<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Rapporti con Dettaglio Anagrafico',true)\n\nfunction Image_prn_Click(){\n  if(this.Radio_OrderBy.Value()=='D'){\n\u002f\u002f     this.Variable_OrderBy.Value('DATAREG,NUMPROG,IDBASE,TIPOREC');\n    this.Variable_OrderBy.Value('DATAREG,NUMPROG,IDBASE');\n  }else{\n    if(this.Radio_OrderBy.Value()=='N'){\n\u002f\u002f       this.Variable_OrderBy.Value('NUMPROG,DATAREG,IDBASE,TIPOREC');\n      this.Variable_OrderBy.Value('NUMPROG,DATAREG,IDBASE');\n    }else{\n      this.Variable_OrderBy.Value('');\n    }\n  }\n  this.Iframe_elaborazione.Show();\n  this.SPLinker_arrp_stp_info_dett_anagrafiche.Link();\n}\n\nfunction this_Calculate(){\n  this.Iframe_elaborazione.Hide();\n}\n\nfunction Checkbox_scheda_onChange(){\n  if(this.Checkbox_scheda.Value()){\n    this.Textbox_respons.Show();\n  }else{\n    this.Textbox_respons.Hide();\n  }\n}\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Rapporti con Dettaglio Anagrafico","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"400","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"600","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Rapporti con Dettaglio Anagrafico","portlet_position":"align center","positioning":"absolute","roles":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"480","version":"37","w":"100%","wizard":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","create_undercond":"","h":"100","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"Box_data_informazione","page":"1","sequence":"1","shrinkable":"","stretch":"false","target":"","type":"Box","w":"123","wireframe_props":"","x":"96","y":"0","zindex":"1"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"2","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"256","y":"327","zindex":"1"},{"calculate":"'DATAREG,NUMPROG,IDBASE'","dataobj":"","field":"","h":"20","init":"true","init_par":"","name":"Variable_OrderBy","page":"1","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"487","y":"221"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label_data_info","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data Informazione","w":"123","wireframe_props":"align,value,n_col","x":"96","y":"0","zindex":"6"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_info","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"5","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"117","y":"32","zerofilling":"false","zindex":"4"},{"anchor":"","css_class":"","font":"","font_size":"","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario_dadata_info","page":"1","popup":"true","return_input":"Textbox_dadata_info","sequence":"6","type":"Calendario","w":"20","wireframe_props":"","x":"182","y":"32","zindex":"5"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_info","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"7","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"117","y":"75","zerofilling":"false","zindex":"4"},{"anchor":"","css_class":"","font":"","font_size":"","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario_adata_info","page":"1","popup":"true","return_input":"Textbox_adata_info","sequence":"8","type":"Calendario","w":"20","wireframe_props":"","x":"182","y":"75","zindex":"5"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","create_undercond":"","h":"100","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"Box_data_reg","page":"1","sequence":"9","shrinkable":"","stretch":"false","target":"","type":"Box","w":"123","wireframe_props":"","x":"260","y":"0","zindex":"1"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label_data_reg","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data Registrazione","w":"123","wireframe_props":"align,value,n_col","x":"260","y":"0","zindex":"6"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_reg","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"282","y":"32","zerofilling":"false","zindex":"4"},{"anchor":"","css_class":"","font":"","font_size":"","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario_dadata_reg","page":"1","popup":"true","return_input":"Textbox_dadata_reg","sequence":"12","type":"Calendario","w":"20","wireframe_props":"","x":"349","y":"32","zindex":"5"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_reg","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"13","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"282","y":"75","zerofilling":"false","zindex":"4"},{"anchor":"","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Solo rapporti in essere","layout_steps_values":"{}","name":"Checkbox_essere","page":"1","sequence":"14","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"178","wireframe_props":"label_text","x":"96","y":"105","zindex":"7"},{"anchor":"","css_class":"","font":"","font_size":"","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario_adata_reg","page":"1","popup":"true","return_input":"Textbox_adata_reg","sequence":"15","type":"Calendario","w":"20","wireframe_props":"","x":"349","y":"75","zindex":"5"},{"anchor":"","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"true","init_par":"","label_text":"Formato Scheda","layout_steps_values":"{}","name":"Checkbox_scheda","page":"1","sequence":"16","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"130","wireframe_props":"label_text","x":"260","y":"105","zindex":"8"},{"anchor":"top-center","calculate":"'S'","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"50","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layout_steps_values":"{}","name":"Radio_TitEssere","orientation":"vertical","page":"1","picture":"","sequence":"17","tabindex":"","textlist":"Estrazione solo dei Titolari Effettivi in essere nel periodo di date scelto,Estrazione dei Titolari Effettivi SENZA filtro per periodo di date scelto","type":"Radio","typevar":"character","valuelist":"S,N","visible":"true","w":"478","wireframe_props":"","x":"1","y":"131","zindex":"9"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label_ordinamento","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Stampa ordinata per","w":"480","wireframe_props":"align,value,n_col","x":"0","y":"186","zindex":"10"},{"anchor":"top-center","calculate":"'D'","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"45","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layout_steps_values":"{}","name":"Radio_OrderBy","orientation":"vertical","page":"1","picture":"","sequence":"19","tabindex":"","textlist":"Data Registraz. N. Progressivo,N. Progressivo Data Registraz.","type":"Radio","typevar":"character","valuelist":"D,N","visible":"true","w":"230","wireframe_props":"","x":"135","y":"210","zindex":"11"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"6","name":"Textbox_dipendenza","page":"1","password":"","picture":"","placeholder":"Dipendenza","readonly":"false","scroll":"false","sequence":"20","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"75","wireframe_props":"name","x":"83","y":"269","zerofilling":"false","zindex":"12"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"Textbox_dipendenza,Textbox_desc_dipendenza","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"Textbox_dipendenza","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_dipendenza","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"21","servlet":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"161","y":"269","zindex":"13","zoomtitle":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"30","name":"Textbox_desc_dipendenza","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"22","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"225","wireframe_props":"name","x":"184","y":"269","zerofilling":"false","zindex":"14"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"Responsabile Antiriciclaggio","hide":"true","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_respons","page":"1","password":"","picture":"","placeholder":"Responsabile Antiriciclaggio","readonly":"false","scroll":"false","sequence":"23","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"326","wireframe_props":"name","x":"83","y":"305","zerofilling":"false","zindex":"16"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"Image_prn","page":"1","path_type":"","sequence":"24","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"206","y":"327","zindex":"6"},{"async":"false","entity_type":"report","h":"20","m_cAction":"","name":"SPLinker_arrp_stp_info_dett_anagrafiche","offline":"false","page":"1","parms":"ReportName=arrp_stp_info_dett_anagrafiche,dadata_info=Textbox_dadata_info,adata_info=Textbox_adata_info,dadata_reg=Textbox_dadata_reg,adata_reg=Textbox_adata_reg,essere=Checkbox_essere,TitEssere=Radio_TitEssere,dipendenza=Textbox_dipendenza,OrderBy=Variable_OrderBy,showParameterMask=False,tiporep=tiporep","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"25","servlet":"","target":"Iframe_elaborazione","type":"SPLinker","w":"259","x":"488","y":"255"},{"anchor":"top-left(%)-right(%)","auto_resize":"true","border":"","default_portlet":"","h":"40","hide":"false","layout_steps_values":"{}","name":"Iframe_elaborazione","page":"1","sequence":"26","type":"Iframe","w":"480","wireframe_props":"","x":"0","y":"360","zindex":"18"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"tiporep","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"27","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"120","wireframe_props":"name","x":"313","y":"332","zerofilling":"false","zindex":"19"}]%>
<%/*Description:Rapporti con Dettaglio Anagrafico*/%>
<%/*ParamsRequest:tiporep*/%>
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
window.pg_stp_info_dett_anagrafiche_Static=function(){
if(typeof Image_prn_Click !='undefined')this.Image_prn_Click=Image_prn_Click;
if(typeof this_Calculate !='undefined')this.this_Calculate=this_Calculate;
if(typeof Checkbox_scheda_onChange !='undefined')this.Checkbox_scheda_onChange=Checkbox_scheda_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('DATAREG,NUMPROG,IDBASE',this.Variable_OrderBy);
ZtVWeb.InitCtrl(false,this.Checkbox_essere);
ZtVWeb.InitCtrl(false,this.Checkbox_scheda);
ZtVWeb.InitCtrl('S',this.Radio_TitEssere);
ZtVWeb.InitCtrl('D',this.Radio_OrderBy);
this.LinkZoom_dipendenza.addObserverFixedVars();
this.getTitlePortlet().SetTitle('Rapporti con Dettaglio Anagrafico',true)
function Image_prn_Click(){
  if(this.Radio_OrderBy.Value()=='D'){
//     this.Variable_OrderBy.Value('DATAREG,NUMPROG,IDBASE,TIPOREC');
    this.Variable_OrderBy.Value('DATAREG,NUMPROG,IDBASE');
  }else{
    if(this.Radio_OrderBy.Value()=='N'){
//       this.Variable_OrderBy.Value('NUMPROG,DATAREG,IDBASE,TIPOREC');
      this.Variable_OrderBy.Value('NUMPROG,DATAREG,IDBASE');
    }else{
      this.Variable_OrderBy.Value('');
    }
  }
  this.Iframe_elaborazione.Show();
  this.SPLinker_arrp_stp_info_dett_anagrafiche.Link();
}
function this_Calculate(){
  this.Iframe_elaborazione.Hide();
}
function Checkbox_scheda_onChange(){
  if(this.Checkbox_scheda.Value()){
    this.Textbox_respons.Show();
  }else{
    this.Textbox_respons.Hide();
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
.pg_stp_info_dett_anagrafiche_container {
}
.pg_stp_info_dett_anagrafiche_title_container {
  margin: auto;
}
.pg_stp_info_dett_anagrafiche_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:600px;
  height:400px;
}
.pg_stp_info_dett_anagrafiche_portlet[Data-page="1"]{
  height:400px;
  width:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_informazione_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:96px;
  left:20.0%;
  right:261px;
  right:54.375%;
  width:auto;
  height:auto;
  min-height:100px;
  display:flex;
  flex-direction:column;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_informazione_ctrl {
  height:100px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_informazione_ctrl > .box_content {
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_informazione_ctrl {
  min-height:100px;
}
.pg_stp_info_dett_anagrafiche_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:327px;
  left:256px;
  left:53.333332%;
  right:194px;
  right:40.416668%;
  width:auto;
  height:30px;
}
.pg_stp_info_dett_anagrafiche_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_data_info_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:0px;
  left:96px;
  left:20.0%;
  right:261px;
  right:54.375%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_data_info_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_data_info_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dadata_info_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:32px;
  left:117px;
  left:24.375%;
  right:303px;
  right:63.125%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dadata_info_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dadata_info_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Calendario_dadata_info_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:32px;
  left:182px;
  left:37.916668%;
  right:278px;
  right:57.916668%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_adata_info_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:75px;
  left:117px;
  left:24.375%;
  right:303px;
  right:63.125%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_adata_info_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_adata_info_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Calendario_adata_info_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:75px;
  left:182px;
  left:37.916668%;
  right:278px;
  right:57.916668%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_reg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:260px;
  left:54.166668%;
  right:97px;
  right:20.208334%;
  width:auto;
  height:auto;
  min-height:100px;
  display:flex;
  flex-direction:column;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_reg_ctrl {
  height:100px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_reg_ctrl > .box_content {
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Box_data_reg_ctrl {
  min-height:100px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_data_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:0px;
  left:260px;
  left:54.166668%;
  right:97px;
  right:20.208334%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_data_reg_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_data_reg_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:32px;
  left:282px;
  left:58.75%;
  right:138px;
  right:28.75%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dadata_reg_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dadata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Calendario_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:32px;
  left:349px;
  left:72.708336%;
  right:111px;
  right:23.125%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:75px;
  left:282px;
  left:58.75%;
  right:138px;
  right:28.75%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_adata_reg_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_adata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Checkbox_essere_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:105px;
  left:96px;
  left:20.0%;
  right:206px;
  right:42.916668%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Calendario_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:75px;
  left:349px;
  left:72.708336%;
  right:111px;
  right:23.125%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Checkbox_scheda_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:105px;
  left:260px;
  left:54.166668%;
  right:90px;
  right:18.75%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stp_info_dett_anagrafiche_portlet > .Radio_TitEssere_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:131px;
  width:478px;
  height:50px;
  margin-left:-239px;
  left:50%;
  height:auto;
  min-height:50px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_ordinamento_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:186px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_ordinamento_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Label_ordinamento_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_info_dett_anagrafiche_portlet > .Radio_OrderBy_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:210px;
  width:230px;
  height:45px;
  margin-left:-105px;
  left:50%;
  height:auto;
  min-height:45px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dipendenza_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:269px;
  left:83px;
  left:17.291666%;
  right:322px;
  right:67.083336%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dipendenza_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_dipendenza_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .LinkZoom_dipendenza_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:269px;
  left:161px;
  left:33.541668%;
  right:299px;
  right:62.291668%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_desc_dipendenza_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:269px;
  left:184px;
  left:38.333332%;
  right:71px;
  right:14.791667%;
  width:auto;
  height:20px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_desc_dipendenza_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_desc_dipendenza_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_respons_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:305px;
  left:83px;
  left:17.291666%;
  right:71px;
  right:14.791667%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_respons_ctrl {
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_respons_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_info_dett_anagrafiche_portlet > .Image_prn_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:327px;
  left:206px;
  left:42.916668%;
  right:244px;
  right:50.833332%;
  width:auto;
  height:30px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Image_prn_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_stp_info_dett_anagrafiche_portlet > .Iframe_elaborazione_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:360px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:40px;
}
.pg_stp_info_dett_anagrafiche_portlet > .tiporep_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:480px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_stp_info_dett_anagrafiche_portlet > .tiporep_ctrl {
  display:none;
}
.pg_stp_info_dett_anagrafiche_portlet > .tiporep_ctrl > input{
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"Rapporti con Dettaglio Anagrafico\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"480\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"96\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"256\",\"y\":\"327\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"487\",\"y\":\"221\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Informazione\",\"w\":\"123\",\"x\":\"96\",\"y\":\"0\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_info\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"117\",\"y\":\"32\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_info\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"182\",\"y\":\"32\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_info\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"117\",\"y\":\"75\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_info\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"182\",\"y\":\"75\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"Box_data_reg\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"260\",\"y\":\"0\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_reg\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Registrazione\",\"w\":\"123\",\"x\":\"260\",\"y\":\"0\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"282\",\"y\":\"32\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"349\",\"y\":\"32\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"282\",\"y\":\"75\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Solo rapporti in essere\",\"layout_steps_values\":{},\"name\":\"Checkbox_essere\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"178\",\"x\":\"96\",\"y\":\"105\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"349\",\"y\":\"75\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Formato Scheda\",\"layout_steps_values\":{},\"name\":\"Checkbox_scheda\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"130\",\"x\":\"260\",\"y\":\"105\",\"zindex\":\"8\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"Radio_TitEssere\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"478\",\"x\":\"1\",\"y\":\"131\",\"zindex\":\"9\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_ordinamento\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stampa ordinata per\",\"w\":\"480\",\"x\":\"0\",\"y\":\"186\",\"zindex\":\"10\"},{\"anchor\":\"top-center\",\"h\":\"45\",\"layout_steps_values\":{},\"name\":\"Radio_OrderBy\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"230\",\"x\":\"135\",\"y\":\"210\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dipendenza\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"75\",\"x\":\"83\",\"y\":\"269\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_dipendenza\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"161\",\"y\":\"269\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_desc_dipendenza\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"225\",\"x\":\"184\",\"y\":\"269\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_respons\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"326\",\"x\":\"83\",\"y\":\"305\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Image_prn\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"206\",\"y\":\"327\",\"zindex\":\"6\"},{\"h\":\"20\",\"name\":\"SPLinker_arrp_stp_info_dett_anagrafiche\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"259\",\"x\":\"488\",\"y\":\"255\"},{\"anchor\":\"top-left(%)-right(%)\",\"h\":\"40\",\"layout_steps_values\":{},\"name\":\"Iframe_elaborazione\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"480\",\"x\":\"0\",\"y\":\"360\",\"zindex\":\"18\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tiporep\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"313\",\"y\":\"332\",\"zindex\":\"19\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stp_info_dett_anagrafiche","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stp_info_dett_anagrafiche_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_stp_info_dett_anagrafiche_portlet > .Checkbox_scheda_ctrl {
  display:none;
}
.pg_stp_info_dett_anagrafiche_portlet > .Textbox_respons_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stp_info_dett_anagrafiche','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Variable_OrderBy= "";
String Label_data_info= "Data Informazione";
java.sql.Date Textbox_dadata_info= JSPLib.NullDate();
if(request.getAttribute("pg_stp_info_dett_anagrafiche_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_stp_info_dett_anagrafiche_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
java.sql.Date Textbox_adata_info= JSPLib.NullDate();
String Label_data_reg= "Data Registrazione";
java.sql.Date Textbox_dadata_reg= JSPLib.NullDate();
java.sql.Date Textbox_adata_reg= JSPLib.NullDate();
boolean Checkbox_essere= false;
boolean Checkbox_scheda= false;
String Radio_TitEssere= "";
String Label_ordinamento= "Stampa ordinata per";
String Radio_OrderBy= "";
String Textbox_dipendenza= "";
if(request.getAttribute("pg_stp_info_dett_anagrafiche_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Textbox_desc_dipendenza= "";
String Textbox_respons= "";
String tiporep=JSPLib.translateXSS(sp.getParameter("tiporep",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stp_info_dett_anagrafiche_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stp_info_dett_anagrafiche_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stp_info_dett_anagrafiche_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stp_info_dett_anagrafiche','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Box_data_informazione' class='Box_data_informazione_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_informazione_td' class='box_content'></div>
</div>
<a id='<%=idPortlet%>_btnExit' class='image-default btnExit_ctrl'   target=''>&#xea01;</a>
<span id='<%=idPortlet%>_Label_data_info'  formid='<%=idPortlet%>' ps-name='Label_data_info'    class='label Label_data_info_ctrl'><div id='<%=idPortlet%>_Label_data_infotbl' style='width:100%;'><%=JSPLib.ToHTML("Data Informazione")%></div></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_info_wrp'><input id='<%=idPortlet%>_Textbox_dadata_info' name='Textbox_dadata_info' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_info' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_info>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_info' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_info.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_info_wrp'><input id='<%=idPortlet%>_Textbox_adata_info' name='Textbox_adata_info' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_info' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_info>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_info' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_info.PopupCalendar();' style='text-decoration:none;'></a>
 <div id='<%=idPortlet%>_Box_data_reg' class='Box_data_reg_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_reg_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label_data_reg'  formid='<%=idPortlet%>' ps-name='Label_data_reg'    class='label Label_data_reg_ctrl'><div id='<%=idPortlet%>_Label_data_regtbl' style='width:100%;'><%=JSPLib.ToHTML("Data Registrazione")%></div></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_reg_wrp'><input id='<%=idPortlet%>_Textbox_dadata_reg' name='Textbox_dadata_reg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_reg' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_reg>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_reg_wrp'><input id='<%=idPortlet%>_Textbox_adata_reg' name='Textbox_adata_reg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_reg' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_reg>A</label></span>
<div id='<%=idPortlet%>_Checkbox_essere_div' style=''><input id='<%=idPortlet%>_Checkbox_essere' name='Checkbox_essere' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Checkbox_essere' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Solo rapporti in essere")%></label></div>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <div id='<%=idPortlet%>_Checkbox_scheda_div' style=''><input id='<%=idPortlet%>_Checkbox_scheda' name='Checkbox_scheda' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Checkbox_scheda' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Formato Scheda")%></label></div>
<div id='<%=idPortlet%>_Radio_TitEssere' class='radio' style='z-index:1;'></div>
<span id='<%=idPortlet%>_Label_ordinamento'  formid='<%=idPortlet%>' ps-name='Label_ordinamento'    class='label Label_ordinamento_ctrl'><div id='<%=idPortlet%>_Label_ordinamentotbl' style='width:100%;'><%=JSPLib.ToHTML("Stampa ordinata per")%></div></span>
<div id='<%=idPortlet%>_Radio_OrderBy' class='radio' style='z-index:1;'></div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dipendenza_wrp'><input id='<%=idPortlet%>_Textbox_dipendenza' name='Textbox_dipendenza' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dipendenza' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dipendenza>Dipendenza</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_dipendenza'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_desc_dipendenza_wrp'><input id='<%=idPortlet%>_Textbox_desc_dipendenza' name='Textbox_desc_dipendenza' type='text' disabled maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_desc_dipendenza' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_respons_wrp'><input id='<%=idPortlet%>_Textbox_respons' name='Textbox_respons' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_respons' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_respons>Responsabile Antiriciclaggio</label></span>
<a id='<%=idPortlet%>_Image_prn' class='image-default Image_prn_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_Iframe_elaborazione_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_tiporep_wrp'><input id='<%=idPortlet%>_tiporep' name='tiporep' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='tiporep' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stp_info_dett_anagrafiche');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stp_info_dett_anagrafiche',["480"],["400"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"480","h":"400","title":"Rapporti con Dettaglio Anagrafico","layer":"false","npage":"1"}]);
this.Box_data_informazione=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_informazione","groupName":"","h":100,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_informazione","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":123,"x":96,"y":0,"zindex":"1"});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":256,"y":327,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Variable_OrderBy=new ZtVWeb._VC(this,'Variable_OrderBy',null,'character','<%=JSPLib.ToJSValue(Variable_OrderBy,false,true)%>',false,false);
this.Label_data_info=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_info","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_info","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label_data_info,false,true)%>","type":"Label","w":123,"x":96,"y":0,"zindex":"6"});
this.Textbox_dadata_info=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_info","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_info","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_info%>","w":60,"x":117,"y":32,"zerofilling":false,"zindex":"4","zoom":""});
this.Calendario_dadata_info=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_info','Calendario_dadata_info',182,32,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_info',{});
this.Textbox_adata_info=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_info","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_info","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_info%>","w":60,"x":117,"y":75,"zerofilling":false,"zindex":"4","zoom":""});
this.Calendario_adata_info=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_info','Calendario_adata_info',182,75,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_info',{});
this.Box_data_reg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_reg","groupName":"","h":100,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_reg","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":123,"x":260,"y":0,"zindex":"1"});
this.Label_data_reg=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_reg","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_reg","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label_data_reg,false,true)%>","type":"Label","w":123,"x":260,"y":0,"zindex":"6"});
this.Textbox_dadata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_reg%>","w":60,"x":282,"y":32,"zerofilling":false,"zindex":"4","zoom":""});
this.Calendario_dadata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_reg','Calendario_dadata_reg',349,32,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_reg',{});
this.Textbox_adata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_reg%>","w":60,"x":282,"y":75,"zerofilling":false,"zindex":"4","zoom":""});
this.Checkbox_essere=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Checkbox_essere","decrypt":false,"edit_undercond":"","encrypt":false,"h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Solo rapporti in essere","layer":false,"layout_steps_values":{},"name":"Checkbox_essere","page":1,"reactive":false,"server_side":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":178,"x":96,"y":105,"zindex":"7"});
this.Calendario_adata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_reg','Calendario_adata_reg',349,75,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_reg',{});
this.Checkbox_scheda=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Checkbox_scheda","decrypt":false,"edit_undercond":"","encrypt":false,"h":20,"hide":"true","hide_undercond":"","init":"true","init_par":"","label_text":"Formato Scheda","layer":false,"layout_steps_values":{},"name":"Checkbox_scheda","page":1,"reactive":false,"server_side":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":130,"x":260,"y":105,"zindex":"8"});
this.Radio_TitEssere=new ZtVWeb.RadioCtrl(this,{"anchor":"top-center","calculate":"'S'","captionsList":"Estrazione solo dei Titolari Effettivi in essere nel periodo di date scelto,Estrazione dei Titolari Effettivi SENZA filtro per periodo di date scelto","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_TitEssere","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":50,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_TitEssere","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"S,N","visible":true,"w":478,"x":1,"y":131,"zindex":"9"});
this.Label_ordinamento=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_ordinamento","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_ordinamento","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label_ordinamento,false,true)%>","type":"Label","w":480,"x":0,"y":186,"zindex":"10"});
this.Radio_OrderBy=new ZtVWeb.RadioCtrl(this,{"anchor":"top-center","calculate":"'D'","captionsList":"Data Registraz. N. Progressivo,N. Progressivo Data Registraz.","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_OrderBy","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":45,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_OrderBy","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,N","visible":true,"w":230,"x":135,"y":210,"zindex":"11"});
this.Textbox_dipendenza=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dipendenza","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"Textbox_dipendenza","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_dipendenza,false,true)%>","w":75,"x":83,"y":269,"zerofilling":false,"zindex":"12","zoom":""});
this.LinkZoom_dipendenza=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_dipendenza","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_info_dett_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"Textbox_dipendenza,Textbox_desc_dipendenza","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_info_dett_anagrafiche_portlet.jspLinkZoom_dipendenza",request.getSession())%>","linkedField":"Textbox_dipendenza","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_dipendenza","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":161,"y":269,"zindex":"13","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_desc_dipendenza=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_desc_dipendenza","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"30","name":"Textbox_desc_dipendenza","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_desc_dipendenza,false,true)%>","w":225,"x":184,"y":269,"zerofilling":false,"zindex":"14","zoom":""});
this.Textbox_respons=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_respons","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"Responsabile Antiriciclaggio","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_respons","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_respons,false,true)%>","w":326,"x":83,"y":305,"zerofilling":false,"zindex":"16","zoom":""});
this.Image_prn=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default Image_prn_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_prn","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"Image_prn","page":1,"path_type":"","server_side":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":206,"y":327,"zindex":"6"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.SPLinker_arrp_stp_info_dett_anagrafiche=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_arrp_stp_info_dett_anagrafiche","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_arrp_stp_info_dett_anagrafiche","offline":false,"page":1,"parms":"ReportName=arrp_stp_info_dett_anagrafiche,dadata_info=Textbox_dadata_info,adata_info=Textbox_adata_info,dadata_reg=Textbox_dadata_reg,adata_reg=Textbox_adata_reg,essere=Checkbox_essere,TitEssere=Radio_TitEssere,dipendenza=Textbox_dipendenza,OrderBy=Variable_OrderBy,showParameterMask=False,tiporep=tiporep","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"Iframe_elaborazione","type":"SPLinker","w":259,"x":488,"y":255});
this.SPLinker_arrp_stp_info_dett_anagrafiche.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Iframe_elaborazione=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"true","border":"","ctrlid":"<%=idPortlet%>_Iframe_elaborazione","default_portlet":"","h":40,"hide":"false","layer":false,"layout_steps_values":{},"name":"Iframe_elaborazione","name_iframe":"Iframe_elaborazione","page":1,"type":"Iframe","w":480,"x":0,"y":360,"zindex":"18"});
this.tiporep=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tiporep","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"tiporep","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tiporep,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"19","zoom":""});
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
<%if(request.getAttribute("pg_stp_info_dett_anagrafiche_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stp_info_dett_anagrafiche_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stp_info_dett_anagrafiche_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Image_prn.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stp_info_dett_anagrafiche',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stp_info_dett_anagrafiche');
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
sp.endPage("pg_stp_info_dett_anagrafiche");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_dipendenza")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "233851259"; } %>