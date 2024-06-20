<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Estrazione mensile Operazioni per OAM\",true)  \n  this.getTitlePortlet().AppendButton({\n    id:\"Crea\",\n    title:FormatMsg('Crea'),\n    tooltip:FormatMsg('Crea il file dei movimenti OAM'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4b;\"},\n    action:'javascript:' + this.formid +'.Crea()'\n  },3);      \n  this.getTitlePortlet().AppendButton({\n    id:\"Print\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg(\"Stampa l'elenco dei movimenti selezionati\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb06;\"},\n    action:'javascript:' + this.formid +'.Stampa()'\n  },2);      \n  this.getTitlePortlet().AppendButton({\n    id:\"Download\",\n    title:FormatMsg('Download'),\n    tooltip:FormatMsg(\"Preleva il file generato\"),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe9dd;\"},\n    action:'javascript:' + this.formid +'.Download()'\n  },1);        \n}\n\nfunction Crea(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.PortletLogs.Start();   \n    this.RTExec.Link()\n  }  \n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop();        \n  alert(\"Elaborazione Completata!\");\n  this.codice.Value(result);\n}\n\nfunction anno_onChange(){\n  if(this.anno.Value()==0) {\n    this.mese.Value(\"\")    \n    this.DaDatOpe.Value(NullDate())\n    this.ADatOpe.Value(NullDate())\n  } else {\n    this.CalcolaDate() \n  }  \n}\n\nfunction mese_onChange(){\n  if(Empty(this.mese.Value())) {\n    this.DaDatOpe.Value(NullDate())\n    this.ADatOpe.Value(NullDate())    \n  } else {\n    this.CalcolaDate()      \n  }  \n}\n\nfunction CalcolaDate() {\n this.DaDatOpe.Value(iif(!Empty(this.anno.Value()) && !Empty(this.mese.Value()),CharToDate(Str(this.anno.Value(),4,0)+this.mese.Value()+\"01\"),this.DaDatOpe.Value()))\n\n}  \n\nfunction DaDatOpe_onChange(){\n if (!Empty(this.DaDatOpe.Value())){\n   this.ADatOpe.Value(arfn_finemese(this.DaDatOpe.Value()))    \n }\n}\n\nfunction Print() {\n  if (confirm(\"Confermi la stampa dei movimenti?\")) {\n    this.RTPrint.Link();  \n  }   \n}  \n\nfunction Download() {\n  if (confirm(\"Confermi il download del file?\")) {\n    this.RTDown.Link();  \n  }   \n}  ","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Creazione File per OAM","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pLog }}{{ @pMsg }}{{ @anno }}{{ @lblAnno }}{{ @mese }}{{ @lblMese }}{{ @DaDatOpe }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @iPrint }}{{ @tipofile }}{{ @lblTipoFile }}{{ @anno }}{{ @lblAnno }}{{ @mese }}{{ @lblMese }}{{ @DaDatOpe }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @iPrint }}{{ @tipofile }}{{ @lblTipoFile }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"340","hsl":"false","htmlcode":"{{ @PortletLogs }} \n\n{{ @lblTipoFile }}\n{{ @tipofile }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @iPrint }}\n\n\n\n\n\n\n\n{{ @lblAOpe }}\n{{ @lblDaOpe }}\n{{ @ADatOpe }}\n{{ @DaDatOpe }}\n{{ @lblMese }}\n{{ @mese }}\n{{ @lblAnno }}\n{{ @anno }}\n\n\n\n\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"100%","min_w":"800","mode":"NORMAL","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"340\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"allowedentities":"arrt_oam_invio","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"23","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_dadata=DaDatOpe,w_a_data=ADatOpe,w_anno=anno,w_mese=mese,w_tipofile=tipofile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"1","servlet":"arrt_oam_invio","target":"","type":"SPLinker","w":"75","x":"66","y":"-58"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"2","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"260","zindex":"3","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"53","wireframe_props":"name","x":"175","y":"29","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"155","wireframe_props":"align,value,n_col","x":"18","y":"30","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"mese","page":"1","picture":"","rapp":"","sequence":"5","spuid":"","tabindex":"","textlist":"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre","type":"Combobox","typevar":"character","valuelist":"01,02,03,04,05,06,07,08,09,10,11,12","visible":"true","w":"212","wireframe_props":"name,textlist","x":"309","y":"29","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblMese","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Mese:","w":"69","wireframe_props":"align,value,n_col","x":"236","y":"30","zindex":"1","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"683","y":"12","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"683","y":"46","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"150","wireframe_props":"align,value,n_col","x":"531","y":"13","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"150","wireframe_props":"align,value,n_col","x":"531","y":"47","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTPrint","offline":"false","page":"1","parms":"ReportName=arrp_stp_fileage,outputFormat=PDF,rotation=LANDSCAPE,DescAzi=gDescAzi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"","target":"iPrint","type":"SPLinker","w":"74","x":"334","y":"-61"},{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"13","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"107","zindex":"9","zone":""},{"allowedentities":"arrt_downloadfile_code","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDown","offline":"false","page":"1","parms":"pCodice=codice,pTipo=OAM","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arrt_downloadfile_code","target":"","type":"SPLinker","w":"78","x":"437","y":"-61"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipofile","page":"1","picture":"","rapp":"","sequence":"15","spuid":"","tabindex":"","textlist":"Ordinario,Sostitutivo","type":"Combobox","typevar":"numeric","valuelist":"0,1","visible":"true","w":"212","wireframe_props":"name,textlist","x":"309","y":"76","zindex":"10","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTipoFile","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo File:","w":"82","wireframe_props":"align,value,n_col","x":"223","y":"77","zindex":"11","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"572","y":"-61"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"false","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"codice","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"818","y":"-59"}]%>
<%/*Description:Creazione File per OAM*/%>
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
window.pg_oam_invio_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Crea !='undefined')this.Crea=Crea;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof anno_onChange !='undefined')this.anno_onChange=anno_onChange;
if(typeof mese_onChange !='undefined')this.mese_onChange=mese_onChange;
if(typeof CalcolaDate !='undefined')this.CalcolaDate=CalcolaDate;
if(typeof DaDatOpe_onChange !='undefined')this.DaDatOpe_onChange=DaDatOpe_onChange;
if(typeof Print !='undefined')this.Print=Print;
if(typeof Download !='undefined')this.Download=Download;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Estrazione mensile Operazioni per OAM",true)  
  this.getTitlePortlet().AppendButton({
    id:"Crea",
    title:FormatMsg('Crea'),
    tooltip:FormatMsg('Crea il file dei movimenti OAM'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4b;"},
    action:'javascript:' + this.formid +'.Crea()'
  },3);      
  this.getTitlePortlet().AppendButton({
    id:"Print",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg("Stampa l'elenco dei movimenti selezionati"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb06;"},
    action:'javascript:' + this.formid +'.Stampa()'
  },2);      
  this.getTitlePortlet().AppendButton({
    id:"Download",
    title:FormatMsg('Download'),
    tooltip:FormatMsg("Preleva il file generato"),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe9dd;"},
    action:'javascript:' + this.formid +'.Download()'
  },1);        
}
function Crea(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.PortletLogs.Start();   
    this.RTExec.Link()
  }  
}
function RTExec_Result(result){
  this.PortletLogs.Stop();        
  alert("Elaborazione Completata!");
  this.codice.Value(result);
}
function anno_onChange(){
  if(this.anno.Value()==0) {
    this.mese.Value("")    
    this.DaDatOpe.Value(NullDate())
    this.ADatOpe.Value(NullDate())
  } else {
    this.CalcolaDate() 
  }  
}
function mese_onChange(){
  if(Empty(this.mese.Value())) {
    this.DaDatOpe.Value(NullDate())
    this.ADatOpe.Value(NullDate())    
  } else {
    this.CalcolaDate()      
  }  
}
function CalcolaDate() {
 this.DaDatOpe.Value(iif(!Empty(this.anno.Value()) && !Empty(this.mese.Value()),CharToDate(Str(this.anno.Value(),4,0)+this.mese.Value()+"01"),this.DaDatOpe.Value()))
}  
function DaDatOpe_onChange(){
 if (!Empty(this.DaDatOpe.Value())){
   this.ADatOpe.Value(arfn_finemese(this.DaDatOpe.Value()))    
 }
}
function Print() {
  if (confirm("Confermi la stampa dei movimenti?")) {
    this.RTPrint.Link();  
  }   
}  
function Download() {
  if (confirm("Confermi il download del file?")) {
    this.RTDown.Link();  
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
.pg_oam_invio_container {
  height:100%;
  overflow:auto;
}
.pg_oam_invio_title_container {
  margin: auto;
}
.pg_oam_invio_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:100%;
  min-width:800px;
  height:100%;
}
.pg_oam_invio_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_oam_invio_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:260px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_oam_invio_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:175px;
  width:53px;
  height:20px;
}
.pg_oam_invio_portlet > .anno_ctrl {
}
.pg_oam_invio_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_oam_invio_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:30px;
  left:18px;
  width:155px;
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_oam_invio_portlet > .mese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:309px;
  width:212px;
  height:20px;
}
.pg_oam_invio_portlet > .lblMese_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:30px;
  left:236px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblMese_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblMese_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_oam_invio_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:683px;
  width:86px;
  height:20px;
}
.pg_oam_invio_portlet > .DaDatOpe_ctrl {
}
.pg_oam_invio_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oam_invio_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:46px;
  left:683px;
  width:86px;
  height:20px;
}
.pg_oam_invio_portlet > .ADatOpe_ctrl {
}
.pg_oam_invio_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oam_invio_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:531px;
  width:150px;
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_oam_invio_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  left:531px;
  width:150px;
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oam_invio_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_oam_invio_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:107px;
  left:0px;
  right:0px;
  width:auto;
  height:150px;
}
.pg_oam_invio_portlet > .tipofile_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:76px;
  left:309px;
  width:212px;
  height:20px;
}
.pg_oam_invio_portlet > .lblTipoFile_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:77px;
  left:223px;
  width:82px;
  height:auto;
  min-height:20px;
}
.pg_oam_invio_portlet > .lblTipoFile_ctrl {
  height:auto;
  min-height:20px;
}
.pg_oam_invio_portlet > .lblTipoFile_ctrl {
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
 String def="[{\"h\":\"340\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"66\",\"y\":\"-58\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"260\",\"zindex\":\"3\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"175\",\"y\":\"29\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"155\",\"x\":\"18\",\"y\":\"30\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"mese\",\"page\":\"1\",\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"309\",\"y\":\"29\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMese\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"69\",\"x\":\"236\",\"y\":\"30\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"683\",\"y\":\"12\",\"zindex\":\"2\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"683\",\"y\":\"46\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"150\",\"x\":\"531\",\"y\":\"13\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"150\",\"x\":\"531\",\"y\":\"47\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTPrint\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"74\",\"x\":\"334\",\"y\":\"-61\"},{\"anchor\":\"top-left-right\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"107\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"RTDown\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"78\",\"x\":\"437\",\"y\":\"-61\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipofile\",\"page\":\"1\",\"textlist\":\"Ordinario,Sostitutivo\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"309\",\"y\":\"76\",\"zindex\":\"10\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTipoFile\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo File:\",\"w\":\"82\",\"x\":\"223\",\"y\":\"77\",\"zindex\":\"11\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"572\",\"y\":\"-61\"},{\"h\":\"20\",\"name\":\"codice\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"818\",\"y\":\"-59\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_oam_invio","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_oam_invio_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("arfn_finemese.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_oam_invio','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double anno= 0;
if(request.getAttribute("pg_oam_invio_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String mese= "";
String lblMese= "Mese:";
java.sql.Date DaDatOpe= JSPLib.NullDate();
java.sql.Date ADatOpe= JSPLib.NullDate();
String lblDaOpe= "Da Data Operazione:";
String lblAOpe= "A Data Operazione:";
double tipofile= 0;
String lblTipoFile= "Tipo File:";
String gDescAzi=sp.getGlobal("gDescAzi","");
String codice= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_oam_invio_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_oam_invio_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_oam_invio_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_oam_invio','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<select id='<%=idPortlet%>_mese' name='mese' class='combobox' style=''></select>
<span id='<%=idPortlet%>_lblMese'  formid='<%=idPortlet%>' ps-name='lblMese'    class='label lblMese_ctrl'><div id='<%=idPortlet%>_lblMesetbl' style='width:100%;'><%=JSPLib.ToHTML("Mese:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<select id='<%=idPortlet%>_tipofile' name='tipofile' class='combobox' style=''></select>
<span id='<%=idPortlet%>_lblTipoFile'  formid='<%=idPortlet%>' ps-name='lblTipoFile'    class='label lblTipoFile_ctrl'><div id='<%=idPortlet%>_lblTipoFiletbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo File:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_oam_invio');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea",true)+","+JSPLib.ToJSValue(sp.translate("Crea"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea il file dei movimenti OAM",true)+","+JSPLib.ToJSValue(sp.translate("Crea il file dei movimenti OAM"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Download",true)+","+JSPLib.ToJSValue(sp.translate("Download"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Preleva il file generato",true)+","+JSPLib.ToJSValue(sp.translate("Preleva il file generato"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa l'elenco dei movimenti selezionati",true)+","+JSPLib.ToJSValue(sp.translate("Stampa l'elenco dei movimenti selezionati"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_oam_invio',["800"],["340"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"340","title":"","layer":""}]);
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_oam_invio",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":23,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_dadata=DaDatOpe,w_a_data=ADatOpe,w_anno=anno,w_mese=mese,w_tipofile=tipofile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_oam_invio","target":"","type":"SPLinker","w":75,"x":66,"y":-58});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_oam_invio",request.getSession())%>';
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":260,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=anno%>","w":53,"x":175,"y":29,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":155,"x":18,"y":30,"zindex":"1"});
this.mese=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_mese","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=mese%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"mese","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre","type":"Combobox","typevar":"character","valuelist":"01,02,03,04,05,06,07,08,09,10,11,12","visible":true,"w":212,"x":309,"y":29,"zindex":"1"});
this.lblMese=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMese","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMese","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblMese,false,true)%>","type":"Label","w":69,"x":236,"y":30,"zindex":"1"});
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=DaDatOpe%>","w":86,"x":683,"y":12,"zerofilling":false,"zindex":"2","zoom":""});
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=ADatOpe%>","w":86,"x":683,"y":46,"zerofilling":false,"zindex":"2","zoom":""});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":150,"x":531,"y":13,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":150,"x":531,"y":47,"zindex":"1"});
this.RTPrint=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPrint","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPrint","offline":false,"page":1,"parms":"ReportName=arrp_stp_fileage,outputFormat=PDF,rotation=LANDSCAPE,DescAzi=gDescAzi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":74,"x":334,"y":-61});
this.RTPrint.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":107,"zindex":"9"});
this.RTDown=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_downloadfile_code",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDown","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDown","offline":false,"page":1,"parms":"pCodice=codice,pTipo=OAM","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadfile_code","target":"","type":"SPLinker","w":78,"x":437,"y":-61});
this.RTDown.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadfile_code",request.getSession())%>';
this.tipofile=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipofile","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipofile%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipofile","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Ordinario,Sostitutivo","type":"Combobox","typevar":"numeric","valuelist":"0,1","visible":true,"w":212,"x":309,"y":76,"zindex":"10"});
this.lblTipoFile=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTipoFile","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTipoFile","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTipoFile,false,true)%>","type":"Label","w":82,"x":223,"y":77,"zindex":"11"});
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.codice=new ZtVWeb._VC(this,'codice',null,'character','<%=JSPLib.ToJSValue(codice,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_oam_invio_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_oam_invio_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_oam_invio_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.mese.FillData();
window.<%=idPortlet%>.tipofile.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_oam_invio',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_oam_invio');
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
sp.endPage("pg_oam_invio");
}%>
<%! public String getJSPUID() { return "1042972951"; } %>