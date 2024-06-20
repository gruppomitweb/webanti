writeToolbar();

var pgCountObj=document.getElementById('pgTotal')
function printPage(){window.print() ;}
function gotoPage(){
var v=document.getElementById('pgCount').value
var o=document.getElementById('pg'+v);
ScrollTo(o,v);
}
function ScrollTo(o,v) {
if(o!=null) {
	o.scrollIntoView();
	document.getElementById('pgCount').value=v
	enableCtrl();
} else {
	alert('Pagina non trovata')
}
}
function goFirst(){
var o=document.getElementById('pg1');
ScrollTo(o,1);
}
function goPrev(){
var v=parseFloat(document.getElementById('pgCount').value)-1
var o=document.getElementById('pg'+v);
ScrollTo(o,v);
}
function goLast(){
var v=document.getElementById('pgTotal').value
var o=document.getElementById('pg'+v);
ScrollTo(o,v);
}
function goNext(){
var v=parseFloat(document.getElementById('pgCount').value)+1
var o=document.getElementById('pg'+v);
ScrollTo(o,v);
}
function fillpagenum(i){
  pgCountObj.value=i
}
function enableCtrl() {
	var page=document.getElementById('pgCount').value
	var totalPage=document.getElementById('pgTotal').value
	document.getElementById('btnPrint').disabled=false
	if (page==totalPage) {
		document.getElementById('btnFirst').disabled=false
		document.getElementById('btnPrev').disabled=false
		document.getElementById('btnNext').disabled=true
		document.getElementById('btnLast').disabled=true
	} else if (page==1) {
		document.getElementById('btnFirst').disabled=true
		document.getElementById('btnPrev').disabled=true
		document.getElementById('btnNext').disabled=false
		document.getElementById('btnLast').disabled=false
	} else {
		document.getElementById('btnFirst').disabled=false
		document.getElementById('btnPrev').disabled=false
		document.getElementById('btnNext').disabled=false
		document.getElementById('btnLast').disabled=false
	}
}

function writeToolbar() {
document.write("<div class='toolbar'>");
document.write("<table cellpadding=0 cellspacing=0 ><tr><td>");
document.write("&nbsp;</td><td>");
document.write("<table cellpadding=0  cellspacing=0><tr><td>");
document.write("<div style='border-left: solid 1px #666666;'><div style='border-left: solid 1px #FFFFFF;height:1px'></div></div>");
document.write("</td><td>");
document.write("<div style='border-left: solid 1px #666666;'><div style='border-left: solid 1px #FFFFFF;'>&nbsp;</div></div>");
document.write("</td><td>");
document.write("<input id='btnPrint' type='image' value='Print' src='../"+theme+"/toolbar/printer.gif' alt='Print' border=0 onclick='javascript:printPage()' disabled>");
document.write("</td></tr></table></td>");
document.write("<td>&nbsp;</td><td valign='middle' >");
document.write("<table cellpadding=0  cellspacing=0><tr><td>");
document.write("<div style='border-left: solid 1px #666666;'><div style='border-left: solid 1px #FFFFFF;'>&nbsp;</div></div>");
document.write("</td><td>");
document.write("<input id='btnFirst' type='image' value='First' src='../"+theme+"/toolbar/first.gif' alt='First' border=0 onclick='javascript:goFirst()' disabled>");
document.write("<input id='btnPrev' type='image' value='Prev' src='../"+theme+"/toolbar/prev.gif' alt='Prev' border=0 onclick='javascript:goPrev()' disabled>");
document.write("<input type=text id='pgCount' value='1' size=4>");
document.write("<input type=text id='pgTotal' value='1' disabled size=4>");
document.write("<input id='btnNext' type='image' value='Next' src='../"+theme+"/toolbar/next.gif' alt='Next' border=0 onclick='javascript:goNext()' disabled>");
document.write("<input id='btnLast' type='image' value='Last' src='../"+theme+"/toolbar/last.gif' alt='Last' border=0 onclick='javascript:goLast()' disabled>");
document.write("</td></tr></table></td>");
document.write("<td>&nbsp;</td>");
document.write("<td valign='middle'>");
document.write("<table cellpadding=0  cellspacing=0><tr><td>");
document.write("<div style='border-left: solid 1px #666666;'><div style='border-left: solid 1px #FFFFFF;'>&nbsp;</div></div>");
document.write("</td><td>");
document.write("<input id='btnGo' type='image' value='Goto...' src='../"+theme+"/toolbar/goto.gif' alt='Goto...' border=0 onclick='javascript:gotoPage()'>");
document.write("</td></tr></table>");
document.write("</td></tr></table>");
document.write("</div>");
}

function openW(URL,style) {
windowOpenForeground(URL,'',style)
}

