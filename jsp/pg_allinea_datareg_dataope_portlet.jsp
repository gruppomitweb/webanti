<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function button_esegui_Click(){\n  var _esegui,_msg\n  \n  _esegui=true;\n  _msg=''\n  \n  if(this.Textbox_DA_DATAOPE.Value()==null){\n    _esegui=false;\n   _msg=_msg+'Data inizio vuota\\n';\n  }\n  if(this.Textbox_A_DATAOPE.Value()==null){\n    _esegui=false;\n   _msg=_msg+'Data fine vuota\\n';\n  }\n  if (_esegui){\n    this.button_esegui.Disabled();\n    this.Calendario_DA_DATAOPE.Disabled();\n    this.Calendario_A_DATAOPE.Disabled();\n    this.Textbox_DA_DATAOPE.Disabled();\n    this.Textbox_A_DATAOPE.Disabled();\n    this.splinker_fn_allinea.Link();\n  }\n}\n\nfunction splinker_fn_allinea_Result(_res){\n  if(_res){\n    alert('Procedura terminata correttamente');\n  }else{\n    alert('Procedura annullata per presenza di errori');\n  }\n  this.button_esegui.Enabled();\n  this.Calendario_DA_DATAOPE.Enabled();\n  this.Calendario_A_DATAOPE.Enabled();\n  this.Textbox_DA_DATAOPE.Enabled();\n  this.Textbox_A_DATAOPE.Enabled();\n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#FFFFFF","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"250","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"605","version":"37","w":"100%"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"Textbox_DA_DATAOPE","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"1","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"90","x":"240","y":"44","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"Textbox_A_DATAOPE","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"1","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"90","x":"240","y":"71","zerofilling":"false","zindex":"1"},{"anchor":" ","css_class":" ","font":" ","font_size":" ","h":"20","name":"Calendario_DA_DATAOPE","page":"1","popup":"true","return_input":"Textbox_DA_DATAOPE","sequence":"2","type":"Calendario","w":"20","x":"335","y":"44"},{"anchor":" ","css_class":" ","font":" ","font_size":" ","h":"20","name":"Calendario_A_DATAOPE","page":"1","popup":"true","return_input":"Textbox_A_DATAOPE","sequence":"2","type":"Calendario","w":"20","x":"335","y":"71"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label_data_allinea","nowrap":"false","page":"1","picture":" ","sequence":"3","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Data da cui allineare le operazioni:","w":"210","x":"25","y":"44","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label_data_allinea_Copy","nowrap":"false","page":"1","picture":" ","sequence":"3","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Data a cui allineare le operazioni:","w":"210","x":"25","y":"71","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":" ","disabled":"false","edit_undercond":" ","empty_value":"false","font":" ","font_size":" ","h":"20","hide_undercond":" ","init":" ","init_par":"O","name":"Combobox_TBL","page":"1","picture":" ","sequence":"3","tabindex":" ","textlist":"Operazioni,Frazionate,Entrambe","type":"Combobox","typevar":"character","valuelist":"O,F,E","visible":"true","w":"100","x":"240","y":"100"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label_tbl","nowrap":"false","page":"1","picture":" ","sequence":"3","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Tabella da allineare:","w":"125","x":"110","y":"100","zindex":"1"},{"anchor":"top-right","bg_color":" ","border_color":" ","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":" ","font":" ","font_color":" ","font_size":" ","h":"20","help_tips":" ","hide_undercond":" ","name":"button_esegui","page":"1","sequence":"5","tabindex":" ","type":"Button","type_submit":"false","value":"Esegui","w":"66","x":"531","y":"51"},{"align":"center","anchor":"top-left-right","assoc_input":" ","bg_color":"#1306C6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","h":"25","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2_Copy_Copy","nowrap":"false","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Allineamento data registrazione alla data operazione","w":"605","x":"0","y":"0","zindex":"1"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"splinker_fn_allinea","offline":"false","page":"1","parms":"DA_DATAOPE=Textbox_DA_DATAOPE,A_DATAOPE=Textbox_A_DATAOPE,TBL=Combobox_TBL","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"6","servlet":"arfn_allinea_datareg_dataope","target":" ","type":"SPLinker","w":"30","x":"351","y":"-39"},{"anchor":"top-left-right","h":"40","name":"Portlet2","page":"1","sequence":"6","src":"showlog_portlet.jsp","type":"Portlet","w":"605","x":"0","y":"147"},{"anchor":"top-left-right","h":"40","name":"Portlet3","page":"1","sequence":"8","src":"showmsg_portlet.jsp","type":"Portlet","w":"605","x":"0","y":"191"}]%>
<%/*Description: */%>
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
window.pg_allinea_datareg_dataope_Static=function(){
if(typeof button_esegui_Click !='undefined')this.button_esegui_Click=button_esegui_Click;
if(typeof splinker_fn_allinea_Result !='undefined')this.splinker_fn_allinea_Result=splinker_fn_allinea_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function button_esegui_Click(){
  var _esegui,_msg
  
  _esegui=true;
  _msg=''
  
  if(this.Textbox_DA_DATAOPE.Value()==null){
    _esegui=false;
   _msg=_msg+'Data inizio vuota\n';
  }
  if(this.Textbox_A_DATAOPE.Value()==null){
    _esegui=false;
   _msg=_msg+'Data fine vuota\n';
  }
  if (_esegui){
    this.button_esegui.Disabled();
    this.Calendario_DA_DATAOPE.Disabled();
    this.Calendario_A_DATAOPE.Disabled();
    this.Textbox_DA_DATAOPE.Disabled();
    this.Textbox_A_DATAOPE.Disabled();
    this.splinker_fn_allinea.Link();
  }
}
function splinker_fn_allinea_Result(_res){
  if(_res){
    alert('Procedura terminata correttamente');
  }else{
    alert('Procedura annullata per presenza di errori');
  }
  this.button_esegui.Enabled();
  this.Calendario_DA_DATAOPE.Enabled();
  this.Calendario_A_DATAOPE.Enabled();
  this.Textbox_DA_DATAOPE.Enabled();
  this.Textbox_A_DATAOPE.Enabled();
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
.pg_allinea_datareg_dataope_container {
}
.pg_allinea_datareg_dataope_portlet{
  position:relative;
  width:100%;
  min-width:605px;
  height:250px;
  background-color:#FFFFFF;
}
.pg_allinea_datareg_dataope_portlet[Data-page="1"]{
  height:250px;
  width:100%;
}
.pg_allinea_datareg_dataope_portlet > .Textbox_DA_DATAOPE_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:240px;
  width:90px;
  height:20px;
}
.pg_allinea_datareg_dataope_portlet > .Textbox_DA_DATAOPE_ctrl {
}
.pg_allinea_datareg_dataope_portlet > .Textbox_DA_DATAOPE_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_allinea_datareg_dataope_portlet > .Textbox_A_DATAOPE_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:71px;
  left:240px;
  width:90px;
  height:20px;
}
.pg_allinea_datareg_dataope_portlet > .Textbox_A_DATAOPE_ctrl {
}
.pg_allinea_datareg_dataope_portlet > .Textbox_A_DATAOPE_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_allinea_datareg_dataope_portlet > .Calendario_DA_DATAOPE_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:335px;
  width:20px;
  height:20px;
}
.pg_allinea_datareg_dataope_portlet > .Calendario_A_DATAOPE_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:71px;
  left:335px;
  width:20px;
  height:20px;
}
.pg_allinea_datareg_dataope_portlet > .label_data_allinea_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:25px;
  width:210px;
  height:auto;
  min-height:19px;
}
.pg_allinea_datareg_dataope_portlet > .label_data_allinea_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allinea_datareg_dataope_portlet > .label_data_allinea_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.pg_allinea_datareg_dataope_portlet > .label_data_allinea_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:71px;
  left:25px;
  width:210px;
  height:auto;
  min-height:19px;
}
.pg_allinea_datareg_dataope_portlet > .label_data_allinea_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allinea_datareg_dataope_portlet > .label_data_allinea_Copy_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.pg_allinea_datareg_dataope_portlet > .Combobox_TBL_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:100px;
  left:240px;
  width:100px;
  height:20px;
}
.pg_allinea_datareg_dataope_portlet > .label_tbl_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:100px;
  left:110px;
  width:125px;
  height:auto;
  min-height:19px;
}
.pg_allinea_datareg_dataope_portlet > .label_tbl_ctrl {
  height:auto;
  min-height:19px;
}
.pg_allinea_datareg_dataope_portlet > .label_tbl_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.pg_allinea_datareg_dataope_portlet > .button_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:51px;
  right:8px;
  width:66px;
  height:20px;
}
.pg_allinea_datareg_dataope_portlet > .button_esegui_ctrl {
  border-width:1px;
}
.pg_allinea_datareg_dataope_portlet > .label2_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:25px;
}
.pg_allinea_datareg_dataope_portlet > .label2_Copy_Copy_ctrl {
  height:auto;
  min-height:25px;
}
.pg_allinea_datareg_dataope_portlet > .label2_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:13pt;
  font-weight:bold;
  color:#FCFCFC;
  text-align:center;
  background-color:#1306C6;
}
.pg_allinea_datareg_dataope_portlet > .Portlet2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:147px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:40px;
}
.pg_allinea_datareg_dataope_portlet > .Portlet3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:191px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:40px;
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
 String def="[{\"h\":\"250\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"605\",\"w\":\"100%\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"240\",\"y\":\"44\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"240\",\"y\":\"71\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"335\",\"y\":\"44\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"335\",\"y\":\"71\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"210\",\"x\":\"25\",\"y\":\"44\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"210\",\"x\":\"25\",\"y\":\"71\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"100\",\"x\":\"240\",\"y\":\"100\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"125\",\"x\":\"110\",\"y\":\"100\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"66\",\"x\":\"531\",\"y\":\"51\"},{\"anchor\":\"top-left-right\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"605\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"351\",\"y\":\"-39\"},{\"anchor\":\"top-left-right\",\"h\":\"40\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"605\",\"x\":\"0\",\"y\":\"147\"},{\"anchor\":\"top-left-right\",\"h\":\"40\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"605\",\"x\":\"0\",\"y\":\"191\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_allinea_datareg_dataope","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_allinea_datareg_dataope_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_allinea_datareg_dataope','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date Textbox_DA_DATAOPE= JSPLib.NullDate();
