import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_insert_tmp_abbina_cointestatari extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*fb235c7e*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_Password;
    public String w_Password;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_fonte;
    public String w_fonte;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_COINT;
    public String w_COINT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_OrderBy;
    public String w_OrderBy;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_Password = source.Has("w_Password");
      if (m_bpassedw_Password) {
        w_Password = source.GetParameter("w_Password",source.GetParameter("Password",""));
      } else {
        if (source.IsForwarded()) {
          w_Password = source.GetCaller().GetString("Password","C",9,0);
          m_bpassedw_Password = true;
        } else {
          w_Password = source.GetParameter("Password",source.GetParameter("w_Password",""));
        }
      }
      m_bpassedw_fonte = source.Has("w_fonte");
      if (m_bpassedw_fonte) {
        w_fonte = source.GetParameter("w_fonte",source.GetParameter("fonte",""));
      } else {
        if (source.IsForwarded()) {
          w_fonte = source.GetCaller().GetString("fonte","C",1,0);
          m_bpassedw_fonte = true;
        } else {
          w_fonte = source.GetParameter("fonte",source.GetParameter("w_fonte",""));
        }
      }
      m_bpassedw_COINT = source.Has("w_COINT");
      if (m_bpassedw_COINT) {
        w_COINT = source.GetParameter("w_COINT",source.GetParameter("COINT",""));
      } else {
        if (source.IsForwarded()) {
          w_COINT = source.GetCaller().GetString("COINT","C",1,0);
          m_bpassedw_COINT = true;
        } else {
          w_COINT = source.GetParameter("COINT",source.GetParameter("w_COINT",""));
        }
      }
      m_bpassedw_OrderBy = source.Has("w_OrderBy");
      if (m_bpassedw_OrderBy) {
        w_OrderBy = source.GetParameter("w_OrderBy",source.GetParameter("OrderBy",""));
      } else {
        if (source.IsForwarded()) {
          w_OrderBy = source.GetCaller().GetString("OrderBy","C",14,0);
          m_bpassedw_OrderBy = true;
        } else {
          w_OrderBy = source.GetParameter("OrderBy",source.GetParameter("w_OrderBy",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_insert_tmp_abbina_cointestatari";
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
    return  ! (status.m_bpassedw_OrderBy) ||  ! (status.m_bpassedw_COINT) ||  ! (status.m_bpassedw_fonte) ||  ! (status.m_bpassedw_Password);
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
    if ( ! (status.m_bpassedw_Password)) {
      status.out.println("l_cV=WtA(l_oWnd('w_Password',"+SPLib.ToJSValue(status.w_Password,"C",9,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Password,"C",9,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_Password',l_cV);");
    if ( ! (status.m_bpassedw_fonte)) {
      status.out.println("l_cV=WtA(l_oWnd('w_fonte',"+SPLib.ToJSValue(status.w_fonte,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_fonte,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_fonte',l_cV);");
    if ( ! (status.m_bpassedw_COINT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_COINT',"+SPLib.ToJSValue(status.w_COINT,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_COINT,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_COINT',l_cV);");
    if ( ! (status.m_bpassedw_OrderBy)) {
      status.out.println("l_cV=WtA(l_oWnd('w_OrderBy',"+SPLib.ToJSValue(status.w_OrderBy,"C",14,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_OrderBy,"C",14,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_OrderBy',l_cV);");
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
    arrt_insert_tmp_abbina_cointestatariR Rcalled;
    Rcalled = new arrt_insert_tmp_abbina_cointestatariR(status.context,status);
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
    return new arrt_insert_tmp_abbina_cointestatariR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_insert_tmp_abbina_cointestatariR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_insert_tmp_abbina_cointestatari"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_Password="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_Password),"?",0,0)+"");
        status.out.println("js:w_fonte="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_fonte),"?",0,0)+"");
        status.out.println("js:w_COINT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_COINT),"?",0,0)+"");
        status.out.println("js:w_OrderBy="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_OrderBy),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_Password,null)) {");
        status.out.println("window[f].w_Password="+SPLib.ToJSValue(status.w_Password,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_fonte,null)) {");
        status.out.println("window[f].w_fonte="+SPLib.ToJSValue(status.w_fonte,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_COINT,null)) {");
        status.out.println("window[f].w_COINT="+SPLib.ToJSValue(status.w_COINT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_OrderBy,null)) {");
        status.out.println("window[f].w_OrderBy="+SPLib.ToJSValue(status.w_OrderBy,"C",0,0)+";");
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
      arrt_insert_tmp_abbina_cointestatariR Rcalled;
      Rcalled = new arrt_insert_tmp_abbina_cointestatariR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_insert_tmp_abbina_cointestatari");
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
