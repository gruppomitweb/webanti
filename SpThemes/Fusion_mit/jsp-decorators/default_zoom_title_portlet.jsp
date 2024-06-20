<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.struct_linkedConfs=[];\nvar ZoomObj = null;\nvar skin = '\u003c%=sp.getSkin()%\u003e';\nvar _this = this;\nvar l_actions;\n\nfunction InitGrammar() {\n  if (!parent.SpeechGrammar) {\n    \u002f\u002f non e' disponibile la libreria SpeechGrammar\n\t\treturn false;\n  }\n  SpeechGrammar = parent.SpeechGrammar;\n  \n  var config = ZoomObj.vzmstructure.Configuration;\n  var zoomName = config.Autozoom ? config.Autozoom : config.vqrname;\n  var zoomDescription = config.description ? config.description : zoomName;\n\n  var terminiObj = {\n    cols: {}, campo: [], campo_V: [], campo_T: [], soggetto: [zoomDescription], soggetto_V: [zoomName]\n  };\n  var cols = ZoomObj.vzmstructure.Cols;\n  for (var i = 0; i \u003c cols.length; i++) {\n    var synonyms = cols[i].synonyms ? cols[i].synonyms.split(',') : [];\n    terminiObj.cols[cols[i].field] = {title: cols[i].title_trad, type: cols[i].type};\n    if(synonyms.length == 0) {\n        terminiObj.campo.push(cols[i].title_trad);\n        terminiObj.campo_V.push(cols[i].field);\n        terminiObj.campo_T.push(cols[i].type); \n    } else {\n      for (var j = 0; j \u003c synonyms.length; j++) {\n        terminiObj.campo.push(synonyms[j]);\n        terminiObj.campo_V.push(cols[i].field);\n        terminiObj.campo_T.push(cols[i].type);\n      }\n    }\n  }\n\n  terminiObj.defaultFld = {};\n  \n  SpeechGrammar.populateColsName(terminiObj, ZoomGrammar.getMinorGrammar());\n\tSpeechGrammar.populateColsName(terminiObj, ZoomGrammar.getMainGrammar());\n\n  var grammarConfig = {};\n  grammarConfig.containerName = window.frameElement.name;\n  grammarConfig.modal = window.frameElement ? window.frameElement.getAttribute(\"modallayer\") : false;\n  grammarConfig.type = 'zoom';\n  grammarConfig.grammar = ZoomGrammar;\n  grammarConfig.ZoomObj = ZoomObj;\n  grammarConfig.termini = terminiObj;\n  grammarConfig.fileName = zoomName + '__' + grammarConfig.type;\n  SpeechGrammar.addGrammarConfig(grammarConfig);\n\n  parent.LoadConfiguration(grammarConfig.fileName);\n}\n\nfunction SubmitListenerForm(elem){\n  switch(elem){\n    case \"new\":\n      ZoomObj.AddNewRecord()\n      break;\n    case \"query\":\n      window.location = \"..\u002fservlet\u002f\"+ZoomObj.Autozoom.Value();\n      break;\n    case \"refresh\":\n      ZoomObj.refreshQuery();\n      break;\n    case \"print\":\n      ZoomObj.printZoom();\n      break;\n    case \"expandreduce\":\n      var wasextended = ZoomObj.Grid.IsExtended();\n      ZoomObj.Grid.ExpandOReduce();\n      this.toolbar.UpdateItem('expandreduce', {\n        \ttitle: wasextended ? FormatMsg('MSG_EXPAND') : FormatMsg('MSG_REDUCE'),\n        \timage:{ fontFamily:'icons8_win10', value: wasextended ? \"&#xee18\" : \"&#xefd2\", size: \"20px\"}\n     \t});\n      break;\n    case \"showVdm\":\n      ZoomObj.ShowVdmMask();\n      break;\n  }\n}\nfunction SetButtons(id,configElements,canAdd){\n  ZoomObj=ZtVWeb.getPortletById(id);\n  InitGrammar();\n  if(configElements.indexOf(\"-n\")==-1 && canAdd){\n    this.toolbar.Append({\n      id:'new',\n      title: FormatMsg('MSG_FORM_FUNCTION_NEW'),\n      action: function(){ _this.SubmitListenerForm('new');},\n      image:{ fontFamily:'icons8_win10', value: \"&#xebed\", size: \"19px\"}\n    });\n  } else {\n    this.toolbar.Remove('new');\n  }\n\tif ((ZoomObj.vzmstructure.Configuration.filters!=\"false\" || !Empty(ZoomObj.vdmName)) && ZoomObj.vzmstructure.Configuration.hideFiltersBtn!=\"true\"){\n  \tvar vdmAct={\n    \tid:'showVdm',\n    \ttitle:FormatMsg('MSG_FILTERS'),\n    \timage:{fontFamily:'icons8_win10', value: \"&#xee44\", size: \"20px\"},\n    \taction:function(){ _this.SubmitListenerForm('showVdm')}\n  \t}\n    if (!Empty(ZoomObj.vdmName))\n    \tthis.toolbar.Append(vdmAct);\n    else\n      this.toolbar.AppendMenuItem(vdmAct);\n  }\n  else \n    this.toolbar.Remove('showVdm');\n  if(ZoomObj.Grid.extensible=='false' || EmptyArray(ZoomObj.Grid.extFields)){\n    \u002f\u002fnascosti\n    this.toolbar.Remove('expandreduce');\n  }else{\n    var isextended = ZoomObj.Grid.IsExtended();\n    if (this.toolbar.IsInToolbar('expandreduce') || this.toolbar.IsInMenu('expandreduce'))\n      this.toolbar.UpdateItem('expandreduce', {\n        \ttitle: isextended ? FormatMsg('MSG_REDUCE') : FormatMsg('MSG_EXPAND'),\n        \timage:{ fontFamily:'icons8_win10', value: isextended ?  \"&#xefd2\" : \"&#xee18\", size: \"20px\"}\n     \t});\n    else {\n      var act={\n        id:'expandreduce',\n        title: isextended ? FormatMsg('MSG_REDUCE') : FormatMsg('MSG_EXPAND'),\n        action:function(){ _this.SubmitListenerForm('expandreduce')},\n        image:{ fontFamily:'icons8_win10', value: isextended ?  \"&#xefd2\" : \"&#xee18\", size: \"20px\"}\n      }\n      if (!Empty(ZoomObj.vdmName)){\n        if (!this.toolbar.AppendAfter(act,'showVdm') && !this.toolbar.AppendBefore(act,'print')  && !this.toolbar.AppendBefore(act,'query') && !this.toolbar.AppendBefore(act,'refresh'))\n          this.toolbar.Append(act);\n      }\n      else { \u002f\u002f bottone di showVdm nel menu\n        if (!this.toolbar.AppendBefore(act,'print') && !this.toolbar.AppendBefore(act,'query') && !this.toolbar.AppendBefore(act,'refresh') && !this.toolbar.AppendBefore(act,'showVdm'))\n          this.toolbar.Append(act);\n      }\n    }\n  }\n  if(configElements.indexOf(\"-p\")==-1 && ZoomObj.vzmstructure.Configuration.PrintMode!='None'){\n    this.toolbar.Append({\n      id:'print',\n      title: FormatMsg('MSG_VZM_PRINT'),\n      action:function(){ _this.SubmitListenerForm('print')},\n      image:{ fontFamily:'icons8_win10', value: \"&#xec0b\", size: \"20px\"}\n    });\n  } else {\n    this.toolbar.Remove('print');\n  }\n  if (ZoomObj.vzmstructure.Configuration.LinkQuery!='false' && \n      !EmptyString(ZoomObj.Autozoom.Value()) && !EmptyString(ZoomObj.PKFields.Value()) && \n      ((ZoomObj.m_cAction && ZoomObj.m_cAction.Value()==\"autozoom\") || ZoomObj.vzmstructure.Configuration.LinkQuery=='force')){\n      this.toolbar.Append({\n        id:'query',\n        title: FormatMsg('MSG_FORM_FUNCTION_QUERY'),\n        action:function(){ _this.SubmitListenerForm('query')},\n        image:{ fontFamily:'icons8_win10', value: \"&#xe950\", size: \"20px\"}\n      });\n    this.Autozoom.Value(ZoomObj.Grid.autozoom)\n    ZoomObj.Grid.autozoom=\"\";\n\t}\n\t\n  \n  this.toolbar.Append({\n    id:'refresh',\n    title: FormatMsg('MSG_FORM_FUNCTION_REFRESH'),\n    action:function(){ _this.SubmitListenerForm('refresh')},\n    image:{ fontFamily:'icons8_win10', value: \"&#xec4d\", size: \"20px\"}\n  });\n  \n  var ii = 0;\n  while( this.toolbar.Remove( 'action' + ii ) ) {\n    ii++;\n  }\n  if (l_actions) {\n    for (ii=0; ii\u003cl_actions.length; ii++) {\n      var action={\n        id:'action'+ii,\n        title:  l_actions[ii].title_trad || l_actions[ii].title,\n        image: l_actions[ii].image_settings=='fontIcon'?{\n              fontFamily:l_actions[ii].font_name,\n              size:l_actions[ii].font_size,\n              value:l_actions[ii].font_image,\n              color:l_actions[ii].font_color\n            }:l_actions[ii].image,\n        action: (function(_action) { return function() { ZoomObj.ExecAction(_action) }; })(l_actions[ii]),\n        tooltip: l_actions[ii].tooltip || l_actions[ii].title_trad || l_actions[ii].title,\n        target:l_actions[ii].target\n      }\n      if (CharToBool(l_actions[ii].important)){\n        if (!Empty(ZoomObj.vdmName)){ \u002f\u002f il bottone dei filtri ? nella toolbar prima del bottone di espandi riduci\n          if (!this.toolbar.AppendBefore(action,'showVdm') && !this.toolbar.AppendBefore(action,'expandreduce') && !this.toolbar.AppendBefore(action,'query') && !this.toolbar.AppendBefore(action,'print') && !this.toolbar.AppendBefore(action,'refresh'))\n            this.toolbar.Append(action);\n        }\n        else if (!this.toolbar.AppendBefore(action,'expandreduce') && !this.toolbar.AppendBefore(action,'print') && !this.toolbar.AppendBefore(action,'query') && !this.toolbar.AppendBefore(action,'refresh') && !this.toolbar.AppendBefore(action,'showVdm')) \u002f\u002f il bottone dei filtri ? nel menu\n          this.toolbar.Append(action);\n      }\n      else this.toolbar.AppendMenuItem(action);\n    }\n  }\n  this.RenderLinkedConfs();\n}\nfunction SetActions(actions) {\n  if (actions && actions.length\u003e0) {\n    l_actions = actions;\n  } else {\n    l_actions = null;\n  }\n}\nvar el = '\u003c%=sp.translate(\"MSG_FORM_FUNCTION_LIST\")%\u003e'\nvar cpt;\nfunction SetCaption(newCaption) {\n  cpt = newCaption;\n  this._setCpt((!this.Tabs.isEmpty() ? '' : cpt));\n}\nfunction _setCpt(newCaption) {\n  var lbl = ( ZoomObj ? ZoomObj.GetVersionsLabel() : \"\" );\n  this.caption_label.Value( \"\u003cspan class='SubtitleLabel'\u003e\" + el + \"\u003c\u002fspan\u003e \" + newCaption );\n  if( lbl ){\n  \tthis.caption_label.Ctrltbl.appendChild(lbl);\n  }\n}\nthis.SetCaption(this.Caption.Value());\nfunction SetLinkedConfs(linkedConfs) {\n  for (var i=0;this.struct_linkedConfs && i\u003cthis.struct_linkedConfs.length;i++) {\n  \tthis.toolbar.Remove('linkedConf'+i);\n  }\n\tthis.struct_linkedConfs = linkedConfs||[];\n  if (ZoomObj) {\n  \tthis.RenderLinkedConfs();\n  }\n}\nfunction Tabs_Click(name) {\n  if (!Eq(ZoomObj.ConfigName.Value(),name) ) { \u002f\u002fcambio configurazione solo se diversa\n  \tZoomObj.LinkedConfiguration(name,true);\n  }\n}\nfunction RenderLinkedConfs() {\n  var img, sep='';\n  var idx=this.toolbar.IsInToolbar('new')||this.toolbar.IsInMenu('new')?1:0;\n  var tabstrips = [];\n\tfor (var i=0;i\u003cthis.struct_linkedConfs.length;i++) {\n    if (this.struct_linkedConfs[i].imagetype=='card') {\n      img = GetStyleVariable(\"card_image\", \"..\u002f\"+skin+\"\u002fimages\u002fzoom\u002flinkedConf_card.png\")\n    } else if (this.struct_linkedConfs[i].imagetype=='chart') {\n      img = GetStyleVariable(\"chart_image\", \"..\u002f\"+skin+\"\u002fimages\u002fzoom\u002flinkedConf_chart.png\");\n    } else {\n      img = GetStyleVariable(\"grid_image\", \"..\u002f\"+skin+\"\u002fimages\u002fzoom\u002flinkedConf_grid.png\");\n    }\n    if (this.struct_linkedConfs[i].ontabs=='true') {\n      tabstrips.push(this.struct_linkedConfs[i]);\n    } else {\n      this.toolbar.Append({\n        id: 'linkedConf'+i,\n        title: this.struct_linkedConfs[i].title_trad || this.struct_linkedConfs[i].title,\n        action: (function(ii) { return function() { _this.ChangeConfiguration(ii) }; })(i),\n        tooltip: this.struct_linkedConfs[i].title_trad || this.struct_linkedConfs[i].title, \n        image: this.struct_linkedConfs[i].imagetoolbar||img\n      },idx++);\n    }\n  }\n  if (tabstrips.length\u003e0) {\n    this._setCpt('');\n    \u002f\u002fignoro eventuali versione della stessa configurazione\n    var cfgname = ZoomObj.ConfigName.Value();\n    if (Empty(cfgname)) {\n      cfgname = \"default\";\n    }\n    var idx = cfgname.indexOf('__');\n    if (idx\u003e-1) {\n      cfgname = cfgname.substring(0,idx);\n    }\n    if (!this.Tabs.Exists(cfgname) ) {\n      this.Tabs.AddTab({name: cfgname, caption: cpt});\n      this.Tabs.Select(cfgname);\n    }\n    for (var i=0;i\u003ctabstrips.length;i++) {\n      cfgname = tabstrips[i].configname;\n      if (Empty(cfgname)) {\n        cfgname = \"default\";\n      }\n      var idx = cfgname.indexOf('__');\n      if (idx\u003e-1) {\n        cfgname = cfgname.substring(0,idx);\n      }\n      if (!this.Tabs.Exists(cfgname) ) {\n        this.Tabs.AddTab({name: cfgname, caption: tabstrips[i].title});\n      }\n    }\n    this.Tabs.Show();\n  } else {\n    this.Tabs.Hide();\n  }\n  this.queueAdjustHeight(50);\n}\nfunction ChangeConfiguration(i) {\n  ZoomObj.LinkedConfiguration(this.struct_linkedConfs[i].configname,true);\n}\n\nfunction updateFilterButton(){\n  this.toolbar.UpdateItem('showVdm', {\n    image:{ fontFamily:'icons8_win10', value: \"&#xefaf\", size: \"20px\"}\n\t})\n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"ZoomTitle","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"62","hsl":"","htmlcode":"{{ caption_label }}\n{{ Autozoom }}\n{{ Caption }}\n{{ toolbar }}\n{{ loadFontIcon }}\n{{ Tabs }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"900","layout_steps_values":"{\"600\":{\"h\":\"62\",\"w\":\"100%\"},\"900\":{\"h\":\"62\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":".\u002fgrammars\u002flib\u002fPorterStemmerIt.es5.js,.\u002fgrammars\u002flib\u002frailroadgrammar.es5.js,.\u002fgrammars\u002flib\u002fparse_functions.js,.\u002fgrammars\u002fbase.js,.\u002fgrammars\u002fzoom.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"600,900","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"900","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"600\":{\"x\":20,\"y\":15,\"w\":\"276\",\"h\":30,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"hide\":\"\",\"align\":\"\"},\"900\":{\"x\":20,\"y\":15,\"w\":483,\"h\":30,\"anchor\":\"top-left-right(%)\",\"n_col\":\"1\",\"fontpct\":\"\",\"align\":\"left\",\"hide\":\"false\"}}","n_col":"1","name":"caption_label","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Caption","w":"483","wireframe_props":"align,value,n_col","x":"20","y":"15","zindex":"3"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Autozoom","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"4","y":"72"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Caption","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"4","y":"96"},{"FAB":"","anchor":"top-left(%)-right","bg_color":"","css_class":"zoom_title_toolbar","h":"40","hide":"false","iconWidth":"30","layer":"false","layout_steps_values":"{\"600\":{\"x\":307,\"y\":10,\"w\":\"292\",\"h\":40,\"anchor\":\"top-right\",\"hide\":\"\"},\"900\":{\"x\":507,\"y\":10,\"w\":393,\"h\":40,\"anchor\":\"top-left(%)-right\",\"hide\":\"false\"}}","maxToolbarItem":"","menu_bg_color":"","name":"toolbar","page":"1","sequence":"4","toolbarAlign":"","type":"SPToolbar","w":"393","wireframe_props":"","x":"507","y":"10","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"52","help_tips":"","hide":"true","hide_undercond":"true","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"600\":{\"x\":757,\"y\":50,\"w\":\"52\",\"h\":52,\"anchor\":\"\",\"hide\":\"\",\"font_size\":\"\"},\"900\":{\"x\":682,\"y\":109,\"w\":\"52\",\"h\":52,\"anchor\":\"\",\"hide\":\"true\",\"font_size\":\"\"}}","name":"loadFontIcon","page":"1","path_type":"","sequence":"5","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"52","wireframe_props":"","x":"682","y":"109","zindex":"4"},{"anchor":"top-left-right","bg_color":"","cell_distr":"","class_Css":"ZoomTabstrip","class_Css_selected":"","font":"","font_color":"","font_size":"","font_weight":"","h":"1","hide":"true","href":"","layer":"false","layout_steps_values":"{\"600\":{\"x\":0,\"y\":0,\"w\":\"600\",\"h\":1,\"anchor\":\"top-left-right\",\"hide\":\"true\"},\"900\":{\"x\":0,\"y\":0,\"w\":900,\"h\":1,\"anchor\":\"top-left-right\",\"hide\":\"true\"}}","links":"","name":"Tabs","page":"1","selected_color":"","selected_item":"","sequence":"6","shrinkable":"true","sp_tabstrip":"true","target":"","type":"Tabs","vertical":"false","vertical_text":"false","w":"900","wireframe_props":"","x":"0","y":"0","zindex":"1"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:Autozoom,Caption*/%>
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
.default_zoom_title_container {
}
.default_zoom_title_portlet{
  position:relative;
  width:100%;
  min-width:600px;
  height:62px;
}
.default_zoom_title_portlet[Data-page="1"]{
  height:62px;
  width:100%;
}
.default_zoom_title_portlet[Data-step="600"] {
  height:62px;
  width:100%;
}
.default_zoom_title_portlet[Data-step="900"] {
  height:62px;
  width:100%;
}
.default_zoom_title_portlet[Data-step="600"] > .caption_label_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:15px;
  left:20px;
  right:304px;
  width:auto;
  height:auto;
  min-height:30px;
}.default_zoom_title_portlet[Data-step="600"] > .caption_label_ctrl {
  height:auto;
  min-height:30px;
}
.default_zoom_title_portlet[Data-step="900"] > .caption_label_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:15px;
  left:20px;
  right:397px;
  right:44.11111%;
  width:auto;
  height:auto;
  min-height:30px;
}.default_zoom_title_portlet[Data-step="900"] > .caption_label_ctrl {
  height:auto;
  min-height:30px;
}
.default_zoom_title_portlet > .caption_label_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.default_zoom_title_portlet[Data-step="600"] > .caption_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_zoom_title_portlet[Data-step="900"] > .caption_label_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_zoom_title_portlet[Data-step="600"] > .toolbar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:1px;
  width:292px;
  height:40px;
}
.default_zoom_title_portlet[Data-step="900"] > .toolbar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:507px;
  left:56.333332%;
  right:0px;
  width:auto;
  height:40px;
}
.default_zoom_title_portlet[Data-step="600"] > .loadFontIcon_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:50px;
  left:757px;
  width:52px;
  height:52px;
}
.default_zoom_title_portlet[Data-step="900"] > .loadFontIcon_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:109px;
  left:682px;
  width:52px;
  height:52px;
  display:none;
}
.default_zoom_title_portlet > .loadFontIcon_ctrl {
  display:none;
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:52px;
  font-size:52px;
}
.default_zoom_title_portlet[Data-step="600"] > .loadFontIcon_ctrl {
  line-height:52px;
  font-size:52px;
}
.default_zoom_title_portlet[Data-step="900"] > .loadFontIcon_ctrl {
  line-height:52px;
  font-size:52px;
}
.default_zoom_title_portlet[Data-step="600"] > .Tabs_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:1px;
  display:none;
}
.default_zoom_title_portlet[Data-step="900"] > .Tabs_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:1px;
  display:none;
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
 String def="[{\"h\":\"62\",\"layout_steps_values\":{\"600\":{\"h\":\"62\",\"w\":\"100%\"},\"900\":{\"h\":\"62\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"600,900\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"900\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"30\",\"layout_steps_values\":{\"600\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":30,\"hide\":\"\",\"n_col\":\"1\",\"w\":\"276\",\"x\":20,\"y\":15},\"900\":{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"fontpct\":\"\",\"h\":30,\"hide\":\"false\",\"n_col\":\"1\",\"w\":483,\"x\":20,\"y\":15}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Caption\",\"w\":\"483\",\"x\":\"20\",\"y\":\"15\",\"zindex\":\"3\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"4\",\"y\":\"72\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"4\",\"y\":\"96\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"40\",\"layout_steps_values\":{\"600\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"\",\"w\":\"292\",\"x\":307,\"y\":10},\"900\":{\"anchor\":\"top-left(%)-right\",\"h\":40,\"hide\":\"false\",\"w\":393,\"x\":507,\"y\":10}},\"page\":\"1\",\"type\":\"SPToolbar\",\"w\":\"393\",\"x\":\"507\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"52\",\"layout_steps_values\":{\"600\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":52,\"hide\":\"\",\"w\":\"52\",\"x\":757,\"y\":50},\"900\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":52,\"hide\":\"true\",\"w\":\"52\",\"x\":682,\"y\":109}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"52\",\"x\":\"682\",\"y\":\"109\",\"zindex\":\"4\"},{\"anchor\":\"top-left-right\",\"h\":\"1\",\"layout_steps_values\":{\"600\":{\"anchor\":\"top-left-right\",\"h\":1,\"hide\":\"true\",\"w\":\"600\",\"x\":0,\"y\":0},\"900\":{\"anchor\":\"top-left-right\",\"h\":1,\"hide\":\"true\",\"w\":900,\"x\":0,\"y\":0}},\"page\":\"1\",\"type\":\"Tabs\",\"w\":\"900\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"default_zoom_title","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default_zoom_title_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.default_zoom_title_portlet > .loadFontIcon_ctrl {
  display:none;
}
.default_zoom_title_portlet > .Tabs_ctrl {
  display:none;
}

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/lib/PorterStemmerIt.es5.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/lib/railroadgrammar.es5.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/lib/parse_functions.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/base.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/zoom.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','default_zoom_title','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String caption_label= "Caption";
String Autozoom=JSPLib.translateXSS(sp.getParameter("Autozoom",""));
String Caption=JSPLib.translateXSS(sp.getParameter("Caption",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='default_zoom_title_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='default_zoom_title_portlet ZoomTitle' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('default_zoom_title','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_caption_label'  formid='<%=idPortlet%>' ps-name='caption_label'    class='TitleLabel caption_label_ctrl'><div id='<%=idPortlet%>_caption_labeltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Caption"))%></div></span>
<div id='<%=idPortlet%>_toolbar' class='disable-selection ctrl_zoom_title_toolbar_container zoom_title_toolbar' >
<div id='<%=idPortlet%>_toolbar_openMenuHandlerDiv' class='zoom_title_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbar_openMenuHandlerImg' class='zoom_title_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbar_listButtons' class='zoom_title_toolbar_listButtons'></div>
</div>
<a id='<%=idPortlet%>_loadFontIcon' class='image loadFontIcon_ctrl'   target=''></a>
<div id='<%=idPortlet%>_Tabs' class='Tabs_ctrl'></div>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>'></script>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','default_zoom_title');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FILTERS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FILTERS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_NEW",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_NEW"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_QUERY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_QUERY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_REFRESH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_REFRESH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_REDUCE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_REDUCE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_PRINT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','default_zoom_title',["900"],["62"],'ZoomTitle',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'600,900', '','','',{"600":{"h":"62","w":"100%"},"900":{"h":"62","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"600":{"w":"100%","h":"62"},"900":{"w":"100%","h":"62"}},"w":"900","h":"62","title":"","layer":"false","npage":"1"}]);
this.caption_label=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_caption_label","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"600":{"align":"","anchor":"top-left-right","fontpct":"","h":30,"hide":"","n_col":"1","w":"276","x":20,"y":15},"900":{"align":"left","anchor":"top-left-right(%)","fontpct":"","h":30,"hide":"false","n_col":"1","w":483,"x":20,"y":15}},"n_col":1,"name":"caption_label","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(caption_label),false,true)%>","type":"Label","w":483,"x":20,"y":15,"zindex":"3"});
this.Autozoom=new ZtVWeb._VC(this,'Autozoom',null,'character','<%=JSPLib.ToJSValue(Autozoom,false,true)%>',false,false);
this.Caption=new ZtVWeb._VC(this,'Caption',null,'character','<%=JSPLib.ToJSValue(Caption,false,true)%>',false,false);
this.toolbar=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-left(%)-right","bg_color":"","cssClass":"zoom_title_toolbar","ctrlid":"<%=idPortlet%>_toolbar","h":40,"hide":"false","iconWidth":30,"layer":false,"layout_steps_values":{"600":{"anchor":"top-right","h":40,"hide":"","w":"292","x":307,"y":10},"900":{"anchor":"top-left(%)-right","h":40,"hide":"false","w":393,"x":507,"y":10}},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbar","page":1,"toolbarAlign":"","type":"SPToolbar","w":393,"x":507,"y":10,"zindex":"1"});
this.loadFontIcon=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image loadFontIcon_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_loadFontIcon","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":52,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"true","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"600":{"anchor":"","font_size":"","h":52,"hide":"","w":"52","x":757,"y":50},"900":{"anchor":"","font_size":"","h":52,"hide":"true","w":"52","x":682,"y":109}},"name":"loadFontIcon","page":1,"path_type":"","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":52,"x":682,"y":109,"zindex":"4"});
 ZtVWeb.RequireFont("icons8_win10","");
