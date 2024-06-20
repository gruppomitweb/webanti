<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _date;\nvar _y;\nvar _m;\nvar _d;\nvar rgx_CAB = new RegExp(\"\u002f^[0-9]{1,6}$\u002f\");\n\n\nfunction this_Loaded(){  \n  \u002f\u002f Inizializzazione variabili locali;\n  _date = new Date();\n  _y = _date.getFullYear();\n  _m = _date.getMonth();\n  this.pLog;\n  \u002f\u002f Gestione portlet\n  this.getTitlePortlet().SetTitle(\"Verifica Rilievi Dati Aggregati (XBRL)\");\n  \n  this.init_combo_anno();\n  this.init_combo_mese();\n  this.update_dadata_adata();\n  this.tipo_segnalante.Value(this.gTipInter.Value());\n  this.tb_codice_segn.Value(this.gIntemediario.Value());\n}\n\n\nfunction check_data(){\n\tif(this.cod_paese_residenza_cli.Value()==\"086\" && !(this.CAB_residenza_cli.Value().match(\"^[0-9]{1,6}$\"))){\n  \tif(confirm(\"Codice CAB di residenza del cliente non valido \\nSei sicuro di voler continuare?\")){\n      this.PortletLogs.Start();    \n      this.RTExec.Link();\n    }\n  }else{\n  \tthis.PortletLogs.Start();   \n    this.RTExec.Link();\n  }  \t\n}\n\nfunction elab_Click(){  \n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n      \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop();\n}    \n\nfunction init_combo_anno(){  \n  var strY = [_y-6,_y-5,_y-4,_y-3,_y-2,_y-1,_y].join(',');\n  this.Combobox_anno.FillDataStatic(strY,strY);  \n  this.Combobox_anno.Value(_y);\n}\nfunction init_combo_mese(){\n\tthis.Combobox_mese.FillDataStatic('1,2,3,4,5,6,7,8,9,10,11,12','gennaio,febbraio,marzo,aprile,maggio,giugno,luglio,agosto,settembre,ottobre,novembre,dicembre');\n  this.Combobox_mese.Value(new Date().getMonth()+1);\n}\nfunction Combobox_anno_onChange(){\n  this.update_dadata_adata();\n}\nfunction Combobox_mese_onChange(){\n  this.update_dadata_adata();\n}\nfunction update_dadata_adata(){  \u002f\u002f Gestisce l'aggiornamento della stringa \"da data a data\"\n  var a = parseInt(this.Combobox_anno.Value());\n  var m = parseInt(this.Combobox_mese.Value())-1;  \n  var d1 = new Date(a, m, 1);\n  var d2 = new Date(a, m+1, 0);\n  var A=[d1.getDate(),d1.getMonth(),d1.getFullYear()];\n  var B=[d2.getDate(),d2.getMonth(),d2.getFullYear()]; \n  var strA=[(A[0]\u003e9 ? '' : '0') + A[0],(A[1]\u003e9 ? '' : '0') +(A[1]+1),A[2]].join('-');\n  var strB=[(B[0]\u003e9 ? '' : '0') + B[0],(B[1]\u003e9 ? '' : '0') +(B[1]+1),B[2]].join('-');\n  this.DaDatOpe.Value(strA);\n  this.ADatOpe.Value(strB);\n\tthis.Label_dates.Value(strA+\" a \"+strB);\n  \u002f\u002f textbox data\n  this.tb_data_riferimento.Value(d2);\n}\nfunction V_descri_tipo_sgn_onChange(){\n  this.Label_descri_tipo_sgn.Value(this.V_descri_tipo_sgn.Value());\n}\nfunction V_descri_cod_dipe_onChange(){\n  this.Label_descri_cod_interno_dipe.Value(this.V_descri_cod_dipe.Value());\n}\nfunction V_descri_cod_paese_res_cli_onChange(){\n  this.Label_descr_cod_paese_res_cli.Value(this.V_descri_cod_paese_res_cli.Value());\n}\nfunction V_descri_cod_paese_int_contr_onChange(){\n  this.Label_descri_cod_paese_int_controp.Value(this.V_descri_cod_paese_int_contr.Value());\n}\nfunction V_descri_causale_aggregata_onChange(){\n  this.Label_descri_causale_aggregata.Value(this.V_descri_causale_aggregata.Value());\n}\nfunction V_descri_sett_sint_onChange(){\n  this.Label_desc_sett_sint.Value(this.V_descri_sett_sint.Value());\n}\nfunction V_descri_cod_paese_controp_onChange(){\n  this.Label_descri_cod_paese_controp.Value(this.V_descri_cod_paese_controp.Value());\n}\n\n\u002f\u002f --- Carica file xml di correzione\nfunction Image_upload_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction Image_import_correzioni_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.SQLRilievi.Query()\n    \u002f\u002f this.Grid86.Refresh()\n    this.Combobox_anno.Value(Year(this.tb_data_riferimento.Value()))\n    this.Combobox_mese.Value(Month(this.tb_data_riferimento.Value()))    \n  } \n}\n\nfunction Aggiorna(evt) {\n  this.RTSaveFile.Link();\n} \n\nfunction this_AfterPageChange(n,oldn){\n  if(n==1) {  \n    this.getTitlePortlet().RemoveButtons()\n  } else {\n    this.getTitlePortlet().AppendButton({\n      id:\"Genera_File\",\n      title:FormatMsg('Verifica Rilievi '),\n      tooltip:FormatMsg('Genera stampa della verifica dei rilievi S.AR.A'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb5c\"},\n      action:'javascript:' + this.formid +'.check_data()'\n    },1);    \n  }  \n}\n\nfunction Grid86_AfterRowChange(currRecIdx,prevRecIdx){\n  this.Combobox_anno.Value(Year(this.tb_data_riferimento.Value()))\n  this.Combobox_mese.Value(Month(this.tb_data_riferimento.Value()))\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Stampa Operazioni Rilievi Dati Aggregati (XBRL)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Label1 }}{{ @Image_import_correzioni }}{{ @Combobox_anno }}{{ @Image_upload }}{{ @Label4 }}{{ @nomefile }}{{ @Combobox_mese }}{{ @lblDatiRilievi }}{{ @Label_dates }}{{ @causale_aggregata }}{{ @cod_interno_dipe }}{{ @Label7_Copy }}{{ @Label0 }}{{ @CAB_dipe }}{{ @Label9_Copy }}{{ @Label11_Copy }}{{ @tb_data_riferimento }}{{ @cod_paese_controp }}{{ @Label12 }}{{ @label1_nome_file }}{{ @tipo_segnalante }}{{ @Label19 }}{{ @LinkZoom54 }}{{ @LinkZoom_dipe }}{{ @tb_codice_segn }}{{ @CAB_int_controp }}{{ @LinkZoom62 }}{{ @Label15 }}{{ @LinkZoom_tipo_sgn }}{{ @Label18_Copy_Copy }}{{ @Label_descri_causale_aggregata }}{{ @Label_descri_cod_interno_dipe }}{{ @Combobox_valuta }}{{ @CAB_controparte }}{{ @Label9_Copy_Copy }}{{ @Label8 }}{{ @Label17 }}{{ @Label_descri_cod_paese_controp }}{{ @Label16 }}{{ @Label_descri_tipo_sgn }}{{ @Label18_Copy_Copy_Copy }}{{ @Label11_Copy_Copy }}{{ @cod_paese_int_controp }}{{ @importo_tot }}{{ @Label10 }}{{ @ABICAB_dipe }}{{ @Label11 }}{{ @CAB_residenza_cli }}{{ @Label9 }}{{ @cod_paese_residenza_cli }}{{ @Label18 }}{{ @importo_tot_cont }}{{ @sett_sint }}{{ @num_tot_ope }}{{ @Label6 }}{{ @Label14 }}{{ @LinkZoom48 }}{{ @num_tot_ope_cont }}{{ @pLog }}{{ @Label_descr_cod_paese_res_cli }}{{ @pMsg }}{{ @LinkZoom_cod_paese_contr }}{{ @Label_descri_cod_paese_int_controp }}{{ @Combobox_segno }}{{ @LinkZoom59 }}{{ @Label_desc_sett_sint }}{{ @Label7 }}{{ @LabelVAR }}{{ @Label23 }}{{ @Combobox_tipo_ope }}{{ @Label43 }}{{ @Label13 }}{{ @Grid86 }}{{ @lblErr01 }}{{ @lblErr02 }}{{ @lblErr03 }}{{ @lblErr04 }}{{ @lblErr11 }}{{ @lblErr10 }}{{ @lblErr09 }}{{ @lblErr08 }}{{ @lblErr07 }}{{ @lblErr06 }}{{ @lblErr05 }}{{ @lblErr12 }}{{ @lblErr13 }}{{ @lblErr14 }}{{ @lblErr15 }}{{ @lblErr16 }}{{ @lblErr17 }}{{ @lblErr18 }}{{ @lblErr19 }}{{ @lblErr20 }}{{ @Label1 }}{{ @Image_import_correzioni }}{{ @Combobox_anno }}{{ @Image_upload }}{{ @Label4 }}{{ @nomefile }}{{ @Combobox_mese }}{{ @lblDatiRilievi }}{{ @Label_dates }}{{ @causale_aggregata }}{{ @cod_interno_dipe }}{{ @Label7_Copy }}{{ @Label0 }}{{ @CAB_dipe }}{{ @Label9_Copy }}{{ @Label11_Copy }}{{ @tb_data_riferimento }}{{ @cod_paese_controp }}{{ @Label12 }}{{ @label1_nome_file }}{{ @tipo_segnalante }}{{ @Label19 }}{{ @LinkZoom54 }}{{ @LinkZoom_dipe }}{{ @tb_codice_segn }}{{ @CAB_int_controp }}{{ @LinkZoom62 }}{{ @Label15 }}{{ @LinkZoom_tipo_sgn }}{{ @Label18_Copy_Copy }}{{ @Label_descri_causale_aggregata }}{{ @Label_descri_cod_interno_dipe }}{{ @Combobox_valuta }}{{ @CAB_controparte }}{{ @Label9_Copy_Copy }}{{ @Label8 }}{{ @Label17 }}{{ @Label_descri_cod_paese_controp }}{{ @Label16 }}{{ @Label_descri_tipo_sgn }}{{ @Label18_Copy_Copy_Copy }}{{ @Label11_Copy_Copy }}{{ @cod_paese_int_controp }}{{ @importo_tot }}{{ @Label10 }}{{ @ABICAB_dipe }}{{ @Label11 }}{{ @CAB_residenza_cli }}{{ @Label9 }}{{ @cod_paese_residenza_cli }}{{ @Label18 }}{{ @importo_tot_cont }}{{ @sett_sint }}{{ @num_tot_ope }}{{ @Label6 }}{{ @Label14 }}{{ @LinkZoom48 }}{{ @num_tot_ope_cont }}{{ @Label_descr_cod_paese_res_cli }}{{ @LinkZoom_cod_paese_contr }}{{ @Label_descri_cod_paese_int_controp }}{{ @Combobox_segno }}{{ @LinkZoom59 }}{{ @Label_desc_sett_sint }}{{ @Label7 }}{{ @LabelVAR }}{{ @Label23 }}{{ @Combobox_tipo_ope }}{{ @Label43 }}{{ @Label13 }}{{ @Grid86 }}{{ @lblErr01 }}{{ @lblErr02 }}{{ @lblErr03 }}{{ @lblErr04 }}{{ @lblErr11 }}{{ @lblErr10 }}{{ @lblErr09 }}{{ @lblErr08 }}{{ @lblErr07 }}{{ @lblErr06 }}{{ @lblErr05 }}{{ @lblErr12 }}{{ @lblErr13 }}{{ @lblErr14 }}{{ @lblErr15 }}{{ @lblErr16 }}{{ @lblErr17 }}{{ @lblErr18 }}{{ @lblErr19 }}{{ @lblErr20 }}{{ @Label1 }}{{ @Image_import_correzioni }}{{ @Combobox_anno }}{{ @Image_upload }}{{ @Label4 }}{{ @nomefile }}{{ @Combobox_mese }}{{ @lblDatiRilievi }}{{ @Label_dates }}{{ @causale_aggregata }}{{ @cod_interno_dipe }}{{ @Label7_Copy }}{{ @Label0 }}{{ @CAB_dipe }}{{ @Label9_Copy }}{{ @Label11_Copy }}{{ @tb_data_riferimento }}{{ @cod_paese_controp }}{{ @Label12 }}{{ @label1_nome_file }}{{ @tipo_segnalante }}{{ @Label19 }}{{ @LinkZoom54 }}{{ @LinkZoom_dipe }}{{ @tb_codice_segn }}{{ @CAB_int_controp }}{{ @LinkZoom62 }}{{ @Label15 }}{{ @LinkZoom_tipo_sgn }}{{ @Label18_Copy_Copy }}{{ @Label_descri_causale_aggregata }}{{ @Label_descri_cod_interno_dipe }}{{ @Combobox_valuta }}{{ @CAB_controparte }}{{ @Label9_Copy_Copy }}{{ @Label8 }}{{ @Label17 }}{{ @Label_descri_cod_paese_controp }}{{ @Label16 }}{{ @Label_descri_tipo_sgn }}{{ @Label18_Copy_Copy_Copy }}{{ @Label11_Copy_Copy }}{{ @cod_paese_int_controp }}{{ @importo_tot }}{{ @Label10 }}{{ @ABICAB_dipe }}{{ @Label11 }}{{ @CAB_residenza_cli }}{{ @Label9 }}{{ @cod_paese_residenza_cli }}{{ @Label18 }}{{ @importo_tot_cont }}{{ @sett_sint }}{{ @num_tot_ope }}{{ @Label6 }}{{ @Label14 }}{{ @LinkZoom48 }}{{ @num_tot_ope_cont }}{{ @Label_descr_cod_paese_res_cli }}{{ @LinkZoom_cod_paese_contr }}{{ @Label_descri_cod_paese_int_controp }}{{ @Combobox_segno }}{{ @LinkZoom59 }}{{ @Label_desc_sett_sint }}{{ @Label7 }}{{ @LabelVAR }}{{ @Label23 }}{{ @Combobox_tipo_ope }}{{ @Label43 }}{{ @Label13 }}{{ @Grid86 }}{{ @lblErr01 }}{{ @lblErr02 }}{{ @lblErr03 }}{{ @lblErr04 }}{{ @lblErr11 }}{{ @lblErr10 }}{{ @lblErr09 }}{{ @lblErr08 }}{{ @lblErr07 }}{{ @lblErr06 }}{{ @lblErr05 }}{{ @lblErr12 }}{{ @lblErr13 }}{{ @lblErr14 }}{{ @lblErr15 }}{{ @lblErr16 }}{{ @lblErr17 }}{{ @lblErr18 }}{{ @lblErr19 }}{{ @lblErr20 }}{{ @PortletLogs }}{{ @PortletLogs_Copy }}\u003c\u002fbody\u003e","grapesCss":"","h":"780,780","hsl":"","htmlcode":" \n{{ @lblErr20 }}\n{{ @lblErr19 }}\n{{ @lblErr18 }}\n{{ @lblErr17 }}\n{{ @lblErr16 }}\n{{ @lblErr15 }}\n{{ @lblErr14 }}\n{{ @lblErr13 }}\n{{ @lblErr12 }}\n{{ @lblErr05 }}\n{{ @lblErr06 }}\n{{ @lblErr07 }}\n{{ @lblErr08 }}\n{{ @lblErr09 }}\n{{ @lblErr10 }}\n{{ @lblErr11 }}\n{{ @lblErr04 }}\n{{ @lblErr03 }}\n{{ @lblErr02 }}\n{{ @lblErr01 }}\n{{ @Grid86 }}\n{{ @lblDatiRilievi }}\n{{ @nomefile }}\n{{ @Image_upload }}\n{{ @Image_import_correzioni }}\n{{ @label1_nome_file }}\n{{ @Label13 }}\n{{ @Label43 }}\n{{ @Combobox_tipo_ope }}\n{{ @Label23 }}\n{{ @LabelVAR }}\n{{ @Label7 }}\n{{ @Label_desc_sett_sint }}\n{{ @LinkZoom59 }}\n{{ @Combobox_segno }}\n{{ @Label_descri_cod_paese_int_controp }}\n{{ @LinkZoom_cod_paese_contr }}\n\n{{ @Label_descr_cod_paese_res_cli }}\n\n{{ @num_tot_ope_cont }}\n{{ @LinkZoom48 }}\n{{ @Label14 }}\n{{ @Label6 }}\n{{ @num_tot_ope }}\n{{ @sett_sint }}\n{{ @importo_tot_cont }}\n{{ @Label18 }}\n{{ @cod_paese_residenza_cli }}\n{{ @Label9 }}\n{{ @CAB_residenza_cli }}\n{{ @Label11 }}\n{{ @ABICAB_dipe }}\n{{ @Label10 }}\n{{ @importo_tot }}\n{{ @cod_paese_int_controp }}\n{{ @Label11_Copy_Copy }}\n{{ @Label18_Copy_Copy_Copy }}\n{{ @Label_descri_tipo_sgn }}\n{{ @Label16 }}\n{{ @Label_descri_cod_paese_controp }}\n{{ @Label17 }}\n{{ @Label8 }}\n{{ @Label9_Copy_Copy }}\n{{ @CAB_controparte }}\n{{ @Combobox_valuta }}\n{{ @Label_descri_cod_interno_dipe }}\n{{ @Label_descri_causale_aggregata }}\n{{ @Label18_Copy_Copy }}\n{{ @LinkZoom_tipo_sgn }}\n{{ @Label15 }}\n{{ @LinkZoom62 }}\n{{ @CAB_int_controp }}\n{{ @tb_codice_segn }}\n{{ @LinkZoom_dipe }}\n{{ @LinkZoom54 }}\n{{ @Label19 }}\n{{ @tipo_segnalante }}\n{{ @Label12 }}\n{{ @cod_paese_controp }}\n{{ @tb_data_riferimento }}\n{{ @Label11_Copy }}\n{{ @Label9_Copy }}\n{{ @CAB_dipe }}\n{{ @Label7_Copy }}\n{{ @cod_interno_dipe }}\n{{ @causale_aggregata }}\n{{ @Label_dates }}\n{{ @Combobox_mese }}\n{{ @Label4 }}\n{{ @Combobox_anno }}\n{{ @Label1 }}\n{{ @Label0 }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ CAB_controparte }}\n{{ Label9_Copy_Copy }}\n{{ Label9_Copy }}\n{{ CAB_int_controp }}\n{{ RTAzzera }}\n{{ Image_elab }}\n{{ btnExit_Copy }}\n{{ Image_prn }}{{ rabicab }}\n{{ btnExit }}{{ DaDatOpe }}\n{{ Label7_Copy }}{{ gIntemediario }}\n{{ Label8 }}{{ RTExec }}{{ ADatOpe }}\n{{ Label9 }}{{ gTipInter }}\n{{ Label10 }}{{ Image73 }}\n{{ Label12 }}\n{{ Label14 }}\n{{ Label15 }}{{ Label_dates }}\n{{ Label16 }}\n{{ Label17 }}\n{{ Label19 }}\n{{ Label18_Copy_Copy_Copy }}\n{{ tb_data_riferimento }}{{ SPLinker_lancia }}{{ Note76 }}\n{{ cod_paese_residenza_cli }}\n{{ num_tot_ope_cont }}{{ LinkZoom_tipo_sgn }}{{ Label_descri_tipo_sgn }}\n{{ Label11_Copy }}{{ V_descri_tipo_sgn }}\n{{ Label0 }}{{ Label1 }}{{ {{ Combobox_valuta }}Textbox2 }}{{ Combobox_anno }}{{ Label4 }}{{ Combobox_mese }}{{ Label6 }}{{ Label7 }}{{ Label13 }}{{ Label18 }}{{ Label18_Copy_Copy }}{{ LabelVAR }}{{ Label23 }}{{ tipo_segnalante }}{{ Variable26 }}{{ cod_paese_int_controp }}{{ cod_interno_dipe }}{{ CAB_dipe }}{{ CAB_residenza_cli }}{{ causale_aggregata }}{{ valuta }}{{ segno }}{{ sett_sint }}{{ cod_paese_controp }}{{ importo_tot }}{{ importo_tot_cont }}{{ num_tot_ope }}{{ Label11 }}{{ Combobox_tipo_ope }}{{ Label43 }}{{ tb_codice_segn }}{{ Calendario44 }}{{ LinkZoom_dipe }}{{ Label_descri_cod_interno_dipe }}{{ V_descri_cod_dipe }}{{ LinkZoom48 }}{{ Label_descr_cod_paese_res_cli }}{{ V_descri_cod_paese_res_cli }}{{ LinkZoom_cod_paese_contr }}{{ Label_descri_cod_paese_int_controp }}{{ V_descri_cod_paese_int_contr }}{{ LinkZoom54 }}{{ Label_descri_causale_aggregata }}{{ V_descri_causale_aggregata }}{{ Combobox_segno }}{{ LinkZoom59 }}{{ Label_desc_sett_sint }}{{ V_descri_sett_sint }}{{ LinkZoom62 }}{{ Label_descri_cod_paese_controp }}{{ V_descri_cod_paese_controp }}{{ pLog }}{{ pMsg }}{{ Image72 }}{{ Iframe_stp }}{{ @PortletLogs }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"1024","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1,2","pagesProp":"[{\"title\":\"Import elenco errori\",\"layer\":\"\",\"h\":\"780\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"Ricerca Rilievo\",\"layer\":\"\",\"h\":\"780\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Import elenco errori,Ricerca Rilievo","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%,100%","wizard":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label1","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno:","w":"81","wireframe_props":"align,value,n_col","x":"128","y":"39","zindex":"2","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"2","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"700","zindex":"3","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"3","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"1070","y":"26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_cod_paese_res_cli","page":"2","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"112"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"120","x":"1070","y":"93"},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xebe5;","font_image_hover":"&#xebe6;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Elabora il file con i rilievi","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_import_correzioni","page":"1","path_type":"","rapp":"","sequence":"6","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"762","y":"42","zindex":"34","zone":""},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"20","hide":"","layer":"","layout_steps_values":"{}","name":"Note64","page":"1","rapp":"","sequence":"7","spuid":"","type":"Note","value":"Bottone Upload","w":"120","wireframe_props":"","x":"1070","y":"5","zindex":"29","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_anno","page":"2","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"92","wireframe_props":"name,textlist","x":"214","y":"39","zindex":"3","zone":""},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna(evt)","page":"1","parmsNames":"nomefile","sequence":"9","type":"EventReceiver","w":"120","x":"1070","y":"49"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_cod_paese_int_contr","page":"2","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"60"},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Carica il file Excel delle correzioni","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_upload","page":"1","path_type":"","rapp":"","sequence":"11","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"42","zindex":"27","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label4","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Mese:","w":"44","wireframe_props":"align,value,n_col","x":"312","y":"39","zindex":"4","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_causale_aggregata","page":"2","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"138"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"565","wireframe_props":"name","x":"150","y":"48","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_mese","page":"2","picture":"","rapp":"","sequence":"15","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"92","wireframe_props":"name,textlist","x":"359","y":"39","zindex":"5","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_sett_sint","page":"2","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"164"},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDatiRilievi","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Upload File Rilievi","w":"200","wireframe_props":"align,value,n_col","x":"14","y":"26","zindex":"19","zone":""},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_dates","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"151","wireframe_props":"align,value,n_col","x":"456","y":"39","zindex":"40","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_cod_paese_controp","page":"2","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"190"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CAUSALE_AGGREGATA","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"causale_aggregata","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"198","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global","name":"gIntemediario","page":"2","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"-96"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CODICE_INTERNO_DIP","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"cod_interno_dipe","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"22","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"223","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global","name":"gTipInter","page":"2","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"-70"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label7_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice segnalante","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"273","zindex":"7","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_tipo_sgn","page":"2","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"34"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label0","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"PERIODO ESTRAZIONE OPERAZIONI","w":"241","wireframe_props":"align,value,n_col","x":"27","y":"9","zindex":"1","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"COMUNE_DIP","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"CAB_dipe","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"27","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"323","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"allowedentities":"arrt_discouic_rilievi_pg","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTExec","offline":"false","page":"2","parms":"w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_rcoddip=cod_interno_dipe,w_rabicab=ABICAB_dipe,w_rcabdip=CAB_dipe,w_rpaecli=cod_paese_residenza_cli,w_rcabcli=CAB_residenza_cli,w_rcodvoc=causale_aggregata,w_rflglire=Combobox_valuta,w_rsegno=Combobox_segno,w_rsetsin=sett_sint,w_rpaecon=cod_paese_controp,w_rcabcon=CAB_controparte,w_rpaeint=cod_paese_int_controp,w_rcabint=CAB_int_controp,w_TipoOper=Combobox_tipo_ope","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"28","servlet":"arrt_discouic_rilievi_pg","target":"","type":"SPLinker","w":"150","x":"1049","y":"218"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label9_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CAB intermediario della controparte","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"348","zindex":"7","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"DaDatOpe","page":"2","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"date","w":"120","x":"1056","y":"-44"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label11_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CAB comune di residenza del cliente","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"398","zindex":"7","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"ADatOpe","page":"2","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"date","w":"120","x":"1054","y":"-18"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"DATA_RIFERIMENTO","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"tb_data_riferimento","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"33","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"423","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"rabicab","page":"2","reactive":"","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"8"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"PAESE_CONTROPARTE","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"cod_paese_controp","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"35","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"448","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label12","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"36","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice paese di residenza del cliente","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"498","zindex":"7","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1_nome_file","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"37","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"129","wireframe_props":"align,value,n_col","x":"19","y":"51","zindex":"1","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TIPO_SEGNALANTE","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"tipo_segnalante","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"38","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"573","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label19","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo totale di cui contanti","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"623","zindex":"8","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"causale_aggregata,V_descri_causale_aggregata","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"causale_aggregata","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom54","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"CODVOC,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"40","servlet":"","spuid":"","suggest":"false","table":"tbcausin","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"198","zindex":"26","zone":"","zoomtitle":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"cod_interno_dipe,V_descri_cod_dipe,CAB_dipe,ABICAB_dipe","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"cod_interno_dipe","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom_dipe","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ,CAB,ABICABSARA","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"41","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"224","zindex":"17","zone":"","zoomtitle":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"CODICE_SEGNALANTE","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"tb_codice_segn","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"42","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"273","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"COMUNE_INTERM_CTRP","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"CAB_int_controp","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"43","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"348","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"cod_paese_controp,V_descri_cod_paese_controp","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"cod_paese_controp","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom62","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"44","servlet":"","spuid":"","suggest":"false","table":"tbstati","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"448","zindex":"34","zone":"","zoomtitle":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label15","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"45","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Segno monetario","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"523","zindex":"8","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"tipo_segnalante,V_descri_tipo_sgn","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"tipo_segnalante","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom_tipo_sgn","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"TIPOINT,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"46","servlet":"","spuid":"","suggest":"false","table":"tbtipint","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"573","zindex":"41","zone":"","zoomtitle":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label18_Copy_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"47","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Numero totale operazioni","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"648","zindex":"8","zone":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_descri_causale_aggregata","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"48","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"198","zindex":"27","zone":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3701FF","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_descri_cod_interno_dipe","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"49","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"224","zindex":"18","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"SQLRilievi","disabled":"false","edit_undercond":"","empty_value":"false","field":"CODICE_VALUTA","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_valuta","page":"2","picture":"","rapp":"","sequence":"50","spuid":"","tabindex":"","textlist":"Euro(3),Valuta(4)","type":"Combobox","typevar":"character","valuelist":"3,4","visible":"true","w":"275","wireframe_props":"name,textlist","x":"284","y":"298","zindex":"30","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"COMUNE_CONTROPARTE","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"CAB_controparte","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"51","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"373","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label9_Copy_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"52","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CAB della controparte","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"373","zindex":"7","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label8","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"53","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data di riferimento","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"423","zindex":"7","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label17","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"54","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice paese della controparte","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"448","zindex":"8","zone":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_descri_cod_paese_controp","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"55","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"448","zindex":"35","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label16","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"56","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Settorizzazione sintetica economica","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"548","zindex":"8","zone":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_descri_tipo_sgn","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"57","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"573","zindex":"42","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label18_Copy_Copy_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"58","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Numero totale operazioni di cui in contanti","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"673","zindex":"8","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label11_Copy_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"59","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ABI+CAB della dipendenza","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"248","zindex":"7","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"PAESE_INTERM_CTRP","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"cod_paese_int_controp","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"60","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"473","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"IMPORTO_TOT","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"importo_tot","page":"2","password":"","picker":"","picture":"999,999,999,999","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"61","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"598","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label10","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"62","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice interno della dipendenza","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"223","zindex":"7","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"ABICAB_SPORTELLO","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ABICAB_dipe","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"63","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"248","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label11","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"64","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CAB comune della dipendenza","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"323","zindex":"7","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"COMUNE_RES_CLIENTE","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"CAB_residenza_cli","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"65","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"398","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label9","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"66","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice paese intermediario della controparte","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"473","zindex":"7","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"PAESE_RES_CLIENTE","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"cod_paese_residenza_cli","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"67","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"498","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label18","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"68","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo totale","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"598","zindex":"8","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"IMPORTO_TOT_CONTANTI","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"importo_tot_cont","page":"2","password":"","picker":"","picture":"999,999,999,999","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"69","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"623","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"SETTORIZ_SINT_ECON","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sett_sint","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"70","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"548","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"NUMERO_TOT_OPER","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"num_tot_ope","page":"2","password":"","picker":"","picture":"999,999,999","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"71","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"648","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"72","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"DATI AGGREGATI DA RILIEVI","w":"241","wireframe_props":"align,value,n_col","x":"27","y":"85","zindex":"6","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"73","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Valuta della segnalazione","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"298","zindex":"8","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"cod_paese_residenza_cli,V_descri_cod_paese_res_cli","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"cod_paese_residenza_cli","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom48","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"74","servlet":"","spuid":"","suggest":"false","table":"tbstati","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"498","zindex":"20","zone":"","zoomtitle":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"NUMERO_OPER_CONT","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"num_tot_ope_cont","page":"2","password":"","picker":"","picture":"999,999,999","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"75","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"275","wireframe_props":"name","x":"284","y":"673","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3803FD","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_descr_cod_paese_res_cli","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"76","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"498","zindex":"21","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"cod_paese_int_controp,V_descri_cod_paese_int_contr","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"cod_paese_int_controp","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom_cod_paese_contr","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"77","servlet":"","spuid":"","suggest":"false","table":"tbstati","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"473","zindex":"23","zone":"","zoomtitle":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3701FF","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_descri_cod_paese_int_controp","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"78","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"473","zindex":"24","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"SQLRilievi","disabled":"false","edit_undercond":"","empty_value":"false","field":"SEGNO_MONETARIO","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_segno","page":"2","picture":"","rapp":"","sequence":"79","spuid":"","tabindex":"","textlist":"Dare (D),Avere(A)","type":"Combobox","typevar":"character","valuelist":"D,A","visible":"true","w":"275","wireframe_props":"name,textlist","x":"284","y":"523","zindex":"29","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"sett_sint,V_descri_sett_sint","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"sett_sint","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom59","offline":"false","openZoomOnMultipleRecord":"true","page":"2","path_type":"","queryparms":"","rapp":"","readfields":"SETSINT,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"80","servlet":"","spuid":"","suggest":"false","table":"tbsetsin","type":"LinkZoom","w":"20","wireframe_props":"","x":"562","y":"548","zindex":"31","zone":"","zoomtitle":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_desc_sett_sint","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"81","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"238","wireframe_props":"align,value,n_col","x":"586","y":"548","zindex":"32","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label7","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"82","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo segnalante","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"573","zindex":"7","zone":""},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelVAR","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"83","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"VARIABILE","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"173","zindex":"9","zone":""},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label23","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"84","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"VALORE","w":"275","wireframe_props":"align,value,n_col","x":"284","y":"173","zindex":"10","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"SQLRilievi","disabled":"false","edit_undercond":"","empty_value":"false","field":"TIPOLOGIA","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_tipo_ope","page":"2","picture":"","rapp":"","sequence":"85","spuid":"","tabindex":"","textlist":"SARA_BONIFICIALTRIITALIA,SARA_BONIFICIALTRIESTERI,SARA_ALTREOPERAZIONIALTRI,SARA_BONIFICIBANCHE,SARA_BONIFICIESTERI,SARA_ALTREOPERAZIONI","type":"Combobox","typevar":"character","valuelist":"SARA_BONIFICIALTRIITALIA,SARA_BONIFICIALTRIESTERI,SARA_ALTREOPERAZIONIALTRI,SARA_BONIFICIBANCHE,SARA_BONIFICIESTERI,SARA_ALTREOPERAZIONI","visible":"true","w":"235","wireframe_props":"name,textlist","x":"252","y":"122","zindex":"13","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label43","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"86","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Operazione:","w":"118","wireframe_props":"align,value,n_col","x":"128","y":"122","zindex":"14","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label13","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"87","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Causale aggregata","w":"255","wireframe_props":"align,value,n_col","x":"19","y":"198","zindex":"8","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"V_descri_cod_dipe","page":"2","reactive":"","sequence":"88","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1056","y":"86"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"ID\",\"title\":\"ID Rilievo\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"MOTIVO\",\"title\":\"Motivazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"TIPOLOGIA\",\"title\":\"Tipologia\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQLRilievi","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"504","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid86","nav_bar":"true","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"89","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"93","zindex":"43","zone":""},{"allowedentities":"arfn_readxml_rilievi","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTRilievi","offline":"false","page":"1","parms":"pFile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"90","servlet":"arfn_readxml_rilievi","target":"","type":"SPLinker","w":"120","x":"1071","y":"142"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"91","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1070","y":"71"},{"allowedqueries":"rows:arfn_readxml_rilievi","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"300","name":"SQLRilievi","offline":"false","page":"1","parms":"pFile=nomefile","parms_source":"","query":"rows:arfn_readxml_rilievi","query_async":"false","return_fields_type":"true","sequence":"92","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"1074","y":"-87"},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"CAUSALE_AGGREGATA_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr01","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"93","server_side":"","shrinkable":"false","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"198","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"CODICE_INTERNO_DIP_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr02","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"94","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"223","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"ABICAB_SPORTELLO_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr03","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"95","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"248","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"ABICAB_SPORTELLO_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr04","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"96","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"273","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"PAESE_CONTROPARTE_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr11","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"97","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"448","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"DATA_RIFERIMENTO_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr10","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"98","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"423","zindex":"44","zone":""},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"COMUNE_RES_CLIENTE_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr09","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"99","server_side":"false","shrinkable":"false","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"398","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"COMUNE_CONTROPARTE_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr08","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"100","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"373","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"COMUNE_INTERM_CTRP_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr07","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"101","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"348","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"COMUNE_DIP_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr06","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"102","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"323","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"CODICE_VALUTA_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr05","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"103","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"298","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"PAESE_INTERM_CTRP_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr12","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"104","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"473","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"PAESE_RES_CLIENTE_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr13","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"105","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"498","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"SEGNO_MONETARIO_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr14","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"106","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"523","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"SETTORIZ_SINT_ECON_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr15","nowrap":"true","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"107","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"548","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"TIPO_SEGNALANTE_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr16","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"108","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"573","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"IMPORTO_TOT_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr17","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"109","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"598","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"IMPORTO_TOT_CONTANTI_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr18","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"110","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"623","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"NUMERO_TOT_OPER_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr19","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"111","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"648","zindex":"44","zone":""},{"align":"","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"NUMERO_TOT_OPER_ERR","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblErr20","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"112","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"163","wireframe_props":"align,value,n_col","x":"845","y":"673","zindex":"44","zone":""}]%>
<%/*Description:Stampa Operazioni Rilievi Dati Aggregati (XBRL)*/%>
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
window.pg_discouic_rilievi_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof check_data !='undefined')this.check_data=check_data;
if(typeof elab_Click !='undefined')this.elab_Click=elab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof init_combo_anno !='undefined')this.init_combo_anno=init_combo_anno;
if(typeof init_combo_mese !='undefined')this.init_combo_mese=init_combo_mese;
if(typeof Combobox_anno_onChange !='undefined')this.Combobox_anno_onChange=Combobox_anno_onChange;
if(typeof Combobox_mese_onChange !='undefined')this.Combobox_mese_onChange=Combobox_mese_onChange;
if(typeof update_dadata_adata !='undefined')this.update_dadata_adata=update_dadata_adata;
if(typeof V_descri_tipo_sgn_onChange !='undefined')this.V_descri_tipo_sgn_onChange=V_descri_tipo_sgn_onChange;
if(typeof V_descri_cod_dipe_onChange !='undefined')this.V_descri_cod_dipe_onChange=V_descri_cod_dipe_onChange;
if(typeof V_descri_cod_paese_res_cli_onChange !='undefined')this.V_descri_cod_paese_res_cli_onChange=V_descri_cod_paese_res_cli_onChange;
if(typeof V_descri_cod_paese_int_contr_onChange !='undefined')this.V_descri_cod_paese_int_contr_onChange=V_descri_cod_paese_int_contr_onChange;
if(typeof V_descri_causale_aggregata_onChange !='undefined')this.V_descri_causale_aggregata_onChange=V_descri_causale_aggregata_onChange;
if(typeof V_descri_sett_sint_onChange !='undefined')this.V_descri_sett_sint_onChange=V_descri_sett_sint_onChange;
if(typeof V_descri_cod_paese_controp_onChange !='undefined')this.V_descri_cod_paese_controp_onChange=V_descri_cod_paese_controp_onChange;
if(typeof Image_upload_Click !='undefined')this.Image_upload_Click=Image_upload_Click;
if(typeof Image_import_correzioni_Click !='undefined')this.Image_import_correzioni_Click=Image_import_correzioni_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof this_AfterPageChange !='undefined')this.this_AfterPageChange=this_AfterPageChange;
if(typeof Grid86_AfterRowChange !='undefined')this.Grid86_AfterRowChange=Grid86_AfterRowChange;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.SQLRilievi.addDataConsumer(this.causale_aggregata,<%=JSPLib.ToJSValue("CAUSALE_AGGREGATA",true)%>);
this.SQLRilievi.addDataConsumer(this.cod_interno_dipe,<%=JSPLib.ToJSValue("CODICE_INTERNO_DIP",true)%>);
this.SQLRilievi.addDataConsumer(this.CAB_dipe,<%=JSPLib.ToJSValue("COMUNE_DIP",true)%>);
this.SQLRilievi.addDataConsumer(this.tb_data_riferimento,<%=JSPLib.ToJSValue("DATA_RIFERIMENTO",true)%>);
this.SQLRilievi.addDataConsumer(this.cod_paese_controp,<%=JSPLib.ToJSValue("PAESE_CONTROPARTE",true)%>);
this.SQLRilievi.addDataConsumer(this.tipo_segnalante,<%=JSPLib.ToJSValue("TIPO_SEGNALANTE",true)%>);
this.LinkZoom54.addObserverFixedVars();
this.LinkZoom_dipe.addObserverFixedVars();
this.SQLRilievi.addDataConsumer(this.tb_codice_segn,<%=JSPLib.ToJSValue("CODICE_SEGNALANTE",true)%>);
this.SQLRilievi.addDataConsumer(this.CAB_int_controp,<%=JSPLib.ToJSValue("COMUNE_INTERM_CTRP",true)%>);
this.LinkZoom62.addObserverFixedVars();
this.LinkZoom_tipo_sgn.addObserverFixedVars();
this.SQLRilievi.addDataConsumer(this.Combobox_valuta,'CODICE_VALUTA');
this.SQLRilievi.addDataConsumer(this.CAB_controparte,<%=JSPLib.ToJSValue("COMUNE_CONTROPARTE",true)%>);
this.SQLRilievi.addDataConsumer(this.cod_paese_int_controp,<%=JSPLib.ToJSValue("PAESE_INTERM_CTRP",true)%>);
this.SQLRilievi.addDataConsumer(this.importo_tot,<%=JSPLib.ToJSValue("IMPORTO_TOT",true)%>);
this.SQLRilievi.addDataConsumer(this.ABICAB_dipe,<%=JSPLib.ToJSValue("ABICAB_SPORTELLO",true)%>);
this.SQLRilievi.addDataConsumer(this.CAB_residenza_cli,<%=JSPLib.ToJSValue("COMUNE_RES_CLIENTE",true)%>);
this.SQLRilievi.addDataConsumer(this.cod_paese_residenza_cli,<%=JSPLib.ToJSValue("PAESE_RES_CLIENTE",true)%>);
this.SQLRilievi.addDataConsumer(this.importo_tot_cont,<%=JSPLib.ToJSValue("IMPORTO_TOT_CONTANTI",true)%>);
this.SQLRilievi.addDataConsumer(this.sett_sint,<%=JSPLib.ToJSValue("SETTORIZ_SINT_ECON",true)%>);
this.SQLRilievi.addDataConsumer(this.num_tot_ope,<%=JSPLib.ToJSValue("NUMERO_TOT_OPER",true)%>);
this.LinkZoom48.addObserverFixedVars();
this.SQLRilievi.addDataConsumer(this.num_tot_ope_cont,<%=JSPLib.ToJSValue("NUMERO_OPER_CONT",true)%>);
this.LinkZoom_cod_paese_contr.addObserverFixedVars();
this.SQLRilievi.addDataConsumer(this.Combobox_segno,'SEGNO_MONETARIO');
this.LinkZoom59.addObserverFixedVars();
this.SQLRilievi.addDataConsumer(this.Combobox_tipo_ope,'TIPOLOGIA');
this.SQLRilievi.addRowConsumer(this.Grid86);
this.SQLRilievi.addDataConsumer(this.lblErr01,'CAUSALE_AGGREGATA_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr02,'CODICE_INTERNO_DIP_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr03,'ABICAB_SPORTELLO_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr04,'ABICAB_SPORTELLO_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr11,'PAESE_CONTROPARTE_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr10,'DATA_RIFERIMENTO_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr09,'COMUNE_RES_CLIENTE_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr08,'COMUNE_CONTROPARTE_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr07,'COMUNE_INTERM_CTRP_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr06,'COMUNE_DIP_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr05,'CODICE_VALUTA_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr12,'PAESE_INTERM_CTRP_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr13,'PAESE_RES_CLIENTE_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr14,'SEGNO_MONETARIO_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr15,'SETTORIZ_SINT_ECON_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr16,'TIPO_SEGNALANTE_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr17,'IMPORTO_TOT_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr18,'IMPORTO_TOT_CONTANTI_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr19,'NUMERO_TOT_OPER_ERR');
this.SQLRilievi.addDataConsumer(this.lblErr20,'NUMERO_TOT_OPER_ERR');
var _date;
var _y;
var _m;
var _d;
var rgx_CAB = new RegExp("/^[0-9]{1,6}$/");
function this_Loaded(){  
  // Inizializzazione variabili locali;
  _date = new Date();
  _y = _date.getFullYear();
  _m = _date.getMonth();
  this.pLog;
  // Gestione portlet
  this.getTitlePortlet().SetTitle("Verifica Rilievi Dati Aggregati (XBRL)");
  
  this.init_combo_anno();
  this.init_combo_mese();
  this.update_dadata_adata();
  this.tipo_segnalante.Value(this.gTipInter.Value());
  this.tb_codice_segn.Value(this.gIntemediario.Value());
}
function check_data(){
	if(this.cod_paese_residenza_cli.Value()=="086" && !(this.CAB_residenza_cli.Value().match("^[0-9]{1,6}$"))){
  	if(confirm("Codice CAB di residenza del cliente non valido \nSei sicuro di voler continuare?")){
      this.PortletLogs.Start();    
      this.RTExec.Link();
    }
  }else{
  	this.PortletLogs.Start();   
    this.RTExec.Link();
  }  	
}
function elab_Click(){  
  if (confirm("Confermi l'estrazione dei dati?")) {
      
  }  
}
function RTExec_Result(result){
  this.PortletLogs.Stop();
}    
function init_combo_anno(){  
  var strY = [_y-6,_y-5,_y-4,_y-3,_y-2,_y-1,_y].join(',');
  this.Combobox_anno.FillDataStatic(strY,strY);  
  this.Combobox_anno.Value(_y);
}
function init_combo_mese(){
	this.Combobox_mese.FillDataStatic('1,2,3,4,5,6,7,8,9,10,11,12','gennaio,febbraio,marzo,aprile,maggio,giugno,luglio,agosto,settembre,ottobre,novembre,dicembre');
  this.Combobox_mese.Value(new Date().getMonth()+1);
}
function Combobox_anno_onChange(){
  this.update_dadata_adata();
}
function Combobox_mese_onChange(){
  this.update_dadata_adata();
}
function update_dadata_adata(){  // Gestisce l'aggiornamento della stringa "da data a data"
  var a = parseInt(this.Combobox_anno.Value());
  var m = parseInt(this.Combobox_mese.Value())-1;  
  var d1 = new Date(a, m, 1);
  var d2 = new Date(a, m+1, 0);
  var A=[d1.getDate(),d1.getMonth(),d1.getFullYear()];
  var B=[d2.getDate(),d2.getMonth(),d2.getFullYear()]; 
  var strA=[(A[0]>9 ? '' : '0') + A[0],(A[1]>9 ? '' : '0') +(A[1]+1),A[2]].join('-');
  var strB=[(B[0]>9 ? '' : '0') + B[0],(B[1]>9 ? '' : '0') +(B[1]+1),B[2]].join('-');
  this.DaDatOpe.Value(strA);
  this.ADatOpe.Value(strB);
	this.Label_dates.Value(strA+" a "+strB);
  // textbox data
  this.tb_data_riferimento.Value(d2);
}
function V_descri_tipo_sgn_onChange(){
  this.Label_descri_tipo_sgn.Value(this.V_descri_tipo_sgn.Value());
}
function V_descri_cod_dipe_onChange(){
  this.Label_descri_cod_interno_dipe.Value(this.V_descri_cod_dipe.Value());
}
function V_descri_cod_paese_res_cli_onChange(){
  this.Label_descr_cod_paese_res_cli.Value(this.V_descri_cod_paese_res_cli.Value());
}
function V_descri_cod_paese_int_contr_onChange(){
  this.Label_descri_cod_paese_int_controp.Value(this.V_descri_cod_paese_int_contr.Value());
}
function V_descri_causale_aggregata_onChange(){
  this.Label_descri_causale_aggregata.Value(this.V_descri_causale_aggregata.Value());
}
function V_descri_sett_sint_onChange(){
  this.Label_desc_sett_sint.Value(this.V_descri_sett_sint.Value());
}
function V_descri_cod_paese_controp_onChange(){
  this.Label_descri_cod_paese_controp.Value(this.V_descri_cod_paese_controp.Value());
}
// --- Carica file xml di correzione
function Image_upload_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function Image_import_correzioni_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.SQLRilievi.Query()
    // this.Grid86.Refresh()
    this.Combobox_anno.Value(Year(this.tb_data_riferimento.Value()))
    this.Combobox_mese.Value(Month(this.tb_data_riferimento.Value()))    
  } 
}
function Aggiorna(evt) {
  this.RTSaveFile.Link();
} 
function this_AfterPageChange(n,oldn){
  if(n==1) {  
    this.getTitlePortlet().RemoveButtons()
  } else {
    this.getTitlePortlet().AppendButton({
      id:"Genera_File",
      title:FormatMsg('Verifica Rilievi '),
      tooltip:FormatMsg('Genera stampa della verifica dei rilievi S.AR.A'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb5c"},
      action:'javascript:' + this.formid +'.check_data()'
    },1);    
  }  
}
function Grid86_AfterRowChange(currRecIdx,prevRecIdx){
  this.Combobox_anno.Value(Year(this.tb_data_riferimento.Value()))
  this.Combobox_mese.Value(Month(this.tb_data_riferimento.Value()))
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
.pg_discouic_rilievi_container {
  height:100%;
  overflow:auto;
}
.pg_discouic_rilievi_title_container {
  margin: auto;
}
.pg_discouic_rilievi_portlet{
  position:relative;
  margin: auto;
  min-width:1024px;
  height:100%;
}
.pg_discouic_rilievi_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_discouic_rilievi_portlet[Data-page="2"]{
  height:100%;
  width:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:39px;
  left:128px;
  width:81px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label1_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label1_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:700px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Image_import_correzioni_ctrl {
  box-sizing:border-box;
  z-index:34;
  position:absolute;
  display:inline-block;
  top:42px;
  left:762px;
  width:30px;
  height:30px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Image_import_correzioni_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Combobox_anno_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:39px;
  left:214px;
  width:92px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Image_upload_ctrl {
  box-sizing:border-box;
  z-index:27;
  position:absolute;
  display:inline-block;
  top:42px;
  left:725px;
  width:30px;
  height:30px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Image_upload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label4_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:39px;
  left:312px;
  width:44px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label4_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label4_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:150px;
  width:565px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .nomefile_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Combobox_mese_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:39px;
  left:359px;
  width:92px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblDatiRilievi_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:26px;
  left:14px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblDatiRilievi_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblDatiRilievi_ctrl {
  overflow:hidden;
  font-weight:bold;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_dates_ctrl {
  box-sizing:border-box;
  z-index:40;
  position:absolute;
  display:inline-block;
  top:39px;
  left:456px;
  width:151px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_dates_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_dates_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .causale_aggregata_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:198px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .causale_aggregata_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .causale_aggregata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_interno_dipe_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:223px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_interno_dipe_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_interno_dipe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label7_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:273px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label7_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label7_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:27px;
  left:2.6367188%;
  right:756px;
  right:73.828125%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label0_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label0_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_dipe_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:323px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_dipe_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_dipe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:348px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:398px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tb_data_riferimento_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:423px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tb_data_riferimento_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tb_data_riferimento_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_controp_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:448px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_controp_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_controp_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label12_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:498px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label12_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label12_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .label1_nome_file_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:51px;
  left:19px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .label1_nome_file_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .label1_nome_file_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tipo_segnalante_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:573px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tipo_segnalante_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tipo_segnalante_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label19_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:623px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label19_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label19_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom54_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:198px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom_dipe_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:224px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tb_codice_segn_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:273px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tb_codice_segn_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .tb_codice_segn_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_int_controp_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:348px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_int_controp_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_int_controp_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom62_ctrl {
  box-sizing:border-box;
  z-index:34;
  position:absolute;
  display:inline-block;
  top:448px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label15_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:523px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label15_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label15_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom_tipo_sgn_ctrl {
  box-sizing:border-box;
  z-index:41;
  position:absolute;
  display:inline-block;
  top:573px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:648px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_causale_aggregata_ctrl {
  box-sizing:border-box;
  z-index:27;
  position:absolute;
  display:inline-block;
  top:198px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_causale_aggregata_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_causale_aggregata_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3600FF;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_interno_dipe_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:224px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_interno_dipe_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_interno_dipe_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3701FF;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Combobox_valuta_ctrl {
  box-sizing:border-box;
  z-index:30;
  position:absolute;
  display:inline-block;
  top:298px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_controparte_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:373px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_controparte_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_controparte_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:373px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label8_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:423px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label8_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label8_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label17_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:448px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label17_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label17_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_paese_controp_ctrl {
  box-sizing:border-box;
  z-index:35;
  position:absolute;
  display:inline-block;
  top:448px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_paese_controp_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_paese_controp_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3600FF;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label16_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:548px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label16_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label16_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_tipo_sgn_ctrl {
  box-sizing:border-box;
  z-index:42;
  position:absolute;
  display:inline-block;
  top:573px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_tipo_sgn_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_tipo_sgn_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3600FF;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:673px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:248px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_int_controp_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:473px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_int_controp_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_int_controp_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .importo_tot_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:598px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .importo_tot_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .importo_tot_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label10_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:223px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label10_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label10_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .ABICAB_dipe_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:248px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .ABICAB_dipe_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .ABICAB_dipe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:323px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label11_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_residenza_cli_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:398px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_residenza_cli_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .CAB_residenza_cli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:473px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label9_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_residenza_cli_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:498px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_residenza_cli_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .cod_paese_residenza_cli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:598px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label18_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .importo_tot_cont_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:623px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .importo_tot_cont_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .importo_tot_cont_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .sett_sint_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:548px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .sett_sint_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .sett_sint_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .num_tot_ope_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:648px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .num_tot_ope_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .num_tot_ope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label6_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:85px;
  left:27px;
  left:2.6367188%;
  right:756px;
  right:73.828125%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label6_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label6_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label14_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:298px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label14_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label14_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom48_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:498px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .num_tot_ope_cont_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:673px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .num_tot_ope_cont_ctrl {
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .num_tot_ope_cont_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descr_cod_paese_res_cli_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:498px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descr_cod_paese_res_cli_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descr_cod_paese_res_cli_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3803FD;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom_cod_paese_contr_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:473px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_paese_int_controp_ctrl {
  box-sizing:border-box;
  z-index:24;
  position:absolute;
  display:inline-block;
  top:473px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_paese_int_controp_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_descri_cod_paese_int_controp_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3701FF;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Combobox_segno_ctrl {
  box-sizing:border-box;
  z-index:29;
  position:absolute;
  display:inline-block;
  top:523px;
  left:284px;
  width:275px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LinkZoom59_ctrl {
  box-sizing:border-box;
  z-index:31;
  position:absolute;
  display:inline-block;
  top:548px;
  left:562px;
  width:20px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_desc_sett_sint_ctrl {
  box-sizing:border-box;
  z-index:32;
  position:absolute;
  display:inline-block;
  top:548px;
  left:586px;
  width:238px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_desc_sett_sint_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label_desc_sett_sint_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  font-weight:bold;
  color:#3600FF;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label7_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:573px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label7_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label7_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LabelVAR_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:173px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LabelVAR_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .LabelVAR_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label23_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:173px;
  left:284px;
  width:275px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label23_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Combobox_tipo_ope_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:122px;
  left:252px;
  width:235px;
  height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label43_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:122px;
  left:128px;
  width:118px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label43_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label43_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label13_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:198px;
  left:19px;
  width:255px;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label13_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Label13_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .Grid86_ctrl {
  box-sizing:border-box;
  z-index:43;
  position:absolute;
  display:inline-block;
  top:93px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:504px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr01_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:198px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr01_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr01_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr02_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:223px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr02_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr02_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr03_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:248px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr03_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr03_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr04_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:273px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr04_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr04_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr11_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:448px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr11_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr11_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr10_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:423px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr10_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr10_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr09_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:398px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr09_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr09_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr08_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:373px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr08_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr08_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr07_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:348px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr07_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr07_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr06_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:323px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr06_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr06_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr05_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:298px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr05_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr05_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr12_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:473px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr12_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr12_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr13_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:498px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr13_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr13_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr14_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:523px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr14_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr14_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr15_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:548px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr15_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr15_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr16_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:573px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr16_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr16_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr17_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:598px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr17_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr17_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr18_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:623px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr18_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr19_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:648px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr19_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr19_ctrl {
  overflow:hidden;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr20_ctrl {
  box-sizing:border-box;
  z-index:44;
  position:absolute;
  display:inline-block;
  top:673px;
  left:845px;
  right:16px;
  right:1.5625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr20_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_rilievi_portlet > .pg_discouic_rilievi_page > .lblErr20_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"780,780\",\"layout_steps_values\":{},\"pages_names\":\"Import elenco errori,Ricerca Rilievo\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%,100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Anno:\",\"w\":\"81\",\"x\":\"128\",\"y\":\"39\",\"zindex\":\"2\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"700\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"26\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"112\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"93\"},{\"anchor\":\"top-left\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"762\",\"y\":\"42\",\"zindex\":\"34\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Note\",\"value\":\"Bottone Upload\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"5\",\"zindex\":\"29\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_anno\",\"page\":\"2\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"92\",\"x\":\"214\",\"y\":\"39\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"49\"},{\"h\":\"20\",\"name\":\"V_descri_cod_paese_int_contr\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"60\"},{\"anchor\":\"top-left\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Image_upload\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"42\",\"zindex\":\"27\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label4\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"44\",\"x\":\"312\",\"y\":\"39\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"V_descri_causale_aggregata\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"138\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"565\",\"x\":\"150\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_mese\",\"page\":\"2\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"92\",\"x\":\"359\",\"y\":\"39\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"V_descri_sett_sint\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"164\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDatiRilievi\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Upload File Rilievi\",\"w\":\"200\",\"x\":\"14\",\"y\":\"26\",\"zindex\":\"19\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_dates\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"151\",\"x\":\"456\",\"y\":\"39\",\"zindex\":\"40\"},{\"h\":\"20\",\"name\":\"V_descri_cod_paese_controp\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"190\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"causale_aggregata\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"198\",\"zindex\":\"12\"},{\"h\":\"20\",\"name\":\"gIntemediario\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"-96\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cod_interno_dipe\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"223\",\"zindex\":\"12\"},{\"h\":\"20\",\"name\":\"gTipInter\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"-70\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label7_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Codice segnalante\",\"w\":\"255\",\"x\":\"19\",\"y\":\"273\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"V_descri_tipo_sgn\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"34\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label0\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"PERIODO ESTRAZIONE OPERAZIONI\",\"w\":\"241\",\"x\":\"27\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CAB_dipe\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"323\",\"zindex\":\"12\"},{\"h\":\"20\",\"name\":\"RTExec\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"150\",\"x\":\"1049\",\"y\":\"218\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label9_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"CAB intermediario della controparte\",\"w\":\"255\",\"x\":\"19\",\"y\":\"348\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"DaDatOpe\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"-44\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label11_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"CAB comune di residenza del cliente\",\"w\":\"255\",\"x\":\"19\",\"y\":\"398\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"ADatOpe\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1054\",\"y\":\"-18\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tb_data_riferimento\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"423\",\"zindex\":\"11\"},{\"h\":\"20\",\"name\":\"rabicab\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cod_paese_controp\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"448\",\"zindex\":\"12\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label12\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Codice paese di residenza del cliente\",\"w\":\"255\",\"x\":\"19\",\"y\":\"498\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1_nome_file\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"129\",\"x\":\"19\",\"y\":\"51\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipo_segnalante\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"573\",\"zindex\":\"11\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label19\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Importo totale di cui contanti\",\"w\":\"255\",\"x\":\"19\",\"y\":\"623\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom54\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"198\",\"zindex\":\"26\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_dipe\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"224\",\"zindex\":\"17\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tb_codice_segn\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"273\",\"zindex\":\"15\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CAB_int_controp\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"348\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom62\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"448\",\"zindex\":\"34\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label15\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Segno monetario\",\"w\":\"255\",\"x\":\"19\",\"y\":\"523\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_tipo_sgn\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"573\",\"zindex\":\"41\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18_Copy_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Numero totale operazioni\",\"w\":\"255\",\"x\":\"19\",\"y\":\"648\",\"zindex\":\"8\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_descri_causale_aggregata\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"198\",\"zindex\":\"27\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_descri_cod_interno_dipe\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"224\",\"zindex\":\"18\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_valuta\",\"page\":\"2\",\"textlist\":\"Euro(3),Valuta(4)\",\"type\":\"Combobox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"298\",\"zindex\":\"30\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CAB_controparte\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"373\",\"zindex\":\"12\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label9_Copy_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"CAB della controparte\",\"w\":\"255\",\"x\":\"19\",\"y\":\"373\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label8\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Data di riferimento\",\"w\":\"255\",\"x\":\"19\",\"y\":\"423\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label17\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Codice paese della controparte\",\"w\":\"255\",\"x\":\"19\",\"y\":\"448\",\"zindex\":\"8\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_descri_cod_paese_controp\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"448\",\"zindex\":\"35\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label16\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Settorizzazione sintetica economica\",\"w\":\"255\",\"x\":\"19\",\"y\":\"548\",\"zindex\":\"8\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_descri_tipo_sgn\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"573\",\"zindex\":\"42\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18_Copy_Copy_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Numero totale operazioni di cui in contanti\",\"w\":\"255\",\"x\":\"19\",\"y\":\"673\",\"zindex\":\"8\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label11_Copy_Copy\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"ABI+CAB della dipendenza\",\"w\":\"255\",\"x\":\"19\",\"y\":\"248\",\"zindex\":\"7\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cod_paese_int_controp\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"473\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"importo_tot\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"598\",\"zindex\":\"12\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label10\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Codice interno della dipendenza\",\"w\":\"255\",\"x\":\"19\",\"y\":\"223\",\"zindex\":\"7\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ABICAB_dipe\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"248\",\"zindex\":\"12\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label11\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"CAB comune della dipendenza\",\"w\":\"255\",\"x\":\"19\",\"y\":\"323\",\"zindex\":\"7\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CAB_residenza_cli\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"398\",\"zindex\":\"12\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label9\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Codice paese intermediario della controparte\",\"w\":\"255\",\"x\":\"19\",\"y\":\"473\",\"zindex\":\"7\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cod_paese_residenza_cli\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"498\",\"zindex\":\"12\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Importo totale\",\"w\":\"255\",\"x\":\"19\",\"y\":\"598\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"importo_tot_cont\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"623\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sett_sint\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"548\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"num_tot_ope\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"648\",\"zindex\":\"12\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"DATI AGGREGATI DA RILIEVI\",\"w\":\"241\",\"x\":\"27\",\"y\":\"85\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Valuta della segnalazione\",\"w\":\"255\",\"x\":\"19\",\"y\":\"298\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom48\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"498\",\"zindex\":\"20\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"num_tot_ope_cont\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"673\",\"zindex\":\"12\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_descr_cod_paese_res_cli\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"498\",\"zindex\":\"21\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_cod_paese_contr\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"473\",\"zindex\":\"23\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_descri_cod_paese_int_controp\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"473\",\"zindex\":\"24\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_segno\",\"page\":\"2\",\"textlist\":\"Dare (D),Avere(A)\",\"type\":\"Combobox\",\"w\":\"275\",\"x\":\"284\",\"y\":\"523\",\"zindex\":\"29\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom59\",\"page\":\"2\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"562\",\"y\":\"548\",\"zindex\":\"31\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_desc_sett_sint\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"238\",\"x\":\"586\",\"y\":\"548\",\"zindex\":\"32\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label7\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Tipo segnalante\",\"w\":\"255\",\"x\":\"19\",\"y\":\"573\",\"zindex\":\"7\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"LabelVAR\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"VARIABILE\",\"w\":\"255\",\"x\":\"19\",\"y\":\"173\",\"zindex\":\"9\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label23\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"VALORE\",\"w\":\"275\",\"x\":\"284\",\"y\":\"173\",\"zindex\":\"10\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_tipo_ope\",\"page\":\"2\",\"textlist\":\"SARA_BONIFICIALTRIITALIA,SARA_BONIFICIALTRIESTERI,SARA_ALTREOPERAZIONIALTRI,SARA_BONIFICIBANCHE,SARA_BONIFICIESTERI,SARA_ALTREOPERAZIONI\",\"type\":\"Combobox\",\"w\":\"235\",\"x\":\"252\",\"y\":\"122\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label43\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":\"118\",\"x\":\"128\",\"y\":\"122\",\"zindex\":\"14\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label13\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Causale aggregata\",\"w\":\"255\",\"x\":\"19\",\"y\":\"198\",\"zindex\":\"8\"},{\"h\":\"20\",\"name\":\"V_descri_cod_dipe\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1056\",\"y\":\"86\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ID Rilievo\"},{\"title\":\"Motivazione\"},{\"title\":\"Tipologia\"}],\"h\":\"504\",\"layout_steps_values\":{},\"name\":\"Grid86\",\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"93\",\"zindex\":\"43\"},{\"h\":\"20\",\"name\":\"RTRilievi\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1071\",\"y\":\"142\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"71\"},{\"h\":\"20\",\"name\":\"SQLRilievi\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1074\",\"y\":\"-87\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr01\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"198\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr02\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"223\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr03\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"248\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr04\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"273\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr11\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"448\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr10\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"423\",\"zindex\":\"44\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr09\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"398\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr08\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"373\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr07\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"348\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr06\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"323\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr05\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"298\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr12\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"473\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr13\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"498\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr14\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"523\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr15\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"548\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr16\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"573\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr17\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"598\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr18\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"623\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr19\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"648\",\"zindex\":\"44\"},{\"align\":\"\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblErr20\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"163\",\"x\":\"845\",\"y\":\"673\",\"zindex\":\"44\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_discouic_rilievi","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_discouic_rilievi_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_discouic_rilievi','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label1= "Anno:";
String V_descri_cod_paese_res_cli= "";
String Combobox_anno= "";
String V_descri_cod_paese_int_contr= "";
String Label4= "Mese:";
String V_descri_causale_aggregata= "";
String nomefile= "";
if(request.getAttribute("pg_discouic_rilievi_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Combobox_mese= "";
String V_descri_sett_sint= "";
String lblDatiRilievi= "Upload File Rilievi";
String Label_dates= "";
String V_descri_cod_paese_controp= "";
String causale_aggregata= "";
String gIntemediario=sp.getGlobal("gIntemediario","");
String cod_interno_dipe= "";
String gTipInter=sp.getGlobal("gTipInter","");
String Label7_Copy= "Codice segnalante";
String V_descri_tipo_sgn= "";
String Label0= "PERIODO ESTRAZIONE OPERAZIONI";
String CAB_dipe= "";
String Label9_Copy= "CAB intermediario della controparte";
java.sql.Date DaDatOpe= JSPLib.NullDate();
String Label11_Copy= "CAB comune di residenza del cliente";
java.sql.Date ADatOpe= JSPLib.NullDate();
java.sql.Date tb_data_riferimento= JSPLib.NullDate();
String rabicab= "";
String cod_paese_controp= "";
String Label12= "Codice paese di residenza del cliente";
String label1_nome_file= "NomeFile:";
String tipo_segnalante= "";
String Label19= "Importo totale di cui contanti";
if(request.getAttribute("pg_discouic_rilievi_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String tb_codice_segn= "";
String CAB_int_controp= "";
String Label15= "Segno monetario";
String Label18_Copy_Copy= "Numero totale operazioni";
String Label_descri_causale_aggregata= "";
String Label_descri_cod_interno_dipe= "";
String Combobox_valuta= "";
String CAB_controparte= "";
String Label9_Copy_Copy= "CAB della controparte";
String Label8= "Data di riferimento";
String Label17= "Codice paese della controparte";
String Label_descri_cod_paese_controp= "";
String Label16= "Settorizzazione sintetica economica";
String Label_descri_tipo_sgn= "";
String Label18_Copy_Copy_Copy= "Numero totale operazioni di cui in contanti";
String Label11_Copy_Copy= "ABI+CAB della dipendenza";
String cod_paese_int_controp= "";
double importo_tot= 0;
String Label10= "Codice interno della dipendenza";
String ABICAB_dipe= "";
String Label11= "CAB comune della dipendenza";
String CAB_residenza_cli= "";
String Label9= "Codice paese intermediario della controparte";
String cod_paese_residenza_cli= "";
String Label18= "Importo totale";
double importo_tot_cont= 0;
String sett_sint= "";
double num_tot_ope= 0;
String Label6= "DATI AGGREGATI DA RILIEVI";
String Label14= "Valuta della segnalazione";
double num_tot_ope_cont= 0;
String Label_descr_cod_paese_res_cli= "";
String Label_descri_cod_paese_int_controp= "";
String Combobox_segno= "";
String Label_desc_sett_sint= "";
String Label7= "Tipo segnalante";
String LabelVAR= "VARIABILE";
String Label23= "VALORE";
String Combobox_tipo_ope= "";
String Label43= "Tipo Operazione:";
String Label13= "Causale aggregata";
String V_descri_cod_dipe= "";
if(request.getAttribute("pg_discouic_rilievi_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String dir= "";
String lblErr01= "";
String lblErr02= "";
String lblErr03= "";
String lblErr04= "";
String lblErr11= "";
String lblErr10= "";
String lblErr09= "";
String lblErr08= "";
String lblErr07= "";
String lblErr06= "";
String lblErr05= "";
String lblErr12= "";
String lblErr13= "";
String lblErr14= "";
String lblErr15= "";
String lblErr16= "";
String lblErr17= "";
String lblErr18= "";
String lblErr19= "";
String lblErr20= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_discouic_rilievi_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='pg_discouic_rilievi_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_discouic_rilievi_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_discouic_rilievi','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='pg_discouic_rilievi_page' style='display:block'>
<a id='<%=idPortlet%>_Image_import_correzioni' class='image-default Image_import_correzioni_ctrl'   target=''>&#xebe5;</a>
<a id='<%=idPortlet%>_Image_upload' class='image-default Image_upload_ctrl'   target=''>&#xe9da;</a>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<span id='<%=idPortlet%>_lblDatiRilievi'  formid='<%=idPortlet%>' ps-name='lblDatiRilievi'    class='label lblDatiRilievi_ctrl'><div id='<%=idPortlet%>_lblDatiRilievitbl' style='width:100%;'><%=JSPLib.ToHTML("Upload File Rilievi")%></div></span>
<span id='<%=idPortlet%>_label1_nome_file'  formid='<%=idPortlet%>' ps-name='label1_nome_file'    class='label label1_nome_file_ctrl'><div id='<%=idPortlet%>_label1_nome_filetbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<div id='<%=idPortlet%>_Grid86' formid='<%=idPortlet%>' ps-name='Grid86'   class='grid' style=''>&nbsp;</div>
</div>
<div id='<%=idPortlet%>_page_2' class='pg_discouic_rilievi_page' style='display:none'>
<span id='<%=idPortlet%>_Label1'  formid='<%=idPortlet%>' ps-name='Label1'    class='label Label1_ctrl'><div id='<%=idPortlet%>_Label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Anno:")%></div></span>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<select id='<%=idPortlet%>_Combobox_anno' name='Combobox_anno' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label4'  formid='<%=idPortlet%>' ps-name='Label4'    class='label Label4_ctrl'><div id='<%=idPortlet%>_Label4tbl' style='width:100%;'><%=JSPLib.ToHTML("Mese:")%></div></span>
<select id='<%=idPortlet%>_Combobox_mese' name='Combobox_mese' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label_dates'  formid='<%=idPortlet%>' ps-name='Label_dates'    class='label Label_dates_ctrl'><div id='<%=idPortlet%>_Label_datestbl' style='width:100%;'></div></span>
<span class='textbox-container'id='<%=idPortlet%>_causale_aggregata_wrp'><input id='<%=idPortlet%>_causale_aggregata' name='causale_aggregata' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='causale_aggregata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_cod_interno_dipe_wrp'><input id='<%=idPortlet%>_cod_interno_dipe' name='cod_interno_dipe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='cod_interno_dipe' /></span>
<span id='<%=idPortlet%>_Label7_Copy'  formid='<%=idPortlet%>' ps-name='Label7_Copy'    class='label Label7_Copy_ctrl'><div id='<%=idPortlet%>_Label7_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Codice segnalante")%></div></span>
<span id='<%=idPortlet%>_Label0'  formid='<%=idPortlet%>' ps-name='Label0'    class='label Label0_ctrl'><div id='<%=idPortlet%>_Label0tbl' style='width:100%;'><%=JSPLib.ToHTML("PERIODO ESTRAZIONE OPERAZIONI")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_CAB_dipe_wrp'><input id='<%=idPortlet%>_CAB_dipe' name='CAB_dipe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='CAB_dipe' /></span>
<span id='<%=idPortlet%>_Label9_Copy'  formid='<%=idPortlet%>' ps-name='Label9_Copy'    class='label Label9_Copy_ctrl'><div id='<%=idPortlet%>_Label9_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("CAB intermediario della controparte")%></div></span>
<span id='<%=idPortlet%>_Label11_Copy'  formid='<%=idPortlet%>' ps-name='Label11_Copy'    class='label Label11_Copy_ctrl'><div id='<%=idPortlet%>_Label11_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("CAB comune di residenza del cliente")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_tb_data_riferimento_wrp'><input id='<%=idPortlet%>_tb_data_riferimento' name='tb_data_riferimento' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='tb_data_riferimento' /></span>
<span class='textbox-container'id='<%=idPortlet%>_cod_paese_controp_wrp'><input id='<%=idPortlet%>_cod_paese_controp' name='cod_paese_controp' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='cod_paese_controp' /></span>
<span id='<%=idPortlet%>_Label12'  formid='<%=idPortlet%>' ps-name='Label12'    class='label Label12_ctrl'><div id='<%=idPortlet%>_Label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice paese di residenza del cliente")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_tipo_segnalante_wrp'><input id='<%=idPortlet%>_tipo_segnalante' name='tipo_segnalante' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='tipo_segnalante' /></span>
<span id='<%=idPortlet%>_Label19'  formid='<%=idPortlet%>' ps-name='Label19'    class='label Label19_ctrl'><div id='<%=idPortlet%>_Label19tbl' style='width:100%;'><%=JSPLib.ToHTML("Importo totale di cui contanti")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom54'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_dipe'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_tb_codice_segn_wrp'><input id='<%=idPortlet%>_tb_codice_segn' name='tb_codice_segn' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='tb_codice_segn' /></span>
<span class='textbox-container'id='<%=idPortlet%>_CAB_int_controp_wrp'><input id='<%=idPortlet%>_CAB_int_controp' name='CAB_int_controp' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='CAB_int_controp' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom62'" ) );%>
<span id='<%=idPortlet%>_Label15'  formid='<%=idPortlet%>' ps-name='Label15'    class='label Label15_ctrl'><div id='<%=idPortlet%>_Label15tbl' style='width:100%;'><%=JSPLib.ToHTML("Segno monetario")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_tipo_sgn'" ) );%>
<span id='<%=idPortlet%>_Label18_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label18_Copy_Copy'    class='label Label18_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label18_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Numero totale operazioni")%></div></span>
<span id='<%=idPortlet%>_Label_descri_causale_aggregata'  formid='<%=idPortlet%>' ps-name='Label_descri_causale_aggregata'    class='label Label_descri_causale_aggregata_ctrl'><div id='<%=idPortlet%>_Label_descri_causale_aggregatatbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label_descri_cod_interno_dipe'  formid='<%=idPortlet%>' ps-name='Label_descri_cod_interno_dipe'    class='label Label_descri_cod_interno_dipe_ctrl'><div id='<%=idPortlet%>_Label_descri_cod_interno_dipetbl' style='width:100%;'></div></span>
<select id='<%=idPortlet%>_Combobox_valuta' name='Combobox_valuta' class='combobox' style=''></select>
<span class='textbox-container'id='<%=idPortlet%>_CAB_controparte_wrp'><input id='<%=idPortlet%>_CAB_controparte' name='CAB_controparte' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='CAB_controparte' /></span>
<span id='<%=idPortlet%>_Label9_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label9_Copy_Copy'    class='label Label9_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label9_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("CAB della controparte")%></div></span>
<span id='<%=idPortlet%>_Label8'  formid='<%=idPortlet%>' ps-name='Label8'    class='label Label8_ctrl'><div id='<%=idPortlet%>_Label8tbl' style='width:100%;'><%=JSPLib.ToHTML("Data di riferimento")%></div></span>
<span id='<%=idPortlet%>_Label17'  formid='<%=idPortlet%>' ps-name='Label17'    class='label Label17_ctrl'><div id='<%=idPortlet%>_Label17tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice paese della controparte")%></div></span>
<span id='<%=idPortlet%>_Label_descri_cod_paese_controp'  formid='<%=idPortlet%>' ps-name='Label_descri_cod_paese_controp'    class='label Label_descri_cod_paese_controp_ctrl'><div id='<%=idPortlet%>_Label_descri_cod_paese_controptbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label16'  formid='<%=idPortlet%>' ps-name='Label16'    class='label Label16_ctrl'><div id='<%=idPortlet%>_Label16tbl' style='width:100%;'><%=JSPLib.ToHTML("Settorizzazione sintetica economica")%></div></span>
<span id='<%=idPortlet%>_Label_descri_tipo_sgn'  formid='<%=idPortlet%>' ps-name='Label_descri_tipo_sgn'    class='label Label_descri_tipo_sgn_ctrl'><div id='<%=idPortlet%>_Label_descri_tipo_sgntbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label18_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label18_Copy_Copy_Copy'    class='label Label18_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label18_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Numero totale operazioni di cui in contanti")%></div></span>
<span id='<%=idPortlet%>_Label11_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label11_Copy_Copy'    class='label Label11_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label11_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("ABI+CAB della dipendenza")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_cod_paese_int_controp_wrp'><input id='<%=idPortlet%>_cod_paese_int_controp' name='cod_paese_int_controp' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='cod_paese_int_controp' /></span>
<span class='textbox-container'id='<%=idPortlet%>_importo_tot_wrp'><input id='<%=idPortlet%>_importo_tot' name='importo_tot' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='importo_tot' data-sp-item-say-pict='999,999,999,999' data-sp-item-get-pict='999,999,999,999' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_Label10'  formid='<%=idPortlet%>' ps-name='Label10'    class='label Label10_ctrl'><div id='<%=idPortlet%>_Label10tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice interno della dipendenza")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ABICAB_dipe_wrp'><input id='<%=idPortlet%>_ABICAB_dipe' name='ABICAB_dipe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ABICAB_dipe' /></span>
<span id='<%=idPortlet%>_Label11'  formid='<%=idPortlet%>' ps-name='Label11'    class='label Label11_ctrl'><div id='<%=idPortlet%>_Label11tbl' style='width:100%;'><%=JSPLib.ToHTML("CAB comune della dipendenza")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_CAB_residenza_cli_wrp'><input id='<%=idPortlet%>_CAB_residenza_cli' name='CAB_residenza_cli' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='CAB_residenza_cli' /></span>
<span id='<%=idPortlet%>_Label9'  formid='<%=idPortlet%>' ps-name='Label9'    class='label Label9_ctrl'><div id='<%=idPortlet%>_Label9tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice paese intermediario della controparte")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_cod_paese_residenza_cli_wrp'><input id='<%=idPortlet%>_cod_paese_residenza_cli' name='cod_paese_residenza_cli' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='cod_paese_residenza_cli' /></span>
<span id='<%=idPortlet%>_Label18'  formid='<%=idPortlet%>' ps-name='Label18'    class='label Label18_ctrl'><div id='<%=idPortlet%>_Label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Importo totale")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_importo_tot_cont_wrp'><input id='<%=idPortlet%>_importo_tot_cont' name='importo_tot_cont' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='importo_tot_cont' data-sp-item-say-pict='999,999,999,999' data-sp-item-get-pict='999,999,999,999' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_sett_sint_wrp'><input id='<%=idPortlet%>_sett_sint' name='sett_sint' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='sett_sint' /></span>
<span class='textbox-container'id='<%=idPortlet%>_num_tot_ope_wrp'><input id='<%=idPortlet%>_num_tot_ope' name='num_tot_ope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='num_tot_ope' data-sp-item-say-pict='999,999,999' data-sp-item-get-pict='999,999,999' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_Label6'  formid='<%=idPortlet%>' ps-name='Label6'    class='label Label6_ctrl'><div id='<%=idPortlet%>_Label6tbl' style='width:100%;'><%=JSPLib.ToHTML("DATI AGGREGATI DA RILIEVI")%></div></span>
<span id='<%=idPortlet%>_Label14'  formid='<%=idPortlet%>' ps-name='Label14'    class='label Label14_ctrl'><div id='<%=idPortlet%>_Label14tbl' style='width:100%;'><%=JSPLib.ToHTML("Valuta della segnalazione")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom48'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_num_tot_ope_cont_wrp'><input id='<%=idPortlet%>_num_tot_ope_cont' name='num_tot_ope_cont' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='num_tot_ope_cont' data-sp-item-say-pict='999,999,999' data-sp-item-get-pict='999,999,999' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_Label_descr_cod_paese_res_cli'  formid='<%=idPortlet%>' ps-name='Label_descr_cod_paese_res_cli'    class='label Label_descr_cod_paese_res_cli_ctrl'><div id='<%=idPortlet%>_Label_descr_cod_paese_res_clitbl' style='width:100%;'></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_cod_paese_contr'" ) );%>
<span id='<%=idPortlet%>_Label_descri_cod_paese_int_controp'  formid='<%=idPortlet%>' ps-name='Label_descri_cod_paese_int_controp'    class='label Label_descri_cod_paese_int_controp_ctrl'><div id='<%=idPortlet%>_Label_descri_cod_paese_int_controptbl' style='width:100%;'></div></span>
<select id='<%=idPortlet%>_Combobox_segno' name='Combobox_segno' class='combobox' style=''></select>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom59'" ) );%>
<span id='<%=idPortlet%>_Label_desc_sett_sint'  formid='<%=idPortlet%>' ps-name='Label_desc_sett_sint'    class='label Label_desc_sett_sint_ctrl'><div id='<%=idPortlet%>_Label_desc_sett_sinttbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label7'  formid='<%=idPortlet%>' ps-name='Label7'    class='label Label7_ctrl'><div id='<%=idPortlet%>_Label7tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo segnalante")%></div></span>
<span id='<%=idPortlet%>_LabelVAR'  formid='<%=idPortlet%>' ps-name='LabelVAR'    class='label LabelVAR_ctrl'><div id='<%=idPortlet%>_LabelVARtbl' style='width:100%;'><%=JSPLib.ToHTML("VARIABILE")%></div></span>
<span id='<%=idPortlet%>_Label23'  formid='<%=idPortlet%>' ps-name='Label23'    class='label Label23_ctrl'><div id='<%=idPortlet%>_Label23tbl' style='width:100%;'><%=JSPLib.ToHTML("VALORE")%></div></span>
<select id='<%=idPortlet%>_Combobox_tipo_ope' name='Combobox_tipo_ope' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label43'  formid='<%=idPortlet%>' ps-name='Label43'    class='label Label43_ctrl'><div id='<%=idPortlet%>_Label43tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Operazione:")%></div></span>
<span id='<%=idPortlet%>_Label13'  formid='<%=idPortlet%>' ps-name='Label13'    class='label Label13_ctrl'><div id='<%=idPortlet%>_Label13tbl' style='width:100%;'><%=JSPLib.ToHTML("Causale aggregata")%></div></span>
<span id='<%=idPortlet%>_lblErr01'  formid='<%=idPortlet%>' ps-name='lblErr01'    class='label lblErr01_ctrl'><div id='<%=idPortlet%>_lblErr01tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr02'  formid='<%=idPortlet%>' ps-name='lblErr02'    class='label lblErr02_ctrl'><div id='<%=idPortlet%>_lblErr02tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr03'  formid='<%=idPortlet%>' ps-name='lblErr03'    class='label lblErr03_ctrl'><div id='<%=idPortlet%>_lblErr03tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr04'  formid='<%=idPortlet%>' ps-name='lblErr04'    class='label lblErr04_ctrl'><div id='<%=idPortlet%>_lblErr04tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr11'  formid='<%=idPortlet%>' ps-name='lblErr11'    class='label lblErr11_ctrl'><div id='<%=idPortlet%>_lblErr11tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr10'  formid='<%=idPortlet%>' ps-name='lblErr10'    class='label lblErr10_ctrl'><div id='<%=idPortlet%>_lblErr10tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr09'  formid='<%=idPortlet%>' ps-name='lblErr09'    class='label lblErr09_ctrl'><div id='<%=idPortlet%>_lblErr09tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr08'  formid='<%=idPortlet%>' ps-name='lblErr08'    class='label lblErr08_ctrl'><div id='<%=idPortlet%>_lblErr08tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr07'  formid='<%=idPortlet%>' ps-name='lblErr07'    class='label lblErr07_ctrl'><div id='<%=idPortlet%>_lblErr07tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr06'  formid='<%=idPortlet%>' ps-name='lblErr06'    class='label lblErr06_ctrl'><div id='<%=idPortlet%>_lblErr06tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr05'  formid='<%=idPortlet%>' ps-name='lblErr05'    class='label lblErr05_ctrl'><div id='<%=idPortlet%>_lblErr05tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr12'  formid='<%=idPortlet%>' ps-name='lblErr12'    class='label lblErr12_ctrl'><div id='<%=idPortlet%>_lblErr12tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr13'  formid='<%=idPortlet%>' ps-name='lblErr13'    class='label lblErr13_ctrl'><div id='<%=idPortlet%>_lblErr13tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr14'  formid='<%=idPortlet%>' ps-name='lblErr14'    class='label lblErr14_ctrl'><div id='<%=idPortlet%>_lblErr14tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr15'  formid='<%=idPortlet%>' ps-name='lblErr15'    class='label lblErr15_ctrl'><div id='<%=idPortlet%>_lblErr15tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr16'  formid='<%=idPortlet%>' ps-name='lblErr16'    class='label lblErr16_ctrl'><div id='<%=idPortlet%>_lblErr16tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr17'  formid='<%=idPortlet%>' ps-name='lblErr17'    class='label lblErr17_ctrl'><div id='<%=idPortlet%>_lblErr17tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr18'  formid='<%=idPortlet%>' ps-name='lblErr18'    class='label lblErr18_ctrl'><div id='<%=idPortlet%>_lblErr18tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr19'  formid='<%=idPortlet%>' ps-name='lblErr19'    class='label lblErr19_ctrl'><div id='<%=idPortlet%>_lblErr19tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblErr20'  formid='<%=idPortlet%>' ps-name='lblErr20'    class='label lblErr20_ctrl'><div id='<%=idPortlet%>_lblErr20tbl' style='width:100%;'></div></span>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_discouic_rilievi');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Genera stampa della verifica dei rilievi S.AR.A",true)+","+JSPLib.ToJSValue(sp.translate("Genera stampa della verifica dei rilievi S.AR.A"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Verifica Rilievi ",true)+","+JSPLib.ToJSValue(sp.translate("Verifica Rilievi "),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/pg_discouic_rilievi_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Import elenco errori"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Ricerca Rilievo"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_discouic_rilievi',["1024","1024"],["780","780"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"780","title":"Import elenco errori","layer":""},{"layout_steps_values":{},"w":"1024","h":"780","title":"Ricerca Rilievo","layer":""}]);
this.Label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label1","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label1,false,true)%>","type":"Label","w":81,"x":128,"y":39,"zindex":"2"});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":2,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":1024,"x":0,"y":700,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":120,"x":1070,"y":26});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.V_descri_cod_paese_res_cli=new ZtVWeb._VC(this,'V_descri_cod_paese_res_cli',null,'character','<%=JSPLib.ToJSValue(V_descri_cod_paese_res_cli,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":120,"x":1070,"y":93});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.Image_import_correzioni=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default Image_import_correzioni_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_import_correzioni","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebe5;","font_image_hover":"&#xebe6;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Elabora il file con i rilievi",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_import_correzioni","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebe5;","srchover":"&#xebe6;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":762,"y":42,"zindex":"34"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Combobox_anno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_anno","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_anno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_anno","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":92,"x":214,"y":39,"zindex":"3"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna(evt)","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":120,"x":1070,"y":49});
this.V_descri_cod_paese_int_contr=new ZtVWeb._VC(this,'V_descri_cod_paese_int_contr',null,'character','<%=JSPLib.ToJSValue(V_descri_cod_paese_int_contr,false,true)%>',false,false);
this.Image_upload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default Image_upload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_upload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Carica il file Excel delle correzioni",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_upload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":42,"zindex":"27"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label4=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label4","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label4,false,true)%>","type":"Label","w":44,"x":312,"y":39,"zindex":"4"});
this.V_descri_causale_aggregata=new ZtVWeb._VC(this,'V_descri_causale_aggregata',null,'character','<%=JSPLib.ToJSValue(V_descri_causale_aggregata,false,true)%>',false,false);
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":565,"x":150,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.Combobox_mese=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_mese","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_mese%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_mese","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":92,"x":359,"y":39,"zindex":"5"});
this.V_descri_sett_sint=new ZtVWeb._VC(this,'V_descri_sett_sint',null,'character','<%=JSPLib.ToJSValue(V_descri_sett_sint,false,true)%>',false,false);
this.lblDatiRilievi=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDatiRilievi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDatiRilievi","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDatiRilievi,false,true)%>","type":"Label","w":200,"x":14,"y":26,"zindex":"19"});
this.Label_dates=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_dates","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_dates","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_dates,false,true)%>","type":"Label","w":151,"x":456,"y":39,"zindex":"40"});
this.V_descri_cod_paese_controp=new ZtVWeb._VC(this,'V_descri_cod_paese_controp',null,'character','<%=JSPLib.ToJSValue(V_descri_cod_paese_controp,false,true)%>',false,false);
this.causale_aggregata=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_causale_aggregata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CAUSALE_AGGREGATA","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"causale_aggregata","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(causale_aggregata,false,true)%>","w":275,"x":284,"y":198,"zerofilling":false,"zindex":"12","zoom":""});
this.gIntemediario=new ZtVWeb._VC(this,'gIntemediario',null,'character','<%=JSPLib.ToJSValue(gIntemediario,false,true)%>',false,false);
this.cod_interno_dipe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cod_interno_dipe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CODICE_INTERNO_DIP","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"cod_interno_dipe","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cod_interno_dipe,false,true)%>","w":275,"x":284,"y":223,"zerofilling":false,"zindex":"12","zoom":""});
this.gTipInter=new ZtVWeb._VC(this,'gTipInter',null,'character','<%=JSPLib.ToJSValue(gTipInter,false,true)%>',false,false);
this.Label7_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label7_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label7_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label7_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":273,"zindex":"7"});
this.V_descri_tipo_sgn=new ZtVWeb._VC(this,'V_descri_tipo_sgn',null,'character','<%=JSPLib.ToJSValue(V_descri_tipo_sgn,false,true)%>',false,false);
this.Label0=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label0","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label0","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label0,false,true)%>","type":"Label","w":241,"x":27,"y":9,"zindex":"1"});
this.CAB_dipe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_CAB_dipe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"COMUNE_DIP","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"CAB_dipe","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(CAB_dipe,false,true)%>","w":275,"x":284,"y":323,"zerofilling":false,"zindex":"12","zoom":""});
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_discouic_rilievi_pg",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":2,"parms":"w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_rcoddip=cod_interno_dipe,w_rabicab=ABICAB_dipe,w_rcabdip=CAB_dipe,w_rpaecli=cod_paese_residenza_cli,w_rcabcli=CAB_residenza_cli,w_rcodvoc=causale_aggregata,w_rflglire=Combobox_valuta,w_rsegno=Combobox_segno,w_rsetsin=sett_sint,w_rpaecon=cod_paese_controp,w_rcabcon=CAB_controparte,w_rpaeint=cod_paese_int_controp,w_rcabint=CAB_int_controp,w_TipoOper=Combobox_tipo_ope","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_discouic_rilievi_pg","target":"","type":"SPLinker","w":150,"x":1049,"y":218});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_discouic_rilievi_pg",request.getSession())%>';
this.Label9_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label9_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label9_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label9_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":348,"zindex":"7"});
this.DaDatOpe=new ZtVWeb._VC(this,'DaDatOpe',null,'date','<%=DaDatOpe%>',false,false);
this.Label11_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label11_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label11_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label11_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":398,"zindex":"7"});
this.ADatOpe=new ZtVWeb._VC(this,'ADatOpe',null,'date','<%=ADatOpe%>',false,false);
this.tb_data_riferimento=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tb_data_riferimento","decrypt":false,"edit_undercond":"","encrypt":false,"field":"DATA_RIFERIMENTO","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"tb_data_riferimento","page":2,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=tb_data_riferimento%>","w":275,"x":284,"y":423,"zerofilling":false,"zindex":"11","zoom":""});
this.rabicab=new ZtVWeb._VC(this,'rabicab',null,'character','<%=JSPLib.ToJSValue(rabicab,false,true)%>',false,false);
this.cod_paese_controp=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cod_paese_controp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"PAESE_CONTROPARTE","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"cod_paese_controp","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cod_paese_controp,false,true)%>","w":275,"x":284,"y":448,"zerofilling":false,"zindex":"12","zoom":""});
this.Label12=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label12","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label12,false,true)%>","type":"Label","w":255,"x":19,"y":498,"zindex":"7"});
this.label1_nome_file=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1_nome_file","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1_nome_file","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1_nome_file,false,true)%>","type":"Label","w":129,"x":19,"y":51,"zindex":"1"});
this.tipo_segnalante=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tipo_segnalante","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TIPO_SEGNALANTE","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"tipo_segnalante","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tipo_segnalante,false,true)%>","w":275,"x":284,"y":573,"zerofilling":false,"zindex":"11","zoom":""});
this.Label19=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label19","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label19","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label19,false,true)%>","type":"Label","w":255,"x":19,"y":623,"zindex":"8"});
this.LinkZoom54=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom54","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"causale_aggregata,V_descri_causale_aggregata","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom54",request.getSession())%>","linkedField":"causale_aggregata","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom54","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"CODVOC,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbcausin,default",request.getSession())%>","suggest":false,"table":"tbcausin","type":"LinkZoom","w":20,"x":562,"y":198,"zindex":"26","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.LinkZoom_dipe=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_dipe","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"cod_interno_dipe,V_descri_cod_dipe,CAB_dipe,ABICAB_dipe","intovarsType":"C,C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom_dipe",request.getSession())%>","linkedField":"cod_interno_dipe","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom_dipe","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,CAB,ABICABSARA","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":562,"y":224,"zindex":"17","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.tb_codice_segn=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tb_codice_segn","decrypt":false,"edit_undercond":"","encrypt":false,"field":"CODICE_SEGNALANTE","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"tb_codice_segn","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tb_codice_segn,false,true)%>","w":275,"x":284,"y":273,"zerofilling":false,"zindex":"15","zoom":""});
this.CAB_int_controp=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_CAB_int_controp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"COMUNE_INTERM_CTRP","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"CAB_int_controp","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(CAB_int_controp,false,true)%>","w":275,"x":284,"y":348,"zerofilling":false,"zindex":"12","zoom":""});
this.LinkZoom62=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom62","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"cod_paese_controp,V_descri_cod_paese_controp","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom62",request.getSession())%>","linkedField":"cod_paese_controp","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom62","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbstati,default",request.getSession())%>","suggest":false,"table":"tbstati","type":"LinkZoom","w":20,"x":562,"y":448,"zindex":"34","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Label15=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label15","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label15","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label15,false,true)%>","type":"Label","w":255,"x":19,"y":523,"zindex":"8"});
this.LinkZoom_tipo_sgn=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_tipo_sgn","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"tipo_segnalante,V_descri_tipo_sgn","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom_tipo_sgn",request.getSession())%>","linkedField":"tipo_segnalante","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom_tipo_sgn","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"TIPOINT,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbtipint,default",request.getSession())%>","suggest":false,"table":"tbtipint","type":"LinkZoom","w":20,"x":562,"y":573,"zindex":"41","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Label18_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18_Copy_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label18_Copy_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":648,"zindex":"8"});
this.Label_descri_causale_aggregata=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_descri_causale_aggregata","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_descri_causale_aggregata","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_descri_causale_aggregata,false,true)%>","type":"Label","w":238,"x":586,"y":198,"zindex":"27"});
this.Label_descri_cod_interno_dipe=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_descri_cod_interno_dipe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3701FF","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_descri_cod_interno_dipe","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_descri_cod_interno_dipe,false,true)%>","type":"Label","w":238,"x":586,"y":224,"zindex":"18"});
this.Combobox_valuta=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_valuta","dataobj_value":"SQLRilievi","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"CODICE_VALUTA","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_valuta%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_valuta","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Euro(3),Valuta(4)","type":"Combobox","typevar":"character","valuelist":"3,4","visible":true,"w":275,"x":284,"y":298,"zindex":"30"});
this.CAB_controparte=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_CAB_controparte","decrypt":false,"edit_undercond":"","encrypt":false,"field":"COMUNE_CONTROPARTE","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"CAB_controparte","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(CAB_controparte,false,true)%>","w":275,"x":284,"y":373,"zerofilling":false,"zindex":"12","zoom":""});
this.Label9_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label9_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label9_Copy_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label9_Copy_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":373,"zindex":"7"});
this.Label8=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label8","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label8","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label8,false,true)%>","type":"Label","w":255,"x":19,"y":423,"zindex":"7"});
this.Label17=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label17","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label17","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label17,false,true)%>","type":"Label","w":255,"x":19,"y":448,"zindex":"8"});
this.Label_descri_cod_paese_controp=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_descri_cod_paese_controp","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_descri_cod_paese_controp","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_descri_cod_paese_controp,false,true)%>","type":"Label","w":238,"x":586,"y":448,"zindex":"35"});
this.Label16=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label16","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label16","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label16,false,true)%>","type":"Label","w":255,"x":19,"y":548,"zindex":"8"});
this.Label_descri_tipo_sgn=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_descri_tipo_sgn","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_descri_tipo_sgn","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_descri_tipo_sgn,false,true)%>","type":"Label","w":238,"x":586,"y":573,"zindex":"42"});
this.Label18_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18_Copy_Copy_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label18_Copy_Copy_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":673,"zindex":"8"});
this.Label11_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label11_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label11_Copy_Copy","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label11_Copy_Copy,false,true)%>","type":"Label","w":255,"x":19,"y":248,"zindex":"7"});
this.cod_paese_int_controp=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cod_paese_int_controp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"PAESE_INTERM_CTRP","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"cod_paese_int_controp","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cod_paese_int_controp,false,true)%>","w":275,"x":284,"y":473,"zerofilling":false,"zindex":"12","zoom":""});
this.importo_tot=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_importo_tot","decrypt":false,"edit_undercond":"","encrypt":false,"field":"IMPORTO_TOT","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"importo_tot","page":2,"picker":"","picture":"999,999,999,999","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=importo_tot%>","w":275,"x":284,"y":598,"zerofilling":false,"zindex":"12","zoom":""});
this.Label10=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label10","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label10","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label10,false,true)%>","type":"Label","w":255,"x":19,"y":223,"zindex":"7"});
this.ABICAB_dipe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ABICAB_dipe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"ABICAB_SPORTELLO","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ABICAB_dipe","page":2,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ABICAB_dipe,false,true)%>","w":275,"x":284,"y":248,"zerofilling":false,"zindex":"12","zoom":""});
this.Label11=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label11","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label11","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label11,false,true)%>","type":"Label","w":255,"x":19,"y":323,"zindex":"7"});
this.CAB_residenza_cli=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_CAB_residenza_cli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"COMUNE_RES_CLIENTE","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"CAB_residenza_cli","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(CAB_residenza_cli,false,true)%>","w":275,"x":284,"y":398,"zerofilling":false,"zindex":"12","zoom":""});
this.Label9=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label9","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label9","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label9,false,true)%>","type":"Label","w":255,"x":19,"y":473,"zindex":"7"});
this.cod_paese_residenza_cli=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cod_paese_residenza_cli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"PAESE_RES_CLIENTE","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"cod_paese_residenza_cli","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cod_paese_residenza_cli,false,true)%>","w":275,"x":284,"y":498,"zerofilling":false,"zindex":"12","zoom":""});
this.Label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label18,false,true)%>","type":"Label","w":255,"x":19,"y":598,"zindex":"8"});
this.importo_tot_cont=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_importo_tot_cont","decrypt":false,"edit_undercond":"","encrypt":false,"field":"IMPORTO_TOT_CONTANTI","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"importo_tot_cont","page":2,"picker":"","picture":"999,999,999,999","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=importo_tot_cont%>","w":275,"x":284,"y":623,"zerofilling":false,"zindex":"12","zoom":""});
this.sett_sint=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sett_sint","decrypt":false,"edit_undercond":"","encrypt":false,"field":"SETTORIZ_SINT_ECON","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"sett_sint","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sett_sint,false,true)%>","w":275,"x":284,"y":548,"zerofilling":false,"zindex":"12","zoom":""});
this.num_tot_ope=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_num_tot_ope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"NUMERO_TOT_OPER","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"num_tot_ope","page":2,"picker":"","picture":"999,999,999","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=num_tot_ope%>","w":275,"x":284,"y":648,"zerofilling":false,"zindex":"12","zoom":""});
this.Label6=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6,false,true)%>","type":"Label","w":241,"x":27,"y":85,"zindex":"6"});
this.Label14=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14,false,true)%>","type":"Label","w":255,"x":19,"y":298,"zindex":"8"});
this.LinkZoom48=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom48","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"cod_paese_residenza_cli,V_descri_cod_paese_res_cli","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom48",request.getSession())%>","linkedField":"cod_paese_residenza_cli","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom48","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbstati,default",request.getSession())%>","suggest":false,"table":"tbstati","type":"LinkZoom","w":20,"x":562,"y":498,"zindex":"20","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.num_tot_ope_cont=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_num_tot_ope_cont","decrypt":false,"edit_undercond":"","encrypt":false,"field":"NUMERO_OPER_CONT","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"num_tot_ope_cont","page":2,"picker":"","picture":"999,999,999","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=num_tot_ope_cont%>","w":275,"x":284,"y":673,"zerofilling":false,"zindex":"12","zoom":""});
this.Label_descr_cod_paese_res_cli=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_descr_cod_paese_res_cli","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3803FD","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_descr_cod_paese_res_cli","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_descr_cod_paese_res_cli,false,true)%>","type":"Label","w":238,"x":586,"y":498,"zindex":"21"});
this.LinkZoom_cod_paese_contr=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_cod_paese_contr","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"cod_paese_int_controp,V_descri_cod_paese_int_contr","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom_cod_paese_contr",request.getSession())%>","linkedField":"cod_paese_int_controp","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom_cod_paese_contr","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbstati,default",request.getSession())%>","suggest":false,"table":"tbstati","type":"LinkZoom","w":20,"x":562,"y":473,"zindex":"23","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Label_descri_cod_paese_int_controp=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_descri_cod_paese_int_controp","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3701FF","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_descri_cod_paese_int_controp","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_descri_cod_paese_int_controp,false,true)%>","type":"Label","w":238,"x":586,"y":473,"zindex":"24"});
this.Combobox_segno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_segno","dataobj_value":"SQLRilievi","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"SEGNO_MONETARIO","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_segno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_segno","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Dare (D),Avere(A)","type":"Combobox","typevar":"character","valuelist":"D,A","visible":true,"w":275,"x":284,"y":523,"zindex":"29"});
this.LinkZoom59=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom59","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_discouic_rilievi_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"sett_sint,V_descri_sett_sint","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_discouic_rilievi_portlet.jspLinkZoom59",request.getSession())%>","linkedField":"sett_sint","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom59","offline":false,"openZoomOnMultipleRecord":true,"page":2,"path_type":"","queryparms":"","readfields":"SETSINT,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbsetsin,default",request.getSession())%>","suggest":false,"table":"tbsetsin","type":"LinkZoom","w":20,"x":562,"y":548,"zindex":"31","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Label_desc_sett_sint=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_desc_sett_sint","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#3600FF","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_desc_sett_sint","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_desc_sett_sint,false,true)%>","type":"Label","w":238,"x":586,"y":548,"zindex":"32"});
this.Label7=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label7","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label7","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label7,false,true)%>","type":"Label","w":255,"x":19,"y":573,"zindex":"7"});
this.LabelVAR=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelVAR","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelVAR","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelVAR,false,true)%>","type":"Label","w":255,"x":19,"y":173,"zindex":"9"});
this.Label23=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label23","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label23","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label23,false,true)%>","type":"Label","w":275,"x":284,"y":173,"zindex":"10"});
this.Combobox_tipo_ope=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_tipo_ope","dataobj_value":"SQLRilievi","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"TIPOLOGIA","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_tipo_ope%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_tipo_ope","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"SARA_BONIFICIALTRIITALIA,SARA_BONIFICIALTRIESTERI,SARA_ALTREOPERAZIONIALTRI,SARA_BONIFICIBANCHE,SARA_BONIFICIESTERI,SARA_ALTREOPERAZIONI","type":"Combobox","typevar":"character","valuelist":"SARA_BONIFICIALTRIITALIA,SARA_BONIFICIALTRIESTERI,SARA_ALTREOPERAZIONIALTRI,SARA_BONIFICIBANCHE,SARA_BONIFICIESTERI,SARA_ALTREOPERAZIONI","visible":true,"w":235,"x":252,"y":122,"zindex":"13"});
this.Label43=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label43","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label43","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label43,false,true)%>","type":"Label","w":118,"x":128,"y":122,"zindex":"14"});
this.Label13=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label13","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label13","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label13,false,true)%>","type":"Label","w":255,"x":19,"y":198,"zindex":"8"});
this.V_descri_cod_dipe=new ZtVWeb._VC(this,'V_descri_cod_dipe',null,'character','<%=JSPLib.ToJSValue(V_descri_cod_dipe,false,true)%>',false,false);
this.Grid86=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid86","dataobj":"SQLRilievi","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":504,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid86","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":93,"zindex":"43"});
this.Grid86.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID Rilievo","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"ID","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Motivazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"MOTIVO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipologia","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TIPOLOGIA","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.RTRilievi=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_readxml_rilievi",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRilievi","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRilievi","offline":false,"page":1,"parms":"pFile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_readxml_rilievi","target":"","type":"SPLinker","w":120,"x":1071,"y":142});
this.RTRilievi.m_cID='<%=JSPLib.cmdHash("routine,arfn_readxml_rilievi",request.getSession())%>';
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.SQLRilievi=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("rows:arfn_readxml_rilievi",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"rows:arfn_readxml_rilievi","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_readxml_rilievi",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLRilievi","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLRilievi","nrows":"300","page":1,"parms":"pFile=nomefile","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":1074,"y":-87});
this.lblErr01=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr01","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"CAUSALE_AGGREGATA_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr01","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"false","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr01,false,true)%>","type":"Label","w":163,"x":845,"y":198,"zindex":"44"});
this.lblErr02=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr02","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"CODICE_INTERNO_DIP_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr02","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr02,false,true)%>","type":"Label","w":163,"x":845,"y":223,"zindex":"44"});
this.lblErr03=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr03","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"ABICAB_SPORTELLO_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr03","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr03,false,true)%>","type":"Label","w":163,"x":845,"y":248,"zindex":"44"});
this.lblErr04=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr04","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"ABICAB_SPORTELLO_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr04","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr04,false,true)%>","type":"Label","w":163,"x":845,"y":273,"zindex":"44"});
this.lblErr11=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr11","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"PAESE_CONTROPARTE_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr11","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr11,false,true)%>","type":"Label","w":163,"x":845,"y":448,"zindex":"44"});
this.lblErr10=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr10","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"DATA_RIFERIMENTO_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr10","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr10,false,true)%>","type":"Label","w":163,"x":845,"y":423,"zindex":"44"});
this.lblErr09=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr09","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"COMUNE_RES_CLIENTE_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr09","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"false","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr09,false,true)%>","type":"Label","w":163,"x":845,"y":398,"zindex":"44"});
this.lblErr08=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr08","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"COMUNE_CONTROPARTE_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr08","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr08,false,true)%>","type":"Label","w":163,"x":845,"y":373,"zindex":"44"});
this.lblErr07=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr07","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"COMUNE_INTERM_CTRP_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr07","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr07,false,true)%>","type":"Label","w":163,"x":845,"y":348,"zindex":"44"});
this.lblErr06=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr06","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"COMUNE_DIP_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr06","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr06,false,true)%>","type":"Label","w":163,"x":845,"y":323,"zindex":"44"});
this.lblErr05=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr05","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"CODICE_VALUTA_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr05","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr05,false,true)%>","type":"Label","w":163,"x":845,"y":298,"zindex":"44"});
this.lblErr12=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"PAESE_INTERM_CTRP_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr12","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr12,false,true)%>","type":"Label","w":163,"x":845,"y":473,"zindex":"44"});
this.lblErr13=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr13","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"PAESE_RES_CLIENTE_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr13","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr13,false,true)%>","type":"Label","w":163,"x":845,"y":498,"zindex":"44"});
this.lblErr14=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr14","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"SEGNO_MONETARIO_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr14","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr14,false,true)%>","type":"Label","w":163,"x":845,"y":523,"zindex":"44"});
this.lblErr15=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr15","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"SETTORIZ_SINT_ECON_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr15","nowrap":"true","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr15,false,true)%>","type":"Label","w":163,"x":845,"y":548,"zindex":"44"});
this.lblErr16=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr16","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"TIPO_SEGNALANTE_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr16","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr16,false,true)%>","type":"Label","w":163,"x":845,"y":573,"zindex":"44"});
this.lblErr17=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr17","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"IMPORTO_TOT_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr17","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr17,false,true)%>","type":"Label","w":163,"x":845,"y":598,"zindex":"44"});
this.lblErr18=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"IMPORTO_TOT_CONTANTI_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr18","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr18,false,true)%>","type":"Label","w":163,"x":845,"y":623,"zindex":"44"});
this.lblErr19=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr19","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"NUMERO_TOT_OPER_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr19","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr19,false,true)%>","type":"Label","w":163,"x":845,"y":648,"zindex":"44"});
this.lblErr20=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblErr20","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"NUMERO_TOT_OPER_ERR","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblErr20","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"false","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblErr20,false,true)%>","type":"Label","w":163,"x":845,"y":673,"zindex":"44"});
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
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_discouic_rilievi_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_discouic_rilievi_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_discouic_rilievi_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image_import_correzioni.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Image_upload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLRilievi.firstQuery('true');
window.<%=idPortlet%>.Combobox_anno.FillData();
window.<%=idPortlet%>.Combobox_mese.FillData();
window.<%=idPortlet%>.Combobox_valuta.FillData();
window.<%=idPortlet%>.Combobox_segno.FillData();
window.<%=idPortlet%>.Combobox_tipo_ope.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_discouic_rilievi',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_discouic_rilievi');
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
sp.endPage("pg_discouic_rilievi");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom54")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbcausin";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODVOC", "DESCRIZ"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_dipe")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ", "CAB", "ABICABSARA"};
  result.m_rdTypes = new String[]{"C", "C", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom62")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbstati";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODSTA", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_tipo_sgn")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbtipint";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"TIPOINT", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom48")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbstati";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODSTA", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_cod_paese_contr")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbstati";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODSTA", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom59")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbsetsin";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"SETSINT", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "1475137778"; } %>