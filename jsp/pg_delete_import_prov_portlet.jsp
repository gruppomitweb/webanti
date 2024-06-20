<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Cancellazione Import da PROVVISORI',true)\n  this.RTPulisci.Link();\n  \u002f\u002f Aggiungo bottone salva\n  this.getTitlePortlet().AppendButton({\n    id:\"Salva\",\n    title:FormatMsg('Elimina Import '),\n    tooltip:FormatMsg(\"Elimina l'import in provvisorio selezionato\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe9be\"},\n    action:'javascript:' + this.formid +'.elimina_import()'\n   },1); \n}\n\nfunction elimina_import(){\n  if(Empty(this.Combobox9.Value())){\n  \talert(\"Non vi sono import in Provvisorio da eliminare\");   \n  }else{  \n    if(confirm(\"Confermi l'anullamento dell'import?\"))\n    {    \n      if(confirm(\"Verranno annullati i seguenti import:\\n\"+this.create_alert_string()+\"\\n\\n\"))\n      {\t\n        this.pLog.Timer0.Start()    \n        this.pMsg.Timer0.Start()   \n        this.RTCancellaImport.Link();\n      }\n    }\n  }\n}\n\n\nfunction Combobox9_onChange(){\n  this.Combobox9.SetCurRec()\n}\nfunction RTCancellaImport_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop();\n  this.SQLDataobj_timestamps.Query();\n}\n\nfunction create_alert_string(){\n  var str=\"\";\n\tthis.Label9.Value().substring(1).slice(0, -1).split(',').forEach(function(entry){\n    switch (entry)\n    {\n       case \"archpers\":\n        \tstr=str+\"Soggetti\\n\";break;\n       case \"persnew\":\n        str=str+\"Modifiche Soggetti\\n\";break;\n       case \"archrap\":\n        \tstr=str+\"Rapporti Provvisorio\\n\";break;\n       case \"archinf\":\n        str=str+\"Informazioni Provvisorio\\n\";break;\n       case \"archope\":\n        \tstr=str+\"Operazioni Provvisorio\\n\";break;\n       case \"archfraz\":\n        str=str+\"Frazionate Provvisorio\\n\";break;\n       case \"archtito\":\n        \tstr=str+\"Titolari Effettivi\\n\";break;\n       case \"procdel\":\n        str=str+\"Procuratori\u002fDelegati sul rapporto Provvisorio\\n\";break;\n       case \"sogope\":\n        str=str+\"Soggetti Operanti Provvisorio\\n\";break;\n       case \"intest\":\n        str=str+\"Intestatari Provvisorio\\n\";break;\n       case \"sogcli\":\n        str=str+\"Altri Intestatari Operazioni\\n\";break;\n       case \"sogben\":\n        str=str+\"Altri Beneficiari Operazioni\\n\";break;\n       case \"sogaltro\":\n        str=str+\"Altri Soggetti Operanti Operazioni\\n\";break;\n       case \"titosupp\":\n        str=str+\"Altri Titolari Effettivi\\n\";break;\n       default:\n    }\n  });  \n  return str;\n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Elimina import nel Provvisori","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"320","hsl":"","htmlcode":"{{ pLog }}\n{{ btnExit }}\n{{ btnElab }}\n{{ RTAzzera }}{{ RTCancellaImport }}\n{{ pMsg }}\n{{ password{{ Label8 }} }}{{ Combobox9 }}\n{{ lblPasswo{{ Label9 }}rd }}\n{{ RTUscita }}{{ SQLDataobj_timestamps }}\n{{ RTPulisci }}\n{{ Image11 }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"850","wizard":""},{"anchor":"","h":"67","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"1","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"846","wireframe_props":"","x":"3","y":"246","zindex":"3"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTPulisci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"725","y":"-58"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label8","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Selezionare l'import da cancellare:","w":"226","wireframe_props":"align,value,n_col","x":"178","y":"13","zindex":"4"},{"allowedqueries":"qbe_delete_import_prov","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"SQLDataobj_timestamps","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_delete_import_prov","query_async":"false","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"192","x":"963","y":"-52"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"SQLDataobj_timestamps","dataobj_value":"SQLDataobj_timestamps","disabled":"false","edit_undercond":"","empty_value":"false","field":"TABELLE","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox9","page":"1","picture":"","sequence":"5","spuid":"","tabindex":"","textlist":"NUMIMP","type":"Combobox","typevar":"datetime","valuelist":"NUMIMP","visible":"true","w":"219","wireframe_props":"name,textlist","x":"414","y":"13","zindex":"5"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"SQLDataobj_timestamps","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"TABELLE","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label9","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"846","wireframe_props":"align,value,n_col","x":"2","y":"42","zindex":"6"},{"allowedentities":"arfn_delete_import_prov","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCancellaImport","offline":"false","page":"1","parms":"w_numimp=Combobox9","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arfn_delete_import_prov","target":"","type":"SPLinker","w":"192","x":"963","y":"-26"},{"anchor":"","h":"128","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"8","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"846","wireframe_props":"","x":"3","y":"115","zindex":""}]%>
<%/*Description:Elimina import nel Provvisori*/%>
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
window.pg_delete_import_prov_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof elimina_import !='undefined')this.elimina_import=elimina_import;
if(typeof Combobox9_onChange !='undefined')this.Combobox9_onChange=Combobox9_onChange;
if(typeof RTCancellaImport_Result !='undefined')this.RTCancellaImport_Result=RTCancellaImport_Result;
if(typeof create_alert_string !='undefined')this.create_alert_string=create_alert_string;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLDataobj_timestamps.addRowConsumer(this.Combobox9);
this.SQLDataobj_timestamps.addDataConsumer(this.Combobox9,'TABELLE');
this.SQLDataobj_timestamps.addDataConsumer(this.Label9,'TABELLE');
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Cancellazione Import da PROVVISORI',true)
  this.RTPulisci.Link();
  // Aggiungo bottone salva
  this.getTitlePortlet().AppendButton({
    id:"Salva",
    title:FormatMsg('Elimina Import '),
    tooltip:FormatMsg("Elimina l'import in provvisorio selezionato"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe9be"},
    action:'javascript:' + this.formid +'.elimina_import()'
   },1); 
}
function elimina_import(){
  if(Empty(this.Combobox9.Value())){
  	alert("Non vi sono import in Provvisorio da eliminare");   
  }else{  
    if(confirm("Confermi l'anullamento dell'import?"))
    {    
      if(confirm("Verranno annullati i seguenti import:\n"+this.create_alert_string()+"\n\n"))
      {	
        this.pLog.Timer0.Start()    
        this.pMsg.Timer0.Start()   
        this.RTCancellaImport.Link();
      }
    }
  }
}
function Combobox9_onChange(){
  this.Combobox9.SetCurRec()
}
function RTCancellaImport_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop();
  this.SQLDataobj_timestamps.Query();
}
function create_alert_string(){
  var str="";
	this.Label9.Value().substring(1).slice(0, -1).split(',').forEach(function(entry){
    switch (entry)
    {
       case "archpers":
        	str=str+"Soggetti\n";break;
       case "persnew":
        str=str+"Modifiche Soggetti\n";break;
       case "archrap":
        	str=str+"Rapporti Provvisorio\n";break;
       case "archinf":
        str=str+"Informazioni Provvisorio\n";break;
       case "archope":
        	str=str+"Operazioni Provvisorio\n";break;
       case "archfraz":
        str=str+"Frazionate Provvisorio\n";break;
       case "archtito":
        	str=str+"Titolari Effettivi\n";break;
       case "procdel":
        str=str+"Procuratori/Delegati sul rapporto Provvisorio\n";break;
       case "sogope":
        str=str+"Soggetti Operanti Provvisorio\n";break;
       case "intest":
        str=str+"Intestatari Provvisorio\n";break;
       case "sogcli":
        str=str+"Altri Intestatari Operazioni\n";break;
       case "sogben":
        str=str+"Altri Beneficiari Operazioni\n";break;
       case "sogaltro":
        str=str+"Altri Soggetti Operanti Operazioni\n";break;
       case "titosupp":
        str=str+"Altri Titolari Effettivi\n";break;
       default:
    }
  });  
  return str;
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
.pg_delete_import_prov_container {
}
.pg_delete_import_prov_title_container {
  margin: auto;
}
.pg_delete_import_prov_portlet{
  position:relative;
  margin: auto;
  width:850px;
  min-width:850px;
  height:320px;
  background-color:#FFFFFF;
}
.pg_delete_import_prov_portlet[Data-page="1"]{
  height:320px;
  width:850px;
}
.pg_delete_import_prov_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:246px;
  left:3px;
  width:846px;
  height:auto;
  min-height:67px;
}
.pg_delete_import_prov_portlet > .Label8_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:13px;
  left:178px;
  width:226px;
  height:auto;
  min-height:20px;
}
.pg_delete_import_prov_portlet > .Label8_ctrl {
  height:auto;
  min-height:20px;
}
.pg_delete_import_prov_portlet > .Label8_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_delete_import_prov_portlet > .Combobox9_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:13px;
  left:414px;
  width:219px;
  height:20px;
}
.pg_delete_import_prov_portlet > .Label9_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:42px;
  left:2px;
  width:846px;
  height:auto;
  min-height:20px;
}
.pg_delete_import_prov_portlet > .Label9_ctrl {
  height:auto;
  min-height:20px;
}
.pg_delete_import_prov_portlet > .Label9_ctrl {
  overflow:hidden;
  color:#FFFFFF;
  text-align:center;
}
.pg_delete_import_prov_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:115px;
  left:3px;
  width:846px;
  height:auto;
  min-height:128px;
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
 String def="[{\"h\":\"320\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"850\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"67\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"846\",\"x\":\"3\",\"y\":\"246\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"725\",\"y\":\"-58\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Selezionare l'import da cancellare:\",\"w\":\"226\",\"x\":\"178\",\"y\":\"13\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"192\",\"x\":\"963\",\"y\":\"-52\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox9\",\"page\":\"1\",\"textlist\":\"NUMIMP\",\"type\":\"Combobox\",\"w\":\"219\",\"x\":\"414\",\"y\":\"13\",\"zindex\":\"5\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label9\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"846\",\"x\":\"2\",\"y\":\"42\",\"zindex\":\"6\"},{\"h\":\"20\",\"name\":\"RTCancellaImport\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"192\",\"x\":\"963\",\"y\":\"-26\"},{\"anchor\":\"\",\"h\":\"128\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"846\",\"x\":\"3\",\"y\":\"115\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_delete_import_prov","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_delete_import_prov_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_delete_import_prov','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label8= "Selezionare l'import da cancellare:";
