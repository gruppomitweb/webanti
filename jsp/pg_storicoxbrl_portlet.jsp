<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle(\"Stampa Storico Estrazioni XBRL\",true)\n    this.getTitlePortlet().AppendButton({\n      id:\"Stampa1\",\n      title:FormatMsg('Stampa 1'),\n      tooltip:FormatMsg(\"Stampa Dati Aggregati\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb6d;\"},\n      action:'javascript:' + this.formid +'.btnSin_Click()'\n    },1);     \n    this.getTitlePortlet().AppendButton({\n      id:\"Stampa2\",\n      title:FormatMsg('Stampa 2'),\n      tooltip:FormatMsg(\"Stampa Dati Aggregati con dettaglio\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n      action:'javascript:' + this.formid +'.btnAna_Click()'\n    },2);  \n\nfunction annomese_onChange(){\n  this.annomese.SetCurRec();\n}\n\nfunction btnAna_Click(){\n  this.Tipo.Value('A');\n  this.start();\n}\n\nfunction btnSin_Click(){\n  this.Tipo.Value('S');\n  this.start();\n}\n\nfunction start(){\n  if (confirm(\"Confermi la stampa \"+(this.Tipo.Value()=='A'?\"con dettaglio\":\"sintetica\"))) {\n    this.iPrint.Load('');\n    this.getTitlePortlet().SetSubTitle(\"Elaborazione in corso attendere prego...\",true)\n    this.PortletLogs.Start();  \n    this.RT_arfn_storicoxbrl.Link();\n  }\n}\n\nfunction RT_arfn_storicoxbrl_Result(result){\n  if(result=='OK') {\n    this.Tipo.Value()=='A'?this.RTStampa1.Link():this.RTStampa2.Link();\n  }\n  this.getTitlePortlet().SetSubTitle(\"Elaborazione Completata\",true)\n  this.PortletLogs.Stop();  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Creazione Operazioni ExtraConto da AUI\u002fAGE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pLog }}{{ @pMsg }}{{ @annomese }}{{ @lblMese }}{{ @iPrint }}{{ @btnAna }}{{ @annomese }}{{ @lblMese }}{{ @btnSin }}{{ @iPrint }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"240","hsl":"false","htmlcode":"{{ @PortletLogs }} \n{{ @iPrint }} \n \n{{ @lblMese }} \n{{ @annomese }} \n \n \n \n \n{{ btnAna }}\n{{ RTAna }}\n{{ RTStampa1 }}\n{{ btnExit }}\n{{ RTEsci }}\n{{ gDescAzi }}\n{{ RTExec }}\n{{ pLog }}\n{{ RTStampa2 }}\n{{ ftypes }}\n{{ pMsg }}\n{{ annomese }}\n{{ lblMese }}\n{{ RTClean }}\n{{ SQLPeriodo }}\n{{ anno }}\n{{ btnSin }}\n{{ iPrint }}\n{{ mese }}\n{{ RTSin }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"240\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"160","zindex":"3","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"server-client","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1000","name":"SQLPeriodo","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_storicoxbrl_select","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"134","waiting_mgs":"","x":"821","y":"90"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa1","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_ver.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"true","popup_height":"","popup_maximized":"by skin","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"","target":"iPrint","type":"SPLinker","w":"134","x":"821","y":"295"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"134","x":"821","y":"172"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa2","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_ver_agg.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,SubstituteQuery=qbe_stpoper_ver_agg_sto","popup":"true","popup_height":"","popup_maximized":"by skin","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"","target":"iPrint","type":"SPLinker","w":"134","x":"821","y":"272"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"\"PDF$|$XLS$|$CSV\"","name":"ftypes","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"134","x":"821","y":"219"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLPeriodo","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"annomese","page":"1","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"","textlist":"ANNOMESE","type":"Combobox","typevar":"character","valuelist":"ANNOMESE","visible":"true","w":"212","wireframe_props":"name,textlist","x":"107","y":"11","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMese","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Periodo di estrazione:","w":"105","wireframe_props":"align,value,n_col","x":"3","y":"14","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLPeriodo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"ANNORIF","h":"20","init":"","init_par":"","name":"anno","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"134","x":"821","y":"128"},{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"116","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"11","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"42","zindex":"9","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLPeriodo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"MESERIF","h":"20","init":"","init_par":"","name":"mese","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"134","x":"821","y":"150"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"Tipo","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"134","x":"821","y":"196"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RT_arfn_storicoxbrl","offline":"false","page":"1","parms":"pAnno=anno,pMese=mese,pTipo=Tipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arfn_storicoxbrl","target":"","type":"SPLinker","w":"134","x":"821","y":"245"}]%>
<%/*Description:Creazione Operazioni ExtraConto da AUI/AGE*/%>
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
window.pg_storicoxbrl_Static=function(){
if(typeof annomese_onChange !='undefined')this.annomese_onChange=annomese_onChange;
if(typeof btnAna_Click !='undefined')this.btnAna_Click=btnAna_Click;
if(typeof btnSin_Click !='undefined')this.btnSin_Click=btnSin_Click;
if(typeof start !='undefined')this.start=start;
if(typeof RT_arfn_storicoxbrl_Result !='undefined')this.RT_arfn_storicoxbrl_Result=RT_arfn_storicoxbrl_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLPeriodo.addRowConsumer(this.annomese);
this.SQLPeriodo.addDataConsumer(this.anno,<%=JSPLib.ToJSValue("ANNORIF",true)%>);
this.SQLPeriodo.addDataConsumer(this.mese,<%=JSPLib.ToJSValue("MESERIF",true)%>);
this.getTitlePortlet().SetTitle("Stampa Storico Estrazioni XBRL",true)
    this.getTitlePortlet().AppendButton({
      id:"Stampa1",
      title:FormatMsg('Stampa 1'),
      tooltip:FormatMsg("Stampa Dati Aggregati"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb6d;"},
      action:'javascript:' + this.formid +'.btnSin_Click()'
    },1);     
    this.getTitlePortlet().AppendButton({
      id:"Stampa2",
      title:FormatMsg('Stampa 2'),
      tooltip:FormatMsg("Stampa Dati Aggregati con dettaglio"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
      action:'javascript:' + this.formid +'.btnAna_Click()'
    },2);  
function annomese_onChange(){
  this.annomese.SetCurRec();
}
function btnAna_Click(){
  this.Tipo.Value('A');
  this.start();
}
function btnSin_Click(){
  this.Tipo.Value('S');
  this.start();
}
function start(){
  if (confirm("Confermi la stampa "+(this.Tipo.Value()=='A'?"con dettaglio":"sintetica"))) {
    this.iPrint.Load('');
    this.getTitlePortlet().SetSubTitle("Elaborazione in corso attendere prego...",true)
    this.PortletLogs.Start();  
    this.RT_arfn_storicoxbrl.Link();
  }
}
function RT_arfn_storicoxbrl_Result(result){
  if(result=='OK') {
    this.Tipo.Value()=='A'?this.RTStampa1.Link():this.RTStampa2.Link();
  }
  this.getTitlePortlet().SetSubTitle("Elaborazione Completata",true)
  this.PortletLogs.Stop();  
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
.pg_storicoxbrl_container {
  height:100%;
  overflow:auto;
}
.pg_storicoxbrl_title_container {
  margin: auto;
}
.pg_storicoxbrl_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_storicoxbrl_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_storicoxbrl_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:160px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_storicoxbrl_portlet > .annomese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:107px;
  width:212px;
  height:20px;
}
.pg_storicoxbrl_portlet > .lblMese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:3px;
  width:105px;
  height:auto;
  min-height:19px;
}
.pg_storicoxbrl_portlet > .lblMese_ctrl {
  height:auto;
  min-height:19px;
}
.pg_storicoxbrl_portlet > .lblMese_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_storicoxbrl_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:42px;
  left:0px;
  right:0px;
  width:auto;
  height:116px;
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
 String def="[{\"h\":\"240\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"160\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"134\",\"x\":\"821\",\"y\":\"90\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"134\",\"x\":\"821\",\"y\":\"295\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"134\",\"x\":\"821\",\"y\":\"172\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"134\",\"x\":\"821\",\"y\":\"272\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"134\",\"x\":\"821\",\"y\":\"219\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"annomese\",\"page\":\"1\",\"textlist\":\"ANNOMESE\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"107\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMese\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Periodo di estrazione:\",\"w\":\"105\",\"x\":\"3\",\"y\":\"14\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"anno\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"134\",\"x\":\"821\",\"y\":\"128\"},{\"anchor\":\"top-left-right\",\"h\":\"116\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"42\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"mese\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"134\",\"x\":\"821\",\"y\":\"150\"},{\"h\":\"20\",\"name\":\"Tipo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"134\",\"x\":\"821\",\"y\":\"196\"},{\"h\":\"20\",\"name\":\"RT_arfn_storicoxbrl\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"134\",\"x\":\"821\",\"y\":\"245\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_storicoxbrl","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_storicoxbrl_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("arfn_finemese.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_storicoxbrl','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gDescAzi=sp.getGlobal("gDescAzi","");
String ftypes="\"PDF|XLS|CSV\"";
String annomese= "";
String lblMese= "Periodo di estrazione:";
String anno= "";
String mese= "";
String Tipo= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_storicoxbrl_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_storicoxbrl_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_storicoxbrl_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_storicoxbrl','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<select id='<%=idPortlet%>_annomese' name='annomese' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblMese'  formid='<%=idPortlet%>' ps-name='lblMese'    class='label lblMese_ctrl'><div id='<%=idPortlet%>_lblMesetbl' style='width:100%;'><%=JSPLib.ToHTML("Periodo di estrazione:")%></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_storicoxbrl');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa 1",true)+","+JSPLib.ToJSValue(sp.translate("Stampa 1"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa 2",true)+","+JSPLib.ToJSValue(sp.translate("Stampa 2"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa Dati Aggregati",true)+","+JSPLib.ToJSValue(sp.translate("Stampa Dati Aggregati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa Dati Aggregati con dettaglio",true)+","+JSPLib.ToJSValue(sp.translate("Stampa Dati Aggregati con dettaglio"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_storicoxbrl',["800"],["240"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"240","title":"","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":160,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.SQLPeriodo=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"server-client","cmd":"qbe_storicoxbrl_select","cmdHash":"<%=JSPLib.cmdHash("qbe_storicoxbrl_select",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLPeriodo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLPeriodo","nrows":"1000","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":134,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":821,"y":90});
this.RTStampa1=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa1","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa1","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_ver.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"true","popup_height":"","popup_maximized":"by skin","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":134,"x":821,"y":295});
this.RTStampa1.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.RTStampa2=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa2","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa2","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_ver_agg.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,SubstituteQuery=qbe_stpoper_ver_agg_sto","popup":"true","popup_height":"","popup_maximized":"by skin","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":134,"x":821,"y":272});
this.RTStampa2.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.ftypes=new ZtVWeb._VC(this,'ftypes',null,'character','<%=JSPLib.ToJSValue(ftypes,false,true)%>',false,false);
this.annomese=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_annomese","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=annomese%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"annomese","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"ANNOMESE","type":"Combobox","typevar":"character","valuelist":"ANNOMESE","visible":true,"w":212,"x":107,"y":11,"zindex":"1"});
this.lblMese=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMese","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMese","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMese,false,true)%>","type":"Label","w":105,"x":3,"y":14,"zindex":"1"});
this.anno=new ZtVWeb._VC(this,'anno',null,'character','<%=JSPLib.ToJSValue(anno,false,true)%>',false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":116,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":42,"zindex":"9"});
this.mese=new ZtVWeb._VC(this,'mese',null,'character','<%=JSPLib.ToJSValue(mese,false,true)%>',false,false);
this.Tipo=new ZtVWeb._VC(this,'Tipo',null,'character','<%=JSPLib.ToJSValue(Tipo,false,true)%>',false,false);
this.RT_arfn_storicoxbrl=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RT_arfn_storicoxbrl","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RT_arfn_storicoxbrl","offline":false,"page":1,"parms":"pAnno=anno,pMese=mese,pTipo=Tipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_storicoxbrl","target":"","type":"SPLinker","w":134,"x":821,"y":245});
this.RT_arfn_storicoxbrl.m_cID='<%=JSPLib.cmdHash("routine,arfn_storicoxbrl",request.getSession())%>';
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
<%if(request.getAttribute("pg_storicoxbrl_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_storicoxbrl_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_storicoxbrl_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLPeriodo.firstQuery('true','',<%SQLExecute.JSONquery(sp,"qbe_storicoxbrl_select",1000,out,false, sp.getParameter((!JSPLib.Empty(sp.getParameter("dataprovider_namespace","")) ? sp.getParameter("dataprovider_namespace","") + "_" : "" )+"page_SQLPeriodo" ,"1"));%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_storicoxbrl',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_storicoxbrl');
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
sp.endPage("pg_storicoxbrl");
}%>
<%! public String getJSPUID() { return "1859099454"; } %>