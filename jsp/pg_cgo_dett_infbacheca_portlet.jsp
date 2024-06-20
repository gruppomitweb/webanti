<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n this.getTitlePortlet().SetTitle(this.cTitolo.Value(),true) \n this.getTitlePortlet().SetSubTitle(this.cCateg.Value(),true)\n}\n\nfunction Image6_Click(){\n  if(confirm(\"Confermi la lettura dell'informazione?\")) {\n    _result=this.RTConfirmRead.Link()\n    if (_result=='KO') {\n      alert(\"Errore durante la conferma della lettura.\\nContattare l'assistenza\")\n    } else {\n      this.confermaBacheca.Emit()\n      alert('Lettura nota confermata');\n      window.close()\n    }  \n  }  \n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"490","hsl":"","htmlcode":"{{ @Image6 }} \n{{ @Repeat5 }} \n{{ @cTesto }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"447\",\"w\":\"100%\"},\"480\":{\"h\":\"447\",\"w\":\"100%\"},\"768\":{\"h\":\"490\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"numinfo","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"793","y":"16"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"SQLDettInfo","offline":"false","page":"1","parms":"pIBCODICE=numinfo","parms_source":"","query":"qbe_cgo_dett_infbacheca","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"125","x":"790","y":"-38"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDettInfo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IBTITOLO","h":"20","init":"","init_par":"","name":"cTitolo","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"796","y":"41"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDettInfo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CBDESCRI","h":"20","init":"","init_par":"","name":"cCateg","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"796","y":"65"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLDettInfo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"IBDESCRI","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"260","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":5,\"w\":319,\"h\":260,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":5,\"w\":478,\"h\":260,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":1,\"y\":5,\"w\":766,\"h\":260,\"anchor\":\"\",\"hide\":\"false\"}}","maxlength":"","name":"cTesto","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"true","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"memo","visible":"true","w":"766","wireframe_props":"name","x":"1","y":"5","zerofilling":"false","zindex":"5"},{"ajax_mode":"false","ajax_mode_autoexec":"true","align":"left","anchor":"","css_class_name":"","ctrlOfVariant":"","fields":"IBDDESFILE,IDBNOMFILE,IBDCODICE","floating":"false","h":"153","hide":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":275,\"w\":\"766\",\"h\":153,\"anchor\":\"\"},\"480\":{\"x\":1,\"y\":275,\"w\":\"766\",\"h\":153,\"anchor\":\"\"},\"768\":{\"x\":1,\"y\":275,\"w\":766,\"h\":153,\"anchor\":\"\",\"hide\":\"\"}}","max_row":"","n_col":"2","n_pages":"5","n_row":"3","name":"Repeat5","navbar":"false","nextHTML":"","page":"1","parameters":"pIBDCODICE=numinfo","portlet":"pg_cgo_url_infbacheca_portlet.jsp","prevHTML":"","query":"qbe_cgo_doc_infbacheca","sequence":"6","spuid":"","stretch":"false","type":"Repeat","valign":"","w":"766","wireframe_props":"n_col,n_row,navbar","x":"1","xml_root":"","xml_source":"","y":"275","zindex":"6"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96a;","font_image_hover":"&#xe96b;","font_name":"ZucchettiDevelopement","font_size":"","h":"40","help_tips":"Conferma lettura","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":152,\"y\":442,\"w\":16,\"h\":40,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":228,\"y\":442,\"w\":24,\"h\":40,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":363,\"y\":442,\"w\":40,\"h\":40,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"Image6","page":"1","path_type":"","sequence":"7","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"40","wireframe_props":"","x":"363","y":"442","zindex":"7"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTConfirmRead","offline":"false","page":"1","parms":"pInfo=numinfo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"arfn_cgo_confread_infbacheca","target":"","type":"SPLinker","w":"120","x":"796","y":"-10"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"confermaBacheca","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"9","type":"EventEmitter","w":"133","x":"784","y":"-63"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:numinfo*/%>
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
window.pg_cgo_dett_infbacheca_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image6_Click !='undefined')this.Image6_Click=Image6_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLDettInfo.addDataConsumer(this.cTitolo,<%=JSPLib.ToJSValue("IBTITOLO",true)%>);
this.SQLDettInfo.addDataConsumer(this.cCateg,<%=JSPLib.ToJSValue("CBDESCRI",true)%>);
this.SQLDettInfo.addDataConsumer(this.cTesto,<%=JSPLib.ToJSValue("IBDESCRI",true)%>);
function this_Loaded(){
 this.getTitlePortlet().SetTitle(this.cTitolo.Value(),true) 
 this.getTitlePortlet().SetSubTitle(this.cCateg.Value(),true)
}
function Image6_Click(){
  if(confirm("Confermi la lettura dell'informazione?")) {
    _result=this.RTConfirmRead.Link()
    if (_result=='KO') {
      alert("Errore durante la conferma della lettura.\nContattare l'assistenza")
    } else {
      this.confermaBacheca.Emit()
      alert('Lettura nota confermata');
      window.close()
    }  
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
.pg_cgo_dett_infbacheca_container {
}
.pg_cgo_dett_infbacheca_title_container {
  margin: auto;
}
.pg_cgo_dett_infbacheca_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:490px;
  background-color:#F3F3F3;
}
.pg_cgo_dett_infbacheca_portlet[Data-page="1"]{
  height:490px;
  width:100%;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="320"] {
  height:447px;
  width:100%;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="480"] {
  height:447px;
  width:100%;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="768"] {
  height:490px;
  width:100%;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="320"] > .cTesto_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:1px;
  left:0.3125%;
  right:0px;
  right:0.0%;
  width:auto;
  height:260px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="480"] > .cTesto_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:1px;
  left:0.20833333%;
  right:1px;
  right:0.20833333%;
  width:auto;
  height:260px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="768"] > .cTesto_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:1px;
  left:0.13020833%;
  right:1px;
  right:0.13020833%;
  width:auto;
  height:260px;
}
.pg_cgo_dett_infbacheca_portlet > .cTesto_ctrl {
}
.pg_cgo_dett_infbacheca_portlet > .cTesto_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  width:100%;
  height:100%;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="320"] > .Repeat5_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:275px;
  left:1px;
  left:0.3125%;
  right:-447px;
  right:-139.6875%;
  width:auto;
  height:auto;
  min-height:153px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="480"] > .Repeat5_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:275px;
  left:1px;
  left:0.20833333%;
  right:-287px;
  right:-59.791668%;
  width:auto;
  height:auto;
  min-height:153px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="768"] > .Repeat5_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:275px;
  left:1px;
  left:0.13020833%;
  right:1px;
  right:0.13020833%;
  width:auto;
  height:auto;
  min-height:153px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="320"] > .Image6_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:442px;
  left:152px;
  left:47.5%;
  right:152px;
  right:47.5%;
  width:auto;
  height:40px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="480"] > .Image6_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:442px;
  left:228px;
  left:47.5%;
  right:228px;
  right:47.5%;
  width:auto;
  height:40px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="768"] > .Image6_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:442px;
  left:363px;
  left:47.265625%;
  right:365px;
  right:47.526043%;
  width:auto;
  height:40px;
}
.pg_cgo_dett_infbacheca_portlet > .Image6_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:40px;
  font-size:40px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="320"] > .Image6_ctrl {
  line-height:40px;
  font-size:16px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="480"] > .Image6_ctrl {
  line-height:40px;
  font-size:24px;
}
.pg_cgo_dett_infbacheca_portlet[Data-step="768"] > .Image6_ctrl {
  line-height:40px;
  font-size:40px;
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
 String def="[{\"h\":\"490\",\"layout_steps_values\":{\"320\":{\"h\":\"447\",\"w\":\"100%\"},\"480\":{\"h\":\"447\",\"w\":\"100%\"},\"768\":{\"h\":\"490\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"793\",\"y\":\"16\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"125\",\"x\":\"790\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"796\",\"y\":\"41\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"796\",\"y\":\"65\"},{\"anchor\":\"\",\"h\":\"260\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"h\":260,\"hide\":\"false\",\"w\":319,\"x\":1,\"y\":5},\"480\":{\"anchor\":\"\",\"h\":260,\"hide\":\"false\",\"w\":478,\"x\":1,\"y\":5},\"768\":{\"anchor\":\"\",\"h\":260,\"hide\":\"false\",\"w\":766,\"x\":1,\"y\":5}},\"name\":\"cTesto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"766\",\"x\":\"1\",\"y\":\"5\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"153\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"h\":153,\"w\":\"766\",\"x\":1,\"y\":275},\"480\":{\"anchor\":\"\",\"h\":153,\"w\":\"766\",\"x\":1,\"y\":275},\"768\":{\"anchor\":\"\",\"h\":153,\"hide\":\"\",\"w\":766,\"x\":1,\"y\":275}},\"n_col\":\"2\",\"n_row\":\"3\",\"name\":\"Repeat5\",\"navbar\":\"false\",\"page\":\"1\",\"type\":\"Repeat\",\"w\":\"766\",\"x\":\"1\",\"y\":\"275\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"40\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"h\":40,\"hide\":\"false\",\"w\":16,\"x\":152,\"y\":442},\"480\":{\"anchor\":\"\",\"h\":40,\"hide\":\"false\",\"w\":24,\"x\":228,\"y\":442},\"768\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":40,\"x\":363,\"y\":442}},\"name\":\"Image6\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"363\",\"y\":\"442\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"RTConfirmRead\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"796\",\"y\":\"-10\"},{\"h\":\"20\",\"name\":\"confermaBacheca\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"133\",\"x\":\"784\",\"y\":\"-63\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_dett_infbacheca","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_dett_infbacheca_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_dett_infbacheca','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double numinfo=sp.getParameter("numinfo",0);
String cTitolo= "";
String cCateg= "";
String cTesto= "";
if(request.getAttribute("pg_cgo_dett_infbacheca_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
Connection conn_Repeat5 = null;
if(request.getAttribute("pg_cgo_dett_infbacheca_firstinclusion")==null){%>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("slootoom.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("zfx.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("RepeatObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_dett_infbacheca_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_dett_infbacheca_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_dett_infbacheca_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_dett_infbacheca','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_cTesto_wrp'><textarea id='<%=idPortlet%>_cTesto' name='cTesto' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='cTesto'    ></textarea></span>
<%
if(request.getAttribute("CtrlCounter")!=null)
  request.setAttribute("CtrlCounter",(Integer)request.getAttribute("CtrlCounter")+1);
else
  request.setAttribute("CtrlCounter",1);
int Repeat5_Counter=(Integer)request.getAttribute("CtrlCounter");
%><%int n_record_Repeat5=3*2;

if(request.getAttribute("safe_params")==null)
  safe_params=new HashMap<String,String>();
else
  safe_params=(Map)(request.getAttribute("safe_params"));

safe_params.put("IBDDESFILE","IBDDESFILE");
safe_params.put("IDBNOMFILE","IDBNOMFILE");
safe_params.put("IBDCODICE","IBDCODICE");
request.setAttribute("safe_params",safe_params);

sp.addQueryParameter("pIBDCODICE",numinfo);
int Repeat5_curr_page=(int)sp.getParameter("page_Repeat5"+Repeat5_Counter ,1);
int Repeat5_RecordNumber=-1;
int Repeat5_n_pages=0;
String Repeat5_bUrl=(String)(request.getHeader("X-Original-Request-URI")==null?(request.getAttribute("javax.servlet.forward.request_uri")!=null?request.getAttribute("javax.servlet.forward.request_uri"):request.getRequestURI()):request.getHeader("X-Original-Request-URI"));
String Repeat5_parms=JSPLib.getQueryStringList(request,"page_Repeat5"+Repeat5_Counter);
Repeat5_parms=(Repeat5_parms.length()>0?"&"+Repeat5_parms:Repeat5_parms);
conn_Repeat5 = new RSConnection("qbe_cgo_doc_infbacheca",sp, n_record_Repeat5,-1,true,Repeat5_curr_page*n_record_Repeat5); 
sp.emptyQueryParameters();
Repeat5_RecordNumber=conn_Repeat5.GetRecordNumber();
Repeat5_n_pages=(int)Math.ceil(Double.valueOf((Repeat5_RecordNumber)/Double.valueOf(n_record_Repeat5)));
if(Repeat5_curr_page>Repeat5_n_pages)Repeat5_curr_page=Repeat5_n_pages;
if(Repeat5_curr_page<1)Repeat5_curr_page=1;
int Repeat5_first_page=(Repeat5_curr_page-5<=0)?1:Repeat5_curr_page-5;
int Repeat5_last_page=(Repeat5_n_pages-Repeat5_curr_page<=5)?Repeat5_n_pages:Repeat5_curr_page+5;
conn_Repeat5.SetPage(Repeat5_curr_page);
int x_Repeat5=1;
String contentType_Repeat5=response.getCharacterEncoding();%>
<div id='<%=idPortlet%>_Repeat5' class='repeater '>
<table id='tbl_<%=idPortlet%>_Repeat5' style='width:100%' cellSpacing='1' cellPadding='1' align='center' border='0'>
<tr><td align='left' valign='' width='50%'>
<%while (!conn_Repeat5.Eop()) {
  
pageContext.include("pg_cgo_url_infbacheca_portlet.jsp?IBDDESFILE="+java.net.URLEncoder.encode(contentType_Repeat5.equals("ISO-8859-1")?JSPLib.Strtran(conn_Repeat5.GetValue("IBDDESFILE",null,sp),"\u20ac","\u0080"):conn_Repeat5.GetValue("IBDDESFILE",null,sp),contentType_Repeat5)+"&IDBNOMFILE="+java.net.URLEncoder.encode(contentType_Repeat5.equals("ISO-8859-1")?JSPLib.Strtran(conn_Repeat5.GetValue("IDBNOMFILE",null,sp),"\u20ac","\u0080"):conn_Repeat5.GetValue("IDBNOMFILE",null,sp),contentType_Repeat5)+"&IBDCODICE="+java.net.URLEncoder.encode(contentType_Repeat5.equals("ISO-8859-1")?JSPLib.Strtran(conn_Repeat5.GetValue("IBDCODICE",null,sp),"\u20ac","\u0080"):conn_Repeat5.GetValue("IBDCODICE",null,sp),contentType_Repeat5));

if(x_Repeat5 % 2 == 0){
  out.print("</td></tr><tr><td align='left' valign='' width='50%'>");
x_Repeat5=0;
}else
  out.print("</td><td align='left' valign='' width='50%'>");
x_Repeat5++;
conn_Repeat5.Next();
}
if(x_Repeat5<2 && x_Repeat5>1)
  for(int i=x_Repeat5;i<2;i++)
    out.print("</td><td align='center'width='25%'>");
out.print("</td></tr></table>");
%>
</div>
<a id='<%=idPortlet%>_Image6' class='image-default Image6_ctrl'   target=''>&#xe96a;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_dett_infbacheca');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_dett_infbacheca',["768"],["490"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"447","w":"100%"},"480":{"h":"447","w":"100%"},"768":{"h":"490","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"447"},"768":{"w":"100%","h":"490"},"480":{"w":"100%","h":"447"}},"w":"768","h":"490","title":"","layer":"false","npage":"1"}]);
this.numinfo=new ZtVWeb._VC(this,'numinfo',null,'numeric',<%=numinfo%>,false,false);
this.SQLDettInfo=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_dett_infbacheca","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_dett_infbacheca",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDettInfo","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDettInfo","nrows":"10","page":1,"parms":"pIBCODICE=numinfo","parms_source":"","type":"SQLDataobj","w":125,"x":790,"y":-38});
this.cTitolo=new ZtVWeb._VC(this,'cTitolo',null,'character','<%=JSPLib.ToJSValue(cTitolo,false,true)%>',false,false);
this.cCateg=new ZtVWeb._VC(this,'cCateg',null,'character','<%=JSPLib.ToJSValue(cCateg,false,true)%>',false,false);
this.cTesto=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cTesto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"IBDESCRI","fixed":"false","floating_placeholder":false,"h":260,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"","h":260,"hide":"false","w":319,"x":1,"y":5},"480":{"anchor":"","h":260,"hide":"false","w":478,"x":1,"y":5},"768":{"anchor":"","h":260,"hide":"false","w":766,"x":1,"y":5}},"maxlength":"","name":"cTesto","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"memo","value":"<%=JSPLib.ToJSValue(cTesto,false,true)%>","w":766,"x":1,"y":5,"zerofilling":false,"zindex":"5","zoom":""});
this.Repeat5=new ZtVWeb.RepeatCtrl(this,'<%=idPortlet%>_Repeat5','Repeat5',153,275,766,1,-1,false,'false','pg_cgo_url_infbacheca_portlet.jsp','qbe_cgo_doc_infbacheca','pIBDCODICE=numinfo','IBDDESFILE,IDBNOMFILE,IBDCODICE','','<%=3%>',2,-1,1,5,'','','false','top-left(%)-right(%)',{"320":{"w":"766","anchor":"","x":1,"h":153,"y":275},"768":{"hide":"","w":766,"anchor":"","x":1,"h":153,"y":275},"480":{"w":"766","anchor":"","x":1,"h":153,"y":275}},'<%=JSPLib.cmdHash("pg_cgo_url_infbacheca_portlet.jsp",session)%>');
this.Repeat5.bUrl='<%=JSPLib.ToJSValue(Repeat5_bUrl)%>'
this.Repeat5.UrlParms='<%=JSPLib.ToJSValue(Repeat5_parms)%>'
this.Repeat5.NextHref='<%=JSPLib.ToJSValue(Repeat5_bUrl)%>'+'?page_Repeat5<%=Repeat5_Counter%>=<%=(conn_Repeat5.GetPage()+1)%><%=JSPLib.ToJSValue(Repeat5_parms)%>';
this.Repeat5.PrevHref='<%=JSPLib.ToJSValue(Repeat5_bUrl)%>'+'?page_Repeat5<%=Repeat5_Counter%>=<%=(conn_Repeat5.GetPage()-1)%><%=JSPLib.ToJSValue(Repeat5_parms)%>';
this.Repeat5.n_rec=<%=Repeat5_RecordNumber%>;
this.Repeat5.eof=<%=conn_Repeat5.Eof()%>
this.Repeat5.bof=<%=!conn_Repeat5.HasPrev()%>
this.Repeat5.currPage=<%=conn_Repeat5.GetPage()%>
this.Repeat5.nPages=<%=Repeat5_n_pages%>
this.Repeat5.Counter=<%=Repeat5_Counter%>
this.Image6=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image6_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image6","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96a;","font_image_hover":"&#xe96b;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":40,"help_tips":"<%=JSPLib.ToJSValue("Conferma lettura",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"320":{"anchor":"","h":40,"hide":"false","w":16,"x":152,"y":442},"480":{"anchor":"","h":40,"hide":"false","w":24,"x":228,"y":442},"768":{"anchor":"","font_size":"","h":40,"hide":"false","w":40,"x":363,"y":442}},"name":"Image6","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96a;","srchover":"&#xe96b;","tabindex":"","target":"","type":"Image","type_submit":"false","w":40,"x":363,"y":442,"zindex":"7"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTConfirmRead=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTConfirmRead","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTConfirmRead","offline":false,"page":1,"parms":"pInfo=numinfo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_cgo_confread_infbacheca","target":"","type":"SPLinker","w":120,"x":796,"y":-10});
this.RTConfirmRead.m_cID='<%=JSPLib.cmdHash("routine,arfn_cgo_confread_infbacheca",request.getSession())%>';
this.confermaBacheca=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_confermaBacheca","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"confermaBacheca","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":133,"x":784,"y":-63});
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
<%if(request.getAttribute("pg_cgo_dett_infbacheca_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_dett_infbacheca_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_dett_infbacheca_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image6.dispatchEvent('OnLoad');
window.<%=idPortlet%>.confermaBacheca.setParms();
window.<%=idPortlet%>.SQLDettInfo.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_dett_infbacheca',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_dett_infbacheca');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{
sp.emptyQueryParameters();
if( conn_Repeat5!=null ) {
	conn_Repeat5.Close();
 }%><%}
if(!included){%>
</html>
<%}
sp.endPage("pg_cgo_dett_infbacheca");
}%>
<%! public String getJSPUID() { return "1833832742"; } %>