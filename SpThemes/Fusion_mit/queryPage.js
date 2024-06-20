document.writeln("<script src='../"+m_cThemePath+"/formTitle.js' type='text/javascript'></script>");
document.writeln("<script src='../"+m_cThemePath+"/queryPageImpl.js' type='text/javascript'></script>");

//***********************************************************************
//                   Configuration variables:
var FormName='queryPage';
//***********************************************************************
function WriteBody_Begin(doc,events,height,addTitle,addToolbar){
  if (addTitle==null) addTitle=true;
  //Se la pagina e' nel frame menu bisogna cambiarne le impostazioni(Titolo e backkground)
  doc.writeln("<BODY "+events+" onresize='DoOnResize()' style='margin:0;padding:0;overflow:hidden'>");
  PrepareJsCalendar();
  doc.writeln("<TABLE border='0' width='100%' height='100%' cellpadding='0' cellspacing='0'>");
  if(window.name=='main'){
    if(addTitle){
      doc.writeln("<TR>");
      doc.writeln("<TD id='titleTD' valign='top' style='width:0;height:0'>");
      Title(doc);
      doc.writeln("</TD>");
      doc.writeln("</TR>");
    }
  }
  doc.writeln("<TR>");
  doc.writeln("<TD id='mainTD' valign='top' style='width:100%;height:100%'>");
  doc.writeln("<DIV id='bodyDiv' style='overflow:auto;width:0;height:0'>");
}
function DoOnResize() {
  adjustWidthAndHeight();
  if(typeof(AdjustOnResize)!='undefined')
    AdjustOnResize();
}
function adjustWidthAndHeight(){
  var titH,mainHeight;
  titH=Ctrl('titleTD')==null ? 0 : Ctrl('titleTD').offsetHeight;
  Ctrl('bodyDiv').style.width=document.body.clientWidth>0 ? document.body.clientWidth : document.body.offsetWidth;
  Ctrl('bodyDiv').style.height=0;
  var mainHeight=(document.body.clientHeight>0 ? document.body.clientHeight : document.body.offsetHeight)-titH;
  Ctrl('bodyDiv').style.height=mainHeight;
  if(Ctrl('scrollDiv')!=null){
    var updH=Ctrl('TblUpdateBtn')!=null?Ctrl('TblUpdateBtn').clientHeight:0;
    var headerH=Ctrl('header')!=null?parseInt(Ctrl('header').style.height):0;
    var footerH=Ctrl('pageFooter')!=null?parseInt(Ctrl('pageFooter').style.height):0;
    Ctrl('scrollDiv').style.width = Ctrl('bodyDiv').style.width;
    Ctrl('scrollDiv').style.height = Max(1,mainHeight-footerH-headerH-titH-updH);
    Ctrl('bodyBegin').style.width=parseInt(Ctrl('scrollDiv').style.width)-18;
  }
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
  var dpi_controller=Ctrl("dpi_controller");
  try{
    if(dpi_controller.clientHeight>13) AdjustFontSize(dpi_controller.clientHeight/13);
  }catch(e){}
  DoOnResize();
}
function Header_BeginHtml(height){
  document.writeln("<DIV id='header' style='position:relative;height:"+height+"'>");
}
function Header_EndHtml(){
  document.writeln("</DIV>");
}
function Footer_BeginHtml(height){
  document.writeln("<DIV id='pageFooter' style='position:relative;height:"+height+"'>");
}
function Footer_EndHtml(){
  document.writeln("</DIV>");
}
