<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"RICERCA DIRETTA SOGGETTO (LISTE WEB)\",true)\n  this.RTAzzeraMessaggi.Link();\n  this.Portlet_showmsg.Timer0_onTimer();\n  this.Portlet_showlog.Timer0_onTimer();  \n  this.denomin.Value(this.nominativo.Value())\n  this.getTitlePortlet().AppendButton({\n    id:\"Ricerca\",\n    title:FormatMsg('Ricerca'),\n    tooltip:FormatMsg('Ricerca i soggetti in base ai parametri'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe942;\"},\n    action:'javascript:' + this.formid +'.Image_esegui_Click()'\n  },1);  \n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa il risultato della ricerca'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.Image_print_Click()'\n  },2);      \n  this.getTitlePortlet().RemoveButton(\"Stampa\")    \n}\n\nfunction Image_esegui_Click(){\n  this.PortletLogs.Start();\n  this.RTRicerca.Link();\n  this.getTitlePortlet().RemoveButton(\"Stampa\")  \n}\n\nfunction RTRicerca_Response(cMsg){\n  this.PortletLogs.Stop();\n  this.SQLDataobj_count_tmp_seek_sogg.Query();  \n}\n\nfunction SQLDataobj_count_tmp_seek_sogg_ConsumersRendered(){\n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa il risultato della ricerca'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.Image_print_Click()'\n  },2);      \n}\n\nfunction Image_print_Click(){\n  if(this.Variable_count_tmp_seek_sogg.Value()==0){\n    if(this.Checkbox_flgnega.Value()=='S'){\n      this.SPLinker_report.Parameters('ReportName=aosrp_ricerca_sogg_neg,outputFormat=PDF,criterio=Radio_criterio,flgnote=Checkbox_flgnote,flgnega=Checkbox_flgnega,flgafon=Checkbox_flgafon,rotation=PORTRAIT,totrec=Variable_totrec,desazi=ABC,w_denomin=denomin,w_simili=simili');\n      this.SPLinker_report.Link();\n    }\n  }else{\n    this.SPLinker_report.Parameters('ReportName=aosrp_ricerca_sogg_web,outputFormat=PDF,criterio=Radio_criterio,flgnote=Checkbox_flgnote,flgnega=Checkbox_flgnega,flgafon=Checkbox_flgafon,rotation=LANDSCAPE,totrec=Variable_totrec,desazi=ABC,w_denomin=denomin,w_simili=simili');\n    this.SPLinker_report.Link();\n  }\n}\n\nfunction Radio_criterio_onChange(){\n  if(this.Radio_criterio.Value()=='D') {\n    this.simili.Value(\"\")\n    this.denomin.Value(this.nominativo.Value())\n  } else {\n    this.denomin.Value(\"\")\n    this.simili.Value(this.nominativo.Value())\n  }  \n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @simili }}{{ @Label_criterio }}{{ @Portlet_showlog }}{{ @Radio_criterio }}{{ @Checkbox_flgnote }}{{ @Checkbox_flgnega }}{{ @Portlet_showmsg }}{{ @Checkbox_flgafon }}{{ @Iframe_elaborazione }}{{ @lblDenom }}{{ @denomin }}{{ @lblSimili }}{{ @simili }}{{ @Label_criterio }}{{ @Radio_criterio }}{{ @Checkbox_flgnote }}{{ @Checkbox_flgnega }}{{ @Checkbox_flgafon }}{{ @Iframe_elaborazione }}{{ @lblDenom }}{{ @denomin }}{{ @lblSimili }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"290","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @simili }} \n{{ gAzienda }}\n{{ simili }}\n{{ Variable_codazi }}\n{{ SQLDataobj_qbe_tot_sog_web }}\n{{ SQLDataobj_count_tmp_seek_sogg }}\n{{ Variable_totrec }}\n{{ Variable_count_tmp_seek_sogg }}\n{{ Label_criterio }}\n{{ Portlet_showlog }}\n{{ Radio_criterio }}\n{{ Image_esegui }}\n{{ Checkbox_flgnote }}\n{{ Image_print }}\n{{ Checkbox_flgnega }}\n{{ Portlet_showmsg }}\n{{ RTRicerca }}{{ nominativo }}\n{{ Checkbox_flgafon }}\n{{ SPLinker_report }}\n{{ Iframe_elaborazione }}\n{{ lblDenom }}\n{{ denomin }}\n{{ lblSimili }}\n{{ RTAzzeraMessaggi }}\n{{ @Label_criterio }} \n \n{{ @Radio_criterio }} \n{{ @Checkbox_flgnote }} \n{{ @Checkbox_flgnega }} \n \n{{ @Checkbox_flgafon }} \n{{ @Iframe_elaborazione }} \n{{ @lblDenom }} \n{{ @denomin }} \n{{ @lblSimili }} \n","included_font":"[]","language":"false","layout_step":"1024","layout_steps_values":"{\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"},\"1024\":{\"h\":\"500\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"290\",\"w\":\"100%\",\"layout_steps_values\":{\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"},\"1024\":{\"h\":\"290\",\"w\":\"100%\"}}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768,1024","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1091","y":"210"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":200,\"w\":320,\"h\":90,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":200,\"w\":480,\"h\":90,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":200,\"w\":768,\"h\":90,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"1024\":{\"x\":0,\"y\":200,\"w\":1024,\"h\":90,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"}}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"200","zindex":"6","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"Radio_criterio='R'","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"Nominativo per ricerca per denominazione","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":87,\"y\":73,\"w\":230,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":130,\"y\":73,\"w\":345,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":207,\"y\":73,\"w\":553,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":276,\"y\":73,\"w\":\"737\",\"h\":22,\"anchor\":\"\",\"hide\":\"false\"}}","maxlength":"","name":"simili","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"737","wireframe_props":"name","x":"276","y":"73","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"calculate":"gAzienda","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"Variable_codazi","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1088","y":"46"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1","name":"SQLDataobj_qbe_tot_sog_web","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tot_sog_web","query_async":"true","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"197","waiting_mgs":"","x":"1084","y":"153"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1","name":"SQLDataobj_count_tmp_seek_sogg","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_count_tmp_seek_sogg","query_async":"false","return_fields_type":"true","sequence":"5","type":"SQLDataobj","w":"230","waiting_mgs":"","x":"1087","y":"-15"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDataobj_qbe_tot_sog_web","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"TOTALE","h":"20","init":"","init_par":"","name":"Variable_totrec","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"numeric","w":"197","x":"1089","y":"75"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDataobj_count_tmp_seek_sogg","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CONTEGGIO","h":"20","init":"","init_par":"","name":"Variable_count_tmp_seek_sogg","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"numeric","w":"230","x":"1087","y":"13"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":9,\"w\":69,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"480\":{\"x\":9,\"y\":9,\"w\":103,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"768\":{\"x\":14,\"y\":9,\"w\":165,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":18,\"y\":9,\"w\":\"220\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"Label_criterio","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo di Ricerca","w":"220","wireframe_props":"align,value,n_col","x":"18","y":"9","zindex":"1","zone":""},{"anchor":"","calculate":"'D'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"25","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":83,\"y\":6,\"w\":215,\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":124,\"y\":6,\"w\":322,\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":129,\"y\":6,\"w\":\"336\",\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":199,\"y\":6,\"w\":516,\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":265,\"y\":6,\"w\":\"688\",\"h\":25,\"anchor\":\"\",\"hide\":\"false\"}}","name":"Radio_criterio","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"10","spuid":"","tabindex":"","textlist":"Denominazione,Ricerca denominazioni simili","type":"Radio","typevar":"character","valuelist":"D,R","visible":"true","w":"688","wireframe_props":"","x":"265","y":"6","zindex":"2","zone":""},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Stampa anche le note","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":41,\"w\":108,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":41,\"w\":162,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":41,\"w\":\"170\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":110,\"w\":259,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":18,\"y\":110,\"w\":\"345\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"Checkbox_flgnote","page":"1","rapp":"","sequence":"11","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"345","wireframe_props":"label_text","x":"18","y":"110","zindex":"3","zone":""},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Stampa anche se esito negativo","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":68,\"w\":148,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":68,\"w\":222,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":68,\"w\":\"232\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":137,\"w\":355,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":18,\"y\":137,\"w\":\"473\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"Checkbox_flgnega","page":"1","rapp":"","sequence":"12","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"473","wireframe_props":"label_text","x":"18","y":"137","zindex":"4","zone":""},{"allowedentities":"aosrt_ricerca_sogg_web","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"routine caller","name":"RTRicerca","offline":"false","page":"1","parms":"w_criterio=Radio_criterio,w_denomin=denomin,w_simili=simili,w_flgnega=Checkbox_flgnega,w_flgnote=Checkbox_flgnote,w_flgafon=Checkbox_flgafon","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"aosrt_ricerca_sogg_web","target":"","type":"SPLinker","w":"240","x":"1083","y":"127"},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Analogia Fonetica","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":98,\"w\":88,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":98,\"w\":132,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":98,\"w\":\"139\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":167,\"w\":211,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":18,\"y\":167,\"w\":\"281\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"Checkbox_flgafon","page":"1","rapp":"","sequence":"15","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"281","wireframe_props":"label_text","x":"18","y":"167","zindex":"5","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"SPLinker_report","offline":"false","page":"1","parms":"ReportName=aosrp_ricerca_sogg_wa,outputFormat=PDF,criterio=Radio_criterio,flgnote=Checkbox_flgnote,flgnega=Checkbox_flgnega,flgafon=Checkbox_flgafon,rotation=LANDSCAPE,totrec=Variable_totrec,desazi=ABC","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"","target":"","type":"SPLinker","w":"120","x":"1087","y":"181"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":194,\"y\":57,\"w\":76,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":291,\"y\":57,\"w\":114,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":302,\"y\":57,\"w\":\"120\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":465,\"y\":126,\"w\":182,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":620,\"y\":126,\"w\":\"242\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"Iframe_elaborazione","page":"1","rapp":"","sequence":"17","spuid":"","type":"Iframe","w":"242","wireframe_props":"","x":"620","y":"126","zindex":"13","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":45,\"w\":83,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":0,\"y\":45,\"w\":124,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":0,\"y\":45,\"w\":200,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":0,\"y\":45,\"w\":\"266\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblDenom","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Denominazione:","w":"266","wireframe_props":"align,value,n_col","x":"0","y":"45","zindex":"14","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"Radio_criterio='D'","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"Nominativo per ricerca per denominazioni simili","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":87,\"y\":44,\"w\":230,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":130,\"y\":44,\"w\":345,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":207,\"y\":44,\"w\":553,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":276,\"y\":44,\"w\":\"737\",\"h\":22,\"anchor\":\"\",\"hide\":\"false\"}}","maxlength":"","name":"denomin","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"737","wireframe_props":"name","x":"276","y":"44","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":74,\"w\":83,\"h\":20,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\" \"},\"480\":{\"x\":0,\"y\":74,\"w\":124,\"h\":20,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\" \"},\"768\":{\"x\":0,\"y\":74,\"w\":200,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":0,\"y\":74,\"w\":\"266\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblSimili","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Denominazioni Simili:","w":"266","wireframe_props":"align,value,n_col","x":"0","y":"74","zindex":"14","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"nominativo","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1096","y":"240"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:nominativo*/%>
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
window.pg_stampa_ricerca_web_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image_esegui_Click !='undefined')this.Image_esegui_Click=Image_esegui_Click;
if(typeof RTRicerca_Response !='undefined')this.RTRicerca_Response=RTRicerca_Response;
if(typeof SQLDataobj_count_tmp_seek_sogg_ConsumersRendered !='undefined')this.SQLDataobj_count_tmp_seek_sogg_ConsumersRendered=SQLDataobj_count_tmp_seek_sogg_ConsumersRendered;
if(typeof Image_print_Click !='undefined')this.Image_print_Click=Image_print_Click;
if(typeof Radio_criterio_onChange !='undefined')this.Radio_criterio_onChange=Radio_criterio_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_EditUnderCondition=function(){
ZtVWeb.EditCtrl(Eq(this.Radio_criterio.Value(),'R'),this.simili);
ZtVWeb.EditCtrl(Eq(this.Radio_criterio.Value(),'D'),this.denomin);
}
ZtVWeb.InitCtrl(this.gAzienda.Value(),this.Variable_codazi);
ZtVWeb.InitCtrl('D',this.Radio_criterio);
ZtVWeb.InitCtrl('S',this.Checkbox_flgnote);
ZtVWeb.InitCtrl('S',this.Checkbox_flgnega);
ZtVWeb.InitCtrl('N',this.Checkbox_flgafon);
this.SQLDataobj_qbe_tot_sog_web.addDataConsumer(this.Variable_totrec,<%=JSPLib.ToJSValue("TOTALE",true)%>);
this.SQLDataobj_count_tmp_seek_sogg.addDataConsumer(this.Variable_count_tmp_seek_sogg,<%=JSPLib.ToJSValue("CONTEGGIO",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("RICERCA DIRETTA SOGGETTO (LISTE WEB)",true)
  this.RTAzzeraMessaggi.Link();
  this.Portlet_showmsg.Timer0_onTimer();
  this.Portlet_showlog.Timer0_onTimer();  
  this.denomin.Value(this.nominativo.Value())
  this.getTitlePortlet().AppendButton({
    id:"Ricerca",
    title:FormatMsg('Ricerca'),
    tooltip:FormatMsg('Ricerca i soggetti in base ai parametri'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe942;"},
    action:'javascript:' + this.formid +'.Image_esegui_Click()'
  },1);  
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa il risultato della ricerca'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.Image_print_Click()'
  },2);      
  this.getTitlePortlet().RemoveButton("Stampa")    
}
function Image_esegui_Click(){
  this.PortletLogs.Start();
  this.RTRicerca.Link();
  this.getTitlePortlet().RemoveButton("Stampa")  
}
function RTRicerca_Response(cMsg){
  this.PortletLogs.Stop();
  this.SQLDataobj_count_tmp_seek_sogg.Query();  
}
function SQLDataobj_count_tmp_seek_sogg_ConsumersRendered(){
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa il risultato della ricerca'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.Image_print_Click()'
  },2);      
}
function Image_print_Click(){
  if(this.Variable_count_tmp_seek_sogg.Value()==0){
    if(this.Checkbox_flgnega.Value()=='S'){
      this.SPLinker_report.Parameters('ReportName=aosrp_ricerca_sogg_neg,outputFormat=PDF,criterio=Radio_criterio,flgnote=Checkbox_flgnote,flgnega=Checkbox_flgnega,flgafon=Checkbox_flgafon,rotation=PORTRAIT,totrec=Variable_totrec,desazi=ABC,w_denomin=denomin,w_simili=simili');
      this.SPLinker_report.Link();
    }
  }else{
    this.SPLinker_report.Parameters('ReportName=aosrp_ricerca_sogg_web,outputFormat=PDF,criterio=Radio_criterio,flgnote=Checkbox_flgnote,flgnega=Checkbox_flgnega,flgafon=Checkbox_flgafon,rotation=LANDSCAPE,totrec=Variable_totrec,desazi=ABC,w_denomin=denomin,w_simili=simili');
    this.SPLinker_report.Link();
  }
}
function Radio_criterio_onChange(){
  if(this.Radio_criterio.Value()=='D') {
    this.simili.Value("")
    this.denomin.Value(this.nominativo.Value())
  } else {
    this.denomin.Value("")
    this.simili.Value(this.nominativo.Value())
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
.pg_stampa_ricerca_web_container {
}
.pg_stampa_ricerca_web_title_container {
  margin: auto;
}
.pg_stampa_ricerca_web_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1024px;
  min-width:320px;
  height:290px;
}
.pg_stampa_ricerca_web_portlet[Data-page="1"]{
  height:290px;
  width:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] {
  height:500px;
  width:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] {
  height:500px;
  width:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] {
  height:500px;
  width:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] {
  height:290px;
  width:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:200px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:200px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:210px;
  width:auto;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:200px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:210px;
  width:auto;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:200px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:210px;
  width:auto;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .simili_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:73px;
  left:276px;
  width:737px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .simili_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:73px;
  left:87px;
  width:230px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .simili_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:73px;
  left:130px;
  width:345px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .simili_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:73px;
  left:207px;
  width:553px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet > .simili_ctrl {
}
.pg_stampa_ricerca_web_portlet > .simili_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Label_criterio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:18px;
  width:220px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Label_criterio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Label_criterio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:6px;
  width:69px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Label_criterio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Label_criterio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:9px;
  width:103px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Label_criterio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Label_criterio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:14px;
  width:165px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Label_criterio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet > .Label_criterio_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Label_criterio_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Label_criterio_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Label_criterio_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Label_criterio_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Radio_criterio_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  left:265px;
  width:688px;
  height:25px;
  height:auto;
  min-height:25px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Radio_criterio_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  left:83px;
  width:215px;
  height:25px;
  height:auto;
  min-height:25px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Radio_criterio_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  left:124px;
  width:322px;
  height:25px;
  height:auto;
  min-height:25px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Radio_criterio_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  left:199px;
  width:516px;
  height:25px;
  height:auto;
  min-height:25px;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Checkbox_flgnote_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:110px;
  left:18px;
  width:345px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Checkbox_flgnote_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:6px;
  width:108px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Checkbox_flgnote_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:9px;
  width:162px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Checkbox_flgnote_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:110px;
  left:14px;
  width:259px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Checkbox_flgnega_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:137px;
  left:18px;
  width:473px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Checkbox_flgnega_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:68px;
  left:6px;
  width:148px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Checkbox_flgnega_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:68px;
  left:9px;
  width:222px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Checkbox_flgnega_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:137px;
  left:14px;
  width:355px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Checkbox_flgafon_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:167px;
  left:18px;
  width:281px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Checkbox_flgafon_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:98px;
  left:6px;
  width:88px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Checkbox_flgafon_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:98px;
  left:9px;
  width:132px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Checkbox_flgafon_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:167px;
  left:14px;
  width:211px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .Iframe_elaborazione_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:126px;
  left:620px;
  width:242px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .Iframe_elaborazione_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:57px;
  left:194px;
  width:76px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .Iframe_elaborazione_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:57px;
  left:291px;
  width:114px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .Iframe_elaborazione_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:126px;
  left:465px;
  width:182px;
  height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .lblDenom_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:45px;
  left:0px;
  width:266px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .lblDenom_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .lblDenom_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:45px;
  left:0px;
  width:83px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="320"] > .lblDenom_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .lblDenom_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:45px;
  left:0px;
  width:124px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="480"] > .lblDenom_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .lblDenom_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:45px;
  left:0px;
  width:200px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="768"] > .lblDenom_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet > .lblDenom_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .lblDenom_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .lblDenom_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .lblDenom_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .lblDenom_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .denomin_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:44px;
  left:276px;
  width:737px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .denomin_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:44px;
  left:87px;
  width:230px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .denomin_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:44px;
  left:130px;
  width:345px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .denomin_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:44px;
  left:207px;
  width:553px;
  height:22px;
}
.pg_stampa_ricerca_web_portlet > .denomin_ctrl {
}
.pg_stampa_ricerca_web_portlet > .denomin_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .lblSimili_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:74px;
  left:0px;
  width:266px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .lblSimili_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .lblSimili_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:74px;
  left:0px;
  width:83px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="320"] > .lblSimili_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .lblSimili_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:74px;
  left:0px;
  width:124px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="480"] > .lblSimili_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .lblSimili_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:74px;
  left:0px;
  width:200px;
  height:auto;
  min-height:20px;
}.pg_stampa_ricerca_web_portlet[Data-step="768"] > .lblSimili_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stampa_ricerca_web_portlet > .lblSimili_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stampa_ricerca_web_portlet[Data-step="1024"] > .lblSimili_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="320"] > .lblSimili_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="480"] > .lblSimili_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stampa_ricerca_web_portlet[Data-step="768"] > .lblSimili_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
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
 String def="[{\"h\":\"290\",\"layout_steps_values\":{\"1024\":{\"h\":\"500\",\"w\":\"100%\"},\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768,1024\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1091\",\"y\":\"210\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":90,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":200},\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":90,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":200},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":90,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":200},\"768\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":90,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":200}},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"200\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":\"737\",\"x\":276,\"y\":73},\"320\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":230,\"x\":87,\"y\":73},\"480\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":345,\"x\":130,\"y\":73},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":553,\"x\":207,\"y\":73}},\"name\":\"simili\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"737\",\"x\":\"276\",\"y\":\"73\",\"zindex\":\"15\"},{\"h\":\"20\",\"name\":\"Variable_codazi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1088\",\"y\":\"46\"},{\"h\":\"20\",\"name\":\"SQLDataobj_qbe_tot_sog_web\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"197\",\"x\":\"1084\",\"y\":\"153\"},{\"h\":\"20\",\"name\":\"SQLDataobj_count_tmp_seek_sogg\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"230\",\"x\":\"1087\",\"y\":\"-15\"},{\"h\":\"20\",\"name\":\"Variable_totrec\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"197\",\"x\":\"1089\",\"y\":\"75\"},{\"h\":\"20\",\"name\":\"Variable_count_tmp_seek_sogg\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"230\",\"x\":\"1087\",\"y\":\"13\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"align\":\"left\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"220\",\"x\":18,\"y\":9},\"320\":{\"align\":\"left\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":69,\"x\":6,\"y\":9},\"480\":{\"align\":\"left\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":103,\"x\":9,\"y\":9},\"768\":{\"align\":\"left\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":165,\"x\":14,\"y\":9}},\"n_col\":\"1\",\"name\":\"Label_criterio\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo di Ricerca\",\"w\":\"220\",\"x\":\"18\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":\"688\",\"x\":265,\"y\":6},\"320\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":215,\"x\":83,\"y\":6},\"480\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":322,\"x\":124,\"y\":6},\"500\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":\"336\",\"x\":129,\"y\":6},\"768\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":516,\"x\":199,\"y\":6}},\"name\":\"Radio_criterio\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"688\",\"x\":\"265\",\"y\":\"6\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stampa anche le note\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"345\",\"x\":18,\"y\":110},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":108,\"x\":6,\"y\":41},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":162,\"x\":9,\"y\":41},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"170\",\"x\":9,\"y\":41},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":259,\"x\":14,\"y\":110}},\"name\":\"Checkbox_flgnote\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"345\",\"x\":\"18\",\"y\":\"110\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stampa anche se esito negativo\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"473\",\"x\":18,\"y\":137},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":148,\"x\":6,\"y\":68},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":222,\"x\":9,\"y\":68},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"232\",\"x\":9,\"y\":68},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":355,\"x\":14,\"y\":137}},\"name\":\"Checkbox_flgnega\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"473\",\"x\":\"18\",\"y\":\"137\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"RTRicerca\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"240\",\"x\":\"1083\",\"y\":\"127\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Analogia Fonetica\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"281\",\"x\":18,\"y\":167},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":88,\"x\":6,\"y\":98},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":132,\"x\":9,\"y\":98},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"139\",\"x\":9,\"y\":98},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":211,\"x\":14,\"y\":167}},\"name\":\"Checkbox_flgafon\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"18\",\"y\":\"167\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"SPLinker_report\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1087\",\"y\":\"181\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"242\",\"x\":620,\"y\":126},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":76,\"x\":194,\"y\":57},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":114,\"x\":291,\"y\":57},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"120\",\"x\":302,\"y\":57},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":182,\"x\":465,\"y\":126}},\"name\":\"Iframe_elaborazione\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"242\",\"x\":\"620\",\"y\":\"126\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"266\",\"x\":0,\"y\":45},\"320\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":83,\"x\":0,\"y\":45},\"480\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":124,\"x\":0,\"y\":45},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":200,\"x\":0,\"y\":45}},\"n_col\":\"1\",\"name\":\"lblDenom\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Denominazione:\",\"w\":\"266\",\"x\":\"0\",\"y\":\"45\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":\"737\",\"x\":276,\"y\":44},\"320\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":230,\"x\":87,\"y\":44},\"480\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":345,\"x\":130,\"y\":44},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":553,\"x\":207,\"y\":44}},\"name\":\"denomin\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"737\",\"x\":\"276\",\"y\":\"44\",\"zindex\":\"15\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"266\",\"x\":0,\"y\":74},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\" \",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":83,\"x\":0,\"y\":74},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\" \",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":124,\"x\":0,\"y\":74},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":200,\"x\":0,\"y\":74}},\"n_col\":\"1\",\"name\":\"lblSimili\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Denominazioni Simili:\",\"w\":\"266\",\"x\":\"0\",\"y\":\"74\",\"zindex\":\"14\"},{\"h\":\"20\",\"name\":\"nominativo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1096\",\"y\":\"240\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stampa_ricerca_web","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stampa_ricerca_web_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stampa_ricerca_web','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gAzienda=sp.getGlobal("gAzienda","");
