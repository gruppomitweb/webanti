<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.PortalStudio.*"%>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.sitepainter.Library"%>
<%@ page import="java.util.Properties"%>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples","")) || sp.CanModifyOwnQuery()) {
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" media="screen"
	href="treedrawfile/treeExplainQuery.css" />
<title>SQL Analyze</title>
<script src="../<%=SPPrxycizer.proxycizedPath("raphael.js")%>" charset="UTF-8"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/RaphaelAdapter.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/RaphaelZPDAdapter.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/showInfo.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/logicNode.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/graphicNode.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/baseTree.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/classicTree.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/mixedTree.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/verticalTree.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/scrollbarSVG.js")%>" charset="cp1252"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualquery/treedrawfile/drawTree.js")%>" charset="cp1252"></script>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>

</head>
<body>
	<div id="explainquerycontainer">attendere risposta del server...
	</div>
	<div id="info">
		<ul id="menu">
			<li id="l0"><a id="c0" href="#">Green</a>
				<ul>
					<li id="d0">
					<b>Safe operation</b>
					<br>Its cost is directly proportional
					<br>to the number of records returned</li>
				</ul></li>
			<li id="l1"><a id="c1" href="#">Yellow</a>
				<ul>
					<li id="d1">
					<b>Potentially dangerous</b>
          <br>It creates temporary resources.
					<br>If  there is sufficient memory its cost is directly
					<br>proportional to the number of record returned
					<br>otherwise to the number of records in the DB.
					<br>It may be a source of eccessive cost</li>
				</ul></li>
			<li id="l2"><a id="c2" href="#">Red</a>
				<ul>
					<li id="d2">
					<b>Dangerous operation</b>
					<br>Its cost  is directly proportional on the number
					<br>of records in the DB.
					<br>To avoid as a source of excessive cost</li>
				</ul></li>
			<li id="l3"><a id="c3" href="#">Blue</a>
				<ul>
					<li id="d3">
					<b>Depending operation</b>
					<br>Its result is not related with
					<br>the number of records returned,
					<br>it needs its associated operations
					<br>for being evaluated</li>
				</ul></li>
			<li id="l4"><a id="c4" href="#">Pink</a>
				<ul>
					<li id="d4">
					<b>Not dangerous</b>
					<br>Its cost depends on the number of records
					<br>in the DB, but on a table that has few data by design</li>
				</ul></li>
			<li id="l5"><a id="c5" href="#">Gray</a>
				<ul>
					<li id="d5">
					<b>Undefined</b>
					<br>Its cost is unknown because
					<br>the operation hasn't been recognized</li>
				</ul></li>
		</ul>
	</div>

