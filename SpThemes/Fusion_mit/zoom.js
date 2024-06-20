document.writeln("<LINK type='text/css' rel='stylesheet' href='../"+m_cThemePath+"/zoom.css'>");
document.writeln("<SCRIPT src='../"+m_cThemePath+"/styleVariables.js' type='text/javascript'></SCRIPT>")
document.writeln("<SCRIPT src='../"+m_cThemePath+"/tabStrip.js' type='text/javascript'></SCRIPT>")
document.writeln("<SCRIPT src='../"+m_cThemePath+"/formTitle.js' type='text/javascript'></SCRIPT>")
document.writeln("<SCRIPT src='../"+m_cThemePath+"/calendar.js' type='text/javascript'></SCRIPT>")

//********************************************
//         Configuration variables:
var tlbQuery_Images = ['../'+m_cThemePath+'/zoom/zoom_new.gif'];
var imgCached=new Array();
var FormName = 'Zoom';
//********************************************
function WriteBody_Begin(doc,events) {
  doc.writeln("<BODY "+events+" onresize='adjustWidthAndHeight()' onload='adjustWidthAndHeight(true)' style='margin:0;padding:0;overflow:hidden'>")
  //Must be called inside BODY tag for Mozilla compatibility
  PrepareJsCalendar();

  doc.writeln("<TABLE border='0' width='100%' height='100%' cellpadding='0' cellspacing='0'>");

  doc.writeln("<TR>");
  doc.writeln("<TD id='titleTD' valign='top' style='width:0;height:0'>");
  if (Ne(window.name,'ZoomOnZoomFrame') && typeof(Title)!='undefined') Title(doc);
  doc.writeln("</TD>");
  doc.writeln("</TR>");

  doc.writeln("<TR>");
  doc.writeln("<TD id='mainTD' valign='top' style='width:100%;height:100%'>");
  doc.writeln("<DIV ID='bodyDiv' STYLE='position:relative;overflow:auto;width:1;height:100%'>")
  doc.writeln("<DIV STYLE='position:relative;margin:0'>")
}
function WriteBody_End(doc) {
  doc.writeln("</DIV>");
  doc.writeln("</DIV>");
  doc.writeln("</TD>");
  doc.writeln("</TR>");
  doc.writeln("</TABLE>");
  doc.writeln("<NOSCRIPT>JavaScript required to see this page</NOSCRIPT>");
  doc.writeln("<SPAN id='dpi_controller' style='position:absolute;top:0;left:0;font-family:verdana;font-size:8pt;visibility:hidden'>0</SPAN>");
  doc.writeln("</BODY>");
  var dpi_controller=Ctrl("dpi_controller");
  m_nPreferredHeight=Ctrl('bodyDiv').scrollHeight+Ctrl('dpi_controller').scrollHeight+1;
  m_nPreferredWidth=Ctrl('bodyDiv').scrollWidth;
  try{
    if(dpi_controller.clientHeight>13) AdjustFontSize(dpi_controller.clientHeight/13);
  }catch(e){}
  adjustWidthAndHeight();
}
function adjustWidthAndHeight(firstTime) {
  var titH, tbStripH, mainHeight;
  titH = Ctrl("titleTD")==null ? 0 : Ctrl("titleTD").offsetHeight;
  tbStripH = typeof(tabs)!='undefined' ? tabs.GetHeight() : 0;
  Ctrl("bodyDiv").style.width = document.body.clientWidth>0 ? document.body.clientWidth : document.body.offsetWidth;
  Ctrl("bodyDiv").style.height = 0;
  mainHeight = Math.max(0,(document.body.clientHeight>0 ? document.body.clientHeight : document.body.offsetHeight) - titH);
  Ctrl("bodyDiv").style.height = mainHeight;
  if (firstTime && Ctrl("page_1")!=null) {
    if (typeof(tabs)!='undefined')
      tabs.Select('page_1');
    Ctrl("page_1").style.margin = 8;
    Ctrl("page_1").style.width = Ctrl("bodyDiv").offsetWidth-32;
    Ctrl("page_1").style.height = Max(Ctrl("bodyDiv").offsetHeight-tbStripH-18,0);
  }
  m_nPreferredHeight=480;
  if (Ctrl("ZoomOnZoomFrame")!=null)
    Ctrl("ZoomOnZoomFrame").style.height = Math.max(0,mainHeight-tbStripH-2);
}
function SetZoomClick() {
  Ctrl(tabs.registeredName+'_page_1_TAB_href').href+=";document.forms[0].submit();";
}
function SetBackClick() {
  Ctrl(tabs.registeredName+'_page_2_TAB_href').href='javascript:if(document.forms.length>0){window.location=document.forms[0].Autozoom.value+"?m_cAction=query"}else{history.back()}';
}
function LoadChildrenInPage(page) {
if (page=='page_2' && ChildToLoad('ZoomOnZoomFrame')) {
var url=CtrlByName("Linkzoomprg").value+'?m_cWindowName=ZoomOnZoomFrame&m_cAction='
url+=newClick.n?'new&'+CtrlByName("FixedFilterURL").value:'query'
windowOpenForeground(url,'',null,null,null,Ctrl('ZoomOnZoomFrame').contentWindow.document)
}
}
function newClick(){
if(Empty(CtrlByName("LinkedField").value)){
DoAutoZoom("","new",["","","","","","","","","","","","","","","","","","","","","","","","","","","",])
}else{
try{
newClick.n=true
tabs.Select('page_2')
}finally{
newClick.n=false
}
}
}
newClick.n=false
function NewButton(doc,title){
doc.writeln("<a href='javascript:newClick();'><img title='"+title+"' alt='Button NEW' src='"+imgCached[0].src+"' align='right' border=0></a>")
}
function New() {
  cacheImgs(tlbQuery_Images);
}
function cacheImgs(p_aImgs) {
  for(var i=0;i<p_aImgs.length;i++){
    imgCached[i]=new Image();
    imgCached[i].src=p_aImgs[i];
  }
}
var _selRow;
function SelectRow(sel){
	if(!parent.ZtVWeb) return;
	var rowIdx=sel.rowIndex-1
	if(sel!=_selRow && IsA(window['row'+rowIdx+'pkclick'],'F')){
		if(_selRow)
			LibJavascript.CssClassNameUtils.removeClass(_selRow,'SelectedRow');
		_selRow=sel;
		LibJavascript.CssClassNameUtils.addClass(_selRow,'SelectedRow');
		window['row'+rowIdx+'pkclick']('event');
	}
}
function RaiseEvent(){
	if(!parent.ZtVWeb) return;
	var evtParms={}
	var inputs=document.forms[1].getElementsByTagName('INPUT')
	for(var i=0,inp;inp=inputs[i++];){
		if(inp.type=='hidden'){
			evtParms[inp.name]=inp.value;
		}
	}
  parent.ZtVWeb.raiseEvent(document.forms[0].Autozoom.value.toLowerCase()+'_zoomSelectedRow',evtParms)
}
