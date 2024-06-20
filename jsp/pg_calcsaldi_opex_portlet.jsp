<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Calcolo Saldi Operazioni Extraconto\",true)\n  this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg(\"Esegue il calcolo dei saldi operazioni extraconto\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n      action:'javascript:' + this.formid +'.btnElab_Click()'\n  },1);       \n  this.cValuta.Value('242')\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione dei dati?\")) {\n    this.getTitlePortlet().RemoveButtons()\n    this.PortletLogs.Start();     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.getTitlePortlet().AppendButton({\n      id:\"Elabora\",\n      title:FormatMsg('Elabora'),\n      tooltip:FormatMsg(\"Esegue il calcolo dei saldi operazioni extraconto\"),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n      action:'javascript:' + this.formid +'.btnElab_Click()'\n  },1);    \n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa il risultato della generazione saldi'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.btnPrint_Click()'\n  },2);   \n  this.PortletLogs.Stop();   \n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnPrint_Click(){\n  this.RTPrint.Link()  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Calcolo Saldi Operazioni Extraconto","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pLog }}{{ @pMsg }}{{ @anno }}{{ @lblAnno }}{{ @flgazzera }}{{ @iPrint }}{{ @cValuta }}{{ @Label31 }}{{ @ndgcli }}{{ @lblNDG }}{{ @LinkZoom20 }}{{ @ragcli }}{{ @flgmopx }}{{ @btnElab }}{{ @btnExit }}{{ @anno }}{{ @lblAnno }}{{ @flgazzera }}{{ @btnPrint }}{{ @iPrint }}{{ @cValuta }}{{ @Label31 }}{{ @ndgcli }}{{ @lblNDG }}{{ @LinkZoom20 }}{{ @ragcli }}{{ @flgmopx }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"370","hsl":"false","htmlcode":"{{ @PortletLogs }} \n \n \n \n \n{{ @anno }} \n{{ @lblAnno }} \n{{ @flgazzera }} \n \n{{ @iPrint }} \n{{ @cValuta }} \n{{ @Label31 }} \n{{ @ndgcli }} \n{{ @lblNDG }} \n{{ @LinkZoom20 }} \n{{ @ragcli }} \n{{ @flgmopx }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"370\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"290","zindex":"3","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_annorif=anno,w_valuta=cValuta,w_flgazz=flgazzera,w_ndgcli=ndgcli,w_flgmopx=flgmopx","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"arrt_calcsaldi_opex","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date()) - 1","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"53","wireframe_props":"name","x":"153","y":"9","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"22","y":"10","zindex":"1","zone":""},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Azzera Saldi Precedenti (Solo se operazione di ricalcolo)","layer":"false","layout_steps_values":"{}","name":"flgazzera","page":"1","rapp":"","sequence":"5","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"408","wireframe_props":"label_text","x":"22","y":"48","zindex":"4","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTSearch","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":"80","x":"245","y":"-63"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTPrint","offline":"false","page":"1","parms":"ReportName=arrp_saldi_opex_r,w_annorif=anno,rotation=LANDSCAPE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":"74","x":"334","y":"-61"},{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"8","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"139","zindex":"9","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDown","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":"78","x":"412","y":"-63"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLValute","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"cValuta","page":"1","picture":"","rapp":"","sequence":"10","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":"true","w":"296","wireframe_props":"name,textlist","x":"367","y":"9","zindex":"10","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"500","name":"SQLValute","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tbvalute","query_async":"false","return_fields_type":"true","sequence":"11","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"554","y":"-62"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label31","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Valuta Prevalente:","w":"146","wireframe_props":"align,value,n_col","x":"217","y":"9","zindex":"12","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"ndgcli","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"225","y":"82","zerofilling":"false","zindex":"13","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblNDG","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Calcola Saldi solo per NDG:","w":"200","wireframe_props":"align,value,n_col","x":"22","y":"82","zindex":"14","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"top-left","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"ndgcli,ragcli","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"ndgcli","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom20","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"15","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"348","y":"82","zindex":"15","zone":"","zoomtitle":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"50","name":"ragcli","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"16","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"380","y":"82","zerofilling":"false","zindex":"16","zone":"","zoom":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"Empty(ndgcli)","init":"","init_par":"N","label_text":"Inserisci data rettifica su Operazione Extraconto","layer":"false","layout_steps_values":"{}","name":"flgmopx","page":"1","rapp":"","sequence":"17","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"383","wireframe_props":"label_text","x":"225","y":"112","zindex":"17","zone":""}]%>
<%/*Description:Calcolo Saldi Operazioni Extraconto*/%>
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
window.pg_calcsaldi_opex_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Empty(this.ndgcli.Value()),this.flgmopx);
}
ZtVWeb.InitCtrl(Year(SystemDate())-1,this.anno);
ZtVWeb.InitCtrl('S',this.flgazzera);
this.SQLValute.addRowConsumer(this.cValuta);
this.LinkZoom20.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Calcolo Saldi Operazioni Extraconto",true)
  this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg("Esegue il calcolo dei saldi operazioni extraconto"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
      action:'javascript:' + this.formid +'.btnElab_Click()'
  },1);       
  this.cValuta.Value('242')
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione dei dati?")) {
    this.getTitlePortlet().RemoveButtons()
    this.PortletLogs.Start();     
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.getTitlePortlet().AppendButton({
      id:"Elabora",
      title:FormatMsg('Elabora'),
      tooltip:FormatMsg("Esegue il calcolo dei saldi operazioni extraconto"),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
      action:'javascript:' + this.formid +'.btnElab_Click()'
  },1);    
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa il risultato della generazione saldi'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.btnPrint_Click()'
  },2);   
  this.PortletLogs.Stop();   
  alert("Elaborazione Completata!");
}
function btnPrint_Click(){
  this.RTPrint.Link()  
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
.pg_calcsaldi_opex_container {
  height:100%;
  overflow:auto;
}
.pg_calcsaldi_opex_title_container {
  margin: auto;
}
.pg_calcsaldi_opex_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_calcsaldi_opex_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_calcsaldi_opex_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:290px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_calcsaldi_opex_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:153px;
  width:53px;
  height:20px;
}
.pg_calcsaldi_opex_portlet > .anno_ctrl {
}
.pg_calcsaldi_opex_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_calcsaldi_opex_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:22px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_calcsaldi_opex_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_calcsaldi_opex_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:right;
  background-color:transparent;
}
.pg_calcsaldi_opex_portlet > .flgazzera_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:48px;
  left:22px;
  width:408px;
  height:20px;
}
.pg_calcsaldi_opex_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:139px;
  left:0px;
  right:0px;
  width:auto;
  height:150px;
}
.pg_calcsaldi_opex_portlet > .cValuta_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:9px;
  left:367px;
  left:45.875%;
  right:137px;
  right:17.125%;
  width:auto;
  height:20px;
}
.pg_calcsaldi_opex_portlet > .Label31_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:9px;
  left:217px;
  left:27.125%;
  right:437px;
  right:54.625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_calcsaldi_opex_portlet > .Label31_ctrl {
  height:auto;
  min-height:20px;
}
.pg_calcsaldi_opex_portlet > .Label31_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_calcsaldi_opex_portlet > .ndgcli_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:82px;
  left:225px;
  width:120px;
  height:20px;
}
.pg_calcsaldi_opex_portlet > .ndgcli_ctrl {
}
.pg_calcsaldi_opex_portlet > .ndgcli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_calcsaldi_opex_portlet > .lblNDG_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:82px;
  left:22px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_calcsaldi_opex_portlet > .lblNDG_ctrl {
  height:auto;
  min-height:20px;
}
.pg_calcsaldi_opex_portlet > .lblNDG_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_calcsaldi_opex_portlet > .LinkZoom20_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:82px;
  left:348px;
  width:20px;
  height:20px;
}
.pg_calcsaldi_opex_portlet > .ragcli_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:82px;
  left:380px;
  width:375px;
  height:20px;
}
.pg_calcsaldi_opex_portlet > .ragcli_ctrl {
}
.pg_calcsaldi_opex_portlet > .ragcli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_calcsaldi_opex_portlet > .flgmopx_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:112px;
  left:225px;
  width:383px;
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
 String def="[{\"h\":\"370\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"290\",\"zindex\":\"3\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"153\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"22\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Azzera Saldi Precedenti (Solo se operazione di ricalcolo)\",\"layout_steps_values\":{},\"name\":\"flgazzera\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"408\",\"x\":\"22\",\"y\":\"48\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"RTSearch\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"245\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTPrint\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"74\",\"x\":\"334\",\"y\":\"-61\"},{\"anchor\":\"top-left-right\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"139\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"RTDown\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"78\",\"x\":\"412\",\"y\":\"-63\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cValuta\",\"page\":\"1\",\"textlist\":\"DESCRI\",\"type\":\"Combobox\",\"w\":\"296\",\"x\":\"367\",\"y\":\"9\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"SQLValute\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"554\",\"y\":\"-62\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label31\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Valuta Prevalente:\",\"w\":\"146\",\"x\":\"217\",\"y\":\"9\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ndgcli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"225\",\"y\":\"82\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblNDG\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Calcola Saldi solo per NDG:\",\"w\":\"200\",\"x\":\"22\",\"y\":\"82\",\"zindex\":\"14\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom20\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"348\",\"y\":\"82\",\"zindex\":\"15\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ragcli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"380\",\"y\":\"82\",\"zindex\":\"16\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Inserisci data rettifica su Operazione Extraconto\",\"layout_steps_values\":{},\"name\":\"flgmopx\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"383\",\"x\":\"225\",\"y\":\"112\",\"zindex\":\"17\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_calcsaldi_opex","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_calcsaldi_opex_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_calcsaldi_opex','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double anno= 0;
