<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction image5_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link()\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.PortletLogs.Start();\n    this.listaFile.Timer0.Start()\n    this.getTitlePortlet().RemoveButtons()\n    this.RTSalva.Link();\n  }    \n}\n\nfunction Aggiorna() {  \n  this.RTSaveFile.Link()\n  this.listaFile.ListaFile.Refresh();  \n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('Import dati da procedure esterne (RTRA)',true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Import\",\n    title:FormatMsg('Importa'),\n    tooltip:FormatMsg('Import i dati dei file RTRA caricati'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.btnElab_Click()'\n  },1);\n}\n\nfunction RTSalva_Result(result){  \n  this.PortletLogs.Stop();\n  this.listaFile.Timer0_onTimer();\n  this.listaFile.Timer0.Stop();\n  this.getTitlePortlet().AppendButton({\n    id:\"Import\",\n    title:FormatMsg('Importa'),\n    tooltip:FormatMsg('Import i dati dei file RTRA caricati'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.btnElab_Click()'\n  },1);       \n  this.getTitlePortlet().AppendButton({\n    id:\"Download\",\n    title:FormatMsg('Download'),\n    tooltip:FormatMsg('Preleva eventuali file di errore'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xebbd;\"},\n    action:'javascript:' + this.formid +'.btnDown_Click()'\n  },2);    \n  \n  alert(\"Elaborazione Terminata\");    \n}\n\nfunction btnDown_Click(){\n  this.RTDownload.Link();\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @nomefile }}{{ @label1 }}{{ @image5 }}{{ @rDest }}{{ @pLog }}{{ @pMsg }}{{ @listaFile }}{{ @Label18 }}{{ @btnExit }}{{ @cImpAna }}{{ @nomefile }}{{ @btnElab }}{{ @label1 }}{{ @image5 }}{{ @rDest }}{{ @listaFile }}{{ @Label18 }}{{ @btnDown }}{{ @cImpAna }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"365","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @cImpAna }}\n\n\n{{ @Label18 }}\n{{ @listaFile }}\n\n\n{{ @rDest }}\n{{ @image5 }}\n{{ @label1 }}\n\n{{ @nomefile }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"365\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"850","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"750","wireframe_props":"name","x":"64","y":"11","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"850","wireframe_props":"","x":"0","y":"275","zindex":"6","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"51","wireframe_props":"align,value,n_col","x":"8","y":"14","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","rapp":"","sequence":"4","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"822","y":"9","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"5","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"127","y":"-69"},{"allowedentities":"arrt_imp_dati_rtra","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSalva","offline":"false","page":"1","parms":"w_tipodest=rDest,w_delprec=S,pAUA=S,pModo=R,pTipo=I,pErrAUI=N,pImpAna=cImpAna,pNoDG=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arrt_imp_dati_rtra","target":"","type":"SPLinker","w":"120","x":"3","y":"-69"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"23","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"P","layer":"false","layout_steps_values":"{}","name":"rDest","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"7","spuid":"","tabindex":"","textlist":"Definitivo,Provvisorio","type":"Radio","typevar":"character","valuelist":"D,P","visible":"true","w":"188","wireframe_props":"","x":"146","y":"44","zindex":"2","zone":""},{"anchor":"","ctrlOfVariant":"","fixed":"","h":"200","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"listaFile","page":"1","rapp":"","sequence":"10","spuid":"","src":"list_imprich_portlet.jsp","themed":"false","type":"Portlet","w":"850","wireframe_props":"","x":"0","y":"73","zindex":"6","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label18","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Destinazione Dati:","w":"129","wireframe_props":"align,value,n_col","x":"15","y":"46","zindex":"7","zone":""},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"12","type":"EventReceiver","w":"111","x":"860","y":"-70"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"238","y":"-29"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"120","x":"515","y":"-67"},{"allowedentities":"..\u002fjsp\u002fpg_scarti_import_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTDownload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"..\u002fjsp\u002fpg_scarti_import_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"256","y":"-70"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"18","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"642","y":"-68"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Importa solo dati Anagrafici","layer":"false","layout_steps_values":"{}","name":"cImpAna","page":"1","rapp":"","sequence":"20","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"216","wireframe_props":"label_text","x":"445","y":"45","zindex":"8","zone":""}]%>
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
window.pg_import_dati_rtra_errori_Static=function(){
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTSalva_Result !='undefined')this.RTSalva_Result=RTSalva_Result;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function image5_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link()
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.PortletLogs.Start();
    this.listaFile.Timer0.Start()
    this.getTitlePortlet().RemoveButtons()
    this.RTSalva.Link();
  }    
}
function Aggiorna() {  
  this.RTSaveFile.Link()
  this.listaFile.ListaFile.Refresh();  
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Import dati da procedure esterne (RTRA)',true)
  this.getTitlePortlet().AppendButton({
    id:"Import",
    title:FormatMsg('Importa'),
    tooltip:FormatMsg('Import i dati dei file RTRA caricati'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.btnElab_Click()'
  },1);
}
function RTSalva_Result(result){  
  this.PortletLogs.Stop();
  this.listaFile.Timer0_onTimer();
  this.listaFile.Timer0.Stop();
  this.getTitlePortlet().AppendButton({
    id:"Import",
    title:FormatMsg('Importa'),
    tooltip:FormatMsg('Import i dati dei file RTRA caricati'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.btnElab_Click()'
  },1);       
  this.getTitlePortlet().AppendButton({
    id:"Download",
    title:FormatMsg('Download'),
    tooltip:FormatMsg('Preleva eventuali file di errore'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xebbd;"},
    action:'javascript:' + this.formid +'.btnDown_Click()'
  },2);    
  
  alert("Elaborazione Terminata");    
}
function btnDown_Click(){
  this.RTDownload.Link();
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
.pg_import_dati_rtra_errori_container {
  height:100%;
  overflow:auto;
}
.pg_import_dati_rtra_errori_title_container {
  margin: auto;
}
.pg_import_dati_rtra_errori_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:850px;
  height:100%;
  background-color:#FFFFFF;
}
.pg_import_dati_rtra_errori_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_import_dati_rtra_errori_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:64px;
  left:7.529412%;
  right:36px;
  right:4.2352943%;
  width:auto;
  height:20px;
}
.pg_import_dati_rtra_errori_portlet > .nomefile_ctrl {
}
.pg_import_dati_rtra_errori_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_import_dati_rtra_errori_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:275px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_import_dati_rtra_errori_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:8px;
  left:0.9411765%;
  right:791px;
  right:93.05882%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_import_dati_rtra_errori_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_import_dati_rtra_errori_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_import_dati_rtra_errori_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:822px;
  left:96.70588%;
  right:8px;
  right:0.9411765%;
  width:auto;
  height:20px;
}
.pg_import_dati_rtra_errori_portlet > .image5_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_import_dati_rtra_errori_portlet > .rDest_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:44px;
  left:146px;
  left:17.17647%;
  right:516px;
  right:60.705883%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
}
.pg_import_dati_rtra_errori_portlet > .listaFile_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:73px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:200px;
}
.pg_import_dati_rtra_errori_portlet > .Label18_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:46px;
  left:15px;
  left:1.7647059%;
  right:706px;
  right:83.05882%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_dati_rtra_errori_portlet > .Label18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_dati_rtra_errori_portlet > .Label18_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_dati_rtra_errori_portlet > .cImpAna_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:45px;
  left:445px;
  left:52.35294%;
  right:189px;
  right:22.235294%;
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
 String def="[{\"h\":\"365\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"850\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"750\",\"x\":\"64\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"name\":\"PortletLogs\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"850\",\"x\":\"0\",\"y\":\"275\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"51\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"822\",\"y\":\"9\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"127\",\"y\":\"-69\"},{\"h\":\"20\",\"name\":\"RTSalva\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"3\",\"y\":\"-69\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"rDest\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"188\",\"x\":\"146\",\"y\":\"44\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"200\",\"layout_steps_values\":{},\"name\":\"listaFile\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"850\",\"x\":\"0\",\"y\":\"73\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Destinazione Dati:\",\"w\":\"129\",\"x\":\"15\",\"y\":\"46\",\"zindex\":\"7\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"860\",\"y\":\"-70\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"238\",\"y\":\"-29\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"515\",\"y\":\"-67\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"256\",\"y\":\"-70\"},{\"h\":\"20\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"642\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Importa solo dati Anagrafici\",\"layout_steps_values\":{},\"name\":\"cImpAna\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"216\",\"x\":\"445\",\"y\":\"45\",\"zindex\":\"8\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_import_dati_rtra_errori","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_import_dati_rtra_errori_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_import_dati_rtra_errori','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomefile= "";
