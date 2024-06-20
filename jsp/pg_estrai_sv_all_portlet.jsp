<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  if(this.sv_type.Value()==\"MT\"){\n    this.tipo_B3.Value(\"B3MT\");\n    this.tipo_B3.Disabled();\n  }\n  else if(this.sv_type.Value()==\"IP\"){\n    this.tipo_B3.Value(\"B3IP\");\n    this.tipo_B3.Disabled();\n    this.btnCrea.Hide();\n  }\n  this.anno.Value(this.RTInit.Link());  \n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE DATI PER SV\",true);\n  this.btnDownload.Hide();\n  this.btnUpdate.Hide(); \n  this.chkSegnala.Hide()\n  this.anno_onChange();\n  this.trimestre_onChange();\n  if(this.gIntemediario.Value()!='07076140966'){\n    this.chkLCC.Hide();\n    this.chkLCC.Value(\"X\");\n  }  \n}\n\nfunction btnElab_Click(){  \n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.PortletLogs.Start();     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop();     \n  if(result=='KO') {\n    alert(\"Elaborazione Abortita. Contattare l'assistenza\");\n  } else {\n    alert(\"Elaborazione Completata. Prelevare il file con il bottone\");\n    this.ftypes.Value('ZIP');\n    this.filename.Value(result);\n    this.btnDownload.Show()\n  }  \n}\n\nfunction RTTable_Result(result){\n  this.PortletLogs.Stop();     \n  if(result=='KO') {\n    alert(\"Elaborazione Abortita. Contattare l'assistenza\");\n  } else {\n    alert(\"Elaborazione Completata. Creato il tabellone per l'analisi trimestrale\");\n  }      \n}\n\nfunction btnCrea_Click(){\n  if (confirm(\"Confermi la creazione del tabellone trimestrale?\")) {    \n    this.PortletLogs.Start();  \n    this.RTTable.Link();  \n  }    \n}\n\n\nfunction btnDownload_Click(){\n  if (confirm(\"Confermi il prelievo del file?\")) {    \n    this.cartella.Value(\"export\");\n    this.RTDownload.Link();    \n  }  \n}\n\nfunction btnCheck_Click(){\n  if(this.tipo_B3.Value()==\"B3MT\"){\n    if (confirm(\"Confermi l'estrazione delle operazioni errate?\")) {\n      this.PortletLogs.Start();       \n      this.iPrint.Reload()    \n      this.RTCheck.Link()\n    }\n  }\n  else if(this.tipo_B3.Value()==\"B3IP\"){\n  \tif (confirm(\"Confermi la verifica sui dati?\")) {\n      this.PortletLogs.Start();      \n      this.iPrint.Reload()    \n      this.RTCheck.Link()\n    }\n  }\n}\n\nfunction RTCheck_Result(result){\n  this.PortletLogs.Stop();    \n  if (Empty(result)) {\n    alert('Non è stato creato nessun file di errori!')\n      this.btnElab.Show() \n  } else {\n    this.filename.Value(result+\".xlsx\")\n    this.cartella.Value(\"appo\")\n    this.ftypes.Value('XLSX');  \n    this.RTDownloadXLSX.Link();\n    alert('Creazione file errori terminata!')\n  }  \n}\n\nfunction btnUpload_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction btnUpdate_Click(){\n  if (confirm(\"Confermi l'import del file delle correzioni?\")) {\n    this.PortletLogs.Start();        \n    this.iPrint.Reload()    \n    this.RTUpdate.Link()\n  }   \n}\n\nfunction RTUpdate_Result(result){\n  this.PortletLogs.Stop();       \n  if (result=='OK') {\n    alert('Elaborazione file correzioni eseguito correttamente!')\n  } else {\n    alert('Elaborazione file correzioni bloccato per presenza di errori')      \n  }  \n  this.btnCrea.Show()\n  this.btnCheck.Show()  \n  this.btnUpdate.Hide()\n  this.nomefile.Value(\"\")\n  this.iPrint.Reload()\n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n  this.btnUpdate.Show()\n  this.btnCrea.Hide()\n  this.btnCheck.Hide()\n  this.btnElab.Hide()  \n}\n\nfunction anno_onChange(){\n  let str = this.anno.Value();\n  if(str.match(\u002f^(19|20)\\d{2}$\u002f)){ \t\u002f\u002f è un anno compreso tra 1900 e 2099 (dovrebbe bastare)\n  \tif(parseInt(str)\u003e2020){\t\t\t\t\t\u002f\u002f disabilito la scelta del segno e setto staticamente DARE = Send\n    \tthis.flgsegno.Value('2');\n      this.flgsegno.Disabled();\n    }else{\n      this.flgsegno.Enabled();}\n  }else{\n  \tAlert(\"Inserire un Anno di Rifermiento valido!\");\n    this.anno.Value(this.RTInit.Link()); \n  }\n  this.SQLDataobj_qbe_ope_fraudolente.Query();\n}\n\nfunction trimestre_onChange(){\n  if (this.trimestre.Value()==2 || this.trimestre.Value()==4) {\n    this.btnFraud.Show()\n    this.chkSegnala.Show()\n  } else {\n    this.btnFraud.Hide()\n    this.chkSegnala.Hide()\n  }\n  this.SQLDataobj_qbe_ope_fraudolente.Query();\n}\n\nfunction btnFraud_Click(){\n  if(confirm(\"Confermi l'aggiornamento delle operazioni fraudolente?\")) {\n    this.PortletLogs.Start();   \n    this.RTFraud.Link()\n  }  \n}\n\nfunction RTFraud_Executed(result,cError){\n  this.PortletLogs.Stop();      \n  alert('Aggiornamento operazioni fraudolente completato!')  \n}\n\nfunction SQLDataobj_qbe_ope_fraudolente_BeforeQuery(){\n  this.pDatIni.Value(this.anno.Value()+(this.trimestre.Value()==1||this.trimestre.Value()==2?'0101':'0701'));\n  this.pDatFin.Value(this.anno.Value()+(this.trimestre.Value()==1||this.trimestre.Value()==2?'0630':'1231'));\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"ESTRAZIONE DATI PER SV (WU)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @btnDownload }}{{ @label3_segno }}{{ @label1 }}{{ @btnElab }}{{ @btnUpload }}{{ @btnUpdate }}{{ @pLog }}{{ @pMsg }}{{ @anno }}{{ @lblAnno }}{{ @trimestre }}{{ @lblTri }}{{ @filename }}{{ @btnCheck }}{{ @btnCrea }}{{ @iPrint }}{{ @nomefile }}{{ @flgsegno }}{{ @chkLCC }}{{ @tipo_B3 }}{{ @label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy }}{{ @btnFraud }}{{ @chkSegnala }}{{ @Textbox_conteggio_fraudolente_tab }}{{ @Textbox_conteggio_fraudolente_orig }}{{ @btnDownload }}{{ @label3_segno }}{{ @label1 }}{{ @btnElab }}{{ @btnUpload }}{{ @btnUpdate }}{{ @anno }}{{ @lblAnno }}{{ @trimestre }}{{ @lblTri }}{{ @filename }}{{ @btnCheck }}{{ @btnCrea }}{{ @iPrint }}{{ @nomefile }}{{ @flgsegno }}{{ @chkLCC }}{{ @tipo_B3 }}{{ @label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy }}{{ @btnFraud }}{{ @chkSegnala }}{{ @Textbox_conteggio_fraudolente_tab }}{{ @Textbox_conteggio_fraudolente_orig }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"370","hsl":"false","htmlcode":"{{ @PortletLogs }} \n{{ @Textbox_conteggio_fraudolente_tab }} \n{{ @Textbox_conteggio_fraudolente{{ @Textbox_conteggio_fraudolente_orig }} \n }} \n{{ @chkSegnala }} \n{{ @btnFraud }} \n{{ @label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy }}\n{{ @tipo_B3 }}\n{{ @chkLCC }}\n{{ @flgsegno }}\n{{ @nomefile }}\n{{ @iPrint }}\n{{ @btnCrea }}\n{{ @btnCheck }}\n{{ @filename }}\n{{ @lblTri }}\n{{ @trimestre }}\n{{ @lblAnno }}\n{{ @anno }}\n\n\n{{ @btnUpdate }}\n\n{{ @btnUpload }}\n{{ @btnElab }}\n{{ @label1 }}\n{{ @label3_segno }}\n{{ @btnDownload }}\n{{ label39 }}\n{{ tipo_periodo }}\n{{ btnDownload }}\n{{ label3_segno }}\n{{ label1 }}\n{{ Event_filename }}\n{{ btnElab }}\n{{ btnUpload }}\n{{ dir }}{{ Image47 }}{{ Checkbox_trimestr }}\n{{ btnExit }}\n{{ RTEsci }}\n{{ RTUpload }}\n{{ RTSaveFile }}\n{{ RTExec }}\n{{ RTDownload }}\n{{ btnUpdate }}{{ Note46 }}\n{{ cartella }}\n{{ pLog }}\n{{ pMsg }}\n{{ anno }}\n{{ lblAnno }}\n{{ trimestre }}\n{{ lblTri }}\n{{ filename }}\n{{ RTClean }}\n{{ RTInit }}\n{{ btnCheck }}\n{{ RTCheck }}\n{{ btnCrea }}\n{{ RTTable }}{{ Timer45 }}\n{{ ftypes }}\n{{ outFile }}\n{{ _datini }}\n{{ _datfin }}{{ Image_ld }}\n{{ Image_dl }}{{ iPrint }}\n{{ nomefile }}\n{{ RTStampa }}\n{{ RTUpdate }}\n{{ RTDownloadXLSX }}\n{{ flgsegno }}\n{{ chkLCC }}\n{{ gIntemediario }}\n{{ tipo_B3 }}\n{{ label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy }}\n{{ Note42 }}\n{{ sv_type }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"370\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva il file generato","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDownload","page":"1","path_type":"","rapp":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"724","y":"46","zindex":"1","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"290","zindex":"3","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label3_segno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Segno:","w":"111","wireframe_props":"align,value,n_col","x":"192","y":"39","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"51","wireframe_props":"align,value,n_col","x":"84","y":"111","zindex":"1","zone":""},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"5","type":"EventReceiver","w":"111","x":"858","y":"105"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","rapp":"","sequence":"6","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"683","y":"46","zindex":"1","zone":""},{"alt":"","anchor":"top-left","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnUpload","page":"1","path_type":"","rapp":"","sequence":"7","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"573","y":"108","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"42","x":"858","y":"151"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"9","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"86","x":"858","y":"72"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"120","x":"858","y":"184"},{"allowedentities":"arfn_estrai_sv_all","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pSegno=flgsegno,pLCC=chkLCC,pTipoBase3=tipo_B3,pFraudo=chkSegnala","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"arfn_estrai_sv_all","target":"","type":"SPLinker","w":"120","x":"1014","y":"182"},{"allowedentities":"DownloadFileServlet","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":"120","x":"1014","y":"145"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Corregge Tabellone Trimestrale","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnUpdate","page":"1","path_type":"","rapp":"","sequence":"13","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"9","zindex":"0","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"cartella","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"499","y":"-61"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"53","wireframe_props":"name","x":"141","y":"10","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"10","y":"15","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"trimestre","page":"1","picture":"","rapp":"","sequence":"17","spuid":"","tabindex":"","textlist":"I Trimestre,II Trimestre,III Trimestre,IV Trimestre","type":"Combobox","typevar":"character","valuelist":"1,2,3,4","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"10","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTri","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Periodo:","w":"69","wireframe_props":"align,value,n_col","x":"234","y":"15","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"filename","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"149","wireframe_props":"name","x":"5","y":"35","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTInit","offline":"false","page":"1","parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"21","servlet":"arfn_initdate","target":"","type":"SPLinker","w":"120","x":"1014","y":"73"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Effettua il controllo dei dati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnCheck","page":"1","path_type":"","rapp":"","sequence":"22","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"724","y":"9","zindex":"0","zone":""},{"allowedentities":"arrt_estrai_sv_check_all","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCheck","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pTipo=C,pFile=nomefile,pTipoBase3=tipo_B3,pFraudo=chkSegnala","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"23","servlet":"arrt_estrai_sv_check_all","target":"","type":"SPLinker","w":"120","x":"1014","y":"20"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe90c;","font_image_hover":"&#xe90d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Crea Tabellone Trimestrale","hide":"false","hide_undercond":"this.tipo_B3.Value()==\"B3IP\"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnCrea","page":"1","path_type":"","rapp":"","sequence":"24","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"683","y":"9","zindex":"0","zone":""},{"allowedentities":"arrt_estrai_sv_check_all","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"27","m_cAction":"function","name":"RTTable","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pTipo=T,pFile=nomefile,pTipoBase3=tipo_B3,pFraudo=chkSegnala","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"25","servlet":"arrt_estrai_sv_check_all","target":"","type":"SPLinker","w":"120","x":"1014","y":"-18"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"ftypes","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"858","y":"15"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"outFile","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"858","y":"-52"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pDatIni","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"858","y":"-91"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pDatFin","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1014","y":"-92"},{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"30","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"138","zindex":"9","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"31","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"431","wireframe_props":"name","x":"140","y":"108","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa","offline":"false","page":"1","parms":"ReportName=arrp_estrai_sv_chk.vrp,FileName=outFile,pDADATA=c_dadate,pA_DATA=c_adate,formatTypes=ftypes,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,SubstituteQuery=qbe_estrai_sv_ope_chk_wu,hidePreview=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"32","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"1014","y":"-45"},{"allowedentities":"arfn_import_correzioni_sv_all","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTUpdate","offline":"false","page":"1","parms":"nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"33","servlet":"arfn_import_correzioni_sv_all","target":"","type":"SPLinker","w":"120","x":"1014","y":"240"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownloadXLSX","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"34","servlet":"arrt_downloadxlsx","target":"iPrint","type":"SPLinker","w":"130","x":"1014","y":"268"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","init":"","init_par":"2","layer":"false","layout_steps_values":"{}","name":"flgsegno","page":"1","picture":"","rapp":"","sequence":"35","spuid":"","tabindex":"","textlist":"Segno Avere = SEND,Segno Dare = SEND","type":"Combobox","typevar":"character","valuelist":"1,2","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"35","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Genera per LCC","layer":"false","layout_steps_values":"{}","name":"chkLCC","page":"1","rapp":"","sequence":"36","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"129","wireframe_props":"label_text","x":"539","y":"13","zindex":"10","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gIntemediario","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1014","y":"307"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipo_B3","page":"1","picture":"","rapp":"","sequence":"38","spuid":"","tabindex":"","textlist":" Base 3 Moneytransfer,Base 3 Istituti di Pagamento","type":"Combobox","typevar":"character","valuelist":"B3MT,B3IP","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"61","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Segnalazione:","w":"111","wireframe_props":"align,value,n_col","x":"192","y":"65","zindex":"1","zone":""},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"100","hide":"","layer":"","layout_steps_values":"{}","name":"Note42","page":"1","rapp":"","sequence":"40","spuid":"","type":"Note","value":"portlet che viene chiamato con parametro da voce di menu:\nnessun parametro = portlet con entrambe le SV \nMT = SV per moneytransfer\nIP = SV per istituti di pagamento","w":"368","wireframe_props":"","x":"1231","y":"-92","zindex":"11","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"sv_type","page":"1","reactive":"","sequence":"41","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1232","y":"14"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"127","hide":"","layer":"","layout_steps_values":"{}","name":"Note46","page":"1","rapp":"","sequence":"42","spuid":"","type":"Note","value":"SV per IP: in accordo con Fabio l'estrazione della voce semestrale avviene in concomitanza con l'estrazione delle voci di semestri 2 e 4. Il file contenente le operazioni generato così contiene tutte le operazioni necessarie per generare le voci trimestrali (trimestre 2 e 4) e la voce semestrale (semestre 1 nel caso del trimestre 2 e semestre 2 nel caso della voce trimestre 4).","w":"486","wireframe_props":"","x":"1188","y":"410","zindex":"12","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9a9;","font_image_hover":"&#xe9aa;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Aggiorna operazioni fraudolente","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnFraud","page":"1","path_type":"","rapp":"","sequence":"43","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"46","zindex":"1","zone":""},{"allowedentities":"arfn_agg_fraudolente","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTFraud","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"44","servlet":"arfn_agg_fraudolente","target":"","type":"SPLinker","w":"120","x":"1014","y":"211"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Estrai Solo Fraudolente","layer":"false","layout_steps_values":"{}","name":"chkSegnala","page":"1","rapp":"","sequence":"45","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"173","wireframe_props":"label_text","x":"539","y":"48","zindex":"10","zone":""},{"allowedqueries":"qbe_count_fraud","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1","name":"SQLDataobj_qbe_count_fraud","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_count_fraud","query_async":"true","return_fields_type":"true","sequence":"46","type":"SQLDataobj","w":"194","waiting_mgs":"","x":"841","y":"361"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLDataobj_qbe_count_fraud","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"conteggio","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_conteggio_fraudolente_tab","page":"1","password":"","picker":"","picture":"","placeholder":"Conteggio Fraudolente tabellone","rapp":"","readonly":"false","scroll":"false","sequence":"47","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"90","wireframe_props":"name","x":"703","y":"108","zerofilling":"false","zindex":"14","zone":"","zoom":""},{"allowedqueries":"qbe_ope_fraudolente","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"SQLDataobj_qbe_ope_fraudolente","offline":"false","page":"1","parms":"pDatIni,pDatFin","parms_source":"","query":"qbe_ope_fraudolente","query_async":"true","return_fields_type":"true","sequence":"48","type":"SQLDataobj","w":"218","waiting_mgs":"","x":"841","y":"385"},{"alias":"conteggio","ctrlOfVariant":"","dataobj":"SQLDataobj_qbe_ope_fraudolente","descr":"Conteggio Fraud","fields":"COUNT(NUMPROG)","groupby_fields":"","h":"20","name":"SQLTotalizer_qbe_ope_fraudolente","orderby_fields":"","page":"1","picture":"999$|$999$|$999","sequence":"49","type":"SQLTotalizer","w":"226","x":"841","y":"409"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLTotalizer_qbe_ope_fraudolente","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"conteggio","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_conteggio_fraudolente_orig","page":"1","password":"","picker":"","picture":"","placeholder":"Conteggio Fraudolente origine","rapp":"","readonly":"false","scroll":"false","sequence":"50","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"93","wireframe_props":"name","x":"600","y":"108","zerofilling":"false","zindex":"17","zone":"","zoom":""}]%>
<%/*Description:ESTRAZIONE DATI PER SV (WU)*/%>
<%/*ParamsRequest:sv_type*/%>
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
window.pg_estrai_sv_all_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof RTTable_Result !='undefined')this.RTTable_Result=RTTable_Result;
if(typeof btnCrea_Click !='undefined')this.btnCrea_Click=btnCrea_Click;
if(typeof btnDownload_Click !='undefined')this.btnDownload_Click=btnDownload_Click;
if(typeof btnCheck_Click !='undefined')this.btnCheck_Click=btnCheck_Click;
if(typeof RTCheck_Result !='undefined')this.RTCheck_Result=RTCheck_Result;
if(typeof btnUpload_Click !='undefined')this.btnUpload_Click=btnUpload_Click;
if(typeof btnUpdate_Click !='undefined')this.btnUpdate_Click=btnUpdate_Click;
if(typeof RTUpdate_Result !='undefined')this.RTUpdate_Result=RTUpdate_Result;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof anno_onChange !='undefined')this.anno_onChange=anno_onChange;
if(typeof trimestre_onChange !='undefined')this.trimestre_onChange=trimestre_onChange;
if(typeof btnFraud_Click !='undefined')this.btnFraud_Click=btnFraud_Click;
if(typeof RTFraud_Executed !='undefined')this.RTFraud_Executed=RTFraud_Executed;
if(typeof SQLDataobj_qbe_ope_fraudolente_BeforeQuery !='undefined')this.SQLDataobj_qbe_ope_fraudolente_BeforeQuery=SQLDataobj_qbe_ope_fraudolente_BeforeQuery;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.sv_type.Value(),'IP'),this.label3_segno);
ZtVWeb.HideCtrl(Eq(this.sv_type.Value(),'IP'),this.label1);
ZtVWeb.HideCtrl(Eq(this.sv_type.Value(),'IP'),this.btnUpload);
ZtVWeb.HideCtrl(Eq(this.tipo_B3.Value(),"B3IP"),this.btnCrea);
ZtVWeb.HideCtrl(Eq(this.sv_type.Value(),'IP'),this.nomefile);
ZtVWeb.HideCtrl(Eq(this.sv_type.Value(),'IP'),this.flgsegno);
}
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
this.SQLDataobj_qbe_count_fraud.addDataConsumer(this.Textbox_conteggio_fraudolente_tab,<%=JSPLib.ToJSValue("conteggio",true)%>);
this.SQLDataobj_qbe_ope_fraudolente.addTotalizer({"alias":"conteggio","descr":"Conteggio Fraud","exp":"COUNT(NUMPROG)","grp":"","orderby":"","picture":"999|999|999","provider":"SQLTotalizer_qbe_ope_fraudolente"});
this.SQLTotalizer_qbe_ope_fraudolente.addDataConsumer(this.Textbox_conteggio_fraudolente_orig,<%=JSPLib.ToJSValue("conteggio",true)%>);
function this_Loaded(){
  if(this.sv_type.Value()=="MT"){
    this.tipo_B3.Value("B3MT");
    this.tipo_B3.Disabled();
  }
  else if(this.sv_type.Value()=="IP"){
    this.tipo_B3.Value("B3IP");
    this.tipo_B3.Disabled();
    this.btnCrea.Hide();
  }
  this.anno.Value(this.RTInit.Link());  
  this.getTitlePortlet().SetTitle("ESTRAZIONE DATI PER SV",true);
  this.btnDownload.Hide();
  this.btnUpdate.Hide(); 
  this.chkSegnala.Hide()
  this.anno_onChange();
  this.trimestre_onChange();
  if(this.gIntemediario.Value()!='07076140966'){
    this.chkLCC.Hide();
    this.chkLCC.Value("X");
  }  
}
function btnElab_Click(){  
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.PortletLogs.Start();     
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.PortletLogs.Stop();     
  if(result=='KO') {
    alert("Elaborazione Abortita. Contattare l'assistenza");
  } else {
    alert("Elaborazione Completata. Prelevare il file con il bottone");
    this.ftypes.Value('ZIP');
    this.filename.Value(result);
    this.btnDownload.Show()
  }  
}
function RTTable_Result(result){
  this.PortletLogs.Stop();     
  if(result=='KO') {
    alert("Elaborazione Abortita. Contattare l'assistenza");
  } else {
    alert("Elaborazione Completata. Creato il tabellone per l'analisi trimestrale");
  }      
}
function btnCrea_Click(){
  if (confirm("Confermi la creazione del tabellone trimestrale?")) {    
    this.PortletLogs.Start();  
    this.RTTable.Link();  
  }    
}
function btnDownload_Click(){
  if (confirm("Confermi il prelievo del file?")) {    
    this.cartella.Value("export");
    this.RTDownload.Link();    
  }  
}
function btnCheck_Click(){
  if(this.tipo_B3.Value()=="B3MT"){
    if (confirm("Confermi l'estrazione delle operazioni errate?")) {
      this.PortletLogs.Start();       
      this.iPrint.Reload()    
      this.RTCheck.Link()
    }
  }
  else if(this.tipo_B3.Value()=="B3IP"){
  	if (confirm("Confermi la verifica sui dati?")) {
      this.PortletLogs.Start();      
      this.iPrint.Reload()    
      this.RTCheck.Link()
    }
  }
}
function RTCheck_Result(result){
  this.PortletLogs.Stop();    
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
    this.PortletLogs.Start();        
    this.iPrint.Reload()    
    this.RTUpdate.Link()
  }   
}
function RTUpdate_Result(result){
  this.PortletLogs.Stop();       
  if (result=='OK') {
    alert('Elaborazione file correzioni eseguito correttamente!')
  } else {
    alert('Elaborazione file correzioni bloccato per presenza di errori')      
  }  
  this.btnCrea.Show()
  this.btnCheck.Show()  
  this.btnUpdate.Hide()
  this.nomefile.Value("")
  this.iPrint.Reload()
}
function Aggiorna() {
  this.RTSaveFile.Link();
  this.btnUpdate.Show()
  this.btnCrea.Hide()
  this.btnCheck.Hide()
  this.btnElab.Hide()  
}
function anno_onChange(){
  let str = this.anno.Value();
  if(str.match(/^(19|20)\d{2}$/)){ 	// è un anno compreso tra 1900 e 2099 (dovrebbe bastare)
  	if(parseInt(str)>2020){					// disabilito la scelta del segno e setto staticamente DARE = Send
    	this.flgsegno.Value('2');
      this.flgsegno.Disabled();
    }else{
      this.flgsegno.Enabled();}
  }else{
  	Alert("Inserire un Anno di Rifermiento valido!");
    this.anno.Value(this.RTInit.Link()); 
  }
  this.SQLDataobj_qbe_ope_fraudolente.Query();
}
function trimestre_onChange(){
  if (this.trimestre.Value()==2 || this.trimestre.Value()==4) {
    this.btnFraud.Show()
    this.chkSegnala.Show()
  } else {
    this.btnFraud.Hide()
    this.chkSegnala.Hide()
  }
  this.SQLDataobj_qbe_ope_fraudolente.Query();
}
function btnFraud_Click(){
  if(confirm("Confermi l'aggiornamento delle operazioni fraudolente?")) {
    this.PortletLogs.Start();   
    this.RTFraud.Link()
  }  
}
function RTFraud_Executed(result,cError){
  this.PortletLogs.Stop();      
  alert('Aggiornamento operazioni fraudolente completato!')  
}
function SQLDataobj_qbe_ope_fraudolente_BeforeQuery(){
  this.pDatIni.Value(this.anno.Value()+(this.trimestre.Value()==1||this.trimestre.Value()==2?'0101':'0701'));
  this.pDatFin.Value(this.anno.Value()+(this.trimestre.Value()==1||this.trimestre.Value()==2?'0630':'1231'));
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
.pg_estrai_sv_all_container {
  height:100%;
  overflow:auto;
}
.pg_estrai_sv_all_title_container {
  margin: auto;
}
.pg_estrai_sv_all_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_estrai_sv_all_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_estrai_sv_all_portlet > .btnDownload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  right:46px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_all_portlet > .btnDownload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_all_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:290px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_estrai_sv_all_portlet > .label3_segno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:39px;
  left:192px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .label3_segno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .label3_segno_ctrl {
  overflow:hidden;
  display:none;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_all_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:111px;
  left:84px;
  width:51px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .label1_ctrl {
  overflow:hidden;
  display:none;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_all_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  right:87px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_all_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_all_portlet > .btnUpload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  left:573px;
  width:20px;
  height:20px;
}
.pg_estrai_sv_all_portlet > .btnUpload_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_estrai_sv_all_portlet > .btnUpdate_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_all_portlet > .btnUpdate_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_all_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:141px;
  width:53px;
  height:20px;
}
.pg_estrai_sv_all_portlet > .anno_ctrl {
}
.pg_estrai_sv_all_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_all_portlet > .lblAnno_ctrl {
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
.pg_estrai_sv_all_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_all_portlet > .trimestre_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sv_all_portlet > .lblTri_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:234px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .lblTri_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .lblTri_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_all_portlet > .filename_ctrl {
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
.pg_estrai_sv_all_portlet > .filename_ctrl {
  display:none;
}
.pg_estrai_sv_all_portlet > .filename_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_all_portlet > .btnCheck_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:46px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_all_portlet > .btnCheck_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_all_portlet > .btnCrea_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:9px;
  right:87px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_all_portlet > .btnCrea_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_all_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:138px;
  left:0px;
  right:0px;
  width:auto;
  height:150px;
}
.pg_estrai_sv_all_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  left:140px;
  width:431px;
  height:20px;
}
.pg_estrai_sv_all_portlet > .nomefile_ctrl {
  display:none;
}
.pg_estrai_sv_all_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_all_portlet > .flgsegno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sv_all_portlet > .chkLCC_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:13px;
  left:539px;
  left:67.375%;
  right:132px;
  right:16.5%;
  width:auto;
  height:20px;
}
.pg_estrai_sv_all_portlet > .tipo_B3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sv_all_portlet > .label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:192px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_all_portlet > .label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_all_portlet > .btnFraud_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_all_portlet > .btnFraud_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_all_portlet > .chkSegnala_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:48px;
  left:539px;
  left:67.375%;
  right:88px;
  right:11.0%;
  width:auto;
  height:20px;
}
.pg_estrai_sv_all_portlet > .Textbox_conteggio_fraudolente_tab_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:108px;
  left:703px;
  left:87.875%;
  right:7px;
  right:0.875%;
  width:auto;
  height:20px;
}
.pg_estrai_sv_all_portlet > .Textbox_conteggio_fraudolente_tab_ctrl {
}
.pg_estrai_sv_all_portlet > .Textbox_conteggio_fraudolente_tab_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_estrai_sv_all_portlet > .Textbox_conteggio_fraudolente_orig_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:108px;
  left:600px;
  left:75.0%;
  right:107px;
  right:13.375%;
  width:auto;
  height:20px;
}
.pg_estrai_sv_all_portlet > .Textbox_conteggio_fraudolente_orig_ctrl {
}
.pg_estrai_sv_all_portlet > .Textbox_conteggio_fraudolente_orig_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
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
 String def="[{\"h\":\"370\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"724\",\"y\":\"46\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"290\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Segno:\",\"w\":\"111\",\"x\":\"192\",\"y\":\"39\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"51\",\"x\":\"84\",\"y\":\"111\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"858\",\"y\":\"105\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"683\",\"y\":\"46\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"573\",\"y\":\"108\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"42\",\"x\":\"858\",\"y\":\"151\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"86\",\"x\":\"858\",\"y\":\"72\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"858\",\"y\":\"184\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"182\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"145\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"9\",\"zindex\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"499\",\"y\":\"-61\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"141\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"10\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trimestre\",\"page\":\"1\",\"textlist\":\"I Trimestre,II Trimestre,III Trimestre,IV Trimestre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTri\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Periodo:\",\"w\":\"69\",\"x\":\"234\",\"y\":\"15\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"filename\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"149\",\"x\":\"5\",\"y\":\"35\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTInit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"73\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnCheck\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"724\",\"y\":\"9\",\"zindex\":\"0\"},{\"h\":\"20\",\"name\":\"RTCheck\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"20\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnCrea\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"683\",\"y\":\"9\",\"zindex\":\"0\"},{\"h\":\"27\",\"name\":\"RTTable\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"-18\"},{\"h\":\"20\",\"name\":\"ftypes\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"858\",\"y\":\"15\"},{\"h\":\"20\",\"name\":\"outFile\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"858\",\"y\":\"-52\"},{\"h\":\"20\",\"name\":\"pDatIni\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"858\",\"y\":\"-91\"},{\"h\":\"20\",\"name\":\"pDatFin\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"-92\"},{\"anchor\":\"top-left-right\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"138\",\"zindex\":\"9\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"431\",\"x\":\"140\",\"y\":\"108\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"-45\"},{\"h\":\"20\",\"name\":\"RTUpdate\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"240\"},{\"h\":\"20\",\"name\":\"RTDownloadXLSX\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"130\",\"x\":\"1014\",\"y\":\"268\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"flgsegno\",\"page\":\"1\",\"textlist\":\"Segno Avere = SEND,Segno Dare = SEND\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"35\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Genera per LCC\",\"layout_steps_values\":{},\"name\":\"chkLCC\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"129\",\"x\":\"539\",\"y\":\"13\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"gIntemediario\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"307\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipo_B3\",\"page\":\"1\",\"textlist\":\"Base 3 Moneytransfer,Base 3 Istituti di Pagamento\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"61\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Segnalazione:\",\"w\":\"111\",\"x\":\"192\",\"y\":\"65\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"Note42\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"portlet che viene chiamato con parametro da voce di menu:\\nnessun parametro = portlet con entrambe le SV \\nMT = SV per moneytransfer\\nIP = SV per istituti di pagamento\",\"w\":\"368\",\"x\":\"1231\",\"y\":\"-92\",\"zindex\":\"11\"},{\"h\":\"20\",\"name\":\"sv_type\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1232\",\"y\":\"14\"},{\"anchor\":\"\",\"h\":\"127\",\"layout_steps_values\":{},\"name\":\"Note46\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"SV per IP: in accordo con Fabio l'estrazione della voce semestrale avviene in concomitanza con l'estrazione delle voci di semestri 2 e 4. Il file contenente le operazioni generato così contiene tutte le operazioni necessarie per generare le voci trimestrali (trimestre 2 e 4) e la voce semestrale (semestre 1 nel caso del trimestre 2 e semestre 2 nel caso della voce trimestre 4).\",\"w\":\"486\",\"x\":\"1188\",\"y\":\"410\",\"zindex\":\"12\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnFraud\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"46\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTFraud\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"211\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Estrai Solo Fraudolente\",\"layout_steps_values\":{},\"name\":\"chkSegnala\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"173\",\"x\":\"539\",\"y\":\"48\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"SQLDataobj_qbe_count_fraud\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"194\",\"x\":\"841\",\"y\":\"361\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_conteggio_fraudolente_tab\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"703\",\"y\":\"108\",\"zindex\":\"14\"},{\"h\":\"20\",\"name\":\"SQLDataobj_qbe_ope_fraudolente\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"218\",\"x\":\"841\",\"y\":\"385\"},{\"h\":\"20\",\"name\":\"SQLTotalizer_qbe_ope_fraudolente\",\"page\":\"1\",\"type\":\"SQLTotalizer\",\"w\":\"226\",\"x\":\"841\",\"y\":\"409\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_conteggio_fraudolente_orig\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"93\",\"x\":\"600\",\"y\":\"108\",\"zindex\":\"17\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrai_sv_all","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrai_sv_all_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrai_sv_all','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label3_segno= "Tipo Segno:";
