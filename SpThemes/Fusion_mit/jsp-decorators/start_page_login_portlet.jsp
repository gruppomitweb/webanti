<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.m_cIPClient.Value('\u003c%out.print(request.getRemoteAddr());%\u003e'); \nthis.m_cIPServer.Value('\u003c%out.print(request.getServerName());%\u003e'); \nthis.m_cIPSPorta.Value('\u003c%out.print(request.getServerPort());%\u003e'); \nthis.m_cIPProtocol.Value('\u003c%out.print(request.getScheme());%\u003e'); \nthis.m_cBrowser.Value('\u003c%out.print(request.getHeader(\"User-Agent\"));%\u003e');\n\n\u003c%if(!sp.hasAdministeredUsers()){%\u003e\n  window.location=\"..\u002fjsp\u002fdefault.jsp\";\n\u003c%}%\u003e\n\n\u002f\u002f this.dataobj_companies.Query();\nfunction dataobj_companies_ConsumersRendered(){\n  if(this.dataobj_companies.isEmpty()){\n  this.g_codazi.Hide();\n  }\n  if(this.dataobj_companies.GetQueryCount()==\"1\"){\n    this.g_codazi.empty_value=false;\n  }\n}\n\nfunction image_captcha_Click(){\n  this.image_captcha.Value('..\u002fservlet\u002fSPImageCaptchaServlet?a='+Math.random());\n}\nfunction image_captcha_new_code_Click(){\n  this.image_captcha_Click();\n}\nif(this.m_cFailedLoginReason.Value())\n  this.errore.Value(this.m_cFailedLoginReason.Value());\n\u002f\u002felse\n  \u002f\u002fthis.errore.Hide();\n\n\u003c%if(com.zucchetti.sitepainter.Library.captchaMustBeShown(request)){\n\u002f\u002fda esplorare la possibilita' di chiedere captcha di una certa dimensione piuttosto che averla\n\u002f\u002ffissa lato server\n%\u003e\nthis.image_captcha.Ctrl.style.width='\u003c%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageWidth\u002f2%\u003epx';\nthis.image_captcha.Ctrl.style.height='\u003c%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageHeight\u002f2%\u003epx';\nthis.image_captcha.Value('..\u002fservlet\u002fSPImageCaptchaServlet');\n\u003c%}else{%\u003e\nthis.m_cCaptcha.Hide();\nthis.image_captcha.Hide();\nthis.image_captcha_new_code.Hide();\n\u003c%}%\u003e\n\nfunction this_OnSubmit(){\n  this.pPwd.Value(this.m_cPassword.Value())\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"type\":\"box\",\"name\":\"boxUp_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#F0A30A\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"boxUp_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:260px; height:362px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"bg_color\\\":\\\"#F0A30A\\\"}\",\"code\":\".boxUp_class{background-color: rgba(240, 163, 10, 1) ;background-size: cover;}\\n\"},{\"type\":\"box\",\"name\":\"Box47_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#EAEAEA\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"Box47_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:699px; height:59px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"bg_color\\\":\\\"#EAEAEA\\\"}\",\"code\":\".Box47_class{background-color: rgba(234, 234, 234, 1) ;background-size: cover;}\\n\"},{\"type\":\"label\",\"name\":\"lblCredenziali_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"16\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"align\\\":\\\"left\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"label0\\\",\\\"type\\\":\\\"Label\\\",\\\"class_name\\\":\\\"lblCredenziali_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:280px;\\\\\\\"\u003eCredenziali di accesso\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\"Credenziali di accesso\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"16\\\"}\",\"code\":\".lblCredenziali_class{text-decoration: none;text-transform: none;font-style: normal;font-weight: normal;font-size: 16px;font-family: Arial, Helvetica, sans-serif;text-align: left;}\\n\"},{\"type\":\"image\",\"name\":\"ImgIcon_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"opacity\\\":\\\"40\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"src\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"image0\\\",\\\"type\\\":\\\"Image\\\",\\\"class_name\\\":\\\"ImgIcon_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:24px; height:24px;\\\\\\\" \u003e\u003cimg src=\\\\\\\"\\\\\\\" width=\\\\\\\"24\\\\\\\" height=\\\\\\\"24\\\\\\\"\u002f\u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"src\\\":\\\"\\\",\\\"page\\\":1,\\\"opacity\\\":\\\"40\\\"}\",\"code\":\".ImgIcon_class{opacity: 0.4;}\\n\"},{\"type\":\"textbox\",\"name\":\"m_cUserName_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_type\\\":\\\"solid\\\",\\\"border_width\\\":\\\"1\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_color\\\":\\\"#202020\\\",\\\"align\\\":\\\"left\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"textbox0\\\",\\\"type\\\":\\\"Textbox\\\",\\\"class_name\\\":\\\"m_cUserName_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:280px;\\\\\\\"\u003eundefined\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\" rtgrwegeg\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_width\\\":\\\"1\\\",\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_color\\\":\\\"#202020\\\"}\",\"code\":\".m_cUserName_class{border: 1px solid #DADADA;color: #202020;text-decoration: none;text-transform: none;font-style: normal;font-weight: normal;font-size: 12px;font-family: Arial, Helvetica, sans-serif;text-align: left;}\\n\"},{\"type\":\"textbox\",\"name\":\"input_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_type\\\":\\\"solid\\\",\\\"border_width\\\":\\\"1\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_color\\\":\\\"#202020\\\",\\\"align\\\":\\\"left\\\",\\\"pad_left\\\":\\\"10\\\",\\\"advanced_font\\\":\\\"Arial, Helvetica, sans-serif\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"textbox0\\\",\\\"type\\\":\\\"Textbox\\\",\\\"class_name\\\":\\\"input_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:280px; height:34px;\\\\\\\"\u003e\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\" \\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_width\\\":\\\"1\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_color\\\":\\\"#202020\\\",\\\"pad_left\\\":\\\"10\\\",\\\"advanced_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"offline_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"]}\",\"code\":\".input_class{padding: 0 0 0 10px;border: 1px solid #DADADA;font-family: Open Sans, sans-serif;color: #202020;text-decoration: none;text-transform: none;font-style: normal;font-weight: normal;font-size: 12px;text-align: left;}\\n\"},{\"type\":\"box\",\"name\":\"boxUp_class\",\"selector\":\".boxUp_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#535d70\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Coustard\\\",\\\"Antic Slab\\\",\\\"Quattrocento\\\",\\\"Cinzel\\\",\\\"Josefin Slab\\\",\\\"Merriweather\\\",\\\"Lora\\\",\\\"Nunito\\\",\\\"Abel\\\",\\\"Fjalla One\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Raleway\\\",\\\"Montserrat\\\",\\\"Roboto Condensed\\\",\\\"Oswald\\\",\\\"Special Elite\\\",\\\"Fredoka One\\\",\\\"Comfortaa\\\",\\\"Bangers\\\",\\\"Righteous\\\",\\\"Sigmar One\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Lobster\\\",\\\"Nova Mono\\\",\\\"Inconsolata\\\",\\\"Source Code Pro\\\",\\\"Anonymous Pro\\\",\\\"Roboto Mono\\\",\\\"Amatic SC\\\",\\\"Shadows Into Light\\\",\\\"Dancing Script\\\",\\\"Pacifico\\\",\\\"Indie Flower\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"box\\\",\\\"class_name\\\":\\\"boxUp_class\\\",\\\"selector\\\":\\\".boxUp_class\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#535d70\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".boxUp_class {\\n  background-color: #535d70;\\n}\\n\"},{\"type\":\"button\",\"name\":\"accedi_class\",\"selector\":\".accedi_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#3F68B5\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"border_radius_tl\\\":\\\"4px\\\",\\\"border_radius_tr\\\":\\\"4px\\\",\\\"border_radius_bl\\\":\\\"4px\\\",\\\"border_radius_br\\\":\\\"4px\\\",\\\"border_width\\\":\\\"0\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"16px\\\",\\\"weight\\\":\\\"300\\\",\\\"style\\\":\\\"normal\\\",\\\"font_color\\\":\\\"#fff\\\",\\\"align\\\":\\\"center\\\",\\\"code\\\":\\\"cursor:pointer;\\\"},\\\"hover\\\":{\\\"bg_color\\\":\\\"#1bbae1\\\"},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"button\\\",\\\"class_name\\\":\\\"accedi_class\\\",\\\"selector\\\":\\\".accedi_class\\\",\\\"value\\\":\\\"MSG_MENU_LOGIN\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#3F68B5\\\",\\\"border_radius_tl\\\":\\\"4px\\\",\\\"border_radius_tr\\\":\\\"4px\\\",\\\"border_radius_bl\\\":\\\"4px\\\",\\\"border_radius_br\\\":\\\"4px\\\",\\\"border_width\\\":\\\"0\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"16px\\\",\\\"weight\\\":\\\"300\\\",\\\"style\\\":\\\"normal\\\",\\\"font_color\\\":\\\"#fff\\\",\\\"align\\\":\\\"center\\\",\\\"code\\\":\\\"cursor:pointer;\\\"}\",\"code\":\".accedi_class {\\n  border-radius: 4px 4px 4px 4px;\\n  border: 0;\\n  background-color: #3F68B5;\\n  cursor: pointer;\\n  font-family: Open Sans, sans-serif;\\n  color: #fff;\\n  font-style: normal;\\n  font-weight: 300;\\n  font-size: 16px;\\n  text-align: center;\\n}\\n\\n.accedi_class:hover {\\n  background-color: #1bbae1;\\n}\\n\"},{\"type\":\"Label\",\"name\":\"lblTesto_class\",\"selector\":\".lblTesto_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"14\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"align\\\":\\\"left\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"#fff\\\",\\\"advanced_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"selector\\\":\\\".lblTesto_class\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"label0\\\",\\\"type\\\":\\\"Label\\\",\\\"class_name\\\":\\\"lblTesto_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:179px;\\\\\\\"\u003eLorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt...\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\"Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt...\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"14\\\",\\\"font_color\\\":\\\"#fff\\\",\\\"advanced_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"offline_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"selector\\\":\\\".lblTesto_class\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".lblTesto_class {\\n  font-family: Open Sans, sans-serif;\\n  color: #fff;\\n  text-decoration: none;\\n  text-transform: none;\\n  font-style: normal;\\n  font-weight: normal;\\n  font-size: 14px;\\n  text-align: left;\\n}\\n\",\"fontoffline\":\"Open Sans, sans-serif\"},{\"type\":\"label\",\"name\":\"lblTestoBlack_class\",\"selector\":\".lblTestoBlack_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"#000\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"lblTestoBlack_class\\\",\\\"selector\\\":\\\".lblTestoBlack_class\\\",\\\"value\\\":\\\"Access to this system is allowed for authorised users only. Activities are logged and monitored UNAUTHORISED ACCESS IS STRICTLY PROHIBITED\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"font_color\\\":\\\"#000\\\"}\",\"code\":\".lblTestoBlack_class {\\n  color: #000;\\n}\\n\"}]","description":"Login standard","fixed_top":"true","form_action":"..\u002fservlet\u002fseamless_login","form_enctype":"","form_target":"","form_type":"true","h":"566","hsl":"","htmlcode":"{{ @boxBar }}\n{{ @g_codazi }}\n{{ @dataobj_companies }}\n{{ @m_cURL }}\n{{ @m_cURLOnError }}\n{{ @m_cAction }}\n{{ @login_failed }}\n{{ @m_cFailedLoginReason }}\n{{ @m_cUserName }}\n{{ @m_cCaptcha }}\n{{ @m_cPassword }}\n{{ @image_captcha }}\n{{ @image_captcha_new_code }}\n{{ @errore }}\n{{ @pURL }}\n{{ @pURLOE }}\n{{ @lblVersione }}\n{{ @pUser }}\n{{ @pPwd }}\n{{ @pAzienda }}\n{{ @m_cIPClient }}\n{{ @pIPC }}\n{{ @ImgUser }}\n{{ @ImgPwd }}\n{{ @ImgWarning }}\n{{ @pIPS }}\n{{ @pIPSP }}\n{{ @m_cIPServer }}\n{{ @m_cIPSPorta }}\n{{ @m_cBrowser }}\n{{ @m_cIPProtocol }}\n{{ @pIPRP }}\n{{ @pBrowser }}\n{{ @lblCredenziali }}\n{{ @boxUp }}\n{{ @Accedi }}\n{{ @lblCopyright }}\n{{ @label44 }}\n{{ @Box47 }}\n{{ @ImageLogo }}\n{{ @Image41 }}\n{{ @RTRelease }}\n{{ @m_cOTP }}\n{{ @ImgOTP }}\n{{ boxBar }}\n{{ g_codazi }}\n{{ dataobj_companies }}\n{{ m_cURL }}\n{{ m_cURLOnError }}\n{{ m_cAction }}\n{{ login_failed }}\n{{ m_cFailedLoginReason }}\n{{ m_cUserName }}\n{{ m_cCaptcha }}\n{{ m_cPassword }}\n{{ image_captcha }}\n{{ image_captcha_new_code }}\n{{ errore }}\n{{ pURL }}\n{{ pURLOE }}\n{{ lblVersione }}\n{{ pUser }}\n{{ pPwd }}\n{{ pAzienda }}\n{{ m_cIPClient }}\n{{ pIPC }}\n{{ ImgUser }}\n{{ ImgPwd }}\n{{ ImgWarning }}\n{{ pIPS }}\n{{ pIPSP }}\n{{ m_cIPServer }}\n{{ m_cIPSPorta }}\n{{ m_cBrowser }}\n{{ m_cIPProtocol }}{{ ImgOTP }}\n{{ pIPRP }}\n{{ pBrowser }}\n{{ lblCredenziali }}{{ m_cOTP }}\n{{ boxUp }}\n{{ Accedi }}\n{{ lblCopyright }}\n{{ label44 }}\n{{ Box47 }}\n{{ ImageLogo }}\n{{ Image41 }}\n{{ RTRelease }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"700","layout_steps_values":"{\"320\":{\"h\":\"362\",\"w\":\"100%\"},\"400\":{\"h\":\"566\",\"w\":\"100%\"},\"480\":{\"h\":\"455\",\"w\":\"100%\"},\"700\":{\"h\":\"566\",\"w\":\"100%\"},\"-1\":{\"h\":\"455\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"700","my_library":"","offline":"false","on_security_failure":"default page","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,700","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"700","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","bg_color":"#FFFFFF","border_color":"","border_weight":"","class_Css":"boxprimary_login","create_undercond":"","h":"438","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":2,\"w\":320,\"h\":328,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"400\":{\"x\":0,\"y\":140,\"w\":400,\"h\":398,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":2,\"w\":\"480\",\"h\":398,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"700\":{\"x\":0,\"y\":100,\"w\":700,\"h\":438,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"}}","name":"boxBar","page":"1","sequence":"1","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"700","wireframe_props":"","x":"0","y":"100","zindex":"0"},{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"input_class","create_undercond":"","dataobj":"dataobj_companies","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"","font_size":"","h":"34","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{\"320\":{\"x\":150,\"y\":177,\"w\":128,\"h\":34,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"400\":{\"x\":187,\"y\":177,\"w\":160,\"h\":34,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"480\":{\"x\":226,\"y\":262,\"w\":\"192\",\"h\":34,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"700\":{\"x\":328,\"y\":333,\"w\":280,\"h\":34,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"}}","name":"g_codazi","page":"1","picture":"","sequence":"2","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"","valuelist":"codazi","visible":"false","w":"280","wireframe_props":"name,textlist","x":"328","y":"333","zindex":"1"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"dataobj_companies","offline":"false","page":"1","parms":"","parms_source":"","query":"start_login_companies","query_async":"true","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"148","x":"2","y":"-35"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'jsp\u002fdefault.jsp'","name":"m_cURL","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"65","x":"701","y":"-18"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'jsp\u002findex.jsp?login_failed=true'","name":"m_cURLOnError","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"114","x":"768","y":"-18"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'execute'","name":"m_cAction","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"79","x":"884","y":"-18"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"login_failed","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"logic","w":"68","x":"965","y":"-18"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"m_cFailedLoginReason","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"memo","w":"124","x":"1035","y":"-18"},{"anchor":"top-left(%)-right(%)-bottom","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"input_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"34","help_tips":"Inserisci username","hide":"","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{\"320\":{\"x\":150,\"y\":84,\"w\":128,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"},\"400\":{\"x\":187,\"y\":84,\"w\":160,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"},\"480\":{\"x\":225,\"y\":169,\"w\":\"192\",\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"},\"700\":{\"x\":328,\"y\":240,\"w\":280,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"}}","maxlength":"","name":"m_cUserName","page":"1","password":"","picture":"","placeholder":"MSG_USERNAME_STANDARD","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"280","wireframe_props":"name","x":"328","y":"240","zerofilling":"false","zindex":"1"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"input_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"32","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":152,\"y\":247,\"w\":\"102\",\"h\":23,\"anchor\":\"top-left\",\"hide\":\"\"},\"400\":{\"x\":152,\"y\":247,\"w\":\"102\",\"h\":23,\"anchor\":\"top-left\",\"hide\":\"\"},\"480\":{\"x\":274,\"y\":343,\"w\":\"102\",\"h\":23,\"anchor\":\"top-left\",\"hide\":\"\"},\"700\":{\"x\":393,\"y\":381,\"w\":\"215\",\"h\":32,\"anchor\":\"top-left\",\"hide\":\"\"}}","maxlength":"","name":"m_cCaptcha","page":"1","password":"","picture":"","placeholder":"MSG_CAPTCHA","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"215","wireframe_props":"name","x":"393","y":"381","zerofilling":"false","zindex":"1"},{"anchor":"top-left(%)-right(%)-bottom","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"input_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"34","help_tips":"Inserisci password","hide":"","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{\"320\":{\"x\":150,\"y\":132,\"w\":128,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"},\"400\":{\"x\":187,\"y\":132,\"w\":160,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"},\"480\":{\"x\":225,\"y\":217,\"w\":\"192\",\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"},\"700\":{\"x\":328,\"y\":288,\"w\":280,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"\"}}","maxlength":"","name":"m_cPassword","page":"1","password":"true","picture":"","placeholder":"MSG_PASSWORD_STANDARD","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"280","wireframe_props":"name","x":"328","y":"288","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"40","help_tips":"MSG_CAPTCHA_GENERATE_NEW","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":255,\"y\":212,\"w\":22,\"h\":40,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":318,\"y\":212,\"w\":27,\"h\":40,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":382,\"y\":303,\"w\":\"34\",\"h\":40,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":328,\"y\":374,\"w\":50,\"h\":40,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"image_captcha","page":"1","path_type":"","sequence":"12","server_side":"","spuid":"","src":"","srchover":"","tabindex":"-1","target":"","type":"Image","type_submit":"false","w":"50","wireframe_props":"","x":"328","y":"374","zindex":"1"},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"ImgIcon_class","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xec4d;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"18","help_tips":"MSG_CAPTCHA_GENERATE_NEW","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":234,\"y\":252,\"w\":\"16\",\"h\":16,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":234,\"y\":229,\"w\":\"16\",\"h\":16,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":356,\"y\":347,\"w\":\"16\",\"h\":16,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":582,\"y\":388,\"w\":\"18\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"image_captcha_new_code","page":"1","path_type":"","sequence":"13","server_side":"","spuid":"","src":"..\u002fvisualweb\u002fimages\u002fgrid_refresh.png","srchover":"","tabindex":"6","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"582","y":"388","zindex":"1"},{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"lblTesto_class lblTestoBlack_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"90","h":"50","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":44,\"y\":275,\"w\":274,\"h\":50,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"90\"},\"400\":{\"x\":55,\"y\":275,\"w\":342,\"h\":50,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"90\"},\"480\":{\"x\":43,\"y\":373,\"w\":\"434\",\"h\":50,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"90\"},\"700\":{\"x\":49,\"y\":484,\"w\":601,\"h\":50,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"90\"}}","n_col":"1","name":"errore","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Digitare Utente e Password e premere il pulsante accedi per accedere all'applicativo","w":"601","wireframe_props":"align,value,n_col","x":"49","y":"484","zindex":"5"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'jsp\u002fdefault.jsp'","name":"pURL","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"65","x":"700","y":"-43"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'jsp\u002findex.jsp?login_failed=true'","name":"pURLOE","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"114","x":"769","y":"-43"},{"align":"right","anchor":"top-right-bottom","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"lblTesto_class lblTestoBlack_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"80","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":211,\"y\":337,\"w\":\"105\",\"h\":24,\"anchor\":\"bottom-right\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"80\"},\"400\":{\"x\":291,\"y\":337,\"w\":\"105\",\"h\":24,\"anchor\":\"bottom-right\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"80\"},\"480\":{\"x\":360,\"y\":430,\"w\":\"117\",\"h\":24,\"anchor\":\"top-right\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"80\"},\"700\":{\"x\":524,\"y\":541,\"w\":175,\"h\":24,\"anchor\":\"top-right-bottom\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"80\"}}","n_col":"1","name":"lblVersione","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Versione -","w":"175","wireframe_props":"align,value,n_col","x":"524","y":"541","zindex":"100"},{"calculate":"m_cUserName","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pUser","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"73","x":"888","y":"-41"},{"calculate":"m_cPassword","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pPwd","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"967","y":"-41"},{"calculate":"g_codazi","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pAzienda","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1040","y":"-41"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":922,\"y\":37,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"400\":{\"x\":922,\"y\":37,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"480\":{\"x\":922,\"y\":37,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"700\":{\"x\":922,\"y\":37,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"}}","maxlength":"","name":"m_cIPClient","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"21","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"922","y":"37","zerofilling":"false","zindex":"1"},{"calculate":"m_cIPClient","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPC","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1131","y":"-41"},{"alt":"","anchor":"top-left(%)-right(%)-bottom","bounded_position":"","class_Css":"ImgIcon_class","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xee99;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"16","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":267,\"y\":93,\"w\":7,\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":333,\"y\":93,\"w\":8,\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":400,\"y\":178,\"w\":\"11\",\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":583,\"y\":249,\"w\":17,\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"ImgUser","page":"1","path_type":"","sequence":"23","server_side":"","spuid":"","src":"..\u002fimages\u002frefresh.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"17","wireframe_props":"","x":"583","y":"249","zindex":"2"},{"alt":"","anchor":"top-left(%)-right(%)-bottom","bounded_position":"","class_Css":"ImgIcon_class","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xed02;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"16","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":267,\"y\":141,\"w\":7,\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":333,\"y\":141,\"w\":8,\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":400,\"y\":226,\"w\":\"11\",\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":583,\"y\":297,\"w\":17,\"h\":16,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"ImgPwd","page":"1","path_type":"","sequence":"24","server_side":"","spuid":"","src":"..\u002fimages\u002frefresh.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"17","wireframe_props":"","x":"583","y":"297","zindex":"2"},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"ImgIcon_class","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf071;","font_image_hover":"","font_name":"fontawesome-webfont","font_size":"","h":"24","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":15,\"y\":280,\"w\":\"24\",\"h\":24,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":15,\"y\":280,\"w\":\"24\",\"h\":24,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":15,\"y\":378,\"w\":\"24\",\"h\":24,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":15,\"y\":489,\"w\":\"24\",\"h\":24,\"anchor\":\"top-left\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"ImgWarning","page":"1","path_type":"","sequence":"25","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"24","wireframe_props":"","x":"15","y":"489","zindex":"10"},{"calculate":"m_cIPServer","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPS","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1207","y":"-41"},{"calculate":"m_cIPSPorta","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPSP","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1283","y":"-41"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":923,\"y\":60,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"400\":{\"x\":923,\"y\":60,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"480\":{\"x\":923,\"y\":60,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"700\":{\"x\":923,\"y\":60,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"}}","maxlength":"","name":"m_cIPServer","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"28","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"923","y":"60","zerofilling":"false","zindex":"1"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":922,\"y\":84,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"400\":{\"x\":922,\"y\":84,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"480\":{\"x\":922,\"y\":84,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"700\":{\"x\":922,\"y\":84,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"}}","maxlength":"","name":"m_cIPSPorta","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"29","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"922","y":"84","zerofilling":"false","zindex":"1"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":741,\"y\":61,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"400\":{\"x\":741,\"y\":61,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"480\":{\"x\":741,\"y\":61,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"700\":{\"x\":741,\"y\":61,\"w\":\"90\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"}}","maxlength":"","name":"m_cBrowser","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"30","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"741","y":"61","zerofilling":"false","zindex":"1"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":741,\"y\":37,\"w\":\"172\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"400\":{\"x\":741,\"y\":37,\"w\":\"172\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"480\":{\"x\":741,\"y\":37,\"w\":\"172\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"},\"700\":{\"x\":741,\"y\":37,\"w\":\"172\",\"h\":18,\"anchor\":\"top-left\",\"hide\":\"\"}}","maxlength":"","name":"m_cIPProtocol","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"31","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"172","wireframe_props":"name","x":"741","y":"37","zerofilling":"false","zindex":"1"},{"calculate":"m_cIPProtocol","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPRP","page":"1","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1359","y":"-41"},{"calculate":"m_cBrowser","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pBrowser","page":"1","reactive":"","sequence":"33","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1450","y":"-41"},{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"lblTesto_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"#535D70","font_size":"","font_weight":"","fontpct":"","h":"26","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":150,\"y\":54,\"w\":128,\"h\":26,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"85\"},\"400\":{\"x\":187,\"y\":54,\"w\":160,\"h\":26,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"85\"},\"480\":{\"x\":225,\"y\":136,\"w\":\"192\",\"h\":26,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"700\":{\"x\":328,\"y\":207,\"w\":280,\"h\":26,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblCredenziali","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"34","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CREDENTIAL_LOGIN","w":"280","wireframe_props":"align,value,n_col","x":"328","y":"207","zindex":"1"},{"anchor":"top-left(%)-right(%)-bottom","bg_color":"","border_color":"","border_weight":"","class_Css":"boxUp_class","create_undercond":"","h":"382","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":2,\"w\":136,\"h\":272,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"400\":{\"x\":0,\"y\":2,\"w\":170,\"h\":272,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":29,\"w\":\"165\",\"h\":342,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"700\":{\"x\":0,\"y\":100,\"w\":240,\"h\":382,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"}}","name":"boxUp","page":"1","sequence":"35","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"240","wireframe_props":"","x":"0","y":"100","zindex":"0"},{"anchor":"top-right-bottom","bg_color":"","border_color":"","border_weight":"","class_Css":"accedi_class","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"32","help_tips":"MSG_MENU_LOGIN","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":150,\"y\":215,\"w\":52,\"h\":32,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"400\":{\"x\":187,\"y\":215,\"w\":65,\"h\":32,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"480\":{\"x\":225,\"y\":310,\"w\":\"78\",\"h\":32,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\"},\"700\":{\"x\":493,\"y\":419,\"w\":115,\"h\":32,\"anchor\":\"top-right-bottom\",\"hide\":\"false\"}}","name":"Accedi","page":"1","sequence":"36","spuid":"","tabindex":"","type":"Button","type_submit":"true","type_wizard":"","value":"MSG_MENU_LOGIN","w":"115","wireframe_props":"value","x":"493","y":"419","zindex":"1"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"lblTesto_class lblTestoBlack_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"80","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":337,\"w\":\"206\",\"h\":24,\"anchor\":\"bottom-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"80\"},\"400\":{\"x\":1,\"y\":337,\"w\":\"206\",\"h\":24,\"anchor\":\"bottom-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"80\"},\"480\":{\"x\":1,\"y\":430,\"w\":\"354\",\"h\":24,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"80\"},\"700\":{\"x\":1,\"y\":541,\"w\":346,\"h\":24,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"80\"}}","n_col":"1","name":"lblCopyright","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"37","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Designed by WEB Development Team &copy; - Gruppo MIT S.r.l. - &copy;","w":"346","wireframe_props":"align,value,n_col","x":"1","y":"541","zindex":"1"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"lblTesto_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"180","h":"33","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":160,\"w\":136,\"h\":46,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"120\"},\"400\":{\"x\":0,\"y\":160,\"w\":170,\"h\":46,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"120\"},\"480\":{\"x\":0,\"y\":245,\"w\":\"165\",\"h\":33,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"180\"},\"700\":{\"x\":0,\"y\":334,\"w\":240,\"h\":33,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"180\"}}","n_col":"1","name":"label44","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"38","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"WEBAOS \u002f WEBTER","w":"240","wireframe_props":"align,value,n_col","x":"0","y":"334","zindex":"101"},{"anchor":"top-left(%)-right(%)-bottom","bg_color":"","border_color":"","border_weight":"0","class_Css":"Box47_class","create_undercond":"","h":"59","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":270,\"w\":320,\"h\":59,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"400\":{\"x\":0,\"y\":270,\"w\":400,\"h\":59,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":367,\"w\":\"480\",\"h\":59,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"},\"700\":{\"x\":0,\"y\":478,\"w\":700,\"h\":59,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"}}","name":"Box47","page":"1","sequence":"39","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"700","wireframe_props":"","x":"0","y":"478","zindex":"1"},{"alt":"","anchor":"top-left(%)-right(%)","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"63","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":183,\"y\":3,\"w\":56,\"h\":40,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":228,\"y\":3,\"w\":70,\"h\":40,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":277,\"y\":40,\"w\":\"83\",\"h\":59,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":411,\"y\":111,\"w\":121,\"h\":63,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"ImageLogo","page":"1","path_type":"","sequence":"40","server_side":"","spuid":"","src":"..\u002fimages\u002fmit.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"121","wireframe_props":"","x":"411","y":"111","zindex":"102"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-thumbnail","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"90","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":80,\"w\":118,\"h\":53,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"400\":{\"x\":7,\"y\":80,\"w\":147,\"h\":53,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":11,\"y\":125,\"w\":\"140\",\"h\":90,\"anchor\":\"top-left(%)-right(%)\",\"hide\":\"false\",\"font_size\":\"\"},\"700\":{\"x\":18,\"y\":199,\"w\":204,\"h\":90,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"Image41","page":"1","path_type":"","sequence":"41","server_side":"","spuid":"","src":"..\u002fimages\u002frisk.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"204","wireframe_props":"","x":"18","y":"199","zindex":"103"},{"allowedentities":"aosfn_release","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function autoexec","name":"RTRelease","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"42","servlet":"aosfn_release","target":"lblVersione","type":"SPLinker","w":"120","x":"201","y":"-31"},{"anchor":"top-left(%)-right(%)-bottom","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"input_class","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"34","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{\"320\":{\"x\":149,\"y\":292,\"w\":71,\"h\":34,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":223,\"y\":389,\"w\":106,\"h\":34,\"anchor\":\"\",\"hide\":\"false\"},\"700\":{\"x\":328,\"y\":418,\"w\":159,\"h\":34,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\"}}","maxlength":"6","name":"m_cOTP","page":"1","password":"","picture":"","placeholder":"MSG_OTP","readonly":"false","scroll":"false","sequence":"43","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"159","wireframe_props":"name","x":"328","y":"418","zerofilling":"false","zindex":"104"},{"alt":"","anchor":"top-left(%)-right(%)-bottom","bounded_position":"","class_Css":"ImgIcon_class","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xef7b;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"18","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":209,\"y\":301,\"w\":8,\"h\":18,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":313,\"y\":398,\"w\":12,\"h\":18,\"anchor\":\"\",\"hide\":\"false\"},\"700\":{\"x\":462,\"y\":427,\"w\":18,\"h\":18,\"anchor\":\"top-left(%)-right(%)-bottom\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"ImgOTP","page":"1","path_type":"","sequence":"44","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"462","y":"427","zindex":"105"}]%>
<%/*Description:Login standard*/%>
<%/*ParamsRequest:g_codazi,login_failed,m_cFailedLoginReason,m_cUserName,m_cPassword,m_cOTP*/%>
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
.start_page_login_container .boxUp_class{  background-color: #F0A30A;
  background-size: cover;
}
.start_page_login_container .Box47_class{
  background-color: #EAEAEA;
  background-size: cover;
}
.start_page_login_container .lblCredenziali_class{
  font-family: Arial, Helvetica, sans-serif;
  text-decoration: none;
  text-transform: none;
  font-style: normal;
  font-weight: normal;
  font-size: 16px;
  text-align: left;
}
.start_page_login_container .ImgIcon_class{
  opacity: 0.4;
}
.start_page_login_container .m_cUserName_class{
  border: 1px solid #DADADA;
  font-family: Arial, Helvetica, sans-serif;
  color: #202020;
  text-decoration: none;
  text-transform: none;
  font-style: normal;
  font-weight: normal;
  font-size: 12px;
  text-align: left;
}
.start_page_login_container .input_class{
  padding-left: 10px;
  border: 1px solid #DADADA;
  font-family: Open Sans, sans-serif;
  color: #202020;
  text-decoration: none;
  text-transform: none;
  font-style: normal;
  font-weight: normal;
  font-size: 12px;
  text-align: left;
}
.start_page_login_container .boxUp_class{
  background-color: #535d70;
}
.start_page_login_container .accedi_class{
  border-radius: 4px 4px 4px 4px;
  border: 0;
  background-color: #3F68B5;
  cursor:pointer;
  font-family: Open Sans, sans-serif;
  color: #fff;
  font-style: normal;
  font-weight: 300;
  font-size: 16px;
  text-align: center;
}
.start_page_login_container .accedi_class:hover{
  background-color: #1bbae1;
}
.start_page_login_container .lblTesto_class{
  font-family: Open Sans, sans-serif;
  color: #fff;
  text-decoration: none;
  text-transform: none;
  font-style: normal;
  font-weight: normal;
  font-size: 14px;
  text-align: left;
}
.start_page_login_container .lblTestoBlack_class{
  color: #000;
}
.start_page_login_container {
}
.start_page_login_title_container {
  margin: auto;
}
.start_page_login_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:700px;
  height:566px;
  background-color:transparent;
}
.start_page_login_portlet[Data-page="1"]{
  height:566px;
  width:100%;
}
.start_page_login_portlet[Data-step="320"] {
  height:362px;
  width:100%;
}
.start_page_login_portlet[Data-step="480"] {
  height:455px;
  width:100%;
}
.start_page_login_portlet[Data-step="700"] {
  height:566px;
  width:100%;
}
.start_page_login_portlet[Data-step="320"] > .boxBar_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:2px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:32px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .boxBar_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:2px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:55px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .boxBar_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:100px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:28px;
  width:auto;
}
.start_page_login_portlet > .boxBar_ctrl {
  min-height:438px;
  background-color:#FFFFFF;
}
.start_page_login_portlet[Data-step="320"] > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:177px;
  left:150px;
  left:46.875%;
  right:42px;
  right:13.125%;
  width:auto;
  height:34px;
}
.start_page_login_portlet[Data-step="480"] > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:262px;
  left:226px;
  left:47.083332%;
  right:62px;
  right:12.916667%;
  width:auto;
  height:34px;
}
.start_page_login_portlet[Data-step="700"] > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:333px;
  left:328px;
  left:46.857143%;
  right:92px;
  right:13.142858%;
  width:auto;
  height:34px;
}
.start_page_login_portlet[Data-step="320"] > .m_cUserName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  left:150px;
  left:46.875%;
  right:42px;
  right:13.125%;
  bottom:244px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .m_cUserName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:169px;
  left:225px;
  left:46.875%;
  right:63px;
  right:13.125%;
  bottom:252px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .m_cUserName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:240px;
  left:328px;
  left:46.857143%;
  right:92px;
  right:13.142858%;
  bottom:292px;
  width:auto;
}
.start_page_login_portlet > .m_cUserName_ctrl {
}
.start_page_login_portlet > .m_cUserName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .m_cCaptcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:247px;
  left:152px;
  width:102px;
  height:23px;
}
.start_page_login_portlet[Data-step="480"] > .m_cCaptcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:343px;
  left:274px;
  width:102px;
  height:23px;
}
.start_page_login_portlet[Data-step="700"] > .m_cCaptcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:381px;
  left:393px;
  width:215px;
  height:32px;
}
.start_page_login_portlet > .m_cCaptcha_ctrl {
}
.start_page_login_portlet > .m_cCaptcha_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .m_cPassword_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:132px;
  left:150px;
  left:46.875%;
  right:42px;
  right:13.125%;
  bottom:196px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .m_cPassword_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:217px;
  left:225px;
  left:46.875%;
  right:63px;
  right:13.125%;
  bottom:204px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .m_cPassword_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:288px;
  left:328px;
  left:46.857143%;
  right:92px;
  right:13.142858%;
  bottom:244px;
  width:auto;
}
.start_page_login_portlet > .m_cPassword_ctrl {
}
.start_page_login_portlet > .m_cPassword_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .image_captcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  left:255px;
  left:79.6875%;
  right:43px;
  right:13.4375%;
  width:auto;
  height:40px;
}
.start_page_login_portlet[Data-step="480"] > .image_captcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:303px;
  left:382px;
  left:79.583336%;
  right:64px;
  right:13.333333%;
  width:auto;
  height:40px;
}
.start_page_login_portlet[Data-step="700"] > .image_captcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:374px;
  left:328px;
  left:46.857143%;
  right:322px;
  right:46.0%;
  width:auto;
  height:40px;
}
.start_page_login_portlet > .image_captcha_ctrl {
}
.start_page_login_portlet > .image_captcha_ctrl > a, .start_page_login_portlet > .image_captcha_ctrl > a:hover{
  text-decoration:none;
}
.start_page_login_portlet > .image_captcha_ctrl > a > img{
  width:100%;
  vertical-align:top;
}
.start_page_login_portlet[Data-step="320"] > .image_captcha_ctrl > a > img {
  height:40px;
}
.start_page_login_portlet[Data-step="400"] > .image_captcha_ctrl > a > img {
  height:40px;
}
.start_page_login_portlet[Data-step="480"] > .image_captcha_ctrl > a > img {
  height:40px;
}
.start_page_login_portlet[Data-step="700"] > .image_captcha_ctrl > a > img {
  height:40px;
}
.start_page_login_portlet[Data-step="320"] > .image_captcha_new_code_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:252px;
  left:234px;
  width:16px;
  height:16px;
}
.start_page_login_portlet[Data-step="480"] > .image_captcha_new_code_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:347px;
  left:356px;
  width:16px;
  height:16px;
}
.start_page_login_portlet[Data-step="700"] > .image_captcha_new_code_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:388px;
  left:582px;
  width:18px;
  height:18px;
}
.start_page_login_portlet > .image_captcha_new_code_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:18px;
  font-size:18px;
}
.start_page_login_portlet[Data-step="320"] > .image_captcha_new_code_ctrl {
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="400"] > .image_captcha_new_code_ctrl {
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="480"] > .image_captcha_new_code_ctrl {
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="700"] > .image_captcha_new_code_ctrl {
  line-height:18px;
  font-size:18px;
}
.start_page_login_portlet[Data-step="320"] > .errore_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:275px;
  left:44px;
  left:13.75%;
  right:2px;
  right:0.625%;
  bottom:37px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .errore_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:373px;
  left:43px;
  left:8.958333%;
  right:3px;
  right:0.625%;
  width:auto;
  height:auto;
  min-height:50px;
}.start_page_login_portlet[Data-step="480"] > .errore_ctrl {
  height:auto;
  min-height:50px;
}
.start_page_login_portlet[Data-step="700"] > .errore_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:484px;
  left:49px;
  left:7.0%;
  right:50px;
  right:7.142857%;
  width:auto;
  height:auto;
  min-height:50px;
}.start_page_login_portlet[Data-step="700"] > .errore_ctrl {
  height:auto;
  min-height:50px;
}
.start_page_login_portlet > .errore_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet[Data-step="320"] > .errore_ctrl > div{
  font-size:90%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="400"] > .errore_ctrl > div{
  font-size:90%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="480"] > .errore_ctrl > div{
  font-size:90%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="700"] > .errore_ctrl > div{
  font-size:90%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="320"] > .lblVersione_ctrl {
  box-sizing:border-box;
  z-index:100;
  position:absolute;
  display:inline-block;
  right:4px;
  bottom:1px;
  width:105px;
  height:auto;
  min-height:24px;
}.start_page_login_portlet[Data-step="320"] > .lblVersione_ctrl {
  height:auto;
  min-height:24px;
}
.start_page_login_portlet[Data-step="480"] > .lblVersione_ctrl {
  box-sizing:border-box;
  z-index:100;
  position:absolute;
  display:inline-block;
  top:430px;
  right:3px;
  width:117px;
  height:auto;
  min-height:24px;
}.start_page_login_portlet[Data-step="480"] > .lblVersione_ctrl {
  height:auto;
  min-height:24px;
}
.start_page_login_portlet[Data-step="700"] > .lblVersione_ctrl {
  box-sizing:border-box;
  z-index:100;
  position:absolute;
  display:inline-block;
  top:541px;
  right:1px;
  bottom:1px;
  width:175px;
}
.start_page_login_portlet > .lblVersione_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.start_page_login_portlet[Data-step="320"] > .lblVersione_ctrl > div{
  font-size:80%;
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="400"] > .lblVersione_ctrl > div{
  font-size:80%;
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="480"] > .lblVersione_ctrl > div{
  font-size:80%;
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="700"] > .lblVersione_ctrl > div{
  font-size:80%;
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="320"] > .m_cIPClient_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:922px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="480"] > .m_cIPClient_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:922px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="700"] > .m_cIPClient_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:922px;
  width:90px;
  height:18px;
}
.start_page_login_portlet > .m_cIPClient_ctrl {
  display:none;
}
.start_page_login_portlet > .m_cIPClient_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .ImgUser_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:93px;
  left:267px;
  left:83.4375%;
  right:46px;
  right:14.375%;
  bottom:253px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .ImgUser_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:178px;
  left:400px;
  left:83.333336%;
  right:69px;
  right:14.375%;
  bottom:261px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .ImgUser_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:249px;
  left:583px;
  left:83.28571%;
  right:100px;
  right:14.285714%;
  bottom:301px;
  width:auto;
}
.start_page_login_portlet > .ImgUser_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="320"] > .ImgUser_ctrl {
  line-height:16px;
  font-size:7px;
}
.start_page_login_portlet[Data-step="400"] > .ImgUser_ctrl {
  line-height:16px;
  font-size:8px;
}
.start_page_login_portlet[Data-step="480"] > .ImgUser_ctrl {
  line-height:16px;
  font-size:11px;
}
.start_page_login_portlet[Data-step="700"] > .ImgUser_ctrl {
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="320"] > .ImgPwd_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:141px;
  left:267px;
  left:83.4375%;
  right:46px;
  right:14.375%;
  bottom:205px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .ImgPwd_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:226px;
  left:400px;
  left:83.333336%;
  right:69px;
  right:14.375%;
  bottom:213px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .ImgPwd_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:297px;
  left:583px;
  left:83.28571%;
  right:100px;
  right:14.285714%;
  bottom:253px;
  width:auto;
}
.start_page_login_portlet > .ImgPwd_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="320"] > .ImgPwd_ctrl {
  line-height:16px;
  font-size:7px;
}
.start_page_login_portlet[Data-step="400"] > .ImgPwd_ctrl {
  line-height:16px;
  font-size:8px;
}
.start_page_login_portlet[Data-step="480"] > .ImgPwd_ctrl {
  line-height:16px;
  font-size:11px;
}
.start_page_login_portlet[Data-step="700"] > .ImgPwd_ctrl {
  line-height:16px;
  font-size:16px;
}
.start_page_login_portlet[Data-step="320"] > .ImgWarning_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:280px;
  left:15px;
  width:24px;
  height:24px;
}
.start_page_login_portlet[Data-step="480"] > .ImgWarning_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:378px;
  left:15px;
  width:24px;
  height:24px;
}
.start_page_login_portlet[Data-step="700"] > .ImgWarning_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:489px;
  left:15px;
  width:24px;
  height:24px;
}
.start_page_login_portlet > .ImgWarning_ctrl {
  text-decoration:none;
  font-family:fontawesome-webfont;
  text-align:center;
  line-height:24px;
  font-size:24px;
}
.start_page_login_portlet[Data-step="320"] > .ImgWarning_ctrl {
  line-height:24px;
  font-size:24px;
}
.start_page_login_portlet[Data-step="400"] > .ImgWarning_ctrl {
  line-height:24px;
  font-size:24px;
}
.start_page_login_portlet[Data-step="480"] > .ImgWarning_ctrl {
  line-height:24px;
  font-size:24px;
}
.start_page_login_portlet[Data-step="700"] > .ImgWarning_ctrl {
  line-height:24px;
  font-size:24px;
}
.start_page_login_portlet[Data-step="320"] > .m_cIPServer_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:923px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="480"] > .m_cIPServer_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:923px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="700"] > .m_cIPServer_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:923px;
  width:90px;
  height:18px;
}
.start_page_login_portlet > .m_cIPServer_ctrl {
  display:none;
}
.start_page_login_portlet > .m_cIPServer_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .m_cIPSPorta_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  left:922px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="480"] > .m_cIPSPorta_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  left:922px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="700"] > .m_cIPSPorta_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  left:922px;
  width:90px;
  height:18px;
}
.start_page_login_portlet > .m_cIPSPorta_ctrl {
  display:none;
}
.start_page_login_portlet > .m_cIPSPorta_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .m_cBrowser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:741px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="480"] > .m_cBrowser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:741px;
  width:90px;
  height:18px;
}
.start_page_login_portlet[Data-step="700"] > .m_cBrowser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:741px;
  width:90px;
  height:18px;
}
.start_page_login_portlet > .m_cBrowser_ctrl {
  display:none;
}
.start_page_login_portlet > .m_cBrowser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .m_cIPProtocol_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:741px;
  width:172px;
  height:18px;
}
.start_page_login_portlet[Data-step="480"] > .m_cIPProtocol_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:741px;
  width:172px;
  height:18px;
}
.start_page_login_portlet[Data-step="700"] > .m_cIPProtocol_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:741px;
  width:172px;
  height:18px;
}
.start_page_login_portlet > .m_cIPProtocol_ctrl {
  display:none;
}
.start_page_login_portlet > .m_cIPProtocol_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .lblCredenziali_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:54px;
  left:150px;
  left:46.875%;
  right:42px;
  right:13.125%;
  width:auto;
  height:auto;
  min-height:26px;
}.start_page_login_portlet[Data-step="320"] > .lblCredenziali_ctrl {
  height:auto;
  min-height:26px;
}
.start_page_login_portlet[Data-step="480"] > .lblCredenziali_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:136px;
  left:225px;
  left:46.875%;
  right:63px;
  right:13.125%;
  width:auto;
  height:auto;
  min-height:26px;
}.start_page_login_portlet[Data-step="480"] > .lblCredenziali_ctrl {
  height:auto;
  min-height:26px;
}
.start_page_login_portlet[Data-step="700"] > .lblCredenziali_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:207px;
  left:328px;
  left:46.857143%;
  right:92px;
  right:13.142858%;
  width:auto;
  height:auto;
  min-height:26px;
}.start_page_login_portlet[Data-step="700"] > .lblCredenziali_ctrl {
  height:auto;
  min-height:26px;
}
.start_page_login_portlet > .lblCredenziali_ctrl {
  overflow:hidden;
  color:#535D70;
  text-align:center;
  background-color:transparent;
}
.start_page_login_portlet[Data-step="320"] > .lblCredenziali_ctrl > div{
  font-size:85%;
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="400"] > .lblCredenziali_ctrl > div{
  font-size:85%;
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="480"] > .lblCredenziali_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="700"] > .lblCredenziali_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="320"] > .boxUp_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:2px;
  left:0px;
  left:0.0%;
  right:184px;
  right:57.5%;
  width:auto;
  height:auto;
  min-height:272px;
}.start_page_login_portlet[Data-step="320"] > .boxUp_ctrl {
  height:272px;
  display:flex;
  flex-direction:column;
}
.start_page_login_portlet > .boxUp_ctrl > .box_content {
  height:100%;
}
.start_page_login_portlet[Data-step="480"] > .boxUp_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:29px;
  left:0px;
  left:0.0%;
  right:315px;
  right:65.625%;
  bottom:84px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .boxUp_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:100px;
  left:0px;
  left:0.0%;
  right:460px;
  right:65.71429%;
  bottom:84px;
  width:auto;
}
.start_page_login_portlet > .boxUp_ctrl {
  min-height:382px;
}
.start_page_login_portlet[Data-step="320"] > .Accedi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:215px;
  left:150px;
  left:46.875%;
  right:118px;
  right:36.875%;
  width:auto;
  height:32px;
}
.start_page_login_portlet[Data-step="480"] > .Accedi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:310px;
  left:225px;
  left:46.875%;
  right:177px;
  right:36.875%;
  width:auto;
  height:32px;
}
.start_page_login_portlet[Data-step="700"] > .Accedi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:419px;
  right:92px;
  bottom:115px;
  width:115px;
}
.start_page_login_portlet > .Accedi_ctrl {
}
.start_page_login_portlet[Data-step="320"] > .lblCopyright_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  left:1px;
  bottom:1px;
  width:206px;
  height:auto;
  min-height:24px;
}.start_page_login_portlet[Data-step="320"] > .lblCopyright_ctrl {
  height:auto;
  min-height:24px;
}
.start_page_login_portlet[Data-step="480"] > .lblCopyright_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:430px;
  left:1px;
  left:0.20833333%;
  right:125px;
  right:26.041666%;
  width:auto;
  height:auto;
  min-height:24px;
}.start_page_login_portlet[Data-step="480"] > .lblCopyright_ctrl {
  height:auto;
  min-height:24px;
}
.start_page_login_portlet[Data-step="700"] > .lblCopyright_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:541px;
  left:1px;
  left:0.14285715%;
  right:353px;
  right:50.42857%;
  width:auto;
  height:auto;
  min-height:24px;
}.start_page_login_portlet[Data-step="700"] > .lblCopyright_ctrl {
  height:auto;
  min-height:24px;
}
.start_page_login_portlet > .lblCopyright_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet[Data-step="320"] > .lblCopyright_ctrl > div{
  font-size:80%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="400"] > .lblCopyright_ctrl > div{
  font-size:80%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="480"] > .lblCopyright_ctrl > div{
  font-size:80%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="700"] > .lblCopyright_ctrl > div{
  font-size:80%;
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="320"] > .label44_ctrl {
  box-sizing:border-box;
  z-index:101;
  position:absolute;
  display:inline-block;
  top:160px;
  left:0px;
  left:0.0%;
  right:184px;
  right:57.5%;
  bottom:156px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .label44_ctrl {
  box-sizing:border-box;
  z-index:101;
  position:absolute;
  display:inline-block;
  top:245px;
  left:0px;
  left:0.0%;
  right:315px;
  right:65.625%;
  width:auto;
  height:auto;
  min-height:33px;
}.start_page_login_portlet[Data-step="480"] > .label44_ctrl {
  height:auto;
  min-height:33px;
}
.start_page_login_portlet[Data-step="700"] > .label44_ctrl {
  box-sizing:border-box;
  z-index:101;
  position:absolute;
  display:inline-block;
  top:334px;
  left:0px;
  left:0.0%;
  right:460px;
  right:65.71429%;
  width:auto;
  height:auto;
  min-height:33px;
}.start_page_login_portlet[Data-step="700"] > .label44_ctrl {
  height:auto;
  min-height:33px;
}
.start_page_login_portlet > .label44_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.start_page_login_portlet[Data-step="320"] > .label44_ctrl > div{
  font-size:120%;
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="400"] > .label44_ctrl > div{
  font-size:120%;
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="480"] > .label44_ctrl > div{
  font-size:180%;
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="700"] > .label44_ctrl > div{
  font-size:180%;
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_login_portlet[Data-step="320"] > .Box47_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:270px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:33px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .Box47_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:367px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:29px;
  width:auto;
}
.start_page_login_portlet[Data-step="700"] > .Box47_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:478px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:29px;
  width:auto;
}
.start_page_login_portlet > .Box47_ctrl {
  min-height:59px;
  border-width:0px;
  border-style:solid;
}
.start_page_login_portlet[Data-step="320"] > .ImageLogo_ctrl {
  box-sizing:border-box;
  z-index:102;
  position:absolute;
  display:inline-block;
  top:3px;
  left:183px;
  left:57.1875%;
  right:81px;
  right:25.3125%;
  width:auto;
  height:40px;
}
.start_page_login_portlet[Data-step="480"] > .ImageLogo_ctrl {
  box-sizing:border-box;
  z-index:102;
  position:absolute;
  display:inline-block;
  top:40px;
  left:277px;
  left:57.708332%;
  right:120px;
  right:25.0%;
  width:auto;
  height:59px;
}
.start_page_login_portlet[Data-step="700"] > .ImageLogo_ctrl {
  box-sizing:border-box;
  z-index:102;
  position:absolute;
  display:inline-block;
  top:111px;
  left:411px;
  left:58.714287%;
  right:168px;
  right:24.0%;
  width:auto;
  height:63px;
}
.start_page_login_portlet > .ImageLogo_ctrl {
}
.start_page_login_portlet > .ImageLogo_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet[Data-step="320"] > .Image41_ctrl {
  box-sizing:border-box;
  z-index:103;
  position:absolute;
  display:inline-block;
  top:80px;
  left:6px;
  left:1.875%;
  right:196px;
  right:61.25%;
  bottom:229px;
  width:auto;
}
.start_page_login_portlet[Data-step="480"] > .Image41_ctrl {
  box-sizing:border-box;
  z-index:103;
  position:absolute;
  display:inline-block;
  top:125px;
  left:11px;
  left:2.2916667%;
  right:329px;
  right:68.541664%;
  width:auto;
  height:90px;
}
.start_page_login_portlet[Data-step="700"] > .Image41_ctrl {
  box-sizing:border-box;
  z-index:103;
  position:absolute;
  display:inline-block;
  top:199px;
  left:18px;
  left:2.5714285%;
  right:478px;
  right:68.28571%;
  width:auto;
  height:90px;
}
.start_page_login_portlet > .Image41_ctrl {
}
.start_page_login_portlet > .Image41_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet[Data-step="320"] > .m_cOTP_ctrl {
  box-sizing:border-box;
  z-index:104;
  position:absolute;
  display:inline-block;
  top:292px;
  left:149px;
  left:46.5625%;
  right:100px;
  right:31.25%;
  width:auto;
  height:34px;
}
.start_page_login_portlet[Data-step="480"] > .m_cOTP_ctrl {
  box-sizing:border-box;
  z-index:104;
  position:absolute;
  display:inline-block;
  top:389px;
  left:223px;
  left:46.458332%;
  right:151px;
  right:31.458334%;
  width:auto;
  height:34px;
}
.start_page_login_portlet[Data-step="700"] > .m_cOTP_ctrl {
  box-sizing:border-box;
  z-index:104;
  position:absolute;
  display:inline-block;
  top:418px;
  left:328px;
  left:46.857143%;
  right:213px;
  right:30.428572%;
  bottom:114px;
  width:auto;
}
.start_page_login_portlet > .m_cOTP_ctrl {
}
.start_page_login_portlet > .m_cOTP_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.start_page_login_portlet[Data-step="320"] > .ImgOTP_ctrl {
  box-sizing:border-box;
  z-index:105;
  position:absolute;
  display:inline-block;
  top:301px;
  left:209px;
  left:65.3125%;
  right:103px;
  right:32.1875%;
  width:auto;
  height:18px;
}
.start_page_login_portlet[Data-step="480"] > .ImgOTP_ctrl {
  box-sizing:border-box;
  z-index:105;
  position:absolute;
  display:inline-block;
  top:398px;
  left:313px;
  left:65.208336%;
  right:155px;
  right:32.291668%;
  width:auto;
  height:18px;
}
.start_page_login_portlet[Data-step="700"] > .ImgOTP_ctrl {
  box-sizing:border-box;
  z-index:105;
  position:absolute;
  display:inline-block;
  top:427px;
  left:462px;
  left:66.0%;
  right:220px;
  right:31.428572%;
  bottom:121px;
  width:auto;
}
.start_page_login_portlet > .ImgOTP_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:18px;
  font-size:18px;
}
.start_page_login_portlet[Data-step="320"] > .ImgOTP_ctrl {
  line-height:18px;
  font-size:8px;
}
.start_page_login_portlet[Data-step="480"] > .ImgOTP_ctrl {
  line-height:18px;
  font-size:12px;
}
.start_page_login_portlet[Data-step="700"] > .ImgOTP_ctrl {
  line-height:18px;
  font-size:18px;
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
 String def="[{\"h\":\"566\",\"layout_steps_values\":{\"-1\":{\"h\":\"455\",\"w\":\"100%\"},\"320\":{\"h\":\"362\",\"w\":\"100%\"},\"400\":{\"h\":\"566\",\"w\":\"100%\"},\"480\":{\"h\":\"455\",\"w\":\"100%\"},\"700\":{\"h\":\"566\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,700\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"700\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"438\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":328,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":2},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":398,\"hide\":\"false\",\"w\":400,\"x\":0,\"y\":140},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":398,\"hide\":\"false\",\"w\":\"480\",\"x\":0,\"y\":2},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":438,\"hide\":\"false\",\"w\":700,\"x\":0,\"y\":100}},\"page\":\"1\",\"type\":\"Box\",\"w\":\"700\",\"x\":\"0\",\"y\":\"100\",\"zindex\":\"0\"},{\"anchor\":\"top-left(%)-right(%)\",\"h\":\"34\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":34,\"hide\":\"false\",\"w\":128,\"x\":150,\"y\":177},\"400\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":34,\"hide\":\"false\",\"w\":160,\"x\":187,\"y\":177},\"480\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":34,\"hide\":\"false\",\"w\":\"192\",\"x\":226,\"y\":262},\"700\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":34,\"hide\":\"false\",\"w\":280,\"x\":328,\"y\":333}},\"name\":\"g_codazi\",\"page\":\"1\",\"textlist\":\"desazi\",\"type\":\"Combobox\",\"w\":\"280\",\"x\":\"328\",\"y\":\"333\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"dataobj_companies\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"148\",\"x\":\"2\",\"y\":\"-35\"},{\"h\":\"22\",\"name\":\"m_cURL\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"65\",\"x\":\"701\",\"y\":\"-18\"},{\"h\":\"22\",\"name\":\"m_cURLOnError\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"114\",\"x\":\"768\",\"y\":\"-18\"},{\"h\":\"22\",\"name\":\"m_cAction\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"79\",\"x\":\"884\",\"y\":\"-18\"},{\"h\":\"22\",\"name\":\"login_failed\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"68\",\"x\":\"965\",\"y\":\"-18\"},{\"h\":\"22\",\"name\":\"m_cFailedLoginReason\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"1035\",\"y\":\"-18\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"34\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":128,\"x\":150,\"y\":84},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":160,\"x\":187,\"y\":84},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":\"192\",\"x\":225,\"y\":169},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":280,\"x\":328,\"y\":240}},\"name\":\"m_cUserName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"280\",\"x\":\"328\",\"y\":\"240\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"32\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"h\":23,\"hide\":\"\",\"w\":\"102\",\"x\":152,\"y\":247},\"400\":{\"anchor\":\"top-left\",\"h\":23,\"hide\":\"\",\"w\":\"102\",\"x\":152,\"y\":247},\"480\":{\"anchor\":\"top-left\",\"h\":23,\"hide\":\"\",\"w\":\"102\",\"x\":274,\"y\":343},\"700\":{\"anchor\":\"top-left\",\"h\":32,\"hide\":\"\",\"w\":\"215\",\"x\":393,\"y\":381}},\"name\":\"m_cCaptcha\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"215\",\"x\":\"393\",\"y\":\"381\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"34\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":128,\"x\":150,\"y\":132},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":160,\"x\":187,\"y\":132},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":\"192\",\"x\":225,\"y\":217},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"\",\"w\":280,\"x\":328,\"y\":288}},\"name\":\"m_cPassword\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"280\",\"x\":\"328\",\"y\":\"288\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"40\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":22,\"x\":255,\"y\":212},\"400\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":27,\"x\":318,\"y\":212},\"480\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":\"34\",\"x\":382,\"y\":303},\"700\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":50,\"x\":328,\"y\":374}},\"name\":\"image_captcha\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"50\",\"x\":\"328\",\"y\":\"374\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":\"16\",\"x\":234,\"y\":252},\"400\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":\"16\",\"x\":234,\"y\":229},\"480\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":\"16\",\"x\":356,\"y\":347},\"700\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":18,\"hide\":\"false\",\"w\":\"18\",\"x\":582,\"y\":388}},\"name\":\"image_captcha_new_code\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"582\",\"y\":\"388\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"50\",\"layout_steps_values\":{\"320\":{\"align\":\"left\",\"anchor\":\"top-left(%)-right(%)-bottom\",\"fontpct\":\"90\",\"h\":50,\"hide\":\"false\",\"n_col\":\"1\",\"w\":274,\"x\":44,\"y\":275},\"400\":{\"align\":\"left\",\"anchor\":\"top-left(%)-right(%)-bottom\",\"fontpct\":\"90\",\"h\":50,\"hide\":\"false\",\"n_col\":\"1\",\"w\":342,\"x\":55,\"y\":275},\"480\":{\"align\":\"left\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"90\",\"h\":50,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"434\",\"x\":43,\"y\":373},\"700\":{\"align\":\"left\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"90\",\"h\":50,\"hide\":\"false\",\"n_col\":\"1\",\"w\":601,\"x\":49,\"y\":484}},\"n_col\":\"1\",\"name\":\"errore\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Digitare Utente e Password e premere il pulsante accedi per accedere all'applicativo\",\"w\":\"601\",\"x\":\"49\",\"y\":\"484\",\"zindex\":\"5\"},{\"h\":\"22\",\"name\":\"pURL\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"65\",\"x\":\"700\",\"y\":\"-43\"},{\"h\":\"22\",\"name\":\"pURLOE\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"114\",\"x\":\"769\",\"y\":\"-43\"},{\"align\":\"right\",\"anchor\":\"top-right-bottom\",\"h\":\"24\",\"layout_steps_values\":{\"320\":{\"align\":\"right\",\"anchor\":\"bottom-right\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"105\",\"x\":211,\"y\":337},\"400\":{\"align\":\"right\",\"anchor\":\"bottom-right\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"105\",\"x\":291,\"y\":337},\"480\":{\"align\":\"right\",\"anchor\":\"top-right\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"117\",\"x\":360,\"y\":430},\"700\":{\"align\":\"right\",\"anchor\":\"top-right-bottom\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":175,\"x\":524,\"y\":541}},\"n_col\":\"1\",\"name\":\"lblVersione\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Versione -\",\"w\":\"175\",\"x\":\"524\",\"y\":\"541\",\"zindex\":\"100\"},{\"h\":\"20\",\"name\":\"pUser\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"73\",\"x\":\"888\",\"y\":\"-41\"},{\"h\":\"20\",\"name\":\"pPwd\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"967\",\"y\":\"-41\"},{\"h\":\"20\",\"name\":\"pAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1040\",\"y\":\"-41\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":37},\"400\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":37},\"480\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":37},\"700\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":37}},\"name\":\"m_cIPClient\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"922\",\"y\":\"37\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"pIPC\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1131\",\"y\":\"-41\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"16\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":7,\"x\":267,\"y\":93},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":8,\"x\":333,\"y\":93},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":\"11\",\"x\":400,\"y\":178},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":17,\"x\":583,\"y\":249}},\"name\":\"ImgUser\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"17\",\"x\":\"583\",\"y\":\"249\",\"zindex\":\"2\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"16\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":7,\"x\":267,\"y\":141},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":8,\"x\":333,\"y\":141},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":\"11\",\"x\":400,\"y\":226},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":16,\"hide\":\"false\",\"w\":17,\"x\":583,\"y\":297}},\"name\":\"ImgPwd\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"17\",\"x\":\"583\",\"y\":\"297\",\"zindex\":\"2\"},{\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":24,\"hide\":\"false\",\"w\":\"24\",\"x\":15,\"y\":280},\"400\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":24,\"hide\":\"false\",\"w\":\"24\",\"x\":15,\"y\":280},\"480\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":24,\"hide\":\"false\",\"w\":\"24\",\"x\":15,\"y\":378},\"700\":{\"anchor\":\"top-left\",\"font_size\":\"\",\"h\":24,\"hide\":\"false\",\"w\":\"24\",\"x\":15,\"y\":489}},\"name\":\"ImgWarning\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"24\",\"x\":\"15\",\"y\":\"489\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"pIPS\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1207\",\"y\":\"-41\"},{\"h\":\"20\",\"name\":\"pIPSP\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1283\",\"y\":\"-41\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":923,\"y\":60},\"400\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":923,\"y\":60},\"480\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":923,\"y\":60},\"700\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":923,\"y\":60}},\"name\":\"m_cIPServer\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"923\",\"y\":\"60\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":84},\"400\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":84},\"480\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":84},\"700\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":922,\"y\":84}},\"name\":\"m_cIPSPorta\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"922\",\"y\":\"84\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":741,\"y\":61},\"400\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":741,\"y\":61},\"480\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":741,\"y\":61},\"700\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"90\",\"x\":741,\"y\":61}},\"name\":\"m_cBrowser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"741\",\"y\":\"61\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"172\",\"x\":741,\"y\":37},\"400\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"172\",\"x\":741,\"y\":37},\"480\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"172\",\"x\":741,\"y\":37},\"700\":{\"anchor\":\"top-left\",\"h\":18,\"hide\":\"\",\"w\":\"172\",\"x\":741,\"y\":37}},\"name\":\"m_cIPProtocol\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"172\",\"x\":\"741\",\"y\":\"37\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"pIPRP\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1359\",\"y\":\"-41\"},{\"h\":\"20\",\"name\":\"pBrowser\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1450\",\"y\":\"-41\"},{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"26\",\"layout_steps_values\":{\"320\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"85\",\"h\":26,\"hide\":\"false\",\"n_col\":\"1\",\"w\":128,\"x\":150,\"y\":54},\"400\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"85\",\"h\":26,\"hide\":\"false\",\"n_col\":\"1\",\"w\":160,\"x\":187,\"y\":54},\"480\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"\",\"h\":26,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"192\",\"x\":225,\"y\":136},\"700\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"\",\"h\":26,\"hide\":\"false\",\"n_col\":\"1\",\"w\":280,\"x\":328,\"y\":207}},\"n_col\":\"1\",\"name\":\"lblCredenziali\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CREDENTIAL_LOGIN\",\"w\":\"280\",\"x\":\"328\",\"y\":\"207\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"382\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":272,\"hide\":\"false\",\"w\":136,\"x\":0,\"y\":2},\"400\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":272,\"hide\":\"false\",\"w\":170,\"x\":0,\"y\":2},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":342,\"hide\":\"false\",\"w\":\"165\",\"x\":0,\"y\":29},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":382,\"hide\":\"false\",\"w\":240,\"x\":0,\"y\":100}},\"name\":\"boxUp\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"240\",\"x\":\"0\",\"y\":\"100\",\"zindex\":\"0\"},{\"anchor\":\"top-right-bottom\",\"h\":\"32\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":32,\"hide\":\"false\",\"w\":52,\"x\":150,\"y\":215},\"400\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":32,\"hide\":\"false\",\"w\":65,\"x\":187,\"y\":215},\"480\":{\"anchor\":\"top-left(%)-right(%)\",\"h\":32,\"hide\":\"false\",\"w\":\"78\",\"x\":225,\"y\":310},\"700\":{\"anchor\":\"top-right-bottom\",\"h\":32,\"hide\":\"false\",\"w\":115,\"x\":493,\"y\":419}},\"name\":\"Accedi\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_MENU_LOGIN\",\"w\":\"115\",\"x\":\"493\",\"y\":\"419\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{\"320\":{\"align\":\"left\",\"anchor\":\"bottom-left\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"206\",\"x\":1,\"y\":337},\"400\":{\"align\":\"left\",\"anchor\":\"bottom-left\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"206\",\"x\":1,\"y\":337},\"480\":{\"align\":\"left\",\"anchor\":\"\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"354\",\"x\":1,\"y\":430},\"700\":{\"align\":\"left\",\"anchor\":\"\",\"fontpct\":\"80\",\"h\":24,\"hide\":\"false\",\"n_col\":\"1\",\"w\":346,\"x\":1,\"y\":541}},\"n_col\":\"1\",\"name\":\"lblCopyright\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Designed by WEB Development Team &copy; - Gruppo MIT S.r.l. - &copy;\",\"w\":\"346\",\"x\":\"1\",\"y\":\"541\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"33\",\"layout_steps_values\":{\"320\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)-bottom\",\"fontpct\":\"120\",\"h\":46,\"hide\":\"false\",\"n_col\":\"1\",\"w\":136,\"x\":0,\"y\":160},\"400\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)-bottom\",\"fontpct\":\"120\",\"h\":46,\"hide\":\"false\",\"n_col\":\"1\",\"w\":170,\"x\":0,\"y\":160},\"480\":{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"fontpct\":\"180\",\"h\":33,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"165\",\"x\":0,\"y\":245},\"700\":{\"align\":\"center\",\"anchor\":\"\",\"fontpct\":\"180\",\"h\":33,\"hide\":\"false\",\"n_col\":\"1\",\"w\":240,\"x\":0,\"y\":334}},\"n_col\":\"1\",\"name\":\"label44\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"WEBAOS \\u002f WEBTER\",\"w\":\"240\",\"x\":\"0\",\"y\":\"334\",\"zindex\":\"101\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"59\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":59,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":270},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":59,\"hide\":\"false\",\"w\":400,\"x\":0,\"y\":270},\"480\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":59,\"hide\":\"false\",\"w\":\"480\",\"x\":0,\"y\":367},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":59,\"hide\":\"false\",\"w\":700,\"x\":0,\"y\":478}},\"name\":\"Box47\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"700\",\"x\":\"0\",\"y\":\"478\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)\",\"h\":\"63\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":56,\"x\":183,\"y\":3},\"400\":{\"anchor\":\"top-left(%)-right(%)\",\"font_size\":\"\",\"h\":40,\"hide\":\"false\",\"w\":70,\"x\":228,\"y\":3},\"480\":{\"anchor\":\"top-left(%)-right(%)\",\"font_size\":\"\",\"h\":59,\"hide\":\"false\",\"w\":\"83\",\"x\":277,\"y\":40},\"700\":{\"anchor\":\"top-left(%)-right(%)\",\"font_size\":\"\",\"h\":63,\"hide\":\"false\",\"w\":121,\"x\":411,\"y\":111}},\"name\":\"ImageLogo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"121\",\"x\":\"411\",\"y\":\"111\",\"zindex\":\"102\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":53,\"hide\":\"false\",\"w\":118,\"x\":6,\"y\":80},\"400\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":53,\"hide\":\"false\",\"w\":147,\"x\":7,\"y\":80},\"480\":{\"anchor\":\"top-left(%)-right(%)\",\"font_size\":\"\",\"h\":90,\"hide\":\"false\",\"w\":\"140\",\"x\":11,\"y\":125},\"700\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":90,\"hide\":\"false\",\"w\":204,\"x\":18,\"y\":199}},\"name\":\"Image41\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"204\",\"x\":\"18\",\"y\":\"199\",\"zindex\":\"103\"},{\"h\":\"20\",\"name\":\"RTRelease\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"201\",\"y\":\"-31\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"34\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"h\":34,\"hide\":\"false\",\"w\":71,\"x\":149,\"y\":292},\"480\":{\"anchor\":\"\",\"h\":34,\"hide\":\"false\",\"w\":106,\"x\":223,\"y\":389},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":34,\"hide\":\"false\",\"w\":159,\"x\":328,\"y\":418}},\"name\":\"m_cOTP\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"159\",\"x\":\"328\",\"y\":\"418\",\"zindex\":\"104\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"18\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"h\":18,\"hide\":\"false\",\"w\":8,\"x\":209,\"y\":301},\"480\":{\"anchor\":\"\",\"h\":18,\"hide\":\"false\",\"w\":12,\"x\":313,\"y\":398},\"700\":{\"anchor\":\"top-left(%)-right(%)-bottom\",\"font_size\":\"\",\"h\":18,\"hide\":\"false\",\"w\":18,\"x\":462,\"y\":427}},\"name\":\"ImgOTP\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"462\",\"y\":\"427\",\"zindex\":\"105\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_login","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_login_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><link href='../<%=SPPrxycizer.proxycizedPath("fonts/OpenSans.css", SPPrxycizer.Mode.QUERYSTRING)%>' rel='stylesheet' type='text/css'>
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
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_login','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String g_codazi=JSPLib.translateXSS(sp.getParameter("g_codazi",""));
String m_cURL="jsp/default.jsp";
String m_cURLOnError="jsp/index.jsp?login_failed=true";
String m_cAction="execute";
boolean login_failed=sp.getParameter("login_failed",false);
String m_cFailedLoginReason=JSPLib.translateXSS(sp.getParameter("m_cFailedLoginReason",""));
String m_cUserName=JSPLib.translateXSS(sp.getParameter("m_cUserName",""));
if(request.getAttribute("start_page_login_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String m_cCaptcha= "";
String m_cPassword=JSPLib.translateXSS(sp.getParameter("m_cPassword",""));
String errore= "Digitare Utente e Password e premere il pulsante accedi per accedere all'applicativo";
String pURL="jsp/default.jsp";
String pURLOE="jsp/index.jsp?login_failed=true";
String lblVersione= "Versione -";
String pUser= "";
String pPwd= "";
String pAzienda= "";
String m_cIPClient= "";
String pIPC= "";
String pIPS= "";
String pIPSP= "";
String m_cIPServer= "";
String m_cIPSPorta= "";
String m_cBrowser= "";
String m_cIPProtocol= "";
String pIPRP= "";
String pBrowser= "";
String lblCredenziali= "CREDENTIAL_LOGIN";
String lblCopyright= "Designed by WEB Development Team &copy; - Gruppo MIT S.r.l. - &copy;";
String label44= "WEBAOS / WEBTER";
String m_cOTP=JSPLib.translateXSS(sp.getParameter("m_cOTP",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_login_container'>
<form id='<%=idPortlet%>_form' name='<%=idPortlet%>_form' action='../servlet/seamless_login' METHOD='POST' style='MARGIN:0' onsubmit='if(window.<%=idPortlet%>.this_OnSubmit)return window.<%=idPortlet%>.this_OnSubmit();'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_login_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_login','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_boxBar' class='boxBar_ctrl SPSection_expanded boxprimary_login' data-original-display='flex'><div id='<%=idPortlet%>_boxBar_td' class='box_content'></div>
</div>
<select id='<%=idPortlet%>_g_codazi' name='g_codazi' class='input_class' style='visibility:hidden' tabindex='4'></select>
<input id='<%=idPortlet%>_m_cURL' name='m_cURL' type='hidden'/>
<input id='<%=idPortlet%>_m_cURLOnError' name='m_cURLOnError' type='hidden'/>
<input id='<%=idPortlet%>_m_cAction' name='m_cAction' type='hidden'/>
<input id='<%=idPortlet%>_login_failed' name='login_failed' type='hidden'/>
<textarea id='<%=idPortlet%>_m_cFailedLoginReason' name='m_cFailedLoginReason' style='display:none'></textarea>
<span class='textbox-container'id='<%=idPortlet%>_m_cUserName_wrp'><input id='<%=idPortlet%>_m_cUserName' name='m_cUserName' type='text' class='input_class' formid='<%=idPortlet%>' ps-name='m_cUserName' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("MSG_USERNAME_STANDARD"))%>/></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cCaptcha_wrp'><input id='<%=idPortlet%>_m_cCaptcha' name='m_cCaptcha' type='text' class='input_class' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cCaptcha' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("MSG_CAPTCHA"))%>/></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cPassword_wrp'><input id='<%=idPortlet%>_m_cPassword' name='m_cPassword' type='password' class='input_class' formid='<%=idPortlet%>' autocomplete='off' ps-name='m_cPassword' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("MSG_PASSWORD_STANDARD"))%>/></span>
<div id='<%=idPortlet%>_image_captcha'><a id='<%=idPortlet%>_image_captchahref' href='javascript:void(0)' target='_self' tabindex='-1'><img id='<%=idPortlet%>_image_captcha_img' class='image image_captcha_ctrl' src="" border='0' ></a>
</div><a id='<%=idPortlet%>_image_captcha_new_code' class='ImgIcon_class image_captcha_new_code_ctrl'  href='javascript:void(0)' target='_self'>&#xec4d;</a>
<span id='<%=idPortlet%>_errore'  formid='<%=idPortlet%>' ps-name='errore'    class='lblTesto_class lblTestoBlack_class errore_ctrl'><div id='<%=idPortlet%>_erroretbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Digitare Utente e Password e premere il pulsante accedi per accedere all'applicativo"))%></div></span>
<input id='<%=idPortlet%>_pURL' name='pURL' type='hidden'/>
<input id='<%=idPortlet%>_pURLOE' name='pURLOE' type='hidden'/>
<span id='<%=idPortlet%>_lblVersione'  formid='<%=idPortlet%>' ps-name='lblVersione'    class='lblTesto_class lblTestoBlack_class lblVersione_ctrl'><div id='<%=idPortlet%>_lblVersionetbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Versione -"))%></div></span>
<input id='<%=idPortlet%>_pUser' name='pUser' type='hidden'/>
<input id='<%=idPortlet%>_pPwd' name='pPwd' type='hidden'/>
<input id='<%=idPortlet%>_pAzienda' name='pAzienda' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPClient_wrp'><input id='<%=idPortlet%>_m_cIPClient' name='m_cIPClient' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPClient' /></span>
<input id='<%=idPortlet%>_pIPC' name='pIPC' type='hidden'/>
<a id='<%=idPortlet%>_ImgUser' class='ImgIcon_class ImgUser_ctrl'   target=''>&#xee99;</a>
<a id='<%=idPortlet%>_ImgPwd' class='ImgIcon_class ImgPwd_ctrl'   target=''>&#xed02;</a>
<a id='<%=idPortlet%>_ImgWarning' class='ImgIcon_class ImgWarning_ctrl'   target=''>&#xf071;</a>
<input id='<%=idPortlet%>_pIPS' name='pIPS' type='hidden'/>
<input id='<%=idPortlet%>_pIPSP' name='pIPSP' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPServer_wrp'><input id='<%=idPortlet%>_m_cIPServer' name='m_cIPServer' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPServer' /></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPSPorta_wrp'><input id='<%=idPortlet%>_m_cIPSPorta' name='m_cIPSPorta' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPSPorta' /></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cBrowser_wrp'><input id='<%=idPortlet%>_m_cBrowser' name='m_cBrowser' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cBrowser' /></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPProtocol_wrp'><input id='<%=idPortlet%>_m_cIPProtocol' name='m_cIPProtocol' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPProtocol' /></span>
<input id='<%=idPortlet%>_pIPRP' name='pIPRP' type='hidden'/>
<input id='<%=idPortlet%>_pBrowser' name='pBrowser' type='hidden'/>
<span id='<%=idPortlet%>_lblCredenziali'  formid='<%=idPortlet%>' ps-name='lblCredenziali'    class='lblTesto_class lblCredenziali_ctrl'><div id='<%=idPortlet%>_lblCredenzialitbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CREDENTIAL_LOGIN"))%></div></span>
<div id='<%=idPortlet%>_boxUp' class='boxUp_ctrl SPSection_expanded boxUp_class' data-original-display='flex'><div id='<%=idPortlet%>_boxUp_td' class='box_content'></div>
</div>
<input id='<%=idPortlet%>_Accedi' type='submit' class='accedi_class Accedi_ctrl'/>
<span id='<%=idPortlet%>_lblCopyright'  formid='<%=idPortlet%>' ps-name='lblCopyright'    class='lblTesto_class lblTestoBlack_class lblCopyright_ctrl'><div id='<%=idPortlet%>_lblCopyrighttbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Designed by WEB Development Team &copy; - Gruppo MIT S.r.l. - &copy;"))%></div></span>
<span id='<%=idPortlet%>_label44'  formid='<%=idPortlet%>' ps-name='label44'    class='lblTesto_class label44_ctrl'><div id='<%=idPortlet%>_label44tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("WEBAOS / WEBTER"))%></div></span>
<div id='<%=idPortlet%>_Box47' class='Box47_ctrl SPSection_expanded Box47_class' data-original-display='flex'><div id='<%=idPortlet%>_Box47_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_ImageLogo'>
<img id='<%=idPortlet%>_ImageLogo_img' class='image ImageLogo_ctrl' src="../images/mit.jpg" >
</div>
<div id='<%=idPortlet%>_Image41'>
<img id='<%=idPortlet%>_Image41_img' class='image-thumbnail Image41_ctrl' src="../images/risk.jpg" >
</div>
<span class='textbox-container'id='<%=idPortlet%>_m_cOTP_wrp'><input id='<%=idPortlet%>_m_cOTP' name='m_cOTP' type='text' maxlength='6' class='input_class' formid='<%=idPortlet%>' ps-name='m_cOTP' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("MSG_OTP"))%>/></span>
<a id='<%=idPortlet%>_ImgOTP' class='ImgIcon_class ImgOTP_ctrl'   target=''>&#xef7b;</a>
</div>
</form>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_login');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_login',["700"],["566"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,700', 'adaptive','','true',{"-1":{"h":"455","w":"100%"},"320":{"h":"362","w":"100%"},"400":{"h":"566","w":"100%"},"480":{"h":"455","w":"100%"},"700":{"h":"566","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"362"},"400":{"w":"100%","h":"566"},"-1":{"w":"100%","h":"455"},"700":{"w":"100%","h":"566"},"480":{"w":"100%","h":"455"}},"w":"700","h":"566","title":"","layer":"false","npage":"1"}]);
this.boxBar=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","bg_color":"#FFFFFF","border_color":"","border_weight":"","class_Css":"boxprimary_login","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_boxBar","groupName":"","h":438,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","h":328,"hide":"false","w":320,"x":0,"y":2},"400":{"anchor":"top-left(%)-right(%)-bottom","h":398,"hide":"false","w":400,"x":0,"y":140},"480":{"anchor":"top-left(%)-right(%)-bottom","h":398,"hide":"false","w":"480","x":0,"y":2},"700":{"anchor":"top-left(%)-right(%)-bottom","h":438,"hide":"false","w":700,"x":0,"y":100}},"name":"boxBar","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":700,"x":0,"y":100,"zindex":"0"});
this.g_codazi=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"input_class","create_undercond":"","ctrlid":"<%=idPortlet%>_g_codazi","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":34,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=g_codazi%>","isdatap":true,"layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)","h":34,"hide":"false","w":128,"x":150,"y":177},"400":{"anchor":"top-left(%)-right(%)","h":34,"hide":"false","w":160,"x":187,"y":177},"480":{"anchor":"top-left(%)-right(%)","h":34,"hide":"false","w":"192","x":226,"y":262},"700":{"anchor":"top-left(%)-right(%)","h":34,"hide":"false","w":280,"x":328,"y":333}},"name":"g_codazi","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":false,"w":280,"x":328,"y":333,"zindex":"1"});
this.dataobj_companies=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"start_login_companies","cmdHash":"<%=JSPLib.cmdHash("start_login_companies",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_companies","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_companies","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":148,"x":2,"y":-35});
this.m_cURL=new ZtVWeb._VC(this,'m_cURL','<%=idPortlet%>_m_cURL','character','<%=JSPLib.ToJSValue(m_cURL,false,true)%>',false,false);
this.m_cURLOnError=new ZtVWeb._VC(this,'m_cURLOnError','<%=idPortlet%>_m_cURLOnError','character','<%=JSPLib.ToJSValue(m_cURLOnError,false,true)%>',false,false);
this.m_cAction=new ZtVWeb._VC(this,'m_cAction','<%=idPortlet%>_m_cAction','character','<%=JSPLib.ToJSValue(m_cAction,false,true)%>',false,false);
this.login_failed=new ZtVWeb._VC(this,'login_failed','<%=idPortlet%>_login_failed','logic',<%=login_failed%>,false,false);
this.m_cFailedLoginReason=new ZtVWeb._VC(this,'m_cFailedLoginReason','<%=idPortlet%>_m_cFailedLoginReason','memo','<%=JSPLib.ToJSValue(m_cFailedLoginReason,false,true)%>',false,false);
this.m_cUserName=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)-bottom","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cUserName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":34,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci username"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":128,"x":150,"y":84},"400":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":160,"x":187,"y":84},"480":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":"192","x":225,"y":169},"700":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":280,"x":328,"y":240}},"maxlength":"","name":"m_cUserName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cUserName,false,true)%>","w":280,"x":328,"y":240,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cCaptcha=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cCaptcha","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":32,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","h":23,"hide":"","w":"102","x":152,"y":247},"400":{"anchor":"top-left","h":23,"hide":"","w":"102","x":152,"y":247},"480":{"anchor":"top-left","h":23,"hide":"","w":"102","x":274,"y":343},"700":{"anchor":"top-left","h":32,"hide":"","w":"215","x":393,"y":381}},"maxlength":"","name":"m_cCaptcha","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cCaptcha,false,true)%>","w":215,"x":393,"y":381,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cPassword=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)-bottom","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cPassword","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":34,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci password"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":128,"x":150,"y":132},"400":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":160,"x":187,"y":132},"480":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":"192","x":225,"y":217},"700":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"","w":280,"x":328,"y":288}},"maxlength":"","name":"m_cPassword","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cPassword,false,true)%>","w":280,"x":328,"y":288,"zerofilling":false,"zindex":"1","zoom":""});
this.image_captcha=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image image_captcha_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_captcha","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":40,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_CAPTCHA_GENERATE_NEW"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"","layer":false,"layout_steps_values":{"320":{"anchor":"","font_size":"","h":40,"hide":"false","w":22,"x":255,"y":212},"400":{"anchor":"","font_size":"","h":40,"hide":"false","w":27,"x":318,"y":212},"480":{"anchor":"","font_size":"","h":40,"hide":"false","w":"34","x":382,"y":303},"700":{"anchor":"","font_size":"","h":40,"hide":"false","w":50,"x":328,"y":374}},"name":"image_captcha","page":1,"path_type":"","server_side":"","spuid":"","src":"","srchover":"","tabindex":"-1","target":"_self","type":"Image","type_submit":"false","w":50,"x":328,"y":374,"zindex":"1"});
this.image_captcha_new_code=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"ImgIcon_class image_captcha_new_code_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_captcha_new_code","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xec4d;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_CAPTCHA_GENERATE_NEW"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","font_size":"","h":16,"hide":"false","w":"16","x":234,"y":252},"400":{"anchor":"top-left","font_size":"","h":16,"hide":"false","w":"16","x":234,"y":229},"480":{"anchor":"top-left","font_size":"","h":16,"hide":"false","w":"16","x":356,"y":347},"700":{"anchor":"top-left","font_size":"","h":18,"hide":"false","w":"18","x":582,"y":388}},"name":"image_captcha_new_code","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xec4d;","srchover":"","tabindex":"6","target":"_self","type":"Image","type_submit":"false","w":18,"x":582,"y":388,"zindex":"1"});
 ZtVWeb.RequireFont("icons8_win10","");
