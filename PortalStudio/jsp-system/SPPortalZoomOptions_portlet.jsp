<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nfunction this_Loaded(){\n this.chk_saveGroup_onChange();\n this.chk_saveUser_onChange();\n}\n\nfunction chk_saveGroup_onChange(){\n if (this.chk_saveGroup.Value()) {\n  this.m_nGroup.Enabled();\n  this.chk_saveUser.Value(false);\n } else {\n  this.m_nGroup.Disabled();\n  this.m_nGroup.Value(\"\");\n }\n}\n\nfunction chk_saveUser_onChange(){\n if (this.chk_saveUser.Value()) {\n  this.m_nUser.Enabled();\n  this.chk_saveGroup.Value(false);\n } else {\n  this.m_nUser.Disabled();\n  this.m_nUser.Value(\"\");\n }\n}\n\u003c%\nboolean canChangeQuery=sp.CanAccessEditor(\"PortalStudio\");\n%\u003e\n\u003c%if (sp.IsPortalZoomHelpInstalled()) {%\u003e\n  ZtVWeb.RequireLibrary('..\u002fspportalzoom_help.js');\n\u003c%}%\u003e\nif (typeof(anchorToFeature)=='undefined'){\n  this.image_help.Hide();\n}\nvar canChangeQuery=\u003c%=canChangeQuery%\u003e;\nvar defaultBO=\"\";\nif (!canChangeQuery) {\n  this.txtVQRName.Disabled();\n  this.btnVqr_New.Disabled();\n  this.btnVqr_Edit.Disabled();\n  this.btnVqr_Query.Disabled();\n  this.chkDefaultBO.Disabled();\n}\nthis.chkFilters.Disabled();\n\nthis.openerID.Value(this.formid);\n\n\nvar emptyData={\n  Table: '',\n  ConfigName: '',\n  VQRName: '',\n  GridRows:'',\n  Default: false,\n  Filters: false,\n  OrderBy: false,\n  CountRows: false,\n  User : 0,\n  Group : 0,\n  Custom : false\n};\nvar localData=emptyData;\n\nfunction chkDefaultBO_onChange(){\n var def=this.chkDefaultBO.Value();\n\u002f\u002f  this.txtVQRName.ReadOnly(def);\n  if(this.chkDefaultBO.Value()){\n    this.txtVQRName.Value(defaultBO);\n    this.txtVQRName.Disabled();\n    this.btnVqr_Edit.Disabled();\n    this.btnVqr_Query.Disabled();\n  }else{\n    this.txtVQRName.Value(localData.VQRName);\n    this.txtVQRName.Enabled();\n    this.btnVqr_Edit.Enabled();\n    this.btnVqr_Query.Enabled();\n   this.txtVQRName_Lostfocus();\n  }\n}\n\nfunction setData(dati){\n  localData={\n    Table:      IsAny(dati.Table)      ? dati.Table      : localData.Table,\n    ConfigName: IsAny(dati.ConfigName) ? dati.ConfigName : localData.ConfigName,\n    VQRName:    IsAny(dati.VQRName)    ? dati.VQRName    : localData.VQRName,\n    GridRows:   IsAny(dati.GridRows)   ? dati.GridRows   : localData.GridRows,\n    Default:    IsAny(dati.Default)    ? dati.Default    : localData.Default,\n    Filters:    IsAny(dati.Filters)    ? dati.Filters    : localData.Filters,\n    OrderBy:    IsAny(dati.OrderBy)    ? dati.OrderBy    : localData.OrderBy,\n    CountRows:  IsAny(dati.CountRows)  ? dati.CountRows  : localData.CountRows,\n    User:       IsAny(dati.User)       ? dati.User       : localData.User,\n    Group:      IsAny(dati.Group)      ? dati.Group      : localData.Group,\n    Custom:     IsAny(dati.Custom)     ? dati.Custom     : localData.Custom\n  }\n  defaultBO =   IsAny(dati.DefaultBO)  ? dati.DefaultBO  : \"\";\n  this.SetControlsValue();\n}\n\nfunction SetControlsValue(){\n  this.txtTable.Value(localData.Table);\n  this.txtConfigName.Value(localData.ConfigName);\n  this.txtVQRName.Value(localData.VQRName);\n  this.txtGridRows.Value(localData.GridRows+\"\");\n  this.chkDefault.Value(localData.Default || EmptyString(localData.ConfigName));\n  this.chkDefaultBO.Value(localData.VQRName==defaultBO || (localData.VQRName.indexOf('[')!=-1 && localData.VQRName.substr(0,localData.VQRName.indexOf('['))==defaultBO.substr(0,defaultBO.indexOf('[')) &&\n      localData.VQRName.substr(localData.VQRName.indexOf('[')).toUpperCase()==defaultBO.substr(defaultBO.indexOf('[')).toUpperCase()));\n  this.chkFilters.Value(localData.Filters);\n  this.chkOrderBy.Value(localData.OrderBy);\n  this.chkCountRows.Value(localData.CountRows);\n  if (localData.User\u003e0) {\n    this.chk_saveUser.Value(true);\n    this.m_nUser.Value(localData.User);\n  } else {\n    this.chk_saveUser.Value(false);\n    this.m_nUser.Value(\"\");\n  }\n  if (localData.Group\u003e0) {\n    this.chk_saveGroup.Value(true);\n    this.m_nGroup.Value(localData.Group);\n  } else {\n    this.chk_saveGroup.Value(false);\n    this.m_nGroup.Value(\"\");\n  }\n  this.chkCustom.Value(localData.Custom);\n\n  this.CheckUI();\n}\n\nfunction btnReset_Click(){\n  this.SetControlsValue();\n}\nfunction chkDefault_onChange(){\n  this.CheckUI();\n}\n\nfunction CheckUI(){\n\u002f\u002f  var def=this.chkDefault.Value();\n\u002f\u002f  this.txtConfigName.ReadOnly(def);\n  if(this.chkDefault.Value()){\n    this.txtConfigName.Value(\"default\");\n  }else{\n    this.txtConfigName.Value(localData.ConfigName);\n  }\n  this.chkDefaultBO_onChange();\n\u002f\u002f  this.txtVQRName_Lostfocus();\n}\n\nfunction getData(fill){\n  fill=fill||{};\n  var this_portlet=this;\n\n  fill.Table=      this_portlet.txtTable.Value();\n  fill.ConfigName= this_portlet.txtConfigName.Value()||'default';\n  fill.VQRName=    this_portlet.txtVQRName.Value();\n  fill.GridRows=   Val(this_portlet.txtGridRows.Value());\n  \u002f\u002ffill.Filters=  this_portlet.chkFilters.Value();\n  fill.OrderBy=    this_portlet.chkOrderBy.Value();\n  fill.CountRows=  \"\"+this_portlet.chkCountRows.Value();\n  fill.Custom =    this_portlet.chkCustom.Value();\n  fill.Group  =    (this_portlet.chk_saveGroup.Value()?this_portlet.m_nGroup.Value()||0:0);\n  fill.User   =    (this_portlet.chk_saveUser.Value()?this_portlet.m_nUser.Value()||0:0);\n  return fill;\n}\n\n\nfunction Sync(){\n  this.SetEmitterName();\n  this.SetReceiverName();\n}\nfunction SetEmitterName(){\n  var pref=this.container.GetListenersPrefix();\n  this.OptionsSet.name=pref+'OptionsSet';\n}\nfunction SetReceiverName(){\n  var pref=this.container.GetListenersPrefix();\n  this['on_'+pref+'OptionsRead']=function(parmsObj){\n    this.OptionsRead.receiveFnc(parmsObj);\n  };\n}\n\nfunction btnVqr_Query_Click(){\n  this.splkVQRSelect.Link();\n}\n\nthis['on_'+this.formid+'_ChangeVQRName']=function(name){\n  this.txtVQRName.Value(name);\n}\n\nfunction txtVQRName_Lostfocus(){\n  var v=this.txtVQRName.Value();\n  if(EmptyString(v)){\n    this.btnVqr_Edit.Disabled();\n  }else{\n    if (canChangeQuery) {\n      this.btnVqr_Edit.Enabled();\n    }\n  }\n}\n\nfunction btnVqr_Edit_Click(){\n  this.splkVQREdit.Link();\n}\n\nfunction btnVqr_New_Click(){\n  this.splkVQRNew.Link();\n}\n\n\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"213","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","tag":"","title":"","title_url":"","type":"Form","v_line":"350","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblName","nowrap":"false","page":"1","picture":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Name:","w":"62","wireframe_props":"align,value,n_col","x":"5","y":"33","zindex":"1"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Choose a configuration name","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"txtConfigName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"2","tabindex":"1","type":"Textbox","typevar":"character","visible":"true","w":"17","wireframe_props":"name","x":"71","y":"33","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblTable","nowrap":"false","page":"1","picture":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Table:","w":"62","wireframe_props":"align,value,n_col","x":"5","y":"58","zindex":"1"},{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Save configuration in custom directory of current instance","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chkCustom","page":"1","sequence":"3","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"93","y":"35","zindex":"1"},{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Save configuration only for the specified group","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chk_saveGroup","page":"1","sequence":"4","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"164","y":"35","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblVqr","nowrap":"false","page":"1","picture":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Query file:","w":"62","wireframe_props":"align,value,n_col","x":"5","y":"83","zindex":"1"},{"anchor":"top-right","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","font":"","font_color":"","font_size":"7pt","h":"17","help_tips":"Group code","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"m_nGroup","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"5","tabindex":"1","type":"Textbox","typevar":"numeric","visible":"true","w":"23","wireframe_props":"name","x":"224","y":"35","zerofilling":"false","zindex":"1"},{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Save configuration only for the specified user","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chk_saveUser","page":"1","sequence":"6","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"268","y":"35","zindex":"1"},{"anchor":"top-right","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","font":"","font_color":"","font_size":"7pt","h":"17","help_tips":"User code","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"m_nUser","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","tabindex":"1","type":"Textbox","typevar":"numeric","visible":"true","w":"23","wireframe_props":"name","x":"323","y":"35","zerofilling":"false","zindex":"1"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Name of the table","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"txtTable","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"8","tabindex":"1","type":"Textbox","typevar":"character","visible":"true","w":"275","wireframe_props":"name","x":"71","y":"58","zerofilling":"false","zindex":"1"},{"anchor":"top-left-right","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Select the name of the query","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"txtVQRName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"9","tabindex":"1","type":"Textbox","typevar":"character","visible":"true","w":"204","wireframe_props":"name","x":"71","y":"83","zerofilling":"false","zindex":"1"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Create new query","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btnVqr_New","page":"1","sequence":"10","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"N","w":"20","wireframe_props":"value","x":"278","y":"84","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblRows","nowrap":"false","page":"1","picture":"","sequence":"10","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Rows:","w":"60","wireframe_props":"align,value,n_col","x":"7","y":"108","zindex":"1"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Edit current query","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btnVqr_Edit","page":"1","sequence":"11","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"E","w":"20","wireframe_props":"value","x":"301","y":"84","zindex":"1"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Select a query","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btnVqr_Query","page":"1","sequence":"12","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"...","w":"20","wireframe_props":"value","x":"326","y":"84","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblDefaultBO","nowrap":"false","page":"1","picture":"","sequence":"12","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Default BO:","w":"67","wireframe_props":"align,value,n_col","x":"104","y":"109","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblDefault","nowrap":"false","page":"1","picture":"","sequence":"12","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Default:","w":"62","wireframe_props":"align,value,n_col","x":"5","y":"133","zindex":"1"},{"anchor":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Number of the visible rows in the grid","hide":"","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"3","name":"txtGridRows","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","tabindex":"1","type":"Textbox","typevar":"character","visible":"true","w":"30","wireframe_props":"name","x":"71","y":"108","zerofilling":"false","zindex":"1"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Check it to select default config name","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chkDefault","page":"1","sequence":"14","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"71","y":"133","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblQueryCount","nowrap":"false","page":"1","picture":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"CountRows:","w":"76","wireframe_props":"align,value,n_col","x":"95","y":"133","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblFilters","nowrap":"false","page":"1","picture":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Filters:","w":"62","wireframe_props":"align,value,n_col","x":"5","y":"158","zindex":"1"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chkFilters","page":"1","sequence":"16","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"71","y":"158","zindex":"1"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Check it to select default BO as query (if exist)","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chkDefaultBO","page":"1","sequence":"16","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"175","y":"109","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblOrderBy","nowrap":"false","page":"1","picture":"","sequence":"16","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Order by:","w":"62","wireframe_props":"align,value,n_col","x":"109","y":"158","zindex":"1"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Check it if you want count the total number of rows","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chkCountRows","page":"1","sequence":"17","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"175","y":"133","zindex":"1"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"13","help_tips":"Check it to save column orderby","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layout_steps_values":"{}","name":"chkOrderBy","page":"1","sequence":"18","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"175","y":"158","zindex":"1"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Clear modified data","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btnReset","page":"1","sequence":"19","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"Reset","w":"45","wireframe_props":"value","x":"16","y":"181","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"OptionsRead","objsValues":"this.setData(evt.optionsData)","page":"1","parmsNames":"optionsData","sequence":"20","type":"EventReceiver","w":"22","x":"-1","y":"-25"},{"broadcast":"all","eventsNames":"","eventsObjs":"","h":"20","name":"OptionsSet","page":"1","parmsNames":"cfgData","parmsTypes":"","parmsValues":"this.getData()","sequence":"21","type":"EventEmitter","w":"22","x":"26","y":"-25"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"","name":"openerID","page":"1","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"57","y":"-25"},{"async":"false","entity_type":"","force_msg_id":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"splkVQRSelect","offline":"false","page":"1","parms":"openerID,VQRName=txtVQRName","popup":"true","popup_height":"440","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"23","servlet":"..\u002fjsp-system\u002fSPPortalZoomOptions_VQRSelect_portlet.jsp","target":"","type":"SPLinker","w":"20","x":"176","y":"216"},{"async":"false","entity_type":"","force_msg_id":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"splkVQREdit","offline":"false","page":"1","parms":"filename=txtVQRName","popup":"true","popup_height":"450","popup_scroll":"false","popup_style":"","popup_width":"600","progressbar":"","refresh":"","sequence":"24","servlet":"..\u002fvisualquery\u002findex.jsp","target":"","type":"SPLinker","w":"20","x":"151","y":"216"},{"async":"false","entity_type":"","force_msg_id":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"splkVQRNew","offline":"false","page":"1","parms":"","popup":"true","popup_height":"450","popup_scroll":"false","popup_style":"","popup_width":"600","progressbar":"","refresh":"","sequence":"25","servlet":"..\u002fvisualquery\u002findex.jsp","target":"","type":"SPLinker","w":"20","x":"126","y":"216"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"31","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"labelTitle","nowrap":"false","page":"1","picture":"","sequence":"26","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Configurazione zoom","w":"352","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"alt":"","anchor":"top-right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"Help","hide":"false","hide_undercond":"","href":"javascript:Help('portalzoom_interfaccia_base_toolbar_config_opzioni')","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image_help","page":"1","path_type":"false","sequence":"27","server_side":"","src":"..\u002fportalstudio\u002fimages\u002fhelp.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"330","y":"7","zindex":"1"},{"align":"left","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"16","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_custom","nowrap":"false","page":"1","picture":"","sequence":"28","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"custom","w":"43","wireframe_props":"align,value,n_col","x":"110","y":"35","zindex":"1"},{"align":"left","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label3","nowrap":"false","page":"1","picture":"","sequence":"29","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"group:","w":"41","wireframe_props":"align,value,n_col","x":"183","y":"35","zindex":"1"},{"align":"left","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_user","nowrap":"false","page":"1","picture":"","sequence":"30","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"user:","w":"36","wireframe_props":"align,value,n_col","x":"286","y":"35","zindex":"1"}]%>
<%/*Description:*/%>
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
.SPPortalZoomOptions_container {
}
.SPPortalZoomOptions_portlet{
  position:relative;
  width:100%;
  min-width:350px;
  height:213px;
}
.SPPortalZoomOptions_portlet[Data-page="1"]{
  height:213px;
  width:100%;
}
.SPPortalZoomOptions_portlet > .lblName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:5px;
  width:62px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblName_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblName_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .txtConfigName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:71px;
  right:262px;
  width:auto;
  height:20px;
}
.SPPortalZoomOptions_portlet > .txtConfigName_ctrl {
}
.SPPortalZoomOptions_portlet > .txtConfigName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_portlet > .lblTable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:58px;
  left:5px;
  width:62px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblTable_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblTable_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .chkCustom_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:244px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .chk_saveGroup_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:173px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .lblVqr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:83px;
  left:5px;
  width:62px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblVqr_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblVqr_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .m_nGroup_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:103px;
  width:23px;
  height:17px;
}
.SPPortalZoomOptions_portlet > .m_nGroup_ctrl {
}
.SPPortalZoomOptions_portlet > .m_nGroup_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_portlet > .chk_saveUser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:69px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .m_nUser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:4px;
  width:23px;
  height:17px;
}
.SPPortalZoomOptions_portlet > .m_nUser_ctrl {
}
.SPPortalZoomOptions_portlet > .m_nUser_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_portlet > .txtTable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:58px;
  left:71px;
  right:4px;
  width:auto;
  height:20px;
}
.SPPortalZoomOptions_portlet > .txtTable_ctrl {
}
.SPPortalZoomOptions_portlet > .txtTable_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_portlet > .txtVQRName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:83px;
  left:71px;
  right:75px;
  width:auto;
  height:20px;
}
.SPPortalZoomOptions_portlet > .txtVQRName_ctrl {
}
.SPPortalZoomOptions_portlet > .txtVQRName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_portlet > .btnVqr_New_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  right:52px;
  width:20px;
  height:20px;
}
.SPPortalZoomOptions_portlet > .btnVqr_New_ctrl {
}
.SPPortalZoomOptions_portlet > .lblRows_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  left:7px;
  width:60px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblRows_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblRows_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .btnVqr_Edit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  right:29px;
  width:20px;
  height:20px;
}
.SPPortalZoomOptions_portlet > .btnVqr_Edit_ctrl {
}
.SPPortalZoomOptions_portlet > .btnVqr_Query_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:84px;
  right:4px;
  width:20px;
  height:20px;
}
.SPPortalZoomOptions_portlet > .btnVqr_Query_ctrl {
}
.SPPortalZoomOptions_portlet > .lblDefaultBO_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:109px;
  left:104px;
  width:67px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblDefaultBO_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblDefaultBO_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .lblDefault_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:133px;
  left:5px;
  width:62px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblDefault_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblDefault_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .txtGridRows_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:108px;
  left:71px;
  width:30px;
  height:20px;
}
.SPPortalZoomOptions_portlet > .txtGridRows_ctrl {
}
.SPPortalZoomOptions_portlet > .txtGridRows_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomOptions_portlet > .chkDefault_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:133px;
  left:71px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .lblQueryCount_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:133px;
  left:95px;
  width:76px;
  height:auto;
  min-height:21px;
}
.SPPortalZoomOptions_portlet > .lblQueryCount_ctrl {
  height:auto;
  min-height:21px;
}
.SPPortalZoomOptions_portlet > .lblQueryCount_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .lblFilters_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:158px;
  left:5px;
  width:62px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblFilters_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblFilters_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .chkFilters_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:158px;
  left:71px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .chkDefaultBO_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:109px;
  left:175px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .lblOrderBy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:158px;
  left:109px;
  width:62px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblOrderBy_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomOptions_portlet > .lblOrderBy_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomOptions_portlet > .chkCountRows_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:133px;
  left:175px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .chkOrderBy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:158px;
  left:175px;
  width:13px;
  height:13px;
}
.SPPortalZoomOptions_portlet > .btnReset_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:181px;
  left:16px;
  width:45px;
  height:24px;
}
.SPPortalZoomOptions_portlet > .btnReset_ctrl {
}
.SPPortalZoomOptions_portlet > .labelTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:-2px;
  width:auto;
  height:auto;
  min-height:31px;
}
.SPPortalZoomOptions_portlet > .labelTitle_ctrl {
  height:auto;
  min-height:31px;
}
.SPPortalZoomOptions_portlet > .labelTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomOptions_portlet > .image_help_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:4px;
  width:16px;
  height:16px;
}
.SPPortalZoomOptions_portlet > .image_help_ctrl {
}
.SPPortalZoomOptions_portlet > .image_help_ctrl > a, .SPPortalZoomOptions_portlet > .image_help_ctrl > a:hover{
  text-decoration:none;
}
.SPPortalZoomOptions_portlet > .image_help_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.SPPortalZoomOptions_portlet > .lbl_custom_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:197px;
  width:43px;
  height:auto;
  min-height:16px;
}
.SPPortalZoomOptions_portlet > .lbl_custom_ctrl {
  height:auto;
  min-height:16px;
}
.SPPortalZoomOptions_portlet > .lbl_custom_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.SPPortalZoomOptions_portlet > .label3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:126px;
  width:41px;
  height:auto;
  min-height:18px;
}
.SPPortalZoomOptions_portlet > .label3_ctrl {
  height:auto;
  min-height:18px;
}
.SPPortalZoomOptions_portlet > .label3_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
}
.SPPortalZoomOptions_portlet > .lbl_user_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  right:28px;
  width:36px;
  height:auto;
  min-height:18px;
}
.SPPortalZoomOptions_portlet > .lbl_user_ctrl {
  height:auto;
  min-height:18px;
}
.SPPortalZoomOptions_portlet > .lbl_user_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
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
 String def="[{\"h\":\"213\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"350\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Name:\",\"w\":\"62\",\"x\":\"5\",\"y\":\"33\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtConfigName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"17\",\"x\":\"71\",\"y\":\"33\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTable\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Table:\",\"w\":\"62\",\"x\":\"5\",\"y\":\"58\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkCustom\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"93\",\"y\":\"35\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chk_saveGroup\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"164\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblVqr\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Query file:\",\"w\":\"62\",\"x\":\"5\",\"y\":\"83\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"17\",\"layout_steps_values\":{},\"name\":\"m_nGroup\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"23\",\"x\":\"224\",\"y\":\"35\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chk_saveUser\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"268\",\"y\":\"35\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"17\",\"layout_steps_values\":{},\"name\":\"m_nUser\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"23\",\"x\":\"323\",\"y\":\"35\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTable\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"275\",\"x\":\"71\",\"y\":\"58\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtVQRName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"204\",\"x\":\"71\",\"y\":\"83\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"btnVqr_New\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"N\",\"w\":\"20\",\"x\":\"278\",\"y\":\"84\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblRows\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Rows:\",\"w\":\"60\",\"x\":\"7\",\"y\":\"108\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"btnVqr_Edit\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"E\",\"w\":\"20\",\"x\":\"301\",\"y\":\"84\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"btnVqr_Query\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"...\",\"w\":\"20\",\"x\":\"326\",\"y\":\"84\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDefaultBO\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Default BO:\",\"w\":\"67\",\"x\":\"104\",\"y\":\"109\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDefault\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Default:\",\"w\":\"62\",\"x\":\"5\",\"y\":\"133\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtGridRows\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"30\",\"x\":\"71\",\"y\":\"108\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkDefault\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"71\",\"y\":\"133\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblQueryCount\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CountRows:\",\"w\":\"76\",\"x\":\"95\",\"y\":\"133\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblFilters\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Filters:\",\"w\":\"62\",\"x\":\"5\",\"y\":\"158\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkFilters\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"71\",\"y\":\"158\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkDefaultBO\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"175\",\"y\":\"109\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrderBy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Order by:\",\"w\":\"62\",\"x\":\"109\",\"y\":\"158\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkCountRows\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"175\",\"y\":\"133\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkOrderBy\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"175\",\"y\":\"158\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnReset\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Reset\",\"w\":\"45\",\"x\":\"16\",\"y\":\"181\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"OptionsRead\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"-1\",\"y\":\"-25\"},{\"h\":\"20\",\"name\":\"OptionsSet\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"26\",\"y\":\"-25\"},{\"h\":\"22\",\"name\":\"openerID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"57\",\"y\":\"-25\"},{\"h\":\"20\",\"name\":\"splkVQRSelect\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"20\",\"x\":\"176\",\"y\":\"216\"},{\"h\":\"20\",\"name\":\"splkVQREdit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"20\",\"x\":\"151\",\"y\":\"216\"},{\"h\":\"20\",\"name\":\"splkVQRNew\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"20\",\"x\":\"126\",\"y\":\"216\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"31\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelTitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Configurazione zoom\",\"w\":\"352\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"16\",\"layout_steps_values\":{},\"name\":\"image_help\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"330\",\"y\":\"7\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-right\",\"h\":\"16\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lbl_custom\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"custom\",\"w\":\"43\",\"x\":\"110\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label3\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"group:\",\"w\":\"41\",\"x\":\"183\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lbl_user\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"user:\",\"w\":\"36\",\"x\":\"286\",\"y\":\"35\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomOptions","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomOptions_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomOptions','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblName= "Name:";
