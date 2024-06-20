<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nvar skin = '\u003c%=sp.getSkin()%\u003e';\n\nthis.skinselector.Ctrl.style.zIndex = \"20\";\n\nthis.BtnsToolbar.Init(\"..\u002f\"+skin+\"\u002fimages\u002ftitle\u002f\");\n\n\n\u003c%\nif(sp.isLogged()){\n%\u003e\nthis.label19.Value('\u003c%=JSPLib.ToJSValue((\"\".equals(sp.getFullName())?sp.getUserName():sp.getFullName()))%\u003e')\n\u003c%\n}\nelse {\n%\u003e\nthis.BtnsToolbar.HideItem('logout');\nthis.label19.Hide()\nthis.label17.Value('.........');\n\u003c%\n}\n%\u003e\n\nthis.Box17.Ctrl.style.backgroundImage='url(..\u002f\u003c%=sp.getSkin()%\u003e\u002fimages\u002ftitle\u002fbg_menu.png)';\n\u003c%\nif (sp.getSkinList().indexOf(\",\")\u003e-1) { %\u003e\nthis.skinselector.FillDataStatic('\u003c%=sp.getSkinList()%\u003e','\u003c%=sp.getSkinList()%\u003e');\nthis.skinselector.Init('\u003c%=sp.getSkin()%\u003e');\nfunction skinselector_onChange(){\n  if(this.skinselector.Value()!='')\n    window.location='..\u002fjsp-system\u002fSPSkinSwitch.jsp?skinName='+this.skinselector.Value()+'&fromURL=\u003c%= JSPLib.ToJSValue ( request.getRequestURI()+(request.getQueryString()!=null?\"?\"+request.getQueryString():\"\") )%\u003e';\n}\n\u003c%} else {%\u003e\nthis.BtnsToolbar.HideItem('skin');\n\u003c%}%\u003e\n\nthis.BtnsToolbar.Draw()\nvar skinSelOpen = false;\nthis.skinselector.Hide()\n\nfunction BtnsToolbar_onSlideItemClick(elem){\n    switch(elem){\n      case \"skin\":\n        if(skinSelOpen){\n          this.skinselector.Hide();\n          skinSelOpen = false;\n        }else{\n          this.skinselector.Show();\n          skinSelOpen = true;\n        }\n      break;\n    }\n}\n\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#CCC","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"PortletHeader","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"79","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"async":"true","auto_exec":"true","h":"30","n_records":"","name":"xmlobj0","page":"1","parms":"","parms_source":"","root":"\u002fSPVMNMenu","sequence":"1","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":"317","x":"0","xmldataobj":"","y":"-40"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"79","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image2","page":"1","path_type":"skin","sequence":"2","server_side":"","src":"..\u002fimages\u002ftitle\u002fopen_title.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"168","wireframe_props":"","x":"0","y":"0","zindex":"6"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"24","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image21","page":"1","path_type":"skin","sequence":"3","server_side":"","src":"..\u002fimages\u002ftitle\u002fwelc_title.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"440","wireframe_props":"","x":"0","y":"0","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"79","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image70","page":"1","path_type":"skin","sequence":"4","server_side":"","src":"..\u002fimages\u002ftitle\u002fclose_title.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"296","wireframe_props":"","x":"727","y":"0","zindex":"0"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"79","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image70_Copy","page":"1","path_type":"skin","sequence":"5","server_side":"","src":"..\u002fimages\u002ftitle\u002fzucchetti.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"296","wireframe_props":"","x":"727","y":"0","zindex":"0"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Tahoma","font_color":"#FFFFFF","font_size":"10px","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label19","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"...","w":"169","wireframe_props":"align,value,n_col","x":"237","y":"4","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Tahoma","font_color":"#3D4E61","font_size":"10px","font_weight":"normal","fontpct":"","h":"14","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label17","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_WELCOME","w":"86","wireframe_props":"align,value,n_col","x":"136","y":"4","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"31","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image28","page":"1","path_type":"skin","sequence":"8","server_side":"","src":"..\u002fimages\u002ftitle\u002fspinfinity.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"150","wireframe_props":"","x":"4","y":"21","zindex":"6"},{"anchor":"top-left-right","bg_color":"transparent","border_color":"#00FF33","border_weight":"0","class_Css":"","create_undercond":"","h":"28","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"Box17","page":"1","sequence":"9","shrinkable":"","stretch":"false","target":"","type":"Box","w":"1024","wireframe_props":"","x":"0","y":"51","zindex":"0"},{"anchor":"top-right","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","disabled":"false","edit_undercond":"","empty_value":"true","font":"","font_size":"7pt","h":"17","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","name":"skinselector","page":"1","picture":"","sequence":"10","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"126","wireframe_props":"name,textlist","x":"688","y":"56","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"'no'","name":"add_login","page":"1","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"143","x":"0","y":"95"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"'1'","name":"depth","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"143","x":"0","y":"120"},{"Root_node_value":"-1","anchor":"top-left-right","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","className":"","close_level":"","dataobj":"xmlobj0","direction":"horizontal","emitter_name":"","field_ChildCount":"elements","field_Css_Class":"","field_Expr":"","field_ExprNot":"","field_Frame":"target","field_Icons":"","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeLinkOver":"","field_NodeParent":"","field_NodeSeq":"","field_NodeTooltip":"","field_inExt":"","field_level":"","field_view_type":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":"26","hide":"","layout_steps_values":"{}","link_secondary":"","max_level":"-1","menu_type":"horizontal","name":"MenuView","page":"1","separator":"","separator_vert":"","sequence":"13","server_side":"","skin_path":"","tag_node":"MenuItem","target_default":"main","type":"MenuView","w":"655","wireframe_props":"","x":"167","y":"51","zindex":"3"},{"anchor":"top-right","bg_color":"","captions":"Skins,MSG_MAP,MSG_MENU_LOGOUT","css_class":"SlideToolbarHeader","font_name":"","font_path":"","h":"25","hide":"false","image_anchor":"","image_anchor_font":"","image_anchor_font_selected":"","image_anchor_selected":"","images":"skin.png,map.png,logout.png","images_font":"","images_path":"","img_height":"0","img_type":"default","img_width":"0","layout_steps_values":"{}","links":"javascript:void(0),sitemap_portlet.jsp,..\u002fservlet\u002fcp_logout","name":"BtnsToolbar","orientation":"horizontal","page":"1","path_type":"","sequence":"","slide":"left","targets":",main,","tooltips":"Skins,MSG_MAP,MSG_MENU_LOGOUT","translate":"true","type":"SlideToolbar","values":"skin,map,logout","w":"68","wireframe_props":"","x":"906","y":"53","zindex":""}]%>
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
.start_page_menu_orizz_container {
}
.start_page_menu_orizz_portlet{
  position:relative;
  width:100%;
  min-width:1024px;
  height:79px;
  background-color:#CCC;
}
.start_page_menu_orizz_portlet[Data-page="1"]{
  height:79px;
  width:100%;
}
.start_page_menu_orizz_portlet > .image2_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:168px;
  height:79px;
}
.start_page_menu_orizz_portlet > .image2_ctrl {
}
.start_page_menu_orizz_portlet > .image2_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_menu_orizz_portlet > .image21_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:440px;
  height:24px;
}
.start_page_menu_orizz_portlet > .image21_ctrl {
}
.start_page_menu_orizz_portlet > .image21_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_menu_orizz_portlet > .image70_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  right:1px;
  width:296px;
  height:79px;
}
.start_page_menu_orizz_portlet > .image70_ctrl {
}
.start_page_menu_orizz_portlet > .image70_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_menu_orizz_portlet > .image70_Copy_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  right:1px;
  width:296px;
  height:79px;
}
.start_page_menu_orizz_portlet > .image70_Copy_ctrl {
}
.start_page_menu_orizz_portlet > .image70_Copy_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_menu_orizz_portlet > .label19_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:237px;
  width:169px;
  height:auto;
  min-height:20px;
}
.start_page_menu_orizz_portlet > .label19_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_menu_orizz_portlet > .label19_ctrl {
  overflow:hidden;
  font-family:Tahoma;
  font-size:10px;
  font-weight:normal;
  color:#FFFFFF;
  text-align:left;
  background-color:transparent;
}
.start_page_menu_orizz_portlet > .label17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:136px;
  width:86px;
  height:auto;
  min-height:14px;
}
.start_page_menu_orizz_portlet > .label17_ctrl {
  height:auto;
  min-height:14px;
}
.start_page_menu_orizz_portlet > .label17_ctrl {
  overflow:hidden;
  font-family:Tahoma;
  font-size:10px;
  font-weight:normal;
  color:#3D4E61;
  text-align:right;
  background-color:transparent;
}
.start_page_menu_orizz_portlet > .image28_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:4px;
  width:150px;
  height:31px;
}
.start_page_menu_orizz_portlet > .image28_ctrl {
}
.start_page_menu_orizz_portlet > .image28_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_menu_orizz_portlet > .Box17_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:51px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:28px;
  display:flex;
  flex-direction:column;
}
.start_page_menu_orizz_portlet > .Box17_ctrl {
  height:28px;
}
.start_page_menu_orizz_portlet > .Box17_ctrl > .box_content {
  height:100%;
}
.start_page_menu_orizz_portlet > .Box17_ctrl {
  min-height:28px;
  background-color:transparent;
  border-width:0px;
  border-style:solid;
  border-color:#00FF33;
}
.start_page_menu_orizz_portlet > .skinselector_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:56px;
  right:210px;
  width:126px;
  height:17px;
}
.start_page_menu_orizz_portlet > .MenuView_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:51px;
  left:167px;
  right:202px;
  width:auto;
  height:26px;
}
.start_page_menu_orizz_portlet .MenuView_ctrl,
.start_page_menu_orizz_portlet .MenuView_ctrl a{
}
.start_page_menu_orizz_portlet > .BtnsToolbar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  right:50px;
  width:68px;
  height:25px;
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
 String def="[{\"h\":\"79\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"XMLDataobj\",\"w\":\"317\",\"x\":\"0\",\"y\":\"-40\"},{\"anchor\":\"\",\"h\":\"79\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"168\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"440\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"79\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"296\",\"x\":\"727\",\"y\":\"0\",\"zindex\":\"0\"},{\"anchor\":\"top-right\",\"h\":\"79\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"296\",\"x\":\"727\",\"y\":\"0\",\"zindex\":\"0\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"...\",\"w\":\"169\",\"x\":\"237\",\"y\":\"4\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_WELCOME\",\"w\":\"86\",\"x\":\"136\",\"y\":\"4\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"31\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"150\",\"x\":\"4\",\"y\":\"21\",\"zindex\":\"6\"},{\"anchor\":\"top-left-right\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"51\",\"zindex\":\"0\"},{\"anchor\":\"top-right\",\"h\":\"17\",\"layout_steps_values\":{},\"name\":\"skinselector\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"126\",\"x\":\"688\",\"y\":\"56\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"add_login\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"143\",\"x\":\"0\",\"y\":\"95\"},{\"h\":\"22\",\"name\":\"depth\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"143\",\"x\":\"0\",\"y\":\"120\"},{\"anchor\":\"top-left-right\",\"h\":\"26\",\"layout_steps_values\":{},\"name\":\"MenuView\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"655\",\"x\":\"167\",\"y\":\"51\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"BtnsToolbar\",\"page\":\"1\",\"type\":\"SlideToolbar\",\"w\":\"68\",\"x\":\"906\",\"y\":\"53\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_menu_orizz","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_menu_orizz_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_menu_orizz','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("start_page_menu_orizz_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
