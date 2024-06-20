<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var ua = navigator.userAgent\n  , device = \"\u003c%=JSPLib.GetUserAgent(request)%\u003e\"\n  , logged = \u003c%=sp.isLogged()%\u003e\n  , inIframe = self.location.href!=parent.location.href\n  , skin = \"\u003c%=sp.getSkin()%\u003e\"\n;\n\nvar item_rifpdetail;\nvar qrcode;\n\nfunction this_Loaded(){\n  this.lbl_istruction.Ctrltbl.style.verticalAlign = \"middle\";\n  this.lbl_istruction.Ctrltbl.style.fontStyle = \"italic\";\n  qrcode=new QRCode(this.qrSide.ctrlid+'_td', {\n    width: 200,\n    height: 200,\n    colorDark : \"black\",\n    colorLight : \"white\",\n    correctLevel : QRCode.CorrectLevel.H\n  });  \n\n}\n\nfunction setParameters(title,descr,logo,url){\n  this.lbl_title.Value(title);\n  this.logo.Value(logo);\n  qrcode.makeCode(url);\n  this.urlOfQr.Value(url);\n  this.urlOfQr.Href(url);\n}\n\nfunction setItem_rifpdetail(rifPortlet){\n \titem_rifpdetail=rifPortlet; \n}\n\nfunction closeDetail_Click(){\n  item_rifpdetail.hideQrDetail();\n}","adaptive":"","author":"Zucchetti SitePainter","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"390","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"visualweb\u002fqrcode2.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","tag":"","title":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"","author":"Zucchetti SitePainter","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"90","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"logo","page":"1","path_type":"","sequence":"2","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"90","wireframe_props":"","x":"9","y":"9","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","author":"Zucchetti SitePainter","bg_color":"","calculate":"","class_Css":"label_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"82","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_title","nowrap":"false","page":"1","picture":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"lbl_title","w":"250","wireframe_props":"align,value,n_col","x":"109","y":"17","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","author":"Zucchetti SitePainter","bg_color":"transparent","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"9pt","font_weight":"normal","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_istruction","nowrap":"false","page":"1","picture":"","sequence":"10","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"SPAS_SCAN_QR_INFO","w":"400","wireframe_props":"align,value,n_col","x":"2","y":"109","zindex":"1"},{"alt":"","anchor":"","author":"Zucchetti SitePainter","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#B5B5B5","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_size":"","h":"26","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layout_steps_values":"{}","name":"closeDetail","page":"1","path_type":"","sequence":"12","server_side":"","src":"..\u002fimages\u002fbackclock.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"26","wireframe_props":"","x":"365","y":"14","zindex":"1"},{"anchor":"bottom-left","author":"Zucchetti SitePainter","bg_color":"#FFFFFF","border_color":"#000000","border_weight":"0","class_Css":"box","create_undercond":"","h":"200","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"qrSide","page":"1","sequence":"13","stretch":"false","type":"Box","w":"200","wireframe_props":"","x":"102","y":"143","zindex":"0"},{"align":"center","anchor":"top-left-right","assoc_input":"","author":"Zucchetti SitePainter","bg_color":"transparent","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"''","init":"","layout_steps_values":"{}","n_col":"1","name":"urlOfQr","nowrap":"false","page":"1","picture":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"blank","type":"Label","value":"","w":"400","wireframe_props":"align,value,n_col","x":"0","y":"363","zindex":"1"}]%>
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
.spas_pqrdetail_app_container {
}
.spas_pqrdetail_app_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:390px;
  background-color:#F3F3F3;
}
.spas_pqrdetail_app_portlet[Data-page="1"]{
  height:390px;
  width:100%;
}
.spas_pqrdetail_app_portlet > .logo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:9px;
  width:90px;
  height:90px;
}
.spas_pqrdetail_app_portlet > .logo_ctrl {
}
.spas_pqrdetail_app_portlet > .logo_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spas_pqrdetail_app_portlet > .lbl_title_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:109px;
  right:41px;
  width:auto;
  height:auto;
  min-height:82px;
}
.spas_pqrdetail_app_portlet > .lbl_title_ctrl {
  height:auto;
  min-height:82px;
}
.spas_pqrdetail_app_portlet > .lbl_title_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pqrdetail_app_portlet > .lbl_istruction_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:109px;
  left:2px;
  right:-2px;
  width:auto;
  height:auto;
  min-height:25px;
}
.spas_pqrdetail_app_portlet > .lbl_istruction_ctrl {
  height:auto;
  min-height:25px;
}
.spas_pqrdetail_app_portlet > .lbl_istruction_ctrl {
  overflow:hidden;
  font-size:9pt;
  font-weight:normal;
  text-align:center;
  background-color:transparent;
}
.spas_pqrdetail_app_portlet > .closeDetail_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:365px;
  width:26px;
  height:26px;
}
.spas_pqrdetail_app_portlet > .closeDetail_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:26px;
  font-size:26px;
  color:#B5B5B5;
}
.spas_pqrdetail_app_portlet > .qrSide_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  left:102px;
  bottom:47px;
  width:200px;
  height:auto;
  min-height:200px;
  display:flex;
  flex-direction:column;
}
.spas_pqrdetail_app_portlet > .qrSide_ctrl {
  height:200px;
}
.spas_pqrdetail_app_portlet > .qrSide_ctrl > .box_content {
  height:100%;
}
.spas_pqrdetail_app_portlet > .qrSide_ctrl {
  min-height:200px;
  background-color:#FFFFFF;
  border-width:0px;
  border-style:solid;
  border-color:#000000;
}
.spas_pqrdetail_app_portlet > .urlOfQr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:363px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:19px;
}
.spas_pqrdetail_app_portlet > .urlOfQr_ctrl a {
  height:auto;
  min-height:19px;
}
.spas_pqrdetail_app_portlet > .urlOfQr_ctrl a {
  overflow:hidden;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:center;
  background-color:transparent;
 display:block;
}
.spas_pqrdetail_app_portlet > .urlOfQr_ctrl > div > a:hover{
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:center;
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
 String def="[{\"h\":\"390\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"90\",\"x\":\"9\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"82\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"lbl_title\",\"w\":\"250\",\"x\":\"109\",\"y\":\"17\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"SPAS_SCAN_QR_INFO\",\"w\":\"400\",\"x\":\"2\",\"y\":\"109\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"26\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"26\",\"x\":\"365\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"bottom-left\",\"h\":\"200\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"200\",\"x\":\"102\",\"y\":\"143\",\"zindex\":\"0\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"400\",\"x\":\"0\",\"y\":\"363\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_pqrdetail_app","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_pqrdetail_app_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/qrcode2.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spas_pqrdetail_app','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lbl_title= "lbl_title";
String lbl_istruction= "SPAS_SCAN_QR_INFO";
String urlOfQr= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spas_pqrdetail_app_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spas_pqrdetail_app_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spas_pqrdetail_app','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_logo'>
<img id='<%=idPortlet%>_logo_img' class='image logo_ctrl' src="" >
</div>
<span id='<%=idPortlet%>_lbl_title'  formid='<%=idPortlet%>' ps-name='lbl_title'    class='label_title lbl_title_ctrl'><div id='<%=idPortlet%>_lbl_titletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("lbl_title"))%></div></span>
<span id='<%=idPortlet%>_lbl_istruction'  formid='<%=idPortlet%>' ps-name='lbl_istruction'    class='label_description lbl_istruction_ctrl'><div id='<%=idPortlet%>_lbl_istructiontbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("SPAS_SCAN_QR_INFO"))%></div></span>
<a id='<%=idPortlet%>_closeDetail' class='image closeDetail_ctrl'   target=''>&#xe9c7;</a>
<div id='<%=idPortlet%>_qrSide' class='qrSide_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_qrSide_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_urlOfQr'  formid='<%=idPortlet%>' ps-name='urlOfQr'    class='label_description urlOfQr_ctrl'><div id='<%=idPortlet%>_urlOfQrtbl' style='width:100%;'><a id='<%=idPortlet%>_urlOfQrhref'  href='''' target='blank' ></a></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spas_pqrdetail_app');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spas_pqrdetail_app',["400"],["390"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"390","title":"","layer":"false","npage":"1"}]);
this.logo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image logo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_logo","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":90,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"logo","page":1,"path_type":"","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":90,"x":9,"y":9,"zindex":"1"});
this.lbl_title=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_title","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_title","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":82,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_title","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_title),false,true)%>","type":"Label","w":250,"x":109,"y":17,"zindex":"1"});
this.lbl_istruction=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_istruction","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"9pt","font_weight":"normal","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_istruction","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_istruction),false,true)%>","type":"Label","w":400,"x":2,"y":109,"zindex":"1"});
this.closeDetail=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image closeDetail_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_closeDetail","edit_undercond":"","field":"","font_color":"#B5B5B5","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"closeDetail","page":1,"path_type":"","server_side":"","src":"&#xe9c7;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":26,"x":365,"y":14,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.qrSide=new ZtVWeb.BoxCtrl(this,{"anchor":"bottom-left","bg_color":"#FFFFFF","border_color":"#000000","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_qrSide","groupName":"","h":200,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"qrSide","page":1,"shrinkable":"false","stretch":"false","target":"","titled":"false","type":"Box","w":200,"x":102,"y":143,"zindex":"0"});
this.urlOfQr=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_urlOfQr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"''","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"urlOfQr","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"blank","text":"<%=JSPLib.ToJSValue(sp.translate(urlOfQr),false,true)%>","type":"Label","w":400,"x":0,"y":363,"zindex":"1"});
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
<%request.setAttribute("spas_pqrdetail_app_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spas_pqrdetail_app_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof setParameters !='undefined')this.setParameters=setParameters;
if(typeof setItem_rifpdetail !='undefined')this.setItem_rifpdetail=setItem_rifpdetail;
if(typeof closeDetail_Click !='undefined')this.closeDetail_Click=closeDetail_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var ua = navigator.userAgent
  , device = "<%=JSPLib.GetUserAgent(request)%>"
  , logged = <%=sp.isLogged()%>
  , inIframe = self.location.href!=parent.location.href
  , skin = "<%=sp.getSkin()%>"
;
var item_rifpdetail;
var qrcode;
function this_Loaded(){
  this.lbl_istruction.Ctrltbl.style.verticalAlign = "middle";
  this.lbl_istruction.Ctrltbl.style.fontStyle = "italic";
  qrcode=new QRCode(this.qrSide.ctrlid+'_td', {
    width: 200,
    height: 200,
    colorDark : "black",
    colorLight : "white",
    correctLevel : QRCode.CorrectLevel.H
  });  
}
function setParameters(title,descr,logo,url){
  this.lbl_title.Value(title);
  this.logo.Value(logo);
  qrcode.makeCode(url);
  this.urlOfQr.Value(url);
  this.urlOfQr.Href(url);
}
function setItem_rifpdetail(rifPortlet){
 	item_rifpdetail=rifPortlet; 
}
function closeDetail_Click(){
  item_rifpdetail.hideQrDetail();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spas_pqrdetail_app_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.closeDetail.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','spas_pqrdetail_app',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spas_pqrdetail_app');
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
sp.endPage("spas_pqrdetail_app");
}%>
<%! public String getJSPUID() { return "1505204001"; } %>