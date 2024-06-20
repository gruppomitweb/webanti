<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nm_cProgName=\"spadministration_groups_zoom\";\ndocument.title=FormatMsg('CP_GROUPS');\n\nfunction this_Loaded(){\n  window.resizeTo(480,500);\n  window.moveTo(100,100);\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.SetTitle(FormatMsg('CP_GROUPS'));\n  customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n                             'javascript:Help()','',FormatMsg('ADMIN_HELP'),FormatMsg('ADMIN_HELP')) \n  customToolbar.RearrangeAll();\n}\n\nvar groupsDisabled=null, groupsEnabled=null;\n  \u003c%\n    java.util.ArrayList userParameter = new java.util.ArrayList();\n\t\t\n    if (disableGroupsOf!=0) {\n      userParameter.add(disableGroupsOf);\n      out.print(\"groupsDisabled='\"+JSPLib.ToJSValue(sp.callFunction(\"\",\"spadministration_getgrouplist\",userParameter))+\"'.trim().split(\u002f *, *\u002f);\");\n    }\n%\u003e\n\n  \u003c%\n    if (enableGroupsOf!=0) {\n      userParameter.add(enableGroupsOf);\n      out.print(\"groupsEnabled='\"+JSPLib.ToJSValue(sp.callFunction(\"\",\"spadministration_getgrouplist\",userParameter))+\"'.trim().split(\u002f *, *\u002f);\");\n    }\n%\u003e\n\nfunction parentNodeEnabled(node) {\n  var parentNode = node.nodeFather;\n  if (typeof(parentNode)=='string' || parentNode.rs.code==\"\" || groupsEnabled.indexOf(parentNode.rs.code) ==-1 ) \u002f\u002fsono al primo livello\n    return false;\n  else \n    return true;\n}\nfunction StdTreeView_Groups_Rendered() {\n  if ( groupsDisabled !=null || groupsEnabled !=null ) {\n  \tvar nodes = this.StdTreeView_Groups.Tree.allnodes, node, i, htmlelement;\n\t\tfor (i=0;i\u003cnodes.length;i++) {\n    \tnode=nodes[i];\n    \tif (node.rs.code!=\"\" && node.nodeFather==this.StdTreeView_Groups.currentnode){ \u002f\u002fescludo root e modifico solo i nuovi caricati\n      \thtmlelement = document.getElementById(node.nodeDiv+'_element');\n      \tif (groupsDisabled !=null && groupsDisabled.indexOf(node.rs.code) \u003e-1 ) {\n        \thtmlelement.style.opacity='0.5';\n      \t} else if (groupsEnabled !=null) {\n        \tif ( groupsEnabled.indexOf(node.rs.code) ==-1 || this.parentNodeEnabled(node) ) { \u002f\u002f se il padre e' abilitato io devo essere disabilitato\n        \t\thtmlelement.style.opacity='0.5';\n        \t} else {\n          \thtmlelement.style.opacity='1';\n        \t}\n      \t} else {\n        \thtmlelement.style.opacity='1';\n      \t}\n    \t}\n  \t}\n  }\n}\n\nfunction select_group(code){\n  if (groupsEnabled!=null && (groupsEnabled.indexOf(this.StdTreeView_Groups.rs.code)==-1 || this.parentNodeEnabled(this.StdTreeView_Groups.currentnode) ) ) {\n    alert(FormatMsg('MSG_USER_NOT_BELONGS_TO_ROLE'));\n  } else if (groupsDisabled!=null && groupsDisabled.indexOf(this.StdTreeView_Groups.rs.code)\u003e-1) {\n    alert(FormatMsg('MSG_USER_BELONGS_TO_ROLE'));\n  } else {\n  \tZtVWeb.DoLinkZoom('\u003c%=sp.getParameter(\"UID\",\"NOT_FROM_ZOOM\")%\u003e',this.StdTreeView_Groups.rs.code,'\u003c%=sp.getParameter(\"OpenerFormId\",\"\")%\u003e');\n  \tWindowClose();\n  }\n}\n\nfunction GetNodeIcon(group_type){\n  if(group_type=='R')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_role.png\")%\u003e';\n  else if(group_type=='D')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_descriptive.gif\")%\u003e';\n  else if(group_type=='O')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_organizational.gif\")%\u003e';\n  else if(group_type=='S')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_sharing.gif\")%\u003e';\n  else\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_group.png\")%\u003e';\n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"172","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"administrator","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","tag":"","title":"default","title_url":"","type":"Form","v_line":"300","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"true","count":"false","h":"30","localDBName":"","n_records":"1000000","name":"dataobj_groups","offline":"false","page":"1","parms":"code,pgrptype","parms_source":"StdTreeView_Groups","query":"spquery_groupstree","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"30","x":"1","y":"-42"},{"anchor":"top-left-right","css":"","css_class":"","dataobj":"dataobj_groups","droppable":"false","droppable_name":"","enable_html":"false","field_ChildCount":"childnum","field_NodeDescr":"name","field_NodeID":"code","field_picture":"","font":"","font_color":"","font_size":"","frame":"","h":"154","hidden_fields":"","hide":"false","layout_steps_values":"{}","name":"StdTreeView_Groups","node_link":"function:select_group(%code%)","page":"1","root_label":"CP_GROUPS","root_link":"","root_node_value":"","scroll_bars":"false","sequence":"3","set_icons":"function:GetNodeIcon(\"%grptype%\")","type":"StdTreeView","w":"282","wireframe_props":"","x":"8","y":"6","zindex":""},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request:grptype","name":"pgrptype","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"384","y":"-49"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"disableGroupsOf","page":"1","sequence":"5","server_side":"true","type":"Variable","typevar":"numeric","w":"122","x":"384","y":"-2"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"enableGroupsOf","page":"1","sequence":"6","server_side":"true","type":"Variable","typevar":"numeric","w":"122","x":"385","y":"35"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:grptype,disableGroupsOf,enableGroupsOf*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.spadministration_groups_zoom_container {
}
.spadministration_groups_zoom_portlet{
  position:relative;
  width:100%;
  min-width:300px;
  height:172px;
  background-color:transparent;
}
.spadministration_groups_zoom_portlet[Data-page="1"]{
  height:172px;
  width:100%;
}
.spadministration_groups_zoom_portlet > .StdTreeView_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:8px;
  right:10px;
  width:auto;
  height:154px;
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
 String def="[{\"h\":\"172\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"300\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"1\",\"y\":\"-42\"},{\"anchor\":\"top-left-right\",\"h\":\"154\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"StdTreeView\",\"w\":\"282\",\"x\":\"8\",\"y\":\"6\",\"zindex\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"384\",\"y\":\"-49\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"384\",\"y\":\"-2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"385\",\"y\":\"35\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_groups_zoom","UTF-8")) {return; }
 %><%if(!sp.isAdministrator() && sp.hasAdministeredUsers()){%>
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_groups_zoom_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("spadministration_help.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_groups_zoom','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_groups_zoom_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("StdTreeViewObj.js")%>'></script>
<%}
String pgrptype=JSPLib.translateXSS(sp.getParameter("grptype",""));
double disableGroupsOf=sp.getParameter("disableGroupsOf",0);
double enableGroupsOf=sp.getParameter("enableGroupsOf",0);
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_groups_zoom_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_groups_zoom_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_groups_zoom_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_groups_zoom','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_StdTreeView_Groups' formid='<%=idPortlet%>' ps-name='StdTreeView_Groups' class='stdtreeview'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_groups_zoom');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_GROUPS",true)+","+JSPLib.ToJSValue(sp.translate("CP_GROUPS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FIELD_UNDEFINED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FIELD_UNDEFINED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FILLING_SUBLAYER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FILLING_SUBLAYER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_USER_BELONGS_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_USER_BELONGS_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_USER_NOT_BELONGS_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_USER_NOT_BELONGS_TO_ROLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_groups_zoom',["300"],["172"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"300","h":"172","title":"","layer":"false","npage":"1"}]);
this.dataobj_groups=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_groupstree","cmdHash":"<%=JSPLib.cmdHash("spquery_groupstree",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_groups","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_groups","nrows":"1000000","page":1,"parms":"code,pgrptype","parms_source":"StdTreeView_Groups","type":"SQLDataobj","w":30,"x":1,"y":-42});
this.StdTreeView_Groups=new ZtVWeb.StdTreeViewCtrl(this,{"anchor":"top-left-right","class_css":"stdtreeview","ctrlid":"<%=idPortlet%>_StdTreeView_Groups","droppable":false,"droppable_name":"","enable_html":false,"font":"","font_color":"","font_size":"","h":154,"hide":"false","icon":"function:GetNodeIcon(\"%grptype%\")","layer":false,"layout_steps_values":{},"name":"StdTreeView_Groups","node_link":"function:select_group(%code%)","page":1,"root_label":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>","root_link":"","root_value":"","scroll_bars":"false","target":"","type":"StdTreeView","w":282,"x":8,"y":6,"zindex":""});
this.StdTreeView_Groups.setRowsCols({"field_ChildCount":"childnum","field_NodeID":"code","hiddenFlds":"","NodeDescr":"name","pictures":""});
this.pgrptype=new ZtVWeb._VC(this,'pgrptype',null,'character','<%=JSPLib.ToJSValue(pgrptype,false,true)%>',false,false);
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
<%request.setAttribute("spadministration_groups_zoom_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_groups_zoom_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof parentNodeEnabled !='undefined')this.parentNodeEnabled=parentNodeEnabled;
if(typeof StdTreeView_Groups_Rendered !='undefined')this.StdTreeView_Groups_Rendered=StdTreeView_Groups_Rendered;
if(typeof select_group !='undefined')this.select_group=select_group;
if(typeof GetNodeIcon !='undefined')this.GetNodeIcon=GetNodeIcon;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.StdTreeView_Groups.addParmConsumer(this.dataobj_groups);
this.dataobj_groups.addRowConsumer(this.StdTreeView_Groups);
this.StdTreeView_Groups.SetDataObject(this.dataobj_groups);

m_cProgName="spadministration_groups_zoom";
document.title=FormatMsg('CP_GROUPS');
function this_Loaded(){
  window.resizeTo(480,500);
  window.moveTo(100,100);
  var customToolbar=this.getTitlePortlet();
  customToolbar.SetTitle(FormatMsg('CP_GROUPS'));
  customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
                             'javascript:Help()','',FormatMsg('ADMIN_HELP'),FormatMsg('ADMIN_HELP')) 
  customToolbar.RearrangeAll();
}
var groupsDisabled=null, groupsEnabled=null;
  <%
    java.util.ArrayList userParameter = new java.util.ArrayList();
		
    if (disableGroupsOf!=0) {
      userParameter.add(disableGroupsOf);
      out.print("groupsDisabled='"+JSPLib.ToJSValue(sp.callFunction("","spadministration_getgrouplist",userParameter))+"'.trim().split(/ *, */);");
    }
%>
  <%
    if (enableGroupsOf!=0) {
      userParameter.add(enableGroupsOf);
      out.print("groupsEnabled='"+JSPLib.ToJSValue(sp.callFunction("","spadministration_getgrouplist",userParameter))+"'.trim().split(/ *, */);");
    }
%>
function parentNodeEnabled(node) {
  var parentNode = node.nodeFather;
  if (typeof(parentNode)=='string' || parentNode.rs.code=="" || groupsEnabled.indexOf(parentNode.rs.code) ==-1 ) //sono al primo livello
    return false;
  else 
    return true;
}
function StdTreeView_Groups_Rendered() {
  if ( groupsDisabled !=null || groupsEnabled !=null ) {
  	var nodes = this.StdTreeView_Groups.Tree.allnodes, node, i, htmlelement;
		for (i=0;i<nodes.length;i++) {
    	node=nodes[i];
    	if (node.rs.code!="" && node.nodeFather==this.StdTreeView_Groups.currentnode){ //escludo root e modifico solo i nuovi caricati
      	htmlelement = document.getElementById(node.nodeDiv+'_element');
      	if (groupsDisabled !=null && groupsDisabled.indexOf(node.rs.code) >-1 ) {
        	htmlelement.style.opacity='0.5';
      	} else if (groupsEnabled !=null) {
        	if ( groupsEnabled.indexOf(node.rs.code) ==-1 || this.parentNodeEnabled(node) ) { // se il padre e' abilitato io devo essere disabilitato
        		htmlelement.style.opacity='0.5';
        	} else {
          	htmlelement.style.opacity='1';
        	}
      	} else {
        	htmlelement.style.opacity='1';
      	}
    	}
  	}
  }
}
function select_group(code){
  if (groupsEnabled!=null && (groupsEnabled.indexOf(this.StdTreeView_Groups.rs.code)==-1 || this.parentNodeEnabled(this.StdTreeView_Groups.currentnode) ) ) {
    alert(FormatMsg('MSG_USER_NOT_BELONGS_TO_ROLE'));
  } else if (groupsDisabled!=null && groupsDisabled.indexOf(this.StdTreeView_Groups.rs.code)>-1) {
    alert(FormatMsg('MSG_USER_BELONGS_TO_ROLE'));
  } else {
  	ZtVWeb.DoLinkZoom('<%=sp.getParameter("UID","NOT_FROM_ZOOM")%>',this.StdTreeView_Groups.rs.code,'<%=sp.getParameter("OpenerFormId","")%>');
  	WindowClose();
  }
}
function GetNodeIcon(group_type){
  if(group_type=='R')
    return '<%=sp.getThemedImage("../images/spadministration_role.png")%>';
  else if(group_type=='D')
    return '<%=sp.getThemedImage("../images/spadministration_descriptive.gif")%>';
  else if(group_type=='O')
    return '<%=sp.getThemedImage("../images/spadministration_organizational.gif")%>';
  else if(group_type=='S')
    return '<%=sp.getThemedImage("../images/spadministration_sharing.gif")%>';
  else
    return '<%=sp.getThemedImage("../images/spadministration_group.png")%>';
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_groups_zoom_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.dataobj_groups.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_groups_zoom',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_groups_zoom');
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
sp.endPage("spadministration_groups_zoom");
}%>
<%! public String getJSPUID() { return "3751352619"; } %>