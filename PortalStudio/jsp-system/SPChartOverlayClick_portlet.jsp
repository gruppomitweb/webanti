<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n\tvar macroType = getZFChartMacroType(this.type.Value()),\n      font = { name : \"Open Sans\", size : 11, style : \"normal\", weight : \"normal\" },\n      sizes,\n      icon,\n      ifr,\n      tabs = document.getElementById(this.formid + \"_tabcontainer\"),\n      _this = this;\n  \n  this.tcont.GetCtrl().innerHTML = \"\";\n  \n  switch (macroType) {\n    case \"xyz\":\n    case \"geo\":\n    case \"hie\":\n    case \"dep\":\n      break;\n    case \"classif\":\n      sizes = this.createTooltipClassif(font);\n      sizes.w += 5;\n      break;\n    default:\t\u002f\u002f category\n      break;\n  }\n  \n  if (window.parent && window.parent.document.getElementById(this.id.Value() + \"tooltipI\")) {\n    ifr = window.parent.document.getElementById(this.id.Value() + \"tooltipI\");\n    ifr.contentDocument.body.style.overflow = \"hidden\";\n  }\n  \n  this.tcont.GetCtrl().style.width = sizes.w + \"px\";\n  this.tcont.GetCtrl().style.height = sizes.h + \"px\";\n  \n  this.Ctrl.style.width = (sizes.w + 10) + \"px\";\n  this.Ctrl.style.minWidth = (sizes.w + 10) + \"px\";\n  this.Ctrl.style.height = (sizes.h + 10) + \"px\";\n\n  var color = \"#FAFAFA\";\n  this.Ctrl.style.backgroundColor = toRgbA(color);\n  this.Ctrl.style.border = \"solid 1px \" + color;\n  this.Ctrl.style.borderRadius = \"5px\";\n  \n  this.Ctrl_container.style.width = (sizes.w + 10) + \"px\";\n  this.Ctrl_container.style.height = (sizes.h + 10) + \"px\";\n  this.Ctrl_container.style.borderRadius = \"5px\";\n\n  var span = this.GetSpan();\n  span.parentNode.removeChild(span);\n\n  setTimeout(function () {   \n    if (window.parent && window.parent.document.getElementById(_this.id.Value() + \"tooltipDiv\")) {\n      ifr = window.parent.document.getElementById(_this.id.Value() + \"tooltipDiv\");\n      ifr.style.width = (sizes.w + 10) + \"px\";\n      ifr.style.height = (sizes.h + 10) + \"px\";\n    }\n  }, 100);\n}\n\nfunction createTooltipClassif(font) {\n  var ser = this.category.Value().split(\"::\"),\n      cols = this.colors.Value().split(\"::\"),\n      ixs = this.idxs.Value().split(\"::\"),\n      cont,\n      retsize = { w: 0, h: 0 },\n      _this = this;\n  \n  for (var i = 0; i \u003c parseInt(this.num.Value()); i++) {\n \t\tcont = document.createElement(\"div\");\n    cont.className = \"contbox\";\n    cont.style.cursor = \"pointer\";\n    cont.setAttribute(\"chart-item\", ixs[i]);\n    cont.onclick = function(e){ _this.onClick(this, e); }\n    this.tcont.GetCtrl().appendChild(cont);\n    this.createColorRect(cols[i], cont);\n    this.createColorDesc(ser[i], cont);\n    retsize.w = Math.max(retsize.w, this.GetOffsetWidth(ser[i], font) + 20);\n    retsize.h += cont.offsetHeight;\n  }\n\n  return retsize;\n}\n\nfunction createColorRect(bcolor, cont) {\n\tvar div = document.createElement(\"div\");\n  div.className = \"colorrect\";\n  var color = bcolor.indexOf(\"rgb\") \u003e= 0 ? bcolor : \"#\" + bcolor;\n  div.style.backgroundColor = toRgbA(color);\n  cont.appendChild(div);\n}\n\nfunction createColorDesc(desc, cont) {\n\tvar div = document.createElement(\"div\");\n  div.className = \"labelTP\";\n  div.textContent = desc;\n  cont.appendChild(div);\n}\n\nfunction onClick(src, evt) {\n  if (src) {\n\t\tvar index = parseInt(src.getAttribute(\"chart-item\")),\n        chart;\n    if (window.parent && window.parent.myZtCharts) {\n    \tchart = window.parent.myZtCharts[this.id.Value()];\n      chart.StdChart._ApplyClickOverlap(chart.StdChart._GetItems()[index], evt);\n    }\n  }\n}\n\n\u002f**** GENERICHE ****\u002f\nfunction GetOffsetHeight(labelText, labelFont) {\n\tvar mySpan = this.GetSpan();\n\tif (labelText != \"\") {\n\t\tmySpan.textContent = labelText;\n\t\tmySpan.style.fontFamily = labelFont.name;\n\t\tmySpan.style.fontStyle = labelFont.style;\n\t\tmySpan.style.fontWeight = labelFont.weight;\n\t\tmySpan.style.fontSize = labelFont.size+'px';\n\t\treturn mySpan.offsetHeight;\n\t}\n\telse\n\t\treturn 0;\n}\n\nfunction GetOffsetWidth(labelText, labelFont) {\n\tvar mySpan = this.GetSpan();\n\tif (labelText != \"\") {\n\t\tmySpan.textContent = labelText;\n\t\tmySpan.style.fontFamily = labelFont.name;\n\t\tmySpan.style.fontStyle = labelFont.style;\n\t\tmySpan.style.fontWeight = labelFont.weight;\n\t\tmySpan.style.fontSize = labelFont.size+'px';\n\t\treturn mySpan.offsetWidth;\n\t}\n\telse\n\t\treturn 0;\n}\n\nfunction GetSpan() {\n\tvar spanId = this.formid + \"myspan\",\n\tmySpan = document.getElementById(spanId);\n\tif (Empty(mySpan)) {\n\t\tmySpan = document.createElement(\"div\");\n\t\tmySpan.id = spanId;\n\t\tthis.Ctrl_container.appendChild(mySpan); \n\t\tmySpan.style.visibility = 'hidden';\n\t\tmySpan.style.display = 'inline-block';\n    mySpan.style.whiteSpace = \"nowrap\";\n    mySpan.style.width = \"auto\";\n    mySpan.style.height = \"auto\";\n    mySpan.style.position = \"absolute\";\n\t}\n\treturn mySpan;\n}\n\nfunction toRgbA(col){\n  var c,\n      hex = col.indexOf(\"#\") \u003e= 0 ? col : \"\",\n      rgb = col;\n  if (!Empty(hex)) {\n    if(\u002f^#([A-Fa-f0-9]{3}){1,2}$\u002f.test(hex)){\n      c= hex.substring(1).split('');\n      if(c.length== 3){\n        c= [c[0], c[0], c[1], c[1], c[2], c[2]];\n      }\n      c= '0x'+c.join('');\n      return 'rgb('+[(c\u003e\u003e16)&255, (c\u003e\u003e8)&255, c&255].join(',')+')';\n    }\n  }\n  else {\n  \treturn rgb;\n  }\n  throw new Error('Bad Hex');\n}\n\n","adaptive":"fixed","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"left top","css":"ChartObj.css","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"border_type\":\"solid\",\"shadow_type\":\"outline\",\"font\":\"Open Sans, sans-serif\",\"size\":\"11px\",\"weight\":\"normal\",\"style\":\"normal\",\"decoration\":\"none\",\"transform\":\"none\",\"font_color\":\"#0D0F12\",\"align\":\"left\",\"code\":\"white-space: nowrap;\\noverflow: visible !important;\\nfloat: left;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"labelTP\",\"selector\":\".labelTP\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".labelTP {\\n  white-space: nowrap;\\n  overflow: visible !important;\\n  float: left;\\n  font-family: Open Sans, sans-serif;\\n  color: #0D0F12;\\n  text-decoration: none;\\n  text-transform: none;\\n  font-style: normal;\\n  font-weight: normal;\\n  font-size: 11px;\\n  text-align: left;\\n}\\n\",\"fontoffline\":\"Open Sans, sans-serif\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"width: 15px;\\nheight: 15px;\\nfloat: left;\",\"max_width\":\"\",\"max_height\":\"\",\"min_width\":\"\",\"min_height\":\"\",\"pad_bottom\":\"\",\"pad_right\":\"\",\"mar_right\":\"5px\"},\"hover\":{},\":before\":{},\":after\":{\"content\":\"\",\"code\":\"\"}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"box\",\"class_name\":\"colorrect\",\"selector\":\".colorrect\",\"id\":\"form\",\"code\":\".colorrect {\\n  margin-right: 5px;\\n  width: 15px;\\n  height: 15px;\\n  float: left;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"width: 99%;\\nheight: 20px;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"box\",\"class_name\":\"contbox\",\"selector\":\".contbox\",\"id\":\"form\",\"code\":\".contbox {\\n  width: 99%;\\n  height: 20px;\\n}\\n\"}]","description":"","fixed_top":"true","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"100","hsl":"","htmlcode":"{{ colors }}\n{{ id }}\n{{ tcont }}\n{{ num }}\n{{ type }}\n{{ serie }}\n{{ category }}\n{{ idxs }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"ZtChartFunctions.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"250","wizard":""},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"colors","page":"1","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"300","y":"-2"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"id","page":"1","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"-2"},{"anchor":"","bg_color":"transparent","border_color":"transparent","border_weight":"0","class_Css":"box","create_undercond":"","h":"90","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"tcont","page":"1","sequence":"3","shrinkable":"","stretch":"false","target":"","type":"Box","w":"240","wireframe_props":"","x":"5","y":"5","zindex":"14"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"num","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"300","y":"23"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"type","page":"1","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"300","y":"48"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"serie","page":"1","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"23"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"category","page":"1","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"48"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"idxs","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"570","y":"-2"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:colors,id,num,type,serie,category,idxs*/%>
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
window.SPChartOverlayClick_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof createTooltipClassif !='undefined')this.createTooltipClassif=createTooltipClassif;
if(typeof createColorRect !='undefined')this.createColorRect=createColorRect;
if(typeof createColorDesc !='undefined')this.createColorDesc=createColorDesc;
if(typeof onClick !='undefined')this.onClick=onClick;
if(typeof GetOffsetHeight !='undefined')this.GetOffsetHeight=GetOffsetHeight;
if(typeof GetOffsetWidth !='undefined')this.GetOffsetWidth=GetOffsetWidth;
if(typeof GetSpan !='undefined')this.GetSpan=GetSpan;
if(typeof toRgbA !='undefined')this.toRgbA=toRgbA;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
	var macroType = getZFChartMacroType(this.type.Value()),
      font = { name : "Open Sans", size : 11, style : "normal", weight : "normal" },
      sizes,
      icon,
      ifr,
      tabs = document.getElementById(this.formid + "_tabcontainer"),
      _this = this;
  
  this.tcont.GetCtrl().innerHTML = "";
  
  switch (macroType) {
    case "xyz":
    case "geo":
    case "hie":
    case "dep":
      break;
    case "classif":
      sizes = this.createTooltipClassif(font);
      sizes.w += 5;
      break;
    default:	// category
      break;
  }
  
  if (window.parent && window.parent.document.getElementById(this.id.Value() + "tooltipI")) {
    ifr = window.parent.document.getElementById(this.id.Value() + "tooltipI");
    ifr.contentDocument.body.style.overflow = "hidden";
  }
  
  this.tcont.GetCtrl().style.width = sizes.w + "px";
  this.tcont.GetCtrl().style.height = sizes.h + "px";
  
  this.Ctrl.style.width = (sizes.w + 10) + "px";
  this.Ctrl.style.minWidth = (sizes.w + 10) + "px";
  this.Ctrl.style.height = (sizes.h + 10) + "px";
  var color = "#FAFAFA";
  this.Ctrl.style.backgroundColor = toRgbA(color);
  this.Ctrl.style.border = "solid 1px " + color;
  this.Ctrl.style.borderRadius = "5px";
  
  this.Ctrl_container.style.width = (sizes.w + 10) + "px";
  this.Ctrl_container.style.height = (sizes.h + 10) + "px";
  this.Ctrl_container.style.borderRadius = "5px";
  var span = this.GetSpan();
  span.parentNode.removeChild(span);
  setTimeout(function () {   
    if (window.parent && window.parent.document.getElementById(_this.id.Value() + "tooltipDiv")) {
      ifr = window.parent.document.getElementById(_this.id.Value() + "tooltipDiv");
      ifr.style.width = (sizes.w + 10) + "px";
      ifr.style.height = (sizes.h + 10) + "px";
    }
  }, 100);
}
function createTooltipClassif(font) {
  var ser = this.category.Value().split("::"),
      cols = this.colors.Value().split("::"),
      ixs = this.idxs.Value().split("::"),
      cont,
      retsize = { w: 0, h: 0 },
      _this = this;
  
  for (var i = 0; i < parseInt(this.num.Value()); i++) {
 		cont = document.createElement("div");
    cont.className = "contbox";
    cont.style.cursor = "pointer";
    cont.setAttribute("chart-item", ixs[i]);
    cont.onclick = function(e){ _this.onClick(this, e); }
    this.tcont.GetCtrl().appendChild(cont);
    this.createColorRect(cols[i], cont);
    this.createColorDesc(ser[i], cont);
    retsize.w = Math.max(retsize.w, this.GetOffsetWidth(ser[i], font) + 20);
    retsize.h += cont.offsetHeight;
  }
  return retsize;
}
function createColorRect(bcolor, cont) {
	var div = document.createElement("div");
  div.className = "colorrect";
  var color = bcolor.indexOf("rgb") >= 0 ? bcolor : "#" + bcolor;
  div.style.backgroundColor = toRgbA(color);
  cont.appendChild(div);
}
function createColorDesc(desc, cont) {
	var div = document.createElement("div");
  div.className = "labelTP";
  div.textContent = desc;
  cont.appendChild(div);
}
function onClick(src, evt) {
  if (src) {
		var index = parseInt(src.getAttribute("chart-item")),
        chart;
    if (window.parent && window.parent.myZtCharts) {
    	chart = window.parent.myZtCharts[this.id.Value()];
      chart.StdChart._ApplyClickOverlap(chart.StdChart._GetItems()[index], evt);
    }
  }
}
function GetOffsetHeight(labelText, labelFont) {
	var mySpan = this.GetSpan();
	if (labelText != "") {
		mySpan.textContent = labelText;
		mySpan.style.fontFamily = labelFont.name;
		mySpan.style.fontStyle = labelFont.style;
		mySpan.style.fontWeight = labelFont.weight;
		mySpan.style.fontSize = labelFont.size+'px';
		return mySpan.offsetHeight;
	}
	else
		return 0;
}
function GetOffsetWidth(labelText, labelFont) {
	var mySpan = this.GetSpan();
	if (labelText != "") {
		mySpan.textContent = labelText;
		mySpan.style.fontFamily = labelFont.name;
		mySpan.style.fontStyle = labelFont.style;
		mySpan.style.fontWeight = labelFont.weight;
		mySpan.style.fontSize = labelFont.size+'px';
		return mySpan.offsetWidth;
	}
	else
		return 0;
}
function GetSpan() {
	var spanId = this.formid + "myspan",
	mySpan = document.getElementById(spanId);
	if (Empty(mySpan)) {
		mySpan = document.createElement("div");
		mySpan.id = spanId;
		this.Ctrl_container.appendChild(mySpan); 
		mySpan.style.visibility = 'hidden';
		mySpan.style.display = 'inline-block';
    mySpan.style.whiteSpace = "nowrap";
    mySpan.style.width = "auto";
    mySpan.style.height = "auto";
    mySpan.style.position = "absolute";
	}
	return mySpan;
}
function toRgbA(col){
  var c,
      hex = col.indexOf("#") >= 0 ? col : "",
      rgb = col;
  if (!Empty(hex)) {
    if(/^#([A-Fa-f0-9]{3}){1,2}$/.test(hex)){
      c= hex.substring(1).split('');
      if(c.length== 3){
        c= [c[0], c[0], c[1], c[1], c[2], c[2]];
      }
      c= '0x'+c.join('');
      return 'rgb('+[(c>>16)&255, (c>>8)&255, c&255].join(',')+')';
    }
  }
  else {
  	return rgb;
  }
  throw new Error('Bad Hex');
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
.SPChartOverlayClick_container .labelTP{  white-space: nowrap;
  overflow: visible !important;
  float: left;
  font-family: Open Sans, sans-serif;
  color: #0D0F12;
  text-decoration: none;
  text-transform: none;
  font-style: normal;
  font-weight: normal;
  font-size: 11px;
  text-align: left;
}
.SPChartOverlayClick_container .colorrect{
  margin-right: 5px;
  width: 15px;
  height: 15px;
  float: left;
}
.SPChartOverlayClick_container .contbox{
  width: 99%;
  height: 20px;
}
.SPChartOverlayClick_container {
}
.SPChartOverlayClick_portlet{
  position:relative;
  width:250px;
  min-width:250px;
  height:100px;
}
.SPChartOverlayClick_portlet[Data-page="1"]{
  height:100px;
  width:250px;
}
.SPChartOverlayClick_portlet > .tcont_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  width:240px;
  height:auto;
  min-height:90px;
  display:flex;
  flex-direction:column;
}
.SPChartOverlayClick_portlet > .tcont_ctrl {
  height:90px;
}
.SPChartOverlayClick_portlet > .tcont_ctrl > .box_content {
  height:100%;
}
.SPChartOverlayClick_portlet > .tcont_ctrl {
  min-height:90px;
  background-color:transparent;
  border-width:0px;
  border-style:solid;
  border-color:transparent;
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
 String def="[{\"h\":\"100\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"250\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"300\",\"y\":\"-2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"-2\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"240\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"14\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"300\",\"y\":\"23\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"300\",\"y\":\"48\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"23\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"48\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"570\",\"y\":\"-2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPChartOverlayClick","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPChartOverlayClick_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><link href='../<%=SPPrxycizer.proxycizedPath("fonts/OpenSans.css", SPPrxycizer.Mode.QUERYSTRING)%>' rel='stylesheet' type='text/css'>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("ChartObj.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("ChartObj.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("ChartObj.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/ChartObj.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("ZtChartFunctions.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPChartOverlayClick','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String colors=JSPLib.translateXSS(sp.getParameter("colors",""));
String id=JSPLib.translateXSS(sp.getParameter("id",""));
double num=sp.getParameter("num",0);
String type=JSPLib.translateXSS(sp.getParameter("type",""));
String serie=JSPLib.translateXSS(sp.getParameter("serie",""));
String category=JSPLib.translateXSS(sp.getParameter("category",""));
String idxs=JSPLib.translateXSS(sp.getParameter("idxs",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPChartOverlayClick_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPChartOverlayClick_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPChartOverlayClick','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_tcont' class='tcont_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_tcont_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPChartOverlayClick');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPChartOverlayClick',["250"],["100"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','','true',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"250","h":"100","title":"","layer":"false","npage":"1"}]);
this.colors=new ZtVWeb._VC(this,'colors',null,'character','<%=JSPLib.ToJSValue(colors,false,true)%>',false,false);
this.id=new ZtVWeb._VC(this,'id',null,'character','<%=JSPLib.ToJSValue(id,false,true)%>',false,false);
this.tcont=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"transparent","border_color":"transparent","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_tcont","groupName":"","h":90,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"tcont","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":240,"x":5,"y":5,"zindex":"14"});
this.num=new ZtVWeb._VC(this,'num',null,'numeric',<%=num%>,false,false);
this.type=new ZtVWeb._VC(this,'type',null,'character','<%=JSPLib.ToJSValue(type,false,true)%>',false,false);
this.serie=new ZtVWeb._VC(this,'serie',null,'character','<%=JSPLib.ToJSValue(serie,false,true)%>',false,false);
this.category=new ZtVWeb._VC(this,'category',null,'character','<%=JSPLib.ToJSValue(category,false,true)%>',false,false);
this.idxs=new ZtVWeb._VC(this,'idxs',null,'character','<%=JSPLib.ToJSValue(idxs,false,true)%>',false,false);
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
<%if(request.getAttribute("SPChartOverlayClick_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPChartOverlayClick_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPChartOverlayClick_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPChartOverlayClick',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPChartOverlayClick');
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
sp.endPage("SPChartOverlayClick");
}%>
<%! public String getJSPUID() { return "3570298185"; } %>