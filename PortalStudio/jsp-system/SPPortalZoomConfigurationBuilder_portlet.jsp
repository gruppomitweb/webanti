<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u003c% %\u003e\nthis.lblSaving.Hide();\n\nvar useImgs=this.UseImages.Value();\nthis.UseImages.typevar='logic';\nthis.UseImages.type='L';\nif(EmptyString(useImgs)){\n  this.UseImages.Value(true);\n}\n\nvar showSaveBtn=this.showSaveBtn.Value();\nthis.showSaveBtn.typevar='logic';\nthis.showSaveBtn.type='L';\nif(EmptyString(showSaveBtn)){\n  this.showSaveBtn.Value(true);\n}\nif(!this.showSaveBtn.Value()){\n  this.btnSave.Hide();\n}\n\nif(this.UseImages.Value()){\n  this.btnSave.Value('');\n  var css=LibJavascript.CssClassNameUtils;\n  css.removeClass(this.btnSave.Ctrl,'PortalZoomParams_Button');\n  css.addClass(this.btnSave.Ctrl,'PortalZoomParams_ImgButton');\n  css.addClass(this.btnSave.Ctrl,'PortalZoomParams_SaveVZM');\n  this.btnSave.Ctrl.style.width=22;\n}\nfunction btnSave_Click(){\n  this.Save();\n}\n\nfunction SaveFilters(container, overwriteFnc) {\n  if(!container)\n    container = this.container;\n\n  if(this.clearHide)\n    window.clearTimeout(this.clearHide)\n\n\tvar configuration={};\n  var parameters=[];\n  parameters.push('m_cAction=save');\n\n  container.GetFiltersConfiguration(configuration);\n  \n  this.SaveConfiguration(container,configuration, parameters);\n}\nfunction Save(container, overwriteFnc){\n  if(!container)\n    container = this.container;\n\n  if(this.clearHide)\n    window.clearTimeout(this.clearHide)\n\n  this.btnSave.Hide();\n  this.lblSaving.Value(\"Saving...\");\n  this.lblSaving.Show()\n  LibJavascript.CssClassNameUtils.addClass(this.Ctrl,'loading');\n\tvar configuration={};\n  var parameters=[];\n  if (! (!container.VQRName || EmptyString(container.VQRName.Value())) ) {\n  \tparameters.push('VQRName='+container.VQRName.Value()); \u002f\u002fParametri da VQR\n  }\n  \n  container.GetDataSave(configuration);\n  container.RowsParamValid=false;\n  var isVqr = container.Vqr && !EmptyString(container.Vqr.Value());\n  parameters.push('m_cAction='+\n    (!EmptyString(configuration.Action) && configuration.Action.match(\u002f(new)|(save)\u002fi) ? \n      configuration.Action.toLowerCase() : \n      (isVqr ?\n        \"new\" : \n        \"save\"\n      )\n  ));\n\n  if (!EmptyString(configuration.SourceConfigName) ) {\n    parameters.push( 'sourceConfigName='+configuration.SourceConfigName );\n  }\n  if (isVqr) {\n    parameters.push('vqr='+container.Vqr.Value());\n  } else if(!EmptyString(configuration.VQRName)){\n    parameters.push('vqr='+configuration.VQRName);\n  }\n\n  var srcCfgName_tmp,action_tmp,vqr_tmp;\n  if(\"SourceConfigName\" in configuration){\n    srcCfgName_tmp=configuration.SourceConfigName;\u002f\u002fpoi lo cancella\n    delete configuration.SourceConfigName;\u002f\u002fper non mandarlo nell'oggetto json\n  }\n  if(\"Action\" in configuration){\n    action_tmp=configuration.Action;\u002f\u002fpoi lo cancella\n    delete configuration.Action;\u002f\u002fper non mandarlo nell'oggetto json\n  }\n  if(\"VQRName\" in configuration){\n    vqr_tmp=configuration.VQRName;\u002f\u002fpoi lo cancella\n    delete configuration.VQRName;\u002f\u002fper non mandarlo nell'oggetto json\n  }\n  configuration.Configuration=configuration.Configuration||{}; \u002f\u002fcrea un oggetto configuration all'interno dell'oggetto json da inviare\n  if(\"GridRows\" in configuration){\n    configuration.Configuration.GridRows = configuration.GridRows;\n    delete configuration.GridRows;\n  }\n  if(\"OrderBy\" in configuration){\n    configuration.Configuration.OrderBy = configuration.OrderBy;\n    delete configuration.OrderBy;\n  }\n  if(\"CountRows\" in configuration){\n    configuration.Configuration.CountRows = configuration.CountRows;\n    delete configuration.CountRows;\n  }\n\n  this.SaveConfiguration(container,configuration, parameters);\n\n  if(srcCfgName_tmp){\n    configuration.SourceConfigName=srcCfgName_tmp;\n  }\n  if(action_tmp){\n    configuration.Action=action_tmp;\n  }\n  if(vqr_tmp){\n    configuration.VQRName=vqr_tmp;\n  }\n\n}\n\nfunction SaveConfiguration(container,configuration, parameters) {\n  var cfgName_tmp;\n  var pTable = '&table='+container.Table.Value();\n\tvar pConfigName = '&configname='+\n    (EmptyString(configuration.ConfigName) ? \n      (EmptyString(container.ConfigName.Value()) ? \n        'default' : \n        container.ConfigName.Value()) :\n    configuration.ConfigName\n  );\n  var pUserConfig='';\n  if(\"Custom\" in configuration){\n    pUserConfig += \"&Custom=\" +configuration.Custom;\n    delete configuration.Custom;\n  }\n  if(\"User\" in configuration){\n    pUserConfig += \"&NewUser=\" +configuration.User;\n    delete configuration.User;\n  }\n  if(\"Group\" in configuration){\n    pUserConfig += \"&NewGroup=\" +configuration.Group;\n    delete configuration.Group;\n  }\n  var pOfflineMode='';\n  if (container.offlinemode) {\n  \tpOfflineMode='&offlinemode='+container.offlinemode.Value();\n  }\n  if(\"ConfigName\" in configuration){\n    cfgName_tmp=configuration.ConfigName;\u002f\u002fpoi lo cancella\n    delete configuration.ConfigName;\u002f\u002fper non mandarlo nell'oggetto json\n  }\n  var pConfig = '&config='+URLenc(toJSONString(configuration));\n  var callback = this.formid+'.saved';\n\tvar url=\"..\u002fservlet\u002fSPVZMProxy?\"+pTable+pConfigName+pUserConfig+pConfig+pOfflineMode+(parameters.length\u003e0?'&'+parameters.join('&'):'') +\n  \t\t\"&m_cID=\" + '\u003c%=JSPLib.cmdHash(\"VisualZoom\", request.getSession())%\u003e';\n \tnew ZtVWeb.JSURL(url, true, callback).Response();\n\n  if(cfgName_tmp){\n    configuration.ConfigName=cfgName_tmp;\n  }\n}\nfunction saved(useless,result){\n  result=eval(\"(\"+result+\")\");\n  if(!result.OK){\n    alert(result.ERROR);\n  }\n\n  this.lblSaving.Value(\"Saved\");\n  LibJavascript.CssClassNameUtils.removeClass(this.Ctrl,'loading');\n  if(this.showSaveBtn.Value())\n    this.btnSave.Show();\n  var _this=this;\n  this.clearHide=window.setTimeout(function(){\n      _this.lblSaving.Hide();\n      _this=null;\n    }, 1000);\n  this.container.dispatchEvent(result.OK?'SaveOk':'SaveFailed');\n  this.container.dispatchEvent('SaveEnd');\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @btnSave }}{{ @lblSaving }}\u003c\u002fbody\u003e","grapesCss":"","h":"25","hsl":"","htmlcode":"{{ @btnSave }} \n{{ @lblSaving }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"undefined","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"json.js","offline":"","on_security_failure":"empty","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"25\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"profiled","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"130","version":"37","w":"100%","wizard":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"1","class_Css":"PortalZoomParams_Button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"MSG_VZM_SAVE","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnSave","page":"1","rapp":"","sequence":"1","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_VZM_SAVE","w":"55","wireframe_props":"value","x":"72","y":"0","zindex":"1","zone":""},{"align":"","anchor":"top-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSaving","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Saving...","w":"55","wireframe_props":"align,value,n_col","x":"9","y":"2","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"showSaveBtn","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"100","x":"0","y":"-26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"UseImages","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"100","x":"0","y":"-49"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SaveCfg","objsValues":"this.Save(evt.configHolder)","page":"1","parmsNames":"configHolder","sequence":"5","type":"EventReceiver","w":"22","x":"103","y":"-25"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:showSaveBtn,UseImages*/%>
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
.SPPortalZoomConfigurationBuilder_container {
}
.SPPortalZoomConfigurationBuilder_title_container {
  margin: auto;
}
.SPPortalZoomConfigurationBuilder_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:130px;
  height:25px;
}
.SPPortalZoomConfigurationBuilder_portlet[Data-page="1"]{
  height:25px;
  width:100%;
}
.SPPortalZoomConfigurationBuilder_portlet > .btnSave_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  right:3px;
  width:55px;
  height:24px;
}
.SPPortalZoomConfigurationBuilder_portlet > .btnSave_ctrl {
  border-width:1px;
}
.SPPortalZoomConfigurationBuilder_portlet > .lblSaving_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:2px;
  right:66px;
  width:55px;
  height:auto;
  min-height:24px;
}
.SPPortalZoomConfigurationBuilder_portlet > .lblSaving_ctrl {
  height:auto;
  min-height:24px;
}
.SPPortalZoomConfigurationBuilder_portlet > .lblSaving_ctrl {
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
 String def="[{\"h\":\"25\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"130\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_VZM_SAVE\",\"w\":\"55\",\"x\":\"72\",\"y\":\"0\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Saving...\",\"w\":\"55\",\"x\":\"9\",\"y\":\"2\",\"zindex\":\"1\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"0\",\"y\":\"-26\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"0\",\"y\":\"-49\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"103\",\"y\":\"-25\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomConfigurationBuilder","UTF-8")) {return; }
 %><%if(!sp.isLogged()){
if (true) return;
}%>
<%if(!sp.CanAccess("ps/SPPortalZoomConfigurationBuilder")){%><%if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomConfigurationBuilder_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomConfigurationBuilder','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblSaving= "Saving...";
String showSaveBtn=JSPLib.translateXSS(sp.getParameter("showSaveBtn",""));
String UseImages=JSPLib.translateXSS(sp.getParameter("UseImages",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomConfigurationBuilder_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomConfigurationBuilder_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomConfigurationBuilder','<%=idPortlet%>',true,'');
</script><%}}%>
<input id='<%=idPortlet%>_btnSave' type='button' class='PortalZoomParams_Button btnSave_ctrl'/>
<span id='<%=idPortlet%>_lblSaving'  formid='<%=idPortlet%>' ps-name='lblSaving'    class='label lblSaving_ctrl'><div id='<%=idPortlet%>_lblSavingtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Saving..."))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomConfigurationBuilder');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomConfigurationBuilder',["130"],["25"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"130","h":"25","title":"","layer":""}]);
this.btnSave=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"1","class_Css":"PortalZoomParams_Button btnSave_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnSave","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_VZM_SAVE"),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnSave","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_VZM_SAVE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":72,"y":0,"zindex":"1"});
this.lblSaving=new ZtVWeb._LC(this,{"align":"","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSaving","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSaving","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblSaving),false,true)%>","type":"Label","w":55,"x":9,"y":2,"zindex":"1"});
this.showSaveBtn=new ZtVWeb._VC(this,'showSaveBtn',null,'character','<%=JSPLib.ToJSValue(showSaveBtn,false,true)%>',false,false);
this.UseImages=new ZtVWeb._VC(this,'UseImages',null,'character','<%=JSPLib.ToJSValue(UseImages,false,true)%>',false,false);
this.SaveCfg=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SaveCfg","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SaveCfg","objsValues":"this.Save(evt.configHolder)","page":1,"parmsNames":"configHolder","type":"EventReceiver","w":22,"x":103,"y":-25});
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
<%request.setAttribute("SPPortalZoomConfigurationBuilder_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomConfigurationBuilder_Static=function(){
if(typeof btnSave_Click !='undefined')this.btnSave_Click=btnSave_Click;
if(typeof SaveFilters !='undefined')this.SaveFilters=SaveFilters;
if(typeof Save !='undefined')this.Save=Save;
if(typeof SaveConfiguration !='undefined')this.SaveConfiguration=SaveConfiguration;
if(typeof saved !='undefined')this.saved=saved;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}
 %>
