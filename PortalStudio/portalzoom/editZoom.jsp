<!DOCTYPE html>
<html>
<head>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.JSPLib" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%Sitepainter sp=Sitepainter.getSitepainter(request);
Library.SetMimeType(response,"text/html");
String zoomFields=sp.getParameter("zoomFields","");
String rowLayer=sp.getParameter("rowLayer","");
String zoomName=sp.getParameter("zoomName","");
String zoomUID=sp.getParameter("zoomUID","");
String filters=sp.getParameter("filters","");
String tilesPosition=sp.getParameter("totalsPosition","");
String tilesStarting=sp.getParameter("totalsStarting","");
String caption=sp.getParameter("caption","");
String versionName=sp.getParameter("versionName","");
String vqrName=sp.getParameter("vqrName","");
String tableName=sp.getParameter("tableName","");
String viewMode=sp.getParameter("viewMode","");
String hideFilter=sp.getParameter("hideFilter","");
String user=sp.getParameter("user","");
double currentUser=sp.getUserCode();
String group=sp.getParameter("group","");
String custom=sp.getParameter("custom","");
if (sp.CanCustomizeZoom() || sp.CanConfigureZoom()){
%>
<title>Smart Zoom</title>
<link type='text/css' rel='STYLESHEET' href='../<%=sp.getSkin()%>/portalstudio.css'>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("SPReportMask.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>'></script>
<style>
body{
  width:auto;
  padding:0;
  margin:0;
  min-width:1000px;
}

ul{
  list-style-type:none;
}
#zoomFields, #zoomTiles, #filters, #reports, #orderByList{
  padding:0;
  margin-top:2px;
  margin-bottom:40px;
  display:table-cell;
}
.verticalLine{
  height:20px;
  border-left:1px solid #a6a6a6;
  width:4px;
  display:inline-block;
  margin-left:7px;
}
.check{
  display:inline-block;
  height:16px;
  width:32px;
  cursor:pointer;
}
.nameFields{
  display:inline-block;
  position:relative;
  bottom:4px;
}

.nameFields[draggable=true] {
  cursor:move;
}

.title{
  font-weight:bold;
  margin-left:20px;
  padding-right:10px;
}

.verticalSpace{
  height:20px;
}

.margin{
  padding-top:3px;
  padding-bottom:3px;
  margin-left:20px;
}

.hidden{
  background:url("../portalstudio/images/btn_check_hidden.png")
}

.inExtGrid{
  background:url("../portalstudio/images/btn_check_extended.png");
}

.base{
  background:url("../portalstudio/images/btn_check_base.png")
}

.columnLayer{
  padding-bottom:0;
  margin-left:0;
}

.notMove{
  cursor:auto;
}

.space{
  height:60px;
}

.hiddenFilter{
  display:none;
}

.filterType, .orderByType{
  position:absolute;
  left:190px;
  width:90px;
}

.orderByType{
  width:100px;
}

.filterName{
  width:130px;
  margin-left:10px;
}

.filterValue{
  width:120px;
  position:absolute;
  left:340px;
}

#columnTitle{
  margin-top:20px;
  margin-bottom:10px;
  font-weight:bold;
}

#filter_div, #report_div{
  width:800px;
  display:inline-block;
}

.imgTiles{
  width:80px;
  height:60px;
}

.divTiles{
  display:inline-block;
}

.radio{
  width:80px;
  margin:0;
  padding:0;
}

#filterTitle, #reportTitle, #tileTitle, #orderByTitle{
  margin-bottom:10px;
  margin-top:10px;
  font-weight:bold;
}

.filterNew, .reportNew, .orderByNew{
  cursor:pointer;
  float:right;
}

.addContainer{
  width:500px;
  border-bottom:1px solid;
  height:24px;
  left:320px;
  font-weight:normal;
  position:relative;
}

#filters, #reports, #orderByList{
  width:520px;
  left:320px;
  position:relative;
}

.filterDelete,.deleteReports, .orderByDelete{
  display:inline-block;
  cursor:pointer;
  position:absolute;
  left:470px;
}

.editReports{
  position:absolute;
  left:450px;
  cursor:pointer;
}

.titleColumn{
  width:500px;
  left:340px;
  position:relative;
  padding-bottom:10px;
  margin-bottom:10px;
  border-bottom:1px solid;
  font-weight:bold;
  opacity:0.6;
  display:inline-block;
  text-transform: uppercase;
}

#filterColumn,#report,#orderByColumn{
  padding-left:10px;
}

#filterOperator, #orderByType{
  position:absolute;
  left:190px;
}

#filterValue{
  position:absolute;
  left:340px;
}

#version{
  /* position:absolute; */
  position:fixed;
  padding.left:20px;
  top:60px;
  width:100%;
  z-index:2;
}

#toolbar{
  background-color:#ffffff;
  z-index:2;
}

.columns,.rowlayers{
  display:inline-block;
  vertical-align:top;

  border-top:0px solid;
  border-bottom:0px solid;
  min-height:120px;
}

.columns{
  border-right:1px solid #BFC2C6;
}

.rowlayers{
  margin-left:10px;
  border-left:1px solid #BFC2C6;
}

.columns .columnLayer .listColumnLayer, .rowlayers .columnLayer .listColumnLayer{
  border:none;
  margin:0;
  padding:0;
}

.columns .listColumnLayer, .rowlayers .listColumnLayer{
  padding-top:10px;
  border-top:0px solid;
  padding-right:10px;
}

.columns .listColumnLayer{
  padding-top:4px;
  padding-right:10px;
  padding-left:22px;
}

.columnLayer,.cl{
  font-size:90% !important;
  text-align:right;
  margin-bottom:6px;
}
.listColumnLayer{
  padding:0;
  padding-bottom:10px;
}

.droppable.columns{
  height:35px;
  padding:0;
  box-sizing:border-box;
  position:absolute;
  border:none;
  min-height:35px;
  max-height:35px;
}

.droppable span{
  background-color:#43AFC3;
  margin-right:4px;
  margin-left:4px;
  width:2px;
  height:35px;
  display:inline-block;
}

.droppableExtraTitle{
  height:20px;
  padding:0;
  box-sizing:border-box;
  position:absolute;
  border:none;
}

.droppableExtraTitle span{
  background-color:#43AFC3;
  margin-right:4px;
  margin-left:4px;
  width:2px;
  height:20px;
  display:inline-block;
}

.droppable.cl{
  position:absolute;
  box-sizing:border-box;
  margin:0;
  height:8px;
  font-size:1px !important;
}

.droppable.cl span{
  background-color:#43AFC3;
  margin-right:0px;
  margin-left:0px;
  margin-top:3px;
  margin-bottom:3px;
  width:100%;
  height:2px;
  display:inline-block;
}

#columns{
  padding:5px 10px 5px 0;
  border:1px dotted #BFC2C6;
  margin-top:5px;
}

.lt, .gt{
  padding-right:4px;
  padding-left:4px;
  cursor:pointer;
  font-family:icons8_win10;
  vertical-align:middle;
}

.gt::after{
  content:"\F145";
}

.lt::after{
  content:"\F144";
}

.columnLayer .lt,.columnLayer .gt{
  display:none;
}

.first .lt{
  visibility:hidden;
}

.last .gt{
  visibility:hidden;
}

.rowLayerImg{
  display:inline-block;

  text-align:right;
  float:right;
}

.smart_rowLayer_title, .smart_column_title{
  display:table-cell;
  vertical-align:middle;
  height:40px;
}

.smart_rowLayer_title{
  padding-left:10px;
  padding-right:10px;
  background:#284678 !important;
  color:white !important;
}

.smart_column_title{
  cursor:move;
}

.smart_column_title.over {
  border-bottom: 2px solid black;
}

.columnLayer .smart_column_title{
  height:auto;
}

.clone{
  border:1px solid #BFC2C6;
  background:#284678;
  height:20px;
  padding:5px;
  z-index:2;
  color:#fff;
}

.smartEditor.version{
  background:#fff;
}

.extraTitle{
  display:inline-block;
  padding-right:5px;
  margin-left:5px;
  padding-left:5px;
}

#extraTitle{
  padding:0;
  margin-bottom:0px;
  display:inline-block;
}

.extraTitle .smart_column_title{
  height:20px;
}

.hiddenField{
  display:none;
}

.visibileField{
  display:inline-block;
}

.extraTitle.first{
  margin-left:0;
  padding-left:0;
}

#deleteExtraTitle{
  font-family:icons8_win10;
  font-size:25px;
  color:#43AFC3;
  display:none;
  margin-left:20px;
}

#deleteExtraTitle::after{
  content:"\EB3E";
}

#noExtraTitle{
  opacity:0.6;
}

#dropNoExtraTitle{
  height:15px;
  background-color:#43AFC3;
  display:none;
  width:100%;
  opacity:0.6;
}

.notValid .label{
  color:red;
  font-weight:bold;
}

