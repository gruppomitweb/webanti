<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\nthis.getTitlePortlet().SetTitle(FormatMsg('PIVOT_TITLE_VERSION'))\n\nfunction this_Loaded(){\n  this.PortletVersion.versionName.Value(this.versionName.Value())\n  this.PortletVersion.custom.Value(this.custom.Value())\n  this.PortletVersion.userCode.Value(this.userCode.Value())\n  this.PortletVersion.groupCode.Value(this.groupCode.Value())\n  this.PortletVersion.this_Loaded();\n}\n\nthis.getTitlePortlet().AppendButton({\n   id:'save',\n   title: FormatMsg('MSG_SAVE_CONFIG'),\n   action:function(){ _this.saveVersion()},\n   image:{ fontFamily:'icons8_win10', value: \"&#xecb3\", size: \"20px\"}\n},0)\n\nthis.getTitlePortlet().AppendButton({\n   id:'close',\n   title: FormatMsg('MSG_CLOSE_ONEXIT'),\n   action:function(){ window.close();},\n   image:{ fontFamily:'icons8_win10', value: \"&#xed93\", size: \"20px\"}\n},1)\n\n\nfunction saveVersion() {\n  var oformid = this.OpenerFormId.Value();\n  var opener = GetOpener();\n  if(!Empty(oformid) && opener) {\n    if(opener[oformid] && opener[oformid].SaveConfigVersion) {\n      var versionName = this.PortletVersion.versionName.Value();\n      var custom = this.PortletVersion.custom.Value()\n      var usableBy = this.PortletVersion.usableBy.Value();\n      var userCode = this.PortletVersion.userCode.Value();\n      var groupCode = this.PortletVersion.groupCode.Value()\n      opener[oformid].SaveConfigVersion(versionName, custom, usableBy, userCode, groupCode)\n    }\n  }\n  window.close();\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e\u003cdiv name=\"Portlet0\" index=\"0\" type=\"Portlet\"\u003ePortlet0\u003c\u002fdiv\u003e{{ @PortletVersion }}{{ @PortletVersion }}{{ @PortletVersion }}{{ @PortletVersion }}{{ @PortletVersion }}{{ @PortletVersion }}\u003c\u002fbody\u003e","grapesCss":"","h":"43","hsl":"","htmlcode":"{{ @PortletVersion }} \n \n \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"43\",\"w\":\"100%\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"57","version":"37","w":"100%","wizard":""},{"anchor":"","ctrlOfVariant":"","fixed":"","h":"40","hide":"false","isoptional":"true","layer":"false","layout_steps_values":"{}","name":"PortletVersion","page":"1","rapp":"","sequence":"1","spuid":"","src":"..\u002fjsp-system\u002fSPSelectVersion_portlet.jsp","themed":"true","type":"Portlet","w":"54","wireframe_props":"","x":"0","y":"0","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OpenerFormId","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-12","y":"53"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"versionName","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-15","y":"78"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"userCode","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-10","y":"108"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"groupCode","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-9","y":"137"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"custom","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"logic","w":"176","x":"-12","y":"164"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:OpenerFormId,versionName,userCode,groupCode,custom*/%>
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
window.SPVisualPivotVersion_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof saveVersion !='undefined')this.saveVersion=saveVersion;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var _this = this;
this.getTitlePortlet().SetTitle(FormatMsg('PIVOT_TITLE_VERSION'))
function this_Loaded(){
  this.PortletVersion.versionName.Value(this.versionName.Value())
  this.PortletVersion.custom.Value(this.custom.Value())
  this.PortletVersion.userCode.Value(this.userCode.Value())
  this.PortletVersion.groupCode.Value(this.groupCode.Value())
  this.PortletVersion.this_Loaded();
}
this.getTitlePortlet().AppendButton({
   id:'save',
   title: FormatMsg('MSG_SAVE_CONFIG'),
   action:function(){ _this.saveVersion()},
   image:{ fontFamily:'icons8_win10', value: "&#xecb3", size: "20px"}
},0)
this.getTitlePortlet().AppendButton({
   id:'close',
   title: FormatMsg('MSG_CLOSE_ONEXIT'),
   action:function(){ window.close();},
   image:{ fontFamily:'icons8_win10', value: "&#xed93", size: "20px"}
},1)
function saveVersion() {
  var oformid = this.OpenerFormId.Value();
  var opener = GetOpener();
  if(!Empty(oformid) && opener) {
    if(opener[oformid] && opener[oformid].SaveConfigVersion) {
      var versionName = this.PortletVersion.versionName.Value();
      var custom = this.PortletVersion.custom.Value()
      var usableBy = this.PortletVersion.usableBy.Value();
      var userCode = this.PortletVersion.userCode.Value();
      var groupCode = this.PortletVersion.groupCode.Value()
      opener[oformid].SaveConfigVersion(versionName, custom, usableBy, userCode, groupCode)
    }
  }
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
.SPVisualPivotVersion_container {
  height:100%;
  overflow:auto;
}
.SPVisualPivotVersion_portlet{
  position:relative;
  width:100%;
  min-width:57px;
  height:100%;
}
.SPVisualPivotVersion_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.SPVisualPivotVersion_portlet > .PortletVersion_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:3px;
  right:5.263158%;
  width:auto;
  height:auto;
  min-height:40px;
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
 String def="[{\"h\":\"43\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"57\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"40\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"54\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-12\",\"y\":\"53\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-15\",\"y\":\"78\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-10\",\"y\":\"108\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-9\",\"y\":\"137\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-12\",\"y\":\"164\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVisualPivotVersion","UTF-8")) {return; }
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
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPVisualPivotVersion_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPVisualPivotVersion','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String OpenerFormId=JSPLib.translateXSS(sp.getParameter("OpenerFormId",""));
String versionName=JSPLib.translateXSS(sp.getParameter("versionName",""));
String userCode=JSPLib.translateXSS(sp.getParameter("userCode",""));
String groupCode=JSPLib.translateXSS(sp.getParameter("groupCode",""));
boolean custom=sp.getParameter("custom",false);
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPVisualPivotVersion_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='SPVisualPivotVersion_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPVisualPivotVersion_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPVisualPivotVersion','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletVersion'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/SPSelectVersion_portlet.jsp?ForcedPortletUID="+idPortlet+"_1y7nkbi",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/SPSelectVersion_portlet.jsp?ForcedPortletUID="+idPortlet+"_1y7nkbi",true)) 
  Library.includeResource(request,response,"/jsp-system/SPSelectVersion_portlet.jsp?ForcedPortletUID="+idPortlet+"_1y7nkbi",true);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPVisualPivotVersion');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CLOSE_ONEXIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CLOSE_ONEXIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SAVE_CONFIG",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SAVE_CONFIG"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("PIVOT_TITLE_VERSION",true)+","+JSPLib.ToJSValue(sp.translate("PIVOT_TITLE_VERSION"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPVisualPivotVersion',["57"],["43"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"57","h":"43","title":"","layer":""}]);
