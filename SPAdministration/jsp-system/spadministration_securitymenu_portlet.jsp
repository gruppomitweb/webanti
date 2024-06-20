<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"m_cProgName='spsecuritymenu';\nm_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\n\nfunction chkDisplayClosed_onChange(){\n  var containers = this.MenuView.ctrl.querySelectorAll('div.menuview_container, li.menuview_sub_open, li.menuview_sub_close');\n  if (this.chkDisplayClosed.Value() ) {\n    LibJavascript.CssClassNameUtils.removeClass(this.MenuView.ctrl,'hide_element_closed');\n    [].forEach.call(containers, function(el) {\n      if (! el.querySelector('.security_element_opened, .security_element_initialize')) {\n        el.style.display = '';\n      }\n    }); \n\n  } else {\n    LibJavascript.CssClassNameUtils.addClass(this.MenuView.ctrl,'hide_element_closed');\n    [].forEach.call(containers, function(el) {\n      if (! el.querySelector('.security_element_opened, .security_element_initialize')) {\n        el.style.display = 'none';\n      }\n    }); \n  }\n}\n\nfunction cpgroupslink_GetZoomLink(offline) {\n  return ZtVWeb.SPWebRootURL+'\u002fjsp-system\u002fspadministration_groups_zoom_portlet.jsp?';\n}\n\nfunction cproleslink_GetZoomLink(offline) {\n  return ZtVWeb.SPWebRootURL+'\u002fjsp-system\u002fspadministration_groups_zoom_portlet.jsp?grptype='+URLenc(this.roleType.Value())+'&'\n    \t\t+(this.radioAddRemoveRole.Value()==1 \u002f*addtouser*\u002f ?'disableGroupsOf=' : 'enableGroupsOf=')+URLenc(this.selectUser.Value())+'&';\u002f\u002fsostituisce il FixedFilter  \n}\nfunction this_Loaded(){\n  this.menuviewcurrent.ctrl.style.display='none';\n  this.menuviewpublic.ctrl.style.display='none';\n  var customToolbar=this.getTitlePortlet();\n  if(m_cTarget != \"_blank\") {\n    customToolbar.AppendButton({\n      image:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n      action:'..\u002fservlet\u002fSPControlPanel',\n      title:FormatMsg(\"MSG_BACK\"),\n      tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n    })\n  }\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })\n  customToolbar.SetTitle(FormatMsg('MSG_WEBMENU_SAFETY',this.file.Value()||'default'));\n  customToolbar.RearrangeAll();  \n  this.radioUserGroup_onChange();\n  LibJavascript.CssClassNameUtils.addClass(this.MenuView.ctrl,'padlock'+SPTheme.SPAdminSecurityMenuStateIconPosition);\n}\nfunction radioUserGroup_onChange(){\n  if (this.radioUserGroup.Value()=='U') {\n    this.m_nMenuOfGroup.Value(0);\n    this.cpgroupslink.Hide();\n    this.nameGroup.Hide();\n    this.nameGroup.Value('');\n\t\tthis.cpuserslink.Show();\n    this.nameUser.Show();\n  } else {\n    this.m_nMenuOfUser.Value(0);\n    this.cpuserslink.Hide();\n    this.nameUser.Hide();\n    this.nameUser.Value('');\n    this.cpgroupslink.Show();\n    this.nameGroup.Show();\n\t\tthis.nameRole.Hide();\n    this.radioAddRemoveRole.Hide();\n    this.cproleslink.Hide();\n    this.btnaddremoverole.Hide();\n  }\n  var elements = document.getElementsByClassName('security_padlock');\n  while (elements.length\u003e0) {\n    if (elements[0].parentNode) {\n    \telements[0].parentNode.removeChild(elements[0]);\n    }\n  }\n  elements = document.getElementsByClassName('security_element_closed');\n  while (elements.length\u003e0) {\n  \tLibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_closed');\n  }\n}\n\nfunction selectUser_onChange(){\n  this.selectRole.Value(0);\n  if (Empty(this.selectUser.Value())) {\n\t\tthis.nameRole.Hide();\n    this.radioAddRemoveRole.Hide();\n    this.cproleslink.Hide();\n  } else {\n    this.nameRole.Show();\n    this.radioAddRemoveRole.Show();\n    this.cproleslink.Show();\n  }\n}\n\nfunction cpgroupslink_LinkBlanked(){\n  this.m_nMenuOfGroup.Value( '' );\n  this.valueChanged();\n}\n\nfunction cpuserslink_LinkBlanked(){\n\tvar elements = document.getElementsByClassName('security_element_role_modified');\n  while (elements.length\u003e0) {\n    LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_role_modified');\n  }  \n  \n  this.m_nMenuOfUser.Value( '' );\n  this.valueChanged();\n}\n\nfunction cpgroupslink_LinkExecuted(){\n  this.m_nMenuOfGroup.Value( this.selectGroup.Value() );\n  this.m_nMenuOfUser.Value( '' );\n  this.valueChanged();\n}\n\nfunction cpuserslink_LinkExecuted(){\n  this.m_nMenuOfUser.Value( this.selectUser.Value() );\n  this.m_nMenuOfGroup.Value( '' );\n  this.valueChanged();\n}\n\nfunction cproleslink_LinkExecuted(){\n\tvar refresh = true;\n  if (!Empty(this.selectRole.Value())) {\n    var groups = this.checkRole.Link();\n    groups = groups.trim().split(\u002f *, *\u002f);\n    if ((this.radioAddRemoveRole.Value()==1 ? Ne : Eq ) (groups.indexOf(Str(this.selectRole.Value(),9).trim()), -1 ) ) {\n      this.selectRole.Value(0);\n      if (this.radioAddRemoveRole.Value()==1)\n      \talert(FormatMsg('MSG_USER_BELONGS_TO_ROLE'));\n     \telse\n        alert(FormatMsg('MSG_USER_NOT_BELONGS_TO_ROLE'));\n      refresh=false;\n    }\n  } \n\tif ( refresh ) {\n\t\tvar elements = document.getElementsByClassName('security_element_role_modified');\n    while (elements.length\u003e0) {\n      LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_role_modified');\n    }  \n  \tthis.m_nMenuOfGroup.Value( this.selectRole.Value() );\n  \tthis.valueChanged();\n  \tthis.btnaddremoverole.Show();\n  }\n}\nfunction cproleslink_LinkBlanked(){\n  this.m_nMenuOfGroup.Value( '' );\n  this.valueChanged();\n  this.btnaddremoverole.Hide();\n}\n\nfunction menuviewcurrent_Rendered(){\n  var i, currentnode, publicnode, adminnode, htmlnode;\n  for(i=0;i\u003cthis.MenuView.Tree.allnodes.length;i++){\n    adminnode=this.MenuView.Tree.allnodes[i];\n    if (adminnode.level\u003e-1 && adminnode.children==0 && !Empty(adminnode.nodeid)) {\u002f\u002flevel -1 e' la root node e non e' da valutare\n      publicnode = this.menuviewpublic.getNodeByID(adminnode.nodeid);\n      currentnode = this.menuviewcurrent.getNodeByID(adminnode.nodeid);\n      htmlnode = document.getElementById(this.MenuView.id + '_' + adminnode.index + '_link');\n      this.AppendSecurityPadLock(htmlnode, adminnode,!!currentnode,!publicnode);\n    }\n  }\n\telementModified = null;\n  this.lblLoading.Hide(); \u002f\u002f l'avviso descritto prima verrà nascosto indicando così il successo dell'operazione, ovvero che son state correttamente \n\n}\n\nthis.MenuView.onMenuClick=function() {\n  if (!Empty(this.Tree.currentnode.link)) {\n    var htmlnode = document.getElementById(this.id + '_' + this.Tree.currentnode.index + '_link');\n    this.form.progname.Value(this.form.getKeyLinkFromHref(htmlnode));\n    if (this.form.progname.Value()!='')\n    \tthis.form.splinkereditsecurity.Link();\n  }\n}\nvar findReportName = \u002f[#?&]ReportName=(\\w+)[&]?\u002f;\nvar findTableName = \u002f[#?&]Table=(\\w+)[&]?\u002f;\nvar findConfigName = \u002f[#?&]ConfigName=(\\w+)[&]?\u002f;\nfunction getKeyLinkFromHref( a_tag ) {\n  if (a_tag.href.indexOf(window.location.origin)==0 ) {\n    var resname = a_tag.pathname.substring(a_tag.pathname.lastIndexOf('\u002f')+1);\n    var tmp;\n    if (resname == 'SPSmartReportPrint_portlet.jsp') { \u002f\u002fsmartreport\n      if (tmp = a_tag.search.match(findReportName) ) {\n        resname = 'svrp\u002f'+tmp[1];\n      } else if (r = a_tag.hash.match(findReportName) ) {\n        resname = 'svrp\u002f'+tmp[1];\n      } else {\n        resname = \"\";\n      }\n    } else if (resname == 'Report') { \u002f\u002freport\n      if (r = a_tag.search.match(findReportName) ) {\n        resname = 'vrp\u002f'+tmp[1];\n      } else {\n        resname = \"\";\n      }\n    } else if (resname == 'portalstudio.jsp') { \u002f\u002fportalstudio\n      resname=\"PortalStudio\";    \n    \u002f\u002fconfig.table_vzm\n    } else if (resname == 'SPPortalZoom.jsp') { \u002f\u002fzoom online\n      if (tmp = a_tag.search.match(findConfigName) ) {\n        resname=tmp[1]+'.';\n      } else {\n        resname='default.';\n      }\n      if (tmp = a_tag.search.match(findTableName) ) {\n        resname+=tmp[1]+'_vzm';\n      } else {\n        resname=\"\";\n      }\n    } else if (resname.startsWith('SPPortalZoom_') ) { \u002f\u002fzoom offline\n      if (tmp = a_tag.search.match(findConfigName) ) {\n        resname=tmp[1]+'.';\n      } else if (tmp = a_tag.hash.match(findConfigName) ) {\n        resname=tmp[1]+'.';\n      } else {\n        resname='default.';\n      }\n      if (tmp = a_tag.search.match(findTableName) ) {\n        resname+=tmp[1]+'_vzm';\n      } else if (tmp = a_tag.hash.match(findTableName) ) {\n        resname+=tmp[1]+'_vzm';\n      } else {\n        resname=\"\";\n      }\n    } else if (resname.endsWith('_portlet.jsp')) {\n      resname = 'ps\u002f'+resname.substring(0,resname.length-'_portlet.jsp'.length);\n    } else if (resname.endsWith('.jsp')) {\n      resname = 'ps\u002f'+resname.substring(0,resname.length-'.jsp'.length);\n    }\n  \treturn resname;\n  } else {\n    return '';\n  }\n}\nvar lineheight=0;\nfunction AppendSecurityPadLock(htmlnode, jselement, hasAccess,hasSecurity) {\n  var padlock = document.getElementById(htmlnode.id+'_padlock');\n  var _this = this;\n  if (lineheight==0) {\n   \tlineheight = htmlnode.parentNode.offsetHeight;\n  }\n  if (!padlock) {\n    padlock = document.createElement('a');\n    padlock.id = htmlnode.id+'_padlock';\n    padlock.className='security_padlock';\n    padlock.href='javascript:void(0);';\n\u002f\u002f     htmlnode.parentNode.appendChild(padlock); \u002f\u002finserire lucchetto dopo\n    htmlnode.parentNode.insertBefore(padlock,htmlnode); \u002f\u002finserire lucchetto prima\n    padlock.onclick=function(e) {\n      e = e ? e : window.event;\n    \tif (e.stopPropogation)\n       \t\te.stopPropogation();\n    \tif (e.cancelBubble != null)\n        \te.cancelBubble = true;\n\n      if (!Empty(_this.selectRole.Value())) {\n    \t\talert(FormatMsg('MSG_CONFIRM_ROLE_FIRST'));\n  \t\t} else {\n        \u002f\u002ftoggle security\n        elementModified = {nodeid :this.getAttribute('nodeid') , hadSecurity: this.getAttribute('hadSecurity')==='true', hadAccess: this.getAttribute('hadAccess')==='true'};\n        _this.link.Value(this.getAttribute('link'));\n        _this.hadSecurity.Value(this.getAttribute('hadSecurity'));\n        _this.opensecurity.Value(elementModified.hadSecurity && elementModified.hadAccess?false:true);\n        _this.code.Value(_this.m_nMenuOfGroup.Value()||_this.m_nMenuOfUser.Value())\n        _this.splinkerupdate.Link();\n      }\n    }\n  }\n\n  if (window.elementModified && elementModified.nodeid==jselement.nodeid) { \u002f\u002fsto scrivendo l'elemento appena modificato\n    if (!elementModified.hadSecurity && ! hasSecurity) {\n      alert(FormatMsg('MSG_INITIALIZATION_NOT_DID'));\n    } else if (elementModified.hadSecurity && !hasSecurity) {\n      alert(FormatMsg('MSG_ELEMENT_WITHOUT_SECURITY'));\n    } else if (elementModified.hadSecurity && elementModified.hadAccess == hasAccess ) {\n      alert(FormatMsg('MSG_SECURITY_NOT_MODIFIED'));\n    }\n  }\n  \n  padlock.setAttribute('hadAccess',hasAccess);\n  padlock.setAttribute('hadSecurity',hasSecurity);\n  padlock.setAttribute('link',this.getKeyLinkFromHref(htmlnode));\n  padlock.setAttribute('nodeid',jselement.nodeid);\n  if (Empty(this.selectRole.Value())) {\n    padlock.setAttribute('originalState',JSON.stringify({'hadAccess':hasAccess,'hadSecurity':hasSecurity}));\n  } else {\n    var originalState = padlock.getAttribute('originalState');\n    if (originalState) {\n      try {\n      \toriginalState = JSON.parse(originalState);\n       \tif ( originalState.hadAccess!=hasAccess || originalState.hadSecurity!=hasSecurity ) {\n          LibJavascript.CssClassNameUtils.addClass(htmlnode.parentNode,'security_element_role_modified');\n        }\n      } catch(ee){}\n      \n    }\n  }\n  LibJavascript.CssClassNameUtils.removeClass(htmlnode.parentNode,'security_element_closed');\n  if (hasSecurity) {\n    if (hasAccess) {\n      \u002f\u002f{ fontFamily:'icons8_win10', value: \"&#xE91C\" }\n      padlock.innerHTML = LibJavascript.DOM.buildIcon({type : 'img'\n\t\t\t\t\t\t\t\t, className : 'opened'\n                , image : (SPTheme.SPAdmin_security_menu_opened_resource_icon?SPTheme.SPAdmin_security_menu_opened_resource_icon:'..\u002fimages\u002ficon_open_padlock.png')\n                , image_attr : \"no-repeat center center\"\n                , style : 'height:'+lineheight+'px;width:'+lineheight+'px;vertical-align:bottom;cursor:pointer;'\n                , title : FormatMsg(\"ADMIN_CLOSE\")\n                , alt : FormatMsg(\"ADMIN_CLOSE\")\n                });\n      htmlnode.className='security_element_opened';\n    } else {\n      padlock.innerHTML = LibJavascript.DOM.buildIcon({type : 'img'\n                , className : 'closed'\n                , image : (SPTheme.SPAdmin_security_menu_closed_resource_icon?SPTheme.SPAdmin_security_menu_closed_resource_icon:'..\u002fimages\u002ficon_closed_padlock.png')\n                , image_attr : \"no-repeat center center\"\n                , style : 'height:'+lineheight+'px;width:'+lineheight+'px;vertical-align:bottom;cursor:pointer;'\n                , title : FormatMsg(\"ADMIN_ACTIVATE\")\n                , alt : FormatMsg(\"ADMIN_ACTIVATE\")\n                });\n      htmlnode.className='security_element_closed';\n      LibJavascript.CssClassNameUtils.addClass(htmlnode.parentNode,'security_element_closed');\n    }\n  } else {\n    padlock.innerHTML = LibJavascript.DOM.buildIcon({type : 'img'\n                , className : 'initialize'\n                , image : (SPTheme.SPAdmin_security_menu_initialize_resource_icon?SPTheme.SPAdmin_security_menu_initialize_resource_icon:'..\u002fimages\u002ficon_closed_padlock.png')\n                , image_attr : \"no-repeat center center\"\n                , style : 'height:'+lineheight+'px;width:'+lineheight+'px;vertical-align:bottom;cursor:pointer;'\n                , title : FormatMsg(\"ADMIN_RULE_OF_SECURITY\")\n                , alt : FormatMsg(\"ADMIN_RULE_OF_SECURITY\")\n\t\t\t\t\t\t\t\t});\n    htmlnode.className='security_element_initialize';\n  }\n}\n\nfunction splinkerupdate_Error(cCause){\n  elementModified = null; \u002f\u002fin caso di errore devo resettare l'elemento appena modificato\n  alert(cCause);\n}\nfunction splinkerupdate_Result(result){\n  if (result==='true') {\n    this.RefreshView();\n  }\n}\n\nfunction RefreshView() {\n  this.menuviewpublic.Blank();\n  this.xmlobjPublic.Query();\n}\n\nfunction xmlobjPublic_QueryExecuted(){\n  this.valueChanged();\n}\n\n\u002f\u002f Funzione che ha il compito, dopo aver scelto una delle voci presenti nel menù a tendina, di prelevare il file XML contenente le pagine\n\u002f\u002f accessibili dall'utente selezionato e di invocare le opportune funzioni.\n\u002f\u002f Funzione invocata ogni volta che si seleziona una voce dal menù a tendina. Ha il compito di passare alla funzione evidenzia() il \n\u002f\u002f valore dell'utente selezionato.\nfunction valueChanged() {\n\tif (Empty(this.m_nMenuOfUser.Value()) && Empty(this.m_nMenuOfGroup.Value())) {\n    var elements = document.getElementsByClassName('security_padlock');\n    while (elements.length\u003e0) {\n      if (elements[0].parentNode) {\n        elements[0].parentNode.removeChild(elements[0]);\n      }\n    }\n    elements = document.getElementsByClassName('security_element_closed');\n    while (elements.length\u003e0) {\n      LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_closed');\n    }\n    return; \u002f\u002f se non viene selezionato alcun valore nel menù a tendina non si proseguirà con nessun'altra operazione\n  } else {\n    this.lblLoading.Show(); \u002f\u002f viene mostrato a video un messaggio che avvisa il caricamento del file XML contenente le pagine accessibili dall'utente \n                \u002f\u002f selezionato e la relativa operazione di evidenziazione di queste all'interno della sitemap\n    this.menuviewcurrent.Blank();\n    this.xmlcurrent.Query();\n  }\n\t\n}\n\nthis.lblLoading.Hide();\n\nfunction radioAddRemoveRole_onChange(){\n  this.selectRole.Value(''); \u002f\u002fsvuota il ruolo selezionato\n\tvar elements = document.getElementsByClassName('security_element_role_modified');\n  while (elements.length\u003e0) {\n    LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_role_modified');\n  }  \n  if ( this.radioAddRemoveRole.Value() == 1) {\n    this.btnaddremoverole.Value(FormatMsg('MSG_ADD_USER_TO_ROLE'));\n  } else {\n    this.btnaddremoverole.Value(FormatMsg('MSG_PULL_USER_FROM_ROLE'));\n  }\n  \n}\n\nfunction btnaddremoverole_Click(){\n  this.splinkeraddremoverole.Link();\n}\n\n\nfunction splinkeraddremoverole_Executed(result,cError){\n  if (result==\"true\") {\n    this.selectRole.Value(0);\n    if (!Empty(cError)) {\n      alert(cError);\n    }\n  } else {\n\t\tif (!Empty(cError)) {\n      alert(cError);\n    }\n  }\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"spadministration_security.css","css_class":"portlet-white-default  no-radius","css_code":"[{\"type\":\"default\",\"name\":\"radioUserGroup_ctrl_element\",\"selector\":\"\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"selector\\\":\\\"\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_bottom\\\":\\\"10\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"radioUserGroup_ctrl_element\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:86px; height:49px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"pad_bottom\\\":\\\"10\\\"}\",\"code\":\".radioUserGroup_ctrl_element{padding: 0 0 10px 0;}\\n\"},{\"type\":\"radio\",\"name\":\"myradio div\",\"selector\":\"\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"selector\\\":\\\"\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_bottom\\\":\\\"10\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"myradio div\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:86px; height:51px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"pad_bottom\\\":\\\"10\\\"}\",\"code\":\".myradio div{padding: 0 0 10px 0;}\\n\"},{\"type\":\"radio\",\"name\":\"myradio input\",\"selector\":\"\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"border_radius_unit\\\":\\\" px\\\",\\\"selector\\\":\\\"\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_radius_unit\\\":\\\" px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"vertical-align: top;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Abel\\\",\\\"Amatic SC\\\",\\\"Anonymous Pro\\\",\\\"Antic Slab\\\",\\\"Bangers\\\",\\\"Cinzel\\\",\\\"Comfortaa\\\",\\\"Coustard\\\",\\\"Dancing Script\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Fjalla One\\\",\\\"Fredoka One\\\",\\\"Inconsolata\\\",\\\"Indie Flower\\\",\\\"Josefin Slab\\\",\\\"Lobster\\\",\\\"Lora\\\",\\\"Merriweather\\\",\\\"Montserrat\\\",\\\"Nova Mono\\\",\\\"Nunito\\\",\\\"Oswald\\\",\\\"Pacifico\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Quattrocento\\\",\\\"Raleway\\\",\\\"Righteous\\\",\\\"Roboto Condensed\\\",\\\"Roboto Mono\\\",\\\"Shadows Into Light\\\",\\\"Sigmar One\\\",\\\"Source Code Pro\\\",\\\"Special Elite\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"myradio input\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:86px; height:51px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"code\\\":\\\"vertical-align: top;\\\"}\",\"code\":\".myradio input{vertical-align: top;}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"border_radius_tl\":\"0\",\"border_radius_tr\":\"0\",\"border_radius_bl\":\"0.5rem\",\"border_radius_br\":\"0.5rem\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"no-radius\",\"selector\":\".no-radius\",\"id\":\"form\"}]","custom":"","description":"Pagina per gestire le sicurezze del menu di applicazione","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lblLoading }}{{ @radioUserGroup }}{{ @selectUser }}{{ @nameUser }}{{ @cpuserslink }}{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @menuviewpublic }}{{ @menuviewcurrent }}{{ @MenuView }}{{ @chkDisplayClosed }}{{ @radioAddRemoveRole }}{{ @selectRole }}{{ @nameRole }}{{ @cproleslink }}{{ @btnaddremoverole }}{{ @lblLoading }}{{ @radioUserGroup }}{{ @selectUser }}{{ @nameUser }}{{ @cpuserslink }}{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @menuviewpublic }}{{ @menuviewcurrent }}{{ @MenuView }}{{ @chkDisplayClosed }}{{ @radioAddRemoveRole }}{{ @selectRole }}{{ @nameRole }}{{ @cproleslink }}{{ @btnaddremoverole }}{{ @lblLoading }}{{ @radioUserGroup }}{{ @selectUser }}{{ @nameUser }}{{ @cpuserslink }}{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @menuviewpublic }}{{ @menuviewcurrent }}{{ @MenuView }}{{ @chkDisplayClosed }}{{ @radioAddRemoveRole }}{{ @selectRole }}{{ @nameRole }}{{ @cproleslink }}{{ @btnaddremoverole }}{{ @Radio1 }}{{ @lblLoading }}{{ @radioUserGroup }}{{ @selectUser }}{{ @nameUser }}{{ @cpuserslink }}{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @menuviewpublic }}{{ @menuviewcurrent }}{{ @MenuView }}{{ @chkDisplayClosed }}{{ @radioAddRemoveRole }}{{ @selectRole }}{{ @nameRole }}{{ @cproleslink }}{{ @btnaddremoverole }}{{ @DataMasher48 }}{{ @HamburgerMenu }}{{ @Radio1 }}{{ @lblLoading }}{{ @radioUserGroup }}{{ @selectUser }}{{ @nameUser }}{{ @cpuserslink }}{{ @selectGroup }}{{ @nameGroup }}{{ @cpgroupslink }}{{ @menuviewpublic }}{{ @menuviewcurrent }}{{ @MenuView }}{{ @chkDisplayClosed }}{{ @radioAddRemoveRole }}{{ @selectRole }}{{ @nameRole }}{{ @cproleslink }}{{ @btnaddremoverole }}{{ @DataMasher48 }}{{ @HamburgerMenu }}{{ @Radio1 }}{{ @Radio1_Copy }}{{ @LiteMenuMobile55 }}\u003c\u002fbody\u003e","grapesCss":"","h":"240","hsl":"","htmlcode":" \n \n \n \n \n \n \n \n \n \n \n \n \n{{ @lblLoading }} \n{{ @radioUserGroup }} \n{{ @selectUser }} \n{{ @nameUser }} \n{{ @cpuserslink }} \n{{ @selectGroup }} \n{{ @nameGroup }} \n{{ @cpgroupslink }} \n{{ @menuviewpublic }} \n{{ @menuviewcurrent }} \n{{ @MenuView }} \n{{ @chkDisplayClosed }} \n{{ @radioAddRemoveRole }} \n{{ @selectRole }} \n{{ @nameRole }} \n{{ @cproleslink }} \n{{ @btnaddremoverole }} \n \n \n \n \n \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"Gestione delle sicurezze\",\"layer\":\"\",\"h\":\"240\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Gestione delle sicurezze","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"700","version":"37","w":"100%","wizard":""},{"async":"true","auto_exec":"true","ctrlOfVariant":"","h":"22","n_records":"","name":"xmlobjBase","page":"1","parms":"file,m_nMenuOfGroup=1,view_all,ignoreSecurity=true,add_login","parms_source":"","root":"\u002fSPVMNMenu","sequence":"1","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":"184","x":"-1","xmldataobj":"","y":"271"},{"async":"true","auto_exec":"true","ctrlOfVariant":"","h":"22","n_records":"","name":"xmlobjPublic","page":"1","parms":"file,m_nMenuOfUser=-2,view_all,add_login","parms_source":"","root":"\u002fSPVMNMenu","sequence":"1","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":"184","x":"-1","xmldataobj":"","y":"298"},{"async":"true","auto_exec":"false","ctrlOfVariant":"","h":"22","n_records":"","name":"xmlcurrent","page":"1","parms":"file,m_nMenuOfUser,m_nMenuOfGroup,view_all,add_login","parms_source":"","root":"\u002fSPVMNMenu","sequence":"2","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":"184","x":"-1","xmldataobj":"","y":"244"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"24","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblLoading","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_LOADING","w":"277","wireframe_props":"align,value,n_col","x":"20","y":"123","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"0","name":"m_nMenuOfUser","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"numeric","w":"113","x":"445","y":"333"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"file","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"445","y":"307"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"0","name":"m_nMenuOfGroup","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"numeric","w":"113","x":"445","y":"359"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"true","name":"view_all","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"logic","w":"113","x":"445","y":"385"},{"anchor":"top-left","calculate":"","class_Css":"radio myradio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"51","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"'G'","layer":"false","layout_steps_values":"{}","name":"radioUserGroup","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"1","textlist":"ADMIN_USER,ADMIN_GROUP","type":"Radio","typevar":"character","valuelist":"U,G","visible":"true","w":"113","wireframe_props":"","x":"20","y":"53","zindex":"2","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"22","m_cAction":"function","name":"splinkerupdate","offline":"false","page":"1","parms":"link,usertype=radioUserGroup,code,opensecurity,hadSecurity","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"spadministration_updatesecurity","target":"result","type":"SPLinker","w":"184","x":"-1","y":"352"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"link","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"324","y":"281"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"opensecurity","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"logic","w":"113","x":"324","y":"306"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"hadSecurity","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"logic","w":"113","x":"324","y":"331"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"result","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"324","y":"381"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"no","name":"add_login","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"445","y":"411"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"9","name":"selectUser","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"113","wireframe_props":"name","x":"445","y":"281","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameUser","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"122","wireframe_props":"name","x":"136","y":"52","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"spadministration_zuser","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectUser,nameUser","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"selectUser","linkedUsing":"nameUser","looselylinked":"false","n_criteria":"2","name":"cpuserslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"17","servlet":"spadministration_users","spuid":"","suggest":"false","table":"cpusers","type":"LinkZoom","w":"20","wireframe_props":"","x":"259","y":"52","zindex":"","zone":"","zoomtitle":"CP_USERS"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"9","name":"selectGroup","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"113","wireframe_props":"name","x":"445","y":"255","zerofilling":"false","zindex":"6","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameGroup","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"122","wireframe_props":"name","x":"136","y":"80","zerofilling":"false","zindex":"7","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectGroup,nameGroup","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"selectGroup","linkedUsing":"nameGroup","looselylinked":"false","n_criteria":"2","name":"cpgroupslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"20","servlet":"","spuid":"","suggest":"false","table":"cpgroups","type":"LinkZoom","w":"20","wireframe_props":"","x":"259","y":"80","zindex":"","zone":"","zoomtitle":"CP_GROUPS"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"22","m_cAction":"","name":"splinkereditsecurity","offline":"false","page":"1","parms":"progname","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"true","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"21","servlet":"..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp","target":"","type":"SPLinker","w":"184","x":"-1","y":"325"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"progname","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"324","y":"431"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"22","included":"false","name":"Event_addQuery","objsValues":"this.RefreshView()","page":"1","parmsNames":"","sequence":"23","type":"EventReceiver","w":"184","x":"-1","y":"406"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"code","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"324","y":"356"},{"Root_node_value":"-1","anchor":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","className":"","close_level":"60","ctrlOfVariant":"","dataobj":"xmlobjPublic","direction":"horizontal","emitter_name":"","field_ChildCount":"elements","field_Css_Class":"","field_Expr":"","field_ExprNot":"","field_Frame":"target","field_Icons":"","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeLinkOver":"","field_NodeParent":"","field_NodeSeq":"","field_NodeTooltip":"","field_inExt":"","field_level":"","field_view_type":"","fixed":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":"30","hide":"","layer":"","layout_steps_values":"{}","link_secondary":"","max_level":"-1","menu_type":"flat","name":"menuviewpublic","page":"1","rapp":"","separator":"","separator_vert":"","sequence":"25","server_side":"","skin_path":"","spuid":"","tag_node":"MenuItem","target_default":"","type":"MenuView","w":"30","wireframe_props":"","x":"724","y":"179","zindex":"","zone":""},{"Root_node_value":"-1","anchor":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","className":"","close_level":"60","ctrlOfVariant":"","dataobj":"xmlcurrent","direction":"horizontal","emitter_name":"","field_ChildCount":"elements","field_Css_Class":"","field_Expr":"","field_ExprNot":"","field_Frame":"target","field_Icons":"","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeLinkOver":"","field_NodeParent":"","field_NodeSeq":"","field_NodeTooltip":"","field_inExt":"","field_level":"","field_view_type":"","fixed":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":"30","hide":"","layer":"","layout_steps_values":"{}","link_secondary":"","max_level":"-1","menu_type":"flat","name":"menuviewcurrent","page":"1","rapp":"","separator":"","separator_vert":"","sequence":"26","server_side":"","skin_path":"","spuid":"","tag_node":"MenuItem","target_default":"","type":"MenuView","w":"30","wireframe_props":"","x":"781","y":"179","zindex":"","zone":""},{"Root_node_value":"-1","anchor":"top-left-right","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","className":"","close_level":"60","ctrlOfVariant":"","dataobj":"xmlobjBase","direction":"vertical","emitter_name":"","field_ChildCount":"elements","field_Css_Class":"","field_Expr":"","field_ExprNot":"","field_Frame":"target","field_Icons":"","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeLinkOver":"","field_NodeParent":"","field_NodeSeq":"","field_NodeTooltip":"","field_inExt":"","field_level":"","field_view_type":"","fixed":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":"40","hide":"","layer":"","layout_steps_values":"{}","link_secondary":"","max_level":"-1","menu_type":"flat","name":"MenuView","page":"1","rapp":"","separator":"","separator_vert":"","sequence":"27","server_side":"","skin_path":"","spuid":"","tag_node":"MenuItem","target_default":"main","type":"MenuView","w":"599","wireframe_props":"","x":"20","y":"147","zindex":"","zone":""},{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"26","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"true","label_text":"MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT","layer":"false","layout_steps_values":"{}","name":"chkDisplayClosed","page":"1","rapp":"","sequence":"28","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"331","wireframe_props":"label_text","x":"20","y":"18","zindex":"8","zone":""},{"anchor":"top-left","calculate":"","class_Css":"radio myradio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"61","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"1","layer":"false","layout_steps_values":"{}","name":"radioAddRemoveRole","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"29","spuid":"","tabindex":"","textlist":"MSG_SIMULATE_ADDING_ROLE,MSG_SIMULATE_REMOVING_ROLE","type":"Radio","typevar":"numeric","valuelist":"1,0","visible":"true","w":"206","wireframe_props":"","x":"289","y":"53","zindex":"9","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"selectRole","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"30","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"113","wireframe_props":"name","x":"324","y":"256","zerofilling":"false","zindex":"12","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"nameRole","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"31","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"122","wireframe_props":"name","x":"502","y":"52","zerofilling":"false","zindex":"10","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"roleType","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"selectRole,nameRole","keyfixedfilters":"grptype","layer":"false","layout_steps_values":"{}","linkedField":"selectRole","linkedUsing":"nameRole","looselylinked":"false","n_criteria":"2","name":"cproleslink","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"32","servlet":"","spuid":"","suggest":"false","table":"cpgroups","type":"LinkZoom","w":"20","wireframe_props":"","x":"628","y":"52","zindex":"","zone":"","zoomtitle":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'R'","name":"roleType","page":"1","reactive":"","sequence":"33","server_side":"false","type":"Variable","typevar":"character","w":"113","x":"324","y":"406"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"22","m_cAction":"function","name":"checkRole","offline":"false","page":"1","parms":"userCode=selectUser","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"34","servlet":"spadministration_getgrouplist","target":"","type":"SPLinker","w":"184","x":"-1","y":"379"},{"anchor":"top-left-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnaddremoverole","page":"1","rapp":"","sequence":"35","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_ADD_USER_TO_ROLE","w":"41","wireframe_props":"value","x":"656","y":"52","zindex":"14","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"22","m_cAction":"function","name":"splinkeraddremoverole","offline":"false","page":"1","parms":"userCode=selectUser,groupCode=selectRole","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"36","servlet":"spadministration_togglegroupofuser","target":"","type":"SPLinker","w":"184","x":"-1","y":"433"}]%>
<%/*Description:Pagina per gestire le sicurezze del menu di applicazione*/%>
<%/*ParamsRequest:file*/%>
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
.spadministration_securitymenu_container .myradio div{
  padding-bottom: 10px;
}
.spadministration_securitymenu_container .myradio input{
  vertical-align: top;
}
.spadministration_securitymenu_container .no-radius{
  border-radius: 0px 0px 0.5rem 0.5rem;
}
.spadministration_securitymenu_container {
  height:100%;
  overflow:auto;
}
.spadministration_securitymenu_portlet{
  position:relative;
  width:100%;
  min-width:700px;
  height:100%;
}
.spadministration_securitymenu_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.spadministration_securitymenu_portlet > .lblLoading_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:123px;
  left:20px;
  width:277px;
  height:auto;
  min-height:24px;
}
.spadministration_securitymenu_portlet > .lblLoading_ctrl {
  height:auto;
  min-height:24px;
}
.spadministration_securitymenu_portlet > .lblLoading_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:left;
  background-color:transparent;
}
.spadministration_securitymenu_portlet > .radioUserGroup_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:53px;
  left:20px;
  width:113px;
  height:51px;
  height:auto;
  min-height:51px;
}
.spadministration_securitymenu_portlet > .selectUser_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:281px;
  left:445px;
  width:113px;
  height:22px;
}
.spadministration_securitymenu_portlet > .selectUser_ctrl {
  display:none;
}
.spadministration_securitymenu_portlet > .selectUser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.spadministration_securitymenu_portlet > .nameUser_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:52px;
  left:136px;
  width:122px;
  height:20px;
}
.spadministration_securitymenu_portlet > .nameUser_ctrl {
}
.spadministration_securitymenu_portlet > .nameUser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securitymenu_portlet > .cpuserslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:52px;
  left:259px;
  width:20px;
  height:20px;
}
.spadministration_securitymenu_portlet > .selectGroup_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:255px;
  left:445px;
  width:113px;
  height:22px;
}
.spadministration_securitymenu_portlet > .selectGroup_ctrl {
  display:none;
}
.spadministration_securitymenu_portlet > .selectGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.spadministration_securitymenu_portlet > .nameGroup_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:80px;
  left:136px;
  width:122px;
  height:20px;
}
.spadministration_securitymenu_portlet > .nameGroup_ctrl {
}
.spadministration_securitymenu_portlet > .nameGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securitymenu_portlet > .cpgroupslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:80px;
  left:259px;
  width:20px;
  height:20px;
}
.spadministration_securitymenu_portlet > .menuviewpublic_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:179px;
  left:724px;
  width:30px;
  height:30px;
}
.spadministration_securitymenu_portlet .menuviewpublic_ctrl,
.spadministration_securitymenu_portlet .menuviewpublic_ctrl a{
}
.spadministration_securitymenu_portlet > .menuviewcurrent_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:179px;
  left:781px;
  width:30px;
  height:30px;
}
.spadministration_securitymenu_portlet .menuviewcurrent_ctrl,
.spadministration_securitymenu_portlet .menuviewcurrent_ctrl a{
}
.spadministration_securitymenu_portlet > .MenuView_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:147px;
  left:20px;
  right:81px;
  width:auto;
  height:40px;
}
.spadministration_securitymenu_portlet .MenuView_ctrl,
.spadministration_securitymenu_portlet .MenuView_ctrl a{
}
.spadministration_securitymenu_portlet > .chkDisplayClosed_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:18px;
  left:20px;
  width:331px;
  height:26px;
}
.spadministration_securitymenu_portlet > .radioAddRemoveRole_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:53px;
  left:289px;
  width:206px;
  height:61px;
  height:auto;
  min-height:61px;
}
.spadministration_securitymenu_portlet > .selectRole_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:256px;
  left:324px;
  width:113px;
  height:22px;
}
.spadministration_securitymenu_portlet > .selectRole_ctrl {
  display:none;
}
.spadministration_securitymenu_portlet > .selectRole_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securitymenu_portlet > .nameRole_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:52px;
  left:502px;
  width:122px;
  height:20px;
}
.spadministration_securitymenu_portlet > .nameRole_ctrl {
}
.spadministration_securitymenu_portlet > .nameRole_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.spadministration_securitymenu_portlet > .cproleslink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:52px;
  left:628px;
  width:20px;
  height:20px;
}
.spadministration_securitymenu_portlet > .btnaddremoverole_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:52px;
  left:656px;
  right:3px;
  right:0.42857143%;
  width:auto;
  height:20px;
}
.spadministration_securitymenu_portlet > .btnaddremoverole_ctrl {
}
.spadministration_securitymenu_container .radioUserGroup_ctrl_element{  padding-bottom: 10px;
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
 String def="[{\"h\":\"240\",\"layout_steps_values\":{},\"pages_names\":\"Gestione delle sicurezze\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"700\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"XMLDataobj\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"271\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"XMLDataobj\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"298\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"XMLDataobj\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"244\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_LOADING\",\"w\":\"277\",\"x\":\"20\",\"y\":\"123\",\"zindex\":\"1\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"445\",\"y\":\"333\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"445\",\"y\":\"307\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"445\",\"y\":\"359\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"445\",\"y\":\"385\"},{\"anchor\":\"top-left\",\"h\":\"51\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Radio\",\"w\":\"113\",\"x\":\"20\",\"y\":\"53\",\"zindex\":\"2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"352\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"281\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"306\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"331\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"381\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"445\",\"y\":\"411\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"selectUser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"445\",\"y\":\"281\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameUser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"122\",\"x\":\"136\",\"y\":\"52\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cpuserslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"259\",\"y\":\"52\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"selectGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"445\",\"y\":\"255\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"122\",\"x\":\"136\",\"y\":\"80\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cpgroupslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"259\",\"y\":\"80\",\"zindex\":\"\"},{\"h\":\"22\",\"name\":\"splinkereditsecurity\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"325\"},{\"h\":\"22\",\"name\":\"progname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"431\"},{\"h\":\"22\",\"name\":\"Event_addQuery\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"406\"},{\"h\":\"22\",\"name\":\"code\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"356\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"menuviewpublic\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"30\",\"x\":\"724\",\"y\":\"179\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"menuviewcurrent\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"30\",\"x\":\"781\",\"y\":\"179\",\"zindex\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"40\",\"layout_steps_values\":{},\"name\":\"MenuView\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"599\",\"x\":\"20\",\"y\":\"147\",\"zindex\":\"\"},{\"anchor\":\"top-left\",\"h\":\"26\",\"label_text\":\"MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT\",\"layout_steps_values\":{},\"name\":\"chkDisplayClosed\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"331\",\"x\":\"20\",\"y\":\"18\",\"zindex\":\"8\"},{\"anchor\":\"top-left\",\"h\":\"61\",\"layout_steps_values\":{},\"name\":\"radioAddRemoveRole\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"206\",\"x\":\"289\",\"y\":\"53\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"selectRole\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"324\",\"y\":\"256\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nameRole\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"122\",\"x\":\"502\",\"y\":\"52\",\"zindex\":\"10\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cproleslink\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"628\",\"y\":\"52\",\"zindex\":\"\"},{\"h\":\"22\",\"name\":\"roleType\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"113\",\"x\":\"324\",\"y\":\"406\"},{\"h\":\"22\",\"name\":\"checkRole\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"379\"},{\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"btnaddremoverole\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_ADD_USER_TO_ROLE\",\"w\":\"41\",\"x\":\"656\",\"y\":\"52\",\"zindex\":\"14\"},{\"h\":\"22\",\"name\":\"splinkeraddremoverole\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"184\",\"x\":\"-1\",\"y\":\"433\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_securitymenu","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_securitymenu_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("spadministration_security.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("spadministration_security.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("spadministration_help.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_securitymenu','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_securitymenu_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
String lblLoading= "MSG_LOADING";
double m_nMenuOfUser=0;
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
if(request.getAttribute("spadministration_securitymenu_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String nameUser= "";
if(request.getAttribute("spadministration_securitymenu_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
double selectGroup= 0;
String nameGroup= "";
String progname= "";
String code= "";
if(request.getAttribute("spadministration_securitymenu_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewObj.js")%>'></script>
<%}
boolean chkDisplayClosed=true;
double radioAddRemoveRole=1;
double selectRole= 0;
String nameRole= "";
String roleType="R";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_securitymenu_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_securitymenu_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_securitymenu_portlet portlet-white-default  no-radius' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_securitymenu','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblLoading'  formid='<%=idPortlet%>' ps-name='lblLoading'    class='label lblLoading_ctrl'><div id='<%=idPortlet%>_lblLoadingtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_LOADING"))%></div></span>
<div id='<%=idPortlet%>_radioUserGroup' class='radio myradio' style='z-index:1;'></div>
<span class='textbox-container'id='<%=idPortlet%>_selectUser_wrp'><input id='<%=idPortlet%>_selectUser' name='selectUser' type='text' maxlength='9' class='textbox' formid='<%=idPortlet%>' ps-name='selectUser' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameUser_wrp'><input id='<%=idPortlet%>_nameUser' name='nameUser' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameUser' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cpuserslink'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_selectGroup_wrp'><input id='<%=idPortlet%>_selectGroup' name='selectGroup' type='text' maxlength='9' class='textbox' formid='<%=idPortlet%>' ps-name='selectGroup' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameGroup_wrp'><input id='<%=idPortlet%>_nameGroup' name='nameGroup' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameGroup' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cpgroupslink'" ) );%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewFlatObj.js")%>'></script>
<div id='<%=idPortlet%>_menuviewpublic' class='menuview_flat'></div>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewFlatObj.js")%>'></script>
<div id='<%=idPortlet%>_menuviewcurrent' class='menuview_flat'></div>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewFlatObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuView' class='menuview_flat'></div>
<div id='<%=idPortlet%>_chkDisplayClosed_div' style=''><input id='<%=idPortlet%>_chkDisplayClosed' name='chkDisplayClosed' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkDisplayClosed' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML(sp.translate("MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT"))%></label></div>
<div id='<%=idPortlet%>_radioAddRemoveRole' class='radio myradio' style='z-index:1;'></div>
<span class='textbox-container'id='<%=idPortlet%>_selectRole_wrp'><input id='<%=idPortlet%>_selectRole' name='selectRole' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='selectRole' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nameRole_wrp'><input id='<%=idPortlet%>_nameRole' name='nameRole' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nameRole' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_cproleslink'" ) );%>
<input id='<%=idPortlet%>_btnaddremoverole' type='button' class='button btnaddremoverole_ctrl'/>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_securitymenu');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ACTIVATE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ACTIVATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_RULE_OF_SECURITY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_RULE_OF_SECURITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ADD_USER_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ADD_USER_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_BACK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_BACK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONFIRM_ROLE_FIRST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONFIRM_ROLE_FIRST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ELEMENT_WITHOUT_SECURITY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ELEMENT_WITHOUT_SECURITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_INITIALIZATION_NOT_DID",true)+","+JSPLib.ToJSValue(sp.translate("MSG_INITIALIZATION_NOT_DID"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PULL_USER_FROM_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PULL_USER_FROM_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SECURITY_NOT_MODIFIED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SECURITY_NOT_MODIFIED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_USER_BELONGS_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_USER_BELONGS_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_USER_NOT_BELONGS_TO_ROLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_USER_NOT_BELONGS_TO_ROLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WEBMENU_SAFETY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WEBMENU_SAFETY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_securitymenu',["700"],["240"],'portlet-white-default  no-radius',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"700","h":"240","title":"Gestione delle sicurezze","layer":""}]);
this.xmlobjBase=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobjBase","field":"","h":22,"hide":"false","layer":false,"layout_steps_values":{},"n_records":"","name":"xmlobjBase","page":1,"parms":"file,m_nMenuOfGroup=1,view_all,ignoreSecurity=true,add_login","parms_source":"","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":184,"x":-1,"xmldataobj":"","y":271});
this.xmlobjPublic=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobjPublic","field":"","h":22,"hide":"false","layer":false,"layout_steps_values":{},"n_records":"","name":"xmlobjPublic","page":1,"parms":"file,m_nMenuOfUser=-2,view_all,add_login","parms_source":"","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":184,"x":-1,"xmldataobj":"","y":298});
this.xmlcurrent=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"false","ctrlid":"<%=idPortlet%>_xmlcurrent","field":"","h":22,"hide":"false","layer":false,"layout_steps_values":{},"n_records":"","name":"xmlcurrent","page":1,"parms":"file,m_nMenuOfUser,m_nMenuOfGroup,view_all,add_login","parms_source":"","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":184,"x":-1,"xmldataobj":"","y":244});
this.lblLoading=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblLoading","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":24,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblLoading","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblLoading),false,true)%>","type":"Label","w":277,"x":20,"y":123,"zindex":"1"});
this.m_nMenuOfUser=new ZtVWeb._VC(this,'m_nMenuOfUser',null,'numeric',<%=m_nMenuOfUser%>,false,false);
this.file=new ZtVWeb._VC(this,'file',null,'character','<%=JSPLib.ToJSValue(file,false,true)%>',false,false);
this.m_nMenuOfGroup=new ZtVWeb._VC(this,'m_nMenuOfGroup',null,'numeric',<%=m_nMenuOfGroup%>,false,false);
this.view_all=new ZtVWeb._VC(this,'view_all',null,'logic',<%=view_all%>,false,false);
this.radioUserGroup=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"","captionsList":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_USER"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP"),false,true)%>","class_Css":"radio myradio","create_undercond":"","ctrlid":"<%=idPortlet%>_radioUserGroup","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":51,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"'G'","layer":false,"layout_steps_values":{},"name":"radioUserGroup","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"1","type":"Radio","typevar":"character","valuesList":"U,G","visible":true,"w":113,"x":20,"y":53,"zindex":"2"});
this.radioUserGroup.Value('<%=JSPLib.ToJSValue(radioUserGroup,false,true)%>');
this.splinkerupdate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkerupdate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkerupdate","offline":false,"page":1,"parms":"link,usertype=radioUserGroup,code,opensecurity,hadSecurity","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_updatesecurity","target":"result","type":"SPLinker","w":184,"x":-1,"y":352});
this.splinkerupdate.m_cID='<%=JSPLib.cmdHash("routine,spadministration_updatesecurity",request.getSession())%>';
this.link=new ZtVWeb._VC(this,'link',null,'character','<%=JSPLib.ToJSValue(link,false,true)%>',false,false);
this.opensecurity=new ZtVWeb._VC(this,'opensecurity',null,'logic',<%=opensecurity%>,false,false);
this.hadSecurity=new ZtVWeb._VC(this,'hadSecurity',null,'logic',<%=hadSecurity%>,false,false);
this.result=new ZtVWeb._VC(this,'result',null,'character','<%=JSPLib.ToJSValue(result,false,true)%>',false,false);
this.add_login=new ZtVWeb._VC(this,'add_login',null,'character','<%=JSPLib.ToJSValue(add_login,false,true)%>',false,false);
this.selectUser=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectUser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"9","name":"selectUser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectUser%>","w":113,"x":445,"y":281,"zerofilling":false,"zindex":"3","zoom":""});
this.nameUser=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameUser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameUser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameUser,false,true)%>","w":122,"x":136,"y":52,"zerofilling":false,"zindex":"5","zoom":""});
this.cpuserslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"spadministration_zuser","ctrlid":"<%=idPortlet%>_cpuserslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_securitymenu_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"selectUser,nameUser","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_securitymenu_portlet.jspcpuserslink",request.getSession())%>","linkedField":"selectUser","linkedUsing":"nameUser","looselylinked":false,"n_criteria":"2","name":"cpuserslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"spadministration_users","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpusers,spadministration_zuser",request.getSession())%>","suggest":false,"table":"cpusers","type":"LinkZoom","w":20,"x":259,"y":52,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_USERS"),false,true)%>"});
this.selectGroup=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"9","name":"selectGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectGroup%>","w":113,"x":445,"y":255,"zerofilling":false,"zindex":"6","zoom":""});
this.nameGroup=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameGroup,false,true)%>","w":122,"x":136,"y":80,"zerofilling":false,"zindex":"7","zoom":""});
this.cpgroupslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_cpgroupslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_securitymenu_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"selectGroup,nameGroup","intovarsType":"N,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_securitymenu_portlet.jspcpgroupslink",request.getSession())%>","linkedField":"selectGroup","linkedUsing":"nameGroup","looselylinked":false,"n_criteria":"2","name":"cpgroupslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":false,"table":"cpgroups","type":"LinkZoom","w":20,"x":259,"y":80,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>"});
this.splinkereditsecurity=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkereditsecurity","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkereditsecurity","offline":false,"page":1,"parms":"progname","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"true","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp","target":"","type":"SPLinker","w":184,"x":-1,"y":325});
this.splinkereditsecurity.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spproceduresecurity_portlet.jsp",request.getSession())%>';
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
this.Event_addQuery=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_addQuery","h":22,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_addQuery","objsValues":"this.RefreshView()","page":1,"parmsNames":"","type":"EventReceiver","w":184,"x":-1,"y":406});
this.code=new ZtVWeb._VC(this,'code',null,'character','<%=JSPLib.ToJSValue(code,false,true)%>',false,false);
this.menuviewpublic=new ZtVWeb.MenuViewFlatCtrl(this,{"anchor":"","arrow_image":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","btn_image":"","btn_imageWidth":"","btnover_image":"","class_Css":"","close_level":"60","ctrlid":"<%=idPortlet%>_menuviewpublic","direction":"horizontal","dx_btn_image":"","dx_btnover_image":"","emitter_name":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":30,"hide":"","layer":false,"layout_steps_values":{},"link_secondary":"","max_level":-1,"menu_type":"flat","name":"menuviewpublic","page":1,"root_value":"-1","separator":"","separator_vert":"","spuid":"","sx_btn_image":"","sx_btnover_image":"","tag_node":"MenuItem","target_default":"","type":"MenuView","w":30,"x":724,"y":179,"zindex":""});
this.menuviewpublic.setRowsCols('uid','elements','caption','','','','','','target','link','','', '','');
this.menuviewcurrent=new ZtVWeb.MenuViewFlatCtrl(this,{"anchor":"","arrow_image":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","btn_image":"","btn_imageWidth":"","btnover_image":"","class_Css":"","close_level":"60","ctrlid":"<%=idPortlet%>_menuviewcurrent","direction":"horizontal","dx_btn_image":"","dx_btnover_image":"","emitter_name":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":30,"hide":"","layer":false,"layout_steps_values":{},"link_secondary":"","max_level":-1,"menu_type":"flat","name":"menuviewcurrent","page":1,"root_value":"-1","separator":"","separator_vert":"","spuid":"","sx_btn_image":"","sx_btnover_image":"","tag_node":"MenuItem","target_default":"","type":"MenuView","w":30,"x":781,"y":179,"zindex":""});
this.menuviewcurrent.setRowsCols('uid','elements','caption','','','','','','target','link','','', '','');
this.MenuView=new ZtVWeb.MenuViewFlatCtrl(this,{"anchor":"top-left-right","arrow_image":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","btn_image":"","btn_imageWidth":"","btnover_image":"","class_Css":"","close_level":"60","ctrlid":"<%=idPortlet%>_MenuView","direction":"vertical","dx_btn_image":"","dx_btnover_image":"","emitter_name":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":40,"hide":"","layer":false,"layout_steps_values":{},"link_secondary":"","max_level":-1,"menu_type":"flat","name":"MenuView","page":1,"root_value":"-1","separator":"","separator_vert":"","spuid":"","sx_btn_image":"","sx_btnover_image":"","tag_node":"MenuItem","target_default":"main","type":"MenuView","w":599,"x":20,"y":147,"zindex":""});
this.MenuView.setRowsCols('uid','elements','caption','','','','','','target','link','','', '','');
this.chkDisplayClosed=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkDisplayClosed","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":26,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"true","label_text":"MSG_SHOW_HIDDEN_ITEMS_FOR_SUBJECT","layer":false,"layout_steps_values":{},"name":"chkDisplayClosed","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":331,"x":20,"y":18,"zindex":"8"});
this.chkDisplayClosed.Value(<%=chkDisplayClosed%>);
this.radioAddRemoveRole=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"","captionsList":"<%=JSPLib.ToJSValue(sp.translate("MSG_SIMULATE_ADDING_ROLE"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("MSG_SIMULATE_REMOVING_ROLE"),false,true)%>","class_Css":"radio myradio","create_undercond":"","ctrlid":"<%=idPortlet%>_radioAddRemoveRole","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":61,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"1","layer":false,"layout_steps_values":{},"name":"radioAddRemoveRole","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"numeric","valuesList":"1,0","visible":true,"w":206,"x":289,"y":53,"zindex":"9"});
this.radioAddRemoveRole.Value(<%=radioAddRemoveRole%>);
this.selectRole=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_selectRole","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"selectRole","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=selectRole%>","w":113,"x":324,"y":256,"zerofilling":false,"zindex":"12","zoom":""});
this.nameRole=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nameRole","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nameRole","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nameRole,false,true)%>","w":122,"x":502,"y":52,"zerofilling":false,"zindex":"10","zoom":""});
this.cproleslink=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_cproleslink","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp-system\u002fspadministration_securitymenu_portlet.jsp","fillemptykeys":false,"fixedvars":"roleType","h":20,"hide":"false","image":"","intovars":"selectRole,nameRole","intovarsType":"N,C","keyfixedfilters":"grptype","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp-system/spadministration_securitymenu_portlet.jspcproleslink",request.getSession())%>","linkedField":"selectRole","linkedUsing":"nameRole","looselylinked":false,"n_criteria":"2","name":"cproleslink","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"code,name","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,cpgroups,default",request.getSession())%>","suggest":false,"table":"cpgroups","type":"LinkZoom","w":20,"x":628,"y":52,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.roleType=new ZtVWeb._VC(this,'roleType',null,'character','<%=JSPLib.ToJSValue(roleType,false,true)%>',false,false);
this.checkRole=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_checkRole","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"checkRole","offline":false,"page":1,"parms":"userCode=selectUser","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_getgrouplist","target":"","type":"SPLinker","w":184,"x":-1,"y":379});
this.checkRole.m_cID='<%=JSPLib.cmdHash("routine,spadministration_getgrouplist",request.getSession())%>';
this.btnaddremoverole=new ZtVWeb._BC(this,{"anchor":"top-left-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnaddremoverole_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnaddremoverole","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnaddremoverole","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_ADD_USER_TO_ROLE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":41,"x":656,"y":52,"zindex":"14"});
this.splinkeraddremoverole=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkeraddremoverole","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkeraddremoverole","offline":false,"page":1,"parms":"userCode=selectUser,groupCode=selectRole","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_togglegroupofuser","target":"","type":"SPLinker","w":184,"x":-1,"y":433});
this.splinkeraddremoverole.m_cID='<%=JSPLib.cmdHash("routine,spadministration_togglegroupofuser",request.getSession())%>';
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
<%request.setAttribute("spadministration_securitymenu_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_securitymenu_Static=function(){
if(typeof chkDisplayClosed_onChange !='undefined')this.chkDisplayClosed_onChange=chkDisplayClosed_onChange;
if(typeof cpgroupslink_GetZoomLink !='undefined')this.cpgroupslink_GetZoomLink=cpgroupslink_GetZoomLink;
if(typeof cproleslink_GetZoomLink !='undefined')this.cproleslink_GetZoomLink=cproleslink_GetZoomLink;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof radioUserGroup_onChange !='undefined')this.radioUserGroup_onChange=radioUserGroup_onChange;
if(typeof selectUser_onChange !='undefined')this.selectUser_onChange=selectUser_onChange;
if(typeof cpgroupslink_LinkBlanked !='undefined')this.cpgroupslink_LinkBlanked=cpgroupslink_LinkBlanked;
if(typeof cpuserslink_LinkBlanked !='undefined')this.cpuserslink_LinkBlanked=cpuserslink_LinkBlanked;
if(typeof cpgroupslink_LinkExecuted !='undefined')this.cpgroupslink_LinkExecuted=cpgroupslink_LinkExecuted;
if(typeof cpuserslink_LinkExecuted !='undefined')this.cpuserslink_LinkExecuted=cpuserslink_LinkExecuted;
if(typeof cproleslink_LinkExecuted !='undefined')this.cproleslink_LinkExecuted=cproleslink_LinkExecuted;
if(typeof cproleslink_LinkBlanked !='undefined')this.cproleslink_LinkBlanked=cproleslink_LinkBlanked;
if(typeof menuviewcurrent_Rendered !='undefined')this.menuviewcurrent_Rendered=menuviewcurrent_Rendered;
if(typeof getKeyLinkFromHref !='undefined')this.getKeyLinkFromHref=getKeyLinkFromHref;
if(typeof AppendSecurityPadLock !='undefined')this.AppendSecurityPadLock=AppendSecurityPadLock;
if(typeof splinkerupdate_Error !='undefined')this.splinkerupdate_Error=splinkerupdate_Error;
if(typeof splinkerupdate_Result !='undefined')this.splinkerupdate_Result=splinkerupdate_Result;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
if(typeof xmlobjPublic_QueryExecuted !='undefined')this.xmlobjPublic_QueryExecuted=xmlobjPublic_QueryExecuted;
if(typeof valueChanged !='undefined')this.valueChanged=valueChanged;
if(typeof radioAddRemoveRole_onChange !='undefined')this.radioAddRemoveRole_onChange=radioAddRemoveRole_onChange;
if(typeof btnaddremoverole_Click !='undefined')this.btnaddremoverole_Click=btnaddremoverole_Click;
if(typeof splinkeraddremoverole_Executed !='undefined')this.splinkeraddremoverole_Executed=splinkeraddremoverole_Executed;
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
this.xmlobjPublic.addRowConsumer(this.menuviewpublic);
this.xmlcurrent.addRowConsumer(this.menuviewcurrent);
this.xmlobjBase.addRowConsumer(this.MenuView);
this.cproleslink.addObserverFixedVars();
this.cproleslink.addLinkedUsingVars();
m_cProgName='spsecuritymenu';
m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
function chkDisplayClosed_onChange(){
  var containers = this.MenuView.ctrl.querySelectorAll('div.menuview_container, li.menuview_sub_open, li.menuview_sub_close');
  if (this.chkDisplayClosed.Value() ) {
    LibJavascript.CssClassNameUtils.removeClass(this.MenuView.ctrl,'hide_element_closed');
    [].forEach.call(containers, function(el) {
      if (! el.querySelector('.security_element_opened, .security_element_initialize')) {
        el.style.display = '';
      }
    }); 
  } else {
    LibJavascript.CssClassNameUtils.addClass(this.MenuView.ctrl,'hide_element_closed');
    [].forEach.call(containers, function(el) {
      if (! el.querySelector('.security_element_opened, .security_element_initialize')) {
        el.style.display = 'none';
      }
    }); 
  }
}
function cpgroupslink_GetZoomLink(offline) {
  return ZtVWeb.SPWebRootURL+'/jsp-system/spadministration_groups_zoom_portlet.jsp?';
}
function cproleslink_GetZoomLink(offline) {
  return ZtVWeb.SPWebRootURL+'/jsp-system/spadministration_groups_zoom_portlet.jsp?grptype='+URLenc(this.roleType.Value())+'&'
    		+(this.radioAddRemoveRole.Value()==1  ?'disableGroupsOf=' : 'enableGroupsOf=')+URLenc(this.selectUser.Value())+'&';//sostituisce il FixedFilter  
}
function this_Loaded(){
  this.menuviewcurrent.ctrl.style.display='none';
  this.menuviewpublic.ctrl.style.display='none';
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
  customToolbar.SetTitle(FormatMsg('MSG_WEBMENU_SAFETY',this.file.Value()||'default'));
  customToolbar.RearrangeAll();  
  this.radioUserGroup_onChange();
  LibJavascript.CssClassNameUtils.addClass(this.MenuView.ctrl,'padlock'+SPTheme.SPAdminSecurityMenuStateIconPosition);
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
  var elements = document.getElementsByClassName('security_padlock');
  while (elements.length>0) {
    if (elements[0].parentNode) {
    	elements[0].parentNode.removeChild(elements[0]);
    }
  }
  elements = document.getElementsByClassName('security_element_closed');
  while (elements.length>0) {
  	LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_closed');
  }
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
	var elements = document.getElementsByClassName('security_element_role_modified');
  while (elements.length>0) {
    LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_role_modified');
  }  
  
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
		var elements = document.getElementsByClassName('security_element_role_modified');
    while (elements.length>0) {
      LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_role_modified');
    }  
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
function menuviewcurrent_Rendered(){
  var i, currentnode, publicnode, adminnode, htmlnode;
  for(i=0;i<this.MenuView.Tree.allnodes.length;i++){
    adminnode=this.MenuView.Tree.allnodes[i];
    if (adminnode.level>-1 && adminnode.children==0 && !Empty(adminnode.nodeid)) {//level -1 e' la root node e non e' da valutare
      publicnode = this.menuviewpublic.getNodeByID(adminnode.nodeid);
      currentnode = this.menuviewcurrent.getNodeByID(adminnode.nodeid);
      htmlnode = document.getElementById(this.MenuView.id + '_' + adminnode.index + '_link');
      this.AppendSecurityPadLock(htmlnode, adminnode,!!currentnode,!publicnode);
    }
  }
	elementModified = null;
  this.lblLoading.Hide(); // l'avviso descritto prima verrà nascosto indicando così il successo dell'operazione, ovvero che son state correttamente 
}
this.MenuView.onMenuClick=function() {
  if (!Empty(this.Tree.currentnode.link)) {
    var htmlnode = document.getElementById(this.id + '_' + this.Tree.currentnode.index + '_link');
    this.form.progname.Value(this.form.getKeyLinkFromHref(htmlnode));
    if (this.form.progname.Value()!='')
    	this.form.splinkereditsecurity.Link();
  }
}
var findReportName = /[#?&]ReportName=(\w+)[&]?/;
var findTableName = /[#?&]Table=(\w+)[&]?/;
var findConfigName = /[#?&]ConfigName=(\w+)[&]?/;
function getKeyLinkFromHref( a_tag ) {
  if (a_tag.href.indexOf(window.location.origin)==0 ) {
    var resname = a_tag.pathname.substring(a_tag.pathname.lastIndexOf('/')+1);
    var tmp;
    if (resname == 'SPSmartReportPrint_portlet.jsp') { //smartreport
      if (tmp = a_tag.search.match(findReportName) ) {
        resname = 'svrp/'+tmp[1];
      } else if (r = a_tag.hash.match(findReportName) ) {
        resname = 'svrp/'+tmp[1];
      } else {
        resname = "";
      }
    } else if (resname == 'Report') { //report
      if (r = a_tag.search.match(findReportName) ) {
        resname = 'vrp/'+tmp[1];
      } else {
        resname = "";
      }
    } else if (resname == 'portalstudio.jsp') { //portalstudio
      resname="PortalStudio";    
    //config.table_vzm
    } else if (resname == 'SPPortalZoom.jsp') { //zoom online
      if (tmp = a_tag.search.match(findConfigName) ) {
        resname=tmp[1]+'.';
      } else {
        resname='default.';
      }
      if (tmp = a_tag.search.match(findTableName) ) {
        resname+=tmp[1]+'_vzm';
      } else {
        resname="";
      }
    } else if (resname.startsWith('SPPortalZoom_') ) { //zoom offline
      if (tmp = a_tag.search.match(findConfigName) ) {
        resname=tmp[1]+'.';
      } else if (tmp = a_tag.hash.match(findConfigName) ) {
        resname=tmp[1]+'.';
      } else {
        resname='default.';
      }
      if (tmp = a_tag.search.match(findTableName) ) {
        resname+=tmp[1]+'_vzm';
      } else if (tmp = a_tag.hash.match(findTableName) ) {
        resname+=tmp[1]+'_vzm';
      } else {
        resname="";
      }
    } else if (resname.endsWith('_portlet.jsp')) {
      resname = 'ps/'+resname.substring(0,resname.length-'_portlet.jsp'.length);
    } else if (resname.endsWith('.jsp')) {
      resname = 'ps/'+resname.substring(0,resname.length-'.jsp'.length);
    }
  	return resname;
  } else {
    return '';
  }
}
var lineheight=0;
function AppendSecurityPadLock(htmlnode, jselement, hasAccess,hasSecurity) {
  var padlock = document.getElementById(htmlnode.id+'_padlock');
  var _this = this;
  if (lineheight==0) {
   	lineheight = htmlnode.parentNode.offsetHeight;
  }
  if (!padlock) {
    padlock = document.createElement('a');
    padlock.id = htmlnode.id+'_padlock';
    padlock.className='security_padlock';
    padlock.href='javascript:void(0);';
//     htmlnode.parentNode.appendChild(padlock); //inserire lucchetto dopo
    htmlnode.parentNode.insertBefore(padlock,htmlnode); //inserire lucchetto prima
    padlock.onclick=function(e) {
      e = e ? e : window.event;
    	if (e.stopPropogation)
       		e.stopPropogation();
    	if (e.cancelBubble != null)
        	e.cancelBubble = true;
      if (!Empty(_this.selectRole.Value())) {
    		alert(FormatMsg('MSG_CONFIRM_ROLE_FIRST'));
  		} else {
        //toggle security
        elementModified = {nodeid :this.getAttribute('nodeid') , hadSecurity: this.getAttribute('hadSecurity')==='true', hadAccess: this.getAttribute('hadAccess')==='true'};
        _this.link.Value(this.getAttribute('link'));
        _this.hadSecurity.Value(this.getAttribute('hadSecurity'));
        _this.opensecurity.Value(elementModified.hadSecurity && elementModified.hadAccess?false:true);
        _this.code.Value(_this.m_nMenuOfGroup.Value()||_this.m_nMenuOfUser.Value())
        _this.splinkerupdate.Link();
      }
    }
  }
  if (window.elementModified && elementModified.nodeid==jselement.nodeid) { //sto scrivendo l'elemento appena modificato
    if (!elementModified.hadSecurity && ! hasSecurity) {
      alert(FormatMsg('MSG_INITIALIZATION_NOT_DID'));
    } else if (elementModified.hadSecurity && !hasSecurity) {
      alert(FormatMsg('MSG_ELEMENT_WITHOUT_SECURITY'));
    } else if (elementModified.hadSecurity && elementModified.hadAccess == hasAccess ) {
      alert(FormatMsg('MSG_SECURITY_NOT_MODIFIED'));
    }
  }
  
  padlock.setAttribute('hadAccess',hasAccess);
  padlock.setAttribute('hadSecurity',hasSecurity);
  padlock.setAttribute('link',this.getKeyLinkFromHref(htmlnode));
  padlock.setAttribute('nodeid',jselement.nodeid);
  if (Empty(this.selectRole.Value())) {
    padlock.setAttribute('originalState',JSON.stringify({'hadAccess':hasAccess,'hadSecurity':hasSecurity}));
  } else {
    var originalState = padlock.getAttribute('originalState');
    if (originalState) {
      try {
      	originalState = JSON.parse(originalState);
       	if ( originalState.hadAccess!=hasAccess || originalState.hadSecurity!=hasSecurity ) {
          LibJavascript.CssClassNameUtils.addClass(htmlnode.parentNode,'security_element_role_modified');
        }
      } catch(ee){}
      
    }
  }
  LibJavascript.CssClassNameUtils.removeClass(htmlnode.parentNode,'security_element_closed');
  if (hasSecurity) {
    if (hasAccess) {
      //{ fontFamily:'icons8_win10', value: "&#xE91C" }
      padlock.innerHTML = LibJavascript.DOM.buildIcon({type : 'img'
								, className : 'opened'
                , image : (SPTheme.SPAdmin_security_menu_opened_resource_icon?SPTheme.SPAdmin_security_menu_opened_resource_icon:'../images/icon_open_padlock.png')
                , image_attr : "no-repeat center center"
                , style : 'height:'+lineheight+'px;width:'+lineheight+'px;vertical-align:bottom;cursor:pointer;'
                , title : FormatMsg("ADMIN_CLOSE")
                , alt : FormatMsg("ADMIN_CLOSE")
                });
      htmlnode.className='security_element_opened';
    } else {
      padlock.innerHTML = LibJavascript.DOM.buildIcon({type : 'img'
                , className : 'closed'
                , image : (SPTheme.SPAdmin_security_menu_closed_resource_icon?SPTheme.SPAdmin_security_menu_closed_resource_icon:'../images/icon_closed_padlock.png')
                , image_attr : "no-repeat center center"
                , style : 'height:'+lineheight+'px;width:'+lineheight+'px;vertical-align:bottom;cursor:pointer;'
                , title : FormatMsg("ADMIN_ACTIVATE")
                , alt : FormatMsg("ADMIN_ACTIVATE")
                });
      htmlnode.className='security_element_closed';
      LibJavascript.CssClassNameUtils.addClass(htmlnode.parentNode,'security_element_closed');
    }
  } else {
    padlock.innerHTML = LibJavascript.DOM.buildIcon({type : 'img'
                , className : 'initialize'
                , image : (SPTheme.SPAdmin_security_menu_initialize_resource_icon?SPTheme.SPAdmin_security_menu_initialize_resource_icon:'../images/icon_closed_padlock.png')
                , image_attr : "no-repeat center center"
                , style : 'height:'+lineheight+'px;width:'+lineheight+'px;vertical-align:bottom;cursor:pointer;'
                , title : FormatMsg("ADMIN_RULE_OF_SECURITY")
                , alt : FormatMsg("ADMIN_RULE_OF_SECURITY")
								});
    htmlnode.className='security_element_initialize';
  }
}
function splinkerupdate_Error(cCause){
  elementModified = null; //in caso di errore devo resettare l'elemento appena modificato
  alert(cCause);
}
function splinkerupdate_Result(result){
  if (result==='true') {
    this.RefreshView();
  }
}
function RefreshView() {
  this.menuviewpublic.Blank();
  this.xmlobjPublic.Query();
}
function xmlobjPublic_QueryExecuted(){
  this.valueChanged();
}
// Funzione che ha il compito, dopo aver scelto una delle voci presenti nel menù a tendina, di prelevare il file XML contenente le pagine
// accessibili dall'utente selezionato e di invocare le opportune funzioni.
// Funzione invocata ogni volta che si seleziona una voce dal menù a tendina. Ha il compito di passare alla funzione evidenzia() il 
// valore dell'utente selezionato.
function valueChanged() {
	if (Empty(this.m_nMenuOfUser.Value()) && Empty(this.m_nMenuOfGroup.Value())) {
    var elements = document.getElementsByClassName('security_padlock');
    while (elements.length>0) {
      if (elements[0].parentNode) {
        elements[0].parentNode.removeChild(elements[0]);
      }
    }
    elements = document.getElementsByClassName('security_element_closed');
    while (elements.length>0) {
      LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_closed');
    }
    return; // se non viene selezionato alcun valore nel menù a tendina non si proseguirà con nessun'altra operazione
  } else {
    this.lblLoading.Show(); // viene mostrato a video un messaggio che avvisa il caricamento del file XML contenente le pagine accessibili dall'utente 
                // selezionato e la relativa operazione di evidenziazione di queste all'interno della sitemap
    this.menuviewcurrent.Blank();
    this.xmlcurrent.Query();
  }
	
}
this.lblLoading.Hide();
function radioAddRemoveRole_onChange(){
  this.selectRole.Value(''); //svuota il ruolo selezionato
	var elements = document.getElementsByClassName('security_element_role_modified');
  while (elements.length>0) {
    LibJavascript.CssClassNameUtils.removeClass(elements[0],'security_element_role_modified');
  }  
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

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_securitymenu_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Event_addQuery=function(parmsObj){<%=idPortlet%>.Event_addQuery.receiveFnc(parmsObj);}
window.<%=idPortlet%>.xmlobjBase.firstQuery('true');
window.<%=idPortlet%>.xmlobjPublic.firstQuery('true');
window.<%=idPortlet%>.xmlcurrent.firstQuery('false');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_securitymenu',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_securitymenu');
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
sp.endPage("spadministration_securitymenu");
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
<%! public String getJSPUID() { return "555456472"; } %>