String txtConfigName= "";
if(request.getAttribute("SPPortalZoomOptions_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblTable= "Table:";
boolean chkCustom=false;
boolean chk_saveGroup=false;
String lblVqr= "Query file:";
double m_nGroup= 0;
boolean chk_saveUser=false;
double m_nUser= 0;
String txtTable= "";
String txtVQRName= "";
String lblRows= "Rows:";
String lblDefaultBO= "Default BO:";
String lblDefault= "Default:";
String txtGridRows= "";
boolean chkDefault=false;
String lblQueryCount= "CountRows:";
String lblFilters= "Filters:";
boolean chkFilters=false;
boolean chkDefaultBO=false;
String lblOrderBy= "Order by:";
boolean chkCountRows=false;
boolean chkOrderBy=false;
String openerID= "";
String labelTitle= "Configurazione zoom";
String lbl_custom= "custom";
String label3= "group:";
String lbl_user= "user:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomOptions_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomOptions_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomOptions','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblName'  formid='<%=idPortlet%>' ps-name='lblName'    class='label lblName_ctrl'><div id='<%=idPortlet%>_lblNametbl' style='width:100%;'><%=JSPLib.ToHTML("Name:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_txtConfigName_wrp'><input id='<%=idPortlet%>_txtConfigName' name='txtConfigName' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='txtConfigName' /></span>
<span id='<%=idPortlet%>_lblTable'  formid='<%=idPortlet%>' ps-name='lblTable'    class='label lblTable_ctrl'><div id='<%=idPortlet%>_lblTabletbl' style='width:100%;'><%=JSPLib.ToHTML("Table:")%></div></span>
<input id='<%=idPortlet%>_chkCustom' tabindex=1 name='chkCustom' class='checkbox' title=<%=JSPLib.ToHTMLValue("Save configuration in custom directory of current instance" )%> type='checkbox' style=''/>
<input id='<%=idPortlet%>_chk_saveGroup' tabindex=1 name='chk_saveGroup' class='checkbox' title=<%=JSPLib.ToHTMLValue("Save configuration only for the specified group" )%> type='checkbox' style=''/>
<span id='<%=idPortlet%>_lblVqr'  formid='<%=idPortlet%>' ps-name='lblVqr'    class='label lblVqr_ctrl'><div id='<%=idPortlet%>_lblVqrtbl' style='width:100%;'><%=JSPLib.ToHTML("Query file:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_nGroup_wrp'><input id='<%=idPortlet%>_m_nGroup' name='m_nGroup' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='m_nGroup' inputmode='numeric' /></span>
<input id='<%=idPortlet%>_chk_saveUser' tabindex=1 name='chk_saveUser' class='checkbox' title=<%=JSPLib.ToHTMLValue("Save configuration only for the specified user" )%> type='checkbox' style=''/>
<span class='textbox-container'id='<%=idPortlet%>_m_nUser_wrp'><input id='<%=idPortlet%>_m_nUser' name='m_nUser' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='m_nUser' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtTable_wrp'><input id='<%=idPortlet%>_txtTable' name='txtTable' type='text' disabled class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='txtTable' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtVQRName_wrp'><input id='<%=idPortlet%>_txtVQRName' name='txtVQRName' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='txtVQRName' /></span>
<input id='<%=idPortlet%>_btnVqr_New' type='button' class='button btnVqr_New_ctrl' tabindex='1'/>
<span id='<%=idPortlet%>_lblRows'  formid='<%=idPortlet%>' ps-name='lblRows'    class='label lblRows_ctrl'><div id='<%=idPortlet%>_lblRowstbl' style='width:100%;'><%=JSPLib.ToHTML("Rows:")%></div></span>
<input id='<%=idPortlet%>_btnVqr_Edit' type='button' class='button btnVqr_Edit_ctrl' tabindex='1'/>
<input id='<%=idPortlet%>_btnVqr_Query' type='button' class='button btnVqr_Query_ctrl' tabindex='1'/>
<span id='<%=idPortlet%>_lblDefaultBO'  formid='<%=idPortlet%>' ps-name='lblDefaultBO'    class='label lblDefaultBO_ctrl'><div id='<%=idPortlet%>_lblDefaultBOtbl' style='width:100%;'><%=JSPLib.ToHTML("Default BO:")%></div></span>
<span id='<%=idPortlet%>_lblDefault'  formid='<%=idPortlet%>' ps-name='lblDefault'    class='label lblDefault_ctrl'><div id='<%=idPortlet%>_lblDefaulttbl' style='width:100%;'><%=JSPLib.ToHTML("Default:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_txtGridRows_wrp'><input id='<%=idPortlet%>_txtGridRows' name='txtGridRows' type='text' maxlength='3' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='txtGridRows' /></span>
<input id='<%=idPortlet%>_chkDefault' tabindex=1 name='chkDefault' class='checkbox' title=<%=JSPLib.ToHTMLValue("Check it to select default config name" )%> type='checkbox' style=''/>
<span id='<%=idPortlet%>_lblQueryCount'  formid='<%=idPortlet%>' ps-name='lblQueryCount'    class='label lblQueryCount_ctrl'><div id='<%=idPortlet%>_lblQueryCounttbl' style='width:100%;'><%=JSPLib.ToHTML("CountRows:")%></div></span>
<span id='<%=idPortlet%>_lblFilters'  formid='<%=idPortlet%>' ps-name='lblFilters'    class='label lblFilters_ctrl'><div id='<%=idPortlet%>_lblFilterstbl' style='width:100%;'><%=JSPLib.ToHTML("Filters:")%></div></span>
<input id='<%=idPortlet%>_chkFilters' tabindex=1 name='chkFilters' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_chkDefaultBO' tabindex=1 name='chkDefaultBO' class='checkbox' title=<%=JSPLib.ToHTMLValue("Check it to select default BO as query (if exist)" )%> type='checkbox' style=''/>
<span id='<%=idPortlet%>_lblOrderBy'  formid='<%=idPortlet%>' ps-name='lblOrderBy'    class='label lblOrderBy_ctrl'><div id='<%=idPortlet%>_lblOrderBytbl' style='width:100%;'><%=JSPLib.ToHTML("Order by:")%></div></span>
<input id='<%=idPortlet%>_chkCountRows' tabindex=1 name='chkCountRows' class='checkbox' title=<%=JSPLib.ToHTMLValue("Check it if you want count the total number of rows" )%> type='checkbox' style=''/>
<input id='<%=idPortlet%>_chkOrderBy' tabindex=1 name='chkOrderBy' class='checkbox' title=<%=JSPLib.ToHTMLValue("Check it to save column orderby" )%> type='checkbox' style=''/>
<input id='<%=idPortlet%>_btnReset' type='button' class='button btnReset_ctrl' tabindex='1'/>
<span id='<%=idPortlet%>_labelTitle'  formid='<%=idPortlet%>' ps-name='labelTitle'    class='TitleLabel labelTitle_ctrl'><div id='<%=idPortlet%>_labelTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Configurazione zoom")%></div></span>
<div id='<%=idPortlet%>_image_help'><a id='<%=idPortlet%>_image_helphref' href='javascript:Help('portalzoom_interfaccia_base_toolbar_config_opzioni')' target='_self'><img id='<%=idPortlet%>_image_help_img' class='image image_help_ctrl' src="../portalstudio/images/help.png" border='0' ></a>
</div><span id='<%=idPortlet%>_lbl_custom'  formid='<%=idPortlet%>' ps-name='lbl_custom'    class='label lbl_custom_ctrl'><div id='<%=idPortlet%>_lbl_customtbl' style='width:100%;'><%=JSPLib.ToHTML("custom")%></div></span>
<span id='<%=idPortlet%>_label3'  formid='<%=idPortlet%>' ps-name='label3'    class='label label3_ctrl'><div id='<%=idPortlet%>_label3tbl' style='width:100%;'><%=JSPLib.ToHTML("group:")%></div></span>
<span id='<%=idPortlet%>_lbl_user'  formid='<%=idPortlet%>' ps-name='lbl_user'    class='label lbl_user_ctrl'><div id='<%=idPortlet%>_lbl_usertbl' style='width:100%;'><%=JSPLib.ToHTML("user:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomOptions');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomOptions',["350"],["213"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"350","h":"213","title":"","layer":"false","npage":"1"}]);
this.lblName=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblName","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblName","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblName,false,true)%>","type":"Label","w":62,"x":5,"y":33,"zindex":"1"});
this.txtConfigName=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtConfigName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Choose a configuration name","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtConfigName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtConfigName,false,true)%>","w":17,"x":71,"y":33,"zerofilling":false,"zindex":"1","zoom":""});
this.lblTable=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTable","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTable","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblTable,false,true)%>","type":"Label","w":62,"x":5,"y":58,"zindex":"1"});
this.chkCustom=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkCustom","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkCustom","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":93,"y":35,"zindex":"1"});
this.chkCustom.Value(<%=chkCustom%>);
this.chk_saveGroup=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chk_saveGroup","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chk_saveGroup","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":164,"y":35,"zindex":"1"});
this.chk_saveGroup.Value(<%=chk_saveGroup%>);
this.lblVqr=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblVqr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblVqr","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblVqr,false,true)%>","type":"Label","w":62,"x":5,"y":83,"zindex":"1"});
this.m_nGroup=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_nGroup","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":17,"help_tips":"Group code","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_nGroup","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=m_nGroup%>","w":23,"x":224,"y":35,"zerofilling":false,"zindex":"1","zoom":""});
this.chk_saveUser=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-right","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chk_saveUser","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chk_saveUser","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":268,"y":35,"zindex":"1"});
this.chk_saveUser.Value(<%=chk_saveUser%>);
this.m_nUser=new ZtVWeb._TC(this,{"anchor":"top-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_nUser","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":17,"help_tips":"User code","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_nUser","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=m_nUser%>","w":23,"x":323,"y":35,"zerofilling":false,"zindex":"1","zoom":""});
this.txtTable=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTable","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Name of the table","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTable","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTable,false,true)%>","w":275,"x":71,"y":58,"zerofilling":false,"zindex":"1","zoom":""});
this.txtVQRName=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtVQRName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Select the name of the query","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtVQRName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtVQRName,false,true)%>","w":204,"x":71,"y":83,"zerofilling":false,"zindex":"1","zoom":""});
this.btnVqr_New=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnVqr_New_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnVqr_New","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":"Create new query","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnVqr_New","page":1,"tabindex":"1","text":"N","type":"Button","type_submit":"false","type_wizard":"","w":20,"x":278,"y":84,"zindex":"1"});
this.lblRows=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblRows","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblRows","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblRows,false,true)%>","type":"Label","w":60,"x":7,"y":108,"zindex":"1"});
this.btnVqr_Edit=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnVqr_Edit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnVqr_Edit","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":"Edit current query","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnVqr_Edit","page":1,"tabindex":"1","text":"E","type":"Button","type_submit":"false","type_wizard":"","w":20,"x":301,"y":84,"zindex":"1"});
this.btnVqr_Query=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnVqr_Query_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnVqr_Query","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":"Select a query","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnVqr_Query","page":1,"tabindex":"1","text":"...","type":"Button","type_submit":"false","type_wizard":"","w":20,"x":326,"y":84,"zindex":"1"});
this.lblDefaultBO=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDefaultBO","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDefaultBO","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblDefaultBO,false,true)%>","type":"Label","w":67,"x":104,"y":109,"zindex":"1"});
this.lblDefault=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDefault","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDefault","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblDefault,false,true)%>","type":"Label","w":62,"x":5,"y":133,"zindex":"1"});
this.txtGridRows=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtGridRows","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Number of the visible rows in the grid","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"3","name":"txtGridRows","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtGridRows,false,true)%>","w":30,"x":71,"y":108,"zerofilling":false,"zindex":"1","zoom":""});
this.chkDefault=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkDefault","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkDefault","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":71,"y":133,"zindex":"1"});
this.chkDefault.Value(<%=chkDefault%>);
this.lblQueryCount=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblQueryCount","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblQueryCount","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblQueryCount,false,true)%>","type":"Label","w":76,"x":95,"y":133,"zindex":"1"});
this.lblFilters=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblFilters","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblFilters","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblFilters,false,true)%>","type":"Label","w":62,"x":5,"y":158,"zindex":"1"});
this.chkFilters=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkFilters","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkFilters","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":71,"y":158,"zindex":"1"});
this.chkFilters.Value(<%=chkFilters%>);
this.chkDefaultBO=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkDefaultBO","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkDefaultBO","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":175,"y":109,"zindex":"1"});
this.chkDefaultBO.Value(<%=chkDefaultBO%>);
this.lblOrderBy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrderBy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrderBy","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblOrderBy,false,true)%>","type":"Label","w":62,"x":109,"y":158,"zindex":"1"});
this.chkCountRows=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkCountRows","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkCountRows","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":175,"y":133,"zindex":"1"});
this.chkCountRows.Value(<%=chkCountRows%>);
this.chkOrderBy=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkOrderBy","decrypt":false,"edit_undercond":"","encrypt":false,"h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkOrderBy","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"1","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":175,"y":158,"zindex":"1"});
this.chkOrderBy.Value(<%=chkOrderBy%>);
this.btnReset=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnReset_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnReset","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Clear modified data","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnReset","page":1,"tabindex":"1","text":"Reset","type":"Button","type_submit":"false","type_wizard":"","w":45,"x":16,"y":181,"zindex":"1"});
this.OptionsRead=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_OptionsRead","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"OptionsRead","objsValues":"this.setData(evt.optionsData)","page":1,"parmsNames":"optionsData","type":"EventReceiver","w":22,"x":-1,"y":-25});
this.OptionsSet=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_OptionsSet","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"OptionsSet","page":1,"parmsNames":"cfgData","parmsTypes":"","parmsValues":"this.getData()","persistent":"true","type":"EventEmitter","w":22,"x":26,"y":-25});
this.openerID=new ZtVWeb._VC(this,'openerID',null,'character','<%=JSPLib.ToJSValue(openerID,false,true)%>',false,false);
this.splkVQRSelect=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splkVQRSelect","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splkVQRSelect","offline":false,"page":1,"parms":"openerID,VQRName=txtVQRName","popup":"true","popup_height":"440","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fSPPortalZoomOptions_VQRSelect_portlet.jsp","target":"","type":"SPLinker","w":20,"x":176,"y":216});
this.splkVQRSelect.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/SPPortalZoomOptions_VQRSelect_portlet.jsp",request.getSession())%>';
this.splkVQREdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splkVQREdit","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splkVQREdit","offline":false,"page":1,"parms":"filename=txtVQRName","popup":"true","popup_height":"450","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"600","progressbar":false,"refresh":"","servlet":"..\u002fvisualquery\u002findex.jsp","target":"","type":"SPLinker","w":20,"x":151,"y":216});
this.splkVQREdit.m_cID='<%=JSPLib.cmdHash("entity,../visualquery/index.jsp",request.getSession())%>';
this.splkVQRNew=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splkVQRNew","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splkVQRNew","offline":false,"page":1,"parms":"","popup":"true","popup_height":"450","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"600","progressbar":false,"refresh":"","servlet":"..\u002fvisualquery\u002findex.jsp","target":"","type":"SPLinker","w":20,"x":126,"y":216});
this.splkVQRNew.m_cID='<%=JSPLib.cmdHash("entity,../visualquery/index.jsp",request.getSession())%>';
this.labelTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":31,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(labelTitle,false,true)%>","type":"Label","w":352,"x":0,"y":0,"zindex":"1"});
this.image_help=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_help_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_help","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue("Help",false,true)%>","hide":"false","hide_undercond":"","href":"javascript:Help('portalzoom_interfaccia_base_toolbar_config_opzioni')","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image_help","page":1,"path_type":"false","server_side":"","src":"..\u002fportalstudio\u002fimages\u002fhelp.png","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":16,"x":330,"y":7,"zindex":"1"});
this.lbl_custom=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_custom","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":16,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_custom","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lbl_custom,false,true)%>","type":"Label","w":43,"x":110,"y":35,"zindex":"1"});
this.label3=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label3","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label3","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label3,false,true)%>","type":"Label","w":41,"x":183,"y":35,"zindex":"1"});
this.lbl_user=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_user","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_user","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lbl_user,false,true)%>","type":"Label","w":36,"x":286,"y":35,"zindex":"1"});
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
<%request.setAttribute("SPPortalZoomOptions_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomOptions_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof chk_saveGroup_onChange !='undefined')this.chk_saveGroup_onChange=chk_saveGroup_onChange;
if(typeof chk_saveUser_onChange !='undefined')this.chk_saveUser_onChange=chk_saveUser_onChange;
if(typeof chkDefaultBO_onChange !='undefined')this.chkDefaultBO_onChange=chkDefaultBO_onChange;
if(typeof setData !='undefined')this.setData=setData;
if(typeof SetControlsValue !='undefined')this.SetControlsValue=SetControlsValue;
if(typeof btnReset_Click !='undefined')this.btnReset_Click=btnReset_Click;
if(typeof chkDefault_onChange !='undefined')this.chkDefault_onChange=chkDefault_onChange;
if(typeof CheckUI !='undefined')this.CheckUI=CheckUI;
if(typeof getData !='undefined')this.getData=getData;
if(typeof Sync !='undefined')this.Sync=Sync;
if(typeof SetEmitterName !='undefined')this.SetEmitterName=SetEmitterName;
if(typeof SetReceiverName !='undefined')this.SetReceiverName=SetReceiverName;
if(typeof btnVqr_Query_Click !='undefined')this.btnVqr_Query_Click=btnVqr_Query_Click;
if(typeof txtVQRName_Lostfocus !='undefined')this.txtVQRName_Lostfocus=txtVQRName_Lostfocus;
if(typeof btnVqr_Edit_Click !='undefined')this.btnVqr_Edit_Click=btnVqr_Edit_Click;
if(typeof btnVqr_New_Click !='undefined')this.btnVqr_New_Click=btnVqr_New_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>

function this_Loaded(){
 this.chk_saveGroup_onChange();
 this.chk_saveUser_onChange();
}
function chk_saveGroup_onChange(){
 if (this.chk_saveGroup.Value()) {
  this.m_nGroup.Enabled();
  this.chk_saveUser.Value(false);
 } else {
  this.m_nGroup.Disabled();
  this.m_nGroup.Value("");
 }
}
function chk_saveUser_onChange(){
 if (this.chk_saveUser.Value()) {
  this.m_nUser.Enabled();
  this.chk_saveGroup.Value(false);
 } else {
  this.m_nUser.Disabled();
  this.m_nUser.Value("");
 }
}
<%
boolean canChangeQuery=sp.CanAccessEditor("PortalStudio");

if (sp.IsPortalZoomHelpInstalled()) {%>
  ZtVWeb.RequireLibrary('../spportalzoom_help.js');
<%}%>
if (typeof(anchorToFeature)=='undefined'){
  this.image_help.Hide();
}
var canChangeQuery=<%=canChangeQuery%>;
var defaultBO="";
if (!canChangeQuery) {
  this.txtVQRName.Disabled();
  this.btnVqr_New.Disabled();
  this.btnVqr_Edit.Disabled();
  this.btnVqr_Query.Disabled();
  this.chkDefaultBO.Disabled();
}
this.chkFilters.Disabled();
this.openerID.Value(this.formid);
var emptyData={
  Table: '',
  ConfigName: '',
  VQRName: '',
  GridRows:'',
  Default: false,
  Filters: false,
  OrderBy: false,
  CountRows: false,
  User : 0,
  Group : 0,
  Custom : false
};
var localData=emptyData;
function chkDefaultBO_onChange(){
 var def=this.chkDefaultBO.Value();
//  this.txtVQRName.ReadOnly(def);
  if(this.chkDefaultBO.Value()){
    this.txtVQRName.Value(defaultBO);
    this.txtVQRName.Disabled();
    this.btnVqr_Edit.Disabled();
    this.btnVqr_Query.Disabled();
  }else{
    this.txtVQRName.Value(localData.VQRName);
    this.txtVQRName.Enabled();
    this.btnVqr_Edit.Enabled();
    this.btnVqr_Query.Enabled();
   this.txtVQRName_Lostfocus();
  }
}
function setData(dati){
  localData={
    Table:      IsAny(dati.Table)      ? dati.Table      : localData.Table,
    ConfigName: IsAny(dati.ConfigName) ? dati.ConfigName : localData.ConfigName,
    VQRName:    IsAny(dati.VQRName)    ? dati.VQRName    : localData.VQRName,
    GridRows:   IsAny(dati.GridRows)   ? dati.GridRows   : localData.GridRows,
    Default:    IsAny(dati.Default)    ? dati.Default    : localData.Default,
    Filters:    IsAny(dati.Filters)    ? dati.Filters    : localData.Filters,
    OrderBy:    IsAny(dati.OrderBy)    ? dati.OrderBy    : localData.OrderBy,
    CountRows:  IsAny(dati.CountRows)  ? dati.CountRows  : localData.CountRows,
    User:       IsAny(dati.User)       ? dati.User       : localData.User,
    Group:      IsAny(dati.Group)      ? dati.Group      : localData.Group,
    Custom:     IsAny(dati.Custom)     ? dati.Custom     : localData.Custom
  }
  defaultBO =   IsAny(dati.DefaultBO)  ? dati.DefaultBO  : "";
  this.SetControlsValue();
}
function SetControlsValue(){
  this.txtTable.Value(localData.Table);
  this.txtConfigName.Value(localData.ConfigName);
  this.txtVQRName.Value(localData.VQRName);
  this.txtGridRows.Value(localData.GridRows+"");
  this.chkDefault.Value(localData.Default || EmptyString(localData.ConfigName));
  this.chkDefaultBO.Value(localData.VQRName==defaultBO || (localData.VQRName.indexOf('[')!=-1 && localData.VQRName.substr(0,localData.VQRName.indexOf('['))==defaultBO.substr(0,defaultBO.indexOf('[')) &&
      localData.VQRName.substr(localData.VQRName.indexOf('[')).toUpperCase()==defaultBO.substr(defaultBO.indexOf('[')).toUpperCase()));
  this.chkFilters.Value(localData.Filters);
  this.chkOrderBy.Value(localData.OrderBy);
  this.chkCountRows.Value(localData.CountRows);
  if (localData.User>0) {
    this.chk_saveUser.Value(true);
    this.m_nUser.Value(localData.User);
  } else {
    this.chk_saveUser.Value(false);
    this.m_nUser.Value("");
  }
  if (localData.Group>0) {
    this.chk_saveGroup.Value(true);
    this.m_nGroup.Value(localData.Group);
  } else {
    this.chk_saveGroup.Value(false);
    this.m_nGroup.Value("");
  }
  this.chkCustom.Value(localData.Custom);
  this.CheckUI();
}
function btnReset_Click(){
  this.SetControlsValue();
}
function chkDefault_onChange(){
  this.CheckUI();
}
function CheckUI(){
//  var def=this.chkDefault.Value();
//  this.txtConfigName.ReadOnly(def);
  if(this.chkDefault.Value()){
    this.txtConfigName.Value("default");
  }else{
    this.txtConfigName.Value(localData.ConfigName);
  }
  this.chkDefaultBO_onChange();
//  this.txtVQRName_Lostfocus();
}
function getData(fill){
  fill=fill||{};
  var this_portlet=this;
  fill.Table=      this_portlet.txtTable.Value();
  fill.ConfigName= this_portlet.txtConfigName.Value()||'default';
  fill.VQRName=    this_portlet.txtVQRName.Value();
  fill.GridRows=   Val(this_portlet.txtGridRows.Value());
  //fill.Filters=  this_portlet.chkFilters.Value();
  fill.OrderBy=    this_portlet.chkOrderBy.Value();
  fill.CountRows=  ""+this_portlet.chkCountRows.Value();
  fill.Custom =    this_portlet.chkCustom.Value();
  fill.Group  =    (this_portlet.chk_saveGroup.Value()?this_portlet.m_nGroup.Value()||0:0);
  fill.User   =    (this_portlet.chk_saveUser.Value()?this_portlet.m_nUser.Value()||0:0);
  return fill;
}
function Sync(){
  this.SetEmitterName();
  this.SetReceiverName();
}
function SetEmitterName(){
  var pref=this.container.GetListenersPrefix();
  this.OptionsSet.name=pref+'OptionsSet';
}
function SetReceiverName(){
  var pref=this.container.GetListenersPrefix();
  this['on_'+pref+'OptionsRead']=function(parmsObj){
    this.OptionsRead.receiveFnc(parmsObj);
  };
}
function btnVqr_Query_Click(){
  this.splkVQRSelect.Link();
}
this['on_'+this.formid+'_ChangeVQRName']=function(name){
  this.txtVQRName.Value(name);
}
function txtVQRName_Lostfocus(){
  var v=this.txtVQRName.Value();
  if(EmptyString(v)){
    this.btnVqr_Edit.Disabled();
  }else{
    if (canChangeQuery) {
      this.btnVqr_Edit.Enabled();
    }
  }
}
function btnVqr_Edit_Click(){
  this.splkVQREdit.Link();
}
function btnVqr_New_Click(){
  this.splkVQRNew.Link();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomOptions_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_OptionsRead=function(parmsObj){<%=idPortlet%>.OptionsRead.receiveFnc(parmsObj);}
window.<%=idPortlet%>.OptionsSet.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomOptions',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomOptions');
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
sp.endPage("SPPortalZoomOptions");
}%>
<%! public String getJSPUID() { return "621581049"; } %>