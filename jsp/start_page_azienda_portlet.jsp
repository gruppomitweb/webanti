<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function dataobj_companies_ConsumersRendered(){\n  this.Variable_count_company.Value(this.dataobj_companies.GetQueryCount());\n  if(this.Variable_count_company.Value()==1){\n    this.g_codazi.Value(this.dataobj_companies.rs.codazi);\n    this.RTChgAzi.Link();\n    this.g_codazi.Disabled()\n    this.btnChgAzi.Hide()\n  }else{\n    if(!Empty(this.gAzienda.Value())){\n      this.g_codazi.Value(this.gAzienda.Value());\n    }\n  }\n}\n\nfunction btnChgAzi_Click(){\n  this.RTChgAzi.Link()\n}\n\nfunction RTChgAzi_Result(result){\n  this.CambioAzienda.Emit()\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Dati Azienda","fixed_top":"true","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"80","hsl":"","htmlcode":"{{ @lblCompany }}\n{{ @lblCompan{{ @gAzienda }}y }}\n{{ @g_codazi }}\n{{ @btnChgAzi }}\n{{ @gListAzi }}\n{{ @dataobj_companies }}\n{{ @RTChgAzi }}\n{{ @CambioAzienda }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"empty","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"pagelet","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"100","version":"37","w":"100%","wizard":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":" #EBF909","font_size":"","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblCompany","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_COMPANY","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"dataobj_companies","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"verdana","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"g_codazi","page":"1","picture":"","sequence":"2","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":"true","w":"70","wireframe_props":"name,textlist","x":"15","y":"25","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#FFFFFF","font_color_hover":"#EBF909","font_image":"&#xe96c;","font_image_hover":"&#xe96d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Seleziona l'azienda","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnChgAzi","page":"1","path_type":"","sequence":"3","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"34","y":"49","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gListAzi","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"157","x":"116","y":"-16"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"100","name":"dataobj_companies","offline":"false","page":"1","parms":"pcodazi=gListAzi","parms_source":"","query":"qbe_login_companies_filtered","query_async":"true","return_fields_type":"true","sequence":"5","type":"SQLDataobj","w":"157","x":"116","y":"8"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"Variable_count_company","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"157","x":"116","y":"31"},{"allowedentities":"arfn_chgazi","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChgAzi","offline":"false","page":"1","parms":"pCodAzi=g_codazi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arfn_chgazi","target":"","type":"SPLinker","w":"157","x":"116","y":"56"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"CambioAzienda","page":"1","parmsNames":"count_company","parmsTypes":"var","parmsValues":"Variable_count_company","persistent":"true","sequence":"8","type":"EventEmitter","w":"157","x":"116","y":"81"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"157","x":"116","y":"-41"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","font_color":"#232323","h":"99","hide":"","layer":"","layout_steps_values":"{}","name":"Note9","page":"1","sequence":"10","spuid":"","type":"Note","value":"Al cambio di azienda ricarico tutto ma solo se ho più di un azienda.\nAttenzione se c'è solo un azienda collegata non lo fa e non attivarlo altrimenti va in loop\n(vedi action code di start_page_data)","w":"463","wireframe_props":"","x":"322","y":"-43","zindex":"3"}]%>
<%/*Description:Dati Azienda*/%>
<%/*ParamsRequest:g_codazi*/%>
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
window.start_page_azienda_Static=function(){
if(typeof dataobj_companies_ConsumersRendered !='undefined')this.dataobj_companies_ConsumersRendered=dataobj_companies_ConsumersRendered;
if(typeof btnChgAzi_Click !='undefined')this.btnChgAzi_Click=btnChgAzi_Click;
if(typeof RTChgAzi_Result !='undefined')this.RTChgAzi_Result=RTChgAzi_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_companies.addRowConsumer(this.g_codazi);
function dataobj_companies_ConsumersRendered(){
  this.Variable_count_company.Value(this.dataobj_companies.GetQueryCount());
  if(this.Variable_count_company.Value()==1){
    this.g_codazi.Value(this.dataobj_companies.rs.codazi);
    this.RTChgAzi.Link();
    this.g_codazi.Disabled()
    this.btnChgAzi.Hide()
  }else{
    if(!Empty(this.gAzienda.Value())){
      this.g_codazi.Value(this.gAzienda.Value());
    }
  }
}
function btnChgAzi_Click(){
  this.RTChgAzi.Link()
}
function RTChgAzi_Result(result){
  this.CambioAzienda.Emit()
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
.start_page_azienda_container {
}
.start_page_azienda_portlet{
  position:relative;
  width:100%;
  min-width:100px;
  height:80px;
}
.start_page_azienda_portlet[Data-page="1"]{
  height:80px;
  width:100%;
}
.start_page_azienda_portlet > .lblCompany_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.start_page_azienda_portlet > .lblCompany_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_azienda_portlet > .lblCompany_ctrl {
  overflow:hidden;
  font-weight:normal;
  color: #EBF909;
  text-align:center;
  background-color:transparent;
}
.start_page_azienda_portlet > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:15px;
  left:15.0%;
  right:15px;
  right:15.0%;
  width:auto;
  height:20px;
}
.start_page_azienda_portlet > .btnChgAzi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:34px;
  left:34.0%;
  right:36px;
  right:36.0%;
  width:auto;
  height:30px;
}
.start_page_azienda_portlet > .btnChgAzi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
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
 String def="[{\"h\":\"80\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_COMPANY\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"g_codazi\",\"page\":\"1\",\"textlist\":\"desazi\",\"type\":\"Combobox\",\"w\":\"70\",\"x\":\"15\",\"y\":\"25\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnChgAzi\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"34\",\"y\":\"49\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"gListAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"157\",\"x\":\"116\",\"y\":\"-16\"},{\"h\":\"20\",\"name\":\"dataobj_companies\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"157\",\"x\":\"116\",\"y\":\"8\"},{\"h\":\"20\",\"name\":\"Variable_count_company\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"157\",\"x\":\"116\",\"y\":\"31\"},{\"h\":\"20\",\"name\":\"RTChgAzi\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"157\",\"x\":\"116\",\"y\":\"56\"},{\"h\":\"20\",\"name\":\"CambioAzienda\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"157\",\"x\":\"116\",\"y\":\"81\"},{\"h\":\"20\",\"name\":\"gAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"157\",\"x\":\"116\",\"y\":\"-41\"},{\"anchor\":\"\",\"h\":\"99\",\"layout_steps_values\":{},\"name\":\"Note9\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"Al cambio di azienda ricarico tutto ma solo se ho più di un azienda.\\nAttenzione se c'è solo un azienda collegata non lo fa e non attivarlo altrimenti va in loop\\n(vedi action code di start_page_data)\",\"w\":\"463\",\"x\":\"322\",\"y\":\"-43\",\"zindex\":\"3\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_azienda","UTF-8")) {return; }
 %><%if(request.getAttribute("javax.servlet.include.request_uri")==null && request.getParameter("clientsideinclusion")==null){
if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_azienda_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_azienda','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblCompany= "MSG_COMPANY";
String g_codazi=JSPLib.translateXSS(sp.getParameter("g_codazi",""));
String gListAzi=sp.getGlobal("gListAzi","");
String Variable_count_company= "";
String gAzienda=sp.getGlobal("gAzienda","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_azienda_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_azienda_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_azienda','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblCompany'  formid='<%=idPortlet%>' ps-name='lblCompany'    class='label lblCompany_ctrl'><div id='<%=idPortlet%>_lblCompanytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_COMPANY"))%></div></span>
<select id='<%=idPortlet%>_g_codazi' name='g_codazi' class='combobox' style='font-family:verdana;' tabindex='4'></select>
<a id='<%=idPortlet%>_btnChgAzi' class='image-default btnChgAzi_ctrl'   target=''>&#xe96c;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_azienda');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_azienda',["100"],["80"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','true',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"80","title":"","layer":"false","npage":"1"}]);
this.lblCompany=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCompany","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":" #EBF909","font_size":"","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCompany","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblCompany),false,true)%>","type":"Label","w":100,"x":0,"y":0,"zindex":"1"});
this.g_codazi=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_g_codazi","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=g_codazi%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"g_codazi","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":true,"w":70,"x":15,"y":25,"zindex":"1"});
this.btnChgAzi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default btnChgAzi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnChgAzi","edit_undercond":"","field":"","font_color":"#FFFFFF","font_color_hover":"#EBF909","font_image":"&#xe96c;","font_image_hover":"&#xe96d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Seleziona l'azienda"),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnChgAzi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":34,"y":49,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.gListAzi=new ZtVWeb._VC(this,'gListAzi',null,'character','<%=JSPLib.ToJSValue(gListAzi,false,true)%>',false,false);
this.dataobj_companies=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_login_companies_filtered","cmdHash":"<%=JSPLib.cmdHash("qbe_login_companies_filtered",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_companies","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_companies","nrows":"100","page":1,"parms":"pcodazi=gListAzi","parms_source":"","type":"SQLDataobj","w":157,"x":116,"y":8});
this.Variable_count_company=new ZtVWeb._VC(this,'Variable_count_company',null,'character','<%=JSPLib.ToJSValue(Variable_count_company,false,true)%>',false,false);
this.RTChgAzi=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_chgazi",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChgAzi","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChgAzi","offline":false,"page":1,"parms":"pCodAzi=g_codazi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_chgazi","target":"","type":"SPLinker","w":157,"x":116,"y":56});
this.RTChgAzi.m_cID='<%=JSPLib.cmdHash("routine,arfn_chgazi",request.getSession())%>';
this.CambioAzienda=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_CambioAzienda","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"CambioAzienda","page":1,"parmsNames":"count_company","parmsTypes":"var","parmsValues":"Variable_count_company","persistent":"true","type":"EventEmitter","w":157,"x":116,"y":81});
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
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
<%if(request.getAttribute("start_page_azienda_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("start_page_azienda_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.start_page_azienda_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnChgAzi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.CambioAzienda.setParms();
window.<%=idPortlet%>.dataobj_companies.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_azienda',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_azienda');
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
sp.endPage("start_page_azienda");
}%>
<%! public String getJSPUID() { return "1112875941"; } %>