<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle(\"Stampa Dipendenze\u002fAgenzie\",true) \nthis.getTitlePortlet().AppendButton({\n  id:\"Stampa\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Stampa Dipendenze\u002fAgenzie'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.Stampa()'\n  },1); \n\nfunction Stampa() {\n  if(confirm(\"Confermi la stampa?\")) {\n    this.RPStampa.Link()    \n  }  \n}  ","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"Stampa Dipendenze\u002fAgenzie","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"510","hsl":"","htmlcode":"{{ @iPrint }}\n{{ @lblOrdine }}\n{{ @OrderBy }}\n{{ @tipstp }}\n\n{{ @descazi2 }}\n{{ @LinkZoom17_Copy }}\n{{ @lbl_Agenzia2 }}\n{{ @aCodDip }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @descazi1 }}\n{{ @LinkZoom17 }}\n\n\n{{ @Agenzia }}\n\n{{ @daCodDip }}\n\n\n\n\n\n\n\n\n\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"},\"-1\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"768","wizard":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl_Agenzia2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Dipendenza\u002fAgenzia:","w":"175","wireframe_props":"align,value,n_col","x":"15","y":"48","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"aCodDip,descazi2","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"aCodDip","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17_Copy","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"2","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"250","y":"48","zindex":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descazi2","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"339","wireframe_props":"name","x":"282","y":"48","zerofilling":"false","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"tipstp","page":"1","picture":"","sequence":"4","spuid":"","tabindex":"","textlist":"Solo Agenti","type":"Combobox","typevar":"character","valuelist":"S","visible":"true","w":"120","wireframe_props":"name,textlist","x":"16","y":"78","zindex":"2"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"RPStampa","offline":"false","page":"1","parms":"ReportName=arrp_stpdipe.vrp,daCodDip=daCodDip,aCodDip=aCodDip,tipstp=tipstp,descazi=gDescAzi,OrderBy=OrderBy,showParameterMask=false,formatTypes=formati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"820","y":"-75"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"818","y":"-44"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"OrderBy","page":"1","picture":"","sequence":"7","spuid":"","tabindex":"","textlist":"Denominazione,Codice","type":"Combobox","typevar":"character","valuelist":"DESCRIZ,CODDIP","visible":"true","w":"323","wireframe_props":"name,textlist","x":"288","y":"78","zindex":"5"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOrdine","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Ordinamento:","w":"92","wireframe_props":"align,value,n_col","x":"186","y":"78","zindex":"6"},{"calculate":"\"PDF$|$XLS$|$CSV\"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"formati","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"814","y":"-10"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"400","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"10","spuid":"","type":"Iframe","w":"768","wireframe_props":"","x":"0","y":"107","zindex":"8"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daCodDip","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"54","wireframe_props":"name","x":"194","y":"19","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Agenzia","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Dipendenza\u002fAgenzia:","w":"175","wireframe_props":"align,value,n_col","x":"14","y":"20","zindex":"1"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"cgo_agenzie","ctrlOfVariant":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"daCodDip,descazi1","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"daCodDip","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom17","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"13","servlet":"","spuid":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"250","y":"20","zindex":"","zoomtitle":"Elenco Agenzie\u002fLocali"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descazi1","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"339","wireframe_props":"name","x":"282","y":"20","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"aCodDip","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"54","wireframe_props":"name","x":"194","y":"47","zerofilling":"false","zindex":"1"}]%>
<%/*Description:Stampa Dipendenze/Agenzie*/%>
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
window.pg_stpdipen_Static=function(){
if(typeof Stampa !='undefined')this.Stampa=Stampa;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
this.formati.Set("PDF|XLS|CSV");
}
this.LinkZoom17_Copy.addObserverFixedVars();
this.LinkZoom17.addObserverFixedVars();
this.getTitlePortlet().SetTitle("Stampa Dipendenze/Agenzie",true) 
this.getTitlePortlet().AppendButton({
  id:"Stampa",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Stampa Dipendenze/Agenzie'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.Stampa()'
  },1); 
