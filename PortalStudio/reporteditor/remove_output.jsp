<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><!doctype html>
<html style="height:100%;">
<head>
  <title>Remove Output</title>
  <script type="text/javascript" src="../visualweb/mootools-core.js"></script>
  <script type="text/javascript" src="../visualweb/mootools-more.js"></script>
  <script type="text/javascript" src="../stdFunctions.js"></script>
  <script type="text/javascript" src="../controls.js"></script>
  <link rel="stylesheet" href="../filewindow.css" type="text/css">
  <%
    Sitepainter sp = new Sitepainter(request);
    if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples",""))) {
    sp.setContentType(response);
   %>

  <script type="text/javascript">
    function getOpener() {
      return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));
    }

    function CloseWindow() {
      if (window.closeFrame) {
        closeFrame();
      }
      else if (!Empty(SPModalLayerId)) {
        getOpener().closeSPModalLayer();
      }
      else {
        window.close();
      }
    }

    var objIdx = null;
    var valueObject = null;
    var SPModalLayerId = null;
    var acceptedOutputFormat = "";
    var m_bUpdated = false;

    function Init() {
      objIdx = '<%=JSPLib.ToJSValue(sp.getParameter("objIdx",""))%>';
      valueObject = '<%=JSPLib.ToJSValue(sp.getParameter("ExpressionValue",""))%>';
      SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';

      acceptedOutputFormat = getOpener().GetAcceptedOutputFormat();
      designFormats();
      InitFormats();
    }

    function InitFormats() {
      if (!Empty(valueObject)) {
        var outputValue = '';
        var found;
        outputListArray = valueObject.split(',');
        for (var i = 0; i < outputListArray.length; i++) {
          //Gestito caso in cui l'utente modifica a mano il valore e lo scrive con il case sbagliato
          outputValue = LRTrim(outputListArray[i]).toUpperCase();
          //Gestito caso della stringa vuota
          if (outputValue != '') {
            found = searchFormat(outputValue);
            if (found) {
              document.id("output_" + outputValue.toLowerCase()).checked = true;
            }
            else {
              alert(outputValue + ": Output Format not accepted.");
            }
          }
        }
      }
    }

    function searchFormat(output) {
      for (i = 0; i < acceptedOutputFormat.length; i++) {
        if (acceptedOutputFormat[i][0] == output) {
          return true;
        }
      }
      return false;
    }

    function designFormats() {
      var i = 0;
      for (i = 0; i < acceptedOutputFormat.length; i++) {
        var checkboxFormat = new Element('input', {
          'id' : "output_" + acceptedOutputFormat[i][0].toLowerCase(),
          type : 'checkbox',
          title : acceptedOutputFormat[i][1],
          value : acceptedOutputFormat[i][0]
        });
        checkboxFormat.addEvent('click', function () {
          SetUpdated();
        });
        var labelFormat = new Element('span', {
          html : acceptedOutputFormat[i][1],
          'class' : '',
          style : {
            'paddingLeft' : '0px'
          },
          title : acceptedOutputFormat[i][1]
        });
        var divFormat = new Element('div', {
          style : 'border-bottom: 1px solid #676767;'
        }).adopt(checkboxFormat).adopt(labelFormat);
        document.id('formatList').adopt(divFormat);
      }
    }

    function ReturnExpression() {
      if (m_bUpdated) {
        valueObject = "";
        var selectedOutput = document.id('formatList').getChildren();
        var output = null;
        var i;
        for (i = 0; i < selectedOutput.length; i++) {
          output = selectedOutput[i].getChildren();
          if (output[0].checked) {
            valueObject += output[0].value + ",";
          }
        }
        //Elimino la virgola finale
        valueObject = Substr(valueObject, 1, RAt(",", valueObject) - 1);
        getOpener().removeOutputReturn(objIdx, valueObject);
        m_bUpdated = false;
      }
      CloseWindow();
    }

    function SetUpdated() {
      m_bUpdated = true;
    } // SetUpdated

    function Unload() {
      if (m_bUpdated) {
        if (confirm("Selection has been modified. Save changes before closing?")) {
          getOpener().removeOutputReturn(objIdx, valueObject);
        }
      }
    } //Unload
 </script>
 <style type="text/css">
    .contenuto {
      border : 0px;
    }
 </style>
</head>

<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4; height:100%;" onload="Init()" onunload="Unload()">
  <div border="1" width="100%" height="100%" cellpadding="0">
    <div id="title">
      <div class="titoli" align="center" onselectstart="return false" style="height:15px;"><b>Available Output Format</b></div>
    </div>
    <div id="formatList" class="contenuto">
    </div>
    <div>
      <div class="footer" height="20" valign="middle" align="center" nowrap >
        <button onclick="ReturnExpression()" accesskey="i" class="bottoni"><u>I</u>nsert</button>&nbsp;
        <button onclick="CloseWindow()" accesskey="c" class="bottoni"><u>C</u>ancel</button>
      </div>
    </div>
  </div>
</body>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
