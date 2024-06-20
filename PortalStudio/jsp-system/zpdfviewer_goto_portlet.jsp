<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nthis.getTitlePortlet().SetTitle(FormatMsg('MSG_ZPDF_GOTOPAGE'));\nthis.getTitlePortlet().AppendButton({\n            id:'OK',\n            title: FormatMsg('SMR_OK'),\n            tooltip: FormatMsg('SMR_OK'),  \n            action: \"javascript:window.\"+this.formid+\".Execute()\",\n            image: { fontFamily:'icons8_win10', value: \"&#xef8b\"}\n            });\nthis.getTitlePortlet().AppendButton({\n            id:'Cancel',\n            title: FormatMsg('SMR_CANCEL'),\n            tooltip: FormatMsg('SMR_CANCEL'),  \n            action: \"javascript:window.\"+this.formid+\".Cancel()\",\n            image: { fontFamily:'icons8_win10', value: \"&#xf048\"}\n            });\n\nfunction Execute(){\n \tvar opener;\n  if( window.GetOpener )\n    opener = window.GetOpener();\n  if ( opener && opener.GoToPage )\n    opener.GoToPage(this.tNum.Value());\n  else if ( window.parent.GoToPage )\n    window.parent.GoToPage(this.tNum.Value());\n  window.close();\n}\n\nfunction Cancel(){\n  window.close();\n}\n\nfunction tNum_Lostfocus(){\n  var value = this.tNum.Value();\n  if (value\u003c1 || value \u003e this.vTot.Value()){\n    alert('Not valid value!');\n    this.tNum.SetFocus();\n  }\n}\n\n\n\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"52","hsl":"","htmlcode":"{{ labTot }}{{ tNum }}{{ Label2 }}{{ vNum }}{{ vTot }}{{ Image5 }}{{ SPLinker4 }}{{ Button5 }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"500","version":"37","w":"100%","wizard":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"vTot","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"true","layout_steps_values":"{}","n_col":"1","name":"labTot","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"","w":"94","wireframe_props":"align,value,n_col","x":"154","y":"17","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"true","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"tNum","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"2","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"94","wireframe_props":"name","x":"18","y":"16","zerofilling":"false","zindex":"2"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"\u002f","w":"17","wireframe_props":"align,value,n_col","x":"133","y":"19","zindex":"3"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"false","init_par":"request","name":"vTot","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"numeric","w":"58","x":"309","y":"14"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:tNum,vTot*/%>
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
window.zpdfviewer_goto_Static=function(){
if(typeof Execute !='undefined')this.Execute=Execute;
if(typeof Cancel !='undefined')this.Cancel=Cancel;
if(typeof tNum_Lostfocus !='undefined')this.tNum_Lostfocus=tNum_Lostfocus;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(this.vTot.Value(),this.labTot);

this.getTitlePortlet().SetTitle(FormatMsg('MSG_ZPDF_GOTOPAGE'));
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
function Execute(){
 	var opener;
  if( window.GetOpener )
    opener = window.GetOpener();
  if ( opener && opener.GoToPage )
    opener.GoToPage(this.tNum.Value());
  else if ( window.parent.GoToPage )
    window.parent.GoToPage(this.tNum.Value());
  window.close();
}
function Cancel(){
  window.close();
}
function tNum_Lostfocus(){
  var value = this.tNum.Value();
  if (value<1 || value > this.vTot.Value()){
    alert('Not valid value!');
    this.tNum.SetFocus();
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
.zpdfviewer_goto_container {
}
.zpdfviewer_goto_portlet{
  position:relative;
  width:100%;
  min-width:500px;
  height:52px;
}
.zpdfviewer_goto_portlet[Data-page="1"]{
  height:52px;
  width:100%;
}
.zpdfviewer_goto_portlet > .labTot_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:154px;
  left:30.8%;
  right:252px;
  right:50.4%;
  width:auto;
  height:auto;
  min-height:22px;
}
.zpdfviewer_goto_portlet > .labTot_ctrl {
  height:auto;
  min-height:22px;
}
.zpdfviewer_goto_portlet > .labTot_ctrl {
  overflow:hidden;
}
.zpdfviewer_goto_portlet > .tNum_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:16px;
  left:18px;
  left:3.6%;
  right:388px;
  right:77.6%;
  width:auto;
  height:22px;
}
.zpdfviewer_goto_portlet > .tNum_ctrl {
}
.zpdfviewer_goto_portlet > .tNum_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.zpdfviewer_goto_portlet > .Label2_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:19px;
  left:133px;
  left:26.6%;
  right:350px;
  right:70.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.zpdfviewer_goto_portlet > .Label2_ctrl {
  height:auto;
  min-height:20px;
}
.zpdfviewer_goto_portlet > .Label2_ctrl {
  overflow:hidden;
  text-align:left;
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
 String def="[{\"h\":\"52\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"500\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"94\",\"x\":\"154\",\"y\":\"17\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"tNum\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"94\",\"x\":\"18\",\"y\":\"16\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\\u002f\",\"w\":\"17\",\"x\":\"133\",\"y\":\"19\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"vTot\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"58\",\"x\":\"309\",\"y\":\"14\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"zpdfviewer_goto","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/zpdfviewer_goto_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','zpdfviewer_goto','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String labTot= "";
double tNum=sp.getParameter("tNum",0);
if(request.getAttribute("zpdfviewer_goto_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label2= "/";
double vTot=sp.getParameter("vTot",0);
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='zpdfviewer_goto_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='zpdfviewer_goto_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='zpdfviewer_goto_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('zpdfviewer_goto','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_labTot'  formid='<%=idPortlet%>' ps-name='labTot'    class='label labTot_ctrl'><div id='<%=idPortlet%>_labTottbl' style='width:100%;'></div></span>
<span class='textbox-container'id='<%=idPortlet%>_tNum_wrp'><input id='<%=idPortlet%>_tNum' name='tNum' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='tNum' autofocus inputmode='numeric' /></span>
<span id='<%=idPortlet%>_Label2'  formid='<%=idPortlet%>' ps-name='Label2'    class='label Label2_ctrl'><div id='<%=idPortlet%>_Label2tbl' style='width:100%;'><%=JSPLib.ToHTML("/")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','zpdfviewer_goto');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ZPDF_GOTOPAGE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ZPDF_GOTOPAGE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SMR_CANCEL",true)+","+JSPLib.ToJSValue(sp.translate("SMR_CANCEL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SMR_OK",true)+","+JSPLib.ToJSValue(sp.translate("SMR_OK"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','zpdfviewer_goto',["500"],["52"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"500","h":"52","title":"","layer":"false","npage":"1"}]);
this.labTot=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"this.vTot.Value()","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labTot","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"true","layer":false,"layout_steps_values":{},"n_col":1,"name":"labTot","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(labTot,false,true)%>","type":"Label","w":94,"x":154,"y":17,"zindex":"1"});
this.tNum=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tNum","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"tNum","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=tNum%>","w":94,"x":18,"y":16,"zerofilling":false,"zindex":"2","zoom":""});
this.Label2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label2,false,true)%>","type":"Label","w":17,"x":133,"y":19,"zindex":"3"});
this.vTot=new ZtVWeb._VC(this,'vTot',null,'numeric',<%=vTot%>,false,false);
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
<%if(request.getAttribute("zpdfviewer_goto_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("zpdfviewer_goto_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.zpdfviewer_goto_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','zpdfviewer_goto',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'zpdfviewer_goto');
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
sp.endPage("zpdfviewer_goto");
}%>
<%! public String getJSPUID() { return "2763880674"; } %>