<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u002f\u002f Reimpianto\nthis.flaganni.y=57\nthis.flaganni.topposition=57\n\u002f\u002f Numero protocollo file\nthis.lblNumProt.y=8\nthis.lblNumProt.topposition=8\nthis.protfile.y=8\nthis.protfile.topposition=8\nthis.LinkZoom44.y=8\nthis.LinkZoom44.topposition=8 \n\u002f\u002f Vecchio Intermediario\nthis.lblInter.y=8\nthis.lblInter.topposition=8\nthis.oldinter.y=8\nthis.oldinter.topposition=8\n\u002f\u002f Data Chiusura\nthis.lblChiu.y=8\nthis.lblChiu.topposition=8\nthis.datachiu.y=8\nthis.datachiu.topposition=8\n\nfunction this_Loaded(){\n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"Creazione File SID Speciali\",true)\n  this.RTChecks.Parameters(\"pTipo=J\")\n  this.java.Value(this.RTChecks.Link())\n  if(this.java.Value()) {\n    this.javaSi.Show()\n    this.javaNo.Hide()\n  } else {\n    this.javaNo.Show()\n    this.javaSi.Hide()    \n  }  \n  this.RTChecks.Parameters(\"pTipo=C\")\n  this.certificati.Value(this.RTChecks.Link()) \n  if(this.certificati.Value()) {\n    this.certSi.Show()\n    this.certNo.Hide()\n  } else {\n    this.certNo.Show()\n    this.certSi.Hide()    \n  }  \n  this.RTChecks.Parameters(\"pTipo=V\")\n  this.validita.Value(this.RTChecks.Link()) \n  if(this.validita.Value()) {\n    this.valiSi.Show()\n    this.valiNo.Hide()\n  } else {\n    this.valiNo.Show()\n    this.valiSi.Hide()    \n  }    \n  if(this.java.Value() && this.certificati.Value()) {\n    this.btnElab.Show()\n    this.btnPrint.Show()\n    this.btnSearch.Show()\n  } else {\n    this.btnElab.Hide()\n    this.btnPrint.Hide()\n    this.btnSearch.Hide()\n  }   \n  this.LinkZoom44.Hide()  \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()      \n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnSearch_Click(){\n  this.RTSearch.Link()\n}\n\nfunction btnPrint_Click(){\n  this.RTPrint.Link()  \n}\n\nfunction btnDown_Click(){\n  this.RTDown.Link()\n}\n\nfunction RadioChoice_onChange(){  \n  if(this.RadioChoice.Value()=='A'){    \n    this.LinkZoom44.Show()      \n  } else {  \n    this.LinkZoom44.Hide()      \n  }    \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Creazione Operazioni ExtraConto da AUI\u002fAGE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"650","hsl":"false","htmlcode":"{{ @lblChiu }}\n{{ @datachiu }}\n{{ @flaganni }}\n{{ @lblInter }}\n{{ @oldinter }}\n\n{{ @LinkZoom44 }}\n{{ @lblNumProt }}\n{{ @protfile }}\n\n{{ @RadioChoice }}\n{{ @Label32_Copy_Copy }}\n{{ @valiNo }}\n{{ @valiSi }}\n{{ @Label32_Copy }}\n{{ @javaNo }}\n{{ @javaSi }}\n\n\n{{ @certNo }}\n{{ @certSi }}\n\n{{ @Label32 }}\n{{ @Box31 }}\n\n\n{{ @iPrint }}\n{{ @btnSearch }}\n{{ @btnPrint }}\n{{ @btnDown }}\n{{ @flgstp }}\n\n\n\n{{ @lblAOpe }}\n{{ @lblDaOpe }}\n{{ @ADatOpe }}\n{{ @DaDatOpe }}\n\n\n\n\n{{ @pMsg }}\n{{ @pLog }}\n\n{{ @btnElab }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"800","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"800","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"641","y":"215","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"javaNo","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f048.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"216","y":"164","zindex":"14"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"javaSi","page":"1","path_type":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f047.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"191","y":"164","zindex":"14"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"JRE Esecuzione","w":"134","wireframe_props":"align,value,n_col","x":"37","y":"164","zindex":"13"},{"allowedentities":"arrt_famextra","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_daData=DaDatOpe,w_a_Data=ADatOpe,w_tipo=RadioChoice,w_flgstp=flgstp,w_flganni=flaganni,w_protfile=protfile,w_oldinter=oldinter,w_datachiu=datachiu","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_famextra","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"java","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"882","y":"-53"},{"anchor":"","ctrlOfVariant":"","h":"128","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"7","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"250","zindex":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"certificati","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"883","y":"-26"},{"anchor":"","ctrlOfVariant":"","h":"63","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"9","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"379","zindex":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"validita","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"884","y":"5"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"valiSi","page":"1","path_type":"","sequence":"11","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"191","y":"193","zindex":"14"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"valiNo","page":"1","path_type":"","sequence":"12","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"216","y":"193","zindex":"14"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"82","x":"154","y":"-65"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"CharToDate('20110101')","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"19","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"534","y":"8","zerofilling":"false","zindex":"2"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Validità Certificati","w":"134","wireframe_props":"align,value,n_col","x":"37","y":"193","zindex":"13"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"534","y":"32","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"178","wireframe_props":"align,value,n_col","x":"354","y":"8","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"178","wireframe_props":"align,value,n_col","x":"354","y":"32","zindex":"1"},{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Non creare i file per le stampe (Per grossi volumi di dati - IP)","layer":"false","layout_steps_values":"{}","name":"flgstp","page":"1","sequence":"19","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"418","wireframe_props":"label_text","x":"9","y":"222","zindex":"5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"N","name":"flgdett","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"433","y":"222"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gFlgWU","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"665","y":"-65"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva File DGN con errori","hide":"false","hide_undercond":"gFlgWU\u003c\u003e'S'","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDown","page":"1","path_type":"","sequence":"22","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"679","y":"212","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa contenuto dei file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnPrint","page":"1","path_type":"","sequence":"23","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"722","y":"212","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Visualizza i file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnSearch","page":"1","path_type":"","sequence":"24","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"212","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTSearch","offline":"false","page":"1","parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"25","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":"80","x":"245","y":"-63"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTPrint","offline":"false","page":"1","parms":"w_anno=anno,w_mese=mese","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"26","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":"74","x":"334","y":"-61"},{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"199","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"27","spuid":"","type":"Iframe","w":"793","wireframe_props":"","x":"3","y":"446","zindex":"9"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDown","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"28","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":"78","x":"412","y":"-63"},{"allowedentities":"arfn_check_sid","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChecks","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"29","servlet":"arfn_check_sid","target":"","type":"SPLinker","w":"120","x":"521","y":"-62"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"90","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box31","page":"1","sequence":"30","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"237","wireframe_props":"","x":"6","y":"128","zindex":"12"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Presenza Certificati","w":"134","wireframe_props":"align,value,n_col","x":"37","y":"135","zindex":"13"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"certSi","page":"1","path_type":"","sequence":"32","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f047.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"191","y":"135","zindex":"14"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"certNo","page":"1","path_type":"","sequence":"33","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f048.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"216","y":"135","zindex":"14"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","font":"","font_size":"","h":"114","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"RadioChoice","orientation":"vertical","page":"1","picture":"","sequence":"34","spuid":"","tabindex":"","textlist":"Reimpianto,Cambio Identificativo,Presa in carico rapporti,Annullamento File,Chiusura Generalizzata Rapporti","type":"Radio","typevar":"character","valuelist":"R,C,P,A,G","visible":"true","w":"254","wireframe_props":"","x":"6","y":"9","zindex":"15"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'A'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"protfile","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"35","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"227","wireframe_props":"name","x":"534","y":"57","zerofilling":"false","zindex":"16"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'A'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblNumProt","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"36","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Numero Protocollo File:","w":"200","wireframe_props":"align,value,n_col","x":"332","y":"57","zindex":"17"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"protfile","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"protfile","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom44","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"PROTOCOLLO","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"37","servlet":"","spuid":"","suggest":"false","table":"aesaldi","type":"LinkZoom","w":"20","wireframe_props":"","x":"764","y":"57","zindex":"18","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'P'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"oldinter","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"38","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"534","y":"81","zerofilling":"false","zindex":"19"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'P'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblInter","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Vecchio Intermediario:","w":"200","wireframe_props":"align,value,n_col","x":"332","y":"81","zindex":"20"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","init":"","init_par":"N","label_text":"Suddividi il reimpianto in file specifici per ogni anno","layer":"false","layout_steps_values":"{}","name":"flaganni","page":"1","sequence":"40","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"false","w":"365","wireframe_props":"label_text","x":"410","y":"103","zindex":"21"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'G'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"datachiu","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"41","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"534","y":"131","zerofilling":"false","zindex":"22"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'G'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblChiu","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"42","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Chiusura Generalizzata Rapporti:","w":"236","wireframe_props":"align,value,n_col","x":"294","y":"131","zindex":"23"}]%>
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
window.pg_famextra_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnSearch_Click !='undefined')this.btnSearch_Click=btnSearch_Click;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
if(typeof RadioChoice_onChange !='undefined')this.RadioChoice_onChange=RadioChoice_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'R'),this.DaDatOpe);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'R'),this.ADatOpe);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'R'),this.lblDaOpe);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'R'),this.lblAOpe);
ZtVWeb.HideCtrl(Ne(this.gFlgWU.Value(),'S'),this.btnDown);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'A'),this.protfile);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'A'),this.lblNumProt);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'P'),this.oldinter);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'P'),this.lblInter);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'R'),this.flaganni);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'G'),this.datachiu);
ZtVWeb.HideCtrl(Ne(this.RadioChoice.Value(),'G'),this.lblChiu);
}
ZtVWeb.InitCtrl(CharToDate('20110101'),this.DaDatOpe);
ZtVWeb.InitCtrl('N',this.flgstp);
this.LinkZoom44.addObserverFixedVars();
// Reimpianto
this.flaganni.y=57
this.flaganni.topposition=57
// Numero protocollo file
this.lblNumProt.y=8
this.lblNumProt.topposition=8
this.protfile.y=8
this.protfile.topposition=8
this.LinkZoom44.y=8
this.LinkZoom44.topposition=8 
// Vecchio Intermediario
this.lblInter.y=8
this.lblInter.topposition=8
this.oldinter.y=8
this.oldinter.topposition=8
// Data Chiusura
this.lblChiu.y=8
this.lblChiu.topposition=8
this.datachiu.y=8
this.datachiu.topposition=8
function this_Loaded(){
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("Creazione File SID Speciali",true)
  this.RTChecks.Parameters("pTipo=J")
  this.java.Value(this.RTChecks.Link())
  if(this.java.Value()) {
    this.javaSi.Show()
    this.javaNo.Hide()
  } else {
    this.javaNo.Show()
    this.javaSi.Hide()    
  }  
  this.RTChecks.Parameters("pTipo=C")
  this.certificati.Value(this.RTChecks.Link()) 
  if(this.certificati.Value()) {
    this.certSi.Show()
    this.certNo.Hide()
  } else {
    this.certNo.Show()
    this.certSi.Hide()    
  }  
  this.RTChecks.Parameters("pTipo=V")
  this.validita.Value(this.RTChecks.Link()) 
  if(this.validita.Value()) {
    this.valiSi.Show()
    this.valiNo.Hide()
  } else {
    this.valiNo.Show()
    this.valiSi.Hide()    
  }    
  if(this.java.Value() && this.certificati.Value()) {
    this.btnElab.Show()
    this.btnPrint.Show()
    this.btnSearch.Show()
  } else {
    this.btnElab.Hide()
    this.btnPrint.Hide()
    this.btnSearch.Hide()
  }   
  this.LinkZoom44.Hide()  
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
  alert("Elaborazione Completata!");
}
function btnSearch_Click(){
  this.RTSearch.Link()
}
function btnPrint_Click(){
  this.RTPrint.Link()  
}
function btnDown_Click(){
  this.RTDown.Link()
}
function RadioChoice_onChange(){  
  if(this.RadioChoice.Value()=='A'){    
    this.LinkZoom44.Show()      
  } else {  
    this.LinkZoom44.Hide()      
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
.pg_famextra_container {
}
.pg_famextra_title_container {
  margin: auto;
}
.pg_famextra_portlet{
  position:relative;
  margin: auto;
  width:800px;
max-width:800px;
  min-width:800px;
  height:650px;
}
.pg_famextra_portlet[Data-page="1"]{
  height:650px;
  width:800px;
}
.pg_famextra_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:215px;
  right:129px;
  width:30px;
  height:30px;
}
.pg_famextra_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famextra_portlet > .javaNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:164px;
  left:216px;
  right:564px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .javaNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_famextra_portlet > .javaSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:164px;
  left:191px;
  right:589px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .javaSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_famextra_portlet > .Label32_Copy_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:164px;
  left:37px;
  right:629px;
  width:134px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .Label32_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .Label32_Copy_ctrl {
  overflow:hidden;
}
.pg_famextra_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:250px;
  left:3px;
  right:4px;
  width:793px;
  height:auto;
  min-height:128px;
}
.pg_famextra_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:379px;
  left:3px;
  right:4px;
  width:793px;
  height:auto;
  min-height:63px;
}
.pg_famextra_portlet > .valiSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:193px;
  left:191px;
  right:589px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .valiSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_famextra_portlet > .valiNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:193px;
  left:216px;
  right:564px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .valiNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_famextra_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:8px;
  left:534px;
  width:125px;
  height:19px;
}
.pg_famextra_portlet > .DaDatOpe_ctrl {
  display:none;
}
.pg_famextra_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famextra_portlet > .Label32_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:193px;
  left:37px;
  right:629px;
  width:134px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .Label32_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .Label32_Copy_Copy_ctrl {
  overflow:hidden;
}
.pg_famextra_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:32px;
  left:534px;
  width:125px;
  height:20px;
}
.pg_famextra_portlet > .ADatOpe_ctrl {
  display:none;
}
.pg_famextra_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famextra_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:354px;
  right:268px;
  width:178px;
  height:auto;
  min-height:19px;
}
.pg_famextra_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famextra_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
  background-color:transparent;
}
.pg_famextra_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:32px;
  left:354px;
  width:178px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
  background-color:transparent;
}
.pg_famextra_portlet > .flgstp_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:222px;
  left:9px;
  width:418px;
  height:20px;
}
.pg_famextra_portlet > .btnDown_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  right:91px;
  width:30px;
  height:30px;
}
.pg_famextra_portlet > .btnDown_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famextra_portlet > .btnPrint_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  right:48px;
  width:30px;
  height:30px;
}
.pg_famextra_portlet > .btnPrint_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famextra_portlet > .btnSearch_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_famextra_portlet > .btnSearch_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famextra_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:446px;
  left:3px;
  right:4px;
  width:793px;
  height:199px;
}
.pg_famextra_portlet > .Box31_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:128px;
  left:6px;
  right:557px;
  width:237px;
  height:auto;
  min-height:90px;
  display:flex;
  flex-direction:column;
}
.pg_famextra_portlet > .Box31_ctrl {
  height:90px;
}
.pg_famextra_portlet > .Box31_ctrl > .box_content {
  height:100%;
}
.pg_famextra_portlet > .Box31_ctrl {
  min-height:90px;
}
.pg_famextra_portlet > .Label32_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:135px;
  left:37px;
  right:629px;
  width:134px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .Label32_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .Label32_ctrl {
  overflow:hidden;
}
.pg_famextra_portlet > .certSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:135px;
  left:191px;
  right:589px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .certSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_famextra_portlet > .certNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:135px;
  left:216px;
  right:564px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .certNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_famextra_portlet > .RadioChoice_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:9px;
  left:6px;
  right:540px;
  width:254px;
  height:114px;
  height:auto;
  min-height:114px;
}
.pg_famextra_portlet > .protfile_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:57px;
  left:534px;
  right:39px;
  width:227px;
  height:20px;
}
.pg_famextra_portlet > .protfile_ctrl {
  display:none;
}
.pg_famextra_portlet > .protfile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famextra_portlet > .lblNumProt_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:57px;
  left:332px;
  right:268px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblNumProt_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblNumProt_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_famextra_portlet > .LinkZoom44_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:57px;
  left:764px;
  right:16px;
  width:20px;
  height:20px;
}
.pg_famextra_portlet > .oldinter_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:81px;
  left:534px;
  right:146px;
  width:120px;
  height:20px;
}
.pg_famextra_portlet > .oldinter_ctrl {
  display:none;
}
.pg_famextra_portlet > .oldinter_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famextra_portlet > .lblInter_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:81px;
  left:332px;
  right:268px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblInter_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblInter_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_famextra_portlet > .flaganni_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:103px;
  left:410px;
  right:25px;
  width:365px;
  height:25px;
}
.pg_famextra_portlet > .datachiu_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:131px;
  left:534px;
  right:141px;
  width:125px;
  height:20px;
}
.pg_famextra_portlet > .datachiu_ctrl {
  display:none;
}
.pg_famextra_portlet > .datachiu_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famextra_portlet > .lblChiu_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:131px;
  left:294px;
  width:236px;
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblChiu_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famextra_portlet > .lblChiu_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
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
 String def="[{\"h\":\"650\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"800\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"641\",\"y\":\"215\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"216\",\"y\":\"164\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"191\",\"y\":\"164\",\"zindex\":\"14\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"JRE Esecuzione\",\"w\":\"134\",\"x\":\"37\",\"y\":\"164\",\"zindex\":\"13\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"882\",\"y\":\"-53\"},{\"anchor\":\"\",\"h\":\"128\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"250\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"883\",\"y\":\"-26\"},{\"anchor\":\"\",\"h\":\"63\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"379\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"884\",\"y\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"191\",\"y\":\"193\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"216\",\"y\":\"193\",\"zindex\":\"14\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"82\",\"x\":\"154\",\"y\":\"-65\"},{\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"534\",\"y\":\"8\",\"zindex\":\"2\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label32_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Validità Certificati\",\"w\":\"134\",\"x\":\"37\",\"y\":\"193\",\"zindex\":\"13\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"534\",\"y\":\"32\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"178\",\"x\":\"354\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"178\",\"x\":\"354\",\"y\":\"32\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Non creare i file per le stampe (Per grossi volumi di dati - IP)\",\"layout_steps_values\":{},\"name\":\"flgstp\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"418\",\"x\":\"9\",\"y\":\"222\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"flgdett\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"433\",\"y\":\"222\"},{\"h\":\"20\",\"name\":\"gFlgWU\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"665\",\"y\":\"-65\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnDown\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"679\",\"y\":\"212\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnPrint\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"722\",\"y\":\"212\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnSearch\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"212\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTSearch\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"245\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTPrint\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"74\",\"x\":\"334\",\"y\":\"-61\"},{\"anchor\":\"top-left-right\",\"h\":\"199\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"793\",\"x\":\"3\",\"y\":\"446\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"RTDown\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"78\",\"x\":\"412\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTChecks\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"521\",\"y\":\"-62\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"Box31\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"237\",\"x\":\"6\",\"y\":\"128\",\"zindex\":\"12\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label32\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Presenza Certificati\",\"w\":\"134\",\"x\":\"37\",\"y\":\"135\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"certSi\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"191\",\"y\":\"135\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"certNo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"216\",\"y\":\"135\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"114\",\"layout_steps_values\":{},\"name\":\"RadioChoice\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"254\",\"x\":\"6\",\"y\":\"9\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"protfile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"227\",\"x\":\"534\",\"y\":\"57\",\"zindex\":\"16\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblNumProt\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Numero Protocollo File:\",\"w\":\"200\",\"x\":\"332\",\"y\":\"57\",\"zindex\":\"17\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom44\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"764\",\"y\":\"57\",\"zindex\":\"18\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"oldinter\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"534\",\"y\":\"81\",\"zindex\":\"19\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblInter\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Vecchio Intermediario:\",\"w\":\"200\",\"x\":\"332\",\"y\":\"81\",\"zindex\":\"20\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Suddividi il reimpianto in file specifici per ogni anno\",\"layout_steps_values\":{},\"name\":\"flaganni\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"365\",\"x\":\"410\",\"y\":\"103\",\"zindex\":\"21\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"datachiu\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"534\",\"y\":\"131\",\"zindex\":\"22\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblChiu\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Chiusura Generalizzata Rapporti:\",\"w\":\"236\",\"x\":\"294\",\"y\":\"131\",\"zindex\":\"23\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_famextra","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_famextra_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_famextra','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label32_Copy= "JRE Esecuzione";
