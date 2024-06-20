<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Nuovo_Click(){\n  this.NuovaOpex.Link()\n}\n\nfunction DeleteOpex(_annorif) {\n  _aggiorna=0\n  if (this.inviato.Value()==0 && Empty(this.dataannu.Value())) {\n    if (confirm(\"Confermi la cancellazione dell'operazione extraconto ?\")) {\n      _aggiorna=1\n      this.tipodel.Value(1)  \n    }  \n  }\n  if (this.inviato.Value()==1 && this.annulla.Value()==0 && Empty(this.dataannu.Value())) {\n    if (confirm(\"Vuoi l'annullamento della comunicazione ?\")) {\n      _aggiorna=1\n      this.tipodel.Value(2)        \n    }     \n  }\n  if (this.inviato.Value()==1 && this.annulla.Value()==0 && !Empty(this.dataannu.Value())) {\n    if (confirm(\"Vuoi il ripristino della comunicazione ?\")) {\n      _aggiorna=1        \n      this.tipodel.Value(3)      \n    }  \n  }        \n  if (this.inviato.Value()==1 && this.annulla.Value()==1) {\n    alert(\"Impossibile ripristinare l'operazione. Annullamento già inviato.\")\n  }  \n  if (_aggiorna==1) {\n    this.anno.Value(_annorif);\n    this.DelOpex.Link()     \n    this.Aggiorna();\n  }   \n}  \n\nfunction Aggiorna() {\n  this.Query1.Query();\n  this.Grid0.Refresh()  \n}  \n\nfunction EdtOpex(_annorif) {\n  if (confirm(\"Confermi la modifica dell'operazione extraconto ?\")) {\n    this.anno.Set(_annorif);\n    this.EditOpex.Link()\n  }            \n} \n\nfunction Grid0_AfterRowChange(currRecIdx,prevRecIdx){\n  this.cmbValute.Value(this.valuta.Value())\n}\n\nfunction Grid0_AfterRowChange_Click(currRecIdx,prevRecIdx){\n this.cmbValute.Value(this.valuta.Value())\n}\n\nfunction this_Loaded(){\n this.cmbValute.Value(this.valuta.Value())\n\u003c%if(sp.isInGroup(9)){%\u003e \n  this.Nuovo.Hide()\n\u003c%}%\u003e \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"false","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","htmlcode":"{{ Grid0 }}\n{{ Query1 }}\n{{ w_CONNES }}\n{{ label2 }}\n{{ Nuovo }}\n{{ NuovaOpex }}\n{{ DelOpex }}\n{{ EditOpex }}\n{{ anno }}\n{{ nSaldo }}\n{{ label9 }}\n{{ label9_Copy }}\n{{ label9_Copy_Copy }}\n{{ nQuantita }}\n{{ qValute }}\n{{ cmbValute }}\n{{ OpexSave }}\n{{ valuta }}\n{{ inviato }}\n{{ annulla }}\n{{ tipodel }}\n{{ dataannu }}\n{{ datainvio }}\n{{ label25 }}\n{{ label25_Copy }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"765","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"attribute","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_CONNES","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"92","wireframe_props":"name","x":"800","y":"24","zerofilling":"false","zindex":"1"},{"allowedqueries":"qbe_opextrbo","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"100","name":"Query1","offline":"false","page":"1","parms":"w_CONNES=w_CONNES","parms_source":"","query":"qbe_opextrbo","query_async":"true","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"92","x":"800","y":"52"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"300","name":"qValute","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tbvalute","query_async":"true","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"92","x":"800","y":"82"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"10\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:EdtOpex('%ANNO%')\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fedit.gif:Modifica la riga corrente\",\"fg_color\":\"\",\"width\":\"10\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"10\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:DeleteOpex('%ANNO%')\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fgrid_delete.gif:Cancella la riga corrente\",\"fg_color\":\"\",\"width\":\"10\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"30\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Anno\",\"type\":\"C\",\"align\":\"left\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"ANNO\",\"fg_color\":\"\",\"width\":\"30\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"60\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"60\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"70\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Delega\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COINT\",\"fg_color\":\"\",\"width\":\"70\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Note\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NOTE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Saldo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SALDO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Q.tà\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"QUANTITA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Valuta\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"VALUTA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Inviato\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"INVIATO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Invio\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAINVIO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Annullata\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"ANNULLA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Annullo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAANNU\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Saldo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"INVSALDO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Saldo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DTSALDO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAPPORTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":",,C,D,C,C,N,N,C,N,D,N,D,N,D,C","filters":"false","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"80","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"6","scroll_bars":"false","sequence":"4","server_side":"false","show_btn_delete":"true","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"765","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"20","zindex":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"#829BC6","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OPERAZIONI EXTRACONTO","w":"765","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"18","help_tips":"Inserisce le nuove informazioni","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Nuovo","page":"1","path_type":"","sequence":"8","server_side":"","spuid":"","src":"..\u002fimages\u002fminiadd.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"2","y":"0","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"editload","name":"NuovaOpex","offline":"false","page":"1","parms":"COLLEG=w_CONNES","popup":"true","popup_height":"145","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"755","progressbar":"","refresh":"","sequence":"9","servlet":"armt_ae_opextrbo","target":"","type":"SPLinker","w":"92","x":"800","y":"234"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"delete","name":"DelOpex","offline":"false","page":"1","parms":"COLLEG=w_CONNES,ANNO=anno","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"armt_ae_opextrbo","target":"","type":"SPLinker","w":"92","x":"800","y":"213"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"edit","name":"EditOpex","offline":"false","page":"1","parms":"COLLEG=w_CONNES,ANNO=anno","popup":"true","popup_height":"145","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"755","progressbar":"","refresh":"","sequence":"11","servlet":"armt_ae_opextrbo","target":"","type":"SPLinker","w":"92","x":"800","y":"192"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"anno","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"92","x":"800","y":"150"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"SALDO","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"12","name":"nSaldo","page":"1","password":"","picture":"999,999,999","placeholder":"","readonly":"true","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"90","wireframe_props":"name","x":"49","y":"245","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label9","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Saldo:","w":"40","wireframe_props":"align,value,n_col","x":"5","y":"245","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label9_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Quantità:","w":"55","wireframe_props":"align,value,n_col","x":"149","y":"245","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label9_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Valuta:","w":"55","wireframe_props":"align,value,n_col","x":"267","y":"245","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"QUANTITA","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"nQuantita","page":"1","password":"","picture":"999,999","placeholder":"","readonly":"true","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"45","wireframe_props":"name","x":"207","y":"245","zerofilling":"false","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"qValute","dataobj_value":"","disabled":"true","edit_undercond":"","empty_value":"true","field":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"cmbValute","page":"1","picture":"","sequence":"19","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":"true","w":"433","wireframe_props":"name,textlist","x":"325","y":"245","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"OpexSave","objsValues":"this.Aggiorna()","page":"1","parmsNames":"","sequence":"20","type":"EventReceiver","w":"92","x":"800","y":"111"},{"calculate":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"VALUTA","h":"20","init":"","init_par":"","name":"valuta","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"30","y":"333"},{"calculate":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"INVIATO","h":"20","init":"","init_par":"","name":"inviato","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"195","y":"334"},{"calculate":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"ANNULLA","h":"20","init":"","init_par":"","name":"annulla","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"356","y":"335"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"tipodel","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"520","y":"335"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DATAANNU","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"dataannu","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"85","wireframe_props":"name","x":"673","y":"276","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DATAINVIO","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"datainvio","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"26","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"85","wireframe_props":"name","x":"207","y":"276","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label25","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Annullamento:","w":"103","wireframe_props":"align,value,n_col","x":"566","y":"276","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label25_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"28","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Invio:","w":"103","wireframe_props":"align,value,n_col","x":"100","y":"276","zindex":"1"}]%>
<%/*Description:*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_opextrbo_container {
}
.pg_opextrbo_title_container {
  margin: auto;
}
.pg_opextrbo_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:765px;
  height:300px;
}
.pg_opextrbo_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.pg_opextrbo_portlet > .w_CONNES_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:765px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_opextrbo_portlet > .w_CONNES_ctrl {
  display:none;
}
.pg_opextrbo_portlet > .w_CONNES_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:80px;
}
.pg_opextrbo_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
}
.pg_opextrbo_portlet > .Nuovo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:2px;
  left:0.26143792%;
  right:745px;
  right:97.38562%;
  width:auto;
  height:18px;
}
.pg_opextrbo_portlet > .Nuovo_ctrl {
}
.pg_opextrbo_portlet > .Nuovo_ctrl > img{
  width:100%;
  vertical-align:top;
  height:18px;
}
.pg_opextrbo_portlet > .nSaldo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:245px;
  left:49px;
  left:6.4052286%;
  right:626px;
  right:81.83006%;
  width:auto;
  height:20px;
}
.pg_opextrbo_portlet > .nSaldo_ctrl {
}
.pg_opextrbo_portlet > .nSaldo_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_portlet > .label9_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:245px;
  left:5px;
  left:0.6535948%;
  right:720px;
  right:94.117645%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label9_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label9_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_portlet > .label9_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:245px;
  left:149px;
  left:19.477123%;
  right:561px;
  right:73.333336%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label9_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label9_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_portlet > .label9_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:245px;
  left:267px;
  left:34.901962%;
  right:443px;
  right:57.908497%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label9_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label9_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_portlet > .nQuantita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:245px;
  left:207px;
  left:27.058823%;
  right:513px;
  right:67.05882%;
  width:auto;
  height:20px;
}
.pg_opextrbo_portlet > .nQuantita_ctrl {
}
.pg_opextrbo_portlet > .nQuantita_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_portlet > .cmbValute_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:245px;
  left:325px;
  left:42.48366%;
  right:7px;
  right:0.9150327%;
  width:auto;
  height:20px;
}
.pg_opextrbo_portlet > .dataannu_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:276px;
  left:673px;
  left:87.973854%;
  right:7px;
  right:0.9150327%;
  width:auto;
  height:20px;
}
.pg_opextrbo_portlet > .dataannu_ctrl {
}
.pg_opextrbo_portlet > .dataannu_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_portlet > .datainvio_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:276px;
  left:207px;
  left:27.058823%;
  right:473px;
  right:61.830067%;
  width:auto;
  height:20px;
}
.pg_opextrbo_portlet > .datainvio_ctrl {
}
.pg_opextrbo_portlet > .datainvio_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_portlet > .label25_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:276px;
  left:566px;
  left:73.98693%;
  right:96px;
  right:12.54902%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label25_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label25_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_portlet > .label25_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:276px;
  left:100px;
  left:13.071896%;
  right:562px;
  right:73.46405%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label25_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_portlet > .label25_Copy_ctrl {
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"765\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_CONNES\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"92\",\"x\":\"800\",\"y\":\"24\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"Query1\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"92\",\"x\":\"800\",\"y\":\"52\"},{\"h\":\"20\",\"name\":\"qValute\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"92\",\"x\":\"800\",\"y\":\"82\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"\"},{\"title\":\"Anno\"},{\"title\":\"Data\"},{\"title\":\"Delega\"},{\"title\":\"Note\"},{\"title\":\"Saldo\"},{\"title\":\"Q.tà\"},{\"title\":\"Valuta\"},{\"title\":\"Inviato\"},{\"title\":\"Data Invio\"},{\"title\":\"Annullata\"},{\"title\":\"Data Annullo\"},{\"title\":\"Saldo\"},{\"title\":\"Data Saldo\"},{\"title\":\"Rapporto\"}],\"h\":\"80\",\"layout_steps_values\":{},\"name\":\"Grid0\",\"page\":\"1\",\"rows\":\"6\",\"type\":\"Grid\",\"w\":\"765\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OPERAZIONI EXTRACONTO\",\"w\":\"765\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"Nuovo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"2\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"NuovaOpex\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"92\",\"x\":\"800\",\"y\":\"234\"},{\"h\":\"20\",\"name\":\"DelOpex\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"92\",\"x\":\"800\",\"y\":\"213\"},{\"h\":\"20\",\"name\":\"EditOpex\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"92\",\"x\":\"800\",\"y\":\"192\"},{\"h\":\"20\",\"name\":\"anno\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"92\",\"x\":\"800\",\"y\":\"150\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nSaldo\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"49\",\"y\":\"245\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label9\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Saldo:\",\"w\":\"40\",\"x\":\"5\",\"y\":\"245\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label9_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Quantità:\",\"w\":\"55\",\"x\":\"149\",\"y\":\"245\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label9_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Valuta:\",\"w\":\"55\",\"x\":\"267\",\"y\":\"245\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nQuantita\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"45\",\"x\":\"207\",\"y\":\"245\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbValute\",\"page\":\"1\",\"textlist\":\"DESCRI\",\"type\":\"Combobox\",\"w\":\"433\",\"x\":\"325\",\"y\":\"245\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"OpexSave\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"92\",\"x\":\"800\",\"y\":\"111\"},{\"h\":\"20\",\"name\":\"valuta\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"30\",\"y\":\"333\"},{\"h\":\"20\",\"name\":\"inviato\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"195\",\"y\":\"334\"},{\"h\":\"20\",\"name\":\"annulla\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"356\",\"y\":\"335\"},{\"h\":\"20\",\"name\":\"tipodel\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"520\",\"y\":\"335\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dataannu\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"673\",\"y\":\"276\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"datainvio\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"207\",\"y\":\"276\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label25\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Annullamento:\",\"w\":\"103\",\"x\":\"566\",\"y\":\"276\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label25_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Invio:\",\"w\":\"103\",\"x\":\"100\",\"y\":\"276\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_opextrbo","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_opextrbo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_opextrbo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String w_CONNES=JSPLib.translateXSS(Library.getAttribute(request,"w_CONNES",""));
if(request.getAttribute("pg_opextrbo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_opextrbo_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label2= "OPERAZIONI EXTRACONTO";
String anno= "";
double nSaldo= 0;
String label9= "Saldo:";
String label9_Copy= "Quantità:";
String label9_Copy_Copy= "Valuta:";
double nQuantita= 0;
String cmbValute= "";
String valuta= "";
String inviato= "";
String annulla= "";
String tipodel= "";
java.sql.Date dataannu= JSPLib.NullDate();
java.sql.Date datainvio= JSPLib.NullDate();
String label25= "Data Annullamento:";
String label25_Copy= "Data Invio:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_opextrbo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_opextrbo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_opextrbo','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_w_CONNES_wrp'><input id='<%=idPortlet%>_w_CONNES' name='w_CONNES' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_CONNES' /></span>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("OPERAZIONI EXTRACONTO")%></div></span>
<div id='<%=idPortlet%>_Nuovo'>
<img id='<%=idPortlet%>_Nuovo_img' class='image Nuovo_ctrl' src="../images/miniadd.gif" >
</div>
<span class='textbox-container'id='<%=idPortlet%>_nSaldo_wrp'><input id='<%=idPortlet%>_nSaldo' name='nSaldo' type='text' disabled maxlength='12' class='textbox' formid='<%=idPortlet%>' ps-name='nSaldo' data-sp-item-say-pict='999,999,999' data-sp-item-get-pict='999,999,999' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_label9'  formid='<%=idPortlet%>' ps-name='label9'    class='label label9_ctrl'><div id='<%=idPortlet%>_label9tbl' style='width:100%;'><%=JSPLib.ToHTML("Saldo:")%></div></span>
<span id='<%=idPortlet%>_label9_Copy'  formid='<%=idPortlet%>' ps-name='label9_Copy'    class='label label9_Copy_ctrl'><div id='<%=idPortlet%>_label9_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Quantità:")%></div></span>
<span id='<%=idPortlet%>_label9_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label9_Copy_Copy'    class='label label9_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label9_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Valuta:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nQuantita_wrp'><input id='<%=idPortlet%>_nQuantita' name='nQuantita' type='text' disabled maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='nQuantita' data-sp-item-say-pict='999,999' data-sp-item-get-pict='999,999' inputmode='numeric' /></span>
<select id='<%=idPortlet%>_cmbValute' name='cmbValute' disabled class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span class='textbox-container'id='<%=idPortlet%>_dataannu_wrp'><input id='<%=idPortlet%>_dataannu' name='dataannu' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='dataannu' /></span>
<span class='textbox-container'id='<%=idPortlet%>_datainvio_wrp'><input id='<%=idPortlet%>_datainvio' name='datainvio' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='datainvio' /></span>
<span id='<%=idPortlet%>_label25'  formid='<%=idPortlet%>' ps-name='label25'    class='label label25_ctrl'><div id='<%=idPortlet%>_label25tbl' style='width:100%;'><%=JSPLib.ToHTML("Data Annullamento:")%></div></span>
<span id='<%=idPortlet%>_label25_Copy'  formid='<%=idPortlet%>' ps-name='label25_Copy'    class='label label25_Copy_ctrl'><div id='<%=idPortlet%>_label25_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Data Invio:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_opextrbo');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_opextrbo',["765"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"765","h":"300","title":"","layer":"false","npage":"1"}]);
this.w_CONNES=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_CONNES","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"attribute","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_CONNES","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_CONNES,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_opextrbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_opextrbo","cmdHash":"<%=JSPLib.cmdHash("qbe_opextrbo",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"100","page":1,"parms":"w_CONNES=w_CONNES","parms_source":"","type":"SQLDataobj","w":92,"x":800,"y":52});
this.qValute=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_tbvalute","cmdHash":"<%=JSPLib.cmdHash("qbe_tbvalute",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_qValute","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"qValute","nrows":"300","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":92,"x":800,"y":82});
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":80,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"true","show_btn_update":"true","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":765,"x":0,"y":20,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":6,"colProperties":[{"disable_fields_conditions":"","maxwidth":"10","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:EdtOpex('%ANNO%')","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fedit.gif:Modifica la riga corrente","fg_color":"","width":"10","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"10","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:DeleteOpex('%ANNO%')","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fgrid_delete.gif:Cancella la riga corrente","fg_color":"","width":"10","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"30","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Anno","type":"C","align":"left","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"ANNO","fg_color":"","width":"30","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"60","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"60","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"70","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Delega","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COINT","fg_color":"","width":"70","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Note","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NOTE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Saldo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SALDO","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Q.tà","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"QUANTITA","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Valuta","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"VALUTA","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Inviato","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"INVIATO","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Invio","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAINVIO","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Annullata","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"ANNULLA","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Annullo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAANNU","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Saldo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"INVSALDO","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Saldo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DTSALDO","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAPPORTO","fg_color":"","width":"","RowSpan":0,"extensible":true}]});
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":765,"x":0,"y":0,"zindex":"1"});
this.Nuovo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image Nuovo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Nuovo","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":18,"help_tips":"<%=JSPLib.ToJSValue("Inserisce le nuove informazioni",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Nuovo","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fminiadd.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":18,"x":2,"y":0,"zindex":"1"});
this.NuovaOpex=new ZtVWeb.SPLinkerCtrl(this,{"action":"editload","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_NuovaOpex","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"NuovaOpex","offline":false,"page":1,"parms":"COLLEG=w_CONNES","popup":"true","popup_height":"145","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"755","progressbar":false,"refresh":"","servlet":"armt_ae_opextrbo","target":"","type":"SPLinker","w":92,"x":800,"y":234});
this.NuovaOpex.m_cID='<%=JSPLib.cmdHash("entity,armt_ae_opextrbo",request.getSession())%>';
this.DelOpex=new ZtVWeb.SPLinkerCtrl(this,{"action":"delete","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DelOpex","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DelOpex","offline":false,"page":1,"parms":"COLLEG=w_CONNES,ANNO=anno","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_ae_opextrbo","target":"","type":"SPLinker","w":92,"x":800,"y":213});
this.DelOpex.m_cID='<%=JSPLib.cmdHash("entity,armt_ae_opextrbo",request.getSession())%>';
this.EditOpex=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_EditOpex","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"EditOpex","offline":false,"page":1,"parms":"COLLEG=w_CONNES,ANNO=anno","popup":"true","popup_height":"145","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"755","progressbar":false,"refresh":"","servlet":"armt_ae_opextrbo","target":"","type":"SPLinker","w":92,"x":800,"y":192});
this.EditOpex.m_cID='<%=JSPLib.cmdHash("entity,armt_ae_opextrbo",request.getSession())%>';
this.anno=new ZtVWeb._VC(this,'anno',null,'character','<%=JSPLib.ToJSValue(anno,false,true)%>',false,false);
this.nSaldo=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nSaldo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"SALDO","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"12","name":"nSaldo","page":1,"picker":"","picture":"999,999,999","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=nSaldo%>","w":90,"x":49,"y":245,"zerofilling":false,"zindex":"1","zoom":""});
this.label9=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label9","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label9","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label9,false,true)%>","type":"Label","w":40,"x":5,"y":245,"zindex":"1"});
this.label9_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label9_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label9_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label9_Copy,false,true)%>","type":"Label","w":55,"x":149,"y":245,"zindex":"1"});
this.label9_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label9_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label9_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label9_Copy_Copy,false,true)%>","type":"Label","w":55,"x":267,"y":245,"zindex":"1"});
this.nQuantita=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nQuantita","decrypt":false,"edit_undercond":"","encrypt":false,"field":"QUANTITA","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"nQuantita","page":1,"picker":"","picture":"999,999","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=nQuantita%>","w":45,"x":207,"y":245,"zerofilling":false,"zindex":"1","zoom":""});
this.cmbValute=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbValute","dataobj_value":"","decrypt":false,"disabled":true,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbValute%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"cmbValute","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":true,"w":433,"x":325,"y":245,"zindex":"1"});
this.OpexSave=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_OpexSave","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"OpexSave","objsValues":"this.Aggiorna()","page":1,"parmsNames":"","type":"EventReceiver","w":92,"x":800,"y":111});
this.valuta=new ZtVWeb._VC(this,'valuta',null,'character','<%=JSPLib.ToJSValue(valuta,false,true)%>',false,false);
this.inviato=new ZtVWeb._VC(this,'inviato',null,'character','<%=JSPLib.ToJSValue(inviato,false,true)%>',false,false);
this.annulla=new ZtVWeb._VC(this,'annulla',null,'character','<%=JSPLib.ToJSValue(annulla,false,true)%>',false,false);
this.tipodel=new ZtVWeb._VC(this,'tipodel',null,'character','<%=JSPLib.ToJSValue(tipodel,false,true)%>',false,false);
this.dataannu=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dataannu","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DATAANNU","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dataannu","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dataannu%>","w":85,"x":673,"y":276,"zerofilling":false,"zindex":"1","zoom":""});
this.datainvio=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_datainvio","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DATAINVIO","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"datainvio","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=datainvio%>","w":85,"x":207,"y":276,"zerofilling":false,"zindex":"1","zoom":""});
this.label25=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label25","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label25","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label25,false,true)%>","type":"Label","w":103,"x":566,"y":276,"zindex":"1"});
this.label25_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label25_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label25_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label25_Copy,false,true)%>","type":"Label","w":103,"x":100,"y":276,"zindex":"1"});
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
<%request.setAttribute("pg_opextrbo_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.pg_opextrbo_Static=function(){
if(typeof Nuovo_Click !='undefined')this.Nuovo_Click=Nuovo_Click;
if(typeof DeleteOpex !='undefined')this.DeleteOpex=DeleteOpex;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof EdtOpex !='undefined')this.EdtOpex=EdtOpex;
if(typeof Grid0_AfterRowChange !='undefined')this.Grid0_AfterRowChange=Grid0_AfterRowChange;
if(typeof Grid0_AfterRowChange_Click !='undefined')this.Grid0_AfterRowChange_Click=Grid0_AfterRowChange_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.nSaldo,<%=JSPLib.ToJSValue("SALDO",true)%>);
this.Query1.addDataConsumer(this.nQuantita,<%=JSPLib.ToJSValue("QUANTITA",true)%>);
this.qValute.addRowConsumer(this.cmbValute);
this.Query1.addDataConsumer(this.valuta,<%=JSPLib.ToJSValue("VALUTA",true)%>);
this.Query1.addDataConsumer(this.inviato,<%=JSPLib.ToJSValue("INVIATO",true)%>);
this.Query1.addDataConsumer(this.annulla,<%=JSPLib.ToJSValue("ANNULLA",true)%>);
this.Query1.addDataConsumer(this.dataannu,<%=JSPLib.ToJSValue("DATAANNU",true)%>);
this.Query1.addDataConsumer(this.datainvio,<%=JSPLib.ToJSValue("DATAINVIO",true)%>);
function Nuovo_Click(){
  this.NuovaOpex.Link()
}
function DeleteOpex(_annorif) {
  _aggiorna=0
  if (this.inviato.Value()==0 && Empty(this.dataannu.Value())) {
    if (confirm("Confermi la cancellazione dell'operazione extraconto ?")) {
      _aggiorna=1
      this.tipodel.Value(1)  
    }  
  }
  if (this.inviato.Value()==1 && this.annulla.Value()==0 && Empty(this.dataannu.Value())) {
    if (confirm("Vuoi l'annullamento della comunicazione ?")) {
      _aggiorna=1
      this.tipodel.Value(2)        
    }     
  }
  if (this.inviato.Value()==1 && this.annulla.Value()==0 && !Empty(this.dataannu.Value())) {
    if (confirm("Vuoi il ripristino della comunicazione ?")) {
      _aggiorna=1        
      this.tipodel.Value(3)      
    }  
  }        
  if (this.inviato.Value()==1 && this.annulla.Value()==1) {
    alert("Impossibile ripristinare l'operazione. Annullamento già inviato.")
  }  
  if (_aggiorna==1) {
    this.anno.Value(_annorif);
    this.DelOpex.Link()     
    this.Aggiorna();
  }   
}  
function Aggiorna() {
  this.Query1.Query();
  this.Grid0.Refresh()  
}  
function EdtOpex(_annorif) {
  if (confirm("Confermi la modifica dell'operazione extraconto ?")) {
    this.anno.Set(_annorif);
    this.EditOpex.Link()
  }            
} 
function Grid0_AfterRowChange(currRecIdx,prevRecIdx){
  this.cmbValute.Value(this.valuta.Value())
}
function Grid0_AfterRowChange_Click(currRecIdx,prevRecIdx){
 this.cmbValute.Value(this.valuta.Value())
}
function this_Loaded(){
 this.cmbValute.Value(this.valuta.Value())
<%if(sp.isInGroup(9)){%> 
  this.Nuovo.Hide()
<%}%> 
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.pg_opextrbo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_OpexSave=function(parmsObj){<%=idPortlet%>.OpexSave.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.qValute.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_opextrbo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_opextrbo');
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
sp.endPage("pg_opextrbo");
}%>
<%! public String getJSPUID() { return "1137495611"; } %>