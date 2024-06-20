<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.usercode.Value(this.codeuser.Value())\nif (this.usercode.Value() != 0) {\n  this.SQLUserData.Query()\n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Gestione Utente\",true)\n  this.getTitlePortlet().AppendButton({id:\"Salva\",\n    title:FormatMsg('Salva'),\n    tooltip:FormatMsg(\"Salva i dati\"),\n    image:{fontFamily:'icons8_win10', value: \"&#xecb3;\"},\n    action:'javascript:' + this.formid +'.Salva()'\n  },1);   \n  if (this.usercode.Value() != 0) {   \n    this.getTitlePortlet().AppendButton({\n    \tid:\"Reset\",\n  \t  title:FormatMsg('Reset OTP'),\n  \t  tooltip:FormatMsg(\"Reset OTP\"),\n  \t  image:{fontFamily:'icons8_win10', value: \"&#xf2bf;\"},\n  \t  action:'javascript:' + this.formid +'.Reset()'\n\t  },2);     \n  }\n  this.getTitlePortlet().AppendButton({\n  \tid:\"Uscita\",\n  \ttitle:FormatMsg('Uscita'),\n  \ttooltip:FormatMsg('Chiude la finestra senza salvare'),\n  \timage:{fontFamily:'icons8_win10', value: \"&#xed93;\"},\n  \taction:'javascript:' + this.formid +'.Annulla()'\n\t},3); \n}\n\nfunction Salva() {\n  if (confirm('Confermi il salvataggio dei dati?')) {\n    this.SPSalva.Link()\n    this.SalvaAgente.Emit()\n  }  \n}  \n\nfunction Annulla() {\n  if (confirm('Confermi la chiusura della maschera?')) {\n    window.close()\n  }    \n}  \n\nfunction Reset() {\n  if (confirm(\"Confermi il reset dell'OTP per l'utente?\")) {\n    this.SPResetOTP.Link()\n  }    \n}  \n\nfunction SPSalva_Executed(result,cError){\n  if(result=='KO') {\n    alert(cError+\" - Contattare HelpDesk\")  \n  } else {  \n    if(result=='OK') {\n      alert('Nuovo utente salvato correttamente!')\n      window.close()    \n    }  \n    if(result=='PWD') {\n      alert('Password resettata correttamente!')\n      window.close()    \n    }  \n    if(result=='USR') {\n      alert('Utente già utilizzato. Inserirne uno diverso')\n    }  \n    if(result=='EMP') {\n      alert('Impossibile inserire un nuovo utente con Utente vuoto!')\n    }      \n    if(result=='AGE') {\n      alert(\"Impossibile modificare un utente di un'altra agenzia!\")\n      window.close() \n    }      \n    if(result=='DIS') {\n      if(this.chkDisable.Value()=='D'){\n        alert('Utente disabilitato correttamente!')\n        window.close()    \n      } else {\n        alert('Utente abilitato correttamente!')\n        window.close()            \n      }  \n    }  \n  } \n}\n\nfunction SPResetOTP_Executed(result,cError){  \n  if(result=='KO') {\n    alert(cError+\" - Contattare HelpDesk\")  \n  } else {  \n    if(result=='OTP') {\n      alert('OTP resettato correttamente!')\n      window.close()    \n    }  \n  }  \n}\n\nfunction imgGen_Click(){\n    var length = this.lunpas.Value(),\n        charset = \"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?.,\",\n        retVal = \"\";\n    for (var i = 0, n = charset.length; i \u003c length; ++i) {\n        retVal += charset.charAt(Math.floor(Math.random() * n));\n    }\n    this.newpasswd.Value(retVal);\n}\n\nfunction SQLUserData_ConsumersRendered(){\n  if(this.SQLUserData.GetQueryCount()==0) {\n    alert(\"Impossibile modificare un utente di un'altra agenzia!\")\n    window.close()\n  }    \n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"190","hsl":"","htmlcode":"{{ @imgGen }}\n{{ @lNewPass }}\n{{ @newpasswd }}\n{{ @lLunPas }}\n{{ @lunpas }}\n{{ @lCodice }}\n{{ @usercode }}\n{{ @chkReset }}\n{{ @chkDisable }}\n{{ @lUtente }}\n{{ @utente }}\n{{ @lNome }}\n{{ @nomeutente }}\n{{ newpasswd }}\n{{ lNewPass }}\n{{ chkDisable }}\n{{ SPResetOTP }}\n{{ lCodice }}\n{{ lUtente }}{{ SalvaAgente }}{{ SQLUserData }}\n{{ usercode }}{{ {{ SPSalva }}lUtente }}\n{{ nomeutente }}{{ lNome }}{{ utente }}{{ ch{{{{ Image13 }} Label12 }}kDisable }}{{ chkReset }}{{ usercode }}{{ btnAzzOTP }}{{ Image12 }}{{ lunpas }}{{ lLunPas }}{{ imgGen }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"666","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLUserData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"fullname","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"60","name":"nomeutente","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"476","wireframe_props":"name","x":"161","y":"46","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lNome","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nominativo:","w":"154","wireframe_props":"align,value,n_col","x":"2","y":"48","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLUserData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"name","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"50","name":"utente","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"161","y":"84","zerofilling":"false","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lUtente","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Utente:","w":"154","wireframe_props":"align,value,n_col","x":"2","y":"84","zindex":"2"},{"anchor":"","calculate":"","checked_value":"D","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"SQLUserData","edit_undercond":"","field":"enabled","h":"20","help_tips":"","hide":"false","hide_undercond":"usercode=0","init":"","init_par":"","label_text":"Disabilitato","layer":"false","layout_steps_values":"{}","name":"chkDisable","page":"1","sequence":"5","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"E","w":"120","wireframe_props":"label_text","x":"161","y":"123","zindex":"5"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"usercode=0","init":"","init_par":"N","label_text":"Resetta la password","layer":"false","layout_steps_values":"{}","name":"chkReset","page":"1","sequence":"6","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"166","wireframe_props":"label_text","x":"375","y":"123","zindex":"6"},{"allowedentities":"arfn_save_user_agency","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"pCode","decrypted_parms_pwd":"cippa","entity_type":"routine","h":"20","m_cAction":"function","name":"SPSalva","offline":"false","page":"1","parms":"pCode=codice,pName=nomeutente,pUser=utente,pDisable=chkDisable,pResetPWD=chkReset,pResetOTP=N,pNewPwd=newpasswd","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arfn_save_user_agency","target":"","type":"SPLinker","w":"120","x":"168","y":"-60"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"SalvaAgente","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"8","type":"EventEmitter","w":"120","x":"726","y":"-59"},{"allowedqueries":"qbe_user_data","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"utente","encrypted_fields_pwd":"cippa","h":"20","localDBName":"","n_records":"1","name":"SQLUserData","offline":"false","page":"1","parms":"pcode=usercode","parms_source":"","query":"qbe_user_data","query_async":"true","return_fields_type":"true","sequence":"9","type":"SQLDataobj","w":"120","x":"341","y":"-60"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"10","name":"usercode","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"89","wireframe_props":"name","x":"162","y":"10","zerofilling":"false","zindex":"7"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lCodice","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice:","w":"154","wireframe_props":"align,value,n_col","x":"2","y":"10","zindex":"2"},{"allowedentities":"arfn_save_user_agency","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"pCode","decrypted_parms_pwd":"cippa","entity_type":"routine","h":"20","m_cAction":"function","name":"SPResetOTP","offline":"false","page":"1","parms":"pCode=codice,pName=nomeutente,pUser=utente,pDisable=chkDisable,pResetPWD=chkReset,pResetOTP=S,pNewPwd=newpasswd","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arfn_save_user_agency","target":"","type":"SPLinker","w":"120","x":"28","y":"-58"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"8","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"2","name":"lunpas","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"26","wireframe_props":"name","x":"163","y":"159","zerofilling":"false","zindex":"8"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"Inserire la lunghezza della password","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lLunPas","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Lung. Password:","w":"154","wireframe_props":"align,value,n_col","x":"2","y":"159","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"20","name":"newpasswd","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"375","y":"159","zerofilling":"false","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lNewPass","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nuova Password:","w":"154","wireframe_props":"align,value,n_col","x":"217","y":"159","zindex":"2"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb49;","font_image_hover":"&#xeb4c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"Premere il bottone per generare la nuova password","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"imgGen","page":"1","path_type":"","sequence":"17","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"536","y":"159","zindex":"9"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"true","decrypt_pwd":"cippa","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"codeuser","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"506","y":"-57"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLUserData","decrypt":"","decrypt_pwd":"","encrypt":"true","encrypt_pwd":"cippa","field":"utente","h":"20","init":"","init_par":"","name":"codice","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"729","y":"-14"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:codeuser*/%>
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
window.pg_user_agency_edit_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Salva !='undefined')this.Salva=Salva;
if(typeof Annulla !='undefined')this.Annulla=Annulla;
if(typeof Reset !='undefined')this.Reset=Reset;
if(typeof SPSalva_Executed !='undefined')this.SPSalva_Executed=SPSalva_Executed;
if(typeof SPResetOTP_Executed !='undefined')this.SPResetOTP_Executed=SPResetOTP_Executed;
if(typeof imgGen_Click !='undefined')this.imgGen_Click=imgGen_Click;
if(typeof SQLUserData_ConsumersRendered !='undefined')this.SQLUserData_ConsumersRendered=SQLUserData_ConsumersRendered;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.usercode.Value(),0),this.chkDisable);
ZtVWeb.HideCtrl(Eq(this.usercode.Value(),0),this.chkReset);
ZtVWeb.HideCtrl(Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0),this.lunpas);
ZtVWeb.HideCtrl(Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0),this.lLunPas);
ZtVWeb.HideCtrl(Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0),this.newpasswd);
ZtVWeb.HideCtrl(Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0),this.lNewPass);
ZtVWeb.HideCtrl(Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0),this.imgGen);
}
ZtVWeb.InitCtrl(8,this.lunpas);
this.SQLUserData.addDataConsumer(this.nomeutente,<%=JSPLib.ToJSValue("fullname",true)%>);
this.SQLUserData.addDataConsumer(this.utente,<%=JSPLib.ToJSValue("name",true)%>);
this.SQLUserData.addDataConsumer(this.chkDisable,'enabled');
this.SQLUserData.addDataConsumer(this.codice,<%=JSPLib.ToJSValue("utente",true)%>);
this.usercode.Value(this.codeuser.Value())
if (this.usercode.Value() != 0) {
  this.SQLUserData.Query()
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Gestione Utente",true)
  this.getTitlePortlet().AppendButton({id:"Salva",
    title:FormatMsg('Salva'),
    tooltip:FormatMsg("Salva i dati"),
    image:{fontFamily:'icons8_win10', value: "&#xecb3;"},
    action:'javascript:' + this.formid +'.Salva()'
  },1);   
  if (this.usercode.Value() != 0) {   
    this.getTitlePortlet().AppendButton({
    	id:"Reset",
  	  title:FormatMsg('Reset OTP'),
  	  tooltip:FormatMsg("Reset OTP"),
  	  image:{fontFamily:'icons8_win10', value: "&#xf2bf;"},
  	  action:'javascript:' + this.formid +'.Reset()'
	  },2);     
  }
  this.getTitlePortlet().AppendButton({
  	id:"Uscita",
  	title:FormatMsg('Uscita'),
  	tooltip:FormatMsg('Chiude la finestra senza salvare'),
  	image:{fontFamily:'icons8_win10', value: "&#xed93;"},
  	action:'javascript:' + this.formid +'.Annulla()'
	},3); 
}
function Salva() {
  if (confirm('Confermi il salvataggio dei dati?')) {
    this.SPSalva.Link()
    this.SalvaAgente.Emit()
  }  
}  
function Annulla() {
  if (confirm('Confermi la chiusura della maschera?')) {
    window.close()
  }    
}  
function Reset() {
  if (confirm("Confermi il reset dell'OTP per l'utente?")) {
    this.SPResetOTP.Link()
  }    
}  
function SPSalva_Executed(result,cError){
  if(result=='KO') {
    alert(cError+" - Contattare HelpDesk")  
  } else {  
    if(result=='OK') {
      alert('Nuovo utente salvato correttamente!')
      window.close()    
    }  
    if(result=='PWD') {
      alert('Password resettata correttamente!')
      window.close()    
    }  
    if(result=='USR') {
      alert('Utente già utilizzato. Inserirne uno diverso')
    }  
    if(result=='EMP') {
      alert('Impossibile inserire un nuovo utente con Utente vuoto!')
    }      
    if(result=='AGE') {
      alert("Impossibile modificare un utente di un'altra agenzia!")
      window.close() 
    }      
    if(result=='DIS') {
      if(this.chkDisable.Value()=='D'){
        alert('Utente disabilitato correttamente!')
        window.close()    
      } else {
        alert('Utente abilitato correttamente!')
        window.close()            
      }  
    }  
  } 
}
function SPResetOTP_Executed(result,cError){  
  if(result=='KO') {
    alert(cError+" - Contattare HelpDesk")  
  } else {  
    if(result=='OTP') {
      alert('OTP resettato correttamente!')
      window.close()    
    }  
  }  
}
function imgGen_Click(){
    var length = this.lunpas.Value(),
        charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?.,",
        retVal = "";
    for (var i = 0, n = charset.length; i < length; ++i) {
        retVal += charset.charAt(Math.floor(Math.random() * n));
    }
    this.newpasswd.Value(retVal);
}
function SQLUserData_ConsumersRendered(){
  if(this.SQLUserData.GetQueryCount()==0) {
    alert("Impossibile modificare un utente di un'altra agenzia!")
    window.close()
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
.pg_user_agency_edit_container {
}
.pg_user_agency_edit_title_container {
  margin: auto;
}
.pg_user_agency_edit_portlet{
  position:relative;
  margin: auto;
  width:666px;
  min-width:666px;
  height:190px;
}
.pg_user_agency_edit_portlet[Data-page="1"]{
  height:190px;
  width:666px;
}
.pg_user_agency_edit_portlet > .nomeutente_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:161px;
  width:476px;
  height:22px;
}
.pg_user_agency_edit_portlet > .nomeutente_ctrl {
}
.pg_user_agency_edit_portlet > .nomeutente_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_user_agency_edit_portlet > .lNome_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:48px;
  left:2px;
  width:154px;
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lNome_ctrl {
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lNome_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_user_agency_edit_portlet > .utente_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:84px;
  left:161px;
  width:375px;
  height:20px;
}
.pg_user_agency_edit_portlet > .utente_ctrl {
}
.pg_user_agency_edit_portlet > .utente_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_user_agency_edit_portlet > .lUtente_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:84px;
  left:2px;
  width:154px;
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lUtente_ctrl {
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lUtente_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_user_agency_edit_portlet > .chkDisable_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:123px;
  left:161px;
  width:120px;
  height:20px;
}
.pg_user_agency_edit_portlet > .chkReset_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:123px;
  left:375px;
  width:166px;
  height:20px;
}
.pg_user_agency_edit_portlet > .usercode_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:10px;
  left:162px;
  width:89px;
  height:20px;
}
.pg_user_agency_edit_portlet > .usercode_ctrl {
}
.pg_user_agency_edit_portlet > .usercode_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_user_agency_edit_portlet > .lCodice_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:10px;
  left:2px;
  width:154px;
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lCodice_ctrl {
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lCodice_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_user_agency_edit_portlet > .lunpas_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:159px;
  left:163px;
  width:26px;
  height:20px;
}
.pg_user_agency_edit_portlet > .lunpas_ctrl {
  display:none;
}
.pg_user_agency_edit_portlet > .lunpas_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_user_agency_edit_portlet > .lLunPas_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:159px;
  left:2px;
  width:154px;
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lLunPas_ctrl {
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lLunPas_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_user_agency_edit_portlet > .newpasswd_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:159px;
  left:375px;
  width:150px;
  height:20px;
}
.pg_user_agency_edit_portlet > .newpasswd_ctrl {
  display:none;
}
.pg_user_agency_edit_portlet > .newpasswd_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_user_agency_edit_portlet > .lNewPass_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:159px;
  left:217px;
  width:154px;
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lNewPass_ctrl {
  height:auto;
  min-height:20px;
}
.pg_user_agency_edit_portlet > .lNewPass_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_user_agency_edit_portlet > .imgGen_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:159px;
  left:536px;
  width:20px;
  height:20px;
}
.pg_user_agency_edit_portlet > .imgGen_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
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
 String def="[{\"h\":\"190\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"666\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"nomeutente\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"476\",\"x\":\"161\",\"y\":\"46\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lNome\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nominativo:\",\"w\":\"154\",\"x\":\"2\",\"y\":\"48\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"utente\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"161\",\"y\":\"84\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lUtente\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Utente:\",\"w\":\"154\",\"x\":\"2\",\"y\":\"84\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Disabilitato\",\"layout_steps_values\":{},\"name\":\"chkDisable\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"120\",\"x\":\"161\",\"y\":\"123\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Resetta la password\",\"layout_steps_values\":{},\"name\":\"chkReset\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"166\",\"x\":\"375\",\"y\":\"123\",\"zindex\":\"6\"},{\"h\":\"20\",\"name\":\"SPSalva\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"168\",\"y\":\"-60\"},{\"h\":\"20\",\"name\":\"SalvaAgente\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"120\",\"x\":\"726\",\"y\":\"-59\"},{\"h\":\"20\",\"name\":\"SQLUserData\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"341\",\"y\":\"-60\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"usercode\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"89\",\"x\":\"162\",\"y\":\"10\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lCodice\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice:\",\"w\":\"154\",\"x\":\"2\",\"y\":\"10\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"SPResetOTP\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"28\",\"y\":\"-58\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"lunpas\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"26\",\"x\":\"163\",\"y\":\"159\",\"zindex\":\"8\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lLunPas\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Lung. Password:\",\"w\":\"154\",\"x\":\"2\",\"y\":\"159\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"newpasswd\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"375\",\"y\":\"159\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lNewPass\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nuova Password:\",\"w\":\"154\",\"x\":\"217\",\"y\":\"159\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"imgGen\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"536\",\"y\":\"159\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"codeuser\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"506\",\"y\":\"-57\"},{\"h\":\"20\",\"name\":\"codice\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"729\",\"y\":\"-14\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_user_agency_edit","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_user_agency_edit_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_user_agency_edit','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomeutente= "";
