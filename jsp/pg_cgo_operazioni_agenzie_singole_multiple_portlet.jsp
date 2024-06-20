<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  \u002f\u002fsetto il titolo della maschera\n  this.getTitlePortlet().SetTitle('Operazioni Multiple Agenzia',true)\n  this.opedata.Value(Right(this.datope.Value(),2)+\"-\"+Substr(this.datope.Value(),5,2)+\"-\"+Left(this.datope.Value(),4)); \n  if(this.tipo.Value()=='S'){\n     this.SQLDataOperazioniMultiple.ChangeQuery('qbe_ cgo_operazioni_dl_multi_dc_s');\n  }else{\n    this.SQLDataOperazioniMultiple.ChangeQuery('qbe_ cgo_operazioni_dl_multi_dc_m');\n  }\n  this.SQLDataOperazioniMultiple.Query();\n}\n\n\u002f\u002fapro il dettaglio di uno specifico master\n\u002f\u002fassociato al tipo di operazione\nfunction Apri(_SNAINUMOPE,_TIPOSM){\n  if( _TIPOSM == 'SDC'){\n\u002f\u002f apro il master delle operazioni singole\n    this.SPLinker_mt.Servlet('armt_snai_oper')\n  }\n  if( _TIPOSM == 'SDL'){\n    this.SPLinker_mt.Servlet('armt_cgo_oper')\n  }\n  if (_TIPOSM == 'MDC'){\n\u002f\u002f apro il master delle operazioni multiple\n \t\tthis.SPLinker_mt.Servlet('armt_cgo_oper_multi_dc' )\n  }\n  if (_TIPOSM == 'MDL'){\n\u002f\u002f apro il master delle operazioni multiple\n \t\tthis.SPLinker_mt.Servlet('armt_cgo_oper_multi' )\n  }\n  this.SPLinker_mt.Parameters('SNAINUMOPE = '+_SNAINUMOPE)\n  this.SPLinker_mt.Link()\n}\n\nfunction RecuperaDL(_CAIDBIGLIETTO, _TOTLIRE, _DATAOPE, _SNAINUMOPE, _TIPOGIOCO) {\n  var cprownumber_selezionato, snainumope_selezionato;\n  if (confirm('Confermi la selezione della registrazione?')) {\n    cprownumber_selezionato=this.cprownumber_selezionato.Value();\n    snainumope_selezionato=this.snainumope_selezionato.Value();\n    caller.WriteRowSM(_CAIDBIGLIETTO,_TOTLIRE,Strtran(_DATAOPE,'-',''),_SNAINUMOPE,_TIPOGIOCO, cprownumber_selezionato, snainumope_selezionato)\n    window.close()\n  }\n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Operazioni Multiple Agenzia","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"200","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Multiple Agenzia","portlet_position":"align center","positioning":"absolute","roles":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"300","version":"37","w":"100%","wizard":""},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"tipo","page":"1","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"179","x":"327","y":"-28"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"numope","page":"1","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"179","x":"327","y":"-5"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"datope","page":"1","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"179","x":"327","y":"18"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"opedata","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"date","w":"179","x":"327","y":"40"},{"appendingData":"false","auto_exec":"false","count":"true","h":"20","localDBName":"","n_records":"10","name":"SQLDataOperazioniMultiple","offline":"false","page":"1","parms":"w_datope=opedata, w_numope=numope, w_segno=segno, w_dc=dc","parms_source":"","query":"qbe_cgo_operazioni_dl_multi_dc_m","query_async":"false","return_fields_type":"true","sequence":"5","type":"SQLDataobj","w":"180","x":"328","y":"127"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"DATAOPE\",\"title\":\"Data Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"function:RecuperaDL('%CAIDBIGLIETTO%', %TOTLIRE%, '%DATAOPE%', '%SNAINUMOPE%', '%TIPOGIOCO%')\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"D\",\"title_align\":\"\"},{\"field\":\"CAIDBIGLIETTO\",\"title\":\"ID BIGLIETTO\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"function:Apri('%SNAINUMOPE%', '%TIPOSM%')\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"SNAINUMOPE\",\"title\":\"N° Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CACODICE\",\"title\":\"Codice Causale\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"TIPOSM\",\"title\":\"Tipo S\u002fM\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"TOTLIRE\",\"title\":\"Importo\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"999,999,999.99\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"SEGNO\",\"title\":\"Segno\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CAFLGOPE\",\"title\":\"Tipo Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"TIPOGIOCO\",\"title\":\"Tipo Gioco\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"DESTPGIO\",\"title\":\"Descrizione Tipo Gioco\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLDataOperazioniMultiple","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"200","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_SQLDataOperazioniM","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"6","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"300","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":"1"},{"calculate":"","dataobj":"SQLDataOperazioniMultiple","field":"CPROWNUM","h":"20","init":"","init_par":"","name":"cprownumber_selezionato","page":"1","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"327","y":"150"},{"async":"false","entity_type":"master","h":"20","m_cAction":"view","name":"SPLinker_mt","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"","target":"","type":"SPLinker","w":"180","x":"327","y":"204"},{"calculate":"","dataobj":"SQLDataOperazioniMultiple","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"snainumope_selezionato","page":"1","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"327","y":"173"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"segno","page":"1","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"179","x":"327","y":"62"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"dc","page":"1","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"179","x":"327","y":"85"}]%>
<%/*Description:Operazioni Multiple Agenzia*/%>
<%/*ParamsRequest:tipo,numope,datope,segno,dc*/%>
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
window.pg_cgo_operazioni_agenzie_singole_multiple_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Apri !='undefined')this.Apri=Apri;
if(typeof RecuperaDL !='undefined')this.RecuperaDL=RecuperaDL;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLDataOperazioniMultiple.addRowConsumer(this.Grid_SQLDataOperazioniM);
this.SQLDataOperazioniMultiple.addDataConsumer(this.cprownumber_selezionato,<%=JSPLib.ToJSValue("CPROWNUM",true)%>);
this.SQLDataOperazioniMultiple.addDataConsumer(this.snainumope_selezionato,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
function this_Loaded(){
  //setto il titolo della maschera
  this.getTitlePortlet().SetTitle('Operazioni Multiple Agenzia',true)
  this.opedata.Value(Right(this.datope.Value(),2)+"-"+Substr(this.datope.Value(),5,2)+"-"+Left(this.datope.Value(),4)); 
  if(this.tipo.Value()=='S'){
     this.SQLDataOperazioniMultiple.ChangeQuery('qbe_ cgo_operazioni_dl_multi_dc_s');
  }else{
    this.SQLDataOperazioniMultiple.ChangeQuery('qbe_ cgo_operazioni_dl_multi_dc_m');
  }
  this.SQLDataOperazioniMultiple.Query();
}
//apro il dettaglio di uno specifico master
//associato al tipo di operazione
function Apri(_SNAINUMOPE,_TIPOSM){
  if( _TIPOSM == 'SDC'){
// apro il master delle operazioni singole
    this.SPLinker_mt.Servlet('armt_snai_oper')
  }
  if( _TIPOSM == 'SDL'){
    this.SPLinker_mt.Servlet('armt_cgo_oper')
  }
  if (_TIPOSM == 'MDC'){
// apro il master delle operazioni multiple
 		this.SPLinker_mt.Servlet('armt_cgo_oper_multi_dc' )
  }
  if (_TIPOSM == 'MDL'){
// apro il master delle operazioni multiple
 		this.SPLinker_mt.Servlet('armt_cgo_oper_multi' )
  }
  this.SPLinker_mt.Parameters('SNAINUMOPE = '+_SNAINUMOPE)
  this.SPLinker_mt.Link()
}
function RecuperaDL(_CAIDBIGLIETTO, _TOTLIRE, _DATAOPE, _SNAINUMOPE, _TIPOGIOCO) {
  var cprownumber_selezionato, snainumope_selezionato;
  if (confirm('Confermi la selezione della registrazione?')) {
    cprownumber_selezionato=this.cprownumber_selezionato.Value();
    snainumope_selezionato=this.snainumope_selezionato.Value();
    caller.WriteRowSM(_CAIDBIGLIETTO,_TOTLIRE,Strtran(_DATAOPE,'-',''),_SNAINUMOPE,_TIPOGIOCO, cprownumber_selezionato, snainumope_selezionato)
    window.close()
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
.pg_cgo_operazioni_agenzie_singole_multiple_container {
}
.pg_cgo_operazioni_agenzie_singole_multiple_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_singole_multiple_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:300px;
  height:200px;
  background-color:#F3F3F3;
}
.pg_cgo_operazioni_agenzie_singole_multiple_portlet[Data-page="1"]{
  height:200px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_singole_multiple_portlet > .Grid_SQLDataOperazioniM_ctrl {
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
  min-height:200px;
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
 String def="[{\"h\":\"200\",\"layout_steps_values\":{},\"pages_names\":\"Operazioni Multiple Agenzia\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"300\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"179\",\"x\":\"327\",\"y\":\"-28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"179\",\"x\":\"327\",\"y\":\"-5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"179\",\"x\":\"327\",\"y\":\"18\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"179\",\"x\":\"327\",\"y\":\"40\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"180\",\"x\":\"328\",\"y\":\"127\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Operazione\"},{\"title\":\"ID BIGLIETTO\"},{\"title\":\"N° Operazione\"},{\"title\":\"Codice Causale\"},{\"title\":\"Tipo S\\u002fM\"},{\"title\":\"Importo\"},{\"title\":\"Segno\"},{\"title\":\"Tipo Operazione\"},{\"title\":\"Tipo Gioco\"},{\"title\":\"Descrizione Tipo Gioco\"}],\"h\":\"200\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"300\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"327\",\"y\":\"150\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"180\",\"x\":\"327\",\"y\":\"204\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"327\",\"y\":\"173\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"179\",\"x\":\"327\",\"y\":\"62\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"179\",\"x\":\"327\",\"y\":\"85\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_singole_multiple","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_singole_multiple_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_singole_multiple','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String tipo=JSPLib.translateXSS(sp.getParameter("tipo",""));
String numope=JSPLib.translateXSS(sp.getParameter("numope",""));
String datope=JSPLib.translateXSS(sp.getParameter("datope",""));
java.sql.Date opedata= JSPLib.NullDate();
if(request.getAttribute("pg_cgo_operazioni_agenzie_singole_multiple_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String cprownumber_selezionato= "";
String snainumope_selezionato= "";
String segno=JSPLib.translateXSS(sp.getParameter("segno",""));
String dc=JSPLib.translateXSS(sp.getParameter("dc",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_singole_multiple_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_singole_multiple_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_singole_multiple_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_singole_multiple','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid_SQLDataOperazioniM' formid='<%=idPortlet%>' ps-name='Grid_SQLDataOperazioniM'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_singole_multiple');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_singole_multiple',["300"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"300","h":"200","title":"Operazioni Multiple Agenzia","layer":"false","npage":"1"}]);
this.tipo=new ZtVWeb._VC(this,'tipo',null,'character','<%=JSPLib.ToJSValue(tipo,false,true)%>',false,false);
this.numope=new ZtVWeb._VC(this,'numope',null,'character','<%=JSPLib.ToJSValue(numope,false,true)%>',false,false);
this.datope=new ZtVWeb._VC(this,'datope',null,'character','<%=JSPLib.ToJSValue(datope,false,true)%>',false,false);
this.opedata=new ZtVWeb._VC(this,'opedata',null,'date','<%=opedata%>',false,false);
this.SQLDataOperazioniMultiple=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_cgo_operazioni_dl_multi_dc_m","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_dl_multi_dc_m",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLDataOperazioniMultiple","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataOperazioniMultiple","nrows":"10","page":1,"parms":"w_datope=opedata, w_numope=numope, w_segno=segno, w_dc=dc","parms_source":"","type":"SQLDataobj","w":180,"x":328,"y":127});
this.Grid_SQLDataOperazioniM=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_SQLDataOperazioniM","dataobj":"SQLDataOperazioniMultiple","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":200,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_SQLDataOperazioniM","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":300,"x":0,"y":0,"zindex":"1"});
this.Grid_SQLDataOperazioniM.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"function:RecuperaDL('%CAIDBIGLIETTO%', %TOTLIRE%, '%DATAOPE%', '%SNAINUMOPE%', '%TIPOGIOCO%')","fixedwidth":"","title":"Data Operazione","align":"","type":"D","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"function:Apri('%SNAINUMOPE%', '%TIPOSM%')","fixedwidth":"","title":"ID BIGLIETTO","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CAIDBIGLIETTO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"N° Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"SNAINUMOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Causale","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CACODICE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo S\u002fM","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TIPOSM","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Importo","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"999,999,999.99","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TOTLIRE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Segno","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"SEGNO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CAFLGOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Gioco","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TIPOGIOCO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Descrizione Tipo Gioco","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DESTPGIO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.cprownumber_selezionato=new ZtVWeb._VC(this,'cprownumber_selezionato',null,'character','<%=JSPLib.ToJSValue(cprownumber_selezionato,false,true)%>',false,false);
this.SPLinker_mt=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_mt","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_mt","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":180,"x":327,"y":204});
this.SPLinker_mt.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.snainumope_selezionato=new ZtVWeb._VC(this,'snainumope_selezionato',null,'character','<%=JSPLib.ToJSValue(snainumope_selezionato,false,true)%>',false,false);
this.segno=new ZtVWeb._VC(this,'segno',null,'character','<%=JSPLib.ToJSValue(segno,false,true)%>',false,false);
this.dc=new ZtVWeb._VC(this,'dc',null,'character','<%=JSPLib.ToJSValue(dc,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_singole_multiple_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_singole_multiple_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_singole_multiple_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_singole_multiple',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_singole_multiple');
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
sp.endPage("pg_cgo_operazioni_agenzie_singole_multiple");
}%>
<%! public String getJSPUID() { return "3356881384"; } %>