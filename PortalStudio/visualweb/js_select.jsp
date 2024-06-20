<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%Sitepainter sp=new Sitepainter(request);%>
<html>
<head>
 <title>Select js...</title>
 <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <link rel="stylesheet" href="../properties.css" type="text/css">
 <script type="text/javascript">
  // CUSTOM CMS
  var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
  // END CUSTOM
  var type='<%=JSPLib.ToJSValue(sp.getParameter("type",""))%>';
  var nome_js='<%=JSPLib.ToJSValue(sp.getParameter("name",""))%>';
  var item='<%=JSPLib.ToJSValue(sp.getParameter("item",""))%>';
  function insert(){
    var returnObject='<%=JSPLib.ToJSValue(request.getParameter("for"))%>';
    if(Ctrl("openlist").selectedIndex>=0){
      var valto=window.opener.Ctrl(returnObject);
      valto.focus();
      if(valto.value!='' && (type=='js'))
        valto.value +=','+Ctrl("openlist").value;
      else
        valto.value =Ctrl("openlist").value;
      //valto.blur();
    }
    window.close();
  }
 </script>
</head>
<body style="border:0;overflow:hidden;margin:0;background-color:#D6D3CE">
 <table border="1" width="100%" height="100%" cellpadding="0" cellspacing="1" align="center">
  <tr>
   <td class="contorno" align="center" height="20">
   <%if (!sp.getParameter("type","").equals("js")){%>
    <b>Cla<u>s</u>ses list of
    <script type="text/javascript">
    if(typeof(window.opener.formProp)!='undefined') {var from=window.opener.formProp;} else {var from=window.opener.pageletProp[0];}
    if(from.sp_theme=='true')
      document.write("portalstudio.css")
    else
      document.write('<%=JSPLib.ToJSValue(request.getParameter("name"))%>')
    </script>
   <%}else{%>
    <b>J<u>s</u> list
  <%}%>
   </td>
  </tr>
  <tr>
   <td class="contorno">
    <select id="openlist" size="15" style="width:100%;height:100%" ondblclick="insert()" accesskey="s">
    <script type="text/javascript">
      var str='';
      var classes = new Array();
      if(type!=''){ //apre la lista dei js
        var url= new JSURL("../servlet/JSPReader?type=js&folder_path="+folder_path,true);
        classes = url.Response();
        classes= classes.split(',');
        if(typeof(classes)!='undefined'){
          for(var i=0;i<classes.length;i++){
            document.write("<option value='"+classes[i]+"'>"+classes[i]+"</option>")
          }
        }
      }
    </script>
    </select>
   </td>
  </tr>
  <tr>
   <td height="20" valign="middle" align="center" nowrap>
    <button onclick="insert()" accesskey="i" class="bottoni"><u>I</u>nsert</button>&nbsp;
    <button onclick="window.close();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>
