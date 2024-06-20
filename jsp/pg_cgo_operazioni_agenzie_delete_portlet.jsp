<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nfunction Ricerca_Click(){\n this.Query1.Query(); \n}\n\nfunction Uscita_Click(){\n this.BtnUscita.Link()\n}\n\nfunction CancellaOpe() {\n  if (confirm('Confermi la cancellazione?')) {\n    _esito=this.DeleteOpe.Link()\n    if (_esito=='OK') {\n      alert('Cancellazione eseguita correttamente')\n    } else {\n      alert('Cancellazione terminata con errori:' + _esito)      \n    }  \n    this.Query1.Query(); \n  }  \n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Operazioni Agenzie per Cancellazione\",true)\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @xcodloc }} \n{{ @xagenzia }} \n{{ @descazi }} \n{{ @LinkZoom17 }} \n{{ @tipogio }} \n{{ @Agenzia }} \n{{ @idticket }} \n{{ @agenzia }} \n{{ @Locale }} \n{{ @Uscita }} \n{{ @Ricerca }} \n{{ @TPG }} \n{{ @IDB }} \n{{ @Grid0 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"N° Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SNAINUMOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo gioco\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPOGIOCO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"n. Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"C\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"IDDIP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"LOC\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODLOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Sorgente\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SORGENTE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"20\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:CancellaOpe()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fGIF\u002f126.gif:Cancella Operazione\",\"fg_color\":\"\",\"width\":\"20\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,C,C,N,C,C,C,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"556","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":96,\"w\":319,\"h\":556,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":96,\"w\":478,\"h\":556,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":77,\"w\":768,\"h\":556,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"77","zindex":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_agenzia=agenzia,w_idticket=idticket,w_tipogio=tipogio","parms_source":"","query":"qbe_operazioni_agenzia_no","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"1030","y":"4"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1000","name":"TipoGioco","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_tbtipgio","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"1030","y":"45"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":68,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":9,\"y\":68,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":3,\"y\":49,\"w\":61,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":17,\"y\":68,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"IDB","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ID Biglietto:","w":"61","wireframe_props":"align,value,n_col","x":"3","y":"49","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":115,\"y\":68,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":172,\"y\":68,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":266,\"y\":49,\"w\":60,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":368,\"y\":68,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"TPG","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Gioco:","w":"60","wireframe_props":"align,value,n_col","x":"266","y":"49","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":694,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":27,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Ricerca","page":"1","path_type":"","sequence":"6","server_side":"","spuid":"","src":"..\u002fimages\u002fsearch.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"694","y":"8","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":61,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":61,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":732,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":61,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Uscita","page":"1","path_type":"","sequence":"7","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"732","y":"8","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":184,\"y\":40,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":276,\"y\":40,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":441,\"y\":21,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":586,\"y\":40,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Locale","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ID Locale:","w":"50","wireframe_props":"align,value,n_col","x":"441","y":"21","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":28,\"y\":34,\"w\":16,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":42,\"y\":34,\"w\":24,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":67,\"y\":15,\"w\":38,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":89,\"y\":34,\"w\":\"54\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"agenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"38","wireframe_props":"name","x":"67","y":"15","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":28,\"y\":63,\"w\":73,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":42,\"y\":63,\"w\":109,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":67,\"y\":44,\"w\":175,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":89,\"y\":63,\"w\":\"234\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"idticket","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"175","wireframe_props":"name","x":"67","y":"44","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":38,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":9,\"y\":38,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":14,\"y\":19,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":17,\"y\":38,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Agenzia","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia:","w":"50","wireframe_props":"align,value,n_col","x":"14","y":"19","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"TipoGioco","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":137,\"y\":63,\"w\":77,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":205,\"y\":63,\"w\":115,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":328,\"y\":44,\"w\":184,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":438,\"y\":63,\"w\":\"247\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","name":"tipogio","page":"1","picture":"","sequence":"12","spuid":"","tabindex":"","textlist":"DESTPGIO","type":"Combobox","typevar":"character","valuelist":"CODTPGIO","visible":"true","w":"184","wireframe_props":"name,textlist","x":"328","y":"44","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"agenzia,descazi,xagenzia,xcodloc","keyfixedfilters":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":45,\"y\":34,\"w\":4,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":67,\"y\":34,\"w\":6,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":108,\"y\":15,\"w\":9,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":143,\"y\":34,\"w\":\"14\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","linkedField":"agenzia","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"13","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"9","wireframe_props":"","x":"108","y":"15","zindex":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":53,\"y\":34,\"w\":109,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":79,\"y\":34,\"w\":163,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":127,\"y\":15,\"w\":261,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":167,\"y\":34,\"w\":\"350\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"descazi","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"261","wireframe_props":"name","x":"127","y":"15","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":275,\"y\":67,\"w\":18,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":412,\"y\":67,\"w\":27,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":660,\"y\":48,\"w\":43,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":879,\"y\":67,\"w\":\"58\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xagenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"43","wireframe_props":"name","x":"660","y":"48","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":206,\"y\":35,\"w\":66,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":309,\"y\":35,\"w\":99,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":494,\"y\":16,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":657,\"y\":35,\"w\":\"212\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xcodloc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"158","wireframe_props":"name","x":"494","y":"16","zerofilling":"false","zindex":"1"},{"allowedentities":"arrt_snai_oper_load","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"SnaiOper","offline":"false","page":"1","parms":"pNumOpe=SNAINUMOPE,pFlgT=Z,pAgenzia=agenzia","popup":"true","popup_height":"725","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"","sequence":"17","servlet":"arrt_snai_oper_load","target":"_new","type":"SPLinker","w":"119","x":"1031","y":"86"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"start","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":"","refresh":"","sequence":"18","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"117","x":"1029","y":"123"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"snainumope","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"-3","y":"-63"},{"allowedentities":"arfn_cgo_delete_ope","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"DeleteOpe","offline":"false","page":"1","parms":"pOpe=snainumope,pTipo=_sorgente,pIDDOC=_iddoc,pCodDip=coddip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"20","servlet":"arfn_cgo_delete_ope","target":"","type":"SPLinker","w":"122","x":"1030","y":"163"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SORGENTE","h":"20","init":"","init_par":"","name":"_sorgente","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"162","y":"-62"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDDOCALL","h":"20","init":"","init_par":"","name":"_iddoc","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"318","y":"-59"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CODDIPE","h":"20","init":"","init_par":"","name":"coddip","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"818","y":"-2"}]%>
<%/*Description:*/%>
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
window.pg_cgo_operazioni_agenzie_delete_Static=function(){
if(typeof Ricerca_Click !='undefined')this.Ricerca_Click=Ricerca_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof CancellaOpe !='undefined')this.CancellaOpe=CancellaOpe;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.TipoGioco.addRowConsumer(this.tipogio);
this.LinkZoom17.addObserverFixedVars();
this.Query1.addDataConsumer(this.snainumope,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
this.Query1.addDataConsumer(this._sorgente,<%=JSPLib.ToJSValue("SORGENTE",true)%>);
this.Query1.addDataConsumer(this._iddoc,<%=JSPLib.ToJSValue("IDDOCALL",true)%>);
this.Query1.addDataConsumer(this.coddip,<%=JSPLib.ToJSValue("CODDIPE",true)%>);

function Ricerca_Click(){
 this.Query1.Query(); 
}
function Uscita_Click(){
 this.BtnUscita.Link()
}
function CancellaOpe() {
  if (confirm('Confermi la cancellazione?')) {
    _esito=this.DeleteOpe.Link()
    if (_esito=='OK') {
      alert('Cancellazione eseguita correttamente')
    } else {
      alert('Cancellazione terminata con errori:' + _esito)      
    }  
    this.Query1.Query(); 
  }  
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Operazioni Agenzie per Cancellazione",true)
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
.pg_cgo_operazioni_agenzie_delete_container {
}
.pg_cgo_operazioni_agenzie_delete_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_delete_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:96px;
  left:1px;
  left:0.3125%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:556px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:96px;
  left:1px;
  left:0.20833333%;
  right:1px;
  right:0.20833333%;
  width:auto;
  height:auto;
  min-height:556px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:77px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:556px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .IDB_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:68px;
  left:6px;
  left:1.875%;
  right:293px;
  right:91.5625%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .IDB_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .IDB_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:68px;
  left:9px;
  left:1.875%;
  right:440px;
  right:91.666664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .IDB_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .IDB_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:3px;
  left:0.390625%;
  right:704px;
  right:91.666664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .IDB_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .IDB_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="1024"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .TPG_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:68px;
  left:115px;
  left:35.9375%;
  right:184px;
  right:57.5%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .TPG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .TPG_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:68px;
  left:172px;
  left:35.833332%;
  right:277px;
  right:57.708332%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .TPG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .TPG_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:266px;
  left:34.635418%;
  right:442px;
  right:57.552082%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .TPG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .TPG_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="1024"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:44px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .Ricerca_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="1024"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="1024"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Uscita_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Uscita_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:184px;
  left:57.5%;
  right:115px;
  right:35.9375%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:276px;
  left:57.5%;
  right:173px;
  right:36.041668%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:21px;
  left:441px;
  left:57.421875%;
  right:277px;
  right:36.067707%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .Locale_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="1024"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:28px;
  left:8.75%;
  right:276px;
  right:86.25%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:42px;
  left:8.75%;
  right:414px;
  right:86.25%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:67px;
  left:8.723958%;
  right:663px;
  right:86.328125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .agenzia_ctrl {
}
.pg_cgo_operazioni_agenzie_delete_portlet > .agenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .idticket_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:28px;
  left:8.75%;
  right:219px;
  right:68.4375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .idticket_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:42px;
  left:8.75%;
  right:329px;
  right:68.541664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .idticket_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:67px;
  left:8.723958%;
  right:526px;
  right:68.489586%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .idticket_ctrl {
}
.pg_cgo_operazioni_agenzie_delete_portlet > .idticket_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:6px;
  left:1.875%;
  right:293px;
  right:91.5625%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:9px;
  left:1.875%;
  right:440px;
  right:91.666664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:19px;
  left:14px;
  left:1.8229166%;
  right:704px;
  right:91.666664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .Agenzia_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="1024"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .tipogio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:137px;
  left:42.8125%;
  right:106px;
  right:33.125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .tipogio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:205px;
  left:42.708332%;
  right:160px;
  right:33.333332%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .tipogio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:328px;
  left:42.708332%;
  right:256px;
  right:33.333332%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:45px;
  left:14.0625%;
  right:271px;
  right:84.6875%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:67px;
  left:13.958333%;
  right:407px;
  right:84.791664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:108px;
  left:14.0625%;
  right:651px;
  right:84.765625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:53px;
  left:16.5625%;
  right:158px;
  right:49.375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:79px;
  left:16.458334%;
  right:238px;
  right:49.583332%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:127px;
  left:16.536459%;
  right:380px;
  right:49.479168%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .descazi_ctrl {
}
.pg_cgo_operazioni_agenzie_delete_portlet > .descazi_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .xagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:67px;
  left:275px;
  left:85.9375%;
  right:27px;
  right:8.4375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .xagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:67px;
  left:412px;
  left:85.833336%;
  right:41px;
  right:8.541667%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .xagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:660px;
  left:85.9375%;
  right:65px;
  right:8.463542%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .xagenzia_ctrl {
  display:none;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .xagenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="320"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:206px;
  left:64.375%;
  right:48px;
  right:15.0%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="480"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:309px;
  left:64.375%;
  right:72px;
  right:15.0%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet[Data-step="768"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:494px;
  left:64.322914%;
  right:116px;
  right:15.104167%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_delete_portlet > .xcodloc_ctrl {
}
.pg_cgo_operazioni_agenzie_delete_portlet > .xcodloc_ctrl > input{
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Operazione\"},{\"title\":\"Tipo gioco\"},{\"title\":\"n. Ticket\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Agenzia\"},{\"title\":\"LOC\"},{\"title\":\"Sorgente\"},{\"title\":\"\"}],\"h\":\"556\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":556,\"hide\":\"false\",\"w\":319,\"x\":1,\"y\":96},\"480\":{\"anchor\":\" \",\"h\":556,\"hide\":\"false\",\"w\":478,\"x\":1,\"y\":96},\"768\":{\"anchor\":\"\",\"h\":556,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":77}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"77\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1030\",\"y\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1030\",\"y\":\"45\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":17,\"y\":68},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":6,\"y\":68},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":9,\"y\":68},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":61,\"x\":3,\"y\":49}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Biglietto:\",\"w\":\"61\",\"x\":\"3\",\"y\":\"49\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":368,\"y\":68},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":115,\"y\":68},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":172,\"y\":68},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":60,\"x\":266,\"y\":49}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":\"60\",\"x\":\"266\",\"y\":\"49\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":27},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":694,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"694\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":61},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":61},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":61},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":732,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"732\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":586,\"y\":40},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":184,\"y\":40},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":276,\"y\":40},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":441,\"y\":21}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Locale:\",\"w\":\"50\",\"x\":\"441\",\"y\":\"21\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"54\",\"x\":89,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":16,\"x\":28,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":24,\"x\":42,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":38,\"x\":67,\"y\":15}},\"name\":\"agenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"38\",\"x\":\"67\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"234\",\"x\":89,\"y\":63},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":73,\"x\":28,\"y\":63},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":109,\"x\":42,\"y\":63},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":175,\"x\":67,\"y\":44}},\"name\":\"idticket\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"175\",\"x\":\"67\",\"y\":\"44\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":17,\"y\":38},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":6,\"y\":38},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":9,\"y\":38},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":14,\"y\":19}},\"n_col\":\"1\",\"name\":\"Agenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"50\",\"x\":\"14\",\"y\":\"19\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"247\",\"x\":438,\"y\":63},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":77,\"x\":137,\"y\":63},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":115,\"x\":205,\"y\":63},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":184,\"x\":328,\"y\":44}},\"name\":\"tipogio\",\"page\":\"1\",\"textlist\":\"DESTPGIO\",\"type\":\"Combobox\",\"w\":\"184\",\"x\":\"328\",\"y\":\"44\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"14\",\"x\":143,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":4,\"x\":45,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":6,\"x\":67,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":9,\"x\":108,\"y\":15}},\"name\":\"LinkZoom17\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"9\",\"x\":\"108\",\"y\":\"15\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"350\",\"x\":167,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":109,\"x\":53,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":163,\"x\":79,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":261,\"x\":127,\"y\":15}},\"name\":\"descazi\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"261\",\"x\":\"127\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"58\",\"x\":879,\"y\":67},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":18,\"x\":275,\"y\":67},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":27,\"x\":412,\"y\":67},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":43,\"x\":660,\"y\":48}},\"name\":\"xagenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"43\",\"x\":\"660\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"212\",\"x\":657,\"y\":35},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":66,\"x\":206,\"y\":35},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":99,\"x\":309,\"y\":35},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":158,\"x\":494,\"y\":16}},\"name\":\"xcodloc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"158\",\"x\":\"494\",\"y\":\"16\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"SnaiOper\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"119\",\"x\":\"1031\",\"y\":\"86\"},{\"h\":\"30\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"117\",\"x\":\"1029\",\"y\":\"123\"},{\"h\":\"20\",\"name\":\"snainumope\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"-3\",\"y\":\"-63\"},{\"h\":\"30\",\"name\":\"DeleteOpe\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"122\",\"x\":\"1030\",\"y\":\"163\"},{\"h\":\"20\",\"name\":\"_sorgente\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"162\",\"y\":\"-62\"},{\"h\":\"20\",\"name\":\"_iddoc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"318\",\"y\":\"-59\"},{\"h\":\"20\",\"name\":\"coddip\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"818\",\"y\":\"-2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_delete","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_delete_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_delete','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_delete_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String IDB= "ID Biglietto:";
String TPG= "Tipo Gioco:";
String Locale= "ID Locale:";
String agenzia= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_delete_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String idticket= "";
String Agenzia= "Agenzia:";
String tipogio= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_delete_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String descazi= "";
String xagenzia= "";
String xcodloc= "";
String snainumope= "";
String _sorgente= "";
String _iddoc= "";
String coddip= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_delete_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_delete_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_delete_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_delete','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_IDB'  formid='<%=idPortlet%>' ps-name='IDB'    class='label IDB_ctrl'><div id='<%=idPortlet%>_IDBtbl' style='width:100%;'><%=JSPLib.ToHTML("ID Biglietto:")%></div></span>
<span id='<%=idPortlet%>_TPG'  formid='<%=idPortlet%>' ps-name='TPG'    class='label TPG_ctrl'><div id='<%=idPortlet%>_TPGtbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Gioco:")%></div></span>
<a id='<%=idPortlet%>_Ricerca' class='image Ricerca_ctrl'   target=''>&#xea19;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<span id='<%=idPortlet%>_Locale'  formid='<%=idPortlet%>' ps-name='Locale'    class='label Locale_ctrl'><div id='<%=idPortlet%>_Localetbl' style='width:100%;'><%=JSPLib.ToHTML("ID Locale:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_agenzia_wrp'><input id='<%=idPortlet%>_agenzia' name='agenzia' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='agenzia' /></span>
<span class='textbox-container'id='<%=idPortlet%>_idticket_wrp'><input id='<%=idPortlet%>_idticket' name='idticket' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='idticket' /></span>
<span id='<%=idPortlet%>_Agenzia'  formid='<%=idPortlet%>' ps-name='Agenzia'    class='label Agenzia_ctrl'><div id='<%=idPortlet%>_Agenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<select id='<%=idPortlet%>_tipogio' name='tipogio' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descazi_wrp'><input id='<%=idPortlet%>_descazi' name='descazi' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descazi' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xagenzia_wrp'><input id='<%=idPortlet%>_xagenzia' name='xagenzia' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='xagenzia' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xcodloc_wrp'><input id='<%=idPortlet%>_xcodloc' name='xcodloc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='xcodloc' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_delete');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_delete',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":556,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":556,"hide":"false","w":319,"x":1,"y":96},"480":{"anchor":" ","h":556,"hide":"false","w":478,"x":1,"y":96},"768":{"anchor":"","h":556,"hide":"false","w":768,"x":0,"y":77}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":77,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Oper.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"N° Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SNAINUMOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo gioco","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPOGIOCO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"n. Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"C","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"IDDIP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"LOC","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODLOC","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Sorgente","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SORGENTE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"20","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:CancellaOpe()","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fGIF\u002f126.gif:Cancella Operazione","fg_color":"","width":"20","RowSpan":0,"extensible":false}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_operazioni_agenzia_no","cmdHash":"<%=JSPLib.cmdHash("qbe_operazioni_agenzia_no",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_agenzia=agenzia,w_idticket=idticket,w_tipogio=tipogio","parms_source":"","type":"SQLDataobj","w":120,"x":1030,"y":4});
this.TipoGioco=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_tbtipgio","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_tbtipgio",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_TipoGioco","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"TipoGioco","nrows":"1000","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":1030,"y":45});
this.IDB=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_IDB","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":17,"y":68},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":6,"y":68},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":9,"y":68},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":61,"x":3,"y":49}},"n_col":1,"name":"IDB","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(IDB,false,true)%>","type":"Label","w":61,"x":3,"y":49,"zindex":"1"});
this.TPG=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_TPG","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":368,"y":68},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":115,"y":68},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":172,"y":68},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":60,"x":266,"y":49}},"n_col":1,"name":"TPG","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(TPG,false,true)%>","type":"Label","w":60,"x":266,"y":49,"zindex":"1"});
this.Ricerca=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Ricerca_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Ricerca","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":27},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":27},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":694,"y":8}},"name":"Ricerca","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea19;","srchover":"&#xea1a;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":694,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":61},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":61},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":61},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":732,"y":8}},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":732,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Locale=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Locale","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":586,"y":40},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":184,"y":40},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":276,"y":40},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":441,"y":21}},"n_col":1,"name":"Locale","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Locale,false,true)%>","type":"Label","w":50,"x":441,"y":21,"zindex":"1"});
this.agenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_agenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"54","x":89,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":16,"x":28,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":24,"x":42,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":38,"x":67,"y":15}},"maxlength":"","name":"agenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(agenzia,false,true)%>","w":38,"x":67,"y":15,"zerofilling":false,"zindex":"1","zoom":""});
this.idticket=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_idticket","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"234","x":89,"y":63},"320":{"anchor":" ","h":20,"hide":"false","w":73,"x":28,"y":63},"480":{"anchor":" ","h":20,"hide":"false","w":109,"x":42,"y":63},"768":{"anchor":"","h":20,"hide":"false","w":175,"x":67,"y":44}},"maxlength":"","name":"idticket","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(idticket,false,true)%>","w":175,"x":67,"y":44,"zerofilling":false,"zindex":"1","zoom":""});
this.Agenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Agenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":17,"y":38},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":6,"y":38},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":9,"y":38},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":14,"y":19}},"n_col":1,"name":"Agenzia","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Agenzia,false,true)%>","type":"Label","w":50,"x":14,"y":19,"zindex":"1"});
this.tipogio=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipogio","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipogio%>","isdatap":true,"layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"247","x":438,"y":63},"320":{"anchor":" ","h":20,"hide":"false","w":77,"x":137,"y":63},"480":{"anchor":" ","h":20,"hide":"false","w":115,"x":205,"y":63},"768":{"anchor":"","h":20,"hide":"false","w":184,"x":328,"y":44}},"name":"tipogio","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"DESTPGIO","type":"Combobox","typevar":"character","valuelist":"CODTPGIO","visible":true,"w":184,"x":328,"y":44,"zindex":"1"});
this.LinkZoom17=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_cgo_operazioni_agenzie_delete_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"agenzia,descazi,xagenzia,xcodloc","intovarsType":"C,C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"14","x":143,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":4,"x":45,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":6,"x":67,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":9,"x":108,"y":15}},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_cgo_operazioni_agenzie_delete_portlet.jspLinkZoom17",request.getSession())%>","linkedField":"agenzia","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":9,"x":108,"y":15,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descazi=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descazi","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"350","x":167,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":109,"x":53,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":163,"x":79,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":261,"x":127,"y":15}},"maxlength":"","name":"descazi","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descazi,false,true)%>","w":261,"x":127,"y":15,"zerofilling":false,"zindex":"1","zoom":""});
this.xagenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xagenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"58","x":879,"y":67},"320":{"anchor":" ","h":20,"hide":"false","w":18,"x":275,"y":67},"480":{"anchor":" ","h":20,"hide":"false","w":27,"x":412,"y":67},"768":{"anchor":"","h":20,"hide":"false","w":43,"x":660,"y":48}},"maxlength":"","name":"xagenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xagenzia,false,true)%>","w":43,"x":660,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.xcodloc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xcodloc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"212","x":657,"y":35},"320":{"anchor":" ","h":20,"hide":"false","w":66,"x":206,"y":35},"480":{"anchor":" ","h":20,"hide":"false","w":99,"x":309,"y":35},"768":{"anchor":"","h":20,"hide":"false","w":158,"x":494,"y":16}},"maxlength":"","name":"xcodloc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xcodloc,false,true)%>","w":158,"x":494,"y":16,"zerofilling":false,"zindex":"1","zoom":""});
this.SnaiOper=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_snai_oper_load",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SnaiOper","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SnaiOper","offline":false,"page":1,"parms":"pNumOpe=SNAINUMOPE,pFlgT=Z,pAgenzia=agenzia","popup":"true","popup_height":"725","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"","servlet":"arrt_snai_oper_load","target":"_new","type":"SPLinker","w":119,"x":1031,"y":86});
this.SnaiOper.m_cID='<%=JSPLib.cmdHash("routine,arrt_snai_oper_load",request.getSession())%>';
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":117,"x":1029,"y":123});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.snainumope=new ZtVWeb._VC(this,'snainumope',null,'character','<%=JSPLib.ToJSValue(snainumope,false,true)%>',false,false);
this.DeleteOpe=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_cgo_delete_ope",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DeleteOpe","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DeleteOpe","offline":false,"page":1,"parms":"pOpe=snainumope,pTipo=_sorgente,pIDDOC=_iddoc,pCodDip=coddip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_cgo_delete_ope","target":"","type":"SPLinker","w":122,"x":1030,"y":163});
this.DeleteOpe.m_cID='<%=JSPLib.cmdHash("routine,arfn_cgo_delete_ope",request.getSession())%>';
this._sorgente=new ZtVWeb._VC(this,'_sorgente',null,'character','<%=JSPLib.ToJSValue(_sorgente,false,true)%>',false,false);
this._iddoc=new ZtVWeb._VC(this,'_iddoc',null,'character','<%=JSPLib.ToJSValue(_iddoc,false,true)%>',false,false);
this.coddip=new ZtVWeb._VC(this,'coddip',null,'character','<%=JSPLib.ToJSValue(coddip,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_delete_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_delete_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_delete_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Ricerca.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.TipoGioco.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_delete',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_delete');
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
sp.endPage("pg_cgo_operazioni_agenzie_delete");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom17")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ", "IDBASE", "CODLOC"};
  result.m_rdTypes = new String[]{"C", "C", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "2127149016"; } %>