this.errore=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"lblTesto_class lblTestoBlack_class","create_undercond":"","ctrlid":"<%=idPortlet%>_errore","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"90","h":50,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"320":{"align":"left","anchor":"top-left(%)-right(%)-bottom","fontpct":"90","h":50,"hide":"false","n_col":"1","w":274,"x":44,"y":275},"400":{"align":"left","anchor":"top-left(%)-right(%)-bottom","fontpct":"90","h":50,"hide":"false","n_col":"1","w":342,"x":55,"y":275},"480":{"align":"left","anchor":"top-left(%)-right(%)","fontpct":"90","h":50,"hide":"false","n_col":"1","w":"434","x":43,"y":373},"700":{"align":"left","anchor":"top-left(%)-right(%)","fontpct":"90","h":50,"hide":"false","n_col":"1","w":601,"x":49,"y":484}},"n_col":1,"name":"errore","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(errore),false,true)%>","type":"Label","w":601,"x":49,"y":484,"zindex":"5"});
this.pURL=new ZtVWeb._VC(this,'pURL','<%=idPortlet%>_pURL','character','<%=JSPLib.ToJSValue(pURL,false,true)%>',false,false);
this.pURLOE=new ZtVWeb._VC(this,'pURLOE','<%=idPortlet%>_pURLOE','character','<%=JSPLib.ToJSValue(pURLOE,false,true)%>',false,false);
this.lblVersione=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right-bottom","assoc_input":"","calculate":"","class_Css":"lblTesto_class lblTestoBlack_class","create_undercond":"","ctrlid":"<%=idPortlet%>_lblVersione","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"80","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"320":{"align":"right","anchor":"bottom-right","fontpct":"80","h":24,"hide":"false","n_col":"1","w":"105","x":211,"y":337},"400":{"align":"right","anchor":"bottom-right","fontpct":"80","h":24,"hide":"false","n_col":"1","w":"105","x":291,"y":337},"480":{"align":"right","anchor":"top-right","fontpct":"80","h":24,"hide":"false","n_col":"1","w":"117","x":360,"y":430},"700":{"align":"right","anchor":"top-right-bottom","fontpct":"80","h":24,"hide":"false","n_col":"1","w":175,"x":524,"y":541}},"n_col":1,"name":"lblVersione","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblVersione),false,true)%>","type":"Label","w":175,"x":524,"y":541,"zindex":"100"});
this.pUser=new ZtVWeb._VC(this,'pUser','<%=idPortlet%>_pUser','character','<%=JSPLib.ToJSValue(pUser,false,true)%>',false,false);
this.pPwd=new ZtVWeb._VC(this,'pPwd','<%=idPortlet%>_pPwd','character','<%=JSPLib.ToJSValue(pPwd,false,true)%>',false,false);
this.pAzienda=new ZtVWeb._VC(this,'pAzienda','<%=idPortlet%>_pAzienda','character','<%=JSPLib.ToJSValue(pAzienda,false,true)%>',false,false);
this.m_cIPClient=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPClient","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":37},"400":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":37},"480":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":37},"700":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":37}},"maxlength":"","name":"m_cIPClient","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPClient,false,true)%>","w":90,"x":922,"y":37,"zerofilling":false,"zindex":"1","zoom":""});
this.pIPC=new ZtVWeb._VC(this,'pIPC','<%=idPortlet%>_pIPC','character','<%=JSPLib.ToJSValue(pIPC,false,true)%>',false,false);
this.ImgUser=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)-bottom","boundedPosition":"","class_Css":"ImgIcon_class ImgUser_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_ImgUser","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xee99;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":7,"x":267,"y":93},"400":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":8,"x":333,"y":93},"480":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":"11","x":400,"y":178},"700":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":17,"x":583,"y":249}},"name":"ImgUser","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xee99;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":17,"x":583,"y":249,"zindex":"2"});
 ZtVWeb.RequireFont("icons8_win10","");
