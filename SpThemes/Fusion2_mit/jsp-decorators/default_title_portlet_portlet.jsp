<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\n\nvar areaExpandImage  ,\n    areaCollapseImage ,\n    areaExpand ,\n    areaCollapse;\n\n\nfunction this_Loaded(){\n\n    areaExpandImage = GetStyleVariable( \"areaExpandImage\", \"\" ),\n    areaCollapseImage = GetStyleVariable( \"areaCollapseImage\", \"\" );\n\n    areaExpand = LibJavascript.DOM.GenerateIcon(\n      areaExpandImage,\n      '',\n      \u002f\u002f'line-height:'+this.icon.Ctrl.offsetHeight+'px'\n      'line-height:'+this.icon.h+'px'    \t\n    );\n\n    areaCollapse = LibJavascript.DOM.GenerateIcon(\n      areaCollapseImage,\n      '',\n      \u002f\u002f'line-height:'+this.icon.Ctrl.offsetHeight+'px'\n      'line-height:'+this.icon.h+'px'    \t\n    );\n\n    this.icon.Ctrl.innerHTML = (this.opened.Value() !== 'true') ? areaExpand : areaCollapse;\n\n}\n\n\n\nfunction ExpanCollapse(){\n  if( this.opened.Value() !== 'true'){\n    this.icon.Ctrl.innerHTML = areaCollapse;\n    show(this);\n    this.opened.Set(\"true\");\n  } else {\n    this.icon.Ctrl.innerHTML = areaExpand;\n    hide(this);\n    this.opened.Set(\"false\");\n  }\n}\nthis.icon.Ctrl.addEventListener(\"click\", ExpanCollapse.bind(this));\n\nthis.lbl_title.Value(this.title.Value());\n\nif(this.draggable.Value() == \"true\"){\n  this.Ctrl.style.cursor = \"move\";\n  \u002f* per permettere il drag, se non e' presente del testo nella label viene rilevato l'evento click dello span e il drag non viene registrato *\u002f\n  if( Empty(this.lbl_title.Value()))\n    this.lbl_title.Value(' ');\n}","adaptive":"","bg_image":"..\u002fimages\u002fportalstudio_background_title.gif","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"type\":\"undefined_type\",\"name\":\"IconCollapseExpand\",\"selector\":\".IconCollapseExpand img\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"table\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"\\\",\\\"align\\\":\\\"\\\",\\\"cursor\\\":\\\"pointer\\\",\\\"mar_top\\\":\\\"auto\\\",\\\"mar_bottom\\\":\\\"auto\\\",\\\"mar_left\\\":\\\"auto\\\",\\\"mar_right\\\":\\\"auto\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"IconCollapseExpand\\\",\\\"selector\\\":\\\".IconCollapseExpand img\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"id\\\":\\\"form\\\",\\\"display\\\":\\\"table\\\",\\\"font_color\\\":\\\"\\\",\\\"align\\\":\\\"\\\",\\\"cursor\\\":\\\"pointer\\\",\\\"mar_top\\\":\\\"auto\\\",\\\"mar_bottom\\\":\\\"auto\\\",\\\"mar_left\\\":\\\"auto\\\",\\\"mar_right\\\":\\\"auto\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".IconCollapseExpand img {\\n  display: table;\\n  margin: auto auto auto auto;\\n  cursor: pointer;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"IconCollapseExpand\",\"selector\":\".IconCollapseExpand a\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"block\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"\\\",\\\"align\\\":\\\"center\\\",\\\"cursor\\\":\\\"pointer\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"IconCollapseExpand\\\",\\\"selector\\\":\\\".IconCollapseExpand a\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"id\\\":\\\"form\\\",\\\"display\\\":\\\"block\\\",\\\"font_color\\\":\\\"\\\",\\\"align\\\":\\\"center\\\",\\\"cursor\\\":\\\"pointer\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".IconCollapseExpand a {\\n  display: block;\\n  cursor: pointer;\\n  text-align: center;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"block\",\"border_type\":\"solid\",\"shadow_type\":\"outline\",\"font_color\":\"rgba(255, 255, 255, 0.70)\",\"align\":\"center\",\"cursor\":\"pointer\",\"code\":\"-webkit-user-select: none;\\n-moz-user-select: none;\\n-ms-user-select: none;\\nuser-select: none;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"IconCollapseExpand\",\"selector\":\".IconCollapseExpand\",\"id\":\"form\",\"code\":\".IconCollapseExpand {\\n  display: block;\\n  -webkit-user-select: none;\\n  -moz-user-select: none;\\n  -ms-user-select: none;\\n  user-select: none;\\n  cursor: pointer;\\n  color: rgba(255, 255, 255, 0.70);\\n  text-align: center;\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"40","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{\"170\":{\"h\":\"40\",\"w\":\"100%\"},\"400\":{\"h\":\"40\",\"w\":\"100%\"},\"600\":{\"h\":\"40\",\"w\":\"100%\"},\"-1\":{\"h\":\"40\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"240","version":"37","w":"100%","wizard":""},{"align":"","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"27","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"","name":"lbl_title","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"request:title","w":"193","wireframe_props":"align,value,n_col","x":"9","y":"9","zindex":"1"},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"BackgroundTitleBox","create_undercond":"","h":"40","hide":"","hide_undercond":"","href":"","layout_steps_values":"{}","name":"background","page":"1","sequence":"1","shrinkable":"","stretch":"false","target":"","type":"Box","w":"240","wireframe_props":"","x":"0","y":"0","zindex":"0"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"title","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"103","x":"0","y":"57"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"content_url","page":"1","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"103","x":"0","y":"80"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"content_area","page":"1","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"103","x":"0","y":"103"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"opened","page":"1","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"103","x":"0","y":"126"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"0","class_Css":"IconCollapseExpand","create_undercond":"","h":"32","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"icon","page":"1","sequence":"11","shrinkable":"","stretch":"false","target":"","type":"Box","w":"32","wireframe_props":"","x":"205","y":"4","zindex":"5"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"draggable","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"103","x":"0","y":"149"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:title,content_url,content_area,opened,draggable*/%>
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
window.default_title_portlet_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof ExpanCollapse !='undefined')this.ExpanCollapse=ExpanCollapse;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>

var areaExpandImage  ,
    areaCollapseImage ,
    areaExpand ,
    areaCollapse;
function this_Loaded(){
    areaExpandImage = GetStyleVariable( "areaExpandImage", "" ),
    areaCollapseImage = GetStyleVariable( "areaCollapseImage", "" );
    areaExpand = LibJavascript.DOM.GenerateIcon(
      areaExpandImage,
      '',
      //'line-height:'+this.icon.Ctrl.offsetHeight+'px'
      'line-height:'+this.icon.h+'px'    	
    );
    areaCollapse = LibJavascript.DOM.GenerateIcon(
      areaCollapseImage,
      '',
      //'line-height:'+this.icon.Ctrl.offsetHeight+'px'
      'line-height:'+this.icon.h+'px'    	
    );
    this.icon.Ctrl.innerHTML = (this.opened.Value() !== 'true') ? areaExpand : areaCollapse;
}
function ExpanCollapse(){
  if( this.opened.Value() !== 'true'){
    this.icon.Ctrl.innerHTML = areaCollapse;
    show(this);
    this.opened.Set("true");
  } else {
    this.icon.Ctrl.innerHTML = areaExpand;
    hide(this);
    this.opened.Set("false");
  }
}
this.icon.Ctrl.addEventListener("click", ExpanCollapse.bind(this));
this.lbl_title.Value(this.title.Value());
if(this.draggable.Value() == "true"){
  this.Ctrl.style.cursor = "move";
  
  if( Empty(this.lbl_title.Value()))
    this.lbl_title.Value(' ');
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
.default_title_portlet_container .IconCollapseExpand img{  display: table;
  margin-top: auto;
  margin-right: auto;
  margin-bottom: auto;
  margin-left: auto;
  cursor: pointer;
}
.default_title_portlet_container .IconCollapseExpand a{
  display: block;
  cursor: pointer;
  text-align: center;
}
.default_title_portlet_container .IconCollapseExpand{
  display: block;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  cursor: pointer;
  color: rgba(255, 255, 255, 0.70);
  text-align: center;
}
.default_title_portlet_container {
}
.default_title_portlet_portlet{
  position:relative;
  width:100%;
  min-width:240px;
  height:40px;
  background-color:transparent;
  background-image:url(../images/portalstudio_background_title.gif);
}
.default_title_portlet_portlet[Data-page="1"]{
  height:40px;
  width:100%;
}
.default_title_portlet_portlet > .lbl_title_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:9px;
  right:38px;
  width:auto;
  height:auto;
  min-height:27px;
}
.default_title_portlet_portlet > .lbl_title_ctrl {
  height:auto;
  min-height:27px;
}
.default_title_portlet_portlet > .lbl_title_ctrl {
  overflow:hidden;
}
.default_title_portlet_portlet > .background_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:40px;
  display:flex;
  flex-direction:column;
}
.default_title_portlet_portlet > .background_ctrl {
  height:40px;
}
.default_title_portlet_portlet > .background_ctrl > .box_content {
  height:100%;
}
.default_title_portlet_portlet > .background_ctrl {
  min-height:40px;
}
.default_title_portlet_portlet > .icon_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:4px;
  right:3px;
  width:32px;
  height:auto;
  min-height:32px;
  display:flex;
  flex-direction:column;
}
.default_title_portlet_portlet > .icon_ctrl {
  height:32px;
}
.default_title_portlet_portlet > .icon_ctrl > .box_content {
  height:100%;
}
.default_title_portlet_portlet > .icon_ctrl {
  min-height:32px;
  border-width:0px;
  border-style:solid;
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
 String def="[{\"h\":\"40\",\"layout_steps_values\":{\"-1\":{\"h\":\"40\",\"w\":\"100%\"},\"170\":{\"h\":\"40\",\"w\":\"100%\"},\"400\":{\"h\":\"40\",\"w\":\"100%\"},\"600\":{\"h\":\"40\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"240\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"\",\"anchor\":\"top-left-right\",\"h\":\"27\",\"layout_steps_values\":{},\"n_col\":\"\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"request:title\",\"w\":\"193\",\"x\":\"9\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"40\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"240\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"103\",\"x\":\"0\",\"y\":\"57\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"103\",\"x\":\"0\",\"y\":\"80\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"103\",\"x\":\"0\",\"y\":\"103\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"103\",\"x\":\"0\",\"y\":\"126\"},{\"anchor\":\"top-right\",\"h\":\"32\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"32\",\"x\":\"205\",\"y\":\"4\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"103\",\"x\":\"0\",\"y\":\"149\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"default_title_portlet","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default_title_portlet_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','default_title_portlet','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lbl_title=JSPLib.translateXSS(sp.getParameter("title",""),"title",request);
String title=JSPLib.translateXSS(sp.getParameter("title",""));
String content_url=JSPLib.translateXSS(sp.getParameter("content_url",""));
String content_area=JSPLib.translateXSS(sp.getParameter("content_area",""));
String opened=JSPLib.translateXSS(sp.getParameter("opened",""));
String draggable=JSPLib.translateXSS(sp.getParameter("draggable",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='default_title_portlet_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='default_title_portlet_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('default_title_portlet','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lbl_title'  formid='<%=idPortlet%>' ps-name='lbl_title'    class='TitleLabel lbl_title_ctrl'><div id='<%=idPortlet%>_lbl_titletbl' style='width:100%;'><%=Library.ToHTMLRepresentation(sp.translate(lbl_title),"","")%></div></span>
<div id='<%=idPortlet%>_background' class='background_ctrl SPSection_expanded BackgroundTitleBox' data-original-display='flex'><div id='<%=idPortlet%>_background_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_icon' class='icon_ctrl SPSection_expanded IconCollapseExpand' data-original-display='flex'><div id='<%=idPortlet%>_icon_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','default_title_portlet');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','default_title_portlet',["240"],["40"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{"-1":{"h":"40","w":"100%"},"170":{"h":"40","w":"100%"},"400":{"h":"40","w":"100%"},"600":{"h":"40","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"400":{"w":"100%","h":"40"},"-1":{"w":"100%","h":"40"},"600":{"w":"100%","h":"40"},"170":{"w":"100%","h":"40"}},"w":"240","h":"40","title":"","layer":"false","npage":"1"}]);
this.lbl_title=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_title","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":27,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_title","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_title),false,true)%>","type":"Label","w":193,"x":9,"y":9,"zindex":"1"});
this.background=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"BackgroundTitleBox","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_background","groupName":"","h":40,"hide":"","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"background","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":240,"x":0,"y":0,"zindex":"0"});
this.title=new ZtVWeb._VC(this,'title',null,'character','<%=JSPLib.ToJSValue(title,false,true)%>',false,false);
this.content_url=new ZtVWeb._VC(this,'content_url',null,'character','<%=JSPLib.ToJSValue(content_url,false,true)%>',false,false);
this.content_area=new ZtVWeb._VC(this,'content_area',null,'character','<%=JSPLib.ToJSValue(content_area,false,true)%>',false,false);
this.opened=new ZtVWeb._VC(this,'opened',null,'character','<%=JSPLib.ToJSValue(opened,false,true)%>',false,false);
this.icon=new ZtVWeb.BoxCtrl(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"0","class_Css":"IconCollapseExpand","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_icon","groupName":"","h":32,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"icon","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":32,"x":205,"y":4,"zindex":"5"});
this.draggable=new ZtVWeb._VC(this,'draggable',null,'character','<%=JSPLib.ToJSValue(draggable,false,true)%>',false,false);
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
<%if(request.getAttribute("default_title_portlet_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("default_title_portlet_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.default_title_portlet_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','default_title_portlet',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'default_title_portlet');
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
sp.endPage("default_title_portlet");
}%>
<%! public String getJSPUID() { return "2320849173"; } %>