<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var boxHeaderExpandImage = GetStyleVariable( \"boxHeaderExpandImage\", \"\" ),\n    boxHeaderCollapseImage = GetStyleVariable( \"boxHeaderCollapseImage\", \"\" );\n\nif (boxHeaderExpandImage!='') {\n\tthis.close.Ctrl.innerHTML = ( LibJavascript.DOM.GenerateIcon(boxHeaderExpandImage) );\n  this.close.Ctrl.addEventListener(\"click\", image_Click.bind(this));\n} else {\n  this.close.Hide();\n}\n\nif (boxHeaderCollapseImage!='') {\n\tthis.open.Ctrl.innerHTML = ( LibJavascript.DOM.GenerateIcon(boxHeaderCollapseImage) );\n  this.open.Ctrl.addEventListener(\"click\", image_Click.bind(this));\n} else {\n  this.open.Hide();\n}\n\nfunction image_Click(){\n  if(!Empty(this.m_cPortletId.Value())){\n    if(this.m_cBoxIsCollasible.Value() == 'true'){\n    \twindow[this.m_cPortletId.Value()][this.m_cBoxId.Value()].ToggleCollapse();\n    }\n  }else{\n    ToggleCollapsibleBox(this.m_cBoxId.Value());\n  }\n}\n\nfunction CAPTION_Click(){\n  if(!Empty(this.m_cPortletId.Value())){\n    if(this.m_cBoxIsCollasible.Value() == 'true'){\n      window[this.m_cPortletId.Value()][this.m_cBoxId.Value()].ToggleCollapse();\n    }\n    \n  }else{\n    ToggleCollapsibleBox(this.m_cBoxId.Value());\n  }\n}\n\nif ( !Empty(this.m_nTabIndex.Value()) && SPTheme.boxHeaderTabIndex ) {\t\n  this.CAPTION.GetCtrl().tabIndex = this.m_nTabIndex.Value();\n} else {\n  this.CAPTION.GetCtrl().tabIndex = -1;\n}\nthis.CAPTION.Value(this.m_cCaption.Value());\nLibJavascript.Events.addEvent(this.CAPTION.GetCtrl(),'keydown',function(e) {\n  e=e?e:window.event;\n  var keyCode = GetKeyCode(e);\n  if (keyCode==13) {\n    this.CAPTION_Click();\n  }\n}.bind(this));\n\nfunction this_Loaded(){\n  if(!Empty(this.m_cPortletId.Value()) && this.m_cBoxIsCollasible.Value() != 'true'){\n\t  this.open.Hide();\n    this.close.Hide();\n    this.CAPTION.Ctrl.style.cursor = 'default';\n  }\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet BoxHeader","css_code":"[{\"type\":\"label\",\"name\":\"TitleBoxLabel\",\"selector\":\".TitleBoxLabel\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_left\\\":\\\"10px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"-ms-user-select: none; \u002f* IE 10+ *\u002f\\\\n-moz-user-select: -moz-none;\\\\n-khtml-user-select: none;\\\\n-webkit-user-select: none;\\\\nuser-select: none;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"TitleBoxLabel\\\",\\\"selector\\\":\\\".TitleBoxLabel\\\",\\\"value\\\":\\\"\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"pad_left\\\":\\\"10px\\\",\\\"code\\\":\\\"-ms-user-select: none; \u002f* IE 10+ *\u002f\\\\n-moz-user-select: -moz-none;\\\\n-khtml-user-select: none;\\\\n-webkit-user-select: none;\\\\nuser-select: none;\\\"}\",\"code\":\".TitleBoxLabel {\\n  padding: 0 0 0 10px;\\n  -ms-user-select: none;\\n \u002f* IE 10+ *\u002f\\n  -moz-user-select: -moz-none;\\n  -khtml-user-select: none;\\n  -webkit-user-select: none;\\n  user-select: none;\\n}\\n\"},{\"type\":\"image\",\"name\":\"TitleIcon\",\"selector\":\".TitleIcon\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"font-weight:bold;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Coustard\\\",\\\"Antic Slab\\\",\\\"Quattrocento\\\",\\\"Cinzel\\\",\\\"Josefin Slab\\\",\\\"Merriweather\\\",\\\"Lora\\\",\\\"Nunito\\\",\\\"Abel\\\",\\\"Fjalla One\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Raleway\\\",\\\"Montserrat\\\",\\\"Roboto Condensed\\\",\\\"Oswald\\\",\\\"Special Elite\\\",\\\"Fredoka One\\\",\\\"Comfortaa\\\",\\\"Bangers\\\",\\\"Righteous\\\",\\\"Sigmar One\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Lobster\\\",\\\"Nova Mono\\\",\\\"Inconsolata\\\",\\\"Source Code Pro\\\",\\\"Anonymous Pro\\\",\\\"Roboto Mono\\\",\\\"Amatic SC\\\",\\\"Shadows Into Light\\\",\\\"Dancing Script\\\",\\\"Pacifico\\\",\\\"Indie Flower\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"src\\\"],\\\"type\\\":\\\"image\\\",\\\"class_name\\\":\\\"TitleIcon\\\",\\\"selector\\\":\\\".TitleIcon\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"src\\\":\\\".\u002fimages\u002fdefault.jpg\\\",\\\"id\\\":\\\"form\\\",\\\"code\\\":\\\"font-weight:bold;\\\"}\",\"code\":\".TitleIcon {\\n  font-weight: bold;\\n}\\n\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"{{ background }}{{ CAPTION }}{{ open }}{{ close }}{{ background }}{{ CAPTION }}{{ open }}{{ close }}{{ @background }}{{ @CAPTION }}{{ @open }}{{ @close }}","grapesCss":"","h":"25","hsl":"","htmlcode":"{{ m_cBoxIsCollasible }}\n{{ background }}\n{{ CAPTION }}\n{{ m_cTheme }}\n{{ m_cBoxId }}\n{{ m_cCaption }}\n{{ m_cInitialState }}\n{{ m_nTabIndex }}\n{{ open }}\n{{ close }}\n{{ m_cPortletId }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"25\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"100","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"background_title_box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"25","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"background","page":"1","rapp":"","sequence":"1","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"100","wireframe_props":"","x":"0","y":"0","zindex":"0","zone":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"BoxHeaderCaption","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"CAPTION","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"73","wireframe_props":"align,value,n_col","x":"23","y":"4","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cTheme","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"459","y":"-42"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cBoxId","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"459","y":"-9"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cCaption","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"459","y":"24"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cInitialState","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"459","y":"57"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_nTabIndex","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"numeric","w":"122","x":"459","y":"90"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"BoxHeaderIcon BoxHeaderIconOpen","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"open","page":"1","rapp":"","sequence":"7","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"20","y":"4","zindex":"8","zone":""},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"BoxHeaderIcon BoxHeaderIconClose","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"close","page":"1","rapp":"","sequence":"8","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"20","y":"4","zindex":"9","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cPortletId","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"459","y":"128"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cBoxIsCollasible","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"459","y":"164"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:m_cTheme,m_cBoxId,m_cCaption,m_cInitialState,m_nTabIndex,m_cPortletId,m_cBoxIsCollasible*/%>
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
window.default_title_box_Static=function(){
if(typeof image_Click !='undefined')this.image_Click=image_Click;
if(typeof CAPTION_Click !='undefined')this.CAPTION_Click=CAPTION_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var boxHeaderExpandImage = GetStyleVariable( "boxHeaderExpandImage", "" ),
    boxHeaderCollapseImage = GetStyleVariable( "boxHeaderCollapseImage", "" );
if (boxHeaderExpandImage!='') {
	this.close.Ctrl.innerHTML = ( LibJavascript.DOM.GenerateIcon(boxHeaderExpandImage) );
  this.close.Ctrl.addEventListener("click", image_Click.bind(this));
} else {
  this.close.Hide();
}
if (boxHeaderCollapseImage!='') {
	this.open.Ctrl.innerHTML = ( LibJavascript.DOM.GenerateIcon(boxHeaderCollapseImage) );
  this.open.Ctrl.addEventListener("click", image_Click.bind(this));
} else {
  this.open.Hide();
}
function image_Click(){
  if(!Empty(this.m_cPortletId.Value())){
    if(this.m_cBoxIsCollasible.Value() == 'true'){
    	window[this.m_cPortletId.Value()][this.m_cBoxId.Value()].ToggleCollapse();
    }
  }else{
    ToggleCollapsibleBox(this.m_cBoxId.Value());
  }
}
function CAPTION_Click(){
  if(!Empty(this.m_cPortletId.Value())){
    if(this.m_cBoxIsCollasible.Value() == 'true'){
      window[this.m_cPortletId.Value()][this.m_cBoxId.Value()].ToggleCollapse();
    }
    
  }else{
    ToggleCollapsibleBox(this.m_cBoxId.Value());
  }
}
if ( !Empty(this.m_nTabIndex.Value()) && SPTheme.boxHeaderTabIndex ) {	
  this.CAPTION.GetCtrl().tabIndex = this.m_nTabIndex.Value();
} else {
  this.CAPTION.GetCtrl().tabIndex = -1;
}
this.CAPTION.Value(this.m_cCaption.Value());
LibJavascript.Events.addEvent(this.CAPTION.GetCtrl(),'keydown',function(e) {
  e=e?e:window.event;
  var keyCode = GetKeyCode(e);
  if (keyCode==13) {
    this.CAPTION_Click();
  }
}.bind(this));
function this_Loaded(){
  if(!Empty(this.m_cPortletId.Value()) && this.m_cBoxIsCollasible.Value() != 'true'){
	  this.open.Hide();
    this.close.Hide();
    this.CAPTION.Ctrl.style.cursor = 'default';
  }
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
.default_title_box_container .TitleBoxLabel{  padding-left: 10px;
  -ms-user-select: none; /* IE 10+ */
  -moz-user-select: -moz-none;
  -khtml-user-select: none;
  -webkit-user-select: none;
  user-select: none;
}
.default_title_box_container .TitleIcon{
  font-weight:bold;
}
.default_title_box_container {
}
.default_title_box_portlet{
  position:relative;
  width:100%;
  min-width:100px;
  height:25px;
}
.default_title_box_portlet[Data-page="1"]{
  height:25px;
  width:100%;
}
.default_title_box_portlet > .background_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:25px;
  display:flex;
  flex-direction:column;
}
.default_title_box_portlet > .background_ctrl {
  height:25px;
}
.default_title_box_portlet > .background_ctrl > .box_content {
  height:100%;
}
.default_title_box_portlet > .background_ctrl {
  min-height:25px;
}
.default_title_box_portlet > .CAPTION_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:23px;
  right:4px;
  width:auto;
  height:auto;
  min-height:20px;
}
.default_title_box_portlet > .CAPTION_ctrl {
  height:auto;
  min-height:20px;
}
.default_title_box_portlet > .CAPTION_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.default_title_box_portlet > .open_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:4px;
  left:20px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.default_title_box_portlet > .open_ctrl {
  height:20px;
}
.default_title_box_portlet > .open_ctrl > .box_content {
  height:100%;
}
.default_title_box_portlet > .open_ctrl {
  min-height:20px;
}
.default_title_box_portlet > .close_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:4px;
  left:20px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.default_title_box_portlet > .close_ctrl {
  height:20px;
}
.default_title_box_portlet > .close_ctrl > .box_content {
  height:100%;
}
.default_title_box_portlet > .close_ctrl {
  min-height:20px;
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
 String def="[{\"h\":\"25\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"73\",\"x\":\"23\",\"y\":\"4\",\"zindex\":\"1\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"-42\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"-9\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"24\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"57\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"90\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"20\",\"y\":\"4\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"20\",\"y\":\"4\",\"zindex\":\"9\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"128\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"459\",\"y\":\"164\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"default_title_box","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default_title_box_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','default_title_box','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String CAPTION= "";
String m_cTheme=JSPLib.translateXSS(sp.getParameter("m_cTheme",""));
String m_cBoxId=JSPLib.translateXSS(sp.getParameter("m_cBoxId",""));
String m_cCaption=JSPLib.translateXSS(sp.getParameter("m_cCaption",""));
String m_cInitialState=JSPLib.translateXSS(sp.getParameter("m_cInitialState",""));
double m_nTabIndex=sp.getParameter("m_nTabIndex",0);
String m_cPortletId=JSPLib.translateXSS(sp.getParameter("m_cPortletId",""));
String m_cBoxIsCollasible=JSPLib.translateXSS(sp.getParameter("m_cBoxIsCollasible",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='default_title_box_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='default_title_box_portlet portlet BoxHeader' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('default_title_box','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_background' class='background_ctrl SPSection_expanded background_title_box' data-original-display='flex'><div id='<%=idPortlet%>_background_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_CAPTION'  formid='<%=idPortlet%>' ps-name='CAPTION'    class='BoxHeaderCaption CAPTION_ctrl'><div id='<%=idPortlet%>_CAPTIONtbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_open' class='open_ctrl SPSection_expanded BoxHeaderIcon BoxHeaderIconOpen' data-original-display='flex'><div id='<%=idPortlet%>_open_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_close' class='close_ctrl SPSection_expanded BoxHeaderIcon BoxHeaderIconClose' data-original-display='flex'><div id='<%=idPortlet%>_close_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','default_title_box');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','default_title_box',["100"],["25"],'portlet BoxHeader',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"25","title":"","layer":""}]);
this.background=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"background_title_box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_background","groupName":"","h":25,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"background","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":100,"x":0,"y":0,"zindex":"0"});
this.CAPTION=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"BoxHeaderCaption","create_undercond":"","ctrlid":"<%=idPortlet%>_CAPTION","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"CAPTION","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(CAPTION,false,true)%>","type":"Label","w":73,"x":23,"y":4,"zindex":"1"});
this.m_cTheme=new ZtVWeb._VC(this,'m_cTheme',null,'character','<%=JSPLib.ToJSValue(m_cTheme,false,true)%>',false,false);
this.m_cBoxId=new ZtVWeb._VC(this,'m_cBoxId',null,'character','<%=JSPLib.ToJSValue(m_cBoxId,false,true)%>',false,false);
this.m_cCaption=new ZtVWeb._VC(this,'m_cCaption',null,'character','<%=JSPLib.ToJSValue(m_cCaption,false,true)%>',false,false);
this.m_cInitialState=new ZtVWeb._VC(this,'m_cInitialState',null,'character','<%=JSPLib.ToJSValue(m_cInitialState,false,true)%>',false,false);
this.m_nTabIndex=new ZtVWeb._VC(this,'m_nTabIndex',null,'numeric',<%=m_nTabIndex%>,false,false);
this.open=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"BoxHeaderIcon BoxHeaderIconOpen","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_open","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"open","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":20,"y":4,"zindex":"8"});
this.close=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"BoxHeaderIcon BoxHeaderIconClose","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_close","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"close","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":20,"y":4,"zindex":"9"});
this.m_cPortletId=new ZtVWeb._VC(this,'m_cPortletId',null,'character','<%=JSPLib.ToJSValue(m_cPortletId,false,true)%>',false,false);
this.m_cBoxIsCollasible=new ZtVWeb._VC(this,'m_cBoxIsCollasible',null,'character','<%=JSPLib.ToJSValue(m_cBoxIsCollasible,false,true)%>',false,false);
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
<%if(request.getAttribute("default_title_box_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("default_title_box_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.default_title_box_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','default_title_box',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'default_title_box');
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
sp.endPage("default_title_box");
}%>
<%! public String getJSPUID() { return "214479874"; } %>