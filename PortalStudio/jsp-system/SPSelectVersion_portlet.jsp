<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function usableBy_onChange(){\n  if (this.usableBy.Value()=='user'){\n  \tthis.userZoomBtn.Show();\n    this.groupZoomBtn.Hide();\n  }\n  else {\n   this.userZoomBtn.Hide()\n   if (this.usableBy.Value()=='group'){\n    this.groupZoomBtn.Show();\n   }\n   else{\n    this.groupZoomBtn.Hide();\n   }\n  }\n}\nfunction this_Loaded(){\n  this.userZoomBtn.Hide();\n  this.groupZoomBtn.Hide();\n  this.usableBy.Value(0);\n  this.hideUserGroup.Value(false);\n  if (!\u003c%=sp.CanConfigureZoom()%\u003e){\n    this.usableBy.Set('user');\n  \tthis.userCode.Set(\u003c%=sp.getUserCode()%\u003e);\n\t\tthis.userCode.Hide();\n  \tthis.userZoomBtn.Hide();\n  \tthis.userFullName.Hide();\n  \tthis.userName.Hide();\n    this.usableBy.Hide();\n    this.usableByLbl.Hide();\n  \tthis.custom.Value(true);\n  \tthis.custom.Hide();\n  \tthis.hideUserGroup.Value(true);\n  }\n\telse if (!Empty(this.userCode.Value())){\n  \tthis.usableBy.Set('user');\n    this.userZoomBtn.DoLink();\n  }\n\telse if (!Empty(this.groupCode.Value())){\n    this.usableBy.Set('group');\n    this.groupZoomBtn.DoLink();\n  }\n}\n\nfunction getVersionName(){\n  var versionName=Strtran(Trim(this.versionName.Value()),' ','_');\n  if (versionName=='default'){\n    versionName='';  \n  }\n  return versionName+this.getUserGroup();\n}\n\nfunction getUserGroup(){\n  var u_g='';\n\tif (this.usableBy.Value()=='user')\n    u_g+='_'+this.userCode.Value();  \n  else if (this.usableBy.Value()=='group')\n    u_g+='_g'+this.groupCode.Value();\n  return u_g;\n}\n\nfunction getUserCode(){\n  if (this.usableBy.Value()=='user')\n    return this.userCode.Value();\n  return 0;\n}\n  \n\nfunction getCustom(){\n return this.custom.Value();\n}\n\nfunction userZoomBtn_LinkExecuted(){\n  this.dispatchEvent('HideUnderCondition');\n}\n\n\n      \n\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","codemanifest":"{\"codemanifest\":\"\"}","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet-white-noradius","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ usableBy }}{{ usableByLbl }}{{ userCode }}{{ userName }}{{ userFullName }}{{ userZoomBtn }}{{ groupCode }}{{ groupName }}{{ groupZoomBtn }}{{ versionLbl }}{{ versionName }}{{ custom }}{{ @usableBy }}{{ @usableByLbl }}{{ @userCode }}{{ @userName }}{{ @userFullName }}{{ @userZoomBtn }}{{ @groupCode }}{{ @groupName }}{{ @groupZoomBtn }}{{ @versionLbl }}{{ @versionName }}{{ @custom }}\u003c\u002fbody\u003e","grapesCss":"","h":"38","hsl":"","htmlcode":"{{ @usableBy }} \n{{ usableBy }}\n{{ usableByLbl }}\n{{ userCode }}\n{{ userName }}\n{{ userFullName }}\n{{ userZoomBtn }}\n{{ groupCode }}\n{{ groupName }}\n{{ groupZoomBtn }}\n{{ versionLbl }}\n{{ versionName }}\n{{ custom }}\n{{ hideUserGroup }}\n{{ @usableByLbl }} \n{{ @userCode }} \n{{ @userName }} \n{{ @userFullName }} \n{{ @userZoomBtn }} \n{{ @groupCode }} \n{{ @groupName }} \n{{ @groupZoomBtn }} \n{{ @versionLbl }} \n{{ @versionName }} \n{{ @custom }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"true","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"38\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"true","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"none","title_block":"","title_url":"","type":"Form","v_line":"926","version":"37","w":"100%","wizard":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"usableBy","page":"1","picture":"","rapp":"","sequence":"1","spuid":"","tabindex":"","textlist":"MSG_ALL,MSG_USERNAME_STANDARD,GROUP_OF_USERS","type":"Combobox","typevar":"character","valuelist":"0,user,group","visible":"true","w":"140","wireframe_props":"name,textlist","x":"614","y":"9","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"usableByLbl","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_AVAILABLE_FOR","w":"115","wireframe_props":"align,value,n_col","x":"497","y":"11","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"off","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"userCode","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"145","wireframe_props":"name","x":"-8","y":"75","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"off","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"usableBy\u003c\u003e'user' or userFullName\u003c\u003e'' or hideUserGroup","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"userName","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"760","y":"9","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"off","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"usableBy\u003c\u003e'user' or userFullName='' or hideUserGroup","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"userFullName","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"760","y":"9","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"spadministration_zuser","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"14","hide":"false","image":"","img_type":"default","intovars":"userCode,userName,userFullName","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"userCode","linkedUsing":"userName,userFullName","looselylinked":"false","n_criteria":"3","name":"userZoomBtn","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name,fullname","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"5","servlet":"","spuid":"","suggest":"true","table":"cpusers","type":"LinkZoom","w":"14","wireframe_props":"","x":"912","y":"9","zindex":"","zone":"","zoomtitle":"CP_USERS"},{"anchor":"","autocapitalize":"on","autocomplete":"off","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupCode","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"145","wireframe_props":"name","x":"-8","y":"105","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"off","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"usableBy\u003c\u003e'group' or hideUserGroup","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupName","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"760","y":"9","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"14","hide":"false","image":"","img_type":"default","intovars":"groupCode,groupName","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"groupCode","linkedUsing":"groupName","looselylinked":"false","n_criteria":"2","name":"groupZoomBtn","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"8","servlet":"","spuid":"","suggest":"true","table":"cpgroups","type":"LinkZoom","w":"14","wireframe_props":"","x":"912","y":"9","zindex":"","zone":"","zoomtitle":"CP_GROUPS"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"versionLbl","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_VERSION_NAME","w":"112","wireframe_props":"align,value,n_col","x":"0","y":"11","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"off","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"versionName","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"301","wireframe_props":"name","x":"114","y":"9","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","label_text":"Custom","layer":"false","layout_steps_values":"{}","name":"custom","page":"1","rapp":"","sequence":"11","spuid":"","style_type":"standard","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"79","wireframe_props":"label_text","x":"420","y":"9","zindex":"2","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"false","init_par":"","name":"hideUserGroup","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"164","y":"74"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:userCode,groupCode,versionName,custom*/%>
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
.SPSelectVersion_container {
}
.SPSelectVersion_portlet{
  position:relative;
  width:100%;
  min-width:926px;
  height:38px;
}
.SPSelectVersion_portlet[Data-page="1"]{
  height:38px;
  width:100%;
}
.SPSelectVersion_portlet > .usableBy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:614px;
  width:140px;
  height:20px;
}
.SPSelectVersion_portlet > .usableByLbl_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:497px;
  width:115px;
  height:auto;
  min-height:19px;
}
.SPSelectVersion_portlet > .usableByLbl_ctrl {
  height:auto;
  min-height:19px;
}
.SPSelectVersion_portlet > .usableByLbl_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-weight:bold;
  text-align:right;
  background-color:transparent;
}
.SPSelectVersion_portlet > .userCode_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:75px;
  left:-8px;
  width:145px;
  height:20px;
}
.SPSelectVersion_portlet > .userCode_ctrl {
  display:none;
}
.SPSelectVersion_portlet > .userCode_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSelectVersion_portlet > .userName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:760px;
  width:150px;
  height:20px;
}
.SPSelectVersion_portlet > .userName_ctrl {
  display:none;
}
.SPSelectVersion_portlet > .userName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPSelectVersion_portlet > .userFullName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:760px;
  width:150px;
  height:20px;
}
.SPSelectVersion_portlet > .userFullName_ctrl {
  display:none;
}
.SPSelectVersion_portlet > .userFullName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPSelectVersion_portlet > .userZoomBtn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:912px;
  width:14px;
  height:14px;
}
.SPSelectVersion_portlet > .groupCode_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:105px;
  left:-8px;
  width:145px;
  height:20px;
}
.SPSelectVersion_portlet > .groupCode_ctrl {
  display:none;
}
.SPSelectVersion_portlet > .groupCode_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSelectVersion_portlet > .groupName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:760px;
  width:150px;
  height:20px;
}
.SPSelectVersion_portlet > .groupName_ctrl {
  display:none;
}
.SPSelectVersion_portlet > .groupName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPSelectVersion_portlet > .groupZoomBtn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:912px;
  width:14px;
  height:14px;
}
.SPSelectVersion_portlet > .versionLbl_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:0px;
  width:112px;
  height:auto;
  min-height:19px;
}
.SPSelectVersion_portlet > .versionLbl_ctrl {
  height:auto;
  min-height:19px;
}
.SPSelectVersion_portlet > .versionLbl_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:right;
  background-color:transparent;
}
.SPSelectVersion_portlet > .versionName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:114px;
  width:301px;
  height:20px;
}
.SPSelectVersion_portlet > .versionName_ctrl {
}
.SPSelectVersion_portlet > .versionName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPSelectVersion_portlet > .custom_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:9px;
  left:420px;
  width:79px;
  height:20px;
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
 String def="[{\"h\":\"38\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"none\",\"type\":\"Form\",\"v_line\":\"926\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"usableBy\",\"page\":\"1\",\"textlist\":\"MSG_ALL,MSG_USERNAME_STANDARD,GROUP_OF_USERS\",\"type\":\"Combobox\",\"w\":\"140\",\"x\":\"614\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"usableByLbl\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_AVAILABLE_FOR\",\"w\":\"115\",\"x\":\"497\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"userCode\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"145\",\"x\":\"-8\",\"y\":\"75\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"userName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"760\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"userFullName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"760\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"name\":\"userZoomBtn\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"14\",\"x\":\"912\",\"y\":\"9\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupCode\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"145\",\"x\":\"-8\",\"y\":\"105\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"760\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"name\":\"groupZoomBtn\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"14\",\"x\":\"912\",\"y\":\"9\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"versionLbl\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_VERSION_NAME\",\"w\":\"112\",\"x\":\"0\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"versionName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"301\",\"x\":\"114\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Custom\",\"layout_steps_values\":{},\"name\":\"custom\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"79\",\"x\":\"420\",\"y\":\"9\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"hideUserGroup\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"164\",\"y\":\"74\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPSelectVersion","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){
