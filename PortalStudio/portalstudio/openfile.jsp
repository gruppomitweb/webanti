<html>
<head>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  SPJSPBridge.CPResultSet rs;
  String tool=sp.getParameter("tool","");
  boolean enableselect=sp.getParameter("select",false);
  String filename=sp.getParameter("filename","");
%>
  <title>Open</title>
  <link rel="stylesheet" href="../properties.css" type="text/css">
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script type="text/javascript">
  function openTag(){
    window.open("openbytag.jsp","openbytag","height=600,width=800,left=200,top=150,status=no,toolbar=no,menubar=no,location=no,resizable");
  }
  function getOpener() {
   return (GetOpener()?GetOpener():(window.caller?window.caller:window.parent));
  }

  function openFile(){
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    var toolpath='<%=JSPLib.ToJSValue(sp.getParameter("tool",""))%>';
    if(Ctrl('openlist').selectedIndex>=0 && !Empty(Ctrl('filename').value)) {
      var text_path=Ctrl('filename').value;
      if(text_path.indexOf('...]')>-1 && text_path.indexOf('[')>-1 && text_path.length>5){
        text_path=Trim(Strtran(text_path,'[',''));
        folder_path+=Trim(Strtran('/'+text_path,'...]',''));
        window.location.href='open.jsp?tool='+toolpath+'&folder_path='+URLenc(folder_path);
      }
      else if(text_path.indexOf('[...]')>-1){
        folder_path=folder_path.substring(0,folder_path.lastIndexOf("/"));
        window.location.href='open.jsp?tool='+toolpath+'&folder_path='+URLenc(folder_path);
      }
      else{
        var SourceMode = "";
        if (Ctrl("sourcemode")) {
          if (Ctrl("sourcemode").checked) {
            SourceMode = "&source=1";
          }
        }
     <%if(!"".equals(sp.getParameter("pagelet_template_folder",""))){%>
        var path_tmp='<%=JSPLib.ToJSValue(sp.getParameter("pagelet_template_folder",""))%>';
     <%}else{%>
        var path_tmp=folder_path;
     <%}%>

     <%if("pagelet".equals(sp.getParameter("tool",""))){%> //interrogo qual'e' il template di questa pagelet
        getOpener().AddRecentOpen('pagelet',text_path,path_tmp);
        getOpener().newCurrentObj(text_path,Ctrl('path').value+path_tmp+text_path+SourceMode,path_tmp);
        closeDlg();
     <%}else if("css".equals(sp.getParameter("tool",""))){%>
        path_tmp=Ctrl("themes_list").value;
        getOpener().AddRecentOpen('css',text_path,path_tmp);
        getOpener().newCurrentObj(text_path,Ctrl('path').value+path_tmp+'/'+text_path+SourceMode,path_tmp+'/');
        closeDlg();
     <%}else if("decorators".equals(sp.getParameter("tool",""))){%>
        if(Ctrl("themes_list").value==''){
          path_tmp="/../"+Ctrl("themes_list").value+"jsp-decorators";
        }
        else{
          path_tmp="/../"+Ctrl("themes_list").value+"/jsp-decorators";
        }
        getOpener().AddRecentOpen('decorators',text_path,path_tmp);
        getOpener().newCurrentObj(text_path,Ctrl('path').value+path_tmp+'/'+text_path+SourceMode,path_tmp);
        closeDlg();
     <%}else if("portalzoom".equals(sp.getParameter("tool",""))){%>
        var configName=text_path.substring(0,text_path.indexOf("["));
        var table=text_path.substring(text_path.indexOf("[")+1,text_path.length-1);
        getOpener().newCurrentObj(text_path,Ctrl('path').value+path_tmp,path_tmp,"?Table="+table+'&ConfigName='+configName+'&ToolsbarState=open-config');
        closeDlg();
     <%}else if("scandoc".equals(sp.getParameter("tool","")) || "module".equals(sp.getParameter("tool",""))){%>
        if(getOpener().frames['portalstudioframe'+getOpener().currentIndex]){
          getOpener().AddRecentOpen('<%=JSPLib.ToJSValue(sp.getParameter("tool",""))%>',text_path,path_tmp);
        }
        if(getOpener().newCurrentObj){
          getOpener().newCurrentObj(text_path,Ctrl('path').value+(path_tmp!=''?path_tmp+'/':path_tmp)+text_path+SourceMode,path_tmp);
        }
        if(getOpener() && getOpener().setWdocModel){
          getOpener().setWdocModel(text_path+".mrp");
        }
        closeDlg();
     <%}else if( "pdf".equals(sp.getParameter("tool","")) || "pdfa1b".equals(sp.getParameter("tool","")) ) {%>
        if(getOpener() && getOpener().LoadPdfz){
          getOpener().LoadPdfz("modules/" + text_path + ".pdf","true");
        }
        else if(getOpener() && getOpener().setWdocModel){
          getOpener().setWdocModel(text_path + ".pdf");
        }
        closeDlg();
     <%}else if("xls".equals(sp.getParameter("tool",""))) {%>
        if(getOpener() && getOpener().setWdocModel){
          getOpener().setWdocModel(text_path);
        }
        closeDlg();
     <%}else if("xlsx".equals(sp.getParameter("tool",""))) {%>
        if(getOpener() && getOpener().setWdocModel){
          getOpener().setWdocModel(text_path);
        }
        closeDlg();
     <%}else if("offp".equals(sp.getParameter("tool",""))) {%>
        if(getOpener() && getOpener().setWdocModel){
          getOpener().setWdocModel(text_path);
        }
        closeDlg();
     <%}else if("xml".equals(sp.getParameter("tool",""))) {%>
        if(getOpener().Loadxml){
          getOpener().Loadxml("../xml/" +text_path + ".xml");
        }
        closeDlg();
     <%}else if("report".equals(sp.getParameter("tool",""))) {%>
        if(getOpener().Loadvrp){
          getOpener().Loadvrp(text_path+".vrp");
        }
        closeDlg();
     <%}else{%>
        getOpener().AddRecentOpen('<%=JSPLib.ToJSValue(sp.getParameter("tool",""))%>'||'portlet',text_path,path_tmp);
        getOpener().newCurrentObj(text_path,Ctrl('path').value+(path_tmp!=''?path_tmp+'/':path_tmp)+text_path+SourceMode,path_tmp);
        closeDlg();
     <%}%>
      }
    }
    else{
      closeDlg();
    }
  }
  function DoOnKeyDown(e){
    e = e ? e : window.event;
    var keyCode = GetKeyCode(e);
    if(keyCode==13){
      openFile();
    }
    else if(keyCode==27){
      closeDlg();
    }
  }
  function getDescription(){
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    var name,des;
    if(Ctrl('openlist').selectedIndex>=0){
      name=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
      if(name.indexOf('...]')==-1){
    <% if("visualquery".equals(tool)){%>
            des=new JSURL("../servlet/SPVQRProxy?action=notes&filename="+name);
    <% } else { %>
            des=new JSURL("../servlet/JSPReader?type=<%=("".equals(tool)?"portlet":JSPLib.ToJSValue(tool,false,true))%>&action=description&name="+name+'&folder_path='+folder_path);
    <% } %>
        des=des.Response();
      }
      if(Empty(des)) { des="No description"; }
      Ctrl('description').value=des;
    }
  }
  function setName(){
    if (Ctrl('openlist').selectedIndex!=-1){
      Ctrl('filename').value=Ctrl('openlist').options[Ctrl('openlist').selectedIndex].text;
    }
  }
  function submitType(form){
    Ctrl('filename').value='';
    Ctrl(form).submit();
  }
  function closeDlg(){
    if(window.parent && window.parent.closeSPModalLayer){
      window.parent.closeSPModalLayer();
    }
    else {
      window.close();
    }
  }
  </script>
  <link rel="shortcut icon" href="images/sp.ico" />