String label1= "NomeFile:";
String dir= "";
String cartella= "";
String anno= "";
if(request.getAttribute("pg_estrai_sv_all_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String trimestre= "";
String lblTri= "Periodo:";
String filename= "";
String ftypes= "";
String outFile= "";
String pDatIni= "";
String pDatFin= "";
String nomefile= "";
String flgsegno="2";
String chkLCC="N";
String gIntemediario=sp.getGlobal("gIntemediario","");
String tipo_B3= "";
String label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy= "Tipo Segnalazione:";
String sv_type=JSPLib.translateXSS(sp.getParameter("sv_type",""));
String chkSegnala="N";
double Textbox_conteggio_fraudolente_tab= 0;
double Textbox_conteggio_fraudolente_orig= 0;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrai_sv_all_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estrai_sv_all_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrai_sv_all_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrai_sv_all','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnDownload' class='image btnDownload_ctrl'   target=''>&#xebbd;</a>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span id='<%=idPortlet%>_label3_segno'  formid='<%=idPortlet%>' ps-name='label3_segno'    class='label label3_segno_ctrl'><div id='<%=idPortlet%>_label3_segnotbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Segno:")%></div></span>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnUpload' class='image btnUpload_ctrl'   target=''>&#xe9da;</a>
<a id='<%=idPortlet%>_btnUpdate' class='image btnUpdate_ctrl'   target=''>&#xea8c;</a>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<select id='<%=idPortlet%>_trimestre' name='trimestre' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblTri'  formid='<%=idPortlet%>' ps-name='lblTri'    class='label lblTri_ctrl'><div id='<%=idPortlet%>_lblTritbl' style='width:100%;'><%=JSPLib.ToHTML("Periodo:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_filename_wrp'><input id='<%=idPortlet%>_filename' name='filename' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='filename' /></span>
<a id='<%=idPortlet%>_btnCheck' class='image btnCheck_ctrl'   target=''>&#xe96e;</a>
<a id='<%=idPortlet%>_btnCrea' class='image btnCrea_ctrl'   target=''>&#xe90c;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<select id='<%=idPortlet%>_flgsegno' name='flgsegno' class='combobox' style='display:none;font-family:verdana;font-size:7pt;'></select>
<div id='<%=idPortlet%>_chkLCC_div' style=''><input id='<%=idPortlet%>_chkLCC' name='chkLCC' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkLCC' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Genera per LCC")%></label></div>
<select id='<%=idPortlet%>_tipo_B3' name='tipo_B3' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy'    class='label label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Segnalazione:")%></div></span>
<a id='<%=idPortlet%>_btnFraud' class='image btnFraud_ctrl'   target=''>&#xe9a9;</a>
<div id='<%=idPortlet%>_chkSegnala_div' style=''><input id='<%=idPortlet%>_chkSegnala' name='chkSegnala' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkSegnala' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Estrai Solo Fraudolente")%></label></div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_conteggio_fraudolente_tab_wrp'><input id='<%=idPortlet%>_Textbox_conteggio_fraudolente_tab' name='Textbox_conteggio_fraudolente_tab' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_conteggio_fraudolente_tab' inputmode='numeric' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_conteggio_fraudolente_tab>Conteggio Fraudolente tabellone</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_conteggio_fraudolente_orig_wrp'><input id='<%=idPortlet%>_Textbox_conteggio_fraudolente_orig' name='Textbox_conteggio_fraudolente_orig' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_conteggio_fraudolente_orig' inputmode='numeric' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_conteggio_fraudolente_orig>Conteggio Fraudolente origine</label></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrai_sv_all');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrai_sv_all',["800"],["370"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"370","title":"","layer":""}]);
this.btnDownload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDownload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDownload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva il file generato",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDownload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":724,"y":46,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":290,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.label3_segno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label3_segno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label3_segno","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label3_segno,false,true)%>","type":"Label","w":111,"x":192,"y":39,"zindex":"1"});
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"this.sv_type.Value()=='IP'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":84,"y":111,"zindex":"1"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":858,"y":105});
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":683,"y":46,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnUpload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image btnUpload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnUpload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"Eq(this.sv_type.Value(),'IP')","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnUpload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":573,"y":108,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":86,"x":858,"y":72});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":120,"x":858,"y":184});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_estrai_sv_all",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pSegno=flgsegno,pLCC=chkLCC,pTipoBase3=tipo_B3,pFraudo=chkSegnala","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_estrai_sv_all","target":"","type":"SPLinker","w":120,"x":1014,"y":182});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_estrai_sv_all",request.getSession())%>';
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("DownloadFileServlet",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":120,"x":1014,"y":145});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,DownloadFileServlet",request.getSession())%>';
this.btnUpdate=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnUpdate_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnUpdate","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Corregge Tabellone Trimestrale",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnUpdate","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.cartella=new ZtVWeb._VC(this,'cartella',null,'character','<%=JSPLib.ToJSValue(cartella,false,true)%>',false,false);
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(anno,false,true)%>","w":53,"x":141,"y":10,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":10,"y":15,"zindex":"1"});
this.trimestre=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_trimestre","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=trimestre%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"trimestre","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"I Trimestre,II Trimestre,III Trimestre,IV Trimestre","type":"Combobox","typevar":"character","valuelist":"1,2,3,4","visible":true,"w":212,"x":304,"y":10,"zindex":"1"});
this.lblTri=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTri","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTri","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTri,false,true)%>","type":"Label","w":69,"x":234,"y":15,"zindex":"1"});
this.filename=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_filename","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"filename","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(filename,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.RTInit=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTInit","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTInit","offline":false,"page":1,"parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_initdate","target":"","type":"SPLinker","w":120,"x":1014,"y":73});
this.RTInit.m_cID='<%=JSPLib.cmdHash("routine,arfn_initdate",request.getSession())%>';
this.btnCheck=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnCheck_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCheck","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Effettua il controllo dei dati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnCheck","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96e;","srchover":"&#xe96f;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":724,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTCheck=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_estrai_sv_check_all",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCheck","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCheck","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pTipo=C,pFile=nomefile,pTipoBase3=tipo_B3,pFraudo=chkSegnala","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check_all","target":"","type":"SPLinker","w":120,"x":1014,"y":20});
this.RTCheck.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check_all",request.getSession())%>';
this.btnCrea=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnCrea_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCrea","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90c;","font_image_hover":"&#xe90d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Crea Tabellone Trimestrale",false,true)%>","hide":"false","hide_undercond":"Eq(this.tipo_B3.Value(),\"B3IP\")","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnCrea","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe90c;","srchover":"&#xe90d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":683,"y":9,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTTable=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_estrai_sv_check_all",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTTable","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":27,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTTable","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pTipo=T,pFile=nomefile,pTipoBase3=tipo_B3,pFraudo=chkSegnala","popup":"false","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check_all","target":"","type":"SPLinker","w":120,"x":1014,"y":-18});
this.RTTable.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check_all",request.getSession())%>';
this.ftypes=new ZtVWeb._VC(this,'ftypes',null,'character','<%=JSPLib.ToJSValue(ftypes,false,true)%>',false,false);
this.outFile=new ZtVWeb._VC(this,'outFile',null,'character','<%=JSPLib.ToJSValue(outFile,false,true)%>',false,false);
this.pDatIni=new ZtVWeb._VC(this,'pDatIni',null,'character','<%=JSPLib.ToJSValue(pDatIni,false,true)%>',false,false);
this.pDatFin=new ZtVWeb._VC(this,'pDatFin',null,'character','<%=JSPLib.ToJSValue(pDatFin,false,true)%>',false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":138,"zindex":"9"});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.sv_type.Value(),'IP')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":431,"x":140,"y":108,"zerofilling":false,"zindex":"1","zoom":""});
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"ReportName=arrp_estrai_sv_chk.vrp,FileName=outFile,pDADATA=c_dadate,pA_DATA=c_adate,formatTypes=ftypes,hideParameterMask=true,hideCover=true,hideLanguage=true,hideSettings=true,SubstituteQuery=qbe_estrai_sv_ope_chk_wu,hidePreview=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":1014,"y":-45});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTUpdate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_import_correzioni_sv_all",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpdate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpdate","offline":false,"page":1,"parms":"nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_import_correzioni_sv_all","target":"","type":"SPLinker","w":120,"x":1014,"y":240});
this.RTUpdate.m_cID='<%=JSPLib.cmdHash("routine,arfn_import_correzioni_sv_all",request.getSession())%>';
this.RTDownloadXLSX=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownloadXLSX","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownloadXLSX","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadxlsx","target":"iPrint","type":"SPLinker","w":130,"x":1014,"y":268});
this.RTDownloadXLSX.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadxlsx",request.getSession())%>';
this.flgsegno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_flgsegno","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.sv_type.Value(),'IP')","init":"","init_par":"<%=flgsegno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"flgsegno","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Segno Avere = SEND,Segno Dare = SEND","type":"Combobox","typevar":"character","valuelist":"1,2","visible":true,"w":212,"x":304,"y":35,"zindex":"1"});
this.chkLCC=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_chkLCC","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Genera per LCC","layer":false,"layout_steps_values":{},"name":"chkLCC","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":129,"x":539,"y":13,"zindex":"10"});
this.chkLCC.Value('<%=chkLCC%>');
this.gIntemediario=new ZtVWeb._VC(this,'gIntemediario',null,'character','<%=JSPLib.ToJSValue(gIntemediario,false,true)%>',false,false);
this.tipo_B3=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipo_B3","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"<%=tipo_B3%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipo_B3","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":" Base 3 Moneytransfer,Base 3 Istituti di Pagamento","type":"Combobox","typevar":"character","valuelist":"B3MT,B3IP","visible":true,"w":212,"x":304,"y":61,"zindex":"1"});
this.label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":111,"x":192,"y":65,"zindex":"1"});
this.sv_type=new ZtVWeb._VC(this,'sv_type',null,'character','<%=JSPLib.ToJSValue(sv_type,false,true)%>',false,false);
this.btnFraud=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnFraud_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnFraud","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9a9;","font_image_hover":"&#xe9aa;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Aggiorna operazioni fraudolente",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnFraud","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9a9;","srchover":"&#xe9aa;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":46,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTFraud=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_agg_fraudolente",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTFraud","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTFraud","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_agg_fraudolente","target":"","type":"SPLinker","w":120,"x":1014,"y":211});
this.RTFraud.m_cID='<%=JSPLib.cmdHash("routine,arfn_agg_fraudolente",request.getSession())%>';
this.chkSegnala=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_chkSegnala","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Estrai Solo Fraudolente","layer":false,"layout_steps_values":{},"name":"chkSegnala","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":173,"x":539,"y":48,"zindex":"10"});
this.chkSegnala.Value('<%=chkSegnala%>');
this.SQLDataobj_qbe_count_fraud=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_count_fraud",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_count_fraud","cmdHash":"<%=JSPLib.cmdHash("qbe_count_fraud",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_count_fraud","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_count_fraud","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":194,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":841,"y":361});
this.Textbox_conteggio_fraudolente_tab=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_conteggio_fraudolente_tab","decrypt":false,"edit_undercond":"","encrypt":false,"field":"conteggio","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_conteggio_fraudolente_tab","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=Textbox_conteggio_fraudolente_tab%>","w":90,"x":703,"y":108,"zerofilling":false,"zindex":"14","zoom":""});
this.SQLDataobj_qbe_ope_fraudolente=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_ope_fraudolente",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_ope_fraudolente","cmdHash":"<%=JSPLib.cmdHash("qbe_ope_fraudolente",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_ope_fraudolente","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_ope_fraudolente","nrows":"10","page":1,"parms":"pDatIni,pDatFin","parms_source":"","type":"SQLDataobj","w":218,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":841,"y":385});
this.SQLTotalizer_qbe_ope_fraudolente=new ZtVWeb.SQLDataProvider(this, { name: 'SQLTotalizer_qbe_ope_fraudolente', nrows: 1000, fieldstype: 'true', count: 'false', async: false });
this.Textbox_conteggio_fraudolente_orig=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_conteggio_fraudolente_orig","decrypt":false,"edit_undercond":"","encrypt":false,"field":"conteggio","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_conteggio_fraudolente_orig","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=Textbox_conteggio_fraudolente_orig%>","w":93,"x":600,"y":108,"zerofilling":false,"zindex":"17","zoom":""});
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
<%if(request.getAttribute("pg_estrai_sv_all_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrai_sv_all_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrai_sv_all_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnDownload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnUpload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnUpdate.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnCheck.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnCrea.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnFraud.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLDataobj_qbe_count_fraud.firstQuery('true');
window.<%=idPortlet%>.SQLDataobj_qbe_ope_fraudolente.firstQuery('true');
window.<%=idPortlet%>.trimestre.FillData();
window.<%=idPortlet%>.flgsegno.FillData();
window.<%=idPortlet%>.tipo_B3.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrai_sv_all',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrai_sv_all');
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
sp.endPage("pg_estrai_sv_all");
}%>
<%! public String getJSPUID() { return "1935518477"; } %>