if(request.getAttribute("pg_import_dati_rtra_errori_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label1= "NomeFile:";
String rDest="P";
String Label18= "Destinazione Dati:";
String dir= "";
String cImpAna="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_import_dati_rtra_errori_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_import_dati_rtra_errori_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_import_dati_rtra_errori_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_import_dati_rtra_errori','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<a id='<%=idPortlet%>_image5' class='image image5_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_rDest' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_listaFile'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/list_imprich_portlet.jsp?ForcedPortletUID="+idPortlet+"_1esm17j",false);%></div>
<span id='<%=idPortlet%>_Label18'  formid='<%=idPortlet%>' ps-name='Label18'    class='label Label18_ctrl'><div id='<%=idPortlet%>_Label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Destinazione Dati:")%></div></span>
<div id='<%=idPortlet%>_cImpAna_div' style=''><input id='<%=idPortlet%>_cImpAna' name='cImpAna' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_cImpAna' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Importa solo dati Anagrafici")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_import_dati_rtra_errori');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Download",true)+","+JSPLib.ToJSValue(sp.translate("Download"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Import i dati dei file RTRA caricati",true)+","+JSPLib.ToJSValue(sp.translate("Import i dati dei file RTRA caricati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Importa",true)+","+JSPLib.ToJSValue(sp.translate("Importa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Preleva eventuali file di errore",true)+","+JSPLib.ToJSValue(sp.translate("Preleva eventuali file di errore"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_import_dati_rtra_errori',["850"],["365"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"850","h":"365","title":"","layer":""}]);
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":750,"x":64,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":850,"x":0,"y":275,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":8,"y":14,"zindex":"1"});
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":822,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":120,"x":127,"y":-69});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.RTSalva=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_imp_dati_rtra",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSalva","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSalva","offline":false,"page":1,"parms":"w_tipodest=rDest,w_delprec=S,pAUA=S,pModo=R,pTipo=I,pErrAUI=N,pImpAna=cImpAna,pNoDG=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_imp_dati_rtra","target":"","type":"SPLinker","w":120,"x":3,"y":-69});
this.RTSalva.m_cID='<%=JSPLib.cmdHash("routine,arrt_imp_dati_rtra",request.getSession())%>';
this.rDest=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Definitivo,Provvisorio","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rDest","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"P","layer":false,"layout_steps_values":{},"name":"rDest","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,P","visible":true,"w":188,"x":146,"y":44,"zindex":"2"});
this.rDest.Value('<%=JSPLib.ToJSValue(rDest,false,true)%>');
if(this.listaFile=ZtVWeb.getPortletInc('<%=idPortlet%>_listaFile')){
this.listaFile.setContainer(this,'listaFile')
this.listaFile_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_listaFile","h":200,"hide":"false","layer":false,"layout_steps_values":{},"name":"listaFile","page":1,"portlet_id":"<%=idPortlet%>_1esm17j","spuid":"","type":"Portlet","w":850,"x":0,"y":73,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_listaFile').style.display='none';
}
this.Label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label18,false,true)%>","type":"Label","w":129,"x":15,"y":46,"zindex":"7"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":860,"y":-70});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":120,"x":515,"y":-67});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("../jsp/pg_scarti_import_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_scarti_import_portlet.jsp","target":"","type":"SPLinker","w":120,"x":256,"y":-70});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_scarti_import_portlet.jsp",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":642,"y":-68});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.cImpAna=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_cImpAna","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Importa solo dati Anagrafici","layer":false,"layout_steps_values":{},"name":"cImpAna","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":216,"x":445,"y":45,"zindex":"8"});
this.cImpAna.Value('<%=cImpAna%>');
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
<%if(request.getAttribute("pg_import_dati_rtra_errori_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_import_dati_rtra_errori_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_import_dati_rtra_errori_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_import_dati_rtra_errori',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_import_dati_rtra_errori');
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
sp.endPage("pg_import_dati_rtra_errori");
}%>
<%! public String getJSPUID() { return "304613643"; } %>