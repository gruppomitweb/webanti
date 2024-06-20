<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><!doctype html>
<html style = "height:100%;">
<head>
  <title>Preview</title>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-core.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>

  <link rel="stylesheet" href="scaneditor.css" type="text/css">
  <%
    Sitepainter sp = new Sitepainter(request);
    if(sp.CanAccessEditor("SPScanEditor")) {
    sp.setContentType(response);
   %>
  <script type="text/javascript">
    var scanDef = "";

    function getOpener() {
      return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));
    }

    function CloseWindow() {
      if (window.closeFrame)
        closeFrame();
      else if (!Empty(SPModalLayerId))
        getOpener().closeSPModalLayer();
      else
        window.close();
    }

    function Init() {
      scanDef = getOpener().createPreview();
      SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
      designPreview();
    }

    function designPreview() {
      var cssClass = "";
      var tbl = document.getElementById("corpo");

      var i = 0, nRows = 0;
      var tRow, cell;
      for (i = 0; scanDef && i<scanDef.length; i++) {
        if (LRTrim(scanDef[i].name) != ""){
          if (i % 2 == 0)
            cssClass = "grid_rowover";
          else
            cssClass = "grid_rowodd";

          tRow = tbl.insertRow(nRows);
          cell = tRow.insertCell(0);
          cell.innerHTML = scanDef[i].name;
          LibJavascript.CssClassNameUtils.addClass(cell,cssClass);
          cell = tRow.insertCell(1);
          cell.innerHTML = scanDef[i].value;
          LibJavascript.CssClassNameUtils.addClass(cell,cssClass);
          nRows++;
        }
      }
    }
  </script>
</head>

<body style="margin:0;height:100%;" onload="Init()" onunload="CloseWindow()">
  <div border="1" width="100%" height="100%" cellpadding="0">
    <div id="title">
      <div class="titoli" onselectstart="return false">Anteprima dei valori rilevati dalle zone</div>
    </div>
    <div id="formatList" class="grid">
      <table id="preview" class="grid_table" border="0">
        <thead class="toolsbar_item">
          <tr class="toolsbar_item_text">
            <td width="30%" class="grid_cell">Zona</td>
            <td class="grid_cell">Valore</td>
          </tr>
        </thead>
        <tbody id="corpo">
        </tbody>
      </table>
    </div>
    <!--<div>
      <div class="footer" height="20" valign="middle" align="center" nowrap>
        <button onclick="CloseWindow()" accesskey="c" class="bottoni"><u>C</u>lose</button>
      </div>
    </div>-->
  </div>
</body>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
