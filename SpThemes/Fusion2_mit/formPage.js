//Name:Classic
//Title on top (fix)
//Toolbar under title (fix)
//Body scrolling

document.writeln("<SCRIPT src='../"+m_cThemePath+"/formTitle.js' type='text/javascript'></SCRIPT>");
document.writeln("<SCRIPT src='../"+m_cThemePath+"/toolbar.js' type='text/javascript'></SCRIPT>");

//***********************************************************************
//                   Configuration variables:
var imagePath='formPage';
var FormName='FormPage';
//***********************************************************************
function WriteBody_Begin(doc,events,height,addTitle,addToolbar){
  if(addTitle==null) addTitle=true;
  if(addToolbar==null) addToolbar=true;
  doc.writeln("<BODY "+events+" onresize='adjustWidthAndHeight()' style='margin:0;padding:0;overflow:hidden'>");
  //Must be called inside BODY tag for Mozilla compatibility
  PrepareJsCalendar(true);
  doc.writeln("<TABLE border='0' width='100%' height='100%' cellpadding='0' cellspacing='0'>");
  if(addTitle && Ne(window.name,'ZoomOnZoomFrame')){
    doc.writeln("<TR>");
    doc.writeln("<TD id='titleTD' valign='top' style='width:0;height:0'>");
    Title(doc);
    doc.writeln("</TD>");
    doc.writeln("</TR>");
  }
  if(addToolbar){
    doc.writeln("<TR>");
    doc.writeln("<TD id='toolbarTD' valign='top' style='width:0;height:0'>");
    Toolbar(doc);
    doc.writeln("</TD>");
    doc.writeln("</TR>");
  }
  doc.writeln("<TR>");
  doc.writeln("<TD id='mainTD' valign='top' style='width:100%;height:100%'>");
  doc.writeln("<DIV id='bodyDiv' style='overflow:auto;width:0;height:0'>");
}
function WriteBody_EndHtml(doc,addToolbar){
  doc.writeln("</DIV>");
  doc.writeln("</TD>");
  doc.writeln("</TR>");
  doc.writeln("</TABLE>");
}
function WriteBody_End(doc){
  doc.writeln("<NOSCRIPT>JavaScript required to see this page</NOSCRIPT>");
  doc.writeln("<SPAN id='dpi_controller' style='position:absolute;top:0;left:0;font-family:verdana;font-size:8pt;visibility:hidden'>0</SPAN>");
  doc.writeln("</BODY>");
  var dpi_controller=Ctrl('dpi_controller');
  try{
    if(dpi_controller.clientHeight>13) AdjustFontSize(dpi_controller.clientHeight/13);
  }catch(e){}
  if(Eq(window.name,'ZoomOnZoomFrame')) {
    SetWindowPreferredSize(false,false);
  }
  else if(typeof(m_nChildStatus)!='undefined' && m_nChildStatus==1 &&
          typeof(sv_ChildAutoResize)!='undefined' && sv_ChildAutoResize) {
    SetWindowPreferredSize(true,typeof(sv_ChildAutoCenter)!='undefined' && sv_ChildAutoCenter);
  }
  else if(opener && typeof(sv_WindowAutoResize)!='undefined' && sv_WindowAutoResize &&
          (m_cFunction=='query' || m_cFunction=='edit' || m_cFunction=='new' || m_cFunction=='view')) {
    SetWindowPreferredSize(true,typeof(sv_WindowAutoCenter)!='undefined' && sv_WindowAutoCenter);
  }
  adjustWidthAndHeight(true);
}
function adjustWidthAndHeight(calculatePreferredHeight){
  var titH,tlbH,mainHeight,tabStripH;
  titH=Ctrl('titleTD')==null ? 0 : Ctrl('titleTD').offsetHeight;
  tlbH=Ctrl('toolbarTD')==null ? 0 : Ctrl('toolbarTD').offsetHeight;
  tabStripH=Ctrl('tabStripTable')==null ? 0 : Ctrl('tabStripTable').offsetHeight+2;
  Ctrl('bodyDiv').style.width=document.body.clientWidth>0 ? document.body.clientWidth : document.body.offsetWidth;
  Ctrl('bodyDiv').style.height=0;
  var mainHeight=(document.body.clientHeight>0 ? document.body.clientHeight : document.body.offsetHeight)-(titH+tlbH);
  if(mainHeight>0) Ctrl('bodyDiv').style.height=mainHeight;
  //Calcola l'altezza esatta del form compreso Title e Toolbar assegnando il valore
  //alla variabile JS genertata dalla servlet
  if(calculatePreferredHeight && typeof(m_nPreferredHeight)!='undefined'){
    m_nPreferredHeight=m_nPreferredHeight+titH+tlbH+tabStripH;
  }
}
