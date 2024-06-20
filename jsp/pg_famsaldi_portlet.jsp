<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"Creazione File Saldi\",true)\n this.RTChecks.Parameters(\"pTipo=J\")\n  this.java.Value(this.RTChecks.Link())\n  if(this.java.Value()) {\n    this.javaSi.Show()\n    this.javaNo.Hide()\n  } else {\n    this.javaNo.Show()\n    this.javaSi.Hide()    \n  }  \n  this.RTChecks.Parameters(\"pTipo=C\")\n  this.certificati.Value(this.RTChecks.Link()) \n  if(this.certificati.Value()) {\n    this.certSi.Show()\n    this.certNo.Hide()\n  } else {\n    this.certNo.Show()\n    this.certSi.Hide()    \n  }  \n  this.RTChecks.Parameters(\"pTipo=V\")\n  this.validita.Value(this.RTChecks.Link()) \n  if(this.validita.Value()) {\n    this.valiSi.Show()\n    this.valiNo.Hide()\n  } else {\n    this.valiNo.Show()\n    this.valiSi.Hide()    \n  }    \n  if(this.java.Value() && this.certificati.Value()) {\n    this.btnElab.Show()\n    this.btnPrint.Show()\n    this.btnSearch.Show()\n  } else {\n    this.btnElab.Hide()\n    this.btnPrint.Hide()\n    this.btnSearch.Hide()\n  }    \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()      \n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnSearch_Click(){\n  this.RTSearch.Link()\n}\n\nfunction btnPrint_Click(){\n  this.RTPrint.Link()  \n}\n\nfunction btnDown_Click(){\n  this.RTDown.Link()\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Creazione File Saldi per AGE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @btnElab }}{{ @javaSi }}{{ @Label32_Copy }}{{ @valiSi }}{{ @valiNo }}{{ @pLog }}{{ @Label32_Copy_Copy }}{{ @pMsg }}{{ @Box31 }}{{ @anno }}{{ @Label32 }}{{ @lblAnno }}{{ @certSi }}{{ @certNo }}{{ @flgstp }}{{ @btnPrint }}{{ @btnSearch }}{{ @iPrint }}{{ @flginvio }}{{ @javaNo }}{{ @anticipo }}\u003c\u002fbody\u003e","grapesCss":"","h":"600","hsl":"false","htmlcode":"{{ @anticipo }} \n{{ @certNo }}\n{{ @certSi }}\n{{ @Label32 }}\n{{ @Box31 }}\n{{ @Label32_Copy_Copy }}\n{{ @valiNo }}\n{{ @valiSi }}\n{{ @Label32_Copy }}\n{{ @javaSi }}\n{{ @javaNo }}\n{{ @flginvio }}\n{{ @iPrint }}\n{{ @btnSearch }}\n{{ @btnPrint }}\n{{ @flgstp }}\n{{ @lblAnno }}\n{{ @anno }}\n{{ @pMsg }}\n{{ @pLog }}\n\n{{ @btnElab }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"800","min_w":"","mode":"NORMAL","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"600\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","rapp":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"13","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"javaSi","page":"1","path_type":"","rapp":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f047.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"439","y":"95","zindex":"14","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"certificati","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"893","y":"-16"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"JRE Esecuzione","w":"134","wireframe_props":"align,value,n_col","x":"285","y":"95","zindex":"13","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"validita","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"894","y":"15"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"valiSi","page":"1","path_type":"","rapp":"","sequence":"6","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"439","y":"124","zindex":"14","zone":""},{"allowedentities":"arrt_famsaldi","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_anno=anno,w_flginvio=flginvio,w_flgstp=flgstp,w_anticipo=anticipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arrt_famsaldi","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"valiNo","page":"1","path_type":"","rapp":"","sequence":"8","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"464","y":"124","zindex":"14","zone":""},{"allowedentities":"arfn_check_sid","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChecks","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arfn_check_sid","target":"","type":"SPLinker","w":"120","x":"422","y":"-61"},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"157","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","rapp":"","sequence":"10","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"236","zindex":"","zone":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32_Copy_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Validità Certificati","w":"134","wireframe_props":"align,value,n_col","x":"285","y":"124","zindex":"13","zone":""},{"anchor":"","ctrlOfVariant":"","fixed":"","h":"42","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","rapp":"","sequence":"12","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"193","zindex":"","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"90","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box31","page":"1","rapp":"","sequence":"13","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"237","wireframe_props":"","x":"254","y":"59","zindex":"12","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"Year(Date()) - 1","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"53","wireframe_props":"name","x":"155","y":"18","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label32","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Presenza Certificati","w":"134","wireframe_props":"align,value,n_col","x":"285","y":"66","zindex":"13","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"143","wireframe_props":"align,value,n_col","x":"9","y":"19","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"certSi","page":"1","path_type":"","rapp":"","sequence":"17","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f047.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"439","y":"65","zindex":"14","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"82","x":"154","y":"-65"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"certNo","page":"1","path_type":"","rapp":"","sequence":"19","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f048.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"464","y":"65","zindex":"14","zone":""},{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Non creare i file per le stampe (Per grossi volumi di dati - IP)","layer":"false","layout_steps_values":"{}","name":"flgstp","page":"1","rapp":"","sequence":"20","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"418","wireframe_props":"label_text","x":"10","y":"164","zindex":"5","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa contenuto dei file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnPrint","page":"1","path_type":"","rapp":"","sequence":"21","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"153","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"java","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"892","y":"-43"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Visualizza i file creati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnSearch","page":"1","path_type":"","rapp":"","sequence":"23","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"153","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTSearch","offline":"false","page":"1","parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"24","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":"80","x":"245","y":"-63"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTPrint","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"25","servlet":"arrt_famsaldi_stp","target":"iPrint","type":"SPLinker","w":"74","x":"334","y":"-61"},{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"208","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"26","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"393","zindex":"9","zone":""},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"20","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"N","layer":"false","layout_steps_values":"{}","name":"flginvio","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"27","spuid":"","tabindex":"","textlist":"Reinvia tutti i saldi,Invia Solo i saldi non inviati","type":"Radio","typevar":"character","valuelist":"S,N","visible":"true","w":"343","wireframe_props":"","x":"260","y":"21","zindex":"10","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"javaNo","page":"1","path_type":"","rapp":"","sequence":"28","server_side":"","spuid":"","src":"..\u002fimages\u002fGIF\u002f048.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"464","y":"95","zindex":"14","zone":""},{"anchor":"","calculate":"","checked_value":"1","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Invio Saldi per cessazione","layer":"false","layout_steps_values":"{}","name":"anticipo","page":"1","rapp":"","sequence":"29","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"0","w":"233","wireframe_props":"label_text","x":"454","y":"164","zindex":"15","zone":""}]%>
<%/*Description:Creazione File Saldi per AGE*/%>
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
window.pg_famsaldi_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnSearch_Click !='undefined')this.btnSearch_Click=btnSearch_Click;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate())-1,this.anno);
ZtVWeb.InitCtrl('N',this.flgstp);
function this_Loaded(){
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("Creazione File Saldi",true)
 this.RTChecks.Parameters("pTipo=J")
  this.java.Value(this.RTChecks.Link())
  if(this.java.Value()) {
    this.javaSi.Show()
    this.javaNo.Hide()
  } else {
    this.javaNo.Show()
    this.javaSi.Hide()    
  }  
  this.RTChecks.Parameters("pTipo=C")
  this.certificati.Value(this.RTChecks.Link()) 
  if(this.certificati.Value()) {
    this.certSi.Show()
    this.certNo.Hide()
  } else {
    this.certNo.Show()
    this.certSi.Hide()    
  }  
  this.RTChecks.Parameters("pTipo=V")
  this.validita.Value(this.RTChecks.Link()) 
  if(this.validita.Value()) {
    this.valiSi.Show()
    this.valiNo.Hide()
  } else {
    this.valiNo.Show()
    this.valiSi.Hide()    
  }    
  if(this.java.Value() && this.certificati.Value()) {
    this.btnElab.Show()
    this.btnPrint.Show()
    this.btnSearch.Show()
  } else {
    this.btnElab.Hide()
    this.btnPrint.Hide()
    this.btnSearch.Hide()
  }    
}
function btnElab_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()      
  alert("Elaborazione Completata!");
}
function btnSearch_Click(){
  this.RTSearch.Link()
}
function btnPrint_Click(){
  this.RTPrint.Link()  
}
function btnDown_Click(){
  this.RTDown.Link()
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
.pg_famsaldi_container {
}
.pg_famsaldi_title_container {
  margin: auto;
}
.pg_famsaldi_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:800px;
  min-width:800px;
  height:600px;
}
.pg_famsaldi_portlet[Data-page="1"]{
  height:600px;
  width:100%;
}
.pg_famsaldi_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  right:45px;
  width:30px;
  height:30px;
}
.pg_famsaldi_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famsaldi_portlet > .javaSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:95px;
  left:439px;
  left:54.875%;
  right:341px;
  right:42.625%;
  width:auto;
  height:20px;
}
.pg_famsaldi_portlet > .javaSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_famsaldi_portlet > .Label32_Copy_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:95px;
  left:285px;
  left:35.625%;
  right:381px;
  right:47.625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .Label32_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .Label32_Copy_ctrl {
  overflow:hidden;
}
.pg_famsaldi_portlet > .valiSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:124px;
  left:439px;
  left:54.875%;
  right:341px;
  right:42.625%;
  width:auto;
  height:20px;
}
.pg_famsaldi_portlet > .valiSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_famsaldi_portlet > .valiNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:124px;
  left:464px;
  left:58.0%;
  right:316px;
  right:39.5%;
  width:auto;
  height:20px;
}
.pg_famsaldi_portlet > .valiNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_famsaldi_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:236px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:207px;
  width:auto;
}
.pg_famsaldi_portlet > .Label32_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:124px;
  left:285px;
  left:35.625%;
  right:381px;
  right:47.625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .Label32_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .Label32_Copy_Copy_ctrl {
  overflow:hidden;
}
.pg_famsaldi_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:193px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:42px;
}
.pg_famsaldi_portlet > .Box31_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:59px;
  left:254px;
  left:31.75%;
  right:309px;
  right:38.625%;
  width:auto;
  height:auto;
  min-height:90px;
  display:flex;
  flex-direction:column;
}
.pg_famsaldi_portlet > .Box31_ctrl {
  height:90px;
}
.pg_famsaldi_portlet > .Box31_ctrl > .box_content {
  height:100%;
}
.pg_famsaldi_portlet > .Box31_ctrl {
  min-height:90px;
}
.pg_famsaldi_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:155px;
  width:53px;
  height:20px;
}
.pg_famsaldi_portlet > .anno_ctrl {
}
.pg_famsaldi_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  width:100%;
  height:100%;
}
.pg_famsaldi_portlet > .Label32_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:66px;
  left:285px;
  left:35.625%;
  right:381px;
  right:47.625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .Label32_ctrl {
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .Label32_ctrl {
  overflow:hidden;
}
.pg_famsaldi_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:19px;
  left:9px;
  width:143px;
  height:auto;
  min-height:19px;
}
.pg_famsaldi_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famsaldi_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_famsaldi_portlet > .certSi_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:65px;
  left:439px;
  left:54.875%;
  right:341px;
  right:42.625%;
  width:auto;
  height:20px;
}
.pg_famsaldi_portlet > .certSi_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#00FF00;
}
.pg_famsaldi_portlet > .certNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:65px;
  left:464px;
  left:58.0%;
  right:316px;
  right:39.5%;
  width:auto;
  height:20px;
}
.pg_famsaldi_portlet > .certNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_famsaldi_portlet > .flgstp_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:164px;
  left:10px;
  width:418px;
  height:20px;
}
.pg_famsaldi_portlet > .btnPrint_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:153px;
  right:45px;
  width:30px;
  height:30px;
}
.pg_famsaldi_portlet > .btnPrint_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famsaldi_portlet > .btnSearch_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:153px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_famsaldi_portlet > .btnSearch_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_famsaldi_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:393px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:-1px;
  width:auto;
}
.pg_famsaldi_portlet > .flginvio_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:21px;
  left:260px;
  left:32.5%;
  right:197px;
  right:24.625%;
  width:auto;
  height:20px;
  height:auto;
  min-height:20px;
}
.pg_famsaldi_portlet > .javaNo_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:95px;
  left:464px;
  left:58.0%;
  right:316px;
  right:39.5%;
  width:auto;
  height:20px;
}
.pg_famsaldi_portlet > .javaNo_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#FF0000;
}
.pg_famsaldi_portlet > .anticipo_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:164px;
  left:454px;
  left:56.75%;
  right:113px;
  right:14.125%;
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
 String def="[{\"h\":\"600\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"439\",\"y\":\"95\",\"zindex\":\"14\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"893\",\"y\":\"-16\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"JRE Esecuzione\",\"w\":\"134\",\"x\":\"285\",\"y\":\"95\",\"zindex\":\"13\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"894\",\"y\":\"15\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"439\",\"y\":\"124\",\"zindex\":\"14\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"464\",\"y\":\"124\",\"zindex\":\"14\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"422\",\"y\":\"-61\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"157\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"236\",\"zindex\":\"\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Validità Certificati\",\"w\":\"134\",\"x\":\"285\",\"y\":\"124\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"42\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"193\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"237\",\"x\":\"254\",\"y\":\"59\",\"zindex\":\"12\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"155\",\"y\":\"18\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label32\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Presenza Certificati\",\"w\":\"134\",\"x\":\"285\",\"y\":\"66\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"143\",\"x\":\"9\",\"y\":\"19\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"certSi\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"439\",\"y\":\"65\",\"zindex\":\"14\"},{\"h\":\"30\",\"name\":\"RTClean\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"82\",\"x\":\"154\",\"y\":\"-65\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"certNo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"464\",\"y\":\"65\",\"zindex\":\"14\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Non creare i file per le stampe (Per grossi volumi di dati - IP)\",\"layout_steps_values\":{},\"name\":\"flgstp\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"418\",\"x\":\"10\",\"y\":\"164\",\"zindex\":\"5\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnPrint\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"153\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"java\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"892\",\"y\":\"-43\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnSearch\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"153\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTSearch\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"245\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTPrint\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"74\",\"x\":\"334\",\"y\":\"-61\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"208\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"393\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"flginvio\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"343\",\"x\":\"260\",\"y\":\"21\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"javaNo\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"464\",\"y\":\"95\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Invio Saldi per cessazione\",\"layout_steps_values\":{},\"name\":\"anticipo\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"233\",\"x\":\"454\",\"y\":\"164\",\"zindex\":\"15\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_famsaldi","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_famsaldi_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_famsaldi','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%boolean certificati= false;
