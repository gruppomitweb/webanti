import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

public class SPManageSecurity extends spadministration_security {

  static public class ServletStatus extends spadministration_security.ServletStatus {
  }
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    entityGlobals.name = "SPManageSecurity";
  }
  public SPEntityGlobals getEntityGlobals() {
    SPEntityGlobals l_eg = super.getEntityGlobals();
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    return l_eg;
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
}
