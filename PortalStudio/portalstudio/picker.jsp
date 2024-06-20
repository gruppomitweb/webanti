<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="java.io.File" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%Sitepainter sp=new Sitepainter(request);%>
<html>
<head>
  <title>document.write(GetOpener().title)</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <link rel="stylesheet" href="../filewindow.css" type="text/css">
  <link rel="stylesheet" href="../properties.css" type="text/css">
  <script>
    var type = '<%=JSPLib.ToJSValue(request.getParameter("type"))%>';
    var mode = '<%=JSPLib.ToJSValue(request.getParameter("mode"))%>';
    var pickerObj = GetOpener().pickerObj;

    function insertElement() {
      var valto = GetOpener().Ctrl('<%=JSPLib.ToJSValue(request.getParameter("for"))%>');
      var value = Ctrl("openlist").value;
      if(mode == 'multiple') {
        valto.focus();
        var all_list = (valto.value) ? valto.value.split(",") : [];
        var found = false;
        for(var i = 0; i < all_list.length && !found; i++) {
          if(all_list[i] == value) found = true;
        }
        if(!found) {
          // foglio non è già presente
          all_list.push(value);
          valto.value = all_list.join(",");
        }
      } else {
        valto.focus();
        valto.value = value;
      }
      WindowClose();
    }
  </script>
</head>

<body>
  <div class="titoli" style="width: 100%; height: 20px; position: fixed; top: 0;"><b>
    <script>document.write(pickerObj[0].title);</script>
  </b></div>

  <select id="openlist" size="15" style="width:100%;height:450px;margin-top: 20px;" ondblclick="insertElement()" accesskey="s">
    <script>
      var path = "";
      if(pickerObj.group) { // se la suddivisione in gruppi è attiva
        for(var j = 0; j < pickerObj.length && pickerObj[j].list; j++) {
          if(pickerObj[j].list.length == 0) continue; // se non ci sono elementi non viene mostrato neanche il titolo del gruppo

          document.write("<optgroup label=\""+pickerObj[j].title+"\">");

          for (var i = 0; i < pickerObj[j].list.length; i++) {
            if(pickerObj[j].list[i].toString().search("TITLE-MARKER-") > -1) { // controllo se elemento è titolo
              document.write("</optgroup><optgroup label=\""+pickerObj[j].list[i].replace("TITLE-MARKER-","")+"\">");
            } else if(pickerObj[j].list[i] != "") { // default, inserisco l'elemento con il suo path (se presente)
              var vaule = path ? path + pickerObj[j].list[i] : pickerObj[j].list[i];
              var selector = (pickerObj[j].selector && pickerObj[j].selector[i]) ? " [" + pickerObj[j].selector[i].trim() + "]" : "";
              document.write("<option value='" + vaule + "'>" + pickerObj[j].list[i] + selector + "</option>");
            }
          }
          document.write("</optgroup>");
        }
      } else {
        if(type == "css") {
          path = "styles/"; // path di default per il css
        }
        for (var i = 0; pickerObj[0].list && i < pickerObj[0].list.length; i++) {
          var value = pickerObj[0].list[i];
          if(type == 'layout') {
            value = Strtran(value, ".jsp","");
          }
          document.write("<option value='" + path + value + "'>" + value + "</option>");
        }
      }
    </script>
  </select>

  <div class="footer" style="width: 100%; height: 30px; position: fixed; bottom: 0;">
    <div class="actions" style="margin-top: 3px;">
      <button onclick="insertElement()" id="main_button" accesskey="i" class="bottoni"><u>I</u>nsert</button>&nbsp;
      <button onclick="window.close();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
    </div>
  </div>
</body>
</html>
