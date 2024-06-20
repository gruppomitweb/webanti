<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Elenco Legami tra Soggetti (AUI)',true);\n  this.getTitlePortlet().AppendButton({\n    id:\"Print\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg(\"Stampa i legami tra soggetti\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb06;\"},\n    action:'javascript:' + this.formid +'.Stampa()'\n  },2);   \n}\n\nfunction Stampa() {\n  if (confirm(\"Confermi la stampa?\")) {\n    this.RTStpLegami.Link()\n  }   \n}  \n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Stampa Elenco Legami (AUI)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"530","hsl":"","htmlcode":"{{ @Label_data_ope_Copy }}\n{{ @Calendario_adata_fin }}\n{{ @Textbox_adata_fin }}\n{{ @Calendario_dadata_fin }}\n{{ @Textbox_dadata_fin }}\n{{ @Box_data_informazione_Copy }}\n\n\n\n\n\n\n\n\n\n{{ @Textbox_aragsoc }}\n{{ @LinkZoom_aCodCli }}\n{{ @Textbox_aCodCli }}\n{{ @Textbox_daragsoc }}\n{{ @LinkZoom_daCodCli }}\n{{ @Textbox_daCodCli }}\n\n\n{{ @Ope_Print }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @Label_data_ope }}\n{{ @Calendario_adata_ini }}\n{{ @Textbox_adata_ini }}\n\n{{ @Calendario_dadata_ini }}\n\n{{ @Textbox_dadata_ini }}\n\n\n{{ @Box_data_informazione }}\n\n\n\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"700","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa Elenco Legami (AUI)","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"700","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_fin","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"368","y":"37","zerofilling":"false","zindex":"5"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_fin","page":"1","popup":"true","return_input":"Textbox_dadata_fin","sequence":"2","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"433","y":"37","zindex":"19"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_fin","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"368","y":"80","zerofilling":"false","zindex":"5"},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_informazione","page":"1","sequence":"4","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"139","wireframe_props":"","x":"168","y":"7","zindex":"2"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_fin","page":"1","popup":"true","return_input":"Textbox_adata_fin","sequence":"5","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"433","y":"80","zindex":"6"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTStpLegami","offline":"false","page":"1","parms":"ReportName=arrp_stplegami_sint.vrp,w_daSoc=Textbox_daCodCli,w_aSoc=Textbox_aCodCli,w_DaDatIni=Textbox_dadata_ini,w_ADatIni=Textbox_adata_ini,w_DaDatFin=Textbox_dadata_fin,w_ADatFin=Textbox_adata_fin,w_DescAzi=gDescAzi,w_descsoc1=Textbox_daragsoc,w_descsoc2=Textbox_aragsoc,rotation=LANDSCAPE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"","target":"Ope_Print","type":"SPLinker","w":"197","x":"706","y":"-92"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_ope_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Chiusura","w":"139","wireframe_props":"align,value,n_col","x":"348","y":"9","zindex":"22"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_ini","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"188","y":"36","zerofilling":"false","zindex":"5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"725","y":"-50"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_ini","page":"1","popup":"true","return_input":"Textbox_dadata_ini","sequence":"10","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"253","y":"36","zindex":"19"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_ini","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"188","y":"79","zerofilling":"false","zindex":"5"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_ini","page":"1","popup":"true","return_input":"Textbox_adata_ini","sequence":"12","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"253","y":"79","zindex":"6"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_ope","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Apertura","w":"139","wireframe_props":"align,value,n_col","x":"168","y":"8","zindex":"22"},{"anchor":"","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","h":"240","hide":"false","layer":"false","layout_steps_values":"{}","name":"Ope_Print","page":"1","sequence":"14","spuid":"","type":"Iframe","w":"700","wireframe_props":"","x":"0","y":"287","zindex":"26"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_daCodCli","page":"1","password":"","picture":"","placeholder":"Da Soggetto","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"96","y":"153","zerofilling":"false","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_daCodCli,Textbox_daragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_daCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"16","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"30","wireframe_props":"","x":"219","y":"150","zindex":"2","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_daragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"384","wireframe_props":"name","x":"254","y":"152","zerofilling":"false","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_aCodCli","page":"1","password":"","picture":"","placeholder":"A Soggetto","readonly":"false","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"96","y":"194","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_aCodCli,Textbox_aragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom_aCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"19","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"30","wireframe_props":"","x":"219","y":"191","zindex":"5","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_aragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"384","wireframe_props":"name","x":"254","y":"193","zerofilling":"false","zindex":"6"},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_informazione_Copy","page":"1","sequence":"21","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"139","wireframe_props":"","x":"348","y":"8","zindex":"2"}]%>
<%/*Description:Stampa Elenco Legami (AUI)*/%>
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
window.pg_stplegami_sint_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Stampa !='undefined')this.Stampa=Stampa;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom_daCodCli.addObserverFixedVars();
this.LinkZoom_aCodCli.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Stampa Elenco Legami tra Soggetti (AUI)',true);
  this.getTitlePortlet().AppendButton({
    id:"Print",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg("Stampa i legami tra soggetti"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb06;"},
    action:'javascript:' + this.formid +'.Stampa()'
  },2);   
}
function Stampa() {
  if (confirm("Confermi la stampa?")) {
    this.RTStpLegami.Link()
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
.pg_stplegami_sint_container {
}
.pg_stplegami_sint_title_container {
  margin: auto;
}
.pg_stplegami_sint_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1024px;
  min-width:700px;
  height:530px;
}
.pg_stplegami_sint_portlet[Data-page="1"]{
  height:530px;
  width:100%;
}
.pg_stplegami_sint_portlet > .Textbox_dadata_fin_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:37px;
  left:368px;
  left:52.57143%;
  right:272px;
  right:38.857143%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_dadata_fin_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_dadata_fin_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .Calendario_dadata_fin_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:37px;
  left:433px;
  left:61.857143%;
  right:247px;
  right:35.285713%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_adata_fin_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:80px;
  left:368px;
  left:52.57143%;
  right:272px;
  right:38.857143%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_adata_fin_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_adata_fin_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:7px;
  left:168px;
  left:24.0%;
  right:393px;
  right:56.142857%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_ctrl {
  height:111px;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_ctrl > .box_content {
  height:100%;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stplegami_sint_portlet > .Calendario_adata_fin_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:80px;
  left:433px;
  left:61.857143%;
  right:247px;
  right:35.285713%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Label_data_ope_Copy_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:9px;
  left:348px;
  left:49.714287%;
  right:213px;
  right:30.428572%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_stplegami_sint_portlet > .Label_data_ope_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stplegami_sint_portlet > .Label_data_ope_Copy_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stplegami_sint_portlet > .Textbox_dadata_ini_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:36px;
  left:188px;
  left:26.857143%;
  right:452px;
  right:64.57143%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_dadata_ini_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_dadata_ini_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .Calendario_dadata_ini_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:36px;
  left:253px;
  left:36.142857%;
  right:427px;
  right:61.0%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_adata_ini_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:79px;
  left:188px;
  left:26.857143%;
  right:452px;
  right:64.57143%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_adata_ini_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_adata_ini_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .Calendario_adata_ini_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:79px;
  left:253px;
  left:36.142857%;
  right:427px;
  right:61.0%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Label_data_ope_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:8px;
  left:168px;
  left:24.0%;
  right:393px;
  right:56.142857%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_stplegami_sint_portlet > .Label_data_ope_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stplegami_sint_portlet > .Label_data_ope_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stplegami_sint_portlet > .Ope_Print_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:287px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:240px;
}
.pg_stplegami_sint_portlet > .Textbox_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:153px;
  left:96px;
  left:13.714286%;
  right:484px;
  right:69.14286%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_daCodCli_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_daCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .LinkZoom_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:150px;
  left:219px;
  left:31.285715%;
  right:451px;
  right:64.42857%;
  width:auto;
  height:30px;
}
.pg_stplegami_sint_portlet > .Textbox_daragsoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:152px;
  left:254px;
  left:36.285713%;
  right:62px;
  right:8.857142%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_daragsoc_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_daragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .Textbox_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:194px;
  left:96px;
  left:13.714286%;
  right:484px;
  right:69.14286%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_aCodCli_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_aCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .LinkZoom_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:191px;
  left:219px;
  left:31.285715%;
  right:451px;
  right:64.42857%;
  width:auto;
  height:30px;
}
.pg_stplegami_sint_portlet > .Textbox_aragsoc_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:193px;
  left:254px;
  left:36.285713%;
  right:62px;
  right:8.857142%;
  width:auto;
  height:20px;
}
.pg_stplegami_sint_portlet > .Textbox_aragsoc_ctrl {
}
.pg_stplegami_sint_portlet > .Textbox_aragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_Copy_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:8px;
  left:348px;
  left:49.714287%;
  right:213px;
  right:30.428572%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_Copy_ctrl {
  height:111px;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_Copy_ctrl > .box_content {
  height:100%;
}
.pg_stplegami_sint_portlet > .Box_data_informazione_Copy_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
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
 String def="[{\"h\":\"530\",\"layout_steps_values\":{},\"pages_names\":\"Stampa Elenco Legami (AUI)\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"700\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_fin\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"368\",\"y\":\"37\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_fin\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"433\",\"y\":\"37\",\"zindex\":\"19\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_fin\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"368\",\"y\":\"80\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_informazione\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"139\",\"x\":\"168\",\"y\":\"7\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_fin\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"433\",\"y\":\"80\",\"zindex\":\"6\"},{\"h\":\"20\",\"name\":\"RTStpLegami\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"706\",\"y\":\"-92\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_ope_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Chiusura\",\"w\":\"139\",\"x\":\"348\",\"y\":\"9\",\"zindex\":\"22\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_ini\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"188\",\"y\":\"36\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"725\",\"y\":\"-50\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_ini\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"253\",\"y\":\"36\",\"zindex\":\"19\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_ini\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"188\",\"y\":\"79\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_ini\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"253\",\"y\":\"79\",\"zindex\":\"6\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_ope\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Apertura\",\"w\":\"139\",\"x\":\"168\",\"y\":\"8\",\"zindex\":\"22\"},{\"anchor\":\"\",\"h\":\"240\",\"layout_steps_values\":{},\"name\":\"Ope_Print\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"700\",\"x\":\"0\",\"y\":\"287\",\"zindex\":\"26\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"96\",\"y\":\"153\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"219\",\"y\":\"150\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"384\",\"x\":\"254\",\"y\":\"152\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"96\",\"y\":\"194\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"219\",\"y\":\"191\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"384\",\"x\":\"254\",\"y\":\"193\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_informazione_Copy\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"139\",\"x\":\"348\",\"y\":\"8\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stplegami_sint","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stplegami_sint_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stplegami_sint','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date Textbox_dadata_fin= JSPLib.NullDate();
if(request.getAttribute("pg_stplegami_sint_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_stplegami_sint_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
java.sql.Date Textbox_adata_fin= JSPLib.NullDate();
String Label_data_ope_Copy= "Data Chiusura";
java.sql.Date Textbox_dadata_ini= JSPLib.NullDate();
String gDescAzi=sp.getGlobal("gDescAzi","");
java.sql.Date Textbox_adata_ini= JSPLib.NullDate();
String Label_data_ope= "Data Apertura";
String Textbox_daCodCli= "";
if(request.getAttribute("pg_stplegami_sint_firstinclusion")==null){%>
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
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stplegami_sint_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stplegami_sint_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stplegami_sint_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stplegami_sint','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_fin_wrp'><input id='<%=idPortlet%>_Textbox_dadata_fin' name='Textbox_dadata_fin' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_fin' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_fin>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_fin' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_fin.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_fin_wrp'><input id='<%=idPortlet%>_Textbox_adata_fin' name='Textbox_adata_fin' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_fin' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_fin>A</label></span>
<div id='<%=idPortlet%>_Box_data_informazione' class='Box_data_informazione_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_informazione_td' class='box_content'></div>
</div>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_fin' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_fin.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label_data_ope_Copy'  formid='<%=idPortlet%>' ps-name='Label_data_ope_Copy'    class='label Label_data_ope_Copy_ctrl'><div id='<%=idPortlet%>_Label_data_ope_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Data Chiusura")%></div></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_ini_wrp'><input id='<%=idPortlet%>_Textbox_dadata_ini' name='Textbox_dadata_ini' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_ini' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_ini>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_ini' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_ini.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_ini_wrp'><input id='<%=idPortlet%>_Textbox_adata_ini' name='Textbox_adata_ini' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_ini' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_ini>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_ini' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_ini.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label_data_ope'  formid='<%=idPortlet%>' ps-name='Label_data_ope'    class='label Label_data_ope_ctrl'><div id='<%=idPortlet%>_Label_data_opetbl' style='width:100%;'><%=JSPLib.ToHTML("Data Apertura")%></div></span>
<div id='<%=idPortlet%>_Ope_Print_DIV'>&nbsp;</div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_daCodCli_wrp'><input id='<%=idPortlet%>_Textbox_daCodCli' name='Textbox_daCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_daCodCli>Da Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_daragsoc_wrp'><input id='<%=idPortlet%>_Textbox_daragsoc' name='Textbox_daragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daragsoc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_aCodCli_wrp'><input id='<%=idPortlet%>_Textbox_aCodCli' name='Textbox_aCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_aCodCli>A Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_aragsoc_wrp'><input id='<%=idPortlet%>_Textbox_aragsoc' name='Textbox_aragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aragsoc' /></span>
<div id='<%=idPortlet%>_Box_data_informazione_Copy' class='Box_data_informazione_Copy_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_informazione_Copy_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stplegami_sint');
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
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa i legami tra soggetti",true)+","+JSPLib.ToJSValue(sp.translate("Stampa i legami tra soggetti"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stplegami_sint',["700"],["530"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"700","h":"530","title":"Stampa Elenco Legami (AUI)","layer":"false","npage":"1"}]);
this.Textbox_dadata_fin=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_fin","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_fin","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_fin%>","w":60,"x":368,"y":37,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_dadata_fin=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_fin','Calendario_dadata_fin',433,37,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_fin',{});
this.Textbox_adata_fin=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_fin","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_fin","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_fin%>","w":60,"x":368,"y":80,"zerofilling":false,"zindex":"5","zoom":""});
this.Box_data_informazione=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_informazione","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_informazione","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":139,"x":168,"y":7,"zindex":"2"});
this.Calendario_adata_fin=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_fin','Calendario_adata_fin',433,80,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_fin',{});
this.RTStpLegami=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStpLegami","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStpLegami","offline":false,"page":1,"parms":"ReportName=arrp_stplegami_sint.vrp,w_daSoc=Textbox_daCodCli,w_aSoc=Textbox_aCodCli,w_DaDatIni=Textbox_dadata_ini,w_ADatIni=Textbox_adata_ini,w_DaDatFin=Textbox_dadata_fin,w_ADatFin=Textbox_adata_fin,w_DescAzi=gDescAzi,w_descsoc1=Textbox_daragsoc,w_descsoc2=Textbox_aragsoc,rotation=LANDSCAPE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"Ope_Print","type":"SPLinker","w":197,"x":706,"y":-92});
this.RTStpLegami.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Label_data_ope_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_ope_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_ope_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_ope_Copy,false,true)%>","type":"Label","w":139,"x":348,"y":9,"zindex":"22"});
this.Textbox_dadata_ini=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_ini","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_ini","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_ini%>","w":60,"x":188,"y":36,"zerofilling":false,"zindex":"5","zoom":""});
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.Calendario_dadata_ini=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_ini','Calendario_dadata_ini',253,36,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_ini',{});
this.Textbox_adata_ini=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_ini","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_ini","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_ini%>","w":60,"x":188,"y":79,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_ini=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_ini','Calendario_adata_ini',253,79,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_ini',{});
this.Label_data_ope=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_ope","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_ope","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_ope,false,true)%>","type":"Label","w":139,"x":168,"y":8,"zindex":"22"});
this.Ope_Print=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_Ope_Print","default_portlet":"","h":240,"hide":"false","layer":false,"layout_steps_values":{},"name":"Ope_Print","name_iframe":"Ope_Print","page":1,"spuid":"","type":"Iframe","w":700,"x":0,"y":287,"zindex":"26"});
this.Textbox_daCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_daCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daCodCli,false,true)%>","w":120,"x":96,"y":153,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stplegami_sint_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_daCodCli,Textbox_daragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stplegami_sint_portlet.jspLinkZoom_daCodCli",request.getSession())%>","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_daCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":30,"x":219,"y":150,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_daragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_daragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daragsoc,false,true)%>","w":384,"x":254,"y":152,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_aCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_aCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aCodCli,false,true)%>","w":120,"x":96,"y":194,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_aCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stplegami_sint_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_aCodCli,Textbox_aragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stplegami_sint_portlet.jspLinkZoom_aCodCli",request.getSession())%>","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_aCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":30,"x":219,"y":191,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_aragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_aragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aragsoc,false,true)%>","w":384,"x":254,"y":193,"zerofilling":false,"zindex":"6","zoom":""});
this.Box_data_informazione_Copy=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_informazione_Copy","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_informazione_Copy","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":139,"x":348,"y":8,"zindex":"2"});
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
<%if(request.getAttribute("pg_stplegami_sint_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stplegami_sint_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stplegami_sint_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stplegami_sint',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stplegami_sint');
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
sp.endPage("pg_stplegami_sint");
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
<%! public String getJSPUID() { return "1961862539"; } %>