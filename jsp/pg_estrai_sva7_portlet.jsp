<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.anno.Value(this.RTInit.Link());\n  this.cartella.Value(\"flussi\");\n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE DATI PER SV A7\",true)\n  this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg(\"Estra i dati e crea il file per l'invio\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n      action:'javascript:' + this.formid +'.btnElab_Click()'\n  },1);     \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.getTitlePortlet().RemoveButtons()\n    this.PortletLogs.Start();    \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop();\n  if(result=='KO') {\n    alert(\"Elaborazione Abortita. Contattare l'assistenza!\");\n  } else {\n    alert(\"Elaborazione Completata. Prelevare il file con il bottone\");\n    this.filename.Value(result);\n    this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg(\"Estra i dati e crea il file per l'invio\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n      action:'javascript:' + this.formid +'.btnElab_Click()'\n    },1);     \n    this.getTitlePortlet().AppendButton({\n      id:\"Download\",\n      title:FormatMsg('Download'),\n      tooltip:FormatMsg(\"Scarica il file elaborato\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xebbd;\"},\n      action:'javascript:' + this.formid +'.btnDownload_Click()'\n    },2);  \n  }  \n}\n\n\nfunction btnDownload_Click(){\n  if (confirm(\"Confermi il prelievo del file?\")) {    \n    this.RTDownload.Link();    \n  }  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Estrazione Movimenti (Operazioni\u002fFrazionate)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pLog }}{{ @pMsg }}{{ @anno }}{{ @lblAnno }}{{ @trimestre }}{{ @lblTri }}{{ @btnDownload }}{{ @btnElab }}{{ @btnExit }}{{ @anno }}{{ @lblAnno }}{{ @trimestre }}{{ @lblTri }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"130","hsl":"false","htmlcode":"{{ @PortletLogs }} \n\n\n\n{{ @lblTri }}\n{{ @trimestre }}\n{{ @lblAnno }}\n{{ @anno }}\n\n\n\n\n\n\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"Filtri Base\",\"layer\":\"\",\"h\":\"130\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Filtri Base, Filtri Aggiuntivi","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"50","zindex":"3","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"233","x":"817","y":"-91"},{"allowedentities":"arfn_estrai_sva7","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"pAnno=anno,pSem=trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"arfn_estrai_sva7","target":"","type":"SPLinker","w":"228","x":"815","y":"-57"},{"allowedentities":"arrt_downloadfile_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella,pTipo=ZIP","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"arrt_downloadfile_doc","target":"","type":"SPLinker","w":"219","x":"818","y":"-16"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cartella","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"836","y":"138"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"53","wireframe_props":"name","x":"141","y":"8","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"10","y":"13","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"trimestre","page":"1","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"","textlist":"I Semestre,II Semestre","type":"Combobox","typevar":"character","valuelist":"1,2","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"8","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTri","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Semestre:","w":"69","wireframe_props":"align,value,n_col","x":"236","y":"13","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTInit","offline":"false","page":"1","parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"arfn_initdate","target":"","type":"SPLinker","w":"223","x":"814","y":"56"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"841","y":"112"}]%>
<%/*Description:Estrazione Movimenti (Operazioni/Frazionate)*/%>
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
window.pg_estrai_sva7_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnDownload_Click !='undefined')this.btnDownload_Click=btnDownload_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
function this_Loaded(){
  this.anno.Value(this.RTInit.Link());
  this.cartella.Value("flussi");
  this.getTitlePortlet().SetTitle("ESTRAZIONE DATI PER SV A7",true)
  this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg("Estra i dati e crea il file per l'invio"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
      action:'javascript:' + this.formid +'.btnElab_Click()'
  },1);     
}
function btnElab_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.getTitlePortlet().RemoveButtons()
    this.PortletLogs.Start();    
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.PortletLogs.Stop();
  if(result=='KO') {
    alert("Elaborazione Abortita. Contattare l'assistenza!");
  } else {
    alert("Elaborazione Completata. Prelevare il file con il bottone");
    this.filename.Value(result);
    this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg("Estra i dati e crea il file per l'invio"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
      action:'javascript:' + this.formid +'.btnElab_Click()'
    },1);     
    this.getTitlePortlet().AppendButton({
      id:"Download",
      title:FormatMsg('Download'),
      tooltip:FormatMsg("Scarica il file elaborato"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xebbd;"},
      action:'javascript:' + this.formid +'.btnDownload_Click()'
    },2);  
  }  
}
function btnDownload_Click(){
  if (confirm("Confermi il prelievo del file?")) {    
    this.RTDownload.Link();    
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
.pg_estrai_sva7_container {
  height:100%;
  overflow:auto;
}
.pg_estrai_sva7_title_container {
  margin: auto;
}
.pg_estrai_sva7_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_estrai_sva7_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_estrai_sva7_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:50px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_estrai_sva7_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:141px;
  width:53px;
  height:20px;
}
.pg_estrai_sva7_portlet > .anno_ctrl {
}
.pg_estrai_sva7_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sva7_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:10px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sva7_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sva7_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sva7_portlet > .trimestre_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sva7_portlet > .lblTri_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:236px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sva7_portlet > .lblTri_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sva7_portlet > .lblTri_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
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
 String def="[{\"h\":\"130\",\"layout_steps_values\":{},\"pages_names\":\"Filtri Base, Filtri Aggiuntivi\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"50\",\"zindex\":\"3\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"233\",\"x\":\"817\",\"y\":\"-91\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"228\",\"x\":\"815\",\"y\":\"-57\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"219\",\"x\":\"818\",\"y\":\"-16\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"836\",\"y\":\"138\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"141\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"10\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trimestre\",\"page\":\"1\",\"textlist\":\"I Semestre,II Semestre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTri\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Semestre:\",\"w\":\"69\",\"x\":\"236\",\"y\":\"13\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTInit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"223\",\"x\":\"814\",\"y\":\"56\"},{\"h\":\"20\",\"name\":\"filename\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"841\",\"y\":\"112\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrai_sva7","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrai_sva7_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrai_sva7','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String cartella= "";
String anno= "";
if(request.getAttribute("pg_estrai_sva7_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String trimestre= "";
String lblTri= "Semestre:";
String filename= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrai_sva7_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estrai_sva7_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrai_sva7_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrai_sva7','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<select id='<%=idPortlet%>_trimestre' name='trimestre' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblTri'  formid='<%=idPortlet%>' ps-name='lblTri'    class='label lblTri_ctrl'><div id='<%=idPortlet%>_lblTritbl' style='width:100%;'><%=JSPLib.ToHTML("Semestre:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrai_sva7');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Download",true)+","+JSPLib.ToJSValue(sp.translate("Download"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Estra i dati e crea il file per l'invio",true)+","+JSPLib.ToJSValue(sp.translate("Estra i dati e crea il file per l'invio"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Scarica il file elaborato",true)+","+JSPLib.ToJSValue(sp.translate("Scarica il file elaborato"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrai_sva7',["800"],["130"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"130","title":"Filtri Base","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":50,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":233,"x":817,"y":-91});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_estrai_sva7",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"pAnno=anno,pSem=trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_estrai_sva7","target":"","type":"SPLinker","w":228,"x":815,"y":-57});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_estrai_sva7",request.getSession())%>';
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_downloadfile_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella,pTipo=ZIP","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadfile_doc","target":"","type":"SPLinker","w":219,"x":818,"y":-16});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadfile_doc",request.getSession())%>';
this.cartella=new ZtVWeb._VC(this,'cartella',null,'character','<%=JSPLib.ToJSValue(cartella,false,true)%>',false,false);
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(anno,false,true)%>","w":53,"x":141,"y":8,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":10,"y":13,"zindex":"1"});
this.trimestre=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_trimestre","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=trimestre%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"trimestre","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"I Semestre,II Semestre","type":"Combobox","typevar":"character","valuelist":"1,2","visible":true,"w":212,"x":304,"y":8,"zindex":"1"});
this.lblTri=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTri","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTri","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTri,false,true)%>","type":"Label","w":69,"x":236,"y":13,"zindex":"1"});
this.RTInit=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTInit","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTInit","offline":false,"page":1,"parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_initdate","target":"","type":"SPLinker","w":223,"x":814,"y":56});
this.RTInit.m_cID='<%=JSPLib.cmdHash("routine,arfn_initdate",request.getSession())%>';
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_estrai_sva7_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrai_sva7_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrai_sva7_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.trimestre.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrai_sva7',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrai_sva7');
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
sp.endPage("pg_estrai_sva7");
}%>
<%! public String getJSPUID() { return "1401200467"; } %>