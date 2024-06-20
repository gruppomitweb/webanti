<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Estrazione AUI (Allegato 2 - 380)\",true)\n  this.tipocr.Value(this.gTipInter.Value());\n  this.codcr.Value(this.gIntemediario.Value())\n  this.gToolbar(\"S\");\n}\n\nfunction btnExec_Click(){\n  if (confirm(\"Confermi la generazione del file 380?\")) {\n    this.gToolbar(\"D\");\n    this.gTimer('S');    \n    this.ChgDate()\n    this.RTExec.Link();  \n  }  \n}\n\nfunction btnSched_Click(){\n  if (confirm(\"Confermi la schdulazione della generazione del file 380?\")) {\n    this.gToolbar(\"D\");\n    this.gTimer('S');    \n    this.ChgDate()\n    this.RTSched.Link();  \n  }  \n}\n\nfunction RTExec_Executed(result,cError){\n  this.gTimer('E')   \n  if(result=='KO'){\n    this.gToolbar(\"S\");\n    alert(\"Elaborazione non completata! Contattare assistenza\");  \n  } else {\n    if(this.flgchk.Value()=='N'){\n      this.gToolbar(\"E\");\n    }  \n    this.filename.Value(result)\n    alert(\"Elaborazione Completata con successo!\");  \n  }     \n}\n\nfunction RTSched_Executed(result,cError){\n  this.gTimer('E')   \n  if(result=='KO'){\n    this.gToolbar(\"S\");\n    alert(\"Schedulazione non completata! Contattare assistenza\");        \n  } else {\n    alert(\"Schedulazione Completata con successo!\");    \n  }     \n}\n\nfunction btnDown_Click(){\n  this.RTDownload.Link()  \n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction gTimer(_func) {\n if(_func=='S') { \n    this.PortletLogs.Start();       \n } else {\n    this.PortletLogs.Stop();           \n }  \n}  \n\nfunction gToolbar(status) {  \n  if(status==\"E\") {\n    this.getTitlePortlet().AppendButton({\n      id:\"Scarica\",\n      title:FormatMsg('Download'),\n      tooltip:FormatMsg('Scarica il file 380'),\n      image:{ fontFamily:'icons8_win10', value: \"&#xece6;\"},\n      action:'javascript:' + this.formid +'.btnDown_Click()'\n    },1);  \n  }  \n  if(status==\"S\" || status==\"E\") {\n    this.getTitlePortlet().AppendButton({\n      id:\"Schedula\",\n      title:FormatMsg('Schedula'),\n      tooltip:FormatMsg('Schedula la creazione del file 380'),\n      image:{ fontFamily:'icons8_win10', value: \"&#xe973;\"},\n      action:'javascript:' + this.formid +'.btnSched_Click()'\n   },1);   \n  this.getTitlePortlet().AppendButton({\n      id:\"Esegui\",\n      title:FormatMsg('Esegui'),\n      tooltip:FormatMsg('Crea il file 380'),\n      image:{ fontFamily:'icons8_win10', value: \"&#xebe1;\"},\n      action:'javascript:' + this.formid +'.btnExec_Click()'\n   },2);       \n  }     \n  if(status=='D') {\n    this.getTitlePortlet().RemoveButton(\"Scarica\");\n    this.getTitlePortlet().RemoveButton(\"Schedula\");\n    this.getTitlePortlet().RemoveButton(\"Esegui\");\n  }     \n}  \n\nfunction ChgDate() {\n  this.daope.Value(DateToChar(this.DaData.Value()));\n  this.a_ope.Value(DateToChar(this.AData.Value()));\n  this.dareg.Value(DateToChar(this.DaDataReg.Value()));\n  this.a_reg.Value(DateToChar(this.ADataReg.Value()));  \n}  ","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Preparazione file per Check Scarico OffLine","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lblDaCli }}{{ @ADataReg }}{{ @flgfrz }}{{ @lblDaOpe_Copy }}{{ @lblTipoDAti }}{{ @lblAOpe_Copy }}{{ @codcli }}{{ @tipoarchd }}{{ @stoper }}{{ @zDaCli_Copy }}{{ @tipoarchp }}{{ @flgrae }}{{ @ragsoc }}{{ @pLog }}{{ @lblArchivi }}{{ @tiprap }}{{ @ragben }}{{ @pMsg }}{{ @flgope }}{{ @flgrap }}{{ @lblControparte }}{{ @flgtit }}{{ @DaData }}{{ @AData }}{{ @tiptit }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @flgdel }}{{ @flgsto }}{{ @tipocr }}{{ @lblTipocr }}{{ @flgint }}{{ @codcr }}{{ @flgchk }}{{ @lblCodcr }}{{ @lblDatiInvio }}{{ @flgxls }}{{ @lblDati_Copy }}{{ @codage }}{{ @lblCAgenzia }}{{ @LinkZoom55 }}{{ @desage }}{{ @DaDataReg }}{{ @allsto }}{{ @multifile }}{{ @flg2020 }}{{ @lblDaCli }}{{ @ADataReg }}{{ @flgfrz }}{{ @lblDaOpe_Copy }}{{ @lblTipoDAti }}{{ @lblAOpe_Copy }}{{ @codcli }}{{ @tipoarchd }}{{ @stoper }}{{ @zDaCli_Copy }}{{ @tipoarchp }}{{ @flgrae }}{{ @ragsoc }}{{ @lblArchivi }}{{ @tiprap }}{{ @ragben }}{{ @flgope }}{{ @flgrap }}{{ @lblControparte }}{{ @flgtit }}{{ @DaData }}{{ @AData }}{{ @tiptit }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @flgdel }}{{ @flgsto }}{{ @tipocr }}{{ @lblTipocr }}{{ @flgint }}{{ @codcr }}{{ @flgchk }}{{ @lblCodcr }}{{ @lblDatiInvio }}{{ @flgxls }}{{ @lblDati_Copy }}{{ @codage }}{{ @lblCAgenzia }}{{ @LinkZoom55 }}{{ @desage }}{{ @DaDataReg }}{{ @allsto }}{{ @multifile }}{{ @flg2020 }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"545","hsl":"false","htmlcode":"{{ @PortletLogs }} \n{{ @flg2020 }} \n\n\n{{ @multifile }}\n{{ @allsto }}\n{{ @DaDataReg }}\n{{ @desage }}\n{{ @LinkZoom55 }}\n{{ @lblCAgenzia }}\n{{ @codage }}\n{{ @lblDati_Copy }}\n{{ @flgxls }}\n{{ @lblDatiInvio }}\n{{ @lblCodcr }}\n{{ @flgchk }}\n{{ @codcr }}\n{{ @flgint }}\n{{ @lblTipocr }}\n{{ @tipocr }}\n{{ @flgsto }}\n{{ @flgdel }}\n{{ @lblAOpe }}\n{{ @lblDaOpe }}\n{{ @tiptit }}\n{{ @AData }}\n{{ @DaData }}\n{{ @flgtit }}\n{{ @lblControparte }}\n{{ @flgrap }}\n{{ @flgope }}\n\n{{ @ragben }}\n{{ @tiprap }}\n{{ @lblArchivi }}\n\n{{ @ragsoc }}\n{{ @flgrae }}\n{{ @tipoarchp }}\n{{ @zDaCli_Copy }}\n{{ @stoper }}\n{{ @tipoarchd }}\n{{ @codcli }}\n{{ @lblAOpe_Copy }}\n{{ @lblTipoDAti }}\n{{ @lblDaOpe_Copy }}\n{{ @flgfrz }}\n{{ @ADataReg }}\n{{ @lblDaCli }}\n{{ multifile }}\n{{ allsto }}\n{{ RTScarica }}\n{{ ADataReg }}\n{{ flgfrz }}\n{{ lblTipoDAti }}{{ gUrlApp }}\n{{ lblAOpe_Copy }}\n{{ flgrae }}{{ gPathDoc }}\n{{ flgope }}\n{{ tiptit }}{{ gAzienda }}\n{{ flgdel }}\n{{ flgsto }}{{ cUrl }}\n{{ flgint }}\n{{ flgchk }}\n{{ flgxls }}\n{{ gWebCHK }}\n{{ DaDataReg }}\n{{ tipoarchp }}{{ RTDownload }}\n{{ lblArchivi }}\n{{ codcli }}\n{{ zDaCli_Copy }}\n{{ ragben }}\n{{ lblControparte }}\n{{ lblCAgenzia }}\n{{ ragsoc }}\n{{ DaCodCli }}\n{{ zDaCli }}\n{{ DaRagSoc }}\n{{ lblDaCli }}\n{{ flgstorico }}\n{{ btnEle2 }}\n{{ btnExit }}\n{{ ftypes }}\n{{ RTEsci }}\n{{ RTExec }}\n{{ pLog }}\n{{ pMsg }}{{ tipoarchd }}\n{{ anno }}\n{{ lblAnno }}\n{{ mese }}{{ codage }}{{ desage }}\n{{ lblMese }}{{ fmodels }}{{ LinkZoom55 }}\n{{ RTClean }}\n{{ DaData }}{{ Label53 }}\n{{ AData }}\n{{ lblDaOpe }}\n{{ lblAOpe }}\n{{ iPrint }}\n{{ gIntemediario }}\n{{ SQLTipo }}\n{{ tipocr }}\n{{ lblTipocr }}\n{{ gTipInter }}\n{{ codcr }}\n{{ btnEle1 }}\n{{ btnRep2 }}\n{{ RTVerifica2 }}\n{{ lblCodcr }}\n{{ lblDatiInvio }}\n{{ datinv }}\n{{ numinv }}\n{{ lblDatInv }}\n{{ lblNumInv }}\n{{ lblDati_Copy }}\n{{ btnExec }}\n{{ gDescAzi }}\n{{ RTStampaNeg }}\n{{ c_dadate }}\n{{ c_adate }}\n{{ RTDownload }}\n{{ btnDown }}\n{{ RTElenco1 }}\n{{ RTVerifica1 }}\n{{ RTElenco2 }}\n{{ btnRep1 }}\n{{ RTSElencoNeg }}\n{{ RTRElenco1 }}\n{{ RTRElenco2 }}\n{{ RTStampa2 }}\n{{ RTStampa1 }}\n{{ flgfrazionate }}\n{{ lblDaOpe_Copy }}{{ stoper }}{{ flgrap }}{{ tiprap }}{{ flgtit }}","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"LibreriaMit.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"545\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaCli","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NDG Cliente:","w":"137","wireframe_props":"align,value,n_col","x":"3","y":"146","zindex":"5","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"465","zindex":"3","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADataReg","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"409","y":"223","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Frazionate","layer":"false","layout_steps_values":"{}","name":"flgfrz","page":"1","rapp":"","sequence":"4","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"162","wireframe_props":"label_text","x":"319","y":"275","zindex":"23","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Registrazione:","w":"129","wireframe_props":"align,value,n_col","x":"11","y":"224","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipoDAti","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipologia Dati:","w":"129","wireframe_props":"align,value,n_col","x":"11","y":"276","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Registrazione:","w":"129","wireframe_props":"align,value,n_col","x":"278","y":"224","zindex":"1","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"codcli","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"144","wireframe_props":"name","x":"143","y":"145","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Definitivi (A.U.I.)","layer":"false","layout_steps_values":"{}","name":"tipoarchd","page":"1","rapp":"","sequence":"9","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"162","wireframe_props":"label_text","x":"143","y":"249","zindex":"23","zone":""},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"R","layer":"false","layout_steps_values":"{}","name":"stoper","page":"1","picture":"","rapp":"","sequence":"10","spuid":"","tabindex":"","textlist":"Storico Soggetti per Data Registrazione,Storico Soggetti per Data Operazione","type":"Combobox","typevar":"character","valuelist":"R,O","visible":"true","w":"393","wireframe_props":"name,textlist","x":"607","y":"275","zindex":"13","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"codcli,ragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"codcli","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"zDaCli_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"11","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"289","y":"145","zindex":"6","zone":"","zoomtitle":""},{"allowedentities":"arrt_chkdiana_all","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_codinter=codcr,w_tipinter=tipocr,w_codage=codage,w_codcli=codcli,w_ragben=ragben,daope=daope,a_ope=a_ope,dareg=dareg,a_reg=a_reg,w_tipoarchd=tipoarchd,w_tipoarchp=tipoarchp,w_stoper=stoper,w_flgope=flgope,w_flgfrz=flgfrz,w_flgrae=flgrae,w_flgrap=flgrap,w_tiprap=tiprap,w_flgtit=flgtit,w_tiptit=tiptit,w_flgint=flgint,w_flgdel=flgdel,w_flgchk=flgchk,w_flgxls=flgxls,w_flgsto=flgsto,w_allsto=allsto,w_multifile=multifile,w_flg2020=flg2020","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arrt_chkdiana_all","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Provvisori","layer":"false","layout_steps_values":"{}","name":"tipoarchp","page":"1","rapp":"","sequence":"13","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"162","wireframe_props":"label_text","x":"319","y":"249","zindex":"23","zone":""},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"A","layer":"false","layout_steps_values":"{}","name":"flgrae","page":"1","picture":"","rapp":"","sequence":"14","spuid":"","tabindex":"","textlist":"Utilizza Codifica RAE,Utilizza Codifica Ateco","type":"Combobox","typevar":"character","valuelist":"R,A","visible":"true","w":"393","wireframe_props":"name,textlist","x":"607","y":"249","zindex":"13","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"ragsoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"477","wireframe_props":"name","x":"313","y":"145","zerofilling":"false","zindex":"7","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblArchivi","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipologia Archivi:","w":"129","wireframe_props":"align,value,n_col","x":"10","y":"250","zindex":"1","zone":""},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"flgrap='S'","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"R","layer":"false","layout_steps_values":"{}","name":"tiprap","page":"1","picture":"","rapp":"","sequence":"17","spuid":"","tabindex":"","textlist":"Rapporti attivi nel periodo,Rapporti attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Rapporti per il periodo","type":"Combobox","typevar":"character","valuelist":"1,2,3,9","visible":"true","w":"393","wireframe_props":"name,textlist","x":"607","y":"301","zindex":"13","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"ragben","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"477","wireframe_props":"name","x":"143","y":"171","zerofilling":"false","zindex":"7","zone":"","zoom":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Operazioni","layer":"false","layout_steps_values":"{}","name":"flgope","page":"1","rapp":"","sequence":"19","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"162","wireframe_props":"label_text","x":"143","y":"275","zindex":"23","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Solo Rapporti attivi nell'intervallo di date selezionato","layer":"false","layout_steps_values":"{}","name":"flgrap","page":"1","rapp":"","sequence":"20","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"143","y":"301","zindex":"23","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblControparte","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Controparte:","w":"137","wireframe_props":"align,value,n_col","x":"3","y":"171","zindex":"5","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Solo Legami attivi nell'intervallo di date selezionato","layer":"false","layout_steps_values":"{}","name":"flgtit","page":"1","rapp":"","sequence":"23","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"143","y":"327","zindex":"23","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaData","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"24","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"143","y":"197","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"AData","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"409","y":"197","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"flgtit='S'","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"R","layer":"false","layout_steps_values":"{}","name":"tiptit","page":"1","picture":"","rapp":"","sequence":"26","spuid":"","tabindex":"","textlist":"Legami attivi nel periodo,Legami attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Legami per il periodo","type":"Combobox","typevar":"character","valuelist":"1,2,3,9","visible":"true","w":"393","wireframe_props":"name,textlist","x":"607","y":"327","zindex":"13","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"11","y":"198","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"28","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"278","y":"198","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Inserire Delegati in registrazioni 31 e 32","layer":"false","layout_steps_values":"{}","name":"flgdel","page":"1","rapp":"","sequence":"29","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"607","y":"353","zindex":"23","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gIntemediario","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"264","y":"-63"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"100","name":"SQLTipo","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tbtipint","query_async":"false","return_fields_type":"true","sequence":"31","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"666","y":"-61"},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Scrivere anche Cancellate e Modificate","layer":"false","layout_steps_values":"{}","name":"flgsto","page":"1","rapp":"","sequence":"32","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"143","y":"405","zindex":"23","zone":""},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLTipo","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipocr","page":"1","picture":"","rapp":"","sequence":"33","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"TIPOINT","visible":"true","w":"585","wireframe_props":"name,textlist","x":"142","y":"29","zindex":"13","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipocr","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"34","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Intermediario:","w":"129","wireframe_props":"align,value,n_col","x":"11","y":"32","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Ripeti dati intestatario per ogni informazione","layer":"false","layout_steps_values":"{}","name":"flgint","page":"1","rapp":"","sequence":"35","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"143","y":"353","zindex":"23","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gTipInter","page":"1","reactive":"","sequence":"36","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"397","y":"-62"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"codcr","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"37","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"142","y":"59","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"gWebCHK='N'","init":"","init_par":"N","label_text":"Scrittura diretta su WEBCHK","layer":"false","layout_steps_values":"{}","name":"flgchk","page":"1","rapp":"","sequence":"38","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"143","y":"379","zindex":"23","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblCodcr","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice:","w":"129","wireframe_props":"align,value,n_col","x":"11","y":"61","zindex":"1","zone":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDatiInvio","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"40","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Dati Centro Servizi","w":"200","wireframe_props":"align,value,n_col","x":"6","y":"4","zindex":"19","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Scrittura 380 su Excel (XLSX)","layer":"false","layout_steps_values":"{}","name":"flgxls","page":"1","rapp":"","sequence":"41","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"607","y":"379","zindex":"23","zone":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDati_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"42","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Dati Invio","w":"200","wireframe_props":"align,value,n_col","x":"6","y":"89","zindex":"19","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gWebCHK","page":"1","reactive":"","sequence":"43","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"798","y":"-62"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"44","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"531","y":"-63"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"codage","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"45","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"79","wireframe_props":"name","x":"143","y":"119","zerofilling":"false","zindex":"20","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblCAgenzia","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"46","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia\u002fDipendenza:","w":"129","wireframe_props":"align,value,n_col","x":"11","y":"120","zindex":"1","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"codage,desage","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"codage","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom55","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"47","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"225","y":"120","zindex":"21","zone":"","zoomtitle":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"35","name":"desage","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"48","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"262","wireframe_props":"name","x":"254","y":"119","zerofilling":"false","zindex":"22","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDataReg","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"49","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"143","y":"223","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cUrl","page":"1","reactive":"","sequence":"50","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1070","y":"-23"},{"allowedentities":"arfn_downloadfile_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTScarica","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella,pTipo=tipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"51","servlet":"arfn_downloadfile_doc","target":"","type":"SPLinker","w":"127","x":"1066","y":"-71"},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"true","init":"","init_par":"N","label_text":"Riportare tutte le modifiche (Stato 3)","layer":"false","layout_steps_values":"{}","name":"allsto","page":"1","rapp":"","sequence":"52","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"612","y":"86","zindex":"23","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Scrivi lo scarico su più file","layer":"false","layout_steps_values":"{}","name":"multifile","page":"1","rapp":"","sequence":"53","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"373","wireframe_props":"label_text","x":"607","y":"405","zindex":"23","zone":""},{"allowedentities":"arrt_chkdiana_sched","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTSched","offline":"false","page":"1","parms":"w_codinter=codcr,w_tipinter=tipocr,w_codage=codage,w_codcli=codcli,w_ragben=ragben,daope=daope,a_ope=a_ope,dareg=dareg,a_reg=a_reg,w_tipoarchd=tipoarchd,w_tipoarchp=tipoarchp,w_stoper=stoper,w_flgope=flgope,w_flgfrz=flgfrz,w_flgrae=flgrae,w_flgrap=flgrap,w_tiprap=tiprap,w_flgtit=flgtit,w_tiptit=tiptit,w_flgint=flgint,w_flgdel=flgdel,w_flgchk=flgchk,w_flgxls=flgxls,w_flgsto=flgsto,w_allsto=allsto,w_multifile=multifile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"54","servlet":"arrt_chkdiana_sched","target":"","type":"SPLinker","w":"75","x":"1065","y":"8"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"daope","page":"1","reactive":"","sequence":"55","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1072","y":"59"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"a_ope","page":"1","reactive":"","sequence":"56","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1072","y":"87"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dareg","page":"1","reactive":"","sequence":"57","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1066","y":"119"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"a_reg","page":"1","reactive":"","sequence":"58","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1065","y":"146"},{"allowedentities":"DownloadFileServlet","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"59","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":"120","x":"1059","y":"173"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"60","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1065","y":"205"},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Genera il tracciato nella modalità 2020 (Informazioni aggiuntive)","layer":"false","layout_steps_values":"{}","name":"flg2020","page":"1","rapp":"","sequence":"61","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"454","wireframe_props":"label_text","x":"143","y":"431","zindex":"23","zone":""}]%>
<%/*Description:Preparazione file per Check Scarico OffLine*/%>
<%/*ParamsRequest:codcli*/%>
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
window.pg_chkdiana_all_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnExec_Click !='undefined')this.btnExec_Click=btnExec_Click;
if(typeof btnSched_Click !='undefined')this.btnSched_Click=btnSched_Click;
if(typeof RTExec_Executed !='undefined')this.RTExec_Executed=RTExec_Executed;
if(typeof RTSched_Executed !='undefined')this.RTSched_Executed=RTSched_Executed;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof gTimer !='undefined')this.gTimer=gTimer;
if(typeof gToolbar !='undefined')this.gToolbar=gToolbar;
if(typeof ChgDate !='undefined')this.ChgDate=ChgDate;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.gWebCHK.Value(),'N'),this.flgchk);
ZtVWeb.HideCtrl(true,this.allsto);
}
this.this_EditUnderCondition=function(){
ZtVWeb.EditCtrl(Eq(this.flgrap.Value(),'S'),this.tiprap);
ZtVWeb.EditCtrl(Eq(this.flgtit.Value(),'S'),this.tiptit);
}
this.zDaCli_Copy.addObserverFixedVars();
this.SQLTipo.addRowConsumer(this.tipocr);
this.LinkZoom55.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Estrazione AUI (Allegato 2 - 380)",true)
  this.tipocr.Value(this.gTipInter.Value());
  this.codcr.Value(this.gIntemediario.Value())
  this.gToolbar("S");
}
function btnExec_Click(){
  if (confirm("Confermi la generazione del file 380?")) {
    this.gToolbar("D");
    this.gTimer('S');    
    this.ChgDate()
    this.RTExec.Link();  
  }  
}
function btnSched_Click(){
  if (confirm("Confermi la schdulazione della generazione del file 380?")) {
    this.gToolbar("D");
    this.gTimer('S');    
    this.ChgDate()
    this.RTSched.Link();  
  }  
}
function RTExec_Executed(result,cError){
  this.gTimer('E')   
  if(result=='KO'){
    this.gToolbar("S");
    alert("Elaborazione non completata! Contattare assistenza");  
  } else {
    if(this.flgchk.Value()=='N'){
      this.gToolbar("E");
    }  
    this.filename.Value(result)
    alert("Elaborazione Completata con successo!");  
  }     
}
function RTSched_Executed(result,cError){
  this.gTimer('E')   
  if(result=='KO'){
    this.gToolbar("S");
    alert("Schedulazione non completata! Contattare assistenza");        
  } else {
    alert("Schedulazione Completata con successo!");    
  }     
}
function btnDown_Click(){
  this.RTDownload.Link()  
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function gTimer(_func) {
 if(_func=='S') { 
    this.PortletLogs.Start();       
 } else {
    this.PortletLogs.Stop();           
 }  
}  
function gToolbar(status) {  
  if(status=="E") {
    this.getTitlePortlet().AppendButton({
      id:"Scarica",
      title:FormatMsg('Download'),
      tooltip:FormatMsg('Scarica il file 380'),
      image:{ fontFamily:'icons8_win10', value: "&#xece6;"},
      action:'javascript:' + this.formid +'.btnDown_Click()'
    },1);  
  }  
  if(status=="S" || status=="E") {
    this.getTitlePortlet().AppendButton({
      id:"Schedula",
      title:FormatMsg('Schedula'),
      tooltip:FormatMsg('Schedula la creazione del file 380'),
      image:{ fontFamily:'icons8_win10', value: "&#xe973;"},
      action:'javascript:' + this.formid +'.btnSched_Click()'
   },1);   
  this.getTitlePortlet().AppendButton({
      id:"Esegui",
      title:FormatMsg('Esegui'),
      tooltip:FormatMsg('Crea il file 380'),
      image:{ fontFamily:'icons8_win10', value: "&#xebe1;"},
      action:'javascript:' + this.formid +'.btnExec_Click()'
   },2);       
  }     
  if(status=='D') {
    this.getTitlePortlet().RemoveButton("Scarica");
    this.getTitlePortlet().RemoveButton("Schedula");
    this.getTitlePortlet().RemoveButton("Esegui");
  }     
}  
function ChgDate() {
  this.daope.Value(DateToChar(this.DaData.Value()));
  this.a_ope.Value(DateToChar(this.AData.Value()));
  this.dareg.Value(DateToChar(this.DaDataReg.Value()));
  this.a_reg.Value(DateToChar(this.ADataReg.Value()));  
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
.pg_chkdiana_all_container {
  height:100%;
  overflow:auto;
}
.pg_chkdiana_all_title_container {
  margin: auto;
}
.pg_chkdiana_all_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:100%;
}
.pg_chkdiana_all_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_chkdiana_all_portlet > .lblDaCli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:146px;
  left:3px;
  width:137px;
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblDaCli_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblDaCli_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
}
.pg_chkdiana_all_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:465px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_chkdiana_all_portlet > .ADataReg_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:223px;
  left:409px;
  width:125px;
  height:20px;
}
.pg_chkdiana_all_portlet > .ADataReg_ctrl {
}
.pg_chkdiana_all_portlet > .ADataReg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .flgfrz_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:275px;
  left:319px;
  width:162px;
  height:20px;
}
.pg_chkdiana_all_portlet > .lblDaOpe_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:224px;
  left:11px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblDaOpe_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblDaOpe_Copy_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .lblTipoDAti_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:276px;
  left:11px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblTipoDAti_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblTipoDAti_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .lblAOpe_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:224px;
  left:278px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblAOpe_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblAOpe_Copy_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .codcli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:145px;
  left:143px;
  width:144px;
  height:20px;
}
.pg_chkdiana_all_portlet > .codcli_ctrl {
}
.pg_chkdiana_all_portlet > .codcli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .tipoarchd_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:249px;
  left:143px;
  width:162px;
  height:20px;
}
.pg_chkdiana_all_portlet > .stoper_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:275px;
  left:607px;
  right:24px;
  width:auto;
  height:20px;
}
.pg_chkdiana_all_portlet > .zDaCli_Copy_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:145px;
  left:289px;
  width:20px;
  height:20px;
}
.pg_chkdiana_all_portlet > .tipoarchp_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:249px;
  left:319px;
  width:162px;
  height:20px;
}
.pg_chkdiana_all_portlet > .flgrae_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:249px;
  left:607px;
  right:24px;
  width:auto;
  height:20px;
}
.pg_chkdiana_all_portlet > .ragsoc_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:145px;
  left:313px;
  width:477px;
  height:20px;
}
.pg_chkdiana_all_portlet > .ragsoc_ctrl {
}
.pg_chkdiana_all_portlet > .ragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .lblArchivi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:250px;
  left:10px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblArchivi_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblArchivi_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .tiprap_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:301px;
  left:607px;
  right:24px;
  width:auto;
  height:20px;
}
.pg_chkdiana_all_portlet > .ragben_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:171px;
  left:143px;
  width:477px;
  height:20px;
}
.pg_chkdiana_all_portlet > .ragben_ctrl {
}
.pg_chkdiana_all_portlet > .ragben_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .flgope_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:275px;
  left:143px;
  width:162px;
  height:20px;
}
.pg_chkdiana_all_portlet > .flgrap_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:301px;
  left:143px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .lblControparte_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:171px;
  left:3px;
  width:137px;
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblControparte_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblControparte_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
}
.pg_chkdiana_all_portlet > .flgtit_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:327px;
  left:143px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .DaData_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:197px;
  left:143px;
  width:125px;
  height:20px;
}
.pg_chkdiana_all_portlet > .DaData_ctrl {
}
.pg_chkdiana_all_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .AData_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:197px;
  left:409px;
  width:125px;
  height:20px;
}
.pg_chkdiana_all_portlet > .AData_ctrl {
}
.pg_chkdiana_all_portlet > .AData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .tiptit_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:327px;
  left:607px;
  right:24px;
  width:auto;
  height:20px;
}
.pg_chkdiana_all_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:198px;
  left:11px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:198px;
  left:278px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .flgdel_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:353px;
  left:607px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .flgsto_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:405px;
  left:143px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .tipocr_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:29px;
  left:142px;
  right:297px;
  width:auto;
  height:20px;
}
.pg_chkdiana_all_portlet > .lblTipocr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:32px;
  left:11px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblTipocr_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblTipocr_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .flgint_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:353px;
  left:143px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .codcr_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:59px;
  left:142px;
  width:120px;
  height:20px;
}
.pg_chkdiana_all_portlet > .codcr_ctrl {
}
.pg_chkdiana_all_portlet > .codcr_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .flgchk_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:379px;
  left:143px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .lblCodcr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:11px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblCodcr_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblCodcr_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .lblDatiInvio_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:4px;
  left:6px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblDatiInvio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblDatiInvio_ctrl {
  overflow:hidden;
}
.pg_chkdiana_all_portlet > .flgxls_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:379px;
  left:607px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .lblDati_Copy_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:89px;
  left:6px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblDati_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chkdiana_all_portlet > .lblDati_Copy_ctrl {
  overflow:hidden;
}
.pg_chkdiana_all_portlet > .codage_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:119px;
  left:143px;
  width:79px;
  height:20px;
}
.pg_chkdiana_all_portlet > .codage_ctrl {
}
.pg_chkdiana_all_portlet > .codage_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .lblCAgenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:120px;
  left:11px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblCAgenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_chkdiana_all_portlet > .lblCAgenzia_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-size:8pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_chkdiana_all_portlet > .LinkZoom55_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:120px;
  left:225px;
  width:20px;
  height:20px;
}
.pg_chkdiana_all_portlet > .desage_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:119px;
  left:254px;
  width:262px;
  height:20px;
}
.pg_chkdiana_all_portlet > .desage_ctrl {
}
.pg_chkdiana_all_portlet > .desage_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .DaDataReg_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:223px;
  left:143px;
  width:125px;
  height:20px;
}
.pg_chkdiana_all_portlet > .DaDataReg_ctrl {
}
.pg_chkdiana_all_portlet > .DaDataReg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chkdiana_all_portlet > .allsto_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:86px;
  left:612px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .multifile_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:405px;
  left:607px;
  width:373px;
  height:20px;
}
.pg_chkdiana_all_portlet > .flg2020_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:431px;
  left:143px;
  width:454px;
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
 String def="[{\"h\":\"545\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NDG Cliente:\",\"w\":\"137\",\"x\":\"3\",\"y\":\"146\",\"zindex\":\"5\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"465\",\"zindex\":\"3\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADataReg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"409\",\"y\":\"223\",\"zindex\":\"2\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Frazionate\",\"layout_steps_values\":{},\"name\":\"flgfrz\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"162\",\"x\":\"319\",\"y\":\"275\",\"zindex\":\"23\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Registrazione:\",\"w\":\"129\",\"x\":\"11\",\"y\":\"224\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTipoDAti\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipologia Dati:\",\"w\":\"129\",\"x\":\"11\",\"y\":\"276\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Registrazione:\",\"w\":\"129\",\"x\":\"278\",\"y\":\"224\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codcli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"144\",\"x\":\"143\",\"y\":\"145\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Definitivi (A.U.I.)\",\"layout_steps_values\":{},\"name\":\"tipoarchd\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"162\",\"x\":\"143\",\"y\":\"249\",\"zindex\":\"23\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"stoper\",\"page\":\"1\",\"textlist\":\"Storico Soggetti per Data Registrazione,Storico Soggetti per Data Operazione\",\"type\":\"Combobox\",\"w\":\"393\",\"x\":\"607\",\"y\":\"275\",\"zindex\":\"13\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zDaCli_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"289\",\"y\":\"145\",\"zindex\":\"6\"},{\"h\":\"30\",\"name\":\"RTExec\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Provvisori\",\"layout_steps_values\":{},\"name\":\"tipoarchp\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"162\",\"x\":\"319\",\"y\":\"249\",\"zindex\":\"23\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"flgrae\",\"page\":\"1\",\"textlist\":\"Utilizza Codifica RAE,Utilizza Codifica Ateco\",\"type\":\"Combobox\",\"w\":\"393\",\"x\":\"607\",\"y\":\"249\",\"zindex\":\"13\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"477\",\"x\":\"313\",\"y\":\"145\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblArchivi\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipologia Archivi:\",\"w\":\"129\",\"x\":\"10\",\"y\":\"250\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tiprap\",\"page\":\"1\",\"textlist\":\"Rapporti attivi nel periodo,Rapporti attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Rapporti per il periodo\",\"type\":\"Combobox\",\"w\":\"393\",\"x\":\"607\",\"y\":\"301\",\"zindex\":\"13\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ragben\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"477\",\"x\":\"143\",\"y\":\"171\",\"zindex\":\"7\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Operazioni\",\"layout_steps_values\":{},\"name\":\"flgope\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"162\",\"x\":\"143\",\"y\":\"275\",\"zindex\":\"23\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Solo Rapporti attivi nell'intervallo di date selezionato\",\"layout_steps_values\":{},\"name\":\"flgrap\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"143\",\"y\":\"301\",\"zindex\":\"23\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblControparte\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Controparte:\",\"w\":\"137\",\"x\":\"3\",\"y\":\"171\",\"zindex\":\"5\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Solo Legami attivi nell'intervallo di date selezionato\",\"layout_steps_values\":{},\"name\":\"flgtit\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"143\",\"y\":\"327\",\"zindex\":\"23\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"143\",\"y\":\"197\",\"zindex\":\"2\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"AData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"409\",\"y\":\"197\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tiptit\",\"page\":\"1\",\"textlist\":\"Legami attivi nel periodo,Legami attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Legami per il periodo\",\"type\":\"Combobox\",\"w\":\"393\",\"x\":\"607\",\"y\":\"327\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"129\",\"x\":\"11\",\"y\":\"198\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"129\",\"x\":\"278\",\"y\":\"198\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Inserire Delegati in registrazioni 31 e 32\",\"layout_steps_values\":{},\"name\":\"flgdel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"607\",\"y\":\"353\",\"zindex\":\"23\"},{\"h\":\"20\",\"name\":\"gIntemediario\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"264\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"SQLTipo\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"666\",\"y\":\"-61\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Scrivere anche Cancellate e Modificate\",\"layout_steps_values\":{},\"name\":\"flgsto\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"143\",\"y\":\"405\",\"zindex\":\"23\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipocr\",\"page\":\"1\",\"textlist\":\"DESCRI\",\"type\":\"Combobox\",\"w\":\"585\",\"x\":\"142\",\"y\":\"29\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTipocr\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Intermediario:\",\"w\":\"129\",\"x\":\"11\",\"y\":\"32\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Ripeti dati intestatario per ogni informazione\",\"layout_steps_values\":{},\"name\":\"flgint\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"143\",\"y\":\"353\",\"zindex\":\"23\"},{\"h\":\"20\",\"name\":\"gTipInter\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"397\",\"y\":\"-62\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codcr\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"142\",\"y\":\"59\",\"zindex\":\"15\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Scrittura diretta su WEBCHK\",\"layout_steps_values\":{},\"name\":\"flgchk\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"143\",\"y\":\"379\",\"zindex\":\"23\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblCodcr\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice:\",\"w\":\"129\",\"x\":\"11\",\"y\":\"61\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDatiInvio\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Dati Centro Servizi\",\"w\":\"200\",\"x\":\"6\",\"y\":\"4\",\"zindex\":\"19\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Scrittura 380 su Excel (XLSX)\",\"layout_steps_values\":{},\"name\":\"flgxls\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"607\",\"y\":\"379\",\"zindex\":\"23\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDati_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Dati Invio\",\"w\":\"200\",\"x\":\"6\",\"y\":\"89\",\"zindex\":\"19\"},{\"h\":\"20\",\"name\":\"gWebCHK\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"798\",\"y\":\"-62\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"531\",\"y\":\"-63\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codage\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"79\",\"x\":\"143\",\"y\":\"119\",\"zindex\":\"20\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblCAgenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia\\u002fDipendenza:\",\"w\":\"129\",\"x\":\"11\",\"y\":\"120\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom55\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"225\",\"y\":\"120\",\"zindex\":\"21\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"desage\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"254\",\"y\":\"119\",\"zindex\":\"22\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDataReg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"143\",\"y\":\"223\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"cUrl\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1070\",\"y\":\"-23\"},{\"h\":\"30\",\"name\":\"RTScarica\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"127\",\"x\":\"1066\",\"y\":\"-71\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Riportare tutte le modifiche (Stato 3)\",\"layout_steps_values\":{},\"name\":\"allsto\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"612\",\"y\":\"86\",\"zindex\":\"23\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Scrivi lo scarico su più file\",\"layout_steps_values\":{},\"name\":\"multifile\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"373\",\"x\":\"607\",\"y\":\"405\",\"zindex\":\"23\"},{\"h\":\"30\",\"name\":\"RTSched\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"1065\",\"y\":\"8\"},{\"h\":\"20\",\"name\":\"daope\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1072\",\"y\":\"59\"},{\"h\":\"20\",\"name\":\"a_ope\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1072\",\"y\":\"87\"},{\"h\":\"20\",\"name\":\"dareg\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1066\",\"y\":\"119\"},{\"h\":\"20\",\"name\":\"a_reg\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1065\",\"y\":\"146\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1059\",\"y\":\"173\"},{\"h\":\"20\",\"name\":\"filename\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1065\",\"y\":\"205\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Genera il tracciato nella modalità 2020 (Informazioni aggiuntive)\",\"layout_steps_values\":{},\"name\":\"flg2020\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"454\",\"x\":\"143\",\"y\":\"431\",\"zindex\":\"23\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_chkdiana_all","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_chkdiana_all_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("LibreriaMit.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_chkdiana_all','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDaCli= "NDG Cliente:";
