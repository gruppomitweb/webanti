<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.Var=function(val){\n  this.val=val;\n  this.Value=function(val){\n    if(arguments.length) this.val=val;\n    return this.val;\n  }\n}\n\nvar opener = GetOpener();\nif(!opener) return;\nif(!opener.columnsObj) return;\nif(!opener.rowsObj) return;\nif(!opener.measuresObj) return;\nif(!opener.filtersObj) return;\n\nvar jscolumns = JSON.parse(JSON.stringify(opener.columnsObj));\nvar jsrows = JSON.parse(JSON.stringify(opener.rowsObj));\nvar jsmeasures = JSON.parse(JSON.stringify(opener.measuresObj));\nvar jsfilters = JSON.parse(JSON.stringify(opener.filtersObj));\nthis.TDatasource.Value(opener.formProp.query)\nthis.VVdmFile.Value(opener.formProp.vdmfile)\n\nvar pObj = {};\n  pObj.columnfields = [];\n  pObj.columnkeys = [];\n  pObj.rowfields = [];\n  pObj.rowkeys = [];\n  pObj.measurefields = [];\n\nvar i, j, t, ti;\nfor( i=0; i\u003cjscolumns.length; i++) {\n   pObj.columnfields.push(jscolumns[i].field)\n   pObj.columnkeys.push(jscolumns[i].keys)\n}\nfor( i=0; i\u003cjsrows.length; i++) {\n   pObj.rowfields.push(jsrows[i].field)\n   pObj.rowkeys.push(jsrows[i].keys)\n}\nfor( i=0; i\u003cjsmeasures.length; i++) {\n   pObj.measurefields.push(jsmeasures[i].field)\n}\nfor( i=0; i\u003cjsfilters.length; i++) {\n   jsfilters[i].visible = true;\n   jsfilters[i].queryparm = '';\n}\n\nvar jslist = [];\nfor( i=0; i\u003cjsrows.length; i++) {\n  for( j=0; j\u003cjscolumns.length; j++) {\n    var o = {};\n    o.row = i;\n    o.column = j;\n    jslist.push(o);\n  }\n}\n\nthis.StaticDataList.FillData(jslist)\n\nvar rcvSuffix=\"\",\n    rcvName='parametersList';\n\nvar filters = [];\n\nfunction crumbObj (evt, ignoreFilterMap) {\n    var res = [],\n      p_exp,\n      p_op, op_suff = '_op', def_op = '=',\n      p_type, type_suff = '_type', def_type = 'C',\n      p_fixed, fixed_suff = '_fixed',\n      p_queryP, queryP_suff = '_queryParm',\n      p_visible, visible_suff = '_visible',\n      p_userFilter, userFilter_suff = '_userFilter',\n      p_defaultFilter, defaultFilter_suff = '_defaultFilter';\n      if(!evt) return [];\n    for (var p in evt) {\n      if (!evt.hasOwnProperty(p)) {\n        continue;\n      }\n      if (evt[p] != null && IsA(evt[p], 'O') && !IsA(evt[p], 'D')) {\n        res = res.concat(crumbObj(evt[p], ignoreFilterMap));\n        continue;\n      }\n      if ((p.match(op_suff + '$') && RTrim(p, op_suff) in evt) ||\n        (p.match(type_suff + '$') && RTrim(p, type_suff) in evt) ||\n        (Empty(evt[p]) && (p + op_suff) in evt) \n        \u002f*&& (_dataobj.Fields_map && (p.toLowerCase() in _dataobj.Fields_map)) ||\n        (filter_map && !(p in filter_map) && !ignoreFilterMap) ||\n        p == \"srcPortletId\"*\u002f\n      ) continue;\n      p_op = EmptyString(evt[p + op_suff]) ? def_op : evt[p + op_suff];\u002f\u002foperatore\n      p_type = EmptyString(evt[p + type_suff]) ? def_type : evt[p + type_suff];\u002f\u002ftipo\n      p_fixed = evt[p + fixed_suff] || false;\u002f\u002ffisso\n      p_queryP = evt[p + queryP_suff] || \"\";\n      p_visible = evt[p + visible_suff] || false;\u002f\u002fvisible\n      p_userFilter = evt[p + userFilter_suff] || false;\u002f\u002ffiltro da moschina\n      p_defaultFilter = evt[p + defaultFilter_suff] || false;\u002f\u002ffiltro da moschina\n      p_exp = evt[p];\n      \u002f*if (filter_map && !ignoreFilterMap) {\n        p = filter_map[p];\n      }*\u002f\n      res.push(\n        {\n          field: p,\n          operator: p_op,\n          expression: p_exp,\n          type: p_type,\n          fixed: p_fixed,\n          queryparm: p_queryP,\n          visible: p_visible,\n          userFilter: p_userFilter,\n          defaultFilter: p_defaultFilter\n        });\n    }\n    return res;\n}\n\nfunction penPusher(parmsObj) { \u002f\u002ffunzione passacarte per receiver di filtro\n  this.$entity$_zoomSetFilter.receiveFnc(parmsObj);\n}\nfor(var i=0,rcvs=rcvName.split(','),l=rcvs.length; i\u003cl; i++){\u002f\u002freceivername multiplo\n  rcvName=rcvs[i];\n  this['on_'+rcvName+rcvSuffix]=penPusher;\u002f\u002fimpostato per l'utente\n}\n\nthis.$entity$_updateFilters.name = this.$entity$_updateFilters.name.replace('$entity$', rcvName);\nthis.$entity$_GetConfigurationField.name = this.$entity$_GetConfigurationField.name.replace('$entity$', rcvName);\n\nfunction SetFilters(evt, opts) {\n  filters = crumbObj(evt.row);\n}\n\nfunction GetFilters() {\n  if(Empty(filters))\n  \treturn jsfilters;\n  var ret = [];\n  var i, f;\n  for( i=0; i\u003cfilters.length; i++ ) {\n    f = filters[i];\n    if( f.visible && Empty(f.queryparm))\n      ret.push(f);\n  }\n  return ret;\n}\n\nfunction GetConfigurationField() {\n  function setFieldInObj(fieldObj, obj) {\n      if (!obj[fieldObj.field])\n          obj[fieldObj.field] = {\n          title: fieldObj.title,\n          type: fieldObj.f_type||'C',\n          hidden: false\n        }\n    }\n  \tvar obj = {},\n    i;\n    for (i = 0; i \u003c jscolumns.length; i++) {\n      setFieldInObj(jscolumns[i], obj)\n    }\n    for (i = 0; i \u003c jsrows.length; i++) {\n      setFieldInObj(jsrows[i], obj)\n    }\n    return obj;\n}\n\nfunction BParameters_Click(){\n  var p = ZtVWeb.getPortletWindow('SPMaskParameters');\n  var url=\"..\u002fjsp\u002fSPMaskParameters_portlet.jsp?\";\n  if (!Empty(this.VVdmFile.Value()))\n    url+= \"ConfigName=\"+URLenc(this.VVdmFile.Value());\n  else\n    url += \"hideEditToolbar=true&QueryName=\"+URLenc(this.TDatasource.Value())+\"&presetParams=\"+\"&hideQueryParameters=false\"+\"&disablePresetParams=false\";\n  url= url + \"&TitleMsg=MSG_SEARCH_FILTERS&offlineMode=false&zoomMode=true&hideAddFilterButton=false&EmitterName=\"+rcvName+\"&ReceiverName=\"+rcvName\n  var params=\"&closeWhenApplyFilter=true\";\n  var i, f;\n  \n  var fl;\n  if(Empty(filters))\n  \tfl = jsfilters;\n  else\n    fl = filters;\n  if(!Empty(fl)) {\n    for( i=0; i\u003cfl.length; i++ ) {\n    f = fl[i];\n    if( !Empty(f.queryparm))\n      params+='&'+URLenc(f.field)+'='+URLenc(f.expression)\n  \t}\n  }\n  layerOpenForeground(url+params,\"filter\",\"\", 800, 600,null,1);\n  this.$entity$_GetConfigurationField.Emit();\n  this.$entity$_updateFilters.Emit();\n}\n\nfunction TRCSS(index) {\n  if( index%2 == 1) return 'grid_rowodd';\n  return 'grid_row';\n}\n\nfunction GetRows(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  index = js.row;\n  for( i=0; i\u003c(index+1); i++) {\n    if(!Empty(ret)) ret+= \" \u003e \"\n    ret+= jsrows[i].field;\n  }\n  return ret;\n}\n\nfunction GetRowsIndex(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  return (js.row+1)+'';\n}\n\nfunction GetColumns(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  index = js.column;\n  for( i=0; i\u003c(index+1); i++) {\n    if(!Empty(ret)) ret+= \" \u003e \"\n    ret+= jscolumns[i].field;\n  }\n  return ret;\n}\n\nfunction GetColumnsIndex(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  return (js.column+1)+'';\n}\n\nfunction TestRows(index) {\n  jslist[index].result = -1;\n  jslist[index].recs = -1; \n  ti = index;\n  var dobj = this.MLevelDataTester;\n\tdobj.ChangeQuery(this.TDatasource.Value());\n  dobj.resetForNewQuery();\n  dobj.ChangeConfigPivot(pObj, jslist[index].row+1, jslist[index].column+1)\n  var fl, f;\n  if(Empty(filters))\n  \tfl = jsfilters;\n  else\n    fl = filters;\n  var i;\n  var parms = '';\n  var jsfilter = [];\n  for( i=0; i\u003cfl.length; i++ ) {\n  \tf = fl[i];\n    if (f.queryparm != \"\") {\n      parms += f.queryparm + \",\";\n      if (this[f.queryparm] && this[f.queryparm].Value) {\n        this[f.queryparm].Value(f.expression);\n      }\n      else {\n        this[f.queryparm] = new this.Var(f.expression);\n      }\n    }\n    else if( f.visible == true ){\n      jsfilter.push({\n              \"field\":f.field,\n              \"type\":f.type,\n              \"operator\":f.operator,\n              \"expression\":f.expression,\n              \"fixed\":false\n            });\n    }\n  }\n  dobj.parms = parms;\n  dobj.queryfilter = jsfilter\n  t = Date.now();\n  dobj.Query()\n}\n\nfunction MLevelDataTester_Abort(jsonCause, strMessage){\n  jslist[ti].result = '';\n  this.StaticDataList.FillData(jslist)\n}\n\nfunction MLevelDataTester_Error(jsonCause, strMessage){\n  jslist[ti].result = 'error : ' + strMessage ;\n  this.StaticDataList.FillData(jslist)\n}\n\nfunction MLevelDataTester_QueryExecuted(){\n  if( Empty(jslist[ti].result) || ( jslist[ti].result == -1 )) {\n  \tjslist[ti].result = (Date.now() - t);\n    jslist[ti].recs = this.MLevelDataTester.GetQueryCount()\n  }\n  this.StaticDataList.FillData(jslist)\n}\n\nfunction BCResultTimeRows(index) {\n  if( !jslist[index].result ) return '';\n  if( jslist[index].result == -1 ) return '';\n  if ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n\t\treturn '#BF0603'\n  var ts = Math.round(jslist[index].result\u002f1000);\n  if( ts \u003c= 10 )\n  \treturn '#00762A'\n  if( ts \u003c= 30 )\n    return \"#bf6403\";\n  return '#BF0603'\n}\n\nfunction ResultTimeRows(index) {\n  if( !jslist[index].result ) return '';\n  if( jslist[index].result == -1 )\n\t\treturn ''\n \tif ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n    return jslist[index].result;\n  return Math.round(jslist[index].result\u002f1000) + ' s'\n}\n\nfunction BCResultRecsRows(index) {\n  if( !jslist[index].recs ) return '';\n  if( jslist[index].recs == -1 )\n\t\treturn ''\n  if ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n    return '';\n  var ts = jslist[index].recs;\n  if( ts \u003c= 500000 )\n  \treturn '#00762A'\n  if( ts \u003c= 150000 )\n    return \"#bf6403\";\n  return '#BF0603'\n}\n\nfunction ResultRecsRows(index) {\n  if( !jslist[index].recs ) return '';\n  if( jslist[index].recs == -1 )\n\t\treturn ''\n  if ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n    return '';\n  return jslist[index].recs + ''\n}\n\nfunction SelectLevel(index) {\n  if( opener.SetCacheLevel )\n    opener.SetCacheLevel(jslist[index].row+1, jslist[index].column+1)\n  window.close()\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"classeditor\u002ffontList.css,portalstudio\u002fportalstudioTheme.css,properties.css","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"opacity: .5\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"textbox\",\"class_name\":\"portalstudio_textbox\",\"selector\":\".portalstudio_opacity\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"opacity: .5\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"textbox\",\"class_name\":\"portalstudio_opacity\",\"selector\":\".portalstudio_opacity\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @TColumns_Copy }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @labelData }}{{ @lblTitle }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @lblTitle }}{{ @TDatasource }}{{ @BParameters }}{{ @lblTitle_Copy }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @lblDatasource }}{{ @TDatasource }}{{ @BParameters }}{{ @lblColumns_Copy }}{{ @lblDatasource }}{{ @lblColumns }}{{ @lblRows }}{{ @Textbox14 }}{{ @lblRows_Copy }}{{ @TLimit }}{{ @lblLimit }}{{ @lblDatasource }}{{ @TDatasource }}{{ @BParameters }}{{ @lblColumns }}{{ @lblRows }}{{ @TLimit }}{{ @lblLimit }}{{ @TColumns_Copy }}{{ @lblMeasures }}{{ @TMeasures }}\u003c\u002fbody\u003e","grapesCss":"","h":"172","hsl":"","htmlcode":"{{ @TDatasource }} \n{{ @lblDatasource }} \n{{ @TRows }} \n \n{{ @BParameters }} \n{{ @TDatasource \n }} \n{{ @TColumns{{ @TRows{{ @labelData{{ @lblDatasource \n }} \n }} \n{{ @labelTitle }} \n }} \n }} \n \n \n \n \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"172\",\"w\":\"100%\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"656","version":"37","w":"100%","wizard":""},{"anchor":"","class_Css":"","code":"\u003ctable class='portalstudio_grid'\u003e\n  \u003ctr class='grid_row'\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eRow level\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eRows\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eColumn level\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eColumns\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eTest\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eResult Time\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eResult Records\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n   \u003c\u002ftr\u003e \n  {{ #each a,index in StaticDataList }}\n      \u003ctr class='{{ function:TRCSS( %index% ) }}'\u003e\n        \u003ctd\u003e\u003cdiv style='text-align:center'\u003e{{ function:GetRowsIndex( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\n            \u003cdiv style='white-space: nowrap;'\u003e{{ function:GetRows( %index% ) }}\u003c\u002fdiv\u003e\n          \u003c\u002ftd\u003e\n        \u003ctd\u003e\u003cdiv style='text-align:center'\u003e{{ function:GetColumnsIndex( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\n            \u003cdiv style='white-space: nowrap;'\u003e{{ function:GetColumns( %index% ) }}\u003c\u002fdiv\u003e\n          \u003c\u002ftd\u003e\n          \u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\"button\" onclick='{{ idPortlet }}.TestRows({{ index }})'\u003eTest\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n\n          \u003ctd\u003e\u003cdiv style='text-align:center;width:100px;\n                   background-color:{{ function:BCResultTimeRows( %index% ) }};\n                   color:white'\n                   \u003e{{ function:ResultTimeRows( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\u003cdiv style='text-align:center;width:70px;\n                   background-color:{{ function:BCResultRecsRows( %index% ) }};\n                   color:white'\n                   \u003e{{ function:ResultRecsRows( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:150px;height:25px' type=\"button\" onclick='{{ idPortlet }}.SelectLevel({{ index }})'\u003eSelect Levels and Close\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n      \u003c\u002ftr\u003e\n  {{ #endeach }}\n\u003c\u002ftable\u003e","ctrlOfVariant":"","dataobjs":"","fixed":"","h":"93","hide":"false","layer":"false","layout_steps_values":"{}","name":"TRows","page":"1","rapp":"","sequence":"1","spuid":"","type":"Template","w":"637","wireframe_props":"","x":"13","y":"71","zindex":"3","zone":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Prefetch Optimisation:","w":"645","wireframe_props":"align,value,n_col","x":"2","y":"2","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDatasource","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Datasource","w":"90","wireframe_props":"align,value,n_col","x":"14","y":"38","zindex":"2","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox portalstudio_opacity","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"TDatasource","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"148","wireframe_props":"name","x":"109","y":"38","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"BParameters","page":"1","rapp":"","sequence":"4","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Set Parameters","w":"148","wireframe_props":"value","x":"263","y":"36","zindex":"5","zone":""},{"cachelevel":"","cachelevel2":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":"20","measures":"","name":"MLevelDataTester","page":"1","parms":"","parms_source":"","queries":"","sequence":"5","type":"MLevelDataProvider","uptolevels":"","uptolevels2":"","w":"120","x":"692","y":"63"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"VVdmFile","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"692","y":"92"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_zoomSetFilter","objsValues":"this.SetFilters(evt)","page":"1","parmsNames":"","sequence":"7","type":"EventReceiver","w":"176","x":"692","y":"-22"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_updateFilters","page":"1","parmsNames":"Filters","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","sequence":"8","type":"EventEmitter","w":"176","x":"692","y":"5"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_GetConfigurationField","page":"1","parmsNames":"Fields","parmsTypes":"func","parmsValues":"this.GetConfigurationField()","persistent":"true","sequence":"9","type":"EventEmitter","w":"176","x":"692","y":"32"},{"alias":"","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"","h":"20","man_query":"","name":"StaticDataList","page":"1","parms":"","parms_source":"","sequence":"10","type":"StaticDataProvider","w":"120","x":"692","y":"121"}]%>
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
window.SPVisualPivotPrefetch_Static=function(){
if(typeof crumbObj  !='undefined')this.crumbObj =crumbObj ;
if(typeof penPusher !='undefined')this.penPusher=penPusher;
if(typeof SetFilters !='undefined')this.SetFilters=SetFilters;
if(typeof GetFilters !='undefined')this.GetFilters=GetFilters;
if(typeof GetConfigurationField !='undefined')this.GetConfigurationField=GetConfigurationField;
if(typeof setFieldInObj !='undefined')this.setFieldInObj=setFieldInObj;
if(typeof BParameters_Click !='undefined')this.BParameters_Click=BParameters_Click;
if(typeof TRCSS !='undefined')this.TRCSS=TRCSS;
if(typeof GetRows !='undefined')this.GetRows=GetRows;
if(typeof GetRowsIndex !='undefined')this.GetRowsIndex=GetRowsIndex;
if(typeof GetColumns !='undefined')this.GetColumns=GetColumns;
if(typeof GetColumnsIndex !='undefined')this.GetColumnsIndex=GetColumnsIndex;
if(typeof TestRows !='undefined')this.TestRows=TestRows;
if(typeof MLevelDataTester_Abort !='undefined')this.MLevelDataTester_Abort=MLevelDataTester_Abort;
if(typeof MLevelDataTester_Error !='undefined')this.MLevelDataTester_Error=MLevelDataTester_Error;
if(typeof MLevelDataTester_QueryExecuted !='undefined')this.MLevelDataTester_QueryExecuted=MLevelDataTester_QueryExecuted;
if(typeof BCResultTimeRows !='undefined')this.BCResultTimeRows=BCResultTimeRows;
if(typeof ResultTimeRows !='undefined')this.ResultTimeRows=ResultTimeRows;
if(typeof BCResultRecsRows !='undefined')this.BCResultRecsRows=BCResultRecsRows;
if(typeof ResultRecsRows !='undefined')this.ResultRecsRows=ResultRecsRows;
if(typeof SelectLevel !='undefined')this.SelectLevel=SelectLevel;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.StaticDataList.addTemplateConsumer(this.TRows);
this.Var=function(val){
  this.val=val;
  this.Value=function(val){
    if(arguments.length) this.val=val;
    return this.val;
  }
}
var opener = GetOpener();
if(!opener) return;
if(!opener.columnsObj) return;
if(!opener.rowsObj) return;
if(!opener.measuresObj) return;
if(!opener.filtersObj) return;
var jscolumns = JSON.parse(JSON.stringify(opener.columnsObj));
var jsrows = JSON.parse(JSON.stringify(opener.rowsObj));
var jsmeasures = JSON.parse(JSON.stringify(opener.measuresObj));
var jsfilters = JSON.parse(JSON.stringify(opener.filtersObj));
this.TDatasource.Value(opener.formProp.query)
this.VVdmFile.Value(opener.formProp.vdmfile)
var pObj = {};
  pObj.columnfields = [];
  pObj.columnkeys = [];
  pObj.rowfields = [];
  pObj.rowkeys = [];
  pObj.measurefields = [];
var i, j, t, ti;
for( i=0; i<jscolumns.length; i++) {
   pObj.columnfields.push(jscolumns[i].field)
   pObj.columnkeys.push(jscolumns[i].keys)
}
for( i=0; i<jsrows.length; i++) {
   pObj.rowfields.push(jsrows[i].field)
   pObj.rowkeys.push(jsrows[i].keys)
}
for( i=0; i<jsmeasures.length; i++) {
   pObj.measurefields.push(jsmeasures[i].field)
}
for( i=0; i<jsfilters.length; i++) {
   jsfilters[i].visible = true;
   jsfilters[i].queryparm = '';
}
var jslist = [];
for( i=0; i<jsrows.length; i++) {
  for( j=0; j<jscolumns.length; j++) {
    var o = {};
    o.row = i;
    o.column = j;
    jslist.push(o);
  }
}
this.StaticDataList.FillData(jslist)
var rcvSuffix="",
    rcvName='parametersList';
var filters = [];
function crumbObj (evt, ignoreFilterMap) {
    var res = [],
      p_exp,
      p_op, op_suff = '_op', def_op = '=',
      p_type, type_suff = '_type', def_type = 'C',
      p_fixed, fixed_suff = '_fixed',
      p_queryP, queryP_suff = '_queryParm',
      p_visible, visible_suff = '_visible',
      p_userFilter, userFilter_suff = '_userFilter',
      p_defaultFilter, defaultFilter_suff = '_defaultFilter';
      if(!evt) return [];
    for (var p in evt) {
      if (!evt.hasOwnProperty(p)) {
        continue;
      }
      if (evt[p] != null && IsA(evt[p], 'O') && !IsA(evt[p], 'D')) {
        res = res.concat(crumbObj(evt[p], ignoreFilterMap));
        continue;
      }
      if ((p.match(op_suff + '$') && RTrim(p, op_suff) in evt) ||
        (p.match(type_suff + '$') && RTrim(p, type_suff) in evt) ||
        (Empty(evt[p]) && (p + op_suff) in evt) 
        
      ) continue;
      p_op = EmptyString(evt[p + op_suff]) ? def_op : evt[p + op_suff];//operatore
      p_type = EmptyString(evt[p + type_suff]) ? def_type : evt[p + type_suff];//tipo
      p_fixed = evt[p + fixed_suff] || false;//fisso
      p_queryP = evt[p + queryP_suff] || "";
      p_visible = evt[p + visible_suff] || false;//visible
      p_userFilter = evt[p + userFilter_suff] || false;//filtro da moschina
      p_defaultFilter = evt[p + defaultFilter_suff] || false;//filtro da moschina
      p_exp = evt[p];
      
      res.push(
        {
          field: p,
          operator: p_op,
          expression: p_exp,
          type: p_type,
          fixed: p_fixed,
          queryparm: p_queryP,
          visible: p_visible,
          userFilter: p_userFilter,
          defaultFilter: p_defaultFilter
        });
    }
    return res;
}
function penPusher(parmsObj) { //funzione passacarte per receiver di filtro
  this.$entity$_zoomSetFilter.receiveFnc(parmsObj);
}
for(var i=0,rcvs=rcvName.split(','),l=rcvs.length; i<l; i++){//receivername multiplo
  rcvName=rcvs[i];
  this['on_'+rcvName+rcvSuffix]=penPusher;//impostato per l'utente
}
this.$entity$_updateFilters.name = this.$entity$_updateFilters.name.replace('$entity$', rcvName);
this.$entity$_GetConfigurationField.name = this.$entity$_GetConfigurationField.name.replace('$entity$', rcvName);
function SetFilters(evt, opts) {
  filters = crumbObj(evt.row);
}
function GetFilters() {
  if(Empty(filters))
  	return jsfilters;
  var ret = [];
  var i, f;
  for( i=0; i<filters.length; i++ ) {
    f = filters[i];
    if( f.visible && Empty(f.queryparm))
      ret.push(f);
  }
  return ret;
}
function GetConfigurationField() {
  function setFieldInObj(fieldObj, obj) {
      if (!obj[fieldObj.field])
          obj[fieldObj.field] = {
          title: fieldObj.title,
          type: fieldObj.f_type||'C',
          hidden: false
        }
    }
  	var obj = {},
    i;
    for (i = 0; i < jscolumns.length; i++) {
      setFieldInObj(jscolumns[i], obj)
    }
    for (i = 0; i < jsrows.length; i++) {
      setFieldInObj(jsrows[i], obj)
    }
    return obj;
}
function BParameters_Click(){
  var p = ZtVWeb.getPortletWindow('SPMaskParameters');
  var url="../jsp/SPMaskParameters_portlet.jsp?";
  if (!Empty(this.VVdmFile.Value()))
    url+= "ConfigName="+URLenc(this.VVdmFile.Value());
  else
    url += "hideEditToolbar=true&QueryName="+URLenc(this.TDatasource.Value())+"&presetParams="+"&hideQueryParameters=false"+"&disablePresetParams=false";
  url= url + "&TitleMsg=MSG_SEARCH_FILTERS&offlineMode=false&zoomMode=true&hideAddFilterButton=false&EmitterName="+rcvName+"&ReceiverName="+rcvName
  var params="&closeWhenApplyFilter=true";
  var i, f;
  
  var fl;
  if(Empty(filters))
  	fl = jsfilters;
  else
    fl = filters;
  if(!Empty(fl)) {
    for( i=0; i<fl.length; i++ ) {
    f = fl[i];
    if( !Empty(f.queryparm))
      params+='&'+URLenc(f.field)+'='+URLenc(f.expression)
  	}
  }
  layerOpenForeground(url+params,"filter","", 800, 600,null,1);
  this.$entity$_GetConfigurationField.Emit();
  this.$entity$_updateFilters.Emit();
}
function TRCSS(index) {
  if( index%2 == 1) return 'grid_rowodd';
  return 'grid_row';
}
function GetRows(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  index = js.row;
  for( i=0; i<(index+1); i++) {
    if(!Empty(ret)) ret+= " > "
    ret+= jsrows[i].field;
  }
  return ret;
}
function GetRowsIndex(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  return (js.row+1)+'';
}
function GetColumns(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  index = js.column;
  for( i=0; i<(index+1); i++) {
    if(!Empty(ret)) ret+= " > "
    ret+= jscolumns[i].field;
  }
  return ret;
}
function GetColumnsIndex(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  return (js.column+1)+'';
}
function TestRows(index) {
  jslist[index].result = -1;
  jslist[index].recs = -1; 
  ti = index;
  var dobj = this.MLevelDataTester;
	dobj.ChangeQuery(this.TDatasource.Value());
  dobj.resetForNewQuery();
  dobj.ChangeConfigPivot(pObj, jslist[index].row+1, jslist[index].column+1)
  var fl, f;
  if(Empty(filters))
  	fl = jsfilters;
  else
    fl = filters;
  var i;
  var parms = '';
  var jsfilter = [];
  for( i=0; i<fl.length; i++ ) {
  	f = fl[i];
    if (f.queryparm != "") {
      parms += f.queryparm + ",";
      if (this[f.queryparm] && this[f.queryparm].Value) {
        this[f.queryparm].Value(f.expression);
      }
      else {
        this[f.queryparm] = new this.Var(f.expression);
      }
    }
    else if( f.visible == true ){
      jsfilter.push({
              "field":f.field,
              "type":f.type,
              "operator":f.operator,
              "expression":f.expression,
              "fixed":false
            });
    }
  }
  dobj.parms = parms;
  dobj.queryfilter = jsfilter
  t = Date.now();
  dobj.Query()
}
function MLevelDataTester_Abort(jsonCause, strMessage){
  jslist[ti].result = '';
  this.StaticDataList.FillData(jslist)
}
function MLevelDataTester_Error(jsonCause, strMessage){
  jslist[ti].result = 'error : ' + strMessage ;
  this.StaticDataList.FillData(jslist)
}
function MLevelDataTester_QueryExecuted(){
  if( Empty(jslist[ti].result) || ( jslist[ti].result == -1 )) {
  	jslist[ti].result = (Date.now() - t);
    jslist[ti].recs = this.MLevelDataTester.GetQueryCount()
  }
  this.StaticDataList.FillData(jslist)
}
function BCResultTimeRows(index) {
  if( !jslist[index].result ) return '';
  if( jslist[index].result == -1 ) return '';
  if ((jslist[index].result + "").indexOf('error')>=0)
		return '#BF0603'
  var ts = Math.round(jslist[index].result/1000);
  if( ts <= 10 )
  	return '#00762A'
  if( ts <= 30 )
    return "#bf6403";
  return '#BF0603'
}
function ResultTimeRows(index) {
  if( !jslist[index].result ) return '';
  if( jslist[index].result == -1 )
		return ''
 	if ((jslist[index].result + "").indexOf('error')>=0)
    return jslist[index].result;
  return Math.round(jslist[index].result/1000) + ' s'
}
function BCResultRecsRows(index) {
  if( !jslist[index].recs ) return '';
  if( jslist[index].recs == -1 )
		return ''
  if ((jslist[index].result + "").indexOf('error')>=0)
    return '';
  var ts = jslist[index].recs;
  if( ts <= 500000 )
  	return '#00762A'
  if( ts <= 150000 )
    return "#bf6403";
  return '#BF0603'
}
function ResultRecsRows(index) {
  if( !jslist[index].recs ) return '';
  if( jslist[index].recs == -1 )
		return ''
  if ((jslist[index].result + "").indexOf('error')>=0)
    return '';
  return jslist[index].recs + ''
}
function SelectLevel(index) {
  if( opener.SetCacheLevel )
    opener.SetCacheLevel(jslist[index].row+1, jslist[index].column+1)
  window.close()
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
.SPVisualPivotPrefetch_container .portalstudio_opacity{  opacity: .5
}
.SPVisualPivotPrefetch_container .portalstudio_opacity{
  opacity: .5
}
.SPVisualPivotPrefetch_container {
}
.SPVisualPivotPrefetch_portlet{
  position:relative;
  width:100%;
  min-width:656px;
  height:172px;
}
.SPVisualPivotPrefetch_portlet[Data-page="1"]{
  height:172px;
  width:100%;
}
.SPVisualPivotPrefetch_portlet > .TRows_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:71px;
  left:13px;
  left:1.9817073%;
  right:6px;
  right:0.91463417%;
  width:auto;
  height:auto;
  min-height:93px;
}
.SPVisualPivotPrefetch_portlet > .labelTitle_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:2px;
  left:2px;
  right:9px;
  width:auto;
  height:auto;
  min-height:30px;
}
.SPVisualPivotPrefetch_portlet > .labelTitle_ctrl {
  height:auto;
  min-height:30px;
}
.SPVisualPivotPrefetch_portlet > .labelTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotPrefetch_portlet > .lblDatasource_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:38px;
  left:14px;
  left:2.1341465%;
  right:552px;
  right:84.14634%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPVisualPivotPrefetch_portlet > .lblDatasource_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotPrefetch_portlet > .lblDatasource_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotPrefetch_portlet > .TDatasource_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:38px;
  left:109px;
  left:16.615854%;
  right:399px;
  right:60.82317%;
  width:auto;
  height:20px;
}
.SPVisualPivotPrefetch_portlet > .TDatasource_ctrl {
}
.SPVisualPivotPrefetch_portlet > .TDatasource_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPVisualPivotPrefetch_portlet > .BParameters_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:36px;
  left:263px;
  left:40.091465%;
  right:245px;
  right:37.34756%;
  width:auto;
  height:25px;
}
.SPVisualPivotPrefetch_portlet > .BParameters_ctrl {
}
.SPVisualPivotPrefetch_portlet > .MLevelDataTester_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:692px;
  left:105.48781%;
  right:-156px;
  right:-23.780487%;
  width:auto;
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
 String def="[{\"h\":\"172\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"656\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"93\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Template\",\"w\":\"637\",\"x\":\"13\",\"y\":\"71\",\"zindex\":\"3\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"30\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Prefetch Optimisation:\",\"w\":\"645\",\"x\":\"2\",\"y\":\"2\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Datasource\",\"w\":\"90\",\"x\":\"14\",\"y\":\"38\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"TDatasource\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"148\",\"x\":\"109\",\"y\":\"38\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"BParameters\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Set Parameters\",\"w\":\"148\",\"x\":\"263\",\"y\":\"36\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"MLevelDataTester\",\"page\":\"1\",\"type\":\"MLevelDataProvider\",\"w\":\"120\",\"x\":\"692\",\"y\":\"63\"},{\"h\":\"20\",\"name\":\"VVdmFile\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"692\",\"y\":\"92\"},{\"h\":\"20\",\"name\":\"$entity$_zoomSetFilter\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"176\",\"x\":\"692\",\"y\":\"-22\"},{\"h\":\"20\",\"name\":\"$entity$_updateFilters\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"176\",\"x\":\"692\",\"y\":\"5\"},{\"h\":\"20\",\"name\":\"$entity$_GetConfigurationField\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"176\",\"x\":\"692\",\"y\":\"32\"},{\"h\":\"20\",\"name\":\"StaticDataList\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"692\",\"y\":\"121\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVisualPivotPrefetch","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPVisualPivotPrefetch_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("classeditor/fontList.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("classeditor/fontList.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("classeditor/fontList.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/classeditor/fontList.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("portalstudio/portalstudioTheme.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("portalstudio/portalstudioTheme.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("properties.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("properties.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("properties.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/properties.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPVisualPivotPrefetch','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPVisualPivotPrefetch_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateParser.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateObj.js")%>'></script>
<%}
String labelTitle= "Prefetch Optimisation:";
String lblDatasource= "Datasource";
String TDatasource= "";
if(request.getAttribute("SPVisualPivotPrefetch_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("SPVisualPivotPrefetch_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("MLevelDataProviderObj.js")%>'></script>
<%}
String VVdmFile= "";
if(request.getAttribute("SPVisualPivotPrefetch_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPVisualPivotPrefetch_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPVisualPivotPrefetch_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPVisualPivotPrefetch','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_TRows' class=' TRows_ctrl'></div>
<span id='<%=idPortlet%>_labelTitle'  formid='<%=idPortlet%>' ps-name='labelTitle'    class='portalstudio_title labelTitle_ctrl'><div id='<%=idPortlet%>_labelTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Prefetch Optimisation:")%></div></span>
<label id='<%=idPortlet%>_lblDatasource'  formid='<%=idPortlet%>' ps-name='lblDatasource'    class='portalstudio_label lblDatasource_ctrl'><div id='<%=idPortlet%>_lblDatasourcetbl' style='width:100%;'><%=JSPLib.ToHTML("Datasource")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_TDatasource_wrp'><input id='<%=idPortlet%>_TDatasource' name='TDatasource' type='text' disabled class='portalstudio_textbox portalstudio_opacity' formid='<%=idPortlet%>' ps-name='TDatasource' /></span>
<input id='<%=idPortlet%>_BParameters' type='button' class='portalstudio_button BParameters_ctrl'/>
<div id='<%=idPortlet%>_MLevelDataTester' style='position:absolute;top:63px;left:692px;width:120px;height:20px;'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPVisualPivotPrefetch');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPVisualPivotPrefetch',["656"],["172"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"656","h":"172","title":"","layer":""}]);
this.TRows=new ZtVWeb.TemplateCtrl(this,{"anchor":"top-left(%)-right(%)","call_stack":"{\"iterator\":\"\",\"key\":\"\",\"data\":\"\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[{\"iterator\":\"a\",\"key\":\"index\",\"data\":\"staticdatalist\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[]}]}","class_Css":"","ctrlid":"<%=idPortlet%>_TRows","h":93,"hide":"false","layer":false,"layout_steps_values":{},"name":"TRows","page":1,"spuid":"","template":"{\"exp\":\"\",\"prefix\":\"\\u003ctable class='portalstudio_grid'\\u003e\\n  \\u003ctr class='grid_row'\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eRow level\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eRows\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eColumn level\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eColumns\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eTest\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eResult Time\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eResult Records\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n   \\u003c\\u002ftr\\u003e \\n  \",\"post\":\"\",\"type\":\"ROOT\",\"attrs\":{},\"nodes\":[{\"exp\":\"%StaticDataList%\",\"prefix\":null,\"post\":\"\\n      \\u003ctr class='\",\"type\":\"EACH\",\"attrs\":{\"iterator\":\"a\",\"key\":\"index\"},\"nodes\":[{\"exp\":\"function:TRCSS(%index%)\",\"prefix\":null,\"post\":\"'\\u003e\\n        \\u003ctd\\u003e\\u003cdiv style='text-align:center'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetRowsIndex(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\n            \\u003cdiv style='white-space: nowrap;'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetRows(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\n          \\u003c\\u002ftd\\u003e\\n        \\u003ctd\\u003e\\u003cdiv style='text-align:center'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetColumnsIndex(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\n            \\u003cdiv style='white-space: nowrap;'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetColumns(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\n          \\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".TestRows(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eTest\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n\\n          \\u003ctd\\u003e\\u003cdiv style='text-align:center;width:100px;\\n                   background-color:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:BCResultTimeRows(%index%)\",\"prefix\":null,\"post\":\";\\n                   color:white'\\n                   \\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:ResultTimeRows(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\u003cdiv style='text-align:center;width:70px;\\n                   background-color:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:BCResultRecsRows(%index%)\",\"prefix\":null,\"post\":\";\\n                   color:white'\\n                   \\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:ResultRecsRows(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:150px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".SelectLevel(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eSelect Levels and Close\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n      \\u003c\\u002ftr\\u003e\\n  \",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]}]},{\"exp\":\"\",\"prefix\":null,\"post\":\"\\n\\u003c\\u002ftable\\u003e\",\"type\":\"END_EACH\",\"attrs\":{},\"nodes\":[]}]}","type":"Template","w":637,"x":13,"y":71,"zindex":"3"});
this.labelTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTitle,false,true)%>","type":"Label","w":645,"x":2,"y":2,"zindex":"2"});
this.lblDatasource=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDatasource","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDatasource","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDatasource,false,true)%>","type":"Label","w":90,"x":14,"y":38,"zindex":"2"});
this.TDatasource=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_TDatasource","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"TDatasource","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(TDatasource,false,true)%>","w":148,"x":109,"y":38,"zerofilling":false,"zindex":"4","zoom":""});
this.BParameters=new ZtVWeb._BC(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button BParameters_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BParameters","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BParameters","page":1,"spuid":"","tabindex":"","text":"Set Parameters","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":263,"y":36,"zindex":"5"});
this.MLevelDataTester=new ZtVWeb.MLevelDataProvider(this,{"anchor":"top-left(%)-right(%)","async":false,"cachelevel":0,"cachelevel2":0,"cmdHash":["<%=JSPLib.cmdHash("",request.getSession())%>"],"ctrlid":"<%=idPortlet%>_MLevelDataTester","decrypted_parms":"","encrypted_fields":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"measures":"","name":"MLevelDataTester","page":1,"parms":"","parms_source":"","queries":"","type":"MLevelDataProvider","uptolevels":"","uptolevels2":"","w":120,"x":692,"y":63});
this.MLevelDataTester._FTranslations = {In_Progress:'<%=JSPLib.ToJSValue(sp.translate("MSG_ELABORATION_INPROGRESS"))%>'}
this.VVdmFile=new ZtVWeb._VC(this,'VVdmFile',null,'character','<%=JSPLib.ToJSValue(VVdmFile,false,true)%>',false,false);
this.$entity$_zoomSetFilter=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_zoomSetFilter","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_zoomSetFilter","objsValues":"this.SetFilters(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":176,"x":692,"y":-22});
this.$entity$_updateFilters=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_updateFilters","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateFilters","page":1,"parmsNames":"Filters","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","type":"EventEmitter","w":176,"x":692,"y":5});
this.$entity$_GetConfigurationField=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_GetConfigurationField","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_GetConfigurationField","page":1,"parmsNames":"Fields","parmsTypes":"func","parmsValues":"this.GetConfigurationField()","persistent":"true","type":"EventEmitter","w":176,"x":692,"y":32});
this.StaticDataList=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataList","dataproviders":"","fieldsString":"","fieldstypeString":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataList","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":692,"y":121});
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
<%if(request.getAttribute("SPVisualPivotPrefetch_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPVisualPivotPrefetch_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPVisualPivotPrefetch_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_$entity$_zoomSetFilter=function(parmsObj){<%=idPortlet%>.$entity$_zoomSetFilter.receiveFnc(parmsObj);}
window.<%=idPortlet%>.$entity$_updateFilters.setParms();
window.<%=idPortlet%>.$entity$_GetConfigurationField.setParms();
window.<%=idPortlet%>.TRows.Render( {"start_on_load":true} );
ZtVWeb.addPortletObj('<%=idPortlet%>','SPVisualPivotPrefetch',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPVisualPivotPrefetch');
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
sp.endPage("SPVisualPivotPrefetch");
}%>
<%! public String getJSPUID() { return "1359603645"; } %>