function Stampa() {
  if(confirm("Confermi la stampa?")) {
    this.RPStampa.Link()    
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
.pg_stpdipen_container {
}
.pg_stpdipen_title_container {
  margin: auto;
}
.pg_stpdipen_portlet{
  position:relative;
  margin: auto;
  width:768px;
  min-width:768px;
  height:510px;
}
.pg_stpdipen_portlet[Data-page="1"]{
  height:510px;
  width:768px;
}
.pg_stpdipen_portlet > .lbl_Agenzia2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:15px;
  width:175px;
  height:auto;
  min-height:19px;
}
.pg_stpdipen_portlet > .lbl_Agenzia2_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stpdipen_portlet > .lbl_Agenzia2_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:right;
  background-color:transparent;
}
.pg_stpdipen_portlet > .LinkZoom17_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:250px;
  width:20px;
  height:20px;
}
.pg_stpdipen_portlet > .descazi2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:282px;
  width:339px;
  height:20px;
}
.pg_stpdipen_portlet > .descazi2_ctrl {
}
.pg_stpdipen_portlet > .descazi2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_stpdipen_portlet > .tipstp_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:78px;
  left:16px;
  width:120px;
  height:20px;
}
.pg_stpdipen_portlet > .OrderBy_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:78px;
  left:288px;
  width:323px;
  height:20px;
}
.pg_stpdipen_portlet > .lblOrdine_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:78px;
  left:186px;
  width:92px;
  height:auto;
  min-height:20px;
}
.pg_stpdipen_portlet > .lblOrdine_ctrl {
  height:auto;
  min-height:20px;
}
.pg_stpdipen_portlet > .lblOrdine_ctrl {
  overflow:hidden;
}
.pg_stpdipen_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:107px;
  left:0px;
  width:768px;
  height:400px;
}
.pg_stpdipen_portlet > .daCodDip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:19px;
  left:194px;
  width:54px;
  height:20px;
}
.pg_stpdipen_portlet > .daCodDip_ctrl {
}
.pg_stpdipen_portlet > .daCodDip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_stpdipen_portlet > .Agenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:14px;
  width:175px;
  height:auto;
  min-height:19px;
}
.pg_stpdipen_portlet > .Agenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_stpdipen_portlet > .Agenzia_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:right;
  background-color:transparent;
}
.pg_stpdipen_portlet > .LinkZoom17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:250px;
  width:20px;
  height:20px;
}
.pg_stpdipen_portlet > .descazi1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:282px;
  width:339px;
  height:20px;
}
.pg_stpdipen_portlet > .descazi1_ctrl {
}
.pg_stpdipen_portlet > .descazi1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_stpdipen_portlet > .aCodDip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  left:194px;
  width:54px;
  height:20px;
}
.pg_stpdipen_portlet > .aCodDip_ctrl {
}
.pg_stpdipen_portlet > .aCodDip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"510\",\"layout_steps_values\":{\"-1\":{\"h\":\"680\",\"w\":\"100%\"},\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"768\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Dipendenza\\u002fAgenzia:\",\"w\":\"175\",\"x\":\"15\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"250\",\"y\":\"48\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descazi2\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"339\",\"x\":\"282\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"tipstp\",\"page\":\"1\",\"textlist\":\"Solo Agenti\",\"type\":\"Combobox\",\"w\":\"120\",\"x\":\"16\",\"y\":\"78\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"RPStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"820\",\"y\":\"-75\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"818\",\"y\":\"-44\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"OrderBy\",\"page\":\"1\",\"textlist\":\"Denominazione,Codice\",\"type\":\"Combobox\",\"w\":\"323\",\"x\":\"288\",\"y\":\"78\",\"zindex\":\"5\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrdine\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Ordinamento:\",\"w\":\"92\",\"x\":\"186\",\"y\":\"78\",\"zindex\":\"6\"},{\"h\":\"20\",\"name\":\"formati\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"814\",\"y\":\"-10\"},{\"anchor\":\"\",\"h\":\"400\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"768\",\"x\":\"0\",\"y\":\"107\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daCodDip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"54\",\"x\":\"194\",\"y\":\"19\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Agenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Dipendenza\\u002fAgenzia:\",\"w\":\"175\",\"x\":\"14\",\"y\":\"20\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom17\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"250\",\"y\":\"20\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descazi1\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"339\",\"x\":\"282\",\"y\":\"20\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"aCodDip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"54\",\"x\":\"194\",\"y\":\"47\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_stpdipen","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_stpdipen_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_stpdipen','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lbl_Agenzia2= "A Dipendenza/Agenzia:";
if(request.getAttribute("pg_stpdipen_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String descazi2= "";
if(request.getAttribute("pg_stpdipen_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String tipstp= "";
String gDescAzi=sp.getGlobal("gDescAzi","");
String OrderBy= "";
String lblOrdine= "Ordinamento:";
String formati= "";
String daCodDip= "";
String Agenzia= "Da Dipendenza/Agenzia:";
String descazi1= "";
String aCodDip= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_stpdipen_title_container' style='width:768px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_stpdipen_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_stpdipen_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_stpdipen','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lbl_Agenzia2'  formid='<%=idPortlet%>' ps-name='lbl_Agenzia2'    class='label lbl_Agenzia2_ctrl'><div id='<%=idPortlet%>_lbl_Agenzia2tbl' style='width:100%;'><%=JSPLib.ToHTML("A Dipendenza/Agenzia:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descazi2_wrp'><input id='<%=idPortlet%>_descazi2' name='descazi2' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descazi2' /></span>
<select id='<%=idPortlet%>_tipstp' name='tipstp' class='combobox' style=''></select>
<select id='<%=idPortlet%>_OrderBy' name='OrderBy' class='combobox' style=''></select>
<span id='<%=idPortlet%>_lblOrdine'  formid='<%=idPortlet%>' ps-name='lblOrdine'    class='label lblOrdine_ctrl'><div id='<%=idPortlet%>_lblOrdinetbl' style='width:100%;'><%=JSPLib.ToHTML("Ordinamento:")%></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_daCodDip_wrp'><input id='<%=idPortlet%>_daCodDip' name='daCodDip' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daCodDip' /></span>
<span id='<%=idPortlet%>_Agenzia'  formid='<%=idPortlet%>' ps-name='Agenzia'    class='label Agenzia_ctrl'><div id='<%=idPortlet%>_Agenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Da Dipendenza/Agenzia:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom17'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_descazi1_wrp'><input id='<%=idPortlet%>_descazi1' name='descazi1' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descazi1' /></span>
<span class='textbox-container'id='<%=idPortlet%>_aCodDip_wrp'><input id='<%=idPortlet%>_aCodDip' name='aCodDip' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='aCodDip' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_stpdipen');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa Dipendenze/Agenzie",true)+","+JSPLib.ToJSValue(sp.translate("Stampa Dipendenze/Agenzie"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_stpdipen',["768"],["510"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{"-1":{"h":"680","w":"100%"},"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"-1":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"510","title":"","layer":"false","npage":"1"}]);
this.lbl_Agenzia2=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_Agenzia2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_Agenzia2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lbl_Agenzia2,false,true)%>","type":"Label","w":175,"x":15,"y":48,"zindex":"1"});
this.LinkZoom17_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stpdipen_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"aCodDip,descazi2","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stpdipen_portlet.jspLinkZoom17_Copy",request.getSession())%>","linkedField":"aCodDip","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":250,"y":48,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descazi2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descazi2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descazi2","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descazi2,false,true)%>","w":339,"x":282,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
this.tipstp=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipstp","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipstp%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"tipstp","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Solo Agenti","type":"Combobox","typevar":"character","valuelist":"S","visible":true,"w":120,"x":16,"y":78,"zindex":"2"});
this.RPStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RPStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RPStampa","offline":false,"page":1,"parms":"ReportName=arrp_stpdipe.vrp,daCodDip=daCodDip,aCodDip=aCodDip,tipstp=tipstp,descazi=gDescAzi,OrderBy=OrderBy,showParameterMask=false,formatTypes=formati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":820,"y":-75});
this.RPStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.OrderBy=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_OrderBy","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=OrderBy%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"OrderBy","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Denominazione,Codice","type":"Combobox","typevar":"character","valuelist":"DESCRIZ,CODDIP","visible":true,"w":323,"x":288,"y":78,"zindex":"5"});
this.lblOrdine=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrdine","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrdine","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOrdine,false,true)%>","type":"Label","w":92,"x":186,"y":78,"zindex":"6"});
this.formati=new ZtVWeb._VC(this,'formati',null,'character','<%=JSPLib.ToJSValue(formati,false,true)%>',false,false);
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":400,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":768,"x":0,"y":107,"zindex":"8"});
this.daCodDip=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daCodDip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daCodDip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(daCodDip,false,true)%>","w":54,"x":194,"y":19,"zerofilling":false,"zindex":"1","zoom":""});
this.Agenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Agenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Agenzia","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Agenzia,false,true)%>","type":"Label","w":175,"x":14,"y":20,"zindex":"1"});
this.LinkZoom17=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"cgo_agenzie","ctrlid":"<%=idPortlet%>_LinkZoom17","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_stpdipen_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"daCodDip,descazi1","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_stpdipen_portlet.jspLinkZoom17",request.getSession())%>","linkedField":"daCodDip","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom17","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,anadip,cgo_agenzie",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":250,"y":20,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Elenco Agenzie/Locali"),false,true)%>"});
this.descazi1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descazi1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descazi1","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descazi1,false,true)%>","w":339,"x":282,"y":20,"zerofilling":false,"zindex":"1","zoom":""});
this.aCodDip=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_aCodDip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"aCodDip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(aCodDip,false,true)%>","w":54,"x":194,"y":47,"zerofilling":false,"zindex":"1","zoom":""});
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
<%if(request.getAttribute("pg_stpdipen_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_stpdipen_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_stpdipen_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.tipstp.FillData();
window.<%=idPortlet%>.OrderBy.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_stpdipen',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_stpdipen');
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
sp.endPage("pg_stpdipen");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom17_Copy")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom17")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "2147066082"; } %>