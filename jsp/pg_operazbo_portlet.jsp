<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"if(this.fonte.Value()=='D') {\n  this.getTitlePortlet().SetTitle(\"Operazioni (AUI)\",true)\n  this.Query1.ChangeQuery(\"qbe_pers_oper\")  \n  this.operazbo.Servlet(\"armt_operazioni\")\n} else {\n  this.getTitlePortlet().SetTitle(\"Operazioni (Provvisorie)\",true)\n  this.Query1.ChangeQuery(\"qbe_pers_oper_prv\")\n  this.operazbo.Servlet(\"armt_oprovvisorie\")\n}  \nthis.Query1.Query()\n                                \nfunction ColoraRiga(_stato) {\n  switch (_stato) {\n    case '2':\n      _colore='#FF0000';\n      break;\n    case '3':  \n      _colore='#FFFF99'\n      break;\n    default:\n      _colore=''\n  }    \n  return _colore;\n}  \n\nfunction ViewBtn(_stato,_tipo) {\n  if (_tipo=='E') {\n    if (_stato=='0' || _stato=='1') {      \n      _immagine='\u003cimg src=\"'+this.gUrlApp.Value()+'images\u002fedit.gif'+'\" alt=\"edit\" \u002f\u003e'\n    } else {\n      _immagine=''      \n    }          \n  }  \n  if (_tipo=='D') {\n    if (_stato=='0' || _stato=='1') {      \n      _immagine='\u003cimg src=\"'+this.gUrlApp.Value()+'images\u002fremove.gif'+'\" alt=\"remove\" \u002f\u003e'\n    } else {\n      _immagine=''            \n    }          \n  }    \n  return _immagine\n}  \n\nfunction Aggiorna(_evt) {\n  this.Query1.Query()\n  this.Grid0.Refresh()\n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Grid0 }}{{ @Grid0 }}{{ @Grid0 }}{{ @Grid0 }}\u003c\u002fbody\u003e","grapesCss":"","h":"500","hsl":"","htmlcode":"{{ armt_operazioni_deletedEntity }}\n\n{{ @Grid0 }}\n{{ Grid0 }}\n{{ Query1 }}\n{{ w_CONNES }}\n{{ operazbo_edt }}\n{{ label2 }}\n{{ operazbo_del }}\n{{ operazbo_view }}\n{{ gUrlApp }}{{ w_CONNES }}\n{{ armt_operazioni_savedEntity }}","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"500\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"195","x":"419","y":"4"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"fonte","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"429","y":"198"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"w_CONNES","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"195","x":"419","y":"25"},{"allowedqueries":"qbe_pers_oper,qbe_pers_oper_prv","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_CONNES=w_CONNES","parms_source":"","query":"qbe_pers_oper","query_async":"true","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"195","waiting_mgs":"","x":"419","y":"46"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATO%')\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"printable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATO%')\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"printable\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data registrazione\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATO%')\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"printable\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Valuta\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATO%')\",\"newline\":false,\"field\":\"VALUTA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"printable\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Causale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATO%')\",\"newline\":false,\"field\":\"CODANA+\\\" \\\"+CODVOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"printable\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"N\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATO%')\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"printable\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,D,D,C,,N","filters":"false","fixed":"","floatRows":"","font":"Tahoma","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"489","hide":"false","hide_default_titles":"","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"operazbo","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":"","zone":""},{"allowedentities":"armt_operazioni,armt_oprovvisorie","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"","name":"operazbo","offline":"false","page":"1","parms":"IDBASE=IDBASE,CONNESCLI=w_CONNES","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"6","servlet":"armt_operazioni","target":"","type":"SPLinker","w":"195","x":"419","y":"67"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_operazioni_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"7","type":"EventReceiver","w":"195","x":"419","y":"88"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_operazioni_deletedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"8","type":"EventReceiver","w":"195","x":"419","y":"109"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_oprovvisorie_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"9","type":"EventReceiver","w":"195","x":"419","y":"129"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_oprovvisorie_deletedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"10","type":"EventReceiver","w":"195","x":"421","y":"150"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:fonte*/%>
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
window.pg_operazbo_Static=function(){
if(typeof ColoraRiga !='undefined')this.ColoraRiga=ColoraRiga;
if(typeof ViewBtn !='undefined')this.ViewBtn=ViewBtn;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
if(this.fonte.Value()=='D') {
  this.getTitlePortlet().SetTitle("Operazioni (AUI)",true)
  this.Query1.ChangeQuery("qbe_pers_oper")  
  this.operazbo.Servlet("armt_operazioni")
} else {
  this.getTitlePortlet().SetTitle("Operazioni (Provvisorie)",true)
  this.Query1.ChangeQuery("qbe_pers_oper_prv")
  this.operazbo.Servlet("armt_oprovvisorie")
}  
this.Query1.Query()
                                
function ColoraRiga(_stato) {
  switch (_stato) {
    case '2':
      _colore='#FF0000';
      break;
    case '3':  
      _colore='#FFFF99'
      break;
    default:
      _colore=''
  }    
  return _colore;
}  
function ViewBtn(_stato,_tipo) {
  if (_tipo=='E') {
    if (_stato=='0' || _stato=='1') {      
      _immagine='<img src="'+this.gUrlApp.Value()+'images/edit.gif'+'" alt="edit" />'
    } else {
      _immagine=''      
    }          
  }  
  if (_tipo=='D') {
    if (_stato=='0' || _stato=='1') {      
      _immagine='<img src="'+this.gUrlApp.Value()+'images/remove.gif'+'" alt="remove" />'
    } else {
      _immagine=''            
    }          
  }    
  return _immagine
}  
function Aggiorna(_evt) {
  this.Query1.Query()
  this.Grid0.Refresh()
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
.pg_operazbo_container {
}
.pg_operazbo_title_container {
  margin: auto;
}
.pg_operazbo_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:500px;
}
.pg_operazbo_portlet[Data-page="1"]{
  height:500px;
  width:100%;
}
.pg_operazbo_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:489px;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"195\",\"x\":\"419\",\"y\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"429\",\"y\":\"198\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"195\",\"x\":\"419\",\"y\":\"25\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"195\",\"x\":\"419\",\"y\":\"46\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"N° Progressivo\"},{\"title\":\"Data Operazione\"},{\"title\":\"Data registrazione\"},{\"title\":\"Valuta\"},{\"title\":\"Causale\"},{\"title\":\"Totale Operazione\"}],\"h\":\"489\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"195\",\"x\":\"419\",\"y\":\"67\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"195\",\"x\":\"419\",\"y\":\"88\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"195\",\"x\":\"419\",\"y\":\"109\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"195\",\"x\":\"419\",\"y\":\"129\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"195\",\"x\":\"421\",\"y\":\"150\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_operazbo","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_operazbo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_operazbo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gUrlApp=sp.getGlobal("gUrlApp","");
String fonte=JSPLib.translateXSS(sp.getParameter("fonte",""));
String w_CONNES=JSPLib.translateXSS(Library.getAttribute(request,"w_CONNES",""));
if(request.getAttribute("pg_operazbo_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_operazbo_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_operazbo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_operazbo_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_operazbo','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_operazbo');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_operazbo',["400"],["500"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"500","title":"","layer":""}]);
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.fonte=new ZtVWeb._VC(this,'fonte',null,'character','<%=JSPLib.ToJSValue(fonte,false,true)%>',false,false);
this.w_CONNES=new ZtVWeb._VC(this,'w_CONNES',null,'character','<%=JSPLib.ToJSValue(w_CONNES,false,true)%>',false,false);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_pers_oper,qbe_pers_oper_prv",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"qbe_pers_oper","cmdHash":"<%=JSPLib.cmdHash("qbe_pers_oper,qbe_pers_oper_prv",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_CONNES=w_CONNES","parms_source":"","type":"SQLDataobj","w":195,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":419,"y":46});
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":489,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"operazbo","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":400,"x":0,"y":0,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","printable":true,"picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATO%')","field":"NUMPROG","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"D","align":"","printable":true,"ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATO%')","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data registrazione","type":"D","align":"","printable":true,"ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATO%')","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Valuta","type":"C","align":"","printable":true,"ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATO%')","newline":false,"field":"VALUTA","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Causale","type":"C","align":"","printable":true,"ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATO%')","newline":false,"field":"CODANA+\" \"+CODVOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"N","align":"right","printable":true,"ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"function:ColoraRiga('%STATO%')","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.operazbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("armt_operazioni,armt_oprovvisorie",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_operazbo","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"operazbo","offline":false,"page":1,"parms":"IDBASE=IDBASE,CONNESCLI=w_CONNES","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_operazioni","target":"","type":"SPLinker","w":195,"x":419,"y":67});
this.operazbo.m_cID='<%=JSPLib.cmdHash("entity,armt_operazioni,armt_oprovvisorie",request.getSession())%>';
this.armt_operazioni_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_operazioni_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_operazioni_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":195,"x":419,"y":88});
this.armt_operazioni_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_operazioni_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_operazioni_deletedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":195,"x":419,"y":109});
this.armt_oprovvisorie_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_oprovvisorie_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_oprovvisorie_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":195,"x":419,"y":129});
this.armt_oprovvisorie_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_oprovvisorie_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_oprovvisorie_deletedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":195,"x":421,"y":150});
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
<%if(request.getAttribute("pg_operazbo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_operazbo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_operazbo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_armt_operazioni_savedEntity=function(parmsObj){<%=idPortlet%>.armt_operazioni_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_operazioni_deletedEntity=function(parmsObj){<%=idPortlet%>.armt_operazioni_deletedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_oprovvisorie_savedEntity=function(parmsObj){<%=idPortlet%>.armt_oprovvisorie_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_oprovvisorie_deletedEntity=function(parmsObj){<%=idPortlet%>.armt_oprovvisorie_deletedEntity.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_operazbo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_operazbo');
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
sp.endPage("pg_operazbo");
}%>
<%! public String getJSPUID() { return "3356487169"; } %>