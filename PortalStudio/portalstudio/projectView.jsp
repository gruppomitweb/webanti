<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%@ page import="org.json.JSONException" %>
<%@ page import="org.json.JSONObject" %><%
Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples",""))) {
%>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>Project view</title>
   <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
   <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
   <script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
   <script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
   <script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>

   <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psEditor.js")%>"></script>
   <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/projectView.js")%>"></script>
   <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
   <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/mif.tree.js")%>"></script>
   <link rel="stylesheet" type="text/css" href="portalstudioTheme.css" />
   <link rel="stylesheet" href="mif-tree.css" type="text/css">
   <link rel="stylesheet" href="nanoScrollerMT.css" type="text/css">
   <style>
    body{
      background:transparent;
    }
   </style>
   <script>
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
        var showJSPSystem=<%=JSPLib.m_bShowJspSystemOnProjectView%>
      </script>
  </head>
  <body>
    <%if (!"none".equals(request.getParameter("m_cDecoration"))){ %>
    <div id='fileView'>
      <div id='toolbar'><%out.flush();
        if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp",true))
        if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp",true))
        Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp",false);%>
      </div>
    <div>
    <script>
            this.toolbar=ZtVWeb.getPortletInc('toolbar');
            this.toolbar.SetTitle('<%=sp.translate("MSG_PORTALSTUDIO_FILE")%>')
            var m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
            if(m_cTarget != "_blank") {
              this.toolbar.AppendButton({
                image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
                action:'../servlet/SPControlPanel',
                title:'<%=sp.translate("MSG_BACK")%>',
                tooltip:'<%=sp.translate("ADMIN_BACK_TO_CP")%>'
              })
            }
            this.toolbar.RearrangeAll();
            document.getElementById('toolbar').style.height=this.toolbar.Ctrl.offsetHeight+'px';
        </script>
    <%}%>
    <div id="project_view" style='top:0;'>
      <div class="tabcontainer">
        <div class="titletab tabSelected" id='pv_btn' onClick='toggleTree(this)'>Project view</div><div class="titletab" id='cv_btn' onClick='toggleTree(this)'> Custom view </div><div class="titletab" id='uv_btn' onClick='toggleTree(this)'> User view </div>
    <div id="tree_container"></div>
    <div id="customTree_container" style='display:none;'></div>
    <div id="userTree_container" style='display:none;'></div>
    <!--div id="open_pv" onclick="toggleProjectView()"></div-->
    </div>
    <input type='hidden' value=<%=JSPLib.ToHTMLValue(request.getParameter("m_cDecoration"))%>>
  </body>
</html>
<%}%>
