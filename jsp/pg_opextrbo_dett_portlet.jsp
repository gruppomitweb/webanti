<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Salva_Click() {\n  if (confirm(\"Confermi il salvataggio dei dati ?\")) {\n    this.SaveMC();\n    pippo=this.SalvaOpex.Link()\n    if (pippo=='OK') {\n      this.OpexSave.Emit()\n      alert('Dati salvati correttamente!') \n      window.close()\n    } else {\n      alert('Problema nel salvataggio dei dati:' + pippo)\n    }  \n\n  }  \n}\n\nfunction Uscita_Click() {\n  if (confirm(\"Confermi l'uscita senza salvare i dati ?\")) {\n    window.close()\n  }  \n}\n\nfunction this_Loaded(){\n this.CreaMC();\n this.cmbValuta.Set(this.valuta.Value());\n}\n\nfunction annorif_Validate(){\n  _esito=this.ChkAnno.Link()\n  if (_esito==\"true\") {\n    return true\n  } else {\n    alert(\"Esiste già un'operazione per l'anno selezionato !\")\n    return false\n  }  \n}\n\n\nfunction CreaMC() {\n  this.mcDati.CreateFld(\"COLLEG\",\"C\");\n  this.mcDati.CreateFld(\"ANNO\",\"C\");\n  this.mcDati.CreateFld(\"IDBASE\",\"C\");\n  this.mcDati.CreateFld(\"DATAOPE\",\"D\");\n  this.mcDati.CreateFld(\"COINT\",\"C\");\n  this.mcDati.CreateFld(\"NOTE\",\"C\");\n  this.mcDati.CreateFld(\"NUMPROG1\",\"C\");\n  this.mcDati.CreateFld(\"RIFIMP\",\"C\");\n  this.mcDati.CreateFld(\"IDFILE\",\"C\");\n  this.mcDati.CreateFld(\"PROGOPEX\",\"N\");\n  this.mcDati.CreateFld(\"SALDO\",\"N\");\n  this.mcDati.CreateFld(\"QUANTITA\",\"N\");\n  this.mcDati.CreateFld(\"VALUTA\",\"C\");\n}\n\nfunction SaveMC() {\n  this.mcDati.AppendBlank();\n  this.mcDati.Set(\"COLLEG\",this.CONNES.Value());\n  this.mcDati.Set(\"ANNO\",this.annorif.Value());\n  this.mcDati.Set(\"DATAOPE\",this.dDataOpe.Value());\n  this.mcDati.Set(\"NOTE\",this.txtNote.Value());\n  this.mcDati.Set(\"SALDO\",this.impsaldo.Value());\n  this.mcDati.Set(\"QUANTITA\",this.nummov.Value());\n  this.mcDati.Set(\"VALUTA\",this.cmbValuta.Value());\n}","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#C0C0C0","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"140","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"752"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#0335FF","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2","nowrap":"false","page":"1","picture":" ","sequence":"1","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"OPERAZIONE EXTRACONTO","w":"754","x":"-1","y":"-1","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"4","name":"annorif","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"1","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"47","x":"102","y":"29","zerofilling":"false","zindex":"1"},{"auto_exec":"true","count":"true","localDBName":" ","n_records":"1000","name":"OpexDett","offline":"false","page":"1","parms":"w_CONNES=CONNES,w_annorif=annorif","parms_source":" ","query":"qbe_opextrbo_dett","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","x":"62","y":"-41"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":"OpexDett","edit_undercond":" ","field":"DATAOPE","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":" ","name":"dDataOpe","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"2","tabindex":" ","type":"Textbox","typevar":"date","visible":"true","w":"91","x":"386","y":"29","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":"50","name":"txtNote","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"3","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"375","x":"102","y":"57","zerofilling":"false","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lData","nowrap":"false","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Data Operazione:","w":"88","x":"296","y":"33","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lNDG","nowrap":"false","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"NDG:","w":"88","x":"507","y":"33","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lSaldo","nowrap":"false","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Saldo Importo Operazioni:","w":"167","x":"217","y":"89","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":"OpexDett","edit_undercond":" ","field":"QUANTITA","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":"5","name":"nummov","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"4","tabindex":" ","type":"Textbox","typevar":"numeric","visible":"true","w":"45","x":"102","y":"85","zerofilling":"false","zindex":"1"},{"alt":" ","anchor":" ","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"Salva","page":"1","path_type":" ","sequence":"5","server_side":" ","src":"..\u002fimages\u002fsave.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"650","y":"103","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":"OpexDett","edit_undercond":" ","field":"SALDO","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":"15","name":"impsaldo","page":"1","password":" ","picture":"999,999,999","readonly":"false","scroll":"false","sequence":"5","tabindex":" ","type":"Textbox","typevar":"numeric","visible":"true","w":"112","x":"386","y":"85","zerofilling":"false","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":"qValute","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","hide_undercond":" ","init":" ","init_par":" ","name":"cmbValuta","page":"1","picture":" ","sequence":"6","tabindex":" ","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":"true","w":"396","x":"102","y":"113"},{"alt":" ","anchor":" ","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"Uscita","page":"1","path_type":" ","sequence":"7","server_side":" ","src":"..\u002fimages\u002fexit.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"700","y":"103","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"SalvaOpex","offline":"false","page":"1","parms":"mcOpex=mcDati,pTipo=tipo","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"9","servlet":"arfn_save_opextrbo","target":" ","type":"SPLinker","w":"30","x":"758","y":"45"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"ChkAnno","offline":"false","page":"1","parms":"pCODICE=CONNES,pAnno=annorif","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"9","servlet":"arfn_verify_opex","target":" ","type":"SPLinker","w":"30","x":"763","y":"-2"},{"eventsNames":" ","eventsObjs":" ","h":"20","name":"OpexSave","page":"1","parmsNames":" ","parmsTypes":" ","parmsValues":" ","sequence":"10","type":"EventEmitter","w":"22","x":"767","y":"92"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lAnno","nowrap":"false","page":"1","picture":" ","sequence":"12","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Anno Riferimento:","w":"89","x":"10","y":"33","zindex":"1"},{"auto_exec":"true","count":"false","localDBName":" ","n_records":"300","name":"qValute","offline":"false","page":"1","parms":" ","parms_source":" ","query":"qbe_tbvalute","query_async":"false","return_fields_type":"true","sequence":"13","type":"SQLDataobj","x":"26","y":"-41"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lNote","nowrap":"false","page":"1","picture":" ","sequence":"15","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Note:","w":"69","x":"30","y":"61","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lMov","nowrap":"false","page":"1","picture":" ","sequence":"15","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"N. Operazioni:","w":"100","x":"-1","y":"89","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lValuta","nowrap":"false","page":"1","picture":" ","sequence":"15","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Valuta:","w":"100","x":"-1","y":"117","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"16","name":"CONNES","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"16","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"142","x":"598","y":"29","zerofilling":"false","zindex":"1"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":"request","maxlength":"1","name":"tipo","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"17","tabindex":" ","type":"Textbox","typevar":"character","visible":"false","w":"57","x":"600","y":"58","zerofilling":"false","zindex":"1"},{"h":"30","name":"mcDati","page":"1","sequence":"18","type":"MemoryCursor","w":"30","x":"110","y":"-32"},{"calculate":" ","dataobj":"OpexDett","field":"VALUTA","h":"20","init":" ","init_par":" ","name":"valuta","page":"1","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"34","x":"600","y":"83"}]%>
<%/*Description: */%>
<%/*ParamsRequest:annorif,dDataOpe,CONNES,tipo*/%>
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
window.pg_opextrbo_dett_Static=function(){
if(typeof Salva_Click !='undefined')this.Salva_Click=Salva_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof annorif_Validate !='undefined')this.annorif_Validate=annorif_Validate;
if(typeof CreaMC !='undefined')this.CreaMC=CreaMC;
if(typeof SaveMC !='undefined')this.SaveMC=SaveMC;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.OpexDett.addDataConsumer(this.dDataOpe,<%=JSPLib.ToJSValue("DATAOPE",true)%>);
this.OpexDett.addDataConsumer(this.nummov,<%=JSPLib.ToJSValue("QUANTITA",true)%>);
this.OpexDett.addDataConsumer(this.impsaldo,<%=JSPLib.ToJSValue("SALDO",true)%>);
this.qValute.addRowConsumer(this.cmbValuta);
this.OpexDett.addDataConsumer(this.valuta,<%=JSPLib.ToJSValue("VALUTA",true)%>);
function Salva_Click() {
  if (confirm("Confermi il salvataggio dei dati ?")) {
    this.SaveMC();
    pippo=this.SalvaOpex.Link()
    if (pippo=='OK') {
      this.OpexSave.Emit()
      alert('Dati salvati correttamente!') 
      window.close()
    } else {
      alert('Problema nel salvataggio dei dati:' + pippo)
    }  
  }  
}
function Uscita_Click() {
  if (confirm("Confermi l'uscita senza salvare i dati ?")) {
    window.close()
  }  
}
function this_Loaded(){
 this.CreaMC();
 this.cmbValuta.Set(this.valuta.Value());
}
function annorif_Validate(){
  _esito=this.ChkAnno.Link()
  if (_esito=="true") {
    return true
  } else {
    alert("Esiste già un'operazione per l'anno selezionato !")
    return false
  }  
}
function CreaMC() {
  this.mcDati.CreateFld("COLLEG","C");
  this.mcDati.CreateFld("ANNO","C");
  this.mcDati.CreateFld("IDBASE","C");
  this.mcDati.CreateFld("DATAOPE","D");
  this.mcDati.CreateFld("COINT","C");
  this.mcDati.CreateFld("NOTE","C");
  this.mcDati.CreateFld("NUMPROG1","C");
  this.mcDati.CreateFld("RIFIMP","C");
  this.mcDati.CreateFld("IDFILE","C");
  this.mcDati.CreateFld("PROGOPEX","N");
  this.mcDati.CreateFld("SALDO","N");
  this.mcDati.CreateFld("QUANTITA","N");
  this.mcDati.CreateFld("VALUTA","C");
}
function SaveMC() {
  this.mcDati.AppendBlank();
  this.mcDati.Set("COLLEG",this.CONNES.Value());
  this.mcDati.Set("ANNO",this.annorif.Value());
  this.mcDati.Set("DATAOPE",this.dDataOpe.Value());
  this.mcDati.Set("NOTE",this.txtNote.Value());
  this.mcDati.Set("SALDO",this.impsaldo.Value());
  this.mcDati.Set("QUANTITA",this.nummov.Value());
  this.mcDati.Set("VALUTA",this.cmbValuta.Value());
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
.pg_opextrbo_dett_container {
}
.pg_opextrbo_dett_portlet{
  position:relative;
  width:752px;
  min-width:752px;
  height:140px;
  background-color:#C0C0C0;
}
.pg_opextrbo_dett_portlet[Data-page="1"]{
  height:140px;
  width:752px;
}
.pg_opextrbo_dett_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-1px;
  left:-1px;
  width:754px;
  height:auto;
  min-height:20px;
}
.pg_opextrbo_dett_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_opextrbo_dett_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#0335FF;
}
.pg_opextrbo_dett_portlet > .annorif_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:102px;
  width:47px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .annorif_ctrl {
}
.pg_opextrbo_dett_portlet > .annorif_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_dett_portlet > .dDataOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:386px;
  width:91px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .dDataOpe_ctrl {
}
.pg_opextrbo_dett_portlet > .dDataOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_dett_portlet > .txtNote_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:57px;
  left:102px;
  width:375px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .txtNote_ctrl {
}
.pg_opextrbo_dett_portlet > .txtNote_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_dett_portlet > .lData_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:296px;
  width:88px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lData_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lData_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .lNDG_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:507px;
  width:88px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lNDG_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lNDG_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .lSaldo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:89px;
  left:217px;
  width:167px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lSaldo_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lSaldo_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .nummov_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:85px;
  left:102px;
  width:45px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .nummov_ctrl {
}
.pg_opextrbo_dett_portlet > .nummov_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_dett_portlet > .Salva_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:103px;
  left:650px;
  width:40px;
  height:30px;
}
.pg_opextrbo_dett_portlet > .Salva_ctrl {
}
.pg_opextrbo_dett_portlet > .Salva_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_opextrbo_dett_portlet > .impsaldo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:85px;
  left:386px;
  width:112px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .impsaldo_ctrl {
}
.pg_opextrbo_dett_portlet > .impsaldo_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_dett_portlet > .cmbValuta_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:113px;
  left:102px;
  width:396px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:103px;
  left:700px;
  width:40px;
  height:30px;
}
.pg_opextrbo_dett_portlet > .Uscita_ctrl {
}
.pg_opextrbo_dett_portlet > .Uscita_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_opextrbo_dett_portlet > .lAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:10px;
  width:89px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .lNote_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:30px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lNote_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lNote_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .lMov_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:89px;
  left:-1px;
  width:100px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lMov_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lMov_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .lValuta_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:117px;
  left:-1px;
  width:100px;
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lValuta_ctrl {
  height:auto;
  min-height:19px;
}
.pg_opextrbo_dett_portlet > .lValuta_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_opextrbo_dett_portlet > .CONNES_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:598px;
  width:142px;
  height:20px;
}
.pg_opextrbo_dett_portlet > .CONNES_ctrl {
}
.pg_opextrbo_dett_portlet > .CONNES_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_opextrbo_dett_portlet > .tipo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_opextrbo_dett_portlet > .tipo_ctrl {
  display:none;
}
.pg_opextrbo_dett_portlet > .tipo_ctrl > input{
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
 String def="[{\"h\":\"140\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"752\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"754\",\"x\":\"-1\",\"y\":\"-1\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"47\",\"x\":\"102\",\"y\":\"29\",\"zindex\":\"1\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"62\",\"y\":\"-41\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"91\",\"x\":\"386\",\"y\":\"29\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"102\",\"y\":\"57\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"88\",\"x\":\"296\",\"y\":\"33\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"88\",\"x\":\"507\",\"y\":\"33\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"167\",\"x\":\"217\",\"y\":\"89\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"45\",\"x\":\"102\",\"y\":\"85\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"650\",\"y\":\"103\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"112\",\"x\":\"386\",\"y\":\"85\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"396\",\"x\":\"102\",\"y\":\"113\"},{\"anchor\":\"\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"700\",\"y\":\"103\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"758\",\"y\":\"45\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"763\",\"y\":\"-2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"767\",\"y\":\"92\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"89\",\"x\":\"10\",\"y\":\"33\",\"zindex\":\"1\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"26\",\"y\":\"-41\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"69\",\"x\":\"30\",\"y\":\"61\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"100\",\"x\":\"-1\",\"y\":\"89\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"100\",\"x\":\"-1\",\"y\":\"117\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"142\",\"x\":\"598\",\"y\":\"29\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"57\",\"x\":\"600\",\"y\":\"58\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"30\",\"x\":\"110\",\"y\":\"-32\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"34\",\"x\":\"600\",\"y\":\"83\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_opextrbo_dett","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_opextrbo_dett_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_opextrbo_dett','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label2= "OPERAZIONE EXTRACONTO";
String annorif=JSPLib.translateXSS(sp.getParameter("annorif",""));
if(request.getAttribute("pg_opextrbo_dett_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date dDataOpe=sp.getParameter("dDataOpe",JSPLib.NullDate());
String txtNote= "";
String lData= "Data Operazione:";
String lNDG= "NDG:";
String lSaldo= "Saldo Importo Operazioni:";
double nummov= 0;
double impsaldo= 0;
String cmbValuta= "";
String lAnno= "Anno Riferimento:";
String lNote= "Note:";
String lMov= "N. Operazioni:";
String lValuta= "Valuta:";
String CONNES=JSPLib.translateXSS(sp.getParameter("CONNES",""));
String tipo=JSPLib.translateXSS(sp.getParameter("tipo",""));
if(request.getAttribute("pg_opextrbo_dett_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
String valuta= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_opextrbo_dett_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_opextrbo_dett_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_opextrbo_dett','<%=idPortlet%>',false,' ');
</script><%}}%>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("OPERAZIONE EXTRACONTO")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_annorif_wrp'><input id='<%=idPortlet%>_annorif' name='annorif' type='text' maxlength='4' class='textbox' formid='<%=idPortlet%>' ps-name='annorif' /></span>
<span class='textbox-container'id='<%=idPortlet%>_dDataOpe_wrp'><input id='<%=idPortlet%>_dDataOpe' name='dDataOpe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='dDataOpe' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtNote_wrp'><input id='<%=idPortlet%>_txtNote' name='txtNote' type='text' maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='txtNote' /></span>
<span id='<%=idPortlet%>_lData'  formid='<%=idPortlet%>' ps-name='lData'    class='label lData_ctrl'><div id='<%=idPortlet%>_lDatatbl' style='width:100%;'><%=JSPLib.ToHTML("Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lNDG'  formid='<%=idPortlet%>' ps-name='lNDG'    class='label lNDG_ctrl'><div id='<%=idPortlet%>_lNDGtbl' style='width:100%;'><%=JSPLib.ToHTML("NDG:")%></div></span>
<span id='<%=idPortlet%>_lSaldo'  formid='<%=idPortlet%>' ps-name='lSaldo'    class='label lSaldo_ctrl'><div id='<%=idPortlet%>_lSaldotbl' style='width:100%;'><%=JSPLib.ToHTML("Saldo Importo Operazioni:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nummov_wrp'><input id='<%=idPortlet%>_nummov' name='nummov' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='nummov' inputmode='numeric' /></span>
<div id='<%=idPortlet%>_Salva'>
<img id='<%=idPortlet%>_Salva_img' class='image Salva_ctrl' src="../images/save.gif" >
</div>
<span class='textbox-container'id='<%=idPortlet%>_impsaldo_wrp'><input id='<%=idPortlet%>_impsaldo' name='impsaldo' type='text' maxlength='15' class='textbox' formid='<%=idPortlet%>' ps-name='impsaldo' data-sp-item-say-pict='999,999,999' data-sp-item-get-pict='999,999,999' inputmode='numeric' /></span>
<select id='<%=idPortlet%>_cmbValuta' name='cmbValuta' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<div id='<%=idPortlet%>_Uscita'>
<img id='<%=idPortlet%>_Uscita_img' class='image Uscita_ctrl' src="../images/exit.gif" >
</div>
<span id='<%=idPortlet%>_lAnno'  formid='<%=idPortlet%>' ps-name='lAnno'    class='label lAnno_ctrl'><div id='<%=idPortlet%>_lAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno Riferimento:")%></div></span>
<span id='<%=idPortlet%>_lNote'  formid='<%=idPortlet%>' ps-name='lNote'    class='label lNote_ctrl'><div id='<%=idPortlet%>_lNotetbl' style='width:100%;'><%=JSPLib.ToHTML("Note:")%></div></span>
<span id='<%=idPortlet%>_lMov'  formid='<%=idPortlet%>' ps-name='lMov'    class='label lMov_ctrl'><div id='<%=idPortlet%>_lMovtbl' style='width:100%;'><%=JSPLib.ToHTML("N. Operazioni:")%></div></span>
<span id='<%=idPortlet%>_lValuta'  formid='<%=idPortlet%>' ps-name='lValuta'    class='label lValuta_ctrl'><div id='<%=idPortlet%>_lValutatbl' style='width:100%;'><%=JSPLib.ToHTML("Valuta:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_CONNES_wrp'><input id='<%=idPortlet%>_CONNES' name='CONNES' type='text' disabled maxlength='16' class='textbox' formid='<%=idPortlet%>' ps-name='CONNES' /></span>
<span class='textbox-container'id='<%=idPortlet%>_tipo_wrp'><input id='<%=idPortlet%>_tipo' name='tipo' type='hidden' disabled maxlength='1' class='textbox' formid='<%=idPortlet%>' ps-name='tipo' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_opextrbo_dett');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_opextrbo_dett',["752"],["140"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"752","h":"140","title":" ","layer":"false","npage":"1"}]);
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":754,"x":-1,"y":-1,"zindex":"1"});
this.annorif=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_annorif","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"4","name":"annorif","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(annorif,false,true)%>","w":47,"x":102,"y":29,"zerofilling":false,"zindex":"1","zoom":""});
this.OpexDett=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_opextrbo_dett","cmdHash":"<%=JSPLib.cmdHash("qbe_opextrbo_dett",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_OpexDett","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"OpexDett","nrows":"1000","page":1,"parms":"w_CONNES=CONNES,w_annorif=annorif","parms_source":" ","type":"SQLDataobj","w":0,"x":62,"y":-41});
this.dDataOpe=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_dDataOpe","decrypt":false,"edit_undercond":" ","encrypt":false,"field":"DATAOPE","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"dDataOpe","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dDataOpe%>","w":91,"x":386,"y":29,"zerofilling":false,"zindex":"1","zoom":""});
this.txtNote=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_txtNote","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"txtNote","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtNote,false,true)%>","w":375,"x":102,"y":57,"zerofilling":false,"zindex":"1","zoom":""});
this.lData=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lData","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lData","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lData,false,true)%>","type":"Label","w":88,"x":296,"y":33,"zindex":"1"});
this.lNDG=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lNDG","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lNDG","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lNDG,false,true)%>","type":"Label","w":88,"x":507,"y":33,"zindex":"1"});
this.lSaldo=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lSaldo","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lSaldo","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lSaldo,false,true)%>","type":"Label","w":167,"x":217,"y":89,"zindex":"1"});
this.nummov=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_nummov","decrypt":false,"edit_undercond":" ","encrypt":false,"field":"QUANTITA","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"nummov","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=nummov%>","w":45,"x":102,"y":85,"zerofilling":false,"zindex":"1","zoom":""});
this.Salva=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":"image Salva_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_Salva","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Salva","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":650,"y":103,"zindex":"1"});
this.impsaldo=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_impsaldo","decrypt":false,"edit_undercond":" ","encrypt":false,"field":"SALDO","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"15","name":"impsaldo","page":1,"picker":"","picture":"999,999,999","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=impsaldo%>","w":112,"x":386,"y":85,"zerofilling":false,"zindex":"1","zoom":""});
this.cmbValuta=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_cmbValuta","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=cmbValuta%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"cmbValuta","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":true,"w":396,"x":102,"y":113});
this.Uscita=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":700,"y":103,"zindex":"1"});
this.SalvaOpex=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SalvaOpex","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"SalvaOpex","offline":false,"page":1,"parms":"mcOpex=mcDati,pTipo=tipo","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arfn_save_opextrbo","target":" ","type":"SPLinker","w":30,"x":758,"y":45});
this.SalvaOpex.m_cID='<%=JSPLib.cmdHash("routine,arfn_save_opextrbo",request.getSession())%>';
this.ChkAnno=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ChkAnno","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"ChkAnno","offline":false,"page":1,"parms":"pCODICE=CONNES,pAnno=annorif","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arfn_verify_opex","target":" ","type":"SPLinker","w":30,"x":763,"y":-2});
this.ChkAnno.m_cID='<%=JSPLib.cmdHash("routine,arfn_verify_opex",request.getSession())%>';
this.OpexSave=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_OpexSave","eventsNames":" ","eventsObjs":" ","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"OpexSave","page":1,"parmsNames":" ","parmsTypes":" ","parmsValues":" ","persistent":"true","type":"EventEmitter","w":22,"x":767,"y":92});
this.lAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lAnno","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lAnno","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lAnno,false,true)%>","type":"Label","w":89,"x":10,"y":33,"zindex":"1"});
this.qValute=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbvalute","cmdHash":"<%=JSPLib.cmdHash("qbe_tbvalute",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_qValute","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"qValute","nrows":"300","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":26,"y":-41});
this.lNote=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lNote","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lNote","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lNote,false,true)%>","type":"Label","w":69,"x":30,"y":61,"zindex":"1"});
this.lMov=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lMov","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lMov","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lMov,false,true)%>","type":"Label","w":100,"x":-1,"y":89,"zindex":"1"});
this.lValuta=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lValuta","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lValuta","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lValuta,false,true)%>","type":"Label","w":100,"x":-1,"y":117,"zindex":"1"});
this.CONNES=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_CONNES","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"16","name":"CONNES","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(CONNES,false,true)%>","w":142,"x":598,"y":29,"zerofilling":false,"zindex":"1","zoom":""});
this.tipo=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_tipo","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"1","name":"tipo","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(tipo,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.mcDati=new ZtVWeb.MemoryCursorCtrl(this,'mcDati','<%=idPortlet%>_mcDati','','','','','false');
this.valuta=new ZtVWeb._VC(this,'valuta',null,'character','<%=JSPLib.ToJSValue(valuta,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_opextrbo_dett_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_opextrbo_dett_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_opextrbo_dett_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.OpexSave.setParms();
window.<%=idPortlet%>.OpexDett.firstQuery('true');
window.<%=idPortlet%>.qValute.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_opextrbo_dett',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_opextrbo_dett');
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
sp.endPage("pg_opextrbo_dett");
}%>
<%! public String getJSPUID() { return "963133841"; } %>