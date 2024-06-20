<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var elementModified = null;\nm_cProgName='spsecurityentity';\nm_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\nfunction chkDisplayClosed_onChange(){\n  if (this.entitycontainer.iframe.contentWindow)\n  \tthis.entitycontainer.iframe.contentWindow.ShowDisabledItems(this.chkDisplayClosed.Value());\n}\n\nfunction cpgroupslink_GetZoomLink(offline) {\n  return ZtVWeb.SPWebRootURL+'\u002fjsp-system\u002fspadministration_groups_zoom_portlet.jsp?';\n}\n\nfunction cproleslink_GetZoomLink(offline) {\n  return ZtVWeb.SPWebRootURL+'\u002fjsp-system\u002fspadministration_groups_zoom_portlet.jsp?grptype='+URLenc(this.roleType.Value())+'&'\n    \t\t+(this.radioAddRemoveRole.Value()==1 \u002f*addtouser*\u002f ?'disableGroupsOf=' : 'enableGroupsOf=')+URLenc(this.selectUser.Value())+'&';\u002f\u002fsostituisce il FixedFilter  \n}\nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  if(m_cTarget != \"_blank\") {\n    customToolbar.AppendButton({\n      image:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n      action:'..\u002fservlet\u002fSPControlPanel',\n      title:FormatMsg(\"MSG_BACK\"),\n      tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n    })\n  }\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })\n  if (this.entityname.Value()) {\n    this.lblSelectEntity.Hide();\n    this.imgSelectEntity.Hide();\n    this.LoadEntity()\n  } else {\n    customToolbar.SetTitle(FormatMsg('MSG_RESOURCE_SAFETY','\u003c'+FormatMsg('MSG_SELECT_RESOURCE_TO_MANAGE')+'\u003e'),true);\n    customToolbar.RearrangeAll(); \u002f\u002fLoadEntity chiama questo metodo sempre\n    this.radioUserGroup_onChange();\n    this.radioUserGroup.Disabled();\n    this.chkDisplayClosed.Disabled();\n    this.nameGroup.Disabled();\n    this.cpgroupslink.Disabled();\n  }\n}\nfunction LoadEntity() {\n  _allElements=null;\u002f\u002fresetto l'oggetto con gli elementi dell'entita'\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.SetTitle(FormatMsg('MSG_RESOURCE_SAFETY',this.entityname.Value()),true);\n  customToolbar.RearrangeAll();\n  this.radioUserGroup.Enabled();\n  this.chkDisplayClosed.Enabled();\n  this.nameGroup.Enabled();\n  this.cpgroupslink.Enabled();\n  this.selectUser.Value(0);\n  this.selectGroup.Value(0);\n  this.splink_current.Servlet(this.entityname.Value());\n  this.splink_public.Servlet(this.entityname.Value());\n  this.entitycontainer.Load('..\u002fservlet\u002f'+this.entityname.Value()+'?m_cAction=painter');\n}\nfunction entitycontainer_Loaded(){\n  if (this.entitycontainer.iframe.src!='javascript:[].join()') {\n    if (this.entitycontainer.iframe.contentWindow && this.entitycontainer.iframe.contentWindow.InitializeEdits) {\n      \u002f\u002fse non trovo la funzione c'e' stato un errore e segnalo un errore generico\n      this.entitycontainer.iframe.contentWindow.InitializeEdits(this);\n      this.radioUserGroup_onChange();\n      this.splink_public.Link();\n    } else {\n      alert(FormatMsg('MSG_ACC_NOT_ALLOWED'));\n      this.entityname.Value('');\n      this.radioUserGroup_onChange();\n      this.radioUserGroup.Disabled();\n      this.chkDisplayClosed.Disabled();\n      this.nameGroup.Disabled();\n      this.cpgroupslink.Disabled();\n    }\n  }\n}\nfunction radioUserGroup_onChange(){\n  if (this.radioUserGroup.Value()=='U') {\n    this.m_nMenuOfGroup.Value(0);\n    this.cpgroupslink.Hide();\n    this.nameGroup.Hide();\n    this.nameGroup.Value('');\n\t\tthis.cpuserslink.Show();\n    this.nameUser.Show();\n  } else {\n    this.m_nMenuOfUser.Value(0);\n    this.cpuserslink.Hide();\n    this.nameUser.Hide();\n    this.nameUser.Value('');\n    this.cpgroupslink.Show();\n    this.nameGroup.Show();\n\t\tthis.nameRole.Hide();\n    this.radioAddRemoveRole.Hide();\n    this.cproleslink.Hide();\n    this.btnaddremoverole.Hide();\n  }\n  if (this.entitycontainer.iframe.contentWindow && this.entitycontainer.iframe.contentWindow.BlankStatusBySelection)\n  \tthis.entitycontainer.iframe.contentWindow.BlankStatusBySelection();\n}\n\nfunction selectUser_onChange(){\n  this.selectRole.Value(0);\n  if (Empty(this.selectUser.Value())) {\n\t\tthis.nameRole.Hide();\n    this.radioAddRemoveRole.Hide();\n    this.cproleslink.Hide();\n  } else {\n    this.nameRole.Show();\n    this.radioAddRemoveRole.Show();\n    this.cproleslink.Show();\n  }\n}\n\nfunction cpgroupslink_LinkBlanked(){\n  this.m_nMenuOfGroup.Value( '' );\n  this.valueChanged();\n}\n\nfunction cpuserslink_LinkBlanked(){\n  this.entitycontainer.iframe.contentWindow.BlankStatusByRole();\n  this.m_nMenuOfUser.Value( '' );\n  this.valueChanged();\n}\n\nfunction cpgroupslink_LinkExecuted(){\n  this.m_nMenuOfGroup.Value( this.selectGroup.Value() );\n  this.m_nMenuOfUser.Value( '' );\n  this.valueChanged();\n}\n\nfunction cpuserslink_LinkExecuted(){\n  this.m_nMenuOfUser.Value( this.selectUser.Value() );\n  this.m_nMenuOfGroup.Value( '' );\n  this.valueChanged();\n}\n\nfunction cproleslink_LinkExecuted(){\n\tvar refresh = true;\n  if (!Empty(this.selectRole.Value())) {\n    var groups = this.checkRole.Link();\n    groups = groups.trim().split(\u002f *, *\u002f);\n    if ((this.radioAddRemoveRole.Value()==1 ? Ne : Eq ) (groups.indexOf(Str(this.selectRole.Value(),9).trim()), -1 ) ) {\n      this.selectRole.Value(0);\n      if (this.radioAddRemoveRole.Value()==1)\n      \talert(FormatMsg('MSG_USER_BELONGS_TO_ROLE'));\n     \telse\n        alert(FormatMsg('MSG_USER_NOT_BELONGS_TO_ROLE'));\n      refresh=false;\n    }\n  } \n\tif ( refresh ) {\n    this.entitycontainer.iframe.contentWindow.BlankStatusByRole();\n  \tthis.m_nMenuOfGroup.Value( this.selectRole.Value() );\n  \tthis.valueChanged();\n  \tthis.btnaddremoverole.Show();\n  }\n}\nfunction cproleslink_LinkBlanked(){\n  this.m_nMenuOfGroup.Value( '' );\n  this.valueChanged();\n  this.btnaddremoverole.Hide();\n}\n\nfunction splinkerupdate_Error(cCause){\n  if (this.entitycontainer.iframe.contentWindow)\n  \tthis.entitycontainer.iframe.contentWindow.elementModified = null; \u002f\u002fin caso di errore devo resettare l'elemento appena modificato\n  alert(cCause);\n}\nfunction splinkerupdate_Result(result){\n  if (result==='true') {\n    this.splink_public.Link(); \u002f\u002frefresh view\n  }\n}\n\nfunction valueChanged() {\n\tif (Empty(this.m_nMenuOfUser.Value()) && Empty(this.m_nMenuOfGroup.Value())) {\n    if (this.entitycontainer.iframe.contentWindow && this.entitycontainer.iframe.contentWindow.BlankStatusBySelection)\n    \tthis.entitycontainer.iframe.contentWindow.BlankStatusBySelection();\n    return; \u002f\u002f se non viene selezionato alcun valore nel menù a tendina non si proseguirà con nessun'altra operazione\n  } else {\n    this.lblLoading.Show(); \u002f\u002f viene mostrato a video un messaggio che avvisa il caricamento del file XML contenente le pagine accessibili dall'utente \n                \u002f\u002f selezionato e la relativa operazione di evidenziazione di queste all'interno della sitemap\n    this.splink_current.Link()\n  }\n\t\n}\n\nvar publicElements = [];\n\nfunction splink_public_Response(cMsg){\n  \u002f\u002friempire oggetto public\n  publicElements = JSON.parse(cMsg);\n  this.valueChanged();\n}\nvar _allElements;\nfunction GetAllElements() {\n  if (!_allElements) {\n    if (this.entitycontainer.iframe.contentWindow)\n    \t_allElements=this.entitycontainer.iframe.contentWindow.GetElementsSecured();\n  }\n  return _allElements;\n}\n\nfunction splink_current_Response(cMsg){\n  var allElements = this.GetAllElements();\n  var currentElements = JSON.parse(cMsg);\n  if (allElements) {\n    for (var i=0;i\u003callElements.length;i++) {\n      var entityElement = allElements[i];\n      var hasSecurity=false;\n      publicElements.some(function(el) {\n        if (el.name===entityElement.name && el.obj===entityElement.obj) {\n          hasSecurity = !el.access; \u002f\u002fse utente pubblico ha accesso non ha sicurezze impostate\n          return true;\n        } \n      });\n      var hasAccess=false;\n      currentElements.some(function(el) {\n        if (el.name===entityElement.name && el.obj===entityElement.obj) {\n          hasAccess = el.access;\n          return true;\n        } \n      });\n      if (this.entitycontainer.iframe.contentWindow)\n      \tthis.entitycontainer.iframe.contentWindow.AppendSecurityPadLock(entityElement, hasAccess, hasSecurity,this);\n    }\n    this.lblLoading.Hide();\n    this.entitycontainer.iframe.contentWindow.elementModified=null;\n  }\n}\nthis.lblLoading.Hide();\n\nfunction radioAddRemoveRole_onChange(){\n  this.selectRole.Value(''); \u002f\u002fsvuota il ruolo selezionato\n  if (this.entitycontainer.iframe.contentWindow)\n  \tthis.entitycontainer.iframe.contentWindow.BlankStatusByRole();\n  if ( this.radioAddRemoveRole.Value() == 1) {\n    this.btnaddremoverole.Value(FormatMsg('MSG_ADD_USER_TO_ROLE'));\n  } else {\n    this.btnaddremoverole.Value(FormatMsg('MSG_PULL_USER_FROM_ROLE'));\n  }\n}\n\nfunction btnaddremoverole_Click(){\n  this.splinkeraddremoverole.Link();\n}\n\nfunction splinkeraddremoverole_Executed(result,cError){\n  if (result==\"true\") {\n    this.selectRole.Value(0);\n    if (!Empty(cError)) {\n      alert(cError);\n    }\n  } else {\n\t\tif (!Empty(cError)) {\n      alert(cError);\n    }\n  }\n}\n\nfunction lblSelectEntity_Click(){\n  this.splinkBoName.Link();\n}\nfunction imgSelectEntity_Click(){\n  this.splinkBoName.Link();\n}\nvar _this=this;\nvar oldResizeIframe = window.resizeIframe;\nwindow.resizeIframe=function(framename) {\n  if ( _this.entitycontainer.name_iframe=='entitycontainer' ) {\n  \t_this.entitycontainer.frameresize(0);\n  }\n  if (oldResizeIframe) oldResizeIframe();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"no-radius portlet-white-default","css_code":"[{\"type\":\"default\",\"name\":\"radioUserGroup_ctrl_element\",\"selector\":\"\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"selector\\\":\\\"\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_bottom\\\":\\\"10\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"radioUserGroup_ctrl_element\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:86px; height:49px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"pad_bottom\\\":\\\"10\\\"}\",\"code\":\".radioUserGroup_ctrl_element{padding: 0 0 10px 0;}\\n\"},{\"type\":\"radio\",\"name\":\"myradio div\",\"selector\":\"\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"selector\\\":\\\"\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_bottom\\\":\\\"10\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"myradio div\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:86px; height:51px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"pad_bottom\\\":\\\"10\\\"}\",\"code\":\".myradio div{padding: 0 0 10px 0;}\\n\"},{\"type\":\"radio\",\"name\":\"myradio input\",\"selector\":\"\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"selector\\\":\\\"\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"vertical-align: top;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"myradio input\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:86px; height:51px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"vertical-align: top;\\\"}\",\"code\":\".myradio input{vertical-align: top;}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"border_radius_tl\":\"0\",\"border_radius_tr\":\"0\",\"border_radius_bl\":\"0.5rem\",\"border_radius_br\":\"0.5rem\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"no-radius\",\"selector\":\".no-radius\",\"id\":\"form\"}]","custom":"","description":"Pagina per gestire le sicurezze dei contenuti delle entità","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lblLoading }}{{ @lblSelectSubject }}{{ @radioUserGroup }}{{ @selectUser }}{{ @nameUser }}{{ @imgSelectEntity }}{{ @cpuserslink }}{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @chkDisplayClosed }}{{ @radioAddRemoveRole }}{{ @selectRole }}{{ @nameRole }}{{ @cproleslink }}{{ @btnaddremoverole }}{{ @entitycontainer }}{{ @lblSelectEntity }}\u003c\u002fbody\u003e","grapesCss":"","h":"400","hsl":"","htmlcode":"{{ @lblLoading }} \n{{ @lblSelectSubject }} \n{{ @radioUserGroup }} \n{{ @selectUser }} \n{{ @nameUser }} \n{{ @imgSelectEntity }} \n{{ @cpuserslink }} \n{{ @selectGroup }} \n{{ @nameGroup }} \n{{ @cpgroupslink }} \n{{ @chkDisplayClosed }} \n{{ @radioAddRemoveRole }} \n{{ @selectRole }} \n{{ @nameRole }} \n{{ @cproleslink }} \n{{ @btnaddremoverole }} \n{{ @entitycontainer }} \n{{ @lblSelectEntity }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"Gestione delle sicurezze\",\"layer\":\"\",\"h\":\"400\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Gestione delle sicurezze","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"700","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblLoading","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_LOADING","w":"277","wireframe_props":"align,value,n_col","x":"21","y":"127","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSelectSubject","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_SELECT_SUBJECT","w":"153","wireframe_props":"align,value,n_col","x":"21","y":"43","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"0","name":"m_nMenuOfUser","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"numeric","w":"150","x":"731","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"request","name":"entityname","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"282"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"request","name":"file","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"75"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"0","name":"m_nMenuOfGroup","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"numeric","w":"150","x":"731","y":"121"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"true","name":"view_all","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"logic","w":"150","x":"731","y":"144"},{"anchor":"top-left","calculate":"","class_Css":"radio myradio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"51","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"'G'","layer":"false","layout_steps_values":"{}","name":"radioUserGroup","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"7","spuid":"","tabindex":"1","textlist":"ADMIN_USER,ADMIN_GROUP","type":"Radio","typevar":"character","valuelist":"U,G","visible":"true","w":"113","wireframe_props":"","x":"21","y":"74","zindex":"2","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"24","m_cAction":"function","name":"splinkerupdate","offline":"false","page":"1","parms":"link,usertype=radioUserGroup,code,opensecurity,hadSecurity","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"spadministration_updatesecurity","target":"result","type":"SPLinker","w":"160","x":"-3","y":"434"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"","name":"link","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"305"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"","name":"opensecurity","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"logic","w":"150","x":"731","y":"328"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"","name":"hadSecurity","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"logic","w":"150","x":"731","y":"351"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"","name":"result","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"190"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"no","name":"add_login","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"167"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"21","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"9","name":"selectUser","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"150","wireframe_props":"name","x":"731","y":"29","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameUser","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"122","wireframe_props":"name","x":"136","y":"73","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xf036;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"imgSelectEntity","page":"1","path_type":"","rapp":"","sequence":"16","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"22","wireframe_props":"","x":"21","y":"10","zindex":"1","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"spadministration_zuser","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectUser,nameUser","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"selectUser","linkedUsing":"nameUser","looselylinked":"false","n_criteria":"2","name":"cpuserslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"17","servlet":"spadministration_users","spuid":"","suggest":"false","table":"cpusers","type":"LinkZoom","w":"20","wireframe_props":"","x":"259","y":"73","zindex":"","zone":"","zoomtitle":"CP_USERS"},{"actObjs":"entityname,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"24","included":"false","name":"EventBoName","objsValues":"boname,this.LoadEntity()","page":"1","parmsNames":"boname","sequence":"18","type":"EventReceiver","w":"160","x":"181","y":"488"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"21","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"9","name":"selectGroup","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"150","wireframe_props":"name","x":"731","y":"6","zerofilling":"false","zindex":"6","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameGroup","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"20","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"122","wireframe_props":"name","x":"136","y":"101","zerofilling":"false","zindex":"7","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectGroup,nameGroup","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"selectGroup","linkedUsing":"nameGroup","looselylinked":"false","n_criteria":"2","name":"cpgroupslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"21","servlet":"","spuid":"","suggest":"false","table":"cpgroups","type":"LinkZoom","w":"20","wireframe_props":"","x":"259","y":"101","zindex":"","zone":"","zoomtitle":"CP_GROUPS"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"24","m_cAction":"","name":"splinkereditsecurity","offline":"false","page":"1","parms":"progname","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"true","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp","target":"","type":"SPLinker","w":"160","x":"181","y":"434"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"","name":"progname","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"259"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"24","included":"false","name":"Event_addQuery","objsValues":"this.splink_public.Link()","page":"1","parmsNames":"","sequence":"24","type":"EventReceiver","w":"160","x":"181","y":"461"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"","name":"code","page":"1","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"374"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"24","m_cAction":"","name":"splinkBoName","offline":"false","page":"1","parms":"","popup":"true","popup_height":"400","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"700","progressbar":"","refresh":"","sequence":"26","servlet":"..\u002fjsp-system\u002fgsso_get_bo_name_portlet.jsp","target":"","type":"SPLinker","w":"160","x":"181","y":"407"},{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"32","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"true","label_text":"MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT","layer":"false","layout_steps_values":"{}","name":"chkDisplayClosed","page":"1","rapp":"","sequence":"27","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"331","wireframe_props":"label_text","x":"320","y":"40","zindex":"8","zone":""},{"anchor":"top-left","calculate":"","class_Css":"radio myradio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"61","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"1","layer":"false","layout_steps_values":"{}","name":"radioAddRemoveRole","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"28","spuid":"","tabindex":"","textlist":"MSG_SIMULATE_ADDING_ROLE,MSG_SIMULATE_REMOVING_ROLE","type":"Radio","typevar":"numeric","valuelist":"1,0","visible":"true","w":"206","wireframe_props":"","x":"289","y":"74","zindex":"9","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"21","help_tips":"","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"selectRole","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"29","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"150","wireframe_props":"name","x":"731","y":"52","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameRole","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"30","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"122","wireframe_props":"name","x":"502","y":"73","zerofilling":"false","zindex":"10","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"roleType","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectRole,nameRole","keyfixedfilters":"grptype","layer":"false","layout_steps_values":"{}","linkedField":"selectRole","linkedUsing":"nameRole","looselylinked":"false","n_criteria":"2","name":"cproleslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"31","servlet":"","spuid":"","suggest":"false","table":"cpgroups","type":"LinkZoom","w":"20","wireframe_props":"","x":"628","y":"73","zindex":"","zone":"","zoomtitle":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"'R'","name":"roleType","page":"1","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"213"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"24","m_cAction":"function","name":"checkRole","offline":"false","page":"1","parms":"userCode=selectUser","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"33","servlet":"spadministration_getgrouplist","target":"","type":"SPLinker","w":"160","x":"-3","y":"461"},{"anchor":"top-left-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnaddremoverole","page":"1","rapp":"","sequence":"34","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_ADD_USER_TO_ROLE","w":"41","wireframe_props":"value","x":"656","y":"73","zindex":"14","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"24","m_cAction":"function","name":"splinkeraddremoverole","offline":"false","page":"1","parms":"userCode=selectUser,groupCode=selectRole","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"35","servlet":"spadministration_togglegroupofuser","target":"","type":"SPLinker","w":"160","x":"-3","y":"488"},{"anchor":"","auto_resize":"true","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"242","hide":"false","layer":"false","layout_steps_values":"{}","name":"entitycontainer","page":"1","rapp":"","sequence":"36","spuid":"","type":"Iframe","w":"700","wireframe_props":"","x":"0","y":"158","zindex":"15","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"24","m_cAction":"function","name":"splink_public","offline":"false","page":"1","parms":"m_nMenuOfUser=-2,m_cAction=painter_security,painter_security","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"37","servlet":"","target":"","type":"SPLinker","w":"160","x":"-3","y":"515"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"'painter_security'","name":"painter_security","page":"1","reactive":"","sequence":"38","server_side":"false","type":"Variable","typevar":"character","w":"150","x":"731","y":"236"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"24","m_cAction":"function","name":"splink_current","offline":"false","page":"1","parms":"m_nMenuOfUser,m_nMenuOfGroup,m_cAction=painter_security,painter_security","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"39","servlet":"","target":"","type":"SPLinker","w":"160","x":"-3","y":"407"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSelectEntity","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"40","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_SELECT_RESOURCE_TO_MANAGE","w":"258","wireframe_props":"align,value,n_col","x":"47","y":"12","zindex":"18","zone":""}]%>
<%/*Description:Pagina per gestire le sicurezze dei contenuti delle entità*/%>
<%/*ParamsRequest:entityname,file*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.spadministration_securityentity_container .myradio div{
  padding-bottom: 10px;
}
.spadministration_securityentity_container .myradio input{
  vertical-align: top;
}
.spadministration_securityentity_container .no-radius{
  border-radius: 0px 0px 0.5rem 0.5rem;
}
.spadministration_securityentity_container {
  height:100%;
  overflow:auto;
}
.spadministration_securityentity_portlet{
  position:relative;
  width:100%;
  min-width:700px;
  height:100%;
}
.spadministration_securityentity_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.spadministration_securityentity_portlet > .lblLoading_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:127px;
  left:21px;
  width:277px;
  height:auto;
  min-height:24px;
}
.spadministration_securityentity_portlet > .lblLoading_ctrl {
  height:auto;
  min-height:24px;
}
.spadministration_securityentity_portlet > .lblLoading_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:left;
  background-color:transparent;
}
.spadministration_securityentity_portlet > .lblSelectSubject_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:21px;
  width:153px;
  height:auto;
  min-height:24px;
}
.spadministration_securityentity_portlet > .lblSelectSubject_ctrl {
  height:auto;
  min-height:24px;
}
.spadministration_securityentity_portlet > .lblSelectSubject_ctrl {
  overflow:hidden;
  text-align:left;
}
.spadministration_securityentity_portlet > .radioUserGroup_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:74px;
  left:21px;
  width:113px;
  height:51px;
  height:auto;
  min-height:51px;
}
.spadministration_securityentity_portlet > .selectUser_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:29px;
  left:731px;
  width:150px;
  height:21px;
}
.spadministration_securityentity_portlet > .selectUser_ctrl {
  display:none;
}
.spadministration_securityentity_portlet > .selectUser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.spadministration_securityentity_portlet > .nameUser_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:73px;
  left:136px;
  width:122px;
  height:20px;
}
.spadministration_securityentity_portlet > .nameUser_ctrl {
}
.spadministration_securityentity_portlet > .nameUser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securityentity_portlet > .imgSelectEntity_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:21px;
  width:22px;
  height:22px;
}
.spadministration_securityentity_portlet > .imgSelectEntity_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:22px;
  font-size:22px;
}
.spadministration_securityentity_portlet > .cpuserslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  left:259px;
  width:20px;
  height:20px;
}
.spadministration_securityentity_portlet > .selectGroup_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:6px;
  left:731px;
  width:150px;
  height:21px;
}
.spadministration_securityentity_portlet > .selectGroup_ctrl {
  display:none;
}
.spadministration_securityentity_portlet > .selectGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.spadministration_securityentity_portlet > .nameGroup_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:101px;
  left:136px;
  width:122px;
  height:20px;
}
.spadministration_securityentity_portlet > .nameGroup_ctrl {
}
.spadministration_securityentity_portlet > .nameGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securityentity_portlet > .cpgroupslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:101px;
  left:259px;
  width:20px;
  height:20px;
}
.spadministration_securityentity_portlet > .chkDisplayClosed_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:40px;
  right:49px;
  width:331px;
  height:32px;
}
.spadministration_securityentity_portlet > .radioAddRemoveRole_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:74px;
  left:289px;
  width:206px;
  height:61px;
  height:auto;
  min-height:61px;
}
.spadministration_securityentity_portlet > .selectRole_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:52px;
  left:731px;
  width:150px;
  height:21px;
}
.spadministration_securityentity_portlet > .selectRole_ctrl {
  display:none;
}
.spadministration_securityentity_portlet > .selectRole_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securityentity_portlet > .nameRole_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:73px;
  left:502px;
  width:122px;
  height:20px;
}
.spadministration_securityentity_portlet > .nameRole_ctrl {
}
.spadministration_securityentity_portlet > .nameRole_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securityentity_portlet > .cproleslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:73px;
  left:628px;
  width:20px;
  height:20px;
}
.spadministration_securityentity_portlet > .btnaddremoverole_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:73px;
  left:656px;
  right:3px;
  right:0.42857143%;
  width:auto;
  height:20px;
}
.spadministration_securityentity_portlet > .btnaddremoverole_ctrl {
}
.spadministration_securityentity_portlet > .entitycontainer_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:158px;
  left:0px;
  width:700px;
  height:242px;
}
.spadministration_securityentity_portlet > .lblSelectEntity_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:12px;
  left:47px;
  width:258px;
  height:auto;
}
.spadministration_securityentity_portlet > .lblSelectEntity_ctrl a {
  height:auto;
}
.spadministration_securityentity_portlet > .lblSelectEntity_ctrl a {
  overflow:hidden;
  text-align:left;
 display:block;
}
.spadministration_securityentity_portlet > .lblSelectEntity_ctrl > div > a:hover{
  text-align:left;
}
.spadministration_securityentity_container .radioUserGroup_ctrl_element{  padding-bottom: 10px;
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"Gestione delle sicurezze\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"700\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_LOADING\",\"w\":\"277\",\"x\":\"21\",\"y\":\"127\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_SELECT_SUBJECT\",\"w\":\"153\",\"x\":\"21\",\"y\":\"43\",\"zindex\":\"1\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"98\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"282\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"75\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"121\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"144\"},{\"anchor\":\"top-left\",\"h\":\"51\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Radio\",\"w\":\"113\",\"x\":\"21\",\"y\":\"74\",\"zindex\":\"2\"},{\"h\":\"24\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"-3\",\"y\":\"434\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"305\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"328\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"351\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"190\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"167\"},{\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"name\":\"selectUser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"731\",\"y\":\"29\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameUser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"122\",\"x\":\"136\",\"y\":\"73\",\"zindex\":\"5\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"imgSelectEntity\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"22\",\"x\":\"21\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cpuserslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"259\",\"y\":\"73\",\"zindex\":\"\"},{\"h\":\"24\",\"name\":\"EventBoName\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"160\",\"x\":\"181\",\"y\":\"488\"},{\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"name\":\"selectGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"731\",\"y\":\"6\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"122\",\"x\":\"136\",\"y\":\"101\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cpgroupslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"259\",\"y\":\"101\",\"zindex\":\"\"},{\"h\":\"24\",\"name\":\"splinkereditsecurity\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"181\",\"y\":\"434\"},{\"h\":\"21\",\"name\":\"progname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"259\"},{\"h\":\"24\",\"name\":\"Event_addQuery\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"160\",\"x\":\"181\",\"y\":\"461\"},{\"h\":\"21\",\"name\":\"code\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"374\"},{\"h\":\"24\",\"name\":\"splinkBoName\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"181\",\"y\":\"407\"},{\"anchor\":\"top-right\",\"h\":\"32\",\"label_text\":\"MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT\",\"layout_steps_values\":{},\"name\":\"chkDisplayClosed\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"331\",\"x\":\"320\",\"y\":\"40\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"61\",\"layout_steps_values\":{},\"name\":\"radioAddRemoveRole\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"206\",\"x\":\"289\",\"y\":\"74\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"name\":\"selectRole\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"731\",\"y\":\"52\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameRole\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"122\",\"x\":\"502\",\"y\":\"73\",\"zindex\":\"10\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cproleslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"628\",\"y\":\"73\",\"zindex\":\"\"},{\"h\":\"21\",\"name\":\"roleType\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"213\"},{\"h\":\"24\",\"name\":\"checkRole\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"-3\",\"y\":\"461\"},{\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"btnaddremoverole\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_ADD_USER_TO_ROLE\",\"w\":\"41\",\"x\":\"656\",\"y\":\"73\",\"zindex\":\"14\"},{\"h\":\"24\",\"name\":\"splinkeraddremoverole\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"-3\",\"y\":\"488\"},{\"anchor\":\"\",\"h\":\"242\",\"layout_steps_values\":{},\"name\":\"entitycontainer\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"700\",\"x\":\"0\",\"y\":\"158\",\"zindex\":\"15\"},{\"h\":\"24\",\"name\":\"splink_public\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"-3\",\"y\":\"515\"},{\"h\":\"21\",\"name\":\"painter_security\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"150\",\"x\":\"731\",\"y\":\"236\"},{\"h\":\"24\",\"name\":\"splink_current\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"-3\",\"y\":\"407\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblSelectEntity\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_SELECT_RESOURCE_TO_MANAGE\",\"w\":\"258\",\"x\":\"47\",\"y\":\"12\",\"zindex\":\"18\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_securityentity","UTF-8")) {return; }
 %><%if(!sp.isAdministrator() && sp.hasAdministeredUsers()){%>
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_securityentity_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("spadministration_help.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_securityentity','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblLoading= "MSG_LOADING";
String lblSelectSubject= "MSG_SELECT_SUBJECT";
double m_nMenuOfUser=0;
String entityname=JSPLib.translateXSS(sp.getParameter("entityname",""));
String file=JSPLib.translateXSS(sp.getParameter("file",""));
double m_nMenuOfGroup=0;
boolean view_all=true;
String radioUserGroup="G";
String link= "";
boolean opensecurity= false;
boolean hadSecurity= false;
String result= "";
String add_login="no";
double selectUser= 0;
if(request.getAttribute("spadministration_securityentity_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String nameUser= "";
if(request.getAttribute("spadministration_securityentity_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
double selectGroup= 0;
String nameGroup= "";
String progname= "";
String code= "";
boolean chkDisplayClosed=true;
double radioAddRemoveRole=1;
double selectRole= 0;
String nameRole= "";
String roleType="R";
String painter_security="painter_security";
String lblSelectEntity= "MSG_SELECT_RESOURCE_TO_MANAGE";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_securityentity_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_securityentity_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_securityentity_portlet no-radius portlet-white-default' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_securityentity','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblLoading'  formid='<%=idPortlet%>' ps-name='lblLoading'    class='label lblLoading_ctrl'><div id='<%=idPortlet%>_lblLoadingtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_LOADING"))%></div></span>
<span id='<%=idPortlet%>_lblSelectSubject'  formid='<%=idPortlet%>' ps-name='lblSelectSubject'    class='label lblSelectSubject_ctrl'><div id='<%=idPortlet%>_lblSelectSubjecttbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_SELECT_SUBJECT"))%></div></span>
<div id='<%=idPortlet%>_radioUserGroup' class='radio myradio' style='z-index:1;'></div>
<span class='textbox-container'id='<%=idPortlet%>_selectUser_wrp'><input id='<%=idPortlet%>_selectUser' name='selectUser' type='text' maxlength='9' class='textbox' formid='<%=idPortlet%>' ps-name='selectUser' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameUser_wrp'><input id='<%=idPortlet%>_nameUser' name='nameUser' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameUser' /></span>
<a id='<%=idPortlet%>_imgSelectEntity' class='image imgSelectEntity_ctrl'  href='javascript:void(0)' target='_self'>&#xf036;</a>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cpuserslink'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_selectGroup_wrp'><input id='<%=idPortlet%>_selectGroup' name='selectGroup' type='text' maxlength='9' class='textbox' formid='<%=idPortlet%>' ps-name='selectGroup' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameGroup_wrp'><input id='<%=idPortlet%>_nameGroup' name='nameGroup' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameGroup' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cpgroupslink'" ) );%>
<div id='<%=idPortlet%>_chkDisplayClosed_div' style=''><input id='<%=idPortlet%>_chkDisplayClosed' name='chkDisplayClosed' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkDisplayClosed' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(sp.translate("MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT"))%></label></div>
<div id='<%=idPortlet%>_radioAddRemoveRole' class='radio myradio' style='z-index:1;'></div>
<span class='textbox-container'id='<%=idPortlet%>_selectRole_wrp'><input id='<%=idPortlet%>_selectRole' name='selectRole' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='selectRole' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameRole_wrp'><input id='<%=idPortlet%>_nameRole' name='nameRole' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameRole' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cproleslink'" ) );%>
<input id='<%=idPortlet%>_btnaddremoverole' type='button' class='button btnaddremoverole_ctrl'/>
<div id='<%=idPortlet%>_entitycontainer_DIV'>&nbsp;</div>
<span id='<%=idPortlet%>_lblSelectEntity'  formid='<%=idPortlet%>' ps-name='lblSelectEntity'    class='label lblSelectEntity_ctrl'><div id='<%=idPortlet%>_lblSelectEntitytbl' style='width:100%;'><a id='<%=idPortlet%>_lblSelectEntityhref' title='<%=JSPLib.ToHTML(sp.translate("MSG_SELECT_RESOURCE_TO_MANAGE"))%>' href='javascript:void(0)'  ><%=JSPLib.ToHTML(sp.translate("MSG_SELECT_RESOURCE_TO_MANAGE"))%></a></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_securityentity');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ACC_NOT_ALLOWED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ACC_NOT_ALLOWED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ADD_USER_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ADD_USER_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_BACK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_BACK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PULL_USER_FROM_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PULL_USER_FROM_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_RESOURCE_SAFETY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_RESOURCE_SAFETY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SELECT_RESOURCE_TO_MANAGE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SELECT_RESOURCE_TO_MANAGE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_USER_BELONGS_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_USER_BELONGS_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_USER_NOT_BELONGS_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_USER_NOT_BELONGS_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_securityentity',["700"],["400"],'no-radius portlet-white-default',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"700","h":"400","title":"Gestione delle sicurezze","layer":""}]);
this.lblLoading=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblLoading","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblLoading","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblLoading),false,true)%>","type":"Label","w":277,"x":21,"y":127,"zindex":"1"});
this.lblSelectSubject=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSelectSubject","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSelectSubject","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblSelectSubject),false,true)%>","type":"Label","w":153,"x":21,"y":43,"zindex":"1"});
this.m_nMenuOfUser=new ZtVWeb._VC(this,'m_nMenuOfUser',null,'numeric',<%=m_nMenuOfUser%>,false,false);
this.entityname=new ZtVWeb._VC(this,'entityname',null,'character','<%=JSPLib.ToJSValue(entityname,false,true)%>',false,false);
this.file=new ZtVWeb._VC(this,'file',null,'character','<%=JSPLib.ToJSValue(file,false,true)%>',false,false);
this.m_nMenuOfGroup=new ZtVWeb._VC(this,'m_nMenuOfGroup',null,'numeric',<%=m_nMenuOfGroup%>,false,false);
this.view_all=new ZtVWeb._VC(this,'view_all',null,'logic',<%=view_all%>,false,false);
this.radioUserGroup=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"","captionsList":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_USER"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP"),false,true)%>","class_Css":"radio myradio","create_undercond":"","ctrlid":"<%=idPortlet%>_radioUserGroup","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":51,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"'G'","layer":false,"layout_steps_values":{},"name":"radioUserGroup","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"1","type":"Radio","typevar":"character","valuesList":"U,G","visible":true,"w":113,"x":21,"y":74,"zindex":"2"});
this.radioUserGroup.Value('<%=JSPLib.ToJSValue(radioUserGroup,false,true)%>');
this.splinkerupdate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkerupdate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkerupdate","offline":false,"page":1,"parms":"link,usertype=radioUserGroup,code,opensecurity,hadSecurity","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_updatesecurity","target":"result","type":"SPLinker","w":160,"x":-3,"y":434});
this.splinkerupdate.m_cID='<%=JSPLib.cmdHash("routine,spadministration_updatesecurity",request.getSession())%>';
this.link=new ZtVWeb._VC(this,'link',null,'character','<%=JSPLib.ToJSValue(link,false,true)%>',false,false);
this.opensecurity=new ZtVWeb._VC(this,'opensecurity',null,'logic',<%=opensecurity%>,false,false);
this.hadSecurity=new ZtVWeb._VC(this,'hadSecurity',null,'logic',<%=hadSecurity%>,false,false);
this.result=new ZtVWeb._VC(this,'result',null,'character','<%=JSPLib.ToJSValue(result,false,true)%>',false,false);
this.add_login=new ZtVWeb._VC(this,'add_login',null,'character','<%=JSPLib.ToJSValue(add_login,false,true)%>',false,false);
this.selectUser=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectUser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":21,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"9","name":"selectUser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectUser%>","w":150,"x":731,"y":29,"zerofilling":false,"zindex":"3","zoom":""});
this.nameUser=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameUser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameUser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameUser,false,true)%>","w":122,"x":136,"y":73,"zerofilling":false,"zindex":"5","zoom":""});
this.imgSelectEntity=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image imgSelectEntity_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgSelectEntity","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf036;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imgSelectEntity","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xf036;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":22,"x":21,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("icons8_win10","");
this.cpuserslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"spadministration_zuser","ctrlid":"<%=idPortlet%>_cpuserslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_securityentity_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"selectUser,nameUser","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_securityentity_portlet.jspcpuserslink",request.getSession())%>","linkedField":"selectUser","linkedUsing":"nameUser","looselylinked":false,"n_criteria":"2","name":"cpuserslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"spadministration_users","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpusers,spadministration_zuser",request.getSession())%>","suggest":false,"table":"cpusers","type":"LinkZoom","w":20,"x":259,"y":73,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_USERS"),false,true)%>"});
this.EventBoName=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"entityname,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_EventBoName","h":24,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"EventBoName","objsValues":"boname,this.LoadEntity()","page":1,"parmsNames":"boname","type":"EventReceiver","w":160,"x":181,"y":488});
this.selectGroup=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":21,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"9","name":"selectGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectGroup%>","w":150,"x":731,"y":6,"zerofilling":false,"zindex":"6","zoom":""});
this.nameGroup=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameGroup,false,true)%>","w":122,"x":136,"y":101,"zerofilling":false,"zindex":"7","zoom":""});
this.cpgroupslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_cpgroupslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_securityentity_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"selectGroup,nameGroup","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_securityentity_portlet.jspcpgroupslink",request.getSession())%>","linkedField":"selectGroup","linkedUsing":"nameGroup","looselylinked":false,"n_criteria":"2","name":"cpgroupslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":false,"table":"cpgroups","type":"LinkZoom","w":20,"x":259,"y":101,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>"});
this.splinkereditsecurity=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkereditsecurity","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkereditsecurity","offline":false,"page":1,"parms":"progname","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"true","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp","target":"","type":"SPLinker","w":160,"x":181,"y":434});
this.splinkereditsecurity.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spproceduresecurity_portlet.jsp",request.getSession())%>';
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
this.Event_addQuery=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_addQuery","h":24,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_addQuery","objsValues":"this.splink_public.Link()","page":1,"parmsNames":"","type":"EventReceiver","w":160,"x":181,"y":461});
this.code=new ZtVWeb._VC(this,'code',null,'character','<%=JSPLib.ToJSValue(code,false,true)%>',false,false);
this.splinkBoName=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkBoName","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkBoName","offline":false,"page":1,"parms":"","popup":"true","popup_height":"400","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"700","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fgsso_get_bo_name_portlet.jsp","target":"","type":"SPLinker","w":160,"x":181,"y":407});
this.splinkBoName.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/gsso_get_bo_name_portlet.jsp",request.getSession())%>';
this.chkDisplayClosed=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkDisplayClosed","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":32,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"true","label_text":"MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT","layer":false,"layout_steps_values":{},"name":"chkDisplayClosed","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":331,"x":320,"y":40,"zindex":"8"});
this.chkDisplayClosed.Value(<%=chkDisplayClosed%>);
this.radioAddRemoveRole=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"","captionsList":"<%=JSPLib.ToJSValue(sp.translate("MSG_SIMULATE_ADDING_ROLE"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("MSG_SIMULATE_REMOVING_ROLE"),false,true)%>","class_Css":"radio myradio","create_undercond":"","ctrlid":"<%=idPortlet%>_radioAddRemoveRole","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":61,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"1","layer":false,"layout_steps_values":{},"name":"radioAddRemoveRole","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"numeric","valuesList":"1,0","visible":true,"w":206,"x":289,"y":74,"zindex":"9"});
this.radioAddRemoveRole.Value(<%=radioAddRemoveRole%>);
this.selectRole=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectRole","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":21,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"selectRole","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectRole%>","w":150,"x":731,"y":52,"zerofilling":false,"zindex":"12","zoom":""});
this.nameRole=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameRole","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameRole","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameRole,false,true)%>","w":122,"x":502,"y":73,"zerofilling":false,"zindex":"10","zoom":""});
this.cproleslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_cproleslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_securityentity_portlet.jsp","fillemptykeys":false,"fixedvars":"roleType","h":20,"hide":"false","image":"","intovars":"selectRole,nameRole","intovarsType":"N,C","keyfixedfilters":"grptype","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_securityentity_portlet.jspcproleslink",request.getSession())%>","linkedField":"selectRole","linkedUsing":"nameRole","looselylinked":false,"n_criteria":"2","name":"cproleslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":false,"table":"cpgroups","type":"LinkZoom","w":20,"x":628,"y":73,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.roleType=new ZtVWeb._VC(this,'roleType',null,'character','<%=JSPLib.ToJSValue(roleType,false,true)%>',false,false);
this.checkRole=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_checkRole","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"checkRole","offline":false,"page":1,"parms":"userCode=selectUser","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_getgrouplist","target":"","type":"SPLinker","w":160,"x":-3,"y":461});
this.checkRole.m_cID='<%=JSPLib.cmdHash("routine,spadministration_getgrouplist",request.getSession())%>';
this.btnaddremoverole=new ZtVWeb._BC(this,{"anchor":"top-left-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnaddremoverole_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnaddremoverole","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnaddremoverole","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_ADD_USER_TO_ROLE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":41,"x":656,"y":73,"zindex":"14"});
this.splinkeraddremoverole=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkeraddremoverole","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkeraddremoverole","offline":false,"page":1,"parms":"userCode=selectUser,groupCode=selectRole","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_togglegroupofuser","target":"","type":"SPLinker","w":160,"x":-3,"y":488});
this.splinkeraddremoverole.m_cID='<%=JSPLib.cmdHash("routine,spadministration_togglegroupofuser",request.getSession())%>';
this.entitycontainer=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"true","border":"","ctrlid":"<%=idPortlet%>_entitycontainer","default_portlet":"","h":242,"hide":"false","layer":false,"layout_steps_values":{},"name":"entitycontainer","name_iframe":"entitycontainer","page":1,"spuid":"","type":"Iframe","w":700,"x":0,"y":158,"zindex":"15"});
this.splink_public=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splink_public","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splink_public","offline":false,"page":1,"parms":"m_nMenuOfUser=-2,m_cAction=painter_security,painter_security","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":160,"x":-3,"y":515});
this.splink_public.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.painter_security=new ZtVWeb._VC(this,'painter_security',null,'character','<%=JSPLib.ToJSValue(painter_security,false,true)%>',false,false);
this.splink_current=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splink_current","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splink_current","offline":false,"page":1,"parms":"m_nMenuOfUser,m_nMenuOfGroup,m_cAction=painter_security,painter_security","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":160,"x":-3,"y":407});
this.splink_current.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.lblSelectEntity=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSelectEntity","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSelectEntity","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblSelectEntity),false,true)%>","type":"Label","w":258,"x":47,"y":12,"zindex":"18"});
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
<%request.setAttribute("spadministration_securityentity_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_securityentity_Static=function(){
if(typeof chkDisplayClosed_onChange !='undefined')this.chkDisplayClosed_onChange=chkDisplayClosed_onChange;
if(typeof cpgroupslink_GetZoomLink !='undefined')this.cpgroupslink_GetZoomLink=cpgroupslink_GetZoomLink;
if(typeof cproleslink_GetZoomLink !='undefined')this.cproleslink_GetZoomLink=cproleslink_GetZoomLink;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LoadEntity !='undefined')this.LoadEntity=LoadEntity;
if(typeof entitycontainer_Loaded !='undefined')this.entitycontainer_Loaded=entitycontainer_Loaded;
if(typeof radioUserGroup_onChange !='undefined')this.radioUserGroup_onChange=radioUserGroup_onChange;
if(typeof selectUser_onChange !='undefined')this.selectUser_onChange=selectUser_onChange;
if(typeof cpgroupslink_LinkBlanked !='undefined')this.cpgroupslink_LinkBlanked=cpgroupslink_LinkBlanked;
if(typeof cpuserslink_LinkBlanked !='undefined')this.cpuserslink_LinkBlanked=cpuserslink_LinkBlanked;
if(typeof cpgroupslink_LinkExecuted !='undefined')this.cpgroupslink_LinkExecuted=cpgroupslink_LinkExecuted;
if(typeof cpuserslink_LinkExecuted !='undefined')this.cpuserslink_LinkExecuted=cpuserslink_LinkExecuted;
if(typeof cproleslink_LinkExecuted !='undefined')this.cproleslink_LinkExecuted=cproleslink_LinkExecuted;
if(typeof cproleslink_LinkBlanked !='undefined')this.cproleslink_LinkBlanked=cproleslink_LinkBlanked;
if(typeof splinkerupdate_Error !='undefined')this.splinkerupdate_Error=splinkerupdate_Error;
if(typeof splinkerupdate_Result !='undefined')this.splinkerupdate_Result=splinkerupdate_Result;
if(typeof valueChanged !='undefined')this.valueChanged=valueChanged;
if(typeof splink_public_Response !='undefined')this.splink_public_Response=splink_public_Response;
if(typeof GetAllElements !='undefined')this.GetAllElements=GetAllElements;
if(typeof splink_current_Response !='undefined')this.splink_current_Response=splink_current_Response;
if(typeof radioAddRemoveRole_onChange !='undefined')this.radioAddRemoveRole_onChange=radioAddRemoveRole_onChange;
if(typeof btnaddremoverole_Click !='undefined')this.btnaddremoverole_Click=btnaddremoverole_Click;
if(typeof splinkeraddremoverole_Executed !='undefined')this.splinkeraddremoverole_Executed=splinkeraddremoverole_Executed;
if(typeof lblSelectEntity_Click !='undefined')this.lblSelectEntity_Click=lblSelectEntity_Click;
if(typeof imgSelectEntity_Click !='undefined')this.imgSelectEntity_Click=imgSelectEntity_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.selectUser);
ZtVWeb.HideCtrl(true,this.selectGroup);
ZtVWeb.HideCtrl(true,this.selectRole);
}
this.cpuserslink.addObserverFixedVars();
this.cpuserslink.addLinkedUsingVars();
this.cpgroupslink.addObserverFixedVars();
this.cpgroupslink.addLinkedUsingVars();
this.cproleslink.addObserverFixedVars();
this.cproleslink.addLinkedUsingVars();
var elementModified = null;
m_cProgName='spsecurityentity';
m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
function chkDisplayClosed_onChange(){
  if (this.entitycontainer.iframe.contentWindow)
  	this.entitycontainer.iframe.contentWindow.ShowDisabledItems(this.chkDisplayClosed.Value());
}
function cpgroupslink_GetZoomLink(offline) {
  return ZtVWeb.SPWebRootURL+'/jsp-system/spadministration_groups_zoom_portlet.jsp?';
}
function cproleslink_GetZoomLink(offline) {
  return ZtVWeb.SPWebRootURL+'/jsp-system/spadministration_groups_zoom_portlet.jsp?grptype='+URLenc(this.roleType.Value())+'&'
    		+(this.radioAddRemoveRole.Value()==1  ?'disableGroupsOf=' : 'enableGroupsOf=')+URLenc(this.selectUser.Value())+'&';//sostituisce il FixedFilter  
}
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  if(m_cTarget != "_blank") {
    customToolbar.AppendButton({
      image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
      action:'../servlet/SPControlPanel',
      title:FormatMsg("MSG_BACK"),
      tooltip:FormatMsg("ADMIN_BACK_TO_CP")
    })
  }
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
    action:'javascript:Help()',
    title:FormatMsg("ADMIN_HELP_TITLE"),
    tooltip:FormatMsg("ADMIN_HELP_TITLE")
  })
  if (this.entityname.Value()) {
    this.lblSelectEntity.Hide();
    this.imgSelectEntity.Hide();
    this.LoadEntity()
  } else {
    customToolbar.SetTitle(FormatMsg('MSG_RESOURCE_SAFETY','<'+FormatMsg('MSG_SELECT_RESOURCE_TO_MANAGE')+'>'),true);
    customToolbar.RearrangeAll(); //LoadEntity chiama questo metodo sempre
    this.radioUserGroup_onChange();
    this.radioUserGroup.Disabled();
    this.chkDisplayClosed.Disabled();
    this.nameGroup.Disabled();
    this.cpgroupslink.Disabled();
  }
}
function LoadEntity() {
  _allElements=null;//resetto l'oggetto con gli elementi dell'entita'
  var customToolbar=this.getTitlePortlet();
  customToolbar.SetTitle(FormatMsg('MSG_RESOURCE_SAFETY',this.entityname.Value()),true);
  customToolbar.RearrangeAll();
  this.radioUserGroup.Enabled();
  this.chkDisplayClosed.Enabled();
  this.nameGroup.Enabled();
  this.cpgroupslink.Enabled();
  this.selectUser.Value(0);
  this.selectGroup.Value(0);
  this.splink_current.Servlet(this.entityname.Value());
  this.splink_public.Servlet(this.entityname.Value());
  this.entitycontainer.Load('../servlet/'+this.entityname.Value()+'?m_cAction=painter');
}
function entitycontainer_Loaded(){
  if (this.entitycontainer.iframe.src!='javascript:[].join()') {
    if (this.entitycontainer.iframe.contentWindow && this.entitycontainer.iframe.contentWindow.InitializeEdits) {
      //se non trovo la funzione c'e' stato un errore e segnalo un errore generico
      this.entitycontainer.iframe.contentWindow.InitializeEdits(this);
      this.radioUserGroup_onChange();
      this.splink_public.Link();
    } else {
      alert(FormatMsg('MSG_ACC_NOT_ALLOWED'));
      this.entityname.Value('');
      this.radioUserGroup_onChange();
      this.radioUserGroup.Disabled();
      this.chkDisplayClosed.Disabled();
      this.nameGroup.Disabled();
      this.cpgroupslink.Disabled();
    }
  }
}
function radioUserGroup_onChange(){
  if (this.radioUserGroup.Value()=='U') {
    this.m_nMenuOfGroup.Value(0);
    this.cpgroupslink.Hide();
    this.nameGroup.Hide();
    this.nameGroup.Value('');
		this.cpuserslink.Show();
    this.nameUser.Show();
  } else {
    this.m_nMenuOfUser.Value(0);
    this.cpuserslink.Hide();
    this.nameUser.Hide();
    this.nameUser.Value('');
    this.cpgroupslink.Show();
    this.nameGroup.Show();
		this.nameRole.Hide();
    this.radioAddRemoveRole.Hide();
    this.cproleslink.Hide();
    this.btnaddremoverole.Hide();
  }
  if (this.entitycontainer.iframe.contentWindow && this.entitycontainer.iframe.contentWindow.BlankStatusBySelection)
  	this.entitycontainer.iframe.contentWindow.BlankStatusBySelection();
}
function selectUser_onChange(){
  this.selectRole.Value(0);
  if (Empty(this.selectUser.Value())) {
		this.nameRole.Hide();
    this.radioAddRemoveRole.Hide();
    this.cproleslink.Hide();
  } else {
    this.nameRole.Show();
    this.radioAddRemoveRole.Show();
    this.cproleslink.Show();
  }
}
function cpgroupslink_LinkBlanked(){
  this.m_nMenuOfGroup.Value( '' );
  this.valueChanged();
}
function cpuserslink_LinkBlanked(){
  this.entitycontainer.iframe.contentWindow.BlankStatusByRole();
  this.m_nMenuOfUser.Value( '' );
  this.valueChanged();
}
function cpgroupslink_LinkExecuted(){
  this.m_nMenuOfGroup.Value( this.selectGroup.Value() );
  this.m_nMenuOfUser.Value( '' );
  this.valueChanged();
}
function cpuserslink_LinkExecuted(){
  this.m_nMenuOfUser.Value( this.selectUser.Value() );
  this.m_nMenuOfGroup.Value( '' );
  this.valueChanged();
}
function cproleslink_LinkExecuted(){
	var refresh = true;
  if (!Empty(this.selectRole.Value())) {
    var groups = this.checkRole.Link();
    groups = groups.trim().split(/ *, */);
    if ((this.radioAddRemoveRole.Value()==1 ? Ne : Eq ) (groups.indexOf(Str(this.selectRole.Value(),9).trim()), -1 ) ) {
      this.selectRole.Value(0);
      if (this.radioAddRemoveRole.Value()==1)
      	alert(FormatMsg('MSG_USER_BELONGS_TO_ROLE'));
     	else
        alert(FormatMsg('MSG_USER_NOT_BELONGS_TO_ROLE'));
      refresh=false;
    }
  } 
	if ( refresh ) {
    this.entitycontainer.iframe.contentWindow.BlankStatusByRole();
  	this.m_nMenuOfGroup.Value( this.selectRole.Value() );
  	this.valueChanged();
  	this.btnaddremoverole.Show();
  }
}
function cproleslink_LinkBlanked(){
  this.m_nMenuOfGroup.Value( '' );
  this.valueChanged();
  this.btnaddremoverole.Hide();
}
function splinkerupdate_Error(cCause){
  if (this.entitycontainer.iframe.contentWindow)
  	this.entitycontainer.iframe.contentWindow.elementModified = null; //in caso di errore devo resettare l'elemento appena modificato
  alert(cCause);
}
function splinkerupdate_Result(result){
  if (result==='true') {
    this.splink_public.Link(); //refresh view
  }
}
function valueChanged() {
	if (Empty(this.m_nMenuOfUser.Value()) && Empty(this.m_nMenuOfGroup.Value())) {
    if (this.entitycontainer.iframe.contentWindow && this.entitycontainer.iframe.contentWindow.BlankStatusBySelection)
    	this.entitycontainer.iframe.contentWindow.BlankStatusBySelection();
    return; // se non viene selezionato alcun valore nel menù a tendina non si proseguirà con nessun'altra operazione
  } else {
    this.lblLoading.Show(); // viene mostrato a video un messaggio che avvisa il caricamento del file XML contenente le pagine accessibili dall'utente 
                // selezionato e la relativa operazione di evidenziazione di queste all'interno della sitemap
    this.splink_current.Link()
  }
	
}
var publicElements = [];
function splink_public_Response(cMsg){
  //riempire oggetto public
  publicElements = JSON.parse(cMsg);
  this.valueChanged();
}
var _allElements;
function GetAllElements() {
  if (!_allElements) {
    if (this.entitycontainer.iframe.contentWindow)
    	_allElements=this.entitycontainer.iframe.contentWindow.GetElementsSecured();
  }
  return _allElements;
}
function splink_current_Response(cMsg){
  var allElements = this.GetAllElements();
  var currentElements = JSON.parse(cMsg);
  if (allElements) {
    for (var i=0;i<allElements.length;i++) {
      var entityElement = allElements[i];
      var hasSecurity=false;
      publicElements.some(function(el) {
        if (el.name===entityElement.name && el.obj===entityElement.obj) {
          hasSecurity = !el.access; //se utente pubblico ha accesso non ha sicurezze impostate
          return true;
        } 
      });
      var hasAccess=false;
      currentElements.some(function(el) {
        if (el.name===entityElement.name && el.obj===entityElement.obj) {
          hasAccess = el.access;
          return true;
        } 
      });
      if (this.entitycontainer.iframe.contentWindow)
      	this.entitycontainer.iframe.contentWindow.AppendSecurityPadLock(entityElement, hasAccess, hasSecurity,this);
    }
    this.lblLoading.Hide();
    this.entitycontainer.iframe.contentWindow.elementModified=null;
  }
}
this.lblLoading.Hide();
function radioAddRemoveRole_onChange(){
  this.selectRole.Value(''); //svuota il ruolo selezionato
  if (this.entitycontainer.iframe.contentWindow)
  	this.entitycontainer.iframe.contentWindow.BlankStatusByRole();
  if ( this.radioAddRemoveRole.Value() == 1) {
    this.btnaddremoverole.Value(FormatMsg('MSG_ADD_USER_TO_ROLE'));
  } else {
    this.btnaddremoverole.Value(FormatMsg('MSG_PULL_USER_FROM_ROLE'));
  }
}
function btnaddremoverole_Click(){
  this.splinkeraddremoverole.Link();
}
function splinkeraddremoverole_Executed(result,cError){
  if (result=="true") {
    this.selectRole.Value(0);
    if (!Empty(cError)) {
      alert(cError);
    }
  } else {
		if (!Empty(cError)) {
      alert(cError);
    }
  }
}
function lblSelectEntity_Click(){
  this.splinkBoName.Link();
}
function imgSelectEntity_Click(){
  this.splinkBoName.Link();
}
var _this=this;
var oldResizeIframe = window.resizeIframe;
window.resizeIframe=function(framename) {
  if ( _this.entitycontainer.name_iframe=='entitycontainer' ) {
  	_this.entitycontainer.frameresize(0);
  }
  if (oldResizeIframe) oldResizeIframe();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_securityentity_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.imgSelectEntity.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_EventBoName=function(parmsObj){<%=idPortlet%>.EventBoName.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_Event_addQuery=function(parmsObj){<%=idPortlet%>.Event_addQuery.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_securityentity',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_securityentity');
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
sp.endPage("spadministration_securityentity");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"cpuserslink")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpusers";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "spadministration_users";
  result.m_rdField = new String[]{"code", "name"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"cpgroupslink")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpgroups";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"code", "name"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"cproleslink")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "cpgroups";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"code", "name"};
  result.m_rdTypes = new String[]{"N", "C"};
  result.m_kField = new String[]{"grptype"};
  result.m_kTypes = new String[]{"C"};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3055092862"; } %>