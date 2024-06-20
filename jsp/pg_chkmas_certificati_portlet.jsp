<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Controllo Massivo Certificati',true) \n  this.getTitlePortlet().AppendButton({\n    id:\"chkmass\",\n    title:FormatMsg('Check'),\n    tooltip:FormatMsg('Controlla i certificati delle aziende presenti'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb5c\"},\n    action:'javascript:' + this.formid +'.ChkMas()'\n  },1);    \n}\n\nfunction ChkMas() {\n  if(confirm(\"Confermi il controllo massivo dei certificati?\")) {\n    this.pMsg.Timer0.Start();\n    this.pLog.Timer0.Start();\n    this.RTChkMas.Link()\n  }  \n}  \n\nfunction RTChkMas_Executed(result,cError){\n  this.pMsg.Timer0_onTimer();\n  this.pLog.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0.Stop();    \n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Controllo Massivo Certificati","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","htmlcode":"{{ @pMsg }} \n{{ @pLog }} \n\n\n\n\n\n\n\n\n\n\n\n{{ Label25_Copy }}\n{{ A_Data }}\n{{ fModel }}\n{{ autril }}\n{{ numdoc }}\n{{ datril }}\n{{ docsca }}\n{{ RTEsegui }}\n{{ Label0 }}\n{{ pMsg }}\n{{ Label1 }}{{ fType }}\n{{ Combobox_anno }}\n{{ Combobox_tr{{ DaData }}imestre }}{{ tipdoc }}\n{{ RTUscita }}\n{{ Image_esegui_estrazione }}{{ Calendario24 }}{{ gDescAzi }}\n{{ RTEstrazione{{ Label25 }}_trimestrale }}\n{{ RTAzzera }}\n{{ Label_nota }}\n{{ Label_nota2 }}\n{{ pLog }}\n{{ btnExit }}\n{{ Label_periodo }}\n{{ Image_download }}\n{{ RTDownload }}\n{{ nomeFile }}\n{{ RTCheck }}\n{{ Check }}\n{{ last_run }}\n{{ last_anno }}\n{{ last_trim }}\n{{ iPrint }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"400","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"900","wizard":""},{"anchor":"","ctrlOfVariant":"","h":"67","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"1","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"900","wireframe_props":"","x":"0","y":"8","zindex":"3"},{"allowedentities":"arfn_chkmass_certificati","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChkMas","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"arfn_chkmass_certificati","target":"","type":"SPLinker","w":"120","x":"926","y":"12"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","h":"156","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"20","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"900","wireframe_props":"","x":"0","y":"76","zindex":"3"}]%>
<%/*Description:Controllo Massivo Certificati*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
window.pg_chkmas_certificati_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof ChkMas !='undefined')this.ChkMas=ChkMas;
if(typeof RTChkMas_Executed !='undefined')this.RTChkMas_Executed=RTChkMas_Executed;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Controllo Massivo Certificati',true) 
  this.getTitlePortlet().AppendButton({
    id:"chkmass",
    title:FormatMsg('Check'),
    tooltip:FormatMsg('Controlla i certificati delle aziende presenti'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb5c"},
    action:'javascript:' + this.formid +'.ChkMas()'
  },1);    
}
function ChkMas() {
  if(confirm("Confermi il controllo massivo dei certificati?")) {
    this.pMsg.Timer0.Start();
    this.pLog.Timer0.Start();
    this.RTChkMas.Link()
  }  
}  
function RTChkMas_Executed(result,cError){
  this.pMsg.Timer0_onTimer();
  this.pLog.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0.Stop();    
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
.pg_chkmas_certificati_container {
  height:100%;
  overflow:auto;
}
.pg_chkmas_certificati_title_container {
  margin: auto;
}
.pg_chkmas_certificati_portlet{
  position:relative;
  margin: auto;
  width:900px;
max-width:400px;
  min-width:900px;
  height:100%;
}
.pg_chkmas_certificati_portlet[Data-page="1"]{
  height:100%;
  width:900px;
}
.pg_chkmas_certificati_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:8px;
  left:0px;
  width:900px;
  height:auto;
  min-height:67px;
}
.pg_chkmas_certificati_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:76px;
  left:0px;
  right:0px;
  bottom:68px;
  width:900px;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"900\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"67\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"900\",\"x\":\"0\",\"y\":\"8\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"926\",\"y\":\"12\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"156\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"900\",\"x\":\"0\",\"y\":\"76\",\"zindex\":\"3\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_chkmas_certificati","UTF-8")) {return; }
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
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_chkmas_certificati_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_chkmas_certificati','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_chkmas_certificati_title_container' style='width:900px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_chkmas_certificati_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_chkmas_certificati_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_chkmas_certificati','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_chkmas_certificati');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Check",true)+","+JSPLib.ToJSValue(sp.translate("Check"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Controlla i certificati delle aziende presenti",true)+","+JSPLib.ToJSValue(sp.translate("Controlla i certificati delle aziende presenti"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_chkmas_certificati',["900"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"300","title":"","layer":"false","npage":"1"}]);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left","ctrlid":"<%=idPortlet%>_pMsg","h":67,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":900,"x":0,"y":8,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.RTChkMas=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_chkmass_certificati",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChkMas","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChkMas","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_chkmass_certificati","target":"","type":"SPLinker","w":120,"x":926,"y":12});
this.RTChkMas.m_cID='<%=JSPLib.cmdHash("routine,arfn_chkmass_certificati",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_pLog","h":156,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":900,"x":0,"y":76,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
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
<%if(request.getAttribute("pg_chkmas_certificati_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_chkmas_certificati_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_chkmas_certificati_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_chkmas_certificati',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_chkmas_certificati');
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
sp.endPage("pg_chkmas_certificati");
}%>
<%! public String getJSPUID() { return "2818204780"; } %>