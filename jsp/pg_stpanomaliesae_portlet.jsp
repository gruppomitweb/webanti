<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Stampa Anomalie Sae\",true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa il risultato della ricerca'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.Image_print_Click()'\n  },2);      \n}\n\nfunction Image_print_Click(){\n  this.RTStampa.Link()              \n}","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Stampa Anomalie SAE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"350","hsl":"","htmlcode":"\n{{ @iPrint }}\n\n\n\n\n\n\n{{ @Label23 }}\n{{ @DaData }}\n\n\n\n\n\n\n\n\n\n\n\n\n{{ gAzienda }}\n{{ simili }}\n{{ Variable_codazi }}\n{{ SQLDataobj_qbe_tot_sog_web }}\n{{ SQLDataobj_count_tmp_seek_sogg }}\n{{ Variable_totrec }}\n{{ Variable_count_tmp_seek_sogg }}\n{{ Label_criterio }}\n{{ Portlet_showlog }}\n{{ Radio_criterio }}\n{{ Image_esegui }}\n{{ Checkbox_flgnote }}\n{{ Image_print }}\n{{ Checkbox_flgnega }}\n{{ Portlet_showmsg }}\n{{ RTRicerca }}{{ nominativo }}\n{{ Checkbox_flgafon }}\n{{ SPLinker_report }}\n{{ Iframe_elaborazione }}\n{{ lblDenom }}\n{{ denomin }}\n{{ lblSimili }}\n{{ RTAzzeraMessaggi }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"1024","layout_steps_values":"{\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"},\"1024\":{\"h\":\"350\",\"w\":\"1024\"}}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768,1024","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"1024","wizard":""},{"allowedentities":"arrt_stpanomaliesae","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTStampa","offline":"false","page":"1","parms":"w_daData=DaData","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"1","servlet":"arrt_stpanomaliesae","target":"iPrint","type":"SPLinker","w":"120","x":"1062","y":"-51"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"299","hide":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":202,\"w\":1024,\"h\":299,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":202,\"w\":1024,\"h\":299,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":202,\"w\":1024,\"h\":299,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":0,\"y\":52,\"w\":\"1024\",\"h\":299,\"anchor\":\"\",\"hide\":\"false\"}}","name":"iPrint","page":"1","sequence":"4","spuid":"","type":"Iframe","w":"1024","wireframe_props":"","x":"0","y":"52","zindex":"14"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":203,\"y\":21,\"w\":173,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":203,\"y\":21,\"w\":173,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":203,\"y\":21,\"w\":173,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":21,\"w\":\"173\",\"h\":22,\"anchor\":\"\",\"hide\":\"false\"}}","maxlength":"","name":"DaData","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"173","wireframe_props":"name","x":"170","y":"21","zerofilling":"false","zindex":"6"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":7,\"y\":21,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":7,\"y\":21,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":7,\"y\":21,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"1024\":{\"x\":7,\"y\":21,\"w\":\"158\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"Label23","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Situazione alla data:","w":"158","wireframe_props":"align,value,n_col","x":"7","y":"21","zindex":"7"}]%>
<%/*Description:Stampa Anomalie SAE*/%>
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
window.pg_stpanomaliesae_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image_print_Click !='undefined')this.Image_print_Click=Image_print_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(SystemDate(),this.DaData);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Stampa Anomalie Sae",true)
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa il risultato della ricerca'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.Image_print_Click()'
  },2);      
}
function Image_print_Click(){
  this.RTStampa.Link()              
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
.pg_stpanomaliesae_container {
}
.pg_stpanomaliesae_title_container {
  margin: auto;
}
.pg_stpanomaliesae_portlet{
  position:relative;
  margin: auto;
  width:1024px;
max-width:1024px;
  min-width:320px;
  height:350px;
}
.pg_stpanomaliesae_portlet[Data-page="1"]{
  height:350px;
  width:1024px;
}
.pg_stpanomaliesae_portlet[Data-step="320"] {
  height:500px;
  width:100%;
}
.pg_stpanomaliesae_portlet[Data-step="480"] {
  height:500px;
  width:100%;
}
.pg_stpanomaliesae_portlet[Data-step="768"] {
  height:500px;
  width:100%;
}
.pg_stpanomaliesae_portlet[Data-step="1024"] {
  height:350px;
  width:1024px;
}
.pg_stpanomaliesae_portlet[Data-step="1024"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:52px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomaliesae_portlet[Data-step="320"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomaliesae_portlet[Data-step="480"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomaliesae_portlet[Data-step="768"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomaliesae_portlet[Data-step="1024"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:170px;
  width:173px;
  height:22px;
}
.pg_stpanomaliesae_portlet[Data-step="320"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:203px;
  width:173px;
  height:22px;
}
.pg_stpanomaliesae_portlet[Data-step="480"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:203px;
  width:173px;
  height:22px;
}
.pg_stpanomaliesae_portlet[Data-step="768"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:203px;
  width:173px;
  height:22px;
}
.pg_stpanomaliesae_portlet > .DaData_ctrl {
}
.pg_stpanomaliesae_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stpanomaliesae_portlet[Data-step="1024"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomaliesae_portlet[Data-step="1024"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomaliesae_portlet[Data-step="320"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomaliesae_portlet[Data-step="320"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomaliesae_portlet[Data-step="480"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomaliesae_portlet[Data-step="480"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomaliesae_portlet[Data-step="768"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomaliesae_portlet[Data-step="768"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomaliesae_portlet > .Label23_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stpanomaliesae_portlet[Data-step="1024"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomaliesae_portlet[Data-step="320"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomaliesae_portlet[Data-step="480"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomaliesae_portlet[Data-step="768"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
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
 String def="[{\"h\":\"350\",\"layout_steps_values\":{\"1024\":{\"h\":\"350\",\"w\":\"1024\"},\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768,1024\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"1024\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1062\",\"y\":\"-51\"},{\"anchor\":\"\",\"h\":\"299\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":\"1024\",\"x\":0,\"y\":52},\"320\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":202},\"480\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":202},\"768\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":202}},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"52\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":\"173\",\"x\":170,\"y\":21},\"320\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":173,\"x\":203,\"y\":21},\"480\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":173,\"x\":203,\"y\":21},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":173,\"x\":203,\"y\":21}},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"173\",\"x\":\"170\",\"y\":\"21\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"158\",\"x\":7,\"y\":21},\"320\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":158,\"x\":7,\"y\":21},\"480\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":158,\"x\":7,\"y\":21},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":158,\"x\":7,\"y\":21}},\"n_col\":\"1\",\"name\":\"Label23\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Situazione alla data:\",\"w\":\"158\",\"x\":\"7\",\"y\":\"21\",\"zindex\":\"7\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stpanomaliesae","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stpanomaliesae_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stpanomaliesae','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date DaData= JSPLib.NullDate();
if(request.getAttribute("pg_stpanomaliesae_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label23= "Situazione alla data:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stpanomaliesae_title_container' style='width:1024px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stpanomaliesae_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stpanomaliesae_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stpanomaliesae','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' /></span>
<span id='<%=idPortlet%>_Label23'  formid='<%=idPortlet%>' ps-name='Label23'    class='label Label23_ctrl'><div id='<%=idPortlet%>_Label23tbl' style='width:100%;'><%=JSPLib.ToHTML("Situazione alla data:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stpanomaliesae');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa il risultato della ricerca",true)+","+JSPLib.ToJSValue(sp.translate("Stampa il risultato della ricerca"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stpanomaliesae',["1024"],["350"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768,1024', 'fixed','<%=m_cTITLEUID%>','',{"1024":{"h":"350","w":"1024"},"320":{"h":"500","w":"100%"},"480":{"h":"500","w":"100%"},"768":{"h":"500","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"500"},"1024":{"w":"1024","h":"350"},"768":{"w":"100%","h":"500"},"480":{"w":"100%","h":"500"}},"w":"1024","h":"350","title":"","layer":"false","npage":"1"}]);
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_stpanomaliesae",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"w_daData=DaData","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_stpanomaliesae","target":"iPrint","type":"SPLinker","w":120,"x":1062,"y":-51});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("routine,arrt_stpanomaliesae",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":299,"hide":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":299,"hide":"false","w":"1024","x":0,"y":52},"320":{"anchor":"","h":299,"hide":"false","w":1024,"x":0,"y":202},"480":{"anchor":"","h":299,"hide":"false","w":1024,"x":0,"y":202},"768":{"anchor":"","h":299,"hide":"false","w":1024,"x":0,"y":202}},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":1024,"x":0,"y":202,"zindex":"14"});
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":22,"hide":"false","w":"173","x":170,"y":21},"320":{"anchor":"","h":22,"hide":"false","w":173,"x":203,"y":21},"480":{"anchor":"","h":22,"hide":"false","w":173,"x":203,"y":21},"768":{"anchor":"","h":22,"hide":"false","w":173,"x":203,"y":21}},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaData%>","w":173,"x":203,"y":21,"zerofilling":false,"zindex":"6","zoom":""});
this.Label23=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label23","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":"158","x":7,"y":21},"320":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":158,"x":7,"y":21},"480":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":158,"x":7,"y":21},"768":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":158,"x":7,"y":21}},"n_col":1,"name":"Label23","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label23,false,true)%>","type":"Label","w":158,"x":7,"y":21,"zindex":"7"});
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
<%if(request.getAttribute("pg_stpanomaliesae_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stpanomaliesae_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stpanomaliesae_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stpanomaliesae',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stpanomaliesae');
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
sp.endPage("pg_stpanomaliesae");
}%>
<%! public String getJSPUID() { return "1168574060"; } %>