<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Manutenzione autocorrezioni\",true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Filtro\",\n    title:FormatMsg('Filtra'),\n    tooltip:FormatMsg('Filtra i dati in base ai parametri'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xea19;\"},\n    action:'javascript:' + this.formid +'.Filtra()'\n },1);    \n  this.getTitlePortlet().AppendButton({\n    id:\"Cancella\",\n    title:FormatMsg('Cancella'),\n    tooltip:FormatMsg('Cancella i record selezionati'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe9a3;\"},\n    action:'javascript:' + this.formid +'.Cancella()'\n },2);      \n}\n\nfunction Filtra() {\n  this.SQLAutocorrect.Query()\n  this.Grid1.Refresh()\n}  \n\nfunction Cancella() {\n  if(confirm(\"Confermi la cancellazione dei record selezionati?\")) {\n    this.mcSelezionati.Value(this.Grid1.GetSelectedDataAsTrsString())\n    this.SPDelete.Link()\n  }  \n}  \n\nfunction SPDelete_Executed(result,cError){\n  if(result=='OK') {\n    alert(\"Cancellazione effettuata con successo\")\n    this.Filtra()\n  } else {\n    alert(cError)\n  }  \n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"576","hsl":"","htmlcode":"\n{{ @Label6_Copy_Copy_Copy }}\n{{ @numdoc }}\n{{ @Label5_Copy_Copy_Copy }}\n{{ @tipodoc }}\n{{ @Label5_Copy_Copy }}\n{{ @codfisc }}\n{{ @Label6_Copy_Copy }}\n{{ @datanascita }}\n{{ @Label6_Copy }}\n{{ @cmbSesso }}\n\n{{ @Label5_Copy }}\n{{ @luogonascita }}\n{{ @Label6 }}\n{{ @Label5 }}\n{{ @nome }}\n{{ @cognome }}\n\n{{ @Grid1 }}\n\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"1024","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"IDPROG","colProperties":"[{\"field\":\"AUTIPDOC\",\"title\":\"Tipo Documento\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"AUNUMDOC\",\"title\":\"Numero Documento\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"AUCOGNOM\",\"title\":\"Cognome\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"AUNOME\",\"title\":\"Nome\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"AULUONAS\",\"title\":\"Luogo di nascita\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"AUDATNAS\",\"title\":\"Data Di Nascita\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"D\",\"title_align\":\"\"},{\"field\":\"AUSESSO\",\"title\":\"Sesso\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"AUCODFISC\",\"title\":\"Codice Fiscale\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLAutocorrect","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"435","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid1","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"99","zindex":"1"},{"allowedqueries":"qbe_wuautocorrect","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"15","name":"SQLAutocorrect","offline":"false","page":"1","parms":"pAUOCOGNOM=cognome,pAUONOME=nome,pAUOLUONAS=luogonascita,pAUODATNAS=datanascita,pAUOSESSO=cmbSesso,pAUOTIPDOC=tipodoc,pAUONUMDOC=numdoc,pAUOCODFISC=codfisc","parms_source":"","query":"qbe_wuautocorrect","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"1073","y":"-68"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"50","name":"cognome","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"142","y":"7","zerofilling":"false","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"50","name":"nome","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"388","wireframe_props":"name","x":"627","y":"7","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label5","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Cognome:","w":"106","wireframe_props":"align,value,n_col","x":"33","y":"7","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nome:","w":"83","wireframe_props":"align,value,n_col","x":"542","y":"7","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"50","name":"luogonascita","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"142","y":"36","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label5_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Luogo di Nascita:","w":"132","wireframe_props":"align,value,n_col","x":"7","y":"36","zindex":"3"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"cmbSesso","page":"1","picture":"","sequence":"9","spuid":"","tabindex":"","textlist":"Maschio,Femmina","type":"Combobox","typevar":"character","valuelist":"M,F","visible":"true","w":"120","wireframe_props":"name,textlist","x":"627","y":"36","zindex":"5"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Sesso:","w":"83","wireframe_props":"align,value,n_col","x":"542","y":"36","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"datanascita","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"135","wireframe_props":"name","x":"880","y":"36","zerofilling":"false","zindex":"6"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data di nascita:","w":"115","wireframe_props":"align,value,n_col","x":"761","y":"36","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"codfisc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"142","wireframe_props":"name","x":"142","y":"65","zerofilling":"false","zindex":"7"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label5_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice Fiscale:","w":"132","wireframe_props":"align,value,n_col","x":"7","y":"65","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"2","name":"tipodoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"33","wireframe_props":"name","x":"627","y":"65","zerofilling":"false","zindex":"8"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label5_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Documento:","w":"132","wireframe_props":"align,value,n_col","x":"493","y":"65","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"numdoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"17","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"135","wireframe_props":"name","x":"880","y":"65","zerofilling":"false","zindex":"9"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label6_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":" Numero Documento","w":"147","wireframe_props":"align,value,n_col","x":"729","y":"66","zindex":"4"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"mcSelezionati","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1077","y":"-39"},{"allowedentities":"arfn_wuautocorrect_maintenance","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPDelete","offline":"false","page":"1","parms":"mcRecord=mcSelezionati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"20","servlet":"arfn_wuautocorrect_maintenance","target":"","type":"SPLinker","w":"120","x":"1090","y":"-8"}]%>
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
window.pg_wuautocorrect_maintenance_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Filtra !='undefined')this.Filtra=Filtra;
if(typeof Cancella !='undefined')this.Cancella=Cancella;
if(typeof SPDelete_Executed !='undefined')this.SPDelete_Executed=SPDelete_Executed;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLAutocorrect.addRowConsumer(this.Grid1);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Manutenzione autocorrezioni",true)
  this.getTitlePortlet().AppendButton({
    id:"Filtro",
    title:FormatMsg('Filtra'),
    tooltip:FormatMsg('Filtra i dati in base ai parametri'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xea19;"},
    action:'javascript:' + this.formid +'.Filtra()'
 },1);    
  this.getTitlePortlet().AppendButton({
    id:"Cancella",
    title:FormatMsg('Cancella'),
    tooltip:FormatMsg('Cancella i record selezionati'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe9a3;"},
    action:'javascript:' + this.formid +'.Cancella()'
 },2);      
}
function Filtra() {
  this.SQLAutocorrect.Query()
  this.Grid1.Refresh()
}  
function Cancella() {
  if(confirm("Confermi la cancellazione dei record selezionati?")) {
    this.mcSelezionati.Value(this.Grid1.GetSelectedDataAsTrsString())
    this.SPDelete.Link()
  }  
}  
function SPDelete_Executed(result,cError){
  if(result=='OK') {
    alert("Cancellazione effettuata con successo")
    this.Filtra()
  } else {
    alert(cError)
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
.pg_wuautocorrect_maintenance_container {
}
.pg_wuautocorrect_maintenance_title_container {
  margin: auto;
}
.pg_wuautocorrect_maintenance_portlet{
  position:relative;
  margin: auto;
  width:1024px;
  min-width:1024px;
  height:576px;
}
.pg_wuautocorrect_maintenance_portlet[Data-page="1"]{
  height:576px;
  width:1024px;
}
.pg_wuautocorrect_maintenance_portlet > .Grid1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:99px;
  left:0px;
  right:0px;
  width:1024px;
  height:auto;
  min-height:435px;
}
.pg_wuautocorrect_maintenance_portlet > .cognome_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:7px;
  left:142px;
  width:375px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .cognome_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .cognome_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .nome_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:7px;
  left:627px;
  width:388px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .nome_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .nome_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:7px;
  left:33px;
  width:106px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:7px;
  left:542px;
  width:83px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .luogonascita_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:36px;
  left:142px;
  width:375px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .luogonascita_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .luogonascita_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:36px;
  left:7px;
  width:132px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .cmbSesso_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:36px;
  left:627px;
  width:120px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:36px;
  left:542px;
  width:83px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .datanascita_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:36px;
  left:880px;
  width:135px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .datanascita_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .datanascita_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:36px;
  left:761px;
  width:115px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .codfisc_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:65px;
  left:142px;
  width:142px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .codfisc_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .codfisc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:65px;
  left:7px;
  width:132px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .tipodoc_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:65px;
  left:627px;
  width:33px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .tipodoc_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .tipodoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:65px;
  left:493px;
  width:132px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label5_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wuautocorrect_maintenance_portlet > .numdoc_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:65px;
  left:880px;
  width:135px;
  height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .numdoc_ctrl {
}
.pg_wuautocorrect_maintenance_portlet > .numdoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:66px;
  left:729px;
  width:147px;
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wuautocorrect_maintenance_portlet > .Label6_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
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
 String def="[{\"h\":\"576\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"1024\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Tipo Documento\"},{\"title\":\"Numero Documento\"},{\"title\":\"Cognome\"},{\"title\":\"Nome\"},{\"title\":\"Luogo di nascita\"},{\"title\":\"Data Di Nascita\"},{\"title\":\"Sesso\"},{\"title\":\"Codice Fiscale\"}],\"h\":\"435\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"99\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1073\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cognome\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"142\",\"y\":\"7\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nome\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"388\",\"x\":\"627\",\"y\":\"7\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label5\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":\"106\",\"x\":\"33\",\"y\":\"7\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome:\",\"w\":\"83\",\"x\":\"542\",\"y\":\"7\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"luogonascita\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"142\",\"y\":\"36\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label5_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Luogo di Nascita:\",\"w\":\"132\",\"x\":\"7\",\"y\":\"36\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbSesso\",\"page\":\"1\",\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"w\":\"120\",\"x\":\"627\",\"y\":\"36\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":\"83\",\"x\":\"542\",\"y\":\"36\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"datanascita\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"135\",\"x\":\"880\",\"y\":\"36\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data di nascita:\",\"w\":\"115\",\"x\":\"761\",\"y\":\"36\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codfisc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"142\",\"x\":\"142\",\"y\":\"65\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label5_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":\"132\",\"x\":\"7\",\"y\":\"65\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipodoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"33\",\"x\":\"627\",\"y\":\"65\",\"zindex\":\"8\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label5_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":\"132\",\"x\":\"493\",\"y\":\"65\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"numdoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"135\",\"x\":\"880\",\"y\":\"65\",\"zindex\":\"9\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label6_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Numero Documento\",\"w\":\"147\",\"x\":\"729\",\"y\":\"66\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"mcSelezionati\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1077\",\"y\":\"-39\"},{\"h\":\"20\",\"name\":\"SPDelete\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1090\",\"y\":\"-8\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_wuautocorrect_maintenance","UTF-8")) {return; }
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
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_wuautocorrect_maintenance_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_wuautocorrect_maintenance','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_wuautocorrect_maintenance_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String cognome= "";
if(request.getAttribute("pg_wuautocorrect_maintenance_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String nome= "";
String Label5= "Cognome:";
String Label6= "Nome:";
String luogonascita= "";
String Label5_Copy= "Luogo di Nascita:";
String cmbSesso= "";
String Label6_Copy= "Sesso:";
java.sql.Date datanascita= JSPLib.NullDate();
String Label6_Copy_Copy= "Data di nascita:";
String codfisc= "";
String Label5_Copy_Copy= "Codice Fiscale:";
String tipodoc= "";
String Label5_Copy_Copy_Copy= "Tipo Documento:";
String numdoc= "";
String Label6_Copy_Copy_Copy= " Numero Documento";
String mcSelezionati= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_wuautocorrect_maintenance_title_container' style='width:1024px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_wuautocorrect_maintenance_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_wuautocorrect_maintenance_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_wuautocorrect_maintenance','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid1' formid='<%=idPortlet%>' ps-name='Grid1'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_cognome_wrp'><input id='<%=idPortlet%>_cognome' name='cognome' type='text' maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='cognome' /></span>
<span class='textbox-container'id='<%=idPortlet%>_nome_wrp'><input id='<%=idPortlet%>_nome' name='nome' type='text' maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='nome' /></span>
<span id='<%=idPortlet%>_Label5'  formid='<%=idPortlet%>' ps-name='Label5'    class='label Label5_ctrl'><div id='<%=idPortlet%>_Label5tbl' style='width:100%;'><%=JSPLib.ToHTML("Cognome:")%></div></span>
<span id='<%=idPortlet%>_Label6'  formid='<%=idPortlet%>' ps-name='Label6'    class='label Label6_ctrl'><div id='<%=idPortlet%>_Label6tbl' style='width:100%;'><%=JSPLib.ToHTML("Nome:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_luogonascita_wrp'><input id='<%=idPortlet%>_luogonascita' name='luogonascita' type='text' maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='luogonascita' /></span>
<span id='<%=idPortlet%>_Label5_Copy'  formid='<%=idPortlet%>' ps-name='Label5_Copy'    class='label Label5_Copy_ctrl'><div id='<%=idPortlet%>_Label5_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Luogo di Nascita:")%></div></span>
<select id='<%=idPortlet%>_cmbSesso' name='cmbSesso' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label6_Copy'  formid='<%=idPortlet%>' ps-name='Label6_Copy'    class='label Label6_Copy_ctrl'><div id='<%=idPortlet%>_Label6_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Sesso:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_datanascita_wrp'><input id='<%=idPortlet%>_datanascita' name='datanascita' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='datanascita' /></span>
<span id='<%=idPortlet%>_Label6_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label6_Copy_Copy'    class='label Label6_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label6_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Data di nascita:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_codfisc_wrp'><input id='<%=idPortlet%>_codfisc' name='codfisc' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='codfisc' /></span>
<span id='<%=idPortlet%>_Label5_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label5_Copy_Copy'    class='label Label5_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label5_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Fiscale:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_tipodoc_wrp'><input id='<%=idPortlet%>_tipodoc' name='tipodoc' type='text' maxlength='2' class='textbox' formid='<%=idPortlet%>' ps-name='tipodoc' /></span>
<span id='<%=idPortlet%>_Label5_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label5_Copy_Copy_Copy'    class='label Label5_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label5_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Documento:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_numdoc_wrp'><input id='<%=idPortlet%>_numdoc' name='numdoc' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='numdoc' /></span>
<span id='<%=idPortlet%>_Label6_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label6_Copy_Copy_Copy'    class='label Label6_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label6_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML(" Numero Documento")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_wuautocorrect_maintenance');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Cancella",true)+","+JSPLib.ToJSValue(sp.translate("Cancella"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Cancella i record selezionati",true)+","+JSPLib.ToJSValue(sp.translate("Cancella i record selezionati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Filtra",true)+","+JSPLib.ToJSValue(sp.translate("Filtra"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Filtra i dati in base ai parametri",true)+","+JSPLib.ToJSValue(sp.translate("Filtra i dati in base ai parametri"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_wuautocorrect_maintenance',["1024"],["576"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"576","title":"","layer":"false","npage":"1"}]);
this.Grid1=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"IDPROG","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid1","dataobj":"SQLAutocorrect","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":435,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid1","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":99,"zindex":"1"});
this.Grid1.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Documento","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUTIPDOC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Numero Documento","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUNUMDOC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Cognome","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUCOGNOM","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Nome","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUNOME","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Luogo di nascita","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AULUONAS","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Di Nascita","align":"","type":"D","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUDATNAS","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Sesso","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUSESSO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Fiscale","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"AUCODFISC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.SQLAutocorrect=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_wuautocorrect",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_wuautocorrect","cmdHash":"<%=JSPLib.cmdHash("qbe_wuautocorrect",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLAutocorrect","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLAutocorrect","nrows":"15","page":1,"parms":"pAUOCOGNOM=cognome,pAUONOME=nome,pAUOLUONAS=luogonascita,pAUODATNAS=datanascita,pAUOSESSO=cmbSesso,pAUOTIPDOC=tipodoc,pAUONUMDOC=numdoc,pAUOCODFISC=codfisc","parms_source":"","type":"SQLDataobj","w":120,"x":1073,"y":-68});
this.cognome=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_cognome","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"cognome","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(cognome,false,true)%>","w":375,"x":142,"y":7,"zerofilling":false,"zindex":"2","zoom":""});
this.nome=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nome","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"nome","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nome,false,true)%>","w":388,"x":627,"y":7,"zerofilling":false,"zindex":"2","zoom":""});
this.Label5=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label5","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label5,false,true)%>","type":"Label","w":106,"x":33,"y":7,"zindex":"3"});
this.Label6=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6,false,true)%>","type":"Label","w":83,"x":542,"y":7,"zindex":"4"});
this.luogonascita=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_luogonascita","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"luogonascita","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(luogonascita,false,true)%>","w":375,"x":142,"y":36,"zerofilling":false,"zindex":"2","zoom":""});
this.Label5_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label5_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label5_Copy,false,true)%>","type":"Label","w":132,"x":7,"y":36,"zindex":"3"});
this.cmbSesso=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbSesso","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbSesso%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbSesso","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Maschio,Femmina","type":"Combobox","typevar":"character","valuelist":"M,F","visible":true,"w":120,"x":627,"y":36,"zindex":"5"});
this.Label6_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6_Copy,false,true)%>","type":"Label","w":83,"x":542,"y":36,"zindex":"4"});
this.datanascita=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_datanascita","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"datanascita","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=datanascita%>","w":135,"x":880,"y":36,"zerofilling":false,"zindex":"6","zoom":""});
this.Label6_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6_Copy_Copy,false,true)%>","type":"Label","w":115,"x":761,"y":36,"zindex":"4"});
this.codfisc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codfisc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"codfisc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codfisc,false,true)%>","w":142,"x":142,"y":65,"zerofilling":false,"zindex":"7","zoom":""});
this.Label5_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label5_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label5_Copy_Copy,false,true)%>","type":"Label","w":132,"x":7,"y":65,"zindex":"3"});
this.tipodoc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_tipodoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"2","name":"tipodoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tipodoc,false,true)%>","w":33,"x":627,"y":65,"zerofilling":false,"zindex":"8","zoom":""});
this.Label5_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label5_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label5_Copy_Copy_Copy,false,true)%>","type":"Label","w":132,"x":493,"y":65,"zindex":"3"});
this.numdoc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_numdoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"numdoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(numdoc,false,true)%>","w":135,"x":880,"y":65,"zerofilling":false,"zindex":"9","zoom":""});
this.Label6_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label6_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label6_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label6_Copy_Copy_Copy,false,true)%>","type":"Label","w":147,"x":729,"y":66,"zindex":"4"});
this.mcSelezionati=new ZtVWeb._VC(this,'mcSelezionati',null,'character','<%=JSPLib.ToJSValue(mcSelezionati,false,true)%>',false,false);
this.SPDelete=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_wuautocorrect_maintenance",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPDelete","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPDelete","offline":false,"page":1,"parms":"mcRecord=mcSelezionati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_wuautocorrect_maintenance","target":"","type":"SPLinker","w":120,"x":1090,"y":-8});
this.SPDelete.m_cID='<%=JSPLib.cmdHash("routine,arfn_wuautocorrect_maintenance",request.getSession())%>';
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
<%if(request.getAttribute("pg_wuautocorrect_maintenance_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_wuautocorrect_maintenance_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_wuautocorrect_maintenance_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLAutocorrect.firstQuery('true');
window.<%=idPortlet%>.cmbSesso.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_wuautocorrect_maintenance',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_wuautocorrect_maintenance');
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
sp.endPage("pg_wuautocorrect_maintenance");
}%>
<%! public String getJSPUID() { return "343821218"; } %>