String simili= "";
if(request.getAttribute("pg_stampa_ricerca_web_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Variable_codazi= "";
double Variable_totrec= 0;
double Variable_count_tmp_seek_sogg= 0;
String Label_criterio= "Tipo di Ricerca";
String Radio_criterio= "";
String Checkbox_flgnote= "";
String Checkbox_flgnega= "";
String Checkbox_flgafon= "";
String lblDenom= "Denominazione:";
String denomin= "";
String lblSimili= "Denominazioni Simili:";
String nominativo=JSPLib.translateXSS(sp.getParameter("nominativo",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stampa_ricerca_web_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stampa_ricerca_web_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stampa_ricerca_web_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stampa_ricerca_web','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_simili_wrp'><input id='<%=idPortlet%>_simili' name='simili' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='simili' /></span>
<span id='<%=idPortlet%>_Label_criterio'  formid='<%=idPortlet%>' ps-name='Label_criterio'    class='label Label_criterio_ctrl'><div id='<%=idPortlet%>_Label_criteriotbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo di Ricerca")%></div></span>
<div id='<%=idPortlet%>_Radio_criterio' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_Checkbox_flgnote_div' style=''><input id='<%=idPortlet%>_Checkbox_flgnote' name='Checkbox_flgnote' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Checkbox_flgnote' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stampa anche le note")%></label></div>
<div id='<%=idPortlet%>_Checkbox_flgnega_div' style=''><input id='<%=idPortlet%>_Checkbox_flgnega' name='Checkbox_flgnega' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Checkbox_flgnega' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stampa anche se esito negativo")%></label></div>
<div id='<%=idPortlet%>_Checkbox_flgafon_div' style=''><input id='<%=idPortlet%>_Checkbox_flgafon' name='Checkbox_flgafon' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Checkbox_flgafon' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Analogia Fonetica")%></label></div>
<div id='<%=idPortlet%>_Iframe_elaborazione_DIV'>&nbsp;</div>
<span id='<%=idPortlet%>_lblDenom'  formid='<%=idPortlet%>' ps-name='lblDenom'    class='label lblDenom_ctrl'><div id='<%=idPortlet%>_lblDenomtbl' style='width:100%;'><%=JSPLib.ToHTML("Denominazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_denomin_wrp'><input id='<%=idPortlet%>_denomin' name='denomin' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='denomin' /></span>
<span id='<%=idPortlet%>_lblSimili'  formid='<%=idPortlet%>' ps-name='lblSimili'    class='label lblSimili_ctrl'><div id='<%=idPortlet%>_lblSimilitbl' style='width:100%;'><%=JSPLib.ToHTML("Denominazioni Simili:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stampa_ricerca_web');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Ricerca",true)+","+JSPLib.ToJSValue(sp.translate("Ricerca"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Ricerca i soggetti in base ai parametri",true)+","+JSPLib.ToJSValue(sp.translate("Ricerca i soggetti in base ai parametri"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa il risultato della ricerca",true)+","+JSPLib.ToJSValue(sp.translate("Stampa il risultato della ricerca"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stampa_ricerca_web',["1024"],["290"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768,1024', 'fixed','<%=m_cTITLEUID%>','',{"1024":{"h":"500","w":"100%"},"320":{"h":"500","w":"100%"},"480":{"h":"500","w":"100%"},"768":{"h":"500","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"500"},"1024":{"w":"100%","h":"290"},"768":{"w":"100%","h":"500"},"480":{"w":"100%","h":"500"}},"w":"1024","h":"290","title":"","layer":""}]);
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-left(%)-right(%)-bottom","h":90,"hide":"false","w":1024,"x":0,"y":200},"320":{"anchor":"top-left(%)-right(%)-bottom","h":90,"hide":"false","w":320,"x":0,"y":200},"480":{"anchor":"top-left(%)-right(%)-bottom","h":90,"hide":"false","w":480,"x":0,"y":200},"768":{"anchor":"top-left(%)-right(%)-bottom","h":90,"hide":"false","w":768,"x":0,"y":200}},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":768,"x":0,"y":200,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.simili=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_simili","decrypt":false,"edit_undercond":"Eq(this.Radio_criterio.Value(),'R')","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"Nominativo per ricerca per denominazione","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":22,"hide":"false","w":"737","x":276,"y":73},"320":{"anchor":" ","h":22,"hide":"false","w":230,"x":87,"y":73},"480":{"anchor":" ","h":22,"hide":"false","w":345,"x":130,"y":73},"768":{"anchor":"","h":22,"hide":"false","w":553,"x":207,"y":73}},"maxlength":"","name":"simili","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(simili,false,true)%>","w":553,"x":207,"y":73,"zerofilling":false,"zindex":"15","zoom":""});
this.Variable_codazi=new ZtVWeb._VC(this,'Variable_codazi',null,'character','<%=JSPLib.ToJSValue(Variable_codazi,false,true)%>',false,false);
this.SQLDataobj_qbe_tot_sog_web=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_tot_sog_web","cmdHash":"<%=JSPLib.cmdHash("qbe_tot_sog_web",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_tot_sog_web","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_tot_sog_web","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":197,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":1084,"y":153});
this.SQLDataobj_count_tmp_seek_sogg=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_count_tmp_seek_sogg","cmdHash":"<%=JSPLib.cmdHash("qbe_count_tmp_seek_sogg",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_count_tmp_seek_sogg","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_count_tmp_seek_sogg","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":230,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":1087,"y":-15});
this.Variable_totrec=new ZtVWeb._VC(this,'Variable_totrec',null,'numeric',<%=Variable_totrec%>,false,false);
this.Variable_count_tmp_seek_sogg=new ZtVWeb._VC(this,'Variable_count_tmp_seek_sogg',null,'numeric',<%=Variable_count_tmp_seek_sogg%>,false,false);
this.Label_criterio=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_criterio","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"left","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":"220","x":18,"y":9},"320":{"align":"left","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":69,"x":6,"y":9},"480":{"align":"left","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":103,"x":9,"y":9},"768":{"align":"left","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":165,"x":14,"y":9}},"n_col":1,"name":"Label_criterio","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_criterio,false,true)%>","type":"Label","w":165,"x":14,"y":9,"zindex":"1"});
this.Radio_criterio=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"'D'","captionsList":"Denominazione,Ricerca denominazioni simili","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_criterio","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":25,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":25,"hide":"false","w":"688","x":265,"y":6},"320":{"anchor":"","h":25,"hide":"false","w":215,"x":83,"y":6},"480":{"anchor":"","h":25,"hide":"false","w":322,"x":124,"y":6},"500":{"anchor":"","h":25,"hide":"false","w":"336","x":129,"y":6},"768":{"anchor":"","h":25,"hide":"false","w":516,"x":199,"y":6}},"name":"Radio_criterio","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,R","visible":true,"w":516,"x":199,"y":6,"zindex":"2"});
this.Checkbox_flgnote=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Checkbox_flgnote","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Stampa anche le note","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"345","x":18,"y":110},"320":{"anchor":"","h":20,"hide":"false","w":108,"x":6,"y":41},"480":{"anchor":"","h":20,"hide":"false","w":162,"x":9,"y":41},"500":{"anchor":"","h":20,"hide":"false","w":"170","x":9,"y":41},"768":{"anchor":"","h":20,"hide":"false","w":259,"x":14,"y":110}},"name":"Checkbox_flgnote","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":259,"x":14,"y":110,"zindex":"3"});
this.Checkbox_flgnega=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Checkbox_flgnega","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Stampa anche se esito negativo","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"473","x":18,"y":137},"320":{"anchor":"","h":20,"hide":"false","w":148,"x":6,"y":68},"480":{"anchor":"","h":20,"hide":"false","w":222,"x":9,"y":68},"500":{"anchor":"","h":20,"hide":"false","w":"232","x":9,"y":68},"768":{"anchor":"","h":20,"hide":"false","w":355,"x":14,"y":137}},"name":"Checkbox_flgnega","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":355,"x":14,"y":137,"zindex":"4"});
this.RTRicerca=new ZtVWeb.SPLinkerCtrl(this,{"action":"routine caller","allowedEntities":"<%=JSPLib.encrypt("aosrt_ricerca_sogg_web",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRicerca","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRicerca","offline":false,"page":1,"parms":"w_criterio=Radio_criterio,w_denomin=denomin,w_simili=simili,w_flgnega=Checkbox_flgnega,w_flgnote=Checkbox_flgnote,w_flgafon=Checkbox_flgafon","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"aosrt_ricerca_sogg_web","target":"","type":"SPLinker","w":240,"x":1083,"y":127});
this.RTRicerca.m_cID='<%=JSPLib.cmdHash("routine,aosrt_ricerca_sogg_web",request.getSession())%>';
this.Checkbox_flgafon=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Checkbox_flgafon","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Analogia Fonetica","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"281","x":18,"y":167},"320":{"anchor":"","h":20,"hide":"false","w":88,"x":6,"y":98},"480":{"anchor":"","h":20,"hide":"false","w":132,"x":9,"y":98},"500":{"anchor":"","h":20,"hide":"false","w":"139","x":9,"y":98},"768":{"anchor":"","h":20,"hide":"false","w":211,"x":14,"y":167}},"name":"Checkbox_flgafon","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":211,"x":14,"y":167,"zindex":"5"});
this.SPLinker_report=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_report","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_report","offline":false,"page":1,"parms":"ReportName=aosrp_ricerca_sogg_wa,outputFormat=PDF,criterio=Radio_criterio,flgnote=Checkbox_flgnote,flgnega=Checkbox_flgnega,flgafon=Checkbox_flgafon,rotation=LANDSCAPE,totrec=Variable_totrec,desazi=ABC","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":120,"x":1087,"y":181});
this.SPLinker_report.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Iframe_elaborazione=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_Iframe_elaborazione","default_portlet":"","h":20,"hide":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"242","x":620,"y":126},"320":{"anchor":"","h":20,"hide":"false","w":76,"x":194,"y":57},"480":{"anchor":"","h":20,"hide":"false","w":114,"x":291,"y":57},"500":{"anchor":"","h":20,"hide":"false","w":"120","x":302,"y":57},"768":{"anchor":"","h":20,"hide":"false","w":182,"x":465,"y":126}},"name":"Iframe_elaborazione","name_iframe":"Iframe_elaborazione","page":1,"spuid":"","type":"Iframe","w":182,"x":465,"y":126,"zindex":"13"});
this.lblDenom=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDenom","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":"266","x":0,"y":45},"320":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":83,"x":0,"y":45},"480":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":124,"x":0,"y":45},"768":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":200,"x":0,"y":45}},"n_col":1,"name":"lblDenom","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDenom,false,true)%>","type":"Label","w":200,"x":0,"y":45,"zindex":"14"});
this.denomin=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_denomin","decrypt":false,"edit_undercond":"Eq(this.Radio_criterio.Value(),'D')","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"Nominativo per ricerca per denominazioni simili","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":22,"hide":"false","w":"737","x":276,"y":44},"320":{"anchor":"","h":22,"hide":"false","w":230,"x":87,"y":44},"480":{"anchor":"","h":22,"hide":"false","w":345,"x":130,"y":44},"768":{"anchor":"","h":22,"hide":"false","w":553,"x":207,"y":44}},"maxlength":"","name":"denomin","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(denomin,false,true)%>","w":553,"x":207,"y":44,"zerofilling":false,"zindex":"15","zoom":""});
this.lblSimili=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSimili","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":"266","x":0,"y":74},"320":{"align":"right","anchor":" ","fontpct":" ","h":20,"hide":"false","n_col":1,"w":83,"x":0,"y":74},"480":{"align":"right","anchor":" ","fontpct":" ","h":20,"hide":"false","n_col":1,"w":124,"x":0,"y":74},"768":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":200,"x":0,"y":74}},"n_col":1,"name":"lblSimili","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblSimili,false,true)%>","type":"Label","w":200,"x":0,"y":74,"zindex":"14"});
this.nominativo=new ZtVWeb._VC(this,'nominativo',null,'character','<%=JSPLib.ToJSValue(nominativo,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_stampa_ricerca_web_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stampa_ricerca_web_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stampa_ricerca_web_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLDataobj_qbe_tot_sog_web.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stampa_ricerca_web',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stampa_ricerca_web');
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
sp.endPage("pg_stampa_ricerca_web");
}%>
<%! public String getJSPUID() { return "1074581454"; } %>