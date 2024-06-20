<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Image_esegui_estrazione_Click(){\n  if(confirm(\"Confermi la stampa?\")) {\n    this.fType.Value(\"PDF|XLSX|CSV\")\n    this.fModel.Value(\"||\")\n    this.RTEsegui.Link()\n  }\n}\n\nfunction btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Revisione Profili Rischio',true)\n  this.RTAzzera.Link();\n}","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"310","hsl":"","htmlcode":"{{ @A_Data }}\n{{ @Label25 }}\n{{ @DaData }}\n{{ @iPrint }}\n{{ @btnExit }}\n{{ @Image_esegui_estrazione }}\n{{ @Label25_Copy }}\n{{ Label25_Copy }}\n{{ A_Data }}\n{{ fModel }}\n{{ autril }}\n{{ numdoc }}\n{{ datril }}\n{{ docsca }}\n{{ RTEsegui }}\n{{ Label0 }}\n{{ pMsg }}\n{{ Label1 }}{{ fType }}\n{{ Combobox_anno }}\n{{ Combobox_tr{{ DaData }}imestre }}{{ tipdoc }}\n{{ RTUscita }}\n{{ Image_esegui_estrazione }}{{ Calendario24 }}{{ gDescAzi }}\n{{ RTEstrazione{{ Label25 }}_trimestrale }}\n{{ RTAzzera }}\n{{ Label_nota }}\n{{ Label_nota2 }}\n{{ pLog }}\n{{ btnExit }}\n{{ Label_periodo }}\n{{ Image_download }}\n{{ RTDownload }}\n{{ nomeFile }}\n{{ RTCheck }}\n{{ Check }}\n{{ last_run }}\n{{ last_anno }}\n{{ last_trim }}\n{{ iPrint }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"400","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa Revisione Profili Rischio","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"900","wizard":""},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"1","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"977","y":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label25_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Revisione:","w":"144","wireframe_props":"align,value,n_col","x":"338","y":"21","zindex":"8"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb4a;","font_image_hover":"&#xeb4b;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_esegui_estrazione","page":"1","path_type":"","sequence":"3","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"826","y":"13","zindex":"5"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"980","y":"-24"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"5","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"861","y":"13","zindex":"1"},{"anchor":"top-left-right","auto_resize":"false","border":"true","default_portlet":"","h":"250","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"6","spuid":"","type":"Iframe","w":"900","wireframe_props":"","x":"0","y":"52","zindex":"6"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaData","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"character","visible":"true","w":"130","wireframe_props":"name","x":"167","y":"21","zerofilling":"false","zindex":"7"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label25","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Revisione:","w":"144","wireframe_props":"align,value,n_col","x":"18","y":"21","zindex":"8"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTEsegui","offline":"false","page":"1","parms":"ReportName=operp_rev_profilo.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,DaData=DaData,A_Data=A_Data,formatModels=fModel","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"9","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"979","y":"26"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"979","y":"48"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fType","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"983","y":"74"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fModel","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"980","y":"103"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"A_Data","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"character","visible":"true","w":"130","wireframe_props":"name","x":"487","y":"21","zerofilling":"false","zindex":"7"}]%>
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
window.pg_rev_profilo_Static=function(){
if(typeof Image_esegui_estrazione_Click !='undefined')this.Image_esegui_estrazione_Click=Image_esegui_estrazione_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(SystemDate(),this.DaData);
ZtVWeb.InitCtrl(SystemDate(),this.A_Data);
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
  this.getTitlePortlet().SetTitle('Stampa Revisione Profili Rischio',true)
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
.pg_rev_profilo_container {
  height:100%;
  overflow:auto;
}
.pg_rev_profilo_title_container {
  margin: auto;
}
.pg_rev_profilo_portlet{
  position:relative;
  margin: auto;
  width:900px;
max-width:400px;
  min-width:900px;
  height:100%;
}
.pg_rev_profilo_portlet[Data-page="1"]{
  height:100%;
  width:900px;
}
.pg_rev_profilo_portlet > .Label25_Copy_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:21px;
  left:338px;
  width:144px;
  height:auto;
  min-height:20px;
}
.pg_rev_profilo_portlet > .Label25_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_rev_profilo_portlet > .Label25_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_rev_profilo_portlet > .Image_esegui_estrazione_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:13px;
  left:826px;
  width:30px;
  height:30px;
}
.pg_rev_profilo_portlet > .Image_esegui_estrazione_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_rev_profilo_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:861px;
  width:30px;
  height:30px;
}
.pg_rev_profilo_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_rev_profilo_portlet > .iPrint_ctrl {
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
.pg_rev_profilo_portlet > .DaData_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:167px;
  width:130px;
  height:20px;
}
.pg_rev_profilo_portlet > .DaData_ctrl {
}
.pg_rev_profilo_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_rev_profilo_portlet > .Label25_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:21px;
  left:18px;
  width:144px;
  height:auto;
  min-height:20px;
}
.pg_rev_profilo_portlet > .Label25_ctrl {
  height:auto;
  min-height:20px;
}
.pg_rev_profilo_portlet > .Label25_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_rev_profilo_portlet > .A_Data_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:487px;
  width:130px;
  height:20px;
}
.pg_rev_profilo_portlet > .A_Data_ctrl {
}
.pg_rev_profilo_portlet > .A_Data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
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
 String def="[{\"h\":\"310\",\"layout_steps_values\":{},\"pages_names\":\"Stampa Revisione Profili Rischio\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"900\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"977\",\"y\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Revisione:\",\"w\":\"144\",\"x\":\"338\",\"y\":\"21\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"826\",\"y\":\"13\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"980\",\"y\":\"-24\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"861\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"250\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"900\",\"x\":\"0\",\"y\":\"52\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"130\",\"x\":\"167\",\"y\":\"21\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label25\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Revisione:\",\"w\":\"144\",\"x\":\"18\",\"y\":\"21\",\"zindex\":\"8\"},{\"h\":\"20\",\"name\":\"RTEsegui\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"979\",\"y\":\"26\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"979\",\"y\":\"48\"},{\"h\":\"20\",\"name\":\"fType\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"983\",\"y\":\"74\"},{\"h\":\"20\",\"name\":\"fModel\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"980\",\"y\":\"103\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"A_Data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"130\",\"x\":\"487\",\"y\":\"21\",\"zindex\":\"7\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_rev_profilo","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_rev_profilo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_rev_profilo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label25_Copy= "A Data Revisione:";
