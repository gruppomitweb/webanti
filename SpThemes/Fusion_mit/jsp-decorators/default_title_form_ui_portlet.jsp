<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u003c%\n\n\u002f\u002fGESTIONE CACHE - Demandata al chiamante che dovrebbe usare SPRrxy che setta gli header adatti al caching\n\n\u002f\u002fresponse.setHeader(\"Cache-Control\",\"public\");\n\u002f\u002fresponse.setHeader(\"Expires\",\"Sun, 17-Jan-2038 19:14:07 GMT\");\n\u002f\u002fresponse.setHeader(\"Last-Modified\",\"Sun, 05-Jan-2008 19:14:07 GMT\");\n\n%\u003e\n\nthis.waitSSVars = true;\nvar ssvars = ZtVWeb.getPortlet('default_title_form');\nif ( ssvars.length ) {\n  var idx = LibJavascript.Array.indexOf(ssvars, null, function(ptl) {\n    return !ptl.hasTitlePtl;\n  });\n  if ( idx\u003e-1 ) {\n    ssvars = ssvars[idx];\n  }\n}\n\n\u002f\u002fVariabili per settare i pulsanti da far vedere o nascondere\n\nvar canDel = ssvars.canDel;\nvar canEdit = ssvars.canEdit;\nvar canAdd = ssvars.canAdd;\n\nvar procedure = ssvars.m_cProcedure.Value();\nvar mode = ssvars.m_cMode.Value();\nvar entityType = ssvars.m_cEntityType.Value();\nvar m_nChildStatus = ssvars.m_nChildStatus;\nvar postinTitle = ssvars.postinTitle;\n\nvar showPostin = ssvars.showPostin;\n\nthis.m_nLastRec.Value(ssvars.m_nLastRec.Value());\nthis.m_nRecPos.Value(ssvars.m_nRecPos.Value());\n\nvar portlet_id=this.formid;\n\nvar show_navbar = false;\n\nvar l_actions = null;\n\nvar newTitle = \"\";\nif(!Empty(ssvars.m_cFunction.Value())){\n  newTitle += \"\u003cspan class=\\\"SubtitleLabel\\\"\u003e\"+ssvars.m_cFunction.Value() +\" \u003c\u002fspan\u003e\";\n} \nnewTitle += ssvars.m_cCaption.Value();\nthis.caption_label.Value(\"\u003cdiv style='text-overflow: ellipsis;overflow: hidden;white-space: nowrap;' title='\"+ssvars.m_cCaption.Value()+\"'\u003e\"\n                           +newTitle+\"\u003c\u002fdiv\u003e\");\n\n\nfunction SetSubTitle(p_cSubTitle) {\n  this.caption_subtitle_label.Value(p_cSubTitle);\n  return true;\n}\n\n\nfunction InitGrammar() {  \n  if (!parent.SpeechGrammar) {\n    \u002f\u002f non e' disponibile la libreria SpeechGrammar\n\t\treturn false;\n  }\n  SpeechGrammar = parent.SpeechGrammar;\n  \n  var terminiObj = {\n    campo: [], campo_V: [], campo_T: [], campo_ID: []\n  };\n  var label = '', synonymous = '', synonym;\n  var nodeList = document.querySelectorAll('.Field, .Memo, .Combobox');\n  Array.prototype.slice.call(nodeList).map(elm =\u003e {\n    if (elm.id) {\n      label = document.querySelector('label[for=' + elm.id + ']');\n      if (label) {\n        label = label.innerText.replace(':', '');\n        terminiObj.campo.push(label);\n        terminiObj.campo_V.push(elm.name);\n        terminiObj.campo_T.push(elm.getAttribute('fieldtype'));\n        terminiObj.campo_ID.push(elm.id);\n      }\n\n      synonymous = elm.getAttribute('synonymous');\n      if (synonymous) {\n        synonymous = synonymous.split(',');\n        for (var i = 0; i \u003c synonymous.length; i++) {\n          synonym = synonymous[i].trim();\n          terminiObj.campo.push(synonym);\n          terminiObj.campo_V.push(elm.name);\n          terminiObj.campo_T.push(elm.getAttribute('fieldtype'));\n          terminiObj.campo_ID.push(elm.id);\n        }\n      }\n    }\n  });\n  \n  SpeechGrammar.populateColsName(terminiObj, BoGrammar.getMinorGrammar());\n  SpeechGrammar.populateColsName(terminiObj, BoGrammar.getMainGrammar());\n  \n  var grammarConfig = {};\n  grammarConfig.containerName = window.frameElement.name;\n  grammarConfig.modal = window.frameElement ? window.frameElement.getAttribute(\"modallayer\") : false;\n  grammarConfig.type = 'bo';\n  grammarConfig.grammar = BoGrammar;\n  grammarConfig.termini = terminiObj;\n  SpeechGrammar.addGrammarConfig(grammarConfig);\n}\n\nfunction SetActions() {\n  l_actions = (typeof(GetEntityActions)!='undefined' ? GetEntityActions(): []);\n  if (l_actions && l_actions.length\u003e0) {\n    for (var ii=0; ii\u003cl_actions.length; ii++) {\n      var item  = Ctrl(l_actions[ii].id);\n      if( item )\n      \titem.parentNode.removeChild(item);\n      if (l_actions[ii].always || mode == \"new\" || mode == \"edit\" || mode == \"dialog\") {        \n         var act={\n          id: l_actions[ii].id,\n          forceid: l_actions[ii].forceid,\n        \ttitle: Translate(l_actions[ii].title),\n          tooltip: Translate(l_actions[ii].title),\n          image:l_actions[ii].img,\n          action: (function(action) {\n            return function(){\n           \t\twindow[action](document.activeElement);\n            }\n          })(l_actions[ii].action)\n        }\n        if (l_actions[ii].important)\n          this.toolbar.Append(act);\n        else this.toolbar.AppendMenuItem(act);\n      }\n    }\n  }\n}\n\nfunction HideNavBar(){\n  \u002f\u002f Nascondo la Nav bar\n  this.first.Hide();\n  this.next.Hide();\n  this.last.Hide();\n  this.prev.Hide();\n  this.back_navbar.Hide();\n  this.m_nLastRec.Hide();\n  this.m_nRecPos.Hide();\n  this.sep.Hide()\n\u002f\u002f   document.getElementById(tbl.ctrlid).style.right = \"10px\";\n}\n\nfunction ShowNavBar(){\n  \u002f\u002fmostro la Nav bar\n  this.first.Show();\n  this.next.Show();\n  this.last.Show();\n  this.prev.Show();\n  this.back_navbar.Show();\n  this.m_nLastRec.Show();\n  this.m_nRecPos.Show();\n  this.sep.Show()\n\u002f\u002f   document.getElementById(tbl.ctrlid).style.right = \"155px\";\n}\n\nfunction HideAllButtons(){\n  for(var i=0;i\u003cvalues.length;i++){\n      tbl.HideItem(values[i]);\n  }\n}\n\nfunction appendExpandReduceButton(){\n  if (ssvars.m_bShowExtendReduceBtn.Value()){\n    this.toolbar.Append({\n      id:'expandReduce',\n      title: FormatMsg('MSG_EXPAND'),\n      action:function(){ _this.expandOReduce('expandReduce');},\n      image:{ fontFamily:'icons8_win10', value: \"&#xee18\"}\n    });\n  }\n}\n\nfunction SetToolbar(){  \n  if(mode == \"edit\" || mode == \"new\" ) {\n\t\tthis.InitGrammar();\n  }\n  if(entityType == \"dialog\"){\n    this.toolbar.Append({\n      id:'ok',\n      title: FormatMsg('OK'),\n      tooltip: FormatMsg('MSG_VIEWED'),\n      action:\"javascript:SendData(\\\"save\\\")\" ,\n      image:{ fontFamily:'icons8_win10', value: \"&#xef8b\"}\n    });\n    this.appendExpandReduceButton();\n    this.toolbar.Append({\n      id:'esc',\n      title: FormatMsg('MSG_CLOSE_ONEXIT'),\n      'tooltip': FormatMsg('MSG_ESC_CLOSE'),\n      action:\"javascript:SendData(\\\"discard\\\")\",\n      image:{ fontFamily:'icons8_win10', value: \"&#xf048\"}\n    });\n    this.SetActions();\n  } else if(entityType == \"page\"){\n    \u002f\u002fle page non hanno bottoni\n  }else if(m_nChildStatus == 1){\n    if(mode == \"query\" || mode == \"view\"){\n      this.appendExpandReduceButton();\n      this.toolbar.Append({\n        id:'close',\n        title: FormatMsg('MSG_CLOSE_ONEXIT'),\n      \ttooltip: FormatMsg('MSG_CLOSE_ONEXIT'),\n        action:\"javascript:window.\"+ssvars.formid+\".Close()\" ,\n        image:{ fontFamily:'icons8_win10', value: \"&#xf048\"}\n      });\n    }else{\n      this.toolbar.Append({\n        id:'ok',\n        title: FormatMsg('OK'),\n      \ttooltip: FormatMsg('MSG_VIEWED'),\n        action:\"javascript:SendData(\\\"save\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xef8b\"}\n      });\n      this.appendExpandReduceButton();\n      this.toolbar.Append({\n        id:'close_discard',\n        title: FormatMsg('MSG_CLOSE_ONEXIT'),\n      \ttooltip: FormatMsg('MSG_ESC_CLOSE'),\n        action:\"javascript:SendData(\\\"moveto\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf048\"}\n      });\n    }\n    this.SetActions();\n  }\n  else if(mode == \"query\"){\n    if ((this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0) || (this.m_nRecPos.Value()==1 && this.m_nLastRec.Value()==1)) {\n    } else {\n    \tthis.ShowNavBar();\n    \tshow_navbar = true;\n    }\n    this.toolbar.Append({\n      id:'zoom',\n      title: FormatMsg('MSG_FORM_FUNCTION_ZOOM'),\n      tooltip: FormatMsg('MSG_ZOOM', FormatMsg('MSG_FORM_FUNCTION_ZOOM')),\n      action:\"javascript:Zoom()\" ,\n      image:{ fontFamily:'icons8_win10', value: \"&#xe9fb\"}\n    });\n    if(canEdit && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){\n      this.toolbar.Append({\n        id:'edit',\n        tooltip: FormatMsg('MSG_EDIT', FormatMsg('MSG_FORM_FUNCTION_EDIT')),\n        title: FormatMsg('MSG_FORM_FUNCTION_EDIT'),\n        action: \"javascript:SubmitListenerForm(\\\"edit\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf0ba\"}\n      });\n    }\n    if(canAdd){\n      this.toolbar.Append({\n        id:'add',\n        tooltip: FormatMsg('MSG_NEW', FormatMsg('MSG_FORM_FUNCTION_NEW')),\n        title: FormatMsg('MSG_FORM_FUNCTION_NEW'),\n        action: \"javascript:SubmitListenerForm(\\\"new\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xebed\"}\n      });\n    }\n    this.appendExpandReduceButton();\n    if(canDel  && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){\n      this.toolbar.Append({\n        id:'delete',\n        tooltip: FormatMsg('MSG_DELETE'),\n        title: FormatMsg('MSG_DELETE_TOOLTIP'),\n        action: \"javascript:SubmitListenerForm(\\\"delete\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf041\"}\n      });\n    }\n    this.SetActions();\n    if(ssvars.m_bHasPrintProc.Value() == \"true\"  && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){\n      this.toolbar.Append({\n        id:'print',\n        tooltip: FormatMsg('MSG_PRINT'),\n        title: FormatMsg('MSG_VZM_PRINT'),\n        action: \"javascript:PrintPrg()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xec0b\"}\n      });\n    }\n    if(ssvars.m_bCanEditSecurity.Value() == \"true\"){\n      this.toolbar.Append({\n        id:'security',\n        tooltip: FormatMsg('MSG_SECURITY'),\n        title: FormatMsg('CP_SECURITY'),\n        action:\"javascript:RunSecurity()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xef7b\"}\n      });\n      this.toolbar.Append({\n        id:'extender',\n        tooltip: FormatMsg('MSG_TABLEEXTENDER'),\n        title: FormatMsg('MSG_TABLEEXTENDER'),\n        action:\"javascript:ExtendTable()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf10d\"}\n      });\n    }\n    \u002f\u002f if(ssvars.m_bCanCreateAlterInterface.Value() == \"true\"){\n      \u002f\u002f tbl.SetItem(\"altint\",{link:\"javascript:CreatePortlet()\"},true);\n    \u002f\u002f }\n    if(showPostin  && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){\n      this.toolbar.Append({\n        id:'postin',\n        title: postinTitle,\n        tooltip: postinTitle,\n        action:\"javascript:PostinButtonClick()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xee04\"}\n      });\n    }\n  }\n  else if(mode == \"edit\" || mode == \"new\"){\n    this.toolbar.Append({\n      id:'save',\n      tooltip: FormatMsg('MSG_SAVE'),\n      title: FormatMsg('MSG_VZM_SAVE'),\n      action:\"javascript:SendData(\\\"save\\\")\",\n      image:{ fontFamily:'icons8_win10', value: \"&#xecb3\"}\n    });\n    this.appendExpandReduceButton()\n    if(ssvars.m_cAtExit.Value() == \"\"){\n      this.toolbar.Append({\n        id:'query',\n        tooltip: FormatMsg('MSG_ESC_QUERY', FormatMsg('MSG_FORM_FUNCTION_QUERY')),\n        title: FormatMsg('MSG_FORM_FUNCTION_QUERY'),\n        action:\"javascript:SendData(\\\"moveto\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xe950\"}\n      });\n    }else{\n      this.toolbar.Append({\n        id:'close_discard',\n        tooltip: FormatMsg('MSG_CANCEL'),\n        title: FormatMsg('ADMIN_CANCEL'),\n        action:\"javascript:SendData(\\\"moveto\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf048\"}\n      });\n    }\n    this.SetActions();\n    if(showPostin){\n      this.toolbar.Append({\n        id:'postin',\n        title: postinTitle,\n        tooltip: postinTitle,\n        action:\"javascript:PostinButtonClick()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xee04\"}\n      });\n    }\n  }\n  else if(mode == \"view\"){\n    this.toolbar.Append({\n      id:'close_ok',\n      title: FormatMsg('MSG_CLOSE_ONEXIT'),\n      tooltip: FormatMsg('MSG_ESC_CLOSE'),\n      action:\"javascript:SendData(\\\"discard\\\")\",\n      image:{ fontFamily:'icons8_win10', value: \"&#xf048\"}\n    });\n    if(canEdit){\n      this.toolbar.Append({\n        id:'edit',\n        tooltip: FormatMsg('MSG_EDIT', FormatMsg('MSG_FORM_FUNCTION_EDIT')),\n        title: FormatMsg('MSG_FORM_FUNCTION_EDIT'),\n        action:\"javascript:SubmitListenerForm(\\\"edit\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf0ba\"}\n      });\n    }\n    this.appendExpandReduceButton()\n    if (canDel) {\n      this.toolbar.Append({\n        id:'delete',\n        tooltip: FormatMsg('MSG_DELETE'),\n        title: FormatMsg('MSG_DELETE_TOOLTIP'),\n        action: \"javascript:SubmitListenerForm(\\\"delete\\\")\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xf041\"}\n      });\n    }\n    this.SetActions();\n    if(ssvars.m_bHasPrintProc.Value() == \"true\"){\n      this.toolbar.Append({\n        id:'print',\n        tooltip: FormatMsg('MSG_PRINT'),\n        title: FormatMsg('MSG_VZM_PRINT'),\n        action:\"javascript:PrintPrg()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xec0b\"}\n      });\n    }\n    if(showPostin){\n      this.toolbar.Append({\n        id:'postin',\n        title: postinTitle,\n        tooltip: postinTitle,\n        action:\"javascript:PostinButtonClick()\",\n        image:{ fontFamily:'icons8_win10', value: \"&#xee04\"}\n      });\n    }\n  }\n  if (entityType!='page'){\n    if (ssvars.m_bShowNotifyBtn.Value()){\n      this.toolbar.Append({\n          id:'toggleNotify',\n          title: FormatMsg('MSG_SHOW_NOTIFY'),\n        \taction:function(){ _this.toggleNotify();},\n          image:{ fontFamily:'icons8_win10', value: \"&#xf56d\"}\n        });\n    }\n  }\n  ssvars.AppendCustomButton(this.toolbar);\n}\n\nfunction toggleNotify(){\n  if (ToggleNotifyContainer()){\n    this.toolbar.UpdateItem('toggleNotify',{\n     title:FormatMsg('MSG_HIDE_NOTIFY')\n    })\n  }\n  else {\n\t\tthis.toolbar.UpdateItem('toggleNotify',{\n     title:FormatMsg('MSG_SHOW_NOTIFY')\n    })\n  }\n}\n\nfunction expandOReduce(){\n  if (isMaskExpand()){\n    this.toolbar.UpdateItem('expandReduce',{\n     image:{ fontFamily:'icons8_win10', value: \"&#xee18\"},\n     title:FormatMsg('MSG_EXPAND')\n    })\n  }\n  else {\n   \tthis.toolbar.UpdateItem('expandReduce',{\n     image:{ fontFamily:'icons8_win10', value: \"&#xefd2\"},\n     title:FormatMsg('MSG_REDUCE')\n    })                       \n  }\n                            \n    \n  ExpandReduce();\n}\n\n\nfunction resizeCaption(){  \n  var backNCR = this.back_navbar.Ctrl.getBoundingClientRect();  \n  if (backNCR.width==0){\n   \tthis.toolbar.Ctrl.style.width='200px';\n  }\n  else {\n    var right = this.toolbar.Ctrl.clientWidth;\n    this.back_navbar.Ctrl.style.right = right + 'px';\n    backNCR = this.back_navbar.Ctrl.getBoundingClientRect();  \n    right += backNCR.width;\n    this.caption_label.Ctrl.style.right = right + 'px';\n  }\n}\n\nfunction m_nRecPos_Lostfocus(){\n  SelectRecordPortlet(this.m_nLastRec.Value(),this.m_nRecPos.Value());\n}\n\nvar _this = this;\nvar create = false;\nfunction StartPortlet() {\n  create = true;\n  this.HideNavBar();\n  this.SetToolbar.call(this);\n  \u002f\u002fthis.SetActions();\n  \u002f\u002fthis.resizeCaption();\n}\nif (document.readyState=='complete' || document.readyState=='loaded' || document.readyState=='interactive') {\n  this.this_Loaded=this.StartPortlet;\n} else {\n  LibJavascript.Events.addEvent(document,'readystatechange',function(){\n    if (document.readyState=='complete') {\n      _this.StartPortlet();\n    }\n  });\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"TitleForm","css_code":"[{\"type\":\"box\",\"name\":\"back_navbar_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"border_width\\\":\\\"0\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"back_navbar_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:140px; height:42px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"border_width\\\":\\\"0\\\"}\",\"code\":\".back_navbar_class{background-size: cover;}\\n\"},{\"type\":\"image\",\"name\":\"prev_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_top\\\":\\\"1\\\",\\\"pad_bottom\\\":\\\"5\\\",\\\"pad_left\\\":\\\"6\\\",\\\"pad_right\\\":\\\"9\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"src\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"image0\\\",\\\"type\\\":\\\"Image\\\",\\\"class_name\\\":\\\"prev_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:24px; height:18px;\\\\\\\" \u003e\u003cimg src=\\\\\\\"undefined\\\\\\\" width=\\\\\\\"24\\\\\\\" height=\\\\\\\"18\\\\\\\"\u002f\u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"src\\\":\\\".\u002fimages\u002fdefault.jpg\\\",\\\"page\\\":1,\\\"pad_top\\\":\\\"1\\\",\\\"pad_bottom\\\":\\\"5\\\",\\\"pad_left\\\":\\\"6\\\",\\\"pad_right\\\":\\\"9\\\"}\",\"code\":\".prev_class{padding: 1px 9px 5px 6px;}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"62","hsl":"","htmlcode":"{{ caption_label }}\n{{ caption_subtitle_label }}\n{{ m_nLastRec }}\n{{ m_nRecPos }}\n{{ first }}\n{{ next }}\n{{ last }}\n{{ prev }}\n{{ clientsideinclusion }}\n{{ toolbar }}\n{{ back_navbar }}\n{{ sep }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"400","layout_steps_values":"{\"400\":{\"h\":\"62\",\"w\":\"100%\"},\"600\":{\"h\":\"62\",\"w\":\"100%\"},\"800\":{\"h\":\"62\",\"w\":\"100%\"},\"900\":{\"h\":\"40\",\"w\":\"100%\"}}","lock_items":"","manifest":"","max_w":"","min_w":"","my_library":".\u002fgrammars\u002flib\u002fPorterStemmerIt.es5.js,.\u002fgrammars\u002flib\u002frailroadgrammar.es5.js,.\u002fgrammars\u002flib\u002fparse_functions.js,.\u002fgrammars\u002fbase.js,.\u002fgrammars\u002fbo.js","offline":"","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"600,800,400","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"align":"","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"400\":{\"x\":20,\"y\":11,\"w\":170,\"h\":22,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"hide\":\"\",\"align\":\"\"},\"600\":{\"x\":20,\"y\":11,\"w\":\"220\",\"h\":22,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"align\":\"\",\"hide\":\"\"},\"800\":{\"x\":20,\"y\":11,\"w\":\"245\",\"h\":22,\"anchor\":\"top-left-right\",\"hide\":\"false\",\"align\":\"\",\"n_col\":\"\",\"fontpct\":\"\"},\"900\":{\"x\":8,\"y\":7,\"w\":230,\"h\":29,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"align\":\"left\",\"hide\":\"false\"}}","n_col":"1","name":"caption_label","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","template_code":"","type":"Label","value":"caption","w":"170","wireframe_props":"align,value,n_col","x":"20","y":"11","zindex":"2"},{"align":"","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"CaptionSubTitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"400\":{\"x\":20,\"y\":32,\"w\":170,\"h\":20,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"hide\":\"\",\"align\":\"\"},\"600\":{\"x\":20,\"y\":32,\"w\":\"220\",\"h\":20,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"align\":\"\",\"hide\":\"\"},\"800\":{\"x\":20,\"y\":32,\"w\":\"245\",\"h\":20,\"anchor\":\"top-left-right\",\"hide\":\"false\",\"align\":\"\",\"n_col\":\"\",\"fontpct\":\"\"},\"900\":{\"x\":8,\"y\":7,\"w\":230,\"h\":29,\"anchor\":\"top-left-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"align\":\"left\",\"hide\":\"false\"}}","n_col":"1","name":"caption_subtitle_label","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"170","wireframe_props":"align,value,n_col","x":"20","y":"32","zindex":"2"},{"anchor":"top-right","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"TitleTextbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"18","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{\"400\":{\"x\":269,\"y\":22,\"w\":30,\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"},\"600\":{\"x\":320,\"y\":22,\"w\":\"30\",\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"},\"800\":{\"x\":355,\"y\":21,\"w\":\"30\",\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"},\"900\":{\"x\":348,\"y\":10,\"w\":\"30\",\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"}}","maxlength":"","name":"m_nLastRec","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"3","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"30","wireframe_props":"name","x":"269","y":"22","zerofilling":"false","zindex":"3"},{"anchor":"top-right","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"TitleTextbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"18","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{\"400\":{\"x\":229,\"y\":22,\"w\":30,\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"},\"600\":{\"x\":281,\"y\":22,\"w\":\"30\",\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"},\"800\":{\"x\":314,\"y\":21,\"w\":\"30\",\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"},\"900\":{\"x\":307,\"y\":10,\"w\":\"30\",\"h\":18,\"anchor\":\"top-right\",\"hide\":\"true\"}}","maxlength":"","name":"m_nRecPos","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"30","wireframe_props":"name","x":"229","y":"22","zerofilling":"false","zindex":"3"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"TitleIcon","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf092;","font_image_hover":"","font_name":"icons8_win10","font_size":"18","h":"30","help_tips":"MSG_FIRST","hide":"true","hide_undercond":"","href":"javascript:RecSeek('first')","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"400\":{\"x\":193,\"y\":18,\"w\":18,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"18\"},\"600\":{\"x\":246,\"y\":18,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"},\"800\":{\"x\":277,\"y\":16,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"\"},\"900\":{\"x\":270,\"y\":5,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"}}","name":"first","page":"1","path_type":"skin","sequence":"5","server_side":"","src":"..\u002ftitle_toolbar\u002ffirst.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"193","y":"18","zindex":"3"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"TitleIcon","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf145;","font_image_hover":"","font_name":"icons8_win10","font_size":"18","h":"30","help_tips":"MSG_NEXT","hide":"true","hide_undercond":"","href":"javascript:RecSeek('next')","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"400\":{\"x\":299,\"y\":18,\"w\":18,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"18\"},\"600\":{\"x\":350,\"y\":18,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"},\"800\":{\"x\":386,\"y\":16,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"\"},\"900\":{\"x\":379,\"y\":5,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"}}","name":"next","page":"1","path_type":"skin","sequence":"6","server_side":"","src":"..\u002ftitle_toolbar\u002fnext.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"299","y":"18","zindex":"3"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"TitleIcon","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf093;","font_image_hover":"","font_name":"icons8_win10","font_size":"18","h":"30","help_tips":"MSG_LAST","hide":"true","hide_undercond":"","href":"javascript:RecSeek('last')","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"400\":{\"x\":316,\"y\":18,\"w\":18,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"18\"},\"600\":{\"x\":367,\"y\":18,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"},\"800\":{\"x\":404,\"y\":16,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"\"},\"900\":{\"x\":397,\"y\":5,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"}}","name":"last","page":"1","path_type":"skin","sequence":"7","server_side":"","src":"..\u002ftitle_toolbar\u002flast.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"316","y":"18","zindex":"3"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"TitleIcon","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf144;","font_image_hover":"","font_name":"icons8_win10","font_size":"18","h":"30","help_tips":"MSG_PREVIOUS","hide":"true","hide_undercond":"","href":"javascript:RecSeek('previous')","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"400\":{\"x\":210,\"y\":18,\"w\":18,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"18\"},\"600\":{\"x\":263,\"y\":18,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"},\"800\":{\"x\":295,\"y\":16,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\",\"font_size\":\"\"},\"900\":{\"x\":288,\"y\":5,\"w\":\"18\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"true\"}}","name":"prev","page":"1","path_type":"skin","sequence":"8","server_side":"","src":"..\u002ftitle_toolbar\u002fprev.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"210","y":"18","zindex":"3"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"clientsideinclusion","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"741","y":"-31"},{"FAB":"","anchor":"top-right","bg_color":"","css_class":"form_title_toolbar","h":"40","hide":"","iconWidth":"26","layer":"false","layout_steps_values":"{\"400\":{\"x\":338,\"y\":11,\"w\":62,\"h\":40,\"anchor\":\"top-right\",\"hide\":\"\"},\"600\":{\"x\":392,\"y\":11,\"w\":\"208\",\"h\":40,\"anchor\":\"top-right\",\"hide\":\"\"},\"800\":{\"x\":430,\"y\":11,\"w\":\"370\",\"h\":40,\"anchor\":\"top-right\",\"hide\":\"false\"},\"900\":{\"x\":444,\"y\":0,\"w\":\"456\",\"h\":40,\"anchor\":\"top-right\",\"hide\":\"false\"}}","maxToolbarItem":"","menu_bg_color":"","name":"toolbar","page":"1","sequence":"10","toolbarAlign":"","type":"SPToolbar","w":"62","wireframe_props":"","x":"338","y":"11","zindex":"1"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"back_navbar_class","create_undercond":"","h":"40","hide":"","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{\"400\":{\"x\":190,\"y\":11,\"w\":147,\"h\":40,\"anchor\":\"top-right\",\"hide\":\"\"},\"600\":{\"x\":242,\"y\":11,\"w\":146,\"h\":40,\"anchor\":\"top-right\",\"hide\":\"\"},\"800\":{\"x\":268,\"y\":11,\"w\":\"162\",\"h\":40,\"anchor\":\"top-right\",\"hide\":\"true\"},\"900\":{\"x\":242,\"y\":0,\"w\":\"200\",\"h\":40,\"anchor\":\"top-right\",\"hide\":\"true\"}}","name":"back_navbar","page":"1","sequence":"11","shrinkable":"","stretch":"false","target":"","type":"Box","w":"147","wireframe_props":"","x":"190","y":"11","zindex":"0"},{"align":"","anchor":"top-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"400\":{\"x\":259,\"y\":18,\"w\":10,\"h\":21,\"anchor\":\"top-right\",\"n_col\":\"1\",\"fontpct\":\"\",\"hide\":\"true\",\"align\":\"\"},\"600\":{\"x\":311,\"y\":18,\"w\":\"10\",\"h\":21,\"n_col\":\"1\",\"fontpct\":\"\",\"anchor\":\"top-right\",\"align\":\"\",\"hide\":\"true\"},\"800\":{\"x\":345,\"y\":19,\"w\":\"10\",\"h\":29,\"anchor\":\"top-right\",\"hide\":\"true\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"900\":{\"x\":338,\"y\":8,\"w\":\"10\",\"h\":29,\"n_col\":\"1\",\"fontpct\":\"\",\"anchor\":\"top-right\",\"align\":\"center\",\"hide\":\"true\"}}","n_col":"1","name":"sep","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","tabindex":"","target":"","template_code":"","type":"Label","value":"-","w":"10","wireframe_props":"align,value,n_col","x":"259","y":"18","zindex":"5"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:m_nLastRec,m_nRecPos,clientsideinclusion*/%>
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
.default_title_form_ui_container .back_navbar_class{  border: 0;
  background-size: cover;
}
.default_title_form_ui_container .prev_class{
  padding-top: 1px;
  padding-right: 9px;
  padding-bottom: 5px;
  padding-left: 6px;
}
.default_title_form_ui_container {
}
.default_title_form_ui_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:62px;
}
.default_title_form_ui_portlet[Data-page="1"]{
  height:62px;
  width:100%;
}
.default_title_form_ui_portlet[Data-step="600"] {
  height:62px;
  width:100%;
}
.default_title_form_ui_portlet[Data-step="800"] {
  height:62px;
  width:100%;
}
.default_title_form_ui_portlet[Data-step="400"] {
  height:62px;
  width:100%;
}
.default_title_form_ui_portlet[Data-step="400"] > .caption_label_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:11px;
  left:20px;
  right:210px;
  width:auto;
  height:auto;
  min-height:22px;
}.default_title_form_ui_portlet[Data-step="400"] > .caption_label_ctrl {
  height:auto;
  min-height:22px;
}
.default_title_form_ui_portlet[Data-step="600"] > .caption_label_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:11px;
  left:20px;
  right:360px;
  width:auto;
  height:auto;
  min-height:22px;
}.default_title_form_ui_portlet[Data-step="600"] > .caption_label_ctrl {
  height:auto;
  min-height:22px;
}
.default_title_form_ui_portlet[Data-step="800"] > .caption_label_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:11px;
  left:20px;
  right:535px;
  width:auto;
  height:auto;
  min-height:22px;
}.default_title_form_ui_portlet[Data-step="800"] > .caption_label_ctrl {
  height:auto;
  min-height:22px;
}
.default_title_form_ui_portlet > .caption_label_ctrl {
  overflow:hidden;
}
.default_title_form_ui_portlet[Data-step="400"] > .caption_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="600"] > .caption_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="800"] > .caption_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="900"] > .caption_label_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="400"] > .caption_subtitle_label_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:32px;
  left:20px;
  right:210px;
  width:auto;
  height:auto;
  min-height:20px;
}.default_title_form_ui_portlet[Data-step="400"] > .caption_subtitle_label_ctrl {
  height:auto;
  min-height:20px;
}
.default_title_form_ui_portlet[Data-step="600"] > .caption_subtitle_label_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:32px;
  left:20px;
  right:360px;
  width:auto;
  height:auto;
  min-height:20px;
}.default_title_form_ui_portlet[Data-step="600"] > .caption_subtitle_label_ctrl {
  height:auto;
  min-height:20px;
}
.default_title_form_ui_portlet[Data-step="800"] > .caption_subtitle_label_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:32px;
  left:20px;
  right:535px;
  width:auto;
  height:auto;
  min-height:20px;
}.default_title_form_ui_portlet[Data-step="800"] > .caption_subtitle_label_ctrl {
  height:auto;
  min-height:20px;
}
.default_title_form_ui_portlet > .caption_subtitle_label_ctrl {
  overflow:hidden;
}
.default_title_form_ui_portlet[Data-step="400"] > .caption_subtitle_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="600"] > .caption_subtitle_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="800"] > .caption_subtitle_label_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="900"] > .caption_subtitle_label_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="400"] > .m_nLastRec_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:22px;
  right:101px;
  width:30px;
  height:18px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="600"] > .m_nLastRec_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:22px;
  right:250px;
  width:30px;
  height:18px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="800"] > .m_nLastRec_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:21px;
  right:415px;
  width:30px;
  height:18px;
  display:none;
}
.default_title_form_ui_portlet > .m_nLastRec_ctrl {
}
.default_title_form_ui_portlet > .m_nLastRec_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.default_title_form_ui_portlet[Data-step="400"] > .m_nRecPos_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:22px;
  right:141px;
  width:30px;
  height:18px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="600"] > .m_nRecPos_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:22px;
  right:289px;
  width:30px;
  height:18px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="800"] > .m_nRecPos_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:21px;
  right:456px;
  width:30px;
  height:18px;
  display:none;
}
.default_title_form_ui_portlet > .m_nRecPos_ctrl {
}
.default_title_form_ui_portlet > .m_nRecPos_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.default_title_form_ui_portlet[Data-step="400"] > .first_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:189px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="600"] > .first_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:336px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="800"] > .first_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:16px;
  right:505px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet > .first_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .first_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="600"] > .first_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="800"] > .first_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="900"] > .first_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .next_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:83px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="600"] > .next_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:232px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="800"] > .next_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:16px;
  right:396px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet > .next_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .next_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="600"] > .next_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="800"] > .next_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="900"] > .next_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .last_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:66px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="600"] > .last_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:215px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="800"] > .last_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:16px;
  right:378px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet > .last_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .last_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="600"] > .last_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="800"] > .last_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="900"] > .last_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .prev_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:172px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="600"] > .prev_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  right:319px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet[Data-step="800"] > .prev_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:16px;
  right:487px;
  width:18px;
  height:30px;
  display:none;
}
.default_title_form_ui_portlet > .prev_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .prev_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="600"] > .prev_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="800"] > .prev_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="900"] > .prev_ctrl {
  line-height:30px;
  font-size:18px;
}
.default_title_form_ui_portlet[Data-step="400"] > .toolbar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  right:0px;
  width:62px;
  height:40px;
}
.default_title_form_ui_portlet[Data-step="600"] > .toolbar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  right:0px;
  width:208px;
  height:40px;
}
.default_title_form_ui_portlet[Data-step="800"] > .toolbar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  right:0px;
  width:370px;
  height:40px;
}
.default_title_form_ui_portlet[Data-step="400"] > .back_navbar_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:11px;
  right:63px;
  width:147px;
  height:auto;
  min-height:40px;
}.default_title_form_ui_portlet[Data-step="400"] > .back_navbar_ctrl {
  height:40px;
  display:flex;
  flex-direction:column;
}
.default_title_form_ui_portlet > .back_navbar_ctrl > .box_content {
  height:100%;
}
.default_title_form_ui_portlet[Data-step="600"] > .back_navbar_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:11px;
  right:212px;
  width:146px;
  height:auto;
  min-height:40px;
}.default_title_form_ui_portlet[Data-step="600"] > .back_navbar_ctrl {
  height:40px;
  display:flex;
  flex-direction:column;
}
.default_title_form_ui_portlet > .back_navbar_ctrl > .box_content {
  height:100%;
}
.default_title_form_ui_portlet[Data-step="800"] > .back_navbar_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:11px;
  right:370px;
  width:162px;
  height:auto;
  min-height:40px;
  display:none;
}.default_title_form_ui_portlet[Data-step="800"] > .back_navbar_ctrl {
  height:40px;
  display:flex;
  flex-direction:column;
}
.default_title_form_ui_portlet > .back_navbar_ctrl > .box_content {
  height:100%;
}
.default_title_form_ui_portlet > .back_navbar_ctrl {
  min-height:40px;
}
.default_title_form_ui_portlet[Data-step="400"] > .sep_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  right:131px;
  width:10px;
  height:auto;
  min-height:21px;
  display:none;
}.default_title_form_ui_portlet[Data-step="400"] > .sep_ctrl {
  height:auto;
  min-height:21px;
}
.default_title_form_ui_portlet[Data-step="600"] > .sep_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  right:279px;
  width:10px;
  height:auto;
  min-height:21px;
  display:none;
}.default_title_form_ui_portlet[Data-step="600"] > .sep_ctrl {
  height:auto;
  min-height:21px;
}
.default_title_form_ui_portlet[Data-step="800"] > .sep_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:19px;
  right:445px;
  width:10px;
  height:auto;
  min-height:29px;
  display:none;
}.default_title_form_ui_portlet[Data-step="800"] > .sep_ctrl {
  height:auto;
  min-height:29px;
}
.default_title_form_ui_portlet > .sep_ctrl {
  overflow:hidden;
}
.default_title_form_ui_portlet[Data-step="400"] > .sep_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="600"] > .sep_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="800"] > .sep_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.default_title_form_ui_portlet[Data-step="900"] > .sep_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
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
 String def="[{\"h\":\"62\",\"layout_steps_values\":{\"400\":{\"h\":\"62\",\"w\":\"100%\"},\"600\":{\"h\":\"62\",\"w\":\"100%\"},\"800\":{\"h\":\"62\",\"w\":\"100%\"},\"900\":{\"h\":\"40\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"600,800,400\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"\",\"anchor\":\"top-left-right\",\"h\":\"22\",\"layout_steps_values\":{\"400\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":22,\"hide\":\"\",\"n_col\":\"1\",\"w\":170,\"x\":20,\"y\":11},\"600\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":22,\"hide\":\"\",\"n_col\":\"1\",\"w\":\"220\",\"x\":20,\"y\":11},\"800\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":22,\"hide\":\"false\",\"n_col\":\"\",\"w\":\"245\",\"x\":20,\"y\":11},\"900\":{\"align\":\"left\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":29,\"hide\":\"false\",\"n_col\":\"1\",\"w\":230,\"x\":8,\"y\":7}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"caption\",\"w\":\"170\",\"x\":\"20\",\"y\":\"11\",\"zindex\":\"2\"},{\"align\":\"\",\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{\"400\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"\",\"n_col\":\"1\",\"w\":170,\"x\":20,\"y\":32},\"600\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"\",\"n_col\":\"1\",\"w\":\"220\",\"x\":20,\"y\":32},\"800\":{\"align\":\"\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"\",\"w\":\"245\",\"x\":20,\"y\":32},\"900\":{\"align\":\"left\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":29,\"hide\":\"false\",\"n_col\":\"1\",\"w\":230,\"x\":8,\"y\":7}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"170\",\"x\":\"20\",\"y\":\"32\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":30,\"x\":269,\"y\":22},\"600\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":\"30\",\"x\":320,\"y\":22},\"800\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":\"30\",\"x\":355,\"y\":21},\"900\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":\"30\",\"x\":348,\"y\":10}},\"name\":\"m_nLastRec\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"30\",\"x\":\"269\",\"y\":\"22\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":30,\"x\":229,\"y\":22},\"600\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":\"30\",\"x\":281,\"y\":22},\"800\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":\"30\",\"x\":314,\"y\":21},\"900\":{\"anchor\":\"top-right\",\"h\":18,\"hide\":\"true\",\"w\":\"30\",\"x\":307,\"y\":10}},\"name\":\"m_nRecPos\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"30\",\"x\":\"229\",\"y\":\"22\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"font_size\":\"18\",\"h\":30,\"hide\":\"true\",\"w\":18,\"x\":193,\"y\":18},\"600\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":246,\"y\":18},\"800\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":277,\"y\":16},\"900\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":270,\"y\":5}},\"name\":\"first\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"193\",\"y\":\"18\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"font_size\":\"18\",\"h\":30,\"hide\":\"true\",\"w\":18,\"x\":299,\"y\":18},\"600\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":350,\"y\":18},\"800\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":386,\"y\":16},\"900\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":379,\"y\":5}},\"name\":\"next\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"299\",\"y\":\"18\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"font_size\":\"18\",\"h\":30,\"hide\":\"true\",\"w\":18,\"x\":316,\"y\":18},\"600\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":367,\"y\":18},\"800\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":404,\"y\":16},\"900\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":397,\"y\":5}},\"name\":\"last\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"316\",\"y\":\"18\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"font_size\":\"18\",\"h\":30,\"hide\":\"true\",\"w\":18,\"x\":210,\"y\":18},\"600\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":263,\"y\":18},\"800\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":295,\"y\":16},\"900\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"true\",\"w\":\"18\",\"x\":288,\"y\":5}},\"name\":\"prev\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"210\",\"y\":\"18\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"clientsideinclusion\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"741\",\"y\":\"-31\"},{\"anchor\":\"top-right\",\"h\":\"40\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"\",\"w\":62,\"x\":338,\"y\":11},\"600\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"\",\"w\":\"208\",\"x\":392,\"y\":11},\"800\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"false\",\"w\":\"370\",\"x\":430,\"y\":11},\"900\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"false\",\"w\":\"456\",\"x\":444,\"y\":0}},\"name\":\"toolbar\",\"page\":\"1\",\"type\":\"SPToolbar\",\"w\":\"62\",\"x\":\"338\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"40\",\"layout_steps_values\":{\"400\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"\",\"w\":147,\"x\":190,\"y\":11},\"600\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"\",\"w\":146,\"x\":242,\"y\":11},\"800\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"true\",\"w\":\"162\",\"x\":268,\"y\":11},\"900\":{\"anchor\":\"top-right\",\"h\":40,\"hide\":\"true\",\"w\":\"200\",\"x\":242,\"y\":0}},\"name\":\"back_navbar\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"147\",\"x\":\"190\",\"y\":\"11\",\"zindex\":\"0\"},{\"align\":\"\",\"anchor\":\"top-right\",\"h\":\"21\",\"layout_steps_values\":{\"400\":{\"align\":\"\",\"anchor\":\"top-right\",\"fontpct\":\"\",\"h\":21,\"hide\":\"true\",\"n_col\":\"1\",\"w\":10,\"x\":259,\"y\":18},\"600\":{\"align\":\"\",\"anchor\":\"top-right\",\"fontpct\":\"\",\"h\":21,\"hide\":\"true\",\"n_col\":\"1\",\"w\":\"10\",\"x\":311,\"y\":18},\"800\":{\"align\":\"center\",\"anchor\":\"top-right\",\"fontpct\":\"\",\"h\":29,\"hide\":\"true\",\"n_col\":\"1\",\"w\":\"10\",\"x\":345,\"y\":19},\"900\":{\"align\":\"center\",\"anchor\":\"top-right\",\"fontpct\":\"\",\"h\":29,\"hide\":\"true\",\"n_col\":\"1\",\"w\":\"10\",\"x\":338,\"y\":8}},\"n_col\":\"1\",\"name\":\"sep\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"-\",\"w\":\"10\",\"x\":\"259\",\"y\":\"18\",\"zindex\":\"5\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"default_title_form_ui","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default_title_form_ui_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.default_title_form_ui_portlet > .m_nLastRec_ctrl {
  display:none;
}
.default_title_form_ui_portlet > .m_nRecPos_ctrl {
  display:none;
}
.default_title_form_ui_portlet > .first_ctrl {
  display:none;
}
.default_title_form_ui_portlet > .next_ctrl {
  display:none;
}
.default_title_form_ui_portlet > .last_ctrl {
  display:none;
}
.default_title_form_ui_portlet > .prev_ctrl {
  display:none;
}
.default_title_form_ui_portlet > .sep_ctrl {
  display:none;
}

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/lib/PorterStemmerIt.es5.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/lib/railroadgrammar.es5.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/lib/parse_functions.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/base.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("./grammars/bo.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','default_title_form_ui','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String caption_label= "caption";
String caption_subtitle_label= "";
String m_nLastRec=JSPLib.translateXSS(sp.getParameter("m_nLastRec",""));
if(request.getAttribute("default_title_form_ui_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
double m_nRecPos=sp.getParameter("m_nRecPos",0);
String clientsideinclusion=JSPLib.translateXSS(sp.getParameter("clientsideinclusion",""));
String sep= "-";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='default_title_form_ui_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='default_title_form_ui_portlet TitleForm' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('default_title_form_ui','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_caption_label'  formid='<%=idPortlet%>' ps-name='caption_label'    class='TitleLabel caption_label_ctrl'><div id='<%=idPortlet%>_caption_labeltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("caption"))%></div></span>
<span id='<%=idPortlet%>_caption_subtitle_label'  formid='<%=idPortlet%>' ps-name='caption_subtitle_label'    class='CaptionSubTitleLabel caption_subtitle_label_ctrl'><div id='<%=idPortlet%>_caption_subtitle_labeltbl' style='width:100%;'></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_nLastRec_wrp'><input id='<%=idPortlet%>_m_nLastRec' name='m_nLastRec' type='text' disabled class='TitleTextbox' formid='<%=idPortlet%>' ps-name='m_nLastRec' /></span>
<span class='textbox-container'id='<%=idPortlet%>_m_nRecPos_wrp'><input id='<%=idPortlet%>_m_nRecPos' name='m_nRecPos' type='text' class='TitleTextbox' formid='<%=idPortlet%>' ps-name='m_nRecPos' inputmode='numeric' /></span>
<a id='<%=idPortlet%>_first' class='TitleIcon first_ctrl'  href='javascript:RecSeek('first')' target='_self'>&#xf092;</a>
<a id='<%=idPortlet%>_next' class='TitleIcon next_ctrl'  href='javascript:RecSeek('next')' target='_self'>&#xf145;</a>
<a id='<%=idPortlet%>_last' class='TitleIcon last_ctrl'  href='javascript:RecSeek('last')' target='_self'>&#xf093;</a>
<a id='<%=idPortlet%>_prev' class='TitleIcon prev_ctrl'  href='javascript:RecSeek('previous')' target='_self'>&#xf144;</a>
<div id='<%=idPortlet%>_toolbar' class='disable-selection ctrl_form_title_toolbar_container form_title_toolbar' >
<div id='<%=idPortlet%>_toolbar_openMenuHandlerDiv' class='form_title_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbar_openMenuHandlerImg' class='form_title_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbar_listButtons' class='form_title_toolbar_listButtons'></div>
</div>
<div id='<%=idPortlet%>_back_navbar' class='back_navbar_ctrl SPSection_expanded back_navbar_class' data-original-display='flex'><div id='<%=idPortlet%>_back_navbar_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_sep'  formid='<%=idPortlet%>' ps-name='sep'    class='TitleLabel sep_ctrl'><div id='<%=idPortlet%>_septbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("-"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','default_title_form_ui');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_CANCEL",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_CANCEL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_SECURITY",true)+","+JSPLib.ToJSValue(sp.translate("CP_SECURITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CANCEL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CANCEL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CLOSE_ONEXIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CLOSE_ONEXIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETE_TOOLTIP",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETE_TOOLTIP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EDIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EDIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ESC_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ESC_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ESC_QUERY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ESC_QUERY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_EDIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_EDIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_NEW",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_NEW"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_QUERY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_QUERY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FORM_FUNCTION_ZOOM",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FORM_FUNCTION_ZOOM"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_HIDE_NOTIFY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_HIDE_NOTIFY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NEW",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NEW"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PRINT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PRINT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_REDUCE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_REDUCE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SAVE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SAVE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SECURITY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SECURITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_SHOW_NOTIFY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_SHOW_NOTIFY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_TABLEEXTENDER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_TABLEEXTENDER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VIEWED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VIEWED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_PRINT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_SAVE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_SAVE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ZOOM",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ZOOM"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("OK",true)+","+JSPLib.ToJSValue(sp.translate("OK"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','default_title_form_ui',["400"],["62"],'TitleForm',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'600,800,400', '','','',{"400":{"h":"62","w":"100%"},"600":{"h":"62","w":"100%"},"800":{"h":"62","w":"100%"},"900":{"h":"40","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"400":{"w":"100%","h":"62"},"600":{"w":"100%","h":"62"},"800":{"w":"100%","h":"62"},"900":{"w":"100%","h":"40"}},"w":"400","h":"62","title":"","layer":"false","npage":"1"}]);
this.caption_label=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_caption_label","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"400":{"align":"","anchor":"top-left-right","fontpct":"","h":22,"hide":"","n_col":"1","w":170,"x":20,"y":11},"600":{"align":"","anchor":"top-left-right","fontpct":"","h":22,"hide":"","n_col":"1","w":"220","x":20,"y":11},"800":{"align":"","anchor":"top-left-right","fontpct":"","h":22,"hide":"false","n_col":"","w":"245","x":20,"y":11},"900":{"align":"left","anchor":"top-left-right","fontpct":"","h":29,"hide":"false","n_col":"1","w":230,"x":8,"y":7}},"n_col":1,"name":"caption_label","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(caption_label),false,true)%>","type":"Label","w":245,"x":20,"y":11,"zindex":"2"});
this.caption_subtitle_label=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"CaptionSubTitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_caption_subtitle_label","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"400":{"align":"","anchor":"top-left-right","fontpct":"","h":20,"hide":"","n_col":"1","w":170,"x":20,"y":32},"600":{"align":"","anchor":"top-left-right","fontpct":"","h":20,"hide":"","n_col":"1","w":"220","x":20,"y":32},"800":{"align":"","anchor":"top-left-right","fontpct":"","h":20,"hide":"false","n_col":"","w":"245","x":20,"y":32},"900":{"align":"left","anchor":"top-left-right","fontpct":"","h":29,"hide":"false","n_col":"1","w":230,"x":8,"y":7}},"n_col":1,"name":"caption_subtitle_label","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(caption_subtitle_label),false,true)%>","type":"Label","w":245,"x":20,"y":32,"zindex":"2"});
this.m_nLastRec=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_nLastRec","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{"400":{"anchor":"top-right","h":18,"hide":"true","w":30,"x":269,"y":22},"600":{"anchor":"top-right","h":18,"hide":"true","w":"30","x":320,"y":22},"800":{"anchor":"top-right","h":18,"hide":"true","w":"30","x":355,"y":21},"900":{"anchor":"top-right","h":18,"hide":"true","w":"30","x":348,"y":10}},"maxlength":"","name":"m_nLastRec","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_nLastRec,false,true)%>","w":30,"x":355,"y":21,"zerofilling":false,"zindex":"3","zoom":""});
this.m_nRecPos=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_nRecPos","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"true","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{"400":{"anchor":"top-right","h":18,"hide":"true","w":30,"x":229,"y":22},"600":{"anchor":"top-right","h":18,"hide":"true","w":"30","x":281,"y":22},"800":{"anchor":"top-right","h":18,"hide":"true","w":"30","x":314,"y":21},"900":{"anchor":"top-right","h":18,"hide":"true","w":"30","x":307,"y":10}},"maxlength":"","name":"m_nRecPos","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=m_nRecPos%>","w":30,"x":314,"y":21,"zerofilling":false,"zindex":"3","zoom":""});
this.first=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"TitleIcon first_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_first","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf092;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"18","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_FIRST"),false,true)%>","hide":"true","hide_undercond":"","href":"javascript:RecSeek('first')","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"400":{"anchor":"top-right","font_size":"18","h":30,"hide":"true","w":18,"x":193,"y":18},"600":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":246,"y":18},"800":{"anchor":"top-right","font_size":"","h":30,"hide":"true","w":"18","x":277,"y":16},"900":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":270,"y":5}},"name":"first","page":1,"path_type":"skin","server_side":"","src":"&#xf092;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":277,"y":16,"zindex":"3"});
 ZtVWeb.RequireFont("icons8_win10","");
