<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function SQLDataobj_qbe_test_opextrbo_ConsumersRendered(){\n  this.Label_inviato.Value('Operazioni da Inviare: '+this.SQLDataobj_qbe_test_opextrbo.rs.tot);\n}\n\nfunction SQLDataobj_qbe_test_opextrbo2_ConsumersRendered(){\n  this.Label_modificato.Value('Operazioni Modificate da inviare: '+this.SQLDataobj_qbe_test_opextrbo2.rs.tot);\n}\n\nfunction SQLDataobj_qbe_test_opextrbo3_ConsumersRendered(){\n  this.Label_annullato.Value('Operazioni da Annullare: '+this.SQLDataobj_qbe_test_opextrbo3.rs.tot);\n}\n\nfunction SQLDataobj_qbe_test_aetesta_ConsumersRendered(){\n  this.Label_inviato_r.Value('Rapporti da Inviare: '+this.SQLDataobj_qbe_test_aetesta.rs.tot);\n}\n\nfunction SQLDataobj_qbe_test_aetesta2_ConsumersRendered(){\n  this.Label_modificato_r.Value('Rapporti Modificati da inviare: '+this.SQLDataobj_qbe_test_aetesta2.rs.tot);\n}\n\nfunction SQLDataobj_qbe_test_aetesta3_ConsumersRendered(){\n  this.Label_annullato_r.Value('Rapporti da Annullare: '+this.SQLDataobj_qbe_test_aetesta3.rs.tot);\n}\nfunction Aggiorna(_evt){\n  this.SQLDataobj_qbe_test_opextrbo.Query();\n  this.SQLDataobj_qbe_test_opextrbo2.Query(); \n  this.SQLDataobj_qbe_test_opextrbo3.Query();\n  this.SQLDataobj_qbe_test_aetesta.Query();\n  this.SQLDataobj_qbe_test_aetesta2.Query(); \n  this.SQLDataobj_qbe_test_aetesta3.Query();\n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Label_titolo }}{{ @Label_inviato }}{{ @Label_modificato }}{{ @Label_annullato }}{{ @Label_inviato_r }}{{ @Label_modificato_r }}{{ @Label_annullato_r }}\u003c\u002fbody\u003e","grapesCss":"","h":"150","hsl":"","htmlcode":"\n{{ @Label_annullato_r }}\n{{ @Label_modificato_r }}\n{{ @Label_inviato_r }}\n{{ @Label_titolo }}\n{{ @Label_annullato }}\n{{ @Label_modificato }}\n{{ @Label_inviato }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"100","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"150\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"100","version":"37","w":"100%","wizard":""},{"allowedqueries":"qbe_test_opextrbo","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_test_opextrbo","offline":"false","page":"1","parms":"inviato=true","parms_source":"","query":"qbe_test_opextrbo","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"209","waiting_mgs":"","x":"112","y":"4"},{"allowedqueries":"qbe_test_opextrbo","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_test_opextrbo2","offline":"false","page":"1","parms":"modificato=true","parms_source":"","query":"qbe_test_opextrbo","query_async":"true","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"209","waiting_mgs":"","x":"112","y":"25"},{"allowedqueries":"qbe_test_opextrbo","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_test_opextrbo3","offline":"false","page":"1","parms":"annullato=true","parms_source":"","query":"qbe_test_opextrbo","query_async":"true","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"209","waiting_mgs":"","x":"112","y":"46"},{"allowedqueries":"qbe_test_aetesta","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_test_aetesta","offline":"false","page":"1","parms":"inviato=true","parms_source":"","query":"qbe_test_aetesta","query_async":"true","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"209","waiting_mgs":"","x":"112","y":"70"},{"allowedqueries":"qbe_test_aetesta","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_test_aetesta2","offline":"false","page":"1","parms":"modificato=true","parms_source":"","query":"qbe_test_aetesta","query_async":"true","return_fields_type":"true","sequence":"5","type":"SQLDataobj","w":"209","waiting_mgs":"","x":"112","y":"91"},{"allowedqueries":"qbe_test_aetesta","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_test_aetesta3","offline":"false","page":"1","parms":"annullato=true","parms_source":"","query":"qbe_test_aetesta","query_async":"true","return_fields_type":"true","sequence":"6","type":"SQLDataobj","w":"209","waiting_mgs":"","x":"112","y":"112"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"120","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_titolo","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Riepilogo ADE","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_inviato","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"26","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_modificato","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"46","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_annullato","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"66","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_inviato_r","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"87","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_modificato_r","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"107","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_annullato_r","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"127","zindex":"1","zone":""},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"AggiornaDatiADE","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"14","type":"EventReceiver","w":"206","x":"112","y":"136"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_personbo_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"15","type":"EventReceiver","w":"206","x":"112","y":"157"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_ae_opextrbo_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"16","type":"EventReceiver","w":"206","x":"112","y":"178"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_ae_famiglie_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"17","type":"EventReceiver","w":"206","x":"112","y":"199"}]%>
<%/*Description:*/%>
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
window.pg_test_opextrbo_Static=function(){
if(typeof SQLDataobj_qbe_test_opextrbo_ConsumersRendered !='undefined')this.SQLDataobj_qbe_test_opextrbo_ConsumersRendered=SQLDataobj_qbe_test_opextrbo_ConsumersRendered;
if(typeof SQLDataobj_qbe_test_opextrbo2_ConsumersRendered !='undefined')this.SQLDataobj_qbe_test_opextrbo2_ConsumersRendered=SQLDataobj_qbe_test_opextrbo2_ConsumersRendered;
if(typeof SQLDataobj_qbe_test_opextrbo3_ConsumersRendered !='undefined')this.SQLDataobj_qbe_test_opextrbo3_ConsumersRendered=SQLDataobj_qbe_test_opextrbo3_ConsumersRendered;
if(typeof SQLDataobj_qbe_test_aetesta_ConsumersRendered !='undefined')this.SQLDataobj_qbe_test_aetesta_ConsumersRendered=SQLDataobj_qbe_test_aetesta_ConsumersRendered;
if(typeof SQLDataobj_qbe_test_aetesta2_ConsumersRendered !='undefined')this.SQLDataobj_qbe_test_aetesta2_ConsumersRendered=SQLDataobj_qbe_test_aetesta2_ConsumersRendered;
if(typeof SQLDataobj_qbe_test_aetesta3_ConsumersRendered !='undefined')this.SQLDataobj_qbe_test_aetesta3_ConsumersRendered=SQLDataobj_qbe_test_aetesta3_ConsumersRendered;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function SQLDataobj_qbe_test_opextrbo_ConsumersRendered(){
  this.Label_inviato.Value('Operazioni da Inviare: '+this.SQLDataobj_qbe_test_opextrbo.rs.tot);
}
function SQLDataobj_qbe_test_opextrbo2_ConsumersRendered(){
  this.Label_modificato.Value('Operazioni Modificate da inviare: '+this.SQLDataobj_qbe_test_opextrbo2.rs.tot);
}
function SQLDataobj_qbe_test_opextrbo3_ConsumersRendered(){
  this.Label_annullato.Value('Operazioni da Annullare: '+this.SQLDataobj_qbe_test_opextrbo3.rs.tot);
}
function SQLDataobj_qbe_test_aetesta_ConsumersRendered(){
  this.Label_inviato_r.Value('Rapporti da Inviare: '+this.SQLDataobj_qbe_test_aetesta.rs.tot);
}
function SQLDataobj_qbe_test_aetesta2_ConsumersRendered(){
  this.Label_modificato_r.Value('Rapporti Modificati da inviare: '+this.SQLDataobj_qbe_test_aetesta2.rs.tot);
}
function SQLDataobj_qbe_test_aetesta3_ConsumersRendered(){
  this.Label_annullato_r.Value('Rapporti da Annullare: '+this.SQLDataobj_qbe_test_aetesta3.rs.tot);
}
function Aggiorna(_evt){
  this.SQLDataobj_qbe_test_opextrbo.Query();
  this.SQLDataobj_qbe_test_opextrbo2.Query(); 
  this.SQLDataobj_qbe_test_opextrbo3.Query();
  this.SQLDataobj_qbe_test_aetesta.Query();
  this.SQLDataobj_qbe_test_aetesta2.Query(); 
  this.SQLDataobj_qbe_test_aetesta3.Query();
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
.pg_test_opextrbo_container {
}
.pg_test_opextrbo_title_container {
  margin: auto;
}
.pg_test_opextrbo_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:100px;
  height:150px;
}
.pg_test_opextrbo_portlet[Data-page="1"]{
  height:150px;
  width:100%;
}
.pg_test_opextrbo_portlet > .Label_titolo_ctrl {
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
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_titolo_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_titolo_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_test_opextrbo_portlet > .Label_titolo_ctrl > div{
  font-size:120%;
}
.pg_test_opextrbo_portlet > .Label_inviato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_inviato_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_inviato_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_test_opextrbo_portlet > .Label_modificato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_modificato_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_modificato_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_test_opextrbo_portlet > .Label_annullato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:66px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_annullato_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_annullato_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_test_opextrbo_portlet > .Label_inviato_r_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:87px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_inviato_r_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_inviato_r_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_test_opextrbo_portlet > .Label_modificato_r_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:107px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_modificato_r_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_modificato_r_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_test_opextrbo_portlet > .Label_annullato_r_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:127px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_annullato_r_ctrl {
  height:auto;
  min-height:20px;
}
.pg_test_opextrbo_portlet > .Label_annullato_r_ctrl {
  overflow:hidden;
  text-align:center;
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
 String def="[{\"h\":\"150\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"209\",\"x\":\"112\",\"y\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"209\",\"x\":\"112\",\"y\":\"25\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"209\",\"x\":\"112\",\"y\":\"46\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"209\",\"x\":\"112\",\"y\":\"70\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"209\",\"x\":\"112\",\"y\":\"91\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"209\",\"x\":\"112\",\"y\":\"112\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Riepilogo ADE\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"26\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"46\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"66\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"87\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"107\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"127\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"206\",\"x\":\"112\",\"y\":\"136\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"206\",\"x\":\"112\",\"y\":\"157\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"206\",\"x\":\"112\",\"y\":\"178\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"206\",\"x\":\"112\",\"y\":\"199\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_test_opextrbo","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_test_opextrbo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_test_opextrbo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label_titolo= "Riepilogo ADE";
String Label_inviato= "";
String Label_modificato= "";
String Label_annullato= "";
String Label_inviato_r= "";
String Label_modificato_r= "";
String Label_annullato_r= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_test_opextrbo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_test_opextrbo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_test_opextrbo','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_Label_titolo'  formid='<%=idPortlet%>' ps-name='Label_titolo'    class='label Label_titolo_ctrl'><div id='<%=idPortlet%>_Label_titolotbl' style='width:100%;'><%=JSPLib.ToHTML("Riepilogo ADE")%></div></span>
<span id='<%=idPortlet%>_Label_inviato'  formid='<%=idPortlet%>' ps-name='Label_inviato'    class='label Label_inviato_ctrl'><div id='<%=idPortlet%>_Label_inviatotbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label_modificato'  formid='<%=idPortlet%>' ps-name='Label_modificato'    class='label Label_modificato_ctrl'><div id='<%=idPortlet%>_Label_modificatotbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label_annullato'  formid='<%=idPortlet%>' ps-name='Label_annullato'    class='label Label_annullato_ctrl'><div id='<%=idPortlet%>_Label_annullatotbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label_inviato_r'  formid='<%=idPortlet%>' ps-name='Label_inviato_r'    class='label Label_inviato_r_ctrl'><div id='<%=idPortlet%>_Label_inviato_rtbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label_modificato_r'  formid='<%=idPortlet%>' ps-name='Label_modificato_r'    class='label Label_modificato_r_ctrl'><div id='<%=idPortlet%>_Label_modificato_rtbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label_annullato_r'  formid='<%=idPortlet%>' ps-name='Label_annullato_r'    class='label Label_annullato_r_ctrl'><div id='<%=idPortlet%>_Label_annullato_rtbl' style='width:100%;'></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_test_opextrbo');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_test_opextrbo',["100"],["150"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"150","title":"","layer":""}]);
this.SQLDataobj_qbe_test_opextrbo=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_test_opextrbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_test_opextrbo","cmdHash":"<%=JSPLib.cmdHash("qbe_test_opextrbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_test_opextrbo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_test_opextrbo","nrows":"10","page":1,"parms":"inviato=true","parms_source":"","type":"SQLDataobj","w":209,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":112,"y":4});
this.SQLDataobj_qbe_test_opextrbo2=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_test_opextrbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_test_opextrbo","cmdHash":"<%=JSPLib.cmdHash("qbe_test_opextrbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_test_opextrbo2","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_test_opextrbo2","nrows":"10","page":1,"parms":"modificato=true","parms_source":"","type":"SQLDataobj","w":209,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":112,"y":25});
this.SQLDataobj_qbe_test_opextrbo3=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_test_opextrbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_test_opextrbo","cmdHash":"<%=JSPLib.cmdHash("qbe_test_opextrbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_test_opextrbo3","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_test_opextrbo3","nrows":"10","page":1,"parms":"annullato=true","parms_source":"","type":"SQLDataobj","w":209,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":112,"y":46});
this.SQLDataobj_qbe_test_aetesta=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_test_aetesta",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_test_aetesta","cmdHash":"<%=JSPLib.cmdHash("qbe_test_aetesta",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_test_aetesta","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_test_aetesta","nrows":"10","page":1,"parms":"inviato=true","parms_source":"","type":"SQLDataobj","w":209,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":112,"y":70});
this.SQLDataobj_qbe_test_aetesta2=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_test_aetesta",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_test_aetesta","cmdHash":"<%=JSPLib.cmdHash("qbe_test_aetesta",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_test_aetesta2","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_test_aetesta2","nrows":"10","page":1,"parms":"modificato=true","parms_source":"","type":"SQLDataobj","w":209,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":112,"y":91});
this.SQLDataobj_qbe_test_aetesta3=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_test_aetesta",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_test_aetesta","cmdHash":"<%=JSPLib.cmdHash("qbe_test_aetesta",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_test_aetesta3","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_test_aetesta3","nrows":"10","page":1,"parms":"annullato=true","parms_source":"","type":"SQLDataobj","w":209,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":112,"y":112});
this.Label_titolo=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_titolo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"120","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_titolo","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_titolo,false,true)%>","type":"Label","w":100,"x":0,"y":0,"zindex":"1"});
this.Label_inviato=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_inviato","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_inviato","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_inviato,false,true)%>","type":"Label","w":100,"x":0,"y":26,"zindex":"1"});
this.Label_modificato=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_modificato","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_modificato","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_modificato,false,true)%>","type":"Label","w":100,"x":0,"y":46,"zindex":"1"});
this.Label_annullato=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_annullato","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_annullato","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_annullato,false,true)%>","type":"Label","w":100,"x":0,"y":66,"zindex":"1"});
this.Label_inviato_r=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_inviato_r","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_inviato_r","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_inviato_r,false,true)%>","type":"Label","w":100,"x":0,"y":87,"zindex":"1"});
this.Label_modificato_r=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_modificato_r","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_modificato_r","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_modificato_r,false,true)%>","type":"Label","w":100,"x":0,"y":107,"zindex":"1"});
this.Label_annullato_r=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_annullato_r","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_annullato_r","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_annullato_r,false,true)%>","type":"Label","w":100,"x":0,"y":127,"zindex":"1"});
this.AggiornaDatiADE=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_AggiornaDatiADE","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"AggiornaDatiADE","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":206,"x":112,"y":136});
this.armt_personbo_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_personbo_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_personbo_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":206,"x":112,"y":157});
this.armt_ae_opextrbo_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_ae_opextrbo_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_ae_opextrbo_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":206,"x":112,"y":178});
this.armt_ae_famiglie_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_ae_famiglie_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_ae_famiglie_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":206,"x":112,"y":199});
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
<%if(request.getAttribute("pg_test_opextrbo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_test_opextrbo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_test_opextrbo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_AggiornaDatiADE=function(parmsObj){<%=idPortlet%>.AggiornaDatiADE.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_personbo_savedEntity=function(parmsObj){<%=idPortlet%>.armt_personbo_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_ae_opextrbo_savedEntity=function(parmsObj){<%=idPortlet%>.armt_ae_opextrbo_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_ae_famiglie_savedEntity=function(parmsObj){<%=idPortlet%>.armt_ae_famiglie_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLDataobj_qbe_test_opextrbo.firstQuery('true');
window.<%=idPortlet%>.SQLDataobj_qbe_test_opextrbo2.firstQuery('true');
window.<%=idPortlet%>.SQLDataobj_qbe_test_opextrbo3.firstQuery('true');
window.<%=idPortlet%>.SQLDataobj_qbe_test_aetesta.firstQuery('true');
window.<%=idPortlet%>.SQLDataobj_qbe_test_aetesta2.firstQuery('true');
window.<%=idPortlet%>.SQLDataobj_qbe_test_aetesta3.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_test_opextrbo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_test_opextrbo');
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
sp.endPage("pg_test_opextrbo");
}%>
<%! public String getJSPUID() { return "2548505847"; } %>