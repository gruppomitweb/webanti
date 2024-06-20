<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\n\u003c%if(\"true\".equals(sp.getParameter(\"SPFromFrontEnd\",\"\")) &&  !(sp.CanAccessEditor(\"PortalStudio\") || \"S\".equals(sp.getGlobal(\"g_PortalSamples\",\"\")))){%\u003e\nwindow.location='..\u002fjsp-system\u002fSPLogin.jsp?m_cURL=\u003c%=JSPLib.ToJSValue(request.getRequestURI()+(!\"\".equals(JSPLib.getParametersList(request))?\"&\":\"\")+JSPLib.getParametersList(request),false)%\u003e'\n\u003c%}%\u003e\n\u003c%\njava.util.regex.Pattern validVarName = java.util.regex.Pattern.compile(\"[a-zA-Z_$][a-zA-Z_$0-9]*\");\nint configMode=sp.ZoomConfigMode();\nboolean canPrint = sp.CanPrintZoom();\n\u002f\u002f Necessario il nome della tabella\nif ( Library.Lib.IsValidTableName(Table) ) {\nString sqpkey=JSPLib.cmdHash(Table,request.getSession());\nif (configMode\u003e0 && sp.IsPortalZoomHelpInstalled()){\n%\u003eZtVWeb.RequireLibrary(\"..\u002fspportalzoom_help.js\");\u003c%\n}\n%\u003e\ndocument.getElementById(this.formid+\"_tabcontainer\").style.display='none';\nthis.refresh_menu.Hide();\nthis.configModeSecurity=\u003c%=configMode%\u003e;\nthis.printModeSecurity = \u003c%=canPrint%\u003e;\nthis.Var=function(val){\n  this.val=val;\n  this.Value=function(val){\n    if(arguments.length) this.val=val;\n    return this.val;\n  }\n}\n\n\u003c%\n  if (!Library.Empty(Tools_Imgs)) {\n    String[] toolsImgsArray = Tools_Imgs.split(\",\");\n    for (int idx = 0; idx \u003c toolsImgsArray.length; idx++) {\n      String currToolImg = sp.getThemedImage(toolsImgsArray[idx]);\n      if (!\"..\u002f\".equals(currToolImg) && !(\"..\u002f\"+sp.getSkin()+\"\u002f\").equals(currToolImg) )\n        toolsImgsArray[idx] = currToolImg;\n    }\n    String newToolsImgs=\"\", sep = \"\";\n    for (int idx = 0; idx \u003c toolsImgsArray.length; idx++) {\n      newToolsImgs+= sep + toolsImgsArray[idx];\n      sep = \",\";\n    }\n%\u003e\nthis.Tools_Imgs.Value(\u003c%=JSPLib.ToJSValue(newToolsImgs,true)%\u003e);\n\u003c%  \n  }\n  String queryParms=\"\",parmsToSend=\"\";\n  Enumeration e=sp.getParameters();\n  String p,v,o=\"\",parms=\"\";\n  while(e.hasMoreElements()){\n    p=(String)e.nextElement();\n    if(p.equals(\"QueryParms\")){\n      String s = sp.getParameter(p,\"\");\n      String namevalue,name,value;\n      int numParams = JSPLib.countChar('=',s);\n      int pStart, pStop=0, pEqual;\n      for(int i=0; i\u003cnumParams; i++) {\n        pEqual = JSPLib.At(\"=\",s,i+2);\n        pStart = pStop+1;\n        if (pEqual==0)\n          pStop += JSPLib.RAt(\",\",JSPLib.Substr(s,pStart));\n        else\n          pStop += JSPLib.RAt(\",\",JSPLib.Substr(s,pStart,pEqual-pStart+1));\n        namevalue=JSPLib.Substr(s, pStart, pStop-pStart);\n        name=JSPLib.Left(namevalue,JSPLib.At(\"=\",namevalue)-1);\n        value=java.net.URLDecoder.decode(JSPLib.Right(namevalue,JSPLib.Len(namevalue)-JSPLib.At(\"=\",namevalue)),Library.m_cResponseEncoding);\n        if(name.length()\u003e0 && validVarName.matcher(name).matches()){\n          queryParms+=name+\",\";\n          o+=\"this.\"+name+\"=new this.Var('\"+JSPLib.ToJSValue(value)+\"');\";\n          parmsToSend+=name+\"=\"+java.net.URLEncoder.encode(value,Library.m_cResponseEncoding)+\"&\";\n        }\n      }\n    }\n    else if(p.startsWith(\"w_\")){\n      if (validVarName.matcher(p).matches()) {\n        queryParms += p+\",\";\n        o+=\"this.\"+p+\"=new this.Var('\"+JSPLib.ToJSValue(sp.getParameter(p,\"\"))+\"');\";\n      }\n    }\n    else if(p.startsWith(\"m_\") && !\"m_cWv\".equals(p) && !\"m_cRegionalSettings\".equals(p)){\n      if (validVarName.matcher(p).matches()) {\n      \to+=\"this.\"+p+\"=new this.Var('\"+JSPLib.ToJSValue(sp.getParameter(p,\"\"))+\"');\";\n      }\n    }\n    parms+=p+\" \";\n  }\n  if(!\"\".equals(queryParms)){\n    queryParms.substring(0, queryParms.length()-1);\n  }\n%\u003e\n\u003c%=o%\u003e\nvar queryParms=\u003c%=Library.ToJSValue(queryParms,\"C\",0,0)%\u003e;\nthis.presetParams=queryParms;\n\u002f\u002fparms=\u003c%=Library.toHTMLValue(parms,\"C\",0,0)%\u003e;\nthis.dataobj.parms+=','+queryParms;\nthis.dataobj2.parms+=','+queryParms;\nthis.vzmstructure=\u003c%\nif(!\"\".equals(Table)){\n  String sqlcmd=\"vzm:\"+Table;\n  if(!\"\".equals(ConfigName)){\n    sqlcmd+=\".\"+ConfigName;\n  }else{\n    sqlcmd+=\".default\";\n  }\n  pageContext.include(\"..\u002fservlet\u002fSQLDataProviderServer?sqlcmd=\"+sqlcmd+\"&SPVZMStructureOnly=true&cmdhash=\"+sqpkey+\"&queryParms=\"+queryParms+\"&\"+parmsToSend);\n  out.print(\";\u002f\u002f\"+Library.toHTMLValue(sqlcmd,\"C\",0,0));\n}else{\n  out.print(\"null;\");\n  out.print(\"\u002f\u002fno Table specified\");\n}\n%\u003e;\nthis.dataobj.cmdHash='\u003c%=sqpkey%\u003e'\nthis.dataobj2.cmdHash='\u003c%=sqpkey%\u003e'\nthis.Caption.Value(\u003c%\nif(!\"\".equals(Caption)){\nout.print(\"'\"+JSPLib.ToJSValue(sp.translate(Caption))+\"'\");\n}\n%\u003e);\nthis.PrintTitle.Value(\u003c%\nif(!\"\".equals(PrintTitle)){\nout.print(\"'\"+JSPLib.ToJSValue(sp.translate(PrintTitle))+\"'\");\n}\n%\u003e);\n\u003c%\nif (!\"\".equals(Tools_Tooltips)){\nout.println(\"this.Tools_Tooltips.Value('\"+JSPLib.ToJSValue(sp.translate(Tools_Tooltips))+\"')\");\n}\n%\u003e\n\u003c%\nif (!\"\".equals(Tools_Titles)){\nout.println(\"this.Tools_Titles.Value('\"+JSPLib.ToJSValue(sp.translate(Tools_Titles))+\"')\");\n}\n%\u003e\n\nif(typeof window.TransDict=='undefined') {\n  window.TransDict = new Array();\n}\nwindow.TransDict['MSG_EDIT_AND_SPLIT']= \u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_EDIT_AND_SPLIT\"),\"C\",0,0)%\u003e\nZtVWeb.AddTranslation('MSG_ZOOM_ACTIONS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_ZOOM_ACTIONS\"),\"C\",0,0)%\u003e);\ndoZoom.call(this);\n\nfunction dataobj_QueryExecuted(){\n  this.dataobj_QueryExecuted_Impl();\n}\nfunction Grid_Rendered(){\n  this.Grid_Rendered_Online();\n}\n    \nthis.startZoom();\n\n\u003c%}%\u003e","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"0","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"SPPortalZoom","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"none\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"SPPortalZoomtTabs\",\"selector\":\".SPPortalZoom .SPPortalZoomtTabs, .SPPortalZoomtTabs\",\"id\":\"form\",\"code\":\".SPPortalZoom .SPPortalZoomtTabs, .SPPortalZoomtTabs {\\n  display: none;\\n}\\n\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ label }}{{ toolbar }}{{ box_tiles }}{{ Grid }}{{ Chart }}{{ label2 }}{{ GridChart }}{{ refresh_menu }}{{ menu_versioni }}{{ toolbar2 }}{{ @label }}{{ @toolbar }}{{ @box_tiles }}{{ @Grid }}{{ @Chart }}{{ @label2 }}{{ @GridChart }}{{ @refresh_menu }}{{ @menu_versioni }}{{ @toolbar2 }}\u003c\u002fbody\u003e","grapesCss":"","h":"50,50","hsl":"","htmlcode":"{{ @label }}\n{{ @toolbar }}\n{{ @box_tiles }}\n{{ @Grid }}\n{{ @Chart }}\n{{ @label2 }}\n{{ @GridChart }}\n{{ @refresh_menu }}\n{{ @menu_versioni }}\n{{ @toolbar2 }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ dataobj }}\n{{ splinker }}\n{{ action_splinker }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ CfgColumnRead }}\n{{ CfgColumnSet }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ parent_splinker }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ label }}\n{{ toolbar }}\n{{ OptionsRead }}\n{{ OptionsSet }}\n{{ box_tiles }}\n{{ Grid }}\n{{ splinker_hist }}\n{{ Table }}\n{{ EventName }}\n{{ Autozoom }}\n{{ EmitterName }}\n{{ PKFields }}\n{{ ReceiverName }}\n{{ Extensible }}\n{{ ToolsbarState }}\n{{ GridRows }}\n{{ Caption }}\n{{ ConfigGridElements }}\n{{ RowMinHeight }}\n{{ ConfigName }}\n{{ Popup }}\n{{ PopupH }}\n{{ PopupW }}\n{{ WaitForFilter }}\n{{ DetailBehavior }}\n{{ AllowOrderBy }}\n{{ SPZTL }}\n{{ FilterOnFields }}\n{{ EntityType }}\n{{ InheritedPKFields }}\n{{ VQRName }}\n{{ Linkzoom }}\n{{ SetDelMessage }}\n{{ SPVZM_action }}\n{{ Linkzoomprg }}\n{{ Tools_Position }}\n{{ SPVZM_vqr }}\n{{ UID }}\n{{ OpenerFormId }}\n{{ GridRowsParam }}\n{{ Tools_Titles }}\n{{ FillEmptyKey }}\n{{ Tools_Urls }}\n{{ RowsParamValid }}\n{{ LinkedField }}\n{{ DefaultsRoutine }}\n{{ Tools_Targets }}\n{{ FieldFilter }}\n{{ QueryCount }}\n{{ Tools_Imgs }}\n{{ FixedFilter }}\n{{ MemoChars }}\n{{ Tools_Tooltips }}\n{{ FixedFilterURL }}\n{{ m_dHistoricalLoadStart }}\n{{ QueryParms }}\n{{ InitEntityFields }}\n{{ HistoryFilterDate }}\n{{ LoadedRecords }}\n{{ m_cWv }}\n{{ totalizer }}\n{{ PopupAtExit }}\n{{ ActivateCheckbox }}\n{{ ConfigScroll }}\n{{ GridMinHeight }}\n{{ ActivateCheckboxAll }}\n{{ ConfigNavbar }}\n{{ FrontendPort }}\n{{ $entity$_GetConfigurationField }}\n{{ PrintMode }}\n{{ LayerInterface }}\n{{ ViewMode }}\n{{ Chart }}\n{{ label2 }}\n{{ GridChart }}\n{{ dataobj2 }}\n{{ refresh_menu }}\n{{ menu_versioni }}\n{{ spl_smartreport }}\n{{ ReportName }}\n{{ m_dNewHistoricalCPFromDate }}\n{{ toolbar2 }}\n{{ PrintTitle }}\n{{ AdvancedSuggester }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"\u003c%=SPPrxycizer.proxycizedPath(\"SPPortalZoom.js\")%\u003e","offline":"","on_security_failure":"login","page_layer":"","pages":"1,2","pagesProp":"[{\"title\":\"Grid\",\"layer\":\"\",\"h\":\"50\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"Grid\",\"layer\":\"\",\"h\":\"50\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Grid,Grid","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"SPPortalZoomtTabs","tabstrip_hidden":"true","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"150","version":"37","w":"100%,100%","wizard":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_NumberOfLoadedRecords","page":"1","parmsNames":"numRecords","parmsTypes":"func","parmsValues":"this.getNumRecords()","persistent":"true","sequence":"1","type":"EventEmitter","w":"22","x":"448","y":"-38"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","init_time":"0","localDBName":"","long_query":"false","n_records":"15","name":"dataobj","offline":"","page":"1","parms":"Autozoom,Linkzoom,Linkzoomprg,DefaultsRoutine,FieldFilter,FixedFilter,SPVZM_action,SPVZM_vqr,SPZTL,HistoryFilterDate,UID","parms_source":"","query":"","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"30","waiting_mgs":"","x":"623","y":"16"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"splinker","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"2","servlet":"","target":"","type":"SPLinker","w":"30","x":"153","y":"-37"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"","name":"action_splinker","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"false","sequence":"3","servlet":"","target":"","type":"SPLinker","w":"30","x":"160","y":"3"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_zoomSetFilter","objsValues":"this.SetFilter(evt)","page":"1","parmsNames":"","sequence":"4","type":"EventReceiver","w":"22","x":"262","y":"-38"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_savedEntity","objsValues":"this.refreshQuery(true)","page":"1","parmsNames":"","sequence":"5","type":"EventReceiver","w":"22","x":"233","y":"-38"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"CfgColumnRead","page":"1","parmsNames":"cfgData","parmsTypes":"func","parmsValues":"this.CfgColumnSend()","persistent":"true","sequence":"6","type":"EventEmitter","w":"22","x":"310","y":"-38"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"CfgColumnSet","objsValues":"this.CfgColumnReceive(evt.cfgData)","page":"1","parmsNames":"cfgData","sequence":"7","type":"EventReceiver","w":"22","x":"340","y":"-38"},{"broadcast":"internal","ctrlOfVariant":"","eventsNames":"RecordChanged,RecordChanged","eventsObjs":"dataobj,dataobj2","h":"20","name":"$entity$_zoomSelectedRow","page":"1","parmsNames":"row,RS_EOF,forceRC","parmsTypes":"func,func,func","parmsValues":"this.GetRS(),this.GetRS_EOF(),this.dataobj.GetForceRecordChanged()","persistent":"true","sequence":"8","type":"EventEmitter","w":"22","x":"694","y":"20"},{"broadcast":"internal","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_callChildren","page":"1","parmsNames":"configuration","parmsTypes":"func","parmsValues":"this.GetConfiguration()","persistent":"true","sequence":"9","type":"EventEmitter","w":"22","x":"726","y":"20"},{"broadcast":"pagelet","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_updateFilters","page":"1","parmsNames":"Filters","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","sequence":"10","type":"EventEmitter","w":"22","x":"758","y":"20"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"editload","name":"parent_splinker","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"","target":"","type":"SPLinker","w":"30","x":"188","y":"-37"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_updateConfiguration","page":"1","parmsNames":"Config,reload","parmsTypes":"func,func","parmsValues":"this.Config(),this.GetReload()","persistent":"true","sequence":"12","type":"EventEmitter","w":"22","x":"233","y":"-10"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_deletedEntity","objsValues":"this.refreshQuery(true)","page":"1","parmsNames":"","sequence":"13","type":"EventReceiver","w":"22","x":"262","y":"-10"},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"10","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"90","wireframe_props":"align,value,n_col","x":"10","y":"0","zindex":"1","zone":""},{"FAB":"","anchor":"top-left(%)-right","bg_color":"","css_class":"spportalzoombase_toolbar","ctrlOfVariant":"","fixed":"","h":"10","hide":"false","iconWidth":"25","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"toolbar","page":"1","rapp":"","sequence":"15","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"50","wireframe_props":"","x":"100","y":"0","zindex":"3","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"OptionsRead","page":"1","parmsNames":"optionsData","parmsTypes":"func","parmsValues":"this.Options()","persistent":"true","sequence":"16","type":"EventEmitter","w":"22","x":"310","y":"0"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"OptionsSet","objsValues":"this.Options(evt.optionsData)","page":"1","parmsNames":"optionsData","sequence":"17","type":"EventReceiver","w":"22","x":"340","y":"0"},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"PortalZoomBase_container_tiles","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"10","hide":"true","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"box_tiles","page":"1","rapp":"","sequence":"18","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"150","wireframe_props":"","x":"0","y":"10","zindex":"2","zone":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"0","cellspacing":"0","checkbox":"false","checkbox_fields":"","colProperties":"","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"grid_navbar","css_class_row":"grid_row","css_class_row_odd":"grid_rowodd","css_class_row_over":"grid_rowover","css_class_row_selected":"grid_rowselected","css_class_title":"grid_title","css_class_title_hover":"grid_titleover","ctrlOfVariant":"","dataobj":"dataobj","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"true","empty_rows":"true","extensible":"false","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"30","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"Grid","nav_bar":"true","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"true","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"true","render_totals":"true","resizablecolumns":"true","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"19","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"splinker","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"center","w":"150","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"20","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"splinker_hist","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"","sequence":"20","servlet":"","target":"","type":"SPLinker","w":"30","x":"194","y":"3"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Table","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"54"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"EventName","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"54"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Autozoom","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"76"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"EmitterName","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"76"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PKFields","page":"1","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ReceiverName","page":"1","reactive":"","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Extensible","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ToolsbarState","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"448","y":"98"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"GridRows","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"numeric","w":"146","x":"152","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Caption","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfigGridElements","page":"1","reactive":"","sequence":"31","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"RowMinHeight","page":"1","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"numeric","w":"146","x":"448","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfigName","page":"1","reactive":"","sequence":"33","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"142"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Popup","page":"1","reactive":"","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"142"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PopupH","page":"1","reactive":"","sequence":"35","server_side":"false","type":"Variable","typevar":"numeric","w":"146","x":"301","y":"142"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PopupW","page":"1","reactive":"","sequence":"36","server_side":"false","type":"Variable","typevar":"numeric","w":"146","x":"448","y":"142"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"WaitForFilter","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"164"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"DetailBehavior","page":"1","reactive":"","sequence":"38","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"164"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"AllowOrderBy","page":"1","reactive":"","sequence":"39","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"164"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"SPZTL","page":"1","reactive":"","sequence":"40","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"448","y":"164"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FilterOnFields","page":"1","reactive":"","sequence":"41","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"186"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"EntityType","page":"1","reactive":"","sequence":"42","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"186"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"InheritedPKFields","page":"1","reactive":"","sequence":"43","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"208"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"VQRName","page":"1","reactive":"","sequence":"44","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"208"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Linkzoom","page":"1","reactive":"","sequence":"45","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"208"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"SetDelMessage","page":"1","reactive":"","sequence":"46","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"230"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"SPVZM_action","page":"1","reactive":"","sequence":"47","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"230"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Linkzoomprg","page":"1","reactive":"","sequence":"48","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"230"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Tools_Position","page":"1","reactive":"","sequence":"49","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"252"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"SPVZM_vqr","page":"1","reactive":"","sequence":"50","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"252"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"UID","page":"1","reactive":"","sequence":"51","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"252"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"OpenerFormId","page":"1","reactive":"","sequence":"52","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"448","y":"253"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"GridRowsParam","page":"1","reactive":"","sequence":"53","server_side":"false","type":"Variable","typevar":"numeric","w":"146","x":"0","y":"274"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Tools_Titles","page":"1","reactive":"","sequence":"54","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"274"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FillEmptyKey","page":"1","reactive":"","sequence":"55","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"301","y":"274"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Tools_Urls","page":"1","reactive":"","sequence":"56","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"296"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"RowsParamValid","page":"1","reactive":"","sequence":"57","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"0","y":"296"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"LinkedField","page":"1","reactive":"","sequence":"58","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"296"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"DefaultsRoutine","page":"1","reactive":"","sequence":"59","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"448","y":"296"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Tools_Targets","page":"1","reactive":"","sequence":"60","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"318"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FieldFilter","page":"1","reactive":"","sequence":"61","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"318"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"QueryCount","page":"1","reactive":"","sequence":"62","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"318"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Tools_Imgs","page":"1","reactive":"","sequence":"63","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"340"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FixedFilter","page":"1","reactive":"","sequence":"64","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"340"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"MemoChars","page":"1","reactive":"","sequence":"65","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"340"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"Tools_Tooltips","page":"1","reactive":"","sequence":"66","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"362"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FixedFilterURL","page":"1","reactive":"","sequence":"67","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"362"},{"calculate":"","ctrlOfVariant":"","dataobj":"dataobj","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"cpfromdate","h":"22","init":"","init_par":"","name":"m_dHistoricalLoadStart","page":"1","reactive":"","sequence":"68","server_side":"false","type":"Variable","typevar":"date","w":"146","x":"0","y":"362"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"QueryParms","page":"1","reactive":"","sequence":"69","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"384"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"InitEntityFields","page":"1","reactive":"","sequence":"70","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"448","y":"384"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"request","name":"HistoryFilterDate","page":"1","reactive":"","sequence":"71","server_side":"false","type":"Variable","typevar":"date","w":"146","x":"301","y":"406"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"request","name":"LoadedRecords","page":"1","reactive":"","sequence":"72","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"427"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"request","name":"m_cWv","page":"1","reactive":"","sequence":"73","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"449"},{"alias":"","ctrlOfVariant":"","dataobj":"dataobj","descr":"","fields":"","groupby_fields":"","h":"30","name":"totalizer","orderby_fields":"","page":"1","picture":"","sequence":"74","type":"SQLTotalizer","w":"30","x":"656","y":"16"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PopupAtExit","page":"1","reactive":"","sequence":"75","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"596","y":"143"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ActivateCheckbox","page":"1","reactive":"","sequence":"76","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"595","y":"165"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ConfigScroll","page":"1","reactive":"","sequence":"77","server_side":"false","type":"Variable","typevar":"character","w":"93","x":"595","y":"188"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"GridMinHeight","page":"1","reactive":"","sequence":"78","server_side":"false","type":"Variable","typevar":"character","w":"102","x":"596","y":"212"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ActivateCheckboxAll","page":"1","reactive":"","sequence":"79","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"595","y":"236"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ConfigNavbar","page":"1","reactive":"","sequence":"80","server_side":"false","type":"Variable","typevar":"character","w":"147","x":"595","y":"118"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FrontendPort","page":"1","reactive":"","sequence":"81","server_side":"false","type":"Variable","typevar":"numeric","w":"141","x":"301","y":"54"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_GetConfigurationField","page":"1","parmsNames":"Fields","parmsTypes":"func","parmsValues":"this.GetConfigurationField()","persistent":"true","sequence":"82","type":"EventEmitter","w":"22","x":"521","y":"11"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"false","name":"PrintMode","page":"1","reactive":"","sequence":"83","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"301","y":"470"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"21","init":"","init_par":"request","name":"LayerInterface","page":"1","reactive":"","sequence":"84","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"301","y":"491"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ViewMode","page":"1","reactive":"","sequence":"85","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"0","y":"384"},{"anchor":"","auto_exec":"true","ccolor":"","chartH":"","chartNavbar":"true","chartNavbarAddRemove":"","chartNavbarChangepage":"true","chartNavbarFirstlast":"true","chartNavbarLastpage":"true","chartNavbarPagepanel":"true","chartW":"","chart_type":"category","compactChart":"","cstroke":"","ctooltip":"","ctrlOfVariant":"","ctype":"","cursorAlignment":"left","cursorPosition":"top","cursorType":"none","danimation":"","data_order":"default","dataobj":"dataobj2","def":"","downloadlist":"","elanimate":"","enable_change_order":"false","enable_menu_sel":"false","exclSer":"","exclicks":"","exportFileName":"","fixed":"","focuskey":"","gendataset":"false","grch_domain":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":"15","hide":"false","key_start":"","layer":"false","layout_steps_values":"{}","legend":"","legendlimit":"","linkparms":"","max_value":"","menuPosition":"","min_value":"","multi_key_field":"","multi_label_field":"","multi_scale":"true","multidimKeyName":"","multisubdivision":"default","multisubheight":"","name":"Chart","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"","othtype":"","page":"2","parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":"true","popup_height":"","popup_type":"","popup_width":"","portletsrc":"","query":"","rangebands":"","rangefunc":"","rapp":"","refline":"","reflinecol":"","selclicks":"","sequence":"86","spuid":"","subtitle":"","target":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","value_labels":"","vaxis_precision":"","vmode":"","w":"40","wireframe_props":"","x":"1","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","y":"20","y_label":"","zfseries":"","zfshow":"","zftype":"default","zindex":"","zone":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"TITLE","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"10","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"87","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1","zone":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"10","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"GridChart","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"1","scroll_bars":"false","sequence":"88","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"true","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":"150","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"10","zindex":"","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","init_time":"0","localDBName":"","long_query":"false","n_records":"15","name":"dataobj2","offline":"","page":"2","parms":"Autozoom,Linkzoom,Linkzoomprg,DefaultsRoutine,FieldFilter,FixedFilter,SPVZM_action,SPVZM_vqr,SPZTL,HistoryFilterDate","parms_source":"","query":"","query_async":"true","return_fields_type":"true","sequence":"89","type":"SQLDataobj","w":"30","waiting_mgs":"","x":"-17","y":"76"},{"anchor":"top-left","bg_color":"","class_Css":"SPPortalZoomBaseMenu","color":"","ctrlOfVariant":"","fixed":"","fontSize":"","h":"40","hide":"true","layer":"false","layout_steps_values":"{}","maxsubitemelements":"5","name":"refresh_menu","page":"1","rapp":"","sequence":"90","spuid":"","type":"HamburgerMenu","visible_handler":"true","w":"40","wireframe_props":"","x":"400","y":"0","zindex":"","zone":""},{"anchor":"top-left","bg_color":"","class_Css":"SPPortalZoomBaseMenuVersion","color":"","ctrlOfVariant":"","fixed":"","fontSize":"","h":"40","hide":"true","layer":"false","layout_steps_values":"{}","maxsubitemelements":"5","name":"menu_versioni","page":"1","rapp":"","sequence":"91","spuid":"","type":"HamburgerMenu","visible_handler":"false","w":"40","wireframe_props":"","x":"448","y":"0","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"smartreport","h":"30","m_cAction":"","name":"spl_smartreport","offline":"","page":"1","parms":"ReportName","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"92","servlet":"","target":"","type":"SPLinker","w":"30","x":"575","y":"-38"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"ReportName","page":"1","reactive":"","sequence":"93","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"624","y":"-37"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"m_dNewHistoricalCPFromDate","page":"1","reactive":"","sequence":"94","server_side":"false","type":"Variable","typevar":"date","w":"122","x":"598","y":"295"},{"FAB":"","anchor":"top-left(%)-right","bg_color":"","css_class":"spportalzoombase_toolbar","ctrlOfVariant":"","fixed":"","h":"10","hide":"false","iconWidth":"25","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"toolbar2","page":"2","rapp":"","sequence":"95","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"50","wireframe_props":"","x":"100","y":"0","zindex":"4","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PrintTitle","page":"1","reactive":"","sequence":"96","server_side":"false","type":"Variable","typevar":"character","w":"122","x":"624","y":"-12"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"AdvancedSuggester","page":"1","reactive":"","sequence":"97","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"152","y":"406"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"pParent","page":"1","reactive":"","sequence":"98","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"456","y":"436"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:Table,EventName,Autozoom,EmitterName,PKFields,ReceiverName,Extensible,ToolsbarState,GridRows,Caption,ConfigGridElements,RowMinHeight,ConfigName,Popup,PopupH,PopupW,WaitForFilter,DetailBehavior,AllowOrderBy,SPZTL,FilterOnFields,EntityType,InheritedPKFields,Linkzoom,SetDelMessage,Linkzoomprg,Tools_Position,UID,OpenerFormId,Tools_Titles,FillEmptyKey,Tools_Urls,LinkedField,DefaultsRoutine,Tools_Targets,FieldFilter,QueryCount,Tools_Imgs,FixedFilter,MemoChars,Tools_Tooltips,FixedFilterURL,QueryParms,InitEntityFields,HistoryFilterDate,LoadedRecords,m_cWv,PopupAtExit,ActivateCheckbox,ConfigScroll,GridMinHeight,ActivateCheckboxAll,ConfigNavbar,FrontendPort,LayerInterface,ViewMode,PrintTitle,AdvancedSuggester,pParent*/%>
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
.SPPortalZoomBase_container .SPPortalZoom .SPPortalZoomtTabs, .SPPortalZoomtTabs{  display: none;
}
.SPPortalZoomBase_container {
}
.SPPortalZoomBase_portlet{
  position:relative;
  min-width:150px;
  height:50px;
}
.SPPortalZoomBase_portlet[Data-page="1"]{
  height:50px;
  width:100%;
}
.SPPortalZoomBase_portlet[Data-page="2"]{
  height:50px;
  width:100%;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .label_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:10px;
  right:50px;
  right:33.333332%;
  width:auto;
  height:auto;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .label_ctrl {
  height:auto;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .label_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .toolbar_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:0px;
  left:100px;
  left:66.666664%;
  right:0px;
  width:auto;
  height:10px;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .box_tiles_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:10px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:10px;
  display:none;
  display:flex;
  flex-direction:column;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .box_tiles_ctrl {
  height:10px;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .box_tiles_ctrl > .box_content {
  height:100%;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .box_tiles_ctrl {
  min-height:10px;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .Grid_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:30px;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .Chart_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:1px;
  width:40px;
  height:15px;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:50px;
  width:auto;
  height:auto;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .label2_ctrl {
  height:auto;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .label2_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .GridChart_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .refresh_menu_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:400px;
  width:40px;
  height:40px;
  display:none;
}
.SPPortalZoomBase_portlet .refresh_menu_ctrl.global_handler{
}
.SPPortalZoomBase_portlet .refresh_menu_ctrl.global_handler:after{
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .menu_versioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:448px;
  width:40px;
  height:40px;
  display:none;
}
.SPPortalZoomBase_portlet .menu_versioni_ctrl.global_handler{
  visibility:hidden;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .toolbar2_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:0px;
  left:100px;
  left:66.666664%;
  right:0px;
  width:auto;
  height:10px;
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
 String def="[{\"h\":\"50,50\",\"layout_steps_values\":{},\"pages_names\":\"Grid,Grid\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"150\",\"w\":\"100%,100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"448\",\"y\":\"-38\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"623\",\"y\":\"16\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"153\",\"y\":\"-37\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"160\",\"y\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"262\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"233\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"310\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"340\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"694\",\"y\":\"20\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"726\",\"y\":\"20\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"758\",\"y\":\"20\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"188\",\"y\":\"-37\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"233\",\"y\":\"-10\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"262\",\"y\":\"-10\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"10\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"90\",\"x\":\"10\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"SPToolbar\",\"w\":\"50\",\"x\":\"100\",\"y\":\"0\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"310\",\"y\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"340\",\"y\":\"0\"},{\"anchor\":\"top-left-right\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"150\",\"x\":\"0\",\"y\":\"10\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"150\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"194\",\"y\":\"3\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"54\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"54\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"76\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"76\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"98\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"120\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"120\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"120\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"120\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"142\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"142\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"142\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"142\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"164\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"164\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"164\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"164\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"186\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"186\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"208\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"208\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"208\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"230\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"230\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"230\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"252\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"252\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"252\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"253\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"274\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"274\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"274\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"296\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"296\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"296\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"296\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"318\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"318\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"318\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"340\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"340\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"340\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"362\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"362\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"362\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"384\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"448\",\"y\":\"384\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"406\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"427\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"449\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLTotalizer\",\"w\":\"30\",\"x\":\"656\",\"y\":\"16\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"596\",\"y\":\"143\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"595\",\"y\":\"165\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"93\",\"x\":\"595\",\"y\":\"188\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"102\",\"x\":\"596\",\"y\":\"212\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"595\",\"y\":\"236\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"147\",\"x\":\"595\",\"y\":\"118\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"141\",\"x\":\"301\",\"y\":\"54\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"521\",\"y\":\"11\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"470\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"301\",\"y\":\"491\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"384\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"page\":\"2\",\"title\":\"\",\"type\":\"Chart\",\"w\":\"40\",\"x\":\"1\",\"y\":\"20\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"10\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"1\",\"type\":\"Grid\",\"w\":\"150\",\"x\":\"0\",\"y\":\"10\",\"zindex\":\"\"},{\"h\":\"30\",\"page\":\"2\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"-17\",\"y\":\"76\"},{\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"HamburgerMenu\",\"w\":\"40\",\"x\":\"400\",\"y\":\"0\",\"zindex\":\"\"},{\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"HamburgerMenu\",\"w\":\"40\",\"x\":\"448\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"575\",\"y\":\"-38\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"624\",\"y\":\"-37\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"598\",\"y\":\"295\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"SPToolbar\",\"w\":\"50\",\"x\":\"100\",\"y\":\"0\",\"zindex\":\"4\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"122\",\"x\":\"624\",\"y\":\"-12\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"152\",\"y\":\"406\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"456\",\"y\":\"436\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomBase","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPPortalZoomBase_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .box_tiles_ctrl {
  display:none;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .refresh_menu_ctrl {
  display:none;
}
.SPPortalZoomBase_portlet > .SPPortalZoomBase_page > .menu_versioni_ctrl {
  display:none;
}

</style>
<%if (!Library.Empty(SPPrxycizer.proxycizedPath("SPPortalZoom.js"))){%>
<script src="../<%=SPPrxycizer.proxycizedPath("SPPortalZoom.js")%>"></script>
<%}%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomBase','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label= "";
if(request.getAttribute("SPPortalZoomBase_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String Table=JSPLib.translateXSS(sp.getParameter("Table",""));
String EventName=JSPLib.translateXSS(sp.getParameter("EventName",""));
String Autozoom=JSPLib.translateXSS(sp.getParameter("Autozoom",""));
String EmitterName=JSPLib.translateXSS(sp.getParameter("EmitterName",""));
String PKFields=JSPLib.translateXSS(sp.getParameter("PKFields",""));
String ReceiverName=JSPLib.translateXSS(sp.getParameter("ReceiverName",""));
String Extensible=JSPLib.translateXSS(sp.getParameter("Extensible",""));
String ToolsbarState=JSPLib.translateXSS(sp.getParameter("ToolsbarState",""));
double GridRows=sp.getParameter("GridRows",0);
String Caption=JSPLib.translateXSS(sp.getParameter("Caption",""));
String ConfigGridElements=JSPLib.translateXSS(sp.getParameter("ConfigGridElements",""));
double RowMinHeight=sp.getParameter("RowMinHeight",0);
String ConfigName=JSPLib.translateXSS(sp.getParameter("ConfigName",""));
String Popup=JSPLib.translateXSS(sp.getParameter("Popup",""));
double PopupH=sp.getParameter("PopupH",0);
double PopupW=sp.getParameter("PopupW",0);
String WaitForFilter=JSPLib.translateXSS(sp.getParameter("WaitForFilter",""));
String DetailBehavior=JSPLib.translateXSS(sp.getParameter("DetailBehavior",""));
String AllowOrderBy=JSPLib.translateXSS(sp.getParameter("AllowOrderBy",""));
String SPZTL=JSPLib.translateXSS(sp.getParameter("SPZTL",""));
String FilterOnFields=JSPLib.translateXSS(sp.getParameter("FilterOnFields",""));
String EntityType=JSPLib.translateXSS(sp.getParameter("EntityType",""));
String InheritedPKFields=JSPLib.translateXSS(sp.getParameter("InheritedPKFields",""));
String VQRName= "";
String Linkzoom=JSPLib.translateXSS(sp.getParameter("Linkzoom",""));
String SetDelMessage=JSPLib.translateXSS(sp.getParameter("SetDelMessage",""));
String SPVZM_action= "";
String Linkzoomprg=JSPLib.translateXSS(sp.getParameter("Linkzoomprg",""));
String Tools_Position=JSPLib.translateXSS(sp.getParameter("Tools_Position",""));
String SPVZM_vqr= "";
String UID=JSPLib.translateXSS(sp.getParameter("UID",""));
String OpenerFormId=JSPLib.translateXSS(sp.getParameter("OpenerFormId",""));
double GridRowsParam= 0;
String Tools_Titles=JSPLib.translateXSS(sp.getParameter("Tools_Titles",""));
boolean FillEmptyKey=sp.getParameter("FillEmptyKey",false);
String Tools_Urls=JSPLib.translateXSS(sp.getParameter("Tools_Urls",""));
boolean RowsParamValid= false;
String LinkedField=JSPLib.translateXSS(sp.getParameter("LinkedField",""));
String DefaultsRoutine=JSPLib.translateXSS(sp.getParameter("DefaultsRoutine",""));
String Tools_Targets=JSPLib.translateXSS(sp.getParameter("Tools_Targets",""));
String FieldFilter=JSPLib.translateXSS(sp.getParameter("FieldFilter",""));
String QueryCount=JSPLib.translateXSS(sp.getParameter("QueryCount",""));
String Tools_Imgs=JSPLib.translateXSS(sp.getParameter("Tools_Imgs",""));
String FixedFilter=JSPLib.translateXSS(sp.getParameter("FixedFilter",""));
String MemoChars=JSPLib.translateXSS(sp.getParameter("MemoChars",""));
String Tools_Tooltips=JSPLib.translateXSS(sp.getParameter("Tools_Tooltips",""));
String FixedFilterURL=JSPLib.translateXSS(sp.getParameter("FixedFilterURL",""));
java.sql.Date m_dHistoricalLoadStart= JSPLib.NullDate();
String QueryParms=JSPLib.translateXSS(sp.getParameter("QueryParms",""));
String InitEntityFields=JSPLib.translateXSS(sp.getParameter("InitEntityFields",""));
java.sql.Date HistoryFilterDate=sp.getParameter("HistoryFilterDate",JSPLib.NullDate());
String LoadedRecords=JSPLib.translateXSS(sp.getParameter("LoadedRecords",""));
String m_cWv=JSPLib.translateXSS(sp.getParameter("m_cWv",""));
String PopupAtExit=JSPLib.translateXSS(sp.getParameter("PopupAtExit",""));
String ActivateCheckbox=JSPLib.translateXSS(sp.getParameter("ActivateCheckbox",""));
String ConfigScroll=JSPLib.translateXSS(sp.getParameter("ConfigScroll",""));
String GridMinHeight=JSPLib.translateXSS(sp.getParameter("GridMinHeight",""));
String ActivateCheckboxAll=JSPLib.translateXSS(sp.getParameter("ActivateCheckboxAll",""));
String ConfigNavbar=JSPLib.translateXSS(sp.getParameter("ConfigNavbar",""));
double FrontendPort=sp.getParameter("FrontendPort",0);
boolean PrintMode=false;
String LayerInterface=JSPLib.translateXSS(sp.getParameter("LayerInterface",""));
String ViewMode=JSPLib.translateXSS(sp.getParameter("ViewMode",""));
if(request.getAttribute("SPPortalZoomBase_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.ChartControl.ChartTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/ChartCtrl.js")%>'></script>
<jsp:include page="../chart/ZtChartLibs.jsp"/>
<script src='../<%=SPPrxycizer.proxycizedPath("ZtChart.js")%>'></script>
<%}
String label2= "";
if(request.getAttribute("SPPortalZoomBase_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("HamburgerMenuObj.js")%>'></script>
<%}
String ReportName= "";
java.sql.Date m_dNewHistoricalCPFromDate= JSPLib.NullDate();
String PrintTitle=JSPLib.translateXSS(sp.getParameter("PrintTitle",""));
String AdvancedSuggester=JSPLib.translateXSS(sp.getParameter("AdvancedSuggester",""));
String pParent=JSPLib.translateXSS(sp.getParameter("pParent",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}
response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires",System.currentTimeMillis() + 0*1000);%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;display:none;'></div>
<div id='<%=idPortlet%>_container' class='SPPortalZoomBase_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomBase_portlet SPPortalZoom'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomBase','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPPortalZoomBase_page' style='display:block'>
<span id='<%=idPortlet%>_label'  formid='<%=idPortlet%>' ps-name='label'    class='TitleLabel label_ctrl'><div id='<%=idPortlet%>_labeltbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_toolbar' class='disable-selection ctrl_spportalzoombase_toolbar_container spportalzoombase_toolbar' >
<div id='<%=idPortlet%>_toolbar_openMenuHandlerDiv' class='spportalzoombase_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbar_openMenuHandlerImg' class='spportalzoombase_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbar_listButtons' class='spportalzoombase_toolbar_listButtons'></div>
</div>
<div id='<%=idPortlet%>_box_tiles' class='box_tiles_ctrl SPSection_expanded PortalZoomBase_container_tiles' data-original-display='flex'><div id='<%=idPortlet%>_box_tiles_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_Grid' formid='<%=idPortlet%>' ps-name='Grid'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_refresh_menu' class='refresh_menu_ctrl SPPortalZoomBaseMenu global_handler closed'></div><div id='<%=idPortlet%>_menu_versioni' class='menu_versioni_ctrl SPPortalZoomBaseMenuVersion global_handler closed'></div></div>
<div id='<%=idPortlet%>_page_2' class='SPPortalZoomBase_page' style='display:none'>
<div id='<%=idPortlet%>_Chart'></div>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='TITLE label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_GridChart' formid='<%=idPortlet%>' ps-name='GridChart'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_toolbar2' class='disable-selection ctrl_spportalzoombase_toolbar_container spportalzoombase_toolbar' >
<div id='<%=idPortlet%>_toolbar2_openMenuHandlerDiv' class='spportalzoombase_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbar2_openMenuHandlerImg' class='spportalzoombase_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbar2_listButtons' class='spportalzoombase_toolbar_listButtons'></div>
</div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomBase');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPPortalZoomBase_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: 'SPPortalZoomtTabs'});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Grid"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Grid"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomBase',["150","150"],["50","50"],'SPPortalZoom',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"150","h":"50","title":"Grid","layer":""},{"layout_steps_values":{},"w":"150","h":"50","title":"Grid","layer":""}]);
this.$entity$_NumberOfLoadedRecords=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_NumberOfLoadedRecords","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_NumberOfLoadedRecords","page":1,"parmsNames":"numRecords","parmsTypes":"func","parmsValues":"this.getNumRecords()","persistent":"true","type":"EventEmitter","w":22,"x":448,"y":-38});
this.dataobj=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj","nrows":"15","page":1,"parms":"Autozoom,Linkzoom,Linkzoomprg,DefaultsRoutine,FieldFilter,FixedFilter,SPVZM_action,SPVZM_vqr,SPZTL,HistoryFilterDate,UID","parms_source":"","type":"SQLDataobj","w":30,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":623,"y":16});
this.splinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"","target":"","type":"SPLinker","w":30,"x":153,"y":-37});
this.splinker.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.action_splinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_action_splinker","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"action_splinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"false","servlet":"","target":"","type":"SPLinker","w":30,"x":160,"y":3});
this.action_splinker.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.$entity$_zoomSetFilter=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_zoomSetFilter","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_zoomSetFilter","objsValues":"this.SetFilter(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":262,"y":-38});
this.$entity$_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_savedEntity","objsValues":"this.refreshQuery(true)","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":233,"y":-38});
this.CfgColumnRead=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_CfgColumnRead","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"CfgColumnRead","page":1,"parmsNames":"cfgData","parmsTypes":"func","parmsValues":"this.CfgColumnSend()","persistent":"true","type":"EventEmitter","w":22,"x":310,"y":-38});
this.CfgColumnSet=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_CfgColumnSet","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"CfgColumnSet","objsValues":"this.CfgColumnReceive(evt.cfgData)","page":1,"parmsNames":"cfgData","type":"EventReceiver","w":22,"x":340,"y":-38});
this.$entity$_zoomSelectedRow=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"internal","ctrlid":"<%=idPortlet%>_$entity$_zoomSelectedRow","eventsNames":"RecordChanged,RecordChanged","eventsObjs":"dataobj,dataobj2","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_zoomSelectedRow","page":1,"parmsNames":"row,RS_EOF,forceRC","parmsTypes":"func,func,func","parmsValues":"this.GetRS(),this.GetRS_EOF(),this.dataobj.GetForceRecordChanged()","persistent":"true","type":"EventEmitter","w":22,"x":694,"y":20});
this.$entity$_callChildren=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"internal","ctrlid":"<%=idPortlet%>_$entity$_callChildren","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_callChildren","page":1,"parmsNames":"configuration","parmsTypes":"func","parmsValues":"this.GetConfiguration()","persistent":"true","type":"EventEmitter","w":22,"x":726,"y":20});
this.$entity$_updateFilters=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"pagelet","ctrlid":"<%=idPortlet%>_$entity$_updateFilters","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateFilters","page":1,"parmsNames":"Filters","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","type":"EventEmitter","w":22,"x":758,"y":20});
this.parent_splinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"editload","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_parent_splinker","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"parent_splinker","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":188,"y":-37});
this.parent_splinker.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.$entity$_updateConfiguration=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_updateConfiguration","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateConfiguration","page":1,"parmsNames":"Config,reload","parmsTypes":"func,func","parmsValues":"this.Config(),this.GetReload()","persistent":"true","type":"EventEmitter","w":22,"x":233,"y":-10});
this.$entity$_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_deletedEntity","objsValues":"this.refreshQuery(true)","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":262,"y":-10});
this.label=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_label","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":10,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label,false,true)%>","type":"Label","w":90,"x":10,"y":0,"zindex":"1"});
this.toolbar=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-left(%)-right","bg_color":"","cssClass":"spportalzoombase_toolbar","ctrlid":"<%=idPortlet%>_toolbar","h":10,"hide":"false","iconWidth":25,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbar","page":1,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":50,"x":100,"y":0,"zindex":"3"});
this.OptionsRead=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_OptionsRead","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"OptionsRead","page":1,"parmsNames":"optionsData","parmsTypes":"func","parmsValues":"this.Options()","persistent":"true","type":"EventEmitter","w":22,"x":310,"y":0});
this.OptionsSet=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_OptionsSet","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"OptionsSet","objsValues":"this.Options(evt.optionsData)","page":1,"parmsNames":"optionsData","type":"EventReceiver","w":22,"x":340,"y":0});
this.box_tiles=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"PortalZoomBase_container_tiles","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_box_tiles","groupName":"","h":10,"hide":"true","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"box_tiles","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":150,"x":0,"y":10,"zindex":"2"});
this.Grid=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":0,"cellspacing":0,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid","dataobj":"dataobj","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":30,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"Grid","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":true,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"true","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"splinker","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"center","w":150,"x":0,"y":20,"zindex":""});
this.Grid.setRowsCols({"draggablecolumns":true,"resizablecolumns":true,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[]});
this.splinker_hist=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_hist","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_hist","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":194,"y":3});
this.splinker_hist.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Table=new ZtVWeb._VC(this,'Table',null,'character','<%=JSPLib.ToJSValue(Table,false,true)%>',false,false);
this.EventName=new ZtVWeb._VC(this,'EventName',null,'character','<%=JSPLib.ToJSValue(EventName,false,true)%>',false,false);
this.Autozoom=new ZtVWeb._VC(this,'Autozoom',null,'character','<%=JSPLib.ToJSValue(Autozoom,false,true)%>',false,false);
this.EmitterName=new ZtVWeb._VC(this,'EmitterName',null,'character','<%=JSPLib.ToJSValue(EmitterName,false,true)%>',false,false);
this.PKFields=new ZtVWeb._VC(this,'PKFields',null,'character','<%=JSPLib.ToJSValue(PKFields,false,true)%>',false,false);
this.ReceiverName=new ZtVWeb._VC(this,'ReceiverName',null,'character','<%=JSPLib.ToJSValue(ReceiverName,false,true)%>',false,false);
this.Extensible=new ZtVWeb._VC(this,'Extensible',null,'character','<%=JSPLib.ToJSValue(Extensible,false,true)%>',false,false);
this.ToolsbarState=new ZtVWeb._VC(this,'ToolsbarState',null,'character','<%=JSPLib.ToJSValue(ToolsbarState,false,true)%>',false,false);
this.GridRows=new ZtVWeb._VC(this,'GridRows',null,'numeric',<%=GridRows%>,false,false);
this.Caption=new ZtVWeb._VC(this,'Caption',null,'character','<%=JSPLib.ToJSValue(Caption,false,true)%>',false,false);
this.ConfigGridElements=new ZtVWeb._VC(this,'ConfigGridElements',null,'character','<%=JSPLib.ToJSValue(ConfigGridElements,false,true)%>',false,false);
this.RowMinHeight=new ZtVWeb._VC(this,'RowMinHeight',null,'numeric',<%=RowMinHeight%>,false,false);
this.ConfigName=new ZtVWeb._VC(this,'ConfigName',null,'character','<%=JSPLib.ToJSValue(ConfigName,false,true)%>',false,false);
this.Popup=new ZtVWeb._VC(this,'Popup',null,'character','<%=JSPLib.ToJSValue(Popup,false,true)%>',false,false);
this.PopupH=new ZtVWeb._VC(this,'PopupH',null,'numeric',<%=PopupH%>,false,false);
this.PopupW=new ZtVWeb._VC(this,'PopupW',null,'numeric',<%=PopupW%>,false,false);
this.WaitForFilter=new ZtVWeb._VC(this,'WaitForFilter',null,'character','<%=JSPLib.ToJSValue(WaitForFilter,false,true)%>',false,false);
this.DetailBehavior=new ZtVWeb._VC(this,'DetailBehavior',null,'character','<%=JSPLib.ToJSValue(DetailBehavior,false,true)%>',false,false);
this.AllowOrderBy=new ZtVWeb._VC(this,'AllowOrderBy',null,'character','<%=JSPLib.ToJSValue(AllowOrderBy,false,true)%>',false,false);
this.SPZTL=new ZtVWeb._VC(this,'SPZTL',null,'character','<%=JSPLib.ToJSValue(SPZTL,false,true)%>',false,false);
this.FilterOnFields=new ZtVWeb._VC(this,'FilterOnFields',null,'character','<%=JSPLib.ToJSValue(FilterOnFields,false,true)%>',false,false);
this.EntityType=new ZtVWeb._VC(this,'EntityType',null,'character','<%=JSPLib.ToJSValue(EntityType,false,true)%>',false,false);
this.InheritedPKFields=new ZtVWeb._VC(this,'InheritedPKFields',null,'character','<%=JSPLib.ToJSValue(InheritedPKFields,false,true)%>',false,false);
this.VQRName=new ZtVWeb._VC(this,'VQRName',null,'character','<%=JSPLib.ToJSValue(VQRName,false,true)%>',false,false);
this.Linkzoom=new ZtVWeb._VC(this,'Linkzoom',null,'character','<%=JSPLib.ToJSValue(Linkzoom,false,true)%>',false,false);
this.SetDelMessage=new ZtVWeb._VC(this,'SetDelMessage',null,'character','<%=JSPLib.ToJSValue(SetDelMessage,false,true)%>',false,false);
this.SPVZM_action=new ZtVWeb._VC(this,'SPVZM_action',null,'character','<%=JSPLib.ToJSValue(SPVZM_action,false,true)%>',false,false);
this.Linkzoomprg=new ZtVWeb._VC(this,'Linkzoomprg',null,'character','<%=JSPLib.ToJSValue(Linkzoomprg,false,true)%>',false,false);
this.Tools_Position=new ZtVWeb._VC(this,'Tools_Position',null,'character','<%=JSPLib.ToJSValue(Tools_Position,false,true)%>',false,false);
this.SPVZM_vqr=new ZtVWeb._VC(this,'SPVZM_vqr',null,'character','<%=JSPLib.ToJSValue(SPVZM_vqr,false,true)%>',false,false);
this.UID=new ZtVWeb._VC(this,'UID',null,'character','<%=JSPLib.ToJSValue(UID,false,true)%>',false,false);
this.OpenerFormId=new ZtVWeb._VC(this,'OpenerFormId',null,'character','<%=JSPLib.ToJSValue(OpenerFormId,false,true)%>',false,false);
this.GridRowsParam=new ZtVWeb._VC(this,'GridRowsParam',null,'numeric',<%=GridRowsParam%>,false,false);
this.Tools_Titles=new ZtVWeb._VC(this,'Tools_Titles',null,'character','<%=JSPLib.ToJSValue(Tools_Titles,false,true)%>',false,false);
this.FillEmptyKey=new ZtVWeb._VC(this,'FillEmptyKey',null,'logic',<%=FillEmptyKey%>,false,false);
this.Tools_Urls=new ZtVWeb._VC(this,'Tools_Urls',null,'character','<%=JSPLib.ToJSValue(Tools_Urls,false,true)%>',false,false);
this.RowsParamValid=new ZtVWeb._VC(this,'RowsParamValid',null,'logic',<%=RowsParamValid%>,false,false);
this.LinkedField=new ZtVWeb._VC(this,'LinkedField',null,'character','<%=JSPLib.ToJSValue(LinkedField,false,true)%>',false,false);
this.DefaultsRoutine=new ZtVWeb._VC(this,'DefaultsRoutine',null,'character','<%=JSPLib.ToJSValue(DefaultsRoutine,false,true)%>',false,false);
this.Tools_Targets=new ZtVWeb._VC(this,'Tools_Targets',null,'character','<%=JSPLib.ToJSValue(Tools_Targets,false,true)%>',false,false);
this.FieldFilter=new ZtVWeb._VC(this,'FieldFilter',null,'character','<%=JSPLib.ToJSValue(FieldFilter,false,true)%>',false,false);
this.QueryCount=new ZtVWeb._VC(this,'QueryCount',null,'character','<%=JSPLib.ToJSValue(QueryCount,false,true)%>',false,false);
this.Tools_Imgs=new ZtVWeb._VC(this,'Tools_Imgs',null,'character','<%=JSPLib.ToJSValue(Tools_Imgs,false,true)%>',false,false);
this.FixedFilter=new ZtVWeb._VC(this,'FixedFilter',null,'character','<%=JSPLib.ToJSValue(FixedFilter,false,true)%>',false,false);
this.MemoChars=new ZtVWeb._VC(this,'MemoChars',null,'character','<%=JSPLib.ToJSValue(MemoChars,false,true)%>',false,false);
this.Tools_Tooltips=new ZtVWeb._VC(this,'Tools_Tooltips',null,'character','<%=JSPLib.ToJSValue(Tools_Tooltips,false,true)%>',false,false);
this.FixedFilterURL=new ZtVWeb._VC(this,'FixedFilterURL',null,'character','<%=JSPLib.ToJSValue(FixedFilterURL,false,true)%>',false,false);
this.m_dHistoricalLoadStart=new ZtVWeb._VC(this,'m_dHistoricalLoadStart',null,'date','<%=m_dHistoricalLoadStart%>',false,false);
this.QueryParms=new ZtVWeb._VC(this,'QueryParms',null,'character','<%=JSPLib.ToJSValue(QueryParms,false,true)%>',false,false);
this.InitEntityFields=new ZtVWeb._VC(this,'InitEntityFields',null,'character','<%=JSPLib.ToJSValue(InitEntityFields,false,true)%>',false,false);
this.HistoryFilterDate=new ZtVWeb._VC(this,'HistoryFilterDate',null,'date','<%=HistoryFilterDate%>',false,false);
this.LoadedRecords=new ZtVWeb._VC(this,'LoadedRecords',null,'character','<%=JSPLib.ToJSValue(LoadedRecords,false,true)%>',false,false);
this.m_cWv=new ZtVWeb._VC(this,'m_cWv',null,'character','<%=JSPLib.ToJSValue(m_cWv,false,true)%>',false,false);
this.totalizer=new ZtVWeb.SQLDataProvider(this, { name: 'totalizer', nrows: 1000, fieldstype: 'true', count: 'false', async: false });
this.PopupAtExit=new ZtVWeb._VC(this,'PopupAtExit',null,'character','<%=JSPLib.ToJSValue(PopupAtExit,false,true)%>',false,false);
this.ActivateCheckbox=new ZtVWeb._VC(this,'ActivateCheckbox',null,'character','<%=JSPLib.ToJSValue(ActivateCheckbox,false,true)%>',false,false);
this.ConfigScroll=new ZtVWeb._VC(this,'ConfigScroll',null,'character','<%=JSPLib.ToJSValue(ConfigScroll,false,true)%>',false,false);
this.GridMinHeight=new ZtVWeb._VC(this,'GridMinHeight',null,'character','<%=JSPLib.ToJSValue(GridMinHeight,false,true)%>',false,false);
this.ActivateCheckboxAll=new ZtVWeb._VC(this,'ActivateCheckboxAll',null,'character','<%=JSPLib.ToJSValue(ActivateCheckboxAll,false,true)%>',false,false);
this.ConfigNavbar=new ZtVWeb._VC(this,'ConfigNavbar',null,'character','<%=JSPLib.ToJSValue(ConfigNavbar,false,true)%>',false,false);
this.FrontendPort=new ZtVWeb._VC(this,'FrontendPort',null,'numeric',<%=FrontendPort%>,false,false);
this.$entity$_GetConfigurationField=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_GetConfigurationField","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_GetConfigurationField","page":1,"parmsNames":"Fields","parmsTypes":"func","parmsValues":"this.GetConfigurationField()","persistent":"true","type":"EventEmitter","w":22,"x":521,"y":11});
this.PrintMode=new ZtVWeb._VC(this,'PrintMode',null,'logic',<%=PrintMode%>,false,false);
this.LayerInterface=new ZtVWeb._VC(this,'LayerInterface',null,'character','<%=JSPLib.ToJSValue(LayerInterface,false,true)%>',false,false);
this.ViewMode=new ZtVWeb._VC(this,'ViewMode',null,'character','<%=JSPLib.ToJSValue(ViewMode,false,true)%>',false,false);
this.Chart=new ZtVWeb.ChartCtrl(this,{"add_dataobj":"","anchor":"top-left","auto_exec":true,"categoryKeyName":"","categoryname":"","ccolor":"","chartH":"","chartNavbar":true,"chartNavbarAddRemove":false,"chartNavbarChangepage":true,"chartNavbarFirstlast":true,"chartNavbarLastpage":true,"chartNavbarPagepanel":true,"chartW":"","chart_type":"category","class_cat":"","class_key":"","class_keycat":"","class_label":"","class_subaxis":"","class_xfrom":"","class_xto":"","class_xval":"","class_yfrom":"","class_yto":"","class_yval":"","compactChart":"","countryname":"","cstroke":"","csubname":"","ctooltip":"","ctrlid":"<%=idPortlet%>_Chart","ctype":"","cursorAlignment":"left","cursorPosition":"top","cursorType":"none","danimation":"","data_order":"default","dataload_datelimit":"","dataobj":"dataobj2","dateformat":"","def":"","depclass":"","depfield_1":"","depfield_1class":"","depfield_1label":"","depfield_2":"","depfield_2class":"","depfield_2label":"","depvalue":"","domain_type":"","downloadlist":"","dsetFunct":"","elanimate":"","enable_change_order":false,"enable_menu_sel":false,"exclSer":"","exclicks":false,"exportFileName":"","fieldpath":"","fieldvalue":"","focuskey":"","gendataset":false,"geo_0_field":"","geo_1_field":"","geo_dom_field":"","geo_level":"","geo_level_2":"","geo_level_3":"","geo_onlydata":"","geo_value_field":"","geo_view":"","geo_view_select":"","grch_domain":"","grch_fields":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":15,"hide":"false","ismulti":false,"key_start":"","keyfieldpath":"","labelKey_field":"","label_field":"","label_series":"","layer":false,"layout_steps_values":{},"legend":"","legendlimit":"","linkparms":"","manualScale":"","mapSeries":"","markers_dataobj":"","markers_desc":"","markers_key":"","markers_lat":"","markers_lng":"","markers_type":"","max_field":"","max_value":"","measureKey_series_field":"","measure_series_field":"","menuPosition":"","min_field":"","min_value":"","multi_autochange":false,"multi_key_field":"","multi_label_field":"","multi_scale":true,"multidimKeyName":"","multisubdivision":"default","multisubheight":"","name":"Chart","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"","othtype":"","page":2,"parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":true,"popup_height":"","popup_type":"","popup_width":"","portletsrc":"","ptl_translate":false,"query":"","rangebands":"","rangefunc":"","refline":"","reflinecol":"","selclicks":false,"seriesname":"","sfield":"","sfieldlabel":"","spuid":"","subtitle":"","target":"","tcustformat":"","tdomainunit":"","tdomainvalue":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","val_field":"","value_fields":"","value_labels":"","valuename":"","valuezname":"","vaxis_precision":"","vmode":"","voro_cat":"","voro_class":"","voro_coords":"","w":40,"x":1,"xKey_field":"","x_field":"","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","xyz_series_field":"","y":20,"y_field":"","y_label":"","z_field":"","zfseries":"","zfshow":"","zftype":"default","zindex":""});
this.label2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"TITLE","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":10,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":100,"x":0,"y":0,"zindex":"1"});
this.GridChart=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridChart","dataobj":"dataobj","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":10,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"GridChart","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"true","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":150,"x":0,"y":10,"zindex":""});
this.GridChart.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":1,"colProperties":[]});
this.dataobj2=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj2","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj2","nrows":"15","page":2,"parms":"Autozoom,Linkzoom,Linkzoomprg,DefaultsRoutine,FieldFilter,FixedFilter,SPVZM_action,SPVZM_vqr,SPZTL,HistoryFilterDate","parms_source":"","type":"SQLDataobj","w":30,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":-17,"y":76});
this.refresh_menu=new ZtVWeb.HamburgerMenuCtrl(this,{"anchor":"top-left","bg_color":"","color":"","css_class":"SPPortalZoomBaseMenu","ctrlid":"<%=idPortlet%>_refresh_menu","fontSize":0,"h":40,"hide":"true","layer":false,"layout_steps_values":{},"maxsubitemelements":5,"name":"refresh_menu","page":1,"spuid":"","type":"HamburgerMenu","visible_handler":true,"w":40,"x":400,"y":0,"zindex":""});
this.menu_versioni=new ZtVWeb.HamburgerMenuCtrl(this,{"anchor":"top-left","bg_color":"","color":"","css_class":"SPPortalZoomBaseMenuVersion","ctrlid":"<%=idPortlet%>_menu_versioni","fontSize":0,"h":40,"hide":"true","layer":false,"layout_steps_values":{},"maxsubitemelements":5,"name":"menu_versioni","page":1,"spuid":"","type":"HamburgerMenu","visible_handler":false,"w":40,"x":448,"y":0,"zindex":""});
this.spl_smartreport=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_spl_smartreport","decrypted_parms":"","entity_type":"smartreport","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"spl_smartreport","offline":false,"page":1,"parms":"ReportName","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":575,"y":-38});
this.spl_smartreport.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.ReportName=new ZtVWeb._VC(this,'ReportName',null,'character','<%=JSPLib.ToJSValue(ReportName,false,true)%>',false,false);
this.m_dNewHistoricalCPFromDate=new ZtVWeb._VC(this,'m_dNewHistoricalCPFromDate',null,'date','<%=m_dNewHistoricalCPFromDate%>',false,false);
this.toolbar2=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-left(%)-right","bg_color":"","cssClass":"spportalzoombase_toolbar","ctrlid":"<%=idPortlet%>_toolbar2","h":10,"hide":"false","iconWidth":25,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbar2","page":2,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":50,"x":100,"y":0,"zindex":"4"});
this.PrintTitle=new ZtVWeb._VC(this,'PrintTitle',null,'character','<%=JSPLib.ToJSValue(PrintTitle,false,true)%>',false,false);
this.AdvancedSuggester=new ZtVWeb._VC(this,'AdvancedSuggester',null,'character','<%=JSPLib.ToJSValue(AdvancedSuggester,false,true)%>',false,false);
this.pParent=new ZtVWeb._VC(this,'pParent',null,'character','<%=JSPLib.ToJSValue(pParent,false,true)%>',false,false);
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
<%request.setAttribute("SPPortalZoomBase_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomBase_Static=function(){
if(typeof dataobj_QueryExecuted !='undefined')this.dataobj_QueryExecuted=dataobj_QueryExecuted;
if(typeof Grid_Rendered !='undefined')this.Grid_Rendered=Grid_Rendered;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.dataobj.addRowConsumer(this.Grid);
this.dataobj.addDataConsumer(this.m_dHistoricalLoadStart,<%=JSPLib.ToJSValue("cpfromdate",true)%>);
this.dataobj.addTotalizer({"alias":"","descr":"","exp":"","grp":"","orderby":"","picture":"","provider":"totalizer"});
this.dataobj2.addRowConsumer(this.Chart);
this.dataobj.addRowConsumer(this.GridChart);

<%if("true".equals(sp.getParameter("SPFromFrontEnd","")) &&  !(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples","")))){%>
window.location='../jsp-system/SPLogin.jsp?m_cURL=<%=JSPLib.ToJSValue(request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request),false)%>'
<%}

java.util.regex.Pattern validVarName = java.util.regex.Pattern.compile("[a-zA-Z_$][a-zA-Z_$0-9]*");
int configMode=sp.ZoomConfigMode();
boolean canPrint = sp.CanPrintZoom();
// Necessario il nome della tabella
if ( Library.Lib.IsValidTableName(Table) ) {
String sqpkey=JSPLib.cmdHash(Table,request.getSession());
if (configMode>0 && sp.IsPortalZoomHelpInstalled()){
%>ZtVWeb.RequireLibrary("../spportalzoom_help.js");<%
}
%>
document.getElementById(this.formid+"_tabcontainer").style.display='none';
this.refresh_menu.Hide();
this.configModeSecurity=<%=configMode%>;
this.printModeSecurity = <%=canPrint%>;
this.Var=function(val){
  this.val=val;
  this.Value=function(val){
    if(arguments.length) this.val=val;
    return this.val;
  }
}
<%
  if (!Library.Empty(Tools_Imgs)) {
    String[] toolsImgsArray = Tools_Imgs.split(",");
    for (int idx = 0; idx < toolsImgsArray.length; idx++) {
      String currToolImg = sp.getThemedImage(toolsImgsArray[idx]);
      if (!"../".equals(currToolImg) && !("../"+sp.getSkin()+"/").equals(currToolImg) )
        toolsImgsArray[idx] = currToolImg;
    }
    String newToolsImgs="", sep = "";
    for (int idx = 0; idx < toolsImgsArray.length; idx++) {
      newToolsImgs+= sep + toolsImgsArray[idx];
      sep = ",";
    }
%>
this.Tools_Imgs.Value(<%=JSPLib.ToJSValue(newToolsImgs,true)%>);
<%  
  }
  String queryParms="",parmsToSend="";
  Enumeration e=sp.getParameters();
  String p,v,o="",parms="";
  while(e.hasMoreElements()){
    p=(String)e.nextElement();
    if(p.equals("QueryParms")){
      String s = sp.getParameter(p,"");
      String namevalue,name,value;
      int numParams = JSPLib.countChar('=',s);
      int pStart, pStop=0, pEqual;
      for(int i=0; i<numParams; i++) {
        pEqual = JSPLib.At("=",s,i+2);
        pStart = pStop+1;
        if (pEqual==0)
          pStop += JSPLib.RAt(",",JSPLib.Substr(s,pStart));
        else
          pStop += JSPLib.RAt(",",JSPLib.Substr(s,pStart,pEqual-pStart+1));
        namevalue=JSPLib.Substr(s, pStart, pStop-pStart);
        name=JSPLib.Left(namevalue,JSPLib.At("=",namevalue)-1);
        value=java.net.URLDecoder.decode(JSPLib.Right(namevalue,JSPLib.Len(namevalue)-JSPLib.At("=",namevalue)),Library.m_cResponseEncoding);
        if(name.length()>0 && validVarName.matcher(name).matches()){
          queryParms+=name+",";
          o+="this."+name+"=new this.Var('"+JSPLib.ToJSValue(value)+"');";
          parmsToSend+=name+"="+java.net.URLEncoder.encode(value,Library.m_cResponseEncoding)+"&";
        }
      }
    }
    else if(p.startsWith("w_")){
      if (validVarName.matcher(p).matches()) {
        queryParms += p+",";
        o+="this."+p+"=new this.Var('"+JSPLib.ToJSValue(sp.getParameter(p,""))+"');";
      }
    }
    else if(p.startsWith("m_") && !"m_cWv".equals(p) && !"m_cRegionalSettings".equals(p)){
      if (validVarName.matcher(p).matches()) {
      	o+="this."+p+"=new this.Var('"+JSPLib.ToJSValue(sp.getParameter(p,""))+"');";
      }
    }
    parms+=p+" ";
  }
  if(!"".equals(queryParms)){
    queryParms.substring(0, queryParms.length()-1);
  }
%>
<%=o%>
var queryParms=<%=Library.ToJSValue(queryParms,"C",0,0)%>;
this.presetParams=queryParms;
//parms=<%=Library.toHTMLValue(parms,"C",0,0)%>;
this.dataobj.parms+=','+queryParms;
this.dataobj2.parms+=','+queryParms;
this.vzmstructure=<%
if(!"".equals(Table)){
  String sqlcmd="vzm:"+Table;
  if(!"".equals(ConfigName)){
    sqlcmd+="."+ConfigName;
  }else{
    sqlcmd+=".default";
  }
  pageContext.include("../servlet/SQLDataProviderServer?sqlcmd="+sqlcmd+"&SPVZMStructureOnly=true&cmdhash="+sqpkey+"&queryParms="+queryParms+"&"+parmsToSend);
  out.print(";//"+Library.toHTMLValue(sqlcmd,"C",0,0));
}else{
  out.print("null;");
  out.print("//no Table specified");
}
%>;
this.dataobj.cmdHash='<%=sqpkey%>'
this.dataobj2.cmdHash='<%=sqpkey%>'
this.Caption.Value(<%
if(!"".equals(Caption)){
out.print("'"+JSPLib.ToJSValue(sp.translate(Caption))+"'");
}
%>);
this.PrintTitle.Value(<%
if(!"".equals(PrintTitle)){
out.print("'"+JSPLib.ToJSValue(sp.translate(PrintTitle))+"'");
}
%>);
<%
if (!"".equals(Tools_Tooltips)){
out.println("this.Tools_Tooltips.Value('"+JSPLib.ToJSValue(sp.translate(Tools_Tooltips))+"')");
}


if (!"".equals(Tools_Titles)){
out.println("this.Tools_Titles.Value('"+JSPLib.ToJSValue(sp.translate(Tools_Titles))+"')");
}
%>
if(typeof window.TransDict=='undefined') {
  window.TransDict = new Array();
}
window.TransDict['MSG_EDIT_AND_SPLIT']= <%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_EDIT_AND_SPLIT"),"C",0,0)%>
ZtVWeb.AddTranslation('MSG_ZOOM_ACTIONS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_ZOOM_ACTIONS"),"C",0,0)%>);
doZoom.call(this);
function dataobj_QueryExecuted(){
  this.dataobj_QueryExecuted_Impl();
}
function Grid_Rendered(){
  this.Grid_Rendered_Online();
}
    
this.startZoom();
<%}%>
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomBase_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.$entity$_NumberOfLoadedRecords.setParms();
window.<%=idPortlet%>.on_$entity$_zoomSetFilter=function(parmsObj){<%=idPortlet%>.$entity$_zoomSetFilter.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_$entity$_savedEntity=function(parmsObj){<%=idPortlet%>.$entity$_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.CfgColumnRead.setParms();
window.<%=idPortlet%>.on_CfgColumnSet=function(parmsObj){<%=idPortlet%>.CfgColumnSet.receiveFnc(parmsObj);}
window.<%=idPortlet%>.$entity$_zoomSelectedRow.addObservers();
window.<%=idPortlet%>.$entity$_callChildren.setParms();
window.<%=idPortlet%>.$entity$_updateFilters.setParms();
window.<%=idPortlet%>.$entity$_updateConfiguration.setParms();
window.<%=idPortlet%>.on_$entity$_deletedEntity=function(parmsObj){<%=idPortlet%>.$entity$_deletedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.OptionsRead.setParms();
window.<%=idPortlet%>.on_OptionsSet=function(parmsObj){<%=idPortlet%>.OptionsSet.receiveFnc(parmsObj);}
window.<%=idPortlet%>.$entity$_GetConfigurationField.setParms();
window.<%=idPortlet%>.Chart._ChartTranslations = {title:'<%=JSPLib.ToJSValue(sp.translate(""))%>',subtitle:'<%=JSPLib.ToJSValue(sp.translate(""))%>',x_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',y_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',percent_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',titleSeries:'<%=JSPLib.ToJSValue(sp.translate(""))%>',othlabel:'<%=JSPLib.ToJSValue(sp.translate(""))%>',label_series:''}
window.<%=idPortlet%>.Chart._createChart()
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomBase',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomBase');
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
sp.endPage("SPPortalZoomBase");
}%>
<%! public String getJSPUID() { return "902790425"; } %>