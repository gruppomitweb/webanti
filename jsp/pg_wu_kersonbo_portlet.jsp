<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.selezione.Value(\"\");\n  this.nasdata.Value(CharToDate(this.datanas.Value()));\n  this.rildata.Value(CharToDate(this.dataril.Value()));  \n  this.cogns.Value(Strtran(this.cognome.Value(),' ',''))\n  this.nomns.Value(Strtran(this.nome.Value(),' ',''))  \n  this.SQLKersonbo.Query()\n  \n}\n\nfunction BtnUscita_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    window.close()\n  }    \n}\n\nfunction BtnCopia_Click(){\n  if(confirm('Confermi la copia dei dati del record selezionato?')){   \n    window.parent.opener.Set_TRXCODFIS(this.scodfisc.Value());\n    window.parent.opener.Set_TRXCOGNOM(this.scognome.Value());\n    window.parent.opener.Set_TRXNOME(this.snome.Value());    \n    window.parent.opener.Set_TRXSESSO(iif(this.ssesso.Value()=='1','M','F'));\n    window.parent.opener.Set_FLGDATIOLD('S');\n\u002f\u002f    window.close()\n  }           \n}\n\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#FFFFFF","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"650","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"1024","version":"37","w":"100%"},{"auto_exec":"false","count":"true","localDBName":" ","n_records":"10000","name":"SQLKersonbo","offline":"false","page":"1","parms":"pCognome=cogns,pNome=nomns,pSesso=sesso,pTipoDoc=tipodoc,pNumDoc=numdocum,pNasCom=nascomun,pNasSta=nasstato,pDatNas=datanas,pCodFis=codfisc,pDatRil=dataril,pQuery=nquery,pDatOpe=dataric","parms_source":" ","query":"rows:arfn_wutrxchk_cases","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","x":"8","y":"-32"},{"align":"left","anchor":"top-left-right","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":" ","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:RTKersonbo\",\"weight\":\"\",\"title\":\"Codice Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CONNES\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nominativo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAGSOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Stato nascita\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NASSTATO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Comune Nascita\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NASCOMUN\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Nascita\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATANASC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Sesso\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SESSO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Documento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPODOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Numero Doc.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMDOCUM\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Rilascio Doc.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATARILASC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Fiscale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODFISC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:%FLGCFVALIDO%:Codice Fiscale Validato\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:%FLGCGFORMAT%:Codice Fiscale Formalmente Corretto\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:RTOperazbo\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\\u002fimages\\u002fGIF\\u002f111.gif:Premere per visualizzare le operazioni collegate\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"SQLKersonbo","disable_fields_conditions":" ","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,C,C,C,D,C,C,C,D,C,,,","filters":"true-by-example","floatRows":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","group_repeated":"false","h":"479","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":" ","link_underlined":" ","name":"grdOperazioni","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":" ","orderby_list":" ","outDataObj":"RecordSelezionato","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":"true","recMark":"true","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"20","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":"top","w":"1024","x":"0","y":"102"},{"align":"center","anchor":"top-left-right","assoc_input":" ","bg_color":"#030BFF","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblTitolo","nowrap":"false","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"VISUALIZZAZIONE SOGGETTI CORRELATI","w":"1024","x":"0","y":"0","zindex":"1"},{"alt":" ","anchor":"top-right","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":"Premere il bottone per chiudere la finestra","hide_undercond":" ","href":" ","img_type":"default","name":"BtnUscita","page":"1","path_type":" ","sequence":"9","server_side":" ","src":"..\u002fimages\u002fexit.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"981","y":"64","zindex":"1"},{"alt":" ","anchor":"top-right","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":"Premere il bottone per copiare i dati del record selezionato","hide_undercond":" ","href":" ","img_type":"default","name":"BtnCopia","page":"1","path_type":" ","sequence":"10","server_side":" ","src":"..\u002fimages\u002fcopia.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"933","y":"64","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"26","name":"cognome","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"12","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"195","x":"64","y":"22","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"25","name":"nome","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"13","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"187","x":"314","y":"22","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"35","name":"nascomun","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"262","x":"603","y":"48","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"2","name":"sesso","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"21","x":"558","y":"22","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"tipodoc","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"68","x":"65","y":"74","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"30","name":"numdocum","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"225","x":"235","y":"74","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"18","name":"codfisc","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"135","x":"683","y":"22","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":"CharToDate(datanas)","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"nasdata","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"73","x":"64","y":"48","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"35","name":"nasstato","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"262","x":"235","y":"48","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"nquery","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"false","w":"68","x":"933","y":"-30","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":"CharToDate(datanas)","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"rildata","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"73","x":"604","y":"75","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"datanas","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"15","tabindex":" ","type":"Textbox","typevar":"character","visible":"false","w":"67","x":"856","y":"-30","zerofilling":"false","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblCognome","nowrap":"false","page":"1","picture":" ","sequence":"16","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Cognome:","w":"56","x":"6","y":"26","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblNome","nowrap":"false","page":"1","picture":" ","sequence":"16","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Nome:","w":"45","x":"267","y":"26","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblSesso","nowrap":"false","page":"1","picture":" ","sequence":"16","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Sesso:","w":"43","x":"513","y":"26","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lbldatNas","nowrap":"false","page":"1","picture":" ","sequence":"16","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Nato il:","w":"56","x":"6","y":"53","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblTipDoc","nowrap":"false","page":"1","picture":" ","sequence":"16","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Tipo Doc.:","w":"56","x":"6","y":"77","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblCodFis","nowrap":"false","page":"1","picture":" ","sequence":"17","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Codice Fiscale:","w":"84","x":"597","y":"26","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblNasStato","nowrap":"false","page":"1","picture":" ","sequence":"17","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Stato di Nascita:","w":"88","x":"145","y":"53","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblNasComun","nowrap":"false","page":"1","picture":" ","sequence":"17","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Comune di Nascita:","w":"98","x":"504","y":"53","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblNumDoc","nowrap":"false","page":"1","picture":" ","sequence":"17","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"N. Documento:","w":"88","x":"145","y":"78","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblRilData","nowrap":"false","page":"1","picture":" ","sequence":"17","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Data di rilascio documento:","w":"137","x":"465","y":"78","zindex":"1"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"cogns","page":"1","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"64","x":"656","y":"-31"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"nomns","page":"1","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"65","x":"579","y":"-28"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","m_cAltInterface":" ","name":"RTKersonbo","offline":"false","page":"1","parms":"CONNES=connesdoc","popup":"true","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"19","servlet":"armt_kersonbo","target":" ","type":"SPLinker","w":"30","x":"115","y":"-40"},{"async":"false","entity_type":"page","h":"30","m_cAction":"view","m_cAltInterface":" ","name":"RTOperazbo","offline":"false","page":"1","parms":"w_connesdoc=connesdoc","popup":"true","popup_height":"440","popup_scroll":"false","popup_style":"by skin","popup_width":"1050","refresh":" ","sequence":"19","servlet":"..\u002fjsp\u002fpg_kersonbo_operazioni_portlet.jsp","target":" ","type":"SPLinker","w":"30","x":"160","y":"-40"},{"calculate":" ","dataobj":"SQLKersonbo","field":"CONNES","h":"20","init":" ","init_par":" ","name":"connesdoc","page":"1","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"97","x":"749","y":"-25"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":"request","name":"dataril","page":"1","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"71","x":"496","y":"-26"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":"request","name":"dataric","page":"1","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"71","x":"409","y":"-34"},{"calculate":" ","dataobj":"SQLKersonbo","field":"CODFISC","h":"20","init":" ","init_par":" ","name":"scodfisc","page":"1","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"-4","y":"663"},{"calculate":" ","dataobj":"SQLKersonbo","field":"COGNOME","h":"20","init":" ","init_par":" ","name":"scognome","page":"1","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"158","y":"667"},{"calculate":" ","dataobj":"SQLKersonbo","field":"NOME","h":"20","init":" ","init_par":" ","name":"snome","page":"1","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"320","y":"665"},{"calculate":" ","dataobj":"SQLKersonbo","field":"SESSO","h":"20","init":" ","init_par":" ","name":"ssesso","page":"1","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"486","y":"663"},{"calculate":" ","dataobj":"SQLKersonbo","field":"CONNES","h":"20","init":" ","init_par":" ","name":"selezione","page":"1","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"648","y":"663"}]%>
<%/*Description: */%>
<%/*ParamsRequest:cognome,nome,nascomun,sesso,tipodoc,numdocum,codfisc,nasstato,nquery,datanas,dataril,dataric*/%>
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
window.pg_wu_kersonbo_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof BtnUscita_Click !='undefined')this.BtnUscita_Click=BtnUscita_Click;
if(typeof BtnCopia_Click !='undefined')this.BtnCopia_Click=BtnCopia_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
ZtVWeb.CalcCtrl(CharToDate(this.datanas.Value()),this.nasdata);
ZtVWeb.CalcCtrl(CharToDate(this.datanas.Value()),this.rildata);
}
this.SQLKersonbo.addRowConsumer(this.grdOperazioni);
this.SQLKersonbo.addDataConsumer(this.connesdoc,<%=JSPLib.ToJSValue("CONNES",true)%>);
this.SQLKersonbo.addDataConsumer(this.scodfisc,<%=JSPLib.ToJSValue("CODFISC",true)%>);
this.SQLKersonbo.addDataConsumer(this.scognome,<%=JSPLib.ToJSValue("COGNOME",true)%>);
this.SQLKersonbo.addDataConsumer(this.snome,<%=JSPLib.ToJSValue("NOME",true)%>);
this.SQLKersonbo.addDataConsumer(this.ssesso,<%=JSPLib.ToJSValue("SESSO",true)%>);
this.SQLKersonbo.addDataConsumer(this.selezione,<%=JSPLib.ToJSValue("CONNES",true)%>);
function this_Loaded(){
  this.selezione.Value("");
  this.nasdata.Value(CharToDate(this.datanas.Value()));
  this.rildata.Value(CharToDate(this.dataril.Value()));  
  this.cogns.Value(Strtran(this.cognome.Value(),' ',''))
  this.nomns.Value(Strtran(this.nome.Value(),' ',''))  
  this.SQLKersonbo.Query()
  
}
function BtnUscita_Click(){
  if (confirm("Confermi l'uscita?")) {
    window.close()
  }    
}
function BtnCopia_Click(){
  if(confirm('Confermi la copia dei dati del record selezionato?')){   
    window.parent.opener.Set_TRXCODFIS(this.scodfisc.Value());
    window.parent.opener.Set_TRXCOGNOM(this.scognome.Value());
    window.parent.opener.Set_TRXNOME(this.snome.Value());    
    window.parent.opener.Set_TRXSESSO(iif(this.ssesso.Value()=='1','M','F'));
    window.parent.opener.Set_FLGDATIOLD('S');
//    window.close()
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
.pg_wu_kersonbo_container {
}
.pg_wu_kersonbo_portlet{
  position:relative;
  width:100%;
  min-width:1024px;
  height:650px;
  background-color:#FFFFFF;
}
.pg_wu_kersonbo_portlet[Data-page="1"]{
  height:650px;
  width:100%;
}
.pg_wu_kersonbo_portlet > .grdOperazioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:479px;
}
.pg_wu_kersonbo_portlet > .lblTitolo_ctrl {
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
.pg_wu_kersonbo_portlet > .lblTitolo_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblTitolo_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:10pt;
  font-weight:bold;
  color:#EFF702;
  text-align:center;
  background-color:#030BFF;
}
.pg_wu_kersonbo_portlet > .BtnUscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:64px;
  right:3px;
  width:40px;
  height:30px;
}
.pg_wu_kersonbo_portlet > .BtnUscita_ctrl {
}
.pg_wu_kersonbo_portlet > .BtnUscita_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_wu_kersonbo_portlet > .BtnCopia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:64px;
  right:51px;
  width:40px;
  height:30px;
}
.pg_wu_kersonbo_portlet > .BtnCopia_ctrl {
}
.pg_wu_kersonbo_portlet > .BtnCopia_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_wu_kersonbo_portlet > .cognome_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:22px;
  left:64px;
  width:195px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .cognome_ctrl {
}
.pg_wu_kersonbo_portlet > .cognome_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .nome_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:22px;
  left:314px;
  width:187px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .nome_ctrl {
}
.pg_wu_kersonbo_portlet > .nome_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .nascomun_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:603px;
  width:262px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .nascomun_ctrl {
}
.pg_wu_kersonbo_portlet > .nascomun_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .sesso_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:22px;
  left:558px;
  width:21px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .sesso_ctrl {
}
.pg_wu_kersonbo_portlet > .sesso_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .tipodoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:74px;
  left:65px;
  width:68px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .tipodoc_ctrl {
}
.pg_wu_kersonbo_portlet > .tipodoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .numdocum_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:74px;
  left:235px;
  width:225px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .numdocum_ctrl {
}
.pg_wu_kersonbo_portlet > .numdocum_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .codfisc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:22px;
  left:683px;
  width:135px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .codfisc_ctrl {
}
.pg_wu_kersonbo_portlet > .codfisc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .nasdata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:64px;
  width:73px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .nasdata_ctrl {
}
.pg_wu_kersonbo_portlet > .nasdata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .nasstato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:235px;
  width:262px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .nasstato_ctrl {
}
.pg_wu_kersonbo_portlet > .nasstato_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .nquery_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wu_kersonbo_portlet > .nquery_ctrl {
  display:none;
}
.pg_wu_kersonbo_portlet > .nquery_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .rildata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:75px;
  left:604px;
  width:73px;
  height:20px;
}
.pg_wu_kersonbo_portlet > .rildata_ctrl {
}
.pg_wu_kersonbo_portlet > .rildata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .datanas_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wu_kersonbo_portlet > .datanas_ctrl {
  display:none;
}
.pg_wu_kersonbo_portlet > .datanas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_wu_kersonbo_portlet > .lblCognome_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:6px;
  width:56px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblCognome_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblCognome_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblNome_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:267px;
  width:45px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNome_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNome_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblSesso_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:513px;
  width:43px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblSesso_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblSesso_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lbldatNas_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:6px;
  width:56px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lbldatNas_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lbldatNas_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblTipDoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:77px;
  left:6px;
  width:56px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblTipDoc_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblTipDoc_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblCodFis_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:597px;
  width:84px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblCodFis_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblCodFis_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblNasStato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:145px;
  width:88px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNasStato_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNasStato_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblNasComun_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:504px;
  width:98px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNasComun_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNasComun_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblNumDoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:78px;
  left:145px;
  width:88px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNumDoc_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblNumDoc_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_kersonbo_portlet > .lblRilData_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:78px;
  left:465px;
  width:137px;
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblRilData_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_kersonbo_portlet > .lblRilData_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
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
 String def="[{\"h\":\"650\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"8\",\"y\":\"-32\"},{\"anchor\":\"top-left-right\",\"h\":\"479\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"102\"},{\"anchor\":\"top-left-right\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"981\",\"y\":\"64\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"933\",\"y\":\"64\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"195\",\"x\":\"64\",\"y\":\"22\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"187\",\"x\":\"314\",\"y\":\"22\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"603\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"21\",\"x\":\"558\",\"y\":\"22\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"68\",\"x\":\"65\",\"y\":\"74\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"225\",\"x\":\"235\",\"y\":\"74\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"135\",\"x\":\"683\",\"y\":\"22\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"73\",\"x\":\"64\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"235\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"68\",\"x\":\"933\",\"y\":\"-30\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"73\",\"x\":\"604\",\"y\":\"75\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"67\",\"x\":\"856\",\"y\":\"-30\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"56\",\"x\":\"6\",\"y\":\"26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"45\",\"x\":\"267\",\"y\":\"26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"43\",\"x\":\"513\",\"y\":\"26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"56\",\"x\":\"6\",\"y\":\"53\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"56\",\"x\":\"6\",\"y\":\"77\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"84\",\"x\":\"597\",\"y\":\"26\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"88\",\"x\":\"145\",\"y\":\"53\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"98\",\"x\":\"504\",\"y\":\"53\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"88\",\"x\":\"145\",\"y\":\"78\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"137\",\"x\":\"465\",\"y\":\"78\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"64\",\"x\":\"656\",\"y\":\"-31\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"65\",\"x\":\"579\",\"y\":\"-28\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"115\",\"y\":\"-40\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"160\",\"y\":\"-40\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"97\",\"x\":\"749\",\"y\":\"-25\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"71\",\"x\":\"496\",\"y\":\"-26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"71\",\"x\":\"409\",\"y\":\"-34\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"-4\",\"y\":\"663\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"158\",\"y\":\"667\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"320\",\"y\":\"665\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"486\",\"y\":\"663\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"648\",\"y\":\"663\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_wu_kersonbo","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_wu_kersonbo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_wu_kersonbo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_wu_kersonbo_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String lblTitolo= "VISUALIZZAZIONE SOGGETTI CORRELATI";