this.ImgPwd=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)-bottom","boundedPosition":"","class_Css":"ImgIcon_class ImgPwd_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_ImgPwd","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xed02;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":7,"x":267,"y":141},"400":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":8,"x":333,"y":141},"480":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":"11","x":400,"y":226},"700":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":16,"hide":"false","w":17,"x":583,"y":297}},"name":"ImgPwd","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xed02;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":17,"x":583,"y":297,"zindex":"2"});
 ZtVWeb.RequireFont("icons8_win10","");
this.ImgWarning=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"ImgIcon_class ImgWarning_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_ImgWarning","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf071;","font_image_hover":"","font_name":"fontawesome-webfont","font_path":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","font_size":"","h":24,"hide":"false","w":"24","x":15,"y":280},"400":{"anchor":"top-left","font_size":"","h":24,"hide":"false","w":"24","x":15,"y":280},"480":{"anchor":"top-left","font_size":"","h":24,"hide":"false","w":"24","x":15,"y":378},"700":{"anchor":"top-left","font_size":"","h":24,"hide":"false","w":"24","x":15,"y":489}},"name":"ImgWarning","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xf071;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":24,"x":15,"y":489,"zindex":"10"});
 ZtVWeb.RequireFont("fontawesome-webfont","");
this.pIPS=new ZtVWeb._VC(this,'pIPS','<%=idPortlet%>_pIPS','character','<%=JSPLib.ToJSValue(pIPS,false,true)%>',false,false);
this.pIPSP=new ZtVWeb._VC(this,'pIPSP','<%=idPortlet%>_pIPSP','character','<%=JSPLib.ToJSValue(pIPSP,false,true)%>',false,false);
this.m_cIPServer=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPServer","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","h":18,"hide":"","w":"90","x":923,"y":60},"400":{"anchor":"top-left","h":18,"hide":"","w":"90","x":923,"y":60},"480":{"anchor":"top-left","h":18,"hide":"","w":"90","x":923,"y":60},"700":{"anchor":"top-left","h":18,"hide":"","w":"90","x":923,"y":60}},"maxlength":"","name":"m_cIPServer","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPServer,false,true)%>","w":90,"x":923,"y":60,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cIPSPorta=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPSPorta","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":84},"400":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":84},"480":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":84},"700":{"anchor":"top-left","h":18,"hide":"","w":"90","x":922,"y":84}},"maxlength":"","name":"m_cIPSPorta","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPSPorta,false,true)%>","w":90,"x":922,"y":84,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cBrowser=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cBrowser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","h":18,"hide":"","w":"90","x":741,"y":61},"400":{"anchor":"top-left","h":18,"hide":"","w":"90","x":741,"y":61},"480":{"anchor":"top-left","h":18,"hide":"","w":"90","x":741,"y":61},"700":{"anchor":"top-left","h":18,"hide":"","w":"90","x":741,"y":61}},"maxlength":"","name":"m_cBrowser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cBrowser,false,true)%>","w":90,"x":741,"y":61,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cIPProtocol=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPProtocol","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left","h":18,"hide":"","w":"172","x":741,"y":37},"400":{"anchor":"top-left","h":18,"hide":"","w":"172","x":741,"y":37},"480":{"anchor":"top-left","h":18,"hide":"","w":"172","x":741,"y":37},"700":{"anchor":"top-left","h":18,"hide":"","w":"172","x":741,"y":37}},"maxlength":"","name":"m_cIPProtocol","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPProtocol,false,true)%>","w":172,"x":741,"y":37,"zerofilling":false,"zindex":"1","zoom":""});
this.pIPRP=new ZtVWeb._VC(this,'pIPRP','<%=idPortlet%>_pIPRP','character','<%=JSPLib.ToJSValue(pIPRP,false,true)%>',false,false);
this.pBrowser=new ZtVWeb._VC(this,'pBrowser','<%=idPortlet%>_pBrowser','character','<%=JSPLib.ToJSValue(pBrowser,false,true)%>',false,false);
this.lblCredenziali=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"lblTesto_class","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCredenziali","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"#535D70","font_size":"","font_weight":"","fontpct":"","h":26,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"320":{"align":"center","anchor":"top-left(%)-right(%)","fontpct":"85","h":26,"hide":"false","n_col":"1","w":128,"x":150,"y":54},"400":{"align":"center","anchor":"top-left(%)-right(%)","fontpct":"85","h":26,"hide":"false","n_col":"1","w":160,"x":187,"y":54},"480":{"align":"center","anchor":"top-left(%)-right(%)","fontpct":"","h":26,"hide":"false","n_col":"1","w":"192","x":225,"y":136},"700":{"align":"center","anchor":"top-left(%)-right(%)","fontpct":"","h":26,"hide":"false","n_col":"1","w":280,"x":328,"y":207}},"n_col":1,"name":"lblCredenziali","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblCredenziali),false,true)%>","type":"Label","w":280,"x":328,"y":207,"zindex":"1"});
this.boxUp=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","bg_color":"","border_color":"","border_weight":"","class_Css":"boxUp_class","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_boxUp","groupName":"","h":382,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)","h":272,"hide":"false","w":136,"x":0,"y":2},"400":{"anchor":"top-left(%)-right(%)","h":272,"hide":"false","w":170,"x":0,"y":2},"480":{"anchor":"top-left(%)-right(%)-bottom","h":342,"hide":"false","w":"165","x":0,"y":29},"700":{"anchor":"top-left(%)-right(%)-bottom","h":382,"hide":"false","w":240,"x":0,"y":100}},"name":"boxUp","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":240,"x":0,"y":100,"zindex":"0"});
this.Accedi=new ZtVWeb._BC(this,{"anchor":"top-right-bottom","bg_color":"","border_color":"","border_weight":"","class_Css":"accedi_class Accedi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Accedi","edit_undercond":"","font":"","font_color":"","font_size":"","h":32,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_MENU_LOGIN"),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)","h":32,"hide":"false","w":52,"x":150,"y":215},"400":{"anchor":"top-left(%)-right(%)","h":32,"hide":"false","w":65,"x":187,"y":215},"480":{"anchor":"top-left(%)-right(%)","h":32,"hide":"false","w":"78","x":225,"y":310},"700":{"anchor":"top-right-bottom","h":32,"hide":"false","w":115,"x":493,"y":419}},"name":"Accedi","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_MENU_LOGIN"),false,true)%>","type":"Button","type_submit":"true","type_wizard":"","w":115,"x":493,"y":419,"zindex":"1"});
this.lblCopyright=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"lblTesto_class lblTestoBlack_class","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCopyright","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"80","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"320":{"align":"left","anchor":"bottom-left","fontpct":"80","h":24,"hide":"false","n_col":"1","w":"206","x":1,"y":337},"400":{"align":"left","anchor":"bottom-left","fontpct":"80","h":24,"hide":"false","n_col":"1","w":"206","x":1,"y":337},"480":{"align":"left","anchor":"","fontpct":"80","h":24,"hide":"false","n_col":"1","w":"354","x":1,"y":430},"700":{"align":"left","anchor":"","fontpct":"80","h":24,"hide":"false","n_col":"1","w":346,"x":1,"y":541}},"n_col":1,"name":"lblCopyright","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblCopyright),false,true)%>","type":"Label","w":346,"x":1,"y":541,"zindex":"1"});
this.label44=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"lblTesto_class","create_undercond":"","ctrlid":"<%=idPortlet%>_label44","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"180","h":33,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"320":{"align":"center","anchor":"top-left(%)-right(%)-bottom","fontpct":"120","h":46,"hide":"false","n_col":"1","w":136,"x":0,"y":160},"400":{"align":"center","anchor":"top-left(%)-right(%)-bottom","fontpct":"120","h":46,"hide":"false","n_col":"1","w":170,"x":0,"y":160},"480":{"align":"center","anchor":"top-left(%)-right(%)","fontpct":"180","h":33,"hide":"false","n_col":"1","w":"165","x":0,"y":245},"700":{"align":"center","anchor":"","fontpct":"180","h":33,"hide":"false","n_col":"1","w":240,"x":0,"y":334}},"n_col":1,"name":"label44","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label44),false,true)%>","type":"Label","w":240,"x":0,"y":334,"zindex":"101"});
this.Box47=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","bg_color":"","border_color":"","border_weight":"0","class_Css":"Box47_class","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box47","groupName":"","h":59,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","h":59,"hide":"false","w":320,"x":0,"y":270},"400":{"anchor":"top-left(%)-right(%)-bottom","h":59,"hide":"false","w":400,"x":0,"y":270},"480":{"anchor":"top-left(%)-right(%)-bottom","h":59,"hide":"false","w":"480","x":0,"y":367},"700":{"anchor":"top-left(%)-right(%)-bottom","h":59,"hide":"false","w":700,"x":0,"y":478}},"name":"Box47","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":700,"x":0,"y":478,"zindex":"1"});
this.ImageLogo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image ImageLogo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_ImageLogo","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":63,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)","font_size":"","h":40,"hide":"false","w":56,"x":183,"y":3},"400":{"anchor":"top-left(%)-right(%)","font_size":"","h":40,"hide":"false","w":70,"x":228,"y":3},"480":{"anchor":"top-left(%)-right(%)","font_size":"","h":59,"hide":"false","w":"83","x":277,"y":40},"700":{"anchor":"top-left(%)-right(%)","font_size":"","h":63,"hide":"false","w":121,"x":411,"y":111}},"name":"ImageLogo","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fmit.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":121,"x":411,"y":111,"zindex":"102"});
this.Image41=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-thumbnail Image41_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image41","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":90,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":53,"hide":"false","w":118,"x":6,"y":80},"400":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":53,"hide":"false","w":147,"x":7,"y":80},"480":{"anchor":"top-left(%)-right(%)","font_size":"","h":90,"hide":"false","w":"140","x":11,"y":125},"700":{"anchor":"","font_size":"","h":90,"hide":"false","w":204,"x":18,"y":199}},"name":"Image41","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002frisk.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":204,"x":18,"y":199,"zindex":"103"});
this.RTRelease=new ZtVWeb.SPLinkerCtrl(this,{"action":"function autoexec","allowedEntities":"<%=JSPLib.encrypt("aosfn_release",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRelease","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRelease","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"aosfn_release","target":"lblVersione","type":"SPLinker","w":120,"x":201,"y":-31});
this.RTRelease.m_cID='<%=JSPLib.cmdHash("routine,aosfn_release",request.getSession())%>';
this.RTRelease.Link();
this.m_cOTP=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)-bottom","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cOTP","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":34,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{"320":{"anchor":"","h":34,"hide":"false","w":71,"x":149,"y":292},"480":{"anchor":"","h":34,"hide":"false","w":106,"x":223,"y":389},"700":{"anchor":"top-left(%)-right(%)-bottom","h":34,"hide":"false","w":159,"x":328,"y":418}},"maxlength":"6","name":"m_cOTP","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cOTP,false,true)%>","w":159,"x":328,"y":418,"zerofilling":false,"zindex":"104","zoom":""});
this.ImgOTP=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)-bottom","boundedPosition":"","class_Css":"ImgIcon_class ImgOTP_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_ImgOTP","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xef7b;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":"","h":18,"hide":"false","w":8,"x":209,"y":301},"480":{"anchor":"","h":18,"hide":"false","w":12,"x":313,"y":398},"700":{"anchor":"top-left(%)-right(%)-bottom","font_size":"","h":18,"hide":"false","w":18,"x":462,"y":427}},"name":"ImgOTP","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xef7b;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":18,"x":462,"y":427,"zindex":"105"});
 ZtVWeb.RequireFont("icons8_win10","");
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
<%request.setAttribute("start_page_login_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.start_page_login_Static=function(){
if(typeof dataobj_companies_ConsumersRendered !='undefined')this.dataobj_companies_ConsumersRendered=dataobj_companies_ConsumersRendered;
if(typeof image_captcha_Click !='undefined')this.image_captcha_Click=image_captcha_Click;
if(typeof image_captcha_new_code_Click !='undefined')this.image_captcha_new_code_Click=image_captcha_new_code_Click;
if(typeof this_OnSubmit !='undefined')this.this_OnSubmit=this_OnSubmit;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
this.pUser.Set(this.m_cUserName.Value());
this.pPwd.Set(this.m_cPassword.Value());
this.pAzienda.Set(this.g_codazi.Value());
this.pIPC.Set(this.m_cIPClient.Value());
this.pIPS.Set(this.m_cIPServer.Value());
this.pIPSP.Set(this.m_cIPSPorta.Value());
this.pIPRP.Set(this.m_cIPProtocol.Value());
this.pBrowser.Set(this.m_cBrowser.Value());
}
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.m_cIPClient);
ZtVWeb.HideCtrl(true,this.m_cIPServer);
ZtVWeb.HideCtrl(true,this.m_cIPSPorta);
ZtVWeb.HideCtrl(true,this.m_cBrowser);
ZtVWeb.HideCtrl(true,this.m_cIPProtocol);
}
this.dataobj_companies.addRowConsumer(this.g_codazi);
this.m_cIPClient.Value('<%out.print(request.getRemoteAddr());%>'); 
this.m_cIPServer.Value('<%out.print(request.getServerName());%>'); 
this.m_cIPSPorta.Value('<%out.print(request.getServerPort());%>'); 
this.m_cIPProtocol.Value('<%out.print(request.getScheme());%>'); 
this.m_cBrowser.Value('<%out.print(request.getHeader("User-Agent"));%>');
<%if(!sp.hasAdministeredUsers()){%>
  window.location="../jsp/default.jsp";
<%}%>
// this.dataobj_companies.Query();
function dataobj_companies_ConsumersRendered(){
  if(this.dataobj_companies.isEmpty()){
  this.g_codazi.Hide();
  }
  if(this.dataobj_companies.GetQueryCount()=="1"){
    this.g_codazi.empty_value=false;
  }
}
function image_captcha_Click(){
  this.image_captcha.Value('../servlet/SPImageCaptchaServlet?a='+Math.random());
}
function image_captcha_new_code_Click(){
  this.image_captcha_Click();
}
if(this.m_cFailedLoginReason.Value())
  this.errore.Value(this.m_cFailedLoginReason.Value());
