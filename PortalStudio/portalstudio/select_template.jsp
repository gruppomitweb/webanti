<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%Sitepainter sp=new Sitepainter(request);
  if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples",""))) {
  sp.setContentType(response);
%>
<!DOCTYPE html>
<html>
<head>
 <title>Available Templates</title>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <style>
  .small{
    height: 45px;
    width: 60px;
  }
 </style>
 <script type="text/javascript">
  function openPagelet(tpl){
    var frontendport = 'frontendport=<%=JSPLib.ToJSValue(sp.getParameter("frontendport","0"))%>';
    var parms={frontendport:'<%=JSPLib.ToJSValue(sp.getParameter("frontendport","0"))%>',template_type: tpl}
    var obj = window.GetOpener();
    if(tpl>5){
      // var from = "?ifrId=<%=sp.getParameter("ifrId","")%>";
      parms.planIframeId='<%=JSPLib.ToJSValue(sp.getParameter("planIframeId",""))%>';
      parms.planItemId='<%=JSPLib.ToJSValue(sp.getParameter("planItemId",""))%>';
      if(obj && obj.newCurrentObj){
        obj.newCurrentObj('New','pageleteditor',parms);
        window.close();
      }else if(obj && obj.parent.newCurrentObj){
        obj.parent.newCurrentObj('New','pageleteditor',parms);
        window.close();
      }else{
        window.open("../pageleteditor/pagelet_editor.jsp?template_type="+tpl+'&'+frontendport, "pageletditor", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
        window.close();
      }
    }else{
      if(obj && obj.newCurrentObj){
        parms.template=tpl;
        obj.newCurrentObj('New','pagelet',parms);
        window.close();
      }else if(obj && obj.parent.newCurrentObj){
        parms.template=tpl;
        obj.parent.newCurrentObj('New','pagelet',parms);
        window.close();
      }else if(obj && obj.GetOpener() && obj.GetOpener().newCurrentObj){
        parms.template=tpl;
        obj.GetOpener().newCurrentObj('New','pagelet',parms);
        obj.close();
        window.close();
      }else{
        window.open("../pagelet/editor.jsp?template="+tpl+'&'+frontendport, "pageletditor_new", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
        window.close();
      }
    }
  }
 </script>
 <style>
  img{
    width: 108px;
  }
 </style>
</head>
<body style="border:0;overflow:hidden;margin:0">
 <table border="0" width="100%" height="100%" cellpadding="5" cellspacing="0" align="center" class="contenuto">
  <tr>
   <td colspan="6"  align="center" height="20" width="100%" class="titoli">Available templates</td>
  </tr>
  <tr>
   <td colspan="6"  align="left" height="20" class="titoli">New template editor</td>
  </tr>
  <tr class="contenuto">
   <td><a href="javascript:openPagelet(7)"><img src="../pagelet/images/off-canvas.gif" border="0"></a></td>
  </tr>
  <tr>
   <td colspan="6"  align="left" height="20" class="titoli">Old template editor</td>
  </tr>
  <tr class="contenuto">
   <td colspan=""><a href="javascript:openPagelet(0)"><img src="../pagelet/images/template0.gif" border="0"></a></td>
   <td><a href="javascript:openPagelet(1)"><img class="small" src="../pagelet/images/template1.gif" border="0"></a></td>
   <td><a href="javascript:openPagelet(2)"><img class="small" src="../pagelet/images/template2.gif" border="0"></a></td>
   <td><a href="javascript:openPagelet(3)"><img class="small" src="../pagelet/images/template3.gif" border="0"></a></td>
   <td><a href="javascript:openPagelet(4)"><img class="small" src="../pagelet/images/template4.gif" border="0"></a></td>
   <td><a href="javascript:openPagelet(5)"><img class="small" src="../pagelet/images/template5.gif" border="0"></a></td>
   <!--td><a href="javascript:openPagelet(6)"><img src="../pagelet/images/pageletEditor.gif" border="0"></a></td-->
   <!-- td><a href="javascript:openPagelet(8)"><img src="../pagelet/images/column-drop.svg" border="0"></a></td>
   <td><a href="javascript:openPagelet(8)"><img src="../pagelet/images/layout-shifter.svg" border="0"></a></td -->
  </tr>
 </table>
</body>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
