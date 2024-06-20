import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_import_masscf extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*dfe8d13e*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String fhand;
    public String riga;
    public double cNumNew;
    public double cNumMod;
    public String nomefileimport;
    public double nProgImp;
    public String _connes;
    public String _ragsoc;
    public String _codfisc;
    public String _esito;
    public double _cfestero;
    public String _nprog;
    public String _nomefileesi;
    public String _nfile;
    public double _contar;
    public double _conta;
    public double _conta2;
    public java.sql.Date _dnas;
    public String _sesso;
    public String _nasstato;
    public String _nascomun;
    public String _oldcon;
    public double _npers;
    public String _risultato;
    public String _protocollo;
    public String _fileprot;
    public String _descrsid;
    public String _tipodoc;
    public double _nriga;
    public String _txtstp;
    public String gPathApp;
    public String gPathDoc;
    public String gUrlApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public double w_tiporep;
    public String w_flgwuker;
    public String w_flgwrong;
    public String w_filexls;
    public String w_flgagg;
    public String cRitorno;
    public String _ndg1;
    public String _cfs1;
    public String _ndg2;
    public String _cfs2;
    public String w_nomefile;
    public String w_flgfam;
    public String w_flganf;
    public String w_flgant;
    public String w_flgxls;
    public String w_flgexa;
    public String w_flgcst;
    public String aaaaaaa_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_nomefile","w_nomefile");
      }        
      w_nomefile = source.GetParameter("w_nomefile","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgfam","w_flgfam");
      }        
      w_flgfam = source.GetParameter("w_flgfam","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flganf","w_flganf");
      }        
      w_flganf = source.GetParameter("w_flganf","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgant","w_flgant");
      }        
      w_flgant = source.GetParameter("w_flgant","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgxls","w_flgxls");
      }        
      w_flgxls = source.GetParameter("w_flgxls","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgexa","w_flgexa");
      }        
      w_flgexa = source.GetParameter("w_flgexa","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgcst","w_flgcst");
      }        
      w_flgcst = source.GetParameter("w_flgcst","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_import_masscf";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = false;
    return l_eg;
  }
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    // Inizializzazione delle variabili della classe globale di stato
    ServletStatus status;
    status = new ServletStatus();
    status.containing = this;
    SPParameterSource source;
    source = SPLib.GetSource(request);
    if ( ! (EnterServlet(status,source,request,response))) {
      return;
    }
    Begin(status);
  }
  boolean NeedsFetchPage(ServletStatus status) {
    return false;
  }
  private void ExecuteRoutine(ServletStatus status) throws IOException {
    arrt_import_masscfR Rcalled;
    Rcalled = new arrt_import_masscfR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaaaaa_retval = Rcalled.Run(status.w_nomefile,status.w_flgfam,status.w_flganf,status.w_flgant,status.w_flgxls,status.w_flgexa,status.w_flgcst);
      if (Rcalled.m_bError) {
        status.m_bError = true;
        status.m_cErrMsg = Rcalled.m_cLastMsgError;
      } else if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
        status.m_bError = true;
        status.m_cErrMsg = status.m_cFaultTrace;
      }
      if (CPLib.eqr(CPLib.Left(status.m_cAtExit,8),"workflow")) {
        ExitToWorkflow(status);
      }
      if (Forward.IsForwarded(status.forwardedto)) {
        if (CPLib.IsNull(status.forwardedto.GetParameterString("m_cAtExit",null))) {
          status.forwardedto.SetParameter("m_cAtExit",status.m_cAtExit);
        }
        SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
        return;
      }
    }
    BringBackPage(status,Rcalled);
  }
  CallerWithObjs NewRoutine(SPServletStatus status,Caller dataFromClient) {
    return new arrt_import_masscfR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_import_masscfR Rcalled) throws IOException {
    String l_cErrMsg;
    String msg;
    msg = status.context.Translate("MSG_END_ROUTINE");
    SPLib.SetContentType(status.response);
    SPLib.NoCache(status.response);
    status.out = status.response.getWriter();
    String l_cJsUid;
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<head>" +
    "");
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<link type='text/css' rel='STYLESHEET' href='../"+status.m_cTheme+"/formPage.css'>" +
    "");
    status.out.println(
     "</head>" +
    "");
    if (status.m_bError) {
      msg = status.context.Translate("MSG_END_ROUTINE_WITH_MSG");
      status.out.println(
       "<body onkeydown='window.ManageKeys(event,false,false)'>" +
      "");
    } else {
      status.out.println(
       "<body>" +
      "");
    }
    status.out.println(
     "<p class='TabLabel' style='margin:0'>" +
     ""+msg+"" +
     "</p>" +
    "");
    if (status.m_bError) {
      status.out.println(
       "<script type='text/javascript'>" +
      "");
      l_cErrMsg = status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(status.m_cErrMsg));
      status.out.println("detailed_database_error="+SPLib.ToJSValue(l_cErrMsg,"C",0,0)+";");
      status.out.println("m_cBrowser=" + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    status.out.println(
     "<!--" +
    "");
    if ( ! (CPLib.Empty(Rcalled.m_cLastMsgError))) {
      CPTokenSource ts;
      ts = new CPTokenSource(status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(Rcalled.m_cLastMsgError)),"\n");
      while (ts.HasMoreTokens()) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(ts.NextToken())+"");
      }
    }
    if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_import_masscf"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.aaaaaaa_retval))+"");
    status.out.println(
     " -->" +
    "");
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void Begin(ServletStatus status) throws IOException {
    if ( ! (CPLib.Empty(status.m_cGlobalsToRead))) {
      JSGlobals(status);
    } else if (CPLib.Empty(status.m_cBrowseName)) {
      ExecuteRoutine(status);
    } else {
      JSResultSet(status);
    }
  }
  void IncludeJS(ServletStatus status) {
    /* --- Area Manuale = UI - Include */
    /* --- Fine Area Manuale */
  }
  // m_CallableNames inizializzato dal primo accesso a GetCallableNames
  private static volatile String[] m_CallableNames;
  public static String[] GetCallableNames() {
    if (CPLib.IsNull(m_CallableNames)) {
      java.util.Set building = new java.util.HashSet();
      GetCallableNames(building);
      m_CallableNames = CPLib.SetOfStringsAsArray(building);
    }
    return (String[])m_CallableNames.clone();
  }
  public static void GetCallableNames(java.util.Set callable) {
  }
  String[] RoutineIDChain() {
    return GetCallableNames();
  }
}
