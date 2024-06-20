<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><!doctype html>
<html>
	<head>
		<script type="text/javascript" src="../visualweb/mootools-core.js"></script>
		<script type="text/javascript" src="../visualweb/mootools-more.js"></script>
		<script type="text/javascript" src="../stdFunctions.js"></script>
		<script type="text/javascript" src="../controls.js"></script>
		<script>
			if (typeof ZtChart == 'undefined') {
				function ZtChart () {
				}
			}
		</script>
		<script type="text/javascript" src="../ZtChartTransDict.js"></script>
		<link rel="stylesheet" href="../filewindow.css" type="text/css">
		<%
		Sitepainter sp = new Sitepainter(request);
		sp.setContentType(response);
		%>

		<script type="text/javascript">
			function getOpener(){
				return GetOpener();//(window.opener ? window.opener : (window.caller ? window.caller : window.parent));
			}

			function CloseWindow(){
				if (window.closeFrame)
					closeFrame();
				else if (!Empty(SPModalLayerId))
					getOpener().closeSPModalLayer();
				else
					window.close();
			}

			var objIdx = null;
			var valueObject = null;
			var SPModalLayerId = null;
			var acceptedFormat = "";
			var m_bUpdated = false;
			var isType = null;
			var titleDiv = null;
			var chartType = null;

			function Init(){
				objIdx = '<%=JSPLib.ToJSValue(sp.getParameter("objIdx",""))%>';
				valueObject = '<%=JSPLib.ToJSValue(sp.getParameter("ExpressionValue",""))%>';
				SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
				isType = CharToBool('<%=JSPLib.ToJSValue(sp.getParameter("isType",""))%>');
				titleDiv = '<%=JSPLib.ToJSValue(sp.getParameter("titleDiv",""))%>';
				chartType = '<%=JSPLib.ToJSValue(sp.getParameter("chartType",""))%>';

				if (isType)
					acceptedFormat = getOpener().GetAvailableChartTypes()[chartType];
				else
					acceptedFormat = getOpener().GetAvailableDownloadFormat();

				document.id("dChartTitle").textContent=titleDiv.replace(/_/g," ");

				designFormats();
				InitFormats();
			}

			function InitFormats(){
				if(!Empty(valueObject)){
					var outputValue = '';
					var found;
					outputListArray = valueObject.split(',');
					for (var i = 0; i < outputListArray.length; i++){
						//Gestito caso in cui l'utente modifica a mano il valore e lo scrive con il case sbagliato
						outputValue = LRTrim(outputListArray[i]);//.toUpperCase();
						//Gestito caso della stringa vuota
						if (outputValue != ''){
							found = searchFormat(outputValue);
							if (found)
								document.id("output_" + outputValue.toLowerCase()).checked = true;
							else
								alert(outputValue + ": Format not accepted.");
						}
					}
				}
			}

			function searchFormat(output){
				if (isType)
					return acceptedFormat.indexOf(output) >= 0;
				for (i = 0; i < acceptedFormat.length; i++){
					if (acceptedFormat[i][0] == output)
						return true;
				}
				return false;
			}

			function designFormats(){
				var i = 0,
				title = "",
				value = "";
				for (i = 0; i < acceptedFormat.length; i++) {
					if (isType) {
						value = acceptedFormat[i];
						title = ZtChartDict.Translate("ZTC_" + value).eng;
					}
					else {
						title = acceptedFormat[i][1],
						value = acceptedFormat[i][0];
					}
					var checkboxFormat = new Element('input',{
						'id' : "output_" + value.toLowerCase(),
						type : 'checkbox',
						title : title,
						value : value
					});
					checkboxFormat.addEvent('click', function (){
						SetUpdated();
					});
					var labelFormat = new Element('span',{
						html : title,
						'class' : '',
						style : {
							'paddingLeft' : '0px'
						},
						title : title
					});
					var divFormat = new Element('div',{
						style : 'border-bottom: 1px solid #676767;'
					}).adopt(checkboxFormat).adopt(labelFormat);
					document.id('formatList').adopt(divFormat);
				}
			}

			function ReturnExpression(){
				if (m_bUpdated){
					valueObject = "";
					var selectedOutput = document.id('formatList').getChildren();
					var output = null;
					var i;
					for (i = 0; i < selectedOutput.length; i++){
						output = selectedOutput[i].getChildren();
						if (output[0].checked)
							valueObject += output[0].value + ",";
					}
					//Elimino la virgola finale
					valueObject = Substr(valueObject, 1, RAt(",", valueObject) - 1);
					getOpener().downloadChartReturn(objIdx, valueObject, isType);
					m_bUpdated = false;
				}
				CloseWindow();
			}

			function SetUpdated(){
				m_bUpdated = true;
			} // SetUpdated

			function Unload(){
				if (m_bUpdated) {
					if (confirm("Selection has been modified. Save changes before closing?"))
						getOpener().removeOutputReturn(objIdx, valueObject);
				}
			} //Unload
		</script>
		<style type="text/css">
			.contenuto {
				border : 0px;
			}
		</style>
	</head>

	<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4;" onload="Init()" onunload="Unload()">
		<div border="1" width="100%" cellpadding="0">
			<div id="title" style="width:100%;">
				<div id="dChartTitle" class="titoli" align="center" onselectstart="return false" style="height:15px;"><b></b></div>
			</div>
			<div id="formatList" class="contenuto" style="position:absolute;top:28px;overflow:auto;width:100%;height:70%;">
			</div>
			<div style="width:100%;position:absolute;bottom:0">
				<div class="footer" height="20" valign="middle" align="center" nowrap >
					<button onclick="ReturnExpression()" accesskey="i" class="bottoni"><u>I</u>nsert</button>&nbsp;
					<button onclick="CloseWindow()" accesskey="c" class="bottoni"><u>C</u>ancel</button>
				</div>
			</div>
		</div>
	</body>
</html>
