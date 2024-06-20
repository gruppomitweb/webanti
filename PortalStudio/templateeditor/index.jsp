<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@page import="com.zucchetti.PortalStudio.*" %>
<%Sitepainter sp=new Sitepainter(request);%>

<html>
<head>
  <title>Layout Editor</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <link type="text/css" rel="stylesheet" href="editor.css">
  <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />

  <script>
    var isCMS = true;
    var SPWebRoot = '<%=JSPLib.SPWebRootURL(request)%>';
    var pageObg, pageid;
    var Contents='<%=JSPLib.ToJSValue(sp.getParameter("contents",""))%>';
    var Urls='<%=JSPLib.ToJSValue(sp.getParameter("urls",""))%>';
    var Groups='<%=JSPLib.ToJSValue(sp.getParameter("groups",""))%>';
    var Parameters='';
    var Contents_type='<%=JSPLib.ToJSValue(sp.getParameter("contents_type",""))%>';
    var urls=Urls.split(',');
    var parameters=new Array();
    var Links=new Array();// Array di oggetti contenente i nomi delle pagine linkate e i parametri di cui hanno bisogno

    for (var i = 0; i < urls.length; i++) {
      if (urls[i].indexOf("?") > -1) {
        urls[i] = Strtran(urls[i], '#', ',');
        parameters[i] = urls[i].substring(urls[i].indexOf("?") + 1);
        urls[i] = Strtran(urls[i], "?" + parameters[i], "");
      } else
        parameters[i] = "";
    }
    Parameters = parameters.join(',');
    Urls = urls.join(',');

    function Load() {
      pageid = '<%=JSPLib.ToJSValue(sp.getParameter("pageid",""))%>';
      if (GetOpener() && GetOpener().ZTPlanObjects && pageid != '')
        pageObg = GetOpener().itemsHTML[GetOpener().index];
      var links_tmp = pageObg.links.split(',');
      // Carico la struttura dei links + parametri della pagina corrente
      for (var i = 0; i < links_tmp.length; i++) {
        for (var ii = 0; ii < GetOpener().itemsHTML.length; ii++) {
          if (GetOpener().itemsHTML[ii].name == links_tmp[i]) {
            Links.push({ 'name': links_tmp[i], 'page_params': GetOpener().itemsHTML[ii].page_parameters });
            break;
          }
        }
      }
      if (!EmptyString(Contents)) {
        var contents = Contents.split(',');
        var urls = Urls.split(',');
        var groups = Groups.split(',');
        var parameters = Parameters.split(',');
        var contents_type = Contents_type.split(',');
        templateframe.Load(contents, urls, groups, parameters, contents_type);
      }
      var tpl = $('templateframe');
      var content = document.body;

      $('loader').setStyle('display', 'none');

      new Element('link', {
        'href': SPWebRoot + '/templateeditor/frame.css',
        'rel': 'stylesheet',
        'type': 'text/css'
      }).inject(frames['templateframe'].document.body);

      $('edit_container').setStyle('display', 'block');
    }

    function Save(keepOpen) {
      var contents = templateframe.getStructure();
      var groupName, resName, resUrl, resParameters, resType;
      var RequestParamList = [];
      if (pageObg != null) {
        contents = eval('(' + contents + ')');
        pageObg.contents = '';
        pageObg.urls = '';
        pageObg.groups = '';
        pageObg.conditions = '';
        pageObg.contents_type = '';
        var n = 0;
        for (var i in contents) {
          groupName = contents[i].id;
          for (var ii = 0; ii < contents[i].childs.length; ii++) {
            if(typeOf(contents[i].childs[ii].url)!='null' && typeOf(contents[i].childs[ii].url)!='undefined'){
              // CUSTOM CMS
              resName = contents[i].childs[ii].name;
              resUrl = contents[i].childs[ii].url;
              resParameters = contents[i].childs[ii].parameters;
              resType = contents[i].childs[ii].type;

              if (resUrl.indexOf('_portlet.jsp') > -1) {
                var url = new JSURL("../servlet/JSPReader?action=paramsrequest&type=portlet&name=" + Strtran(resUrl, '_portlet.jsp', ''), true);
                url = url.Response();
                var url_tmp = url.split(',');
                for (var iii = 0; iii < url_tmp.length; iii++) {
                  if (!Empty(url_tmp[iii]) && LibJavascript.Array.indexOf(RequestParamList, url_tmp[iii]) == -1)
                    RequestParamList.push(url_tmp[iii]);
                }
              }

              if (n > 0) {
                pageObg.contents += "," + resName;
                pageObg.contents_type += "," + resType;
                pageObg.urls += "," + resUrl;
                pageObg.conditions += ";";
                pageObg.groups += "," + groupName;
              } else {
                pageObg.contents = resName;
                pageObg.contents_type = resType;
                pageObg.urls = resUrl;
                pageObg.groups = groupName;
              }

              if (!Empty(resParameters)) {
                pageObg.urls += "?" + resParameters;
              }

              n++;
            }
          }
        }
        pageObg.page_parameters = RequestParamList.join(',');
        GetOpener().writeHTML();
        GetOpener().m_bUpdated = true;
        if (!keepOpen) {
          window.close();
          if (!templateframe.checkGroupsEncode()) {
            GetOpener().save('true');
          }
        }
      }
    }
    var activeTab = "edit";

    function setIframeSrc() {
      if (isCMS) {
        var dnsFound = window.location.host.split(':')[0];
        var host = window.location.protocol + "//" + dnsFound + (!Empty(window.location.port) ? ":" + window.location.port : "") + Strtran(window.location.pathname, "/templateeditor/index.jsp", "") + '/cms/' + GetOpener().itemsHTML[GetOpener().index].alias;
        $("preview_iframe").src = host + '.html';
      } else {
        $("preview_iframe").src = "../jsp/" + GetOpener().itemsHTML[GetOpener().index].name + ".jsp";
      }
      $("loader").style.display = "none";
    }

    function Preview() {
      if (activeTab != "preview") {
        $('preview_template').addClass('active');
        $('edit_template').removeClass('active');
        $('properties-aside').setStyle('display', 'none');

        if (!templateframe.checkGroupsEncode() && confirm("Le risorse sono state modificate. Procedere al salvataggio del plan?")) {
          activeTab = "preview";

          $('preview_container').setStyle('display', 'block');
          $('edit_container').setStyle('display', 'none');
          $("loader").style.display = "block";
          templateframe.setGroupsEncode();
          Save(true);
          GetOpener().save('true');
          setTimeout(setIframeSrc, 2000);
        } else {
          activeTab = "preview";
          $('preview_container').setStyle('display', 'block');
          $('edit_container').setStyle('display', 'none');
          setIframeSrc();
        }
      }
    }

    function Edit() {
      if (activeTab != "edit") {
        activeTab = "edit";
        $('edit_template').addClass('active');
        $('preview_template').removeClass('active');
        $('properties-aside').setStyle('display', 'block');
        $('preview_container').setStyle('display', 'none');
        $('edit_container').setStyle('display', 'block');
      }
    }
  </script>
