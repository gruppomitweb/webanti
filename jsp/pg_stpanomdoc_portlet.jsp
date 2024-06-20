<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Stampa Soggetti con anomalie su documento\",true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa il risultato della ricerca'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb05;\"},\n    action:'javascript:' + this.formid +'.Image_print_Click()'\n  },2);      \n}\n\nfunction Image_print_Click(){\n  this.in.Value(iif(this.attive.Value()==1,\"'0','1'\",\"'0','1','2','3'\"))\n  this.RTStampa.Link()              \n}\n\nfunction attive_onChange(){\n  if(this.attive.Value()==1) {\n    this.ChkEst.Value(2)\n  } else { \n    this.ChkEst.Value(1)    \n    this.TABELLA.Value('intestbo')\n  }  \n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"500","hsl":"","htmlcode":"{{ @TABELLA }}\n{{ @iPrint }}\n{{ @attive }}\n\n\n{{ @ChkEst }}\n{{ @autril }}\n{{ @docsca }}\n{{ @Label23 }}\n{{ @DaData }}\n\n\n\n\n{{ @datril }}\n\n{{ @numdoc }}\n{{ @tipdoc }}\n\n\n\n\n{{ gAzienda }}\n{{ simili }}\n{{ Variable_codazi }}\n{{ SQLDataobj_qbe_tot_sog_web }}\n{{ SQLDataobj_count_tmp_seek_sogg }}\n{{ Variable_totrec }}\n{{ Variable_count_tmp_seek_sogg }}\n{{ Label_criterio }}\n{{ Portlet_showlog }}\n{{ Radio_criterio }}\n{{ Image_esegui }}\n{{ Checkbox_flgnote }}\n{{ Image_print }}\n{{ Checkbox_flgnega }}\n{{ Portlet_showmsg }}\n{{ RTRicerca }}{{ nominativo }}\n{{ Checkbox_flgafon }}\n{{ SPLinker_report }}\n{{ Iframe_elaborazione }}\n{{ lblDenom }}\n{{ denomin }}\n{{ lblSimili }}\n{{ RTAzzeraMessaggi }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"1024","layout_steps_values":"{\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"},\"1024\":{\"h\":\"500\",\"w\":\"1024\"}}","lock_items":"","manifest":"Custom manifest","max_w":"1024","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768,1024","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"1024","wizard":""},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Autorità di Rilascio mancante","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":98,\"w\":88,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":98,\"w\":132,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":98,\"w\":\"139\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":167,\"w\":211,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":168,\"w\":\"281\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"autril","page":"1","sequence":"1","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"281","wireframe_props":"label_text","x":"170","y":"168","zindex":"5"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTStampa","offline":"false","page":"1","parms":"ReportName=arrp_stpanomdoc.vrp,numdoc=numdoc,datril=datril,docsca=docsca,autril=autril,DaData=DaData,ChkEst=ChkEst,TABELLA=TABELLA,attive=attive,in=in,OrderBy=RAGSOC,desazi=gDescAzi,rotation=LANDSCAPE,showParameterMask=false","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"1062","y":"-51"},{"anchor":"","calculate":"'intestbo'","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"ChkEst=1","init":"true","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":745,\"y\":52,\"w\":267,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":745,\"y\":52,\"w\":267,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":745,\"y\":52,\"w\":267,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":745,\"y\":52,\"w\":\"267\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"TABELLA","page":"1","picture":"","sequence":"3","spuid":"","tabindex":"","textlist":"Intestatari rapporti,Delegati sui rapporti,Titolari Effettivi","type":"Combobox","typevar":"character","valuelist":"intestbo,delegabo,intestit","visible":"true","w":"267","wireframe_props":"name,textlist","x":"745","y":"52","zindex":"10"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"1","layer":"false","layout_steps_values":"{\"320\":{\"x\":745,\"y\":21,\"w\":267,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":745,\"y\":21,\"w\":267,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":745,\"y\":21,\"w\":267,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":745,\"y\":21,\"w\":\"267\",\"h\":22,\"anchor\":\"\",\"hide\":\"false\"}}","name":"ChkEst","page":"1","picture":"","sequence":"4","spuid":"","tabindex":"","textlist":"Tutti i soggetti,Solo quelli presenti in","type":"Combobox","typevar":"numeric","valuelist":"1,2","visible":"true","w":"267","wireframe_props":"name,textlist","x":"745","y":"21","zindex":"9"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Solo per le registrazioni attive","layer":"false","layout_steps_values":"{\"320\":{\"x\":745,\"y\":163,\"w\":281,\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":745,\"y\":163,\"w\":281,\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":745,\"y\":163,\"w\":281,\"h\":25,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":745,\"y\":163,\"w\":\"281\",\"h\":25,\"anchor\":\"\",\"hide\":\"false\"}}","name":"attive","page":"1","sequence":"5","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"281","wireframe_props":"label_text","x":"745","y":"163","zindex":"11"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1063","y":"-25"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"in","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1065","y":"4"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"299","hide":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":202,\"w\":1024,\"h\":299,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":202,\"w\":1024,\"h\":299,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":202,\"w\":1024,\"h\":299,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":0,\"y\":202,\"w\":\"1024\",\"h\":299,\"anchor\":\"\",\"hide\":\"false\"}}","name":"iPrint","page":"1","sequence":"8","spuid":"","type":"Iframe","w":"1024","wireframe_props":"","x":"0","y":"202","zindex":"14"},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Tipo Documento Mancante","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":41,\"w\":108,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":41,\"w\":162,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":41,\"w\":\"170\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":110,\"w\":259,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":52,\"w\":\"281\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"tipdoc","page":"1","sequence":"9","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"281","wireframe_props":"label_text","x":"170","y":"52","zindex":"3"},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Numero Documento Mancante","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":68,\"w\":148,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":68,\"w\":222,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":68,\"w\":\"232\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":137,\"w\":355,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":81,\"w\":\"281\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"numdoc","page":"1","sequence":"10","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"281","wireframe_props":"label_text","x":"170","y":"81","zindex":"4"},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Data Rilascio Mancante","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":98,\"w\":88,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":98,\"w\":132,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":98,\"w\":\"139\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":167,\"w\":211,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":110,\"w\":\"281\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"datril","page":"1","sequence":"11","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"281","wireframe_props":"label_text","x":"170","y":"110","zindex":"5"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":203,\"y\":21,\"w\":173,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":203,\"y\":21,\"w\":173,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":203,\"y\":21,\"w\":173,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":21,\"w\":\"173\",\"h\":22,\"anchor\":\"\",\"hide\":\"false\"}}","maxlength":"","name":"DaData","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"12","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"173","wireframe_props":"name","x":"170","y":"21","zerofilling":"false","zindex":"6"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{\"320\":{\"x\":7,\"y\":21,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":7,\"y\":21,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":7,\"y\":21,\"w\":158,\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"1024\":{\"x\":7,\"y\":21,\"w\":\"158\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"Label23","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Situazione alla data:","w":"158","wireframe_props":"align,value,n_col","x":"7","y":"21","zindex":"7"},{"anchor":"","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Documento Scaduto","layer":"false","layout_steps_values":"{\"320\":{\"x\":6,\"y\":68,\"w\":148,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":9,\"y\":68,\"w\":222,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"500\":{\"x\":9,\"y\":68,\"w\":\"232\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":14,\"y\":137,\"w\":355,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":170,\"y\":139,\"w\":\"281\",\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","name":"docsca","page":"1","sequence":"14","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"281","wireframe_props":"label_text","x":"170","y":"139","zindex":"4"}]%>
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
window.pg_stpanomdoc_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image_print_Click !='undefined')this.Image_print_Click=Image_print_Click;
if(typeof attive_onChange !='undefined')this.attive_onChange=attive_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.ChkEst.Value(),1),this.TABELLA);
}
ZtVWeb.InitCtrl('S',this.autril);
ZtVWeb.InitCtrl('intestbo',this.TABELLA);
ZtVWeb.InitCtrl('S',this.tipdoc);
ZtVWeb.InitCtrl('S',this.numdoc);
ZtVWeb.InitCtrl('S',this.datril);
ZtVWeb.InitCtrl(SystemDate(),this.DaData);
ZtVWeb.InitCtrl('S',this.docsca);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Stampa Soggetti con anomalie su documento",true)
  this.getTitlePortlet().AppendButton({
    id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa il risultato della ricerca'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb05;"},
    action:'javascript:' + this.formid +'.Image_print_Click()'
  },2);      
}
function Image_print_Click(){
  this.in.Value(iif(this.attive.Value()==1,"'0','1'","'0','1','2','3'"))
  this.RTStampa.Link()              
}
function attive_onChange(){
  if(this.attive.Value()==1) {
    this.ChkEst.Value(2)
  } else { 
    this.ChkEst.Value(1)    
    this.TABELLA.Value('intestbo')
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
.pg_stpanomdoc_container {
}
.pg_stpanomdoc_title_container {
  margin: auto;
}
.pg_stpanomdoc_portlet{
  position:relative;
  margin: auto;
  width:1024px;
max-width:1024px;
  min-width:320px;
  height:500px;
}
.pg_stpanomdoc_portlet[Data-page="1"]{
  height:500px;
  width:1024px;
}
.pg_stpanomdoc_portlet[Data-step="320"] {
  height:500px;
  width:100%;
}
.pg_stpanomdoc_portlet[Data-step="480"] {
  height:500px;
  width:100%;
}
.pg_stpanomdoc_portlet[Data-step="768"] {
  height:500px;
  width:100%;
}
.pg_stpanomdoc_portlet[Data-step="1024"] {
  height:500px;
  width:1024px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .autril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:168px;
  left:170px;
  width:281px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .autril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:98px;
  left:6px;
  width:88px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .autril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:98px;
  left:9px;
  width:132px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .autril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:167px;
  left:14px;
  width:211px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .TABELLA_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:52px;
  left:745px;
  width:267px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .TABELLA_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:52px;
  left:745px;
  width:267px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .TABELLA_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:52px;
  left:745px;
  width:267px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .TABELLA_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:52px;
  left:745px;
  width:267px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .ChkEst_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:21px;
  left:745px;
  width:267px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .ChkEst_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:21px;
  left:745px;
  width:267px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .ChkEst_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:21px;
  left:745px;
  width:267px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .ChkEst_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:21px;
  left:745px;
  width:267px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .attive_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:163px;
  left:745px;
  width:281px;
  height:25px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .attive_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:163px;
  left:745px;
  width:281px;
  height:25px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .attive_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:163px;
  left:745px;
  width:281px;
  height:25px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .attive_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:163px;
  left:745px;
  width:281px;
  height:25px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:202px;
  left:0px;
  width:1024px;
  height:299px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .tipdoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:52px;
  left:170px;
  width:281px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .tipdoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:6px;
  width:108px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .tipdoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:9px;
  width:162px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .tipdoc_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:110px;
  left:14px;
  width:259px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .numdoc_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:81px;
  left:170px;
  width:281px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .numdoc_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:68px;
  left:6px;
  width:148px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .numdoc_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:68px;
  left:9px;
  width:222px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .numdoc_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:137px;
  left:14px;
  width:355px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .datril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:110px;
  left:170px;
  width:281px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .datril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:98px;
  left:6px;
  width:88px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .datril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:98px;
  left:9px;
  width:132px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .datril_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:167px;
  left:14px;
  width:211px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:170px;
  width:173px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:203px;
  width:173px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:203px;
  width:173px;
  height:22px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .DaData_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:21px;
  left:203px;
  width:173px;
  height:22px;
}
.pg_stpanomdoc_portlet > .DaData_ctrl {
}
.pg_stpanomdoc_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomdoc_portlet[Data-step="1024"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomdoc_portlet[Data-step="320"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomdoc_portlet[Data-step="480"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .Label23_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:21px;
  left:7px;
  width:158px;
  height:auto;
  min-height:20px;
}.pg_stpanomdoc_portlet[Data-step="768"] > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpanomdoc_portlet > .Label23_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .Label23_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_stpanomdoc_portlet[Data-step="1024"] > .docsca_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:139px;
  left:170px;
  width:281px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="320"] > .docsca_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:68px;
  left:6px;
  width:148px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="480"] > .docsca_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:68px;
  left:9px;
  width:222px;
  height:20px;
}
.pg_stpanomdoc_portlet[Data-step="768"] > .docsca_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:137px;
  left:14px;
  width:355px;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{\"1024\":{\"h\":\"500\",\"w\":\"1024\"},\"320\":{\"h\":\"500\",\"w\":\"100%\"},\"480\":{\"h\":\"500\",\"w\":\"100%\"},\"768\":{\"h\":\"500\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768,1024\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"1024\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Autorità di Rilascio mancante\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"281\",\"x\":170,\"y\":168},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":88,\"x\":6,\"y\":98},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":132,\"x\":9,\"y\":98},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"139\",\"x\":9,\"y\":98},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":211,\"x\":14,\"y\":167}},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"170\",\"y\":\"168\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1062\",\"y\":\"-51\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"267\",\"x\":745,\"y\":52},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":267,\"x\":745,\"y\":52},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":267,\"x\":745,\"y\":52},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":267,\"x\":745,\"y\":52}},\"name\":\"TABELLA\",\"page\":\"1\",\"textlist\":\"Intestatari rapporti,Delegati sui rapporti,Titolari Effettivi\",\"type\":\"Combobox\",\"w\":\"267\",\"x\":\"745\",\"y\":\"52\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":\"267\",\"x\":745,\"y\":21},\"320\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":267,\"x\":745,\"y\":21},\"480\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":267,\"x\":745,\"y\":21},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":267,\"x\":745,\"y\":21}},\"name\":\"ChkEst\",\"page\":\"1\",\"textlist\":\"Tutti i soggetti,Solo quelli presenti in\",\"type\":\"Combobox\",\"w\":\"267\",\"x\":\"745\",\"y\":\"21\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"25\",\"label_text\":\"Solo per le registrazioni attive\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":\"281\",\"x\":745,\"y\":163},\"320\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":281,\"x\":745,\"y\":163},\"480\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":281,\"x\":745,\"y\":163},\"768\":{\"anchor\":\"\",\"h\":25,\"hide\":\"false\",\"w\":281,\"x\":745,\"y\":163}},\"name\":\"attive\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"745\",\"y\":\"163\",\"zindex\":\"11\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1063\",\"y\":\"-25\"},{\"h\":\"20\",\"name\":\"in\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1065\",\"y\":\"4\"},{\"anchor\":\"\",\"h\":\"299\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":\"1024\",\"x\":0,\"y\":202},\"320\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":202},\"480\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":202},\"768\":{\"anchor\":\"\",\"h\":299,\"hide\":\"false\",\"w\":1024,\"x\":0,\"y\":202}},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"202\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Tipo Documento Mancante\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"281\",\"x\":170,\"y\":52},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":108,\"x\":6,\"y\":41},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":162,\"x\":9,\"y\":41},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"170\",\"x\":9,\"y\":41},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":259,\"x\":14,\"y\":110}},\"name\":\"tipdoc\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"170\",\"y\":\"52\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Numero Documento Mancante\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"281\",\"x\":170,\"y\":81},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":148,\"x\":6,\"y\":68},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":222,\"x\":9,\"y\":68},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"232\",\"x\":9,\"y\":68},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":355,\"x\":14,\"y\":137}},\"name\":\"numdoc\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"170\",\"y\":\"81\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Data Rilascio Mancante\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"281\",\"x\":170,\"y\":110},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":88,\"x\":6,\"y\":98},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":132,\"x\":9,\"y\":98},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"139\",\"x\":9,\"y\":98},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":211,\"x\":14,\"y\":167}},\"name\":\"datril\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"170\",\"y\":\"110\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":\"173\",\"x\":170,\"y\":21},\"320\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":173,\"x\":203,\"y\":21},\"480\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":173,\"x\":203,\"y\":21},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":173,\"x\":203,\"y\":21}},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"173\",\"x\":\"170\",\"y\":\"21\",\"zindex\":\"6\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"158\",\"x\":7,\"y\":21},\"320\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":158,\"x\":7,\"y\":21},\"480\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":158,\"x\":7,\"y\":21},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":158,\"x\":7,\"y\":21}},\"n_col\":\"1\",\"name\":\"Label23\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Situazione alla data:\",\"w\":\"158\",\"x\":\"7\",\"y\":\"21\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Documento Scaduto\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"281\",\"x\":170,\"y\":139},\"320\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":148,\"x\":6,\"y\":68},\"480\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":222,\"x\":9,\"y\":68},\"500\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":\"232\",\"x\":9,\"y\":68},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":355,\"x\":14,\"y\":137}},\"name\":\"docsca\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"281\",\"x\":\"170\",\"y\":\"139\",\"zindex\":\"4\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stpanomdoc","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stpanomdoc_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stpanomdoc','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String autril= "";