this.Tabs=new ZtVWeb.TabStripControl(this,{"anchor":"top-left-right","bg_color":"","cell_distr":"","class_Css":"ZoomTabstrip","class_Css_selected":"","ctrlid":"<%=idPortlet%>_Tabs","font":"","font_color":"","font_size":"","font_weight":"","h":1,"hide":"true","href":"","layer":false,"layout_steps_values":{"600":{"anchor":"top-left-right","h":1,"hide":"true","w":"600","x":0,"y":0},"900":{"anchor":"top-left-right","h":1,"hide":"true","w":900,"x":0,"y":0}},"name":"Tabs","page":1,"selected_color":"","selected_item":"","shrinkable":"true","sp_tabstrip":true,"target":"","type":"Tabs","vertical":"false","vertical_text":"false","w":900,"x":0,"y":0,"zindex":"1"});
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
<%request.setAttribute("default_zoom_title_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.default_zoom_title_Static=function(){
if(typeof InitGrammar !='undefined')this.InitGrammar=InitGrammar;
if(typeof SubmitListenerForm !='undefined')this.SubmitListenerForm=SubmitListenerForm;
if(typeof SetButtons !='undefined')this.SetButtons=SetButtons;
if(typeof SetActions !='undefined')this.SetActions=SetActions;
if(typeof SetCaption !='undefined')this.SetCaption=SetCaption;
if(typeof _setCpt !='undefined')this._setCpt=_setCpt;
if(typeof SetLinkedConfs !='undefined')this.SetLinkedConfs=SetLinkedConfs;
if(typeof Tabs_Click !='undefined')this.Tabs_Click=Tabs_Click;
if(typeof RenderLinkedConfs !='undefined')this.RenderLinkedConfs=RenderLinkedConfs;
if(typeof ChangeConfiguration !='undefined')this.ChangeConfiguration=ChangeConfiguration;
if(typeof updateFilterButton !='undefined')this.updateFilterButton=updateFilterButton;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.loadFontIcon);
}
this.struct_linkedConfs=[];
var ZoomObj = null;
var skin = '<%=sp.getSkin()%>';
var _this = this;
var l_actions;
function InitGrammar() {
  if (!parent.SpeechGrammar) {
    // non e' disponibile la libreria SpeechGrammar
		return false;
  }
  SpeechGrammar = parent.SpeechGrammar;
  
  var config = ZoomObj.vzmstructure.Configuration;
  var zoomName = config.Autozoom ? config.Autozoom : config.vqrname;
  var zoomDescription = config.description ? config.description : zoomName;
  var terminiObj = {
    cols: {}, campo: [], campo_V: [], campo_T: [], soggetto: [zoomDescription], soggetto_V: [zoomName]
  };
  var cols = ZoomObj.vzmstructure.Cols;
  for (var i = 0; i < cols.length; i++) {
    var synonyms = cols[i].synonyms ? cols[i].synonyms.split(',') : [];
    terminiObj.cols[cols[i].field] = {title: cols[i].title_trad, type: cols[i].type};
    if(synonyms.length == 0) {
        terminiObj.campo.push(cols[i].title_trad);
        terminiObj.campo_V.push(cols[i].field);
        terminiObj.campo_T.push(cols[i].type); 
    } else {
      for (var j = 0; j < synonyms.length; j++) {
        terminiObj.campo.push(synonyms[j]);
        terminiObj.campo_V.push(cols[i].field);
        terminiObj.campo_T.push(cols[i].type);
      }
    }
  }
  terminiObj.defaultFld = {};
  
  SpeechGrammar.populateColsName(terminiObj, ZoomGrammar.getMinorGrammar());
	SpeechGrammar.populateColsName(terminiObj, ZoomGrammar.getMainGrammar());
  var grammarConfig = {};
  grammarConfig.containerName = window.frameElement.name;
  grammarConfig.modal = window.frameElement ? window.frameElement.getAttribute("modallayer") : false;
  grammarConfig.type = 'zoom';
  grammarConfig.grammar = ZoomGrammar;
  grammarConfig.ZoomObj = ZoomObj;
  grammarConfig.termini = terminiObj;
  grammarConfig.fileName = zoomName + '__' + grammarConfig.type;
  SpeechGrammar.addGrammarConfig(grammarConfig);
  parent.LoadConfiguration(grammarConfig.fileName);
}
function SubmitListenerForm(elem){
  switch(elem){
    case "new":
      ZoomObj.AddNewRecord()
      break;
    case "query":
      window.location = "../servlet/"+ZoomObj.Autozoom.Value();
      break;
    case "refresh":
      ZoomObj.refreshQuery();
      break;
    case "print":
      ZoomObj.printZoom();
      break;
    case "expandreduce":
      var wasextended = ZoomObj.Grid.IsExtended();
      ZoomObj.Grid.ExpandOReduce();
      this.toolbar.UpdateItem('expandreduce', {
        	title: wasextended ? FormatMsg('MSG_EXPAND') : FormatMsg('MSG_REDUCE'),
        	image:{ fontFamily:'icons8_win10', value: wasextended ? "&#xee18" : "&#xefd2", size: "20px"}
     	});
      break;
    case "showVdm":
      ZoomObj.ShowVdmMask();
      break;
  }
}
function SetButtons(id,configElements,canAdd){
  ZoomObj=ZtVWeb.getPortletById(id);
  InitGrammar();
  if(configElements.indexOf("-n")==-1 && canAdd){
    this.toolbar.Append({
      id:'new',
      title: FormatMsg('MSG_FORM_FUNCTION_NEW'),
      action: function(){ _this.SubmitListenerForm('new');},
      image:{ fontFamily:'icons8_win10', value: "&#xebed", size: "19px"}
    });
  } else {
    this.toolbar.Remove('new');
  }
	if ((ZoomObj.vzmstructure.Configuration.filters!="false" || !Empty(ZoomObj.vdmName)) && ZoomObj.vzmstructure.Configuration.hideFiltersBtn!="true"){
  	var vdmAct={
    	id:'showVdm',
    	title:FormatMsg('MSG_FILTERS'),
    	image:{fontFamily:'icons8_win10', value: "&#xee44", size: "20px"},
    	action:function(){ _this.SubmitListenerForm('showVdm')}
  	}
    if (!Empty(ZoomObj.vdmName))
    	this.toolbar.Append(vdmAct);
    else
      this.toolbar.AppendMenuItem(vdmAct);
  }
  else 
    this.toolbar.Remove('showVdm');
  if(ZoomObj.Grid.extensible=='false' || EmptyArray(ZoomObj.Grid.extFields)){
    //nascosti
    this.toolbar.Remove('expandreduce');
  }else{
    var isextended = ZoomObj.Grid.IsExtended();
    if (this.toolbar.IsInToolbar('expandreduce') || this.toolbar.IsInMenu('expandreduce'))
      this.toolbar.UpdateItem('expandreduce', {
        	title: isextended ? FormatMsg('MSG_REDUCE') : FormatMsg('MSG_EXPAND'),
        	image:{ fontFamily:'icons8_win10', value: isextended ?  "&#xefd2" : "&#xee18", size: "20px"}
     	});
    else {
      var act={
        id:'expandreduce',
        title: isextended ? FormatMsg('MSG_REDUCE') : FormatMsg('MSG_EXPAND'),
        action:function(){ _this.SubmitListenerForm('expandreduce')},
        image:{ fontFamily:'icons8_win10', value: isextended ?  "&#xefd2" : "&#xee18", size: "20px"}
      }
      if (!Empty(ZoomObj.vdmName)){
        if (!this.toolbar.AppendAfter(act,'showVdm') && !this.toolbar.AppendBefore(act,'print')  && !this.toolbar.AppendBefore(act,'query') && !this.toolbar.AppendBefore(act,'refresh'))
          this.toolbar.Append(act);
      }
      else { // bottone di showVdm nel menu
        if (!this.toolbar.AppendBefore(act,'print') && !this.toolbar.AppendBefore(act,'query') && !this.toolbar.AppendBefore(act,'refresh') && !this.toolbar.AppendBefore(act,'showVdm'))
          this.toolbar.Append(act);
      }
    }
  }
  if(configElements.indexOf("-p")==-1 && ZoomObj.vzmstructure.Configuration.PrintMode!='None'){
    this.toolbar.Append({
      id:'print',
      title: FormatMsg('MSG_VZM_PRINT'),
      action:function(){ _this.SubmitListenerForm('print')},
      image:{ fontFamily:'icons8_win10', value: "&#xec0b", size: "20px"}
    });
  } else {
    this.toolbar.Remove('print');
  }
  if (ZoomObj.vzmstructure.Configuration.LinkQuery!='false' && 
      !EmptyString(ZoomObj.Autozoom.Value()) && !EmptyString(ZoomObj.PKFields.Value()) && 
      ((ZoomObj.m_cAction && ZoomObj.m_cAction.Value()=="autozoom") || ZoomObj.vzmstructure.Configuration.LinkQuery=='force')){
      this.toolbar.Append({
        id:'query',
        title: FormatMsg('MSG_FORM_FUNCTION_QUERY'),
        action:function(){ _this.SubmitListenerForm('query')},
        image:{ fontFamily:'icons8_win10', value: "&#xe950", size: "20px"}
      });
    this.Autozoom.Value(ZoomObj.Grid.autozoom)
    ZoomObj.Grid.autozoom="";
	}
	
  
  this.toolbar.Append({
    id:'refresh',
    title: FormatMsg('MSG_FORM_FUNCTION_REFRESH'),
    action:function(){ _this.SubmitListenerForm('refresh')},
    image:{ fontFamily:'icons8_win10', value: "&#xec4d", size: "20px"}
  });
  
  var ii = 0;
  while( this.toolbar.Remove( 'action' + ii ) ) {
    ii++;
  }
  if (l_actions) {
    for (ii=0; ii<l_actions.length; ii++) {
      var action={
        id:'action'+ii,
        title:  l_actions[ii].title_trad || l_actions[ii].title,
        image: l_actions[ii].image_settings=='fontIcon'?{
              fontFamily:l_actions[ii].font_name,
              size:l_actions[ii].font_size,
              value:l_actions[ii].font_image,
              color:l_actions[ii].font_color
            }:l_actions[ii].image,
        action: (function(_action) { return function() { ZoomObj.ExecAction(_action) }; })(l_actions[ii]),
        tooltip: l_actions[ii].tooltip || l_actions[ii].title_trad || l_actions[ii].title,
        target:l_actions[ii].target
      }
      if (CharToBool(l_actions[ii].important)){
        if (!Empty(ZoomObj.vdmName)){ // il bottone dei filtri ? nella toolbar prima del bottone di espandi riduci
          if (!this.toolbar.AppendBefore(action,'showVdm') && !this.toolbar.AppendBefore(action,'expandreduce') && !this.toolbar.AppendBefore(action,'query') && !this.toolbar.AppendBefore(action,'print') && !this.toolbar.AppendBefore(action,'refresh'))
            this.toolbar.Append(action);
        }
        else if (!this.toolbar.AppendBefore(action,'expandreduce') && !this.toolbar.AppendBefore(action,'print') && !this.toolbar.AppendBefore(action,'query') && !this.toolbar.AppendBefore(action,'refresh') && !this.toolbar.AppendBefore(action,'showVdm')) // il bottone dei filtri ? nel menu
          this.toolbar.Append(action);
      }
      else this.toolbar.AppendMenuItem(action);
    }
  }
  this.RenderLinkedConfs();
}
function SetActions(actions) {
  if (actions && actions.length>0) {
    l_actions = actions;
  } else {
    l_actions = null;
  }
}
var el = '<%=sp.translate("MSG_FORM_FUNCTION_LIST")%>'
var cpt;
function SetCaption(newCaption) {
  cpt = newCaption;
  this._setCpt((!this.Tabs.isEmpty() ? '' : cpt));
}
function _setCpt(newCaption) {
  var lbl = ( ZoomObj ? ZoomObj.GetVersionsLabel() : "" );
  this.caption_label.Value( "<span class='SubtitleLabel'>" + el + "</span> " + newCaption );
  if( lbl ){
  	this.caption_label.Ctrltbl.appendChild(lbl);
  }
}
this.SetCaption(this.Caption.Value());
function SetLinkedConfs(linkedConfs) {
  for (var i=0;this.struct_linkedConfs && i<this.struct_linkedConfs.length;i++) {
  	this.toolbar.Remove('linkedConf'+i);
  }
	this.struct_linkedConfs = linkedConfs||[];
  if (ZoomObj) {
  	this.RenderLinkedConfs();
  }
}
function Tabs_Click(name) {
  if (!Eq(ZoomObj.ConfigName.Value(),name) ) { //cambio configurazione solo se diversa
  	ZoomObj.LinkedConfiguration(name,true);
  }
}
function RenderLinkedConfs() {
  var img, sep='';
  var idx=this.toolbar.IsInToolbar('new')||this.toolbar.IsInMenu('new')?1:0;
  var tabstrips = [];
	for (var i=0;i<this.struct_linkedConfs.length;i++) {
    if (this.struct_linkedConfs[i].imagetype=='card') {
      img = GetStyleVariable("card_image", "../"+skin+"/images/zoom/linkedConf_card.png")
    } else if (this.struct_linkedConfs[i].imagetype=='chart') {
      img = GetStyleVariable("chart_image", "../"+skin+"/images/zoom/linkedConf_chart.png");
    } else {
      img = GetStyleVariable("grid_image", "../"+skin+"/images/zoom/linkedConf_grid.png");
    }
    if (this.struct_linkedConfs[i].ontabs=='true') {
      tabstrips.push(this.struct_linkedConfs[i]);
    } else {
      this.toolbar.Append({
        id: 'linkedConf'+i,
        title: this.struct_linkedConfs[i].title_trad || this.struct_linkedConfs[i].title,
        action: (function(ii) { return function() { _this.ChangeConfiguration(ii) }; })(i),
        tooltip: this.struct_linkedConfs[i].title_trad || this.struct_linkedConfs[i].title, 
        image: this.struct_linkedConfs[i].imagetoolbar||img
      },idx++);
    }
  }
  if (tabstrips.length>0) {
    this._setCpt('');
    //ignoro eventuali versione della stessa configurazione
    var cfgname = ZoomObj.ConfigName.Value();
    if (Empty(cfgname)) {
      cfgname = "default";
    }
    var idx = cfgname.indexOf('__');
    if (idx>-1) {
      cfgname = cfgname.substring(0,idx);
    }
    if (!this.Tabs.Exists(cfgname) ) {
      this.Tabs.AddTab({name: cfgname, caption: cpt});
      this.Tabs.Select(cfgname);
    }
    for (var i=0;i<tabstrips.length;i++) {
      cfgname = tabstrips[i].configname;
      if (Empty(cfgname)) {
        cfgname = "default";
      }
      var idx = cfgname.indexOf('__');
      if (idx>-1) {
        cfgname = cfgname.substring(0,idx);
      }
      if (!this.Tabs.Exists(cfgname) ) {
        this.Tabs.AddTab({name: cfgname, caption: tabstrips[i].title});
      }
    }
    this.Tabs.Show();
  } else {
    this.Tabs.Hide();
  }
  this.queueAdjustHeight(50);
}
function ChangeConfiguration(i) {
  ZoomObj.LinkedConfiguration(this.struct_linkedConfs[i].configname,true);
}
function updateFilterButton(){
  this.toolbar.UpdateItem('showVdm', {
    image:{ fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"}
	})
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.default_zoom_title_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.loadFontIcon.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','default_zoom_title',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'default_zoom_title');
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
sp.endPage("default_zoom_title");
}%>
<%! public String getJSPUID() { return "4232632762"; } %>