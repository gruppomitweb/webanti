<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE AUI (Allegato 1)\",true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Crea\",\n    title:FormatMsg('Crea'),\n    tooltip:FormatMsg(\"Crea l'estrazione AUI (Allegato 1)\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4b;\"},\n    action:'javascript:' + this.formid +'.Crea()'\n  },1);    \n}\nfunction btnElab_Click(){\n  if(this.opesel.Value()=='N' && this.rapsel.Value()=='N' && this.frzsel.Value()=='N'){\n    alert(\"Selezionare almeno una voce tra Operazioni, Frazionate e Rapporti\");\n  }\n  else{\n    if (confirm(\"Confermi l'estrazione dei dati?\")) {\n      this.PortletLogs.Start() \n      this.getTitlePortlet().RemoveButtons()\n      this.RTExec.Link();        \n    }\n  }\n}\n\nfunction dadata_onChange(){\n  this.rapsel_onChange();\n}\n\nfunction a_data_onChange(){\n  this.rapsel_onChange();\n}\n\nfunction rapsel_onChange(){\n  if(this.rapsel.Value()=='S'){\n    if(this.dadata.Value()!=null || this.a_data.Value()!=null){\n    \tthis.rappAttivSel.Show();\n    }\n  }\n  else{\n    this.rappAttivSel.Hide();\n  }\n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop()      \n  this.nomefile.Value(result);\n  this.SPLinker_aosrt_downloadfile.Link();\n  this.getTitlePortlet().AppendButton({\n    id:\"Crea\",\n    title:FormatMsg('Crea'),\n    tooltip:FormatMsg(\"Crea l'estrazione AUI (Allegato 1)\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4b;\"},\n    action:'javascript:' + this.formid +'.Crea()'\n  },1);  \n}","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @cDIP }}{{ @label15 }}{{ @rapsel }}{{ @btnElab }}{{ @lblOrdine }}{{ @label38_Copy }}{{ @zANADIP }}{{ @tipoout }}{{ @btnExit }}{{ @xdesdip }}{{ @label38_Copy_Copy_Copy_Copy }}{{ @pLog }}{{ @dadata }}{{ @lblTipoFile }}{{ @pMsg }}{{ @a_data }}{{ @rapporto }}{{ @label18_Copy }}{{ @opesel }}{{ @frzsel }}{{ @label18_Copy_Copy }}{{ @xdesrap }}{{ @zANARAPBO }}{{ @Calendario19_Copy }}{{ @Calendario19_Copy_Copy }}{{ @lblRapporto }}{{ @connes }}{{ @ragsoc }}{{ @cmbStorico }}{{ @zPERSONBO }}{{ @lblStorico }}{{ @cmbOrder }}{{ @rappAttivSel }}{{ @cDIP }}{{ @label15 }}{{ @rapsel }}{{ @lblOrdine }}{{ @label38_Copy }}{{ @zANADIP }}{{ @tipoout }}{{ @xdesdip }}{{ @label38_Copy_Copy_Copy_Copy }}{{ @dadata }}{{ @lblTipoFile }}{{ @a_data }}{{ @rapporto }}{{ @label18_Copy }}{{ @opesel }}{{ @frzsel }}{{ @label18_Copy_Copy }}{{ @xdesrap }}{{ @zANARAPBO }}{{ @Calendario19_Copy }}{{ @Calendario19_Copy_Copy }}{{ @lblRapporto }}{{ @connes }}{{ @ragsoc }}{{ @cmbStorico }}{{ @zPERSONBO }}{{ @lblStorico }}{{ @cmbOrder }}{{ @rappAttivSel }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"300","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @cDIP }} \n{{ @label15 }} \n{{ @rapsel }} \n \n{{ @lblOrdine }} \n{{ @label38_Copy }} \n{{ @zANADIP }} \n{{ @tipoout }} \n \n{{ @xdesdip }} \n{{ @label38_Copy_Copy_Copy_Copy }} \n \n{{ @dadata }} \n{{ @lblTipoFile }} \n \n{{ @a_data }} \n{{ @rapporto }} \n{{ @label18_Copy }} \n{{ @opesel }} \n{{ @frzsel }} \n{{ @label18_Copy_Copy }} \n{{ @xdesrap }} \n{{ @zANARAPBO }} \n{{ @Calendario19_Copy }} \n{{ @Calendario19_Copy_Copy }} \n{{ @lblRapporto }} \n{{ @connes }} \n{{ @ragsoc }} \n{{ @cmbStorico }} \n{{ @zPERSONBO }} \n{{ @lblStorico }} \n{{ @cmbOrder }} \n{{ @rappAttivSel }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"300\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"cDIP","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"57","wireframe_props":"name","x":"151","y":"46","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"220","zindex":"3","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label15","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NDG Intestatario:","w":"97","wireframe_props":"align,value,n_col","x":"52","y":"78","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Rapporti","layer":"false","layout_steps_values":"{}","name":"rapsel","page":"1","rapp":"","sequence":"4","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"113","wireframe_props":"label_text","x":"288","y":"156","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOrdine","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Ordine Estrazione:","w":"126","wireframe_props":"align,value,n_col","x":"384","y":"132","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Agenzia:","w":"69","wireframe_props":"align,value,n_col","x":"80","y":"51","zindex":"1","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"cDIP,xdesdip","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"cDIP","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"zANADIP","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"7","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"207","y":"46","zindex":"","zone":"","zoomtitle":"Agenzie\u002fDipendenze\u002fPunti Operativi"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"E","layer":"false","layout_steps_values":"{}","name":"tipoout","page":"1","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"","textlist":"XLSX,TXT,CSV","type":"Combobox","typevar":"character","valuelist":"E,T,C","visible":"true","w":"354","wireframe_props":"name,textlist","x":"151","y":"186","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"xdesdip","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"370","wireframe_props":"name","x":"236","y":"46","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Estrazione:","w":"111","wireframe_props":"align,value,n_col","x":"38","y":"162","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"dadata","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"151","y":"18","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipoFile","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Output:","w":"111","wireframe_props":"align,value,n_col","x":"38","y":"190","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"a_data","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"380","y":"18","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"25","name":"rapporto","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"187","wireframe_props":"name","x":"151","y":"102","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"111","wireframe_props":"align,value,n_col","x":"38","y":"23","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"S","label_text":"Operazioni","layer":"false","layout_steps_values":"{}","name":"opesel","page":"1","rapp":"","sequence":"16","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"113","wireframe_props":"label_text","x":"159","y":"156","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Frazionate","layer":"false","layout_steps_values":"{}","name":"frzsel","page":"1","rapp":"","sequence":"17","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"113","wireframe_props":"label_text","x":"412","y":"156","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label18_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"111","wireframe_props":"align,value,n_col","x":"266","y":"23","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"xdesrap","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"426","wireframe_props":"name","x":"367","y":"103","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"rapporto,xdesrap","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"rapporto","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"zANARAPBO","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"20","servlet":"","spuid":"","suggest":"false","table":"anarapbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"339","y":"103","zindex":"","zone":"","zoomtitle":"Rapporti"},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario19_Copy","page":"1","popup":"true","rapp":"","return_input":"dadata","sequence":"21","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"232","y":"18","zindex":"","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_DaData=dadata,w_AData=a_data,w_codage=cDIP,w_codcli=connes,w_rapporto=rapporto,w_flgope=opesel,w_flgrap=rapsel,w_flgfrz=frzsel,w_flgordine=cmbOrder,w_stoper=cmbStorico,w_tipout=tipoout,w_rappAttivSel=rappAttivSel","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"arfn_estrai_all1","target":"","type":"SPLinker","w":"129","x":"882","y":"11"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"23","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"129","x":"882","y":"34"},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario19_Copy_Copy","page":"1","popup":"true","rapp":"","return_input":"a_data","sequence":"24","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"461","y":"18","zindex":"","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblRapporto","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Rapporto:","w":"97","wireframe_props":"align,value,n_col","x":"52","y":"106","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"connes","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"27","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"131","wireframe_props":"name","x":"151","y":"74","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"ragsoc","page":"1","password":"","picker":"","picture":"!","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"28","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"426","wireframe_props":"name","x":"313","y":"73","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"O","layer":"false","layout_steps_values":"{}","name":"cmbStorico","page":"1","picture":"","rapp":"","sequence":"29","spuid":"","tabindex":"","textlist":"Data Operazione,Data Registrazione","type":"Combobox","typevar":"character","valuelist":"O,R","visible":"true","w":"226","wireframe_props":"name,textlist","x":"151","y":"130","zindex":"5","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"connes,ragsoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"connes","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"zPERSONBO","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"30","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"283","y":"73","zindex":"","zone":"","zoomtitle":"Soggetti"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblStorico","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Estrazione Stor. Anag. per:","w":"148","wireframe_props":"align,value,n_col","x":"1","y":"134","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","layer":"false","layout_steps_values":"{}","name":"cmbOrder","page":"1","picture":"","rapp":"","sequence":"32","spuid":"","tabindex":"","textlist":"Standard,Data Registrazione","type":"Combobox","typevar":"character","valuelist":"S,R","visible":"true","w":"285","wireframe_props":"name,textlist","x":"512","y":"129","zindex":"5","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","label_text":"Estrarre solo Rapporti attivi nel periodo","layer":"false","layout_steps_values":"{}","name":"rappAttivSel","page":"1","rapp":"","sequence":"33","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"288","wireframe_props":"label_text","x":"487","y":"18","zindex":"6","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPLinker_aosrt_downloadfile","offline":"false","page":"1","parms":"pFile=nomefile,pCartella=appo,pTipo=ZIP,pDir=A","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"34","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":"129","x":"882","y":"57"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"nomefile","page":"1","reactive":"","sequence":"35","server_side":"false","type":"Variable","typevar":"character","w":"129","x":"882","y":"80"}]%>
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
window.pg_estrazione_all1_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof dadata_onChange !='undefined')this.dadata_onChange=dadata_onChange;
if(typeof a_data_onChange !='undefined')this.a_data_onChange=a_data_onChange;
if(typeof rapsel_onChange !='undefined')this.rapsel_onChange=rapsel_onChange;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.zANADIP.addObserverFixedVars();
this.zANARAPBO.addObserverFixedVars();
this.zPERSONBO.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle("ESTRAZIONE AUI (Allegato 1)",true)
  this.getTitlePortlet().AppendButton({
    id:"Crea",
    title:FormatMsg('Crea'),
    tooltip:FormatMsg("Crea l'estrazione AUI (Allegato 1)"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4b;"},
    action:'javascript:' + this.formid +'.Crea()'
  },1);    
}
function btnElab_Click(){
  if(this.opesel.Value()=='N' && this.rapsel.Value()=='N' && this.frzsel.Value()=='N'){
    alert("Selezionare almeno una voce tra Operazioni, Frazionate e Rapporti");
  }
  else{
    if (confirm("Confermi l'estrazione dei dati?")) {
      this.PortletLogs.Start() 
      this.getTitlePortlet().RemoveButtons()
      this.RTExec.Link();        
    }
  }
}
function dadata_onChange(){
  this.rapsel_onChange();
}
function a_data_onChange(){
  this.rapsel_onChange();
}
function rapsel_onChange(){
  if(this.rapsel.Value()=='S'){
    if(this.dadata.Value()!=null || this.a_data.Value()!=null){
    	this.rappAttivSel.Show();
    }
  }
  else{
    this.rappAttivSel.Hide();
  }
}
function RTExec_Result(result){
  this.PortletLogs.Stop()      
  this.nomefile.Value(result);
  this.SPLinker_aosrt_downloadfile.Link();
  this.getTitlePortlet().AppendButton({
    id:"Crea",
    title:FormatMsg('Crea'),
    tooltip:FormatMsg("Crea l'estrazione AUI (Allegato 1)"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4b;"},
    action:'javascript:' + this.formid +'.Crea()'
  },1);  
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
.pg_estrazione_all1_container {
  height:100%;
  overflow:auto;
}
.pg_estrazione_all1_title_container {
  margin: auto;
}
.pg_estrazione_all1_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_estrazione_all1_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_estrazione_all1_portlet > .cDIP_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:151px;
  width:57px;
  height:20px;
}
.pg_estrazione_all1_portlet > .cDIP_ctrl {
}
.pg_estrazione_all1_portlet > .cDIP_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:220px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_estrazione_all1_portlet > .label15_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:78px;
  left:52px;
  width:97px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label15_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label15_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .rapsel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:156px;
  left:288px;
  width:113px;
  height:22px;
}
.pg_estrazione_all1_portlet > .lblOrdine_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:132px;
  left:384px;
  width:126px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblOrdine_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblOrdine_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .label38_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:51px;
  left:80px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label38_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label38_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .zANADIP_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:207px;
  width:20px;
  height:20px;
}
.pg_estrazione_all1_portlet > .tipoout_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:186px;
  left:151px;
  width:354px;
  height:20px;
}
.pg_estrazione_all1_portlet > .xdesdip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:236px;
  width:370px;
  height:20px;
}
.pg_estrazione_all1_portlet > .xdesdip_ctrl {
}
.pg_estrazione_all1_portlet > .xdesdip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .label38_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:162px;
  left:38px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label38_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label38_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .dadata_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:151px;
  width:81px;
  height:20px;
}
.pg_estrazione_all1_portlet > .dadata_ctrl {
}
.pg_estrazione_all1_portlet > .dadata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .lblTipoFile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:190px;
  left:38px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblTipoFile_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblTipoFile_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .a_data_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:380px;
  width:81px;
  height:20px;
}
.pg_estrazione_all1_portlet > .a_data_ctrl {
}
.pg_estrazione_all1_portlet > .a_data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .rapporto_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:102px;
  left:151px;
  width:187px;
  height:20px;
}
.pg_estrazione_all1_portlet > .rapporto_ctrl {
}
.pg_estrazione_all1_portlet > .rapporto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .label18_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:23px;
  left:38px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label18_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label18_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .opesel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:156px;
  left:159px;
  width:113px;
  height:22px;
}
.pg_estrazione_all1_portlet > .frzsel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:156px;
  left:412px;
  width:113px;
  height:22px;
}
.pg_estrazione_all1_portlet > .label18_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:23px;
  left:266px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label18_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .label18_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .xdesrap_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:103px;
  left:367px;
  width:426px;
  height:20px;
}
.pg_estrazione_all1_portlet > .xdesrap_ctrl {
}
.pg_estrazione_all1_portlet > .xdesrap_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .zANARAPBO_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:103px;
  left:339px;
  width:20px;
  height:20px;
}
.pg_estrazione_all1_portlet > .Calendario19_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:232px;
  width:20px;
  height:20px;
}
.pg_estrazione_all1_portlet > .Calendario19_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:461px;
  width:20px;
  height:20px;
}
.pg_estrazione_all1_portlet > .lblRapporto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:106px;
  left:52px;
  width:97px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblRapporto_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblRapporto_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .connes_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:74px;
  left:151px;
  width:131px;
  height:20px;
}
.pg_estrazione_all1_portlet > .connes_ctrl {
}
.pg_estrazione_all1_portlet > .connes_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .ragsoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  left:313px;
  width:426px;
  height:20px;
}
.pg_estrazione_all1_portlet > .ragsoc_ctrl {
}
.pg_estrazione_all1_portlet > .ragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrazione_all1_portlet > .cmbStorico_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:130px;
  left:151px;
  width:226px;
  height:20px;
}
.pg_estrazione_all1_portlet > .zPERSONBO_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  left:283px;
  width:20px;
  height:20px;
}
.pg_estrazione_all1_portlet > .lblStorico_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:134px;
  left:1px;
  width:148px;
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblStorico_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrazione_all1_portlet > .lblStorico_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrazione_all1_portlet > .cmbOrder_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:129px;
  left:512px;
  width:285px;
  height:20px;
}
.pg_estrazione_all1_portlet > .rappAttivSel_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:18px;
  left:487px;
  width:288px;
  height:20px;
  display:none;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cDIP\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"57\",\"x\":\"151\",\"y\":\"46\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"name\":\"PortletLogs\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"220\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label15\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NDG Intestatario:\",\"w\":\"97\",\"x\":\"52\",\"y\":\"78\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"label_text\":\"Rapporti\",\"layout_steps_values\":{},\"name\":\"rapsel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"113\",\"x\":\"288\",\"y\":\"156\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrdine\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Ordine Estrazione:\",\"w\":\"126\",\"x\":\"384\",\"y\":\"132\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"69\",\"x\":\"80\",\"y\":\"51\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zANADIP\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"207\",\"y\":\"46\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipoout\",\"page\":\"1\",\"textlist\":\"XLSX,TXT,CSV\",\"type\":\"Combobox\",\"w\":\"354\",\"x\":\"151\",\"y\":\"186\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"xdesdip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"370\",\"x\":\"236\",\"y\":\"46\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Estrazione:\",\"w\":\"111\",\"x\":\"38\",\"y\":\"162\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dadata\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"151\",\"y\":\"18\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTipoFile\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Output:\",\"w\":\"111\",\"x\":\"38\",\"y\":\"190\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"a_data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"380\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"rapporto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"187\",\"x\":\"151\",\"y\":\"102\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"111\",\"x\":\"38\",\"y\":\"23\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"label_text\":\"Operazioni\",\"layout_steps_values\":{},\"name\":\"opesel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"113\",\"x\":\"159\",\"y\":\"156\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"label_text\":\"Frazionate\",\"layout_steps_values\":{},\"name\":\"frzsel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"113\",\"x\":\"412\",\"y\":\"156\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"111\",\"x\":\"266\",\"y\":\"23\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"xdesrap\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"426\",\"x\":\"367\",\"y\":\"103\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zANARAPBO\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"339\",\"y\":\"103\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario19_Copy\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"232\",\"y\":\"18\",\"zindex\":\"\"},{\"h\":\"20\",\"name\":\"RTExec\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"129\",\"x\":\"882\",\"y\":\"11\"},{\"h\":\"20\",\"name\":\"RTEsci\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"129\",\"x\":\"882\",\"y\":\"34\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario19_Copy_Copy\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"461\",\"y\":\"18\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblRapporto\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Rapporto:\",\"w\":\"97\",\"x\":\"52\",\"y\":\"106\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"connes\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"131\",\"x\":\"151\",\"y\":\"74\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"426\",\"x\":\"313\",\"y\":\"73\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbStorico\",\"page\":\"1\",\"textlist\":\"Data Operazione,Data Registrazione\",\"type\":\"Combobox\",\"w\":\"226\",\"x\":\"151\",\"y\":\"130\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zPERSONBO\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"283\",\"y\":\"73\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblStorico\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Estrazione Stor. Anag. per:\",\"w\":\"148\",\"x\":\"1\",\"y\":\"134\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbOrder\",\"page\":\"1\",\"textlist\":\"Standard,Data Registrazione\",\"type\":\"Combobox\",\"w\":\"285\",\"x\":\"512\",\"y\":\"129\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Estrarre solo Rapporti attivi nel periodo\",\"layout_steps_values\":{},\"name\":\"rappAttivSel\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"288\",\"x\":\"487\",\"y\":\"18\",\"zindex\":\"6\"},{\"h\":\"20\",\"name\":\"SPLinker_aosrt_downloadfile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"129\",\"x\":\"882\",\"y\":\"57\"},{\"h\":\"20\",\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"129\",\"x\":\"882\",\"y\":\"80\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrazione_all1","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrazione_all1_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_estrazione_all1_portlet > .rappAttivSel_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrazione_all1','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String cDIP= "";
