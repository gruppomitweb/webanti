<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Grid0_AfterRowChange(currRecIdx,prevRecIdx){\n  if (Empty(this.Grid0.RowValue(\"CGOESICON\"))) {\n    this.cEsitoCon.Value(0);    \n  } else {  \n    this.cEsitoCon.Value(this.Grid0.RowValue(\"CGOESICON\"));\n  }  \n}\n\nfunction Ricerca_Click(){\n this.Query1.Query();\n this.Grid0.Refresh() \n if (Empty(this.Grid0.RowValue(\"CGOESICON\"))) {\n   this.cEsitoCon.Value(0);    \n } else {  \n   this.cEsitoCon.Value(this.Grid0.RowValue(\"CGOESICON\"));\n }   \n}\n\nfunction Uscita_Click(){\n this.BtnUscita.Link()\n}\n\nfunction Ricevente() {\n  this.Query1.Query();\n}\n\nfunction Excel_Click(){\n  this.EstrazioneExcel.Link()\n}\n\nfunction Salva_Click() {\n  if (Empty(this.cEsitoCon.Value()) && !Empty(this.mcNote.Value())) {\n       alert(\"Selezionare un esito contatto prima di salvare i dati !\") \n  } else {\n      if (confirm(\"Confermi il salvataggio dei dati ?\")) {\n        pippo=this.SalvaContatto.Link();\n        alert('Dati salvati correttamente!') ;\n        this.Grid0.Refresh(true);\n        \u002f\u002f this.Query1.Query(); \n       }\n \t}  \n}\n\nfunction this_Loaded(){\n this.getTitlePortlet().SetTitle(\"Operazioni Agenzie da Completare\",true);\n this.cEsitoCon.Value(this.Grid0.RowValue(\"CGOESICON\",0));\n}\n\nfunction lblAll_Click(){\n  if (this.cbAll.Value()='N') {\n    this.cbAll.Value('S')\n  } else {\n    this.cbAll.Value('N')    \n  }  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"\n{{ @Calendario45 }}\n{{ @cCodLoc }}\n{{ @cbAll }}\n{{ @dDataCon }}\n{{ @lblLocale }}\n{{ @Telefono }}\n{{ @telagenzia }}\n{{ @descage }}\n{{ @desccau }}\n{{ @lbldContatto }}\n{{ @label27_Copy }}\n{{ @label27 }}\n{{ @agente }}\n{{ @causale }}\n{{ @Note }}\n{{ @mcNote }}\n{{ @xcodloc }}\n{{ @xagenzia }}\n{{ @descazi }}\n{{ @LinkZoom17 }}\n{{ @cEsitoCon }}\n{{ @tipogio }}\n{{ @Agenzia }}\n{{ @idticket }}\n{{ @agenzia }}\n{{ @Locale }}\n{{ @Excel }}\n{{ @Uscita }}\n{{ @Salva }}\n{{ @Ricerca }}\n{{ @lblcEsitoCon }}\n{{ @TPG }}\n{{ @IDB }}\n{{ @Grid0 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"height\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:SnaiOper\",\"weight\":\"\",\"title\":\"N° Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SNAINUMOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo gioco\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPOGIOCO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"N\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Giorni\",\"type\":\"N\",\"align\":\"center\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"GIORNI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"center\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"IDDIP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"LOC\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODLOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Contatto\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CGODATCON\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Esito\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CGOESICON\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"ECDESCRI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,C,C,N,N,C,C,D,C,C","filters":"true-by-example","floatRows":"","font":"Tahoma","font_color":"","font_size":"","font_weight":"normal","group_repeated":"false","h":"436","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":96,\"w\":319,\"h\":436,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":96,\"w\":478,\"h\":436,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":1,\"y\":77,\"w\":765,\"h\":436,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"true","print_option":"default","print_result":"true","print_size":"","print_title":"Operazioni da Completare","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"765","wireframe_props":"colProperties,checkbox,rows","x":"1","y":"77","zindex":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"15","name":"Query1","offline":"false","page":"1","parms":"w_agenzia=agenzia,w_idticket=idticket,w_tipogio=tipogio","parms_source":"","query":"qbe_cgo_operazioni_agenzia_admin","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"1030","y":"4"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1000","name":"TipoGioco","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_tbtipgio","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"1030","y":"45"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1000","name":"EsitiCon","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_esiticon","query_async":"false","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"120","x":"1074","y":"5"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":68,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":9,\"y\":68,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":0,\"y\":49,\"w\":63,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":17,\"y\":68,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"IDB","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ID Biglietto:","w":"63","wireframe_props":"align,value,n_col","x":"0","y":"49","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":115,\"y\":68,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":172,\"y\":68,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":276,\"y\":49,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":368,\"y\":68,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"TPG","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Gioco:","w":"50","wireframe_props":"align,value,n_col","x":"276","y":"49","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":59,\"y\":549,\"w\":28,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":88,\"y\":549,\"w\":42,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":157,\"y\":530,\"w\":67,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":186,\"y\":549,\"w\":\"92\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"lblcEsitoCon","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Esito Contatto:","w":"67","wireframe_props":"align,value,n_col","x":"157","y":"530","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per effettuare la ricerca","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":697,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":27,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Ricerca","page":"1","path_type":"","sequence":"8","server_side":"","spuid":"","src":"..\u002fimages\u002fsearch.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"697","y":"8","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Salva i dati del contatto","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":304,\"y\":589,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":456,\"y\":589,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":729,\"y\":570,\"w\":28,\"h\":30,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":972,\"y\":589,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Salva","page":"1","path_type":"","sequence":"9","server_side":"","spuid":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"28","wireframe_props":"","x":"729","y":"570","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":61,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":61,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":733,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":61,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Uscita","page":"1","path_type":"","sequence":"10","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"733","y":"8","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per produrre il file excel","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":291,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":436,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":661,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":929,\"y\":27,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Excel","page":"1","path_type":"","sequence":"11","server_side":"","spuid":"","src":"..\u002fimages\u002fexcel.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"661","y":"8","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":184,\"y\":40,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":276,\"y\":40,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":441,\"y\":21,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":586,\"y\":40,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Locale","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ID Locale:","w":"50","wireframe_props":"align,value,n_col","x":"441","y":"21","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"SalvaContatto","offline":"false","page":"1","parms":"pNumOpe=NumOpe,pDatCon=dDataCon,pEsiCon=cEsitoCon,pNotCon=mcNote,pAll=cbAll","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arrt_cgo_save_esiticon","target":"","type":"SPLinker","w":"181","x":"1037","y":"300"},{"calculate":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"NumOpe","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"558","y":"48"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":28,\"y\":34,\"w\":16,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":42,\"y\":34,\"w\":24,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":67,\"y\":15,\"w\":38,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":89,\"y\":34,\"w\":\"54\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"agenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"38","wireframe_props":"name","x":"67","y":"15","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":28,\"y\":63,\"w\":73,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":42,\"y\":63,\"w\":109,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":67,\"y\":44,\"w\":175,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":89,\"y\":63,\"w\":\"234\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"idticket","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"175","wireframe_props":"name","x":"67","y":"44","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":38,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":9,\"y\":38,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":14,\"y\":19,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":17,\"y\":38,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Agenzia","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia:","w":"50","wireframe_props":"align,value,n_col","x":"14","y":"19","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"TipoGioco","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":137,\"y\":63,\"w\":77,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":205,\"y\":63,\"w\":115,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":328,\"y\":44,\"w\":184,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":438,\"y\":63,\"w\":\"247\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","name":"tipogio","page":"1","picture":"","sequence":"18","spuid":"","tabindex":"","textlist":"DESTPGIO","type":"Combobox","typevar":"character","valuelist":"CODTPGIO","visible":"true","w":"184","wireframe_props":"name,textlist","x":"328","y":"44","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"EsitiCon","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":88,\"y\":545,\"w\":77,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":132,\"y\":545,\"w\":115,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":227,\"y\":526,\"w\":184,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":279,\"y\":545,\"w\":\"247\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","name":"cEsitoCon","page":"1","picture":"","sequence":"19","spuid":"","tabindex":"","textlist":"ECDESCRI","type":"Combobox","typevar":"character","valuelist":"ECCODICE","visible":"true","w":"184","wireframe_props":"name,textlist","x":"227","y":"526","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"agenzia,descazi,xagenzia,xcodloc","keyfixedfilters":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":45,\"y\":34,\"w\":4,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":67,\"y\":34,\"w\":6,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":108,\"y\":15,\"w\":9,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":143,\"y\":34,\"w\":\"14\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","linkedField":"agenzia","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"20","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"9","wireframe_props":"","x":"108","y":"15","zindex":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":53,\"y\":34,\"w\":109,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":79,\"y\":34,\"w\":163,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":127,\"y\":15,\"w\":261,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":167,\"y\":34,\"w\":\"350\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"descazi","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"21","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"261","wireframe_props":"name","x":"127","y":"15","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":275,\"y\":67,\"w\":18,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":412,\"y\":67,\"w\":27,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":660,\"y\":48,\"w\":43,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":879,\"y\":67,\"w\":\"58\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xagenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"22","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"43","wireframe_props":"name","x":"660","y":"48","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":206,\"y\":35,\"w\":66,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":309,\"y\":35,\"w\":99,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":494,\"y\":16,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":657,\"y\":35,\"w\":\"212\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xcodloc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"23","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"158","wireframe_props":"name","x":"494","y":"16","zerofilling":"false","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"SnaiOper","offline":"false","page":"1","parms":"pNumOpe=SNAINUMOPE,pFlgT=Z,pAgenzia=agenzia","popup":"true","popup_height":"725","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"","sequence":"24","servlet":"arrt_snai_oper_load","target":"_new","type":"SPLinker","w":"170","x":"1031","y":"86"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"start","name":"EsitoContatto","offline":"false","page":"1","parms":"NumOpe=SNAINUMOPE,dDataCon=mcDataCon,cEsitoCon=mcEsito,mNote=mcNote","popup":"true","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"760","progressbar":"","refresh":"","sequence":"25","servlet":"pg_cgo_contatto_portlet.jsp","target":"_new","type":"SPLinker","w":"173","x":"1030","y":"166"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"EstrazioneExcel","offline":"false","page":"1","parms":"pAgenzia=agenzia,pTicket=idticket,pTipGio=tipogio","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":"","refresh":"","sequence":"26","servlet":"arrt_cgo_operazioni_admin_xls","target":"","type":"SPLinker","w":"178","x":"1030","y":"209"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"start","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":"","refresh":"","sequence":"27","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"185","x":"1030","y":"254"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_snai_oper_savedEntity","objsValues":"this.Ricevente()","page":"1","parmsNames":"","sequence":"28","type":"EventReceiver","w":"167","x":"1034","y":"129"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CGONOTCON","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"52","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":32,\"y\":569,\"w\":267,\"h\":52,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":48,\"y\":569,\"w\":400,\"h\":52,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":76,\"y\":550,\"w\":640,\"h\":52,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":101,\"y\":569,\"w\":\"856\",\"h\":52,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"mcNote","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"true","sequence":"29","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"memo","visible":"true","w":"640","wireframe_props":"name","x":"76","y":"550","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":-1,\"y\":572,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":-1,\"y\":572,\"w\":46,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":0,\"y\":553,\"w\":74,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":-2,\"y\":572,\"w\":\"101\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Note","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Note Contatto:","w":"74","wireframe_props":"align,value,n_col","x":"0","y":"553","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CACODICE","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":32,\"y\":625,\"w\":11,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":48,\"y\":625,\"w\":16,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":76,\"y\":606,\"w\":26,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":102,\"y\":625,\"w\":\"36\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"3","name":"causale","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"31","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"26","wireframe_props":"name","x":"76","y":"606","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"IDDIP","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":32,\"y\":650,\"w\":16,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":48,\"y\":650,\"w\":24,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":76,\"y\":631,\"w\":38,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":102,\"y\":650,\"w\":\"54\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"3","name":"agente","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"32","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"38","wireframe_props":"name","x":"76","y":"631","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":5,\"y\":630,\"w\":26,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":7,\"y\":630,\"w\":39,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":0,\"y\":611,\"w\":74,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":13,\"y\":630,\"w\":\"85\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"label27","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"33","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Biglietto:","w":"74","wireframe_props":"align,value,n_col","x":"0","y":"611","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":15,\"y\":655,\"w\":16,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":22,\"y\":655,\"w\":24,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":14,\"y\":637,\"w\":60,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":45,\"y\":655,\"w\":\"53\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"label27_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"34","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia:","w":"60","wireframe_props":"align,value,n_col","x":"14","y":"637","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":5,\"y\":549,\"w\":26,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":7,\"y\":549,\"w\":39,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":0,\"y\":530,\"w\":74,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":13,\"y\":549,\"w\":\"86\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"lbldContatto","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"35","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Contatto:","w":"74","wireframe_props":"align,value,n_col","x":"0","y":"530","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TRDESREG","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":45,\"y\":625,\"w\":117,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":67,\"y\":625,\"w\":175,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":108,\"y\":606,\"w\":280,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":144,\"y\":625,\"w\":\"375\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"50","name":"desccau","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"36","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"280","wireframe_props":"name","x":"108","y":"606","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DESCRIZ","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":50,\"y\":650,\"w\":105,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":75,\"y\":650,\"w\":157,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":120,\"y\":631,\"w\":252,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":160,\"y\":650,\"w\":\"336\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"50","name":"descage","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"37","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"252","wireframe_props":"name","x":"120","y":"631","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TELEFONO","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":166,\"y\":650,\"w\":37,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":249,\"y\":650,\"w\":55,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":398,\"y\":631,\"w\":88,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":529,\"y\":650,\"w\":\"119\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"telagenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"38","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"88","wireframe_props":"name","x":"398","y":"631","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":155,\"y\":655,\"w\":9,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":232,\"y\":655,\"w\":13,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":372,\"y\":637,\"w\":21,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":495,\"y\":655,\"w\":\"29\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Telefono","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tel.:","w":"21","wireframe_props":"align,value,n_col","x":"372","y":"637","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":208,\"y\":655,\"w\":20,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":312,\"y\":655,\"w\":30,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":493,\"y\":637,\"w\":66,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":665,\"y\":655,\"w\":\"64\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"lblLocale","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"40","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice LOC:","w":"66","wireframe_props":"align,value,n_col","x":"493","y":"637","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CGODATCON","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":32,\"y\":545,\"w\":23,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":48,\"y\":545,\"w\":34,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":76,\"y\":526,\"w\":55,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":101,\"y\":545,\"w\":\"75\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"10","name":"dDataCon","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"41","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"55","wireframe_props":"name","x":"76","y":"526","zerofilling":"false","zindex":"1"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","dataobj":"","edit_undercond":"","field":"","h":"23","help_tips":"Aggiorna tutte le operazioni dell'agenzia","hide":"false","hide_undercond":"","init":"false","init_par":"S","label_text":"Aggiorna tutte le operazioni dell'agenzia","layer":"false","layout_steps_values":"{\"320\":{\"x\":172,\"y\":543,\"w\":4,\"h\":13,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":258,\"y\":543,\"w\":6,\"h\":13,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":428,\"y\":524,\"w\":310,\"h\":23,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":550,\"y\":543,\"w\":\"13\",\"h\":13,\"anchor\":\" \",\"hide\":\"false\"}}","name":"cbAll","page":"1","sequence":"42","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"310","wireframe_props":"label_text","x":"428","y":"524","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CODLOC","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":229,\"y\":650,\"w\":70,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":343,\"y\":650,\"w\":105,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":563,\"y\":631,\"w\":168,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":730,\"y\":650,\"w\":\"225\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"30","name":"cCodLoc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"43","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"168","wireframe_props":"name","x":"563","y":"631","zerofilling":"false","zindex":"1"},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":56,\"y\":545,\"w\":6,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":84,\"y\":545,\"w\":9,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":134,\"y\":526,\"w\":14,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":178,\"y\":545,\"w\":\"20\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Calendario45","page":"1","popup":"true","return_input":"dDataCon","sequence":"44","spuid":"","type":"Calendario","w":"14","wireframe_props":"","x":"134","y":"526","zindex":""}]%>
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
window.pg_cgo_operazioni_agenzie_admin_Static=function(){
if(typeof Grid0_AfterRowChange !='undefined')this.Grid0_AfterRowChange=Grid0_AfterRowChange;
if(typeof Ricerca_Click !='undefined')this.Ricerca_Click=Ricerca_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof Ricevente !='undefined')this.Ricevente=Ricevente;
if(typeof Excel_Click !='undefined')this.Excel_Click=Excel_Click;
if(typeof Salva_Click !='undefined')this.Salva_Click=Salva_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof lblAll_Click !='undefined')this.lblAll_Click=lblAll_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.NumOpe,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
this.TipoGioco.addRowConsumer(this.tipogio);
this.EsitiCon.addRowConsumer(this.cEsitoCon);
this.LinkZoom17.addObserverFixedVars();
this.Query1.addDataConsumer(this.mcNote,<%=JSPLib.ToJSValue("CGONOTCON",true)%>);
this.Query1.addDataConsumer(this.causale,<%=JSPLib.ToJSValue("CACODICE",true)%>);
this.Query1.addDataConsumer(this.agente,<%=JSPLib.ToJSValue("IDDIP",true)%>);
this.Query1.addDataConsumer(this.desccau,<%=JSPLib.ToJSValue("TRDESREG",true)%>);
this.Query1.addDataConsumer(this.descage,<%=JSPLib.ToJSValue("DESCRIZ",true)%>);
this.Query1.addDataConsumer(this.telagenzia,<%=JSPLib.ToJSValue("TELEFONO",true)%>);
this.Query1.addDataConsumer(this.dDataCon,<%=JSPLib.ToJSValue("CGODATCON",true)%>);
this.Query1.addDataConsumer(this.cCodLoc,<%=JSPLib.ToJSValue("CODLOC",true)%>);
function Grid0_AfterRowChange(currRecIdx,prevRecIdx){
  if (Empty(this.Grid0.RowValue("CGOESICON"))) {
    this.cEsitoCon.Value(0);    
  } else {  
    this.cEsitoCon.Value(this.Grid0.RowValue("CGOESICON"));
  }  
}
function Ricerca_Click(){
 this.Query1.Query();
 this.Grid0.Refresh() 
 if (Empty(this.Grid0.RowValue("CGOESICON"))) {
   this.cEsitoCon.Value(0);    
 } else {  
   this.cEsitoCon.Value(this.Grid0.RowValue("CGOESICON"));
 }   
}
function Uscita_Click(){
 this.BtnUscita.Link()
}
function Ricevente() {
  this.Query1.Query();
}
function Excel_Click(){
  this.EstrazioneExcel.Link()
}
function Salva_Click() {
  if (Empty(this.cEsitoCon.Value()) && !Empty(this.mcNote.Value())) {
       alert("Selezionare un esito contatto prima di salvare i dati !") 
  } else {
      if (confirm("Confermi il salvataggio dei dati ?")) {
        pippo=this.SalvaContatto.Link();
        alert('Dati salvati correttamente!') ;
        this.Grid0.Refresh(true);
        // this.Query1.Query(); 
       }
 	}  
}
function this_Loaded(){
 this.getTitlePortlet().SetTitle("Operazioni Agenzie da Completare",true);
 this.cEsitoCon.Value(this.Grid0.RowValue("CGOESICON",0));
}
function lblAll_Click(){
  if (this.cbAll.Value()='N') {
    this.cbAll.Value('S')
  } else {
    this.cbAll.Value('N')    
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
.pg_cgo_operazioni_agenzie_admin_container {
}
.pg_cgo_operazioni_agenzie_admin_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_admin_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Grid0_ctrl {
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
  min-height:436px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Grid0_ctrl {
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
  min-height:436px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:77px;
  left:1px;
  left:0.13020833%;
  right:2px;
  right:0.26041666%;
  width:auto;
  height:auto;
  min-height:436px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .IDB_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .IDB_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .IDB_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .IDB_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .IDB_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:0px;
  left:0.0%;
  right:705px;
  right:91.796875%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .IDB_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .IDB_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .IDB_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .TPG_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .TPG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .TPG_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .TPG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .TPG_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:276px;
  left:35.9375%;
  right:442px;
  right:57.552082%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .TPG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .TPG_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .TPG_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lblcEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:549px;
  left:59px;
  left:18.4375%;
  right:233px;
  right:72.8125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lblcEsitoCon_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lblcEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:549px;
  left:88px;
  left:18.333334%;
  right:350px;
  right:72.916664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lblcEsitoCon_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lblcEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:530px;
  left:157px;
  left:20.442709%;
  right:544px;
  right:70.833336%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lblcEsitoCon_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .lblcEsitoCon_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .lblcEsitoCon_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lblcEsitoCon_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lblcEsitoCon_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lblcEsitoCon_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Ricerca_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Ricerca_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:41px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Ricerca_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Salva_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:589px;
  left:304px;
  left:95.0%;
  right:4px;
  right:1.25%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Salva_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:589px;
  left:456px;
  left:95.0%;
  right:6px;
  right:1.25%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Salva_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:570px;
  left:729px;
  left:94.921875%;
  right:11px;
  right:1.4322916%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Salva_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:28px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Salva_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Salva_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Salva_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Salva_ctrl {
  line-height:30px;
  font-size:28px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Uscita_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Uscita_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:5px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Uscita_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Uscita_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:291px;
  left:90.9375%;
  right:17px;
  right:5.3125%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:436px;
  left:90.833336%;
  right:26px;
  right:5.4166665%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:77px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Excel_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Excel_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Excel_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Excel_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Excel_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Locale_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Locale_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Locale_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Locale_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .agenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .agenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .agenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet > .agenzia_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .agenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .idticket_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .idticket_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .idticket_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet > .idticket_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .idticket_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Agenzia_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Agenzia_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Agenzia_ctrl {
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
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Agenzia_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .tipogio_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .tipogio_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .tipogio_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .cEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:545px;
  left:88px;
  left:27.5%;
  right:155px;
  right:48.4375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .cEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:545px;
  left:132px;
  left:27.5%;
  right:233px;
  right:48.541668%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .cEsitoCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  left:227px;
  left:29.557291%;
  right:357px;
  right:46.484375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .LinkZoom17_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .LinkZoom17_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .LinkZoom17_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .descazi_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .descazi_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .descazi_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet > .descazi_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .descazi_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .xagenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .xagenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .xagenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet > .xagenzia_ctrl {
  display:none;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .xagenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .xcodloc_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .xcodloc_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .xcodloc_ctrl {
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
.pg_cgo_operazioni_agenzie_admin_portlet > .xcodloc_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .xcodloc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .mcNote_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:569px;
  left:32px;
  left:10.0%;
  right:21px;
  right:6.5625%;
  width:auto;
  height:52px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .mcNote_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:569px;
  left:48px;
  left:10.0%;
  right:32px;
  right:6.6666665%;
  width:auto;
  height:52px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .mcNote_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:550px;
  left:76px;
  left:9.895833%;
  right:52px;
  right:6.7708335%;
  width:auto;
  height:52px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .mcNote_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .mcNote_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Note_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:572px;
  left:-1px;
  left:-0.3125%;
  right:290px;
  right:90.625%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Note_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Note_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:572px;
  left:-1px;
  left:-0.20833333%;
  right:435px;
  right:90.625%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Note_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Note_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:553px;
  left:0px;
  left:0.0%;
  right:694px;
  right:90.364586%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Note_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Note_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Note_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Note_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Note_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Note_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .causale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:625px;
  left:32px;
  left:10.0%;
  right:277px;
  right:86.5625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .causale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:625px;
  left:48px;
  left:10.0%;
  right:416px;
  right:86.666664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .causale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:606px;
  left:76px;
  left:9.895833%;
  right:666px;
  right:86.71875%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .causale_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .causale_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .agente_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:32px;
  left:10.0%;
  right:272px;
  right:85.0%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .agente_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:48px;
  left:10.0%;
  right:408px;
  right:85.0%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .agente_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:631px;
  left:76px;
  left:9.895833%;
  right:654px;
  right:85.15625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .agente_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .agente_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .label27_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:630px;
  left:5px;
  left:1.5625%;
  right:289px;
  right:90.3125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .label27_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .label27_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:630px;
  left:7px;
  left:1.4583334%;
  right:434px;
  right:90.416664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .label27_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .label27_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:611px;
  left:0px;
  left:0.0%;
  right:694px;
  right:90.364586%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .label27_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .label27_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .label27_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .label27_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .label27_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .label27_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .label27_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:655px;
  left:15px;
  left:4.6875%;
  right:289px;
  right:90.3125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .label27_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .label27_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:655px;
  left:22px;
  left:4.5833335%;
  right:434px;
  right:90.416664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .label27_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .label27_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:637px;
  left:14px;
  left:1.8229166%;
  right:694px;
  right:90.364586%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .label27_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .label27_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .label27_Copy_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .label27_Copy_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .label27_Copy_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .label27_Copy_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lbldContatto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:549px;
  left:5px;
  left:1.5625%;
  right:289px;
  right:90.3125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lbldContatto_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lbldContatto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:549px;
  left:7px;
  left:1.4583334%;
  right:434px;
  right:90.416664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lbldContatto_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lbldContatto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:530px;
  left:0px;
  left:0.0%;
  right:694px;
  right:90.364586%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lbldContatto_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .lbldContatto_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .lbldContatto_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lbldContatto_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lbldContatto_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lbldContatto_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .desccau_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:625px;
  left:45px;
  left:14.0625%;
  right:158px;
  right:49.375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .desccau_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:625px;
  left:67px;
  left:13.958333%;
  right:238px;
  right:49.583332%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .desccau_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:606px;
  left:108px;
  left:14.0625%;
  right:380px;
  right:49.479168%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .desccau_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .desccau_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .descage_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:50px;
  left:15.625%;
  right:165px;
  right:51.5625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .descage_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:75px;
  left:15.625%;
  right:248px;
  right:51.666668%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .descage_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:631px;
  left:120px;
  left:15.625%;
  right:396px;
  right:51.5625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .descage_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .descage_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .telagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:166px;
  left:51.875%;
  right:117px;
  right:36.5625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .telagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:249px;
  left:51.875%;
  right:176px;
  right:36.666668%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .telagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:631px;
  left:398px;
  left:51.822918%;
  right:282px;
  right:36.71875%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .telagenzia_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .telagenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Telefono_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:655px;
  left:155px;
  left:48.4375%;
  right:156px;
  right:48.75%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Telefono_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Telefono_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:655px;
  left:232px;
  left:48.333332%;
  right:235px;
  right:48.958332%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Telefono_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Telefono_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:637px;
  left:372px;
  left:48.4375%;
  right:375px;
  right:48.828125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Telefono_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .Telefono_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .Telefono_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Telefono_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Telefono_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Telefono_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lblLocale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:655px;
  left:208px;
  left:65.0%;
  right:92px;
  right:28.75%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lblLocale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lblLocale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:655px;
  left:312px;
  left:65.0%;
  right:138px;
  right:28.75%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lblLocale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lblLocale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:637px;
  left:493px;
  left:64.19271%;
  right:209px;
  right:27.213541%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lblLocale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .lblLocale_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="1024"] > .lblLocale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .lblLocale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .lblLocale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .lblLocale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .dDataCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:545px;
  left:32px;
  left:10.0%;
  right:265px;
  right:82.8125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .dDataCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:545px;
  left:48px;
  left:10.0%;
  right:398px;
  right:82.916664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .dDataCon_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  left:76px;
  left:9.895833%;
  right:637px;
  right:82.94271%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .dDataCon_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .dDataCon_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .cbAll_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:543px;
  left:172px;
  left:53.75%;
  right:144px;
  right:45.0%;
  width:auto;
  height:13px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .cbAll_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:543px;
  left:258px;
  left:53.75%;
  right:216px;
  right:45.0%;
  width:auto;
  height:13px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .cbAll_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:524px;
  left:428px;
  left:55.729168%;
  right:30px;
  right:3.90625%;
  width:auto;
  height:23px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .cCodLoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:229px;
  left:71.5625%;
  right:21px;
  right:6.5625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .cCodLoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:650px;
  left:343px;
  left:71.458336%;
  right:32px;
  right:6.6666665%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .cCodLoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:631px;
  left:563px;
  left:73.30729%;
  right:37px;
  right:4.8177085%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet > .cCodLoc_ctrl {
}
.pg_cgo_operazioni_agenzie_admin_portlet > .cCodLoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="320"] > .Calendario45_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:545px;
  left:56px;
  left:17.5%;
  right:258px;
  right:80.625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="480"] > .Calendario45_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:545px;
  left:84px;
  left:17.5%;
  right:387px;
  right:80.625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_admin_portlet[Data-step="768"] > .Calendario45_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  left:134px;
  left:17.447916%;
  right:620px;
  right:80.729164%;
  width:auto;
  height:20px;
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Operazione\"},{\"title\":\"Tipo gioco\"},{\"title\":\"Ticket\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Giorni\"},{\"title\":\"Agenzia\"},{\"title\":\"LOC\"},{\"title\":\"Data Contatto\"},{\"title\":\"Esito\"},{\"title\":\"Descrizione\"}],\"h\":\"436\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":436,\"hide\":\"false\",\"w\":319,\"x\":1,\"y\":96},\"480\":{\"anchor\":\" \",\"h\":436,\"hide\":\"false\",\"w\":478,\"x\":1,\"y\":96},\"768\":{\"anchor\":\"\",\"h\":436,\"hide\":\"false\",\"w\":765,\"x\":1,\"y\":77}},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"765\",\"x\":\"1\",\"y\":\"77\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1030\",\"y\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1030\",\"y\":\"45\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1074\",\"y\":\"5\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":17,\"y\":68},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":6,\"y\":68},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":9,\"y\":68},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":63,\"x\":0,\"y\":49}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Biglietto:\",\"w\":\"63\",\"x\":\"0\",\"y\":\"49\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":368,\"y\":68},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":115,\"y\":68},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":172,\"y\":68},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":276,\"y\":49}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":\"50\",\"x\":\"276\",\"y\":\"49\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"92\",\"x\":186,\"y\":549},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":28,\"x\":59,\"y\":549},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":42,\"x\":88,\"y\":549},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":67,\"x\":157,\"y\":530}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Esito Contatto:\",\"w\":\"67\",\"x\":\"157\",\"y\":\"530\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":27},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":697,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"697\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":972,\"y\":589},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":304,\"y\":589},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":456,\"y\":589},\"768\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":28,\"x\":729,\"y\":570}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"28\",\"x\":\"729\",\"y\":\"570\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":61},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":61},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":61},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":733,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"733\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":929,\"y\":27},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":291,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":436,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":661,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"661\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":586,\"y\":40},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":184,\"y\":40},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":276,\"y\":40},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":441,\"y\":21}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Locale:\",\"w\":\"50\",\"x\":\"441\",\"y\":\"21\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"181\",\"x\":\"1037\",\"y\":\"300\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"558\",\"y\":\"48\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"54\",\"x\":89,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":16,\"x\":28,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":24,\"x\":42,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":38,\"x\":67,\"y\":15}},\"name\":\"agenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"38\",\"x\":\"67\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"234\",\"x\":89,\"y\":63},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":73,\"x\":28,\"y\":63},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":109,\"x\":42,\"y\":63},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":175,\"x\":67,\"y\":44}},\"name\":\"idticket\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"175\",\"x\":\"67\",\"y\":\"44\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":17,\"y\":38},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":6,\"y\":38},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":9,\"y\":38},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":14,\"y\":19}},\"n_col\":\"1\",\"name\":\"Agenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"50\",\"x\":\"14\",\"y\":\"19\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"247\",\"x\":438,\"y\":63},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":77,\"x\":137,\"y\":63},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":115,\"x\":205,\"y\":63},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":184,\"x\":328,\"y\":44}},\"name\":\"tipogio\",\"page\":\"1\",\"textlist\":\"DESTPGIO\",\"type\":\"Combobox\",\"w\":\"184\",\"x\":\"328\",\"y\":\"44\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"247\",\"x\":279,\"y\":545},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":77,\"x\":88,\"y\":545},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":115,\"x\":132,\"y\":545},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":184,\"x\":227,\"y\":526}},\"name\":\"cEsitoCon\",\"page\":\"1\",\"textlist\":\"ECDESCRI\",\"type\":\"Combobox\",\"w\":\"184\",\"x\":\"227\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"14\",\"x\":143,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":4,\"x\":45,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":6,\"x\":67,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":9,\"x\":108,\"y\":15}},\"name\":\"LinkZoom17\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"9\",\"x\":\"108\",\"y\":\"15\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"350\",\"x\":167,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":109,\"x\":53,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":163,\"x\":79,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":261,\"x\":127,\"y\":15}},\"name\":\"descazi\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"261\",\"x\":\"127\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"58\",\"x\":879,\"y\":67},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":18,\"x\":275,\"y\":67},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":27,\"x\":412,\"y\":67},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":43,\"x\":660,\"y\":48}},\"name\":\"xagenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"43\",\"x\":\"660\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"212\",\"x\":657,\"y\":35},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":66,\"x\":206,\"y\":35},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":99,\"x\":309,\"y\":35},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":158,\"x\":494,\"y\":16}},\"name\":\"xcodloc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"158\",\"x\":\"494\",\"y\":\"16\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"SnaiOper\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"1031\",\"y\":\"86\"},{\"h\":\"30\",\"name\":\"EsitoContatto\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"173\",\"x\":\"1030\",\"y\":\"166\"},{\"h\":\"30\",\"name\":\"EstrazioneExcel\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"178\",\"x\":\"1030\",\"y\":\"209\"},{\"h\":\"30\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"185\",\"x\":\"1030\",\"y\":\"254\"},{\"h\":\"20\",\"name\":\"armt_snai_oper_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"167\",\"x\":\"1034\",\"y\":\"129\"},{\"anchor\":\"\",\"h\":\"52\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":52,\"hide\":\"false\",\"w\":\"856\",\"x\":101,\"y\":569},\"320\":{\"anchor\":\" \",\"h\":52,\"hide\":\"false\",\"w\":267,\"x\":32,\"y\":569},\"480\":{\"anchor\":\" \",\"h\":52,\"hide\":\"false\",\"w\":400,\"x\":48,\"y\":569},\"768\":{\"anchor\":\"\",\"h\":52,\"hide\":\"false\",\"w\":640,\"x\":76,\"y\":550}},\"name\":\"mcNote\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"640\",\"x\":\"76\",\"y\":\"550\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"101\",\"x\":-2,\"y\":572},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":-1,\"y\":572},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":46,\"x\":-1,\"y\":572},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":74,\"x\":0,\"y\":553}},\"n_col\":\"1\",\"name\":\"Note\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Note Contatto:\",\"w\":\"74\",\"x\":\"0\",\"y\":\"553\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"36\",\"x\":102,\"y\":625},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":11,\"x\":32,\"y\":625},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":16,\"x\":48,\"y\":625},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":26,\"x\":76,\"y\":606}},\"name\":\"causale\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"26\",\"x\":\"76\",\"y\":\"606\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"54\",\"x\":102,\"y\":650},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":16,\"x\":32,\"y\":650},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":24,\"x\":48,\"y\":650},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":38,\"x\":76,\"y\":631}},\"name\":\"agente\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"38\",\"x\":\"76\",\"y\":\"631\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"85\",\"x\":13,\"y\":630},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":26,\"x\":5,\"y\":630},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":39,\"x\":7,\"y\":630},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":74,\"x\":0,\"y\":611}},\"n_col\":\"1\",\"name\":\"label27\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Biglietto:\",\"w\":\"74\",\"x\":\"0\",\"y\":\"611\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"53\",\"x\":45,\"y\":655},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":16,\"x\":15,\"y\":655},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":24,\"x\":22,\"y\":655},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":60,\"x\":14,\"y\":637}},\"n_col\":\"1\",\"name\":\"label27_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"60\",\"x\":\"14\",\"y\":\"637\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"86\",\"x\":13,\"y\":549},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":26,\"x\":5,\"y\":549},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":39,\"x\":7,\"y\":549},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":74,\"x\":0,\"y\":530}},\"n_col\":\"1\",\"name\":\"lbldContatto\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Contatto:\",\"w\":\"74\",\"x\":\"0\",\"y\":\"530\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"375\",\"x\":144,\"y\":625},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":117,\"x\":45,\"y\":625},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":175,\"x\":67,\"y\":625},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":280,\"x\":108,\"y\":606}},\"name\":\"desccau\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"280\",\"x\":\"108\",\"y\":\"606\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"336\",\"x\":160,\"y\":650},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":105,\"x\":50,\"y\":650},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":157,\"x\":75,\"y\":650},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":252,\"x\":120,\"y\":631}},\"name\":\"descage\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"252\",\"x\":\"120\",\"y\":\"631\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"119\",\"x\":529,\"y\":650},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":37,\"x\":166,\"y\":650},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":55,\"x\":249,\"y\":650},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":88,\"x\":398,\"y\":631}},\"name\":\"telagenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"88\",\"x\":\"398\",\"y\":\"631\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"29\",\"x\":495,\"y\":655},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":9,\"x\":155,\"y\":655},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":13,\"x\":232,\"y\":655},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":21,\"x\":372,\"y\":637}},\"n_col\":\"1\",\"name\":\"Telefono\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tel.:\",\"w\":\"21\",\"x\":\"372\",\"y\":\"637\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"64\",\"x\":665,\"y\":655},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":20,\"x\":208,\"y\":655},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":30,\"x\":312,\"y\":655},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":66,\"x\":493,\"y\":637}},\"n_col\":\"1\",\"name\":\"lblLocale\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice LOC:\",\"w\":\"66\",\"x\":\"493\",\"y\":\"637\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"75\",\"x\":101,\"y\":545},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":23,\"x\":32,\"y\":545},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":34,\"x\":48,\"y\":545},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":55,\"x\":76,\"y\":526}},\"name\":\"dDataCon\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"55\",\"x\":\"76\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"23\",\"label_text\":\"Aggiorna tutte le operazioni dell'agenzia\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":13,\"hide\":\"false\",\"w\":\"13\",\"x\":550,\"y\":543},\"320\":{\"anchor\":\" \",\"h\":13,\"hide\":\"false\",\"w\":4,\"x\":172,\"y\":543},\"480\":{\"anchor\":\" \",\"h\":13,\"hide\":\"false\",\"w\":6,\"x\":258,\"y\":543},\"768\":{\"anchor\":\"\",\"h\":23,\"hide\":\"false\",\"w\":310,\"x\":428,\"y\":524}},\"name\":\"cbAll\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"310\",\"x\":\"428\",\"y\":\"524\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"225\",\"x\":730,\"y\":650},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":70,\"x\":229,\"y\":650},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":105,\"x\":343,\"y\":650},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":168,\"x\":563,\"y\":631}},\"name\":\"cCodLoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"168\",\"x\":\"563\",\"y\":\"631\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"20\",\"x\":178,\"y\":545},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":6,\"x\":56,\"y\":545},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":9,\"x\":84,\"y\":545},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":14,\"x\":134,\"y\":526}},\"name\":\"Calendario45\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"14\",\"x\":\"134\",\"y\":\"526\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_admin","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_admin_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_admin','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_admin_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String IDB= "ID Biglietto:";
String TPG= "Tipo Gioco:";
String lblcEsitoCon= "Esito Contatto:";
String Locale= "ID Locale:";
String NumOpe= "";
String agenzia= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_admin_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String idticket= "";
String Agenzia= "Agenzia:";
String tipogio= "";
String cEsitoCon= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_admin_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String descazi= "";
String xagenzia= "";
String xcodloc= "";
String mcNote= "";
String Note= "Note Contatto:";
String causale= "";
String agente= "";
String label27= "Tipo Biglietto:";
String label27_Copy= "Agenzia:";
String lbldContatto= "Data Contatto:";
String desccau= "";
String descage= "";
String telagenzia= "";
String Telefono= "Tel.:";
String lblLocale= "Codice LOC:";
java.sql.Date dDataCon= JSPLib.NullDate();
String cbAll="S";
String cCodLoc= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_admin_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_admin_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_admin_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_admin_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_admin','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_IDB'  formid='<%=idPortlet%>' ps-name='IDB'    class='label IDB_ctrl'><div id='<%=idPortlet%>_IDBtbl' style='width:100%;'><%=JSPLib.ToHTML("ID Biglietto:")%></div></span>
<span id='<%=idPortlet%>_TPG'  formid='<%=idPortlet%>' ps-name='TPG'    class='label TPG_ctrl'><div id='<%=idPortlet%>_TPGtbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Gioco:")%></div></span>
<span id='<%=idPortlet%>_lblcEsitoCon'  formid='<%=idPortlet%>' ps-name='lblcEsitoCon'    class='label lblcEsitoCon_ctrl'><div id='<%=idPortlet%>_lblcEsitoContbl' style='width:100%;'><%=JSPLib.ToHTML("Esito Contatto:")%></div></span>
<a id='<%=idPortlet%>_Ricerca' class='image Ricerca_ctrl'   target=''>&#xea19;</a>
<a id='<%=idPortlet%>_Salva' class='image Salva_ctrl'   target=''>&#xeb36;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_Excel' class='image Excel_ctrl'   target=''>&#xea8c;</a>
<span id='<%=idPortlet%>_Locale'  formid='<%=idPortlet%>' ps-name='Locale'    class='label Locale_ctrl'><div id='<%=idPortlet%>_Localetbl' style='width:100%;'><%=JSPLib.ToHTML("ID Locale:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_agenzia_wrp'><input id='<%=idPortlet%>_agenzia' name='agenzia' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='agenzia' /></span>
<span class='textbox-container'id='<%=idPortlet%>_idticket_wrp'><input id='<%=idPortlet%>_idticket' name='idticket' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='idticket' /></span>
<span id='<%=idPortlet%>_Agenzia'  formid='<%=idPortlet%>' ps-name='Agenzia'    class='label Agenzia_ctrl'><div id='<%=idPortlet%>_Agenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<select id='<%=idPortlet%>_tipogio' name='tipogio' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<select id='<%=idPortlet%>_cEsitoCon' name='cEsitoCon' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descazi_wrp'><input id='<%=idPortlet%>_descazi' name='descazi' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descazi' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xagenzia_wrp'><input id='<%=idPortlet%>_xagenzia' name='xagenzia' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='xagenzia' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xcodloc_wrp'><input id='<%=idPortlet%>_xcodloc' name='xcodloc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='xcodloc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_mcNote_wrp'><textarea id='<%=idPortlet%>_mcNote' name='mcNote' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='mcNote'    ></textarea></span>
<span id='<%=idPortlet%>_Note'  formid='<%=idPortlet%>' ps-name='Note'    class='label Note_ctrl'><div id='<%=idPortlet%>_Notetbl' style='width:100%;'><%=JSPLib.ToHTML("Note Contatto:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_causale_wrp'><input id='<%=idPortlet%>_causale' name='causale' type='text' disabled maxlength='3' class='textbox' formid='<%=idPortlet%>' ps-name='causale' /></span>
<span class='textbox-container'id='<%=idPortlet%>_agente_wrp'><input id='<%=idPortlet%>_agente' name='agente' type='text' disabled maxlength='3' class='textbox' formid='<%=idPortlet%>' ps-name='agente' /></span>
<span id='<%=idPortlet%>_label27'  formid='<%=idPortlet%>' ps-name='label27'    class='label label27_ctrl'><div id='<%=idPortlet%>_label27tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Biglietto:")%></div></span>
<span id='<%=idPortlet%>_label27_Copy'  formid='<%=idPortlet%>' ps-name='label27_Copy'    class='label label27_Copy_ctrl'><div id='<%=idPortlet%>_label27_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<span id='<%=idPortlet%>_lbldContatto'  formid='<%=idPortlet%>' ps-name='lbldContatto'    class='label lbldContatto_ctrl'><div id='<%=idPortlet%>_lbldContattotbl' style='width:100%;'><%=JSPLib.ToHTML("Data Contatto:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_desccau_wrp'><input id='<%=idPortlet%>_desccau' name='desccau' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='desccau' /></span>
<span class='textbox-container'id='<%=idPortlet%>_descage_wrp'><input id='<%=idPortlet%>_descage' name='descage' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='descage' /></span>
<span class='textbox-container'id='<%=idPortlet%>_telagenzia_wrp'><input id='<%=idPortlet%>_telagenzia' name='telagenzia' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='telagenzia' /></span>
<span id='<%=idPortlet%>_Telefono'  formid='<%=idPortlet%>' ps-name='Telefono'    class='label Telefono_ctrl'><div id='<%=idPortlet%>_Telefonotbl' style='width:100%;'><%=JSPLib.ToHTML("Tel.:")%></div></span>
<span id='<%=idPortlet%>_lblLocale'  formid='<%=idPortlet%>' ps-name='lblLocale'    class='label lblLocale_ctrl'><div id='<%=idPortlet%>_lblLocaletbl' style='width:100%;'><%=JSPLib.ToHTML("Codice LOC:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_dDataCon_wrp'><input id='<%=idPortlet%>_dDataCon' name='dDataCon' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='dDataCon' /></span>
<div id='<%=idPortlet%>_cbAll_div' style=''><input id='<%=idPortlet%>_cbAll' name='cbAll' class='slider checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Aggiorna tutte le operazioni dell'agenzia" )%> /><label for='<%=idPortlet%>_cbAll' class='label' title=<%=JSPLib.ToHTMLValue("Aggiorna tutte le operazioni dell'agenzia" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Aggiorna tutte le operazioni dell'agenzia")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_cCodLoc_wrp'><input id='<%=idPortlet%>_cCodLoc' name='cCodLoc' type='text' disabled maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='cCodLoc' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario45' class='calendar' onclick='window.<%=idPortlet%>.Calendario45.PopupCalendar();' style='text-decoration:none;'></a>
 </div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_admin');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_admin',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"Tahoma","font_color":"","font_size":"","font_weight":"normal","group_repeated":"false","h":436,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":436,"hide":"false","w":319,"x":1,"y":96},"480":{"anchor":" ","h":436,"hide":"false","w":478,"x":1,"y":96},"768":{"anchor":"","h":436,"hide":"false","w":765,"x":1,"y":77}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":true,"print_max":false,"print_option":"default","print_outputf":"","print_result":true,"print_size":"","print_title":"Operazioni da Completare","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":765,"x":1,"y":77,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Oper.","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","height":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:SnaiOper","weight":"","title":"N° Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SNAINUMOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo gioco","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPOGIOCO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Totale Operazione","type":"N","align":"right","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"999,999,999.99","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TOTLIRE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Giorni","type":"N","align":"center","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"center","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"GIORNI","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"IDDIP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"LOC","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODLOC","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Contatto","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CGODATCON","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Esito","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CGOESICON","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"ECDESCRI","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_operazioni_agenzia_admin","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenzia_admin",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"15","page":1,"parms":"w_agenzia=agenzia,w_idticket=idticket,w_tipogio=tipogio","parms_source":"","type":"SQLDataobj","w":120,"x":1030,"y":4});
this.TipoGioco=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_tbtipgio","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_tbtipgio",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_TipoGioco","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"TipoGioco","nrows":"1000","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":1030,"y":45});
this.EsitiCon=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_esiticon","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_esiticon",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_EsitiCon","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"EsitiCon","nrows":"1000","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":1074,"y":5});
this.IDB=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_IDB","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":17,"y":68},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":6,"y":68},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":9,"y":68},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":63,"x":0,"y":49}},"n_col":1,"name":"IDB","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(IDB,false,true)%>","type":"Label","w":63,"x":0,"y":49,"zindex":"1"});
this.TPG=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_TPG","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":368,"y":68},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":115,"y":68},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":172,"y":68},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":276,"y":49}},"n_col":1,"name":"TPG","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(TPG,false,true)%>","type":"Label","w":50,"x":276,"y":49,"zindex":"1"});
this.lblcEsitoCon=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblcEsitoCon","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"92","x":186,"y":549},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":28,"x":59,"y":549},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":42,"x":88,"y":549},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":67,"x":157,"y":530}},"n_col":1,"name":"lblcEsitoCon","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblcEsitoCon,false,true)%>","type":"Label","w":67,"x":157,"y":530,"zindex":"1"});
this.Ricerca=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Ricerca_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Ricerca","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per effettuare la ricerca",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":27},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":27},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":697,"y":8}},"name":"Ricerca","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea19;","srchover":"&#xea1a;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":697,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Salva=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image Salva_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Salva","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Salva i dati del contatto",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":972,"y":589},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":304,"y":589},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":456,"y":589},"768":{"anchor":"","font_size":"","h":30,"hide":"false","w":28,"x":729,"y":570}},"name":"Salva","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb36;","srchover":"&#xeb37;","tabindex":"","target":"","type":"Image","type_submit":"false","w":28,"x":729,"y":570,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":61},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":61},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":61},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":733,"y":8}},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":733,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Excel=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Excel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Excel","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per produrre il file excel",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":929,"y":27},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":291,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":436,"y":27},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":661,"y":8}},"name":"Excel","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":661,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Locale=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Locale","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":586,"y":40},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":184,"y":40},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":276,"y":40},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":441,"y":21}},"n_col":1,"name":"Locale","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Locale,false,true)%>","type":"Label","w":50,"x":441,"y":21,"zindex":"1"});
this.SalvaContatto=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SalvaContatto","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SalvaContatto","offline":false,"page":1,"parms":"pNumOpe=NumOpe,pDatCon=dDataCon,pEsiCon=cEsitoCon,pNotCon=mcNote,pAll=cbAll","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_save_esiticon","target":"","type":"SPLinker","w":181,"x":1037,"y":300});
this.SalvaContatto.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_save_esiticon",request.getSession())%>';
this.NumOpe=new ZtVWeb._VC(this,'NumOpe',null,'character','<%=JSPLib.ToJSValue(NumOpe,false,true)%>',false,false);
this.agenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_agenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"54","x":89,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":16,"x":28,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":24,"x":42,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":38,"x":67,"y":15}},"maxlength":"","name":"agenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(agenzia,false,true)%>","w":38,"x":67,"y":15,"zerofilling":false,"zindex":"1","zoom":""});
this.idticket=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_idticket","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"234","x":89,"y":63},"320":{"anchor":" ","h":20,"hide":"false","w":73,"x":28,"y":63},"480":{"anchor":" ","h":20,"hide":"false","w":109,"x":42,"y":63},"768":{"anchor":"","h":20,"hide":"false","w":175,"x":67,"y":44}},"maxlength":"","name":"idticket","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(idticket,false,true)%>","w":175,"x":67,"y":44,"zerofilling":false,"zindex":"1","zoom":""});
this.Agenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Agenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":17,"y":38},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":6,"y":38},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":9,"y":38},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":14,"y":19}},"n_col":1,"name":"Agenzia","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Agenzia,false,true)%>","type":"Label","w":50,"x":14,"y":19,"zindex":"1"});
this.tipogio=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipogio","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipogio%>","isdatap":true,"layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"247","x":438,"y":63},"320":{"anchor":" ","h":20,"hide":"false","w":77,"x":137,"y":63},"480":{"anchor":" ","h":20,"hide":"false","w":115,"x":205,"y":63},"768":{"anchor":"","h":20,"hide":"false","w":184,"x":328,"y":44}},"name":"tipogio","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"DESTPGIO","type":"Combobox","typevar":"character","valuelist":"CODTPGIO","visible":true,"w":184,"x":328,"y":44,"zindex":"1"});
this.cEsitoCon=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cEsitoCon","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"<%=cEsitoCon%>","isdatap":true,"layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"247","x":279,"y":545},"320":{"anchor":" ","h":20,"hide":"false","w":77,"x":88,"y":545},"480":{"anchor":" ","h":20,"hide":"false","w":115,"x":132,"y":545},"768":{"anchor":"","h":20,"hide":"false","w":184,"x":227,"y":526}},"name":"cEsitoCon","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"ECDESCRI","type":"Combobox","typevar":"character","valuelist":"ECCODICE","visible":true,"w":184,"x":227,"y":526,"zindex":"1"});
this.LinkZoom17=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_cgo_operazioni_agenzie_admin_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"agenzia,descazi,xagenzia,xcodloc","intovarsType":"C,C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"14","x":143,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":4,"x":45,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":6,"x":67,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":9,"x":108,"y":15}},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_cgo_operazioni_agenzie_admin_portlet.jspLinkZoom17",request.getSession())%>","linkedField":"agenzia","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":9,"x":108,"y":15,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descazi=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descazi","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"350","x":167,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":109,"x":53,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":163,"x":79,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":261,"x":127,"y":15}},"maxlength":"","name":"descazi","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descazi,false,true)%>","w":261,"x":127,"y":15,"zerofilling":false,"zindex":"1","zoom":""});
this.xagenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xagenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"58","x":879,"y":67},"320":{"anchor":" ","h":20,"hide":"false","w":18,"x":275,"y":67},"480":{"anchor":" ","h":20,"hide":"false","w":27,"x":412,"y":67},"768":{"anchor":"","h":20,"hide":"false","w":43,"x":660,"y":48}},"maxlength":"","name":"xagenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xagenzia,false,true)%>","w":43,"x":660,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.xcodloc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xcodloc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"212","x":657,"y":35},"320":{"anchor":" ","h":20,"hide":"false","w":66,"x":206,"y":35},"480":{"anchor":" ","h":20,"hide":"false","w":99,"x":309,"y":35},"768":{"anchor":"","h":20,"hide":"false","w":158,"x":494,"y":16}},"maxlength":"","name":"xcodloc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xcodloc,false,true)%>","w":158,"x":494,"y":16,"zerofilling":false,"zindex":"1","zoom":""});
this.SnaiOper=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SnaiOper","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SnaiOper","offline":false,"page":1,"parms":"pNumOpe=SNAINUMOPE,pFlgT=Z,pAgenzia=agenzia","popup":"true","popup_height":"725","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"","servlet":"arrt_snai_oper_load","target":"_new","type":"SPLinker","w":170,"x":1031,"y":86});
this.SnaiOper.m_cID='<%=JSPLib.cmdHash("routine,arrt_snai_oper_load",request.getSession())%>';
this.EsitoContatto=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_EsitoContatto","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"EsitoContatto","offline":false,"page":1,"parms":"NumOpe=SNAINUMOPE,dDataCon=mcDataCon,cEsitoCon=mcEsito,mNote=mcNote","popup":"true","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"760","progressbar":false,"refresh":"","servlet":"pg_cgo_contatto_portlet.jsp","target":"_new","type":"SPLinker","w":173,"x":1030,"y":166});
this.EsitoContatto.m_cID='<%=JSPLib.cmdHash("entity,pg_cgo_contatto_portlet.jsp",request.getSession())%>';
this.EstrazioneExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_EstrazioneExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"EstrazioneExcel","offline":false,"page":1,"parms":"pAgenzia=agenzia,pTicket=idticket,pTipGio=tipogio","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":false,"refresh":"","servlet":"arrt_cgo_operazioni_admin_xls","target":"","type":"SPLinker","w":178,"x":1030,"y":209});
this.EstrazioneExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_operazioni_admin_xls",request.getSession())%>';
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":185,"x":1030,"y":254});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.armt_snai_oper_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_snai_oper_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_snai_oper_savedEntity","objsValues":"this.Ricevente()","page":1,"parmsNames":"","type":"EventReceiver","w":167,"x":1034,"y":129});
this.mcNote=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_mcNote","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CGONOTCON","fixed":"false","floating_placeholder":false,"h":52,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":52,"hide":"false","w":"856","x":101,"y":569},"320":{"anchor":" ","h":52,"hide":"false","w":267,"x":32,"y":569},"480":{"anchor":" ","h":52,"hide":"false","w":400,"x":48,"y":569},"768":{"anchor":"","h":52,"hide":"false","w":640,"x":76,"y":550}},"maxlength":"","name":"mcNote","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"memo","value":"<%=JSPLib.ToJSValue(mcNote,false,true)%>","w":640,"x":76,"y":550,"zerofilling":false,"zindex":"1","zoom":""});
this.Note=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Note","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"101","x":-2,"y":572},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":-1,"y":572},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":46,"x":-1,"y":572},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":74,"x":0,"y":553}},"n_col":1,"name":"Note","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Note,false,true)%>","type":"Label","w":74,"x":0,"y":553,"zindex":"1"});
this.causale=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_causale","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CACODICE","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"36","x":102,"y":625},"320":{"anchor":" ","h":20,"hide":"false","w":11,"x":32,"y":625},"480":{"anchor":" ","h":20,"hide":"false","w":16,"x":48,"y":625},"768":{"anchor":"","h":20,"hide":"false","w":26,"x":76,"y":606}},"maxlength":"3","name":"causale","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(causale,false,true)%>","w":26,"x":76,"y":606,"zerofilling":false,"zindex":"1","zoom":""});
this.agente=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_agente","decrypt":false,"edit_undercond":"","encrypt":false,"field":"IDDIP","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"54","x":102,"y":650},"320":{"anchor":" ","h":20,"hide":"false","w":16,"x":32,"y":650},"480":{"anchor":" ","h":20,"hide":"false","w":24,"x":48,"y":650},"768":{"anchor":"","h":20,"hide":"false","w":38,"x":76,"y":631}},"maxlength":"3","name":"agente","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(agente,false,true)%>","w":38,"x":76,"y":631,"zerofilling":false,"zindex":"1","zoom":""});
this.label27=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label27","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"85","x":13,"y":630},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":26,"x":5,"y":630},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":39,"x":7,"y":630},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":74,"x":0,"y":611}},"n_col":1,"name":"label27","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label27,false,true)%>","type":"Label","w":74,"x":0,"y":611,"zindex":"1"});
this.label27_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label27_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"53","x":45,"y":655},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":16,"x":15,"y":655},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":24,"x":22,"y":655},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":60,"x":14,"y":637}},"n_col":1,"name":"label27_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label27_Copy,false,true)%>","type":"Label","w":60,"x":14,"y":637,"zindex":"1"});
this.lbldContatto=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbldContatto","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"86","x":13,"y":549},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":26,"x":5,"y":549},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":39,"x":7,"y":549},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":74,"x":0,"y":530}},"n_col":1,"name":"lbldContatto","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lbldContatto,false,true)%>","type":"Label","w":74,"x":0,"y":530,"zindex":"1"});
this.desccau=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_desccau","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TRDESREG","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"375","x":144,"y":625},"320":{"anchor":" ","h":20,"hide":"false","w":117,"x":45,"y":625},"480":{"anchor":" ","h":20,"hide":"false","w":175,"x":67,"y":625},"768":{"anchor":"","h":20,"hide":"false","w":280,"x":108,"y":606}},"maxlength":"50","name":"desccau","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(desccau,false,true)%>","w":280,"x":108,"y":606,"zerofilling":false,"zindex":"1","zoom":""});
this.descage=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DESCRIZ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"336","x":160,"y":650},"320":{"anchor":" ","h":20,"hide":"false","w":105,"x":50,"y":650},"480":{"anchor":" ","h":20,"hide":"false","w":157,"x":75,"y":650},"768":{"anchor":"","h":20,"hide":"false","w":252,"x":120,"y":631}},"maxlength":"50","name":"descage","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descage,false,true)%>","w":252,"x":120,"y":631,"zerofilling":false,"zindex":"1","zoom":""});
this.telagenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_telagenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TELEFONO","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"119","x":529,"y":650},"320":{"anchor":" ","h":20,"hide":"false","w":37,"x":166,"y":650},"480":{"anchor":" ","h":20,"hide":"false","w":55,"x":249,"y":650},"768":{"anchor":"","h":20,"hide":"false","w":88,"x":398,"y":631}},"maxlength":"","name":"telagenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(telagenzia,false,true)%>","w":88,"x":398,"y":631,"zerofilling":false,"zindex":"1","zoom":""});
this.Telefono=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Telefono","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"29","x":495,"y":655},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":9,"x":155,"y":655},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":13,"x":232,"y":655},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":21,"x":372,"y":637}},"n_col":1,"name":"Telefono","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Telefono,false,true)%>","type":"Label","w":21,"x":372,"y":637,"zindex":"1"});
this.lblLocale=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblLocale","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"64","x":665,"y":655},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":20,"x":208,"y":655},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":30,"x":312,"y":655},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":66,"x":493,"y":637}},"n_col":1,"name":"lblLocale","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblLocale,false,true)%>","type":"Label","w":66,"x":493,"y":637,"zindex":"1"});
this.dDataCon=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dDataCon","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CGODATCON","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"75","x":101,"y":545},"320":{"anchor":" ","h":20,"hide":"false","w":23,"x":32,"y":545},"480":{"anchor":" ","h":20,"hide":"false","w":34,"x":48,"y":545},"768":{"anchor":"","h":20,"hide":"false","w":55,"x":76,"y":526}},"maxlength":"10","name":"dDataCon","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dDataCon%>","w":55,"x":76,"y":526,"zerofilling":false,"zindex":"1","zoom":""});
this.cbAll=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_cbAll","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":23,"hide":"false","hide_undercond":"","init":"false","init_par":"S","label_text":"Aggiorna tutte le operazioni dell'agenzia","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":13,"hide":"false","w":"13","x":550,"y":543},"320":{"anchor":" ","h":13,"hide":"false","w":4,"x":172,"y":543},"480":{"anchor":" ","h":13,"hide":"false","w":6,"x":258,"y":543},"768":{"anchor":"","h":23,"hide":"false","w":310,"x":428,"y":524}},"name":"cbAll","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":310,"x":428,"y":524,"zindex":"1"});
this.cbAll.Value('<%=cbAll%>');
this.cCodLoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cCodLoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CODLOC","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"225","x":730,"y":650},"320":{"anchor":" ","h":20,"hide":"false","w":70,"x":229,"y":650},"480":{"anchor":" ","h":20,"hide":"false","w":105,"x":343,"y":650},"768":{"anchor":"","h":20,"hide":"false","w":168,"x":563,"y":631}},"maxlength":"30","name":"cCodLoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cCodLoc,false,true)%>","w":168,"x":563,"y":631,"zerofilling":false,"zindex":"1","zoom":""});
this.Calendario45=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario45','Calendario45',134,526,14,20,'Verdana','10','top-left(%)-right(%)','true','dDataCon',{"320":{"hide":"false","w":6,"anchor":" ","x":56,"h":20,"y":545},"1024":{"hide":"false","w":"20","anchor":" ","x":178,"h":20,"y":545},"768":{"hide":"false","w":14,"anchor":"","x":134,"h":20,"y":526},"480":{"hide":"false","w":9,"anchor":" ","x":84,"h":20,"y":545}});
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_admin_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_admin_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_admin_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Ricerca.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Salva.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Excel.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_armt_snai_oper_savedEntity=function(parmsObj){<%=idPortlet%>.armt_snai_oper_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.TipoGioco.firstQuery('true');
window.<%=idPortlet%>.EsitiCon.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_admin',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_admin');
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
sp.endPage("pg_cgo_operazioni_agenzie_admin");
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
<%! public String getJSPUID() { return "2128936895"; } %>