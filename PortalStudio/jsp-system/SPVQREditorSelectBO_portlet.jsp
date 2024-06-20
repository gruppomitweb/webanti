<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  var res = new JSURL(\"..\u002fservlet\u002fSPXDCProxy?action=procedures\"+(this.offlinemode.Value()?'&offlinemode=true':'')).Response();\n  if (res!=\"ACCESS DENIED\"){\n    res=eval(res);\n    this.dataProcedures.FillData(res);\n  } else {\n    this.selectEntity.Value(\"Please, login with administrator user.\");\n  }\n  \u003c%=idPortlet%\u003e_tabstrip.HideTabsContainer();\n  document.title=\"Select a procedure\";\n}\nvar currentlinks;\nfunction next(){\n  var res = new JSURL(\"..\u002fservlet\u002fSPXDCProxy?action=procedure_props&table=\"+URLenc(this.dataProcedures.rs.procedure)+(this.offlinemode.Value()?'&offlinemode=true':'')).Response();\n  if (res!=\"ACCESS DENIED\") {\n    res = eval(\"(\"+res+\")\");\n    if (res.entityType=='master\u002fdetail' && this.hideLinkedTables.Value().toLowerCase()!=\"true\") {\n      this.MDProperties.Show();\n      this.MDProperties.Value('');\n    } else\n      this.MDProperties.Hide();\n    currentlinks=res.links;\n    var hk = haveKeys(currentlinks); \n    if ((!hk && res.entityType!='master\u002fdetail') || this.hideLinkedTables.Value().toLowerCase()==\"true\") {\n      this.btnConfirm_Click();\n    } else {\n      \u003c%=idPortlet%\u003e_tabstrip.Next();\n      this.currentEntity.Value(\"Selected Entity: \"+this.dataProcedures.rs.comment)\n      if (hk) {\n        this.gridTables.Show();\n        this.FillLinksTable();\n        this.MDProperties.leftposition=293;\n        this.MDProperties.Ctrl.style.left=\"293px\";\n      } else {\n        this.gridTables.Hide();\n        this.MDProperties.leftposition=5;\n        this.MDProperties.Ctrl.style.left=\"5px\";\n      }\n    }\n  } else {\n    this.selectEntity.Value(\"Please, login with administrator user.\");\n  }\n}\nvar haveKeys=function(obj) {\n  var res=false;\n  if (obj)\n  for (var key in obj){\n    if (obj.hasOwnProperty(key)) res=true;\n  }\n  return res;\n}\n\nfunction MDProperties_onChange(){\n  if (haveKeys(currentlinks))\n    this.FillLinksTable();\n}\n\nfunction FillLinksTable() {\n  var _;\n  var mode = (!this.MDProperties.IsHidden()? this.MDProperties.Value()==\"HEAD\"?false:(this.MDProperties.Value()==\"ROWS\"?true:_):_);\n  var data=[];\n  for (var tbl in currentlinks) {\n    if (typeof mode =='undefined' || LibJavascript.Array.indexOf(currentlinks[tbl],mode,function(e1,e2){return \u002f^true$\u002fi.test(e1)==e2;})\u003e-1)\n      data.push([tbl])\n  }\n  if (this.gridTables.datasource) {\n    this.gridTables.CloseRow()\n    this.gridTables._initMemCurs()\n    this.gridTables._renderOutputDataObj();\n  }\n  this.dataTables.FillData(data);\n}\nfunction btnPrev_Click(){\n\u003c%=idPortlet%\u003e_tabstrip.Prev();\n}\n\nfunction btnConfirm_Click(){\n  var result = \"BO:\"+this.dataProcedures.rs.procedure;\n  if (!this.MDProperties.IsHidden() && this.MDProperties.Value()!=\"\" && this.hideLinkedTables.Value().toLowerCase()!=\"true\"){\n    result += \"[\"+this.MDProperties.Value()+\"]\";\n  }\n  if (haveKeys(currentlinks) && this.hideLinkedTables.Value().toLowerCase()!=\"true\") {\n    var tmp = this.gridTables.GetSelectedData()\n    for (var i=0; i\u003ctmp.Data.length-1; i++) {\n      result += \"-\u003e\"+tmp.Data[i][0];\n    }\n  }\n  var call = (window.opener?window.opener:(window.caller?window.caller:window.parent));\n  if (!Empty(this.callerFunction.Value()) && call[this.callerFunction.Value()]){\n    call[this.callerFunction.Value()](result,this.dataProcedures.rs.module);\n  }else{\n    if(!Empty(this.portletId.Value()) && GetOpener()[this.portletId.Value()].selectedBO){\n      GetOpener()[this.portletId.Value()].selectedBO.Set(Strtran(result,\"BO:\",\"\"));\n    }else{\n    \n      if(this.isForm.Value()){\n        GetOpener().formProp[this.propRef.Value()]=Strtran(result,\"BO:\",\"\");\n      }else{\n        GetOpener().itemsHTML[GetOpener().index][this.propRef.Value()]=Strtran(result,\"BO:\",\"\");\n      }\n      if(this.isForm.Value()){\n        GetOpener().FormProperties();  \n      }else{\n        GetOpener().Properties();  \n      }\n    }\n  }\n  \n  if (call.closeSPModalLayer && !window.opener){\n    if ( !call.closeSPModalLayer() && window.WindowClose ) {\n      window.WindowClose();\n    }\n  }\n  else \n    window.close();\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"portalstudio\u002fportalstudioTheme.css","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"420","hsl":"","htmlcode":"{{ dataProcedures }}\n{{ gridProcedures }}\n{{ btnPrev }}\n{{ MDProperties }}\n{{ gridTables }}{{ propRef }}\n{{ dataTables }}\n{{ currentEntity }}\n{{ selectEntity }}\n{{ btnConfirm }}{{ isForm }}\n{{ callerFunction }}\n{{ hideLinkedTables }}{{ portletId }}\n{{ offlinemode }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"portalstudio\u002fstyleVariables.js","offline":"","on_security_failure":"login","pages_names":"Entità,Campi e Link","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"alias":"procedure,comment,module","auto_exec":"true","dataproviders":"","fieldsType":"C,C,C","h":"20","man_query":"","name":"dataProcedures","page":"1","parms":"","parms_source":"","sequence":"1","type":"StaticDataProvider","w":"120","x":"429","y":"13"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Procedure\",\"align\":\"\",\"link\":\"function:next()\",\"width\":\"50%\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"procedure\",\"maxwidth\":\"\",\"title\":\"Procedure\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Description\",\"align\":\"\",\"link\":\"function:next()\",\"width\":\"50%\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"comment\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_card_container":"","css_class_grid":"portalstudio_grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataProcedures","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":",","filters":"true-by-example","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"385","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"false","name":"gridProcedures","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"middle","w":"390","wireframe_props":"colProperties,checkbox,rows","x":"5","y":"29","zindex":""},{"anchor":"bottom-left","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnPrev","page":"2","sequence":"3","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Back","w":"71","wireframe_props":"value","x":"5","y":"388","zindex":"1"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","font":"Tahoma","font_size":"9pt","h":"72","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"''","layer":"false","layout_steps_values":"{}","name":"MDProperties","orientation":"vertical","page":"2","picture":"","sequence":"4","spuid":"","tabindex":"","textlist":"All,Head,Rows","type":"Radio","typevar":"character","valuelist":",HEAD,ROWS","visible":"true","w":"102","wireframe_props":"","x":"293","y":"30","zindex":"1"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"tablename","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Linked Table Name\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"tablename\",\"maxwidth\":\"\",\"title\":\"Linked Table Name\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\"}]","css_class_card_container":"","css_class_grid":"portalstudio_grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataTables","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"250","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridTables","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"275","wireframe_props":"colProperties,checkbox,rows","x":"5","y":"29","zindex":""},{"alias":"tablename","auto_exec":"true","dataproviders":"","fieldsType":"C","h":"20","man_query":"","name":"dataTables","page":"2","parms":"","parms_source":"","sequence":"6","type":"StaticDataProvider","w":"120","x":"-2","y":"-35"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"26","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"currentEntity","nowrap":"false","page":"2","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Current Entity:","w":"390","wireframe_props":"align,value,n_col","x":"5","y":"3","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"26","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"selectEntity","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select a procedure","w":"390","wireframe_props":"align,value,n_col","x":"5","y":"3","zindex":"1"},{"anchor":"bottom-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnConfirm","page":"2","sequence":"9","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Select","w":"65","wireframe_props":"value","x":"330","y":"388","zindex":"1"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"callerFunction","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"133","x":"0","y":"-27"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"hideLinkedTables","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"133","x":"142","y":"-27"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"offlinemode","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"logic","w":"128","x":"284","y":"-27"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"propRef","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"430","y":"45"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"isForm","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"433","y":"77"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"portletId","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"431","y":"109"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:callerFunction,hideLinkedTables,offlinemode,propRef,isForm,portletId*/%>
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
.SPVQREditorSelectBO_container {
}
.SPVQREditorSelectBO_portlet{
  position:relative;
  min-width:400px;
  height:420px;
  background-color:#FFFFFF;
}
.SPVQREditorSelectBO_portlet[Data-page="1"]{
  height:420px;
  width:100%;
}
.SPVQREditorSelectBO_portlet[Data-page="2"]{
  height:420px;
  width:100%;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .gridProcedures_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:5px;
  right:5px;
  width:auto;
  height:auto;
  min-height:385px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .btnPrev_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  left:5px;
  bottom:12px;
  width:71px;
  height:20px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .btnPrev_ctrl {
  font-family:Verdana;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .MDProperties_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:30px;
  left:293px;
  width:102px;
  height:72px;
  height:auto;
  min-height:72px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .gridTables_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:5px;
  width:275px;
  height:auto;
  min-height:250px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .currentEntity_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:5px;
  right:5px;
  width:auto;
  height:auto;
  min-height:26px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .currentEntity_ctrl {
  height:auto;
  min-height:26px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .currentEntity_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .selectEntity_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:5px;
  right:5px;
  width:auto;
  height:auto;
  min-height:26px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .selectEntity_ctrl {
  height:auto;
  min-height:26px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .selectEntity_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .btnConfirm_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  right:5px;
  bottom:12px;
  width:65px;
  height:20px;
}
.SPVQREditorSelectBO_portlet > .SPVQREditorSelectBO_page > .btnConfirm_ctrl {
  font-family:Verdana;
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
 String def="[{\"h\":\"420\",\"layout_steps_values\":{},\"pages_names\":\"Entità,Campi e Link\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"429\",\"y\":\"13\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Procedure\"},{\"title\":\"Description\"}],\"h\":\"385\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"390\",\"x\":\"5\",\"y\":\"29\",\"zindex\":\"\"},{\"anchor\":\"bottom-left\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Button\",\"value\":\"Back\",\"w\":\"71\",\"x\":\"5\",\"y\":\"388\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"72\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Radio\",\"w\":\"102\",\"x\":\"293\",\"y\":\"30\",\"zindex\":\"1\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Linked Table Name\"}],\"h\":\"250\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"275\",\"x\":\"5\",\"y\":\"29\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"-2\",\"y\":\"-35\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"26\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Current Entity:\",\"w\":\"390\",\"x\":\"5\",\"y\":\"3\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"26\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Select a procedure\",\"w\":\"390\",\"x\":\"5\",\"y\":\"3\",\"zindex\":\"1\"},{\"anchor\":\"bottom-right\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Button\",\"value\":\"Select\",\"w\":\"65\",\"x\":\"330\",\"y\":\"388\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"133\",\"x\":\"0\",\"y\":\"-27\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"133\",\"x\":\"142\",\"y\":\"-27\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"128\",\"x\":\"284\",\"y\":\"-27\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"430\",\"y\":\"45\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"433\",\"y\":\"77\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"431\",\"y\":\"109\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVQREditorSelectBO","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPVQREditorSelectBO_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPVQREditorSelectBO','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPVQREditorSelectBO_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
if(request.getAttribute("SPVQREditorSelectBO_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String MDProperties="";
String currentEntity= "Current Entity:";
String selectEntity= "Select a procedure";
String callerFunction=JSPLib.translateXSS(sp.getParameter("callerFunction",""));
String hideLinkedTables=JSPLib.translateXSS(sp.getParameter("hideLinkedTables",""));
boolean offlinemode=sp.getParameter("offlinemode",false);
String propRef=JSPLib.translateXSS(sp.getParameter("propRef",""));
boolean isForm=sp.getParameter("isForm",false);
String portletId=JSPLib.translateXSS(sp.getParameter("portletId",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPVQREditorSelectBO_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPVQREditorSelectBO_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPVQREditorSelectBO','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPVQREditorSelectBO_page' style='display:block'>
<div id='<%=idPortlet%>_gridProcedures' formid='<%=idPortlet%>' ps-name='gridProcedures'   class='portalstudio_grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_selectEntity'  formid='<%=idPortlet%>' ps-name='selectEntity'    class='portalstudio_title selectEntity_ctrl'><div id='<%=idPortlet%>_selectEntitytbl' style='width:100%;'><%=JSPLib.ToHTML("Select a procedure")%></div></span>
</div>
<div id='<%=idPortlet%>_page_2' class='SPVQREditorSelectBO_page' style='display:none'>
<input id='<%=idPortlet%>_btnPrev' type='button' class='portalstudio_button black btnPrev_ctrl'/>
<div id='<%=idPortlet%>_MDProperties' class='radio' style='z-index:1;font-family:Tahoma;font-size:9pt;'></div>
<div id='<%=idPortlet%>_gridTables' formid='<%=idPortlet%>' ps-name='gridTables'   class='portalstudio_grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_currentEntity'  formid='<%=idPortlet%>' ps-name='currentEntity'    class='portalstudio_title currentEntity_ctrl'><div id='<%=idPortlet%>_currentEntitytbl' style='width:100%;'><%=JSPLib.ToHTML("Current Entity:")%></div></span>
<input id='<%=idPortlet%>_btnConfirm' type='button' class='portalstudio_button btnConfirm_ctrl'/>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPVQREditorSelectBO');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPVQREditorSelectBO_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Entità"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Campi e Link"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPVQREditorSelectBO',["400","400"],["420"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"420","title":"Entità","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"400","h":"420","title":"Campi e Link","layer":"false","npage":"2"}]);
this.dataProcedures=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_dataProcedures","dataproviders":"","fieldsString":"procedure,comment,module","fieldstypeString":"C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"dataProcedures","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":429,"y":13});
this.gridProcedures=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"portalstudio_grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridProcedures","dataobj":"dataProcedures","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":385,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"none","name":"gridProcedures","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":false,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"middle","w":390,"x":5,"y":29,"zindex":""});
this.gridProcedures.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:next()","weight":"","align":"","type":"C","title":"Procedure","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"procedure","fg_color":"","width":"50%","alias":"Procedure","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:next()","weight":"","align":"","type":"C","title":"Description","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"comment","fg_color":"","width":"50%","alias":"Description","RowSpan":0,"extensible":false}]});
this.btnPrev=new ZtVWeb._BC(this,{"anchor":"bottom-left","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnPrev_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPrev","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnPrev","page":2,"spuid":"","tabindex":"","text":"Back","type":"Button","type_submit":"false","type_wizard":"","w":71,"x":5,"y":388,"zindex":"1"});
this.MDProperties=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"","captionsList":"All,Head,Rows","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_MDProperties","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"Tahoma","font_size":"9pt","h":72,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"''","layer":false,"layout_steps_values":{},"name":"MDProperties","orientation":"vertical","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":",HEAD,ROWS","visible":true,"w":102,"x":293,"y":30,"zindex":"1"});
this.MDProperties.Value('<%=JSPLib.ToJSValue(MDProperties,false,true)%>');
this.gridTables=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"tablename","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"portalstudio_grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridTables","dataobj":"dataTables","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":250,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridTables","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":275,"x":5,"y":29,"zindex":""});
this.gridTables.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"weight":"","type":"C","title":"Linked Table Name","layer":"","ColSpan":0,"bg_color":"","newline":false,"field":"tablename","fg_color":"","width":"","alias":"Linked Table Name","RowSpan":0,"extensible":false}]});
this.dataTables=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_dataTables","dataproviders":"","fieldsString":"tablename","fieldstypeString":"C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"dataTables","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":-2,"y":-35});
this.currentEntity=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_currentEntity","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":26,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"currentEntity","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(currentEntity,false,true)%>","type":"Label","w":390,"x":5,"y":3,"zindex":"1"});
this.selectEntity=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_selectEntity","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":26,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"selectEntity","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(selectEntity,false,true)%>","type":"Label","w":390,"x":5,"y":3,"zindex":"1"});
this.btnConfirm=new ZtVWeb._BC(this,{"anchor":"bottom-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button btnConfirm_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnConfirm","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnConfirm","page":2,"spuid":"","tabindex":"","text":"Select","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":330,"y":388,"zindex":"1"});
this.callerFunction=new ZtVWeb._VC(this,'callerFunction',null,'character','<%=JSPLib.ToJSValue(callerFunction,false,true)%>',false,false);
this.hideLinkedTables=new ZtVWeb._VC(this,'hideLinkedTables',null,'character','<%=JSPLib.ToJSValue(hideLinkedTables,false,true)%>',false,false);
this.offlinemode=new ZtVWeb._VC(this,'offlinemode',null,'logic',<%=offlinemode%>,false,false);
this.propRef=new ZtVWeb._VC(this,'propRef',null,'character','<%=JSPLib.ToJSValue(propRef,false,true)%>',false,false);
this.isForm=new ZtVWeb._VC(this,'isForm',null,'logic',<%=isForm%>,false,false);
this.portletId=new ZtVWeb._VC(this,'portletId',null,'character','<%=JSPLib.ToJSValue(portletId,false,true)%>',false,false);
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
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%request.setAttribute("SPVQREditorSelectBO_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPVQREditorSelectBO_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof next !='undefined')this.next=next;
if(typeof MDProperties_onChange !='undefined')this.MDProperties_onChange=MDProperties_onChange;
if(typeof FillLinksTable !='undefined')this.FillLinksTable=FillLinksTable;
if(typeof btnPrev_Click !='undefined')this.btnPrev_Click=btnPrev_Click;
if(typeof btnConfirm_Click !='undefined')this.btnConfirm_Click=btnConfirm_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.dataProcedures.addRowConsumer(this.gridProcedures);
this.dataTables.addRowConsumer(this.gridTables);
function this_Loaded(){
  var res = new JSURL("../servlet/SPXDCProxy?action=procedures"+(this.offlinemode.Value()?'&offlinemode=true':'')).Response();
  if (res!="ACCESS DENIED"){
    res=eval(res);
    this.dataProcedures.FillData(res);
  } else {
    this.selectEntity.Value("Please, login with administrator user.");
  }
  <%=idPortlet%>_tabstrip.HideTabsContainer();
  document.title="Select a procedure";
}
var currentlinks;
function next(){
  var res = new JSURL("../servlet/SPXDCProxy?action=procedure_props&table="+URLenc(this.dataProcedures.rs.procedure)+(this.offlinemode.Value()?'&offlinemode=true':'')).Response();
  if (res!="ACCESS DENIED") {
    res = eval("("+res+")");
    if (res.entityType=='master/detail' && this.hideLinkedTables.Value().toLowerCase()!="true") {
      this.MDProperties.Show();
      this.MDProperties.Value('');
    } else
      this.MDProperties.Hide();
    currentlinks=res.links;
    var hk = haveKeys(currentlinks); 
    if ((!hk && res.entityType!='master/detail') || this.hideLinkedTables.Value().toLowerCase()=="true") {
      this.btnConfirm_Click();
    } else {
      <%=idPortlet%>_tabstrip.Next();
      this.currentEntity.Value("Selected Entity: "+this.dataProcedures.rs.comment)
      if (hk) {
        this.gridTables.Show();
        this.FillLinksTable();
        this.MDProperties.leftposition=293;
        this.MDProperties.Ctrl.style.left="293px";
      } else {
        this.gridTables.Hide();
        this.MDProperties.leftposition=5;
        this.MDProperties.Ctrl.style.left="5px";
      }
    }
  } else {
    this.selectEntity.Value("Please, login with administrator user.");
  }
}
var haveKeys=function(obj) {
  var res=false;
  if (obj)
  for (var key in obj){
    if (obj.hasOwnProperty(key)) res=true;
  }
  return res;
}
function MDProperties_onChange(){
  if (haveKeys(currentlinks))
    this.FillLinksTable();
}
function FillLinksTable() {
  var _;
  var mode = (!this.MDProperties.IsHidden()? this.MDProperties.Value()=="HEAD"?false:(this.MDProperties.Value()=="ROWS"?true:_):_);
  var data=[];
  for (var tbl in currentlinks) {
    if (typeof mode =='undefined' || LibJavascript.Array.indexOf(currentlinks[tbl],mode,function(e1,e2){return /^true$/i.test(e1)==e2;})>-1)
      data.push([tbl])
  }
  if (this.gridTables.datasource) {
    this.gridTables.CloseRow()
    this.gridTables._initMemCurs()
    this.gridTables._renderOutputDataObj();
  }
  this.dataTables.FillData(data);
}
function btnPrev_Click(){
<%=idPortlet%>_tabstrip.Prev();
}
function btnConfirm_Click(){
  var result = "BO:"+this.dataProcedures.rs.procedure;
  if (!this.MDProperties.IsHidden() && this.MDProperties.Value()!="" && this.hideLinkedTables.Value().toLowerCase()!="true"){
    result += "["+this.MDProperties.Value()+"]";
  }
  if (haveKeys(currentlinks) && this.hideLinkedTables.Value().toLowerCase()!="true") {
    var tmp = this.gridTables.GetSelectedData()
    for (var i=0; i<tmp.Data.length-1; i++) {
      result += "->"+tmp.Data[i][0];
    }
  }
  var call = (window.opener?window.opener:(window.caller?window.caller:window.parent));
  if (!Empty(this.callerFunction.Value()) && call[this.callerFunction.Value()]){
    call[this.callerFunction.Value()](result,this.dataProcedures.rs.module);
  }else{
    if(!Empty(this.portletId.Value()) && GetOpener()[this.portletId.Value()].selectedBO){
      GetOpener()[this.portletId.Value()].selectedBO.Set(Strtran(result,"BO:",""));
    }else{
    
      if(this.isForm.Value()){
        GetOpener().formProp[this.propRef.Value()]=Strtran(result,"BO:","");
      }else{
        GetOpener().itemsHTML[GetOpener().index][this.propRef.Value()]=Strtran(result,"BO:","");
      }
      if(this.isForm.Value()){
        GetOpener().FormProperties();  
      }else{
        GetOpener().Properties();  
      }
    }
  }
  
  if (call.closeSPModalLayer && !window.opener){
    if ( !call.closeSPModalLayer() && window.WindowClose ) {
      window.WindowClose();
    }
  }
  else 
    window.close();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPVQREditorSelectBO_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPVQREditorSelectBO',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPVQREditorSelectBO');
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
sp.endPage("SPVQREditorSelectBO");
}%>
<%! public String getJSPUID() { return "1391350091"; } %>