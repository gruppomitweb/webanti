<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
%>
<!DOCTYPE html>
<html>
<head>
 <title>Select portlet</title>
 <style>
		body, html{
			height:100%;
			margin:0;
			padding:0;
      background-color:#E4E4E4;
		}
 </style>
 <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <script type="text/javascript">
 var pName,cType;
  function Init(){
    pName='<%=JSPLib.ToJSValue(sp.getParameter("pName",""))%>';//Portlet name
    cType='<%=JSPLib.ToJSValue(sp.getParameter("cType","portlet"))%>';//Ctrl Type
    document.getElementById("title").innerText='Available portlets';
    if(!Empty(cType) && !Empty(pName)){
      document.getElementById("title").innerText="Available "+cType+'s';
      getCtrlList();
    }else
      getFileList();
  }
  function checkSelection(){
    var obj=Ctrl("openlist");
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    if(obj.selectedIndex>=0){
      var text_path=obj.options[obj.selectedIndex].text;
      if(text_path.indexOf("...]")>-1 && text_path.indexOf("[")>-1 && text_path.length>5){
        text_path=Trim(Strtran(text_path,"[",""));
        folder_path+=Trim(Strtran("/"+text_path, "...]",""));
        window.location.href='insert.jsp?for=<%=JSPLib.ToJSValue(request.getParameter("for"))%>&folder_path='+URLenc(folder_path);
      }else if(text_path.indexOf("[...]")>-1){
        folder_path=folder_path.substring(0,folder_path.lastIndexOf("/"));
        window.location.href='insert.jsp?for=<%=JSPLib.ToJSValue(request.getParameter("for"))%>&folder_path='+URLenc(folder_path);
      }else{
        setValue();
      }
    }
  }
  function setValue(){
    var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    if(folder_path.length>0) folder_path+="/";
    if(folder_path.charAt(0)=="/") folder_path=folder_path.substr(1);
    var returnObject='<%=JSPLib.ToJSValue(request.getParameter("for"))%>';
    if(cType!='portlet' && Empty(pName)){
      GetOpener().layerOpenForeground("insert.jsp?for="+returnObject+"&cType="+cType+"&pName="+name,"SelectEmitter",'',400,600,true,1);
      window.close();
      return;
    }
    if(cType=='portlet')
      GetOpener().document.getElementById(returnObject).value=name+'_portlet.jsp'
    else
      GetOpener().document.getElementById(returnObject).value=name;
    GetOpener().document.getElementById(returnObject).focus()
    window.close();
  }
  function getFileList(){
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>'
    if(folder_path!='') document.write("<option>[...]</option>");
    portletFiles=new JSURL("../servlet/JSPReader?type=portlet&folder_path="+folder_path);
    portletFiles=portletFiles.Response();
    var Files=portletFiles.split(',');
    var SelectObj=Ctrl('openlist');
    for(var i=0;i<Files.length;i++){
      var opt=new Option();
      opt.text=Strtran(Files[i], "_portlet.jsp", "");
      opt.value=Strtran(Files[i], "_portlet.jsp", "");
      SelectObj.options[i]=opt;
    }
  }
  function getDescription(){
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>'
    var name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var des = new JSURL("../servlet/JSPReader?type=portlet&action=description&name="+name+"&folder_path="+folder_path);
    des=des.Response();
    if(des=="undefined") des="No description";
    des=Strtran(des,'\u0080','\u20AC');
    Ctrl('description').value=des;
  }
  function getCtrlList(){
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>'
    var portlet_name=pName;  //Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    var action='';
    if(cType=='receiver')
      action="getReceivers";
    else if(cType=='emitter')
      action="getEmitters";
    else if(cType=='memorycursor')
      action="getMemoryCursor";
    var names = new JSURL("../servlet/JSPReader?action="+action+"&type=portlet&action=description&name="+portlet_name+"&folder_path="+folder_path);
    names=names.Response();
    var Names=names.split(',');
    var SelectObj=Ctrl('openlist');
    for(var i=0;i<Names.length;i++){
      var opt=new Option();
      opt.text=Names[i];
      opt.value=Names[i];
      SelectObj.options[i]=opt;
    }
  }
 </script>
</head>
<body onload='Init();'>
 <table style='height:100%;width:100%' border="0"  cellpadding="0" cellspacing="1" align="center" class="contornointerno">
  <tr>
   <td class="titoli" align="center" height="20"><b><div id='title'>Available files</div></b></td>
  </tr>
  <tr>
   <td class="contenuto">
    <select id="openlist" size='33' style="width:100%;height:100%" ondblclick="checkSelection()" onchange="getDescription()" accesskey="v">
    </select>
   </td>
  </tr>
  <tr>
   <td class="contenuto" align="center" style="width:100%;height:45px;">
    <textarea readonly id="description" style="width:100%;height:45px;"></textarea>
   </td>
  </tr>
  <tr>
   <td class="footer" align="center" height="20" nowrap>
    <button onclick="checkSelection();" accesskey="o" class="bottoni"><u>O</u>k</button>&nbsp;
    <button onclick="window.close();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>
