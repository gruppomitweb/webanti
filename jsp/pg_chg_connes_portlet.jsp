<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Elabora_Click(){\n  if (confirm(\"Confermi il cambio di NDG?\")) {\n    this.PortletLogs.Start();\n    this.RTEsegui.Link()   \n  }  \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Cambio NDG Soggetto\",true)  \n  this.zDaCli.DoLink()\n  this.zDaCli.Hide()    \n}\n\nfunction RTTrasferisci_Result(result){\n  this.PortletLogs.Stop();  \n  if (result=='OK'){    \n    alert('Elaborazione Terminata con successo!');  \n  } else {\n    this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg('Esegue il cambio di NDG'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n      action:'javascript:' + this.formid +'.Elabora_Click()'\n    },1);      \n    alert('Elaborazione Terminata. Abortita per errori!');      \n  }   \n}\n\nfunction ACodCli_onChange(){\n  if(!Empty(this.DaCodCli.Value()) && !Empty(this.ACodCli.Value())) {\n    this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg('Esegue il cambio di NDG'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n      action:'javascript:' + this.formid +'.Elabora_Click()'\n    },1);   \n  } else {\n    this.getTitlePortlet().RemoveButtons()\n  }  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Controllo di Gestione","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pMsg }}{{ @pLog }}{{ @DaCodCli }}{{ @lblDaCli }}{{ @ACodCli }}{{ @lblACli }}{{ @zDaCli }}{{ @DaRagSoc }}{{ @Elabora }}{{ @Uscita }}{{ @DaCodCli }}{{ @lblDaCli }}{{ @ACodCli }}{{ @lblACli }}{{ @zDaCli }}{{ @DaRagSoc }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"160","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @DaRagSoc }} \n{{ @zDaCli }} \n{{ @lblACli }} \n{{ @ACodCli }} \n{{ @lblDaCli }} \n{{ @DaCodCli }} \n \n \n \n \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"Utilities.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"160\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"70","zindex":"6","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTEsegui","offline":"false","page":"1","parms":"w_oldcon=DaCodCli,w_newcon=ACodCli","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"arrt_chg_connes","target":"","type":"SPLinker","w":"147","x":"807","y":"-66"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"DaCodCli","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"144","wireframe_props":"name","x":"203","y":"8","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaCli","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice (NDG) Origine:","w":"199","wireframe_props":"align,value,n_col","x":"0","y":"9","zindex":"5","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"ACodCli","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"144","wireframe_props":"name","x":"203","y":"37","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblACli","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice (NDG) Destinazione:","w":"199","wireframe_props":"align,value,n_col","x":"0","y":"37","zindex":"5","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"DaCodCli,DaRagSoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"DaCodCli","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"zDaCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"11","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"350","y":"8","zindex":"6","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"DaRagSoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"416","wireframe_props":"name","x":"376","y":"8","zerofilling":"false","zindex":"7","zone":"","zoom":""}]%>
<%/*Description:Controllo di Gestione*/%>
<%/*ParamsRequest:DaCodCli*/%>
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
window.pg_chg_connes_Static=function(){
if(typeof Elabora_Click !='undefined')this.Elabora_Click=Elabora_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTTrasferisci_Result !='undefined')this.RTTrasferisci_Result=RTTrasferisci_Result;
if(typeof ACodCli_onChange !='undefined')this.ACodCli_onChange=ACodCli_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.zDaCli.addObserverFixedVars();
function Elabora_Click(){
  if (confirm("Confermi il cambio di NDG?")) {
    this.PortletLogs.Start();
    this.RTEsegui.Link()   
  }  
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Cambio NDG Soggetto",true)  
  this.zDaCli.DoLink()
  this.zDaCli.Hide()    
}
function RTTrasferisci_Result(result){
  this.PortletLogs.Stop();  
  if (result=='OK'){    
    alert('Elaborazione Terminata con successo!');  
  } else {
    this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg('Esegue il cambio di NDG'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
      action:'javascript:' + this.formid +'.Elabora_Click()'
    },1);      
    alert('Elaborazione Terminata. Abortita per errori!');      
  }   
}
function ACodCli_onChange(){
  if(!Empty(this.DaCodCli.Value()) && !Empty(this.ACodCli.Value())) {
    this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg('Esegue il cambio di NDG'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
      action:'javascript:' + this.formid +'.Elabora_Click()'
    },1);   
  } else {
    this.getTitlePortlet().RemoveButtons()
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
.pg_chg_connes_container {
  height:100%;
  overflow:auto;
}
.pg_chg_connes_title_container {
  margin: auto;
}
.pg_chg_connes_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_chg_connes_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_chg_connes_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:70px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_chg_connes_portlet > .DaCodCli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:8px;
  left:203px;
  left:25.375%;
  right:453px;
  right:56.625%;
  width:auto;
  height:20px;
}
.pg_chg_connes_portlet > .DaCodCli_ctrl {
}
.pg_chg_connes_portlet > .DaCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_connes_portlet > .lblDaCli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:9px;
  left:0px;
  left:0.0%;
  right:601px;
  right:75.125%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_chg_connes_portlet > .lblDaCli_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_connes_portlet > .lblDaCli_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_chg_connes_portlet > .ACodCli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:37px;
  left:203px;
  left:25.375%;
  right:453px;
  right:56.625%;
  width:auto;
  height:20px;
}
.pg_chg_connes_portlet > .ACodCli_ctrl {
}
.pg_chg_connes_portlet > .ACodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_connes_portlet > .lblACli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:37px;
  left:0px;
  left:0.0%;
  right:601px;
  right:75.125%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_chg_connes_portlet > .lblACli_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_connes_portlet > .lblACli_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_chg_connes_portlet > .zDaCli_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:8px;
  left:350px;
  left:43.75%;
  right:430px;
  right:53.75%;
  width:auto;
  height:20px;
}
.pg_chg_connes_portlet > .DaRagSoc_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:8px;
  left:376px;
  left:47.0%;
  right:8px;
  right:1.0%;
  width:auto;
  height:20px;
}
.pg_chg_connes_portlet > .DaRagSoc_ctrl {
}
.pg_chg_connes_portlet > .DaRagSoc_ctrl > input{
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
 String def="[{\"h\":\"160\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"70\",\"zindex\":\"6\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"807\",\"y\":\"-66\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"144\",\"x\":\"203\",\"y\":\"8\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaCli\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice (NDG) Origine:\",\"w\":\"199\",\"x\":\"0\",\"y\":\"9\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ACodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"144\",\"x\":\"203\",\"y\":\"37\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblACli\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice (NDG) Destinazione:\",\"w\":\"199\",\"x\":\"0\",\"y\":\"37\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zDaCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"350\",\"y\":\"8\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaRagSoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"416\",\"x\":\"376\",\"y\":\"8\",\"zindex\":\"7\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_chg_connes","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_chg_connes_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_chg_connes','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String DaCodCli=JSPLib.translateXSS(sp.getParameter("DaCodCli",""));
if(request.getAttribute("pg_chg_connes_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblDaCli= "Codice (NDG) Origine:";
String ACodCli= "";
String lblACli= "Codice (NDG) Destinazione:";
if(request.getAttribute("pg_chg_connes_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String DaRagSoc= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_chg_connes_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_chg_connes_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_chg_connes_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_chg_connes','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_DaCodCli_wrp'><input id='<%=idPortlet%>_DaCodCli' name='DaCodCli' type='text' disabled maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='DaCodCli' /></span>
<span id='<%=idPortlet%>_lblDaCli'  formid='<%=idPortlet%>' ps-name='lblDaCli'    class='label lblDaCli_ctrl'><div id='<%=idPortlet%>_lblDaClitbl' style='width:100%;'><%=JSPLib.ToHTML("Codice (NDG) Origine:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ACodCli_wrp'><input id='<%=idPortlet%>_ACodCli' name='ACodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='ACodCli' /></span>
<span id='<%=idPortlet%>_lblACli'  formid='<%=idPortlet%>' ps-name='lblACli'    class='label lblACli_ctrl'><div id='<%=idPortlet%>_lblAClitbl' style='width:100%;'><%=JSPLib.ToHTML("Codice (NDG) Destinazione:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zDaCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_DaRagSoc_wrp'><input id='<%=idPortlet%>_DaRagSoc' name='DaRagSoc' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='DaRagSoc' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_chg_connes');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegue il cambio di NDG",true)+","+JSPLib.ToJSValue(sp.translate("Esegue il cambio di NDG"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_chg_connes',["800"],["160"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"160","title":"","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":70,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.RTEsegui=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsegui","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsegui","offline":false,"page":1,"parms":"w_oldcon=DaCodCli,w_newcon=ACodCli","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_chg_connes","target":"","type":"SPLinker","w":147,"x":807,"y":-66});
this.RTEsegui.m_cID='<%=JSPLib.cmdHash("routine,arrt_chg_connes",request.getSession())%>';
this.DaCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"16","name":"DaCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(DaCodCli,false,true)%>","w":144,"x":203,"y":8,"zerofilling":false,"zindex":"4","zoom":""});
this.lblDaCli=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaCli","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaCli","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaCli,false,true)%>","type":"Label","w":199,"x":0,"y":9,"zindex":"5"});
this.ACodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ACodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"ACodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ACodCli,false,true)%>","w":144,"x":203,"y":37,"zerofilling":false,"zindex":"4","zoom":""});
this.lblACli=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblACli","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblACli","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblACli,false,true)%>","type":"Label","w":199,"x":0,"y":37,"zindex":"5"});
this.zDaCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zDaCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_chg_connes_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"DaCodCli,DaRagSoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_chg_connes_portlet.jspzDaCli",request.getSession())%>","linkedField":"DaCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zDaCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":350,"y":8,"zindex":"6","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.DaRagSoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaRagSoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"DaRagSoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(DaRagSoc,false,true)%>","w":416,"x":376,"y":8,"zerofilling":false,"zindex":"7","zoom":""});
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
<%if(request.getAttribute("pg_chg_connes_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_chg_connes_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_chg_connes_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_chg_connes',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_chg_connes');
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
sp.endPage("pg_chg_connes");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"zDaCli")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3994637992"; } %>