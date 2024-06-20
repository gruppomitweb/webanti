<html>
<head>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@ page import="java.util.*" %><%
  Sitepainter sp=new Sitepainter(request);
  SPJSPBridge.CPResultSet rs;
%>
 <title>Select layout</title>
 <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
</head>
<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4" onload="this.focus();Init()">
 <table border="1" width="100%" height="100%" cellpadding="0" cellspacing="1" align="center">
  <tr>
   <td class="titoli" align="center" height="20"><b>A<u>v</u>ailable files:</b></td>
  </tr>
  <tr>
   <td class="contenuto" height="100%">
    <select id="openlist" size="8" style="width:100%;height:100%" ondblclick="insert()" accesskey="v">
     <script>
      var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
      var type = '<%=JSPLib.ToJSValue(sp.getParameter("type","pagelet_template"))%>';
      portletFiles = new JSURL("../servlet/JSPReader?type="+type+"&folder_path="+folder_path);
      portletFiles = portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        if(Files[i].indexOf("..]")==-1)
          document.write("<option value='"+Strtran(Files[i], ".jsp","")+"'>"+Strtran(Files[i], ".jsp","")+"</option>");
      }
     </script>
    </select>
    <script>
    QueryString.keys = new Array();
    QueryString.values = new Array();

    function QueryString(key) {
      var value = null;
      for (var i=0;i<QueryString.keys.length;i++) {
        if (QueryString.keys[i]==key) {
          value = QueryString.values[i];
          break;
        }
      }
      return value;
    }

    function QueryString_Parse() {
      var query = window.location.search.substring(1);
      var pairs = query.split("&");
      for (var i=0;i<pairs.length;i++) {
        var pos = pairs[i].indexOf('=');
        if (pos >= 0) {
          var argname = pairs[i].substring(0,pos);
          var value = pairs[i].substring(pos+1);
          QueryString.keys[QueryString.keys.length] = argname;
          QueryString.values[QueryString.values.length] = value;
        }
      }
    }
    var ReturnObjectIndex = null;
    function Init() {
      QueryString_Parse();
      ReturnObjectIndex = QueryString("for");
    }

    function insert() {
      if(Ctrl("openlist").value!=''){
	if(type!='layout') {
		GetOpener().itemsHTML[ReturnObjectIndex].template=Ctrl("openlist").value;
	}
	else {
	//CUSTOM CMS
		if(QueryString("isFormProp")=='true'){
		      GetOpener().formProp["layout"]=Ctrl("openlist").value;
		      GetOpener().FormProperties();
		      window.close();
		      return;
		}
		else {
			GetOpener().itemsHTML[ReturnObjectIndex].layout=Ctrl("openlist").value;
		}
	}
        GetOpener().Properties();
        GetOpener().writeHTML();
        GetOpener().drawLinks(true);
      }
      window.close();
    }
    </script>
   </td>
  </tr>
  <tr>
   <td class="footer" align="center" nowrap>
    <button onclick="insert()" accesskey="o" class="bottoni"><u>O</u>k</button>&nbsp;
    <button onclick="window.close();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>