String Label32_Copy= "JRE Esecuzione";
boolean validita= false;
String Label32_Copy_Copy= "Validità Certificati";
double anno= 0;
if(request.getAttribute("pg_famsaldi_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label32= "Presenza Certificati";
String lblAnno= "Anno di riferimento:";
String flgstp="N";
boolean java= false;
String flginvio="N";
String anticipo= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_famsaldi_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_famsaldi_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_famsaldi_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_famsaldi','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_javaSi' class='image-default javaSi_ctrl'   target=''>&#xe96c;</a>
<span id='<%=idPortlet%>_Label32_Copy'  formid='<%=idPortlet%>' ps-name='Label32_Copy'    class='label Label32_Copy_ctrl'><div id='<%=idPortlet%>_Label32_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("JRE Esecuzione")%></div></span>
<a id='<%=idPortlet%>_valiSi' class='image-default valiSi_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_valiNo' class='image-default valiNo_ctrl'   target=''>&#xe96c;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<span id='<%=idPortlet%>_Label32_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label32_Copy_Copy'    class='label Label32_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label32_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Validità Certificati")%></div></span>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<div id='<%=idPortlet%>_Box31' class='Box31_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box31_td' class='box_content'></div>
</div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_Label32'  formid='<%=idPortlet%>' ps-name='Label32'    class='label Label32_ctrl'><div id='<%=idPortlet%>_Label32tbl' style='width:100%;'><%=JSPLib.ToHTML("Presenza Certificati")%></div></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<a id='<%=idPortlet%>_certSi' class='image-default certSi_ctrl'   target=''>&#xe96c;</a>
<a id='<%=idPortlet%>_certNo' class='image-default certNo_ctrl'   target=''>&#xe96c;</a>
<div id='<%=idPortlet%>_flgstp_div' style=''><input id='<%=idPortlet%>_flgstp' name='flgstp' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgstp' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Non creare i file per le stampe (Per grossi volumi di dati - IP)")%></label></div>
<a id='<%=idPortlet%>_btnPrint' class='image btnPrint_ctrl'   target=''>&#xeb05;</a>
<a id='<%=idPortlet%>_btnSearch' class='image btnSearch_ctrl'   target=''>&#xe9dc;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_flginvio' class='radio' style='z-index:1;'></div>
<a id='<%=idPortlet%>_javaNo' class='image-default javaNo_ctrl'   target=''>&#xe96c;</a>
<div id='<%=idPortlet%>_anticipo_div' style=''><input id='<%=idPortlet%>_anticipo' name='anticipo' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_anticipo' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Invio Saldi per cessazione")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_famsaldi');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_famsaldi',["800"],["600"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"600","title":"","layer":""}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":13,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.javaSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default javaSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_javaSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"javaSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":439,"y":95,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.certificati=new ZtVWeb._VC(this,'certificati',null,'logic',<%=certificati%>,false,false);
this.Label32_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32_Copy,false,true)%>","type":"Label","w":134,"x":285,"y":95,"zindex":"13"});
this.validita=new ZtVWeb._VC(this,'validita',null,'logic',<%=validita%>,false,false);
this.valiSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default valiSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_valiSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"valiSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":439,"y":124,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_famsaldi",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_anno=anno,w_flginvio=flginvio,w_flgstp=flgstp,w_anticipo=anticipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famsaldi","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_famsaldi",request.getSession())%>';
this.valiNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default valiNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_valiNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"valiNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":464,"y":124,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTChecks=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_check_sid",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChecks","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChecks","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_check_sid","target":"","type":"SPLinker","w":120,"x":422,"y":-61});
this.RTChecks.m_cID='<%=JSPLib.cmdHash("routine,arfn_check_sid",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_pLog","h":157,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":800,"x":0,"y":236,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.Label32_Copy_Copy=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32_Copy_Copy,false,true)%>","type":"Label","w":134,"x":285,"y":124,"zindex":"13"});
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":42,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":800,"x":0,"y":193,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Box31=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box31","groupName":"","h":90,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box31","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":237,"x":254,"y":59,"zindex":"12"});
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"Year(SystemDate())-1","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=anno%>","w":53,"x":155,"y":18,"zerofilling":false,"zindex":"1","zoom":""});
this.Label32=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label32,false,true)%>","type":"Label","w":134,"x":285,"y":66,"zindex":"13"});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":143,"x":9,"y":19,"zindex":"1"});
this.certSi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default certSi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_certSi","edit_undercond":"","field":"","font_color":"#00FF00","font_color_hover":"#00FF00","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"certSi","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":439,"y":65,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":82,"x":154,"y":-65});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.certNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default certNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_certNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"certNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":464,"y":65,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.flgstp=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgstp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Non creare i file per le stampe (Per grossi volumi di dati - IP)","layer":false,"layout_steps_values":{},"name":"flgstp","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":418,"x":10,"y":164,"zindex":"5"});
this.flgstp.Value('<%=flgstp%>');
this.btnPrint=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnPrint_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPrint","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa contenuto dei file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnPrint","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":153,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.java=new ZtVWeb._VC(this,'java',null,'logic',<%=java%>,false,false);
this.btnSearch=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnSearch_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnSearch","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9dc;","font_image_hover":"&#xe9dd;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Visualizza i file creati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnSearch","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9dc;","srchover":"&#xe9dd;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":153,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSearch=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSearch","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSearch","offline":false,"page":1,"parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":80,"x":245,"y":-63});
this.RTSearch.m_cID='<%=JSPLib.cmdHash("entity,list_filesid_portlet.jsp",request.getSession())%>';
this.RTPrint=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPrint","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPrint","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famsaldi_stp","target":"iPrint","type":"SPLinker","w":74,"x":334,"y":-61});
this.RTPrint.m_cID='<%=JSPLib.cmdHash("routine,arrt_famsaldi_stp",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":208,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":393,"zindex":"9"});
this.flginvio=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Reinvia tutti i saldi,Invia Solo i saldi non inviati","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_flginvio","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":20,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"N","layer":false,"layout_steps_values":{},"name":"flginvio","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"S,N","visible":true,"w":343,"x":260,"y":21,"zindex":"10"});
this.flginvio.Value('<%=JSPLib.ToJSValue(flginvio,false,true)%>');
this.javaNo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default javaNo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_javaNo","edit_undercond":"","field":"","font_color":"#FF0000","font_color_hover":"#FF0000","font_image":"&#xe96c;","font_image_hover":"&#xe96c;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"javaNo","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96c;","srchover":"&#xe96c;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":464,"y":95,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.anticipo=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"1","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_anticipo","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Invio Saldi per cessazione","layer":false,"layout_steps_values":{},"name":"anticipo","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"0","w":233,"x":454,"y":164,"zindex":"15"});
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
<%if(request.getAttribute("pg_famsaldi_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_famsaldi_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_famsaldi_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.javaSi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.valiSi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.valiNo.dispatchEvent('OnLoad');
window.<%=idPortlet%>.certSi.dispatchEvent('OnLoad');
window.<%=idPortlet%>.certNo.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnPrint.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnSearch.dispatchEvent('OnLoad');
window.<%=idPortlet%>.javaNo.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_famsaldi',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_famsaldi');
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
sp.endPage("pg_famsaldi");
}%>
<%! public String getJSPUID() { return "520947270"; } %>