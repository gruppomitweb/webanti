import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_impdel_ip extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*e2bb1a76*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipodest;
    public String w_tipodest;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impzip;
    public double w_impzip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_annorif;
    public double w_annorif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_msgimp;
    public String w_msgimp;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_chkaui;
    public String w_chkaui;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_imperr;
    public String w_imperr;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_creamo;
    public String w_creamo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_fscarti;
    public double w_fscarti;
    public String fhand;
    public String riga;
    public double cNumNew;
    public double conta;
    public double _esito;
    public String _numprog;
    public String _czip;
    public String cNomeFileZip;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String _annope;
    public String _idrif;
    public String cCanc;
    public String cProg;
    public String _oldid;
    public java.sql.Date _datnew;
    public java.sql.Date _datfra;
    public String _tiporec;
    public String czipfile;
    public String cpercorsozip;
    public String cdirectoryfile;
    public String buffernomefile;
    public String nomefileimport;
    public double _priorita;
    public String gPathApp;
    public String gUrlApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_tipodest = source.Has("w_tipodest");
      if (m_bpassedw_tipodest) {
        w_tipodest = source.GetParameter("w_tipodest",source.GetParameter("tipodest",""));
      } else {
        if (source.IsForwarded()) {
          w_tipodest = source.GetCaller().GetString("tipodest","C",1,0);
          m_bpassedw_tipodest = true;
        } else {
          w_tipodest = source.GetParameter("tipodest",source.GetParameter("w_tipodest",""));
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
      m_bpassedw_annorif = source.Has("w_annorif");
      if (m_bpassedw_annorif) {
        w_annorif = source.GetParameter("w_annorif",source.GetParameter("annorif",0));
      } else {
        if (source.IsForwarded()) {
          w_annorif = source.GetCaller().GetNumber("annorif","N",4,0);
          m_bpassedw_annorif = true;
        } else {
          w_annorif = source.GetParameter("annorif",source.GetParameter("w_annorif",0));
        }
      }
      m_bpassedw_msgimp = source.Has("w_msgimp");
      if (m_bpassedw_msgimp) {
        w_msgimp = source.GetParameter("w_msgimp",source.GetParameter("msgimp",""));
      } else {
        if (source.IsForwarded()) {
          w_msgimp = source.GetCaller().GetString("msgimp","C",120,0);
          m_bpassedw_msgimp = true;
        } else {
          w_msgimp = source.GetParameter("msgimp",source.GetParameter("w_msgimp",""));
        }
      }
      m_bpassedw_chkaui = source.Has("w_chkaui");
      if (m_bpassedw_chkaui) {
        w_chkaui = source.GetParameter("w_chkaui",source.GetParameter("chkaui",""));
      } else {
        if (source.IsForwarded()) {
          w_chkaui = source.GetCaller().GetString("chkaui","C",1,0);
          m_bpassedw_chkaui = true;
        } else {
          w_chkaui = source.GetParameter("chkaui",source.GetParameter("w_chkaui",""));
        }
      }
      m_bpassedw_imperr = source.Has("w_imperr");
      if (m_bpassedw_imperr) {
        w_imperr = source.GetParameter("w_imperr",source.GetParameter("imperr",""));
      } else {
        if (source.IsForwarded()) {
          w_imperr = source.GetCaller().GetString("imperr","C",1,0);
          m_bpassedw_imperr = true;
        } else {
          w_imperr = source.GetParameter("imperr",source.GetParameter("w_imperr",""));
        }
      }
      m_bpassedw_creamo = source.Has("w_creamo");
      if (m_bpassedw_creamo) {
        w_creamo = source.GetParameter("w_creamo",source.GetParameter("creamo",""));
      } else {
        if (source.IsForwarded()) {
          w_creamo = source.GetCaller().GetString("creamo","C",1,0);
          m_bpassedw_creamo = true;
        } else {
          w_creamo = source.GetParameter("creamo",source.GetParameter("w_creamo",""));
        }
      }
      m_bpassedw_fscarti = source.Has("w_fscarti");
      if (m_bpassedw_fscarti) {
        w_fscarti = source.GetParameter("w_fscarti",source.GetParameter("fscarti",0));
      } else {
        if (source.IsForwarded()) {
          w_fscarti = source.GetCaller().GetNumber("fscarti","N",1,0);
          m_bpassedw_fscarti = true;
        } else {
          w_fscarti = source.GetParameter("fscarti",source.GetParameter("w_fscarti",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_impdel_ip";
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
    return  ! (status.m_bpassedw_fscarti) ||  ! (status.m_bpassedw_creamo) ||  ! (status.m_bpassedw_imperr) ||  ! (status.m_bpassedw_chkaui) ||  ! (status.m_bpassedw_msgimp) ||  ! (status.m_bpassedw_annorif) ||  ! (status.m_bpassedw_impzip) ||  ! (status.m_bpassedw_tipodest);
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
    if ( ! (status.m_bpassedw_tipodest)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipodest',"+SPLib.ToJSValue(status.w_tipodest,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipodest,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipodest',l_cV);");
    if ( ! (status.m_bpassedw_impzip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_impzip',"+SPLib.ToJSValue(status.w_impzip,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_impzip,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_impzip',l_cV);");
    if ( ! (status.m_bpassedw_annorif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_annorif',"+SPLib.ToJSValue(status.w_annorif,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_annorif,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_annorif',l_cV);");
    if ( ! (status.m_bpassedw_msgimp)) {
      status.out.println("l_cV=WtA(l_oWnd('w_msgimp',"+SPLib.ToJSValue(status.w_msgimp,"C",120,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_msgimp,"C",120,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_msgimp',l_cV);");
    if ( ! (status.m_bpassedw_chkaui)) {
      status.out.println("l_cV=WtA(l_oWnd('w_chkaui',"+SPLib.ToJSValue(status.w_chkaui,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_chkaui,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_chkaui',l_cV);");
    if ( ! (status.m_bpassedw_imperr)) {
      status.out.println("l_cV=WtA(l_oWnd('w_imperr',"+SPLib.ToJSValue(status.w_imperr,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_imperr,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_imperr',l_cV);");
    if ( ! (status.m_bpassedw_creamo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_creamo',"+SPLib.ToJSValue(status.w_creamo,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_creamo,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_creamo',l_cV);");
    if ( ! (status.m_bpassedw_fscarti)) {
      status.out.println("l_cV=WtA(l_oWnd('w_fscarti',"+SPLib.ToJSValue(status.w_fscarti,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_fscarti,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_fscarti',l_cV);");
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
    arrt_impdel_ipR Rcalled;
    Rcalled = new arrt_impdel_ipR(status.context,status);
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
    return new arrt_impdel_ipR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_impdel_ipR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_impdel_ip"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_tipodest="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipodest),"?",0,0)+"");
        status.out.println("js:w_impzip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impzip),"?",0,0)+"");
        status.out.println("js:w_annorif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_annorif),"?",0,0)+"");
        status.out.println("js:w_msgimp="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_msgimp),"?",0,0)+"");
        status.out.println("js:w_chkaui="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_chkaui),"?",0,0)+"");
        status.out.println("js:w_imperr="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_imperr),"?",0,0)+"");
        status.out.println("js:w_creamo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_creamo),"?",0,0)+"");
        status.out.println("js:w_fscarti="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_fscarti),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_tipodest,null)) {");
        status.out.println("window[f].w_tipodest="+SPLib.ToJSValue(status.w_tipodest,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_impzip,null)) {");
        status.out.println("window[f].w_impzip="+SPLib.ToJSValue(status.w_impzip,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_annorif,null)) {");
        status.out.println("window[f].w_annorif="+SPLib.ToJSValue(status.w_annorif,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_msgimp,null)) {");
        status.out.println("window[f].w_msgimp="+SPLib.ToJSValue(status.w_msgimp,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_chkaui,null)) {");
        status.out.println("window[f].w_chkaui="+SPLib.ToJSValue(status.w_chkaui,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_imperr,null)) {");
        status.out.println("window[f].w_imperr="+SPLib.ToJSValue(status.w_imperr,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_creamo,null)) {");
        status.out.println("window[f].w_creamo="+SPLib.ToJSValue(status.w_creamo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_fscarti,null)) {");
        status.out.println("window[f].w_fscarti="+SPLib.ToJSValue(status.w_fscarti,"N",0,0)+";");
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
      arrt_impdel_ipR Rcalled;
      Rcalled = new arrt_impdel_ipR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_impdel_ip");
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
