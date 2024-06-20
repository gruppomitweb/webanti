<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Elabora_Click(){\n  if (confirm(\"Confermi la creazione delle variazioni?\")) {\n    this.PortletLogs.Start();     \n    this.RTEsegui.Link()   \n  }  \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Crea Movimenti Variazione\",true)\n  this.zDaCli.DoLink()\n  this.zDaCli.Hide()  \n  this.getTitlePortlet().AppendButton({\n    id:\"Elabora\",\n    title:FormatMsg('Elabora'),\n    tooltip:FormatMsg('Esegue il cambio di NDG'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.Elabora_Click()'\n  },1);     \n\u002f\u002f   this.flgoper.Value('S')\n}\n\nfunction RTEsegui_Result(result){\n  this.PortletLogs.Stop();  \n  if (result=='OK'){\n    alert('Elaborazione Terminata con successo!');  \n  } else {\n    alert('Elaborazione Terminata. Abortita per errori!');      \n  }   \n}\nfunction RTEsegui_Error(cCause){\nalert(cCause)  \n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Controllo di Gestione","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pMsg }}{{ @DaData }}{{ @A_Data }}{{ @Uscita }}{{ @lblAData }}{{ @pLog }}{{ @DaCodCli }}{{ @lblDaCli }}{{ @zDaCli }}{{ @DaRagSoc }}{{ @lblData }}{{ @flgoper }}{{ @flg5455 }}{{ @flg3132 }}{{ @vardata }}{{ @flgleg }}{{ @flgrap }}{{ @Box17 }}{{ @Label18 }}{{ @Box19 }}{{ @Label20 }}{{ @lblDaData }}{{ @flgfraz }}{{ @DaData }}{{ @A_Data }}{{ @Elabora }}{{ @lblAData }}{{ @DaCodCli }}{{ @lblDaCli }}{{ @zDaCli }}{{ @DaRagSoc }}{{ @lblData }}{{ @flgoper }}{{ @flg5455 }}{{ @flg3132 }}{{ @vardata }}{{ @flgleg }}{{ @flgrap }}{{ @Box17 }}{{ @Label18 }}{{ @Box19 }}{{ @Label20 }}{{ @lblDaData }}{{ @flgfraz }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"330","hsl":"","htmlcode":"{{ @PortletLogs }} \n \n{{ A_Data }}\n{{ lblAData }}\n{{ RTAzzera }}\n{{ flgoper }}\n{{ flgrap }}\n{{ lblData }}\n{{ flg3132 }}\n{{ pMsg }}\n{{ Elabora }}\n{{ Uscita }}\n{{ RTEsegui }}{{ vardata }}\n{{ pLog }}{{ Box19 }}\n{{{{ Box17 }} RTAzzera }}{{ datavar }}{{ flgoper{{ Label20 }} }}{{ flgleg }}\n{{ DaCodCli }}{{ Label18 }}\n{{ lblDaCli }}{{ flg5455 }}\n{{ ACodCli }}\n{{ lblACli }}\n{{ zDaCli }}\n{{ DaRagSoc }}\n{{ lblDaData }}{{ DaData }}{{ @DaData }} \n{{ @A_Data }} \n \n \n{{ @lblAData }} \n \n{{ @DaCodCli }} \n{{ @lblDaCli }} \n{{ @zDaCli }} \n{{ @DaRagSoc }} \n{{ @lblData }} \n{{ @flgoper }} \n{{ @flg5455 }} \n{{ @flg3132 }} \n{{ @vardata }} \n{{ @flgleg }} \n{{ @flgrap }} \n{{ @Box17 }} \n{{ @Label18 }} \n{{ @Box19 }} \n{{ @Label20 }} \n{{ @lblDaData }} \n{{ @flgfraz }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"Utilities.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"330\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"240","zindex":"6","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"flgoper='N' and flgleg='N' and flgrap='N'","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaData","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"126","wireframe_props":"name","x":"417","y":"211","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"flgoper='N' and flgleg='N' and flgrap='N'","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"A_Data","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"125","wireframe_props":"name","x":"712","y":"211","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"flgoper='N' and flgleg='N' and flgrap='N'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAData","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"156","wireframe_props":"align,value,n_col","x":"553","y":"213","zindex":"5","zone":""},{"allowedentities":"arrt_chg_create","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTEsegui","offline":"false","page":"1","parms":"w_oldcon=DaCodCli,w_datvar=vardata,w_flgoper=flgoper,w_flgfraz=flgfraz,w_flg3132=flg3132,w_flg5455=flg5455,w_flgleg=flgleg,w_flgrap=flgrap,w_DaData=DaData,w_A_Data=A_Data","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arrt_chg_create","target":"","type":"SPLinker","w":"147","x":"807","y":"-66"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"16","name":"DaCodCli","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"144","wireframe_props":"name","x":"203","y":"8","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaCli","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Codice (NDG):","w":"199","wireframe_props":"align,value,n_col","x":"0","y":"9","zindex":"5","zone":""},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixed":"","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"DaCodCli,DaRagSoc","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"DaCodCli","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"zDaCli","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","rapp":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"12","servlet":"","spuid":"","suggest":"false","table":"personbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"350","y":"8","zindex":"6","zone":"","zoomtitle":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"70","name":"DaRagSoc","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"13","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"418","wireframe_props":"name","x":"376","y":"8","zerofilling":"false","zindex":"7","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblData","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Data Variazione:","w":"124","wireframe_props":"align,value,n_col","x":"0","y":"213","zindex":"5","zone":""},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Operazioni","layer":"false","layout_steps_values":"{}","name":"flgoper","page":"1","rapp":"","sequence":"15","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"282","wireframe_props":"label_text","x":"460","y":"73","zindex":"9","zone":""},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Informazioni Legami (54\u002f55)","layer":"false","layout_steps_values":"{}","name":"flg5455","page":"1","rapp":"","sequence":"16","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"248","wireframe_props":"label_text","x":"52","y":"103","zindex":"10","zone":""},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Informazioni Rapporti (31\u002f32)","layer":"false","layout_steps_values":"{}","name":"flg3132","page":"1","rapp":"","sequence":"17","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"248","wireframe_props":"label_text","x":"52","y":"132","zindex":"10","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Date()","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"vardata","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"18","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"120","wireframe_props":"name","x":"128","y":"211","zerofilling":"false","zindex":"11","zone":"","zoom":""},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Informazioni legami","layer":"false","layout_steps_values":"{}","name":"flgleg","page":"1","rapp":"","sequence":"19","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"282","wireframe_props":"label_text","x":"460","y":"133","zindex":"12","zone":""},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Informazioni rapporti","layer":"false","layout_steps_values":"{}","name":"flgrap","page":"1","rapp":"","sequence":"20","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"282","wireframe_props":"label_text","x":"460","y":"163","zindex":"12","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"126","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box17","page":"1","rapp":"","sequence":"21","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"372","wireframe_props":"","x":"3","y":"35","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label18","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Modifiche per aggiornamento dati","w":"372","wireframe_props":"align,value,n_col","x":"3","y":"42","zindex":"13","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"167","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box19","page":"1","rapp":"","sequence":"23","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"356","wireframe_props":"","x":"417","y":"35","zindex":"1","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label20","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Modifiche per correzione dati","w":"356","wireframe_props":"align,value,n_col","x":"417","y":"42","zindex":"14","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"flgoper='N' and flgleg='N' and flgrap='N'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaData","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"25","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Operazione:","w":"156","wireframe_props":"align,value,n_col","x":"258","y":"213","zindex":"5","zone":""},{"anchor":"","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Frazionate","layer":"false","layout_steps_values":"{}","name":"flgfraz","page":"1","rapp":"","sequence":"26","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"282","wireframe_props":"label_text","x":"460","y":"103","zindex":"9","zone":""}]%>
<%/*Description:Controllo di Gestione*/%>
<%/*ParamsRequest:DaCodCli*/%>
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
window.pg_chg_create_Static=function(){
if(typeof Elabora_Click !='undefined')this.Elabora_Click=Elabora_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTEsegui_Result !='undefined')this.RTEsegui_Result=RTEsegui_Result;
if(typeof RTEsegui_Error !='undefined')this.RTEsegui_Error=RTEsegui_Error;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.flgoper.Value(),'N') && Eq(this.flgleg.Value(),'N') && Eq(this.flgrap.Value(),'N'),this.DaData);
ZtVWeb.HideCtrl(Eq(this.flgoper.Value(),'N') && Eq(this.flgleg.Value(),'N') && Eq(this.flgrap.Value(),'N'),this.A_Data);
ZtVWeb.HideCtrl(Eq(this.flgoper.Value(),'N') && Eq(this.flgleg.Value(),'N') && Eq(this.flgrap.Value(),'N'),this.lblAData);
ZtVWeb.HideCtrl(Eq(this.flgoper.Value(),'N') && Eq(this.flgleg.Value(),'N') && Eq(this.flgrap.Value(),'N'),this.lblDaData);
}
ZtVWeb.InitCtrl('N',this.flgoper);
ZtVWeb.InitCtrl('N',this.flg5455);
ZtVWeb.InitCtrl('N',this.flg3132);
ZtVWeb.InitCtrl(SystemDate(),this.vardata);
ZtVWeb.InitCtrl('N',this.flgleg);
ZtVWeb.InitCtrl('N',this.flgrap);
ZtVWeb.InitCtrl('N',this.flgfraz);
this.zDaCli.addObserverFixedVars();
function Elabora_Click(){
  if (confirm("Confermi la creazione delle variazioni?")) {
    this.PortletLogs.Start();     
    this.RTEsegui.Link()   
  }  
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Crea Movimenti Variazione",true)
  this.zDaCli.DoLink()
  this.zDaCli.Hide()  
  this.getTitlePortlet().AppendButton({
    id:"Elabora",
    title:FormatMsg('Elabora'),
    tooltip:FormatMsg('Esegue il cambio di NDG'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.Elabora_Click()'
  },1);     
//   this.flgoper.Value('S')
}
function RTEsegui_Result(result){
  this.PortletLogs.Stop();  
  if (result=='OK'){
    alert('Elaborazione Terminata con successo!');  
  } else {
    alert('Elaborazione Terminata. Abortita per errori!');      
  }   
}
function RTEsegui_Error(cCause){
alert(cCause)  
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
.pg_chg_create_container {
  height:100%;
  overflow:auto;
}
.pg_chg_create_title_container {
  margin: auto;
}
.pg_chg_create_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
  background-color:#FFFFFF;
}
.pg_chg_create_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_chg_create_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:240px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_chg_create_portlet > .DaData_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:211px;
  left:417px;
  width:126px;
  height:20px;
}
.pg_chg_create_portlet > .DaData_ctrl {
  display:none;
}
.pg_chg_create_portlet > .DaData_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_create_portlet > .A_Data_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:211px;
  left:712px;
  width:125px;
  height:20px;
}
.pg_chg_create_portlet > .A_Data_ctrl {
  display:none;
}
.pg_chg_create_portlet > .A_Data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_create_portlet > .lblAData_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:213px;
  left:553px;
  width:156px;
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblAData_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblAData_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_chg_create_portlet > .DaCodCli_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:8px;
  left:203px;
  width:144px;
  height:20px;
}
.pg_chg_create_portlet > .DaCodCli_ctrl {
}
.pg_chg_create_portlet > .DaCodCli_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_create_portlet > .lblDaCli_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:9px;
  left:0px;
  width:199px;
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblDaCli_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblDaCli_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_chg_create_portlet > .zDaCli_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:8px;
  left:350px;
  width:20px;
  height:20px;
}
.pg_chg_create_portlet > .DaRagSoc_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:8px;
  left:376px;
  width:418px;
  height:20px;
}
.pg_chg_create_portlet > .DaRagSoc_ctrl {
}
.pg_chg_create_portlet > .DaRagSoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_create_portlet > .lblData_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:213px;
  left:0px;
  width:124px;
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblData_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblData_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_chg_create_portlet > .flgoper_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:73px;
  left:460px;
  width:282px;
  height:20px;
}
.pg_chg_create_portlet > .flg5455_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:103px;
  left:52px;
  width:248px;
  height:20px;
}
.pg_chg_create_portlet > .flg3132_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:132px;
  left:52px;
  width:248px;
  height:20px;
}
.pg_chg_create_portlet > .vardata_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:211px;
  left:128px;
  width:120px;
  height:20px;
}
.pg_chg_create_portlet > .vardata_ctrl {
}
.pg_chg_create_portlet > .vardata_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_chg_create_portlet > .flgleg_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:133px;
  left:460px;
  width:282px;
  height:20px;
}
.pg_chg_create_portlet > .flgrap_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:163px;
  left:460px;
  width:282px;
  height:20px;
}
.pg_chg_create_portlet > .Box17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:3px;
  width:372px;
  height:auto;
  min-height:126px;
  display:flex;
  flex-direction:column;
}
.pg_chg_create_portlet > .Box17_ctrl {
  height:126px;
}
.pg_chg_create_portlet > .Box17_ctrl > .box_content {
  height:100%;
}
.pg_chg_create_portlet > .Box17_ctrl {
  min-height:126px;
}
.pg_chg_create_portlet > .Label18_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:42px;
  left:3px;
  width:372px;
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .Label18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .Label18_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-weight:bold;
  text-align:center;
}
.pg_chg_create_portlet > .Box19_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:417px;
  width:356px;
  height:auto;
  min-height:167px;
  display:flex;
  flex-direction:column;
}
.pg_chg_create_portlet > .Box19_ctrl {
  height:167px;
}
.pg_chg_create_portlet > .Box19_ctrl > .box_content {
  height:100%;
}
.pg_chg_create_portlet > .Box19_ctrl {
  min-height:167px;
}
.pg_chg_create_portlet > .Label20_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:42px;
  left:417px;
  width:356px;
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .Label20_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .Label20_ctrl {
  overflow:hidden;
  font-family:Tahoma, Geneva, sans-serif;
  font-weight:bold;
  text-align:center;
}
.pg_chg_create_portlet > .lblDaData_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:213px;
  left:258px;
  width:156px;
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblDaData_ctrl {
  height:auto;
  min-height:20px;
}
.pg_chg_create_portlet > .lblDaData_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_chg_create_portlet > .flgfraz_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:103px;
  left:460px;
  width:282px;
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
 String def="[{\"h\":\"330\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"240\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaData\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"126\",\"x\":\"417\",\"y\":\"211\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"A_Data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"712\",\"y\":\"211\",\"zindex\":\"11\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAData\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"156\",\"x\":\"553\",\"y\":\"213\",\"zindex\":\"5\"},{\"h\":\"30\",\"name\":\"RTEsegui\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"807\",\"y\":\"-66\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaCodCli\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"144\",\"x\":\"203\",\"y\":\"8\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaCli\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice (NDG):\",\"w\":\"199\",\"x\":\"0\",\"y\":\"9\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"zDaCli\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"350\",\"y\":\"8\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaRagSoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"418\",\"x\":\"376\",\"y\":\"8\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblData\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data Variazione:\",\"w\":\"124\",\"x\":\"0\",\"y\":\"213\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea Variazioni Operazioni\",\"layout_steps_values\":{},\"name\":\"flgoper\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"282\",\"x\":\"460\",\"y\":\"73\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea Informazioni Legami (54\\u002f55)\",\"layout_steps_values\":{},\"name\":\"flg5455\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"248\",\"x\":\"52\",\"y\":\"103\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea Informazioni Rapporti (31\\u002f32)\",\"layout_steps_values\":{},\"name\":\"flg3132\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"248\",\"x\":\"52\",\"y\":\"132\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"vardata\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"128\",\"y\":\"211\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea Variazioni Informazioni legami\",\"layout_steps_values\":{},\"name\":\"flgleg\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"282\",\"x\":\"460\",\"y\":\"133\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea Variazioni Informazioni rapporti\",\"layout_steps_values\":{},\"name\":\"flgrap\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"282\",\"x\":\"460\",\"y\":\"163\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"126\",\"layout_steps_values\":{},\"name\":\"Box17\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"372\",\"x\":\"3\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Modifiche per aggiornamento dati\",\"w\":\"372\",\"x\":\"3\",\"y\":\"42\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"167\",\"layout_steps_values\":{},\"name\":\"Box19\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"356\",\"x\":\"417\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label20\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Modifiche per correzione dati\",\"w\":\"356\",\"x\":\"417\",\"y\":\"42\",\"zindex\":\"14\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaData\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"156\",\"x\":\"258\",\"y\":\"213\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Crea Variazioni Frazionate\",\"layout_steps_values\":{},\"name\":\"flgfraz\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"282\",\"x\":\"460\",\"y\":\"103\",\"zindex\":\"9\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_chg_create","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_chg_create_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_chg_create','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date DaData= JSPLib.NullDate();
