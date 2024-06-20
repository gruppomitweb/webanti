<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Lettura Esiti di Elaborazione',true)\nthis.Bottoni(\"C\")  \n\n\nfunction IDSID_onChange(){\n  this.getTitlePortlet().SetSubTitle('Identificativo SID: '+this.IDSID.Value()+' - File elaborabili da questa maschera: ATPEC03.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m \u002f ATPEC04.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m',true);\n}\n\nfunction image_upload_Click(){\n\u002f\u002f   this.dir.Value('Tmp\u002f');\n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\nfunction Aggiorna() {\n  var idsid;\n  if(Left(LRTrim(this.nomefile.Value()),8)!='ATPEC03.' && Left(LRTrim(this.nomefile.Value()),8)!='ATPEC04.'){\n    alert('Attenzione!!!\\n Il file caricato non è una ricevuta di un invio mensile o dei saldi');\n    this.btnElab.Hide()\n  }\n  idsid=Substr(this.nomefile.Value(),At('.',this.nomefile.Value())+1,At('.',this.nomefile.Value(),1));\n  if(idsid!=this.IDSID.Value()){\n    alert('Attenzione!!!\\n Il file caricato non è di questo intermediario');\n    this.btnElab.Hide();\n  }\n  this.RTSaveFile.Link();\n  this.FileName.Value(Left(LRTrim(this.nomefile.Value()),33));\n  this.PortletLogs.Clean();\n  this.iPrint.Reload();\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.Bottoni(\"D\")\n    this.PortletLogs.Start();\n    this.RTElabora.Link();\n  }    \n}\n\nfunction RTElabora_Result(result){\n  this.PortletLogs.Stop();\n  this.Bottoni(\"C\")  \n  alert(\"Elaborazione Terminata\");\n}\n\nfunction btnExcel_Click(){\n  this.RTExcel.Link();\n}\n\nfunction btnPrint_Click(){\n  this.RTStampa.Link();\n}\n\nfunction Bottoni(_action) {\n  if(_action=='C') {\n    this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg(\"Legge la ricevuta\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n      action:'javascript:' + this.formid +'.btnElab_Click()'\n    },1);     \n    this.getTitlePortlet().AppendButton({\n      id:\"Stampa\",\n      title:FormatMsg('Stampa'),\n      tooltip:FormatMsg(\"Stampa il risultato dell'elaborazione\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n      action:'javascript:' + this.formid +'.btnPrint_Click()'\n    },2);                                            \n  } else {\n    this.getTitlePortlet().RemoveButtons()      \n  }  \n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label_nome_file }}{{ @nomefile }}{{ @image_upload }}{{ @nomsg }}{{ @pLog }}{{ @pMsg }}{{ @iPrint }}{{ @label_nome_file }}{{ @nomefile }}{{ @image_upload }}{{ @nomsg }}{{ @btnElab }}{{ @btnPrint }}{{ @iPrint }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"310","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @iPrint }}\n\n\n\n\n{{ @nomsg }}\n{{ @image_upload }}\n{{ @nomefile }}\n{{ @label_nome_file }}\n{{ SQLDataobj_armt_intermbo }}\n{{ IDSID }}\n{{ nomefile }}\n{{ label_nome_file }}\n{{ image_upload }}\n{{ RTUpload }}\n{{ RTElabora }}\n{{ pLog }}\n{{ pMsg }}\n{{ Event_filename }}\n{{ dir }}\n{{ RTSaveFile }}\n{{ btnExit }}\n{{ RTAzzera }}\n{{ RTUscita }}\n{{ iPrint }}{{ Note22 }}\n{{ btnElab }}\n{{ btnPrint }}{{ filename }}\n{{ RTStampa }}\n{{ gDescAzi }}\n{{ nomsg }}\n{{ formatTypes }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"800","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"310\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"998","y":"13"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"230","zindex":"3","zone":""},{"allowedqueries":"BO:armt_intermbo","appendingData":"false","auto_exec":"server-client","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"1","name":"SQLDataobj_armt_intermbo","offline":"false","page":"1","parms":"","parms_source":"","query":"BO:armt_intermbo","query_async":"true","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"183","waiting_mgs":"","x":"998","y":"56"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLDataobj_armt_intermbo","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDSID","h":"20","init":"","init_par":"","name":"IDSID","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"998","y":"78"},{"calculate":"'Tmp\u002f'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"dir","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"998","y":"106"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"6","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"183","x":"998","y":"127"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"7","type":"EventReceiver","w":"183","x":"998","y":"148"},{"allowedentities":"arfn_upload_file_doc","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":"183","x":"998","y":"169"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTElabora","offline":"false","page":"1","parms":"w_nomefile=nomefile,w_nomsg=nomsg","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arrt_famesiti_elab","target":"","type":"SPLinker","w":"183","x":"998","y":"204"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa","offline":"false","page":"1","parms":"ReportName=arrp_esiti_elaborazione.vrp,w_DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,hideParameterMask=true,formatTypes=formatTypes,FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"","target":"iPrint","type":"SPLinker","w":"183","x":"998","y":"234"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_nome_file","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"NomeFile:","w":"60","wireframe_props":"align,value,n_col","x":"8","y":"14","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"500","wireframe_props":"name","x":"68","y":"13","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"image_upload","page":"1","path_type":"","rapp":"","sequence":"13","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"568","y":"13","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Non segnala errori a video per file esito molto grandi (\u003e 5Mb)","layer":"false","layout_steps_values":"{}","name":"nomsg","page":"1","rapp":"","sequence":"14","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"417","wireframe_props":"label_text","x":"9","y":"50","zindex":"5","zone":""},{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"15","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"79","zindex":"4","zone":""},{"calculate":"'PDF$|$XLS$|$CSV'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"formatTypes","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"998","y":"256"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"FileName","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"183","x":"998","y":"282"}]%>
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
window.pg_famesiti_elab_Static=function(){
if(typeof IDSID_onChange !='undefined')this.IDSID_onChange=IDSID_onChange;
if(typeof image_upload_Click !='undefined')this.image_upload_Click=image_upload_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTElabora_Result !='undefined')this.RTElabora_Result=RTElabora_Result;
if(typeof btnExcel_Click !='undefined')this.btnExcel_Click=btnExcel_Click;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
if(typeof Bottoni !='undefined')this.Bottoni=Bottoni;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('Tmp/',this.dir);
ZtVWeb.InitCtrl('PDF|XLS|CSV',this.formatTypes);
this.SQLDataobj_armt_intermbo.addDataConsumer(this.IDSID,<%=JSPLib.ToJSValue("IDSID",true)%>);
this.getTitlePortlet().SetTitle('Lettura Esiti di Elaborazione',true)
this.Bottoni("C")  
function IDSID_onChange(){
  this.getTitlePortlet().SetSubTitle('Identificativo SID: '+this.IDSID.Value()+' - File elaborabili da questa maschera: ATPEC03.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m / ATPEC04.'+this.IDSID.Value()+'.DXXXXXXX.TXXXXXX.p7m',true);
}
function image_upload_Click(){
//   this.dir.Value('Tmp/');
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function Aggiorna() {
  var idsid;
  if(Left(LRTrim(this.nomefile.Value()),8)!='ATPEC03.' && Left(LRTrim(this.nomefile.Value()),8)!='ATPEC04.'){
    alert('Attenzione!!!\n Il file caricato non è una ricevuta di un invio mensile o dei saldi');
    this.btnElab.Hide()
  }
  idsid=Substr(this.nomefile.Value(),At('.',this.nomefile.Value())+1,At('.',this.nomefile.Value(),1));
  if(idsid!=this.IDSID.Value()){
    alert('Attenzione!!!\n Il file caricato non è di questo intermediario');
    this.btnElab.Hide();
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
  this.RTExcel.Link();
}
function btnPrint_Click(){
  this.RTStampa.Link();
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
      id:"Stampa",
      title:FormatMsg('Stampa'),
      tooltip:FormatMsg("Stampa il risultato dell'elaborazione"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
      action:'javascript:' + this.formid +'.btnPrint_Click()'
    },2);                                            
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
.pg_famesiti_elab_container {
}
.pg_famesiti_elab_title_container {
  margin: auto;
}
.pg_famesiti_elab_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:310px;
}
.pg_famesiti_elab_portlet[Data-page="1"]{
  height:310px;
  width:100%;
}
.pg_famesiti_elab_portlet > .PortletLogs_ctrl {
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
.pg_famesiti_elab_portlet > .label_nome_file_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:8px;
  left:1.0%;
  right:732px;
  right:91.5%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_famesiti_elab_portlet > .label_nome_file_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_elab_portlet > .label_nome_file_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_famesiti_elab_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:68px;
  left:8.5%;
  right:232px;
  right:29.0%;
  width:auto;
  height:20px;
}
.pg_famesiti_elab_portlet > .nomefile_ctrl {
}
.pg_famesiti_elab_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_famesiti_elab_portlet > .image_upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:568px;
  left:71.0%;
  right:212px;
  right:26.5%;
  width:auto;
  height:20px;
}
.pg_famesiti_elab_portlet > .image_upload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_famesiti_elab_portlet > .nomsg_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:50px;
  left:9px;
  left:1.125%;
  right:374px;
  right:46.75%;
  width:auto;
  height:20px;
}
.pg_famesiti_elab_portlet > .iPrint_ctrl {
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
 String def="[{\"h\":\"310\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"998\",\"y\":\"13\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"230\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"183\",\"x\":\"998\",\"y\":\"56\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"998\",\"y\":\"78\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"998\",\"y\":\"106\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"998\",\"y\":\"127\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"183\",\"x\":\"998\",\"y\":\"148\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"998\",\"y\":\"169\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"998\",\"y\":\"204\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"998\",\"y\":\"234\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"60\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"500\",\"x\":\"68\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image_upload\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"568\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Non segnala errori a video per file esito molto grandi (\\u003e 5Mb)\",\"layout_steps_values\":{},\"name\":\"nomsg\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"417\",\"x\":\"9\",\"y\":\"50\",\"zindex\":\"5\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"79\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"formatTypes\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"998\",\"y\":\"256\"},{\"h\":\"20\",\"name\":\"FileName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"183\",\"x\":\"998\",\"y\":\"282\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_famesiti_elab","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_famesiti_elab_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_famesiti_elab','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gDescAzi=sp.getGlobal("gDescAzi","");
String IDSID= "";
String dir= "";
String label_nome_file= "NomeFile:";
String nomefile= "";
if(request.getAttribute("pg_famesiti_elab_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String nomsg="N";
String formatTypes= "";
String FileName= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_famesiti_elab_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_famesiti_elab_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_famesiti_elab_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_famesiti_elab','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span id='<%=idPortlet%>_label_nome_file'  formid='<%=idPortlet%>' ps-name='label_nome_file'    class='label label_nome_file_ctrl'><div id='<%=idPortlet%>_label_nome_filetbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<a id='<%=idPortlet%>_image_upload' class='image image_upload_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_nomsg_div' style=''><input id='<%=idPortlet%>_nomsg' name='nomsg' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_nomsg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Non segnala errori a video per file esito molto grandi (> 5Mb)")%></label></div>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_famesiti_elab');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Legge la ricevuta",true)+","+JSPLib.ToJSValue(sp.translate("Legge la ricevuta"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa il risultato dell'elaborazione",true)+","+JSPLib.ToJSValue(sp.translate("Stampa il risultato dell'elaborazione"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_famesiti_elab',["800"],["310"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"310","title":"","layer":""}]);
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":230,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.SQLDataobj_armt_intermbo=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("BO:armt_intermbo",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"server-client","cmd":"BO:armt_intermbo","cmdHash":"<%=JSPLib.cmdHash("BO:armt_intermbo",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_armt_intermbo","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_armt_intermbo","nrows":"1","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":183,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":998,"y":56});
this.IDSID=new ZtVWeb._VC(this,'IDSID',null,'character','<%=JSPLib.ToJSValue(IDSID,false,true)%>',false,false);
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":183,"x":998,"y":127});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":183,"x":998,"y":148});
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file_doc",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file_doc","target":"","type":"SPLinker","w":183,"x":998,"y":169});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file_doc",request.getSession())%>';
this.RTElabora=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElabora","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElabora","offline":false,"page":1,"parms":"w_nomefile=nomefile,w_nomsg=nomsg","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famesiti_elab","target":"","type":"SPLinker","w":183,"x":998,"y":204});
this.RTElabora.m_cID='<%=JSPLib.cmdHash("routine,arrt_famesiti_elab",request.getSession())%>';
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"ReportName=arrp_esiti_elaborazione.vrp,w_DescAzi=gDescAzi,hideCover=true,hideLanguage=true,hideSettings=true,hideParameterMask=true,formatTypes=formatTypes,FileName=FileName","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":183,"x":998,"y":234});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.label_nome_file=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_nome_file","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_nome_file","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_nome_file,false,true)%>","type":"Label","w":60,"x":8,"y":14,"zindex":"1"});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":500,"x":68,"y":13,"zerofilling":false,"zindex":"1","zoom":""});
this.image_upload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image_upload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_upload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image_upload","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":568,"y":13,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.nomsg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_nomsg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Non segnala errori a video per file esito molto grandi (\u003e 5Mb)","layer":false,"layout_steps_values":{},"name":"nomsg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":417,"x":9,"y":50,"zindex":"5"});
this.nomsg.Value('<%=nomsg%>');
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":79,"zindex":"4"});
this.formatTypes=new ZtVWeb._VC(this,'formatTypes',null,'character','<%=JSPLib.ToJSValue(formatTypes,false,true)%>',false,false);
this.FileName=new ZtVWeb._VC(this,'FileName',null,'character','<%=JSPLib.ToJSValue(FileName,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_famesiti_elab_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_famesiti_elab_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_famesiti_elab_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.image_upload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLDataobj_armt_intermbo.firstQuery('true','',<%SQLExecute.JSONquery(sp,"BO:armt_intermbo",1,out,false, sp.getParameter((!JSPLib.Empty(sp.getParameter("dataprovider_namespace","")) ? sp.getParameter("dataprovider_namespace","") + "_" : "" )+"page_SQLDataobj_armt_intermbo" ,"1"));%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_famesiti_elab',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_famesiti_elab');
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
sp.endPage("pg_famesiti_elab");
}%>
<%! public String getJSPUID() { return "609901129"; } %>