<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Verifica Documentazione Operazioni\",true)\n}\n\nfunction Ricerca_Click(){\n this.Query1.Query(); \n}\n\nfunction Uscita_Click(){\n this.BtnUscita.Link()\n}\n\nfunction CalcSemaforo(_flgdoc) {\n  _ritorno=''\n  if (_flgdoc=='S') {\n    _ritorno=\"\u003cimg src='\"+LRTrim(this.gUrlApp.Value())+\"\u002fimages\u002fGIF\u002f092.gif'\"+' alt=\"ok\" \u002f\u003e'\n  }\n  if (_flgdoc=='N') {\n    _ritorno=\"\u003cimg src='\"+LRTrim(this.gUrlApp.Value())+\"\u002fimages\u002fGIF\u002f093.gif'\"+' alt=\"ko\" \u002f\u003e'    \n  }    \n  if (_flgdoc=='X') {\n    _ritorno=\"\u003cimg src='\"+LRTrim(this.gUrlApp.Value())+\"\u002fimages\u002fGIF\u002f091.gif'\"+' alt=\"ne\" \u002f\u003e'    \n  }   \n  return _ritorno\n}  \n\nfunction LanciaOper() {\n  if (this.origine.Value()=='S') {\n    this.ViewStorico.Link()\n  } else {\n    if (this.tipooper.Value()=='1') {    \n      this.ViewOper1.Link()\n    }\n    if (this.tipooper.Value()=='2') {    \n      this.ViewOper2.Link()      \n    }\n    if (this.tipooper.Value()=='3') {    \n      this.ViewOper3.Link()      \n    }    \n  } \n}  \n  \nfunction LanciaDoc() {\n  this.Documenti.Link()\n}  \n\nfunction UnlockDocs() {\n  if (this.flagfull.Value()=='S') {\n    if (confirm('Confermi lo sblocco dei documenti?')) {\n      _esito=this.RTUnlockDocs.Link();\n      if (_esito=='OK') {\n        alert('Sblocco avvenuto correttamente');\n        this.Query1.Query()\n        this.Grid0.Refresh(true)\n      } else {\n        alert('Non è stato possibile sbloccare i documenti');        \n      }  \n    }  \n  } else {\n    alert('Operazione non possibile. Documenti già sbloccati')\n  }  \n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @xcodloc }} \n{{ @descazi }} \n{{ @LinkZoom17 }} \n{{ @Agenzia }} \n{{ @agenzia }} \n{{ @Locale }} \n{{ @Uscita }} \n{{ @Ricerca }} \n{{ @Grid0 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo gioco\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPOGIOCO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"N\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODDIPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"LOC\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODLOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Stato Doc.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"FLGDOCALL\",\"fg_color\":\"\",\"width\":\"80\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":true,\"onclick\":\"\",\"link\":\"function:LanciaDoc()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"function:CalcSemaforo('%FLGDOCALL%')\",\"fg_color\":\"\",\"width\":\"10\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"10\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:UnlockDocs()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fGIF\u002f063.gif:Sblocco Documentazione\",\"fg_color\":\"\",\"width\":\"10\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,C,N,C,C,C,,","filters":"true-by-example","floatRows":"","font":"Tahoma","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":65,\"w\":319,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":65,\"w\":478,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":43,\"w\":768,\"h\":528,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"43","zindex":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_agenzia=agenzia","parms_source":"","query":"qbe_cgo_operazioni_agenzia_docs","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"1030","y":"4"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":" &#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":249,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"},\"480\":{\"x\":409,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"},\"768\":{\"x\":697,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":953,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"}}","name":"Ricerca","page":"1","path_type":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fsearch.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"697","y":"7","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":" &#xe9fb;","font_image_hover":" &#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":286,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"},\"480\":{\"x\":446,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"},\"768\":{\"x\":734,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":990,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"}}","name":"Uscita","page":"1","path_type":"","sequence":"4","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"734","y":"7","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":170,\"y\":38,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":255,\"y\":38,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":408,\"y\":16,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":542,\"y\":38,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Locale","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ID Locale:","w":"50","wireframe_props":"align,value,n_col","x":"408","y":"16","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":28,\"y\":34,\"w\":16,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":42,\"y\":34,\"w\":24,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":67,\"y\":12,\"w\":38,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":89,\"y\":34,\"w\":\"54\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"agenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"38","wireframe_props":"name","x":"67","y":"12","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":38,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":9,\"y\":38,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":14,\"y\":16,\"w\":50,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":17,\"y\":38,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Agenzia","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia:","w":"50","wireframe_props":"align,value,n_col","x":"14","y":"16","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"agenzia,descazi,xagenzia,xcodloc","keyfixedfilters":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":45,\"y\":34,\"w\":4,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":67,\"y\":34,\"w\":6,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":108,\"y\":12,\"w\":9,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":143,\"y\":34,\"w\":\"14\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","linkedField":"agenzia","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"8","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"9","wireframe_props":"","x":"108","y":"12","zindex":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":53,\"y\":34,\"w\":109,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":79,\"y\":34,\"w\":163,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":127,\"y\":12,\"w\":261,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":167,\"y\":34,\"w\":\"350\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"descazi","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"261","wireframe_props":"name","x":"127","y":"12","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":192,\"y\":34,\"w\":66,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":288,\"y\":34,\"w\":99,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":460,\"y\":12,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":613,\"y\":34,\"w\":\"212\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xcodloc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"158","wireframe_props":"name","x":"460","y":"12","zerofilling":"false","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"start","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":"","refresh":"","sequence":"11","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"1077","y":"57"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"866","y":"14"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"xagenzia","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"979","y":"-64"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"ORIGINE","h":"20","init":"","init_par":"","name":"origine","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"862","y":"40"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"idoper","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"905","y":"-28"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"ViewOper2","offline":"false","page":"1","parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"armt_cgo_oper","target":"","type":"SPLinker","w":"30","x":"1094","y":"105"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"ViewOper3","offline":"false","page":"1","parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"armt_cgo_oper_multi","target":"","type":"SPLinker","w":"30","x":"1098","y":"149"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"ViewOper1","offline":"false","page":"1","parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"armt_snai_oper","target":"","type":"SPLinker","w":"30","x":"1100","y":"209"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"ViewStorico","offline":"false","page":"1","parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"19","servlet":"armt_snai_oper_storico","target":"","type":"SPLinker","w":"30","x":"1188","y":"104"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"TIPOOPER","h":"20","init":"","init_par":"","name":"tipooper","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"62","x":"905","y":"-60"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"start","name":"Documenti","offline":"false","page":"1","parms":"rID=iddoc,rTG=tipogioco,rImporto=totlire,rContanti=totcont,rFull=flagfull,rIDTicket=ticket","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"21","servlet":"pg_allegati_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"1103","y":"263"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"TIPOGIOCO","h":"20","init":"","init_par":"","name":"tipogioco","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"1103","y":"335"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"FLGDOCALL","h":"20","init":"","init_par":"","name":"flagfull","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"1103","y":"303"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"TOTLIRE","h":"20","init":"","init_par":"","name":"totlire","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"numeric","w":"149","x":"1103","y":"371"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"TOTCONT","h":"20","init":"","init_par":"","name":"totcont","page":"1","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"numeric","w":"149","x":"1105","y":"408"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDDOCALL","h":"20","init":"","init_par":"","name":"iddoc","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"865","y":"68"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTUnlockDocs","offline":"false","page":"1","parms":"pID=iddoc,pTipo=origine","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"27","servlet":"arfn_unlock_doc","target":"","type":"SPLinker","w":"30","x":"1199","y":"57"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CAIDBIGLIETTO","h":"20","init":"","init_par":"","name":"ticket","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"1106","y":"437"}]%>
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
window.pg_cgo_operazioni_agenzie_docs_admin_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Ricerca_Click !='undefined')this.Ricerca_Click=Ricerca_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof CalcSemaforo !='undefined')this.CalcSemaforo=CalcSemaforo;
if(typeof LanciaOper !='undefined')this.LanciaOper=LanciaOper;
if(typeof LanciaDoc !='undefined')this.LanciaDoc=LanciaDoc;
if(typeof UnlockDocs !='undefined')this.UnlockDocs=UnlockDocs;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.LinkZoom17.addObserverFixedVars();
this.Query1.addDataConsumer(this.origine,<%=JSPLib.ToJSValue("ORIGINE",true)%>);
this.Query1.addDataConsumer(this.idoper,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
this.Query1.addDataConsumer(this.tipooper,<%=JSPLib.ToJSValue("TIPOOPER",true)%>);
this.Query1.addDataConsumer(this.tipogioco,<%=JSPLib.ToJSValue("TIPOGIOCO",true)%>);
this.Query1.addDataConsumer(this.flagfull,<%=JSPLib.ToJSValue("FLGDOCALL",true)%>);
this.Query1.addDataConsumer(this.totlire,<%=JSPLib.ToJSValue("TOTLIRE",true)%>);
this.Query1.addDataConsumer(this.totcont,<%=JSPLib.ToJSValue("TOTCONT",true)%>);
this.Query1.addDataConsumer(this.iddoc,<%=JSPLib.ToJSValue("IDDOCALL",true)%>);
this.Query1.addDataConsumer(this.ticket,<%=JSPLib.ToJSValue("CAIDBIGLIETTO",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Verifica Documentazione Operazioni",true)
}
function Ricerca_Click(){
 this.Query1.Query(); 
}
function Uscita_Click(){
 this.BtnUscita.Link()
}
function CalcSemaforo(_flgdoc) {
  _ritorno=''
  if (_flgdoc=='S') {
    _ritorno="<img src='"+LRTrim(this.gUrlApp.Value())+"/images/GIF/092.gif'"+' alt="ok" />'
  }
  if (_flgdoc=='N') {
    _ritorno="<img src='"+LRTrim(this.gUrlApp.Value())+"/images/GIF/093.gif'"+' alt="ko" />'    
  }    
  if (_flgdoc=='X') {
    _ritorno="<img src='"+LRTrim(this.gUrlApp.Value())+"/images/GIF/091.gif'"+' alt="ne" />'    
  }   
  return _ritorno
}  
function LanciaOper() {
  if (this.origine.Value()=='S') {
    this.ViewStorico.Link()
  } else {
    if (this.tipooper.Value()=='1') {    
      this.ViewOper1.Link()
    }
    if (this.tipooper.Value()=='2') {    
      this.ViewOper2.Link()      
    }
    if (this.tipooper.Value()=='3') {    
      this.ViewOper3.Link()      
    }    
  } 
}  
  
function LanciaDoc() {
  this.Documenti.Link()
}  
function UnlockDocs() {
  if (this.flagfull.Value()=='S') {
    if (confirm('Confermi lo sblocco dei documenti?')) {
      _esito=this.RTUnlockDocs.Link();
      if (_esito=='OK') {
        alert('Sblocco avvenuto correttamente');
        this.Query1.Query()
        this.Grid0.Refresh(true)
      } else {
        alert('Non è stato possibile sbloccare i documenti');        
      }  
    }  
  } else {
    alert('Operazione non possibile. Documenti già sbloccati')
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
.pg_cgo_operazioni_agenzie_docs_admin_container {
}
.pg_cgo_operazioni_agenzie_docs_admin_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:1px;
  left:0.3125%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:1px;
  left:0.20833333%;
  right:1px;
  right:0.20833333%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  right:41px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  right:41px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:41px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .Ricerca_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="1024"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  right:4px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  right:4px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:4px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="1024"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:170px;
  left:53.125%;
  right:129px;
  right:40.3125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:255px;
  left:53.125%;
  right:194px;
  right:40.416668%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:408px;
  left:53.125%;
  right:310px;
  right:40.364582%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .Locale_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="1024"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .agenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .agenzia_ctrl {
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
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:67px;
  left:8.723958%;
  right:663px;
  right:86.328125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .agenzia_ctrl {
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .agenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Agenzia_ctrl {
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
}.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Agenzia_ctrl {
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
}.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:14px;
  left:1.8229166%;
  right:704px;
  right:91.666664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .Agenzia_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="1024"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .LinkZoom17_ctrl {
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
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .LinkZoom17_ctrl {
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
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:108px;
  left:14.0625%;
  right:651px;
  right:84.765625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .descazi_ctrl {
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
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .descazi_ctrl {
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
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:127px;
  left:16.536459%;
  right:380px;
  right:49.479168%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .descazi_ctrl {
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .descazi_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="320"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:192px;
  left:60.0%;
  right:62px;
  right:19.375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="480"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:288px;
  left:60.0%;
  right:93px;
  right:19.375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet[Data-step="768"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:460px;
  left:59.895832%;
  right:150px;
  right:19.53125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .xcodloc_ctrl {
}
.pg_cgo_operazioni_agenzie_docs_admin_portlet > .xcodloc_ctrl > input{
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Ticket\"},{\"title\":\"Tipo gioco\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Agenzia\"},{\"title\":\"LOC\"},{\"title\":\"Stato Doc.\"},{\"title\":\"\"},{\"title\":\"\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":319,\"x\":1,\"y\":65},\"480\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":478,\"x\":1,\"y\":65},\"768\":{\"anchor\":\"\",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":43}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"43\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1030\",\"y\":\"4\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":953,\"y\":29},\"320\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":249,\"y\":29},\"480\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":409,\"y\":29},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":697,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"697\",\"y\":\"7\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":990,\"y\":29},\"320\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":286,\"y\":29},\"480\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":446,\"y\":29},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":734,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"734\",\"y\":\"7\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":542,\"y\":38},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":170,\"y\":38},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":255,\"y\":38},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":408,\"y\":16}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Locale:\",\"w\":\"50\",\"x\":\"408\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"54\",\"x\":89,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":16,\"x\":28,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":24,\"x\":42,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":38,\"x\":67,\"y\":12}},\"name\":\"agenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"38\",\"x\":\"67\",\"y\":\"12\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":17,\"y\":38},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":6,\"y\":38},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":9,\"y\":38},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":50,\"x\":14,\"y\":16}},\"n_col\":\"1\",\"name\":\"Agenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"50\",\"x\":\"14\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"14\",\"x\":143,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":4,\"x\":45,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":6,\"x\":67,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":9,\"x\":108,\"y\":12}},\"name\":\"LinkZoom17\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"9\",\"x\":\"108\",\"y\":\"12\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"350\",\"x\":167,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":109,\"x\":53,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":163,\"x\":79,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":261,\"x\":127,\"y\":12}},\"name\":\"descazi\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"261\",\"x\":\"127\",\"y\":\"12\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"212\",\"x\":613,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":66,\"x\":192,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":99,\"x\":288,\"y\":34},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":158,\"x\":460,\"y\":12}},\"name\":\"xcodloc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"158\",\"x\":\"460\",\"y\":\"12\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1077\",\"y\":\"57\"},{\"h\":\"20\",\"name\":\"gUrlApp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"866\",\"y\":\"14\"},{\"h\":\"20\",\"name\":\"xagenzia\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"979\",\"y\":\"-64\"},{\"h\":\"20\",\"name\":\"origine\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"862\",\"y\":\"40\"},{\"h\":\"20\",\"name\":\"idoper\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"905\",\"y\":\"-28\"},{\"h\":\"30\",\"name\":\"ViewOper2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1094\",\"y\":\"105\"},{\"h\":\"30\",\"name\":\"ViewOper3\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1098\",\"y\":\"149\"},{\"h\":\"30\",\"name\":\"ViewOper1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1100\",\"y\":\"209\"},{\"h\":\"30\",\"name\":\"ViewStorico\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1188\",\"y\":\"104\"},{\"h\":\"20\",\"name\":\"tipooper\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"62\",\"x\":\"905\",\"y\":\"-60\"},{\"h\":\"30\",\"name\":\"Documenti\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1103\",\"y\":\"263\"},{\"h\":\"20\",\"name\":\"tipogioco\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1103\",\"y\":\"335\"},{\"h\":\"20\",\"name\":\"flagfull\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1103\",\"y\":\"303\"},{\"h\":\"20\",\"name\":\"totlire\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1103\",\"y\":\"371\"},{\"h\":\"20\",\"name\":\"totcont\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1105\",\"y\":\"408\"},{\"h\":\"20\",\"name\":\"iddoc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"865\",\"y\":\"68\"},{\"h\":\"30\",\"name\":\"RTUnlockDocs\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"1199\",\"y\":\"57\"},{\"h\":\"20\",\"name\":\"ticket\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1106\",\"y\":\"437\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_docs_admin","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_docs_admin_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_docs_admin','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_docs_admin_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String Locale= "ID Locale:";
String agenzia= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_docs_admin_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Agenzia= "Agenzia:";
if(request.getAttribute("pg_cgo_operazioni_agenzie_docs_admin_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String descazi= "";
String xcodloc= "";
String gUrlApp=sp.getGlobal("gUrlApp","");
String xagenzia= "";
String origine= "";
String idoper= "";
String tipooper= "";
String tipogioco= "";
String flagfull= "";
double totlire= 0;
double totcont= 0;
String iddoc= "";
String ticket= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_docs_admin_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_docs_admin_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_docs_admin_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_docs_admin','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Ricerca' class='image Ricerca_ctrl'   target=''>&#xea19;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<span id='<%=idPortlet%>_Locale'  formid='<%=idPortlet%>' ps-name='Locale'    class='label Locale_ctrl'><div id='<%=idPortlet%>_Localetbl' style='width:100%;'><%=JSPLib.ToHTML("ID Locale:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_agenzia_wrp'><input id='<%=idPortlet%>_agenzia' name='agenzia' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='agenzia' /></span>
<span id='<%=idPortlet%>_Agenzia'  formid='<%=idPortlet%>' ps-name='Agenzia'    class='label Agenzia_ctrl'><div id='<%=idPortlet%>_Agenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descazi_wrp'><input id='<%=idPortlet%>_descazi' name='descazi' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descazi' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xcodloc_wrp'><input id='<%=idPortlet%>_xcodloc' name='xcodloc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='xcodloc' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_docs_admin');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_docs_admin',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"Tahoma","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":528,"hide":"false","w":319,"x":1,"y":65},"480":{"anchor":" ","h":528,"hide":"false","w":478,"x":1,"y":65},"768":{"anchor":"","h":528,"hide":"false","w":768,"x":0,"y":43}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":43,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Oper.","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo gioco","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPOGIOCO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"N","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODDIPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"LOC","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODLOC","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Stato Doc.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"FLGDOCALL","fg_color":"","width":"80","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","orderby_field":"","col_class":"","font_size":"","link":"function:LanciaDoc()","fixedwidth":"10","title":"","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:CalcSemaforo('%FLGDOCALL%')","droppable_name":"","fg_color":"","width":"10","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:UnlockDocs()","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fGIF\u002f063.gif:Sblocco Documentazione","fg_color":"","width":"10","RowSpan":0,"extensible":false}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_operazioni_agenzia_docs","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenzia_docs",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_agenzia=agenzia","parms_source":"","type":"SQLDataobj","w":120,"x":1030,"y":4});
this.Ricerca=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Ricerca_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Ricerca","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","h":30,"hide":"false","w":"30","x":953,"y":29},"320":{"anchor":"top-right","h":30,"hide":"false","w":"30","x":249,"y":29},"480":{"anchor":"top-right","h":30,"hide":"false","w":"30","x":409,"y":29},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":697,"y":7}},"name":"Ricerca","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea19;","srchover":"&#xea1a;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":697,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","h":30,"hide":"false","w":"30","x":990,"y":29},"320":{"anchor":"top-right","h":30,"hide":"false","w":"30","x":286,"y":29},"480":{"anchor":"top-right","h":30,"hide":"false","w":"30","x":446,"y":29},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":734,"y":7}},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":734,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Locale=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Locale","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":542,"y":38},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":170,"y":38},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":255,"y":38},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":408,"y":16}},"n_col":1,"name":"Locale","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Locale,false,true)%>","type":"Label","w":50,"x":408,"y":16,"zindex":"1"});
this.agenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_agenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"54","x":89,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":16,"x":28,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":24,"x":42,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":38,"x":67,"y":12}},"maxlength":"","name":"agenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(agenzia,false,true)%>","w":38,"x":67,"y":12,"zerofilling":false,"zindex":"1","zoom":""});
this.Agenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Agenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":17,"y":38},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":6,"y":38},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":9,"y":38},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":50,"x":14,"y":16}},"n_col":1,"name":"Agenzia","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Agenzia,false,true)%>","type":"Label","w":50,"x":14,"y":16,"zindex":"1"});
this.LinkZoom17=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_cgo_operazioni_agenzie_docs_admin_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"agenzia,descazi,xagenzia,xcodloc","intovarsType":"C,C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"14","x":143,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":4,"x":45,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":6,"x":67,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":9,"x":108,"y":12}},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_cgo_operazioni_agenzie_docs_admin_portlet.jspLinkZoom17",request.getSession())%>","linkedField":"agenzia","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":9,"x":108,"y":12,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descazi=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descazi","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"350","x":167,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":109,"x":53,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":163,"x":79,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":261,"x":127,"y":12}},"maxlength":"","name":"descazi","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descazi,false,true)%>","w":261,"x":127,"y":12,"zerofilling":false,"zindex":"1","zoom":""});
this.xcodloc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xcodloc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"212","x":613,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":66,"x":192,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":99,"x":288,"y":34},"768":{"anchor":"","h":20,"hide":"false","w":158,"x":460,"y":12}},"maxlength":"","name":"xcodloc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xcodloc,false,true)%>","w":158,"x":460,"y":12,"zerofilling":false,"zindex":"1","zoom":""});
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":30,"x":1077,"y":57});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.xagenzia=new ZtVWeb._VC(this,'xagenzia',null,'character','<%=JSPLib.ToJSValue(xagenzia,false,true)%>',false,false);
this.origine=new ZtVWeb._VC(this,'origine',null,'character','<%=JSPLib.ToJSValue(origine,false,true)%>',false,false);
this.idoper=new ZtVWeb._VC(this,'idoper',null,'character','<%=JSPLib.ToJSValue(idoper,false,true)%>',false,false);
this.ViewOper2=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ViewOper2","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ViewOper2","offline":false,"page":1,"parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_cgo_oper","target":"","type":"SPLinker","w":30,"x":1094,"y":105});
this.ViewOper2.m_cID='<%=JSPLib.cmdHash("entity,armt_cgo_oper",request.getSession())%>';
this.ViewOper3=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ViewOper3","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ViewOper3","offline":false,"page":1,"parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_cgo_oper_multi","target":"","type":"SPLinker","w":30,"x":1098,"y":149});
this.ViewOper3.m_cID='<%=JSPLib.cmdHash("entity,armt_cgo_oper_multi",request.getSession())%>';
this.ViewOper1=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ViewOper1","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ViewOper1","offline":false,"page":1,"parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_snai_oper","target":"","type":"SPLinker","w":30,"x":1100,"y":209});
this.ViewOper1.m_cID='<%=JSPLib.cmdHash("entity,armt_snai_oper",request.getSession())%>';
this.ViewStorico=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ViewStorico","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ViewStorico","offline":false,"page":1,"parms":"SNAINUMOPE=idoper","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_snai_oper_storico","target":"","type":"SPLinker","w":30,"x":1188,"y":104});
this.ViewStorico.m_cID='<%=JSPLib.cmdHash("entity,armt_snai_oper_storico",request.getSession())%>';
this.tipooper=new ZtVWeb._VC(this,'tipooper',null,'character','<%=JSPLib.ToJSValue(tipooper,false,true)%>',false,false);
this.Documenti=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Documenti","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Documenti","offline":false,"page":1,"parms":"rID=iddoc,rTG=tipogioco,rImporto=totlire,rContanti=totcont,rFull=flagfull,rIDTicket=ticket","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"pg_allegati_portlet.jsp","target":"","type":"SPLinker","w":30,"x":1103,"y":263});
this.Documenti.m_cID='<%=JSPLib.cmdHash("entity,pg_allegati_portlet.jsp",request.getSession())%>';
this.tipogioco=new ZtVWeb._VC(this,'tipogioco',null,'character','<%=JSPLib.ToJSValue(tipogioco,false,true)%>',false,false);
this.flagfull=new ZtVWeb._VC(this,'flagfull',null,'character','<%=JSPLib.ToJSValue(flagfull,false,true)%>',false,false);
this.totlire=new ZtVWeb._VC(this,'totlire',null,'numeric',<%=totlire%>,false,false);
this.totcont=new ZtVWeb._VC(this,'totcont',null,'numeric',<%=totcont%>,false,false);
this.iddoc=new ZtVWeb._VC(this,'iddoc',null,'character','<%=JSPLib.ToJSValue(iddoc,false,true)%>',false,false);
this.RTUnlockDocs=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUnlockDocs","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUnlockDocs","offline":false,"page":1,"parms":"pID=iddoc,pTipo=origine","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_unlock_doc","target":"","type":"SPLinker","w":30,"x":1199,"y":57});
this.RTUnlockDocs.m_cID='<%=JSPLib.cmdHash("routine,arfn_unlock_doc",request.getSession())%>';
this.ticket=new ZtVWeb._VC(this,'ticket',null,'character','<%=JSPLib.ToJSValue(ticket,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_docs_admin_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_docs_admin_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_docs_admin_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Ricerca.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_docs_admin',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_docs_admin');
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
sp.endPage("pg_cgo_operazioni_agenzie_docs_admin");
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
<%! public String getJSPUID() { return "4069859223"; } %>