</body>
<script>

		//per internet Explorer 8 o inferiore non hanno indexOf (array) e trim (per pulizia stringhe
		if(!Array.indexOf){
			Array.prototype.indexOf = function(obj){
				for(var i=0; i<this.length; i++){
					if(this[i]==obj){
						return i;
					}
				}
				return -1;
			};
		}
		if(!String.trim) {
			String.prototype.trim = function() {
				return this.replace(/^\s+|\s+$/g, "");
			};
		}
		<%
			Properties params = Library.GetProperties(request.getParameter("m_cParams"));
      String cNumParams = params.getProperty("Rows");
			if(Library.Empty(cNumParams)) {
				cNumParams = "0";
			}
			int nNumParams = (int)Library.Val(cNumParams);
			String paramsValue = "var paramsValue=[";
			String paramsName = "var paramsName=[";
			String sep="";
			for(int i=0;i<nNumParams;i++) {
        paramsName+=sep+"\""+Library.GetProperty(params,"field","",i)+"\"";
        paramsValue+=sep+"\""+request.getParameter(Library.GetProperty(params,"field","",i))+"\"";
				sep=",";
			}
      paramsName+="];";
      paramsValue+="];";
      out.print(paramsName);
      out.print(paramsValue);
    %>

		var params="";
		for (var i=0; i<paramsName.length; i++){
			params+="&"+paramsName[i]+"="+URLenc(paramsValue[i]);
		}

		var responseJSON = new JSURL("../servlet/SPVQRProxy?m_cWv="+
				URLenc('<%=JSPLib.ToJSValue(request.getParameter("m_cWv"))%>')+
				"&m_cParams="+URLenc('<%=JSPLib.ToJSValue(request.getParameter("m_cParams"))%>')+
				"&m_cAction="+URLenc('<%=JSPLib.ToJSValue(request.getParameter("m_cAction"))%>')
				+ params, true);
	var JSONObj = responseJSON.Response();
	// dopo aver ricevuto la risposta dal server cancello ciò che e' presente nel body e poi creo
	// i vari oggetti
	// document.body.innerHTML = "";

	var corpo = document.getElementById("explainquerycontainer");
	corpo.innerHTML = "";
	var divPadre = document.createElement("div");
	divPadre.setAttribute("id", "toolbar");
	corpo.appendChild(divPadre);

	var menuSelect = document.createElement("select");
	menuSelect.setAttribute("id", "choiceMenu");
	divPadre.appendChild(menuSelect);

	var opzione = document.createElement("option");
	opzione.setAttribute("value", "Classico");
	opzione.innerHTML = "Classic";
	opzione.setAttribute("selected", "selected");
	menuSelect.appendChild(opzione);
	opzione = document.createElement("option");
	opzione.setAttribute("value", "Misto");
	opzione.innerHTML = "Mixed";
	menuSelect.appendChild(opzione);
	opzione = document.createElement("option");
	opzione.setAttribute("value", "Verticale");
	opzione.innerHTML = "Vertical";
	menuSelect.appendChild(opzione);

	var button = document.createElement("input");
	button.setAttribute("type", "button");
	button.setAttribute("value", "Draw Tree");
	button.setAttribute("selected", "selected");
	button.setAttribute("id", "drawTree");
	divPadre.appendChild(button);

	var divButton = document.createElement("div");
	divButton.setAttribute("id", "divButton");
	divPadre.appendChild(divButton);

	var buttonTollbar = [], tooltipButton = [ 'Zoom in', 'Zoom out',
			'Move left', 'Move up', 'Move down', 'Move right' ],
      imgButton=[String.fromCharCode(parseInt("e680;",16)),String.fromCharCode(parseInt("e681;",16)),String.fromCharCode(parseInt("e72a;",16)),String.fromCharCode(parseInt("e72c;",16)),String.fromCharCode(parseInt("e728;",16)),String.fromCharCode(parseInt("e72e;",16))];
	if (document.implementation.hasFeature(
			"http://www.w3.org/TR/SVG11/feature#BasicStructure", "1.1")) {
		for ( var i = 0; i < 6; i++) {
			buttonTollbar[i] = document.createElement("span");
			buttonTollbar[i].setAttribute("id", "button" + i);
			buttonTollbar[i].setAttribute("class", "button");
			buttonTollbar[i].setAttribute("title", tooltipButton[i]);
      buttonTollbar[i].innerHTML=imgButton[i];
			divButton.appendChild(buttonTollbar[i]);
		}
	}

	var divInfo = document.createElement("div");
	divInfo.setAttribute("id", "divInfo");

	corpo.appendChild(divInfo);

	var colorsTollbar = [], tooltipColors = [ 'Green', 'Yellow', 'Red', 'Blue',
			'Pink', 'Gray' ];
	var codeColor = [ '#00CC00', '#f9f006', '#ff0000', '#0000ff', '#ff66a7',
			'#666666' ];
	var codeColorBack = [ '#ECFAEC', '#FFFFEA', '#FFEFEF', '#E5E5FF',
			'#FFECF4', '#E7E7E7' ];
	var numColors = [];

	var color = document.createElement("ul");
	color.setAttribute("id", "color");
	var empty = document.createElement("li");
	empty.setAttribute("id", "empty");
	empty.setAttribute("style", "color:white;");
	var emptyText = document.createTextNode(".");
	empty.appendChild(emptyText);
	color.appendChild(empty);

	for ( var i = 0; i < 6; i++) {
		document.getElementById("l" + i).setAttribute(
				"style", "border-color:" + codeColor[i] + "; background-color:" + codeColorBack[i]);
		/*document.getElementById("c"+i).setAttribute("style", "a:hover{background-color:" + codeColor[i]
			+ "}");*/
		document.getElementById("d" + i).setAttribute(
				"style", "border-color:" + codeColor[i] + "; background-color:"+ codeColorBack[i]);
		//var text = document.createTextNode(" (ok)");
		//document.getElementById("c"+i).appendChild(text);
	}

	divInfo.appendChild(color);

	var divSpazioGrafico = document.createElement("div");
	divSpazioGrafico.setAttribute("id", "spazioPerGrafico");
	corpo.appendChild(divSpazioGrafico);

	var scrollH = document.createElement("div");
	scrollH.setAttribute("id", "scrollbarHorizontal");
	corpo.appendChild(scrollH);

	var scrollV = document.createElement("div");
	scrollV.setAttribute("id", "scrollbarVertical");
	corpo.appendChild(scrollV);

	//dopo aver creato i vari elementi disegno
	if (JSONObj.length == 0)
		alert("Il plan della query \350 vuoto");
	else if (JSONObj.indexOf("ACCESS DENIED") != -1)
		alert("Non hai le credenziali d'accesso");
	else {
		var JSONObj = eval('(' + JSONObj + ')');
		var disegnatore = new CreaAlbero();
		disegnatore.init(JSONObj);

		disegnatore.ridisegnaAlbero("choiceMenu", "spazioPerGrafico", true);

		//inserisco il numero di nodi per ogni colore
		var green = disegnatore.green;
		var text = document.createTextNode(" (" + green + ")");
		document.getElementById("c" + 0).appendChild(text);
		var yellow = disegnatore.yellow;
		var text = document.createTextNode(" (" + yellow + ")");
		document.getElementById("c" + 1).appendChild(text);
		var red = disegnatore.red;
		var text = document.createTextNode(" (" + red + ")");
		document.getElementById("c" + 2).appendChild(text);
		var blue = disegnatore.blue;
		var text = document.createTextNode(" (" + blue + ")");
		document.getElementById("c" + 3).appendChild(text);
		var pink = disegnatore.pink;
		var text = document.createTextNode(" (" + pink + ")");
		document.getElementById("c" + 4).appendChild(text);
		var gray = disegnatore.gray;
		var text = document.createTextNode(" (" + gray + ")");
		document.getElementById("c" + 5).appendChild(text);

		button.onclick = function() {
			disegnatore.ridisegnaAlbero("choiceMenu", "spazioPerGrafico", true);
		};
		if (document.implementation.hasFeature(
				"http://www.w3.org/TR/SVG11/feature#BasicStructure", "1.1")) {
			buttonTollbar[0].onclick = function() {
				disegnatore.zoomTree(-5);
			};
			buttonTollbar[1].onclick = function() {
				disegnatore.zoomTree(5);
			};
			buttonTollbar[2].onclick = function() {
				disegnatore.moveTree(50, 0);
			};
			buttonTollbar[3].onclick = function() {
				disegnatore.moveTree(0, 50);
			};
			buttonTollbar[4].onclick = function() {
				disegnatore.moveTree(0, -50);
			};
			buttonTollbar[5].onclick = function() {
				disegnatore.moveTree(-50, 0);
			};
		}
	}
</script>

</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
