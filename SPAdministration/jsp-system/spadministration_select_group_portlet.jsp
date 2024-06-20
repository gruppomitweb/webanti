<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n\tconst selectedValue = this.selectGroup.Value();\n  if(selectedValue \u003e 0) {\n    this.cpgroupslink.DoLink()\n    this.Combobox5.Value('true');\n    this.cpgroupslink.Show();\n    this.nameGroup.Show();\n  } else {\n  \tthis.Combobox5.Value('false');\n    this.cpgroupslink.Hide();\n    this.nameGroup.Hide();\n  }\n}\n\nfunction groupnamequery_QueryExecuted(){\n  this.nameGroup.Value(Trim(this.groupnamequery.Data[0][0]))\n}\n\n\nfunction selectGroup_onChange(){\n  const selectedValue = this.selectGroup.Value();\n  const url = '\\m_cSpoofedGroup='+ selectedValue;\n  const regexSub = \u002fm_cSpoofedGroup=([0-9]+)\u002f\n  window.location.assign(window.location.href.replace(regexSub, (selectedValue \u003e 0 ? url : '')));\n  if(!window.location.href.match(regexSub) && selectedValue\u003e0) {\n  window.location.assign(window.location.href + (window.location.href.includes('?') ? '&' + url : '?' + url))\n  }\n}\n\n\nfunction cpgroupslink_GetZoomLink(offline) {\n  return ZtVWeb.SPWebRootURL+'\u002fjsp-system\u002fspadministration_groups_zoom_portlet.jsp?';\n}\n\nfunction Combobox5_onChange(){\n\tif(this.Combobox5.Value() === 'false') {\n    window.location.assign(window.location.href.split('?')[0]);\n  } else {\n  \tthis.cpgroupslink.Show();\n    this.nameGroup.Show();\n  }\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @Combobox5 }}{{ @Label6 }}","grapesCss":"","h":"108","hsl":"","htmlcode":"{{ @nameGroup }}\n{{ @cpgroupslink }}\n{{ @selectGroup }}\n{{{{ @Label6 }} @nameGroup }}\n{{ @Combobox5 }}","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"108\",\"w\":\"208\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"208","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"","hide_undercond":"true","init":"false","init_par":"request:m_cSpoofedGroup","layer":"false","layout_steps_values":"{}","maxlength":"9","name":"selectGroup","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"93","wireframe_props":"name","x":"289","y":"24","zerofilling":"false","zindex":"6","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameGroup","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"141","wireframe_props":"name","x":"20","y":"71","zerofilling":"false","zindex":"7","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectGroup,nameGroup","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"selectGroup","linkedUsing":"nameGroup","looselylinked":"false","n_criteria":"2","name":"cpgroupslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"2","servlet":"","spuid":"","suggest":"false","table":"cpgroups","type":"LinkZoom","w":"20","wireframe_props":"","x":"168","y":"71","zindex":"","zone":"","zoomtitle":"CP_GROUPS"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox5","page":"1","picture":"","rapp":"","sequence":"3","spuid":"","tabindex":"","textlist":"tutti,gruppo","type":"Combobox","typevar":"character","valuelist":"false,true","visible":"true","w":"168","wireframe_props":"name,textlist","x":"20","y":"39","zindex":"8","zone":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Modifica per:","w":"165","wireframe_props":"align,value,n_col","x":"20","y":"6","zindex":"9","zone":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:m_cSpoofedGroup*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(sp.getParameter("SpStaticCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/javascript");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
window.spadministration_select_group_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof groupnamequery_QueryExecuted !='undefined')this.groupnamequery_QueryExecuted=groupnamequery_QueryExecuted;
if(typeof selectGroup_onChange !='undefined')this.selectGroup_onChange=selectGroup_onChange;
if(typeof cpgroupslink_GetZoomLink !='undefined')this.cpgroupslink_GetZoomLink=cpgroupslink_GetZoomLink;
if(typeof Combobox5_onChange !='undefined')this.Combobox5_onChange=Combobox5_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.selectGroup);
}
this.cpgroupslink.addObserverFixedVars();
this.cpgroupslink.addLinkedUsingVars();
function this_Loaded(){
	const selectedValue = this.selectGroup.Value();
  if(selectedValue > 0) {
    this.cpgroupslink.DoLink()
    this.Combobox5.Value('true');
    this.cpgroupslink.Show();
    this.nameGroup.Show();
  } else {
  	this.Combobox5.Value('false');
    this.cpgroupslink.Hide();
    this.nameGroup.Hide();
  }
}
function groupnamequery_QueryExecuted(){
  this.nameGroup.Value(Trim(this.groupnamequery.Data[0][0]))
}
function selectGroup_onChange(){
  const selectedValue = this.selectGroup.Value();
  const url = '\m_cSpoofedGroup='+ selectedValue;
  const regexSub = /m_cSpoofedGroup=([0-9]+)/
  window.location.assign(window.location.href.replace(regexSub, (selectedValue > 0 ? url : '')));
  if(!window.location.href.match(regexSub) && selectedValue>0) {
  window.location.assign(window.location.href + (window.location.href.includes('?') ? '&' + url : '?' + url))
  }
}
function cpgroupslink_GetZoomLink(offline) {
  return ZtVWeb.SPWebRootURL+'/jsp-system/spadministration_groups_zoom_portlet.jsp?';
}
function Combobox5_onChange(){
	if(this.Combobox5.Value() === 'false') {
    window.location.assign(window.location.href.split('?')[0]);
  } else {
  	this.cpgroupslink.Show();
    this.nameGroup.Show();
  }
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.spadministration_select_group_container {
}
.spadministration_select_group_title_container {
  margin: auto;
}
.spadministration_select_group_portlet{
  position:relative;
  margin: auto;
  width:208px;
  min-width:208px;
  height:108px;
  background-color:#F3F3F3;
}
.spadministration_select_group_portlet[Data-page="1"]{
  height:108px;
  width:208px;
}
.spadministration_select_group_portlet > .selectGroup_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:24px;
  left:289px;
  width:93px;
  height:22px;
}
.spadministration_select_group_portlet > .selectGroup_ctrl {
  display:none;
}
.spadministration_select_group_portlet > .selectGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.spadministration_select_group_portlet > .nameGroup_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:71px;
  left:20px;
  width:141px;
  height:20px;
}
.spadministration_select_group_portlet > .nameGroup_ctrl {
}
.spadministration_select_group_portlet > .nameGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_select_group_portlet > .cpgroupslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:71px;
  left:168px;
  width:20px;
  height:20px;
}
.spadministration_select_group_portlet > .Combobox5_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:39px;
  left:20px;
  width:168px;
  height:22px;
}
.spadministration_select_group_portlet > .Label6_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:6px;
  left:20px;
  width:165px;
  height:auto;
  min-height:22px;
}
.spadministration_select_group_portlet > .Label6_ctrl {
  height:auto;
  min-height:22px;
}
.spadministration_select_group_portlet > .Label6_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"108\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"208\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"selectGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"93\",\"x\":\"289\",\"y\":\"24\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"141\",\"x\":\"20\",\"y\":\"71\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cpgroupslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"168\",\"y\":\"71\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"Combobox5\",\"page\":\"1\",\"textlist\":\"tutti,gruppo\",\"type\":\"Combobox\",\"w\":\"168\",\"x\":\"20\",\"y\":\"39\",\"zindex\":\"8\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Modifica per:\",\"w\":\"165\",\"x\":\"20\",\"y\":\"6\",\"zindex\":\"9\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_select_group","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_select_group_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_select_group','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double selectGroup=sp.getParameter("m_cSpoofedGroup",0);
if(request.getAttribute("spadministration_select_group_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String nameGroup= "";
if(request.getAttribute("spadministration_select_group_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Combobox5= "";
String Label6= "Modifica per:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spadministration_select_group_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_select_group_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_select_group','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_selectGroup_wrp'><input id='<%=idPortlet%>_selectGroup' name='selectGroup' type='text' maxlength='9' class='textbox' formid='<%=idPortlet%>' ps-name='selectGroup' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameGroup_wrp'><input id='<%=idPortlet%>_nameGroup' name='nameGroup' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameGroup' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cpgroupslink'" ) );%>
<select id='<%=idPortlet%>_Combobox5' name='Combobox5' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label6'  formid='<%=idPortlet%>' ps-name='Label6'    class='label Label6_ctrl'><div id='<%=idPortlet%>_Label6tbl' style='width:100%;'><%=JSPLib.ToHTML("Modifica per:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_select_group');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_select_group',["208"],["108"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"208","h":"108","title":"","layer":""}]);
this.selectGroup=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"","hide":"","hide_undercond":"true","init":"false","init_par":"request:m_cSpoofedGroup","layer":false,"layout_steps_values":{},"maxlength":"9","name":"selectGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectGroup%>","w":93,"x":289,"y":24,"zerofilling":false,"zindex":"6","zoom":""});
this.nameGroup=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameGroup,false,true)%>","w":141,"x":20,"y":71,"zerofilling":false,"zindex":"7","zoom":""});
this.cpgroupslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_cpgroupslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_select_group_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"selectGroup,nameGroup","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_select_group_portlet.jspcpgroupslink",request.getSession())%>","linkedField":"selectGroup","linkedUsing":"nameGroup","looselylinked":false,"n_criteria":"2","name":"cpgroupslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":false,"table":"cpgroups","type":"LinkZoom","w":20,"x":168,"y":71,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>"});
this.Combobox5=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox5","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox5%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox5","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"tutti,gruppo","type":"Combobox","typevar":"character","valuelist":"false,true","visible":true,"w":168,"x":20,"y":39,"zindex":"8"});
this.Label6=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6,false,true)%>","type":"Label","w":165,"x":20,"y":6,"zindex":"9"});
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
<%if(request.getAttribute("spadministration_select_group_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("spadministration_select_group_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.spadministration_select_group_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Combobox5.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_select_group',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_select_group');
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
sp.endPage("spadministration_select_group");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"cpgroupslink")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpgroups";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"code", "name"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "2869443649"; } %>