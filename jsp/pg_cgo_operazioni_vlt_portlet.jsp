<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Operazioni da Completare (VLT)\",true)\n}\n\nfunction LanciaView() {\n  _comando=this.ComandoWorkflow.Link();\n  this.comando.Value(Left(_comando,1));\n  this.OpeEdit.Link()\n}  \n\nfunction RefreshView() {\n  this.Query1.Query();\n  this.Grid0.Refresh();\n}  \n\nfunction Ricerca_Click(){\n  this.RefreshView()\n}\n\nfunction Excel_Click(){\n  this.EstrazioneExcel.Link()\n}   \n\nfunction Uscita_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.BtnUscita.Link();\n  }\n}  ","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Dipendenza\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODDIPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DESCRIZ\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:LanciaView()\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAFLGOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"C\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Segno\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SEGNO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"C,C,D,C,C,N,C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":69,\"w\":320,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":69,\"w\":480,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":45,\"w\":768,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"45","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":61,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":61,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":732,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\" \"},\"1024\":{\"x\":979,\"y\":61,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Uscita","page":"1","path_type":"","sequence":"1","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"732","y":"8","zindex":"1"},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_agenzia=agenzia","parms_source":"","query":"qbe_cgo_operazioni_vlt","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"0","y":"-30"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per produrre il file excel","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":291,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":436,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":660,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\" \"},\"1024\":{\"x\":929,\"y\":27,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Excel","page":"1","path_type":"","sequence":"2","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"660","y":"8","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"SNAINUMOPE","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":83,\"y\":-32,\"w\":45,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":124,\"y\":-32,\"w\":67,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":199,\"y\":-32,\"w\":107,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":263,\"y\":-32,\"w\":\"146\",\"h\":22,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"w_snainumope","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"3","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"107","wireframe_props":"name","x":"199","y":"-32","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"master","h":"30","m_cAction":"edit","m_cAltInterface":"","name":"OpeEdit","offline":"false","page":"1","parms":"SNAINUMOPE=w_snainumope,verifica=comando,tipop=V","popup":"true","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"4","servlet":"armt_snai_oper_v","target":"","type":"SPLinker","w":"30","x":"50","y":"-30"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"ComandoWorkflow","offline":"false","page":"1","parms":"pNumOpe=w_snainumope,pFlgT=P,pAgenzia=gCodDip","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"5","servlet":"..\u002fservlet\u002farfn_snai_oper_load","target":"","type":"SPLinker","w":"30","x":"97","y":"-29"},{"calculate":"","dataobj":"Query1","field":"TIPOPE","h":"20","init":"","init_par":"","name":"tipope","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"1076","y":"-23"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"320\":{\"x\":173,\"y\":39,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":259,\"y\":39,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":415,\"y\":15,\"w\":50,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"1024\":{\"x\":552,\"y\":39,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Locale","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"ID Locale:","w":"50","wireframe_props":"align,value,n_col","x":"415","y":"15","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"431","y":"-30"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gCodDip","page":"1","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"600","y":"-30"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"comando","page":"1","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"759","y":"-27"},{"async":"false","entity_type":"page","h":"30","m_cAction":"","m_cAltInterface":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"926","y":"-30"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_snai_oper_v_savedEntity","objsValues":"this.RefreshView()","page":"1","parmsNames":"","sequence":"16","type":"EventReceiver","w":"22","x":"970","y":"-30"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_snai_oper_va_savedEntity_Copy","objsValues":"this.RefreshView()","page":"1","parmsNames":"","sequence":"17","type":"EventReceiver","w":"22","x":"1047","y":"15"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":31,\"y\":33,\"w\":16,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":46,\"y\":33,\"w\":24,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":74,\"y\":9,\"w\":38,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":99,\"y\":33,\"w\":\"54\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"agenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"18","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"38","wireframe_props":"name","x":"74","y":"9","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"320\":{\"x\":9,\"y\":37,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":13,\"y\":37,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":21,\"y\":13,\"w\":50,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"1024\":{\"x\":27,\"y\":37,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Agenzia","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"19","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Agenzia:","w":"50","wireframe_props":"align,value,n_col","x":"21","y":"13","zindex":"1"},{"anchor":"","calculateZoomTitle":"","configname":"cgo_agenzie","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"agenzia,descazi,xagenzia,xcodloc","keyfixedfilters":"","layout_steps_values":"{\"320\":{\"x\":48,\"y\":33,\"w\":4,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":72,\"y\":33,\"w\":6,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":115,\"y\":9,\"w\":9,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":153,\"y\":33,\"w\":\"14\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","linkedField":"agenzia","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"20","servlet":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"9","wireframe_props":"","x":"115","y":"9","zindex":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":56,\"y\":33,\"w\":109,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":84,\"y\":33,\"w\":163,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":134,\"y\":9,\"w\":261,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":177,\"y\":33,\"w\":\"350\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"descazi","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"21","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"261","wireframe_props":"name","x":"134","y":"9","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":195,\"y\":35,\"w\":66,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":292,\"y\":35,\"w\":99,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":468,\"y\":11,\"w\":158,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":623,\"y\":35,\"w\":\"212\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xcodloc","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"22","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"158","wireframe_props":"name","x":"468","y":"11","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":61,\"y\":-30,\"w\":18,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":91,\"y\":-30,\"w\":27,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":146,\"y\":-30,\"w\":43,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":195,\"y\":-30,\"w\":\"58\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"xagenzia","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"23","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"43","wireframe_props":"name","x":"146","y":"-30","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","m_cAltInterface":"","name":"EstrazioneExcel","offline":"false","page":"1","parms":"pTipo=V","popup":"true","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":"","refresh":"","sequence":"24","servlet":"arrt_cgo_operazioni_xls","target":"_new","type":"SPLinker","w":"30","x":"136","y":"-30"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per effettuare la ricerca","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":696,\"y\":8,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\" \"},\"1024\":{\"x\":979,\"y\":27,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Ricerca","page":"1","path_type":"","sequence":"26","server_side":"","src":"..\u002fimages\u002fsearch.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"696","y":"8","zindex":"1"}]%>
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
window.pg_cgo_operazioni_vlt_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LanciaView !='undefined')this.LanciaView=LanciaView;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
if(typeof Ricerca_Click !='undefined')this.Ricerca_Click=Ricerca_Click;
if(typeof Excel_Click !='undefined')this.Excel_Click=Excel_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.w_snainumope,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
this.Query1.addDataConsumer(this.tipope,<%=JSPLib.ToJSValue("TIPOPE",true)%>);
this.LinkZoom17.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Operazioni da Completare (VLT)",true)
}
function LanciaView() {
  _comando=this.ComandoWorkflow.Link();
  this.comando.Value(Left(_comando,1));
  this.OpeEdit.Link()
}  
function RefreshView() {
  this.Query1.Query();
  this.Grid0.Refresh();
}  
function Ricerca_Click(){
  this.RefreshView()
}
function Excel_Click(){
  this.EstrazioneExcel.Link()
}   
function Uscita_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.BtnUscita.Link();
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
.pg_cgo_operazioni_vlt_container {
}
.pg_cgo_operazioni_vlt_title_container {
  margin: auto;
}
.pg_cgo_operazioni_vlt_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_vlt_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:69px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:69px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="1024"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Uscita_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Uscita_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:291px;
  left:90.9375%;
  right:17px;
  right:5.3125%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:436px;
  left:90.833336%;
  right:26px;
  right:5.4166665%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:78px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet > .Excel_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="1024"] > .Excel_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Excel_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Excel_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Excel_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:83px;
  left:25.9375%;
  right:192px;
  right:60.0%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:124px;
  left:25.833334%;
  right:289px;
  right:60.208332%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:199px;
  left:25.911459%;
  right:462px;
  right:60.15625%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_vlt_portlet > .w_snainumope_ctrl {
  display:none;
}
.pg_cgo_operazioni_vlt_portlet > .w_snainumope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:39px;
  left:173px;
  left:54.0625%;
  right:126px;
  right:39.375%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:39px;
  left:259px;
  left:53.958332%;
  right:190px;
  right:39.583332%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Locale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:415px;
  left:54.036457%;
  right:303px;
  right:39.453125%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Locale_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_vlt_portlet > .Locale_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="1024"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Locale_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:31px;
  left:9.6875%;
  right:273px;
  right:85.3125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:46px;
  left:9.583333%;
  right:410px;
  right:85.416664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:74px;
  left:9.635417%;
  right:656px;
  right:85.416664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet > .agenzia_ctrl {
}
.pg_cgo_operazioni_vlt_portlet > .agenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:9px;
  left:2.8125%;
  right:290px;
  right:90.625%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:13px;
  left:2.7083333%;
  right:436px;
  right:90.833336%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:21px;
  left:2.734375%;
  right:697px;
  right:90.75521%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_vlt_portlet > .Agenzia_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="1024"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Agenzia_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:48px;
  left:15.0%;
  right:268px;
  right:83.75%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:72px;
  left:15.0%;
  right:402px;
  right:83.75%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:115px;
  left:14.973958%;
  right:644px;
  right:83.854164%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:56px;
  left:17.5%;
  right:155px;
  right:48.4375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:84px;
  left:17.5%;
  right:233px;
  right:48.541668%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .descazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:134px;
  left:17.447916%;
  right:373px;
  right:48.567707%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet > .descazi_ctrl {
}
.pg_cgo_operazioni_vlt_portlet > .descazi_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:195px;
  left:60.9375%;
  right:59px;
  right:18.4375%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:292px;
  left:60.833332%;
  right:89px;
  right:18.541666%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .xcodloc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:468px;
  left:60.9375%;
  right:142px;
  right:18.489584%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet > .xcodloc_ctrl {
}
.pg_cgo_operazioni_vlt_portlet > .xcodloc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .xagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-30px;
  left:61px;
  left:19.0625%;
  right:241px;
  right:75.3125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .xagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-30px;
  left:91px;
  left:18.958334%;
  right:362px;
  right:75.416664%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .xagenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-30px;
  left:146px;
  left:19.010416%;
  right:579px;
  right:75.390625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_vlt_portlet > .xagenzia_ctrl {
  display:none;
}
.pg_cgo_operazioni_vlt_portlet > .xagenzia_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:42px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_vlt_portlet > .Ricerca_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="1024"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="320"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="480"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_vlt_portlet[Data-step="768"] > .Ricerca_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Codice Dipendenza\"},{\"title\":\"Descrizione\"},{\"title\":\"Data Oper.\"},{\"title\":\"N° Ticket\"},{\"title\":\"Tipo Operazione\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Segno\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":69},\"480\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":69},\"768\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":45}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"45\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":61},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":61},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":61},\"768\":{\"anchor\":\"top-right\",\"font_size\":\" \",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":732,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"732\",\"y\":\"8\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"0\",\"y\":\"-30\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":929,\"y\":27},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":291,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":436,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\" \",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":660,\"y\":8}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"660\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":\"146\",\"x\":263,\"y\":-32},\"320\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":45,\"x\":83,\"y\":-32},\"480\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":67,\"x\":124,\"y\":-32},\"768\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":107,\"x\":199,\"y\":-32}},\"name\":\"w_snainumope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"107\",\"x\":\"199\",\"y\":\"-32\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"OpeEdit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"50\",\"y\":\"-30\"},{\"h\":\"30\",\"name\":\"ComandoWorkflow\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"97\",\"y\":\"-29\"},{\"h\":\"20\",\"name\":\"tipope\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1076\",\"y\":\"-23\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":552,\"y\":39},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":173,\"y\":39},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":259,\"y\":39},\"768\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":50,\"x\":415,\"y\":15}},\"n_col\":\"1\",\"name\":\"Locale\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ID Locale:\",\"w\":\"50\",\"x\":\"415\",\"y\":\"15\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"gUrlApp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"431\",\"y\":\"-30\"},{\"h\":\"20\",\"name\":\"gCodDip\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"600\",\"y\":\"-30\"},{\"h\":\"20\",\"name\":\"comando\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"759\",\"y\":\"-27\"},{\"h\":\"30\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"926\",\"y\":\"-30\"},{\"h\":\"20\",\"name\":\"armt_snai_oper_v_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"970\",\"y\":\"-30\"},{\"h\":\"20\",\"name\":\"armt_snai_oper_va_savedEntity_Copy\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"1047\",\"y\":\"15\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"54\",\"x\":99,\"y\":33},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":16,\"x\":31,\"y\":33},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":24,\"x\":46,\"y\":33},\"768\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":38,\"x\":74,\"y\":9}},\"name\":\"agenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"38\",\"x\":\"74\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":27,\"y\":37},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":9,\"y\":37},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":13,\"y\":37},\"768\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":50,\"x\":21,\"y\":13}},\"n_col\":\"1\",\"name\":\"Agenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"50\",\"x\":\"21\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"14\",\"x\":153,\"y\":33},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":4,\"x\":48,\"y\":33},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":6,\"x\":72,\"y\":33},\"768\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":9,\"x\":115,\"y\":9}},\"name\":\"LinkZoom17\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"9\",\"x\":\"115\",\"y\":\"9\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"350\",\"x\":177,\"y\":33},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":109,\"x\":56,\"y\":33},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":163,\"x\":84,\"y\":33},\"768\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":261,\"x\":134,\"y\":9}},\"name\":\"descazi\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"261\",\"x\":\"134\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"212\",\"x\":623,\"y\":35},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":66,\"x\":195,\"y\":35},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":99,\"x\":292,\"y\":35},\"768\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":158,\"x\":468,\"y\":11}},\"name\":\"xcodloc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"158\",\"x\":\"468\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"58\",\"x\":195,\"y\":-30},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":18,\"x\":61,\"y\":-30},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":27,\"x\":91,\"y\":-30},\"768\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":43,\"x\":146,\"y\":-30}},\"name\":\"xagenzia\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"43\",\"x\":\"146\",\"y\":\"-30\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"EstrazioneExcel\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"136\",\"y\":\"-30\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":27},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\" \",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":696,\"y\":8}},\"name\":\"Ricerca\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"696\",\"y\":\"8\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_vlt","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_vlt_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_vlt','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_vlt_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_snainumope= "";
if(request.getAttribute("pg_cgo_operazioni_vlt_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String tipope= "";
String Locale= "ID Locale:";
String gUrlApp=sp.getGlobal("gUrlApp","");
String gCodDip=sp.getGlobal("gCodDip","");
String comando= "";
String agenzia= "";
String Agenzia= "Agenzia:";
if(request.getAttribute("pg_cgo_operazioni_vlt_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String descazi= "";
String xcodloc= "";
String xagenzia= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_vlt_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_vlt_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_vlt_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_vlt','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_Excel' class='image Excel_ctrl'   target=''>&#xea8c;</a>
<span class='textbox-container'id='<%=idPortlet%>_w_snainumope_wrp'><input id='<%=idPortlet%>_w_snainumope' name='w_snainumope' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_snainumope' /></span>
<span id='<%=idPortlet%>_Locale'  formid='<%=idPortlet%>' ps-name='Locale'    class='label Locale_ctrl'><div id='<%=idPortlet%>_Localetbl' style='width:100%;'><%=JSPLib.ToHTML("ID Locale:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_agenzia_wrp'><input id='<%=idPortlet%>_agenzia' name='agenzia' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='agenzia' /></span>
<span id='<%=idPortlet%>_Agenzia'  formid='<%=idPortlet%>' ps-name='Agenzia'    class='label Agenzia_ctrl'><div id='<%=idPortlet%>_Agenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descazi_wrp'><input id='<%=idPortlet%>_descazi' name='descazi' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descazi' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xcodloc_wrp'><input id='<%=idPortlet%>_xcodloc' name='xcodloc' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='xcodloc' /></span>
<span class='textbox-container'id='<%=idPortlet%>_xagenzia_wrp'><input id='<%=idPortlet%>_xagenzia' name='xagenzia' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='xagenzia' /></span>
<a id='<%=idPortlet%>_Ricerca' class='image Ricerca_ctrl'   target=''>&#xea19;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_vlt');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_vlt',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":528,"hide":"false","w":320,"x":0,"y":69},"480":{"anchor":" ","h":528,"hide":"false","w":480,"x":0,"y":69},"768":{"anchor":" ","h":528,"hide":"false","w":768,"x":0,"y":45}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":45,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Dipendenza","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODDIPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DESCRIZ","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Oper.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:LanciaView()","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAFLGOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"C","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Segno","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SEGNO","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":61},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":61},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":61},"768":{"anchor":"top-right","font_size":" ","h":30,"hide":"false","w":30,"x":732,"y":8}},"name":"Uscita","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":732,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_operazioni_vlt","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_vlt",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_agenzia=agenzia","parms_source":"","type":"SQLDataobj","w":120,"x":0,"y":-30});
this.Excel=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Excel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Excel","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per produrre il file excel",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":929,"y":27},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":291,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":436,"y":27},"768":{"anchor":"top-right","font_size":" ","h":30,"hide":"false","w":30,"x":660,"y":8}},"name":"Excel","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":660,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.w_snainumope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_snainumope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"SNAINUMOPE","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":22,"hide":"false","w":"146","x":263,"y":-32},"320":{"anchor":" ","h":22,"hide":"false","w":45,"x":83,"y":-32},"480":{"anchor":" ","h":22,"hide":"false","w":67,"x":124,"y":-32},"768":{"anchor":" ","h":22,"hide":"false","w":107,"x":199,"y":-32}},"maxlength":"","name":"w_snainumope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_snainumope,false,true)%>","w":107,"x":199,"y":-32,"zerofilling":false,"zindex":"1","zoom":""});
this.OpeEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEdit","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEdit","offline":false,"page":1,"parms":"SNAINUMOPE=w_snainumope,verifica=comando,tipop=V","popup":"true","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_snai_oper_v","target":"","type":"SPLinker","w":30,"x":50,"y":-30});
this.OpeEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_snai_oper_v",request.getSession())%>';
this.ComandoWorkflow=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ComandoWorkflow","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ComandoWorkflow","offline":false,"page":1,"parms":"pNumOpe=w_snainumope,pFlgT=P,pAgenzia=gCodDip","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"..\u002fservlet\u002farfn_snai_oper_load","target":"","type":"SPLinker","w":30,"x":97,"y":-29});
this.ComandoWorkflow.m_cID='<%=JSPLib.cmdHash("routine,../servlet/arfn_snai_oper_load",request.getSession())%>';
this.tipope=new ZtVWeb._VC(this,'tipope',null,'character','<%=JSPLib.ToJSValue(tipope,false,true)%>',false,false);
this.Locale=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Locale","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":552,"y":39},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":173,"y":39},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":259,"y":39},"768":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":50,"x":415,"y":15}},"n_col":1,"name":"Locale","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Locale,false,true)%>","type":"Label","w":50,"x":415,"y":15,"zindex":"1"});
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.gCodDip=new ZtVWeb._VC(this,'gCodDip',null,'character','<%=JSPLib.ToJSValue(gCodDip,false,true)%>',false,false);
this.comando=new ZtVWeb._VC(this,'comando',null,'character','<%=JSPLib.ToJSValue(comando,false,true)%>',false,false);
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":30,"x":926,"y":-30});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.armt_snai_oper_v_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_snai_oper_v_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_snai_oper_v_savedEntity","objsValues":"this.RefreshView()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":970,"y":-30});
this.armt_snai_oper_va_savedEntity_Copy=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_snai_oper_va_savedEntity_Copy","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_snai_oper_va_savedEntity_Copy","objsValues":"this.RefreshView()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":1047,"y":15});
this.agenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_agenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"54","x":99,"y":33},"320":{"anchor":" ","h":20,"hide":"false","w":16,"x":31,"y":33},"480":{"anchor":" ","h":20,"hide":"false","w":24,"x":46,"y":33},"768":{"anchor":" ","h":20,"hide":"false","w":38,"x":74,"y":9}},"maxlength":"","name":"agenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(agenzia,false,true)%>","w":38,"x":74,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.Agenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Agenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":27,"y":37},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":9,"y":37},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":13,"y":37},"768":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":50,"x":21,"y":13}},"n_col":1,"name":"Agenzia","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Agenzia,false,true)%>","type":"Label","w":50,"x":21,"y":13,"zindex":"1"});
this.LinkZoom17=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_cgo_operazioni_vlt_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"agenzia,descazi,xagenzia,xcodloc","intovarsType":"C,C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"14","x":153,"y":33},"320":{"anchor":" ","h":20,"hide":"false","w":4,"x":48,"y":33},"480":{"anchor":" ","h":20,"hide":"false","w":6,"x":72,"y":33},"768":{"anchor":" ","h":20,"hide":"false","w":9,"x":115,"y":9}},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_cgo_operazioni_vlt_portlet.jspLinkZoom17",request.getSession())%>","linkedField":"agenzia","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,IDBASE,CODLOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":9,"x":115,"y":9,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descazi=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descazi","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"350","x":177,"y":33},"320":{"anchor":" ","h":20,"hide":"false","w":109,"x":56,"y":33},"480":{"anchor":" ","h":20,"hide":"false","w":163,"x":84,"y":33},"768":{"anchor":" ","h":20,"hide":"false","w":261,"x":134,"y":9}},"maxlength":"","name":"descazi","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descazi,false,true)%>","w":261,"x":134,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.xcodloc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xcodloc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"212","x":623,"y":35},"320":{"anchor":" ","h":20,"hide":"false","w":66,"x":195,"y":35},"480":{"anchor":" ","h":20,"hide":"false","w":99,"x":292,"y":35},"768":{"anchor":" ","h":20,"hide":"false","w":158,"x":468,"y":11}},"maxlength":"","name":"xcodloc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xcodloc,false,true)%>","w":158,"x":468,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.xagenzia=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xagenzia","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"58","x":195,"y":-30},"320":{"anchor":" ","h":20,"hide":"false","w":18,"x":61,"y":-30},"480":{"anchor":" ","h":20,"hide":"false","w":27,"x":91,"y":-30},"768":{"anchor":" ","h":20,"hide":"false","w":43,"x":146,"y":-30}},"maxlength":"","name":"xagenzia","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xagenzia,false,true)%>","w":43,"x":146,"y":-30,"zerofilling":false,"zindex":"1","zoom":""});
this.EstrazioneExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_EstrazioneExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"EstrazioneExcel","offline":false,"page":1,"parms":"pTipo=V","popup":"true","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":false,"refresh":"","servlet":"arrt_cgo_operazioni_xls","target":"_new","type":"SPLinker","w":30,"x":136,"y":-30});
this.EstrazioneExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_operazioni_xls",request.getSession())%>';
this.Ricerca=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Ricerca_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Ricerca","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per effettuare la ricerca",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":27},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":27},"768":{"anchor":"top-right","font_size":" ","h":30,"hide":"false","w":30,"x":696,"y":8}},"name":"Ricerca","page":1,"path_type":"","server_side":"","src":"&#xea19;","srchover":"&#xea1a;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":696,"y":8,"zindex":"1"});
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
<%if(request.getAttribute("pg_cgo_operazioni_vlt_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_vlt_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_vlt_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Excel.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_armt_snai_oper_v_savedEntity=function(parmsObj){<%=idPortlet%>.armt_snai_oper_v_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_snai_oper_va_savedEntity_Copy=function(parmsObj){<%=idPortlet%>.armt_snai_oper_va_savedEntity_Copy.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Ricerca.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_vlt',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_vlt');
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
sp.endPage("pg_cgo_operazioni_vlt");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom17")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ", "IDBASE", "CODLOC"};
  result.m_rdTypes = new String[]{"C", "C", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "1556662350"; } %>