<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u002f\u002fSetto le variabili utili per la costruzione del calendario\nvar zero = '';\nvar mese = new Array ( 'Gennaio' , 'Febbraio','Marzo','Aprile','Maggio','Giugno','Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre');\nvar giorno = new Array ('Domenica','Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato');\n\n\ni= new Date(); dd=i.getDay(); gg=i.getDate(); mm=i.getMonth(); aa=i.getFullYear();\n\nif (gg \u003c 10) { zero = '0' } else { zero = '' };\n\n\u002f\u002f Vml\nvar vmlClock = \"\";\nvmlClock += \"\u003cxml:namespace ns=\\\"urn:schemas-microsoft-com:vml\\\" prefix=\\\"vml\\\" \u002f\u003e\u003c?import namespace=\\\"vml\\\" implementation=\\\"#default#VML\\\" ?\u003e\";\nvmlClock += \"\u003cvml:group id=\\\"seconds\\\" style=\\\"width:80px;height:80px;position:absolute;left:20px;top:20px;\\\" coordorigin=\\\"0 0\\\" coordsize=\\\"80 80\\\"\u003e\u003cvml:line from=\\\"40,40\\\" to=\\\"40,0\\\"\u003e\u003cvml:stroke weight=\\\"1px\\\" endcap=\\\"round\\\" color=\\\"#cc0000\\\"\u002f\u003e\u003c\u002fvml:line\u003e\u003c\u002fvml:group\u003e\";\nvmlClock += \"\u003cvml:group id=\\\"minutes\\\" style=\\\"width:80px;height:80px;position:absolute;left:20px;top:20px;\\\" coordorigin=\\\"0 0\\\" coordsize=\\\"80 80\\\"\u003e\u003cvml:line from=\\\"40,40\\\" to=\\\"40,0\\\"\u003e\u003cvml:stroke weight=\\\"3px\\\" endcap=\\\"round\\\" color=\\\"#3a484b\\\"\u002f\u003e\u003c\u002fvml:line\u003e\u003c\u002fvml:group\u003e\";\nvmlClock += \"\u003cvml:group id=\\\"hours\\\" style=\\\"width:80px;height:80px;position:absolute;left:20px;top:20px;\\\" coordorigin=\\\"0 0\\\" coordsize=\\\"80 80\\\"\u003e\u003cvml:line from=\\\"40,40\\\" to=\\\"40,15\\\"\u003e\u003cvml:stroke weight=\\\"5px\\\" endcap=\\\"round\\\" color=\\\"#3a484b\\\"\u002f\u003e\u003c\u002fvml:line\u003e\u003c\u002fvml:group\u003e\";\nvmlClock += \"\u003cvml:oval fillcolor=\\\"#3a484b\\\" style=\\\"width:10px;height:10px;position:absolute;left:53px;top:53px;\\\" strokecolor=\\\"#3a484b\\\" strokeweight=\\\"1px\\\" \u002f\u003e\";\n\n\u002f\u002f Canvas\nvar canvasClock = \"\u003ccanvas id=\\\"canvasClock\\\" width=\\\"80\\\" height=\\\"80\\\" style=\\\"position:absolute;left:20px;top:20px;\\\"\u003e\u003c\u002fcanvas\u003e\";\n\n\u002f\u002f Update vml clock\nfunction vmlClock(){\n\n  var now = new Date();\n  var sec = now.getSeconds();\n  var min = now.getMinutes();\n  var hr  = now.getHours();\n  hr = hr\u003e=12 ? hr-12 : hr;\n\n  var seconds = document.getElementById(\"seconds\");\n  if(seconds) seconds.rotation = sec * 6;\n\n  var minutes= document.getElementById(\"minutes\");\n  if(minutes) minutes.rotation = min * 6;\n\n  var hours= document.getElementById(\"hours\");\n  if(hours) hours.rotation = hr * 30 + min\u002f2;\n}\n\n\u002f\u002f Update canvas clock\nfunction canvasClock() {\n\n  var now = new Date();\n  var ctx = document.getElementById(\"canvasClock\").getContext('2d');\n  ctx.save();\n  ctx.clearRect(0,0,80,80);\n  ctx.translate(40,40);\n  ctx.scale(0.4,0.4);\n  ctx.rotate(-Math.PI\u002f2);\n  ctx.strokeStyle = \"#3a484b\";\n  ctx.fillStyle = \"white\";\n  ctx.lineWidth = 6;\n  ctx.lineCap = \"round\";\n\n  var sec = now.getSeconds();\n  var min = now.getMinutes();\n  var hr  = now.getHours();\n  hr = hr\u003e=12 ? hr-12 : hr;\n\n  ctx.fillStyle = \"#3a484b\";\n\n  \u002f\u002f write Hours\n  ctx.save();\n  ctx.rotate( hr*(Math.PI\u002f6) + (Math.PI\u002f360)*min + (Math.PI\u002f21600)*sec )\n  ctx.lineWidth = 12;\n  ctx.beginPath();\n  ctx.moveTo(0,0);\n  ctx.lineTo(55,0);\n  ctx.stroke();\n  ctx.restore();\n\n  \u002f\u002f write Minutes\n  ctx.save();\n  ctx.rotate( (Math.PI\u002f30)*min + (Math.PI\u002f1800)*sec )\n  ctx.lineWidth = 8;\n  ctx.beginPath();\n  ctx.moveTo(0,0);\n  ctx.lineTo(95,0);\n  ctx.stroke();\n  ctx.restore();\n\n  \u002f\u002f Write seconds\n  ctx.save();\n  ctx.rotate(sec * Math.PI\u002f30);\n  ctx.strokeStyle = '#cc0000';\n  ctx.lineWidth = 2;\n  ctx.beginPath();\n  ctx.moveTo(0,0);\n  ctx.lineTo(110,0);\n  ctx.stroke();\n  ctx.restore();\n\n  \u002f\u002f Write pivot\n  ctx.beginPath();\n  ctx.lineWidth = 2;\n  ctx.strokeStyle = '#3a484b';\n  ctx.arc(0,0,10,0,Math.PI*2,true);\n  ctx.fill();\n  ctx.restore();\n\n  \u002f\u002f Erase old\n  ctx.beginPath();\n  ctx.lineWidth = 14;\n  ctx.strokeStyle = '#fff';\n  ctx.arc(0,0,120,0,Math.PI*2,true);\n  ctx.stroke();\n  ctx.restore();\n}\n\n\nfunction this_Loaded(){\n\n  \u002f\u002f Se browser non supporta canvas\n  if(!document.createElement(\"canvas\").getContext) {\n    this.clockBox.Ctrl.innerHTML = vmlClock;\n    setInterval(this.formid+'.vmlClock()',1000);\n  }else{\n    this.clockBox.Ctrl.innerHTML = canvasClock;\n    setInterval(this.formid+'.canvasClock()',1000);\n  }\n}\n\n\nvar _this = this;\n\n\nfunction upclock(){\n   var dte = new Date();\n   var hrs = dte.getHours();\n   var min = dte.getMinutes();\n   var sec = dte.getSeconds();\n   var col = ':';\n   var spc = ' ';\n   if (hrs == 0) hrs=12;\n   if (hrs\u003c=9) hrs=\"0\"+hrs;\n   if (min\u003c=9) min=\"0\"+min;\n   if (sec\u003c=9) sec=\"0\"+sec;\n   this.label15.Value(hrs+'.'+min+'.'+sec+spc);\n}\n\n\nvar zero = '';\nvar mese = new Array ( '\u003c%=JSPLib.ToJSValue(sp.translate(\"Gennaio\"))%\u003e' , '\u003c%=JSPLib.ToJSValue(sp.translate(\"Febbraio\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Marzo\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Aprile\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Maggio\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Giugno\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Luglio\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Agosto\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Settembre\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Ottobre\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Novembre\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Dicembre\"))%\u003e');\nvar giorno = new Array ('\u003c%=JSPLib.ToJSValue(sp.translate(\"Domenica\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Lunedi\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Martedi\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Mercoledi\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Giovedi\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Venerdi\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"Sabato\"))%\u003e');\n\n\n\nvar i= new Date();\nvar dd=i.getDay();\nvar gg=i.getDate();\nvar mm=i.getMonth();\nvar aa=i.getFullYear();\n\n\n\nif (gg \u003c 10) { zero = '0' } else { zero = '' };\nthis.label14.Value(Trim(zero + gg));\nthis.label12.Value( giorno[dd]);\nthis.label16.Value(mese[mm]+ ' '+ aa  );\n\n\n\n\nsetInterval('ZtVWeb.getPortlet(\\'start_page_calendar\\').upclock()',1000);\n\n","bg_image":" ","cache_time":" ","color":"transparent","css":" ","css_class":" ","description":" ","form_action":" ","form_target":" ","form_type":"false","h":"250","hsl":" ","language":"false","lock_items":" ","manifest":" ","my_library":" ","offline":" ","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","sp_theme":"false","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"170"},{"align":"center","anchor":"top-right","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":"31px","font_weight":"bold","h":"40","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label14","page":"1","picture":" ","sequence":"1","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"00","w":"53","x":"55","y":"183","zindex":"1"},{"align":"left","anchor":"top-right","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Tahoma","font_color":"#291C00","font_size":"10px","font_weight":"normal","h":"15","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label16","page":"1","picture":" ","sequence":"2","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Settembre 2006","w":"74","x":"57","y":"218","zindex":"1"},{"align":"left","anchor":"top-right","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#291C00","font_size":"10px","font_weight":"normal","h":"13","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label15","page":"1","picture":" ","sequence":"3","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"...","w":"102","x":"60","y":"158","zindex":"1"},{"align":"center","anchor":"top-right","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":"Tahoma","font_color":"#333333","font_size":"7pt","font_weight":"bold","h":"14","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label12","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Martedi","w":"57","x":"54","y":"177","zindex":"1"},{"anchor":" ","bg_color":"transparent","border_color":" ","border_weight":"0","class_Css":" ","h":"120","hide_undercond":" ","name":"clockBox","page":"1","sequence":"5","stretch":"false","type":"Box","w":"120","x":"25","y":"26","zindex":"2"},{"alt":" ","anchor":" ","dataobj":" ","field":" ","h":"250","help_tips":" ","hide_undercond":" ","href":" ","name":"sfx_Copy","page":"1","path_type":"skin","sequence":"6","server_side":" ","src":"..\u002fimages\u002fbackclock.png","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"170","x":"0","y":"0","zindex":"0"},{"alt":" ","anchor":" ","dataobj":" ","field":" ","h":"135","help_tips":" ","hide_undercond":" ","href":" ","name":"sfx","page":"1","path_type":"skin","sequence":"7","server_side":" ","src":"..\u002fimages\u002fclock.png","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"135","x":"17","y":"20","zindex":"1"}]%>
<%/*Description: */%>
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
.start_page_calendar_container {
}
.start_page_calendar_portlet{
  position:relative;
  width:170px;
  min-width:170px;
  height:250px;
  background-color:transparent;
}
.start_page_calendar_portlet[Data-page="1"]{
  height:250px;
  width:170px;
}
.start_page_calendar_portlet > .label14_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:183px;
  right:62px;
  width:53px;
  height:auto;
  min-height:40px;
}
.start_page_calendar_portlet > .label14_ctrl {
  height:auto;
  min-height:40px;
}
.start_page_calendar_portlet > .label14_ctrl {
  overflow:hidden;
  font-size:31px;
  font-weight:bold;
  text-align:center;
  background-color:transparent;
}
.start_page_calendar_portlet > .label16_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:218px;
  right:39px;
  width:74px;
  height:auto;
  min-height:15px;
}
.start_page_calendar_portlet > .label16_ctrl {
  height:auto;
  min-height:15px;
}
.start_page_calendar_portlet > .label16_ctrl {
  overflow:hidden;
  font-family:Tahoma;
  font-size:10px;
  font-weight:normal;
  color:#291C00;
  text-align:left;
  background-color:transparent;
}
.start_page_calendar_portlet > .label15_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:158px;
  right:8px;
  width:102px;
  height:auto;
  min-height:13px;
}
.start_page_calendar_portlet > .label15_ctrl {
  height:auto;
  min-height:13px;
}
.start_page_calendar_portlet > .label15_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:10px;
  font-weight:normal;
  color:#291C00;
  text-align:left;
  background-color:transparent;
}
.start_page_calendar_portlet > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:177px;
  right:59px;
  width:57px;
  height:auto;
  min-height:14px;
}
.start_page_calendar_portlet > .label12_ctrl {
  height:auto;
  min-height:14px;
}
.start_page_calendar_portlet > .label12_ctrl {
  overflow:hidden;
  font-family:Tahoma;
  font-size:7pt;
  font-weight:bold;
  color:#333333;
  text-align:center;
  background-color:transparent;
}
.start_page_calendar_portlet > .clockBox_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:26px;
  left:25px;
  width:120px;
  height:auto;
  min-height:120px;
  display:flex;
  flex-direction:column;
}
.start_page_calendar_portlet > .clockBox_ctrl {
  height:120px;
}
.start_page_calendar_portlet > .clockBox_ctrl > .box_content {
  height:100%;
}
.start_page_calendar_portlet > .clockBox_ctrl {
  min-height:120px;
  background-color:transparent;
  border-width:0px;
  border-style:solid;
}
.start_page_calendar_portlet > .sfx_Copy_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:170px;
  height:250px;
}
.start_page_calendar_portlet > .sfx_Copy_ctrl {
}
.start_page_calendar_portlet > .sfx_Copy_ctrl > img{
  width:100%;
  vertical-align:top;
  height:250px;
}
.start_page_calendar_portlet > .sfx_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:17px;
  width:135px;
  height:135px;
}
.start_page_calendar_portlet > .sfx_ctrl {
}
.start_page_calendar_portlet > .sfx_ctrl > img{
  width:100%;
  vertical-align:top;
  height:135px;
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
 String def="[{\"h\":\"250\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"170\"},{\"anchor\":\"top-right\",\"h\":\"40\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"53\",\"x\":\"55\",\"y\":\"183\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"15\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"74\",\"x\":\"57\",\"y\":\"218\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"102\",\"x\":\"60\",\"y\":\"158\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"14\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"57\",\"x\":\"54\",\"y\":\"177\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"120\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"120\",\"x\":\"25\",\"y\":\"26\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"250\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"170\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"135\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"135\",\"x\":\"17\",\"y\":\"20\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_calendar","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_calendar_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_calendar','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label14= "00";
String label16= "Settembre 2006";
String label15= "...";
String label12= "Martedi";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_calendar_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_calendar_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_calendar','<%=idPortlet%>',false,' ');
</script><%}}%>
<span id='<%=idPortlet%>_label14'  formid='<%=idPortlet%>' ps-name='label14'    class='label label14_ctrl'><div id='<%=idPortlet%>_label14tbl' style='width:100%;'><%=JSPLib.ToHTML("00")%></div></span>
<span id='<%=idPortlet%>_label16'  formid='<%=idPortlet%>' ps-name='label16'    class='label label16_ctrl'><div id='<%=idPortlet%>_label16tbl' style='width:100%;'><%=JSPLib.ToHTML("Settembre 2006")%></div></span>
<span id='<%=idPortlet%>_label15'  formid='<%=idPortlet%>' ps-name='label15'    class='label label15_ctrl'><div id='<%=idPortlet%>_label15tbl' style='width:100%;'><%=JSPLib.ToHTML("...")%></div></span>
<span id='<%=idPortlet%>_label12'  formid='<%=idPortlet%>' ps-name='label12'    class='label label12_ctrl'><div id='<%=idPortlet%>_label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Martedi")%></div></span>
<div id='<%=idPortlet%>_clockBox' class='clockBox_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_clockBox_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_sfx_Copy'>
<img id='<%=idPortlet%>_sfx_Copy_img' class=' sfx_Copy_ctrl' src="../<%=sp.getSkin()%>/images/backclock.png" >
</div>
<div id='<%=idPortlet%>_sfx'>
<img id='<%=idPortlet%>_sfx_img' class=' sfx_ctrl' src="../<%=sp.getSkin()%>/images/clock.png" >
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_calendar');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_calendar',["170"],["250"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"170","h":"250","title":" ","layer":"false","npage":"1"}]);
this.label14=new ZtVWeb._LC(this,{"align":"center","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label14","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":"31px","font_weight":"bold","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label14","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label14,false,true)%>","type":"Label","w":53,"x":55,"y":183,"zindex":"1"});
this.label16=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_label16","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Tahoma","font_color":"#291C00","font_size":"10px","font_weight":"normal","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label16","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label16,false,true)%>","type":"Label","w":74,"x":57,"y":218,"zindex":"1"});
this.label15=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_label15","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#291C00","font_size":"10px","font_weight":"normal","fontpct":"","h":13,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label15","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label15,false,true)%>","type":"Label","w":102,"x":60,"y":158,"zindex":"1"});
this.label12=new ZtVWeb._LC(this,{"align":"center","anchor":"top-right","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Tahoma","font_color":"#333333","font_size":"7pt","font_weight":"bold","fontpct":"","h":14,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label12,false,true)%>","type":"Label","w":57,"x":54,"y":177,"zindex":"1"});
this.clockBox=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"transparent","border_color":" ","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_clockBox","groupName":"","h":120,"hide":"false","hide_undercond":" ","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"clockBox","page":1,"shrinkable":"false","stretch":"false","target":"","titled":"false","type":"Box","w":120,"x":25,"y":26,"zindex":"2"});
this.sfx_Copy=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":" sfx_Copy_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_sfx_Copy","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":250,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"sfx_Copy","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002fbackclock.png","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":170,"x":0,"y":0,"zindex":"0"});
this.sfx=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":" sfx_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_sfx","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":135,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"sfx","page":1,"path_type":"skin","server_side":"","src":"..\u002f<%=sp.getSkin()%>\u002fimages\u002fclock.png","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":135,"x":17,"y":20,"zindex":"1"});
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
<%request.setAttribute("start_page_calendar_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.start_page_calendar_Static=function(){
if(typeof vmlClock !='undefined')this.vmlClock=vmlClock;
if(typeof canvasClock !='undefined')this.canvasClock=canvasClock;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof upclock !='undefined')this.upclock=upclock;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
//Setto le variabili utili per la costruzione del calendario
var zero = '';
var mese = new Array ( 'Gennaio' , 'Febbraio','Marzo','Aprile','Maggio','Giugno','Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre');
var giorno = new Array ('Domenica','Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato');
i= new Date(); dd=i.getDay(); gg=i.getDate(); mm=i.getMonth(); aa=i.getFullYear();
if (gg < 10) { zero = '0' } else { zero = '' };
// Vml
var vmlClock = "";
vmlClock += "<xml:namespace ns=\"urn:schemas-microsoft-com:vml\" prefix=\"vml\" /><?import namespace=\"vml\" implementation=\"#default#VML\" ?>";
vmlClock += "<vml:group id=\"seconds\" style=\"width:80px;height:80px;position:absolute;left:20px;top:20px;\" coordorigin=\"0 0\" coordsize=\"80 80\"><vml:line from=\"40,40\" to=\"40,0\"><vml:stroke weight=\"1px\" endcap=\"round\" color=\"#cc0000\"/></vml:line></vml:group>";
vmlClock += "<vml:group id=\"minutes\" style=\"width:80px;height:80px;position:absolute;left:20px;top:20px;\" coordorigin=\"0 0\" coordsize=\"80 80\"><vml:line from=\"40,40\" to=\"40,0\"><vml:stroke weight=\"3px\" endcap=\"round\" color=\"#3a484b\"/></vml:line></vml:group>";
vmlClock += "<vml:group id=\"hours\" style=\"width:80px;height:80px;position:absolute;left:20px;top:20px;\" coordorigin=\"0 0\" coordsize=\"80 80\"><vml:line from=\"40,40\" to=\"40,15\"><vml:stroke weight=\"5px\" endcap=\"round\" color=\"#3a484b\"/></vml:line></vml:group>";
vmlClock += "<vml:oval fillcolor=\"#3a484b\" style=\"width:10px;height:10px;position:absolute;left:53px;top:53px;\" strokecolor=\"#3a484b\" strokeweight=\"1px\" />";
// Canvas
var canvasClock = "<canvas id=\"canvasClock\" width=\"80\" height=\"80\" style=\"position:absolute;left:20px;top:20px;\"></canvas>";
// Update vml clock
function vmlClock(){
  var now = new Date();
  var sec = now.getSeconds();
  var min = now.getMinutes();
  var hr  = now.getHours();
  hr = hr>=12 ? hr-12 : hr;
  var seconds = document.getElementById("seconds");
  if(seconds) seconds.rotation = sec * 6;
  var minutes= document.getElementById("minutes");
  if(minutes) minutes.rotation = min * 6;
  var hours= document.getElementById("hours");
  if(hours) hours.rotation = hr * 30 + min/2;
}
// Update canvas clock
function canvasClock() {
  var now = new Date();
  var ctx = document.getElementById("canvasClock").getContext('2d');
  ctx.save();
  ctx.clearRect(0,0,80,80);
  ctx.translate(40,40);
  ctx.scale(0.4,0.4);
  ctx.rotate(-Math.PI/2);
  ctx.strokeStyle = "#3a484b";
  ctx.fillStyle = "white";
  ctx.lineWidth = 6;
  ctx.lineCap = "round";
  var sec = now.getSeconds();
  var min = now.getMinutes();
  var hr  = now.getHours();
  hr = hr>=12 ? hr-12 : hr;
  ctx.fillStyle = "#3a484b";
  // write Hours
  ctx.save();
  ctx.rotate( hr*(Math.PI/6) + (Math.PI/360)*min + (Math.PI/21600)*sec )
  ctx.lineWidth = 12;
  ctx.beginPath();
  ctx.moveTo(0,0);
  ctx.lineTo(55,0);
  ctx.stroke();
  ctx.restore();
  // write Minutes
  ctx.save();
  ctx.rotate( (Math.PI/30)*min + (Math.PI/1800)*sec )
  ctx.lineWidth = 8;
  ctx.beginPath();
  ctx.moveTo(0,0);
  ctx.lineTo(95,0);
  ctx.stroke();
  ctx.restore();
  // Write seconds
  ctx.save();
  ctx.rotate(sec * Math.PI/30);
  ctx.strokeStyle = '#cc0000';
  ctx.lineWidth = 2;
  ctx.beginPath();
  ctx.moveTo(0,0);
  ctx.lineTo(110,0);
  ctx.stroke();
  ctx.restore();
  // Write pivot
  ctx.beginPath();
  ctx.lineWidth = 2;
  ctx.strokeStyle = '#3a484b';
  ctx.arc(0,0,10,0,Math.PI*2,true);
  ctx.fill();
  ctx.restore();
  // Erase old
  ctx.beginPath();
  ctx.lineWidth = 14;
  ctx.strokeStyle = '#fff';
  ctx.arc(0,0,120,0,Math.PI*2,true);
  ctx.stroke();
  ctx.restore();
}
function this_Loaded(){
  // Se browser non supporta canvas
  if(!document.createElement("canvas").getContext) {
    this.clockBox.Ctrl.innerHTML = vmlClock;
    setInterval(this.formid+'.vmlClock()',1000);
  }else{
    this.clockBox.Ctrl.innerHTML = canvasClock;
    setInterval(this.formid+'.canvasClock()',1000);
  }
}
var _this = this;
function upclock(){
   var dte = new Date();
   var hrs = dte.getHours();
   var min = dte.getMinutes();
   var sec = dte.getSeconds();
   var col = ':';
   var spc = ' ';
   if (hrs == 0) hrs=12;
   if (hrs<=9) hrs="0"+hrs;
   if (min<=9) min="0"+min;
   if (sec<=9) sec="0"+sec;
   this.label15.Value(hrs+'.'+min+'.'+sec+spc);
}
var zero = '';
var mese = new Array ( '<%=JSPLib.ToJSValue(sp.translate("Gennaio"))%>' , '<%=JSPLib.ToJSValue(sp.translate("Febbraio"))%>','<%=JSPLib.ToJSValue(sp.translate("Marzo"))%>','<%=JSPLib.ToJSValue(sp.translate("Aprile"))%>','<%=JSPLib.ToJSValue(sp.translate("Maggio"))%>','<%=JSPLib.ToJSValue(sp.translate("Giugno"))%>','<%=JSPLib.ToJSValue(sp.translate("Luglio"))%>','<%=JSPLib.ToJSValue(sp.translate("Agosto"))%>','<%=JSPLib.ToJSValue(sp.translate("Settembre"))%>','<%=JSPLib.ToJSValue(sp.translate("Ottobre"))%>','<%=JSPLib.ToJSValue(sp.translate("Novembre"))%>','<%=JSPLib.ToJSValue(sp.translate("Dicembre"))%>');
var giorno = new Array ('<%=JSPLib.ToJSValue(sp.translate("Domenica"))%>','<%=JSPLib.ToJSValue(sp.translate("Lunedi"))%>','<%=JSPLib.ToJSValue(sp.translate("Martedi"))%>','<%=JSPLib.ToJSValue(sp.translate("Mercoledi"))%>','<%=JSPLib.ToJSValue(sp.translate("Giovedi"))%>','<%=JSPLib.ToJSValue(sp.translate("Venerdi"))%>','<%=JSPLib.ToJSValue(sp.translate("Sabato"))%>');
var i= new Date();
var dd=i.getDay();
var gg=i.getDate();
var mm=i.getMonth();
var aa=i.getFullYear();
if (gg < 10) { zero = '0' } else { zero = '' };
this.label14.Value(Trim(zero + gg));
this.label12.Value( giorno[dd]);
this.label16.Value(mese[mm]+ ' '+ aa  );
setInterval('ZtVWeb.getPortlet(\'start_page_calendar\').upclock()',1000);

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_calendar_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_calendar',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_calendar');
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
sp.endPage("start_page_calendar");
}%>
<%! public String getJSPUID() { return "2965519159"; } %>