<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\nfunction this_Loaded() {\n  this.ZtTabs.HideTabsContainer();\n  if (Empty(this.pagetype.Value()))\n    return;\n  this.setupd.Value(false);\n \tif (this.pagetype.Value() == 1) {\n    if (Empty(this.fields.Value()))\n    \treturn;\n    if (Empty(this.series.Value()))\n      this.series.Value(this.fields.Value());\n    var data = [],\n      splits = this.series.Value().split(\",\"),\n      prop = this.prop.Value(),\n      psplit;\n    if (!Empty(prop))\n      prop = prop.split(\"|\");\n    else\n      prop = splits;\n    for (var i = 0; i \u003c prop.length; i++) {\n      if (prop[i].indexOf(\";\") \u003e= 0) {\n        psplit = prop[i].split(\";\");\n        data.push([psplit[0], psplit[1], (psplit[2] == \"false\" ? 0 : 1)]);\n      }\n      else\n        data.push([prop[i], \"default\", 0]);\n    }\n    this.sdp.FillData(data);\n  }\n  else {\n    var data = [],\n        prop = this.prop.Value();\n    if (!Empty(prop))\n      prop = prop.split(\"|\");\n    else\n      prop = [\";default;\"];\n    for (var i = 0; i \u003c prop.length; i++) {\n      if (prop[i].indexOf(\";\") \u003e= 0) {\n        psplit = prop[i].split(\";\");\n        data.push([psplit[0], psplit[1], (psplit[2] || \"\")]);\n      }\n      else\n        data.push([\"\", \"default\"]);\n    }\n    this.sdpclass.FillData(data);\n  }\n\t\n  var tptl = this.getTitlePortlet();\n  if (!Empty(this.fromwizard.Value())) {\n    tptl.Ctrl_container.style.display = \"none\";\n  }\n  else {\n    var ttoolb = tptl.toolbar;\n    ttoolb.Append({\tid: \"okconf\",\n                   title: FormatMsg(\"RPT_APPLY\"),\n                   tooltip: FormatMsg(\"RPT_APPLY\"),\n                   action: this.pageReturnConfiguration,\n                   image: {\tFontName: \"icons8_win10\",\n                           Size: 24,\n                           Char: parseInt(\"ef8b\",16),\n                           FontWeight: \"normal\"\n                          }\n                            });\n    ttoolb.Append({\tid: \"delconf\",\n                   title: FormatMsg(\"MSG_CLOSE_ONEXIT\"),\n                   tooltip: FormatMsg(\"MSG_CLOSE_ONEXIT\"),\n                   action: this.returnOnCancel,\n                   image: {\tFontName: \"icons8_win10\",\n                           Size: 24,\n                           Char: parseInt(\"ed93\",16),\n                           FontWeight: \"normal\"\n                          }\n                  });\n  }\n  \n  this.ZtTabs.Select(\"page\" + this.pagetype.Value());\n}\n\nfunction Grid6_DataChange(){\n  this.setupd.Value(true);\n}\n\nfunction GridClass_DataChange(){\n  this.setupd.Value(true);\n}\n\nfunction returnSeriesConfiguration() {\n\tvar mconf = _this.Grid6.GetSelectedData(),\n      splits = _this.series.Value().split(\",\"),\n      fsplits = _this.fields.Value().split(\",\"),\n      rstring = \"\";\n  if (_this.setupd.Value()) {\n    for (var i = 0; i \u003c splits.length; i++) {\n      var f = false;\n      for (var j = 0; !f && j \u003c mconf.Data.length - 1; j++) {\n        if (mconf.Data[j][0] == splits[i]) {\n          rstring += fsplits[i] + \";\" + mconf.Data[j][mconf.Fields.indexOf(\"TYPE_new\")] + \";\" + (mconf.Data[j][mconf.Fields.indexOf(\"KAXIS_new\")] == \"0\" ? \"false\" : \"true\") + \"|\";  \t\n          f = true;\n        }\n      }\n\n      if (!f)\n        rstring += fsplits[i] + \";\" + \"default\" + \";\" + \"false\" + \"|\";\n    }\n\n    if (rstring.slice(-1) == \"|\")\n      rstring = rstring.slice(0, rstring.length - 1);\n  }\n  else\n    rstring = _this.prop.Value();\n  \n  if (GetOpener() && GetOpener()[_this.callerFunction.Value()]) {\n  \tGetOpener()[_this.callerFunction.Value()](_this.index.Value(), rstring);\n    GetOpener().closeSPModalLayer();\n  }\n  else\n    window.closeSPModalLayer();  \n}\n\nfunction returnOnCancel() {\n\tif (GetOpener() && GetOpener()[_this.callerFunction.Value()]) {\n  \tGetOpener()[_this.callerFunction.Value()](_this.index.Value(), _this.prop.Value());\n    GetOpener().closeSPModalLayer();\n  }\n  else\n    window.closeSPModalLayer();\n}\n\nfunction returnSeriesConfigurationForWizard() {\n  var mconf = this.Grid6.GetSelectedData(),\n      splits = this.series.Value().split(\",\"),\n      fsplits = this.fields.Value().split(\",\"),\n      rstring = \"\";\n  if (this.setupd.Value()) {\n    for (var i = 0; i \u003c splits.length; i++) {\n      var f = false;\n      for (var j = 0; !f && j \u003c mconf.Data.length - 1; j++) {\n        if (mconf.Data[j][0] == splits[i]) {\n          rstring += splits[i] + \";\" + mconf.Data[j][mconf.Fields.indexOf(\"TYPE_new\")] + \";\" + (mconf.Data[j][mconf.Fields.indexOf(\"KAXIS_new\")] == \"0\" ? \"false\" : \"true\") + \"|\";  \t\n          f = true;\n        }\n      }\n\n      if (!f)\n        rstring += fsplits[i] + \";\" + \"default\" + \";\" + \"false\" + \"|\";\n    }\n\n    if (rstring.slice(-1) == \"|\")\n      rstring = rstring.slice(0, rstring.length - 1);\n  }\n  else\n    rstring = this.prop.Value();\n  \n  return rstring;\n}\n\nfunction returnClassificationConfiguration() {\n\tvar mconf = _this.GridClass.GetSelectedData(),\n      old_prop = _this.prop.Value(),\n      rstring = \"\",\n      splits = old_prop.split(\"|\");\n\n  if (_this.setupd.Value()) {\n    for (var i = 0; i \u003c splits.length; i++) {\n      var f = false,\n          pcol = splits[i].split(\";\")[0];\n      for (var j = 0; !f && j \u003c mconf.Data.length - 1; j++) {\n        if (mconf.Data[j][0] == pcol) {\n          rstring +=  mconf.Data[j][mconf.Fields.indexOf(\"NODE_new\")] + \";\" + mconf.Data[j][mconf.Fields.indexOf(\"TYPE_new\")] + \";\" + mconf.Data[j][mconf.Fields.indexOf(\"COLOR_new\")] + \"|\";  \t\n          f = true;\n        }\n      }\n\n      if (!f)\n        rstring += splits[i] + \"|\";\n    }\n\n    if (rstring.slice(-1) == \"|\")\n      rstring = rstring.slice(0, rstring.length - 1);\n  }\n  else\n    rstring = _this.prop.Value();\n\n  if (GetOpener() && GetOpener()[_this.callerFunction.Value()]) {\n  \tGetOpener()[_this.callerFunction.Value()](_this.index.Value(), rstring);\n    GetOpener().closeSPModalLayer();\n  }\n  else\n    window.closeSPModalLayer();  \n}\n\nfunction pageReturnConfiguration() {\n\tif (_this.pagetype.Value() == 1)\n    _this.returnSeriesConfiguration();\n  else\n    _this.returnClassificationConfiguration();\n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"250","hsl":"","htmlcode":"{{ series }}\n{{ fields }}\n{{ sdp }}\n{{ sdpclass }}\n{{ Grid6 }}\n{{ GridClass }}\n{{ pagetype }}\n{{ callerFunction }}\n{{ index }}\n{{ prop }}\n{{ setupd }}\n{{ fromwizard }}\n{{ Image12 }}{{ Image13 }}{{ Label14 }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"d3.js,ZtChartFunctions.js","offline":"false","on_security_failure":"login","pages_names":"series,classification","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"385","version":"37","w":"100%","wizard":""},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"series","page":"1","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"404","y":"37"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"fields","page":"1","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"404","y":"60"},{"alias":"VALUEF,TYPE,KAXIS","auto_exec":"true","dataproviders":"","fieldsType":"C,C,L","h":"30","man_query":"","name":"sdp","page":"1","parms":"","parms_source":"","sequence":"3","type":"StaticDataProvider","w":"55","x":"405","y":"-3"},{"alias":"NODE,TYPE,COLOR","auto_exec":"true","dataproviders":"","fieldsType":"C,C,C","h":"30","man_query":"","name":"sdpclass","page":"2","parms":"","parms_source":"","sequence":"4","type":"StaticDataProvider","w":"101","x":"415","y":"7"},{"align":"left","anchor":"top-left-right(%)-bottom","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"VALUEF,TYPE,KAXIS","colProperties":"[{\"field\":\"html:bar:100,0,100,%COLOR%,%COLOR%\",\"title\":\"Serie\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"VALUEF\",\"title\":\"Serie\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"combobox:TYPE:[['default';'default'];['LINES';'line'];['SLINES';'line with only shapes'];['VBAR';'vertical bar'];['AREA';'area'];['STACKEDAREA';'stacked-area'];['VSTACKBAR';'vertical stacked-bar'];['LAYEREDBAR';'vertical layered bar'];['TREEMAPBAR';'vertical treemap bar']]:false\",\"title\":\"Tipo di grafico\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"isEditable\":true,\"title_align\":\"\"},{\"field\":\"checkbox:KAXIS\",\"title\":\"Scala con asse dedicato\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"isEditable\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"sdp","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"244","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid6","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"380","wireframe_props":"colProperties,checkbox,rows","x":"5","y":"2","zindex":"7"},{"align":"left","anchor":"top-left-right(%)-bottom","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"NODE,TYPE","colProperties":"[{\"field\":\"NODE\",\"title\":\"Classificazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"isEditable\":true,\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"field\":\"combobox:TYPE:[['default';'default'];['circle';'circle'];['square';'square'];['triangle';'triangle'];['cross';'cross'];['diamond';'diamond'];['star';'star'];['wye';'wye']]:false\",\"title\":\"Tipo di forma\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"isEditable\":true,\"title_align\":\"\"},{\"field\":\"COLOR\",\"title\":\"Colore (hex with # or rgb)\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"isEditable\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"sdpclass","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"241","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"GridClass","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"6","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"left","title_color":"","type":"Grid","valign":"top","w":"380","wireframe_props":"colProperties,checkbox,rows","x":"5","y":"5","zindex":"7"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"pagetype","page":"1","sequence":"7","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"404","y":"198"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"callerFunction","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"404","y":"83"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"index","page":"1","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"404","y":"106"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"prop","page":"1","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"404","y":"129"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"setupd","page":"1","sequence":"11","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"404","y":"152"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"fromwizard","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"404","y":"175"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:series,fields,pagetype,callerFunction,index,prop,fromwizard*/%>
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
window.SPChartSeriesConfigurator_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Grid6_DataChange !='undefined')this.Grid6_DataChange=Grid6_DataChange;
if(typeof GridClass_DataChange !='undefined')this.GridClass_DataChange=GridClass_DataChange;
if(typeof returnSeriesConfiguration !='undefined')this.returnSeriesConfiguration=returnSeriesConfiguration;
if(typeof returnOnCancel !='undefined')this.returnOnCancel=returnOnCancel;
if(typeof returnSeriesConfigurationForWizard !='undefined')this.returnSeriesConfigurationForWizard=returnSeriesConfigurationForWizard;
if(typeof returnClassificationConfiguration !='undefined')this.returnClassificationConfiguration=returnClassificationConfiguration;
if(typeof pageReturnConfiguration !='undefined')this.pageReturnConfiguration=pageReturnConfiguration;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.sdp.addRowConsumer(this.Grid6);
this.sdpclass.addRowConsumer(this.GridClass);
var _this = this;
function this_Loaded() {
  this.ZtTabs.HideTabsContainer();
  if (Empty(this.pagetype.Value()))
    return;
  this.setupd.Value(false);
 	if (this.pagetype.Value() == 1) {
    if (Empty(this.fields.Value()))
    	return;
    if (Empty(this.series.Value()))
      this.series.Value(this.fields.Value());
    var data = [],
      splits = this.series.Value().split(","),
      prop = this.prop.Value(),
      psplit;
    if (!Empty(prop))
      prop = prop.split("|");
    else
      prop = splits;
    for (var i = 0; i < prop.length; i++) {
      if (prop[i].indexOf(";") >= 0) {
        psplit = prop[i].split(";");
        data.push([psplit[0], psplit[1], (psplit[2] == "false" ? 0 : 1)]);
      }
      else
        data.push([prop[i], "default", 0]);
    }
    this.sdp.FillData(data);
  }
  else {
    var data = [],
        prop = this.prop.Value();
    if (!Empty(prop))
      prop = prop.split("|");
    else
      prop = [";default;"];
    for (var i = 0; i < prop.length; i++) {
      if (prop[i].indexOf(";") >= 0) {
        psplit = prop[i].split(";");
        data.push([psplit[0], psplit[1], (psplit[2] || "")]);
      }
      else
        data.push(["", "default"]);
    }
    this.sdpclass.FillData(data);
  }
	
  var tptl = this.getTitlePortlet();
  if (!Empty(this.fromwizard.Value())) {
    tptl.Ctrl_container.style.display = "none";
  }
  else {
    var ttoolb = tptl.toolbar;
    ttoolb.Append({	id: "okconf",
                   title: FormatMsg("RPT_APPLY"),
                   tooltip: FormatMsg("RPT_APPLY"),
                   action: this.pageReturnConfiguration,
                   image: {	FontName: "icons8_win10",
                           Size: 24,
                           Char: parseInt("ef8b",16),
                           FontWeight: "normal"
                          }
                            });
    ttoolb.Append({	id: "delconf",
                   title: FormatMsg("MSG_CLOSE_ONEXIT"),
                   tooltip: FormatMsg("MSG_CLOSE_ONEXIT"),
                   action: this.returnOnCancel,
                   image: {	FontName: "icons8_win10",
                           Size: 24,
                           Char: parseInt("ed93",16),
                           FontWeight: "normal"
                          }
                  });
  }
  
  this.ZtTabs.Select("page" + this.pagetype.Value());
}
function Grid6_DataChange(){
  this.setupd.Value(true);
}
function GridClass_DataChange(){
  this.setupd.Value(true);
}
function returnSeriesConfiguration() {
	var mconf = _this.Grid6.GetSelectedData(),
      splits = _this.series.Value().split(","),
      fsplits = _this.fields.Value().split(","),
      rstring = "";
  if (_this.setupd.Value()) {
    for (var i = 0; i < splits.length; i++) {
      var f = false;
      for (var j = 0; !f && j < mconf.Data.length - 1; j++) {
        if (mconf.Data[j][0] == splits[i]) {
          rstring += fsplits[i] + ";" + mconf.Data[j][mconf.Fields.indexOf("TYPE_new")] + ";" + (mconf.Data[j][mconf.Fields.indexOf("KAXIS_new")] == "0" ? "false" : "true") + "|";  	
          f = true;
        }
      }
      if (!f)
        rstring += fsplits[i] + ";" + "default" + ";" + "false" + "|";
    }
    if (rstring.slice(-1) == "|")
      rstring = rstring.slice(0, rstring.length - 1);
  }
  else
    rstring = _this.prop.Value();
  
  if (GetOpener() && GetOpener()[_this.callerFunction.Value()]) {
  	GetOpener()[_this.callerFunction.Value()](_this.index.Value(), rstring);
    GetOpener().closeSPModalLayer();
  }
  else
    window.closeSPModalLayer();  
}
function returnOnCancel() {
	if (GetOpener() && GetOpener()[_this.callerFunction.Value()]) {
  	GetOpener()[_this.callerFunction.Value()](_this.index.Value(), _this.prop.Value());
    GetOpener().closeSPModalLayer();
  }
  else
    window.closeSPModalLayer();
}
function returnSeriesConfigurationForWizard() {
  var mconf = this.Grid6.GetSelectedData(),
      splits = this.series.Value().split(","),
      fsplits = this.fields.Value().split(","),
      rstring = "";
  if (this.setupd.Value()) {
    for (var i = 0; i < splits.length; i++) {
      var f = false;
      for (var j = 0; !f && j < mconf.Data.length - 1; j++) {
        if (mconf.Data[j][0] == splits[i]) {
          rstring += splits[i] + ";" + mconf.Data[j][mconf.Fields.indexOf("TYPE_new")] + ";" + (mconf.Data[j][mconf.Fields.indexOf("KAXIS_new")] == "0" ? "false" : "true") + "|";  	
          f = true;
        }
      }
      if (!f)
        rstring += fsplits[i] + ";" + "default" + ";" + "false" + "|";
    }
    if (rstring.slice(-1) == "|")
      rstring = rstring.slice(0, rstring.length - 1);
  }
  else
    rstring = this.prop.Value();
  
  return rstring;
}
function returnClassificationConfiguration() {
	var mconf = _this.GridClass.GetSelectedData(),
      old_prop = _this.prop.Value(),
      rstring = "",
      splits = old_prop.split("|");
  if (_this.setupd.Value()) {
    for (var i = 0; i < splits.length; i++) {
      var f = false,
          pcol = splits[i].split(";")[0];
      for (var j = 0; !f && j < mconf.Data.length - 1; j++) {
        if (mconf.Data[j][0] == pcol) {
          rstring +=  mconf.Data[j][mconf.Fields.indexOf("NODE_new")] + ";" + mconf.Data[j][mconf.Fields.indexOf("TYPE_new")] + ";" + mconf.Data[j][mconf.Fields.indexOf("COLOR_new")] + "|";  	
          f = true;
        }
      }
      if (!f)
        rstring += splits[i] + "|";
    }
    if (rstring.slice(-1) == "|")
      rstring = rstring.slice(0, rstring.length - 1);
  }
  else
    rstring = _this.prop.Value();
  if (GetOpener() && GetOpener()[_this.callerFunction.Value()]) {
  	GetOpener()[_this.callerFunction.Value()](_this.index.Value(), rstring);
    GetOpener().closeSPModalLayer();
  }
  else
    window.closeSPModalLayer();  
}
function pageReturnConfiguration() {
	if (_this.pagetype.Value() == 1)
    _this.returnSeriesConfiguration();
  else
    _this.returnClassificationConfiguration();
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
.SPChartSeriesConfigurator_container {
}
.SPChartSeriesConfigurator_portlet{
  position:relative;
  min-width:385px;
  height:250px;
}
.SPChartSeriesConfigurator_portlet[Data-page="1"]{
  height:250px;
  width:100%;
}
.SPChartSeriesConfigurator_portlet[Data-page="2"]{
  height:250px;
  width:100%;
}
.SPChartSeriesConfigurator_portlet > .SPChartSeriesConfigurator_page > .Grid6_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:2px;
  left:5px;
  right:0px;
  right:0.0%;
  bottom:4px;
  width:auto;
}
.SPChartSeriesConfigurator_portlet > .SPChartSeriesConfigurator_page > .GridClass_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  right:0px;
  right:0.0%;
  bottom:4px;
  width:auto;
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
 String def="[{\"h\":\"250\",\"layout_steps_values\":{},\"pages_names\":\"series,classification\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"385\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"37\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"60\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"55\",\"x\":\"405\",\"y\":\"-3\"},{\"h\":\"30\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"101\",\"x\":\"415\",\"y\":\"7\"},{\"anchor\":\"top-left-right(%)-bottom\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Serie\"},{\"title\":\"Serie\"},{\"isEditable\":true,\"title\":\"Tipo di grafico\"},{\"isEditable\":true,\"title\":\"Scala con asse dedicato\"}],\"h\":\"244\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"380\",\"x\":\"5\",\"y\":\"2\",\"zindex\":\"7\"},{\"anchor\":\"top-left-right(%)-bottom\",\"checkbox\":\"false\",\"colProperties\":[{\"isEditable\":true,\"title\":\"Classificazione\"},{\"isEditable\":true,\"title\":\"Tipo di forma\"},{\"isEditable\":true,\"title\":\"Colore (hex with # or rgb)\"}],\"h\":\"241\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"380\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"7\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"198\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"83\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"106\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"129\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"152\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"404\",\"y\":\"175\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPChartSeriesConfigurator","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPChartSeriesConfigurator_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("d3.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("ZtChartFunctions.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPChartSeriesConfigurator','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String series=JSPLib.translateXSS(sp.getParameter("series",""));
String fields=JSPLib.translateXSS(sp.getParameter("fields",""));
if(request.getAttribute("SPChartSeriesConfigurator_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
if(request.getAttribute("SPChartSeriesConfigurator_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%double pagetype=sp.getParameter("pagetype",0);
String callerFunction=JSPLib.translateXSS(sp.getParameter("callerFunction",""));
String index=JSPLib.translateXSS(sp.getParameter("index",""));
String prop=JSPLib.translateXSS(sp.getParameter("prop",""));
boolean setupd= false;
String fromwizard=JSPLib.translateXSS(sp.getParameter("fromwizard",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPChartSeriesConfigurator_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPChartSeriesConfigurator_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPChartSeriesConfigurator_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPChartSeriesConfigurator','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPChartSeriesConfigurator_page' style='display:block'>
<div id='<%=idPortlet%>_Grid6' formid='<%=idPortlet%>' ps-name='Grid6'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
</div>
<div id='<%=idPortlet%>_page_2' class='SPChartSeriesConfigurator_page' style='display:none'>
<div id='<%=idPortlet%>_GridClass' formid='<%=idPortlet%>' ps-name='GridClass'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPChartSeriesConfigurator');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CHANGE_MARK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CHANGE_MARK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_INSERT_2ND_OP",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_INSERT_2ND_OP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CLOSE_ONEXIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CLOSE_ONEXIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_APPLY",true)+","+JSPLib.ToJSValue(sp.translate("RPT_APPLY"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPChartSeriesConfigurator_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("series"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("classification"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPChartSeriesConfigurator',["385","385"],["250"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"385","h":"250","title":"series","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"385","h":"250","title":"classification","layer":"false","npage":"2"}]);
this.series=new ZtVWeb._VC(this,'series',null,'character','<%=JSPLib.ToJSValue(series,false,true)%>',false,false);
this.fields=new ZtVWeb._VC(this,'fields',null,'character','<%=JSPLib.ToJSValue(fields,false,true)%>',false,false);
this.sdp=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_sdp","dataproviders":"","fieldsString":"VALUEF,TYPE,KAXIS","fieldstypeString":"C,C,L","h":30,"hide":"false","layer":false,"layout_steps_values":{},"name":"sdp","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":55,"x":405,"y":-3});
this.sdpclass=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_sdpclass","dataproviders":"","fieldsString":"NODE,TYPE,COLOR","fieldstypeString":"C,C,C","h":30,"hide":"false","layer":false,"layout_steps_values":{},"name":"sdpclass","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":101,"x":415,"y":7});
this.Grid6=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right(%)-bottom","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"VALUEF,TYPE,KAXIS","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid6","dataobj":"sdp","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":244,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid6","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":380,"x":5,"y":2,"zindex":"7"});
this.Grid6.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"Serie","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:bar:100,0,100,%COLOR%,%COLOR%","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Serie","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"VALUEF","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo di grafico","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"isEditable":true,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:TYPE:[['default';'default'];['LINES';'line'];['SLINES';'line with only shapes'];['VBAR';'vertical bar'];['AREA';'area'];['STACKEDAREA';'stacked-area'];['VSTACKBAR';'vertical stacked-bar'];['LAYEREDBAR';'vertical layered bar'];['TREEMAPBAR';'vertical treemap bar']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Scala con asse dedicato","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"isEditable":true,"extensible":false,"enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"checkbox:KAXIS","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
PrepareJsCalendar(false);
this.GridClass=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right(%)-bottom","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"NODE,TYPE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridClass","dataobj":"sdpclass","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":241,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"GridClass","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"left","title_color":"","type":"Grid","valign":"top","w":380,"x":5,"y":5,"zindex":"7"});
this.GridClass.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Classificazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"isEditable":true,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"NODE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo di forma","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"isEditable":true,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:TYPE:[['default';'default'];['circle';'circle'];['square';'square'];['triangle';'triangle'];['cross';'cross'];['diamond';'diamond'];['star';'star'];['wye';'wye']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Colore (hex with # or rgb)","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"isEditable":true,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"COLOR","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
PrepareJsCalendar(false);
this.pagetype=new ZtVWeb._VC(this,'pagetype',null,'numeric',<%=pagetype%>,false,false);
this.callerFunction=new ZtVWeb._VC(this,'callerFunction',null,'character','<%=JSPLib.ToJSValue(callerFunction,false,true)%>',false,false);
this.index=new ZtVWeb._VC(this,'index',null,'character','<%=JSPLib.ToJSValue(index,false,true)%>',false,false);
this.prop=new ZtVWeb._VC(this,'prop',null,'character','<%=JSPLib.ToJSValue(prop,false,true)%>',false,false);
this.setupd=new ZtVWeb._VC(this,'setupd',null,'logic',<%=setupd%>,false,false);
this.fromwizard=new ZtVWeb._VC(this,'fromwizard',null,'character','<%=JSPLib.ToJSValue(fromwizard,false,true)%>',false,false);
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
<%if(request.getAttribute("SPChartSeriesConfigurator_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPChartSeriesConfigurator_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPChartSeriesConfigurator_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPChartSeriesConfigurator',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPChartSeriesConfigurator');
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
sp.endPage("SPChartSeriesConfigurator");
}%>
<%! public String getJSPUID() { return "3529637888"; } %>