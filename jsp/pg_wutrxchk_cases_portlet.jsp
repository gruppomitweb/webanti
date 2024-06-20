<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.nasdata.Value(CharToDate(this.datanas.Value()));\n  this.rildata.Value(CharToDate(this.dataril.Value()));  \n  this.ricdata.Value(CharToDate(this.dataric.Value()));\n  this.cogns.Value(Strtran(this.cognome.Value(),' ',''))\n  this.nomns.Value(Strtran(this.nome.Value(),' ',''))  \n  this.nIdx.Value(Val(this.idtrx.Value()));\n  this.SQLCases.Query()\n  this.selezione.Value(\"\");\n  this.SQLKersonbo.Query()\n  this.BtnCopia.Hide()  \n}\n\nfunction grdOperazioni_Copy_AfterRowChange(currRecIdx,prevRecIdx){\n  if(this.sconnes.Value()!=\"****************\"){\n    this.BtnCopia.Show()\n  } else {\n    this.BtnCopia.Hide()\n  }  \n}\n\nfunction grdOperazioni_AfterRowChange(currRecIdx,prevRecIdx){\n  this.SQLKersonbo.Query()  \n  this.BtnCopia.Hide()    \n}\n\nfunction BtnCopia_Click(){\n  if(this.sconnes.Value()!=\"****************\") {\n    if(confirm('Confermi la copia dei dati del record selezionato?')){   \n      Set_xtipdoc(this.stipdoc.Value());\n      Set_xtnumdoc(this.snumdoc.Value());\n      Set_xluonas(this.sluonas.Value());\n      Set_FLGDATIOLD('S');\n      Set_TRXESITO('V');\n    }\n  } else {\n    alert(\"Impossibile selezionare i dati della transazione\")\n  }  \n}\n\nfunction ColoraRiga(_connes,_err) {\n  _colore='';\n  if (_connes==\"****************\") {\n    _colore='#FFFF00';\n  } else {\n    if (_err==\"*\") {\n      _colore='#F9A30D';\n    }       \n    if (_err==\"£\") {\n      _colore='#F6CCDB';\n    }    \n  }  \n  return _colore\n}\n\nfunction ColoraRigaFG(_connes) {\n  _colore='';\n  if (_connes==\"****************\") {\n    _colore='#000000';\n  }    \n  return _colore\n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"500","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"false","count":"true","h":"20","localDBName":"","n_records":"8","name":"SQLCases","offline":"false","page":"1","parms":"pIDTRX=idtrx","parms_source":"","query":"qbe_wutrxchk_cases","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"8","y":"-32"},{"appendingData":"false","auto_exec":"false","count":"true","h":"20","localDBName":"","n_records":"10000","name":"SQLKersonbo","offline":"false","page":"1","parms":"pCognome=cognome,pNome=nome,pSesso=sesso,pTipoDoc=tipodoc,pNumDoc=numdocum,pNasCom=nascomun,pNasSta=nasstato,pDatNas=datanas,pCodFis=codfisc,pDatRil=dataril,pQuery=nquery,pDatOpe=dataric,pLuoNas=luonas,pFLGNCF=flgncf","parms_source":"","query":"rows:arfn_wutrxchk_cases","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"750","y":"-29"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Caso\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXCODCASE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WCNOMCAS\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLCases","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"N,C","filters":"false","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"131","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grdOperazioni","nav_bar":"false","nav_bar_addremove":"true","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"false","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"20","zindex":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Cognome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR01%')\",\"newline\":false,\"field\":\"COGNOME\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR02%')\",\"newline\":false,\"field\":\"NOME\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nominativo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR03%')\",\"newline\":false,\"field\":\"RAGSOC\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"field\":\"LUOGONAS\",\"title\":\"Luogo Nascita\",\"font_family\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR04%')\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Nascita\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR05%')\",\"newline\":false,\"field\":\"DATANASC\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Sesso\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR06%')\",\"newline\":false,\"field\":\"SESSO\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Documento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR07%')\",\"newline\":false,\"field\":\"TIPODOC\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Numero Doc.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR08%')\",\"newline\":false,\"field\":\"NUMDOCUM\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Rilascio Doc.\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR09%')\",\"newline\":false,\"field\":\"DATARILASC\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Fiscale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR10%')\",\"newline\":false,\"field\":\"CODFISC\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"CF Validato\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:%FLGCFVALIDO%:Codice Fiscale Validato\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"CF Form. Valido\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:%FLGCGFORMAT%:Codice Fiscale Formalmente Corretto\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:RTOperazbo\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fGIF\u002f111.gif:Premere per aprire la pagina di controllo del codice fiscale\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"field\":\"image:..\u002fimages\u002fGIF\u002f088.gif:Premere per aprire la pagina di controllo del codice fiscale con i dati anagrafici\",\"title\":\"\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"SPLink:RTChkCFANAG\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%')\",\"newline\":false,\"field\":\"CONNES\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Comune Nascita\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR04%')\",\"newline\":false,\"field\":\"NASCOMUN\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Stato nascita\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%CONNES%','%ERR03%')\",\"newline\":false,\"field\":\"NASSTATO\",\"fg_color\":\"function:ColoraRigaFG('%CONNES%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLKersonbo","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"C,C,C,C,D,C,C,C,D,C,,,,C,C","filters":"false","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"216","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grdOperazioni_Copy","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"RecordSelezionato","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"false","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"6","scroll_bars":"false","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"203","zindex":""},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"#030BFF","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblTitolo","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"RILIEVI","w":"1024","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"#030BFF","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblTitolo_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"SOGGETTI CHE CREANO IL RILIEVO","w":"1024","wireframe_props":"align,value,n_col","x":"0","y":"183","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"19","help_tips":"Copia i dati selezionati per correggere","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layout_steps_values":"{}","name":"BtnCopia","page":"1","path_type":"","sequence":"7","server_side":"","src":"..\u002fimages\u002fGIF\u002f008.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"19","wireframe_props":"","x":"1001","y":"183","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"26","name":"cognome","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"69","wireframe_props":"name","x":"245","y":"-26","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"25","name":"nome","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"9","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"76","wireframe_props":"name","x":"1057","y":"29","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"35","name":"nascomun","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"262","wireframe_props":"name","x":"1054","y":"116","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"2","name":"sesso","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"87","wireframe_props":"name","x":"1057","y":"52","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"tipodoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"12","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"68","wireframe_props":"name","x":"1057","y":"146","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"30","name":"numdocum","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"225","wireframe_props":"name","x":"1052","y":"-24","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"18","name":"codfisc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"14","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"135","wireframe_props":"name","x":"1057","y":"82","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"CharToDate(datanas)","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"nasdata","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","tabindex":"","type":"Textbox","typevar":"date","visible":"false","w":"73","wireframe_props":"name","x":"327","y":"-25","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"35","name":"nasstato","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"16","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"262","wireframe_props":"name","x":"1054","y":"180","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"SQLCases","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TRXNQUERY","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"nquery","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"17","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"68","wireframe_props":"name","x":"1062","y":"272","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"CharToDate(datanas)","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"rildata","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"18","tabindex":"","type":"Textbox","typevar":"date","visible":"false","w":"73","wireframe_props":"name","x":"1054","y":"212","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"datanas","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"19","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"67","wireframe_props":"name","x":"856","y":"-30","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"dataric","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"20","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"67","wireframe_props":"name","x":"949","y":"-29","zerofilling":"false","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"ricdata","page":"1","sequence":"21","server_side":"false","type":"Variable","typevar":"date","w":"149","x":"1193","y":"38"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"cogns","page":"1","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"64","x":"656","y":"-31"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"nomns","page":"1","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"65","x":"579","y":"-28"},{"async":"false","entity_type":"","h":"30","m_cAction":"","name":"RTOperazbo","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"popup","popup_width":"","progressbar":"","refresh":"","sequence":"24","servlet":"https:\u002f\u002ftelematici.agenziaentrate.gov.it\u002fVerificaCF\u002fScegli.do?parameter=verificaCf","target":"","type":"SPLinker","w":"203","x":"1047","y":"444"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"dataril","page":"1","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"71","x":"496","y":"-26"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"idtrx","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"26","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"149","wireframe_props":"name","x":"1054","y":"242","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"SQLCases","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"WCDESCRI","floating_placeholder":"","font":"Verdana","font_color":"#FF0000","font_size":"7pt","h":"24","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"vDerscizione","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"27","tabindex":"","type":"Textbox","typevar":"memo","visible":"true","w":"1015","wireframe_props":"name","x":"4","y":"155","zerofilling":"false","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"nIdx","page":"1","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"1054","y":"302"},{"async":"false","entity_type":"","h":"30","m_cAction":"start","name":"PGKersonbo","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"29","servlet":"","target":"","type":"SPLinker","w":"190","x":"1046","y":"407"},{"calculate":"","dataobj":"SQLKersonbo","field":"CODFISC","h":"20","init":"","init_par":"","name":"scodfisc","page":"1","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"6","y":"673"},{"calculate":"","dataobj":"SQLKersonbo","field":"COGNOME","h":"20","init":"","init_par":"","name":"scognome","page":"1","sequence":"31","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"168","y":"677"},{"calculate":"","dataobj":"SQLKersonbo","field":"NOME","h":"20","init":"","init_par":"","name":"snome","page":"1","sequence":"32","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"330","y":"675"},{"calculate":"","dataobj":"SQLKersonbo","field":"SESSO","h":"20","init":"","init_par":"","name":"ssesso","page":"1","sequence":"33","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"496","y":"673"},{"calculate":"","dataobj":"SQLKersonbo","field":"CONNES","h":"20","init":"","init_par":"","name":"selezione","page":"1","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"658","y":"673"},{"calculate":"","dataobj":"SQLKersonbo","field":"CONNES","h":"20","init":"","init_par":"","name":"sconnes","page":"1","sequence":"35","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"833","y":"674"},{"calculate":"","dataobj":"SQLKersonbo","field":"DOCTYPE","h":"20","init":"","init_par":"","name":"stipdoc","page":"1","sequence":"36","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"8","y":"523"},{"calculate":"","dataobj":"SQLKersonbo","field":"NUMDOCUM","h":"20","init":"","init_par":"","name":"snumdoc","page":"1","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"149","y":"525"},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"RTChkCFANAG","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"popup","popup_width":"","progressbar":"","refresh":"","sequence":"38","servlet":"https:\u002f\u002ftelematici.agenziaentrate.gov.it\u002fVerificaCF\u002fScegli.do?parameter=verificaCfPf","target":"","type":"SPLinker","w":"120","x":"1049","y":"5"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"50","name":"luonas","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"39","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"375","wireframe_props":"name","x":"1053","y":"330","zerofilling":"false","zindex":"2"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"flgcnf","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"40","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"120","wireframe_props":"name","x":"1070","y":"361","zerofilling":"false","zindex":"3"},{"calculate":"","dataobj":"SQLKersonbo","field":"LUOGONAS","h":"20","init":"","init_par":"","name":"sluonas","page":"1","sequence":"41","server_side":"false","type":"Variable","typevar":"character","w":"214","x":"298","y":"528"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:cognome,nome,nascomun,sesso,tipodoc,numdocum,codfisc,nasstato,datanas,dataric,dataril,idtrx,luonas,flgcnf*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
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
window.pg_wutrxchk_cases_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof grdOperazioni_Copy_AfterRowChange !='undefined')this.grdOperazioni_Copy_AfterRowChange=grdOperazioni_Copy_AfterRowChange;
if(typeof grdOperazioni_AfterRowChange !='undefined')this.grdOperazioni_AfterRowChange=grdOperazioni_AfterRowChange;
if(typeof BtnCopia_Click !='undefined')this.BtnCopia_Click=BtnCopia_Click;
if(typeof ColoraRiga !='undefined')this.ColoraRiga=ColoraRiga;
if(typeof ColoraRigaFG !='undefined')this.ColoraRigaFG=ColoraRigaFG;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
ZtVWeb.CalcCtrl(CharToDate(this.datanas.Value()),this.nasdata);
ZtVWeb.CalcCtrl(CharToDate(this.datanas.Value()),this.rildata);
}
this.SQLCases.addRowConsumer(this.grdOperazioni);
this.SQLKersonbo.addRowConsumer(this.grdOperazioni_Copy);
this.SQLCases.addDataConsumer(this.nquery,<%=JSPLib.ToJSValue("TRXNQUERY",true)%>);
this.SQLCases.addDataConsumer(this.vDerscizione,<%=JSPLib.ToJSValue("WCDESCRI",true)%>);
this.SQLKersonbo.addDataConsumer(this.scodfisc,<%=JSPLib.ToJSValue("CODFISC",true)%>);
this.SQLKersonbo.addDataConsumer(this.scognome,<%=JSPLib.ToJSValue("COGNOME",true)%>);
this.SQLKersonbo.addDataConsumer(this.snome,<%=JSPLib.ToJSValue("NOME",true)%>);
this.SQLKersonbo.addDataConsumer(this.ssesso,<%=JSPLib.ToJSValue("SESSO",true)%>);
this.SQLKersonbo.addDataConsumer(this.selezione,<%=JSPLib.ToJSValue("CONNES",true)%>);
this.SQLKersonbo.addDataConsumer(this.sconnes,<%=JSPLib.ToJSValue("CONNES",true)%>);
this.SQLKersonbo.addDataConsumer(this.stipdoc,<%=JSPLib.ToJSValue("DOCTYPE",true)%>);
this.SQLKersonbo.addDataConsumer(this.snumdoc,<%=JSPLib.ToJSValue("NUMDOCUM",true)%>);
this.SQLKersonbo.addDataConsumer(this.sluonas,<%=JSPLib.ToJSValue("LUOGONAS",true)%>);
function this_Loaded(){
  this.nasdata.Value(CharToDate(this.datanas.Value()));
  this.rildata.Value(CharToDate(this.dataril.Value()));  
  this.ricdata.Value(CharToDate(this.dataric.Value()));
  this.cogns.Value(Strtran(this.cognome.Value(),' ',''))
  this.nomns.Value(Strtran(this.nome.Value(),' ',''))  
  this.nIdx.Value(Val(this.idtrx.Value()));
  this.SQLCases.Query()
  this.selezione.Value("");
  this.SQLKersonbo.Query()
  this.BtnCopia.Hide()  
}
function grdOperazioni_Copy_AfterRowChange(currRecIdx,prevRecIdx){
  if(this.sconnes.Value()!="****************"){
    this.BtnCopia.Show()
  } else {
    this.BtnCopia.Hide()
  }  
}
function grdOperazioni_AfterRowChange(currRecIdx,prevRecIdx){
  this.SQLKersonbo.Query()  
  this.BtnCopia.Hide()    
}
function BtnCopia_Click(){
  if(this.sconnes.Value()!="****************") {
    if(confirm('Confermi la copia dei dati del record selezionato?')){   
      Set_xtipdoc(this.stipdoc.Value());
      Set_xtnumdoc(this.snumdoc.Value());
      Set_xluonas(this.sluonas.Value());
      Set_FLGDATIOLD('S');
      Set_TRXESITO('V');
    }
  } else {
    alert("Impossibile selezionare i dati della transazione")
  }  
}
function ColoraRiga(_connes,_err) {
  _colore='';
  if (_connes=="****************") {
    _colore='#FFFF00';
  } else {
    if (_err=="*") {
      _colore='#F9A30D';
    }       
    if (_err=="£") {
      _colore='#F6CCDB';
    }    
  }  
  return _colore
}
function ColoraRigaFG(_connes) {
  _colore='';
  if (_connes=="****************") {
    _colore='#000000';
  }    
  return _colore
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
.pg_wutrxchk_cases_container {
}
.pg_wutrxchk_cases_title_container {
  margin: auto;
}
.pg_wutrxchk_cases_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:500px;
  background-color:#FFFFFF;
}
.pg_wutrxchk_cases_portlet[Data-page="1"]{
  height:500px;
  width:100%;
}
.pg_wutrxchk_cases_portlet > .grdOperazioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:131px;
}
.pg_wutrxchk_cases_portlet > .grdOperazioni_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:203px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:216px;
}
.pg_wutrxchk_cases_portlet > .lblTitolo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_wutrxchk_cases_portlet > .lblTitolo_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wutrxchk_cases_portlet > .lblTitolo_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:10pt;
  font-weight:bold;
  color:#EFF702;
  text-align:center;
  background-color:#030BFF;
}
.pg_wutrxchk_cases_portlet > .lblTitolo_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:183px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_wutrxchk_cases_portlet > .lblTitolo_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wutrxchk_cases_portlet > .lblTitolo_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:10pt;
  font-weight:bold;
  color:#EFF702;
  text-align:center;
  background-color:#030BFF;
}
.pg_wutrxchk_cases_portlet > .BtnCopia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:183px;
  right:4px;
  width:19px;
  height:19px;
}
.pg_wutrxchk_cases_portlet > .BtnCopia_ctrl {
}
.pg_wutrxchk_cases_portlet > .BtnCopia_ctrl > img{
  width:100%;
  vertical-align:top;
  height:19px;
}
.pg_wutrxchk_cases_portlet > .cognome_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .cognome_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .cognome_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .nome_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .nome_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .nome_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .nascomun_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .nascomun_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .nascomun_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .sesso_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .sesso_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .sesso_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .tipodoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .tipodoc_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .tipodoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .numdocum_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .numdocum_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .numdocum_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .codfisc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .codfisc_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .codfisc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .nasdata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .nasdata_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .nasdata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .nasstato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .nasstato_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .nasstato_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .nquery_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .nquery_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .nquery_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .rildata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .rildata_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .rildata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .datanas_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .datanas_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .datanas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .dataric_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .dataric_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .dataric_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .idtrx_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .idtrx_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .idtrx_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .vDerscizione_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:155px;
  left:4px;
  width:1015px;
  height:24px;
}
.pg_wutrxchk_cases_portlet > .vDerscizione_ctrl {
}
.pg_wutrxchk_cases_portlet > .vDerscizione_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  font-color:;color:#FF0000;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .luonas_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .luonas_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .luonas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wutrxchk_cases_portlet > .flgcnf_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wutrxchk_cases_portlet > .flgcnf_ctrl {
  display:none;
}
.pg_wutrxchk_cases_portlet > .flgcnf_ctrl > input{
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"8\",\"y\":\"-32\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"750\",\"y\":\"-29\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Caso\"},{\"title\":\"Descrizione\"}],\"h\":\"131\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Cognome\"},{\"title\":\"Nome\"},{\"title\":\"Nominativo\"},{\"title\":\"Luogo Nascita\"},{\"title\":\"Data Nascita\"},{\"title\":\"Sesso\"},{\"title\":\"Tipo Documento\"},{\"title\":\"Numero Doc.\"},{\"title\":\"Data Rilascio Doc.\"},{\"title\":\"Codice Fiscale\"},{\"title\":\"CF Validato\"},{\"title\":\"CF Form. Valido\"},{\"title\":\"\"},{\"title\":\"\"},{\"title\":\"Codice Collegamento\"},{\"title\":\"Comune Nascita\"},{\"title\":\"Stato nascita\"}],\"h\":\"216\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"6\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"203\",\"zindex\":\"\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"RILIEVI\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"SOGGETTI CHE CREANO IL RILIEVO\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"183\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"19\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"19\",\"x\":\"1001\",\"y\":\"183\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cognome\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"69\",\"x\":\"245\",\"y\":\"-26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nome\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"76\",\"x\":\"1057\",\"y\":\"29\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nascomun\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"1054\",\"y\":\"116\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sesso\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"87\",\"x\":\"1057\",\"y\":\"52\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipodoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"68\",\"x\":\"1057\",\"y\":\"146\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"numdocum\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"225\",\"x\":\"1052\",\"y\":\"-24\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codfisc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"135\",\"x\":\"1057\",\"y\":\"82\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nasdata\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"73\",\"x\":\"327\",\"y\":\"-25\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nasstato\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"1054\",\"y\":\"180\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nquery\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"68\",\"x\":\"1062\",\"y\":\"272\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"rildata\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"73\",\"x\":\"1054\",\"y\":\"212\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"datanas\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"67\",\"x\":\"856\",\"y\":\"-30\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dataric\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"67\",\"x\":\"949\",\"y\":\"-29\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"ricdata\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1193\",\"y\":\"38\"},{\"h\":\"20\",\"name\":\"cogns\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"64\",\"x\":\"656\",\"y\":\"-31\"},{\"h\":\"20\",\"name\":\"nomns\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"65\",\"x\":\"579\",\"y\":\"-28\"},{\"h\":\"30\",\"name\":\"RTOperazbo\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"203\",\"x\":\"1047\",\"y\":\"444\"},{\"h\":\"20\",\"name\":\"dataril\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"71\",\"x\":\"496\",\"y\":\"-26\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"idtrx\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"149\",\"x\":\"1054\",\"y\":\"242\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"vDerscizione\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"1015\",\"x\":\"4\",\"y\":\"155\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"nIdx\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1054\",\"y\":\"302\"},{\"h\":\"30\",\"name\":\"PGKersonbo\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"190\",\"x\":\"1046\",\"y\":\"407\"},{\"h\":\"20\",\"name\":\"scodfisc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"6\",\"y\":\"673\"},{\"h\":\"20\",\"name\":\"scognome\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"168\",\"y\":\"677\"},{\"h\":\"20\",\"name\":\"snome\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"330\",\"y\":\"675\"},{\"h\":\"20\",\"name\":\"ssesso\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"496\",\"y\":\"673\"},{\"h\":\"20\",\"name\":\"selezione\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"658\",\"y\":\"673\"},{\"h\":\"20\",\"name\":\"sconnes\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"833\",\"y\":\"674\"},{\"h\":\"20\",\"name\":\"stipdoc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"8\",\"y\":\"523\"},{\"h\":\"20\",\"name\":\"snumdoc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"149\",\"y\":\"525\"},{\"h\":\"20\",\"name\":\"RTChkCFANAG\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1049\",\"y\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"luonas\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"1053\",\"y\":\"330\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"flgcnf\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"361\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"sluonas\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"214\",\"x\":\"298\",\"y\":\"528\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_wutrxchk_cases","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_wutrxchk_cases_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_wutrxchk_cases','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_wutrxchk_cases_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String lblTitolo= "RILIEVI";
String lblTitolo_Copy= "SOGGETTI CHE CREANO IL RILIEVO";
String cognome=JSPLib.translateXSS(sp.getParameter("cognome",""));
if(request.getAttribute("pg_wutrxchk_cases_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String nome=JSPLib.translateXSS(sp.getParameter("nome",""));
String nascomun=JSPLib.translateXSS(sp.getParameter("nascomun",""));
String sesso=JSPLib.translateXSS(sp.getParameter("sesso",""));
String tipodoc=JSPLib.translateXSS(sp.getParameter("tipodoc",""));
String numdocum=JSPLib.translateXSS(sp.getParameter("numdocum",""));
String codfisc=JSPLib.translateXSS(sp.getParameter("codfisc",""));
java.sql.Date nasdata= JSPLib.NullDate();
String nasstato=JSPLib.translateXSS(sp.getParameter("nasstato",""));
String nquery= "";
java.sql.Date rildata= JSPLib.NullDate();
String datanas=JSPLib.translateXSS(sp.getParameter("datanas",""));
String dataric=JSPLib.translateXSS(sp.getParameter("dataric",""));
java.sql.Date ricdata= JSPLib.NullDate();
String cogns= "";
String nomns= "";
String dataril=JSPLib.translateXSS(sp.getParameter("dataril",""));
String idtrx=JSPLib.translateXSS(sp.getParameter("idtrx",""));
String vDerscizione= "";
String nIdx= "";
String scodfisc= "";
String scognome= "";
String snome= "";
String ssesso= "";
String selezione= "";
String sconnes= "";
String stipdoc= "";
String snumdoc= "";
String luonas=JSPLib.translateXSS(sp.getParameter("luonas",""));
String flgcnf=JSPLib.translateXSS(sp.getParameter("flgcnf",""));
String sluonas= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_wutrxchk_cases_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_wutrxchk_cases_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_wutrxchk_cases','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grdOperazioni' formid='<%=idPortlet%>' ps-name='grdOperazioni'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_grdOperazioni_Copy' formid='<%=idPortlet%>' ps-name='grdOperazioni_Copy'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_lblTitolo'  formid='<%=idPortlet%>' ps-name='lblTitolo'    class='label lblTitolo_ctrl'><div id='<%=idPortlet%>_lblTitolotbl' style='width:100%;'><%=JSPLib.ToHTML("RILIEVI")%></div></span>
<span id='<%=idPortlet%>_lblTitolo_Copy'  formid='<%=idPortlet%>' ps-name='lblTitolo_Copy'    class='label lblTitolo_Copy_ctrl'><div id='<%=idPortlet%>_lblTitolo_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("SOGGETTI CHE CREANO IL RILIEVO")%></div></span>
<div id='<%=idPortlet%>_BtnCopia'>
<img id='<%=idPortlet%>_BtnCopia_img' class='image BtnCopia_ctrl' src="../images/GIF/008.gif" >
</div>
<span class='textbox-container'id='<%=idPortlet%>_cognome_wrp'><input id='<%=idPortlet%>_cognome' name='cognome' type='hidden' maxlength='26' class='textbox' formid='<%=idPortlet%>' ps-name='cognome' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nome_wrp'><input id='<%=idPortlet%>_nome' name='nome' type='hidden' maxlength='25' class='textbox' formid='<%=idPortlet%>' ps-name='nome' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nascomun_wrp'><input id='<%=idPortlet%>_nascomun' name='nascomun' type='hidden' maxlength='35' class='textbox' formid='<%=idPortlet%>' ps-name='nascomun' /></span>
<span class='textbox-container'id='<%=idPortlet%>_sesso_wrp'><input id='<%=idPortlet%>_sesso' name='sesso' type='hidden' maxlength='2' class='textbox' formid='<%=idPortlet%>' ps-name='sesso' /></span>
<span class='textbox-container'id='<%=idPortlet%>_tipodoc_wrp'><input id='<%=idPortlet%>_tipodoc' name='tipodoc' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='tipodoc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_numdocum_wrp'><input id='<%=idPortlet%>_numdocum' name='numdocum' type='hidden' maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='numdocum' /></span>
<span class='textbox-container'id='<%=idPortlet%>_codfisc_wrp'><input id='<%=idPortlet%>_codfisc' name='codfisc' type='hidden' maxlength='18' class='textbox' formid='<%=idPortlet%>' ps-name='codfisc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nasdata_wrp'><input id='<%=idPortlet%>_nasdata' name='nasdata' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='nasdata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nasstato_wrp'><input id='<%=idPortlet%>_nasstato' name='nasstato' type='hidden' maxlength='35' class='textbox' formid='<%=idPortlet%>' ps-name='nasstato' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nquery_wrp'><input id='<%=idPortlet%>_nquery' name='nquery' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='nquery' /></span>
<span class='textbox-container'id='<%=idPortlet%>_rildata_wrp'><input id='<%=idPortlet%>_rildata' name='rildata' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='rildata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_datanas_wrp'><input id='<%=idPortlet%>_datanas' name='datanas' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='datanas' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dataric_wrp'><input id='<%=idPortlet%>_dataric' name='dataric' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='dataric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_idtrx_wrp'><input id='<%=idPortlet%>_idtrx' name='idtrx' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='idtrx' /></span>
<span class='textbox-container'id='<%=idPortlet%>_vDerscizione_wrp'><input id='<%=idPortlet%>_vDerscizione' name='vDerscizione' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='vDerscizione' /></span>
<span class='textbox-container'id='<%=idPortlet%>_luonas_wrp'><input id='<%=idPortlet%>_luonas' name='luonas' type='hidden' maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='luonas' /></span>
<span class='textbox-container'id='<%=idPortlet%>_flgcnf_wrp'><input id='<%=idPortlet%>_flgcnf' name='flgcnf' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='flgcnf' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_wutrxchk_cases');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_wutrxchk_cases',["1024"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"500","title":"","layer":"false","npage":"1"}]);
this.SQLCases=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_wutrxchk_cases","cmdHash":"<%=JSPLib.cmdHash("qbe_wutrxchk_cases",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLCases","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLCases","nrows":"8","page":1,"parms":"pIDTRX=idtrx","parms_source":"","type":"SQLDataobj","w":120,"x":8,"y":-32});
this.SQLKersonbo=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"rows:arfn_wutrxchk_cases","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_wutrxchk_cases",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLKersonbo","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLKersonbo","nrows":"10000","page":1,"parms":"pCognome=cognome,pNome=nome,pSesso=sesso,pTipoDoc=tipodoc,pNumDoc=numdocum,pNasCom=nascomun,pNasSta=nasstato,pDatNas=datanas,pCodFis=codfisc,pDatRil=dataril,pQuery=nquery,pDatOpe=dataric,pLuoNas=luonas,pFLGNCF=flgncf","parms_source":"","type":"SQLDataobj","w":120,"x":750,"y":-29});
this.grdOperazioni=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdOperazioni","dataobj":"SQLCases","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":131,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grdOperazioni","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":20,"zindex":""});
this.grdOperazioni.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Caso","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXCODCASE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WCNOMCAS","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.grdOperazioni_Copy=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdOperazioni_Copy","dataobj":"SQLKersonbo","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":216,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grdOperazioni_Copy","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"RecordSelezionato","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":203,"zindex":""});
this.grdOperazioni_Copy.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":6,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Cognome","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR01%')","field":"COGNOME","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Nome","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR02%')","field":"NOME","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Nominativo","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR03%')","field":"RAGSOC","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Luogo Nascita","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR04%')","field":"LUOGONAS","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Nascita","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR05%')","field":"DATANASC","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Sesso","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR06%')","field":"SESSO","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Documento","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR07%')","field":"TIPODOC","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Numero Doc.","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR08%')","field":"NUMDOCUM","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Rilascio Doc.","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR09%')","field":"DATARILASC","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Fiscale","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR10%')","field":"CODFISC","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"CF Validato","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:%FLGCFVALIDO%:Codice Fiscale Validato","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"CF Form. Valido","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:%FLGCGFORMAT%:Codice Fiscale Formalmente Corretto","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"SPLink:RTOperazbo","fixedwidth":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"image:..\u002fimages\u002fGIF\u002f111.gif:Premere per aprire la pagina di controllo del codice fiscale","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"SPLink:RTChkCFANAG","fixedwidth":"","title":"","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"image:..\u002fimages\u002fGIF\u002f088.gif:Premere per aprire la pagina di controllo del codice fiscale con i dati anagrafici","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Collegamento","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":true,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%')","field":"CONNES","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Comune Nascita","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":true,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR04%')","field":"NASCOMUN","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Stato nascita","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":true,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%CONNES%','%ERR03%')","field":"NASSTATO","droppable_name":"","fg_color":"function:ColoraRigaFG('%CONNES%')","width":"","RowSpan":0,"font_family":""}]});
this.lblTitolo=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitolo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitolo","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblTitolo,false,true)%>","type":"Label","w":1024,"x":0,"y":0,"zindex":"1"});
this.lblTitolo_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitolo_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitolo_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblTitolo_Copy,false,true)%>","type":"Label","w":1024,"x":0,"y":183,"zindex":"1"});
this.BtnCopia=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnCopia_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnCopia","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":19,"help_tips":"<%=JSPLib.ToJSValue("Copia i dati selezionati per correggere",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnCopia","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fGIF\u002f008.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":19,"x":1001,"y":183,"zindex":"1"});
this.cognome=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cognome","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"26","name":"cognome","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cognome,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.nome=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nome","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"25","name":"nome","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nome,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.nascomun=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nascomun","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"35","name":"nascomun","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nascomun,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.sesso=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sesso","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"2","name":"sesso","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sesso,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.tipodoc=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tipodoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"tipodoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tipodoc,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.numdocum=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_numdocum","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"30","name":"numdocum","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(numdocum,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.codfisc=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codfisc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"18","name":"codfisc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codfisc,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.nasdata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"CharToDate(this.datanas.Value())","create_undercond":"","ctrlid":"<%=idPortlet%>_nasdata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nasdata","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=nasdata%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.nasstato=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nasstato","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"35","name":"nasstato","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nasstato,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.nquery=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nquery","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TRXNQUERY","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nquery","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nquery,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.rildata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"CharToDate(this.datanas.Value())","create_undercond":"","ctrlid":"<%=idPortlet%>_rildata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"rildata","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=rildata%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.datanas=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_datanas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"datanas","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(datanas,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.dataric=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dataric","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"dataric","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(dataric,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.ricdata=new ZtVWeb._VC(this,'ricdata',null,'date','<%=ricdata%>',false,false);
this.cogns=new ZtVWeb._VC(this,'cogns',null,'character','<%=JSPLib.ToJSValue(cogns,false,true)%>',false,false);
this.nomns=new ZtVWeb._VC(this,'nomns',null,'character','<%=JSPLib.ToJSValue(nomns,false,true)%>',false,false);
this.RTOperazbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTOperazbo","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTOperazbo","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"popup","popup_width":"","progressbar":false,"refresh":"","servlet":"https:\u002f\u002ftelematici.agenziaentrate.gov.it\u002fVerificaCF\u002fScegli.do?parameter=verificaCf","target":"","type":"SPLinker","w":203,"x":1047,"y":444});
this.RTOperazbo.m_cID='<%=JSPLib.cmdHash("entity,https://telematici.agenziaentrate.gov.it/VerificaCF/Scegli.do?parameter=verificaCf",request.getSession())%>';
this.dataril=new ZtVWeb._VC(this,'dataril',null,'character','<%=JSPLib.ToJSValue(dataril,false,true)%>',false,false);
this.idtrx=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_idtrx","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"idtrx","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(idtrx,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.vDerscizione=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_vDerscizione","decrypt":false,"edit_undercond":"","encrypt":false,"field":"WCDESCRI","fixed":"false","floating_placeholder":false,"h":24,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"vDerscizione","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"memo","value":"<%=JSPLib.ToJSValue(vDerscizione,false,true)%>","w":1015,"x":4,"y":155,"zerofilling":false,"zindex":"1","zoom":""});
this.nIdx=new ZtVWeb._VC(this,'nIdx',null,'character','<%=JSPLib.ToJSValue(nIdx,false,true)%>',false,false);
this.PGKersonbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_PGKersonbo","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"PGKersonbo","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":190,"x":1046,"y":407});
this.PGKersonbo.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.scodfisc=new ZtVWeb._VC(this,'scodfisc',null,'character','<%=JSPLib.ToJSValue(scodfisc,false,true)%>',false,false);
this.scognome=new ZtVWeb._VC(this,'scognome',null,'character','<%=JSPLib.ToJSValue(scognome,false,true)%>',false,false);
this.snome=new ZtVWeb._VC(this,'snome',null,'character','<%=JSPLib.ToJSValue(snome,false,true)%>',false,false);
this.ssesso=new ZtVWeb._VC(this,'ssesso',null,'character','<%=JSPLib.ToJSValue(ssesso,false,true)%>',false,false);
this.selezione=new ZtVWeb._VC(this,'selezione',null,'character','<%=JSPLib.ToJSValue(selezione,false,true)%>',false,false);
this.sconnes=new ZtVWeb._VC(this,'sconnes',null,'character','<%=JSPLib.ToJSValue(sconnes,false,true)%>',false,false);
this.stipdoc=new ZtVWeb._VC(this,'stipdoc',null,'character','<%=JSPLib.ToJSValue(stipdoc,false,true)%>',false,false);
this.snumdoc=new ZtVWeb._VC(this,'snumdoc',null,'character','<%=JSPLib.ToJSValue(snumdoc,false,true)%>',false,false);
this.RTChkCFANAG=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChkCFANAG","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChkCFANAG","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"popup","popup_width":"","progressbar":false,"refresh":"","servlet":"https:\u002f\u002ftelematici.agenziaentrate.gov.it\u002fVerificaCF\u002fScegli.do?parameter=verificaCfPf","target":"","type":"SPLinker","w":120,"x":1049,"y":5});
this.RTChkCFANAG.m_cID='<%=JSPLib.cmdHash("entity,https://telematici.agenziaentrate.gov.it/VerificaCF/Scegli.do?parameter=verificaCfPf",request.getSession())%>';
this.luonas=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_luonas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"50","name":"luonas","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(luonas,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"2","zoom":""});
this.flgcnf=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_flgcnf","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"flgcnf","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(flgcnf,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"3","zoom":""});
this.sluonas=new ZtVWeb._VC(this,'sluonas',null,'character','<%=JSPLib.ToJSValue(sluonas,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_wutrxchk_cases_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_wutrxchk_cases_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_wutrxchk_cases_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_wutrxchk_cases',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_wutrxchk_cases');
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
sp.endPage("pg_wutrxchk_cases");
}%>
<%! public String getJSPUID() { return "1985067681"; } %>