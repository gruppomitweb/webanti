<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var source_str;\nvar msg_confirm;\nfunction this_Loaded(){\n  \u002f\u002falert(\"pSource=\"+this.source.Value()+\",formatTypes=\"+this.Ftypes.Value())\n  switch(this.source.Value())\n  {\n    case \"o\":\n      {\n      \tsource_str = \"Operazioni\";\n        msg_confirm = \"Confermi il trasferimento delle operazioni?\"\n        this.LinkZoom_xperazbo.Show();\n        this.lblDaOpe.Show();\n        this.daope.Show();\n        this.adope.Show();\n        this.CalDaOpe.Show();\n        this.lblAScad.Show();\n        this.CalAdOpe.Show();\n        \u002f\u002fthis.flgforce.Show(); \u002f\u002f Disabilitato in quanto (se attivo) porta a duplicazione di INFOR e RIFIMP in definitivo\n        this.Label_INFORM.Show();\n        this.Textbox_INFORM.Show();        \n      }\n      break;\n    case \"f\":\n      {\n      \tsource_str = \"Frazionate\";\n        msg_confirm = \"Confermi il trasferimento delle frazionate?\"\n        this.LinkZoom_xraziobo.Show();\n        this.lblDaOpe.Show();\n        this.daope.Show();\n        this.adope.Show();\n        this.CalDaOpe.Show();\n        this.lblAScad.Show();\n        this.CalAdOpe.Show();\n        \u002f\u002fthis.flgforce.Show();\n        this.Label_INFORM.Show();\n        this.Textbox_INFORM.Show();\n      }\n     \tbreak;\n    case \"r\":\n   \t\tsource_str = \"Rapporti Continuativi\";\n      msg_confirm = \"Confermi il trasferimento dei rapporti continuativi?\"\n     \tbreak;\n    case \"t\":\n    \tsource_str = \"Legami tra Soggetti\";\n      msg_confirm = \"Confermi il trasferimento dei legami tra soggetti?\"      \n      break;\n    default:\n      source_str = \"ERRORE\";\n  }\n  this.getTitlePortlet().SetTitle(\"Trasferimento \"+source_str+\" da Provvisorio a AUI\",true);\n  this.getTitlePortlet().SetTitle(\"Elabora\");\n  this.getTitlePortlet().AppendButton({\n    id:\"Elabora\",\n    title:FormatMsg('Elabora'),\n    tooltip:FormatMsg('Elabora il trasferimento da provvisorio a definitivo'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47\"},\n    action:'javascript:' + this.formid +'.elabora()'\n  },1);\n}\n\n\nfunction elabora(){\n  if (confirm(msg_confirm)) {\n    this.PortletLogs.Start();   \n    this.RTElab.Link()   \n  }  \n}\n\nfunction RTTrasferisci_Result(result){  \n  this.PortletLogs.Stop();\n  alert('Elaborazione Terminata!');  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lblDaOpe }}{{ @daope }}{{ @CalDaOpe }}{{ @lblAScad }}{{ @adope }}{{ @CalAdOpe }}{{ @flgforce }}{{ @Label_INFORM }}{{ @Textbox_INFORM }}{{ @LinkZoom_xperazbo }}{{ @pLog }}{{ @pMsg }}{{ @LinkZoom_xraziobo }}{{ @err_print }}{{ @lblDaOpe }}{{ @daope }}{{ @CalDaOpe }}{{ @lblAScad }}{{ @adope }}{{ @CalAdOpe }}{{ @flgforce }}{{ @Label_INFORM }}{{ @Textbox_INFORM }}{{ @LinkZoom_xperazbo }}{{ @LinkZoom_xraziobo }}{{ @err_print }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"290","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @err_print }}\n{{ @LinkZoom_xraziobo }}\n\n\n{{ @LinkZoom_xperazbo }}\n{{ @Textbox_INFORM }}\n{{ @Label_INFORM }}\n{{ @flgforce }}\n{{ @CalAdOpe }}\n{{ @adope }}\n{{ @lblAScad }}\n{{ @CalDaOpe }}\n{{ @daope }}\n{{ @lblDaOpe }}\n{{ LinkZoom_xraziobo }}\n{{ Note19 }}{{ lblDaOpe }}{{ source }}\n{{ daope }}\n{{ CalDaOpe }}\n{{ lblAScad }}\n{{ adope }}{{ Label17 }}\n{{ CalAdOpe }}{{ RTElab }}\n{{ flgforce }}{{ Fmodels }}\n{{ Label_INFORM }}\n{{ Textbox_INFORM }}{{ Note20 }}\n{{ LinkZoom_xperazbo }}\n{{ Elabora }}\n{{ Uscita }}{{ SPLinker19 }}{{ Ftypes }}\n{{ pLog }}\n{{ pMsg }}\n{{ RTAzzera }}\n{{ RTTrasferisci }}\n{{ err_print }}{{ BtnUscita }}{{ SQLDataobj21 }}\n{{ Grid22 }}","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"Utilities.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"290\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"","assoc_input":"daope","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data:","w":"65","wireframe_props":"align,value,n_col","x":"11","y":"18","zindex":"1","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"200","zindex":"6","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daope","page":"1","password":"","picker":"","picture":"","placeholder":"Da Data","rapp":"","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"88","wireframe_props":"name","x":"81","y":"18","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"true","layer":"false","layout_steps_values":"{}","name":"CalDaOpe","page":"1","popup":"true","rapp":"","return_input":"daope","sequence":"3","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"174","y":"18","zindex":"","zone":""},{"align":"right","anchor":"","assoc_input":"adope","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAScad","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data:","w":"60","wireframe_props":"align,value,n_col","x":"198","y":"18","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"adope","page":"1","password":"","picker":"","picture":"","placeholder":"A Data","rapp":"","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"88","wireframe_props":"name","x":"259","y":"18","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"Verdana","font_size":"10","h":"20","hide":"true","layer":"false","layout_steps_values":"{}","name":"CalAdOpe","page":"1","popup":"true","rapp":"","return_input":"adope","sequence":"6","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"351","y":"18","zindex":"","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"Forza il passaggio dati anche in presenza d'operazioni con lo stesso riferimento d'importazione","hide":"true","hide_undercond":"","init":"","init_par":"N","label_text":"Forza Trasferimento","layer":"false","layout_steps_values":"{}","name":"flgforce","page":"1","rapp":"","sequence":"7","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"179","wireframe_props":"label_text","x":"380","y":"18","zindex":"2","zone":""},{"align":"right","anchor":"","assoc_input":"Textbox_INFORM","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_INFORM","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Riferimento 2:","w":"94","wireframe_props":"align,value,n_col","x":"566","y":"18","zindex":"6","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Indicare il riferimento 2 per filtrare i dati","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"30","name":"Textbox_INFORM","page":"1","password":"","picker":"","picture":"","placeholder":"Riferimento 2","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"118","wireframe_props":"name","x":"664","y":"18","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"Textbox_INFORM","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_INFORM","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom_xperazbo","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"INFORM","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"10","servlet":"","spuid":"","suggest":"","table":"xperazbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"786","y":"18","zindex":"5","zone":"","zoomtitle":"Vista operazioni provvisorie per selezione riferimento 2"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"false","init_par":"request","name":"source","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1071","y":"27"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"73","hide":"","layer":"","layout_steps_values":"{}","name":"Note20","page":"1","rapp":"","sequence":"15","spuid":"","type":"Note","value":"o:ope f:fraz r:rappo+info t:legami","w":"95","wireframe_props":"","x":"858","y":"-85","zindex":"8","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"true","image":"","img_type":"default","intovars":"Textbox_INFORM","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_INFORM","linkedUsing":"","looselylinked":"true","n_criteria":"1","name":"LinkZoom_xraziobo","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"INFORM","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"16","servlet":"","spuid":"","suggest":"","table":"xraziobo","type":"LinkZoom","w":"20","wireframe_props":"","x":"786","y":"18","zindex":"5","zone":"","zoomtitle":"Vista frazionate provvisorie per selezione riferimento 2"},{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"err_print","page":"1","rapp":"","sequence":"17","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"46","zindex":"9","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RTElab","offline":"false","page":"1","parms":"ReportName=arrp_trasf_prov_aui,pSource=source,pDatIni=daope,pDatFin=adope,pForza=flgforce,pInform=Textbox_INFORM,outputFormat=PDF,hidePreview=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"","target":"err_print","type":"SPLinker","w":"120","x":"861","y":"88"},{"calculate":"'PDF$|$XLSX'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"Ftypes","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1071","y":"49"},{"calculate":"'$|$'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"Fmodels","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1074","y":"69"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:source*/%>
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
window.pg_trasf_prov_aui_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof elabora !='undefined')this.elabora=elabora;
if(typeof RTTrasferisci_Result !='undefined')this.RTTrasferisci_Result=RTTrasferisci_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('PDF|XLSX',this.Ftypes);
ZtVWeb.InitCtrl('|',this.Fmodels);
this.LinkZoom_xperazbo.addObserverFixedVars();
this.LinkZoom_xraziobo.addObserverFixedVars();
var source_str;
var msg_confirm;
function this_Loaded(){
  //alert("pSource="+this.source.Value()+",formatTypes="+this.Ftypes.Value())
  switch(this.source.Value())
  {
    case "o":
      {
      	source_str = "Operazioni";
        msg_confirm = "Confermi il trasferimento delle operazioni?"
        this.LinkZoom_xperazbo.Show();
        this.lblDaOpe.Show();
        this.daope.Show();
        this.adope.Show();
        this.CalDaOpe.Show();
        this.lblAScad.Show();
        this.CalAdOpe.Show();
        //this.flgforce.Show(); // Disabilitato in quanto (se attivo) porta a duplicazione di INFOR e RIFIMP in definitivo
        this.Label_INFORM.Show();
        this.Textbox_INFORM.Show();        
      }
      break;
    case "f":
      {
      	source_str = "Frazionate";
        msg_confirm = "Confermi il trasferimento delle frazionate?"
        this.LinkZoom_xraziobo.Show();
        this.lblDaOpe.Show();
        this.daope.Show();
        this.adope.Show();
        this.CalDaOpe.Show();
        this.lblAScad.Show();
        this.CalAdOpe.Show();
        //this.flgforce.Show();
        this.Label_INFORM.Show();
        this.Textbox_INFORM.Show();
      }
     	break;
    case "r":
   		source_str = "Rapporti Continuativi";
      msg_confirm = "Confermi il trasferimento dei rapporti continuativi?"
     	break;
    case "t":
    	source_str = "Legami tra Soggetti";
      msg_confirm = "Confermi il trasferimento dei legami tra soggetti?"      
      break;
    default:
      source_str = "ERRORE";
  }
  this.getTitlePortlet().SetTitle("Trasferimento "+source_str+" da Provvisorio a AUI",true);
  this.getTitlePortlet().SetTitle("Elabora");
  this.getTitlePortlet().AppendButton({
    id:"Elabora",
    title:FormatMsg('Elabora'),
    tooltip:FormatMsg('Elabora il trasferimento da provvisorio a definitivo'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47"},
    action:'javascript:' + this.formid +'.elabora()'
  },1);
}
function elabora(){
  if (confirm(msg_confirm)) {
    this.PortletLogs.Start();   
    this.RTElab.Link()   
  }  
}
function RTTrasferisci_Result(result){  
  this.PortletLogs.Stop();
  alert('Elaborazione Terminata!');  
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
.pg_trasf_prov_aui_container {
  height:100%;
  overflow:auto;
}
.pg_trasf_prov_aui_title_container {
  margin: auto;
}
.pg_trasf_prov_aui_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
  background-color:#FFFFFF;
}
.pg_trasf_prov_aui_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_trasf_prov_aui_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:11px;
  left:1.375%;
  right:724px;
  right:90.5%;
  width:auto;
  height:auto;
  min-height:19px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trasf_prov_aui_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_trasf_prov_aui_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:200px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_trasf_prov_aui_portlet > .daope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:81px;
  left:10.125%;
  right:631px;
  right:78.875%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .daope_ctrl {
}
.pg_trasf_prov_aui_portlet > .daope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_trasf_prov_aui_portlet > .CalDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:174px;
  left:21.75%;
  right:606px;
  right:75.75%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .lblAScad_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:198px;
  left:24.75%;
  right:542px;
  right:67.75%;
  width:auto;
  height:auto;
  min-height:19px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .lblAScad_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trasf_prov_aui_portlet > .lblAScad_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_trasf_prov_aui_portlet > .adope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:259px;
  left:32.375%;
  right:453px;
  right:56.625%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .adope_ctrl {
}
.pg_trasf_prov_aui_portlet > .adope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_trasf_prov_aui_portlet > .CalAdOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:351px;
  left:43.875%;
  right:429px;
  right:53.625%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .flgforce_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:18px;
  left:380px;
  left:47.5%;
  right:241px;
  right:30.125%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .Label_INFORM_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:18px;
  left:566px;
  left:70.75%;
  right:140px;
  right:17.5%;
  width:auto;
  height:auto;
  min-height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .Label_INFORM_ctrl {
  height:auto;
  min-height:20px;
}
.pg_trasf_prov_aui_portlet > .Label_INFORM_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_trasf_prov_aui_portlet > .Textbox_INFORM_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:18px;
  left:664px;
  left:83.0%;
  right:18px;
  right:2.25%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .Textbox_INFORM_ctrl {
}
.pg_trasf_prov_aui_portlet > .Textbox_INFORM_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_trasf_prov_aui_portlet > .LinkZoom_xperazbo_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:786px;
  left:98.25%;
  right:-6px;
  right:-0.75%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .LinkZoom_xraziobo_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:786px;
  left:98.25%;
  right:-6px;
  right:-0.75%;
  width:auto;
  height:20px;
  display:none;
}
.pg_trasf_prov_aui_portlet > .err_print_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:46px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:94px;
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
 String def="[{\"h\":\"290\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"65\",\"x\":\"11\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"200\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"88\",\"x\":\"81\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CalDaOpe\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"174\",\"y\":\"18\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAScad\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"60\",\"x\":\"198\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"adope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"88\",\"x\":\"259\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CalAdOpe\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"351\",\"y\":\"18\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Forza Trasferimento\",\"layout_steps_values\":{},\"name\":\"flgforce\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"179\",\"x\":\"380\",\"y\":\"18\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_INFORM\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Riferimento 2:\",\"w\":\"94\",\"x\":\"566\",\"y\":\"18\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_INFORM\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"118\",\"x\":\"664\",\"y\":\"18\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_xperazbo\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"786\",\"y\":\"18\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"source\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1071\",\"y\":\"27\"},{\"anchor\":\"\",\"h\":\"73\",\"layout_steps_values\":{},\"name\":\"Note20\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"o:ope f:fraz r:rappo+info t:legami\",\"w\":\"95\",\"x\":\"858\",\"y\":\"-85\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_xraziobo\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"786\",\"y\":\"18\",\"zindex\":\"5\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"err_print\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"46\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"RTElab\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"861\",\"y\":\"88\"},{\"h\":\"20\",\"name\":\"Ftypes\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1071\",\"y\":\"49\"},{\"h\":\"20\",\"name\":\"Fmodels\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1074\",\"y\":\"69\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_trasf_prov_aui","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_trasf_prov_aui_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_trasf_prov_aui_portlet > .lblDaOpe_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .daope_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .CalDaOpe_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .lblAScad_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .adope_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .CalAdOpe_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .flgforce_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .Label_INFORM_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .Textbox_INFORM_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .LinkZoom_xperazbo_ctrl {
  display:none;
}
.pg_trasf_prov_aui_portlet > .LinkZoom_xraziobo_ctrl {
  display:none;
}

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_trasf_prov_aui','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDaOpe= "Da Data:";
java.sql.Date daope= JSPLib.NullDate();
if(request.getAttribute("pg_trasf_prov_aui_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_trasf_prov_aui_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String lblAScad= "A Data:";
java.sql.Date adope= JSPLib.NullDate();
String flgforce="N";
String Label_INFORM= "Riferimento 2:";
String Textbox_INFORM= "";
if(request.getAttribute("pg_trasf_prov_aui_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String source=JSPLib.translateXSS(sp.getParameter("source",""));
String Ftypes= "";
String Fmodels= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_trasf_prov_aui_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_trasf_prov_aui_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_trasf_prov_aui_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_trasf_prov_aui','<%=idPortlet%>',false,'');
</script><%}}%>
<label id='<%=idPortlet%>_lblDaOpe' for='<%=idPortlet%>_daope' formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data:")%></div></label>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_daope_wrp'><input id='<%=idPortlet%>_daope' name='daope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daope' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("Da Data"))%>/></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_CalDaOpe' class='calendar' onclick='window.<%=idPortlet%>.CalDaOpe.PopupCalendar();' style='text-decoration:none;'></a>
 <label id='<%=idPortlet%>_lblAScad' for='<%=idPortlet%>_adope' formid='<%=idPortlet%>' ps-name='lblAScad'    class='label lblAScad_ctrl'><div id='<%=idPortlet%>_lblAScadtbl' style='width:100%;'><%=JSPLib.ToHTML("A Data:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_adope_wrp'><input id='<%=idPortlet%>_adope' name='adope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='adope' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("A Data"))%>/></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_CalAdOpe' class='calendar' onclick='window.<%=idPortlet%>.CalAdOpe.PopupCalendar();' style='text-decoration:none;'></a>
 <div id='<%=idPortlet%>_flgforce_div' style=''><input id='<%=idPortlet%>_flgforce' name='flgforce' class='slider checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Forza il passaggio dati anche in presenza d'operazioni con lo stesso riferimento d'importazione" )%> /><label for='<%=idPortlet%>_flgforce' class='label' title=<%=JSPLib.ToHTMLValue("Forza il passaggio dati anche in presenza d'operazioni con lo stesso riferimento d'importazione" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Forza Trasferimento")%></label></div>
<label id='<%=idPortlet%>_Label_INFORM' for='<%=idPortlet%>_Textbox_INFORM' formid='<%=idPortlet%>' ps-name='Label_INFORM'    class='label Label_INFORM_ctrl'><div id='<%=idPortlet%>_Label_INFORMtbl' style='width:100%;'><%=JSPLib.ToHTML("Riferimento 2:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_INFORM_wrp'><input id='<%=idPortlet%>_Textbox_INFORM' name='Textbox_INFORM' type='text' maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_INFORM' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("Riferimento 2"))%>/></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_xperazbo'" ) );
out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_xraziobo'" ) );%>
<div id='<%=idPortlet%>_err_print_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_trasf_prov_aui');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora il trasferimento da provvisorio a definitivo",true)+","+JSPLib.ToJSValue(sp.translate("Elabora il trasferimento da provvisorio a definitivo"),true)+");\n");
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
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_trasf_prov_aui',["800"],["290"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"290","title":"","layer":""}]);
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"daope","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":65,"x":11,"y":18,"zindex":"1"});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":200,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.daope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=daope%>","w":88,"x":81,"y":18,"zerofilling":false,"zindex":"1","zoom":""});
this.CalDaOpe=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_CalDaOpe','CalDaOpe',174,18,20,20,'Verdana','10','top-left(%)-right(%)','true','daope',{});
this.lblAScad=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"adope","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAScad","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAScad","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAScad,false,true)%>","type":"Label","w":60,"x":198,"y":18,"zindex":"1"});
this.adope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_adope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"adope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=adope%>","w":88,"x":259,"y":18,"zerofilling":false,"zindex":"1","zoom":""});
this.CalAdOpe=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_CalAdOpe','CalAdOpe',351,18,20,20,'Verdana','10','top-left(%)-right(%)','true','adope',{});
this.flgforce=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgforce","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"true","hide_undercond":"","init":"","init_par":"N","label_text":"Forza Trasferimento","layer":false,"layout_steps_values":{},"name":"flgforce","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":179,"x":380,"y":18,"zindex":"2"});
this.flgforce.Value('<%=flgforce%>');
this.Label_INFORM=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"Textbox_INFORM","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_INFORM","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_INFORM","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_INFORM,false,true)%>","type":"Label","w":94,"x":566,"y":18,"zindex":"6"});
this.Textbox_INFORM=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_INFORM","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Indicare il riferimento 2 per filtrare i dati","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"30","name":"Textbox_INFORM","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_INFORM,false,true)%>","w":118,"x":664,"y":18,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_xperazbo=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_xperazbo","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_trasf_prov_aui_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"Textbox_INFORM","intovarsType":"C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_trasf_prov_aui_portlet.jspLinkZoom_xperazbo",request.getSession())%>","linkedField":"Textbox_INFORM","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom_xperazbo","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"INFORM","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xperazbo,default",request.getSession())%>","suggest":false,"table":"xperazbo","type":"LinkZoom","w":20,"x":786,"y":18,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Vista operazioni provvisorie per selezione riferimento 2"),false,true)%>"});
this.source=new ZtVWeb._VC(this,'source',null,'character','<%=JSPLib.ToJSValue(source,false,true)%>',false,false);
this.LinkZoom_xraziobo=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_xraziobo","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_trasf_prov_aui_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"true","image":"","intovars":"Textbox_INFORM","intovarsType":"C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_trasf_prov_aui_portlet.jspLinkZoom_xraziobo",request.getSession())%>","linkedField":"Textbox_INFORM","linkedUsing":"","looselylinked":true,"n_criteria":"1","name":"LinkZoom_xraziobo","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"INFORM","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xraziobo,default",request.getSession())%>","suggest":false,"table":"xraziobo","type":"LinkZoom","w":20,"x":786,"y":18,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Vista frazionate provvisorie per selezione riferimento 2"),false,true)%>"});
this.err_print=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_err_print","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"err_print","name_iframe":"err_print","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":46,"zindex":"9"});
this.RTElab=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElab","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElab","offline":false,"page":1,"parms":"ReportName=arrp_trasf_prov_aui,pSource=source,pDatIni=daope,pDatFin=adope,pForza=flgforce,pInform=Textbox_INFORM,outputFormat=PDF,hidePreview=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"err_print","type":"SPLinker","w":120,"x":861,"y":88});
this.RTElab.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Ftypes=new ZtVWeb._VC(this,'Ftypes',null,'character','<%=JSPLib.ToJSValue(Ftypes,false,true)%>',false,false);
this.Fmodels=new ZtVWeb._VC(this,'Fmodels',null,'character','<%=JSPLib.ToJSValue(Fmodels,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_trasf_prov_aui_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_trasf_prov_aui_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_trasf_prov_aui_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_trasf_prov_aui',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_trasf_prov_aui');
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
sp.endPage("pg_trasf_prov_aui");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_xperazbo")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xperazbo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"INFORM"};
  result.m_rdTypes = new String[]{"C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom_xraziobo")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xraziobo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = true;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_DefaultFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"INFORM"};
  result.m_rdTypes = new String[]{"C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "1856560879"; } %>