<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate Sintetica '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);\n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa le anagrafiche dei soggetti'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.Image_prn_Click()'\n  },1);   \n}\n\nfunction Image_prn_Click(){\n\tif(this.Radio_OrderBy.Value()=='D'){\n    this.Variable_OrderBy.Value('DATAREG,NUMPROG,IDBASE');\n  }\n  else{\n    if(this.Radio_OrderBy.Value()=='N'){\n      this.Variable_OrderBy.Value('NUMPROG,DATAREG,IDBASE');\n    }else{\n      this.Variable_OrderBy.Value('');\n    }\n  }\n  this.PortletLogs.Start();\n  this.SPLinker_arrp_stpoper_sa.Link()\n}\n\nfunction Radio_Tipo_Stampa_onChange(){  \n  if(this.Radio_Tipo_Stampa.Value()=='D')\n    this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate con Dettaglio Anagrafico '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);\n  if(this.Radio_Tipo_Stampa.Value()=='A')\n    this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate Analitica '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);\n  if(this.Radio_Tipo_Stampa.Value()=='S')\n\t  this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate Sintetica '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);\n  this.Ope_Print.Reload()\n}\n\nfunction SPLinker_arrp_stpoper_sa_Executed(result,cError){\n this.PortletLogs.Stop(); \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Stampa con Dettaglio Anagrafico","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Radio_Stato_Ope }}{{ @Textbox_dadata_ret }}{{ @Box_data_informazione }}{{ @Calendario_dadata_ret }}{{ @Textbox_adata_ret }}{{ @Textbox_dadata_ope }}{{ @Calendario_adata_ret }}{{ @Calendario_dadata_ope }}{{ @Label_data_Ret }}{{ @Textbox_adata_ope }}{{ @Calendario_adata_ope }}{{ @Label_data_ope }}{{ @Label_data_reg }}{{ @Box_data_reg }}{{ @Textbox_dadata_reg }}{{ @Textbox_adata_reg }}{{ @Calendario_adata_reg }}{{ @Calendario_dadata_reg }}{{ @Radio_OrderBy }}{{ @Stp_dist_lire_euro }}{{ @Label_ordinamento }}{{ @Radio_Tipo_Operaz }}{{ @Senza_dip }}{{ @btnExit }}{{ @Tipo_Oper }}{{ @Solo_attive }}{{ @stato_operazione }}{{ @Radio_Tipo_Stampa }}{{ @Con_Contanti }}{{ @Radio_TitEssere }}{{ @Textbox_intestatario }}{{ @LinkZoom_intestatario }}{{ @Textbox_desc_intestatario }}{{ @Textbox_dipendenza }}{{ @LinkZoom_dipendenza }}{{ @Textbox_desc_dipendenza }}{{ @Box34 }}{{ @Ope_Print }}{{ @Box_data_informazione_Copy }}{{ @tipo_stampa }}{{ @Image_prn }}{{ @Radio_Stato_Ope }}{{ @Textbox_dadata_ret }}{{ @Box_data_informazione }}{{ @Calendario_dadata_ret }}{{ @Textbox_adata_ret }}{{ @Textbox_dadata_ope }}{{ @Calendario_adata_ret }}{{ @Calendario_dadata_ope }}{{ @Label_data_Ret }}{{ @Textbox_adata_ope }}{{ @Calendario_adata_ope }}{{ @Label_data_ope }}{{ @Label_data_reg }}{{ @Box_data_reg }}{{ @Textbox_dadata_reg }}{{ @Textbox_adata_reg }}{{ @Calendario_adata_reg }}{{ @Calendario_dadata_reg }}{{ @Radio_OrderBy }}{{ @Stp_dist_lire_euro }}{{ @Label_ordinamento }}{{ @Radio_Tipo_Operaz }}{{ @Senza_dip }}{{ @Tipo_Oper }}{{ @Solo_attive }}{{ @stato_operazione }}{{ @Radio_Tipo_Stampa }}{{ @Con_Contanti }}{{ @Radio_TitEssere }}{{ @Textbox_intestatario }}{{ @LinkZoom_intestatario }}{{ @Textbox_desc_intestatario }}{{ @Textbox_dipendenza }}{{ @LinkZoom_dipendenza }}{{ @Textbox_desc_dipendenza }}{{ @Box34 }}{{ @Ope_Print }}{{ @Box_data_informazione_Copy }}{{ @tipo_stampa }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"720","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @tipo_stampa }}\n{{ @Box_data_informazione_Copy }}\n{{ @Ope_Print }}\n{{ @Box34 }}\n{{ @Textbox_desc_dipendenza }}\n{{ @LinkZoom_dipendenza }}\n{{ @Textbox_dipendenza }}\n{{ @Textbox_desc_intestatario }}\n{{ @LinkZoom_intestatario }}\n{{ @Textbox_intestatario }}\n{{ @Radio_TitEssere }}\n{{ @Con_Contanti }}\n{{ @Radio_Tipo_Stampa }}\n{{ @stato_operazione }}\n{{ @Solo_attive }}\n{{ @Tipo_Oper }}\n\n{{ @Senza_dip }}\n{{ @Radio_Tipo_Operaz }}\n{{ @Label_ordinamento }}\n{{ @Stp_dist_lire_euro }}\n{{ @Radio_OrderBy }}\n{{ @Calendario_dadata_reg }}\n{{ @Calendario_adata_reg }}\n{{ @Textbox_adata_reg }}\n{{ @Textbox_dadata_reg }}\n{{ @Box_data_reg }}\n{{ @Label_data_reg }}\n{{ @Label_data_ope }}\n{{ @Calendario_adata_ope }}\n{{ @Textbox_adata_ope }}\n{{ @Label_data_Ret }}\n{{ @Calendario_dadata_ope }}\n{{ @Calendario_adata_ret }}\n{{ @Textbox_dadata_ope }}\n{{ @Textbox_adata_ret }}\n{{ @Calendario_dadata_ret }}\n{{ @Box_data_informazione }}\n{{ @Textbox_dadata_ret }}\n{{ @Radio_Stato_Ope }}\n\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"Stampa con Dettaglio\",\"layer\":\"\",\"h\":\"720\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Stampa con Dettaglio","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"540","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"540","wireframe_props":"","x":"0","y":"630","zindex":"6","zone":""},{"anchor":"","calculate":"'T'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"20","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"Radio_Stato_Ope","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"2","spuid":"","tabindex":"","textlist":"Tutte,Solo Attive,Solo Cancellate,Solo vecchia copia di modifica","type":"Radio","typevar":"character","valuelist":"T,A,C,M","visible":"true","w":"314","wireframe_props":"","x":"227","y":"259","zindex":"16","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_ret","page":"1","password":"","picker":"","picture":"","placeholder":"Da","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"381","y":"41","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"118","hide":"","layer":"","layout_steps_values":"{}","name":"Note45","page":"1","rapp":"","sequence":"4","spuid":"","type":"Note","value":"stato definisce lo stato dell'operazione:\nT = Tutte\nA = Solo op. Attive (STATOREG = 0,1)\nC = Solo op. Cancellate (STATOREG = 2)\nM = Solo vecchia copia di op. Modificate ((STATOREG = 3)","w":"298","wireframe_props":"","x":"551","y":"101","zindex":"27","zone":""},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_informazione","page":"1","rapp":"","sequence":"5","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"123","wireframe_props":"","x":"57","y":"12","zindex":"2","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_ret","page":"1","popup":"true","rapp":"","return_input":"Textbox_dadata_ret","sequence":"6","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"446","y":"41","zindex":"19","zone":""},{"allowedentities":"arrt_stp_ope_fraz_all","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPLinker_arrp_stpoper_sa","offline":"false","page":"1","parms":"w_DaDatOpe=Textbox_dadata_ope,w_ADatOpe=Textbox_adata_ope,w_DaDatReg=Textbox_dadata_reg,w_EstrazTitEffNelPeriodo=Radio_TitEssere,w_OrderBy=Variable_OrderBy,w_CONNES=Textbox_intestatario,w_TipoOpeStampa=Radio_Tipo_Operaz,w_TipoStampa=Radio_Tipo_Stampa,w_Stp_dist_lire_euro=Stp_dist_lire_euro,w_Con_Contanti=Con_Contanti,w_Solo_attive=Solo_attive,w_Senza_dip=Senza_dip,w_Dipendenza=Textbox_dipendenza,w_ADatReg=Textbox_adata_reg,w_Ambito=ambito,w_DaDatRet=Textbox_dadata_ret,w_ADatRet=Textbox_adata_ret,w_Stato=Radio_Stato_Ope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arrt_stp_ope_fraz_all","target":"Ope_Print","type":"SPLinker","w":"197","x":"552","y":"-50"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_ret","page":"1","password":"","picker":"","picture":"","placeholder":"A","rapp":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"381","y":"84","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_ope","page":"1","password":"","picker":"","picture":"","placeholder":"Da","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"77","y":"41","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_ret","page":"1","popup":"true","rapp":"","return_input":"Textbox_adata_ret","sequence":"10","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"446","y":"84","zindex":"6","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_ope","page":"1","popup":"true","rapp":"","return_input":"Textbox_dadata_ope","sequence":"11","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"142","y":"41","zindex":"19","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_Ret","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Rettifica","w":"123","wireframe_props":"align,value,n_col","x":"361","y":"13","zindex":"22","zone":""},{"calculate":"'DATAREG,NUMPROG,IDBASE'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"Variable_OrderBy","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"197","x":"551","y":"-77"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_ope","page":"1","password":"","picker":"","picture":"","placeholder":"A","rapp":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"77","y":"84","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_ope","page":"1","popup":"true","rapp":"","return_input":"Textbox_adata_ope","sequence":"15","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"142","y":"84","zindex":"6","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_ope","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Operazione","w":"123","wireframe_props":"align,value,n_col","x":"57","y":"13","zindex":"22","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_reg","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Registrazione","w":"123","wireframe_props":"align,value,n_col","x":"208","y":"13","zindex":"23","zone":""},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_reg","page":"1","rapp":"","sequence":"18","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"123","wireframe_props":"","x":"208","y":"12","zindex":"2","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_dadata_reg","page":"1","password":"","picker":"","picture":"","placeholder":"Da","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"230","y":"42","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_adata_reg","page":"1","password":"","picker":"","picture":"","placeholder":"A","rapp":"","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"230","y":"84","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_reg","page":"1","popup":"true","rapp":"","return_input":"Textbox_adata_reg","sequence":"21","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"297","y":"85","zindex":"6","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_reg","page":"1","popup":"true","rapp":"","return_input":"Textbox_dadata_reg","sequence":"22","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"297","y":"42","zindex":"6","zone":""},{"anchor":"top-center","calculate":"'D'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"45","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"Radio_OrderBy","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"23","spuid":"","tabindex":"","textlist":"Data Registraz. N. Progressivo,N. Progressivo Data Registraz.","type":"Radio","typevar":"character","valuelist":"D,N","visible":"true","w":"230","wireframe_props":"","x":"162","y":"340","zindex":"12","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"false","label_text":" Stampa Distinta Lire\u002fEuro","layer":"false","layout_steps_values":"{}","name":"Stp_dist_lire_euro","page":"1","rapp":"","sequence":"24","spuid":"","style_type":"standard","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"195","wireframe_props":"label_text","x":"572","y":"406","zindex":"18","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_ordinamento","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"25","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Stampa ordinata per:","w":"480","wireframe_props":"align,value,n_col","x":"29","y":"316","zindex":"11","zone":""},{"anchor":"","calculate":"'O'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"20","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"Radio_Tipo_Operaz","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"26","spuid":"","tabindex":"","textlist":"Operazioni,Frazionate,Entrambe","type":"Radio","typevar":"character","valuelist":"O,F,E","visible":"true","w":"314","wireframe_props":"","x":"227","y":"232","zindex":"16","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":" Senza dipendenza (con Intermediario)","layer":"false","layout_steps_values":"{}","name":"Senza_dip","page":"1","rapp":"","sequence":"27","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"188","wireframe_props":"label_text","x":"99","y":"411","zindex":"18","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Tipo_Oper","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo di Operazione:","w":"138","wireframe_props":"align,value,n_col","x":"79","y":"232","zindex":"17","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"false","label_text":" Solo operazioni attive","layer":"false","layout_steps_values":"{}","name":"Solo_attive","page":"1","rapp":"","sequence":"30","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"170","wireframe_props":"label_text","x":"573","y":"433","zindex":"18","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"stato_operazione","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Stato Operazione:","w":"138","wireframe_props":"align,value,n_col","x":"79","y":"259","zindex":"17","zone":""},{"anchor":"","calculate":"'S'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"20","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"Radio_Tipo_Stampa","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"32","spuid":"","tabindex":"","textlist":"Dettaglio Anagrafico,Analitica,Sintetica","type":"Radio","typevar":"character","valuelist":"D,A,S","visible":"true","w":"314","wireframe_props":"","x":"227","y":"286","zindex":"16","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":" Solo con presenza di contanti","layer":"false","layout_steps_values":"{}","name":"Con_Contanti","page":"1","rapp":"","sequence":"33","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"195","wireframe_props":"label_text","x":"307","y":"411","zindex":"18","zone":""},{"anchor":"top-center","calculate":"'S'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"66","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"Radio_TitEssere","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"34","spuid":"","tabindex":"","textlist":"Estrazione solo dei Titolari Effettivi in essere nel periodo di date scelto,Estrazione dei Titolari Effettivi SENZA filtro per periodo di date scelto,Estrazione solo dei titolari effetti collegati direttamente all'operazione","type":"Radio","typevar":"character","valuelist":"S,N,X","visible":"true","w":"495","wireframe_props":"","x":"25","y":"128","zindex":"10","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"Textbox_intestatario","page":"1","password":"","picker":"","picture":"","placeholder":"Intestatario","rapp":"","readonly":"false","scroll":"false","sequence":"35","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"131","wireframe_props":"name","x":"79","y":"200","zerofilling":"false","zindex":"13","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"Textbox_intestatario,Textbox_desc_intestatario","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_intestatario","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_intestatario","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"36","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"213","y":"200","zindex":"14","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"30","name":"Textbox_desc_intestatario","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"37","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"225","wireframe_props":"name","x":"235","y":"200","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"Textbox_dipendenza","page":"1","password":"","picker":"","picture":"","placeholder":"Dipendenza","rapp":"","readonly":"false","scroll":"false","sequence":"38","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"131","wireframe_props":"name","x":"79","y":"451","zerofilling":"false","zindex":"13","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"Textbox_dipendenza,Textbox_desc_dipendenza","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_dipendenza","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_dipendenza","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"39","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"213","y":"451","zindex":"14","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"30","name":"Textbox_desc_dipendenza","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"40","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"225","wireframe_props":"name","x":"236","y":"451","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"80","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box34","page":"1","rapp":"","sequence":"41","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"284","wireframe_props":"","x":"126","y":"314","zindex":"0","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ambito","page":"1","reactive":"","sequence":"42","server_side":"false","type":"Variable","typevar":"character","w":"197","x":"551","y":"-23"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"90","hide":"","layer":"","layout_steps_values":"{}","name":"ambito","page":"1","rapp":"","sequence":"43","spuid":"","type":"Note","value":"ambito definisce la provenienza della chiamata: \nD = Definitivo\u002fAUI, \nP = Provvisorio","w":"197","wireframe_props":"","x":"551","y":"4","zindex":"25","zone":""},{"anchor":"","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"Ope_Print","page":"1","rapp":"","sequence":"44","spuid":"","type":"Iframe","w":"540","wireframe_props":"","x":"0","y":"478","zindex":"26","zone":""},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_informazione_Copy","page":"1","rapp":"","sequence":"45","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"123","wireframe_props":"","x":"361","y":"12","zindex":"2","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"tipo_stampa","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"46","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo di Stampa:","w":"138","wireframe_props":"align,value,n_col","x":"79","y":"286","zindex":"17","zone":""}]%>
<%/*Description:Stampa con Dettaglio Anagrafico*/%>
<%/*ParamsRequest:ambito*/%>
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
window.pg_stp_ope_fraz_all_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image_prn_Click !='undefined')this.Image_prn_Click=Image_prn_Click;
if(typeof Radio_Tipo_Stampa_onChange !='undefined')this.Radio_Tipo_Stampa_onChange=Radio_Tipo_Stampa_onChange;
if(typeof SPLinker_arrp_stpoper_sa_Executed !='undefined')this.SPLinker_arrp_stpoper_sa_Executed=SPLinker_arrp_stpoper_sa_Executed;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('T',this.Radio_Stato_Ope);
ZtVWeb.InitCtrl('DATAREG,NUMPROG,IDBASE',this.Variable_OrderBy);
ZtVWeb.InitCtrl('D',this.Radio_OrderBy);
ZtVWeb.InitCtrl('O',this.Radio_Tipo_Operaz);
ZtVWeb.InitCtrl('S',this.Radio_Tipo_Stampa);
ZtVWeb.InitCtrl('S',this.Radio_TitEssere);
this.LinkZoom_intestatario.addObserverFixedVars();
this.LinkZoom_dipendenza.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate Sintetica '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa le anagrafiche dei soggetti'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.Image_prn_Click()'
  },1);   
}
function Image_prn_Click(){
	if(this.Radio_OrderBy.Value()=='D'){
    this.Variable_OrderBy.Value('DATAREG,NUMPROG,IDBASE');
  }
  else{
    if(this.Radio_OrderBy.Value()=='N'){
      this.Variable_OrderBy.Value('NUMPROG,DATAREG,IDBASE');
    }else{
      this.Variable_OrderBy.Value('');
    }
  }
  this.PortletLogs.Start();
  this.SPLinker_arrp_stpoper_sa.Link()
}
function Radio_Tipo_Stampa_onChange(){  
  if(this.Radio_Tipo_Stampa.Value()=='D')
    this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate con Dettaglio Anagrafico '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);
  if(this.Radio_Tipo_Stampa.Value()=='A')
    this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate Analitica '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);
  if(this.Radio_Tipo_Stampa.Value()=='S')
	  this.getTitlePortlet().SetTitle('Stampa Operazioni e Frazionate Sintetica '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);
  this.Ope_Print.Reload()
}
function SPLinker_arrp_stpoper_sa_Executed(result,cError){
 this.PortletLogs.Stop(); 
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
.pg_stp_ope_fraz_all_container {
  height:100%;
  overflow:auto;
}
.pg_stp_ope_fraz_all_title_container {
  margin: auto;
}
.pg_stp_ope_fraz_all_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:540px;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_stp_ope_fraz_all_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:630px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_stp_ope_fraz_all_portlet > .Radio_Stato_Ope_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:259px;
  left:227px;
  left:42.037037%;
  right:-1px;
  right:-0.18518518%;
  width:auto;
  height:20px;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_ret_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:41px;
  left:381px;
  left:70.55556%;
  right:99px;
  right:18.333334%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_ret_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_ret_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:57px;
  left:10.555555%;
  right:360px;
  right:66.666664%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_ctrl {
  height:111px;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_ctrl > .box_content {
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stp_ope_fraz_all_portlet > .Calendario_dadata_ret_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:41px;
  left:446px;
  left:82.59259%;
  right:74px;
  right:13.703704%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_ret_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:84px;
  left:381px;
  left:70.55556%;
  right:99px;
  right:18.333334%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_ret_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_ret_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_ope_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:41px;
  left:77px;
  left:14.259259%;
  right:403px;
  right:74.62963%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_ope_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_ope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Calendario_adata_ret_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:84px;
  left:446px;
  left:82.59259%;
  right:74px;
  right:13.703704%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Calendario_dadata_ope_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:41px;
  left:142px;
  left:26.296297%;
  right:378px;
  right:70.0%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_Ret_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:13px;
  left:361px;
  left:66.85185%;
  right:56px;
  right:10.37037%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_Ret_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_Ret_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_ope_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:84px;
  left:77px;
  left:14.259259%;
  right:403px;
  right:74.62963%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_ope_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_ope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Calendario_adata_ope_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:84px;
  left:142px;
  left:26.296297%;
  right:378px;
  right:70.0%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_ope_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:13px;
  left:57px;
  left:10.555555%;
  right:360px;
  right:66.666664%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_ope_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_ope_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_reg_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:13px;
  left:208px;
  left:38.51852%;
  right:209px;
  right:38.703705%;
  width:auto;
  height:auto;
  min-height:22px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_reg_ctrl {
  height:auto;
  min-height:22px;
}
.pg_stp_ope_fraz_all_portlet > .Label_data_reg_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_reg_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:208px;
  left:38.51852%;
  right:209px;
  right:38.703705%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_reg_ctrl {
  height:111px;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_reg_ctrl > .box_content {
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_reg_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:42px;
  left:230px;
  left:42.592594%;
  right:250px;
  right:46.296295%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_reg_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dadata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:84px;
  left:230px;
  left:42.592594%;
  right:250px;
  right:46.296295%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_reg_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_adata_reg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Calendario_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:85px;
  left:297px;
  left:55.0%;
  right:223px;
  right:41.296295%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Calendario_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:42px;
  left:297px;
  left:55.0%;
  right:223px;
  right:41.296295%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Radio_OrderBy_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:340px;
  width:230px;
  height:45px;
  margin-left:-108px;
  left:50%;
  height:auto;
  min-height:45px;
}
.pg_stp_ope_fraz_all_portlet > .Stp_dist_lire_euro_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:406px;
  left:572px;
  left:105.92593%;
  right:-227px;
  right:-42.037037%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stp_ope_fraz_all_portlet > .Label_ordinamento_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:316px;
  left:29px;
  left:5.3703704%;
  right:31px;
  right:5.740741%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Label_ordinamento_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Label_ordinamento_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_ope_fraz_all_portlet > .Radio_Tipo_Operaz_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:232px;
  left:227px;
  left:42.037037%;
  right:-1px;
  right:-0.18518518%;
  width:auto;
  height:20px;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Senza_dip_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:411px;
  left:99px;
  left:18.333334%;
  right:253px;
  right:46.851852%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Tipo_Oper_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:232px;
  left:79px;
  left:14.62963%;
  right:323px;
  right:59.814816%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Tipo_Oper_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Tipo_Oper_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stp_ope_fraz_all_portlet > .Solo_attive_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:433px;
  left:573px;
  left:106.111115%;
  right:-203px;
  right:-37.592594%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stp_ope_fraz_all_portlet > .stato_operazione_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:259px;
  left:79px;
  left:14.62963%;
  right:323px;
  right:59.814816%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .stato_operazione_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .stato_operazione_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stp_ope_fraz_all_portlet > .Radio_Tipo_Stampa_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:286px;
  left:227px;
  left:42.037037%;
  right:-1px;
  right:-0.18518518%;
  width:auto;
  height:20px;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Con_Contanti_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:411px;
  left:307px;
  left:56.851852%;
  right:38px;
  right:7.037037%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Radio_TitEssere_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:128px;
  width:495px;
  height:66px;
  margin-left:-245px;
  left:50%;
  height:auto;
  min-height:66px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_intestatario_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:200px;
  left:79px;
  left:14.62963%;
  right:330px;
  right:61.11111%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_intestatario_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_intestatario_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .LinkZoom_intestatario_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:200px;
  left:213px;
  left:39.444443%;
  right:307px;
  right:56.851852%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_desc_intestatario_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:200px;
  left:235px;
  left:43.51852%;
  right:80px;
  right:14.814815%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_desc_intestatario_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_desc_intestatario_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dipendenza_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:451px;
  left:79px;
  left:14.62963%;
  right:330px;
  right:61.11111%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dipendenza_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_dipendenza_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .LinkZoom_dipendenza_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:451px;
  left:213px;
  left:39.444443%;
  right:307px;
  right:56.851852%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_desc_dipendenza_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:451px;
  left:236px;
  left:43.703705%;
  right:79px;
  right:14.62963%;
  width:auto;
  height:20px;
}
.pg_stp_ope_fraz_all_portlet > .Textbox_desc_dipendenza_ctrl {
}
.pg_stp_ope_fraz_all_portlet > .Textbox_desc_dipendenza_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Box34_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:314px;
  left:126px;
  left:23.333334%;
  right:130px;
  right:24.074074%;
  width:auto;
  height:auto;
  min-height:80px;
  display:flex;
  flex-direction:column;
}
.pg_stp_ope_fraz_all_portlet > .Box34_ctrl {
  height:80px;
}
.pg_stp_ope_fraz_all_portlet > .Box34_ctrl > .box_content {
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Box34_ctrl {
  min-height:80px;
  border-color:#CBCBCB;
}
.pg_stp_ope_fraz_all_portlet > .Ope_Print_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:478px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:150px;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_Copy_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:361px;
  left:66.85185%;
  right:56px;
  right:10.37037%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_Copy_ctrl {
  height:111px;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_Copy_ctrl > .box_content {
  height:100%;
}
.pg_stp_ope_fraz_all_portlet > .Box_data_informazione_Copy_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stp_ope_fraz_all_portlet > .tipo_stampa_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:286px;
  left:79px;
  left:14.62963%;
  right:323px;
  right:59.814816%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .tipo_stampa_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_ope_fraz_all_portlet > .tipo_stampa_ctrl {
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
 String def="[{\"h\":\"720\",\"layout_steps_values\":{},\"pages_names\":\"Stampa con Dettaglio\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"540\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"540\",\"x\":\"0\",\"y\":\"630\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Radio\",\"w\":\"314\",\"x\":\"227\",\"y\":\"259\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_ret\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"381\",\"y\":\"41\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"118\",\"layout_steps_values\":{},\"name\":\"Note45\",\"page\":\"1\",\"type\":\"Note\",\"w\":\"298\",\"x\":\"551\",\"y\":\"101\",\"zindex\":\"27\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_informazione\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"57\",\"y\":\"12\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_ret\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"446\",\"y\":\"41\",\"zindex\":\"19\"},{\"h\":\"20\",\"name\":\"SPLinker_arrp_stpoper_sa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"552\",\"y\":\"-50\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_ret\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"381\",\"y\":\"84\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_ope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"77\",\"y\":\"41\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_ret\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"446\",\"y\":\"84\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_ope\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"142\",\"y\":\"41\",\"zindex\":\"19\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_Ret\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Rettifica\",\"w\":\"123\",\"x\":\"361\",\"y\":\"13\",\"zindex\":\"22\"},{\"h\":\"20\",\"name\":\"Variable_OrderBy\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"197\",\"x\":\"551\",\"y\":\"-77\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_ope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"77\",\"y\":\"84\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_ope\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"142\",\"y\":\"84\",\"zindex\":\"6\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_ope\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Operazione\",\"w\":\"123\",\"x\":\"57\",\"y\":\"13\",\"zindex\":\"22\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_reg\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Registrazione\",\"w\":\"123\",\"x\":\"208\",\"y\":\"13\",\"zindex\":\"23\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_reg\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"208\",\"y\":\"12\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dadata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"230\",\"y\":\"42\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_adata_reg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"230\",\"y\":\"84\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"297\",\"y\":\"85\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"297\",\"y\":\"42\",\"zindex\":\"6\"},{\"anchor\":\"top-center\",\"h\":\"45\",\"layout_steps_values\":{},\"name\":\"Radio_OrderBy\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"230\",\"x\":\"162\",\"y\":\"340\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stampa Distinta Lire\\u002fEuro\",\"layout_steps_values\":{},\"name\":\"Stp_dist_lire_euro\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"195\",\"x\":\"572\",\"y\":\"406\",\"zindex\":\"18\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_ordinamento\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stampa ordinata per:\",\"w\":\"480\",\"x\":\"29\",\"y\":\"316\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Radio_Tipo_Operaz\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"314\",\"x\":\"227\",\"y\":\"232\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Senza dipendenza (con Intermediario)\",\"layout_steps_values\":{},\"name\":\"Senza_dip\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"188\",\"x\":\"99\",\"y\":\"411\",\"zindex\":\"18\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Tipo_Oper\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo di Operazione:\",\"w\":\"138\",\"x\":\"79\",\"y\":\"232\",\"zindex\":\"17\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Solo operazioni attive\",\"layout_steps_values\":{},\"name\":\"Solo_attive\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"170\",\"x\":\"573\",\"y\":\"433\",\"zindex\":\"18\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"stato_operazione\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stato Operazione:\",\"w\":\"138\",\"x\":\"79\",\"y\":\"259\",\"zindex\":\"17\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Radio_Tipo_Stampa\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"314\",\"x\":\"227\",\"y\":\"286\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Solo con presenza di contanti\",\"layout_steps_values\":{},\"name\":\"Con_Contanti\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"195\",\"x\":\"307\",\"y\":\"411\",\"zindex\":\"18\"},{\"anchor\":\"top-center\",\"h\":\"66\",\"layout_steps_values\":{},\"name\":\"Radio_TitEssere\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"495\",\"x\":\"25\",\"y\":\"128\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_intestatario\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"131\",\"x\":\"79\",\"y\":\"200\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_intestatario\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"213\",\"y\":\"200\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_desc_intestatario\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"225\",\"x\":\"235\",\"y\":\"200\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_dipendenza\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"131\",\"x\":\"79\",\"y\":\"451\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_dipendenza\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"213\",\"y\":\"451\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_desc_dipendenza\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"225\",\"x\":\"236\",\"y\":\"451\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"80\",\"layout_steps_values\":{},\"name\":\"Box34\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"284\",\"x\":\"126\",\"y\":\"314\",\"zindex\":\"0\"},{\"h\":\"20\",\"name\":\"ambito\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"197\",\"x\":\"551\",\"y\":\"-23\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"ambito\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"ambito definisce la provenienza della chiamata: \\nD = Definitivo\\u002fAUI, \\nP = Provvisorio\",\"w\":\"197\",\"x\":\"551\",\"y\":\"4\",\"zindex\":\"25\"},{\"anchor\":\"\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"Ope_Print\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"540\",\"x\":\"0\",\"y\":\"478\",\"zindex\":\"26\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_informazione_Copy\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"361\",\"y\":\"12\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"tipo_stampa\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo di Stampa:\",\"w\":\"138\",\"x\":\"79\",\"y\":\"286\",\"zindex\":\"17\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stp_ope_fraz_all","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stp_ope_fraz_all_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_stp_ope_fraz_all_portlet > .Stp_dist_lire_euro_ctrl {
  display:none;
}
.pg_stp_ope_fraz_all_portlet > .Solo_attive_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stp_ope_fraz_all','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Radio_Stato_Ope= "";
java.sql.Date Textbox_dadata_ret= JSPLib.NullDate();
if(request.getAttribute("pg_stp_ope_fraz_all_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_stp_ope_fraz_all_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
java.sql.Date Textbox_adata_ret= JSPLib.NullDate();
java.sql.Date Textbox_dadata_ope= JSPLib.NullDate();
String Label_data_Ret= "Data Rettifica";
String Variable_OrderBy= "";
java.sql.Date Textbox_adata_ope= JSPLib.NullDate();
String Label_data_ope= "Data Operazione";
String Label_data_reg= "Data Registrazione";
java.sql.Date Textbox_dadata_reg= JSPLib.NullDate();
java.sql.Date Textbox_adata_reg= JSPLib.NullDate();
String Radio_OrderBy= "";
boolean Stp_dist_lire_euro=false;
String Label_ordinamento= "Stampa ordinata per:";
String Radio_Tipo_Operaz= "";
boolean Senza_dip=false;
String Tipo_Oper= "Tipo di Operazione:";
boolean Solo_attive=false;
String stato_operazione= "Stato Operazione:";
String Radio_Tipo_Stampa= "";
boolean Con_Contanti=false;
String Radio_TitEssere= "";
String Textbox_intestatario= "";
if(request.getAttribute("pg_stp_ope_fraz_all_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Textbox_desc_intestatario= "";
String Textbox_dipendenza= "";
String Textbox_desc_dipendenza= "";
String ambito=JSPLib.translateXSS(sp.getParameter("ambito",""));
String tipo_stampa= "Tipo di Stampa:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stp_ope_fraz_all_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stp_ope_fraz_all_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stp_ope_fraz_all_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stp_ope_fraz_all','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<div id='<%=idPortlet%>_Radio_Stato_Ope' class='radio' style='z-index:1;'></div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_ret_wrp'><input id='<%=idPortlet%>_Textbox_dadata_ret' name='Textbox_dadata_ret' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_ret' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_ret>Da</label></span>
<div id='<%=idPortlet%>_Box_data_informazione' class='Box_data_informazione_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_informazione_td' class='box_content'></div>
</div>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_ret' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_ret.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_adata_ret_wrp'><input id='<%=idPortlet%>_Textbox_adata_ret' name='Textbox_adata_ret' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_adata_ret' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_adata_ret>A</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dadata_ope_wrp'><input id='<%=idPortlet%>_Textbox_dadata_ope' name='Textbox_dadata_ope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dadata_ope' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dadata_ope>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_ret' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_ret.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_ope' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_ope.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label_data_Ret'  formid='<%=idPortlet%>' ps-name='Label_data_Ret'    class='label Label_data_Ret_ctrl'><div id='<%=idPortlet%>_Label_data_Rettbl' style='width:100%;'><%=JSPLib.ToHTML("Data Rettifica")%></div></span>
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
 <div id='<%=idPortlet%>_Radio_OrderBy' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_Stp_dist_lire_euro_div' style=''><input id='<%=idPortlet%>_Stp_dist_lire_euro' name='Stp_dist_lire_euro' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Stp_dist_lire_euro' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(" Stampa Distinta Lire/Euro")%></label></div>
<span id='<%=idPortlet%>_Label_ordinamento'  formid='<%=idPortlet%>' ps-name='Label_ordinamento'    class='label Label_ordinamento_ctrl'><div id='<%=idPortlet%>_Label_ordinamentotbl' style='width:100%;'><%=JSPLib.ToHTML("Stampa ordinata per:")%></div></span>
<div id='<%=idPortlet%>_Radio_Tipo_Operaz' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_Senza_dip_div' style=''><input id='<%=idPortlet%>_Senza_dip' name='Senza_dip' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Senza_dip' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(" Senza dipendenza (con Intermediario)")%></label></div>
<span id='<%=idPortlet%>_Tipo_Oper'  formid='<%=idPortlet%>' ps-name='Tipo_Oper'    class='label Tipo_Oper_ctrl'><div id='<%=idPortlet%>_Tipo_Opertbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo di Operazione:")%></div></span>
<div id='<%=idPortlet%>_Solo_attive_div' style=''><input id='<%=idPortlet%>_Solo_attive' name='Solo_attive' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Solo_attive' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(" Solo operazioni attive")%></label></div>
<span id='<%=idPortlet%>_stato_operazione'  formid='<%=idPortlet%>' ps-name='stato_operazione'    class='label stato_operazione_ctrl'><div id='<%=idPortlet%>_stato_operazionetbl' style='width:100%;'><%=JSPLib.ToHTML("Stato Operazione:")%></div></span>
<div id='<%=idPortlet%>_Radio_Tipo_Stampa' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_Con_Contanti_div' style=''><input id='<%=idPortlet%>_Con_Contanti' name='Con_Contanti' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_Con_Contanti' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(" Solo con presenza di contanti")%></label></div>
<div id='<%=idPortlet%>_Radio_TitEssere' class='radio' style='z-index:1;'></div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_intestatario_wrp'><input id='<%=idPortlet%>_Textbox_intestatario' name='Textbox_intestatario' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_intestatario' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_intestatario>Intestatario</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_intestatario'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_desc_intestatario_wrp'><input id='<%=idPortlet%>_Textbox_desc_intestatario' name='Textbox_desc_intestatario' type='text' disabled maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_desc_intestatario' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_dipendenza_wrp'><input id='<%=idPortlet%>_Textbox_dipendenza' name='Textbox_dipendenza' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_dipendenza' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_dipendenza>Dipendenza</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_dipendenza'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_desc_dipendenza_wrp'><input id='<%=idPortlet%>_Textbox_desc_dipendenza' name='Textbox_desc_dipendenza' type='text' disabled maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_desc_dipendenza' /></span>
<div id='<%=idPortlet%>_Box34' class='Box34_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box34_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_Ope_Print_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_Box_data_informazione_Copy' class='Box_data_informazione_Copy_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_informazione_Copy_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_tipo_stampa'  formid='<%=idPortlet%>' ps-name='tipo_stampa'    class='label tipo_stampa_ctrl'><div id='<%=idPortlet%>_tipo_stampatbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo di Stampa:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stp_ope_fraz_all');
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
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa le anagrafiche dei soggetti",true)+","+JSPLib.ToJSValue(sp.translate("Stampa le anagrafiche dei soggetti"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stp_ope_fraz_all',["540"],["720"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"540","h":"720","title":"Stampa con Dettaglio","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":540,"x":0,"y":630,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.Radio_Stato_Ope=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"'T'","captionsList":"Tutte,Solo Attive,Solo Cancellate,Solo vecchia copia di modifica","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_Stato_Ope","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":20,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_Stato_Ope","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"T,A,C,M","visible":true,"w":314,"x":227,"y":259,"zindex":"16"});
this.Textbox_dadata_ret=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_ret","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_ret","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_ret%>","w":60,"x":381,"y":41,"zerofilling":false,"zindex":"5","zoom":""});
this.Box_data_informazione=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_informazione","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_informazione","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":123,"x":57,"y":12,"zindex":"2"});
this.Calendario_dadata_ret=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_ret','Calendario_dadata_ret',446,41,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_ret',{});
this.SPLinker_arrp_stpoper_sa=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_stp_ope_fraz_all",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_arrp_stpoper_sa","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_arrp_stpoper_sa","offline":false,"page":1,"parms":"w_DaDatOpe=Textbox_dadata_ope,w_ADatOpe=Textbox_adata_ope,w_DaDatReg=Textbox_dadata_reg,w_EstrazTitEffNelPeriodo=Radio_TitEssere,w_OrderBy=Variable_OrderBy,w_CONNES=Textbox_intestatario,w_TipoOpeStampa=Radio_Tipo_Operaz,w_TipoStampa=Radio_Tipo_Stampa,w_Stp_dist_lire_euro=Stp_dist_lire_euro,w_Con_Contanti=Con_Contanti,w_Solo_attive=Solo_attive,w_Senza_dip=Senza_dip,w_Dipendenza=Textbox_dipendenza,w_ADatReg=Textbox_adata_reg,w_Ambito=ambito,w_DaDatRet=Textbox_dadata_ret,w_ADatRet=Textbox_adata_ret,w_Stato=Radio_Stato_Ope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_stp_ope_fraz_all","target":"Ope_Print","type":"SPLinker","w":197,"x":552,"y":-50});
this.SPLinker_arrp_stpoper_sa.m_cID='<%=JSPLib.cmdHash("routine,arrt_stp_ope_fraz_all",request.getSession())%>';
this.Textbox_adata_ret=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_ret","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_ret","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_ret%>","w":60,"x":381,"y":84,"zerofilling":false,"zindex":"5","zoom":""});
this.Textbox_dadata_ope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_ope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_ope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_ope%>","w":60,"x":77,"y":41,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_ret=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_ret','Calendario_adata_ret',446,84,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_ret',{});
this.Calendario_dadata_ope=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_ope','Calendario_dadata_ope',142,41,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_ope',{});
this.Label_data_Ret=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_Ret","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_Ret","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_Ret,false,true)%>","type":"Label","w":123,"x":361,"y":13,"zindex":"22"});
this.Variable_OrderBy=new ZtVWeb._VC(this,'Variable_OrderBy',null,'character','<%=JSPLib.ToJSValue(Variable_OrderBy,false,true)%>',false,false);
this.Textbox_adata_ope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_ope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_ope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_ope%>","w":60,"x":77,"y":84,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_ope=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_ope','Calendario_adata_ope',142,84,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_ope',{});
this.Label_data_ope=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_ope","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_ope","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_ope,false,true)%>","type":"Label","w":123,"x":57,"y":13,"zindex":"22"});
this.Label_data_reg=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_reg","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_reg","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_reg,false,true)%>","type":"Label","w":123,"x":208,"y":13,"zindex":"23"});
this.Box_data_reg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_reg","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_reg","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":123,"x":208,"y":12,"zindex":"2"});
this.Textbox_dadata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dadata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_dadata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_dadata_reg%>","w":60,"x":230,"y":42,"zerofilling":false,"zindex":"5","zoom":""});
this.Textbox_adata_reg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_adata_reg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_adata_reg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_adata_reg%>","w":60,"x":230,"y":84,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_reg','Calendario_adata_reg',297,85,20,20,'','','top-left(%)-right(%)','true','Textbox_adata_reg',{});
this.Calendario_dadata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_reg','Calendario_dadata_reg',297,42,20,20,'','','top-left(%)-right(%)','true','Textbox_dadata_reg',{});
this.Radio_OrderBy=new ZtVWeb.RadioCtrl(this,{"anchor":"top-center","calculate":"'D'","captionsList":"Data Registraz. N. Progressivo,N. Progressivo Data Registraz.","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_OrderBy","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":45,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_OrderBy","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,N","visible":true,"w":230,"x":162,"y":340,"zindex":"12"});
this.Stp_dist_lire_euro=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Stp_dist_lire_euro","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"true","hide_undercond":"","init":"","init_par":"false","label_text":" Stampa Distinta Lire\u002fEuro","layer":false,"layout_steps_values":{},"name":"Stp_dist_lire_euro","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"standard","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":195,"x":572,"y":406,"zindex":"18"});
this.Stp_dist_lire_euro.Value(<%=Stp_dist_lire_euro%>);
this.Label_ordinamento=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_ordinamento","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_ordinamento","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_ordinamento,false,true)%>","type":"Label","w":480,"x":29,"y":316,"zindex":"11"});
this.Radio_Tipo_Operaz=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"'O'","captionsList":"Operazioni,Frazionate,Entrambe","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_Tipo_Operaz","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":20,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_Tipo_Operaz","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"O,F,E","visible":true,"w":314,"x":227,"y":232,"zindex":"16"});
this.Senza_dip=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Senza_dip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":" Senza dipendenza (con Intermediario)","layer":false,"layout_steps_values":{},"name":"Senza_dip","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":188,"x":99,"y":411,"zindex":"18"});
this.Senza_dip.Value(<%=Senza_dip%>);
this.Tipo_Oper=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Tipo_Oper","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Tipo_Oper","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Tipo_Oper,false,true)%>","type":"Label","w":138,"x":79,"y":232,"zindex":"17"});
this.Solo_attive=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Solo_attive","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"true","hide_undercond":"","init":"","init_par":"false","label_text":" Solo operazioni attive","layer":false,"layout_steps_values":{},"name":"Solo_attive","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":170,"x":573,"y":433,"zindex":"18"});
this.Solo_attive.Value(<%=Solo_attive%>);
this.stato_operazione=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_stato_operazione","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"stato_operazione","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(stato_operazione,false,true)%>","type":"Label","w":138,"x":79,"y":259,"zindex":"17"});
this.Radio_Tipo_Stampa=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"'S'","captionsList":"Dettaglio Anagrafico,Analitica,Sintetica","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_Tipo_Stampa","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":20,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_Tipo_Stampa","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,A,S","visible":true,"w":314,"x":227,"y":286,"zindex":"16"});
this.Con_Contanti=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Con_Contanti","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":" Solo con presenza di contanti","layer":false,"layout_steps_values":{},"name":"Con_Contanti","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":195,"x":307,"y":411,"zindex":"18"});
this.Con_Contanti.Value(<%=Con_Contanti%>);
this.Radio_TitEssere=new ZtVWeb.RadioCtrl(this,{"anchor":"top-center","calculate":"'S'","captionsList":"Estrazione solo dei Titolari Effettivi in essere nel periodo di date scelto,Estrazione dei Titolari Effettivi SENZA filtro per periodo di date scelto,Estrazione solo dei titolari effetti collegati direttamente all'operazione","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_TitEssere","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":66,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_TitEssere","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"S,N,X","visible":true,"w":495,"x":25,"y":128,"zindex":"10"});
this.Textbox_intestatario=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_intestatario","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"Textbox_intestatario","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_intestatario,false,true)%>","w":131,"x":79,"y":200,"zerofilling":false,"zindex":"13","zoom":""});
this.LinkZoom_intestatario=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_intestatario","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_ope_fraz_all_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"Textbox_intestatario,Textbox_desc_intestatario","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_ope_fraz_all_portlet.jspLinkZoom_intestatario",request.getSession())%>","linkedField":"Textbox_intestatario","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_intestatario","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":213,"y":200,"zindex":"14","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_desc_intestatario=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_desc_intestatario","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"30","name":"Textbox_desc_intestatario","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_desc_intestatario,false,true)%>","w":225,"x":235,"y":200,"zerofilling":false,"zindex":"15","zoom":""});
this.Textbox_dipendenza=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_dipendenza","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"Textbox_dipendenza","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_dipendenza,false,true)%>","w":131,"x":79,"y":451,"zerofilling":false,"zindex":"13","zoom":""});
this.LinkZoom_dipendenza=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_dipendenza","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_ope_fraz_all_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"Textbox_dipendenza,Textbox_desc_dipendenza","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_ope_fraz_all_portlet.jspLinkZoom_dipendenza",request.getSession())%>","linkedField":"Textbox_dipendenza","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_dipendenza","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":213,"y":451,"zindex":"14","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_desc_dipendenza=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_desc_dipendenza","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"30","name":"Textbox_desc_dipendenza","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_desc_dipendenza,false,true)%>","w":225,"x":236,"y":451,"zerofilling":false,"zindex":"15","zoom":""});
this.Box34=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box34","groupName":"","h":80,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box34","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":284,"x":126,"y":314,"zindex":"0"});
this.ambito=new ZtVWeb._VC(this,'ambito',null,'character','<%=JSPLib.ToJSValue(ambito,false,true)%>',false,false);
this.Ope_Print=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_Ope_Print","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"Ope_Print","name_iframe":"Ope_Print","page":1,"spuid":"","type":"Iframe","w":540,"x":0,"y":478,"zindex":"26"});
this.Box_data_informazione_Copy=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_informazione_Copy","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_informazione_Copy","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":123,"x":361,"y":12,"zindex":"2"});
this.tipo_stampa=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_tipo_stampa","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"tipo_stampa","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(tipo_stampa,false,true)%>","type":"Label","w":138,"x":79,"y":286,"zindex":"17"});
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
<%if(request.getAttribute("pg_stp_ope_fraz_all_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stp_ope_fraz_all_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stp_ope_fraz_all_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stp_ope_fraz_all',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stp_ope_fraz_all');
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
sp.endPage("pg_stp_ope_fraz_all");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_intestatario")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 2;
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
<%! public String getJSPUID() { return "995246941"; } %>