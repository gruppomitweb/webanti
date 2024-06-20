import java.io.PrintWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zucchetti.sitepainter.SPPrxycizer;

public class SPServerTestConnection extends SPServlet implements SPInvokable {
  static public class ServletStatus extends SPPageServletStatus {
  }

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    entityGlobals.name = "SPServerTestConnection";
  }

  public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    ServletStatus status = new ServletStatus();
    SPParameterSource source = SPLib.GetSource(request);
    status.context = SPLib.GetContext(SPLib.GetContextID(request), request);
    status.m_cTheme = SPLib.GetTheme(status.context);
    status.m_cBrowser = SPLib.GetBrowser(request);
    SPLib.SetContentType(response);
    status.out=response.getWriter();
    String ODBCDataSource = source.GetParameter("ODBCDataSource","");
    String DatabaseTypeString = source.GetParameter("DatabaseTypeString","");

    status.out.println("<html>");
    status.out.println("<head>");
    status.out.println("<script src='../"+SPPrxycizer.proxycizedPath("stdFunctions.js")+"'></script>");
    status.out.println("<script src='../"+SPPrxycizer.proxycizedPath("controls.js")+"'></script>");
    status.out.println("<script>");
    status.out.println("function PlatformPathStart(p_cName) {");
    status.out.println("return p_cName;");
    status.out.println("}");
    status.out.println("var m_cCaption = '"+status.context.Translate("MSG_SERVER_TEST_CONNECTION")+"';");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cFunction = 'dbadm';");
    status.out.println("</script>");
    String l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/styleVariables.js");
    status.out.println("<script src='../"+l_cJsUid+"'></script>");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calendar"+(SPLib.IsMobile(request)?".mobile":"")+".js");
    status.out.println(
            "<script src='../"+l_cJsUid+"' defer>" +
                    "</script>" +
                    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calculator"+(SPLib.IsMobile(request)?".mobile":"")+".js");
    status.out.println(
            "<script src='../"+l_cJsUid+"' defer>" +
                    "</script>" +
                    "");
    status.out.println("<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/queryPage.css'>");
    status.out.println("<script src='../"+status.m_cTheme+"/queryPage.js' type='text/javascript'></script>");
    status.out.println("<title>"+status.context.Translate("MSG_SERVER_TEST_CONNECTION")+"</title>");
    status.out.println("</head>");
    status.out.println("<script>");
    status.out.println("WriteBody_Begin(document,'',0,true,false);");
    status.out.println("</script>");

    if (!CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("<p align='center'><b>");
      status.out.println(status.context.Translate("MSG_ACC_NOT_ALLOWED"));
      status.out.println("</b></p>");
    }
    else {
      status.out.println("<br>");
      status.out.println("<p style='font-family:verdana;margin:10px;font-size:10pt;text-align:center'>");
      status.out.println("<b>");

      try {
        CPPooler.LoadDBDriver(DatabaseTypeString, ODBCDataSource);
        StringBuffer l_srv=new StringBuffer(ODBCDataSource), l_u=new StringBuffer(), l_p=new StringBuffer();
        CPPooler.CookDatasource(l_srv,l_u,l_p,false);
        CPPooler.GetConnFromSrv(l_srv.toString(),l_u.toString(),l_p.toString()).close();

        status.out.println(status.context.Translate("MSG_SERVER_CONNECTION_OK"));
        status.out.println("</b></p>");
      } catch (SQLException e) {
        status.out.println(status.context.Translate("MSG_SERVER_CONNECTION_ERROR"));
        status.out.println("</b></p><br>");
        status.out.println("<p style='font-family:verdana;margin:10px;font-size:8pt'>");
        status.out.println(status.context.Translate("MSG_LOOK_INTO_COUNTERS"));
        CPStdCounter.Error(new CPWarningError(e));
        status.out.println("</p>");
      } catch (NamingException e) {
        status.out.println(status.context.Translate("MSG_SERVER_CONNECTION_ERROR"));
        status.out.println("</b></p><br>");
        status.out.println("<p style='font-family:verdana;margin:10px;font-size:8pt'>");
        status.out.println(status.context.Translate("MSG_LOOK_INTO_COUNTERS"));
        status.out.println("</p>");
        CPStdCounter.Error(new CPWarningError(e));
      }
      status.out.println("<div align='center'>");
      status.out.println("<input type='button' value='"+status.context.Translate("ADMIN_CLOSE")+"' title='"+status.context.Translate("ADMIN_CLOSE")+"' onclick='WindowClose()'>");
      status.out.println("</div>");
    }
    status.out.println("<script>");
    status.out.println("WriteBody_EndHtml(document,false)");
    status.out.println("WriteBody_End(document)");
    status.out.println("</script>");
    status.out.println("</html>");
  }
}
