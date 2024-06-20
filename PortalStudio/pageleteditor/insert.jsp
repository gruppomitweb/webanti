<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%
  Sitepainter sp=new Sitepainter(request);
  SPJSPBridge.CPResultSet rs;
  String tool=sp.getParameter("tool","portlet");
  String zone=sp.getParameter("zone","");
  String input_id=sp.getParameter("inputID","");
%>
<html>
<head>
 <title>Insert</title>
 <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <script type="text/javascript">
  var Ctrl = LibJavascript.DOM.Ctrl;
function doload(){
<%if("resource".equals(tool) || "group".equals(tool) || "servlet".equals(tool) ){%>
  window.resizeTo(370,180);
<%}else{%>
  window.resizeTo(400,600);
<%}%>
	window.setTimeout(function(){
    var body=Ctrl('body');
		var d_w=body.scrollWidth-(window.outerWidth||body.offsetWidth);
		var d_h=body.scrollHeight-body.offsetHeight;
		window.resizeBy(d_w, d_h);
	}, 200);
}

function checkSelection(){
  var obj = Ctrl("openlist");
  var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
  if(obj.selectedIndex>=0) {
    var text_path=obj.options[obj.selectedIndex].text;
    if(text_path.indexOf("...]")>-1 && text_path.indexOf("[")>-1 && text_path.length>5){
      text_path=Trim(Strtran(text_path,"[",""));
      folder_path+=Trim(Strtran("/"+text_path, "...]",""));
      window.location.href='insert.jsp?tool=<%=JSPLib.ToJSValue(tool)%>&zone=<%=JSPLib.ToJSValue(zone)%>&folder_path='+URLenc(folder_path);
    }else if(text_path.indexOf("[...]")>-1){
      folder_path=folder_path.substring(0,folder_path.lastIndexOf("/"));
      window.location.href='insert.jsp?tool=<%=JSPLib.ToJSValue(tool)%>&zone=<%=JSPLib.ToJSValue(zone)%>&folder_path='+URLenc(folder_path);
    }else{
      typePortlet();
    }
  }
}

function typePortlet(){
  var tool='<%=JSPLib.ToJSValue(tool)%>';
  var name;
  var value
  if(tool=='servlet'){
    var name="../servlet/"+Ctrl('servlet').value;
    // window.opener.addResource(name+'.jsp','static');
    value = name+'.jsp';
  } else{
    var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    if (folder_path.length>0) folder_path+="/";
    if (folder_path.charAt(0)=="/") folder_path=folder_path.substr(1);
  }
  if(tool=='jsp'){
    value = name;
  }else if(tool=='portlet'){
    value = name+'_portlet.jsp';
  }else if(tool=='pagelet'){
    value = name+'.jsp';
  }else if(tool=='html'){
    value = name;
  }else if(tool=='decorators') {
    value = "../jsp-decorators/"+name;
  }
  GetOpener().ExpressionBuilderReturn('<%=JSPLib.ToJSValue(input_id)%>', value);
  GetOpener().updateProperties(document.getElementById('<%=JSPLib.ToJSValue(input_id)%>'),'src','str',false,value,true)
  window.close();
}

function getDescription(){
  var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
  if (<% if("portlet".equals(tool))
           out.print("true");
         else
           out.print("false");
    %>) {
    var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var des=new JSURL("../servlet/JSPReader?type=portlet&action=description&name="+name+"&folder_path="+folder_path);
    des=des.Response();
    if(des=="undefined") des="No description";
    Ctrl('description').value=des;
  }
}
 </script>
</head>
<body style="border:0;margin:0;background-color:#E4E4E4" onload="doload();">
 <div id="body" style="height:100%;width:100%;overflow:auto">
  <table border="0" width="352" cellpadding="0" cellspacing="2" align="center" class="contenuto" style="height:100%;width:100%">
   <tr>
    <td class="titoli" align="center" height="20" colspan="2"><label for="openlist" accesskey="V"><b>A<u>v</u>ailable files:</b></label></td>
   </tr>
   <tr>
    <td class="contenuto" colspan="2" height="100%">
<%if("servlet".equals(tool)){%>
     <table class="contenuto" style="width:100%;height:100%;"><tr>
      <td nowrap><label for="servlet" accesskey="S"><u>S</u>ervlet name:</td><td style="width:100%"><input id='servlet' type='text'  style="width:100%"></td></tr>
     </table>
<%}else {%>
     <select id="openlist" size=15 style="width: 100%; height:100%" ondblclick="checkSelection();" onchange="getDescription()">
     <script type="text/javascript">
      var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
      if(folder_path!='') document.write("<option>[...]</option>");
<%if("portlet".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=portlet&folder_path="+folder_path);
      portletFiles = portletFiles.Response();
      var Files=portletFiles.split(',');
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
<%}else if("decorators".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=decorators&folder_path=../../jsp-decorators");
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
      <td class="titoli" align="center" height="20" colspan="2"><b>File <u>t</u>ype:</b></td>
    </tr>
    <tr>
    <td class="footer"  style="width:100%;" nowrap>
      <form id="form1" action="insert.jsp" method="post" style="display:inline;padding:1px">
        <select name="tool" onChange="Ctrl('form1').submit()" style="width:70%;display:inline;margin-left:5px;" accessKey="t">
          <option <%if("portlet".equals(tool)) out.print("selected");%> value="portlet">Portlet</option>
          <option <%if("html".equals(tool)) out.print("selected");%> value="html">HTML Document</option>
          <option <%if("jsp".equals(tool)) out.print("selected");%> value="jsp">Manual jsp</option>
          <option <%if("servlet".equals(tool)) out.print("selected");%> value="servlet">SitePainter Servlet</option>
          <option <%if("pagelet".equals(tool)) out.print("selected");%> value="pagelet">Pagelet</option>
          <option <%if("decorators".equals(tool)) out.print("selected");%> value="decorators">Decorators</option>
          <!--<option <%if("templatezone".equals(tool)) out.print("selected");%> value="templatezone">Resource/Group</option> -->
        </select>
        <input type="hidden" name="folder_path" value=<%=JSPLib.ToHTMLValue(sp.getParameter("folder_path",""))%>>
        <input name="zone" type="hidden" value=<%=JSPLib.ToHTMLValue(zone)%>>
      </form>
    </td>
    <td class="footer" height="20" valign="middle" align="center" nowrap>
      <button onclick="checkSelection();" accesskey="o" class="bottoni" style="display:inline;"><u>O</u>k</button>&nbsp;
      <button onclick="window.close();" accesskey="c" class="bottoni" style="display:inline;"><u>C</u>ancel</button>
    </td>
    </td>
  </tr>
 </table>
 </div>
</body>
</html>