</style>
</head>
<body onLoad='DoLoad()' style='min-height:300px;' onresize='Resize()'>
<div id='editZoom'>
  <div id='toolbar'><%out.flush();
   if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp",true))
   if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp",true))
   Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp",false);%></div>

  <div id='version' class='version smartEditor'>
    <%out.flush();
   Library.includeResource(request,response,"/jsp-system/SPSelectVersion_portlet.jsp?versionName="+versionName+"&userCode="+user+
   "&groupCode="+group+"&custom="+custom,false);%>
  </div>
  <div id='content' style='margin-left:0px; padding-top:90px;'>
    <div>
      <div style='display:inline-block; width:340px; vertical-align:top;'> <!-- lista colonne -->
        <div class='label title' id='columnTitle'> <%=sp.translate("MSG_GRID")%> </div>
        <!--div style='background-image:url(./images/grid.png); margin-left:20px;'  id='gridImage' class='imgTiles'></div-->
        <div style='padding-left:20px;'>
          <div class='label' style='margin-top:15px; font-size:70%;'><%=sp.translate("MSG_BASE")%></div>
          <div class='verticalLine'></div>
          <div class='label'  style='display:inline-block; font-size:70%;'><%=sp.translate("MSG_EXTENDED")%></div>
        </div>
        <ul id='zoomFields'>
        </ul>
        <div class='verticalSpace' id='rowLayerSpace'></div>
      </div>
      <div style='display:inline-block; padding-top:60px;'> <!-- config griglia position:absolute; left:22%; top:145px;-->
        <div class='label'><%=sp.translate("RPT_PREVIEW")%></div>
        <span class='label' id='noExtraTitle'><%=sp.translate("MSG_NO_EXTRA_TITLE")%></span>
        <span class='label' id='dropNoExtraTitle'></span>
        <ul id='extraTitle'>
        </ul>
        <span id='deleteExtraTitle'></span>
        <ul id='columns'>
        </ul>
      </div>
    </div>
    <%if (sp.CanConfigureZoom()){%>
    <span class='label' style='margin-left:20px'>* <%=sp.translate("MSG_FIELD_NOT_IN_ZOOM")%></span>
    <%}%>
      <div id='tiles'>
      <div class='label title' id='tileTitle'> <%=sp.translate("MSG_TILES")%> </div>
      <div style='width:340px; display:inline-block; vertical-align:top;'>
        <div style='padding-left:20px;' id='tileBaseExt'>
          <div class='label' style='margin-top:15px; font-size:70%;'><%=sp.translate("MSG_BASE")%></div>
          <div class='verticalLine'></div>
          <div class='label'  style='display:inline-block; font-size:70%;'><%=sp.translate("MSG_EXTENDED")%></div>
        </div>
        <ul id='zoomTiles'>
        </ul>
      </div>
      <div style='display:inline-block;' id='tileContainer'>
        <div class='label' style='padding-bottom:10px;'><%=sp.translate("MSG_PLACEMENT")%></div>
        <div class='divTiles'>
          <div style='background-image:url(./images/topLeft.png)' class='imgTiles'></div>
          <input type='radio' name='tilesRadio' value='topLeft' id='topLeft' class='radio'>
        </div>
        <div class='divTiles'>
          <div style='background-image:url(./images/topRight.png)' class='imgTiles'></div>
          <input type='radio' name='tilesRadio' value='topRight' id='topRight' class='radio'>
        </div>
        <div class='divTiles'>
          <div style='background-image:url(./images/bottomLeft.png)'  class='imgTiles'></div>
          <input type='radio' name='tilesRadio' value='bottomLeft' id='bottomLeft' class='radio'>
        </div>
        <div class='divTiles'>
          <div style='background-image:url(./images/bottomRight.png)'  class='imgTiles'></div>
          <input type='radio' name='tilesRadio' value='bottomRight' id='bottomRight' class='radio'>
        </div>
        <div class='divTiles'>
          <div style='background-image:url(./images/gridTiles.png)'  class='imgTiles' id='imgGrid'></div>
          <input type='radio' name='tilesRadio' value='grid' id='grid' class='radio'>
        </div>
        <div class='divTiles'>
          <div style='background-image:url(./images/grid.png)'  class='imgTiles' id='imgHiddenTiles'></div>
          <input type='radio' name='tilesRadio' value='hiddenTiles' id='hiddenTiles' class='radio'>
        </div>
      </div>

    </div>
    <div class='space'></div>
    <div>
      <div id='orderBy_div'>
        <div class='label title'  id='orderByTitle'>  </div>
        <div class='titleColumn'>
          <span class='label' id='orderByColumn'> <%=sp.translate("MSG_COLUMN")%> </span>
          <span class='label' id='orderByType'> <%=sp.translate("ADMIN_TYPE")%> </span>
        </div>
        <ul id='orderByList'>
        </ul>
      </div>
    </div>
    <div class='space'></div>
    <div>
      <div id='filter_div'>
        <div class='label title'  id='filterTitle'>  </div>
        <div class='titleColumn'>
          <span class='label' id='filterColumn'> <%=sp.translate("MSG_COLUMN")%> </span>
          <span class='label' id='filterOperator'> <%=sp.translate("MSG_OPERATOR")%> </span>
          <span class='label' id='filterValue'> <%=sp.translate("MSG_VALUE")%> </span>
        </div>
        <ul id='filters'>
        </ul>
      </div>
    </div>
    <div class='space'></div>
    <div>
      <div id='report_div'>
        <div class='label title'  id='reportTitle'>  </div>
        <div class='titleColumn'>
          <span class='label' id='report'> <%=sp.translate("MSG_RPT")%> </span>
        </div>
        <ul id='reports'>
        </ul>
      </div>
    </div>
  </div>
