<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  SPJSPBridge.CPResultSet rs = sp.queryDirect(new com.zucchetti.sitepainter.SimpleQuery()
                                .addField("codazi")
                                .addField("desazi")
                                .addTable("cpazi"));
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> values = new ArrayList<String>();
    while(!rs.Eof()){
      names.add("'"+JSPLib.ToJSValue(rs.GetColumnString(2).trim())+"'");
      values.add("'"+JSPLib.ToJSValue(rs.GetColumnString(1).trim())+"'");
      rs.Next();
    }
    rs.Close();
%>
<!DOCTYPE html>
<html>
<head>
<title>Menu Editor - Sitepainter Infinity Portalstudio</title>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>" type="text/javascript"></script>

<script type="text/javascript">
  var anames = <%=names%>;
  var avalues = <%=values%>;
  var companies = "";/*Query per avere le aziende*/
  for( var i = 0; i < anames.length; i++){
    companies += ","+anames[i]+":"+(avalues[i]);
  }
  var tipz = null, mainitem = null; //variabile necessaria per il keydown comune in PortalCommonJS
  var cmdhash = '<%=getCmdHash("Menu", request)%>';
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("menueditor/itemsObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>"></script>
<script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
<script src='../<%=SPPrxycizer.proxycizedPath("menueditor/menueditor.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/mif.tree.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/TabsMT.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/calendar.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>"></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
<link rel="stylesheet" type="text/css" href="../Notimoo.css" />
<link rel="stylesheet" href="../properties.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../portalstudio/TabsMT.css" />
<link rel="stylesheet" type="text/css" href="../portalstudio/editor.css" />
<link rel="stylesheet" type="text/css" href="../portalstudio/calendar.css" />
<link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
<link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" type="text/css">
<link rel="stylesheet" href="menueditor.css" type="text/css">
<link rel="stylesheet" href="../portalstudio/mif-tree.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />

<script type="text/javascript">
  var SPWebRoot = '<%=JSPLib.SPWebRootURL(request)%>';
  function refreshToolTips(){
    tipz.detach('.tipz');
    $$('.tipz').each(function(element,index) {
      element.store('tip:title', ' ');
      element.store('tip:text', element.get('title'));
    });
    tipz.attach('.tipz');
  }
  </script>

</head>
<body onload="doLoad(event,'<%=JSPLib.ToJSValue(sp.getParameter("filename",""))%>',<%=sp.getParameter("offlinemode",false)%>,<%=sp.getParameter("custom",false)%>)">
  <span style="z-index:101" id="mversion"></span>
  <div id="toolbar" class="horizontal droppable_toolbar"></div>
  <div id="gadgets_pane" style="display:block">
    <div id="gadgets_panerightbar" class="" title="Toggle Module Fields Explorer"><div id="gadgets_openclose"></div></div>
    <!--div id="gadgetlistTitle"-->
    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">&nbsp;Menu properties</div>
      <a class="gadgets_pane_toggler" title="Toggle source module properties" id="menuproperties-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='formproperties'style="height:100%;" ></div>
    </div>
     <div id="propertiesTitle" class="gadgetlistTitle" for="properties">
      <div class="text" id="propertiesTitleTxt">&nbsp;Item properties</div>
      <a class="gadgets_pane_toggler" title="Toggle source module properties" id="menuitem-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='properties'style="height:100%;" ></div>
    </div>
    <!-- Div Search -->
    <div id="searchpropertiesTitle" class="gadgetlistTitle" for="searchproperties">
      <div class="text">&nbsp;Search</div>
      <a id="search-toggler" class="gadgets_pane_toggler opened" title="Toggle search" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div id="searchnav" class="gadgets_pane_item">
      <div id="searchproperties" style="height:100%;" class="pseditorprop"></div>
      <div id="findList"></div>
    </div>
  </div>
  <div id="loading" style="display:block"></div>
  <div id="navmenu_tabcontainer">
    <div class="tab_wrapper" id="custom_tab_wrapper">
    </div>
    <div style="overflow-x:hidden;width:1%;float:left;">&nbsp;</div>
    <div class="tab_wrapper">
      <ul id='menu_list_source' style="width:1000px;">
      </ul>
    </div>
  </div>
  <div id="backcanvas" style="display:none">
    <div style="float:left;clear:both;height:0px;line-height:5px;min-height:0px;width:100%"></div>
    <div id="custom_frame" name="custom_frame" class="tree_frame" ></div>
    <div style="overflow-x:hidden;width:1%;float:left;">&nbsp;</div>
    <div id="source_frame" name="project_frame" class="tree_frame" ></div>
    <img src="../portalstudio/images/backbottom.png" alt="bottom" class="imgbottom" />
  </div>
  <input id="lostfocus" style="height:0px;width:0px;opacity:0;position:absolute;top:0;"></input>
</body>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
