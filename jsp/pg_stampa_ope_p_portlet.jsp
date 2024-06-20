<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Operazioni Provvisorie');\n}\n\nfunction prnAnalitica_Click(){\n  this.ShowLog.Timer0.Start()\n  this.ShowMsg.Timer0.Start()\n  this.SPAnalitica.Link()\n}\n\nfunction prnSintetica_Click(){\n  this.ShowLog.Timer0.Start()\n  this.ShowMsg.Timer0.Start()\n  this.SPSintetica.Link()\n}\n\n\t\t\n\t\t\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Stampa con Dettaglio Anagrafico","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"620","hsl":"","htmlcode":"{{ @Label14_Copy_Copy_Copy }}\n{{ @a_ragdest }}\n{{ @LinkZoom12_Copy }}\n{{ @daragdest }}\n{{ @LinkZoom10_Copy }}\n{{ @a_coddest }}\n{{ @Label14_Copy_Copy }}\n{{ @dacoddest }}\n{{ @a_ragsoc }}\n{{ @LinkZoom12 }}\n{{ @daragsoc }}\n{{ @LinkZoom10 }}\n{{ @a_codcli }}\n{{ @Label14 }}\n{{ @dacodcli }}\n{{ @Label14_Copy }}\n{{ @prnSintetica }}\n{{ @ShowLog }}\n{{ @ShowMsg }}\n{{ @flgtit }}\n\n\n{{ @Ope_Print }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @btnExit }}\n\n\n\n\n\n{{ @Calendario_dadata_reg }}\n{{ @Calendario_adata_reg }}\n{{ @Textbox_adata_reg }}\n{{ @Textbox_dadata_reg }}\n{{ @Box_data_reg }}\n{{ @Label_data_reg }}\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @prnAnalitica }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"600","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa con Dettaglio","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"900","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_reg","page":"1","password":"","picture":"","placeholder":"Da","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"37","y":"42","zerofilling":"false","zindex":"5"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_reg","page":"1","password":"","picture":"","placeholder":"A","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"37","y":"84","zerofilling":"false","zindex":"5"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_reg","page":"1","popup":"true","return_input":"Textbox_dadata_reg","sequence":"3","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"104","y":"42","zindex":"6"},{"anchor":"","css_class":"","ctrlOfVariant":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_reg","page":"1","popup":"true","return_input":"Textbox_adata_reg","sequence":"4","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"104","y":"85","zindex":"6"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"dacodcli","page":"1","password":"","picture":"DD-MM-YYYY","placeholder":"","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"71","wireframe_props":"name","x":"267","y":"19","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"dacodcli,daragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"dacodcli","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom10","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"6","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"339","y":"20","zindex":"6","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"daragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"527","wireframe_props":"name","x":"366","y":"19","zerofilling":"false","zindex":"7"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"a_codcli","page":"1","password":"","picture":"DD-MM-YYYY","placeholder":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"71","wireframe_props":"name","x":"267","y":"46","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"a_codcli,a_ragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"a_codcli","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom12","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"9","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"339","y":"46","zindex":"8","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"a_ragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"527","wireframe_props":"name","x":"366","y":"46","zerofilling":"false","zindex":"9"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"dacoddest","page":"1","password":"","picture":"DD-MM-YYYY","placeholder":"","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"71","wireframe_props":"name","x":"267","y":"74","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"dacoddest,daragdest","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"dacoddest","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom10_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"12","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"339","y":"75","zindex":"6","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"daragdest","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"527","wireframe_props":"name","x":"366","y":"74","zerofilling":"false","zindex":"7"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"a_coddest","page":"1","password":"","picture":"DD-MM-YYYY","placeholder":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"71","wireframe_props":"name","x":"267","y":"101","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"a_coddest,a_ragdest","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"a_coddest","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom12_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"15","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"339","y":"101","zindex":"8","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"a_ragdest","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"527","wireframe_props":"name","x":"366","y":"101","zerofilling":"false","zindex":"9"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#0930F9","font_color_hover":"#000000","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Analitica","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"prnAnalitica","page":"1","path_type":"","sequence":"17","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"390","y":"130","zindex":"6"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Destinatario:","w":"127","wireframe_props":"align,value,n_col","x":"134","y":"72","zindex":"5"},{"allowedentities":"opert_stampa_ope","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPAnalitica","offline":"false","page":"1","parms":"w_DaDatReg=Textbox_dadata_reg,w_ADatReg=Textbox_adata_reg,w_daSog=dacodcli,w_aSog=a_codcli,w_flgtit=flgtit,pType=P,w_dadest=dacoddest,w_a_dest=a_coddest","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"19","servlet":"opert_stampa_ope","target":"Ope_Print","type":"SPLinker","w":"197","x":"769","y":"-90"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Soggetto:","w":"127","wireframe_props":"align,value,n_col","x":"134","y":"17","zindex":"5"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_reg","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Registrazione","w":"123","wireframe_props":"align,value,n_col","x":"15","y":"13","zindex":"23"},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_reg","page":"1","sequence":"22","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"123","wireframe_props":"","x":"15","y":"12","zindex":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Destinatario:","w":"127","wireframe_props":"align,value,n_col","x":"134","y":"101","zindex":"5"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"24","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"492","y":"130","zindex":"1"},{"anchor":"","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","h":"199","hide":"false","layer":"false","layout_steps_values":"{}","name":"Ope_Print","page":"1","sequence":"25","spuid":"","type":"Iframe","w":"900","wireframe_props":"","x":"0","y":"400","zindex":"26"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Stampa dei titolari effettivi","layer":"false","layout_steps_values":"{}","name":"flgtit","page":"1","sequence":"26","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"208","wireframe_props":"label_text","x":"17","y":"133","zindex":"27"},{"anchor":"","ctrlOfVariant":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"ShowMsg","page":"1","sequence":"27","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"900","wireframe_props":"","x":"0","y":"168","zindex":"28"},{"anchor":"","ctrlOfVariant":"","h":"141","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"ShowLog","page":"1","sequence":"28","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"900","wireframe_props":"","x":"0","y":"259","zindex":"28"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#06670B","font_color_hover":"#000000","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Sintetica","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"prnSintetica","page":"1","path_type":"","sequence":"29","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"441","y":"130","zindex":"6"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Soggetto:","w":"127","wireframe_props":"align,value,n_col","x":"134","y":"46","zindex":"5"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"SPSintetica","offline":"false","page":"1","parms":"ReportName=operp_stampa_ope_s_4.vrp,w_dadatreg=Textbox_dadata_reg,w_a_datreg=Textbox_adata_reg,w_daSog=dacodcli,w_aSog=a_codcli,rotation=LANDSCAPE,hideParameterMask=true,w_dadest=dacoddest,w_a_dest=a_coddest","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"31","servlet":"","target":"Ope_Print","type":"SPLinker","w":"194","x":"770","y":"-66"}]%>
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
window.pg_stampa_ope_p_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof prnAnalitica_Click !='undefined')this.prnAnalitica_Click=prnAnalitica_Click;
if(typeof prnSintetica_Click !='undefined')this.prnSintetica_Click=prnSintetica_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom10.addObserverFixedVars();
this.LinkZoom12.addObserverFixedVars();
this.LinkZoom10_Copy.addObserverFixedVars();
this.LinkZoom12_Copy.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Stampa Operazioni Provvisorie');
}
function prnAnalitica_Click(){
  this.ShowLog.Timer0.Start()
  this.ShowMsg.Timer0.Start()
  this.SPAnalitica.Link()
}
function prnSintetica_Click(){
  this.ShowLog.Timer0.Start()
  this.ShowMsg.Timer0.Start()
  this.SPSintetica.Link()
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
.pg_stampa_ope_p_container {
}
.pg_stampa_ope_p_title_container {
  margin: auto;
}
.pg_stampa_ope_p_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1024px;
  min-width:600px;
  height:620px;
}
.pg_stampa_ope_p_portlet[Data-page="1"]{
  height:620px;
  width:100%;
}
.pg_stampa_ope_p_portlet > .Textbox_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:42px;
  left:37px;
  left:4.111111%;
  right:803px;
  right:89.22222%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .Textbox_dadata_reg_ctrl {
}
.pg_stampa_ope_p_portlet > .Textbox_dadata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .Textbox_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:84px;
  left:37px;
  left:4.111111%;
  right:803px;
  right:89.22222%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .Textbox_adata_reg_ctrl {
}
.pg_stampa_ope_p_portlet > .Textbox_adata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .Calendario_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:42px;
  left:104px;
  left:11.555555%;
  right:776px;
  right:86.22222%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .Calendario_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:85px;
  left:104px;
  left:11.555555%;
  right:776px;
  right:86.22222%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .dacodcli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:19px;
  left:267px;
  left:29.666666%;
  right:562px;
  right:62.444443%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .dacodcli_ctrl {
}
.pg_stampa_ope_p_portlet > .dacodcli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .LinkZoom10_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:20px;
  left:339px;
  left:37.666668%;
  right:541px;
  right:60.11111%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .daragsoc_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:19px;
  left:366px;
  left:40.666668%;
  right:7px;
  right:0.7777778%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .daragsoc_ctrl {
}
.pg_stampa_ope_p_portlet > .daragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .a_codcli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:46px;
  left:267px;
  left:29.666666%;
  right:562px;
  right:62.444443%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .a_codcli_ctrl {
}
.pg_stampa_ope_p_portlet > .a_codcli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .LinkZoom12_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:46px;
  left:339px;
  left:37.666668%;
  right:541px;
  right:60.11111%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .a_ragsoc_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:46px;
  left:366px;
  left:40.666668%;
  right:7px;
  right:0.7777778%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .a_ragsoc_ctrl {
}
.pg_stampa_ope_p_portlet > .a_ragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .dacoddest_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:74px;
  left:267px;
  left:29.666666%;
  right:562px;
  right:62.444443%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .dacoddest_ctrl {
}
.pg_stampa_ope_p_portlet > .dacoddest_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .LinkZoom10_Copy_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:75px;
  left:339px;
  left:37.666668%;
  right:541px;
  right:60.11111%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .daragdest_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:74px;
  left:366px;
  left:40.666668%;
  right:7px;
  right:0.7777778%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .daragdest_ctrl {
}
.pg_stampa_ope_p_portlet > .daragdest_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .a_coddest_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:101px;
  left:267px;
  left:29.666666%;
  right:562px;
  right:62.444443%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .a_coddest_ctrl {
}
.pg_stampa_ope_p_portlet > .a_coddest_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .LinkZoom12_Copy_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:101px;
  left:339px;
  left:37.666668%;
  right:541px;
  right:60.11111%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .a_ragdest_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:101px;
  left:366px;
  left:40.666668%;
  right:7px;
  right:0.7777778%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .a_ragdest_ctrl {
}
.pg_stampa_ope_p_portlet > .a_ragdest_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ope_p_portlet > .prnAnalitica_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:130px;
  left:390px;
  left:43.333332%;
  right:480px;
  right:53.333332%;
  width:auto;
  height:30px;
}
.pg_stampa_ope_p_portlet > .prnAnalitica_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#0930F9;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:72px;
  left:134px;
  left:14.888889%;
  right:639px;
  right:71.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stampa_ope_p_portlet > .Label14_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:17px;
  left:134px;
  left:14.888889%;
  right:639px;
  right:71.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stampa_ope_p_portlet > .Label_data_reg_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:13px;
  left:15px;
  left:1.6666666%;
  right:762px;
  right:84.666664%;
  width:auto;
  height:auto;
  min-height:22px;
}
.pg_stampa_ope_p_portlet > .Label_data_reg_ctrl {
  height:auto;
  min-height:22px;
}
.pg_stampa_ope_p_portlet > .Label_data_reg_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stampa_ope_p_portlet > .Box_data_reg_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:15px;
  left:1.6666666%;
  right:762px;
  right:84.666664%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stampa_ope_p_portlet > .Box_data_reg_ctrl {
  height:111px;
}
.pg_stampa_ope_p_portlet > .Box_data_reg_ctrl > .box_content {
  height:100%;
}
.pg_stampa_ope_p_portlet > .Box_data_reg_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:101px;
  left:134px;
  left:14.888889%;
  right:639px;
  right:71.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stampa_ope_p_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:130px;
  left:492px;
  left:54.666668%;
  right:378px;
  right:42.0%;
  width:auto;
  height:30px;
}
.pg_stampa_ope_p_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_stampa_ope_p_portlet > .Ope_Print_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:400px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:199px;
}
.pg_stampa_ope_p_portlet > .flgtit_ctrl {
  box-sizing:border-box;
  z-index:27;
  position:absolute;
  display:inline-block;
  top:133px;
  left:17px;
  left:1.8888888%;
  right:675px;
  right:75.0%;
  width:auto;
  height:20px;
}
.pg_stampa_ope_p_portlet > .ShowMsg_ctrl {
  box-sizing:border-box;
  z-index:28;
  position:absolute;
  display:inline-block;
  top:168px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:90px;
}
.pg_stampa_ope_p_portlet > .ShowLog_ctrl {
  box-sizing:border-box;
  z-index:28;
  position:absolute;
  display:inline-block;
  top:259px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:141px;
}
.pg_stampa_ope_p_portlet > .prnSintetica_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:130px;
  left:441px;
  left:49.0%;
  right:429px;
  right:47.666668%;
  width:auto;
  height:30px;
}
.pg_stampa_ope_p_portlet > .prnSintetica_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#06670B;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:46px;
  left:134px;
  left:14.888889%;
  right:639px;
  right:71.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ope_p_portlet > .Label14_Copy_ctrl {
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
 String def="[{\"h\":\"620\",\"layout_steps_values\":{},\"pages_names\":\"Stampa con Dettaglio\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"900\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"37\",\"y\":\"42\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"37\",\"y\":\"84\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"104\",\"y\":\"42\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"104\",\"y\":\"85\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dacodcli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"71\",\"x\":\"267\",\"y\":\"19\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom10\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"339\",\"y\":\"20\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"527\",\"x\":\"366\",\"y\":\"19\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_codcli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"71\",\"x\":\"267\",\"y\":\"46\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom12\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"339\",\"y\":\"46\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_ragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"527\",\"x\":\"366\",\"y\":\"46\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dacoddest\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"71\",\"x\":\"267\",\"y\":\"74\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom10_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"339\",\"y\":\"75\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daragdest\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"527\",\"x\":\"366\",\"y\":\"74\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_coddest\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"71\",\"x\":\"267\",\"y\":\"101\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom12_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"339\",\"y\":\"101\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_ragdest\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"527\",\"x\":\"366\",\"y\":\"101\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"prnAnalitica\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"390\",\"y\":\"130\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Destinatario:\",\"w\":\"127\",\"x\":\"134\",\"y\":\"72\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"SPAnalitica\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"769\",\"y\":\"-90\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Soggetto:\",\"w\":\"127\",\"x\":\"134\",\"y\":\"17\",\"zindex\":\"5\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_reg\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Registrazione\",\"w\":\"123\",\"x\":\"15\",\"y\":\"13\",\"zindex\":\"23\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_reg\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"15\",\"y\":\"12\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Destinatario:\",\"w\":\"127\",\"x\":\"134\",\"y\":\"101\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"492\",\"y\":\"130\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"199\",\"layout_steps_values\":{},\"name\":\"Ope_Print\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"900\",\"x\":\"0\",\"y\":\"400\",\"zindex\":\"26\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stampa dei titolari effettivi\",\"layout_steps_values\":{},\"name\":\"flgtit\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"208\",\"x\":\"17\",\"y\":\"133\",\"zindex\":\"27\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"ShowMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"900\",\"x\":\"0\",\"y\":\"168\",\"zindex\":\"28\"},{\"anchor\":\"\",\"h\":\"141\",\"layout_steps_values\":{},\"name\":\"ShowLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"900\",\"x\":\"0\",\"y\":\"259\",\"zindex\":\"28\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"prnSintetica\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"441\",\"y\":\"130\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Soggetto:\",\"w\":\"127\",\"x\":\"134\",\"y\":\"46\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"SPSintetica\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"194\",\"x\":\"770\",\"y\":\"-66\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stampa_ope_p","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stampa_ope_p_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stampa_ope_p','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date Textbox_dadata_reg= JSPLib.NullDate();
if(request.getAttribute("pg_stampa_ope_p_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date Textbox_adata_reg= JSPLib.NullDate();
if(request.getAttribute("pg_stampa_ope_p_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String dacodcli= "";
if(request.getAttribute("pg_stampa_ope_p_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String daragsoc= "";
String a_codcli= "";
String a_ragsoc= "";
String dacoddest= "";
String daragdest= "";
String a_coddest= "";
String a_ragdest= "";
String Label14_Copy_Copy= "Da Destinatario:";
String Label14= "Da Soggetto:";
String Label_data_reg= "Data Registrazione";
String Label14_Copy_Copy_Copy= "A Destinatario:";
String flgtit= "";
String Label14_Copy= "A Soggetto:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stampa_ope_p_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stampa_ope_p_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stampa_ope_p_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stampa_ope_p','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_reg_wrp'><input id='<%=idPortlet%>_Textbox_dadata_reg' name='Textbox_dadata_reg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_reg' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_reg>Da</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_reg_wrp'><input id='<%=idPortlet%>_Textbox_adata_reg' name='Textbox_adata_reg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_reg' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_reg>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container'id='<%=idPortlet%>_dacodcli_wrp'><input id='<%=idPortlet%>_dacodcli' name='dacodcli' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='dacodcli' data-sp-item-say-pict='DD-MM-YYYY' data-sp-item-get-pict='DD-MM-YYYY' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom10'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_daragsoc_wrp'><input id='<%=idPortlet%>_daragsoc' name='daragsoc' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='daragsoc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_a_codcli_wrp'><input id='<%=idPortlet%>_a_codcli' name='a_codcli' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='a_codcli' data-sp-item-say-pict='DD-MM-YYYY' data-sp-item-get-pict='DD-MM-YYYY' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom12'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_a_ragsoc_wrp'><input id='<%=idPortlet%>_a_ragsoc' name='a_ragsoc' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='a_ragsoc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dacoddest_wrp'><input id='<%=idPortlet%>_dacoddest' name='dacoddest' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='dacoddest' data-sp-item-say-pict='DD-MM-YYYY' data-sp-item-get-pict='DD-MM-YYYY' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom10_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_daragdest_wrp'><input id='<%=idPortlet%>_daragdest' name='daragdest' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='daragdest' /></span>
<span class='textbox-container'id='<%=idPortlet%>_a_coddest_wrp'><input id='<%=idPortlet%>_a_coddest' name='a_coddest' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='a_coddest' data-sp-item-say-pict='DD-MM-YYYY' data-sp-item-get-pict='DD-MM-YYYY' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom12_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_a_ragdest_wrp'><input id='<%=idPortlet%>_a_ragdest' name='a_ragdest' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='a_ragdest' /></span>
<a id='<%=idPortlet%>_prnAnalitica' class='image-default prnAnalitica_ctrl'   target=''>&#xeb05;</a>
<span id='<%=idPortlet%>_Label14_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label14_Copy_Copy'    class='label Label14_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label14_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Da Destinatario:")%></div></span>
<span id='<%=idPortlet%>_Label14'  formid='<%=idPortlet%>' ps-name='Label14'    class='label Label14_ctrl'><div id='<%=idPortlet%>_Label14tbl' style='width:100%;'><%=JSPLib.ToHTML("Da Soggetto:")%></div></span>
<span id='<%=idPortlet%>_Label_data_reg'  formid='<%=idPortlet%>' ps-name='Label_data_reg'    class='label Label_data_reg_ctrl'><div id='<%=idPortlet%>_Label_data_regtbl' style='width:100%;'><%=JSPLib.ToHTML("Data Registrazione")%></div></span>
<div id='<%=idPortlet%>_Box_data_reg' class='Box_data_reg_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_reg_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label14_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label14_Copy_Copy_Copy'    class='label Label14_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label14_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Destinatario:")%></div></span>
<a id='<%=idPortlet%>_btnExit' class='image-default btnExit_ctrl'   target=''>&#xea01;</a>
<div id='<%=idPortlet%>_Ope_Print_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_flgtit_div' style=''><input id='<%=idPortlet%>_flgtit' name='flgtit' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgtit' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stampa dei titolari effettivi")%></label></div>
<div id='<%=idPortlet%>_ShowMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_1ppw55w",false);%></div>
<div id='<%=idPortlet%>_ShowLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_1ppw4br",false);%></div>
<a id='<%=idPortlet%>_prnSintetica' class='image-default prnSintetica_ctrl'   target=''>&#xeb05;</a>
<span id='<%=idPortlet%>_Label14_Copy'  formid='<%=idPortlet%>' ps-name='Label14_Copy'    class='label Label14_Copy_ctrl'><div id='<%=idPortlet%>_Label14_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Soggetto:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stampa_ope_p');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stampa_ope_p',["900"],["620"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"620","title":"Stampa con Dettaglio","layer":"false","npage":"1"}]);
this.Textbox_dadata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_reg%>","w":60,"x":37,"y":42,"zerofilling":false,"zindex":"5","zoom":""});
this.Textbox_adata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_reg%>","w":60,"x":37,"y":84,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_dadata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_reg','Calendario_dadata_reg',104,42,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_reg',{});
this.Calendario_adata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_reg','Calendario_adata_reg',104,85,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_reg',{});
this.dacodcli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dacodcli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"dacodcli","page":1,"picker":"","picture":"DD-MM-YYYY","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(dacodcli,false,true)%>","w":71,"x":267,"y":19,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom10=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom10","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stampa_ope_p_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"dacodcli,daragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stampa_ope_p_portlet.jspLinkZoom10",request.getSession())%>","linkedField":"dacodcli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom10","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":339,"y":20,"zindex":"6","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.daragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"daragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daragsoc,false,true)%>","w":527,"x":366,"y":19,"zerofilling":false,"zindex":"7","zoom":""});
this.a_codcli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_codcli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"a_codcli","page":1,"picker":"","picture":"DD-MM-YYYY","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(a_codcli,false,true)%>","w":71,"x":267,"y":46,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom12=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom12","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stampa_ope_p_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"a_codcli,a_ragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stampa_ope_p_portlet.jspLinkZoom12",request.getSession())%>","linkedField":"a_codcli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom12","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":339,"y":46,"zindex":"8","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.a_ragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_ragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"a_ragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(a_ragsoc,false,true)%>","w":527,"x":366,"y":46,"zerofilling":false,"zindex":"9","zoom":""});
this.dacoddest=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dacoddest","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"dacoddest","page":1,"picker":"","picture":"DD-MM-YYYY","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(dacoddest,false,true)%>","w":71,"x":267,"y":74,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom10_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom10_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stampa_ope_p_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"dacoddest,daragdest","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stampa_ope_p_portlet.jspLinkZoom10_Copy",request.getSession())%>","linkedField":"dacoddest","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom10_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":339,"y":75,"zindex":"6","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.daragdest=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daragdest","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"daragdest","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daragdest,false,true)%>","w":527,"x":366,"y":74,"zerofilling":false,"zindex":"7","zoom":""});
this.a_coddest=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_coddest","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"a_coddest","page":1,"picker":"","picture":"DD-MM-YYYY","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(a_coddest,false,true)%>","w":71,"x":267,"y":101,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom12_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom12_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stampa_ope_p_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"a_coddest,a_ragdest","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stampa_ope_p_portlet.jspLinkZoom12_Copy",request.getSession())%>","linkedField":"a_coddest","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom12_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":339,"y":101,"zindex":"8","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.a_ragdest=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_ragdest","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"a_ragdest","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(a_ragdest,false,true)%>","w":527,"x":366,"y":101,"zerofilling":false,"zindex":"9","zoom":""});
this.prnAnalitica=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default prnAnalitica_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_prnAnalitica","edit_undercond":"","field":"","font_color":"#0930F9","font_color_hover":"#000000","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Analitica",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"prnAnalitica","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":390,"y":130,"zindex":"6"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label14_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14_Copy_Copy,false,true)%>","type":"Label","w":127,"x":134,"y":72,"zindex":"5"});
this.SPAnalitica=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("opert_stampa_ope",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPAnalitica","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPAnalitica","offline":false,"page":1,"parms":"w_DaDatReg=Textbox_dadata_reg,w_ADatReg=Textbox_adata_reg,w_daSog=dacodcli,w_aSog=a_codcli,w_flgtit=flgtit,pType=P,w_dadest=dacoddest,w_a_dest=a_coddest","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_stampa_ope","target":"Ope_Print","type":"SPLinker","w":197,"x":769,"y":-90});
this.SPAnalitica.m_cID='<%=JSPLib.cmdHash("routine,opert_stampa_ope",request.getSession())%>';
this.Label14=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14,false,true)%>","type":"Label","w":127,"x":134,"y":17,"zindex":"5"});
this.Label_data_reg=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_reg","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_reg","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_reg,false,true)%>","type":"Label","w":123,"x":15,"y":13,"zindex":"23"});
this.Box_data_reg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_reg","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_reg","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":123,"x":15,"y":12,"zindex":"2"});
this.Label14_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14_Copy_Copy_Copy,false,true)%>","type":"Label","w":127,"x":134,"y":101,"zindex":"5"});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":492,"y":130,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Ope_Print=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_Ope_Print","default_portlet":"","h":199,"hide":"false","layer":false,"layout_steps_values":{},"name":"Ope_Print","name_iframe":"Ope_Print","page":1,"spuid":"","type":"Iframe","w":900,"x":0,"y":400,"zindex":"26"});
this.flgtit=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgtit","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Stampa dei titolari effettivi","layer":false,"layout_steps_values":{},"name":"flgtit","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":208,"x":17,"y":133,"zindex":"27"});
if(this.ShowMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_ShowMsg')){
this.ShowMsg.setContainer(this,'ShowMsg')
this.ShowMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_ShowMsg","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"ShowMsg","page":1,"portlet_id":"<%=idPortlet%>_1ppw55w","spuid":"","type":"Portlet","w":900,"x":0,"y":168,"zindex":"28"});
} else {
document.getElementById('<%=idPortlet%>_ShowMsg').style.display='none';
}
if(this.ShowLog=ZtVWeb.getPortletInc('<%=idPortlet%>_ShowLog')){
this.ShowLog.setContainer(this,'ShowLog')
this.ShowLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_ShowLog","h":141,"hide":"false","layer":false,"layout_steps_values":{},"name":"ShowLog","page":1,"portlet_id":"<%=idPortlet%>_1ppw4br","spuid":"","type":"Portlet","w":900,"x":0,"y":259,"zindex":"28"});
} else {
document.getElementById('<%=idPortlet%>_ShowLog').style.display='none';
}
this.prnSintetica=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image-default prnSintetica_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_prnSintetica","edit_undercond":"","field":"","font_color":"#06670B","font_color_hover":"#000000","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Sintetica",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"prnSintetica","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":441,"y":130,"zindex":"6"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label14_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14_Copy,false,true)%>","type":"Label","w":127,"x":134,"y":46,"zindex":"5"});
this.SPSintetica=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPSintetica","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPSintetica","offline":false,"page":1,"parms":"ReportName=operp_stampa_ope_s_4.vrp,w_dadatreg=Textbox_dadata_reg,w_a_datreg=Textbox_adata_reg,w_daSog=dacodcli,w_aSog=a_codcli,rotation=LANDSCAPE,hideParameterMask=true,w_dadest=dacoddest,w_a_dest=a_coddest","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"Ope_Print","type":"SPLinker","w":194,"x":770,"y":-66});
this.SPSintetica.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
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
<%if(request.getAttribute("pg_stampa_ope_p_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stampa_ope_p_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stampa_ope_p_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.prnAnalitica.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.prnSintetica.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stampa_ope_p',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stampa_ope_p');
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
sp.endPage("pg_stampa_ope_p");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom10")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom12")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom10_Copy")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom12_Copy")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3500948190"; } %>