<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.m_cIPClient.Value('\u003c%out.print(request.getRemoteAddr());%\u003e'); \nthis.m_cIPServer.Value('\u003c%out.print(request.getServerName());%\u003e'); \nthis.m_cIPSPorta.Value('\u003c%out.print(request.getServerPort());%\u003e'); \nthis.m_cIPProtocol.Value('\u003c%out.print(request.getScheme());%\u003e'); \nthis.m_cBrowser.Value('\u003c%out.print(request.getHeader(\"User-Agent\"));%\u003e');\n\n\u003c%if(!sp.hasAdministeredUsers()){%\u003e\n  window.location=\"..\u002fjsp\u002fdefault.jsp\";\n\u003c%}%\u003e\n\u003c% \u002f\u002f GESTIONE OAUTH IDENTITY PROVIDER(S)\n  final com.zucchetti.sitepainter.oauth.client.IdentityProvider identityProvider = com.zucchetti.sitepainter.oauth.SPOAuthLibrary.GetIdentityProvider(\"0000000001\", request);\n\tString authURI = \"\";\n  if (identityProvider != null ) {\n    authURI = identityProvider.makeAuthURI(request.getSession());\n\u002f\u002f final Set\u003cString\u003e identityProviderNames = com.zucchetti.sitepainter.oauth.SPOAuthLibrary.GetAvailableIdentityProviders();\n\u002f\u002f if(identityProviderNames.size()\u003e0) {\n\u002f\u002f   String firstIdentityProviderName = null;\n\u002f\u002f   for (String providerName : identityProviderNames) {\n\u002f\u002f     firstIdentityProviderName = providerName;\n\u002f\u002f     break;\n\u002f\u002f   }\n\u002f\u002f   final com.zucchetti.sitepainter.oauth.client.IdentityProvider identityProvider = com.zucchetti.sitepainter.oauth.SPOAuthLibrary.GetIdentityProvider(firstIdentityProviderName);\n\u002f\u002f   final String authURI = identityProvider.makeAuthURI(request.getSession());\n\u002f\u002f redirect automatica ad Identity Provider\n    if(identityProvider.isAutologin()) { %\u003e\nlocation.href='\u003c%=authURI%\u003e';\nreturn;\u003c%\n    } else {\n%\u003e\u002f\u002f login su Identity Provider da pulsante\nthis.oauth.Show();\n\u002f\u002fthis.oauth_img.Show();\nthis.container_oauth.Show();\u003c%\n    }\n  } %\u003e\n\n                                    \nfunction oauth_Click() {\n  let a = document.createElement(\"a\");\n  a.href = \"\u003c%=authURI%\u003e\";\n  a.target = \"_self\";\n  a.click();\n}\n  \nfunction oauth_img_Click(){\n  oauth_Click();\n}\n\u003c% \u002f\u002f} \u002f\u002f GESTIONE OAUTH IDENTITY PROVIDER(S) FINE %\u003e\n  \nthis.dataobj_companies.Query();\n  \nfunction dataobj_companies_ConsumersRendered(){     \n  this.g_codazi.Show();\n  this.labelAzienda.Show();\n  this.container_azi.Show();  \n  if(this.dataobj_companies.isEmpty() || this.dataobj_companies.GetQueryCount()==\"1\"){\n    this.g_codazi.empty_value=false;    \n    \u002f\u002f this.g_codazi.Hide();\n    \u002f\u002f this.labelAzienda.Hide();\n    \u002f\u002f this.container_azi.Hide();\n    this.g_codazi.Disabled();\n  }\n}\n                                        \nfunction image_captcha_Click(){\n  this.image_captcha.Value('..\u002fservlet\u002fSPImageCaptchaServlet?a='+Math.random());\n}\nfunction image_captcha_new_code_Click(){\n  this.image_captcha_Click();\n}\nif(this.m_cFailedLoginReason.Value())\n  this.errore.Value(this.m_cFailedLoginReason.Value());\nelse\n  this.errore.Hide();\n\n\u003c%if(com.zucchetti.sitepainter.Library.captchaMustBeShown(request)){\n\u002f\u002fda esplorare la possibilita' di chiedere captcha di una certa dimensione piuttosto che averla\n\u002f\u002ffissa lato server\n%\u003e\nthis.image_captcha.Ctrl.style.width='\u003c%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageWidth\u002f2%\u003epx';\nthis.image_captcha.Ctrl.style.height='\u003c%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageHeight\u002f2%\u003epx';\nthis.image_captcha.Value('..\u002fservlet\u002fSPImageCaptchaServlet');\nthis.container_captcha.Show();\n\u003c%}else{%\u003e\nthis.m_cCaptcha.Hide();\nthis.image_captcha.Hide();\n\u002f\u002fthis.image_captcha_new_code.Hide();\nthis.container_captcha.Hide();\n\u003c%}%\u003e\n  \nfunction this_OnSubmit(){\n  this.pPwd.Value(this.m_cPassword.Value())\n}\n        \nfunction lblVersione_Click(){\n  this.RTRelease.Link();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"type\":\"box\",\"name\":\"boxUp_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#F0A30A\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"boxUp_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:260px; height:362px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"bg_color\\\":\\\"#F0A30A\\\"}\",\"code\":\".boxUp_class{background-color: rgba(240, 163, 10, 1) ;background-size: cover;}\\n\"},{\"type\":\"box\",\"name\":\"Box47_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#EAEAEA\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"Box47_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:699px; height:59px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"bg_color\\\":\\\"#EAEAEA\\\"}\",\"code\":\".Box47_class{background-color: rgba(234, 234, 234, 1) ;background-size: cover;}\\n\"},{\"type\":\"label\",\"name\":\"lblCredenziali_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"16\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"align\\\":\\\"left\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"label0\\\",\\\"type\\\":\\\"Label\\\",\\\"class_name\\\":\\\"lblCredenziali_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:280px;\\\\\\\"\u003eCredenziali di accesso\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\"Credenziali di accesso\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"16\\\"}\",\"code\":\".lblCredenziali_class{text-decoration: none;text-transform: none;font-style: normal;font-weight: normal;font-size: 16px;font-family: Arial, Helvetica, sans-serif;text-align: left;}\\n\"},{\"type\":\"image\",\"name\":\"ImgIcon_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"opacity\\\":\\\"40\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"src\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"image0\\\",\\\"type\\\":\\\"Image\\\",\\\"class_name\\\":\\\"ImgIcon_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:24px; height:24px;\\\\\\\" \u003e\u003cimg src=\\\\\\\"\\\\\\\" width=\\\\\\\"24\\\\\\\" height=\\\\\\\"24\\\\\\\"\u002f\u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"src\\\":\\\"\\\",\\\"page\\\":1,\\\"opacity\\\":\\\"40\\\"}\",\"code\":\".ImgIcon_class{opacity: 0.4;}\\n\"},{\"type\":\"textbox\",\"name\":\"m_cUserName_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_type\\\":\\\"solid\\\",\\\"border_width\\\":\\\"1\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_color\\\":\\\"#202020\\\",\\\"align\\\":\\\"left\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"textbox0\\\",\\\"type\\\":\\\"Textbox\\\",\\\"class_name\\\":\\\"m_cUserName_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:280px;\\\\\\\"\u003eundefined\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\" rtgrwegeg\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_width\\\":\\\"1\\\",\\\"font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_color\\\":\\\"#202020\\\"}\",\"code\":\".m_cUserName_class{border: 1px solid #DADADA;color: #202020;text-decoration: none;text-transform: none;font-style: normal;font-weight: normal;font-size: 12px;font-family: Arial, Helvetica, sans-serif;text-align: left;}\\n\"},{\"type\":\"textbox\",\"name\":\"input_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_type\\\":\\\"solid\\\",\\\"border_width\\\":\\\"1\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_unit\\\":\\\"px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_color\\\":\\\"#202020\\\",\\\"align\\\":\\\"left\\\",\\\"pad_left\\\":\\\"10\\\",\\\"advanced_font\\\":\\\"Arial, Helvetica, sans-serif\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"value\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"textbox0\\\",\\\"type\\\":\\\"Textbox\\\",\\\"class_name\\\":\\\"input_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:280px; height:34px;\\\\\\\"\u003e\u003c\u002fdiv\u003e\\\",\\\"value\\\":\\\" \\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"weight\\\":\\\"normal\\\",\\\"style\\\":\\\"normal\\\",\\\"decoration\\\":\\\"none\\\",\\\"transform\\\":\\\"none\\\",\\\"font_unit\\\":\\\"px\\\",\\\"align\\\":\\\"left\\\",\\\"class_Css\\\":\\\"label\\\",\\\"page\\\":1,\\\"border_color\\\":\\\"#DADADA\\\",\\\"border_width\\\":\\\"1\\\",\\\"font\\\":\\\"Open Sans, sans-serif\\\",\\\"size\\\":\\\"12\\\",\\\"font_color\\\":\\\"#202020\\\",\\\"pad_left\\\":\\\"10\\\",\\\"advanced_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"offline_font\\\":\\\"Arial, Helvetica, sans-serif\\\",\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"]}\",\"code\":\".input_class{padding: 0 0 0 10px;border: 1px solid #DADADA;font-family: Open Sans, sans-serif;color: #202020;text-decoration: none;text-transform: none;font-style: normal;font-weight: normal;font-size: 12px;text-align: left;}\\n\"},{\"type\":\"box\",\"name\":\"boxUp_class\",\"selector\":\".boxUp_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#535d70\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Coustard\\\",\\\"Antic Slab\\\",\\\"Quattrocento\\\",\\\"Cinzel\\\",\\\"Josefin Slab\\\",\\\"Merriweather\\\",\\\"Lora\\\",\\\"Nunito\\\",\\\"Abel\\\",\\\"Fjalla One\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Raleway\\\",\\\"Montserrat\\\",\\\"Roboto Condensed\\\",\\\"Oswald\\\",\\\"Special Elite\\\",\\\"Fredoka One\\\",\\\"Comfortaa\\\",\\\"Bangers\\\",\\\"Righteous\\\",\\\"Sigmar One\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Lobster\\\",\\\"Nova Mono\\\",\\\"Inconsolata\\\",\\\"Source Code Pro\\\",\\\"Anonymous Pro\\\",\\\"Roboto Mono\\\",\\\"Amatic SC\\\",\\\"Shadows Into Light\\\",\\\"Dancing Script\\\",\\\"Pacifico\\\",\\\"Indie Flower\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"box\\\",\\\"class_name\\\":\\\"boxUp_class\\\",\\\"selector\\\":\\\".boxUp_class\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#535d70\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".boxUp_class {\\n  background-color: #535d70;\\n}\\n\"},{\"type\":\"label\",\"name\":\"lblTestoBlack_class\",\"selector\":\".lblTestoBlack_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"font_color\\\":\\\"#000\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"lblTestoBlack_class\\\",\\\"selector\\\":\\\".lblTestoBlack_class\\\",\\\"value\\\":\\\"Access to this system is allowed for authorised users only. Activities are logged and monitored UNAUTHORISED ACCESS IS STRICTLY PROHIBITED\\\",\\\"h\\\":\\\"40px\\\",\\\"w\\\":\\\"200px\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"font_color\\\":\\\"#000\\\"}\",\"code\":\".lblTestoBlack_class {\\n  color: #000;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"bg_color\":\"#0072BC\",\"border_type\":\"solid\",\"shadow_type\":\"outline\",\"border_radius_tl\":\"4px\",\"border_radius_tr\":\"4px\",\"border_radius_bl\":\"4px\",\"border_radius_br\":\"4px\",\"border_width\":\"0\",\"font\":\"Open Sans, sans-serif\",\"size\":\"16px\",\"weight\":\"300\",\"style\":\"normal\",\"font_color\":\"#fff\",\"align\":\"center\",\"code\":\"cursor:pointer;\"},\"hover\":{\"bg_color\":\"#1bbae1\"},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"button\",\"class_name\":\"accedi_class\",\"selector\":\".accedi_class\",\"value\":\"MSG_MENU_LOGIN\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".accedi_class {\\n  border-radius: 4px 4px 4px 4px;\\n  border: 0;\\n  background-color: #0072BC;\\n  cursor: pointer;\\n  font-family: Open Sans, sans-serif;\\n  color: #fff;\\n  font-style: normal;\\n  font-weight: 300;\\n  font-size: 16px;\\n  text-align: center;\\n}\\n\\n.accedi_class:hover {\\n  background-color: #1bbae1;\\n}\\n\",\"fontoffline\":\"Open Sans, sans-serif\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"overflow: hidden;\\nheight: 100%;\\n\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"start_page_login_container\",\"selector\":\".start_page_login_container\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"height: 100%;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"start_page_login_container\",\"selector\":\".start_page_login_container \u003e form\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label\",\"selector\":\".label\",\"value\":\"Access to this system is allowed for authorised users only. \u003cbr \u002f\u003eActivities are logged and monitored UNAUTHORISED ACCESS IS STRICTLY PROHIBITED\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"size\":\"13px\",\"weight\":\"300\",\"font_color\":\"#555555\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label\",\"selector\":\".label.privacy\",\"value\":\"Access to this system is allowed for authorised users only. \u003cbr \u002f\u003eActivities are logged and monitored UNAUTHORISED ACCESS IS STRICTLY PROHIBITED\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"font_color\":\"white\",\"code\":\"background: linear-gradient(40deg, #016cfe 0%, #4033aa 100%);\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"button\",\"class_name\":\"button-large\",\"selector\":\".button-large.button-login\",\"value\":\"MSG_MENU_LOGIN\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"background: linear-gradient(40deg, #e3a601 0%, #c9950a 100%);\"},\"hover\":{\"code\":\"background: linear-gradient(40deg, #e3a601 0%, #c9950a 100%);\"},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"button\",\"class_name\":\"button-oauth\",\"selector\":\".button-large.button-login.button-oauth\",\"value\":\"Accedi con Identity Provider\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"Login standard","fixed_top":"","form_action":"..\u002fservlet\u002fseamless_login","form_enctype":"","form_target":"","form_type":"true","grapesCode":"\u003cbody\u003e{{ @g_codazi }}{{ @m_cUserName }}{{ @m_cCaptcha }}{{ @m_cPassword }}{{ @image_captcha }}{{ @footer_message }}{{ @errore }}{{ @imgLogo }}{{ @Accedi }}{{ @lblCopyright }}{{ @container_captcha }}{{ @container_azi }}{{ @m_cOTP }}{{ @g_codazi }}{{ @m_cUserName }}{{ @m_cCaptcha }}{{ @m_cPassword }}{{ @image_captcha }}{{ @image_captcha_new_code }}{{ @footer_message }}{{ @ImgUser }}{{ @ImgPwd }}{{ @errore }}{{ @imgLogo }}{{ @Accedi }}{{ @lblCopyright }}{{ @container_captcha }}{{ @container_azi }}{{ @m_cOTP }}{{ @ImgOTP }}{{ @labelPassword }}{{ @labelPassword_Copy }}{{ @g_codazi }}{{ @m_cUserName }}{{ @m_cCaptcha }}{{ @m_cPassword }}{{ @image_captcha }}{{ @image_captcha_new_code }}{{ @footer_message }}{{ @lblVersione }}{{ @ImgUser }}{{ @ImgPwd }}{{ @ImgWarning }}{{ @errore }}{{ @imgLogo }}{{ @Accedi }}{{ @lblCopyright }}{{ @Box47 }}{{ @header_background }}{{ @container_captcha }}{{ @container_azi }}{{ @m_cOTP }}{{ @ImgOTP }}{{ @labelPassword }}{{ @labelUsername }}{{ @labelUsername_Copy }}{{ @g_codazi }}{{ @m_cUserName }}{{ @m_cCaptcha }}{{ @m_cPassword }}{{ @image_captcha }}{{ @image_captcha_new_code }}{{ @footer_message }}{{ @lblVersione }}{{ @ImgUser }}{{ @ImgPwd }}{{ @ImgWarning }}{{ @errore }}{{ @imgLogo }}{{ @Accedi }}{{ @lblCopyright }}{{ @Box47 }}{{ @header_background }}{{ @container_captcha }}{{ @container_azi }}{{ @m_cOTP }}{{ @ImgOTP }}{{ @labelPassword }}{{ @labelUsername }}{{ @labelOtp }}{{ @labelOtp_Copy }}{{ @labelAzienda }}{{ @labelAzienda }}{{ @labelOtp }}{{ @oauth }}{{ @labelUsername }}{{ @labelAzienda }}{{ @labelOtp }}{{ @oauth }}{{ @oauth_img }}{{ @container_captcha_Copy }}{{ @container_oauth }}{{ @container_oauth }}{{ @oauth }}{{ @oauth_img }}{{ @container_oauth }}{{ @lblVersione }}{{ @m_cIPClient }}{{ @m_cIPServer }}{{ @m_cIPSPorta }}{{ @m_cBrowser }}{{ @m_cIPProtocol }}\u003c\u002fbody\u003e","grapesCss":"","h":"1050","hsl":"","htmlcode":"{{ @labelUsername }} \n{{ @g_codazi }} \n{{ g_codazi }}\n{{ dataobj_companies }}\n{{ m_cURL }}\n{{ m_cURLOnError }}\n{{ m_cAction }}\n{{ login_failed }}\n{{ m_cFailedLoginReason }}\n{{ m_cUserName }}\n{{ m_cCaptcha }}\n{{ m_cPassword }}\n{{ image_captcha }}\n{{ image_captcha_new_code }}\n{{ footer_message }}\n{{ lblVersione }}\n{{ ImgUser }}\n{{ ImgPwd }}\n{{ ImgWarning }}\n{{ errore }}\n{{ imgLogo }}\n{{ Accedi }}\n{{ lblCopyright }}\n{{ Box47 }}\n{{ header_background }}\n{{ container_captcha }}\n{{ container_azi }}\n{{ m_cOTP }}\n{{ ImgOTP }}\n{{ @m_cUserName }} \n{{ @m_cCaptcha }} \n{{ @m_cPassword }} \n{{ @image_captcha }} \n \n{{ @footer_message }} \n \n \n \n \n{{ @errore }} \n{{ @imgLogo }} \n{{ @Accedi }} \n{{ @lblCopyright }} \n \n \n{{ @container_captcha }} \n{{ @container_azi }} \n{{ @m_cOTP }} \n \n{{ @labelPassword{{ @labelUsername{{ @labelOtp{{ @labelAzienda }} \n }} \n }} \n }} \n{{ @labelOtp }} \n{{ @labelPassword }} \n{{ @oauth }} \n \n{{ @container_oauth }} \n{{ @lblVersione }} \n{{ @pURL }} \n{{ @pURLOE }} \n{{ @pUser }} \n{{ @pPwd }} \n{{ @pAzienda }} \n{{ @pIPC }} \n{{ @pIPS }} \n{{ @pIPSP }} \n{{ @pIPRP }} \n{{ @pBrowser }} \n{{ @m_cIPClient }} \n{{ @m_cIPServer }} \n{{ @m_cIPSPorta }} \n{{ @m_cBrowser }} \n{{ @m_cIPProtocol }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"default page","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"1050\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"413","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"23","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"dataobj_companies","offline":"false","page":"1","parms":"","parms_source":"","query":"start_login_companies","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"180","waiting_mgs":"","x":"434","y":"-13"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'jsp\u002fdefault.jsp'","name":"pURL","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"65","x":"434","y":"-46"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cIPClient","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"828","y":"34","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"23","init":"","init_par":"","name":"m_cURL","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"434","y":"26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'jsp\u002findex.jsp?login_failed=true'","name":"pURLOE","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"114","x":"503","y":"-46"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cIPServer","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"829","y":"57","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"23","init":"","init_par":"'jsp\u002findex.jsp?login_failed=true'","name":"m_cURLOnError","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"434","y":"147"},{"calculate":"m_cUserName","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pUser","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"73","x":"622","y":"-44"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cIPSPorta","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"828","y":"81","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"23","init":"","init_par":"'execute'","name":"m_cAction","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"434","y":"67"},{"calculate":"m_cPassword","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pPwd","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"701","y":"-44"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cBrowser","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"647","y":"58","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"23","init":"","init_par":"request","name":"login_failed","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"logic","w":"180","x":"434","y":"187"},{"calculate":"g_codazi","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pAzienda","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"774","y":"-44"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cIPProtocol","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"172","wireframe_props":"name","x":"647","y":"34","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"23","init":"","init_par":"request","name":"m_cFailedLoginReason","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"memo","w":"180","x":"434","y":"107"},{"calculate":"m_cIPClient","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPC","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"865","y":"-44"},{"align":"center","anchor":"bottom-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_data","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"#848484","font_size":"","font_weight":"","fontpct":"","h":"60","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"footer_message","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Access to this system is allowed for authorised users only. \u003cbr\u003eActivities are logged and monitored\u003cbr\u003eUNAUTHORISED ACCESS IS STRICTLY PROHIBITED","w":"367","wireframe_props":"align,value,n_col","x":"23","y":"903","zindex":"5","zone":""},{"calculate":"m_cIPServer","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPS","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"941","y":"-44"},{"anchor":"top-center","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox-round-border","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"50","help_tips":"Inserisci username","hide":"","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cUserName","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"317","wireframe_props":"name","x":"48","y":"182","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"m_cIPSPorta","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPSP","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1017","y":"-44"},{"anchor":"top-center","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox-round-border","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"50","help_tips":"Inserisci password","hide":"","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cPassword","page":"1","password":"true","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"22","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"317","wireframe_props":"name","x":"48","y":"280","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"m_cIPProtocol","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pIPRP","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1093","y":"-44"},{"anchor":"top-center","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"dataobj_companies","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"50","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"g_codazi","page":"1","picture":"","rapp":"","sequence":"24","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"","valuelist":"codazi","visible":"true","w":"317","wireframe_props":"name,textlist","x":"48","y":"476","zindex":"1","zone":""},{"calculate":"m_cBrowser","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"pBrowser","page":"1","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"66","x":"1184","y":"-44"},{"align":"center","anchor":"top-center","assoc_input":"","bg_color":"","calculate":"","class_Css":"label-warn-background","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"38","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"errore","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"685","zindex":"1","zone":""},{"align":"center","anchor":"bottom-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_data","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"38","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lblCopyright","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Designed by WEB Development Team &copy; \u003cbr\u003e Gruppo MIT S.r.l. - &copy;","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"984","zindex":"1","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"60","hide":"true","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"container_captcha","page":"1","rapp":"","sequence":"28","shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"413","wireframe_props":"","x":"0","y":"741","zindex":"0","zone":""},{"alt":"","anchor":"top-center","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"50","help_tips":"Codice di controllo CAPTCHA","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image_captcha","page":"1","path_type":"","rapp":"","sequence":"29","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"130","wireframe_props":"","x":"45","y":"746","zindex":"1","zone":""},{"anchor":"top-center","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox-round-border","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"50","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"m_cCaptcha","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"30","spuid":"","tabindex":"6","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"170","wireframe_props":"name","x":"195","y":"745","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"98","hide":"true","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"container_azi","page":"1","rapp":"","sequence":"31","shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"413","wireframe_props":"","x":"0","y":"427","zindex":"0","zone":""},{"anchor":"top-center","bg_color":"","border_color":"","border_weight":"","class_Css":"button-large button-login","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"44","help_tips":"MSG_MENU_LOGIN","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Accedi","page":"1","rapp":"","sequence":"32","spuid":"","tabindex":"5","type":"Button","type_submit":"true","type_wizard":"","value":"MSG_MENU_LOGIN","w":"317","wireframe_props":"value","x":"48","y":"549","zindex":"1","zone":""},{"alt":"","anchor":"top-center","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"65","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"imgLogo","page":"1","path_type":"fixed","rapp":"","sequence":"33","server_side":"","spuid":"","src":"..\u002fimages\u002fmit.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"172","wireframe_props":"","x":"121","y":"45","zindex":"1","zone":""},{"anchor":"top-center","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox-round-border","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"50","help_tips":"Inserisci OTP","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"6","name":"m_cOTP","page":"1","password":"false","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"34","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"317","wireframe_props":"name","x":"48","y":"378","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"left","anchor":"top-center","assoc_input":"","bg_color":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelUsername","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"35","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Username","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"157","zindex":"1","zone":""},{"align":"left","anchor":"top-center","assoc_input":"","bg_color":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelAzienda","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"36","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Azienda","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"451","zindex":"1","zone":""},{"align":"left","anchor":"top-center","assoc_input":"","bg_color":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelOtp","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"37","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OTP","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"353","zindex":"1","zone":""},{"align":"left","anchor":"top-center","assoc_input":"","bg_color":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelPassword","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"38","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Password","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"255","zindex":"1","zone":""},{"anchor":"top-left","bg_color":"","border_color":"#E3A601","border_weight":"","class_Css":"button-large button-login button-oauth","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"44","help_tips":"","hide":"true","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"oauth","page":"1","rapp":"","sequence":"39","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Accedi Con Identity Provider","w":"317","wireframe_props":"value","x":"48","y":"619","zindex":"101","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"71","hide":"true","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"container_oauth","page":"1","rapp":"","sequence":"40","shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"413","wireframe_props":"","x":"0","y":"593","zindex":"0","zone":""},{"align":"center","anchor":"bottom-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label_data","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"80","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblVersione","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"41","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Versione -","w":"317","wireframe_props":"align,value,n_col","x":"48","y":"1023","zindex":"100","zone":""},{"allowedentities":"arfn_release","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function autoexec","name":"RTRelease","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"42","servlet":"arfn_release","target":"lblVersione","type":"SPLinker","w":"120","x":"434","y":"232"}]%>
<%/*Description:Login standard*/%>
<%/*ParamsRequest:login_failed,m_cFailedLoginReason,m_cUserName,m_cPassword,g_codazi,m_cOTP*/%>
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
.start_page_login_container .lblTestoBlack_class{
  color: #000;
}
.start_page_login_container .accedi_class{
  border-radius: 4px 4px 4px 4px;
  border: 0;
  background-color: #0072BC;
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

.start_page_login_container{
  overflow: hidden;
  height: 100%;
  
}

.start_page_login_container > form{
  height: 100%;
}
.start_page_login_container .label.privacy{
  color: #555555;
  font-weight: 300;
  font-size: 13px;
}
.start_page_login_container .button-large.button-login{
  background: linear-gradient(40deg, #016cfe 0%, #4033aa 100%);
  cursor: pointer;
  color: white;
}
.start_page_login_container .button-large.button-login.button-oauth{
  background: linear-gradient(40deg, #e3a601 0%, #c9950a 100%);
}
.start_page_login_container .button-large.button-login.button-oauth:hover{
  background: linear-gradient(40deg, #e3a601 0%, #c9950a 100%);
}
.start_page_login_container {
  height:100%;
  overflow:auto;
}
.start_page_login_title_container {
  margin: auto;
}
.start_page_login_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:413px;
  height:100%;
  background-color:#FFFFFF;
}
.start_page_login_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.start_page_login_portlet > .m_cIPClient_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:828px;
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
.start_page_login_portlet > .m_cIPServer_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:57px;
  left:829px;
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
.start_page_login_portlet > .m_cIPSPorta_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:81px;
  left:828px;
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
.start_page_login_portlet > .m_cBrowser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:58px;
  left:647px;
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
.start_page_login_portlet > .m_cIPProtocol_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:647px;
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
.start_page_login_portlet > .footer_message_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  left:23px;
  right:23px;
  bottom:87px;
  width:auto;
  height:auto;
  min-height:60px;
}
.start_page_login_portlet > .footer_message_ctrl {
  height:auto;
  min-height:60px;
}
.start_page_login_portlet > .footer_message_ctrl {
  overflow:hidden;
  color:#848484;
  text-align:center;
}
.start_page_login_portlet > .m_cUserName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:182px;
  width:317px;
  height:50px;
  margin-left:-158px;
  left:50%;
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
.start_page_login_portlet > .m_cPassword_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:280px;
  width:317px;
  height:50px;
  margin-left:-158px;
  left:50%;
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
.start_page_login_portlet > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:476px;
  width:317px;
  height:50px;
  margin-left:-158px;
  left:50%;
  display:none;
}
.start_page_login_portlet > .errore_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:685px;
  width:317px;
  height:auto;
  min-height:38px;
  margin-left:-158px;
  left:50%;
}
.start_page_login_portlet > .errore_ctrl {
  height:auto;
  min-height:38px;
}
.start_page_login_portlet > .errore_ctrl {
  overflow:hidden;
  text-align:center;
}
.start_page_login_portlet > .lblCopyright_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  left:48px;
  right:48px;
  bottom:28px;
  width:auto;
  height:auto;
  min-height:38px;
}
.start_page_login_portlet > .lblCopyright_ctrl {
  height:auto;
  min-height:38px;
}
.start_page_login_portlet > .lblCopyright_ctrl {
  overflow:hidden;
  text-align:center;
}
.start_page_login_portlet > .container_captcha_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:741px;
  left:0px;
  width:413px;
  height:auto;
  display:none;
  display:flex;
  flex-direction:column;
}
.start_page_login_portlet > .container_captcha_ctrl {
  height:60px;
}
.start_page_login_portlet > .container_captcha_ctrl > .box_content {
  height:100%;
}
.start_page_login_portlet > .container_captcha_ctrl {
  border-width:0px;
  border-style:solid;
}
.start_page_login_portlet > .image_captcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:746px;
  width:130px;
  height:50px;
  margin-left:-161px;
  left:50%;
}
.start_page_login_portlet > .image_captcha_ctrl {
}
.start_page_login_portlet > .image_captcha_ctrl > a, .start_page_login_portlet > .image_captcha_ctrl > a:hover{
  text-decoration:none;
}
.start_page_login_portlet > .image_captcha_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:50px;
}
.start_page_login_portlet > .m_cCaptcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:745px;
  width:170px;
  height:50px;
  margin-left:-11px;
  left:50%;
}
.start_page_login_portlet > .m_cCaptcha_ctrl {
}
.start_page_login_portlet > .m_cCaptcha_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.start_page_login_portlet > .container_azi_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:427px;
  left:0px;
  width:413px;
  height:auto;
  display:none;
  display:flex;
  flex-direction:column;
}
.start_page_login_portlet > .container_azi_ctrl {
  height:98px;
}
.start_page_login_portlet > .container_azi_ctrl > .box_content {
  height:100%;
}
.start_page_login_portlet > .container_azi_ctrl {
  border-width:0px;
  border-style:solid;
}
.start_page_login_portlet > .Accedi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:549px;
  width:317px;
  height:44px;
  margin-left:-158px;
  left:50%;
}
.start_page_login_portlet > .Accedi_ctrl {
}
.start_page_login_portlet > .imgLogo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  width:172px;
  height:65px;
  margin-left:-85px;
  left:50%;
}
.start_page_login_portlet > .imgLogo_ctrl {
}
.start_page_login_portlet > .imgLogo_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet > .m_cOTP_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:378px;
  width:317px;
  height:50px;
  margin-left:-158px;
  left:50%;
  display:none;
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
.start_page_login_portlet > .labelUsername_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:157px;
  width:317px;
  height:auto;
  min-height:20px;
  margin-left:-158px;
  left:50%;
}
.start_page_login_portlet > .labelUsername_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_login_portlet > .labelUsername_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .labelAzienda_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:451px;
  width:317px;
  height:auto;
  min-height:20px;
  margin-left:-158px;
  left:50%;
  display:none;
}
.start_page_login_portlet > .labelAzienda_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_login_portlet > .labelAzienda_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .labelOtp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:353px;
  width:317px;
  height:auto;
  min-height:20px;
  margin-left:-158px;
  left:50%;
  display:none;
}
.start_page_login_portlet > .labelOtp_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_login_portlet > .labelOtp_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .labelPassword_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:255px;
  width:317px;
  height:auto;
  min-height:20px;
  margin-left:-158px;
  left:50%;
}
.start_page_login_portlet > .labelPassword_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_login_portlet > .labelPassword_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .oauth_ctrl {
  box-sizing:border-box;
  z-index:101;
  position:absolute;
  display:inline-block;
  top:619px;
  left:48px;
  width:317px;
  height:44px;
  display:none;
}
.start_page_login_portlet > .oauth_ctrl {
  border-color:#E3A601;
}
.start_page_login_portlet > .container_oauth_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:593px;
  left:0px;
  width:413px;
  height:auto;
  display:none;
  display:flex;
  flex-direction:column;
}
.start_page_login_portlet > .container_oauth_ctrl {
  height:71px;
}
.start_page_login_portlet > .container_oauth_ctrl > .box_content {
  height:100%;
}
.start_page_login_portlet > .container_oauth_ctrl {
  border-width:0px;
  border-style:solid;
}
.start_page_login_portlet > .lblVersione_ctrl {
  box-sizing:border-box;
  z-index:100;
  position:absolute;
  display:inline-block;
  left:48px;
  right:48px;
  bottom:3px;
  width:auto;
  height:auto;
  min-height:24px;
}
.start_page_login_portlet > .lblVersione_ctrl {
  height:auto;
  min-height:24px;
}
.start_page_login_portlet > .lblVersione_ctrl {
  overflow:hidden;
  text-align:center;
  background-color:transparent;
}
.start_page_login_portlet > .lblVersione_ctrl > div{
  font-size:80%;
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
 String def="[{\"h\":\"1050\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"413\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"180\",\"x\":\"434\",\"y\":\"-13\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"65\",\"x\":\"434\",\"y\":\"-46\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cIPClient\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"828\",\"y\":\"34\",\"zindex\":\"1\"},{\"h\":\"23\",\"name\":\"m_cURL\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"434\",\"y\":\"26\"},{\"h\":\"22\",\"name\":\"pURLOE\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"114\",\"x\":\"503\",\"y\":\"-46\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cIPServer\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"829\",\"y\":\"57\",\"zindex\":\"1\"},{\"h\":\"23\",\"name\":\"m_cURLOnError\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"434\",\"y\":\"147\"},{\"h\":\"20\",\"name\":\"pUser\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"73\",\"x\":\"622\",\"y\":\"-44\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cIPSPorta\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"828\",\"y\":\"81\",\"zindex\":\"1\"},{\"h\":\"23\",\"name\":\"m_cAction\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"434\",\"y\":\"67\"},{\"h\":\"20\",\"name\":\"pPwd\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"701\",\"y\":\"-44\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cBrowser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"647\",\"y\":\"58\",\"zindex\":\"1\"},{\"h\":\"23\",\"name\":\"login_failed\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"434\",\"y\":\"187\"},{\"h\":\"20\",\"name\":\"pAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"774\",\"y\":\"-44\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cIPProtocol\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"172\",\"x\":\"647\",\"y\":\"34\",\"zindex\":\"1\"},{\"h\":\"23\",\"name\":\"m_cFailedLoginReason\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"434\",\"y\":\"107\"},{\"h\":\"20\",\"name\":\"pIPC\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"865\",\"y\":\"-44\"},{\"align\":\"center\",\"anchor\":\"bottom-left-right\",\"h\":\"60\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"footer_message\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Access to this system is allowed for authorised users only. \\u003cbr\\u003eActivities are logged and monitored\\u003cbr\\u003eUNAUTHORISED ACCESS IS STRICTLY PROHIBITED\",\"w\":\"367\",\"x\":\"23\",\"y\":\"903\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"pIPS\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"941\",\"y\":\"-44\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"m_cUserName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"317\",\"x\":\"48\",\"y\":\"182\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"pIPSP\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1017\",\"y\":\"-44\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"m_cPassword\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"317\",\"x\":\"48\",\"y\":\"280\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"pIPRP\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1093\",\"y\":\"-44\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"g_codazi\",\"page\":\"1\",\"textlist\":\"desazi\",\"type\":\"Combobox\",\"w\":\"317\",\"x\":\"48\",\"y\":\"476\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"pBrowser\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"1184\",\"y\":\"-44\"},{\"align\":\"center\",\"anchor\":\"top-center\",\"h\":\"38\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"errore\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"317\",\"x\":\"48\",\"y\":\"685\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"bottom-left-right\",\"h\":\"38\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lblCopyright\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Designed by WEB Development Team &copy; \\u003cbr\\u003e Gruppo MIT S.r.l. - &copy;\",\"w\":\"317\",\"x\":\"48\",\"y\":\"984\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"60\",\"layout_steps_values\":{},\"name\":\"container_captcha\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"413\",\"x\":\"0\",\"y\":\"741\",\"zindex\":\"0\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"image_captcha\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"130\",\"x\":\"45\",\"y\":\"746\",\"zindex\":\"1\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"m_cCaptcha\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"170\",\"x\":\"195\",\"y\":\"745\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"98\",\"layout_steps_values\":{},\"name\":\"container_azi\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"413\",\"x\":\"0\",\"y\":\"427\",\"zindex\":\"0\"},{\"anchor\":\"top-center\",\"h\":\"44\",\"layout_steps_values\":{},\"name\":\"Accedi\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_MENU_LOGIN\",\"w\":\"317\",\"x\":\"48\",\"y\":\"549\",\"zindex\":\"1\"},{\"anchor\":\"top-center\",\"h\":\"65\",\"layout_steps_values\":{},\"name\":\"imgLogo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"172\",\"x\":\"121\",\"y\":\"45\",\"zindex\":\"1\"},{\"anchor\":\"top-center\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"m_cOTP\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"317\",\"x\":\"48\",\"y\":\"378\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-center\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelUsername\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Username\",\"w\":\"317\",\"x\":\"48\",\"y\":\"157\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-center\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelAzienda\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Azienda\",\"w\":\"317\",\"x\":\"48\",\"y\":\"451\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-center\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelOtp\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OTP\",\"w\":\"317\",\"x\":\"48\",\"y\":\"353\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-center\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelPassword\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Password\",\"w\":\"317\",\"x\":\"48\",\"y\":\"255\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"44\",\"layout_steps_values\":{},\"name\":\"oauth\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Accedi Con Identity Provider\",\"w\":\"317\",\"x\":\"48\",\"y\":\"619\",\"zindex\":\"101\"},{\"anchor\":\"\",\"h\":\"71\",\"layout_steps_values\":{},\"name\":\"container_oauth\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"413\",\"x\":\"0\",\"y\":\"593\",\"zindex\":\"0\"},{\"align\":\"center\",\"anchor\":\"bottom-left-right\",\"h\":\"24\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblVersione\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Versione -\",\"w\":\"317\",\"x\":\"48\",\"y\":\"1023\",\"zindex\":\"100\"},{\"h\":\"20\",\"name\":\"RTRelease\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"434\",\"y\":\"232\"}]";
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
<html  ps-stretch>
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
.start_page_login_portlet > .g_codazi_ctrl {
  display:none;
}
.start_page_login_portlet > .container_captcha_ctrl {
  display:none;
}
.start_page_login_portlet > .container_azi_ctrl {
  display:none;
}
.start_page_login_portlet > .m_cOTP_ctrl {
  display:none;
}
.start_page_login_portlet > .labelAzienda_ctrl {
  display:none;
}
.start_page_login_portlet > .labelOtp_ctrl {
  display:none;
}
.start_page_login_portlet > .oauth_ctrl {
  display:none;
}
.start_page_login_portlet > .container_oauth_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_login','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String pURL="jsp/default.jsp";
String m_cIPClient= "";
if(request.getAttribute("start_page_login_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String m_cURL= "";
String pURLOE="jsp/index.jsp?login_failed=true";
String m_cIPServer= "";
String m_cURLOnError="jsp/index.jsp?login_failed=true";
String pUser= "";
String m_cIPSPorta= "";
String m_cAction="execute";
String pPwd= "";
String m_cBrowser= "";
boolean login_failed=sp.getParameter("login_failed",false);
String pAzienda= "";
String m_cIPProtocol= "";
String m_cFailedLoginReason=JSPLib.translateXSS(sp.getParameter("m_cFailedLoginReason",""));
String pIPC= "";
String footer_message= "Access to this system is allowed for authorised users only. <br>Activities are logged and monitored<br>UNAUTHORISED ACCESS IS STRICTLY PROHIBITED";
String pIPS= "";
String m_cUserName=JSPLib.translateXSS(sp.getParameter("m_cUserName",""));
String pIPSP= "";
String m_cPassword=JSPLib.translateXSS(sp.getParameter("m_cPassword",""));
String pIPRP= "";
String g_codazi=JSPLib.translateXSS(sp.getParameter("g_codazi",""));
String pBrowser= "";
String errore= "";
String lblCopyright= "Designed by WEB Development Team &copy; <br> Gruppo MIT S.r.l. - &copy;";
String m_cCaptcha= "";
String m_cOTP=JSPLib.translateXSS(sp.getParameter("m_cOTP",""));
String labelUsername= "Username";
String labelAzienda= "Azienda";
String labelOtp= "OTP";
String labelPassword= "Password";
String lblVersione= "Versione -";
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
<input id='<%=idPortlet%>_pURL' name='pURL' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPClient_wrp'><input id='<%=idPortlet%>_m_cIPClient' name='m_cIPClient' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPClient' /></span>
<input id='<%=idPortlet%>_m_cURL' name='m_cURL' type='hidden'/>
<input id='<%=idPortlet%>_pURLOE' name='pURLOE' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPServer_wrp'><input id='<%=idPortlet%>_m_cIPServer' name='m_cIPServer' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPServer' /></span>
<input id='<%=idPortlet%>_m_cURLOnError' name='m_cURLOnError' type='hidden'/>
<input id='<%=idPortlet%>_pUser' name='pUser' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPSPorta_wrp'><input id='<%=idPortlet%>_m_cIPSPorta' name='m_cIPSPorta' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPSPorta' /></span>
<input id='<%=idPortlet%>_m_cAction' name='m_cAction' type='hidden'/>
<input id='<%=idPortlet%>_pPwd' name='pPwd' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cBrowser_wrp'><input id='<%=idPortlet%>_m_cBrowser' name='m_cBrowser' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cBrowser' /></span>
<input id='<%=idPortlet%>_login_failed' name='login_failed' type='hidden'/>
<input id='<%=idPortlet%>_pAzienda' name='pAzienda' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cIPProtocol_wrp'><input id='<%=idPortlet%>_m_cIPProtocol' name='m_cIPProtocol' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cIPProtocol' /></span>
<textarea id='<%=idPortlet%>_m_cFailedLoginReason' name='m_cFailedLoginReason' style='display:none'></textarea>
<input id='<%=idPortlet%>_pIPC' name='pIPC' type='hidden'/>
<span id='<%=idPortlet%>_footer_message'  formid='<%=idPortlet%>' ps-name='footer_message'    class='label_data footer_message_ctrl'><div id='<%=idPortlet%>_footer_messagetbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Access to this system is allowed for authorised users only. <br>Activities are logged and monitored<br>UNAUTHORISED ACCESS IS STRICTLY PROHIBITED"))%></div></span>
<input id='<%=idPortlet%>_pIPS' name='pIPS' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cUserName_wrp'><input id='<%=idPortlet%>_m_cUserName' name='m_cUserName' type='text' class='textbox-round-border' tabindex='1' formid='<%=idPortlet%>' ps-name='m_cUserName' /></span>
<input id='<%=idPortlet%>_pIPSP' name='pIPSP' type='hidden'/>
<span class='textbox-container'id='<%=idPortlet%>_m_cPassword_wrp'><input id='<%=idPortlet%>_m_cPassword' name='m_cPassword' type='password' class='textbox-round-border' tabindex='3' formid='<%=idPortlet%>' autocomplete='off' ps-name='m_cPassword' /></span>
<input id='<%=idPortlet%>_pIPRP' name='pIPRP' type='hidden'/>
<select id='<%=idPortlet%>_g_codazi' name='g_codazi' class='combobox' style='' tabindex='4'></select>
<input id='<%=idPortlet%>_pBrowser' name='pBrowser' type='hidden'/>
<span id='<%=idPortlet%>_errore'  formid='<%=idPortlet%>' ps-name='errore'    class='label-warn-background errore_ctrl'><div id='<%=idPortlet%>_erroretbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_lblCopyright'  formid='<%=idPortlet%>' ps-name='lblCopyright'    class='label_data lblCopyright_ctrl'><div id='<%=idPortlet%>_lblCopyrighttbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Designed by WEB Development Team &copy; <br> Gruppo MIT S.r.l. - &copy;"))%></div></span>
<div id='<%=idPortlet%>_container_captcha' class='container_captcha_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_container_captcha_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_image_captcha'><a id='<%=idPortlet%>_image_captchahref' href='javascript:void(0)' target='_self'><img id='<%=idPortlet%>_image_captcha_img' class='image image_captcha_ctrl' src="" border='0' ></a>
</div><span class='textbox-container'id='<%=idPortlet%>_m_cCaptcha_wrp'><input id='<%=idPortlet%>_m_cCaptcha' name='m_cCaptcha' type='text' class='textbox-round-border' tabindex='6' formid='<%=idPortlet%>' ps-name='m_cCaptcha' /></span>
<div id='<%=idPortlet%>_container_azi' class='container_azi_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_container_azi_td' class='box_content'></div>
</div>
<input id='<%=idPortlet%>_Accedi' type='submit' class='button-large button-login Accedi_ctrl' tabindex='5'/>
<div id='<%=idPortlet%>_imgLogo'>
<img id='<%=idPortlet%>_imgLogo_img' class='image imgLogo_ctrl' src="../images/mit.jpg" >
</div>
<span class='textbox-container'id='<%=idPortlet%>_m_cOTP_wrp'><input id='<%=idPortlet%>_m_cOTP' name='m_cOTP' type='text' maxlength='6' class='textbox-round-border' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cOTP' /></span>
<span id='<%=idPortlet%>_labelUsername'  formid='<%=idPortlet%>' ps-name='labelUsername'    class='label-small-bold-uppercase labelUsername_ctrl'><div id='<%=idPortlet%>_labelUsernametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Username"))%></div></span>
<span id='<%=idPortlet%>_labelAzienda'  formid='<%=idPortlet%>' ps-name='labelAzienda'    class='label-small-bold-uppercase labelAzienda_ctrl'><div id='<%=idPortlet%>_labelAziendatbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Azienda"))%></div></span>
<span id='<%=idPortlet%>_labelOtp'  formid='<%=idPortlet%>' ps-name='labelOtp'    class='label-small-bold-uppercase labelOtp_ctrl'><div id='<%=idPortlet%>_labelOtptbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("OTP"))%></div></span>
<span id='<%=idPortlet%>_labelPassword'  formid='<%=idPortlet%>' ps-name='labelPassword'    class='label-small-bold-uppercase labelPassword_ctrl'><div id='<%=idPortlet%>_labelPasswordtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Password"))%></div></span>
<input id='<%=idPortlet%>_oauth' type='button' class='button-large button-login button-oauth oauth_ctrl'/>
<div id='<%=idPortlet%>_container_oauth' class='container_oauth_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_container_oauth_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_lblVersione'  formid='<%=idPortlet%>' ps-name='lblVersione'    class='label_data lblVersione_ctrl'><div id='<%=idPortlet%>_lblVersionetbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Versione -"))%></div></span>
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
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_login',["413"],["1050"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"413","h":"1050","title":"","layer":""}]);
this.dataobj_companies=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"start_login_companies","cmdHash":"<%=JSPLib.cmdHash("start_login_companies",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_companies","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":23,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_companies","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":180,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":434,"y":-13});
this.pURL=new ZtVWeb._VC(this,'pURL','<%=idPortlet%>_pURL','character','<%=JSPLib.ToJSValue(pURL,false,true)%>',false,false);
this.m_cIPClient=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPClient","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cIPClient","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPClient,false,true)%>","w":90,"x":828,"y":34,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cURL=new ZtVWeb._VC(this,'m_cURL','<%=idPortlet%>_m_cURL','character','<%=JSPLib.ToJSValue(m_cURL,false,true)%>',false,false);
this.pURLOE=new ZtVWeb._VC(this,'pURLOE','<%=idPortlet%>_pURLOE','character','<%=JSPLib.ToJSValue(pURLOE,false,true)%>',false,false);
this.m_cIPServer=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPServer","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cIPServer","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPServer,false,true)%>","w":90,"x":829,"y":57,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cURLOnError=new ZtVWeb._VC(this,'m_cURLOnError','<%=idPortlet%>_m_cURLOnError','character','<%=JSPLib.ToJSValue(m_cURLOnError,false,true)%>',false,false);
this.pUser=new ZtVWeb._VC(this,'pUser','<%=idPortlet%>_pUser','character','<%=JSPLib.ToJSValue(pUser,false,true)%>',false,false);
this.m_cIPSPorta=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPSPorta","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cIPSPorta","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPSPorta,false,true)%>","w":90,"x":828,"y":81,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cAction=new ZtVWeb._VC(this,'m_cAction','<%=idPortlet%>_m_cAction','character','<%=JSPLib.ToJSValue(m_cAction,false,true)%>',false,false);
this.pPwd=new ZtVWeb._VC(this,'pPwd','<%=idPortlet%>_pPwd','character','<%=JSPLib.ToJSValue(pPwd,false,true)%>',false,false);
this.m_cBrowser=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cBrowser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cBrowser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cBrowser,false,true)%>","w":90,"x":647,"y":58,"zerofilling":false,"zindex":"1","zoom":""});
this.login_failed=new ZtVWeb._VC(this,'login_failed','<%=idPortlet%>_login_failed','logic',<%=login_failed%>,false,false);
this.pAzienda=new ZtVWeb._VC(this,'pAzienda','<%=idPortlet%>_pAzienda','character','<%=JSPLib.ToJSValue(pAzienda,false,true)%>',false,false);
this.m_cIPProtocol=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cIPProtocol","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cIPProtocol","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cIPProtocol,false,true)%>","w":172,"x":647,"y":34,"zerofilling":false,"zindex":"1","zoom":""});
this.m_cFailedLoginReason=new ZtVWeb._VC(this,'m_cFailedLoginReason','<%=idPortlet%>_m_cFailedLoginReason','memo','<%=JSPLib.ToJSValue(m_cFailedLoginReason,false,true)%>',false,false);
this.pIPC=new ZtVWeb._VC(this,'pIPC','<%=idPortlet%>_pIPC','character','<%=JSPLib.ToJSValue(pIPC,false,true)%>',false,false);
this.footer_message=new ZtVWeb._LC(this,{"align":"center","anchor":"bottom-left-right","assoc_input":"","calculate":"","class_Css":"label_data","create_undercond":"","ctrlid":"<%=idPortlet%>_footer_message","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"#848484","font_size":"","font_weight":"","fontpct":"","h":60,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"footer_message","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(footer_message),false,true)%>","type":"Label","w":367,"x":23,"y":903,"zindex":"5"});
this.pIPS=new ZtVWeb._VC(this,'pIPS','<%=idPortlet%>_pIPS','character','<%=JSPLib.ToJSValue(pIPS,false,true)%>',false,false);
this.m_cUserName=new ZtVWeb._TC(this,{"anchor":"top-center","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cUserName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":50,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci username"),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cUserName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cUserName,false,true)%>","w":317,"x":48,"y":182,"zerofilling":false,"zindex":"1","zoom":""});
this.pIPSP=new ZtVWeb._VC(this,'pIPSP','<%=idPortlet%>_pIPSP','character','<%=JSPLib.ToJSValue(pIPSP,false,true)%>',false,false);
this.m_cPassword=new ZtVWeb._TC(this,{"anchor":"top-center","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cPassword","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":50,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci password"),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cPassword","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cPassword,false,true)%>","w":317,"x":48,"y":280,"zerofilling":false,"zindex":"1","zoom":""});
this.pIPRP=new ZtVWeb._VC(this,'pIPRP','<%=idPortlet%>_pIPRP','character','<%=JSPLib.ToJSValue(pIPRP,false,true)%>',false,false);
this.g_codazi=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-center","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_g_codazi","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":50,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"<%=g_codazi%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"g_codazi","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":true,"w":317,"x":48,"y":476,"zindex":"1"});
this.pBrowser=new ZtVWeb._VC(this,'pBrowser','<%=idPortlet%>_pBrowser','character','<%=JSPLib.ToJSValue(pBrowser,false,true)%>',false,false);
this.errore=new ZtVWeb._LC(this,{"align":"center","anchor":"top-center","assoc_input":"","calculate":"","class_Css":"label-warn-background","create_undercond":"","ctrlid":"<%=idPortlet%>_errore","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":38,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"errore","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(errore),false,true)%>","type":"Label","w":317,"x":48,"y":685,"zindex":"1"});
this.lblCopyright=new ZtVWeb._LC(this,{"align":"center","anchor":"bottom-left-right","assoc_input":"","calculate":"","class_Css":"label_data","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCopyright","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":38,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCopyright","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblCopyright),false,true)%>","type":"Label","w":317,"x":48,"y":984,"zindex":"1"});
this.container_captcha=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_container_captcha","groupName":"","h":60,"hide":"true","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"container_captcha","page":1,"shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":413,"x":0,"y":741,"zindex":"0"});
this.image_captcha=new ZtVWeb._IC(this,{"alt":"","anchor":"top-center","boundedPosition":"","class_Css":"image image_captcha_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_captcha","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":50,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Codice di controllo CAPTCHA"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image_captcha","page":1,"path_type":"","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":130,"x":45,"y":746,"zindex":"1"});
this.m_cCaptcha=new ZtVWeb._TC(this,{"anchor":"top-center","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cCaptcha","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":50,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cCaptcha","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cCaptcha,false,true)%>","w":170,"x":195,"y":745,"zerofilling":false,"zindex":"1","zoom":""});
this.container_azi=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_container_azi","groupName":"","h":98,"hide":"true","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"container_azi","page":1,"shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":413,"x":0,"y":427,"zindex":"0"});
this.Accedi=new ZtVWeb._BC(this,{"anchor":"top-center","bg_color":"","border_color":"","border_weight":"","class_Css":"button-large button-login Accedi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Accedi","edit_undercond":"","font":"","font_color":"","font_size":"","h":44,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_MENU_LOGIN"),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Accedi","page":1,"spuid":"","tabindex":"5","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_MENU_LOGIN"),false,true)%>","type":"Button","type_submit":"true","type_wizard":"","w":317,"x":48,"y":549,"zindex":"1"});
this.imgLogo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-center","boundedPosition":"","class_Css":"image imgLogo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgLogo","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":65,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imgLogo","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"..\u002fimages\u002fmit.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":172,"x":121,"y":45,"zindex":"1"});
this.m_cOTP=new ZtVWeb._TC(this,{"anchor":"top-center","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cOTP","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":50,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci OTP"),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"6","name":"m_cOTP","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cOTP,false,true)%>","w":317,"x":48,"y":378,"zerofilling":false,"zindex":"1","zoom":""});
this.labelUsername=new ZtVWeb._LC(this,{"align":"left","anchor":"top-center","assoc_input":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlid":"<%=idPortlet%>_labelUsername","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelUsername","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelUsername),false,true)%>","type":"Label","w":317,"x":48,"y":157,"zindex":"1"});
this.labelAzienda=new ZtVWeb._LC(this,{"align":"left","anchor":"top-center","assoc_input":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlid":"<%=idPortlet%>_labelAzienda","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelAzienda","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelAzienda),false,true)%>","type":"Label","w":317,"x":48,"y":451,"zindex":"1"});
this.labelOtp=new ZtVWeb._LC(this,{"align":"left","anchor":"top-center","assoc_input":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlid":"<%=idPortlet%>_labelOtp","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelOtp","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelOtp),false,true)%>","type":"Label","w":317,"x":48,"y":353,"zindex":"1"});
this.labelPassword=new ZtVWeb._LC(this,{"align":"left","anchor":"top-center","assoc_input":"","calculate":"","class_Css":"label-small-bold-uppercase","create_undercond":"","ctrlid":"<%=idPortlet%>_labelPassword","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelPassword","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelPassword),false,true)%>","type":"Label","w":317,"x":48,"y":255,"zindex":"1"});
this.oauth=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"#E3A601","border_weight":"","class_Css":"button-large button-login button-oauth oauth_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_oauth","edit_undercond":"","font":"","font_color":"","font_size":"","h":44,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"oauth","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("Accedi Con Identity Provider"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":317,"x":48,"y":619,"zindex":"101"});
this.container_oauth=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_container_oauth","groupName":"","h":71,"hide":"true","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"container_oauth","page":1,"shrinkable":"true","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":413,"x":0,"y":593,"zindex":"0"});
this.lblVersione=new ZtVWeb._LC(this,{"align":"center","anchor":"bottom-left-right","assoc_input":"","calculate":"","class_Css":"label_data","create_undercond":"","ctrlid":"<%=idPortlet%>_lblVersione","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"80","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblVersione","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblVersione),false,true)%>","type":"Label","w":317,"x":48,"y":1023,"zindex":"100"});
this.RTRelease=new ZtVWeb.SPLinkerCtrl(this,{"action":"function autoexec","allowedEntities":"<%=JSPLib.encrypt("arfn_release",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRelease","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRelease","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_release","target":"lblVersione","type":"SPLinker","w":120,"x":434,"y":232});
this.RTRelease.m_cID='<%=JSPLib.cmdHash("routine,arfn_release",request.getSession())%>';
this.RTRelease.Link();
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
if(typeof oauth_Click !='undefined')this.oauth_Click=oauth_Click;
if(typeof oauth_img_Click !='undefined')this.oauth_img_Click=oauth_img_Click;
if(typeof dataobj_companies_ConsumersRendered !='undefined')this.dataobj_companies_ConsumersRendered=dataobj_companies_ConsumersRendered;
if(typeof image_captcha_Click !='undefined')this.image_captcha_Click=image_captcha_Click;
if(typeof image_captcha_new_code_Click !='undefined')this.image_captcha_new_code_Click=image_captcha_new_code_Click;
if(typeof this_OnSubmit !='undefined')this.this_OnSubmit=this_OnSubmit;
if(typeof lblVersione_Click !='undefined')this.lblVersione_Click=lblVersione_Click;
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
<%}
 // GESTIONE OAUTH IDENTITY PROVIDER(S)
  final com.zucchetti.sitepainter.oauth.client.IdentityProvider identityProvider = com.zucchetti.sitepainter.oauth.SPOAuthLibrary.GetIdentityProvider("0000000001", request);
	String authURI = "";
  if (identityProvider != null ) {
    authURI = identityProvider.makeAuthURI(request.getSession());
// final Set<String> identityProviderNames = com.zucchetti.sitepainter.oauth.SPOAuthLibrary.GetAvailableIdentityProviders();
// if(identityProviderNames.size()>0) {
//   String firstIdentityProviderName = null;
//   for (String providerName : identityProviderNames) {
//     firstIdentityProviderName = providerName;
//     break;
//   }
//   final com.zucchetti.sitepainter.oauth.client.IdentityProvider identityProvider = com.zucchetti.sitepainter.oauth.SPOAuthLibrary.GetIdentityProvider(firstIdentityProviderName);
//   final String authURI = identityProvider.makeAuthURI(request.getSession());
// redirect automatica ad Identity Provider
    if(identityProvider.isAutologin()) { %>
location.href='<%=authURI%>';
return;<%
    } else {
%>// login su Identity Provider da pulsante
this.oauth.Show();
//this.oauth_img.Show();
this.container_oauth.Show();<%
    }
  } %>
                                    
