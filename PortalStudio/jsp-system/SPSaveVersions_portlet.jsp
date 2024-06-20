<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var isAdmin=\u003c%=sp.isAdministrator()%\u003e;\nvar saved=false;\n\u003c% if (\"zoom\".equalsIgnoreCase(typeEditor)) {%\u003e\n  var dotIndexOf = this.fileName.Value().lastIndexOf('.');\n  var tblName = this.fileName.Value().substring(dotIndexOf+1);\n\tvar cfgName = this.fileName.Value().substring(0,dotIndexOf);\n\tvar url='..\u002fservlet\u002fSPVZMProxy?m_cAction=vzmVariant&table='+URLenc(tblName)+'&configname='+URLenc(cfgName);\n  var listVersion=eval(new JSURL(url,true).Response());\n  var obj=[];\n  for(var i=0;i\u003clistVersion.length;i++){\n    obj[i]=[];\n    obj[i][0]=Strtran(listVersion[i],'_',' ')||'default';\n  }\n\u003c% } else if (\"smartreport\".equalsIgnoreCase(typeEditor)) {%\u003e\n  this.versionLbl.Value(FormatMsg(\"RPT_ATTACH\"));\n\tthis.fileList.ColumnTitles(FormatMsg(\"RPT_LISTFILE\"));\n\tvar url = new JSURL('..\u002fservlet\u002fSPReportGet?action=svrpVariant&filename='+ this.fileName.Value() + \"&custom=\" + this.custom.Value(), true);\n\tvar listVersion = url.Response();\n  listVersion = listVersion.split(\",\");\n\tvar obj = [];\n\tfor (var i = 0; i \u003c listVersion.length; i++) {\n  \tobj[i] = [];\n  \tvar nameVersion = Strtran(listVersion[i], \".svrp\", \"\");\n    if (this.custom.Value())\n      nameVersion = Strtran(nameVersion, \"1\u002f\", \"\");\n  \tobj[i][0] = Strtran(nameVersion, this.fileName.Value() + '__', '');\n\t}\n\u003c% } else {%\u003e\nvar maskName=this.fileName.Value();\nvar idx=maskName.indexOf(\"__\");\nif (idx!=-1)\n  maskName=maskName.substring(0,idx);\nvar url='..\u002fservlet\u002fSPVDMProxy?m_cAction=vdmVariant&filter='+maskName;\nvar listVersion=eval(new JSURL(url,true).Response());\nvar obj=[];\nfor(var i=0;i\u003clistVersion.length;i++){\n  obj[i]=[];\n  var nameVersion=listVersion[i].substring(maskName.length,listVersion[i].length-4).toLowerCase();\n  obj[i][0]=Strtran(Strtran(nameVersion,'__',''),'_',' ')||'default';\n}\n\u003c% } %\u003e\nfunction this_Loaded(){\n\u002f\u002f\u003c% if (\"zoom\".equalsIgnoreCase(typeEditor)) {%\u003e\n  \u002f\u002fthis.name.Value(this.fileName.Value());\n\u002f\u002f\u003c% } else {%\u003e\n\t\u002f\u002fthis.name.Value(maskName);\n\u002f\u002f\u003c% } %\u003e\n\tthis.userZoomBtn.Hide()\n\tthis.groupZoomBtn.Hide()\n  if (!isAdmin || this.typeEditor.Value() == \"smartreport\"){\n \t\tthis.usableBy.Hide()\n    this.usableByLbl.Hide()\n \t}\n  var customToolbar=this.getTitlePortlet();\n  var title = \"\";\n  if (this.typeEditor.Value()=='zoom')\n    title = '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_ZOOM_TBSTRIP_ZOOM\"))%\u003e: '+this.fileName.Value();\n  else if (this.typeEditor.Value()=='smartreport')\n    title = '\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_RPT\"))%\u003e: ' + this.fileName.Value();\n  else\n    title = '\u003c%=JSPLib.ToJSValue(sp.translate(\"VDM_MASK\"))%\u003e: '+maskName;\n  customToolbar.SetTitle(title)  \n  if (customToolbar.AddButton(SPTheme.smartEditorSaveImage||'\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fsave.png\",pageContext.getServletContext())%\u003e', this.saveBtn_Click, this, '\u003c%=sp.translate(\"MSG_SAVE_CONFIG\")%\u003e', '\u003c%=sp.translate(\"MSG_SAVE_CONFIG\")%\u003e'))\n    this.saveBtn.Hide()\n if (customToolbar.AddButton(SPTheme.smartEditorDiscardImage || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fclose.png\",pageContext.getServletContext())%\u003e', this.closeBtn_Click, this, '\u003c%=sp.translate(\"MSG_CLOSE_ONEXIT\")%\u003e', '\u003c%=sp.translate(\"MSG_CLOSE_ONEXIT\")%\u003e'))\n    this.closeBtn.Hide()\n  customToolbar.RearrangeAll()\n}\n\n\nthis.StaticDataProvider2.FillData(obj)\nthis.StaticDataProvider2.Query()\n\nfunction usableBy_onChange(){\n  if (this.usableBy.Value()=='user'){\n  \tthis.userZoomBtn.Show()\n    this.groupZoomBtn.Hide()\n  }\n  else {\n   this.userZoomBtn.Hide()\n   if (this.usableBy.Value()=='group')\n    this.groupZoomBtn.Show()\n   else\n    this.groupZoomBtn.Hide()\n  }\n}\n\nfunction saveBtn_Click(){\n  var type = \"\";\n  \u003c% if (\"zoom\".equalsIgnoreCase(typeEditor)) {%\u003e\n  \ttype = 'portalzoom';\n  \u003c% } else if (\"smartreport\".equalsIgnoreCase(typeEditor)) {%\u003e\n    type = 'smartreport';\n  \u003c% } else {%\u003e\n    type = 'maskparameters';\n  \u003c% } %\u003e;\n  if (Empty(this.versionName.Value()) && this.usableBy.Value()==0)\n    alert(\"Default mask can't be overwritten!\");\n  else{\n    var fileName = \"\";\n    \u003c% if (\"zoom\".equalsIgnoreCase(typeEditor)) {%\u003e\n      fileName = cfgName;\n    \u003c% } else if (\"smartreport\".equalsIgnoreCase(typeEditor)) {%\u003e\n      fileName = this.fileName.Value();\n    \u003c% } else {%\u003e\n      fileName = maskName;\n    \u003c% } %\u003e;\n    fileName = fileName + '__' + Strtran(this.versionName.Value(),' ','_');\n    if (this.usableBy.Value()=='user')\n      fileName+='_'+this.userCode.Value();  \n    else if (this.usableBy.Value()=='group')\n     \tfileName+='_g'+this.groupCode.Value();\n    var url = new JSURL(\"..\u002fservlet\u002fJSPReader?type=\" + URLenc(type) + \"&name=\"+ URLenc(fileName) +\"&custom=\"+URLenc( this.custom.Value()) +'&check=true'+\u003c%= (\"zoom\".equalsIgnoreCase(typeEditor) ? \"'&tablename='+URLenc(tblName)\" : \"''\" )%\u003e,true);    \n    output=url.Response();\n    var _this = this;\n\t  function doSave(){\n\u003c% if (\"zoom\".equalsIgnoreCase(typeEditor)) {%\u003e\n      var l_opener = window.GetOpener();\n      l_opener[_this.portletID.Value()].confirmZoom(fileName);\n      saved=true;\n      window.close();\n\u003c% } else if (\"smartreport\".equalsIgnoreCase(typeEditor)) {%\u003e\n  \t\twindow.GetOpener().save2(fileName);\n      window.close();\n\u003c% } else {%\u003e\n      window.GetOpener().saveAs(fileName);\n      window.close();\n\u003c% } %\u003e\n    }\n    if(output!=\"found\"){\n      doSave();\n    } else {\n      WindowConfirm(\"File already existing overwrite?\", function(overwrite){\n        if(overwrite){\n          doSave();\n        }\n      });\n    }\n  }\n\t\n}\n      \nfunction closeBtn_Click(){\n  window.close();\n}\n\u003c% if (\"zoom\".equalsIgnoreCase(typeEditor)) {%\u003e\n  var _this=this;\n  LibJavascript.Events.addEvent(window,\"unload\",function(){\n    if (!saved){\n      window.GetOpener()[_this.portletID.Value()].discardZoom();  \n    }\n\n  });\n\u003c%}%\u003e\n      \n\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"490","hsl":"","htmlcode":"{{ fileList }}\n{{ StaticDataProvider2 }}\n{{ fileName }}\n{{ custom }}\n{{ usableBy }}\n{{ usableByLbl }}\n{{ userCode }}\n{{ userName }}\n{{ userZoomBtn }}\n{{ groupCode }}\n{{ groupName }}\n{{ groupZoomBtn }}\n{{ saveBtn }}\n{{ versionLbl }}\n{{ versionName }}\n{{ closeBtn }}\n{{ portletID }}\n{{ typeEditor }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"417","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"font_family\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"maxwidth\":\"\",\"ColSpan\":\"\",\"RowSpan\":\"\",\"picture\":\"\",\"layer\":\"\",\"newline\":\"\",\"enable_HTML\":\"\",\"orderby_field\":\"\",\"extensible\":\"\",\"url\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":\"\",\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title\":\"List version\",\"field\":\"fileName\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"StaticDataProvider2","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"402","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"fileList","nav_bar":"false","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"0","scroll_bars":"true","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"417","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"54","zindex":""},{"alias":"fileName","auto_exec":"true","dataproviders":"","fieldsType":"C","h":"20","man_query":"","name":"StaticDataProvider2","page":"1","sequence":"2","type":"StaticDataProvider","w":"120","x":"659","y":"30"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"fileName","page":"1","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"145","x":"426","y":"13"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"custom","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"logic","w":"145","x":"426","y":"40"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","name":"usableBy","page":"1","picture":"","sequence":"5","tabindex":"","textlist":"MSG_ALL,MSG_USERNAME_STANDARD,GROUP_OF_USERS","type":"Combobox","typevar":"character","valuelist":"0,user,group","visible":"true","w":"112","wireframe_props":"name,textlist","x":"94","y":"26","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"usableByLbl","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"USABLE_BY","w":"92","wireframe_props":"align,value,n_col","x":"0","y":"31","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"userCode","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"145","wireframe_props":"name","x":"426","y":"70","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"usableBy\u003c\u003e'user'","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"userName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"184","wireframe_props":"name","x":"211","y":"26","zerofilling":"false","zindex":"1"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"spadministration_zuser","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"14","hide":"false","image":"","img_type":"default","intovars":"userCode,userName","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"userCode","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"userZoomBtn","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"code,fullname","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"9","servlet":"","suggest":"false","table":"cpusers","type":"LinkZoom","w":"14","wireframe_props":"","x":"397","y":"26","zindex":"","zoomtitle":"CP_USERS"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"groupCode","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"145","wireframe_props":"name","x":"426","y":"100","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"usableBy\u003c\u003e'group'","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"groupName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"184","wireframe_props":"name","x":"211","y":"26","zerofilling":"false","zindex":"1"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"14","hide":"false","image":"","img_type":"default","intovars":"groupCode,groupName","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"groupCode","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"groupZoomBtn","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"12","servlet":"","suggest":"false","table":"cpgroups","type":"LinkZoom","w":"14","wireframe_props":"","x":"397","y":"26","zindex":"","zoomtitle":"CP_GROUPS"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"button","create_undercond":"","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"saveBtn","page":"1","sequence":"13","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_SAVE_CONFIG","w":"65","wireframe_props":"value","x":"135","y":"463","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"versionLbl","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"VERSION_NAME","w":"92","wireframe_props":"align,value,n_col","x":"0","y":"9","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"versionName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"301","wireframe_props":"name","x":"94","y":"4","zerofilling":"false","zindex":"1"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"button","create_undercond":"","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"closeBtn","page":"1","sequence":"16","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_CLOSE_ONEXIT","w":"65","wireframe_props":"value","x":"238","y":"463","zindex":"1"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"portletID","page":"1","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"145","x":"426","y":"130"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"typeEditor","page":"1","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"145","x":"426","y":"160"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:fileName,custom,portletID,typeEditor*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.SPSaveVersions_container {
}
.SPSaveVersions_portlet{
  position:relative;
  width:100%;
  min-width:417px;
  height:490px;
}
.SPSaveVersions_portlet[Data-page="1"]{
  height:490px;
  width:100%;
}
.SPSaveVersions_portlet > .fileList_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:54px;
  left:0px;
  right:0px;
  width:auto;
  height:402px;
}
.SPSaveVersions_portlet > .usableBy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:94px;
  width:112px;
  height:20px;
}
.SPSaveVersions_portlet > .usableByLbl_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:31px;
  left:0px;
  width:92px;
  height:auto;
  min-height:19px;
}
.SPSaveVersions_portlet > .usableByLbl_ctrl {
  height:auto;
  min-height:19px;
}
.SPSaveVersions_portlet > .usableByLbl_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.SPSaveVersions_portlet > .userCode_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:426px;
  width:145px;
  height:20px;
}
.SPSaveVersions_portlet > .userCode_ctrl {
  display:none;
}
.SPSaveVersions_portlet > .userCode_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSaveVersions_portlet > .userName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:211px;
  width:184px;
  height:20px;
}
.SPSaveVersions_portlet > .userName_ctrl {
  display:none;
}
.SPSaveVersions_portlet > .userName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSaveVersions_portlet > .userZoomBtn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:397px;
  width:14px;
  height:14px;
}
.SPSaveVersions_portlet > .groupCode_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:100px;
  left:426px;
  width:145px;
  height:20px;
}
.SPSaveVersions_portlet > .groupCode_ctrl {
  display:none;
}
.SPSaveVersions_portlet > .groupCode_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSaveVersions_portlet > .groupName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:211px;
  width:184px;
  height:20px;
}
.SPSaveVersions_portlet > .groupName_ctrl {
  display:none;
}
.SPSaveVersions_portlet > .groupName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSaveVersions_portlet > .groupZoomBtn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:397px;
  width:14px;
  height:14px;
}
.SPSaveVersions_portlet > .saveBtn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:463px;
  left:135px;
  width:65px;
  height:20px;
}
.SPSaveVersions_portlet > .saveBtn_ctrl {
  font-family:Verdana;
  border-width:0px;
}
.SPSaveVersions_portlet > .versionLbl_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:0px;
  width:92px;
  height:auto;
  min-height:19px;
}
.SPSaveVersions_portlet > .versionLbl_ctrl {
  height:auto;
  min-height:19px;
}
.SPSaveVersions_portlet > .versionLbl_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.SPSaveVersions_portlet > .versionName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:94px;
  width:301px;
  height:20px;
}
.SPSaveVersions_portlet > .versionName_ctrl {
}
.SPSaveVersions_portlet > .versionName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPSaveVersions_portlet > .closeBtn_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:463px;
  left:238px;
  width:65px;
  height:20px;
}
.SPSaveVersions_portlet > .closeBtn_ctrl {
  font-family:Verdana;
  border-width:0px;
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
 String def="[{\"h\":\"490\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"417\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"List version\"}],\"h\":\"402\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"0\",\"type\":\"Grid\",\"w\":\"417\",\"x\":\"0\",\"y\":\"54\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"659\",\"y\":\"30\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"426\",\"y\":\"13\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"426\",\"y\":\"40\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"usableBy\",\"page\":\"1\",\"textlist\":\"MSG_ALL,MSG_USERNAME_STANDARD,GROUP_OF_USERS\",\"type\":\"Combobox\",\"w\":\"112\",\"x\":\"94\",\"y\":\"26\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"usableByLbl\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"USABLE_BY\",\"w\":\"92\",\"x\":\"0\",\"y\":\"31\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"userCode\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"145\",\"x\":\"426\",\"y\":\"70\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"userName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"184\",\"x\":\"211\",\"y\":\"26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"name\":\"userZoomBtn\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"14\",\"x\":\"397\",\"y\":\"26\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupCode\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"145\",\"x\":\"426\",\"y\":\"100\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"184\",\"x\":\"211\",\"y\":\"26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"name\":\"groupZoomBtn\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"14\",\"x\":\"397\",\"y\":\"26\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"saveBtn\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_SAVE_CONFIG\",\"w\":\"65\",\"x\":\"135\",\"y\":\"463\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"versionLbl\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"VERSION_NAME\",\"w\":\"92\",\"x\":\"0\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"versionName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"301\",\"x\":\"94\",\"y\":\"4\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"closeBtn\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_CLOSE_ONEXIT\",\"w\":\"65\",\"x\":\"238\",\"y\":\"463\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"portletID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"426\",\"y\":\"130\"},{\"h\":\"20\",\"name\":\"typeEditor\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"426\",\"y\":\"160\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPSaveVersions","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPSaveVersions_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPSaveVersions','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPSaveVersions_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("SPSaveVersions_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
String fileName=JSPLib.translateXSS(sp.getParameter("fileName",""));
boolean custom=sp.getParameter("custom",false);
String usableBy= "";
String usableByLbl= "USABLE_BY";
double userCode= 0;
if(request.getAttribute("SPSaveVersions_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String userName= "";
if(request.getAttribute("SPSaveVersions_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
double groupCode= 0;
String groupName= "";
String versionLbl= "VERSION_NAME";
String versionName= "";
String portletID=JSPLib.translateXSS(sp.getParameter("portletID",""));
String typeEditor=JSPLib.translateXSS(sp.getParameter("typeEditor",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPSaveVersions_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='SPSaveVersions_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPSaveVersions_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPSaveVersions','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_fileList' formid='<%=idPortlet%>' ps-name='fileList'   class='grid' style=''>&nbsp;</div>
<select id='<%=idPortlet%>_usableBy' name='usableBy' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_usableByLbl'  formid='<%=idPortlet%>' ps-name='usableByLbl'    class='label usableByLbl_ctrl'><div id='<%=idPortlet%>_usableByLbltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("USABLE_BY"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_userCode_wrp'><input id='<%=idPortlet%>_userCode' name='userCode' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='userCode' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_userName_wrp'><input id='<%=idPortlet%>_userName' name='userName' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='userName' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_userZoomBtn'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_groupCode_wrp'><input id='<%=idPortlet%>_groupCode' name='groupCode' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='groupCode' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_groupName_wrp'><input id='<%=idPortlet%>_groupName' name='groupName' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='groupName' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_groupZoomBtn'" ) );%>
<input id='<%=idPortlet%>_saveBtn' type='button' class='button saveBtn_ctrl'/>
<span id='<%=idPortlet%>_versionLbl'  formid='<%=idPortlet%>' ps-name='versionLbl'    class='label versionLbl_ctrl'><div id='<%=idPortlet%>_versionLbltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("VERSION_NAME"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_versionName_wrp'><input id='<%=idPortlet%>_versionName' name='versionName' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='versionName' /></span>
<input id='<%=idPortlet%>_closeBtn' type='button' class='button closeBtn_ctrl'/>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPSaveVersions');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_ATTACH",true)+","+JSPLib.ToJSValue(sp.translate("RPT_ATTACH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_LISTFILE",true)+","+JSPLib.ToJSValue(sp.translate("RPT_LISTFILE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPSaveVersions',["417"],["490"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"417","h":"490","title":"","layer":"false","npage":"1"}]);
this.fileList=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_fileList","dataobj":"StaticDataProvider2","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":402,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"fileList","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"true","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":417,"x":0,"y":54,"zindex":""});
this.fileList.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":0,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":"","font_size":"","onclick":"","align":"","title":"<%=JSPLib.ToJSValue(sp.translate("List version"),false,true)%>","ColSpan":"","picture":"","layer":"","url":"","target":"","droppable":"","newline":"","droppable_name":"","field":"fileName","fg_color":"","width":"","RowSpan":"","font_family":"","extensible":""}]});
this.StaticDataProvider2=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProvider2","dataproviders":"","fieldsString":"fileName","fieldstypeString":"C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProvider2","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":659,"y":30});
this.fileName=new ZtVWeb._VC(this,'fileName',null,'character','<%=JSPLib.ToJSValue(fileName,false,true)%>',false,false);
this.custom=new ZtVWeb._VC(this,'custom',null,'logic',<%=custom%>,false,false);
this.usableBy=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_usableBy","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=usableBy%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"usableBy","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"<%=JSPLib.ToJSValue(sp.translate("MSG_ALL"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("MSG_USERNAME_STANDARD"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("GROUP_OF_USERS"),false,true)%>","type":"Combobox","typevar":"character","valuelist":"0,user,group","visible":true,"w":112,"x":94,"y":26,"zindex":"1"});
this.usableByLbl=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_usableByLbl","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"usableByLbl","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(usableByLbl),false,true)%>","type":"Label","w":92,"x":0,"y":31,"zindex":"1"});
this.userCode=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_userCode","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"userCode","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=userCode%>","w":145,"x":426,"y":70,"zerofilling":false,"zindex":"1","zoom":""});
this.userName=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_userName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"usableBy\u003c\u003e'user'","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"userName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(userName,false,true)%>","w":184,"x":211,"y":26,"zerofilling":false,"zindex":"1","zoom":""});
this.userZoomBtn=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"spadministration_zuser","ctrlid":"<%=idPortlet%>_userZoomBtn","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fSPSaveVersions_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":14,"hide":"false","image":"","intovars":"userCode,userName","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/SPSaveVersions_portlet.jspuserZoomBtn",request.getSession())%>","linkedField":"userCode","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"userZoomBtn","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,fullname","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,cpusers,spadministration_zuser",request.getSession())%>","suggest":false,"table":"cpusers","type":"LinkZoom","w":14,"x":397,"y":26,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_USERS"),false,true)%>"});
this.groupCode=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupCode","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupCode","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=groupCode%>","w":145,"x":426,"y":100,"zerofilling":false,"zindex":"1","zoom":""});
this.groupName=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"usableBy\u003c\u003e'group'","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupName,false,true)%>","w":184,"x":211,"y":26,"zerofilling":false,"zindex":"1","zoom":""});
this.groupZoomBtn=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_groupZoomBtn","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fSPSaveVersions_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":14,"hide":"false","image":"","intovars":"groupCode,groupName","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/SPSaveVersions_portlet.jspgroupZoomBtn",request.getSession())%>","linkedField":"groupCode","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"groupZoomBtn","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":false,"table":"cpgroups","type":"LinkZoom","w":14,"x":397,"y":26,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>"});
this.saveBtn=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"button saveBtn_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_saveBtn","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"saveBtn","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_SAVE_CONFIG"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":135,"y":463,"zindex":"1"});
this.versionLbl=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_versionLbl","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"versionLbl","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(versionLbl),false,true)%>","type":"Label","w":92,"x":0,"y":9,"zindex":"1"});
this.versionName=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_versionName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"versionName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(versionName,false,true)%>","w":301,"x":94,"y":4,"zerofilling":false,"zindex":"1","zoom":""});
this.closeBtn=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"button closeBtn_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_closeBtn","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"closeBtn","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_CLOSE_ONEXIT"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":238,"y":463,"zindex":"1"});
this.portletID=new ZtVWeb._VC(this,'portletID',null,'character','<%=JSPLib.ToJSValue(portletID,false,true)%>',false,false);
this.typeEditor=new ZtVWeb._VC(this,'typeEditor',null,'character','<%=JSPLib.ToJSValue(typeEditor,false,true)%>',false,false);
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
<%request.setAttribute("SPSaveVersions_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPSaveVersions_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof usableBy_onChange !='undefined')this.usableBy_onChange=usableBy_onChange;
if(typeof saveBtn_Click !='undefined')this.saveBtn_Click=saveBtn_Click;
if(typeof doSave !='undefined')this.doSave=doSave;
if(typeof closeBtn_Click !='undefined')this.closeBtn_Click=closeBtn_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.userCode);
ZtVWeb.HideCtrl(Ne(this.usableBy.Value(),'user'),this.userName);
ZtVWeb.HideCtrl(true,this.groupCode);
ZtVWeb.HideCtrl(Ne(this.usableBy.Value(),'group'),this.groupName);
}
this.StaticDataProvider2.addRowConsumer(this.fileList);
this.userZoomBtn.addObserverFixedVars();
this.groupZoomBtn.addObserverFixedVars();
var isAdmin=<%=sp.isAdministrator()%>;
var saved=false;
<% if ("zoom".equalsIgnoreCase(typeEditor)) {%>
  var dotIndexOf = this.fileName.Value().lastIndexOf('.');
  var tblName = this.fileName.Value().substring(dotIndexOf+1);
	var cfgName = this.fileName.Value().substring(0,dotIndexOf);
	var url='../servlet/SPVZMProxy?m_cAction=vzmVariant&table='+URLenc(tblName)+'&configname='+URLenc(cfgName);
  var listVersion=eval(new JSURL(url,true).Response());
  var obj=[];
  for(var i=0;i<listVersion.length;i++){
    obj[i]=[];
    obj[i][0]=Strtran(listVersion[i],'_',' ')||'default';
  }
<% } else if ("smartreport".equalsIgnoreCase(typeEditor)) {%>
  this.versionLbl.Value(FormatMsg("RPT_ATTACH"));
	this.fileList.ColumnTitles(FormatMsg("RPT_LISTFILE"));
	var url = new JSURL('../servlet/SPReportGet?action=svrpVariant&filename='+ this.fileName.Value() + "&custom=" + this.custom.Value(), true);
	var listVersion = url.Response();
  listVersion = listVersion.split(",");
	var obj = [];
	for (var i = 0; i < listVersion.length; i++) {
  	obj[i] = [];
  	var nameVersion = Strtran(listVersion[i], ".svrp", "");
    if (this.custom.Value())
      nameVersion = Strtran(nameVersion, "1/", "");
  	obj[i][0] = Strtran(nameVersion, this.fileName.Value() + '__', '');
	}
<% } else {%>
var maskName=this.fileName.Value();
var idx=maskName.indexOf("__");
if (idx!=-1)
  maskName=maskName.substring(0,idx);
var url='../servlet/SPVDMProxy?m_cAction=vdmVariant&filter='+maskName;
var listVersion=eval(new JSURL(url,true).Response());
var obj=[];
for(var i=0;i<listVersion.length;i++){
  obj[i]=[];
  var nameVersion=listVersion[i].substring(maskName.length,listVersion[i].length-4).toLowerCase();
  obj[i][0]=Strtran(Strtran(nameVersion,'__',''),'_',' ')||'default';
}
<% } %>
function this_Loaded(){
//<% if ("zoom".equalsIgnoreCase(typeEditor)) {%>
  //this.name.Value(this.fileName.Value());
//<% } else {%>
	//this.name.Value(maskName);
//<% } %>
	this.userZoomBtn.Hide()
	this.groupZoomBtn.Hide()
  if (!isAdmin || this.typeEditor.Value() == "smartreport"){
 		this.usableBy.Hide()
    this.usableByLbl.Hide()
 	}
  var customToolbar=this.getTitlePortlet();
  var title = "";
  if (this.typeEditor.Value()=='zoom')
    title = '<%=JSPLib.ToJSValue(sp.translate("MSG_ZOOM_TBSTRIP_ZOOM"))%>: '+this.fileName.Value();
  else if (this.typeEditor.Value()=='smartreport')
    title = '<%=JSPLib.ToJSValue(sp.translate("MSG_RPT"))%>: ' + this.fileName.Value();
  else
    title = '<%=JSPLib.ToJSValue(sp.translate("VDM_MASK"))%>: '+maskName;
  customToolbar.SetTitle(title)  
  if (customToolbar.AddButton(SPTheme.smartEditorSaveImage||'<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>', this.saveBtn_Click, this, '<%=sp.translate("MSG_SAVE_CONFIG")%>', '<%=sp.translate("MSG_SAVE_CONFIG")%>'))
    this.saveBtn.Hide()
 if (customToolbar.AddButton(SPTheme.smartEditorDiscardImage || '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>', this.closeBtn_Click, this, '<%=sp.translate("MSG_CLOSE_ONEXIT")%>', '<%=sp.translate("MSG_CLOSE_ONEXIT")%>'))
    this.closeBtn.Hide()
  customToolbar.RearrangeAll()
}
this.StaticDataProvider2.FillData(obj)
this.StaticDataProvider2.Query()
function usableBy_onChange(){
  if (this.usableBy.Value()=='user'){
  	this.userZoomBtn.Show()
    this.groupZoomBtn.Hide()
  }
  else {
   this.userZoomBtn.Hide()
   if (this.usableBy.Value()=='group')
    this.groupZoomBtn.Show()
   else
    this.groupZoomBtn.Hide()
  }
}
function saveBtn_Click(){
  var type = "";
  <% if ("zoom".equalsIgnoreCase(typeEditor)) {%>
  	type = 'portalzoom';
  <% } else if ("smartreport".equalsIgnoreCase(typeEditor)) {%>
    type = 'smartreport';
  <% } else {%>
    type = 'maskparameters';
  <% } %>;
  if (Empty(this.versionName.Value()) && this.usableBy.Value()==0)
    alert("Default mask can't be overwritten!");
  else{
    var fileName = "";
    <% if ("zoom".equalsIgnoreCase(typeEditor)) {%>
      fileName = cfgName;
    <% } else if ("smartreport".equalsIgnoreCase(typeEditor)) {%>
      fileName = this.fileName.Value();
    <% } else {%>
      fileName = maskName;
    <% } %>;
    fileName = fileName + '__' + Strtran(this.versionName.Value(),' ','_');
    if (this.usableBy.Value()=='user')
      fileName+='_'+this.userCode.Value();  
    else if (this.usableBy.Value()=='group')
     	fileName+='_g'+this.groupCode.Value();
    var url = new JSURL("../servlet/JSPReader?type=" + URLenc(type) + "&name="+ URLenc(fileName) +"&custom="+URLenc( this.custom.Value()) +'&check=true'+<%= ("zoom".equalsIgnoreCase(typeEditor) ? "'&tablename='+URLenc(tblName)" : "''" )%>,true);    
    output=url.Response();
    var _this = this;
	  function doSave(){
<% if ("zoom".equalsIgnoreCase(typeEditor)) {%>
      var l_opener = window.GetOpener();
      l_opener[_this.portletID.Value()].confirmZoom(fileName);
      saved=true;
      window.close();
<% } else if ("smartreport".equalsIgnoreCase(typeEditor)) {%>
  		window.GetOpener().save2(fileName);
      window.close();
<% } else {%>
      window.GetOpener().saveAs(fileName);
      window.close();
<% } %>
    }
    if(output!="found"){
      doSave();
    } else {
      WindowConfirm("File already existing overwrite?", function(overwrite){
        if(overwrite){
          doSave();
        }
      });
    }
  }
	
}
      
function closeBtn_Click(){
  window.close();
}
<% if ("zoom".equalsIgnoreCase(typeEditor)) {%>
  var _this=this;
  LibJavascript.Events.addEvent(window,"unload",function(){
    if (!saved){
      window.GetOpener()[_this.portletID.Value()].discardZoom();  
    }
  });
<%}%>
      

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPSaveVersions_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.usableBy.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPSaveVersions',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPSaveVersions');
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
sp.endPage("SPSaveVersions");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"userZoomBtn")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpusers";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"code", "fullname"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"groupZoomBtn")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpgroups";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"code", "name"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "313773826"; } %>