if(sp.isOfflineInstallation(request)){%><%if(Library.Empty(sp.getParameter("m_cSPOfflineApp",""))) {out.println("Empty SPOfflineApp parameter");return; }%><%}%><!DOCTYPE html>
<html <%if(sp.isOfflineInstallation(request)){%> <%=com.zucchetti.spofflineapp.Library.getManifestAttribute( request )%>="<%=JSPLib.SPWebRootURL(request)%>/spofflineapp/manifests/<%=sp.getParameter("m_cSPOfflineApp",(sp.getGlobal("i_lOfflineApplicationMode" , false ) ?  sp.getGlobal("i_cEntryPoint","") : "spofflineapp" ))%>_app_manifest.jsp"<%}%>>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPSelectVersion_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, true,false); %><script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPSelectVersion','portletObj',<%if(sp.isOfflineInstallation(request)){%>new ZtVWeb.SPParameterSource().GetInclusionParameter('SPParentObjId', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>')<%}else{%>'<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>'<%}%>);
/*JS_MARKER_END*/
</script>
<%String usableBy= "";
String usableByLbl= "MSG_AVAILABLE_FOR";
double userCode=sp.getParameter("userCode",0);
if(request.getAttribute("SPSelectVersion_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String userName= "";
String userFullName= "";
if(request.getAttribute("SPSelectVersion_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
double groupCode=sp.getParameter("groupCode",0);
String groupName= "";
String versionLbl= "MSG_VERSION_NAME";
String versionName=JSPLib.translateXSS(sp.getParameter("versionName",""));
boolean custom=sp.getParameter("custom",false);
boolean hideUserGroup= false;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPSelectVersion_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPSelectVersion_portlet portlet-white-noradius' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPSelectVersion','<%=idPortlet%>',false,'');
</script><%}}%>
<select id='<%=idPortlet%>_usableBy' name='usableBy' class='combobox' style='font-family:verdana;'></select>
<span id='<%=idPortlet%>_usableByLbl'  formid='<%=idPortlet%>' ps-name='usableByLbl'    class='label usableByLbl_ctrl'><div id='<%=idPortlet%>_usableByLbltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_AVAILABLE_FOR"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_userCode_wrp'><input id='<%=idPortlet%>_userCode' name='userCode' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='userCode' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_userName_wrp'><input id='<%=idPortlet%>_userName' name='userName' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='userName' /></span>
<span class='textbox-container'id='<%=idPortlet%>_userFullName_wrp'><input id='<%=idPortlet%>_userFullName' name='userFullName' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='userFullName' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_userZoomBtn'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_groupCode_wrp'><input id='<%=idPortlet%>_groupCode' name='groupCode' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='groupCode' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_groupName_wrp'><input id='<%=idPortlet%>_groupName' name='groupName' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='groupName' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_groupZoomBtn'" ) );%>
<span id='<%=idPortlet%>_versionLbl'  formid='<%=idPortlet%>' ps-name='versionLbl'    class='label versionLbl_ctrl'><div id='<%=idPortlet%>_versionLbltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_VERSION_NAME"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_versionName_wrp'><input id='<%=idPortlet%>_versionName' name='versionName' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='versionName' /></span>
<div id='<%=idPortlet%>_custom_div' style=''><input id='<%=idPortlet%>_custom' name='custom' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_custom' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(sp.translate("Custom"))%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPSelectVersion');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
<%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource = new ZtVWeb.SPParameterSource();<%}%>
var m_cSPPageletId = <%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('PageletId', '<%=JSPLib.ToJSValue(PageletId,false,true)%>');<%}else{%>'<%=JSPLib.ToJSValue(PageletId,false,true)%>';<%}%>
var m_cSPPortletTitleId = <%if(sp.isOfflineInstallation(request)){%>this.m_oSPParameterSource.GetInclusionParameter('SPPortletTitleId', '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>');<%}else{%>'<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';<%}%>
ZtVWeb.newForm(this,'<%=idPortlet%>','SPSelectVersion',["926"],["38"],'portlet-white-noradius',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"926","h":"38","title":"","layer":""}]);
this.usableBy=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_usableBy","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=usableBy%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"usableBy","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"<%=JSPLib.ToJSValue(sp.translate("MSG_ALL"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("MSG_USERNAME_STANDARD"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("GROUP_OF_USERS"),false,true)%>","type":"Combobox","typevar":"character","valuelist":"0,user,group","visible":true,"w":140,"x":614,"y":9,"zindex":"1"});
this.usableByLbl=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_usableByLbl","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"usableByLbl","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(usableByLbl),false,true)%>","type":"Label","w":115,"x":497,"y":11,"zindex":"1"});
this.userCode=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_userCode","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"userCode","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%if(sp.isOfflineInstallation(request)){%><%out.write("\"+");%>this.m_oSPParameterSource.GetInclusionParameter('userCode',<%='"'%><%}%><%=userCode%><%if(sp.isOfflineInstallation(request)){%><%='"'%>)<%out.write("+\"");%><%}%>","w":145,"x":-8,"y":75,"zerofilling":false,"zindex":"1","zoom":""});
this.userName=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_userName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"usableBy\u003c\u003e'user' or userFullName\u003c\u003e'' or hideUserGroup","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"userName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(userName,false,true)%>","w":150,"x":760,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.userFullName=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_userFullName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"usableBy\u003c\u003e'user' or userFullName='' or hideUserGroup","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"userFullName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(userFullName,false,true)%>","w":150,"x":760,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.userZoomBtn=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"spadministration_zuser","ctrlid":"<%=idPortlet%>_userZoomBtn","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fSPSelectVersion_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":14,"hide":"false","image":"","intovars":"userCode,userName,userFullName","intovarsType":"N,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/SPSelectVersion_portlet.jspuserZoomBtn",request.getSession())%>","linkedField":"userCode","linkedUsing":"userName,userFullName","looselylinked":false,"n_criteria":"3","name":"userZoomBtn","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name,fullname","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpusers,spadministration_zuser",request.getSession())%>","suggest":true,"table":"cpusers","type":"LinkZoom","w":14,"x":912,"y":9,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_USERS"),false,true)%>"});
this.groupCode=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupCode","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupCode","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%if(sp.isOfflineInstallation(request)){%><%out.write("\"+");%>this.m_oSPParameterSource.GetInclusionParameter('groupCode',<%='"'%><%}%><%=groupCode%><%if(sp.isOfflineInstallation(request)){%><%='"'%>)<%out.write("+\"");%><%}%>","w":145,"x":-8,"y":105,"zerofilling":false,"zindex":"1","zoom":""});
this.groupName=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"usableBy\u003c\u003e'group' or hideUserGroup","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupName,false,true)%>","w":150,"x":760,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.groupZoomBtn=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_groupZoomBtn","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fSPSelectVersion_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":14,"hide":"false","image":"","intovars":"groupCode,groupName","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/SPSelectVersion_portlet.jspgroupZoomBtn",request.getSession())%>","linkedField":"groupCode","linkedUsing":"groupName","looselylinked":false,"n_criteria":"2","name":"groupZoomBtn","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":true,"table":"cpgroups","type":"LinkZoom","w":14,"x":912,"y":9,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>"});
this.versionLbl=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_versionLbl","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"versionLbl","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(versionLbl),false,true)%>","type":"Label","w":112,"x":0,"y":11,"zindex":"1"});
this.versionName=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_versionName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"versionName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%if(sp.isOfflineInstallation(request)){%><%out.write("\"+");%>this.m_oSPParameterSource.GetInclusionParameter('versionName',<%='"'%><%}%><%=JSPLib.ToJSValue(versionName,false,true)%><%if(sp.isOfflineInstallation(request)){%><%='"'%>)<%out.write("+\"");%><%}%>","w":301,"x":114,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.custom=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_custom","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"request","label_text":"Custom","layer":false,"layout_steps_values":{},"name":"custom","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"standard","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":79,"x":420,"y":9,"zindex":"2"});
this.custom.Value(<%=custom%>);
this.hideUserGroup=new ZtVWeb._VC(this,'hideUserGroup',null,'logic',<%=hideUserGroup%>,false,false);
  <%if(sp.isOfflineInstallation(request)){%>
if(m_cSPPageletId){
  <%}%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
  <%if(sp.isOfflineInstallation(request)){%>
}
  <%}%>

}
/*JS_MARKER_END*/
</script>
<%request.setAttribute("SPSelectVersion_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPSelectVersion_Static=function(){
if(typeof usableBy_onChange !='undefined')this.usableBy_onChange=usableBy_onChange;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof getVersionName !='undefined')this.getVersionName=getVersionName;
if(typeof getUserGroup !='undefined')this.getUserGroup=getUserGroup;
if(typeof getUserCode !='undefined')this.getUserCode=getUserCode;
if(typeof getCustom !='undefined')this.getCustom=getCustom;
if(typeof userZoomBtn_LinkExecuted !='undefined')this.userZoomBtn_LinkExecuted=userZoomBtn_LinkExecuted;
  <%if(sp.isOfflineInstallation(request)){%>
var m_cSPPageletId = this.m_oSPParameterSource.GetInclusionParameter('PageletId', '<%=JSPLib.ToJSValue(PageletId,false,true)%>');
if(m_cSPPageletId){
  <%}%>
this.this_Calc=function(){
  this.PageletCalc();
}
  <%if(sp.isOfflineInstallation(request)){%>
}
  <%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.userCode);