</div>
<script>
var zoomName, zoomUID, nFilter=0,nOrderBy=0,reports,vqrName,tableName,queryFields={},listColumnsById={},listColumnsByName={};
vqrName='<%=JSPLib.ToJSValue(vqrName)%>'
tableName='<%=JSPLib.ToJSValue(tableName)%>'
function Resize(){
  document.getElementById('content').style.height=
  (document.documentElement.clientHeight-document.getElementById('toolbar').offsetHeight-document.getElementById('version').offsetHeight-20)+'px';
}
function DoLoad(){
  var caption='<%=JSPLib.ToJSValue(caption)%>';
  var versionName='<%=JSPLib.ToJSValue(versionName)%>';
  var zoomFields=JSON.parse('<%=JSPLib.ToJSValue(zoomFields)%>');
  var rowLayer=JSON.parse('<%=JSPLib.ToJSValue(rowLayer)%>');
  var filters=JSON.parse('<%=JSPLib.ToJSValue(filters)%>');
  var tilesPosition='<%=JSPLib.ToJSValue(tilesPosition)%>';
  var tilesStarting='<%=JSPLib.ToJSValue(tilesStarting)%>';
  var viewMode='<%=JSPLib.ToJSValue(viewMode)%>';
  var  hideFilter= <%=JSPLib.ToJSValue(hideFilter)%>;
  zoomName='<%=JSPLib.ToJSValue(zoomName)%>';
  zoomUID='<%=JSPLib.ToJSValue(zoomUID)%>';

  if (tilesPosition=='bottom-tile'){
    if (tilesStarting=='left') {
      tilesPosition='bottomLeft';
    }
    else {
      tilesPosition='bottomRight';
    }
  }
  else if (tilesPosition=='top-tile'){
    if (tilesStarting=='left') {
      tilesPosition='topLeft';
    }
    else {
      tilesPosition='topRight';
    }
  }
  else if (tilesPosition=='hidden'){
    tilesPosition='hiddenTiles';
  }
  else {
    tilesPosition='grid';
  }
  document.getElementById(tilesPosition).checked=true;

  var inner="",innerGrid="",innerExtraTitle="",columnsExtraTitle=[];
  /* PREVIEW GRID */
  if (zoomFields.length>0 || rowLayer.length>0){
    for (var i=0;i<zoomFields.length;i++){
      // listFieldsForFilter+="<option value='"+Lower(zoomFields[i].field)+"'>"+zoomFields[i].title+"</option>";
      var description=zoomFields[i].title2
      innerGrid+="<li class='columns label "+(zoomFields[i].hidden ? "hiddenField":"visibleField")+"' id="+ToHTMLValue(zoomFields[i].id)+" name="+ToHTMLValue(zoomFields[i].field)+"><span class='smart_column_title' draggable='true'><span class='lt' onclick='moveLeft(this)'></span>"+ToHTML(description)+"<span class='gt' onclick='moveRight(this)'></span></span>";
      innerGrid+="<ul class='listColumnLayer'>";
      if (zoomFields[i].show_extra_title) {
        columnsExtraTitle.push(zoomFields[i]);
      }
      listColumnsById[zoomFields[i].id]={
          name:Lower(zoomFields[i].field),
          description:description,
          inExtGrid:zoomFields[i].inExtGrid,
          hidden:zoomFields[i].hidden,
          isHTML:zoomFields[i].field.indexOf('html:')==0,
          type:zoomFields[i].type
      }
      if (!listColumnsByName[Lower(zoomFields[i].field)]) {
        listColumnsByName[Lower(zoomFields[i].field)]=[];
      }
      listColumnsByName[Lower(zoomFields[i].field)].push(zoomFields[i].id);

      for (var j=0; j<zoomFields[i].Layer.length;j++){
        // listFieldsForFilter+="<option value='"+Lower(zoomFields[i].Layer[j].field)+"'>"+zoomFields[i].Layer[j].title+"</option>";
        description=zoomFields[i].Layer[j].title2;
        innerGrid+="<li class='columnLayer label "+(zoomFields[i].Layer[j].hidden ? "hiddenField":"visibleField")+"' id="+ToHTMLValue(zoomFields[i].id)+" name="+ToHTMLValue(zoomFields[i].Layer[j].field)+"> <span class='smart_column_title' draggable='true'><span class='lt' onclick='moveLeft(this)'></span>"+ToHTML(description)+"<span class='gt' onclick='moveRight(this)'></span></span><ul class='listColumnLayer'></ul></li>";
        if (zoomFields[i].Layer[j].show_extra_title) {
          columnsExtraTitle.push(zoomFields[i].Layer[j]);
        }
        listColumnsById[zoomFields[i].Layer[j].id]={
          name:Lower(zoomFields[i].Layer[j].field),
          description:description,
          inExtGrid:zoomFields[i].Layer[j].inExtGrid,
          hidden:zoomFields[i].Layer[j].hidden,
          isHTML:zoomFields[i].Layer[j].field.indexOf('html:')==0,
          type:zoomFields[i].Layer[j].type
        }
        if (!listColumnsByName[Lower(zoomFields[i].Layer[j].field)]) {
          listColumnsByName[Lower(zoomFields[i].Layer[j].field)]=[];
        }
        listColumnsByName[Lower(zoomFields[i].Layer[j].field)].push(zoomFields[i].Layer[j].id);
      }
      innerGrid+="</ul></li>";
    }
  }
  else {
    document.getElementById("columnTitle").style.display='none';
  }

  for (var i=0;i<rowLayer.length;i++){
    listColumnsById[rowLayer[i].id]={
      name:Lower(rowLayer[i].field),
      description:rowLayer[i].title2,
      inExtGrid:rowLayer[i].inExtGrid,
      hidden:rowLayer[i].hidden,
      type:rowLayer[i].type
    }
    if (!listColumnsByName[Lower(rowLayer[i].field)]) {
      listColumnsByName[Lower(rowLayer[i].field)]=[];
    }
    listColumnsByName[Lower(rowLayer[i].field)].push(rowLayer[i].id);
  }


  /* LISTA COLONNE */

  if (<%=sp.CanConfigureZoom()%>){
    var url = new JSURL("../servlet/SPVZMProxy?action=vqr_fields&table="+URLenc(tableName)+"&vqr="+URLenc(vqrName),true);
    var listQueryFields=JSON.parse(url.Response());
    var desc='';
    for (var i=0; i<listQueryFields.length; i++){
      desc='';
      var state='hidden',id=LibJavascript.AlfaKeyGen(10);
      var fieldName=Lower(listQueryFields[i].alias)
      if (fieldName in listColumnsByName){
        for (var j=0; j<listColumnsByName[fieldName].length; j++){
          state='hidden';
          id=listColumnsByName[fieldName][j];
          desc=listColumnsById[id].description;
          if (listColumnsById[id].inExtGrid) {
            state='inExtGrid';
          }
          else if (!listColumnsById[id].hidden) {
            state='base';
          }
          inner+="<li class='label margin' id='col_"+ToHTMLValue(id)+"'><div><div class='check "+state+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+id)+"></div> <div class='nameFields' draggable='true'>"+ToHTML(desc)+"</div></div></li>";
        }
      }
      else {
        desc=listQueryFields[i].desc_trad || listQueryFields[i].desc;
        queryFields[Lower(listQueryFields[i].alias)]={
          description:desc
        }
        innerGrid+="<li class='columns label hiddenField' id="+ToHTMLValue(id)+" name="+ToHTMLValue(listQueryFields[i].alias)+"><span class='smart_column_title' draggable='true'><span class='lt' onclick='moveLeft(this)'></span>"+ToHTML(desc)+"<span class='gt' onclick='moveRight(this)'></span></span>";
        innerGrid+="<ul class='listColumnLayer'></ul></li>";
        listColumnsById[id]={
            name:listQueryFields[i].alias,
            description:desc,
            type:listQueryFields[i].type
        }
        inner+="<li class='label margin' id="+ToHTMLValue("col_"+id)+"><div><div class='check "+state+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+id)+"></div> <div class='nameFields' draggable='true'>"+ToHTML(desc)+" *</div></div></li>";
        if (!listColumnsByName[Lower(listQueryFields[i].alias)]) {
          listColumnsByName[Lower(listQueryFields[i].alias)]=[];
        }
        listColumnsByName[Lower(listQueryFields[i].alias)].push(id);
      }
    }
    for (var i=0;i<zoomFields.length;i++){
      if (zoomFields[i].field.indexOf('html:')==0){
        inner+="<li class='label "+(i<zoomFields.length-1?"margin":"margin")+"' id="+ToHTMLValue("col_"+zoomFields[i].id)+"><div><div class='check "+(zoomFields[i].hidden ? "hidden" : zoomFields[i].inExtGrid==true ? "inExtGrid" : "base")+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+zoomFields[i].id)+"></div> <div class='nameFields' >"+ToHTML(zoomFields[i].title2)+"</div></div></li>";
        for (var j=0; j<zoomFields[i].Layer.length;j++){
          if (zoomFields[i].Layer[j].field.indexOf('html:')==0) {
            inner+="<li class='label "+(j<zoomFields[i].Layer.length-1?"margin":"margin")+"' id="+ToHTMLValue("col_"+zoomFields[i].Layer[j].id)+"><div><div class='check "+(zoomFields[i].Layer[j].hidden ? "hidden" : zoomFields[i].Layer[j].inExtGrid==true ? "inExtGrid" : "base")+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+zoomFields[i].Layer[j].id)+"></div> <div class='nameFields' >"+ToHTML(zoomFields[i].Layer[j].title2)+"</div></div></li>";
          }
        }
      }
    }
  }
  else {
    if (zoomFields.length>0 || rowLayer.length>0){
      for (var i=0;i<zoomFields.length;i++){
        inner+="<li class='label "+(i<zoomFields.length-1?"margin":"margin")+"' id="+ToHTMLValue("col_"+zoomFields[i].id)+"><div><div class='check "+(zoomFields[i].hidden ? "hidden" : zoomFields[i].inExtGrid==true ? "inExtGrid" : "base")+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+zoomFields[i].id)+"></div> <div class='nameFields' >"+ToHTML(zoomFields[i].title2)+"</div></div>";
        inner+="</li>";
        for (var j=0; j<zoomFields[i].Layer.length;j++){
          inner+="<li class='label "+(j<zoomFields[i].Layer.length-1?"margin":"margin")+"' id="+ToHTMLValue("col_"+zoomFields[i].Layer[j].id)+"><div><div class='check "+(zoomFields[i].Layer[j].hidden ? "hidden" : zoomFields[i].Layer[j].inExtGrid==true ? "inExtGrid" : "base")+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+zoomFields[i].Layer[j].id)+"></div> <div class='nameFields' >"+ToHTML(zoomFields[i].Layer[j].title2)+"</div></div></li>";
        }
      }
      if (rowLayer.length>0){
        for (var i=0;i<rowLayer.length;i++){
          inner+="<li class='label "+(i<rowLayer.length-1?"margin":"margin")+"' id="+ToHTMLValue("col_"+rowLayer[i].id)+"><div><div class='check "+(rowLayer[i].hidden ? "hidden" : rowLayer[i].inExtGrid==true ? "inExtGrid" : "base")+"' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+rowLayer[i].id)+"></div> <div class='nameFields' >"+ToHTML(rowLayer[i].title2)+"</div></div></li>";
        }
      }
    }
  }

  innerGrid+="<li class='label rowlayers'><span class='label smart_rowLayer_title'>&nbsp;ROW LAYER</span>";
  innerGrid+="<ul class='listColumnLayer' id='rowLayer'>";
  if (rowLayer.length>0){
    for (var i=0;i<rowLayer.length;i++){
      // listFieldsForFilter+="<option value='"+Lower(rowLayer[i].field)+"'>"+rowLayer[i].title+"</option>";
      if (rowLayer[i].show_extra_title) {
        columnsExtraTitle.push(rowLayer[i]);
      }
      var description=rowLayer[i].title2
      innerGrid+="<li class='columnLayer label "+(rowLayer[i].hidden ? "hiddenField":"visibleField")+"' id="+ToHTMLValue(rowLayer[i].id)+" name="+ToHTMLValue(rowLayer[i].field)+"> <span class='smart_column_title' draggable='true'><span class='lt' onclick='moveLeft(this)'></span>"+ToHTML(description)+"<span class='gt' onclick='moveRight(this)'></span></span><ul class='listColumnLayer'></ul></li>";
      listColumnsById[rowLayer[i].id]={
          name:Lower(rowLayer[i].field),
          description:description,
          type:rowLayer[i].type
      }
    }
  }
  innerGrid+="</ul></li>";

  document.getElementById("columns").innerHTML=innerGrid;
  document.getElementById("zoomFields").innerHTML=inner;

  columnsExtraTitle.sort(function(c1,c2){//ordino l'array temp in base all'idx
    var res=c1.extracolidx-c2.extracolidx;
    return res;
  });
  for (var i=0; i<columnsExtraTitle.length; i++){
    innerExtraTitle+="<li class='extraTitle label "+(i==0?'first ':'')+(i==columnsExtraTitle.length-1?'last':'')+"' id="+ToHTMLValue(columnsExtraTitle[i].id+"_extra")+"><span class='smart_column_title' draggable='true'><span class='lt' onclick='moveLeft(this)'></span>"+ToHTML(columnsExtraTitle[i].title)+"<span class='gt' onclick='moveRight(this)'></span></span>";
    // imposto l'attributo draggable del nameField a false
    var nameF=document.querySelectorAll('.nameFields');
    for(var j=0; j<nameF.length; j++) {
      if(columnsExtraTitle[i].field==nameF[j].innerText) {
        nameF[j].setAttribute('draggable', false);
      }
    }
  }
  if (!Empty(innerExtraTitle)){
    document.getElementById("extraTitle").innerHTML=innerExtraTitle;
    document.getElementById('noExtraTitle').style.display='none';
    // document.getElementById('dropNoExtraTitle').style.display='none';
  }
  else {
      document.getElementById('extraTitle').style.display='none';
  }

  adjustTitleWidth();
  adjustMoveArrows(false);
  updateListColumnsWidth();

  // DRAG COLONNE
  LibJavascript.Events.addEvent(document.getElementById('columns'),'mousedown',moverMouseDown);
  var listFields=document.querySelectorAll('.nameFields');
  for (var i=0;i<listFields.length;i++)
    LibJavascript.Events.addEvent(listFields[i],'mousedown',moveZoomFields);
  LibJavascript.Events.addEvent(document.getElementById('extraTitle'),'mousedown',moveExtraTitle);

  function createDroppables(el){
    var colonne=document.querySelectorAll('.columns.visibleField');
    var height=document.getElementById('columns').offsetHeight;
    var droppable;
    var parentCol;
    let droppables = [];
    for (var i=0; i<colonne.length; i++){
      if (colonne[i]!=el){
        // colonna a sx
        if (colonne[i-1]!=el){
          droppable=document.createElement('li');
          droppables.push(droppable);
          droppable.className='droppable columns';
          parentCol=colonne[i].parentNode;
          parentCol.insertBefore(droppable, colonne[i]);
          droppable.innerHTML='<span> </span>';
          droppable.style.top=colonne[i].offsetTop+'px';
          droppable.style.left=(colonne[i].offsetLeft-5)+'px';
        }
        var cl=colonne[i].getElementsByClassName('columnLayer');
        if (cl[0]!=el){
          // primo column layer
          droppable=document.createElement('li');
          droppables.push(droppable);
          droppable.className='droppable cl';
          if (cl.length>0){
            parentCol=cl[0].parentNode;
            parentCol.insertBefore(droppable, cl[0]);
          }
          else {
            parentCol=colonne[i].getElementsByClassName('listColumnLayer')[0];
            parentCol.appendChild(droppable);
          }
          droppable.innerHTML='<span> </span>';
          droppable.style.top=(colonne[i].getElementsByClassName('listColumnLayer')[0].offsetTop-6)+'px';
          droppable.style.left=(colonne[i].offsetLeft)+'px';
          droppable.style.width=(colonne[i].offsetWidth)+'px';
        }
        if (cl.length>0){
          // sotto agli altri column layer
          for (var j=0; j<cl.length; j++){
            if (cl[j].parentNode.parentNode!=el && cl[j]!=el && cl[j+1]!=el){
              var droppable=document.createElement('li');
              droppable.className='droppable cl';
              parentCol=cl[j].parentNode;
              parentCol.insertBefore(droppable, cl[j].nextSibling);
              droppable.innerHTML='<span> </span>';
              droppable.style.top=(cl[j].offsetTop+cl[j].offsetHeight)+'px';
              droppable.style.left=(cl[j].parentNode.offsetLeft)+'px';
              droppable.style.width=(cl[j].parentNode.offsetWidth)+'px';
              droppables.push(droppable);
            }
          }
        }
      }
    }
    //ultima colonna
    if (colonne[colonne.length-1]!=el){
      droppable=document.createElement('li');
      droppable.className='droppable columns';
      droppables.push(droppable);
      parentCol=colonne[colonne.length-1].parentNode;
      var lastChild=document.querySelector('.label.rowlayers');
      parentCol.insertBefore(droppable, lastChild);
      droppable.innerHTML='<span> </span>';
      droppable.style.top=colonne[colonne.length-1].offsetTop+'px';
      droppable.style.left=(colonne[colonne.length-1].offsetLeft+colonne[colonne.length-1].offsetWidth-6)+'px';
    }
    // row layer
    var layers=document.querySelectorAll('.rowlayers .columnLayer');
    // primo row layer
    if (layers[0]!=el){
      droppable=document.createElement('li');
      droppables.push(droppable);
      droppable.className='droppable cl';
      var rl=document.getElementById('rowLayer');
      if (layers.length>0) {
        var parLayer=layers[0].parentNode;
        parLayer.insertBefore(droppable, layers[0]);
      }
      else {
        rl.appendChild(droppable);
      }
      droppable.innerHTML='<span> </span>';
      droppable.style.top=(rl.offsetTop-5)+'px';
      droppable.style.left=(rl.parentNode.offsetLeft)+'px';
      droppable.style.width=(rl.parentNode.offsetWidth)+'px';
    }
    // sotto gli altri row layer
    if (layers.length>0){
      for (var j=0; j<layers.length; j++){
        if (layers[j].parentNode.parentNode!=el && layers[j]!=el && layers[j+1]!=el){
          var droppable=document.createElement('li');
          droppables.push(droppable);
          droppable.className='droppable cl';
          var parLayer=layers[j].parentNode;
          parLayer.insertBefore(droppable, layers[j].nextSibling);
          // droppable.inject(layers[j],'after');
          droppable.innerHTML='<span> </span>';
          droppable.style.top=(layers[j].offsetTop+layers[j].offsetHeight)+'px';
          droppable.style.left=(layers[j].parentNode.offsetLeft)+'px';
          droppable.style.width=(layers[j].parentNode.offsetWidth)+'px';
        }
      }
    }
    return droppables;
  }

  function moverMouseDown(evt){
    var title=evt.srcElement || evt.target;
    var element=title.parentNode;
    if (evt.button!=0 || title.parentNode.classList.contains("rowlayers") || title.classList.contains("lt")  || title.classList.contains("gt")) {
      return;
    }
    var parentTitle=title.parentNode;
    title.addEventListener('dragstart', handleDragStart);
    title.addEventListener('dragend', handleDragEnd);
    // title.addEventListener('drop', handleDrop);
    var draggedEl;

    function handleDragStart(evt) {
      draggedEl=evt.target;
      let droppables = createDroppables(element);
      droppables.forEach( e => {
        e.addEventListener('dragover', handleDragOver)
        e.addEventListener('dragenter', handleDragEnter);
        e.addEventListener('dragleave', handleDragLeave);
        e.addEventListener('drop', handleDrop);
      });
      evt.dataTransfer.effectAllowed = 'move';
    }

    function handleDragEnd(evt) {
      destroyElements(document.querySelectorAll('.droppable'));
    }

    function handleDragOver(evt) {
      evt.preventDefault();
    }

    function handleDragEnter(e) {
      var droppable=e.target;
      droppable.style.backgroundColor='#43AFC3';
    }

    function handleDragLeave(e) {
      var droppable=e.target;
      droppable.style.backgroundColor='';
    }

    function handleDrop(evt) {
      // dragged e' l'elemento che sto spostando
      // evt.target l'elemento in cui sono posizionato
      evt.stopPropagation();
      var drop=evt.target;
      if (Lower(drop.tagName) == 'span') {
        drop = drop.parentNode;
      }
      if (drop){
        var orderCol=document.getElementById('orderBy_lbl_'+Lower(element.getAttribute('name')));
        if (drop.classList.contains('columns')){
          element.classList.add('columns');
          element.classList.remove('columnLayer');
          if (orderCol){
            orderCol.parentNode.parentNode.parentNode.classList.remove('notValid');
            orderCol.parentNode.parentNode.parentNode.classList.add('orderValid');
          }
        }
        else{ // divento un layer
          element.classList.add('columnLayer');
          element.classList.remove('columns');
          if (orderCol){// && !document.getElementById(element.id+'_extra')){
              orderCol.parentNode.parentNode.parentNode.classList.add('notValid');
              orderCol.parentNode.parentNode.parentNode.classList.remove('orderValid');
          }
          element.firstElementChild.style.width='';
        }
        var parDrop=drop.parentNode;
        draggedEl=parDrop.insertBefore(element, drop);
      }
      if (draggedEl){
        draggedEl.style.position='';
        draggedEl.style.top='';
        draggedEl.style.left='';
        draggedEl.classList.remove('first');
        draggedEl.classList.remove('last');
        adjustTitleWidth();
        var parent = document.getElementById('columns');
        var children = parent.childNodes;
        if (children.length>2){
          children[0].classList.add('first');
          children[1].classList.remove('first');
          children[children.length-2].classList.add('last');
          children[children.length-3].classList.remove('last');
        }
        else{
          children[0].classList.add('first');
          children[0].classList.add('last');
        }
      }
      adjustMoveArrows(true);
      updateListColumnsWidth();
    }
  }

  function createExtraTitleDroppables(el,showTrash){
    var titles=document.querySelectorAll('.extraTitle');
    var parTitles=document.getElementById('extraTitle');
    var height=parTitles.offsetHeight;
    var droppable;
    var dropBar=document.getElementById('dropNoExtraTitle');
    var droppables=[];
    if (titles.length>0){ // l'ul ha figli
      for (var i=0; i<titles.length; i++){
        if (titles[i]!=el && titles[i-1]!=el){
          droppable=document.createElement('li');
          droppable.className='droppableExtraTitle';
          droppables.push(droppable);
          parTitles.insertBefore(droppable, titles[i]);
          droppable.innerHTML='<span> </span>';
          droppable.style.top=titles[i].offsetTop+'px';
          droppable.style.left=(titles[i].offsetLeft-6)+'px';
        }
      }
      if (titles[titles.length-1]!=el){
        droppable=document.createElement('li');
        droppable.className='droppableExtraTitle';
        droppables.push(droppable);
        parTitles.insertBefore(droppable, titles[titles.length]);
        // droppable.inject(titles[titles.length-1],'after');
        droppable.innerHTML='<span> </span>';
        droppable.style.top=titles[titles.length-1].offsetTop+'px';
        droppable.style.left=(titles[titles.length-1].offsetLeft+titles[titles.length-1].offsetWidth)+'px';
      }
      if (showTrash) {
        var trash=document.getElementById('deleteExtraTitle');
        droppables.push(trash);
        trash.style.display='inline-block';
      }
    }
    else { // l'ul non ha figli
        droppables.push(parTitles);
        droppables.push(dropBar);
        document.getElementById('noExtraTitle').style.display='none';
        dropBar.style.display='block';
        document.getElementById('dropNoExtraTitle').style.opacity='0.6';
    }
    return droppables;
  }

  function moveExtraTitle(evt){
    var title=evt.srcElement || evt.target;
    var element=title.parentNode;
    if (evt.button!=0 || title.classList.contains("lt")  || title.classList.contains("gt")) {
      return;
    }
    var parentTitle=title.parentNode;

    title.addEventListener('dragstart', handleDragStart);
    title.addEventListener('dragend', handleDragEnd);
    var draggedEl;

    let droppables = createExtraTitleDroppables(element,true);
    droppables.forEach( e => {
      e.addEventListener('dragover', handleDragOver)
      e.addEventListener('dragenter', handleDragEnter);
      e.addEventListener('dragleave', handleDragLeave);
      e.addEventListener('drop', handleDrop);
    });

    function handleDragStart(evt) {
      draggedEl=evt.target;
      evt.dataTransfer.effectAllowed = 'move';
    }

    function handleDragEnd(evt) {
      destroyElements(document.querySelectorAll('.droppableExtraTitle'));
      if(droppables) {
        droppables.forEach( e => {
          e.removeEventListener('dragover', handleDragOver)
          e.removeEventListener('dragenter', handleDragEnter);
          e.removeEventListener('dragleave', handleDragLeave);
          e.removeEventListener('drop', handleDrop);
        });
      }
      document.getElementById('deleteExtraTitle').style.display='none';
      document.getElementById('deleteExtraTitle').style.fontSize='25px';
      element.style.display='';
    }

    function handleDragOver(evt) {
      evt.preventDefault();
    }

    function handleDragEnter(e) {
      var droppable=e.target;
      if (droppable.id!='deleteExtraTitle') {
        droppable.style.backgroundColor='#43AFC3';
      }
      else {
        droppable.style.fontSize='30px';
      }
    }

    function handleDragLeave(e) {
      var droppable=e.target;
      if (droppable.id!='deleteExtraTitle') {
        droppable.style.backgroundColor='';
      }
      else {
        droppable.style.fontSize='25px';
      }
    }

    function handleDrop(evt) {
      // dragged e' l'elemento che sto spostando
      // evt.target l'elemento in cui sono posizionato
      evt.stopPropagation(); // stops the browser from redirecting.
      var drop=evt.target;
      if (drop){
        if (drop.id=='deleteExtraTitle') {
          // prima di eliminarlo rimetto draggabile il campo che ho eliminato
          var zoomF=document.getElementById('zoomFields');
          var nameF= zoomF.querySelectorAll('.nameFields');
          for(let i=0;i<nameF.length;i++) {
            if(nameF[i].innerText==draggedEl.innerText) {
              nameF[i].setAttribute('draggable', true);
            }
          }
          deleteElement(element);
        }
        else {
          var parDrop=drop.parentNode;
          draggedEl=parDrop.insertBefore(element, drop);
        }
        updateListColumnsWidth(true);
      }
      var children=document.querySelectorAll('.extraTitle');
      if (children.length>1){
        children[0].classList.add('first');
        children[1].classList.remove('first');
        children[children.length-1].classList.add('last');
        children[children.length-2].classList.remove('last');
      }
      else if (children.length==1){
        children[0].classList.add('first');
        children[0].classList.add('last');
      }
      else {
        document.getElementById('noExtraTitle').style.display='';
        document.getElementById('extraTitle').style.display='none';
      }
    }
  }

  function moveZoomFields(evt){
    var title=evt.srcElement || evt.target;
    var element=title;
    var id=Strtran(element.parentNode.parentNode.id,"col_","");
    if (document.getElementById(id+'_extra')){
      return;
    }

    title.addEventListener('dragstart', handleDragStart);
    title.addEventListener('dragend', handleDragEnd);
    var draggedEl;
    let droppables = createExtraTitleDroppables(element);
    droppables.forEach( e => {
      e.addEventListener('dragover', handleDragOver)
      e.addEventListener('dragenter', handleDragEnter);
      e.addEventListener('dragleave', handleDragLeave);
      e.addEventListener('drop', handleDrop);
    });

    function handleDragStart(evt) {
      draggedEl=evt.target;
    }

    function handleDragEnd(evt) {
      destroyElements(document.querySelectorAll('.droppableExtraTitle'));
      document.getElementById('dropNoExtraTitle').style.display='none';
      if(droppables) {
        droppables.forEach( e => {
          e.removeEventListener('dragover', handleDragOver)
          e.removeEventListener('dragenter', handleDragEnter);
          e.removeEventListener('dragleave', handleDragLeave);
          e.removeEventListener('drop', handleDrop);
        });
      }
      if(evt.dataTransfer.dropEffect!='none') {
        draggedEl.setAttribute('draggable', false);
      }
      var children=document.getElementById('extraTitle').children;
      if (children.length>0){
        document.getElementById('extraTitle').style.display='inline-block';
        document.getElementById('noExtraTitle').style.display='none';
      }
      else {
        document.getElementById('extraTitle').style.display='none';
        document.getElementById('noExtraTitle').style.display='inline-block';
      }
    }

    function handleDragOver(evt) {
      evt.preventDefault();
    }

    function handleDragEnter(evt) {
      evt.dataTransfer.effectAllowed = 'copy';
      var droppable=evt.target;
      if (droppable.id=='dropNoExtraTitle') {
        droppable.style.opacity='1';
      }
      else {
        droppable.style.backgroundColor='#43AFC3';
      }
    }

    function handleDragLeave(evt) {
      var droppable=evt.target;
      if (droppable.id=='dropNoExtraTitle') {
        droppable.style.opacity='0.6';
      }
      else {
        droppable.style.backgroundColor='';
      }
    }

    function handleDrop(evt) {
      // dragged e' l'elemento che sto spostando
      // evt.target l'elemento in cui sono posizionato
      evt.stopPropagation(); // stops the browser from redirecting.
      var drop=evt.target;
      if (drop){
        // trasformo l'elemento che sto copiando in uno smart_column_title
        var el=document.createElement('li');
        el.className='extraTitle label';
        var id=Strtran(element.parentNode.parentNode.id,"col_","");
        el.id=id+"_extra";
        el.innerHTML="<span class='smart_column_title' draggable='true'><span class='lt' onclick='moveLeft(this)'></span>"+ToHTML(draggedEl.innerText)+"<span class='gt' onclick='moveRight(this)'></span></span>";
        if (drop.id=='dropNoExtraTitle'){
          var extraT=document.getElementById('extraTitle');
          extraT.appendChild(el);
          extraT.style.display='inline-block';
        }
        else {
          var parDrop=drop.parentNode;
          el=parDrop.insertBefore(el, drop);
        }
        var name=document.getElementById(id)?document.getElementById(id).getAttribute('name'):'';
        if (!Empty(name)){
          var orderCol=document.getElementById('orderBy_lbl_'+Lower(name));
          if (orderCol){
            orderCol.parentNode.parentNode.parentNode.classList.remove('notValid');
            orderCol.parentNode.parentNode.parentNode.classList.add('orderValid');
          }
        }

        updateListColumnsWidth(true);
      }
      var children=document.querySelectorAll('.extraTitle.label');
      document.getElementById('dropNoExtraTitle').style.display='none';
      if (children.length==0) {
        document.getElementById('noExtraTitle').style.display='inline-block';
      }
      if (el){
        if (children.length>1){
          children[0].classList.add('first');
          children[1].classList.remove('first');
          children[children.length-1].classList.add('last');
          children[children.length-2].classList.remove('last');
        }
        else if (children.length==1){
          children[0].classList.add('first');
          children[0].classList.add('last');
        }
      }
    }
  }

  /* TILES */
  if (viewMode=='chart'){
    document.getElementById('tiles').style.display='none';
  }
  else {
    inner="";
    var nTiles=0;
    for (var i=0;i<zoomFields.length;i++){
      if (!Empty(zoomFields[i].tile)){
        nTiles++;
      }
    }
    if (nTiles>0){
      for (var i=0;i<zoomFields.length;i++){
        if (!Empty(zoomFields[i].tile)){
          nTiles--;
          inner+="<li class='label "+(nTiles>0?"margin":"margin")+"' id="+ToHTMLValue(zoomFields[i].id+"_tile")+"><div><div class='check "+(zoomFields[i].tileVisibility=='hidden' ? "hidden" : zoomFields[i].tileVisibility=='extended' ? "inExtGrid" : "base")+"' class='check' onclick='changeVisibility(this)' id="+ToHTMLValue("check_"+zoomFields[i].id+"_tile")+"></div> <div class='nameFields notMove'>"+ToHTML(zoomFields[i].tile)+"</div></div></li>"
        }
      }
      document.getElementById("zoomTiles").innerHTML=inner;
    }
    else {
      document.getElementById('tiles').style.display='none';
    }
    inner="";

    if (viewMode=='card'){
      document.getElementById("grid").style.display='none';
      document.getElementById("imgGrid").style.display='none';
    }
  }


  /* ORDERBY */
  document.getElementById('orderByTitle').innerHTML="<%=sp.translate("MSG_ORDER")%> <div class='addContainer'>"+getImg(SPTheme.smartEditorAddOrderByImage,'/visualweb/images/grid_new.png','orderByNew','addOrderBy()')+ "</div>"

  var listOrderBy=[]
  for (var i=0;i<zoomFields.length;i++){
    if (!Empty(zoomFields[i].orderbystatus)){
      listOrderBy[zoomFields[i].orderbyidx]=zoomFields[i];
    }
  }
  for (var i=0;i<listOrderBy.length;i++){
    if (listOrderBy[i]){
      addOrderBy(listOrderBy[i]);
    }
  }

  /* FILTER */
  if (!hideFilter){
    document.getElementById('filterTitle').innerHTML="<%=sp.translate("MSG_FILTERS")%> <div class='addContainer'>"+getImg(SPTheme.smartEditorAddFilterImage,'/visualweb/images/grid_filters_add.png','filterNew','addFilter()')+ "</div>"
    if (filters.length>0){
      for (var i=0;i<filters.length;i++){
        addFilter(filters[i]);
      }
    }
  }
  else {
    document.getElementById('filter_div').parentNode.style.display='none';
  }

  /* REPORT */
  reports = GetOpener()[zoomUID].getReports();
  inner = "";

  var enableEditReport = <%=sp.CanEditZoomPrint()%>,
  enableNewReport = <%=sp.CanAddZoomPrint()%>;

  inner = "<%=sp.translate("RPT_TITLE")%> <div class='addContainer'>";
  if (enableNewReport)
    inner += getImg(SPTheme.smartEditorAddReportImage, '/visualweb/images/grid_new.png', 'reportNew', 'addReport()');
  inner += "</div>";
  document.getElementById('reportTitle').innerHTML = inner;
  inner = "";

  var editReportHtml = getImg(SPTheme.smartEditorEditReportImage, '/visualweb/images/grid_edit.png', 'editReports', 'editReport(this)'),
  deleteReportHtml = getImg(SPTheme.smartEditorDeleteReportImage, '/visualweb/images/grid_filter_delete.png', 'deleteReports', 'deleteReport(this)');
  for (el in reports) {
    inner += ("<li class='label margin' id=" + ToHTMLValue(el) + "><div style='display:inline-block;'><div class='nameFields notMove' style='width:300px; margin-left:10px;'>" + ToHTML(el));
    if (enableEditReport)
      inner += editReportHtml;
    inner += (deleteReportHtml + "</div></div></li>");
  }
  document.getElementById("reports").innerHTML = inner;

  /* TOOLBAR */
  editZoom=new function(){
    ZtVWeb.newForm(this,'editZoom','editZoom',100,30,'portlet',false);
    if(this.toolbar=ZtVWeb.getPortletInc('toolbar')){
      this.toolbar.setContainer(this,'toolbar')
      this.toolbar_ctrl=new ZtVWeb.PortletCtrl(this,'toolbar','toolbar',0,0,'100%',1,'');
    }
    this.toolbar_ctrl.Ctrl.style.position='fixed';
    this.toolbar_ctrl.Ctrl.style.width='100%';
    this.toolbar_ctrl.Ctrl.style.height=this.toolbar.Ctrl.offsetHeight+'px';
    this.toolbar.title.Value(caption+" <span class='SPPortalZoom_currentversion'>"+versionName+"</span>" )
    this.toolbar.AddButton(GetStyleVariable("smartEditorApplyImage", '<%=sp.getThemedImage("../images/custom_toolbar/ok.png",pageContext.getServletContext())%>'), "javascript:applyZoom()", '', '<%=sp.translate("RPT_APPLY")%>', '<%=sp.translate("RPT_APPLY")%>');
    this.toolbar.AddButton(GetStyleVariable("smartEditorSaveImage", '<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>'), "javascript:saveZoom()", '', '<%=sp.translate("MSG_SAVE_CONFIG")%>', '<%=sp.translate("MSG_SAVE_CONFIG")%>');

    this.toolbar.AddButton(GetStyleVariable("smartEditorDiscardImage", '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>'), "javascript:closeWindow()", '', '<%=sp.translate("MSG_CLOSE_ONEXIT")%>', '<%=sp.translate("MSG_CLOSE_ONEXIT")%>');
    <%if ((!Library.Empty(user) && Integer.parseInt(user,10)>0) || (sp.CanConfigureZoom() && ((zoomName.indexOf("__")!=-1) || "true".equals(custom)))){%>
      this.toolbar.AddMenuButton(GetStyleVariable("smartEditorDeleteImage", '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>'), "javascript:deleteZoom()", '', '<%=sp.translate("MSG_DELETE_VERSION")%>', '<%=sp.translate("MSG_DELETE_VERSION")%>');
    <%}%>
    this.toolbar.AddMenuButton(GetStyleVariable("controlPanelHelp", '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>'), "javascript:Help()", '', '<%=sp.translate("ADMIN_HELP_TITLE")%>', '<%=sp.translate("ADMIN_HELP_TITLE")%>');
    this.toolbar.RearrangeAll();
    if (this.version=ZtVWeb.getPortletInc('version')){
      this.version.setContainer(this,'version')
      this.version_ctrl=new ZtVWeb.PortletCtrl(this,'version','version',0,1,'100%',0,'');
      this.version_ctrl.stretchHeight=true;
    }
  }
}

