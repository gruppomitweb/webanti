<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"document.title=\"VZM Maker\"\n\nfunction this_Loaded(){\n \u002f\u002friempie la combo delle tabelle\n var aTables=(new Function('return '+this.Tables.Value()))();\n var cmb=this.Table.Ctrl;\n cmb.innerHTML='';\n for(var i=0,tbl; i\u003caTables.length; i++){\n  cmb.options[cmb.options.length]=new Option(aTables[i][1],aTables[i][1]);\n }\n\n this.ConfigName.Value('default');\n\n this.chk_saveGroup_onChange();\n this.chk_saveUser_onChange();\n var btnSave=document.getElementById(this.cfgBuilder.formid+'_btnSave');\n if (btnSave)\n   btnSave.className='portalstudio_button'\n var lblSaving=document.getElementById(this.cfgBuilder.formid+'_lblSaving');\n if (lblSaving)\n   \tlblSaving.className='portalstudio_label'\n}\n\nfunction chk_saveGroup_onChange(){\n if (this.chk_saveGroup.Value()) {\n  this.m_nGroup.Enabled();\n  this.chk_saveUser.Value(false);\n } else {\n  this.m_nGroup.Disabled();\n  this.m_nGroup.Value(\"\");\n }\n}\n\nfunction chk_saveUser_onChange(){\n if (this.chk_saveUser.Value()) {\n  this.m_nUser.Enabled();\n  this.chk_saveGroup.Value(false);\n } else {\n  this.m_nUser.Disabled();\n  this.m_nUser.Value(\"\");\n\n }\n}\n\nfunction GetDataSave(cfg){\n  var this_portlet = this;\n  cfg.Custom =    this_portlet.chkCustom.Value();\n  cfg.Group  =    (this_portlet.chk_saveGroup.Value()?this_portlet.m_nGroup.Value()||0:0);\n  cfg.User   =    (this_portlet.chk_saveUser.Value()?this_portlet.m_nUser.Value()||0:0);\n  return cfg;\n}\n\nfunction btnCancel_Click(){\n  if (window.closeFrame) closeFrame();\n  else window.close()\n}\n\nfunction this_SaveOk(){\n  window.setTimeout(function(){\n    if (window.closeFrame) closeFrame();\n    else window.close()\n  },1000);\n}","bg_image":" ","cache_time":" ","color":" ","css":"portalstudio\u002fportalstudioTheme.css","css_class":" ","description":" ","form_action":" ","form_target":" ","form_type":"true","h":"170","hsl":" ","language":"true","manifest":" ","my_library":"portalstudio\u002fstyleVariables.js","offline":" ","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"375","version":"37","w":"100%"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"request","name":"Tables","page":"1","sequence":"1","type":"Variable","typevar":"character","w":"146","x":"0","y":"-25"},{"align":"right","anchor":"top-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblTable","page":"1","picture":" ","sequence":"2","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Table:","w":"90","x":"11","y":"35","zindex":"1"},{"anchor":"top-right","calculate":" ","class_Css":"portalstudio_combobox","dataobj":" ","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":" ","h":"19","hide_undercond":" ","init":" ","init_par":" ","name":"Table","page":"1","picture":" ","sequence":"3","tabindex":" ","textlist":" ","type":"Combobox","typevar":" ","valuelist":" ","visible":"true","w":"263","x":"103","y":"33"},{"align":"right","anchor":"top-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblConfigName","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Config name:","w":"90","x":"11","y":"59","zindex":"1"},{"anchor":"top-right","calculate":" ","class_Css":"portalstudio_textbox","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"22","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"ConfigName","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"5","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"263","x":"103","y":"55","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"top-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblVqr","page":"1","picture":" ","sequence":"6","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Vqr name:","w":"90","x":"11","y":"82","zindex":"1"},{"anchor":"top-right","calculate":" ","class_Css":"portalstudio_textbox","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"22","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"Vqr","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"7","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"263","x":"103","y":"78","zerofilling":"false","zindex":"1"},{"anchor":"top-right","calculate":" ","checked_value":"true","edit_undercond":" ","h":"13","help_tips":"Save configuration in custom directory of current instance","hide_undercond":" ","init":" ","init_par":"false","name":"chkCustom","page":"1","sequence":"8","tabindex":" ","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","x":"104","y":"108"},{"align":"left","anchor":"top-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"16","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lbl_custom","page":"1","picture":" ","sequence":"9","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"custom","w":"43","x":"120","y":"107","zindex":"1"},{"anchor":"top-right","calculate":" ","checked_value":"true","edit_undercond":" ","h":"13","help_tips":"Save configuration only for the specified group","hide_undercond":" ","init":" ","init_par":"false","name":"chk_saveGroup","page":"1","sequence":"10","tabindex":" ","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","x":"185","y":"108"},{"align":"left","anchor":"top-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"18","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label3","page":"1","picture":" ","sequence":"11","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"group:","w":"41","x":"203","y":"107","zindex":"1"},{"anchor":"top-right","calculate":" ","class_Css":"portalstudio_textbox","dataobj":" ","edit_undercond":" ","field":" ","font":" ","font_color":" ","font_size":"7pt","h":"17","help_tips":"Group code","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"m_nGroup","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"12","tabindex":" ","type":"Textbox","typevar":"numeric","visible":"true","w":"23","x":"244","y":"107","zerofilling":"false","zindex":"1"},{"anchor":"top-right","calculate":" ","checked_value":"true","edit_undercond":" ","h":"13","help_tips":"Save configuration only for the specified user","hide_undercond":" ","init":" ","init_par":"false","name":"chk_saveUser","page":"1","sequence":"13","tabindex":" ","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","x":"289","y":"108"},{"align":"left","anchor":"top-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"18","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lbl_user","page":"1","picture":" ","sequence":"14","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"user:","w":"36","x":"306","y":"107","zindex":"1"},{"anchor":"top-right","calculate":" ","class_Css":"portalstudio_textbox","dataobj":" ","edit_undercond":" ","field":" ","font":" ","font_color":" ","font_size":"7pt","h":"17","help_tips":"User code","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"m_nUser","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"15","tabindex":" ","type":"Textbox","typevar":"numeric","visible":"true","w":"23","x":"343","y":"107","zerofilling":"false","zindex":"1"},{"anchor":"top-left-right","h":"26","name":"cfgBuilder","page":"1","sequence":"16","src":"..\u002fjsp-system\u002fSPPortalZoomConfigurationBuilder_portlet.jsp?UseImages=False","type":"Portlet","w":"300","x":"2","y":"136"},{"anchor":"top-right","bg_color":" ","border_color":" ","border_weight":" ","class_Css":"portalstudio_button","edit_undercond":" ","font":" ","font_color":" ","font_size":" ","h":"24","help_tips":" ","hide_undercond":" ","name":"btnCancel","page":"1","sequence":"17","tabindex":" ","type":"Button","type_submit":"false","value":"Close","w":"55","x":"309","y":"136"},{"align":"center","anchor":"top-left-right","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"portalstudio_title","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"28","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"txtTitle","page":"1","picture":" ","sequence":"18","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"VZM specifications","w":"375","x":"0","y":"0","zindex":"1"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":"request","name":"offlinemode","page":"1","sequence":"19","type":"Variable","typevar":"character","w":"126","x":"163","y":"-24"}]%>
<%/*Description: */%>
<%/*ParamsRequest:Tables,Vqr,offlinemode*/%>
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
window.SPMakeVzmFromVqr_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof chk_saveGroup_onChange !='undefined')this.chk_saveGroup_onChange=chk_saveGroup_onChange;
if(typeof chk_saveUser_onChange !='undefined')this.chk_saveUser_onChange=chk_saveUser_onChange;
if(typeof GetDataSave !='undefined')this.GetDataSave=GetDataSave;
if(typeof btnCancel_Click !='undefined')this.btnCancel_Click=btnCancel_Click;
if(typeof this_SaveOk !='undefined')this.this_SaveOk=this_SaveOk;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
document.title="VZM Maker"
function this_Loaded(){
 //riempie la combo delle tabelle
 var aTables=(new Function('return '+this.Tables.Value()))();
 var cmb=this.Table.Ctrl;
 cmb.innerHTML='';
 for(var i=0,tbl; i<aTables.length; i++){
  cmb.options[cmb.options.length]=new Option(aTables[i][1],aTables[i][1]);
 }
 this.ConfigName.Value('default');
 this.chk_saveGroup_onChange();
 this.chk_saveUser_onChange();
 var btnSave=document.getElementById(this.cfgBuilder.formid+'_btnSave');
 if (btnSave)
   btnSave.className='portalstudio_button'
 var lblSaving=document.getElementById(this.cfgBuilder.formid+'_lblSaving');
 if (lblSaving)
   	lblSaving.className='portalstudio_label'
}
function chk_saveGroup_onChange(){
 if (this.chk_saveGroup.Value()) {
  this.m_nGroup.Enabled();
  this.chk_saveUser.Value(false);
 } else {
  this.m_nGroup.Disabled();
  this.m_nGroup.Value("");
 }
}
function chk_saveUser_onChange(){
 if (this.chk_saveUser.Value()) {
  this.m_nUser.Enabled();
  this.chk_saveGroup.Value(false);
 } else {
  this.m_nUser.Disabled();
  this.m_nUser.Value("");
 }
}
function GetDataSave(cfg){
  var this_portlet = this;
  cfg.Custom =    this_portlet.chkCustom.Value();
  cfg.Group  =    (this_portlet.chk_saveGroup.Value()?this_portlet.m_nGroup.Value()||0:0);
  cfg.User   =    (this_portlet.chk_saveUser.Value()?this_portlet.m_nUser.Value()||0:0);
  return cfg;
}
function btnCancel_Click(){
  if (window.closeFrame) closeFrame();
  else window.close()
}
function this_SaveOk(){
  window.setTimeout(function(){
    if (window.closeFrame) closeFrame();
    else window.close()
  },1000);
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
.SPMakeVzmFromVqr_container {
}
.SPMakeVzmFromVqr_portlet{
  position:relative;
  width:100%;
  min-width:375px;
  height:170px;
}
.SPMakeVzmFromVqr_portlet[Data-page="1"]{
  height:170px;
  width:100%;
}
.SPMakeVzmFromVqr_portlet > .lblTable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:274px;
  width:90px;
  height:auto;
  min-height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblTable_ctrl {
  height:auto;
  min-height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblTable_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPMakeVzmFromVqr_portlet > .Table_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  right:9px;
  width:263px;
  height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblConfigName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:59px;
  right:274px;
  width:90px;
  height:auto;
  min-height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblConfigName_ctrl {
  height:auto;
  min-height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblConfigName_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPMakeVzmFromVqr_portlet > .ConfigName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:55px;
  right:9px;
  width:263px;
  height:22px;
}
.SPMakeVzmFromVqr_portlet > .ConfigName_ctrl {
}
.SPMakeVzmFromVqr_portlet > .ConfigName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPMakeVzmFromVqr_portlet > .lblVqr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:82px;
  right:274px;
  width:90px;
  height:auto;
  min-height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblVqr_ctrl {
  height:auto;
  min-height:19px;
}
.SPMakeVzmFromVqr_portlet > .lblVqr_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPMakeVzmFromVqr_portlet > .Vqr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:78px;
  right:9px;
  width:263px;
  height:22px;
}
.SPMakeVzmFromVqr_portlet > .Vqr_ctrl {
}
.SPMakeVzmFromVqr_portlet > .Vqr_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPMakeVzmFromVqr_portlet > .chkCustom_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  right:258px;
  width:13px;
  height:13px;
}
.SPMakeVzmFromVqr_portlet > .lbl_custom_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:107px;
  right:212px;
  width:43px;
  height:auto;
  min-height:16px;
}
.SPMakeVzmFromVqr_portlet > .lbl_custom_ctrl {
  height:auto;
  min-height:16px;
}
.SPMakeVzmFromVqr_portlet > .lbl_custom_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPMakeVzmFromVqr_portlet > .chk_saveGroup_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  right:177px;
  width:13px;
  height:13px;
}
.SPMakeVzmFromVqr_portlet > .label3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:107px;
  right:131px;
  width:41px;
  height:auto;
  min-height:18px;
}
.SPMakeVzmFromVqr_portlet > .label3_ctrl {
  height:auto;
  min-height:18px;
}
.SPMakeVzmFromVqr_portlet > .label3_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPMakeVzmFromVqr_portlet > .m_nGroup_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:107px;
  right:108px;
  width:23px;
  height:17px;
}
.SPMakeVzmFromVqr_portlet > .m_nGroup_ctrl {
}
.SPMakeVzmFromVqr_portlet > .m_nGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPMakeVzmFromVqr_portlet > .chk_saveUser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  right:73px;
  width:13px;
  height:13px;
}
.SPMakeVzmFromVqr_portlet > .lbl_user_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:107px;
  right:33px;
  width:36px;
  height:auto;
  min-height:18px;
}
.SPMakeVzmFromVqr_portlet > .lbl_user_ctrl {
  height:auto;
  min-height:18px;
}
.SPMakeVzmFromVqr_portlet > .lbl_user_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPMakeVzmFromVqr_portlet > .m_nUser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:107px;
  right:9px;
  width:23px;
  height:17px;
}
.SPMakeVzmFromVqr_portlet > .m_nUser_ctrl {
}
.SPMakeVzmFromVqr_portlet > .m_nUser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPMakeVzmFromVqr_portlet > .cfgBuilder_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:136px;
  left:2px;
  right:73px;
  width:auto;
  height:auto;
  min-height:26px;
}
.SPMakeVzmFromVqr_portlet > .btnCancel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:136px;
  right:11px;
  width:55px;
  height:24px;
}
.SPMakeVzmFromVqr_portlet > .btnCancel_ctrl {
}
.SPMakeVzmFromVqr_portlet > .txtTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:28px;
}
.SPMakeVzmFromVqr_portlet > .txtTitle_ctrl {
  height:auto;
  min-height:28px;
}
.SPMakeVzmFromVqr_portlet > .txtTitle_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"170\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"375\",\"w\":\"100%\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"-25\"},{\"anchor\":\"top-right\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"90\",\"x\":\"11\",\"y\":\"35\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"263\",\"x\":\"103\",\"y\":\"33\"},{\"anchor\":\"top-right\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"90\",\"x\":\"11\",\"y\":\"59\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"22\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"263\",\"x\":\"103\",\"y\":\"55\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"90\",\"x\":\"11\",\"y\":\"82\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"22\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"263\",\"x\":\"103\",\"y\":\"78\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"104\",\"y\":\"108\"},{\"anchor\":\"top-right\",\"h\":\"16\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"43\",\"x\":\"120\",\"y\":\"107\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"185\",\"y\":\"108\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"41\",\"x\":\"203\",\"y\":\"107\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"17\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"23\",\"x\":\"244\",\"y\":\"107\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"289\",\"y\":\"108\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"36\",\"x\":\"306\",\"y\":\"107\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"17\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"23\",\"x\":\"343\",\"y\":\"107\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"26\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"300\",\"x\":\"2\",\"y\":\"136\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"55\",\"x\":\"309\",\"y\":\"136\"},{\"anchor\":\"top-left-right\",\"h\":\"28\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"375\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"163\",\"y\":\"-24\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPMakeVzmFromVqr","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPMakeVzmFromVqr_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("portalstudio/portalstudioTheme.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("portalstudio/portalstudioTheme.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPMakeVzmFromVqr','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Tables=JSPLib.translateXSS(sp.getParameter("Tables",""));
String lblTable= "Table:";
String Table= "";
String lblConfigName= "Config name:";
String ConfigName= "";
if(request.getAttribute("SPMakeVzmFromVqr_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblVqr= "Vqr name:";
String Vqr=JSPLib.translateXSS(sp.getParameter("Vqr",""));
boolean chkCustom=false;
String lbl_custom= "custom";
boolean chk_saveGroup=false;
String label3= "group:";
double m_nGroup= 0;
boolean chk_saveUser=false;
String lbl_user= "user:";
double m_nUser= 0;
String txtTitle= "VZM specifications";
String offlinemode=JSPLib.translateXSS(sp.getParameter("offlinemode",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPMakeVzmFromVqr_container'>
<form id='<%=idPortlet%>_form' name='<%=idPortlet%>_form' METHOD='POST' style='MARGIN:0' onsubmit='if(window.<%=idPortlet%>.this_OnSubmit)return window.<%=idPortlet%>.this_OnSubmit();'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPMakeVzmFromVqr_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPMakeVzmFromVqr','<%=idPortlet%>',false,' ');
</script><%}}%>
<input id='<%=idPortlet%>_Tables' name='Tables' type='hidden'/>
<span id='<%=idPortlet%>_lblTable'  formid='<%=idPortlet%>' ps-name='lblTable'    class='portalstudio_label lblTable_ctrl'><div id='<%=idPortlet%>_lblTabletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Table:"))%></div></span>
<select id='<%=idPortlet%>_Table' name='Table' class='portalstudio_combobox' style='font-family:verdana;'></select>
<span id='<%=idPortlet%>_lblConfigName'  formid='<%=idPortlet%>' ps-name='lblConfigName'    class='portalstudio_label lblConfigName_ctrl'><div id='<%=idPortlet%>_lblConfigNametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Config name:"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ConfigName_wrp'><input id='<%=idPortlet%>_ConfigName' name='ConfigName' type='text' class='portalstudio_textbox' formid='<%=idPortlet%>' ps-name='ConfigName' /></span>
<span id='<%=idPortlet%>_lblVqr'  formid='<%=idPortlet%>' ps-name='lblVqr'    class='portalstudio_label lblVqr_ctrl'><div id='<%=idPortlet%>_lblVqrtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Vqr name:"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_Vqr_wrp'><input id='<%=idPortlet%>_Vqr' name='Vqr' type='text' class='portalstudio_textbox' formid='<%=idPortlet%>' ps-name='Vqr' /></span>
<input id='<%=idPortlet%>_chkCustom' name='chkCustom' class='checkbox' title=<%=JSPLib.ToHTMLValue(sp.translate("Save configuration in custom directory of current instance") )%> type='checkbox' style=''/>
<span id='<%=idPortlet%>_lbl_custom'  formid='<%=idPortlet%>' ps-name='lbl_custom'    class='portalstudio_label lbl_custom_ctrl'><div id='<%=idPortlet%>_lbl_customtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("custom"))%></div></span>
<input id='<%=idPortlet%>_chk_saveGroup' name='chk_saveGroup' class='checkbox' title=<%=JSPLib.ToHTMLValue(sp.translate("Save configuration only for the specified group") )%> type='checkbox' style=''/>
<span id='<%=idPortlet%>_label3'  formid='<%=idPortlet%>' ps-name='label3'    class='portalstudio_label label3_ctrl'><div id='<%=idPortlet%>_label3tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("group:"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_nGroup_wrp'><input id='<%=idPortlet%>_m_nGroup' name='m_nGroup' type='text' class='portalstudio_textbox' formid='<%=idPortlet%>' ps-name='m_nGroup' inputmode='numeric' /></span>
<input id='<%=idPortlet%>_chk_saveUser' name='chk_saveUser' class='checkbox' title=<%=JSPLib.ToHTMLValue(sp.translate("Save configuration only for the specified user") )%> type='checkbox' style=''/>
<span id='<%=idPortlet%>_lbl_user'  formid='<%=idPortlet%>' ps-name='lbl_user'    class='portalstudio_label lbl_user_ctrl'><div id='<%=idPortlet%>_lbl_usertbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("user:"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_nUser_wrp'><input id='<%=idPortlet%>_m_nUser' name='m_nUser' type='text' class='portalstudio_textbox' formid='<%=idPortlet%>' ps-name='m_nUser' inputmode='numeric' /></span>
<div id='<%=idPortlet%>_cfgBuilder'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp-system/SPPortalZoomConfigurationBuilder_portlet.jsp?UseImages=False&ForcedPortletUID="+idPortlet+"_1jk9h1z",false);%></div>
<input id='<%=idPortlet%>_btnCancel' type='button' class='portalstudio_button btnCancel_ctrl'/>
<span id='<%=idPortlet%>_txtTitle'  formid='<%=idPortlet%>' ps-name='txtTitle'    class='portalstudio_title txtTitle_ctrl'><div id='<%=idPortlet%>_txtTitletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("VZM specifications"))%></div></span>
<input id='<%=idPortlet%>_offlinemode' name='offlinemode' type='hidden'/>
</div>
</form>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPMakeVzmFromVqr');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPMakeVzmFromVqr',["375"],["170"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"375","h":"170","title":" ","layer":"false","npage":"1"}]);
this.Tables=new ZtVWeb._VC(this,'Tables','<%=idPortlet%>_Tables','character','<%=JSPLib.ToJSValue(Tables,false,true)%>',false,false);
this.lblTable=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTable","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTable","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(lblTable),false,true)%>","type":"Label","w":90,"x":11,"y":35,"zindex":"1"});
this.Table=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-right","calculate":" ","class_Css":"portalstudio_combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Table","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"","h":19,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=Table%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Table","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":" ","type":"Combobox","typevar":"character","valuelist":" ","visible":true,"w":263,"x":103,"y":33});
this.lblConfigName=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblConfigName","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblConfigName","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(lblConfigName),false,true)%>","type":"Label","w":90,"x":11,"y":59,"zindex":"1"});
this.ConfigName=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_ConfigName","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ConfigName","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ConfigName,false,true)%>","w":263,"x":103,"y":55,"zerofilling":false,"zindex":"1","zoom":""});
this.lblVqr=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblVqr","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblVqr","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(lblVqr),false,true)%>","type":"Label","w":90,"x":11,"y":82,"zindex":"1"});
this.Vqr=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_Vqr","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"Vqr","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Vqr,false,true)%>","w":263,"x":103,"y":78,"zerofilling":false,"zindex":"1","zoom":""});
this.chkCustom=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":" ","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkCustom","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Save configuration in custom directory of current instance"),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkCustom","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":104,"y":108});
this.chkCustom.Value(<%=chkCustom%>);
this.lbl_custom=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_custom","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":16,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_custom","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_custom),false,true)%>","type":"Label","w":43,"x":120,"y":107,"zindex":"1"});
this.chk_saveGroup=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":" ","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chk_saveGroup","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Save configuration only for the specified group"),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chk_saveGroup","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":185,"y":108});
this.chk_saveGroup.Value(<%=chk_saveGroup%>);
this.label3=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label3","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label3","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(label3),false,true)%>","type":"Label","w":41,"x":203,"y":107,"zindex":"1"});
this.m_nGroup=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_m_nGroup","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":17,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Group code"),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_nGroup","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=m_nGroup%>","w":23,"x":244,"y":107,"zerofilling":false,"zindex":"1","zoom":""});
this.chk_saveUser=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":" ","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chk_saveUser","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Save configuration only for the specified user"),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chk_saveUser","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":289,"y":108});
this.chk_saveUser.Value(<%=chk_saveUser%>);
this.lbl_user=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_user","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_user","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_user),false,true)%>","type":"Label","w":36,"x":306,"y":107,"zindex":"1"});
this.m_nUser=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_m_nUser","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":17,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("User code"),false,true)%>","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_nUser","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=m_nUser%>","w":23,"x":343,"y":107,"zerofilling":false,"zindex":"1","zoom":""});
if(this.cfgBuilder=ZtVWeb.getPortletInc('<%=idPortlet%>_cfgBuilder')){
this.cfgBuilder.setContainer(this,'cfgBuilder')
this.cfgBuilder_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_cfgBuilder","h":26,"hide":"false","layer":false,"layout_steps_values":{},"name":"cfgBuilder","page":1,"portlet_id":"<%=idPortlet%>_1jk9h1z","type":"Portlet","w":300,"x":2,"y":136});
} else {
document.getElementById('<%=idPortlet%>_cfgBuilder').style.display='none';
}
this.btnCancel=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":" ","border_weight":" ","class_Css":"portalstudio_button btnCancel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCancel","edit_undercond":" ","font":"","font_color":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(" "),false,true)%>","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"btnCancel","page":1,"tabindex":" ","text":"<%=JSPLib.ToJSValue(sp.translate("Close"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":309,"y":136});
this.txtTitle=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":" ","calculate":" ","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTitle","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":28,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"txtTitle","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(txtTitle),false,true)%>","type":"Label","w":375,"x":0,"y":0,"zindex":"1"});
this.offlinemode=new ZtVWeb._VC(this,'offlinemode','<%=idPortlet%>_offlinemode','character','<%=JSPLib.ToJSValue(offlinemode,false,true)%>',false,false);
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
<%if(request.getAttribute("SPMakeVzmFromVqr_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPMakeVzmFromVqr_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPMakeVzmFromVqr_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Table.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPMakeVzmFromVqr',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPMakeVzmFromVqr');
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
sp.endPage("SPMakeVzmFromVqr");
}%>
<%! public String getJSPUID() { return "95477258"; } %>