</head>
<body>
    <div id="loader"></div>

<div class="flexbox-parent">

    <header class="header" id="toolbar-top">
      <strong>Layout:</strong>
      <span style="font-style:italic"> <%=JSPLib.ToHTML(sp.getParameter("tpl",""))%></span>
    </header>

    <div class="fill-area flexbox-item-grow">
      <div class="flexbox-item-grow wrapper">
        <aside class="properties-aside" id="properties-aside">

          <div id="gadgets_pane" class="child-scrollable">
            <div class="gadgetstitle">Resources explorer</div>
            <div id="gadgetslist"></div>
          </div>

        </aside>

        <main class="main">

          <div class="child-scrollable" id="canvas">

            <div class="iframecontainer" id="edit_container" style="display:none;">
              <iframe id="templateframe" name="templateframe" src=<%=JSPLib.ToHTMLValue(JSPLib.SPWebRootURL(request)+"/jsp/"+sp.getParameter("tpl","")+"?editMode=true")%> class="frame-container"></iframe>
            </div>
            <div class="iframecontainer" id="preview_container" style="display:none;">
              <iframe id="preview_iframe" name="preview_iframe" src="" class="frame-container"></iframe>
            </div>
          </div>

        </main>


      </div>
    </div>
    <footer class="footer" id="toolbar-bottom">
      <ul class="actions">
        <li class="btn btn-tools active" id="edit_template" onclick="Edit();">Edit Mode</li>
        <li class="btn btn-tools" id="preview_template" onclick="Preview();">Preview Mode</li>
        <li class="btn btn-confirm" id="save_template" onclick="Save();">Save</li>
        <li class="btn" id="close_template" onclick="if(confirm('Vuoi chiudere?')) WindowClose();" accesskey="esc">Close</li>
      </ul>
    </footer>
</div>

</body>
</html>
