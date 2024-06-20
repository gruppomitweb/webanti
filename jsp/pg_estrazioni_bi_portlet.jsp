<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Estrazioni per BI',true) \n  this.getTitlePortlet().AppendButton({\n    id:\"Genera_File\",\n    title:FormatMsg('Estrazione Dati'),\n    tooltip:FormatMsg('Crea il report selezionato'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb5c\"},\n    action:'javascript:' + this.formid +'.Report()'\n  },1);   \n  this.getTitlePortlet().AppendButton({\n    id:\"Uscita\",\n    title:FormatMsg('Uscita'),\n    tooltip:FormatMsg('Chiude la maschera di estrazione'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xea01\"},\n    action:'javascript:' + this.formid +'.Uscita()'\n  },2);  \n}\n\nfunction Report(){\n  if(confirm(\"Confermi la stampa?\")) {\n    this.fType.Value(\"XLS|XLSX|CSV|CSVS\")\n    this.fModel.Value(\"|||\")\n    if(this.Combobox13.Value()=='1') {\n      this.filename.Value(\"Operazioni_Sale_Conta_\"+DateToChar(this.DaData.Value())+\"_\"+DateToChar(this.A_Data.Value()))\n      this.RTStampa1.Link()\n    }\n    if(this.Combobox13.Value()=='2') {  \n      this.filename.Value(\"Estrazione_Soggetti_\"+DateToChar(this.DaData.Value())+\"_\"+DateToChar(this.A_Data.Value()))\n      this.RTStampa2.Link()\n    }  \n    if(this.Combobox13.Value()=='3') {  \n      this.filename.Value(\"Totali_Sale_Conta_\"+DateToChar(this.DaData.Value())+\"_\"+DateToChar(this.A_Data.Value()))\n      this.RTStampa3.Link()\n    } \n    if(this.Combobox13.Value()=='4') {  \n      this.filename.Value(\"Legali_Rappresentanti_\"+DateToChar(this.DaData.Value())+\"_\"+DateToChar(this.A_Data.Value()))\n      this.RTStampa4.Link()\n    }\n    if(this.Combobox13.Value()=='5') {  \n      this.filename.Value(\"Titolari_Effettivi_\"+DateToChar(this.DaData.Value())+\"_\"+DateToChar(this.A_Data.Value()))\n      this.query.Value(\"qbe_estrazione_titolari_bi\")\n      this.RTStampa5.Link()\n    }    \n  }\n}\n\nfunction Uscita(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction Combobox13_onChange(){\n  this.iPrint.Reload()\n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"400","hsl":"","htmlcode":"\n{{ @LabelAData }}\n{{ @iPrint }}\n{{ @Combobox13 }}\n{{ @A_Data }}\n{{ @LabelDaData }}\n{{ @DaData }}\n\n\n\n{{ @LabelTipo }}\n{{ Label25_Copy }}\n{{ A_Data }}\n{{ fModel }}\n{{ autril }}\n{{ numdoc }}\n{{ datril }}\n{{ docsca }}\n{{ RTEsegui }}\n{{ Label0 }}\n{{ pMsg }}\n{{ Label1 }}{{ fType }}\n{{ Combobox_anno }}\n{{ Combobox_tr{{ DaData }}imestre }}{{ tipdoc }}\n{{ RTUscita }}\n{{ Image_esegui_estrazione }}{{ Calendario24 }}{{ gDescAzi }}\n{{ RTEstrazione{{ Label25 }}_trimestrale }}\n{{ RTAzzera }}\n{{ Label_nota }}\n{{ Label_nota2 }}\n{{ pLog }}\n{{ btnExit }}\n{{ Label_periodo }}\n{{ Image_download }}\n{{ RTDownload }}\n{{ nomeFile }}\n{{ RTCheck }}\n{{ Check }}\n{{ last_run }}\n{{ last_anno }}\n{{ last_trim }}\n{{ iPrint }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"400","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Stampa Revisione Profili Rischio","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"900","wizard":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"1","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"977","y":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelAData","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data:","w":"144","wireframe_props":"align,value,n_col","x":"343","y":"61","zindex":"8"},{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","h":"302","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"3","spuid":"","type":"Iframe","w":"900","wireframe_props":"","x":"0","y":"97","zindex":"6"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaData","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"character","visible":"true","w":"130","wireframe_props":"name","x":"172","y":"61","zerofilling":"false","zindex":"7"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelDaData","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data:","w":"144","wireframe_props":"align,value,n_col","x":"23","y":"61","zindex":"8"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"start","name":"RTStampa1","offline":"false","page":"1","parms":"ReportName=operp_estrazione_contante_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"false","refresh":"","sequence":"6","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"979","y":"26"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"953","y":"213"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fType","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"957","y":"239"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fModel","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"954","y":"268"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"A_Data","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"character","visible":"true","w":"130","wireframe_props":"name","x":"492","y":"61","zerofilling":"false","zindex":"7"},{"anchor":"","calculate":"1","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox13","page":"1","picture":"","sequence":"11","spuid":"","tabindex":"","textlist":"Operazioni Sale Conta,Elenco Clientela,Totali Sale Conta,Legali Rappresentanti,Titolari Effettivi","type":"Combobox","typevar":"numeric","valuelist":"1,2,3,4,5","visible":"true","w":"442","wireframe_props":"name,textlist","x":"172","y":"22","zindex":"9"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelTipo","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Estrazioni:","w":"144","wireframe_props":"align,value,n_col","x":"23","y":"22","zindex":"8"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa2","offline":"false","page":"1","parms":"ReportName=operp_estrazione_soggetti_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"false","refresh":"","sequence":"13","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"980","y":"49"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"962","y":"296"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa3","offline":"false","page":"1","parms":"ReportName=operp_estrazione_contante_totali_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"false","refresh":"","sequence":"15","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"981","y":"74"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa4","offline":"false","page":"1","parms":"ReportName=operp_estrazioni_legrap_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"false","refresh":"","sequence":"16","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"980","y":"103"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTStampa5","offline":"false","page":"1","parms":"ReportName=operp_estrazioni_legrap_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename,SubstituteQuery=query,printTitle=Titolari_Effettivi","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"false","refresh":"","sequence":"17","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"981","y":"131"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"query","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"969","y":"319"}]%>
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
window.pg_estrazioni_bi_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Report !='undefined')this.Report=Report;
if(typeof Uscita !='undefined')this.Uscita=Uscita;
if(typeof Combobox13_onChange !='undefined')this.Combobox13_onChange=Combobox13_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(SystemDate(),this.A_Data);
ZtVWeb.InitCtrl(1,this.Combobox13);
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Estrazioni per BI',true) 
  this.getTitlePortlet().AppendButton({
    id:"Genera_File",
    title:FormatMsg('Estrazione Dati'),
    tooltip:FormatMsg('Crea il report selezionato'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb5c"},
    action:'javascript:' + this.formid +'.Report()'
  },1);   
  this.getTitlePortlet().AppendButton({
    id:"Uscita",
    title:FormatMsg('Uscita'),
    tooltip:FormatMsg('Chiude la maschera di estrazione'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xea01"},
    action:'javascript:' + this.formid +'.Uscita()'
  },2);  
}
function Report(){
  if(confirm("Confermi la stampa?")) {
    this.fType.Value("XLS|XLSX|CSV|CSVS")
    this.fModel.Value("|||")
    if(this.Combobox13.Value()=='1') {
      this.filename.Value("Operazioni_Sale_Conta_"+DateToChar(this.DaData.Value())+"_"+DateToChar(this.A_Data.Value()))
      this.RTStampa1.Link()
    }
    if(this.Combobox13.Value()=='2') {  
      this.filename.Value("Estrazione_Soggetti_"+DateToChar(this.DaData.Value())+"_"+DateToChar(this.A_Data.Value()))
      this.RTStampa2.Link()
    }  
    if(this.Combobox13.Value()=='3') {  
      this.filename.Value("Totali_Sale_Conta_"+DateToChar(this.DaData.Value())+"_"+DateToChar(this.A_Data.Value()))
      this.RTStampa3.Link()
    } 
    if(this.Combobox13.Value()=='4') {  
      this.filename.Value("Legali_Rappresentanti_"+DateToChar(this.DaData.Value())+"_"+DateToChar(this.A_Data.Value()))
      this.RTStampa4.Link()
    }
    if(this.Combobox13.Value()=='5') {  
      this.filename.Value("Titolari_Effettivi_"+DateToChar(this.DaData.Value())+"_"+DateToChar(this.A_Data.Value()))
      this.query.Value("qbe_estrazione_titolari_bi")
      this.RTStampa5.Link()
    }    
  }
}
function Uscita(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function Combobox13_onChange(){
  this.iPrint.Reload()
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
.pg_estrazioni_bi_container {
  height:100%;
  overflow:auto;
}
.pg_estrazioni_bi_title_container {
  margin: auto;
}
.pg_estrazioni_bi_portlet{
  position:relative;
  margin: auto;
  width:900px;
max-width:400px;
  min-width:900px;
  height:100%;
}
.pg_estrazioni_bi_portlet[Data-page="1"]{
  height:100%;
  width:900px;
}
.pg_estrazioni_bi_portlet > .LabelAData_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:61px;
  left:343px;
  width:144px;
  height:auto;
  min-height:20px;
}
.pg_estrazioni_bi_portlet > .LabelAData_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estrazioni_bi_portlet > .LabelAData_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estrazioni_bi_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:97px;
  left:0px;
  right:0px;
  width:900px;
  height:302px;
}
.pg_estrazioni_bi_portlet > .DaData_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:61px;
  left:172px;
  width:130px;
  height:20px;
}
.pg_estrazioni_bi_portlet > .DaData_ctrl {
}
.pg_estrazioni_bi_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_estrazioni_bi_portlet > .LabelDaData_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:61px;
  left:23px;
  width:144px;
  height:auto;
  min-height:20px;
}
.pg_estrazioni_bi_portlet > .LabelDaData_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estrazioni_bi_portlet > .LabelDaData_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estrazioni_bi_portlet > .A_Data_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:61px;
  left:492px;
  width:130px;
  height:20px;
}
.pg_estrazioni_bi_portlet > .A_Data_ctrl {
}
.pg_estrazioni_bi_portlet > .A_Data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_estrazioni_bi_portlet > .Combobox13_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:22px;
  left:172px;
  width:442px;
  height:20px;
}
.pg_estrazioni_bi_portlet > .LabelTipo_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:22px;
  left:23px;
  width:144px;
  height:auto;
  min-height:20px;
}
.pg_estrazioni_bi_portlet > .LabelTipo_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estrazioni_bi_portlet > .LabelTipo_ctrl {
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"Stampa Revisione Profili Rischio\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"900\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"977\",\"y\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"144\",\"x\":\"343\",\"y\":\"61\",\"zindex\":\"8\"},{\"anchor\":\"top-left-right\",\"h\":\"302\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"900\",\"x\":\"0\",\"y\":\"97\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"130\",\"x\":\"172\",\"y\":\"61\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"LabelDaData\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"144\",\"x\":\"23\",\"y\":\"61\",\"zindex\":\"8\"},{\"h\":\"20\",\"name\":\"RTStampa1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"979\",\"y\":\"26\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"953\",\"y\":\"213\"},{\"h\":\"20\",\"name\":\"fType\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"957\",\"y\":\"239\"},{\"h\":\"20\",\"name\":\"fModel\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"954\",\"y\":\"268\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"A_Data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"130\",\"x\":\"492\",\"y\":\"61\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox13\",\"page\":\"1\",\"textlist\":\"Operazioni Sale Conta,Elenco Clientela,Totali Sale Conta,Legali Rappresentanti,Titolari Effettivi\",\"type\":\"Combobox\",\"w\":\"442\",\"x\":\"172\",\"y\":\"22\",\"zindex\":\"9\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"LabelTipo\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Estrazioni:\",\"w\":\"144\",\"x\":\"23\",\"y\":\"22\",\"zindex\":\"8\"},{\"h\":\"20\",\"name\":\"RTStampa2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"980\",\"y\":\"49\"},{\"h\":\"20\",\"name\":\"filename\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"962\",\"y\":\"296\"},{\"h\":\"20\",\"name\":\"RTStampa3\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"981\",\"y\":\"74\"},{\"h\":\"20\",\"name\":\"RTStampa4\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"980\",\"y\":\"103\"},{\"h\":\"20\",\"name\":\"RTStampa5\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"981\",\"y\":\"131\"},{\"h\":\"20\",\"name\":\"query\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"969\",\"y\":\"319\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrazioni_bi","UTF-8")) {return; }
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
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrazioni_bi_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrazioni_bi','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String LabelAData= "A Data:";
String DaData= "";
if(request.getAttribute("pg_estrazioni_bi_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String LabelDaData= "Da Data:";
String gDescAzi=sp.getGlobal("gDescAzi","");
String fType= "";
String fModel= "";
String A_Data= "";
double Combobox13= 0;
String LabelTipo= "Tipo Estrazioni:";
String filename= "";
String query= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrazioni_bi_title_container' style='width:900px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estrazioni_bi_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrazioni_bi_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrazioni_bi','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_LabelAData'  formid='<%=idPortlet%>' ps-name='LabelAData'    class='label LabelAData_ctrl'><div id='<%=idPortlet%>_LabelADatatbl' style='width:100%;'><%=JSPLib.ToHTML("A Data:")%></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' /></span>
<span id='<%=idPortlet%>_LabelDaData'  formid='<%=idPortlet%>' ps-name='LabelDaData'    class='label LabelDaData_ctrl'><div id='<%=idPortlet%>_LabelDaDatatbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_A_Data_wrp'><input id='<%=idPortlet%>_A_Data' name='A_Data' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='A_Data' /></span>
<select id='<%=idPortlet%>_Combobox13' name='Combobox13' class='combobox' style=''></select>
<span id='<%=idPortlet%>_LabelTipo'  formid='<%=idPortlet%>' ps-name='LabelTipo'    class='label LabelTipo_ctrl'><div id='<%=idPortlet%>_LabelTipotbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Estrazioni:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrazioni_bi');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Chiude la maschera di estrazione",true)+","+JSPLib.ToJSValue(sp.translate("Chiude la maschera di estrazione"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Crea il report selezionato",true)+","+JSPLib.ToJSValue(sp.translate("Crea il report selezionato"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Estrazione Dati",true)+","+JSPLib.ToJSValue(sp.translate("Estrazione Dati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Uscita",true)+","+JSPLib.ToJSValue(sp.translate("Uscita"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrazioni_bi',["900"],["400"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"400","title":"Stampa Revisione Profili Rischio","layer":"false","npage":"1"}]);
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":977,"y":2});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.LabelAData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelAData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelAData","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelAData,false,true)%>","type":"Label","w":144,"x":343,"y":61,"zindex":"8"});
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":302,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":900,"x":0,"y":97,"zindex":"6"});
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"character","value":"<%=JSPLib.ToJSValue(DaData,false,true)%>","w":130,"x":172,"y":61,"zerofilling":false,"zindex":"7","zoom":""});
this.LabelDaData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelDaData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelDaData","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelDaData,false,true)%>","type":"Label","w":144,"x":23,"y":61,"zindex":"8"});
this.RTStampa1=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa1","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa1","offline":false,"page":1,"parms":"ReportName=operp_estrazione_contante_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":979,"y":26});
this.RTStampa1.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.fType=new ZtVWeb._VC(this,'fType',null,'character','<%=JSPLib.ToJSValue(fType,false,true)%>',false,false);
this.fModel=new ZtVWeb._VC(this,'fModel',null,'character','<%=JSPLib.ToJSValue(fModel,false,true)%>',false,false);
this.A_Data=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_A_Data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"A_Data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"character","value":"<%=JSPLib.ToJSValue(A_Data,false,true)%>","w":130,"x":492,"y":61,"zerofilling":false,"zindex":"7","zoom":""});
this.Combobox13=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"1","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox13","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"<%=Combobox13%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox13","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Operazioni Sale Conta,Elenco Clientela,Totali Sale Conta,Legali Rappresentanti,Titolari Effettivi","type":"Combobox","typevar":"numeric","valuelist":"1,2,3,4,5","visible":true,"w":442,"x":172,"y":22,"zindex":"9"});
this.LabelTipo=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelTipo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelTipo","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelTipo,false,true)%>","type":"Label","w":144,"x":23,"y":22,"zindex":"8"});
this.RTStampa2=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa2","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa2","offline":false,"page":1,"parms":"ReportName=operp_estrazione_soggetti_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":980,"y":49});
this.RTStampa2.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.RTStampa3=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa3","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa3","offline":false,"page":1,"parms":"ReportName=operp_estrazione_contante_totali_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":981,"y":74});
this.RTStampa3.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTStampa4=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa4","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa4","offline":false,"page":1,"parms":"ReportName=operp_estrazioni_legrap_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":980,"y":103});
this.RTStampa4.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTStampa5=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa5","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa5","offline":false,"page":1,"parms":"ReportName=operp_estrazioni_legrap_bi.vrp,formatTypes=fType,hideParameterMask=true,rotation=LANDSCAPE,desazi=gDescAzi,pDATAOPE_INI=DaData,pDATAOPE_FIN=A_Data,formatModels=fModel,FileName=filename,SubstituteQuery=query,printTitle=Titolari_Effettivi","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":981,"y":131});
this.RTStampa5.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.query=new ZtVWeb._VC(this,'query',null,'character','<%=JSPLib.ToJSValue(query,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_estrazioni_bi_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrazioni_bi_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrazioni_bi_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Combobox13.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrazioni_bi',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrazioni_bi');
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
sp.endPage("pg_estrazioni_bi");
}%>
<%! public String getJSPUID() { return "2679455145"; } %>