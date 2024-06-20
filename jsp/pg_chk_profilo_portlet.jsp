<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Image_esegui_estrazione_Click(){\n  if(confirm(\"Confermi la stampa?\")) {\n    this.fType.Value(\"PDF|XLSX|CSV\")\n    this.fModel.Value(\"||\")\n    this.RTEsegui.Link()\n  }\n}\n\nfunction btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Soggetti con\u002fsenza profilo di rischio',true)\n  this.RTAzzera.Link();\n}","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"310","hsl":"","htmlcode":"{{ @Label14 }}\n{{ @cmbSoggetti }}\n\n\n\n{{ @iPrint }}\n{{ @btnExit }}\n{{ @Image_esegui_estrazione }}\n\n{{ Label25_Copy }}\n{{ A_Data }}\n{{ fModel }}\n{{ autril }}\n{{ numdoc }}\n{{ datril }}\n{{ docsca }}\n{{ RTEsegui }}\n{{ Label0 }}\n{{ pMsg }}\n{{ Label1 }}{{ fType }}\n{{ Combobox_anno }}\n{{ Combobox_tr{{ DaData }}imestre }}{{ tipdoc }}\n{{ RTUscita }}\n{{ Image_esegui_estrazione }}{{ Calendario24 }}{{ gDescAzi }}\n{{ RTEstrazione{{ Label25 }}_trimestrale }}\n{{ RTAzzera }}\n{{ Label_nota }}\n{{ Label_nota2 }}\n{{ pLog }}\n{{ btnExit }}\n{{ Label_periodo }}\n{{ Image_download }}\n{{ RTDownload }}\n{{ nomeFile }}\n{{ RTCheck }}\n{{ Check }}\n{{ last_run }}\n{{ last_anno }}\n{{ last_trim }}\n{{ iPrint }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"400","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa Soggetti con\u002fsenza profilo di rischio","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"900","wizard":""},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"1","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"977","y":"2"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb4a;","font_image_hover":"&#xeb4b;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_esegui_estrazione","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"826","y":"13","zindex":"5"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"980","y":"-24"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"4","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"861","y":"13","zindex":"1"},{"anchor":"top-left-right","auto_resize":"false","border":"true","default_portlet":"","h":"250","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"5","spuid":"","type":"Iframe","w":"900","wireframe_props":"","x":"0","y":"52","zindex":"6"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTEsegui","offline":"false","page":"1","parms":"ReportName=operp_chk_profilo.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pTipo=cmbSoggetti,formatModels=fModel","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"6","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"979","y":"26"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"979","y":"48"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fType","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"983","y":"74"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fModel","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"980","y":"103"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"T","layer":"false","layout_steps_values":"{}","name":"cmbSoggetti","page":"1","picture":"","sequence":"10","spuid":"","tabindex":"","textlist":"Tutti, Solo con Profilo, Solo senza Profilo","type":"Combobox","typevar":"character","valuelist":"T,C,S","visible":"true","w":"307","wireframe_props":"name,textlist","x":"246","y":"20","zindex":"7"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipologia di soggetti da estrarre:","w":"240","wireframe_props":"align,value,n_col","x":"0","y":"20","zindex":"8"}]%>
<%/*Description:*/%>
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
window.pg_chk_profilo_Static=function(){
if(typeof Image_esegui_estrazione_Click !='undefined')this.Image_esegui_estrazione_Click=Image_esegui_estrazione_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function Image_esegui_estrazione_Click(){
  if(confirm("Confermi la stampa?")) {
    this.fType.Value("PDF|XLSX|CSV")
    this.fModel.Value("||")
    this.RTEsegui.Link()
  }
}
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Stampa Soggetti con/senza profilo di rischio',true)
  this.RTAzzera.Link();
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
.pg_chk_profilo_container {
  height:100%;
  overflow:auto;
}
.pg_chk_profilo_title_container {
  margin: auto;
}
.pg_chk_profilo_portlet{
  position:relative;
  margin: auto;
  width:900px;
max-width:400px;
  min-width:900px;
  height:100%;
}
.pg_chk_profilo_portlet[Data-page="1"]{
  height:100%;
  width:900px;
}
.pg_chk_profilo_portlet > .Image_esegui_estrazione_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:13px;
  left:826px;
  width:30px;
  height:30px;
}
.pg_chk_profilo_portlet > .Image_esegui_estrazione_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_chk_profilo_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:861px;
  width:30px;
  height:30px;
}
.pg_chk_profilo_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_chk_profilo_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:52px;
  left:0px;
  right:0px;
  width:900px;
  height:250px;
}
.pg_chk_profilo_portlet > .cmbSoggetti_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:20px;
  left:246px;
  width:307px;
  height:20px;
}
.pg_chk_profilo_portlet > .Label14_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  width:240px;
  height:auto;
  min-height:20px;
}
.pg_chk_profilo_portlet > .Label14_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chk_profilo_portlet > .Label14_ctrl {
  overflow:hidden;
  text-align:right;
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
 String def="[{\"h\":\"310\",\"layout_steps_values\":{},\"pages_names\":\"Stampa Soggetti con\\u002fsenza profilo di rischio\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"900\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"977\",\"y\":\"2\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"826\",\"y\":\"13\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"980\",\"y\":\"-24\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"861\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"250\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"900\",\"x\":\"0\",\"y\":\"52\",\"zindex\":\"6\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"979\",\"y\":\"26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"979\",\"y\":\"48\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"983\",\"y\":\"74\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"980\",\"y\":\"103\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbSoggetti\",\"page\":\"1\",\"textlist\":\"Tutti, Solo con Profilo, Solo senza Profilo\",\"type\":\"Combobox\",\"w\":\"307\",\"x\":\"246\",\"y\":\"20\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipologia di soggetti da estrarre:\",\"w\":\"240\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"8\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_chk_profilo","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_chk_profilo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_chk_profilo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gDescAzi=sp.getGlobal("gDescAzi","");
String fType= "";
String fModel= "";
String cmbSoggetti="T";
String Label14= "Tipologia di soggetti da estrarre:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_chk_profilo_title_container' style='width:900px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_chk_profilo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_chk_profilo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_chk_profilo','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_Image_esegui_estrazione' class='image-default Image_esegui_estrazione_ctrl'   target=''>&#xeb4a;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xea01;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<select id='<%=idPortlet%>_cmbSoggetti' name='cmbSoggetti' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label14'  formid='<%=idPortlet%>' ps-name='Label14'    class='label Label14_ctrl'><div id='<%=idPortlet%>_Label14tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipologia di soggetti da estrarre:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_chk_profilo');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_chk_profilo',["900"],["310"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"310","title":"Stampa Soggetti con\u002fsenza profilo di rischio","layer":"false","npage":"1"}]);
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":977,"y":2});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.Image_esegui_estrazione=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default Image_esegui_estrazione_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_esegui_estrazione","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb4a;","font_image_hover":"&#xeb4b;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_esegui_estrazione","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb4a;","srchover":"&#xeb4b;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":826,"y":13,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":980,"y":-24});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,opefn_azzera_messaggi",request.getSession())%>';
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":861,"y":13,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"true","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":250,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":900,"x":0,"y":52,"zindex":"6"});
this.RTEsegui=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsegui","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsegui","offline":false,"page":1,"parms":"ReportName=operp_chk_profilo.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pTipo=cmbSoggetti,formatModels=fModel","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":979,"y":26});
this.RTEsegui.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.fType=new ZtVWeb._VC(this,'fType',null,'character','<%=JSPLib.ToJSValue(fType,false,true)%>',false,false);
this.fModel=new ZtVWeb._VC(this,'fModel',null,'character','<%=JSPLib.ToJSValue(fModel,false,true)%>',false,false);
this.cmbSoggetti=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbSoggetti","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbSoggetti%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbSoggetti","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Tutti, Solo con Profilo, Solo senza Profilo","type":"Combobox","typevar":"character","valuelist":"T,C,S","visible":true,"w":307,"x":246,"y":20,"zindex":"7"});
this.Label14=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14,false,true)%>","type":"Label","w":240,"x":0,"y":20,"zindex":"8"});
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
<%if(request.getAttribute("pg_chk_profilo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_chk_profilo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_chk_profilo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image_esegui_estrazione.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.cmbSoggetti.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_chk_profilo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_chk_profilo');
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
sp.endPage("pg_chk_profilo");
}%>
<%! public String getJSPUID() { return "1545085074"; } %>