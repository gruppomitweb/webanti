<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Creazione File SID Ordinari\",true)\n  this.RTChecks.Parameters(\"pTipo=J\")\n  this.java.Value(this.RTChecks.Link())\n  if(this.java.Value()) {\n    this.javaSi.Show()\n    this.javaNo.Hide()\n  } else {\n    this.javaNo.Show()\n    this.javaSi.Hide()    \n  }  \n  this.RTChecks.Parameters(\"pTipo=C\")\n  this.certificati.Value(this.RTChecks.Link()) \n  if(this.certificati.Value()) {\n    this.certSi.Show()\n    this.certNo.Hide()\n  } else {\n    this.certNo.Show()\n    this.certSi.Hide()    \n  }  \n  this.RTChecks.Parameters(\"pTipo=V\")\n  this.validita.Value(this.RTChecks.Link()) \n  if(this.validita.Value()) {\n    this.valiSi.Show()\n    this.valiNo.Hide()\n  } else {\n    this.valiNo.Show()\n    this.valiSi.Hide()    \n  }    \n  if(this.java.Value() && this.certificati.Value()) {\n    this.btnElab.Show()\n    this.btnPrint.Show()\n    this.btnSearch.Show()\n  } else {\n    this.btnElab.Hide()\n    this.btnPrint.Hide()\n    this.btnSearch.Hide()\n  }  \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.PortletLogs.Start();  \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop();  \n  alert(\"Elaborazione Completata!\");\n  this.AggiornaDatiADE.Emit()\n}\n\nfunction anno_onChange(){\n  if(this.anno.Value()==0) {\n    this.mese.Value(\"\")    \n    this.DaDatOpe.Value(NullDate())\n    this.ADatOpe.Value(NullDate())\n  } else {\n    this.CalcolaDate() \n  }  \n}\n\nfunction mese_onChange(){\n  if(Empty(this.mese.Value())) {\n    this.DaDatOpe.Value(NullDate())\n    this.ADatOpe.Value(NullDate())    \n  } else {\n    this.CalcolaDate()      \n  }  \n}\n\nfunction CalcolaDate() {\n this.DaDatOpe.Value(iif(!Empty(this.anno.Value()) && !Empty(this.mese.Value()),CharToDate(Str(this.anno.Value(),4,0)+this.mese.Value()+\"01\"),this.DaDatOpe.Value()))\n}  \n\nfunction DaDatOpe_onChange(){\n if (!Empty(this.DaDatOpe.Value())){\n   this.ADatOpe.Value(arfn_finemese(this.DaDatOpe.Value()))    \n }\n}\n\nfunction btnSearch_Click(){\n  this.RTSearch.Link()\n}\n\nfunction btnPrint_Click(){\n  this.RTPrint.Link()  \n}\n\nfunction btnDown_Click(){\n  this.RTDown.Link()\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Creazione Operazioni ExtraConto da AUI\u002fAGE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @btnElab }}{{ @javaNo }}{{ @javaSi }}{{ @Label32_Copy }}{{ @pLog }}{{ @anno }}{{ @lblAnno }}{{ @valiSi }}{{ @mese }}{{ @lblMese }}{{ @valiNo }}{{ @DaDatOpe }}{{ @Label32_Copy_Copy }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @flgagg }}{{ @flgnew }}{{ @flgdel }}{{ @flgstp }}{{ @btnDown }}{{ @btnPrint }}{{ @btnSearch }}{{ @iPrint }}{{ @Box31 }}{{ @Label32 }}{{ @certSi }}{{ @certNo }}{{ @chkClose }}{{ @pMsg }}{{ @btnElab }}{{ @javaNo }}{{ @javaSi }}{{ @Label32_Copy }}{{ @iPrint }}{{ @anno }}{{ @lblAnno }}{{ @valiSi }}{{ @mese }}{{ @lblMese }}{{ @valiNo }}{{ @DaDatOpe }}{{ @Label32_Copy_Copy }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @flgagg }}{{ @flgnew }}{{ @flgdel }}{{ @flgstp }}{{ @btnDown }}{{ @btnPrint }}{{ @btnSearch }}{{ @Box31 }}{{ @Label32 }}{{ @certSi }}{{ @certNo }}{{ @chkClose }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"470","hsl":"false","htmlcode":"{{ @PortletLogs }} \n \n{{ @chkClose }}\n\n{{ @Label32_Copy_Copy }}\n{{ @valiNo }}\n{{ @valiSi }}\n{{ @Label32_Copy }}\n{{ @javaNo }}\n{{ @javaSi }}\n\n\n{{ @certNo }}\n{{ @certSi }}\n\n{{ @Label32 }}\n{{ @Box31 }}\n\n\n{{ @iPrint }}\n{{ @btnSearch }}\n{{ @btnPrint }}\n{{ @btnDown }}\n{{ @flgstp }}\n{{ @flgdel }}\n{{ @flgnew }}\n{{ @flgagg }}\n{{ @lblAOpe }}\n{{ @lblDaOpe }}\n{{ @ADatOpe }}\n{{ @DaDatOpe }}\n{{ @lblMese }}\n{{ @mese }}\n{{ @lblAnno }}\n{{ @anno }}\n\n\n\n{{ @btnElab }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"800","min_w":"","mode":"NORMAL","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"470\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","rapp":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"737","y":"24","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"javaNo","page":"1","path_type":"","rapp":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f048.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"491","y":"115","zindex":"14","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"javaSi","page":"1","path_type":"","rapp":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f047.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"466","y":"115","zindex":"14","zone":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"JRE Esecuzione","w":"134","wireframe_props":"align,value,n_col","x":"312","y":"115","zindex":"13","zone":""},{"allowedentities":"arrt_faminvio","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_anno=anno,w_mese=mese,w_dadata=DaDatOpe,w_a_data=ADatOpe,w_flgagg=flgagg,w_flgdel=flgdel,w_flgnew=flgnew,w_flgstp=flgstp,w_flgdett=flgdett,w_flagchiu=chkClose","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_faminvio","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"java","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"879","y":"-24"},{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"134","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"7","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"255","zindex":"8","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"certificati","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"882","y":"-1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"validita","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"882","y":"26"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"53","wireframe_props":"name","x":"140","y":"29","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"9","y":"34","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"valiSi","page":"1","path_type":"","rapp":"","sequence":"12","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"466","y":"144","zindex":"14","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"mese","page":"1","picture":"","rapp":"","sequence":"13","spuid":"","tabindex":"","textlist":"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre","type":"Combobox","typevar":"character","valuelist":"01,02,03,04,05,06,07,08,09,10,11,12","visible":"true","w":"212","wireframe_props":"name,textlist","x":"274","y":"29","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMese","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Mese:","w":"69","wireframe_props":"align,value,n_col","x":"206","y":"34","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"valiNo","page":"1","path_type":"","rapp":"","sequence":"15","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"491","y":"144","zindex":"14","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"601","y":"12","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Validità Certificati","w":"134","wireframe_props":"align,value,n_col","x":"312","y":"144","zindex":"13","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"601","y":"46","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"470","y":"15","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"470","y":"51","zindex":"1","zone":""},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Aggiornamenti\u002fRettifiche","layer":"false","layout_steps_values":"{}","name":"flgagg","page":"1","rapp":"","sequence":"22","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"190","wireframe_props":"label_text","x":"217","y":"188","zindex":"4","zone":""},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Nuovi Rapporti\u002fChiusure","layer":"false","layout_steps_values":"{}","name":"flgnew","page":"1","rapp":"","sequence":"23","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"190","wireframe_props":"label_text","x":"9","y":"188","zindex":"4","zone":""},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Annullamenti\u002fCancellazioni","layer":"false","layout_steps_values":"{}","name":"flgdel","page":"1","rapp":"","sequence":"24","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"204","wireframe_props":"label_text","x":"425","y":"188","zindex":"4","zone":""},{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Non creare i file per le stampe (Per grossi volumi di dati - IP)","layer":"false","layout_steps_values":"{}","name":"flgstp","page":"1","rapp":"","sequence":"25","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"418","wireframe_props":"label_text","x":"9","y":"221","zindex":"5","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"N","name":"flgdett","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"653","y":"102"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gFlgWU","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"665","y":"-65"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva File DGN con errori","hide":"false","hide_undercond":"gFlgWU\u003c\u003e'S'","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDown","page":"1","path_type":"fixed","rapp":"","sequence":"28","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"679","y":"212","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa contenuto dei file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnPrint","page":"1","path_type":"","rapp":"","sequence":"29","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"722","y":"212","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Visualizza i file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnSearch","page":"1","path_type":"fixed","rapp":"","sequence":"30","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"212","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTSearch","offline":"false","page":"1","parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"31","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":"80","x":"245","y":"-63"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTPrint","offline":"false","page":"1","parms":"w_anno=anno,w_mese=mese","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"32","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":"74","x":"334","y":"-61"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDown","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"33","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":"78","x":"412","y":"-63"},{"allowedentities":"arfn_check_sid","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChecks","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"34","servlet":"arfn_check_sid","target":"","type":"SPLinker","w":"120","x":"521","y":"-62"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"90","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box31","page":"1","rapp":"","sequence":"35","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"237","wireframe_props":"","x":"281","y":"79","zindex":"12","zone":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"36","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Presenza Certificati","w":"134","wireframe_props":"align,value,n_col","x":"312","y":"86","zindex":"13","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"certSi","page":"1","path_type":"","rapp":"","sequence":"37","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f047.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"466","y":"86","zindex":"14","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"certNo","page":"1","path_type":"","rapp":"","sequence":"38","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f048.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"491","y":"86","zindex":"14","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"25","help_tips":"","hide":"false","hide_undercond":"flgnew \u003c\u003e 'S'","init":"","init_par":"N","label_text":"Chiusura Straordinaria","layer":"false","layout_steps_values":"{}","name":"chkClose","page":"1","rapp":"","sequence":"39","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"false","w":"211","wireframe_props":"label_text","x":"442","y":"221","zindex":"15","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"AggiornaDatiADE","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"40","type":"EventEmitter","w":"120","x":"882","y":"51"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"41","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"390","zindex":"3","zone":""}]%>
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
window.pg_faminvio_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof anno_onChange !='undefined')this.anno_onChange=anno_onChange;
if(typeof mese_onChange !='undefined')this.mese_onChange=mese_onChange;
if(typeof CalcolaDate !='undefined')this.CalcolaDate=CalcolaDate;
if(typeof DaDatOpe_onChange !='undefined')this.DaDatOpe_onChange=DaDatOpe_onChange;
if(typeof btnSearch_Click !='undefined')this.btnSearch_Click=btnSearch_Click;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Ne(this.gFlgWU.Value(),'S'),this.btnDown);
ZtVWeb.HideCtrl(Ne(this.flgnew.Value(),'S'),this.chkClose);
}
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
ZtVWeb.InitCtrl('S',this.flgagg);
ZtVWeb.InitCtrl('S',this.flgnew);
ZtVWeb.InitCtrl('S',this.flgdel);
ZtVWeb.InitCtrl('N',this.flgstp);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Creazione File SID Ordinari",true)
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
}
function btnElab_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.PortletLogs.Start();  
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.PortletLogs.Stop();  
  alert("Elaborazione Completata!");
  this.AggiornaDatiADE.Emit()
}
function anno_onChange(){
  if(this.anno.Value()==0) {
    this.mese.Value("")    
    this.DaDatOpe.Value(NullDate())
    this.ADatOpe.Value(NullDate())
  } else {
    this.CalcolaDate() 
  }  
}
function mese_onChange(){
  if(Empty(this.mese.Value())) {
    this.DaDatOpe.Value(NullDate())
    this.ADatOpe.Value(NullDate())    
  } else {
    this.CalcolaDate()      
  }  
}
function CalcolaDate() {
 this.DaDatOpe.Value(iif(!Empty(this.anno.Value()) && !Empty(this.mese.Value()),CharToDate(Str(this.anno.Value(),4,0)+this.mese.Value()+"01"),this.DaDatOpe.Value()))
}  
function DaDatOpe_onChange(){
 if (!Empty(this.DaDatOpe.Value())){
   this.ADatOpe.Value(arfn_finemese(this.DaDatOpe.Value()))    
 }
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

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_faminvio_container {
  height:100%;
  overflow:auto;
}
.pg_faminvio_title_container {
  margin: auto;
}
.pg_faminvio_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:800px;
  min-width:800px;
  height:100%;
}
.pg_faminvio_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_faminvio_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:24px;
  right:33px;
  width:30px;
  height:30px;
}
.pg_faminvio_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_faminvio_portlet > .javaNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:115px;
  left:491px;
  left:61.375%;
  right:289px;
  right:36.125%;
  width:auto;
  height:20px;
}
.pg_faminvio_portlet > .javaNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_faminvio_portlet > .javaSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:115px;
  left:466px;
  left:58.25%;
  right:314px;
  right:39.25%;
  width:auto;
  height:20px;
}
.pg_faminvio_portlet > .javaSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_faminvio_portlet > .Label32_Copy_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:115px;
  left:312px;
  left:39.0%;
  right:354px;
  right:44.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_faminvio_portlet > .Label32_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_faminvio_portlet > .Label32_Copy_ctrl {
  overflow:hidden;
}
.pg_faminvio_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:255px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:81px;
  width:auto;
}
.pg_faminvio_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:140px;
  width:53px;
  height:20px;
}
.pg_faminvio_portlet > .anno_ctrl {
}
.pg_faminvio_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_faminvio_portlet > .lblAnno_ctrl {
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
.pg_faminvio_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_faminvio_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_faminvio_portlet > .valiSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:144px;
  left:466px;
  left:58.25%;
  right:314px;
  right:39.25%;
  width:auto;
  height:20px;
}
.pg_faminvio_portlet > .valiSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_faminvio_portlet > .mese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:274px;
  width:212px;
  height:20px;
}
.pg_faminvio_portlet > .lblMese_ctrl {
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
.pg_faminvio_portlet > .lblMese_ctrl {
  height:auto;
  min-height:19px;
}
.pg_faminvio_portlet > .lblMese_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_faminvio_portlet > .valiNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:144px;
  left:491px;
  left:61.375%;
  right:289px;
  right:36.125%;
  width:auto;
  height:20px;
}
.pg_faminvio_portlet > .valiNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_faminvio_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:601px;
  width:86px;
  height:20px;
}
.pg_faminvio_portlet > .DaDatOpe_ctrl {
}
.pg_faminvio_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_faminvio_portlet > .Label32_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:144px;
  left:312px;
  left:39.0%;
  right:354px;
  right:44.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_faminvio_portlet > .Label32_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_faminvio_portlet > .Label32_Copy_Copy_ctrl {
  overflow:hidden;
}
.pg_faminvio_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:46px;
  left:601px;
  width:86px;
  height:20px;
}
.pg_faminvio_portlet > .ADatOpe_ctrl {
}
.pg_faminvio_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_faminvio_portlet > .lblDaOpe_ctrl {
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
.pg_faminvio_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_faminvio_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_faminvio_portlet > .lblAOpe_ctrl {
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
.pg_faminvio_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_faminvio_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_faminvio_portlet > .flgagg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:188px;
  left:217px;
  width:190px;
  height:20px;
}
.pg_faminvio_portlet > .flgnew_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:188px;
  left:9px;
  width:190px;
  height:20px;
}
.pg_faminvio_portlet > .flgdel_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:188px;
  left:425px;
  width:204px;
  height:20px;
}
.pg_faminvio_portlet > .flgstp_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:221px;
  left:9px;
  width:418px;
  height:25px;
}
.pg_faminvio_portlet > .btnDown_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  right:91px;
  width:30px;
  height:30px;
}
.pg_faminvio_portlet > .btnDown_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_faminvio_portlet > .btnPrint_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  right:48px;
  width:30px;
  height:30px;
}
.pg_faminvio_portlet > .btnPrint_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_faminvio_portlet > .btnSearch_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_faminvio_portlet > .btnSearch_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_faminvio_portlet > .Box31_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:79px;
  left:281px;
  left:35.125%;
  right:282px;
  right:35.25%;
  width:auto;
  height:auto;
  min-height:90px;
  display:flex;
  flex-direction:column;
}
.pg_faminvio_portlet > .Box31_ctrl {
  height:90px;
}
.pg_faminvio_portlet > .Box31_ctrl > .box_content {
  height:100%;
}
.pg_faminvio_portlet > .Box31_ctrl {
  min-height:90px;
}
.pg_faminvio_portlet > .Label32_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:86px;
  left:312px;
  left:39.0%;
  right:354px;
  right:44.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_faminvio_portlet > .Label32_ctrl {
  height:auto;
  min-height:20px;
}
.pg_faminvio_portlet > .Label32_ctrl {
  overflow:hidden;
}
.pg_faminvio_portlet > .certSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:86px;
  left:466px;
  left:58.25%;
  right:314px;
  right:39.25%;
  width:auto;
  height:20px;
}
.pg_faminvio_portlet > .certSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_faminvio_portlet > .certNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:86px;
  left:491px;
  left:61.375%;
  right:289px;
  right:36.125%;
  width:auto;
  height:20px;
}
.pg_faminvio_portlet > .certNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_faminvio_portlet > .chkClose_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:221px;
  left:442px;
  left:55.25%;
  right:147px;
  right:18.375%;
  width:auto;
  height:25px;
}
.pg_faminvio_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:390px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
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
 String def="[{\"h\":\"470\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"737\",\"y\":\"24\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"491\",\"y\":\"115\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"466\",\"y\":\"115\",\"zindex\":\"14\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"JRE Esecuzione\",\"w\":\"134\",\"x\":\"312\",\"y\":\"115\",\"zindex\":\"13\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"879\",\"y\":\"-24\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"134\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"255\",\"zindex\":\"8\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"882\",\"y\":\"-1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"882\",\"y\":\"26\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"140\",\"y\":\"29\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"9\",\"y\":\"34\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"valiSi\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"466\",\"y\":\"144\",\"zindex\":\"14\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"mese\",\"page\":\"1\",\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"274\",\"y\":\"29\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMese\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"69\",\"x\":\"206\",\"y\":\"34\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"valiNo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"491\",\"y\":\"144\",\"zindex\":\"14\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"601\",\"y\":\"12\",\"zindex\":\"2\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label32_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Validità Certificati\",\"w\":\"134\",\"x\":\"312\",\"y\":\"144\",\"zindex\":\"13\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"601\",\"y\":\"46\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"129\",\"x\":\"470\",\"y\":\"15\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"129\",\"x\":\"470\",\"y\":\"51\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Aggiornamenti\\u002fRettifiche\",\"layout_steps_values\":{},\"name\":\"flgagg\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"190\",\"x\":\"217\",\"y\":\"188\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Nuovi Rapporti\\u002fChiusure\",\"layout_steps_values\":{},\"name\":\"flgnew\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"190\",\"x\":\"9\",\"y\":\"188\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Annullamenti\\u002fCancellazioni\",\"layout_steps_values\":{},\"name\":\"flgdel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"204\",\"x\":\"425\",\"y\":\"188\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"25\",\"label_text\":\"Non creare i file per le stampe (Per grossi volumi di dati - IP)\",\"layout_steps_values\":{},\"name\":\"flgstp\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"418\",\"x\":\"9\",\"y\":\"221\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"flgdett\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"653\",\"y\":\"102\"},{\"h\":\"20\",\"name\":\"gFlgWU\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"665\",\"y\":\"-65\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnDown\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"679\",\"y\":\"212\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnPrint\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"722\",\"y\":\"212\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnSearch\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"212\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTSearch\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"245\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTPrint\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"74\",\"x\":\"334\",\"y\":\"-61\"},{\"h\":\"20\",\"name\":\"RTDown\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"78\",\"x\":\"412\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTChecks\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"521\",\"y\":\"-62\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"Box31\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"237\",\"x\":\"281\",\"y\":\"79\",\"zindex\":\"12\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label32\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Presenza Certificati\",\"w\":\"134\",\"x\":\"312\",\"y\":\"86\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"certSi\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"466\",\"y\":\"86\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"certNo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"491\",\"y\":\"86\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Chiusura Straordinaria\",\"layout_steps_values\":{},\"name\":\"chkClose\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"211\",\"x\":\"442\",\"y\":\"221\",\"zindex\":\"15\"},{\"h\":\"20\",\"name\":\"AggiornaDatiADE\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"120\",\"x\":\"882\",\"y\":\"51\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"name\":\"PortletLogs\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"390\",\"zindex\":\"3\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_faminvio","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_faminvio_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_faminvio','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label32_Copy= "JRE Esecuzione";
