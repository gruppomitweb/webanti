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
  <title>Class Editor - Sitepainter Infinity Portalstudio</title>
  <script>
    var b_reload=true;
    var SPWebRootURL='<%=JSPLib.SPWebRootURL(request)%>';
    var skinList ='<%=sp.getSkinList()%>';
    var currentSkin = '<%=sp.getTheme()%>';
    var version=<%=JSPLib.GetPSVersion()%>;
    var cmdhash = '<%=getCmdHash("classeditor", request)%>';
  </script>
  <link type="text/css" rel="stylesheet" href="../properties.css">
  <link type="text/css" rel="stylesheet" href="../classeditor/classeditor.css">
  <link type="text/css" rel="stylesheet" href="../codemirror/lib/codemirror.css">
  <link type="text/css" rel="stylesheet" href="../codemirror/addon/scroll/simplescrollbars.css">
  <link type="text/css" rel="stylesheet" href="../classeditor/fontList.css">
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("classeditor/ClassEditorGenerator.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("classeditor/itemsObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("classeditor/editor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("classeditor/properties.js")%>'></script>
  <script>
    window.onload = function(){
      var name = '<%=JSPLib.ToJSValue(sp.getParameter("name",""))%>';
      var file = '<%=JSPLib.ToJSValue(sp.getParameter("css",""))%>';
      var selector = '<%=JSPLib.ToJSValue(sp.getParameter("selector",""))%>';
      loadClass('event', '<%=sp.getSkin()%>', '<%=JSPLib.ToJSValue(sp.getParameter("type",""))%>', name, selector, file);
    };
  </script>
</head>

<body>
  <div class="flexbox-parent">
    <div class="fill-area flexbox-item-grow">
      <div class="flexbox-item-grow wrapper">
        <aside class="properties-aside">
          <div id="properties" class="child-scrollable"></div>
        </aside>
        <main class="main">
          <header class="header" id="toolbar-top"></header>
          <div class="child-scrollable" id="canvas">
            <div id='container-item'></div>
          </div>
          <footer class="footer" id="toolbar-bottom">
            <ul class="actions">
              <li class="btn btn-confirm" id="save" onclick="saveClass();">Save class</li>
              <li class="btn btn-confirm" id="saveAs" onclick="saveAsLayer();">Save class in...</li>
              <li class="btn" id="close" onclick="window.close();" accesskey="esc">Close</li>
            </ul>
          </footer>
        </main>
        <aside class="class-manager">
          <div class="child-scrollable">
            <header class="class-manager-title">
              <span id="class-manager-title">No class found.</span>
              <nav class="file-actions">
                <i class="mi mi-code file-title-icon" title="Show code preview of current class. (Ctrl + B)" onclick="previewCss()"></i>
                <i class="mi mi-refresh file-title-icon" title="Refresh Class Editor." onclick="refreshClassManager()"></i>
                <i class="mi mi-delete file-title-icon" title="Delete current class." onclick="deleteClass()"></i>
              </nav>
            </header>
            <section id="class-manager"></section>
          </div>
        </aside>
      </div>
    </div>
  </div>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>"></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("codemirror/mode/css/css.js")%>"></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("classeditor/cssbeautify.js")%>" ></script>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
</body>

</html>
