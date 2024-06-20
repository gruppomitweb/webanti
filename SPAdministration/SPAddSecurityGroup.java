import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

public class SPAddSecurityGroup extends spselectsecuritygroup {

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    entityGlobals.name = "SPAddSecurityGroup";
  }
  public boolean CheckAccess(SPServletStatus status,HttpServletResponse response) throws IOException {
    if (!CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.m_cErrMsg=status.context.Translate("MSG_ACC_NOT_ALLOWED");
      status.out=response.getWriter();
      WriteErrorPage(status);
      return false;
    }
    return true;
  }
  
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    request.getRequestDispatcher("../jsp-system/spselectsecuritygroup_portlet.jsp").forward(request, response);
  }
}
