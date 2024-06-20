<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var ua = navigator.userAgent\n  , device = \"\u003c%=JSPLib.GetUserAgent(request)%\u003e\"\n;\nvar item_applist;\nvar left_distance;\nvar arrBtn=[];\n\nvar app_title,app_descr,app_logo,app_access,app_url,app_apkUrl;\n\n\u002f\u002f eliminazione tabstrip\nvar tabstrip = window[this.formid + '_tabstrip'];  \n\n function hideTabStrip(){\n   tabstrip.HideTabsContainer();\n}\n\nthis.hideTabStrip();\n\nfunction setPage(nPage){\n  this.ZtTabs.Select('page'+nPage,nPage);\n}\n\nfunction this_Loaded(){\n \u002f\u002f centra bottone BtnGotoApp\n this.BtnGotoApp.Ctrl.style.left = '50%';\n this.BtnGotoApp.Ctrl.style.marginLeft = -((this.width\u002f2-this.BtnGotoApp.leftposition)+this.BtnGotoApp.Ctrl.width\u002f2)+'px';   \n \u002f\u002f centra il bottone BtnRegister\n this.BtnRegister.Ctrl.style.left = '50%';\n this.BtnRegister.Ctrl.style.marginLeft = -((this.width\u002f2-this.BtnRegister.leftposition)+this.BtnRegister.Ctrl.width\u002f2)+'px';   \n}\n\n\n\nfunction isIAR(){\n  return navigator.userAgent.match(\u002fzRuntime\u002f);\n}\n\n\nfunction BtnQR_Click(){\n  this.startQrPortlet(this.url.Value());\n}\n\nfunction BtnQrNative_Click(){\n  this.startQrPortlet(this.apkUrl.Value());\n}\n\nfunction BtnInstallBrowser_Click(){\n  if(this.isIAR())\n    window.open(\"it.zucchetti.sitepainter.iar:\"+this.url.Value(),\"_blank\");\n  else\n    window.open(this.url.Value(),\"_blank\");\n}\n\nfunction BtnInstallNative_Click(){\n  window.open(this.apkUrl.Value(),\"_blank\");\n}\n\nfunction startQrPortlet(urlParam){\n  var portletQrDetail='spas_pqrdetail_app';\n  var pQrDetail=ZtVWeb.getPortlet(portletQrDetail);\u002f\u002fritorna se costruito\n  if(!pQrDetail){\n\t  var div=document.createElement('div');\n  \tdiv.id='divQrDetail';\n  \tdocument.body.appendChild(div);\n  \tZtVWeb.Include('..\u002fjsp\u002f'+portletQrDetail+'_portlet.jsp', div);\n  \tpQrDetail=ZtVWeb.getPortlet(portletQrDetail);\n    pQrDetail.setItem_rifpdetail(this);\n  }\n  pQrDetail.setParameters(this.lbl_title.Value(),this.lbl_descr.Value(),this.imm_logo.Value(),urlParam);\n  div=document.getElementById('divQrDetail');\n  div.style.position='absolute';\n  var portletHeader;\n  if(device=='SMARTPHONE'){\n    \u002f\u002f portlet centrato\n    div.style.left=\"\";\n    div.style.width=\"100%\";\n    pQrDetail.Ctrl.style['max-width']=\"95%\";\n    pQrDetail.Ctrl.style.margin=\"auto\";\n    \n    portletHeader='spas_pheaderstore_small';\n  }else{\n    portletHeader='spas_pheaderstore';\n  }\n  this.height_top.Value(ZtVWeb.getPortlet(portletHeader).height);\n  div.style.top=parseInt(this.height_top.Value())+20+'px';\t\t\t\n  div.style.left=((window.innerWidth-pQrDetail.width)\u002f2)+'px';\n  div.style.zIndex='15';\n  this.showQrDetail();\n}\n\nfunction checkIsAppIsInstalled(urlApp){\n  var self=this;\n  urlApp=urlApp.split('\u002f').filter(function clear (token) {\n        \treturn token.length \u003e 0;\n        } ).join(\"\u002f\");\n  if(this.isIAR()){\n    function successImport(){\n    \tfunction success(obj){\n        for(var i=0;i\u003cobj.length;i++){\n          var urlTmp=obj[i].url;\n          urlTmp=urlTmp.split('\u002f').filter(function clear (token) {\n        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treturn token.length \u003e 0;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        } ).join(\"\u002f\");\n          if(urlTmp == urlApp){\n          \tself.BtnInstallBrowser.Value(\"Open\");\n          }\u002f\u002fif\n        }\u002f\u002ffor\n      }\u002f\u002fsuccess\n      function fail(){\n      \tconsole.log('Read installed apps from device failed');\n      }\n    \tShortcutPlugin.getInstalledApps(this.success,this.fail);\n    }\u002f\u002fsuccessImport\n\n    function failImport(err){\n    \tconsole.log('Import cordova failed'); \n    }\n\n    LibJavascript.importCordova(this.successImport,this.failImport);\n  }\n}\n\nfunction setAppValue(title,descr,logo,access,url,apkUrl){\n    this.checkIsAppIsInstalled(url);\n    arrBtn=[];\n    this.lbl_title.Value(title);\n    this.lbl_descr.Value(descr);\n    this.imm_logo.Value(logo);\n    this.url.Value(url);\n    this.apkUrl.Value(apkUrl);\n    this.BtnQR.Hide();\n    this.BtnInstallBrowser.Hide();\n    this.BtnInstallNative.Hide();\n    this.BtnQrNative.Hide();\n    if(device == \"SMARTPHONE\" || device == \"ANDROID\" || device == \"IPAD\" || device == \"TABLET\" || device ==\"MOBILE\"){\n      if(access=='browser_and_hybrid' || access=='browser_only'){\n        if(this.isIAR())\n          this.BtnInstallBrowser.Value(\"Install\")\n          this.BtnInstallBrowser.Show();\n        arrBtn.push(this.BtnInstallBrowser);\n      }\n      if(access=='browser_and_hybrid' || access=='hybrid_only'){\n        if(this.isIAR()) {\n          this.BtnInstallNative.Value(\"Download App\");\n          this.BtnInstallNative.Ctrl.style.whiteSpace='normal';\n        }\n        if('\u003c%=JSPLib.GetMobileOperationSystem(request)%\u003e'==='ANDROID'){\n          this.BtnInstallNative.Show();\n          arrBtn.push(this.BtnInstallNative); \n        }\n      }\n    }else if(!window.openDatabase){\t\t\t\t\t\u002f\u002fif haven't databases property the devices can't install app on browser \n      if(access=='browser_and_hybrid' || access=='browser_only' ){\t\n        this.BtnQR.Show();\n        arrBtn.push(this.BtnQR);\n      }\n      if(access=='browser_and_hybrid' || access=='hybrid_only' ){\n        this.BtnQrNative.Show();\n        arrBtn.push(this.BtnQrNative);\n      }\n    }else{ \t\t\n      if(access=='browser_and_hybrid' || access=='browser_only' ){\n        this.BtnQR.Show();\n        arrBtn.push(this.BtnQR);\n        this.BtnInstallBrowser.Show();\n        arrBtn.push(this.BtnInstallBrowser);\n      }\n      if(access=='browser_and_hybrid' || access=='hybrid_only' ){  \n        this.BtnQrNative.Show();\n        arrBtn.push(this.BtnQrNative);\n      }\n    }\n    this.positionButton();\n}\n\nfunction setParameters(title,descr,logo,access,url,apkUrl,modstore,code,nPage){\n  app_title=title;\n  app_descr=descr;\n  app_logo=logo;\n  app_access=access;\n  app_url=url;\n  app_apkUrl=apkUrl;\n  this.code.Value(code);\n  if(modstore=='offline'){\n    this.isOnline.Value(false)\n  }else{\n    this.isOnline.Value(true)\n  }\n  if(nPage==1){\n    this.setAppValue(app_title,app_descr,app_logo,app_access,app_url,app_apkUrl) \n    this.setPage(1);\n  }else{\n    \u002f\u002f inizializzo valori\n    this.lbl_title_2.Value(FormatMsg(\"MSG_APPREG_WELCOME\",title));\n    this.lbl_title_3.Value(FormatMsg(\"MSG_APPREG_WELCOME\",title));\n    this.txt_namesurname.Ctrl_input.placeholder=this.lbl_namesurname.Value();\n    this.txt_namesurname.Ctrl_input.autocorrect=\"off\"\n    this.txt_company.Ctrl_input.placeholder=this.lbl_company.Value();\n    this.txt_company.Ctrl_input.autocorrect=\"off\"\n    this.txt_mail.Ctrl_input.placeholder=this.lbl_mail.Value();\n    this.txt_mail.Ctrl_input.type=\"email\"; \u002f\u002f fa apparire tastiera per inserimento indirizzo mail\n    this.txt_mail.Ctrl_input.setAttribute(\"required\",null); \u002f\u002f obbligatorio\n    this.txt_note.Ctrl_input.placeholder=this.lbl_note.Value();    \n    \n    this.setPage(2);\n  }  \n}\n\nfunction positionButton(){\n  var widthBtn=[];\n  var sumWidthBtn=0;\n  for(i=0;i\u003carrBtn.length;i++){\n    widthBtn.push(arrBtn[i].controlwidth);\n    sumWidthBtn+=widthBtn[i];\n  }\n  var spaceBetweenButton=10;\n  var left_distance_first_button=((this.width-sumWidthBtn-spaceBetweenButton*arrBtn.length))\u002f2;\n  for(i=0;i\u003carrBtn.length;i++){\n    \n    arrBtn[i].Ctrl.style.left=left_distance_first_button+i*spaceBetweenButton+i*widthBtn[i]+\"px\";\n  }  \n} \n\nfunction closePage(){\n item_applist.hideDetail();\n item_applist.showStore();\n}\n\nfunction closeDetail_Click(){\n  this.closePage();\n \n}\nfunction closeDetail_2_Click(){\n this.closePage();\n}\n\nfunction closeDetail_3_Click(){\n this.closePage();\n}\n\nfunction BtnGotoApp_Click(){\n  this.setAppValue(app_title,app_descr,app_logo,app_access,app_url,app_apkUrl);\n  this.setPage(1);\n}\n\nfunction BtnRegister_Click(){\n  this.setPage(3);\n}\n\nfunction txt_mail_Validate(){\n mymail=this.txt_mail.Value();\n  if(!Empty(mymail)){ \n    if (\u002f^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$\u002f.test(mymail)){  \n      return (true)  \n    } else { \n      alert(FormatMsg(\"Indirizzo mail non valido!\"))  \n      return (false)  \n    }\n  } else {\n   return (true)\n  }  \n}\n\n\nfunction BtnConfRegister_Click(){\n  if(Empty(this.txt_mail.Value())){\n     alert(FormatMsg(\"Indirizzo mail obbligatorio!\"))  \n     this.txt_mail.SetFocus()\n  }   \n  this.spRreg.Link()   \n}\n\nfunction spRreg_Result(result){\n  if(Empty(result)) {\n    alert(FormatMsg(\"MSG_APPREG_REG_COMPLETE\"));\n    this.setAppValue(app_title,app_descr,app_logo,app_access,app_url,app_apkUrl);\n    \u002f\u002f ripulisco i dati appena inseriti: contrordine da Aulla: lasciamo quelli appena inseriti\n    \u002f\u002fthis.txt_namesurname.Value(\"\");\n    \u002f\u002fthis.txt_company.Value(\"\");\n    \u002f\u002fthis.txt_mail.Value(\"\");\n    \u002f\u002fthis.txt_note.Value(\"\");\n    this.setPage(1);\n  } else {\n    alert(FormatMsg(result))\n  }\n}\n\n\nfunction setItem_applist(rifPortlet){\n \titem_applist=rifPortlet; \n}\n\nfunction hideQrDetail(){\n  var div=document.getElementById('divQrDetail');\n  div.style.display='none';\n}\n\nfunction showQrDetail(){\n  var div=document.getElementById('divQrDetail');\n  div.style.display='';\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"350","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"false","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"LibJavascript.importCordova.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnQR","page":"1","sequence":"4","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"QR Web","w":"72","wireframe_props":"value","x":"116","y":"252","zindex":"1"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnInstallBrowser","page":"1","sequence":"4","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Web","w":"72","wireframe_props":"value","x":"28","y":"252","zindex":"1"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnInstallNative","page":"1","sequence":"4","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Hybrid","w":"72","wireframe_props":"value","x":"208","y":"252","zindex":"1"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnGotoApp","page":"2","sequence":"4","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_APPREG_BTNACCOUNT","w":"72","wireframe_props":"value","x":"164","y":"112","zindex":"1"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnRegister","page":"2","sequence":"4","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_APPREG_BTNNOACCOUNT","w":"72","wireframe_props":"value","x":"164","y":"213","zindex":"1"},{"anchor":"bottom-right","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnConfRegister","page":"3","sequence":"4","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_APPREG_BTNNOACCOUNT","w":"72","wireframe_props":"value","x":"300","y":"271","zindex":"1"},{"alt":"","anchor":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"90","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"imm_logo","page":"1","path_type":"","sequence":"5","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"90","wireframe_props":"","x":"9","y":"9","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"82","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_title","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"lbl_title","w":"250","wireframe_props":"align,value,n_col","x":"105","y":"17","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"54","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_title_2","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_WELCOME","w":"350","wireframe_props":"align,value,n_col","x":"4","y":"5","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"54","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_title_3","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_WELCOME","w":"350","wireframe_props":"align,value,n_col","x":"4","y":"5","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"107","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_descr","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"lbl_descr","w":"343","wireframe_props":"align,value,n_col","x":"12","y":"105","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_descr_account","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_ACCOUNT","w":"400","wireframe_props":"align,value,n_col","x":"0","y":"81","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_descr_noaccount","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_NOACCOUNT","w":"400","wireframe_props":"align,value,n_col","x":"0","y":"180","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_namesurname","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_NAMESURNAME","w":"314","wireframe_props":"align,value,n_col","x":"29","y":"69","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_company","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_COMPANY","w":"314","wireframe_props":"align,value,n_col","x":"30","y":"119","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_mail","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_MAIL","w":"314","wireframe_props":"align,value,n_col","x":"32","y":"169","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_note","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_APPREG_NOTE","w":"314","wireframe_props":"align,value,n_col","x":"33","y":"218","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"url","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"428","y":"14"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"TextBoxTitle","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"80","name":"txt_namesurname","page":"3","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"343","wireframe_props":"name","x":"28","y":"91","zerofilling":"false","zindex":"1"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"TextBoxTitle","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"80","name":"txt_company","page":"3","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"343","wireframe_props":"name","x":"29","y":"141","zerofilling":"false","zindex":"1"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"TextBoxTitle","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"80","name":"txt_mail","page":"3","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"343","wireframe_props":"name","x":"31","y":"191","zerofilling":"false","zindex":"1"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"TextBoxTitle","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"80","name":"txt_note","page":"3","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"343","wireframe_props":"name","x":"32","y":"240","zerofilling":"false","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"apkUrl","page":"1","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"428","y":"40"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"56","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"BtnQrNative","page":"1","sequence":"11","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"QR Hybrid","w":"72","wireframe_props":"value","x":"298","y":"252","zindex":"1"},{"alt":"","anchor":"top-right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_size":"","h":"26","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layout_steps_values":"{}","name":"closeDetail","page":"1","path_type":"","sequence":"12","server_side":"","src":"..\u002fimages\u002fbackclock.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"26","wireframe_props":"","x":"365","y":"14","zindex":"1"},{"alt":"","anchor":"top-right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_size":"","h":"26","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layout_steps_values":"{}","name":"closeDetail_2","page":"2","path_type":"","sequence":"12","server_side":"","src":"..\u002fimages\u002fbackclock.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"26","wireframe_props":"","x":"364","y":"14","zindex":"1"},{"alt":"","anchor":"top-right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_size":"","h":"26","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layout_steps_values":"{}","name":"closeDetail_3","page":"3","path_type":"","sequence":"12","server_side":"","src":"..\u002fimages\u002fbackclock.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"26","wireframe_props":"","x":"364","y":"15","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"height_top","page":"1","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"428","y":"66"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"spRreg","offline":"false","page":"3","parms":"isOnline,code,e_mail=txt_mail,fullname=txt_namesurname,company=txt_company,note=txt_note","popup":"false","popup_height":"","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"spas_freg","target":"","type":"SPLinker","w":"30","x":"457","y":"79"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"isOnline","page":"3","sequence":"14","server_side":"false","type":"Variable","typevar":"logic","w":"130","x":"522","y":"85"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"code","page":"3","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"523","y":"110"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:url*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
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
.spas_pdetail_app_container {
}
.spas_pdetail_app_portlet{
  position:relative;
  min-width:400px;
  height:350px;
  background-color:#F3F3F3;
}
.spas_pdetail_app_portlet[Data-page="1"]{
  height:350px;
  width:100%;
}
.spas_pdetail_app_portlet[Data-page="2"]{
  height:350px;
  width:100%;
}
.spas_pdetail_app_portlet[Data-page="3"]{
  height:350px;
  width:100%;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnQR_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:252px;
  left:116px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnQR_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnInstallBrowser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:252px;
  left:28px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnInstallBrowser_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnInstallNative_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:252px;
  left:208px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnInstallNative_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnGotoApp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:112px;
  left:164px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnGotoApp_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnRegister_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:213px;
  left:164px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnRegister_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnConfRegister_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  right:28px;
  bottom:23px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnConfRegister_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .imm_logo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:9px;
  width:90px;
  height:90px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .imm_logo_ctrl {
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .imm_logo_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:105px;
  right:45px;
  width:auto;
  height:auto;
  min-height:82px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_ctrl {
  height:auto;
  min-height:82px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:4px;
  right:46px;
  width:auto;
  height:auto;
  min-height:54px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_2_ctrl {
  height:auto;
  min-height:54px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_2_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:4px;
  right:46px;
  width:auto;
  height:auto;
  min-height:54px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_3_ctrl {
  height:auto;
  min-height:54px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_title_3_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:105px;
  left:12px;
  right:45px;
  width:auto;
  height:auto;
  min-height:107px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_ctrl {
  height:auto;
  min-height:107px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_account_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:81px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:22px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_account_ctrl {
  height:auto;
  min-height:22px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_account_ctrl {
  overflow:hidden;
  text-align:center;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_noaccount_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:180px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:22px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_noaccount_ctrl {
  height:auto;
  min-height:22px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_descr_noaccount_ctrl {
  overflow:hidden;
  text-align:center;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_namesurname_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:69px;
  left:29px;
  right:57px;
  width:auto;
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_namesurname_ctrl {
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_namesurname_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_company_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  left:30px;
  right:56px;
  width:auto;
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_company_ctrl {
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_company_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_mail_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:169px;
  left:32px;
  right:54px;
  width:auto;
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_mail_ctrl {
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_mail_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_note_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:218px;
  left:33px;
  right:53px;
  width:auto;
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_note_ctrl {
  height:auto;
  min-height:21px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .lbl_note_ctrl {
  overflow:hidden;
  text-align:left;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_namesurname_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:91px;
  left:28px;
  right:29px;
  width:auto;
  height:20px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_namesurname_ctrl {
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_namesurname_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_company_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:141px;
  left:29px;
  right:28px;
  width:auto;
  height:20px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_company_ctrl {
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_company_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_mail_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:191px;
  left:31px;
  right:26px;
  width:auto;
  height:20px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_mail_ctrl {
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_mail_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_note_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:240px;
  left:32px;
  right:25px;
  width:auto;
  height:20px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_note_ctrl {
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .txt_note_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnQrNative_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:252px;
  left:298px;
  width:72px;
  height:56px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .BtnQrNative_ctrl {
  border-width:1px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .closeDetail_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  right:9px;
  width:26px;
  height:26px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .closeDetail_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:26px;
  font-size:26px;
  color:#000000;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .closeDetail_2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  right:10px;
  width:26px;
  height:26px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .closeDetail_2_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:26px;
  font-size:26px;
  color:#000000;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .closeDetail_3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  right:10px;
  width:26px;
  height:26px;
}
.spas_pdetail_app_portlet > .spas_pdetail_app_page > .closeDetail_3_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:26px;
  font-size:26px;
  color:#000000;
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
 String def="[{\"h\":\"350\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"56\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"QR Web\",\"w\":\"72\",\"x\":\"116\",\"y\":\"252\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"56\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"Web\",\"w\":\"72\",\"x\":\"28\",\"y\":\"252\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"56\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"Hybrid\",\"w\":\"72\",\"x\":\"208\",\"y\":\"252\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"56\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Button\",\"value\":\"MSG_APPREG_BTNACCOUNT\",\"w\":\"72\",\"x\":\"164\",\"y\":\"112\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"56\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Button\",\"value\":\"MSG_APPREG_BTNNOACCOUNT\",\"w\":\"72\",\"x\":\"164\",\"y\":\"213\",\"zindex\":\"1\"},{\"anchor\":\"bottom-right\",\"h\":\"56\",\"layout_steps_values\":{},\"page\":\"3\",\"type\":\"Button\",\"value\":\"MSG_APPREG_BTNNOACCOUNT\",\"w\":\"72\",\"x\":\"300\",\"y\":\"271\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"90\",\"x\":\"9\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"82\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"lbl_title\",\"w\":\"250\",\"x\":\"105\",\"y\":\"17\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"54\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"MSG_APPREG_WELCOME\",\"w\":\"350\",\"x\":\"4\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"54\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"MSG_APPREG_WELCOME\",\"w\":\"350\",\"x\":\"4\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"107\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"lbl_descr\",\"w\":\"343\",\"x\":\"12\",\"y\":\"105\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"MSG_APPREG_ACCOUNT\",\"w\":\"400\",\"x\":\"0\",\"y\":\"81\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"MSG_APPREG_NOACCOUNT\",\"w\":\"400\",\"x\":\"0\",\"y\":\"180\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"MSG_APPREG_NAMESURNAME\",\"w\":\"314\",\"x\":\"29\",\"y\":\"69\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"MSG_APPREG_COMPANY\",\"w\":\"314\",\"x\":\"30\",\"y\":\"119\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"MSG_APPREG_MAIL\",\"w\":\"314\",\"x\":\"32\",\"y\":\"169\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"MSG_APPREG_NOTE\",\"w\":\"314\",\"x\":\"33\",\"y\":\"218\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"428\",\"y\":\"14\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txt_namesurname\",\"page\":\"3\",\"type\":\"Textbox\",\"w\":\"343\",\"x\":\"28\",\"y\":\"91\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txt_company\",\"page\":\"3\",\"type\":\"Textbox\",\"w\":\"343\",\"x\":\"29\",\"y\":\"141\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txt_mail\",\"page\":\"3\",\"type\":\"Textbox\",\"w\":\"343\",\"x\":\"31\",\"y\":\"191\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txt_note\",\"page\":\"3\",\"type\":\"Textbox\",\"w\":\"343\",\"x\":\"32\",\"y\":\"240\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"apkUrl\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"428\",\"y\":\"40\"},{\"anchor\":\"\",\"h\":\"56\",\"layout_steps_values\":{},\"name\":\"BtnQrNative\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"QR Hybrid\",\"w\":\"72\",\"x\":\"298\",\"y\":\"252\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"26\",\"layout_steps_values\":{},\"name\":\"closeDetail\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"26\",\"x\":\"365\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"26\",\"layout_steps_values\":{},\"name\":\"closeDetail_2\",\"page\":\"2\",\"type\":\"Image\",\"w\":\"26\",\"x\":\"364\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"26\",\"layout_steps_values\":{},\"name\":\"closeDetail_3\",\"page\":\"3\",\"type\":\"Image\",\"w\":\"26\",\"x\":\"364\",\"y\":\"15\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"height_top\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"428\",\"y\":\"66\"},{\"h\":\"30\",\"name\":\"spRreg\",\"page\":\"3\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"457\",\"y\":\"79\"},{\"h\":\"20\",\"name\":\"isOnline\",\"page\":\"3\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"522\",\"y\":\"85\"},{\"h\":\"20\",\"name\":\"code\",\"page\":\"3\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"523\",\"y\":\"110\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_pdetail_app","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_pdetail_app_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
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
<script src="../<%=SPPrxycizer.proxycizedPath("LibJavascript.importCordova.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spas_pdetail_app','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lbl_title= "lbl_title";
String lbl_title_2= "MSG_APPREG_WELCOME";
String lbl_title_3= "MSG_APPREG_WELCOME";
String lbl_descr= "lbl_descr";
String lbl_descr_account= "MSG_APPREG_ACCOUNT";
String lbl_descr_noaccount= "MSG_APPREG_NOACCOUNT";
String lbl_namesurname= "MSG_APPREG_NAMESURNAME";
String lbl_company= "MSG_APPREG_COMPANY";
String lbl_mail= "MSG_APPREG_MAIL";
String lbl_note= "MSG_APPREG_NOTE";
String url=JSPLib.translateXSS(sp.getParameter("url",""));
String txt_namesurname= "";
if(request.getAttribute("spas_pdetail_app_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String txt_company= "";
String txt_mail= "";
String txt_note= "";
String apkUrl= "";
String height_top= "";
boolean isOnline= false;
String code= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='spas_pdetail_app_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spas_pdetail_app_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spas_pdetail_app','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='spas_pdetail_app_page' style='display:block'>
<input id='<%=idPortlet%>_BtnQR' type='button' class='button_login BtnQR_ctrl'/>
<input id='<%=idPortlet%>_BtnInstallBrowser' type='button' class='button_login BtnInstallBrowser_ctrl'/>
<input id='<%=idPortlet%>_BtnInstallNative' type='button' class='button_login BtnInstallNative_ctrl'/>
<div id='<%=idPortlet%>_imm_logo'>
<img id='<%=idPortlet%>_imm_logo_img' class='image imm_logo_ctrl' src="" >
</div>
<span id='<%=idPortlet%>_lbl_title'  formid='<%=idPortlet%>' ps-name='lbl_title'    class='label_title lbl_title_ctrl'><div id='<%=idPortlet%>_lbl_titletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("lbl_title"))%></div></span>
<span id='<%=idPortlet%>_lbl_descr'  formid='<%=idPortlet%>' ps-name='lbl_descr'    class='label_description lbl_descr_ctrl'><div id='<%=idPortlet%>_lbl_descrtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("lbl_descr"))%></div></span>
<input id='<%=idPortlet%>_BtnQrNative' type='button' class='button_login BtnQrNative_ctrl'/>
<a id='<%=idPortlet%>_closeDetail' class='image closeDetail_ctrl'   target=''>&#xe9c7;</a>
</div>
<div id='<%=idPortlet%>_page_2' class='spas_pdetail_app_page' style='display:none'>
<input id='<%=idPortlet%>_BtnGotoApp' type='button' class='button_login BtnGotoApp_ctrl'/>
<input id='<%=idPortlet%>_BtnRegister' type='button' class='button_login BtnRegister_ctrl'/>
<span id='<%=idPortlet%>_lbl_title_2'  formid='<%=idPortlet%>' ps-name='lbl_title_2'    class='label_title lbl_title_2_ctrl'><div id='<%=idPortlet%>_lbl_title_2tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_WELCOME"))%></div></span>
<span id='<%=idPortlet%>_lbl_descr_account'  formid='<%=idPortlet%>' ps-name='lbl_descr_account'    class='label_description lbl_descr_account_ctrl'><div id='<%=idPortlet%>_lbl_descr_accounttbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_ACCOUNT"))%></div></span>
<span id='<%=idPortlet%>_lbl_descr_noaccount'  formid='<%=idPortlet%>' ps-name='lbl_descr_noaccount'    class='label_description lbl_descr_noaccount_ctrl'><div id='<%=idPortlet%>_lbl_descr_noaccounttbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_NOACCOUNT"))%></div></span>
<a id='<%=idPortlet%>_closeDetail_2' class='image closeDetail_2_ctrl'   target=''>&#xe9c7;</a>
</div>
<div id='<%=idPortlet%>_page_3' class='spas_pdetail_app_page' style='display:none'>
<input id='<%=idPortlet%>_BtnConfRegister' type='button' class='button_login BtnConfRegister_ctrl'/>
<span id='<%=idPortlet%>_lbl_title_3'  formid='<%=idPortlet%>' ps-name='lbl_title_3'    class='label_title lbl_title_3_ctrl'><div id='<%=idPortlet%>_lbl_title_3tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_WELCOME"))%></div></span>
<span id='<%=idPortlet%>_lbl_namesurname'  formid='<%=idPortlet%>' ps-name='lbl_namesurname'    class='label_description lbl_namesurname_ctrl'><div id='<%=idPortlet%>_lbl_namesurnametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_NAMESURNAME"))%></div></span>
<span id='<%=idPortlet%>_lbl_company'  formid='<%=idPortlet%>' ps-name='lbl_company'    class='label_description lbl_company_ctrl'><div id='<%=idPortlet%>_lbl_companytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_COMPANY"))%></div></span>
<span id='<%=idPortlet%>_lbl_mail'  formid='<%=idPortlet%>' ps-name='lbl_mail'    class='label_description lbl_mail_ctrl'><div id='<%=idPortlet%>_lbl_mailtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_MAIL"))%></div></span>
<span id='<%=idPortlet%>_lbl_note'  formid='<%=idPortlet%>' ps-name='lbl_note'    class='label_description lbl_note_ctrl'><div id='<%=idPortlet%>_lbl_notetbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_APPREG_NOTE"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_txt_namesurname_wrp'><input id='<%=idPortlet%>_txt_namesurname' name='txt_namesurname' type='text' maxlength='80' class='TextBoxTitle' formid='<%=idPortlet%>' ps-name='txt_namesurname' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txt_company_wrp'><input id='<%=idPortlet%>_txt_company' name='txt_company' type='text' maxlength='80' class='TextBoxTitle' formid='<%=idPortlet%>' ps-name='txt_company' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txt_mail_wrp'><input id='<%=idPortlet%>_txt_mail' name='txt_mail' type='text' maxlength='80' class='TextBoxTitle' formid='<%=idPortlet%>' ps-name='txt_mail' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txt_note_wrp'><input id='<%=idPortlet%>_txt_note' name='txt_note' type='text' maxlength='80' class='TextBoxTitle' formid='<%=idPortlet%>' ps-name='txt_note' /></span>
<a id='<%=idPortlet%>_closeDetail_3' class='image closeDetail_3_ctrl'   target=''>&#xe9c7;</a>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spas_pdetail_app');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Indirizzo mail non valido!",true)+","+JSPLib.ToJSValue(sp.translate("Indirizzo mail non valido!"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Indirizzo mail obbligatorio!",true)+","+JSPLib.ToJSValue(sp.translate("Indirizzo mail obbligatorio!"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_APPREG_REG_COMPLETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_APPREG_REG_COMPLETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_APPREG_WELCOME",true)+","+JSPLib.ToJSValue(sp.translate("MSG_APPREG_WELCOME"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/spas_pdetail_app_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("page_1"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("page_2"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page3', element:'<%=idPortlet%>_page_3',caption:'<%=JSPLib.ToJSValue(sp.translate("page_3"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spas_pdetail_app',["400","400","400"],["350"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,3,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"350","title":"","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"400","h":"350","title":"","layer":"false","npage":"2"},{"layout_steps_values":{},"w":"400","h":"350","title":"","layer":"false","npage":"3"}]);
this.BtnQR=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnQR_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnQR","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnQR","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("QR Web"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":116,"y":252,"zindex":"1"});
this.BtnInstallBrowser=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnInstallBrowser_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnInstallBrowser","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnInstallBrowser","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("Web"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":28,"y":252,"zindex":"1"});
this.BtnInstallNative=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnInstallNative_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnInstallNative","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnInstallNative","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("Hybrid"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":208,"y":252,"zindex":"1"});
this.BtnGotoApp=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnGotoApp_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnGotoApp","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnGotoApp","page":2,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_APPREG_BTNACCOUNT"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":164,"y":112,"zindex":"1"});
this.BtnRegister=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnRegister_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnRegister","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnRegister","page":2,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_APPREG_BTNNOACCOUNT"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":164,"y":213,"zindex":"1"});
this.BtnConfRegister=new ZtVWeb._BC(this,{"anchor":"bottom-right","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnConfRegister_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnConfRegister","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnConfRegister","page":3,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_APPREG_BTNNOACCOUNT"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":300,"y":271,"zindex":"1"});
this.imm_logo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image imm_logo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imm_logo","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":90,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imm_logo","page":1,"path_type":"","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":90,"x":9,"y":9,"zindex":"1"});
this.lbl_title=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_title","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_title","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":82,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_title","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_title),false,true)%>","type":"Label","w":250,"x":105,"y":17,"zindex":"1"});
this.lbl_title_2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_title","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_title_2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":54,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_title_2","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_title_2),false,true)%>","type":"Label","w":350,"x":4,"y":5,"zindex":"1"});
this.lbl_title_3=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_title","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_title_3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":54,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_title_3","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_title_3),false,true)%>","type":"Label","w":350,"x":4,"y":5,"zindex":"1"});
this.lbl_descr=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_descr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":107,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_descr","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_descr),false,true)%>","type":"Label","w":343,"x":12,"y":105,"zindex":"1"});
this.lbl_descr_account=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_descr_account","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_descr_account","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_descr_account),false,true)%>","type":"Label","w":400,"x":0,"y":81,"zindex":"1"});
this.lbl_descr_noaccount=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_descr_noaccount","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_descr_noaccount","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_descr_noaccount),false,true)%>","type":"Label","w":400,"x":0,"y":180,"zindex":"1"});
this.lbl_namesurname=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_namesurname","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_namesurname","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_namesurname),false,true)%>","type":"Label","w":314,"x":29,"y":69,"zindex":"1"});
this.lbl_company=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_company","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_company","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_company),false,true)%>","type":"Label","w":314,"x":30,"y":119,"zindex":"1"});
this.lbl_mail=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_mail","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_mail","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_mail),false,true)%>","type":"Label","w":314,"x":32,"y":169,"zindex":"1"});
this.lbl_note=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_note","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_note","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_note),false,true)%>","type":"Label","w":314,"x":33,"y":218,"zindex":"1"});
this.url=new ZtVWeb._VC(this,'url',null,'character','<%=JSPLib.ToJSValue(url,false,true)%>',false,false);
this.txt_namesurname=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txt_namesurname","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"txt_namesurname","page":3,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txt_namesurname,false,true)%>","w":343,"x":28,"y":91,"zerofilling":false,"zindex":"1","zoom":""});
this.txt_company=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txt_company","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"txt_company","page":3,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txt_company,false,true)%>","w":343,"x":29,"y":141,"zerofilling":false,"zindex":"1","zoom":""});
this.txt_mail=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txt_mail","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"txt_mail","page":3,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txt_mail,false,true)%>","w":343,"x":31,"y":191,"zerofilling":false,"zindex":"1","zoom":""});
this.txt_note=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txt_note","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"80","name":"txt_note","page":3,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txt_note,false,true)%>","w":343,"x":32,"y":240,"zerofilling":false,"zindex":"1","zoom":""});
this.apkUrl=new ZtVWeb._VC(this,'apkUrl',null,'character','<%=JSPLib.ToJSValue(apkUrl,false,true)%>',false,false);
this.BtnQrNative=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button_login BtnQrNative_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnQrNative","edit_undercond":"","font":"","font_color":"","font_size":"","h":56,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BtnQrNative","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("QR Hybrid"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":72,"x":298,"y":252,"zindex":"1"});
this.closeDetail=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image closeDetail_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_closeDetail","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"closeDetail","page":1,"path_type":"","server_side":"","src":"&#xe9c7;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":26,"x":365,"y":14,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.closeDetail_2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image closeDetail_2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_closeDetail_2","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"closeDetail_2","page":2,"path_type":"","server_side":"","src":"&#xe9c7;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":26,"x":364,"y":14,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.closeDetail_3=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image closeDetail_3_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_closeDetail_3","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xe9c7;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"closeDetail_3","page":3,"path_type":"","server_side":"","src":"&#xe9c7;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":26,"x":364,"y":15,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.height_top=new ZtVWeb._VC(this,'height_top',null,'character','<%=JSPLib.ToJSValue(height_top,false,true)%>',false,false);
this.spRreg=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_spRreg","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"spRreg","offline":false,"page":3,"parms":"isOnline,code,e_mail=txt_mail,fullname=txt_namesurname,company=txt_company,note=txt_note","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spas_freg","target":"","type":"SPLinker","w":30,"x":457,"y":79});
this.spRreg.m_cID='<%=JSPLib.cmdHash("routine,spas_freg",request.getSession())%>';
this.isOnline=new ZtVWeb._VC(this,'isOnline',null,'logic',<%=isOnline%>,false,false);
this.code=new ZtVWeb._VC(this,'code',null,'character','<%=JSPLib.ToJSValue(code,false,true)%>',false,false);
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
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%request.setAttribute("spas_pdetail_app_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spas_pdetail_app_Static=function(){
if(typeof hideTabStrip !='undefined')this.hideTabStrip=hideTabStrip;
if(typeof setPage !='undefined')this.setPage=setPage;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof isIAR !='undefined')this.isIAR=isIAR;
if(typeof BtnQR_Click !='undefined')this.BtnQR_Click=BtnQR_Click;
if(typeof BtnQrNative_Click !='undefined')this.BtnQrNative_Click=BtnQrNative_Click;
if(typeof BtnInstallBrowser_Click !='undefined')this.BtnInstallBrowser_Click=BtnInstallBrowser_Click;
if(typeof BtnInstallNative_Click !='undefined')this.BtnInstallNative_Click=BtnInstallNative_Click;
if(typeof startQrPortlet !='undefined')this.startQrPortlet=startQrPortlet;
if(typeof checkIsAppIsInstalled !='undefined')this.checkIsAppIsInstalled=checkIsAppIsInstalled;
if(typeof successImport !='undefined')this.successImport=successImport;
if(typeof success !='undefined')this.success=success;
if(typeof fail !='undefined')this.fail=fail;
if(typeof failImport !='undefined')this.failImport=failImport;
if(typeof setAppValue !='undefined')this.setAppValue=setAppValue;
if(typeof setParameters !='undefined')this.setParameters=setParameters;
if(typeof positionButton !='undefined')this.positionButton=positionButton;
if(typeof closePage !='undefined')this.closePage=closePage;
if(typeof closeDetail_Click !='undefined')this.closeDetail_Click=closeDetail_Click;
if(typeof closeDetail_2_Click !='undefined')this.closeDetail_2_Click=closeDetail_2_Click;
if(typeof closeDetail_3_Click !='undefined')this.closeDetail_3_Click=closeDetail_3_Click;
if(typeof BtnGotoApp_Click !='undefined')this.BtnGotoApp_Click=BtnGotoApp_Click;
if(typeof BtnRegister_Click !='undefined')this.BtnRegister_Click=BtnRegister_Click;
if(typeof txt_mail_Validate !='undefined')this.txt_mail_Validate=txt_mail_Validate;
if(typeof BtnConfRegister_Click !='undefined')this.BtnConfRegister_Click=BtnConfRegister_Click;
if(typeof spRreg_Result !='undefined')this.spRreg_Result=spRreg_Result;
if(typeof setItem_applist !='undefined')this.setItem_applist=setItem_applist;
if(typeof hideQrDetail !='undefined')this.hideQrDetail=hideQrDetail;
if(typeof showQrDetail !='undefined')this.showQrDetail=showQrDetail;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
  this.EnablePage(3);
}
this.EnablePage(1);
this.EnablePage(2);
this.EnablePage(3);
var ua = navigator.userAgent
  , device = "<%=JSPLib.GetUserAgent(request)%>"