function adjustTitleWidth(){
  var children = document.getElementById('columns').children;
  for (var i=0; i<children.length; i++){
    children[i].firstElementChild.style.width='';
    children[i].firstElementChild.style.width=children[i].offsetWidth+'px';
  }
}

function moveLeft(el){
  var field=el.parentNode.parentNode;
  var parent=field.parentNode;
  var prev=field.previousElementSibling;
  if (prev){
    parent.insertBefore(field, prev);
    if (field.classList.contains('last')){
      field.classList.remove('last');
      prev.classList.add('last');
    }
    if (prev.classList.contains('first')){
      prev.classList.remove('first');
      field.classList.add('first');
    }
  }
}

function moveRight(el){
  var field=el.parentNode.parentNode;
  var parent=field.parentNode;
  var next=field.nextElementSibling;
  if (next){
    parent.insertBefore(field, next.nextSibling);
    if (field.classList.contains('first')){
      field.classList.remove('first');
      next.classList.add('first');
    }
    if (next.classList.contains('last')){
      next.classList.remove('last');
      field.classList.add('last');
    }
  }
}

function getImg(themeVar,url,cssClass,onclick){
  var img="";
  var newFilter=SPTheme.grid_img_filter_addnew;
  if (Empty(themeVar)) {
    img="<img onclick='"+onclick+"' class='"+cssClass+"' src='"+ZtVWeb.SPWebRootURL+url+"'>";
  }
  else if (typeof(themeVar)=="string" && themeVar.indexOf('{')==-1) {
    img="<img onclick='"+onclick+"' class='"+cssClass+"' src='"+themeVar+"'>";
  }
  else {
    if( typeof(themeVar)== 'string') {
      themeVar = JSON.parse(themeVar);
    }
    var font=themeVar.FontName;
    ZtVWeb.RequireFont(font);
    img="<span onclick='"+onclick+"' class='"+cssClass+"' style='font-family:"+font+"; font-size:"+parseInt(themeVar.Size)+"px; "+(themeVar.FontWeight ? "font-weight:"+themeVar.FontWeight+"; ":"")+ "'>"+String.fromCharCode(themeVar.Char)+"</span>";
  }
  return img;
}