function oauth_Click() {
  let a = document.createElement("a");
  a.href = "<%=authURI%>";
  a.target = "_self";
  a.click();
}
  
function oauth_img_Click(){
  oauth_Click();
}
<% //} // GESTIONE OAUTH IDENTITY PROVIDER(S) FINE %>
  
this.dataobj_companies.Query();
  
function dataobj_companies_ConsumersRendered(){     
  this.g_codazi.Show();
  this.labelAzienda.Show();
  this.container_azi.Show();  
  if(this.dataobj_companies.isEmpty() || this.dataobj_companies.GetQueryCount()=="1"){
    this.g_codazi.empty_value=false;    
    // this.g_codazi.Hide();
    // this.labelAzienda.Hide();
    // this.container_azi.Hide();
    this.g_codazi.Disabled();
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
else
  this.errore.Hide();
<%if(com.zucchetti.sitepainter.Library.captchaMustBeShown(request)){
//da esplorare la possibilita' di chiedere captcha di una certa dimensione piuttosto che averla
//fissa lato server
%>
this.image_captcha.Ctrl.style.width='<%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageWidth/2%>px';
this.image_captcha.Ctrl.style.height='<%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageHeight/2%>px';
this.image_captcha.Value('../servlet/SPImageCaptchaServlet');
this.container_captcha.Show();
<%}else{%>
this.m_cCaptcha.Hide();
this.image_captcha.Hide();
//this.image_captcha_new_code.Hide();
this.container_captcha.Hide();
<%}%>
  
function this_OnSubmit(){
  this.pPwd.Value(this.m_cPassword.Value())
}
        
function lblVersione_Click(){
  this.RTRelease.Link();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_login_Static.call(window.<%=idPortlet%>);
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
<%! public String getJSPUID() { return "3723464694"; } %>