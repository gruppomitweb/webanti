import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@com.zucchetti.sitepainter.EntityRoles({"spauthid_admin"})
public class SPManageOIDCClients extends spadministration_users {
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    entityGlobals.name = "SPManageOIDCClients";
    entityGlobals.m_cZoomConfigName = "spauthid_zclients";
  }
  public String getEntityTitle() {
    return "Client";
  }
  public boolean CheckAccess(SPServletStatus status,HttpServletResponse response) throws IOException {
    boolean res = super.CheckAccess(status, response);
    if (res) {
      status.context.CanEventuallyZoomOn("SPManageOIDCClients",entityGlobals.zoomableTables);
      status.context.GetAuthority().AuthorizeUser("spadministration_usersgroups",true,true,true,true);
      status.context.GetAuthority().AuthorizeUser("spadministration_usercompanies",true,true,true,true);
    }
    return res;
  }
}
