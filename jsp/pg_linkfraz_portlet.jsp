<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle(\"Collegamento Frazionate\",true)\nthis.GridOpe.SetSPLinkerActions('-d-e-n');\nthis.tipope.Value(1)\n\nfunction button12_Click(){\n  this.QueryOpe.Query();\n}\n\nfunction Conferma_Click() {\n  this.opeValues.Value(this.GridOpe.GetSelectedDataAsTrsString());\n  if (Empty(this.codcol.Value())) {\n    alert('Impossibile effettuare il collegamento se non si inserisce il codice!')\n  } else {\n    if (confirm('Confermi il collegamento delle operazioni\u002ftitolarità ?')) {   \n      _esito=this.RTCollega.Link();\n      this.QueryOpe.Query();\n      alert('Collegamento completato correttamente')\n      window.close()\n    }  \n  }  \n}\n\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"474","hsl":"","htmlcode":"{{ @ragsocben }}\n{{ @LinkZoom25_Copy_Copy }}\n{{ @Label3_Copy_Copy_Copy_Copy_Copy }}\n{{ @w_CONNESBEN }}\n{{ @ragsocope }}\n{{ @LinkZoom25_Copy }}\n{{ @Label3_Copy_Copy_Copy_Copy }}\n{{ @w_CONNESOPER }}\n{{ @LinkZoom25 }}\n{{ @LinkZoom24 }}\n{{ @tipope }}\n{{ @label19 }}\n{{ @dadata }}\n{{ @a_data }}\n{{ @codcol }}\n{{ @descrap }}\n{{ @ragsoc }}\n{{ @Label3_Copy_Copy_Copy }}\n{{ @Label3_Copy_Copy }}\n{{ @Label3_Copy }}\n{{ @Label3 }}\n{{ @Label2 }}\n{{ @Label1 }}\n{{ @Conferma }}\n{{ @button12 }}\n{{ @labelOpe }}\n{{ @w_IDOPER }}\n{{ @w_RAPPORTO }}\n{{ @w_CONNES }}\n{{ @GridOpe }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"740","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"IDBASE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:operazbo_view\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data registrazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COLLEG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"QueryOpe","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,D,D,C","filters":"false","floatRows":"","font":"Tahoma","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"268","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"GridOpe","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"740","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"197","zindex":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label3_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Esecutore:","w":"61","wireframe_props":"align,value,n_col","x":"5","y":"96","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label3_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Controparte:","w":"61","wireframe_props":"align,value,n_col","x":"3","y":"122","zindex":"1"},{"allowedqueries":"qbe_linkfraz","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"100","name":"QueryOpe","offline":"false","page":"1","parms":"w_connes=w_CONNES,w_dadata=dadata,w_a_data=a_data,w_rapporto=w_RAPPORTO,w_connesope=w_CONNESOPER,w_connesben=W_CONNESBEN","parms_source":"","query":"qbe_linkfraz","query_async":"false","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"120","x":"784","y":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"linkoper_subjects","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"22","hide":"false","image":"","img_type":"default","intovars":"w_CONNESOPER,ragsocope","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_CONNESOPER","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom25_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"5","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"22","wireframe_props":"","x":"198","y":"93","zindex":"","zoomtitle":"Soggetti"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"linkoper_subjects","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"22","hide":"false","image":"","img_type":"default","intovars":"w_CONNESBEN,ragsocben","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_CONNESBEN","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom25_Copy_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"6","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"22","wireframe_props":"","x":"198","y":"119","zindex":"","zoomtitle":"Soggetti"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"w_CONNES","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_CONNES","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"129","wireframe_props":"name","x":"67","y":"66","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ragsocben","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"501","wireframe_props":"name","x":"224","y":"119","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"w_RAPPORTO","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_RAPPORTO","page":"1","password":"false","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"196","wireframe_props":"name","x":"67","y":"37","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ragsocope","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"501","wireframe_props":"name","x":"226","y":"93","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"w_IDOPER","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_IDOPER","page":"1","password":"false","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"129","wireframe_props":"name","x":"589","y":"6","zerofilling":"false","zindex":"1"},{"align":"center","anchor":"","assoc_input":"","bg_color":"#829BC6","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelOpe","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Frazionate (A.U.I.)","w":"740","wireframe_props":"align,value,n_col","x":"0","y":"177","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"w_CONNESBEN","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_CONNESBEN","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"129","wireframe_props":"name","x":"67","y":"119","zerofilling":"false","zindex":"1"},{"allowedentities":"armt_ofrazionate","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"operazbo_view","offline":"false","page":"1","parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"14","servlet":"armt_ofrazionate","target":"_new","type":"SPLinker","w":"137","x":"781","y":"-66"},{"anchor":"","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"Verdana","font_color":"#000000","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"button12","page":"1","sequence":"15","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Ricerca","w":"65","wireframe_props":"value","x":"309","y":"8","zindex":"1"},{"anchor":"","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Conferma","page":"1","sequence":"16","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Collega","w":"75","wireframe_props":"value","x":"641","y":"145","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label1","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data:","w":"61","wireframe_props":"align,value,n_col","x":"5","y":"11","zindex":"1"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data:","w":"47","wireframe_props":"align,value,n_col","x":"173","y":"11","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label3","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"19","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Soggetto:","w":"61","wireframe_props":"align,value,n_col","x":"5","y":"69","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label3_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Coll.:","w":"65","wireframe_props":"align,value,n_col","x":"0","y":"147","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label3_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Rapporto:","w":"61","wireframe_props":"align,value,n_col","x":"5","y":"39","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label3_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ID Operazione:","w":"103","wireframe_props":"align,value,n_col","x":"482","y":"6","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"23","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"501","wireframe_props":"name","x":"226","y":"66","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descrap","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"24","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"427","wireframe_props":"name","x":"291","y":"37","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"Inserire il codice di collegamento delle operazioni selezionate","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"12","name":"codcol","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"106","wireframe_props":"name","x":"525","y":"146","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"a_data","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"26","spuid":"","tabindex":"2","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"83","wireframe_props":"name","x":"217","y":"10","zerofilling":"false","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"dadata","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"27","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"83","wireframe_props":"name","x":"67","y":"10","zerofilling":"false","zindex":"1"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label19","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"28","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice Collegamento:","w":"125","wireframe_props":"align,value,n_col","x":"411","y":"147","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"opeValues","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"787","y":"30"},{"allowedentities":"arfn_likfraz_save","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTCollega","offline":"false","page":"1","parms":"oValues=opeValues,pColleg=codcol,pTipo=tipope,pOper=w_IDOPER","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"30","servlet":"arfn_likfraz_save","target":"","type":"SPLinker","w":"124","x":"780","y":"-33"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"true","edit_undercond":"","empty_value":"false","field":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"request","layer":"false","layout_steps_values":"{}","name":"tipope","page":"1","picture":"","sequence":"31","spuid":"","tabindex":"3","textlist":"Normale,Multipla","type":"Combobox","typevar":"character","valuelist":"'0','2'","visible":"true","w":"179","wireframe_props":"name,textlist","x":"67","y":"146","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"22","hide":"false","image":"","img_type":"default","intovars":"w_RAPPORTO,descrap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_RAPPORTO","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom24","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"32","servlet":"","spuid":"","suggest":"false","table":"anarapbo","type":"LinkZoom","w":"22","wireframe_props":"","x":"266","y":"37","zindex":"","zoomtitle":"Elenco Rapporti"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"linkoper_subjects","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"22","hide":"false","image":"","img_type":"default","intovars":"w_CONNES,ragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_CONNES","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom25","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"33","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"22","wireframe_props":"","x":"198","y":"66","zindex":"","zoomtitle":"Soggetti"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"w_CONNESOPER","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_CONNESOPER","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"34","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"129","wireframe_props":"name","x":"67","y":"93","zerofilling":"false","zindex":"1"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:w_CONNES,ragsocben,w_RAPPORTO,ragsocope,w_IDOPER,w_CONNESBEN,ragsoc,descrap,tipope,w_CONNESOPER*/%>
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
window.pg_linkfraz_Static=function(){
if(typeof button12_Click !='undefined')this.button12_Click=button12_Click;
if(typeof Conferma_Click !='undefined')this.Conferma_Click=Conferma_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
ZtVWeb.CalcCtrl(this.w_CONNES.Value(),this.w_CONNES);
ZtVWeb.CalcCtrl(this.w_RAPPORTO.Value(),this.w_RAPPORTO);
ZtVWeb.CalcCtrl(this.w_IDOPER.Value(),this.w_IDOPER);
ZtVWeb.CalcCtrl(this.w_CONNESBEN.Value(),this.w_CONNESBEN);
ZtVWeb.CalcCtrl(this.w_CONNESOPER.Value(),this.w_CONNESOPER);
}
this.QueryOpe.addRowConsumer(this.GridOpe);
this.LinkZoom25_Copy.addObserverFixedVars();
this.LinkZoom25_Copy_Copy.addObserverFixedVars();
this.LinkZoom24.addObserverFixedVars();
this.LinkZoom25.addObserverFixedVars();
this.getTitlePortlet().SetTitle("Collegamento Frazionate",true)
this.GridOpe.SetSPLinkerActions('-d-e-n');
this.tipope.Value(1)
function button12_Click(){
  this.QueryOpe.Query();
}
function Conferma_Click() {
  this.opeValues.Value(this.GridOpe.GetSelectedDataAsTrsString());
  if (Empty(this.codcol.Value())) {
    alert('Impossibile effettuare il collegamento se non si inserisce il codice!')
  } else {
    if (confirm('Confermi il collegamento delle operazioni/titolarità ?')) {   
      _esito=this.RTCollega.Link();
      this.QueryOpe.Query();
      alert('Collegamento completato correttamente')
      window.close()
    }  
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
.pg_linkfraz_container {
}
.pg_linkfraz_title_container {
  margin: auto;
}
.pg_linkfraz_portlet{
  position:relative;
  margin: auto;
  width:740px;
  min-width:740px;
  height:474px;
}
.pg_linkfraz_portlet[Data-page="1"]{
  height:474px;
  width:740px;
}
.pg_linkfraz_portlet > .GridOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:197px;
  left:0px;
  width:740px;
  height:auto;
  min-height:268px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:96px;
  left:5px;
  width:61px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:122px;
  left:3px;
  width:61px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .LinkZoom25_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:93px;
  left:198px;
  width:22px;
  height:22px;
}
.pg_linkfraz_portlet > .LinkZoom25_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  left:198px;
  width:22px;
  height:22px;
}
.pg_linkfraz_portlet > .w_CONNES_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:66px;
  left:67px;
  width:129px;
  height:22px;
}
.pg_linkfraz_portlet > .w_CONNES_ctrl {
}
.pg_linkfraz_portlet > .w_CONNES_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .ragsocben_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  left:224px;
  width:501px;
  height:22px;
}
.pg_linkfraz_portlet > .ragsocben_ctrl {
}
.pg_linkfraz_portlet > .ragsocben_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .w_RAPPORTO_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:67px;
  width:196px;
  height:22px;
}
.pg_linkfraz_portlet > .w_RAPPORTO_ctrl {
}
.pg_linkfraz_portlet > .w_RAPPORTO_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .ragsocope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:93px;
  left:226px;
  width:501px;
  height:22px;
}
.pg_linkfraz_portlet > .ragsocope_ctrl {
}
.pg_linkfraz_portlet > .ragsocope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .w_IDOPER_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:589px;
  width:129px;
  height:22px;
}
.pg_linkfraz_portlet > .w_IDOPER_ctrl {
}
.pg_linkfraz_portlet > .w_IDOPER_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .labelOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:177px;
  left:0px;
  width:740px;
  height:auto;
  min-height:20px;
}
.pg_linkfraz_portlet > .labelOpe_ctrl {
  height:auto;
  min-height:20px;
}
.pg_linkfraz_portlet > .labelOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
}
.pg_linkfraz_portlet > .w_CONNESBEN_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  left:67px;
  width:129px;
  height:22px;
}
.pg_linkfraz_portlet > .w_CONNESBEN_ctrl {
}
.pg_linkfraz_portlet > .w_CONNESBEN_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .button12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:309px;
  width:65px;
  height:20px;
}
.pg_linkfraz_portlet > .button12_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#000000;
  background-color:buttonface;
  border-width:1px;
  border-color:#000000;
}
.pg_linkfraz_portlet > .Conferma_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:145px;
  left:641px;
  width:75px;
  height:20px;
}
.pg_linkfraz_portlet > .Conferma_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#FFFFFF;
  background-color:#10CE1D;
  border-width:1px;
  border-color:#000000;
}
.pg_linkfraz_portlet > .Label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:5px;
  width:61px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .Label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:173px;
  width:47px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label2_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_linkfraz_portlet > .Label3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:69px;
  left:5px;
  width:61px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .Label3_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:147px;
  left:0px;
  width:65px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:39px;
  left:5px;
  width:61px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:482px;
  width:103px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .Label3_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_linkfraz_portlet > .ragsoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:66px;
  left:226px;
  width:501px;
  height:22px;
}
.pg_linkfraz_portlet > .ragsoc_ctrl {
}
.pg_linkfraz_portlet > .ragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .descrap_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:291px;
  width:427px;
  height:22px;
}
.pg_linkfraz_portlet > .descrap_ctrl {
}
.pg_linkfraz_portlet > .descrap_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .codcol_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:146px;
  left:525px;
  width:106px;
  height:20px;
}
.pg_linkfraz_portlet > .codcol_ctrl {
}
.pg_linkfraz_portlet > .codcol_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .a_data_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:10px;
  left:217px;
  width:83px;
  height:20px;
}
.pg_linkfraz_portlet > .a_data_ctrl {
}
.pg_linkfraz_portlet > .a_data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:67px;
  width:83px;
  height:20px;
}
.pg_linkfraz_portlet > .dadata_ctrl {
}
.pg_linkfraz_portlet > .dadata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_linkfraz_portlet > .label19_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:147px;
  left:411px;
  width:125px;
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .label19_ctrl {
  height:auto;
  min-height:19px;
}
.pg_linkfraz_portlet > .label19_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_linkfraz_portlet > .tipope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:146px;
  left:67px;
  width:179px;
  height:20px;
}
.pg_linkfraz_portlet > .LinkZoom24_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:266px;
  width:22px;
  height:22px;
}
.pg_linkfraz_portlet > .LinkZoom25_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:66px;
  left:198px;
  width:22px;
  height:22px;
}
.pg_linkfraz_portlet > .w_CONNESOPER_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:93px;
  left:67px;
  width:129px;
  height:22px;
}
.pg_linkfraz_portlet > .w_CONNESOPER_ctrl {
}
.pg_linkfraz_portlet > .w_CONNESOPER_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
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
 String def="[{\"h\":\"474\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"740\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"N° Progressivo\"},{\"title\":\"Data Operazione\"},{\"title\":\"Data registrazione\"},{\"title\":\"Codice Collegamento\"}],\"h\":\"268\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"740\",\"x\":\"0\",\"y\":\"197\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Esecutore:\",\"w\":\"61\",\"x\":\"5\",\"y\":\"96\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Controparte:\",\"w\":\"61\",\"x\":\"3\",\"y\":\"122\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"784\",\"y\":\"4\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"22\",\"x\":\"198\",\"y\":\"93\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"22\",\"x\":\"198\",\"y\":\"119\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_CONNES\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"129\",\"x\":\"67\",\"y\":\"66\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"ragsocben\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"501\",\"x\":\"224\",\"y\":\"119\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_RAPPORTO\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"196\",\"x\":\"67\",\"y\":\"37\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"ragsocope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"501\",\"x\":\"226\",\"y\":\"93\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_IDOPER\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"129\",\"x\":\"589\",\"y\":\"6\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Frazionate (A.U.I.)\",\"w\":\"740\",\"x\":\"0\",\"y\":\"177\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_CONNESBEN\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"129\",\"x\":\"67\",\"y\":\"119\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"operazbo_view\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"137\",\"x\":\"781\",\"y\":\"-66\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"button12\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Ricerca\",\"w\":\"65\",\"x\":\"309\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Conferma\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Collega\",\"w\":\"75\",\"x\":\"641\",\"y\":\"145\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"61\",\"x\":\"5\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"47\",\"x\":\"173\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label3\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Soggetto:\",\"w\":\"61\",\"x\":\"5\",\"y\":\"69\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label3_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Coll.:\",\"w\":\"65\",\"x\":\"0\",\"y\":\"147\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label3_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Rapporto:\",\"w\":\"61\",\"x\":\"5\",\"y\":\"39\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label3_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Operazione:\",\"w\":\"103\",\"x\":\"482\",\"y\":\"6\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"ragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"501\",\"x\":\"226\",\"y\":\"66\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"descrap\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"427\",\"x\":\"291\",\"y\":\"37\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codcol\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"106\",\"x\":\"525\",\"y\":\"146\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"217\",\"y\":\"10\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dadata\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"67\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label19\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice Collegamento:\",\"w\":\"125\",\"x\":\"411\",\"y\":\"147\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"opeValues\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"787\",\"y\":\"30\"},{\"h\":\"30\",\"name\":\"RTCollega\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"124\",\"x\":\"780\",\"y\":\"-33\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipope\",\"page\":\"1\",\"textlist\":\"Normale,Multipla\",\"type\":\"Combobox\",\"w\":\"179\",\"x\":\"67\",\"y\":\"146\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"LinkZoom24\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"22\",\"x\":\"266\",\"y\":\"37\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"LinkZoom25\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"22\",\"x\":\"198\",\"y\":\"66\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_CONNESOPER\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"129\",\"x\":\"67\",\"y\":\"93\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_linkfraz","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_linkfraz_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_linkfraz','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_linkfraz_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String Label3_Copy_Copy_Copy_Copy= "Esecutore:";
