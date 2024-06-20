<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var ua = navigator.userAgent\n  , device = \"\u003c%=JSPLib.GetUserAgent(request)%\u003e\"\n  , logged = \u003c%=sp.isLogged()%\u003e\n  , inIframe = self.location.href!=parent.location.href\n  , skin = \"\u003c%=sp.getSkin()%\u003e\"\n  , url = \"\u003c%=JSPLib.SPWebRootURL(request)%\u003e\u002fspofflineapp\u002findex_\"+this.OAAPPPLAN.Value()+\".jsp\"\n  , urlonline= \"\u003c%=JSPLib.SPWebRootURL(request)%\u003e\u002f\"+this.OAAPPPLAN.Value()\n  , radius = '3px'\n;\n\nvar item_applist;\nvar os='\u003c%=JSPLib.GetMobileOperationSystem(request)%\u003e';\nvar apkUrl;\n\nthis.Ctrl.style.borderRadius = radius;\nthis.Box11.Ctrl.style.borderTopLeftRadius = radius;\nthis.Box11.Ctrl.style.borderTopRightRadius = radius;\nthis.lbl_title.Ctrl.style.overflow = 'hidden';\nthis.lbl_title.Ctrl.style.textOverflow = 'ellipsis';\nthis.lbl_title.Ctrl.style.verticalAlign = 'middle';\nthis.lbl_title.Ctrl.style.lineHeight = this.lbl_title.minheight + 'px';\n\n\nif('offline'==\"\u003c%=JSPLib.ToJSValue(modstore)%\u003e\"){\n \tapkUrl=\"\u003c%=JSPLib.SPWebRootURL(request)%\u003e\u002fspofflineapp\u002f\"+this.OAAPPPLAN.Value()+\".apk\";   \n}else{\n  apkUrl=\"\u003c%=JSPLib.SPWebRootURL(request)%\u003e\u002f\"+this.OAAPPPLAN.Value()+\".apk\";\n}\n\nthis.height_top.Value(ZtVWeb.getPortlet('spas_pheaderstore').height);\n\nfunction openWith(){\n  var portletDetail='', pdetail= '';\n  portletDetail='spas_pdetail_app';\n  pdetail=  ZtVWeb.getPortlet(portletDetail);\n  if(!pdetail){\n    var div=document.createElement('div');\n    div.id='divDetail';\n    document.body.appendChild(div);\n    ZtVWeb.Include( '..\u002fjsp\u002f'+portletDetail+'_portlet.jsp', div );\n    pdetail=  ZtVWeb.getPortlet(portletDetail);\n    pdetail.setItem_applist(this);\n  }\n  if(this.modstore.Value()=='online'){\n    url=urlonline;\n  }\n  \u002f\u002fcentra\n  div=document.getElementById('divDetail');\n  div.style.position='absolute';\n  var scroll=document.body.scrollTop;\n  div.style.top=(parseInt(this.height_top.Value())+20+scroll)+'px';\n  div.style.left=((window.innerWidth-pdetail.width)\u002f2)+'px';\n  div.style.zIndex='10';\n  if(this.OAAPPREQREG.Value()==0){  \n    pdetail.setParameters(this.OAAPPTITLE.Value(),this.OADESCRI.Value(),this.OAAPPLOGO.Value(),this.OAAPPACCESSMODE.Value(),url,apkUrl,this.modstore.Value(),this.OA__CODE.Value(),1);\n  } else {\n    pdetail.setParameters(this.OAAPPTITLE.Value(),this.OADESCRI.Value(),this.OAAPPLOGO.Value(),this.OAAPPACCESSMODE.Value(),url,apkUrl,this.modstore.Value(),this.OA__CODE.Value(),2);\n  }  \n  this.showDetail();\n}\n\nfunction showDetail(){\n  var div=document.getElementById('divDetail');\n  var portletDetail='spas_pdetail_app';\n  var pdetail=  ZtVWeb.getPortlet(portletDetail);\n  if(device=='SMARTPHONE'){\n    \u002f\u002f portlet centrato\n    div.style.left=\"\";\n    div.style.width=\"100%\";\n    pdetail.Ctrl.style['max-width']=\"95%\";\n    pdetail.Ctrl.style.margin=\"auto\";\n    div.addEventListener(\"touchmove\", this.disableScroll);\n    div.addEventListener(\"touchmove\", this.disableScroll);\n  }else{\n    document.documentElement.style.overflow='hidden';\n  }\n  div.style.display='';\n  this.hideStore();\n}\n\nfunction disableScroll(event){\n  event.preventDefault()\n}\n\nfunction hideDetail(){\n  var div=document.getElementById('divDetail');\n  div.style.display='none';\n\tif(device!='SMARTPHONE'){\n    document.documentElement.style.overflow='';\n  }\n  this.showStore();\n}\n\nfunction hideStore(){\n  var scroll=document.body.scrollTop;\n  var div=document.getElementById('divHide');\n  div.style.top=scroll+'px';\n  div.style.display='';\n}\n\nfunction showStore(){\n\tvar div=document.getElementById('divHide');\n  div.style.display='none';\n}\n\nfunction createOpacity(){\n  var div=document.getElementById('divHide');\n  if (!div){\n    div=document.createElement('div');\n    div.id='divHide';\n    div.style.position='absolute';\n    div.style.left='0px';\n    div.style.zIndex='5';\n    div.style.width='100%';\n    div.style.height='100%';\n    div.style.background='rgba(20, 20, 20, .5)'; \n    document.documentElement.appendChild(div);\n    div.style.display='none';\n    var contexThis=this;\n    div.addEventListener(\"click\", function(){\n      if(document.getElementById('divQrDetail')){\t\t\t\t\t\t\t\t\t\t\t\t\t\u002f\u002fse esiste QR\n        if(document.getElementById('divQrDetail').style.display=='none'){ \t\t\u002f\u002fse qr ? none\n          contexThis.hideDetail();\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\u002f\u002fchiudo dettagli\n        }else{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\u002f\u002faltrimenti qr ? visibile\n          ZtVWeb.getPortlet('spas_pdetail_app').hideQrDetail();\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\u002f\u002fchiudo qr\n        }\n      }else{ \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\u002f\u002faltrimenti non esiste qr\n        contexThis.hideDetail();\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\u002f\u002fchiudo dettagli\n      }\n    });\n  }\n}\n\nfunction this_Loaded(){\n  this.logo.Value(this.OAAPPLOGO.Value());\n  this.lbl_title.Value(this.OAAPPTITLE.Value() || this.OAAPPPLAN.Value());\n  this.lbl_descr.Value(this.OADESCRI.Value());\n  this.lbl_descr.Ctrltbl.style.verticalAlign = \"middle\";\n  this.lbl_descr.Ctrltbl.style.fontStyle = \"italic\";\n  this.createOpacity();\n  this.Ctrl.addEventListener('click', function(){\n    this.openWith();\n  }.bind(this));\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#EFF0F2","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"spas_item_applist","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"image\",\"class_name\":\"image\",\"selector\":\".image\",\"id\":\"form\",\"code\":\"\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"cursor: pointer;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"spas_item_applist\",\"selector\":\".spas_item_applist\",\"id\":\"form\",\"code\":\".spas_item_applist {\\n  cursor: pointer;\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"170","hsl":"","htmlcode":"{{ Box11 }}\n{{ logo }}\n{{ OADESCRI }}\n{{ OA__CODE }}\n{{ OAAPPLOGO }}\n{{ OAAPPPLAN }}\n{{ OAAPPTITLE }}\n{{ lbl_title }}\n{{ lbl_descr }}\n{{ OAAPPACCESSMODE }}\n{{ modstore }}\n{{ height_top }}\n{{ OAAPPREQREG }}\n{{ OAAPPURLREG }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"315","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","bg_color":"#DCDCDC","border_color":"","border_weight":"0","class_Css":"box","create_undercond":"","h":"53","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"Box11","page":"1","sequence":"1","shrinkable":"","stretch":"false","target":"","type":"Box","w":"315","wireframe_props":"","x":"0","y":"0","zindex":"0"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"94","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0);","img_type":"default","keep_proportions":"true","layout_steps_values":"{}","name":"logo","page":"1","path_type":"","sequence":"2","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"94","wireframe_props":"","x":"12","y":"65","zindex":"1"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OADESCRI","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"607","y":"26"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OA__CODE","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"606","y":"-4"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OAAPPLOGO","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"607","y":"59"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OAAPPPLAN","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"607","y":"92"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OAAPPTITLE","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"607","y":"125"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label_title","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"16px","font_weight":"bold","fontpct":"","h":"46","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_title","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"lbl_title","w":"306","wireframe_props":"align,value,n_col","x":"5","y":"3","zindex":"1"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label_description","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"#919191","font_size":"","font_weight":"normal","fontpct":"","h":"97","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lbl_descr","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"lbl_descr","w":"193","wireframe_props":"align,value,n_col","x":"118","y":"69","zindex":"1"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request:OAAPPACCESSMODE:browser_and_hybrid","name":"OAAPPACCESSMODE","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"607","y":"158"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"modstore","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"607","y":"224"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"height_top","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"607","y":"191"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OAAPPREQREG","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"numeric","w":"130","x":"607","y":"257"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"OAAPPURLREG","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"607","y":"290"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:OADESCRI,OA__CODE,OAAPPLOGO,OAAPPPLAN,OAAPPTITLE,OAAPPACCESSMODE,modstore,OAAPPREQREG,OAAPPURLREG*/%>
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
.spas_item_applist_container .spas_item_applist{  cursor: pointer;
}
.spas_item_applist_container {
}
.spas_item_applist_portlet{
  position:relative;
  width:100%;
  min-width:315px;
  height:170px;
  background-color:#EFF0F2;
}
.spas_item_applist_portlet[Data-page="1"]{
  height:170px;
  width:100%;
}
.spas_item_applist_portlet > .Box11_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:53px;
  display:flex;
  flex-direction:column;
}
.spas_item_applist_portlet > .Box11_ctrl {
  height:53px;
}
.spas_item_applist_portlet > .Box11_ctrl > .box_content {
  height:100%;
}
.spas_item_applist_portlet > .Box11_ctrl {
  min-height:53px;
  background-color:#DCDCDC;
  border-width:0px;
  border-style:solid;
}
.spas_item_applist_portlet > .logo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:12px;
  width:94px;
  height:94px;
}
.spas_item_applist_portlet > .logo_ctrl {
}
.spas_item_applist_portlet > .logo_ctrl > a, .spas_item_applist_portlet > .logo_ctrl > a:hover{
  text-decoration:none;
}
.spas_item_applist_portlet > .logo_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spas_item_applist_portlet > .lbl_title_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:5px;
  right:4px;
  width:auto;
  height:auto;
  min-height:46px;
}
.spas_item_applist_portlet > .lbl_title_ctrl {
  height:auto;
  min-height:46px;
}
.spas_item_applist_portlet > .lbl_title_ctrl {
  overflow:hidden;
  font-size:16px;
  font-weight:bold;
  text-align:left;
}
.spas_item_applist_portlet > .lbl_descr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:69px;
  left:118px;
  right:4px;
  width:auto;
  height:auto;
  min-height:97px;
}
.spas_item_applist_portlet > .lbl_descr_ctrl {
  height:auto;
  min-height:97px;
}
.spas_item_applist_portlet > .lbl_descr_ctrl {
  overflow:hidden;
  font-weight:normal;
  color:#919191;
  text-align:left;
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
 String def="[{\"h\":\"170\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"315\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"53\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"315\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"94\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"94\",\"x\":\"12\",\"y\":\"65\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"607\",\"y\":\"26\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"606\",\"y\":\"-4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"607\",\"y\":\"59\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"607\",\"y\":\"92\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"607\",\"y\":\"125\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"46\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"lbl_title\",\"w\":\"306\",\"x\":\"5\",\"y\":\"3\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"97\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"lbl_descr\",\"w\":\"193\",\"x\":\"118\",\"y\":\"69\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"607\",\"y\":\"158\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"607\",\"y\":\"224\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"607\",\"y\":\"191\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"607\",\"y\":\"257\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"607\",\"y\":\"290\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_item_applist","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_item_applist_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spas_item_applist','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String OADESCRI=JSPLib.translateXSS(sp.getParameter("OADESCRI",""));
String OA__CODE=JSPLib.translateXSS(sp.getParameter("OA__CODE",""));
String OAAPPLOGO=JSPLib.translateXSS(sp.getParameter("OAAPPLOGO",""));
String OAAPPPLAN=JSPLib.translateXSS(sp.getParameter("OAAPPPLAN",""));
String OAAPPTITLE=JSPLib.translateXSS(sp.getParameter("OAAPPTITLE",""));
String lbl_title= "lbl_title";
String lbl_descr= "lbl_descr";
String OAAPPACCESSMODE=JSPLib.translateXSS(sp.getParameter("OAAPPACCESSMODE","browser_and_hybrid"));
String modstore=JSPLib.translateXSS(sp.getParameter("modstore",""));
String height_top= "";
double OAAPPREQREG=sp.getParameter("OAAPPREQREG",0);
String OAAPPURLREG=JSPLib.translateXSS(sp.getParameter("OAAPPURLREG",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spas_item_applist_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spas_item_applist_portlet spas_item_applist' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spas_item_applist','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Box11' class='Box11_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box11_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_logo'><a id='<%=idPortlet%>_logohref' href='javascript:void(0);' target='_self'><img id='<%=idPortlet%>_logo_img' class='image logo_ctrl' src="" border='0' ></a>
</div><span id='<%=idPortlet%>_lbl_title'  formid='<%=idPortlet%>' ps-name='lbl_title'    class='label_title lbl_title_ctrl'><div id='<%=idPortlet%>_lbl_titletbl' style='width:100%;'><%=JSPLib.ToHTML("lbl_title")%></div></span>
<span id='<%=idPortlet%>_lbl_descr'  formid='<%=idPortlet%>' ps-name='lbl_descr'    class='label_description lbl_descr_ctrl'><div id='<%=idPortlet%>_lbl_descrtbl' style='width:100%;'><%=JSPLib.ToHTML("lbl_descr")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spas_item_applist');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spas_item_applist',["315"],["170"],'spas_item_applist',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"315","h":"170","title":"","layer":"false","npage":"1"}]);
this.Box11=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"#DCDCDC","border_color":"","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box11","groupName":"","h":53,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box11","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":315,"x":0,"y":0,"zindex":"0"});
this.logo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image logo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_logo","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":94,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0);","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"logo","page":1,"path_type":"","server_side":"","src":"","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":94,"x":12,"y":65,"zindex":"1"});
this.OADESCRI=new ZtVWeb._VC(this,'OADESCRI',null,'character','<%=JSPLib.ToJSValue(OADESCRI,false,true)%>',false,false);
this.OA__CODE=new ZtVWeb._VC(this,'OA__CODE',null,'character','<%=JSPLib.ToJSValue(OA__CODE,false,true)%>',false,false);
this.OAAPPLOGO=new ZtVWeb._VC(this,'OAAPPLOGO',null,'character','<%=JSPLib.ToJSValue(OAAPPLOGO,false,true)%>',false,false);
this.OAAPPPLAN=new ZtVWeb._VC(this,'OAAPPPLAN',null,'character','<%=JSPLib.ToJSValue(OAAPPPLAN,false,true)%>',false,false);
this.OAAPPTITLE=new ZtVWeb._VC(this,'OAAPPTITLE',null,'character','<%=JSPLib.ToJSValue(OAAPPTITLE,false,true)%>',false,false);
this.lbl_title=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_title","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_title","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"16px","font_weight":"bold","fontpct":"","h":46,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_title","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lbl_title,false,true)%>","type":"Label","w":306,"x":5,"y":3,"zindex":"1"});
this.lbl_descr=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label_description","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_descr","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"#919191","font_size":"","font_weight":"normal","fontpct":"","h":97,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_descr","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lbl_descr,false,true)%>","type":"Label","w":193,"x":118,"y":69,"zindex":"1"});
this.OAAPPACCESSMODE=new ZtVWeb._VC(this,'OAAPPACCESSMODE',null,'character','<%=JSPLib.ToJSValue(OAAPPACCESSMODE,false,true)%>',false,false);
this.modstore=new ZtVWeb._VC(this,'modstore',null,'character','<%=JSPLib.ToJSValue(modstore,false,true)%>',false,false);
this.height_top=new ZtVWeb._VC(this,'height_top',null,'character','<%=JSPLib.ToJSValue(height_top,false,true)%>',false,false);
this.OAAPPREQREG=new ZtVWeb._VC(this,'OAAPPREQREG',null,'numeric',<%=OAAPPREQREG%>,false,false);
this.OAAPPURLREG=new ZtVWeb._VC(this,'OAAPPURLREG',null,'character','<%=JSPLib.ToJSValue(OAAPPURLREG,false,true)%>',false,false);
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
<%request.setAttribute("spas_item_applist_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spas_item_applist_Static=function(){
if(typeof openWith !='undefined')this.openWith=openWith;
if(typeof showDetail !='undefined')this.showDetail=showDetail;
if(typeof disableScroll !='undefined')this.disableScroll=disableScroll;
if(typeof hideDetail !='undefined')this.hideDetail=hideDetail;
if(typeof hideStore !='undefined')this.hideStore=hideStore;
if(typeof showStore !='undefined')this.showStore=showStore;
if(typeof createOpacity !='undefined')this.createOpacity=createOpacity;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var ua = navigator.userAgent
  , device = "<%=JSPLib.GetUserAgent(request)%>"
  , logged = <%=sp.isLogged()%>
  , inIframe = self.location.href!=parent.location.href
  , skin = "<%=sp.getSkin()%>"
  , url = "<%=JSPLib.SPWebRootURL(request)%>/spofflineapp/index_"+this.OAAPPPLAN.Value()+".jsp"
  , urlonline= "<%=JSPLib.SPWebRootURL(request)%>/"+this.OAAPPPLAN.Value()
  , radius = '3px'
;
var item_applist;
var os='<%=JSPLib.GetMobileOperationSystem(request)%>';
var apkUrl;
this.Ctrl.style.borderRadius = radius;
this.Box11.Ctrl.style.borderTopLeftRadius = radius;
this.Box11.Ctrl.style.borderTopRightRadius = radius;
this.lbl_title.Ctrl.style.overflow = 'hidden';
this.lbl_title.Ctrl.style.textOverflow = 'ellipsis';
this.lbl_title.Ctrl.style.verticalAlign = 'middle';
this.lbl_title.Ctrl.style.lineHeight = this.lbl_title.minheight + 'px';
if('offline'=="<%=JSPLib.ToJSValue(modstore)%>"){
 	apkUrl="<%=JSPLib.SPWebRootURL(request)%>/spofflineapp/"+this.OAAPPPLAN.Value()+".apk";   
}else{
  apkUrl="<%=JSPLib.SPWebRootURL(request)%>/"+this.OAAPPPLAN.Value()+".apk";
}
this.height_top.Value(ZtVWeb.getPortlet('spas_pheaderstore').height);
function openWith(){
  var portletDetail='', pdetail= '';
  portletDetail='spas_pdetail_app';
  pdetail=  ZtVWeb.getPortlet(portletDetail);
  if(!pdetail){
    var div=document.createElement('div');
    div.id='divDetail';
    document.body.appendChild(div);
    ZtVWeb.Include( '../jsp/'+portletDetail+'_portlet.jsp', div );
    pdetail=  ZtVWeb.getPortlet(portletDetail);
    pdetail.setItem_applist(this);
  }
  if(this.modstore.Value()=='online'){
    url=urlonline;
  }
  //centra
  div=document.getElementById('divDetail');
  div.style.position='absolute';
  var scroll=document.body.scrollTop;
  div.style.top=(parseInt(this.height_top.Value())+20+scroll)+'px';
  div.style.left=((window.innerWidth-pdetail.width)/2)+'px';
  div.style.zIndex='10';
  if(this.OAAPPREQREG.Value()==0){  
    pdetail.setParameters(this.OAAPPTITLE.Value(),this.OADESCRI.Value(),this.OAAPPLOGO.Value(),this.OAAPPACCESSMODE.Value(),url,apkUrl,this.modstore.Value(),this.OA__CODE.Value(),1);
  } else {
    pdetail.setParameters(this.OAAPPTITLE.Value(),this.OADESCRI.Value(),this.OAAPPLOGO.Value(),this.OAAPPACCESSMODE.Value(),url,apkUrl,this.modstore.Value(),this.OA__CODE.Value(),2);
  }  
  this.showDetail();
}
function showDetail(){
  var div=document.getElementById('divDetail');
  var portletDetail='spas_pdetail_app';
  var pdetail=  ZtVWeb.getPortlet(portletDetail);
  if(device=='SMARTPHONE'){
    // portlet centrato
    div.style.left="";
    div.style.width="100%";
    pdetail.Ctrl.style['max-width']="95%";
    pdetail.Ctrl.style.margin="auto";
    div.addEventListener("touchmove", this.disableScroll);
    div.addEventListener("touchmove", this.disableScroll);
  }else{
    document.documentElement.style.overflow='hidden';
  }
  div.style.display='';
  this.hideStore();
}
function disableScroll(event){
  event.preventDefault()
}
function hideDetail(){
  var div=document.getElementById('divDetail');
  div.style.display='none';
	if(device!='SMARTPHONE'){
    document.documentElement.style.overflow='';
  }
  this.showStore();
}
function hideStore(){
  var scroll=document.body.scrollTop;
  var div=document.getElementById('divHide');
  div.style.top=scroll+'px';
  div.style.display='';
}
function showStore(){
	var div=document.getElementById('divHide');
  div.style.display='none';
}
function createOpacity(){
  var div=document.getElementById('divHide');
  if (!div){
    div=document.createElement('div');
    div.id='divHide';
    div.style.position='absolute';
    div.style.left='0px';
    div.style.zIndex='5';
    div.style.width='100%';
    div.style.height='100%';
    div.style.background='rgba(20, 20, 20, .5)'; 
    document.documentElement.appendChild(div);
    div.style.display='none';
    var contexThis=this;
    div.addEventListener("click", function(){
      if(document.getElementById('divQrDetail')){													//se esiste QR
        if(document.getElementById('divQrDetail').style.display=='none'){ 		//se qr ? none
          contexThis.hideDetail();																								//chiudo dettagli
        }else{																																//altrimenti qr ? visibile
          ZtVWeb.getPortlet('spas_pdetail_app').hideQrDetail();																								//chiudo qr
        }
      }else{ 																															//altrimenti non esiste qr
        contexThis.hideDetail();																							//chiudo dettagli
      }
    });
  }
}
function this_Loaded(){
  this.logo.Value(this.OAAPPLOGO.Value());
  this.lbl_title.Value(this.OAAPPTITLE.Value() || this.OAAPPPLAN.Value());
  this.lbl_descr.Value(this.OADESCRI.Value());
  this.lbl_descr.Ctrltbl.style.verticalAlign = "middle";
  this.lbl_descr.Ctrltbl.style.fontStyle = "italic";
  this.createOpacity();
  this.Ctrl.addEventListener('click', function(){
    this.openWith();
  }.bind(this));
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spas_item_applist_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','spas_item_applist',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spas_item_applist');
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
sp.endPage("spas_item_applist");
}%>
<%! public String getJSPUID() { return "2696022433"; } %>