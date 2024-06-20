<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Lettura Ricevute SID',true);\nthis.Bottoni(\"C\");\n\nfunction IDSID_onChange(){\n  this.getTitlePortlet().SetSubTitle('Identificativo SID: '+this.IDSID.Value()+' - File elaborabili da questa maschera: ATPECZC.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m',true);\n}\n\nfunction image_upload_Click(){\n\u002f\u002f   this.dir.Value('Tmp\u002f');\n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction Aggiorna() {\n  var idsid;\n  if(Left(LRTrim(this.nomefile.Value()),8)!='ATPECZC.'){\n    alert('Attenzione!!!\\n Il file caricato non è una ricevuta di un invio mensile o dei saldi');\n    this.Bottoni(\"D\");\n  }\n  idsid=Substr(this.nomefile.Value(),At('.',this.nomefile.Value())+1,At('.',this.nomefile.Value(),1));\n  if(idsid!=this.IDSID.Value()){\n    alert('Attenzione!!!\\n Il file caricato non è di questo intermediario');\n    this.Bottoni(\"D\");\n  }  \n  this.RTSaveFile.Link();\n  this.FileName.Value(Left(LRTrim(this.nomefile.Value()),33));\n  this.PortletLogs.Clean();\n  this.iPrint.Reload();\n}  \n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.Bottoni(\"D\")\n    this.PortletLogs.Start();\n    this.RTElabora.Link();\n  }    \n}\n\nfunction RTElabora_Result(result){  \n  this.PortletLogs.Stop();\n  this.Bottoni(\"C\")\n  alert(\"Elaborazione Terminata\");\n}\n\nfunction btnExcel_Click(){\n  if (confirm(\"Confermi la creazione del file con gli errori?\")) {\n    this.RTExcel.Link();\n  }  \n}\n\nfunction btnPrint1_Click(){\n  if (confirm(\"Confermi la stampa dell'esito dell'invio del file?\")) {  \n    this.RTStampa1.Link();\n  }  \n}\n\nfunction btnPrint2_Click(){\n  if (confirm(\"Confermi la stampa degli esiti rilevati?\")) {\n    this.RTStampa2.Link();\n  }    \n}\n\nfunction RTExcel_Result(result){\n  this.id.Value(result)\n  this.RTDownload.Link()\n}\n\nfunction Bottoni(_action) {\n  if(_action=='C') {\n    this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg(\"Legge la ricevuta\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n      action:'javascript:' + this.formid +'.btnElab_Click()'\n    },1);     \n    this.getTitlePortlet().AppendButton({\n      id:\"Stampa1\",\n      title:FormatMsg('Stampa 1'),\n      tooltip:FormatMsg(\"Stampa il risultato dell'elaborazione\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb6d;\"},\n      action:'javascript:' + this.formid +'.btnPrint1_Click()'\n    },2);     \n    this.getTitlePortlet().AppendButton({\n      id:\"Stampa2\",\n      title:FormatMsg('Stampa 2'),\n      tooltip:FormatMsg(\"Stampa Esiti Rilevati\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n      action:'javascript:' + this.formid +'.btnPrint2_Click()'\n    },3);  \n    this.getTitlePortlet().AppendButton({\n      id:\"Excel\",\n      title:FormatMsg('Excel'),\n      tooltip:FormatMsg(\"Crea file excel con errori rilevati per la correzione\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xea8c;\"},\n      action:'javascript:' + this.formid +'.btnExcel_Click()'\n    },4);                                          \n  } else {\n    this.getTitlePortlet().RemoveButtons()      \n  }  \n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Lettura Ricevute SID","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label_file }}{{ @nomefile }}{{ @image_upload }}{{ @Label_Anno }}{{ @anno }}{{ @pLog }}{{ @pMsg }}{{ @iPrint }}{{ @label_file }}{{ @nomefile }}{{ @image_upload }}{{ @Label_Anno }}{{ @anno }}{{ @btnElab }}{{ @btnPrint1 }}{{ @btnPrint2 }}{{ @btnExcel }}{{ @iPrint }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"310","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ FileName }}\n{{ @iPrint }}\n\n\n\n\n\n\n{{ @anno }}\n{{ @Label_Anno }}\n{{ @image_upload }}\n{{ @nomefile }}\n{{ @label_file }}\n{{ nomefile }}\n{{ btnExcel }}\n{{ label_file }}\n{{ image_upload }}\n{{ RTUpload }}\n{{ RTElabora }}{{ SQLDataobj_armt_intermbo }}\n{{ pLog }}\n{{ pMsg }}{{ IDSID }}\n{{ Event_filename }}\n{{ dir }}\n{{ RTSaveFile }}\n{{ btnExit }}\n{{ RTAzzera }}\n{{ RTUscita }}\n{{ iPrint }}\n{{ btnElab }}\n{{ btnPrint1 }}\n{{ btnPrint2 }}\n{{ gFlgIPMT }}\n{{ anno }}\n{{ Label_Anno }}\n{{ RTStampa1 }}\n{{ gDescAzi }}\n{{ RTStampa2 }}\n{{ RTExcel }}\n \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"800","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"Lettura Ricevute SID\",\"layer\":\"\",\"h\":\"310\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Lettura Ricevute SID","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"894","y":"-14"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"230","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gFlgIPMT","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"894","y":"11"},{"calculate":"'Tmp\u002f'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"dir","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"894","y":"72"},{"allowedqueries":"BO:armt_intermbo","appendingData":"false","auto_exec":"server-client","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1","name":"SQLDataobj_armt_intermbo","offline":"false","page":"1","parms":"","parms_source":"","query":"BO:armt_intermbo","query_async":"true","return_fields_type":"true","sequence":"5","type":"SQLDataobj","w":"183","waiting_mgs":"","x":"894","y":"109"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDataobj_armt_intermbo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDSID","h":"20","init":"","init_par":"","name":"IDSID","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"894","y":"131"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"7","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"183","x":"894","y":"193"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"8","type":"EventReceiver","w":"183","x":"894","y":"217"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"183","x":"894","y":"244"},{"allowedentities":"arrt_famesiti","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTElabora","offline":"false","page":"1","parms":"w_nomefile=nomefile,w_anno=anno","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arrt_famesiti","target":"","type":"SPLinker","w":"183","x":"894","y":"269"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa1","offline":"false","page":"1","parms":"ReportName=arrp_ricevute_sid.vrp,w_DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,hideParameterMask=true,FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"","target":"iPrint","type":"SPLinker","w":"183","x":"894","y":"302"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTStampa2","offline":"false","page":"1","parms":"FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arrt_fam_stp_esiti_sid","target":"iPrint","type":"SPLinker","w":"183","x":"894","y":"324"},{"allowedentities":"arrt_fam_xls_esiti_sid","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExcel","offline":"false","page":"1","parms":"FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arrt_fam_xls_esiti_sid","target":"","type":"SPLinker","w":"183","x":"894","y":"346"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"FileName","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"894","y":"368"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_file","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"100","wireframe_props":"align,value,n_col","x":"8","y":"14","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"false","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"446","wireframe_props":"name","x":"108","y":"13","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"image_upload","page":"1","path_type":"fixed","rapp":"","sequence":"17","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"554","y":"13","zindex":"1","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_Anno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di Riferimento:","w":"100","wireframe_props":"align,value,n_col","x":"8","y":"49","zindex":"6","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"19","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"35","wireframe_props":"name","x":"108","y":"49","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"20","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"79","zindex":"4","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"id","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"898","y":"-41"},{"allowedentities":"DownloadFileServlet","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"id=id","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":"120","x":"898","y":"393"}]%>
<%/*Description:Lettura Ricevute SID*/%>
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
window.pg_famric_elab_Static=function(){
if(typeof IDSID_onChange !='undefined')this.IDSID_onChange=IDSID_onChange;
if(typeof image_upload_Click !='undefined')this.image_upload_Click=image_upload_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTElabora_Result !='undefined')this.RTElabora_Result=RTElabora_Result;
if(typeof btnExcel_Click !='undefined')this.btnExcel_Click=btnExcel_Click;
if(typeof btnPrint1_Click !='undefined')this.btnPrint1_Click=btnPrint1_Click;
if(typeof btnPrint2_Click !='undefined')this.btnPrint2_Click=btnPrint2_Click;
if(typeof RTExcel_Result !='undefined')this.RTExcel_Result=RTExcel_Result;
if(typeof Bottoni !='undefined')this.Bottoni=Bottoni;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('Tmp/',this.dir);
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
this.SQLDataobj_armt_intermbo.addDataConsumer(this.IDSID,<%=JSPLib.ToJSValue("IDSID",true)%>);
this.getTitlePortlet().SetTitle('Lettura Ricevute SID',true);
this.Bottoni("C");
function IDSID_onChange(){
  this.getTitlePortlet().SetSubTitle('Identificativo SID: '+this.IDSID.Value()+' - File elaborabili da questa maschera: ATPECZC.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m',true);
}
function image_upload_Click(){
//   this.dir.Value('Tmp/');
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function Aggiorna() {
  var idsid;
  if(Left(LRTrim(this.nomefile.Value()),8)!='ATPECZC.'){
    alert('Attenzione!!!\n Il file caricato non è una ricevuta di un invio mensile o dei saldi');
    this.Bottoni("D");
  }
  idsid=Substr(this.nomefile.Value(),At('.',this.nomefile.Value())+1,At('.',this.nomefile.Value(),1));
  if(idsid!=this.IDSID.Value()){
    alert('Attenzione!!!\n Il file caricato non è di questo intermediario');
    this.Bottoni("D");
  }  
  this.RTSaveFile.Link();
  this.FileName.Value(Left(LRTrim(this.nomefile.Value()),33));
  this.PortletLogs.Clean();
  this.iPrint.Reload();
}  
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.Bottoni("D")
    this.PortletLogs.Start();
    this.RTElabora.Link();
  }    
}
function RTElabora_Result(result){  
  this.PortletLogs.Stop();
  this.Bottoni("C")
  alert("Elaborazione Terminata");
}
function btnExcel_Click(){
  if (confirm("Confermi la creazione del file con gli errori?")) {
    this.RTExcel.Link();
  }  
}
function btnPrint1_Click(){
  if (confirm("Confermi la stampa dell'esito dell'invio del file?")) {  
    this.RTStampa1.Link();
  }  
}
function btnPrint2_Click(){
  if (confirm("Confermi la stampa degli esiti rilevati?")) {
    this.RTStampa2.Link();
  }    
}
function RTExcel_Result(result){
  this.id.Value(result)
  this.RTDownload.Link()
}
function Bottoni(_action) {
  if(_action=='C') {
    this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg("Legge la ricevuta"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
      action:'javascript:' + this.formid +'.btnElab_Click()'
    },1);     
    this.getTitlePortlet().AppendButton({
      id:"Stampa1",
      title:FormatMsg('Stampa 1'),
      tooltip:FormatMsg("Stampa il risultato dell'elaborazione"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb6d;"},
      action:'javascript:' + this.formid +'.btnPrint1_Click()'
    },2);     
    this.getTitlePortlet().AppendButton({
      id:"Stampa2",
      title:FormatMsg('Stampa 2'),
      tooltip:FormatMsg("Stampa Esiti Rilevati"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
      action:'javascript:' + this.formid +'.btnPrint2_Click()'
    },3);  
    this.getTitlePortlet().AppendButton({
      id:"Excel",
      title:FormatMsg('Excel'),
      tooltip:FormatMsg("Crea file excel con errori rilevati per la correzione"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xea8c;"},
      action:'javascript:' + this.formid +'.btnExcel_Click()'
    },4);                                          
  } else {
    this.getTitlePortlet().RemoveButtons()      
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
.pg_famric_elab_container {
  height:100%;
  overflow:auto;
}
.pg_famric_elab_title_container {
  margin: auto;
}
.pg_famric_elab_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_famric_elab_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_famric_elab_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:230px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_famric_elab_portlet > .label_file_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:8px;
  left:1.0%;
  right:692px;
  right:86.5%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_famric_elab_portlet > .label_file_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famric_elab_portlet > .label_file_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_famric_elab_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:108px;
  left:13.5%;
  right:246px;
  right:30.75%;
  width:auto;
  height:20px;
}
.pg_famric_elab_portlet > .nomefile_ctrl {
}
.pg_famric_elab_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famric_elab_portlet > .image_upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:554px;
  left:69.25%;
  right:226px;
  right:28.25%;
  width:auto;
  height:20px;
}
.pg_famric_elab_portlet > .image_upload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_famric_elab_portlet > .Label_Anno_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:49px;
  left:8px;
  left:1.0%;
  right:692px;
  right:86.5%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_famric_elab_portlet > .Label_Anno_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famric_elab_portlet > .Label_Anno_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_famric_elab_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:49px;
  left:108px;
  left:13.5%;
  right:657px;
  right:82.125%;
  width:auto;
  height:20px;
}
.pg_famric_elab_portlet > .anno_ctrl {
}
.pg_famric_elab_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_famric_elab_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:79px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:81px;
  width:auto;
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
 String def="[{\"h\":\"310\",\"layout_steps_values\":{},\"pages_names\":\"Lettura Ricevute SID\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"894\",\"y\":\"-14\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"230\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"894\",\"y\":\"11\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"894\",\"y\":\"72\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"183\",\"x\":\"894\",\"y\":\"109\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"894\",\"y\":\"131\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"894\",\"y\":\"193\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"183\",\"x\":\"894\",\"y\":\"217\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"894\",\"y\":\"244\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"894\",\"y\":\"269\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"894\",\"y\":\"302\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"894\",\"y\":\"324\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"894\",\"y\":\"346\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"894\",\"y\":\"368\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"100\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"446\",\"x\":\"108\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image_upload\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"554\",\"y\":\"13\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_Anno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di Riferimento:\",\"w\":\"100\",\"x\":\"8\",\"y\":\"49\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"35\",\"x\":\"108\",\"y\":\"49\",\"zindex\":\"5\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"79\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"id\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"898\",\"y\":\"-41\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"898\",\"y\":\"393\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_famric_elab","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_famric_elab_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_famric_elab','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gDescAzi=sp.getGlobal("gDescAzi","");
String gFlgIPMT=sp.getGlobal("gFlgIPMT","");
String dir= "";
String IDSID= "";
String FileName= "";
String label_file= "NomeFile:";
String nomefile= "";
if(request.getAttribute("pg_famric_elab_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label_Anno= "Anno di Riferimento:";
String anno= "";
String id= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_famric_elab_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_famric_elab_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_famric_elab_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_famric_elab','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span id='<%=idPortlet%>_label_file'  formid='<%=idPortlet%>' ps-name='label_file'    class='label label_file_ctrl'><div id='<%=idPortlet%>_label_filetbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<a id='<%=idPortlet%>_image_upload' class='image image_upload_ctrl'   target=''>&#xe9da;</a>
<span id='<%=idPortlet%>_Label_Anno'  formid='<%=idPortlet%>' ps-name='Label_Anno'    class='label Label_Anno_ctrl'><div id='<%=idPortlet%>_Label_Annotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di Riferimento:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' /></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_famric_elab');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea file excel con errori rilevati per la correzione",true)+","+JSPLib.ToJSValue(sp.translate("Crea file excel con errori rilevati per la correzione"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Excel",true)+","+JSPLib.ToJSValue(sp.translate("Excel"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Legge la ricevuta",true)+","+JSPLib.ToJSValue(sp.translate("Legge la ricevuta"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa 1",true)+","+JSPLib.ToJSValue(sp.translate("Stampa 1"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa 2",true)+","+JSPLib.ToJSValue(sp.translate("Stampa 2"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa Esiti Rilevati",true)+","+JSPLib.ToJSValue(sp.translate("Stampa Esiti Rilevati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa il risultato dell'elaborazione",true)+","+JSPLib.ToJSValue(sp.translate("Stampa il risultato dell'elaborazione"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_famric_elab',["800"],["310"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"310","title":"Lettura Ricevute SID","layer":""}]);
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":230,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.gFlgIPMT=new ZtVWeb._VC(this,'gFlgIPMT',null,'character','<%=JSPLib.ToJSValue(gFlgIPMT,false,true)%>',false,false);
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.SQLDataobj_armt_intermbo=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("BO:armt_intermbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"server-client","cmd":"BO:armt_intermbo","cmdHash":"<%=JSPLib.cmdHash("BO:armt_intermbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_armt_intermbo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_armt_intermbo","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":183,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":894,"y":109});
this.IDSID=new ZtVWeb._VC(this,'IDSID',null,'character','<%=JSPLib.ToJSValue(IDSID,false,true)%>',false,false);
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":183,"x":894,"y":193});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":183,"x":894,"y":217});
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":183,"x":894,"y":244});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.RTElabora=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_famesiti",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElabora","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElabora","offline":false,"page":1,"parms":"w_nomefile=nomefile,w_anno=anno","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famesiti","target":"","type":"SPLinker","w":183,"x":894,"y":269});
this.RTElabora.m_cID='<%=JSPLib.cmdHash("routine,arrt_famesiti",request.getSession())%>';
this.RTStampa1=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa1","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa1","offline":false,"page":1,"parms":"ReportName=arrp_ricevute_sid.vrp,w_DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,hideParameterMask=true,FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":183,"x":894,"y":302});
this.RTStampa1.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTStampa2=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa2","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa2","offline":false,"page":1,"parms":"FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fam_stp_esiti_sid","target":"iPrint","type":"SPLinker","w":183,"x":894,"y":324});
this.RTStampa2.m_cID='<%=JSPLib.cmdHash("routine,arrt_fam_stp_esiti_sid",request.getSession())%>';
this.RTExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_fam_xls_esiti_sid",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExcel","offline":false,"page":1,"parms":"FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fam_xls_esiti_sid","target":"","type":"SPLinker","w":183,"x":894,"y":346});
this.RTExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_fam_xls_esiti_sid",request.getSession())%>';
this.FileName=new ZtVWeb._VC(this,'FileName',null,'character','<%=JSPLib.ToJSValue(FileName,false,true)%>',false,false);
this.label_file=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_file","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_file","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_file,false,true)%>","type":"Label","w":100,"x":8,"y":14,"zindex":"1"});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":446,"x":108,"y":13,"zerofilling":false,"zindex":"1","zoom":""});
this.image_upload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image_upload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_upload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image_upload","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":554,"y":13,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label_Anno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_Anno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_Anno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_Anno,false,true)%>","type":"Label","w":100,"x":8,"y":49,"zindex":"6"});
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(anno,false,true)%>","w":35,"x":108,"y":49,"zerofilling":false,"zindex":"5","zoom":""});
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":79,"zindex":"4"});
this.id=new ZtVWeb._VC(this,'id',null,'character','<%=JSPLib.ToJSValue(id,false,true)%>',false,false);
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("DownloadFileServlet",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"id=id","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":120,"x":898,"y":393});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,DownloadFileServlet",request.getSession())%>';
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
<%if(request.getAttribute("pg_famric_elab_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_famric_elab_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_famric_elab_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.image_upload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLDataobj_armt_intermbo.firstQuery('true','',<%SQLExecute.JSONquery(sp,"BO:armt_intermbo",1,out,false, sp.getParameter((!JSPLib.Empty(sp.getParameter("dataprovider_namespace","")) ? sp.getParameter("dataprovider_namespace","") + "_" : "" )+"page_SQLDataobj_armt_intermbo" ,"1"));%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_famric_elab',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_famric_elab');
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
sp.endPage("pg_famric_elab");
}%>
<%! public String getJSPUID() { return "240623055"; } %>