if(this.PortletVersion=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletVersion')){
this.PortletVersion.setContainer(this,'PortletVersion')
this.PortletVersion_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_PortletVersion","h":40,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletVersion","page":1,"portlet_id":"<%=idPortlet%>_1y7nkbi","spuid":"","type":"Portlet","w":54,"x":0,"y":0,"zindex":"1"});
} else {
document.getElementById('<%=idPortlet%>_PortletVersion').style.display='none';
}
this.OpenerFormId=new ZtVWeb._VC(this,'OpenerFormId',null,'character','<%=JSPLib.ToJSValue(OpenerFormId,false,true)%>',false,false);
this.versionName=new ZtVWeb._VC(this,'versionName',null,'character','<%=JSPLib.ToJSValue(versionName,false,true)%>',false,false);
this.userCode=new ZtVWeb._VC(this,'userCode',null,'character','<%=JSPLib.ToJSValue(userCode,false,true)%>',false,false);
this.groupCode=new ZtVWeb._VC(this,'groupCode',null,'character','<%=JSPLib.ToJSValue(groupCode,false,true)%>',false,false);
this.custom=new ZtVWeb._VC(this,'custom',null,'logic',<%=custom%>,false,false);
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
<%if(request.getAttribute("SPVisualPivotVersion_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPVisualPivotVersion_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPVisualPivotVersion_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPVisualPivotVersion',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPVisualPivotVersion');
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
sp.endPage("SPVisualPivotVersion");
}%>
<%! public String getJSPUID() { return "1159470133"; } %>