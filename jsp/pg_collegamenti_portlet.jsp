<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.GridOpe.SetSPLinkerActions('-d-e-n');\nthis.GridTit.SetSPLinkerActions('-d-e-n');\nthis.GridFrz.SetSPLinkerActions('-d-e-n');\n\nfunction button12_Click(){\n  this.QueryOpe.Query();\n  this.QueryTit.Query();\n  this.QueryFrz.Query();  \n}\n\nfunction Conferma_Click(){\n  this.opeValues.Value(this.GridOpe.GetSelectedDataAsTrsString());\n  this.titValues.Value(this.GridTit.GetSelectedDataAsTrsString());\n  this.frzValues.Value(this.GridFrz.GetSelectedDataAsTrsString());  \n  if (confirm('Confermi il collegamento delle operazioni\u002ftitolarità ?')) {   \n    _esito=this.RTCollega.Link();\n    this.QueryOpe.Query();\n    this.QueryTit.Query();    \n    this.QueryFrz.Query();    \n  }  \n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#C0C0C0","css":" ","css_class":"undefined","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"700","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"false","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"742"},{"align":"left","anchor":" ","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"IDBASE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:operazbo_view\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data registrazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COLLEG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"QueryOpe","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,D,D,C","filters":"false","font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":"150","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":"#FFFFFF","link_underlined":"true","name":"GridOpe","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":"false","render_totals":" ","resizablecolumns":"false","row_color":"#CCCCCC","row_color_odd":"#999999","rows":"5","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":" ","w":"740","x":"0","y":"120"},{"align":"left","anchor":" ","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"IDBASE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:rapotit_view\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Registrazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAPPORTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COLLEG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"QueryTit","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,D,D,C,C","filters":"false","font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":"150","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":"#FFFFFF","link_underlined":"true","name":"GridTit","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"false","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":"false","render_totals":" ","resizablecolumns":"false","row_color":"#CCCCCC","row_color_odd":"#999999","rows":"5","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":"left","title_color":" ","type":"Grid","valign":" ","w":"740","x":"0","y":"318"},{"align":"left","anchor":" ","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"IDBASE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:fraziobo_view\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data registrazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COLLEG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"QueryFrz","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,D,D,C","filters":"false","font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":"150","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":"#FFFFFF","link_underlined":"true","name":"GridFrz","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":"false","render_totals":" ","resizablecolumns":"false","row_color":"#CCCCCC","row_color_odd":"#999999","rows":"5","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":" ","w":"740","x":"0","y":"515"},{"auto_exec":"true","count":"true","localDBName":" ","n_records":"100","name":"QueryOpe","offline":"false","page":"1","parms":"w_connes=w_CONNES,w_dadata=dadata,w_adata=a_data","parms_source":" ","query":"qbe_terz_oper","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","x":"0","y":"-40"},{"auto_exec":"true","count":"true","localDBName":" ","n_records":"100","name":"QueryTit","offline":"false","page":"1","parms":"w_connes=w_CONNES,w_dadata=dadata,w_adata=a_data","parms_source":" ","query":"qbe_terz_tit","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","x":"36","y":"-40"},{"auto_exec":"true","count":"true","localDBName":" ","n_records":"100","name":"QueryFrz","offline":"false","page":"1","parms":"w_connes=w_CONNES,w_dadata=dadata,w_adata=a_data","parms_source":" ","query":"qbe_terz_frz","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","x":"79","y":"-38"},{"anchor":" ","calculate":"w_CONNES","class_Css":" ","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"22","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"w_CONNES","page":"1","password":"false","picture":" ","readonly":"true","scroll":"false","sequence":"3","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"129","x":"67","y":"39","zerofilling":"false","zindex":"1"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#829BC6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"labelTit","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"TITOLARI EFFETTIVI (A.U.I.)","w":"740","x":"0","y":"298","zindex":"1"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#829BC6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"labelOpe","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"OPERAZIONI (A.U.I.)","w":"740","x":"0","y":"100","zindex":"1"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#829BC6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"labelFrz","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"FRAZIONATE (A.U.I.)","w":"740","x":"0","y":"495","zindex":"1"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","m_cAltInterface":" ","name":"operazbo_view","offline":"false","page":"1","parms":"IDBASE","popup":"true","popup_height":"600","popup_scroll":"false","popup_style":" ","popup_width":"800","refresh":"false","sequence":"7","servlet":"armt_operazioni","target":"_new","type":"SPLinker","w":"30","x":"360","y":"-42"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","m_cAltInterface":" ","name":"fraziobo_view","offline":"false","page":"1","parms":"IDBASE","popup":"true","popup_height":"600","popup_scroll":"false","popup_style":" ","popup_width":"800","refresh":"false","sequence":"7","servlet":"armt_ofrazionate","target":"_new","type":"SPLinker","w":"30","x":"404","y":"-41"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","m_cAltInterface":" ","name":"rapotit_view","offline":"false","page":"1","parms":"IDBASE","popup":"true","popup_height":"600","popup_scroll":"false","popup_style":" ","popup_width":"800","refresh":"false","sequence":"10","servlet":"armt_rapotit","target":"_new","type":"SPLinker","w":"30","x":"445","y":"-43"},{"anchor":" ","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","name":"button12","page":"1","sequence":"11","tabindex":" ","type":"Button","type_submit":"false","value":"Ricerca","w":"65","x":"310","y":"11"},{"anchor":" ","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":"not(Empty(codcol))","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","name":"Conferma","page":"1","sequence":"11","tabindex":" ","type":"Button","type_submit":"false","value":"Collega","w":"75","x":"648","y":"9"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"Label1","page":"1","picture":" ","sequence":"13","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Da Data:","w":"47","x":"18","y":"11","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"Label2","page":"1","picture":" ","sequence":"13","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"A Data:","w":"47","x":"173","y":"11","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"Label3","page":"1","picture":" ","sequence":"13","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Soggetto:","w":"47","x":"18","y":"42","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"Label3_Copy","page":"1","picture":" ","sequence":"13","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Tipo Oper:","w":"57","x":"8","y":"71","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"22","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"ragsoc","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"14","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"517","x":"201","y":"39","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":"Inserire il codice di collegamento delle operazioni selezionate","hide_undercond":" ","init":" ","init_par":" ","maxlength":"12","name":"codcol","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"15","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"106","x":"532","y":"10","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"a_data","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"15","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"83","x":"217","y":"10","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"dadata","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"15","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"83","x":"67","y":"10","zerofilling":"false","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label19","page":"1","picture":" ","sequence":"16","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Codice Collegamento:","w":"125","x":"418","y":"11","zindex":"1"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"opeValues","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"0","y":"674"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"titValues","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"138","y":"676"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"frzValues","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"278","y":"679"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"RTCollega","offline":"false","page":"1","parms":"tValues=titValues,oValues=opeValues,fValues=frzValues,pColleg=codcol,pTipo=tipope","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"17","servlet":"arrt_collegamenti_save","target":" ","type":"SPLinker","w":"30","x":"702","y":"-44"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":" ","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","hide_undercond":" ","init":" ","init_par":" ","name":"tipope","page":"1","picture":" ","sequence":"18","tabindex":" ","textlist":"Normale,Multipla","type":"Combobox","typevar":"character","valuelist":"'0','1'","visible":"true","w":"179","x":"67","y":"70"}]%>
<%/*Description: */%>
<%/*ParamsRequest:w_CONNES,ragsoc*/%>
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
window.pg_collegamenti_Static=function(){
if(typeof button12_Click !='undefined')this.button12_Click=button12_Click;
if(typeof Conferma_Click !='undefined')this.Conferma_Click=Conferma_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
ZtVWeb.CalcCtrl(this.w_CONNES.Value(),this.w_CONNES);
}
this.this_EditUnderCondition=function(){
ZtVWeb.EditCtrl(!(Empty(this.codcol.Value())),this.Conferma);
}
this.QueryOpe.addRowConsumer(this.GridOpe);
this.QueryTit.addRowConsumer(this.GridTit);
this.QueryFrz.addRowConsumer(this.GridFrz);
this.GridOpe.SetSPLinkerActions('-d-e-n');
this.GridTit.SetSPLinkerActions('-d-e-n');
this.GridFrz.SetSPLinkerActions('-d-e-n');
function button12_Click(){
  this.QueryOpe.Query();
  this.QueryTit.Query();
  this.QueryFrz.Query();  
}
function Conferma_Click(){
  this.opeValues.Value(this.GridOpe.GetSelectedDataAsTrsString());
  this.titValues.Value(this.GridTit.GetSelectedDataAsTrsString());
  this.frzValues.Value(this.GridFrz.GetSelectedDataAsTrsString());  
  if (confirm('Confermi il collegamento delle operazioni/titolarità ?')) {   
    _esito=this.RTCollega.Link();
    this.QueryOpe.Query();
    this.QueryTit.Query();    
    this.QueryFrz.Query();    
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
.pg_collegamenti_container {
}
.pg_collegamenti_portlet{
  position:relative;
  width:742px;
  min-width:742px;
  height:700px;
  background-color:#C0C0C0;
}
.pg_collegamenti_portlet[Data-page="1"]{
  height:700px;
  width:742px;
}
.pg_collegamenti_portlet > .GridOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:120px;
  left:0px;
  width:740px;
  height:auto;
  min-height:150px;
}
.pg_collegamenti_portlet > .GridTit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:318px;
  left:0px;
  width:740px;
  height:auto;
  min-height:150px;
}
.pg_collegamenti_portlet > .GridFrz_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:515px;
  left:0px;
  width:740px;
  height:auto;
  min-height:150px;
}
.pg_collegamenti_portlet > .w_CONNES_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:39px;
  left:67px;
  width:129px;
  height:22px;
}
.pg_collegamenti_portlet > .w_CONNES_ctrl {
}
.pg_collegamenti_portlet > .w_CONNES_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_collegamenti_portlet > .labelTit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:298px;
  left:0px;
  width:740px;
  height:auto;
  min-height:20px;
}
.pg_collegamenti_portlet > .labelTit_ctrl {
  height:auto;
  min-height:20px;
}
.pg_collegamenti_portlet > .labelTit_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
}
.pg_collegamenti_portlet > .labelOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:100px;
  left:0px;
  width:740px;
  height:auto;
  min-height:20px;
}
.pg_collegamenti_portlet > .labelOpe_ctrl {
  height:auto;
  min-height:20px;
}
.pg_collegamenti_portlet > .labelOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
}
.pg_collegamenti_portlet > .labelFrz_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:495px;
  left:0px;
  width:740px;
  height:auto;
  min-height:20px;
}
.pg_collegamenti_portlet > .labelFrz_ctrl {
  height:auto;
  min-height:20px;
}
.pg_collegamenti_portlet > .labelFrz_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
}
.pg_collegamenti_portlet > .button12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:310px;
  width:65px;
  height:20px;
}
.pg_collegamenti_portlet > .button12_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#000000;
  background-color:buttonface;
  border-width:1px;
  border-color:#000000;
}
.pg_collegamenti_portlet > .Conferma_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:648px;
  width:75px;
  height:20px;
}
.pg_collegamenti_portlet > .Conferma_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#FFFFFF;
  background-color:#10CE1D;
  border-width:1px;
  border-color:#000000;
}
.pg_collegamenti_portlet > .Label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:18px;
  width:47px;
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_collegamenti_portlet > .Label2_ctrl {
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
.pg_collegamenti_portlet > .Label2_ctrl {
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_collegamenti_portlet > .Label3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:18px;
  width:47px;
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label3_ctrl {
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label3_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_collegamenti_portlet > .Label3_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:71px;
  left:8px;
  width:57px;
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label3_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .Label3_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_collegamenti_portlet > .ragsoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:39px;
  left:201px;
  width:517px;
  height:22px;
}
.pg_collegamenti_portlet > .ragsoc_ctrl {
}
.pg_collegamenti_portlet > .ragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_collegamenti_portlet > .codcol_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:532px;
  width:106px;
  height:20px;
}
.pg_collegamenti_portlet > .codcol_ctrl {
}
.pg_collegamenti_portlet > .codcol_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_collegamenti_portlet > .a_data_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:217px;
  width:83px;
  height:20px;
}
.pg_collegamenti_portlet > .a_data_ctrl {
}
.pg_collegamenti_portlet > .a_data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_collegamenti_portlet > .dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:67px;
  width:83px;
  height:20px;
}
.pg_collegamenti_portlet > .dadata_ctrl {
}
.pg_collegamenti_portlet > .dadata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_collegamenti_portlet > .label19_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:418px;
  width:125px;
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .label19_ctrl {
  height:auto;
  min-height:19px;
}
.pg_collegamenti_portlet > .label19_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_collegamenti_portlet > .tipope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:67px;
  width:179px;
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
 String def="[{\"h\":\"700\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"742\"},{\"anchor\":\"\",\"h\":\"150\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"740\",\"x\":\"0\",\"y\":\"120\"},{\"anchor\":\"\",\"h\":\"150\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"740\",\"x\":\"0\",\"y\":\"318\"},{\"anchor\":\"\",\"h\":\"150\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"740\",\"x\":\"0\",\"y\":\"515\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"0\",\"y\":\"-40\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"36\",\"y\":\"-40\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"79\",\"y\":\"-38\"},{\"anchor\":\"\",\"h\":\"22\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"129\",\"x\":\"67\",\"y\":\"39\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"740\",\"x\":\"0\",\"y\":\"298\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"740\",\"x\":\"0\",\"y\":\"100\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"740\",\"x\":\"0\",\"y\":\"495\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"360\",\"y\":\"-42\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"404\",\"y\":\"-41\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"445\",\"y\":\"-43\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"65\",\"x\":\"310\",\"y\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"75\",\"x\":\"648\",\"y\":\"9\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"47\",\"x\":\"18\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"47\",\"x\":\"173\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"47\",\"x\":\"18\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"57\",\"x\":\"8\",\"y\":\"71\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"517\",\"x\":\"201\",\"y\":\"39\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"106\",\"x\":\"532\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"217\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"67\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"125\",\"x\":\"418\",\"y\":\"11\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"0\",\"y\":\"674\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"138\",\"y\":\"676\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"278\",\"y\":\"679\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"702\",\"y\":\"-44\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"179\",\"x\":\"67\",\"y\":\"70\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_collegamenti","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_collegamenti_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_collegamenti','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_collegamenti_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_CONNES=JSPLib.translateXSS(sp.getParameter("w_CONNES",""));