String label19= "...";
String label17= "MSG_WELCOME";
String skinselector= "";
String add_login="no";
String depth="1";
if(request.getAttribute("start_page_menu_orizz_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewObj.js")%>'></script>
<%}
if(request.getAttribute("start_page_menu_orizz_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("SlideToolbarObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_menu_orizz_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_menu_orizz_portlet PortletHeader' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_menu_orizz','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_image2'>
<img id='<%=idPortlet%>_image2_img' class='image image2_ctrl' src="../<%=sp.getSkin()%>/images/title/open_title.png" >
</div>
<div id='<%=idPortlet%>_image21'>
<img id='<%=idPortlet%>_image21_img' class='image image21_ctrl' src="../<%=sp.getSkin()%>/images/title/welc_title.png" >
</div>
<div id='<%=idPortlet%>_image70'>
<img id='<%=idPortlet%>_image70_img' class='image image70_ctrl' src="../<%=sp.getSkin()%>/images/title/close_title.png" >
</div>
<div id='<%=idPortlet%>_image70_Copy'>
<img id='<%=idPortlet%>_image70_Copy_img' class='image image70_Copy_ctrl' src="../<%=sp.getSkin()%>/images/title/zucchetti.png" >
</div>
<span id='<%=idPortlet%>_label19'  formid='<%=idPortlet%>' ps-name='label19'    class='label label19_ctrl'><div id='<%=idPortlet%>_label19tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("..."))%></div></span>
<span id='<%=idPortlet%>_label17'  formid='<%=idPortlet%>' ps-name='label17'    class='label label17_ctrl'><div id='<%=idPortlet%>_label17tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_WELCOME"))%></div></span>
<div id='<%=idPortlet%>_image28'>
<img id='<%=idPortlet%>_image28_img' class='image image28_ctrl' src="../<%=sp.getSkin()%>/images/title/spinfinity.png" >
</div>
<div id='<%=idPortlet%>_Box17' class='Box17_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box17_td' class='box_content'></div>
</div>
<select id='<%=idPortlet%>_skinselector' name='skinselector' class='combobox' style='font-size:7pt;'></select>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewHorObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuView' class='menuview_horizontal'></div>
<div class='SlideToolbarHeader' id='<%=idPortlet%>_BtnsToolbar' style='position:absolute;z-index:;top:53px;left:906px;height:25px;background:transparent;overflow:hidden;'>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_menu_orizz');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_menu_orizz',["1024"],["79"],'PortletHeader',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"79","title":"","layer":"false","npage":"1"}]);
this.xmlobj0=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobj0","field":"","h":30,"hide":"false","layer":false,"layout_steps_values":{},"n_records":"","name":"xmlobj0","page":1,"parms":"","parms_source":"","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":317,"x":0,"xmldataobj":"","y":-40});
this.image2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image2","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":79,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image2","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002ftitle\u002fopen_title.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":168,"x":0,"y":0,"zindex":"6"});
this.image21=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image21_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image21","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image21","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002ftitle\u002fwelc_title.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":440,"x":0,"y":0,"zindex":"1"});
this.image70=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image70_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image70","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":79,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image70","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002ftitle\u002fclose_title.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":296,"x":727,"y":0,"zindex":"0"});
this.image70_Copy=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image70_Copy_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image70_Copy","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":79,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image70_Copy","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002ftitle\u002fzucchetti.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":296,"x":727,"y":0,"zindex":"0"});
this.label19=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label19","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Tahoma","font_color":"#FFFFFF","font_size":"10px","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label19","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(label19),false,true)%>","type":"Label","w":169,"x":237,"y":4,"zindex":"1"});
this.label17=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label17","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Tahoma","font_color":"#3D4E61","font_size":"10px","font_weight":"normal","fontpct":"","h":14,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label17","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(label17),false,true)%>","type":"Label","w":86,"x":136,"y":4,"zindex":"1"});
this.image28=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image28_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image28","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":31,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image28","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002ftitle\u002fspinfinity.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":150,"x":4,"y":21,"zindex":"6"});
this.Box17=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"transparent","border_color":"#00FF33","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box17","groupName":"","h":28,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box17","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":1024,"x":0,"y":51,"zindex":"0"});
this.skinselector=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_skinselector","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"font":"","font_size":"7pt","h":17,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=skinselector%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"skinselector","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":126,"x":688,"y":56,"zindex":"1"});
this.add_login=new ZtVWeb._VC(this,'add_login',null,'character','<%=JSPLib.ToJSValue(add_login,false,true)%>',false,false);
this.depth=new ZtVWeb._VC(this,'depth',null,'character','<%=JSPLib.ToJSValue(depth,false,true)%>',false,false);
this.MenuView=new ZtVWeb.MenuViewHorCtrl(this,{"anchor":"top-left-right","arrow_image":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","btn_image":"","btn_imageWidth":"","btnover_image":"","class_Css":"","close_level":"","ctrlid":"<%=idPortlet%>_MenuView","direction":"horizontal","dx_btn_image":"","dx_btnover_image":"","emitter_name":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":26,"hide":"","layer":false,"layout_steps_values":{},"link_secondary":"","max_level":-1,"menu_type":"horizontal","name":"MenuView","page":1,"root_value":"-1","separator":"","separator_vert":"","sx_btn_image":"","sx_btnover_image":"","tag_node":"MenuItem","target_default":"main","type":"MenuView","w":655,"x":167,"y":51,"zindex":"3"});
this.MenuView.setRowsCols('uid','elements','caption','','','','','','target','link','','', '','');
this.BtnsToolbar=new ZtVWeb.SlideToolbarCtrl(this,{"anchor":"top-right","bgcolor":"","captions":"<%=sp.translate("Skins")%>,<%=sp.translate("MSG_MAP")%>,<%=sp.translate("MSG_MENU_LOGOUT")%>","css_class":"SlideToolbarHeader","ctrlid":"<%=idPortlet%>_BtnsToolbar","font_name":"","font_path":"","h":25,"hide":"false","image_anchor":"","image_anchor_font":"","image_anchor_font_selected":"","image_anchor_selected":"","images":"skin.png,map.png,logout.png","imagesPath":"","images_font":"","img_height":0,"img_type":"default","img_width":0,"layer":false,"layout_steps_values":{},"links":"javascript:void(0),sitemap_portlet.jsp,..\u002fservlet\u002fcp_logout","name":"BtnsToolbar","orientation":"horizontal","page":1,"path_type":"","slide":"left","targets":",main,","tooltips":"<%=sp.translate("Skins")%>,<%=sp.translate("MSG_MAP")%>,<%=sp.translate("MSG_MENU_LOGOUT")%>","translate":"true","type":"SlideToolbar","values":"skin,map,logout","w":68,"x":906,"y":53,"z_index":"","zindex":""});
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
<%request.setAttribute("start_page_menu_orizz_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.start_page_menu_orizz_Static=function(){
if(typeof skinselector_onChange !='undefined')this.skinselector_onChange=skinselector_onChange;
if(typeof BtnsToolbar_onSlideItemClick !='undefined')this.BtnsToolbar_onSlideItemClick=BtnsToolbar_onSlideItemClick;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.xmlobj0.addRowConsumer(this.MenuView);

var skin = '<%=sp.getSkin()%>';
this.skinselector.Ctrl.style.zIndex = "20";
this.BtnsToolbar.Init("../"+skin+"/images/title/");
<%
if(sp.isLogged()){
%>
this.label19.Value('<%=JSPLib.ToJSValue(("".equals(sp.getFullName())?sp.getUserName():sp.getFullName()))%>')
<%
}
else {
%>
this.BtnsToolbar.HideItem('logout');
this.label19.Hide()
this.label17.Value('.........');
<%
}
%>
this.Box17.Ctrl.style.backgroundImage='url(../<%=sp.getSkin()%>/images/title/bg_menu.png)';
<%
if (sp.getSkinList().indexOf(",")>-1) { %>
this.skinselector.FillDataStatic('<%=sp.getSkinList()%>','<%=sp.getSkinList()%>');
this.skinselector.Init('<%=sp.getSkin()%>');
function skinselector_onChange(){
  if(this.skinselector.Value()!='')
    window.location='../jsp-system/SPSkinSwitch.jsp?skinName='+this.skinselector.Value()+'&fromURL=<%= JSPLib.ToJSValue ( request.getRequestURI()+(request.getQueryString()!=null?"?"+request.getQueryString():"") )%>';
}
<%} else {%>
this.BtnsToolbar.HideItem('skin');
<%}%>
this.BtnsToolbar.Draw()
var skinSelOpen = false;
this.skinselector.Hide()
function BtnsToolbar_onSlideItemClick(elem){
    switch(elem){
      case "skin":
        if(skinSelOpen){
          this.skinselector.Hide();
          skinSelOpen = false;
        }else{
          this.skinselector.Show();
          skinSelOpen = true;
        }
      break;
    }
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_menu_orizz_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.xmlobj0.firstQuery('true');
window.<%=idPortlet%>.skinselector.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_menu_orizz',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_menu_orizz');
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
sp.endPage("start_page_menu_orizz");
}%>
<%! public String getJSPUID() { return "2893861260"; } %>