java.sql.Timestamp Combobox9= JSPLib.NullDateTime();
String Label9= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_delete_import_prov_title_container' style='width:850px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_delete_import_prov_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_delete_import_prov_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_delete_import_prov','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span id='<%=idPortlet%>_Label8'  formid='<%=idPortlet%>' ps-name='Label8'    class='label Label8_ctrl'><div id='<%=idPortlet%>_Label8tbl' style='width:100%;'><%=JSPLib.ToHTML("Selezionare l'import da cancellare:")%></div></span>
<select id='<%=idPortlet%>_Combobox9' name='Combobox9' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label9'  formid='<%=idPortlet%>' ps-name='Label9'    class='label Label9_ctrl'><div id='<%=idPortlet%>_Label9tbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_delete_import_prov');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elimina Import ",true)+","+JSPLib.ToJSValue(sp.translate("Elimina Import "),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elimina l'import in provvisorio selezionato",true)+","+JSPLib.ToJSValue(sp.translate("Elimina l'import in provvisorio selezionato"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_delete_import_prov',["850"],["320"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"850","h":"320","title":"","layer":"false","npage":"1"}]);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left","ctrlid":"<%=idPortlet%>_pMsg","h":67,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":846,"x":3,"y":246,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.RTPulisci=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPulisci","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPulisci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":725,"y":-58});
this.RTPulisci.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.Label8=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label8","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label8","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label8,false,true)%>","type":"Label","w":226,"x":178,"y":13,"zindex":"4"});
this.SQLDataobj_timestamps=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_delete_import_prov",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_delete_import_prov","cmdHash":"<%=JSPLib.cmdHash("qbe_delete_import_prov",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_timestamps","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_timestamps","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":192,"x":963,"y":-52});
this.Combobox9=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox9","dataobj_value":"SQLDataobj_timestamps","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"TABELLE","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox9%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"Combobox9","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"NUMIMP","type":"Combobox","typevar":"datetime","valuelist":"NUMIMP","visible":true,"w":219,"x":414,"y":13,"zindex":"5"});
this.Label9=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label9","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"TABELLE","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label9","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label9,false,true)%>","type":"Label","w":846,"x":2,"y":42,"zindex":"6"});
this.RTCancellaImport=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_delete_import_prov",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCancellaImport","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCancellaImport","offline":false,"page":1,"parms":"w_numimp=Combobox9","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_delete_import_prov","target":"","type":"SPLinker","w":192,"x":963,"y":-26});
this.RTCancellaImport.m_cID='<%=JSPLib.cmdHash("routine,arfn_delete_import_prov",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left","ctrlid":"<%=idPortlet%>_pLog","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":846,"x":3,"y":115,"zindex":""});
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
<%if(request.getAttribute("pg_delete_import_prov_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_delete_import_prov_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_delete_import_prov_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLDataobj_timestamps.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_delete_import_prov',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_delete_import_prov');
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
sp.endPage("pg_delete_import_prov");
}%>
<%! public String getJSPUID() { return "2779319402"; } %>