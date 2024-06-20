import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stpoper_prv_sa extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*9c7531ab*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaDatOpe;
    public java.sql.Date w_DaDatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ADatOpe;
    public java.sql.Date w_ADatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_daCodCli;
    public String w_daCodCli;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_aCodCli;
    public String w_aCodCli;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_adata;
    public String w_c_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_dadata;
    public String w_c_dadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_OrderBy;
    public String w_OrderBy;
    public double onlyope;
    public double onlyrap;
    public String statoreg;
    public String gFlgDoc;
    public String gDescAzi;
    public String _connes;
    public java.sql.Date _dataope;
    public java.sql.Date _dataret;
    public String _numsto;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_DaDatOpe = source.Has("w_DaDatOpe");
      if (m_bpassedw_DaDatOpe) {
        w_DaDatOpe = source.GetParameter("w_DaDatOpe",source.GetParameter("DaDatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaDatOpe = source.GetCaller().GetDate("DaDatOpe","D",8,0);
          m_bpassedw_DaDatOpe = true;
        } else {
          w_DaDatOpe = source.GetParameter("DaDatOpe",source.GetParameter("w_DaDatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_ADatOpe = source.Has("w_ADatOpe");
      if (m_bpassedw_ADatOpe) {
        w_ADatOpe = source.GetParameter("w_ADatOpe",source.GetParameter("ADatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_ADatOpe = source.GetCaller().GetDate("ADatOpe","D",8,0);
          m_bpassedw_ADatOpe = true;
        } else {
          w_ADatOpe = source.GetParameter("ADatOpe",source.GetParameter("w_ADatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_daCodCli = source.Has("w_daCodCli");
      if (m_bpassedw_daCodCli) {
        w_daCodCli = source.GetParameter("w_daCodCli",source.GetParameter("daCodCli",""));
      } else {
        if (source.IsForwarded()) {
          w_daCodCli = source.GetCaller().GetString("daCodCli","C",16,0);
          m_bpassedw_daCodCli = true;
        } else {
          w_daCodCli = source.GetParameter("daCodCli",source.GetParameter("w_daCodCli",""));
        }
      }
      m_bpassedw_aCodCli = source.Has("w_aCodCli");
      if (m_bpassedw_aCodCli) {
        w_aCodCli = source.GetParameter("w_aCodCli",source.GetParameter("aCodCli",""));
      } else {
        if (source.IsForwarded()) {
          w_aCodCli = source.GetCaller().GetString("aCodCli","C",16,0);
          m_bpassedw_aCodCli = true;
        } else {
          w_aCodCli = source.GetParameter("aCodCli",source.GetParameter("w_aCodCli",""));
        }
      }
      m_bpassedw_c_adata = source.Has("w_c_adata");
      if (m_bpassedw_c_adata) {
        w_c_adata = source.GetParameter("w_c_adata",source.GetParameter("c_adata",""));
      } else {
        if (source.IsForwarded()) {
          w_c_adata = source.GetCaller().GetString("c_adata","C",8,0);
          m_bpassedw_c_adata = true;
        } else {
          w_c_adata = source.GetParameter("c_adata",source.GetParameter("w_c_adata",""));
        }
      }
      m_bpassedw_c_dadata = source.Has("w_c_dadata");
      if (m_bpassedw_c_dadata) {
        w_c_dadata = source.GetParameter("w_c_dadata",source.GetParameter("c_dadata",""));
      } else {
        if (source.IsForwarded()) {
          w_c_dadata = source.GetCaller().GetString("c_dadata","C",8,0);
          m_bpassedw_c_dadata = true;
        } else {
          w_c_dadata = source.GetParameter("c_dadata",source.GetParameter("w_c_dadata",""));
        }
      }
      m_bpassedw_OrderBy = source.Has("w_OrderBy");
      if (m_bpassedw_OrderBy) {
        w_OrderBy = source.GetParameter("w_OrderBy",source.GetParameter("OrderBy",""));
      } else {
        if (source.IsForwarded()) {
          w_OrderBy = source.GetCaller().GetString("OrderBy","C",22,0);
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
    l_eg.name = "arrt_stpoper_prv_sa";
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
    return  ! (status.m_bpassedw_OrderBy) ||  ! (status.m_bpassedw_c_dadata) ||  ! (status.m_bpassedw_c_adata) ||  ! (status.m_bpassedw_aCodCli) ||  ! (status.m_bpassedw_daCodCli) ||  ! (status.m_bpassedw_ADatOpe) ||  ! (status.m_bpassedw_DaDatOpe);
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
    if ( ! (status.m_bpassedw_DaDatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaDatOpe',"+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaDatOpe',l_cV);");
    if ( ! (status.m_bpassedw_ADatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_ADatOpe',"+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_ADatOpe',l_cV);");
    if ( ! (status.m_bpassedw_daCodCli)) {
      status.out.println("l_cV=WtA(l_oWnd('w_daCodCli',"+SPLib.ToJSValue(status.w_daCodCli,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_daCodCli,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_daCodCli',l_cV);");
    if ( ! (status.m_bpassedw_aCodCli)) {
      status.out.println("l_cV=WtA(l_oWnd('w_aCodCli',"+SPLib.ToJSValue(status.w_aCodCli,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_aCodCli,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_aCodCli',l_cV);");
    if ( ! (status.m_bpassedw_c_adata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_adata',"+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_adata',l_cV);");
    if ( ! (status.m_bpassedw_c_dadata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_dadata',"+SPLib.ToJSValue(status.w_c_dadata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_dadata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_dadata',l_cV);");
    if ( ! (status.m_bpassedw_OrderBy)) {
      status.out.println("l_cV=WtA(l_oWnd('w_OrderBy',"+SPLib.ToJSValue(status.w_OrderBy,"C",22,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_OrderBy,"C",22,0)+",'C');");
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
    arrt_stpoper_prv_saR Rcalled;
    Rcalled = new arrt_stpoper_prv_saR(status.context,status);
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
    return new arrt_stpoper_prv_saR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stpoper_prv_saR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stpoper_prv_sa"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_DaDatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaDatOpe),"?",0,0)+"");
        status.out.println("js:w_ADatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ADatOpe),"?",0,0)+"");
        status.out.println("js:w_daCodCli="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_daCodCli),"?",0,0)+"");
        status.out.println("js:w_aCodCli="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_aCodCli),"?",0,0)+"");
        status.out.println("js:w_c_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_adata),"?",0,0)+"");
        status.out.println("js:w_c_dadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_dadata),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_DaDatOpe,null)) {");
        status.out.println(" window[f].w_DaDatOpe.setTime(("+SPLib.ToJSValue(status.w_DaDatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ADatOpe,null)) {");
        status.out.println(" window[f].w_ADatOpe.setTime(("+SPLib.ToJSValue(status.w_ADatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_daCodCli,null)) {");
        status.out.println("window[f].w_daCodCli="+SPLib.ToJSValue(status.w_daCodCli,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_aCodCli,null)) {");
        status.out.println("window[f].w_aCodCli="+SPLib.ToJSValue(status.w_aCodCli,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_adata,null)) {");
        status.out.println("window[f].w_c_adata="+SPLib.ToJSValue(status.w_c_adata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_dadata,null)) {");
        status.out.println("window[f].w_c_dadata="+SPLib.ToJSValue(status.w_c_dadata,"C",0,0)+";");
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
      arrt_stpoper_prv_saR Rcalled;
      Rcalled = new arrt_stpoper_prv_saR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stpoper_prv_sa");
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
