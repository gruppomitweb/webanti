<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nif( EntityStatus() == \"N\") {\n  this.pwd3.Show()\n  this.label_YYYRCYYISO.Show()\n\tthis.box_pwd.Show()\n  \u002f\u002f utente di tipo macchina\n  Set_accesstype_human(false);\n  Set_accesstype_service(false);\n  Set_accesstype_machine(true);\n}\nfunction pwd3_onChange(){\n  \u002f\u002f change pwd2 and pwd1\n  w_pwd1 = w_pwd2 = this.pwd3.Value();\n}","adaptive":"","altInterfaceFor":"SPManageOIDCClients","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label_ZRXEDHLHRU }}{{ @code }}{{ @label_GONJPLYFCM }}{{ @fullname }}{{ @label_LWKHSAVZHT }}{{ @name }}{{ @label_YYYRCYYISO }}{{ @label_WNFOFUHXXF }}{{ @pwdcomplexity_group }}{{ @label_XCVHSJEHUH }}{{ @pwdcomplexity }}{{ @label_OXCBAQDUEO }}{{ @pwddaysduration_group }}{{ @label_CNLYOZMXLI }}{{ @pwddaysduration }}{{ @label_INOSWBMEWD }}{{ @pwdciclicity_groups }}{{ @label_KRTEQHMKQD }}{{ @pwdciclicity }}{{ @label_ONZAKKFAAI }}{{ @pwdcaptchalevel_group }}{{ @label_SWHXFUZIRC }}{{ @captchalevel }}{{ @pwdratecause }}{{ @Textbox104 }}{{ @pwd3 }}{{ @Box8 }}{{ @box_pwd }}\u003c\u002fbody\u003e","grapesCss":"","h":"166","hsl":"","htmlcode":" \n \n \n \n{{ @label_ZRXEDHLHRU }} \n{{ @code }} \n{{ @label_GONJPLYFCM }} \n{{ @fullname }} \n{{ @label_LWKHSAVZHT }} \n{{ @name }} \n \n \n{{ @label_YYYRCYYISO }} \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n{{ @label_WNFOFUHXXF }} \n{{ @pwdcomplexity_group }} \n{{ @label_XCVHSJEHUH }} \n{{ @pwdcomplexity }} \n{{ @label_OXCBAQDUEO }} \n{{ @pwddaysduration_group }} \n{{ @label_CNLYOZMXLI }} \n{{ @pwddaysduration }} \n{{ @label_INOSWBMEWD }} \n{{ @pwdciclicity_groups }} \n{{ @label_KRTEQHMKQD }} \n{{ @pwdciclicity }} \n{{ @label_ONZAKKFAAI }} \n{{ @pwdcaptchalevel_group }} \n{{ @label_SWHXFUZIRC }} \n{{ @captchalevel }} \n{{ @pwdratecause }} \n{{ @pwd3 }} \n{{ @box_pwd }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"false","pages":"1","pagesProp":"[{\"h\":\"166\",\"w\":\"603\",\"title\":\"\",\"layer\":\"false\",\"layout_steps_values\":{},\"altInterfacePage\":true}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"true","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"603","wizard":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_ZRXEDHLHRU","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"ZRXEDHLHRU","tabindex":"4","target":"","template_code":"","type":"Label","value":"ADMIN_CODE","w":"196","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"1","zone":"CIUGDDXJMR"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"12","name":"code","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"true","readonly":"false","scroll":"false","sequence":"2","spuid":"CIUGDDXJMR","tabindex":"5","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"76","wireframe_props":"name","x":"210","y":"20","zerofilling":"false","zindex":"1","zone":"CIUGDDXJMR","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_GONJPLYFCM","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"GONJPLYFCM","tabindex":"6","target":"","template_code":"","type":"Label","value":"ADMIN_DESCRIPTION","w":"196","wireframe_props":"align,value,n_col","x":"5","y":"55","zindex":"1","zone":"YOMCOSHNCV"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"2048","name":"fullname","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"true","readonly":"false","scroll":"false","sequence":"4","spuid":"YOMCOSHNCV","tabindex":"7","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"374","wireframe_props":"name","x":"210","y":"55","zerofilling":"false","zindex":"1","zone":"YOMCOSHNCV","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_LWKHSAVZHT","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"LWKHSAVZHT","tabindex":"8","target":"","template_code":"","type":"Label","value":"Client ID","w":"196","wireframe_props":"align,value,n_col","x":"5","y":"90","zindex":"1","zone":"ZOLPGDGKUC"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"50","name":"name","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"true","readonly":"false","scroll":"false","sequence":"6","spuid":"ZOLPGDGKUC","tabindex":"9","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"374","wireframe_props":"name","x":"210","y":"90","zerofilling":"false","zindex":"1","zone":"ZOLPGDGKUC","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_YYYRCYYISO","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"YYYRCYYISO","tabindex":"11","target":"","template_code":"","type":"Label","value":"Secret","w":"196","wireframe_props":"align,value,n_col","x":"5","y":"125","zindex":"1","zone":"GMYTSOEEXH"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"w_pwd2","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"true","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"pwd3","page":"1","password":"true","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"374","wireframe_props":"name","x":"210","y":"125","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"false","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"34","hide":"true","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"box_pwd","page":"1","rapp":"","sequence":"9","shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"false","type":"Box","w":"593","wireframe_props":"","x":"1","y":"120","zindex":"0","zone":""}]%>
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
window.SPManageOIDCClients_Static=function(){
if(typeof pwd3_onChange !='undefined')this.pwd3_onChange=pwd3_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(w_pwd2,this.pwd3);

if( EntityStatus() == "N") {
  this.pwd3.Show()
  this.label_YYYRCYYISO.Show()
	this.box_pwd.Show()
  // utente di tipo macchina
  Set_accesstype_human(false);
  Set_accesstype_service(false);
  Set_accesstype_machine(true);
}
function pwd3_onChange(){
  // change pwd2 and pwd1
  w_pwd1 = w_pwd2 = this.pwd3.Value();
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
.SPManageOIDCClients_container {
}
.SPManageOIDCClients_portlet{
  position:relative;
  width:603px;
  min-width:603px;
  height:166px;
}
.SPManageOIDCClients_portlet[Data-page="1"]{
  height:166px;
  width:603px;
}
.SPManageOIDCClients_portlet > .label_ZRXEDHLHRU_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  width:196px;
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_ZRXEDHLHRU_ctrl {
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_ZRXEDHLHRU_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPManageOIDCClients_portlet > .code_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:210px;
  width:76px;
  height:25px;
}
.SPManageOIDCClients_portlet > .code_ctrl {
}
.SPManageOIDCClients_portlet > .code_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPManageOIDCClients_portlet > .label_GONJPLYFCM_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:55px;
  left:5px;
  width:196px;
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_GONJPLYFCM_ctrl {
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_GONJPLYFCM_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPManageOIDCClients_portlet > .fullname_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:55px;
  left:210px;
  width:374px;
  height:25px;
}
.SPManageOIDCClients_portlet > .fullname_ctrl {
}
.SPManageOIDCClients_portlet > .fullname_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPManageOIDCClients_portlet > .label_LWKHSAVZHT_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:90px;
  left:5px;
  width:196px;
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_LWKHSAVZHT_ctrl {
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_LWKHSAVZHT_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPManageOIDCClients_portlet > .name_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:90px;
  left:210px;
  width:374px;
  height:25px;
}
.SPManageOIDCClients_portlet > .name_ctrl {
}
.SPManageOIDCClients_portlet > .name_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPManageOIDCClients_portlet > .label_YYYRCYYISO_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:125px;
  left:5px;
  width:196px;
  height:auto;
  min-height:25px;
  display:none;
}
.SPManageOIDCClients_portlet > .label_YYYRCYYISO_ctrl {
  height:auto;
  min-height:25px;
}
.SPManageOIDCClients_portlet > .label_YYYRCYYISO_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPManageOIDCClients_portlet > .pwd3_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:125px;
  left:210px;
  width:374px;
  height:25px;
  display:none;
}
.SPManageOIDCClients_portlet > .pwd3_ctrl {
}
.SPManageOIDCClients_portlet > .pwd3_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPManageOIDCClients_portlet > .box_pwd_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:120px;
  left:1px;
  width:593px;
  height:auto;
  display:none;
  display:flex;
  flex-direction:column;
}
.SPManageOIDCClients_portlet > .box_pwd_ctrl {
  height:34px;
}
.SPManageOIDCClients_portlet > .box_pwd_ctrl > .box_content {
  height:100%;
}
.SPManageOIDCClients_portlet > .box_pwd_ctrl {
  border-width:0px;
  border-style:solid;
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
 String def="[{\"h\":\"166\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"603\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_CODE\",\"w\":\"196\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"code\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"76\",\"x\":\"210\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_GONJPLYFCM\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_DESCRIPTION\",\"w\":\"196\",\"x\":\"5\",\"y\":\"55\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"fullname\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"374\",\"x\":\"210\",\"y\":\"55\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_LWKHSAVZHT\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Client ID\",\"w\":\"196\",\"x\":\"5\",\"y\":\"90\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"name\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"374\",\"x\":\"210\",\"y\":\"90\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_YYYRCYYISO\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Secret\",\"w\":\"196\",\"x\":\"5\",\"y\":\"125\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"pwd3\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"374\",\"x\":\"210\",\"y\":\"125\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"34\",\"layout_steps_values\":{},\"name\":\"box_pwd\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"593\",\"x\":\"1\",\"y\":\"120\",\"zindex\":\"0\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPManageOIDCClients","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPManageOIDCClients_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,true); %><script>
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
.SPManageOIDCClients_portlet > .label_YYYRCYYISO_ctrl {
  display:none;
}
.SPManageOIDCClients_portlet > .pwd3_ctrl {
  display:none;
}
.SPManageOIDCClients_portlet > .box_pwd_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPManageOIDCClients','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label_ZRXEDHLHRU= "ADMIN_CODE";
double code= 0;
if(request.getAttribute("SPManageOIDCClients_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label_GONJPLYFCM= "ADMIN_DESCRIPTION";
String fullname= "";
String label_LWKHSAVZHT= "Client ID";
String name= "";
String label_YYYRCYYISO= "Secret";
String pwd3= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPManageOIDCClients_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPManageOIDCClients_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPManageOIDCClients','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='ZRXEDHLHRU'  formid='<%=idPortlet%>' ps-name='label_ZRXEDHLHRU'    class='label label_ZRXEDHLHRU_ctrl'><div id='ZRXEDHLHRUtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("ADMIN_CODE"))%></div></span>
<span class='textbox-container'id='CIUGDDXJMR_wrp'><input id='CIUGDDXJMR' name='code' type='text' maxlength='12' class='textbox' tabindex='5' formid='<%=idPortlet%>' ps-name='code' inputmode='numeric' /></span>
<span id='GONJPLYFCM'  formid='<%=idPortlet%>' ps-name='label_GONJPLYFCM'    class='label label_GONJPLYFCM_ctrl'><div id='GONJPLYFCMtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("ADMIN_DESCRIPTION"))%></div></span>
<span class='textbox-container'id='YOMCOSHNCV_wrp'><input id='YOMCOSHNCV' name='fullname' type='text' maxlength='2048' class='textbox' tabindex='7' formid='<%=idPortlet%>' ps-name='fullname' /></span>
<span id='LWKHSAVZHT'  formid='<%=idPortlet%>' ps-name='label_LWKHSAVZHT'    class='label label_LWKHSAVZHT_ctrl'><div id='LWKHSAVZHTtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Client ID"))%></div></span>
<span class='textbox-container'id='ZOLPGDGKUC_wrp'><input id='ZOLPGDGKUC' name='name' type='text' maxlength='50' class='textbox' tabindex='9' formid='<%=idPortlet%>' ps-name='name' /></span>
<span id='YYYRCYYISO'  formid='<%=idPortlet%>' ps-name='label_YYYRCYYISO'    class='label label_YYYRCYYISO_ctrl'><div id='YYYRCYYISOtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Secret"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_pwd3_wrp'><input id='<%=idPortlet%>_pwd3' name='pwd3' type='password' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='pwd3' /></span>
<div id='<%=idPortlet%>_box_pwd' class='box_pwd_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_box_pwd_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPManageOIDCClients');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPManageOIDCClients',["603"],["166"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"603","h":"166","altInterfacePage":true,"title":"","layer":"false"}]);
this.label_ZRXEDHLHRU=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"ZRXEDHLHRU","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_ZRXEDHLHRU","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"ZRXEDHLHRU","tabindex":"4","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_ZRXEDHLHRU),false,true)%>","type":"Label","w":196,"x":5,"y":20,"zindex":"1"});
this.code=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"CIUGDDXJMR","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"12","name":"code","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"CIUGDDXJMR","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=code%>","w":76,"x":210,"y":20,"zerofilling":false,"zindex":"1","zoom":""});
this.label_GONJPLYFCM=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"GONJPLYFCM","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_GONJPLYFCM","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"GONJPLYFCM","tabindex":"6","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_GONJPLYFCM),false,true)%>","type":"Label","w":196,"x":5,"y":55,"zindex":"1"});
this.fullname=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"YOMCOSHNCV","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"2048","name":"fullname","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"YOMCOSHNCV","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(fullname,false,true)%>","w":374,"x":210,"y":55,"zerofilling":false,"zindex":"1","zoom":""});
this.label_LWKHSAVZHT=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"LWKHSAVZHT","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_LWKHSAVZHT","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"LWKHSAVZHT","tabindex":"8","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_LWKHSAVZHT),false,true)%>","type":"Label","w":196,"x":5,"y":90,"zindex":"1"});
this.name=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"ZOLPGDGKUC","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"name","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"ZOLPGDGKUC","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(name,false,true)%>","w":374,"x":210,"y":90,"zerofilling":false,"zindex":"1","zoom":""});
this.label_YYYRCYYISO=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"YYYRCYYISO","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_YYYRCYYISO","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"YYYRCYYISO","tabindex":"11","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_YYYRCYYISO),false,true)%>","type":"Label","w":196,"x":5,"y":125,"zindex":"1"});
this.pwd3=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"w_pwd2","create_undercond":"","ctrlid":"<%=idPortlet%>_pwd3","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"pwd3","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(pwd3,false,true)%>","w":374,"x":210,"y":125,"zerofilling":false,"zindex":"3","zoom":""});
this.box_pwd=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_box_pwd","groupName":"","h":34,"hide":"true","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"box_pwd","page":1,"shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","titled":"false","type":"Box","w":593,"x":1,"y":120,"zindex":"0"});
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
<%if(request.getAttribute("SPManageOIDCClients_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPManageOIDCClients_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPManageOIDCClients_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPManageOIDCClients',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPManageOIDCClients');
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
sp.endPage("SPManageOIDCClients");
}%>
<%! public String getJSPUID() { return "3294315293"; } %>