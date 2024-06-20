<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
Sitepainter sp=new Sitepainter(request);
  if(sp.CanAccess("SPPDFViewer")) {
%>

<html class="zBoViewer">
<head>
<title>zBo Viewer - Sitepainter Infinity</title>
<link rel="stylesheet" href="../<%=sp.getTheme()%>/zpdfviewer.css" type="text/css">
<link rel="stylesheet" href="../<%=sp.getTheme()%>/portalstudio.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../Notimoo.css" />
<script>
	var mversion = '4.0';
	var m_cAction = '<%=JSPLib.ToJSValue(sp.getParameter("m_cAction","view"))%>';
  var m_cAtExit = '<%=JSPLib.ToJSValue(sp.getParameter("m_cAtExit","close"))%>';
  var m_cMode = '<%=JSPLib.ToJSValue(sp.getParameter("m_cMode",""))%>';
	var zoomid = '<%=JSPLib.ToJSValue(sp.getParameter("zoomid",""))%>';
	var pdfzoom = <%=sp.getParameter("pdfzoom",999)%>;
	var mboname = '<%=JSPLib.ToJSValue(sp.getParameter("boname",""))%>';
	var mbokeysvalues = '<%=JSPLib.ToJSValue(sp.getParameter("bokeysvalues",""))%>';
	var canmodpages = false;//<%=sp.getParameter("canmodpages",true)%>;
	var gridid = '<%=JSPLib.ToJSValue(sp.getParameter("gridid",""))%>';
  var msgPreview = '<%=JSPLib.ToJSValue(sp.translate("RPT_PREVIEW"))%>';
  var msgCancel = '<%=JSPLib.ToJSValue(sp.translate("ADMIN_CANCEL"))%>';
  var msgCancelTooltip = '<%=JSPLib.ToJSValue(sp.translate("MSG_CANCEL"))%>';
  var msgExpand = '<%=JSPLib.ToJSValue(sp.translate("MSG_EXPAND"))%>';
  var msgReduce = '<%=JSPLib.ToJSValue(sp.translate("MSG_REDUCE"))%>';
	var mtitle  = '<%=JSPLib.ToJSValue(sp.getParameter("title",""))%>';
	var showsignmarks = <%=sp.getParameter("showsignmarks",true)%>;
</script>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<!--<script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>-->
<script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("zboviewer/itemsObj.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("zboviewer/zboviewer.js")%>'></script>
<script type="text/javascript">
window.addEvent('domready', function() {
	if(window.addEventListener){
		window.addEventListener("dragover",function(e){
		  e = e || event;
		  e.dataTransfer.effectAllowed="none";
		  e.preventDefault();
		},false);
		window.addEventListener("drop",function(e){
		  e = e || event;
		  e.dataTransfer.effectAllowed="none"
		  e.preventDefault();
		},false);
	}
	if(window.attachEvent){
		window.attachEvent("ondragover",function(e){
		  e = e || event;
		  e.dataTransfer.effectAllowed="none";
		  e.preventDefault();
		},false);
		window.attachEvent("ondrop",function(e){
		  e = e || event;
		  e.dataTransfer.effectAllowed="none"
		  e.preventDefault();
		},false);
	}


	$('prevBtn').addEvents({
		'click':function(){
			PreviousBO();
		}
	});

	$('nextBtn').addEvents({
		'click':function(){
			NextBO();
		}
	});

	$$('.ctrlBtn').each(function(el){
	  el.morphFx = new Fx.Morph(el,{'duration':200,'link':'cancel'});
	  el.setStyles({'opacity':0});
	  el.addEvents({
	   'mouseover':function(){
			this.morphFx.start({'opacity':0.6});
			this.setStyle('background-position','top right');
			$('backcanvas').fireEvent('mouseenter',this);
	   },
	   'mouseout':function(){
			this.morphFx.start({'opacity':0.2});
			this.setStyle('background-position','top left');
			$('backcanvas').fireEvent('mouseleave',this);
	   }
	  });
	 });

	document.id('objList').getChildren().each(function(el){
	  el.title = FormatMsg(el.title);
    });

	$('canvas').addEvents({
		'mouseenter':function(from){
			$$('.ctrlBtn').each(function(el){
					el.morphFx.start({'opacity':0.2});
			});
		},
		'mouseleave':function(from){
			$$('.ctrlBtn').each(function(el){
					el.morphFx.start({'opacity':0});
			});
		}
	});
});
</script>

<link rel="shortcut icon" href="../portalstudio/sp.ico" />
</head>
	<body style='height: inherit;' topmargin="0" leftmargin="0" onLoad="doLoad(event)" onResize="resizeWindow(event)">
		<span style="display:none;z-index:1000" id="mversion"></span>
		<!-- div nuova toolbar TODO style="display:none"-->
		<div id="loading" class="loading"></div>
		<div id="wrapper" style="width:100%;height:100%;">
		<div id='properties'></div>
		<div id="backcanvas" class="canvas" style="display:block;border:0px solid #676767;position:relative;overflow:hidden;width:50%;height:99%;left:0px;top:0px;-moz-user-select:none">
    <div id='zbo_events' style="display:none"><%out.flush();Library.includeResource(request,response,"/jsp-system/zboviewer_events_portlet.jsp",false);%></div>
			<div id="toolbar" class="toolbar" style="display:none">
			<ul  id="objList" class="objList">
				<li title="New" id="bnew">
					<span  id="bnewa" onclick="NewBO()"  class="zPdfIcon new"></span>
				</li>
				<li title="Edit" id="bedit">
					<span  id="bedita" onclick="EditBO()"  class="zPdfIcon edit"></span>
				</li>
				<li title="Save" id="bsave">
					<span  id="bsavea" onclick="SaveBO()" class="zPdfIcon save"></span>
				</li>
				<li title="Close" id="bcancel">
					<span  id="bcancela" onclick="CancelBO()" class="zPdfIcon close"></span>
				</li>
				<li title="Delete" id="bdelete">
					<span  id="bdeletea" onclick="DeleteBO()" class="zPdfIcon delete"></span>
				</li>
				<li title="Close" id="bclose">
					<span  id="bclosea" onclick="CancelBO()" class="zPdfIcon close"></span>
				</li>
				<!-- <li title="Attach document" id="battach" style="display:none;position:absolute;right:0px;">
					<span  id="battacha" onclick="ToogleClick()" class="zPdfIcon attach"></span>
				</li>	-->
			</ul>
			</div>

			<div id="prevBtn" class="ctrlBtn" title="Previous" style="display:block;font-size:1px;line-height:0;">
			</div>
			<div id="nextBtn" class="ctrlBtn" title="Next" style="display:block;font-size:1px;line-height:0;">
			</div>
			<div id="canvas" scrolling="yes" style="position:relative;border:0px dotted #676767;left:0px;width:100%;height:100%" onClick="cancelEvent(event);clickItem(event)">
				<iframe allowtransparency="true" frameborder="0" toResize='no' id='i_canvasframe' name='i_canvasframe' style='top:0;border:0;width:100%;height:100%;box-sizing:border-box'></iframe>
			</div>
		</div>

		<div id='gadgets_panerightbarR' class="" title=""><div id="gadgets_opencloseR" title="Show document"></div></div>
		<div id='i_gadget_wrapper' style='position:absolute;display:block;z-index:999'>
			<iframe allowtransparency="true" frameborder="0" toResize='no' id='i_gadgetframe' name='i_gadgetframe' style='position:absolute;top:0;border-left:1px solid #c3c3c3;width:100%;height:95%;box-sizing:border-box'></iframe>
		</div>
	</body>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>

