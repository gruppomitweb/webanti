<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@page import="java.util.*" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
%>
<html>
<head>
  <title>Portlet Editor - Sitepainter Infinity Portalstudio</title>
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("properties.css")%>">
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("classeditor/classeditor.css")%>">
  <script>
    var b_reload=true;
    var SPWebRootURL='<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request))%>';
    var skinList ='<%=JSPLib.ToJSValue(sp.getSkinList())%>';
    var currentSkin = '<%=JSPLib.ToJSValue(sp.getTheme())%>';
    var version=<%=JSPLib.GetPSVersion()%>

    var typeObj = '<%=JSPLib.ToJSValue(request.getParameter("type"))%>';
    var modeAction = '<%=JSPLib.ToJSValue(request.getParameter("mode"))%>';
  </script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
  <script async>
    var availableType = ["box", "label", "image", "textbox", "button", "ZoomTile"];
    var editor = getParent();
    function action(type, name, selector, file) {
      if(modeAction == 'all' || modeAction == 'edit') {
        var mar_left = 50, width = ((editor.frameElement && editor.frameElement.clientWidth) ? (editor.frameElement.clientWidth - mar_left*2) : 1124);
        var mar_top = 25, height = ((editor.frameElement && editor.frameElement.clientHeight) ? (editor.frameElement.clientHeight - mar_top*2) : 720);
        var url = "../classeditor/editor.jsp?name=" + encodeURIComponent(name) + "&type=" + type + "&selector=" + encodeURIComponent(selector) + "&css=" + encodeURIComponent(file);
        editor.openSPModalLayer(url, mar_top, mar_left, width, height, true, 1, false, true, editor);
        window.onblur = function(){ WindowClose(); }
      } else if(modeAction == 'insert') {
        var valto = GetOpener().document.getElementById('<%=JSPLib.ToJSValue(request.getParameter("for"))%>');
        valto.value += (Empty(valto.value)) ? name : " " + name;
        valto.focus();
        WindowClose();
      }
    }

    function getParent() {
      var result = GetOpener();
      while(!result.classCssObj && !Empty(result.GetOpener())) {
        result = result.GetOpener();
      }
      return result;
    }

    function generateFileManager() {
      var section, title, actions, content;
      var ctrl_container = Ctrl('class-manager');
          ctrl_container.innerHTML = "",
          count = 0;

      if(modeAction == 'edit') {
        var valto = GetOpener().document.getElementById('<%=JSPLib.ToJSValue(request.getParameter("for"))%>');
        var nameValue = valto.value.split(" ");
      }

      section = new Element('section', { 'class': "file" });
      content = new Element('ul', { 'class': "file-content" });

      for(var i = 0; !Empty(editor.classCssObj) && i < editor.classCssObj.length; i++) {
        // cerco la classe nel portlet
        var toInsert = false,
          class_name = Empty(editor.classCssObj[i].version) ? editor.classCssObj[i].name : editor.classCssObj[i].class_name;
        if(modeAction == 'edit') {
          if(editor.classCssObj[i].type.toLowerCase() == typeObj && nameValue.indexOf(class_name) > -1) {
            toInsert = true;
          } else if(availableType.indexOf(typeObj) == -1 && nameValue.indexOf(class_name) > -1) {
            toInsert = true;
          }
        } else {
          if(editor.classCssObj[i].type.toLowerCase() == typeObj || modeAction == 'all' || availableType.indexOf(typeObj) == -1) {
            toInsert = true;
          }
        }

        if(toInsert) {
          createElement(editor.classCssObj[i], "portlet", count).inject(content);
          count++;
        }
      }
      if(content.childElementCount > 0)
        injectElement("portlet", content, section);
      section.inject(ctrl_container);

      var tmp_list = Empty(editor.formProp.css) ? [] : editor.formProp.css.split(',');
      for (var i = 0; i < tmp_list.length && editor.formProp.css != ""; i++) {
        // cerco la classe nei fogli stile
        var allStyles = restoreClassFromFile(tmp_list[i]);
        section = new Element('section', { 'class': "file" });
        content = new Element('ul', { 'class': "file-content" });
        for(var ii = 0; allStyles && ii < allStyles.length; ii++) {
          var toInsert = false,
            class_name = Empty(allStyles[ii].version) ? allStyles[ii].name : allStyles[ii].class_name;
          if(modeAction == 'edit') {
            if(allStyles[ii].type.toLowerCase() == typeObj && nameValue.indexOf(class_name) > -1) {
              toInsert = true;
            } else if(availableType.indexOf(typeObj) == -1 && nameValue.indexOf(class_name) > -1) {
              toInsert = true;
            }
          } else {
            if(allStyles[ii].type.toLowerCase() == typeObj || modeAction == 'all' || availableType.indexOf(typeObj) == -1) {
              toInsert = true;
            }
          }

          if(toInsert) {
            createElement(allStyles[ii], tmp_list[i], count).inject(content);
            count++;
          }
        }
        if(content.childElementCount > 0)
          injectElement(tmp_list[i], content, section);

        var listSkins = new JSURL("../servlet/JSPReader?type=themes",true).Response().split(",");
        // cerco la classe nei fogli stile delle varie skin
        for(var j = 0; j < listSkins.length - 1; j++) {
          var allStylesThemed = restoreClassFromFile(listSkins[j] + "/" + tmp_list[i]);
          content = new Element('ul', { 'class': "file-content" });
          for(var jj = 0; allStylesThemed && jj < allStylesThemed.length; jj++) {
            var toInsert = false,
              class_name = Empty(allStylesThemed[jj].version) ? allStylesThemed[jj].name : allStylesThemed[jj].class_name;
            if(modeAction == 'edit') {
              if(allStylesThemed[jj].type.toLowerCase() == typeObj && nameValue.indexOf(class_name) > -1) {
                toInsert = true;
              } else if(availableType.indexOf(typeObj) == -1 && nameValue.indexOf(class_name) > -1) {
                toInsert = true;
              }
            } else {
              if(allStylesThemed[jj].type.toLowerCase() == typeObj || modeAction == 'all' || availableType.indexOf(typeObj) == -1) {
                toInsert = true;
              }
            }

            if(toInsert) {
              createElement(allStylesThemed[jj], listSkins[j] + "/" + tmp_list[i], count).inject(content);
              count++;
            }
          }
          if(content.childElementCount > 0)
            injectElement(listSkins[j] + "/" + tmp_list[i], content, section);
        }
        section.inject(ctrl_container);
      }

      if(modeAction == 'insert') {
        // Carico portalstudio.css
        if(editor.formProp.sp_theme=='true' || typeObj=='ZoomTile') {
          section = new Element('section', { 'class': "file" });
          content = new Element('ul', { 'class': "file-content" });
          var classes = eval(new JSURL("../servlet/CssParser?name=portalstudio&item=" + initialCap(typeObj), true).Response());
          if (typeof(classes) != 'undefined') {
            var exit = false;
            for(var i = 0; i < classes.length && !exit; i = i + 2) {
              if(classes[i].toString().search("TITLE-MARKER-") > -1) {
                exit = true;
              } else {
                var html =  "<li id='file-" + count +"' onclick=\"action('', '"+classes[i]+"', '', '')\" >";
                    html += "<span id='link-" + count +"'>." + classes[i] + "</span></li>";
                content.innerHTML += html;
                count++;
              }
            }
          }
          if(content.childElementCount > 0) {
            title = new Element('div', { 'class': "file-title", 'html' : '<span>portalstudio.css</span>' });
            title.inject(section);
            content.inject(section);
          }
        }
        section.inject(ctrl_container);
      }
      Ctrl('class-manager-title').innerHTML = ((count > 0) ? count + " class(es) found in:" : "No class found.");

      [].forEach.call(document.querySelectorAll('.file-content'), function(ul) {
        sortUnorderedList(ul, false);
      })

      if(modeAction == 'edit' && count == 1) {
        Ctrl("link-0").click();
      } else if(modeAction == 'edit' && count == 0) {
        var mar_left = 50, width = ((editor.frameElement && editor.frameElement.clientWidth) ? (editor.frameElement.clientWidth - mar_left*2) : 1124);
        var mar_top = 25, height = ((editor.frameElement && editor.frameElement.clientHeight) ? (editor.frameElement.clientHeight - mar_top*2) : 720);
        var valto = GetOpener().document.getElementById('<%=JSPLib.ToJSValue(request.getParameter("for"))%>').value.split(" ");
        if(valto.length > 1) {
          var portalClasses = eval(new JSURL("../servlet/CssParser?name=portalstudio", true).Response());
          for(var i = 0; i < valto.length; i++) {
            if(portalClasses.indexOf(valto[i]) > -1) {
              valto.splice(i, 1);
            }
          }
        }
        var url = "../classeditor/editor.jsp?name=" + ((valto.length > 0) ? encodeURIComponent(valto[0]) : "") + "&type=" + typeObj;
        if(editor.formProp.type == "Form") {
          url += "&css=portlet";
        }
        editor.openSPModalLayer(url, mar_top, mar_left, width, height, true, 1, false, true, editor);
        window.onblur = function(){ WindowClose(); }
      }
    }

    function createElement(obj, file, count) {
      var class_name = Empty(obj.version) ? obj.name : obj.class_name;
      var html  = (obj.selector) ? obj.selector : "." + class_name;
      var li = new Element('li', { 'id' : "file-" + count });

      new Element('p', {
        'id'     : "link-" + count,
        'html'   : html,
        'events' : {
          'click' : function() {
            action(obj.type, class_name, obj.selector, file);
          }
        }
      }).inject(li);

      new Element('i', {  // aggiungo l'icona per eliminare una classe
        'class':  "mi mi-delete",
        'title':  "Delete selected class.",
        'name':   name,
        'events': {
          'click': function(count) {
            if(confirm("Are you sure that do you want to delete select class?")) {
              externalDeleteClass(class_name, obj.selector, file);
              document.getElementById("file-"+count).style.display = "none";
              // aggiorno il conteggio delle classi nel titolo
              var num = parseInt(Ctrl('class-manager-title').innerHTML) - 1;
              Ctrl('class-manager-title').innerHTML = ((num > 0) ? num + " class(es) found in:" : "No class found.");
            } else return;
          }.bind(this, count)
        }
      }).inject(li);

      return li;
    }

    function injectElement(name, content, section) {
      title = new Element('div', { 'class': "file-title", 'html' : "<span>"+name+"</span>" });
      actions = new Element('nav', { 'class': "file-actions" });

      new Element('i', {  // aggiungo l'icona per la nuova classe
        'class':  "mi mi-add file-title-icon",
        'title':  "Add class in current position.",
        'name': name,
        'events': {
          'click': function () {
            var mar_left = 50, width = ((editor.frameElement && editor.frameElement.clientWidth) ? (editor.frameElement.clientWidth - mar_left*2) : 1124);
            var mar_top = 25, height = ((editor.frameElement && editor.frameElement.clientHeight) ? (editor.frameElement.clientHeight - mar_top*2) : 720);
            editor.openSPModalLayer("../classeditor/editor.jsp?type=" + typeObj + "&css=" + encodeURIComponent(name), mar_top, mar_left, width, height, true, 1, false, true, editor);
            window.onblur = function(){ WindowClose(); }
          }
        }
      }).inject(actions);

      actions.inject(title);
      title.inject(section);
      content.inject(section);
    }

    document.onkeydown = function(e) {
      if (e.keyCode === 27) { // ESC
        WindowClose();
        return false;
      }
    };
    window.onload = generateFileManager;

    function externalDeleteClass(name, selector, file) {
      if(Empty(name) || Empty(selector) || Empty(file)) return;

      var found = false,
        list = (file != "portlet") ? restoreClassFromFile(file) : editor.classCssObj;

      for(var i = 0; list && i < list.length && !found; i++) {
        var class_name = Empty(list[i].version) ? list[i].name : list[i].class_name;
        if(class_name == name && list[i].selector == selector) {
          list.splice(i, 1);
          found = true;
        }
      }

      if(found && file != "portlet") { // rigenero il file se la classe era esterna al file
        deleteClassFromFile(file.replace(".ce.css", ""), name, selector)
      }

      return found;
    }
  </script>
</head>

<body>
  <div class="flexbox-parent">
    <header class="header picker" id="class-manager-title"></header>
    <div class="fill-area flexbox-item-grow picker">
      <section class="flexbox-item-grow class-manager" id="class-manager"></section>
    </div>
  </div>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("classeditor/cssbeautify.js")%>" ></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
  <script defer src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("classeditor/editor.js")%>"></script>
</body>

</html>
