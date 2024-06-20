import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_fam_rstp_invio extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*48ba947b*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_stpinvio;
    public String w_stpinvio;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdatinvio;
    public java.sql.Date w_xdatinvio;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xtipinvio;
    public String w_xtipinvio;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xtpcinvio;
    public String w_xtpcinvio;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgdett;
    public String w_flgdett;
    public double _conta;
    public String _errore;
    public double _crea;
    public double _stampa;
    public double _okrep;
    public double _asaldi;
    public String w_anno;
    public String w_mese;
    public String gMsgImp;
    public String gMsgProc;
    public String gDescAzi;
    public java.sql.Date gScadSaldi;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_stpinvio = source.Has("w_stpinvio");
      if (m_bpassedw_stpinvio) {
        w_stpinvio = source.GetParameter("w_stpinvio",source.GetParameter("stpinvio",""));
      } else {
        if (source.IsForwarded()) {
          w_stpinvio = source.GetCaller().GetString("stpinvio","C",10,0);
          m_bpassedw_stpinvio = true;
        } else {
          w_stpinvio = source.GetParameter("stpinvio",source.GetParameter("w_stpinvio",""));
        }
      }
      m_bpassedw_xdatinvio = source.Has("w_xdatinvio");
      if (m_bpassedw_xdatinvio) {
        w_xdatinvio = source.GetParameter("w_xdatinvio",source.GetParameter("xdatinvio",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_xdatinvio = source.GetCaller().GetDate("xdatinvio","D",8,0);
          m_bpassedw_xdatinvio = true;
        } else {
          w_xdatinvio = source.GetParameter("xdatinvio",source.GetParameter("w_xdatinvio",CPLib.NullDate()));
        }
      }
      m_bpassedw_xtipinvio = source.Has("w_xtipinvio");
      if (m_bpassedw_xtipinvio) {
        w_xtipinvio = source.GetParameter("w_xtipinvio",source.GetParameter("xtipinvio",""));
      } else {
        if (source.IsForwarded()) {
          w_xtipinvio = source.GetCaller().GetString("xtipinvio","C",1,0);
          m_bpassedw_xtipinvio = true;
        } else {
          w_xtipinvio = source.GetParameter("xtipinvio",source.GetParameter("w_xtipinvio",""));
        }
      }
      m_bpassedw_xtpcinvio = source.Has("w_xtpcinvio");
      if (m_bpassedw_xtpcinvio) {
        w_xtpcinvio = source.GetParameter("w_xtpcinvio",source.GetParameter("xtpcinvio",""));
      } else {
        if (source.IsForwarded()) {
          w_xtpcinvio = source.GetCaller().GetString("xtpcinvio","C",1,0);
          m_bpassedw_xtpcinvio = true;
        } else {
          w_xtpcinvio = source.GetParameter("xtpcinvio",source.GetParameter("w_xtpcinvio",""));
        }
      }
      m_bpassedw_flgdett = source.Has("w_flgdett");
      if (m_bpassedw_flgdett) {
        w_flgdett = source.GetParameter("w_flgdett",source.GetParameter("flgdett",""));
      } else {
        if (source.IsForwarded()) {
          w_flgdett = source.GetCaller().GetString("flgdett","C",2,0);
          m_bpassedw_flgdett = true;
        } else {
          w_flgdett = source.GetParameter("flgdett",source.GetParameter("w_flgdett",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_fam_rstp_invio";
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
    return  ! (status.m_bpassedw_flgdett) ||  ! (status.m_bpassedw_xtpcinvio) ||  ! (status.m_bpassedw_xtipinvio) ||  ! (status.m_bpassedw_xdatinvio) ||  ! (status.m_bpassedw_stpinvio);
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
    if ( ! (status.m_bpassedw_stpinvio)) {
      status.out.println("l_cV=WtA(l_oWnd('w_stpinvio',"+SPLib.ToJSValue(status.w_stpinvio,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_stpinvio,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_stpinvio',l_cV);");
    if ( ! (status.m_bpassedw_xdatinvio)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_xdatinvio',"+SPLib.ToJSValue(status.w_xdatinvio,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdatinvio,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_xdatinvio',l_cV);");
    if ( ! (status.m_bpassedw_xtipinvio)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xtipinvio',"+SPLib.ToJSValue(status.w_xtipinvio,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xtipinvio,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xtipinvio',l_cV);");
    if ( ! (status.m_bpassedw_xtpcinvio)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xtpcinvio',"+SPLib.ToJSValue(status.w_xtpcinvio,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xtpcinvio,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xtpcinvio',l_cV);");
    if ( ! (status.m_bpassedw_flgdett)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgdett',"+SPLib.ToJSValue(status.w_flgdett,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgdett,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgdett',l_cV);");
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
    arrt_fam_rstp_invioR Rcalled;
    Rcalled = new arrt_fam_rstp_invioR(status.context,status);
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
    return new arrt_fam_rstp_invioR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_fam_rstp_invioR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_fam_rstp_invio"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_stpinvio="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_stpinvio),"?",0,0)+"");
        status.out.println("js:w_xdatinvio="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdatinvio),"?",0,0)+"");
        status.out.println("js:w_xtipinvio="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xtipinvio),"?",0,0)+"");
        status.out.println("js:w_xtpcinvio="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xtpcinvio),"?",0,0)+"");
        status.out.println("js:w_flgdett="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgdett),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_stpinvio,null)) {");
        status.out.println("window[f].w_stpinvio="+SPLib.ToJSValue(status.w_stpinvio,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdatinvio,null)) {");
        status.out.println(" window[f].w_xdatinvio.setTime(("+SPLib.ToJSValue(status.w_xdatinvio,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xtipinvio,null)) {");
        status.out.println("window[f].w_xtipinvio="+SPLib.ToJSValue(status.w_xtipinvio,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xtpcinvio,null)) {");
        status.out.println("window[f].w_xtpcinvio="+SPLib.ToJSValue(status.w_xtpcinvio,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgdett,null)) {");
        status.out.println("window[f].w_flgdett="+SPLib.ToJSValue(status.w_flgdett,"C",0,0)+";");
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
      arrt_fam_rstp_invioR Rcalled;
      Rcalled = new arrt_fam_rstp_invioR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_fam_rstp_invio");
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