String DaData= "";
if(request.getAttribute("pg_rev_profilo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label25= "Da Data Revisione:";
String gDescAzi=sp.getGlobal("gDescAzi","");
String fType= "";
String fModel= "";
String A_Data= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_rev_profilo_title_container' style='width:900px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_rev_profilo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_rev_profilo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_rev_profilo','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_Label25_Copy'  formid='<%=idPortlet%>' ps-name='Label25_Copy'    class='label Label25_Copy_ctrl'><div id='<%=idPortlet%>_Label25_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Revisione:")%></div></span>
<a id='<%=idPortlet%>_Image_esegui_estrazione' class='image-default Image_esegui_estrazione_ctrl'   target=''>&#xeb4a;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xea01;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' /></span>
<span id='<%=idPortlet%>_Label25'  formid='<%=idPortlet%>' ps-name='Label25'    class='label Label25_ctrl'><div id='<%=idPortlet%>_Label25tbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Revisione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_A_Data_wrp'><input id='<%=idPortlet%>_A_Data' name='A_Data' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='A_Data' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_rev_profilo');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_rev_profilo',["900"],["310"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"310","title":"Stampa Revisione Profili Rischio","layer":"false","npage":"1"}]);
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":977,"y":2});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.Label25_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label25_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label25_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label25_Copy,false,true)%>","type":"Label","w":144,"x":338,"y":21,"zindex":"8"});
this.Image_esegui_estrazione=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default Image_esegui_estrazione_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_esegui_estrazione","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb4a;","font_image_hover":"&#xeb4b;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_esegui_estrazione","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb4a;","srchover":"&#xeb4b;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":826,"y":13,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":980,"y":-24});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,opefn_azzera_messaggi",request.getSession())%>';
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":861,"y":13,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"true","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":250,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":900,"x":0,"y":52,"zindex":"6"});
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"character","value":"<%=JSPLib.ToJSValue(DaData,false,true)%>","w":130,"x":167,"y":21,"zerofilling":false,"zindex":"7","zoom":""});
this.Label25=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label25","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label25","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label25,false,true)%>","type":"Label","w":144,"x":18,"y":21,"zindex":"8"});
this.RTEsegui=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsegui","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsegui","offline":false,"page":1,"parms":"ReportName=operp_rev_profilo.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,DaData=DaData,A_Data=A_Data,formatModels=fModel","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":979,"y":26});
this.RTEsegui.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.fType=new ZtVWeb._VC(this,'fType',null,'character','<%=JSPLib.ToJSValue(fType,false,true)%>',false,false);
this.fModel=new ZtVWeb._VC(this,'fModel',null,'character','<%=JSPLib.ToJSValue(fModel,false,true)%>',false,false);
this.A_Data=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_A_Data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"A_Data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"character","value":"<%=JSPLib.ToJSValue(A_Data,false,true)%>","w":130,"x":487,"y":21,"zerofilling":false,"zindex":"7","zoom":""});
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
<%if(request.getAttribute("pg_rev_profilo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_rev_profilo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_rev_profilo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image_esegui_estrazione.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_rev_profilo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_rev_profilo');
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
sp.endPage("pg_rev_profilo");
}%>
<%! public String getJSPUID() { return "3726183548"; } %>