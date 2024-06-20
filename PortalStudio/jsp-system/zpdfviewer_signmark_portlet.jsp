<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nthis.getTitlePortlet().SetTitle(FormatMsg('MSG_ZPDF_EDIT_SIGNMARK'));\nthis.getTitlePortlet().AppendButton({\n            id:'OK',\n            title: FormatMsg('SMR_OK'),\n            tooltip: FormatMsg('SMR_OK'),  \n            action: \"javascript:window.\"+this.formid+\".Execute()\",\n            image: { fontFamily:'icons8_win10', value: \"&#xef8b\"}\n            });\nthis.getTitlePortlet().AppendButton({\n            id:'Cancel',\n            title: FormatMsg('SMR_CANCEL'),\n            tooltip: FormatMsg('SMR_CANCEL'),  \n            action: \"javascript:window.\"+this.formid+\".Cancel()\",\n            image: { fontFamily:'icons8_win10', value: \"&#xf048\"}\n            });\n\n\nfunction this_Loaded(){\n  var labels = this.vGroupsList.Value();\n  var values = this.vGroupsListKeys.Value();\n  if( Empty(labels) ) labels = values;\n  this.cSignMarkGroup.FillDataStatic(values, labels)\n  \n  \u002f\u002fSe c'è solo un firmatario disponibile lo mostro già selezionato nella combo, altrimenti mostro il gruppo di firma iniziale\n  if(values){\n    var valuesArray = values.split(\",\");\n    \n  \tif(valuesArray.length == 1)\n      this.cSignMarkGroup.Value(values);\n  \telse\n  \t\tthis.cSignMarkGroup.Value(this.vSignMarkGroup.Value());\n  }\n  else{\n    this.cSignMarkGroup.Value('');\n  }\n  \n  var opener;\n  if( window.GetOpener )\n    opener = window.GetOpener();\n  if( opener && opener.SelectSignMark )\n  \topener.SelectSignMark(this.vSignMarkID.Value())\n  else if ( window.parent.SelectSignMark )\n    window.parent.SelectSignMark(this.vSignMarkID.Value())\n}\n\nfunction Execute(){\n \tvar opener;\n  if( window.GetOpener )\n    opener = window.GetOpener();\n  var check = true;\n  if( opener && opener.CheckUniqueSignMarkKey )\n    check = opener.CheckUniqueSignMarkKey(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());\n  else if ( window.parent.CheckUniqueSignMarkKey )\n    check = window.parent.CheckUniqueSignMarkKey(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());\n  if( !check ) {\n    alert( FormatMsg('MSG_KEY_ALREADY_USED') );\n    return;\n  } \n  if ( opener && opener.SetSignMarkInfo )\n    opener.SetSignMarkInfo(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());\n  else if ( window.parent.SetSignMarkInfo )\n    window.parent.SetSignMarkInfo(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());\n  window.close();\n}\n\nfunction Cancel(){\n  window.close();\n}\n\n\n\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"60","hsl":"","htmlcode":"{{ vGroupsListKeys }}\n{{ labTot }}{{ tNum }}{{ Label2 }}{{ vNum }}{{ vTot }}{{ Image5 }}{{ SPLinker4 }}{{ Button5 }}{{ Label4 }}{{ tSignMarkName }}{{ Label6 }}{{ cSignMarkGroup }}{{ vSignMarkID }}{{ vGroupsList }}{{ vSignMarkGroup }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"300","version":"37","w":"100%","wizard":""},{"anchor":"top-left","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Nome della zona di firma","hide":"false","hide_undercond":"True","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"tSignMarkName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"160","wireframe_props":"name","x":"650","y":"81","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Firma per","w":"80","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"3"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"","font_size":"","h":"20","help_tips":"Firmatario a cui verrà assegnata la zona di firma","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","name":"cSignMarkGroup","page":"1","picture":"","sequence":"4","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"189","wireframe_props":"name,textlist","x":"93","y":"20","zindex":"4"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"vSignMarkID","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"653","y":"-28"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"vGroupsList","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"653","y":"-1"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"vSignMarkGroup","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"653","y":"26"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"vGroupsListKeys","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"653","y":"53"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:tSignMarkName,vSignMarkID,vGroupsList,vSignMarkGroup,vGroupsListKeys*/%>
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
window.zpdfviewer_signmark_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Execute !='undefined')this.Execute=Execute;
if(typeof Cancel !='undefined')this.Cancel=Cancel;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.tSignMarkName);
}

