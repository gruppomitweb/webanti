<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Import Fotografia Anagrafe Rapporti',true);\n\nfunction IDSID_onChange(){\n  this.getTitlePortlet().SetSubTitle('Identificativo SID: '+this.IDSID.Value()+' - File elaborabili da questa maschera: ATPEC05.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m.enc',true);\n}\n\nfunction this_Loaded(){\n  this.dirdest.Value(\"SID\u002fMIGRA\u002fELB\");\n\u002f\u002f   this.btnExcel.Hide()\n  if (this.gFlgIPMT.Value()!='S') {\n    this.flgwrt.Hide();\n    this.ADatOpe.Hide();\n    this.DaDatOpe.Hide();\n    this.lblAOpe.Hide();\n    this.lblDaOpe.Hide();\n  }  \n\u002f\u002f   this.formati.Value('PDF|XLS|CSV');\n  this.getTitlePortlet().AppendButton({\n    id:\"Importa\",\n    title:FormatMsg('Importa'),\n    tooltip:FormatMsg('Importa i dati delle famiglie in WEBANTI'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe912\"},\n    action:'javascript:' + this.formid +'.Importa()'\n  },2);    \n}\n\nfunction image_upload_Click(){\n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction Aggiorna() {\n  var idsid;\n  this.listaFile.ListaFile.Refresh();\n  if(Lower(Substr(this.nomefile.Value(),RAt('.',this.nomefile.Value())+1))!='zip'){\n    if(Left(LRTrim(this.nomefile.Value()),8)!='ATPEC05.'){\n      alert('Attenzione!!!\\n Il file caricato non è una fotografia');\n      this.btnElab.Hide();\n    }\n    idsid=Substr(this.nomefile.Value(),At('.',this.nomefile.Value())+1,At('.',this.nomefile.Value(),1));\n    if(idsid!=this.IDSID.Value()){\n      alert('Attenzione!!!\\n Il file caricato non è di questo intermediario');\n      this.btnElab.Hide();\n    }\n  }\n  this.RTSaveFile.Link();\n  this.RTAzzera.Link();\n  this.pLog.Timer0_onTimer();\n  this.pMsg.Timer0_onTimer();\n  this.elaborazione.Reload();\n  this.elaborazione.Reload();\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.btnElab.Disabled();\n    this.btnFoto.Disabled();\n    this.btnReport.Disabled();\n    this.pMsg.Timer0.Start();\n    this.pLog.Timer0.Start();\n    this.listaFile.Timer0.Start();\n    this.RTElabora.Link();\n  }\n}\n\nfunction RTElabora_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pLog.Timer0_onTimer();\n  this.listaFile.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0.Stop();\n  this.listaFile.Timer0.Stop();\n  this.btnElab.Enabled();\n  this.btnFoto.Enabled();\n  this.btnReport.Enabled();\n\u002f*\n  if (this.gFlgIPMT.Value()=='S') {  \n    this.btnExcel.Hide()\n  }\n*\u002f  \n  alert(\"Elaborazione Terminata con successo!\");\n}\n\nfunction RTSaveFile_Result(result){\n  if(result=='OK') {\n    this.listaFile.ListaFile.Refresh();\n  } else {\n    alert(result);\n  }\n}\n\nfunction btnReport_Click(){\n  this.pMsg.Timer0.Start();\n  this.pLog.Timer0.Start();\n  this.listaFile.Timer0.Start();\n  this.RTReport.Link();\n}\n\n\u002f\u002f function btnExcel_Click(){\n\u002f\u002f   this.pMsg.Timer0.Start();\n\u002f\u002f   this.pLog.Timer0.Start();\n\u002f\u002f   this.listaFile.Timer0.Start();  \n\u002f\u002f   this.RTExcel.Link()\n\u002f\u002f }\n\nfunction RTReport_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pLog.Timer0_onTimer();\n  this.listaFile.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0.Stop();\n  this.nomerep.Value(result);\n  this.RTStampa.Link();\n}\n\nfunction btnFoto_Click(){\n  this.RTStampaFoto.Link();\n}\n\nfunction Importa() {\n  if (confirm(\"Confermi l'import della fotografia?\")) {\n    this.pMsg.Timer0.Start();\n    this.pLog.Timer0.Start();\n    this.RTImport.Link();\n  }  \n}    ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"590","hsl":"","htmlcode":"{{ @chknoe }} \n{{ @image_upload }}\n{{ gDescAzi }}\n{{ gFlgIPMT }}\n{{ RTAzzera }}\n{{ nomefile }}\n{{ ADatOpe }}\n{{ label1 }}\n{{ lblDaOpe }}\n{{ dir }}\n{{ RTUpload }}\n{{ dirdest }}\n{{ Event_filename }}\n{{ RTSaveFile }}\n{{ lblAOpe }}\n{{ btnExit }}\n{{ btnElab }}\n{{ RTElabora }}\n{{ image_upload }}\n{{ listaFile }}\n{{ flgwrt }}\n{{ pLog }}\n{{ pMsg }}\n{{ elaborazione }}\n{{ btnReport }}{{ filename }}\n{{ RTReport }}\n{{ RTExcel }}\n{{ DaDatOpe }}\n{{ nomerep }}\n{{ formati }}\n{{ RTStampa }}\n{{ btnFoto }}\n{{ RTStampaFoto }}\n{{ cAzzera }}\n{{ RTUscita }}\n{{ SQLDataobj_armt_intermbo }}\n{{ IDSID }}\n{{ @cAzzera }}\n{{ @btnFoto }}\n{{ @DaDatOpe }}\n{{ @btnReport }}\n{{ @listaFile }}\n{{ @pMsg }}\n{{ @flgwrt }}\n{{ @pLog }}\n{{ @image5 }}\n{{ @elaborazione }}\n{{ @btnElab }}\n{{ @btnExit }}\n{{ @lblAOpe }}\n{{ @lblDaOpe }}\n{{ @label1 }}\n{{ @ADatOpe }}\n{{ @nomefile }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"800","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"750","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"764","y":"-73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gFlgIPMT","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"764","y":"-50"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function autoexec","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"111","x":"764","y":"-25"},{"allowedqueries":"BO:armt_intermbo","appendingData":"false","auto_exec":"server-client","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1","name":"SQLDataobj_armt_intermbo","offline":"false","page":"1","parms":"","parms_source":"","query":"BO:armt_intermbo","query_async":"true","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"183","x":"764","y":"16"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDataobj_armt_intermbo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDSID","h":"20","init":"","init_par":"","name":"IDSID","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"764","y":"38"},{"align":"right","anchor":"","assoc_input":"nomefile","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"100","wireframe_props":"align,value,n_col","x":"8","y":"10","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"319","wireframe_props":"name","x":"108","y":"10","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"image_upload","page":"1","path_type":"","sequence":"8","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"428","y":"10","zindex":"1"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Elabora i file selezionati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"9","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_execute.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"665","y":"4","zindex":"1"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Azzera tabella di destinazione","layer":"false","layout_steps_values":"{}","name":"cAzzera","page":"1","sequence":"10","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"213","wireframe_props":"label_text","x":"450","y":"10","zindex":"14"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#0C1DF3","font_color_hover":"#0C1DF3","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampe Fotografia Anagrafe Rapporti","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnFoto","page":"1","path_type":"","sequence":"11","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"699","y":"4","zindex":"1"},{"align":"right","anchor":"","assoc_input":"DaDatOpe","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"144","wireframe_props":"align,value,n_col","x":"25","y":"34","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"100","wireframe_props":"name","x":"173","y":"34","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"","assoc_input":"ADatOpe","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"144","wireframe_props":"align,value,n_col","x":"25","y":"54","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"100","wireframe_props":"name","x":"173","y":"54","zerofilling":"false","zindex":"2"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"22","help_tips":"Modalità Scrittura Errori","hide":"false","hide_undercond":"","init":"","init_par":"D","layer":"false","layout_steps_values":"{}","name":"flgwrt","page":"1","picture":"","sequence":"16","spuid":"","tabindex":"","textlist":"Scrittura Errori Memoria,Scrittura Errori Archivio","type":"Combobox","typevar":"character","valuelist":"M,D","visible":"true","w":"160","wireframe_props":"name,textlist","x":"279","y":"44","zindex":"13"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampe risultato controllo","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnReport","page":"1","path_type":"","sequence":"17","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"450","y":"43","zindex":"1"},{"anchor":"","ctrlOfVariant":"","h":"150","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"listaFile","page":"1","sequence":"18","spuid":"","src":"list_imprich_portlet.jsp","themed":"false","type":"Portlet","w":"750","wireframe_props":"","x":"0","y":"113","zindex":"6"},{"anchor":"","ctrlOfVariant":"","h":"42","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"19","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"750","wireframe_props":"","x":"0","y":"263","zindex":"3"},{"anchor":"top-left(%)-right","ctrlOfVariant":"","h":"89","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"20","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"750","wireframe_props":"","x":"0","y":"305","zindex":"3"},{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"178","hide":"false","layer":"false","layout_steps_values":"{}","name":"elaborazione","page":"1","sequence":"21","spuid":"","type":"Iframe","w":"750","wireframe_props":"","x":"0","y":"394","zindex":"11"},{"calculate":"'Tmp\u002f'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"dir","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"764","y":"75"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dirdest","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"764","y":"97"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"24","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"111","x":"764","y":"118"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"25","type":"EventReceiver","w":"111","x":"883","y":"75"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=dirdest,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"26","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"111","x":"883","y":"118"},{"allowedentities":"arrt_fammigra","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTElabora","offline":"false","page":"1","parms":"pAzzera=cAzzera","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"27","servlet":"arrt_fammigra","target":"","type":"SPLinker","w":"111","x":"764","y":"173"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"nomerep","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"764","y":"208"},{"allowedentities":"arrt_fammigra_stp","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTReport","offline":"false","page":"1","parms":"w_dadata=DaDatOpe,w_a_data=ADatOpe,w_flgwrt=flgwrt,w_flgnoe=chknoe","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"29","servlet":"arrt_fammigra_stp","target":"","type":"SPLinker","w":"111","x":"764","y":"230"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"routine caller","name":"RTExcel","offline":"false","page":"1","parms":"ReportName=arrp_stp_errimp.vrp,outputFormat=PDF","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"30","servlet":"arrt_fam_xls_esiti_sid","target":"","type":"SPLinker","w":"111","x":"764","y":"261"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa","offline":"false","page":"1","parms":"ReportName=nomerep,w_DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,formatTypes=formati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"31","servlet":"","target":"elaborazione","type":"SPLinker","w":"111","x":"764","y":"283"},{"calculate":"'PDF$|$XLS$|$XLSX$|$CSV'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"formati","page":"1","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"character","w":"111","x":"764","y":"311"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampaFoto","offline":"false","page":"1","parms":"ReportName=arrp_famesiti_stp,DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,formatTypes=formati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"33","servlet":"","target":"elaborazione","type":"SPLinker","w":"111","x":"764","y":"333"},{"allowedentities":"arrt_fammigra_imp","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTImport","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"34","servlet":"arrt_fammigra_imp","target":"","type":"SPLinker","w":"111","x":"763","y":"357"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Non controllare operazioni\u002frapporti non presenti","layer":"false","layout_steps_values":"{}","name":"chknoe","page":"1","sequence":"35","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"411","wireframe_props":"label_text","x":"282","y":"85","zindex":"15"}]%>
<%/*Description:*/%>
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
window.pg_fam_esiti_foto_Static=function(){
if(typeof IDSID_onChange !='undefined')this.IDSID_onChange=IDSID_onChange;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof image_upload_Click !='undefined')this.image_upload_Click=image_upload_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTElabora_Result !='undefined')this.RTElabora_Result=RTElabora_Result;
if(typeof RTSaveFile_Result !='undefined')this.RTSaveFile_Result=RTSaveFile_Result;
if(typeof btnReport_Click !='undefined')this.btnReport_Click=btnReport_Click;
if(typeof RTReport_Result !='undefined')this.RTReport_Result=RTReport_Result;
if(typeof btnFoto_Click !='undefined')this.btnFoto_Click=btnFoto_Click;
if(typeof Importa !='undefined')this.Importa=Importa;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('Tmp/',this.dir);
ZtVWeb.InitCtrl('PDF|XLS|XLSX|CSV',this.formati);
this.SQLDataobj_armt_intermbo.addDataConsumer(this.IDSID,<%=JSPLib.ToJSValue("IDSID",true)%>);
this.getTitlePortlet().SetTitle('Import Fotografia Anagrafe Rapporti',true);
function IDSID_onChange(){
  this.getTitlePortlet().SetSubTitle('Identificativo SID: '+this.IDSID.Value()+' - File elaborabili da questa maschera: ATPEC05.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m.enc',true);
}
function this_Loaded(){
  this.dirdest.Value("SID/MIGRA/ELB");
//   this.btnExcel.Hide()
  if (this.gFlgIPMT.Value()!='S') {
    this.flgwrt.Hide();
    this.ADatOpe.Hide();
    this.DaDatOpe.Hide();
    this.lblAOpe.Hide();
    this.lblDaOpe.Hide();
  }  
//   this.formati.Value('PDF|XLS|CSV');
  this.getTitlePortlet().AppendButton({
    id:"Importa",
    title:FormatMsg('Importa'),
    tooltip:FormatMsg('Importa i dati delle famiglie in WEBANTI'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe912"},
    action:'javascript:' + this.formid +'.Importa()'
  },2);    
}
function image_upload_Click(){
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function Aggiorna() {
  var idsid;
  this.listaFile.ListaFile.Refresh();
  if(Lower(Substr(this.nomefile.Value(),RAt('.',this.nomefile.Value())+1))!='zip'){
    if(Left(LRTrim(this.nomefile.Value()),8)!='ATPEC05.'){
      alert('Attenzione!!!\n Il file caricato non è una fotografia');
      this.btnElab.Hide();
    }
    idsid=Substr(this.nomefile.Value(),At('.',this.nomefile.Value())+1,At('.',this.nomefile.Value(),1));
    if(idsid!=this.IDSID.Value()){
      alert('Attenzione!!!\n Il file caricato non è di questo intermediario');
      this.btnElab.Hide();
    }
  }
  this.RTSaveFile.Link();
  this.RTAzzera.Link();
  this.pLog.Timer0_onTimer();
  this.pMsg.Timer0_onTimer();
  this.elaborazione.Reload();
  this.elaborazione.Reload();
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.btnElab.Disabled();
    this.btnFoto.Disabled();
    this.btnReport.Disabled();
    this.pMsg.Timer0.Start();
    this.pLog.Timer0.Start();
    this.listaFile.Timer0.Start();
    this.RTElabora.Link();
  }
}
function RTElabora_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pLog.Timer0_onTimer();
  this.listaFile.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0.Stop();
  this.listaFile.Timer0.Stop();
  this.btnElab.Enabled();
  this.btnFoto.Enabled();
  this.btnReport.Enabled();
  
  alert("Elaborazione Terminata con successo!");
}
function RTSaveFile_Result(result){
  if(result=='OK') {
    this.listaFile.ListaFile.Refresh();
  } else {
    alert(result);
  }
}
function btnReport_Click(){
  this.pMsg.Timer0.Start();
  this.pLog.Timer0.Start();
  this.listaFile.Timer0.Start();
  this.RTReport.Link();
}
// function btnExcel_Click(){
//   this.pMsg.Timer0.Start();
//   this.pLog.Timer0.Start();
//   this.listaFile.Timer0.Start();  
//   this.RTExcel.Link()
// }
function RTReport_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pLog.Timer0_onTimer();
  this.listaFile.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0.Stop();
  this.nomerep.Value(result);
  this.RTStampa.Link();
}
function btnFoto_Click(){
  this.RTStampaFoto.Link();
}
function Importa() {
  if (confirm("Confermi l'import della fotografia?")) {
    this.pMsg.Timer0.Start();
    this.pLog.Timer0.Start();
    this.RTImport.Link();
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
.pg_fam_esiti_foto_container {
  height:100%;
  overflow:auto;
}
.pg_fam_esiti_foto_title_container {
  margin: auto;
}
.pg_fam_esiti_foto_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1024px;
  min-width:800px;
  height:100%;
  background-color:#FFFFFF;
}
.pg_fam_esiti_foto_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_fam_esiti_foto_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:8px;
  left:1.0666667%;
  right:642px;
  right:85.6%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_fam_esiti_foto_portlet > .label1_ctrl {
  height:auto;
  min-height:20px;
}
.pg_fam_esiti_foto_portlet > .label1_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_fam_esiti_foto_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:108px;
  left:14.4%;
  right:323px;
  right:43.066666%;
  width:auto;
  height:20px;
}
.pg_fam_esiti_foto_portlet > .nomefile_ctrl {
}
.pg_fam_esiti_foto_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_fam_esiti_foto_portlet > .image_upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:428px;
  left:57.066666%;
  right:302px;
  right:40.266666%;
  width:auto;
  height:20px;
}
.pg_fam_esiti_foto_portlet > .image_upload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_fam_esiti_foto_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:665px;
  left:88.666664%;
  right:55px;
  right:7.3333335%;
  width:auto;
  height:30px;
}
.pg_fam_esiti_foto_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_fam_esiti_foto_portlet > .cAzzera_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:10px;
  left:450px;
  left:60.0%;
  right:87px;
  right:11.6%;
  width:auto;
  height:20px;
}
.pg_fam_esiti_foto_portlet > .btnFoto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:699px;
  left:93.2%;
  right:21px;
  right:2.8%;
  width:auto;
  height:30px;
}
.pg_fam_esiti_foto_portlet > .btnFoto_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#0C1DF3;
}
.pg_fam_esiti_foto_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:25px;
  left:3.3333333%;
  right:581px;
  right:77.46667%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_fam_esiti_foto_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:20px;
}
.pg_fam_esiti_foto_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_fam_esiti_foto_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:34px;
  left:173px;
  left:23.066668%;
  right:477px;
  right:63.6%;
  width:auto;
  height:20px;
}
.pg_fam_esiti_foto_portlet > .DaDatOpe_ctrl {
}
.pg_fam_esiti_foto_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_fam_esiti_foto_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:54px;
  left:25px;
  left:3.3333333%;
  right:581px;
  right:77.46667%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_fam_esiti_foto_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:20px;
}
.pg_fam_esiti_foto_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_fam_esiti_foto_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:54px;
  left:173px;
  left:23.066668%;
  right:477px;
  right:63.6%;
  width:auto;
  height:20px;
}
.pg_fam_esiti_foto_portlet > .ADatOpe_ctrl {
}
.pg_fam_esiti_foto_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_fam_esiti_foto_portlet > .flgwrt_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:44px;
  left:279px;
  left:37.2%;
  right:311px;
  right:41.466667%;
  width:auto;
  height:22px;
}
.pg_fam_esiti_foto_portlet > .btnReport_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:450px;
  left:60.0%;
  right:270px;
  right:36.0%;
  width:auto;
  height:30px;
}
.pg_fam_esiti_foto_portlet > .btnReport_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_fam_esiti_foto_portlet > .listaFile_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:113px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_fam_esiti_foto_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:263px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:42px;
}
.pg_fam_esiti_foto_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:305px;
  left:0px;
  left:0.0%;
  right:0px;
  width:auto;
  height:auto;
  min-height:89px;
}
.pg_fam_esiti_foto_portlet > .elaborazione_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:394px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:18px;
  width:auto;
}
.pg_fam_esiti_foto_portlet > .chknoe_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:85px;
  left:282px;
  left:37.6%;
  right:57px;
  right:7.6%;
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
 String def="[{\"h\":\"590\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"750\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"764\",\"y\":\"-73\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"764\",\"y\":\"-50\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"-25\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"183\",\"x\":\"764\",\"y\":\"16\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"764\",\"y\":\"38\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"100\",\"x\":\"8\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"319\",\"x\":\"108\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image_upload\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"428\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"665\",\"y\":\"4\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Azzera tabella di destinazione\",\"layout_steps_values\":{},\"name\":\"cAzzera\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"213\",\"x\":\"450\",\"y\":\"10\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnFoto\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"699\",\"y\":\"4\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"144\",\"x\":\"25\",\"y\":\"34\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"173\",\"y\":\"34\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"144\",\"x\":\"25\",\"y\":\"54\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"173\",\"y\":\"54\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"flgwrt\",\"page\":\"1\",\"textlist\":\"Scrittura Errori Memoria,Scrittura Errori Archivio\",\"type\":\"Combobox\",\"w\":\"160\",\"x\":\"279\",\"y\":\"44\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnReport\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"450\",\"y\":\"43\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"listaFile\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"750\",\"x\":\"0\",\"y\":\"113\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"42\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"750\",\"x\":\"0\",\"y\":\"263\",\"zindex\":\"3\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"89\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"750\",\"x\":\"0\",\"y\":\"305\",\"zindex\":\"3\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"178\",\"layout_steps_values\":{},\"name\":\"elaborazione\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"750\",\"x\":\"0\",\"y\":\"394\",\"zindex\":\"11\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"764\",\"y\":\"75\"},{\"h\":\"20\",\"name\":\"dirdest\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"764\",\"y\":\"97\"},{\"h\":\"20\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"118\"},{\"h\":\"20\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"883\",\"y\":\"75\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"883\",\"y\":\"118\"},{\"h\":\"20\",\"name\":\"RTElabora\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"173\"},{\"h\":\"20\",\"name\":\"nomerep\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"764\",\"y\":\"208\"},{\"h\":\"20\",\"name\":\"RTReport\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"230\"},{\"h\":\"20\",\"name\":\"RTExcel\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"261\"},{\"h\":\"20\",\"name\":\"RTStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"283\"},{\"h\":\"20\",\"name\":\"formati\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"111\",\"x\":\"764\",\"y\":\"311\"},{\"h\":\"20\",\"name\":\"RTStampaFoto\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"764\",\"y\":\"333\"},{\"h\":\"20\",\"name\":\"RTImport\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"111\",\"x\":\"763\",\"y\":\"357\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Non controllare operazioni\\u002frapporti non presenti\",\"layout_steps_values\":{},\"name\":\"chknoe\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"411\",\"x\":\"282\",\"y\":\"85\",\"zindex\":\"15\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_fam_esiti_foto","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_fam_esiti_foto_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_fam_esiti_foto','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gDescAzi=sp.getGlobal("gDescAzi","");