this.next=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"TitleIcon next_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_next","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf145;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"18","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_NEXT"),false,true)%>","hide":"true","hide_undercond":"","href":"javascript:RecSeek('next')","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"400":{"anchor":"top-right","font_size":"18","h":30,"hide":"true","w":18,"x":299,"y":18},"600":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":350,"y":18},"800":{"anchor":"top-right","font_size":"","h":30,"hide":"true","w":"18","x":386,"y":16},"900":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":379,"y":5}},"name":"next","page":1,"path_type":"skin","server_side":"","src":"&#xf145;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":386,"y":16,"zindex":"3"});
 ZtVWeb.RequireFont("icons8_win10","");
this.last=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"TitleIcon last_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_last","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf093;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"18","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_LAST"),false,true)%>","hide":"true","hide_undercond":"","href":"javascript:RecSeek('last')","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"400":{"anchor":"top-right","font_size":"18","h":30,"hide":"true","w":18,"x":316,"y":18},"600":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":367,"y":18},"800":{"anchor":"top-right","font_size":"","h":30,"hide":"true","w":"18","x":404,"y":16},"900":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":397,"y":5}},"name":"last","page":1,"path_type":"skin","server_side":"","src":"&#xf093;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":404,"y":16,"zindex":"3"});
 ZtVWeb.RequireFont("icons8_win10","");
