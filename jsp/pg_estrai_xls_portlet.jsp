<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.mcParametri.Value(this.RTCreaMC.Link());\n  this.opesel.Value('S');\n  this.frzsel.Value('S');\n  this.flgsto.Value('S');\n  this.flgncf.Value('S');\n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE MOVIMENTI (OPERAZIONI\u002fFRAZIONATE)\",true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Batch\",\n    title:FormatMsg('Batch'),\n    tooltip:FormatMsg(\"Esegui estrazione in modalità ritardata\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe91c\"},\n    action:'javascript:' + this.formid +'.btnBatch_Click()'\n  },2);                                 \n  this.getTitlePortlet().AppendButton({\n    id:\"Real\",\n    title:FormatMsg('Esegui'),\n    tooltip:FormatMsg(\"Esegui estrazione in tempo reale\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47\"},\n    action:'javascript:' + this.formid +'.btnElab_Click()'\n  },2);\n}\n\nfunction LoadMC() {\n  this.mcParametri.Set(\"pTipo\",this.tipoelab.Value())\n  this.mcParametri.Set(\"w_dadata\",this.dadata.Value());\n  this.mcParametri.Set(\"w_adata\",this.a_data.Value());\n  this.mcParametri.Set(\"w_cdadata\",this.cdadata.Value());\n  this.mcParametri.Set(\"w_c_adata\",this.c_adata.Value());\n  this.mcParametri.Set(\"w_cDIP\",this.cDIP.Value());\n  this.mcParametri.Set(\"w_xdesdip\",this.xdesdip.Value());\n  this.mcParametri.Set(\"w_ragosc\",this.ragosc.Value());\n  this.mcParametri.Set(\"w_citnas\",this.citnas.Value());\n  this.mcParametri.Set(\"w_stanas\",this.stanas.Value());\n  this.mcParametri.Set(\"w_datnas\",this.datnas.Value());\n  this.mcParametri.Set(\"w_cMTCN\",this.cMTCN.Value());\n  this.mcParametri.Set(\"w_cCODFISC\",this.cCODFISC.Value());\n  this.mcParametri.Set(\"w_ragben\",this.ragben.Value());\n  this.mcParametri.Set(\"w_staben\",this.staben.Value());\n  this.mcParametri.Set(\"w_codmag\",this.codmag.Value());\n  this.mcParametri.Set(\"w_connes\",this.connes.Value());\n  this.mcParametri.Set(\"w_nomefile\",this.nomefile.Value());\n  this.mcParametri.Set(\"w_tipofile\",this.tipofile.Value());\n  this.mcParametri.Set(\"w_flgsto\",this.flgsto.Value());\n  this.mcParametri.Set(\"w_tipoout\",this.tipoout.Value());\n  this.mcParametri.Set(\"w_opesel\",this.opesel.Value());\n  this.mcParametri.Set(\"w_frzsel\",this.frzsel.Value());\n  this.mcParametri.Set(\"w_attive\",this.attive.Value());\n  this.mcParametri.Set(\"w_destfold\",this.destfold.Value());\n  this.mcParametri.Set(\"w_flgmese\",this.flgmese.Value());\n  this.mcParametri.Set(\"w_flgncf\",this.flgncf.Value());\n  this.mcParametri.Set(\"w_flgsegno\",this.flgsegno.Value());\n  this.mcParametri.Set(\"w_lststa\",this.lStati.Value());\n  this.mcParametri.Set(\"w_lstprv\",this.lProv.Value());\n  this.mcParametri.Set(\"w_importo\",this.importo.Value());  \n  this.mcParametri.Set(\"w_storico\",this.storico.Value());  \n}  \n\nfunction btnElab_Click(){\n  _errore=0;\n  if (this.opesel.Value()=='N' && this.frzsel.Value()=='N') {\n    _errore=1;\n    alert('Obbligatorio selezionare una fonte da cui prelevare i dati')\n  }  \n  if (Empty(this.tipoout.Value())) {\n    _errore=1;\n    alert('Obbligatorio selezionare la destinazione dei dati')\n  }  \n  if (Empty(this.flgsegno.Value())) {\n    _errore=1;\n    alert('Obbligatorio selezionare il segno delle operazioni')\n  }          \n  if (this.flgmese.Value()=='S' && (Empty(this.dadata.Value()) || Empty(this.a_data.Value()))) {\n    _errore=1;\n    alert('Creazione di un file per mese utilizzabile solo se viene selezionato un periodo')                                    \n  }    \n  if (_errore==0) {  \n    if (confirm(\"Confermi l'estrazione dei movimenti?\")) {      \n      this.PortletLogs.Start();     \n      this.CalcListe();\n      this.tipoelab.Value('X');\n      this.cdadata.Value(DateToChar(this.dadata.Value()));\n      this.c_adata.Value(DateToChar(this.a_data.Value()));\n      this.LoadMC();\n      this.RTExec.Link();\n    }  \n  }  \n}\n\nfunction btnBatch_Click(){\n  _errore=0;\n  if (this.opesel.Value()=='N' && this.frzsel.Value()=='N') {\n    _errore=1;\n    alert('Obbligatorio selezionare una fonte da cui prelevare i dati')\n  }  \n  if (Empty(this.tipoout.Value())) {\n    _errore=1;\n    alert('Obbligatorio selezionare la destinazione dei dati')\n  }  \n  if (Empty(this.flgsegno.Value())) {\n    _errore=1;\n    alert('Obbligatorio selezionare il segno delle operazioni')\n  }          \n  if (this.flgmese.Value()=='S' && (Empty(this.dadata.Value()) || Empty(this.a_data.Value()))) {\n    _errore=1;\n    alert('Creazione di un file per mese utilizzabile solo se viene selezionato un periodo')                                    \n  }                                  \n  if (_errore==0) {\n    if (confirm(\"Confermi lo scheduling dell'estrazione dei movimenti?\")) {  \n      this.CalcListe();\n      this.tipoelab.Value('B');\n      this.cdadata.Value(DateToChar(this.dadata.Value()));\n      this.c_adata.Value(DateToChar(this.a_data.Value()));\n      this.LoadMC();      \n      this.RTExec.Link();  \n    }  \n  }  \n}\n\nfunction CalcListe() {\n  this.selectedValues.Value(this.grdStati.GetSelectedDataAsTrsString());\n  this.lStati.Value(this.RTListe.Link());    \n  this.selectedValues.Value(this.grdProv.GetSelectedDataAsTrsString());\n  this.lProv.Value(this.RTListe.Link());      \n}  \n\nfunction RTExec_Result(result) {\n\u002f\u002f  window.location=result\n  alert(result)\n  this.filename.Value(result);\n  this.cartella.Value(\"export\");\n  this.PortletLogs.Stop();     \n  this.RTCopia.Link();\n  alert(\"Elaborazione Completata!\");  \n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link()\n} \n\nfunction Upload_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link()\n}\n\nfunction RTCopia_Result(result){\n  if(result=='OK') {\n    this.downloadURI('..\u002fappo\u002f'+this.gAzienda.Value()+\"\u002f\"+this.filename.Value(),this.filename.Value())\n  } else {\n    alert(\"Non ci sono file da prelevare\")\n  }  \n}\n\nfunction downloadURI(uri, name) {\n  var link = document.createElement(\"a\");\n  link.download = name;\n  link.href = uri;\n  document.body.appendChild(link);\n  link.click();\n  document.body.removeChild(link);\n  delete link;\n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Estrazione Movimenti (Operazioni\u002fFrazionate)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label2_Copy_Copy_Copy_Copy }}{{ @label2_Copy_Copy_Copy_Copy_Copy }}{{ @ragben }}{{ @pLog }}{{ @pMsg }}{{ @grdStati }}{{ @grdProv }}{{ @connes }}{{ @label15 }}{{ @label15_Copy }}{{ @LinkZoom16 }}{{ @flgncf }}{{ @flgmese }}{{ @opesel }}{{ @frzsel }}{{ @attive }}{{ @label21_Copy }}{{ @label21_Copy_Copy }}{{ @label21_Copy_Copy_Copy }}{{ @label21_Copy_Copy_Copy_Copy }}{{ @label21_Copy_Copy_Copy_Copy_Copy }}{{ @ragosc }}{{ @codmag }}{{ @tipoout }}{{ @cCODFISC }}{{ @label38 }}{{ @label38_Copy }}{{ @label38_Copy_Copy }}{{ @label38_Copy_Copy_Copy_Copy }}{{ @label38_Copy_Copy_Copy_Copy_Copy }}{{ @label38_Copy_Copy_Copy_Copy_Copy_Copy }}{{ @Città }}{{ @label10 }}{{ @tipofile }}{{ @flgsegno }}{{ @desmag }}{{ @citnas }}{{ @stanas }}{{ @staben }}{{ @cDIP }}{{ @zANADIP }}{{ @label12 }}{{ @label12_Copy }}{{ @label12_Copy_Copy }}{{ @label12_Copy_Copy_Copy }}{{ @cMTCN }}{{ @xdesdip }}{{ @LinkZoom13 }}{{ @LinkZoom13_Copy }}{{ @LinkZoom13_Copy_Copy }}{{ @datnas }}{{ @dadata }}{{ @a_data }}{{ @label18 }}{{ @label18_Copy }}{{ @label18_Copy_Copy }}{{ @label18_Copy_Copy_Copy }}{{ @label18_Copy_Copy_Copy_Copy }}{{ @label18_Copy_Copy_Copy_Copy_Copy }}{{ @Calendario19 }}{{ @Calendario19_Copy }}{{ @Calendario19_Copy_Copy }}{{ @nomefile }}{{ @Upload }}{{ @importo }}{{ @storico }}{{ @flgsto }}{{ @destaben }}{{ @label2_Copy_Copy_Copy_Copy }}{{ @label2_Copy_Copy_Copy_Copy_Copy }}{{ @ragben }}{{ @grdStati }}{{ @grdProv }}{{ @connes }}{{ @label15 }}{{ @label15_Copy }}{{ @LinkZoom16 }}{{ @flgncf }}{{ @flgmese }}{{ @opesel }}{{ @frzsel }}{{ @attive }}{{ @label21_Copy }}{{ @label21_Copy_Copy }}{{ @label21_Copy_Copy_Copy }}{{ @label21_Copy_Copy_Copy_Copy }}{{ @label21_Copy_Copy_Copy_Copy_Copy }}{{ @ragosc }}{{ @codmag }}{{ @tipoout }}{{ @cCODFISC }}{{ @label38 }}{{ @label38_Copy }}{{ @label38_Copy_Copy }}{{ @label38_Copy_Copy_Copy_Copy }}{{ @label38_Copy_Copy_Copy_Copy_Copy }}{{ @label38_Copy_Copy_Copy_Copy_Copy_Copy }}{{ @Città }}{{ @label10 }}{{ @tipofile }}{{ @flgsegno }}{{ @desmag }}{{ @citnas }}{{ @stanas }}{{ @staben }}{{ @cDIP }}{{ @zANADIP }}{{ @label12 }}{{ @label12_Copy }}{{ @label12_Copy_Copy }}{{ @label12_Copy_Copy_Copy }}{{ @cMTCN }}{{ @xdesdip }}{{ @LinkZoom13 }}{{ @LinkZoom13_Copy }}{{ @LinkZoom13_Copy_Copy }}{{ @datnas }}{{ @dadata }}{{ @a_data }}{{ @label18 }}{{ @label18_Copy }}{{ @label18_Copy_Copy }}{{ @label18_Copy_Copy_Copy }}{{ @label18_Copy_Copy_Copy_Copy }}{{ @label18_Copy_Copy_Copy_Copy_Copy }}{{ @Calendario19 }}{{ @Calendario19_Copy }}{{ @Calendario19_Copy_Copy }}{{ @nomefile }}{{ @Upload }}{{ @importo }}{{ @storico }}{{ @flgsto }}{{ @destaben }}{{ @PortletLogs }}{{ @Città }}\u003c\u002fbody\u003e","grapesCss":"","h":"425,560","hsl":"false","htmlcode":"{{ @PortletLogs }} \n{{ @destaben }}\n{{ @flgsto }}\n{{ @storico }}\n{{ @importo }}\n{{ @Upload }}\n\n{{ @nomefile }}\n{{ @Calendario19_Copy_Copy }}\n{{ @Calendario19_Copy }}\n{{ @Calendario19 }}\n{{ @label18_Copy_Copy_Copy_Copy_Copy }}\n{{ @label18_Copy_Copy_Copy_Copy }}\n{{ @label18_Copy_Copy_Copy }}\n{{ @label18_Copy_Copy }}\n{{ @label18_Copy }}\n{{ @label18 }}\n{{ @a_data }}\n{{ @dadata }}\n{{ @datnas }}\n{{ @LinkZoom13_Copy_Copy }}\n{{ @LinkZoom13_Copy }}\n{{ @LinkZoom13 }}\n{{ @xdesdip }}\n{{ @cMTCN }}\n{{ @label12_Copy_Copy_Copy }}\n{{ @label12_Copy_Copy }}\n{{ @label12_Copy }}\n{{ @label12 }}\n{{ @zANADIP }}\n{{ @cDIP }}\n{{ @staben }}\n{{ @stanas }}\n{{ @citnas }}\n{{ @desmag }}\n{{ @flgsegno }}\n{{ @tipofile }}\n{{ @label10 }}\n{{ @Città }}\n{{ @label38_Copy_Copy_Copy_Copy_Copy_Copy }}\n{{ @label38_Copy_Copy_Copy_Copy_Copy }}\n{{ @label38_Copy_Copy_Copy_Copy }}\n\n{{ @label38_Copy_Copy }}\n{{ @label38_Copy }}\n{{ @label38 }}\n{{ @cCODFISC }}\n{{ @tipoout }}\n{{ @codmag }}\n{{ @ragosc }}\n{{ @label21_Copy_Copy_Copy_Copy_Copy }}\n{{ @label21_Copy_Copy_Copy_Copy }}\n{{ @label21_Copy_Copy_Copy }}\n{{ @label21_Copy_Copy }}\n{{ @label21_Copy }}\n{{ @attive }}\n{{ @frzsel }}\n{{ @opesel }}\n{{ @flgmese }}\n{{ @flgncf }}\n{{ @LinkZoom16 }}\n{{ @label15_Copy }}\n{{ @label15 }}\n{{ @connes }}\n{{ @grdProv }}\n{{ @grdStati }}\n\n\n{{ @ragben }}\n{{ @label2_Copy_Copy_Copy_Copy_Copy }}\n{{ @label2_Copy_Copy_Copy_Copy }}\n{{ destaben }}\n{{ RTUpload }}\n{{ mRoot }}\n{{ label2_Copy_Copy_Copy_Copy }}\n{{ label2_Copy_Copy_Copy_Copy_Copy }}\n{{ ragben }}\n{{ btnBatch }}\n{{ btnElab }}\n{{ btnExit }}\n{{ mFileName }}\n{{ selectedValues }}\n{{ RTEsci }}\n{{ RTExec }}\n{{ RTCreaMC }}\n{{ mcParametri }}\n{{ pLog }}\n{{ pMsg }}\n{{ grdStati }}\n{{ grdProv }}\n{{ SQLStati }}\n{{ SQLProv }}\n{{ connes }}\n{{ label15 }}\n{{ label15_Copy }}\n{{ LinkZoom16 }}\n{{ flgncf }}\n{{ flgmese }}\n{{ opesel }}\n{{ frzsel }}\n{{ attive }}\n{{ label21_Copy }}\n{{ label21_Copy_Copy }}\n{{ label21_Copy_Copy_Copy }}\n{{ label21_Copy_Copy_Copy_Copy }}\n{{ label21_Copy_Copy_Copy_Copy_Copy }}\n{{ ragosc }}\n{{ codmag }}\n{{ tipoout }}\n{{ cCODFISC }}\n{{ label38 }}\n{{ label38_Copy }}\n{{ label38_Copy_Copy }}\n{{ label38_Copy_Copy_Copy }}\n{{ label38_Copy_Copy_Copy_Copy }}\n{{ label38_Copy_Copy_Copy_Copy_Copy }}\n{{ label38_Copy_Copy_Copy_Copy_Copy_Copy }}\n{{ Città }}\n{{ label10 }}\n{{ tipofile }}\n{{ flgsegno }}\n{{ desmag }}\n{{ citnas }}\n{{ stanas }}\n{{ staben }}\n{{ cDIP }}\n{{ zANADIP }}\n{{ label12 }}\n{{ label12_Copy }}\n{{ label12_Copy_Copy }}\n{{ label12_Copy_Copy_Copy }}\n{{ cMTCN }}\n{{ xdesdip }}\n{{ LinkZoom13 }}\n{{ LinkZoom13_Copy }}\n{{ LinkZoom13_Copy_Copy }}\n{{ datnas }}\n{{ dadata }}\n{{ a_data }}\n{{ label18 }}\n{{ label18_Copy }}\n{{ label18_Copy_Copy }}\n{{ label18_Copy_Copy_Copy }}\n{{ label18_Copy_Copy_Copy_Copy }}\n{{ label18_Copy_Copy_Copy_Copy_Copy }}\n{{ Calendario19 }}\n{{ Calendario19_Copy }}\n{{ Calendario19_Copy_Copy }}\n{{ nomefile }}\n{{ destfold }}\n{{ Upload }}\n{{ lProv }}\n{{ lStati }}\n{{ tipoelab }}\n{{ RTListe }}\n{{ cdadata }}\n{{ c_adata }}\n{{ gAzienda }}\n{{ mDirectory }}\n{{ importo }}\n{{ dir }}\n{{ RTSaveFile }}\n{{ Event_filename }}\n{{ storico }}\n{{ flgsto }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1,2","pagesProp":"[{\"title\":\"Filtri Base\",\"layer\":\"\",\"h\":\"425\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\" Filtri Aggiuntivi\",\"layer\":\"\",\"h\":\"560\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Filtri Base, Filtri Aggiuntivi","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%,100%","wizard":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"1","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"137","x":"818","y":"209"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"345","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1139","y":"-40"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'\u002f'","name":"mRoot","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"821","y":"105"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cartella","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1135","y":"-14"},{"align":"center","anchor":"","assoc_input":"","bg_color":"#1306C6","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#FFF700","font_size":"11pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2_Copy_Copy_Copy_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Stati destinazione","w":"800","wireframe_props":"align,value,n_col","x":"0","y":"6","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"destfold","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1013","y":"53"},{"align":"center","anchor":"","assoc_input":"","bg_color":"#1306C6","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#FFF700","font_size":"11pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Province Agenzie","w":"800","wireframe_props":"align,value,n_col","x":"0","y":"263","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"60","name":"ragben","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"450","wireframe_props":"name","x":"116","y":"116","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"mFileName","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"977","y":"133"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"selectedValues","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"825","y":"-74"},{"allowedentities":"arfn_start_estrai_xls","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"mcParam=mcParametri","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arfn_start_estrai_xls","target":"","type":"SPLinker","w":"125","x":"980","y":"180"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTCreaMC","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arfn_creamc","target":"","type":"SPLinker","w":"92","x":"1000","y":"-79"},{"auto_create":"","ctrlOfVariant":"","fields":"","h":"30","name":"mcParametri","page":"1","sequence":"15","type":"MemoryCursor","types":"","w":"107","x":"1004","y":"7"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true-selectAll","checkbox_fields":"CODICE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DESCRI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQLStati","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,C","filters":"false","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"237","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grdStati","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"16","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"799","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"25","zindex":"","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true-selectAll","checkbox_fields":"CODICE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Provincia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQLProv","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"237","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grdProv","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"17","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"799","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"282","zindex":"","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLStati","offline":"false","page":"2","parms":"","parms_source":"","query":"qbe_tbstati","query_async":"false","return_fields_type":"true","sequence":"18","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"-3","y":"-68"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLProv","offline":"false","page":"2","parms":"","parms_source":"","query":"qbe_provage","query_async":"false","return_fields_type":"true","sequence":"19","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"137","y":"-68"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"connes","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"131","wireframe_props":"name","x":"116","y":"6","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label15","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NDG Intestatario:","w":"111","wireframe_props":"align,value,n_col","x":"3","y":"9","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label15_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nominativo:","w":"111","wireframe_props":"align,value,n_col","x":"3","y":"38","zindex":"1","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"connes,ragosc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"connes","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom16","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"23","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"247","y":"6","zindex":"","zone":"","zoomtitle":"Soggetti"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":"false","layout_steps_values":"{}","name":"flgncf","page":"1","rapp":"","sequence":"24","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"13","wireframe_props":"label_text","x":"642","y":"60","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":"false","layout_steps_values":"{}","name":"flgmese","page":"1","rapp":"","sequence":"25","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"13","wireframe_props":"label_text","x":"642","y":"174","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":"false","layout_steps_values":"{}","name":"opesel","page":"1","rapp":"","sequence":"26","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"13","wireframe_props":"label_text","x":"116","y":"291","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":"false","layout_steps_values":"{}","name":"frzsel","page":"1","rapp":"","sequence":"27","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"13","wireframe_props":"label_text","x":"211","y":"291","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":"false","layout_steps_values":"{}","name":"attive","page":"1","rapp":"","sequence":"28","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"13","wireframe_props":"label_text","x":"350","y":"291","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"flgncf","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"13","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label21_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Elimina C. F. Fittizio","w":"112","wireframe_props":"align,value,n_col","x":"661","y":"64","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"flgmese","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"13","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label21_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Crea un file per ogni mese","w":"139","wireframe_props":"align,value,n_col","x":"661","y":"177","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"opesel","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"13","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label21_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Operazioni","w":"61","wireframe_props":"align,value,n_col","x":"135","y":"295","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"frzsel","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"13","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label21_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"32","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Frazionate","w":"61","wireframe_props":"align,value,n_col","x":"230","y":"295","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"attive","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"13","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label21_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"33","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Solo movimenti Attivi","w":"116","wireframe_props":"align,value,n_col","x":"369","y":"295","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"ragosc","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"34","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"426","wireframe_props":"name","x":"116","y":"33","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"5","name":"codmag","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"35","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"47","wireframe_props":"name","x":"116","y":"204","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipoout","page":"1","picture":"","rapp":"","sequence":"36","spuid":"","tabindex":"","textlist":"Excel,Testo,Database con Azzeramento,Database in Accodamento,CSV","type":"Combobox","typevar":"character","valuelist":"E,T,Z,D,C","visible":"true","w":"275","wireframe_props":"name,textlist","x":"117","y":"316","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"cCODFISC","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"37","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"139","wireframe_props":"name","x":"640","y":"33","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"38","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MacroAgente:","w":"69","wireframe_props":"align,value,n_col","x":"45","y":"210","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia:","w":"69","wireframe_props":"align,value,n_col","x":"45","y":"238","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"40","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nome File:","w":"69","wireframe_props":"align,value,n_col","x":"45","y":"268","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"41","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Estrazione:","w":"111","wireframe_props":"align,value,n_col","x":"1","y":"291","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"42","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Output:","w":"111","wireframe_props":"align,value,n_col","x":"1","y":"320","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"43","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Segno (fino al 31\u002f12\u002f2020):","w":"186","wireframe_props":"align,value,n_col","x":"416","y":"320","zindex":"1","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"codmag,desmag","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"codmag","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"Città","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"MACODICE,MADESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"44","servlet":"","spuid":"","suggest":"false","table":"tbmacage","type":"LinkZoom","w":"20","wireframe_props":"","x":"163","y":"204","zindex":"","zone":"","zoomtitle":"MacroAgenti"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"14","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label10","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"45","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice Fiscale:","w":"88","wireframe_props":"align,value,n_col","x":"550","y":"40","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipofile","page":"1","picture":"","rapp":"","sequence":"46","spuid":"","tabindex":"","textlist":"MTCN,C.F.","type":"Combobox","typevar":"character","valuelist":"1,2","visible":"true","w":"103","wireframe_props":"name,textlist","x":"692","y":"263","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"2","layer":"false","layout_steps_values":"{}","name":"flgsegno","page":"1","picture":"","rapp":"","sequence":"47","spuid":"","tabindex":"","textlist":"Segno Avere = SEND,Segno Dare = SEND","type":"Combobox","typevar":"character","valuelist":"1,2","visible":"true","w":"191","wireframe_props":"name,textlist","x":"604","y":"316","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"desmag","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"48","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"370","wireframe_props":"name","x":"193","y":"204","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"40","name":"citnas","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"49","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"300","wireframe_props":"name","x":"116","y":"60","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"40","name":"stanas","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"50","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"300","wireframe_props":"name","x":"116","y":"88","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"40","name":"staben","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"51","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"37","wireframe_props":"name","x":"116","y":"144","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"cDIP","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"52","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"57","wireframe_props":"name","x":"116","y":"234","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"cDIP,xdesdip","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"cDIP","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"zANADIP","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"53","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"173","y":"234","zindex":"","zone":"","zoomtitle":"Agenzie"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label12","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"54","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Città di Nascita:","w":"111","wireframe_props":"align,value,n_col","x":"3","y":"64","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label12_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"55","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Stato di Nascita:","w":"98","wireframe_props":"align,value,n_col","x":"16","y":"92","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label12_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"56","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Controparte:","w":"98","wireframe_props":"align,value,n_col","x":"16","y":"121","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label12_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"57","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Stato di Destinazione:","w":"111","wireframe_props":"align,value,n_col","x":"3","y":"149","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"cMTCN","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"58","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"85","wireframe_props":"name","x":"640","y":"234","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"xdesdip","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"59","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"370","wireframe_props":"name","x":"203","y":"234","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"citnas","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"citnas","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom13","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CITTA","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"60","servlet":"","spuid":"","suggest":"false","table":"tbcitta","type":"LinkZoom","w":"20","wireframe_props":"","x":"416","y":"60","zindex":"","zone":"","zoomtitle":"Città"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"stanas","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"stanas","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom13_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"61","servlet":"","spuid":"","suggest":"false","table":"tbstati","type":"LinkZoom","w":"20","wireframe_props":"","x":"416","y":"88","zindex":"","zone":"","zoomtitle":"Stati"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"staben,destaben","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"staben","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom13_Copy_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"62","servlet":"","spuid":"","suggest":"false","table":"tbstati","type":"LinkZoom","w":"20","wireframe_props":"","x":"154","y":"144","zindex":"","zone":"","zoomtitle":"Stati"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"datnas","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"63","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"640","y":"89","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"dadata","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"64","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"116","y":"174","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"a_data","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"65","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"345","y":"174","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"66","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data di Nascita:","w":"95","wireframe_props":"align,value,n_col","x":"543","y":"92","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"67","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"111","wireframe_props":"align,value,n_col","x":"3","y":"179","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"68","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"111","wireframe_props":"align,value,n_col","x":"231","y":"179","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"69","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MTCN:","w":"40","wireframe_props":"align,value,n_col","x":"598","y":"238","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"70","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo:","w":"35","wireframe_props":"align,value,n_col","x":"655","y":"268","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"71","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo \u003e=","w":"76","wireframe_props":"align,value,n_col","x":"562","y":"210","zindex":"1","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario19","page":"1","popup":"true","rapp":"","return_input":"datnas","sequence":"72","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"721","y":"89","zindex":"","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario19_Copy","page":"1","popup":"true","rapp":"","return_input":"dadata","sequence":"73","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"197","y":"174","zindex":"","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario19_Copy_Copy","page":"1","popup":"true","rapp":"","return_input":"a_data","sequence":"74","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"426","y":"174","zindex":"","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"60","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"75","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"457","wireframe_props":"name","x":"116","y":"264","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Upload","page":"1","rapp":"","sequence":"76","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Seleziona","w":"65","wireframe_props":"value","x":"573","y":"264","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"lProv","page":"1","reactive":"","sequence":"77","server_side":"false","type":"Variable","typevar":"character","w":"41","x":"819","y":"78"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"lStati","page":"1","reactive":"","sequence":"78","server_side":"false","type":"Variable","typevar":"character","w":"140","x":"826","y":"-45"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"27","init":"","init_par":"","name":"tipoelab","page":"1","reactive":"","sequence":"79","server_side":"false","type":"Variable","typevar":"character","w":"137","x":"830","y":"-16"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTListe","offline":"false","page":"2","parms":"mcStringa=selectedValues","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"80","servlet":"arfn_selezione","target":"","type":"SPLinker","w":"106","x":"827","y":"-13"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cdadata","page":"1","reactive":"","sequence":"81","server_side":"false","type":"Variable","typevar":"character","w":"99","x":"832","y":"14"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"c_adata","page":"1","reactive":"","sequence":"82","server_side":"false","type":"Variable","typevar":"character","w":"53","x":"941","y":"15"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"83","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"833","y":"50"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"mDirectory","page":"1","reactive":"","sequence":"84","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"819","y":"133"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"15","name":"importo","page":"1","password":"","picker":"","picture":"999,999,999.99","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"85","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"112","wireframe_props":"name","x":"641","y":"204","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"86","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1129","y":"-79"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"87","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"120","x":"1002","y":"-43"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"88","type":"EventReceiver","w":"111","x":"1062","y":"93"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","layer":"false","layout_steps_values":"{}","name":"storico","page":"1","picture":"","rapp":"","sequence":"89","spuid":"","tabindex":"","textlist":"Storico Soggetti per Data Operazione,Storico Soggetti per Data Registrazione","type":"Combobox","typevar":"character","valuelist":"O,S","visible":"true","w":"340","wireframe_props":"name,textlist","x":"446","y":"6","zindex":"2","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Dati Storici Soggetto","layer":"false","layout_steps_values":"{}","name":"flgsto","page":"1","rapp":"","sequence":"90","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"154","wireframe_props":"label_text","x":"288","y":"6","zindex":"3","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"60","name":"destaben","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"91","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"449","wireframe_props":"name","x":"182","y":"144","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"allowedentities":"arfn_copy_file_appo","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTCopia","offline":"false","page":"1","parms":"pNomeFile=filename,pCartella=cartella","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"92","servlet":"arfn_copy_file_appo","target":"","type":"SPLinker","w":"127","x":"1136","y":"16"}]%>
<%/*Description:Estrazione Movimenti (Operazioni/Frazionate)*/%>
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
window.pg_estrai_xls_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LoadMC !='undefined')this.LoadMC=LoadMC;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof btnBatch_Click !='undefined')this.btnBatch_Click=btnBatch_Click;
if(typeof CalcListe !='undefined')this.CalcListe=CalcListe;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof Upload_Click !='undefined')this.Upload_Click=Upload_Click;
if(typeof RTCopia_Result !='undefined')this.RTCopia_Result=RTCopia_Result;
if(typeof downloadURI !='undefined')this.downloadURI=downloadURI;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.SQLStati.addRowConsumer(this.grdStati);
this.SQLProv.addRowConsumer(this.grdProv);
this.LinkZoom16.addObserverFixedVars();
this.Città.addObserverFixedVars();
this.zANADIP.addObserverFixedVars();
this.LinkZoom13.addObserverFixedVars();
this.LinkZoom13_Copy.addObserverFixedVars();
this.LinkZoom13_Copy_Copy.addObserverFixedVars();
function this_Loaded(){
  this.mcParametri.Value(this.RTCreaMC.Link());
  this.opesel.Value('S');
  this.frzsel.Value('S');
  this.flgsto.Value('S');
  this.flgncf.Value('S');
  this.getTitlePortlet().SetTitle("ESTRAZIONE MOVIMENTI (OPERAZIONI/FRAZIONATE)",true)
  this.getTitlePortlet().AppendButton({
    id:"Batch",
    title:FormatMsg('Batch'),
    tooltip:FormatMsg("Esegui estrazione in modalità ritardata"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe91c"},
    action:'javascript:' + this.formid +'.btnBatch_Click()'
  },2);                                 
  this.getTitlePortlet().AppendButton({
    id:"Real",
    title:FormatMsg('Esegui'),
    tooltip:FormatMsg("Esegui estrazione in tempo reale"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47"},
    action:'javascript:' + this.formid +'.btnElab_Click()'
  },2);
}
function LoadMC() {
  this.mcParametri.Set("pTipo",this.tipoelab.Value())
  this.mcParametri.Set("w_dadata",this.dadata.Value());
  this.mcParametri.Set("w_adata",this.a_data.Value());
  this.mcParametri.Set("w_cdadata",this.cdadata.Value());
  this.mcParametri.Set("w_c_adata",this.c_adata.Value());
  this.mcParametri.Set("w_cDIP",this.cDIP.Value());
  this.mcParametri.Set("w_xdesdip",this.xdesdip.Value());
  this.mcParametri.Set("w_ragosc",this.ragosc.Value());
  this.mcParametri.Set("w_citnas",this.citnas.Value());
  this.mcParametri.Set("w_stanas",this.stanas.Value());
  this.mcParametri.Set("w_datnas",this.datnas.Value());
  this.mcParametri.Set("w_cMTCN",this.cMTCN.Value());
  this.mcParametri.Set("w_cCODFISC",this.cCODFISC.Value());
  this.mcParametri.Set("w_ragben",this.ragben.Value());
  this.mcParametri.Set("w_staben",this.staben.Value());
  this.mcParametri.Set("w_codmag",this.codmag.Value());
  this.mcParametri.Set("w_connes",this.connes.Value());
  this.mcParametri.Set("w_nomefile",this.nomefile.Value());
  this.mcParametri.Set("w_tipofile",this.tipofile.Value());
  this.mcParametri.Set("w_flgsto",this.flgsto.Value());
  this.mcParametri.Set("w_tipoout",this.tipoout.Value());
  this.mcParametri.Set("w_opesel",this.opesel.Value());
  this.mcParametri.Set("w_frzsel",this.frzsel.Value());
  this.mcParametri.Set("w_attive",this.attive.Value());
  this.mcParametri.Set("w_destfold",this.destfold.Value());
  this.mcParametri.Set("w_flgmese",this.flgmese.Value());
  this.mcParametri.Set("w_flgncf",this.flgncf.Value());
  this.mcParametri.Set("w_flgsegno",this.flgsegno.Value());
  this.mcParametri.Set("w_lststa",this.lStati.Value());
  this.mcParametri.Set("w_lstprv",this.lProv.Value());
  this.mcParametri.Set("w_importo",this.importo.Value());  
  this.mcParametri.Set("w_storico",this.storico.Value());  
}  
function btnElab_Click(){
  _errore=0;
  if (this.opesel.Value()=='N' && this.frzsel.Value()=='N') {
    _errore=1;
    alert('Obbligatorio selezionare una fonte da cui prelevare i dati')
  }  
  if (Empty(this.tipoout.Value())) {
    _errore=1;
    alert('Obbligatorio selezionare la destinazione dei dati')
  }  
  if (Empty(this.flgsegno.Value())) {
    _errore=1;
    alert('Obbligatorio selezionare il segno delle operazioni')
  }          
  if (this.flgmese.Value()=='S' && (Empty(this.dadata.Value()) || Empty(this.a_data.Value()))) {
    _errore=1;
    alert('Creazione di un file per mese utilizzabile solo se viene selezionato un periodo')                                    
  }    
  if (_errore==0) {  
    if (confirm("Confermi l'estrazione dei movimenti?")) {      
      this.PortletLogs.Start();     
      this.CalcListe();
      this.tipoelab.Value('X');
      this.cdadata.Value(DateToChar(this.dadata.Value()));
      this.c_adata.Value(DateToChar(this.a_data.Value()));
      this.LoadMC();
      this.RTExec.Link();
    }  
  }  
}
function btnBatch_Click(){
  _errore=0;
  if (this.opesel.Value()=='N' && this.frzsel.Value()=='N') {
    _errore=1;
    alert('Obbligatorio selezionare una fonte da cui prelevare i dati')
  }  
  if (Empty(this.tipoout.Value())) {
    _errore=1;
    alert('Obbligatorio selezionare la destinazione dei dati')
  }  
  if (Empty(this.flgsegno.Value())) {
    _errore=1;
    alert('Obbligatorio selezionare il segno delle operazioni')
  }          
  if (this.flgmese.Value()=='S' && (Empty(this.dadata.Value()) || Empty(this.a_data.Value()))) {
    _errore=1;
    alert('Creazione di un file per mese utilizzabile solo se viene selezionato un periodo')                                    
  }                                  
  if (_errore==0) {
    if (confirm("Confermi lo scheduling dell'estrazione dei movimenti?")) {  
      this.CalcListe();
      this.tipoelab.Value('B');
      this.cdadata.Value(DateToChar(this.dadata.Value()));
      this.c_adata.Value(DateToChar(this.a_data.Value()));
      this.LoadMC();      
      this.RTExec.Link();  
    }  
  }  
}
function CalcListe() {
  this.selectedValues.Value(this.grdStati.GetSelectedDataAsTrsString());
  this.lStati.Value(this.RTListe.Link());    
  this.selectedValues.Value(this.grdProv.GetSelectedDataAsTrsString());
  this.lProv.Value(this.RTListe.Link());      
}  
function RTExec_Result(result) {
//  window.location=result
  alert(result)
  this.filename.Value(result);
  this.cartella.Value("export");
  this.PortletLogs.Stop();     
  this.RTCopia.Link();
  alert("Elaborazione Completata!");  
}
function Aggiorna() {
  this.RTSaveFile.Link()
} 
function Upload_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link()
}
function RTCopia_Result(result){
  if(result=='OK') {
    this.downloadURI('../appo/'+this.gAzienda.Value()+"/"+this.filename.Value(),this.filename.Value())
  } else {
    alert("Non ci sono file da prelevare")
  }  
}
function downloadURI(uri, name) {
  var link = document.createElement("a");
  link.download = name;
  link.href = uri;
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
  delete link;
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
.pg_estrai_xls_container {
  height:100%;
  overflow:auto;
}
.pg_estrai_xls_title_container {
  margin: auto;
}
.pg_estrai_xls_portlet{
  position:relative;
  margin: auto;
  min-width:800px;
  height:100%;
}
.pg_estrai_xls_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_estrai_xls_portlet[Data-page="2"]{
  height:100%;
  width:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:345px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label2_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label2_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label2_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:11pt;
  font-weight:bold;
  color:#FFF700;
  text-align:center;
  background-color:#1306C6;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label2_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:263px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label2_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label2_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:11pt;
  font-weight:bold;
  color:#FFF700;
  text-align:center;
  background-color:#1306C6;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .ragben_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:116px;
  left:116px;
  left:14.5%;
  right:234px;
  right:29.25%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .ragben_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .ragben_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .grdStati_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.125%;
  width:auto;
  height:auto;
  min-height:237px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .grdProv_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:282px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.125%;
  width:auto;
  height:auto;
  min-height:237px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .connes_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:116px;
  left:14.5%;
  right:553px;
  right:69.125%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .connes_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .connes_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label15_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:3px;
  left:0.375%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label15_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label15_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label15_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:3px;
  left:0.375%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label15_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label15_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .LinkZoom16_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:247px;
  left:30.875%;
  right:533px;
  right:66.625%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .flgncf_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:642px;
  left:80.25%;
  right:145px;
  right:18.125%;
  width:auto;
  height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .flgmese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:174px;
  left:642px;
  left:80.25%;
  right:145px;
  right:18.125%;
  width:auto;
  height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .opesel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:291px;
  left:116px;
  left:14.5%;
  right:671px;
  right:83.875%;
  width:auto;
  height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .frzsel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:291px;
  left:211px;
  left:26.375%;
  right:576px;
  right:72.0%;
  width:auto;
  height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .attive_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:291px;
  left:350px;
  left:43.75%;
  right:437px;
  right:54.625%;
  width:auto;
  height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:64px;
  left:661px;
  left:82.625%;
  right:27px;
  right:3.375%;
  width:auto;
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_ctrl {
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:177px;
  left:661px;
  left:82.625%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_ctrl {
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:295px;
  left:135px;
  left:16.875%;
  right:604px;
  right:75.5%;
  width:auto;
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:295px;
  left:230px;
  left:28.75%;
  right:509px;
  right:63.625%;
  width:auto;
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:295px;
  left:369px;
  left:46.125%;
  right:315px;
  right:39.375%;
  width:auto;
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:13px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label21_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .ragosc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:116px;
  left:14.5%;
  right:258px;
  right:32.25%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .ragosc_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .ragosc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .codmag_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:204px;
  left:116px;
  left:14.5%;
  right:637px;
  right:79.625%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .codmag_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .codmag_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .tipoout_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:316px;
  left:117px;
  left:14.625%;
  right:408px;
  right:51.0%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cCODFISC_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:640px;
  left:80.0%;
  right:21px;
  right:2.625%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cCODFISC_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cCODFISC_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:210px;
  left:45px;
  left:5.625%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:238px;
  left:45px;
  left:5.625%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:268px;
  left:45px;
  left:5.625%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:291px;
  left:1px;
  left:0.125%;
  right:688px;
  right:86.0%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:320px;
  left:1px;
  left:0.125%;
  right:688px;
  right:86.0%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:320px;
  left:416px;
  left:52.0%;
  right:198px;
  right:24.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .Città_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:204px;
  left:163px;
  left:20.375%;
  right:617px;
  right:77.125%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label10_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:550px;
  left:68.75%;
  right:162px;
  right:20.25%;
  width:auto;
  height:auto;
  min-height:14px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label10_ctrl {
  height:auto;
  min-height:14px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label10_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .tipofile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:263px;
  left:692px;
  left:86.5%;
  right:5px;
  right:0.625%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .flgsegno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:316px;
  left:604px;
  left:75.5%;
  right:5px;
  right:0.625%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .desmag_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:204px;
  left:193px;
  left:24.125%;
  right:237px;
  right:29.625%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .desmag_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .desmag_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .citnas_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:116px;
  left:14.5%;
  right:384px;
  right:48.0%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .citnas_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .citnas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .stanas_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:88px;
  left:116px;
  left:14.5%;
  right:384px;
  right:48.0%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .stanas_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .stanas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .staben_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:144px;
  left:116px;
  left:14.5%;
  right:647px;
  right:80.875%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .staben_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .staben_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cDIP_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:234px;
  left:116px;
  left:14.5%;
  right:627px;
  right:78.375%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cDIP_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cDIP_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .zANADIP_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:234px;
  left:173px;
  left:21.625%;
  right:607px;
  right:75.875%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:64px;
  left:3px;
  left:0.375%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:92px;
  left:16px;
  left:2.0%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:121px;
  left:16px;
  left:2.0%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:149px;
  left:3px;
  left:0.375%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label12_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cMTCN_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:234px;
  left:640px;
  left:80.0%;
  right:75px;
  right:9.375%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cMTCN_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .cMTCN_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .xdesdip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:234px;
  left:203px;
  left:25.375%;
  right:227px;
  right:28.375%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .xdesdip_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .xdesdip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .LinkZoom13_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:416px;
  left:52.0%;
  right:364px;
  right:45.5%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .LinkZoom13_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:88px;
  left:416px;
  left:52.0%;
  right:364px;
  right:45.5%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .LinkZoom13_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:144px;
  left:154px;
  left:19.25%;
  right:626px;
  right:78.25%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .datnas_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:89px;
  left:640px;
  left:80.0%;
  right:79px;
  right:9.875%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .datnas_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .datnas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:174px;
  left:116px;
  left:14.5%;
  right:603px;
  right:75.375%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .dadata_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .dadata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .a_data_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:174px;
  left:345px;
  left:43.125%;
  right:374px;
  right:46.75%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .a_data_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .a_data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:92px;
  left:543px;
  left:67.875%;
  right:162px;
  right:20.25%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:179px;
  left:3px;
  left:0.375%;
  right:686px;
  right:85.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:179px;
  left:231px;
  left:28.875%;
  right:458px;
  right:57.25%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:238px;
  left:598px;
  left:74.75%;
  right:162px;
  right:20.25%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:268px;
  left:655px;
  left:81.875%;
  right:110px;
  right:13.75%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:210px;
  left:562px;
  left:70.25%;
  right:162px;
  right:20.25%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .label18_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .Calendario19_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:89px;
  left:721px;
  left:90.125%;
  right:59px;
  right:7.375%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .Calendario19_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:174px;
  left:197px;
  left:24.625%;
  right:583px;
  right:72.875%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .Calendario19_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:174px;
  left:426px;
  left:53.25%;
  right:354px;
  right:44.25%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:264px;
  left:116px;
  left:14.5%;
  right:227px;
  right:28.375%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .nomefile_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .Upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:264px;
  left:573px;
  left:71.625%;
  right:162px;
  right:20.25%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .Upload_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#000000;
  background-color:buttonface;
  border-width:1px;
  border-color:#000000;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .importo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:204px;
  left:641px;
  left:80.125%;
  right:47px;
  right:5.875%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .importo_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .importo_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .storico_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  left:446px;
  left:55.75%;
  right:14px;
  right:1.75%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .flgsto_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:6px;
  left:288px;
  left:36.0%;
  right:358px;
  right:44.75%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .destaben_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:144px;
  left:182px;
  left:22.75%;
  right:169px;
  right:21.125%;
  width:auto;
  height:20px;
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .destaben_ctrl {
}
.pg_estrai_xls_portlet > .pg_estrai_xls_page > .destaben_ctrl > input{
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
 String def="[{\"h\":\"425,560\",\"layout_steps_values\":{},\"pages_names\":\"Filtri Base, Filtri Aggiuntivi\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%,100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"137\",\"x\":\"818\",\"y\":\"209\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"345\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1139\",\"y\":\"-40\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"821\",\"y\":\"105\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1135\",\"y\":\"-14\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Stati destinazione\",\"w\":\"800\",\"x\":\"0\",\"y\":\"6\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1013\",\"y\":\"53\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Province Agenzie\",\"w\":\"800\",\"x\":\"0\",\"y\":\"263\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ragben\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"450\",\"x\":\"116\",\"y\":\"116\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"mFileName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"977\",\"y\":\"133\"},{\"h\":\"20\",\"name\":\"selectedValues\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"825\",\"y\":\"-74\"},{\"h\":\"30\",\"name\":\"RTExec\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"125\",\"x\":\"980\",\"y\":\"180\"},{\"h\":\"30\",\"name\":\"RTCreaMC\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"92\",\"x\":\"1000\",\"y\":\"-79\"},{\"h\":\"30\",\"name\":\"mcParametri\",\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"107\",\"x\":\"1004\",\"y\":\"7\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true-selectAll\",\"colProperties\":[{\"title\":\"Codice\"},{\"title\":\"Descrizione\"}],\"h\":\"237\",\"layout_steps_values\":{},\"name\":\"grdStati\",\"page\":\"2\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"799\",\"x\":\"0\",\"y\":\"25\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true-selectAll\",\"colProperties\":[{\"title\":\"Provincia\"}],\"h\":\"237\",\"layout_steps_values\":{},\"name\":\"grdProv\",\"page\":\"2\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"799\",\"x\":\"0\",\"y\":\"282\",\"zindex\":\"\"},{\"h\":\"20\",\"name\":\"SQLStati\",\"page\":\"2\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"-3\",\"y\":\"-68\"},{\"h\":\"20\",\"name\":\"SQLProv\",\"page\":\"2\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"137\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"connes\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"131\",\"x\":\"116\",\"y\":\"6\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label15\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NDG Intestatario:\",\"w\":\"111\",\"x\":\"3\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label15_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nominativo:\",\"w\":\"111\",\"x\":\"3\",\"y\":\"38\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom16\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"247\",\"y\":\"6\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"flgncf\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"642\",\"y\":\"60\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"flgmese\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"642\",\"y\":\"174\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"opesel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"116\",\"y\":\"291\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"frzsel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"211\",\"y\":\"291\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"attive\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"350\",\"y\":\"291\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"13\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label21_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Elimina C. F. Fittizio\",\"w\":\"112\",\"x\":\"661\",\"y\":\"64\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"13\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label21_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Crea un file per ogni mese\",\"w\":\"139\",\"x\":\"661\",\"y\":\"177\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"13\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label21_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Operazioni\",\"w\":\"61\",\"x\":\"135\",\"y\":\"295\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"13\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label21_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Frazionate\",\"w\":\"61\",\"x\":\"230\",\"y\":\"295\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"13\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label21_Copy_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Solo movimenti Attivi\",\"w\":\"116\",\"x\":\"369\",\"y\":\"295\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ragosc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"426\",\"x\":\"116\",\"y\":\"33\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codmag\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"47\",\"x\":\"116\",\"y\":\"204\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipoout\",\"page\":\"1\",\"textlist\":\"Excel,Testo,Database con Azzeramento,Database in Accodamento,CSV\",\"type\":\"Combobox\",\"w\":\"275\",\"x\":\"117\",\"y\":\"316\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cCODFISC\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"139\",\"x\":\"640\",\"y\":\"33\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MacroAgente:\",\"w\":\"69\",\"x\":\"45\",\"y\":\"210\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"69\",\"x\":\"45\",\"y\":\"238\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome File:\",\"w\":\"69\",\"x\":\"45\",\"y\":\"268\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Estrazione:\",\"w\":\"111\",\"x\":\"1\",\"y\":\"291\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Output:\",\"w\":\"111\",\"x\":\"1\",\"y\":\"320\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Segno (fino al 31\\u002f12\\u002f2020):\",\"w\":\"186\",\"x\":\"416\",\"y\":\"320\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Città\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"163\",\"y\":\"204\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label10\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":\"88\",\"x\":\"550\",\"y\":\"40\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipofile\",\"page\":\"1\",\"textlist\":\"MTCN,C.F.\",\"type\":\"Combobox\",\"w\":\"103\",\"x\":\"692\",\"y\":\"263\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"flgsegno\",\"page\":\"1\",\"textlist\":\"Segno Avere = SEND,Segno Dare = SEND\",\"type\":\"Combobox\",\"w\":\"191\",\"x\":\"604\",\"y\":\"316\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"desmag\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"370\",\"x\":\"193\",\"y\":\"204\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"citnas\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"300\",\"x\":\"116\",\"y\":\"60\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"stanas\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"300\",\"x\":\"116\",\"y\":\"88\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"staben\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"37\",\"x\":\"116\",\"y\":\"144\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cDIP\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"57\",\"x\":\"116\",\"y\":\"234\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zANADIP\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"173\",\"y\":\"234\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label12\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Città di Nascita:\",\"w\":\"111\",\"x\":\"3\",\"y\":\"64\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label12_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":\"98\",\"x\":\"16\",\"y\":\"92\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label12_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Controparte:\",\"w\":\"98\",\"x\":\"16\",\"y\":\"121\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label12_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stato di Destinazione:\",\"w\":\"111\",\"x\":\"3\",\"y\":\"149\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cMTCN\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"640\",\"y\":\"234\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"xdesdip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"370\",\"x\":\"203\",\"y\":\"234\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom13\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"416\",\"y\":\"60\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom13_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"416\",\"y\":\"88\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom13_Copy_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"154\",\"y\":\"144\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"datnas\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"640\",\"y\":\"89\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dadata\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"116\",\"y\":\"174\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"345\",\"y\":\"174\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data di Nascita:\",\"w\":\"95\",\"x\":\"543\",\"y\":\"92\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"111\",\"x\":\"3\",\"y\":\"179\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"111\",\"x\":\"231\",\"y\":\"179\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MTCN:\",\"w\":\"40\",\"x\":\"598\",\"y\":\"238\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo:\",\"w\":\"35\",\"x\":\"655\",\"y\":\"268\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importo \\u003e=\",\"w\":\"76\",\"x\":\"562\",\"y\":\"210\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario19\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"721\",\"y\":\"89\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario19_Copy\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"197\",\"y\":\"174\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario19_Copy_Copy\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"426\",\"y\":\"174\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"457\",\"x\":\"116\",\"y\":\"264\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Upload\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Seleziona\",\"w\":\"65\",\"x\":\"573\",\"y\":\"264\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"lProv\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"41\",\"x\":\"819\",\"y\":\"78\"},{\"h\":\"20\",\"name\":\"lStati\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"140\",\"x\":\"826\",\"y\":\"-45\"},{\"h\":\"27\",\"name\":\"tipoelab\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"137\",\"x\":\"830\",\"y\":\"-16\"},{\"h\":\"30\",\"name\":\"RTListe\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"106\",\"x\":\"827\",\"y\":\"-13\"},{\"h\":\"20\",\"name\":\"cdadata\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"99\",\"x\":\"832\",\"y\":\"14\"},{\"h\":\"20\",\"name\":\"c_adata\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"53\",\"x\":\"941\",\"y\":\"15\"},{\"h\":\"20\",\"name\":\"gAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"833\",\"y\":\"50\"},{\"h\":\"22\",\"name\":\"mDirectory\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"819\",\"y\":\"133\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"importo\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"112\",\"x\":\"641\",\"y\":\"204\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1129\",\"y\":\"-79\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1002\",\"y\":\"-43\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"1062\",\"y\":\"93\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"storico\",\"page\":\"1\",\"textlist\":\"Storico Soggetti per Data Operazione,Storico Soggetti per Data Registrazione\",\"type\":\"Combobox\",\"w\":\"340\",\"x\":\"446\",\"y\":\"6\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Dati Storici Soggetto\",\"layout_steps_values\":{},\"name\":\"flgsto\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"154\",\"x\":\"288\",\"y\":\"6\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"destaben\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"449\",\"x\":\"182\",\"y\":\"144\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTCopia\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"127\",\"x\":\"1136\",\"y\":\"16\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrai_xls","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrai_xls_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrai_xls','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String filename= "";
String mRoot="/";
String cartella= "";
String label2_Copy_Copy_Copy_Copy= "Stati destinazione";
String destfold= "";
String label2_Copy_Copy_Copy_Copy_Copy= "Province Agenzie";
String ragben= "";
if(request.getAttribute("pg_estrai_xls_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String mFileName= "";
String selectedValues= "";
if(request.getAttribute("pg_estrai_xls_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
if(request.getAttribute("pg_estrai_xls_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String connes= "";
String label15= "NDG Intestatario:";
String label15_Copy= "Nominativo:";
if(request.getAttribute("pg_estrai_xls_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String flgncf="N";
String flgmese="N";
String opesel="N";
String frzsel="N";
String attive="N";
String label21_Copy= "Elimina C. F. Fittizio";
String label21_Copy_Copy= "Crea un file per ogni mese";
String label21_Copy_Copy_Copy= "Operazioni";
String label21_Copy_Copy_Copy_Copy= "Frazionate";
String label21_Copy_Copy_Copy_Copy_Copy= "Solo movimenti Attivi";
String ragosc= "";
String codmag= "";
String tipoout= "";
String cCODFISC= "";
String label38= "MacroAgente:";
String label38_Copy= "Agenzia:";
String label38_Copy_Copy= "Nome File:";
String label38_Copy_Copy_Copy_Copy= "Estrazione:";
String label38_Copy_Copy_Copy_Copy_Copy= "Tipo Output:";
String label38_Copy_Copy_Copy_Copy_Copy_Copy= "Tipo Segno (fino al 31/12/2020):";
String label10= "Codice Fiscale:";
String tipofile= "";
String flgsegno="2";
String desmag= "";
String citnas= "";
String stanas= "";
String staben= "";
String cDIP= "";
String label12= "Città di Nascita:";
String label12_Copy= "Stato di Nascita:";
String label12_Copy_Copy= "Controparte:";
String label12_Copy_Copy_Copy= "Stato di Destinazione:";
String cMTCN= "";
String xdesdip= "";
java.sql.Date datnas= JSPLib.NullDate();
java.sql.Date dadata= JSPLib.NullDate();
java.sql.Date a_data= JSPLib.NullDate();
String label18= "Data di Nascita:";
String label18_Copy= "Da Data Operazione:";
String label18_Copy_Copy= "A Data Operazione:";
String label18_Copy_Copy_Copy= "MTCN:";
String label18_Copy_Copy_Copy_Copy= "Tipo:";
String label18_Copy_Copy_Copy_Copy_Copy= "Importo >=";
if(request.getAttribute("pg_estrai_xls_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String nomefile= "";
String lProv= "";
String lStati= "";
String tipoelab= "";
String cdadata= "";
String c_adata= "";
String gAzienda=sp.getGlobal("gAzienda","");
String mDirectory= "";
double importo= 0;
String dir= "";
String storico="S";
String flgsto="S";
String destaben= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrai_xls_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='pg_estrai_xls_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrai_xls_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrai_xls','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='pg_estrai_xls_page' style='display:block'>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_ragben_wrp'><input id='<%=idPortlet%>_ragben' name='ragben' type='text' maxlength='60' class='textbox' formid='<%=idPortlet%>' ps-name='ragben' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<span class='textbox-container'id='<%=idPortlet%>_connes_wrp'><input id='<%=idPortlet%>_connes' name='connes' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='connes' /></span>
<span id='<%=idPortlet%>_label15'  formid='<%=idPortlet%>' ps-name='label15'    class='LabelOpenClose label15_ctrl'><div id='<%=idPortlet%>_label15tbl' style='width:100%;'><%=JSPLib.ToHTML("NDG Intestatario:")%></div></span>
<span id='<%=idPortlet%>_label15_Copy'  formid='<%=idPortlet%>' ps-name='label15_Copy'    class='label label15_Copy_ctrl'><div id='<%=idPortlet%>_label15_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Nominativo:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom16'" ) );%>
<input id='<%=idPortlet%>_flgncf' name='flgncf' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_flgmese' name='flgmese' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_opesel' name='opesel' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_frzsel' name='frzsel' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_attive' name='attive' class='checkbox' type='checkbox' style=''/>
<label id='<%=idPortlet%>_label21_Copy' for='<%=idPortlet%>_flgncf' formid='<%=idPortlet%>' ps-name='label21_Copy'    class='label label21_Copy_ctrl'><div id='<%=idPortlet%>_label21_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Elimina C. F. Fittizio")%></div></label>
<label id='<%=idPortlet%>_label21_Copy_Copy' for='<%=idPortlet%>_flgmese' formid='<%=idPortlet%>' ps-name='label21_Copy_Copy'    class='label label21_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label21_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Crea un file per ogni mese")%></div></label>
<label id='<%=idPortlet%>_label21_Copy_Copy_Copy' for='<%=idPortlet%>_opesel' formid='<%=idPortlet%>' ps-name='label21_Copy_Copy_Copy'    class='label label21_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label21_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Operazioni")%></div></label>
<label id='<%=idPortlet%>_label21_Copy_Copy_Copy_Copy' for='<%=idPortlet%>_frzsel' formid='<%=idPortlet%>' ps-name='label21_Copy_Copy_Copy_Copy'    class='label label21_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label21_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Frazionate")%></div></label>
<label id='<%=idPortlet%>_label21_Copy_Copy_Copy_Copy_Copy' for='<%=idPortlet%>_attive' formid='<%=idPortlet%>' ps-name='label21_Copy_Copy_Copy_Copy_Copy'    class='label label21_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label21_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Solo movimenti Attivi")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_ragosc_wrp'><input id='<%=idPortlet%>_ragosc' name='ragosc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='ragosc' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<span class='textbox-container'id='<%=idPortlet%>_codmag_wrp'><input id='<%=idPortlet%>_codmag' name='codmag' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='codmag' /></span>
<select id='<%=idPortlet%>_tipoout' name='tipoout' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span class='textbox-container'id='<%=idPortlet%>_cCODFISC_wrp'><input id='<%=idPortlet%>_cCODFISC' name='cCODFISC' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='cCODFISC' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<span id='<%=idPortlet%>_label38'  formid='<%=idPortlet%>' ps-name='label38'    class='label label38_ctrl'><div id='<%=idPortlet%>_label38tbl' style='width:100%;'><%=JSPLib.ToHTML("MacroAgente:")%></div></span>
<span id='<%=idPortlet%>_label38_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy'    class='label label38_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<span id='<%=idPortlet%>_label38_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy'    class='label label38_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Nome File:")%></div></span>
<span id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy_Copy_Copy'    class='label label38_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Estrazione:")%></div></span>
<span id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy_Copy_Copy_Copy'    class='label label38_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Output:")%></div></span>
<span id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy_Copy_Copy_Copy_Copy'    class='label label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Segno (fino al 31/12/2020):")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_Città'" ) );%>
<span id='<%=idPortlet%>_label10'  formid='<%=idPortlet%>' ps-name='label10'    class='label label10_ctrl'><div id='<%=idPortlet%>_label10tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Fiscale:")%></div></span>
<select id='<%=idPortlet%>_tipofile' name='tipofile' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<select id='<%=idPortlet%>_flgsegno' name='flgsegno' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span class='textbox-container'id='<%=idPortlet%>_desmag_wrp'><input id='<%=idPortlet%>_desmag' name='desmag' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='desmag' /></span>
<span class='textbox-container'id='<%=idPortlet%>_citnas_wrp'><input id='<%=idPortlet%>_citnas' name='citnas' type='text' maxlength='40' class='textbox' formid='<%=idPortlet%>' ps-name='citnas' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<span class='textbox-container'id='<%=idPortlet%>_stanas_wrp'><input id='<%=idPortlet%>_stanas' name='stanas' type='text' maxlength='40' class='textbox' formid='<%=idPortlet%>' ps-name='stanas' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<span class='textbox-container'id='<%=idPortlet%>_staben_wrp'><input id='<%=idPortlet%>_staben' name='staben' type='text' maxlength='40' class='textbox' formid='<%=idPortlet%>' ps-name='staben' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<span class='textbox-container'id='<%=idPortlet%>_cDIP_wrp'><input id='<%=idPortlet%>_cDIP' name='cDIP' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='cDIP' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zANADIP'" ) );%>
<span id='<%=idPortlet%>_label12'  formid='<%=idPortlet%>' ps-name='label12'    class='label label12_ctrl'><div id='<%=idPortlet%>_label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Città di Nascita:")%></div></span>
<span id='<%=idPortlet%>_label12_Copy'  formid='<%=idPortlet%>' ps-name='label12_Copy'    class='label label12_Copy_ctrl'><div id='<%=idPortlet%>_label12_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Stato di Nascita:")%></div></span>
<span id='<%=idPortlet%>_label12_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label12_Copy_Copy'    class='label label12_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label12_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Controparte:")%></div></span>
<span id='<%=idPortlet%>_label12_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label12_Copy_Copy_Copy'    class='label label12_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label12_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Stato di Destinazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_cMTCN_wrp'><input id='<%=idPortlet%>_cMTCN' name='cMTCN' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='cMTCN' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xdesdip_wrp'><input id='<%=idPortlet%>_xdesdip' name='xdesdip' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='xdesdip' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom13'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom13_Copy'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom13_Copy_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_datnas_wrp'><input id='<%=idPortlet%>_datnas' name='datnas' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='datnas' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dadata_wrp'><input id='<%=idPortlet%>_dadata' name='dadata' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='dadata' /></span>
<span class='textbox-container'id='<%=idPortlet%>_a_data_wrp'><input id='<%=idPortlet%>_a_data' name='a_data' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='a_data' /></span>
<span id='<%=idPortlet%>_label18'  formid='<%=idPortlet%>' ps-name='label18'    class='label label18_ctrl'><div id='<%=idPortlet%>_label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Data di Nascita:")%></div></span>
<span id='<%=idPortlet%>_label18_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy'    class='label label18_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_label18_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy_Copy'    class='label label18_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_label18_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy_Copy_Copy'    class='label label18_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("MTCN:")%></div></span>
<span id='<%=idPortlet%>_label18_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy_Copy_Copy_Copy'    class='label label18_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo:")%></div></span>
<span id='<%=idPortlet%>_label18_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy_Copy_Copy_Copy_Copy'    class='label label18_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Importo >=")%></div></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario19' class='calendar' onclick='window.<%=idPortlet%>.Calendario19.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario19_Copy' class='calendar' onclick='window.<%=idPortlet%>.Calendario19_Copy.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario19_Copy_Copy' class='calendar' onclick='window.<%=idPortlet%>.Calendario19_Copy_Copy.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='60' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<input id='<%=idPortlet%>_Upload' type='button' class='button Upload_ctrl'/>
<span class='textbox-container'id='<%=idPortlet%>_importo_wrp'><input id='<%=idPortlet%>_importo' name='importo' type='text' maxlength='15' class='textbox' formid='<%=idPortlet%>' ps-name='importo' data-sp-item-say-pict='999,999,999.99' data-sp-item-get-pict='999,999,999.99' data-sp-item-dec='2' inputmode='numeric' /></span>
<select id='<%=idPortlet%>_storico' name='storico' class='combobox' style=''></select>
<div id='<%=idPortlet%>_flgsto_div' style=''><input id='<%=idPortlet%>_flgsto' name='flgsto' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgsto' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Dati Storici Soggetto")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_destaben_wrp'><input id='<%=idPortlet%>_destaben' name='destaben' type='text' maxlength='60' class='textbox' formid='<%=idPortlet%>' ps-name='destaben' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
</div>
<div id='<%=idPortlet%>_page_2' class='pg_estrai_xls_page' style='display:none'>
<span id='<%=idPortlet%>_label2_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy_Copy_Copy_Copy'    class='label label2_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Stati destinazione")%></div></span>
<span id='<%=idPortlet%>_label2_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy_Copy_Copy_Copy_Copy'    class='label label2_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Province Agenzie")%></div></span>
<div id='<%=idPortlet%>_grdStati' formid='<%=idPortlet%>' ps-name='grdStati'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_grdProv' formid='<%=idPortlet%>' ps-name='grdProv'   class='grid' style=''>&nbsp;</div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrai_xls');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Batch",true)+","+JSPLib.ToJSValue(sp.translate("Batch"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegui",true)+","+JSPLib.ToJSValue(sp.translate("Esegui"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegui estrazione in modalità ritardata",true)+","+JSPLib.ToJSValue(sp.translate("Esegui estrazione in modalità ritardata"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegui estrazione in tempo reale",true)+","+JSPLib.ToJSValue(sp.translate("Esegui estrazione in tempo reale"),true)+");\n");
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
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/pg_estrai_xls_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Filtri Base"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate(" Filtri Aggiuntivi"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrai_xls',["800","800"],["425","560"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"425","title":"Filtri Base","layer":""},{"layout_steps_values":{},"w":"800","h":"560","title":" Filtri Aggiuntivi","layer":""}]);
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":137,"x":818,"y":209});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":345,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.mRoot=new ZtVWeb._VC(this,'mRoot',null,'character','<%=JSPLib.ToJSValue(mRoot,false,true)%>',false,false);
this.cartella=new ZtVWeb._VC(this,'cartella',null,'character','<%=JSPLib.ToJSValue(cartella,false,true)%>',false,false);
this.label2_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#FFF700","font_size":"11pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy_Copy_Copy_Copy","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":800,"x":0,"y":6,"zindex":"1"});
this.destfold=new ZtVWeb._VC(this,'destfold',null,'character','<%=JSPLib.ToJSValue(destfold,false,true)%>',false,false);
this.label2_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#FFF700","font_size":"11pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":800,"x":0,"y":263,"zindex":"1"});
this.ragben=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragben","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"60","name":"ragben","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragben,false,true)%>","w":450,"x":116,"y":116,"zerofilling":false,"zindex":"1","zoom":""});
this.mFileName=new ZtVWeb._VC(this,'mFileName',null,'character','<%=JSPLib.ToJSValue(mFileName,false,true)%>',false,false);
this.selectedValues=new ZtVWeb._VC(this,'selectedValues',null,'character','<%=JSPLib.ToJSValue(selectedValues,false,true)%>',false,false);
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_start_estrai_xls",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"mcParam=mcParametri","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_start_estrai_xls","target":"","type":"SPLinker","w":125,"x":980,"y":180});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_start_estrai_xls",request.getSession())%>';
this.RTCreaMC=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCreaMC","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCreaMC","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_creamc","target":"","type":"SPLinker","w":92,"x":1000,"y":-79});
this.RTCreaMC.m_cID='<%=JSPLib.cmdHash("routine,arfn_creamc",request.getSession())%>';
this.mcParametri=new ZtVWeb.MemoryCursorCtrl(this,'mcParametri','<%=idPortlet%>_mcParametri','','','','','false');
this.grdStati=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true-selectAll","checkbox_fields":"CODICE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdStati","dataobj":"SQLStati","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":237,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grdStati","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":799,"x":0,"y":25,"zindex":""});
this.grdStati.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DESCRI","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.grdProv=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true-selectAll","checkbox_fields":"CODICE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdProv","dataobj":"SQLProv","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":237,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grdProv","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":799,"x":0,"y":282,"zindex":""});
this.grdProv.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Provincia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODICE","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.SQLStati=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbstati","cmdHash":"<%=JSPLib.cmdHash("qbe_tbstati",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLStati","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLStati","nrows":"10","page":2,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":-3,"y":-68});
this.SQLProv=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_provage","cmdHash":"<%=JSPLib.cmdHash("qbe_provage",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLProv","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLProv","nrows":"10","page":2,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":137,"y":-68});
this.connes=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_connes","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"connes","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(connes,false,true)%>","w":131,"x":116,"y":6,"zerofilling":false,"zindex":"1","zoom":""});
this.label15=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlid":"<%=idPortlet%>_label15","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label15","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label15,false,true)%>","type":"Label","w":111,"x":3,"y":9,"zindex":"1"});
this.label15_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label15_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label15_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label15_Copy,false,true)%>","type":"Label","w":111,"x":3,"y":38,"zindex":"1"});
this.LinkZoom16=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom16","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrai_xls_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"connes,ragosc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrai_xls_portlet.jspLinkZoom16",request.getSession())%>","linkedField":"connes","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom16","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":247,"y":6,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.flgncf=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgncf","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":false,"layout_steps_values":{},"name":"flgncf","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":13,"x":642,"y":60,"zindex":"1"});
this.flgncf.Value('<%=flgncf%>');
this.flgmese=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgmese","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":false,"layout_steps_values":{},"name":"flgmese","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":13,"x":642,"y":174,"zindex":"1"});
this.flgmese.Value('<%=flgmese%>');
this.opesel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_opesel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":false,"layout_steps_values":{},"name":"opesel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":13,"x":116,"y":291,"zindex":"1"});
this.opesel.Value('<%=opesel%>');
this.frzsel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_frzsel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":false,"layout_steps_values":{},"name":"frzsel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":13,"x":211,"y":291,"zindex":"1"});
this.frzsel.Value('<%=frzsel%>');
this.attive=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_attive","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"","layer":false,"layout_steps_values":{},"name":"attive","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":13,"x":350,"y":291,"zindex":"1"});
this.attive.Value('<%=attive%>');
this.label21_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"flgncf","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label21_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":13,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label21_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label21_Copy,false,true)%>","type":"Label","w":112,"x":661,"y":64,"zindex":"1"});
this.label21_Copy_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"flgmese","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label21_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":13,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label21_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label21_Copy_Copy,false,true)%>","type":"Label","w":139,"x":661,"y":177,"zindex":"1"});
this.label21_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"opesel","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label21_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":13,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label21_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label21_Copy_Copy_Copy,false,true)%>","type":"Label","w":61,"x":135,"y":295,"zindex":"1"});
this.label21_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"frzsel","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label21_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":13,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label21_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label21_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":61,"x":230,"y":295,"zindex":"1"});
this.label21_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"attive","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label21_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":13,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label21_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label21_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":116,"x":369,"y":295,"zindex":"1"});
this.ragosc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragosc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"ragosc","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragosc,false,true)%>","w":426,"x":116,"y":33,"zerofilling":false,"zindex":"1","zoom":""});
this.codmag=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codmag","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"codmag","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codmag,false,true)%>","w":47,"x":116,"y":204,"zerofilling":false,"zindex":"1","zoom":""});
this.tipoout=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipoout","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipoout%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipoout","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Excel,Testo,Database con Azzeramento,Database in Accodamento,CSV","type":"Combobox","typevar":"character","valuelist":"E,T,Z,D,C","visible":true,"w":275,"x":117,"y":316,"zindex":"1"});
this.cCODFISC=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cCODFISC","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"cCODFISC","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cCODFISC,false,true)%>","w":139,"x":640,"y":33,"zerofilling":false,"zindex":"1","zoom":""});
this.label38=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38,false,true)%>","type":"Label","w":69,"x":45,"y":210,"zindex":"1"});
this.label38_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy,false,true)%>","type":"Label","w":69,"x":45,"y":238,"zindex":"1"});
this.label38_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy,false,true)%>","type":"Label","w":69,"x":45,"y":268,"zindex":"1"});
this.label38_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":111,"x":1,"y":291,"zindex":"1"});
this.label38_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":111,"x":1,"y":320,"zindex":"1"});
this.label38_Copy_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":186,"x":416,"y":320,"zindex":"1"});
this.Città=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_Città","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrai_xls_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"codmag,desmag","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrai_xls_portlet.jspCittà",request.getSession())%>","linkedField":"codmag","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"Città","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbmacage,default",request.getSession())%>","suggest":false,"table":"tbmacage","type":"LinkZoom","w":20,"x":163,"y":204,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("MacroAgenti"),false,true)%>"});
this.label10=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label10","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":14,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label10","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label10,false,true)%>","type":"Label","w":88,"x":550,"y":40,"zindex":"1"});
this.tipofile=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipofile","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipofile%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipofile","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"MTCN,C.F.","type":"Combobox","typevar":"character","valuelist":"1,2","visible":true,"w":103,"x":692,"y":263,"zindex":"1"});
this.flgsegno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_flgsegno","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=flgsegno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"flgsegno","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Segno Avere = SEND,Segno Dare = SEND","type":"Combobox","typevar":"character","valuelist":"1,2","visible":true,"w":191,"x":604,"y":316,"zindex":"1"});
this.desmag=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_desmag","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"desmag","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(desmag,false,true)%>","w":370,"x":193,"y":204,"zerofilling":false,"zindex":"1","zoom":""});
this.citnas=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_citnas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"40","name":"citnas","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(citnas,false,true)%>","w":300,"x":116,"y":60,"zerofilling":false,"zindex":"1","zoom":""});
this.stanas=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_stanas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"40","name":"stanas","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(stanas,false,true)%>","w":300,"x":116,"y":88,"zerofilling":false,"zindex":"1","zoom":""});
this.staben=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_staben","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"40","name":"staben","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(staben,false,true)%>","w":37,"x":116,"y":144,"zerofilling":false,"zindex":"1","zoom":""});
this.cDIP=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cDIP","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"cDIP","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cDIP,false,true)%>","w":57,"x":116,"y":234,"zerofilling":false,"zindex":"1","zoom":""});
this.zANADIP=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zANADIP","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrai_xls_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"cDIP,xdesdip","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrai_xls_portlet.jspzANADIP",request.getSession())%>","linkedField":"cDIP","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zANADIP","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":173,"y":234,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Agenzie"),false,true)%>"});
this.label12=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label12,false,true)%>","type":"Label","w":111,"x":3,"y":64,"zindex":"1"});
this.label12_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label12_Copy,false,true)%>","type":"Label","w":98,"x":16,"y":92,"zindex":"1"});
this.label12_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label12_Copy_Copy,false,true)%>","type":"Label","w":98,"x":16,"y":121,"zindex":"1"});
this.label12_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label12_Copy_Copy_Copy,false,true)%>","type":"Label","w":111,"x":3,"y":149,"zindex":"1"});
this.cMTCN=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cMTCN","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"cMTCN","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cMTCN,false,true)%>","w":85,"x":640,"y":234,"zerofilling":false,"zindex":"1","zoom":""});
this.xdesdip=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xdesdip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"xdesdip","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xdesdip,false,true)%>","w":370,"x":203,"y":234,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom13=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom13","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrai_xls_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"citnas","intovarsType":"C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrai_xls_portlet.jspLinkZoom13",request.getSession())%>","linkedField":"citnas","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom13","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CITTA","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbcitta,default",request.getSession())%>","suggest":false,"table":"tbcitta","type":"LinkZoom","w":20,"x":416,"y":60,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Città"),false,true)%>"});
this.LinkZoom13_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom13_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrai_xls_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"stanas","intovarsType":"C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrai_xls_portlet.jspLinkZoom13_Copy",request.getSession())%>","linkedField":"stanas","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom13_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbstati,default",request.getSession())%>","suggest":false,"table":"tbstati","type":"LinkZoom","w":20,"x":416,"y":88,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Stati"),false,true)%>"});
this.LinkZoom13_Copy_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom13_Copy_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrai_xls_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"staben,destaben","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrai_xls_portlet.jspLinkZoom13_Copy_Copy",request.getSession())%>","linkedField":"staben","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom13_Copy_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,tbstati,default",request.getSession())%>","suggest":false,"table":"tbstati","type":"LinkZoom","w":20,"x":154,"y":144,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Stati"),false,true)%>"});
this.datnas=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_datnas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"datnas","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=datnas%>","w":81,"x":640,"y":89,"zerofilling":false,"zindex":"1","zoom":""});
this.dadata=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dadata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"dadata","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dadata%>","w":81,"x":116,"y":174,"zerofilling":false,"zindex":"1","zoom":""});
this.a_data=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"a_data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=a_data%>","w":81,"x":345,"y":174,"zerofilling":false,"zindex":"1","zoom":""});
this.label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18,false,true)%>","type":"Label","w":95,"x":543,"y":92,"zindex":"1"});
this.label18_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy,false,true)%>","type":"Label","w":111,"x":3,"y":179,"zindex":"1"});
this.label18_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy_Copy,false,true)%>","type":"Label","w":111,"x":231,"y":179,"zindex":"1"});
this.label18_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy_Copy_Copy,false,true)%>","type":"Label","w":40,"x":598,"y":238,"zindex":"1"});
this.label18_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":35,"x":655,"y":268,"zindex":"1"});
this.label18_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":76,"x":562,"y":210,"zindex":"1"});
this.Calendario19=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario19','Calendario19',721,89,20,20,'Verdana','10','top-left(%)-right(%)','true','datnas',{});
this.Calendario19_Copy=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario19_Copy','Calendario19_Copy',197,174,20,20,'Verdana','10','top-left(%)-right(%)','true','dadata',{});
this.Calendario19_Copy_Copy=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario19_Copy_Copy','Calendario19_Copy_Copy',426,174,20,20,'Verdana','10','top-left(%)-right(%)','true','a_data',{});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"60","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":457,"x":116,"y":264,"zerofilling":false,"zindex":"1","zoom":""});
this.Upload=new ZtVWeb._BC(this,{"anchor":"top-left(%)-right(%)","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button Upload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Upload","edit_undercond":"","font":"Verdana","font_color":"#000000","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Upload","page":1,"spuid":"","tabindex":"","text":"Seleziona","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":573,"y":264,"zindex":"1"});
this.lProv=new ZtVWeb._VC(this,'lProv',null,'character','<%=JSPLib.ToJSValue(lProv,false,true)%>',false,false);
this.lStati=new ZtVWeb._VC(this,'lStati',null,'character','<%=JSPLib.ToJSValue(lStati,false,true)%>',false,false);
this.tipoelab=new ZtVWeb._VC(this,'tipoelab',null,'character','<%=JSPLib.ToJSValue(tipoelab,false,true)%>',false,false);
this.RTListe=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTListe","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTListe","offline":false,"page":2,"parms":"mcStringa=selectedValues","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_selezione","target":"","type":"SPLinker","w":106,"x":827,"y":-13});
this.RTListe.m_cID='<%=JSPLib.cmdHash("routine,arfn_selezione",request.getSession())%>';
this.cdadata=new ZtVWeb._VC(this,'cdadata',null,'character','<%=JSPLib.ToJSValue(cdadata,false,true)%>',false,false);
this.c_adata=new ZtVWeb._VC(this,'c_adata',null,'character','<%=JSPLib.ToJSValue(c_adata,false,true)%>',false,false);
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.mDirectory=new ZtVWeb._VC(this,'mDirectory',null,'character','<%=JSPLib.ToJSValue(mDirectory,false,true)%>',false,false);
this.importo=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_importo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"15","name":"importo","page":1,"picker":"","picture":"999,999,999.99","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=importo%>","w":112,"x":641,"y":204,"zerofilling":false,"zindex":"1","zoom":""});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":120,"x":1002,"y":-43});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":1062,"y":93});
this.storico=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_storico","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=storico%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"storico","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Storico Soggetti per Data Operazione,Storico Soggetti per Data Registrazione","type":"Combobox","typevar":"character","valuelist":"O,S","visible":true,"w":340,"x":446,"y":6,"zindex":"2"});
this.flgsto=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgsto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Dati Storici Soggetto","layer":false,"layout_steps_values":{},"name":"flgsto","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":154,"x":288,"y":6,"zindex":"3"});
this.flgsto.Value('<%=flgsto%>');
this.destaben=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_destaben","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"60","name":"destaben","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(destaben,false,true)%>","w":449,"x":182,"y":144,"zerofilling":false,"zindex":"1","zoom":""});
this.RTCopia=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_copy_file_appo",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCopia","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCopia","offline":false,"page":1,"parms":"pNomeFile=filename,pCartella=cartella","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_copy_file_appo","target":"","type":"SPLinker","w":127,"x":1136,"y":16});
this.RTCopia.m_cID='<%=JSPLib.cmdHash("routine,arfn_copy_file_appo",request.getSession())%>';
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
<%if(request.getAttribute("pg_estrai_xls_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrai_xls_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrai_xls_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLStati.firstQuery('true');
window.<%=idPortlet%>.SQLProv.firstQuery('true');
window.<%=idPortlet%>.tipoout.FillData();
window.<%=idPortlet%>.tipofile.FillData();
window.<%=idPortlet%>.flgsegno.FillData();
window.<%=idPortlet%>.storico.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrai_xls',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrai_xls');
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
sp.endPage("pg_estrai_xls");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom16")) {
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
if (Library.eq(p_cControlName,"Città")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbmacage";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"MACODICE", "MADESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"zANADIP")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 2;
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
if (Library.eq(p_cControlName,"LinkZoom13")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbcitta";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CITTA"};
  result.m_rdTypes = new String[]{"C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom13_Copy")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbstati";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"DESCRI"};
  result.m_rdTypes = new String[]{"C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom13_Copy_Copy")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbstati";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODSTA", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "1406313799"; } %>