<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="org.json.JSONException" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples",""))) {
%><!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
 <title>Sitepainter Infinity Portalstudio</title>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psEditor.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/mif.tree.js")%>"></script>
 <link rel="stylesheet" type="text/css" href="portalstudioTheme.css" />
 <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
 <script  src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
 <link rel="shortcut icon" href="images/sp.ico" />
 <link rel="stylesheet" href="mif-tree.css" type="text/css">
 <link rel="stylesheet" href="nanoScrollerMT.css" type="text/css">
 <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudio.js")%>"></script>
 <script type="text/javascript">
 <% String [] tks=request.getContextPath().split("/"); %>
 webAppName='<%=tks[tks.length-1]%>'
  function PreloadTool(){
<%  String tool=sp.getParameter("tool","");
    String name=sp.getParameter("id","");
    String frontendport=sp.getParameter("frontendport","0");
    String offlinemode=sp.getParameter("offlinemode","false");
    String servlet=sp.getParameter("servlet","");
    String _path="";
    String custom=sp.getParameter("custom","false");
    if (name.indexOf("/")>=0){
      _path=name.substring(0,name.lastIndexOf("/"));
      name=name.substring(name.lastIndexOf("/")+1);
    }
    if("portlet".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'portlet',{'folder_path':'"+_path+"'" + ( !Library.Empty(servlet)? ",'servlet':'"+servlet+"'" : "" )+ "});");
    else if("pagelet".equals(tool)){
      if(name.equals(""))
        out.print("  selecttemplate(\'\','"+frontendport+"');");
      else
        out.print("newCurrentObj(\'"+name+"\',\'pagelet\',{'folder_path':'"+_path+"','frontendport':'"+frontendport+"'});");

    }else if("pageleteditor".equals(tool)){
      out.print("  newCurrentObj(\'"+name+"\',\'pageleteditor\',\'"+_path+"\');");
    }else if("visualquery".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'visualquery\',{'frontendport':"+frontendport+",'offlinemode':"+offlinemode+"});");
    else if("pageeditor".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'manualjsp',{'_path':"+_path+",'frontendport':"+frontendport+"});");
    else if("report".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'report\',{'frontendport':"+frontendport+"});");
    else if("smartreport".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'smartreport\',{'frontendport':"+frontendport+"});");
    else if("module".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'module\',\'\');");
    else if("scandoc".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'scandoc\',\'\');");
    else if("chart".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'chart\',\'\');");
    else if("plan".equals(tool))
      out.print("  newCurrentObj(\'"+name+"\',\'plan\',{'frontendport':"+frontendport+"});");
    else if("portalzoom".equals(tool)){
      if(name.equals(""))
        out.print("  openWin('../portalzoom/new.jsp?frontendport="+frontendport+"');");
     else
      out.print("  newCurrentObj(\'"+name+"\',\'portalzoom\',{'frontendport':"+frontendport+",'custom':"+custom+"});");
    }
    else if ("maskparameters".equals(tool)){
      out.print("  newCurrentObj(\'"+("".equals(name)?"New":name)+"\',\'maskparameters\',{'frontendport':"+frontendport+"});");
    }
    else if ("visualpivot".equals(tool)){
      out.print("  newCurrentObj(\'"+("".equals(name)?"New":name)+"\',\'visualpivot\',{'frontendport':"+frontendport+"});");
    }
%>
  }
<%
  SPJSPBridge.CPResultSet rs = sp.queryDirect(new com.zucchetti.sitepainter.SimpleQuery()
                                .addField("codazi")
                                .addField("desazi")
                                .addTable("cpazi"));
  JSONObject company=new JSONObject();
  try{
    while(!rs.Eof()){
      company.put(rs.GetColumnString(1).trim(),rs.GetColumnString(2).trim());
      rs.Next();
    }
  }
  catch(JSONException e){}
  rs.Close();
  rs = sp.queryDirect(new com.zucchetti.sitepainter.SimpleQuery()
                                .addField("code")
                                .addField("fullname")
                                .addField("name")
                                .addTable("cpusers"));
  JSONObject user=new JSONObject();
  try{
    while(!rs.Eof()){
      String userCode=rs.GetColumnString(1).trim();
      String userName=rs.GetColumnString(2).trim();
      if ("".equals(userName))
        userName=rs.GetColumnString(3).trim();
      user.put(userCode,userName);
      rs.Next();
    }
  }
  catch(JSONException e){}
  rs.Close();
  rs = sp.queryDirect(new com.zucchetti.sitepainter.SimpleQuery()
                                .addField("code")
                                .addField("name")
                                .addTable("cpgroups"));
  JSONObject group=new JSONObject();
  try{
    while(!rs.Eof()){
      group.put(rs.GetColumnString(1).trim(),rs.GetColumnString(2).trim());
      rs.Next();
    }
  }
  catch(JSONException e){}
  rs.Close();
%>
  var companyObj = <%=company%>
  var userObj = <%=user%>
  var groupObj = <%=group%>
  function openAbout() {
    alert('<%=JSPLib.ToJSValue(sp.GetToolVersion())%>');
  }
 </script>
</head>

<body onResize="ResizePS()" onkeydown="manageItems(event)" class="toolBig-opened">
	<div id="wrapAll">
	  <div id="paintersMenu"></div>
  	<div id="toolBig">
  		<div id="portletBtn" class='toolbar_btn' onClick="newCurrentObj('New','portlet',{})" style='background-image:url(images/icon/portletBtn.png);'  title="Portlet"></div>
			<div id="portletBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="portletBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Portlet Editor</span></div>
			</div>

			<div id="pageletBtn" onClick="selecttemplate('');" style='background-image:url(images/icon/pageletBtn.png);' title="Pagelet" class='toolbar_btn'></div>
			<div id="pageletBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="pageletBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Pagelet Editor</span></div>
			</div>

			<div id="pageletgroupBtn" onClick="newCurrentObj('New','plan')" style='background-image:url(images/icon/pageletgroupBtn.png);'  class='toolbar_btn' title="Plan"></div>
			<div id="pageletgroupBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="pageletgroupBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Pagelet Group Editor</span></div>
			</div>

			<div id="queryBtn" onClick="newCurrentObj('New','visualquery',{})" style='background-image:url(images/icon/queryBtn.png);' class='toolbar_btn' title="Visual Query"></div>
			<div id="queryBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="queryBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Visual Query Editor</span></div>
			</div>

			<div id="portalZoomBtn" onClick="openWin('../portalzoom/new.jsp');" style='background-image:url(images/icon/zoomBtn.png);'  class='toolbar_btn' title="Portal Zoom"></div>
			<div id="portalZoomBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="portalZoomBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Portal Zoom Editor</span></div>
			</div>

			<!--<div id="pageBtn" onClick="newCurrentObj('New','manualjsp',{});" style='background-image:url(images/icon/pageBtn.png);'  class='toolbar_btn' title="Page"></div>
			<div id="pageBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="pageBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Page Editor</span></div>
			</div>-->

			<div id="reportBtn" onClick="newCurrentObj('New','report',{});" style='background-image:url(images/icon/reportBtn.png);'  class='toolbar_btn' title="Report"></div>
			<div id="reportBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="reportBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Report Editor</span></div>
			</div>

      		<div id="smartreportBtn" onClick="newCurrentObj('New','smartreport',{});" style='background-image:url(images/icon/smartreportBtn.png);'  class='toolbar_btn' title="SmartReport"></div>
			<div id="smartreportBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="smartreportBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">SmartReport Editor</span></div>
			</div>

			<div id="chartBtn" onClick="newCurrentObj('New','chart',{});" style='background-image:url(images/icon/chartBtn.png);'  class='toolbar_btn' title="Chart"></div>
			<div id="chartBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="chartBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Chart Editor</span></div>
			</div>

			<div id="moduleBtn" onClick="newCurrentObj('New','module',{});" style='background-image:url(images/icon/moduleBtn.png);'  class='toolbar_btn' title="Module"></div>
			<div id="moduleBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="moduleBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Module Editor</span></div>
			</div>

			<div id="scaBtn" onClick="newCurrentObj('New','scandoc',{});" style='background-image:url(images/icon/scaBtn.png);'  class='toolbar_btn' title="ScanDoc"></div>
			<div id="scaBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="scaBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">ScanDoc Editor</span></div>
			</div>

			<div id="menuBtn" onClick="newCurrentObj('New','menu',{});" style='background-image:url(images/icon/menuBtn.png);'  class='toolbar_btn' title="Menu"></div>
			<div id="menuBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="menuBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Menu Editor</span></div>
			</div>

			<!--<div id="cssBtn" onClick="newCurrentObj('New','css',{});" style='background-image:url(images/icon/cssBtn.png);'  class='toolbar_btn' title="CSS"></div>
			<div id="cssBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="cssBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">CSS Editor</span></div>
			</div>-->

      <div id="maskparametersBtn" onClick="newCurrentObj('New','maskparameters');" style='background-image:url(images/icon/maskparametersBtn.png);' class='toolbar_btn' title="MaskParameters">
			  <div id="maskparametersBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="maskparametersBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Mask Parameters Editor</span></div></div>
			</div>

      <div id="classeditorBtn" onClick="newCurrentObj('New','cssclass');" style='background-image:url(images/icon/classeditor.png);' class='toolbar_btn' title="ClassEditor">
        <div id="classeditorBtnTxt" style="background:url(images/backbtntxt.png) no-repeat top right;cursor:pointer;display:none;float:left; height:45px; padding-left:5px; overflow:hidden;padding-top:15px;"><div id="classeditorBtnTxtWrapper"><span style="color:#FFFFFF; font-family:Tahoma,Verdana,Arial; font-weight:bold; font-size:11px;">Class Editor</span></div></div>
      </div>
      <span class="title"> <span class="big">SitePainter</span> Infinity Portalstudio</span>
		</div>
    <span id="title"> SitePainter Infinity Portalstudio</span>
		<div id="tlbopenclose"  title="Toggle tools selector" onclick="toggleToolbarBig()"></div>
    <div id="project_view_container" class="opened">
      <iframe id="project_view_frame" name="project_view_frame" frameborder="0" src="./projectView.jsp?m_cDecoration=none" style='width:100%; height:100%'></iframe>

      <div id="open_pv" onclick="toggleProjectView()"></div>
    </div>
	  <div id="tabwrapper" style="display:none;">
		  <div id='tabcontainer'></div>
	  </div>
  </div><iframe id="portalstudioframe0" name="portalstudioframe0" frameborder="0" style="width:100%;" src="portalstudio.html" class="portalstudioframes"></iframe>
  <iframe id="portalstudioframe1" name="portalstudioframe1" frameborder="0" style="display:none" class="portalstudioframes"></iframe>

<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
}%>

</body>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
