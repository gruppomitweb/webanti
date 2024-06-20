<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var isAndroid= !!window.navigator.userAgent.match( \u002fandroid\u002fi );\n\nthis.lblDownload.Ctrl.style.verticalAlign=\"bottom\";\nthis.lblDownload.Ctrl.style.lineHeight=\"30px\";\n\nfunction isIAR(){\n  return navigator.userAgent.match(\u002fzRuntime\u002f);\n}\n\nfunction downloadApp_Click(){\n  window.open(\"..\u002fenterpriseappstore.apk\",\"_self\");\n\n}\n\nfunction this_Loaded(){\n  var existsHybridEnterpriseAppStore=\u003c%=com.zucchetti.sitepainter.Library.existsHybridEnterpriseAppStore()%\u003e;\n  if(!isAndroid || !existsHybridEnterpriseAppStore || this.isIAR()){\n    this.downloadApp.Hide();\n    this.lblDownload.Hide();\n  }\n  var portletW = this.Ctrl.clientWidth;\n  var lblTitle = this.lblTitle.Ctrl;\n  var lblTitleEnd = parseInt( lblTitle.style.width, 10) + parseInt( lblTitle.style.left, 10);\n  var lblDownload = this.lblDownload.Ctrl;\n  var lblDownloadStart = parseInt( lblDownload.style.width, 10) + parseInt( lblDownload.style.right, 10);\n  if ( portletW - lblTitleEnd \u003c lblDownloadStart ) {\n    this.lblDownload.Hide();\n  }\n}\n\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"spappstore_header","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"weight\":\"\",\"font_color\":\"#FFFFFF\",\"align\":\"left\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label_title\",\"selector\":\".spappstore_header .label_title.light\",\"value\":\"Azienda\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".spappstore_header .label_title.light {\\n  font-weight: 300;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"weight\":\"\",\"font_color\":\"#FFFFFF\",\"align\":\"left\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label_title\",\"selector\":\".spappstore_header .label_title\",\"value\":\"Azienda\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".spappstore_header .label_title {\\n  color: #FFFFFF;\\n  text-align: left;\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"59","hsl":"","htmlcode":"{{ Box7 }}\n{{ lblDownload }}\n{{ image8 }}\n{{ lblTitle }}\n{{ lblAzi }}\n{{ downloadApp }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"315","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","bg_color":"#21272C","border_color":"#000000","border_weight":"0","class_Css":"box","create_undercond":"","h":"59","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"Box7","page":"1","sequence":"1","shrinkable":"","stretch":"false","target":"","type":"Box","w":"315","wireframe_props":"","x":"0","y":"0","zindex":"0"},{"align":"right","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblDownload","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"SPAS_DOWNLOAD_ENTERPRISEAPPSTORE_APP","w":"200","wireframe_props":"align,value,n_col","x":"59","y":"21","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"27","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image8","page":"1","path_type":"","sequence":"3","server_side":"","src":"..\u002fimages\u002fspas_header_infinity_app_store.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"38","wireframe_props":"","x":"18","y":"20","zindex":"1"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"normal","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblTitle","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Demo","w":"138","wireframe_props":"align,value,n_col","x":"181","y":"21","zindex":"1"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_title light","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAzi","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Azienda","w":"102","wireframe_props":"align,value,n_col","x":"73","y":"21","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#FFFFFF","font_color_hover":"","font_image":"&#xeb5c;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layout_steps_values":"{}","name":"downloadApp","page":"1","path_type":"","sequence":"6","server_side":"","src":"..\u002fimages\u002fbackclock.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"265","y":"14","zindex":"1"}]%>
<%/*Description:*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.spas_pheaderstore_container .spappstore_header .label_title.light{  color: #FFFFFF;
  text-align: left;
}
.spas_pheaderstore_container .spappstore_header .label_title{
  color: #FFFFFF;
  text-align: left;
}
.spas_pheaderstore_container {
}
.spas_pheaderstore_title_container {
  margin: auto;
}
.spas_pheaderstore_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:315px;
  height:59px;
  background-color:#FFFFFF;
}
.spas_pheaderstore_portlet[Data-page="1"]{
  height:59px;
  width:100%;
}
.spas_pheaderstore_portlet > .Box7_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:59px;
  display:flex;
  flex-direction:column;
}
.spas_pheaderstore_portlet > .Box7_ctrl {
  height:59px;
}
.spas_pheaderstore_portlet > .Box7_ctrl > .box_content {
  height:100%;
}
.spas_pheaderstore_portlet > .Box7_ctrl {
  min-height:59px;
  background-color:#21272C;
  border-width:0px;
  border-style:solid;
  border-color:#000000;
}
.spas_pheaderstore_portlet > .lblDownload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:21px;
  right:56px;
  width:200px;
  height:auto;
  min-height:25px;
}
.spas_pheaderstore_portlet > .lblDownload_ctrl {
  height:auto;
  min-height:25px;
}
.spas_pheaderstore_portlet > .lblDownload_ctrl {
  overflow:hidden;
  font-family:Verdana;
  color:#FFFFFF;
  text-align:right;
  background-color:transparent;
}
.spas_pheaderstore_portlet > .image8_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:18px;
  width:38px;
  height:27px;
}
.spas_pheaderstore_portlet > .image8_ctrl {
}
.spas_pheaderstore_portlet > .image8_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spas_pheaderstore_portlet > .lblTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:21px;
  left:181px;
  width:138px;
  height:auto;
  min-height:25px;
}
.spas_pheaderstore_portlet > .lblTitle_ctrl {
  height:auto;
  min-height:25px;
}
.spas_pheaderstore_portlet > .lblTitle_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#FFFFFF;
  text-align:left;
  background-color:transparent;
}
.spas_pheaderstore_portlet > .lblAzi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:21px;
  left:73px;
  width:102px;
  height:auto;
  min-height:25px;
}
.spas_pheaderstore_portlet > .lblAzi_ctrl {
  height:auto;
  min-height:25px;
}
.spas_pheaderstore_portlet > .lblAzi_ctrl {
  overflow:hidden;
}
.spas_pheaderstore_portlet > .downloadApp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  right:20px;
  width:30px;
  height:30px;
}
.spas_pheaderstore_portlet > .downloadApp_ctrl {
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
 String def="[{\"h\":\"59\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"315\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"59\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"315\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"align\":\"right\",\"anchor\":\"top-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"SPAS_DOWNLOAD_ENTERPRISEAPPSTORE_APP\",\"w\":\"200\",\"x\":\"59\",\"y\":\"21\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"27\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"38\",\"x\":\"18\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Demo\",\"w\":\"138\",\"x\":\"181\",\"y\":\"21\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Azienda\",\"w\":\"102\",\"x\":\"73\",\"y\":\"21\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"265\",\"y\":\"14\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_pheaderstore","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_pheaderstore_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spas_pheaderstore','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDownload= "SPAS_DOWNLOAD_ENTERPRISEAPPSTORE_APP";
String lblTitle= "Demo";
String lblAzi= "Azienda";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spas_pheaderstore_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spas_pheaderstore_portlet spappstore_header' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spas_pheaderstore','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Box7' class='Box7_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box7_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_lblDownload'  formid='<%=idPortlet%>' ps-name='lblDownload'    class='label lblDownload_ctrl'><div id='<%=idPortlet%>_lblDownloadtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("SPAS_DOWNLOAD_ENTERPRISEAPPSTORE_APP"))%></div></span>
<div id='<%=idPortlet%>_image8'>
<img id='<%=idPortlet%>_image8_img' class='image image8_ctrl' src="../images/spas_header_infinity_app_store.png" >
</div>
<span id='<%=idPortlet%>_lblTitle'  formid='<%=idPortlet%>' ps-name='lblTitle'    class='label_title lblTitle_ctrl'><div id='<%=idPortlet%>_lblTitletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Demo"))%></div></span>
<span id='<%=idPortlet%>_lblAzi'  formid='<%=idPortlet%>' ps-name='lblAzi'    class='label_title light lblAzi_ctrl'><div id='<%=idPortlet%>_lblAzitbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Azienda"))%></div></span>
<a id='<%=idPortlet%>_downloadApp' class='image downloadApp_ctrl'   target=''>&#xeb5c;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spas_pheaderstore');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spas_pheaderstore',["315"],["59"],'spappstore_header',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"315","h":"59","title":"","layer":"false","npage":"1"}]);
this.Box7=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"#21272C","border_color":"#000000","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box7","groupName":"","h":59,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box7","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":315,"x":0,"y":0,"zindex":"0"});
this.lblDownload=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDownload","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#FFFFFF","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDownload","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblDownload),false,true)%>","type":"Label","w":200,"x":59,"y":21,"zindex":"1"});
this.image8=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image8_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image8","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":27,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image8","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fspas_header_infinity_app_store.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":38,"x":18,"y":20,"zindex":"1"});
this.lblTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label_title","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FFFFFF","font_size":"","font_weight":"normal","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitle","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblTitle),false,true)%>","type":"Label","w":138,"x":181,"y":21,"zindex":"1"});
this.lblAzi=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label_title light","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAzi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAzi","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblAzi),false,true)%>","type":"Label","w":102,"x":73,"y":21,"zindex":"1"});
this.downloadApp=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image downloadApp_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_downloadApp","edit_undercond":"","field":"","font_color":"#FFFFFF","font_color_hover":"","font_image":"&#xeb5c;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"downloadApp","page":1,"path_type":"","server_side":"","src":"&#xeb5c;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":265,"y":14,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
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
<%request.setAttribute("spas_pheaderstore_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spas_pheaderstore_Static=function(){
if(typeof isIAR !='undefined')this.isIAR=isIAR;
if(typeof downloadApp_Click !='undefined')this.downloadApp_Click=downloadApp_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var isAndroid= !!window.navigator.userAgent.match( /android/i );
this.lblDownload.Ctrl.style.verticalAlign="bottom";
this.lblDownload.Ctrl.style.lineHeight="30px";
function isIAR(){
  return navigator.userAgent.match(/zRuntime/);
}
function downloadApp_Click(){
  window.open("../enterpriseappstore.apk","_self");
}
function this_Loaded(){
  var existsHybridEnterpriseAppStore=<%=com.zucchetti.sitepainter.Library.existsHybridEnterpriseAppStore()%>;
  if(!isAndroid || !existsHybridEnterpriseAppStore || this.isIAR()){
    this.downloadApp.Hide();
    this.lblDownload.Hide();
  }
  var portletW = this.Ctrl.clientWidth;
  var lblTitle = this.lblTitle.Ctrl;
  var lblTitleEnd = parseInt( lblTitle.style.width, 10) + parseInt( lblTitle.style.left, 10);
  var lblDownload = this.lblDownload.Ctrl;
  var lblDownloadStart = parseInt( lblDownload.style.width, 10) + parseInt( lblDownload.style.right, 10);
  if ( portletW - lblTitleEnd < lblDownloadStart ) {
    this.lblDownload.Hide();
  }
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spas_pheaderstore_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.downloadApp.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','spas_pheaderstore',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spas_pheaderstore');
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
sp.endPage("spas_pheaderstore");
}%>
<%! public String getJSPUID() { return "2019698700"; } %>