<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\n\nthis.getTitlePortlet().AppendButton({\n   id:'apply',\n   title:'Applica',\n   tooltip:'',\n   image:SPTheme.smartEditorApplyImage,\n   action: _this.returnConfiguration\n})\nthis.getTitlePortlet().SetTitle('Multi Data Level')\nthis.getTitlePortlet().SetSubTitle('Data Level Configuration')\n\n\nthis.Var=function(val){\n  this.val=val;\n  this.Value=function(val){\n    if(arguments.length) this.val=val;\n    return this.val;\n  }\n}\n\nvar opener = GetOpener();\nconsole.log(opener.itemsHTML[this.objIndex.Value()])\nif(!opener) {\n  alert( 'No opener!')    \n  return;\n}\nif(!opener.itemsHTML || !opener.itemsHTML[this.objIndex.Value()] || opener.itemsHTML[this.objIndex.Value()].type != 'MLevelDataProvider') {\n  alert( 'Invalid object!')    \n  return;\n}\nvar mobj = opener.itemsHTML[this.objIndex.Value()];\nvar jscolumns = mobj.fields.split(',');\nvar jsrows = mobj.filterfields.split(',');\nvar jscolumnskeys = mobj.fieldskeys.split(',');\nvar jsrowskeys = mobj.filterfieldskeys.split(',');\nvar jsmeasures = mobj.measures.split(',');\nvar jsqueries = mobj.queries.split(',');\nvar jsup = mobj.uptolevels.split(',');\nvar jsup2 = mobj.uptolevels2.split(',');\nvar cachelevel = parseInt('0'+mobj.cachelevel)\nvar cachelevel2 = parseInt('0'+mobj.cachelevel2)\n\nvar pObj = {};\n  pObj.columnfields = [];\n  pObj.columnkeys = [];\n  pObj.rowfields = [];\n  pObj.rowkeys = [];\n  pObj.measurefields = [];\n\n\nvar i, j, t, ti;\nfor( i=0; i\u003cjscolumns.length; i++) {\n   pObj.columnfields.push(jscolumns[i])\n   pObj.columnkeys.push(jscolumnskeys[i])\n}\nfor( i=0; i\u003cjsrows.length; i++) {\n   pObj.rowfields.push(jsrows[i])\n   pObj.rowkeys.push(jsrowskeys[i])\n}\nfor( i=0; i\u003cjsmeasures.length; i++) {\n   pObj.measurefields.push(jsmeasures[i])\n}\n\nvar jslist = [];\nfor( i=0; i\u003cjsrows.length; i++) {\n  for( j=0; j\u003cjscolumns.length; j++) {\n    var o = {};\n    o.row = i;\n    o.column = j;\n    jslist.push(o);\n  }\n}\n\nvar jsupmap = {}\nfor ( i=0; i\u003cjsup.length; i++ ) {\n  if( jsqueries[i] ) {\n    if( jsup2[i] ) {\n    \tjsupmap[jsup[i] + '-' + jsup2[i]] = jsqueries[i]\n  \t}\n  \telse {\n      jsupmap[jsup[i] + '-' + '0'] = jsqueries[i]\n  \t}\n  }\n}\n\nthis.StaticDataList.FillData(jslist)\n\n\nfunction TRCSS(index) {\n  if( index%2 == 1) return 'grid_rowodd';\n  return 'grid_row';\n}\n\nfunction GetRows(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  index = js.row;\n  for( i=0; i\u003c(index+1); i++) {\n    if(!Empty(ret)) ret+= \" \u003e \"\n    ret+= jsrows[i];\n  }\n  return ret;\n}\n\nfunction GetRowsIndex(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  return (js.row+1)+'';\n}\n\nfunction GetColumns(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  index = js.column;\n  for( i=0; i\u003c(index+1); i++) {\n    if(!Empty(ret)) ret+= \" \u003e \"\n    ret+= jscolumns[i];\n  }\n  return ret;\n}\n\nfunction GetColumnsIndex(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  return (js.column+1)+'';\n}\n\nfunction GetQueryIndex(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  var r = js.row+1, c = js.column+1;\n  if( jsupmap[r + '-' + c] ) return jsupmap[r + '-' + c];\n  if( jsupmap[r + '-' + '0'] ) return jsupmap[r + '-' + '0'];\n  return '';\n}\n\nfunction GetRadioIndex(index) {\n\tvar i;\n  var ret = '';\n  var js = jslist[index];\n  var r = js.row+1, c = js.column+1;\n  if( r==cachelevel && c==cachelevel2 )\n  \treturn 'checked';\n  return '';\n}\n\nfunction InputQueryIndex(index) {\n  var ctrl = _this.TRows.GetCtrl()\n  var table = ctrl.children[0];\n  var tr = table.rows.item(index+1);\n  var vqr = tr.getElementsByClassName('textquery')[0].value;\n  var js = jslist[index];\n  var r = js.row+1, c = js.column+1;\n  jsupmap[r + '-' + c] = vqr;\n}\n\nfunction RadioQueryIndex(index) {\n  var js = jslist[index];\n  cachelevel = js.row+1;\n  cachelevel2 = js.column+1;\n}\n\nfunction TestQuery(index) {\n  jslist[index].result = -1;\n  jslist[index].recs = -1; \n  ti = index;\n  var dobj = this.mDataobj;\n  var ctrl = _this.TRows.GetCtrl()\n  var table = ctrl.children[0];\n  var tr = table.rows.item(index+1);\n  var vqr = tr.getElementsByClassName('textquery')[0].value;\n\tdobj.ChangeQuery(vqr);\n  dobj.resetForNewQuery();\n  dobj.ChangeConfigPivot(pObj, jslist[index].row+1, jslist[index].column+1)\n  \u002f*var fl, f;\n  if(Empty(filters))\n  \tfl = jsfilters;\n  else\n    fl = filters;\n  var i;\n  var parms = '';\n  var jsfilter = [];\n  for( i=0; i\u003cfl.length; i++ ) {\n  \tf = fl[i];\n    if (f.queryparm != \"\") {\n      parms += f.queryparm + \",\";\n      if (this[f.queryparm] && this[f.queryparm].Value) {\n        this[f.queryparm].Value(f.expression);\n      }\n      else {\n        this[f.queryparm] = new this.Var(f.expression);\n      }\n    }\n    else if( f.visible == true ){\n      jsfilter.push({\n              \"field\":f.field,\n              \"type\":f.type,\n              \"operator\":f.operator,\n              \"expression\":f.expression,\n              \"fixed\":false\n            });\n    }\n  }\n  dobj.parms = parms;\n  dobj.queryfilter = jsfilter*\u002f\n  t = Date.now();\n  dobj.Query()\n}\n\nfunction mDataobj_Abort(jsonCause, strMessage){\n  jslist[ti].result = '';\n  this.StaticDataList.FillData(jslist)\n}\n\nfunction mDataobj_Error(jsonCause, strMessage){\n  jslist[ti].result = 'error : ' + strMessage ;\n  this.StaticDataList.FillData(jslist)\n}\n\nfunction mDataobj_QueryExecuted(){\n  if( Empty(jslist[ti].result) || ( jslist[ti].result == -1 )) {\n  \tjslist[ti].result = (Date.now() - t);\n    jslist[ti].recs = this.mDataobj.GetQueryCount()\n  }\n  this.StaticDataList.FillData(jslist)\n}\n\nfunction BCResultTimeQuery(index) {\n  if( !jslist[index].result ) return '';\n  if( jslist[index].result == -1 ) return '';\n  if ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n\t\treturn '#BF0603'\n  var ts = Math.round(jslist[index].result\u002f1000);\n  if( ts \u003c= 10 )\n  \treturn '#00762A'\n  if( ts \u003c= 30 )\n    return \"#bf6403\";\n  return '#BF0603'\n}\n\nfunction ResultTimeQuery(index) {\n  if( !jslist[index].result ) return '';\n  if( jslist[index].result == -1 )\n\t\treturn ''\n \tif ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n    return jslist[index].result;\n  return Math.round(jslist[index].result\u002f1000) + ' s'\n}\n\nfunction BCResultRecsQuery(index) {\n  if( !jslist[index].recs ) return '';\n  if( jslist[index].recs == -1 )\n\t\treturn ''\n  if ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n    return '';\n  var ts = jslist[index].recs;\n  if( ts \u003c= 500000 )\n  \treturn '#00762A'\n  if( ts \u003c= 150000 )\n    return \"#bf6403\";\n  return '#BF0603'\n}\n\nfunction ResultRecsQuery(index) {\n  if( !jslist[index].recs ) return '';\n  if( jslist[index].recs == -1 )\n\t\treturn ''\n  if ((jslist[index].result + \"\").indexOf('error')\u003e=0)\n    return '';\n  return jslist[index].recs + ''\n}\n\n\nfunction returnConfiguration() {\n  var ctrl = _this.TRows.GetCtrl()\n  var table = ctrl.children[0];\n  var prefetched = 'prefetched', rowindex = 'rowindex', columnindex = 'columnindex', textquery = 'textquery'\n  var jsret = {};\n  jsret.queries = [];\n  jsret.uptolevels = [];\n  jsret.uptolevels2 = [];\n  \n\tvar rowLength = table.rows.length;\n  for (i = 1; i \u003c rowLength; i++){\n\t\tvar tr = table.rows.item(i);\n    jsret.queries.push(tr.getElementsByClassName(textquery)[0].value)\n    jsret.uptolevels.push(tr.getElementsByClassName(rowindex)[0].textContent)\n    jsret.uptolevels2.push(tr.getElementsByClassName(columnindex)[0].textContent)\n    if( tr.getElementsByClassName(prefetched)[0].checked ) {\n      jsret.prefetched = {};\n      jsret.prefetched.row = tr.getElementsByClassName(rowindex)[0].textContent;\n      jsret.prefetched.column = tr.getElementsByClassName(columnindex)[0].textContent;\n    }\n  }\n  if (opener.SetMLevelConfiguration) {\n  \topener.SetMLevelConfiguration(_this.objIndex.Value(), jsret);\n  }\n  window.close()\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"classeditor\u002ffontList.css,portalstudio\u002fportalstudioTheme.css,properties.css","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"opacity: .5\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"textbox\",\"class_name\":\"portalstudio_textbox\",\"selector\":\".portalstudio_opacity\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"opacity: .5\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"textbox\",\"class_name\":\"portalstudio_opacity\",\"selector\":\".portalstudio_opacity\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @TColumns_Copy }}{{ @TColumns }}{{ @TRows }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @labelData }}{{ @lblTitle }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @lblTitle }}{{ @lblTitle_Copy }}{{ @TColumns }}{{ @TRows }}{{ @labelTitle }}{{ @TDatasource }}{{ @BParameters }}{{ @lblColumns_Copy }}{{ @lblDatasource }}{{ @lblColumns }}{{ @lblRows }}{{ @Textbox14 }}{{ @lblRows_Copy }}{{ @TLimit }}{{ @lblLimit }}{{ @lblDatasource }}{{ @TDatasource }}{{ @BParameters }}{{ @lblColumns }}{{ @lblRows }}{{ @TLimit }}{{ @lblLimit }}{{ @TColumns_Copy }}{{ @lblMeasures }}{{ @TMeasures }}\u003c\u002fbody\u003e","grapesCss":"","h":"172","hsl":"","htmlcode":" \n \n{{ @TRows }} \n \n \n{{ @TDatasource \n }} \n{{ @TColumns{{ @TRows{{ @labelData{{ @lblDatasource \n }} \n }} \n \n }} \n }} \n \n \n \n \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"172\",\"w\":\"100%\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"656","version":"37","w":"100%","wizard":""},{"anchor":"","class_Css":"","code":"\u003ctable class='portalstudio_grid'\u003e\n  \u003ctr class='grid_row'\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eChoose Prefetched levels\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eRow level\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eRows\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eColumn level\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eColumns\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eSpecify Query by level\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eTest\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eResult Time\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd class='grid_cell_title'\u003e\u003cdiv style='text-align:center'\u003eResult Records\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n   \u003c\u002ftr\u003e \n  {{ #each a,index in StaticDataList }}\n      \u003ctr class='{{ function:TRCSS( %index% ) }}'\u003e\n        \u003ctd\u003e\u003cdiv style='text-align:center'\u003e\u003cinput class='prefetched' type=\"radio\" name=\"prefetched\" onchange='{{ idPortlet }}.RadioQueryIndex({{ index }})' value=\"{{ index }}\"  {{ function:GetRadioIndex( %index% ) }} \u002f\u003e\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n        \u003ctd\u003e\u003cdiv class='rowindex' style='text-align:center'\u003e{{ function:GetRowsIndex( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\n            \u003cdiv style='white-space: nowrap;'\u003e{{ function:GetRows( %index% ) }}\u003c\u002fdiv\u003e\n          \u003c\u002ftd\u003e\n        \u003ctd\u003e\u003cdiv class='columnindex' style='text-align:center'\u003e{{ function:GetColumnsIndex( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\n            \u003cdiv style='white-space: nowrap;'\u003e{{ function:GetColumns( %index% ) }}\u003c\u002fdiv\u003e\n          \u003c\u002ftd\u003e\n          \u003ctd\u003e\u003cinput class='portalstudio_textbox textquery' style='width:150px;height:25px' type=\"text\" value='{{ function:GetQueryIndex( %index% ) }}' onblur='{{ idPortlet }}.InputQueryIndex({{ index }})'\u003e\u003c\u002ftd\u003e\n        \t\u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\"button\" onclick='{{ idPortlet }}.TestQuery({{ index }})'\u003eTest\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n\n          \u003ctd\u003e\u003cdiv style='text-align:center;width:100px;\n                   background-color:{{ function:BCResultTimeQuery( %index% ) }};\n                   color:white'\n                   \u003e{{ function:ResultTimeQuery( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n          \u003ctd\u003e\u003cdiv style='text-align:center;width:70px;\n                   background-color:{{ function:BCResultRecsQuery( %index% ) }};\n                   color:white'\n                   \u003e{{ function:ResultRecsQuery( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n      \u003c\u002ftr\u003e\n  {{ #endeach }}\n\u003c\u002ftable\u003e","ctrlOfVariant":"","dataobjs":"","fixed":"","h":"158","hide":"false","layer":"false","layout_steps_values":"{}","name":"TRows","page":"1","rapp":"","sequence":"1","spuid":"","type":"Template","w":"637","wireframe_props":"","x":"13","y":"6","zindex":"3","zone":""},{"alias":"","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"","h":"20","man_query":"","name":"StaticDataList","page":"1","parms":"","parms_source":"","sequence":"1","type":"StaticDataProvider","w":"120","x":"670","y":"-53"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"objIndex","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"673","y":"-24"},{"cachelevel":"","cachelevel2":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":"20","measures":"","name":"mDataobj","page":"1","parms":"","parms_source":"","queries":"","sequence":"3","type":"MLevelDataProvider","uptolevels":"","uptolevels2":"","w":"120","x":"677","y":"11"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:objIndex*/%>
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
window.SPMLevelDataConfig_Static=function(){
if(typeof TRCSS !='undefined')this.TRCSS=TRCSS;
if(typeof GetRows !='undefined')this.GetRows=GetRows;
if(typeof GetRowsIndex !='undefined')this.GetRowsIndex=GetRowsIndex;
if(typeof GetColumns !='undefined')this.GetColumns=GetColumns;
if(typeof GetColumnsIndex !='undefined')this.GetColumnsIndex=GetColumnsIndex;
if(typeof GetQueryIndex !='undefined')this.GetQueryIndex=GetQueryIndex;
if(typeof GetRadioIndex !='undefined')this.GetRadioIndex=GetRadioIndex;
if(typeof InputQueryIndex !='undefined')this.InputQueryIndex=InputQueryIndex;
if(typeof RadioQueryIndex !='undefined')this.RadioQueryIndex=RadioQueryIndex;
if(typeof TestQuery !='undefined')this.TestQuery=TestQuery;
if(typeof mDataobj_Abort !='undefined')this.mDataobj_Abort=mDataobj_Abort;
if(typeof mDataobj_Error !='undefined')this.mDataobj_Error=mDataobj_Error;
if(typeof mDataobj_QueryExecuted !='undefined')this.mDataobj_QueryExecuted=mDataobj_QueryExecuted;
if(typeof BCResultTimeQuery !='undefined')this.BCResultTimeQuery=BCResultTimeQuery;
if(typeof ResultTimeQuery !='undefined')this.ResultTimeQuery=ResultTimeQuery;
if(typeof BCResultRecsQuery !='undefined')this.BCResultRecsQuery=BCResultRecsQuery;
if(typeof ResultRecsQuery !='undefined')this.ResultRecsQuery=ResultRecsQuery;
if(typeof returnConfiguration !='undefined')this.returnConfiguration=returnConfiguration;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.StaticDataList.addTemplateConsumer(this.TRows);
var _this = this;
this.getTitlePortlet().AppendButton({
   id:'apply',
   title:'Applica',
   tooltip:'',
   image:SPTheme.smartEditorApplyImage,
   action: _this.returnConfiguration
})
this.getTitlePortlet().SetTitle('Multi Data Level')
this.getTitlePortlet().SetSubTitle('Data Level Configuration')
this.Var=function(val){
  this.val=val;
  this.Value=function(val){
    if(arguments.length) this.val=val;
    return this.val;
  }
}
var opener = GetOpener();
console.log(opener.itemsHTML[this.objIndex.Value()])
if(!opener) {
  alert( 'No opener!')    
  return;
}
if(!opener.itemsHTML || !opener.itemsHTML[this.objIndex.Value()] || opener.itemsHTML[this.objIndex.Value()].type != 'MLevelDataProvider') {
  alert( 'Invalid object!')    
  return;
}
var mobj = opener.itemsHTML[this.objIndex.Value()];
var jscolumns = mobj.fields.split(',');
var jsrows = mobj.filterfields.split(',');
var jscolumnskeys = mobj.fieldskeys.split(',');
var jsrowskeys = mobj.filterfieldskeys.split(',');
var jsmeasures = mobj.measures.split(',');
var jsqueries = mobj.queries.split(',');
var jsup = mobj.uptolevels.split(',');
var jsup2 = mobj.uptolevels2.split(',');
var cachelevel = parseInt('0'+mobj.cachelevel)
var cachelevel2 = parseInt('0'+mobj.cachelevel2)
var pObj = {};
  pObj.columnfields = [];
  pObj.columnkeys = [];
  pObj.rowfields = [];
  pObj.rowkeys = [];
  pObj.measurefields = [];
var i, j, t, ti;
for( i=0; i<jscolumns.length; i++) {
   pObj.columnfields.push(jscolumns[i])
   pObj.columnkeys.push(jscolumnskeys[i])
}
for( i=0; i<jsrows.length; i++) {
   pObj.rowfields.push(jsrows[i])
   pObj.rowkeys.push(jsrowskeys[i])
}
for( i=0; i<jsmeasures.length; i++) {
   pObj.measurefields.push(jsmeasures[i])
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
var jsupmap = {}
for ( i=0; i<jsup.length; i++ ) {
  if( jsqueries[i] ) {
    if( jsup2[i] ) {
    	jsupmap[jsup[i] + '-' + jsup2[i]] = jsqueries[i]
  	}
  	else {
      jsupmap[jsup[i] + '-' + '0'] = jsqueries[i]
  	}
  }
}
this.StaticDataList.FillData(jslist)
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
    ret+= jsrows[i];
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
    ret+= jscolumns[i];
  }
  return ret;
}
function GetColumnsIndex(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  return (js.column+1)+'';
}
function GetQueryIndex(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  var r = js.row+1, c = js.column+1;
  if( jsupmap[r + '-' + c] ) return jsupmap[r + '-' + c];
  if( jsupmap[r + '-' + '0'] ) return jsupmap[r + '-' + '0'];
  return '';
}
function GetRadioIndex(index) {
	var i;
  var ret = '';
  var js = jslist[index];
  var r = js.row+1, c = js.column+1;
  if( r==cachelevel && c==cachelevel2 )
  	return 'checked';
  return '';
}
function InputQueryIndex(index) {
  var ctrl = _this.TRows.GetCtrl()
  var table = ctrl.children[0];
  var tr = table.rows.item(index+1);
  var vqr = tr.getElementsByClassName('textquery')[0].value;
  var js = jslist[index];
  var r = js.row+1, c = js.column+1;
  jsupmap[r + '-' + c] = vqr;
}
function RadioQueryIndex(index) {
  var js = jslist[index];
  cachelevel = js.row+1;
  cachelevel2 = js.column+1;
}
function TestQuery(index) {
  jslist[index].result = -1;
  jslist[index].recs = -1; 
  ti = index;
  var dobj = this.mDataobj;
  var ctrl = _this.TRows.GetCtrl()
  var table = ctrl.children[0];
  var tr = table.rows.item(index+1);
  var vqr = tr.getElementsByClassName('textquery')[0].value;
	dobj.ChangeQuery(vqr);
  dobj.resetForNewQuery();
  dobj.ChangeConfigPivot(pObj, jslist[index].row+1, jslist[index].column+1)
  
  t = Date.now();
  dobj.Query()
}
function mDataobj_Abort(jsonCause, strMessage){
  jslist[ti].result = '';
  this.StaticDataList.FillData(jslist)
}
function mDataobj_Error(jsonCause, strMessage){
  jslist[ti].result = 'error : ' + strMessage ;
  this.StaticDataList.FillData(jslist)
}
function mDataobj_QueryExecuted(){
  if( Empty(jslist[ti].result) || ( jslist[ti].result == -1 )) {
  	jslist[ti].result = (Date.now() - t);
    jslist[ti].recs = this.mDataobj.GetQueryCount()
  }
  this.StaticDataList.FillData(jslist)
}
function BCResultTimeQuery(index) {
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
function ResultTimeQuery(index) {
  if( !jslist[index].result ) return '';
  if( jslist[index].result == -1 )
		return ''
 	if ((jslist[index].result + "").indexOf('error')>=0)
    return jslist[index].result;
  return Math.round(jslist[index].result/1000) + ' s'
}
function BCResultRecsQuery(index) {
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
function ResultRecsQuery(index) {
  if( !jslist[index].recs ) return '';
  if( jslist[index].recs == -1 )
		return ''
  if ((jslist[index].result + "").indexOf('error')>=0)
    return '';
  return jslist[index].recs + ''
}
function returnConfiguration() {
  var ctrl = _this.TRows.GetCtrl()
  var table = ctrl.children[0];
  var prefetched = 'prefetched', rowindex = 'rowindex', columnindex = 'columnindex', textquery = 'textquery'
  var jsret = {};
  jsret.queries = [];
  jsret.uptolevels = [];
  jsret.uptolevels2 = [];
  
	var rowLength = table.rows.length;
  for (i = 1; i < rowLength; i++){
		var tr = table.rows.item(i);
    jsret.queries.push(tr.getElementsByClassName(textquery)[0].value)
    jsret.uptolevels.push(tr.getElementsByClassName(rowindex)[0].textContent)
    jsret.uptolevels2.push(tr.getElementsByClassName(columnindex)[0].textContent)
    if( tr.getElementsByClassName(prefetched)[0].checked ) {
      jsret.prefetched = {};
      jsret.prefetched.row = tr.getElementsByClassName(rowindex)[0].textContent;
      jsret.prefetched.column = tr.getElementsByClassName(columnindex)[0].textContent;
    }
  }
  if (opener.SetMLevelConfiguration) {
  	opener.SetMLevelConfiguration(_this.objIndex.Value(), jsret);
  }
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
.SPMLevelDataConfig_container .portalstudio_opacity{  opacity: .5
}
.SPMLevelDataConfig_container .portalstudio_opacity{
  opacity: .5
}
.SPMLevelDataConfig_container {
}
.SPMLevelDataConfig_portlet{
  position:relative;
  width:100%;
  min-width:656px;
  height:172px;
}
.SPMLevelDataConfig_portlet[Data-page="1"]{
  height:172px;
  width:100%;
}
.SPMLevelDataConfig_portlet > .TRows_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:6px;
  left:13px;
  left:1.9817073%;
  right:6px;
  right:0.91463417%;
  width:auto;
  height:auto;
  min-height:158px;
}
.SPMLevelDataConfig_portlet > .mDataobj_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:677px;
  left:103.20122%;
  right:-141px;
  right:-21.493902%;
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
 String def="[{\"h\":\"172\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"656\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"158\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Template\",\"w\":\"637\",\"x\":\"13\",\"y\":\"6\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"670\",\"y\":\"-53\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"673\",\"y\":\"-24\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"MLevelDataProvider\",\"w\":\"120\",\"x\":\"677\",\"y\":\"11\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPMLevelDataConfig","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPMLevelDataConfig_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPMLevelDataConfig','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPMLevelDataConfig_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateParser.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateObj.js")%>'></script>
<%}
if(request.getAttribute("SPMLevelDataConfig_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
double objIndex=sp.getParameter("objIndex",0);
if(request.getAttribute("SPMLevelDataConfig_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("MLevelDataProviderObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPMLevelDataConfig_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='SPMLevelDataConfig_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPMLevelDataConfig_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPMLevelDataConfig','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_TRows' class=' TRows_ctrl'></div>
<div id='<%=idPortlet%>_mDataobj' style='position:absolute;top:11px;left:677px;width:120px;height:20px;'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPMLevelDataConfig');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPMLevelDataConfig',["656"],["172"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"656","h":"172","title":"","layer":""}]);
this.TRows=new ZtVWeb.TemplateCtrl(this,{"anchor":"top-left(%)-right(%)","call_stack":"{\"iterator\":\"\",\"key\":\"\",\"data\":\"\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[{\"iterator\":\"a\",\"key\":\"index\",\"data\":\"staticdatalist\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[]}]}","class_Css":"","ctrlid":"<%=idPortlet%>_TRows","h":158,"hide":"false","layer":false,"layout_steps_values":{},"name":"TRows","page":1,"spuid":"","template":"{\"exp\":\"\",\"prefix\":\"\\u003ctable class='portalstudio_grid'\\u003e\\n  \\u003ctr class='grid_row'\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eChoose Prefetched levels\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eRow level\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eRows\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eColumn level\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eColumns\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eSpecify Query by level\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eTest\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eResult Time\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd class='grid_cell_title'\\u003e\\u003cdiv style='text-align:center'\\u003eResult Records\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n   \\u003c\\u002ftr\\u003e \\n  \",\"post\":\"\",\"type\":\"ROOT\",\"attrs\":{},\"nodes\":[{\"exp\":\"%StaticDataList%\",\"prefix\":null,\"post\":\"\\n      \\u003ctr class='\",\"type\":\"EACH\",\"attrs\":{\"iterator\":\"a\",\"key\":\"index\"},\"nodes\":[{\"exp\":\"function:TRCSS(%index%)\",\"prefix\":null,\"post\":\"'\\u003e\\n        \\u003ctd\\u003e\\u003cdiv style='text-align:center'\\u003e\\u003cinput class='prefetched' type=\\\"radio\\\" name=\\\"prefetched\\\" onchange='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".RadioQueryIndex(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")' value=\\\"\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\"\\\"  \",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetRadioIndex(%index%)\",\"prefix\":null,\"post\":\" \\u002f\\u003e\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n        \\u003ctd\\u003e\\u003cdiv class='rowindex' style='text-align:center'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetRowsIndex(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\n            \\u003cdiv style='white-space: nowrap;'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetRows(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\n          \\u003c\\u002ftd\\u003e\\n        \\u003ctd\\u003e\\u003cdiv class='columnindex' style='text-align:center'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetColumnsIndex(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\n            \\u003cdiv style='white-space: nowrap;'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetColumns(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\n          \\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\u003cinput class='portalstudio_textbox textquery' style='width:150px;height:25px' type=\\\"text\\\" value='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:GetQueryIndex(%index%)\",\"prefix\":null,\"post\":\"' onblur='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".InputQueryIndex(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003e\\u003c\\u002ftd\\u003e\\n        \\t\\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".TestQuery(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eTest\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n\\n          \\u003ctd\\u003e\\u003cdiv style='text-align:center;width:100px;\\n                   background-color:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:BCResultTimeQuery(%index%)\",\"prefix\":null,\"post\":\";\\n                   color:white'\\n                   \\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:ResultTimeQuery(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n          \\u003ctd\\u003e\\u003cdiv style='text-align:center;width:70px;\\n                   background-color:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:BCResultRecsQuery(%index%)\",\"prefix\":null,\"post\":\";\\n                   color:white'\\n                   \\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:ResultRecsQuery(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n      \\u003c\\u002ftr\\u003e\\n  \",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]}]},{\"exp\":\"\",\"prefix\":null,\"post\":\"\\n\\u003c\\u002ftable\\u003e\",\"type\":\"END_EACH\",\"attrs\":{},\"nodes\":[]}]}","type":"Template","w":637,"x":13,"y":6,"zindex":"3"});
this.StaticDataList=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataList","dataproviders":"","fieldsString":"","fieldstypeString":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataList","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":670,"y":-53});
this.objIndex=new ZtVWeb._VC(this,'objIndex',null,'numeric',<%=objIndex%>,false,false);
this.mDataobj=new ZtVWeb.MLevelDataProvider(this,{"anchor":"top-left(%)-right(%)","async":false,"cachelevel":0,"cachelevel2":0,"cmdHash":["<%=JSPLib.cmdHash("",request.getSession())%>"],"ctrlid":"<%=idPortlet%>_mDataobj","decrypted_parms":"","encrypted_fields":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"measures":"","name":"mDataobj","page":1,"parms":"","parms_source":"","queries":"","type":"MLevelDataProvider","uptolevels":"","uptolevels2":"","w":120,"x":677,"y":11});
this.mDataobj._FTranslations = {In_Progress:'<%=JSPLib.ToJSValue(sp.translate("MSG_ELABORATION_INPROGRESS"))%>'}
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
<%if(request.getAttribute("SPMLevelDataConfig_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPMLevelDataConfig_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPMLevelDataConfig_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.TRows.Render( {"start_on_load":true} );
ZtVWeb.addPortletObj('<%=idPortlet%>','SPMLevelDataConfig',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPMLevelDataConfig');
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
sp.endPage("SPMLevelDataConfig");
}%>
<%! public String getJSPUID() { return "1395010536"; } %>