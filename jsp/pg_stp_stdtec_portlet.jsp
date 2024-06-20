<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Stampa Standard Tecnici '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);\n  if(this.ambito.Value()=='P') {\n    this.lblTipoPDF.Hide()\n    this.tipopdf.Hide()\n    this.Label_data_reg.Hide()\n    this.w_DaDatReg.Hide()\n    this.Calendario_dadata_reg.Hide()\n    this.w_ADatReg.Hide()\n    this.Calendario_adata_reg.Hide()\n    this.Box_data_reg.Hide()\n  }  \n  this.tiporep_onChange()\n  this.getTitlePortlet().AppendButton({\n      id:\"Stampa\",\n      title:FormatMsg('Stampa'),\n      tooltip:FormatMsg('Stampa Standard Tecnici'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n      action:'javascript:' + this.formid +'.btnExec_Click()'\n   },1);       \n}\n\nfunction tiporep_onChange(){\n  if(this.tiporep.Value()=='R') {\n    this.w_daRapporto.Show()\n    this.LinkZoom_daRapporto.Show()\n    this.Textbox_desrap1.Show()\n    this.w_aRapporto.Show()\n    this.LinkZoom_aRapporto.Show()\n    this.Textbox_desrap2.Show()\n    this.Textbox_daCodCli.Hide()\n    this.LinkZoom_daCodCli.Hide()\n    this.Textbox_daragsoc.Hide()\n    this.Textbox_aCodCli.Hide()\n    this.LinkZoom_aCodCli.Hide()\n    this.Textbox_aragsoc.Hide()    \n  } else {  \n    this.Textbox_daCodCli.Show()\n    this.LinkZoom_daCodCli.Show()\n    this.Textbox_daragsoc.Show()\n    this.Textbox_aCodCli.Show()\n    this.LinkZoom_aCodCli.Show()\n    this.Textbox_aragsoc.Show()    \n    this.w_daRapporto.Hide()\n    this.LinkZoom_daRapporto.Hide()\n    this.Textbox_desrap1.Hide()\n    this.w_aRapporto.Hide()\n    this.LinkZoom_aRapporto.Hide()\n    this.Textbox_desrap2.Hide()\n  }  \n}\n\nfunction tipopdf_onChange(){\n  if(this.tipopdf.Value()=='PDF') {\n    this.Label_data_ope.Show()\n    this.w_DaDatOpe.Show()\n    this.Calendario_dadata_ope.Show()\n    this.w_ADatOpe.Show()\n    this.Calendario_adata_ope.Show()\n    this.Box_data_ope.Show()  \n    \n  } else {\n    this.Label_data_ope.Hide()\n    this.w_DaDatOpe.Hide()\n    this.Calendario_dadata_ope.Hide()\n    this.w_ADatOpe.Hide()\n    this.Calendario_adata_ope.Hide()\n    this.Box_data_ope.Hide()    \n  }  \n}\n  \nfunction btnExec_Click() {\n  this.PortletLogs.Start();  \n  if(this.tiporep.Value()=='R'){\n\u002f\u002f     this.RTReportRAP.Link()    \n    this.RTReport.Servlet('arrt_stp_stdtec_rap_new') \n    this.RTReport.Parameters('pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+\",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daRapporto=w_daRapporto,w_aRapporto=w_aRapporto,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip\")  \n  }  \n  if(this.tiporep.Value()=='O'){\n    \u002f\u002fthis.RTReport.Servlet('arrt_stp_stdtec_new') \n    if(this.gTipInter.Value()=='46' || this.gTipInter.Value()=='81') {\n      this.RTReport.Servlet('arrt_stp_stdtec_new_mt')       \n    } else {  \n      \u002f\u002fthis.RTReport.Servlet('arrt_stp_stdtec_new_mc') \n      this.RTReport.Servlet('arrt_stp_stdtec_new')       \n    }  \n    this.RTReport.Parameters('pTipo=O,pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+\",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip\")      \n  }  \n  if(this.tiporep.Value()=='F'){\n    this.RTReport.Servlet('arrt_stp_stdtec_new') \n    \u002f\u002fthis.RTReport.Servlet('arrt_stp_stdtec_new_mc') \n    this.RTReport.Parameters('pTipo=F,pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+\",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip\")      \n  }  \n  if(this.tiporep.Value()=='L'){\n    this.RTReport.Servlet('arrt_stp_stdtec_tit_new') \n    this.RTReport.Parameters('pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+\",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip\")        \n  }  \n  this.RTReport.Link()  \n}  \n\nfunction RTReport_Result(result){\n   this.PortletLogs.Start();     \n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Stampa Standard Tecnici","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lblTipoPDF }}{{ @tipopdf }}{{ @pLog }}{{ @Label_data_ope }}{{ @w_DaDatOpe }}{{ @Calendario_dadata_ope }}{{ @w_ADatOpe }}{{ @pMsg }}{{ @Calendario_adata_ope }}{{ @Label_data_reg }}{{ @w_DaDatReg }}{{ @Calendario_dadata_reg }}{{ @w_ADatReg }}{{ @Calendario_adata_reg }}{{ @lblTipoRep }}{{ @tiporep }}{{ @Textbox_daCodCli }}{{ @LinkZoom_daCodCli }}{{ @Textbox_daragsoc }}{{ @Textbox_aCodCli }}{{ @LinkZoom_aCodCli }}{{ @Textbox_aragsoc }}{{ @w_daRapporto }}{{ @LinkZoom_daRapporto }}{{ @Textbox_desrap1 }}{{ @w_aRapporto }}{{ @LinkZoom_aRapporto }}{{ @Textbox_desrap2 }}{{ @w_daCodDip }}{{ @LinkZoom17 }}{{ @descage1 }}{{ @Box_data_ope }}{{ @w_aCodDip }}{{ @LinkZoom17_Copy }}{{ @descage2 }}{{ @Box_data_reg }}{{ @iPrint }}{{ @lblTipoPDF }}{{ @tipopdf }}{{ @Label_data_ope }}{{ @w_DaDatOpe }}{{ @Calendario_dadata_ope }}{{ @w_ADatOpe }}{{ @Calendario_adata_ope }}{{ @Label_data_reg }}{{ @w_DaDatReg }}{{ @Calendario_dadata_reg }}{{ @w_ADatReg }}{{ @Calendario_adata_reg }}{{ @lblTipoRep }}{{ @tiporep }}{{ @Textbox_daCodCli }}{{ @LinkZoom_daCodCli }}{{ @Textbox_daragsoc }}{{ @Textbox_aCodCli }}{{ @LinkZoom_aCodCli }}{{ @Textbox_aragsoc }}{{ @w_daRapporto }}{{ @LinkZoom_daRapporto }}{{ @Textbox_desrap1 }}{{ @w_aRapporto }}{{ @LinkZoom_aRapporto }}{{ @Textbox_desrap2 }}{{ @w_daCodDip }}{{ @LinkZoom17 }}{{ @descage1 }}{{ @Box_data_ope }}{{ @w_aCodDip }}{{ @LinkZoom17_Copy }}{{ @descage2 }}{{ @Box_data_reg }}{{ @iPrint }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"570","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @descage1 }} \n{{ @tiporep }} \n{{ @lblTipoRep }} \n{{ @tipopdf }} \n \n{{ @tiporep{{ @lblTipoRep{{ @w_aCodDip }} \n{{ @descage1 \n \n }} \n{{ @LinkZoom17 }} \n{{ @w_daCodDip }} \n{{ @descage2 }} \n{{ @LinkZoom17_Copy }} \n{{ @Textbox_desrap2 }} \n{{ @Textbox_desrap1 }} \n{{ @LinkZoom_aRapporto }} \n{{ @w_aRapporto }} \n{{ @LinkZoom_daRapporto }} \n{{ @w_daRapporto }} \n }} \n }} \n{{ @Textbox_aragsoc }} \n{{ @Textbox_daragsoc }} \n{{ @LinkZoom_aCodCli }} \n{{ @Textbox_aCodCli }} \n{{ @LinkZoom_daCodCli }} \n{{ @Textbox_daCodCli }} \n{{ @tipopdf{{ @lblTipoPDF }} \n }} \n \n\n\n{{ @iPrint }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @Calendario_dadata_reg }}\n{{ @Calendario_adata_reg }}\n{{ @w_ADatReg }}\n{{ @w_DaDatReg }}\n{{ @Box_data_reg }}\n{{ @Label_data_reg }}\n{{ @Label_data_ope }}\n{{ @Calendario_adata_ope }}\n{{ @w_ADatOpe }}\n\n{{ @Calendario_dadata_ope }}\n\n{{ @w_DaDatOpe }}\n\n\n{{ @Box_data_ope }}\n\n\n\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"600","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"570\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"540","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipoPDF","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo PDF:","w":"88","wireframe_props":"align,value,n_col","x":"94","y":"5","zindex":"28","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"540","wireframe_props":"","x":"0","y":"490","zindex":"3","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"PDF","layer":"false","layout_steps_values":"{}","name":"tipopdf","page":"1","picture":"","rapp":"","sequence":"3","spuid":"","tabindex":"","textlist":"PDF Standard,PDF per Conservazione","type":"Combobox","typevar":"character","valuelist":"PDF,PDFA1B","visible":"true","w":"257","wireframe_props":"name,textlist","x":"187","y":"5","zindex":"27","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_ope","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Operazione","w":"123","wireframe_props":"align,value,n_col","x":"114","y":"31","zindex":"22","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_DaDatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"Da","rapp":"","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"134","y":"59","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_ope","page":"1","popup":"true","rapp":"","return_input":"w_DaDatOpe","sequence":"6","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"199","y":"59","zindex":"19","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_ADatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"A","rapp":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"134","y":"102","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_ope","page":"1","popup":"true","rapp":"","return_input":"w_ADatOpe","sequence":"8","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"199","y":"102","zindex":"6","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_data_reg","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Registrazione","w":"123","wireframe_props":"align,value,n_col","x":"265","y":"31","zindex":"23","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_DaDatReg","page":"1","password":"","picker":"","picture":"","placeholder":"Da","rapp":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"287","y":"60","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_dadata_reg","page":"1","popup":"true","rapp":"","return_input":"w_DaDatReg","sequence":"11","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"354","y":"60","zindex":"6","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_ADatReg","page":"1","password":"","picker":"","picture":"","placeholder":"A","rapp":"","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"60","wireframe_props":"name","x":"287","y":"102","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario_adata_reg","page":"1","popup":"true","rapp":"","return_input":"w_ADatReg","sequence":"13","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"354","y":"103","zindex":"6","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipoRep","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Stampa:","w":"99","wireframe_props":"align,value,n_col","x":"83","y":"149","zindex":"30","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"R","layer":"false","layout_steps_values":"{}","name":"tiporep","page":"1","picture":"","rapp":"","sequence":"15","spuid":"","tabindex":"","textlist":"Rapporti,Operazioni,Frazionate,Legami","type":"Combobox","typevar":"character","valuelist":"R,O,F,L","visible":"true","w":"253","wireframe_props":"name,textlist","x":"187","y":"148","zindex":"29","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_daCodCli","page":"1","password":"","picker":"","picture":"","placeholder":"Da Soggetto","rapp":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"4","y":"178","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"Textbox_daCodCli,Textbox_daragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_daCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"17","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"129","y":"178","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_daragsoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"373","wireframe_props":"name","x":"161","y":"178","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"Textbox_aCodCli","page":"1","password":"","picker":"","picture":"","placeholder":"A Soggetto","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"4","y":"205","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"Textbox_aCodCli,Textbox_aragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom_aCodCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"20","servlet":"","spuid":"","suggest":"true","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"129","y":"205","zindex":"5","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_aragsoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"21","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"374","wireframe_props":"name","x":"161","y":"205","zerofilling":"false","zindex":"6","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"25","name":"w_daRapporto","page":"1","password":"","picker":"","picture":"","placeholder":"Da Rapporto","rapp":"","readonly":"false","scroll":"false","sequence":"22","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"203","wireframe_props":"name","x":"4","y":"232","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"w_daRapporto,Textbox_desrap1","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_daRapporto","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_daRapporto","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"23","servlet":"","spuid":"","suggest":"true","table":"anarapbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"212","y":"232","zindex":"2","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_desrap1","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"24","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"288","wireframe_props":"name","x":"245","y":"232","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"25","name":"w_aRapporto","page":"1","password":"","picker":"","picture":"","placeholder":"A Rapporto","rapp":"","readonly":"false","scroll":"false","sequence":"25","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"203","wireframe_props":"name","x":"4","y":"259","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"w_aRapporto,Textbox_desrap2","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_aRapporto","linkedUsing":"","looselylinked":"","n_criteria":"1","name":"LinkZoom_aRapporto","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"26","servlet":"","spuid":"","suggest":"true","table":"anarapbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"212","y":"259","zindex":"5","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"Textbox_desrap2","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"27","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"288","wireframe_props":"name","x":"245","y":"259","zerofilling":"false","zindex":"6","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_daCodDip","page":"1","password":"","picker":"","picture":"","placeholder":"Da Dipendenza","rapp":"","readonly":"false","scroll":"false","sequence":"28","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"119","wireframe_props":"name","x":"4","y":"286","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"w_daCodDip,descage1","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_daCodDip","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"29","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"128","y":"286","zindex":"","zone":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descage1","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"30","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"378","wireframe_props":"name","x":"153","y":"286","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_ope","page":"1","rapp":"","sequence":"31","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"123","wireframe_props":"","x":"114","y":"30","zindex":"2","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_aCodDip","page":"1","password":"","picker":"","picture":"","placeholder":"A Dipendenza","rapp":"","readonly":"false","scroll":"false","sequence":"32","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"119","wireframe_props":"name","x":"4","y":"313","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"w_aCodDip,descage2","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"w_aCodDip","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"33","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"128","y":"313","zindex":"","zone":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descage2","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"34","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"378","wireframe_props":"name","x":"153","y":"313","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"allowedentities":"arrt_stp_stdtec_rap_new","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTReportRAP","offline":"false","page":"1","parms":"pAUI=ambito,pPDF=tipopdf,w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daRapporto=w_daRapporto,w_aRapporto=w_aRapporto,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"35","servlet":"arrt_stp_stdtec_rap_new","target":"iPrint","type":"SPLinker","w":"197","x":"552","y":"-69"},{"anchor":"","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"111","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box_data_reg","page":"1","rapp":"","sequence":"36","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"123","wireframe_props":"","x":"265","y":"30","zindex":"2","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ambito","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"197","x":"562","y":"213"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"90","hide":"","layer":"","layout_steps_values":"{}","name":"ambito","page":"1","rapp":"","sequence":"38","spuid":"","type":"Note","value":"ambito definisce la provenienza della chiamata: \nD = Definitivo\u002fAUI, \nP = Provvisorio","w":"197","wireframe_props":"","x":"557","y":"88","zindex":"25","zone":""},{"anchor":"","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"39","spuid":"","type":"Iframe","w":"540","wireframe_props":"","x":"0","y":"338","zindex":"26","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTReportOpeFrz","offline":"false","page":"1","parms":"pTipo=tipo,pAUI=ambito,pPDF=tipopdf,w_DaDatOpe=w_DaDatOpe,w_ADatope=w_ADatope,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_DaCodCli=Textbox_daCodCli,w_ACodCli=Textbox_aCodCli,w_DaCodDip=w_DaCodDip,w_ACodDip=w_ACodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"40","servlet":"","target":"iPrint","type":"SPLinker","w":"197","x":"552","y":"-42"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"tipo","page":"1","reactive":"","sequence":"41","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"563","y":"240"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTReport","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"42","servlet":"","target":"iPrint","type":"SPLinker","w":"197","x":"553","y":"-16"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gTipInter","page":"1","reactive":"","sequence":"43","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"564","y":"26"}]%>
<%/*Description:Stampa Standard Tecnici*/%>
<%/*ParamsRequest:ambito*/%>
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
window.pg_stp_stdtec_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof tiporep_onChange !='undefined')this.tiporep_onChange=tiporep_onChange;
if(typeof tipopdf_onChange !='undefined')this.tipopdf_onChange=tipopdf_onChange;
if(typeof btnExec_Click !='undefined')this.btnExec_Click=btnExec_Click;
if(typeof RTReport_Result !='undefined')this.RTReport_Result=RTReport_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom_daCodCli.addObserverFixedVars();
this.LinkZoom_aCodCli.addObserverFixedVars();
this.LinkZoom_daRapporto.addObserverFixedVars();
this.LinkZoom_aRapporto.addObserverFixedVars();
this.LinkZoom17.addObserverFixedVars();
this.LinkZoom17_Copy.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Stampa Standard Tecnici '+iif(this.ambito.Value()=='D','(A.U.I.)','(Provvisorio)'),true);
  if(this.ambito.Value()=='P') {
    this.lblTipoPDF.Hide()
    this.tipopdf.Hide()
    this.Label_data_reg.Hide()
    this.w_DaDatReg.Hide()
    this.Calendario_dadata_reg.Hide()
    this.w_ADatReg.Hide()
    this.Calendario_adata_reg.Hide()
    this.Box_data_reg.Hide()
  }  
  this.tiporep_onChange()
  this.getTitlePortlet().AppendButton({
      id:"Stampa",
      title:FormatMsg('Stampa'),
      tooltip:FormatMsg('Stampa Standard Tecnici'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
      action:'javascript:' + this.formid +'.btnExec_Click()'
   },1);       
}
function tiporep_onChange(){
  if(this.tiporep.Value()=='R') {
    this.w_daRapporto.Show()
    this.LinkZoom_daRapporto.Show()
    this.Textbox_desrap1.Show()
    this.w_aRapporto.Show()
    this.LinkZoom_aRapporto.Show()
    this.Textbox_desrap2.Show()
    this.Textbox_daCodCli.Hide()
    this.LinkZoom_daCodCli.Hide()
    this.Textbox_daragsoc.Hide()
    this.Textbox_aCodCli.Hide()
    this.LinkZoom_aCodCli.Hide()
    this.Textbox_aragsoc.Hide()    
  } else {  
    this.Textbox_daCodCli.Show()
    this.LinkZoom_daCodCli.Show()
    this.Textbox_daragsoc.Show()
    this.Textbox_aCodCli.Show()
    this.LinkZoom_aCodCli.Show()
    this.Textbox_aragsoc.Show()    
    this.w_daRapporto.Hide()
    this.LinkZoom_daRapporto.Hide()
    this.Textbox_desrap1.Hide()
    this.w_aRapporto.Hide()
    this.LinkZoom_aRapporto.Hide()
    this.Textbox_desrap2.Hide()
  }  
}
function tipopdf_onChange(){
  if(this.tipopdf.Value()=='PDF') {
    this.Label_data_ope.Show()
    this.w_DaDatOpe.Show()
    this.Calendario_dadata_ope.Show()
    this.w_ADatOpe.Show()
    this.Calendario_adata_ope.Show()
    this.Box_data_ope.Show()  
    
  } else {
    this.Label_data_ope.Hide()
    this.w_DaDatOpe.Hide()
    this.Calendario_dadata_ope.Hide()
    this.w_ADatOpe.Hide()
    this.Calendario_adata_ope.Hide()
    this.Box_data_ope.Hide()    
  }  
}
  