if(request.getAttribute("pg_collegamenti_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String labelTit= "TITOLARI EFFETTIVI (A.U.I.)";
String labelOpe= "OPERAZIONI (A.U.I.)";
String labelFrz= "FRAZIONATE (A.U.I.)";
String Label1= "Da Data:";
String Label2= "A Data:";
String Label3= "Soggetto:";
String Label3_Copy= "Tipo Oper:";
String ragsoc=JSPLib.translateXSS(sp.getParameter("ragsoc",""));
String codcol= "";
java.sql.Date a_data= JSPLib.NullDate();
java.sql.Date dadata= JSPLib.NullDate();
String label19= "Codice Collegamento:";
String opeValues= "";
String titValues= "";
String frzValues= "";
String tipope= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_collegamenti_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_collegamenti_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_collegamenti','<%=idPortlet%>',false,' ');
</script><%}}%>
<div id='<%=idPortlet%>_GridOpe' formid='<%=idPortlet%>' ps-name='GridOpe'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_GridTit' formid='<%=idPortlet%>' ps-name='GridTit'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_GridFrz' formid='<%=idPortlet%>' ps-name='GridFrz'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_w_CONNES_wrp'><input id='<%=idPortlet%>_w_CONNES' name='w_CONNES' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='w_CONNES' /></span>
<span id='<%=idPortlet%>_labelTit'  formid='<%=idPortlet%>' ps-name='labelTit'    class='label labelTit_ctrl'><div id='<%=idPortlet%>_labelTittbl' style='width:100%;'><%=JSPLib.ToHTML("TITOLARI EFFETTIVI (A.U.I.)")%></div></span>
<span id='<%=idPortlet%>_labelOpe'  formid='<%=idPortlet%>' ps-name='labelOpe'    class='label labelOpe_ctrl'><div id='<%=idPortlet%>_labelOpetbl' style='width:100%;'><%=JSPLib.ToHTML("OPERAZIONI (A.U.I.)")%></div></span>
<span id='<%=idPortlet%>_labelFrz'  formid='<%=idPortlet%>' ps-name='labelFrz'    class='label labelFrz_ctrl'><div id='<%=idPortlet%>_labelFrztbl' style='width:100%;'><%=JSPLib.ToHTML("FRAZIONATE (A.U.I.)")%></div></span>
<input id='<%=idPortlet%>_button12' type='button' class='button button12_ctrl'/>
<input id='<%=idPortlet%>_Conferma' type='button' class='button Conferma_ctrl'/>
<span id='<%=idPortlet%>_Label1'  formid='<%=idPortlet%>' ps-name='Label1'    class='label Label1_ctrl'><div id='<%=idPortlet%>_Label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data:")%></div></span>
<span id='<%=idPortlet%>_Label2'  formid='<%=idPortlet%>' ps-name='Label2'    class='label Label2_ctrl'><div id='<%=idPortlet%>_Label2tbl' style='width:100%;'><%=JSPLib.ToHTML("A Data:")%></div></span>
<span id='<%=idPortlet%>_Label3'  formid='<%=idPortlet%>' ps-name='Label3'    class='label Label3_ctrl'><div id='<%=idPortlet%>_Label3tbl' style='width:100%;'><%=JSPLib.ToHTML("Soggetto:")%></div></span>
<span id='<%=idPortlet%>_Label3_Copy'  formid='<%=idPortlet%>' ps-name='Label3_Copy'    class='label Label3_Copy_ctrl'><div id='<%=idPortlet%>_Label3_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Oper:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ragsoc_wrp'><input id='<%=idPortlet%>_ragsoc' name='ragsoc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ragsoc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_codcol_wrp'><input id='<%=idPortlet%>_codcol' name='codcol' type='text' maxlength='12' class='textbox' formid='<%=idPortlet%>' ps-name='codcol' /></span>
<span class='textbox-container'id='<%=idPortlet%>_a_data_wrp'><input id='<%=idPortlet%>_a_data' name='a_data' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='a_data' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dadata_wrp'><input id='<%=idPortlet%>_dadata' name='dadata' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='dadata' /></span>
<span id='<%=idPortlet%>_label19'  formid='<%=idPortlet%>' ps-name='label19'    class='label label19_ctrl'><div id='<%=idPortlet%>_label19tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Collegamento:")%></div></span>
<select id='<%=idPortlet%>_tipope' name='tipope' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_collegamenti');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_collegamenti',["742"],["700"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"742","h":"700","title":" ","layer":"false","npage":"1"}]);
this.GridOpe=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"IDBASE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridOpe","dataobj":"QueryOpe","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"#FFFFFF","link_underlined":"true","name":"GridOpe","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"black","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":" ","row_color":"#CCCCCC","row_color_odd":"#999999","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":" ","w":740,"x":0,"y":120});
this.GridOpe.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:operazbo_view","weight":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NUMPROG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data registrazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Collegamento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COLLEG","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.GridTit=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"IDBASE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridTit","dataobj":"QueryTit","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"false","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"#FFFFFF","link_underlined":"true","name":"GridTit","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"black","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":" ","row_color":"#CCCCCC","row_color_odd":"#999999","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":"left","title_color":"","type":"Grid","valign":" ","w":740,"x":0,"y":318});
this.GridTit.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:rapotit_view","weight":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NUMPROG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Registrazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAPPORTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Collegamento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COLLEG","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.GridFrz=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"IDBASE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridFrz","dataobj":"QueryFrz","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"#FFFFFF","link_underlined":"true","name":"GridFrz","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"black","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":" ","row_color":"#CCCCCC","row_color_odd":"#999999","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":" ","w":740,"x":0,"y":515});
this.GridFrz.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:fraziobo_view","weight":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NUMPROG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data registrazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Collegamento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COLLEG","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.QueryOpe=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_terz_oper","cmdHash":"<%=JSPLib.cmdHash("qbe_terz_oper",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_QueryOpe","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"QueryOpe","nrows":"100","page":1,"parms":"w_connes=w_CONNES,w_dadata=dadata,w_adata=a_data","parms_source":" ","type":"SQLDataobj","w":0,"x":0,"y":-40});
this.QueryTit=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_terz_tit","cmdHash":"<%=JSPLib.cmdHash("qbe_terz_tit",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_QueryTit","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"QueryTit","nrows":"100","page":1,"parms":"w_connes=w_CONNES,w_dadata=dadata,w_adata=a_data","parms_source":" ","type":"SQLDataobj","w":0,"x":36,"y":-40});
this.QueryFrz=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_terz_frz","cmdHash":"<%=JSPLib.cmdHash("qbe_terz_frz",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_QueryFrz","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"QueryFrz","nrows":"100","page":1,"parms":"w_connes=w_CONNES,w_dadata=dadata,w_adata=a_data","parms_source":" ","type":"SQLDataobj","w":0,"x":79,"y":-38});
this.w_CONNES=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"this.w_CONNES.Value()","create_undercond":" ","ctrlid":"<%=idPortlet%>_w_CONNES","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_CONNES","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_CONNES,false,true)%>","w":129,"x":67,"y":39,"zerofilling":false,"zindex":"1","zoom":""});
this.labelTit=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_labelTit","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTit","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(labelTit,false,true)%>","type":"Label","w":740,"x":0,"y":298,"zindex":"1"});
this.labelOpe=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_labelOpe","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelOpe","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(labelOpe,false,true)%>","type":"Label","w":740,"x":0,"y":100,"zindex":"1"});
this.labelFrz=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_labelFrz","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelFrz","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(labelFrz,false,true)%>","type":"Label","w":740,"x":0,"y":495,"zindex":"1"});
this.operazbo_view=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_operazbo_view","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"operazbo_view","offline":false,"page":1,"parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":" ","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_operazioni","target":"_new","type":"SPLinker","w":30,"x":360,"y":-42});
this.operazbo_view.m_cID='<%=JSPLib.cmdHash("entity,armt_operazioni",request.getSession())%>';
this.fraziobo_view=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_fraziobo_view","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"fraziobo_view","offline":false,"page":1,"parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":" ","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_ofrazionate","target":"_new","type":"SPLinker","w":30,"x":404,"y":-41});
this.fraziobo_view.m_cID='<%=JSPLib.cmdHash("entity,armt_ofrazionate",request.getSession())%>';
this.rapotit_view=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_rapotit_view","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"rapotit_view","offline":false,"page":1,"parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":" ","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_rapotit","target":"_new","type":"SPLinker","w":30,"x":445,"y":-43});
this.rapotit_view.m_cID='<%=JSPLib.cmdHash("entity,armt_rapotit",request.getSession())%>';
this.button12=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button button12_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_button12","edit_undercond":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"button12","page":1,"tabindex":" ","text":"Ricerca","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":310,"y":11});
this.Conferma=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button Conferma_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_Conferma","edit_undercond":"!(Empty(this.codcol.Value()))","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"Conferma","page":1,"tabindex":" ","text":"Collega","type":"Button","type_submit":"false","type_wizard":"","w":75,"x":648,"y":9});
this.Label1=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_Label1","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label1","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(Label1,false,true)%>","type":"Label","w":47,"x":18,"y":11,"zindex":"1"});
this.Label2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_Label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(Label2,false,true)%>","type":"Label","w":47,"x":173,"y":11,"zindex":"1"});
this.Label3=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_Label3","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(Label3,false,true)%>","type":"Label","w":47,"x":18,"y":42,"zindex":"1"});
this.Label3_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_Label3_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label3_Copy","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(Label3_Copy,false,true)%>","type":"Label","w":57,"x":8,"y":71,"zindex":"1"});
this.ragsoc=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_ragsoc","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"ragsoc","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragsoc,false,true)%>","w":517,"x":201,"y":39,"zerofilling":false,"zindex":"1","zoom":""});
this.codcol=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_codcol","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Inserire il codice di collegamento delle operazioni selezionate","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"12","name":"codcol","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codcol,false,true)%>","w":106,"x":532,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.a_data=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_a_data","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"a_data","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=a_data%>","w":83,"x":217,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.dadata=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_dadata","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dadata","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dadata%>","w":83,"x":67,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.label19=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label19","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label19","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label19,false,true)%>","type":"Label","w":125,"x":418,"y":11,"zindex":"1"});
this.opeValues=new ZtVWeb._VC(this,'opeValues',null,'character','<%=JSPLib.ToJSValue(opeValues,false,true)%>',false,false);
this.titValues=new ZtVWeb._VC(this,'titValues',null,'character','<%=JSPLib.ToJSValue(titValues,false,true)%>',false,false);
this.frzValues=new ZtVWeb._VC(this,'frzValues',null,'character','<%=JSPLib.ToJSValue(frzValues,false,true)%>',false,false);
this.RTCollega=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCollega","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTCollega","offline":false,"page":1,"parms":"tValues=titValues,oValues=opeValues,fValues=frzValues,pColleg=codcol,pTipo=tipope","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arrt_collegamenti_save","target":" ","type":"SPLinker","w":30,"x":702,"y":-44});
this.RTCollega.m_cID='<%=JSPLib.cmdHash("routine,arrt_collegamenti_save",request.getSession())%>';
this.tipope=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_tipope","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=tipope%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipope","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":"Normale,Multipla","type":"Combobox","typevar":"character","valuelist":"'0','1'","visible":true,"w":179,"x":67,"y":70});
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
<%if(request.getAttribute("pg_collegamenti_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_collegamenti_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_collegamenti_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.QueryOpe.firstQuery('true');
window.<%=idPortlet%>.QueryTit.firstQuery('true');
window.<%=idPortlet%>.QueryFrz.firstQuery('true');
window.<%=idPortlet%>.tipope.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_collegamenti',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_collegamenti');
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
sp.endPage("pg_collegamenti");
}%>
<%! public String getJSPUID() { return "3082076912"; } %>