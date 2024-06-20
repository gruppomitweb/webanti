import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_rapopebo extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*95408ce5*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IDBASE;
    public String w_IDBASE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNES;
    public String w_CONNES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATARETT;
    public java.sql.Date w_DATARETT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NUMPROG;
    public String w_NUMPROG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLAGFRAZ;
    public String w_FLAGFRAZ;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipooper;
    public String w_tipooper;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datavaria;
    public java.sql.Date w_datavaria;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_IDBASE = source.Has("w_IDBASE");
      if (m_bpassedw_IDBASE) {
        w_IDBASE = source.GetParameter("w_IDBASE",source.GetParameter("IDBASE",""));
      } else {
        if (source.IsForwarded()) {
          w_IDBASE = source.GetCaller().GetString("IDBASE","C",10,0);
          m_bpassedw_IDBASE = true;
        } else {
          w_IDBASE = source.GetParameter("IDBASE",source.GetParameter("w_IDBASE",""));
        }
      }
      m_bpassedw_CONNES = source.Has("w_CONNES");
      if (m_bpassedw_CONNES) {
        w_CONNES = source.GetParameter("w_CONNES",source.GetParameter("CONNES",""));
      } else {
        if (source.IsForwarded()) {
          w_CONNES = source.GetCaller().GetString("CONNES","C",16,0);
          m_bpassedw_CONNES = true;
        } else {
          w_CONNES = source.GetParameter("CONNES",source.GetParameter("w_CONNES",""));
        }
      }
      m_bpassedw_DATARETT = source.Has("w_DATARETT");
      if (m_bpassedw_DATARETT) {
        w_DATARETT = source.GetParameter("w_DATARETT",source.GetParameter("DATARETT",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATARETT = source.GetCaller().GetDate("DATARETT","D",8,0);
          m_bpassedw_DATARETT = true;
        } else {
          w_DATARETT = source.GetParameter("DATARETT",source.GetParameter("w_DATARETT",CPLib.NullDate()));
        }
      }
      m_bpassedw_NUMPROG = source.Has("w_NUMPROG");
      if (m_bpassedw_NUMPROG) {
        w_NUMPROG = source.GetParameter("w_NUMPROG",source.GetParameter("NUMPROG",""));
      } else {
        if (source.IsForwarded()) {
          w_NUMPROG = source.GetCaller().GetString("NUMPROG","C",7,0);
          m_bpassedw_NUMPROG = true;
        } else {
          w_NUMPROG = source.GetParameter("NUMPROG",source.GetParameter("w_NUMPROG",""));
        }
      }
      m_bpassedw_FLAGFRAZ = source.Has("w_FLAGFRAZ");
      if (m_bpassedw_FLAGFRAZ) {
        w_FLAGFRAZ = source.GetParameter("w_FLAGFRAZ",source.GetParameter("FLAGFRAZ",""));
      } else {
        if (source.IsForwarded()) {
          w_FLAGFRAZ = source.GetCaller().GetString("FLAGFRAZ","C",1,0);
          m_bpassedw_FLAGFRAZ = true;
        } else {
          w_FLAGFRAZ = source.GetParameter("FLAGFRAZ",source.GetParameter("w_FLAGFRAZ",""));
        }
      }
      m_bpassedw_tipooper = source.Has("w_tipooper");
      if (m_bpassedw_tipooper) {
        w_tipooper = source.GetParameter("w_tipooper",source.GetParameter("tipooper",""));
      } else {
        if (source.IsForwarded()) {
          w_tipooper = source.GetCaller().GetString("tipooper","C",1,0);
          m_bpassedw_tipooper = true;
        } else {
          w_tipooper = source.GetParameter("tipooper",source.GetParameter("w_tipooper",""));
        }
      }
      m_bpassedw_datavaria = source.Has("w_datavaria");
      if (m_bpassedw_datavaria) {
        w_datavaria = source.GetParameter("w_datavaria",source.GetParameter("datavaria",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datavaria = source.GetCaller().GetDate("datavaria","D",8,0);
          m_bpassedw_datavaria = true;
        } else {
          w_datavaria = source.GetParameter("datavaria",source.GetParameter("w_datavaria",CPLib.NullDate()));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_rapopebo";
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
    return  ! (status.m_bpassedw_datavaria) ||  ! (status.m_bpassedw_tipooper) ||  ! (status.m_bpassedw_FLAGFRAZ) ||  ! (status.m_bpassedw_NUMPROG) ||  ! (status.m_bpassedw_DATARETT) ||  ! (status.m_bpassedw_CONNES) ||  ! (status.m_bpassedw_IDBASE);
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
    if ( ! (status.m_bpassedw_IDBASE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IDBASE',"+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IDBASE',l_cV);");
    if ( ! (status.m_bpassedw_CONNES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNES',"+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNES',l_cV);");
    if ( ! (status.m_bpassedw_DATARETT)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATARETT',"+SPLib.ToJSValue(status.w_DATARETT,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATARETT,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATARETT',l_cV);");
    if ( ! (status.m_bpassedw_NUMPROG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NUMPROG',"+SPLib.ToJSValue(status.w_NUMPROG,"C",7,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NUMPROG,"C",7,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NUMPROG',l_cV);");
    if ( ! (status.m_bpassedw_FLAGFRAZ)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLAGFRAZ',"+SPLib.ToJSValue(status.w_FLAGFRAZ,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLAGFRAZ,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLAGFRAZ',l_cV);");
    if ( ! (status.m_bpassedw_tipooper)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipooper',"+SPLib.ToJSValue(status.w_tipooper,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipooper,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipooper',l_cV);");
    if ( ! (status.m_bpassedw_datavaria)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datavaria',"+SPLib.ToJSValue(status.w_datavaria,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datavaria,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datavaria',l_cV);");
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
    arrt_rapopeboR Rcalled;
    Rcalled = new arrt_rapopeboR(status.context,status);
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
    return new arrt_rapopeboR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_rapopeboR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_rapopebo"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_IDBASE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IDBASE),"?",0,0)+"");
        status.out.println("js:w_CONNES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNES),"?",0,0)+"");
        status.out.println("js:w_DATARETT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATARETT),"?",0,0)+"");
        status.out.println("js:w_NUMPROG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NUMPROG),"?",0,0)+"");
        status.out.println("js:w_FLAGFRAZ="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLAGFRAZ),"?",0,0)+"");
        status.out.println("js:w_tipooper="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipooper),"?",0,0)+"");
        status.out.println("js:w_datavaria="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datavaria),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_IDBASE,null)) {");
        status.out.println("window[f].w_IDBASE="+SPLib.ToJSValue(status.w_IDBASE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CONNES,null)) {");
        status.out.println("window[f].w_CONNES="+SPLib.ToJSValue(status.w_CONNES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATARETT,null)) {");
        status.out.println(" window[f].w_DATARETT.setTime(("+SPLib.ToJSValue(status.w_DATARETT,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NUMPROG,null)) {");
        status.out.println("window[f].w_NUMPROG="+SPLib.ToJSValue(status.w_NUMPROG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FLAGFRAZ,null)) {");
        status.out.println("window[f].w_FLAGFRAZ="+SPLib.ToJSValue(status.w_FLAGFRAZ,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipooper,null)) {");
        status.out.println("window[f].w_tipooper="+SPLib.ToJSValue(status.w_tipooper,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datavaria,null)) {");
        status.out.println(" window[f].w_datavaria.setTime(("+SPLib.ToJSValue(status.w_datavaria,"D",0,0)+").getTime())");
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
      arrt_rapopeboR Rcalled;
      Rcalled = new arrt_rapopeboR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_rapopebo");
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