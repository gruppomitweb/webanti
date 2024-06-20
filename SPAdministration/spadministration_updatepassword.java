import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class spadministration_updatepassword extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*5ad2fda*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_confirm_password;
    public String w_confirm_password;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_new_password;
    public String w_new_password;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_old_password;
    public String w_old_password;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedcachekey;
    public String cachekey;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedroot_m_cURL_servlet;
    public String root_m_cURL_servlet;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedm_cAtExit;
    public String m_cAtExit;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedchangeReason;
    public String changeReason;
    public String errormessage;
    public double usercode;
    public String pwdcript_current;
    public String pwdcript_new;
    public String m_cChangePasswordLockDestination;
    public double w_pwdcomplexity;
    public boolean canupdate;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_confirm_password = source.Has("w_confirm_password");
      if (m_bpassedw_confirm_password) {
        w_confirm_password = source.GetParameter("w_confirm_password",source.GetParameter("confirm_password",""));
      } else {
        if (source.IsForwarded()) {
          w_confirm_password = source.GetCaller().GetString("confirm_password","C",20,0);
          m_bpassedw_confirm_password = true;
        } else {
          w_confirm_password = source.GetParameter("confirm_password",source.GetParameter("w_confirm_password",""));
        }
      }
      m_bpassedw_new_password = source.Has("w_new_password");
      if (m_bpassedw_new_password) {
        w_new_password = source.GetParameter("w_new_password",source.GetParameter("new_password",""));
      } else {
        if (source.IsForwarded()) {
          w_new_password = source.GetCaller().GetString("new_password","C",20,0);
          m_bpassedw_new_password = true;
        } else {
          w_new_password = source.GetParameter("new_password",source.GetParameter("w_new_password",""));
        }
      }
      m_bpassedw_old_password = source.Has("w_old_password");
      if (m_bpassedw_old_password) {
        w_old_password = source.GetParameter("w_old_password",source.GetParameter("old_password",""));
      } else {
        if (source.IsForwarded()) {
          w_old_password = source.GetCaller().GetString("old_password","C",20,0);
          m_bpassedw_old_password = true;
        } else {
          w_old_password = source.GetParameter("old_password",source.GetParameter("w_old_password",""));
        }
      }
      m_bpassedcachekey = source.Has("cachekey");
      if (m_bpassedcachekey) {
        cachekey = source.GetParameter("cachekey",source.GetParameter("cachekey",""));
      } else {
        if (source.IsForwarded()) {
          cachekey = source.GetCaller().GetString("cachekey","C",20,0);
          m_bpassedcachekey = true;
        } else {
          cachekey = source.GetParameter("cachekey",source.GetParameter("cachekey",""));
        }
      }
      m_bpassedroot_m_cURL_servlet = source.Has("root_m_cURL_servlet");
      if (m_bpassedroot_m_cURL_servlet) {
        root_m_cURL_servlet = source.GetParameter("root_m_cURL_servlet",source.GetParameter("root_m_cURL_servlet",""));
      } else {
        if (source.IsForwarded()) {
          root_m_cURL_servlet = source.GetCaller().GetString("root_m_cURL_servlet","C",100,0);
          m_bpassedroot_m_cURL_servlet = true;
        } else {
          root_m_cURL_servlet = source.GetParameter("root_m_cURL_servlet",source.GetParameter("root_m_cURL_servlet",""));
        }
      }
      m_bpassedm_cAtExit = source.Has("m_cAtExit");
      if (m_bpassedm_cAtExit) {
        m_cAtExit = source.GetParameter("m_cAtExit",source.GetParameter("m_cAtExit",""));
      } else {
        if (source.IsForwarded()) {
          m_cAtExit = source.GetCaller().GetString("m_cAtExit","C",100,0);
          m_bpassedm_cAtExit = true;
        } else {
          m_cAtExit = source.GetParameter("m_cAtExit",source.GetParameter("m_cAtExit",""));
        }
      }
      m_bpassedchangeReason = source.Has("changeReason");
      if (m_bpassedchangeReason) {
        changeReason = source.GetParameter("changeReason",source.GetParameter("changeReason",""));
      } else {
        if (source.IsForwarded()) {
          changeReason = source.GetCaller().GetString("changeReason","C",10,0);
          m_bpassedchangeReason = true;
        } else {
          changeReason = source.GetParameter("changeReason",source.GetParameter("changeReason",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "spadministration_updatepassword";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = false;
    l_eg.m_nCallableFrom = 1;
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
    if (SPLib.IsForwarded(request)) {
      Begin(status);
    } else {
      spadministration_updatepasswordR Rcalled;
      Rcalled = new spadministration_updatepasswordR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = "Routine spadministration_updatepassword called via http but was designed with no UI tier,revise your application host="+request.getHeader("Host")+" referer="+request.getHeader("Referer");
      if ( ! (CPLib.IsNull(l))) {
        l.log(Rcalled.m_cLastMsgError);
      }
      status.m_bError = true;
      status.m_cErrMsg = Rcalled.m_cLastMsgError;
      BringBackPage(status,Rcalled);
    }
  }
  boolean NeedsFetchPage(ServletStatus status) {
    return  ! (status.m_bpassedchangeReason) ||  ! (status.m_bpassedm_cAtExit) ||  ! (status.m_bpassedroot_m_cURL_servlet) ||  ! (status.m_bpassedcachekey) ||  ! (status.m_bpassedw_old_password) ||  ! (status.m_bpassedw_new_password) ||  ! (status.m_bpassedw_confirm_password);
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
    if ( ! (status.m_bpassedw_confirm_password)) {
      status.out.println("l_cV=WtA(l_oWnd('w_confirm_password',"+SPLib.ToJSValue(status.w_confirm_password,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_confirm_password,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_confirm_password',l_cV);");
    if ( ! (status.m_bpassedw_new_password)) {
      status.out.println("l_cV=WtA(l_oWnd('w_new_password',"+SPLib.ToJSValue(status.w_new_password,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_new_password,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_new_password',l_cV);");
    if ( ! (status.m_bpassedw_old_password)) {
      status.out.println("l_cV=WtA(l_oWnd('w_old_password',"+SPLib.ToJSValue(status.w_old_password,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_old_password,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_old_password',l_cV);");
    if ( ! (status.m_bpassedcachekey)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cachekey',"+SPLib.ToJSValue(status.cachekey,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.cachekey,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('cachekey',l_cV);");
    if ( ! (status.m_bpassedroot_m_cURL_servlet)) {
      status.out.println("l_cV=WtA(l_oWnd('w_root_m_cURL_servlet',"+SPLib.ToJSValue(status.root_m_cURL_servlet,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.root_m_cURL_servlet,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('root_m_cURL_servlet',l_cV);");
    if ( ! (status.m_bpassedm_cAtExit)) {
      status.out.println("l_cV=WtA(l_oWnd('w_m_cAtExit',"+SPLib.ToJSValue(status.m_cAtExit,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.m_cAtExit,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('m_cAtExit',l_cV);");
    if ( ! (status.m_bpassedchangeReason)) {
      status.out.println("l_cV=WtA(l_oWnd('w_changeReason',"+SPLib.ToJSValue(status.changeReason,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.changeReason,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('changeReason',l_cV);");
    status.out.println("l_oWv.setValue('m_cID','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("routine,spadministration_updatepassword",((SPContext)status.context).session)+"')");
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
    spadministration_updatepasswordR Rcalled;
    Rcalled = new spadministration_updatepasswordR(status.context,status);
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
    return new spadministration_updatepasswordR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,spadministration_updatepasswordR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","spadministration_updatepassword"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_confirm_password="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_confirm_password),"?",0,0)+"");
        status.out.println("js:w_new_password="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_new_password),"?",0,0)+"");
        status.out.println("js:w_old_password="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_old_password),"?",0,0)+"");
        status.out.println("js:cachekey="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.cachekey),"?",0,0)+"");
        status.out.println("js:root_m_cURL_servlet="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.root_m_cURL_servlet),"?",0,0)+"");
        status.out.println("js:m_cAtExit="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.m_cAtExit),"?",0,0)+"");
        status.out.println("js:changeReason="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.changeReason),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_confirm_password,null)) {");
        status.out.println("window[f].w_confirm_password="+SPLib.ToJSValue(status.w_confirm_password,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_new_password,null)) {");
        status.out.println("window[f].w_new_password="+SPLib.ToJSValue(status.w_new_password,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_old_password,null)) {");
        status.out.println("window[f].w_old_password="+SPLib.ToJSValue(status.w_old_password,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cachekey,null)) {");
        status.out.println("window[f].w_cachekey="+SPLib.ToJSValue(status.cachekey,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_root_m_cURL_servlet,null)) {");
        status.out.println("window[f].w_root_m_cURL_servlet="+SPLib.ToJSValue(status.root_m_cURL_servlet,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_m_cAtExit,null)) {");
        status.out.println("window[f].w_m_cAtExit="+SPLib.ToJSValue(status.m_cAtExit,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_changeReason,null)) {");
        status.out.println("window[f].w_changeReason="+SPLib.ToJSValue(status.changeReason,"C",0,0)+";");
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
      spadministration_updatepasswordR Rcalled;
      Rcalled = new spadministration_updatepasswordR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"spadministration_updatepassword");
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
    if (CPLib.IsNull(m_CallableNames)) {
      // Il controllo in callable evita la ricorsione di una routine A che chiama routine B che chiama a sua volta A
      if ( ! (callable.contains("spadministration_updatepassword"))) {
        CPLib.AddToSet(callable,"spadministration_updatepassword");
        spadministration_updatepassword.GetCallableNames(callable);
      }
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  String[] RoutineIDChain() {
    return GetCallableNames();
  }
}