String cognome=JSPLib.translateXSS(sp.getParameter("cognome",""));
if(request.getAttribute("pg_wu_kersonbo_firstinclusion")==null){
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
String nquery=JSPLib.translateXSS(sp.getParameter("nquery",""));
java.sql.Date rildata= JSPLib.NullDate();
String datanas=JSPLib.translateXSS(sp.getParameter("datanas",""));
String lblCognome= "Cognome:";
String lblNome= "Nome:";
String lblSesso= "Sesso:";
String lbldatNas= "Nato il:";
String lblTipDoc= "Tipo Doc.:";
String lblCodFis= "Codice Fiscale:";
String lblNasStato= "Stato di Nascita:";
String lblNasComun= "Comune di Nascita:";
String lblNumDoc= "N. Documento:";
String lblRilData= "Data di rilascio documento:";
String cogns= "";
String nomns= "";
String connesdoc= "";
String dataril=JSPLib.translateXSS(sp.getParameter("dataril",""));
String dataric=JSPLib.translateXSS(sp.getParameter("dataric",""));
String scodfisc= "";
String scognome= "";
String snome= "";
String ssesso= "";
String selezione= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_wu_kersonbo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_wu_kersonbo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_wu_kersonbo','<%=idPortlet%>',false,' ');
</script><%}}%>
<div id='<%=idPortlet%>_grdOperazioni' formid='<%=idPortlet%>' ps-name='grdOperazioni'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_lblTitolo'  formid='<%=idPortlet%>' ps-name='lblTitolo'    class='label lblTitolo_ctrl'><div id='<%=idPortlet%>_lblTitolotbl' style='width:100%;'><%=JSPLib.ToHTML("VISUALIZZAZIONE SOGGETTI CORRELATI")%></div></span>
<div id='<%=idPortlet%>_BtnUscita'>
<img id='<%=idPortlet%>_BtnUscita_img' class='image BtnUscita_ctrl' src="../images/exit.gif" >
</div>
<div id='<%=idPortlet%>_BtnCopia'>
<img id='<%=idPortlet%>_BtnCopia_img' class='image BtnCopia_ctrl' src="../images/copia.gif" >
</div>
<span class='textbox-container'id='<%=idPortlet%>_cognome_wrp'><input id='<%=idPortlet%>_cognome' name='cognome' type='text' maxlength='26' class='textbox' formid='<%=idPortlet%>' ps-name='cognome' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nome_wrp'><input id='<%=idPortlet%>_nome' name='nome' type='text' maxlength='25' class='textbox' formid='<%=idPortlet%>' ps-name='nome' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nascomun_wrp'><input id='<%=idPortlet%>_nascomun' name='nascomun' type='text' maxlength='35' class='textbox' formid='<%=idPortlet%>' ps-name='nascomun' /></span>
<span class='textbox-container'id='<%=idPortlet%>_sesso_wrp'><input id='<%=idPortlet%>_sesso' name='sesso' type='text' maxlength='2' class='textbox' formid='<%=idPortlet%>' ps-name='sesso' /></span>
<span class='textbox-container'id='<%=idPortlet%>_tipodoc_wrp'><input id='<%=idPortlet%>_tipodoc' name='tipodoc' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='tipodoc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_numdocum_wrp'><input id='<%=idPortlet%>_numdocum' name='numdocum' type='text' maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='numdocum' /></span>
<span class='textbox-container'id='<%=idPortlet%>_codfisc_wrp'><input id='<%=idPortlet%>_codfisc' name='codfisc' type='text' maxlength='18' class='textbox' formid='<%=idPortlet%>' ps-name='codfisc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nasdata_wrp'><input id='<%=idPortlet%>_nasdata' name='nasdata' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nasdata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nasstato_wrp'><input id='<%=idPortlet%>_nasstato' name='nasstato' type='text' maxlength='35' class='textbox' formid='<%=idPortlet%>' ps-name='nasstato' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nquery_wrp'><input id='<%=idPortlet%>_nquery' name='nquery' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='nquery' /></span>
<span class='textbox-container'id='<%=idPortlet%>_rildata_wrp'><input id='<%=idPortlet%>_rildata' name='rildata' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='rildata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_datanas_wrp'><input id='<%=idPortlet%>_datanas' name='datanas' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='datanas' /></span>
<span id='<%=idPortlet%>_lblCognome'  formid='<%=idPortlet%>' ps-name='lblCognome'    class='label lblCognome_ctrl'><div id='<%=idPortlet%>_lblCognometbl' style='width:100%;'><%=JSPLib.ToHTML("Cognome:")%></div></span>
<span id='<%=idPortlet%>_lblNome'  formid='<%=idPortlet%>' ps-name='lblNome'    class='label lblNome_ctrl'><div id='<%=idPortlet%>_lblNometbl' style='width:100%;'><%=JSPLib.ToHTML("Nome:")%></div></span>
<span id='<%=idPortlet%>_lblSesso'  formid='<%=idPortlet%>' ps-name='lblSesso'    class='label lblSesso_ctrl'><div id='<%=idPortlet%>_lblSessotbl' style='width:100%;'><%=JSPLib.ToHTML("Sesso:")%></div></span>
<span id='<%=idPortlet%>_lbldatNas'  formid='<%=idPortlet%>' ps-name='lbldatNas'    class='label lbldatNas_ctrl'><div id='<%=idPortlet%>_lbldatNastbl' style='width:100%;'><%=JSPLib.ToHTML("Nato il:")%></div></span>
<span id='<%=idPortlet%>_lblTipDoc'  formid='<%=idPortlet%>' ps-name='lblTipDoc'    class='label lblTipDoc_ctrl'><div id='<%=idPortlet%>_lblTipDoctbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Doc.:")%></div></span>
<span id='<%=idPortlet%>_lblCodFis'  formid='<%=idPortlet%>' ps-name='lblCodFis'    class='label lblCodFis_ctrl'><div id='<%=idPortlet%>_lblCodFistbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Fiscale:")%></div></span>
<span id='<%=idPortlet%>_lblNasStato'  formid='<%=idPortlet%>' ps-name='lblNasStato'    class='label lblNasStato_ctrl'><div id='<%=idPortlet%>_lblNasStatotbl' style='width:100%;'><%=JSPLib.ToHTML("Stato di Nascita:")%></div></span>
<span id='<%=idPortlet%>_lblNasComun'  formid='<%=idPortlet%>' ps-name='lblNasComun'    class='label lblNasComun_ctrl'><div id='<%=idPortlet%>_lblNasComuntbl' style='width:100%;'><%=JSPLib.ToHTML("Comune di Nascita:")%></div></span>
<span id='<%=idPortlet%>_lblNumDoc'  formid='<%=idPortlet%>' ps-name='lblNumDoc'    class='label lblNumDoc_ctrl'><div id='<%=idPortlet%>_lblNumDoctbl' style='width:100%;'><%=JSPLib.ToHTML("N. Documento:")%></div></span>
<span id='<%=idPortlet%>_lblRilData'  formid='<%=idPortlet%>' ps-name='lblRilData'    class='label lblRilData_ctrl'><div id='<%=idPortlet%>_lblRilDatatbl' style='width:100%;'><%=JSPLib.ToHTML("Data di rilascio documento:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_wu_kersonbo');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_wu_kersonbo',["1024"],["650"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"650","title":" ","layer":"false","npage":"1"}]);
this.SQLKersonbo=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"rows:arfn_wutrxchk_cases","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_wutrxchk_cases",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLKersonbo","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLKersonbo","nrows":"10000","page":1,"parms":"pCognome=cogns,pNome=nomns,pSesso=sesso,pTipoDoc=tipodoc,pNumDoc=numdocum,pNasCom=nascomun,pNasSta=nasstato,pDatNas=datanas,pCodFis=codfisc,pDatRil=dataril,pQuery=nquery,pDatOpe=dataric","parms_source":" ","type":"SQLDataobj","w":0,"x":8,"y":-32});
this.grdOperazioni=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":" ","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdOperazioni","dataobj":"SQLKersonbo","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":479,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":" ","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"grdOperazioni","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"RecordSelezionato","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":true,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"true-by-example","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":102});
this.grdOperazioni.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:RTKersonbo","weight":"","title":"Codice Collegamento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CONNES","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nominativo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAGSOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Stato nascita","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NASSTATO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Comune Nascita","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NASCOMUN","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Nascita","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATANASC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Sesso","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SESSO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Documento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPODOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Numero Doc.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NUMDOCUM","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Rilascio Doc.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATARILASC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Fiscale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODFISC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:%FLGCFVALIDO%:Codice Fiscale Validato","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:%FLGCGFORMAT%:Codice Fiscale Formalmente Corretto","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:RTOperazbo","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fGIF\u002f111.gif:Premere per visualizzare le operazioni collegate","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.lblTitolo=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblTitolo","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitolo","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblTitolo,false,true)%>","type":"Label","w":1024,"x":0,"y":0,"zindex":"1"});
this.BtnUscita=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-right","boundedPosition":"","class_Css":"image BtnUscita_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_BtnUscita","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il bottone per chiudere la finestra",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnUscita","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":981,"y":64,"zindex":"1"});
this.BtnCopia=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-right","boundedPosition":"","class_Css":"image BtnCopia_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_BtnCopia","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il bottone per copiare i dati del record selezionato",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnCopia","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fcopia.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":933,"y":64,"zindex":"1"});
this.cognome=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_cognome","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"26","name":"cognome","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cognome,false,true)%>","w":195,"x":64,"y":22,"zerofilling":false,"zindex":"1","zoom":""});
this.nome=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_nome","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"25","name":"nome","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nome,false,true)%>","w":187,"x":314,"y":22,"zerofilling":false,"zindex":"1","zoom":""});
this.nascomun=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_nascomun","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"35","name":"nascomun","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nascomun,false,true)%>","w":262,"x":603,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.sesso=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_sesso","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"2","name":"sesso","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sesso,false,true)%>","w":21,"x":558,"y":22,"zerofilling":false,"zindex":"1","zoom":""});
this.tipodoc=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_tipodoc","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"tipodoc","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tipodoc,false,true)%>","w":68,"x":65,"y":74,"zerofilling":false,"zindex":"1","zoom":""});
this.numdocum=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_numdocum","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"30","name":"numdocum","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(numdocum,false,true)%>","w":225,"x":235,"y":74,"zerofilling":false,"zindex":"1","zoom":""});
this.codfisc=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_codfisc","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"18","name":"codfisc","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codfisc,false,true)%>","w":135,"x":683,"y":22,"zerofilling":false,"zindex":"1","zoom":""});
this.nasdata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"CharToDate(this.datanas.Value())","create_undercond":" ","ctrlid":"<%=idPortlet%>_nasdata","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nasdata","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=nasdata%>","w":73,"x":64,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.nasstato=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_nasstato","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"35","name":"nasstato","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nasstato,false,true)%>","w":262,"x":235,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.nquery=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_nquery","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"nquery","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nquery,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.rildata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"CharToDate(this.datanas.Value())","create_undercond":" ","ctrlid":"<%=idPortlet%>_rildata","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"rildata","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=rildata%>","w":73,"x":604,"y":75,"zerofilling":false,"zindex":"1","zoom":""});
this.datanas=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_datanas","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"datanas","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(datanas,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.lblCognome=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblCognome","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCognome","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblCognome,false,true)%>","type":"Label","w":56,"x":6,"y":26,"zindex":"1"});
this.lblNome=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblNome","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNome","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblNome,false,true)%>","type":"Label","w":45,"x":267,"y":26,"zindex":"1"});
this.lblSesso=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblSesso","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSesso","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblSesso,false,true)%>","type":"Label","w":43,"x":513,"y":26,"zindex":"1"});
this.lbldatNas=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lbldatNas","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbldatNas","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lbldatNas,false,true)%>","type":"Label","w":56,"x":6,"y":53,"zindex":"1"});
this.lblTipDoc=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblTipDoc","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipDoc","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblTipDoc,false,true)%>","type":"Label","w":56,"x":6,"y":77,"zindex":"1"});
this.lblCodFis=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblCodFis","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCodFis","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblCodFis,false,true)%>","type":"Label","w":84,"x":597,"y":26,"zindex":"1"});
this.lblNasStato=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblNasStato","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNasStato","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblNasStato,false,true)%>","type":"Label","w":88,"x":145,"y":53,"zindex":"1"});
this.lblNasComun=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblNasComun","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNasComun","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblNasComun,false,true)%>","type":"Label","w":98,"x":504,"y":53,"zindex":"1"});
this.lblNumDoc=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblNumDoc","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNumDoc","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblNumDoc,false,true)%>","type":"Label","w":88,"x":145,"y":78,"zindex":"1"});
this.lblRilData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblRilData","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblRilData","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblRilData,false,true)%>","type":"Label","w":137,"x":465,"y":78,"zindex":"1"});
this.cogns=new ZtVWeb._VC(this,'cogns',null,'character','<%=JSPLib.ToJSValue(cogns,false,true)%>',false,false);
this.nomns=new ZtVWeb._VC(this,'nomns',null,'character','<%=JSPLib.ToJSValue(nomns,false,true)%>',false,false);
this.RTKersonbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTKersonbo","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTKersonbo","offline":false,"page":1,"parms":"CONNES=connesdoc","popup":"true","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"armt_kersonbo","target":" ","type":"SPLinker","w":30,"x":115,"y":-40});
this.RTKersonbo.m_cID='<%=JSPLib.cmdHash("entity,armt_kersonbo",request.getSession())%>';
this.RTOperazbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTOperazbo","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTOperazbo","offline":false,"page":1,"parms":"w_connesdoc=connesdoc","popup":"true","popup_height":"440","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"1050","progressbar":false,"refresh":" ","servlet":"..\u002fjsp\u002fpg_kersonbo_operazioni_portlet.jsp","target":" ","type":"SPLinker","w":30,"x":160,"y":-40});
this.RTOperazbo.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_kersonbo_operazioni_portlet.jsp",request.getSession())%>';
this.connesdoc=new ZtVWeb._VC(this,'connesdoc',null,'character','<%=JSPLib.ToJSValue(connesdoc,false,true)%>',false,false);
this.dataril=new ZtVWeb._VC(this,'dataril',null,'character','<%=JSPLib.ToJSValue(dataril,false,true)%>',false,false);
this.dataric=new ZtVWeb._VC(this,'dataric',null,'character','<%=JSPLib.ToJSValue(dataric,false,true)%>',false,false);
this.scodfisc=new ZtVWeb._VC(this,'scodfisc',null,'character','<%=JSPLib.ToJSValue(scodfisc,false,true)%>',false,false);
this.scognome=new ZtVWeb._VC(this,'scognome',null,'character','<%=JSPLib.ToJSValue(scognome,false,true)%>',false,false);
this.snome=new ZtVWeb._VC(this,'snome',null,'character','<%=JSPLib.ToJSValue(snome,false,true)%>',false,false);
this.ssesso=new ZtVWeb._VC(this,'ssesso',null,'character','<%=JSPLib.ToJSValue(ssesso,false,true)%>',false,false);
this.selezione=new ZtVWeb._VC(this,'selezione',null,'character','<%=JSPLib.ToJSValue(selezione,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_wu_kersonbo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_wu_kersonbo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_wu_kersonbo_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_wu_kersonbo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_wu_kersonbo');
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
sp.endPage("pg_wu_kersonbo");
}%>
<%! public String getJSPUID() { return "3413232030"; } %>