if(request.getAttribute("pg_allinea_datareg_dataope_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date Textbox_A_DATAOPE= JSPLib.NullDate();
if(request.getAttribute("pg_allinea_datareg_dataope_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String label_data_allinea= "Data da cui allineare le operazioni:";
String label_data_allinea_Copy= "Data a cui allineare le operazioni:";
String Combobox_TBL="O";
String label_tbl= "Tabella da allineare:";
String label2_Copy_Copy= "Allineamento data registrazione alla data operazione";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_allinea_datareg_dataope_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_allinea_datareg_dataope_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_allinea_datareg_dataope','<%=idPortlet%>',false,' ');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_DA_DATAOPE_wrp'><input id='<%=idPortlet%>_Textbox_DA_DATAOPE' name='Textbox_DA_DATAOPE' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_DA_DATAOPE' /></span>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_A_DATAOPE_wrp'><input id='<%=idPortlet%>_Textbox_A_DATAOPE' name='Textbox_A_DATAOPE' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_A_DATAOPE' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_DA_DATAOPE' class='calendar' onclick='window.<%=idPortlet%>.Calendario_DA_DATAOPE.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_A_DATAOPE' class='calendar' onclick='window.<%=idPortlet%>.Calendario_A_DATAOPE.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_label_data_allinea'  formid='<%=idPortlet%>' ps-name='label_data_allinea'    class='label label_data_allinea_ctrl'><div id='<%=idPortlet%>_label_data_allineatbl' style='width:100%;'><%=JSPLib.ToHTML("Data da cui allineare le operazioni:")%></div></span>
<span id='<%=idPortlet%>_label_data_allinea_Copy'  formid='<%=idPortlet%>' ps-name='label_data_allinea_Copy'    class='label label_data_allinea_Copy_ctrl'><div id='<%=idPortlet%>_label_data_allinea_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Data a cui allineare le operazioni:")%></div></span>
<select id='<%=idPortlet%>_Combobox_TBL' name='Combobox_TBL' class='combobox' style=''></select>
<span id='<%=idPortlet%>_label_tbl'  formid='<%=idPortlet%>' ps-name='label_tbl'    class='label label_tbl_ctrl'><div id='<%=idPortlet%>_label_tbltbl' style='width:100%;'><%=JSPLib.ToHTML("Tabella da allineare:")%></div></span>
<input id='<%=idPortlet%>_button_esegui' type='button' class='button button_esegui_ctrl'/>
<span id='<%=idPortlet%>_label2_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy_Copy'    class='label label2_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Allineamento data registrazione alla data operazione")%></div></span>
<div id='<%=idPortlet%>_Portlet2'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_d4kj2w",false);%></div>
<div id='<%=idPortlet%>_Portlet3'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_d4kj2x",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_allinea_datareg_dataope');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_allinea_datareg_dataope',["605"],["250"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"605","h":"250","title":" ","layer":"false","npage":"1"}]);
this.Textbox_DA_DATAOPE=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_Textbox_DA_DATAOPE","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_DA_DATAOPE","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_DA_DATAOPE%>","w":90,"x":240,"y":44,"zerofilling":false,"zindex":"1","zoom":""});
this.Textbox_A_DATAOPE=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_Textbox_A_DATAOPE","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_A_DATAOPE","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_A_DATAOPE%>","w":90,"x":240,"y":71,"zerofilling":false,"zindex":"1","zoom":""});
this.Calendario_DA_DATAOPE=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_DA_DATAOPE','Calendario_DA_DATAOPE',335,44,20,20,'','','top-left','true','Textbox_DA_DATAOPE',{});
this.Calendario_A_DATAOPE=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_A_DATAOPE','Calendario_A_DATAOPE',335,71,20,20,'','','top-left','true','Textbox_A_DATAOPE',{});
this.label_data_allinea=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label_data_allinea","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_data_allinea","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label_data_allinea,false,true)%>","type":"Label","w":210,"x":25,"y":44,"zindex":"1"});
this.label_data_allinea_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label_data_allinea_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_data_allinea_Copy","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label_data_allinea_Copy,false,true)%>","type":"Label","w":210,"x":25,"y":71,"zindex":"1"});
this.Combobox_TBL=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_Combobox_TBL","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":false,"encrypt":false,"font":"","font_size":"","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=Combobox_TBL%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_TBL","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":"Operazioni,Frazionate,Entrambe","type":"Combobox","typevar":"character","valuelist":"O,F,E","visible":true,"w":100,"x":240,"y":100});
this.label_tbl=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label_tbl","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_tbl","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label_tbl,false,true)%>","type":"Label","w":125,"x":110,"y":100,"zindex":"1"});
this.button_esegui=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":" ","border_weight":"1","class_Css":"button button_esegui_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_button_esegui","edit_undercond":" ","font":"","font_color":"","font_size":"","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"button_esegui","page":1,"tabindex":" ","text":"Esegui","type":"Button","type_submit":"false","type_wizard":"","w":66,"x":531,"y":51});
this.label2_Copy_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2_Copy_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy_Copy","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2_Copy_Copy,false,true)%>","type":"Label","w":605,"x":0,"y":0,"zindex":"1"});
this.splinker_fn_allinea=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_fn_allinea","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"splinker_fn_allinea","offline":false,"page":1,"parms":"DA_DATAOPE=Textbox_DA_DATAOPE,A_DATAOPE=Textbox_A_DATAOPE,TBL=Combobox_TBL","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arfn_allinea_datareg_dataope","target":" ","type":"SPLinker","w":30,"x":351,"y":-39});
this.splinker_fn_allinea.m_cID='<%=JSPLib.cmdHash("routine,arfn_allinea_datareg_dataope",request.getSession())%>';
if(this.Portlet2=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet2')){
this.Portlet2.setContainer(this,'Portlet2')
this.Portlet2_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet2","h":40,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet2","page":1,"portlet_id":"<%=idPortlet%>_d4kj2w","type":"Portlet","w":605,"x":0,"y":147});
} else {
document.getElementById('<%=idPortlet%>_Portlet2').style.display='none';
}
if(this.Portlet3=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet3')){
this.Portlet3.setContainer(this,'Portlet3')
this.Portlet3_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet3","h":40,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet3","page":1,"portlet_id":"<%=idPortlet%>_d4kj2x","type":"Portlet","w":605,"x":0,"y":191});
} else {
document.getElementById('<%=idPortlet%>_Portlet3').style.display='none';
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
<%if(request.getAttribute("pg_allinea_datareg_dataope_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_allinea_datareg_dataope_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_allinea_datareg_dataope_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Combobox_TBL.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_allinea_datareg_dataope',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_allinea_datareg_dataope');
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
sp.endPage("pg_allinea_datareg_dataope");
}%>
<%! public String getJSPUID() { return "3229289941"; } %>