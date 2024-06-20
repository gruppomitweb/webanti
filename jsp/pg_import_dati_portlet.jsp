<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Import dati da procedure esterne',true);\nthis.getTitlePortlet().SetSubTitle('',true);\n\nfunction this_Loaded(){  \n  this.btnDown.Hide();  \n  this.btnStpChk.Hide()\n  this.flgforzaagg.Value('N')  \n  this.flgforzaagg.Disabled()\n  if (this.actflg.Value()=='S') {\n    this.flgforzaagg.Show()\n  }\n  if (this.actria.Value()=='S') {    \n    this.norifimp.Show()\n    this.norifimp.Value(gAzienda='bef'?'S':'N');\n  }\n\u003c%if(sp.isInGroup(3) || sp.isInGroup(4)){%\u003e\n  this.rDest.Value('P')\n  this.rDest.Disabled()\n\u003c%}%\u003e  \n}\n\nfunction SQLDataobj_intermbo_ConsumersRendered(){  \n  if(this.SQLDataobj_intermbo.rs.VIGILATO==\"1\"){\n  \tthis.chkaui.Value(\"S\");\n    this.chkaui.Disabled(); \u002f\u002f Disabilito la possibilità di escludere il controllo\n  }  \n}\n\nfunction btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction image5_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.btnDown.Hide();  \n    this.btnStpChk.Hide()    \n    this.PortletLogs.Start();\n    this.listaFile.Timer0.Start();\n    this.RTSalva.Link();\n  }    \n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n  this.listaFile.ListaFile.Refresh()\n}  \n\nfunction RTSalva_Result(result){\n  this.PortletLogs.Stop();\n  this.listaFile.Timer0_onTimer();\n  this.listaFile.Timer0.Stop();  \n  if (result==0) {\n    alert(\"Elaborazione Terminata con successo!\");\n    this.AggiornaDatiADE.Emit()\n  }  \n  if (result==1) {\n    this.btnStpChk.Show();\n    alert(\"Controllo anagrafiche terminato con errori\\nPremere il bottone di stampa per l'esito\");\n  }  \n  if (result==2) {\n    this.btnDown.Show();      \n    alert(\"Elaborazione Terminata con errori.\\nPrelevare i file con gli errori\");    \n  }  \n}\n\nfunction btnDown_Click(){\n  this.RTDownload.Link();\n}\n\nfunction RTSaveFile_Result(result){\n  this.listaFile.ListaFile.Refresh()\n}\n\nfunction btnChkFile_Click(){\n  if (confirm(\"Confermi il controllo dei file di import?\")) {  \n    this.PortletLogs.Start();\n    this.listaFile.Timer0.Start();    \n    this.RTChkFile.Link()\n  }  \n}\n\nfunction RTChkFile_Result(result){  \n  this.PortletLogs.Stop();\n  this.listaFile.Timer0_onTimer();\n  this.listaFile.Timer0.Stop();    \n  this.errimp.Set(result);\n  if (this.errimp.Value() == -1) {\n    alert(\"Elaborazione Terminata. I file non rientrano tra quelli controllabili\");\n  }  \n  \n  if (this.errimp.Value()==0) {\n    alert(\"Elaborazione Terminata. Non sono stati rilevati errori\");\n  }  \n  if (this.errimp.Value() \u003e 0) {\n    alert(\"Elaborazione Terminata. Sono stati rilevati errori.\\nLanciare la stampa per la verifica\");\n  }  \n}\n\nfunction btnStpChk_Click(){\n  this.RTStpChkErr.Link()\n}\n\nfunction btnStpErr_Click(){\n  this.RTStpErr.Link()\n}\n\nfunction flgaggfam_onChange(){\n  if(this.flgaggfam.Value()=='S') {\n    this.flgforzaagg.Enabled()\n  } else {\n    this.flgforzaagg.Value('N')\n    this.flgforzaagg.Disabled()\n  }  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @nomefile }}{{ @label1 }}{{ @btnExit }}{{ @btnElab }}{{ @image5 }}{{ @rDest }}{{ @pMsg }}{{ @listaFile }}{{ @Label18 }}{{ @btnDown }}{{ @chkaui }}{{ @imperr }}{{ @flgaggfam }}{{ @flgimposv }}{{ @btnStpErr }}{{ @btnChkFile }}{{ @btnStpChk }}{{ @creamo }}{{ @norifimp }}{{ @flgforzaagg }}{{ @actflg }}{{ @actria }}{{ @opeunivoco }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"485","hsl":"","htmlcode":"{{ @opeunivoco }} \n\n{{ @actria }}\n{{ @actflg }}\n{{ @flgforzaagg }}\n{{ @norifimp }}\n{{ @creamo }}\n{{ @btnStpChk }}\n{{ @btnChkFile }}\n{{ @btnStpErr }}\n{{ @flgimposv }}\n{{ @flgaggfam }}\n{{ @imperr }}\n{{ @chkaui }}\n{{ @btnDown }}\n{{ @Label18 }}\n{{ @listaFile }}\n{{ @PortletLogs }}\n\n{{ @rDest }}\n{{ @image5 }}\n{{ @btnElab }}\n{{ @btnExit }}\n{{ @label1 }}\n{{ @nomefile }}\n{{ nomefile }}\n{{ label1 }}{{ SQLDataobj_intermbo }}\n{{ RTUpload }}\n{{ btnExit }}\n{{ btnElab }}{{ SPLinker37 }}{{ vigilato }}\n{{ RTSalva }}\n{{ image5 }}\n{{ rDest }}\n{{ listaFile }}\n{{ Label18 }}\n{{ Event_filename }}\n{{ dir }}\n{{ RTSaveFile }}\n{{ RTUscita }}\n{{ btnDown }}\n{{ RTDownload }}\n{{ RTAzzera }}\n{{ chkaui }}\n{{ imperr }}\n{{ flgaggfam }}\n{{ flgimposv }}\n{{ fscarti }}\n{{ btnStpErr }}\n{{ btnChkFile }}\n{{ errimp }}\n{{ btnStpChk }}\n{{ RTChkFile }}\n{{ creamo }}\n{{ RTStpChkErr }}\n{{ RTStpErr }}\n{{ norifimp }}\n{{ flgforzaagg }}\n{{ actflg }}\n{{ actria }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"485\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"851","version":"37","w":"100%","wizard":""},{"allowedqueries":"qbe_intermbo_tipint","appendingData":"false","auto_exec":"server-client","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1","name":"SQLDataobj_intermbo","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_intermbo_tipint","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"154","waiting_mgs":"","x":"1045","y":"-80"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"750","wireframe_props":"name","x":"64","y":"11","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"51","wireframe_props":"align,value,n_col","x":"8","y":"14","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"4","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"379","y":"-67"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","rapp":"","sequence":"5","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_exit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"813","y":"36","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'import dei dati","hide":"false","hide_undercond":"errimp=1","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","rapp":"","sequence":"6","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_execute.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"771","y":"36","zindex":"1","zone":""},{"allowedentities":"arrt_imp_dati","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSalva","offline":"false","page":"1","parms":"w_tipodest=rDest,w_chkaui=chkaui,w_imperr=imperr,w_flgaggfam=flgaggfam,w_flgimposv=flgimposv,w_creamo=creamo,w_norifimp=norifimp,w_flgforzaagg=flgforzaagg,w_opeunivoco=opeunivoco","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arrt_imp_dati","target":"","type":"SPLinker","w":"120","x":"1","y":"-67"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","rapp":"","sequence":"8","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"820","y":"9","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"23","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layer":"false","layout_steps_values":"{}","name":"rDest","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"9","spuid":"","tabindex":"","textlist":"Definitivo,Provvisorio","type":"Radio","typevar":"character","valuelist":"D,P","visible":"true","w":"188","wireframe_props":"","x":"146","y":"44","zindex":"2","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"10","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"851","wireframe_props":"","x":"0","y":"405","zindex":"3","zone":""},{"anchor":"","ctrlOfVariant":"","fixed":"","h":"200","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"listaFile","page":"1","rapp":"","sequence":"11","spuid":"","src":"list_imprich_portlet.jsp","themed":"false","type":"Portlet","w":"851","wireframe_props":"","x":"0","y":"204","zindex":"6","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label18","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Destinazione Dati:","w":"129","wireframe_props":"align,value,n_col","x":"15","y":"46","zindex":"7","zone":""},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"13","type":"EventReceiver","w":"111","x":"869","y":"-82"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"869","y":"-57"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"120","x":"505","y":"-67"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"16","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"255","y":"-66"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva eventuali file di errore","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDown","page":"1","path_type":"","rapp":"","sequence":"17","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"729","y":"73","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTDownload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"..\u002fjsp\u002fpg_list_file_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"629","y":"-66"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"Controllo preliminare sui dati (obbligatorio per soggetti vigilati)","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Controllo preliminare dati import","layer":"false","layout_steps_values":"{}","name":"chkaui","page":"1","rapp":"","sequence":"20","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"278","wireframe_props":"label_text","x":"16","y":"78","zindex":"8","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Importa i dati anche in presenza di errori","layer":"false","layout_steps_values":"{}","name":"imperr","page":"1","rapp":"","sequence":"21","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"294","wireframe_props":"label_text","x":"16","y":"110","zindex":"9","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Aggiorna Famiglie (ARCHPERS\u002fPERSNEW)","layer":"false","layout_steps_values":"{}","name":"flgaggfam","page":"1","rapp":"","sequence":"22","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"306","wireframe_props":"label_text","x":"16","y":"142","zindex":"9","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Aggiorna Importo Netto (SV)","layer":"false","layout_steps_values":"{}","name":"flgimposv","page":"1","rapp":"","sequence":"23","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"266","wireframe_props":"label_text","x":"406","y":"78","zindex":"10","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"0","name":"fscarti","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"numeric","w":"111","x":"869","y":"-32"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Errori Controllo File","hide":"false","hide_undercond":"errimp=0","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnStpErr","page":"1","path_type":"","rapp":"","sequence":"25","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"771","y":"73","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Controllo file Import","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnChkFile","page":"1","path_type":"","rapp":"","sequence":"26","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"729","y":"36","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"errimp","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"869","y":"-7"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#037EFB","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Errori Controllo Anagrafiche","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnStpChk","page":"1","path_type":"","rapp":"","sequence":"28","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"813","y":"73","zindex":"1","zone":""},{"allowedentities":"arrt_imp_dati_storico_exam","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChkFile","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"29","servlet":"arrt_imp_dati_storico_exam","target":"","type":"SPLinker","w":"111","x":"869","y":"18"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Crea modifiche su operazioni","layer":"false","layout_steps_values":"{}","name":"creamo","page":"1","rapp":"","sequence":"30","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"266","wireframe_props":"label_text","x":"406","y":"110","zindex":"10","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStpChkErr","offline":"false","page":"1","parms":"ReportName=arrp_stp_errimp_pers.vrp,outputFormat=PDF","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"31","servlet":"","target":"","type":"SPLinker","w":"111","x":"869","y":"43"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStpErr","offline":"false","page":"1","parms":"ReportName=arrp_stp_errimp.vrp,FileName=Errori_rilevati_nel_controllo_file,formatTypes=PDF$|$XLS$|$XLSX","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"32","servlet":"","target":"","type":"SPLinker","w":"111","x":"869","y":"68"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"N","label_text":"Non utilizzare RIFIMP\u002fINFORM per le modifiche","layer":"false","layout_steps_values":"{}","name":"norifimp","page":"1","rapp":"","sequence":"33","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"439","wireframe_props":"label_text","x":"406","y":"142","zindex":"10","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"N","label_text":"Forza Aggiorna Famiglie (ARCHPERS\u002fPERSNEW)","layer":"false","layout_steps_values":"{}","name":"flgforzaagg","page":"1","rapp":"","sequence":"34","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"379","wireframe_props":"label_text","x":"16","y":"174","zindex":"9","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"actflg","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"35","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"120","wireframe_props":"name","x":"548","y":"44","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"actria","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"36","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"120","wireframe_props":"name","x":"403","y":"47","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"100","hide":"","layer":"","layout_steps_values":"{}","name":"Note38","page":"1","rapp":"","sequence":"37","spuid":"","type":"Note","value":"outputFormat=PDF$|$XLS","w":"200","wireframe_props":"","x":"1069","y":"38","zindex":"12","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"AggiornaDatiADE","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"38","type":"EventEmitter","w":"120","x":"870","y":"92"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"39","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"870","y":"117"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"File Unico Operazioni\u002fFrazionate (ARCHOPE)","layer":"false","layout_steps_values":"{}","name":"opeunivoco","page":"1","rapp":"","sequence":"40","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"439","wireframe_props":"label_text","x":"406","y":"174","zindex":"10","zone":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:actflg,actria*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.pg_import_dati_container {
  height:100%;
  overflow:auto;
}
.pg_import_dati_title_container {
  margin: auto;
}
.pg_import_dati_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:851px;
  height:100%;
  background-color:#FFFFFF;
}
.pg_import_dati_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_import_dati_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:64px;
  left:7.520564%;
  right:37px;
  right:4.347826%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .nomefile_ctrl {
}
.pg_import_dati_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_import_dati_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:8px;
  left:0.9400705%;
  right:792px;
  right:93.06698%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_import_dati_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_import_dati_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_import_dati_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  right:8px;
  width:30px;
  height:30px;
}
.pg_import_dati_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_dati_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  right:50px;
  width:30px;
  height:30px;
}
.pg_import_dati_portlet > .btnElab_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_dati_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:820px;
  left:96.35722%;
  right:11px;
  right:1.2925969%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .image5_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_import_dati_portlet > .rDest_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:44px;
  left:146px;
  left:17.156286%;
  right:517px;
  right:60.752056%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
}
.pg_import_dati_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:405px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_import_dati_portlet > .listaFile_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:204px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:200px;
}
.pg_import_dati_portlet > .Label18_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:46px;
  left:15px;
  left:1.7626323%;
  right:707px;
  right:83.07873%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_dati_portlet > .Label18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_dati_portlet > .Label18_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_dati_portlet > .btnDown_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  right:92px;
  width:30px;
  height:30px;
}
.pg_import_dati_portlet > .btnDown_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_dati_portlet > .chkaui_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:78px;
  left:16px;
  left:1.880141%;
  right:557px;
  right:65.45241%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .imperr_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:110px;
  left:16px;
  left:1.880141%;
  right:541px;
  right:63.57227%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .flgaggfam_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:142px;
  left:16px;
  left:1.880141%;
  right:529px;
  right:62.162163%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .flgimposv_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:78px;
  left:406px;
  left:47.70858%;
  right:179px;
  right:21.034077%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .btnStpErr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  right:50px;
  width:30px;
  height:30px;
}
.pg_import_dati_portlet > .btnStpErr_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_dati_portlet > .btnChkFile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  right:92px;
  width:30px;
  height:30px;
}
.pg_import_dati_portlet > .btnChkFile_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_dati_portlet > .btnStpChk_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  right:8px;
  width:30px;
  height:30px;
}
.pg_import_dati_portlet > .btnStpChk_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#037EFB;
}
.pg_import_dati_portlet > .creamo_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:110px;
  left:406px;
  left:47.70858%;
  right:179px;
  right:21.034077%;
  width:auto;
  height:20px;
}
.pg_import_dati_portlet > .norifimp_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:142px;
  left:406px;
  left:47.70858%;
  right:6px;
  right:0.70505285%;
  width:auto;
  height:20px;
  display:none;
}
.pg_import_dati_portlet > .flgforzaagg_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:174px;
  left:16px;
  left:1.880141%;
  right:456px;
  right:53.58402%;
  width:auto;
  height:20px;
  display:none;
}
.pg_import_dati_portlet > .actflg_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:851px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_import_dati_portlet > .actflg_ctrl {
  display:none;
}
.pg_import_dati_portlet > .actflg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_dati_portlet > .actria_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:851px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_import_dati_portlet > .actria_ctrl {
  display:none;
}
.pg_import_dati_portlet > .actria_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_dati_portlet > .opeunivoco_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:174px;
  left:406px;
  left:47.70858%;
  right:6px;
  right:0.70505285%;
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
 String def="[{\"h\":\"485\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"851\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"154\",\"x\":\"1045\",\"y\":\"-80\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"750\",\"x\":\"64\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"51\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"379\",\"y\":\"-67\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"813\",\"y\":\"36\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"771\",\"y\":\"36\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTSalva\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"820\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"rDest\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"188\",\"x\":\"146\",\"y\":\"44\",\"zindex\":\"2\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"name\":\"PortletLogs\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"851\",\"x\":\"0\",\"y\":\"405\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"200\",\"layout_steps_values\":{},\"name\":\"listaFile\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"851\",\"x\":\"0\",\"y\":\"204\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Destinazione Dati:\",\"w\":\"129\",\"x\":\"15\",\"y\":\"46\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"869\",\"y\":\"-82\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"869\",\"y\":\"-57\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"505\",\"y\":\"-67\"},{\"h\":\"20\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"255\",\"y\":\"-66\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnDown\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"729\",\"y\":\"73\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"629\",\"y\":\"-66\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Controllo preliminare dati import\",\"layout_steps_values\":{},\"name\":\"chkaui\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"278\",\"x\":\"16\",\"y\":\"78\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Importa i dati anche in presenza di errori\",\"layout_steps_values\":{},\"name\":\"imperr\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"294\",\"x\":\"16\",\"y\":\"110\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Aggiorna Famiglie (ARCHPERS\\u002fPERSNEW)\",\"layout_steps_values\":{},\"name\":\"flgaggfam\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"306\",\"x\":\"16\",\"y\":\"142\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Aggiorna Importo Netto (SV)\",\"layout_steps_values\":{},\"name\":\"flgimposv\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"266\",\"x\":\"406\",\"y\":\"78\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"fscarti\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"869\",\"y\":\"-32\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnStpErr\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"771\",\"y\":\"73\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnChkFile\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"729\",\"y\":\"36\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"errimp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"869\",\"y\":\"-7\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnStpChk\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"813\",\"y\":\"73\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTChkFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"869\",\"y\":\"18\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea modifiche su operazioni\",\"layout_steps_values\":{},\"name\":\"creamo\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"266\",\"x\":\"406\",\"y\":\"110\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"RTStpChkErr\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"869\",\"y\":\"43\"},{\"h\":\"20\",\"name\":\"RTStpErr\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"869\",\"y\":\"68\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Non utilizzare RIFIMP\\u002fINFORM per le modifiche\",\"layout_steps_values\":{},\"name\":\"norifimp\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"439\",\"x\":\"406\",\"y\":\"142\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Forza Aggiorna Famiglie (ARCHPERS\\u002fPERSNEW)\",\"layout_steps_values\":{},\"name\":\"flgforzaagg\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"379\",\"x\":\"16\",\"y\":\"174\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"actflg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"548\",\"y\":\"44\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"actria\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"403\",\"y\":\"47\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"Note38\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"outputFormat=PDF$|$XLS\",\"w\":\"200\",\"x\":\"1069\",\"y\":\"38\",\"zindex\":\"12\"},{\"h\":\"20\",\"name\":\"AggiornaDatiADE\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"120\",\"x\":\"870\",\"y\":\"92\"},{\"h\":\"20\",\"name\":\"gAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"870\",\"y\":\"117\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"File Unico Operazioni\\u002fFrazionate (ARCHOPE)\",\"layout_steps_values\":{},\"name\":\"opeunivoco\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"439\",\"x\":\"406\",\"y\":\"174\",\"zindex\":\"10\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_import_dati","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_import_dati_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_import_dati_portlet > .norifimp_ctrl {
  display:none;
}
.pg_import_dati_portlet > .flgforzaagg_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_import_dati','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomefile= "";
if(request.getAttribute("pg_import_dati_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label1= "NomeFile:";
String rDest="D";
String Label18= "Destinazione Dati:";
String dir= "";
String chkaui="N";
String imperr="N";
String flgaggfam="N";
String flgimposv="N";
double fscarti=0;
String errimp= "";
String creamo="N";
String norifimp="N";
String flgforzaagg="N";
String actflg=JSPLib.translateXSS(sp.getParameter("actflg",""));
String actria=JSPLib.translateXSS(sp.getParameter("actria",""));
String gAzienda=sp.getGlobal("gAzienda","");
String opeunivoco="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_import_dati_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_import_dati_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_import_dati_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_import_dati','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xea01;</a>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_image5' class='image image5_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_rDest' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<div id='<%=idPortlet%>_listaFile'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/list_imprich_portlet.jsp?ForcedPortletUID="+idPortlet+"_1esm17j",false);%></div>
<span id='<%=idPortlet%>_Label18'  formid='<%=idPortlet%>' ps-name='Label18'    class='label Label18_ctrl'><div id='<%=idPortlet%>_Label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Destinazione Dati:")%></div></span>
<a id='<%=idPortlet%>_btnDown' class='image btnDown_ctrl'   target=''>&#xebbd;</a>
<div id='<%=idPortlet%>_chkaui_div' style=''><input id='<%=idPortlet%>_chkaui' name='chkaui' class='checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Controllo preliminare sui dati (obbligatorio per soggetti vigilati)" )%> /><label for='<%=idPortlet%>_chkaui' class='label' title=<%=JSPLib.ToHTMLValue("Controllo preliminare sui dati (obbligatorio per soggetti vigilati)" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Controllo preliminare dati import")%></label></div>
<div id='<%=idPortlet%>_imperr_div' style=''><input id='<%=idPortlet%>_imperr' name='imperr' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_imperr' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Importa i dati anche in presenza di errori")%></label></div>
<div id='<%=idPortlet%>_flgaggfam_div' style=''><input id='<%=idPortlet%>_flgaggfam' name='flgaggfam' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgaggfam' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Aggiorna Famiglie (ARCHPERS/PERSNEW)")%></label></div>
<div id='<%=idPortlet%>_flgimposv_div' style=''><input id='<%=idPortlet%>_flgimposv' name='flgimposv' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgimposv' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Aggiorna Importo Netto (SV)")%></label></div>
<a id='<%=idPortlet%>_btnStpErr' class='image btnStpErr_ctrl'   target=''>&#xeb05;</a>
<a id='<%=idPortlet%>_btnChkFile' class='image btnChkFile_ctrl'   target=''>&#xe96e;</a>
<a id='<%=idPortlet%>_btnStpChk' class='image btnStpChk_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_creamo_div' style=''><input id='<%=idPortlet%>_creamo' name='creamo' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_creamo' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea modifiche su operazioni")%></label></div>
<div id='<%=idPortlet%>_norifimp_div' style=''><input id='<%=idPortlet%>_norifimp' name='norifimp' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_norifimp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Non utilizzare RIFIMP/INFORM per le modifiche")%></label></div>
<div id='<%=idPortlet%>_flgforzaagg_div' style=''><input id='<%=idPortlet%>_flgforzaagg' name='flgforzaagg' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgforzaagg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Forza Aggiorna Famiglie (ARCHPERS/PERSNEW)")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_actflg_wrp'><input id='<%=idPortlet%>_actflg' name='actflg' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='actflg' /></span>
<span class='textbox-container'id='<%=idPortlet%>_actria_wrp'><input id='<%=idPortlet%>_actria' name='actria' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='actria' /></span>
<div id='<%=idPortlet%>_opeunivoco_div' style=''><input id='<%=idPortlet%>_opeunivoco' name='opeunivoco' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_opeunivoco' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("File Unico Operazioni/Frazionate (ARCHOPE)")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_import_dati');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_import_dati',["851"],["485"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"485","title":"","layer":""}]);
this.SQLDataobj_intermbo=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_intermbo_tipint",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"server-client","cmd":"qbe_intermbo_tipint","cmdHash":"<%=JSPLib.cmdHash("qbe_intermbo_tipint",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_intermbo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_intermbo","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":154,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":1045,"y":-80});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":750,"x":64,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":8,"y":14,"zindex":"1"});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":120,"x":379,"y":-67});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":813,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'import dei dati",false,true)%>","hide":"false","hide_undercond":"errimp=1","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":771,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSalva=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_imp_dati",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSalva","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSalva","offline":false,"page":1,"parms":"w_tipodest=rDest,w_chkaui=chkaui,w_imperr=imperr,w_flgaggfam=flgaggfam,w_flgimposv=flgimposv,w_creamo=creamo,w_norifimp=norifimp,w_flgforzaagg=flgforzaagg,w_opeunivoco=opeunivoco","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_imp_dati","target":"","type":"SPLinker","w":120,"x":1,"y":-67});
this.RTSalva.m_cID='<%=JSPLib.cmdHash("routine,arrt_imp_dati",request.getSession())%>';
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":820,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.rDest=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Definitivo,Provvisorio","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rDest","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layer":false,"layout_steps_values":{},"name":"rDest","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,P","visible":true,"w":188,"x":146,"y":44,"zindex":"2"});
this.rDest.Value('<%=JSPLib.ToJSValue(rDest,false,true)%>');
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":851,"x":0,"y":405,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
if(this.listaFile=ZtVWeb.getPortletInc('<%=idPortlet%>_listaFile')){
this.listaFile.setContainer(this,'listaFile')
this.listaFile_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_listaFile","h":200,"hide":"false","layer":false,"layout_steps_values":{},"name":"listaFile","page":1,"portlet_id":"<%=idPortlet%>_1esm17j","spuid":"","type":"Portlet","w":851,"x":0,"y":204,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_listaFile').style.display='none';
}
this.Label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label18,false,true)%>","type":"Label","w":129,"x":15,"y":46,"zindex":"7"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":869,"y":-82});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":120,"x":505,"y":-67});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":255,"y":-66});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.btnDown=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDown_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDown","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva eventuali file di errore",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDown","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":729,"y":73,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_list_file_portlet.jsp","target":"","type":"SPLinker","w":120,"x":629,"y":-66});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_list_file_portlet.jsp",request.getSession())%>';
this.chkaui=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkaui","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Controllo preliminare dati import","layer":false,"layout_steps_values":{},"name":"chkaui","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":278,"x":16,"y":78,"zindex":"8"});
this.chkaui.Value('<%=chkaui%>');
this.imperr=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_imperr","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Importa i dati anche in presenza di errori","layer":false,"layout_steps_values":{},"name":"imperr","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":294,"x":16,"y":110,"zindex":"9"});
this.imperr.Value('<%=imperr%>');
this.flgaggfam=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgaggfam","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Aggiorna Famiglie (ARCHPERS\u002fPERSNEW)","layer":false,"layout_steps_values":{},"name":"flgaggfam","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":306,"x":16,"y":142,"zindex":"9"});
this.flgaggfam.Value('<%=flgaggfam%>');
this.flgimposv=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgimposv","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Aggiorna Importo Netto (SV)","layer":false,"layout_steps_values":{},"name":"flgimposv","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":266,"x":406,"y":78,"zindex":"10"});
this.flgimposv.Value('<%=flgimposv%>');
this.fscarti=new ZtVWeb._VC(this,'fscarti',null,'numeric',<%=fscarti%>,false,false);
this.btnStpErr=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnStpErr_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnStpErr","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Errori Controllo File",false,true)%>","hide":"false","hide_undercond":"errimp=0","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnStpErr","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":771,"y":73,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnChkFile=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnChkFile_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnChkFile","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Controllo file Import",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnChkFile","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96e;","srchover":"&#xe96f;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":729,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.errimp=new ZtVWeb._VC(this,'errimp',null,'character','<%=JSPLib.ToJSValue(errimp,false,true)%>',false,false);
this.btnStpChk=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnStpChk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnStpChk","edit_undercond":"","field":"","font_color":"#037EFB","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Errori Controllo Anagrafiche",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnStpChk","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":813,"y":73,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTChkFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_imp_dati_storico_exam",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChkFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChkFile","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_imp_dati_storico_exam","target":"","type":"SPLinker","w":111,"x":869,"y":18});
this.RTChkFile.m_cID='<%=JSPLib.cmdHash("routine,arrt_imp_dati_storico_exam",request.getSession())%>';
this.creamo=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_creamo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Crea modifiche su operazioni","layer":false,"layout_steps_values":{},"name":"creamo","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":266,"x":406,"y":110,"zindex":"10"});
this.creamo.Value('<%=creamo%>');
this.RTStpChkErr=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStpChkErr","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStpChkErr","offline":false,"page":1,"parms":"ReportName=arrp_stp_errimp_pers.vrp,outputFormat=PDF","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":111,"x":869,"y":43});
this.RTStpChkErr.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTStpErr=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStpErr","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStpErr","offline":false,"page":1,"parms":"ReportName=arrp_stp_errimp.vrp,FileName=Errori_rilevati_nel_controllo_file,formatTypes=PDF|XLS|XLSX","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":111,"x":869,"y":68});
this.RTStpErr.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.norifimp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_norifimp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"true","hide_undercond":"","init":"","init_par":"N","label_text":"Non utilizzare RIFIMP\u002fINFORM per le modifiche","layer":false,"layout_steps_values":{},"name":"norifimp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":439,"x":406,"y":142,"zindex":"10"});
this.norifimp.Value('<%=norifimp%>');
this.flgforzaagg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgforzaagg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"true","hide_undercond":"","init":"","init_par":"N","label_text":"Forza Aggiorna Famiglie (ARCHPERS\u002fPERSNEW)","layer":false,"layout_steps_values":{},"name":"flgforzaagg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":379,"x":16,"y":174,"zindex":"9"});
this.flgforzaagg.Value('<%=flgforzaagg%>');
this.actflg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_actflg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"actflg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(actflg,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"11","zoom":""});
this.actria=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_actria","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"actria","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(actria,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"11","zoom":""});
this.AggiornaDatiADE=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_AggiornaDatiADE","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"AggiornaDatiADE","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":120,"x":870,"y":92});
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.opeunivoco=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_opeunivoco","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"File Unico Operazioni\u002fFrazionate (ARCHOPE)","layer":false,"layout_steps_values":{},"name":"opeunivoco","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":439,"x":406,"y":174,"zindex":"10"});
this.opeunivoco.Value('<%=opeunivoco%>');
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
<%request.setAttribute("pg_import_dati_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.pg_import_dati_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof SQLDataobj_intermbo_ConsumersRendered !='undefined')this.SQLDataobj_intermbo_ConsumersRendered=SQLDataobj_intermbo_ConsumersRendered;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof RTSalva_Result !='undefined')this.RTSalva_Result=RTSalva_Result;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
if(typeof RTSaveFile_Result !='undefined')this.RTSaveFile_Result=RTSaveFile_Result;
if(typeof btnChkFile_Click !='undefined')this.btnChkFile_Click=btnChkFile_Click;
if(typeof RTChkFile_Result !='undefined')this.RTChkFile_Result=RTChkFile_Result;
if(typeof btnStpChk_Click !='undefined')this.btnStpChk_Click=btnStpChk_Click;
if(typeof btnStpErr_Click !='undefined')this.btnStpErr_Click=btnStpErr_Click;
if(typeof flgaggfam_onChange !='undefined')this.flgaggfam_onChange=flgaggfam_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.errimp.Value(),1),this.btnElab);
ZtVWeb.HideCtrl(Eq(this.errimp.Value(),0),this.btnStpErr);
}
this.getTitlePortlet().SetTitle('Import dati da procedure esterne',true);
this.getTitlePortlet().SetSubTitle('',true);
function this_Loaded(){  
  this.btnDown.Hide();  
  this.btnStpChk.Hide()
  this.flgforzaagg.Value('N')  
  this.flgforzaagg.Disabled()
  if (this.actflg.Value()=='S') {
    this.flgforzaagg.Show()
  }
  if (this.actria.Value()=='S') {    
    this.norifimp.Show()
    this.norifimp.Value(gAzienda='bef'?'S':'N');
  }
<%if(sp.isInGroup(3) || sp.isInGroup(4)){%>
  this.rDest.Value('P')
  this.rDest.Disabled()
<%}%>  
}
function SQLDataobj_intermbo_ConsumersRendered(){  
  if(this.SQLDataobj_intermbo.rs.VIGILATO=="1"){
  	this.chkaui.Value("S");
    this.chkaui.Disabled(); // Disabilito la possibilità di escludere il controllo
  }  
}
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function image5_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.btnDown.Hide();  
    this.btnStpChk.Hide()    
    this.PortletLogs.Start();
    this.listaFile.Timer0.Start();
    this.RTSalva.Link();
  }    
}
function Aggiorna() {
  this.RTSaveFile.Link();
  this.listaFile.ListaFile.Refresh()
}  
function RTSalva_Result(result){
  this.PortletLogs.Stop();
  this.listaFile.Timer0_onTimer();
  this.listaFile.Timer0.Stop();  
  if (result==0) {
    alert("Elaborazione Terminata con successo!");
    this.AggiornaDatiADE.Emit()
  }  
  if (result==1) {
    this.btnStpChk.Show();
    alert("Controllo anagrafiche terminato con errori\nPremere il bottone di stampa per l'esito");
  }  
  if (result==2) {
    this.btnDown.Show();      
    alert("Elaborazione Terminata con errori.\nPrelevare i file con gli errori");    
  }  
}
function btnDown_Click(){
  this.RTDownload.Link();
}
function RTSaveFile_Result(result){
  this.listaFile.ListaFile.Refresh()
}
function btnChkFile_Click(){
  if (confirm("Confermi il controllo dei file di import?")) {  
    this.PortletLogs.Start();
    this.listaFile.Timer0.Start();    
    this.RTChkFile.Link()
  }  
}
function RTChkFile_Result(result){  
  this.PortletLogs.Stop();
  this.listaFile.Timer0_onTimer();
  this.listaFile.Timer0.Stop();    
  this.errimp.Set(result);
  if (this.errimp.Value() == -1) {
    alert("Elaborazione Terminata. I file non rientrano tra quelli controllabili");
  }  
  
  if (this.errimp.Value()==0) {
    alert("Elaborazione Terminata. Non sono stati rilevati errori");
  }  
  if (this.errimp.Value() > 0) {
    alert("Elaborazione Terminata. Sono stati rilevati errori.\nLanciare la stampa per la verifica");
  }  
}
function btnStpChk_Click(){
  this.RTStpChkErr.Link()
}
function btnStpErr_Click(){
  this.RTStpErr.Link()
}
function flgaggfam_onChange(){
  if(this.flgaggfam.Value()=='S') {
    this.flgforzaagg.Enabled()
  } else {
    this.flgforzaagg.Value('N')
    this.flgforzaagg.Disabled()
  }  
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.pg_import_dati_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.btnDown.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnStpErr.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnChkFile.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnStpChk.dispatchEvent('OnLoad');
window.<%=idPortlet%>.AggiornaDatiADE.setParms();
window.<%=idPortlet%>.SQLDataobj_intermbo.firstQuery('true','',<%SQLExecute.JSONquery(sp,"qbe_intermbo_tipint",1,out,false, sp.getParameter((!JSPLib.Empty(sp.getParameter("dataprovider_namespace","")) ? sp.getParameter("dataprovider_namespace","") + "_" : "" )+"page_SQLDataobj_intermbo" ,"1"));%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_import_dati',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_import_dati');
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
sp.endPage("pg_import_dati");
}%>
<%! public String getJSPUID() { return "2791562553"; } %>