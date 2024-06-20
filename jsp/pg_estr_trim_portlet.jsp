<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Combobox_anno_onChange(){  \n  this.Image_download.Hide();\n}\nfunction Check_onChange(){\n  this.Image_download.Hide();\n  if(this.Check.Value()) {\n    this.cErrori.Set('N')    \n    this.Image_esegui_estrazione_xlsx.Hide()\n    this.nomefile.Hide()\n    this.labelFile.Hide()\n    this.btnUpload.Hide()\n    this.btnUpdate.Hide()    \n  } else {\n    this.Image_esegui_estrazione_xlsx.Show()    \n  }  \n}\nfunction Image_download_Click(){  \n  if(this.last_run.Value()==\"true\"){\n    if (confirm(\"Confermi il download del file?\")) {\n      this.fileName.Value('ERRORI_'+this.last_anno.Value()+'Q'+this.last_trim.Value()+'.xlsx');\n      this.RTDownXLSX.Servlet(\"..\u002fappo\u002f\"+this.gAzienda.Value()+\"\u002f\"+this.fileName.Value())\n      this.RTDownXLSX.Link();\n    } \n  }\n  else{\n    if (confirm(\"Confermi il download del file?\")) {\n      this.fileName.Value(this.last_anno.Value()+'Q'+this.last_trim.Value()+'.zip');\n      this.RTDownload.Parameters(\"pFile=fileName,pCartella=export,pTipo=ZIP\")      \n      this.RTDownload.Link();\n    }  \n  }\n}\n\nfunction Image_esegui_estrazione_Click(){\n  this.last_run.Value(this.Check.Value()); \u002f\u002f tiene conto dell'ultima esecuzione\n  this.last_trim.Value(this.Combobox_trimestre.Value());\n  this.last_anno.Value(this.Combobox_anno.Value());\n  if(this.Check.Value()){\n    if(confirm(\"Confermi il controllo dei dati?\")) {\n      this.Image_download.Hide();\n      this.pMsg.Timer0.Start();\n      this.pLog.Timer0.Start();\n      this.RTCheck.Parameters(\"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre\");\n      this.RTCheck.Link();\n    }\n  }\n  else{\n    if(confirm(\"Confermi l'estrazione dei dati?\")) {\n      this.Image_download.Hide();\n      this.pMsg.Timer0.Start();\n      this.pLog.Timer0.Start();\n      this.RTEstrazione_trimestrale.Parameters(\"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre,w_tipo=E\");\n      this.RTEstrazione_trimestrale.Link();\n    }\n  }\n}\n\nfunction Image_esegui_estrazione_xlsx_Click(){\n  this.last_run.Value(this.Check.Value()); \u002f\u002f tiene conto dell'ultima esecuzione\n  this.last_trim.Value(this.Combobox_trimestre.Value());\n  this.last_anno.Value(this.Combobox_anno.Value());\n  if(confirm(\"Confermi l'estrazione dei dati in Excel?\")) {\n      this.Image_download.Hide();\n      this.pMsg.Timer0.Start();\n      this.pLog.Timer0.Start();\n      this.RTEstrazione_trimestrale.Parameters(\"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre,w_tipo=S\");\n      this.RTEstrazione_trimestrale.Link();\n  }\n}\n\nfunction btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('Estrazione Trimestrale per Banca d\\'Italia',true)\n  this.RTAzzera.Link();\n  this.Image_download.Hide();\n  this.btnUpdate.Hide() \t  \n  this.nomefile.Hide()\n  this.labelFile.Hide()\n  this.btnUpload.Hide()\n  \u002f\u002f inizializzazione delle combobox\n  var max = 11;\n  var d = new Date();  \n  var n = d.getFullYear();\n  var m = d.getMonth();  \n  var str = '';\n  for(var i=0; i\u003cmax; i++){\n      str=str+(n-i);\n      if(i!=(max-1))\n    \t\tstr=str+',';\n  }\n  this.Combobox_anno.FillDataStatic(str,str);\n  if(m\u003c3)\n \t\tthis.Combobox_anno.Value(n-1);\n  else\n  \tthis.Combobox_anno.Value(n);\n  this.Combobox_trimestre.FillDataStatic('1,2,3,4','Q1,Q2,Q3,Q4');\n  if(m\u003c3)\n    this.Combobox_trimestre.Value('4');\n  else if(m\u003c6)\n    this.Combobox_trimestre.Value('1');\n  else if(m\u003c9)\n    this.Combobox_trimestre.Value('2');\n  else\n    this.Combobox_trimestre.Value('3');  \n  \n  \u002f\u002f getsione nota  \n\u002f\u002f   var str_nota2 = \"Periodo di invio valido per \"\n\u002f\u002f   if( m\u003e0 && m\u003c3)\n\u002f\u002f     str_nota2 =str_nota2+\" Q1 dal 1 gennaio \u2013 31 marzo\";\n\u002f\u002f   else if( m\u003e3 && m\u003c6)\n\u002f\u002f     str_nota2 =str_nota2+\" Q2 dal 1 aprile \u2013 30 giugno\";\n\u002f\u002f   else if( m\u003e6 && m\u003c9)\n\u002f\u002f     str_nota2 =str_nota2+\" Q3 dal 1 luglio \u2013 30 settembre\";\n\u002f\u002f   else if( m\u003e9) \n\u002f\u002f     str_nota2 =str_nota2+\" Q4 dal 1 ottobre \u2013 31 dicembre\";\n\u002f\u002f   this.Label_nota2.Value(str_nota2);\n  var str_nota2 = \"Periodo di invio valido per \"\n  if( m\u003e0 && m\u003c3)\n    str_nota2 =str_nota2+\" Q4 dal 1 Gennaio al 31 Gennaio\";\n  else if( m\u003e3 && m\u003c6)\n    str_nota2 =str_nota2+\" Q2 dal 1 Luglio al 31 luglio \";\n  else if( m\u003e6 && m\u003c9)\n    str_nota2 =str_nota2+\" Q3 dal 1 Ottobre al 31 Ottobre\";\n  else if( m\u003e9) \n    str_nota2 =str_nota2+\" Q1 dal 1 Aprile al 30 Aprile\";\n  this.Label_nota2.Value(str_nota2);\n  if(m==3 || m==6 || m==9 || m==0)\n  {\n    this.Label_nota.Hide();\n   \tthis.Label_nota2.Hide();\n  }\n  else{\n    this.Label_nota.Show();\n  \tthis.Label_nota2.Show();\n  }\n\tthis.Combobox_trimestre_onChange();\n}\nfunction Combobox_trimestre_onChange(){\n  this.Image_download.Hide();\n  if(this.Combobox_trimestre.Value()==4)\n    this.Label_periodo.Value('1 ottobre \u2013 31 dicembre')\n  if(this.Combobox_trimestre.Value()==1)\n    this.Label_periodo.Value('1 gennaio - 31 marzo')\n  if(this.Combobox_trimestre.Value()==2)\n    this.Label_periodo.Value('1 aprile \u2013 30 giugno')\n  if(this.Combobox_trimestre.Value()==3)\n    this.Label_periodo.Value('1 luglio \u2013 30 settembre') \n}\n\nfunction RTEstrazione_trimestrale_Result(result){  \n\tthis.stop_timer();      \n}\n\nfunction RTCheck_Result(result){\t\n\tthis.stop_timer(); \n}\n\nfunction stop_timer(){\n\tthis.pLog.Timer0_onTimer();\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0.Stop();\n  this.Image_download.Show(); \n}\n\nfunction btnUpload_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link()\n  this.btnUpdate.Show()\n}\n\nfunction RTUpdate_Result(result){\n  alert(result)\n  this.stop_timer()\n}\n\nfunction btnUpdate_Click(){\n  if(confirm(\"Confermi la correzione dei dati?\")) {\n    this.pMsg.Timer0.Start();\n    this.pLog.Timer0.Start();\n    this.RTUpdate.Link();\n  }  \n}\n\nfunction cErrori_onChange(){\n  if(this.cErrori.Value()=='S') {\n    this.Check.Set(false)    \n    this.nomefile.Show()\n    this.labelFile.Show()\n    this.btnUpload.Show()   \n    this.Image_esegui_estrazione_xlsx.Hide()\n    this.Image_esegui_estrazione.Hide()\n  } else {\n    this.nomefile.Hide()\n    this.labelFile.Hide()\n    this.btnUpload.Hide()   \n    this.btnUpdate.Hide()   \n    this.Image_esegui_estrazione_xlsx.Show()\n    this.Image_esegui_estrazione.Show()\n  }  \n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"370","hsl":"","htmlcode":"{{ @btnUpdate }}\n\n\n\n{{ @cErrori }}\n\n\n\n\n\n{{ @nomefile }}\n{{ @btnUpload }}\n{{ @labelFile }}\n{{ @Image_esegui_estrazione_xlsx }}\n{{ @Check }}\n{{ @Image_download }}\n{{ @Label_periodo }}\n\n{{ @pLog }}\n{{ @Label_nota2 }}\n{{ @Label_nota }}\n{{ @Image_esegui_estrazione }}\n{{ @Combobox_trimestre }}\n{{ @Combobox_anno }}\n{{ @Label1 }}\n{{ @pMsg }}\n{{ @Label0 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1000","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Estrazione Trimestrale per Banca d'Italia","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"851","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label0","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno:","w":"57","wireframe_props":"align,value,n_col","x":"239","y":"7","zindex":"1"},{"alt":"","anchor":"top-left","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnUpload","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"672","y":"80","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"42","x":"891","y":"319"},{"anchor":"","ctrlOfVariant":"","h":"60","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"4","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"851","wireframe_props":"","x":"0","y":"170","zindex":"3"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"431","wireframe_props":"name","x":"239","y":"79","zerofilling":"false","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"6","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"122","x":"891","y":"240"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label1","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Trimestre","w":"72","wireframe_props":"align,value,n_col","x":"394","y":"8","zindex":"2"},{"allowedentities":"opefn_upload_file","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"opefn_upload_file","target":"","type":"SPLinker","w":"120","x":"891","y":"352"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_anno","page":"1","picture":"","sequence":"9","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"numeric","valuelist":"","visible":"true","w":"80","wireframe_props":"name,textlist","x":"305","y":"8","zindex":"3"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"10","type":"EventReceiver","w":"120","x":"892","y":"265"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_trimestre","page":"1","picture":"","sequence":"11","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"80","wireframe_props":"name,textlist","x":"471","y":"8","zindex":"4"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"12","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"263","y":"-58"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb4a;","font_image_hover":"&#xeb4b;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Creazione file trimestrali","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_esegui_estrazione","page":"1","path_type":"","sequence":"13","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"816","y":"133","zindex":"5"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTEstrazione_trimestrale","offline":"false","page":"1","parms":"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre,w_tipo=E","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"opert_estr_trim","target":"","type":"SPLinker","w":"120","x":"895","y":"137"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"141","y":"-59"},{"allowedentities":"opefn_update_trimestrali","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTUpdate","offline":"false","page":"1","parms":"nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"opefn_update_trimestrali","target":"","type":"SPLinker","w":"120","x":"890","y":"382"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Arial, Helvetica, sans-serif","font_color":"#FF0000","font_size":"6","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_nota","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NOTA: Le segnalazioni relative alle banconote ritirate (RIT) e sovvenzionate (SOV) devono essere trasmesse trimestralmente nei termini.","w":"520","wireframe_props":"align,value,n_col","x":"144","y":"127","zindex":"6"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Arial, Helvetica, sans-serif","font_color":"#FF0000","font_size":"6","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_nota2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"496","wireframe_props":"align,value,n_col","x":"155","y":"145","zindex":"7"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","h":"140","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"19","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"851","wireframe_props":"","x":"0","y":"230","zindex":"3"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_periodo","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"124","wireframe_props":"align,value,n_col","x":"552","y":"8","zindex":"8"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Prelievo file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_download","page":"1","path_type":"","sequence":"21","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"746","y":"134","zindex":"5"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"opert_downloadfile","target":"","type":"SPLinker","w":"120","x":"895","y":"112"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fileName","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"14","y":"-60"},{"allowedentities":"opert_check_estr_trim","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCheck","offline":"false","page":"1","parms":"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"24","servlet":"opert_check_estr_trim","target":"","type":"SPLinker","w":"120","x":"895","y":"87"},{"anchor":"","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"Effettual il controllo preliminare all'estrazione e genera un file excel con gli errori","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Controllo di Gestione","layer":"false","layout_steps_values":"{}","name":"Check","page":"1","sequence":"25","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"191","wireframe_props":"label_text","x":"273","y":"37","zindex":"11"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"last_run","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"895","y":"165"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"last_anno","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"895","y":"189"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"last_trim","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"895","y":"214"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTDownXLSX","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"29","servlet":"","target":"","type":"SPLinker","w":"120","x":"890","y":"63"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"398","y":"-61"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Crea file Excel per verifica Errori","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_esegui_estrazione_xlsx","page":"1","path_type":"","sequence":"31","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"781","y":"134","zindex":"5"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelFile","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"32","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nome File Correzioni:","w":"127","wireframe_props":"align,value,n_col","x":"107","y":"83","zindex":"1"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Correzione Errori","layer":"false","layout_steps_values":"{}","name":"cErrori","page":"1","sequence":"33","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"161","wireframe_props":"label_text","x":"474","y":"37","zindex":"12"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96c;","font_image_hover":"&#xe96d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnUpdate","page":"1","path_type":"","sequence":"34","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"815","y":"79","zindex":"13"}]%>
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
window.pg_estr_trim_Static=function(){
if(typeof Combobox_anno_onChange !='undefined')this.Combobox_anno_onChange=Combobox_anno_onChange;
if(typeof Check_onChange !='undefined')this.Check_onChange=Check_onChange;
if(typeof Image_download_Click !='undefined')this.Image_download_Click=Image_download_Click;
if(typeof Image_esegui_estrazione_Click !='undefined')this.Image_esegui_estrazione_Click=Image_esegui_estrazione_Click;
if(typeof Image_esegui_estrazione_xlsx_Click !='undefined')this.Image_esegui_estrazione_xlsx_Click=Image_esegui_estrazione_xlsx_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Combobox_trimestre_onChange !='undefined')this.Combobox_trimestre_onChange=Combobox_trimestre_onChange;
if(typeof RTEstrazione_trimestrale_Result !='undefined')this.RTEstrazione_trimestrale_Result=RTEstrazione_trimestrale_Result;
if(typeof RTCheck_Result !='undefined')this.RTCheck_Result=RTCheck_Result;
if(typeof stop_timer !='undefined')this.stop_timer=stop_timer;
if(typeof btnUpload_Click !='undefined')this.btnUpload_Click=btnUpload_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof RTUpdate_Result !='undefined')this.RTUpdate_Result=RTUpdate_Result;
if(typeof btnUpdate_Click !='undefined')this.btnUpdate_Click=btnUpdate_Click;
if(typeof cErrori_onChange !='undefined')this.cErrori_onChange=cErrori_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(false,this.Check);
function Combobox_anno_onChange(){  
  this.Image_download.Hide();
}
function Check_onChange(){
  this.Image_download.Hide();
  if(this.Check.Value()) {
    this.cErrori.Set('N')    
    this.Image_esegui_estrazione_xlsx.Hide()
    this.nomefile.Hide()
    this.labelFile.Hide()
    this.btnUpload.Hide()
    this.btnUpdate.Hide()    
  } else {
    this.Image_esegui_estrazione_xlsx.Show()    
  }  
}
function Image_download_Click(){  
  if(this.last_run.Value()=="true"){
    if (confirm("Confermi il download del file?")) {
      this.fileName.Value('ERRORI_'+this.last_anno.Value()+'Q'+this.last_trim.Value()+'.xlsx');
      this.RTDownXLSX.Servlet("../appo/"+this.gAzienda.Value()+"/"+this.fileName.Value())
      this.RTDownXLSX.Link();
    } 
  }
  else{
    if (confirm("Confermi il download del file?")) {
      this.fileName.Value(this.last_anno.Value()+'Q'+this.last_trim.Value()+'.zip');
      this.RTDownload.Parameters("pFile=fileName,pCartella=export,pTipo=ZIP")      
      this.RTDownload.Link();
    }  
  }
}
function Image_esegui_estrazione_Click(){
  this.last_run.Value(this.Check.Value()); // tiene conto dell'ultima esecuzione
  this.last_trim.Value(this.Combobox_trimestre.Value());
  this.last_anno.Value(this.Combobox_anno.Value());
  if(this.Check.Value()){
    if(confirm("Confermi il controllo dei dati?")) {
      this.Image_download.Hide();
      this.pMsg.Timer0.Start();
      this.pLog.Timer0.Start();
      this.RTCheck.Parameters("w_anno=Combobox_anno,w_trimestre=Combobox_trimestre");
      this.RTCheck.Link();
    }
  }
  else{
    if(confirm("Confermi l'estrazione dei dati?")) {
      this.Image_download.Hide();
      this.pMsg.Timer0.Start();
      this.pLog.Timer0.Start();
      this.RTEstrazione_trimestrale.Parameters("w_anno=Combobox_anno,w_trimestre=Combobox_trimestre,w_tipo=E");
      this.RTEstrazione_trimestrale.Link();
    }
  }
}
function Image_esegui_estrazione_xlsx_Click(){
  this.last_run.Value(this.Check.Value()); // tiene conto dell'ultima esecuzione
  this.last_trim.Value(this.Combobox_trimestre.Value());
  this.last_anno.Value(this.Combobox_anno.Value());
  if(confirm("Confermi l'estrazione dei dati in Excel?")) {
      this.Image_download.Hide();
      this.pMsg.Timer0.Start();
      this.pLog.Timer0.Start();
      this.RTEstrazione_trimestrale.Parameters("w_anno=Combobox_anno,w_trimestre=Combobox_trimestre,w_tipo=S");
      this.RTEstrazione_trimestrale.Link();
  }
}
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Estrazione Trimestrale per Banca d\'Italia',true)
  this.RTAzzera.Link();
  this.Image_download.Hide();
  this.btnUpdate.Hide() 	  
  this.nomefile.Hide()
  this.labelFile.Hide()
  this.btnUpload.Hide()
  // inizializzazione delle combobox
  var max = 11;
  var d = new Date();  
  var n = d.getFullYear();
  var m = d.getMonth();  
  var str = '';
  for(var i=0; i<max; i++){
      str=str+(n-i);
      if(i!=(max-1))
    		str=str+',';
  }
  this.Combobox_anno.FillDataStatic(str,str);
  if(m<3)
 		this.Combobox_anno.Value(n-1);
  else
  	this.Combobox_anno.Value(n);
  this.Combobox_trimestre.FillDataStatic('1,2,3,4','Q1,Q2,Q3,Q4');
  if(m<3)
    this.Combobox_trimestre.Value('4');
  else if(m<6)
    this.Combobox_trimestre.Value('1');
  else if(m<9)
    this.Combobox_trimestre.Value('2');
  else
    this.Combobox_trimestre.Value('3');  
  
  // getsione nota  
//   var str_nota2 = "Periodo di invio valido per "
//   if( m>0 && m<3)
//     str_nota2 =str_nota2+" Q1 dal 1 gennaio – 31 marzo";
//   else if( m>3 && m<6)
//     str_nota2 =str_nota2+" Q2 dal 1 aprile – 30 giugno";
//   else if( m>6 && m<9)
//     str_nota2 =str_nota2+" Q3 dal 1 luglio – 30 settembre";
//   else if( m>9) 
//     str_nota2 =str_nota2+" Q4 dal 1 ottobre – 31 dicembre";
//   this.Label_nota2.Value(str_nota2);
  var str_nota2 = "Periodo di invio valido per "
  if( m>0 && m<3)
    str_nota2 =str_nota2+" Q4 dal 1 Gennaio al 31 Gennaio";
  else if( m>3 && m<6)
    str_nota2 =str_nota2+" Q2 dal 1 Luglio al 31 luglio ";
  else if( m>6 && m<9)
    str_nota2 =str_nota2+" Q3 dal 1 Ottobre al 31 Ottobre";
  else if( m>9) 
    str_nota2 =str_nota2+" Q1 dal 1 Aprile al 30 Aprile";
  this.Label_nota2.Value(str_nota2);
  if(m==3 || m==6 || m==9 || m==0)
  {
    this.Label_nota.Hide();
   	this.Label_nota2.Hide();
  }
  else{
    this.Label_nota.Show();
  	this.Label_nota2.Show();
  }
	this.Combobox_trimestre_onChange();
}
function Combobox_trimestre_onChange(){
  this.Image_download.Hide();
  if(this.Combobox_trimestre.Value()==4)
    this.Label_periodo.Value('1 ottobre – 31 dicembre')
  if(this.Combobox_trimestre.Value()==1)
    this.Label_periodo.Value('1 gennaio - 31 marzo')
  if(this.Combobox_trimestre.Value()==2)
    this.Label_periodo.Value('1 aprile – 30 giugno')
  if(this.Combobox_trimestre.Value()==3)
    this.Label_periodo.Value('1 luglio – 30 settembre') 
}
function RTEstrazione_trimestrale_Result(result){  
	this.stop_timer();      
}
function RTCheck_Result(result){	
	this.stop_timer(); 
}
function stop_timer(){
	this.pLog.Timer0_onTimer();
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0.Stop();
  this.Image_download.Show(); 
}
function btnUpload_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function Aggiorna() {
  this.RTSaveFile.Link()
  this.btnUpdate.Show()
}
function RTUpdate_Result(result){
  alert(result)
  this.stop_timer()
}
function btnUpdate_Click(){
  if(confirm("Confermi la correzione dei dati?")) {
    this.pMsg.Timer0.Start();
    this.pLog.Timer0.Start();
    this.RTUpdate.Link();
  }  
}
function cErrori_onChange(){
  if(this.cErrori.Value()=='S') {
    this.Check.Set(false)    
    this.nomefile.Show()
    this.labelFile.Show()
    this.btnUpload.Show()   
    this.Image_esegui_estrazione_xlsx.Hide()
    this.Image_esegui_estrazione.Hide()
  } else {
    this.nomefile.Hide()
    this.labelFile.Hide()
    this.btnUpload.Hide()   
    this.btnUpdate.Hide()   
    this.Image_esegui_estrazione_xlsx.Show()
    this.Image_esegui_estrazione.Show()
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
.pg_estr_trim_container {
  height:100%;
  overflow:auto;
}
.pg_estr_trim_title_container {
  margin: auto;
}
.pg_estr_trim_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1000px;
  min-width:851px;
  height:100%;
  background-color:#F3F3F3;
}
.pg_estr_trim_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_estr_trim_portlet > .Label0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  left:239px;
  left:28.084606%;
  right:555px;
  right:65.21739%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label0_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label0_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estr_trim_portlet > .btnUpload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:80px;
  left:672px;
  width:20px;
  height:20px;
}
.pg_estr_trim_portlet > .btnUpload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_estr_trim_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:170px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:60px;
}
.pg_estr_trim_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:79px;
  left:239px;
  width:431px;
  height:20px;
}
.pg_estr_trim_portlet > .nomefile_ctrl {
}
.pg_estr_trim_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estr_trim_portlet > .Label1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:8px;
  left:394px;
  left:46.298473%;
  right:385px;
  right:45.240894%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label1_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label1_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estr_trim_portlet > .Combobox_anno_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:8px;
  left:305px;
  left:35.840187%;
  right:466px;
  right:54.759106%;
  width:auto;
  height:20px;
}
.pg_estr_trim_portlet > .Combobox_trimestre_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:8px;
  left:471px;
  left:55.34665%;
  right:300px;
  right:35.252644%;
  width:auto;
  height:20px;
}
.pg_estr_trim_portlet > .Image_esegui_estrazione_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:133px;
  left:816px;
  left:95.88719%;
  right:5px;
  right:0.5875441%;
  width:auto;
  height:30px;
}
.pg_estr_trim_portlet > .Image_esegui_estrazione_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estr_trim_portlet > .Label_nota_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:127px;
  left:144px;
  left:16.921268%;
  right:187px;
  right:21.974148%;
  width:auto;
  height:auto;
  min-height:20px;
  display:none;
}
.pg_estr_trim_portlet > .Label_nota_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label_nota_ctrl {
  overflow:hidden;
  font-family:Arial, Helvetica, sans-serif;
  font-size:6;
  color:#FF0000;
  text-align:left;
}
.pg_estr_trim_portlet > .Label_nota2_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:145px;
  left:155px;
  left:18.213865%;
  right:200px;
  right:23.501762%;
  width:auto;
  height:auto;
  min-height:20px;
  display:none;
}
.pg_estr_trim_portlet > .Label_nota2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label_nota2_ctrl {
  overflow:hidden;
  font-family:Arial, Helvetica, sans-serif;
  font-size:6;
  color:#FF0000;
  text-align:left;
}
.pg_estr_trim_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:230px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_estr_trim_portlet > .Label_periodo_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:8px;
  left:552px;
  left:64.86487%;
  right:175px;
  right:20.564043%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label_periodo_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_portlet > .Label_periodo_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_estr_trim_portlet > .Image_download_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:134px;
  left:746px;
  left:87.661575%;
  right:75px;
  right:8.813161%;
  width:auto;
  height:30px;
}
.pg_estr_trim_portlet > .Image_download_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estr_trim_portlet > .Check_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:37px;
  left:273px;
  left:32.079906%;
  right:387px;
  right:45.47591%;
  width:auto;
  height:20px;
}
.pg_estr_trim_portlet > .Image_esegui_estrazione_xlsx_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:134px;
  left:781px;
  left:91.77438%;
  right:40px;
  right:4.7003527%;
  width:auto;
  height:30px;
}
.pg_estr_trim_portlet > .Image_esegui_estrazione_xlsx_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estr_trim_portlet > .labelFile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:83px;
  left:107px;
  width:127px;
  height:auto;
  min-height:19px;
}
.pg_estr_trim_portlet > .labelFile_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estr_trim_portlet > .labelFile_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estr_trim_portlet > .cErrori_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:37px;
  left:474px;
  left:55.699177%;
  right:216px;
  right:25.381903%;
  width:auto;
  height:20px;
}
.pg_estr_trim_portlet > .btnUpdate_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:79px;
  left:815px;
  left:95.769684%;
  right:6px;
  right:0.70505285%;
  width:auto;
  height:30px;
}
.pg_estr_trim_portlet > .btnUpdate_ctrl {
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
 String def="[{\"h\":\"370\",\"layout_steps_values\":{},\"pages_names\":\"Estrazione Trimestrale per Banca d'Italia\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"851\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno:\",\"w\":\"57\",\"x\":\"239\",\"y\":\"7\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"672\",\"y\":\"80\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"42\",\"x\":\"891\",\"y\":\"319\"},{\"anchor\":\"\",\"h\":\"60\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"851\",\"x\":\"0\",\"y\":\"170\",\"zindex\":\"3\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"431\",\"x\":\"239\",\"y\":\"79\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"122\",\"x\":\"891\",\"y\":\"240\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Trimestre\",\"w\":\"72\",\"x\":\"394\",\"y\":\"8\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"891\",\"y\":\"352\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_anno\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"80\",\"x\":\"305\",\"y\":\"8\",\"zindex\":\"3\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"120\",\"x\":\"892\",\"y\":\"265\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_trimestre\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"80\",\"x\":\"471\",\"y\":\"8\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"263\",\"y\":\"-58\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Image_esegui_estrazione\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"816\",\"y\":\"133\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"RTEstrazione_trimestrale\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"895\",\"y\":\"137\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"141\",\"y\":\"-59\"},{\"h\":\"20\",\"name\":\"RTUpdate\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"890\",\"y\":\"382\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_nota\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NOTA: Le segnalazioni relative alle banconote ritirate (RIT) e sovvenzionate (SOV) devono essere trasmesse trimestralmente nei termini.\",\"w\":\"520\",\"x\":\"144\",\"y\":\"127\",\"zindex\":\"6\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_nota2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"496\",\"x\":\"155\",\"y\":\"145\",\"zindex\":\"7\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"140\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"851\",\"x\":\"0\",\"y\":\"230\",\"zindex\":\"3\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_periodo\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"124\",\"x\":\"552\",\"y\":\"8\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Image_download\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"746\",\"y\":\"134\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"895\",\"y\":\"112\"},{\"h\":\"20\",\"name\":\"fileName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"14\",\"y\":\"-60\"},{\"h\":\"20\",\"name\":\"RTCheck\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"895\",\"y\":\"87\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Controllo di Gestione\",\"layout_steps_values\":{},\"name\":\"Check\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"191\",\"x\":\"273\",\"y\":\"37\",\"zindex\":\"11\"},{\"h\":\"20\",\"name\":\"last_run\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"895\",\"y\":\"165\"},{\"h\":\"20\",\"name\":\"last_anno\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"895\",\"y\":\"189\"},{\"h\":\"20\",\"name\":\"last_trim\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"895\",\"y\":\"214\"},{\"h\":\"20\",\"name\":\"RTDownXLSX\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"890\",\"y\":\"63\"},{\"h\":\"20\",\"name\":\"gAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"398\",\"y\":\"-61\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Image_esegui_estrazione_xlsx\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"781\",\"y\":\"134\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelFile\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome File Correzioni:\",\"w\":\"127\",\"x\":\"107\",\"y\":\"83\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Correzione Errori\",\"layout_steps_values\":{},\"name\":\"cErrori\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"161\",\"x\":\"474\",\"y\":\"37\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnUpdate\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"815\",\"y\":\"79\",\"zindex\":\"13\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estr_trim","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estr_trim_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_estr_trim_portlet > .Label_nota_ctrl {
  display:none;
}
.pg_estr_trim_portlet > .Label_nota2_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estr_trim','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label0= "Anno:";
String dir= "";
String nomefile= "";
if(request.getAttribute("pg_estr_trim_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label1= "Trimestre";
double Combobox_anno= 0;
String Combobox_trimestre= "";
String Label_nota= "NOTA: Le segnalazioni relative alle banconote ritirate (RIT) e sovvenzionate (SOV) devono essere trasmesse trimestralmente nei termini.";
String Label_nota2= "";
String Label_periodo= "";
String fileName= "";
boolean Check= false;
String last_run= "";
String last_anno= "";
String last_trim= "";
String gAzienda=sp.getGlobal("gAzienda","");
String labelFile= "Nome File Correzioni:";
String cErrori="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estr_trim_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estr_trim_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estr_trim_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estr_trim','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_Label0'  formid='<%=idPortlet%>' ps-name='Label0'    class='label Label0_ctrl'><div id='<%=idPortlet%>_Label0tbl' style='width:100%;'><%=JSPLib.ToHTML("Anno:")%></div></span>
<a id='<%=idPortlet%>_btnUpload' class='image btnUpload_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<span id='<%=idPortlet%>_Label1'  formid='<%=idPortlet%>' ps-name='Label1'    class='label Label1_ctrl'><div id='<%=idPortlet%>_Label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Trimestre")%></div></span>
<select id='<%=idPortlet%>_Combobox_anno' name='Combobox_anno' class='combobox' style=''></select>
<select id='<%=idPortlet%>_Combobox_trimestre' name='Combobox_trimestre' class='combobox' style=''></select>
<a id='<%=idPortlet%>_Image_esegui_estrazione' class='image-default Image_esegui_estrazione_ctrl'   target=''>&#xeb4a;</a>
<span id='<%=idPortlet%>_Label_nota'  formid='<%=idPortlet%>' ps-name='Label_nota'    class='label Label_nota_ctrl'><div id='<%=idPortlet%>_Label_notatbl' style='width:100%;'><%=JSPLib.ToHTML("NOTA: Le segnalazioni relative alle banconote ritirate (RIT) e sovvenzionate (SOV) devono essere trasmesse trimestralmente nei termini.")%></div></span>
<span id='<%=idPortlet%>_Label_nota2'  formid='<%=idPortlet%>' ps-name='Label_nota2'    class='label Label_nota2_ctrl'><div id='<%=idPortlet%>_Label_nota2tbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<span id='<%=idPortlet%>_Label_periodo'  formid='<%=idPortlet%>' ps-name='Label_periodo'    class='label Label_periodo_ctrl'><div id='<%=idPortlet%>_Label_periodotbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_Image_download' class='image-default Image_download_ctrl'   target=''>&#xe9dc;</a>
<div id='<%=idPortlet%>_Check_div' style=''><input id='<%=idPortlet%>_Check' name='Check' class='slider checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Effettual il controllo preliminare all'estrazione e genera un file excel con gli errori" )%> /><label for='<%=idPortlet%>_Check' class='label' title=<%=JSPLib.ToHTMLValue("Effettual il controllo preliminare all'estrazione e genera un file excel con gli errori" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Controllo di Gestione")%></label></div>
<a id='<%=idPortlet%>_Image_esegui_estrazione_xlsx' class='image-default Image_esegui_estrazione_xlsx_ctrl'   target=''>&#xea8c;</a>
<span id='<%=idPortlet%>_labelFile'  formid='<%=idPortlet%>' ps-name='labelFile'    class='label labelFile_ctrl'><div id='<%=idPortlet%>_labelFiletbl' style='width:100%;'><%=JSPLib.ToHTML("Nome File Correzioni:")%></div></span>
<div id='<%=idPortlet%>_cErrori_div' style=''><input id='<%=idPortlet%>_cErrori' name='cErrori' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_cErrori' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Correzione Errori")%></label></div>
<a id='<%=idPortlet%>_btnUpdate' class='image-default btnUpdate_ctrl'   target=''>&#xe96c;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estr_trim');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estr_trim',["851"],["370"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"370","title":"Estrazione Trimestrale per Banca d'Italia","layer":"false","npage":"1"}]);
this.Label0=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label0","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label0","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label0,false,true)%>","type":"Label","w":57,"x":239,"y":7,"zindex":"1"});
this.btnUpload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image btnUpload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnUpload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnUpload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":672,"y":80,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":60,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":851,"x":0,"y":170,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":431,"x":239,"y":79,"zerofilling":false,"zindex":"1","zoom":""});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":122,"x":891,"y":240});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.Label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label1","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label1,false,true)%>","type":"Label","w":72,"x":394,"y":8,"zindex":"2"});
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("opefn_upload_file",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_upload_file","target":"","type":"SPLinker","w":120,"x":891,"y":352});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,opefn_upload_file",request.getSession())%>';
this.Combobox_anno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_anno","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_anno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_anno","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"numeric","valuelist":"","visible":true,"w":80,"x":305,"y":8,"zindex":"3"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":120,"x":892,"y":265});
this.Combobox_trimestre=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_trimestre","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_trimestre%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_trimestre","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":80,"x":471,"y":8,"zindex":"4"});
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":263,"y":-58});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.Image_esegui_estrazione=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image_esegui_estrazione_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_esegui_estrazione","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb4a;","font_image_hover":"&#xeb4b;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Creazione file trimestrali",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_esegui_estrazione","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb4a;","srchover":"&#xeb4b;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":816,"y":133,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEstrazione_trimestrale=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEstrazione_trimestrale","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEstrazione_trimestrale","offline":false,"page":1,"parms":"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre,w_tipo=E","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_estr_trim","target":"","type":"SPLinker","w":120,"x":895,"y":137});
this.RTEstrazione_trimestrale.m_cID='<%=JSPLib.cmdHash("routine,opert_estr_trim",request.getSession())%>';
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":141,"y":-59});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,opefn_azzera_messaggi",request.getSession())%>';
this.RTUpdate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("opefn_update_trimestrali",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpdate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpdate","offline":false,"page":1,"parms":"nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_update_trimestrali","target":"","type":"SPLinker","w":120,"x":890,"y":382});
this.RTUpdate.m_cID='<%=JSPLib.cmdHash("routine,opefn_update_trimestrali",request.getSession())%>';
this.Label_nota=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_nota","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Arial, Helvetica, sans-serif","font_color":"#FF0000","font_size":"6","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_nota","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_nota,false,true)%>","type":"Label","w":520,"x":144,"y":127,"zindex":"6"});
this.Label_nota2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_nota2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Arial, Helvetica, sans-serif","font_color":"#FF0000","font_size":"6","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_nota2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_nota2,false,true)%>","type":"Label","w":496,"x":155,"y":145,"zindex":"7"});
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_pLog","h":140,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":851,"x":0,"y":230,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.Label_periodo=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_periodo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_periodo","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_periodo,false,true)%>","type":"Label","w":124,"x":552,"y":8,"zindex":"8"});
this.Image_download=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image_download_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_download","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Prelievo file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_download","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9dc;","srchover":"&#xe9dd;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":746,"y":134,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_downloadfile","target":"","type":"SPLinker","w":120,"x":895,"y":112});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,opert_downloadfile",request.getSession())%>';
this.fileName=new ZtVWeb._VC(this,'fileName',null,'character','<%=JSPLib.ToJSValue(fileName,false,true)%>',false,false);
this.RTCheck=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("opert_check_estr_trim",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCheck","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCheck","offline":false,"page":1,"parms":"w_anno=Combobox_anno,w_trimestre=Combobox_trimestre","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_check_estr_trim","target":"","type":"SPLinker","w":120,"x":895,"y":87});
this.RTCheck.m_cID='<%=JSPLib.cmdHash("routine,opert_check_estr_trim",request.getSession())%>';
this.Check=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_Check","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Controllo di Gestione","layer":false,"layout_steps_values":{},"name":"Check","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":191,"x":273,"y":37,"zindex":"11"});
this.last_run=new ZtVWeb._VC(this,'last_run',null,'character','<%=JSPLib.ToJSValue(last_run,false,true)%>',false,false);
this.last_anno=new ZtVWeb._VC(this,'last_anno',null,'character','<%=JSPLib.ToJSValue(last_anno,false,true)%>',false,false);
this.last_trim=new ZtVWeb._VC(this,'last_trim',null,'character','<%=JSPLib.ToJSValue(last_trim,false,true)%>',false,false);
this.RTDownXLSX=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownXLSX","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownXLSX","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":120,"x":890,"y":63});
this.RTDownXLSX.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.Image_esegui_estrazione_xlsx=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image_esegui_estrazione_xlsx_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_esegui_estrazione_xlsx","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Crea file Excel per verifica Errori",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_esegui_estrazione_xlsx","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":781,"y":134,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.labelFile=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelFile","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelFile","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelFile,false,true)%>","type":"Label","w":127,"x":107,"y":83,"zindex":"1"});
this.cErrori=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_cErrori","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Correzione Errori","layer":false,"layout_steps_values":{},"name":"cErrori","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":161,"x":474,"y":37,"zindex":"12"});
this.cErrori.Value('<%=cErrori%>');
this.btnUpdate=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default btnUpdate_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnUpdate","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96c;","font_image_hover":"&#xe96d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnUpdate","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":815,"y":79,"zindex":"13"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
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
<%if(request.getAttribute("pg_estr_trim_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estr_trim_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estr_trim_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnUpload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Image_esegui_estrazione.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Image_download.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Image_esegui_estrazione_xlsx.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnUpdate.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Combobox_anno.FillData();
window.<%=idPortlet%>.Combobox_trimestre.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estr_trim',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estr_trim');
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
sp.endPage("pg_estr_trim");
}%>
<%! public String getJSPUID() { return "1526144744"; } %>