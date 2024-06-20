<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.PortalStudio.visualpagelet.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  String tpl_type=PageletGenerator.GetTemplateType(sp.getParameter("name",""));
  int template_type=0; //default
  if (!"".equals(tpl_type)) template_type=Integer.parseInt(tpl_type);
  else template_type=(int)sp.getParameter("template",0);
%>
<!DOCTYPE html>
<html style='height:100%'>
<head>
 <title>Pagelet Editor - Sitepainter Infinity Portalstudio</title>
 <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />
 <script src="../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("PageletLib.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("zdnd_commons.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("zdnd_pagelet_edt.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("pagelet/itemsObj.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("pagelet/properties.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("pagelet/editor.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>" type="text/javascript"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/renderDef.js")%>"></script>
 <link rel="stylesheet" href="../Notimoo.css" type="text/css"/>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <link rel="stylesheet" href="../properties.css" type="text/css">
 <link rel="stylesheet" href="../portalstudio/editor.css" type="text/css">
 <link rel="stylesheet" href="pagelet.css" type="text/css">
 <link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" type="text/css">
 <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
 <link rel="stylesheet" type="text/css" href="../portalstudio/renderDef.css" />
 <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
</head>
<body style="margin:0;background:url(../portalstudio/images/splashEditor.png) no-repeat bottom right fixed;height:100%;" onkeydown="manageItems(event)" onLoad="doload(<%=template_type%>,'<%=JSPLib.ToJSValue(sp.getParameter("name",""))%>',<%=sp.getParameter("frontendport",0)%>);try{parent.setTitle(this);} catch(e){};">
  <div id="FileToolbar" style="z-index:101;position:absolute;left:71px;top:2px;"></div>
  <div id="pgl_tabs"></div>
  <div id="loader" style="display:block;" ></div>
  <div id='container' style="opacity:0;">
    <div id="toolbar" class="droppable horizontal">
      <p><strong>Layout:</strong><span style="font-style:italic"><%=JSPLib.ToHTML(sp.getParameter("name",""))%></span></p>
    </div>
    <div id="gadgets_pane" style="display:">
      <div id="gadgets_panerightbar" class="" title="Toggle resources explorer"><div id="gadgets_openclose"></div></div>
      <div class="gadgetlistTitle" for="formproperties">
        <div class="text">&nbsp;Pagelet properties</div>
        <a  class="gadgets_pane_toggler opened" title="Toggle resources explorer" id="properties-toggler" href="#"></a>
        <div class="list_border"></div>
      </div>
      <div class="gadgets_pane_item">
        <div id="formproperties" style="height:100%;"></div>
      </div>
      <div class="gadgetlistTitle" for="pageletproperties">
        <div class="text">&nbsp;Cell properties</div>
        <a  class="gadgets_pane_toggler opened" title="Toggle resources explorer" id="pagelet-toggler" href="#"></a>
        <div class="list_border"></div>
      </div>
      <div class="gadgets_pane_item">
        <div id="pageletproperties" style="height:100%;"></div>
      </div>
    </div>
    <div class="canvas" id="canvas" >
      <div id="backcanvas">

<script>
  var tool='pagelet';
  var cmdhash = '<%=getCmdHash("pagelet_new", request)%>'
  var pmgr = new Z.PageletManager();
</script>

<%switch (template_type){
  case 1:%>
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INIZIO TABELLA Template 1@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <table  id="pagelet" width='100%' height='600' bgcolor='' align=left border=0  cellspacing=0 cellpadding=0>
  <tr>
  <!--#####################Header1##################################-->
  <td id="header1" height=''   align=center valign='top' class='cell selected' onClick="selectPageletItem(event,'header1')">
  <script type="text/javascript">writeCellTabs('header1');pageletProp[1]=new ZTPageletObjects.columnObj('header1','header1');pmgr.registerDroplet(new Z.Droplet('header1'));</script>
  </td>
  <!--#####################Header2##################################-->
  <td id="header2" height=''   align=center valign='top' class='cell' onClick="selectPageletItem(event,'header2')" colspan=2>
  <script type="text/javascript">writeCellTabs('header2');pageletProp[2]=new ZTPageletObjects.columnObj('header2','header2');pmgr.registerDroplet(new Z.Droplet('header2'));</script>
  </td>
  </tr>
  <tr><td id="col1" width='200' valign=top align=center class='cell' onClick="selectPageletItem(event,'col1')">
  <script type="text/javascript">writeCellTabs('col1');pageletProp[3]=new ZTPageletObjects.columnObj('col1','column1');pmgr.registerDroplet(new Z.Droplet('col1'));</script>
  <!--########################Colonna 1###################################-->
  </td>
  <td  id="col2" width='380' valign=top align=center class='cell' onClick="selectPageletItem(event,'col2')">
  <script type="text/javascript">writeCellTabs('col2');pageletProp[4]=new ZTPageletObjects.columnObj('col2','column2');pmgr.registerDroplet(new Z.Droplet('col2'));</script>
  <!--##########################Colonna 2################################-->
  </td>
  <td  id="col3" width='200' valign=top align=center class='cell' onClick="selectPageletItem(event,'col3')">
  <script type="text/javascript">writeCellTabs('col3');pageletProp[5]=new ZTPageletObjects.columnObj('col3','column3');pmgr.registerDroplet(new Z.Droplet('col3'));</script>
  <!--##########################Colonna 3##############################-->
  </td></tr>
  <tr>
  <!--########################Footer1###################################-->
  <td  id="footer1" align=center valign=top class='cell' onClick="selectPageletItem(event,'footer1')">
  <script type="text/javascript">writeCellTabs('footer1');pageletProp[6]=new ZTPageletObjects.columnObj('footer1','footer1');pmgr.registerDroplet(new Z.Droplet('footer1'));</script>
  </td>
  <!--########################Footer2###################################-->
  <td  id="footer2" align=center valign=top class='cell' onClick="selectPageletItem(event,'footer2')" colspan=2>
  <script type="text/javascript">writeCellTabs('footer2');pageletProp[7]=new ZTPageletObjects.columnObj('footer2','footer2');pmgr.registerDroplet(new Z.Droplet('footer2'));</script>
  </td>
  </tr>
  </table>
<%break;
  case 2:%>
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INIZIO TABELLA Template 2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <table  id="pagelet" width='100%' height='600' bgcolor='' align=left border=0  cellspacing=0 cellpadding=0>
  <tr>
  <!--#####################Header##################################-->
  <td id="header" height='' colspan=4  align=center valign='top' class='cell selected' onClick="selectPageletItem(event,'header')">
  <script type="text/javascript">writeCellTabs('header');pageletProp[1]=new ZTPageletObjects.columnObj('header','header');pmgr.registerDroplet(new Z.Droplet('header'));</script>
  </td>
  </tr>
  <tr>
  <!--########################Colonna 1###################################-->
  <td id="col1" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col1')">
  <script type="text/javascript">writeCellTabs('col1');pageletProp[2]=new ZTPageletObjects.columnObj('col1','column1');pmgr.registerDroplet(new Z.Droplet('col1'));</script>
  </td>
  <td  id="col2" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col2')">
  <script type="text/javascript">writeCellTabs('col2');pageletProp[3]=new ZTPageletObjects.columnObj('col2','column2');pmgr.registerDroplet(new Z.Droplet('col2'));</script>
  <!--##########################Colonna 2################################-->
  </td>
  <td  id="col3" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col3')">
  <script type="text/javascript">writeCellTabs('col3');pageletProp[4]=new ZTPageletObjects.columnObj('col3','column3');pmgr.registerDroplet(new Z.Droplet('col3'));</script>
  <!--##########################Colonna 3##############################-->
  </td>
  <td  id="col4" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col4')">
  <script type="text/javascript">writeCellTabs('col4');pageletProp[5]=new ZTPageletObjects.columnObj('col4','column4');pmgr.registerDroplet(new Z.Droplet('col4'));</script>
  <!--##########################Colonna 4##############################-->
  </td>
  </tr>
  <tr>
  <!--########################Footer###################################-->
  <td  id="footer" colspan=4 align=center valign=top class='cell' onClick="selectPageletItem(event,'footer')">
  <script type="text/javascript">writeCellTabs('footer');pageletProp[6]=new ZTPageletObjects.columnObj('footer','footer');pmgr.registerDroplet(new Z.Droplet('footer'));</script>
  </td>
  </tr>
  </table>
<%break;
  case 3:%>
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INIZIO TABELLA Template 3@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <table  id="pagelet" width='100%' height='600' bgcolor='' align=left border=0  cellspacing=0 cellpadding=0>
  <tr>
  <!--#####################Header##################################-->
  <td id="header" height='' colspan=3  align=center valign='top' class='cell selected' onClick="selectPageletItem(event,'header')">
  <script type="text/javascript">writeCellTabs('header');pageletProp[1]=new ZTPageletObjects.columnObj('header','header');pmgr.registerDroplet(new Z.Droplet('header'));</script>
  </td>
  </tr>
  <tr>
  <!--########################Colonna 1###################################-->
  <td id="col1" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col1')">
  <script type="text/javascript">writeCellTabs('col1');pageletProp[2]=new ZTPageletObjects.columnObj('col1','column1');pmgr.registerDroplet(new Z.Droplet('col1'));</script>
  </td>
  <!--##########################Colonna 2################################-->
  <td  id="col2" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col2')">
  <script type="text/javascript">writeCellTabs('col2',true);pageletProp[3]=new ZTPageletObjects.columnObj('col2','column2');</script>

    <!--##########################Zona Centrale Colonna 2################################-->

    <table width='100%' height='100%'  align=left border=1  cellspacing=0 cellpadding=0 class='cell'>
    <tr>
    <td id="col2_1"    colspan=2  align=center valign='top' class='cell' onClick="selectPageletItem(event,'col2_1')">
    <script type="text/javascript">writeCellTabs('col2_1');pageletProp[4]=new ZTPageletObjects.columnObj('col2_1','column2_1');pmgr.registerDroplet(new Z.Droplet('col2_1'));</script>
    </td>
    <tr>
    <td id="col2_2" align=center valign='top' class='cell' onClick="selectPageletItem(event,'col2_2')">
    <script type="text/javascript">writeCellTabs('col2_2');pageletProp[5]=new ZTPageletObjects.columnObj('col2_2','column2_2');pmgr.registerDroplet(new Z.Droplet('col2_2'));</script>
    </td>
    <td id="col2_3"   align=center valign='top' class='cell' onClick="selectPageletItem(event,'col2_3')">
    <script type="text/javascript">writeCellTabs('col2_3');pageletProp[6]=new ZTPageletObjects.columnObj('col2_3','column2_3');pmgr.registerDroplet(new Z.Droplet('col2_3'));</script>
    </td>
    </tr>
    </table>

  </td>
  <td  id="col3" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col3')">
  <script type="text/javascript">writeCellTabs('col3');pageletProp[7]=new ZTPageletObjects.columnObj('col3','column3');pmgr.registerDroplet(new Z.Droplet('col3'));</script>
  <!--##########################Colonna 3##############################-->
  </td>

  </tr>
  <tr>
  <!--########################Footer###################################-->
  <td  id="footer" colspan=3 align=center valign=top class='cell' onClick="selectPageletItem(event,'footer')">
  <script type="text/javascript">writeCellTabs('footer');pageletProp[8]=new ZTPageletObjects.columnObj('footer','footer');pmgr.registerDroplet(new Z.Droplet('footer'));</script>
  </td>
  </tr>
  </table>
<%break;
  case 4:%>
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INIZIO TABELLA Template 3@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <table  id="pagelet" width='100%' height='600' bgcolor='' align=left border=0  cellspacing=0 cellpadding=0>
  <tr>
  <!--#####################Header##################################-->
  <td id="header" height='' colspan=3  align=center valign='top' class='cell selected' onClick="selectPageletItem(event,'header')">
  <script type="text/javascript">writeCellTabs('header');pageletProp[1]=new ZTPageletObjects.columnObj('header','header');pmgr.registerDroplet(new Z.Droplet('header'));</script>
  </td>
  </tr>
  <tr>
  <!--########################Colonna 1###################################-->
  <td id="col1" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col1')">
  <script type="text/javascript">writeCellTabs('col1');pageletProp[2]=new ZTPageletObjects.columnObj('col1','column1');pmgr.registerDroplet(new Z.Droplet('col1'));</script>
  </td>
  <!--##########################Colonna 2################################-->
  <td  id="col2" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col2')">
  <script type="text/javascript">writeCellTabs('col2',true);pageletProp[3]=new ZTPageletObjects.columnObj('col2','column2');</script>

    <!--##########################Zona Centrale Colonna 2################################-->

    <table width='100%' height='100%'  align=left border=1  cellspacing=0 cellpadding=0 class='cell'>
    <tr>
    <td id="col2_1" align=center valign='top' class='cell' onClick="selectPageletItem(event,'col2_1')">
    <script type="text/javascript">writeCellTabs('col2_1');pageletProp[4]=new ZTPageletObjects.columnObj('col2_1','column2_1');pmgr.registerDroplet(new Z.Droplet('col2_1'));</script>
    </td>
    <td id="col2_2" align=center valign='top' class='cell' onClick="selectPageletItem(event,'col2_2')">
    <script type="text/javascript">writeCellTabs('col2_2');pageletProp[5]=new ZTPageletObjects.columnObj('col2_2','column2_2');pmgr.registerDroplet(new Z.Droplet('col2_2'));</script>
    </td>
    <tr>
    <td id="col2_3" colspan=2  align=center valign='top' class='cell' onClick="selectPageletItem(event,'col2_3')">
    <script type="text/javascript">writeCellTabs('col2_3');pageletProp[6]=new ZTPageletObjects.columnObj('col2_3','column2_3');pmgr.registerDroplet(new Z.Droplet('col2_3'));</script>
    </td>
    </tr>
    </table>

  </td>
  <td  id="col3" width='20%' valign=top align=center class='cell' onClick="selectPageletItem(event,'col3')">
  <script type="text/javascript">writeCellTabs('col3');pageletProp[7]=new ZTPageletObjects.columnObj('col3','column3');pmgr.registerDroplet(new Z.Droplet('col3'));</script>
  <!--##########################Colonna 3##############################-->
  </td>

  </tr>
  <tr>
  <!--########################Footer###################################-->
  <td  id="footer" colspan=3 align=center valign=top class='cell' onClick="selectPageletItem(event,'footer')">
  <script type="text/javascript">writeCellTabs('footer');pageletProp[8]=new ZTPageletObjects.columnObj('footer','footer');pmgr.registerDroplet(new Z.Droplet('footer'));</script>
  </td>
  </tr>
  </table>
  <%break;
  case 5:%>
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INIZIO TABELLA Template 5 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <table  id="pagelet" width='100%' height='600' bgcolor='' align=left border=0  cellspacing=0 cellpadding=0>
  <tr>
  <!--#####################Header##################################-->
  <td id="header" height=''  colspan=2 align=center valign='top' class='cell selected' onClick="selectPageletItem(event,'header')">
  <script type="text/javascript">writeCellTabs('header');pageletProp[1]=new ZTPageletObjects.columnObj('header','header');pmgr.registerDroplet(new Z.Droplet('header'));</script>
  </td></tr>
  <tr>
  <!--########################Colonna 1###############################-->
  <td id="col1" width='200' valign=top align=center class='cell' onClick="selectPageletItem(event,'col1')">
  <script type="text/javascript">writeCellTabs('col1');pageletProp[2]=new ZTPageletObjects.columnObj('col1','column1');pmgr.registerDroplet(new Z.Droplet('col1'));</script>
  </td>

  <!--##########################Colonna 3############################-->
  <td  id="col2" width='200' valign=top  class='cell' onClick="selectPageletItem(event,'col2')">
  <script type="text/javascript">writeCellTabs('col2');pageletProp[3]=new ZTPageletObjects.columnObj('col2','column2');pmgr.registerDroplet(new Z.Droplet('col2'));</script>
  </td></tr>
  <tr>
  <!--########################Footer#################################-->
  <td  id="footer" colspan=2 align=center valign=top class='cell' onClick="selectPageletItem(event,'footer')">
  <script type="text/javascript">writeCellTabs('footer');pageletProp[4]=new ZTPageletObjects.columnObj('footer','footer');pmgr.registerDroplet(new Z.Droplet('footer'));</script>
  </td></tr>
  </table>
<%break;
  default:%>
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INIZIO TABELLA Template 0 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <table  id="pagelet"   bgcolor='' align=left border=0  cellspacing=0 cellpadding=0>
  <tr>
  <!--#####################Header##################################-->
  <td id="header" height=''  colspan=3 align=center valign='top' class='cell selected' onClick="selectPageletItem(event,'header')">
  <script type="text/javascript">writeCellTabs('header');pageletProp[1]=new ZTPageletObjects.columnObj('header','header');pmgr.registerDroplet(new Z.Droplet('header'));</script>
  </td></tr>
  <tr>
  <!--########################Colonna 1###############################-->
  <td id="col1"   valign=top align=center class='cell'  onClick="selectPageletItem(event,'col1')">
  <script type="text/javascript">writeCellTabs('col1');pageletProp[2]=new ZTPageletObjects.columnObj('col1','column1');pmgr.registerDroplet(new Z.Droplet('col1'));</script>
  </td>
  <!--##########################Colonna 2##############################-->
  <td  id="col2"   valign=top align=center class='cell' onClick="selectPageletItem(event,'col2')">
  <script type="text/javascript">writeCellTabs('col2');pageletProp[3]=new ZTPageletObjects.columnObj('col2','column2');pmgr.registerDroplet(new Z.Droplet('col2'));</script>
  </td>
  <!--##########################Colonna 3############################-->
  <td  id="col3"   valign=top align=center class='cell' onClick="selectPageletItem(event,'col3')">
  <script type="text/javascript">writeCellTabs('col3');pageletProp[4]=new ZTPageletObjects.columnObj('col3','column3');pmgr.registerDroplet(new Z.Droplet('col3'));</script>
  </td></tr>
  <tr>
  <!--########################Footer#################################-->
  <td  id="footer" colspan=3 align=center valign=top class='cell' onClick="selectPageletItem(event,'footer')">
  <script type="text/javascript">writeCellTabs('footer');pageletProp[5]=new ZTPageletObjects.columnObj('footer','footer');pmgr.registerDroplet(new Z.Droplet('footer'));</script>
  </td></tr>
  </table>
<%break;
}%>
  </div>
  </div>
  <div id="properties"></div>
</div>
<div id='i_preview_wrapper' style='position:absolute;display:none;z-index:999;background:#454545;'>
  <iframe allowtransparency="true" frameborder="0" toResize='no' id='i_preview' style='position:absolute;top:0;border:0;width:100%;box-sizing:border-box'></iframe>
<div>
<div id='parameters_wrapper' style='position:absolute;display:none;top:80px;left:500px;width:400px;height:600px;background-color:#ECEAEA'>Parameters List</div>
</body>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
