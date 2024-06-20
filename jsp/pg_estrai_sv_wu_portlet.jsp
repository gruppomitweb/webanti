<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.anno.Value(this.RTInit.Link());  \n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE DATI PER SV\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n  this.btnDownload.Hide()\n  this.btnUpdate.Hide()\n  this.btnRicarica.Hide()  \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()      \n  if(result=='KO') {\n    alert(\"Elaborazione Abortita. Contattare l'assistenza\");\n  } else {\n    alert(\"Elaborazione Completata. Prelevare il file con il bottone\");\n    this.ftypes.Value('TXT');\n    this.filename.Value(result);\n    this.btnDownload.Show()\n  }  \n}\n\nfunction RTTable_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()      \n  if(result=='KO') {\n    alert(\"Elaborazione Abortita. Contattare l'assistenza\");\n  } else {\n    alert(\"Elaborazione Completata. Creato il tabellone per l'analisi trimnestrale\");\n  }      \n}\n\nfunction btnCrea_Click(){\n  if (confirm(\"Confermi la creazione del tabellone trimestrale?\")) {    \n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTTable.Link();  \n  }    \n}\n\nfunction btnDownload_Click(){\n  if (confirm(\"Confermi il prelievo del file?\")) {    \n    this.cartella.Value(\"export\");\n    this.RTDownload.Link();    \n  }  \n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction btnCheck_Click(){\n  if (confirm(\"Confermi l'estrazione delle operazioni errate?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()         \n    this.iPrint.Reload()    \n    this.RTCheck.Link()\n  }  \n}\n\nfunction RTCheck_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()    \n  if (Empty(result)) {\n    alert('Non è stato creato nessun file di errori!')\n      this.btnElab.Show() \n  } else {    \n    this.filename.Value(result+\".xlsx\")\n    this.cartella.Value(\"appo\")\n    this.ftypes.Value('XLSX');  \n    this.RTDownloadXLSX.Link();\n    alert('Creazione file errori terminata!')\n  }  \n}\n\nfunction btnUpload_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction btnUpdate_Click(){\n  if (confirm(\"Confermi l'import del file delle correzioni?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()         \n    this.iPrint.Reload()    \n    this.RTUpdate.Link()\n  }   \n}\n\nfunction RTUpdate_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()       \n  if (result=='OK') {\n    alert('Elaborazione file correzioni eseguito correttamente!')\n  } else {\n    alert('Elaborazione file correzioni bloccato per presenza di errori')      \n  }  \n  this.btnExport.Show()\n  this.btnCrea.Show()\n  this.btnCheck.Show()  \n  this.btnUpdate.Hide()\n  this.nomefile.Value(\"\")\n  this.iPrint.Reload()\n}\n\nfunction btnExport_Click(){\n  if (confirm(\"Confermi la creazione della copia dei dati su file di testo?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()         \n    this.iPrint.Reload()    \n    this.RTExport.Link()\n  }   \n}\n\nfunction RTExport_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()       \n  this.filename.Value(result)\n  this.cartella.Value(\"flussi\")\n  this.ftypes.Value('TXT');  \n  this.RTDownloadTab.Link();\n  alert('Creazione file copia terminata!')  \n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n  this.btnUpdate.Show()\n  this.btnExport.Hide()\n  this.btnCrea.Hide()\n  this.btnCheck.Hide()\n  this.btnElab.Hide()  \n  this.btnRicarica.Show()    \n}  \n\nfunction btnRicarica_Click(){\n  if (confirm(\"Confermi il restore dell'archivio trimestrale?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()         \n    this.iPrint.Reload()    \n    this.RTRicarica.Link()\n  }   \n}\n\nfunction RTRicarica_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()       \n  if (result=='OK') {\n    alert('Restore della tabella trimestrale completato con successo!')  \n  } else {\n    alert('Errore nel restore della tabella trimestrale!')      \n  }  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"ESTRAZIONE DATI PER SV (WU)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"500","hsl":"false","htmlcode":"{{ @btnRicarica }}\n{{ @nomefile }}\n{{ @btnExport }}\n{{ @iPrint }}\n{{ @btnCrea }}\n{{ @btnCheck }}\n{{ @filename }}\n{{ @lblTri }}\n{{ @trimestre }}\n{{ @lblAnno }}\n{{ @anno }}\n{{ @pMsg }}\n{{ @pLog }}\n{{ @btnUpdate }}\n{{ @btnExit }}\n{{ @btnUpload }}\n{{ @btnElab }}\n{{ @label1 }}\n{{ @btnDownload }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva il file generato","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDownload","page":"1","path_type":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"683","y":"47","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"51","wireframe_props":"align,value,n_col","x":"84","y":"49","zindex":"1"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"3","type":"EventReceiver","w":"111","x":"858","y":"105"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"4","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"724","y":"46","zindex":"1"},{"alt":"","anchor":"top-left","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnUpload","page":"1","path_type":"","sequence":"5","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"573","y":"46","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"42","x":"857","y":"151"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"7","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"46","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"1024","y":"219"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"9","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"86","x":"847","y":"72"},{"allowedentities":"arfn_upload_file","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"120","x":"853","y":"184"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"arfn_estrai_sv_wu","target":"","type":"SPLinker","w":"120","x":"1013","y":"182"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella,pTipo=ftypes,pDir=A","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":"120","x":"1012","y":"145"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Corregge Tabellone Trimestrale","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnUpdate","page":"1","path_type":"","sequence":"13","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"724","y":"9","zindex":"0"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cartella","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"499","y":"-61"},{"anchor":"","ctrlOfVariant":"","h":"128","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"15","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"82","zindex":""},{"anchor":"","ctrlOfVariant":"","h":"63","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"16","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"211","zindex":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"53","wireframe_props":"name","x":"141","y":"10","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"10","y":"15","zindex":"1"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"trimestre","page":"1","picture":"","sequence":"19","spuid":"","tabindex":"","textlist":"I Trimestre,II Trimestre,III Trimestre,IV Trimestre","type":"Combobox","typevar":"character","valuelist":"1,2,3,4","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"10","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTri","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Trimestre:","w":"69","wireframe_props":"align,value,n_col","x":"236","y":"15","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"filename","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"21","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"149","wireframe_props":"name","x":"660","y":"-60","zerofilling":"false","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"1012","y":"110"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTInit","offline":"false","page":"1","parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"23","servlet":"arfn_initdate","target":"","type":"SPLinker","w":"120","x":"1009","y":"73"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Effettua il controllo dei dati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnCheck","page":"1","path_type":"","sequence":"24","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"683","y":"9","zindex":"0"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCheck","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pTipo=C,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"25","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":"120","x":"1017","y":"6"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90c;","font_image_hover":"&#xe90d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Crea Tabellone Trimestrale","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnCrea","page":"1","path_type":"","sequence":"26","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"644","y":"9","zindex":"0"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"27","m_cAction":"function","name":"RTTable","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pTipo=T,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"27","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":"120","x":"1017","y":"-18"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"ftypes","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"855","y":"15"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"outFile","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"855","y":"-52"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"_datini","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"862","y":"-91"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"_datfin","page":"1","reactive":"","sequence":"31","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1007","y":"-92"},{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","h":"199","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"32","spuid":"","type":"Iframe","w":"793","wireframe_props":"","x":"3","y":"276","zindex":"9"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe904;","font_image_hover":"&#xe905;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Scarica Tabellone Trimestrale","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExport","page":"1","path_type":"","sequence":"33","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"9","zindex":"0"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"34","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"431","wireframe_props":"name","x":"140","y":"46","zerofilling":"false","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa","offline":"false","page":"1","parms":"ReportName=arrp_estrai_sv_chk.vrp,FileName=outFile,pDADATA=c_dadate,pA_DATA=c_adate,formatTypes=ftypes,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,SubstituteQuery=qbe_estrai_sv_ope_chk_wu,hidePreview=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"35","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"1013","y":"-45"},{"allowedentities":"arfn_import_correzioni_sv_wu","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTUpdate","offline":"false","page":"1","parms":"nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"36","servlet":"arfn_import_correzioni_sv_wu","target":"","type":"SPLinker","w":"120","x":"1023","y":"247"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownloadXLSX","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"37","servlet":"arrt_downloadxlsx","target":"iPrint","type":"SPLinker","w":"120","x":"1024","y":"285"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExport","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pTipo=X,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"38","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":"120","x":"1019","y":"313"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9a9;","font_image_hover":"&#xe9aa;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Crea Tabellone Trimestrale","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnRicarica","page":"1","path_type":"","sequence":"39","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"644","y":"47","zindex":"0"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTRicarica","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pTipo=R,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"40","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":"120","x":"1020","y":"344"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownloadTab","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella,pTipo=ftypes,pDir=D","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"41","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":"120","x":"1022","y":"376"}]%>
<%/*Description:ESTRAZIONE DATI PER SV (WU)*/%>
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
window.pg_estrai_sv_wu_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof RTTable_Result !='undefined')this.RTTable_Result=RTTable_Result;
if(typeof btnCrea_Click !='undefined')this.btnCrea_Click=btnCrea_Click;
if(typeof btnDownload_Click !='undefined')this.btnDownload_Click=btnDownload_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnCheck_Click !='undefined')this.btnCheck_Click=btnCheck_Click;
if(typeof RTCheck_Result !='undefined')this.RTCheck_Result=RTCheck_Result;
if(typeof btnUpload_Click !='undefined')this.btnUpload_Click=btnUpload_Click;
if(typeof btnUpdate_Click !='undefined')this.btnUpdate_Click=btnUpdate_Click;
if(typeof RTUpdate_Result !='undefined')this.RTUpdate_Result=RTUpdate_Result;
if(typeof btnExport_Click !='undefined')this.btnExport_Click=btnExport_Click;
if(typeof RTExport_Result !='undefined')this.RTExport_Result=RTExport_Result;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof btnRicarica_Click !='undefined')this.btnRicarica_Click=btnRicarica_Click;
if(typeof RTRicarica_Result !='undefined')this.RTRicarica_Result=RTRicarica_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
function this_Loaded(){
  this.anno.Value(this.RTInit.Link());  
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("ESTRAZIONE DATI PER SV",true)
  this.getTitlePortlet().SetSubTitle("",true)
  this.btnDownload.Hide()
  this.btnUpdate.Hide()
  this.btnRicarica.Hide()  
}
function btnElab_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()      
  if(result=='KO') {
    alert("Elaborazione Abortita. Contattare l'assistenza");
  } else {
    alert("Elaborazione Completata. Prelevare il file con il bottone");
    this.ftypes.Value('TXT');
    this.filename.Value(result);
    this.btnDownload.Show()
  }  
}
function RTTable_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()      
  if(result=='KO') {
    alert("Elaborazione Abortita. Contattare l'assistenza");
  } else {
    alert("Elaborazione Completata. Creato il tabellone per l'analisi trimnestrale");
  }      
}
function btnCrea_Click(){
  if (confirm("Confermi la creazione del tabellone trimestrale?")) {    
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTTable.Link();  
  }    
}
function btnDownload_Click(){
  if (confirm("Confermi il prelievo del file?")) {    
    this.cartella.Value("export");
    this.RTDownload.Link();    
  }  
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function btnCheck_Click(){
  if (confirm("Confermi l'estrazione delle operazioni errate?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()         
    this.iPrint.Reload()    
    this.RTCheck.Link()
  }  
}
function RTCheck_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()    
  if (Empty(result)) {
    alert('Non è stato creato nessun file di errori!')
      this.btnElab.Show() 
  } else {    
    this.filename.Value(result+".xlsx")
    this.cartella.Value("appo")
    this.ftypes.Value('XLSX');  
    this.RTDownloadXLSX.Link();
    alert('Creazione file errori terminata!')
  }  
}
function btnUpload_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function btnUpdate_Click(){
  if (confirm("Confermi l'import del file delle correzioni?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()         
    this.iPrint.Reload()    
    this.RTUpdate.Link()
  }   
}
function RTUpdate_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()       
  if (result=='OK') {
    alert('Elaborazione file correzioni eseguito correttamente!')
  } else {
    alert('Elaborazione file correzioni bloccato per presenza di errori')      
  }  
  this.btnExport.Show()
  this.btnCrea.Show()
  this.btnCheck.Show()  
  this.btnUpdate.Hide()
  this.nomefile.Value("")
  this.iPrint.Reload()
}
function btnExport_Click(){
  if (confirm("Confermi la creazione della copia dei dati su file di testo?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()         
    this.iPrint.Reload()    
    this.RTExport.Link()
  }   
}
function RTExport_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()       
  this.filename.Value(result)
  this.cartella.Value("flussi")
  this.ftypes.Value('TXT');  
  this.RTDownloadTab.Link();
  alert('Creazione file copia terminata!')  
}
function Aggiorna() {
  this.RTSaveFile.Link();
  this.btnUpdate.Show()
  this.btnExport.Hide()
  this.btnCrea.Hide()
  this.btnCheck.Hide()
  this.btnElab.Hide()  
  this.btnRicarica.Show()    
}  
function btnRicarica_Click(){
  if (confirm("Confermi il restore dell'archivio trimestrale?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()         
    this.iPrint.Reload()    
    this.RTRicarica.Link()
  }   
}
function RTRicarica_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()       
  if (result=='OK') {
    alert('Restore della tabella trimestrale completato con successo!')  
  } else {
    alert('Errore nel restore della tabella trimestrale!')      
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
.pg_estrai_sv_wu_container {
}
.pg_estrai_sv_wu_title_container {
  margin: auto;
}
.pg_estrai_sv_wu_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:500px;
}
.pg_estrai_sv_wu_portlet[Data-page="1"]{
  height:500px;
  width:100%;
}
.pg_estrai_sv_wu_portlet > .btnDownload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  right:87px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnDownload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:84px;
  width:51px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_wu_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_wu_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_wu_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  right:46px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .btnUpload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:573px;
  width:20px;
  height:20px;
}
.pg_estrai_sv_wu_portlet > .btnUpload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_estrai_sv_wu_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .btnUpdate_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:46px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnUpdate_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:82px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:128px;
}
.pg_estrai_sv_wu_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:211px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:63px;
}
.pg_estrai_sv_wu_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:141px;
  width:53px;
  height:20px;
}
.pg_estrai_sv_wu_portlet > .anno_ctrl {
}
.pg_estrai_sv_wu_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_wu_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:10px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_wu_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_wu_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_wu_portlet > .trimestre_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sv_wu_portlet > .lblTri_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:236px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_wu_portlet > .lblTri_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_wu_portlet > .lblTri_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_wu_portlet > .filename_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:800px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_estrai_sv_wu_portlet > .filename_ctrl {
  display:none;
}
.pg_estrai_sv_wu_portlet > .filename_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_wu_portlet > .btnCheck_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:87px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnCheck_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .btnCrea_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:126px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnCrea_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:276px;
  left:3px;
  right:4px;
  width:auto;
  height:199px;
}
.pg_estrai_sv_wu_portlet > .btnExport_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnExport_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_wu_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:140px;
  width:431px;
  height:20px;
}
.pg_estrai_sv_wu_portlet > .nomefile_ctrl {
}
.pg_estrai_sv_wu_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_wu_portlet > .btnRicarica_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:47px;
  right:126px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_wu_portlet > .btnRicarica_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"683\",\"y\":\"47\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"51\",\"x\":\"84\",\"y\":\"49\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"858\",\"y\":\"105\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"724\",\"y\":\"46\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"573\",\"y\":\"46\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"42\",\"x\":\"857\",\"y\":\"151\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"46\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1024\",\"y\":\"219\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"86\",\"x\":\"847\",\"y\":\"72\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"853\",\"y\":\"184\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1013\",\"y\":\"182\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1012\",\"y\":\"145\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"724\",\"y\":\"9\",\"zindex\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"499\",\"y\":\"-61\"},{\"anchor\":\"\",\"h\":\"128\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"82\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"63\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"211\",\"zindex\":\"\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"141\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"10\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trimestre\",\"page\":\"1\",\"textlist\":\"I Trimestre,II Trimestre,III Trimestre,IV Trimestre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTri\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Trimestre:\",\"w\":\"69\",\"x\":\"236\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"filename\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"149\",\"x\":\"660\",\"y\":\"-60\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTClean\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1012\",\"y\":\"110\"},{\"h\":\"20\",\"name\":\"RTInit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1009\",\"y\":\"73\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnCheck\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"683\",\"y\":\"9\",\"zindex\":\"0\"},{\"h\":\"20\",\"name\":\"RTCheck\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1017\",\"y\":\"6\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnCrea\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"644\",\"y\":\"9\",\"zindex\":\"0\"},{\"h\":\"27\",\"name\":\"RTTable\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1017\",\"y\":\"-18\"},{\"h\":\"20\",\"name\":\"ftypes\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"855\",\"y\":\"15\"},{\"h\":\"20\",\"name\":\"outFile\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"855\",\"y\":\"-52\"},{\"h\":\"20\",\"name\":\"_datini\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"862\",\"y\":\"-91\"},{\"h\":\"20\",\"name\":\"_datfin\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1007\",\"y\":\"-92\"},{\"anchor\":\"top-left-right\",\"h\":\"199\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"793\",\"x\":\"3\",\"y\":\"276\",\"zindex\":\"9\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExport\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"9\",\"zindex\":\"0\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"431\",\"x\":\"140\",\"y\":\"46\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1013\",\"y\":\"-45\"},{\"h\":\"20\",\"name\":\"RTUpdate\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1023\",\"y\":\"247\"},{\"h\":\"20\",\"name\":\"RTDownloadXLSX\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1024\",\"y\":\"285\"},{\"h\":\"20\",\"name\":\"RTExport\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1019\",\"y\":\"313\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnRicarica\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"644\",\"y\":\"47\",\"zindex\":\"0\"},{\"h\":\"20\",\"name\":\"RTRicarica\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1020\",\"y\":\"344\"},{\"h\":\"20\",\"name\":\"RTDownloadTab\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1022\",\"y\":\"376\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrai_sv_wu","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrai_sv_wu_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrai_sv_wu','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label1= "NomeFile:";
