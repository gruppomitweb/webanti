<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _nolock\n\nfunction this_Loaded(){\n  this.mcParametri.CreateFld(\"da_data\",'D');\n  this.mcParametri.CreateFld(\"a_data\",'D');\n  this.mcParametri.CreateFld(\"fonte\",'C');\n  this.mcParametri.AppendBlank();\n  _nolock=true;\n}\n\nfunction LoadMC() {\n  this.mcParametri.Set(\"da_data\",this.Textbox_dadata.Value())\n  this.mcParametri.Set(\"a_data\",this.Textbox_adata.Value());\n  this.mcParametri.Set(\"fonte\",this.Combobox_fonte.Value());\n}\n\n\nfunction btnElimina_Click(){\n  var _esegui,_msg\n  _esegui=true;\n  _msg=''\n\u002f\u002f   alert(this.Textbox_dadata.Value());\n\u002f\u002f   alert(this.Textbox_adata.Value());\n\u002f\u002f   alert(this.Combobox_fonte.Value());\n  if(this.Textbox_dadata.Value()==null){\n    _esegui=false;\n    _msg=_msg+'Data inizio vuota\\n';\n  }\n  \n  if(this.Textbox_adata.Value()==null){\n    _esegui=false;\n   _msg=_msg+'Data fine vuota\\n';\n  }\n  \n  if(this.Textbox_dadata.Value()\u003ethis.Textbox_adata.Value()){\n    _esegui=false;\n    _msg=_msg+'Data inizio superiore a data fine\\n';\n  }\n  \n  if(this.Combobox_fonte.Value()==''){\n    _esegui=false;\n    _msg=_msg+'Selezionare l\\'archivio su cui effetuare la cancellazione\\n';\n  }\n  \n  if(_esegui && _nolock){\n    this.LoadMC();\n    _nolock=false;\n    this.splinker_elimina.Link();\n  }else{\n    if (_nolock){\n      _msg='Alcuni parametri non sono stati correttamente valorizzati per tanto la procedura non verra eseguita.\\n\\nDi seguito i parametri da valorizzare correttamente:\\n\\n'+_msg;\n    }else{\n      _msg='Attendere prego routine in esecuzione';\n    }\n    alert(_msg);\n  }\n  \n}\n\nfunction splinker_elimina_Result(_ritorno){\n  _nolock=true;\n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":" ","css":" ","css_class":" ","description":"Annullamento massivo operazioni","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"300","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":"Annullamento massivo operazioni","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"800","version":"37","w":"100%"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"Textbox_dadata","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"1","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"90","x":"269","y":"16","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"Textbox_adata","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"2","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"90","x":"542","y":"16","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":" ","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":" ","h":"20","hide_undercond":" ","init":" ","init_par":" ","name":"Combobox_fonte","page":"1","picture":" ","sequence":"3","tabindex":" ","textlist":"solo intere,solo frazionate,Tutte","type":"Combobox","typevar":"character","valuelist":"O,F,T","visible":"true","w":"144","x":"474","y":"56"},{"alt":"avvia eliminazione operazioni inidcate","anchor":" ","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"btnElimina","page":"1","path_type":" ","sequence":"4","server_side":" ","src":"..\u002fimages\u002felaborazione.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"395","y":"96","zindex":"1"},{"anchor":" ","css_class":" ","font":" ","font_size":" ","h":"18","name":"Calendario_dadata","page":"1","popup":"true","return_input":"Textbox_dadata","sequence":"5","type":"Calendario","w":"18","x":"364","y":"16"},{"anchor":" ","css_class":" ","font":" ","font_size":" ","h":"18","name":"Calendario_adata","page":"1","popup":"true","return_input":"Textbox_adata","sequence":"5","type":"Calendario","w":"18","x":"637","y":"16"},{"anchor":"top-left-right","h":"40","name":"Portlet2","page":"1","sequence":"6","src":"showlog_portlet.jsp","type":"Portlet","w":"798","x":"1","y":"156"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label_dadata","nowrap":"false","page":"1","picture":" ","sequence":"7","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Da data operazione:","w":"120","x":"149","y":"16","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label_adata","nowrap":"false","page":"1","picture":" ","sequence":"7","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"A data operazione:","w":"120","x":"422","y":"16","zindex":"1"},{"anchor":"top-left-right","h":"40","name":"Portlet3","page":"1","sequence":"8","src":"showmsg_portlet.jsp","type":"Portlet","w":"798","x":"1","y":"200"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label_fonte","nowrap":"false","page":"1","picture":" ","sequence":"9","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Selezionare da quale archivi annulare l'operazioni:","w":"300","x":"174","y":"57","zindex":"1"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"splinker_elimina","offline":"false","page":"1","parms":"mcParam=mcParametri","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"10","servlet":"arfn_del_ope","target":" ","type":"SPLinker","w":"30","x":"577","y":"-37"},{"h":"30","name":"mcParametri","page":"1","sequence":"11","type":"MemoryCursor","w":"30","x":"38","y":"-37"}]%>
<%/*Description:Annullamento massivo operazioni*/%>
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
window.pg_del_ope_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LoadMC !='undefined')this.LoadMC=LoadMC;
if(typeof btnElimina_Click !='undefined')this.btnElimina_Click=btnElimina_Click;
if(typeof splinker_elimina_Result !='undefined')this.splinker_elimina_Result=splinker_elimina_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var _nolock
function this_Loaded(){
  this.mcParametri.CreateFld("da_data",'D');
  this.mcParametri.CreateFld("a_data",'D');
  this.mcParametri.CreateFld("fonte",'C');
  this.mcParametri.AppendBlank();
  _nolock=true;
}
function LoadMC() {
  this.mcParametri.Set("da_data",this.Textbox_dadata.Value())
  this.mcParametri.Set("a_data",this.Textbox_adata.Value());
  this.mcParametri.Set("fonte",this.Combobox_fonte.Value());
}
function btnElimina_Click(){
  var _esegui,_msg
  _esegui=true;
  _msg=''
//   alert(this.Textbox_dadata.Value());
//   alert(this.Textbox_adata.Value());
//   alert(this.Combobox_fonte.Value());
  if(this.Textbox_dadata.Value()==null){
    _esegui=false;
    _msg=_msg+'Data inizio vuota\n';
  }
  
  if(this.Textbox_adata.Value()==null){
    _esegui=false;
   _msg=_msg+'Data fine vuota\n';
  }
  
  if(this.Textbox_dadata.Value()>this.Textbox_adata.Value()){
    _esegui=false;
    _msg=_msg+'Data inizio superiore a data fine\n';
  }
  
  if(this.Combobox_fonte.Value()==''){
    _esegui=false;
    _msg=_msg+'Selezionare l\'archivio su cui effetuare la cancellazione\n';
  }
  
  if(_esegui && _nolock){
    this.LoadMC();
    _nolock=false;
    this.splinker_elimina.Link();
  }else{
    if (_nolock){
      _msg='Alcuni parametri non sono stati correttamente valorizzati per tanto la procedura non verra eseguita.\n\nDi seguito i parametri da valorizzare correttamente:\n\n'+_msg;
    }else{
      _msg='Attendere prego routine in esecuzione';
    }
    alert(_msg);
  }
  
}
function splinker_elimina_Result(_ritorno){
  _nolock=true;
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
.pg_del_ope_container {
}
.pg_del_ope_portlet{
  position:relative;
  width:100%;
  min-width:800px;
  height:300px;
}
.pg_del_ope_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.pg_del_ope_portlet > .Textbox_dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:269px;
  width:90px;
  height:20px;
}
.pg_del_ope_portlet > .Textbox_dadata_ctrl {
}
.pg_del_ope_portlet > .Textbox_dadata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_del_ope_portlet > .Textbox_adata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:542px;
  width:90px;
  height:20px;
}
.pg_del_ope_portlet > .Textbox_adata_ctrl {
}
.pg_del_ope_portlet > .Textbox_adata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_del_ope_portlet > .Combobox_fonte_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:56px;
  left:474px;
  width:144px;
  height:20px;
}
.pg_del_ope_portlet > .btnElimina_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:96px;
  left:395px;
  width:40px;
  height:30px;
}
.pg_del_ope_portlet > .btnElimina_ctrl {
}
.pg_del_ope_portlet > .btnElimina_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_del_ope_portlet > .Calendario_dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:364px;
  width:18px;
  height:18px;
}
.pg_del_ope_portlet > .Calendario_adata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:637px;
  width:18px;
  height:18px;
}
.pg_del_ope_portlet > .Portlet2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:156px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:40px;
}
.pg_del_ope_portlet > .label_dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:149px;
  width:120px;
  height:auto;
  min-height:19px;
}
.pg_del_ope_portlet > .label_dadata_ctrl {
  height:auto;
  min-height:19px;
}
.pg_del_ope_portlet > .label_dadata_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.pg_del_ope_portlet > .label_adata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:422px;
  width:120px;
  height:auto;
  min-height:19px;
}
.pg_del_ope_portlet > .label_adata_ctrl {
  height:auto;
  min-height:19px;
}
.pg_del_ope_portlet > .label_adata_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.pg_del_ope_portlet > .Portlet3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:200px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:40px;
}
.pg_del_ope_portlet > .label_fonte_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:57px;
  left:174px;
  width:300px;
  height:auto;
  min-height:19px;
}
.pg_del_ope_portlet > .label_fonte_ctrl {
  height:auto;
  min-height:19px;
}
.pg_del_ope_portlet > .label_fonte_ctrl {
  overflow:hidden;
  text-align:left;
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
 String def="[{\"h\":\"300\",\"pages_names\":\"Annullamento massivo operazioni\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"269\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"542\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"144\",\"x\":\"474\",\"y\":\"56\"},{\"anchor\":\"\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"395\",\"y\":\"96\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"18\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"18\",\"x\":\"364\",\"y\":\"16\"},{\"anchor\":\"\",\"h\":\"18\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"18\",\"x\":\"637\",\"y\":\"16\"},{\"anchor\":\"top-left-right\",\"h\":\"40\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"798\",\"x\":\"1\",\"y\":\"156\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"120\",\"x\":\"149\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"120\",\"x\":\"422\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"40\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"798\",\"x\":\"1\",\"y\":\"200\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"300\",\"x\":\"174\",\"y\":\"57\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"577\",\"y\":\"-37\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"30\",\"x\":\"38\",\"y\":\"-37\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_del_ope","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_del_ope_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_del_ope','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date Textbox_dadata= JSPLib.NullDate();
if(request.getAttribute("pg_del_ope_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date Textbox_adata= JSPLib.NullDate();
String Combobox_fonte= "";
if(request.getAttribute("pg_del_ope_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String label_dadata= "Da data operazione:";
String label_adata= "A data operazione:";
String label_fonte= "Selezionare da quale archivi annulare l'operazioni:";
if(request.getAttribute("pg_del_ope_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_del_ope_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_del_ope_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_del_ope','<%=idPortlet%>',false,' ');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_dadata_wrp'><input id='<%=idPortlet%>_Textbox_dadata' name='Textbox_dadata' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_adata_wrp'><input id='<%=idPortlet%>_Textbox_adata' name='Textbox_adata' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata' /></span>
<select id='<%=idPortlet%>_Combobox_fonte' name='Combobox_fonte' class='combobox' style='font-family:verdana;'></select>
<div id='<%=idPortlet%>_btnElimina'>
<img id='<%=idPortlet%>_btnElimina_img' class='image btnElimina_ctrl' src="../images/elaborazione.gif" >
</div>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata.PopupCalendar();' style='text-decoration:none;'></a>
 <div id='<%=idPortlet%>_Portlet2'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_d4kj2w",false);%></div>
<span id='<%=idPortlet%>_label_dadata'  formid='<%=idPortlet%>' ps-name='label_dadata'    class='label label_dadata_ctrl'><div id='<%=idPortlet%>_label_dadatatbl' style='width:100%;'><%=JSPLib.ToHTML("Da data operazione:")%></div></span>
<span id='<%=idPortlet%>_label_adata'  formid='<%=idPortlet%>' ps-name='label_adata'    class='label label_adata_ctrl'><div id='<%=idPortlet%>_label_adatatbl' style='width:100%;'><%=JSPLib.ToHTML("A data operazione:")%></div></span>
<div id='<%=idPortlet%>_Portlet3'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_d4kj2x",false);%></div>
<span id='<%=idPortlet%>_label_fonte'  formid='<%=idPortlet%>' ps-name='label_fonte'    class='label label_fonte_ctrl'><div id='<%=idPortlet%>_label_fontetbl' style='width:100%;'><%=JSPLib.ToHTML("Selezionare da quale archivi annulare l'operazioni:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_del_ope');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_del_ope',["800"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"300","title":"Annullamento massivo operazioni","layer":"false","npage":"1"}]);
this.Textbox_dadata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_Textbox_dadata","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata%>","w":90,"x":269,"y":16,"zerofilling":false,"zindex":"1","zoom":""});
this.Textbox_adata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_Textbox_adata","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata%>","w":90,"x":542,"y":16,"zerofilling":false,"zindex":"1","zoom":""});
this.Combobox_fonte=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_Combobox_fonte","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=Combobox_fonte%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_fonte","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":"solo intere,solo frazionate,Tutte","type":"Combobox","typevar":"character","valuelist":"O,F,T","visible":true,"w":144,"x":474,"y":56});
this.btnElimina=new ZtVWeb._IC(this,{"alt":"avvia eliminazione operazioni inidcate","anchor":"top-left","boundedPosition":"","class_Css":"image btnElimina_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_btnElimina","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnElimina","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":395,"y":96,"zindex":"1"});
this.Calendario_dadata=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata','Calendario_dadata',364,16,18,18,'','','top-left','true','Textbox_dadata',{});
this.Calendario_adata=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata','Calendario_adata',637,16,18,18,'','','top-left','true','Textbox_adata',{});
if(this.Portlet2=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet2')){
this.Portlet2.setContainer(this,'Portlet2')
this.Portlet2_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet2","h":40,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet2","page":1,"portlet_id":"<%=idPortlet%>_d4kj2w","type":"Portlet","w":798,"x":1,"y":156});
} else {
document.getElementById('<%=idPortlet%>_Portlet2').style.display='none';
}
this.label_dadata=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label_dadata","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_dadata","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label_dadata,false,true)%>","type":"Label","w":120,"x":149,"y":16,"zindex":"1"});
this.label_adata=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label_adata","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_adata","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label_adata,false,true)%>","type":"Label","w":120,"x":422,"y":16,"zindex":"1"});
if(this.Portlet3=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet3')){
this.Portlet3.setContainer(this,'Portlet3')
this.Portlet3_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet3","h":40,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet3","page":1,"portlet_id":"<%=idPortlet%>_d4kj2x","type":"Portlet","w":798,"x":1,"y":200});
} else {
document.getElementById('<%=idPortlet%>_Portlet3').style.display='none';
}
this.label_fonte=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label_fonte","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fonte","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label_fonte,false,true)%>","type":"Label","w":300,"x":174,"y":57,"zindex":"1"});
this.splinker_elimina=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_elimina","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"splinker_elimina","offline":false,"page":1,"parms":"mcParam=mcParametri","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arfn_del_ope","target":" ","type":"SPLinker","w":30,"x":577,"y":-37});
this.splinker_elimina.m_cID='<%=JSPLib.cmdHash("routine,arfn_del_ope",request.getSession())%>';
this.mcParametri=new ZtVWeb.MemoryCursorCtrl(this,'mcParametri','<%=idPortlet%>_mcParametri','','','','','false');
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
<%if(request.getAttribute("pg_del_ope_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_del_ope_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_del_ope_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Combobox_fonte.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_del_ope',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_del_ope');
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
sp.endPage("pg_del_ope");
}%>
<%! public String getJSPUID() { return "3766475898"; } %>