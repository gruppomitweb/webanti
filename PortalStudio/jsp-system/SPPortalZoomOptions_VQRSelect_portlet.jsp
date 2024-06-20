<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nfunction grdVqrs_RowsChanged(rows){\nthis.GridRows.Value(rows);\n}\n\ndocument.title=\"\u003c%=sp.translate(\"MSG_VZM_SELECT\")%\u003e\"+\" VQR\";\n\nvar this_portlet=this;\nvar _fill=function(jsurl){\n  eval( ['var vqrs=', jsurl.Response().replace(\u002f\\.vqr\u002fgi, '')].join('') );\n  __fill.call(this_portlet, vqrs);\n}\nthis.grdVqrs.Refresh=function(){\n  this.form.VQRSelected.Value(\"\");\n  this.form.Fill();\n}\nvar __fill=function(vqrs){\n  vqrList={Fields:['VQR'],Data:[]};\n  var find,find_lc, foundIdx,gridRows=this.GridRows.Value();\n  if(!EmptyString(this.VQRName.Value())){\n    find=this.VQRName.Value();\n    find_lc=find.toLowerCase();\n  }\n  for(var i=0, vqr, _gridRows=gridRows, l=vqrs.length; i\u003cl; i++){\n    vqr=vqrs[i];\n    vqrList.Data[i]=[vqr];\n    if(find && i\u003c_gridRows && vqr.toLowerCase()==find_lc){\n      foundIdx=i+1;\n    }\n  }\n  this.grdVqrs.rows=gridRows;\n  vqrList.Data.push(\"tf,C,\"+vqrList.Data.length);\n  this.VQRList.firstQuery('true','',vqrList);\n  if(IsAny(foundIdx)){\n    this.grdVqrs.SetCurRec(foundIdx);\n  }else if(find){\n    this.VQRSelected.Value(find);\n  }\nthis.imgRefresh.Hide();\n\u002f\u002f  this.imgRefresh.Value('..\u002fvisualweb\u002fimages\u002fvqr_list_refresh.gif');\n}\n\nfunction Fill(){\n  var vqrsel=this.VQRSelected.Value(),\n      filter=EmptyString(vqrsel) ? '' : '&filter='+vqrsel;\n  this.imgRefresh.Show();\n\u002f\u002f  this.imgRefresh.Value('..\u002fvisualweb\u002fimages\u002floading_small.gif');\n  new JSURL(\"..\u002fservlet\u002fSPVQRProxy?action=vqr\"+filter,true,_fill);\n}\n\nfunction Ok(){\n  var openerID=this.openerID.Value();\n  if(!openerID) return;\n  var VQRName=this.VQRSelected.Value();\n  var caller= window.opener||window;\n  caller.ZtVWeb.raiseEvent(openerID+\"_ChangeVQRName\", VQRName);\n  this.Cancel(); \n}\n\nfunction Cancel(){\n  var openerID=this.openerID.Value();\n  if(!openerID) return;\n  if(window.opener){\n    window.close();\n  }\n}\n\nfunction btnOk_Click(){\n  this.Ok();\n}\n\nfunction btnCancel_Click(){\n  this.Cancel();\n}\n\nfunction this_Loaded(){\n  this.Fill();\n}\n\nfunction btnVqr_Filter_Click(){\n  this.VQRName.Value(this.VQRSelected.Value());\n  this.Fill();\n}","bg_image":" ","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"430","language":"false","my_library":" ","on_security_failure":"login","pages_names":" ","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"400","version":"37","w":"100%"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"VQRName","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"40","y":"-50"},{"align":"left","anchor":"top-left-right","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":" ","column_align":" ","columnfields":" ","columnformat":" ","columnlinks":" ","columntitles":"VQR","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"VQRList","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","filters":"false","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"350","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":" ","line_color":" ","link_underlined":" ","name":"grdVqrs","nav_bar":"true","on_click":" ","orderby":" ","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","pictures":" ","preCheckbox_fld":" ","recMark":"true","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"20","scroll_bars":"true","sequence":" ","splinker":" ","splinker_pos":"left","target":" ","title_color":" ","type":"Grid","valign":"top","w":"380","x":"10","y":"10"},{"auto_exec":"false","count":"true","n_records":"0","name":"VQRList","page":"1","parms":" ","parms_source":" ","query":" ","query_async":"false","return_fields_type":"true","sequence":" ","type":"SQLDataobj","x":"0","y":"-39"},{"anchor":"top-left-right","class_Css":"textbox","dataobj":"VQRList","field":"VQR","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","init_par":" ","maxlength":" ","name":"VQRSelected","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":" ","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"275","x":"70","y":"365","zindex":"1"},{"anchor":"top-right","bg_color":" ","class_Css":" ","font":" ","font_color":" ","font_size":" ","h":"25","help_tips":" ","name":"btnOk","page":"1","sequence":" ","tabindex":" ","type":"Button","type_submit":"false","value":"Ok","w":"55","x":"275","y":"397"},{"anchor":"top-right","bg_color":" ","class_Css":"button","font":" ","font_color":" ","font_size":" ","h":"25","help_tips":" ","name":"btnCancel","page":"1","sequence":" ","tabindex":" ","type":"Button","type_submit":"false","value":"Cancel","w":"55","x":"335","y":"397"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"openerID","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"40","y":"-26"},{"align":"left","anchor":"top-left","bg_color":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","help_tips":" ","href":" ","name":"lblSelected","page":"1","picture":" ","sequence":" ","tabindex":" ","target":" ","type":"Label","value":"Selected:","w":"60","x":"10","y":"367","zindex":"1"},{"anchor":" ","dataobj":" ","field":" ","h":"16","help_tips":"Refresh VQR list","href":" ","name":"imgRefresh","page":"1","sequence":" ","src":"..\u002fvisualweb\u002fimages\u002floading_small.gif","srchover":" ","tabindex":" ","target":" ","themed_image":"false","type":"Image","type_submit":"false","w":"16","x":"10","y":"10","zindex":"2"},{"anchor":"top-right","bg_color":" ","class_Css":" ","font":" ","font_color":" ","font_size":" ","h":"20","help_tips":" ","name":"btnVqr_Filter","page":"1","sequence":" ","tabindex":" ","type":"Button","type_submit":"false","value":"Filter","w":"40","x":"350","y":"367"},{"anchor":" ","class_Css":"textbox","dataobj":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"18","help_tips":" ","init_par":"request:GridRows:50","maxlength":"3","name":"GridRows","page":"1","password":" ","picture":"999","readonly":"false","scroll":"false","sequence":" ","tabindex":" ","type":"Textbox","typevar":"numeric","visible":"true","w":"33","x":"188","y":"-50","zindex":"1"}]%>
<%/*Description: */%>
<%/*ParamsRequest:VQRName,openerID,GridRows*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPPortalZoomOptions_VQRSelect_container {
}
.SPPortalZoomOptions_VQRSelect_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:430px;
}
.SPPortalZoomOptions_VQRSelect_portlet[Data-page="1"]{
  height:430px;
  width:100%;
}
.SPPortalZoomOptions_VQRSelect_portlet > .grdVqrs_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:10px;
  right:10px;
  width:auto;
  height:350px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .VQRSelected_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:365px;
  left:70px;
  right:55px;
  width:auto;
  height:20px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .VQRSelected_ctrl {
}
.SPPortalZoomOptions_VQRSelect_portlet > .VQRSelected_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_VQRSelect_portlet > .btnOk_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:397px;
  right:70px;
  width:55px;
  height:25px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .btnOk_ctrl {
  border-width:nullpx;
}
.SPPortalZoomOptions_VQRSelect_portlet > .btnCancel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:397px;
  right:10px;
  width:55px;
  height:25px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .btnCancel_ctrl {
  border-width:nullpx;
}
.SPPortalZoomOptions_VQRSelect_portlet > .lblSelected_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:367px;
  left:10px;
  width:60px;
  height:auto;
  min-height:19px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .lblSelected_ctrl {
  height:auto;
  min-height:19px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .lblSelected_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomOptions_VQRSelect_portlet > .imgRefresh_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:10px;
  left:10px;
  width:16px;
  height:16px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .imgRefresh_ctrl {
}
.SPPortalZoomOptions_VQRSelect_portlet > .imgRefresh_ctrl > img{
  width:100%;
  vertical-align:top;
  height:16px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .btnVqr_Filter_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:367px;
  right:10px;
  width:40px;
  height:20px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .btnVqr_Filter_ctrl {
  border-width:nullpx;
}
.SPPortalZoomOptions_VQRSelect_portlet > .GridRows_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-50px;
  left:188px;
  width:33px;
  height:18px;
}
.SPPortalZoomOptions_VQRSelect_portlet > .GridRows_ctrl {
}
.SPPortalZoomOptions_VQRSelect_portlet > .GridRows_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
<%}else if(sp.getParameter("SpWireframe","").equals("true")){
String containerId=sp.getParameter("containerID",idPortlet);
Library.SetMimeType(response,"text/html");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
PrintWireFrame(containerId,out);
%>
<%!
void PrintWireFrame(String containerId, java.io.Writer out) throws java.lang.Throwable {
 String def="[{\"h\":\"430\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"40\",\"y\":\"-50\"},{\"anchor\":\"top-left-right\",\"h\":\"350\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"380\",\"x\":\"10\",\"y\":\"10\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"0\",\"y\":\"-39\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"70\",\"y\":\"365\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"55\",\"x\":\"275\",\"y\":\"397\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"55\",\"x\":\"335\",\"y\":\"397\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"40\",\"y\":\"-26\"},{\"anchor\":\"top-left\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"60\",\"x\":\"10\",\"y\":\"367\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"16\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"10\",\"y\":\"10\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"40\",\"x\":\"350\",\"y\":\"367\"},{\"anchor\":\"\",\"h\":\"18\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"33\",\"x\":\"188\",\"y\":\"-50\",\"zindex\":\"1\"}]";
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("stdFunctions.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("portalstudio/renderDef.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("visualweb/itemsObj.js")+"'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../visualweb/itemsObj.css'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../portalstudio/renderDef.css'></script>\n");
 out.write("<div id="+JSPLib.ToHTMLValue(containerId)+"></div>\n");
 out.write("<script> /*JS_MARKER_START*/\n");
 out.write("new renderDef({\n");
 out.write("def: "+def+",\n");
 out.write("container: '"+JSPLib.ToJSValue(containerId)+"',\n");
 out.write("replaceContainer: true\n");
 out.write("})\n");
 out.write("/*JS_MARKER_END*/ </script>\n");
}/**/%>
<%}else{
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomOptions_VQRSelect","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomOptions_VQRSelect_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<% sp.WritePortalStudioCSS(request, out); 
if(Library.IsMobile(request)){%><%}%>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomOptions_VQRSelect','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String VQRName=JSPLib.translateXSS(sp.getParameter("VQRName",""));
if(request.getAttribute("SPPortalZoomOptions_VQRSelect_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String VQRSelected= "";
if(request.getAttribute("SPPortalZoomOptions_VQRSelect_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String openerID=JSPLib.translateXSS(sp.getParameter("openerID",""));
String lblSelected= "Selected:";
double GridRows=sp.getParameter("GridRows",50);
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomOptions_VQRSelect_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomOptions_VQRSelect_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomOptions_VQRSelect','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grdVqrs' formid='<%=idPortlet%>' ps-name='grdVqrs'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_VQRSelected_wrp'><input id='<%=idPortlet%>_VQRSelected' name='VQRSelected' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='VQRSelected' /></span>
<input id='<%=idPortlet%>_btnOk' type='button' class='button btnOk_ctrl'/>
<input id='<%=idPortlet%>_btnCancel' type='button' class='button btnCancel_ctrl'/>
<span id='<%=idPortlet%>_lblSelected'  formid='<%=idPortlet%>' ps-name='lblSelected'    class='label lblSelected_ctrl'><div id='<%=idPortlet%>_lblSelectedtbl' style='width:100%;'><%=JSPLib.ToHTML("Selected:")%></div></span>
<div id='<%=idPortlet%>_imgRefresh'>
<img id='<%=idPortlet%>_imgRefresh_img' class=' imgRefresh_ctrl' src="../visualweb/images/loading_small.gif" >
</div>
<input id='<%=idPortlet%>_btnVqr_Filter' type='button' class='button btnVqr_Filter_ctrl'/>
<span class='textbox-container'id='<%=idPortlet%>_GridRows_wrp'><input id='<%=idPortlet%>_GridRows' name='GridRows' type='text' maxlength='3' class='textbox' formid='<%=idPortlet%>' ps-name='GridRows' data-sp-item-say-pict='999' data-sp-item-get-pict='999' inputmode='numeric' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomOptions_VQRSelect');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomOptions_VQRSelect',["400"],["430"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"430","title":" ","layer":"false","npage":"1"}]);
this.VQRName=new ZtVWeb._VC(this,'VQRName',null,'character','<%=JSPLib.ToJSValue(VQRName,false,true)%>',false,false);
this.grdVqrs=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":" ","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdVqrs","dataobj":"VQRList","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":350,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":" ","keepMemCurs":" ","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"grdVqrs","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"true","show_btn_delete":"false","show_btn_update":"false","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":"left","title_color":"","type":"Grid","valign":"top","w":380,"x":10,"y":10});
this.grdVqrs.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[]});
this.VQRList=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":" ","cmdHash":"<%=JSPLib.cmdHash(" ",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_VQRList","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"VQRList","nrows":"0","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":0,"y":-39});
this.VQRSelected=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_VQRSelected","decrypt":false,"edit_undercond":"","encrypt":false,"field":"VQR","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"VQRSelected","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(VQRSelected,false,true)%>","w":275,"x":70,"y":365,"zerofilling":false,"zindex":"1","zoom":""});
this.btnOk=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","class_Css":"button btnOk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":" ","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnOk","page":1,"tabindex":" ","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":275,"y":397});
this.btnCancel=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","class_Css":"button btnCancel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCancel","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":" ","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnCancel","page":1,"tabindex":" ","text":"Cancel","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":335,"y":397});
this.openerID=new ZtVWeb._VC(this,'openerID',null,'character','<%=JSPLib.ToJSValue(openerID,false,true)%>',false,false);
this.lblSelected=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSelected","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":" ","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSelected","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":"false","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblSelected,false,true)%>","type":"Label","w":60,"x":10,"y":367,"zindex":"1"});
this.imgRefresh=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":" imgRefresh_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgRefresh","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue("Refresh VQR list",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"imgRefresh","page":1,"server_side":"false","src":"..\u002fvisualweb\u002fimages\u002floading_small.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":16,"x":10,"y":10,"zindex":"2"});
this.btnVqr_Filter=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","class_Css":"button btnVqr_Filter_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnVqr_Filter","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":" ","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnVqr_Filter","page":1,"tabindex":" ","text":"Filter","type":"Button","type_submit":"false","type_wizard":"","w":40,"x":350,"y":367});
this.GridRows=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_GridRows","decrypt":false,"edit_undercond":"","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request:GridRows:50","layer":false,"layout_steps_values":{},"maxlength":"3","name":"GridRows","page":1,"picker":"","picture":"999","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=GridRows%>","w":33,"x":188,"y":-50,"zerofilling":false,"zindex":"1","zoom":""});
<%if(!Library.Empty(PageletId) ){%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
<%}%>

}
/*JS_MARKER_END*/
</script>
<%request.setAttribute("SPPortalZoomOptions_VQRSelect_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomOptions_VQRSelect_Static=function(){
if(typeof grdVqrs_RowsChanged !='undefined')this.grdVqrs_RowsChanged=grdVqrs_RowsChanged;
if(typeof Fill !='undefined')this.Fill=Fill;
if(typeof Ok !='undefined')this.Ok=Ok;
if(typeof Cancel !='undefined')this.Cancel=Cancel;
if(typeof btnOk_Click !='undefined')this.btnOk_Click=btnOk_Click;
if(typeof btnCancel_Click !='undefined')this.btnCancel_Click=btnCancel_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnVqr_Filter_Click !='undefined')this.btnVqr_Filter_Click=btnVqr_Filter_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.VQRList.addRowConsumer(this.grdVqrs);
this.VQRList.addDataConsumer(this.VQRSelected,<%=JSPLib.ToJSValue("VQR",true)%>);