//else
  //this.errore.Hide();
<%if(com.zucchetti.sitepainter.Library.captchaMustBeShown(request)){
//da esplorare la possibilita' di chiedere captcha di una certa dimensione piuttosto che averla
//fissa lato server
%>
this.image_captcha.Ctrl.style.width='<%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageWidth/2%>px';
this.image_captcha.Ctrl.style.height='<%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageHeight/2%>px';
this.image_captcha.Value('../servlet/SPImageCaptchaServlet');
<%}else{%>
this.m_cCaptcha.Hide();
this.image_captcha.Hide();
this.image_captcha_new_code.Hide();
<%}%>
function this_OnSubmit(){
  this.pPwd.Value(this.m_cPassword.Value())
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_login_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.image_captcha_new_code.dispatchEvent('OnLoad');
window.<%=idPortlet%>.ImgUser.dispatchEvent('OnLoad');
window.<%=idPortlet%>.ImgPwd.dispatchEvent('OnLoad');
window.<%=idPortlet%>.ImgWarning.dispatchEvent('OnLoad');
window.<%=idPortlet%>.ImgOTP.dispatchEvent('OnLoad');
window.<%=idPortlet%>.dataobj_companies.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_login',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_login');
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
sp.endPage("start_page_login");
}%>
<%! public String getJSPUID() { return "560722012"; } %>