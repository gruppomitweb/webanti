<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Check per Estrazione Trimestrale',true)\n  this.getTitlePortlet().AppendButton({\n    id:\"Lista\",\n    title:FormatMsg('Stampa'),\n    tooltip:FormatMsg('Lancia la stampa di controllo selezionata'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.btnStampa1_Click()'\n  },1); \n  this.fType.Value(\"XLS|XLSX|CSV|CSVS\")\n  this.fModel.Value(\"|||\")  \n  \u002f\u002f inizializzazione delle combobox\n  var max = 11;\n  var d = new Date();  \n  var n = d.getFullYear();\n  var m = d.getMonth();  \n  var str = '';\n  for(var i=0; i\u003cmax; i++){\n      str=str+(n-i);\n      if(i!=(max-1))\n    \t\tstr=str+',';\n  }\n  this.Combobox_anno.FillDataStatic(str,str);\n  if(m\u003c3)\n \t\tthis.Combobox_anno.Value(n-1);\n  else\n  \tthis.Combobox_anno.Value(n);\n  this.Combobox_trimestre.FillDataStatic('1,2,3,4','Q1,Q2,Q3,Q4');\n  if(m\u003c3)\n    this.Combobox_trimestre.Value('4');\n  else if(m\u003c6)\n    this.Combobox_trimestre.Value('1');\n  else if(m\u003c9)\n    this.Combobox_trimestre.Value('2');\n  else\n    this.Combobox_trimestre.Value('3');  \n\n\tthis.Combobox_trimestre_onChange();\n  this.cmbReport_onChange()\n}\n\nfunction Combobox_trimestre_onChange(){\n  if(this.Combobox_trimestre.Value()==4) {\n    this.Label_periodo.Value('1 ottobre \u2013 31 dicembre')\n    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"1001\"))\n    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"1231\"))\n  }  \n  if(this.Combobox_trimestre.Value()==1) {\n    this.Label_periodo.Value('1 gennaio - 31 marzo')\n    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"0101\"))\n    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"0331\"))  \n  }\n  if(this.Combobox_trimestre.Value()==2) {\n    this.Label_periodo.Value('1 aprile \u2013 30 giugno')\n    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"0401\"))\n    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"0630\"))  \n  }  \n  if(this.Combobox_trimestre.Value()==3) {\n    this.Label_periodo.Value('1 luglio \u2013 30 settembre') \n    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"0701\"))\n    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+\"0930\"))  \n  }  \n  _nomefile=this.cmbReport.Text()+\"_\"+this.Combobox_anno.Value()+\"_Q\"+this.Combobox_trimestre.Value();\n  this.nomeOutput.Value(_nomefile.replaceAll(\u002f\\s+\u002fg,\"_\"));  \n  this.iPrint.Reload()\n}\n\nfunction cmbReport_onChange(){  \n  _nomefile=this.cmbReport.Text()+\"_\"+this.Combobox_anno.Value()+\"_Q\"+this.Combobox_trimestre.Value();\n  this.nomeOutput.Value(_nomefile.replaceAll(\u002f\\s+\u002fg,\"_\"));\n  this.iPrint.Reload()\n}\n\nfunction Combobox_anno_onChange(){\n  this.iPrint.Reload()  \n}\n\nfunction cmbArchivio_onChange(){\n  this.iPrint.Reload()\n}\n\nfunction btnStampa1_Click(){\n  if (confirm(\"Confermi l'esecuzione del report?\")) {\n    if(this.cmbReport.Value()==\"operp_estr_trim_check1.vrp\"){\n      this.SQLAssenza.ChangeQuery(\"qbe_estr_trim_scostamento_\"+this.cmbArchivio.Value()+\"_conta\")  \n      this.queryname.Value(\"qbe_estr_trim_scostamento_\"+this.cmbArchivio.Value())\n    }  \n    if(this.cmbReport.Value()==\"operp_estr_trim_check2.vrp\"){\n      this.SQLAssenza.ChangeQuery(\"qbe_estr_trim_assenza_\"+this.cmbArchivio.Value()+\"_conta\")\n      this.queryname.Value(\"qbe_estr_trim_assenza_\"+this.cmbArchivio.Value())\n    }  \n    if(this.cmbReport.Value()==\"operp_estr_trim_check3.vrp\"){\n      this.SQLAssenza.ChangeQuery(\"qbe_estr_trim_elenco_\"+this.cmbArchivio.Value()+\"_conta\")\n      this.queryname.Value(\"qbe_estr_trim_elenco_\"+this.cmbArchivio.Value())\n    }      \n   this.SQLAssenza.Query()   \n   if(this._totale.Value()==0){    \n     alert(\"Non sono state trovate anomalie\")\n   } else {  \n    this.SPStampa.Link();\n   }  \n  }  \n}\n\nfunction btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"400","hsl":"","htmlcode":"{{ @Label2 }}\n{{ @cmbArchivio }}\n{{ @Stampa }}\n{{ @cmbReport }}\n\n{{ @iPrint }}\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n{{ @Label_periodo }}\n\n\n\n\n\n{{ @Combobox_trimestre }}\n{{ @Combobox_anno }}\n{{ @Label1 }}\n\n{{ @Label0 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1000","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Estrazione Trimestrale per Banca d'Italia","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"851","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label0","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno:","w":"57","wireframe_props":"align,value,n_col","x":"17","y":"12","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fModel","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"901","y":"266"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label1","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Trimestre","w":"72","wireframe_props":"align,value,n_col","x":"166","y":"13","zindex":"2"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"nomeOutput","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"897","y":"29"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_anno","page":"1","picture":"","sequence":"5","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"numeric","valuelist":"","visible":"true","w":"80","wireframe_props":"name,textlist","x":"77","y":"13","zindex":"3"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"Combobox_trimestre","page":"1","picture":"","sequence":"6","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"80","wireframe_props":"name,textlist","x":"243","y":"13","zindex":"4"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_periodo","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"135","wireframe_props":"align,value,n_col","x":"329","y":"13","zindex":"8"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"last_run","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"895","y":"165"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"last_anno","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"895","y":"189"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"last_trim","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"895","y":"214"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"398","y":"-61"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dadataope","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"date","w":"120","x":"888","y":"-62"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"a_dataope","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"date","w":"120","x":"889","y":"-36"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"20","m_cAction":"","name":"SPStampa","offline":"false","page":"1","parms":"ReportName=cmbReport,pdadata=dadataope,pa_data=a_dataope,rotation=LANDSCAPE,formatModels=fModel,formatTypes=fType,hideParameterMask=true,FileName=nomeOutput,SubstituteQuery=queryname","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"893","y":"-3"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"313","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"15","spuid":"","type":"Iframe","w":"851","wireframe_props":"","x":"0","y":"78","zindex":"12"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"cmbReport","page":"1","picture":"","sequence":"16","spuid":"","tabindex":"","textlist":"Mancanza Dati Contante,Scostamento Importi,Elenco","type":"Combobox","typevar":"character","valuelist":"operp_estr_trim_check2.vrp,operp_estr_trim_check1.vrp,operp_estr_trim_check3.vrp","visible":"true","w":"292","wireframe_props":"name,textlist","x":"550","y":"13","zindex":"13"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Stampa","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Stampa","w":"72","wireframe_props":"align,value,n_col","x":"474","y":"14","zindex":"2"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"fType","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"898","y":"244"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"P","layer":"false","layout_steps_values":"{}","name":"cmbArchivio","page":"1","picture":"","sequence":"19","spuid":"","tabindex":"","textlist":"Provvisorio,Definitivo","type":"Combobox","typevar":"character","valuelist":"p,d","visible":"true","w":"247","wireframe_props":"name,textlist","x":"77","y":"46","zindex":"14"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Archivio:","w":"71","wireframe_props":"align,value,n_col","x":"3","y":"46","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"queryname","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"909","y":"61"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"1","name":"SQLAssenza","offline":"false","page":"1","parms":"pdadata=dadataope,pa_data=a_dataope","parms_source":"","query":"","query_async":"false","return_fields_type":"true","sequence":"22","type":"SQLDataobj","w":"120","x":"895","y":"95"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLAssenza","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"TOTALE","h":"20","init":"","init_par":"","name":"_totale","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"903","y":"293"}]%>
<%/*Description:*/%>
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
window.pg_estr_trim_check_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Combobox_trimestre_onChange !='undefined')this.Combobox_trimestre_onChange=Combobox_trimestre_onChange;
if(typeof cmbReport_onChange !='undefined')this.cmbReport_onChange=cmbReport_onChange;
if(typeof Combobox_anno_onChange !='undefined')this.Combobox_anno_onChange=Combobox_anno_onChange;
if(typeof cmbArchivio_onChange !='undefined')this.cmbArchivio_onChange=cmbArchivio_onChange;
if(typeof btnStampa1_Click !='undefined')this.btnStampa1_Click=btnStampa1_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLAssenza.addDataConsumer(this._totale,<%=JSPLib.ToJSValue("TOTALE",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Check per Estrazione Trimestrale',true)
  this.getTitlePortlet().AppendButton({
    id:"Lista",
    title:FormatMsg('Stampa'),
    tooltip:FormatMsg('Lancia la stampa di controllo selezionata'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.btnStampa1_Click()'
  },1); 
  this.fType.Value("XLS|XLSX|CSV|CSVS")
  this.fModel.Value("|||")  
  // inizializzazione delle combobox
  var max = 11;
  var d = new Date();  
  var n = d.getFullYear();
  var m = d.getMonth();  
  var str = '';
  for(var i=0; i<max; i++){
      str=str+(n-i);
      if(i!=(max-1))
    		str=str+',';
  }
  this.Combobox_anno.FillDataStatic(str,str);
  if(m<3)
 		this.Combobox_anno.Value(n-1);
  else
  	this.Combobox_anno.Value(n);
  this.Combobox_trimestre.FillDataStatic('1,2,3,4','Q1,Q2,Q3,Q4');
  if(m<3)
    this.Combobox_trimestre.Value('4');
  else if(m<6)
    this.Combobox_trimestre.Value('1');
  else if(m<9)
    this.Combobox_trimestre.Value('2');
  else
    this.Combobox_trimestre.Value('3');  
	this.Combobox_trimestre_onChange();
  this.cmbReport_onChange()
}
function Combobox_trimestre_onChange(){
  if(this.Combobox_trimestre.Value()==4) {
    this.Label_periodo.Value('1 ottobre – 31 dicembre')
    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"1001"))
    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"1231"))
  }  
  if(this.Combobox_trimestre.Value()==1) {
    this.Label_periodo.Value('1 gennaio - 31 marzo')
    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"0101"))
    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"0331"))  
  }
  if(this.Combobox_trimestre.Value()==2) {
    this.Label_periodo.Value('1 aprile – 30 giugno')
    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"0401"))
    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"0630"))  
  }  
  if(this.Combobox_trimestre.Value()==3) {
    this.Label_periodo.Value('1 luglio – 30 settembre') 
    this.dadataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"0701"))
    this.a_dataope.Value(CharToDate(Str(this.Combobox_anno.Value(),4,0)+"0930"))  
  }  
  _nomefile=this.cmbReport.Text()+"_"+this.Combobox_anno.Value()+"_Q"+this.Combobox_trimestre.Value();
  this.nomeOutput.Value(_nomefile.replaceAll(/\s+/g,"_"));  
  this.iPrint.Reload()
}
function cmbReport_onChange(){  
  _nomefile=this.cmbReport.Text()+"_"+this.Combobox_anno.Value()+"_Q"+this.Combobox_trimestre.Value();
  this.nomeOutput.Value(_nomefile.replaceAll(/\s+/g,"_"));
  this.iPrint.Reload()
}
function Combobox_anno_onChange(){
  this.iPrint.Reload()  
}
function cmbArchivio_onChange(){
  this.iPrint.Reload()
}
function btnStampa1_Click(){
  if (confirm("Confermi l'esecuzione del report?")) {
    if(this.cmbReport.Value()=="operp_estr_trim_check1.vrp"){
      this.SQLAssenza.ChangeQuery("qbe_estr_trim_scostamento_"+this.cmbArchivio.Value()+"_conta")  
      this.queryname.Value("qbe_estr_trim_scostamento_"+this.cmbArchivio.Value())
    }  
    if(this.cmbReport.Value()=="operp_estr_trim_check2.vrp"){
      this.SQLAssenza.ChangeQuery("qbe_estr_trim_assenza_"+this.cmbArchivio.Value()+"_conta")
      this.queryname.Value("qbe_estr_trim_assenza_"+this.cmbArchivio.Value())
    }  
    if(this.cmbReport.Value()=="operp_estr_trim_check3.vrp"){
      this.SQLAssenza.ChangeQuery("qbe_estr_trim_elenco_"+this.cmbArchivio.Value()+"_conta")
      this.queryname.Value("qbe_estr_trim_elenco_"+this.cmbArchivio.Value())
    }      
   this.SQLAssenza.Query()   
   if(this._totale.Value()==0){    
     alert("Non sono state trovate anomalie")
   } else {  
    this.SPStampa.Link();
   }  
  }  
}
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
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
.pg_estr_trim_check_container {
  height:100%;
  overflow:auto;
}
.pg_estr_trim_check_title_container {
  margin: auto;
}
.pg_estr_trim_check_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1000px;
  min-width:851px;
  height:100%;
}
.pg_estr_trim_check_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_estr_trim_check_portlet > .Label0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:17px;
  left:1.9976498%;
  right:777px;
  right:91.304344%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label0_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label0_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estr_trim_check_portlet > .Label1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:13px;
  left:166px;
  left:19.506462%;
  right:613px;
  right:72.032906%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label1_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label1_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estr_trim_check_portlet > .Combobox_anno_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:13px;
  left:77px;
  left:9.048179%;
  right:694px;
  right:81.55112%;
  width:auto;
  height:20px;
}
.pg_estr_trim_check_portlet > .Combobox_trimestre_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:13px;
  left:243px;
  left:28.554642%;
  right:528px;
  right:62.044655%;
  width:auto;
  height:20px;
}
.pg_estr_trim_check_portlet > .Label_periodo_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:13px;
  left:329px;
  left:38.6604%;
  right:387px;
  right:45.47591%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label_periodo_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label_periodo_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_estr_trim_check_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:78px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:313px;
}
.pg_estr_trim_check_portlet > .cmbReport_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:13px;
  left:550px;
  left:64.629845%;
  right:9px;
  right:1.0575793%;
  width:auto;
  height:22px;
}
.pg_estr_trim_check_portlet > .Stampa_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:14px;
  left:474px;
  left:55.699177%;
  right:305px;
  right:35.840187%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Stampa_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Stampa_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_estr_trim_check_portlet > .cmbArchivio_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:46px;
  left:77px;
  left:9.048179%;
  right:527px;
  right:61.927143%;
  width:auto;
  height:20px;
}
.pg_estr_trim_check_portlet > .Label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:3px;
  left:0.35252643%;
  right:777px;
  right:91.304344%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_estr_trim_check_portlet > .Label2_ctrl {
  overflow:hidden;
  text-align:right;
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"Estrazione Trimestrale per Banca d'Italia\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"851\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno:\",\"w\":\"57\",\"x\":\"17\",\"y\":\"12\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"901\",\"y\":\"266\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Trimestre\",\"w\":\"72\",\"x\":\"166\",\"y\":\"13\",\"zindex\":\"2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"897\",\"y\":\"29\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_anno\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"80\",\"x\":\"77\",\"y\":\"13\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Combobox_trimestre\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"80\",\"x\":\"243\",\"y\":\"13\",\"zindex\":\"4\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_periodo\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"135\",\"x\":\"329\",\"y\":\"13\",\"zindex\":\"8\"},{\"h\":\"20\",\"name\":\"last_run\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"895\",\"y\":\"165\"},{\"h\":\"20\",\"name\":\"last_anno\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"895\",\"y\":\"189\"},{\"h\":\"20\",\"name\":\"last_trim\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"895\",\"y\":\"214\"},{\"h\":\"20\",\"name\":\"gAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"398\",\"y\":\"-61\"},{\"h\":\"20\",\"name\":\"dadataope\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"888\",\"y\":\"-62\"},{\"h\":\"20\",\"name\":\"a_dataope\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"889\",\"y\":\"-36\"},{\"h\":\"20\",\"name\":\"SPStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"893\",\"y\":\"-3\"},{\"anchor\":\"\",\"h\":\"313\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"851\",\"x\":\"0\",\"y\":\"78\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"cmbReport\",\"page\":\"1\",\"textlist\":\"Mancanza Dati Contante,Scostamento Importi,Elenco\",\"type\":\"Combobox\",\"w\":\"292\",\"x\":\"550\",\"y\":\"13\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Stampa\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stampa\",\"w\":\"72\",\"x\":\"474\",\"y\":\"14\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"fType\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"898\",\"y\":\"244\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbArchivio\",\"page\":\"1\",\"textlist\":\"Provvisorio,Definitivo\",\"type\":\"Combobox\",\"w\":\"247\",\"x\":\"77\",\"y\":\"46\",\"zindex\":\"14\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Archivio:\",\"w\":\"71\",\"x\":\"3\",\"y\":\"46\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"queryname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"909\",\"y\":\"61\"},{\"h\":\"20\",\"name\":\"SQLAssenza\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"895\",\"y\":\"95\"},{\"h\":\"20\",\"name\":\"_totale\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"903\",\"y\":\"293\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estr_trim_check","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estr_trim_check_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estr_trim_check','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label0= "Anno:";
String fModel= "";
String Label1= "Trimestre";
String nomeOutput= "";
double Combobox_anno= 0;
String Combobox_trimestre= "";
String Label_periodo= "";
String last_run= "";
String last_anno= "";
String last_trim= "";
String gAzienda=sp.getGlobal("gAzienda","");
java.sql.Date dadataope= JSPLib.NullDate();
java.sql.Date a_dataope= JSPLib.NullDate();
String cmbReport= "";
String Stampa= "Stampa";
String fType= "";
String cmbArchivio="P";
String Label2= "Archivio:";
String queryname= "";
double _totale= 0;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estr_trim_check_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estr_trim_check_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estr_trim_check_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estr_trim_check','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_Label0'  formid='<%=idPortlet%>' ps-name='Label0'    class='label Label0_ctrl'><div id='<%=idPortlet%>_Label0tbl' style='width:100%;'><%=JSPLib.ToHTML("Anno:")%></div></span>
<span id='<%=idPortlet%>_Label1'  formid='<%=idPortlet%>' ps-name='Label1'    class='label Label1_ctrl'><div id='<%=idPortlet%>_Label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Trimestre")%></div></span>
<select id='<%=idPortlet%>_Combobox_anno' name='Combobox_anno' class='combobox' style=''></select>
<select id='<%=idPortlet%>_Combobox_trimestre' name='Combobox_trimestre' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label_periodo'  formid='<%=idPortlet%>' ps-name='Label_periodo'    class='label Label_periodo_ctrl'><div id='<%=idPortlet%>_Label_periodotbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<select id='<%=idPortlet%>_cmbReport' name='cmbReport' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Stampa'  formid='<%=idPortlet%>' ps-name='Stampa'    class='label Stampa_ctrl'><div id='<%=idPortlet%>_Stampatbl' style='width:100%;'><%=JSPLib.ToHTML("Stampa")%></div></span>
<select id='<%=idPortlet%>_cmbArchivio' name='cmbArchivio' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label2'  formid='<%=idPortlet%>' ps-name='Label2'    class='label Label2_ctrl'><div id='<%=idPortlet%>_Label2tbl' style='width:100%;'><%=JSPLib.ToHTML("Archivio:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estr_trim_check');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Lancia la stampa di controllo selezionata",true)+","+JSPLib.ToJSValue(sp.translate("Lancia la stampa di controllo selezionata"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Stampa",true)+","+JSPLib.ToJSValue(sp.translate("Stampa"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estr_trim_check',["851"],["400"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"400","title":"Estrazione Trimestrale per Banca d'Italia","layer":"false","npage":"1"}]);
this.Label0=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label0","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label0","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label0,false,true)%>","type":"Label","w":57,"x":17,"y":12,"zindex":"1"});
this.fModel=new ZtVWeb._VC(this,'fModel',null,'character','<%=JSPLib.ToJSValue(fModel,false,true)%>',false,false);
this.Label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label1","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label1,false,true)%>","type":"Label","w":72,"x":166,"y":13,"zindex":"2"});
this.nomeOutput=new ZtVWeb._VC(this,'nomeOutput',null,'character','<%=JSPLib.ToJSValue(nomeOutput,false,true)%>',false,false);
this.Combobox_anno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_anno","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_anno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_anno","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"numeric","valuelist":"","visible":true,"w":80,"x":77,"y":13,"zindex":"3"});
this.Combobox_trimestre=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_Combobox_trimestre","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=Combobox_trimestre%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Combobox_trimestre","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":80,"x":243,"y":13,"zindex":"4"});
this.Label_periodo=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_periodo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_periodo","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_periodo,false,true)%>","type":"Label","w":135,"x":329,"y":13,"zindex":"8"});
this.last_run=new ZtVWeb._VC(this,'last_run',null,'character','<%=JSPLib.ToJSValue(last_run,false,true)%>',false,false);
this.last_anno=new ZtVWeb._VC(this,'last_anno',null,'character','<%=JSPLib.ToJSValue(last_anno,false,true)%>',false,false);
this.last_trim=new ZtVWeb._VC(this,'last_trim',null,'character','<%=JSPLib.ToJSValue(last_trim,false,true)%>',false,false);
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.dadataope=new ZtVWeb._VC(this,'dadataope',null,'date','<%=dadataope%>',false,false);
this.a_dataope=new ZtVWeb._VC(this,'a_dataope',null,'date','<%=a_dataope%>',false,false);
this.SPStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPStampa","offline":false,"page":1,"parms":"ReportName=cmbReport,pdadata=dadataope,pa_data=a_dataope,rotation=LANDSCAPE,formatModels=fModel,formatTypes=fType,hideParameterMask=true,FileName=nomeOutput,SubstituteQuery=queryname","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":893,"y":-3});
this.SPStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":313,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":851,"x":0,"y":78,"zindex":"12"});
this.cmbReport=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbReport","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbReport%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbReport","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Mancanza Dati Contante,Scostamento Importi,Elenco","type":"Combobox","typevar":"character","valuelist":"operp_estr_trim_check2.vrp,operp_estr_trim_check1.vrp,operp_estr_trim_check3.vrp","visible":true,"w":292,"x":550,"y":13,"zindex":"13"});
this.Stampa=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Stampa","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Stampa","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Stampa,false,true)%>","type":"Label","w":72,"x":474,"y":14,"zindex":"2"});
this.fType=new ZtVWeb._VC(this,'fType',null,'character','<%=JSPLib.ToJSValue(fType,false,true)%>',false,false);
this.cmbArchivio=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbArchivio","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbArchivio%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbArchivio","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Provvisorio,Definitivo","type":"Combobox","typevar":"character","valuelist":"p,d","visible":true,"w":247,"x":77,"y":46,"zindex":"14"});
this.Label2=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label2,false,true)%>","type":"Label","w":71,"x":3,"y":46,"zindex":"1"});
this.queryname=new ZtVWeb._VC(this,'queryname',null,'character','<%=JSPLib.ToJSValue(queryname,false,true)%>',false,false);
this.SQLAssenza=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLAssenza","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLAssenza","nrows":"1","page":1,"parms":"pdadata=dadataope,pa_data=a_dataope","parms_source":"","type":"SQLDataobj","w":120,"x":895,"y":95});
this._totale=new ZtVWeb._VC(this,'_totale',null,'numeric',<%=_totale%>,false,false);
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
<%if(request.getAttribute("pg_estr_trim_check_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estr_trim_check_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estr_trim_check_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Combobox_anno.FillData();
window.<%=idPortlet%>.Combobox_trimestre.FillData();
window.<%=idPortlet%>.cmbReport.FillData();
window.<%=idPortlet%>.cmbArchivio.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estr_trim_check',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estr_trim_check');
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
sp.endPage("pg_estr_trim_check");
}%>
<%! public String getJSPUID() { return "1392600320"; } %>