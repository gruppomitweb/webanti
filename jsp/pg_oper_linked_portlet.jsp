<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Operazioni Collegate',true);\n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Stampa con Dettaglio Anagrafico","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"530","hsl":"","htmlcode":"{{ @Textbox_aragsoc }}\n{{ @LinkZoom_aCodCli }}\n{{ @Textbox_aCodCli }}\n{{ @Textbox_daragsoc }}\n{{ @LinkZoom_daCodCli }}\n{{ @Textbox_daCodCli }}\n\n\n{{ @Ope_Print }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @btnExit }}\n\n\n\n\n\n{{ @Calendario_dadata_reg }}\n{{ @Calendario_adata_reg }}\n{{ @Textbox_adata_reg }}\n{{ @Textbox_dadata_reg }}\n{{ @Box_data_reg }}\n{{ @Label_data_reg }}\n{{ @Label_data_ope }}\n{{ @Calendario_adata_ope }}\n{{ @Textbox_adata_ope }}\n\n{{ @Calendario_dadata_ope }}\n\n{{ @Textbox_dadata_ope }}\n\n\n{{ @Box_data_informazione }}\n\n\n{{ @Image_prn }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"600","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa con Dettaglio","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"540","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"Image_prn","page":"1","path_type":"","sequence":"1","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"229","y":"237","zindex":"6"},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_informazione","page":"1","sequence":"2","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"123","wireframe_props":"","x":"144","y":"11","zindex":"2"},{"allowedentities":"arrt_oper_linked","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTStpOperColl","offline":"false","page":"1","parms":"w_DaDatOpe=Textbox_dadata_ope,w_ADatOpe=Textbox_adata_ope,w_DaDatReg=Textbox_dadata_reg,w_ADatReg=Textbox_adata_reg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"arrt_oper_linked","target":"Ope_Print","type":"SPLinker","w":"197","x":"552","y":"-69"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_ope","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"164","y":"40","zerofilling":"false","zindex":"5"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_ope","page":"1","popup":"true","return_input":"Textbox_dadata_ope","sequence":"5","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"229","y":"40","zindex":"19"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_ope","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"164","y":"83","zerofilling":"false","zindex":"5"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_ope","page":"1","popup":"true","return_input":"Textbox_adata_ope","sequence":"7","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"229","y":"83","zindex":"6"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_ope","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Operazione","w":"123","wireframe_props":"align,value,n_col","x":"144","y":"12","zindex":"22"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_reg","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Registrazione","w":"123","wireframe_props":"align,value,n_col","x":"295","y":"12","zindex":"23"},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_reg","page":"1","sequence":"10","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"123","wireframe_props":"","x":"295","y":"11","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_reg","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"317","y":"41","zerofilling":"false","zindex":"5"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_reg","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"317","y":"83","zerofilling":"false","zindex":"5"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_reg","page":"1","popup":"true","return_input":"Textbox_adata_reg","sequence":"13","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"384","y":"84","zindex":"6"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_reg","page":"1","popup":"true","return_input":"Textbox_dadata_reg","sequence":"14","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"384","y":"41","zindex":"6"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"15","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"277","y":"236","zindex":"1"},{"anchor":"","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","h":"240","hide":"false","layer":"false","layout_steps_values":"{}","name":"Ope_Print","page":"1","sequence":"16","spuid":"","type":"Iframe","w":"540","wireframe_props":"","x":"0","y":"279","zindex":"26"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_daCodCli","page":"1","password":"","picture":"","placeholder":"Da Soggetto","readonly":"false","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"17","y":"144","zerofilling":"false","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_daCodCli,Textbox_daragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_daCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"18","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"30","wireframe_props":"","x":"140","y":"141","zindex":"2","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_daragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"353","wireframe_props":"name","x":"175","y":"143","zerofilling":"false","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_aCodCli","page":"1","password":"","picture":"","placeholder":"A Soggetto","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"17","y":"185","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_aCodCli,Textbox_aragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom_aCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"21","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"30","wireframe_props":"","x":"140","y":"182","zindex":"5","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_aragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"22","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"353","wireframe_props":"name","x":"175","y":"184","zerofilling":"false","zindex":"6"}]%>
<%/*Description:Stampa con Dettaglio Anagrafico*/%>
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
window.pg_oper_linked_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom_daCodCli.addObserverFixedVars();
this.LinkZoom_aCodCli.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Stampa Operazioni Collegate',true);
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
.pg_oper_linked_container {
}
.pg_oper_linked_title_container {
  margin: auto;
}
.pg_oper_linked_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1024px;
  min-width:600px;
  height:530px;
}
.pg_oper_linked_portlet[Data-page="1"]{
  height:530px;
  width:100%;
}
.pg_oper_linked_portlet > .Image_prn_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:237px;
  left:229px;
  left:42.407406%;
  right:281px;
  right:52.037037%;
  width:auto;
  height:30px;
}
.pg_oper_linked_portlet > .Image_prn_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_oper_linked_portlet > .Box_data_informazione_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:11px;
  left:144px;
  left:26.666666%;
  right:273px;
  right:50.555557%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_oper_linked_portlet > .Box_data_informazione_ctrl {
  height:111px;
}
.pg_oper_linked_portlet > .Box_data_informazione_ctrl > .box_content {
  height:100%;
}
.pg_oper_linked_portlet > .Box_data_informazione_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_oper_linked_portlet > .Textbox_dadata_ope_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:40px;
  left:164px;
  left:30.37037%;
  right:316px;
  right:58.51852%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_dadata_ope_ctrl {
}
.pg_oper_linked_portlet > .Textbox_dadata_ope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .Calendario_dadata_ope_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:40px;
  left:229px;
  left:42.407406%;
  right:291px;
  right:53.88889%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_adata_ope_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:83px;
  left:164px;
  left:30.37037%;
  right:316px;
  right:58.51852%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_adata_ope_ctrl {
}
.pg_oper_linked_portlet > .Textbox_adata_ope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .Calendario_adata_ope_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:83px;
  left:229px;
  left:42.407406%;
  right:291px;
  right:53.88889%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Label_data_ope_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:12px;
  left:144px;
  left:26.666666%;
  right:273px;
  right:50.555557%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_oper_linked_portlet > .Label_data_ope_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oper_linked_portlet > .Label_data_ope_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_oper_linked_portlet > .Label_data_reg_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:12px;
  left:295px;
  left:54.62963%;
  right:122px;
  right:22.592592%;
  width:auto;
  height:auto;
  min-height:22px;
}
.pg_oper_linked_portlet > .Label_data_reg_ctrl {
  height:auto;
  min-height:22px;
}
.pg_oper_linked_portlet > .Label_data_reg_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_oper_linked_portlet > .Box_data_reg_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:11px;
  left:295px;
  left:54.62963%;
  right:122px;
  right:22.592592%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_oper_linked_portlet > .Box_data_reg_ctrl {
  height:111px;
}
.pg_oper_linked_portlet > .Box_data_reg_ctrl > .box_content {
  height:100%;
}
.pg_oper_linked_portlet > .Box_data_reg_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_oper_linked_portlet > .Textbox_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:41px;
  left:317px;
  left:58.703705%;
  right:163px;
  right:30.185184%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_dadata_reg_ctrl {
}
.pg_oper_linked_portlet > .Textbox_dadata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .Textbox_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:83px;
  left:317px;
  left:58.703705%;
  right:163px;
  right:30.185184%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_adata_reg_ctrl {
}
.pg_oper_linked_portlet > .Textbox_adata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .Calendario_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:84px;
  left:384px;
  left:71.111115%;
  right:136px;
  right:25.185184%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Calendario_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:41px;
  left:384px;
  left:71.111115%;
  right:136px;
  right:25.185184%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:236px;
  left:277px;
  left:51.296295%;
  right:233px;
  right:43.148148%;
  width:auto;
  height:30px;
}
.pg_oper_linked_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_oper_linked_portlet > .Ope_Print_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:279px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:240px;
}
.pg_oper_linked_portlet > .Textbox_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:144px;
  left:17px;
  left:3.148148%;
  right:403px;
  right:74.62963%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_daCodCli_ctrl {
}
.pg_oper_linked_portlet > .Textbox_daCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .LinkZoom_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:141px;
  left:140px;
  left:25.925926%;
  right:370px;
  right:68.51852%;
  width:auto;
  height:30px;
}
.pg_oper_linked_portlet > .Textbox_daragsoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:143px;
  left:175px;
  left:32.407406%;
  right:12px;
  right:2.2222223%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_daragsoc_ctrl {
}
.pg_oper_linked_portlet > .Textbox_daragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .Textbox_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:185px;
  left:17px;
  left:3.148148%;
  right:403px;
  right:74.62963%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_aCodCli_ctrl {
}
.pg_oper_linked_portlet > .Textbox_aCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oper_linked_portlet > .LinkZoom_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:182px;
  left:140px;
  left:25.925926%;
  right:370px;
  right:68.51852%;
  width:auto;
  height:30px;
}
.pg_oper_linked_portlet > .Textbox_aragsoc_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:184px;
  left:175px;
  left:32.407406%;
  right:12px;
  right:2.2222223%;
  width:auto;
  height:20px;
}
.pg_oper_linked_portlet > .Textbox_aragsoc_ctrl {
}
.pg_oper_linked_portlet > .Textbox_aragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"530\",\"layout_steps_values\":{},\"pages_names\":\"Stampa con Dettaglio\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"540\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"229\",\"y\":\"237\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"144\",\"y\":\"11\",\"zindex\":\"2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"552\",\"y\":\"-69\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_ope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"164\",\"y\":\"40\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_ope\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"229\",\"y\":\"40\",\"zindex\":\"19\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_ope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"164\",\"y\":\"83\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_ope\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"229\",\"y\":\"83\",\"zindex\":\"6\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_ope\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Operazione\",\"w\":\"123\",\"x\":\"144\",\"y\":\"12\",\"zindex\":\"22\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_reg\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Registrazione\",\"w\":\"123\",\"x\":\"295\",\"y\":\"12\",\"zindex\":\"23\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_reg\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"295\",\"y\":\"11\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"317\",\"y\":\"41\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"317\",\"y\":\"83\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"384\",\"y\":\"84\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"384\",\"y\":\"41\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"277\",\"y\":\"236\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"240\",\"layout_steps_values\":{},\"name\":\"Ope_Print\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"540\",\"x\":\"0\",\"y\":\"279\",\"zindex\":\"26\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"17\",\"y\":\"144\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"140\",\"y\":\"141\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"353\",\"x\":\"175\",\"y\":\"143\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"17\",\"y\":\"185\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"140\",\"y\":\"182\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"353\",\"x\":\"175\",\"y\":\"184\",\"zindex\":\"6\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_oper_linked","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_oper_linked_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_oper_linked','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date Textbox_dadata_ope= JSPLib.NullDate();
if(request.getAttribute("pg_oper_linked_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_oper_linked_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
java.sql.Date Textbox_adata_ope= JSPLib.NullDate();
String Label_data_ope= "Data Operazione";
String Label_data_reg= "Data Registrazione";
java.sql.Date Textbox_dadata_reg= JSPLib.NullDate();
java.sql.Date Textbox_adata_reg= JSPLib.NullDate();
String Textbox_daCodCli= "";
if(request.getAttribute("pg_oper_linked_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Textbox_daragsoc= "";
String Textbox_aCodCli= "";
String Textbox_aragsoc= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_oper_linked_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_oper_linked_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_oper_linked_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_oper_linked','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_Image_prn' class='image-default Image_prn_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_Box_data_informazione' class='Box_data_informazione_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_informazione_td' class='box_content'></div>
</div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_ope_wrp'><input id='<%=idPortlet%>_Textbox_dadata_ope' name='Textbox_dadata_ope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_ope' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_ope>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_ope' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_ope.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_ope_wrp'><input id='<%=idPortlet%>_Textbox_adata_ope' name='Textbox_adata_ope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_ope' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_ope>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_ope' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_ope.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label_data_ope'  formid='<%=idPortlet%>' ps-name='Label_data_ope'    class='label Label_data_ope_ctrl'><div id='<%=idPortlet%>_Label_data_opetbl' style='width:100%;'><%=JSPLib.ToHTML("Data Operazione")%></div></span>
<span id='<%=idPortlet%>_Label_data_reg'  formid='<%=idPortlet%>' ps-name='Label_data_reg'    class='label Label_data_reg_ctrl'><div id='<%=idPortlet%>_Label_data_regtbl' style='width:100%;'><%=JSPLib.ToHTML("Data Registrazione")%></div></span>
<div id='<%=idPortlet%>_Box_data_reg' class='Box_data_reg_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_reg_td' class='box_content'></div>
</div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_reg_wrp'><input id='<%=idPortlet%>_Textbox_dadata_reg' name='Textbox_dadata_reg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_reg' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_reg>Da</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_reg_wrp'><input id='<%=idPortlet%>_Textbox_adata_reg' name='Textbox_adata_reg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_reg' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_reg>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <a id='<%=idPortlet%>_btnExit' class='image-default btnExit_ctrl'   target=''>&#xea01;</a>
<div id='<%=idPortlet%>_Ope_Print_DIV'>&nbsp;</div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_daCodCli_wrp'><input id='<%=idPortlet%>_Textbox_daCodCli' name='Textbox_daCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_daCodCli>Da Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_daragsoc_wrp'><input id='<%=idPortlet%>_Textbox_daragsoc' name='Textbox_daragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daragsoc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_aCodCli_wrp'><input id='<%=idPortlet%>_Textbox_aCodCli' name='Textbox_aCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_aCodCli>A Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_aragsoc_wrp'><input id='<%=idPortlet%>_Textbox_aragsoc' name='Textbox_aragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aragsoc' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_oper_linked');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_oper_linked',["540"],["530"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"540","h":"530","title":"Stampa con Dettaglio","layer":"false","npage":"1"}]);
this.Image_prn=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default Image_prn_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_prn","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"Image_prn","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":229,"y":237,"zindex":"6"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Box_data_informazione=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_informazione","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_informazione","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":123,"x":144,"y":11,"zindex":"2"});
this.RTStpOperColl=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_oper_linked",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStpOperColl","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStpOperColl","offline":false,"page":1,"parms":"w_DaDatOpe=Textbox_dadata_ope,w_ADatOpe=Textbox_adata_ope,w_DaDatReg=Textbox_dadata_reg,w_ADatReg=Textbox_adata_reg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_oper_linked","target":"Ope_Print","type":"SPLinker","w":197,"x":552,"y":-69});
this.RTStpOperColl.m_cID='<%=JSPLib.cmdHash("routine,arrt_oper_linked",request.getSession())%>';
this.Textbox_dadata_ope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_ope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_ope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_ope%>","w":60,"x":164,"y":40,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_dadata_ope=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_ope','Calendario_dadata_ope',229,40,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_ope',{});
this.Textbox_adata_ope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_ope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_ope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_ope%>","w":60,"x":164,"y":83,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_ope=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_ope','Calendario_adata_ope',229,83,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_ope',{});
this.Label_data_ope=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_ope","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_ope","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_ope,false,true)%>","type":"Label","w":123,"x":144,"y":12,"zindex":"22"});
this.Label_data_reg=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_reg","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_reg","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_reg,false,true)%>","type":"Label","w":123,"x":295,"y":12,"zindex":"23"});
this.Box_data_reg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_reg","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_reg","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":123,"x":295,"y":11,"zindex":"2"});
this.Textbox_dadata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_reg%>","w":60,"x":317,"y":41,"zerofilling":false,"zindex":"5","zoom":""});
this.Textbox_adata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_reg%>","w":60,"x":317,"y":83,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_reg','Calendario_adata_reg',384,84,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_reg',{});
this.Calendario_dadata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_reg','Calendario_dadata_reg',384,41,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_reg',{});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":277,"y":236,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Ope_Print=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_Ope_Print","default_portlet":"","h":240,"hide":"false","layer":false,"layout_steps_values":{},"name":"Ope_Print","name_iframe":"Ope_Print","page":1,"spuid":"","type":"Iframe","w":540,"x":0,"y":279,"zindex":"26"});
this.Textbox_daCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_daCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daCodCli,false,true)%>","w":120,"x":17,"y":144,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_oper_linked_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_daCodCli,Textbox_daragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_oper_linked_portlet.jspLinkZoom_daCodCli",request.getSession())%>","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_daCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":30,"x":140,"y":141,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_daragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_daragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daragsoc,false,true)%>","w":353,"x":175,"y":143,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_aCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_aCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aCodCli,false,true)%>","w":120,"x":17,"y":185,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_aCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_oper_linked_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_aCodCli,Textbox_aragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_oper_linked_portlet.jspLinkZoom_aCodCli",request.getSession())%>","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_aCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":30,"x":140,"y":182,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_aragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_aragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aragsoc,false,true)%>","w":353,"x":175,"y":184,"zerofilling":false,"zindex":"6","zoom":""});
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
<%if(request.getAttribute("pg_oper_linked_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_oper_linked_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_oper_linked_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image_prn.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_oper_linked',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_oper_linked');
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
sp.endPage("pg_oper_linked");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_daCodCli")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aCodCli")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "1929534180"; } %>