function editReport(el){
  var fields=GetOpener()[zoomUID].getFieldsForPrint();
  var rep=el.parentNode.parentNode.parentNode.id;

  /* EG: aggiungo questa chiamata perche' il comportamento tra il 'nuovo' da print portlet e il 'nuovo' da versione
    dev'essere coerente */
  var strc = GetOpener()[zoomUID].Grid.GetPrintData();
  var url = "../smartreport/smartreport.jsp";
  url += "?id="+reports[rep].value;
  url += "&custom="+reports[rep].custom;
  url += "&datasource="+vqrName;
  url += "&fields="+URLenc(URLenc(fields));
  url += "&configName="+zoomName+"."+tableName;
  url += "&gridID=" + strc.gridName;
  url += "&portletID=" + strc.openerID;

  windowOpenForeground(url)
}

function deleteReport(el){
  var rep=el.parentNode.parentNode.parentNode.id;
  if (confirm("Are you sure you want to delete "+rep+" report?")){
    var deleteResponse = new JSURL("../servlet/JSPDelete?name=" + URLenc(reports[rep].value) + ".svrp&custom=" + URLenc(reports[rep].custom));
    deleteResponse = deleteResponse.Response();
    if (deleteResponse=='deleted'){
      deleteElement(el.parentNode.parentNode.parentNode);
      reports[rep]=null;
    }
  }
}

