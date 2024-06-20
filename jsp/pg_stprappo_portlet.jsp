<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _y=20;\n\nthis.getTitlePortlet().AppendButton({\n  id:\"Stampa\",\n  title:FormatMsg('MSG_VZM_PRINT'),\n  tooltip:FormatMsg('Stampa'),\n  image:{ fontFamily:'icons8_win10', value: \"&#xec0b\"},\n  action:'javascript:' + this.formid +'.gestione_toolbar(\"P\")'\n},3);\nswitch (this.fonte.Value()) {\n  case 'D':\n    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (AUI)',true);\n    this.daRappo_aui.Show();\n    this.aRappo_aui.Show();\n    this.LinkZoom_daRappo_aui.Show();\n    this.LinkZoom_aRappo_aui.Show();\n    break;\n  case 'P':\n    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (Provvisorio)',true);\n    this.daRappo_prov.Show();\n    this.aRappo_prov.Show();\n    this.LinkZoom_daRappo_prov.Show();\n    this.LinkZoom_aRappo_prov.Show();\n    this.daRappo_prov.y=_y;\n    this.daRappo_prov.topposition=_y\n    this.aRappo_prov.y=_y;\n    this.aRappo_prov.topposition=_y;\n    this.LinkZoom_daRappo_prov.y=_y;\n    this.LinkZoom_daRappo_prov.topposition=_y;\n    this.LinkZoom_aRappo_prov.y=_y;\n    this.LinkZoom_aRappo_prov.topposition=_y;\n    break\n  case 'J':\n    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (Agenzia Entrate)',true);\n    this.daRappo_ae.Show();\n    this.aRappo_ae.Show();\n    this.LinkZoom_daRappo_ae.Show();\n    this.LinkZoom_aRappo_ae.Show();\n    this.daRappo_ae.y=_y;\n    this.daRappo_ae.topposition=_y;\n    this.aRappo_ae.y=_y;\n    this.aRappo_ae.topposition=_y;\n    this.LinkZoom_daRappo_ae.y=_y;\n    this.LinkZoom_daRappo_ae.topposition=_y;\n    this.LinkZoom_aRappo_ae.y=_y;\n    this.LinkZoom_aRappo_ae.topposition=_y;\n    break\n  case 'W':\n    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (Storico)',true);\n    this.daRappo_st.Show();\n    this.aRappo_st.Show();\n    this.LinkZoom_daRappo_st.Show();\n    this.LinkZoom_aRappo_st.Show();\n    this.daRappo_st.y=_y;\n    this.daRappo_st.topposition=_y;\n    this.aRappo_st.y=_y;\n    this.aRappo_st.topposition=_y;\n    this.LinkZoom_daRappo_st.y=_y;\n    this.LinkZoom_daRappo_st.topposition=_y;\n    this.LinkZoom_aRappo_st.y=_y;\n    this.LinkZoom_aRappo_st.topposition=_y;\n    break\n}\nthis.detana_onChange();\n\nfunction gestione_toolbar(azione){\n  if(azione=='P'){\n    switch (this.fonte.Value()) {\n      case 'D':\n        this.daRappo.Value(this.daRappo_aui.Value());\n        this.aRappo.Value(this.aRappo_aui.Value());\n        this.SPLinker_arrt_stprappo_all.Link();\n        break\n      case 'P':\n        this.daRappo.Value(this.daRappo_prov.Value());\n        this.aRappo.Value(this.aRappo_prov.Value());\n        this.SPLinker_arrt_stprappo_all.Link();\n        break\n      case 'J':\n        this.daRappo.Value(this.daRappo_ae.Value());\n        this.aRappo.Value(this.aRappo_ae.Value());\n        this.SPLinker_arrt_stprappo_all.Link();\n        break\n      case 'W':\n        this.daRappo.Value(this.daRappo_st.Value());\n        this.aRappo.Value(this.aRappo_st.Value());\n        this.SPLinker_arrt_stprappo_all.Link();\n        break\n    }\n  }\n}\n\nfunction detana_onChange(){\n  var tipo=(Empty(this.tipo.Value())||(!this.detana.Value()&&(this.tipo.Value()=='1'||this.tipo.Value()=='2')))?'T':this.tipo.Value();\n\u002f\u002f   this.tipo.FillDataStatic('Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi'+(this.detana.Value()?'':',Solo i rapporti aperti senza titolari,Solo i rapporti chiusi senza titolari'),'T,A,C'+(this.detana.Value()?'':',1,2'));\n  this.tipo.FillDataStatic('T,A,C'+(!this.detana.Value()?'':',1,2'),'Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi'+(!this.detana.Value()?'':',Solo i rapporti aperti senza titolari,Solo i rapporti chiusi senza titolari'));\n  this.tipo.Value(tipo);\n  this.tipostp.FillDataStatic('X'+(this.detana.Value()?'':',R'),'Excel'+(this.detana.Value()?'':',Report'));\n  this.tipostp.Value('X');\n}\n\nfunction SPLinker_arrt_stprappo_Executed(result,cError){\n  alert(cError);\n  alert(result);\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"570","hsl":"","htmlcode":"{{ @descri_risc }} \n{{ @pRISGLOB }} \n{{ @descri_age }} \n{{ @pTIPOAG }} \n{{ @pTIPOAG{{ @descri_age{{ @pRISGLOB{{ @descri_risc{{ @LinkZoom_aRappo_st }} \n{{ @aRappo_st }} \n{{ @LinkZoom_daRappo_st }} \n{{ @daRappo_st }} \n }} \n{{ @LinkZoom_pRISGLOB }} \n }} \n }} \n{{ @LinkZoom_pTIPOAG }} \n }} \n{{ @LinkZoom_aRappo_aui }} \n{{ @aRappo_aui }} \n{{ @daRappo_aui }} \n{{ @aui }} \n{{ @Box_opzioni }}\n{{ @Label_tipostp }}\n\n{{ @Box_filtri }}\n{{ @tipostp }}\n{{ @pLog }}\n{{ @pMsg }}\n{{ @tipo }}\n{{ @mod_copia }}\n{{ @cancellata }}\n{{ @flgdel }}\n{{ @flgtit }}\n{{ @mod_attiva }}\n{{ @attiva }}\n{{ @detana }}\n{{ @detope }}\n{{ @descdip }}\n{{ @LinkZoom_coddip }}\n{{ @coddip }}\n{{ @AData }}\n{{ @DaData }}\n{{ @aDescSogg }}\n{{ @LinkZoom_ASogg }}\n{{ @ASogg }}\n{{ @daDescSogg }}\n{{ @LinkZoom_DaSogg }}\n{{ @DaSogg }}\n{{ @aDescRap }}\n{{ @daDescRap }}\n{{ @LinkZoom_aRappo_aui{{ @LinkZoom_aRappo_ae }} \n{{ @aRappo_ae }} \n{{ @LinkZoom_daRappo_ae }} \n{{ @daRappo_ae }} \n }}\n{{ @LinkZoom_daRappo_aui }}\n{{ @aRappo }}\n{{ @daRappo_aui{{ @LinkZoom_aRappo_prov }} \n{{ @aRappo_prov }} \n{{ @LinkZoom_daRappo_prov }} \n{{ @daRappo_prov }} \n }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1200","min_w":"1000","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa rapporti","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"640","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"fonte","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"662","y":"22"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daRappo_aui","page":"1","password":"","picture":"","placeholder":"Da Rapporto","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"2","y":"20","zerofilling":"false","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daRappo_prov","page":"1","password":"","picture":"","placeholder":"Da Rapporto","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"2","y":"584","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daRappo_ae","page":"1","password":"","picture":"","placeholder":"Da Rapporto","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"2","y":"608","zerofilling":"false","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"daRappo_aui,daDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"daRappo_aui","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_daRappo_aui","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"5","servlet":"","spuid":"","suggest":"true","table":"anarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"122","y":"20","zindex":"3","zoomtitle":"Rapporti AUI"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daRappo_st","page":"1","password":"","picture":"","placeholder":"Da Rapporto","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"2","y":"632","zerofilling":"false","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"daRappo_prov,daDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"daRappo_prov","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_daRappo_prov","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"7","servlet":"","spuid":"","suggest":"true","table":"xnarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"122","y":"584","zindex":"2","zoomtitle":"Rapporti Provvisorio"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"daRappo_ae,daDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"daRappo_ae","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_daRappo_ae","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"8","servlet":"","spuid":"","suggest":"true","table":"jnarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"122","y":"608","zindex":"2","zoomtitle":"Rapporti Agenzia Entrate"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"daRappo_st,daDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"daRappo_st","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_daRappo_st","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"9","servlet":"","spuid":"","suggest":"true","table":"wnarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"122","y":"632","zindex":"2","zoomtitle":"Rapporti Storico"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aRappo_prov","page":"1","password":"","picture":"","placeholder":"A Rapporto","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"316","y":"584","zerofilling":"false","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daDescRap","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"180","wireframe_props":"name","x":"132","y":"20","zerofilling":"false","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aRappo_aui","page":"1","password":"","picture":"","placeholder":"A Rapporto","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"316","y":"20","zerofilling":"false","zindex":"5"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aRappo_ae","page":"1","password":"","picture":"","placeholder":"A Rapporto","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"316","y":"608","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"aRappo_aui,aDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"aRappo_aui","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_aRappo_aui","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"14","servlet":"","spuid":"","suggest":"true","table":"anarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"436","y":"20","zindex":"6","zoomtitle":"Rapporti AUI"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aRappo_st","page":"1","password":"","picture":"","placeholder":"A Rapporto","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"316","y":"632","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"aRappo_prov,aDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"aRappo_prov","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_aRappo_prov","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"16","servlet":"","spuid":"","suggest":"true","table":"xnarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"436","y":"584","zindex":"5","zoomtitle":"Rapporti Provvisorio"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"aRappo_ae,aDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"aRappo_ae","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_aRappo_ae","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"17","servlet":"","spuid":"","suggest":"true","table":"xnarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"436","y":"608","zindex":"5","zoomtitle":"Rapporti Agenzia Entrate"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"aRappo_st,aDescRap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"aRappo_st","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_aRappo_st","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"18","servlet":"","spuid":"","suggest":"true","table":"xnarapbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"436","y":"632","zindex":"5","zoomtitle":"Rapporti Storico"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aDescRap","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"180","wireframe_props":"name","x":"446","y":"20","zerofilling":"false","zindex":"7"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaSogg","page":"1","password":"","picture":"","placeholder":"Da Soggetto","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"2","y":"60","zerofilling":"false","zindex":"8"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"DaSogg,daDescSogg","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"DaSogg","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_DaSogg","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"21","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"122","y":"60","zindex":"9","zoomtitle":"Soggetti"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daDescSogg","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"22","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"180","wireframe_props":"name","x":"132","y":"60","zerofilling":"false","zindex":"10"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ASogg","page":"1","password":"","picture":"","placeholder":"A Soggetto","readonly":"false","scroll":"false","sequence":"23","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"316","y":"60","zerofilling":"false","zindex":"11"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"ASogg,aDescSogg","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"ASogg","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_ASogg","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"24","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"10","wireframe_props":"","x":"436","y":"60","zindex":"12","zoomtitle":"Soggetti"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aDescSogg","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"180","wireframe_props":"name","x":"446","y":"60","zerofilling":"false","zindex":"13"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"coddip","page":"1","password":"","picture":"","placeholder":"Dipendenza \u002f Agenzia","readonly":"false","scroll":"false","sequence":"26","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"2","y":"100","zerofilling":"false","zindex":"14"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"coddip,descdip","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"coddip","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_coddip","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"27","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"10","wireframe_props":"","x":"122","y":"100","zindex":"15","zoomtitle":"Dipendenza"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descdip","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"28","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"132","y":"100","zerofilling":"false","zindex":"16"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaData","page":"1","password":"","picture":"","placeholder":"A Data Informazione","readonly":"false","scroll":"false","sequence":"29","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"120","wireframe_props":"name","x":"316","y":"100","zerofilling":"false","zindex":"17"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"AData","page":"1","password":"","picture":"","placeholder":"Da Data Informazione","readonly":"false","scroll":"false","sequence":"30","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"120","wireframe_props":"name","x":"440","y":"100","zerofilling":"false","zindex":"18"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"2","name":"pTIPOAG","page":"1","password":"","picture":"","placeholder":"Tipo rapporto AE","readonly":"false","scroll":"false","sequence":"31","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"64","wireframe_props":"name","x":"2","y":"140","zerofilling":"false","zindex":"19"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"pTIPOAG,descri_age","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"pTIPOAG","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_pTIPOAG","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"32","servlet":"","spuid":"","suggest":"true","table":"tbrapp","type":"LinkZoom","w":"10","wireframe_props":"","x":"66","y":"140","zindex":"20","zoomtitle":"Tipo agenzia entrate"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descri_age","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"33","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"237","wireframe_props":"name","x":"76","y":"140","zerofilling":"false","zindex":"21"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"pRISGLOB","page":"1","password":"","picture":"","placeholder":"Rischio Globale","readonly":"false","scroll":"false","sequence":"34","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"64","wireframe_props":"name","x":"316","y":"140","zerofilling":"false","zindex":"22"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"pRISGLOB,descri_risc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"pRISGLOB","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom_pRISGLOB","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"35","servlet":"","spuid":"","suggest":"true","table":"tbrisglob","type":"LinkZoom","w":"10","wireframe_props":"","x":"380","y":"140","zindex":"23","zoomtitle":"Rischio Globale"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descri_risc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"36","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"236","wireframe_props":"name","x":"390","y":"140","zerofilling":"false","zindex":"24"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"Stampa con dettaglio informazioni","layer":"false","layout_steps_values":"{}","name":"detope","page":"1","sequence":"37","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"160","wireframe_props":"label_text","x":"2","y":"182","zindex":"25"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"Dettaglio anagrafico (Solo Excel)","layer":"false","layout_steps_values":"{}","name":"detana","page":"1","sequence":"38","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"160","wireframe_props":"label_text","x":"2","y":"209","zindex":"26"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"not(detana)","init":"","init_par":"false","label_text":"Stampa Titolari Effettivi","layer":"false","layout_steps_values":"{}","name":"flgtit","page":"1","sequence":"39","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"160","wireframe_props":"label_text","x":"2","y":"235","zindex":"27"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"not(detana)","init":"","init_par":"false","label_text":"Stampa Delegati","layer":"false","layout_steps_values":"{}","name":"flgdel","page":"1","sequence":"40","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"160","wireframe_props":"label_text","x":"2","y":"261","zindex":"28"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"fonte\u003c\u003e'D'","init":"","init_par":"true","label_text":"0 - Registrazione attiva","layer":"false","layout_steps_values":"{}","name":"attiva","page":"1","sequence":"41","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"176","wireframe_props":"label_text","x":"164","y":"182","zindex":"29"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"fonte\u003c\u003e'D'","init":"","init_par":"true","label_text":"1 - Registrazione derivante da modifica","layer":"false","layout_steps_values":"{}","name":"mod_attiva","page":"1","sequence":"42","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"176","wireframe_props":"label_text","x":"164","y":"209","zindex":"30"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"fonte\u003c\u003e'D'","init":"","init_par":"true","label_text":"2 - Copia di registrazione cancellata","layer":"false","layout_steps_values":"{}","name":"cancellata","page":"1","sequence":"43","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"176","wireframe_props":"label_text","x":"164","y":"235","zindex":"31"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"fonte\u003c\u003e'D'","init":"","init_par":"true","label_text":"3 - Copia di registrazione modificata","layer":"false","layout_steps_values":"{}","name":"mod_copia","page":"1","sequence":"44","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"176","wireframe_props":"label_text","x":"164","y":"261","zindex":"32"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","font":"","font_size":"","h":"104","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"T","layer":"false","layout_steps_values":"{}","name":"tipo","orientation":"vertical","page":"1","picture":"","sequence":"45","spuid":"","tabindex":"","textlist":"Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi","type":"Radio","typevar":"character","valuelist":"T,A,C","visible":"true","w":"150","wireframe_props":"","x":"342","y":"182","zindex":"33"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"not(detana) $|$$|$ fonte\u003c\u003e'J'","init":"","init_par":"true","label_text":"Includi Titolari dell'AUI","layer":"false","layout_steps_values":"{}","name":"aui","page":"1","sequence":"46","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"119","wireframe_props":"label_text","x":"492","y":"182","zindex":"34"},{"align":"","anchor":"","assoc_input":"tipostp","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_tipostp","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"47","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo di stampa:","w":"56","wireframe_props":"align,value,n_col","x":"266","y":"310","zindex":"29"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","font":"","font_size":"","h":"30","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipostp","orientation":"horizontal","page":"1","picture":"","sequence":"48","spuid":"","tabindex":"","textlist":"Excel,Report","type":"Radio","typevar":"character","valuelist":"X,R","visible":"true","w":"124","wireframe_props":"","x":"323","y":"310","zindex":"36"},{"anchor":"","bg_color":"","border_color":"#BDBDBD","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"0","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_filtri","page":"1","sequence":"49","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"580","wireframe_props":"","x":"40","y":"170","zindex":"37"},{"anchor":"","bg_color":"","border_color":"#BDBDBD","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"0","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_opzioni","page":"1","sequence":"50","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"580","wireframe_props":"","x":"40","y":"300","zindex":"38"},{"anchor":"","ctrlOfVariant":"","h":"74","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"51","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"640","wireframe_props":"","x":"0","y":"352","zindex":"39"},{"anchor":"top-left-right(%)-bottom","ctrlOfVariant":"","h":"143","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"52","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"640","wireframe_props":"","x":"0","y":"427","zindex":"40"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"daRappo","page":"1","reactive":"","sequence":"53","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"662","y":"45"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"aRappo","page":"1","reactive":"","sequence":"54","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"662","y":"68"},{"allowedentities":"arrt_stprappo_all","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPLinker_arrt_stprappo_all","offline":"false","page":"1","parms":"fonte,tipostp,daRappo,aRappo,DaSogg,aSogg,coddip,DaData,AData,detope,detana,flgtit,flgdel,tipo,attiva,mod_attiva,cancellata,mod_copia,aui,pTIPOAG,pRISGLOB","popup":"true","popup_height":"","popup_maximized":"by skin","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"55","servlet":"arrt_stprappo_all","target":"","type":"SPLinker","w":"178","x":"662","y":"91"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:fonte*/%>
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
window.pg_stprappo_Static=function(){
if(typeof gestione_toolbar !='undefined')this.gestione_toolbar=gestione_toolbar;
if(typeof detana_onChange !='undefined')this.detana_onChange=detana_onChange;
if(typeof SPLinker_arrt_stprappo_Executed !='undefined')this.SPLinker_arrt_stprappo_Executed=SPLinker_arrt_stprappo_Executed;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(!(this.detana.Value()),this.flgtit);
ZtVWeb.HideCtrl(!(this.detana.Value()),this.flgdel);
ZtVWeb.HideCtrl(Ne(this.fonte.Value(),'D'),this.attiva);
ZtVWeb.HideCtrl(Ne(this.fonte.Value(),'D'),this.mod_attiva);
ZtVWeb.HideCtrl(Ne(this.fonte.Value(),'D'),this.cancellata);
ZtVWeb.HideCtrl(Ne(this.fonte.Value(),'D'),this.mod_copia);
ZtVWeb.HideCtrl(!(this.detana.Value()) || Ne(this.fonte.Value(),'J'),this.aui);
}
this.LinkZoom_daRappo_aui.addObserverFixedVars();
this.LinkZoom_daRappo_prov.addObserverFixedVars();
this.LinkZoom_daRappo_ae.addObserverFixedVars();
this.LinkZoom_daRappo_st.addObserverFixedVars();
this.LinkZoom_aRappo_aui.addObserverFixedVars();
this.LinkZoom_aRappo_prov.addObserverFixedVars();
this.LinkZoom_aRappo_ae.addObserverFixedVars();
this.LinkZoom_aRappo_st.addObserverFixedVars();
this.LinkZoom_DaSogg.addObserverFixedVars();
this.LinkZoom_ASogg.addObserverFixedVars();
this.LinkZoom_coddip.addObserverFixedVars();
this.LinkZoom_pTIPOAG.addObserverFixedVars();
this.LinkZoom_pRISGLOB.addObserverFixedVars();
var _y=20;
this.getTitlePortlet().AppendButton({
  id:"Stampa",
  title:FormatMsg('MSG_VZM_PRINT'),
  tooltip:FormatMsg('Stampa'),
  image:{ fontFamily:'icons8_win10', value: "&#xec0b"},
  action:'javascript:' + this.formid +'.gestione_toolbar("P")'
},3);
switch (this.fonte.Value()) {
  case 'D':
    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (AUI)',true);
    this.daRappo_aui.Show();
    this.aRappo_aui.Show();
    this.LinkZoom_daRappo_aui.Show();
    this.LinkZoom_aRappo_aui.Show();
    break;
  case 'P':
    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (Provvisorio)',true);
    this.daRappo_prov.Show();
    this.aRappo_prov.Show();
    this.LinkZoom_daRappo_prov.Show();
    this.LinkZoom_aRappo_prov.Show();
    this.daRappo_prov.y=_y;
    this.daRappo_prov.topposition=_y
    this.aRappo_prov.y=_y;
    this.aRappo_prov.topposition=_y;
    this.LinkZoom_daRappo_prov.y=_y;
    this.LinkZoom_daRappo_prov.topposition=_y;
    this.LinkZoom_aRappo_prov.y=_y;
    this.LinkZoom_aRappo_prov.topposition=_y;
    break
  case 'J':
    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (Agenzia Entrate)',true);
    this.daRappo_ae.Show();
    this.aRappo_ae.Show();
    this.LinkZoom_daRappo_ae.Show();
    this.LinkZoom_aRappo_ae.Show();
    this.daRappo_ae.y=_y;
    this.daRappo_ae.topposition=_y;
    this.aRappo_ae.y=_y;
    this.aRappo_ae.topposition=_y;
    this.LinkZoom_daRappo_ae.y=_y;
    this.LinkZoom_daRappo_ae.topposition=_y;
    this.LinkZoom_aRappo_ae.y=_y;
    this.LinkZoom_aRappo_ae.topposition=_y;
    break
  case 'W':
    this.getTitlePortlet().SetTitle('Stampa Rapporti Continuativi (Storico)',true);
    this.daRappo_st.Show();
    this.aRappo_st.Show();
    this.LinkZoom_daRappo_st.Show();
    this.LinkZoom_aRappo_st.Show();
    this.daRappo_st.y=_y;
    this.daRappo_st.topposition=_y;
    this.aRappo_st.y=_y;
    this.aRappo_st.topposition=_y;
    this.LinkZoom_daRappo_st.y=_y;
    this.LinkZoom_daRappo_st.topposition=_y;
    this.LinkZoom_aRappo_st.y=_y;
    this.LinkZoom_aRappo_st.topposition=_y;
    break
}
this.detana_onChange();
function gestione_toolbar(azione){
  if(azione=='P'){
    switch (this.fonte.Value()) {
      case 'D':
        this.daRappo.Value(this.daRappo_aui.Value());
        this.aRappo.Value(this.aRappo_aui.Value());
        this.SPLinker_arrt_stprappo_all.Link();
        break
      case 'P':
        this.daRappo.Value(this.daRappo_prov.Value());
        this.aRappo.Value(this.aRappo_prov.Value());
        this.SPLinker_arrt_stprappo_all.Link();
        break
      case 'J':
        this.daRappo.Value(this.daRappo_ae.Value());
        this.aRappo.Value(this.aRappo_ae.Value());
        this.SPLinker_arrt_stprappo_all.Link();
        break
      case 'W':
        this.daRappo.Value(this.daRappo_st.Value());
        this.aRappo.Value(this.aRappo_st.Value());
        this.SPLinker_arrt_stprappo_all.Link();
        break
    }
  }
}
function detana_onChange(){
  var tipo=(Empty(this.tipo.Value())||(!this.detana.Value()&&(this.tipo.Value()=='1'||this.tipo.Value()=='2')))?'T':this.tipo.Value();
//   this.tipo.FillDataStatic('Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi'+(this.detana.Value()?'':',Solo i rapporti aperti senza titolari,Solo i rapporti chiusi senza titolari'),'T,A,C'+(this.detana.Value()?'':',1,2'));
  this.tipo.FillDataStatic('T,A,C'+(!this.detana.Value()?'':',1,2'),'Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi'+(!this.detana.Value()?'':',Solo i rapporti aperti senza titolari,Solo i rapporti chiusi senza titolari'));
  this.tipo.Value(tipo);
  this.tipostp.FillDataStatic('X'+(this.detana.Value()?'':',R'),'Excel'+(this.detana.Value()?'':',Report'));
  this.tipostp.Value('X');
}
function SPLinker_arrt_stprappo_Executed(result,cError){
  alert(cError);
  alert(result);
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
.pg_stprappo_container {
  height:100%;
  overflow:auto;
}
.pg_stprappo_title_container {
  margin: auto;
}
.pg_stprappo_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1200px;
  min-width:1000px;
  height:100%;
  background-color:#F3F3F3;
}
.pg_stprappo_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_stprappo_portlet > .daRappo_aui_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:20px;
  left:2px;
  left:0.3125%;
  right:518px;
  right:80.9375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .daRappo_aui_ctrl {
}
.pg_stprappo_portlet > .daRappo_aui_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .daRappo_prov_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:584px;
  left:2px;
  left:0.3125%;
  right:518px;
  right:80.9375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .daRappo_prov_ctrl {
}
.pg_stprappo_portlet > .daRappo_prov_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .daRappo_ae_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:608px;
  left:2px;
  left:0.3125%;
  right:518px;
  right:80.9375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .daRappo_ae_ctrl {
}
.pg_stprappo_portlet > .daRappo_ae_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_aui_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:20px;
  left:122px;
  left:19.0625%;
  right:508px;
  right:79.375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .daRappo_st_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:632px;
  left:2px;
  left:0.3125%;
  right:518px;
  right:80.9375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .daRappo_st_ctrl {
}
.pg_stprappo_portlet > .daRappo_st_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_prov_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:584px;
  left:122px;
  left:19.0625%;
  right:508px;
  right:79.375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_ae_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:608px;
  left:122px;
  left:19.0625%;
  right:508px;
  right:79.375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_st_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:632px;
  left:122px;
  left:19.0625%;
  right:508px;
  right:79.375%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aRappo_prov_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:584px;
  left:316px;
  left:49.375%;
  right:204px;
  right:31.875%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aRappo_prov_ctrl {
}
.pg_stprappo_portlet > .aRappo_prov_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .daDescRap_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:20px;
  left:132px;
  left:20.625%;
  right:328px;
  right:51.25%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .daDescRap_ctrl {
}
.pg_stprappo_portlet > .daDescRap_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .aRappo_aui_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:20px;
  left:316px;
  left:49.375%;
  right:204px;
  right:31.875%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aRappo_aui_ctrl {
}
.pg_stprappo_portlet > .aRappo_aui_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .aRappo_ae_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:608px;
  left:316px;
  left:49.375%;
  right:204px;
  right:31.875%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aRappo_ae_ctrl {
}
.pg_stprappo_portlet > .aRappo_ae_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_aui_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:20px;
  left:436px;
  left:68.125%;
  right:194px;
  right:30.3125%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aRappo_st_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:632px;
  left:316px;
  left:49.375%;
  right:204px;
  right:31.875%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aRappo_st_ctrl {
}
.pg_stprappo_portlet > .aRappo_st_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_prov_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:584px;
  left:436px;
  left:68.125%;
  right:194px;
  right:30.3125%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_ae_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:608px;
  left:436px;
  left:68.125%;
  right:194px;
  right:30.3125%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_st_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:632px;
  left:436px;
  left:68.125%;
  right:194px;
  right:30.3125%;
  width:auto;
  height:20px;
  display:none;
}
.pg_stprappo_portlet > .aDescRap_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:20px;
  left:446px;
  left:69.6875%;
  right:14px;
  right:2.1875%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .aDescRap_ctrl {
}
.pg_stprappo_portlet > .aDescRap_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .DaSogg_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:60px;
  left:2px;
  left:0.3125%;
  right:518px;
  right:80.9375%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .DaSogg_ctrl {
}
.pg_stprappo_portlet > .DaSogg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_DaSogg_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:60px;
  left:122px;
  left:19.0625%;
  right:508px;
  right:79.375%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .daDescSogg_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:60px;
  left:132px;
  left:20.625%;
  right:328px;
  right:51.25%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .daDescSogg_ctrl {
}
.pg_stprappo_portlet > .daDescSogg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .ASogg_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:60px;
  left:316px;
  left:49.375%;
  right:204px;
  right:31.875%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .ASogg_ctrl {
}
.pg_stprappo_portlet > .ASogg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_ASogg_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:60px;
  left:436px;
  left:68.125%;
  right:194px;
  right:30.3125%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .aDescSogg_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:60px;
  left:446px;
  left:69.6875%;
  right:14px;
  right:2.1875%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .aDescSogg_ctrl {
}
.pg_stprappo_portlet > .aDescSogg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .coddip_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:100px;
  left:2px;
  left:0.3125%;
  right:518px;
  right:80.9375%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .coddip_ctrl {
}
.pg_stprappo_portlet > .coddip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_coddip_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:100px;
  left:122px;
  left:19.0625%;
  right:508px;
  right:79.375%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .descdip_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:100px;
  left:132px;
  left:20.625%;
  right:388px;
  right:60.625%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .descdip_ctrl {
}
.pg_stprappo_portlet > .descdip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .DaData_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:100px;
  left:316px;
  left:49.375%;
  right:204px;
  right:31.875%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .DaData_ctrl {
}
.pg_stprappo_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .AData_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:100px;
  left:440px;
  left:68.75%;
  right:80px;
  right:12.5%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .AData_ctrl {
}
.pg_stprappo_portlet > .AData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .pTIPOAG_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:140px;
  left:2px;
  left:0.3125%;
  right:574px;
  right:89.6875%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .pTIPOAG_ctrl {
}
.pg_stprappo_portlet > .pTIPOAG_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_pTIPOAG_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:140px;
  left:66px;
  left:10.3125%;
  right:564px;
  right:88.125%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .descri_age_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:140px;
  left:76px;
  left:11.875%;
  right:327px;
  right:51.09375%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .descri_age_ctrl {
}
.pg_stprappo_portlet > .descri_age_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .pRISGLOB_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:140px;
  left:316px;
  left:49.375%;
  right:260px;
  right:40.625%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .pRISGLOB_ctrl {
}
.pg_stprappo_portlet > .pRISGLOB_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .LinkZoom_pRISGLOB_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:140px;
  left:380px;
  left:59.375%;
  right:250px;
  right:39.0625%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .descri_risc_ctrl {
  box-sizing:border-box;
  z-index:24;
  position:absolute;
  display:inline-block;
  top:140px;
  left:390px;
  left:60.9375%;
  right:14px;
  right:2.1875%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .descri_risc_ctrl {
}
.pg_stprappo_portlet > .descri_risc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stprappo_portlet > .detope_ctrl {
  box-sizing:border-box;
  z-index:25;
  position:absolute;
  display:inline-block;
  top:182px;
  left:2px;
  left:0.3125%;
  right:478px;
  right:74.6875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .detana_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:209px;
  left:2px;
  left:0.3125%;
  right:478px;
  right:74.6875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .flgtit_ctrl {
  box-sizing:border-box;
  z-index:27;
  position:absolute;
  display:inline-block;
  top:235px;
  left:2px;
  left:0.3125%;
  right:478px;
  right:74.6875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .flgdel_ctrl {
  box-sizing:border-box;
  z-index:28;
  position:absolute;
  display:inline-block;
  top:261px;
  left:2px;
  left:0.3125%;
  right:478px;
  right:74.6875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .attiva_ctrl {
  box-sizing:border-box;
  z-index:29;
  position:absolute;
  display:inline-block;
  top:182px;
  left:164px;
  left:25.625%;
  right:300px;
  right:46.875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .mod_attiva_ctrl {
  box-sizing:border-box;
  z-index:30;
  position:absolute;
  display:inline-block;
  top:209px;
  left:164px;
  left:25.625%;
  right:300px;
  right:46.875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .cancellata_ctrl {
  box-sizing:border-box;
  z-index:31;
  position:absolute;
  display:inline-block;
  top:235px;
  left:164px;
  left:25.625%;
  right:300px;
  right:46.875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .mod_copia_ctrl {
  box-sizing:border-box;
  z-index:32;
  position:absolute;
  display:inline-block;
  top:261px;
  left:164px;
  left:25.625%;
  right:300px;
  right:46.875%;
  width:auto;
  height:25px;
}
.pg_stprappo_portlet > .tipo_ctrl {
  box-sizing:border-box;
  z-index:33;
  position:absolute;
  display:inline-block;
  top:182px;
  left:342px;
  left:53.4375%;
  right:148px;
  right:23.125%;
  width:auto;
  height:104px;
  height:auto;
  min-height:104px;
}
.pg_stprappo_portlet > .aui_ctrl {
  box-sizing:border-box;
  z-index:34;
  position:absolute;
  display:inline-block;
  top:182px;
  left:492px;
  left:76.875%;
  right:29px;
  right:4.53125%;
  width:auto;
  height:20px;
}
.pg_stprappo_portlet > .Label_tipostp_ctrl {
  box-sizing:border-box;
  z-index:29;
  position:absolute;
  display:inline-block;
  top:310px;
  left:266px;
  left:41.5625%;
  right:318px;
  right:49.6875%;
  width:auto;
  height:auto;
  min-height:30px;
}
.pg_stprappo_portlet > .Label_tipostp_ctrl {
  height:auto;
  min-height:30px;
}
.pg_stprappo_portlet > .Label_tipostp_ctrl {
  overflow:hidden;
}
.pg_stprappo_portlet > .tipostp_ctrl {
  box-sizing:border-box;
  z-index:36;
  position:absolute;
  display:inline-block;
  top:310px;
  left:323px;
  left:50.46875%;
  right:193px;
  right:30.15625%;
  width:auto;
  height:30px;
  height:auto;
  min-height:30px;
}
.pg_stprappo_portlet > .Box_filtri_ctrl {
  box-sizing:border-box;
  z-index:37;
  position:absolute;
  display:inline-block;
  top:170px;
  left:40px;
  left:6.25%;
  right:20px;
  right:3.125%;
  width:auto;
  height:auto;
  min-height:0px;
  display:flex;
  flex-direction:column;
}
.pg_stprappo_portlet > .Box_filtri_ctrl {
  height:0px;
}
.pg_stprappo_portlet > .Box_filtri_ctrl > .box_content {
  height:100%;
}
.pg_stprappo_portlet > .Box_filtri_ctrl {
  min-height:0px;
  border-color:#BDBDBD;
}
.pg_stprappo_portlet > .Box_opzioni_ctrl {
  box-sizing:border-box;
  z-index:38;
  position:absolute;
  display:inline-block;
  top:300px;
  left:40px;
  left:6.25%;
  right:20px;
  right:3.125%;
  width:auto;
  height:auto;
  min-height:0px;
  display:flex;
  flex-direction:column;
}
.pg_stprappo_portlet > .Box_opzioni_ctrl {
  height:0px;
}
.pg_stprappo_portlet > .Box_opzioni_ctrl > .box_content {
  height:100%;
}
.pg_stprappo_portlet > .Box_opzioni_ctrl {
  min-height:0px;
  border-color:#BDBDBD;
}
.pg_stprappo_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:39;
  position:absolute;
  display:inline-block;
  top:352px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:74px;
}
.pg_stprappo_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:40;
  position:absolute;
  display:inline-block;
  top:427px;
  left:0px;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
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
 String def="[{\"h\":\"570\",\"layout_steps_values\":{},\"pages_names\":\"Stampa rapporti\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"640\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"662\",\"y\":\"22\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daRappo_aui\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"2\",\"y\":\"20\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daRappo_prov\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"2\",\"y\":\"584\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daRappo_ae\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"2\",\"y\":\"608\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daRappo_aui\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"122\",\"y\":\"20\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daRappo_st\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"2\",\"y\":\"632\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daRappo_prov\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"122\",\"y\":\"584\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daRappo_ae\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"122\",\"y\":\"608\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daRappo_st\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"122\",\"y\":\"632\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aRappo_prov\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"316\",\"y\":\"584\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daDescRap\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"180\",\"x\":\"132\",\"y\":\"20\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aRappo_aui\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"316\",\"y\":\"20\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aRappo_ae\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"316\",\"y\":\"608\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aRappo_aui\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"436\",\"y\":\"20\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aRappo_st\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"316\",\"y\":\"632\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aRappo_prov\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"436\",\"y\":\"584\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aRappo_ae\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"436\",\"y\":\"608\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aRappo_st\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"436\",\"y\":\"632\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aDescRap\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"180\",\"x\":\"446\",\"y\":\"20\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaSogg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"2\",\"y\":\"60\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_DaSogg\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"122\",\"y\":\"60\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daDescSogg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"180\",\"x\":\"132\",\"y\":\"60\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ASogg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"316\",\"y\":\"60\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_ASogg\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"436\",\"y\":\"60\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aDescSogg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"180\",\"x\":\"446\",\"y\":\"60\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"coddip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"2\",\"y\":\"100\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_coddip\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"122\",\"y\":\"100\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descdip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"132\",\"y\":\"100\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"316\",\"y\":\"100\",\"zindex\":\"17\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"AData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"440\",\"y\":\"100\",\"zindex\":\"18\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"pTIPOAG\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"64\",\"x\":\"2\",\"y\":\"140\",\"zindex\":\"19\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_pTIPOAG\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"66\",\"y\":\"140\",\"zindex\":\"20\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descri_age\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"237\",\"x\":\"76\",\"y\":\"140\",\"zindex\":\"21\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"pRISGLOB\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"64\",\"x\":\"316\",\"y\":\"140\",\"zindex\":\"22\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_pRISGLOB\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"10\",\"x\":\"380\",\"y\":\"140\",\"zindex\":\"23\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descri_risc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"236\",\"x\":\"390\",\"y\":\"140\",\"zindex\":\"24\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Stampa con dettaglio informazioni\",\"layout_steps_values\":{},\"name\":\"detope\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"160\",\"x\":\"2\",\"y\":\"182\",\"zindex\":\"25\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Dettaglio anagrafico (Solo Excel)\",\"layout_steps_values\":{},\"name\":\"detana\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"160\",\"x\":\"2\",\"y\":\"209\",\"zindex\":\"26\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Stampa Titolari Effettivi\",\"layout_steps_values\":{},\"name\":\"flgtit\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"160\",\"x\":\"2\",\"y\":\"235\",\"zindex\":\"27\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Stampa Delegati\",\"layout_steps_values\":{},\"name\":\"flgdel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"160\",\"x\":\"2\",\"y\":\"261\",\"zindex\":\"28\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"0 - Registrazione attiva\",\"layout_steps_values\":{},\"name\":\"attiva\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"164\",\"y\":\"182\",\"zindex\":\"29\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"1 - Registrazione derivante da modifica\",\"layout_steps_values\":{},\"name\":\"mod_attiva\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"164\",\"y\":\"209\",\"zindex\":\"30\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"2 - Copia di registrazione cancellata\",\"layout_steps_values\":{},\"name\":\"cancellata\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"164\",\"y\":\"235\",\"zindex\":\"31\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"3 - Copia di registrazione modificata\",\"layout_steps_values\":{},\"name\":\"mod_copia\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"164\",\"y\":\"261\",\"zindex\":\"32\"},{\"anchor\":\"\",\"h\":\"104\",\"layout_steps_values\":{},\"name\":\"tipo\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"150\",\"x\":\"342\",\"y\":\"182\",\"zindex\":\"33\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Includi Titolari dell'AUI\",\"layout_steps_values\":{},\"name\":\"aui\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"119\",\"x\":\"492\",\"y\":\"182\",\"zindex\":\"34\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_tipostp\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo di stampa:\",\"w\":\"56\",\"x\":\"266\",\"y\":\"310\",\"zindex\":\"29\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"tipostp\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"124\",\"x\":\"323\",\"y\":\"310\",\"zindex\":\"36\"},{\"anchor\":\"\",\"h\":\"0\",\"layout_steps_values\":{},\"name\":\"Box_filtri\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"580\",\"x\":\"40\",\"y\":\"170\",\"zindex\":\"37\"},{\"anchor\":\"\",\"h\":\"0\",\"layout_steps_values\":{},\"name\":\"Box_opzioni\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"580\",\"x\":\"40\",\"y\":\"300\",\"zindex\":\"38\"},{\"anchor\":\"\",\"h\":\"74\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"640\",\"x\":\"0\",\"y\":\"352\",\"zindex\":\"39\"},{\"anchor\":\"top-left-right(%)-bottom\",\"h\":\"143\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"640\",\"x\":\"0\",\"y\":\"427\",\"zindex\":\"40\"},{\"h\":\"20\",\"name\":\"daRappo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"662\",\"y\":\"45\"},{\"h\":\"20\",\"name\":\"aRappo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"662\",\"y\":\"68\"},{\"h\":\"20\",\"name\":\"SPLinker_arrt_stprappo_all\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"178\",\"x\":\"662\",\"y\":\"91\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stprappo","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stprappo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_stprappo_portlet > .daRappo_aui_ctrl {
  display:none;
}
.pg_stprappo_portlet > .daRappo_prov_ctrl {
  display:none;
}
.pg_stprappo_portlet > .daRappo_ae_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_aui_ctrl {
  display:none;
}
.pg_stprappo_portlet > .daRappo_st_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_prov_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_ae_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_daRappo_st_ctrl {
  display:none;
}
.pg_stprappo_portlet > .aRappo_prov_ctrl {
  display:none;
}
.pg_stprappo_portlet > .aRappo_aui_ctrl {
  display:none;
}
.pg_stprappo_portlet > .aRappo_ae_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_aui_ctrl {
  display:none;
}
.pg_stprappo_portlet > .aRappo_st_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_prov_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_ae_ctrl {
  display:none;
}
.pg_stprappo_portlet > .LinkZoom_aRappo_st_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stprappo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String fonte=JSPLib.translateXSS(sp.getParameter("fonte",""));
String daRappo_aui= "";
if(request.getAttribute("pg_stprappo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String daRappo_prov= "";
String daRappo_ae= "";
if(request.getAttribute("pg_stprappo_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String daRappo_st= "";
String aRappo_prov= "";
String daDescRap= "";
String aRappo_aui= "";
String aRappo_ae= "";
String aRappo_st= "";
String aDescRap= "";
String DaSogg= "";
String daDescSogg= "";
String ASogg= "";
String aDescSogg= "";
String coddip= "";
String descdip= "";
java.sql.Date DaData= JSPLib.NullDate();
java.sql.Date AData= JSPLib.NullDate();
String pTIPOAG= "";
String descri_age= "";
String pRISGLOB= "";
String descri_risc= "";
boolean detope=false;
boolean detana=false;
boolean flgtit=false;
boolean flgdel=false;
boolean attiva=true;
boolean mod_attiva=true;
boolean cancellata=true;
boolean mod_copia=true;
String tipo="T";
boolean aui=true;
String Label_tipostp= "Tipo di stampa:";
String tipostp= "";
String daRappo= "";
String aRappo= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stprappo_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stprappo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stprappo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stprappo','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_daRappo_aui_wrp'><input id='<%=idPortlet%>_daRappo_aui' name='daRappo_aui' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daRappo_aui' placeholder=' '/>
<label for=<%=idPortlet%>_daRappo_aui>Da Rapporto</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_daRappo_prov_wrp'><input id='<%=idPortlet%>_daRappo_prov' name='daRappo_prov' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daRappo_prov' placeholder=' '/>
<label for=<%=idPortlet%>_daRappo_prov>Da Rapporto</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_daRappo_ae_wrp'><input id='<%=idPortlet%>_daRappo_ae' name='daRappo_ae' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daRappo_ae' placeholder=' '/>
<label for=<%=idPortlet%>_daRappo_ae>Da Rapporto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daRappo_aui'" ) );%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_daRappo_st_wrp'><input id='<%=idPortlet%>_daRappo_st' name='daRappo_st' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daRappo_st' placeholder=' '/>
<label for=<%=idPortlet%>_daRappo_st>Da Rapporto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daRappo_prov'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daRappo_ae'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daRappo_st'" ) );%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_aRappo_prov_wrp'><input id='<%=idPortlet%>_aRappo_prov' name='aRappo_prov' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='aRappo_prov' placeholder=' '/>
<label for=<%=idPortlet%>_aRappo_prov>A Rapporto</label></span>
<span class='textbox-container'id='<%=idPortlet%>_daDescRap_wrp'><input id='<%=idPortlet%>_daDescRap' name='daDescRap' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='daDescRap' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_aRappo_aui_wrp'><input id='<%=idPortlet%>_aRappo_aui' name='aRappo_aui' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='aRappo_aui' placeholder=' '/>
<label for=<%=idPortlet%>_aRappo_aui>A Rapporto</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_aRappo_ae_wrp'><input id='<%=idPortlet%>_aRappo_ae' name='aRappo_ae' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='aRappo_ae' placeholder=' '/>
<label for=<%=idPortlet%>_aRappo_ae>A Rapporto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aRappo_aui'" ) );%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_aRappo_st_wrp'><input id='<%=idPortlet%>_aRappo_st' name='aRappo_st' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='aRappo_st' placeholder=' '/>
<label for=<%=idPortlet%>_aRappo_st>A Rapporto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aRappo_prov'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aRappo_ae'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aRappo_st'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_aDescRap_wrp'><input id='<%=idPortlet%>_aDescRap' name='aDescRap' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='aDescRap' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_DaSogg_wrp'><input id='<%=idPortlet%>_DaSogg' name='DaSogg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='DaSogg' placeholder=' '/>
<label for=<%=idPortlet%>_DaSogg>Da Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_DaSogg'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_daDescSogg_wrp'><input id='<%=idPortlet%>_daDescSogg' name='daDescSogg' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='daDescSogg' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_ASogg_wrp'><input id='<%=idPortlet%>_ASogg' name='ASogg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='ASogg' placeholder=' '/>
<label for=<%=idPortlet%>_ASogg>A Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_ASogg'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_aDescSogg_wrp'><input id='<%=idPortlet%>_aDescSogg' name='aDescSogg' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='aDescSogg' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_coddip_wrp'><input id='<%=idPortlet%>_coddip' name='coddip' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='coddip' placeholder=' '/>
<label for=<%=idPortlet%>_coddip>Dipendenza / Agenzia</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_coddip'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descdip_wrp'><input id='<%=idPortlet%>_descdip' name='descdip' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descdip' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' placeholder=' '/>
<label for=<%=idPortlet%>_DaData>A Data Informazione</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_AData_wrp'><input id='<%=idPortlet%>_AData' name='AData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='AData' placeholder=' '/>
<label for=<%=idPortlet%>_AData>Da Data Informazione</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_pTIPOAG_wrp'><input id='<%=idPortlet%>_pTIPOAG' name='pTIPOAG' type='text' maxlength='2' class='textbox' formid='<%=idPortlet%>' ps-name='pTIPOAG' placeholder=' '/>
<label for=<%=idPortlet%>_pTIPOAG>Tipo rapporto AE</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_pTIPOAG'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descri_age_wrp'><input id='<%=idPortlet%>_descri_age' name='descri_age' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descri_age' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_pRISGLOB_wrp'><input id='<%=idPortlet%>_pRISGLOB' name='pRISGLOB' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='pRISGLOB' placeholder=' '/>
<label for=<%=idPortlet%>_pRISGLOB>Rischio Globale</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_pRISGLOB'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descri_risc_wrp'><input id='<%=idPortlet%>_descri_risc' name='descri_risc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descri_risc' /></span>
<div id='<%=idPortlet%>_detope_div' style=''><input id='<%=idPortlet%>_detope' name='detope' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_detope' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stampa con dettaglio informazioni")%></label></div>
<div id='<%=idPortlet%>_detana_div' style=''><input id='<%=idPortlet%>_detana' name='detana' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_detana' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Dettaglio anagrafico (Solo Excel)")%></label></div>
<div id='<%=idPortlet%>_flgtit_div' style='display:none;'><input id='<%=idPortlet%>_flgtit' name='flgtit' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgtit' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stampa Titolari Effettivi")%></label></div>
<div id='<%=idPortlet%>_flgdel_div' style='display:none;'><input id='<%=idPortlet%>_flgdel' name='flgdel' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgdel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stampa Delegati")%></label></div>
<div id='<%=idPortlet%>_attiva_div' style='display:none;'><input id='<%=idPortlet%>_attiva' name='attiva' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_attiva' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("0 - Registrazione attiva")%></label></div>
<div id='<%=idPortlet%>_mod_attiva_div' style='display:none;'><input id='<%=idPortlet%>_mod_attiva' name='mod_attiva' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_mod_attiva' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("1 - Registrazione derivante da modifica")%></label></div>
<div id='<%=idPortlet%>_cancellata_div' style='display:none;'><input id='<%=idPortlet%>_cancellata' name='cancellata' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_cancellata' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2 - Copia di registrazione cancellata")%></label></div>
<div id='<%=idPortlet%>_mod_copia_div' style='display:none;'><input id='<%=idPortlet%>_mod_copia' name='mod_copia' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_mod_copia' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("3 - Copia di registrazione modificata")%></label></div>
<div id='<%=idPortlet%>_tipo' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_aui_div' style='display:none;'><input id='<%=idPortlet%>_aui' name='aui' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_aui' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Includi Titolari dell'AUI")%></label></div>
<label id='<%=idPortlet%>_Label_tipostp' for='<%=idPortlet%>_tipostp' formid='<%=idPortlet%>' ps-name='Label_tipostp'    class='label Label_tipostp_ctrl'><div id='<%=idPortlet%>_Label_tipostptbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo di stampa:")%></div></label>
<div id='<%=idPortlet%>_tipostp' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_Box_filtri' class='Box_filtri_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_filtri_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_Box_opzioni' class='Box_opzioni_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_opzioni_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stprappo');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_PRINT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stprappo',["640"],["570"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"640","h":"570","title":"Stampa rapporti","layer":"false","npage":"1"}]);
this.fonte=new ZtVWeb._VC(this,'fonte',null,'character','<%=JSPLib.ToJSValue(fonte,false,true)%>',false,false);
this.daRappo_aui=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daRappo_aui","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daRappo_aui","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daRappo_aui,false,true)%>","w":120,"x":2,"y":20,"zerofilling":false,"zindex":"2","zoom":""});
this.daRappo_prov=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daRappo_prov","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daRappo_prov","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daRappo_prov,false,true)%>","w":120,"x":2,"y":584,"zerofilling":false,"zindex":"1","zoom":""});
this.daRappo_ae=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daRappo_ae","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daRappo_ae","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daRappo_ae,false,true)%>","w":120,"x":2,"y":608,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daRappo_aui=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daRappo_aui","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"daRappo_aui,daDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_daRappo_aui",request.getSession())%>","linkedField":"daRappo_aui","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_daRappo_aui","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":true,"table":"anarapbo","type":"LinkZoom","w":10,"x":122,"y":20,"zindex":"3","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti AUI"),false,true)%>"});
this.daRappo_st=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daRappo_st","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daRappo_st","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daRappo_st,false,true)%>","w":120,"x":2,"y":632,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daRappo_prov=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daRappo_prov","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"daRappo_prov,daDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_daRappo_prov",request.getSession())%>","linkedField":"daRappo_prov","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_daRappo_prov","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xnarapbo,default",request.getSession())%>","suggest":true,"table":"xnarapbo","type":"LinkZoom","w":10,"x":122,"y":584,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti Provvisorio"),false,true)%>"});
this.LinkZoom_daRappo_ae=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daRappo_ae","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"daRappo_ae,daDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_daRappo_ae",request.getSession())%>","linkedField":"daRappo_ae","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_daRappo_ae","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,jnarapbo,default",request.getSession())%>","suggest":true,"table":"jnarapbo","type":"LinkZoom","w":10,"x":122,"y":608,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti Agenzia Entrate"),false,true)%>"});
this.LinkZoom_daRappo_st=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daRappo_st","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"daRappo_st,daDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_daRappo_st",request.getSession())%>","linkedField":"daRappo_st","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_daRappo_st","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,wnarapbo,default",request.getSession())%>","suggest":true,"table":"wnarapbo","type":"LinkZoom","w":10,"x":122,"y":632,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti Storico"),false,true)%>"});
this.aRappo_prov=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aRappo_prov","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aRappo_prov","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aRappo_prov,false,true)%>","w":120,"x":316,"y":584,"zerofilling":false,"zindex":"4","zoom":""});
this.daDescRap=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daDescRap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daDescRap","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daDescRap,false,true)%>","w":180,"x":132,"y":20,"zerofilling":false,"zindex":"4","zoom":""});
this.aRappo_aui=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aRappo_aui","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aRappo_aui","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aRappo_aui,false,true)%>","w":120,"x":316,"y":20,"zerofilling":false,"zindex":"5","zoom":""});
this.aRappo_ae=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aRappo_ae","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aRappo_ae","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aRappo_ae,false,true)%>","w":120,"x":316,"y":608,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_aRappo_aui=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aRappo_aui","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"aRappo_aui,aDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_aRappo_aui",request.getSession())%>","linkedField":"aRappo_aui","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_aRappo_aui","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":true,"table":"anarapbo","type":"LinkZoom","w":10,"x":436,"y":20,"zindex":"6","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti AUI"),false,true)%>"});
this.aRappo_st=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aRappo_st","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aRappo_st","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aRappo_st,false,true)%>","w":120,"x":316,"y":632,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_aRappo_prov=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aRappo_prov","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"aRappo_prov,aDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_aRappo_prov",request.getSession())%>","linkedField":"aRappo_prov","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_aRappo_prov","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xnarapbo,default",request.getSession())%>","suggest":true,"table":"xnarapbo","type":"LinkZoom","w":10,"x":436,"y":584,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti Provvisorio"),false,true)%>"});
this.LinkZoom_aRappo_ae=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aRappo_ae","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"aRappo_ae,aDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_aRappo_ae",request.getSession())%>","linkedField":"aRappo_ae","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_aRappo_ae","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xnarapbo,default",request.getSession())%>","suggest":true,"table":"xnarapbo","type":"LinkZoom","w":10,"x":436,"y":608,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti Agenzia Entrate"),false,true)%>"});
this.LinkZoom_aRappo_st=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aRappo_st","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"aRappo_st,aDescRap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_aRappo_st",request.getSession())%>","linkedField":"aRappo_st","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_aRappo_st","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xnarapbo,default",request.getSession())%>","suggest":true,"table":"xnarapbo","type":"LinkZoom","w":10,"x":436,"y":632,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti Storico"),false,true)%>"});
this.aDescRap=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aDescRap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aDescRap","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aDescRap,false,true)%>","w":180,"x":446,"y":20,"zerofilling":false,"zindex":"7","zoom":""});
this.DaSogg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaSogg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaSogg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(DaSogg,false,true)%>","w":120,"x":2,"y":60,"zerofilling":false,"zindex":"8","zoom":""});
this.LinkZoom_DaSogg=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_DaSogg","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"DaSogg,daDescSogg","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_DaSogg",request.getSession())%>","linkedField":"DaSogg","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_DaSogg","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":10,"x":122,"y":60,"zindex":"9","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.daDescSogg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daDescSogg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daDescSogg","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daDescSogg,false,true)%>","w":180,"x":132,"y":60,"zerofilling":false,"zindex":"10","zoom":""});
this.ASogg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ASogg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ASogg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ASogg,false,true)%>","w":120,"x":316,"y":60,"zerofilling":false,"zindex":"11","zoom":""});
this.LinkZoom_ASogg=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_ASogg","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"ASogg,aDescSogg","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_ASogg",request.getSession())%>","linkedField":"ASogg","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_ASogg","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":10,"x":436,"y":60,"zindex":"12","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.aDescSogg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aDescSogg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aDescSogg","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aDescSogg,false,true)%>","w":180,"x":446,"y":60,"zerofilling":false,"zindex":"13","zoom":""});
this.coddip=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_coddip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"coddip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(coddip,false,true)%>","w":120,"x":2,"y":100,"zerofilling":false,"zindex":"14","zoom":""});
this.LinkZoom_coddip=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_coddip","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"coddip,descdip","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_coddip",request.getSession())%>","linkedField":"coddip","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_coddip","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":10,"x":122,"y":100,"zindex":"15","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Dipendenza"),false,true)%>"});
this.descdip=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descdip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descdip","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descdip,false,true)%>","w":120,"x":132,"y":100,"zerofilling":false,"zindex":"16","zoom":""});
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaData%>","w":120,"x":316,"y":100,"zerofilling":false,"zindex":"17","zoom":""});
this.AData=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_AData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"AData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=AData%>","w":120,"x":440,"y":100,"zerofilling":false,"zindex":"18","zoom":""});
this.pTIPOAG=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_pTIPOAG","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"2","name":"pTIPOAG","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(pTIPOAG,false,true)%>","w":64,"x":2,"y":140,"zerofilling":false,"zindex":"19","zoom":""});
this.LinkZoom_pTIPOAG=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_pTIPOAG","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"pTIPOAG,descri_age","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_pTIPOAG",request.getSession())%>","linkedField":"pTIPOAG","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_pTIPOAG","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbrapp,default",request.getSession())%>","suggest":true,"table":"tbrapp","type":"LinkZoom","w":10,"x":66,"y":140,"zindex":"20","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Tipo agenzia entrate"),false,true)%>"});
this.descri_age=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descri_age","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descri_age","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descri_age,false,true)%>","w":237,"x":76,"y":140,"zerofilling":false,"zindex":"21","zoom":""});
this.pRISGLOB=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_pRISGLOB","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"pRISGLOB","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(pRISGLOB,false,true)%>","w":64,"x":316,"y":140,"zerofilling":false,"zindex":"22","zoom":""});
this.LinkZoom_pRISGLOB=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_pRISGLOB","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stprappo_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"pRISGLOB,descri_risc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stprappo_portlet.jspLinkZoom_pRISGLOB",request.getSession())%>","linkedField":"pRISGLOB","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom_pRISGLOB","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODICE,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbrisglob,default",request.getSession())%>","suggest":true,"table":"tbrisglob","type":"LinkZoom","w":10,"x":380,"y":140,"zindex":"23","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rischio Globale"),false,true)%>"});
this.descri_risc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descri_risc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descri_risc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descri_risc,false,true)%>","w":236,"x":390,"y":140,"zerofilling":false,"zindex":"24","zoom":""});
this.detope=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_detope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"Stampa con dettaglio informazioni","layer":false,"layout_steps_values":{},"name":"detope","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":160,"x":2,"y":182,"zindex":"25"});
this.detope.Value(<%=detope%>);
this.detana=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_detana","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"Dettaglio anagrafico (Solo Excel)","layer":false,"layout_steps_values":{},"name":"detana","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":160,"x":2,"y":209,"zindex":"26"});
this.detana.Value(<%=detana%>);
this.flgtit=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgtit","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"!(this.detana.Value())","init":"","init_par":"false","label_text":"Stampa Titolari Effettivi","layer":false,"layout_steps_values":{},"name":"flgtit","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":160,"x":2,"y":235,"zindex":"27"});
this.flgtit.Value(<%=flgtit%>);
this.flgdel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgdel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"!(this.detana.Value())","init":"","init_par":"false","label_text":"Stampa Delegati","layer":false,"layout_steps_values":{},"name":"flgdel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":160,"x":2,"y":261,"zindex":"28"});
this.flgdel.Value(<%=flgdel%>);
this.attiva=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_attiva","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"Ne(this.fonte.Value(),'D')","init":"","init_par":"true","label_text":"0 - Registrazione attiva","layer":false,"layout_steps_values":{},"name":"attiva","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":176,"x":164,"y":182,"zindex":"29"});
this.attiva.Value(<%=attiva%>);
this.mod_attiva=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_mod_attiva","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"Ne(this.fonte.Value(),'D')","init":"","init_par":"true","label_text":"1 - Registrazione derivante da modifica","layer":false,"layout_steps_values":{},"name":"mod_attiva","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":176,"x":164,"y":209,"zindex":"30"});
this.mod_attiva.Value(<%=mod_attiva%>);
this.cancellata=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_cancellata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"Ne(this.fonte.Value(),'D')","init":"","init_par":"true","label_text":"2 - Copia di registrazione cancellata","layer":false,"layout_steps_values":{},"name":"cancellata","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":176,"x":164,"y":235,"zindex":"31"});
this.cancellata.Value(<%=cancellata%>);
this.mod_copia=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_mod_copia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"Ne(this.fonte.Value(),'D')","init":"","init_par":"true","label_text":"3 - Copia di registrazione modificata","layer":false,"layout_steps_values":{},"name":"mod_copia","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":176,"x":164,"y":261,"zindex":"32"});
this.mod_copia.Value(<%=mod_copia%>);
this.tipo=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_tipo","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":104,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"T","layer":false,"layout_steps_values":{},"name":"tipo","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"T,A,C","visible":true,"w":150,"x":342,"y":182,"zindex":"33"});
this.tipo.Value('<%=JSPLib.ToJSValue(tipo,false,true)%>');
this.aui=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_aui","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"!(this.detana.Value()) || Ne(this.fonte.Value(),'J')","init":"","init_par":"true","label_text":"Includi Titolari dell'AUI","layer":false,"layout_steps_values":{},"name":"aui","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":119,"x":492,"y":182,"zindex":"34"});
this.aui.Value(<%=aui%>);
this.Label_tipostp=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"tipostp","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_tipostp","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_tipostp","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_tipostp,false,true)%>","type":"Label","w":56,"x":266,"y":310,"zindex":"29"});
this.tipostp=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Excel,Report","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_tipostp","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":30,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"name":"tipostp","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"X,R","visible":true,"w":124,"x":323,"y":310,"zindex":"36"});
this.Box_filtri=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#BDBDBD","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_filtri","groupName":"","h":0,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_filtri","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":580,"x":40,"y":170,"zindex":"37"});
this.Box_opzioni=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#BDBDBD","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_opzioni","groupName":"","h":0,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_opzioni","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":580,"x":40,"y":300,"zindex":"38"});
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":74,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":640,"x":0,"y":352,"zindex":"39"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right(%)-bottom","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":640,"x":0,"y":427,"zindex":"40"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.daRappo=new ZtVWeb._VC(this,'daRappo',null,'character','<%=JSPLib.ToJSValue(daRappo,false,true)%>',false,false);
this.aRappo=new ZtVWeb._VC(this,'aRappo',null,'character','<%=JSPLib.ToJSValue(aRappo,false,true)%>',false,false);
this.SPLinker_arrt_stprappo_all=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_stprappo_all",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_arrt_stprappo_all","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_arrt_stprappo_all","offline":false,"page":1,"parms":"fonte,tipostp,daRappo,aRappo,DaSogg,aSogg,coddip,DaData,AData,detope,detana,flgtit,flgdel,tipo,attiva,mod_attiva,cancellata,mod_copia,aui,pTIPOAG,pRISGLOB","popup":"true","popup_height":"","popup_maximized":"by skin","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_stprappo_all","target":"","type":"SPLinker","w":178,"x":662,"y":91});
this.SPLinker_arrt_stprappo_all.m_cID='<%=JSPLib.cmdHash("routine,arrt_stprappo_all",request.getSession())%>';
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
<%if(request.getAttribute("pg_stprappo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stprappo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stprappo_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stprappo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stprappo');
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
sp.endPage("pg_stprappo");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_daRappo_aui")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_daRappo_prov")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xnarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_daRappo_ae")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "jnarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_daRappo_st")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "wnarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aRappo_aui")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aRappo_prov")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xnarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aRappo_ae")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xnarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aRappo_st")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xnarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_DaSogg")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 2;
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
if (Library.eq(p_cControlName,"LinkZoom_ASogg")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 2;
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
if (Library.eq(p_cControlName,"LinkZoom_coddip")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 1;
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
if (Library.eq(p_cControlName,"LinkZoom_pTIPOAG")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbrapp";
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
if (Library.eq(p_cControlName,"LinkZoom_pRISGLOB")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbrisglob";
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
<%! public String getJSPUID() { return "74602512"; } %>