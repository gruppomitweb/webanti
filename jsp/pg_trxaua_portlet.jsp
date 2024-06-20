<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function BtnEdit() {\n  _edit=this.RTEditBlock.Link()\n  if(_edit==1) {\n    this.RTEdit.Link()\n  } else {\n    alert('Impossibile lavorare una transazione già in carico ad un altro utente')\n  }  \n  this.SQLTRXAUA.Query()  \n}  \n\nfunction Rinfresca(_evt) {\n  this.SQLTRXAUA.Query(true)    \n  this.SQLTRXSCADUTE.Query()\n  this.SQLTRXINSCAD.Query()\n}  \n\nfunction ColoraRiga(_scadenza,_trxnum) {\n  _colore='';\n  if (_trxnum \u003e 0) {\n    if (_scadenza \u003e= 0 && _scadenza \u003c= this.gScadTrx.Value()) {\n      _colore='#FFFF00';\n    }\n    if (_scadenza \u003c 0) {\n      _colore='#FF0000';\n    }  \n  }  \n  return _colore\n}\n\nfunction ColoraRigaFG(_scadenza,_trxnum) {\n  _colore='';\n  if (_trxnum \u003e 0) {\n    if (_scadenza \u003e= 0 && _scadenza \u003c= this.gScadTrx.Value()) {\n      _colore='#000000';\n    }\n    if (_scadenza \u003c 0) {\n      _colore='#FFFFFF';\n    }\n  }  \n  return _colore\n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"TRANSAZIONI CON RILIEVI AUA\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"450","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"true","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"15","name":"SQLTRXAUA","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_wutrxchk_aua","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"8","y":"-58"},{"appendingData":"false","auto_exec":"true","count":"false","h":"20","localDBName":"","n_records":"1","name":"SQLTRXINSCAD","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_wutrxchk_inscad","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"1038","y":"-51"},{"appendingData":"false","auto_exec":"true","count":"false","h":"20","localDBName":"","n_records":"1","name":"SQLTRXSCADUTE","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_wutrxchk_scadute","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"140","y":"-59"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:BtnEdit()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fGIF\u002f005.gif:Premere per modificare la transazione\",\"fg_color\":\"\",\"width\":\"20\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"20\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:RTView\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fGIF\u002f113.gif:Premere per visualizzare la transazione\",\"fg_color\":\"\",\"width\":\"20\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"ID Transazione\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXCODPRG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"show_extra_title\":false,\"hidden\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXCODDIP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"MTCN\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXMTCN\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXDATOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Scadenza\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXSCAEDT\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Cognome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXCOGNOM\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXNOME\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Fiscale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXCODFIS\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Luogo di nascita\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXLUONAS\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Di Nascita\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXDATNAS\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Sesso\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXSESSO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Documento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXTIPDOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Numero Documento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXNUMDOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Rilievi\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXNUMRIL\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"User\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRXUTENTE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"show_extra_title\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"hidden\":true},{\"field\":\"fullname\",\"title\":\"Utente\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"GG. Scadenza\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%SCADENZA%','%TRXCODPRG%')\",\"newline\":false,\"field\":\"SCADENZA\",\"fg_color\":\"function:ColoraRigaFG('%SCADENZA%','%TRXCODPRG%')\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLTRXAUA","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":",,N,C,C,D,D,C,C,C,C,D,C,C,C,N,N,N","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"388","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grdOperazioni","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"RecordSelezionato","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"true","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"37","zindex":""},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_wutrxchk_aua_savedEntity","objsValues":"this.Rinfresca(evt)","page":"1","parmsNames":"evt","sequence":"5","type":"EventReceiver","w":"22","x":"464","y":"-59"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_wutrxchk_aua_discardedEntity","objsValues":"this.Rinfresca(evt)","page":"1","parmsNames":"evt","sequence":"6","type":"EventReceiver","w":"22","x":"507","y":"-57"},{"async":"false","entity_type":"master","h":"30","m_cAction":"edit","name":"RTEdit","offline":"false","page":"1","parms":"TRXCODPRG=idtrx","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"armt_wutrxchk_aua","target":"","type":"SPLinker","w":"30","x":"362","y":"-65"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","name":"RTView","offline":"false","page":"1","parms":"TRXCODPRG=idtrx","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"armt_wutrxchk_aua","target":"","type":"SPLinker","w":"30","x":"322","y":"-66"},{"alias":"TOTALE","dataobj":"SQLTRXAUA","descr":"Numero di transazioni Presenti","fields":"COUNT(*)","groupby_fields":"","h":"20","name":"SQLTotalizer12","page":"1","picture":"999,999,999.99","sequence":"9","type":"SQLTotalizer","w":"120","x":"639","y":"-60"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"SQLTotalizer12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TOTALE","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"9pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"trxtotali","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"10","tabindex":"","type":"Textbox","typevar":"numeric","visible":"true","w":"74","wireframe_props":"name","x":"325","y":"9","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"SQLTRXINSCAD","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TOTINSCAD","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"9pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"trxinscad","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typevar":"numeric","visible":"true","w":"55","wireframe_props":"name","x":"584","y":"9","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"SQLTRXSCADUTE","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"TOTSCADUTE","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"9pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"trxscadute","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"12","tabindex":"","type":"Textbox","typevar":"numeric","visible":"true","w":"55","wireframe_props":"name","x":"812","y":"9","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label14","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Transazioni da Elaborare:","w":"211","wireframe_props":"align,value,n_col","x":"109","y":"10","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label14_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Transazioni in scadenza:","w":"164","wireframe_props":"align,value,n_col","x":"414","y":"10","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label14_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Transazioni scadute:","w":"158","wireframe_props":"align,value,n_col","x":"649","y":"10","zindex":"1"},{"calculate":"","dataobj":"SQLTRXAUA","field":"TRXUTENTE","h":"20","init":"","init_par":"","name":"user","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"56","x":"952","y":"-56"},{"calculate":"","dataobj":"SQLTRXAUA","field":"TRXCODPRG","h":"20","init":"","init_par":"","name":"idtrx","page":"1","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"40","x":"905","y":"-56"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","name":"RTEditBlock","offline":"false","page":"1","parms":"pIDTrx=idtrx","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"arrt_wutrxchk_aua_edit","target":"","type":"SPLinker","w":"30","x":"411","y":"-69"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global int","name":"gScadTrx","page":"1","sequence":"19","server_side":"false","type":"Variable","typevar":"numeric","w":"70","x":"796","y":"-57"}]%>
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
window.pg_trxaua_Static=function(){
if(typeof BtnEdit !='undefined')this.BtnEdit=BtnEdit;
if(typeof Rinfresca !='undefined')this.Rinfresca=Rinfresca;
if(typeof ColoraRiga !='undefined')this.ColoraRiga=ColoraRiga;
if(typeof ColoraRigaFG !='undefined')this.ColoraRigaFG=ColoraRigaFG;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLTRXAUA.addRowConsumer(this.grdOperazioni);
this.SQLTRXAUA.addTotalizer({"alias":"TOTALE","descr":"Numero di transazioni Presenti","exp":"COUNT(*)","grp":"","orderby":"","picture":"999,999,999.99","provider":"SQLTotalizer12"});
this.SQLTotalizer12.addDataConsumer(this.trxtotali,<%=JSPLib.ToJSValue("TOTALE",true)%>);
this.SQLTRXINSCAD.addDataConsumer(this.trxinscad,<%=JSPLib.ToJSValue("TOTINSCAD",true)%>);
this.SQLTRXSCADUTE.addDataConsumer(this.trxscadute,<%=JSPLib.ToJSValue("TOTSCADUTE",true)%>);
this.SQLTRXAUA.addDataConsumer(this.user,<%=JSPLib.ToJSValue("TRXUTENTE",true)%>);
this.SQLTRXAUA.addDataConsumer(this.idtrx,<%=JSPLib.ToJSValue("TRXCODPRG",true)%>);
function BtnEdit() {
  _edit=this.RTEditBlock.Link()
  if(_edit==1) {
    this.RTEdit.Link()
  } else {
    alert('Impossibile lavorare una transazione già in carico ad un altro utente')
  }  
  this.SQLTRXAUA.Query()  
}  
function Rinfresca(_evt) {
  this.SQLTRXAUA.Query(true)    
  this.SQLTRXSCADUTE.Query()
  this.SQLTRXINSCAD.Query()
}  
function ColoraRiga(_scadenza,_trxnum) {
  _colore='';
  if (_trxnum > 0) {
    if (_scadenza >= 0 && _scadenza <= this.gScadTrx.Value()) {
      _colore='#FFFF00';
    }
    if (_scadenza < 0) {
      _colore='#FF0000';
    }  
  }  
  return _colore
}
function ColoraRigaFG(_scadenza,_trxnum) {
  _colore='';
  if (_trxnum > 0) {
    if (_scadenza >= 0 && _scadenza <= this.gScadTrx.Value()) {
      _colore='#000000';
    }
    if (_scadenza < 0) {
      _colore='#FFFFFF';
    }
  }  
  return _colore
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle("TRANSAZIONI CON RILIEVI AUA",true)
  this.getTitlePortlet().SetSubTitle("",true)
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
.pg_trxaua_container {
}
.pg_trxaua_title_container {
  margin: auto;
}
.pg_trxaua_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:450px;
  background-color:#FFFFFF;
}
.pg_trxaua_portlet[Data-page="1"]{
  height:450px;
  width:100%;
}
.pg_trxaua_portlet > .grdOperazioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:388px;
}
.pg_trxaua_portlet > .trxtotali_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:325px;
  width:74px;
  height:20px;
}
.pg_trxaua_portlet > .trxtotali_ctrl {
}
.pg_trxaua_portlet > .trxtotali_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:9pt;
  width:100%;
  height:100%;
}
.pg_trxaua_portlet > .trxinscad_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:584px;
  width:55px;
  height:20px;
}
.pg_trxaua_portlet > .trxinscad_ctrl {
}
.pg_trxaua_portlet > .trxinscad_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:9pt;
  width:100%;
  height:100%;
}
.pg_trxaua_portlet > .trxscadute_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:812px;
  width:55px;
  height:20px;
}
.pg_trxaua_portlet > .trxscadute_ctrl {
}
.pg_trxaua_portlet > .trxscadute_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:9pt;
  width:100%;
  height:100%;
}
.pg_trxaua_portlet > .label14_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:109px;
  width:211px;
  height:auto;
  min-height:19px;
}
.pg_trxaua_portlet > .label14_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trxaua_portlet > .label14_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_trxaua_portlet > .label14_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:414px;
  width:164px;
  height:auto;
  min-height:19px;
}
.pg_trxaua_portlet > .label14_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trxaua_portlet > .label14_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_trxaua_portlet > .label14_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:649px;
  width:158px;
  height:auto;
  min-height:19px;
}
.pg_trxaua_portlet > .label14_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trxaua_portlet > .label14_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
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
 String def="[{\"h\":\"450\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"8\",\"y\":\"-58\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1038\",\"y\":\"-51\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"140\",\"y\":\"-59\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"\"},{\"title\":\"ID Transazione\"},{\"title\":\"Agenzia\"},{\"title\":\"MTCN\"},{\"title\":\"Data Operazione\"},{\"title\":\"Scadenza\"},{\"title\":\"Cognome\"},{\"title\":\"Nome\"},{\"title\":\"Codice Fiscale\"},{\"title\":\"Luogo di nascita\"},{\"title\":\"Data Di Nascita\"},{\"title\":\"Sesso\"},{\"title\":\"Tipo Documento\"},{\"title\":\"Numero Documento\"},{\"title\":\"Rilievi\"},{\"title\":\"User\"},{\"title\":\"Utente\"},{\"title\":\"GG. Scadenza\"}],\"h\":\"388\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"37\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"464\",\"y\":\"-59\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"507\",\"y\":\"-57\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"362\",\"y\":\"-65\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"322\",\"y\":\"-66\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLTotalizer\",\"w\":\"120\",\"x\":\"639\",\"y\":\"-60\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trxtotali\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"74\",\"x\":\"325\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trxinscad\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"55\",\"x\":\"584\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trxscadute\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"55\",\"x\":\"812\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label14\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Transazioni da Elaborare:\",\"w\":\"211\",\"x\":\"109\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label14_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Transazioni in scadenza:\",\"w\":\"164\",\"x\":\"414\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label14_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Transazioni scadute:\",\"w\":\"158\",\"x\":\"649\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"user\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"56\",\"x\":\"952\",\"y\":\"-56\"},{\"h\":\"20\",\"name\":\"idtrx\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"40\",\"x\":\"905\",\"y\":\"-56\"},{\"h\":\"30\",\"name\":\"RTEditBlock\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"411\",\"y\":\"-69\"},{\"h\":\"20\",\"name\":\"gScadTrx\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"796\",\"y\":\"-57\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_trxaua","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_trxaua_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_trxaua','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_trxaua_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%double trxtotali= 0;
