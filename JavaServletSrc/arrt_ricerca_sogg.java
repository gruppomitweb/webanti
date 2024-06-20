import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_ricerca_sogg extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*4d7064b8*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_criterio;
    public String w_criterio;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_denomin;
    public String w_denomin;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codfisc;
    public String w_codfisc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_simili;
    public String w_simili;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgnega;
    public String w_flgnega;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgnote;
    public String w_flgnote;
    public double _conta;
    public String _denom;
    public String _specseg;
    public java.sql.Date gDatTER;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_criterio = source.Has("w_criterio");
      if (m_bpassedw_criterio) {
        w_criterio = source.GetParameter("w_criterio",source.GetParameter("criterio",""));
      } else {
        if (source.IsForwarded()) {
          w_criterio = source.GetCaller().GetString("criterio","C",1,0);
          m_bpassedw_criterio = true;
        } else {
          w_criterio = source.GetParameter("criterio",source.GetParameter("w_criterio",""));
        }
      }
      m_bpassedw_denomin = source.Has("w_denomin");
      if (m_bpassedw_denomin) {
        w_denomin = source.GetParameter("w_denomin",source.GetParameter("denomin",""));
      } else {
        if (source.IsForwarded()) {
          w_denomin = source.GetCaller().GetString("denomin","C",60,0);
          m_bpassedw_denomin = true;
        } else {
          w_denomin = source.GetParameter("denomin",source.GetParameter("w_denomin",""));
        }
      }
      m_bpassedw_codfisc = source.Has("w_codfisc");
      if (m_bpassedw_codfisc) {
        w_codfisc = source.GetParameter("w_codfisc",source.GetParameter("codfisc",""));
      } else {
        if (source.IsForwarded()) {
          w_codfisc = source.GetCaller().GetString("codfisc","C",16,0);
          m_bpassedw_codfisc = true;
        } else {
          w_codfisc = source.GetParameter("codfisc",source.GetParameter("w_codfisc",""));
        }
      }
      m_bpassedw_simili = source.Has("w_simili");
      if (m_bpassedw_simili) {
        w_simili = source.GetParameter("w_simili",source.GetParameter("simili",""));
      } else {
        if (source.IsForwarded()) {
          w_simili = source.GetCaller().GetString("simili","C",60,0);
          m_bpassedw_simili = true;
        } else {
          w_simili = source.GetParameter("simili",source.GetParameter("w_simili",""));
        }
      }
      m_bpassedw_flgnega = source.Has("w_flgnega");
      if (m_bpassedw_flgnega) {
        w_flgnega = source.GetParameter("w_flgnega",source.GetParameter("flgnega",""));
      } else {
        if (source.IsForwarded()) {
          w_flgnega = source.GetCaller().GetString("flgnega","C",1,0);
          m_bpassedw_flgnega = true;
        } else {
          w_flgnega = source.GetParameter("flgnega",source.GetParameter("w_flgnega",""));
        }
      }
      m_bpassedw_flgnote = source.Has("w_flgnote");
      if (m_bpassedw_flgnote) {
        w_flgnote = source.GetParameter("w_flgnote",source.GetParameter("flgnote",""));
      } else {
        if (source.IsForwarded()) {
          w_flgnote = source.GetCaller().GetString("flgnote","C",1,0);
          m_bpassedw_flgnote = true;
        } else {
          w_flgnote = source.GetParameter("flgnote",source.GetParameter("w_flgnote",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_ricerca_sogg";
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
    return  ! (status.m_bpassedw_flgnote) ||  ! (status.m_bpassedw_flgnega) ||  ! (status.m_bpassedw_simili) ||  ! (status.m_bpassedw_codfisc) ||  ! (status.m_bpassedw_denomin) ||  ! (status.m_bpassedw_criterio);
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
    if ( ! (status.m_bpassedw_criterio)) {
      status.out.println("l_cV=WtA(l_oWnd('w_criterio',"+SPLib.ToJSValue(status.w_criterio,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_criterio,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_criterio',l_cV);");
    if ( ! (status.m_bpassedw_denomin)) {
      status.out.println("l_cV=WtA(l_oWnd('w_denomin',"+SPLib.ToJSValue(status.w_denomin,"C",60,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_denomin,"C",60,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_denomin',l_cV);");
    if ( ! (status.m_bpassedw_codfisc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codfisc',"+SPLib.ToJSValue(status.w_codfisc,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codfisc,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codfisc',l_cV);");
    if ( ! (status.m_bpassedw_simili)) {
      status.out.println("l_cV=WtA(l_oWnd('w_simili',"+SPLib.ToJSValue(status.w_simili,"C",60,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_simili,"C",60,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_simili',l_cV);");
    if ( ! (status.m_bpassedw_flgnega)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgnega',"+SPLib.ToJSValue(status.w_flgnega,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgnega,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgnega',l_cV);");
    if ( ! (status.m_bpassedw_flgnote)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgnote',"+SPLib.ToJSValue(status.w_flgnote,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgnote,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgnote',l_cV);");
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
    arrt_ricerca_soggR Rcalled;
    Rcalled = new arrt_ricerca_soggR(status.context,status);
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
    return new arrt_ricerca_soggR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_ricerca_soggR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_ricerca_sogg"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_criterio="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_criterio),"?",0,0)+"");
        status.out.println("js:w_denomin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_denomin),"?",0,0)+"");
        status.out.println("js:w_codfisc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codfisc),"?",0,0)+"");
        status.out.println("js:w_simili="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_simili),"?",0,0)+"");
        status.out.println("js:w_flgnega="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgnega),"?",0,0)+"");
        status.out.println("js:w_flgnote="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgnote),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_criterio,null)) {");
        status.out.println("window[f].w_criterio="+SPLib.ToJSValue(status.w_criterio,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_denomin,null)) {");
        status.out.println("window[f].w_denomin="+SPLib.ToJSValue(status.w_denomin,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codfisc,null)) {");
        status.out.println("window[f].w_codfisc="+SPLib.ToJSValue(status.w_codfisc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_simili,null)) {");
        status.out.println("window[f].w_simili="+SPLib.ToJSValue(status.w_simili,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgnega,null)) {");
        status.out.println("window[f].w_flgnega="+SPLib.ToJSValue(status.w_flgnega,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgnote,null)) {");
        status.out.println("window[f].w_flgnote="+SPLib.ToJSValue(status.w_flgnote,"C",0,0)+";");
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
      arrt_ricerca_soggR Rcalled;
      Rcalled = new arrt_ricerca_soggR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_ricerca_sogg");
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
