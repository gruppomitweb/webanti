<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Creazione File per invio S.AR.A. a UIF (XBRL)\",true)\n  this.tipocr.Value(this.gTipInter.Value());\n  this.codcr.Value(this.gIntemediario.Value())\n  this.ftypes.Value('PDF|XLS|CSV')\n  this.fmodels.Value('||')\n  this.btnDown.Hide()\n  this.btnExec.Hide()\n  if(LibreriaMit.inter_art1(this.gTipInter.Value())) {\n    this.flgfrazionate.Show()\n  } else {   \n    this.flgfrazionate.Hide()\n  }  \n}\n\nfunction btnExec_Click(){\n  if (confirm(\"Confermi la creazione del file?\")) {\n    this.gTimer('S')    \n    this.RTExec.Link();  \n  }  \n}\n\nfunction numinv_onChange(){\n  if (this.numinv.Value()!=0 && this.anno.Value()!=0 && !Empty(this.mese.Value())) {\n    this.btnExec.Show();\n  } else {  \n    this.btnExec.Hide();\n  }  \n}\n\nfunction datinv_onChange(){\n  if (Empty(this.datinv.Value())) {\n    this.btnExec.Hide();\n  } else {  \n    this.btnExec.Show();\n  }  \n}\n\nfunction RTExec_Result(result){\n  if(result!=0){\n    this.btnDown.Show();\n  }  \n  this.btnExec.Enabled()\n  this.gTimer('E')    \n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnDown_Click(){\n  this.RTDownload.Link()\n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction anno_onChange(){\n  if(this.anno.Value()==0) {\n    this.mese.Value(\"\")    \n    this.DaDatOpe.Value(NullDate())\n    this.ADatOpe.Value(NullDate())\n  } else {\n    this.CalcolaDate() \n  }  \n\u002f\u002f   if(this.anno.Value()\u003e=2021) {\n\u002f\u002f     this.flgfrazionate.Hide()\n\u002f\u002f     this.flgfrazionate.Value('N')\n\u002f\u002f   }    \n}\n\nfunction mese_onChange(){\n  if(Empty(this.mese.Value())) {\n    this.DaDatOpe.Value(NullDate())\n    this.ADatOpe.Value(NullDate())    \n    this.c_dadate.Value('')\n    this.c_adate.Value('')\n  } else {\n    this.CalcolaDate()      \n  }  \n}\n\nfunction CalcolaDate() {\n this.DaDatOpe.Value(iif(!Empty(this.anno.Value()) && !Empty(this.mese.Value()),CharToDate(Str(this.anno.Value(),4,0)+this.mese.Value()+\"01\"),this.DaDatOpe.Value()))\n this.c_dadate.Value(DateToChar(this.DaDatOpe.Value()))\n}  \n\nfunction DaDatOpe_onChange(){\n if (!Empty(this.DaDatOpe.Value())){\n   this.ADatOpe.Value(arfn_finemese(this.DaDatOpe.Value()))    \n   this.c_adate.Value(DateToChar(this.ADatOpe.Value()))\n }\n}\n\nfunction btnRep1_Click(){\n  if(confirm(\"Confermi il lancio della stampa?\")) {\n    this.btnRep1.Disabled()\n    this.gTimer('S')\n    this.RTVerifica1.Link()    \n  }  \n}                      \n\nfunction RTVerifica1_Result(result){\n  this.btnRep1.Enabled()\n  this.gTimer('E')  \n  if(result!=0) {\n    this.RTStampa1.Link()\n  } else {\n    this.RTStampaNeg.Link()    \n  }  \n}  \n\nfunction btnRep2_Click(){\n  if(confirm(\"Confermi il lancio della stampa?\")) {  \n    this.btnRep2.Disabled()\n    this.gTimer('S')\n    this.RTVerifica2.Link()\n  }  \n}\n   \nfunction RTVerifica2_Result(result){\n  this.btnRep2.Enabled()\n  this.gTimer('E')    \n  if(result!=0) {\n    this.RTStampa2.Link()\n  } else {\n    this.RTStampaNeg.Link()    \n  }  \n}\n\nfunction btnEle1_Click(){\n  if(confirm(\"Confermi il lancio della stampa?\")) {  \n    this.btnEle1.Disabled()\n    this.gTimer('S')\n    this.RTElenco1.Link()\n  }  \n}\n   \nfunction RTElenco1_Result(result){\n  this.btnEle1.Enabled()\n  this.gTimer('E')    \n  if(result!=0) {\n    this.RTRElenco1.Link()\n  } else {\n    this.RTSElencoNeg.Link()    \n  }  \n}\n\nfunction btnEle2_Click(){\n  if(confirm(\"Confermi il lancio della stampa?\")) {  \n    this.btnEle2.Disabled()  \n    this.gTimer('S')  \n    this.RTElenco2.Link()\n  }  \n}\n   \nfunction RTElenco2_Result(result){\n  this.btnEle2.Enabled()  \n  this.gTimer('E')\n  if(result!=0) {\n    this.RTRElenco2.Link()\n  } else {\n    this.RTSElencoNeg.Link()    \n  }  \n}\n\nfunction gTimer(_func) {\n if(_func=='S') {\n   this.iPrint.Reload();   \n   this.PortletLogs.Start();    \n } else {\n   this.PortletLogs.Stop();        \n }  \n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Creazione Operazioni ExtraConto da AUI\u002fAGE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @btnEle2 }}{{ @btnExit }}{{ @pLog }}{{ @pMsg }}{{ @anno }}{{ @lblAnno }}{{ @mese }}{{ @lblMese }}{{ @DaDatOpe }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @iPrint }}{{ @tipocr }}{{ @lblTipocr }}{{ @codcr }}{{ @btnEle1 }}{{ @btnRep2 }}{{ @lblCodcr }}{{ @lblDatiInvio }}{{ @datinv }}{{ @numinv }}{{ @lblDatInv }}{{ @lblNumInv }}{{ @lblDati_Copy }}{{ @btnExec }}{{ @btnDown }}{{ @btnRep1 }}{{ @flgfrazionate }}{{ @flgstorico }}{{ @btnEle2 }}{{ @btnExit }}{{ @anno }}{{ @lblAnno }}{{ @mese }}{{ @lblMese }}{{ @DaDatOpe }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @iPrint }}{{ @tipocr }}{{ @lblTipocr }}{{ @codcr }}{{ @btnEle1 }}{{ @btnRep2 }}{{ @lblCodcr }}{{ @lblDatiInvio }}{{ @datinv }}{{ @numinv }}{{ @lblDatInv }}{{ @lblNumInv }}{{ @lblDati_Copy }}{{ @btnExec }}{{ @btnDown }}{{ @btnRep1 }}{{ @flgfrazionate }}{{ @flgstorico }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"460","hsl":"false","htmlcode":"{{ @PortletLogs }} \n{{ @flgstorico }}\n{{ @flgfrazionate }}\n{{ @btnRep1 }}\n{{ @btnDown }}\n{{ @btnExec }}\n{{ @lblDati_Copy }}\n{{ @lblNumInv }}\n{{ @lblDatInv }}\n{{ @numinv }}\n{{ @datinv }}\n{{ @lblDatiInvio }}\n{{ @lblCodcr }}\n{{ @btnRep2 }}\n{{ @btnEle1 }}\n{{ @codcr }}\n{{ @lblTipocr }}\n{{ @tipocr }}\n{{ @iPrint }}\n{{ @lblAOpe }}\n{{ @lblDaOpe }}\n{{ @ADatOpe }}\n{{ @DaDatOpe }}\n{{ @lblMese }}\n{{ @mese }}\n{{ @lblAnno }}\n{{ @anno }}\n\n\n{{ @btnExit }}\n{{ @btnEle2 }}\n{{ flgstorico }}\n{{ btnEle2 }}\n{{ btnExit }}\n{{ ftypes }}\n{{ RTEsci }}\n{{ RTExec }}\n{{ pLog }}\n{{ pMsg }}\n{{ anno }}\n{{ lblAnno }}\n{{ mese }}\n{{ lblMese }}{{ fmodels }}\n{{ RTClean }}\n{{ DaDatOpe }}\n{{ ADatOpe }}\n{{ lblDaOpe }}\n{{ lblAOpe }}\n{{ iPrint }}\n{{ gIntemediario }}\n{{ SQLTipo }}\n{{ tipocr }}\n{{ lblTipocr }}\n{{ gTipInter }}\n{{ codcr }}\n{{ btnEle1 }}\n{{ btnRep2 }}\n{{ RTVerifica2 }}\n{{ lblCodcr }}\n{{ lblDatiInvio }}\n{{ datinv }}\n{{ numinv }}\n{{ lblDatInv }}\n{{ lblNumInv }}\n{{ lblDati_Copy }}\n{{ btnExec }}\n{{ gDescAzi }}\n{{ RTStampaNeg }}\n{{ c_dadate }}\n{{ c_adate }}\n{{ RTDownload }}\n{{ btnDown }}\n{{ RTElenco1 }}\n{{ RTVerifica1 }}\n{{ RTElenco2 }}\n{{ btnRep1 }}\n{{ RTSElencoNeg }}\n{{ RTRElenco1 }}\n{{ RTRElenco2 }}\n{{ RTStampa2 }}\n{{ RTStampa1 }}\n{{ flgfrazionate }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"arfn_finemese.js,LibreriaMit.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"460\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#0309FD","font_color_hover":"#0309FD","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Dati Aggregati con Dettaglio","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnEle2","page":"1","path_type":"","rapp":"","sequence":"1","server_side":"","spuid":"","src":"showlog_portlet.jsp","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"715","y":"8","zindex":"1","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"380","zindex":"3","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","rapp":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"766","y":"233","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"ftypes","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"841","y":"107"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"63","x":"3","y":"-67"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_datinv=datinv,w_numinv=numinv,w_flgfrazionate=flgfrazionate,w_storico=flgstorico","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arrt_discouic_xbrl","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"53","wireframe_props":"name","x":"140","y":"29","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"9","y":"34","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"mese","page":"1","picture":"","rapp":"","sequence":"9","spuid":"","tabindex":"","textlist":"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre","type":"Combobox","typevar":"character","valuelist":"01,02,03,04,05,06,07,08,09,10,11,12","visible":"true","w":"212","wireframe_props":"name,textlist","x":"274","y":"29","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMese","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Mese:","w":"69","wireframe_props":"align,value,n_col","x":"206","y":"34","zindex":"1","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"601","y":"12","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"601","y":"46","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"470","y":"15","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"470","y":"51","zindex":"1","zone":""},{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"107","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"16","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"271","zindex":"9","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gIntemediario","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"264","y":"-63"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"100","name":"SQLTipo","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tbtipint","query_async":"false","return_fields_type":"true","sequence":"18","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"666","y":"-61"},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLTipo","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipocr","page":"1","picture":"","rapp":"","sequence":"19","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"TIPOINT","visible":"true","w":"120","wireframe_props":"name,textlist","x":"140","y":"154","zindex":"13","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipocr","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Intermediario:","w":"129","wireframe_props":"align,value,n_col","x":"9","y":"157","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gTipInter","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"397","y":"-62"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"codcr","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"22","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"140","y":"184","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FD030F","font_color_hover":"#FD030F","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Dati Aggregati senza Dettaglio","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnEle1","page":"1","path_type":"","rapp":"","sequence":"23","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"752","y":"8","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#03FD1B","font_color_hover":"#03FD1B","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Check Operazioni\u002fFrazionate (PDF)","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnRep2","page":"1","path_type":"","rapp":"","sequence":"24","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"715","y":"47","zindex":"1","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTVerifica2","offline":"false","page":"1","parms":"pTipo=R,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"25","servlet":"arrt_discouic_chk","target":"","type":"SPLinker","w":"120","x":"837","y":"-84"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblCodcr","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice:","w":"129","wireframe_props":"align,value,n_col","x":"9","y":"186","zindex":"1","zone":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDatiInvio","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Dati Centro Servizi","w":"200","wireframe_props":"align,value,n_col","x":"4","y":"129","zindex":"19","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"11","name":"datinv","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"28","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"82","wireframe_props":"name","x":"140","y":"240","zerofilling":"false","zindex":"21","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"4","name":"numinv","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"29","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"30","wireframe_props":"name","x":"413","y":"240","zerofilling":"false","zindex":"22","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDatInv","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Invio:","w":"129","wireframe_props":"align,value,n_col","x":"10","y":"246","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblNumInv","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Numero Invio:","w":"129","wireframe_props":"align,value,n_col","x":"284","y":"246","zindex":"1","zone":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDati_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"32","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Dati Invio","w":"200","wireframe_props":"align,value,n_col","x":"4","y":"215","zindex":"19","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Crea il file S.AR.A.","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExec","page":"1","path_type":"","rapp":"","sequence":"33","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"727","y":"233","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"531","y":"-63"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampaNeg","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_ver_chk_neg.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,formatTypes=PDF,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"35","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"840","y":"-27"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"c_dadate","page":"1","reactive":"","sequence":"36","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"988","y":"70"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"c_adate","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"840","y":"75"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTDownload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"38","servlet":"pg_fileuic_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"978","y":"-26"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva file S.AR.A.","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDown","page":"1","path_type":"","rapp":"","sequence":"39","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"688","y":"233","zindex":"1","zone":""},{"allowedentities":"arrt_discouic_ver","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTElenco1","offline":"false","page":"1","parms":"pTipo=A,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"40","servlet":"arrt_discouic_ver","target":"","type":"SPLinker","w":"120","x":"840","y":"6"},{"allowedentities":"arrt_discouic_chk","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTVerifica1","offline":"false","page":"1","parms":"pTipo=X,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"41","servlet":"arrt_discouic_chk","target":"","type":"SPLinker","w":"120","x":"977","y":"-86"},{"allowedentities":"arrt_discouic_ver","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTElenco2","offline":"false","page":"1","parms":"pTipo=D,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"42","servlet":"arrt_discouic_ver","target":"","type":"SPLinker","w":"120","x":"983","y":"7"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Check Operazioni\u002fFrazionate (XLS)","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnRep1","page":"1","path_type":"","rapp":"","sequence":"43","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"752","y":"47","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTSElencoNeg","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_ver_neg.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,formatTypes=PDF,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"44","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"988","y":"104"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTRElenco1","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_ver_agg.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"45","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"842","y":"43"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTRElenco2","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_ver.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"46","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"983","y":"42"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa2","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_chk.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,formatTypes=PDF,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"47","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"839","y":"-52"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa1","offline":"false","page":"1","parms":"ReportName=arrp_stpoper_chk_xls.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,outputFormat=XLSX","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"48","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"978","y":"-53"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Considerare anche le operazioni di gestione con contante (frazionate)","layer":"false","layout_steps_values":"{}","name":"flgfrazionate","page":"1","rapp":"","sequence":"49","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"541","wireframe_props":"label_text","x":"11","y":"74","zindex":"23","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Utilizzare dati storici per la settorizzazione","layer":"false","layout_steps_values":"{}","name":"flgstorico","page":"1","rapp":"","sequence":"50","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"541","wireframe_props":"label_text","x":"10","y":"101","zindex":"23","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fmodels","page":"1","reactive":"","sequence":"51","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"856","y":"149"}]%>
<%/*Description:Creazione Operazioni ExtraConto da AUI/AGE*/%>
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
window.pg_discouic_xbrl_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnExec_Click !='undefined')this.btnExec_Click=btnExec_Click;
if(typeof numinv_onChange !='undefined')this.numinv_onChange=numinv_onChange;
if(typeof datinv_onChange !='undefined')this.datinv_onChange=datinv_onChange;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof anno_onChange !='undefined')this.anno_onChange=anno_onChange;
if(typeof mese_onChange !='undefined')this.mese_onChange=mese_onChange;
if(typeof CalcolaDate !='undefined')this.CalcolaDate=CalcolaDate;
if(typeof DaDatOpe_onChange !='undefined')this.DaDatOpe_onChange=DaDatOpe_onChange;
if(typeof btnRep1_Click !='undefined')this.btnRep1_Click=btnRep1_Click;
if(typeof RTVerifica1_Result !='undefined')this.RTVerifica1_Result=RTVerifica1_Result;
if(typeof btnRep2_Click !='undefined')this.btnRep2_Click=btnRep2_Click;
if(typeof RTVerifica2_Result !='undefined')this.RTVerifica2_Result=RTVerifica2_Result;
if(typeof btnEle1_Click !='undefined')this.btnEle1_Click=btnEle1_Click;
if(typeof RTElenco1_Result !='undefined')this.RTElenco1_Result=RTElenco1_Result;
if(typeof btnEle2_Click !='undefined')this.btnEle2_Click=btnEle2_Click;
if(typeof RTElenco2_Result !='undefined')this.RTElenco2_Result=RTElenco2_Result;
if(typeof gTimer !='undefined')this.gTimer=gTimer;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
ZtVWeb.InitCtrl(SystemDate(),this.datinv);
this.SQLTipo.addRowConsumer(this.tipocr);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Creazione File per invio S.AR.A. a UIF (XBRL)",true)
  this.tipocr.Value(this.gTipInter.Value());
  this.codcr.Value(this.gIntemediario.Value())
  this.ftypes.Value('PDF|XLS|CSV')
  this.fmodels.Value('||')
  this.btnDown.Hide()
  this.btnExec.Hide()
  if(LibreriaMit.inter_art1(this.gTipInter.Value())) {
    this.flgfrazionate.Show()
  } else {   
    this.flgfrazionate.Hide()
  }  
}
function btnExec_Click(){
  if (confirm("Confermi la creazione del file?")) {
    this.gTimer('S')    
    this.RTExec.Link();  
  }  
}
function numinv_onChange(){
  if (this.numinv.Value()!=0 && this.anno.Value()!=0 && !Empty(this.mese.Value())) {
    this.btnExec.Show();
  } else {  
    this.btnExec.Hide();
  }  
}
function datinv_onChange(){
  if (Empty(this.datinv.Value())) {
    this.btnExec.Hide();
  } else {  
    this.btnExec.Show();
  }  
}
function RTExec_Result(result){
  if(result!=0){
    this.btnDown.Show();
  }  
  this.btnExec.Enabled()
  this.gTimer('E')    
  alert("Elaborazione Completata!");
}
function btnDown_Click(){
  this.RTDownload.Link()
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function anno_onChange(){
  if(this.anno.Value()==0) {
    this.mese.Value("")    
    this.DaDatOpe.Value(NullDate())
    this.ADatOpe.Value(NullDate())
  } else {
    this.CalcolaDate() 
  }  
//   if(this.anno.Value()>=2021) {
//     this.flgfrazionate.Hide()
//     this.flgfrazionate.Value('N')
//   }    
}
function mese_onChange(){
  if(Empty(this.mese.Value())) {
    this.DaDatOpe.Value(NullDate())
    this.ADatOpe.Value(NullDate())    
    this.c_dadate.Value('')
    this.c_adate.Value('')
  } else {
    this.CalcolaDate()      
  }  
}
function CalcolaDate() {
 this.DaDatOpe.Value(iif(!Empty(this.anno.Value()) && !Empty(this.mese.Value()),CharToDate(Str(this.anno.Value(),4,0)+this.mese.Value()+"01"),this.DaDatOpe.Value()))
 this.c_dadate.Value(DateToChar(this.DaDatOpe.Value()))
}  
function DaDatOpe_onChange(){
 if (!Empty(this.DaDatOpe.Value())){
   this.ADatOpe.Value(arfn_finemese(this.DaDatOpe.Value()))    
   this.c_adate.Value(DateToChar(this.ADatOpe.Value()))
 }
}
function btnRep1_Click(){
  if(confirm("Confermi il lancio della stampa?")) {
    this.btnRep1.Disabled()
    this.gTimer('S')
    this.RTVerifica1.Link()    
  }  
}                      
function RTVerifica1_Result(result){
  this.btnRep1.Enabled()
  this.gTimer('E')  
  if(result!=0) {
    this.RTStampa1.Link()
  } else {
    this.RTStampaNeg.Link()    
  }  
}  
function btnRep2_Click(){
  if(confirm("Confermi il lancio della stampa?")) {  
    this.btnRep2.Disabled()
    this.gTimer('S')
    this.RTVerifica2.Link()
  }  
}
   
function RTVerifica2_Result(result){
  this.btnRep2.Enabled()
  this.gTimer('E')    
  if(result!=0) {
    this.RTStampa2.Link()
  } else {
    this.RTStampaNeg.Link()    
  }  
}
function btnEle1_Click(){
  if(confirm("Confermi il lancio della stampa?")) {  
    this.btnEle1.Disabled()
    this.gTimer('S')
    this.RTElenco1.Link()
  }  
}
   
function RTElenco1_Result(result){
  this.btnEle1.Enabled()
  this.gTimer('E')    
  if(result!=0) {
    this.RTRElenco1.Link()
  } else {
    this.RTSElencoNeg.Link()    
  }  
}
function btnEle2_Click(){
  if(confirm("Confermi il lancio della stampa?")) {  
    this.btnEle2.Disabled()  
    this.gTimer('S')  
    this.RTElenco2.Link()
  }  
}
   
function RTElenco2_Result(result){
  this.btnEle2.Enabled()  
  this.gTimer('E')
  if(result!=0) {
    this.RTRElenco2.Link()
  } else {
    this.RTSElencoNeg.Link()    
  }  
}
function gTimer(_func) {
 if(_func=='S') {
   this.iPrint.Reload();   
   this.PortletLogs.Start();    
 } else {
   this.PortletLogs.Stop();        
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
.pg_discouic_xbrl_container {
}
.pg_discouic_xbrl_title_container {
  margin: auto;
}
.pg_discouic_xbrl_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:460px;
}
.pg_discouic_xbrl_portlet[Data-page="1"]{
  height:460px;
  width:100%;
}
.pg_discouic_xbrl_portlet > .btnEle2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:55px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnEle2_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#0309FD;
}
.pg_discouic_xbrl_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:380px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_discouic_xbrl_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:233px;
  right:4px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_discouic_xbrl_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:140px;
  width:53px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .anno_ctrl {
}
.pg_discouic_xbrl_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_discouic_xbrl_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:9px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .mese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:274px;
  width:212px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .lblMese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:206px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblMese_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblMese_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:601px;
  width:86px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .DaDatOpe_ctrl {
}
.pg_discouic_xbrl_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_xbrl_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:46px;
  left:601px;
  width:86px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .ADatOpe_ctrl {
}
.pg_discouic_xbrl_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_xbrl_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:470px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:51px;
  left:470px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:271px;
  left:0px;
  right:0px;
  width:auto;
  height:107px;
}
.pg_discouic_xbrl_portlet > .tipocr_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:154px;
  left:140px;
  right:540px;
  width:auto;
  height:20px;
}
.pg_discouic_xbrl_portlet > .lblTipocr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:157px;
  left:9px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblTipocr_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblTipocr_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .codcr_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:184px;
  left:140px;
  width:120px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .codcr_ctrl {
}
.pg_discouic_xbrl_portlet > .codcr_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_xbrl_portlet > .btnEle1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:18px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnEle1_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#FD030F;
}
.pg_discouic_xbrl_portlet > .btnRep2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  right:55px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnRep2_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#03FD1B;
}
.pg_discouic_xbrl_portlet > .lblCodcr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:186px;
  left:9px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblCodcr_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblCodcr_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .lblDatiInvio_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:129px;
  left:4px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_discouic_xbrl_portlet > .lblDatiInvio_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_xbrl_portlet > .lblDatiInvio_ctrl {
  overflow:hidden;
}
.pg_discouic_xbrl_portlet > .datinv_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:240px;
  left:140px;
  width:82px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .datinv_ctrl {
}
.pg_discouic_xbrl_portlet > .datinv_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_xbrl_portlet > .numinv_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:240px;
  left:413px;
  width:30px;
  height:20px;
}
.pg_discouic_xbrl_portlet > .numinv_ctrl {
}
.pg_discouic_xbrl_portlet > .numinv_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_discouic_xbrl_portlet > .lblDatInv_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:246px;
  left:10px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblDatInv_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblDatInv_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .lblNumInv_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:246px;
  left:284px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblNumInv_ctrl {
  height:auto;
  min-height:19px;
}
.pg_discouic_xbrl_portlet > .lblNumInv_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_discouic_xbrl_portlet > .lblDati_Copy_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:215px;
  left:4px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_discouic_xbrl_portlet > .lblDati_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_discouic_xbrl_portlet > .lblDati_Copy_ctrl {
  overflow:hidden;
}
.pg_discouic_xbrl_portlet > .btnExec_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:233px;
  right:43px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnExec_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_discouic_xbrl_portlet > .btnDown_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:233px;
  right:82px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnDown_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_discouic_xbrl_portlet > .btnRep1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  right:18px;
  width:30px;
  height:30px;
}
.pg_discouic_xbrl_portlet > .btnRep1_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_discouic_xbrl_portlet > .flgfrazionate_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:74px;
  left:11px;
  left:1.375%;
  right:248px;
  right:31.0%;
  width:auto;
  height:20px;
}
.pg_discouic_xbrl_portlet > .flgstorico_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:101px;
  left:10px;
  left:1.25%;
  right:249px;
  right:31.125%;
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
 String def="[{\"h\":\"460\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"715\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"380\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"766\",\"y\":\"233\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"841\",\"y\":\"107\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"63\",\"x\":\"3\",\"y\":\"-67\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"140\",\"y\":\"29\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"9\",\"y\":\"34\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"mese\",\"page\":\"1\",\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"274\",\"y\":\"29\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMese\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"69\",\"x\":\"206\",\"y\":\"34\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"601\",\"y\":\"12\",\"zindex\":\"2\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"601\",\"y\":\"46\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"129\",\"x\":\"470\",\"y\":\"15\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"129\",\"x\":\"470\",\"y\":\"51\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"107\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"271\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"gIntemediario\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"264\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"SQLTipo\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"666\",\"y\":\"-61\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipocr\",\"page\":\"1\",\"textlist\":\"DESCRI\",\"type\":\"Combobox\",\"w\":\"120\",\"x\":\"140\",\"y\":\"154\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTipocr\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Intermediario:\",\"w\":\"129\",\"x\":\"9\",\"y\":\"157\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"gTipInter\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"397\",\"y\":\"-62\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codcr\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"140\",\"y\":\"184\",\"zindex\":\"15\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnEle1\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"752\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnRep2\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"715\",\"y\":\"47\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTVerifica2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"837\",\"y\":\"-84\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblCodcr\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice:\",\"w\":\"129\",\"x\":\"9\",\"y\":\"186\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDatiInvio\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Dati Centro Servizi\",\"w\":\"200\",\"x\":\"4\",\"y\":\"129\",\"zindex\":\"19\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"datinv\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"82\",\"x\":\"140\",\"y\":\"240\",\"zindex\":\"21\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"numinv\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"30\",\"x\":\"413\",\"y\":\"240\",\"zindex\":\"22\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDatInv\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Invio:\",\"w\":\"129\",\"x\":\"10\",\"y\":\"246\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblNumInv\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Numero Invio:\",\"w\":\"129\",\"x\":\"284\",\"y\":\"246\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDati_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Dati Invio\",\"w\":\"200\",\"x\":\"4\",\"y\":\"215\",\"zindex\":\"19\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExec\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"727\",\"y\":\"233\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"531\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTStampaNeg\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"840\",\"y\":\"-27\"},{\"h\":\"20\",\"name\":\"c_dadate\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"988\",\"y\":\"70\"},{\"h\":\"20\",\"name\":\"c_adate\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"840\",\"y\":\"75\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"978\",\"y\":\"-26\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnDown\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"688\",\"y\":\"233\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTElenco1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"840\",\"y\":\"6\"},{\"h\":\"20\",\"name\":\"RTVerifica1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"977\",\"y\":\"-86\"},{\"h\":\"20\",\"name\":\"RTElenco2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"983\",\"y\":\"7\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnRep1\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"752\",\"y\":\"47\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTSElencoNeg\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"988\",\"y\":\"104\"},{\"h\":\"20\",\"name\":\"RTRElenco1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"842\",\"y\":\"43\"},{\"h\":\"20\",\"name\":\"RTRElenco2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"983\",\"y\":\"42\"},{\"h\":\"20\",\"name\":\"RTStampa2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"839\",\"y\":\"-52\"},{\"h\":\"20\",\"name\":\"RTStampa1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"978\",\"y\":\"-53\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Considerare anche le operazioni di gestione con contante (frazionate)\",\"layout_steps_values\":{},\"name\":\"flgfrazionate\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"541\",\"x\":\"11\",\"y\":\"74\",\"zindex\":\"23\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Utilizzare dati storici per la settorizzazione\",\"layout_steps_values\":{},\"name\":\"flgstorico\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"541\",\"x\":\"10\",\"y\":\"101\",\"zindex\":\"23\"},{\"h\":\"20\",\"name\":\"fmodels\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"856\",\"y\":\"149\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_discouic_xbrl","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_discouic_xbrl_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("arfn_finemese.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("LibreriaMit.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_discouic_xbrl','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String ftypes= "";
double anno= 0;
if(request.getAttribute("pg_discouic_xbrl_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String mese= "";
String lblMese= "Mese:";
java.sql.Date DaDatOpe= JSPLib.NullDate();
java.sql.Date ADatOpe= JSPLib.NullDate();
String lblDaOpe= "Da Data Operazione:";
String lblAOpe= "A Data Operazione:";
String gIntemediario=sp.getGlobal("gIntemediario","");
String tipocr= "";
String lblTipocr= "Tipo Intermediario:";
String gTipInter=sp.getGlobal("gTipInter","");
String codcr= "";
String lblCodcr= "Codice:";
String lblDatiInvio= "Dati Centro Servizi";
java.sql.Date datinv= JSPLib.NullDate();
double numinv= 0;
String lblDatInv= "Data Invio:";
String lblNumInv= "Numero Invio:";
String lblDati_Copy= "Dati Invio";
String gDescAzi=sp.getGlobal("gDescAzi","");
String c_dadate= "";
String c_adate= "";
String flgfrazionate="N";
String flgstorico="N";
String fmodels= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_discouic_xbrl_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_discouic_xbrl_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_discouic_xbrl_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_discouic_xbrl','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnEle2' class='image btnEle2_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<select id='<%=idPortlet%>_mese' name='mese' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblMese'  formid='<%=idPortlet%>' ps-name='lblMese'    class='label lblMese_ctrl'><div id='<%=idPortlet%>_lblMesetbl' style='width:100%;'><%=JSPLib.ToHTML("Mese:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<select id='<%=idPortlet%>_tipocr' name='tipocr' class='combobox' style=''></select>
<span id='<%=idPortlet%>_lblTipocr'  formid='<%=idPortlet%>' ps-name='lblTipocr'    class='label lblTipocr_ctrl'><div id='<%=idPortlet%>_lblTipocrtbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Intermediario:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_codcr_wrp'><input id='<%=idPortlet%>_codcr' name='codcr' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='codcr' /></span>
<a id='<%=idPortlet%>_btnEle1' class='image btnEle1_ctrl'   target=''>&#xeb05;</a>
<a id='<%=idPortlet%>_btnRep2' class='image btnRep2_ctrl'   target=''>&#xeb05;</a>
<span id='<%=idPortlet%>_lblCodcr'  formid='<%=idPortlet%>' ps-name='lblCodcr'    class='label lblCodcr_ctrl'><div id='<%=idPortlet%>_lblCodcrtbl' style='width:100%;'><%=JSPLib.ToHTML("Codice:")%></div></span>
<span id='<%=idPortlet%>_lblDatiInvio'  formid='<%=idPortlet%>' ps-name='lblDatiInvio'    class='label lblDatiInvio_ctrl'><div id='<%=idPortlet%>_lblDatiInviotbl' style='width:100%;'><%=JSPLib.ToHTML("Dati Centro Servizi")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_datinv_wrp'><input id='<%=idPortlet%>_datinv' name='datinv' type='text' maxlength='11' class='textbox' formid='<%=idPortlet%>' ps-name='datinv' /></span>
<span class='textbox-container'id='<%=idPortlet%>_numinv_wrp'><input id='<%=idPortlet%>_numinv' name='numinv' type='text' maxlength='4' class='textbox' formid='<%=idPortlet%>' ps-name='numinv' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblDatInv'  formid='<%=idPortlet%>' ps-name='lblDatInv'    class='label lblDatInv_ctrl'><div id='<%=idPortlet%>_lblDatInvtbl' style='width:100%;'><%=JSPLib.ToHTML("Data Invio:")%></div></span>
<span id='<%=idPortlet%>_lblNumInv'  formid='<%=idPortlet%>' ps-name='lblNumInv'    class='label lblNumInv_ctrl'><div id='<%=idPortlet%>_lblNumInvtbl' style='width:100%;'><%=JSPLib.ToHTML("Numero Invio:")%></div></span>
<span id='<%=idPortlet%>_lblDati_Copy'  formid='<%=idPortlet%>' ps-name='lblDati_Copy'    class='label lblDati_Copy_ctrl'><div id='<%=idPortlet%>_lblDati_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Dati Invio")%></div></span>
<a id='<%=idPortlet%>_btnExec' class='image btnExec_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnDown' class='image btnDown_ctrl'   target=''>&#xebbd;</a>
<a id='<%=idPortlet%>_btnRep1' class='image btnRep1_ctrl'   target=''>&#xea8c;</a>
<div id='<%=idPortlet%>_flgfrazionate_div' style=''><input id='<%=idPortlet%>_flgfrazionate' name='flgfrazionate' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgfrazionate' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Considerare anche le operazioni di gestione con contante (frazionate)")%></label></div>
<div id='<%=idPortlet%>_flgstorico_div' style=''><input id='<%=idPortlet%>_flgstorico' name='flgstorico' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgstorico' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Utilizzare dati storici per la settorizzazione")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_discouic_xbrl');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_discouic_xbrl',["800"],["460"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"460","title":"","layer":""}]);
this.btnEle2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnEle2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnEle2","edit_undercond":"","field":"","font_color":"#0309FD","font_color_hover":"#0309FD","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Dati Aggregati con Dettaglio",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnEle2","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":715,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":380,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":766,"y":233,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.ftypes=new ZtVWeb._VC(this,'ftypes',null,'character','<%=JSPLib.ToJSValue(ftypes,false,true)%>',false,false);
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":63,"x":3,"y":-67});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_datinv=datinv,w_numinv=numinv,w_flgfrazionate=flgfrazionate,w_storico=flgstorico","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_discouic_xbrl","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_discouic_xbrl",request.getSession())%>';
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=anno%>","w":53,"x":140,"y":29,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":9,"y":34,"zindex":"1"});
this.mese=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_mese","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=mese%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"mese","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre","type":"Combobox","typevar":"character","valuelist":"01,02,03,04,05,06,07,08,09,10,11,12","visible":true,"w":212,"x":274,"y":29,"zindex":"1"});
this.lblMese=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMese","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMese","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMese,false,true)%>","type":"Label","w":69,"x":206,"y":34,"zindex":"1"});
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=DaDatOpe%>","w":86,"x":601,"y":12,"zerofilling":false,"zindex":"2","zoom":""});
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=ADatOpe%>","w":86,"x":601,"y":46,"zerofilling":false,"zindex":"2","zoom":""});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":129,"x":470,"y":15,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":129,"x":470,"y":51,"zindex":"1"});
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":107,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":271,"zindex":"9"});
this.gIntemediario=new ZtVWeb._VC(this,'gIntemediario',null,'character','<%=JSPLib.ToJSValue(gIntemediario,false,true)%>',false,false);
this.SQLTipo=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbtipint","cmdHash":"<%=JSPLib.cmdHash("qbe_tbtipint",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLTipo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLTipo","nrows":"100","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":666,"y":-61});
this.tipocr=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipocr","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipocr%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"tipocr","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"TIPOINT","visible":true,"w":120,"x":140,"y":154,"zindex":"13"});
this.lblTipocr=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipocr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipocr","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipocr,false,true)%>","type":"Label","w":129,"x":9,"y":157,"zindex":"1"});
this.gTipInter=new ZtVWeb._VC(this,'gTipInter',null,'character','<%=JSPLib.ToJSValue(gTipInter,false,true)%>',false,false);
this.codcr=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codcr","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"codcr","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codcr,false,true)%>","w":120,"x":140,"y":184,"zerofilling":false,"zindex":"15","zoom":""});
this.btnEle1=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnEle1_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnEle1","edit_undercond":"","field":"","font_color":"#FD030F","font_color_hover":"#FD030F","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Dati Aggregati senza Dettaglio",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnEle1","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":752,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnRep2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnRep2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnRep2","edit_undercond":"","field":"","font_color":"#03FD1B","font_color_hover":"#03FD1B","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Check Operazioni/Frazionate (PDF)",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnRep2","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":715,"y":47,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTVerifica2=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTVerifica2","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTVerifica2","offline":false,"page":1,"parms":"pTipo=R,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_discouic_chk","target":"","type":"SPLinker","w":120,"x":837,"y":-84});
this.RTVerifica2.m_cID='<%=JSPLib.cmdHash("routine,arrt_discouic_chk",request.getSession())%>';
this.lblCodcr=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCodcr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCodcr","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblCodcr,false,true)%>","type":"Label","w":129,"x":9,"y":186,"zindex":"1"});
this.lblDatiInvio=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDatiInvio","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDatiInvio","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDatiInvio,false,true)%>","type":"Label","w":200,"x":4,"y":129,"zindex":"19"});
this.datinv=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_datinv","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"11","name":"datinv","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=datinv%>","w":82,"x":140,"y":240,"zerofilling":false,"zindex":"21","zoom":""});
this.numinv=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_numinv","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"4","name":"numinv","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=numinv%>","w":30,"x":413,"y":240,"zerofilling":false,"zindex":"22","zoom":""});
this.lblDatInv=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDatInv","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDatInv","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDatInv,false,true)%>","type":"Label","w":129,"x":10,"y":246,"zindex":"1"});
this.lblNumInv=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblNumInv","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNumInv","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblNumInv,false,true)%>","type":"Label","w":129,"x":284,"y":246,"zindex":"1"});
this.lblDati_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDati_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDati_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDati_Copy,false,true)%>","type":"Label","w":200,"x":4,"y":215,"zindex":"19"});
this.btnExec=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExec_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExec","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Crea il file S.AR.A.",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExec","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":727,"y":233,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.RTStampaNeg=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampaNeg","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampaNeg","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_ver_chk_neg.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,formatTypes=PDF,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":840,"y":-27});
this.RTStampaNeg.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.c_dadate=new ZtVWeb._VC(this,'c_dadate',null,'character','<%=JSPLib.ToJSValue(c_dadate,false,true)%>',false,false);
this.c_adate=new ZtVWeb._VC(this,'c_adate',null,'character','<%=JSPLib.ToJSValue(c_adate,false,true)%>',false,false);
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"pg_fileuic_portlet.jsp","target":"","type":"SPLinker","w":120,"x":978,"y":-26});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("entity,pg_fileuic_portlet.jsp",request.getSession())%>';
this.btnDown=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDown_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDown","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva file S.AR.A.",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDown","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":688,"y":233,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTElenco1=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_discouic_ver",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElenco1","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElenco1","offline":false,"page":1,"parms":"pTipo=A,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_discouic_ver","target":"","type":"SPLinker","w":120,"x":840,"y":6});
this.RTElenco1.m_cID='<%=JSPLib.cmdHash("routine,arrt_discouic_ver",request.getSession())%>';
this.RTVerifica1=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_discouic_chk",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTVerifica1","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTVerifica1","offline":false,"page":1,"parms":"pTipo=X,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_discouic_chk","target":"","type":"SPLinker","w":120,"x":977,"y":-86});
this.RTVerifica1.m_cID='<%=JSPLib.cmdHash("routine,arrt_discouic_chk",request.getSession())%>';
this.RTElenco2=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_discouic_ver",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElenco2","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElenco2","offline":false,"page":1,"parms":"pTipo=D,w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_tipocr=tipocr,w_codcr=codcr,w_flgfrazionate=flgfrazionate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_discouic_ver","target":"","type":"SPLinker","w":120,"x":983,"y":7});
this.RTElenco2.m_cID='<%=JSPLib.cmdHash("routine,arrt_discouic_ver",request.getSession())%>';
this.btnRep1=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnRep1_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnRep1","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Check Operazioni/Frazionate (XLS)",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnRep1","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":752,"y":47,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSElencoNeg=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSElencoNeg","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSElencoNeg","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_ver_neg.vrp,rotation=LANDSCAPE,c_dadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,formatTypes=PDF,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":988,"y":104});
this.RTSElencoNeg.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTRElenco1=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRElenco1","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRElenco1","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_ver_agg.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":842,"y":43});
this.RTRElenco1.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTRElenco2=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRElenco2","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRElenco2","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_ver.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,xtipo=S,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":983,"y":42});
this.RTRElenco2.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTStampa2=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa2","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa2","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_chk.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,formatTypes=PDF,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":839,"y":-52});
this.RTStampa2.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTStampa1=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa1","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa1","offline":false,"page":1,"parms":"ReportName=arrp_stpoper_chk_xls.vrp,rotation=LANDSCAPE,cdadata=c_dadate,c_adata=c_adate,DescAzi=gDescAzi,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,outputFormat=XLSX","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":978,"y":-53});
this.RTStampa1.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.flgfrazionate=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgfrazionate","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Considerare anche le operazioni di gestione con contante (frazionate)","layer":false,"layout_steps_values":{},"name":"flgfrazionate","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":541,"x":11,"y":74,"zindex":"23"});
this.flgfrazionate.Value('<%=flgfrazionate%>');
this.flgstorico=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgstorico","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Utilizzare dati storici per la settorizzazione","layer":false,"layout_steps_values":{},"name":"flgstorico","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":541,"x":10,"y":101,"zindex":"23"});
this.flgstorico.Value('<%=flgstorico%>');
this.fmodels=new ZtVWeb._VC(this,'fmodels',null,'character','<%=JSPLib.ToJSValue(fmodels,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_discouic_xbrl_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_discouic_xbrl_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_discouic_xbrl_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnEle2.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnEle1.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnRep2.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExec.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnDown.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnRep1.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLTipo.firstQuery('true');
window.<%=idPortlet%>.mese.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_discouic_xbrl',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_discouic_xbrl');
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
sp.endPage("pg_discouic_xbrl");
}%>
<%! public String getJSPUID() { return "562560964"; } %>