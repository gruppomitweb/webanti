import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_login extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*673742a9*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CodUte;
    public String w_CodUte;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PwdUte;
    public String w_PwdUte;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ErrLogin;
    public String w_ErrLogin;
    public String w_usercode;
    public String w_pwd;
    public double w_utentecp;
    public double gUserCode;
    public String gUtente;
    public String gEmail;
    public String gIntemediario;
    public String gTipInter;
    public String gDescAzi;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_CodUte = source.Has("w_CodUte");
      if (m_bpassedw_CodUte) {
        w_CodUte = source.GetParameter("w_CodUte",source.GetParameter("CodUte",""));
      } else {
        if (source.IsForwarded()) {
          w_CodUte = source.GetCaller().GetString("CodUte","C",10,0);
          m_bpassedw_CodUte = true;
        } else {
          w_CodUte = source.GetParameter("CodUte",source.GetParameter("w_CodUte",""));
        }
      }
      m_bpassedw_PwdUte = source.Has("w_PwdUte");
      if (m_bpassedw_PwdUte) {
        w_PwdUte = source.GetParameter("w_PwdUte",source.GetParameter("PwdUte",""));
      } else {
        if (source.IsForwarded()) {
          w_PwdUte = source.GetCaller().GetString("PwdUte","C",20,0);
          m_bpassedw_PwdUte = true;
        } else {
          w_PwdUte = source.GetParameter("PwdUte",source.GetParameter("w_PwdUte",""));
        }
      }
      m_bpassedw_ErrLogin = source.Has("w_ErrLogin");
      if (m_bpassedw_ErrLogin) {
        w_ErrLogin = source.GetParameter("w_ErrLogin",source.GetParameter("ErrLogin",""));
      } else {
        if (source.IsForwarded()) {
          w_ErrLogin = source.GetCaller().GetString("ErrLogin","C",100,0);
          m_bpassedw_ErrLogin = true;
        } else {
          w_ErrLogin = source.GetParameter("ErrLogin",source.GetParameter("w_ErrLogin",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_login";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = true;
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
    return  ! (status.m_bpassedw_ErrLogin) ||  ! (status.m_bpassedw_PwdUte) ||  ! (status.m_bpassedw_CodUte);
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
    if ( ! (status.m_bpassedw_CodUte)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CodUte',"+SPLib.ToJSValue(status.w_CodUte,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CodUte,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CodUte',l_cV);");
    if ( ! (status.m_bpassedw_PwdUte)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PwdUte',"+SPLib.ToJSValue(status.w_PwdUte,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PwdUte,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PwdUte',l_cV);");
    if ( ! (status.m_bpassedw_ErrLogin)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ErrLogin',"+SPLib.ToJSValue(status.w_ErrLogin,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ErrLogin,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ErrLogin',l_cV);");
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
    arrt_loginR Rcalled;
    Rcalled = new arrt_loginR(status.context,status);
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
    return new arrt_loginR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_loginR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_login"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_CodUte="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CodUte),"?",0,0)+"");
        status.out.println("js:w_PwdUte="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PwdUte),"?",0,0)+"");
        status.out.println("js:w_ErrLogin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ErrLogin),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_CodUte,null)) {");
        status.out.println("window[f].w_CodUte="+SPLib.ToJSValue(status.w_CodUte,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PwdUte,null)) {");
        status.out.println("window[f].w_PwdUte="+SPLib.ToJSValue(status.w_PwdUte,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ErrLogin,null)) {");
        status.out.println("window[f].w_ErrLogin="+SPLib.ToJSValue(status.w_ErrLogin,"C",0,0)+";");
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
      arrt_loginR Rcalled;
      Rcalled = new arrt_loginR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_login");
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
