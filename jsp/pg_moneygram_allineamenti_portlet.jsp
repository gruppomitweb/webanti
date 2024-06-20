<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _nolock\n\nfunction this_Loaded(){\n  this.mcParametri.CreateFld(\"data_allienamento\",'D');\n  this.mcParametri.AppendBlank();\n  this.annorif.Hide()\n  this.lblAnnRif.Hide();\n  _nolock=true;\n}\n\nfunction image_upload_real_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n}\n\nfunction LoadMC() {\n  this.mcParametri.Set(\"data_allienamento\",this.Textbox_data_allinea.Value());\n}\n\nfunction LoadMC2() {\n  this.mcParametri.Set(\"data_allienamento\",this.Textbox_data_real.Value());\n}\n\nfunction image_data_allinena_Click(){\n  var _esegui,_msg\n  _esegui=true;\n  _msg=''\n  if (confirm(\"Confermi il lancio della procedura?\")) {\n    if(this.Textbox_data_allinea.Value()==null){\n      _esegui=false;\n     _msg=_msg+'Data vuota\\n';\n    }\n    if(_esegui && _nolock){\n      this.LoadMC();\n      _nolock=false;\n      this.Calendario1.Disabled();\n      this.Calendario_real.Disabled();\n      this.Textbox_data_allinea.Disabled();\n      this.Textbox_data_real.Disabled();\n      this.nomefile.Disabled();\n      this.splinker_data_allienea.Link();\n    }else{\n      if (_nolock){\n        _msg='Alcuni parametri non sono stati correttamente valorizzati per tanto la procedura non verra eseguita.\\n\\nDi seguito i parametri da valorizzare correttamente:\\n\\n'+_msg;\n      }else{\n        _msg='Attendere prego routine in esecuzione';\n      }\n      alert(_msg);\n    }\n  }\n}\nfunction splinker_data_allienea_Result(_ritorno){\n  _nolock=true;\n  this.Calendario1.Enabled();\n  this.Textbox_data_allinea.Enabled();\n  this.Calendario_real.Enabled();\n  this.Textbox_data_allinea.Enabled();\n  this.Textbox_data_real.Enabled();\n  this.nomefile.Enabled();\n}\n\nfunction image_data_allinena_real_Click(){\n  var _esegui,_msg\n  _esegui=true;\n  _msg=''\n  if(this.Radio_opzione.Value()=='R'&&this.Textbox_data_real.Value()==null){\n    _esegui=false;\n    _msg=_msg+'File non caricato\\n';\n  }  \n  if(this.Radio_opzione.Value()=='R'&&this.Textbox_data_real.Value()==null){\n    _esegui=false;\n   _msg=_msg+'Data vuota\\n';\n  }\n  if(_esegui && _nolock){\n    this.LoadMC2();\n    _nolock=false;\n    this.Calendario1.Disabled();\n    this.Calendario_real.Disabled();\n    this.Textbox_data_allinea.Disabled();\n    this.Textbox_data_real.Disabled();\n    this.pMsg.Timer0.Start()\n    this.pLog.Timer0.Start()\n    this.nomefile.Disabled();\n    this.RT_real.Link();\n  }else{\n    if (_nolock){\n      _msg='Alcuni parametri non sono stati correttamente valorizzati per tanto la procedura non verra eseguita.\\n\\nDi seguito i parametri da valorizzare correttamente:\\n\\n'+_msg;\n    }else{\n      _msg='Attendere prego routine in esecuzione';\n    }\n    alert(_msg);\n  }\n}\n\nfunction RT_real_Result(cMsg){\n  alert(\"Elaborazione Terminata\")\n  _nolock=true;\n  this.Calendario1.Enabled();\n  this.Textbox_data_allinea.Enabled();\n  this.Calendario_real.Enabled();\n  this.Textbox_data_allinea.Enabled();\n  this.Textbox_data_real.Enabled();\n  this.nomefile.Enabled();\n  this.pMsg.Timer0_onTimer()\n  this.pLog.Timer0_onTimer()\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0.Stop()\n}\n\nfunction RTSaveFile_Result(result){\n  if(result!='OK'){\n    alert(result);\n  }\n}\n\n\nfunction Radio_opzione_onChange(){\n  if(this.Radio_opzione.Value()!='R'){\n    this.Calendario_real.Hide();\n  }else{\n    this.Calendario_real.Show();\n  }\n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Allinea le date di modifica a quella indicata solo per quelle che sono oltre","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"350","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"900","min_w":"400","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Allinea date modifica anagrafica,RealCF-Cancellazione massiva","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_data_allinea","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"1","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"90","wireframe_props":"name","x":"283","y":"3","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='R'","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"Textbox_data_real","page":"2","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"2","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"90","wireframe_props":"name","x":"279","y":"53","zerofilling":"false","zindex":"1"},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario1","page":"1","popup":"true","return_input":"Textbox_data_allinea","sequence":"3","type":"Calendario","w":"20","wireframe_props":"","x":"376","y":"3","zindex":""},{"async":"false","entity_type":"","h":"22","m_cAction":"","m_cAltInterface":"","name":"RTUpload","offline":"false","page":"2","parms":"","popup":"true","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":"","refresh":"","sequence":"4","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"90","x":"421","y":"-24"},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario_real","page":"2","popup":"true","return_input":"Textbox_data_real","sequence":"5","type":"Calendario","w":"20","wireframe_props":"","x":"376","y":"53","zindex":""},{"async":"true","entity_type":"routine","h":"22","m_cAction":"function","m_cAltInterface":"","name":"RT_real","offline":"false","page":"2","parms":"datamod=Textbox_data_real,aggfam=Checkbox_modfamiglie,pnomefile=nomefile,pannorif=annorif,pselezione=Radio_opzione","popup":"false","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":"false","refresh":"","sequence":"6","servlet":"arrt_import_file_xlsx_esterni","target":"","type":"SPLinker","w":"90","x":"421","y":"32"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label_data_allinea","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data a cui allineare le modifiche successive:","w":"276","wireframe_props":"align,value,n_col","x":"3","y":"3","zindex":"1"},{"align":"right","anchor":"","assoc_input":"Textbox_data_real","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='R'","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label_data_riferimento_allineamrento_real","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data a cui allineare le modifiche dei real:","w":"271","wireframe_props":"align,value,n_col","x":"4","y":"54","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"nomefile","page":"2","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"9","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"346","wireframe_props":"name","x":"4","y":"4","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"bounded","layout_steps_values":"{}","name":"image_data_allinena","page":"1","path_type":"","sequence":"10","server_side":"","src":"..\u002fimages\u002fpng\u002foptions.png","srchover":"..\u002fimages\u002fpng\u002foptions alt.png","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"360","y":"65","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"bounded","layout_steps_values":"{}","name":"image_data_allinena_real","page":"2","path_type":"","sequence":"11","server_side":"","src":"..\u002fimages\u002fpng\u002foptions.png","srchover":"..\u002fimages\u002fpng\u002foptions alt.png","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"360","y":"78","zindex":"1"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"splinker_data_allienea","offline":"false","page":"1","parms":"mcParam=mcParametri","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"false","refresh":"","sequence":"12","servlet":"arfn_moneygram_allineamenti","target":"","type":"SPLinker","w":"153","x":"228","y":"-69"},{"anchor":"","h":"150","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"Portlet2","page":"1","sequence":"13","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"398","wireframe_props":"","x":"1","y":"111","zindex":""},{"actObjs":"nomefile","actTypes":"var","broadcast":"all","h":"20","included":"false","name":"Refresh","objsValues":"NomeFile","page":"2","parmsNames":"NomeFile","sequence":"14","type":"EventReceiver","w":"75","x":"1","y":"-61"},{"anchor":"","h":"70","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"Portlet3","page":"1","sequence":"15","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"398","wireframe_props":"","x":"1","y":"262","zindex":""},{"anchor":"","h":"150","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"2","sequence":"16","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"398","wireframe_props":"","x":"1","y":"111","zindex":""},{"anchor":"","h":"70","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"2","sequence":"17","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"398","wireframe_props":"","x":"1","y":"262","zindex":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"bounded","layout_steps_values":"{}","name":"image_upload_real","page":"2","path_type":"","sequence":"18","server_side":"","src":"..\u002fimages\u002fpng\u002ftop.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"360","y":"2","zindex":"1"},{"auto_create":"","fields":"","h":"30","name":"mcParametri","page":"1","sequence":"19","type":"MemoryCursor","types":"","w":"100","x":"4","y":"-70"},{"anchor":"","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"20","help_tips":"Modifica tutte le famiglie le famiglie","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='R'","init":"true","init_par":"","label_text":"modifica anche le famiglie collegate","layout_steps_values":"{}","name":"Checkbox_modfamiglie","page":"2","sequence":"20","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"254","wireframe_props":"label_text","x":"102","y":"87","zindex":"2"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"2","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"254","y":"-61"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"2","parmsNames":"nomefile","sequence":"22","type":"EventReceiver","w":"111","x":"117","y":"-61"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","m_cAltInterface":"","name":"RTSaveFile","offline":"false","page":"2","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"23","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"90","x":"421","y":"5"},{"anchor":"","calculate":"'R'","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"23","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layout_steps_values":"{}","name":"Radio_opzione","orientation":"horizontal","page":"2","picture":"","sequence":"24","tabindex":"","textlist":"RealCF,Cancellazione massiva,Aggiornamento Frazionate,Saldi","type":"Radio","typevar":"character","valuelist":"R,C,M,S","visible":"true","w":"235","wireframe_props":"","x":"7","y":"29","zindex":"3"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='S'","init":"","init_par":"","layout_steps_values":"{}","maxlength":"4","name":"annorif","page":"2","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"25","tabindex":"","type":"Textbox","typevar":"numeric","visible":"true","w":"46","wireframe_props":"name","x":"279","y":"52","zerofilling":"false","zindex":"4"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='S'","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAnnRif","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Anno di riferimento:","w":"200","wireframe_props":"align,value,n_col","x":"75","y":"53","zindex":"5"}]%>
<%/*Description:Allinea le date di modifica a quella indicata solo per quelle che sono oltre*/%>
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
window.pg_moneygram_allineamenti_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof image_upload_real_Click !='undefined')this.image_upload_real_Click=image_upload_real_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof LoadMC !='undefined')this.LoadMC=LoadMC;
if(typeof LoadMC2 !='undefined')this.LoadMC2=LoadMC2;
if(typeof image_data_allinena_Click !='undefined')this.image_data_allinena_Click=image_data_allinena_Click;
if(typeof splinker_data_allienea_Result !='undefined')this.splinker_data_allienea_Result=splinker_data_allienea_Result;
if(typeof image_data_allinena_real_Click !='undefined')this.image_data_allinena_real_Click=image_data_allinena_real_Click;
if(typeof RT_real_Result !='undefined')this.RT_real_Result=RT_real_Result;
if(typeof RTSaveFile_Result !='undefined')this.RTSaveFile_Result=RTSaveFile_Result;
if(typeof Radio_opzione_onChange !='undefined')this.Radio_opzione_onChange=Radio_opzione_onChange;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Ne(this.Radio_opzione.Value(),'R'),this.Textbox_data_real);
ZtVWeb.HideCtrl(Ne(this.Radio_opzione.Value(),'R'),this.label_data_riferimento_allineamrento_real);
ZtVWeb.HideCtrl(Ne(this.Radio_opzione.Value(),'R'),this.Checkbox_modfamiglie);
ZtVWeb.HideCtrl(Ne(this.Radio_opzione.Value(),'S'),this.annorif);
ZtVWeb.HideCtrl(Ne(this.Radio_opzione.Value(),'S'),this.lblAnnRif);
}
ZtVWeb.InitCtrl(false,this.Checkbox_modfamiglie);
ZtVWeb.InitCtrl('R',this.Radio_opzione);
this.EnablePage(1);
this.EnablePage(2);
var _nolock
function this_Loaded(){
  this.mcParametri.CreateFld("data_allienamento",'D');
  this.mcParametri.AppendBlank();
  this.annorif.Hide()
  this.lblAnnRif.Hide();
  _nolock=true;
}
function image_upload_real_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function Aggiorna() {
  this.RTSaveFile.Link();
}
function LoadMC() {
  this.mcParametri.Set("data_allienamento",this.Textbox_data_allinea.Value());
}
function LoadMC2() {
  this.mcParametri.Set("data_allienamento",this.Textbox_data_real.Value());
}
function image_data_allinena_Click(){
  var _esegui,_msg
  _esegui=true;
  _msg=''
  if (confirm("Confermi il lancio della procedura?")) {
    if(this.Textbox_data_allinea.Value()==null){
      _esegui=false;
     _msg=_msg+'Data vuota\n';
    }
    if(_esegui && _nolock){
      this.LoadMC();
      _nolock=false;
      this.Calendario1.Disabled();
      this.Calendario_real.Disabled();
      this.Textbox_data_allinea.Disabled();
      this.Textbox_data_real.Disabled();
      this.nomefile.Disabled();
      this.splinker_data_allienea.Link();
    }else{
      if (_nolock){
        _msg='Alcuni parametri non sono stati correttamente valorizzati per tanto la procedura non verra eseguita.\n\nDi seguito i parametri da valorizzare correttamente:\n\n'+_msg;
      }else{
        _msg='Attendere prego routine in esecuzione';
      }
      alert(_msg);
    }
  }
}
function splinker_data_allienea_Result(_ritorno){
  _nolock=true;
  this.Calendario1.Enabled();
  this.Textbox_data_allinea.Enabled();
  this.Calendario_real.Enabled();
  this.Textbox_data_allinea.Enabled();
  this.Textbox_data_real.Enabled();
  this.nomefile.Enabled();
}
function image_data_allinena_real_Click(){
  var _esegui,_msg
  _esegui=true;
  _msg=''
  if(this.Radio_opzione.Value()=='R'&&this.Textbox_data_real.Value()==null){
    _esegui=false;
    _msg=_msg+'File non caricato\n';
  }  
  if(this.Radio_opzione.Value()=='R'&&this.Textbox_data_real.Value()==null){
    _esegui=false;
   _msg=_msg+'Data vuota\n';
  }
  if(_esegui && _nolock){
    this.LoadMC2();
    _nolock=false;
    this.Calendario1.Disabled();
    this.Calendario_real.Disabled();
    this.Textbox_data_allinea.Disabled();
    this.Textbox_data_real.Disabled();
    this.pMsg.Timer0.Start()
    this.pLog.Timer0.Start()
    this.nomefile.Disabled();
    this.RT_real.Link();
  }else{
    if (_nolock){
      _msg='Alcuni parametri non sono stati correttamente valorizzati per tanto la procedura non verra eseguita.\n\nDi seguito i parametri da valorizzare correttamente:\n\n'+_msg;
    }else{
      _msg='Attendere prego routine in esecuzione';
    }
    alert(_msg);
  }
}
function RT_real_Result(cMsg){
  alert("Elaborazione Terminata")
  _nolock=true;
  this.Calendario1.Enabled();
  this.Textbox_data_allinea.Enabled();
  this.Calendario_real.Enabled();
  this.Textbox_data_allinea.Enabled();
  this.Textbox_data_real.Enabled();
  this.nomefile.Enabled();
  this.pMsg.Timer0_onTimer()
  this.pLog.Timer0_onTimer()
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0.Stop()
}
function RTSaveFile_Result(result){
  if(result!='OK'){
    alert(result);
  }
}
function Radio_opzione_onChange(){
  if(this.Radio_opzione.Value()!='R'){
    this.Calendario_real.Hide();
  }else{
    this.Calendario_real.Show();
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
.pg_moneygram_allineamenti_container {
}
.pg_moneygram_allineamenti_title_container {
  margin: auto;
}
.pg_moneygram_allineamenti_portlet{
  position:relative;
  margin: auto;
max-width:900px;
  min-width:400px;
  height:350px;
  background-color:#FFFFFF;
}
.pg_moneygram_allineamenti_portlet[Data-page="1"]{
  height:350px;
  width:100%;
}
.pg_moneygram_allineamenti_portlet[Data-page="2"]{
  height:350px;
  width:100%;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Textbox_data_allinea_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:283px;
  left:70.75%;
  right:27px;
  right:6.75%;
  width:auto;
  height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Textbox_data_allinea_ctrl {
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Textbox_data_allinea_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Textbox_data_real_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:279px;
  left:69.75%;
  right:31px;
  right:7.75%;
  width:auto;
  height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Textbox_data_real_ctrl {
  display:none;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Textbox_data_real_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Calendario1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:376px;
  left:94.0%;
  right:4px;
  right:1.0%;
  width:auto;
  height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Calendario_real_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:376px;
  left:94.0%;
  right:4px;
  right:1.0%;
  width:auto;
  height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .label_data_allinea_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:3px;
  left:0.75%;
  right:121px;
  right:30.25%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .label_data_allinea_ctrl {
  height:auto;
  min-height:19px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .label_data_allinea_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .label_data_riferimento_allineamrento_real_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:54px;
  left:4px;
  left:1.0%;
  right:125px;
  right:31.25%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .label_data_riferimento_allineamrento_real_ctrl {
  height:auto;
  min-height:19px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .label_data_riferimento_allineamrento_real_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
  background-color:transparent;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:4px;
  left:1.0%;
  right:50px;
  right:12.5%;
  width:auto;
  height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .nomefile_ctrl {
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_data_allinena_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:360px;
  left:90.0%;
  right:10px;
  right:2.5%;
  width:auto;
  height:30px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_data_allinena_ctrl {
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_data_allinena_ctrl > img{
  width:100%;
  vertical-align:top;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_data_allinena_real_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:78px;
  left:360px;
  left:90.0%;
  right:10px;
  right:2.5%;
  width:auto;
  height:30px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_data_allinena_real_ctrl {
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_data_allinena_real_ctrl > img{
  width:100%;
  vertical-align:top;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Portlet2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:111px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Portlet3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:262px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:111px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:262px;
  left:1px;
  left:0.25%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_upload_real_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:2px;
  left:360px;
  left:90.0%;
  right:10px;
  right:2.5%;
  width:auto;
  height:30px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_upload_real_ctrl {
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .image_upload_real_ctrl > img{
  width:100%;
  vertical-align:top;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Checkbox_modfamiglie_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:87px;
  left:102px;
  left:25.5%;
  right:44px;
  right:11.0%;
  width:auto;
  height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .Radio_opzione_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:29px;
  left:7px;
  left:1.75%;
  right:158px;
  right:39.5%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .annorif_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:52px;
  left:279px;
  left:69.75%;
  right:75px;
  right:18.75%;
  width:auto;
  height:22px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .annorif_ctrl {
  display:none;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .annorif_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .lblAnnRif_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:53px;
  left:75px;
  left:18.75%;
  right:125px;
  right:31.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .lblAnnRif_ctrl {
  height:auto;
  min-height:20px;
}
.pg_moneygram_allineamenti_portlet > .pg_moneygram_allineamenti_page > .lblAnnRif_ctrl {
  overflow:hidden;
  display:none;
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
 String def="[{\"h\":\"350\",\"layout_steps_values\":{},\"pages_names\":\"Allinea date modifica anagrafica,RealCF-Cancellazione massiva\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_data_allinea\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"283\",\"y\":\"3\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_data_real\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"279\",\"y\":\"53\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario1\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"376\",\"y\":\"3\",\"zindex\":\"\"},{\"h\":\"22\",\"name\":\"RTUpload\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"90\",\"x\":\"421\",\"y\":\"-24\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario_real\",\"page\":\"2\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"376\",\"y\":\"53\",\"zindex\":\"\"},{\"h\":\"22\",\"name\":\"RT_real\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"90\",\"x\":\"421\",\"y\":\"32\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_data_allinea\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data a cui allineare le modifiche successive:\",\"w\":\"276\",\"x\":\"3\",\"y\":\"3\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_data_riferimento_allineamrento_real\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Data a cui allineare le modifiche dei real:\",\"w\":\"271\",\"x\":\"4\",\"y\":\"54\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"346\",\"x\":\"4\",\"y\":\"4\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"image_data_allinena\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"360\",\"y\":\"65\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"image_data_allinena_real\",\"page\":\"2\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"360\",\"y\":\"78\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"splinker_data_allienea\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"153\",\"x\":\"228\",\"y\":\"-69\"},{\"anchor\":\"\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"Portlet2\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"398\",\"x\":\"1\",\"y\":\"111\",\"zindex\":\"\"},{\"h\":\"20\",\"name\":\"Refresh\",\"page\":\"2\",\"type\":\"EventReceiver\",\"w\":\"75\",\"x\":\"1\",\"y\":\"-61\"},{\"anchor\":\"\",\"h\":\"70\",\"layout_steps_values\":{},\"name\":\"Portlet3\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"398\",\"x\":\"1\",\"y\":\"262\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"2\",\"type\":\"Portlet\",\"w\":\"398\",\"x\":\"1\",\"y\":\"111\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"70\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"2\",\"type\":\"Portlet\",\"w\":\"398\",\"x\":\"1\",\"y\":\"262\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"image_upload_real\",\"page\":\"2\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"360\",\"y\":\"2\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"mcParametri\",\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"100\",\"x\":\"4\",\"y\":\"-70\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"modifica anche le famiglie collegate\",\"layout_steps_values\":{},\"name\":\"Checkbox_modfamiglie\",\"page\":\"2\",\"type\":\"Checkbox\",\"w\":\"254\",\"x\":\"102\",\"y\":\"87\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"2\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"254\",\"y\":\"-61\"},{\"h\":\"20\",\"name\":\"Event_filename\",\"page\":\"2\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"117\",\"y\":\"-61\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"2\",\"type\":\"SPLinker\",\"w\":\"90\",\"x\":\"421\",\"y\":\"5\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"Radio_opzione\",\"page\":\"2\",\"type\":\"Radio\",\"w\":\"235\",\"x\":\"7\",\"y\":\"29\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"annorif\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"279\",\"y\":\"52\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnnRif\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"200\",\"x\":\"75\",\"y\":\"53\",\"zindex\":\"5\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_moneygram_allineamenti","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_moneygram_allineamenti_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_moneygram_allineamenti','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date Textbox_data_allinea= JSPLib.NullDate();
if(request.getAttribute("pg_moneygram_allineamenti_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date Textbox_data_real= JSPLib.NullDate();
if(request.getAttribute("pg_moneygram_allineamenti_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String label_data_allinea= "Data a cui allineare le modifiche successive:";
String label_data_riferimento_allineamrento_real= "Data a cui allineare le modifiche dei real:";
String nomefile= "";
if(request.getAttribute("pg_moneygram_allineamenti_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
boolean Checkbox_modfamiglie= false;
String dir= "";
String Radio_opzione= "";
double annorif= 0;
String lblAnnRif= "Anno di riferimento:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_moneygram_allineamenti_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='pg_moneygram_allineamenti_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_moneygram_allineamenti_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_moneygram_allineamenti','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='pg_moneygram_allineamenti_page' style='display:block'>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_data_allinea_wrp'><input id='<%=idPortlet%>_Textbox_data_allinea' name='Textbox_data_allinea' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_data_allinea' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario1' class='calendar' onclick='window.<%=idPortlet%>.Calendario1.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_label_data_allinea'  formid='<%=idPortlet%>' ps-name='label_data_allinea'    class='label label_data_allinea_ctrl'><div id='<%=idPortlet%>_label_data_allineatbl' style='width:100%;'><%=JSPLib.ToHTML("Data a cui allineare le modifiche successive:")%></div></span>
<div id='<%=idPortlet%>_image_data_allinena'>
<img id='<%=idPortlet%>_image_data_allinena_img' class='image image_data_allinena_ctrl' src="../images/png/options.png" >
</div>
<div id='<%=idPortlet%>_Portlet2'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_d4kj2w",false);%></div>
<div id='<%=idPortlet%>_Portlet3'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_d4kj2x",false);%></div>
</div>
<div id='<%=idPortlet%>_page_2' class='pg_moneygram_allineamenti_page' style='display:none'>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_data_real_wrp'><input id='<%=idPortlet%>_Textbox_data_real' name='Textbox_data_real' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_data_real' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario_real' class='calendar' onclick='window.<%=idPortlet%>.Calendario_real.PopupCalendar();' style='text-decoration:none;'></a>
 <label id='<%=idPortlet%>_label_data_riferimento_allineamrento_real' for='<%=idPortlet%>_Textbox_data_real' formid='<%=idPortlet%>' ps-name='label_data_riferimento_allineamrento_real'    class='label label_data_riferimento_allineamrento_real_ctrl'><div id='<%=idPortlet%>_label_data_riferimento_allineamrento_realtbl' style='width:100%;'><%=JSPLib.ToHTML("Data a cui allineare le modifiche dei real:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<div id='<%=idPortlet%>_image_data_allinena_real'>
<img id='<%=idPortlet%>_image_data_allinena_real_img' class='image image_data_allinena_real_ctrl' src="../images/png/options.png" >
</div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<div id='<%=idPortlet%>_image_upload_real'>
<img id='<%=idPortlet%>_image_upload_real_img' class='image image_upload_real_ctrl' src="../images/png/top.png" >
</div>
<div id='<%=idPortlet%>_Checkbox_modfamiglie_div' style='display:none;'><input id='<%=idPortlet%>_Checkbox_modfamiglie' name='Checkbox_modfamiglie' class='checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Modifica tutte le famiglie le famiglie" )%> /><label for='<%=idPortlet%>_Checkbox_modfamiglie' class='label' title=<%=JSPLib.ToHTMLValue("Modifica tutte le famiglie le famiglie" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("modifica anche le famiglie collegate")%></label></div>
<div id='<%=idPortlet%>_Radio_opzione' class='radio' style='z-index:1;'></div>
<span class='textbox-container'id='<%=idPortlet%>_annorif_wrp'><input id='<%=idPortlet%>_annorif' name='annorif' type='text' maxlength='4' class='textbox' formid='<%=idPortlet%>' ps-name='annorif' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnnRif'  formid='<%=idPortlet%>' ps-name='lblAnnRif'    class='label lblAnnRif_ctrl'><div id='<%=idPortlet%>_lblAnnRiftbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_moneygram_allineamenti');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/pg_moneygram_allineamenti_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Allinea date modifica anagrafica"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("RealCF-Cancellazione massiva"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_moneygram_allineamenti',["400","400"],["350"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"350","title":"Allinea date modifica anagrafica","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"400","h":"350","title":"RealCF-Cancellazione massiva","layer":"false","npage":"2"}]);
this.Textbox_data_allinea=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_data_allinea","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_data_allinea","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_data_allinea%>","w":90,"x":283,"y":3,"zerofilling":false,"zindex":"1","zoom":""});
this.Textbox_data_real=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_data_real","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Ne(this.Radio_opzione.Value(),'R')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_data_real","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_data_real%>","w":90,"x":279,"y":53,"zerofilling":false,"zindex":"1","zoom":""});
this.Calendario1=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario1','Calendario1',376,3,20,20,'Verdana','10','top-left(%)-right(%)','true','Textbox_data_allinea',{});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":2,"parms":"","popup":"true","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":90,"x":421,"y":-24});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.Calendario_real=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario_real','Calendario_real',376,53,20,20,'Verdana','10','top-left(%)-right(%)','true','Textbox_data_real',{});
this.RT_real=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RT_real","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RT_real","offline":false,"page":2,"parms":"datamod=Textbox_data_real,aggfam=Checkbox_modfamiglie,pnomefile=nomefile,pannorif=annorif,pselezione=Radio_opzione","popup":"false","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":false,"refresh":"","servlet":"arrt_import_file_xlsx_esterni","target":"","type":"SPLinker","w":90,"x":421,"y":32});
this.RT_real.m_cID='<%=JSPLib.cmdHash("routine,arrt_import_file_xlsx_esterni",request.getSession())%>';
this.label_data_allinea=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_data_allinea","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_data_allinea","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label_data_allinea,false,true)%>","type":"Label","w":276,"x":3,"y":3,"zindex":"1"});
this.label_data_riferimento_allineamrento_real=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"Textbox_data_real","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_data_riferimento_allineamrento_real","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='R'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_data_riferimento_allineamrento_real","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label_data_riferimento_allineamrento_real,false,true)%>","type":"Label","w":271,"x":4,"y":54,"zindex":"1"});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nomefile","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":346,"x":4,"y":4,"zerofilling":false,"zindex":"1","zoom":""});
this.image_data_allinena=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image image_data_allinena_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_data_allinena","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image_data_allinena","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fpng\u002foptions.png","srchover":"..\u002fimages\u002fpng\u002foptions alt.png","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":360,"y":65,"zindex":"1"});
this.image_data_allinena_real=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image image_data_allinena_real_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_data_allinena_real","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image_data_allinena_real","page":2,"path_type":"","server_side":"","src":"..\u002fimages\u002fpng\u002foptions.png","srchover":"..\u002fimages\u002fpng\u002foptions alt.png","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":360,"y":78,"zindex":"1"});
this.splinker_data_allienea=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_data_allienea","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_data_allienea","offline":false,"page":1,"parms":"mcParam=mcParametri","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_moneygram_allineamenti","target":"","type":"SPLinker","w":153,"x":228,"y":-69});
this.splinker_data_allienea.m_cID='<%=JSPLib.cmdHash("routine,arfn_moneygram_allineamenti",request.getSession())%>';
if(this.Portlet2=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet2')){
this.Portlet2.setContainer(this,'Portlet2')
this.Portlet2_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_Portlet2","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet2","page":1,"portlet_id":"<%=idPortlet%>_d4kj2w","type":"Portlet","w":398,"x":1,"y":111,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_Portlet2').style.display='none';
}
this.Refresh=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile","actTypes":"var","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Refresh","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Refresh","objsValues":"NomeFile","page":2,"parmsNames":"NomeFile","type":"EventReceiver","w":75,"x":1,"y":-61});
if(this.Portlet3=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet3')){
this.Portlet3.setContainer(this,'Portlet3')
this.Portlet3_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_Portlet3","h":70,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet3","page":1,"portlet_id":"<%=idPortlet%>_d4kj2x","type":"Portlet","w":398,"x":1,"y":262,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_Portlet3').style.display='none';
}
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":2,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":398,"x":1,"y":111,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":70,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":2,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":398,"x":1,"y":262,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.image_upload_real=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image image_upload_real_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_upload_real","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image_upload_real","page":2,"path_type":"","server_side":"","src":"..\u002fimages\u002fpng\u002ftop.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":360,"y":2,"zindex":"1"});
this.mcParametri=new ZtVWeb.MemoryCursorCtrl(this,'mcParametri','<%=idPortlet%>_mcParametri','','','','','false');
this.Checkbox_modfamiglie=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"false","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Checkbox_modfamiglie","decrypt":false,"edit_undercond":"","encrypt":false,"h":20,"hide":"false","hide_undercond":"Ne(this.Radio_opzione.Value(),'R')","init":"true","init_par":"","label_text":"modifica anche le famiglie collegate","layer":false,"layout_steps_values":{},"name":"Checkbox_modfamiglie","page":2,"reactive":false,"server_side":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":254,"x":102,"y":87,"zindex":"2"});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":2,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":117,"y":-61});
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":2,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":90,"x":421,"y":5});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.Radio_opzione=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"'R'","captionsList":"RealCF,Cancellazione massiva,Aggiornamento Frazionate,Saldi","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio_opzione","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"Radio_opzione","orientation":"horizontal","page":2,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"R,C,M,S","visible":true,"w":235,"x":7,"y":29,"zindex":"3"});
this.annorif=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_annorif","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"Ne(this.Radio_opzione.Value(),'S')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"4","name":"annorif","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=annorif%>","w":46,"x":279,"y":52,"zerofilling":false,"zindex":"4","zoom":""});
this.lblAnnRif=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnnRif","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"this.Radio_opzione.Value()!='S'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnnRif","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblAnnRif,false,true)%>","type":"Label","w":200,"x":75,"y":53,"zindex":"5"});
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
<%if(request.getAttribute("pg_moneygram_allineamenti_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_moneygram_allineamenti_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_moneygram_allineamenti_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Refresh=function(parmsObj){<%=idPortlet%>.Refresh.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_moneygram_allineamenti',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_moneygram_allineamenti');
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
sp.endPage("pg_moneygram_allineamenti");
}%>
<%! public String getJSPUID() { return "411183365"; } %>