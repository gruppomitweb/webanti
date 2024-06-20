<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%
  Sitepainter sp=new Sitepainter(request);
  SPJSPBridge.CPResultSet rs;
  String tool=sp.getParameter("tool","portlet");
  String zone=sp.getParameter("zone","");
%>
<html>
<head>
 <title>Insert...</title>
 <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <script type="text/javascript">
var returnObject=GetOpener().document.getElementById('<%=JSPLib.ToJSValue(request.getParameter("for"))%>');
var element='<%=JSPLib.ToJSValue(request.getParameter("element"))%>';
var layout='<%=JSPLib.ToJSValue(request.getParameter("layout"))%>';
function doload(){
	if(element == "groups")
		document.getElementById('labelname').innerHTML = "<b>Group <u>n</u>ame:</b>"
<%if("servlet".equals(tool)){%>
  window.resizeTo(370,240);
<%}else if("templatezone".equals(tool)){%>
  window.resizeTo(370,240);
<%}else{%>
  window.resizeTo(400,600);
<%}%>
}
function checkSelection(){
  if(Ctrl("filename").value!=''){
	if(element == "groups")
		returnObject.value=document.getElementById("filename").value;
	else
		returnObject.value=document.getElementById("filename").value+'_portlet.jsp';
    returnObject.focus();
  }
  window.close();
}
function typePortlet(){
  var tool='<%=tool%>';
  if(tool=='templatezone'){
    if(Ctrl('check_zone').checked){
      var name=Ctrl('templatezone').value;
      var type='zone';
    }else{
      var name=Ctrl('templatezone').value;
      var type='group';
    }
  }
  else if(tool=='servlet'){
    var name="../servlet/"+Ctrl('servlet').value;
  }
  else{
    var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    if (folder_path.length > 0) folder_path+="/";
    if (folder_path.charAt(0)=="/") folder_path=folder_path.substr(1);
  }
  if(tool=='jsp')
    GetOpener().insertportlet2(name,'<%=zone%>');
  else if(tool=='portlet'){
    GetOpener().insertportlet2(folder_path+name+'_portlet.jsp','<%=zone%>');
  }
  else if(tool=='pagelet')
    GetOpener().insertportlet2(name+'.jsp','<%=zone%>');
  else
    GetOpener().insertportlet2(name,'<%=zone%>',type);
  window.close();
}
function getDescription(){
  var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
  if(<% if("portlet".equals(tool))
           out.print("true");
         else
           out.print("false");
    %>) {
    var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var des = new JSURL("../servlet/JSPReader?type=portlet&action=description&name="+name+"&folder_path="+folder_path);
    des = des.Response();
    if (des == "undefined") des="No description";
    Ctrl('description').value=des;
  }
}
function setName(){
  var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
  Ctrl('filename').value=name;
}
 </script>
</head>
<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4" onload="doload()">
 <table class="contenuto" border="0" width="100%" height="100%" cellpadding="0" cellspacing="2" align="center">
  <tr>
   <td class="titoli" align="center" height="20" colspan="2"><b>A<u>v</u>ailable files:</b></td>
  </tr>
  <tr>
   <td class="contenuto" colspan="2" height="100%">

<%if("templatezone".equals(tool)){%>
    <table class="titoli" width="100%" height="100%">
     <tr><td>Name</td> <td><input id="templatezone" type="text"></td></tr>
     <tr><td>Zone</td> <td><input id="check_zone" name="iszone" type="radio" value="zone"></td></tr>
     <tr><td>Group</td> <td><input id="check_group" name="iszone" type="radio" value="group" checked></td></tr>
    </table>
<%}else if("servlet".equals(tool)){%>
    <table class="titoli" width="100%" height="100%">
     <tr><td>Servlet name</td> <td><input id="servlet" type="text"></td></tr>
    </table>
<%}else {%>
    <select id="openlist" size="15" style="width:100%;height:100%" ondblclick="checkSelection();" onchange="setName();getDescription()" accesskey="v">
    <script type="text/javascript">
     var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>'
     if(folder_path!='') document.write("<option>[...]</option>");
<%if("portlet".equals(tool)){%>
     //portletFiles = new JSURL("../servlet/JSPReader?type=portlet&folder_path="+folder_path);
	 if(element == "groups")
		names = new JSURL("../servlet/JSPReader?type=layout_tags&name="+layout);
	 else
		names = new JSURL("../servlet/JSPReader?type=portlet&folder_path="+folder_path);
     names = names.Response();
     var Files=names.split(',');
     for(var i=0;i<Files.length;i++){
       document.write("<option>"+Strtran(Files[i], "_portlet.jsp", "")+"</option>");
     }
 <%}else if("pagelet".equals(tool)){%>
     portletFiles = new JSURL("../servlet/JSPReader?type=pagelet&folder_path="+folder_path);
     portletFiles = portletFiles.Response();
     var Files=portletFiles.split(',');
     for(var i=0;i<Files.length;i++){
       document.write("<option>"+Strtran(Files[i], ".jsp","")+"</option>");
     }
 <%}else if("jsp".equals(tool)){%>
    portletFiles = new JSURL("../servlet/JSPReader?folder_path="+folder_path);
    portletFiles = portletFiles.Response();
    var Files=portletFiles.split(',');
    for(var i=0;i<Files.length;i++){
      document.write("<option>"+Files[i]+"</option>");
    }
 <%}else if("html".equals(tool)){%>
    portletFiles = new JSURL("../servlet/JSPReader?type=html&folder_path="+folder_path);
    portletFiles = portletFiles.Response();
    var Files=portletFiles.split(',');
    for(var i=0;i<Files.length;i++){
      document.write("<option>"+Files[i]+"</option>");
    }
  <%}%>
    </script>
    </select>
<%}%>
   </td>
  </tr>
  <tr>
   <td class="contenuto" align="center" colspan="2">
    <textarea readonly id="description" style="width:100%;height:40px;"></textarea>
   </td>
  </tr>
  <tr>
   <td class="titoli" id="labelname" align="center" height="20" colspan="2"><b>File <u>n</u>ame:</b></td>
  </tr>
  <tr>
   <td class="footer" height="20" width="100%" valign="middle" align="center">
    <!--
    <form id="form1" action="insert.jsp" method="post">
    <select  name='tool' onChange="Ctrl('form1').submit()" style="width: 100%" accessKey="t">
    <option <%if("portlet".equals(tool)) out.print("selected");%> value='portlet'>Portlet</option>
    <option <%if("jsp".equals(tool)) out.print("selected");%> value='jsp'>Manual jsp</option>
    <option <%if("pagelet".equals(tool)) out.print("selected");%> value='pagelet'>Pagelet</option>
    <option <%if("templatezone".equals(tool)) out.print("selected");%> value='templatezone'>Template Zone</option>
    <option <%if("html".equals(tool)) out.print("selected");%> value="html">HTML Document</option>
    <option <%if("servlet".equals(tool)) out.print("selected");%> value="servlet">SitePainter Servlet</option>
    </select>
    <input type="hidden" name="folder_path" value=<%=JSPLib.ToHTMLValue(sp.getParameter("folder_path",""))%>>
    <input name="zone" type="hidden" value="<%=zone%>">
    </form>
    -->
    <input type="text" id="filename" value="" style="width:100%" accesskey="n">
   </td>
   <td class="footer" height="20" valign="middle" align="center" nowrap>
    <button onclick="checkSelection();" accesskey="o" class="bottoni"><u>O</u>k</button>&nbsp;
    <button onclick="window.close();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>