this.getTitlePortlet().SetTitle(FormatMsg('MSG_ZPDF_EDIT_SIGNMARK'));
this.getTitlePortlet().AppendButton({
            id:'OK',
            title: FormatMsg('SMR_OK'),
            tooltip: FormatMsg('SMR_OK'),  
            action: "javascript:window."+this.formid+".Execute()",
            image: { fontFamily:'icons8_win10', value: "&#xef8b"}
            });
this.getTitlePortlet().AppendButton({
            id:'Cancel',
            title: FormatMsg('SMR_CANCEL'),
            tooltip: FormatMsg('SMR_CANCEL'),  
            action: "javascript:window."+this.formid+".Cancel()",
            image: { fontFamily:'icons8_win10', value: "&#xf048"}
            });
function this_Loaded(){
  var labels = this.vGroupsList.Value();
  var values = this.vGroupsListKeys.Value();
  if( Empty(labels) ) labels = values;
  this.cSignMarkGroup.FillDataStatic(values, labels)
  
  //Se c'è solo un firmatario disponibile lo mostro già selezionato nella combo, altrimenti mostro il gruppo di firma iniziale
  if(values){
    var valuesArray = values.split(",");
    
  	if(valuesArray.length == 1)
      this.cSignMarkGroup.Value(values);
  	else
  		this.cSignMarkGroup.Value(this.vSignMarkGroup.Value());
  }
  else{
    this.cSignMarkGroup.Value('');
  }
  
  var opener;
  if( window.GetOpener )
    opener = window.GetOpener();
  if( opener && opener.SelectSignMark )
  	opener.SelectSignMark(this.vSignMarkID.Value())
  else if ( window.parent.SelectSignMark )
    window.parent.SelectSignMark(this.vSignMarkID.Value())
}
function Execute(){
 	var opener;
  if( window.GetOpener )
    opener = window.GetOpener();
  var check = true;
  if( opener && opener.CheckUniqueSignMarkKey )
    check = opener.CheckUniqueSignMarkKey(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());
  else if ( window.parent.CheckUniqueSignMarkKey )
    check = window.parent.CheckUniqueSignMarkKey(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());
  if( !check ) {
    alert( FormatMsg('MSG_KEY_ALREADY_USED') );
    return;
  } 
  if ( opener && opener.SetSignMarkInfo )
    opener.SetSignMarkInfo(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());
  else if ( window.parent.SetSignMarkInfo )
    window.parent.SetSignMarkInfo(this.vSignMarkID.Value(), this.tSignMarkName.Value(), this.cSignMarkGroup.Value());
  window.close();
}
function Cancel(){
  window.close();
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
.zpdfviewer_signmark_container {
}
.zpdfviewer_signmark_portlet{
  position:relative;
  width:100%;
  min-width:300px;
  height:60px;
}
.zpdfviewer_signmark_portlet[Data-page="1"]{
  height:60px;
  width:100%;
}
.zpdfviewer_signmark_portlet > .tSignMarkName_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.zpdfviewer_signmark_portlet > .tSignMarkName_ctrl {
  display:none;
}
.zpdfviewer_signmark_portlet > .tSignMarkName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.zpdfviewer_signmark_portlet > .Label6_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  width:80px;
  height:auto;
  min-height:20px;
}
.zpdfviewer_signmark_portlet > .Label6_ctrl {
  height:auto;
  min-height:20px;
}
.zpdfviewer_signmark_portlet > .Label6_ctrl {
  overflow:hidden;
  text-align:right;
}
.zpdfviewer_signmark_portlet > .cSignMarkGroup_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:20px;
  left:93px;
  width:189px;
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
 String def="[{\"h\":\"60\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"300\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tSignMarkName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"160\",\"x\":\"650\",\"y\":\"81\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Firma per\",\"w\":\"80\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"3\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cSignMarkGroup\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"189\",\"x\":\"93\",\"y\":\"20\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"vSignMarkID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"653\",\"y\":\"-28\"},{\"h\":\"20\",\"name\":\"vGroupsList\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"653\",\"y\":\"-1\"},{\"h\":\"20\",\"name\":\"vSignMarkGroup\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"653\",\"y\":\"26\"},{\"h\":\"20\",\"name\":\"vGroupsListKeys\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"653\",\"y\":\"53\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"zpdfviewer_signmark","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/zpdfviewer_signmark_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','zpdfviewer_signmark','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String tSignMarkName=JSPLib.translateXSS(sp.getParameter("tSignMarkName",""));
