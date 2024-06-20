<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Aggiornamento Tabelle di Base',true);\n  this.RTAzzera.Link();\n  if (this.gAggTabs.Value()=='N') {\n    this.varsel1.Value(\"NNNNNNNN\")\n    this.varsel2.Value(\"NNNNNNNN\")\n    this.varsel3.Value(\"NNNNNNNN\")\n    this.varsel4.Value(\"NNNNNNNN\")\n    this.varsel5.Value(\"NNNNNNNNNN\")\n    this.getTitlePortlet().AppendButton({\n      id:\"Importa\",\n      title:FormatMsg('Importa AUI\u002fAGE'),\n      tooltip:FormatMsg('Aggiorna i dati nelle tabelle di base'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n      action:'javascript:' + this.formid +'.Import()'\n    },1);      \n    this.getTitlePortlet().AppendButton({\n      id:\"ImportaIII\",\n      title:FormatMsg('Importa III\u002fIV'),\n      tooltip:FormatMsg('Aggiorna i dati delle tabelle della III\u002fIV Direttiva'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n      action:'javascript:' + this.formid +'.ImportIII()'\n    },2);          \n    this.getTitlePortlet().AppendButton({\n      id:\"SelDes\",\n      title:FormatMsg('Seleziona\u002fDeselezione'),\n      tooltip:FormatMsg('Seleziona\u002fDeseleziona le tabelle'),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n      action:'javascript:' + this.formid +'.SelDes()'\n    },3);      \n  } else {\n    this.SelDes();   \n    alert(\"Necessario aggiornamento tabelle di base\")\n    this.PortletLogs.Start();\n    this.RTExec.Link();    \n  }  \n}\n\nfunction Import(){\n  if (confirm(\"Confermi l'aggiornamento delle tabelle di base?\")) {\n    this.PortletLogs.Start();\n    this.RTExec.Link();\n  }    \n}\n\nfunction ImportIII(){\n  if (confirm(\"Confermi l'aggiornamento delle tabelle della III\u002fIV Direttiva?\")) {\n    this.PortletLogs.Start();\n    this.RTExecIII.Link();\n  }    \n}\n\nfunction SelDes(){\n  if(At(\"S\",this.varsel1.Value()) \u003e 0) {\n    this.convgio.Value(\"N\")\n    this.inter2bo.Value(\"N\")                   \n    this.rapogg.Value(\"N\")                       \n    this.staticrs.Value(\"N\")    \n    this.tbcandistr.Value(\"N\")\n    this.tbcauana.Value(\"N\")\n    this.tbcitta.Value(\"N\")\n    this.tbcittna.Value(\"N\")\n    this.tberrdge.Value(\"N\")                   \n    this.tberrorisid.Value(\"N\")    \n    this.tberrsiddgn.Value(\"N\")\n    this.tbesielb.Value(\"N\")                       \n    this.tbesitoage.Value(\"N\")\n    this.tbluonas.Value(\"N\")\n    this.tbprovsv.Value(\"N\")\n    this.tbprvreg.Value(\"N\")\n    this.tbramgru.Value(\"N\")\n    this.tbrapp.Value(\"N\")\n    this.tbricevutesid.Value(\"N\")\n    this.tbsetsin.Value(\"N\")\n    this.tbstati.Value(\"N\")\n    this.tbstatna.Value(\"N\")\n    this.tbstgru.Value(\"N\")\n    this.tbtipdoc.Value(\"N\")\n    this.tbtipint.Value(\"N\")\n    this.tbtipleg.Value(\"N\") \n    this.tbtipnat.Value(\"N\")                       \n    this.tbtipreg.Value(\"N\")                       \n    this.tbvalute.Value(\"N\") \n    this.tbnatura.Value(\"N\")\n    this.tbscopo.Value(\"N\")    \n    this.tbrisglob.Value(\"N\")    \n    this.tbident.Value(\"N\")    \n    this.tbtipope.Value(\"N\")\n    this.tbprcsched.Value(\"N\")\n    this.tbnaturaage.Value(\"N\")\n    this.tblimcon.Value(\"N\")\n    this.tbaml.Value(\"N\")\n    this.tabellea7.Value(\"N\")\n    this.tbvasp.Value(\"N\")\n    this.tbstatisv.Value(\"N\")\n    this.tbnindris.Value(\"N\")\n    this.varsel1.Value(\"NNNNNNNN\")\n    this.varsel2.Value(\"NNNNNNNN\")\n    this.varsel3.Value(\"NNNNNNNN\")\n    this.varsel4.Value(\"NNNNNNNN\")    \n    this.varsel5.Value(\"NNNNNNNNNN\")\n  } else {\n    this.convgio.Value(\"S\")\n    this.inter2bo.Value(\"S\")                   \n    this.rapogg.Value(\"S\")                       \n    this.staticrs.Value(\"S\")    \n    this.tbcandistr.Value(\"S\")\n    this.tbcauana.Value(\"S\")\n    this.tbcitta.Value(\"S\")\n    this.tbcittna.Value(\"S\")\n    this.tberrdge.Value(\"S\")                   \n    this.tberrorisid.Value(\"S\")\n    this.tberrsiddgn.Value(\"S\")\n    this.tbesielb.Value(\"S\")                       \n    this.tbesitoage.Value(\"S\")\n    this.tbluonas.Value(\"S\")\n    this.tbprovsv.Value(\"S\")\n    this.tbprvreg.Value(\"S\")\n    this.tbramgru.Value(\"S\")\n    this.tbrapp.Value(\"S\")\n    this.tbricevutesid.Value(\"S\")\n    this.tbsetsin.Value(\"S\")\n    this.tbstati.Value(\"S\")\n    this.tbstatna.Value(\"S\")\n    this.tbstgru.Value(\"S\")    \n    this.tbtipdoc.Value(\"S\")\n    this.tbtipint.Value(\"S\")\n    this.tbtipleg.Value(\"S\") \n    this.tbtipnat.Value(\"S\")                       \n    this.tbtipreg.Value(\"S\")                       \n    this.tbvalute.Value(\"S\")    \n    this.tbnatura.Value(\"S\")\n    this.tbscopo.Value(\"S\")    \n    this.tbrisglob.Value(\"S\")        \n    this.tbident.Value(\"S\")  \n    this.tbtipope.Value(\"S\")\n    this.tbprcsched.Value(\"S\")\n    this.tbnaturaage.Value(\"S\")\n    this.tblimcon.Value(\"S\")    \n    this.tbaml.Value(\"S\") \n    this.tabellea7.Value(\"S\")    \n    this.tbvasp.Value(\"S\")\n    this.tbstatisv.Value(\"S\")\n    this.tbnindris.Value(\"S\")\n    this.varsel1.Value(\"SSSSSSSS\")\n    this.varsel2.Value(\"SSSSSSSS\")    \n    this.varsel3.Value(\"SSSSSSSS\")        \n    this.varsel4.Value(\"SSSSSSSS\")        \n    this.varsel5.Value(\"SSSSSSSSSS\")            \n  }  \n}\n\nfunction RTExec_Result(result){\n  if (this.gAggTabs.Value()=='S') {\n    alert(\"Aggiornamento Tabelle di Base Completato!\")\n    this.PortletLogs.Stop();\n    this.RTLogout.Link();\n  }  \n}\n\nfunction RTExecIII_Result(result){\n  alert(\"Aggiornamento Tabelle III\u002fIV Direttiva Completato!\")\n  this.PortletLogs.Stop();  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @tberrdge }}{{ @tbtiporisc }}{{ @tbscopo }}{{ @tbareegeog }}{{ @tbramgru }}{{ @tbimporto }}{{ @tbrisglob }}{{ @tbplauso }}{{ @tbvalute }}{{ @tbspecie }}{{ @tbesitoage }}{{ @tbsvolgim }}{{ @tbcondotta }}{{ @convgio }}{{ @tbdurata }}{{ @tbsetsin }}{{ @tbcauana }}{{ @tbrapp }}{{ @rapogg }}{{ @tbtipleg }}{{ @tbtipnat }}{{ @tbcittna }}{{ @tberrsiddgn }}{{ @tbricevutesid }}{{ @tbstatna }}{{ @tbstgru }}{{ @tbprvreg }}{{ @tbesielb }}{{ @tbluonas }}{{ @staticrs }}{{ @tbcandistr }}{{ @tbprovsv }}{{ @inter2bo }}{{ @tbtipreg }}{{ @tbcitta }}{{ @tbstati }}{{ @tbtipint }}{{ @tbtipdoc }}{{ @tberrorisid }}{{ @tbnatura }}{{ @tbident }}{{ @tbtipope }}{{ @tbprcsched }}{{ @tbnaturaage }}{{ @Label48 }}{{ @Label48_Copy }}{{ @tbtipatt }}{{ @tblimcon }}{{ @tbaml }}{{ @tabellea7 }}{{ @tbvasp }}{{ @tbstatisv }}{{ @tbnindris }}\u003cdiv name=\"Portlet65\" index=\"63\" type=\"Portlet\"\u003ePortlet65\u003c\u002fdiv\u003e{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"550","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @tbnindris }} \n{{ @tbstatisv }}\n{{ @tbvasp }}\n{{ @tabellea7 }}\n{{ @tbaml }}\n{{ @tblimcon }}\n\n\n\n{{ @tbdurata }}\n{{ @tbcondotta }}\n{{ @tbsvolgim }}\n{{ @tbspecie }}\n{{ @tbplauso }}\n{{ @tbimporto }}\n{{ @tbareegeog }}\n{{ @tbtiporisc }}\n{{ @tbtipatt }}\n{{ @Label48_Copy }}\n{{ @Label48 }}\n\n{{ @tbnaturaage }}\n{{ @tbprcsched }}\n{{ @tbtipope }}\n{{ @tbident }}\n{{ @tbnatura }}\n\n{{ @tberrorisid }}\n{{ @tbtipdoc }}\n{{ @tbtipint }}\n{{ @tbstati }}\n{{ @tbcitta }}\n\n\n{{ @tbtipreg }}\n{{ @inter2bo }}\n{{ @tbprovsv }}\n{{ @tbcandistr }}\n{{ @staticrs }}\n{{ @tbluonas }}\n{{ @tbesielb }}\n{{ @tbprvreg }}\n{{ @tbstgru }}\n\n{{ @tbstatna }}\n{{ @tbricevutesid }}\n{{ @tberrsiddgn }}\n\n{{ @tbcittna }}\n{{ @tbtipnat }}\n{{ @tbtipleg }}\n{{ @rapogg }}\n{{ @tbrapp }}\n{{ @tbcauana }}\n{{ @tbsetsin }}\n{{ @convgio }}\n{{ @tbesitoage }}\n{{ @tbvalute }}\n{{ @tbrisglob }}\n{{ @tbramgru }}\n{{ @tbscopo }}\n{{ @tberrdge }}\n{{ tbtipope }}\n{{ RTLogout }}\n{{ tberrdge }}\n{{ tbscopo }}\n{{ tbramgru }}\n{{ tbrisglob }}\n{{ tbvalute }}\n{{ tbesitoage }}\n{{ varsel5 }}\n{{ convgio }}\n{{ tbsetsin }}\n{{ tbcauana }}\n{{ tbrapp }}\n{{ rapogg }}\n{{ tbtipleg }}\n{{ tbtipnat }}\n{{ tbcittna }}\n{{ btnExit }}\n{{ tberrsiddgn }}\n{{ tbricevutesid }}\n{{ tbstatna }}\n{{ btnElab }}\n{{ tbstgru }}\n{{ tbprvreg }}\n{{ tbesielb }}\n{{ tbluonas }}\n{{ RTExec }}\n{{ staticrs }}\n{{ tbcandistr }}\n{{ tbprovsv }}\n{{ inter2bo }}\n{{ tbtipreg }}\n{{ pLog }}\n{{ pMsg }}\n{{ RTUscita }}\n{{ RTAzzera }}\n{{ tbcitta }}\n{{ tbstati }}\n{{ tbtipint }}\n{{ tbtipdoc }}\n{{ tberrorisid }}\n{{ btnSelDes }}\n{{ varsel1 }}\n{{ varsel2 }}\n{{ varsel3 }}\n{{ varsel4 }}\n{{ gAggTabs }}\n{{ RTDelAgg }}\n{{ tbnatura }}\n{{ tbident }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"550\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1000","version":"37","w":"100%","wizard":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Errori Esiti Saldi (AGE)","layer":"false","layout_steps_values":"{}","name":"tberrdge","page":"1","rapp":"","sequence":"1","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"173","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Rischio","layer":"false","layout_steps_values":"{}","name":"tbtiporisc","page":"1","rapp":"","sequence":"2","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"402","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Scopo Rapporto","layer":"false","layout_steps_values":"{}","name":"tbscopo","page":"1","rapp":"","sequence":"3","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"229","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Aree Geografiche","layer":"false","layout_steps_values":"{}","name":"tbareegeog","page":"1","rapp":"","sequence":"4","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"374","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"R.A.E. (UIF)","layer":"false","layout_steps_values":"{}","name":"tbramgru","page":"1","rapp":"","sequence":"5","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"61","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Importo","layer":"false","layout_steps_values":"{}","name":"tbimporto","page":"1","rapp":"","sequence":"6","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"402","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Rischio Globale","layer":"false","layout_steps_values":"{}","name":"tbrisglob","page":"1","rapp":"","sequence":"7","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"229","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Plauso","layer":"false","layout_steps_values":"{}","name":"tbplauso","page":"1","rapp":"","sequence":"8","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"374","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Valute (UIF)","layer":"false","layout_steps_values":"{}","name":"tbvalute","page":"1","rapp":"","sequence":"9","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"61","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Specie Giuridica","layer":"false","layout_steps_values":"{}","name":"tbspecie","page":"1","rapp":"","sequence":"10","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"374","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Esiti Age (AGE)","layer":"false","layout_steps_values":"{}","name":"tbesitoage","page":"1","rapp":"","sequence":"11","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"61","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Svolgimento","layer":"false","layout_steps_values":"{}","name":"tbsvolgim","page":"1","rapp":"","sequence":"12","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"374","zindex":"4","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"varsel5","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"798","y":"-70"},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Condotta","layer":"false","layout_steps_values":"{}","name":"tbcondotta","page":"1","rapp":"","sequence":"14","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"402","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Conversione Tipi Gioco (CGO)","layer":"false","layout_steps_values":"{}","name":"convgio","page":"1","rapp":"","sequence":"15","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"201","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Durata","layer":"false","layout_steps_values":"{}","name":"tbdurata","page":"1","rapp":"","sequence":"16","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"430","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Settori Sintetici (UIF)","layer":"false","layout_steps_values":"{}","name":"tbsetsin","page":"1","rapp":"","sequence":"17","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"89","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Causali (UIF)","layer":"false","layout_steps_values":"{}","name":"tbcauana","page":"1","rapp":"","sequence":"18","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"89","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipi Rapporto (AGE)","layer":"false","layout_steps_values":"{}","name":"tbrapp","page":"1","rapp":"","sequence":"19","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"89","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Rapporti Oggettivi (UIF)","layer":"false","layout_steps_values":"{}","name":"rapogg","page":"1","rapp":"","sequence":"20","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"229","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Legame (UIF)","layer":"false","layout_steps_values":"{}","name":"tbtipleg","page":"1","rapp":"","sequence":"21","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"117","zindex":"4","zone":""},{"allowedentities":"arfn_import_3dce","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExecIII","offline":"false","page":"1","parms":"w_tbareegeog=tbareegeog,w_tbspecie=tbspecie,w_tbtiporisc=tbtiporisc,w_tbsvolgim=tbsvolgim,w_tbcondotta=tbcondotta,w_tbimporto=tbimporto,w_tbdurata=tbdurata,w_tbplauso=tbplauso,w_tbtipatt=tbtipatt","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"arfn_import_3dce","target":"","type":"SPLinker","w":"120","x":"1011","y":"8"},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Natura Conti (AGE)","layer":"false","layout_steps_values":"{}","name":"tbtipnat","page":"1","rapp":"","sequence":"23","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"117","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Città di Nascita (UIF)","layer":"false","layout_steps_values":"{}","name":"tbcittna","page":"1","rapp":"","sequence":"24","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"117","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Errori Diagnostico SID (AGE)","layer":"false","layout_steps_values":"{}","name":"tberrsiddgn","page":"1","rapp":"","sequence":"25","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"145","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Esiti Ricevute SID (AGE)","layer":"false","layout_steps_values":"{}","name":"tbricevutesid","page":"1","rapp":"","sequence":"26","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"145","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Stati di Nascita (UIF)","layer":"false","layout_steps_values":"{}","name":"tbstatna","page":"1","rapp":"","sequence":"27","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"145","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"S.A.E. (UIF)","layer":"false","layout_steps_values":"{}","name":"tbstgru","page":"1","rapp":"","sequence":"28","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"33","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Province \u002f Regioni (AGE)","layer":"false","layout_steps_values":"{}","name":"tbprvreg","page":"1","rapp":"","sequence":"29","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"173","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Esiti Elaborazione (AGE)","layer":"false","layout_steps_values":"{}","name":"tbesielb","page":"1","rapp":"","sequence":"30","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"173","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Luoghi Nascita (WU)","layer":"false","layout_steps_values":"{}","name":"tbluonas","page":"1","rapp":"","sequence":"31","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"173","zindex":"4","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_tbcitta=tbcitta,w_tbstati=tbstati,w_tbsetsin=tbsetsin,w_tbcauana=tbcauana,w_inter2bo=inter2bo,w_tbvalute=tbvalute,w_tbtipreg=tbtipreg,w_tbtipint=tbtipint,w_tbesitoage=tbesitoage,w_tbrapp=tbrapp,w_tbstgru=tbstgru,w_tbramgru=tbramgru,w_tbtipdoc=tbtipdoc,w_tbtipleg=tbtipleg,w_tbtipnat=tbtipnat,w_tberrorisid=tberrorisid,w_tberrsiddgn=tberrsiddgn,w_tbricevutesid=tbricevutesid,w_tbcittna=tbcittna,w_tbstatna=tbstatna,w_tberrdge=tberrdge,w_tbprvreg=tbprvreg,w_tbesielb=tbesielb,w_convgio=convgio,w_staticrs=staticrs,w_tbcandistr=tbcandistr,w_tbluonas=tbluonas,w_tbprovsv=tbprovsv,w_rapogg=rapogg,w_tbnatura=tbnatura,w_tbscopo=tbscopo,w_tbrisglob=tbrisglob,w_tbident=tbident,w_tbtipope=tbtipope,w_tbprcsched=tbprcsched,w_tbnaturaage=tbnaturaage,w_tblimcon=tblimcon,w_tbaml=tbaml,w_tabellea7=tabellea7,w_tbvasp=tbvasp,w_tbstatisv=tbstatisv,w_tbnindris=tbnindris","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"32","servlet":"arfn_imp_newtabs","target":"","type":"SPLinker","w":"120","x":"1","y":"-67"},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Stati OCSE (CRS)","layer":"false","layout_steps_values":"{}","name":"staticrs","page":"1","rapp":"","sequence":"33","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"201","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Canali Distributivi (SV)","layer":"false","layout_steps_values":"{}","name":"tbcandistr","page":"1","rapp":"","sequence":"34","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"201","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Province (SV)","layer":"false","layout_steps_values":"{}","name":"tbprovsv","page":"1","rapp":"","sequence":"35","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"201","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"ABI+CAB (UIF)","layer":"false","layout_steps_values":"{}","name":"inter2bo","page":"1","rapp":"","sequence":"36","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"33","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Registrazione (UIF)","layer":"false","layout_steps_values":"{}","name":"tbtipreg","page":"1","rapp":"","sequence":"37","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"33","zindex":"4","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"38","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"131","y":"-68"},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"request","label_text":"Città (UIF)","layer":"false","layout_steps_values":"{}","name":"tbcitta","page":"1","rapp":"","sequence":"39","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"33","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"request","label_text":"Stati (UIF)","layer":"false","layout_steps_values":"{}","name":"tbstati","page":"1","rapp":"","sequence":"40","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"61","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Intermediario (UIF)","layer":"false","layout_steps_values":"{}","name":"tbtipint","page":"1","rapp":"","sequence":"41","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"89","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Documento (UIF)","layer":"false","layout_steps_values":"{}","name":"tbtipdoc","page":"1","rapp":"","sequence":"42","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"117","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Errori Esiti SID (AGE)","layer":"false","layout_steps_values":"{}","name":"tberrorisid","page":"1","rapp":"","sequence":"43","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"145","zindex":"4","zone":""},{"calculate":"tbcitta+tbstati+tbtipint+tbtipdoc+tberrorisid+tberrdge+convgio+rapogg","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"varsel1","page":"1","reactive":"","sequence":"44","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"452","y":"-71"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"varsel2","page":"1","reactive":"","sequence":"45","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"536","y":"-71"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"varsel3","page":"1","reactive":"","sequence":"46","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"619","y":"-71"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"varsel4","page":"1","reactive":"","sequence":"47","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"712","y":"-70"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAggTabs","page":"1","reactive":"","sequence":"48","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1016","y":"-44"},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Natura Rapporto","layer":"false","layout_steps_values":"{}","name":"tbnatura","page":"1","rapp":"","sequence":"49","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"229","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Identificazione","layer":"false","layout_steps_values":"{}","name":"tbident","page":"1","rapp":"","sequence":"50","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"257","zindex":"4","zone":""},{"allowedentities":"cp_logout","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTLogout","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"51","servlet":"cp_logout","target":"","type":"SPLinker","w":"120","x":"1014","y":"-14"},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Operazione (AGE)","layer":"false","layout_steps_values":"{}","name":"tbtipope","page":"1","rapp":"","sequence":"52","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"257","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Processi Schedulabili","layer":"false","layout_steps_values":"{}","name":"tbprcsched","page":"1","rapp":"","sequence":"53","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"257","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Natura Valuta (AGE)","layer":"false","layout_steps_values":"{}","name":"tbnaturaage","page":"1","rapp":"","sequence":"54","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"257","zindex":"4","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"h2","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label48","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"55","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"TABELLE AUI E AGE","w":"1000","wireframe_props":"align,value,n_col","x":"0","y":"6","zindex":"5","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"h2","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label48_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"56","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"TABELLE III\u002fIV DIRETTIVA","w":"1000","wireframe_props":"align,value,n_col","x":"0","y":"346","zindex":"5","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Attività","layer":"false","layout_steps_values":"{}","name":"tbtipatt","page":"1","rapp":"","sequence":"57","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"402","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Limite Contante","layer":"false","layout_steps_values":"{}","name":"tblimcon","page":"1","rapp":"","sequence":"58","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"285","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Questionario AML","layer":"false","layout_steps_values":"{}","name":"tbaml","page":"1","rapp":"","sequence":"59","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"285","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tabelle SV A7","layer":"false","layout_steps_values":"{}","name":"tabellea7","page":"1","rapp":"","sequence":"60","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"506","y":"285","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tabelle OAM","layer":"false","layout_steps_values":"{}","name":"tbvasp","page":"1","rapp":"","sequence":"61","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"740","y":"285","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Stati per SV","layer":"false","layout_steps_values":"{}","name":"tbstatisv","page":"1","rapp":"","sequence":"62","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"38","y":"313","zindex":"4","zone":""},{"anchor":"","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tabelle Indici di Rischio","layer":"false","layout_steps_values":"{}","name":"tbnindris","page":"1","rapp":"","sequence":"63","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"220","wireframe_props":"label_text","x":"272","y":"313","zindex":"4","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"64","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"1000","wireframe_props":"","x":"0","y":"461","zindex":"6","zone":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:tbcitta,tbstati*/%>
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
window.pg_imp_newtabs_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Import !='undefined')this.Import=Import;
if(typeof ImportIII !='undefined')this.ImportIII=ImportIII;
if(typeof SelDes !='undefined')this.SelDes=SelDes;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof RTExecIII_Result !='undefined')this.RTExecIII_Result=RTExecIII_Result;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
this.varsel1.Set(this.tbcitta.Value()+this.tbstati.Value()+this.tbtipint.Value()+this.tbtipdoc.Value()+this.tberrorisid.Value()+this.tberrdge.Value()+this.convgio.Value()+this.rapogg.Value());
}
ZtVWeb.InitCtrl("N",this.tberrdge);
ZtVWeb.InitCtrl("N",this.tbtiporisc);
ZtVWeb.InitCtrl("N",this.tbscopo);
ZtVWeb.InitCtrl("N",this.tbareegeog);
ZtVWeb.InitCtrl("N",this.tbramgru);
ZtVWeb.InitCtrl("N",this.tbimporto);
ZtVWeb.InitCtrl("N",this.tbrisglob);
ZtVWeb.InitCtrl("N",this.tbplauso);
ZtVWeb.InitCtrl("N",this.tbvalute);
ZtVWeb.InitCtrl("N",this.tbspecie);
ZtVWeb.InitCtrl("N",this.tbesitoage);
ZtVWeb.InitCtrl("N",this.tbsvolgim);
ZtVWeb.InitCtrl("N",this.tbcondotta);
ZtVWeb.InitCtrl("N",this.convgio);
ZtVWeb.InitCtrl("N",this.tbdurata);
ZtVWeb.InitCtrl("N",this.tbsetsin);
ZtVWeb.InitCtrl("N",this.tbcauana);
ZtVWeb.InitCtrl("N",this.tbrapp);
ZtVWeb.InitCtrl("N",this.rapogg);
ZtVWeb.InitCtrl("N",this.tbtipleg);
ZtVWeb.InitCtrl("N",this.tbtipnat);
ZtVWeb.InitCtrl("N",this.tbcittna);
ZtVWeb.InitCtrl("N",this.tberrsiddgn);
ZtVWeb.InitCtrl("N",this.tbricevutesid);
ZtVWeb.InitCtrl("N",this.tbstatna);
ZtVWeb.InitCtrl("N",this.tbstgru);
ZtVWeb.InitCtrl("N",this.tbprvreg);
ZtVWeb.InitCtrl("N",this.tbesielb);
ZtVWeb.InitCtrl("N",this.tbluonas);
ZtVWeb.InitCtrl("N",this.staticrs);
ZtVWeb.InitCtrl("N",this.tbcandistr);
ZtVWeb.InitCtrl("N",this.tbprovsv);
ZtVWeb.InitCtrl("N",this.inter2bo);
ZtVWeb.InitCtrl("N",this.tbtipreg);
ZtVWeb.InitCtrl("N",this.tbcitta);
ZtVWeb.InitCtrl("N",this.tbstati);
ZtVWeb.InitCtrl("N",this.tbtipint);
ZtVWeb.InitCtrl("N",this.tbtipdoc);
ZtVWeb.InitCtrl("N",this.tberrorisid);
ZtVWeb.InitCtrl("N",this.tbnatura);
ZtVWeb.InitCtrl("N",this.tbident);
ZtVWeb.InitCtrl("N",this.tbtipope);
ZtVWeb.InitCtrl("N",this.tbprcsched);
ZtVWeb.InitCtrl("N",this.tbnaturaage);
ZtVWeb.InitCtrl("N",this.tbtipatt);
ZtVWeb.InitCtrl("N",this.tblimcon);
ZtVWeb.InitCtrl("N",this.tbaml);
ZtVWeb.InitCtrl("N",this.tabellea7);
ZtVWeb.InitCtrl("N",this.tbvasp);
ZtVWeb.InitCtrl("N",this.tbstatisv);
ZtVWeb.InitCtrl("N",this.tbnindris);
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Aggiornamento Tabelle di Base',true);
  this.RTAzzera.Link();
  if (this.gAggTabs.Value()=='N') {
    this.varsel1.Value("NNNNNNNN")
    this.varsel2.Value("NNNNNNNN")
    this.varsel3.Value("NNNNNNNN")
    this.varsel4.Value("NNNNNNNN")
    this.varsel5.Value("NNNNNNNNNN")
    this.getTitlePortlet().AppendButton({
      id:"Importa",
      title:FormatMsg('Importa AUI/AGE'),
      tooltip:FormatMsg('Aggiorna i dati nelle tabelle di base'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
      action:'javascript:' + this.formid +'.Import()'
    },1);      
    this.getTitlePortlet().AppendButton({
      id:"ImportaIII",
      title:FormatMsg('Importa III/IV'),
      tooltip:FormatMsg('Aggiorna i dati delle tabelle della III/IV Direttiva'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
      action:'javascript:' + this.formid +'.ImportIII()'
    },2);          
    this.getTitlePortlet().AppendButton({
      id:"SelDes",
      title:FormatMsg('Seleziona/Deselezione'),
      tooltip:FormatMsg('Seleziona/Deseleziona le tabelle'),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
      action:'javascript:' + this.formid +'.SelDes()'
    },3);      
  } else {
    this.SelDes();   
    alert("Necessario aggiornamento tabelle di base")
    this.PortletLogs.Start();
    this.RTExec.Link();    
  }  
}
function Import(){
  if (confirm("Confermi l'aggiornamento delle tabelle di base?")) {
    this.PortletLogs.Start();
    this.RTExec.Link();
  }    
}
function ImportIII(){
  if (confirm("Confermi l'aggiornamento delle tabelle della III/IV Direttiva?")) {
    this.PortletLogs.Start();
    this.RTExecIII.Link();
  }    
}
function SelDes(){
  if(At("S",this.varsel1.Value()) > 0) {
    this.convgio.Value("N")
    this.inter2bo.Value("N")                   
    this.rapogg.Value("N")                       
    this.staticrs.Value("N")    
    this.tbcandistr.Value("N")
    this.tbcauana.Value("N")
    this.tbcitta.Value("N")
    this.tbcittna.Value("N")
    this.tberrdge.Value("N")                   
    this.tberrorisid.Value("N")    
    this.tberrsiddgn.Value("N")
    this.tbesielb.Value("N")                       
    this.tbesitoage.Value("N")
    this.tbluonas.Value("N")
    this.tbprovsv.Value("N")
    this.tbprvreg.Value("N")
    this.tbramgru.Value("N")
    this.tbrapp.Value("N")
    this.tbricevutesid.Value("N")
    this.tbsetsin.Value("N")
    this.tbstati.Value("N")
    this.tbstatna.Value("N")
    this.tbstgru.Value("N")
    this.tbtipdoc.Value("N")
    this.tbtipint.Value("N")
    this.tbtipleg.Value("N") 
    this.tbtipnat.Value("N")                       
    this.tbtipreg.Value("N")                       
    this.tbvalute.Value("N") 
    this.tbnatura.Value("N")
    this.tbscopo.Value("N")    
    this.tbrisglob.Value("N")    
    this.tbident.Value("N")    
    this.tbtipope.Value("N")
    this.tbprcsched.Value("N")
    this.tbnaturaage.Value("N")
    this.tblimcon.Value("N")
    this.tbaml.Value("N")
    this.tabellea7.Value("N")
    this.tbvasp.Value("N")
    this.tbstatisv.Value("N")
    this.tbnindris.Value("N")
    this.varsel1.Value("NNNNNNNN")
    this.varsel2.Value("NNNNNNNN")
    this.varsel3.Value("NNNNNNNN")
    this.varsel4.Value("NNNNNNNN")    
    this.varsel5.Value("NNNNNNNNNN")
  } else {
    this.convgio.Value("S")
    this.inter2bo.Value("S")                   
    this.rapogg.Value("S")                       
    this.staticrs.Value("S")    
    this.tbcandistr.Value("S")
    this.tbcauana.Value("S")
    this.tbcitta.Value("S")
    this.tbcittna.Value("S")
    this.tberrdge.Value("S")                   
    this.tberrorisid.Value("S")
    this.tberrsiddgn.Value("S")
    this.tbesielb.Value("S")                       
    this.tbesitoage.Value("S")
    this.tbluonas.Value("S")
    this.tbprovsv.Value("S")
    this.tbprvreg.Value("S")
    this.tbramgru.Value("S")
    this.tbrapp.Value("S")
    this.tbricevutesid.Value("S")
    this.tbsetsin.Value("S")
    this.tbstati.Value("S")
    this.tbstatna.Value("S")
    this.tbstgru.Value("S")    
    this.tbtipdoc.Value("S")
    this.tbtipint.Value("S")
    this.tbtipleg.Value("S") 
    this.tbtipnat.Value("S")                       
    this.tbtipreg.Value("S")                       
    this.tbvalute.Value("S")    
    this.tbnatura.Value("S")
    this.tbscopo.Value("S")    
    this.tbrisglob.Value("S")        
    this.tbident.Value("S")  
    this.tbtipope.Value("S")
    this.tbprcsched.Value("S")
    this.tbnaturaage.Value("S")
    this.tblimcon.Value("S")    
    this.tbaml.Value("S") 
    this.tabellea7.Value("S")    
    this.tbvasp.Value("S")
    this.tbstatisv.Value("S")
    this.tbnindris.Value("S")
    this.varsel1.Value("SSSSSSSS")
    this.varsel2.Value("SSSSSSSS")    
    this.varsel3.Value("SSSSSSSS")        
    this.varsel4.Value("SSSSSSSS")        
    this.varsel5.Value("SSSSSSSSSS")            
  }  
}
function RTExec_Result(result){
  if (this.gAggTabs.Value()=='S') {
    alert("Aggiornamento Tabelle di Base Completato!")
    this.PortletLogs.Stop();
    this.RTLogout.Link();
  }  
}
function RTExecIII_Result(result){
  alert("Aggiornamento Tabelle III/IV Direttiva Completato!")
  this.PortletLogs.Stop();  
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
.pg_imp_newtabs_container {
  height:100%;
  overflow:auto;
}
.pg_imp_newtabs_title_container {
  margin: auto;
}
.pg_imp_newtabs_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1000px;
  height:100%;
  background-color:#FFFFFF;
}
.pg_imp_newtabs_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_imp_newtabs_portlet > .tberrdge_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:173px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtiporisc_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:402px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbscopo_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:229px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbareegeog_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:374px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbramgru_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:61px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbimporto_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:402px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbrisglob_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:229px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbplauso_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:374px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbvalute_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:61px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbspecie_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:374px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbesitoage_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:61px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbsvolgim_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:374px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbcondotta_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:402px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .convgio_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:201px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbdurata_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:430px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbsetsin_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:89px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbcauana_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:89px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbrapp_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:89px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .rapogg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:229px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtipleg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:117px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtipnat_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:117px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbcittna_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:117px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tberrsiddgn_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:145px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbricevutesid_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:145px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbstatna_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:145px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbstgru_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:33px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbprvreg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:173px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbesielb_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:173px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbluonas_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:173px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .staticrs_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:201px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbcandistr_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:201px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbprovsv_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:201px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .inter2bo_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:33px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtipreg_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:33px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbcitta_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:33px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbstati_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:61px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtipint_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:89px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtipdoc_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:117px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tberrorisid_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:145px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbnatura_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:229px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbident_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:257px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbtipope_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:257px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbprcsched_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:257px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbnaturaage_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:257px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .Label48_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:6px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_imp_newtabs_portlet > .Label48_ctrl {
  height:auto;
  min-height:20px;
}
.pg_imp_newtabs_portlet > .Label48_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_imp_newtabs_portlet > .Label48_Copy_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:346px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_imp_newtabs_portlet > .Label48_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_imp_newtabs_portlet > .Label48_Copy_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_imp_newtabs_portlet > .tbtipatt_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:402px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tblimcon_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:285px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbaml_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:285px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tabellea7_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:285px;
  left:506px;
  left:50.6%;
  right:274px;
  right:27.4%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbvasp_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:285px;
  left:740px;
  left:74.0%;
  right:40px;
  right:4.0%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbstatisv_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:313px;
  left:38px;
  left:3.8%;
  right:742px;
  right:74.2%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .tbnindris_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:313px;
  left:272px;
  left:27.2%;
  right:508px;
  right:50.8%;
  width:auto;
  height:20px;
}
.pg_imp_newtabs_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:461px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:-1px;
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
 String def="[{\"h\":\"550\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1000\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Errori Esiti Saldi (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"173\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Rischio\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"402\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Scopo Rapporto\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"229\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Aree Geografiche\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"374\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"R.A.E. (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"61\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Importo\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"402\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Rischio Globale\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"229\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Plauso\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"374\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Valute (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"61\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Specie Giuridica\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"374\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Esiti Age (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"61\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Svolgimento\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"374\",\"zindex\":\"4\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"798\",\"y\":\"-70\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Condotta\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"402\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Conversione Tipi Gioco (CGO)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"201\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Durata\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"430\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Settori Sintetici (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"89\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Causali (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"89\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipi Rapporto (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"89\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Rapporti Oggettivi (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"229\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Legame (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"117\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1011\",\"y\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Natura Conti (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"117\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Città di Nascita (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"117\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Errori Diagnostico SID (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"145\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Esiti Ricevute SID (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"145\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stati di Nascita (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"145\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"S.A.E. (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"33\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Province \\u002f Regioni (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"173\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Esiti Elaborazione (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"173\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Luoghi Nascita (WU)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"173\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stati OCSE (CRS)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"201\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Canali Distributivi (SV)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"201\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Province (SV)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"201\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"ABI+CAB (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"33\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Registrazione (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"33\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"131\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Città (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"33\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stati (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"61\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Intermediario (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"89\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Documento (UIF)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"117\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Errori Esiti SID (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"145\",\"zindex\":\"4\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"452\",\"y\":\"-71\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"536\",\"y\":\"-71\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"619\",\"y\":\"-71\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"712\",\"y\":\"-70\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1016\",\"y\":\"-44\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Natura Rapporto\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"229\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Identificazione\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"257\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1014\",\"y\":\"-14\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Operazione (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"257\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Processi Schedulabili\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"257\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Natura Valuta (AGE)\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"257\",\"zindex\":\"4\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"TABELLE AUI E AGE\",\"w\":\"1000\",\"x\":\"0\",\"y\":\"6\",\"zindex\":\"5\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"TABELLE III\\u002fIV DIRETTIVA\",\"w\":\"1000\",\"x\":\"0\",\"y\":\"346\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Attività\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"402\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Limite Contante\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"285\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Questionario AML\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"285\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tabelle SV A7\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"506\",\"y\":\"285\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tabelle OAM\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"740\",\"y\":\"285\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Stati per SV\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"38\",\"y\":\"313\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tabelle Indici di Rischio\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"220\",\"x\":\"272\",\"y\":\"313\",\"zindex\":\"4\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1000\",\"x\":\"0\",\"y\":\"461\",\"zindex\":\"6\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_imp_newtabs","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_imp_newtabs_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_imp_newtabs','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String tberrdge="N";
String tbtiporisc="N";
String tbscopo="N";
String tbareegeog="N";
String tbramgru="N";
String tbimporto="N";
String tbrisglob="N";
String tbplauso="N";
String tbvalute="N";
String tbspecie="N";
String tbesitoage="N";
String tbsvolgim="N";
String varsel5= "";
String tbcondotta="N";
String convgio="N";
String tbdurata="N";
String tbsetsin="N";
String tbcauana="N";
String tbrapp="N";
String rapogg="N";
String tbtipleg="N";
String tbtipnat="N";
String tbcittna="N";
String tberrsiddgn="N";
String tbricevutesid="N";
String tbstatna="N";
String tbstgru="N";
String tbprvreg="N";
String tbesielb="N";
String tbluonas="N";
String staticrs="N";
String tbcandistr="N";
String tbprovsv="N";
String inter2bo="N";
String tbtipreg="N";
String tbcitta=JSPLib.translateXSS(sp.getParameter("tbcitta",""));
String tbstati=JSPLib.translateXSS(sp.getParameter("tbstati",""));
String tbtipint="N";
String tbtipdoc="N";
String tberrorisid="N";
String varsel1= "";
String varsel2= "";
String varsel3= "";
String varsel4= "";
String gAggTabs=sp.getGlobal("gAggTabs","");
String tbnatura="N";
String tbident="N";
String tbtipope="N";
String tbprcsched="N";
String tbnaturaage="N";
String Label48= "TABELLE AUI E AGE";
String Label48_Copy= "TABELLE III/IV DIRETTIVA";
String tbtipatt="N";
String tblimcon="N";
String tbaml="N";
String tabellea7="N";
String tbvasp="N";
String tbstatisv="N";
String tbnindris="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_imp_newtabs_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_imp_newtabs_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_imp_newtabs_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_imp_newtabs','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_tberrdge_div' style=''><input id='<%=idPortlet%>_tberrdge' name='tberrdge' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tberrdge' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Errori Esiti Saldi (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbtiporisc_div' style=''><input id='<%=idPortlet%>_tbtiporisc' name='tbtiporisc' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtiporisc' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Rischio")%></label></div>
<div id='<%=idPortlet%>_tbscopo_div' style=''><input id='<%=idPortlet%>_tbscopo' name='tbscopo' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbscopo' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Scopo Rapporto")%></label></div>
<div id='<%=idPortlet%>_tbareegeog_div' style=''><input id='<%=idPortlet%>_tbareegeog' name='tbareegeog' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbareegeog' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Aree Geografiche")%></label></div>
<div id='<%=idPortlet%>_tbramgru_div' style=''><input id='<%=idPortlet%>_tbramgru' name='tbramgru' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbramgru' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("R.A.E. (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbimporto_div' style=''><input id='<%=idPortlet%>_tbimporto' name='tbimporto' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbimporto' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Importo")%></label></div>
<div id='<%=idPortlet%>_tbrisglob_div' style=''><input id='<%=idPortlet%>_tbrisglob' name='tbrisglob' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbrisglob' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Rischio Globale")%></label></div>
<div id='<%=idPortlet%>_tbplauso_div' style=''><input id='<%=idPortlet%>_tbplauso' name='tbplauso' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbplauso' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Plauso")%></label></div>
<div id='<%=idPortlet%>_tbvalute_div' style=''><input id='<%=idPortlet%>_tbvalute' name='tbvalute' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbvalute' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Valute (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbspecie_div' style=''><input id='<%=idPortlet%>_tbspecie' name='tbspecie' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbspecie' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Specie Giuridica")%></label></div>
<div id='<%=idPortlet%>_tbesitoage_div' style=''><input id='<%=idPortlet%>_tbesitoage' name='tbesitoage' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbesitoage' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Esiti Age (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbsvolgim_div' style=''><input id='<%=idPortlet%>_tbsvolgim' name='tbsvolgim' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbsvolgim' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Svolgimento")%></label></div>
<div id='<%=idPortlet%>_tbcondotta_div' style=''><input id='<%=idPortlet%>_tbcondotta' name='tbcondotta' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbcondotta' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Condotta")%></label></div>
<div id='<%=idPortlet%>_convgio_div' style=''><input id='<%=idPortlet%>_convgio' name='convgio' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_convgio' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Conversione Tipi Gioco (CGO)")%></label></div>
<div id='<%=idPortlet%>_tbdurata_div' style=''><input id='<%=idPortlet%>_tbdurata' name='tbdurata' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbdurata' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Durata")%></label></div>
<div id='<%=idPortlet%>_tbsetsin_div' style=''><input id='<%=idPortlet%>_tbsetsin' name='tbsetsin' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbsetsin' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Settori Sintetici (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbcauana_div' style=''><input id='<%=idPortlet%>_tbcauana' name='tbcauana' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbcauana' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Causali (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbrapp_div' style=''><input id='<%=idPortlet%>_tbrapp' name='tbrapp' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbrapp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipi Rapporto (AGE)")%></label></div>
<div id='<%=idPortlet%>_rapogg_div' style=''><input id='<%=idPortlet%>_rapogg' name='rapogg' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_rapogg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Rapporti Oggettivi (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbtipleg_div' style=''><input id='<%=idPortlet%>_tbtipleg' name='tbtipleg' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipleg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Legame (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbtipnat_div' style=''><input id='<%=idPortlet%>_tbtipnat' name='tbtipnat' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipnat' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Natura Conti (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbcittna_div' style=''><input id='<%=idPortlet%>_tbcittna' name='tbcittna' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbcittna' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Città di Nascita (UIF)")%></label></div>
<div id='<%=idPortlet%>_tberrsiddgn_div' style=''><input id='<%=idPortlet%>_tberrsiddgn' name='tberrsiddgn' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tberrsiddgn' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Errori Diagnostico SID (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbricevutesid_div' style=''><input id='<%=idPortlet%>_tbricevutesid' name='tbricevutesid' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbricevutesid' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Esiti Ricevute SID (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbstatna_div' style=''><input id='<%=idPortlet%>_tbstatna' name='tbstatna' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbstatna' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stati di Nascita (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbstgru_div' style=''><input id='<%=idPortlet%>_tbstgru' name='tbstgru' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbstgru' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("S.A.E. (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbprvreg_div' style=''><input id='<%=idPortlet%>_tbprvreg' name='tbprvreg' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbprvreg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Province / Regioni (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbesielb_div' style=''><input id='<%=idPortlet%>_tbesielb' name='tbesielb' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbesielb' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Esiti Elaborazione (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbluonas_div' style=''><input id='<%=idPortlet%>_tbluonas' name='tbluonas' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbluonas' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Luoghi Nascita (WU)")%></label></div>
<div id='<%=idPortlet%>_staticrs_div' style=''><input id='<%=idPortlet%>_staticrs' name='staticrs' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_staticrs' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stati OCSE (CRS)")%></label></div>
<div id='<%=idPortlet%>_tbcandistr_div' style=''><input id='<%=idPortlet%>_tbcandistr' name='tbcandistr' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbcandistr' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Canali Distributivi (SV)")%></label></div>
<div id='<%=idPortlet%>_tbprovsv_div' style=''><input id='<%=idPortlet%>_tbprovsv' name='tbprovsv' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbprovsv' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Province (SV)")%></label></div>
<div id='<%=idPortlet%>_inter2bo_div' style=''><input id='<%=idPortlet%>_inter2bo' name='inter2bo' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_inter2bo' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("ABI+CAB (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbtipreg_div' style=''><input id='<%=idPortlet%>_tbtipreg' name='tbtipreg' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipreg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Registrazione (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbcitta_div' style=''><input id='<%=idPortlet%>_tbcitta' name='tbcitta' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbcitta' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Città (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbstati_div' style=''><input id='<%=idPortlet%>_tbstati' name='tbstati' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbstati' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stati (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbtipint_div' style=''><input id='<%=idPortlet%>_tbtipint' name='tbtipint' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipint' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Intermediario (UIF)")%></label></div>
<div id='<%=idPortlet%>_tbtipdoc_div' style=''><input id='<%=idPortlet%>_tbtipdoc' name='tbtipdoc' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipdoc' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Documento (UIF)")%></label></div>
<div id='<%=idPortlet%>_tberrorisid_div' style=''><input id='<%=idPortlet%>_tberrorisid' name='tberrorisid' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tberrorisid' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Errori Esiti SID (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbnatura_div' style=''><input id='<%=idPortlet%>_tbnatura' name='tbnatura' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbnatura' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Natura Rapporto")%></label></div>
<div id='<%=idPortlet%>_tbident_div' style=''><input id='<%=idPortlet%>_tbident' name='tbident' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbident' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Identificazione")%></label></div>
<div id='<%=idPortlet%>_tbtipope_div' style=''><input id='<%=idPortlet%>_tbtipope' name='tbtipope' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipope' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Operazione (AGE)")%></label></div>
<div id='<%=idPortlet%>_tbprcsched_div' style=''><input id='<%=idPortlet%>_tbprcsched' name='tbprcsched' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbprcsched' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Processi Schedulabili")%></label></div>
<div id='<%=idPortlet%>_tbnaturaage_div' style=''><input id='<%=idPortlet%>_tbnaturaage' name='tbnaturaage' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbnaturaage' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Natura Valuta (AGE)")%></label></div>
<span id='<%=idPortlet%>_Label48'  formid='<%=idPortlet%>' ps-name='Label48'    class='label Label48_ctrl'><div id='<%=idPortlet%>_Label48tbl' style='width:100%;'><h2><%=JSPLib.ToHTML("TABELLE AUI E AGE")%></h2></div></span>
<span id='<%=idPortlet%>_Label48_Copy'  formid='<%=idPortlet%>' ps-name='Label48_Copy'    class='label Label48_Copy_ctrl'><div id='<%=idPortlet%>_Label48_Copytbl' style='width:100%;'><h2><%=JSPLib.ToHTML("TABELLE III/IV DIRETTIVA")%></h2></div></span>
<div id='<%=idPortlet%>_tbtipatt_div' style=''><input id='<%=idPortlet%>_tbtipatt' name='tbtipatt' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbtipatt' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Attività")%></label></div>
<div id='<%=idPortlet%>_tblimcon_div' style=''><input id='<%=idPortlet%>_tblimcon' name='tblimcon' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tblimcon' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Limite Contante")%></label></div>
<div id='<%=idPortlet%>_tbaml_div' style=''><input id='<%=idPortlet%>_tbaml' name='tbaml' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbaml' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Questionario AML")%></label></div>
<div id='<%=idPortlet%>_tabellea7_div' style=''><input id='<%=idPortlet%>_tabellea7' name='tabellea7' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tabellea7' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tabelle SV A7")%></label></div>
<div id='<%=idPortlet%>_tbvasp_div' style=''><input id='<%=idPortlet%>_tbvasp' name='tbvasp' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbvasp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tabelle OAM")%></label></div>
<div id='<%=idPortlet%>_tbstatisv_div' style=''><input id='<%=idPortlet%>_tbstatisv' name='tbstatisv' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbstatisv' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Stati per SV")%></label></div>
<div id='<%=idPortlet%>_tbnindris_div' style=''><input id='<%=idPortlet%>_tbnindris' name='tbnindris' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tbnindris' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tabelle Indici di Rischio")%></label></div>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_imp_newtabs');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Aggiorna i dati delle tabelle della III/IV Direttiva",true)+","+JSPLib.ToJSValue(sp.translate("Aggiorna i dati delle tabelle della III/IV Direttiva"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Aggiorna i dati nelle tabelle di base",true)+","+JSPLib.ToJSValue(sp.translate("Aggiorna i dati nelle tabelle di base"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Importa AUI/AGE",true)+","+JSPLib.ToJSValue(sp.translate("Importa AUI/AGE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Importa III/IV",true)+","+JSPLib.ToJSValue(sp.translate("Importa III/IV"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Seleziona/Deseleziona le tabelle",true)+","+JSPLib.ToJSValue(sp.translate("Seleziona/Deseleziona le tabelle"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Seleziona/Deselezione",true)+","+JSPLib.ToJSValue(sp.translate("Seleziona/Deselezione"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_imp_newtabs',["1000"],["550"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1000","h":"550","title":"","layer":""}]);
this.tberrdge=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tberrdge","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Errori Esiti Saldi (AGE)","layer":false,"layout_steps_values":{},"name":"tberrdge","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":173,"zindex":"4"});
this.tberrdge.Value('<%=tberrdge%>');
this.tbtiporisc=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtiporisc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Rischio","layer":false,"layout_steps_values":{},"name":"tbtiporisc","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":402,"zindex":"4"});
this.tbtiporisc.Value('<%=tbtiporisc%>');
this.tbscopo=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbscopo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Scopo Rapporto","layer":false,"layout_steps_values":{},"name":"tbscopo","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":229,"zindex":"4"});
this.tbscopo.Value('<%=tbscopo%>');
this.tbareegeog=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbareegeog","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Aree Geografiche","layer":false,"layout_steps_values":{},"name":"tbareegeog","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":374,"zindex":"4"});
this.tbareegeog.Value('<%=tbareegeog%>');
this.tbramgru=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbramgru","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"R.A.E. (UIF)","layer":false,"layout_steps_values":{},"name":"tbramgru","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":61,"zindex":"4"});
this.tbramgru.Value('<%=tbramgru%>');
this.tbimporto=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbimporto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Importo","layer":false,"layout_steps_values":{},"name":"tbimporto","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":402,"zindex":"4"});
this.tbimporto.Value('<%=tbimporto%>');
this.tbrisglob=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbrisglob","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Rischio Globale","layer":false,"layout_steps_values":{},"name":"tbrisglob","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":229,"zindex":"4"});
this.tbrisglob.Value('<%=tbrisglob%>');
this.tbplauso=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbplauso","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Plauso","layer":false,"layout_steps_values":{},"name":"tbplauso","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":374,"zindex":"4"});
this.tbplauso.Value('<%=tbplauso%>');
this.tbvalute=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbvalute","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Valute (UIF)","layer":false,"layout_steps_values":{},"name":"tbvalute","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":61,"zindex":"4"});
this.tbvalute.Value('<%=tbvalute%>');
this.tbspecie=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbspecie","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Specie Giuridica","layer":false,"layout_steps_values":{},"name":"tbspecie","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":374,"zindex":"4"});
this.tbspecie.Value('<%=tbspecie%>');
this.tbesitoage=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbesitoage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Esiti Age (AGE)","layer":false,"layout_steps_values":{},"name":"tbesitoage","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":61,"zindex":"4"});
this.tbesitoage.Value('<%=tbesitoage%>');
this.tbsvolgim=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbsvolgim","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Svolgimento","layer":false,"layout_steps_values":{},"name":"tbsvolgim","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":374,"zindex":"4"});
this.tbsvolgim.Value('<%=tbsvolgim%>');
this.varsel5=new ZtVWeb._VC(this,'varsel5',null,'character','<%=JSPLib.ToJSValue(varsel5,false,true)%>',false,false);
this.tbcondotta=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbcondotta","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Condotta","layer":false,"layout_steps_values":{},"name":"tbcondotta","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":402,"zindex":"4"});
this.tbcondotta.Value('<%=tbcondotta%>');
this.convgio=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_convgio","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Conversione Tipi Gioco (CGO)","layer":false,"layout_steps_values":{},"name":"convgio","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":201,"zindex":"4"});
this.convgio.Value('<%=convgio%>');
this.tbdurata=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbdurata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Durata","layer":false,"layout_steps_values":{},"name":"tbdurata","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":430,"zindex":"4"});
this.tbdurata.Value('<%=tbdurata%>');
this.tbsetsin=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbsetsin","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Settori Sintetici (UIF)","layer":false,"layout_steps_values":{},"name":"tbsetsin","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":89,"zindex":"4"});
this.tbsetsin.Value('<%=tbsetsin%>');
this.tbcauana=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbcauana","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Causali (UIF)","layer":false,"layout_steps_values":{},"name":"tbcauana","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":89,"zindex":"4"});
this.tbcauana.Value('<%=tbcauana%>');
this.tbrapp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbrapp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipi Rapporto (AGE)","layer":false,"layout_steps_values":{},"name":"tbrapp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":89,"zindex":"4"});
this.tbrapp.Value('<%=tbrapp%>');
this.rapogg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_rapogg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Rapporti Oggettivi (UIF)","layer":false,"layout_steps_values":{},"name":"rapogg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":229,"zindex":"4"});
this.rapogg.Value('<%=rapogg%>');
this.tbtipleg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipleg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Legame (UIF)","layer":false,"layout_steps_values":{},"name":"tbtipleg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":117,"zindex":"4"});
this.tbtipleg.Value('<%=tbtipleg%>');
this.RTExecIII=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_import_3dce",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExecIII","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExecIII","offline":false,"page":1,"parms":"w_tbareegeog=tbareegeog,w_tbspecie=tbspecie,w_tbtiporisc=tbtiporisc,w_tbsvolgim=tbsvolgim,w_tbcondotta=tbcondotta,w_tbimporto=tbimporto,w_tbdurata=tbdurata,w_tbplauso=tbplauso,w_tbtipatt=tbtipatt","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_import_3dce","target":"","type":"SPLinker","w":120,"x":1011,"y":8});
this.RTExecIII.m_cID='<%=JSPLib.cmdHash("routine,arfn_import_3dce",request.getSession())%>';
this.tbtipnat=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipnat","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Natura Conti (AGE)","layer":false,"layout_steps_values":{},"name":"tbtipnat","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":117,"zindex":"4"});
this.tbtipnat.Value('<%=tbtipnat%>');
this.tbcittna=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbcittna","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Città di Nascita (UIF)","layer":false,"layout_steps_values":{},"name":"tbcittna","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":117,"zindex":"4"});
this.tbcittna.Value('<%=tbcittna%>');
this.tberrsiddgn=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tberrsiddgn","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Errori Diagnostico SID (AGE)","layer":false,"layout_steps_values":{},"name":"tberrsiddgn","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":145,"zindex":"4"});
this.tberrsiddgn.Value('<%=tberrsiddgn%>');
this.tbricevutesid=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbricevutesid","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Esiti Ricevute SID (AGE)","layer":false,"layout_steps_values":{},"name":"tbricevutesid","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":145,"zindex":"4"});
this.tbricevutesid.Value('<%=tbricevutesid%>');
this.tbstatna=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbstatna","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Stati di Nascita (UIF)","layer":false,"layout_steps_values":{},"name":"tbstatna","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":145,"zindex":"4"});
this.tbstatna.Value('<%=tbstatna%>');
this.tbstgru=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbstgru","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"S.A.E. (UIF)","layer":false,"layout_steps_values":{},"name":"tbstgru","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":33,"zindex":"4"});
this.tbstgru.Value('<%=tbstgru%>');
this.tbprvreg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbprvreg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Province \u002f Regioni (AGE)","layer":false,"layout_steps_values":{},"name":"tbprvreg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":173,"zindex":"4"});
this.tbprvreg.Value('<%=tbprvreg%>');
this.tbesielb=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbesielb","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Esiti Elaborazione (AGE)","layer":false,"layout_steps_values":{},"name":"tbesielb","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":173,"zindex":"4"});
this.tbesielb.Value('<%=tbesielb%>');
this.tbluonas=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbluonas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Luoghi Nascita (WU)","layer":false,"layout_steps_values":{},"name":"tbluonas","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":173,"zindex":"4"});
this.tbluonas.Value('<%=tbluonas%>');
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_tbcitta=tbcitta,w_tbstati=tbstati,w_tbsetsin=tbsetsin,w_tbcauana=tbcauana,w_inter2bo=inter2bo,w_tbvalute=tbvalute,w_tbtipreg=tbtipreg,w_tbtipint=tbtipint,w_tbesitoage=tbesitoage,w_tbrapp=tbrapp,w_tbstgru=tbstgru,w_tbramgru=tbramgru,w_tbtipdoc=tbtipdoc,w_tbtipleg=tbtipleg,w_tbtipnat=tbtipnat,w_tberrorisid=tberrorisid,w_tberrsiddgn=tberrsiddgn,w_tbricevutesid=tbricevutesid,w_tbcittna=tbcittna,w_tbstatna=tbstatna,w_tberrdge=tberrdge,w_tbprvreg=tbprvreg,w_tbesielb=tbesielb,w_convgio=convgio,w_staticrs=staticrs,w_tbcandistr=tbcandistr,w_tbluonas=tbluonas,w_tbprovsv=tbprovsv,w_rapogg=rapogg,w_tbnatura=tbnatura,w_tbscopo=tbscopo,w_tbrisglob=tbrisglob,w_tbident=tbident,w_tbtipope=tbtipope,w_tbprcsched=tbprcsched,w_tbnaturaage=tbnaturaage,w_tblimcon=tblimcon,w_tbaml=tbaml,w_tabellea7=tabellea7,w_tbvasp=tbvasp,w_tbstatisv=tbstatisv,w_tbnindris=tbnindris","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_imp_newtabs","target":"","type":"SPLinker","w":120,"x":1,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_imp_newtabs",request.getSession())%>';
this.staticrs=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_staticrs","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Stati OCSE (CRS)","layer":false,"layout_steps_values":{},"name":"staticrs","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":201,"zindex":"4"});
this.staticrs.Value('<%=staticrs%>');
this.tbcandistr=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbcandistr","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Canali Distributivi (SV)","layer":false,"layout_steps_values":{},"name":"tbcandistr","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":201,"zindex":"4"});
this.tbcandistr.Value('<%=tbcandistr%>');
this.tbprovsv=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbprovsv","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Province (SV)","layer":false,"layout_steps_values":{},"name":"tbprovsv","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":201,"zindex":"4"});
this.tbprovsv.Value('<%=tbprovsv%>');
this.inter2bo=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_inter2bo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"ABI+CAB (UIF)","layer":false,"layout_steps_values":{},"name":"inter2bo","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":33,"zindex":"4"});
this.inter2bo.Value('<%=inter2bo%>');
this.tbtipreg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipreg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Registrazione (UIF)","layer":false,"layout_steps_values":{},"name":"tbtipreg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":33,"zindex":"4"});
this.tbtipreg.Value('<%=tbtipreg%>');
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":131,"y":-68});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.tbcitta=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbcitta","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"request","label_text":"Città (UIF)","layer":false,"layout_steps_values":{},"name":"tbcitta","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":33,"zindex":"4"});
this.tbcitta.Value('<%=tbcitta%>');
this.tbstati=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbstati","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"request","label_text":"Stati (UIF)","layer":false,"layout_steps_values":{},"name":"tbstati","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":61,"zindex":"4"});
this.tbstati.Value('<%=tbstati%>');
this.tbtipint=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipint","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Intermediario (UIF)","layer":false,"layout_steps_values":{},"name":"tbtipint","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":89,"zindex":"4"});
this.tbtipint.Value('<%=tbtipint%>');
this.tbtipdoc=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipdoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Documento (UIF)","layer":false,"layout_steps_values":{},"name":"tbtipdoc","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":117,"zindex":"4"});
this.tbtipdoc.Value('<%=tbtipdoc%>');
this.tberrorisid=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tberrorisid","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Errori Esiti SID (AGE)","layer":false,"layout_steps_values":{},"name":"tberrorisid","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":145,"zindex":"4"});
this.tberrorisid.Value('<%=tberrorisid%>');
this.varsel1=new ZtVWeb._VC(this,'varsel1',null,'character','<%=JSPLib.ToJSValue(varsel1,false,true)%>',false,false);
this.varsel2=new ZtVWeb._VC(this,'varsel2',null,'character','<%=JSPLib.ToJSValue(varsel2,false,true)%>',false,false);
this.varsel3=new ZtVWeb._VC(this,'varsel3',null,'character','<%=JSPLib.ToJSValue(varsel3,false,true)%>',false,false);
this.varsel4=new ZtVWeb._VC(this,'varsel4',null,'character','<%=JSPLib.ToJSValue(varsel4,false,true)%>',false,false);
this.gAggTabs=new ZtVWeb._VC(this,'gAggTabs',null,'character','<%=JSPLib.ToJSValue(gAggTabs,false,true)%>',false,false);
this.tbnatura=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbnatura","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Natura Rapporto","layer":false,"layout_steps_values":{},"name":"tbnatura","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":229,"zindex":"4"});
this.tbnatura.Value('<%=tbnatura%>');
this.tbident=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbident","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Identificazione","layer":false,"layout_steps_values":{},"name":"tbident","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":257,"zindex":"4"});
this.tbident.Value('<%=tbident%>');
this.RTLogout=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("cp_logout",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTLogout","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTLogout","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"cp_logout","target":"","type":"SPLinker","w":120,"x":1014,"y":-14});
this.RTLogout.m_cID='<%=JSPLib.cmdHash("routine,cp_logout",request.getSession())%>';
this.tbtipope=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Operazione (AGE)","layer":false,"layout_steps_values":{},"name":"tbtipope","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":257,"zindex":"4"});
this.tbtipope.Value('<%=tbtipope%>');
this.tbprcsched=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbprcsched","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Processi Schedulabili","layer":false,"layout_steps_values":{},"name":"tbprcsched","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":257,"zindex":"4"});
this.tbprcsched.Value('<%=tbprcsched%>');
this.tbnaturaage=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbnaturaage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Natura Valuta (AGE)","layer":false,"layout_steps_values":{},"name":"tbnaturaage","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":257,"zindex":"4"});
this.tbnaturaage.Value('<%=tbnaturaage%>');
this.Label48=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label48","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"h2","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label48","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label48,false,true)%>","type":"Label","w":1000,"x":0,"y":6,"zindex":"5"});
this.Label48_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label48_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"h2","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label48_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label48_Copy,false,true)%>","type":"Label","w":1000,"x":0,"y":346,"zindex":"5"});
this.tbtipatt=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbtipatt","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tipo Attività","layer":false,"layout_steps_values":{},"name":"tbtipatt","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":402,"zindex":"4"});
this.tbtipatt.Value('<%=tbtipatt%>');
this.tblimcon=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tblimcon","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Limite Contante","layer":false,"layout_steps_values":{},"name":"tblimcon","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":285,"zindex":"4"});
this.tblimcon.Value('<%=tblimcon%>');
this.tbaml=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbaml","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Questionario AML","layer":false,"layout_steps_values":{},"name":"tbaml","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":285,"zindex":"4"});
this.tbaml.Value('<%=tbaml%>');
this.tabellea7=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tabellea7","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tabelle SV A7","layer":false,"layout_steps_values":{},"name":"tabellea7","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":506,"y":285,"zindex":"4"});
this.tabellea7.Value('<%=tabellea7%>');
this.tbvasp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbvasp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tabelle OAM","layer":false,"layout_steps_values":{},"name":"tbvasp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":740,"y":285,"zindex":"4"});
this.tbvasp.Value('<%=tbvasp%>');
this.tbstatisv=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbstatisv","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Stati per SV","layer":false,"layout_steps_values":{},"name":"tbstatisv","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":38,"y":313,"zindex":"4"});
this.tbstatisv.Value('<%=tbstatisv%>');
this.tbnindris=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"\"N\"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tbnindris","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Tabelle Indici di Rischio","layer":false,"layout_steps_values":{},"name":"tbnindris","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":220,"x":272,"y":313,"zindex":"4"});
this.tbnindris.Value('<%=tbnindris%>');
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":1000,"x":0,"y":461,"zindex":"6"});
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
<%if(request.getAttribute("pg_imp_newtabs_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_imp_newtabs_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_imp_newtabs_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_imp_newtabs',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_imp_newtabs');
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
sp.endPage("pg_imp_newtabs");
}%>
<%! public String getJSPUID() { return "2626268316"; } %>