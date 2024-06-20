import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SPManageAutonumber extends spadministration_autonum {

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    entityGlobals.name = "SPManageAutonumber";
  }
  public boolean CheckAccess(SPServletStatus status,HttpServletResponse response) throws IOException {
    if (!CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.m_cErrMsg=status.context.Translate("MSG_ACC_NOT_ALLOWED");
      status.out=response.getWriter();
      WriteErrorPage(status);
      return false;
    }
    status.context.CanEventuallyZoomOn("SPManageAutonumber",entityGlobals.zoomableTables);
    return true;
  }
}