if(request.getAttribute("pg_estrazione_all1_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label15= "NDG Intestatario:";
String rapsel="N";
String lblOrdine= "Ordine Estrazione:";
String label38_Copy= "Agenzia:";
if(request.getAttribute("pg_estrazione_all1_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String tipoout="E";
String xdesdip= "";
String label38_Copy_Copy_Copy_Copy= "Estrazione:";
java.sql.Date dadata= JSPLib.NullDate();
String lblTipoFile= "Tipo Output:";
java.sql.Date a_data= JSPLib.NullDate();
String rapporto= "";
String label18_Copy= "Da Data Operazione:";
String opesel="S";
String frzsel="N";
String label18_Copy_Copy= "A Data Operazione:";
String xdesrap= "";
if(request.getAttribute("pg_estrazione_all1_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String lblRapporto= "Rapporto:";
String connes= "";
String ragsoc= "";
String cmbStorico="O";
String lblStorico= "Estrazione Stor. Anag. per:";
String cmbOrder="S";
String rappAttivSel= "";
String nomefile= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrazione_all1_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estrazione_all1_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrazione_all1_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrazione_all1','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_cDIP_wrp'><input id='<%=idPortlet%>_cDIP' name='cDIP' type='text' maxlength='6' class='textbox' formid='<%=idPortlet%>' ps-name='cDIP' /></span>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span id='<%=idPortlet%>_label15'  formid='<%=idPortlet%>' ps-name='label15'    class='LabelOpenClose label15_ctrl'><div id='<%=idPortlet%>_label15tbl' style='width:100%;'><%=JSPLib.ToHTML("NDG Intestatario:")%></div></span>
<div id='<%=idPortlet%>_rapsel_div' style=''><input id='<%=idPortlet%>_rapsel' name='rapsel' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_rapsel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Rapporti")%></label></div>
<span id='<%=idPortlet%>_lblOrdine'  formid='<%=idPortlet%>' ps-name='lblOrdine'    class='LabelOpenClose lblOrdine_ctrl'><div id='<%=idPortlet%>_lblOrdinetbl' style='width:100%;'><%=JSPLib.ToHTML("Ordine Estrazione:")%></div></span>
<span id='<%=idPortlet%>_label38_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy'    class='label label38_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zANADIP'" ) );%>
<select id='<%=idPortlet%>_tipoout' name='tipoout' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span class='textbox-container'id='<%=idPortlet%>_xdesdip_wrp'><input id='<%=idPortlet%>_xdesdip' name='xdesdip' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='xdesdip' /></span>
<span id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy_Copy_Copy'    class='label label38_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Estrazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_dadata_wrp'><input id='<%=idPortlet%>_dadata' name='dadata' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='dadata' /></span>
<span id='<%=idPortlet%>_lblTipoFile'  formid='<%=idPortlet%>' ps-name='lblTipoFile'    class='label lblTipoFile_ctrl'><div id='<%=idPortlet%>_lblTipoFiletbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Output:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_a_data_wrp'><input id='<%=idPortlet%>_a_data' name='a_data' type='text' maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='a_data' /></span>
<span class='textbox-container'id='<%=idPortlet%>_rapporto_wrp'><input id='<%=idPortlet%>_rapporto' name='rapporto' type='text' maxlength='25' class='textbox' formid='<%=idPortlet%>' ps-name='rapporto' /></span>
<span id='<%=idPortlet%>_label18_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy'    class='label label18_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_opesel_div' style=''><input id='<%=idPortlet%>_opesel' name='opesel' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_opesel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Operazioni")%></label></div>
<div id='<%=idPortlet%>_frzsel_div' style=''><input id='<%=idPortlet%>_frzsel' name='frzsel' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_frzsel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Frazionate")%></label></div>
<span id='<%=idPortlet%>_label18_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy_Copy'    class='label label18_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_xdesrap_wrp'><input id='<%=idPortlet%>_xdesrap' name='xdesrap' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='xdesrap' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zANARAPBO'" ) );%>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario19_Copy' class='calendar' onclick='window.<%=idPortlet%>.Calendario19_Copy.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario19_Copy_Copy' class='calendar' onclick='window.<%=idPortlet%>.Calendario19_Copy_Copy.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_lblRapporto'  formid='<%=idPortlet%>' ps-name='lblRapporto'    class='LabelOpenClose lblRapporto_ctrl'><div id='<%=idPortlet%>_lblRapportotbl' style='width:100%;'><%=JSPLib.ToHTML("Rapporto:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_connes_wrp'><input id='<%=idPortlet%>_connes' name='connes' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='connes' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ragsoc_wrp'><input id='<%=idPortlet%>_ragsoc' name='ragsoc' type='text' maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='ragsoc' data-sp-item-say-pict='!' data-sp-item-get-pict='!' /></span>
<select id='<%=idPortlet%>_cmbStorico' name='cmbStorico' class='combobox' style=''></select>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zPERSONBO'" ) );%>
<span id='<%=idPortlet%>_lblStorico'  formid='<%=idPortlet%>' ps-name='lblStorico'    class='LabelOpenClose lblStorico_ctrl'><div id='<%=idPortlet%>_lblStoricotbl' style='width:100%;'><%=JSPLib.ToHTML("Estrazione Stor. Anag. per:")%></div></span>
<select id='<%=idPortlet%>_cmbOrder' name='cmbOrder' class='combobox' style=''></select>
<div id='<%=idPortlet%>_rappAttivSel_div' style=''><input id='<%=idPortlet%>_rappAttivSel' name='rappAttivSel' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_rappAttivSel' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Estrarre solo Rapporti attivi nel periodo")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrazione_all1');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea",true)+","+JSPLib.ToJSValue(sp.translate("Crea"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea l'estrazione AUI (Allegato 1)",true)+","+JSPLib.ToJSValue(sp.translate("Crea l'estrazione AUI (Allegato 1)"),true)+");\n");
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
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrazione_all1',["800"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"300","title":"","layer":""}]);
this.cDIP=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cDIP","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"6","name":"cDIP","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cDIP,false,true)%>","w":57,"x":151,"y":46,"zerofilling":false,"zindex":"1","zoom":""});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":220,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.label15=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlid":"<%=idPortlet%>_label15","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label15","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label15,false,true)%>","type":"Label","w":97,"x":52,"y":78,"zindex":"1"});
this.rapsel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_rapsel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":22,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Rapporti","layer":false,"layout_steps_values":{},"name":"rapsel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":113,"x":288,"y":156,"zindex":"1"});
this.rapsel.Value('<%=rapsel%>');
this.lblOrdine=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrdine","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrdine","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOrdine,false,true)%>","type":"Label","w":126,"x":384,"y":132,"zindex":"1"});
this.label38_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy,false,true)%>","type":"Label","w":69,"x":80,"y":51,"zindex":"1"});
this.zANADIP=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zANADIP","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrazione_all1_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"cDIP,xdesdip","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrazione_all1_portlet.jspzANADIP",request.getSession())%>","linkedField":"cDIP","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zANADIP","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":207,"y":46,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Agenzie/Dipendenze/Punti Operativi"),false,true)%>"});
this.tipoout=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipoout","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipoout%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipoout","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"XLSX,TXT,CSV","type":"Combobox","typevar":"character","valuelist":"E,T,C","visible":true,"w":354,"x":151,"y":186,"zindex":"1"});
this.xdesdip=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xdesdip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"xdesdip","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xdesdip,false,true)%>","w":370,"x":236,"y":46,"zerofilling":false,"zindex":"1","zoom":""});
this.label38_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":111,"x":38,"y":162,"zindex":"1"});
this.dadata=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dadata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"dadata","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dadata%>","w":81,"x":151,"y":18,"zerofilling":false,"zindex":"1","zoom":""});
this.lblTipoFile=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipoFile","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipoFile","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipoFile,false,true)%>","type":"Label","w":111,"x":38,"y":190,"zindex":"1"});
this.a_data=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_a_data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"a_data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=a_data%>","w":81,"x":380,"y":18,"zerofilling":false,"zindex":"1","zoom":""});
this.rapporto=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_rapporto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"25","name":"rapporto","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(rapporto,false,true)%>","w":187,"x":151,"y":102,"zerofilling":false,"zindex":"4","zoom":""});
this.label18_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy,false,true)%>","type":"Label","w":111,"x":38,"y":23,"zindex":"1"});
this.opesel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_opesel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":22,"hide":"false","hide_undercond":"","init":"false","init_par":"S","label_text":"Operazioni","layer":false,"layout_steps_values":{},"name":"opesel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":113,"x":159,"y":156,"zindex":"1"});
this.opesel.Value('<%=opesel%>');
this.frzsel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_frzsel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":22,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Frazionate","layer":false,"layout_steps_values":{},"name":"frzsel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":113,"x":412,"y":156,"zindex":"1"});
this.frzsel.Value('<%=frzsel%>');
this.label18_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label18_Copy_Copy,false,true)%>","type":"Label","w":111,"x":266,"y":23,"zindex":"1"});
this.xdesrap=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xdesrap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"xdesrap","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xdesrap,false,true)%>","w":426,"x":367,"y":103,"zerofilling":false,"zindex":"1","zoom":""});
this.zANARAPBO=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zANARAPBO","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrazione_all1_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"rapporto,xdesrap","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrazione_all1_portlet.jspzANARAPBO",request.getSession())%>","linkedField":"rapporto","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zANARAPBO","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":false,"table":"anarapbo","type":"LinkZoom","w":20,"x":339,"y":103,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Rapporti"),false,true)%>"});
this.Calendario19_Copy=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario19_Copy','Calendario19_Copy',232,18,20,20,'Verdana','10','top-left','true','dadata',{});
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_DaData=dadata,w_AData=a_data,w_codage=cDIP,w_codcli=connes,w_rapporto=rapporto,w_flgope=opesel,w_flgrap=rapsel,w_flgfrz=frzsel,w_flgordine=cmbOrder,w_stoper=cmbStorico,w_tipout=tipoout,w_rappAttivSel=rappAttivSel","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_estrai_all1","target":"","type":"SPLinker","w":129,"x":882,"y":11});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_estrai_all1",request.getSession())%>';
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":129,"x":882,"y":34});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.Calendario19_Copy_Copy=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario19_Copy_Copy','Calendario19_Copy_Copy',461,18,20,20,'Verdana','10','top-left','true','a_data',{});
this.lblRapporto=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlid":"<%=idPortlet%>_lblRapporto","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblRapporto","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblRapporto,false,true)%>","type":"Label","w":97,"x":52,"y":106,"zindex":"1"});
this.connes=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_connes","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"connes","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(connes,false,true)%>","w":131,"x":151,"y":74,"zerofilling":false,"zindex":"1","zoom":""});
this.ragsoc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"ragsoc","page":1,"picker":"","picture":"!","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragsoc,false,true)%>","w":426,"x":313,"y":73,"zerofilling":false,"zindex":"1","zoom":""});
this.cmbStorico=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbStorico","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbStorico%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbStorico","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Data Operazione,Data Registrazione","type":"Combobox","typevar":"character","valuelist":"O,R","visible":true,"w":226,"x":151,"y":130,"zindex":"5"});
this.zPERSONBO=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zPERSONBO","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_estrazione_all1_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"connes,ragsoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_estrazione_all1_portlet.jspzPERSONBO",request.getSession())%>","linkedField":"connes","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zPERSONBO","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":283,"y":73,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Soggetti"),false,true)%>"});
this.lblStorico=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"LabelOpenClose","create_undercond":"","ctrlid":"<%=idPortlet%>_lblStorico","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblStorico","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblStorico,false,true)%>","type":"Label","w":148,"x":1,"y":134,"zindex":"1"});
this.cmbOrder=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbOrder","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbOrder%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbOrder","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Standard,Data Registrazione","type":"Combobox","typevar":"character","valuelist":"S,R","visible":true,"w":285,"x":512,"y":129,"zindex":"5"});
this.rappAttivSel=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_rappAttivSel","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"true","hide_undercond":"","init":"","init_par":"","label_text":"Estrarre solo Rapporti attivi nel periodo","layer":false,"layout_steps_values":{},"name":"rappAttivSel","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":288,"x":487,"y":18,"zindex":"6"});
this.SPLinker_aosrt_downloadfile=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_aosrt_downloadfile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_aosrt_downloadfile","offline":false,"page":1,"parms":"pFile=nomefile,pCartella=appo,pTipo=ZIP,pDir=A","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":129,"x":882,"y":57});
this.SPLinker_aosrt_downloadfile.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadfile",request.getSession())%>';
this.nomefile=new ZtVWeb._VC(this,'nomefile',null,'character','<%=JSPLib.ToJSValue(nomefile,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_estrazione_all1_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrazione_all1_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrazione_all1_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.tipoout.FillData();
window.<%=idPortlet%>.cmbStorico.FillData();
window.<%=idPortlet%>.cmbOrder.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrazione_all1',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrazione_all1');
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
sp.endPage("pg_estrazione_all1");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
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
if (Library.eq(p_cControlName,"zANARAPBO")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"zPERSONBO")) {
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
return null;
}/**/%>
<%! public String getJSPUID() { return "1497561221"; } %>