this.lblSaving.Hide();
var useImgs=this.UseImages.Value();
this.UseImages.typevar='logic';
this.UseImages.type='L';
if(EmptyString(useImgs)){
  this.UseImages.Value(true);
}
var showSaveBtn=this.showSaveBtn.Value();
this.showSaveBtn.typevar='logic';
this.showSaveBtn.type='L';
if(EmptyString(showSaveBtn)){
  this.showSaveBtn.Value(true);
}
if(!this.showSaveBtn.Value()){
  this.btnSave.Hide();
}
if(this.UseImages.Value()){
  this.btnSave.Value('');
  var css=LibJavascript.CssClassNameUtils;
  css.removeClass(this.btnSave.Ctrl,'PortalZoomParams_Button');
  css.addClass(this.btnSave.Ctrl,'PortalZoomParams_ImgButton');
  css.addClass(this.btnSave.Ctrl,'PortalZoomParams_SaveVZM');
  this.btnSave.Ctrl.style.width=22;
}
function btnSave_Click(){
  this.Save();
}
function SaveFilters(container, overwriteFnc) {
  if(!container)
    container = this.container;
  if(this.clearHide)
    window.clearTimeout(this.clearHide)
	var configuration={};
  var parameters=[];
  parameters.push('m_cAction=save');
  container.GetFiltersConfiguration(configuration);
  
  this.SaveConfiguration(container,configuration, parameters);
}
function Save(container, overwriteFnc){
  if(!container)
    container = this.container;
  if(this.clearHide)
    window.clearTimeout(this.clearHide)
  this.btnSave.Hide();
  this.lblSaving.Value("Saving...");
  this.lblSaving.Show()
  LibJavascript.CssClassNameUtils.addClass(this.Ctrl,'loading');
	var configuration={};
  var parameters=[];
  if (! (!container.VQRName || EmptyString(container.VQRName.Value())) ) {
  	parameters.push('VQRName='+container.VQRName.Value()); //Parametri da VQR
  }
  
  container.GetDataSave(configuration);
  container.RowsParamValid=false;
  var isVqr = container.Vqr && !EmptyString(container.Vqr.Value());
  parameters.push('m_cAction='+
    (!EmptyString(configuration.Action) && configuration.Action.match(/(new)|(save)/i) ? 
      configuration.Action.toLowerCase() : 
      (isVqr ?
        "new" : 
        "save"
      )
  ));
  if (!EmptyString(configuration.SourceConfigName) ) {
    parameters.push( 'sourceConfigName='+configuration.SourceConfigName );
  }
  if (isVqr) {
    parameters.push('vqr='+container.Vqr.Value());
  } else if(!EmptyString(configuration.VQRName)){
    parameters.push('vqr='+configuration.VQRName);
  }
  var srcCfgName_tmp,action_tmp,vqr_tmp;
  if("SourceConfigName" in configuration){
    srcCfgName_tmp=configuration.SourceConfigName;//poi lo cancella
    delete configuration.SourceConfigName;//per non mandarlo nell'oggetto json
  }
  if("Action" in configuration){
    action_tmp=configuration.Action;//poi lo cancella
    delete configuration.Action;//per non mandarlo nell'oggetto json
  }
  if("VQRName" in configuration){
    vqr_tmp=configuration.VQRName;//poi lo cancella
    delete configuration.VQRName;//per non mandarlo nell'oggetto json
  }
  configuration.Configuration=configuration.Configuration||{}; //crea un oggetto configuration all'interno dell'oggetto json da inviare
  if("GridRows" in configuration){
    configuration.Configuration.GridRows = configuration.GridRows;
    delete configuration.GridRows;
  }
  if("OrderBy" in configuration){
    configuration.Configuration.OrderBy = configuration.OrderBy;
    delete configuration.OrderBy;
  }
  if("CountRows" in configuration){
    configuration.Configuration.CountRows = configuration.CountRows;
    delete configuration.CountRows;
  }
  this.SaveConfiguration(container,configuration, parameters);
  if(srcCfgName_tmp){
    configuration.SourceConfigName=srcCfgName_tmp;
  }
  if(action_tmp){
    configuration.Action=action_tmp;
  }
  if(vqr_tmp){
    configuration.VQRName=vqr_tmp;
  }
}
function SaveConfiguration(container,configuration, parameters) {
  var cfgName_tmp;
  var pTable = '&table='+container.Table.Value();
	var pConfigName = '&configname='+
    (EmptyString(configuration.ConfigName) ? 
      (EmptyString(container.ConfigName.Value()) ? 
        'default' : 
        container.ConfigName.Value()) :
    configuration.ConfigName
  );
  var pUserConfig='';
  if("Custom" in configuration){
    pUserConfig += "&Custom=" +configuration.Custom;
    delete configuration.Custom;
  }
  if("User" in configuration){
    pUserConfig += "&NewUser=" +configuration.User;
    delete configuration.User;
  }
  if("Group" in configuration){
    pUserConfig += "&NewGroup=" +configuration.Group;
    delete configuration.Group;
  }
  var pOfflineMode='';
  if (container.offlinemode) {
  	pOfflineMode='&offlinemode='+container.offlinemode.Value();
  }
  if("ConfigName" in configuration){
    cfgName_tmp=configuration.ConfigName;//poi lo cancella
    delete configuration.ConfigName;//per non mandarlo nell'oggetto json
  }
  var pConfig = '&config='+URLenc(toJSONString(configuration));
  var callback = this.formid+'.saved';
	var url="../servlet/SPVZMProxy?"+pTable+pConfigName+pUserConfig+pConfig+pOfflineMode+(parameters.length>0?'&'+parameters.join('&'):'') +
  		"&m_cID=" + '<%=JSPLib.cmdHash("VisualZoom", request.getSession())%>';
 	new ZtVWeb.JSURL(url, true, callback).Response();
  if(cfgName_tmp){
    configuration.ConfigName=cfgName_tmp;
  }
}
function saved(useless,result){
  result=eval("("+result+")");
  if(!result.OK){
    alert(result.ERROR);
  }
  this.lblSaving.Value("Saved");
  LibJavascript.CssClassNameUtils.removeClass(this.Ctrl,'loading');
  if(this.showSaveBtn.Value())
    this.btnSave.Show();
  var _this=this;
  this.clearHide=window.setTimeout(function(){
      _this.lblSaving.Hide();
      _this=null;
    }, 1000);
  this.container.dispatchEvent(result.OK?'SaveOk':'SaveFailed');
  this.container.dispatchEvent('SaveEnd');
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomConfigurationBuilder_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SaveCfg=function(parmsObj){<%=idPortlet%>.SaveCfg.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomConfigurationBuilder',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomConfigurationBuilder');
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
sp.endPage("SPPortalZoomConfigurationBuilder");
}%>
<%! public String getJSPUID() { return "192482902"; } %>