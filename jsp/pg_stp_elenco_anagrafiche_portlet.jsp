<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Elenco Anagrafiche',true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa le anagrafiche dei soggetti'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.Image_prn_Click()'\n  },1); \n\nfunction Image_prn_Click(){\n  this.Iframe_elaborazione.Show();\n  this.SPLinker_arrp_elenco_anagrafiche.Link();\n}\n\nfunction this_Calculate(){\n  this.Iframe_elaborazione.Hide();\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Elenco Anagrafiche","fixed_top":"false","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Textbox_daCodCli }}{{ @LinkZoom_daCodCli }}{{ @Textbox_daragsoc }}{{ @Textbox_aCodCli }}{{ @LinkZoom_aCodCli }}{{ @Textbox_aragsoc }}{{ @Box_rischi }}{{ @Label_valutazione_rischio }}{{ @Textbox_comport }}{{ @LinkZoom_comport }}{{ @Textbox_comport_desc }}{{ @Textbox_prevalente }}{{ @LinkZoom_prevalente }}{{ @Textbox_prevalente_desc }}{{ @Textbox_natura }}{{ @LinkZoom_natura }}{{ @Textbox_natura_desc }}{{ @Textbox_areageo }}{{ @LinkZoom_areageo }}{{ @Textbox_areageo_desc }}{{ @Checkbox_nodoc }}{{ @Box_titolo_rischio }}{{ @Iframe_elaborazione }}\u003c\u002fbody\u003e","grapesCss":"","h":"400","hsl":"","htmlcode":"{{ @Textbox_daCodCli }} \n{{ @LinkZoom_daCodCli }} \n{{ @Textbox_daragsoc }} \n{{ @Textbox_aCodCli }} \n{{ @LinkZoom_aCodCli }} \n{{ @Textbox_aragsoc }} \n{{ @Box_rischi }} \n{{ @Label_valutazione_rischio }} \n{{ @Textbox_comport }} \n{{ @LinkZoom_comport }} \n{{ @Textbox_comport_desc }} \n{{ @Textbox_prevalente }} \n{{ @LinkZoom_prevalente }} \n{{ @Textbox_prevalente_desc }} \n{{ @Textbox_natura }} \n{{ @LinkZoom_natura }} \n{{ @Textbox_natura_desc }} \n{{ @Textbox_areageo }} \n{{ @LinkZoom_areageo }} \n{{ @Textbox_areageo_desc }} \n{{ @Checkbox_nodoc }} \n \n \n{{ @Box_titolo_rischio }} \n{{ @Iframe_elaborazione }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"500","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\" Elenco Anagrafiche\",\"layer\":\"\",\"h\":\"400\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":" Elenco Anagrafiche","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_daCodCli","page":"1","password":"","picker":"","picture":"","placeholder":"Da Soggetto","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"4","y":"19","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_daCodCli,Textbox_daragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_daCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"2","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"30","wireframe_props":"","x":"127","y":"16","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_daragsoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"162","y":"18","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_aCodCli","page":"1","password":"","picker":"","picture":"","placeholder":"A Soggetto","rapp":"","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"4","y":"60","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_aCodCli,Textbox_aragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom_aCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"5","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"30","wireframe_props":"","x":"127","y":"57","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_aragsoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"162","y":"59","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"170","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_rischi","page":"1","rapp":"","sequence":"7","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"398","wireframe_props":"","x":"1","y":"90","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label TitleLabel","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_valutazione_rischio","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Valutazione Rischio per aspetti connessi al Soggetto","w":"398","wireframe_props":"align,value,n_col","x":"1","y":"90","zindex":"4","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"5","name":"Textbox_comport","page":"1","password":"","picker":"","picture":"","placeholder":"Comportamento Tenuto","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"85","wireframe_props":"name","x":"4","y":"127","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_comport,Textbox_comport_desc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_comport","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"LinkZoom_comport","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"10","servlet":"","spuid":"","suggest":"true","table":"tbcondotta","type":"LinkZoom","w":"30","wireframe_props":"","x":"94","y":"124","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"200","name":"Textbox_comport_desc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"231","wireframe_props":"name","x":"127","y":"127","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"5","name":"Textbox_prevalente","page":"1","password":"","picker":"","picture":"","placeholder":"Prevalente Attività","rapp":"","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"85","wireframe_props":"name","x":"4","y":"162","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_prevalente,Textbox_prevalente_desc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_prevalente","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"LinkZoom_prevalente","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"13","servlet":"","spuid":"","suggest":"true","table":"tbtipatt","type":"LinkZoom","w":"30","wireframe_props":"","x":"94","y":"159","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"200","name":"Textbox_prevalente_desc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"231","wireframe_props":"name","x":"127","y":"162","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"5","name":"Textbox_natura","page":"1","password":"","picker":"","picture":"","placeholder":"Natura Giuridica","rapp":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"85","wireframe_props":"name","x":"4","y":"198","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_natura,Textbox_natura_desc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_natura","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"LinkZoom_natura","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODSPE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"16","servlet":"","spuid":"","suggest":"true","table":"tbspecie","type":"LinkZoom","w":"30","wireframe_props":"","x":"94","y":"195","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"200","name":"Textbox_natura_desc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"231","wireframe_props":"name","x":"127","y":"198","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"5","name":"Textbox_areageo","page":"1","password":"","picker":"","picture":"","placeholder":"Area geografica","rapp":"","readonly":"false","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"85","wireframe_props":"name","x":"4","y":"233","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","hide":"false","image":"","img_type":"default","intovars":"Textbox_areageo,Textbox_areageo_desc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_areageo","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"LinkZoom_areageo","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"19","servlet":"","spuid":"","suggest":"true","table":"tbareegeog","type":"LinkZoom","w":"30","wireframe_props":"","x":"94","y":"231","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"200","name":"Textbox_areageo_desc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"231","wireframe_props":"name","x":"127","y":"233","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"top-center","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Solo persone senza documento","layer":"false","layout_steps_values":"{}","name":"Checkbox_nodoc","page":"1","rapp":"","sequence":"21","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"249","wireframe_props":"label_text","x":"85","y":"260","zindex":"5","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"SPLinker_arrp_elenco_anagrafiche","offline":"false","page":"1","parms":"ReportName=arrp_elenco_anagrafiche,daCodCli=Textbox_daCodCli,aCodCli=Textbox_aCodCli,comport=Textbox_comport,prevalente=Textbox_prevalente,natura=Textbox_natura,areageo=Textbox_areageo,nodoc=Checkbox_nodoc,showParameterMask=False","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"false","refresh":"","sequence":"24","servlet":"","target":"Iframe_elaborazione","type":"SPLinker","w":"218","x":"421","y":"29"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"22","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_titolo_rischio","page":"1","rapp":"","sequence":"25","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"398","wireframe_props":"","x":"1","y":"90","zindex":"1","zone":""},{"anchor":"top-left(%)-right(%)","auto_resize":"true","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"111","hide":"false","layer":"false","layout_steps_values":"{}","name":"Iframe_elaborazione","page":"1","rapp":"","sequence":"26","spuid":"","type":"Iframe","w":"400","wireframe_props":"","x":"0","y":"289","zindex":"9","zone":""}]%>
<%/*Description:Elenco Anagrafiche*/%>
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
window.pg_stp_elenco_anagrafiche_Static=function(){
if(typeof Image_prn_Click !='undefined')this.Image_prn_Click=Image_prn_Click;
if(typeof this_Calculate !='undefined')this.this_Calculate=this_Calculate;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(false,this.Checkbox_nodoc);
this.LinkZoom_daCodCli.addObserverFixedVars();
this.LinkZoom_aCodCli.addObserverFixedVars();
this.LinkZoom_comport.addObserverFixedVars();
this.LinkZoom_prevalente.addObserverFixedVars();
this.LinkZoom_natura.addObserverFixedVars();
this.LinkZoom_areageo.addObserverFixedVars();
this.getTitlePortlet().SetTitle('Elenco Anagrafiche',true)
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa le anagrafiche dei soggetti'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.Image_prn_Click()'
  },1); 
