import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_import_masscf_xls extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*90c2f13e*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_nomefile;
    public String w_nomefile;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgfam;
    public String w_flgfam;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgwuker;
    public String w_flgwuker;
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
    public double riga_letta;
    public double foglio;
    public String cProgSto;
    public java.sql.Date _data;
    public String gPathApp;
    public String gUrlApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_nomefile = source.Has("w_nomefile");
      if (m_bpassedw_nomefile) {
        w_nomefile = source.GetParameter("w_nomefile",source.GetParameter("nomefile",""));
      } else {
        if (source.IsForwarded()) {
          w_nomefile = source.GetCaller().GetString("nomefile","C",80,0);
          m_bpassedw_nomefile = true;
        } else {
          w_nomefile = source.GetParameter("nomefile",source.GetParameter("w_nomefile",""));
        }
      }
      m_bpassedw_flgfam = source.Has("w_flgfam");
      if (m_bpassedw_flgfam) {
        w_flgfam = source.GetParameter("w_flgfam",source.GetParameter("flgfam",""));
      } else {
        if (source.IsForwarded()) {
          w_flgfam = source.GetCaller().GetString("flgfam","C",1,0);
          m_bpassedw_flgfam = true;
        } else {
          w_flgfam = source.GetParameter("flgfam",source.GetParameter("w_flgfam",""));
        }
      }
      m_bpassedw_flgwuker = source.Has("w_flgwuker");
      if (m_bpassedw_flgwuker) {
        w_flgwuker = source.GetParameter("w_flgwuker",source.GetParameter("flgwuker",""));
      } else {
        if (source.IsForwarded()) {
          w_flgwuker = source.GetCaller().GetString("flgwuker","C",1,0);
          m_bpassedw_flgwuker = true;
        } else {
          w_flgwuker = source.GetParameter("flgwuker",source.GetParameter("w_flgwuker",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_import_masscf_xls";
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
    return  ! (status.m_bpassedw_flgwuker) ||  ! (status.m_bpassedw_flgfam) ||  ! (status.m_bpassedw_nomefile);
  }
  private void FetchPage(ServletStatus status) throws IOException {
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
    IncludeJS(status);
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    status.out.println(
     "</head>" +
    "");
    status.out.println(
     "<body>" +
    "");
    status.out.println(
     "<form name='RoutineParms' method='POST' action='"+status.m_cURL+"'>" +
    "");
    status.out.println(
     "<input name='m_cAction' type='hidden' value="+SPLib.ToHTMLValue("execute","C",0,0)+">" +
    "");
    status.out.println(
     "<input name='m_cAtExit' type='hidden' value="+SPLib.ToHTMLValue(status.m_cAtExit,"C",0,0)+">" +
    "");
    status.out.println(
     "<input name='m_cWv' type='hidden' value=''>" +
    "");
    status.out.println(
     "</form>" +
    "");
    status.out.println(
     "<p>" +
     ""+status.context.Translate("MSG_ROUTINE_WAIT")+"" +
     "</p>" +
    "");
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    status.out.println("AppletTag('Wv','Trs');");
    status.out.println("var l_oWv = InitWvApplet();");
    status.out.println("var l_oWnd;");
    status.out.println("var l_cV;");
    if (SPLib.HasRegionalSettings(status.context)) {
      status.out.println("SetWindowObject(false);");
    } else {
      status.out.println("SetWindowObject(true);");
    }
    if ( ! (status.m_bpassedw_nomefile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_nomefile',"+SPLib.ToJSValue(status.w_nomefile,"C",80,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_nomefile,"C",80,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_nomefile',l_cV);");
    if ( ! (status.m_bpassedw_flgfam)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgfam',"+SPLib.ToJSValue(status.w_flgfam,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgfam,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgfam',l_cV);");
    if ( ! (status.m_bpassedw_flgwuker)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgwuker',"+SPLib.ToJSValue(status.w_flgwuker,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgwuker,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgwuker',l_cV);");
    status.out.println("document.RoutineParms.m_cWv.value=WvApplet().asString();");
    status.out.println("document.RoutineParms.submit();");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void ExecuteRoutine(ServletStatus status) throws IOException {
    arrt_import_masscf_xlsR Rcalled;
    Rcalled = new arrt_import_masscf_xlsR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run();
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
    return new arrt_import_masscf_xlsR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_import_masscf_xlsR Rcalled) throws IOException {
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
    if (CPLib.eqr(status.m_cAction,"executeAsync")) {
      status.out.println(
       "<!--" +
      "");
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync()))+"");
      status.out.println(
       " -->" +
      "");
    } else {
      if (status.m_bApplet) {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_import_masscf_xls"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_nomefile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_nomefile),"?",0,0)+"");
        status.out.println("js:w_flgfam="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgfam),"?",0,0)+"");
        status.out.println("js:w_flgwuker="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgwuker),"?",0,0)+"");
        status.PrintMutableParameters();
        status.out.println(
         " -->" +
        "");
      } else {
        status.out.println(
         "<script type='text/javascript'>" +
        "");
        status.out.println("f=NameForCaller();");
        status.out.println("if (IsWndAccessible(window[f])) {");
        status.out.println("if (Ne(typeof(window[f].DisplayErrorMessage),'undefined') && Ne(typeof(window[f].CalledBatchEnd),'undefined')) {");
        status.out.println("if (Ne(window[f].w_nomefile,null)) {");
        status.out.println("window[f].w_nomefile="+SPLib.ToJSValue(status.w_nomefile,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgfam,null)) {");
        status.out.println("window[f].w_flgfam="+SPLib.ToJSValue(status.w_flgfam,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgwuker,null)) {");
        status.out.println("window[f].w_flgwuker="+SPLib.ToJSValue(status.w_flgwuker,"C",0,0)+";");
        status.out.println("}");
        if (status.m_bError) {
          l_cErrMsg = status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(status.m_cErrMsg));
          status.out.println("window[f].l_cErrorMsg="+SPLib.ToJSValue(l_cErrMsg,"C",0,0)+";");
          status.out.println("window[f].DisplayErrorMessage();");
        } else {
          status.out.println("window[f].CalledBatchEnd();");
        }
        status.out.println("}");
        status.out.println("CloseEnclosing();");
        status.out.println("}");
        status.out.println(
         "</script>" +
        "");
      }
    }
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void Begin(ServletStatus status) throws IOException {
    if ( ! (CPLib.Empty(status.m_cBrowseName))) {
      JSResultSet(status);
    } else if ( ! (CPLib.Empty(status.m_cGlobalsToRead))) {
      JSGlobals(status);
    } else if (CPLib.eqr(status.m_cAction,"start") && NeedsFetchPage(status)) {
      FetchPage(status);
    } else if (CPLib.eqr(status.m_cAction,"execute") || CPLib.eqr(status.m_cAction,"start") || CPLib.eqr(status.m_cAction,"executeAsync")) {
      ExecuteRoutine(status);
    } else {
      arrt_import_masscf_xlsR Rcalled;
      Rcalled = new arrt_import_masscf_xlsR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_import_masscf_xls");
      if ( ! (CPLib.IsNull(l))) {
        l.log(Rcalled.m_cLastMsgError);
      }
      status.m_bError = true;
      status.m_cErrMsg = Rcalled.m_cLastMsgError;
      BringBackPage(status,Rcalled);
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
