import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arfn_imp_newtabs_old extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ac9804c7*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String fhand;
    public String riga;
    public String _code1;
    public String _code;
    public String _code2;
    public String _code3;
    public String _code4;
    public String _code10;
    public String _code11;
    public String _code40;
    public double _codenum;
    public String _dbaicab;
    public double conta;
    public String _lista;
    public String _oldazi;
    public String _id4;
    public String _stringa;
    public double _id;
    public String gMsgImp;
    public String gMsgProc;
    public String gFlgWU;
    public String w_tbcitta;
    public String w_tbstati;
    public String w_tbsetsin;
    public String w_tbcauana;
    public String w_inter2bo;
    public String w_tbvalute;
    public String w_tbtipreg;
    public String w_tbtipint;
    public String w_tbesitoage;
    public String w_tbrapp;
    public String w_tbstgru;
    public String w_tbramgru;
    public String w_tbtipdoc;
    public String w_tbtipleg;
    public String w_tbtipnat;
    public String w_tberrorisid;
    public String w_tberrsiddgn;
    public String w_tbricevutesid;
    public String w_tbcittna;
    public String w_tbstatna;
    public String w_tberrdge;
    public String w_tbprvreg;
    public String w_tbesielb;
    public String w_convgio;
    public String w_staticrs;
    public String w_tbcandistr;
    public String w_tbluonas;
    public String w_tbprovsv;
    public String w_rapogg;
    public String w_tbnatura;
    public String w_tbscopo;
    public String w_tbrisglob;
    public String w_tbident;
    public String w_tbtipope;
    public String w_tbprcsched;
    public String aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcitta","w_tbcitta");
      }        
      w_tbcitta = source.GetParameter("w_tbcitta","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbstati","w_tbstati");
      }        
      w_tbstati = source.GetParameter("w_tbstati","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbsetsin","w_tbsetsin");
      }        
      w_tbsetsin = source.GetParameter("w_tbsetsin","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcauana","w_tbcauana");
      }        
      w_tbcauana = source.GetParameter("w_tbcauana","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_inter2bo","w_inter2bo");
      }        
      w_inter2bo = source.GetParameter("w_inter2bo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbvalute","w_tbvalute");
      }        
      w_tbvalute = source.GetParameter("w_tbvalute","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipreg","w_tbtipreg");
      }        
      w_tbtipreg = source.GetParameter("w_tbtipreg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipint","w_tbtipint");
      }        
      w_tbtipint = source.GetParameter("w_tbtipint","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbesitoage","w_tbesitoage");
      }        
      w_tbesitoage = source.GetParameter("w_tbesitoage","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbrapp","w_tbrapp");
      }        
      w_tbrapp = source.GetParameter("w_tbrapp","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbstgru","w_tbstgru");
      }        
      w_tbstgru = source.GetParameter("w_tbstgru","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbramgru","w_tbramgru");
      }        
      w_tbramgru = source.GetParameter("w_tbramgru","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipdoc","w_tbtipdoc");
      }        
      w_tbtipdoc = source.GetParameter("w_tbtipdoc","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipleg","w_tbtipleg");
      }        
      w_tbtipleg = source.GetParameter("w_tbtipleg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipnat","w_tbtipnat");
      }        
      w_tbtipnat = source.GetParameter("w_tbtipnat","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tberrorisid","w_tberrorisid");
      }        
      w_tberrorisid = source.GetParameter("w_tberrorisid","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tberrsiddgn","w_tberrsiddgn");
      }        
      w_tberrsiddgn = source.GetParameter("w_tberrsiddgn","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbricevutesid","w_tbricevutesid");
      }        
      w_tbricevutesid = source.GetParameter("w_tbricevutesid","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcittna","w_tbcittna");
      }        
      w_tbcittna = source.GetParameter("w_tbcittna","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbstatna","w_tbstatna");
      }        
      w_tbstatna = source.GetParameter("w_tbstatna","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tberrdge","w_tberrdge");
      }        
      w_tberrdge = source.GetParameter("w_tberrdge","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbprvreg","w_tbprvreg");
      }        
      w_tbprvreg = source.GetParameter("w_tbprvreg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbesielb","w_tbesielb");
      }        
      w_tbesielb = source.GetParameter("w_tbesielb","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_convgio","w_convgio");
      }        
      w_convgio = source.GetParameter("w_convgio","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_staticrs","w_staticrs");
      }        
      w_staticrs = source.GetParameter("w_staticrs","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcandistr","w_tbcandistr");
      }        
      w_tbcandistr = source.GetParameter("w_tbcandistr","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbluonas","w_tbluonas");
      }        
      w_tbluonas = source.GetParameter("w_tbluonas","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbprovsv","w_tbprovsv");
      }        
      w_tbprovsv = source.GetParameter("w_tbprovsv","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rapogg","w_rapogg");
      }        
      w_rapogg = source.GetParameter("w_rapogg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbnatura","w_tbnatura");
      }        
      w_tbnatura = source.GetParameter("w_tbnatura","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbscopo","w_tbscopo");
      }        
      w_tbscopo = source.GetParameter("w_tbscopo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbrisglob","w_tbrisglob");
      }        
      w_tbrisglob = source.GetParameter("w_tbrisglob","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbident","w_tbident");
      }        
      w_tbident = source.GetParameter("w_tbident","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipope","w_tbtipope");
      }        
      w_tbtipope = source.GetParameter("w_tbtipope","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbprcsched","w_tbprcsched");
      }        
      w_tbprcsched = source.GetParameter("w_tbprcsched","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arfn_imp_newtabs_old";
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
    arfn_imp_newtabs_oldR Rcalled;
    Rcalled = new arfn_imp_newtabs_oldR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa_retval = Rcalled.Run(status.w_tbcitta,status.w_tbstati,status.w_tbsetsin,status.w_tbcauana,status.w_inter2bo,status.w_tbvalute,status.w_tbtipreg,status.w_tbtipint,status.w_tbesitoage,status.w_tbrapp,status.w_tbstgru,status.w_tbramgru,status.w_tbtipdoc,status.w_tbtipleg,status.w_tbtipnat,status.w_tberrorisid,status.w_tberrsiddgn,status.w_tbricevutesid,status.w_tbcittna,status.w_tbstatna,status.w_tberrdge,status.w_tbprvreg,status.w_tbesielb,status.w_convgio,status.w_staticrs,status.w_tbcandistr,status.w_tbluonas,status.w_tbprovsv,status.w_rapogg,status.w_tbnatura,status.w_tbscopo,status.w_tbrisglob,status.w_tbident,status.w_tbtipope,status.w_tbprcsched);
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
    return new arfn_imp_newtabs_oldR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arfn_imp_newtabs_oldR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arfn_imp_newtabs_old"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa_retval))+"");
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