ZtVWeb.HideCtrl(Ne(this.usableBy.Value(),'user') || Ne(this.userFullName.Value(),'') || this.hideUserGroup.Value(),this.userName);
ZtVWeb.HideCtrl(Ne(this.usableBy.Value(),'user') || Eq(this.userFullName.Value(),'') || this.hideUserGroup.Value(),this.userFullName);
ZtVWeb.HideCtrl(true,this.groupCode);
ZtVWeb.HideCtrl(Ne(this.usableBy.Value(),'group') || this.hideUserGroup.Value(),this.groupName);
}
this.userZoomBtn.addObserverFixedVars();
this.userZoomBtn.addLinkedUsingVars();
this.groupZoomBtn.addObserverFixedVars();
this.groupZoomBtn.addLinkedUsingVars();
function usableBy_onChange(){
  if (this.usableBy.Value()=='user'){
  	this.userZoomBtn.Show();
    this.groupZoomBtn.Hide();
  }
  else {
   this.userZoomBtn.Hide()
   if (this.usableBy.Value()=='group'){
    this.groupZoomBtn.Show();
   }
   else{
    this.groupZoomBtn.Hide();
   }
  }
}
function this_Loaded(){
  this.userZoomBtn.Hide();
  this.groupZoomBtn.Hide();
  this.usableBy.Value(0);
  this.hideUserGroup.Value(false);
  if (!<%=sp.CanConfigureZoom()%>){
    this.usableBy.Set('user');
  	this.userCode.Set(<%=sp.getUserCode()%>);
		this.userCode.Hide();
  	this.userZoomBtn.Hide();
  	this.userFullName.Hide();
  	this.userName.Hide();
    this.usableBy.Hide();
    this.usableByLbl.Hide();
  	this.custom.Value(true);
  	this.custom.Hide();
  	this.hideUserGroup.Value(true);
  }
	else if (!Empty(this.userCode.Value())){
  	this.usableBy.Set('user');
    this.userZoomBtn.DoLink();
  }
	else if (!Empty(this.groupCode.Value())){
    this.usableBy.Set('group');
    this.groupZoomBtn.DoLink();
  }
}
function getVersionName(){
  var versionName=Strtran(Trim(this.versionName.Value()),' ','_');
  if (versionName=='default'){
    versionName='';  
  }
  return versionName+this.getUserGroup();
}
function getUserGroup(){
  var u_g='';
	if (this.usableBy.Value()=='user')
    u_g+='_'+this.userCode.Value();  
  else if (this.usableBy.Value()=='group')
    u_g+='_g'+this.groupCode.Value();
  return u_g;
}
function getUserCode(){
  if (this.usableBy.Value()=='user')
    return this.userCode.Value();
  return 0;
}
  
function getCustom(){
 return this.custom.Value();
}
function userZoomBtn_LinkExecuted(){
  this.dispatchEvent('HideUnderCondition');
}
      

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPSelectVersion_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.usableBy.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPSelectVersion',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPSelectVersion');
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
sp.endPage("SPSelectVersion");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"userZoomBtn")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpusers";
  result.n_KMode = 3;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"code", "name", "fullname"};
  result.m_rdTypes = new String[]{"N", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"groupZoomBtn")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpgroups";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"code", "name"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3878143797"; } %>