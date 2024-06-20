import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_calcolasett extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*84e89123*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SOTGRUP;
    public String w_SOTGRUP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAMOGRUP;
    public String w_RAMOGRUP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SETTSINT;
    public String w_SETTSINT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_OLDSETSIN;
    public String w_OLDSETSIN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCUIC;
    public String w_DESCUIC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ATTIV;
    public String w_ATTIV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipsot;
    public String w_tipsot;
    public String _NewRamo;
    public String _ateco;
    public double _oksotgru;
    public double _okramatt;
    public double _okateco;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_SOTGRUP = source.Has("w_SOTGRUP");
      if (m_bpassedw_SOTGRUP) {
        w_SOTGRUP = source.GetParameter("w_SOTGRUP",source.GetParameter("SOTGRUP",""));
      } else {
        if (source.IsForwarded()) {
          w_SOTGRUP = source.GetCaller().GetString("SOTGRUP","C",3,0);
          m_bpassedw_SOTGRUP = true;
        } else {
          w_SOTGRUP = source.GetParameter("SOTGRUP",source.GetParameter("w_SOTGRUP",""));
        }
      }
      m_bpassedw_RAMOGRUP = source.Has("w_RAMOGRUP");
      if (m_bpassedw_RAMOGRUP) {
        w_RAMOGRUP = source.GetParameter("w_RAMOGRUP",source.GetParameter("RAMOGRUP",""));
      } else {
        if (source.IsForwarded()) {
          w_RAMOGRUP = source.GetCaller().GetString("RAMOGRUP","C",3,0);
          m_bpassedw_RAMOGRUP = true;
        } else {
          w_RAMOGRUP = source.GetParameter("RAMOGRUP",source.GetParameter("w_RAMOGRUP",""));
        }
      }
      m_bpassedw_SETTSINT = source.Has("w_SETTSINT");
      if (m_bpassedw_SETTSINT) {
        w_SETTSINT = source.GetParameter("w_SETTSINT",source.GetParameter("SETTSINT",""));
      } else {
        if (source.IsForwarded()) {
          w_SETTSINT = source.GetCaller().GetString("SETTSINT","C",3,0);
          m_bpassedw_SETTSINT = true;
        } else {
          w_SETTSINT = source.GetParameter("SETTSINT",source.GetParameter("w_SETTSINT",""));
        }
      }
      m_bpassedw_OLDSETSIN = source.Has("w_OLDSETSIN");
      if (m_bpassedw_OLDSETSIN) {
        w_OLDSETSIN = source.GetParameter("w_OLDSETSIN",source.GetParameter("OLDSETSIN",""));
      } else {
        if (source.IsForwarded()) {
          w_OLDSETSIN = source.GetCaller().GetString("OLDSETSIN","C",3,0);
          m_bpassedw_OLDSETSIN = true;
        } else {
          w_OLDSETSIN = source.GetParameter("OLDSETSIN",source.GetParameter("w_OLDSETSIN",""));
        }
      }
      m_bpassedw_DESCUIC = source.Has("w_DESCUIC");
      if (m_bpassedw_DESCUIC) {
        w_DESCUIC = source.GetParameter("w_DESCUIC",source.GetParameter("DESCUIC",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCUIC = source.GetCaller().GetString("DESCUIC","C",60,0);
          m_bpassedw_DESCUIC = true;
        } else {
          w_DESCUIC = source.GetParameter("DESCUIC",source.GetParameter("w_DESCUIC",""));
        }
      }
      m_bpassedw_ATTIV = source.Has("w_ATTIV");
      if (m_bpassedw_ATTIV) {
        w_ATTIV = source.GetParameter("w_ATTIV",source.GetParameter("ATTIV",""));
      } else {
        if (source.IsForwarded()) {
          w_ATTIV = source.GetCaller().GetString("ATTIV","C",10,0);
          m_bpassedw_ATTIV = true;
        } else {
          w_ATTIV = source.GetParameter("ATTIV",source.GetParameter("w_ATTIV",""));
        }
      }
      m_bpassedw_tipsot = source.Has("w_tipsot");
      if (m_bpassedw_tipsot) {
        w_tipsot = source.GetParameter("w_tipsot",source.GetParameter("tipsot",""));
      } else {
        if (source.IsForwarded()) {
          w_tipsot = source.GetCaller().GetString("tipsot","C",1,0);
          m_bpassedw_tipsot = true;
        } else {
          w_tipsot = source.GetParameter("tipsot",source.GetParameter("w_tipsot",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_calcolasett";
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
    return  ! (status.m_bpassedw_tipsot) ||  ! (status.m_bpassedw_ATTIV) ||  ! (status.m_bpassedw_DESCUIC) ||  ! (status.m_bpassedw_OLDSETSIN) ||  ! (status.m_bpassedw_SETTSINT) ||  ! (status.m_bpassedw_RAMOGRUP) ||  ! (status.m_bpassedw_SOTGRUP);
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
    if ( ! (status.m_bpassedw_SOTGRUP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SOTGRUP',"+SPLib.ToJSValue(status.w_SOTGRUP,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SOTGRUP,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SOTGRUP',l_cV);");
    if ( ! (status.m_bpassedw_RAMOGRUP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAMOGRUP',"+SPLib.ToJSValue(status.w_RAMOGRUP,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAMOGRUP,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAMOGRUP',l_cV);");
    if ( ! (status.m_bpassedw_SETTSINT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SETTSINT',"+SPLib.ToJSValue(status.w_SETTSINT,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SETTSINT,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SETTSINT',l_cV);");
    if ( ! (status.m_bpassedw_OLDSETSIN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_OLDSETSIN',"+SPLib.ToJSValue(status.w_OLDSETSIN,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_OLDSETSIN,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_OLDSETSIN',l_cV);");
    if ( ! (status.m_bpassedw_DESCUIC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCUIC',"+SPLib.ToJSValue(status.w_DESCUIC,"C",60,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCUIC,"C",60,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCUIC',l_cV);");
    if ( ! (status.m_bpassedw_ATTIV)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ATTIV',"+SPLib.ToJSValue(status.w_ATTIV,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ATTIV,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ATTIV',l_cV);");
    if ( ! (status.m_bpassedw_tipsot)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipsot',"+SPLib.ToJSValue(status.w_tipsot,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipsot,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipsot',l_cV);");
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
    arrt_calcolasettR Rcalled;
    Rcalled = new arrt_calcolasettR(status.context,status);
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
    return new arrt_calcolasettR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_calcolasettR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_calcolasett"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_SOTGRUP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SOTGRUP),"?",0,0)+"");
        status.out.println("js:w_RAMOGRUP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAMOGRUP),"?",0,0)+"");
        status.out.println("js:w_SETTSINT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SETTSINT),"?",0,0)+"");
        status.out.println("js:w_OLDSETSIN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_OLDSETSIN),"?",0,0)+"");
        status.out.println("js:w_DESCUIC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCUIC),"?",0,0)+"");
        status.out.println("js:w_ATTIV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ATTIV),"?",0,0)+"");
        status.out.println("js:w_tipsot="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipsot),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_SOTGRUP,null)) {");
        status.out.println("window[f].w_SOTGRUP="+SPLib.ToJSValue(status.w_SOTGRUP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAMOGRUP,null)) {");
        status.out.println("window[f].w_RAMOGRUP="+SPLib.ToJSValue(status.w_RAMOGRUP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SETTSINT,null)) {");
        status.out.println("window[f].w_SETTSINT="+SPLib.ToJSValue(status.w_SETTSINT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_OLDSETSIN,null)) {");
        status.out.println("window[f].w_OLDSETSIN="+SPLib.ToJSValue(status.w_OLDSETSIN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCUIC,null)) {");
        status.out.println("window[f].w_DESCUIC="+SPLib.ToJSValue(status.w_DESCUIC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ATTIV,null)) {");
        status.out.println("window[f].w_ATTIV="+SPLib.ToJSValue(status.w_ATTIV,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipsot,null)) {");
        status.out.println("window[f].w_tipsot="+SPLib.ToJSValue(status.w_tipsot,"C",0,0)+";");
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
      arrt_calcolasettR Rcalled;
      Rcalled = new arrt_calcolasettR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_calcolasett");
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