this.prev=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"TitleIcon prev_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_prev","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf144;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"18","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_PREVIOUS"),false,true)%>","hide":"true","hide_undercond":"","href":"javascript:RecSeek('previous')","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"400":{"anchor":"top-right","font_size":"18","h":30,"hide":"true","w":18,"x":210,"y":18},"600":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":263,"y":18},"800":{"anchor":"top-right","font_size":"","h":30,"hide":"true","w":"18","x":295,"y":16},"900":{"anchor":"top-right","h":30,"hide":"true","w":"18","x":288,"y":5}},"name":"prev","page":1,"path_type":"skin","server_side":"","src":"&#xf144;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":295,"y":16,"zindex":"3"});
 ZtVWeb.RequireFont("icons8_win10","");
this.clientsideinclusion=new ZtVWeb._VC(this,'clientsideinclusion',null,'character','<%=JSPLib.ToJSValue(clientsideinclusion,false,true)%>',false,false);
this.toolbar=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-right","bg_color":"","cssClass":"form_title_toolbar","ctrlid":"<%=idPortlet%>_toolbar","h":40,"hide":"false","iconWidth":26,"layer":false,"layout_steps_values":{"400":{"anchor":"top-right","h":40,"hide":"","w":62,"x":338,"y":11},"600":{"anchor":"top-right","h":40,"hide":"","w":"208","x":392,"y":11},"800":{"anchor":"top-right","h":40,"hide":"false","w":"370","x":430,"y":11},"900":{"anchor":"top-right","h":40,"hide":"false","w":"456","x":444,"y":0}},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbar","page":1,"toolbarAlign":"","type":"SPToolbar","w":370,"x":430,"y":11,"zindex":"1"});
this.back_navbar=new ZtVWeb.BoxCtrl(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"back_navbar_class","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_back_navbar","groupName":"","h":40,"hide":"true","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{"400":{"anchor":"top-right","h":40,"hide":"","w":147,"x":190,"y":11},"600":{"anchor":"top-right","h":40,"hide":"","w":146,"x":242,"y":11},"800":{"anchor":"top-right","h":40,"hide":"true","w":"162","x":268,"y":11},"900":{"anchor":"top-right","h":40,"hide":"true","w":"200","x":242,"y":0}},"name":"back_navbar","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":162,"x":268,"y":11,"zindex":"0"});
this.sep=new ZtVWeb._LC(this,{"align":"","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_sep","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":29,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"400":{"align":"","anchor":"top-right","fontpct":"","h":21,"hide":"true","n_col":"1","w":10,"x":259,"y":18},"600":{"align":"","anchor":"top-right","fontpct":"","h":21,"hide":"true","n_col":"1","w":"10","x":311,"y":18},"800":{"align":"center","anchor":"top-right","fontpct":"","h":29,"hide":"true","n_col":"1","w":"10","x":345,"y":19},"900":{"align":"center","anchor":"top-right","fontpct":"","h":29,"hide":"true","n_col":"1","w":"10","x":338,"y":8}},"n_col":1,"name":"sep","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(sep),false,true)%>","type":"Label","w":10,"x":345,"y":19,"zindex":"5"});
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
<%request.setAttribute("default_title_form_ui_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.default_title_form_ui_Static=function(){
if(typeof SetSubTitle !='undefined')this.SetSubTitle=SetSubTitle;
if(typeof InitGrammar !='undefined')this.InitGrammar=InitGrammar;
if(typeof SetActions !='undefined')this.SetActions=SetActions;
if(typeof HideNavBar !='undefined')this.HideNavBar=HideNavBar;
if(typeof ShowNavBar !='undefined')this.ShowNavBar=ShowNavBar;
if(typeof HideAllButtons !='undefined')this.HideAllButtons=HideAllButtons;
if(typeof appendExpandReduceButton !='undefined')this.appendExpandReduceButton=appendExpandReduceButton;
if(typeof SetToolbar !='undefined')this.SetToolbar=SetToolbar;
if(typeof toggleNotify !='undefined')this.toggleNotify=toggleNotify;
if(typeof expandOReduce !='undefined')this.expandOReduce=expandOReduce;
if(typeof resizeCaption !='undefined')this.resizeCaption=resizeCaption;
if(typeof m_nRecPos_Lostfocus !='undefined')this.m_nRecPos_Lostfocus=m_nRecPos_Lostfocus;
if(typeof StartPortlet !='undefined')this.StartPortlet=StartPortlet;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}