java.sql.Date ADataReg= JSPLib.NullDate();
if(request.getAttribute("pg_chkdiana_all_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String flgfrz="N";
String lblDaOpe_Copy= "Da Data Registrazione:";
String lblTipoDAti= "Tipologia Dati:";
String lblAOpe_Copy= "A Data Registrazione:";
String codcli=JSPLib.translateXSS(sp.getParameter("codcli",""));
String tipoarchd="S";
String stoper="R";
if(request.getAttribute("pg_chkdiana_all_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String tipoarchp="N";
String flgrae="A";
String ragsoc= "";
String lblArchivi= "Tipologia Archivi:";
String tiprap="R";
String ragben= "";
String flgope="S";
String flgrap="N";
String lblControparte= "Controparte:";
String flgtit="N";
java.sql.Date DaData= JSPLib.NullDate();
java.sql.Date AData= JSPLib.NullDate();
String tiptit="R";
String lblDaOpe= "Da Data Operazione:";
String lblAOpe= "A Data Operazione:";
String flgdel="S";
String gIntemediario=sp.getGlobal("gIntemediario","");
String flgsto="N";
String tipocr= "";
String lblTipocr= "Tipo Intermediario:";
String flgint="S";
String gTipInter=sp.getGlobal("gTipInter","");
String codcr= "";
String flgchk="N";
String lblCodcr= "Codice:";
String lblDatiInvio= "Dati Centro Servizi";
String flgxls="N";
String lblDati_Copy= "Dati Invio";
String gWebCHK=sp.getGlobal("gWebCHK","");
String gDescAzi=sp.getGlobal("gDescAzi","");
String codage= "";
String lblCAgenzia= "Agenzia/Dipendenza:";
String desage= "";
java.sql.Date DaDataReg= JSPLib.NullDate();
String cUrl= "";
String allsto="N";
String multifile="N";
String daope= "";
String a_ope= "";
String dareg= "";
String a_reg= "";
String filename= "";
String flg2020="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_chkdiana_all_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_chkdiana_all_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_chkdiana_all_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_chkdiana_all','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblDaCli'  formid='<%=idPortlet%>' ps-name='lblDaCli'    class='label lblDaCli_ctrl'><div id='<%=idPortlet%>_lblDaClitbl' style='width:100%;'><%=JSPLib.ToHTML("NDG Cliente:")%></div></span>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_ADataReg_wrp'><input id='<%=idPortlet%>_ADataReg' name='ADataReg' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='ADataReg' /></span>
<div id='<%=idPortlet%>_flgfrz_div' style=''><input id='<%=idPortlet%>_flgfrz' name='flgfrz' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgfrz' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Frazionate")%></label></div>
<span id='<%=idPortlet%>_lblDaOpe_Copy'  formid='<%=idPortlet%>' ps-name='lblDaOpe_Copy'    class='label lblDaOpe_Copy_ctrl'><div id='<%=idPortlet%>_lblDaOpe_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Registrazione:")%></div></span>
<span id='<%=idPortlet%>_lblTipoDAti'  formid='<%=idPortlet%>' ps-name='lblTipoDAti'    class='label lblTipoDAti_ctrl'><div id='<%=idPortlet%>_lblTipoDAtitbl' style='width:100%;'><%=JSPLib.ToHTML("Tipologia Dati:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe_Copy'  formid='<%=idPortlet%>' ps-name='lblAOpe_Copy'    class='label lblAOpe_Copy_ctrl'><div id='<%=idPortlet%>_lblAOpe_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Registrazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_codcli_wrp'><input id='<%=idPortlet%>_codcli' name='codcli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='codcli' /></span>
<div id='<%=idPortlet%>_tipoarchd_div' style=''><input id='<%=idPortlet%>_tipoarchd' name='tipoarchd' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tipoarchd' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Definitivi (A.U.I.)")%></label></div>
<select id='<%=idPortlet%>_stoper' name='stoper' class='combobox' style=''></select>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zDaCli_Copy'" ) );%>
<div id='<%=idPortlet%>_tipoarchp_div' style=''><input id='<%=idPortlet%>_tipoarchp' name='tipoarchp' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tipoarchp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Provvisori")%></label></div>
<select id='<%=idPortlet%>_flgrae' name='flgrae' class='combobox' style=''></select>
<span class='textbox-container'id='<%=idPortlet%>_ragsoc_wrp'><input id='<%=idPortlet%>_ragsoc' name='ragsoc' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='ragsoc' /></span>
<span id='<%=idPortlet%>_lblArchivi'  formid='<%=idPortlet%>' ps-name='lblArchivi'    class='label lblArchivi_ctrl'><div id='<%=idPortlet%>_lblArchivitbl' style='width:100%;'><%=JSPLib.ToHTML("Tipologia Archivi:")%></div></span>
<select id='<%=idPortlet%>_tiprap' name='tiprap' class='combobox' style=''></select>
<span class='textbox-container'id='<%=idPortlet%>_ragben_wrp'><input id='<%=idPortlet%>_ragben' name='ragben' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='ragben' /></span>
<div id='<%=idPortlet%>_flgope_div' style=''><input id='<%=idPortlet%>_flgope' name='flgope' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgope' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Operazioni")%></label></div>
<div id='<%=idPortlet%>_flgrap_div' style=''><input id='<%=idPortlet%>_flgrap' name='flgrap' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgrap' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Solo Rapporti attivi nell'intervallo di date selezionato")%></label></div>
<span id='<%=idPortlet%>_lblControparte'  formid='<%=idPortlet%>' ps-name='lblControparte'    class='label lblControparte_ctrl'><div id='<%=idPortlet%>_lblContropartetbl' style='width:100%;'><%=JSPLib.ToHTML("Controparte:")%></div></span>
<div id='<%=idPortlet%>_flgtit_div' style=''><input id='<%=idPortlet%>_flgtit' name='flgtit' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgtit' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Solo Legami attivi nell'intervallo di date selezionato")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' /></span>
<span class='textbox-container'id='<%=idPortlet%>_AData_wrp'><input id='<%=idPortlet%>_AData' name='AData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='AData' /></span>
<select id='<%=idPortlet%>_tiptit' name='tiptit' class='combobox' style=''></select>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_flgdel_div' style=''><input id='<%=idPortlet%>_flgdel' name='flgdel' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgdel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Inserire Delegati in registrazioni 31 e 32")%></label></div>
<div id='<%=idPortlet%>_flgsto_div' style=''><input id='<%=idPortlet%>_flgsto' name='flgsto' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgsto' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Scrivere anche Cancellate e Modificate")%></label></div>
<select id='<%=idPortlet%>_tipocr' name='tipocr' class='combobox' style=''></select>
<span id='<%=idPortlet%>_lblTipocr'  formid='<%=idPortlet%>' ps-name='lblTipocr'    class='label lblTipocr_ctrl'><div id='<%=idPortlet%>_lblTipocrtbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Intermediario:")%></div></span>
<div id='<%=idPortlet%>_flgint_div' style=''><input id='<%=idPortlet%>_flgint' name='flgint' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgint' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Ripeti dati intestatario per ogni informazione")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_codcr_wrp'><input id='<%=idPortlet%>_codcr' name='codcr' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='codcr' /></span>
<div id='<%=idPortlet%>_flgchk_div' style='display:none;'><input id='<%=idPortlet%>_flgchk' name='flgchk' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgchk' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Scrittura diretta su WEBCHK")%></label></div>
<span id='<%=idPortlet%>_lblCodcr'  formid='<%=idPortlet%>' ps-name='lblCodcr'    class='label lblCodcr_ctrl'><div id='<%=idPortlet%>_lblCodcrtbl' style='width:100%;'><%=JSPLib.ToHTML("Codice:")%></div></span>
<span id='<%=idPortlet%>_lblDatiInvio'  formid='<%=idPortlet%>' ps-name='lblDatiInvio'    class='label lblDatiInvio_ctrl'><div id='<%=idPortlet%>_lblDatiInviotbl' style='width:100%;'><%=JSPLib.ToHTML("Dati Centro Servizi")%></div></span>
<div id='<%=idPortlet%>_flgxls_div' style=''><input id='<%=idPortlet%>_flgxls' name='flgxls' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgxls' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Scrittura 380 su Excel (XLSX)")%></label></div>
<span id='<%=idPortlet%>_lblDati_Copy'  formid='<%=idPortlet%>' ps-name='lblDati_Copy'    class='label lblDati_Copy_ctrl'><div id='<%=idPortlet%>_lblDati_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Dati Invio")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_codage_wrp'><input id='<%=idPortlet%>_codage' name='codage' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='codage' /></span>
<span id='<%=idPortlet%>_lblCAgenzia'  formid='<%=idPortlet%>' ps-name='lblCAgenzia'    class='label lblCAgenzia_ctrl'><div id='<%=idPortlet%>_lblCAgenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia/Dipendenza:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom55'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_desage_wrp'><input id='<%=idPortlet%>_desage' name='desage' type='text' disabled maxlength='35' class='textbox' formid='<%=idPortlet%>' ps-name='desage' /></span>
<span class='textbox-container'id='<%=idPortlet%>_DaDataReg_wrp'><input id='<%=idPortlet%>_DaDataReg' name='DaDataReg' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaDataReg' /></span>
<div id='<%=idPortlet%>_allsto_div' style='display:none;'><input id='<%=idPortlet%>_allsto' name='allsto' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_allsto' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Riportare tutte le modifiche (Stato 3)")%></label></div>
<div id='<%=idPortlet%>_multifile_div' style=''><input id='<%=idPortlet%>_multifile' name='multifile' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_multifile' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Scrivi lo scarico su più file")%></label></div>
<div id='<%=idPortlet%>_flg2020_div' style=''><input id='<%=idPortlet%>_flg2020' name='flg2020' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flg2020' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Genera il tracciato nella modalità 2020 (Informazioni aggiuntive)")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_chkdiana_all');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea il file 380",true)+","+JSPLib.ToJSValue(sp.translate("Crea il file 380"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Download",true)+","+JSPLib.ToJSValue(sp.translate("Download"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegui",true)+","+JSPLib.ToJSValue(sp.translate("Esegui"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Scarica il file 380",true)+","+JSPLib.ToJSValue(sp.translate("Scarica il file 380"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Schedula",true)+","+JSPLib.ToJSValue(sp.translate("Schedula"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Schedula la creazione del file 380",true)+","+JSPLib.ToJSValue(sp.translate("Schedula la creazione del file 380"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_chkdiana_all',["1024"],["545"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"545","title":"","layer":""}]);
this.lblDaCli=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaCli","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaCli","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaCli,false,true)%>","type":"Label","w":137,"x":3,"y":146,"zindex":"5"});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":1024,"x":0,"y":465,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.ADataReg=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADataReg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADataReg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=ADataReg%>","w":125,"x":409,"y":223,"zerofilling":false,"zindex":"2","zoom":""});
this.flgfrz=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgfrz","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Frazionate","layer":false,"layout_steps_values":{},"name":"flgfrz","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":162,"x":319,"y":275,"zindex":"23"});
this.flgfrz.Value('<%=flgfrz%>');
this.lblDaOpe_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe_Copy,false,true)%>","type":"Label","w":129,"x":11,"y":224,"zindex":"1"});
this.lblTipoDAti=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipoDAti","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipoDAti","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipoDAti,false,true)%>","type":"Label","w":129,"x":11,"y":276,"zindex":"1"});
this.lblAOpe_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe_Copy,false,true)%>","type":"Label","w":129,"x":278,"y":224,"zindex":"1"});
this.codcli=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codcli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"16","name":"codcli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codcli,false,true)%>","w":144,"x":143,"y":145,"zerofilling":false,"zindex":"4","zoom":""});
this.tipoarchd=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tipoarchd","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Definitivi (A.U.I.)","layer":false,"layout_steps_values":{},"name":"tipoarchd","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":162,"x":143,"y":249,"zindex":"23"});
this.tipoarchd.Value('<%=tipoarchd%>');
this.stoper=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_stoper","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=stoper%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"stoper","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Storico Soggetti per Data Registrazione,Storico Soggetti per Data Operazione","type":"Combobox","typevar":"character","valuelist":"R,O","visible":true,"w":393,"x":607,"y":275,"zindex":"13"});
this.zDaCli_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zDaCli_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_chkdiana_all_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"codcli,ragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_chkdiana_all_portlet.jspzDaCli_Copy",request.getSession())%>","linkedField":"codcli","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zDaCli_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":289,"y":145,"zindex":"6","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_chkdiana_all",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_codinter=codcr,w_tipinter=tipocr,w_codage=codage,w_codcli=codcli,w_ragben=ragben,daope=daope,a_ope=a_ope,dareg=dareg,a_reg=a_reg,w_tipoarchd=tipoarchd,w_tipoarchp=tipoarchp,w_stoper=stoper,w_flgope=flgope,w_flgfrz=flgfrz,w_flgrae=flgrae,w_flgrap=flgrap,w_tiprap=tiprap,w_flgtit=flgtit,w_tiptit=tiptit,w_flgint=flgint,w_flgdel=flgdel,w_flgchk=flgchk,w_flgxls=flgxls,w_flgsto=flgsto,w_allsto=allsto,w_multifile=multifile,w_flg2020=flg2020","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_chkdiana_all","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_chkdiana_all",request.getSession())%>';
this.tipoarchp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tipoarchp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Provvisori","layer":false,"layout_steps_values":{},"name":"tipoarchp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":162,"x":319,"y":249,"zindex":"23"});
this.tipoarchp.Value('<%=tipoarchp%>');
this.flgrae=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_flgrae","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=flgrae%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"flgrae","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Utilizza Codifica RAE,Utilizza Codifica Ateco","type":"Combobox","typevar":"character","valuelist":"R,A","visible":true,"w":393,"x":607,"y":249,"zindex":"13"});
this.ragsoc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"ragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragsoc,false,true)%>","w":477,"x":313,"y":145,"zerofilling":false,"zindex":"7","zoom":""});
this.lblArchivi=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblArchivi","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblArchivi","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblArchivi,false,true)%>","type":"Label","w":129,"x":10,"y":250,"zindex":"1"});
this.tiprap=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tiprap","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"Eq(this.flgrap.Value(),'S')","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tiprap%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tiprap","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Rapporti attivi nel periodo,Rapporti attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Rapporti per il periodo","type":"Combobox","typevar":"character","valuelist":"1,2,3,9","visible":true,"w":393,"x":607,"y":301,"zindex":"13"});
this.ragben=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragben","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"ragben","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragben,false,true)%>","w":477,"x":143,"y":171,"zerofilling":false,"zindex":"7","zoom":""});
this.flgope=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Operazioni","layer":false,"layout_steps_values":{},"name":"flgope","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":162,"x":143,"y":275,"zindex":"23"});
this.flgope.Value('<%=flgope%>');
this.flgrap=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgrap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Solo Rapporti attivi nell'intervallo di date selezionato","layer":false,"layout_steps_values":{},"name":"flgrap","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":143,"y":301,"zindex":"23"});
this.flgrap.Value('<%=flgrap%>');
this.lblControparte=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblControparte","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblControparte","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblControparte,false,true)%>","type":"Label","w":137,"x":3,"y":171,"zindex":"5"});
this.flgtit=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgtit","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Solo Legami attivi nell'intervallo di date selezionato","layer":false,"layout_steps_values":{},"name":"flgtit","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":143,"y":327,"zindex":"23"});
this.flgtit.Value('<%=flgtit%>');
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaData%>","w":125,"x":143,"y":197,"zerofilling":false,"zindex":"2","zoom":""});
this.AData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_AData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"AData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=AData%>","w":125,"x":409,"y":197,"zerofilling":false,"zindex":"2","zoom":""});
this.tiptit=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tiptit","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"Eq(this.flgtit.Value(),'S')","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tiptit%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tiptit","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Legami attivi nel periodo,Legami attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Legami per il periodo","type":"Combobox","typevar":"character","valuelist":"1,2,3,9","visible":true,"w":393,"x":607,"y":327,"zindex":"13"});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":129,"x":11,"y":198,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":129,"x":278,"y":198,"zindex":"1"});
this.flgdel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgdel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Inserire Delegati in registrazioni 31 e 32","layer":false,"layout_steps_values":{},"name":"flgdel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":607,"y":353,"zindex":"23"});
this.flgdel.Value('<%=flgdel%>');
this.gIntemediario=new ZtVWeb._VC(this,'gIntemediario',null,'character','<%=JSPLib.ToJSValue(gIntemediario,false,true)%>',false,false);
this.SQLTipo=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbtipint","cmdHash":"<%=JSPLib.cmdHash("qbe_tbtipint",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLTipo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLTipo","nrows":"100","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":666,"y":-61});
this.flgsto=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgsto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Scrivere anche Cancellate e Modificate","layer":false,"layout_steps_values":{},"name":"flgsto","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":143,"y":405,"zindex":"23"});
this.flgsto.Value('<%=flgsto%>');
this.tipocr=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipocr","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipocr%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"tipocr","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"TIPOINT","visible":true,"w":585,"x":142,"y":29,"zindex":"13"});
this.lblTipocr=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipocr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipocr","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipocr,false,true)%>","type":"Label","w":129,"x":11,"y":32,"zindex":"1"});
this.flgint=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgint","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Ripeti dati intestatario per ogni informazione","layer":false,"layout_steps_values":{},"name":"flgint","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":143,"y":353,"zindex":"23"});
this.flgint.Value('<%=flgint%>');
this.gTipInter=new ZtVWeb._VC(this,'gTipInter',null,'character','<%=JSPLib.ToJSValue(gTipInter,false,true)%>',false,false);
this.codcr=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codcr","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"codcr","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codcr,false,true)%>","w":120,"x":142,"y":59,"zerofilling":false,"zindex":"15","zoom":""});
this.flgchk=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgchk","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"Eq(this.gWebCHK.Value(),'N')","init":"","init_par":"N","label_text":"Scrittura diretta su WEBCHK","layer":false,"layout_steps_values":{},"name":"flgchk","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":143,"y":379,"zindex":"23"});
this.flgchk.Value('<%=flgchk%>');
this.lblCodcr=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCodcr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCodcr","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblCodcr,false,true)%>","type":"Label","w":129,"x":11,"y":61,"zindex":"1"});
this.lblDatiInvio=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDatiInvio","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDatiInvio","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDatiInvio,false,true)%>","type":"Label","w":200,"x":6,"y":4,"zindex":"19"});
this.flgxls=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgxls","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Scrittura 380 su Excel (XLSX)","layer":false,"layout_steps_values":{},"name":"flgxls","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":607,"y":379,"zindex":"23"});
this.flgxls.Value('<%=flgxls%>');
this.lblDati_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDati_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDati_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDati_Copy,false,true)%>","type":"Label","w":200,"x":6,"y":89,"zindex":"19"});
this.gWebCHK=new ZtVWeb._VC(this,'gWebCHK',null,'character','<%=JSPLib.ToJSValue(gWebCHK,false,true)%>',false,false);
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.codage=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"codage","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codage,false,true)%>","w":79,"x":143,"y":119,"zerofilling":false,"zindex":"20","zoom":""});
this.lblCAgenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCAgenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"#000000","font_size":"8pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCAgenzia","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblCAgenzia,false,true)%>","type":"Label","w":129,"x":11,"y":120,"zindex":"1"});
this.LinkZoom55=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom55","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_chkdiana_all_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"codage,desage","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_chkdiana_all_portlet.jspLinkZoom55",request.getSession())%>","linkedField":"codage","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom55","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":225,"y":120,"zindex":"21","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.desage=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_desage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"35","name":"desage","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(desage,false,true)%>","w":262,"x":254,"y":119,"zerofilling":false,"zindex":"22","zoom":""});
this.DaDataReg=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDataReg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDataReg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaDataReg%>","w":125,"x":143,"y":223,"zerofilling":false,"zindex":"2","zoom":""});
this.cUrl=new ZtVWeb._VC(this,'cUrl',null,'character','<%=JSPLib.ToJSValue(cUrl,false,true)%>',false,false);
this.RTScarica=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_downloadfile_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTScarica","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTScarica","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella,pTipo=tipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_downloadfile_doc","target":"","type":"SPLinker","w":127,"x":1066,"y":-71});
this.RTScarica.m_cID='<%=JSPLib.cmdHash("routine,arfn_downloadfile_doc",request.getSession())%>';
this.allsto=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_allsto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"true","init":"","init_par":"N","label_text":"Riportare tutte le modifiche (Stato 3)","layer":false,"layout_steps_values":{},"name":"allsto","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":612,"y":86,"zindex":"23"});
this.allsto.Value('<%=allsto%>');
this.multifile=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_multifile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Scrivi lo scarico su più file","layer":false,"layout_steps_values":{},"name":"multifile","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":373,"x":607,"y":405,"zindex":"23"});
this.multifile.Value('<%=multifile%>');
this.RTSched=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_chkdiana_sched",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSched","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSched","offline":false,"page":1,"parms":"w_codinter=codcr,w_tipinter=tipocr,w_codage=codage,w_codcli=codcli,w_ragben=ragben,daope=daope,a_ope=a_ope,dareg=dareg,a_reg=a_reg,w_tipoarchd=tipoarchd,w_tipoarchp=tipoarchp,w_stoper=stoper,w_flgope=flgope,w_flgfrz=flgfrz,w_flgrae=flgrae,w_flgrap=flgrap,w_tiprap=tiprap,w_flgtit=flgtit,w_tiptit=tiptit,w_flgint=flgint,w_flgdel=flgdel,w_flgchk=flgchk,w_flgxls=flgxls,w_flgsto=flgsto,w_allsto=allsto,w_multifile=multifile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_chkdiana_sched","target":"","type":"SPLinker","w":75,"x":1065,"y":8});
this.RTSched.m_cID='<%=JSPLib.cmdHash("routine,arrt_chkdiana_sched",request.getSession())%>';
this.daope=new ZtVWeb._VC(this,'daope',null,'character','<%=JSPLib.ToJSValue(daope,false,true)%>',false,false);
this.a_ope=new ZtVWeb._VC(this,'a_ope',null,'character','<%=JSPLib.ToJSValue(a_ope,false,true)%>',false,false);
this.dareg=new ZtVWeb._VC(this,'dareg',null,'character','<%=JSPLib.ToJSValue(dareg,false,true)%>',false,false);
this.a_reg=new ZtVWeb._VC(this,'a_reg',null,'character','<%=JSPLib.ToJSValue(a_reg,false,true)%>',false,false);
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("DownloadFileServlet",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":120,"x":1059,"y":173});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,DownloadFileServlet",request.getSession())%>';
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.flg2020=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flg2020","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Genera il tracciato nella modalità 2020 (Informazioni aggiuntive)","layer":false,"layout_steps_values":{},"name":"flg2020","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":454,"x":143,"y":431,"zindex":"23"});
this.flg2020.Value('<%=flg2020%>');
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
<%if(request.getAttribute("pg_chkdiana_all_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_chkdiana_all_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_chkdiana_all_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLTipo.firstQuery('true');
window.<%=idPortlet%>.stoper.FillData();
window.<%=idPortlet%>.flgrae.FillData();
window.<%=idPortlet%>.tiprap.FillData();
window.<%=idPortlet%>.tiptit.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_chkdiana_all',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_chkdiana_all');
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
sp.endPage("pg_chkdiana_all");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"zDaCli_Copy")) {
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
if (Library.eq(p_cControlName,"LinkZoom55")) {
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
return null;
}/**/%>
<%! public String getJSPUID() { return "875205815"; } %>