;
var item_applist;
var left_distance;
var arrBtn=[];
var app_title,app_descr,app_logo,app_access,app_url,app_apkUrl;
// eliminazione tabstrip
var tabstrip = window[this.formid + '_tabstrip'];  
 function hideTabStrip(){
   tabstrip.HideTabsContainer();
}
this.hideTabStrip();
function setPage(nPage){
  this.ZtTabs.Select('page'+nPage,nPage);
}
function this_Loaded(){
 // centra bottone BtnGotoApp
 this.BtnGotoApp.Ctrl.style.left = '50%';
 this.BtnGotoApp.Ctrl.style.marginLeft = -((this.width/2-this.BtnGotoApp.leftposition)+this.BtnGotoApp.Ctrl.width/2)+'px';   
 // centra il bottone BtnRegister
 this.BtnRegister.Ctrl.style.left = '50%';
 this.BtnRegister.Ctrl.style.marginLeft = -((this.width/2-this.BtnRegister.leftposition)+this.BtnRegister.Ctrl.width/2)+'px';   
}
function isIAR(){
  return navigator.userAgent.match(/zRuntime/);
}
function BtnQR_Click(){
  this.startQrPortlet(this.url.Value());
}
function BtnQrNative_Click(){
  this.startQrPortlet(this.apkUrl.Value());
}
function BtnInstallBrowser_Click(){
  if(this.isIAR())
    window.open("it.zucchetti.sitepainter.iar:"+this.url.Value(),"_blank");
  else
    window.open(this.url.Value(),"_blank");
}
function BtnInstallNative_Click(){
  window.open(this.apkUrl.Value(),"_blank");
}
function startQrPortlet(urlParam){
  var portletQrDetail='spas_pqrdetail_app';
  var pQrDetail=ZtVWeb.getPortlet(portletQrDetail);//ritorna se costruito
  if(!pQrDetail){
	  var div=document.createElement('div');
  	div.id='divQrDetail';
  	document.body.appendChild(div);
  	ZtVWeb.Include('../jsp/'+portletQrDetail+'_portlet.jsp', div);
  	pQrDetail=ZtVWeb.getPortlet(portletQrDetail);
    pQrDetail.setItem_rifpdetail(this);
  }
  pQrDetail.setParameters(this.lbl_title.Value(),this.lbl_descr.Value(),this.imm_logo.Value(),urlParam);
  div=document.getElementById('divQrDetail');
  div.style.position='absolute';
  var portletHeader;
  if(device=='SMARTPHONE'){
    // portlet centrato
    div.style.left="";
    div.style.width="100%";
    pQrDetail.Ctrl.style['max-width']="95%";
    pQrDetail.Ctrl.style.margin="auto";
    
    portletHeader='spas_pheaderstore_small';
  }else{
    portletHeader='spas_pheaderstore';
  }
  this.height_top.Value(ZtVWeb.getPortlet(portletHeader).height);
  div.style.top=parseInt(this.height_top.Value())+20+'px';			
  div.style.left=((window.innerWidth-pQrDetail.width)/2)+'px';
  div.style.zIndex='15';
  this.showQrDetail();
}
function checkIsAppIsInstalled(urlApp){
  var self=this;
  urlApp=urlApp.split('/').filter(function clear (token) {
        	return token.length > 0;
        } ).join("/");
  if(this.isIAR()){
    function successImport(){
    	function success(obj){
        for(var i=0;i<obj.length;i++){
          var urlTmp=obj[i].url;
          urlTmp=urlTmp.split('/').filter(function clear (token) {
        																		return token.length > 0;
																	        } ).join("/");
          if(urlTmp == urlApp){
          	self.BtnInstallBrowser.Value("Open");
          }//if
        }//for
      }//success
      function fail(){
      	console.log('Read installed apps from device failed');
      }
    	ShortcutPlugin.getInstalledApps(this.success,this.fail);
    }//successImport
    function failImport(err){
    	console.log('Import cordova failed'); 
    }
    LibJavascript.importCordova(this.successImport,this.failImport);
  }
}
function setAppValue(title,descr,logo,access,url,apkUrl){
    this.checkIsAppIsInstalled(url);
    arrBtn=[];
    this.lbl_title.Value(title);
    this.lbl_descr.Value(descr);
    this.imm_logo.Value(logo);
    this.url.Value(url);
    this.apkUrl.Value(apkUrl);
    this.BtnQR.Hide();
    this.BtnInstallBrowser.Hide();
    this.BtnInstallNative.Hide();
    this.BtnQrNative.Hide();
    if(device == "SMARTPHONE" || device == "ANDROID" || device == "IPAD" || device == "TABLET" || device =="MOBILE"){
      if(access=='browser_and_hybrid' || access=='browser_only'){
        if(this.isIAR())
          this.BtnInstallBrowser.Value("Install")
          this.BtnInstallBrowser.Show();
        arrBtn.push(this.BtnInstallBrowser);
      }
      if(access=='browser_and_hybrid' || access=='hybrid_only'){
        if(this.isIAR()) {
          this.BtnInstallNative.Value("Download App");
          this.BtnInstallNative.Ctrl.style.whiteSpace='normal';
        }
        if('<%=JSPLib.GetMobileOperationSystem(request)%>'==='ANDROID'){
          this.BtnInstallNative.Show();
          arrBtn.push(this.BtnInstallNative); 
        }
      }
    }else if(!window.openDatabase){					//if haven't databases property the devices can't install app on browser 
      if(access=='browser_and_hybrid' || access=='browser_only' ){	
        this.BtnQR.Show();
        arrBtn.push(this.BtnQR);
      }
      if(access=='browser_and_hybrid' || access=='hybrid_only' ){
        this.BtnQrNative.Show();
        arrBtn.push(this.BtnQrNative);
      }
    }else{ 		
      if(access=='browser_and_hybrid' || access=='browser_only' ){
        this.BtnQR.Show();
        arrBtn.push(this.BtnQR);
        this.BtnInstallBrowser.Show();
        arrBtn.push(this.BtnInstallBrowser);
      }
      if(access=='browser_and_hybrid' || access=='hybrid_only' ){  
        this.BtnQrNative.Show();
        arrBtn.push(this.BtnQrNative);
      }
    }
    this.positionButton();
}
function setParameters(title,descr,logo,access,url,apkUrl,modstore,code,nPage){
  app_title=title;
  app_descr=descr;
  app_logo=logo;
  app_access=access;
  app_url=url;
  app_apkUrl=apkUrl;
  this.code.Value(code);
  if(modstore=='offline'){
    this.isOnline.Value(false)
  }else{
    this.isOnline.Value(true)
  }
  if(nPage==1){
    this.setAppValue(app_title,app_descr,app_logo,app_access,app_url,app_apkUrl) 
    this.setPage(1);
  }else{
    // inizializzo valori
    this.lbl_title_2.Value(FormatMsg("MSG_APPREG_WELCOME",title));
    this.lbl_title_3.Value(FormatMsg("MSG_APPREG_WELCOME",title));
    this.txt_namesurname.Ctrl_input.placeholder=this.lbl_namesurname.Value();
    this.txt_namesurname.Ctrl_input.autocorrect="off"
    this.txt_company.Ctrl_input.placeholder=this.lbl_company.Value();
    this.txt_company.Ctrl_input.autocorrect="off"
    this.txt_mail.Ctrl_input.placeholder=this.lbl_mail.Value();
    this.txt_mail.Ctrl_input.type="email"; // fa apparire tastiera per inserimento indirizzo mail
    this.txt_mail.Ctrl_input.setAttribute("required",null); // obbligatorio
    this.txt_note.Ctrl_input.placeholder=this.lbl_note.Value();    
    
    this.setPage(2);
  }  
}
function positionButton(){
  var widthBtn=[];
  var sumWidthBtn=0;
  for(i=0;i<arrBtn.length;i++){
    widthBtn.push(arrBtn[i].controlwidth);
    sumWidthBtn+=widthBtn[i];
  }
  var spaceBetweenButton=10;
  var left_distance_first_button=((this.width-sumWidthBtn-spaceBetweenButton*arrBtn.length))/2;
  for(i=0;i<arrBtn.length;i++){
    
    arrBtn[i].Ctrl.style.left=left_distance_first_button+i*spaceBetweenButton+i*widthBtn[i]+"px";
  }  
} 
function closePage(){
 item_applist.hideDetail();
 item_applist.showStore();
}
function closeDetail_Click(){
  this.closePage();
 
}
function closeDetail_2_Click(){
 this.closePage();
}
function closeDetail_3_Click(){
 this.closePage();
}
function BtnGotoApp_Click(){
  this.setAppValue(app_title,app_descr,app_logo,app_access,app_url,app_apkUrl);
  this.setPage(1);
}
function BtnRegister_Click(){
  this.setPage(3);
}
function txt_mail_Validate(){
 mymail=this.txt_mail.Value();
  if(!Empty(mymail)){ 
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mymail)){  
      return (true)  
    } else { 
      alert(FormatMsg("Indirizzo mail non valido!"))  
      return (false)  
    }
  } else {
   return (true)
  }  
}
function BtnConfRegister_Click(){
  if(Empty(this.txt_mail.Value())){
     alert(FormatMsg("Indirizzo mail obbligatorio!"))  
     this.txt_mail.SetFocus()
  }   
  this.spRreg.Link()   
}
function spRreg_Result(result){
  if(Empty(result)) {
    alert(FormatMsg("MSG_APPREG_REG_COMPLETE"));
    this.setAppValue(app_title,app_descr,app_logo,app_access,app_url,app_apkUrl);
    // ripulisco i dati appena inseriti: contrordine da Aulla: lasciamo quelli appena inseriti
    //this.txt_namesurname.Value("");
    //this.txt_company.Value("");
    //this.txt_mail.Value("");
    //this.txt_note.Value("");
    this.setPage(1);
  } else {
    alert(FormatMsg(result))
  }
}
function setItem_applist(rifPortlet){
 	item_applist=rifPortlet; 
}
function hideQrDetail(){
  var div=document.getElementById('divQrDetail');
  div.style.display='none';
}
function showQrDetail(){
  var div=document.getElementById('divQrDetail');
  div.style.display='';
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spas_pdetail_app_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.closeDetail.dispatchEvent('OnLoad');
window.<%=idPortlet%>.closeDetail_2.dispatchEvent('OnLoad');
window.<%=idPortlet%>.closeDetail_3.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','spas_pdetail_app',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spas_pdetail_app');
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
sp.endPage("spas_pdetail_app");
}%>
<%! public String getJSPUID() { return "2922331979"; } %>