function btnExec_Click() {
  this.PortletLogs.Start();  
  if(this.tiporep.Value()=='R'){
//     this.RTReportRAP.Link()    
    this.RTReport.Servlet('arrt_stp_stdtec_rap_new') 
    this.RTReport.Parameters('pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daRapporto=w_daRapporto,w_aRapporto=w_aRapporto,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip")  
  }  
  if(this.tiporep.Value()=='O'){
    //this.RTReport.Servlet('arrt_stp_stdtec_new') 
    if(this.gTipInter.Value()=='46' || this.gTipInter.Value()=='81') {
      this.RTReport.Servlet('arrt_stp_stdtec_new_mt')       
    } else {  
      //this.RTReport.Servlet('arrt_stp_stdtec_new_mc') 
      this.RTReport.Servlet('arrt_stp_stdtec_new')       
    }  
    this.RTReport.Parameters('pTipo=O,pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip")      
  }  
  if(this.tiporep.Value()=='F'){
    this.RTReport.Servlet('arrt_stp_stdtec_new') 
    //this.RTReport.Servlet('arrt_stp_stdtec_new_mc') 
    this.RTReport.Parameters('pTipo=F,pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip")      
  }  
  if(this.tiporep.Value()=='L'){
    this.RTReport.Servlet('arrt_stp_stdtec_tit_new') 
    this.RTReport.Parameters('pAUI='+this.ambito.Value()+',pPDF='+this.tipopdf.Value()+",w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daCodCli=Textbox_daCodCli,w_aCodCli=Textbox_aCodCli,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip")        
  }  
  this.RTReport.Link()  
}  
function RTReport_Result(result){
   this.PortletLogs.Start();     
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
.pg_stp_stdtec_container {
  height:100%;
  overflow:auto;
}
.pg_stp_stdtec_title_container {
  margin: auto;
}
.pg_stp_stdtec_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1024px;
  min-width:600px;
  height:100%;
}
.pg_stp_stdtec_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_stp_stdtec_portlet > .lblTipoPDF_ctrl {
  box-sizing:border-box;
  z-index:28;
  position:absolute;
  display:inline-block;
  top:5px;
  left:94px;
  left:17.407408%;
  right:358px;
  right:66.296295%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_stdtec_portlet > .lblTipoPDF_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_stdtec_portlet > .lblTipoPDF_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stp_stdtec_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:490px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_stp_stdtec_portlet > .tipopdf_ctrl {
  box-sizing:border-box;
  z-index:27;
  position:absolute;
  display:inline-block;
  top:5px;
  left:187px;
  left:34.62963%;
  right:96px;
  right:17.777779%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Label_data_ope_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:31px;
  left:114px;
  left:21.11111%;
  right:303px;
  right:56.11111%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_stp_stdtec_portlet > .Label_data_ope_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stp_stdtec_portlet > .Label_data_ope_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_stdtec_portlet > .w_DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:59px;
  left:134px;
  left:24.814816%;
  right:346px;
  right:64.07407%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_DaDatOpe_ctrl {
}
.pg_stp_stdtec_portlet > .w_DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Calendario_dadata_ope_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:59px;
  left:199px;
  left:36.851852%;
  right:321px;
  right:59.444443%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:102px;
  left:134px;
  left:24.814816%;
  right:346px;
  right:64.07407%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_ADatOpe_ctrl {
}
.pg_stp_stdtec_portlet > .w_ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Calendario_adata_ope_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:102px;
  left:199px;
  left:36.851852%;
  right:321px;
  right:59.444443%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Label_data_reg_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:31px;
  left:265px;
  left:49.074074%;
  right:152px;
  right:28.148148%;
  width:auto;
  height:auto;
  min-height:22px;
}
.pg_stp_stdtec_portlet > .Label_data_reg_ctrl {
  height:auto;
  min-height:22px;
}
.pg_stp_stdtec_portlet > .Label_data_reg_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_stp_stdtec_portlet > .w_DaDatReg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:60px;
  left:287px;
  left:53.148148%;
  right:193px;
  right:35.74074%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_DaDatReg_ctrl {
}
.pg_stp_stdtec_portlet > .w_DaDatReg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Calendario_dadata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:60px;
  left:354px;
  left:65.55556%;
  right:166px;
  right:30.74074%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_ADatReg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:102px;
  left:287px;
  left:53.148148%;
  right:193px;
  right:35.74074%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_ADatReg_ctrl {
}
.pg_stp_stdtec_portlet > .w_ADatReg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Calendario_adata_reg_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:103px;
  left:354px;
  left:65.55556%;
  right:166px;
  right:30.74074%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .lblTipoRep_ctrl {
  box-sizing:border-box;
  z-index:30;
  position:absolute;
  display:inline-block;
  top:149px;
  left:83px;
  left:15.37037%;
  right:358px;
  right:66.296295%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_stp_stdtec_portlet > .lblTipoRep_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stp_stdtec_portlet > .lblTipoRep_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stp_stdtec_portlet > .tiporep_ctrl {
  box-sizing:border-box;
  z-index:29;
  position:absolute;
  display:inline-block;
  top:148px;
  left:187px;
  left:34.62963%;
  right:100px;
  right:18.518518%;
  width:auto;
  height:22px;
}
.pg_stp_stdtec_portlet > .Textbox_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:178px;
  left:4px;
  left:0.7407407%;
  right:416px;
  right:77.03704%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_daCodCli_ctrl {
}
.pg_stp_stdtec_portlet > .Textbox_daCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .LinkZoom_daCodCli_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:178px;
  left:129px;
  left:23.88889%;
  right:391px;
  right:72.40741%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_daragsoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:178px;
  left:161px;
  left:29.814816%;
  right:6px;
  right:1.1111112%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_daragsoc_ctrl {
}
.pg_stp_stdtec_portlet > .Textbox_daragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Textbox_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:205px;
  left:4px;
  left:0.7407407%;
  right:416px;
  right:77.03704%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_aCodCli_ctrl {
}
.pg_stp_stdtec_portlet > .Textbox_aCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .LinkZoom_aCodCli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:205px;
  left:129px;
  left:23.88889%;
  right:391px;
  right:72.40741%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_aragsoc_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:205px;
  left:161px;
  left:29.814816%;
  right:5px;
  right:0.9259259%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_aragsoc_ctrl {
}
.pg_stp_stdtec_portlet > .Textbox_aragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .w_daRapporto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:232px;
  left:4px;
  left:0.7407407%;
  right:333px;
  right:61.666668%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_daRapporto_ctrl {
}
.pg_stp_stdtec_portlet > .w_daRapporto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .LinkZoom_daRapporto_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:232px;
  left:212px;
  left:39.25926%;
  right:308px;
  right:57.037037%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_desrap1_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:232px;
  left:245px;
  left:45.37037%;
  right:7px;
  right:1.2962962%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_desrap1_ctrl {
}
.pg_stp_stdtec_portlet > .Textbox_desrap1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .w_aRapporto_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:259px;
  left:4px;
  left:0.7407407%;
  right:333px;
  right:61.666668%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_aRapporto_ctrl {
}
.pg_stp_stdtec_portlet > .w_aRapporto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .LinkZoom_aRapporto_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:259px;
  left:212px;
  left:39.25926%;
  right:308px;
  right:57.037037%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_desrap2_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:259px;
  left:245px;
  left:45.37037%;
  right:7px;
  right:1.2962962%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .Textbox_desrap2_ctrl {
}
.pg_stp_stdtec_portlet > .Textbox_desrap2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .w_daCodDip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:286px;
  left:4px;
  left:0.7407407%;
  right:417px;
  right:77.22222%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_daCodDip_ctrl {
}
.pg_stp_stdtec_portlet > .w_daCodDip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:286px;
  left:128px;
  left:23.703703%;
  right:392px;
  right:72.59259%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .descage1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:286px;
  left:153px;
  left:28.333334%;
  right:9px;
  right:1.6666666%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .descage1_ctrl {
}
.pg_stp_stdtec_portlet > .descage1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Box_data_ope_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:30px;
  left:114px;
  left:21.11111%;
  right:303px;
  right:56.11111%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stp_stdtec_portlet > .Box_data_ope_ctrl {
  height:111px;
}
.pg_stp_stdtec_portlet > .Box_data_ope_ctrl > .box_content {
  height:100%;
}
.pg_stp_stdtec_portlet > .Box_data_ope_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stp_stdtec_portlet > .w_aCodDip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:313px;
  left:4px;
  left:0.7407407%;
  right:417px;
  right:77.22222%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .w_aCodDip_ctrl {
}
.pg_stp_stdtec_portlet > .w_aCodDip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .LinkZoom17_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:313px;
  left:128px;
  left:23.703703%;
  right:392px;
  right:72.59259%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .descage2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:313px;
  left:153px;
  left:28.333334%;
  right:9px;
  right:1.6666666%;
  width:auto;
  height:20px;
}
.pg_stp_stdtec_portlet > .descage2_ctrl {
}
.pg_stp_stdtec_portlet > .descage2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_stp_stdtec_portlet > .Box_data_reg_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:30px;
  left:265px;
  left:49.074074%;
  right:152px;
  right:28.148148%;
  width:auto;
  height:auto;
  min-height:111px;
  display:flex;
  flex-direction:column;
}
.pg_stp_stdtec_portlet > .Box_data_reg_ctrl {
  height:111px;
}
.pg_stp_stdtec_portlet > .Box_data_reg_ctrl > .box_content {
  height:100%;
}
.pg_stp_stdtec_portlet > .Box_data_reg_ctrl {
  min-height:111px;
  border-color:#CBCBCB;
}
.pg_stp_stdtec_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:26;
  position:absolute;
  display:inline-block;
  top:338px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:150px;
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
 String def="[{\"h\":\"570\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"540\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo PDF:\",\"w\":\"88\",\"x\":\"94\",\"y\":\"5\",\"zindex\":\"28\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"540\",\"x\":\"0\",\"y\":\"490\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipopdf\",\"page\":\"1\",\"textlist\":\"PDF Standard,PDF per Conservazione\",\"type\":\"Combobox\",\"w\":\"257\",\"x\":\"187\",\"y\":\"5\",\"zindex\":\"27\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_ope\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Operazione\",\"w\":\"123\",\"x\":\"114\",\"y\":\"31\",\"zindex\":\"22\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"134\",\"y\":\"59\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_ope\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"199\",\"y\":\"59\",\"zindex\":\"19\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"134\",\"y\":\"102\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_ope\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"199\",\"y\":\"102\",\"zindex\":\"6\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_data_reg\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Registrazione\",\"w\":\"123\",\"x\":\"265\",\"y\":\"31\",\"zindex\":\"23\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_DaDatReg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"287\",\"y\":\"60\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_dadata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"354\",\"y\":\"60\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_ADatReg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"287\",\"y\":\"102\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_adata_reg\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"354\",\"y\":\"103\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTipoRep\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Stampa:\",\"w\":\"99\",\"x\":\"83\",\"y\":\"149\",\"zindex\":\"30\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"tiporep\",\"page\":\"1\",\"textlist\":\"Rapporti,Operazioni,Frazionate,Legami\",\"type\":\"Combobox\",\"w\":\"253\",\"x\":\"187\",\"y\":\"148\",\"zindex\":\"29\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"4\",\"y\":\"178\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"129\",\"y\":\"178\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_daragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"373\",\"x\":\"161\",\"y\":\"178\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"4\",\"y\":\"205\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aCodCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"129\",\"y\":\"205\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_aragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"374\",\"x\":\"161\",\"y\":\"205\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_daRapporto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"203\",\"x\":\"4\",\"y\":\"232\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_daRapporto\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"212\",\"y\":\"232\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_desrap1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"288\",\"x\":\"245\",\"y\":\"232\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_aRapporto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"203\",\"x\":\"4\",\"y\":\"259\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_aRapporto\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"212\",\"y\":\"259\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_desrap2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"288\",\"x\":\"245\",\"y\":\"259\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_daCodDip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"119\",\"x\":\"4\",\"y\":\"286\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom17\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"128\",\"y\":\"286\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descage1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"378\",\"x\":\"153\",\"y\":\"286\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_ope\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"114\",\"y\":\"30\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_aCodDip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"119\",\"x\":\"4\",\"y\":\"313\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom17_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"128\",\"y\":\"313\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descage2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"378\",\"x\":\"153\",\"y\":\"313\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTReportRAP\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"552\",\"y\":\"-69\"},{\"anchor\":\"\",\"h\":\"111\",\"layout_steps_values\":{},\"name\":\"Box_data_reg\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"123\",\"x\":\"265\",\"y\":\"30\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"ambito\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"197\",\"x\":\"562\",\"y\":\"213\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"ambito\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"ambito definisce la provenienza della chiamata: \\nD = Definitivo\\u002fAUI, \\nP = Provvisorio\",\"w\":\"197\",\"x\":\"557\",\"y\":\"88\",\"zindex\":\"25\"},{\"anchor\":\"\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"540\",\"x\":\"0\",\"y\":\"338\",\"zindex\":\"26\"},{\"h\":\"20\",\"name\":\"RTReportOpeFrz\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"552\",\"y\":\"-42\"},{\"h\":\"20\",\"name\":\"tipo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"563\",\"y\":\"240\"},{\"h\":\"20\",\"name\":\"RTReport\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"197\",\"x\":\"553\",\"y\":\"-16\"},{\"h\":\"20\",\"name\":\"gTipInter\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"564\",\"y\":\"26\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stp_stdtec","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stp_stdtec_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stp_stdtec','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblTipoPDF= "Tipo PDF:";
String tipopdf="PDF";
String Label_data_ope= "Data Operazione";
java.sql.Date w_DaDatOpe= JSPLib.NullDate();
if(request.getAttribute("pg_stp_stdtec_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_stp_stdtec_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
java.sql.Date w_ADatOpe= JSPLib.NullDate();
String Label_data_reg= "Data Registrazione";
java.sql.Date w_DaDatReg= JSPLib.NullDate();
java.sql.Date w_ADatReg= JSPLib.NullDate();
String lblTipoRep= "Tipo Stampa:";
String tiporep="R";
String Textbox_daCodCli= "";
if(request.getAttribute("pg_stp_stdtec_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Textbox_daragsoc= "";
String Textbox_aCodCli= "";
String Textbox_aragsoc= "";
String w_daRapporto= "";
String Textbox_desrap1= "";
String w_aRapporto= "";
String Textbox_desrap2= "";
String w_daCodDip= "";
String descage1= "";
String w_aCodDip= "";
String descage2= "";
String ambito=JSPLib.translateXSS(sp.getParameter("ambito",""));
String tipo= "";
String gTipInter=sp.getGlobal("gTipInter","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stp_stdtec_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stp_stdtec_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stp_stdtec_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stp_stdtec','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblTipoPDF'  formid='<%=idPortlet%>' ps-name='lblTipoPDF'    class='label lblTipoPDF_ctrl'><div id='<%=idPortlet%>_lblTipoPDFtbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo PDF:")%></div></span>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<select id='<%=idPortlet%>_tipopdf' name='tipopdf' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label_data_ope'  formid='<%=idPortlet%>' ps-name='Label_data_ope'    class='label Label_data_ope_ctrl'><div id='<%=idPortlet%>_Label_data_opetbl' style='width:100%;'><%=JSPLib.ToHTML("Data Operazione")%></div></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_DaDatOpe_wrp'><input id='<%=idPortlet%>_w_DaDatOpe' name='w_DaDatOpe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_DaDatOpe' placeholder=' '/>
<label for=<%=idPortlet%>_w_DaDatOpe>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_ope' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_ope.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_ADatOpe_wrp'><input id='<%=idPortlet%>_w_ADatOpe' name='w_ADatOpe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_ADatOpe' placeholder=' '/>
<label for=<%=idPortlet%>_w_ADatOpe>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_ope' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_ope.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label_data_reg'  formid='<%=idPortlet%>' ps-name='Label_data_reg'    class='label Label_data_reg_ctrl'><div id='<%=idPortlet%>_Label_data_regtbl' style='width:100%;'><%=JSPLib.ToHTML("Data Registrazione")%></div></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_DaDatReg_wrp'><input id='<%=idPortlet%>_w_DaDatReg' name='w_DaDatReg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_DaDatReg' placeholder=' '/>
<label for=<%=idPortlet%>_w_DaDatReg>Da</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_dadata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_dadata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_ADatReg_wrp'><input id='<%=idPortlet%>_w_ADatReg' name='w_ADatReg' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_ADatReg' placeholder=' '/>
<label for=<%=idPortlet%>_w_ADatReg>A</label></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_adata_reg' class='calendar' onclick='window.<%=idPortlet%>.Calendario_adata_reg.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_lblTipoRep'  formid='<%=idPortlet%>' ps-name='lblTipoRep'    class='label lblTipoRep_ctrl'><div id='<%=idPortlet%>_lblTipoReptbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Stampa:")%></div></span>
<select id='<%=idPortlet%>_tiporep' name='tiporep' class='combobox' style=''></select>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_daCodCli_wrp'><input id='<%=idPortlet%>_Textbox_daCodCli' name='Textbox_daCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_daCodCli>Da Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_daragsoc_wrp'><input id='<%=idPortlet%>_Textbox_daragsoc' name='Textbox_daragsoc' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_daragsoc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_Textbox_aCodCli_wrp'><input id='<%=idPortlet%>_Textbox_aCodCli' name='Textbox_aCodCli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aCodCli' placeholder=' '/>
<label for=<%=idPortlet%>_Textbox_aCodCli>A Soggetto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aCodCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_aragsoc_wrp'><input id='<%=idPortlet%>_Textbox_aragsoc' name='Textbox_aragsoc' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_aragsoc' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_daRapporto_wrp'><input id='<%=idPortlet%>_w_daRapporto' name='w_daRapporto' type='text' maxlength='25' class='textbox' formid='<%=idPortlet%>' ps-name='w_daRapporto' placeholder=' '/>
<label for=<%=idPortlet%>_w_daRapporto>Da Rapporto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_daRapporto'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_desrap1_wrp'><input id='<%=idPortlet%>_Textbox_desrap1' name='Textbox_desrap1' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_desrap1' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_aRapporto_wrp'><input id='<%=idPortlet%>_w_aRapporto' name='w_aRapporto' type='text' maxlength='25' class='textbox' formid='<%=idPortlet%>' ps-name='w_aRapporto' placeholder=' '/>
<label for=<%=idPortlet%>_w_aRapporto>A Rapporto</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_aRapporto'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_desrap2_wrp'><input id='<%=idPortlet%>_Textbox_desrap2' name='Textbox_desrap2' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_desrap2' /></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_daCodDip_wrp'><input id='<%=idPortlet%>_w_daCodDip' name='w_daCodDip' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_daCodDip' placeholder=' '/>
<label for=<%=idPortlet%>_w_daCodDip>Da Dipendenza</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descage1_wrp'><input id='<%=idPortlet%>_descage1' name='descage1' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descage1' /></span>
<div id='<%=idPortlet%>_Box_data_ope' class='Box_data_ope_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_ope_td' class='box_content'></div>
</div>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_w_aCodDip_wrp'><input id='<%=idPortlet%>_w_aCodDip' name='w_aCodDip' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='w_aCodDip' placeholder=' '/>
<label for=<%=idPortlet%>_w_aCodDip>A Dipendenza</label></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descage2_wrp'><input id='<%=idPortlet%>_descage2' name='descage2' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descage2' /></span>
<div id='<%=idPortlet%>_Box_data_reg' class='Box_data_reg_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box_data_reg_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stp_stdtec');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
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
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa Standard Tecnici",true)+","+JSPLib.ToJSValue(sp.translate("Stampa Standard Tecnici"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stp_stdtec',["540"],["570"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"540","h":"570","title":"","layer":""}]);
this.lblTipoPDF=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipoPDF","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipoPDF","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipoPDF,false,true)%>","type":"Label","w":88,"x":94,"y":5,"zindex":"28"});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":540,"x":0,"y":490,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.tipopdf=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipopdf","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipopdf%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipopdf","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"PDF Standard,PDF per Conservazione","type":"Combobox","typevar":"character","valuelist":"PDF,PDFA1B","visible":true,"w":257,"x":187,"y":5,"zindex":"27"});
this.Label_data_ope=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_ope","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_ope","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_ope,false,true)%>","type":"Label","w":123,"x":114,"y":31,"zindex":"22"});
this.w_DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=w_DaDatOpe%>","w":60,"x":134,"y":59,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_dadata_ope=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_ope','Calendario_dadata_ope',199,59,20,20,'','','top-left(%)-right(%)','true','w_DaDatOpe',{});
this.w_ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=w_ADatOpe%>","w":60,"x":134,"y":102,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_ope=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_ope','Calendario_adata_ope',199,102,20,20,'','','top-left(%)-right(%)','true','w_ADatOpe',{});
this.Label_data_reg=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_data_reg","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_data_reg","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_data_reg,false,true)%>","type":"Label","w":123,"x":265,"y":31,"zindex":"23"});
this.w_DaDatReg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_DaDatReg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_DaDatReg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=w_DaDatReg%>","w":60,"x":287,"y":60,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_dadata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_dadata_reg','Calendario_dadata_reg',354,60,20,20,'','','top-left(%)-right(%)','true','w_DaDatReg',{});
this.w_ADatReg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_ADatReg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_ADatReg","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=w_ADatReg%>","w":60,"x":287,"y":102,"zerofilling":false,"zindex":"5","zoom":""});
this.Calendario_adata_reg=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_adata_reg','Calendario_adata_reg',354,103,20,20,'','','top-left(%)-right(%)','true','w_ADatReg',{});
this.lblTipoRep=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipoRep","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipoRep","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipoRep,false,true)%>","type":"Label","w":99,"x":83,"y":149,"zindex":"30"});
this.tiporep=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tiporep","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tiporep%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tiporep","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Rapporti,Operazioni,Frazionate,Legami","type":"Combobox","typevar":"character","valuelist":"R,O,F,L","visible":true,"w":253,"x":187,"y":148,"zindex":"29"});
this.Textbox_daCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_daCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daCodCli,false,true)%>","w":120,"x":4,"y":178,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_stdtec_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"Textbox_daCodCli,Textbox_daragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_stdtec_portlet.jspLinkZoom_daCodCli",request.getSession())%>","linkedField":"Textbox_daCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_daCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":20,"x":129,"y":178,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_daragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_daragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_daragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_daragsoc,false,true)%>","w":373,"x":161,"y":178,"zerofilling":false,"zindex":"3","zoom":""});
this.Textbox_aCodCli=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"Textbox_aCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aCodCli,false,true)%>","w":120,"x":4,"y":205,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_aCodCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aCodCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_stdtec_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"Textbox_aCodCli,Textbox_aragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_stdtec_portlet.jspLinkZoom_aCodCli",request.getSession())%>","linkedField":"Textbox_aCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_aCodCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":true,"table":"personbo","type":"LinkZoom","w":20,"x":129,"y":205,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_aragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_aragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_aragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_aragsoc,false,true)%>","w":374,"x":161,"y":205,"zerofilling":false,"zindex":"6","zoom":""});
this.w_daRapporto=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_daRapporto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"25","name":"w_daRapporto","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_daRapporto,false,true)%>","w":203,"x":4,"y":232,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom_daRapporto=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_daRapporto","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_stdtec_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"w_daRapporto,Textbox_desrap1","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_stdtec_portlet.jspLinkZoom_daRapporto",request.getSession())%>","linkedField":"w_daRapporto","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_daRapporto","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":true,"table":"anarapbo","type":"LinkZoom","w":20,"x":212,"y":232,"zindex":"2","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_desrap1=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_desrap1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_desrap1","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_desrap1,false,true)%>","w":288,"x":245,"y":232,"zerofilling":false,"zindex":"3","zoom":""});
this.w_aRapporto=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_aRapporto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"25","name":"w_aRapporto","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_aRapporto,false,true)%>","w":203,"x":4,"y":259,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_aRapporto=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_aRapporto","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_stdtec_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"w_aRapporto,Textbox_desrap2","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_stdtec_portlet.jspLinkZoom_aRapporto",request.getSession())%>","linkedField":"w_aRapporto","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_aRapporto","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":true,"table":"anarapbo","type":"LinkZoom","w":20,"x":212,"y":259,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Textbox_desrap2=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_desrap2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"Textbox_desrap2","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_desrap2,false,true)%>","w":288,"x":245,"y":259,"zerofilling":false,"zindex":"6","zoom":""});
this.w_daCodDip=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_daCodDip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_daCodDip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_daCodDip,false,true)%>","w":119,"x":4,"y":286,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom17=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_stdtec_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"w_daCodDip,descage1","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_stdtec_portlet.jspLinkZoom17",request.getSession())%>","linkedField":"w_daCodDip","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":128,"y":286,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descage1=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descage1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descage1","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descage1,false,true)%>","w":378,"x":153,"y":286,"zerofilling":false,"zindex":"1","zoom":""});
this.Box_data_ope=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_ope","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_ope","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":123,"x":114,"y":30,"zindex":"2"});
this.w_aCodDip=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_aCodDip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_aCodDip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_aCodDip,false,true)%>","w":119,"x":4,"y":313,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom17_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stp_stdtec_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"w_aCodDip,descage2","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stp_stdtec_portlet.jspLinkZoom17_Copy",request.getSession())%>","linkedField":"w_aCodDip","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":128,"y":313,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descage2=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descage2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descage2","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descage2,false,true)%>","w":378,"x":153,"y":313,"zerofilling":false,"zindex":"1","zoom":""});
this.RTReportRAP=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_stp_stdtec_rap_new",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTReportRAP","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTReportRAP","offline":false,"page":1,"parms":"pAUI=ambito,pPDF=tipopdf,w_DaDatOpe=w_DaDatOpe,w_ADatOpe=w_ADatOpe,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_daRapporto=w_daRapporto,w_aRapporto=w_aRapporto,w_daCodDip=w_daCodDip,w_aCodDip=w_aCodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_stp_stdtec_rap_new","target":"iPrint","type":"SPLinker","w":197,"x":552,"y":-69});
this.RTReportRAP.m_cID='<%=JSPLib.cmdHash("routine,arrt_stp_stdtec_rap_new",request.getSession())%>';
this.Box_data_reg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"#CBCBCB","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box_data_reg","groupName":"","h":111,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box_data_reg","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":123,"x":265,"y":30,"zindex":"2"});
this.ambito=new ZtVWeb._VC(this,'ambito',null,'character','<%=JSPLib.ToJSValue(ambito,false,true)%>',false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":540,"x":0,"y":338,"zindex":"26"});
this.RTReportOpeFrz=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTReportOpeFrz","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTReportOpeFrz","offline":false,"page":1,"parms":"pTipo=tipo,pAUI=ambito,pPDF=tipopdf,w_DaDatOpe=w_DaDatOpe,w_ADatope=w_ADatope,w_DaDatReg=w_DaDatReg,w_ADatReg=w_ADatReg,w_DaCodCli=Textbox_daCodCli,w_ACodCli=Textbox_aCodCli,w_DaCodDip=w_DaCodDip,w_ACodDip=w_ACodDip","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":197,"x":552,"y":-42});
this.RTReportOpeFrz.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.tipo=new ZtVWeb._VC(this,'tipo',null,'character','<%=JSPLib.ToJSValue(tipo,false,true)%>',false,false);
this.RTReport=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTReport","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTReport","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":197,"x":553,"y":-16});
this.RTReport.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.gTipInter=new ZtVWeb._VC(this,'gTipInter',null,'character','<%=JSPLib.ToJSValue(gTipInter,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_stp_stdtec_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stp_stdtec_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stp_stdtec_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.tipopdf.FillData();
window.<%=idPortlet%>.tiporep.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stp_stdtec',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stp_stdtec');
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
sp.endPage("pg_stp_stdtec");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_daCodCli")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aCodCli")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_daRapporto")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_aRapporto")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom17")) {
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
if (Library.eq(p_cControlName,"LinkZoom17_Copy")) {
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
<%! public String getJSPUID() { return "3792839740"; } %>