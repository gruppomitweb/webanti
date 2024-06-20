<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Storico Operazioni\",true)\n}\n\nfunction LanciaView() {\n  this.CreaDir.Link()\n  this.OpeEdit.Link()\n}  \n\nfunction BtnEsci_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.Uscita.Link();\n  }\n}  \n\nfunction CalcSemaforo(_flgdoc) {\n  _ritorno=''\n  if (_flgdoc=='S') {\n    _ritorno=\"\u003cimg src='..\u002fimages\u002fGIF\u002f092.gif'\"+' alt=\"ok\" \u002f\u003e'\n  }\n  if (_flgdoc=='N') {\n    _ritorno=\"\u003cimg src='..\u002fimages\u002fGIF\u002f093.gif'\"+' alt=\"ko\" \u002f\u003e'    \n  }    \n  if (_flgdoc=='X') {\n    _ritorno=\"\u003cimg src='..\u002fimages\u002fGIF\u002f091.gif'\"+' alt=\"ne\" \u002f\u003e'    \n  }      \n  return _ritorno\n}  \n\nfunction CalcSblocco(_flgulk) {\n  _ritorno=''\n  if (_flgulk=='S') {\n    _ritorno=\"\u003cimg src='..\u002fimages\u002fGIF\u002f069.gif'\"+' alt=\"ok\" \u002f\u003e'\n  } else {\n    _ritorno=\"\u003cimg src='..\u002fimages\u002fGIF\u002f068.gif'\"+' alt=\"ko\" \u002f\u003e'    \n  }    \n  return _ritorno\n}  \n\nfunction RefreshView() {\n  this.Query1.Query();\n  this.Grid0.Refresh();\n}  \n\nfunction StampaModulo() {\n  if (confirm('Confermi la stampa del modulo?')) {\n    if (this.gStpDwn.Value()=='N') {\n      this.PrintRegWin.Link()\n    } else {\n      this.PrintReg.Link()      \n    }  \n  }  \n}  \n\nfunction DescTipReg(_tipo) {\n  ritorno='';\n  if (_tipo=='G') {\n    ritorno='Giocata'\n  }\n  if (_tipo=='V') {\n    ritorno='Vincita'\n  }\n  if (_tipo=='P') {\n    ritorno='Prelievo'\n  }\n  if (_tipo=='R') {\n    ritorno='Versamento'\n  }\n  return ritorno;\n}  \n\nfunction Sblocca(_flgunl) {\n  if (_flgunl=='N') {\n    if (confirm(\"Confermi lo sblocco dell'operazione?\")) {\n      _result=this.RTSblocco.Link()\n      if (_result==\"OK\") {\n        alert(\"Sblocco operazione avvenuta correttamente\")\n        this.RefreshView()\n      } else {\n        alert(\"Errore durante l'operazione di sblocco. Contattare assistenza!\")\n      }  \n    }    \n  }  \n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @BtnEsci }} \n{{ @w_snainumope }} \n{{ @Grid0 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Storico Operazioni Agenzie","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"D\",\"align\":\"center\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"center\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:LanciaView()\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODDIPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DESCRIZ\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Completamento\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CGODATFINCOM\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Gioco\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DESTPGIO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Registrazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAFLGOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"N\",\"align\":\"center\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"center\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Segno\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SEGNO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Stato Doc.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"FLGDOCALL\",\"fg_color\":\"\",\"width\":\"80\",\"RowSpan\":0,\"extensible\":false},{\"field\":\"NUMSBLOCCO\",\"title\":\"Sblocchi\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"center\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"center\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":true,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"function:CalcSemaforo('%FLGDOCALL%')\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:StampaModulo()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fprinter_ico.gif:Stampa il modulo di adeguata verifica\",\"fg_color\":\"\",\"width\":\"10\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Premere per la stampa del modulo di adeguata verifica\"},{\"field\":\"function:CalcSblocco('%FLGSBLOCCO%')\",\"title\":\"\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"function:Sblocca('%FLGSBLOCCO%')\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"Premere il lucchetto per sbloccare l'operazione\",\"type\":\"C\",\"title_align\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,C,C,D,C,C,N,C,C,,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":22,\"w\":\"320\",\"h\":528,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":22,\"w\":\"480\",\"h\":528,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":42,\"w\":768,\"h\":528,\"anchor\":\"top-left-right\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"true","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"42","zindex":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_OrderBy=OrderBy","parms_source":"","query":"qbe_cgo_operazioni_admin_storico","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"-3","y":"-65"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"SNAINUMOPE","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":263,\"y\":-32,\"w\":\"146\",\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":263,\"y\":-32,\"w\":\"146\",\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":37,\"y\":13,\"w\":146,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":263,\"y\":-32,\"w\":\"146\",\"h\":22,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"w_snainumope","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"146","wireframe_props":"name","x":"37","y":"13","zerofilling":"false","zindex":"1"},{"allowedentities":"armt_snai_oper_storico","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"OpeEdit","offline":"false","page":"1","parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"4","servlet":"armt_snai_oper_storico","target":"","type":"SPLinker","w":"112","x":"777","y":"36"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"428","y":"-65"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gStpDwn","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"585","y":"-65"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"30","m_cAction":"","name":"Uscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"112","x":"778","y":"-34"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"PrintReg","offline":"false","page":"1","parms":"w_SNAINUMOPE=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"arrt_cgo_moduli_storico","target":"","type":"SPLinker","w":"113","x":"777","y":"70"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"PrintRegWin","offline":"false","page":"1","parms":"w_SNAINUMOPE=w_snainumope","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arrt_cgo_moduli_storico","target":"","type":"SPLinker","w":"114","x":"779","y":"-1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":" &#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":291,\"y\":0,\"w\":\"25\",\"h\":25,\"anchor\":\"top-right\",\"hide\":\"false\"},\"480\":{\"x\":451,\"y\":0,\"w\":\"25\",\"h\":25,\"anchor\":\"top-right\",\"hide\":\"false\"},\"768\":{\"x\":732,\"y\":6,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":995,\"y\":0,\"w\":\"25\",\"h\":25,\"anchor\":\"top-right\",\"hide\":\"false\"}}","name":"BtnEsci","page":"1","path_type":"","sequence":"10","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"732","y":"6","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"34","included":"true","name":"allegatiRefresh","objsValues":"this.RefreshView()","page":"1","parmsNames":"","sequence":"11","type":"EventReceiver","w":"164","x":"915","y":"-63"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTSblocco","offline":"false","page":"1","parms":"pCodice=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arfn_cgo_sblocco","target":"","type":"SPLinker","w":"112","x":"777","y":"105"},{"calculate":"'DATAOPE desc'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"OrderBy","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"165","y":"-64"},{"allowedentities":"arfn_snai_oper_storico","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"CreaDir","offline":"false","page":"1","parms":"pID=w_snainumope","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"14","servlet":"arfn_snai_oper_storico","target":"","type":"SPLinker","w":"112","x":"778","y":"137"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"34","included":"false","name":"armt_snai_oper_storico_savedEntity","objsValues":"this.RefreshView()","page":"1","parmsNames":"","sequence":"15","type":"EventReceiver","w":"164","x":"913","y":"-19"}]%>
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
window.pg_cgo_operazioni_storico_adm_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LanciaView !='undefined')this.LanciaView=LanciaView;
if(typeof BtnEsci_Click !='undefined')this.BtnEsci_Click=BtnEsci_Click;
if(typeof CalcSemaforo !='undefined')this.CalcSemaforo=CalcSemaforo;
if(typeof CalcSblocco !='undefined')this.CalcSblocco=CalcSblocco;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
if(typeof StampaModulo !='undefined')this.StampaModulo=StampaModulo;
if(typeof DescTipReg !='undefined')this.DescTipReg=DescTipReg;
if(typeof Sblocca !='undefined')this.Sblocca=Sblocca;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('DATAOPE desc',this.OrderBy);
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.w_snainumope,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Storico Operazioni",true)
}
function LanciaView() {
  this.CreaDir.Link()
  this.OpeEdit.Link()
}  
function BtnEsci_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.Uscita.Link();
  }
}  
function CalcSemaforo(_flgdoc) {
  _ritorno=''
  if (_flgdoc=='S') {
    _ritorno="<img src='../images/GIF/092.gif'"+' alt="ok" />'
  }
  if (_flgdoc=='N') {
    _ritorno="<img src='../images/GIF/093.gif'"+' alt="ko" />'    
  }    
  if (_flgdoc=='X') {
    _ritorno="<img src='../images/GIF/091.gif'"+' alt="ne" />'    
  }      
  return _ritorno
}  
function CalcSblocco(_flgulk) {
  _ritorno=''
  if (_flgulk=='S') {
    _ritorno="<img src='../images/GIF/069.gif'"+' alt="ok" />'
  } else {
    _ritorno="<img src='../images/GIF/068.gif'"+' alt="ko" />'    
  }    
  return _ritorno
}  
function RefreshView() {
  this.Query1.Query();
  this.Grid0.Refresh();
}  
function StampaModulo() {
  if (confirm('Confermi la stampa del modulo?')) {
    if (this.gStpDwn.Value()=='N') {
      this.PrintRegWin.Link()
    } else {
      this.PrintReg.Link()      
    }  
  }  
}  
function DescTipReg(_tipo) {
  ritorno='';
  if (_tipo=='G') {
    ritorno='Giocata'
  }
  if (_tipo=='V') {
    ritorno='Vincita'
  }
  if (_tipo=='P') {
    ritorno='Prelievo'
  }
  if (_tipo=='R') {
    ritorno='Versamento'
  }
  return ritorno;
}  
function Sblocca(_flgunl) {
  if (_flgunl=='N') {
    if (confirm("Confermi lo sblocco dell'operazione?")) {
      _result=this.RTSblocco.Link()
      if (_result=="OK") {
        alert("Sblocco operazione avvenuta correttamente")
        this.RefreshView()
      } else {
        alert("Errore durante l'operazione di sblocco. Contattare assistenza!")
      }  
    }    
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
.pg_cgo_operazioni_storico_adm_container {
}
.pg_cgo_operazioni_storico_adm_title_container {
  margin: auto;
}
.pg_cgo_operazioni_storico_adm_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:22px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:22px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="320"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:263px;
  left:82.1875%;
  right:-89px;
  right:-27.8125%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="480"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:263px;
  left:54.791668%;
  right:71px;
  right:14.791667%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="768"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:37px;
  left:4.8177085%;
  right:585px;
  right:76.171875%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_storico_adm_portlet > .w_snainumope_ctrl {
  display:none;
}
.pg_cgo_operazioni_storico_adm_portlet > .w_snainumope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="320"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  right:4px;
  width:25px;
  height:25px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="480"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  right:4px;
  width:25px;
  height:25px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="768"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_storico_adm_portlet > .BtnEsci_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="1024"] > .BtnEsci_ctrl {
  line-height:25px;
  font-size:25px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="320"] > .BtnEsci_ctrl {
  line-height:25px;
  font-size:25px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="480"] > .BtnEsci_ctrl {
  line-height:25px;
  font-size:25px;
}
.pg_cgo_operazioni_storico_adm_portlet[Data-step="768"] > .BtnEsci_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Storico Operazioni Agenzie\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Ticket\"},{\"title\":\"Agenzia\"},{\"title\":\"Nome Agenzia\"},{\"title\":\"Data Completamento\"},{\"title\":\"Tipo Gioco\"},{\"title\":\"Tipo Registrazione\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Segno\"},{\"title\":\"Stato Doc.\"},{\"title\":\"Sblocchi\"},{\"title\":\"\"},{\"title\":\"\"},{\"title\":\"\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left-right\",\"h\":528,\"hide\":\"false\",\"w\":\"320\",\"x\":0,\"y\":22},\"480\":{\"anchor\":\"top-left-right\",\"h\":528,\"hide\":\"false\",\"w\":\"480\",\"x\":0,\"y\":22},\"768\":{\"anchor\":\"top-left-right\",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":42}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"42\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"-3\",\"y\":\"-65\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":\"146\",\"x\":263,\"y\":-32},\"320\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":\"146\",\"x\":263,\"y\":-32},\"480\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":\"146\",\"x\":263,\"y\":-32},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":146,\"x\":37,\"y\":13}},\"name\":\"w_snainumope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"146\",\"x\":\"37\",\"y\":\"13\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"OpeEdit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"112\",\"x\":\"777\",\"y\":\"36\"},{\"h\":\"20\",\"name\":\"gUrlApp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"428\",\"y\":\"-65\"},{\"h\":\"20\",\"name\":\"gStpDwn\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"585\",\"y\":\"-65\"},{\"h\":\"30\",\"name\":\"Uscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"112\",\"x\":\"778\",\"y\":\"-34\"},{\"h\":\"30\",\"name\":\"PrintReg\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"113\",\"x\":\"777\",\"y\":\"70\"},{\"h\":\"30\",\"name\":\"PrintRegWin\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"114\",\"x\":\"779\",\"y\":\"-1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"h\":25,\"hide\":\"false\",\"w\":\"25\",\"x\":995,\"y\":0},\"320\":{\"anchor\":\"top-right\",\"h\":25,\"hide\":\"false\",\"w\":\"25\",\"x\":291,\"y\":0},\"480\":{\"anchor\":\"top-right\",\"h\":25,\"hide\":\"false\",\"w\":\"25\",\"x\":451,\"y\":0},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":732,\"y\":6}},\"name\":\"BtnEsci\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"732\",\"y\":\"6\",\"zindex\":\"1\"},{\"h\":\"34\",\"name\":\"allegatiRefresh\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"164\",\"x\":\"915\",\"y\":\"-63\"},{\"h\":\"30\",\"name\":\"RTSblocco\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"112\",\"x\":\"777\",\"y\":\"105\"},{\"h\":\"20\",\"name\":\"OrderBy\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"165\",\"y\":\"-64\"},{\"h\":\"30\",\"name\":\"CreaDir\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"112\",\"x\":\"778\",\"y\":\"137\"},{\"h\":\"34\",\"name\":\"armt_snai_oper_storico_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"164\",\"x\":\"913\",\"y\":\"-19\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_storico_adm","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_storico_adm_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_storico_adm','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_storico_adm_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_snainumope= "";
if(request.getAttribute("pg_cgo_operazioni_storico_adm_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String gUrlApp=sp.getGlobal("gUrlApp","");
String gStpDwn=sp.getGlobal("gStpDwn","");
String OrderBy= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_storico_adm_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_storico_adm_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_storico_adm_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_storico_adm','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_w_snainumope_wrp'><input id='<%=idPortlet%>_w_snainumope' name='w_snainumope' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_snainumope' /></span>
<a id='<%=idPortlet%>_BtnEsci' class='image BtnEsci_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_storico_adm');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_storico_adm',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Storico Operazioni Agenzie","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":"top-left-right","h":528,"hide":"false","w":"320","x":0,"y":22},"480":{"anchor":"top-left-right","h":528,"hide":"false","w":"480","x":0,"y":22},"768":{"anchor":"top-left-right","h":528,"hide":"false","w":768,"x":0,"y":42}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":true,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":42,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Oper.","type":"D","align":"center","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"center","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:LanciaView()","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODDIPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DESCRIZ","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Completamento","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CGODATFINCOM","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Gioco","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DESTPGIO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Registrazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAFLGOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Totale Operazione","type":"N","align":"center","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"center","enable_HTML":false,"onclick":"","weight":"","picture":"999,999,999.99","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TOTLIRE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Segno","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SEGNO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Stato Doc.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"FLGDOCALL","fg_color":"","width":"80","RowSpan":0,"extensible":false},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Sblocchi","align":"center","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"center","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"NUMSBLOCCO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:CalcSemaforo('%FLGDOCALL%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","font_weight":"","orderby_field":"","col_class":"","font_size":"","link":"function:StampaModulo()","fixedwidth":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"Premere per la stampa del modulo di adeguata verifica","droppable":false,"bg_color":"","field":"image:..\u002fimages\u002fprinter_ico.gif:Stampa il modulo di adeguata verifica","droppable_name":"","fg_color":"","width":"10","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"function:Sblocca('%FLGSBLOCCO%')","fixedwidth":"","title":"","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"Premere il lucchetto per sbloccare l'operazione","droppable":false,"bg_color":"","field":"function:CalcSblocco('%FLGSBLOCCO%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_operazioni_admin_storico","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_admin_storico",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_OrderBy=OrderBy","parms_source":"","type":"SQLDataobj","w":120,"x":-3,"y":-65});
this.w_snainumope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_snainumope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"SNAINUMOPE","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":22,"hide":"false","w":"146","x":263,"y":-32},"320":{"anchor":" ","h":22,"hide":"false","w":"146","x":263,"y":-32},"480":{"anchor":" ","h":22,"hide":"false","w":"146","x":263,"y":-32},"768":{"anchor":"","h":22,"hide":"false","w":146,"x":37,"y":13}},"maxlength":"","name":"w_snainumope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_snainumope,false,true)%>","w":146,"x":37,"y":13,"zerofilling":false,"zindex":"1","zoom":""});
this.OpeEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"<%=JSPLib.encrypt("armt_snai_oper_storico",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEdit","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEdit","offline":false,"page":1,"parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_snai_oper_storico","target":"","type":"SPLinker","w":112,"x":777,"y":36});
this.OpeEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_snai_oper_storico",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.gStpDwn=new ZtVWeb._VC(this,'gStpDwn',null,'character','<%=JSPLib.ToJSValue(gStpDwn,false,true)%>',false,false);
this.Uscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Uscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Uscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":112,"x":778,"y":-34});
this.Uscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.PrintReg=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_PrintReg","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"PrintReg","offline":false,"page":1,"parms":"w_SNAINUMOPE=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_moduli_storico","target":"","type":"SPLinker","w":113,"x":777,"y":70});
this.PrintReg.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_moduli_storico",request.getSession())%>';
this.PrintRegWin=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_PrintRegWin","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"PrintRegWin","offline":false,"page":1,"parms":"w_SNAINUMOPE=w_snainumope","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_moduli_storico","target":"","type":"SPLinker","w":114,"x":779,"y":-1});
this.PrintRegWin.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_moduli_storico",request.getSession())%>';
this.BtnEsci=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnEsci_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnEsci","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","h":25,"hide":"false","w":"25","x":995,"y":0},"320":{"anchor":"top-right","h":25,"hide":"false","w":"25","x":291,"y":0},"480":{"anchor":"top-right","h":25,"hide":"false","w":"25","x":451,"y":0},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":732,"y":6}},"name":"BtnEsci","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":732,"y":6,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.allegatiRefresh=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_allegatiRefresh","h":34,"hide":"false","included":"true","layer":false,"layout_steps_values":{},"name":"allegatiRefresh","objsValues":"this.RefreshView()","page":1,"parmsNames":"","type":"EventReceiver","w":164,"x":915,"y":-63});
this.RTSblocco=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSblocco","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSblocco","offline":false,"page":1,"parms":"pCodice=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_cgo_sblocco","target":"","type":"SPLinker","w":112,"x":777,"y":105});
this.RTSblocco.m_cID='<%=JSPLib.cmdHash("routine,arfn_cgo_sblocco",request.getSession())%>';
this.OrderBy=new ZtVWeb._VC(this,'OrderBy',null,'character','<%=JSPLib.ToJSValue(OrderBy,false,true)%>',false,false);
this.CreaDir=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_snai_oper_storico",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_CreaDir","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"CreaDir","offline":false,"page":1,"parms":"pID=w_snainumope","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"arfn_snai_oper_storico","target":"","type":"SPLinker","w":112,"x":778,"y":137});
this.CreaDir.m_cID='<%=JSPLib.cmdHash("routine,arfn_snai_oper_storico",request.getSession())%>';
this.armt_snai_oper_storico_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_snai_oper_storico_savedEntity","h":34,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_snai_oper_storico_savedEntity","objsValues":"this.RefreshView()","page":1,"parmsNames":"","type":"EventReceiver","w":164,"x":913,"y":-19});
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
<%if(request.getAttribute("pg_cgo_operazioni_storico_adm_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_storico_adm_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_storico_adm_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.BtnEsci.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_<%=(!"".equals(Library.getAttribute(request,"m_cInclusionEntityName",""))?Library.getAttribute(request,"m_cInclusionEntityName","")+"_":"")%>allegatiRefresh=function(parmsObj){<%=idPortlet%>.allegatiRefresh.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_snai_oper_storico_savedEntity=function(parmsObj){<%=idPortlet%>.armt_snai_oper_storico_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_storico_adm',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_storico_adm');
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
sp.endPage("pg_cgo_operazioni_storico_adm");
}%>
<%! public String getJSPUID() { return "1011231743"; } %>