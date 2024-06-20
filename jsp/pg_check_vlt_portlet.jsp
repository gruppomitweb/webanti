<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var adv\nvar motivo\nvar er = \u002f^[0-9]+\\.?[0-9]?[0-9]?$\u002f;\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"VERIFICA TICKET VLT TRA \u20ac 400 e \u20ac 500\",true)\n}\n\nfunction btnElab_Click(){\n  if (Empty(this.introdotto.Value()) || Empty(this.giocato.Value()) || Empty(this.vinto.Value()) || Empty(this.vintonetto.Value())) {\n    if (Empty(this.introdotto.Value())) {\n      alert(\"Inserire un valore nell'importo introdotto\")\n      this.introdotto.SetFocus()\n      return\n    }  \n    if (Empty(this.giocato.Value())) {\n      alert(\"Inserire un valore nell'importo giocato\")\n      this.giocato.SetFocus()\n      return\n    } \n    if (Empty(this.vinto.Value())) {\n      alert(\"Inserire un valore nell'importo vinto lordo\")\n      this.vinto.SetFocus()\n      return\n    }  \n    if (Empty(this.vintonetto.Value())) {\n      alert(\"Inserire un valore nell'importo vinto netto\")\n      this.vintonetto.SetFocus()\n      return\n    }      \n  }  \n  if ((Val(this.vintonetto.Value()) \u003e Val(this.vinto.Value())) || (Val(this.vintonetto.Value()) == 0 && Val(this.vinto.Value()) \u003e 0) || (Val(this.vintonetto.Value()) \u003e 0 && Val(this.vinto.Value())==0)) {\n    alert('Importo vinto netto non congruente con Importo vinto lordo!');\n    this.vintonetto.SetFocus()\n    return    \n  }  \n  motivo=''\n  msg=''\n  this.lblMotivo.Value('')\n  this.lblResult.Value('')  \n  this.nominale.Value(Val(this.introdotto.Value()) - Val(this.giocato.Value()) + Val(this.vintonetto.Value()));\n  if (this.nominale.Value() \u003e= 500) {\n    adv = true; \n    motivo = 'Il valore nominale del ticket risulta superiore o uguale a 500 euro';\n  } else {\n    if (this.nominale.Value() \u003e= 400 && this.nominale.Value() \u003c 500) {\n      rapgino = Math.round(Val(this.giocato.Value()) * 10000 \u002f this.nominale.Value());\n      rapgiin = Math.round(Val(this.giocato.Value()) * 10000 \u002f Val(this.introdotto.Value()));\n      rapvino = Math.round(Val(this.vinto.Value()) * 10000 \u002f this.nominale.Value());\n      if (rapgino \u003c= 2000) {\n        adv = true;\n        motivo+='Il rapporto fra il valore complessivo dell\\'importo puntato e il valore nominale &egrave; inferiore al 20%' + '\u003cbr\u002f\u003e\\n';\n      }\n      if (rapgiin \u003c= 2000) {\n        adv = true;\n        motivo+='Il rapporto fra il valore complessivo dell\\'importo puntato e quello dell\\'importo introdotto &egrave; inferiore al 20%' + '\u003cbr\u002f\u003e\\n';\n      }\n      if (rapvino \u003c= 2000) {\n        adv = true;\n        motivo+='Il rapporto fra il valore complessivo dell\\'importo vinto e il valore nominale del ticket &egrave; inferiore al 20%' + '\u003cbr\u002f\u003e\\n';\n      }\n    } else {\n      adv = false;\n      motivo = 'Il valore nominale del ticket risulta inferiore a 400 euro'\n    }  \n  }  \n  if (adv) { \n    this.lblResult.RemoveCssClass('label_verde')\n    this.lblResult.AddCssClass('label_rosso')\n    msg = \"TICKET DA SOTTOPORRE AD ADEGUATA VERIFICA \";\n  } else {\n    this.lblResult.RemoveCssClass('label_rosso')\n    this.lblResult.AddCssClass('label_verde')\n    msg = \"TICKET DA NON SOTTOPORRE AD ADEGUATA VERIFICA\";  \n  }  \n  this.lblMotivo.Value(motivo)\n  this.lblResult.Value(msg) \n}\n\nfunction btnExit_Click(){\n  this.BtnUscita.Link()\n}\n\nfunction introdotto_onChange(){\n  if (!er.test(this.introdotto.Value())) {\n    alert(\"E' necessario inserire un valore numerico nell'importo introdotto\")   \n    this.introdotto.Init('')    \n    this.introdotto.SetFocus()\n  }  \n}\n\nfunction giocato_onChange(){\n  if (!er.test(this.giocato.Value())) {\n    alert(\"E' necessario inserire un valore numerico nell'importo giocato\")   \n    this.giocato.Init('')          \n    this.giocato.SetFocus()\n  }  \n}\n\nfunction vinto_onChange(){\n  if (!er.test(this.vinto.Value())) {\n    alert(\"E' necessario inserire un valore numerico nell'importo vinto lordo\")   \n    this.vinto.Init('')          \n    this.vinto.SetFocus()\n  }  \n}\n\nfunction vintonetto_onChange(){\n  if (!er.test(this.vintonetto.Value())) {\n    alert(\"E' necessario inserire un valore numerico nell'importo vinto netto\")   \n    this.vintonetto.Init('')          \n    this.vintonetto.SetFocus()\n  }  \n}\n\n\u002f\u002f function introdotto_Validate(){\n\u002f\u002f   if (!er.test(this.introdotto.Value())) {\n\u002f\u002f     alert(\"E' necessario inserire un valore numerico nell'importo introdotto\")   \n\u002f\u002f   }  \n\u002f\u002f   return er.test(this.introdotto.Value())\n\u002f\u002f }\n\n\u002f\u002f function giocato_Validate(){\n\u002f\u002f   if (!er.test(this.giocato.Value())) {\n\u002f\u002f     alert(\"E' necessario inserire un valore numerico nell'importo giocato\")   \n\u002f\u002f   }  \n\u002f\u002f   return er.test(this.giocato.Value())  \n\u002f\u002f }\n\n\u002f\u002f function vinto_Validate(){\n\u002f\u002f   if (!er.test(this.vinto.Value())) {\n\u002f\u002f     alert(\"E' necessario inserire un valore numerico nell'importo vinto lordo\")   \n\u002f\u002f   }      \n\u002f\u002f   return er.test(this.vinto.Value())\n\u002f\u002f }\n\n\u002f\u002f function vintonetto_Validate(){\n\u002f\u002f   if (!er.test(this.vintonetto.Value())) {\n\u002f\u002f     alert(\"E' necessario inserire un valore numerico nell'importo vinto netto\")   \n\u002f\u002f   }      \n\u002f\u002f   return er.test(this.vintonetto.Value())\n\u002f\u002f }","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"font_color\":\"#F10913\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label_rosso\",\"selector\":\".label_rosso\",\"value\":\"Valore Giocato:\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".label_rosso {\\n  color: #F10913;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"font_color\":\"#09F11F\",\"code\":\"\\n\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label_verde\",\"selector\":\".label_verde\",\"value\":\"Valore Introdotto:\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".label_verde {\\n  color: #09F11F;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"align\":\"right\",\"code\":\".textbox_right {\\n  text-align: right;\\n}\\n\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"textbox\",\"class_name\":\"textbox_right\",\"selector\":\".textbox_right\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".textbox_right {\\n  text-align: right;\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"320","hsl":"","htmlcode":"{{ introdotto }}\n{{ giocato }}\n{{ vinto }}\n{{ vintonetto }}\n{{ nominale }}\n{{ btnExit }}\n{{ Label1 }}\n{{ lblMotivo }}\n{{ Label2 }}\n{{ Label2_Copy }}\n{{ Label2_Copy_Copy }}\n{{ lblResult }}\n{{ btnElab }}\n{{ Label2_Copy_Copy_Copy }}\n{{ BtnUscita }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"733","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"null","class_Css":"textbox textbox_right","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"introdotto","page":"1","password":"","picture":"999,999,999.99","placeholder":"Minimo: \u20ac 0,00","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"108","wireframe_props":"name","x":"390","y":"19","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"null","class_Css":"textbox textbox_right","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"giocato","page":"1","password":"","picture":"999,999,999.99","placeholder":"Minimo: \u20ac 0,00","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"108","wireframe_props":"name","x":"390","y":"60","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"null","class_Css":"textbox textbox_right","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"vinto","page":"1","password":"","picture":"999,999,999.99","placeholder":"Minimo: \u20ac 0,00","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"108","wireframe_props":"name","x":"390","y":"101","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"null","class_Css":"textbox textbox_right","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"vintonetto","page":"1","password":"","picture":"999,999,999.99","placeholder":"Minimo: \u20ac 0,00","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"108","wireframe_props":"name","x":"390","y":"142","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Val(introdotto) - Val(giocato) + Val(vintonetto)","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"nominale","page":"1","password":"","picture":"999,999,999.99","placeholder":"","readonly":"true","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"108","wireframe_props":"name","x":"390","y":"183","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"6","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"392","y":"219","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label1","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo Introdotto:","w":"185","wireframe_props":"align,value,n_col","x":"201","y":"19","zindex":"2"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMotivo","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"false","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"731","wireframe_props":"align,value,n_col","x":"0","y":"292","zindex":"5"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo Puntato:","w":"185","wireframe_props":"align,value,n_col","x":"201","y":"60","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label2_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo Vinto Lordo:","w":"185","wireframe_props":"align,value,n_col","x":"201","y":"101","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label2_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo Nominale del Ticket:","w":"241","wireframe_props":"align,value,n_col","x":"145","y":"183","zindex":"3"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblResult","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"731","wireframe_props":"align,value,n_col","x":"0","y":"265","zindex":"4"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui la verifica","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"13","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"353","y":"219","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label2_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Importo Vinto Netto:","w":"240","wireframe_props":"align,value,n_col","x":"145","y":"142","zindex":"3"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"start_page_logo_agenzie_portlet.jsp","target":"","type":"SPLinker","w":"93","x":"74","y":"-68"}]%>
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
window.pg_check_vlt_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof introdotto_onChange !='undefined')this.introdotto_onChange=introdotto_onChange;
if(typeof giocato_onChange !='undefined')this.giocato_onChange=giocato_onChange;
if(typeof vinto_onChange !='undefined')this.vinto_onChange=vinto_onChange;
if(typeof vintonetto_onChange !='undefined')this.vintonetto_onChange=vintonetto_onChange;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
ZtVWeb.CalcCtrl(Val(this.introdotto.Value())-Val(this.giocato.Value())+Val(this.vintonetto.Value()),this.nominale);
}
ZtVWeb.InitCtrl(null,this.introdotto);
ZtVWeb.InitCtrl(null,this.giocato);
ZtVWeb.InitCtrl(null,this.vinto);
ZtVWeb.InitCtrl(null,this.vintonetto);
var adv
var motivo
var er = /^[0-9]+\.?[0-9]?[0-9]?$/;
function this_Loaded(){
  this.getTitlePortlet().SetTitle("VERIFICA TICKET VLT TRA € 400 e € 500",true)
}
function btnElab_Click(){
  if (Empty(this.introdotto.Value()) || Empty(this.giocato.Value()) || Empty(this.vinto.Value()) || Empty(this.vintonetto.Value())) {
    if (Empty(this.introdotto.Value())) {
      alert("Inserire un valore nell'importo introdotto")
      this.introdotto.SetFocus()
      return
    }  
    if (Empty(this.giocato.Value())) {
      alert("Inserire un valore nell'importo giocato")
      this.giocato.SetFocus()
      return
    } 
    if (Empty(this.vinto.Value())) {
      alert("Inserire un valore nell'importo vinto lordo")
      this.vinto.SetFocus()
      return
    }  
    if (Empty(this.vintonetto.Value())) {
      alert("Inserire un valore nell'importo vinto netto")
      this.vintonetto.SetFocus()
      return
    }      
  }  
  if ((Val(this.vintonetto.Value()) > Val(this.vinto.Value())) || (Val(this.vintonetto.Value()) == 0 && Val(this.vinto.Value()) > 0) || (Val(this.vintonetto.Value()) > 0 && Val(this.vinto.Value())==0)) {
    alert('Importo vinto netto non congruente con Importo vinto lordo!');
    this.vintonetto.SetFocus()
    return    
  }  
  motivo=''
  msg=''
  this.lblMotivo.Value('')
  this.lblResult.Value('')  
  this.nominale.Value(Val(this.introdotto.Value()) - Val(this.giocato.Value()) + Val(this.vintonetto.Value()));
  if (this.nominale.Value() >= 500) {
    adv = true; 
    motivo = 'Il valore nominale del ticket risulta superiore o uguale a 500 euro';
  } else {
    if (this.nominale.Value() >= 400 && this.nominale.Value() < 500) {
      rapgino = Math.round(Val(this.giocato.Value()) * 10000 / this.nominale.Value());
      rapgiin = Math.round(Val(this.giocato.Value()) * 10000 / Val(this.introdotto.Value()));
      rapvino = Math.round(Val(this.vinto.Value()) * 10000 / this.nominale.Value());
      if (rapgino <= 2000) {
        adv = true;
        motivo+='Il rapporto fra il valore complessivo dell\'importo puntato e il valore nominale &egrave; inferiore al 20%' + '<br/>\n';
      }
      if (rapgiin <= 2000) {
        adv = true;
        motivo+='Il rapporto fra il valore complessivo dell\'importo puntato e quello dell\'importo introdotto &egrave; inferiore al 20%' + '<br/>\n';
      }
      if (rapvino <= 2000) {
        adv = true;
        motivo+='Il rapporto fra il valore complessivo dell\'importo vinto e il valore nominale del ticket &egrave; inferiore al 20%' + '<br/>\n';
      }
    } else {
      adv = false;
      motivo = 'Il valore nominale del ticket risulta inferiore a 400 euro'
    }  
  }  
  if (adv) { 
    this.lblResult.RemoveCssClass('label_verde')
    this.lblResult.AddCssClass('label_rosso')
    msg = "TICKET DA SOTTOPORRE AD ADEGUATA VERIFICA ";
  } else {
    this.lblResult.RemoveCssClass('label_rosso')
    this.lblResult.AddCssClass('label_verde')
    msg = "TICKET DA NON SOTTOPORRE AD ADEGUATA VERIFICA";  
  }  
  this.lblMotivo.Value(motivo)
  this.lblResult.Value(msg) 
}
function btnExit_Click(){
  this.BtnUscita.Link()
}
function introdotto_onChange(){
  if (!er.test(this.introdotto.Value())) {
    alert("E' necessario inserire un valore numerico nell'importo introdotto")   
    this.introdotto.Init('')    
    this.introdotto.SetFocus()
  }  
}
function giocato_onChange(){
  if (!er.test(this.giocato.Value())) {
    alert("E' necessario inserire un valore numerico nell'importo giocato")   
    this.giocato.Init('')          
    this.giocato.SetFocus()
  }  
}
function vinto_onChange(){
  if (!er.test(this.vinto.Value())) {
    alert("E' necessario inserire un valore numerico nell'importo vinto lordo")   
    this.vinto.Init('')          
    this.vinto.SetFocus()
  }  
}
function vintonetto_onChange(){
  if (!er.test(this.vintonetto.Value())) {
    alert("E' necessario inserire un valore numerico nell'importo vinto netto")   
    this.vintonetto.Init('')          
    this.vintonetto.SetFocus()
  }  
}
// function introdotto_Validate(){
//   if (!er.test(this.introdotto.Value())) {
//     alert("E' necessario inserire un valore numerico nell'importo introdotto")   
//   }  
//   return er.test(this.introdotto.Value())
// }
// function giocato_Validate(){
//   if (!er.test(this.giocato.Value())) {
//     alert("E' necessario inserire un valore numerico nell'importo giocato")   
//   }  
//   return er.test(this.giocato.Value())  
// }
// function vinto_Validate(){
//   if (!er.test(this.vinto.Value())) {
//     alert("E' necessario inserire un valore numerico nell'importo vinto lordo")   
//   }      
//   return er.test(this.vinto.Value())
// }
// function vintonetto_Validate(){
//   if (!er.test(this.vintonetto.Value())) {
//     alert("E' necessario inserire un valore numerico nell'importo vinto netto")   
//   }      
//   return er.test(this.vintonetto.Value())
// }
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_check_vlt_container .label_rosso{  color: #F10913;
}
.pg_check_vlt_container .label_verde{
  
  
  color: #09F11F;
}
.pg_check_vlt_container .textbox_right{
  .textbox_right {
    text-align: right;
  }
.pg_check_vlt_container   
  text-align: right;
}
.pg_check_vlt_container {
}
.pg_check_vlt_title_container {
  margin: auto;
}
.pg_check_vlt_portlet{
  position:relative;
  margin: auto;
  width:733px;
  min-width:733px;
  height:320px;
}
.pg_check_vlt_portlet[Data-page="1"]{
  height:320px;
  width:733px;
}
.pg_check_vlt_portlet > .introdotto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:19px;
  left:390px;
  width:108px;
  height:20px;
}
.pg_check_vlt_portlet > .introdotto_ctrl {
}
.pg_check_vlt_portlet > .introdotto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_check_vlt_portlet > .giocato_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:390px;
  width:108px;
  height:20px;
}
.pg_check_vlt_portlet > .giocato_ctrl {
}
.pg_check_vlt_portlet > .giocato_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_check_vlt_portlet > .vinto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:101px;
  left:390px;
  width:108px;
  height:20px;
}
.pg_check_vlt_portlet > .vinto_ctrl {
}
.pg_check_vlt_portlet > .vinto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_check_vlt_portlet > .vintonetto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:142px;
  left:390px;
  width:108px;
  height:20px;
}
.pg_check_vlt_portlet > .vintonetto_ctrl {
}
.pg_check_vlt_portlet > .vintonetto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_check_vlt_portlet > .nominale_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:183px;
  left:390px;
  width:108px;
  height:20px;
}
.pg_check_vlt_portlet > .nominale_ctrl {
}
.pg_check_vlt_portlet > .nominale_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_check_vlt_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:219px;
  right:311px;
  width:30px;
  height:30px;
}
.pg_check_vlt_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_check_vlt_portlet > .Label1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:19px;
  left:201px;
  width:185px;
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label1_ctrl {
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label1_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_check_vlt_portlet > .lblMotivo_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:292px;
  left:0px;
  width:731px;
  height:auto;
  min-height:22px;
}
.pg_check_vlt_portlet > .lblMotivo_ctrl {
  height:auto;
  min-height:22px;
}
.pg_check_vlt_portlet > .lblMotivo_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_check_vlt_portlet > .Label2_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:60px;
  left:201px;
  width:185px;
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_check_vlt_portlet > .Label2_Copy_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:101px;
  left:201px;
  width:185px;
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_check_vlt_portlet > .Label2_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:183px;
  left:145px;
  width:241px;
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_check_vlt_portlet > .lblResult_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:265px;
  left:0px;
  width:731px;
  height:auto;
  min-height:22px;
}
.pg_check_vlt_portlet > .lblResult_ctrl {
  height:auto;
  min-height:22px;
}
.pg_check_vlt_portlet > .lblResult_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_check_vlt_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:219px;
  right:350px;
  width:30px;
  height:30px;
}
.pg_check_vlt_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_check_vlt_portlet > .Label2_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:142px;
  left:145px;
  width:240px;
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_check_vlt_portlet > .Label2_Copy_Copy_Copy_ctrl {
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
 String def="[{\"h\":\"320\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"733\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"introdotto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"390\",\"y\":\"19\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"giocato\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"390\",\"y\":\"60\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vinto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"390\",\"y\":\"101\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vintonetto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"390\",\"y\":\"142\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nominale\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"390\",\"y\":\"183\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"392\",\"y\":\"219\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importo Introdotto:\",\"w\":\"185\",\"x\":\"201\",\"y\":\"19\",\"zindex\":\"2\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMotivo\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"731\",\"x\":\"0\",\"y\":\"292\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importo Puntato:\",\"w\":\"185\",\"x\":\"201\",\"y\":\"60\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importo Vinto Lordo:\",\"w\":\"185\",\"x\":\"201\",\"y\":\"101\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importo Nominale del Ticket:\",\"w\":\"241\",\"x\":\"145\",\"y\":\"183\",\"zindex\":\"3\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblResult\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"731\",\"x\":\"0\",\"y\":\"265\",\"zindex\":\"4\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"353\",\"y\":\"219\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importo Vinto Netto:\",\"w\":\"240\",\"x\":\"145\",\"y\":\"142\",\"zindex\":\"3\"},{\"h\":\"30\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"74\",\"y\":\"-68\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_check_vlt","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_check_vlt_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_check_vlt','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String introdotto= "";
if(request.getAttribute("pg_check_vlt_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String giocato= "";
String vinto= "";
String vintonetto= "";
double nominale= 0;
String Label1= "Importo Introdotto:";
String lblMotivo= "";
String Label2= "Importo Puntato:";
String Label2_Copy= "Importo Vinto Lordo:";
String Label2_Copy_Copy= "Importo Nominale del Ticket:";
String lblResult= "";
String Label2_Copy_Copy_Copy= "Importo Vinto Netto:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_check_vlt_title_container' style='width:733px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_check_vlt_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_check_vlt_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_check_vlt','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_introdotto_wrp'><input id='<%=idPortlet%>_introdotto' name='introdotto' type='text' maxlength='10' class='textbox textbox_right' formid='<%=idPortlet%>' ps-name='introdotto' data-sp-item-say-pict='999,999,999.99' data-sp-item-get-pict='999,999,999.99' data-sp-item-dec='2' placeholder=' '/>
<label for=<%=idPortlet%>_introdotto>Minimo: € 0,00</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_giocato_wrp'><input id='<%=idPortlet%>_giocato' name='giocato' type='text' maxlength='10' class='textbox textbox_right' formid='<%=idPortlet%>' ps-name='giocato' data-sp-item-say-pict='999,999,999.99' data-sp-item-get-pict='999,999,999.99' data-sp-item-dec='2' placeholder=' '/>
<label for=<%=idPortlet%>_giocato>Minimo: € 0,00</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_vinto_wrp'><input id='<%=idPortlet%>_vinto' name='vinto' type='text' maxlength='10' class='textbox textbox_right' formid='<%=idPortlet%>' ps-name='vinto' data-sp-item-say-pict='999,999,999.99' data-sp-item-get-pict='999,999,999.99' data-sp-item-dec='2' placeholder=' '/>
<label for=<%=idPortlet%>_vinto>Minimo: € 0,00</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_vintonetto_wrp'><input id='<%=idPortlet%>_vintonetto' name='vintonetto' type='text' maxlength='10' class='textbox textbox_right' formid='<%=idPortlet%>' ps-name='vintonetto' data-sp-item-say-pict='999,999,999.99' data-sp-item-get-pict='999,999,999.99' data-sp-item-dec='2' placeholder=' '/>
<label for=<%=idPortlet%>_vintonetto>Minimo: € 0,00</label></span>
<span class='textbox-container'id='<%=idPortlet%>_nominale_wrp'><input id='<%=idPortlet%>_nominale' name='nominale' type='text' disabled maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='nominale' data-sp-item-say-pict='999,999,999.99' data-sp-item-get-pict='999,999,999.99' data-sp-item-dec='2' inputmode='numeric' /></span>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<span id='<%=idPortlet%>_Label1'  formid='<%=idPortlet%>' ps-name='Label1'    class='label Label1_ctrl'><div id='<%=idPortlet%>_Label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Importo Introdotto:")%></div></span>
<span id='<%=idPortlet%>_lblMotivo'  formid='<%=idPortlet%>' ps-name='lblMotivo'    class='label lblMotivo_ctrl'><div id='<%=idPortlet%>_lblMotivotbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_Label2'  formid='<%=idPortlet%>' ps-name='Label2'    class='label Label2_ctrl'><div id='<%=idPortlet%>_Label2tbl' style='width:100%;'><%=JSPLib.ToHTML("Importo Puntato:")%></div></span>
<span id='<%=idPortlet%>_Label2_Copy'  formid='<%=idPortlet%>' ps-name='Label2_Copy'    class='label Label2_Copy_ctrl'><div id='<%=idPortlet%>_Label2_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Importo Vinto Lordo:")%></div></span>
<span id='<%=idPortlet%>_Label2_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label2_Copy_Copy'    class='label Label2_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label2_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Importo Nominale del Ticket:")%></div></span>
<span id='<%=idPortlet%>_lblResult'  formid='<%=idPortlet%>' ps-name='lblResult'    class='label lblResult_ctrl'><div id='<%=idPortlet%>_lblResulttbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<span id='<%=idPortlet%>_Label2_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label2_Copy_Copy_Copy'    class='label Label2_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label2_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Importo Vinto Netto:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_check_vlt');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_check_vlt',["733"],["320"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"733","h":"320","title":"","layer":"false","npage":"1"}]);
this.introdotto=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"null","create_undercond":"","ctrlid":"<%=idPortlet%>_introdotto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"introdotto","page":1,"picker":"","picture":"999,999,999.99","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(introdotto,false,true)%>","w":108,"x":390,"y":19,"zerofilling":false,"zindex":"1","zoom":""});
this.giocato=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"null","create_undercond":"","ctrlid":"<%=idPortlet%>_giocato","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"giocato","page":1,"picker":"","picture":"999,999,999.99","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(giocato,false,true)%>","w":108,"x":390,"y":60,"zerofilling":false,"zindex":"1","zoom":""});
this.vinto=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"null","create_undercond":"","ctrlid":"<%=idPortlet%>_vinto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"vinto","page":1,"picker":"","picture":"999,999,999.99","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(vinto,false,true)%>","w":108,"x":390,"y":101,"zerofilling":false,"zindex":"1","zoom":""});
this.vintonetto=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"null","create_undercond":"","ctrlid":"<%=idPortlet%>_vintonetto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"vintonetto","page":1,"picker":"","picture":"999,999,999.99","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(vintonetto,false,true)%>","w":108,"x":390,"y":142,"zerofilling":false,"zindex":"1","zoom":""});
this.nominale=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Val(this.introdotto.Value())-Val(this.giocato.Value())+Val(this.vintonetto.Value())","create_undercond":"","ctrlid":"<%=idPortlet%>_nominale","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"nominale","page":1,"picker":"","picture":"999,999,999.99","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=nominale%>","w":108,"x":390,"y":183,"zerofilling":false,"zindex":"1","zoom":""});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":392,"y":219,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label1","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label1,false,true)%>","type":"Label","w":185,"x":201,"y":19,"zindex":"2"});
this.lblMotivo=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMotivo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMotivo","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"false","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMotivo,false,true)%>","type":"Label","w":731,"x":0,"y":292,"zindex":"5"});
this.Label2=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label2,false,true)%>","type":"Label","w":185,"x":201,"y":60,"zindex":"3"});
this.Label2_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label2_Copy,false,true)%>","type":"Label","w":185,"x":201,"y":101,"zindex":"3"});
this.Label2_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label2_Copy_Copy,false,true)%>","type":"Label","w":241,"x":145,"y":183,"zindex":"3"});
this.lblResult=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblResult","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblResult","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblResult,false,true)%>","type":"Label","w":731,"x":0,"y":265,"zindex":"4"});
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui la verifica",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":353,"y":219,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label2_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label2_Copy_Copy_Copy,false,true)%>","type":"Label","w":240,"x":145,"y":142,"zindex":"3"});
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_agenzie_portlet.jsp","target":"","type":"SPLinker","w":93,"x":74,"y":-68});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_agenzie_portlet.jsp",request.getSession())%>';
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
<%if(request.getAttribute("pg_check_vlt_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_check_vlt_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_check_vlt_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_check_vlt',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_check_vlt');
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
sp.endPage("pg_check_vlt");
}%>
<%! public String getJSPUID() { return "848135007"; } %>