if(request.getAttribute("pg_user_agency_edit_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lNome= "Nominativo:";
String utente= "";
String lUtente= "Utente:";
String chkDisable= "";
String chkReset="N";
double usercode= 0;
String lCodice= "Codice:";
double lunpas= 0;
String lLunPas= "Lung. Password:";
String newpasswd= "";
String lNewPass= "Nuova Password:";
String codeuser_enc=JSPLib.translateXSS(sp.getParameter("codeuser",""));
double codeuser = JSPLib.decryptNumber(codeuser_enc,request,"cippa");
double codice= 0;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_user_agency_edit_title_container' style='width:666px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_user_agency_edit_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_user_agency_edit_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_user_agency_edit','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomeutente_wrp'><input id='<%=idPortlet%>_nomeutente' name='nomeutente' type='text' maxlength='60' class='textbox' formid='<%=idPortlet%>' ps-name='nomeutente' /></span>
<span id='<%=idPortlet%>_lNome'  formid='<%=idPortlet%>' ps-name='lNome'    class='label lNome_ctrl'><div id='<%=idPortlet%>_lNometbl' style='width:100%;'><%=JSPLib.ToHTML("Nominativo:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_utente_wrp'><input id='<%=idPortlet%>_utente' name='utente' type='text' maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='utente' /></span>
<span id='<%=idPortlet%>_lUtente'  formid='<%=idPortlet%>' ps-name='lUtente'    class='label lUtente_ctrl'><div id='<%=idPortlet%>_lUtentetbl' style='width:100%;'><%=JSPLib.ToHTML("Utente:")%></div></span>
<div id='<%=idPortlet%>_chkDisable_div' style='display:none;'><input id='<%=idPortlet%>_chkDisable' name='chkDisable' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkDisable' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Disabilitato")%></label></div>
<div id='<%=idPortlet%>_chkReset_div' style='display:none;'><input id='<%=idPortlet%>_chkReset' name='chkReset' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkReset' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Resetta la password")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_usercode_wrp'><input id='<%=idPortlet%>_usercode' name='usercode' type='text' disabled maxlength='10' class='textbox' formid='<%=idPortlet%>' ps-name='usercode' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lCodice'  formid='<%=idPortlet%>' ps-name='lCodice'    class='label lCodice_ctrl'><div id='<%=idPortlet%>_lCodicetbl' style='width:100%;'><%=JSPLib.ToHTML("Codice:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_lunpas_wrp'><input id='<%=idPortlet%>_lunpas' name='lunpas' type='text' maxlength='2' class='textbox' formid='<%=idPortlet%>' ps-name='lunpas' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lLunPas'  formid='<%=idPortlet%>' ps-name='lLunPas'    class='label lLunPas_ctrl'><div id='<%=idPortlet%>_lLunPastbl' style='width:100%;'><%=JSPLib.ToHTML("Lung. Password:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_newpasswd_wrp'><input id='<%=idPortlet%>_newpasswd' name='newpasswd' type='text' disabled maxlength='20' class='textbox' formid='<%=idPortlet%>' ps-name='newpasswd' /></span>
<span id='<%=idPortlet%>_lNewPass'  formid='<%=idPortlet%>' ps-name='lNewPass'    class='label lNewPass_ctrl'><div id='<%=idPortlet%>_lNewPasstbl' style='width:100%;'><%=JSPLib.ToHTML("Nuova Password:")%></div></span>
<a id='<%=idPortlet%>_imgGen' class='image-default imgGen_ctrl'   target=''>&#xeb49;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_user_agency_edit');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Chiude la finestra senza salvare",true)+","+JSPLib.ToJSValue(sp.translate("Chiude la finestra senza salvare"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Reset OTP",true)+","+JSPLib.ToJSValue(sp.translate("Reset OTP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Salva",true)+","+JSPLib.ToJSValue(sp.translate("Salva"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Salva i dati",true)+","+JSPLib.ToJSValue(sp.translate("Salva i dati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Uscita",true)+","+JSPLib.ToJSValue(sp.translate("Uscita"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_user_agency_edit',["666"],["190"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"666","h":"190","title":"","layer":"false","npage":"1"}]);
this.nomeutente=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomeutente","decrypt":false,"edit_undercond":"","encrypt":false,"field":"fullname","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"60","name":"nomeutente","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomeutente,false,true)%>","w":476,"x":161,"y":46,"zerofilling":false,"zindex":"1","zoom":""});
this.lNome=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lNome","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lNome","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lNome,false,true)%>","type":"Label","w":154,"x":2,"y":48,"zindex":"2"});
this.utente=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_utente","decrypt":false,"edit_undercond":"","encrypt":false,"field":"name","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"utente","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(utente,false,true)%>","w":375,"x":161,"y":84,"zerofilling":false,"zindex":"3","zoom":""});
this.lUtente=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lUtente","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lUtente","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lUtente,false,true)%>","type":"Label","w":154,"x":2,"y":84,"zindex":"2"});
this.chkDisable=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"D","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkDisable","decrypt":false,"edit_undercond":"","encrypt":false,"field":"enabled","h":20,"hide":"false","hide_undercond":"Eq(this.usercode.Value(),0)","init":"","init_par":"","label_text":"Disabilitato","layer":false,"layout_steps_values":{},"name":"chkDisable","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"E","w":120,"x":161,"y":123,"zindex":"5"});
this.chkReset=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkReset","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"Eq(this.usercode.Value(),0)","init":"","init_par":"N","label_text":"Resetta la password","layer":false,"layout_steps_values":{},"name":"chkReset","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":166,"x":375,"y":123,"zindex":"6"});
this.chkReset.Value('<%=chkReset%>');
this.SPSalva=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_save_user_agency",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPSalva","decrypted_parms":"pCode","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPSalva","offline":false,"page":1,"parms":"pCode=codice,pName=nomeutente,pUser=utente,pDisable=chkDisable,pResetPWD=chkReset,pResetOTP=N,pNewPwd=newpasswd","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_save_user_agency","target":"","type":"SPLinker","w":120,"x":168,"y":-60});
this.SPSalva.decrypted_parms ='<%=JSPLib.encrypt("pCode,cippa",request,"xxxx")%>';
this.SPSalva.m_cID='<%=JSPLib.cmdHash("routine,arfn_save_user_agency"+"pCode,cippa",request.getSession())%>';
this.SalvaAgente=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SalvaAgente","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"SalvaAgente","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":120,"x":726,"y":-59});
this.SQLUserData=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_user_data",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"qbe_user_data","cmdHash":"<%=JSPLib.cmdHash("qbe_user_datautente,cippa",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLUserData","decrypted_parms":"","encrypted_fields":"utente","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLUserData","nrows":"1","page":1,"parms":"pcode=usercode","parms_source":"","type":"SQLDataobj","w":120,"x":341,"y":-60});
this.SQLUserData.encrypted_fields ='<%=JSPLib.encrypt("utente,cippa",request,"xxxx")%>';
this.usercode=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_usercode","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"10","name":"usercode","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=usercode%>","w":89,"x":162,"y":10,"zerofilling":false,"zindex":"7","zoom":""});
this.lCodice=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lCodice","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lCodice","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lCodice,false,true)%>","type":"Label","w":154,"x":2,"y":10,"zindex":"2"});
this.SPResetOTP=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_save_user_agency",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPResetOTP","decrypted_parms":"pCode","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPResetOTP","offline":false,"page":1,"parms":"pCode=codice,pName=nomeutente,pUser=utente,pDisable=chkDisable,pResetPWD=chkReset,pResetOTP=S,pNewPwd=newpasswd","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_save_user_agency","target":"","type":"SPLinker","w":120,"x":28,"y":-58});
this.SPResetOTP.decrypted_parms ='<%=JSPLib.encrypt("pCode,cippa",request,"xxxx")%>';
this.SPResetOTP.m_cID='<%=JSPLib.cmdHash("routine,arfn_save_user_agency"+"pCode,cippa",request.getSession())%>';
this.lunpas=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"8","create_undercond":"","ctrlid":"<%=idPortlet%>_lunpas","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0)","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"2","name":"lunpas","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=lunpas%>","w":26,"x":163,"y":159,"zerofilling":false,"zindex":"8","zoom":""});
this.lLunPas=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lLunPas","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"<%=JSPLib.ToJSValue("Inserire la lunghezza della password",false,true)%>","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lLunPas","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lLunPas,false,true)%>","type":"Label","w":154,"x":2,"y":159,"zindex":"2"});
this.newpasswd=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_newpasswd","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0)","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"20","name":"newpasswd","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(newpasswd,false,true)%>","w":150,"x":375,"y":159,"zerofilling":false,"zindex":"3","zoom":""});
this.lNewPass=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lNewPass","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"chkReset='N' && usercode != 0","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lNewPass","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lNewPass,false,true)%>","type":"Label","w":154,"x":217,"y":159,"zindex":"2"});
this.imgGen=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default imgGen_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgGen","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb49;","font_image_hover":"&#xeb4c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("Premere il bottone per generare la nuova password",false,true)%>","hide":"false","hide_undercond":"Eq(this.chkReset.Value(),'N') && Ne(this.usercode.Value(),0)","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"imgGen","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb49;","srchover":"&#xeb4c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":536,"y":159,"zindex":"9"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.codeuser=new ZtVWeb._VC(this,'codeuser',null,'numeric',<%=codeuser%>,false,false);
this.codice=new ZtVWeb._VC(this,'codice',null,'numeric','<%=JSPLib.ToJSValue(JSPLib.encrypt(codice,request,"cippa"),false,true)%>',true,false);
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
<%if(request.getAttribute("pg_user_agency_edit_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_user_agency_edit_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_user_agency_edit_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SalvaAgente.setParms();
window.<%=idPortlet%>.imgGen.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_user_agency_edit',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_user_agency_edit');
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
sp.endPage("pg_user_agency_edit");
}%>
<%! public String getJSPUID() { return "3695919349"; } %>