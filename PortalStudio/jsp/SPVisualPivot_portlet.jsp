<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u003c%if(\"true\".equals(sp.getParameter(\"SPFromFrontEnd\",\"\")) &&  !(sp.CanAccessEditor(\"PortalStudio\") || \"S\".equals(sp.getGlobal(\"g_PortalSamples\",\"\")))){%\u003e\nwindow.location='..\u002fjsp-system\u002fSPLogin.jsp?m_cURL=\u003c%=JSPLib.ToJSValue(request.getRequestURI()+(!\"\".equals(JSPLib.getParametersList(request))?\"&\":\"\")+JSPLib.getParametersList(request),false)%\u003e'\n\u003c%}%\u003e\n\u003c%\njava.util.regex.Pattern validVarName = java.util.regex.Pattern.compile(\"[a-zA-Z_$][a-zA-Z_$0-9]*\");\nint configMode = sp.VisualPivotConfigMode();\nboolean canPrint = sp.CanPrintVisualPivot();\nString sqpkey=\"\";\u002f*JSPLib.cmdHash(Table,request.getSession());*\u002f\n%\u003e\nthis.savinghashparameter = '\u003c%=JSPLib.cmdHash(\"VisualPivot\", request.getSession())%\u003e';\n\u002f\u002fdocument.getElementById(this.formid+\"_tabcontainer\").style.display='none';\nthis.configModeSecurity=\u003c%=configMode%\u003e;\nthis.printModeSecurity=\u003c%=canPrint%\u003e;\nthis.Var=function(val){\n  this.val=val;\n  this.Value=function(val){\n    if(arguments.length) this.val=val;\n    return this.val;\n  }\n}\n\n\u003c%  \n  String queryParms=\"\",parmsToSend=\"\";\n  Enumeration e=sp.getParameters();\n  String p,v,o=\"\",parms=\"\";\n  while(e.hasMoreElements()){\n    p=(String)e.nextElement();\n    if(p.equals(\"QueryParms\")){\n      String s = sp.getParameter(p,\"\");\n      String namevalue,name,value;\n      int numParams = JSPLib.countChar('=',s);\n      int pStart, pStop=0, pEqual;\n      for(int i=0; i\u003cnumParams; i++) {\n        pEqual = JSPLib.At(\"=\",s,i+2);\n        pStart = pStop+1;\n        if (pEqual==0)\n          pStop += JSPLib.RAt(\",\",JSPLib.Substr(s,pStart));\n        else\n          pStop += JSPLib.RAt(\",\",JSPLib.Substr(s,pStart,pEqual-pStart+1));\n        namevalue=JSPLib.Substr(s, pStart, pStop-pStart);\n        name=JSPLib.Left(namevalue,JSPLib.At(\"=\",namevalue)-1);\n        value=java.net.URLDecoder.decode(JSPLib.Right(namevalue,JSPLib.Len(namevalue)-JSPLib.At(\"=\",namevalue)),Library.m_cResponseEncoding);\n        if(name.length()\u003e0 && validVarName.matcher(name).matches()){\n          queryParms+=name+\",\";\n          o+=\"this.\"+name+\"=new this.Var('\"+JSPLib.ToJSValue(value)+\"');\";\n          parmsToSend+=name+\"=\"+java.net.URLEncoder.encode(value,Library.m_cResponseEncoding)+\"&\";\n        }\n      }\n    }\n    else if(p.startsWith(\"w_\")){\n      if (validVarName.matcher(p).matches()) {\n        queryParms += p+\",\";\n        o+=\"this.\"+p+\"=new this.Var('\"+JSPLib.ToJSValue(sp.getParameter(p,\"\"))+\"');\";\n      }\n    }\n    else if(p.startsWith(\"m_\") && !\"m_cWv\".equals(p) && !\"m_cRegionalSettings\".equals(p)){\n      if (validVarName.matcher(p).matches()) {\n      \to+=\"this.\"+p+\"=new this.Var('\"+JSPLib.ToJSValue(sp.getParameter(p,\"\"))+\"');\";\n      }\n    }\n    parms+=p+\" \";\n  }\n  if(!\"\".equals(queryParms)){\n    queryParms.substring(0, queryParms.length()-1);\n  }\n%\u003e\n\u003c%=o%\u003e\n this.theme = \u003c%=Library.ToJSValue(sp.getTheme(), \"C\", 0, 0)%\u003e;\nvar queryParms=\u003c%=Library.ToJSValue(queryParms,\"C\",0,0)%\u003e;\n\u002f\u002fthis.presetParams=queryParms;\nthis.dataobj.parms+=','+queryParms;\nthis.mDataobj.parms+=','+queryParms;\n\u002f\u002fthis.dataobj.cmdHash=' =sqpkey%\u003e'\nthis.Caption.Value(\u003c%\nif(!\"\".equals(Caption)){\nout.print(\"'\"+JSPLib.ToJSValue(sp.translate(Caption))+\"'\");\n}\n%\u003e);\nthis.PrintTitle.Value(\u003c%\nif(!\"\".equals(PrintTitle)){\nout.print(\"'\"+JSPLib.ToJSValue(sp.translate(PrintTitle))+\"'\");\n}\n%\u003e);\n\n\n\u002f\u002fper avere le stringhe fisse\nZtVWeb.AddTranslation('MSG_VIEWS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_VIEWS\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('PIVOT_SAVE_CONFIG',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"PIVOT_SAVE_CONFIG\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('PIVOT_HIDE_FIELDS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"PIVOT_HIDE_FIELDS\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('PIVOT_SHOW_FIELDS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"PIVOT_SHOW_FIELDS\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_VERSIONS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_VERSIONS\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_ZOOM_ACTIONS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_ZOOM_ACTIONS\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_FILTERS',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_FILTERS\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_VZM_PRINT',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_VZM_PRINT\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_FORM_FUNCTION_REFRESH',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_FORM_FUNCTION_REFRESH\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_XLSX_TABLE',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_XLSX_TABLE\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_XLSX_PIVOT',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_XLSX_PIVOT\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_FULL_EDITOR',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_FULL_EDITOR\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_DRILL_DOWN',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_DRILL_DOWN\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_DRILL_UP',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_DRILL_UP\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_VIEW',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_VIEW\"),\"C\",0,0)%\u003e);\nZtVWeb.AddTranslation('MSG_OPEN_LINK',\u003c%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate(\"MSG_OPEN_LINK\"),\"C\",0,0)%\u003e);\n                                                                                                                                                      \ndoVPV.call(this);\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"0","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"none\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"SPPortalZoomtTabs\",\"selector\":\".SPPortalZoom .SPPortalZoomtTabs, .SPPortalZoomtTabs\",\"id\":\"form\",\"code\":\".SPPortalZoom .SPPortalZoomtTabs, .SPPortalZoomtTabs {\\n  display: none;\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"button\",\"class_name\":\"buttonx\",\"selector\":\".buttonx\",\"value\":\"...\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @GridPivot }}{{ @Chart }}{{ @label }}{{ @ChartB }}{{ @GridPivotB }}{{ @GridPivot }}{{ @Chart }}{{ @label }}{{ @ChartB }}{{ @GridPivotB }}{{ @toolbar }}{{ @GridPivot }}{{ @Chart }}{{ @label }}{{ @ChartB }}{{ @GridPivotB }}{{ @toolbar }}{{ @label_Copy }}{{ @toolbar_Copy }}{{ @toolbar }}{{ @labelA }}{{ @toolbarA }}{{ @label_Copy }}{{ @toolbar_Copy }}{{ @toolbarB }}{{ @labelB }}{{ @toolbarA }}{{ @toolbarB }}{{ @labelB }}{{ @labelA }}{{ @Box44 }}\u003cdiv name=\"Portlet45\" index=\"38\" type=\"Portlet\"\u003ePortlet45\u003c\u002fdiv\u003e{{ @Button48 }}{{ @Button49 }}{{ @BoxCollpase }}{{ @PVersion }}{{ @BSave }}{{ @BConfig }}{{ @toolbarA }}{{ @toolbarB }}{{ @labelB }}{{ @labelA }}{{ @menu_versioni }}{{ @menu_versioni }}{{ @BoxCollapse }}{{ @BoxCollapse_Copy }}{{ @menu_versioni }}{{ @BoxCollapse }}{{ @BoxCollapseA }}{{ @BoxCollapse_Copy }}{{ @BoxCollapseB }}{{ @BoxCollapseA }}{{ @BoxCollapseB }}{{ @BoxCollapse }}{{ @BoxCollapseA }}{{ @BoxCollapseB }}{{ @menu_versioni_Copy }}{{ @refresh_menu }}\u003c\u002fbody\u003e","grapesCss":"","h":"50,50,50","hsl":"","htmlcode":"{{ @BoxCollapse }} \n \n \n \n \n \n{{ @BoxCollpase \n }} \n \n{{ @toolbarA }} \n{{ @Chart }} \n{{ @GridPivotB }} \n{{ @ChartB }} \n{{ @label }} \n \n \n{{ @ChartB }} \n \n{{ @GridPivot }} \n{{ @toolbar2 }}\n\n\n{{ @GridChart }}\n{{ @label2 }}\n{{ @ChartP \n }}\n\n\n\n\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deleted{{ AdvancedSuggester }}Entity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ $entity$_GetConfigurationField }}\n{{ $entity$_NumberOfLoadedRecords }}\n{{ dataobj }}\n{{ splinker }}\n{{ action_splinker }}\n{{ $entity$_zoomSetFilter }}\n{{ $entity$_savedEntity }}\n{{ CfgColumnRead }}\n{{ CfgColumnSet }}\n{{ $entity$_zoomSelectedRow }}\n{{ $entity$_callChildren }}\n{{ $entity$_updateFilters }}\n{{ parent_splinker }}\n{{ $entity$_updateConfiguration }}\n{{ $entity$_deletedEntity }}\n{{ label }}\n{{ toolbar }}\n{{ OptionsRead }}\n{{ OptionsSet }}\n{{ box_tiles }}\n{{ Grid }}\n{{ splinker_hist }}\n{{ Table }}\n{{ EventName }}\n{{ Autozoom }}\n{{ EmitterName }}\n{{ PKFields }}\n{{ ReceiverName }}\n{{ Extensible }}\n{{ ToolsbarState }}\n{{ GridRows }}\n{{ Caption }}\n{{ ConfigGridElements }}\n{{ RowMinHeight }}\n{{ ConfigName }}\n{{ Popup }}\n{{ PopupH }}\n{{ PopupW }}\n{{ WaitForFilter }}\n{{ DetailBehavior }}\n{{ AllowOrderBy }}\n{{ SPZTL }}\n{{ FilterOnFields }}\n{{ EntityType }}\n{{ InheritedPKFields }}\n{{ VQRName }}\n{{ Linkzoom }}\n{{ SetDelMessage }}\n{{ SPVZM_action }}\n{{ Linkzoomprg }}\n{{ Tools_Position }}\n{{ SPVZM_vqr }}\n{{ UID }}\n{{ OpenerFormId }}\n{{ GridRowsParam }}\n{{ Tools_Titles }}\n{{ FillEmptyKey }}\n{{ Tools_Urls }}\n{{ RowsParamValid }}\n{{ LinkedField }}\n{{ DefaultsRoutine }}\n{{ Tools_Targets }}\n{{ FieldFilter }}\n{{ QueryCount }}\n{{ Tools_Imgs }}\n{{ FixedFilter }}\n{{ MemoChars }}\n{{ Tools_Tooltips }}\n{{ FixedFilterURL }}\n{{ m_dHistoricalLoadStart }}\n{{ QueryParms }}\n{{ InitEntityFields }}\n{{ HistoryFilterDate }}\n{{ LoadedRecords }}\n{{ m_cWv }}\n{{ totalizer }}\n{{ PopupAtExit }}\n{{ ActivateCheckbox }}\n{{ ConfigScroll }}\n{{ GridMinHeight }}\n{{ ActivateCheckboxAll }}\n{{ ConfigNavbar }}\n{{ FrontendPort }}\n{{ $entity$_GetConfigurationField }}\n{{ PrintMode }}\n{{ LayerInterface }}\n{{ ViewMode }}\n{{ Chart }}\n{{ label2 }}\n{{ GridChart }}\n{{ dataobj2 }}\n{{ refresh_menu }}\n{{ menu_versioni }}\n{{ spl_smartreport }}\n{{ ReportName }}\n{{ m_dNewHistoricalCPFromDate }}\n{{ toolbar2 }}\n{{ @toolbar }} \n{{ @toolbarA{{ @toolbarB }} \n{{ @labelB }} \n }} \n{{ @labelA }} \n{{ @TVersion{{ @CCustom \n \n }} \n }} \n \n \n \n{{ @menu_versioni }} \n{{ @BoxCollapse{{ @BoxCollapseA{{ @BoxCollapseB }} \n }} \n }} \n{{ PrintTitle }}{{ @BoxCollapseA }} \n{{ @refresh_menu }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"\u003c%=SPPrxycizer.proxycizedPath(\"SPVisualPivot.js\")%\u003e","offline":"","on_security_failure":"login","page_layer":"","pages":"1,2,3","pagesProp":"[{\"title\":\"grid\",\"layer\":\"\",\"h\":\"50\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"chart\",\"layer\":\"\",\"h\":\"50\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"both\",\"layer\":\"\",\"h\":\"50\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"grid,chart,both","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"true","tag":"","title":"none","title_block":"","title_url":"","type":"Form","v_line":"150","version":"37","w":"100%,100%,100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"true","n_records":"999999","name":"dataobj","offline":"","page":"1","parms":"","parms_source":"","query":"","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"176","waiting_mgs":"","x":"399","y":"94"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"$entity$_zoomSetFilter","objsValues":"this.SetFilters(evt)","page":"1","parmsNames":"","sequence":"2","type":"EventReceiver","w":"176","x":"783","y":"118"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ReceiverName","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"199","y":"86"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"userCode","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"266"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"EventName","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"199","y":"108"},{"FAB":"","anchor":"top-left(%)-right","bg_color":"","css_class":"spportalzoombase_toolbar","ctrlOfVariant":"","fixed":"","h":"10","hide":"false","iconWidth":"25","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"toolbarA","page":"2","rapp":"","sequence":"6","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"50","wireframe_props":"","x":"100","y":"0","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"groupCode","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"288"},{"FAB":"","anchor":"top-left(%)-right","bg_color":"","css_class":"spportalzoombase_toolbar","ctrlOfVariant":"","fixed":"","h":"10","hide":"false","iconWidth":"25","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"toolbarB","page":"3","rapp":"","sequence":"8","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"50","wireframe_props":"","x":"100","y":"0","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"custom","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"logic","w":"176","x":"-4","y":"310"},{"broadcast":"pagelet","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_updateFilters","page":"1","parmsNames":"Filters","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","sequence":"10","type":"EventEmitter","w":"176","x":"783","y":"94"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_updateConfiguration","page":"1","parmsNames":"Config,reload","parmsTypes":"func,func","parmsValues":"this.Config(),this.GetReload()","persistent":"true","sequence":"11","type":"EventEmitter","w":"176","x":"783","y":"70"},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"10","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelB","nowrap":"false","page":"3","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"90","wireframe_props":"align,value,n_col","x":"10","y":"1","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"Caption","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"90"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ConfigName","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"112"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"VQRName","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"134"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"UID","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"198"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OpenerFormId","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"242"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"QueryParms","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"156"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"m_cWv","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"154"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ConfigNavbar","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"176"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"false","name":"PrintMode","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"logic","w":"176","x":"-4","y":"178"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"ReportName","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"200"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"PrintTitle","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"222"},{"anchor":"","bigtotaltext":"","canFilter":"","columnbigtotal":"","columndescrs":"","columnfields":"","columnkeys":"","columnlistvalues":"","columnpictures":"","columnsort":"","columnsorts":"","columnsortsfields":"","columnsubtotal":"","cssClass":"drilldown","cssFile":"styles\u002fGridPivotObj.css","ctrlOfVariant":"","dataobj":"","fixed":"","h":"30","hide":"","hidemeasures":"true","layer":"","layout_steps_values":"{}","measurecondformats":"","measuredescrs":"","measurefields":"","measurepictures":"","measuresoncolumn":"","measurestitle":"","name":"GridPivot","odimdescrs":"","odimfields":"","odimkeys":"","odimlistvalues":"","odimpictures":"","odimsorts":"","odimsortsfields":"","omeascondformats":"","omeasdescrs":"","omeasfields":"","omeaspictures":"","othDimMeas":"true","page":"1","print_grep":"true","print_hideexport":"","print_hidesettings":"","print_max":"","print_model":"default","print_option":"default","print_outputf":"default","print_result":"","print_title":"","rapp":"","rowbigtotal":"","rowdescrs":"","rowfields":"","rowkeys":"","rowpictures":"","rowsort":"","rowsorts":"","rowsortsfields":"","rowsubtotal":"","scroll_bars":"false","sequence":"24","spuid":"","subtotaltext":"","type":"GridPivot","uiDragDrop":"false","w":"150","wireframe_props":"","x":"0","y":"20","zindex":"4","zone":""},{"allowedentities":"SPVPVProxy","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"loadVPV","offline":"","page":"1","parms":"ConfigName,action=load","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"25","servlet":"SPVPVProxy","target":"","type":"SPLinker","w":"176","x":"591","y":"118"},{"anchor":"top-left(%)-right(%)-bottom","auto_exec":"true","categoryKeyName":"","categoryname":"","ccolor":"","chartH":"","chartNavbar":"","chartNavbarAddRemove":"","chartNavbarChangepage":"","chartNavbarFirstlast":"","chartNavbarLastpage":"","chartNavbarPagepanel":"","chartW":"","chart_type":"category","compactChart":"","cstroke":"","ctooltip":"","ctrlOfVariant":"","ctype":"VBAR","cursorAlignment":"left","cursorPosition":"top","cursorType":"none","danimation":"","data_order":"","dataobj":"","def":"","downloadlist":"","elanimate":"","enable_change_order":"","enable_menu_sel":"","exclSer":"","exclicks":"","exportFileName":"","fixed":"","focuskey":"","gendataset":"","grch_domain":"","grch_fields":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":"30","hide":"false","key_start":"","labelKey_field":"","label_field":"","label_series":"","layer":"false","layout_steps_values":"{}","legend":"","legendlimit":"","linkparms":"","manualScale":"","mapSeries":"","max_value":"","menuPosition":"","min_value":"","multi_key_field":"","multi_label_field":"","multi_scale":"true","multidimKeyName":"","multisubdivision":"default","multisubheight":"","name":"Chart","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"","othtype":"","page":"2","parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":"true","popup_height":"","popup_type":"","popup_width":"","portletsrc":"","query":"","rangebands":"","rangefunc":"","rapp":"","refline":"","reflinecol":"","selclicks":"","sequence":"26","seriesname":"","sfield":"","sfieldlabel":"","spuid":"","subtitle":"","target":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","value_fields":"","value_labels":"","valuename":"","vaxis_precision":"","vmode":"","w":"150","wireframe_props":"","x":"0","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","y":"20","y_label":"","zfseries":"","zfshow":"","zftype":"default","zindex":"5","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ViewMode","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"286"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"SPLinker","offline":"","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"28","servlet":"","target":"","type":"SPLinker","w":"176","x":"591","y":"94"},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"10","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"90","wireframe_props":"align,value,n_col","x":"6","y":"1","zindex":"1","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"$entity$_GetConfigurationField","page":"1","parmsNames":"Fields","parmsTypes":"func","parmsValues":"this.GetConfigurationField()","persistent":"true","sequence":"30","type":"EventEmitter","w":"176","x":"783","y":"142"},{"anchor":"top-left(%)-right(%)-bottom","auto_exec":"true","ccolor":"","chartH":"","chartNavbar":"false","chartNavbarAddRemove":"","chartNavbarChangepage":"","chartNavbarFirstlast":"","chartNavbarLastpage":"","chartNavbarPagepanel":"","chartW":"","chart_type":"","compactChart":"","cstroke":"","ctooltip":"","ctrlOfVariant":"","ctype":"","cursorAlignment":"left","cursorPosition":"top","cursorType":"none","danimation":"","data_order":"","dataobj":"StaticDataProviderB","def":"","downloadlist":"","elanimate":"","enable_change_order":"","enable_menu_sel":"","exclSer":"","exclicks":"","exportFileName":"","fixed":"","focuskey":"","gendataset":"","grch_domain":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":"15","hide":"false","key_start":"","layer":"false","layout_steps_values":"{}","legend":"","legendlimit":"","linkparms":"","max_value":"","menuPosition":"","min_value":"","multi_key_field":"rowKey","multi_label_field":"rowKeyDesc","multi_scale":"true","multidimKeyName":"","multisubdivision":"default","multisubheight":"","name":"ChartB","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"true","othtype":"limit","page":"3","parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":"true","popup_height":"","popup_type":"","popup_width":"","portletsrc":"","query":"","rangebands":"","rangefunc":"","rapp":"","refline":"","reflinecol":"","selclicks":"","sequence":"31","spuid":"","subtitle":"","target":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","value_labels":"","vaxis_precision":"","vmode":"mdim","w":"150","wireframe_props":"","x":"0","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","y":"20","y_label":"","zfseries":"","zfshow":"default","zftype":"default","zindex":"6","zone":""},{"alias":"","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"","h":"20","man_query":"","name":"StaticDataProviderB","page":"3","parms":"","parms_source":"","sequence":"32","type":"StaticDataProvider","w":"162","x":"174","y":"7"},{"anchor":"bottom-left(%)-right(%)","bigtotaltext":"","canFilter":"","columnbigtotal":"","columndescrs":"","columnfields":"","columnkeys":"","columnlistvalues":"","columnpictures":"","columnsort":"","columnsorts":"","columnsortsfields":"","columnsubtotal":"","cssClass":"drilldown","cssFile":"styles\u002fGridPivotObj.css","ctrlOfVariant":"","dataobj":"","fixed":"","h":"15","hide":"","hidemeasures":"","layer":"","layout_steps_values":"{}","measurecondformats":"","measuredescrs":"","measurefields":"","measurepictures":"","measuresoncolumn":"","measurestitle":"","name":"GridPivotB","odimdescrs":"","odimfields":"","odimkeys":"","odimlistvalues":"","odimpictures":"","odimsorts":"","odimsortsfields":"","omeascondformats":"","omeasdescrs":"","omeasfields":"","omeaspictures":"","othDimMeas":"true","page":"3","print_grep":"true","print_hideexport":"","print_hidesettings":"","print_max":"","print_model":"default","print_option":"default","print_outputf":"default","print_result":"","print_title":"","rapp":"","rowbigtotal":"","rowdescrs":"","rowfields":"","rowkeys":"","rowpictures":"","rowsort":"","rowsorts":"","rowsortsfields":"","rowsubtotal":"","scroll_bars":"false","sequence":"33","spuid":"","subtotaltext":"","type":"GridPivot","uiDragDrop":"","w":"150","wireframe_props":"","x":"0","y":"36","zindex":"9","zone":""},{"FAB":"","anchor":"top-left(%)-right","bg_color":"","css_class":"spportalzoombase_toolbar","ctrlOfVariant":"","fixed":"","h":"10","hide":"false","iconWidth":"25","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"toolbar","page":"1","rapp":"","sequence":"34","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"50","wireframe_props":"","x":"100","y":"0","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ConfigGridElements","page":"1","reactive":"","sequence":"35","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"220"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"","name":"action_splinker","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"false","sequence":"36","servlet":"","target":"","type":"SPLinker","w":"176","x":"591","y":"142"},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"10","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelA","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"37","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"90","wireframe_props":"align,value,n_col","x":"10","y":"1","zindex":"1","zone":""},{"allowedentities":"..\u002fjsp-system\u002fSPVisualPivotVersion_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"SPLinkPivotVersion","offline":"","page":"1","parms":"OpenerFormId=InnerFormId,userCode=userCode,groupCode=groupCode,custom=custom,versionName=versionName","popup":"true","popup_height":"150","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"928","progressbar":"","refresh":"","sequence":"38","servlet":"..\u002fjsp-system\u002fSPVisualPivotVersion_portlet.jsp","target":"","type":"SPLinker","w":"176","x":"591","y":"70"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"InnerFormId","page":"1","reactive":"","sequence":"39","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"264"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"versionName","page":"1","reactive":"","sequence":"40","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"-4","y":"244"},{"anchor":"top-left","bg_color":"","class_Css":"SPPortalZoomBaseMenuVersion","color":"","ctrlOfVariant":"","fixed":"","fontSize":"","h":"40","hide":"true","layer":"false","layout_steps_values":"{}","maxsubitemelements":"5","name":"menu_versioni","page":"1","rapp":"","sequence":"41","spuid":"","type":"HamburgerMenu","visible_handler":"true","w":"40","wireframe_props":"","x":"182","y":"9","zindex":"","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"jsClickItem","page":"1","reactive":"","sequence":"42","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"200","y":"308"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"17","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxCollapse","page":"1","rapp":"","sequence":"43","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"150","wireframe_props":"","x":"0","y":"0","zindex":"0","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"17","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxCollapseA","page":"2","rapp":"","sequence":"44","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"150","wireframe_props":"","x":"0","y":"0","zindex":"0","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"17","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxCollapseB","page":"3","rapp":"","sequence":"45","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"150","wireframe_props":"","x":"0","y":"0","zindex":"0","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"EmitterName","page":"1","reactive":"","sequence":"46","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"199","y":"64"},{"anchor":"top-left","bg_color":"","class_Css":"SPPortalZoomBaseMenu","color":"","ctrlOfVariant":"","fixed":"","fontSize":"","h":"40","hide":"true","layer":"false","layout_steps_values":"{}","maxsubitemelements":"5","name":"refresh_menu","page":"2","rapp":"","sequence":"47","spuid":"","type":"HamburgerMenu","visible_handler":"true","w":"40","wireframe_props":"","x":"167","y":"-27","zindex":"","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"pParent","page":"1","reactive":"","sequence":"48","server_side":"false","type":"Variable","typevar":"character","w":"176","x":"199","y":"130"},{"cachelevel":"","cachelevel2":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":"20","measures":"","name":"mDataobj","page":"1","parms":"","parms_source":"","queries":"","sequence":"49","type":"MLevelDataProvider","uptolevels":"","uptolevels2":"","w":"176","x":"399","y":"70"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:ReceiverName,userCode,EventName,groupCode,custom,Caption,ConfigName,UID,OpenerFormId,QueryParms,m_cWv,ConfigNavbar,PrintTitle,ViewMode,ConfigGridElements,versionName,EmitterName,pParent*/%>
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
.SPVisualPivot_container .SPPortalZoom .SPPortalZoomtTabs, .SPPortalZoomtTabs{  display: none;
}
.SPVisualPivot_container .buttonx{
  cursor: pointer;
}
.SPVisualPivot_container {
  height:100%;
  overflow:auto;
}
.SPVisualPivot_portlet{
  position:relative;
  min-width:150px;
  height:100%;
}
.SPVisualPivot_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.SPVisualPivot_portlet[Data-page="2"]{
  height:100%;
  width:100%;
}
.SPVisualPivot_portlet[Data-page="3"]{
  height:100%;
  width:100%;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .toolbarA_ctrl {
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
.SPVisualPivot_portlet > .SPVisualPivot_page > .toolbarB_ctrl {
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
.SPVisualPivot_portlet > .SPVisualPivot_page > .labelB_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:10px;
  right:50px;
  right:33.333332%;
  width:auto;
  height:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .labelB_ctrl {
  height:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .labelB_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .GridPivot_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:30px;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .Chart_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .label_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:6px;
  right:54px;
  right:36.0%;
  width:auto;
  height:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .label_ctrl {
  height:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .label_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .ChartB_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:15px;
  width:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .GridPivotB_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:-1px;
  width:auto;
  height:15px;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .toolbar_ctrl {
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
.SPVisualPivot_portlet > .SPVisualPivot_page > .labelA_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:10px;
  right:50px;
  right:33.333332%;
  width:auto;
  height:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .labelA_ctrl {
  height:auto;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .labelA_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .menu_versioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:182px;
  width:40px;
  height:40px;
  display:none;
}
.SPVisualPivot_portlet .menu_versioni_ctrl.global_handler{
}
.SPVisualPivot_portlet .menu_versioni_ctrl.global_handler:after{
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapse_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapse_ctrl {
  height:17px;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapse_ctrl > .box_content {
  height:100%;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapse_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseA_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseA_ctrl {
  height:17px;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseA_ctrl > .box_content {
  height:100%;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseA_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseB_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseB_ctrl {
  height:17px;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseB_ctrl > .box_content {
  height:100%;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .BoxCollapseB_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .refresh_menu_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-27px;
  left:167px;
  width:40px;
  height:40px;
  display:none;
}
.SPVisualPivot_portlet .refresh_menu_ctrl.global_handler{
}
.SPVisualPivot_portlet .refresh_menu_ctrl.global_handler:after{
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .mDataobj_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:399px;
  left:266.0%;
  right:-425px;
  right:-283.33334%;
  width:auto;
  height:20px;
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
 String def="[{\"h\":\"50,50,50\",\"layout_steps_values\":{},\"pages_names\":\"grid,chart,both\",\"steps\":\"\",\"title\":\"none\",\"type\":\"Form\",\"v_line\":\"150\",\"w\":\"100%,100%,100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"176\",\"x\":\"399\",\"y\":\"94\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"176\",\"x\":\"783\",\"y\":\"118\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"199\",\"y\":\"86\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"266\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"199\",\"y\":\"108\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"SPToolbar\",\"w\":\"50\",\"x\":\"100\",\"y\":\"0\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"288\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"3\",\"type\":\"SPToolbar\",\"w\":\"50\",\"x\":\"100\",\"y\":\"0\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"310\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"176\",\"x\":\"783\",\"y\":\"94\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"176\",\"x\":\"783\",\"y\":\"70\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"10\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"90\",\"x\":\"10\",\"y\":\"1\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"90\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"112\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"134\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"198\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"242\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"156\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"154\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"176\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"178\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"200\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"222\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"GridPivot\",\"w\":\"150\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"176\",\"x\":\"591\",\"y\":\"118\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"2\",\"title\":\"\",\"type\":\"Chart\",\"w\":\"150\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"286\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"176\",\"x\":\"591\",\"y\":\"94\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"10\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"90\",\"x\":\"6\",\"y\":\"1\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"176\",\"x\":\"783\",\"y\":\"142\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"page\":\"3\",\"title\":\"\",\"type\":\"Chart\",\"w\":\"150\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"6\"},{\"h\":\"20\",\"page\":\"3\",\"type\":\"StaticDataProvider\",\"w\":\"162\",\"x\":\"174\",\"y\":\"7\"},{\"anchor\":\"bottom-left(%)-right(%)\",\"h\":\"15\",\"layout_steps_values\":{},\"page\":\"3\",\"type\":\"GridPivot\",\"w\":\"150\",\"x\":\"0\",\"y\":\"36\",\"zindex\":\"9\"},{\"anchor\":\"top-left(%)-right\",\"h\":\"10\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"SPToolbar\",\"w\":\"50\",\"x\":\"100\",\"y\":\"0\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"220\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"176\",\"x\":\"591\",\"y\":\"142\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"10\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"90\",\"x\":\"10\",\"y\":\"1\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"176\",\"x\":\"591\",\"y\":\"70\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"264\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"-4\",\"y\":\"244\"},{\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"HamburgerMenu\",\"w\":\"40\",\"x\":\"182\",\"y\":\"9\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"200\",\"y\":\"308\"},{\"anchor\":\"\",\"h\":\"17\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"150\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"17\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Box\",\"w\":\"150\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"17\",\"layout_steps_values\":{},\"page\":\"3\",\"type\":\"Box\",\"w\":\"150\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"199\",\"y\":\"64\"},{\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"HamburgerMenu\",\"w\":\"40\",\"x\":\"167\",\"y\":\"-27\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"176\",\"x\":\"199\",\"y\":\"130\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"MLevelDataProvider\",\"w\":\"176\",\"x\":\"399\",\"y\":\"70\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVisualPivot","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPVisualPivot_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.SPVisualPivot_portlet > .SPVisualPivot_page > .menu_versioni_ctrl {
  display:none;
}
.SPVisualPivot_portlet > .SPVisualPivot_page > .refresh_menu_ctrl {
  display:none;
}

</style>
<%if (!Library.Empty(SPPrxycizer.proxycizedPath("SPVisualPivot.js"))){%>
<script src="../<%=SPPrxycizer.proxycizedPath("SPVisualPivot.js")%>"></script>
<%}%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPVisualPivot','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String ReceiverName=JSPLib.translateXSS(sp.getParameter("ReceiverName",""));
String userCode=JSPLib.translateXSS(sp.getParameter("userCode",""));
String EventName=JSPLib.translateXSS(sp.getParameter("EventName",""));
String groupCode=JSPLib.translateXSS(sp.getParameter("groupCode",""));
boolean custom=sp.getParameter("custom",false);
String labelB= "";
String Caption=JSPLib.translateXSS(sp.getParameter("Caption",""));
String ConfigName=JSPLib.translateXSS(sp.getParameter("ConfigName",""));
String VQRName= "";
String UID=JSPLib.translateXSS(sp.getParameter("UID",""));
String OpenerFormId=JSPLib.translateXSS(sp.getParameter("OpenerFormId",""));
String QueryParms=JSPLib.translateXSS(sp.getParameter("QueryParms",""));
String m_cWv=JSPLib.translateXSS(sp.getParameter("m_cWv",""));
String ConfigNavbar=JSPLib.translateXSS(sp.getParameter("ConfigNavbar",""));
boolean PrintMode=false;
String ReportName= "";
String PrintTitle=JSPLib.translateXSS(sp.getParameter("PrintTitle",""));
if(request.getAttribute("SPVisualPivot_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridPivotControl.PivotTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("d3.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("ZtPivotData.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("ZtPivot.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridPivotCtrl.js")%>'></script>
<%}
if(request.getAttribute("SPVisualPivot_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.ChartControl.ChartTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/ChartCtrl.js")%>'></script>
<jsp:include page="../chart/ZtChartLibs.jsp"/>
<script src='../<%=SPPrxycizer.proxycizedPath("ZtChart.js")%>'></script>
<%}
String ViewMode=JSPLib.translateXSS(sp.getParameter("ViewMode",""));
String label= "";
if(request.getAttribute("SPVisualPivot_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
String ConfigGridElements=JSPLib.translateXSS(sp.getParameter("ConfigGridElements",""));
String labelA= "";
String InnerFormId= "";
String versionName=JSPLib.translateXSS(sp.getParameter("versionName",""));
if(request.getAttribute("SPVisualPivot_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("HamburgerMenuObj.js")%>'></script>
<%}
String jsClickItem= "";
String EmitterName=JSPLib.translateXSS(sp.getParameter("EmitterName",""));
String pParent=JSPLib.translateXSS(sp.getParameter("pParent",""));
if(request.getAttribute("SPVisualPivot_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("MLevelDataProviderObj.js")%>'></script>
<%}
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
<div id='<%=idPortlet%>_container' class='SPVisualPivot_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPVisualPivot_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPVisualPivot','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPVisualPivot_page' style='display:block'>
<div id='<%=idPortlet%>_GridPivot'></div>
<span id='<%=idPortlet%>_label'  formid='<%=idPortlet%>' ps-name='label'    class='TitleLabel label_ctrl'><div id='<%=idPortlet%>_labeltbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_toolbar' class='disable-selection ctrl_spportalzoombase_toolbar_container spportalzoombase_toolbar' >
<div id='<%=idPortlet%>_toolbar_openMenuHandlerDiv' class='spportalzoombase_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbar_openMenuHandlerImg' class='spportalzoombase_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbar_listButtons' class='spportalzoombase_toolbar_listButtons'></div>
</div>
<div id='<%=idPortlet%>_menu_versioni' class='menu_versioni_ctrl SPPortalZoomBaseMenuVersion global_handler closed'></div><div id='<%=idPortlet%>_BoxCollapse' class='BoxCollapse_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxCollapse_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_mDataobj' style='position:absolute;top:70px;left:399px;width:176px;height:20px;'></div>
</div>
<div id='<%=idPortlet%>_page_2' class='SPVisualPivot_page' style='display:none'>
<div id='<%=idPortlet%>_toolbarA' class='disable-selection ctrl_spportalzoombase_toolbar_container spportalzoombase_toolbar' >
<div id='<%=idPortlet%>_toolbarA_openMenuHandlerDiv' class='spportalzoombase_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbarA_openMenuHandlerImg' class='spportalzoombase_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbarA_listButtons' class='spportalzoombase_toolbar_listButtons'></div>
</div>
<div id='<%=idPortlet%>_Chart'></div>
<span id='<%=idPortlet%>_labelA'  formid='<%=idPortlet%>' ps-name='labelA'    class='TitleLabel labelA_ctrl'><div id='<%=idPortlet%>_labelAtbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_BoxCollapseA' class='BoxCollapseA_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxCollapseA_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_refresh_menu' class='refresh_menu_ctrl SPPortalZoomBaseMenu global_handler closed'></div></div>
<div id='<%=idPortlet%>_page_3' class='SPVisualPivot_page' style='display:none'>
<div id='<%=idPortlet%>_toolbarB' class='disable-selection ctrl_spportalzoombase_toolbar_container spportalzoombase_toolbar' >
<div id='<%=idPortlet%>_toolbarB_openMenuHandlerDiv' class='spportalzoombase_toolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbarB_openMenuHandlerImg' class='spportalzoombase_toolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbarB_listButtons' class='spportalzoombase_toolbar_listButtons'></div>
</div>
<span id='<%=idPortlet%>_labelB'  formid='<%=idPortlet%>' ps-name='labelB'    class='TitleLabel labelB_ctrl'><div id='<%=idPortlet%>_labelBtbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_ChartB'></div>
<div id='<%=idPortlet%>_GridPivotB'></div>
<div id='<%=idPortlet%>_BoxCollapseB' class='BoxCollapseB_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxCollapseB_td' class='box_content'></div>
</div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPVisualPivot');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPVisualPivot_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("grid"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("chart"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page3', element:'<%=idPortlet%>_page_3',caption:'<%=JSPLib.ToJSValue(sp.translate("both"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPVisualPivot',["150","150","150"],["50","50","50"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,true,3,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"150","h":"50","title":"grid","layer":""},{"layout_steps_values":{},"w":"150","h":"50","title":"chart","layer":""},{"layout_steps_values":{},"w":"150","h":"50","title":"both","layer":""}]);
this.dataobj=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":true,"name":"dataobj","nrows":"999999","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":176,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":399,"y":94});
this.$entity$_zoomSetFilter=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_zoomSetFilter","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_zoomSetFilter","objsValues":"this.SetFilters(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":176,"x":783,"y":118});
this.ReceiverName=new ZtVWeb._VC(this,'ReceiverName',null,'character','<%=JSPLib.ToJSValue(ReceiverName,false,true)%>',false,false);
this.userCode=new ZtVWeb._VC(this,'userCode',null,'character','<%=JSPLib.ToJSValue(userCode,false,true)%>',false,false);
this.EventName=new ZtVWeb._VC(this,'EventName',null,'character','<%=JSPLib.ToJSValue(EventName,false,true)%>',false,false);
this.toolbarA=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-left(%)-right","bg_color":"","cssClass":"spportalzoombase_toolbar","ctrlid":"<%=idPortlet%>_toolbarA","h":10,"hide":"false","iconWidth":25,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbarA","page":2,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":50,"x":100,"y":0,"zindex":"3"});
this.groupCode=new ZtVWeb._VC(this,'groupCode',null,'character','<%=JSPLib.ToJSValue(groupCode,false,true)%>',false,false);
this.toolbarB=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-left(%)-right","bg_color":"","cssClass":"spportalzoombase_toolbar","ctrlid":"<%=idPortlet%>_toolbarB","h":10,"hide":"false","iconWidth":25,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbarB","page":3,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":50,"x":100,"y":0,"zindex":"3"});
this.custom=new ZtVWeb._VC(this,'custom',null,'logic',<%=custom%>,false,false);
this.$entity$_updateFilters=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"pagelet","ctrlid":"<%=idPortlet%>_$entity$_updateFilters","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateFilters","page":1,"parmsNames":"Filters","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","type":"EventEmitter","w":176,"x":783,"y":94});
this.$entity$_updateConfiguration=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_updateConfiguration","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateConfiguration","page":1,"parmsNames":"Config,reload","parmsTypes":"func,func","parmsValues":"this.Config(),this.GetReload()","persistent":"true","type":"EventEmitter","w":176,"x":783,"y":70});
this.labelB=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_labelB","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":10,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelB","nowrap":"false","page":3,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelB),false,true)%>","type":"Label","w":90,"x":10,"y":1,"zindex":"1"});
this.Caption=new ZtVWeb._VC(this,'Caption',null,'character','<%=JSPLib.ToJSValue(Caption,false,true)%>',false,false);
this.ConfigName=new ZtVWeb._VC(this,'ConfigName',null,'character','<%=JSPLib.ToJSValue(ConfigName,false,true)%>',false,false);
this.VQRName=new ZtVWeb._VC(this,'VQRName',null,'character','<%=JSPLib.ToJSValue(VQRName,false,true)%>',false,false);
this.UID=new ZtVWeb._VC(this,'UID',null,'character','<%=JSPLib.ToJSValue(UID,false,true)%>',false,false);
this.OpenerFormId=new ZtVWeb._VC(this,'OpenerFormId',null,'character','<%=JSPLib.ToJSValue(OpenerFormId,false,true)%>',false,false);
this.QueryParms=new ZtVWeb._VC(this,'QueryParms',null,'character','<%=JSPLib.ToJSValue(QueryParms,false,true)%>',false,false);
this.m_cWv=new ZtVWeb._VC(this,'m_cWv',null,'character','<%=JSPLib.ToJSValue(m_cWv,false,true)%>',false,false);
this.ConfigNavbar=new ZtVWeb._VC(this,'ConfigNavbar',null,'character','<%=JSPLib.ToJSValue(ConfigNavbar,false,true)%>',false,false);
this.PrintMode=new ZtVWeb._VC(this,'PrintMode',null,'logic',<%=PrintMode%>,false,false);
this.ReportName=new ZtVWeb._VC(this,'ReportName',null,'character','<%=JSPLib.ToJSValue(ReportName,false,true)%>',false,false);
this.PrintTitle=new ZtVWeb._VC(this,'PrintTitle',null,'character','<%=JSPLib.ToJSValue(PrintTitle,false,true)%>',false,false);
this.GridPivot=new ZtVWeb.GridPivot(this,{"anchor":"top-left(%)-right(%)","bigtotaltext":"","canFilter":false,"columnbigtotal":false,"columndescrs":"","columnfields":"","columninit":0,"columnkeys":"","columnlistvalues":"","columnpictures":"","columnsort":false,"columnsorts":"","columnsortsfields":"","columnsubtotal":false,"cssClass":"drilldown","cssFile":"styles\u002fGridPivotObj.css","ctrlid":"<%=idPortlet%>_GridPivot","dataobj":"","h":30,"hide":"","hidemeasures":true,"layer":false,"layout_steps_values":{},"measurecondformats":"","measuredescrs":"","measurefields":"","measurepictures":"","measuresoncolumn":false,"measurestitle":"","name":"GridPivot","odimdescrs":"","odimfields":"","odimkeys":"","odimlistvalues":"","odimpictures":"","odimsorts":"","odimsortsfields":"","omeascondformats":"","omeasdescrs":"","omeasfields":"","omeaspictures":"","othDimMeas":true,"page":1,"print_grep":true,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_model":"default","print_option":"default","print_outputf":"default","print_result":false,"print_size":"","print_title":"","print_totals":false,"rowbigtotal":false,"rowdescrs":"","rowfields":"","rowinit":0,"rowkeys":"","rowpictures":"","rowsort":false,"rowsorts":"","rowsortsfields":"","rowsubtotal":false,"scroll_bars":"false","spuid":"","subtotaltext":"","type":"GridPivot","uiDragDrop":false,"w":150,"x":0,"y":20,"zindex":"4"});
this.GridPivot._Translations = {rowdescrs:'',columndescrs:'',measuredescrs:'',odimdescrs:'',omeasdescrs:'',subtotaltext:'',bigtotaltext:'',measurestitle:'',print_title:''}
<%String GridPivot_variant;
java.util.List<String> cssList_GridPivot_variant = new java.util.ArrayList<String>();
 GridPivot_variant=SPPrxycizer.getVariant("portalstudio.css");
if(GridPivot_variant != null) { cssList_GridPivot_variant.add("'"+SPPrxycizer.proxycizedPath("portalstudio.css")+"'" );
}
 GridPivot_variant=SPPrxycizer.getThemedVariant("portalstudio.css", sp.getSkin());
if(GridPivot_variant!= null) { cssList_GridPivot_variant.add("'"+SPPrxycizer.proxycizedPath(sp.getSkin()+"/portalstudio.css")+"'");
}
 GridPivot_variant=SPPrxycizer.getVariant("styles/GridPivotObj.css");
if(GridPivot_variant != null) { cssList_GridPivot_variant.add("'"+SPPrxycizer.proxycizedPath("styles/GridPivotObj.css")+"'" );
}
 GridPivot_variant=SPPrxycizer.getThemedVariant("styles/GridPivotObj.css", sp.getSkin());
if(GridPivot_variant!= null) { cssList_GridPivot_variant.add("'"+SPPrxycizer.proxycizedPath(sp.getSkin()+"/styles/GridPivotObj.css")+"'");
}%>
this.GridPivot._cssFiles = <%=cssList_GridPivot_variant.toString()%>
this.loadVPV=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("SPVPVProxy",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_loadVPV","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"loadVPV","offline":false,"page":1,"parms":"ConfigName,action=load","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"SPVPVProxy","target":"","type":"SPLinker","w":176,"x":591,"y":118});
this.loadVPV.m_cID='<%=JSPLib.cmdHash("routine,SPVPVProxy",request.getSession())%>';
this.Chart=new ZtVWeb.ChartCtrl(this,{"add_dataobj":"","anchor":"top-left(%)-right(%)-bottom","auto_exec":true,"categoryKeyName":"","categoryname":"","ccolor":"","chartH":"","chartNavbar":false,"chartNavbarAddRemove":false,"chartNavbarChangepage":false,"chartNavbarFirstlast":false,"chartNavbarLastpage":false,"chartNavbarPagepanel":false,"chartW":"","chart_type":"category","class_cat":"","class_key":"","class_keycat":"","class_label":"","class_subaxis":"","class_xfrom":"","class_xto":"","class_xval":"","class_yfrom":"","class_yto":"","class_yval":"","compactChart":"","countryname":"","cstroke":"","csubname":"","ctooltip":"","ctrlid":"<%=idPortlet%>_Chart","ctype":"VBAR","cursorAlignment":"left","cursorPosition":"top","cursorType":"none","danimation":"","data_order":"","dataload_datelimit":"","dataobj":"","dateformat":"","def":"","depclass":"","depfield_1":"","depfield_1class":"","depfield_1label":"","depfield_2":"","depfield_2class":"","depfield_2label":"","depvalue":"","domain_type":"","downloadlist":"","dsetFunct":"","elanimate":"","enable_change_order":false,"enable_menu_sel":false,"exclSer":"","exclicks":false,"exportFileName":"","fieldpath":"","fieldvalue":"","focuskey":"","gendataset":false,"geo_0_field":"","geo_1_field":"","geo_dom_field":"","geo_level":"","geo_level_2":"","geo_level_3":"","geo_onlydata":"","geo_value_field":"","geo_view":"","geo_view_select":"","grch_domain":"","grch_fields":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":30,"hide":"false","ismulti":false,"key_start":"","keyfieldpath":"","labelKey_field":"","label_field":"","label_series":"","layer":false,"layout_steps_values":{},"legend":"","legendlimit":"","linkparms":"","manualScale":"","mapSeries":"","markers_dataobj":"","markers_desc":"","markers_key":"","markers_lat":"","markers_lng":"","markers_type":"","max_field":"","max_value":"","measureKey_series_field":"","measure_series_field":"","menuPosition":"","min_field":"","min_value":"","multi_autochange":false,"multi_key_field":"","multi_label_field":"","multi_scale":true,"multidimKeyName":"","multisubdivision":"default","multisubheight":"","name":"Chart","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"","othtype":"","page":2,"parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":true,"popup_height":"","popup_type":"","popup_width":"","portletsrc":"","ptl_translate":true,"query":"","rangebands":"","rangefunc":"","refline":"","reflinecol":"","selclicks":false,"seriesname":"","sfield":"","sfieldlabel":"","spuid":"","subtitle":"","target":"","tcustformat":"","tdomainunit":"","tdomainvalue":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","val_field":"","value_fields":"","value_labels":"","valuename":"","valuezname":"","vaxis_precision":"","vmode":"","voro_cat":"","voro_class":"","voro_coords":"","w":150,"x":0,"xKey_field":"","x_field":"","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","xyz_series_field":"","y":20,"y_field":"","y_label":"","z_field":"","zfseries":"","zfshow":"","zftype":"default","zindex":"5"});
this.ViewMode=new ZtVWeb._VC(this,'ViewMode',null,'character','<%=JSPLib.ToJSValue(ViewMode,false,true)%>',false,false);
this.SPLinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":176,"x":591,"y":94});
this.SPLinker.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.label=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_label","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":10,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label),false,true)%>","type":"Label","w":90,"x":6,"y":1,"zindex":"1"});
this.$entity$_GetConfigurationField=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_GetConfigurationField","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_GetConfigurationField","page":1,"parmsNames":"Fields","parmsTypes":"func","parmsValues":"this.GetConfigurationField()","persistent":"true","type":"EventEmitter","w":176,"x":783,"y":142});
this.ChartB=new ZtVWeb.ChartCtrl(this,{"add_dataobj":"","anchor":"top-left(%)-right(%)-bottom","auto_exec":true,"categoryKeyName":"","categoryname":"","ccolor":"","chartH":"","chartNavbar":false,"chartNavbarAddRemove":false,"chartNavbarChangepage":false,"chartNavbarFirstlast":false,"chartNavbarLastpage":false,"chartNavbarPagepanel":false,"chartW":"","chart_type":"","class_cat":"","class_key":"","class_keycat":"","class_label":"","class_subaxis":"","class_xfrom":"","class_xto":"","class_xval":"","class_yfrom":"","class_yto":"","class_yval":"","compactChart":"","countryname":"","cstroke":"","csubname":"","ctooltip":"","ctrlid":"<%=idPortlet%>_ChartB","ctype":"","cursorAlignment":"left","cursorPosition":"top","cursorType":"none","danimation":"","data_order":"","dataload_datelimit":"","dataobj":"StaticDataProviderB","dateformat":"","def":"","depclass":"","depfield_1":"","depfield_1class":"","depfield_1label":"","depfield_2":"","depfield_2class":"","depfield_2label":"","depvalue":"","domain_type":"","downloadlist":"","dsetFunct":"","elanimate":"","enable_change_order":false,"enable_menu_sel":false,"exclSer":"","exclicks":false,"exportFileName":"","fieldpath":"","fieldvalue":"","focuskey":"","gendataset":false,"geo_0_field":"","geo_1_field":"","geo_dom_field":"","geo_level":"","geo_level_2":"","geo_level_3":"","geo_onlydata":"","geo_value_field":"","geo_view":"","geo_view_select":"","grch_domain":"","grch_fields":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":15,"hide":"false","ismulti":false,"key_start":"","keyfieldpath":"","labelKey_field":"","label_field":"","label_series":"","layer":false,"layout_steps_values":{},"legend":"","legendlimit":"","linkparms":"","manualScale":"","mapSeries":"","markers_dataobj":"","markers_desc":"","markers_key":"","markers_lat":"","markers_lng":"","markers_type":"","max_field":"","max_value":"","measureKey_series_field":"","measure_series_field":"","menuPosition":"","min_field":"","min_value":"","multi_autochange":false,"multi_key_field":"rowKey","multi_label_field":"rowKeyDesc","multi_scale":true,"multidimKeyName":"","multisubdivision":"default","multisubheight":"","name":"ChartB","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"true","othtype":"limit","page":3,"parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":true,"popup_height":"","popup_type":"","popup_width":"","portletsrc":"","ptl_translate":true,"query":"","rangebands":"","rangefunc":"","refline":"","reflinecol":"","selclicks":false,"seriesname":"","sfield":"","sfieldlabel":"","spuid":"","subtitle":"","target":"","tcustformat":"","tdomainunit":"","tdomainvalue":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","val_field":"","value_fields":"","value_labels":"","valuename":"","valuezname":"","vaxis_precision":"","vmode":"mdim","voro_cat":"","voro_class":"","voro_coords":"","w":150,"x":0,"xKey_field":"","x_field":"","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","xyz_series_field":"","y":20,"y_field":"","y_label":"","z_field":"","zfseries":"","zfshow":"default","zftype":"default","zindex":"6"});
this.StaticDataProviderB=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProviderB","dataproviders":"","fieldsString":"","fieldstypeString":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProviderB","page":3,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":162,"x":174,"y":7});
this.GridPivotB=new ZtVWeb.GridPivot(this,{"anchor":"bottom-left(%)-right(%)","bigtotaltext":"","canFilter":false,"columnbigtotal":false,"columndescrs":"","columnfields":"","columninit":0,"columnkeys":"","columnlistvalues":"","columnpictures":"","columnsort":false,"columnsorts":"","columnsortsfields":"","columnsubtotal":false,"cssClass":"drilldown","cssFile":"styles\u002fGridPivotObj.css","ctrlid":"<%=idPortlet%>_GridPivotB","dataobj":"","h":15,"hide":"","hidemeasures":false,"layer":false,"layout_steps_values":{},"measurecondformats":"","measuredescrs":"","measurefields":"","measurepictures":"","measuresoncolumn":false,"measurestitle":"","name":"GridPivotB","odimdescrs":"","odimfields":"","odimkeys":"","odimlistvalues":"","odimpictures":"","odimsorts":"","odimsortsfields":"","omeascondformats":"","omeasdescrs":"","omeasfields":"","omeaspictures":"","othDimMeas":true,"page":3,"print_grep":true,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_model":"default","print_option":"default","print_outputf":"default","print_result":false,"print_size":"","print_title":"","print_totals":false,"rowbigtotal":false,"rowdescrs":"","rowfields":"","rowinit":0,"rowkeys":"","rowpictures":"","rowsort":false,"rowsorts":"","rowsortsfields":"","rowsubtotal":false,"scroll_bars":"false","spuid":"","subtotaltext":"","type":"GridPivot","uiDragDrop":false,"w":150,"x":0,"y":36,"zindex":"9"});
this.GridPivotB._Translations = {rowdescrs:'',columndescrs:'',measuredescrs:'',odimdescrs:'',omeasdescrs:'',subtotaltext:'',bigtotaltext:'',measurestitle:'',print_title:''}
<%String GridPivotB_variant;
java.util.List<String> cssList_GridPivotB_variant = new java.util.ArrayList<String>();
 GridPivotB_variant=SPPrxycizer.getVariant("portalstudio.css");
if(GridPivotB_variant != null) { cssList_GridPivotB_variant.add("'"+SPPrxycizer.proxycizedPath("portalstudio.css")+"'" );
}
 GridPivotB_variant=SPPrxycizer.getThemedVariant("portalstudio.css", sp.getSkin());
if(GridPivotB_variant!= null) { cssList_GridPivotB_variant.add("'"+SPPrxycizer.proxycizedPath(sp.getSkin()+"/portalstudio.css")+"'");
}
 GridPivotB_variant=SPPrxycizer.getVariant("styles/GridPivotObj.css");
if(GridPivotB_variant != null) { cssList_GridPivotB_variant.add("'"+SPPrxycizer.proxycizedPath("styles/GridPivotObj.css")+"'" );
}
 GridPivotB_variant=SPPrxycizer.getThemedVariant("styles/GridPivotObj.css", sp.getSkin());
if(GridPivotB_variant!= null) { cssList_GridPivotB_variant.add("'"+SPPrxycizer.proxycizedPath(sp.getSkin()+"/styles/GridPivotObj.css")+"'");
}%>
this.GridPivotB._cssFiles = <%=cssList_GridPivotB_variant.toString()%>
this.toolbar=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"","anchor":"top-left(%)-right","bg_color":"","cssClass":"spportalzoombase_toolbar","ctrlid":"<%=idPortlet%>_toolbar","h":10,"hide":"false","iconWidth":25,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbar","page":1,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":50,"x":100,"y":0,"zindex":"3"});
this.ConfigGridElements=new ZtVWeb._VC(this,'ConfigGridElements',null,'character','<%=JSPLib.ToJSValue(ConfigGridElements,false,true)%>',false,false);
this.action_splinker=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_action_splinker","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"action_splinker","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"false","servlet":"","target":"","type":"SPLinker","w":176,"x":591,"y":142});
this.action_splinker.m_cID='<%=JSPLib.cmdHash("routine,",request.getSession())%>';
this.labelA=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"TitleLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_labelA","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":10,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelA","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"true","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelA),false,true)%>","type":"Label","w":90,"x":10,"y":1,"zindex":"1"});
this.SPLinkPivotVersion=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("../jsp-system/SPVisualPivotVersion_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinkPivotVersion","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinkPivotVersion","offline":false,"page":1,"parms":"OpenerFormId=InnerFormId,userCode=userCode,groupCode=groupCode,custom=custom,versionName=versionName","popup":"true","popup_height":"150","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"928","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fSPVisualPivotVersion_portlet.jsp","target":"","type":"SPLinker","w":176,"x":591,"y":70});
this.SPLinkPivotVersion.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/SPVisualPivotVersion_portlet.jsp",request.getSession())%>';
this.InnerFormId=new ZtVWeb._VC(this,'InnerFormId',null,'character','<%=JSPLib.ToJSValue(InnerFormId,false,true)%>',false,false);
this.versionName=new ZtVWeb._VC(this,'versionName',null,'character','<%=JSPLib.ToJSValue(versionName,false,true)%>',false,false);
this.menu_versioni=new ZtVWeb.HamburgerMenuCtrl(this,{"anchor":"top-left","bg_color":"","color":"","css_class":"SPPortalZoomBaseMenuVersion","ctrlid":"<%=idPortlet%>_menu_versioni","fontSize":0,"h":40,"hide":"true","layer":false,"layout_steps_values":{},"maxsubitemelements":5,"name":"menu_versioni","page":1,"spuid":"","type":"HamburgerMenu","visible_handler":true,"w":40,"x":182,"y":9,"zindex":""});
this.jsClickItem=new ZtVWeb._VC(this,'jsClickItem',null,'character','<%=JSPLib.ToJSValue(jsClickItem,false,true)%>',false,false);
this.BoxCollapse=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxCollapse","groupName":"","h":17,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxCollapse","page":1,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":150,"x":0,"y":0,"zindex":"0"});
this.BoxCollapse.containedCtrls = ['label'];
this.BoxCollapseA=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxCollapseA","groupName":"","h":17,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxCollapseA","page":2,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":150,"x":0,"y":0,"zindex":"0"});
this.BoxCollapseA.containedCtrls = ['labelA'];
this.BoxCollapseB=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxCollapseB","groupName":"","h":17,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxCollapseB","page":3,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":150,"x":0,"y":0,"zindex":"0"});
this.BoxCollapseB.containedCtrls = ['labelB'];
this.EmitterName=new ZtVWeb._VC(this,'EmitterName',null,'character','<%=JSPLib.ToJSValue(EmitterName,false,true)%>',false,false);
this.refresh_menu=new ZtVWeb.HamburgerMenuCtrl(this,{"anchor":"top-left","bg_color":"","color":"","css_class":"SPPortalZoomBaseMenu","ctrlid":"<%=idPortlet%>_refresh_menu","fontSize":0,"h":40,"hide":"true","layer":false,"layout_steps_values":{},"maxsubitemelements":5,"name":"refresh_menu","page":2,"spuid":"","type":"HamburgerMenu","visible_handler":true,"w":40,"x":167,"y":-27,"zindex":""});
this.pParent=new ZtVWeb._VC(this,'pParent',null,'character','<%=JSPLib.ToJSValue(pParent,false,true)%>',false,false);
this.mDataobj=new ZtVWeb.MLevelDataProvider(this,{"anchor":"top-left(%)-right(%)","async":false,"cachelevel":0,"cachelevel2":0,"cmdHash":["<%=JSPLib.cmdHash("",request.getSession())%>"],"ctrlid":"<%=idPortlet%>_mDataobj","decrypted_parms":"","encrypted_fields":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"measures":"","name":"mDataobj","page":1,"parms":"","parms_source":"","queries":"","type":"MLevelDataProvider","uptolevels":"","uptolevels2":"","w":176,"x":399,"y":70});
this.mDataobj._FTranslations = {In_Progress:'<%=JSPLib.ToJSValue(sp.translate("MSG_ELABORATION_INPROGRESS"))%>'}
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
<%request.setAttribute("SPVisualPivot_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPVisualPivot_Static=function(){
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
this.StaticDataProviderB.addRowConsumer(this.ChartB);
<%if("true".equals(sp.getParameter("SPFromFrontEnd","")) &&  !(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples","")))){%>
window.location='../jsp-system/SPLogin.jsp?m_cURL=<%=JSPLib.ToJSValue(request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request),false)%>'
<%}

java.util.regex.Pattern validVarName = java.util.regex.Pattern.compile("[a-zA-Z_$][a-zA-Z_$0-9]*");
int configMode = sp.VisualPivotConfigMode();
boolean canPrint = sp.CanPrintVisualPivot();
String sqpkey="";
%>
this.savinghashparameter = '<%=JSPLib.cmdHash("VisualPivot", request.getSession())%>';
//document.getElementById(this.formid+"_tabcontainer").style.display='none';
this.configModeSecurity=<%=configMode%>;
this.printModeSecurity=<%=canPrint%>;
this.Var=function(val){
  this.val=val;
  this.Value=function(val){
    if(arguments.length) this.val=val;
    return this.val;
  }
}
<%  
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
 this.theme = <%=Library.ToJSValue(sp.getTheme(), "C", 0, 0)%>;
var queryParms=<%=Library.ToJSValue(queryParms,"C",0,0)%>;
//this.presetParams=queryParms;
this.dataobj.parms+=','+queryParms;
this.mDataobj.parms+=','+queryParms;
//this.dataobj.cmdHash=' =sqpkey%>'
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
//per avere le stringhe fisse
ZtVWeb.AddTranslation('MSG_VIEWS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_VIEWS"),"C",0,0)%>);
ZtVWeb.AddTranslation('PIVOT_SAVE_CONFIG',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("PIVOT_SAVE_CONFIG"),"C",0,0)%>);
ZtVWeb.AddTranslation('PIVOT_HIDE_FIELDS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("PIVOT_HIDE_FIELDS"),"C",0,0)%>);
ZtVWeb.AddTranslation('PIVOT_SHOW_FIELDS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("PIVOT_SHOW_FIELDS"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_VERSIONS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_VERSIONS"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_ZOOM_ACTIONS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_ZOOM_ACTIONS"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_FILTERS',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_FILTERS"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_VZM_PRINT',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_VZM_PRINT"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_FORM_FUNCTION_REFRESH',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_FORM_FUNCTION_REFRESH"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_XLSX_TABLE',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_XLSX_TABLE"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_XLSX_PIVOT',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_XLSX_PIVOT"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_FULL_EDITOR',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_FULL_EDITOR"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_DRILL_DOWN',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_DRILL_DOWN"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_DRILL_UP',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_DRILL_UP"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_VIEW',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_VIEW"),"C",0,0)%>);
ZtVWeb.AddTranslation('MSG_OPEN_LINK',<%=com.zucchetti.sitepainter.Library.ToJSValue(sp.translate("MSG_OPEN_LINK"),"C",0,0)%>);
                                                                                                                                                      
doVPV.call(this);

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPVisualPivot_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_$entity$_zoomSetFilter=function(parmsObj){<%=idPortlet%>.$entity$_zoomSetFilter.receiveFnc(parmsObj);}
window.<%=idPortlet%>.$entity$_updateFilters.setParms();
window.<%=idPortlet%>.$entity$_updateConfiguration.setParms();
window.<%=idPortlet%>.$entity$_GetConfigurationField.setParms();
window.<%=idPortlet%>.Chart._ChartTranslations = {title:'<%=JSPLib.ToJSValue(sp.translate(""))%>',subtitle:'<%=JSPLib.ToJSValue(sp.translate(""))%>',x_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',y_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',percent_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',titleSeries:'<%=JSPLib.ToJSValue(sp.translate(""))%>',othlabel:'<%=JSPLib.ToJSValue(sp.translate(""))%>',label_series:''}
window.<%=idPortlet%>.Chart._createChart()
window.<%=idPortlet%>.ChartB._ChartTranslations = {title:'<%=JSPLib.ToJSValue(sp.translate(""))%>',subtitle:'<%=JSPLib.ToJSValue(sp.translate(""))%>',x_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',y_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',percent_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',titleSeries:'<%=JSPLib.ToJSValue(sp.translate(""))%>',othlabel:'<%=JSPLib.ToJSValue(sp.translate(""))%>',label_series:''}
window.<%=idPortlet%>.ChartB._createChart()
ZtVWeb.addPortletObj('<%=idPortlet%>','SPVisualPivot',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPVisualPivot');
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
sp.endPage("SPVisualPivot");
}%>
<%! public String getJSPUID() { return "3568875007"; } %>