function addReport(){
  var fields = GetOpener()[zoomUID].getFieldsForPrint(MGetQueryFields(vqrName, true));

  /* EG: aggiungo questa chiamata perche' il comportamento tra il 'nuovo' da print portlet e il 'nuovo' da versione
    dev'essere coerente */
  var strc = GetOpener()[zoomUID].Grid.GetPrintData();
  var url = "../smartreport/smartreport.jsp";
  url += "?datasource="+vqrName;
  url += "&fields="+URLenc(URLenc(fields));
  url += "&configName="+zoomName+"."+tableName;
  url += "&updfnc=updateReports";
  url += "&gridID=" + strc.gridName;
  url += "&portletID=" + strc.openerID;

  windowOpenForeground(url);
}

function updateReports(reportName,custom){
  if (!Empty(reportName)){
    var label=Strtran(reportName,zoomName+'.'+tableName + "__", "")
    if (!reports[label]){
      reports[label]={value:reportName,custom:custom};
      document.getElementById("reports").innerHTML+="<li class='label margin' id="+ToHTMLValue(label)+"><div style='display:inline-block;'><div class='nameFields notMove' style='width:300px; margin-left:10px;'>"+label+getImg(SPTheme.smartEditorEditReportImage,'/visualweb/images/grid_edit.png','editReports','editReport(this)')+getImg(SPTheme.smartEditorDeleteReportImage,'/visualweb/images/grid_filter_delete.png','deleteReports','deleteReport(this)')+"</div></div></li>"  ;
    }
  }
}

function setOrderByFld(el){
  if (el){
    var idx=el.getAttribute('idx')
    var select=document.getElementById('orderByName_'+idx);
    if (select.style.display!='none'){
      var lbl=document.getElementById('orderByName_lbl_'+idx);
      var id=select.value;
      lbl.innerHTML=listColumnsById[id].description;
      lbl.style.display='inline-block';
      lbl.id='orderBy_lbl_'+id;
      select.style.display='none';
      var col=document.getElementById(id);
      if ((col && (col.classList.contains('hiddenField') || !col.classList.contains('columns')))){// && !document.getElementById(id+'_extra')){
        el.parentNode.parentNode.parentNode.classList.add('notValid');
        el.parentNode.parentNode.parentNode.classList.remove('orderValid');
      }
    }
  }
}

function addOrderBy(el){
    if (!el && nOrderBy>0) {
      setOrderByFld(document.getElementById('orderByName_'+(nOrderBy-1)));
    }
    var options='';
    if (el){
      options+="<option value="+ToHTMLValue(el.id)+" name="+ToHTMLValue(Lower(el.field))+">"+ToHTML(listColumnsById[el.id]?listColumnsById[el.id].description:queryFields[Lower(el.field)].description)+"</option>";
    }
    else {
      var list=document.getElementById("columns").children; // colonne della griglia
      for (var i=0; i<list.length-1; i++){ // length-1 perch� l'ultimo � il row layer
        var id=list[i].id;
        var check=document.getElementById("check_"+id);
        var name=Lower(list[i].getAttribute('name'));
        if (((check && !check.classList.contains('hidden')) || document.getElementById(id+'_extra')) && !listColumnsById[id].isHTML){
          if (!document.getElementById('orderBy_lbl_'+list[i].id)) {
            options+="<option value="+ToHTMLValue(id)+" name="+ToHTMLValue(name)+">"+ToHTML(listColumnsById[id]?listColumnsById[id].description:queryFields[name].description)+"</option>";
          }
        }
      }
    }
    if (Empty(options)) {
      return;
    }
    var inner="<select id='orderByName_"+nOrderBy+"' class='combobox filterName' idx='"+nOrderBy+"' onChange='setOrderByFld(this)'>"+options+"</select>"
    inner+="<span id='orderByName_lbl_"+nOrderBy+"' style=display:none;' class='filterName label' idx='"+nOrderBy+"'></span>"
    inner+="<select class='orderByType combobox' id='orderByType_"+nOrderBy+"' idx='"+nOrderBy+"' onChange='setOrderByFld(this)'>"+
    '<option selected value="asc"><%=sp.translate("MSG_ASCENDING")%></option>'+
    '<option value="desc"><%=sp.translate("MSG_DESCENDING")%></option>'+
    "</select>"
    var li=document.createElement("li");
    li.className='margin orderValid';
    li.setAttribute('idx',nOrderBy);
    li.id='orderByList_'+nOrderBy;
    li.innerHTML="<div style='display:inline-block;'><div class='nameFields notMove' >"+inner+getImg(SPTheme.smartEditorDeleteOrderByImage,'/visualweb/images/grid_filter_delete.png','orderByDelete','deleteOrderBy(this)')+"</div></div>"
    document.getElementById("orderByList").appendChild(li);
    if (el){
        document.getElementById('orderByType_'+nOrderBy).value=el.orderbystatus;
         setOrderByFld(document.getElementById('orderByName_'+nOrderBy));
    }
    nOrderBy++;
}

function deleteOrderBy(el){
  deleteElement(el.parentNode.parentNode.parentNode);
}

function deleteFilter(el){
  deleteElement(el.parentNode.parentNode.parentNode);
}