String gFlgIPMT=sp.getGlobal("gFlgIPMT","");
String IDSID= "";
String label1= "NomeFile:";
String nomefile= "";
if(request.getAttribute("pg_fam_esiti_foto_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String cAzzera="N";
String lblDaOpe= "Da Data Operazione:";
java.sql.Date DaDatOpe= JSPLib.NullDate();
String lblAOpe= "A Data Operazione:";
java.sql.Date ADatOpe= JSPLib.NullDate();
String flgwrt="D";
String dir= "";
String dirdest= "";
String nomerep= "";
String formati= "";
String chknoe="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_fam_esiti_foto_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_fam_esiti_foto_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_fam_esiti_foto_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_fam_esiti_foto','<%=idPortlet%>',false,'');
</script><%}}%>
<label id='<%=idPortlet%>_label1' for='<%=idPortlet%>_nomefile' formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<a id='<%=idPortlet%>_image_upload' class='image image_upload_ctrl'   target=''>&#xe9da;</a>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<div id='<%=idPortlet%>_cAzzera_div' style=''><input id='<%=idPortlet%>_cAzzera' name='cAzzera' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_cAzzera' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Azzera tabella di destinazione")%></label></div>
<a id='<%=idPortlet%>_btnFoto' class='image btnFoto_ctrl'   target=''>&#xeb05;</a>
<label id='<%=idPortlet%>_lblDaOpe' for='<%=idPortlet%>_DaDatOpe' formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
<label id='<%=idPortlet%>_lblAOpe' for='<%=idPortlet%>_ADatOpe' formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<select id='<%=idPortlet%>_flgwrt' name='flgwrt' class='combobox' title=<%=JSPLib.ToHTMLValue("Modalità Scrittura Errori" )%> style=''></select>
<a id='<%=idPortlet%>_btnReport' class='image btnReport_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_listaFile'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/list_imprich_portlet.jsp?ForcedPortletUID="+idPortlet+"_1esm17j",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_elaborazione_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_chknoe_div' style=''><input id='<%=idPortlet%>_chknoe' name='chknoe' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chknoe' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Non controllare operazioni/rapporti non presenti")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_fam_esiti_foto');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Importa",true)+","+JSPLib.ToJSValue(sp.translate("Importa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Importa i dati delle famiglie in WEBANTI",true)+","+JSPLib.ToJSValue(sp.translate("Importa i dati delle famiglie in WEBANTI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_fam_esiti_foto',["750"],["590"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"750","h":"590","title":"","layer":"false","npage":"1"}]);
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.gFlgIPMT=new ZtVWeb._VC(this,'gFlgIPMT',null,'character','<%=JSPLib.ToJSValue(gFlgIPMT,false,true)%>',false,false);
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function autoexec","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":111,"x":764,"y":-25});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.RTAzzera.Link();
this.SQLDataobj_armt_intermbo=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("BO:armt_intermbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"server-client","cmd":"BO:armt_intermbo","cmdHash":"<%=JSPLib.cmdHash("BO:armt_intermbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_armt_intermbo","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_armt_intermbo","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":183,"x":764,"y":16});
this.IDSID=new ZtVWeb._VC(this,'IDSID',null,'character','<%=JSPLib.ToJSValue(IDSID,false,true)%>',false,false);
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"nomefile","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":100,"x":8,"y":10,"zindex":"1"});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":319,"x":108,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.image_upload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image_upload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_upload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image_upload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":428,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Elabora i file selezionati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":665,"y":4,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.cAzzera=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_cAzzera","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Azzera tabella di destinazione","layer":false,"layout_steps_values":{},"name":"cAzzera","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":213,"x":450,"y":10,"zindex":"14"});
this.cAzzera.Value('<%=cAzzera%>');
this.btnFoto=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image btnFoto_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnFoto","edit_undercond":"","field":"","font_color":"#0C1DF3","font_color_hover":"#0C1DF3","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampe Fotografia Anagrafe Rapporti",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnFoto","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":699,"y":4,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"DaDatOpe","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":144,"x":25,"y":34,"zindex":"1"});
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaDatOpe%>","w":100,"x":173,"y":34,"zerofilling":false,"zindex":"2","zoom":""});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"ADatOpe","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":144,"x":25,"y":54,"zindex":"1"});
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=ADatOpe%>","w":100,"x":173,"y":54,"zerofilling":false,"zindex":"2","zoom":""});
this.flgwrt=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_flgwrt","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"Modalità Scrittura Errori","hide":"false","hide_undercond":"","init":"","init_par":"<%=flgwrt%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"flgwrt","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Scrittura Errori Memoria,Scrittura Errori Archivio","type":"Combobox","typevar":"character","valuelist":"M,D","visible":true,"w":160,"x":279,"y":44,"zindex":"13"});
this.btnReport=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image btnReport_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnReport","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampe risultato controllo",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnReport","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":450,"y":43,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
if(this.listaFile=ZtVWeb.getPortletInc('<%=idPortlet%>_listaFile')){
this.listaFile.setContainer(this,'listaFile')
this.listaFile_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_listaFile","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"listaFile","page":1,"portlet_id":"<%=idPortlet%>_1esm17j","spuid":"","type":"Portlet","w":750,"x":0,"y":113,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_listaFile').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":42,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":750,"x":0,"y":263,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right","ctrlid":"<%=idPortlet%>_pLog","h":89,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":750,"x":0,"y":305,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.elaborazione=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_elaborazione","default_portlet":"","h":178,"hide":"false","layer":false,"layout_steps_values":{},"name":"elaborazione","name_iframe":"elaborazione","page":1,"spuid":"","type":"Iframe","w":750,"x":0,"y":394,"zindex":"11"});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.dirdest=new ZtVWeb._VC(this,'dirdest',null,'character','<%=JSPLib.ToJSValue(dirdest,false,true)%>',false,false);
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":111,"x":764,"y":118});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":883,"y":75});
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=dirdest,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":111,"x":883,"y":118});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.RTElabora=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_fammigra",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElabora","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElabora","offline":false,"page":1,"parms":"pAzzera=cAzzera","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fammigra","target":"","type":"SPLinker","w":111,"x":764,"y":173});
this.RTElabora.m_cID='<%=JSPLib.cmdHash("routine,arrt_fammigra",request.getSession())%>';
this.nomerep=new ZtVWeb._VC(this,'nomerep',null,'character','<%=JSPLib.ToJSValue(nomerep,false,true)%>',false,false);
this.RTReport=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_fammigra_stp",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTReport","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTReport","offline":false,"page":1,"parms":"w_dadata=DaDatOpe,w_a_data=ADatOpe,w_flgwrt=flgwrt,w_flgnoe=chknoe","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fammigra_stp","target":"","type":"SPLinker","w":111,"x":764,"y":230});
this.RTReport.m_cID='<%=JSPLib.cmdHash("routine,arrt_fammigra_stp",request.getSession())%>';
this.RTExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"routine caller","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExcel","offline":false,"page":1,"parms":"ReportName=arrp_stp_errimp.vrp,outputFormat=PDF","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fam_xls_esiti_sid","target":"","type":"SPLinker","w":111,"x":764,"y":261});
this.RTExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_fam_xls_esiti_sid",request.getSession())%>';
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"ReportName=nomerep,w_DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,formatTypes=formati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"elaborazione","type":"SPLinker","w":111,"x":764,"y":283});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.formati=new ZtVWeb._VC(this,'formati',null,'character','<%=JSPLib.ToJSValue(formati,false,true)%>',false,false);
this.RTStampaFoto=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampaFoto","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampaFoto","offline":false,"page":1,"parms":"ReportName=arrp_famesiti_stp,DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,formatTypes=formati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"elaborazione","type":"SPLinker","w":111,"x":764,"y":333});
this.RTStampaFoto.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTImport=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_fammigra_imp",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTImport","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTImport","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fammigra_imp","target":"","type":"SPLinker","w":111,"x":763,"y":357});
this.RTImport.m_cID='<%=JSPLib.cmdHash("routine,arrt_fammigra_imp",request.getSession())%>';
this.chknoe=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chknoe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Non controllare operazioni\u002frapporti non presenti","layer":false,"layout_steps_values":{},"name":"chknoe","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":411,"x":282,"y":85,"zindex":"15"});
this.chknoe.Value('<%=chknoe%>');
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
<%if(request.getAttribute("pg_fam_esiti_foto_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_fam_esiti_foto_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_fam_esiti_foto_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.image_upload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnFoto.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnReport.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLDataobj_armt_intermbo.firstQuery('true','',<%SQLExecute.JSONquery(sp,"BO:armt_intermbo",1,out,false, sp.getParameter((!JSPLib.Empty(sp.getParameter("dataprovider_namespace","")) ? sp.getParameter("dataprovider_namespace","") + "_" : "" )+"page_SQLDataobj_armt_intermbo" ,"1"));%>);
window.<%=idPortlet%>.flgwrt.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_fam_esiti_foto',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_fam_esiti_foto');
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
sp.endPage("pg_fam_esiti_foto");
}%>
<%! public String getJSPUID() { return "2429672283"; } %>