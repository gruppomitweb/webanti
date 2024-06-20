<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><!doctype html>
<html style="height:100%;">
	<head>
		<script type="text/javascript" src="../visualweb/mootools-core.js"></script>
		<script type="text/javascript" src="../visualweb/mootools-more.js"></script>
		<script type="text/javascript" src="../stdFunctions.js"></script>
		<script type="text/javascript" src="../controls.js"></script>
		<script src="../portalstudio/jscolor/jscolor.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" media="screen" title="default" href="../properties.css"></link>
		<link rel="stylesheet" type="text/css" media="screen" title="default" href="../filewindow.css"></link>

		<link rel="stylesheet" type="text/css" href="../AdditionalFonts.css" />

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

			var objIdx = null;
			var separator = null;
			var SPModalLayerId = null;
			var callerFunction = null;
			var font = null;
			var m_bUpdated = false;
			var availableFonts =	[	{name: "Arial",	family: "'Arial','DejaVu Sans'", other: true},
										{name: "Arial Black", family: "'Arial Black','DejaVu Sans'", other: true},
										{name: "Comic Sans MS", family: "'Comic Sans MS','DejaVu Sans'", other: true},
										{name: "Courier", family: "'Courier','DejaVu Sans'", other: true},
										{name: "DejaVu Sans", family: "'DejaVu Sans'", other: false},
										{name: "DejaVu Serif", family: "'DejaVu Serif'", other: false},
										{name: "Digital System", family: "'Digital System'", other: false},
										{name: "Electronic Highway Sign", family: "'Electronic Highway Sign'", other: false},
										{name: "Georgia", family: "'Georgia','DejaVu Sans'", other: true},
										{name: "JD LCD Rounded Regular", family: "'JD LCD Rounded Regular'", other: false},
										{name: "Lets go Digital", family: "'Lets go Digital'", other: false},
										{name: "Liquid Crystal", family: "'Liquid Crystal'", other: false},
										{name: "Lucida Sans", family: "'Lucida Sans','DejaVu Sans'", other: true},
										{name: "NovaMono", family: "'NovaMono'", other: false},
										{name: "Open Sans", family: "'Open Sans'", other: false},
										{name: "Share Tech Mono", family: "'Share Tech Mono'", other: false},
										{name: "Source Code Pro", family: "'Source Code Pro'", other: false},
										{name: "Tahoma", family: "'Tahoma','DejaVu Sans", other: true},
										{name: "Times New Roman", family: "'Times New Roman','DejaVu Sans'", other: true},
										{name: "Ubuntu", family: "'Ubuntu'", other: false},
										{name: "Verdana", family: "'Verdana','DejaVu Sans", other: true},
										{name: "VT323", family: "'VT323'", other: false}
									];
			var availableStyles = 	[	{text:"Normal", val:"N"},
										{text:"Bold", val:"B"},
										{text:"Italic", val:"I"},
										{text:"Bold Italic", val:"BI"}
									];
			var textLetter = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
			var textNumber = "0123456789";
			var textSpecialChar = "! \" # $ % & \' ( ) * + , - . / : ; < = > ? @ [ ] _ \\ "+unescape("\u20AC");
			var textOtherFont = "*note that in the event of non-attendance of the font, will be applied by default DejaVu Sans";
			var fontObj = {};
			var typeF = null;

			function Init(){
				objIdx = '<%=JSPLib.ToJSValue(sp.getParameter("objIdx",""))%>';
				separator = '<%=JSPLib.ToJSValue(sp.getParameter("separator",""))%>';
				SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
				callerFunction = '<%=JSPLib.ToJSValue(sp.getParameter("callerFunction",""))%>';
				fontFunc = '<%=JSPLib.ToJSValue(sp.getParameter("fontFunc",""))%>';
				typeF = '<%=JSPLib.ToJSValue(sp.getParameter("type",""))%>';

				var receiverObj;

				if (objIdx == "null") objIdx = null;
				if (objIdx!=null){
					receiverObj=getOpener().itemsHTML[objIdx];
				}
				else {
					receiverObj=getOpener().formProp;
				}

				fontObj = 	{	name: receiverObj[fontFunc]().split(separator)[0],
								size: receiverObj[fontFunc]().split(separator)[1],
								color: receiverObj[fontFunc]().split(separator)[2],
								style: receiverObj[fontFunc]().split(separator)[3]
							};

				setSpecsFontDiv();
				setFontDiv();

			}

			function setSpecsFontDiv(){
				var opt;
				var label =  new Element("span",{
					id:			"label_size",
					html:		"Preview size:",
					styles: {
								fontFamily:	"Arial,sans-serif",
								fontSize:	"13px",
								lineHeight:	"1.2",
								color: 		"#000000",
								paddingLeft: "50px"
							},
					title : "size"
				});

				var input = new Element("select",{
					id:		"select_size",
					styles: {
								paddingLeft: "5px",
								width:		"60px",
								marginLeft:	'10px'/*,
								position:	"absolute",
								top:	"1.5px",
								left:	"60px"
								paddingLeft: "50px"*/
							},
					events:	{
								change: 	function(){
												fontObj.size = this.value;
												document.getElements(".textFont").setStyle("fontSize", this.value+"px");
												return;
											}
							}
				});

				document.id("specsfontdiv")
					.adopt(label)
					.adopt(input);

				for(var i=24; i<37; i=i+2){
					opt = new Element("option",{
						value:	i,
						text:	i+"px",
						styles:	{
									textAlign:	"center"
								}
					});
					document.id("select_size")
						.adopt(opt);
				}

				label =  new Element("span",{
					id:			"label_style",
					html:		"Style:",
					styles: {
								fontFamily:	"Arial,sans-serif",
								fontSize:	"13px",
								lineHeight:	"1.2",
								color: 		"#000000",
								paddingLeft: "50px"/*
								position:	"absolute",
								top:	"5px",
								left:	"20px"*/
							},
					title : "style"
				});

				input = new Element("select",{
					id:		"select_style",
					styles: {
								paddingLeft: "5px",
								width:		"100px",
								marginLeft:	'10px'/*,
								position:	"absolute",
								top:	"1.5px",
								left:	"60px"*/
							},
					events:	{
								change: 	function(){
												fontObj.style = this.value;
												if(this.value=="B"){
													document.getElements(".textFont").setStyle("fontWeight","bold");
												}
												else if(this.value=="I"){
													document.getElements(".textFont").setStyle("fontStyle","italic");
													document.getElements(".textFont").setStyle("fontWeight","");
												}
												else if(this.value=="BI"){
													document.getElements(".textFont").setStyle("fontStyle","italic");
													document.getElements(".textFont").setStyle("fontWeight","bold");
												}
												else{
													document.getElements(".textFont").setStyle("fontStyle","normal");
													document.getElements(".textFont").setStyle("fontWeight","");
												}
												SetUpdated();
												return;
											}
							}
				});

				document.id("specsfontdiv")
					.adopt(label)
					.adopt(input);

				if(!Empty(availableStyles)){
					var isSel = false;
					for(var i=0; i<availableStyles.length; i++){
						if(fontObj.style == availableStyles[i].val)
							isSel = true;
						else
							isSel = false;
						opt = new Element("option",{
							value:	availableStyles[i].val,
							text:	availableStyles[i].text,
							styles:	{
										textAlign:	"center"
									},
							selected:	isSel
						});
						document.id("select_style")
							.adopt(opt);
					}
				}

				label =  new Element("span",{
					id:			"label_color",
					html:		"Color:",
					styles: {
								fontFamily:	"Arial,sans-serif",
								fontSize:	"13px",
								lineHeight:	"1.2",
								color: 		"#000000",
								paddingLeft: "50px",
								visibility:	"hidden"
							},
					title : "color"
				});

				var colBtn = CreateBtnColor();

				input = new Element("input",{
					id:		"input_color",
					styles: {
								paddingLeft: "5px",
								width:		"100px",
								marginLeft:	'10px',
								backgroundColor: "",
								visibility:	"hidden"
							},
					value:	fontObj.color
				});

				// var col = new jscolor.color(input,{hash:true,adjust:true,required:false,pickerPosition:'right',pickerWrapper:colBtn});

				document.id("specsfontdiv")
					.adopt(label)
					.adopt(input)
					.adopt(colBtn);

			}

			function CreateBtnColor(){
				var propBtnColor = new Element('div',{
					'class':	'input_inline_btn',
					styles:	{
						width:		'18px',
						'float':	'right',
						marginTop:	'2.5px',
						height:		'18px',
						overflow:	'hidden',
						cursor:		'pointer',
						background:	'url(../portalstudio/images/psheet/btn_psheet.png) no-repeat scroll',
						backgroundPosition:	'-73px -18px',
						visibility:	"hidden"
					}
				});
				return propBtnColor;
			}

			function setFontDiv(){
				var divFont, label, bckGround="#FFFFFF";
				if(!Empty(availableFonts)){
					for(var i=0; i<availableFonts.length; i++){
						if(availableFonts[i].name==fontObj.name)
							bckGround="#E4E6DF";
						else
							bckGround="#FFFFFF";

						divFont = new Element('div',{
							id:			"divFont_"+i,
							styles:	{
								padding:	"40px 0px 0px 20px",
								border:		"1px solid #bbb",
								margin:		"0 3px 10px 10px",
								background:	bckGround,
								overflow:	"auto",
								position:	"relative"
							}
						});

						document.id("fontlistdiv")
							.adopt(divFont);

						label =  new Element("span",{
							html:		textLetter,
							'class':	'textFont',
							styles: {
										fontFamily:	availableFonts[i].family,
										fontSize:	22+"px",
										color: 		"#000000",
										display:	"block",
										lineHeight:	"1.2"
									}
						});

						document.id("divFont_"+i)
							.adopt(label);

						label =  new Element("span",{
							html:		textNumber,
							'class':	'textFont',
							styles: {
										fontFamily:	availableFonts[i].family,
										fontSize:	22+"px",
										color: 		"#000000",
										display:	"block",
										lineHeight:	"1.2"
									}
						});

						document.id("divFont_"+i)
							.adopt(label);

						label =  new Element("span",{
							html:		textSpecialChar,
							'class':	'textFont',
							styles: {
										fontFamily:	availableFonts[i].family,
										fontSize:	22+"px",
										color: 		"#000000",
										display:	"block"
									}
						});

						document.id("divFont_"+i)
							.adopt(label);

						label =  new Element("span",{
							id:			"descText_"+i,
							html:		availableFonts[i].name+", ",
							styles: {
										fontFamily:	"Arial,sans-serif",
										fontSize:	"13px",
										color: 		"#000000",
										fontWeight:	"bold",
										position:	"absolute",
										bottom:		"20px"
									}
						});

						document.id("divFont_"+i)
							.adopt(label);

						label =  new Element("span",{
							html:		availableFonts[i].name,
							styles: {
										fontFamily:	availableFonts[i].family,
										fontSize:	"13px",
										color: 		"#000000",
										position:	"absolute",
										bottom:		"20px",
										marginLeft:	(document.id("descText_"+i).offsetWidth+4)+"px"
									}
						});

						document.id("divFont_"+i)
							.adopt(label);

						if(availableFonts[i].other){
							label =  new Element("span",{
								html:		textOtherFont,
								styles: {
											fontFamily:	"Arial,sans-serif",
											fontSize:	"10px",
											color: 		"#000000",
											display:	"block",
											position:	"absolute",
											bottom:		"0px"
										}
							});

							document.id("divFont_"+i)
								.adopt(label);
						}

						label = new Element("button",{
							text:		"Select",
							accesskey:	"i",
							"class":	"bottoni _"+ i,
							events: {
										click:	function(){
													var idx = parseInt(this.className.substr(this.className.indexOf("_")+1));
													if(fontObj.name != availableFonts[idx].name){
														fontObj.name = availableFonts[idx].name;
														SetUpdated();
													}
													/*if(fontObj.color != document.id("input_color").value){
														fontObj.color = document.id("input_color").value;
														SetUpdated();
													}*/
													ReturnExpression();
													return;
												}
									},
							styles:	{
										display:	"block",
										"float":	"right",
										marginTop:	"35px",
										marginRight: "10px",
										cursor:		"pointer"
									}
						});

						document.id("divFont_"+i)
							.adopt(label);
					}
				}
			}

			function ReturnExpression(){
				if (m_bUpdated){
					var output = "";
					output += fontObj.name + separator;
					output += fontObj.size + separator;
					output += fontObj.color + separator;
					output += fontObj.style;

					getOpener()[callerFunction](objIdx, output, typeF);

					m_bUpdated = false;
				}
				CloseWindow();
			}

			function SetUpdated(){
				m_bUpdated = true;
			}

		</script>
		<title>Font Viewer</title>
	</head>

	<body bgcolor="#E4E4E4" topmargin="0" leftmargin="0" marginwidth="0" marginheight="0" scroll="yes" style="border:0px;overflow:auto;margin:0pt" onload="Init()">
		<div border="1" width="100%" height="100%" cellpadding="0">
			<div id="specsfontdiv" style="position:absolute; top:10px">
			</div>
			<div id="fontlistdiv" style="width:100%; height:90%; overflow:auto; position:absolute; top:50px;">
			</div>
		</div>
	</body>
</html>