//GESTIONE CACHE - Demandata al chiamante che dovrebbe usare SPRrxy che setta gli header adatti al caching
//response.setHeader("Cache-Control","public");
//response.setHeader("Expires","Sun, 17-Jan-2038 19:14:07 GMT");
//response.setHeader("Last-Modified","Sun, 05-Jan-2008 19:14:07 GMT");
%>
this.waitSSVars = true;
var ssvars = ZtVWeb.getPortlet('default_title_form');
if ( ssvars.length ) {
  var idx = LibJavascript.Array.indexOf(ssvars, null, function(ptl) {
    return !ptl.hasTitlePtl;
  });
  if ( idx>-1 ) {
    ssvars = ssvars[idx];
  }
}
//Variabili per settare i pulsanti da far vedere o nascondere
var canDel = ssvars.canDel;
var canEdit = ssvars.canEdit;
var canAdd = ssvars.canAdd;
var procedure = ssvars.m_cProcedure.Value();
var mode = ssvars.m_cMode.Value();
var entityType = ssvars.m_cEntityType.Value();
var m_nChildStatus = ssvars.m_nChildStatus;
var postinTitle = ssvars.postinTitle;
var showPostin = ssvars.showPostin;
this.m_nLastRec.Value(ssvars.m_nLastRec.Value());
this.m_nRecPos.Value(ssvars.m_nRecPos.Value());
var portlet_id=this.formid;
var show_navbar = false;
var l_actions = null;
var newTitle = "";
if(!Empty(ssvars.m_cFunction.Value())){
  newTitle += "<span class=\"SubtitleLabel\">"+ssvars.m_cFunction.Value() +" </span>";
} 
newTitle += ssvars.m_cCaption.Value();
this.caption_label.Value("<div style='text-overflow: ellipsis;overflow: hidden;white-space: nowrap;' title='"+ssvars.m_cCaption.Value()+"'>"
                           +newTitle+"</div>");
