<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u002f\u002f includo portalstudio.css del tema iMobile per rendere bene il portlet\nZtVWeb.RequireCSS(\"iMobile\u002fportalstudio.css\");\n\nfunction this_Loaded(){\n  LibJavascript.CssClassNameUtils.addClass(document.body, 'mobile');\n  document.documentElement.style.height = \"100%\";\n  document.body.style.height = \"100%\";\n  document.body.style.background = this.Ctrl.style.background;\n\tthis.typeOfApps.Value(\u003c%=JSPLib.ToJSValue(\"offline\".equals(modstore) ? \"Offline\" : \"Online\", true)%\u003e);\n  this.typeOfApps.Hide();\n}\n\nfunction apprepeater_LoadedAjax(){\n  if ( this.apprepeater.GetRecordNumber()\u003c=0 ) { \u002f\u002f non ci sono app\n    this.typeOfApps.Hide();\n  }\n}\n\n\u002f\u002fthis.apprepeater.loadAJAXcontent(#cPortlet#,#cQuery#,#cParameters#,#cFields#,#cVars#,#n_row#,#n_col,#nMax_rec#,#nCurrPage#,#npages_next#,#cXml_source#,cXml_root)\nthis.apprepeater.loadAJAXcontent(null,\u003c%=JSPLib.ToJSValue(\"offline\".equals(modstore) ? \"gsso_qapplist\" : \"spma_qgetinfo\", true)%\u003e);\n\n                                 \n                                 ","bg_image":" ","cache_in_post":"false","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"75","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"320","version":"37","w":"100%"},{"ajax_mode":"true","ajax_mode_autoexec":"false","align":"center","anchor":"top-left-right","css_class_name":"enterpriseappstore","fields":"OAAPPLOGO,OADESCRI,OAAPPPLAN,OAAPPTITLE,OAAPPACCESSMODE,modstore,OAAPPREQREG,OAAPPURLREG,OA__CODE","floating":"true","h":"73","max_row":"100","n_col":"1","n_pages":"0","n_row":"all","name":"apprepeater","navbar":"false","nextHTML":" ","page":"1","parameters":" ","portlet":"spas_item_applist_portlet.jsp","prevHTML":" ","query":" ","sequence":"5","stretch":"false","type":"Repeat","valign":"center","w":"320","x":"0","xml_root":" ","xml_source":" ","y":"0"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":"request","name":"modstore","page":"1","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"345","y":"46"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label_title","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":"#FFFFFF","font_size":" ","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"typeOfApps","nowrap":"false","page":"1","picture":" ","sequence":"26","server_side":" ","tabindex":" ","target":" ","type":"Label","value":" ","w":"69","x":"345","y":"17","zindex":"1"}]%>
<%/*Description: */%>
<%/*ParamsRequest:modstore*/%>
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
.spas_ptlapplist_container {
}
.spas_ptlapplist_portlet{
  position:relative;
  width:100%;
  min-width:320px;
  height:75px;
}
.spas_ptlapplist_portlet[Data-page="1"]{
  height:75px;
  width:100%;
}
.spas_ptlapplist_portlet > .apprepeater_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:73px;
}
.spas_ptlapplist_portlet > .typeOfApps_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:345px;
  width:69px;
  height:auto;
  min-height:19px;
}
.spas_ptlapplist_portlet > .typeOfApps_ctrl {
  height:auto;
  min-height:19px;
}
.spas_ptlapplist_portlet > .typeOfApps_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#FFFFFF;
  text-align:left;
  background-color:transparent;
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
 String def="[{\"h\":\"75\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"320\",\"w\":\"100%\"},{\"anchor\":\"top-left-right\",\"h\":\"73\",\"page\":\"1\",\"type\":\"Repeat\",\"w\":\"320\",\"x\":\"0\",\"y\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"345\",\"y\":\"46\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"345\",\"y\":\"17\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_ptlapplist","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_ptlapplist_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spas_ptlapplist','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spas_ptlapplist_firstinclusion")==null){%>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("slootoom.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("zfx.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("RepeatObj.js")%>'></script>
<%}
String modstore=JSPLib.translateXSS(sp.getParameter("modstore",""));
String typeOfApps= " ";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spas_ptlapplist_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spas_ptlapplist_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spas_ptlapplist','<%=idPortlet%>',false,' ');
</script><%}}