if(request.getAttribute("pg_calcsaldi_opex_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String flgazzera="N";
String cValuta= "";
String Label31= "Valuta Prevalente:";
String ndgcli= "";
String lblNDG= "Calcola Saldi solo per NDG:";
if(request.getAttribute("pg_calcsaldi_opex_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String ragcli= "";
String flgmopx="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_calcsaldi_opex_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_calcsaldi_opex_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_calcsaldi_opex_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_calcsaldi_opex','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<div id='<%=idPortlet%>_flgazzera_div' style=''><input id='<%=idPortlet%>_flgazzera' name='flgazzera' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgazzera' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Azzera Saldi Precedenti (Solo se operazione di ricalcolo)")%></label></div>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<select id='<%=idPortlet%>_cValuta' name='cValuta' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label31'  formid='<%=idPortlet%>' ps-name='Label31'    class='label Label31_ctrl'><div id='<%=idPortlet%>_Label31tbl' style='width:100%;'><%=JSPLib.ToHTML("Valuta Prevalente:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ndgcli_wrp'><input id='<%=idPortlet%>_ndgcli' name='ndgcli' type='text' maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='ndgcli' /></span>
<span id='<%=idPortlet%>_lblNDG'  formid='<%=idPortlet%>' ps-name='lblNDG'    class='label lblNDG_ctrl'><div id='<%=idPortlet%>_lblNDGtbl' style='width:100%;'><%=JSPLib.ToHTML("Calcola Saldi solo per NDG:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom20'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_ragcli_wrp'><input id='<%=idPortlet%>_ragcli' name='ragcli' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='ragcli' /></span>
<div id='<%=idPortlet%>_flgmopx_div' style='display:none;'><input id='<%=idPortlet%>_flgmopx' name='flgmopx' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgmopx' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Inserisci data rettifica su Operazione Extraconto")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_calcsaldi_opex');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegue il calcolo dei saldi operazioni extraconto",true)+","+JSPLib.ToJSValue(sp.translate("Esegue il calcolo dei saldi operazioni extraconto"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa il risultato della generazione saldi",true)+","+JSPLib.ToJSValue(sp.translate("Stampa il risultato della generazione saldi"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_calcsaldi_opex',["800"],["370"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"370","title":"","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":290,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_annorif=anno,w_valuta=cValuta,w_flgazz=flgazzera,w_ndgcli=ndgcli,w_flgmopx=flgmopx","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_calcsaldi_opex","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_calcsaldi_opex",request.getSession())%>';
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())-1","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=anno%>","w":53,"x":153,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":22,"y":10,"zindex":"1"});
this.flgazzera=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgazzera","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Azzera Saldi Precedenti (Solo se operazione di ricalcolo)","layer":false,"layout_steps_values":{},"name":"flgazzera","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":408,"x":22,"y":48,"zindex":"4"});
this.flgazzera.Value('<%=flgazzera%>');
this.RTSearch=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSearch","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSearch","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":80,"x":245,"y":-63});
this.RTSearch.m_cID='<%=JSPLib.cmdHash("entity,list_filesid_portlet.jsp",request.getSession())%>';
this.RTPrint=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPrint","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPrint","offline":false,"page":1,"parms":"ReportName=arrp_saldi_opex_r,w_annorif=anno,rotation=LANDSCAPE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":74,"x":334,"y":-61});
this.RTPrint.m_cID='<%=JSPLib.cmdHash("entity,arrt_famprino_stp",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":139,"zindex":"9"});
this.RTDown=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDown","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDown","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":78,"x":412,"y":-63});
this.RTDown.m_cID='<%=JSPLib.cmdHash("routine,arrt_famgetdgn",request.getSession())%>';
this.cValuta=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cValuta","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cValuta%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"cValuta","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":true,"w":296,"x":367,"y":9,"zindex":"10"});
this.SQLValute=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbvalute","cmdHash":"<%=JSPLib.cmdHash("qbe_tbvalute",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLValute","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLValute","nrows":"500","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":554,"y":-62});
this.Label31=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label31","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label31","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label31,false,true)%>","type":"Label","w":146,"x":217,"y":9,"zindex":"12"});
this.ndgcli=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ndgcli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"16","name":"ndgcli","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ndgcli,false,true)%>","w":120,"x":225,"y":82,"zerofilling":false,"zindex":"13","zoom":""});
this.lblNDG=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblNDG","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblNDG","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblNDG,false,true)%>","type":"Label","w":200,"x":22,"y":82,"zindex":"14"});
this.LinkZoom20=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom20","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_calcsaldi_opex_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"ndgcli,ragcli","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_calcsaldi_opex_portlet.jspLinkZoom20",request.getSession())%>","linkedField":"ndgcli","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom20","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":348,"y":82,"zindex":"15","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.ragcli=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ragcli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"ragcli","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ragcli,false,true)%>","w":375,"x":380,"y":82,"zerofilling":false,"zindex":"16","zoom":""});
this.flgmopx=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgmopx","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"Empty(this.ndgcli.Value())","init":"","init_par":"N","label_text":"Inserisci data rettifica su Operazione Extraconto","layer":false,"layout_steps_values":{},"name":"flgmopx","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":383,"x":225,"y":112,"zindex":"17"});
this.flgmopx.Value('<%=flgmopx%>');
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
<%if(request.getAttribute("pg_calcsaldi_opex_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_calcsaldi_opex_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_calcsaldi_opex_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLValute.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_calcsaldi_opex',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_calcsaldi_opex');
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
sp.endPage("pg_calcsaldi_opex");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom20")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "personbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CONNES", "RAGSOC"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "2741102430"; } %>