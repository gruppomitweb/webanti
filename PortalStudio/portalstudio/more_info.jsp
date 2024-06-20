<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><!doctype html>
<html>
	<head>
		<script type="text/javascript" src="../visualweb/mootools-core.js"></script>
		<script type="text/javascript" src="../visualweb/mootools-more.js"></script>
		<script type="text/javascript" src="../stdFunctions.js"></script>
		<script type="text/javascript" src="../controls.js"></script>
		<script type="text/javascript" src="../propertiesDescriptions.js"></script>
		<link rel="stylesheet" href="../filewindow.css" type="text/css">
		<%
		Sitepainter sp = new Sitepainter(request);
		sp.setContentType(response);
		%>

		<script type="text/javascript">
			function getOpener(){
				return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));
			}

			function CloseWindow(){
				if (window.closeFrame)
					closeFrame();
				else if (!Empty(SPModalLayerId))
					getOpener().closeSPModalLayer();
				else
					window.close();
			}

			var tool = null;
			var objName = null;
			var SPModalLayerId = null;
			var propID = null;
			var propDesc = null;
			var propName = null;

			function Init(){
				tool = '<%=JSPLib.ToJSValue(sp.getParameter("tool",""))%>';
				objName = '<%=JSPLib.ToJSValue(sp.getParameter("objName",""))%>';
				propID = '<%=JSPLib.ToJSValue(sp.getParameter("propID",""))%>';
				propName = '<%=JSPLib.ToJSValue(sp.getParameter("propName",""))%>';

				SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';

				insertDesc();
			}

			function insertDesc(){
				propDesc = getPropertyDescriptionObj(tool,objName.toLowerCase(),propID);

				document.id("descTitle").textContent=propName.toUpperCase();

				var stringDesc;
				if(!Empty(propDesc.desc)){
					stringDesc = new Element('div',{
							html : propDesc.desc,
							'class' : 'descStringDiv'
						});
				}

				var stringLink,divFormat;
				if(!Empty(propDesc.link)){
					stringLink = new Element('div',{
							html : "More info...",
							'class' : 'descStringLinkDiv'
					})
					.setStyles({
						'position': 'absolute',
						'bottom': '0px',
						'right': '20px',
						'textDecoration': 'underline'
					});

					divFormat = new Element('a',{
						href : propDesc.link,
						target : "_blank"
					})
					.adopt(stringLink);
				}

				document.id('descriptions')
					.adopt(stringDesc)
					.adopt(divFormat);

			}
		</script>
		<style type="text/css">
			.contenuto {
				border : 0px;
			}
		</style>
	</head>

	<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4;" onload="Init()">
		<div border="1" width="100%" cellpadding="0">
			<div id="title" style="width:100%;">
				<div id="descTitle" class="titoli" align="center" onselectstart="return false" style="height:15px;"><b></b></div>
			</div>
			<div id="descriptions" class="contenuto" style="position:absolute;top:28px;overflow:auto;width:100%;height:70%;">
			</div>
			<div style="width:100%;position:absolute;bottom:0">
				<div class="footer" height="20" valign="middle" align="center" nowrap >
					<button onclick="CloseWindow()" accesskey="i" class="bottoni"><u>O</u>k</button>
				</div>
			</div>
		</div>
	</body>
</html>