if(request.getAttribute("pg_chg_create_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date A_Data= JSPLib.NullDate();
String lblAData= "A Data Operazione:";
String DaCodCli=JSPLib.translateXSS(sp.getParameter("DaCodCli",""));
String lblDaCli= "Codice (NDG):";
if(request.getAttribute("pg_chg_create_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String DaRagSoc= "";
String lblData= "Data Variazione:";
String flgoper= "";
String flg5455= "";
String flg3132= "";
java.sql.Date vardata= JSPLib.NullDate();
String flgleg= "";
String flgrap= "";
String Label18= "Modifiche per aggiornamento dati";
String Label20= "Modifiche per correzione dati";
String lblDaData= "Da Data Operazione:";
String flgfraz= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_chg_create_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_chg_create_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_chg_create_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_chg_create','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_DaData_wrp'><input id='<%=idPortlet%>_DaData' name='DaData' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaData' /></span>
<span class='textbox-container'id='<%=idPortlet%>_A_Data_wrp'><input id='<%=idPortlet%>_A_Data' name='A_Data' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='A_Data' /></span>
<span id='<%=idPortlet%>_lblAData'  formid='<%=idPortlet%>' ps-name='lblAData'    class='label lblAData_ctrl'><div id='<%=idPortlet%>_lblADatatbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_DaCodCli_wrp'><input id='<%=idPortlet%>_DaCodCli' name='DaCodCli' type='text' disabled maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='DaCodCli' /></span>
<span id='<%=idPortlet%>_lblDaCli'  formid='<%=idPortlet%>' ps-name='lblDaCli'    class='label lblDaCli_ctrl'><div id='<%=idPortlet%>_lblDaClitbl' style='width:100%;'><%=JSPLib.ToHTML("Codice (NDG):")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_zDaCli'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_DaRagSoc_wrp'><input id='<%=idPortlet%>_DaRagSoc' name='DaRagSoc' type='text' disabled maxlength='70' class='textbox' formid='<%=idPortlet%>' ps-name='DaRagSoc' /></span>
<span id='<%=idPortlet%>_lblData'  formid='<%=idPortlet%>' ps-name='lblData'    class='label lblData_ctrl'><div id='<%=idPortlet%>_lblDatatbl' style='width:100%;'><%=JSPLib.ToHTML("Data Variazione:")%></div></span>
<div id='<%=idPortlet%>_flgoper_div' style=''><input id='<%=idPortlet%>_flgoper' name='flgoper' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgoper' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea Variazioni Operazioni")%></label></div>
<div id='<%=idPortlet%>_flg5455_div' style=''><input id='<%=idPortlet%>_flg5455' name='flg5455' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flg5455' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea Informazioni Legami (54/55)")%></label></div>
<div id='<%=idPortlet%>_flg3132_div' style=''><input id='<%=idPortlet%>_flg3132' name='flg3132' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flg3132' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea Informazioni Rapporti (31/32)")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_vardata_wrp'><input id='<%=idPortlet%>_vardata' name='vardata' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='vardata' /></span>
<div id='<%=idPortlet%>_flgleg_div' style=''><input id='<%=idPortlet%>_flgleg' name='flgleg' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgleg' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea Variazioni Informazioni legami")%></label></div>
<div id='<%=idPortlet%>_flgrap_div' style=''><input id='<%=idPortlet%>_flgrap' name='flgrap' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgrap' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea Variazioni Informazioni rapporti")%></label></div>
<div id='<%=idPortlet%>_Box17' class='Box17_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box17_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label18'  formid='<%=idPortlet%>' ps-name='Label18'    class='label Label18_ctrl'><div id='<%=idPortlet%>_Label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Modifiche per aggiornamento dati")%></div></span>
<div id='<%=idPortlet%>_Box19' class='Box19_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box19_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_Label20'  formid='<%=idPortlet%>' ps-name='Label20'    class='label Label20_ctrl'><div id='<%=idPortlet%>_Label20tbl' style='width:100%;'><%=JSPLib.ToHTML("Modifiche per correzione dati")%></div></span>
<span id='<%=idPortlet%>_lblDaData'  formid='<%=idPortlet%>' ps-name='lblDaData'    class='label lblDaData_ctrl'><div id='<%=idPortlet%>_lblDaDatatbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_flgfraz_div' style=''><input id='<%=idPortlet%>_flgfraz' name='flgfraz' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgfraz' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Crea Variazioni Frazionate")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_chg_create');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Esegue il cambio di NDG",true)+","+JSPLib.ToJSValue(sp.translate("Esegue il cambio di NDG"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_chg_create',["800"],["330"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"330","title":"","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":240,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.DaData=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaData","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.flgoper.Value(),'N') && Eq(this.flgleg.Value(),'N') && Eq(this.flgrap.Value(),'N')","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaData","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaData%>","w":126,"x":417,"y":211,"zerofilling":false,"zindex":"11","zoom":""});
this.A_Data=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_A_Data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"Eq(this.flgoper.Value(),'N') && Eq(this.flgleg.Value(),'N') && Eq(this.flgrap.Value(),'N')","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"A_Data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=A_Data%>","w":125,"x":712,"y":211,"zerofilling":false,"zindex":"11","zoom":""});
this.lblAData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"flgoper='N' and flgleg='N' and flgrap='N'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAData","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAData,false,true)%>","type":"Label","w":156,"x":553,"y":213,"zindex":"5"});
this.RTEsegui=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_chg_create",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsegui","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsegui","offline":false,"page":1,"parms":"w_oldcon=DaCodCli,w_datvar=vardata,w_flgoper=flgoper,w_flgfraz=flgfraz,w_flg3132=flg3132,w_flg5455=flg5455,w_flgleg=flgleg,w_flgrap=flgrap,w_DaData=DaData,w_A_Data=A_Data","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_chg_create","target":"","type":"SPLinker","w":147,"x":807,"y":-66});
this.RTEsegui.m_cID='<%=JSPLib.cmdHash("routine,arrt_chg_create",request.getSession())%>';
this.DaCodCli=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaCodCli","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"16","name":"DaCodCli","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(DaCodCli,false,true)%>","w":144,"x":203,"y":8,"zerofilling":false,"zindex":"4","zoom":""});
this.lblDaCli=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaCli","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaCli","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaCli,false,true)%>","type":"Label","w":199,"x":0,"y":9,"zindex":"5"});
this.zDaCli=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_zDaCli","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_chg_create_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"DaCodCli,DaRagSoc","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_chg_create_portlet.jspzDaCli",request.getSession())%>","linkedField":"DaCodCli","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"zDaCli","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CONNES,RAGSOC","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,personbo,default",request.getSession())%>","suggest":false,"table":"personbo","type":"LinkZoom","w":20,"x":350,"y":8,"zindex":"6","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.DaRagSoc=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaRagSoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"70","name":"DaRagSoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(DaRagSoc,false,true)%>","w":418,"x":376,"y":8,"zerofilling":false,"zindex":"7","zoom":""});
this.lblData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblData","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblData,false,true)%>","type":"Label","w":124,"x":0,"y":213,"zindex":"5"});
this.flgoper=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgoper","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Operazioni","layer":false,"layout_steps_values":{},"name":"flgoper","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":282,"x":460,"y":73,"zindex":"9"});
this.flg5455=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flg5455","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Informazioni Legami (54\u002f55)","layer":false,"layout_steps_values":{},"name":"flg5455","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":248,"x":52,"y":103,"zindex":"10"});
this.flg3132=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flg3132","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Informazioni Rapporti (31\u002f32)","layer":false,"layout_steps_values":{},"name":"flg3132","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":248,"x":52,"y":132,"zindex":"10"});
this.vardata=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"SystemDate()","create_undercond":"","ctrlid":"<%=idPortlet%>_vardata","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"vardata","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=vardata%>","w":120,"x":128,"y":211,"zerofilling":false,"zindex":"11","zoom":""});
this.flgleg=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgleg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Informazioni legami","layer":false,"layout_steps_values":{},"name":"flgleg","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":282,"x":460,"y":133,"zindex":"12"});
this.flgrap=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgrap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Informazioni rapporti","layer":false,"layout_steps_values":{},"name":"flgrap","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":282,"x":460,"y":163,"zindex":"12"});
this.Box17=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box17","groupName":"","h":126,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box17","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":372,"x":3,"y":35,"zindex":"1"});
this.Label18=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label18,false,true)%>","type":"Label","w":372,"x":3,"y":42,"zindex":"13"});
this.Box19=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box19","groupName":"","h":167,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box19","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":356,"x":417,"y":35,"zindex":"1"});
this.Label20=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label20","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label20","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label20,false,true)%>","type":"Label","w":356,"x":417,"y":42,"zindex":"14"});
this.lblDaData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaData","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"flgoper='N' and flgleg='N' and flgrap='N'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaData","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaData,false,true)%>","type":"Label","w":156,"x":258,"y":213,"zindex":"5"});
this.flgfraz=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgfraz","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"","label_text":"Crea Variazioni Frazionate","layer":false,"layout_steps_values":{},"name":"flgfraz","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":282,"x":460,"y":103,"zindex":"9"});
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
<%if(request.getAttribute("pg_chg_create_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_chg_create_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_chg_create_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_chg_create',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_chg_create');
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
sp.endPage("pg_chg_create");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"zDaCli")) {
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
<%! public String getJSPUID() { return "417802545"; } %>