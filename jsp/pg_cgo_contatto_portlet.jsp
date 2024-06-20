<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"CONTATTO\",true)\n}\n\nfunction Salva_Click() {\n  if (confirm(\"Confermi il salvataggio dei dati ?\")) {\n    pippo=this.SalvaContatto.Link()\n    this.ContattoSave.Emit()\n    alert('Dati salvati correttamente!') \n    window.close()\n\n  }  \n}\n\nfunction Uscita_Click() {\n  if (confirm(\"Confermi l'uscita senza salvare i dati ?\")) {\n    window.close()\n  }  \n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"200","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"752","wizard":""},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"1000","name":"EsitiCon","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_esiticon","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"758","y":"6"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"153","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"mNote","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"true","sequence":"3","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"744","wireframe_props":"name","x":"4","y":"42","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"NumOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"53","wireframe_props":"name","x":"527","y":"14","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"dDataCon","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"5","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"91","wireframe_props":"name","x":"97","y":"10","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lData","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data Contatto:","w":"88","wireframe_props":"align,value,n_col","x":"7","y":"14","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lEsito","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Esito:","w":"69","wireframe_props":"align,value,n_col","x":"198","y":"14","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Salva","page":"1","path_type":"","sequence":"8","server_side":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"683","y":"8","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"EsitiCon","disabled":"false","edit_undercond":"","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","name":"cEsitoCon","page":"1","picture":"","sequence":"9","tabindex":"","textlist":"ECDESCRI","type":"Combobox","typevar":"character","valuelist":"ECCODICE","visible":"true","w":"238","wireframe_props":"name,textlist","x":"271","y":"10","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Uscita","page":"1","path_type":"","sequence":"10","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"718","y":"8","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"SalvaContatto","offline":"false","page":"1","parms":"pNumOpe=NumOpe,pDatCon=dDataCon,pEsiCon=cEsitoCon,pNotCon=mNote","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"arrt_cgo_save_esiticon","target":"","type":"SPLinker","w":"30","x":"758","y":"45"},{"broadcast":"all","eventsNames":"","eventsObjs":"","h":"20","name":"ContattoSave","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"12","type":"EventEmitter","w":"22","x":"767","y":"92"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:mNote,NumOpe,dDataCon,cEsitoCon*/%>
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
window.pg_cgo_contatto_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Salva_Click !='undefined')this.Salva_Click=Salva_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.EsitiCon.addRowConsumer(this.cEsitoCon);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("CONTATTO",true)
}
function Salva_Click() {
  if (confirm("Confermi il salvataggio dei dati ?")) {
    pippo=this.SalvaContatto.Link()
    this.ContattoSave.Emit()
    alert('Dati salvati correttamente!') 
    window.close()
  }  
}
function Uscita_Click() {
  if (confirm("Confermi l'uscita senza salvare i dati ?")) {
    window.close()
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
.pg_cgo_contatto_container {
}
.pg_cgo_contatto_title_container {
  margin: auto;
}
.pg_cgo_contatto_portlet{
  position:relative;
  margin: auto;
  width:752px;
  min-width:752px;
  height:200px;
}
.pg_cgo_contatto_portlet[Data-page="1"]{
  height:200px;
  width:752px;
}
.pg_cgo_contatto_portlet > .mNote_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:4px;
  width:744px;
  height:153px;
}
.pg_cgo_contatto_portlet > .mNote_ctrl {
}
.pg_cgo_contatto_portlet > .mNote_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.pg_cgo_contatto_portlet > .NumOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_cgo_contatto_portlet > .NumOpe_ctrl {
  display:none;
}
.pg_cgo_contatto_portlet > .NumOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_contatto_portlet > .dDataCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:97px;
  width:91px;
  height:20px;
}
.pg_cgo_contatto_portlet > .dDataCon_ctrl {
}
.pg_cgo_contatto_portlet > .dDataCon_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_contatto_portlet > .lData_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:7px;
  width:88px;
  height:auto;
  min-height:19px;
}
.pg_cgo_contatto_portlet > .lData_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_contatto_portlet > .lData_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_contatto_portlet > .lEsito_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:198px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_cgo_contatto_portlet > .lEsito_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_contatto_portlet > .lEsito_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_contatto_portlet > .Salva_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:683px;
  width:30px;
  height:30px;
}
.pg_cgo_contatto_portlet > .Salva_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_contatto_portlet > .cEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:271px;
  width:238px;
  height:20px;
}
.pg_cgo_contatto_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:718px;
  width:30px;
  height:30px;
}
.pg_cgo_contatto_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
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
 String def="[{\"h\":\"200\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"752\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"758\",\"y\":\"6\"},{\"anchor\":\"\",\"h\":\"153\",\"layout_steps_values\":{},\"name\":\"mNote\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"744\",\"x\":\"4\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"NumOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"527\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dDataCon\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"91\",\"x\":\"97\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lData\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Contatto:\",\"w\":\"88\",\"x\":\"7\",\"y\":\"14\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lEsito\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Esito:\",\"w\":\"69\",\"x\":\"198\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Salva\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"683\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cEsitoCon\",\"page\":\"1\",\"textlist\":\"ECDESCRI\",\"type\":\"Combobox\",\"w\":\"238\",\"x\":\"271\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Uscita\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"718\",\"y\":\"8\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"SalvaContatto\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"758\",\"y\":\"45\"},{\"h\":\"20\",\"name\":\"ContattoSave\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"767\",\"y\":\"92\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_contatto","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_contatto_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_contatto','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String mNote=JSPLib.translateXSS(sp.getParameter("mNote",""));