function addFilter(filter){
  filter=filter||{visible:true};
  var listFieldsForFilter="";
    var list=document.getElementById("columns").children,name;
    // combo per la selezione del filtro
    if (!filter.fixed){
      for (var i=0; i<list.length-1; i++){
        var id=list[i].id;
        var check=document.getElementById("check_"+id)
        var layer=list[i].getElementsByClassName("listColumnLayer")[0];
        name=Lower(list[i].getAttribute('name'));
        if (((check && !check.classList.contains('hidden')) || document.getElementById(id+'_extra')) && !listColumnsById[id].isHTML){
          listFieldsForFilter+="<option value="+ToHTMLValue(name)+">"+ToHTML(listColumnsById[id].description)+"</option>";
          if (layer){
            layer=layer.children;
            for (var j=0; j<layer.length; j++){
              id=layer[j].id;
              check=document.getElementById("check_"+id);
              name=Lower(layer[j].getAttribute('name'));
              if (((check && !check.classList.contains('hidden')) || document.getElementById(id+'_extra')) && !listColumnsById[id].isHTML){
                listFieldsForFilter+="<option value="+ToHTMLValue(name)+">"+ToHTML(listColumnsById[id].description)+"</option>";
              }
            }
          }
        }
      }
      list=document.getElementById("rowLayer").children;
      for (var i=0; i<list.length; i++){
        var id=list[i].id;
        var check=document.getElementById("check_"+id);
        if ((check && !check.classList.contains('hidden')) || document.getElementById(id+'_extra')){
          name=Lower(list[i].getAttribute('name'));
          listFieldsForFilter+="<option value="+ToHTMLValue(name)+">"+ToHTML(listColumnsById[id].description)+"</option>";
        }
      }
      if (!filter.visible){
        name=Lower(filter.field);
        var id;
        if (listColumnsByName[name]){
          id=listColumnsByName[name][0]; //prima colonna con quel nome
        }
        else {
          var el;
          for (el in listColumnsById){
            if (Lower(listColumnsById[el].name==name)) {
              id=el;
            }
          }
        }
        listFieldsForFilter+="<option value="+ToHTMLValue(name)+">"+ToHTML(listColumnsById[id].description)+"</option>";
      }
      var select="<select id='filterName_"+nFilter+"' class='combobox filterName'>"+listFieldsForFilter+"</select>";
      // combo per la scelta dell'operazione
      select+="<select class='filterType combobox' id='filterType_"+nFilter+"'>"+
      '<option selected value="like"><%=sp.translate("MSG_STARTS_WITH")%></option>'+
      '<option value="contains"><%=sp.translate("MSG_CONTAINS")%></option>'+
      '<option value="=">=</option>'+
      '<option value="<"><</option>'+
      '<option value="<="><=</option>'+
      '<option value=">=">>=</option>'+
      '<option value=">">></option>'+
      '<option value="<>"><></option>'+
      '<option value="empty"><%=sp.translate("MSG_EMPTY")%></option>'+
      '<option value="notempty"><%=sp.translate("MSG_NOTEMPTY")%></option>'+
      "</select>"
      var value="<input type='text' value='"+(filter.expression||'')+"' id='value_"+nFilter+"' class='textbox filterValue'/>";
      var li=document.createElement("li");
      li.className='margin';
      li.setAttribute("idx",nFilter);
      li.innerHTML="<div style='display:inline-block;'><div class='nameFields notMove filters' >"+select+value+getImg(SPTheme.smartEditorDeleteFilterImage,'/visualweb/images/grid_filter_delete.png','filterDelete','deleteFilter(this)')+"</div>"+"</div>"
      document.getElementById("filters").appendChild(li);
      if (filter.field){
        document.getElementById("filterName_"+nFilter).value=Lower(filter.field);
        document.getElementById("filterType_"+nFilter).value=Lower(filter.operator);
      }
      if (!filter.visible) {
        li.classList.add('hiddenFilter');
      }
    }
    // else if (!filter.fixed){
    //   var li=document.createElement("li");
    //   li.style.display='none';
    //   li.setAttribute("idx",nFilter);
    //   li.innerHTML="<input type='hidden' id='filterName_"+nFilter+"' value='"+Lower(filter.field)+"'>"+
    //                             "<input type='hidden' id='filterType_"+nFilter+"' value='"+Lower(filter.operator)+"'>"+
    //                             "<input type='hidden' id='value_"+nFilter+"' value='"+(filter.expression||'')+"'>";
    //   document.getElementById("filters").appendChild(li);
    // }
  nFilter++;
}

// function addVdm(){
  // var vdmName=zoomName+'.'+tableName;
  // var existVdm=new JSURL("../servlet/SPVDMProxy?m_cAction=exist&m_cConfigName="+vdmName, true).Response()==1;
  // var _filters=[],idx=0;
  // var listFilters=document.getElementById("filters").getElementsByTagName("li");
  // for (var i=0; i<listFilters.length; i++){
    // var id=listFilters[i].id;
    // if (!Empty(document.getElementById("value_"+id).value)){
      // _filters[idx]={};
      // _filters[idx].fieldName=document.getElementById("filterName_"+id).value;
      // _filters[idx].queryFilter=false;
      // _filters[idx].initialOperation=document.getElementById("filterType_"+id).value;
      // _filters[idx].initialValue=document.getElementById("value_"+id).value;
      // _filters[idx].changeOperation=true;
      // _filters[idx].description=listColumns[Lower(document.getElementById("filterName_"+id).value)].description;
      // idx++;
    // }
  // }
  // if (existVdm && confirm("A parameter's configuration has already existed, do you want to update it with new filters?")){
     // var saved=new JSURL("../servlet/SPVDMProxy?m_cAction=addFieldToMask&m_cConfigName="+vdmName+"&m_cWv="+URLenc(JSON.stringify(_filters)),true).Response();
    // if (saved.startsWith("Saved"))
      // Alert("The configuration has been updated")
    // else Alert("Error: the configuration hasn't been updated")
  // }
  // else {
    // var obj={
      // configName:vdmName,
      // fields:_filters,
      // titleMsg:"MSG_SEARCH_FILTERS"
    // }
    // var saved=new JSURL("../servlet/SPVDMProxy?m_cAction=save&m_cConfigName="+vdmName+"&m_cWv="+URLenc(JSON.stringify(obj))+"&queryName="+vqrName+"&forceSave=true&custom=false",true).Response();
    // if (saved.startsWith("Saved"))
      // Alert("The configuration has been created")
    // else Alert("Error: the configuration hasn't been created")
  // }
// }

function closeWindow(){
  window.close();
}

function changeVisibility(el,visibility){
  var id=Strtran(el.id,"check_","");
  var col=document.getElementById(id);
  var orderCol=document.getElementById('orderBy_lbl_'+Lower(col.getAttribute('name')))
  visibility=visibility||(el.classList.contains("hidden")?'inExtGrid':el.classList.contains("inExtGrid")?'base':'hidden');
  if (visibility=='inExtGrid'){ //ero nascosto, passo a esteso
    el.classList.remove("hidden");
    el.classList.remove("base");
    el.classList.add("inExtGrid");
    if (col.parentNode.id!='zoomTiles'){
      col.classList.remove('hiddenField');
      col.classList.add('visibleField');
      if (orderCol){
        orderCol.parentNode.parentNode.parentNode.classList.remove('notValid');
        orderCol.parentNode.parentNode.parentNode.classList.add('orderValid');
      }
      updateListColumnsWidth();
    }
    // se sono un column layer e la colonna principale � nascosta, passo a rowlayer
    if (col.classList.contains('columnLayer') && col.parentNode.parentNode.classList.contains('hiddenField')){
      var rowL=document.getElementById('rowLayer');
      col.appendChild(rowL);
      adjustTitleWidth();
      updateListColumnsWidth();
    }
    var hiddenFilter=document.getElementById("filters").getElementsByClassName("hiddenFilter");
    if (hiddenFilter.length>0){
      for (var i=0; i<hiddenFilter.length;i++){
        var name=document.getElementById("filterName_"+hiddenFilter[i].getAttribute("idx")).value;
        if (listColumnsByName[name][0]==id) {
          hiddenFilter[i].classList.remove('hiddenFilter');
        }
      }
    }
  }
  else if (visibility=='base'){ // ero esteso, passo a visibile
    el.classList.remove("inExtGrid");
    el.classList.remove("hidden");
    el.classList.add("base");
  }
  else { // passo a nascosto
    el.classList.remove("base");
    el.classList.remove("inExtGrid");
    el.classList.add("hidden");

    if (col.parentNode.id!='zoomTiles'){
      col.classList.remove('visibleField');
      col.classList.add('hiddenField');
      if (orderCol){
        // if (!document.getElementById(id+'_extra')){
        orderCol.parentNode.parentNode.parentNode.classList.add('notValid');
        orderCol.parentNode.parentNode.parentNode.classList.remove('orderValid');
        // }
      }
      updateListColumnsWidth();
    }
  }
  var cl=col.getElementsByClassName('columnLayer');
  for (var i=0; i<cl.length; i++){
    var c=document.getElementById('check_'+cl[i].id);
    if (!c.classList.contains('hidden')) {
      changeVisibility(c,visibility);
    }
  }
  adjustMoveArrows(true);

}

function updateListColumnsWidth(title){
  if (!title){
    var children=document.getElementById('columns').querySelectorAll(".visibleField.columns");
    var width=document.getElementById('rowLayer').offsetWidth+20;
    for (var i=0; i<children.length; i++){
      width+=children[i].offsetWidth;
    }
    document.getElementById('columns').style.width=width+'px';
  }
  else {
    document.getElementById('columns').parentNode.parentNode.style.width=(Math.max(document.getElementById('columns').offsetWidth,document.getElementById('extraTitle').style)+400)+'px';
  }
}

function adjustMoveArrows(remove){
  if (remove){
    var first=document.getElementsByClassName('first')[0];
    if (first) {
      first.classList.remove('first');
    }
    var last=document.getElementsByClassName('last')[0];
    if (last) {
      last.classList.remove('last');
    }
  }
  var children=document.getElementById('columns').querySelectorAll(".visibleField.columns");
  if (children.length>0){
    children[0].classList.add('first');
    children[children.length-1].classList.add('last');
  }
  children=document.getElementById('extraTitle').children;
  if (children.length>0){
    children[0].classList.add('first');
    children[children.length-1].classList.add('last');
  }
}

