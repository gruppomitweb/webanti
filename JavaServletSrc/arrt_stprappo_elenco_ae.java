import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stprappo_elenco_ae extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*5d6756ec*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_daRappo;
    public String w_daRappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_aRappo;
    public String w_aRappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaDatIni;
    public java.sql.Date w_DaDatIni;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ADatIni;
    public java.sql.Date w_ADatIni;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaDatFin;
    public java.sql.Date w_DaDatFin;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ADatFin;
    public java.sql.Date w_ADatFin;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipo;
    public String w_tipo;
    public String gPathApp;
    public String gUrlApp;
    public String gDescAzi;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_daRappo = source.Has("w_daRappo");
      if (m_bpassedw_daRappo) {
        w_daRappo = source.GetParameter("w_daRappo",source.GetParameter("daRappo",""));
      } else {
        if (source.IsForwarded()) {
          w_daRappo = source.GetCaller().GetString("daRappo","C",25,0);
          m_bpassedw_daRappo = true;
        } else {
          w_daRappo = source.GetParameter("daRappo",source.GetParameter("w_daRappo",""));
        }
      }
      m_bpassedw_aRappo = source.Has("w_aRappo");
      if (m_bpassedw_aRappo) {
        w_aRappo = source.GetParameter("w_aRappo",source.GetParameter("aRappo",""));
      } else {
        if (source.IsForwarded()) {
          w_aRappo = source.GetCaller().GetString("aRappo","C",25,0);
          m_bpassedw_aRappo = true;
        } else {
          w_aRappo = source.GetParameter("aRappo",source.GetParameter("w_aRappo",""));
        }
      }
      m_bpassedw_DaDatIni = source.Has("w_DaDatIni");
      if (m_bpassedw_DaDatIni) {
        w_DaDatIni = source.GetParameter("w_DaDatIni",source.GetParameter("DaDatIni",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaDatIni = source.GetCaller().GetDate("DaDatIni","D",8,0);
          m_bpassedw_DaDatIni = true;
        } else {
          w_DaDatIni = source.GetParameter("DaDatIni",source.GetParameter("w_DaDatIni",CPLib.NullDate()));
        }
      }
      m_bpassedw_ADatIni = source.Has("w_ADatIni");
      if (m_bpassedw_ADatIni) {
        w_ADatIni = source.GetParameter("w_ADatIni",source.GetParameter("ADatIni",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_ADatIni = source.GetCaller().GetDate("ADatIni","D",8,0);
          m_bpassedw_ADatIni = true;
        } else {
          w_ADatIni = source.GetParameter("ADatIni",source.GetParameter("w_ADatIni",CPLib.NullDate()));
        }
      }
      m_bpassedw_DaDatFin = source.Has("w_DaDatFin");
      if (m_bpassedw_DaDatFin) {
        w_DaDatFin = source.GetParameter("w_DaDatFin",source.GetParameter("DaDatFin",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaDatFin = source.GetCaller().GetDate("DaDatFin","D",8,0);
          m_bpassedw_DaDatFin = true;
        } else {
          w_DaDatFin = source.GetParameter("DaDatFin",source.GetParameter("w_DaDatFin",CPLib.NullDate()));
        }
      }
      m_bpassedw_ADatFin = source.Has("w_ADatFin");
      if (m_bpassedw_ADatFin) {
        w_ADatFin = source.GetParameter("w_ADatFin",source.GetParameter("ADatFin",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_ADatFin = source.GetCaller().GetDate("ADatFin","D",8,0);
          m_bpassedw_ADatFin = true;
        } else {
          w_ADatFin = source.GetParameter("ADatFin",source.GetParameter("w_ADatFin",CPLib.NullDate()));
        }
      }
      m_bpassedw_tipo = source.Has("w_tipo");
      if (m_bpassedw_tipo) {
        w_tipo = source.GetParameter("w_tipo",source.GetParameter("tipo",""));
      } else {
        if (source.IsForwarded()) {
          w_tipo = source.GetCaller().GetString("tipo","C",1,0);
          m_bpassedw_tipo = true;
        } else {
          w_tipo = source.GetParameter("tipo",source.GetParameter("w_tipo",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_stprappo_elenco_ae";
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
    return  ! (status.m_bpassedw_tipo) ||  ! (status.m_bpassedw_ADatFin) ||  ! (status.m_bpassedw_DaDatFin) ||  ! (status.m_bpassedw_ADatIni) ||  ! (status.m_bpassedw_DaDatIni) ||  ! (status.m_bpassedw_aRappo) ||  ! (status.m_bpassedw_daRappo);
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
    if ( ! (status.m_bpassedw_daRappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_daRappo',"+SPLib.ToJSValue(status.w_daRappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_daRappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_daRappo',l_cV);");
    if ( ! (status.m_bpassedw_aRappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_aRappo',"+SPLib.ToJSValue(status.w_aRappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_aRappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_aRappo',l_cV);");
    if ( ! (status.m_bpassedw_DaDatIni)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaDatIni',"+SPLib.ToJSValue(status.w_DaDatIni,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatIni,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaDatIni',l_cV);");
    if ( ! (status.m_bpassedw_ADatIni)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_ADatIni',"+SPLib.ToJSValue(status.w_ADatIni,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatIni,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_ADatIni',l_cV);");
    if ( ! (status.m_bpassedw_DaDatFin)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaDatFin',"+SPLib.ToJSValue(status.w_DaDatFin,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatFin,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaDatFin',l_cV);");
    if ( ! (status.m_bpassedw_ADatFin)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_ADatFin',"+SPLib.ToJSValue(status.w_ADatFin,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatFin,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_ADatFin',l_cV);");
    if ( ! (status.m_bpassedw_tipo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipo',"+SPLib.ToJSValue(status.w_tipo,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipo,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipo',l_cV);");
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
    arrt_stprappo_elenco_aeR Rcalled;
    Rcalled = new arrt_stprappo_elenco_aeR(status.context,status);
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
    return new arrt_stprappo_elenco_aeR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stprappo_elenco_aeR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stprappo_elenco_ae"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_daRappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_daRappo),"?",0,0)+"");
        status.out.println("js:w_aRappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_aRappo),"?",0,0)+"");
        status.out.println("js:w_DaDatIni="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaDatIni),"?",0,0)+"");
        status.out.println("js:w_ADatIni="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ADatIni),"?",0,0)+"");
        status.out.println("js:w_DaDatFin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaDatFin),"?",0,0)+"");
        status.out.println("js:w_ADatFin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ADatFin),"?",0,0)+"");
        status.out.println("js:w_tipo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipo),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_daRappo,null)) {");
        status.out.println("window[f].w_daRappo="+SPLib.ToJSValue(status.w_daRappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_aRappo,null)) {");
        status.out.println("window[f].w_aRappo="+SPLib.ToJSValue(status.w_aRappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DaDatIni,null)) {");
        status.out.println(" window[f].w_DaDatIni.setTime(("+SPLib.ToJSValue(status.w_DaDatIni,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ADatIni,null)) {");
        status.out.println(" window[f].w_ADatIni.setTime(("+SPLib.ToJSValue(status.w_ADatIni,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DaDatFin,null)) {");
        status.out.println(" window[f].w_DaDatFin.setTime(("+SPLib.ToJSValue(status.w_DaDatFin,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ADatFin,null)) {");
        status.out.println(" window[f].w_ADatFin.setTime(("+SPLib.ToJSValue(status.w_ADatFin,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipo,null)) {");
        status.out.println("window[f].w_tipo="+SPLib.ToJSValue(status.w_tipo,"C",0,0)+";");
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
      arrt_stprappo_elenco_aeR Rcalled;
      Rcalled = new arrt_stprappo_elenco_aeR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stprappo_elenco_ae");
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
