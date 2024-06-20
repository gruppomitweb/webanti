<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var skins = '\u003c%=sp.getSkinList()%\u003e'.split(',');\n\u002f\u002f this.MenuView.SetCurrentApp('Articoli_61.3')\n\u002f\u002f this.MenuView.SetCurrentApp('Articoli')\n\n\u003c%\nif(sp.isLogged()){\n%\u003e\nthis.User.Value('\u003c%=JSPLib.ToJSValue((\"\".equals(sp.getFullName())?sp.getUserName():sp.getFullName()))%\u003e')\n\u003c%\n}\nelse {\n%\u003e\nthis.User.Hide()\n\u003c%\n}\n%\u003e\n  \nfunction SetSkin( skin ) {\n\twindow.location='..\u002fjsp-system\u002fSPSkinSwitch.jsp?skinName='+skin+'&fromURL=\u003c%=JSPLib.ToJSValue( request.getRequestURI()+(request.getQueryString()!=null?\"?\"+request.getQueryString():\"\") )%\u003e';\n}\n\n\nthis.HamburgerMenu.Append({\n  id: 'utils',\n  title: '' \u002f\u002f,\n  \u002f\u002fchild_type: 'horizontal'\n})\nthis.HamburgerMenu.Append({\n  id: 'User',\n  title: this.User.Value(),\n},'utils')\nthis.HamburgerMenu.Append({\n  id: 'map',\n  tooltip: 'Site Map',\n  image: {fontFamily: 'ZucchettiDevelopement', value: '&#xeaa9', size: '24px', color: '#000'},\n  action: function(_this){ return function(){_this.map.Link();}}(this)\n},'utils')\nthis.HamburgerMenu.Append({\n  id: 'logout',\n  tooltip: 'Logout',\n  image: {fontFamily: 'ZucchettiDevelopement', value: '&#xea01', size: '24px', color: '#000'},\n  action: function(_this){ return function(){_this.logout.Link();}}(this)\n},'utils')\n  this.HamburgerMenu.Append({\n  id: 'user',\n  title: this.User.Value(),\n    child_type: 'vertical'\n})\n  \u002f*\n  this.HamburgerMenu.Append({\n  id: 'utils',\n  title: 'actions' \u002f\u002f,\n  \u002f\u002fchild_type: 'horizontal'\n})\nthis.HamburgerMenu.Append({\n  id: 'map',\n  tooltip: 'Site Map',\n  image: {fontFamily: 'ZucchettiDevelopement', value: '&#xeaa9', size: '24px', color: '#000'},\n  action: function(_this){ return function(){_this.map.Link();}}(this)\n},'utils')\nthis.HamburgerMenu.Append({\n  id: 'logout',\n  tooltip: 'Logout',\n  image: {fontFamily: 'ZucchettiDevelopement', value: '&#xea01', size: '24px', color: '#000'},\n  action: function(_this){ return function(){_this.logout.Link();}}(this)\n},'utils')\n*\u002f\n\nthis.HamburgerMenu.Append({\n  id: 'skin',\n  title: 'Skins',\n  child_type: 'vertical'\n})\nfor( var i=0; i\u003cskins.length; i++){\n\tthis.HamburgerMenu.Append({\n    id: skins[i],\n    title: skins[i],\n    action:function(_this,skin){ \n    \t\treturn function(){\n        _this.SetSkin(skin);\n      \t}\n    \t}(this,skins[i]) \n  }, 'skin');\n}\n  \n\u002f\u002fsitemap_portlet.jsp\n\nfunction offcanvas_close_Click(){\n  this.getPagelet().ToggleLeftSide();\n  this.offcanvas_close.Hide();\n  this.offcanvas_open.Show();\n}\n  \n  \nfunction offcanvas_open_Click(){\n  this.getPagelet().ToggleLeftSide();\n  this.offcanvas_open.Hide();\n  this.offcanvas_close.Show();\n}\n\n\u002f\u002f Aggiunto per differenziare i menu dallo standard a quello di webuic---------------------\nfunction MenuView_Validate(a){\n\u002f\u002f   alert(a)\n  if(this.gAppName.Value()=='UIC'){\n    switch(a) {\n      case '01. Analisi':\n        return false;\n        break;\n        \u002f\u002fCambiato per permettere le interviste in a chi ha webuic e webaos_uic\n      \u002f*case '02. Nuove analisi':\n      \treturn false;\n        break;*\u002f\n      case '01. Gestione Indici':\n        return false;\n        break;\n      case '02. Configurazione set di ricerca':\n        return false;\n        break;\n      case '03. Elaborazione set di ricerca':\n        return false;\n        break;\n      case '04. Scheduler':\n        return false;\n        break;\n      case '05. Categorie':\n        return false;\n        break;\n      case '03. Intervista autovalutazione':\n        return false;\n        break;\n      case '09. Verifica Profilatura':\n        return false;\n        break;\n      case '03. Contrasto al terrorismo':\n        return this.gTER.Value();\n        break;\n      case '04. Indicatori Anomalia':\n        return false;\n        break;\n      case '05. SOS':\n        return false;\n        break;\n      case '06. Home':\n        return false;\n        break;\n      case '07. MAV':\n        return false;\n        break;\n      case '06. Categorie':\n        return false;\n        break;\n      case '07. Relazione Annuale':\n        return false;\n        break;\n      case '08. Confronto':\n        return false;\n        break;\n      case'90. Analisi personalizzate':\n        return false;\n        break;\n      default:\n        return true;\n    }\n  }else{\n    switch(a) {\n      case '01. Home':\n        return false;\n        break;\n      case '01. Analisi':\n        return this.gAOS.Value();\n        break;\n      case '03. Contrasto al terrorismo':\n        return this.gTER.Value();\n        break;\n      case '04. Indicatori Anomalia':\n        return this.gAOS.Value();\n        break;\n      case '05. SOS':\n        return this.gSOS.Value();\n        break;\n      case '07. MAV':\n        return this.gMAV.Value();\n        break;\n      case'90. Analisi personalizzate':\n\u002f\u002f         return this.gAppName.Value()=='OPE';\n        return this.gAzienda.Value()=='sicita';\n        break;\n      default:\n        return true;\n    }\n  }\n}\n\u002f\u002f --------------------------------------------------------------------------------------","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet-header-default","css_code":"[{\"type\":\"image\",\"name\":\"image8_class1223\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"grayscale\\\":\\\"100\\\",\\\"border_radius_tl\\\":\\\"50\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"src\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"image0\\\",\\\"type\\\":\\\"Image\\\",\\\"class_name\\\":\\\"image8_class1223\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:40px; height:40px;\\\\\\\" \u003e\u003cimg src=\\\\\\\"undefined\\\\\\\" width=\\\\\\\"40\\\\\\\" height=\\\\\\\"40\\\\\\\"\u002f\u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"src\\\":\\\"..\u002fimages\u002ffirma.png\\\",\\\"page\\\":1,\\\"grayscale\\\":\\\"100\\\",\\\"border_radius_tl\\\":\\\"50\\\"}\",\"code\":\".image8_class1223{border-radius: 50px 0 0 0;-webkit-filter: grayscale(100%) ;filter: grayscale(100%) ;}\\n\"},{\"type\":\"hamburgermenu\",\"name\":\"HamburgerMenu_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"z-index: 1;\\\\n\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"default0\\\",\\\"type\\\":\\\"default\\\",\\\"class_name\\\":\\\"HamburgerMenu_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:33px; height:30px;\\\\\\\" \u003eNo preview available.\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"page\\\":1,\\\"code\\\":\\\"z-index: 1;\\\\n\\\"}\",\"code\":\".HamburgerMenu_class{z-index: 1;\\n}\\n\"},{\"type\":\"image\",\"name\":\"image8_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"grayscale\\\":\\\"100\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"sepia\\\":\\\"1\\\",\\\"border_radius_tl\\\":\\\"20\\\",\\\"border_radius_tr\\\":\\\"20\\\",\\\"border_radius_bl\\\":\\\"20\\\",\\\"border_radius_br\\\":\\\"20\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"src\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"image0\\\",\\\"type\\\":\\\"Image\\\",\\\"class_name\\\":\\\"image8_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:40px; height:40px;\\\\\\\" \u003e\u003cimg src=\\\\\\\"..\u002fimages\u002ffirma.jpg\\\\\\\" width=\\\\\\\"40\\\\\\\" height=\\\\\\\"40\\\\\\\"\u002f\u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"src\\\":\\\"..\u002fFusion\u002fimages\u002ffirma.jpg\\\",\\\"page\\\":1,\\\"grayscale\\\":\\\"100\\\",\\\"sepia\\\":\\\"1\\\",\\\"border_radius_tl\\\":\\\"20\\\",\\\"border_radius_tr\\\":\\\"20\\\",\\\"border_radius_bl\\\":\\\"20\\\",\\\"border_radius_br\\\":\\\"20\\\",\\\"font_list\\\":[\\\"\\\",\\\"Coustard\\\",\\\"Antic Slab\\\",\\\"Quattrocento\\\",\\\"Cinzel\\\",\\\"Josefin Slab\\\",\\\"Merriweather\\\",\\\"Lora\\\",\\\"Nunito\\\",\\\"Abel\\\",\\\"Fjalla One\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Raleway\\\",\\\"Montserrat\\\",\\\"Roboto Condensed\\\",\\\"Oswald\\\",\\\"Special Elite\\\",\\\"Fredoka One\\\",\\\"Comfortaa\\\",\\\"Bangers\\\",\\\"Righteous\\\",\\\"Sigmar One\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Lobster\\\",\\\"Nova Mono\\\",\\\"Inconsolata\\\",\\\"Source Code Pro\\\",\\\"Anonymous Pro\\\",\\\"Roboto Mono\\\",\\\"Amatic SC\\\",\\\"Shadows Into Light\\\",\\\"Dancing Script\\\",\\\"Pacifico\\\",\\\"Indie Flower\\\"]}\",\"code\":\".image8_class{border-radius: 20px 20px 20px 20px;-webkit-filter: sepia(1%) grayscale(100%) ;filter: sepia(1%) grayscale(100%) ;}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label\",\"selector\":\".label\",\"value\":\"...\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"display: flex;\\nalign-items: center;\\nfont-weight: 400;\\ncolor: #000;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label\",\"selector\":\".label.username-header\",\"value\":\"...\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @User }}{{ @HamburgerMenu }}{{ @offcanvas_open }}{{ @offcanvas_close }}{{ @MenuView }}{{ @User }}{{ @HamburgerMenu }}{{ @offcanvas_open }}{{ @offcanvas_close }}{{ @MenuView }}\u003c\u002fbody\u003e","grapesCss":"","h":"40","hsl":"","htmlcode":" \n \n{{ xmlobj0 }}\n{{ backgroundBox }}\n{{ User }}\n{{ add_login }}\n{{ depth }}\n{{ image8 }}\n{{ HamburgerMenu }}\n{{ offcanvas_open }}\n{{ offcanvas_close }}\n{{ logout }}\n{{ map }}\n{{ MenuView }}\n{{ @User }} \n \n{{ @HamburgerMenu }} \n{{ @offcanvas_open }} \n{{ @offcanvas_close }} \n{{ @MenuView }} \n","included_font":"[]","language":"true","layout_step":"800","layout_steps_values":"{\"800\":{\"h\":\"50\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"40\",\"w\":\"100%\",\"layout_steps_values\":{\"800\":{\"h\":\"40\",\"w\":\"100%\"}}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"800","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"async":"true","auto_exec":"true","ctrlOfVariant":"","h":"22","n_records":"1000","name":"xmlobj0","page":"1","parms":"set_default_target=false","parms_source":"","root":"\u002fSPVMNMenu","sequence":"1","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":"78","x":"0","xmldataobj":"","y":"-28"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAppName","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"81","x":"354","y":"-26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"70","x":"441","y":"-26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global boolean","name":"gTER","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"logic","w":"67","x":"515","y":"-26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global boolean","name":"gSOS","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"logic","w":"66","x":"586","y":"-26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global boolean","name":"gAOS","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"logic","w":"66","x":"658","y":"-26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global boolean","name":"gMAV","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"logic","w":"66","x":"730","y":"-26"},{"align":"right","anchor":"top-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label username-header","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"800\":{\"x\":585,\"y\":10,\"w\":155,\"h\":20,\"anchor\":\"top-right\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":767,\"y\":16,\"w\":\"169\",\"h\":34,\"anchor\":\"top-right\",\"align\":\"\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"User","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"...","w":"155","wireframe_props":"align,value,n_col","x":"585","y":"10","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'no'","name":"add_login","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"143","x":"0","y":"95"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'1'","name":"depth","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"143","x":"3","y":"130"},{"anchor":"top-right","bg_color":"","class_Css":"skin_list","color":"","ctrlOfVariant":"","fixed":"","fontSize":"","h":"36","hide":"false","layer":"false","layout_steps_values":"{\"800\":{\"x\":744,\"y\":2,\"w\":36,\"h\":36,\"anchor\":\"top-right\",\"hide\":\"false\"},\"1024\":{\"x\":988,\"y\":16,\"w\":\"33\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"}}","maxsubitemelements":"","name":"HamburgerMenu","page":"1","rapp":"","sequence":"11","spuid":"","type":"HamburgerMenu","visible_handler":"true","w":"36","wireframe_props":"","x":"744","y":"2","zindex":"999","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb9f;","font_image_hover":"","font_name":"ZucchettiDevelopement.ttf","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"800\":{\"x\":20,\"y\":5,\"w\":\"30\",\"h\":30,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":3,\"y\":10,\"w\":\"30\",\"h\":30,\"anchor\":\"\",\"hide\":\"false\"}}","name":"offcanvas_open","page":"1","path_type":"","rapp":"","sequence":"12","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"20","y":"5","zindex":"5","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeba1;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"true","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{\"800\":{\"x\":20,\"y\":5,\"w\":\"30\",\"h\":30,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":3,\"y\":10,\"w\":\"30\",\"h\":30,\"anchor\":\"\",\"hide\":\"false\"}}","name":"offcanvas_close","page":"1","path_type":"fixed","rapp":"","sequence":"13","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"20","y":"5","zindex":"5","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"22","m_cAction":"","name":"logout","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"cp_logout","target":"_self","type":"SPLinker","w":"62","x":"86","y":"-28"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"22","m_cAction":"","name":"map","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"..\u002fjsp\u002fsitemap_portlet.jsp","target":"main","type":"SPLinker","w":"64","x":"155","y":"-28"},{"Root_node_value":"","anchor":"top-left-right","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","className":"","close_level":"","ctrlOfVariant":"","dataobj":"xmlobj0","direction":"horizontal","emitter_name":"","field_ChildCount":"elements","field_Css_Class":"","field_Expr":"caption","field_ExprNot":"","field_Frame":"target","field_Icons":"","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeLinkOver":"","field_NodeParent":"","field_NodeSeq":"","field_NodeTooltip":"","field_inExt":"","field_level":"","field_view_type":"","fixed":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":"28","hide":"","layer":"","layout_steps_values":"{\"800\":{\"x\":70,\"y\":5,\"w\":478,\"h\":28,\"anchor\":\"top-left-right\",\"direction\":\"horizontal\"},\"1024\":{\"x\":53,\"y\":0,\"w\":\"702\",\"h\":50,\"anchor\":\"top-left-right\",\"direction\":\"horizontal\"}}","link_secondary":"","max_level":"-1","menu_type":"horizontal","name":"MenuView","page":"1","rapp":"","separator":"","separator_vert":"","sequence":"16","server_side":"false","skin_path":"","spuid":"","tag_node":"MenuItem","target_default":"tab","type":"MenuView","w":"478","wireframe_props":"","x":"70","y":"5","zindex":"1000","zone":""}]%>
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
.start_page_menu_orizz_container .image8_class1223{  border-radius: 50px 0 0 0;
  -webkit-filter: grayscale(100%) ;
  filter: grayscale(100%) ;
}
.start_page_menu_orizz_container .HamburgerMenu_class{
  z-index: 1;
  
}
.start_page_menu_orizz_container .image8_class{
  border-radius: 20px 20px 20px 20px;
  -webkit-filter: sepia(1%) grayscale(100%) ;
  filter: sepia(1%) grayscale(100%) ;
}
.start_page_menu_orizz_container .label.username-header{
  display: flex;
  align-items: center;
  font-weight: 400;
  color: #000;
}
.start_page_menu_orizz_container {
}
.start_page_menu_orizz_portlet{
  position:relative;
  width:100%;
  min-width:800px;
  height:40px;
}
.start_page_menu_orizz_portlet[Data-page="1"]{
  height:40px;
  width:100%;
}
.start_page_menu_orizz_portlet[Data-step="800"] {
  height:40px;
  width:100%;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .User_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:60px;
  width:155px;
  height:auto;
  min-height:20px;
}.start_page_menu_orizz_portlet[Data-step="800"] > .User_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_menu_orizz_portlet > .User_ctrl {
  overflow:hidden;
  text-align:right;
}
.start_page_menu_orizz_portlet[Data-step="1024"] > .User_ctrl > div{
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .User_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .HamburgerMenu_ctrl {
  box-sizing:border-box;
  z-index:999;
  position:absolute;
  display:inline-block;
  top:2px;
  right:20px;
  width:36px;
  height:36px;
}
.start_page_menu_orizz_portlet .HamburgerMenu_ctrl.global_handler{
  z-index:999;
}
.start_page_menu_orizz_portlet .HamburgerMenu_ctrl.global_handler:after{
}
.start_page_menu_orizz_portlet[Data-step="800"] > .offcanvas_open_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:20px;
  width:30px;
  height:30px;
}
.start_page_menu_orizz_portlet > .offcanvas_open_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.start_page_menu_orizz_portlet[Data-step="1024"] > .offcanvas_open_ctrl {
  line-height:30px;
  font-size:30px;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .offcanvas_open_ctrl {
  line-height:30px;
  font-size:30px;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .offcanvas_close_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:20px;
  width:30px;
  height:30px;
}
.start_page_menu_orizz_portlet > .offcanvas_close_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.start_page_menu_orizz_portlet[Data-step="1024"] > .offcanvas_close_ctrl {
  line-height:30px;
  font-size:30px;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .offcanvas_close_ctrl {
  line-height:30px;
  font-size:30px;
}
.start_page_menu_orizz_portlet[Data-step="800"] > .MenuView_ctrl {
  box-sizing:border-box;
  z-index:1000;
  position:absolute;
  display:inline-block;
  top:5px;
  left:70px;
  right:252px;
  width:auto;
  height:28px;
}
.start_page_menu_orizz_portlet .MenuView_ctrl,
.start_page_menu_orizz_portlet .MenuView_ctrl a{
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
 String def="[{\"h\":\"40\",\"layout_steps_values\":{\"800\":{\"h\":\"50\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"800\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"XMLDataobj\",\"w\":\"78\",\"x\":\"0\",\"y\":\"-28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"81\",\"x\":\"354\",\"y\":\"-26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"70\",\"x\":\"441\",\"y\":\"-26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"67\",\"x\":\"515\",\"y\":\"-26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"586\",\"y\":\"-26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"658\",\"y\":\"-26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"66\",\"x\":\"730\",\"y\":\"-26\"},{\"align\":\"right\",\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"align\":\"\",\"anchor\":\"top-right\",\"fontpct\":\"\",\"h\":34,\"n_col\":\"1\",\"w\":\"169\",\"x\":767,\"y\":16},\"800\":{\"align\":\"right\",\"anchor\":\"top-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":155,\"x\":585,\"y\":10}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"...\",\"w\":\"155\",\"x\":\"585\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"143\",\"x\":\"0\",\"y\":\"95\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"143\",\"x\":\"3\",\"y\":\"130\"},{\"anchor\":\"top-right\",\"h\":\"36\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":\"33\",\"x\":988,\"y\":16},\"800\":{\"anchor\":\"top-right\",\"h\":36,\"hide\":\"false\",\"w\":36,\"x\":744,\"y\":2}},\"page\":\"1\",\"type\":\"HamburgerMenu\",\"w\":\"36\",\"x\":\"744\",\"y\":\"2\",\"zindex\":\"999\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":3,\"y\":10},\"800\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":20,\"y\":5}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"20\",\"y\":\"5\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":3,\"y\":10},\"800\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":20,\"y\":5}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"20\",\"y\":\"5\",\"zindex\":\"5\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"62\",\"x\":\"86\",\"y\":\"-28\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"64\",\"x\":\"155\",\"y\":\"-28\"},{\"anchor\":\"top-left-right\",\"h\":\"28\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-left-right\",\"direction\":\"horizontal\",\"h\":50,\"w\":\"702\",\"x\":53,\"y\":0},\"800\":{\"anchor\":\"top-left-right\",\"direction\":\"horizontal\",\"h\":28,\"w\":478,\"x\":70,\"y\":5}},\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"478\",\"x\":\"70\",\"y\":\"5\",\"zindex\":\"1000\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_menu_orizz","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_menu_orizz_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_menu_orizz','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("start_page_menu_orizz_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
String gAppName=sp.getGlobal("gAppName","");
String gAzienda=sp.getGlobal("gAzienda","");
boolean gTER=sp.getGlobal("gTER",true);
boolean gSOS=sp.getGlobal("gSOS",true);
boolean gAOS=sp.getGlobal("gAOS",true);
boolean gMAV=sp.getGlobal("gMAV",true);
String User= "...";
String add_login="no";
String depth="1";
if(request.getAttribute("start_page_menu_orizz_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("HamburgerMenuObj.js")%>'></script>
<%}
if(request.getAttribute("start_page_menu_orizz_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_menu_orizz_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_menu_orizz_portlet portlet-header-default' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_menu_orizz','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_User'  formid='<%=idPortlet%>' ps-name='User'    class='label username-header User_ctrl'><div id='<%=idPortlet%>_Usertbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("..."))%></div></span>
<div id='<%=idPortlet%>_HamburgerMenu' class='HamburgerMenu_ctrl skin_list global_handler closed'></div><a id='<%=idPortlet%>_offcanvas_open' class='image offcanvas_open_ctrl'  href='javascript:void(0)' target='_self'>&#xeb9f;</a>
<a id='<%=idPortlet%>_offcanvas_close' class='image offcanvas_close_ctrl'  href='javascript:void(0)' target='_self'>&#xeba1;</a>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewHorObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuView' class='menuview_horizontal'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_menu_orizz');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_menu_orizz',["800"],["40"],'portlet-header-default',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'800', '','','',{"800":{"h":"50","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"800":{"w":"100%","h":"40"}},"w":"800","h":"40","title":"","layer":""}]);
this.xmlobj0=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobj0","field":"","h":22,"hide":"false","layer":false,"layout_steps_values":{},"n_records":"1000","name":"xmlobj0","page":1,"parms":"set_default_target=false","parms_source":"","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":78,"x":0,"xmldataobj":"","y":-28});
this.gAppName=new ZtVWeb._VC(this,'gAppName',null,'character','<%=JSPLib.ToJSValue(gAppName,false,true)%>',false,false);
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.gTER=new ZtVWeb._VC(this,'gTER',null,'logic',<%=gTER%>,false,false);
this.gSOS=new ZtVWeb._VC(this,'gSOS',null,'logic',<%=gSOS%>,false,false);
this.gAOS=new ZtVWeb._VC(this,'gAOS',null,'logic',<%=gAOS%>,false,false);
this.gMAV=new ZtVWeb._VC(this,'gMAV',null,'logic',<%=gMAV%>,false,false);
this.User=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label username-header","create_undercond":"","ctrlid":"<%=idPortlet%>_User","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"","anchor":"top-right","fontpct":"","h":34,"n_col":"1","w":"169","x":767,"y":16},"800":{"align":"right","anchor":"top-right","fontpct":"","h":20,"hide":"false","n_col":"1","w":155,"x":585,"y":10}},"n_col":1,"name":"User","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(User),false,true)%>","type":"Label","w":155,"x":585,"y":10,"zindex":"1"});
this.add_login=new ZtVWeb._VC(this,'add_login',null,'character','<%=JSPLib.ToJSValue(add_login,false,true)%>',false,false);
this.depth=new ZtVWeb._VC(this,'depth',null,'character','<%=JSPLib.ToJSValue(depth,false,true)%>',false,false);
this.HamburgerMenu=new ZtVWeb.HamburgerMenuCtrl(this,{"anchor":"top-right","bg_color":"","color":"","css_class":"skin_list","ctrlid":"<%=idPortlet%>_HamburgerMenu","fontSize":0,"h":36,"hide":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","h":30,"hide":"false","w":"33","x":988,"y":16},"800":{"anchor":"top-right","h":36,"hide":"false","w":36,"x":744,"y":2}},"maxsubitemelements":0,"name":"HamburgerMenu","page":1,"spuid":"","type":"HamburgerMenu","visible_handler":true,"w":36,"x":744,"y":2,"zindex":"999"});
this.offcanvas_open=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image offcanvas_open_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_offcanvas_open","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb9f;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":30,"hide":"false","w":"30","x":3,"y":10},"800":{"anchor":"","font_size":"","h":30,"hide":"false","w":"30","x":20,"y":5}},"name":"offcanvas_open","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb9f;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":30,"x":20,"y":5,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.offcanvas_close=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image offcanvas_close_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_offcanvas_close","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeba1;","font_image_hover":"","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","href":"javascript:void(0)","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":30,"hide":"false","w":"30","x":3,"y":10},"800":{"anchor":"","font_size":"","h":30,"hide":"false","w":"30","x":20,"y":5}},"name":"offcanvas_close","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xeba1;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":30,"x":20,"y":5,"zindex":"5"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.logout=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_logout","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"logout","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"cp_logout","target":"_self","type":"SPLinker","w":62,"x":86,"y":-28});
this.logout.m_cID='<%=JSPLib.cmdHash("entity,cp_logout",request.getSession())%>';
this.map=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_map","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"map","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fsitemap_portlet.jsp","target":"main","type":"SPLinker","w":64,"x":155,"y":-28});
this.map.m_cID='<%=JSPLib.cmdHash("entity,../jsp/sitemap_portlet.jsp",request.getSession())%>';
this.MenuView=new ZtVWeb.MenuViewHorCtrl(this,{"anchor":"top-left-right","arrow_image":"","bg_color":"","bg_color_smenu":"","bg_over_color":"","bg_over_color_smenu":"","btn_image":"","btn_imageWidth":"","btnover_image":"","class_Css":"","close_level":"","ctrlid":"<%=idPortlet%>_MenuView","direction":"horizontal","dx_btn_image":"","dx_btnover_image":"","emitter_name":"","folder_path":"","font":"","font_color":"","font_color_smenu":"","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":"","h":28,"hide":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-left-right","direction":"horizontal","h":50,"w":"702","x":53,"y":0},"800":{"anchor":"top-left-right","direction":"horizontal","h":28,"w":478,"x":70,"y":5}},"link_secondary":"","max_level":-1,"menu_type":"horizontal","name":"MenuView","page":1,"root_value":"","separator":"","separator_vert":"","spuid":"","sx_btn_image":"","sx_btnover_image":"","tag_node":"MenuItem","target_default":"tab","type":"MenuView","w":478,"x":70,"y":5,"zindex":"1000"});
this.MenuView.setRowsCols('uid','elements','caption','','','','caption','','target','link','','', '','');
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
<%request.setAttribute("start_page_menu_orizz_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.start_page_menu_orizz_Static=function(){
if(typeof SetSkin !='undefined')this.SetSkin=SetSkin;
if(typeof offcanvas_close_Click !='undefined')this.offcanvas_close_Click=offcanvas_close_Click;
if(typeof offcanvas_open_Click !='undefined')this.offcanvas_open_Click=offcanvas_open_Click;
if(typeof MenuView_Validate !='undefined')this.MenuView_Validate=MenuView_Validate;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.offcanvas_close);
}
this.xmlobj0.addRowConsumer(this.MenuView);
var skins = '<%=sp.getSkinList()%>'.split(',');
// this.MenuView.SetCurrentApp('Articoli_61.3')
// this.MenuView.SetCurrentApp('Articoli')
<%
if(sp.isLogged()){
%>
this.User.Value('<%=JSPLib.ToJSValue(("".equals(sp.getFullName())?sp.getUserName():sp.getFullName()))%>')
<%
}
else {
%>
this.User.Hide()
<%
}
%>
  
function SetSkin( skin ) {
	window.location='../jsp-system/SPSkinSwitch.jsp?skinName='+skin+'&fromURL=<%=JSPLib.ToJSValue( request.getRequestURI()+(request.getQueryString()!=null?"?"+request.getQueryString():"") )%>';
}
this.HamburgerMenu.Append({
  id: 'utils',
  title: '' //,
  //child_type: 'horizontal'
})
this.HamburgerMenu.Append({
  id: 'User',
  title: this.User.Value(),
},'utils')
this.HamburgerMenu.Append({
  id: 'map',
  tooltip: 'Site Map',
  image: {fontFamily: 'ZucchettiDevelopement', value: '&#xeaa9', size: '24px', color: '#000'},
  action: function(_this){ return function(){_this.map.Link();}}(this)
},'utils')
this.HamburgerMenu.Append({
  id: 'logout',
  tooltip: 'Logout',
  image: {fontFamily: 'ZucchettiDevelopement', value: '&#xea01', size: '24px', color: '#000'},
  action: function(_this){ return function(){_this.logout.Link();}}(this)
},'utils')
  this.HamburgerMenu.Append({
  id: 'user',
  title: this.User.Value(),
    child_type: 'vertical'
})
  
this.HamburgerMenu.Append({
  id: 'skin',
  title: 'Skins',
  child_type: 'vertical'
})
for( var i=0; i<skins.length; i++){
	this.HamburgerMenu.Append({
    id: skins[i],
    title: skins[i],
    action:function(_this,skin){ 
    		return function(){
        _this.SetSkin(skin);
      	}
    	}(this,skins[i]) 
  }, 'skin');
}
  
//sitemap_portlet.jsp
function offcanvas_close_Click(){
  this.getPagelet().ToggleLeftSide();
  this.offcanvas_close.Hide();
  this.offcanvas_open.Show();
}
  
  
function offcanvas_open_Click(){
  this.getPagelet().ToggleLeftSide();
  this.offcanvas_open.Hide();
  this.offcanvas_close.Show();
}
// Aggiunto per differenziare i menu dallo standard a quello di webuic---------------------
function MenuView_Validate(a){
//   alert(a)
  if(this.gAppName.Value()=='UIC'){
    switch(a) {
      case '01. Analisi':
        return false;
        break;
        //Cambiato per permettere le interviste in a chi ha webuic e webaos_uic
      
      case '01. Gestione Indici':
        return false;
        break;
      case '02. Configurazione set di ricerca':
        return false;
        break;
      case '03. Elaborazione set di ricerca':
        return false;
        break;
      case '04. Scheduler':
        return false;
        break;
      case '05. Categorie':
        return false;
        break;
      case '03. Intervista autovalutazione':
        return false;
        break;
      case '09. Verifica Profilatura':
        return false;
        break;
      case '03. Contrasto al terrorismo':
        return this.gTER.Value();
        break;
      case '04. Indicatori Anomalia':
        return false;
        break;
      case '05. SOS':
        return false;
        break;
      case '06. Home':
        return false;
        break;
      case '07. MAV':
        return false;
        break;
      case '06. Categorie':
        return false;
        break;
      case '07. Relazione Annuale':
        return false;
        break;
      case '08. Confronto':
        return false;
        break;
      case'90. Analisi personalizzate':
        return false;
        break;
      default:
        return true;
    }
  }else{
    switch(a) {
      case '01. Home':
        return false;
        break;
      case '01. Analisi':
        return this.gAOS.Value();
        break;
      case '03. Contrasto al terrorismo':
        return this.gTER.Value();
        break;
      case '04. Indicatori Anomalia':
        return this.gAOS.Value();
        break;
      case '05. SOS':
        return this.gSOS.Value();
        break;
      case '07. MAV':
        return this.gMAV.Value();
        break;
      case'90. Analisi personalizzate':
//         return this.gAppName.Value()=='OPE';
        return this.gAzienda.Value()=='sicita';
        break;
      default:
        return true;
    }
  }
}
// --------------------------------------------------------------------------------------
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_menu_orizz_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.offcanvas_open.dispatchEvent('OnLoad');
window.<%=idPortlet%>.offcanvas_close.dispatchEvent('OnLoad');
window.<%=idPortlet%>.xmlobj0.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_menu_orizz',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_menu_orizz');
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
sp.endPage("start_page_menu_orizz");
}%>
<%! public String getJSPUID() { return "580801197"; } %>