function getZoomFields(){
  if (nOrderBy>0) {
     setOrderByFld(document.getElementById('orderByName_'+(nOrderBy-1)));
  }
  var _zoomFields=[];
  var list=document.getElementById("columns").children;
  for (var i=0; i<list.length-1; i++){ // length-1 perch� l'ultimo � il row layer
    var id=list[i].id;
    var tile=document.getElementById("check_"+id+"_tile");
    var check=document.getElementById("check_"+id);
    var layer=list[i].getElementsByClassName("listColumnLayer")[0];
    var name=Lower(list[i].getAttribute('name'));
    if ((check && !check.classList.contains('hidden')) || !queryFields[name] || document.getElementById(id+'_extra')){
        var orderByIdx=document.getElementById('orderBy_lbl_'+id);
        orderByIdx=orderByIdx && orderByIdx.parentNode.parentNode.parentNode.classList.contains('orderValid')?orderByIdx.getAttribute('idx'):-1;
      _zoomFields.push({
        id:id,
        inExtGrid:check?check.classList.contains("inExtGrid"): listColumnsById[id].inExtGrid,
        hidden:check?check.classList.contains("hidden"): listColumnsById[id].hidden,
        Layer:[],
        tileVisibility:tile?(tile.classList.contains("hidden")?"hidden":(tile.classList.contains("inExtGrid")?"extended":"base")):"base",
        field:name,
        title:listColumnsById[id]?listColumnsById[id].description:queryFields[name].description,
        show_extra_title:document.getElementById(id+'_extra')?true:false,
        extracolidx:document.getElementById(id+'_extra')?getPosInExtraTitle(document.getElementById(id+'_extra')):-1,
        orderbystatus:orderByIdx!=-1?document.getElementById('orderByType_'+orderByIdx).value:'',
        orderbyidx:orderByIdx!=-1?getIndexMatch(document.getElementById('orderByList_'+orderByIdx),'orderValid')+1:0
      })
      if (layer){
        layer=layer.children;
        for (var j=0; j<layer.length; j++){
          name=Lower(layer[j].getAttribute('name'));
          id=layer[j].id;
          check=document.getElementById("check_"+id);
          if ((check && !check.classList.contains('hidden')) || listColumnsByName[name] || document.getElementById(id+'_extra')){
            _zoomFields[_zoomFields.length-1].Layer.push({
              id:id,
              inExtGrid:check?check.classList.contains("inExtGrid"):listColumnsById[id].inExtGrid,
              hidden:check?check.classList.contains("hidden"):listColumnsById[id].hidden,
              field:name,
              title:listColumnsById[id]?listColumnsById[id].description:queryFields[name].description,
              show_extra_title:document.getElementById(id+'_extra')?true:false,
              extracolidx:document.getElementById(id+'_extra')?getPosInExtraTitle(document.getElementById(id+'_extra')):-1
            })
          }
        }
      }
    }
  }
  return _zoomFields;
}

function getRowLayer(){
  var _rowLayer=[];
  var list=document.getElementById("rowLayer").children;
  for (var i=0; i<list.length; i++){
    var id=list[i].id;
    var check=document.getElementById("check_"+id);
    var name=Lower(list[i].getAttribute('name'));
    if ((check && !check.classList.contains('hidden')) || listColumnsByName[name] || document.getElementById(id+'_extra')){
      _rowLayer.push({
        id:id,
        inExtGrid:check?check.classList.contains("inExtGrid"):listColumnsById[id].inExtGrid,
        hidden:check?check.classList.contains("hidden"):listColumnsById[id].hidden,
        field:name,
        title:listColumnsById[id]?listColumnsById[id].description:queryFields[name].description,
        show_extra_title:document.getElementById(id+'_extra')?true:false,
        extracolidx:document.getElementById(id+'_extra')?getPosInExtraTitle(document.getElementById(id+'_extra')):-1
      })
    }
  }
  return _rowLayer;
}

function getFilters(){
  var _filters=[],idx=0,value,filterType;
  var listFilters=document.getElementById("filters").getElementsByTagName("li");
  for (var i=0; i<listFilters.length; i++){
    var id=listFilters[i].getAttribute("idx"),
    fieldName=document.getElementById("filterName_"+id).value;
    value=document.getElementById("value_"+id).value;
    filterType=document.getElementById("filterType_"+id).value;
    if ((!Empty(value) || filterType=='empty' || filterType=='notempty') && (listColumnsByName[fieldName] || listFilters[i].classList.contains('hiddenFilter'))){
      _filters[idx]={};
      _filters[idx].field=fieldName;
      _filters[idx].operator=filterType;
      _filters[idx].expression=value;
      _filters[idx].type=listColumnsByName[fieldName]?listColumnsById[listColumnsByName[fieldName][0]].type:'C';
      idx++;
    }
  }
  return _filters;
}

function getTotals(){
  var totalsPosition,totalsStart='left';
  if (document.getElementById("topLeft").checked){
    totalsPosition='top-tile';
  }
  else if (document.getElementById("topRight").checked){
    totalsPosition='top-tile';
    totalsStart='right';
  }
  else if (document.getElementById("bottomLeft").checked){
    totalsPosition='bottom-tile';
  }
  else if (document.getElementById("bottomRight").checked){
    totalsPosition='bottom-tile';
    totalsStart='right';
  }
  else if (document.getElementById("grid").checked){
    totalsPosition='grid';
  }
  else {
    totalsPosition='hidden';
  }
  return [totalsPosition,totalsStart];
}

function applyZoom(){
  var totals=getTotals();
  GetOpener()[zoomUID].applyZoom(getZoomFields(),getRowLayer(),getFilters(),totals[0],totals[1]);
  close();
}

var showMask=true;
function getFileName(){
  var versionName=editZoom.version.getVersionName();
  var fileName=zoomName.split('__')[0];
  if (!Empty(versionName)){
    var userGroup=editZoom.version.getUserGroup();
    if (versionName.indexOf('_') && Empty(userGroup)){
      var ug=versionName.substring(versionName.lastIndexOf('_')+1);
      if (!isNaN(parseInt(ug))){
        if (!confirm("<%=sp.translate("MSG_SAVING_VERSION_FOR_USER")%>")) {
          return -1;
        }
        showMask=false;
      }
      else if (ug.charAt(0)=='g'){
        ug=ug.substring(1);
        if (!isNaN(parseInt(ug))){
          if (!confirm("<%=sp.translate("MSG_SAVING_VERSION_FOR_GROUP")%>")) {
            return -1;
          }
          showMask=false;
        }
      }
    }
    if (isNaN(parseInt(versionName))) {
      fileName+=(versionName!=userGroup?'__':'')+versionName;
    }
    else {
      fileName=-2;
    }
  }
  return fileName;
}

function saveZoom(){
  showMask=true;
  var totals=getTotals();
  var fileName=getFileName();
  var userCode=editZoom.version.getUserCode();
  showMask=showMask && (!<%=sp.CanConfigureZoom()%> || userCode==0 || <%=currentUser%>==editZoom.version.getUserCode());
  if (fileName==-1) {
    return;
  }
  if (fileName==-2) {
    alert("<%=sp.translate("MSG_VERSION_NAME_NOT_VALID")%>")
  }
  else {
    var custom=editZoom.version.getCustom();
    if (custom || confirm("<%=sp.translate("MSG_SAVING_VERSION_NOT_CUSTOM")%>")){

      // controllo se posso salvare la versione
      var url = new JSURL("../servlet/SPVZMProxy?action=checkVersion&User="+URLenc('<%=user%>')+"&Custom="+URLenc(custom)+"&configname="+URLenc(fileName)+"&table="+URLenc(tableName),true);
      var resp=parseInt(url.Response()) // -1: non modificabile, 0: esiste, ma modificabile, 1: nuova
      if (resp==-1){
        alert("<%=sp.translate("MSG_OVERWRITE_VERSION_FROM_SMART_EDITOR")%>")
      }
      else if(resp==1 || confirm("<%=sp.translate("MSG_OVERWRITE_VERSION")%>")){
        GetOpener()[zoomUID].saveZoom(getZoomFields(),getRowLayer(),getFilters(),true,totals[0],totals[1],(custom?"1/":"0/")+fileName,!showMask);
        close();
      }
    }
  }
}

function deleteZoom(){
  if (confirm("<%=sp.translate("MSG_DELETE_VERSION_ALERT")%>")){
    var url = new JSURL("../servlet/SPVZMProxy?action=deleteVersion&User="+URLenc('<%=user%>')+"&Group="+URLenc('<%=group%>')+"&Custom="+URLenc('<%=custom%>')+"&configname="+URLenc(zoomName)+"&table="+URLenc(tableName),true);
    var resp=url.Response()
    if (resp=='deleted'){
      alert("<%=sp.translate("MSG_VERSION_DELETED")%>")
      GetOpener()[zoomUID].deleteZoom();
      close();
    }
    else {
      alert("<%=sp.translate("MSG_DELETE_VERSION_ERROR")%>")
    }
  }
}

function Help(){
  var prop="vzoomeditor_smarteditor";
  if (typeof(anchorToFeature) != 'undefined') {
    if (prop in anchorToFeature) {
      i = anchorToFeature[prop];
    }
    else {
      i = anchorToFeature["vzoomeditor"];
    }
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?' + URLenc(i +  '||' + prop) , '', 'toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
  }
}

function destroyElements(elmArray) {
  for (var i = 0; i < elmArray.length; i++) {
    deleteElement(elmArray[i]);
  }
}

function deleteElement(element) {
  if (element.parentNode === null) {
    return;
  }
  element.parentNode.removeChild(element);
}

function setElementsStyle(elmArray, prop, value) {
  for (var i = 0; i < elmArray.length; i++) {
    elmArray[i].style[prop] = value;
  }
}

function getPosInExtraTitle(element) {
  var parent=element.parentNode;
  return Array.prototype.indexOf.call(parent.children, element);
}

function getIndexMatch(element, match) {
  var a=[];
  var parent=element.parentNode;
  for(let i=0;i<parent.children["length"];i++) {
    if(parent.children[i].classList.contains(match)) {
      a.push(parent.children[i]);
    }
  }
  return a.indexOf(element);
}

</script>
</body>
<%}%>
  </html>