if(request.getAttribute("pg_cgo_contatto_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String NumOpe=JSPLib.translateXSS(sp.getParameter("NumOpe",""));
java.sql.Date dDataCon=sp.getParameter("dDataCon",JSPLib.NullDate());
String lData= "Data Contatto:";
String lEsito= "Esito:";
String cEsitoCon=JSPLib.translateXSS(sp.getParameter("cEsitoCon",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_contatto_title_container' style='width:752px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_contatto_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_contatto_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_contatto','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_mNote_wrp'><textarea id='<%=idPortlet%>_mNote' name='mNote' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='mNote'    ></textarea></span>
<span class='textbox-container'id='<%=idPortlet%>_NumOpe_wrp'><input id='<%=idPortlet%>_NumOpe' name='NumOpe' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='NumOpe' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dDataCon_wrp'><input id='<%=idPortlet%>_dDataCon' name='dDataCon' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='dDataCon' /></span>
<span id='<%=idPortlet%>_lData'  formid='<%=idPortlet%>' ps-name='lData'    class='label lData_ctrl'><div id='<%=idPortlet%>_lDatatbl' style='width:100%;'><%=JSPLib.ToHTML("Data Contatto:")%></div></span>
<span id='<%=idPortlet%>_lEsito'  formid='<%=idPortlet%>' ps-name='lEsito'    class='label lEsito_ctrl'><div id='<%=idPortlet%>_lEsitotbl' style='width:100%;'><%=JSPLib.ToHTML("Esito:")%></div></span>
<a id='<%=idPortlet%>_Salva' class='image Salva_ctrl'   target=''>&#xeb36;</a>
<select id='<%=idPortlet%>_cEsitoCon' name='cEsitoCon' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_contatto');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_contatto',["752"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"752","h":"200","title":"","layer":"false","npage":"1"}]);
this.EsitiCon=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_esiticon","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_esiticon",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_EsitiCon","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"EsitiCon","nrows":"1000","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":758,"y":6});
this.mNote=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_mNote","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":153,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"mNote","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(mNote,false,true)%>","w":744,"x":4,"y":42,"zerofilling":false,"zindex":"1","zoom":""});
this.NumOpe=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_NumOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"NumOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(NumOpe,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.dDataCon=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dDataCon","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"dDataCon","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dDataCon%>","w":91,"x":97,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.lData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lData","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lData,false,true)%>","type":"Label","w":88,"x":7,"y":14,"zindex":"1"});
this.lEsito=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lEsito","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lEsito","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lEsito,false,true)%>","type":"Label","w":69,"x":198,"y":14,"zindex":"1"});
this.Salva=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image Salva_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Salva","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Salva","page":1,"path_type":"","server_side":"","src":"&#xeb36;","srchover":"&#xeb37;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":683,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.cEsitoCon=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cEsitoCon","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cEsitoCon%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"cEsitoCon","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"ECDESCRI","type":"Combobox","typevar":"character","valuelist":"ECCODICE","visible":true,"w":238,"x":271,"y":10,"zindex":"1"});
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":718,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.SalvaContatto=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SalvaContatto","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SalvaContatto","offline":false,"page":1,"parms":"pNumOpe=NumOpe,pDatCon=dDataCon,pEsiCon=cEsitoCon,pNotCon=mNote","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_save_esiticon","target":"","type":"SPLinker","w":30,"x":758,"y":45});
this.SalvaContatto.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_save_esiticon",request.getSession())%>';
this.ContattoSave=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_ContattoSave","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"ContattoSave","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":22,"x":767,"y":92});
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
<%if(request.getAttribute("pg_cgo_contatto_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_contatto_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_contatto_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Salva.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.ContattoSave.setParms();
window.<%=idPortlet%>.EsitiCon.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_contatto',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_contatto');
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
sp.endPage("pg_cgo_contatto");
}%>
<%! public String getJSPUID() { return "3265691132"; } %>