if(request.getAttribute("pg_trxaua_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
double trxinscad= 0;
double trxscadute= 0;
String label14= "Transazioni da Elaborare:";
String label14_Copy= "Transazioni in scadenza:";
String label14_Copy_Copy= "Transazioni scadute:";
String user= "";
String idtrx= "";
double gScadTrx=sp.getGlobal("gScadTrx",1);
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_trxaua_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_trxaua_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_trxaua_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_trxaua','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grdOperazioni' formid='<%=idPortlet%>' ps-name='grdOperazioni'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_trxtotali_wrp'><input id='<%=idPortlet%>_trxtotali' name='trxtotali' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='trxtotali' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_trxinscad_wrp'><input id='<%=idPortlet%>_trxinscad' name='trxinscad' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='trxinscad' inputmode='numeric' /></span>
<span class='textbox-container'id='<%=idPortlet%>_trxscadute_wrp'><input id='<%=idPortlet%>_trxscadute' name='trxscadute' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='trxscadute' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_label14'  formid='<%=idPortlet%>' ps-name='label14'    class='label label14_ctrl'><div id='<%=idPortlet%>_label14tbl' style='width:100%;'><%=JSPLib.ToHTML("Transazioni da Elaborare:")%></div></span>
<span id='<%=idPortlet%>_label14_Copy'  formid='<%=idPortlet%>' ps-name='label14_Copy'    class='label label14_Copy_ctrl'><div id='<%=idPortlet%>_label14_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Transazioni in scadenza:")%></div></span>
<span id='<%=idPortlet%>_label14_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label14_Copy_Copy'    class='label label14_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label14_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Transazioni scadute:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_trxaua');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_trxaua',["1024"],["450"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},true,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"450","title":"","layer":"false","npage":"1"}]);
this.SQLTRXAUA=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_wutrxchk_aua","cmdHash":"<%=JSPLib.cmdHash("qbe_wutrxchk_aua",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLTRXAUA","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLTRXAUA","nrows":"15","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":8,"y":-58});
this.SQLTRXINSCAD=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_wutrxchk_inscad","cmdHash":"<%=JSPLib.cmdHash("qbe_wutrxchk_inscad",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLTRXINSCAD","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLTRXINSCAD","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":1038,"y":-51});
this.SQLTRXSCADUTE=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_wutrxchk_scadute","cmdHash":"<%=JSPLib.cmdHash("qbe_wutrxchk_scadute",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLTRXSCADUTE","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLTRXSCADUTE","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":140,"y":-59});
this.grdOperazioni=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdOperazioni","dataobj":"SQLTRXAUA","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":388,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grdOperazioni","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"RecordSelezionato","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":true,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":37,"zindex":""});
this.grdOperazioni.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","font_weight":"","orderby_field":"","col_class":"","font_size":"","link":"function:BtnEdit()","fixedwidth":"20","title":"","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"image:..\u002fimages\u002fGIF\u002f005.gif:Premere per modificare la transazione","droppable_name":"","fg_color":"","width":"20","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:RTView","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fGIF\u002f113.gif:Premere per visualizzare la transazione","fg_color":"","width":"20","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID Transazione","type":"N","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","show_extra_title":false,"enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TRXCODPRG","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXCODDIP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"MTCN","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXMTCN","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXDATOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Scadenza","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXSCAEDT","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Cognome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXCOGNOM","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXNOME","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Fiscale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXCODFIS","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Luogo di nascita","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXLUONAS","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Di Nascita","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXDATNAS","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Sesso","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXSESSO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Documento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXTIPDOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Numero Documento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXNUMDOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Rilievi","type":"N","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRXNUMRIL","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"User","type":"N","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"show_extra_title":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TRXUTENTE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Utente","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"fullname","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"GG. Scadenza","type":"N","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%SCADENZA%','%TRXCODPRG%')","field":"SCADENZA","droppable_name":"","fg_color":"function:ColoraRigaFG('%SCADENZA%','%TRXCODPRG%')","width":"","RowSpan":0,"font_family":""}]});
this.armt_wutrxchk_aua_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_wutrxchk_aua_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_wutrxchk_aua_savedEntity","objsValues":"this.Rinfresca(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":22,"x":464,"y":-59});
this.armt_wutrxchk_aua_discardedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_wutrxchk_aua_discardedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_wutrxchk_aua_discardedEntity","objsValues":"this.Rinfresca(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":22,"x":507,"y":-57});
this.RTEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEdit","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEdit","offline":false,"page":1,"parms":"TRXCODPRG=idtrx","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_wutrxchk_aua","target":"","type":"SPLinker","w":30,"x":362,"y":-65});
this.RTEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_wutrxchk_aua",request.getSession())%>';
this.RTView=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTView","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTView","offline":false,"page":1,"parms":"TRXCODPRG=idtrx","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_wutrxchk_aua","target":"","type":"SPLinker","w":30,"x":322,"y":-66});
this.RTView.m_cID='<%=JSPLib.cmdHash("entity,armt_wutrxchk_aua",request.getSession())%>';
this.SQLTotalizer12=new ZtVWeb.SQLDataProvider(this, { name: 'SQLTotalizer12', nrows: 1000, fieldstype: 'true', count: 'false', async: false });
this.trxtotali=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_trxtotali","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TOTALE","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"trxtotali","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=trxtotali%>","w":74,"x":325,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.trxinscad=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_trxinscad","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TOTINSCAD","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"trxinscad","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=trxinscad%>","w":55,"x":584,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.trxscadute=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_trxscadute","decrypt":false,"edit_undercond":"","encrypt":false,"field":"TOTSCADUTE","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"trxscadute","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=trxscadute%>","w":55,"x":812,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.label14=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label14","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label14","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label14,false,true)%>","type":"Label","w":211,"x":109,"y":10,"zindex":"1"});
this.label14_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label14_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label14_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label14_Copy,false,true)%>","type":"Label","w":164,"x":414,"y":10,"zindex":"1"});
this.label14_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label14_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label14_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label14_Copy_Copy,false,true)%>","type":"Label","w":158,"x":649,"y":10,"zindex":"1"});
this.user=new ZtVWeb._VC(this,'user',null,'character','<%=JSPLib.ToJSValue(user,false,true)%>',false,false);
this.idtrx=new ZtVWeb._VC(this,'idtrx',null,'character','<%=JSPLib.ToJSValue(idtrx,false,true)%>',false,false);
this.RTEditBlock=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEditBlock","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEditBlock","offline":false,"page":1,"parms":"pIDTrx=idtrx","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_wutrxchk_aua_edit","target":"","type":"SPLinker","w":30,"x":411,"y":-69});
this.RTEditBlock.m_cID='<%=JSPLib.cmdHash("routine,arrt_wutrxchk_aua_edit",request.getSession())%>';
this.gScadTrx=new ZtVWeb._VC(this,'gScadTrx',null,'numeric',<%=gScadTrx%>,false,false);
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
<%if(request.getAttribute("pg_trxaua_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_trxaua_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_trxaua_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_armt_wutrxchk_aua_savedEntity=function(parmsObj){<%=idPortlet%>.armt_wutrxchk_aua_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_wutrxchk_aua_discardedEntity=function(parmsObj){<%=idPortlet%>.armt_wutrxchk_aua_discardedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLTRXAUA.firstQuery('true');
window.<%=idPortlet%>.SQLTRXINSCAD.firstQuery('true');
window.<%=idPortlet%>.SQLTRXSCADUTE.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_trxaua',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_trxaua');
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
sp.endPage("pg_trxaua");
}%>
<%! public String getJSPUID() { return "656537982"; } %>