boolean java= false;
boolean certificati= false;
boolean validita= false;
double anno= 0;
if(request.getAttribute("pg_faminvio_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String mese= "";
String lblMese= "Mese:";
java.sql.Date DaDatOpe= JSPLib.NullDate();
String Label32_Copy_Copy= "Validità Certificati";
java.sql.Date ADatOpe= JSPLib.NullDate();
String lblDaOpe= "Da Data Operazione:";
String lblAOpe= "A Data Operazione:";
String flgagg="N";
String flgnew="N";
String flgdel="N";
String flgstp="N";
String flgdett="N";
String gFlgWU=sp.getGlobal("gFlgWU","");
String Label32= "Presenza Certificati";
String chkClose="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_faminvio_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_faminvio_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_faminvio_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_faminvio','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_javaNo' class='image-default javaNo_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_javaSi' class='image-default javaSi_ctrl'   target=''>&#xe96c;</a>
<span id='<%=idPortlet%>_Label32_Copy'  formid='<%=idPortlet%>' ps-name='Label32_Copy'    class='label Label32_Copy_ctrl'><div id='<%=idPortlet%>_Label32_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("JRE Esecuzione")%></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<a id='<%=idPortlet%>_valiSi' class='image-default valiSi_ctrl'   target=''>&#xe96c;</a>
<select id='<%=idPortlet%>_mese' name='mese' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblMese'  formid='<%=idPortlet%>' ps-name='lblMese'    class='label lblMese_ctrl'><div id='<%=idPortlet%>_lblMesetbl' style='width:100%;'><%=JSPLib.ToHTML("Mese:")%></div></span>
<a id='<%=idPortlet%>_valiNo' class='image-default valiNo_ctrl'   target=''>&#xe96c;</a>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
<span id='<%=idPortlet%>_Label32_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label32_Copy_Copy'    class='label Label32_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label32_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Validità Certificati")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_flgagg_div' style=''><input id='<%=idPortlet%>_flgagg' name='flgagg' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgagg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Aggiornamenti/Rettifiche")%></label></div>
<div id='<%=idPortlet%>_flgnew_div' style=''><input id='<%=idPortlet%>_flgnew' name='flgnew' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgnew' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Nuovi Rapporti/Chiusure")%></label></div>
<div id='<%=idPortlet%>_flgdel_div' style=''><input id='<%=idPortlet%>_flgdel' name='flgdel' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgdel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Annullamenti/Cancellazioni")%></label></div>
<div id='<%=idPortlet%>_flgstp_div' style=''><input id='<%=idPortlet%>_flgstp' name='flgstp' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgstp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Non creare i file per le stampe (Per grossi volumi di dati - IP)")%></label></div>
<a id='<%=idPortlet%>_btnDown' class='image btnDown_ctrl'   target=''>&#xebbd;</a>
<a id='<%=idPortlet%>_btnPrint' class='image btnPrint_ctrl'   target=''>&#xeb05;</a>
<a id='<%=idPortlet%>_btnSearch' class='image btnSearch_ctrl'   target=''>&#xe9dc;</a>
<div id='<%=idPortlet%>_Box31' class='Box31_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box31_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label32'  formid='<%=idPortlet%>' ps-name='Label32'    class='label Label32_ctrl'><div id='<%=idPortlet%>_Label32tbl' style='width:100%;'><%=JSPLib.ToHTML("Presenza Certificati")%></div></span>
<a id='<%=idPortlet%>_certSi' class='image-default certSi_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_certNo' class='image-default certNo_ctrl'   target=''>&#xe96c;</a>
<div id='<%=idPortlet%>_chkClose_div' style='display:none;'><input id='<%=idPortlet%>_chkClose' name='chkClose' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkClose' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Chiusura Straordinaria")%></label></div>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_faminvio');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_faminvio',["800"],["470"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"470","title":"","layer":""}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":737,"y":24,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.javaNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default javaNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_javaNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"javaNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":491,"y":115,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.javaSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default javaSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_javaSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"javaSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":466,"y":115,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label32_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32_Copy,false,true)%>","type":"Label","w":134,"x":312,"y":115,"zindex":"13"});
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_faminvio",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_anno=anno,w_mese=mese,w_dadata=DaDatOpe,w_a_data=ADatOpe,w_flgagg=flgagg,w_flgdel=flgdel,w_flgnew=flgnew,w_flgstp=flgstp,w_flgdett=flgdett,w_flagchiu=chkClose","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_faminvio","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_faminvio",request.getSession())%>';
this.java=new ZtVWeb._VC(this,'java',null,'logic',<%=java%>,false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":134,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":255,"zindex":"8"});
this.certificati=new ZtVWeb._VC(this,'certificati',null,'logic',<%=certificati%>,false,false);
this.validita=new ZtVWeb._VC(this,'validita',null,'logic',<%=validita%>,false,false);
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=anno%>","w":53,"x":140,"y":29,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":9,"y":34,"zindex":"1"});
this.valiSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default valiSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_valiSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"valiSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":466,"y":144,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.mese=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_mese","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=mese%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"mese","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre","type":"Combobox","typevar":"character","valuelist":"01,02,03,04,05,06,07,08,09,10,11,12","visible":true,"w":212,"x":274,"y":29,"zindex":"1"});
this.lblMese=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMese","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMese","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMese,false,true)%>","type":"Label","w":69,"x":206,"y":34,"zindex":"1"});
this.valiNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default valiNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_valiNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"valiNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":491,"y":144,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=DaDatOpe%>","w":86,"x":601,"y":12,"zerofilling":false,"zindex":"2","zoom":""});
this.Label32_Copy_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32_Copy_Copy,false,true)%>","type":"Label","w":134,"x":312,"y":144,"zindex":"13"});
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=ADatOpe%>","w":86,"x":601,"y":46,"zerofilling":false,"zindex":"2","zoom":""});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":129,"x":470,"y":15,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":129,"x":470,"y":51,"zindex":"1"});
this.flgagg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgagg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Aggiornamenti\u002fRettifiche","layer":false,"layout_steps_values":{},"name":"flgagg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":190,"x":217,"y":188,"zindex":"4"});
this.flgagg.Value('<%=flgagg%>');
this.flgnew=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgnew","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Nuovi Rapporti\u002fChiusure","layer":false,"layout_steps_values":{},"name":"flgnew","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":190,"x":9,"y":188,"zindex":"4"});
this.flgnew.Value('<%=flgnew%>');
this.flgdel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgdel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Annullamenti\u002fCancellazioni","layer":false,"layout_steps_values":{},"name":"flgdel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":204,"x":425,"y":188,"zindex":"4"});
this.flgdel.Value('<%=flgdel%>');
this.flgstp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgstp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Non creare i file per le stampe (Per grossi volumi di dati - IP)","layer":false,"layout_steps_values":{},"name":"flgstp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":418,"x":9,"y":221,"zindex":"5"});
this.flgstp.Value('<%=flgstp%>');
this.flgdett=new ZtVWeb._VC(this,'flgdett',null,'character','<%=JSPLib.ToJSValue(flgdett,false,true)%>',false,false);
this.gFlgWU=new ZtVWeb._VC(this,'gFlgWU',null,'character','<%=JSPLib.ToJSValue(gFlgWU,false,true)%>',false,false);
this.btnDown=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDown_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDown","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva File DGN con errori",false,true)%>","hide":"false","hide_undercond":"Ne(this.gFlgWU.Value(),'S')","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDown","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":679,"y":212,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnPrint=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnPrint_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPrint","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa contenuto dei file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnPrint","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":722,"y":212,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnSearch=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnSearch_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnSearch","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Visualizza i file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnSearch","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xe9dc;","srchover":"&#xe9dd;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":212,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSearch=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSearch","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSearch","offline":false,"page":1,"parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":80,"x":245,"y":-63});
this.RTSearch.m_cID='<%=JSPLib.cmdHash("entity,list_filesid_portlet.jsp",request.getSession())%>';
this.RTPrint=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPrint","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPrint","offline":false,"page":1,"parms":"w_anno=anno,w_mese=mese","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":74,"x":334,"y":-61});
this.RTPrint.m_cID='<%=JSPLib.cmdHash("routine,arrt_famprino_stp",request.getSession())%>';
this.RTDown=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDown","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDown","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":78,"x":412,"y":-63});
this.RTDown.m_cID='<%=JSPLib.cmdHash("routine,arrt_famgetdgn",request.getSession())%>';
this.RTChecks=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_check_sid",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChecks","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChecks","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_check_sid","target":"","type":"SPLinker","w":120,"x":521,"y":-62});
this.RTChecks.m_cID='<%=JSPLib.cmdHash("routine,arfn_check_sid",request.getSession())%>';
this.Box31=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box31","groupName":"","h":90,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box31","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":237,"x":281,"y":79,"zindex":"12"});
this.Label32=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32,false,true)%>","type":"Label","w":134,"x":312,"y":86,"zindex":"13"});
this.certSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default certSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_certSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"certSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":466,"y":86,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.certNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default certNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_certNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"certNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":491,"y":86,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.chkClose=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkClose","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"Ne(this.flgnew.Value(),'S')","init":"","init_par":"N","label_text":"Chiusura Straordinaria","layer":false,"layout_steps_values":{},"name":"chkClose","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"false","w":211,"x":442,"y":221,"zindex":"15"});
this.chkClose.Value('<%=chkClose%>');
this.AggiornaDatiADE=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_AggiornaDatiADE","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"AggiornaDatiADE","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":120,"x":882,"y":51});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":390,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
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
<%if(request.getAttribute("pg_faminvio_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_faminvio_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_faminvio_Static.call(window.<%=idPortlet%>);
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
window.<%=idPortlet%>.AggiornaDatiADE.setParms();
window.<%=idPortlet%>.mese.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_faminvio',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_faminvio');
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
sp.endPage("pg_faminvio");
}%>
<%! public String getJSPUID() { return "2363851772"; } %>