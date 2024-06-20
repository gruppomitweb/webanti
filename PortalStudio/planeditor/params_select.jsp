<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
Sitepainter sp=new Sitepainter(request);
sp.setContentType(response);
%>
<html>
<head>
 <title>Select Parameters</title>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <link rel="stylesheet" href="../properties.css" type="text/css">
 <script type="text/javascript">
  var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
  var nome_portlet='<%=JSPLib.ToJSValue(sp.getParameter("name",""))%>';
  function insert(){
    var returnObject='<%=JSPLib.ToJSValue(request.getParameter("for"))%>';
    if(Ctrl("openlist").selectedIndex>=0){
      var valto=GetOpener().Ctrl(returnObject);
      valto.value =Ctrl("openlist").value;
      valto.focus();
    }
    window.close();
  }
 </script>

</head>
<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4">
 <table border="1" width="100%" height="100%" cellpadding="0" cellspacing="1" align="center">
  <tr>
   <td class="titoli" align="center" height="20">
    <b>Parameters list

   </td>
  </tr>
  <tr>
   <td class="contenuto">

    <select id="openlist" size="15" style="width:100%;height:100%" ondblclick="insert()" accesskey="s">
    <script type="text/javascript">
      var str='';
      var parms;
		  var url= new JSURL("../servlet/JSPReader?action=paramsrequest&type=portlet&name="+nome_portlet+"&folder_path="+folder_path,true);
      parms = url.Response();
      parms= parms.split(',');
      if(parms!=null){
        for(var i=0;i<parms.length;i++){
          document.write("<option value='"+parms[i]+"'>"+parms[i]+"</option>")
        }
      }
    </script>
    </select>
   </td>
  </tr>
  <tr>
   <td class='footer' height="20" valign="middle" align="center" nowrap>
    <button onclick="insert()" accesskey="i" class="bottoni"><u>I</u>nsert</button>&nbsp;
    <button onclick="window.close();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>
