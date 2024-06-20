<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function SQLFamEsiti_QueryExecuted(){\n  this.cmgRAPAGE.Value(this.SQLFamEsiti.rs.FAMTIPORAP);\n  this.Saldo2011.Value(this.SQLFamEsiti.rs.FAMSAL2011);\n  this.Saldo2012.Value(this.SQLFamEsiti.rs.FAMSAL2012);\n  this.Saldo2013.Value(this.SQLFamEsiti.rs.FAMSAL2013);\n  this.Saldo2014.Value(this.SQLFamEsiti.rs.FAMSAL2014);  \n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#FFFFFF","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"200","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"700"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"50","name":"rapunique","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"2","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"410","x":"161","y":"14","zerofilling":"false","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2","nowrap":"false","page":"1","picture":" ","sequence":"3","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Codice Univoco Famiglia:","w":"142","x":"15","y":"17","zindex":"1"},{"auto_exec":"true","count":"false","localDBName":" ","n_records":"1","name":"SQLFamEsiti","offline":"false","page":"1","parms":"pFAMCODICE=rapunique","parms_source":" ","query":"qbe_famesiti","query_async":"false","return_fields_type":"true","sequence":"4","type":"SQLDataobj","x":"6","y":"-32"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":"SQLTbtiprap","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","hide_undercond":" ","init":" ","init_par":" ","name":"cmgRAPAGE","page":"1","picture":" ","sequence":"5","tabindex":" ","textlist":" ","type":"Combobox","typevar":"character","valuelist":" ","visible":"true","w":"408","x":"161","y":"42"},{"auto_exec":"true","count":"false","localDBName":" ","n_records":"100","name":"SQLTbtiprap","offline":"false","page":"1","parms":" ","parms_source":" ","query":"qbe_tbrapp","query_async":"false","return_fields_type":"true","sequence":"6","type":"SQLDataobj","x":"56","y":"-28"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label5","nowrap":"false","page":"1","picture":" ","sequence":"7","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Tipo Rapporto:","w":"114","x":"43","y":"44","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":"SQLFamEsiti","edit_undercond":" ","field":"FAMDATINI","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"dDatIni","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"8","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"89","x":"161","y":"70","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":"SQLFamEsiti","edit_undercond":" ","field":"FAMDATINI,FAMDATFIN","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"dDatFin","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"8","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"89","x":"411","y":"70","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","checked_value":"0","create_undercond":" ","edit_undercond":" ","h":"13","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","name":"Saldo2011","page":"1","sequence":"9","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":"13","x":"164","y":"101"},{"anchor":" ","calculate":" ","checked_value":"0","create_undercond":" ","edit_undercond":" ","h":"13","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","name":"Saldo2012","page":"1","sequence":"9","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":"13","x":"254","y":"102"},{"anchor":" ","calculate":" ","checked_value":"0","create_undercond":" ","edit_undercond":" ","h":"13","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","name":"Saldo2013","page":"1","sequence":"9","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":"13","x":"344","y":"102"},{"anchor":" ","calculate":" ","checked_value":"0","create_undercond":" ","edit_undercond":" ","h":"13","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","name":"Saldo2014","page":"1","sequence":"9","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":"13","x":"434","y":"102"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label10","nowrap":"false","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Saldo 2011","w":"69","x":"183","y":"102","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label11","nowrap":"false","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Saldo 2012","w":"69","x":"273","y":"102","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label12","nowrap":"false","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Saldo 2013","w":"69","x":"363","y":"102","zindex":"1"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label13","nowrap":"false","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Saldo 2014","w":"69","x":"453","y":"102","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label18","nowrap":"false","page":"1","picture":" ","sequence":"12","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Data Inizio:","w":"69","x":"88","y":"75","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label18_Copy","nowrap":"false","page":"1","picture":" ","sequence":"12","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Data Fine:","w":"69","x":"338","y":"76","zindex":"1"}]%>
<%/*Description: */%>
<%/*ParamsRequest:rapunique*/%>
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
window.pg_famesiti_Static=function(){
if(typeof SQLFamEsiti_QueryExecuted !='undefined')this.SQLFamEsiti_QueryExecuted=SQLFamEsiti_QueryExecuted;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLTbtiprap.addRowConsumer(this.cmgRAPAGE);
this.SQLFamEsiti.addDataConsumer(this.dDatIni,<%=JSPLib.ToJSValue("FAMDATINI",true)%>);
this.SQLFamEsiti.addDataConsumer(this.dDatFin,<%=JSPLib.ToJSValue("FAMDATINI,FAMDATFIN",true)%>);
function SQLFamEsiti_QueryExecuted(){
  this.cmgRAPAGE.Value(this.SQLFamEsiti.rs.FAMTIPORAP);
  this.Saldo2011.Value(this.SQLFamEsiti.rs.FAMSAL2011);
  this.Saldo2012.Value(this.SQLFamEsiti.rs.FAMSAL2012);
  this.Saldo2013.Value(this.SQLFamEsiti.rs.FAMSAL2013);
  this.Saldo2014.Value(this.SQLFamEsiti.rs.FAMSAL2014);  
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
.pg_famesiti_container {
}
.pg_famesiti_portlet{
  position:relative;
  width:700px;
  min-width:700px;
  height:200px;
  background-color:#FFFFFF;
}
.pg_famesiti_portlet[Data-page="1"]{
  height:200px;
  width:700px;
}
.pg_famesiti_portlet > .rapunique_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:161px;
  width:410px;
  height:20px;
}
.pg_famesiti_portlet > .rapunique_ctrl {
}
.pg_famesiti_portlet > .rapunique_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_famesiti_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:15px;
  width:142px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label2_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_famesiti_portlet > .cmgRAPAGE_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:161px;
  width:408px;
  height:20px;
}
.pg_famesiti_portlet > .label5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:43px;
  width:114px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label5_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label5_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_famesiti_portlet > .dDatIni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:161px;
  width:89px;
  height:20px;
}
.pg_famesiti_portlet > .dDatIni_ctrl {
}
.pg_famesiti_portlet > .dDatIni_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_famesiti_portlet > .dDatFin_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:411px;
  width:89px;
  height:20px;
}
.pg_famesiti_portlet > .dDatFin_ctrl {
}
.pg_famesiti_portlet > .dDatFin_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_famesiti_portlet > .Saldo2011_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:101px;
  left:164px;
  width:13px;
  height:13px;
}
.pg_famesiti_portlet > .Saldo2012_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:254px;
  width:13px;
  height:13px;
}
.pg_famesiti_portlet > .Saldo2013_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:344px;
  width:13px;
  height:13px;
}
.pg_famesiti_portlet > .Saldo2014_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:434px;
  width:13px;
  height:13px;
}
.pg_famesiti_portlet > .label10_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:183px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label10_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label10_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_famesiti_portlet > .label11_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:273px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label11_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label11_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_famesiti_portlet > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:363px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label12_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label12_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_famesiti_portlet > .label13_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:102px;
  left:453px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label13_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label13_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_famesiti_portlet > .label18_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:75px;
  left:88px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label18_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label18_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_famesiti_portlet > .label18_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:76px;
  left:338px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label18_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_famesiti_portlet > .label18_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
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
 String def="[{\"h\":\"200\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"700\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"410\",\"x\":\"161\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"142\",\"x\":\"15\",\"y\":\"17\",\"zindex\":\"1\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"6\",\"y\":\"-32\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"408\",\"x\":\"161\",\"y\":\"42\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"56\",\"y\":\"-28\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"114\",\"x\":\"43\",\"y\":\"44\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"89\",\"x\":\"161\",\"y\":\"70\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"89\",\"x\":\"411\",\"y\":\"70\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"164\",\"y\":\"101\"},{\"anchor\":\"\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"254\",\"y\":\"102\"},{\"anchor\":\"\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"344\",\"y\":\"102\"},{\"anchor\":\"\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"434\",\"y\":\"102\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"183\",\"y\":\"102\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"273\",\"y\":\"102\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"363\",\"y\":\"102\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"453\",\"y\":\"102\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"88\",\"y\":\"75\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"338\",\"y\":\"76\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_famesiti","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_famesiti_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_famesiti','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String rapunique=JSPLib.translateXSS(sp.getParameter("rapunique",""));