String dir= "";
String cartella= "";
String anno= "";
if(request.getAttribute("pg_estrai_sv_wu_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String trimestre= "";
String lblTri= "Trimestre:";
String filename= "";
String ftypes= "";
String outFile= "";
String _datini= "";
String _datfin= "";
String nomefile= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrai_sv_wu_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estrai_sv_wu_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrai_sv_wu_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrai_sv_wu','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnDownload' class='image btnDownload_ctrl'   target=''>&#xebbd;</a>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnUpload' class='image btnUpload_ctrl'   target=''>&#xe9da;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_btnUpdate' class='image btnUpdate_ctrl'   target=''>&#xea8c;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<select id='<%=idPortlet%>_trimestre' name='trimestre' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblTri'  formid='<%=idPortlet%>' ps-name='lblTri'    class='label lblTri_ctrl'><div id='<%=idPortlet%>_lblTritbl' style='width:100%;'><%=JSPLib.ToHTML("Trimestre:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_filename_wrp'><input id='<%=idPortlet%>_filename' name='filename' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='filename' /></span>
<a id='<%=idPortlet%>_btnCheck' class='image btnCheck_ctrl'   target=''>&#xe96e;</a>
<a id='<%=idPortlet%>_btnCrea' class='image btnCrea_ctrl'   target=''>&#xe90c;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<a id='<%=idPortlet%>_btnExport' class='image btnExport_ctrl'   target=''>&#xe904;</a>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<a id='<%=idPortlet%>_btnRicarica' class='image btnRicarica_ctrl'   target=''>&#xe9a9;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrai_sv_wu');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrai_sv_wu',["800"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"500","title":"","layer":"false","npage":"1"}]);
this.btnDownload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDownload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDownload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva il file generato",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDownload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":683,"y":47,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":84,"y":49,"zindex":"1"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":858,"y":105});
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":724,"y":46,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnUpload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image btnUpload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnUpload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnUpload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":573,"y":46,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":46,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":1024,"y":219});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":86,"x":847,"y":72});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":120,"x":853,"y":184});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_estrai_sv_wu","target":"","type":"SPLinker","w":120,"x":1013,"y":182});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_estrai_sv_wu",request.getSession())%>';
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella,pTipo=ftypes,pDir=A","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":120,"x":1012,"y":145});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadfile",request.getSession())%>';
this.btnUpdate=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnUpdate_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnUpdate","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Corregge Tabellone Trimestrale",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnUpdate","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":724,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.cartella=new ZtVWeb._VC(this,'cartella',null,'character','<%=JSPLib.ToJSValue(cartella,false,true)%>',false,false);
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":793,"x":3,"y":82,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":63,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":793,"x":3,"y":211,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(anno,false,true)%>","w":53,"x":141,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":10,"y":15,"zindex":"1"});
this.trimestre=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_trimestre","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=trimestre%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"trimestre","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"I Trimestre,II Trimestre,III Trimestre,IV Trimestre","type":"Combobox","typevar":"character","valuelist":"1,2,3,4","visible":true,"w":212,"x":304,"y":10,"zindex":"1"});
this.lblTri=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTri","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTri","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTri,false,true)%>","type":"Label","w":69,"x":236,"y":15,"zindex":"1"});
this.filename=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_filename","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"filename","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(filename,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":1012,"y":110});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.RTInit=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTInit","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTInit","offline":false,"page":1,"parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_initdate","target":"","type":"SPLinker","w":120,"x":1009,"y":73});
this.RTInit.m_cID='<%=JSPLib.cmdHash("routine,arfn_initdate",request.getSession())%>';
this.btnCheck=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnCheck_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCheck","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Effettua il controllo dei dati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnCheck","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96e;","srchover":"&#xe96f;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":683,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTCheck=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCheck","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCheck","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pTipo=C,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":120,"x":1017,"y":6});
this.RTCheck.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check_wu",request.getSession())%>';
this.btnCrea=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnCrea_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCrea","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90c;","font_image_hover":"&#xe90d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Crea Tabellone Trimestrale",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnCrea","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe90c;","srchover":"&#xe90d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":644,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTTable=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTTable","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":27,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTTable","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pTipo=T,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":120,"x":1017,"y":-18});
this.RTTable.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check_wu",request.getSession())%>';
this.ftypes=new ZtVWeb._VC(this,'ftypes',null,'character','<%=JSPLib.ToJSValue(ftypes,false,true)%>',false,false);
this.outFile=new ZtVWeb._VC(this,'outFile',null,'character','<%=JSPLib.ToJSValue(outFile,false,true)%>',false,false);
this._datini=new ZtVWeb._VC(this,'_datini',null,'character','<%=JSPLib.ToJSValue(_datini,false,true)%>',false,false);
this._datfin=new ZtVWeb._VC(this,'_datfin',null,'character','<%=JSPLib.ToJSValue(_datfin,false,true)%>',false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":199,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":793,"x":3,"y":276,"zindex":"9"});
this.btnExport=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExport_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExport","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe904;","font_image_hover":"&#xe905;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Scarica Tabellone Trimestrale",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExport","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe904;","srchover":"&#xe905;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":431,"x":140,"y":46,"zerofilling":false,"zindex":"1","zoom":""});
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"ReportName=arrp_estrai_sv_chk.vrp,FileName=outFile,pDADATA=c_dadate,pA_DATA=c_adate,formatTypes=ftypes,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,SubstituteQuery=qbe_estrai_sv_ope_chk_wu,hidePreview=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":1013,"y":-45});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTUpdate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_import_correzioni_sv_wu",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpdate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpdate","offline":false,"page":1,"parms":"nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_import_correzioni_sv_wu","target":"","type":"SPLinker","w":120,"x":1023,"y":247});
this.RTUpdate.m_cID='<%=JSPLib.cmdHash("routine,arfn_import_correzioni_sv_wu",request.getSession())%>';
this.RTDownloadXLSX=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownloadXLSX","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownloadXLSX","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadxlsx","target":"iPrint","type":"SPLinker","w":120,"x":1024,"y":285});
this.RTDownloadXLSX.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadxlsx",request.getSession())%>';
this.RTExport=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExport","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExport","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pTipo=X,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":120,"x":1019,"y":313});
this.RTExport.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check_wu",request.getSession())%>';
this.btnRicarica=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnRicarica_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnRicarica","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9a9;","font_image_hover":"&#xe9aa;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Crea Tabellone Trimestrale",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnRicarica","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9a9;","srchover":"&#xe9aa;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":644,"y":47,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTRicarica=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRicarica","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRicarica","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pTipo=R,pFile=nomefile","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check_wu","target":"","type":"SPLinker","w":120,"x":1020,"y":344});
this.RTRicarica.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check_wu",request.getSession())%>';
this.RTDownloadTab=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownloadTab","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownloadTab","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella,pTipo=ftypes,pDir=D","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":120,"x":1022,"y":376});
this.RTDownloadTab.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadfile",request.getSession())%>';
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
<%if(request.getAttribute("pg_estrai_sv_wu_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrai_sv_wu_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrai_sv_wu_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnDownload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnUpload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnUpdate.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnCheck.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnCrea.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExport.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnRicarica.dispatchEvent('OnLoad');
window.<%=idPortlet%>.trimestre.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrai_sv_wu',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrai_sv_wu');
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
sp.endPage("pg_estrai_sv_wu");
}%>
<%! public String getJSPUID() { return "2877075539"; } %>