function SetSubTitle(p_cSubTitle) {
  this.caption_subtitle_label.Value(p_cSubTitle);
  return true;
}
function InitGrammar() {  
  if (!parent.SpeechGrammar) {
    // non e' disponibile la libreria SpeechGrammar
		return false;
  }
  SpeechGrammar = parent.SpeechGrammar;
  
  var terminiObj = {
    campo: [], campo_V: [], campo_T: [], campo_ID: []
  };
  var label = '', synonymous = '', synonym;
  var nodeList = document.querySelectorAll('.Field, .Memo, .Combobox');
  Array.prototype.slice.call(nodeList).map(elm => {
    if (elm.id) {
      label = document.querySelector('label[for=' + elm.id + ']');
      if (label) {
        label = label.innerText.replace(':', '');
        terminiObj.campo.push(label);
        terminiObj.campo_V.push(elm.name);
        terminiObj.campo_T.push(elm.getAttribute('fieldtype'));
        terminiObj.campo_ID.push(elm.id);
      }
      synonymous = elm.getAttribute('synonymous');
      if (synonymous) {
        synonymous = synonymous.split(',');
        for (var i = 0; i < synonymous.length; i++) {
          synonym = synonymous[i].trim();
          terminiObj.campo.push(synonym);
          terminiObj.campo_V.push(elm.name);
          terminiObj.campo_T.push(elm.getAttribute('fieldtype'));
          terminiObj.campo_ID.push(elm.id);
        }
      }
    }
  });
  
  SpeechGrammar.populateColsName(terminiObj, BoGrammar.getMinorGrammar());
  SpeechGrammar.populateColsName(terminiObj, BoGrammar.getMainGrammar());
  
  var grammarConfig = {};
  grammarConfig.containerName = window.frameElement.name;
  grammarConfig.modal = window.frameElement ? window.frameElement.getAttribute("modallayer") : false;
  grammarConfig.type = 'bo';
  grammarConfig.grammar = BoGrammar;
  grammarConfig.termini = terminiObj;
  SpeechGrammar.addGrammarConfig(grammarConfig);
}
function SetActions() {
  l_actions = (typeof(GetEntityActions)!='undefined' ? GetEntityActions(): []);
  if (l_actions && l_actions.length>0) {
    for (var ii=0; ii<l_actions.length; ii++) {
      var item  = Ctrl(l_actions[ii].id);
      if( item )
      	item.parentNode.removeChild(item);
      if (l_actions[ii].always || mode == "new" || mode == "edit" || mode == "dialog") {        
         var act={
          id: l_actions[ii].id,
          forceid: l_actions[ii].forceid,
        	title: Translate(l_actions[ii].title),
          tooltip: Translate(l_actions[ii].title),
          image:l_actions[ii].img,
          action: (function(action) {
            return function(){
           		window[action](document.activeElement);
            }
          })(l_actions[ii].action)
        }
        if (l_actions[ii].important)
          this.toolbar.Append(act);
        else this.toolbar.AppendMenuItem(act);
      }
    }
  }
}
function HideNavBar(){
  // Nascondo la Nav bar
  this.first.Hide();
  this.next.Hide();
  this.last.Hide();
  this.prev.Hide();
  this.back_navbar.Hide();
  this.m_nLastRec.Hide();
  this.m_nRecPos.Hide();
  this.sep.Hide()
//   document.getElementById(tbl.ctrlid).style.right = "10px";
}
function ShowNavBar(){
  //mostro la Nav bar
  this.first.Show();
  this.next.Show();
  this.last.Show();
  this.prev.Show();
  this.back_navbar.Show();
  this.m_nLastRec.Show();
  this.m_nRecPos.Show();
  this.sep.Show()
//   document.getElementById(tbl.ctrlid).style.right = "155px";
}
function HideAllButtons(){
  for(var i=0;i<values.length;i++){
      tbl.HideItem(values[i]);
  }
}
function appendExpandReduceButton(){
  if (ssvars.m_bShowExtendReduceBtn.Value()){
    this.toolbar.Append({
      id:'expandReduce',
      title: FormatMsg('MSG_EXPAND'),
      action:function(){ _this.expandOReduce('expandReduce');},
      image:{ fontFamily:'icons8_win10', value: "&#xee18"}
    });
  }
}
function SetToolbar(){  
  if(mode == "edit" || mode == "new" ) {
		this.InitGrammar();
  }
  if(entityType == "dialog"){
    this.toolbar.Append({
      id:'ok',
      title: FormatMsg('OK'),
      tooltip: FormatMsg('MSG_VIEWED'),
      action:"javascript:SendData(\"save\")" ,
      image:{ fontFamily:'icons8_win10', value: "&#xef8b"}
    });
    this.appendExpandReduceButton();
    this.toolbar.Append({
      id:'esc',
      title: FormatMsg('MSG_CLOSE_ONEXIT'),
      'tooltip': FormatMsg('MSG_ESC_CLOSE'),
      action:"javascript:SendData(\"discard\")",
      image:{ fontFamily:'icons8_win10', value: "&#xf048"}
    });
    this.SetActions();
  } else if(entityType == "page"){
    //le page non hanno bottoni
  }else if(m_nChildStatus == 1){
    if(mode == "query" || mode == "view"){
      this.appendExpandReduceButton();
      this.toolbar.Append({
        id:'close',
        title: FormatMsg('MSG_CLOSE_ONEXIT'),
      	tooltip: FormatMsg('MSG_CLOSE_ONEXIT'),
        action:"javascript:window."+ssvars.formid+".Close()" ,
        image:{ fontFamily:'icons8_win10', value: "&#xf048"}
      });
    }else{
      this.toolbar.Append({
        id:'ok',
        title: FormatMsg('OK'),
      	tooltip: FormatMsg('MSG_VIEWED'),
        action:"javascript:SendData(\"save\")",
        image:{ fontFamily:'icons8_win10', value: "&#xef8b"}
      });
      this.appendExpandReduceButton();
      this.toolbar.Append({
        id:'close_discard',
        title: FormatMsg('MSG_CLOSE_ONEXIT'),
      	tooltip: FormatMsg('MSG_ESC_CLOSE'),
        action:"javascript:SendData(\"moveto\")",
        image:{ fontFamily:'icons8_win10', value: "&#xf048"}
      });
    }
    this.SetActions();
  }
  else if(mode == "query"){
    if ((this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0) || (this.m_nRecPos.Value()==1 && this.m_nLastRec.Value()==1)) {
    } else {
    	this.ShowNavBar();
    	show_navbar = true;
    }
    this.toolbar.Append({
      id:'zoom',
      title: FormatMsg('MSG_FORM_FUNCTION_ZOOM'),
      tooltip: FormatMsg('MSG_ZOOM', FormatMsg('MSG_FORM_FUNCTION_ZOOM')),
      action:"javascript:Zoom()" ,
      image:{ fontFamily:'icons8_win10', value: "&#xe9fb"}
    });
    if(canEdit && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){
      this.toolbar.Append({
        id:'edit',
        tooltip: FormatMsg('MSG_EDIT', FormatMsg('MSG_FORM_FUNCTION_EDIT')),
        title: FormatMsg('MSG_FORM_FUNCTION_EDIT'),
        action: "javascript:SubmitListenerForm(\"edit\")",
        image:{ fontFamily:'icons8_win10', value: "&#xf0ba"}
      });
    }
    if(canAdd){
      this.toolbar.Append({
        id:'add',
        tooltip: FormatMsg('MSG_NEW', FormatMsg('MSG_FORM_FUNCTION_NEW')),
        title: FormatMsg('MSG_FORM_FUNCTION_NEW'),
        action: "javascript:SubmitListenerForm(\"new\")",
        image:{ fontFamily:'icons8_win10', value: "&#xebed"}
      });
    }
    this.appendExpandReduceButton();
    if(canDel  && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){
      this.toolbar.Append({
        id:'delete',
        tooltip: FormatMsg('MSG_DELETE'),
        title: FormatMsg('MSG_DELETE_TOOLTIP'),
        action: "javascript:SubmitListenerForm(\"delete\")",
        image:{ fontFamily:'icons8_win10', value: "&#xf041"}
      });
    }
    this.SetActions();
    if(ssvars.m_bHasPrintProc.Value() == "true"  && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){
      this.toolbar.Append({
        id:'print',
        tooltip: FormatMsg('MSG_PRINT'),
        title: FormatMsg('MSG_VZM_PRINT'),
        action: "javascript:PrintPrg()",
        image:{ fontFamily:'icons8_win10', value: "&#xec0b"}
      });
    }
    if(ssvars.m_bCanEditSecurity.Value() == "true"){
      this.toolbar.Append({
        id:'security',
        tooltip: FormatMsg('MSG_SECURITY'),
        title: FormatMsg('CP_SECURITY'),
        action:"javascript:RunSecurity()",
        image:{ fontFamily:'icons8_win10', value: "&#xef7b"}
      });
      this.toolbar.Append({
        id:'extender',
        tooltip: FormatMsg('MSG_TABLEEXTENDER'),
        title: FormatMsg('MSG_TABLEEXTENDER'),
        action:"javascript:ExtendTable()",
        image:{ fontFamily:'icons8_win10', value: "&#xf10d"}
      });
    }
    // if(ssvars.m_bCanCreateAlterInterface.Value() == "true"){
      // tbl.SetItem("altint",{link:"javascript:CreatePortlet()"},true);
    // }
    if(showPostin  && !(this.m_nRecPos.Value()==0 && this.m_nLastRec.Value()==0)){
      this.toolbar.Append({
        id:'postin',
        title: postinTitle,
        tooltip: postinTitle,
        action:"javascript:PostinButtonClick()",
        image:{ fontFamily:'icons8_win10', value: "&#xee04"}
      });
    }
  }
  else if(mode == "edit" || mode == "new"){
    this.toolbar.Append({
      id:'save',
      tooltip: FormatMsg('MSG_SAVE'),
      title: FormatMsg('MSG_VZM_SAVE'),
      action:"javascript:SendData(\"save\")",
      image:{ fontFamily:'icons8_win10', value: "&#xecb3"}
    });
    this.appendExpandReduceButton()
    if(ssvars.m_cAtExit.Value() == ""){
      this.toolbar.Append({
        id:'query',
        tooltip: FormatMsg('MSG_ESC_QUERY', FormatMsg('MSG_FORM_FUNCTION_QUERY')),
        title: FormatMsg('MSG_FORM_FUNCTION_QUERY'),
        action:"javascript:SendData(\"moveto\")",
        image:{ fontFamily:'icons8_win10', value: "&#xe950"}
      });
    }else{
      this.toolbar.Append({
        id:'close_discard',
        tooltip: FormatMsg('MSG_CANCEL'),
        title: FormatMsg('ADMIN_CANCEL'),
        action:"javascript:SendData(\"moveto\")",
        image:{ fontFamily:'icons8_win10', value: "&#xf048"}
      });
    }
    this.SetActions();
    if(showPostin){
      this.toolbar.Append({
        id:'postin',
        title: postinTitle,
        tooltip: postinTitle,
        action:"javascript:PostinButtonClick()",
        image:{ fontFamily:'icons8_win10', value: "&#xee04"}
      });
    }
  }
  else if(mode == "view"){
    this.toolbar.Append({
      id:'close_ok',
      title: FormatMsg('MSG_CLOSE_ONEXIT'),
      tooltip: FormatMsg('MSG_ESC_CLOSE'),
      action:"javascript:SendData(\"discard\")",
      image:{ fontFamily:'icons8_win10', value: "&#xf048"}
    });
    if(canEdit){
      this.toolbar.Append({
        id:'edit',
        tooltip: FormatMsg('MSG_EDIT', FormatMsg('MSG_FORM_FUNCTION_EDIT')),
        title: FormatMsg('MSG_FORM_FUNCTION_EDIT'),
        action:"javascript:SubmitListenerForm(\"edit\")",
        image:{ fontFamily:'icons8_win10', value: "&#xf0ba"}
      });
    }
    this.appendExpandReduceButton()
    if (canDel) {
      this.toolbar.Append({
        id:'delete',
        tooltip: FormatMsg('MSG_DELETE'),
        title: FormatMsg('MSG_DELETE_TOOLTIP'),
        action: "javascript:SubmitListenerForm(\"delete\")",
        image:{ fontFamily:'icons8_win10', value: "&#xf041"}
      });
    }
    this.SetActions();
    if(ssvars.m_bHasPrintProc.Value() == "true"){
      this.toolbar.Append({
        id:'print',
        tooltip: FormatMsg('MSG_PRINT'),
        title: FormatMsg('MSG_VZM_PRINT'),
        action:"javascript:PrintPrg()",
        image:{ fontFamily:'icons8_win10', value: "&#xec0b"}
      });
    }
    if(showPostin){
      this.toolbar.Append({
        id:'postin',
        title: postinTitle,
        tooltip: postinTitle,
        action:"javascript:PostinButtonClick()",
        image:{ fontFamily:'icons8_win10', value: "&#xee04"}
      });
    }
  }
  if (entityType!='page'){
    if (ssvars.m_bShowNotifyBtn.Value()){
      this.toolbar.Append({
          id:'toggleNotify',
          title: FormatMsg('MSG_SHOW_NOTIFY'),
        	action:function(){ _this.toggleNotify();},
          image:{ fontFamily:'icons8_win10', value: "&#xf56d"}
        });
    }
  }
  ssvars.AppendCustomButton(this.toolbar);
}
function toggleNotify(){
  if (ToggleNotifyContainer()){
    this.toolbar.UpdateItem('toggleNotify',{
     title:FormatMsg('MSG_HIDE_NOTIFY')
    })
  }
  else {
		this.toolbar.UpdateItem('toggleNotify',{
     title:FormatMsg('MSG_SHOW_NOTIFY')
    })
  }
}
function expandOReduce(){
  if (isMaskExpand()){
    this.toolbar.UpdateItem('expandReduce',{
     image:{ fontFamily:'icons8_win10', value: "&#xee18"},
     title:FormatMsg('MSG_EXPAND')
    })
  }
  else {
   	this.toolbar.UpdateItem('expandReduce',{
     image:{ fontFamily:'icons8_win10', value: "&#xefd2"},
     title:FormatMsg('MSG_REDUCE')
    })                       
  }
                            
    
  ExpandReduce();
}
function resizeCaption(){  
  var backNCR = this.back_navbar.Ctrl.getBoundingClientRect();  
  if (backNCR.width==0){
   	this.toolbar.Ctrl.style.width='200px';
  }
  else {
    var right = this.toolbar.Ctrl.clientWidth;
    this.back_navbar.Ctrl.style.right = right + 'px';
    backNCR = this.back_navbar.Ctrl.getBoundingClientRect();  
    right += backNCR.width;
    this.caption_label.Ctrl.style.right = right + 'px';
  }
}
function m_nRecPos_Lostfocus(){
  SelectRecordPortlet(this.m_nLastRec.Value(),this.m_nRecPos.Value());
}
var _this = this;
var create = false;
function StartPortlet() {
  create = true;
  this.HideNavBar();
  this.SetToolbar.call(this);
  //this.SetActions();
  //this.resizeCaption();
}
if (document.readyState=='complete' || document.readyState=='loaded' || document.readyState=='interactive') {
  this.this_Loaded=this.StartPortlet;
} else {
  LibJavascript.Events.addEvent(document,'readystatechange',function(){
    if (document.readyState=='complete') {
      _this.StartPortlet();
    }
  });
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.default_title_form_ui_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.first.dispatchEvent('OnLoad');
window.<%=idPortlet%>.next.dispatchEvent('OnLoad');
window.<%=idPortlet%>.last.dispatchEvent('OnLoad');
window.<%=idPortlet%>.prev.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','default_title_form_ui',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'default_title_form_ui');
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
sp.endPage("default_title_form_ui");
}%>
<%! public String getJSPUID() { return "371427521"; } %>