if(request.getAttribute("zpdfviewer_signmark_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label6= "Firma per";
String cSignMarkGroup= "";
String vSignMarkID=JSPLib.translateXSS(sp.getParameter("vSignMarkID",""));
String vGroupsList=JSPLib.translateXSS(sp.getParameter("vGroupsList",""));
String vSignMarkGroup=JSPLib.translateXSS(sp.getParameter("vSignMarkGroup",""));
String vGroupsListKeys=JSPLib.translateXSS(sp.getParameter("vGroupsListKeys",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='zpdfviewer_signmark_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='zpdfviewer_signmark_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='zpdfviewer_signmark_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('zpdfviewer_signmark','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_tSignMarkName_wrp'><input id='<%=idPortlet%>_tSignMarkName' name='tSignMarkName' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='tSignMarkName' /></span>
<span id='<%=idPortlet%>_Label6'  formid='<%=idPortlet%>' ps-name='Label6'    class='label Label6_ctrl'><div id='<%=idPortlet%>_Label6tbl' style='width:100%;'><%=JSPLib.ToHTML("Firma per")%></div></span>
<select id='<%=idPortlet%>_cSignMarkGroup' name='cSignMarkGroup' class='combobox' title=<%=JSPLib.ToHTMLValue("Firmatario a cui verrà assegnata la zona di firma" )%> style=''></select>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','zpdfviewer_signmark');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_KEY_ALREADY_USED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_KEY_ALREADY_USED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ZPDF_EDIT_SIGNMARK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ZPDF_EDIT_SIGNMARK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SMR_CANCEL",true)+","+JSPLib.ToJSValue(sp.translate("SMR_CANCEL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SMR_OK",true)+","+JSPLib.ToJSValue(sp.translate("SMR_OK"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','zpdfviewer_signmark',["300"],["60"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"300","h":"60","title":"","layer":"false","npage":"1"}]);
this.tSignMarkName=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tSignMarkName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"Nome della zona di firma","hide":"false","hide_undercond":"true","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"tSignMarkName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tSignMarkName,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"2","zoom":""});
this.Label6=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6,false,true)%>","type":"Label","w":80,"x":5,"y":20,"zindex":"3"});
this.cSignMarkGroup=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cSignMarkGroup","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"Firmatario a cui verrà assegnata la zona di firma","hide":"false","hide_undercond":"","init":"false","init_par":"<%=cSignMarkGroup%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cSignMarkGroup","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":189,"x":93,"y":20,"zindex":"4"});
this.vSignMarkID=new ZtVWeb._VC(this,'vSignMarkID',null,'character','<%=JSPLib.ToJSValue(vSignMarkID,false,true)%>',false,false);
this.vGroupsList=new ZtVWeb._VC(this,'vGroupsList',null,'character','<%=JSPLib.ToJSValue(vGroupsList,false,true)%>',false,false);
this.vSignMarkGroup=new ZtVWeb._VC(this,'vSignMarkGroup',null,'character','<%=JSPLib.ToJSValue(vSignMarkGroup,false,true)%>',false,false);
this.vGroupsListKeys=new ZtVWeb._VC(this,'vGroupsListKeys',null,'character','<%=JSPLib.ToJSValue(vGroupsListKeys,false,true)%>',false,false);
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
<%if(request.getAttribute("zpdfviewer_signmark_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("zpdfviewer_signmark_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.zpdfviewer_signmark_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.cSignMarkGroup.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','zpdfviewer_signmark',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'zpdfviewer_signmark');
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
sp.endPage("zpdfviewer_signmark");
}%>
<%! public String getJSPUID() { return "2372025147"; } %>