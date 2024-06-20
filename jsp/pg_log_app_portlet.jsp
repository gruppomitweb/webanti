<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function btnExit_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.Uscita.Link();\n  }\n}  \n\nfunction CrtlImg(_nomefile) {\n  _ritorno=''\n  if (!Empty(_nomefile)) {\n    _ritorno=\"\u003ca img src='\"+LRTrim(this.gUrlApp.Value())+\"images\u002fGIF\u002f118.gif' title='Premere il bottone per scaricare il file' alt='ok'\u002f\u003e\u003c\u002fa\u003e\"\n    alert(_ritorno)\n  } else {\n    _ritorno=\"\"  \n  }    \n  return _ritorno \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('LOG APPLICAZIONE',true);\n}\n\nfunction Scarica() {\n  _file=this.RTScarica.Link()\n  if(Left(_file,6)=='Errore') {\n    alert(_file) \n  } else {\n    this.cURL.Value(_file);    \n    this.RTDownload.Servlet(this.cURL.Value())\n    this.RTDownload.Link()    \n  }    \n}  \n\nfunction cmbTipLog_onChange(){\n  this.Query1.Query()\n  this.Grid7.Refresh()\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @Label10 }} \n{{ @cmbTipLog }} \n{{ @btnExit }} \n{{ @Grid7 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"pLOGTYPE=cmbTipLog","parms_source":"","query":"qbe_log_app","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"183","x":"156","y":"-59"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"30","m_cAction":"","name":"Uscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"142","x":"2","y":"-64"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"354","y":"-62"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"LOGFILE","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"964","y":"-52"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"LOGDATORA\",\"title\":\"LOGDATORA\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"T\",\"title_align\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"field\":\"LOGUTENTE\",\"title\":\"LOGUTENTE\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"LOGTIPOPE\",\"title\":\"LOGTIPOPE\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"LOGTABELLA\",\"title\":\"LOGTABELLA\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"LOGCHIAVE\",\"title\":\"LOGCHIAVE\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"LOGTESTO\",\"title\":\"LOGTESTO\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"M\",\"title_align\":\"\"},{\"field\":\"LOGFILE\",\"title\":\"LOGFILE\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"LOGPATH\",\"title\":\"LOGPATH\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true},{\"field\":\"%LOGPATH%\",\"title\":\"\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"30\",\"fixedwidth\":\"30\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"function:Scarica()\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"true-by-example","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"525","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid7","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"44","zindex":"2"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTScarica","offline":"false","page":"1","parms":"pNomeFile=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arrt_downloadxlsx_log","target":"","type":"SPLinker","w":"127","x":"679","y":"-61"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"7","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"987","y":"7","zindex":"3"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cURL","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"823","y":"-55"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTDownload","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"","target":"","type":"SPLinker","w":"127","x":"541","y":"-68"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","layer":"false","layout_steps_values":"{}","name":"cmbTipLog","page":"1","picture":"","sequence":"10","spuid":"","tabindex":"","textlist":"Scheduler-Import,Applicazione,Documentale","type":"Combobox","typevar":"character","valuelist":"S,I,D","visible":"true","w":"248","wireframe_props":"name,textlist","x":"120","y":"9","zindex":"4"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label10","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Log:","w":"108","wireframe_props":"align,value,n_col","x":"8","y":"11","zindex":"5"}]%>
<%/*Description:*/%>
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
window.pg_log_app_Static=function(){
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof CrtlImg !='undefined')this.CrtlImg=CrtlImg;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Scarica !='undefined')this.Scarica=Scarica;
if(typeof cmbTipLog_onChange !='undefined')this.cmbTipLog_onChange=cmbTipLog_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addDataConsumer(this.filename,<%=JSPLib.ToJSValue("LOGFILE",true)%>);
this.Query1.addRowConsumer(this.Grid7);
function btnExit_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.Uscita.Link();
  }
}  
function CrtlImg(_nomefile) {
  _ritorno=''
  if (!Empty(_nomefile)) {
    _ritorno="<a img src='"+LRTrim(this.gUrlApp.Value())+"images/GIF/118.gif' title='Premere il bottone per scaricare il file' alt='ok'/></a>"
    alert(_ritorno)
  } else {
    _ritorno=""  
  }    
  return _ritorno 
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle('LOG APPLICAZIONE',true);
}
function Scarica() {
  _file=this.RTScarica.Link()
  if(Left(_file,6)=='Errore') {
    alert(_file) 
  } else {
    this.cURL.Value(_file);    
    this.RTDownload.Servlet(this.cURL.Value())
    this.RTDownload.Link()    
  }    
}  
function cmbTipLog_onChange(){
  this.Query1.Query()
  this.Grid7.Refresh()
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
.pg_log_app_container {
}
.pg_log_app_title_container {
  margin: auto;
}
.pg_log_app_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:680px;
}
.pg_log_app_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_log_app_portlet > .Grid7_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:44px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:525px;
}
.pg_log_app_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:7px;
  left:987px;
  left:96.38672%;
  right:7px;
  right:0.68359375%;
  width:auto;
  height:30px;
}
.pg_log_app_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_log_app_portlet > .cmbTipLog_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:9px;
  left:120px;
  left:11.71875%;
  right:656px;
  right:64.0625%;
  width:auto;
  height:22px;
}
.pg_log_app_portlet > .Label10_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:11px;
  left:8px;
  left:0.78125%;
  right:908px;
  right:88.671875%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_log_app_portlet > .Label10_ctrl {
  height:auto;
  min-height:20px;
}
.pg_log_app_portlet > .Label10_ctrl {
  overflow:hidden;
  text-align:right;
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"183\",\"x\":\"156\",\"y\":\"-59\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"142\",\"x\":\"2\",\"y\":\"-64\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"354\",\"y\":\"-62\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"964\",\"y\":\"-52\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"LOGDATORA\"},{\"title\":\"LOGUTENTE\"},{\"title\":\"LOGTIPOPE\"},{\"title\":\"LOGTABELLA\"},{\"title\":\"LOGCHIAVE\"},{\"title\":\"LOGTESTO\"},{\"title\":\"LOGFILE\"},{\"title\":\"LOGPATH\"},{\"title\":\"\"}],\"h\":\"525\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"44\",\"zindex\":\"2\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"127\",\"x\":\"679\",\"y\":\"-61\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"987\",\"y\":\"7\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"823\",\"y\":\"-55\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"127\",\"x\":\"541\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"cmbTipLog\",\"page\":\"1\",\"textlist\":\"Scheduler-Import,Applicazione,Documentale\",\"type\":\"Combobox\",\"w\":\"248\",\"x\":\"120\",\"y\":\"9\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label10\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Log:\",\"w\":\"108\",\"x\":\"8\",\"y\":\"11\",\"zindex\":\"5\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_log_app","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_log_app_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_log_app','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gUrlApp=sp.getGlobal("gUrlApp","");
String filename= "";
if(request.getAttribute("pg_log_app_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String cURL= "";
String cmbTipLog="S";
String Label10= "Tipo Log:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_log_app_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_log_app_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_log_app_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_log_app','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid7' formid='<%=idPortlet%>' ps-name='Grid7'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_btnExit' class='image-default btnExit_ctrl'   target=''>&#xea01;</a>
<select id='<%=idPortlet%>_cmbTipLog' name='cmbTipLog' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label10'  formid='<%=idPortlet%>' ps-name='Label10'    class='label Label10_ctrl'><div id='<%=idPortlet%>_Label10tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Log:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_log_app');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_log_app',["1024"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_log_app","cmdHash":"<%=JSPLib.cmdHash("qbe_log_app",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"pLOGTYPE=cmbTipLog","parms_source":"","type":"SQLDataobj","w":183,"x":156,"y":-59});
this.Uscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Uscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Uscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":142,"x":2,"y":-64});
this.Uscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.Grid7=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid7","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":525,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid7","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":44,"zindex":"2"});
this.Grid7.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGDATORA","align":"","type":"T","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGDATORA","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGUTENTE","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGUTENTE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGTIPOPE","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGTIPOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGTABELLA","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGTABELLA","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGCHIAVE","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGCHIAVE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGTESTO","align":"","type":"M","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGTESTO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGFILE","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGFILE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"LOGPATH","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"LOGPATH","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"function:Scarica()","fixedwidth":"30","title":"","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"%LOGPATH%","droppable_name":"","fg_color":"","width":"30","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.RTScarica=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTScarica","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTScarica","offline":false,"page":1,"parms":"pNomeFile=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadxlsx_log","target":"","type":"SPLinker","w":127,"x":679,"y":-61});
this.RTScarica.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadxlsx_log",request.getSession())%>';
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":987,"y":7,"zindex":"3"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.cURL=new ZtVWeb._VC(this,'cURL',null,'character','<%=JSPLib.ToJSValue(cURL,false,true)%>',false,false);
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":127,"x":541,"y":-68});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.cmbTipLog=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbTipLog","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbTipLog%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbTipLog","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Scheduler-Import,Applicazione,Documentale","type":"Combobox","typevar":"character","valuelist":"S,I,D","visible":true,"w":248,"x":120,"y":9,"zindex":"4"});
this.Label10=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label10","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label10","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label10,false,true)%>","type":"Label","w":108,"x":8,"y":11,"zindex":"5"});
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
<%if(request.getAttribute("pg_log_app_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_log_app_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_log_app_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.cmbTipLog.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_log_app',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_log_app');
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
sp.endPage("pg_log_app");
}%>
<%! public String getJSPUID() { return "1455459865"; } %>