if(request.getAttribute("CtrlCounter")!=null)
  request.setAttribute("CtrlCounter",(Integer)request.getAttribute("CtrlCounter")+1);
else
  request.setAttribute("CtrlCounter",1);
int apprepeater_Counter=(Integer)request.getAttribute("CtrlCounter");
%><%int n_record_apprepeater=0;%>
<div id='<%=idPortlet%>_apprepeater' class='repeater enterpriseappstore'>
<div id='<%=idPortlet%>_apprepeater_wrapper' class='repeater_wrapper' style='position:relative;float:left;width:100%;'></div>
</div>
<span id='<%=idPortlet%>_typeOfApps'  formid='<%=idPortlet%>' ps-name='typeOfApps'    class='label_title typeOfApps_ctrl'><div id='<%=idPortlet%>_typeOfAppstbl' style='width:100%;'> </div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spas_ptlapplist');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spas_ptlapplist',["320"],["75"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"320","h":"75","title":" ","layer":"false","npage":"1"}]);
this.apprepeater=new ZtVWeb.RepeatCtrl(this,'<%=idPortlet%>_apprepeater','apprepeater',73,0,320,0,-1,true,'false','spas_item_applist_portlet.jsp',' ',' ','OAAPPLOGO,OADESCRI,OAAPPPLAN,OAAPPTITLE,OAAPPACCESSMODE,OAAPPREQREG,OAAPPURLREG,OA__CODE','modstore','<%=0%>',1,100,1,0,'','','true','top-left-right',{},'<%=JSPLib.cmdHash("spas_item_applist_portlet.jsp",session)%>');
this.modstore=new ZtVWeb._VC(this,'modstore',null,'character','<%=JSPLib.ToJSValue(modstore,false,true)%>',false,false);
this.typeOfApps=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label_title","create_undercond":" ","ctrlid":"<%=idPortlet%>_typeOfApps","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":"#FFFFFF","font_size":" ","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"typeOfApps","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(typeOfApps,false,true)%>","type":"Label","w":69,"x":345,"y":17,"zindex":"1"});
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
<%request.setAttribute("spas_ptlapplist_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spas_ptlapplist_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof apprepeater_LoadedAjax !='undefined')this.apprepeater_LoadedAjax=apprepeater_LoadedAjax;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
// includo portalstudio.css del tema iMobile per rendere bene il portlet
ZtVWeb.RequireCSS("iMobile/portalstudio.css");
function this_Loaded(){
  LibJavascript.CssClassNameUtils.addClass(document.body, 'mobile');
  document.documentElement.style.height = "100%";
  document.body.style.height = "100%";
  document.body.style.background = this.Ctrl.style.background;
	this.typeOfApps.Value(<%=JSPLib.ToJSValue("offline".equals(modstore) ? "Offline" : "Online", true)%>);
  this.typeOfApps.Hide();
}
function apprepeater_LoadedAjax(){
  if ( this.apprepeater.GetRecordNumber()<=0 ) { // non ci sono app
    this.typeOfApps.Hide();
  }
}
//this.apprepeater.loadAJAXcontent(#cPortlet#,#cQuery#,#cParameters#,#cFields#,#cVars#,#n_row#,#n_col,#nMax_rec#,#nCurrPage#,#npages_next#,#cXml_source#,cXml_root)
this.apprepeater.loadAJAXcontent(null,<%=JSPLib.ToJSValue("offline".equals(modstore) ? "gsso_qapplist" : "spma_qgetinfo", true)%>);
                                 
                                 
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spas_ptlapplist_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','spas_ptlapplist',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spas_ptlapplist');
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
sp.endPage("spas_ptlapplist");
}%>
<%! public String getJSPUID() { return "3346636056"; } %>