</head>
<body style="border:0;margin:0;overflow:hidden" onLoad="this.focus();Ctrl('openlist').focus();<%if("".equals(tool) || "portlet".equals(tool) || "visualquery".equals(tool) || "plan".equals(tool) || "module".equals(tool)) {%>getDescription()<%}%>">
 <table border="0" width="100%" height="100%" cellpadding="1" cellspacing="1" align="center">
  <tr style="display:none">
   <td class="contorno" align="center" height="20" colspan="2">Available files</td>
  </tr>
  <tr>
   <td class="contorno" height="100%" colspan="2">
    <select id="openlist" size="15" style="width:100%;height:100%" ondblclick="openFile()" onKeyDown="DoOnKeyDown(event)" <%if("".equals(tool) || "portlet".equals(tool) || "visualquery".equals(tool) || "plan".equals(tool) || "module".equals(tool)) {%>onClick="getDescription();setName()" onChange="getDescription();setName()" <%}else{%>onClick="setName()" onChange="setName()"<%}%> accesskey="v" >
     <script type="text/javascript">
      var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    <%if("".equals(tool) || "portlet".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=portlet&filter=<%=JSPLib.ToJSValue(filename,false,true)%>&folder_path="+folder_path);
      portletFiles=portletFiles.Response();
      if(folder_path!=""){
        document.write("<option>[...]</option>");
      }
      if(portletFiles!=""){
        var Files=portletFiles.split(',');
        for(var i=0;i<Files.length;i++){
          document.write("<option "+(i==0?'selected':'')+">"+Strtran(Files[i], "_portlet.jsp", "")+"</option>");
        }
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../visualweb/editor.htm?id=">
<%}else if("decorators".equals(tool)){%>
  <%if(!"".equals(sp.getParameter("pagelet_template_folder",""))){%>
      folder_path='..<%=JSPLib.ToJSValue(sp.getParameter("pagelet_template_folder",""))%>'+"jsp-decorators";
  <%}else{%>
      folder_path="../../jsp-decorators";
  <%}%>
      portletFiles=new JSURL("../servlet/JSPReader?type=decorators&filter=<%=JSPLib.ToJSValue(filename,false,true)%>&folder_path="+folder_path);
      portletFiles=portletFiles.Response();
      if(portletFiles!=""){
        var Files=portletFiles.split(',');
        for(var i=0;i<Files.length;i++){
          document.write("<option>"+Strtran(Files[i], "_portlet.jsp", "")+"</option>");
        }
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../visualweb/editor.htm?id=">
<%} else if("pagelet".equals(tool)){%>
  <%if(!"".equals(sp.getParameter("pagelet_template_folder",""))){%>
      var path_tmp='..<%=JSPLib.ToJSValue(sp.getParameter("pagelet_template_folder",""))%>';
  <%}else{%>
      var path_tmp=folder_path;
  <%}%>
      portletFiles = new JSURL("../servlet/JSPReader?type=pagelet&filter=<%=JSPLib.ToJSValue(filename,false,true)%>&folder_path="+path_tmp);
      portletFiles = portletFiles.Response();
      if(folder_path!="") document.write("<option>[...]</option>");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option "+(i==0?'selected':'')+">"+Strtran(Files[i], ".jsp","")+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../pagelet/editor.jsp?name=">
<%} else if("visualquery".equals(tool)){%>
      eval('VqrFiles = '+new JSURL("../servlet/SPVQRProxy?action=vqr&filter=<%=JSPLib.ToJSValue(filename,false,true)%>").Response().replace(/\.vqr/gi, ''));
      for(var i=0,l=VqrFiles.length; i<l; ){
        //document.write("<option>"+Strtran(VqrFiles[i], ".vqr", "")+"</option>");
        document.write("<option "+(i==0?'selected':'')+">"+VqrFiles[i++]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../visualquery/index.jsp?filename=">
<%} else if("portalzoom".equals(tool)){%>
      var zooms = new JSURL("../servlet/JSPReader?type=portalzoom&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      zooms=zooms.Response();
      if(zooms!=''){
        var Files=zooms.split(',');
        for(var i=0,l=Files.length; i<l; ){
          document.write("<option "+(i==0?'selected':'')+">"+Strtran(Strtran(Files[i++],".","["),"_vzm","")+"]</option>");
        }
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../jsp/SPPortalZoom.jsp">
<%} else if("chart".equals(tool)){%>
      allChartFiles=new JSURL("../servlet/SPChartServlet?filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      allChartFiles=allChartFiles.Response();
      var ChartFiles=allChartFiles.split(',');
      for(var i=0;i<ChartFiles.length;i++){
        if(ChartFiles[i].indexOf("__temp")<0) document.write("<option>"+ChartFiles[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../chart/index.jsp?filename=">
<%} else if("manualjsp".equals(tool)){%>
      if(folder_path!="") document.write("<option>[...]</option>");
      portletFiles=new JSURL("../servlet/JSPReader?filter=<%=JSPLib.ToJSValue(filename,false,true)%>&folder_path="+folder_path);
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option>"+Files[i]+"</option>")
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../pageeditor/index.jsp?action=load&name=">
<%} else if("templates".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=templates&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option>"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../pageeditor/index.jsp?action=load&type=template&name=">
<%} else if("plan".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=plan&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option "+(i==0?'selected':'')+">"+Strtran(Files[i], ".plandef", "")+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../planeditor/plan.jsp?id=">
<%} else if("html".equals(tool)){%>
      if(folder_path!="") document.write("<option>[...]</option>");
      portletFiles=new JSURL("../servlet/JSPReader?type=html&filter=<%=JSPLib.ToJSValue(filename,false,true)%>&folder_path="+folder_path);
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option>"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../pageeditor/index.jsp?action=load&type=html&name=">
<% } else if("report".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=webreport&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".vrp","");
      portletFiles=Strtran(portletFiles,".VRP","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../reporteditor/index.htm?id=">
<% } else if("css".equals(tool)){%>
  <%if(!"".equals(sp.getParameter("pagelet_template_folder",""))){%>
      var path_tmp='..<%=JSPLib.ToJSValue(sp.getParameter("pagelet_template_folder",""))%>';
  <%}else{%>
      var path_tmp=folder_path;
  <%}%>
      portletFiles=new JSURL("../servlet/JSPReader?type=css&filter=<%=JSPLib.ToJSValue(filename,false,true)%>&folder_path="+path_tmp);
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".css","");
      portletFiles=Strtran(portletFiles,".CSS","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        //modifica per nascondere i css temporanei
        if (!((Files[i].indexOf("tmp_csseditor_")>-1)&&(Files[i].length==24))){
          document.write("<option>"+Files[i]+"</option>");
        }
      }
     </script>
    </select>
    <input id="path" type="hidden" value="../csseditor/css_editor.jsp?name=">
<% } else if("scandoc".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=scandoc&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".sca","");
      portletFiles=Strtran(portletFiles,".SCA","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
      if(getOpener().frames["portalstudioframe"+getOpener().currentIndex]){
        document.write("<input id='path' type='hidden' value='../scaneditor/scaneditor.jsp?toolbar=false&id='>");
      }
      else{
        document.write("<input id='path' type='hidden' value='../scaneditor/scaneditor.jsp?id='>");
      }
     </script>
    </select>
<% } else if("module".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=module&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".mrp","");
      portletFiles=Strtran(portletFiles,".MRP","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
      if(getOpener().frames["portalstudioframe"+getOpener().currentIndex]){
        document.write("<input id='path' type='hidden' value='../moduleeditor/moduleeditor.jsp?toolbar=false&id='>");
      }
      else{
        document.write("<input id='path' type='hidden' value='../moduleeditor/moduleeditor.jsp?id='>");
      }
     </script>
    </select>
<% } else if("pdf".equals(tool) || "pdfa1b".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=pdf&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".pdf","");
      portletFiles=Strtran(portletFiles,".PDF","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="">
<% } else if("xls".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=xls&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="">
<% } else if("xlsx".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=xlsx&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="">
<% } else if("offp".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=offp&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="">
<% } else if("xml".equals(tool)){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=xml&filter=<%=JSPLib.ToJSValue(filename,false,true)%>");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".xml","");
      portletFiles=Strtran(portletFiles,".XML","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<option >"+Files[i]+"</option>");
      }
     </script>
    </select>
    <input id="path" type="hidden" value="">
<% } %>
   </td>
  </tr>
  <tr>
<%if("manualjsp".equals(tool) || "templates".equals(tool)) {%>
   <td class="contornointerno" align="left" colspan="2" style="width:100%;height:30px;font-size:10pt;font-family:tahoma;">
    <input id="sourcemode" type="checkbox" title="Opening a document in source mode will not change the structure of manual jsp file.">
    <label for="sourcemode">Open in Source-mode</label>
   </td>
<%}else if("pagelet".equals(tool) || "css".equals(tool) || "decorators".equals(tool)){ %>
   <td class="contornointerno" align="left" colspan="2" style="width:100%;height:30px;font-size:10pt;font-family:tahoma;">
    Open template from theme:
    <form id="form2" action="open.jsp" style="margin:0;display:inline">
     <select id="themes_list" name="themes_list_name" class="propertiesTablePValueCheckbox" onChange="fixPath(this);submitType('form2')">
      <option value="">-</option>
     </select>
   <%if("pagelet".equals(tool)){%>
     <input type="hidden" name="tool" value="pagelet">
   <%}else if("decorators".equals(tool)){%>
     <input type="hidden" name="tool" value="decorators">
   <%}else{%>
     <input type="hidden" name="tool" value="css">
   <%}%>
     <input type="hidden" name="folder_path" value=<%=JSPLib.ToHTMLValue(sp.getParameter("folder_path",""))%>>
     <input type="hidden" name="pagelet_template_folder" value="">
     <input type="hidden" name="theme" value="">
    </form>
    <script type="text/javascript">
      function Themes_List(){
        var theme_tmp='<%=JSPLib.ToJSValue(sp.getParameter("theme",""))%>';
        var output=new JSURL("../servlet/JSPReader?type=themes",true);
        output=output.Response();
        var themes_list=Ctrl("themes_list");
        var list=output.split(",");
        for(var i=0;i<list.length-1;i++){
          opt=new Option;
          opt.text=list[i];
          opt.value=list[i];
          themes_list.options[i+1]=opt;
          if(themes_list.options[themes_list.options.length-1].value==theme_tmp){
            themes_list.options[themes_list.options.length-1].selected="selected";
          }
        }
      }
      function fixPath(obj){
        if(obj.value==""){
          Ctrl("pagelet_template_folder").value="";
        }
        else{
          Ctrl("pagelet_template_folder").value="/../"+obj.value+"/";
        }
        Ctrl("theme").value=obj.value;
      }
      Themes_List();
    </script>
   </td>
<%} else { %>
   <td id='contornointerno' class="contornointerno" align="center" colspan="2" height="45px">
    <textarea readonly id="description" style="width:100%;height:100%;font-size:9pt;font-family:tahoma;background-color:#E0E0E0"></textarea>
   </td>
<%}%>
  </tr>
  <tr id="stooltitle">
   <td class="contorno" align="center" height="20" colspan="2"><b>File <u>t</u>ype</b></td>
  </tr>
  <form id="form1" action="open.jsp">
  <tr>
    <td class="contorno" width="100%" align="center">
     <input style="display:none" type="text" name="filename" value="" style="width:100%" accesskey="n">
    </td>
    <td class="contorno" align="right" style="padding:10px" nowrap>
     <button onClick="openFile()" accesskey="o" class="bottoni SPButton" style="margin-right:1"><u>O</u>K</button>
     <button onClick="closeDlg()" accesskey="c" class="bottoni SPButton" style="margin-right:1"><u>C</u>ancel</button>
    </td>
   </tr>
   <tr>
    <td id="stoollist" class="contorno" height="20" width="100%" valign="middle" align="center" colspan="2">
     <select id="stool" name="stool" onChange="submitType('form1')" style="width:100%" accesskey="t">
      <option <%if("module".equals(tool)) out.print("selected");%> value="module">Module</option>
      <option <%if("pdfa1b".equals(tool)) out.print("selected");%> value="pdf">Pdf</option>
      <option <%if("pdf".equals(tool)) out.print("selected");%> value="pdf">Pdf</option>
      <option <%if("report".equals(tool)) out.print("selected");%> value="report">Report</option>
      <option <%if("xml".equals(tool)) out.print("selected");%> value="xml">Xml</option>
      <option <%if("xls".equals(tool)) out.print("selected");%> value="xls">Xls</option>
      <option <%if("xlsx".equals(tool)) out.print("selected");%> value="xlsx">Xlsx</option>
      <option <%if("offp".equals(tool)) out.print("selected");%> value="offp">Docx\Odt</option>
     </select>
     <input type="hidden" name="folder_path" value=<%=JSPLib.ToHTMLValue(sp.getParameter("folder_path",""))%>>
     <input type="hidden" name="toolenable" value=<%=sp.getParameter("toolenable",true)%>>
     <input type="hidden" name="tool" value=<%=JSPLib.ToHTMLValue(sp.getParameter("tool",""))%>>
    </td>
   </tr>
   <tr>
    <td style="display:none" class="contorno" align="center" height="20" colspan="2"><b>File <u>n</u>ame</b></td>
   </tr>

  </form>
 </table>
</body>
<script>
  var toolenable=<%=sp.getParameter("toolenable",true)%>;
  var tool='<%=JSPLib.ToJSValue(sp.getParameter("tool",""))%>';
  if(!toolenable){
    Ctrl("stool").disabled=!toolenable;
    Ctrl("stoollist").style.display = 'none';
    Ctrl("stooltitle").style.display = 'none';
  }
  else{
    Ctrl("stool").options[0]=null;
    Ctrl("stool").options[0]=null;
  }
  if(tool == 'pdf' || tool == 'pdfa1b' || tool == 'offp'|| tool == 'xls'|| tool == 'xlsx'|| tool == 'xml') {
    Ctrl("contornointerno").style.display = 'none';
  }
  var theme='<%=JSPLib.ToJSValue(sp.getParameter("theme",""))%>';
  if(theme && theme.length>0){
    var l=document.createElement('link');
    l.rel="StyleSheet";
    l.type="text/css";
    l.href='../'+theme+'/formPage.css';
    document.getElementsByTagName('head')[0].appendChild(l);
  }
</script>
</html>