String TABELLA= "";
double ChkEst=1;
boolean attive= false;
String gDescAzi=sp.getGlobal("gDescAzi","");
String in= "";
String tipdoc= "";
String numdoc= "";
String datril= "";
java.sql.Date DaData= JSPLib.NullDate();
if(request.getAttribute("pg_stpanomdoc_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label23= "Situazione alla data:";
String docsca= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stpanomdoc_title_container' style='width:1024px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stpanomdoc_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stpanomdoc_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stpanomdoc','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_autril_div' style=''><input id='<%=idPortlet%>_autril' name='autril' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_autril' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Autorità di Rilascio mancante")%></label></div>
<select id='<%=idPortlet%>_TABELLA' name='TABELLA' class='combobox' style='display:none;'></select>
<select id='<%=idPortlet%>_ChkEst' name='ChkEst' class='combobox' style=''></select>
<div id='<%=idPortlet%>_attive_div' style=''><input id='<%=idPortlet%>_attive' name='attive' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_attive' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Solo per le registrazioni attive")%></label></div>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_tipdoc_div' style=''><input id='<%=idPortlet%>_tipdoc' name='tipdoc' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_tipdoc' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Tipo Documento Mancante")%></label></div>
<div id='<%=idPortlet%>_numdoc_div' style=''><input id='<%=idPortlet%>_numdoc' name='numdoc' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_numdoc' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Numero Documento Mancante")%></label></div>
<div id='<%=idPortlet%>_datril_div' style=''><input id='<%=idPortlet%>_datril' name='datril' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_datril' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Data Rilascio Mancante")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' /></span>
<span id='<%=idPortlet%>_Label23'  formid='<%=idPortlet%>' ps-name='Label23'    class='label Label23_ctrl'><div id='<%=idPortlet%>_Label23tbl' style='width:100%;'><%=JSPLib.ToHTML("Situazione alla data:")%></div></span>
<div id='<%=idPortlet%>_docsca_div' style=''><input id='<%=idPortlet%>_docsca' name='docsca' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_docsca' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Documento Scaduto")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stpanomdoc');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa il risultato della ricerca",true)+","+JSPLib.ToJSValue(sp.translate("Stampa il risultato della ricerca"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stpanomdoc',["1024"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768,1024', 'fixed','<%=m_cTITLEUID%>','',{"1024":{"h":"500","w":"1024"},"320":{"h":"500","w":"100%"},"480":{"h":"500","w":"100%"},"768":{"h":"500","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"500"},"1024":{"w":"1024","h":"500"},"768":{"w":"100%","h":"500"},"480":{"w":"100%","h":"500"}},"w":"1024","h":"500","title":"","layer":"false","npage":"1"}]);
this.autril=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_autril","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Autorità di Rilascio mancante","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"281","x":170,"y":168},"320":{"anchor":"","h":20,"hide":"false","w":88,"x":6,"y":98},"480":{"anchor":"","h":20,"hide":"false","w":132,"x":9,"y":98},"500":{"anchor":"","h":20,"hide":"false","w":"139","x":9,"y":98},"768":{"anchor":"","h":20,"hide":"false","w":211,"x":14,"y":167}},"name":"autril","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":211,"x":14,"y":167,"zindex":"5"});
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"ReportName=arrp_stpanomdoc.vrp,numdoc=numdoc,datril=datril,docsca=docsca,autril=autril,DaData=DaData,ChkEst=ChkEst,TABELLA=TABELLA,attive=attive,in=in,OrderBy=RAGSOC,desazi=gDescAzi,rotation=LANDSCAPE,showParameterMask=false","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":1062,"y":-51});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.TABELLA=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"'intestbo'","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_TABELLA","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.ChkEst.Value(),1)","init":"true","init_par":"<%=TABELLA%>","isdatap":false,"layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"267","x":745,"y":52},"320":{"anchor":"","h":20,"hide":"false","w":267,"x":745,"y":52},"480":{"anchor":"","h":20,"hide":"false","w":267,"x":745,"y":52},"768":{"anchor":"","h":20,"hide":"false","w":267,"x":745,"y":52}},"name":"TABELLA","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Intestatari rapporti,Delegati sui rapporti,Titolari Effettivi","type":"Combobox","typevar":"character","valuelist":"intestbo,delegabo,intestit","visible":true,"w":267,"x":745,"y":52,"zindex":"10"});
this.ChkEst=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_ChkEst","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=ChkEst%>","isdatap":false,"layer":false,"layout_steps_values":{"1024":{"anchor":"","h":22,"hide":"false","w":"267","x":745,"y":21},"320":{"anchor":"","h":22,"hide":"false","w":267,"x":745,"y":21},"480":{"anchor":"","h":22,"hide":"false","w":267,"x":745,"y":21},"768":{"anchor":"","h":22,"hide":"false","w":267,"x":745,"y":21}},"name":"ChkEst","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Tutti i soggetti,Solo quelli presenti in","type":"Combobox","typevar":"numeric","valuelist":"1,2","visible":true,"w":267,"x":745,"y":21,"zindex":"9"});
this.attive=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_attive","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":25,"hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Solo per le registrazioni attive","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":25,"hide":"false","w":"281","x":745,"y":163},"320":{"anchor":"","h":25,"hide":"false","w":281,"x":745,"y":163},"480":{"anchor":"","h":25,"hide":"false","w":281,"x":745,"y":163},"768":{"anchor":"","h":25,"hide":"false","w":281,"x":745,"y":163}},"name":"attive","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":281,"x":745,"y":163,"zindex":"11"});
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.in=new ZtVWeb._VC(this,'in',null,'character','<%=JSPLib.ToJSValue(in,false,true)%>',false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":299,"hide":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":299,"hide":"false","w":"1024","x":0,"y":202},"320":{"anchor":"","h":299,"hide":"false","w":1024,"x":0,"y":202},"480":{"anchor":"","h":299,"hide":"false","w":1024,"x":0,"y":202},"768":{"anchor":"","h":299,"hide":"false","w":1024,"x":0,"y":202}},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":1024,"x":0,"y":202,"zindex":"14"});
this.tipdoc=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_tipdoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Tipo Documento Mancante","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"281","x":170,"y":52},"320":{"anchor":"","h":20,"hide":"false","w":108,"x":6,"y":41},"480":{"anchor":"","h":20,"hide":"false","w":162,"x":9,"y":41},"500":{"anchor":"","h":20,"hide":"false","w":"170","x":9,"y":41},"768":{"anchor":"","h":20,"hide":"false","w":259,"x":14,"y":110}},"name":"tipdoc","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":259,"x":14,"y":110,"zindex":"3"});
this.numdoc=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_numdoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Numero Documento Mancante","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"281","x":170,"y":81},"320":{"anchor":"","h":20,"hide":"false","w":148,"x":6,"y":68},"480":{"anchor":"","h":20,"hide":"false","w":222,"x":9,"y":68},"500":{"anchor":"","h":20,"hide":"false","w":"232","x":9,"y":68},"768":{"anchor":"","h":20,"hide":"false","w":355,"x":14,"y":137}},"name":"numdoc","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":355,"x":14,"y":137,"zindex":"4"});
this.datril=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_datril","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Data Rilascio Mancante","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"281","x":170,"y":110},"320":{"anchor":"","h":20,"hide":"false","w":88,"x":6,"y":98},"480":{"anchor":"","h":20,"hide":"false","w":132,"x":9,"y":98},"500":{"anchor":"","h":20,"hide":"false","w":"139","x":9,"y":98},"768":{"anchor":"","h":20,"hide":"false","w":211,"x":14,"y":167}},"name":"datril","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":211,"x":14,"y":167,"zindex":"5"});
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":22,"hide":"false","w":"173","x":170,"y":21},"320":{"anchor":"","h":22,"hide":"false","w":173,"x":203,"y":21},"480":{"anchor":"","h":22,"hide":"false","w":173,"x":203,"y":21},"768":{"anchor":"","h":22,"hide":"false","w":173,"x":203,"y":21}},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaData%>","w":173,"x":203,"y":21,"zerofilling":false,"zindex":"6","zoom":""});
this.Label23=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label23","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":"1","w":"158","x":7,"y":21},"320":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":158,"x":7,"y":21},"480":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":158,"x":7,"y":21},"768":{"align":"right","anchor":"","fontpct":"","h":20,"hide":"false","n_col":1,"w":158,"x":7,"y":21}},"n_col":1,"name":"Label23","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label23,false,true)%>","type":"Label","w":158,"x":7,"y":21,"zindex":"7"});
this.docsca=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_docsca","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Documento Scaduto","layer":false,"layout_steps_values":{"1024":{"anchor":"","h":20,"hide":"false","w":"281","x":170,"y":139},"320":{"anchor":"","h":20,"hide":"false","w":148,"x":6,"y":68},"480":{"anchor":"","h":20,"hide":"false","w":222,"x":9,"y":68},"500":{"anchor":"","h":20,"hide":"false","w":"232","x":9,"y":68},"768":{"anchor":"","h":20,"hide":"false","w":355,"x":14,"y":137}},"name":"docsca","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":355,"x":14,"y":137,"zindex":"4"});
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
<%if(request.getAttribute("pg_stpanomdoc_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stpanomdoc_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stpanomdoc_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.TABELLA.FillData();
window.<%=idPortlet%>.ChkEst.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stpanomdoc',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stpanomdoc');
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
sp.endPage("pg_stpanomdoc");
}%>
<%! public String getJSPUID() { return "450421389"; } %>