boolean java= false;
boolean certificati= false;
boolean validita= false;
java.sql.Date DaDatOpe= JSPLib.NullDate();
if(request.getAttribute("pg_famextra_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label32_Copy_Copy= "Validità Certificati";
java.sql.Date ADatOpe= JSPLib.NullDate();
String lblDaOpe= "Da Data Operazione:";
String lblAOpe= "A Data Operazione:";
String flgstp="N";
String flgdett="N";
String gFlgWU=sp.getGlobal("gFlgWU","");
String Label32= "Presenza Certificati";
String RadioChoice= "";
String protfile= "";
String lblNumProt= "Numero Protocollo File:";
if(request.getAttribute("pg_famextra_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String oldinter= "";
String lblInter= "Vecchio Intermediario:";
String flaganni="N";
java.sql.Date datachiu= JSPLib.NullDate();
String lblChiu= "Chiusura Generalizzata Rapporti:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_famextra_title_container' style='width:800px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_famextra_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_famextra_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_famextra','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_javaNo' class='image-default javaNo_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_javaSi' class='image-default javaSi_ctrl'   target=''>&#xe96c;</a>
<span id='<%=idPortlet%>_Label32_Copy'  formid='<%=idPortlet%>' ps-name='Label32_Copy'    class='label Label32_Copy_ctrl'><div id='<%=idPortlet%>_Label32_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("JRE Esecuzione")%></div></span>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<a id='<%=idPortlet%>_valiSi' class='image-default valiSi_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_valiNo' class='image-default valiNo_ctrl'   target=''>&#xe96c;</a>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='date' disabled class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
<span id='<%=idPortlet%>_Label32_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label32_Copy_Copy'    class='label Label32_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label32_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Validità Certificati")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_flgstp_div' style=''><input id='<%=idPortlet%>_flgstp' name='flgstp' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgstp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Non creare i file per le stampe (Per grossi volumi di dati - IP)")%></label></div>
<a id='<%=idPortlet%>_btnDown' class='image btnDown_ctrl'   target=''>&#xebbd;</a>
<a id='<%=idPortlet%>_btnPrint' class='image btnPrint_ctrl'   target=''>&#xeb05;</a>
<a id='<%=idPortlet%>_btnSearch' class='image btnSearch_ctrl'   target=''>&#xe9dc;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_Box31' class='Box31_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box31_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label32'  formid='<%=idPortlet%>' ps-name='Label32'    class='label Label32_ctrl'><div id='<%=idPortlet%>_Label32tbl' style='width:100%;'><%=JSPLib.ToHTML("Presenza Certificati")%></div></span>
<a id='<%=idPortlet%>_certSi' class='image-default certSi_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_certNo' class='image-default certNo_ctrl'   target=''>&#xe96c;</a>
<div id='<%=idPortlet%>_RadioChoice' class='radio' style='z-index:1;'></div>
<span class='textbox-container'id='<%=idPortlet%>_protfile_wrp'><input id='<%=idPortlet%>_protfile' name='protfile' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='protfile' /></span>
<span id='<%=idPortlet%>_lblNumProt'  formid='<%=idPortlet%>' ps-name='lblNumProt'    class='label lblNumProt_ctrl'><div id='<%=idPortlet%>_lblNumProttbl' style='width:100%;'><%=JSPLib.ToHTML("Numero Protocollo File:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom44'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_oldinter_wrp'><input id='<%=idPortlet%>_oldinter' name='oldinter' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='oldinter' /></span>
<span id='<%=idPortlet%>_lblInter'  formid='<%=idPortlet%>' ps-name='lblInter'    class='label lblInter_ctrl'><div id='<%=idPortlet%>_lblIntertbl' style='width:100%;'><%=JSPLib.ToHTML("Vecchio Intermediario:")%></div></span>
<div id='<%=idPortlet%>_flaganni_div' style='display:none;'><input id='<%=idPortlet%>_flaganni' name='flaganni' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flaganni' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Suddividi il reimpianto in file specifici per ogni anno")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_datachiu_wrp'><input id='<%=idPortlet%>_datachiu' name='datachiu' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='datachiu' /></span>
<span id='<%=idPortlet%>_lblChiu'  formid='<%=idPortlet%>' ps-name='lblChiu'    class='label lblChiu_ctrl'><div id='<%=idPortlet%>_lblChiutbl' style='width:100%;'><%=JSPLib.ToHTML("Chiusura Generalizzata Rapporti:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_famextra');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_famextra',["800"],["650"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"650","title":"","layer":"false","npage":"1"}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":641,"y":215,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.javaNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default javaNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_javaNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"javaNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":216,"y":164,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.javaSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default javaSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_javaSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"javaSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":191,"y":164,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label32_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32_Copy,false,true)%>","type":"Label","w":134,"x":37,"y":164,"zindex":"13"});
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_famextra",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_daData=DaDatOpe,w_a_Data=ADatOpe,w_tipo=RadioChoice,w_flgstp=flgstp,w_flganni=flaganni,w_protfile=protfile,w_oldinter=oldinter,w_datachiu=datachiu","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famextra","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_famextra",request.getSession())%>';
this.java=new ZtVWeb._VC(this,'java',null,'logic',<%=java%>,false,false);
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":793,"x":3,"y":250,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.certificati=new ZtVWeb._VC(this,'certificati',null,'logic',<%=certificati%>,false,false);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":63,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":793,"x":3,"y":379,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.validita=new ZtVWeb._VC(this,'validita',null,'logic',<%=validita%>,false,false);
this.valiSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default valiSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_valiSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"valiSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":191,"y":193,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.valiNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default valiNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_valiNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"valiNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":216,"y":193,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":82,"x":154,"y":-65});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"CharToDate('20110101')","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":19,"help_tips":"","hide":"false","hide_undercond":"Ne(this.RadioChoice.Value(),'R')","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaDatOpe%>","w":125,"x":534,"y":8,"zerofilling":false,"zindex":"2","zoom":""});
this.Label32_Copy_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32_Copy_Copy,false,true)%>","type":"Label","w":134,"x":37,"y":193,"zindex":"13"});
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Ne(this.RadioChoice.Value(),'R')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=ADatOpe%>","w":125,"x":534,"y":32,"zerofilling":false,"zindex":"2","zoom":""});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":178,"x":354,"y":8,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'R'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":178,"x":354,"y":32,"zindex":"1"});
this.flgstp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgstp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Non creare i file per le stampe (Per grossi volumi di dati - IP)","layer":false,"layout_steps_values":{},"name":"flgstp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":418,"x":9,"y":222,"zindex":"5"});
this.flgstp.Value('<%=flgstp%>');
this.flgdett=new ZtVWeb._VC(this,'flgdett',null,'character','<%=JSPLib.ToJSValue(flgdett,false,true)%>',false,false);
this.gFlgWU=new ZtVWeb._VC(this,'gFlgWU',null,'character','<%=JSPLib.ToJSValue(gFlgWU,false,true)%>',false,false);
this.btnDown=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDown_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDown","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva File DGN con errori",false,true)%>","hide":"false","hide_undercond":"Ne(this.gFlgWU.Value(),'S')","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDown","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":679,"y":212,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnPrint=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnPrint_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPrint","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa contenuto dei file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnPrint","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":722,"y":212,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnSearch=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnSearch_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnSearch","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Visualizza i file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnSearch","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9dc;","srchover":"&#xe9dd;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":212,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSearch=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSearch","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSearch","offline":false,"page":1,"parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":80,"x":245,"y":-63});
this.RTSearch.m_cID='<%=JSPLib.cmdHash("entity,list_filesid_portlet.jsp",request.getSession())%>';
this.RTPrint=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPrint","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPrint","offline":false,"page":1,"parms":"w_anno=anno,w_mese=mese","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":74,"x":334,"y":-61});
this.RTPrint.m_cID='<%=JSPLib.cmdHash("routine,arrt_famprino_stp",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":199,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":793,"x":3,"y":446,"zindex":"9"});
this.RTDown=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDown","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDown","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":78,"x":412,"y":-63});
this.RTDown.m_cID='<%=JSPLib.cmdHash("routine,arrt_famgetdgn",request.getSession())%>';
this.RTChecks=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_check_sid",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChecks","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChecks","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_check_sid","target":"","type":"SPLinker","w":120,"x":521,"y":-62});
this.RTChecks.m_cID='<%=JSPLib.cmdHash("routine,arfn_check_sid",request.getSession())%>';
this.Box31=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box31","groupName":"","h":90,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box31","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":237,"x":6,"y":128,"zindex":"12"});
this.Label32=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32,false,true)%>","type":"Label","w":134,"x":37,"y":135,"zindex":"13"});
this.certSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default certSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_certSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"certSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":191,"y":135,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.certNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default certNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_certNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"certNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":216,"y":135,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RadioChoice=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Reimpianto,Cambio Identificativo,Presa in carico rapporti,Annullamento File,Chiusura Generalizzata Rapporti","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_RadioChoice","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":114,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"name":"RadioChoice","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"R,C,P,A,G","visible":true,"w":254,"x":6,"y":9,"zindex":"15"});
this.protfile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_protfile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Ne(this.RadioChoice.Value(),'A')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"protfile","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(protfile,false,true)%>","w":227,"x":534,"y":57,"zerofilling":false,"zindex":"16","zoom":""});
this.lblNumProt=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblNumProt","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'A'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNumProt","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblNumProt,false,true)%>","type":"Label","w":200,"x":332,"y":57,"zindex":"17"});
this.LinkZoom44=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom44","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_famextra_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"protfile","intovarsType":"C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_famextra_portlet.jspLinkZoom44",request.getSession())%>","linkedField":"protfile","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom44","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"PROTOCOLLO","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,aesaldi,default",request.getSession())%>","suggest":false,"table":"aesaldi","type":"LinkZoom","w":20,"x":764,"y":57,"zindex":"18","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.oldinter=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_oldinter","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Ne(this.RadioChoice.Value(),'P')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"oldinter","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(oldinter,false,true)%>","w":120,"x":534,"y":81,"zerofilling":false,"zindex":"19","zoom":""});
this.lblInter=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblInter","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'P'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblInter","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblInter,false,true)%>","type":"Label","w":200,"x":332,"y":81,"zindex":"20"});
this.flaganni=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flaganni","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"Ne(this.RadioChoice.Value(),'R')","init":"","init_par":"N","label_text":"Suddividi il reimpianto in file specifici per ogni anno","layer":false,"layout_steps_values":{},"name":"flaganni","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"false","w":365,"x":410,"y":103,"zindex":"21"});
this.flaganni.Value('<%=flaganni%>');
this.datachiu=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_datachiu","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Ne(this.RadioChoice.Value(),'G')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"datachiu","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=datachiu%>","w":125,"x":534,"y":131,"zerofilling":false,"zindex":"22","zoom":""});
this.lblChiu=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblChiu","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"RadioChoice\u003c\u003e 'G'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblChiu","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblChiu,false,true)%>","type":"Label","w":236,"x":294,"y":131,"zindex":"23"});
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
<%if(request.getAttribute("pg_famextra_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_famextra_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_famextra_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.javaNo.dispatchEvent('OnLoad');
window.<%=idPortlet%>.javaSi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.valiSi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.valiNo.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnDown.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnPrint.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnSearch.dispatchEvent('OnLoad');
window.<%=idPortlet%>.certSi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.certNo.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_famextra',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_famextra');
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
sp.endPage("pg_famextra");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom44")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "aesaldi";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"PROTOCOLLO"};
  result.m_rdTypes = new String[]{"C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3653932082"; } %>