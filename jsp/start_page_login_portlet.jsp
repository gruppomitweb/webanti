<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\n\u003c%if(!sp.hasAdministeredUsers()){%\u003e\n  window.location=\"..\u002fjsp\u002fdefault.jsp\";\n\u003c%}%\u003e\n\nthis.dataobj_companies.Query();\nif(this.dataobj_companies.isEmpty()){\n  this.lblCompany.Hide();\n  this.g_codazi.Hide();\n}\nif(this.dataobj_companies.GetQueryCount()==\"1\"){\n  this.g_codazi.empty_value=false;\n}\nfunction image_captcha_Click(){\n  this.image_captcha.Value('..\u002fservlet\u002fSPImageCaptchaServlet?a='+Math.random());\n}\nfunction image_captcha_new_code_Click(){\n  this.image_captcha_Click();\n}\nif(this.m_cFailedLoginReason.Value())\n  this.errore.Value(this.m_cFailedLoginReason.Value());\nelse\n  this.errore.Hide();\n\n\u003c%if(com.zucchetti.sitepainter.Library.captchaMustBeShown(request)){\n\u002f\u002fda esplorare la possibilita' di chiedere captcha di una certa dimensione piuttosto che averla\n\u002f\u002ffissa lato server\n%\u003e\nthis.image_captcha.Ctrl.style.width='\u003c%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageWidth\u002f2%\u003epx';\nthis.image_captcha.Ctrl.style.height='\u003c%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageHeight\u002f2%\u003epx';\nthis.image_captcha.Value('..\u002fservlet\u002fSPImageCaptchaServlet');\n\u003c%}else{%\u003e\nthis.m_cCaptcha.Hide();\nthis.image_captcha.Hide();\nthis.lbl_Captcha.Hide();\nthis.image_captcha_new_code.Hide();\n\u003c%}%\u003e\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Login standard","fixed_top":"","form_action":"..\u002fservlet\u002fcp_login","form_enctype":"","form_target":"","form_type":"true","h":"700","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"default page","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"350","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"bg","page":"1","path_type":"themed","sequence":"1","server_side":"","src":"..\u002fimages\u002fstart_logo.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"320","wireframe_props":"","x":"455","y":"-12","zindex":"0"},{"alt":"","anchor":"top-left","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"132","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"imgBar","page":"1","path_type":"skin","sequence":"2","server_side":"","src":"..\u002fimages\u002flogin\u002fblack_bar.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"940","wireframe_props":"","x":"1","y":"346","zindex":"1"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblUsername","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_USERNAME_STANDARD","w":"97","wireframe_props":"align,value,n_col","x":"449","y":"363","zindex":"1"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_Captcha","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_CAPTCHA","w":"65","wireframe_props":"align,value,n_col","x":"753","y":"363","zindex":"1"},{"anchor":"top-left","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"8pt","h":"18","help_tips":"Inserisci username","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"m_cUserName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","tabindex":"1","type":"Textbox","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"447","y":"379","zerofilling":"false","zindex":"2"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblPassword","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_PASSWORD_STANDARD","w":"105","wireframe_props":"align,value,n_col","x":"601","y":"363","zindex":"1"},{"anchor":"top-left","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"8pt","h":"18","help_tips":"Inserisci password","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"m_cPassword","page":"1","password":"true","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"6","tabindex":"2","type":"Textbox","typevar":"character","visible":"true","w":"150","wireframe_props":"name","x":"599","y":"379","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblCompany","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MSG_COMPANY","w":"82","wireframe_props":"align,value,n_col","x":"206","y":"452","zindex":"1"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"dataobj_companies","disabled":"false","edit_undercond":"","empty_value":"true","font":"verdana","font_size":"","h":"19","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","name":"g_codazi","page":"1","picture":"","sequence":"8","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"","valuelist":"codazi","visible":"true","w":"129","wireframe_props":"name,textlist","x":"290","y":"451","zindex":"1"},{"alt":"","anchor":"top-left","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"29","help_tips":"MSG_MENU_LOGIN_CLICK","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"Accedi","page":"1","path_type":"skin","sequence":"9","server_side":"","src":"..\u002fimages\u002flogin\u002flogin_enter.png","srchover":"..\u002fimages\u002flogin\u002flogin_enter_hover.png","tabindex":"5","target":"","type":"Image","type_submit":"true","w":"69","wireframe_props":"","x":"439","y":"442","zindex":"2"},{"appendingData":"false","auto_exec":"true","count":"false","h":"30","localDBName":"","n_records":"10","name":"dataobj_companies","offline":"false","page":"1","parms":"","parms_source":"","query":"start_login_companies","query_async":"false","return_fields_type":"true","sequence":"10","type":"SQLDataobj","w":"30","x":"2","y":"-35"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"'jsp\u002fdefault.jsp'","name":"m_cURL","page":"1","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"65","x":"62","y":"-29"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"'jsp\u002findex.jsp?login_failed=true'","name":"m_cURLOnError","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"114","x":"129","y":"-29"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"'login'","name":"m_cAction","page":"1","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"79","x":"245","y":"-29"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"login_failed","page":"1","sequence":"14","server_side":"false","type":"Variable","typevar":"logic","w":"68","x":"326","y":"-29"},{"align":"left","anchor":"","assoc_input":"","bg_color":"#ff3300","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"#FFFFFF","font_size":"7pt","font_weight":"bold","fontpct":"","h":"14","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"errore","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"errore","w":"150","wireframe_props":"align,value,n_col","x":"447","y":"399","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"m_cFailedLoginReason","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"memo","w":"124","x":"396","y":"-29"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"7pt","font_weight":"normal","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label18","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"&copy; 2017 Zucchetti SPA - Tutti i diritti riservati","w":"229","wireframe_props":"align,value,n_col","x":"566","y":"447","zindex":"1"},{"anchor":"top-left","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"8pt","h":"18","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"m_cCaptcha","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"18","tabindex":"3","type":"Textbox","typevar":"character","visible":"true","w":"90","wireframe_props":"name","x":"751","y":"379","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"40","help_tips":"MSG_CAPTCHA_GENERATE_NEW","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image_captcha","page":"1","path_type":"","sequence":"19","server_side":"","src":"","srchover":"","tabindex":"-1","target":"","type":"Image","type_submit":"false","w":"50","wireframe_props":"","x":"843","y":"368","zindex":"1"},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"Box_login","create_undercond":"","h":"132","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"Box19","page":"1","sequence":"20","shrinkable":"","stretch":"false","type":"Box","w":"91","wireframe_props":"","x":"932","y":"346","zindex":"1"},{"alt":"","anchor":"top-left","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"MSG_CAPTCHA_GENERATE_NEW","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"image_captcha_new_code","page":"1","path_type":"","sequence":"21","server_side":"","src":"..\u002fvisualweb\u002fimages\u002fgrid_refresh.png","srchover":"","tabindex":"-1","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"824","y":"363","zindex":"1"}]%>
<%/*Description:Login standard*/%>
<%/*ParamsRequest:g_codazi,login_failed,m_cFailedLoginReason*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.start_page_login_container {
}
.start_page_login_title_container {
  margin: auto;
}
.start_page_login_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:700px;
  background-color:transparent;
}
.start_page_login_portlet[Data-page="1"]{
  height:700px;
  width:100%;
}
.start_page_login_portlet > .bg_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:-12px;
  left:455px;
  width:320px;
  height:350px;
}
.start_page_login_portlet > .bg_ctrl {
}
.start_page_login_portlet > .bg_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet > .imgBar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:346px;
  left:1px;
  width:940px;
  height:132px;
}
.start_page_login_portlet > .imgBar_ctrl {
}
.start_page_login_portlet > .imgBar_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet > .lblUsername_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:363px;
  left:449px;
  width:97px;
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lblUsername_ctrl {
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lblUsername_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .lbl_Captcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:363px;
  left:753px;
  width:65px;
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lbl_Captcha_ctrl {
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lbl_Captcha_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .m_cUserName_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:379px;
  left:447px;
  width:150px;
  height:18px;
}
.start_page_login_portlet > .m_cUserName_ctrl {
}
.start_page_login_portlet > .m_cUserName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet > .lblPassword_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:363px;
  left:601px;
  width:105px;
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lblPassword_ctrl {
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lblPassword_ctrl {
  overflow:hidden;
  text-align:left;
}
.start_page_login_portlet > .m_cPassword_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:379px;
  left:599px;
  width:150px;
  height:18px;
}
.start_page_login_portlet > .m_cPassword_ctrl {
}
.start_page_login_portlet > .m_cPassword_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet > .lblCompany_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:452px;
  left:206px;
  width:82px;
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lblCompany_ctrl {
  height:auto;
  min-height:18px;
}
.start_page_login_portlet > .lblCompany_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.start_page_login_portlet > .g_codazi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:451px;
  left:290px;
  width:129px;
  height:19px;
}
.start_page_login_portlet > .Accedi_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:442px;
  left:439px;
  width:69px;
  height:29px;
}
.start_page_login_portlet > .Accedi_ctrl {
}
.start_page_login_portlet > .Accedi_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet > .errore_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:399px;
  left:447px;
  width:150px;
  height:auto;
  min-height:14px;
}
.start_page_login_portlet > .errore_ctrl {
  height:auto;
  min-height:14px;
}
.start_page_login_portlet > .errore_ctrl {
  overflow:hidden;
  font-size:7pt;
  font-weight:bold;
  color:#FFFFFF;
  text-align:left;
  background-color:#ff3300;
}
.start_page_login_portlet > .label18_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:447px;
  left:566px;
  width:229px;
  height:auto;
  min-height:15px;
}
.start_page_login_portlet > .label18_ctrl {
  height:auto;
  min-height:15px;
}
.start_page_login_portlet > .label18_ctrl {
  overflow:hidden;
  font-size:7pt;
  font-weight:normal;
  text-align:right;
  background-color:transparent;
}
.start_page_login_portlet > .m_cCaptcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:379px;
  left:751px;
  width:90px;
  height:18px;
}
.start_page_login_portlet > .m_cCaptcha_ctrl {
}
.start_page_login_portlet > .m_cCaptcha_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:8pt;
  width:100%;
  height:100%;
}
.start_page_login_portlet > .image_captcha_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:368px;
  left:843px;
  width:50px;
  height:40px;
}
.start_page_login_portlet > .image_captcha_ctrl {
}
.start_page_login_portlet > .image_captcha_ctrl > a, .start_page_login_portlet > .image_captcha_ctrl > a:hover{
  text-decoration:none;
}
.start_page_login_portlet > .image_captcha_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.start_page_login_portlet > .Box19_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:346px;
  left:932px;
  right:1px;
  width:auto;
  height:auto;
  min-height:132px;
  display:flex;
  flex-direction:column;
}
.start_page_login_portlet > .Box19_ctrl {
  height:132px;
}
.start_page_login_portlet > .Box19_ctrl > .box_content {
  height:100%;
}
.start_page_login_portlet > .Box19_ctrl {
  min-height:132px;
}
.start_page_login_portlet > .image_captcha_new_code_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:363px;
  left:824px;
  width:16px;
  height:16px;
}
.start_page_login_portlet > .image_captcha_new_code_ctrl {
}
.start_page_login_portlet > .image_captcha_new_code_ctrl > a, .start_page_login_portlet > .image_captcha_new_code_ctrl > a:hover{
  text-decoration:none;
}
.start_page_login_portlet > .image_captcha_new_code_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
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
 String def="[{\"h\":\"700\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"350\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"320\",\"x\":\"455\",\"y\":\"-12\",\"zindex\":\"0\"},{\"anchor\":\"top-left\",\"h\":\"132\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"940\",\"x\":\"1\",\"y\":\"346\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_USERNAME_STANDARD\",\"w\":\"97\",\"x\":\"449\",\"y\":\"363\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_CAPTCHA\",\"w\":\"65\",\"x\":\"753\",\"y\":\"363\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cUserName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"447\",\"y\":\"379\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblPassword\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_PASSWORD_STANDARD\",\"w\":\"105\",\"x\":\"601\",\"y\":\"363\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cPassword\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"150\",\"x\":\"599\",\"y\":\"379\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblCompany\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_COMPANY\",\"w\":\"82\",\"x\":\"206\",\"y\":\"452\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"name\":\"g_codazi\",\"page\":\"1\",\"textlist\":\"desazi\",\"type\":\"Combobox\",\"w\":\"129\",\"x\":\"290\",\"y\":\"451\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"29\",\"layout_steps_values\":{},\"name\":\"Accedi\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"69\",\"x\":\"439\",\"y\":\"442\",\"zindex\":\"2\"},{\"h\":\"30\",\"name\":\"dataobj_companies\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"2\",\"y\":\"-35\"},{\"h\":\"22\",\"name\":\"m_cURL\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"65\",\"x\":\"62\",\"y\":\"-29\"},{\"h\":\"22\",\"name\":\"m_cURLOnError\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"114\",\"x\":\"129\",\"y\":\"-29\"},{\"h\":\"22\",\"name\":\"m_cAction\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"79\",\"x\":\"245\",\"y\":\"-29\"},{\"h\":\"22\",\"name\":\"login_failed\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"68\",\"x\":\"326\",\"y\":\"-29\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"errore\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"errore\",\"w\":\"150\",\"x\":\"447\",\"y\":\"399\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"m_cFailedLoginReason\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"124\",\"x\":\"396\",\"y\":\"-29\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"&copy; 2017 Zucchetti SPA - Tutti i diritti riservati\",\"w\":\"229\",\"x\":\"566\",\"y\":\"447\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"m_cCaptcha\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"90\",\"x\":\"751\",\"y\":\"379\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"40\",\"layout_steps_values\":{},\"name\":\"image_captcha\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"50\",\"x\":\"843\",\"y\":\"368\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"132\",\"layout_steps_values\":{},\"name\":\"Box19\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"91\",\"x\":\"932\",\"y\":\"346\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"16\",\"layout_steps_values\":{},\"name\":\"image_captcha_new_code\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"824\",\"y\":\"363\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_login","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_login_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_login','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblUsername= "MSG_USERNAME_STANDARD";
String lbl_Captcha= "MSG_CAPTCHA";
String m_cUserName= "";
if(request.getAttribute("start_page_login_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblPassword= "MSG_PASSWORD_STANDARD";
String m_cPassword= "";
String lblCompany= "MSG_COMPANY";
String g_codazi=JSPLib.translateXSS(sp.getParameter("g_codazi",""));
String m_cURL="jsp/default.jsp";
String m_cURLOnError="jsp/index.jsp?login_failed=true";
String m_cAction="login";
boolean login_failed=sp.getParameter("login_failed",false);
String errore= "errore";
String m_cFailedLoginReason=JSPLib.translateXSS(sp.getParameter("m_cFailedLoginReason",""));
String label18= "&copy; 2017 Zucchetti SPA - Tutti i diritti riservati";
String m_cCaptcha= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_login_container'>
<form id='<%=idPortlet%>_form' name='<%=idPortlet%>_form' action='../servlet/cp_login' METHOD='POST' style='MARGIN:0' onsubmit='if(window.<%=idPortlet%>.this_OnSubmit)return window.<%=idPortlet%>.this_OnSubmit();'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_login_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_login','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_bg'>
<img id='<%=idPortlet%>_bg_img' class='image bg_ctrl' src="<%=sp.getThemedImage("../images/start_logo.jpg",pageContext.getServletContext())%>" >
</div>
<div id='<%=idPortlet%>_imgBar'>
<img id='<%=idPortlet%>_imgBar_img' class='image imgBar_ctrl' src="../<%=sp.getSkin()%>/images/login/black_bar.png" >
</div>
<span id='<%=idPortlet%>_lblUsername'  formid='<%=idPortlet%>' ps-name='lblUsername'    class='label lblUsername_ctrl'><div id='<%=idPortlet%>_lblUsernametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_USERNAME_STANDARD"))%></div></span>
<span id='<%=idPortlet%>_lbl_Captcha'  formid='<%=idPortlet%>' ps-name='lbl_Captcha'    class='label lbl_Captcha_ctrl'><div id='<%=idPortlet%>_lbl_Captchatbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_CAPTCHA"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cUserName_wrp'><input id='<%=idPortlet%>_m_cUserName' name='m_cUserName' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='m_cUserName' /></span>
<span id='<%=idPortlet%>_lblPassword'  formid='<%=idPortlet%>' ps-name='lblPassword'    class='label lblPassword_ctrl'><div id='<%=idPortlet%>_lblPasswordtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_PASSWORD_STANDARD"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cPassword_wrp'><input id='<%=idPortlet%>_m_cPassword' name='m_cPassword' type='password' class='textbox' tabindex='2' formid='<%=idPortlet%>' autocomplete='off' ps-name='m_cPassword' /></span>
<span id='<%=idPortlet%>_lblCompany'  formid='<%=idPortlet%>' ps-name='lblCompany'    class='label lblCompany_ctrl'><div id='<%=idPortlet%>_lblCompanytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_COMPANY"))%></div></span>
<select id='<%=idPortlet%>_g_codazi' name='g_codazi' class='combobox' style='font-family:verdana;' tabindex='4'></select>
<div id='<%=idPortlet%>_Accedi'><input type='image' id='<%=idPortlet%>_Accedi_img' class='image Accedi_ctrl' src="../<%=sp.getSkin()%>/images/login/login_enter.png" />
</div><input id='<%=idPortlet%>_m_cURL' name='m_cURL' type='hidden'/>
<input id='<%=idPortlet%>_m_cURLOnError' name='m_cURLOnError' type='hidden'/>
<input id='<%=idPortlet%>_m_cAction' name='m_cAction' type='hidden'/>
<input id='<%=idPortlet%>_login_failed' name='login_failed' type='hidden'/>
<span id='<%=idPortlet%>_errore'  formid='<%=idPortlet%>' ps-name='errore'    class='label errore_ctrl'><div id='<%=idPortlet%>_erroretbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("errore"))%></div></span>
<textarea id='<%=idPortlet%>_m_cFailedLoginReason' name='m_cFailedLoginReason' style='display:none'></textarea>
<span id='<%=idPortlet%>_label18'  formid='<%=idPortlet%>' ps-name='label18'    class='label label18_ctrl'><div id='<%=idPortlet%>_label18tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("&copy; 2017 Zucchetti SPA - Tutti i diritti riservati"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_m_cCaptcha_wrp'><input id='<%=idPortlet%>_m_cCaptcha' name='m_cCaptcha' type='text' class='textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='m_cCaptcha' /></span>
<div id='<%=idPortlet%>_image_captcha'><a id='<%=idPortlet%>_image_captchahref' href='javascript:void(0)' target='_self' tabindex='-1'><img id='<%=idPortlet%>_image_captcha_img' class='image image_captcha_ctrl' src="" border='0' ></a>
</div><div id='<%=idPortlet%>_Box19' class='Box19_ctrl SPSection_expanded Box_login' data-original-display='flex'><div id='<%=idPortlet%>_Box19_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_image_captcha_new_code'><a id='<%=idPortlet%>_image_captcha_new_codehref' href='javascript:void(0)' target='_self' tabindex='-1'><img id='<%=idPortlet%>_image_captcha_new_code_img' class='image image_captcha_new_code_ctrl' src="../visualweb/images/grid_refresh.png" border='0' ></a>
</div></div>
</form>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_login');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_login',["1024"],["700"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"700","title":"","layer":"false","npage":"1"}]);
this.bg=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image bg_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_bg","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":350,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"bg","page":1,"path_type":"themed","server_side":"","src":"<%=sp.getThemedImage("../images/start_logo.jpg",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":320,"x":455,"y":-12,"zindex":"0"});
this.imgBar=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image imgBar_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgBar","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":132,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imgBar","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002flogin\u002fblack_bar.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":940,"x":1,"y":346,"zindex":"1"});
this.lblUsername=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblUsername","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblUsername","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblUsername),false,true)%>","type":"Label","w":97,"x":449,"y":363,"zindex":"1"});
this.lbl_Captcha=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_Captcha","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_Captcha","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_Captcha),false,true)%>","type":"Label","w":65,"x":753,"y":363,"zindex":"1"});
this.m_cUserName=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cUserName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci username"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cUserName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cUserName,false,true)%>","w":150,"x":447,"y":379,"zerofilling":false,"zindex":"2","zoom":""});
this.lblPassword=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblPassword","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblPassword","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblPassword),false,true)%>","type":"Label","w":105,"x":601,"y":363,"zindex":"1"});
this.m_cPassword=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cPassword","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Inserisci password"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cPassword","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cPassword,false,true)%>","w":150,"x":599,"y":379,"zerofilling":false,"zindex":"2","zoom":""});
this.lblCompany=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCompany","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCompany","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblCompany),false,true)%>","type":"Label","w":82,"x":206,"y":452,"zindex":"1"});
this.g_codazi=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_g_codazi","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"font":"verdana","font_size":"","h":19,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=g_codazi%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"g_codazi","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"4","textlist":"desazi","type":"Combobox","typevar":"character","valuelist":"codazi","visible":true,"w":129,"x":290,"y":451,"zindex":"1"});
this.Accedi=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image Accedi_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Accedi","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":29,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_MENU_LOGIN_CLICK"),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"Accedi","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002flogin\u002flogin_enter.png","srchover":"..\u002f<%=sp.getSkin()%>\u002fimages\u002flogin\u002flogin_enter_hover.png","tabindex":"5","target":"","type":"Image","type_submit":"true","w":69,"x":439,"y":442,"zindex":"2"});
this.dataobj_companies=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"start_login_companies","cmdHash":"<%=JSPLib.cmdHash("start_login_companies",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_companies","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_companies","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":30,"x":2,"y":-35});
this.m_cURL=new ZtVWeb._VC(this,'m_cURL','<%=idPortlet%>_m_cURL','character','<%=JSPLib.ToJSValue(m_cURL,false,true)%>',false,false);
this.m_cURLOnError=new ZtVWeb._VC(this,'m_cURLOnError','<%=idPortlet%>_m_cURLOnError','character','<%=JSPLib.ToJSValue(m_cURLOnError,false,true)%>',false,false);
this.m_cAction=new ZtVWeb._VC(this,'m_cAction','<%=idPortlet%>_m_cAction','character','<%=JSPLib.ToJSValue(m_cAction,false,true)%>',false,false);
this.login_failed=new ZtVWeb._VC(this,'login_failed','<%=idPortlet%>_login_failed','logic',<%=login_failed%>,false,false);
this.errore=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_errore","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"#FFFFFF","font_size":"7pt","font_weight":"bold","fontpct":"","h":14,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"errore","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(errore),false,true)%>","type":"Label","w":150,"x":447,"y":399,"zindex":"1"});
this.m_cFailedLoginReason=new ZtVWeb._VC(this,'m_cFailedLoginReason','<%=idPortlet%>_m_cFailedLoginReason','memo','<%=JSPLib.ToJSValue(m_cFailedLoginReason,false,true)%>',false,false);
this.label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"7pt","font_weight":"normal","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(label18),false,true)%>","type":"Label","w":229,"x":566,"y":447,"zindex":"1"});
this.m_cCaptcha=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_m_cCaptcha","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":18,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"m_cCaptcha","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(m_cCaptcha,false,true)%>","w":90,"x":751,"y":379,"zerofilling":false,"zindex":"1","zoom":""});
this.image_captcha=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image_captcha_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_captcha","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":40,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_CAPTCHA_GENERATE_NEW"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image_captcha","page":1,"path_type":"","server_side":"","src":"","srchover":"","tabindex":"-1","target":"_self","type":"Image","type_submit":"false","w":50,"x":843,"y":368,"zindex":"1"});
this.Box19=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"Box_login","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box19","groupName":"","h":132,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box19","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":91,"x":932,"y":346,"zindex":"1"});
this.image_captcha_new_code=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image image_captcha_new_code_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_captcha_new_code","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_CAPTCHA_GENERATE_NEW"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"image_captcha_new_code","page":1,"path_type":"","server_side":"","src":"..\u002fvisualweb\u002fimages\u002fgrid_refresh.png","srchover":"","tabindex":"-1","target":"_self","type":"Image","type_submit":"false","w":16,"x":824,"y":363,"zindex":"1"});
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
<%request.setAttribute("start_page_login_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.start_page_login_Static=function(){
if(typeof image_captcha_Click !='undefined')this.image_captcha_Click=image_captcha_Click;
if(typeof image_captcha_new_code_Click !='undefined')this.image_captcha_new_code_Click=image_captcha_new_code_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_companies.addRowConsumer(this.g_codazi);

<%if(!sp.hasAdministeredUsers()){%>
  window.location="../jsp/default.jsp";
<%}%>
this.dataobj_companies.Query();
if(this.dataobj_companies.isEmpty()){
  this.lblCompany.Hide();
  this.g_codazi.Hide();
}
if(this.dataobj_companies.GetQueryCount()=="1"){
  this.g_codazi.empty_value=false;
}
function image_captcha_Click(){
  this.image_captcha.Value('../servlet/SPImageCaptchaServlet?a='+Math.random());
}
function image_captcha_new_code_Click(){
  this.image_captcha_Click();
}
if(this.m_cFailedLoginReason.Value())
  this.errore.Value(this.m_cFailedLoginReason.Value());
else
  this.errore.Hide();
<%if(com.zucchetti.sitepainter.Library.captchaMustBeShown(request)){
//da esplorare la possibilita' di chiedere captcha di una certa dimensione piuttosto che averla
//fissa lato server
%>
this.image_captcha.Ctrl.style.width='<%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageWidth/2%>px';
this.image_captcha.Ctrl.style.height='<%=com.zucchetti.sitepainter.ImageCaptchaEngine.imageHeight/2%>px';
this.image_captcha.Value('../servlet/SPImageCaptchaServlet');
<%}else{%>
this.m_cCaptcha.Hide();
this.image_captcha.Hide();
this.lbl_Captcha.Hide();
this.image_captcha_new_code.Hide();
<%}%>

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_login_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.dataobj_companies.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_login',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_login');
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
sp.endPage("start_page_login");
}%>
<%! public String getJSPUID() { return "4045530878"; } %>