function Image_prn_Click(){
  this.Iframe_elaborazione.Show();
  this.SPLinker_arrp_elenco_anagrafiche.Link();
}
function this_Calculate(){
  this.Iframe_elaborazione.Hide();
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
.pg_stp_elenco_anagrafiche_container {
  height:100%;
  overflow:auto;
}
.pg_stp_elenco_anagrafiche_title_container {
  margin: auto;
}
.pg_stp_elenco_anagrafiche_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:500px;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:19px;
  left:4px;
  left:1.0%;
  right:276px;
  right:69.0%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_daCodCli_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_daCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .LinkZoom_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:16px;
  left:127px;
  left:31.75%;
  right:243px;
  right:60.75%;
  width:auto;
  height:30px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_daragsoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  left:162px;
  left:40.5%;
  right:88px;
  right:22.0%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_daragsoc_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_daragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:4px;
  left:1.0%;
  right:276px;
  right:69.0%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_aCodCli_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_aCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .LinkZoom_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:57px;
  left:127px;
  left:31.75%;
  right:243px;
  right:60.75%;
  width:auto;
  height:30px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_aragsoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:59px;
  left:162px;
  left:40.5%;
  right:88px;
  right:22.0%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_aragsoc_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_aragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_rischi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:90px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:170px;
  display:flex;
  flex-direction:column;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_rischi_ctrl {
  height:170px;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_rischi_ctrl > .box_content {
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_rischi_ctrl {
  min-height:170px;
}
.pg_stp_elenco_anagrafiche_portlet > .Label_valutazione_rischio_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:90px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Label_valutazione_rischio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Label_valutazione_rischio_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_comport_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:127px;
  left:4px;
  left:1.0%;
  right:311px;
  right:77.75%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_comport_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_comport_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .LinkZoom_comport_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:124px;
  left:94px;
  left:23.5%;
  right:276px;
  right:69.0%;
  width:auto;
  height:30px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_comport_desc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:127px;
  left:127px;
  left:31.75%;
  right:42px;
  right:10.5%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_comport_desc_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_comport_desc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_prevalente_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:162px;
  left:4px;
  left:1.0%;
  right:311px;
  right:77.75%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_prevalente_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_prevalente_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .LinkZoom_prevalente_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:159px;
  left:94px;
  left:23.5%;
  right:276px;
  right:69.0%;
  width:auto;
  height:30px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_prevalente_desc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:162px;
  left:127px;
  left:31.75%;
  right:42px;
  right:10.5%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_prevalente_desc_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_prevalente_desc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_natura_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:198px;
  left:4px;
  left:1.0%;
  right:311px;
  right:77.75%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_natura_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_natura_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .LinkZoom_natura_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:195px;
  left:94px;
  left:23.5%;
  right:276px;
  right:69.0%;
  width:auto;
  height:30px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_natura_desc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:198px;
  left:127px;
  left:31.75%;
  right:42px;
  right:10.5%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_natura_desc_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_natura_desc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_areageo_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:233px;
  left:4px;
  left:1.0%;
  right:311px;
  right:77.75%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_areageo_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_areageo_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .LinkZoom_areageo_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:231px;
  left:94px;
  left:23.5%;
  right:276px;
  right:69.0%;
  width:auto;
  height:30px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_areageo_desc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:233px;
  left:127px;
  left:31.75%;
  right:42px;
  right:10.5%;
  width:auto;
  height:20px;
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_areageo_desc_ctrl {
}
.pg_stp_elenco_anagrafiche_portlet > .Textbox_areageo_desc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Checkbox_nodoc_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:260px;
  width:249px;
  height:20px;
  margin-left:-115px;
  left:50%;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_titolo_rischio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:90px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:22px;
  display:flex;
  flex-direction:column;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_titolo_rischio_ctrl {
  height:22px;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_titolo_rischio_ctrl > .box_content {
  height:100%;
}
.pg_stp_elenco_anagrafiche_portlet > .Box_titolo_rischio_ctrl {
  min-height:22px;
}
.pg_stp_elenco_anagrafiche_portlet > .Iframe_elaborazione_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:289px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:111px;
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"Elenco Anagrafiche\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"4\",\"y\":\"19\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"127\",\"y\":\"16\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"162\",\"y\":\"18\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"4\",\"y\":\"60\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"127\",\"y\":\"57\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"162\",\"y\":\"59\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"170\",\"layout_steps_values\":{},\"name\":\"Box_rischi\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"398\",\"x\":\"1\",\"y\":\"90\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_valutazione_rischio\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Valutazione Rischio per aspetti connessi al Soggetto\",\"w\":\"398\",\"x\":\"1\",\"y\":\"90\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_comport\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"4\",\"y\":\"127\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_comport\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"94\",\"y\":\"124\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_comport_desc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"231\",\"x\":\"127\",\"y\":\"127\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_prevalente\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"4\",\"y\":\"162\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_prevalente\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"94\",\"y\":\"159\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_prevalente_desc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"231\",\"x\":\"127\",\"y\":\"162\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_natura\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"4\",\"y\":\"198\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_natura\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"94\",\"y\":\"195\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_natura_desc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"231\",\"x\":\"127\",\"y\":\"198\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_areageo\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"4\",\"y\":\"233\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"LinkZoom_areageo\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"30\",\"x\":\"94\",\"y\":\"231\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_areageo_desc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"231\",\"x\":\"127\",\"y\":\"233\",\"zindex\":\"3\"},{\"anchor\":\"top-center\",\"h\":\"20\",\"label_text\":\"Solo persone senza documento\",\"layout_steps_values\":{},\"name\":\"Checkbox_nodoc\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"249\",\"x\":\"85\",\"y\":\"260\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"SPLinker_arrp_elenco_anagrafiche\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"218\",\"x\":\"421\",\"y\":\"29\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"Box_titolo_rischio\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"398\",\"x\":\"1\",\"y\":\"90\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Iframe_elaborazione\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"400\",\"x\":\"0\",\"y\":\"289\",\"zindex\":\"9\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stp_elenco_anagrafiche","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stp_elenco_anagrafiche_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stp_elenco_anagrafiche','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Textbox_daCodCli= "";
if(request.getAttribute("pg_stp_elenco_anagrafiche_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_stp_elenco_anagrafiche_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Textbox_daragsoc= "";
String Textbox_aCodCli= "";
String Textbox_aragsoc= "";
String Label_valutazione_rischio= "Valutazione Rischio per aspetti connessi al Soggetto";
String Textbox_comport= "";
String Textbox_comport_desc= "";
String Textbox_prevalente= "";
String Textbox_prevalente_desc= "";
String Textbox_natura= "";
String Textbox_natura_desc= "";
String Textbox_areageo= "";
String Textbox_areageo_desc= "";
boolean Checkbox_nodoc= false;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stp_elenco_anagrafiche_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stp_elenco_anagrafiche_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stp_elenco_anagrafiche_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stp_elenco_anagrafiche','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_daCodCli_wrp'><input id='<%=idPortlet%>_Textbox_daCodCli' name='Textbox_daCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_daCodCli>Da Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_daragsoc_wrp'><input id='<%=idPortlet%>_Textbox_daragsoc' name='Textbox_daragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daragsoc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_aCodCli_wrp'><input id='<%=idPortlet%>_Textbox_aCodCli' name='Textbox_aCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_aCodCli>A Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_aragsoc_wrp'><input id='<%=idPortlet%>_Textbox_aragsoc' name='Textbox_aragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aragsoc' /></span>
<div id='<%=idPortlet%>_Box_rischi' class='Box_rischi_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_rischi_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label_valutazione_rischio'  formid='<%=idPortlet%>' ps-name='Label_valutazione_rischio'    class='label TitleLabel Label_valutazione_rischio_ctrl'><div id='<%=idPortlet%>_Label_valutazione_rischiotbl' style='width:100%;'><%=JSPLib.ToHTML("Valutazione Rischio per aspetti connessi al Soggetto")%></div></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_comport_wrp'><input id='<%=idPortlet%>_Textbox_comport' name='Textbox_comport' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_comport' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_comport>Comportamento Tenuto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_comport'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_comport_desc_wrp'><input id='<%=idPortlet%>_Textbox_comport_desc' name='Textbox_comport_desc' type='text' disabled maxlength='200' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_comport_desc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_prevalente_wrp'><input id='<%=idPortlet%>_Textbox_prevalente' name='Textbox_prevalente' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_prevalente' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_prevalente>Prevalente Attività</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_prevalente'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_prevalente_desc_wrp'><input id='<%=idPortlet%>_Textbox_prevalente_desc' name='Textbox_prevalente_desc' type='text' disabled maxlength='200' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_prevalente_desc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_natura_wrp'><input id='<%=idPortlet%>_Textbox_natura' name='Textbox_natura' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_natura' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_natura>Natura Giuridica</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_natura'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_natura_desc_wrp'><input id='<%=idPortlet%>_Textbox_natura_desc' name='Textbox_natura_desc' type='text' disabled maxlength='200' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_natura_desc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_areageo_wrp'><input id='<%=idPortlet%>_Textbox_areageo' name='Textbox_areageo' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_areageo' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_areageo>Area geografica</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_areageo'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_areageo_desc_wrp'><input id='<%=idPortlet%>_Textbox_areageo_desc' name='Textbox_areageo_desc' type='text' disabled maxlength='200' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_areageo_desc' /></span>
<div id='<%=idPortlet%>_Checkbox_nodoc_div' style=''><input id='<%=idPortlet%>_Checkbox_nodoc' name='Checkbox_nodoc' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Checkbox_nodoc' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Solo persone senza documento")%></label></div>
<div id='<%=idPortlet%>_Box_titolo_rischio' class='Box_titolo_rischio_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_titolo_rischio_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_Iframe_elaborazione_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stp_elenco_anagrafiche');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa le anagrafiche dei soggetti",true)+","+JSPLib.ToJSValue(sp.translate("Stampa le anagrafiche dei soggetti"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stp_elenco_anagrafiche',["400"],["400"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','false',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"400","title":" Elenco Anagrafiche","layer":""}]);
this.Textbox_daCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_daCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daCodCli,false,true)%>","w":120,"x":4,"y":19,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_elenco_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_daCodCli,Textbox_daragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_elenco_anagrafiche_portlet.jspLinkZoom_daCodCli",request.getSession())%>","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_daCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":30,"x":127,"y":16,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_daragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_daragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daragsoc,false,true)%>","w":150,"x":162,"y":18,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_aCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_aCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aCodCli,false,true)%>","w":120,"x":4,"y":60,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_aCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_elenco_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_aCodCli,Textbox_aragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_elenco_anagrafiche_portlet.jspLinkZoom_aCodCli",request.getSession())%>","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_aCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":30,"x":127,"y":57,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_aragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_aragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aragsoc,false,true)%>","w":150,"x":162,"y":59,"zerofilling":false,"zindex":"3","zoom":""});
this.Box_rischi=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_rischi","groupName":"","h":170,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_rischi","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":398,"x":1,"y":90,"zindex":"1"});
this.Label_valutazione_rischio=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_valutazione_rischio","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_valutazione_rischio","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_valutazione_rischio,false,true)%>","type":"Label","w":398,"x":1,"y":90,"zindex":"4"});
this.Textbox_comport=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_comport","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"Textbox_comport","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_comport,false,true)%>","w":85,"x":4,"y":127,"zerofilling":false,"zindex":"2","zoom":""});
this.LinkZoom_comport=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_comport","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_elenco_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_comport,Textbox_comport_desc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_elenco_anagrafiche_portlet.jspLinkZoom_comport",request.getSession())%>","linkedField":"Textbox_comport","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_comport","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbcondotta,default",request.getSession())%>","suggest":true,"table":"tbcondotta","type":"LinkZoom","w":30,"x":94,"y":124,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_comport_desc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_comport_desc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"200","name":"Textbox_comport_desc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_comport_desc,false,true)%>","w":231,"x":127,"y":127,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_prevalente=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_prevalente","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"Textbox_prevalente","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_prevalente,false,true)%>","w":85,"x":4,"y":162,"zerofilling":false,"zindex":"2","zoom":""});
this.LinkZoom_prevalente=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_prevalente","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_elenco_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_prevalente,Textbox_prevalente_desc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_elenco_anagrafiche_portlet.jspLinkZoom_prevalente",request.getSession())%>","linkedField":"Textbox_prevalente","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_prevalente","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbtipatt,default",request.getSession())%>","suggest":true,"table":"tbtipatt","type":"LinkZoom","w":30,"x":94,"y":159,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_prevalente_desc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_prevalente_desc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"200","name":"Textbox_prevalente_desc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_prevalente_desc,false,true)%>","w":231,"x":127,"y":162,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_natura=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_natura","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"Textbox_natura","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_natura,false,true)%>","w":85,"x":4,"y":198,"zerofilling":false,"zindex":"2","zoom":""});
this.LinkZoom_natura=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_natura","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_elenco_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_natura,Textbox_natura_desc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_elenco_anagrafiche_portlet.jspLinkZoom_natura",request.getSession())%>","linkedField":"Textbox_natura","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_natura","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODSPE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbspecie,default",request.getSession())%>","suggest":true,"table":"tbspecie","type":"LinkZoom","w":30,"x":94,"y":195,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_natura_desc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_natura_desc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"200","name":"Textbox_natura_desc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_natura_desc,false,true)%>","w":231,"x":127,"y":198,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_areageo=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_areageo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"Textbox_areageo","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_areageo,false,true)%>","w":85,"x":4,"y":233,"zerofilling":false,"zindex":"2","zoom":""});
this.LinkZoom_areageo=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_areageo","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_elenco_anagrafiche_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":30,"hide":"false","image":"","intovars":"Textbox_areageo,Textbox_areageo_desc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_elenco_anagrafiche_portlet.jspLinkZoom_areageo",request.getSession())%>","linkedField":"Textbox_areageo","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_areageo","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbareegeog,default",request.getSession())%>","suggest":true,"table":"tbareegeog","type":"LinkZoom","w":30,"x":94,"y":231,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_areageo_desc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_areageo_desc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"200","name":"Textbox_areageo_desc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_areageo_desc,false,true)%>","w":231,"x":127,"y":233,"zerofilling":false,"zindex":"3","zoom":""});
this.Checkbox_nodoc=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-center","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Checkbox_nodoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Solo persone senza documento","layer":false,"layout_steps_values":{},"name":"Checkbox_nodoc","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":249,"x":85,"y":260,"zindex":"5"});
this.SPLinker_arrp_elenco_anagrafiche=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_arrp_elenco_anagrafiche","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_arrp_elenco_anagrafiche","offline":false,"page":1,"parms":"ReportName=arrp_elenco_anagrafiche,daCodCli=Textbox_daCodCli,aCodCli=Textbox_aCodCli,comport=Textbox_comport,prevalente=Textbox_prevalente,natura=Textbox_natura,areageo=Textbox_areageo,nodoc=Checkbox_nodoc,showParameterMask=False","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"Iframe_elaborazione","type":"SPLinker","w":218,"x":421,"y":29});
this.SPLinker_arrp_elenco_anagrafiche.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Box_titolo_rischio=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_titolo_rischio","groupName":"","h":22,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_titolo_rischio","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":398,"x":1,"y":90,"zindex":"1"});
this.Iframe_elaborazione=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"true","border":"","ctrlid":"<%=idPortlet%>_Iframe_elaborazione","default_portlet":"","h":111,"hide":"false","layer":false,"layout_steps_values":{},"name":"Iframe_elaborazione","name_iframe":"Iframe_elaborazione","page":1,"spuid":"","type":"Iframe","w":400,"x":0,"y":289,"zindex":"9"});
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
<%if(request.getAttribute("pg_stp_elenco_anagrafiche_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stp_elenco_anagrafiche_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stp_elenco_anagrafiche_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stp_elenco_anagrafiche',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stp_elenco_anagrafiche');
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
sp.endPage("pg_stp_elenco_anagrafiche");
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
if (Library.eq(p_cControlName,"LinkZoom_comport")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbcondotta";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CODICE", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_prevalente")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbtipatt";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CODICE", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_natura")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbspecie";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CODSPE", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_areageo")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbareegeog";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CODICE", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3185958893"; } %>