if(request.getAttribute("pg_famesiti_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label2= "Codice Univoco Famiglia:";
String cmgRAPAGE= "";
String label5= "Tipo Rapporto:";
java.sql.Date dDatIni= JSPLib.NullDate();
java.sql.Date dDatFin= JSPLib.NullDate();
String Saldo2011= "";
String Saldo2012= "";
String Saldo2013= "";
String Saldo2014= "";
String label10= "Saldo 2011";
String label11= "Saldo 2012";
String label12= "Saldo 2013";
String label13= "Saldo 2014";
String label18= "Data Inizio:";
String label18_Copy= "Data Fine:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_famesiti_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_famesiti_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_famesiti','<%=idPortlet%>',false,' ');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_rapunique_wrp'><input id='<%=idPortlet%>_rapunique' name='rapunique' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='rapunique' /></span>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice Univoco Famiglia:")%></div></span>
<select id='<%=idPortlet%>_cmgRAPAGE' name='cmgRAPAGE' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_label5'  formid='<%=idPortlet%>' ps-name='label5'    class='label label5_ctrl'><div id='<%=idPortlet%>_label5tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Rapporto:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_dDatIni_wrp'><input id='<%=idPortlet%>_dDatIni' name='dDatIni' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='dDatIni' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dDatFin_wrp'><input id='<%=idPortlet%>_dDatFin' name='dDatFin' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='dDatFin' /></span>
<input id='<%=idPortlet%>_Saldo2011' name='Saldo2011' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_Saldo2012' name='Saldo2012' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_Saldo2013' name='Saldo2013' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_Saldo2014' name='Saldo2014' class='checkbox' type='checkbox' style=''/>
<span id='<%=idPortlet%>_label10'  formid='<%=idPortlet%>' ps-name='label10'    class='label label10_ctrl'><div id='<%=idPortlet%>_label10tbl' style='width:100%;'><%=JSPLib.ToHTML("Saldo 2011")%></div></span>
<span id='<%=idPortlet%>_label11'  formid='<%=idPortlet%>' ps-name='label11'    class='label label11_ctrl'><div id='<%=idPortlet%>_label11tbl' style='width:100%;'><%=JSPLib.ToHTML("Saldo 2012")%></div></span>
<span id='<%=idPortlet%>_label12'  formid='<%=idPortlet%>' ps-name='label12'    class='label label12_ctrl'><div id='<%=idPortlet%>_label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Saldo 2013")%></div></span>
<span id='<%=idPortlet%>_label13'  formid='<%=idPortlet%>' ps-name='label13'    class='label label13_ctrl'><div id='<%=idPortlet%>_label13tbl' style='width:100%;'><%=JSPLib.ToHTML("Saldo 2014")%></div></span>
<span id='<%=idPortlet%>_label18'  formid='<%=idPortlet%>' ps-name='label18'    class='label label18_ctrl'><div id='<%=idPortlet%>_label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Data Inizio:")%></div></span>
<span id='<%=idPortlet%>_label18_Copy'  formid='<%=idPortlet%>' ps-name='label18_Copy'    class='label label18_Copy_ctrl'><div id='<%=idPortlet%>_label18_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Data Fine:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_famesiti');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_famesiti',["700"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"700","h":"200","title":" ","layer":"false","npage":"1"}]);
this.rapunique=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_rapunique","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"50","name":"rapunique","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(rapunique,false,true)%>","w":410,"x":161,"y":14,"zerofilling":false,"zindex":"1","zoom":""});
this.label2=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":142,"x":15,"y":17,"zindex":"1"});
this.SQLFamEsiti=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_famesiti","cmdHash":"<%=JSPLib.cmdHash("qbe_famesiti",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLFamEsiti","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLFamEsiti","nrows":"1","page":1,"parms":"pFAMCODICE=rapunique","parms_source":" ","type":"SQLDataobj","w":0,"x":6,"y":-32});
this.cmgRAPAGE=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_cmgRAPAGE","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=cmgRAPAGE%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"cmgRAPAGE","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":" ","type":"Combobox","typevar":"character","valuelist":" ","visible":true,"w":408,"x":161,"y":42});
this.SQLTbtiprap=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbrapp","cmdHash":"<%=JSPLib.cmdHash("qbe_tbrapp",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLTbtiprap","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLTbtiprap","nrows":"100","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":56,"y":-28});
this.label5=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label5","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label5","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label5,false,true)%>","type":"Label","w":114,"x":43,"y":44,"zindex":"1"});
this.dDatIni=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_dDatIni","decrypt":false,"edit_undercond":" ","encrypt":false,"field":"FAMDATINI","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dDatIni","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dDatIni%>","w":89,"x":161,"y":70,"zerofilling":false,"zindex":"1","zoom":""});
this.dDatFin=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_dDatFin","decrypt":false,"edit_undercond":" ","encrypt":false,"field":"FAMDATINI,FAMDATFIN","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dDatFin","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dDatFin%>","w":89,"x":411,"y":70,"zerofilling":false,"zindex":"1","zoom":""});
this.Saldo2011=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":" ","checked_value":"0","create_undercond":" ","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Saldo2011","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"hide":"false","hide_undercond":" ","init":" ","init_par":"","label_text":"","layer":false,"layout_steps_values":{},"name":"Saldo2011","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":13,"x":164,"y":101});
this.Saldo2012=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":" ","checked_value":"0","create_undercond":" ","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Saldo2012","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"hide":"false","hide_undercond":" ","init":" ","init_par":"","label_text":"","layer":false,"layout_steps_values":{},"name":"Saldo2012","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":13,"x":254,"y":102});
this.Saldo2013=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":" ","checked_value":"0","create_undercond":" ","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Saldo2013","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"hide":"false","hide_undercond":" ","init":" ","init_par":"","label_text":"","layer":false,"layout_steps_values":{},"name":"Saldo2013","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":13,"x":344,"y":102});
this.Saldo2014=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":" ","checked_value":"0","create_undercond":" ","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Saldo2014","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"hide":"false","hide_undercond":" ","init":" ","init_par":"","label_text":"","layer":false,"layout_steps_values":{},"name":"Saldo2014","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"1","w":13,"x":434,"y":102});
this.label10=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label10","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label10","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label10,false,true)%>","type":"Label","w":69,"x":183,"y":102,"zindex":"1"});
this.label11=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label11","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label11","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label11,false,true)%>","type":"Label","w":69,"x":273,"y":102,"zindex":"1"});
this.label12=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label12","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label12,false,true)%>","type":"Label","w":69,"x":363,"y":102,"zindex":"1"});
this.label13=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label13","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label13","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label13,false,true)%>","type":"Label","w":69,"x":453,"y":102,"zindex":"1"});
this.label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label18","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label18,false,true)%>","type":"Label","w":69,"x":88,"y":75,"zindex":"1"});
this.label18_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label18_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label18_Copy","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label18_Copy,false,true)%>","type":"Label","w":69,"x":338,"y":76,"zindex":"1"});
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
<%if(request.getAttribute("pg_famesiti_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_famesiti_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_famesiti_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLFamEsiti.firstQuery('true');
window.<%=idPortlet%>.SQLTbtiprap.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_famesiti',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_famesiti');
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
sp.endPage("pg_famesiti");
}%>
<%! public String getJSPUID() { return "1415779"; } %>