import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_imp_esiti extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*b3e067d5*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_msgproc;
    public String w_msgproc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_scelta;
    public double w_scelta;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impzip;
    public double w_impzip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedgMsgProc;
    public String gMsgProc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_nomefile;
    public String w_nomefile;
    public String fhand;
    public String riga;
    public String _filename;
    public double salta;
    public double findesito;
    public String nprog;
    public String esito;
    public String esito2;
    public String idbase;
    public double nputf8;
    public double npnormal;
    public double nProgImp;
    public double _max;
    public double _min;
    public double _cicli;
    public double _contacilci;
    public double _bottom;
    public double _top;
    public double contafile;
    public String _aprog;
    public String _afile;
    public String _cprog;
    public String _cfile;
    public String rapporto;
    public String tipoac;
    public String connes;
    public String ident;
    public String ragsoc;
    public String persona;
    public String cognome;
    public String nome;
    public String sesso;
    public java.sql.Date datanasc;
    public String nascomun;
    public String nasstato;
    public String tipinter;
    public String desccit;
    public String provincia;
    public String codfisc;
    public String codcab;
    public String czipfile;
    public String cpercorsozip;
    public String cdirectoryfile;
    public String buffernomefile;
    public String nomefileimport;
    public double _priorita;
    public String gPathApp;
    public String gAzienda;
    public String gMsgImp;
    public double gOkPrintEsiti;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_msgproc = source.Has("w_msgproc");
      if (m_bpassedw_msgproc) {
        w_msgproc = source.GetParameter("w_msgproc",source.GetParameter("msgproc",""));
      } else {
        if (source.IsForwarded()) {
          w_msgproc = source.GetCaller().GetString("msgproc","M",10,0);
          m_bpassedw_msgproc = true;
        } else {
          w_msgproc = source.GetParameter("msgproc",source.GetParameter("w_msgproc",""));
        }
      }
      m_bpassedw_scelta = source.Has("w_scelta");
      if (m_bpassedw_scelta) {
        w_scelta = source.GetParameter("w_scelta",source.GetParameter("scelta",0));
      } else {
        if (source.IsForwarded()) {
          w_scelta = source.GetCaller().GetNumber("scelta","N",1,0);
          m_bpassedw_scelta = true;
        } else {
          w_scelta = source.GetParameter("scelta",source.GetParameter("w_scelta",0));
        }
      }
      m_bpassedw_impzip = source.Has("w_impzip");
      if (m_bpassedw_impzip) {
        w_impzip = source.GetParameter("w_impzip",source.GetParameter("impzip",0));
      } else {
        if (source.IsForwarded()) {
          w_impzip = source.GetCaller().GetNumber("impzip","N",1,0);
          m_bpassedw_impzip = true;
        } else {
          w_impzip = source.GetParameter("impzip",source.GetParameter("w_impzip",0));
        }
      }
      m_bpassedgMsgProc = source.Has("gMsgProc");
      if (m_bpassedgMsgProc) {
        gMsgProc = source.GetParameter("gMsgProc",source.GetParameter("gMsgProc",""));
      } else {
        if (source.IsForwarded()) {
          gMsgProc = source.GetCaller().GetString("gMsgProc","M",10,0);
          m_bpassedgMsgProc = true;
        } else {
          gMsgProc = source.GetParameter("gMsgProc",source.GetParameter("gMsgProc",""));
        }
      }
      m_bpassedw_nomefile = source.Has("w_nomefile");
      if (m_bpassedw_nomefile) {
        w_nomefile = source.GetParameter("w_nomefile",source.GetParameter("nomefile",""));
      } else {
        if (source.IsForwarded()) {
          w_nomefile = source.GetCaller().GetString("nomefile","C",100,0);
          m_bpassedw_nomefile = true;
        } else {
          w_nomefile = source.GetParameter("nomefile",source.GetParameter("w_nomefile",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_imp_esiti";
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
    return  ! (status.m_bpassedw_nomefile) ||  ! (status.m_bpassedgMsgProc) ||  ! (status.m_bpassedw_impzip) ||  ! (status.m_bpassedw_scelta) ||  ! (status.m_bpassedw_msgproc);
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
    if ( ! (status.m_bpassedw_msgproc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_msgproc',"+SPLib.ToJSValue(status.w_msgproc,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_msgproc,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_msgproc',l_cV);");
    if ( ! (status.m_bpassedw_scelta)) {
      status.out.println("l_cV=WtA(l_oWnd('w_scelta',"+SPLib.ToJSValue(status.w_scelta,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_scelta,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_scelta',l_cV);");
    if ( ! (status.m_bpassedw_impzip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_impzip',"+SPLib.ToJSValue(status.w_impzip,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_impzip,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_impzip',l_cV);");
    if ( ! (status.m_bpassedgMsgProc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_gMsgProc',"+SPLib.ToJSValue(status.gMsgProc,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.gMsgProc,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('gMsgProc',l_cV);");
    if ( ! (status.m_bpassedw_nomefile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_nomefile',"+SPLib.ToJSValue(status.w_nomefile,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_nomefile,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_nomefile',l_cV);");
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
    arrt_imp_esitiR Rcalled;
    Rcalled = new arrt_imp_esitiR(status.context,status);
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
    return new arrt_imp_esitiR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_imp_esitiR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_imp_esiti"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_msgproc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_msgproc),"?",0,0)+"");
        status.out.println("js:w_scelta="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_scelta),"?",0,0)+"");
        status.out.println("js:w_impzip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impzip),"?",0,0)+"");
        status.out.println("js:gMsgProc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.gMsgProc),"?",0,0)+"");
        status.out.println("js:w_nomefile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_nomefile),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_msgproc,null)) {");
        status.out.println("window[f].w_msgproc="+SPLib.ToJSValue(status.w_msgproc,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_scelta,null)) {");
        status.out.println("window[f].w_scelta="+SPLib.ToJSValue(status.w_scelta,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_impzip,null)) {");
        status.out.println("window[f].w_impzip="+SPLib.ToJSValue(status.w_impzip,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_gMsgProc,null)) {");
        status.out.println("window[f].w_gMsgProc="+SPLib.ToJSValue(status.gMsgProc,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_nomefile,null)) {");
        status.out.println("window[f].w_nomefile="+SPLib.ToJSValue(status.w_nomefile,"C",0,0)+";");
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
      arrt_imp_esitiR Rcalled;
      Rcalled = new arrt_imp_esitiR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_imp_esiti");
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