function grdVqrs_RowsChanged(rows){
this.GridRows.Value(rows);
}
document.title="<%=sp.translate("MSG_VZM_SELECT")%>"+" VQR";
var this_portlet=this;
var _fill=function(jsurl){
  eval( ['var vqrs=', jsurl.Response().replace(/\.vqr/gi, '')].join('') );
  __fill.call(this_portlet, vqrs);
}
this.grdVqrs.Refresh=function(){
  this.form.VQRSelected.Value("");
  this.form.Fill();
}
var __fill=function(vqrs){
  vqrList={Fields:['VQR'],Data:[]};
  var find,find_lc, foundIdx,gridRows=this.GridRows.Value();
  if(!EmptyString(this.VQRName.Value())){
    find=this.VQRName.Value();
    find_lc=find.toLowerCase();
  }
  for(var i=0, vqr, _gridRows=gridRows, l=vqrs.length; i<l; i++){
    vqr=vqrs[i];
    vqrList.Data[i]=[vqr];
    if(find && i<_gridRows && vqr.toLowerCase()==find_lc){
      foundIdx=i+1;
    }
  }
  this.grdVqrs.rows=gridRows;
  vqrList.Data.push("tf,C,"+vqrList.Data.length);
  this.VQRList.firstQuery('true','',vqrList);
  if(IsAny(foundIdx)){
    this.grdVqrs.SetCurRec(foundIdx);
  }else if(find){
    this.VQRSelected.Value(find);
  }
this.imgRefresh.Hide();
//  this.imgRefresh.Value('../visualweb/images/vqr_list_refresh.gif');
}
function Fill(){
  var vqrsel=this.VQRSelected.Value(),
      filter=EmptyString(vqrsel) ? '' : '&filter='+vqrsel;
  this.imgRefresh.Show();
//  this.imgRefresh.Value('../visualweb/images/loading_small.gif');
  new JSURL("../servlet/SPVQRProxy?action=vqr"+filter,true,_fill);
}
function Ok(){
  var openerID=this.openerID.Value();
  if(!openerID) return;
  var VQRName=this.VQRSelected.Value();
  var caller= window.opener||window;
  caller.ZtVWeb.raiseEvent(openerID+"_ChangeVQRName", VQRName);
  this.Cancel(); 
}
function Cancel(){
  var openerID=this.openerID.Value();
  if(!openerID) return;
  if(window.opener){
    window.close();
  }
}
function btnOk_Click(){
  this.Ok();
}
function btnCancel_Click(){
  this.Cancel();
}
function this_Loaded(){
  this.Fill();
}
function btnVqr_Filter_Click(){
  this.VQRName.Value(this.VQRSelected.Value());
  this.Fill();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomOptions_VQRSelect_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomOptions_VQRSelect',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomOptions_VQRSelect');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{
}%>
<%if(!included){%>
</html>
<%}
sp.endPage("SPPortalZoomOptions_VQRSelect");
}%>
<%! public String getJSPUID() { return "1130402549"; } %>