<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function lbl2_Click(){\n  this.SPlbl2.Link()\n}\nfunction this_Loaded(){\n  this.splinker_fn_mess_status.Link()\n\u002f\u002f  this.lbl5.Hide()\n}\n\nvar notifications, nmess_read, nmess_noread, esegui;\n\u002f\u002f var letti, noletti;\n\nfunction openTab(link, name) {\n   parent.windowOpenForeground(link,'tab','toolbar=no,scrollbars=yes,resizable=yes', null, null, null, null, false, name);\n}\n\n\u002f\u002f+ \" \u003cspan class='tab_area'\u003e\" + FormatMsg(\"SNAI\") + \"\u003c\u002fspan\u003e\"\n\nfunction Nuove(){\n   openTab('..\u002fjsp\u002fpg_cgo_operazioni_agenzie_dl_portlet.jsp', FormatMsg(\"03. Nuove Operazioni\")) ;\n}\n\nfunction DaCompletare(){\n   openTab('..\u002fjsp\u002fpg_cgo_operazioni_agenzie_portlet.jsp', FormatMsg(\"01. Da Completare (Singole)\"));\n}\n\nfunction MultiNew(){\n   openTab('..\u002fjsp\u002fpg_cgo_operazioni_agenzie_dl_multipli_portlet.jsp', FormatMsg(\"04. Nuove Operazioni Multiple\"));\n}\n\nfunction MultiEnd(){\n   openTab('..\u002fjsp\u002fpg_cgo_operazioni_agenzie_dl_multipli_dc_portlet.jsp', FormatMsg(\"02. Da Completare (Multiple)\"));\n}\n\nfunction splinker_fn_mess_status_Result(_testo){   \n  this.mRitorno.Value(_testo);  \n  if (this.mRitorno.RecCount() \u003e 0) {\n    this.mRitorno.GoTo(1);\n    while (!(this.mRitorno.Eof())) {\n      if (this.mRitorno.Get(\"tipo\")==\"dc\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        this.lbl1.Value('Operazioni da Completare ('+LRTrim(Str(_conta,10,0))+')')\n      }\n      if (this.mRitorno.Get(\"tipo\")==\"no\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        this.lbl2.Value('Nuove Operazioni ('+LRTrim(Str(_conta,10,0))+')')        \n      }\n      if (this.mRitorno.Get(\"tipo\")==\"om\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        this.lbl3.Value('Operazioni Multiple ('+LRTrim(Str(_conta,10,0))+')')                \n      }       \n      if (this.mRitorno.Get(\"tipo\")==\"in\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        this.lbl4.Value('Informazioni da leggere ('+LRTrim(Str(_conta,10,0))+')')                \n      }             \n      if (this.mRitorno.Get(\"tipo\")==\"mc\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        this.lbl5.Value('Multiple da Completare ('+LRTrim(Str(_conta,10,0))+')')                \n      }                   \n      this.mRitorno.Next();\n    }\n  }\n}\n\nfunction Aggiorna(_evt) {\n  this.splinker_fn_mess_status.Link()  \n}  ","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"jquery.toast.css,style_light.css","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"180","hsl":"","htmlcode":"{{ @lbl5 }} \n{{ @lbl4 }} \n{{ @lbl3 }} \n{{ @lbl2 }} \n{{ @lbl1 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"230","version":"37","w":"100%","wizard":""},{"auto_create":"","ctrlOfVariant":"","fields":"","h":"30","name":"mRitorno","page":"1","sequence":"1","type":"MemoryCursor","types":"","w":"141","x":"49","y":"-36"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"splinker_fn_mess_status","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"arfn_nuovi_alert","target":"","type":"SPLinker","w":"290","x":"271","y":"162"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FD092B","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:DaCompletare()","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Operazioni da Completare ()","w":"200","wireframe_props":"align,value,n_col","x":"16","y":"47","zindex":"1"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#0BF54D","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:Nuove()","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl2","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nuove Operazioni ()","w":"200","wireframe_props":"align,value,n_col","x":"16","y":"12","zindex":"1"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#F5ED0B","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:MultiNew()","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl3","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Operazioni Multiple ()","w":"200","wireframe_props":"align,value,n_col","x":"16","y":"82","zindex":"1"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"start_page_logo_agenzie_portlet.jsp","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl4","nowrap":"false","page":"1","picture":"","sanitize":"none","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"main","template_code":"","type":"Label","value":"Informazioni da leggere ()","w":"200","wireframe_props":"align,value,n_col","x":"16","y":"152","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"confermaBacheca","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"evt","sequence":"7","type":"EventReceiver","w":"298","x":"275","y":"-29"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_cgo_oper_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"evt","sequence":"8","type":"EventReceiver","w":"300","x":"272","y":"38"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_cgo_oper_multi_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"evt","sequence":"9","type":"EventReceiver","w":"301","x":"273","y":"9"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_snai_oper_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"evt","sequence":"10","type":"EventReceiver","w":"309","x":"270","y":"68"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:MultiEnd()","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl5","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Multiple da Completare ()","w":"200","wireframe_props":"align,value,n_col","x":"16","y":"117","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_cgo_oper_multi_dc_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"evt","sequence":"12","type":"EventReceiver","w":"301","x":"272","y":"95"}]%>
<%/*Description:*/%>
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
window.pg_operaz_msg_side_Static=function(){
if(typeof lbl2_Click !='undefined')this.lbl2_Click=lbl2_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof openTab !='undefined')this.openTab=openTab;
if(typeof Nuove !='undefined')this.Nuove=Nuove;
if(typeof DaCompletare !='undefined')this.DaCompletare=DaCompletare;
if(typeof MultiNew !='undefined')this.MultiNew=MultiNew;
if(typeof MultiEnd !='undefined')this.MultiEnd=MultiEnd;
if(typeof splinker_fn_mess_status_Result !='undefined')this.splinker_fn_mess_status_Result=splinker_fn_mess_status_Result;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function lbl2_Click(){
  this.SPlbl2.Link()
}
function this_Loaded(){
  this.splinker_fn_mess_status.Link()
//  this.lbl5.Hide()
}
var notifications, nmess_read, nmess_noread, esegui;
// var letti, noletti;
function openTab(link, name) {
   parent.windowOpenForeground(link,'tab','toolbar=no,scrollbars=yes,resizable=yes', null, null, null, null, false, name);
}
//+ " <span class='tab_area'>" + FormatMsg("SNAI") + "</span>"
function Nuove(){
   openTab('../jsp/pg_cgo_operazioni_agenzie_dl_portlet.jsp', FormatMsg("03. Nuove Operazioni")) ;
}
function DaCompletare(){
   openTab('../jsp/pg_cgo_operazioni_agenzie_portlet.jsp', FormatMsg("01. Da Completare (Singole)"));
}
function MultiNew(){
   openTab('../jsp/pg_cgo_operazioni_agenzie_dl_multipli_portlet.jsp', FormatMsg("04. Nuove Operazioni Multiple"));
}
function MultiEnd(){
   openTab('../jsp/pg_cgo_operazioni_agenzie_dl_multipli_dc_portlet.jsp', FormatMsg("02. Da Completare (Multiple)"));
}
function splinker_fn_mess_status_Result(_testo){   
  this.mRitorno.Value(_testo);  
  if (this.mRitorno.RecCount() > 0) {
    this.mRitorno.GoTo(1);
    while (!(this.mRitorno.Eof())) {
      if (this.mRitorno.Get("tipo")=="dc"){
        _conta=this.mRitorno.Get("numero")
        this.lbl1.Value('Operazioni da Completare ('+LRTrim(Str(_conta,10,0))+')')
      }
      if (this.mRitorno.Get("tipo")=="no"){
        _conta=this.mRitorno.Get("numero")
        this.lbl2.Value('Nuove Operazioni ('+LRTrim(Str(_conta,10,0))+')')        
      }
      if (this.mRitorno.Get("tipo")=="om"){
        _conta=this.mRitorno.Get("numero")
        this.lbl3.Value('Operazioni Multiple ('+LRTrim(Str(_conta,10,0))+')')                
      }       
      if (this.mRitorno.Get("tipo")=="in"){
        _conta=this.mRitorno.Get("numero")
        this.lbl4.Value('Informazioni da leggere ('+LRTrim(Str(_conta,10,0))+')')                
      }             
      if (this.mRitorno.Get("tipo")=="mc"){
        _conta=this.mRitorno.Get("numero")
        this.lbl5.Value('Multiple da Completare ('+LRTrim(Str(_conta,10,0))+')')                
      }                   
      this.mRitorno.Next();
    }
  }
}
function Aggiorna(_evt) {
  this.splinker_fn_mess_status.Link()  
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
.pg_operaz_msg_side_container {
}
.pg_operaz_msg_side_title_container {
  margin: auto;
}
.pg_operaz_msg_side_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:230px;
  height:180px;
}
.pg_operaz_msg_side_portlet[Data-page="1"]{
  height:180px;
  width:100%;
}
.pg_operaz_msg_side_portlet > .lbl1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  left:16px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl1_ctrl a {
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl1_ctrl a {
  overflow:hidden;
  color:#FD092B;
 display:block;
}
.pg_operaz_msg_side_portlet > .lbl1_ctrl > div > a:hover{
  color:#FD092B;
}
.pg_operaz_msg_side_portlet > .lbl2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:16px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl2_ctrl a {
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl2_ctrl a {
  overflow:hidden;
  color:#0BF54D;
 display:block;
}
.pg_operaz_msg_side_portlet > .lbl2_ctrl > div > a:hover{
  color:#0BF54D;
}
.pg_operaz_msg_side_portlet > .lbl3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:82px;
  left:16px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl3_ctrl a {
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl3_ctrl a {
  overflow:hidden;
  color:#F5ED0B;
 display:block;
}
.pg_operaz_msg_side_portlet > .lbl3_ctrl > div > a:hover{
  color:#F5ED0B;
}
.pg_operaz_msg_side_portlet > .lbl4_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:152px;
  left:16px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl4_ctrl a {
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl4_ctrl a {
  overflow:hidden;
  color:#FFFFFF;
 display:block;
}
.pg_operaz_msg_side_portlet > .lbl4_ctrl > div > a:hover{
  color:#FFFFFF;
}
.pg_operaz_msg_side_portlet > .lbl5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:117px;
  left:16px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl5_ctrl a {
  height:auto;
  min-height:20px;
}
.pg_operaz_msg_side_portlet > .lbl5_ctrl a {
  overflow:hidden;
  color:#FFFFFF;
 display:block;
}
.pg_operaz_msg_side_portlet > .lbl5_ctrl > div > a:hover{
  color:#FFFFFF;
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
 String def="[{\"h\":\"180\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"230\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"141\",\"x\":\"49\",\"y\":\"-36\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"290\",\"x\":\"271\",\"y\":\"162\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Operazioni da Completare ()\",\"w\":\"200\",\"x\":\"16\",\"y\":\"47\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nuove Operazioni ()\",\"w\":\"200\",\"x\":\"16\",\"y\":\"12\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Operazioni Multiple ()\",\"w\":\"200\",\"x\":\"16\",\"y\":\"82\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Informazioni da leggere ()\",\"w\":\"200\",\"x\":\"16\",\"y\":\"152\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"298\",\"x\":\"275\",\"y\":\"-29\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"300\",\"x\":\"272\",\"y\":\"38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"301\",\"x\":\"273\",\"y\":\"9\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"309\",\"x\":\"270\",\"y\":\"68\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Multiple da Completare ()\",\"w\":\"200\",\"x\":\"16\",\"y\":\"117\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"301\",\"x\":\"272\",\"y\":\"95\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_operaz_msg_side","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_operaz_msg_side_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("jquery.toast.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("jquery.toast.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("jquery.toast.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/jquery.toast.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("style_light.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("style_light.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("style_light.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/style_light.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_operaz_msg_side','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_operaz_msg_side_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
String lbl1= "Operazioni da Completare ()";
String lbl2= "Nuove Operazioni ()";
String lbl3= "Operazioni Multiple ()";
String lbl4= "Informazioni da leggere ()";
String lbl5= "Multiple da Completare ()";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_operaz_msg_side_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_operaz_msg_side_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_operaz_msg_side','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lbl1'  formid='<%=idPortlet%>' ps-name='lbl1'    class='label lbl1_ctrl'><div id='<%=idPortlet%>_lbl1tbl' style='width:100%;'><a id='<%=idPortlet%>_lbl1href' title='<%=JSPLib.ToHTML("Operazioni da Completare ()")%>' href='function:DaCompletare()'  ><%=JSPLib.ToHTML("Operazioni da Completare ()")%></a></div></span>
<span id='<%=idPortlet%>_lbl2'  formid='<%=idPortlet%>' ps-name='lbl2'    class='label lbl2_ctrl'><div id='<%=idPortlet%>_lbl2tbl' style='width:100%;'><a id='<%=idPortlet%>_lbl2href' title='<%=JSPLib.ToHTML("Nuove Operazioni ()")%>' href='function:Nuove()'  ><%=JSPLib.ToHTML("Nuove Operazioni ()")%></a></div></span>
<span id='<%=idPortlet%>_lbl3'  formid='<%=idPortlet%>' ps-name='lbl3'    class='label lbl3_ctrl'><div id='<%=idPortlet%>_lbl3tbl' style='width:100%;'><a id='<%=idPortlet%>_lbl3href' title='<%=JSPLib.ToHTML("Operazioni Multiple ()")%>' href='function:MultiNew()'  ><%=JSPLib.ToHTML("Operazioni Multiple ()")%></a></div></span>
<span id='<%=idPortlet%>_lbl4'  formid='<%=idPortlet%>' ps-name='lbl4'    class='label lbl4_ctrl'><div id='<%=idPortlet%>_lbl4tbl' style='width:100%;'><a id='<%=idPortlet%>_lbl4href' title='<%=JSPLib.ToHTML("Informazioni da leggere ()")%>' href='start_page_logo_agenzie_portlet.jsp' target='main' ><%=JSPLib.ToHTML("Informazioni da leggere ()")%></a></div></span>
<span id='<%=idPortlet%>_lbl5'  formid='<%=idPortlet%>' ps-name='lbl5'    class='label lbl5_ctrl'><div id='<%=idPortlet%>_lbl5tbl' style='width:100%;'><a id='<%=idPortlet%>_lbl5href' title='<%=JSPLib.ToHTML("Multiple da Completare ()")%>' href='function:MultiEnd()'  ><%=JSPLib.ToHTML("Multiple da Completare ()")%></a></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_operaz_msg_side');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("01. Da Completare (Singole)",true)+","+JSPLib.ToJSValue(sp.translate("01. Da Completare (Singole)"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("02. Da Completare (Multiple)",true)+","+JSPLib.ToJSValue(sp.translate("02. Da Completare (Multiple)"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("03. Nuove Operazioni",true)+","+JSPLib.ToJSValue(sp.translate("03. Nuove Operazioni"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("04. Nuove Operazioni Multiple",true)+","+JSPLib.ToJSValue(sp.translate("04. Nuove Operazioni Multiple"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SNAI",true)+","+JSPLib.ToJSValue(sp.translate("SNAI"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_operaz_msg_side',["230"],["180"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"230","h":"180","title":"","layer":"false","npage":"1"}]);
this.mRitorno=new ZtVWeb.MemoryCursorCtrl(this,'mRitorno','<%=idPortlet%>_mRitorno','','','','','false');
this.splinker_fn_mess_status=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_fn_mess_status","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_fn_mess_status","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_nuovi_alert","target":"","type":"SPLinker","w":290,"x":271,"y":162});
this.splinker_fn_mess_status.m_cID='<%=JSPLib.cmdHash("routine,arfn_nuovi_alert",request.getSession())%>';
this.lbl1=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FD092B","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:DaCompletare()","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lbl1,false,true)%>","type":"Label","w":200,"x":16,"y":47,"zindex":"1"});
this.lbl2=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#0BF54D","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:Nuove()","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl2","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lbl2,false,true)%>","type":"Label","w":200,"x":16,"y":12,"zindex":"1"});
this.lbl3=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#F5ED0B","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:MultiNew()","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl3","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lbl3,false,true)%>","type":"Label","w":200,"x":16,"y":82,"zindex":"1"});
this.lbl4=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"start_page_logo_agenzie_portlet.jsp","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl4","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"main","template":"","text":"<%=JSPLib.ToJSValue(lbl4,false,true)%>","type":"Label","w":200,"x":16,"y":152,"zindex":"1"});
this.confermaBacheca=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_confermaBacheca","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"confermaBacheca","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":298,"x":275,"y":-29});
this.armt_cgo_oper_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_cgo_oper_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_cgo_oper_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":300,"x":272,"y":38});
this.armt_cgo_oper_multi_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_cgo_oper_multi_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_cgo_oper_multi_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":301,"x":273,"y":9});
this.armt_snai_oper_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_snai_oper_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_snai_oper_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":309,"x":270,"y":68});
this.lbl5=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl5","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:MultiEnd()","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl5","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lbl5,false,true)%>","type":"Label","w":200,"x":16,"y":117,"zindex":"1"});
this.armt_cgo_oper_multi_dc_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_cgo_oper_multi_dc_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_cgo_oper_multi_dc_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":301,"x":272,"y":95});
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
<%if(request.getAttribute("pg_operaz_msg_side_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_operaz_msg_side_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_operaz_msg_side_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_confermaBacheca=function(parmsObj){<%=idPortlet%>.confermaBacheca.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_cgo_oper_savedEntity=function(parmsObj){<%=idPortlet%>.armt_cgo_oper_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_cgo_oper_multi_savedEntity=function(parmsObj){<%=idPortlet%>.armt_cgo_oper_multi_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_snai_oper_savedEntity=function(parmsObj){<%=idPortlet%>.armt_snai_oper_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_cgo_oper_multi_dc_savedEntity=function(parmsObj){<%=idPortlet%>.armt_cgo_oper_multi_dc_savedEntity.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_operaz_msg_side',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_operaz_msg_side');
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
sp.endPage("pg_operaz_msg_side");
}%>
<%! public String getJSPUID() { return "1856620597"; } %>