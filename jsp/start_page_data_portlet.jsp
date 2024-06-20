<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){  \n  this.Label11.Hide()\n  if(!Empty(this.newver.Value())) {\n    alert(this.newver.Value())\n  }    \n}\n\nfunction RTRelease_Result(result){\n  this.RTNewVersion.Link();\n  this.lblVersione.Value(result);\n}\n\nfunction RTNewVersion_Result(result){\n  if(!Empty(this.newver.Value())) {\n    alert(this.newver.Value());\n    this.lblVersione.Value(this.versione.Value()+'\\n'+this.newver.Value());\n  }\n}\n\nfunction Label11_Click(){\n  this.RTManuale.Link()\n}\n\nfunction dataobj_companies_ConsumersRendered(){\n  this.Variable_count_company.Value(this.dataobj_companies.GetQueryCount());\n  if(this.Variable_count_company.Value()==1){\n    this.g_codazi.Value(this.dataobj_companies.rs.codazi);\n    this.RTChgAzi.Link();\n    this.g_codazi.Disabled()\n  }else{\n    if(!Empty(this.gAzienda.Value())){\n      this.g_codazi.Value(this.gAzienda.Value());\n    }\n  }\n}\n\nfunction g_codazi_onChange(){\n  if (this.g_codazi.Value() != this.gAzienda.Value()) {\n    if(confirm(\"Confermi il cambio dell'azienda?\\n(Tutti i dati non salvati verranno persi)\")) {\n      this.g_codazi.SetCurRec()\n      this.RTChgAzi.Link()  \n      if(this.Variable_count_company.Value()\u003e1){\n        this.RTPulizia.Link();\n      }    \n      this.g_codazi.Value(this.gAzienda.Value())\n    } else {\n      this.g_codazi.Value(this.gAzienda.Value())\n    }  \n  }  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Dati Azienda","fixed_top":"false","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @g_codazi }}{{ @lblVersione }}{{ @Image5 }}{{ @imgMIT }}{{ @elabgen }}{{ @Label11 }}{{ @lblCompany }}\u003c\u002fbody\u003e","grapesCss":"","h":"275","hsl":"","htmlcode":" \n{{ @g_codazi }} \n{{ @lblCompany }} \n{{ @Label11 }} \n \n{{ @elabgen }}\n{{ @imgMIT }}\n{{ @Image5 }}\n\n{{ @lblVersione }}\n{{ gAzienda }}\n{{ RTRelease }}\n{{ versione }}\n{{ RTNewVersion }}\n{{ newver }}\n{{ lblVersione }}\n{{ lblAzienda }}\n{{ Image5 }}\n{{ imgMIT }}\n{{ elabgen }}\n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"empty","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"275\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"pagelet","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"230","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"315","y":"-47"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"100","name":"dataobj_companies","offline":"false","page":"1","parms":"pcodazi=gListAzi","parms_source":"","query":"qbe_login_companies_filtered","query_async":"true","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"157","waiting_mgs":"","x":"324","y":"214"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"dataobj_companies","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"Tahoma, Geneva, sans-serif","font_size":"10","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","name":"g_codazi","page":"1","picture":"","rapp":"","sequence":"3","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":"true","w":"210","wireframe_props":"name,textlist","x":"10","y":"69","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"Variable_count_company_Copy","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"157","x":"324","y":"237"},{"allowedentities":"arfn_release","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function autoexec","name":"RTRelease","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arfn_release","target":"versione","type":"SPLinker","w":"120","x":"315","y":"-24"},{"allowedentities":"arfn_chgazi","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTChgAzi","offline":"false","page":"1","parms":"pCodAzi=g_codazi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arfn_chgazi","target":"","type":"SPLinker","w":"157","x":"324","y":"262"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"versione","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"315","y":"-1"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"99","hide":"","layer":"","layout_steps_values":"{}","name":"Note9","page":"1","rapp":"","sequence":"8","spuid":"","type":"Note","value":"Al cambio di azienda ricarico tutto ma solo se ho più di un azienda.\nAttenzione se c'è solo un azienda collegata non lo fa e non attivarlo altrimenti va in loop\n(vedi action code di start_page_data)","w":"463","wireframe_props":"","x":"530","y":"163","zindex":"3","zone":""},{"allowedentities":"fn_app_new_version","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTNewVersion","offline":"false","page":"1","parms":"pAppl=ANTI,pRelease=versione","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"fn_app_new_version","target":"newver","type":"SPLinker","w":"120","x":"315","y":"22"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"newver","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"315","y":"45"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"120","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblVersione","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Release","w":"230","wireframe_props":"align,value,n_col","x":"0","y":"12","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"69","help_tips":"","hide":"false","hide_undercond":"","href":"http:\u002f\u002fwww.soffiate.it","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image5","page":"1","path_type":"","rapp":"","sequence":"12","server_side":"","spuid":"","src":"..\u002fimages\u002fwhistle.png","srchover":"","tabindex":"","target":"_new","type":"Image","type_submit":"false","w":"109","wireframe_props":"","x":"60","y":"99","zindex":"2","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"69","help_tips":"","hide":"false","hide_undercond":"","href":"http:\u002f\u002fwww.gruppomit.com","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"imgMIT","page":"1","path_type":"","rapp":"","sequence":"13","server_side":"","spuid":"","src":"..\u002fimages\u002fmit.jpg","srchover":"","tabindex":"","target":"_new","type":"Image","type_submit":"false","w":"109","wireframe_props":"","x":"60","y":"174","zindex":"2","zone":""},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"2","hide":"true","layer":"false","layout_steps_values":"{}","name":"elabgen","page":"1","rapp":"","sequence":"14","spuid":"","type":"Iframe","w":"2","wireframe_props":"","x":"4","y":"75","zindex":"3","zone":""},{"allowedentities":"arrt_cgo_manuale","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTManuale","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arrt_cgo_manuale","target":"","type":"SPLinker","w":"120","x":"317","y":"66"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label11","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MANUALE","w":"228","wireframe_props":"align,value,n_col","x":"0","y":"250","zindex":"5","zone":""},{"allowedentities":"default.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"RTPulizia","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"default.jsp","target":"","type":"SPLinker","w":"120","x":"322","y":"114"},{"allowedentities":"start_page_logo_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"RTPulizia_Copy_da_eliminare_se_va_bene_l_altro","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"start_page_logo_portlet.jsp","target":"main","type":"SPLinker","w":"120","x":"324","y":"138"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"Variable_count_company","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"324","y":"160"},{"align":"center","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblCompany","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_COMPANY","w":"230","wireframe_props":"align,value,n_col","x":"0","y":"43","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gListAzi","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"157","x":"324","y":"190"}]%>
<%/*Description:Dati Azienda*/%>
<%/*ParamsRequest:g_codazi*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
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
window.start_page_data_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTRelease_Result !='undefined')this.RTRelease_Result=RTRelease_Result;
if(typeof RTNewVersion_Result !='undefined')this.RTNewVersion_Result=RTNewVersion_Result;
if(typeof Label11_Click !='undefined')this.Label11_Click=Label11_Click;
if(typeof dataobj_companies_ConsumersRendered !='undefined')this.dataobj_companies_ConsumersRendered=dataobj_companies_ConsumersRendered;
if(typeof g_codazi_onChange !='undefined')this.g_codazi_onChange=g_codazi_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_companies.addRowConsumer(this.g_codazi);
function this_Loaded(){  
  this.Label11.Hide()
  if(!Empty(this.newver.Value())) {
    alert(this.newver.Value())
  }    
}
function RTRelease_Result(result){
  this.RTNewVersion.Link();
  this.lblVersione.Value(result);
}
function RTNewVersion_Result(result){
  if(!Empty(this.newver.Value())) {
    alert(this.newver.Value());
    this.lblVersione.Value(this.versione.Value()+'\n'+this.newver.Value());
  }
}
function Label11_Click(){
  this.RTManuale.Link()
}
function dataobj_companies_ConsumersRendered(){
  this.Variable_count_company.Value(this.dataobj_companies.GetQueryCount());
  if(this.Variable_count_company.Value()==1){
    this.g_codazi.Value(this.dataobj_companies.rs.codazi);
    this.RTChgAzi.Link();
    this.g_codazi.Disabled()
  }else{
    if(!Empty(this.gAzienda.Value())){
      this.g_codazi.Value(this.gAzienda.Value());
    }
  }
}
function g_codazi_onChange(){
  if (this.g_codazi.Value() != this.gAzienda.Value()) {
    if(confirm("Confermi il cambio dell'azienda?\n(Tutti i dati non salvati verranno persi)")) {
      this.g_codazi.SetCurRec()
      this.RTChgAzi.Link()  
      if(this.Variable_count_company.Value()>1){
        this.RTPulizia.Link();
      }    
      this.g_codazi.Value(this.gAzienda.Value())
    } else {
      this.g_codazi.Value(this.gAzienda.Value())
    }  
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
.start_page_data_container {
}
.start_page_data_portlet{
  position:relative;
  width:100%;
  min-width:230px;
  height:275px;
}
.start_page_data_portlet[Data-page="1"]{
  height:275px;
  width:100%;
}
.start_page_data_portlet > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:69px;
  left:10px;
  left:4.347826%;
  right:10px;
  right:4.347826%;
  width:auto;
  height:20px;
}
.start_page_data_portlet > .lblVersione_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:25px;
}
.start_page_data_portlet > .lblVersione_ctrl {
  height:auto;
  min-height:25px;
}
.start_page_data_portlet > .lblVersione_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:center;
  background-color:transparent;
}
.start_page_data_portlet > .lblVersione_ctrl > div{
  font-size:120%;
}
.start_page_data_portlet > .Image5_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:99px;
  left:60px;
  left:26.086956%;
  right:61px;
  right:26.52174%;
  width:auto;
  height:69px;
}
.start_page_data_portlet > .Image5_ctrl {
}
.start_page_data_portlet > .Image5_ctrl > a, .start_page_data_portlet > .Image5_ctrl > a:hover{
  text-decoration:none;
}
.start_page_data_portlet > .Image5_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:69px;
}
.start_page_data_portlet > .imgMIT_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:174px;
  left:60px;
  left:26.086956%;
  right:61px;
  right:26.52174%;
  width:auto;
  height:69px;
}
.start_page_data_portlet > .imgMIT_ctrl {
}
.start_page_data_portlet > .imgMIT_ctrl > a, .start_page_data_portlet > .imgMIT_ctrl > a:hover{
  text-decoration:none;
}
.start_page_data_portlet > .imgMIT_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:69px;
}
.start_page_data_portlet > .elabgen_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:75px;
  left:4px;
  left:1.7391304%;
  right:224px;
  right:97.391304%;
  width:auto;
  height:2px;
  display:none;
}
.start_page_data_portlet > .Label11_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:250px;
  left:0px;
  left:0.0%;
  right:2px;
  right:0.8695652%;
  width:auto;
  height:auto;
  min-height:20px;
}
.start_page_data_portlet > .Label11_ctrl a {
  height:auto;
  min-height:20px;
}
.start_page_data_portlet > .Label11_ctrl a {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
 display:block;
}
.start_page_data_portlet > .Label11_ctrl > div > a:hover{
  font-weight:bold;
  text-align:center;
}
.start_page_data_portlet > .lblCompany_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.start_page_data_portlet > .lblCompany_ctrl {
  height:auto;
  min-height:20px;
}
.start_page_data_portlet > .lblCompany_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:center;
  background-color:transparent;
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
 String def="[{\"h\":\"275\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"230\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"315\",\"y\":\"-47\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"157\",\"x\":\"324\",\"y\":\"214\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"g_codazi\",\"page\":\"1\",\"textlist\":\"desazi\",\"type\":\"Combobox\",\"w\":\"210\",\"x\":\"10\",\"y\":\"69\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"Variable_count_company_Copy\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"157\",\"x\":\"324\",\"y\":\"237\"},{\"h\":\"20\",\"name\":\"RTRelease\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"315\",\"y\":\"-24\"},{\"h\":\"20\",\"name\":\"RTChgAzi\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"157\",\"x\":\"324\",\"y\":\"262\"},{\"h\":\"20\",\"name\":\"versione\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"315\",\"y\":\"-1\"},{\"anchor\":\"\",\"h\":\"99\",\"layout_steps_values\":{},\"name\":\"Note9\",\"page\":\"1\",\"type\":\"Note\",\"w\":\"463\",\"x\":\"530\",\"y\":\"163\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"RTNewVersion\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"315\",\"y\":\"22\"},{\"h\":\"20\",\"name\":\"newver\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"315\",\"y\":\"45\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblVersione\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Release\",\"w\":\"230\",\"x\":\"0\",\"y\":\"12\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"69\",\"layout_steps_values\":{},\"name\":\"Image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"109\",\"x\":\"60\",\"y\":\"99\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"69\",\"layout_steps_values\":{},\"name\":\"imgMIT\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"109\",\"x\":\"60\",\"y\":\"174\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"2\",\"layout_steps_values\":{},\"name\":\"elabgen\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"2\",\"x\":\"4\",\"y\":\"75\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"RTManuale\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"317\",\"y\":\"66\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label11\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MANUALE\",\"w\":\"228\",\"x\":\"0\",\"y\":\"250\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"RTPulizia\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"322\",\"y\":\"114\"},{\"h\":\"20\",\"name\":\"RTPulizia_Copy_da_eliminare_se_va_bene_l_altro\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"324\",\"y\":\"138\"},{\"h\":\"20\",\"name\":\"Variable_count_company\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"324\",\"y\":\"160\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblCompany\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_COMPANY\",\"w\":\"230\",\"x\":\"0\",\"y\":\"43\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"gListAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"157\",\"x\":\"324\",\"y\":\"190\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_data","UTF-8")) {return; }
 %><%if(request.getAttribute("javax.servlet.include.request_uri")==null && request.getParameter("clientsideinclusion")==null){
if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_data_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.start_page_data_portlet > .elabgen_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_data','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gAzienda=sp.getGlobal("gAzienda","");
String g_codazi=JSPLib.translateXSS(sp.getParameter("g_codazi",""));
String Variable_count_company_Copy= "";
String versione= "";
String newver= "";
String lblVersione= "Release";
String Label11= "MANUALE";
String Variable_count_company= "";
String lblCompany= "MSG_COMPANY";
String gListAzi=sp.getGlobal("gListAzi","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_data_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_data_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_data','<%=idPortlet%>',false,'');
</script><%}}%>
<select id='<%=idPortlet%>_g_codazi' name='g_codazi' class='combobox' style='font-family:Tahoma, Geneva, sans-serif;font-size:10;' tabindex='4'></select>
<span id='<%=idPortlet%>_lblVersione'  formid='<%=idPortlet%>' ps-name='lblVersione'    class='label lblVersione_ctrl'><div id='<%=idPortlet%>_lblVersionetbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Release"))%></div></span>
<div id='<%=idPortlet%>_Image5'><a id='<%=idPortlet%>_Image5href' href='http://www.soffiate.it' target='_new'><img id='<%=idPortlet%>_Image5_img' class='image-default Image5_ctrl' src="../images/whistle.png" border='0' ></a>
</div><div id='<%=idPortlet%>_imgMIT'><a id='<%=idPortlet%>_imgMIThref' href='http://www.gruppomit.com' target='_new'><img id='<%=idPortlet%>_imgMIT_img' class='image-default imgMIT_ctrl' src="../images/mit.jpg" border='0' ></a>
</div><div id='<%=idPortlet%>_elabgen_DIV'>&nbsp;</div>
<span id='<%=idPortlet%>_Label11'  formid='<%=idPortlet%>' ps-name='Label11'    class='label Label11_ctrl'><div id='<%=idPortlet%>_Label11tbl' style='width:100%;'><a id='<%=idPortlet%>_Label11href' title='<%=JSPLib.ToHTML(sp.translate("MANUALE"))%>' href='#'  ><%=JSPLib.ToHTML(sp.translate("MANUALE"))%></a></div></span>
<span id='<%=idPortlet%>_lblCompany'  formid='<%=idPortlet%>' ps-name='lblCompany'    class='label lblCompany_ctrl'><div id='<%=idPortlet%>_lblCompanytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_COMPANY"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_data');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_data',["230"],["275"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"230","h":"275","title":"","layer":""}]);
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.dataobj_companies=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_login_companies_filtered","cmdHash":"<%=JSPLib.cmdHash("qbe_login_companies_filtered",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_companies","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_companies","nrows":"100","page":1,"parms":"pcodazi=gListAzi","parms_source":"","type":"SQLDataobj","w":157,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":324,"y":214});
this.g_codazi=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_g_codazi","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"Tahoma, Geneva, sans-serif","font_size":"10","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=g_codazi%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"g_codazi","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":true,"w":210,"x":10,"y":69,"zindex":"1"});
this.Variable_count_company_Copy=new ZtVWeb._VC(this,'Variable_count_company_Copy',null,'character','<%=JSPLib.ToJSValue(Variable_count_company_Copy,false,true)%>',false,false);
this.RTRelease=new ZtVWeb.SPLinkerCtrl(this,{"action":"function autoexec","allowedEntities":"<%=JSPLib.encrypt("arfn_release",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTRelease","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTRelease","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_release","target":"versione","type":"SPLinker","w":120,"x":315,"y":-24});
this.RTRelease.m_cID='<%=JSPLib.cmdHash("routine,arfn_release",request.getSession())%>';
this.RTRelease.Link();
this.RTChgAzi=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_chgazi",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTChgAzi","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTChgAzi","offline":false,"page":1,"parms":"pCodAzi=g_codazi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_chgazi","target":"","type":"SPLinker","w":157,"x":324,"y":262});
this.RTChgAzi.m_cID='<%=JSPLib.cmdHash("routine,arfn_chgazi",request.getSession())%>';
this.versione=new ZtVWeb._VC(this,'versione',null,'character','<%=JSPLib.ToJSValue(versione,false,true)%>',false,false);
this.RTNewVersion=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("fn_app_new_version",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTNewVersion","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTNewVersion","offline":false,"page":1,"parms":"pAppl=ANTI,pRelease=versione","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"fn_app_new_version","target":"newver","type":"SPLinker","w":120,"x":315,"y":22});
this.RTNewVersion.m_cID='<%=JSPLib.cmdHash("routine,fn_app_new_version",request.getSession())%>';
this.newver=new ZtVWeb._VC(this,'newver',null,'character','<%=JSPLib.ToJSValue(newver,false,true)%>',false,false);
this.lblVersione=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblVersione","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"120","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblVersione","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblVersione),false,true)%>","type":"Label","w":230,"x":0,"y":12,"zindex":"1"});
this.Image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":69,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"http:\u002f\u002fwww.soffiate.it","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image5","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fwhistle.png","srchover":"","tabindex":"","target":"_new","type":"Image","type_submit":"false","w":109,"x":60,"y":99,"zindex":"2"});
this.imgMIT=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default imgMIT_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgMIT","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":69,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"http:\u002f\u002fwww.gruppomit.com","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"imgMIT","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fmit.jpg","srchover":"","tabindex":"","target":"_new","type":"Image","type_submit":"false","w":109,"x":60,"y":174,"zindex":"2"});
this.elabgen=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_elabgen","default_portlet":"","h":2,"hide":"true","layer":false,"layout_steps_values":{},"name":"elabgen","name_iframe":"elabgen","page":1,"spuid":"","type":"Iframe","w":2,"x":4,"y":75,"zindex":"3"});
this.RTManuale=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_cgo_manuale",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTManuale","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTManuale","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_manuale","target":"","type":"SPLinker","w":120,"x":317,"y":66});
this.RTManuale.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_manuale",request.getSession())%>';
this.Label11=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label11","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label11","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(Label11),false,true)%>","type":"Label","w":228,"x":0,"y":250,"zindex":"5"});
this.RTPulizia=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("default.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPulizia","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPulizia","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"default.jsp","target":"","type":"SPLinker","w":120,"x":322,"y":114});
this.RTPulizia.m_cID='<%=JSPLib.cmdHash("entity,default.jsp",request.getSession())%>';
this.RTPulizia_Copy_da_eliminare_se_va_bene_l_altro=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("start_page_logo_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPulizia_Copy_da_eliminare_se_va_bene_l_altro","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPulizia_Copy_da_eliminare_se_va_bene_l_altro","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"main","type":"SPLinker","w":120,"x":324,"y":138});
this.RTPulizia_Copy_da_eliminare_se_va_bene_l_altro.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.Variable_count_company=new ZtVWeb._VC(this,'Variable_count_company',null,'character','<%=JSPLib.ToJSValue(Variable_count_company,false,true)%>',false,false);
this.lblCompany=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCompany","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCompany","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblCompany),false,true)%>","type":"Label","w":230,"x":0,"y":43,"zindex":"1"});
this.gListAzi=new ZtVWeb._VC(this,'gListAzi',null,'character','<%=JSPLib.ToJSValue(gListAzi,false,true)%>',false,false);
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
<%if(request.getAttribute("start_page_data_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("start_page_data_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.start_page_data_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.dataobj_companies.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_data',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_data');
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
sp.endPage("start_page_data");
}%>
<%! public String getJSPUID() { return "348732411"; } %>