String Label3_Copy_Copy_Copy_Copy_Copy= "Controparte:";
if(request.getAttribute("pg_linkfraz_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String w_CONNES=JSPLib.translateXSS(sp.getParameter("w_CONNES",""));
if(request.getAttribute("pg_linkfraz_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String ragsocben=JSPLib.translateXSS(sp.getParameter("ragsocben",""));
String w_RAPPORTO=JSPLib.translateXSS(sp.getParameter("w_RAPPORTO",""));
String ragsocope=JSPLib.translateXSS(sp.getParameter("ragsocope",""));
String w_IDOPER=JSPLib.translateXSS(sp.getParameter("w_IDOPER",""));
String labelOpe= "Frazionate (A.U.I.)";
String w_CONNESBEN=JSPLib.translateXSS(sp.getParameter("w_CONNESBEN",""));
String Label1= "Da Data:";
String Label2= "A Data:";
String Label3= "Soggetto:";
String Label3_Copy= "Tipo Coll.:";
String Label3_Copy_Copy= "Rapporto:";
String Label3_Copy_Copy_Copy= "ID Operazione:";
String ragsoc=JSPLib.translateXSS(sp.getParameter("ragsoc",""));
String descrap=JSPLib.translateXSS(sp.getParameter("descrap",""));
String codcol= "";
java.sql.Date a_data= JSPLib.NullDate();
java.sql.Date dadata= JSPLib.NullDate();
String label19= "Codice Collegamento:";
String opeValues= "";
String tipope=JSPLib.translateXSS(sp.getParameter("tipope",""));
String w_CONNESOPER=JSPLib.translateXSS(sp.getParameter("w_CONNESOPER",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_linkfraz_title_container' style='width:740px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_linkfraz_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_linkfraz_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_linkfraz','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_GridOpe' formid='<%=idPortlet%>' ps-name='GridOpe'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_Label3_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label3_Copy_Copy_Copy_Copy'    class='label Label3_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label3_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Esecutore:")%></div></span>
<span id='<%=idPortlet%>_Label3_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label3_Copy_Copy_Copy_Copy_Copy'    class='label Label3_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label3_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Controparte:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom25_Copy'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom25_Copy_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_w_CONNES_wrp'><input id='<%=idPortlet%>_w_CONNES' name='w_CONNES' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_CONNES' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ragsocben_wrp'><input id='<%=idPortlet%>_ragsocben' name='ragsocben' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ragsocben' /></span>
<span class='textbox-container'id='<%=idPortlet%>_w_RAPPORTO_wrp'><input id='<%=idPortlet%>_w_RAPPORTO' name='w_RAPPORTO' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='w_RAPPORTO' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ragsocope_wrp'><input id='<%=idPortlet%>_ragsocope' name='ragsocope' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ragsocope' /></span>
<span class='textbox-container'id='<%=idPortlet%>_w_IDOPER_wrp'><input id='<%=idPortlet%>_w_IDOPER' name='w_IDOPER' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='w_IDOPER' /></span>
<span id='<%=idPortlet%>_labelOpe'  formid='<%=idPortlet%>' ps-name='labelOpe'    class='label labelOpe_ctrl'><div id='<%=idPortlet%>_labelOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Frazionate (A.U.I.)")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_w_CONNESBEN_wrp'><input id='<%=idPortlet%>_w_CONNESBEN' name='w_CONNESBEN' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_CONNESBEN' /></span>
<input id='<%=idPortlet%>_button12' type='button' class='button button12_ctrl'/>
<input id='<%=idPortlet%>_Conferma' type='button' class='button Conferma_ctrl'/>
<span id='<%=idPortlet%>_Label1'  formid='<%=idPortlet%>' ps-name='Label1'    class='label Label1_ctrl'><div id='<%=idPortlet%>_Label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data:")%></div></span>
<span id='<%=idPortlet%>_Label2'  formid='<%=idPortlet%>' ps-name='Label2'    class='label Label2_ctrl'><div id='<%=idPortlet%>_Label2tbl' style='width:100%;'><%=JSPLib.ToHTML("A Data:")%></div></span>
<span id='<%=idPortlet%>_Label3'  formid='<%=idPortlet%>' ps-name='Label3'    class='label Label3_ctrl'><div id='<%=idPortlet%>_Label3tbl' style='width:100%;'><%=JSPLib.ToHTML("Soggetto:")%></div></span>
<span id='<%=idPortlet%>_Label3_Copy'  formid='<%=idPortlet%>' ps-name='Label3_Copy'    class='label Label3_Copy_ctrl'><div id='<%=idPortlet%>_Label3_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Coll.:")%></div></span>
<span id='<%=idPortlet%>_Label3_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label3_Copy_Copy'    class='label Label3_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label3_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Rapporto:")%></div></span>
<span id='<%=idPortlet%>_Label3_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label3_Copy_Copy_Copy'    class='label Label3_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label3_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("ID Operazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ragsoc_wrp'><input id='<%=idPortlet%>_ragsoc' name='ragsoc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ragsoc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_descrap_wrp'><input id='<%=idPortlet%>_descrap' name='descrap' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descrap' /></span>
<span class='textbox-container'id='<%=idPortlet%>_codcol_wrp'><input id='<%=idPortlet%>_codcol' name='codcol' type='text' maxlength='12' class='textbox' formid='<%=idPortlet%>' ps-name='codcol' /></span>
<span class='textbox-container'id='<%=idPortlet%>_a_data_wrp'><input id='<%=idPortlet%>_a_data' name='a_data' type='text' class='textbox' tabindex='2' formid='<%=idPortlet%>' ps-name='a_data' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dadata_wrp'><input id='<%=idPortlet%>_dadata' name='dadata' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='dadata' /></span>
<span id='<%=idPortlet%>_label19'  formid='<%=idPortlet%>' ps-name='label19'    class='label label19_ctrl'><div id='<%=idPortlet%>_label19tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Collegamento:")%></div></span>
<select id='<%=idPortlet%>_tipope' name='tipope' disabled class='combobox' style='font-family:verdana;font-size:7pt;' tabindex='3'></select>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom24'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom25'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_w_CONNESOPER_wrp'><input id='<%=idPortlet%>_w_CONNESOPER' name='w_CONNESOPER' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_CONNESOPER' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_linkfraz');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_linkfraz',["740"],["474"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"740","h":"474","title":"","layer":"false","npage":"1"}]);
this.GridOpe=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"IDBASE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridOpe","dataobj":"QueryOpe","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":268,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"GridOpe","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":740,"x":0,"y":197,"zindex":""});
this.GridOpe.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:operazbo_view","weight":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NUMPROG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data registrazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Collegamento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COLLEG","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Label3_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label3_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label3_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":61,"x":5,"y":96,"zindex":"1"});
this.Label3_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label3_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label3_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":61,"x":3,"y":122,"zindex":"1"});
this.QueryOpe=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_linkfraz",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_linkfraz","cmdHash":"<%=JSPLib.cmdHash("qbe_linkfraz",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_QueryOpe","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"QueryOpe","nrows":"100","page":1,"parms":"w_connes=w_CONNES,w_dadata=dadata,w_a_data=a_data,w_rapporto=w_RAPPORTO,w_connesope=w_CONNESOPER,w_connesben=W_CONNESBEN","parms_source":"","type":"SQLDataobj","w":120,"x":784,"y":4});
this.LinkZoom25_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"linkoper_subjects","ctrlid":"<%=idPortlet%>_LinkZoom25_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_linkfraz_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":22,"hide":"false","image":"","intovars":"w_CONNESOPER,ragsocope","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_linkfraz_portlet.jspLinkZoom25_Copy",request.getSession())%>","linkedField":"w_CONNESOPER","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom25_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,linkoper_subjects",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":22,"x":198,"y":93,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.LinkZoom25_Copy_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"linkoper_subjects","ctrlid":"<%=idPortlet%>_LinkZoom25_Copy_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_linkfraz_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":22,"hide":"false","image":"","intovars":"w_CONNESBEN,ragsocben","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_linkfraz_portlet.jspLinkZoom25_Copy_Copy",request.getSession())%>","linkedField":"w_CONNESBEN","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom25_Copy_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,linkoper_subjects",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":22,"x":198,"y":119,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.w_CONNES=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"this.w_CONNES.Value()","create_undercond":"","ctrlid":"<%=idPortlet%>_w_CONNES","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_CONNES","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_CONNES,false,true)%>","w":129,"x":67,"y":66,"zerofilling":false,"zindex":"1","zoom":""});
this.ragsocben=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragsocben","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"ragsocben","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragsocben,false,true)%>","w":501,"x":224,"y":119,"zerofilling":false,"zindex":"1","zoom":""});
this.w_RAPPORTO=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"this.w_RAPPORTO.Value()","create_undercond":"","ctrlid":"<%=idPortlet%>_w_RAPPORTO","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_RAPPORTO","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_RAPPORTO,false,true)%>","w":196,"x":67,"y":37,"zerofilling":false,"zindex":"1","zoom":""});
this.ragsocope=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragsocope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"ragsocope","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragsocope,false,true)%>","w":501,"x":226,"y":93,"zerofilling":false,"zindex":"1","zoom":""});
this.w_IDOPER=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"this.w_IDOPER.Value()","create_undercond":"","ctrlid":"<%=idPortlet%>_w_IDOPER","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_IDOPER","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_IDOPER,false,true)%>","w":129,"x":589,"y":6,"zerofilling":false,"zindex":"1","zoom":""});
this.labelOpe=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelOpe","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelOpe,false,true)%>","type":"Label","w":740,"x":0,"y":177,"zindex":"1"});
this.w_CONNESBEN=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"this.w_CONNESBEN.Value()","create_undercond":"","ctrlid":"<%=idPortlet%>_w_CONNESBEN","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_CONNESBEN","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_CONNESBEN,false,true)%>","w":129,"x":67,"y":119,"zerofilling":false,"zindex":"1","zoom":""});
this.operazbo_view=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"<%=JSPLib.encrypt("armt_ofrazionate",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_operazbo_view","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"operazbo_view","offline":false,"page":1,"parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_ofrazionate","target":"_new","type":"SPLinker","w":137,"x":781,"y":-66});
this.operazbo_view.m_cID='<%=JSPLib.cmdHash("entity,armt_ofrazionate",request.getSession())%>';
this.button12=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button button12_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_button12","edit_undercond":"","font":"Verdana","font_color":"#000000","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"button12","page":1,"spuid":"","tabindex":"","text":"Ricerca","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":309,"y":8,"zindex":"1"});
this.Conferma=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button Conferma_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Conferma","edit_undercond":"","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Conferma","page":1,"spuid":"","tabindex":"","text":"Collega","type":"Button","type_submit":"false","type_wizard":"","w":75,"x":641,"y":145,"zindex":"1"});
this.Label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label1","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label1,false,true)%>","type":"Label","w":61,"x":5,"y":11,"zindex":"1"});
this.Label2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label2,false,true)%>","type":"Label","w":47,"x":173,"y":11,"zindex":"1"});
this.Label3=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label3,false,true)%>","type":"Label","w":61,"x":5,"y":69,"zindex":"1"});
this.Label3_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label3_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label3_Copy,false,true)%>","type":"Label","w":65,"x":0,"y":147,"zindex":"1"});
this.Label3_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label3_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label3_Copy_Copy,false,true)%>","type":"Label","w":61,"x":5,"y":39,"zindex":"1"});
this.Label3_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label3_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label3_Copy_Copy_Copy,false,true)%>","type":"Label","w":103,"x":482,"y":6,"zindex":"1"});
this.ragsoc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"ragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragsoc,false,true)%>","w":501,"x":226,"y":66,"zerofilling":false,"zindex":"1","zoom":""});
this.descrap=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descrap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"descrap","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descrap,false,true)%>","w":427,"x":291,"y":37,"zerofilling":false,"zindex":"1","zoom":""});
this.codcol=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codcol","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Inserire il codice di collegamento delle operazioni selezionate","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"12","name":"codcol","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codcol,false,true)%>","w":106,"x":525,"y":146,"zerofilling":false,"zindex":"1","zoom":""});
this.a_data=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"a_data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=a_data%>","w":83,"x":217,"y":10,"zerofilling":false,"zindex":"2","zoom":""});
this.dadata=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dadata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dadata","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dadata%>","w":83,"x":67,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.label19=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label19","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label19","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label19,false,true)%>","type":"Label","w":125,"x":411,"y":147,"zindex":"1"});
this.opeValues=new ZtVWeb._VC(this,'opeValues',null,'character','<%=JSPLib.ToJSValue(opeValues,false,true)%>',false,false);
this.RTCollega=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_likfraz_save",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCollega","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCollega","offline":false,"page":1,"parms":"oValues=opeValues,pColleg=codcol,pTipo=tipope,pOper=w_IDOPER","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_likfraz_save","target":"","type":"SPLinker","w":124,"x":780,"y":-33});
this.RTCollega.m_cID='<%=JSPLib.cmdHash("routine,arfn_likfraz_save",request.getSession())%>';
this.tipope=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipope","dataobj_value":"","decrypt":false,"disabled":true,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"<%=tipope%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipope","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"3","textlist":"Normale,Multipla","type":"Combobox","typevar":"character","valuelist":"'0','2'","visible":true,"w":179,"x":67,"y":146,"zindex":"1"});
this.LinkZoom24=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom24","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_linkfraz_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":22,"hide":"false","image":"","intovars":"w_RAPPORTO,descrap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_linkfraz_portlet.jspLinkZoom24",request.getSession())%>","linkedField":"w_RAPPORTO","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom24","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":false,"table":"anarapbo","type":"LinkZoom","w":22,"x":266,"y":37,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Rapporti"),false,true)%>"});
this.LinkZoom25=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"linkoper_subjects","ctrlid":"<%=idPortlet%>_LinkZoom25","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_linkfraz_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":22,"hide":"false","image":"","intovars":"w_CONNES,ragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_linkfraz_portlet.jspLinkZoom25",request.getSession())%>","linkedField":"w_CONNES","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom25","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,linkoper_subjects",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":22,"x":198,"y":66,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.w_CONNESOPER=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"this.w_CONNESOPER.Value()","create_undercond":"","ctrlid":"<%=idPortlet%>_w_CONNESOPER","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_CONNESOPER","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_CONNESOPER,false,true)%>","w":129,"x":67,"y":93,"zerofilling":false,"zindex":"1","zoom":""});
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
<%if(request.getAttribute("pg_linkfraz_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_linkfraz_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_linkfraz_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.tipope.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_linkfraz',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_linkfraz');
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
sp.endPage("pg_linkfraz");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom25_Copy")) {
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
if (Library.eq(p_cControlName,"LinkZoom25_Copy_Copy")) {
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
if (Library.eq(p_cControlName,"LinkZoom24")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom25")) {
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
return null;
}/**/%>
<%! public String getJSPUID() { return "2465337483"; } %>