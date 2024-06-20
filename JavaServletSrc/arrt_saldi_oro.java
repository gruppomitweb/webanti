import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_saldi_oro extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3f540e7e*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_annoope;
    public double w_annoope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNES;
    public String w_CONNES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_imppagato;
    public double w_imppagato;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impricevuto;
    public double w_impricevuto;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_numope;
    public double w_numope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_risultato;
    public String w_risultato;
    public String _rapporto;
    public double _esiste;
    public double _saldi;
    public String _saldiage;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_annoope = source.Has("w_annoope");
      if (m_bpassedw_annoope) {
        w_annoope = source.GetParameter("w_annoope",source.GetParameter("annoope",0));
      } else {
        if (source.IsForwarded()) {
          w_annoope = source.GetCaller().GetNumber("annoope","N",4,0);
          m_bpassedw_annoope = true;
        } else {
          w_annoope = source.GetParameter("annoope",source.GetParameter("w_annoope",0));
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
      m_bpassedw_imppagato = source.Has("w_imppagato");
      if (m_bpassedw_imppagato) {
        w_imppagato = source.GetParameter("w_imppagato",source.GetParameter("imppagato",0));
      } else {
        if (source.IsForwarded()) {
          w_imppagato = source.GetCaller().GetNumber("imppagato","N",15,0);
          m_bpassedw_imppagato = true;
        } else {
          w_imppagato = source.GetParameter("imppagato",source.GetParameter("w_imppagato",0));
        }
      }
      m_bpassedw_impricevuto = source.Has("w_impricevuto");
      if (m_bpassedw_impricevuto) {
        w_impricevuto = source.GetParameter("w_impricevuto",source.GetParameter("impricevuto",0));
      } else {
        if (source.IsForwarded()) {
          w_impricevuto = source.GetCaller().GetNumber("impricevuto","N",15,0);
          m_bpassedw_impricevuto = true;
        } else {
          w_impricevuto = source.GetParameter("impricevuto",source.GetParameter("w_impricevuto",0));
        }
      }
      m_bpassedw_numope = source.Has("w_numope");
      if (m_bpassedw_numope) {
        w_numope = source.GetParameter("w_numope",source.GetParameter("numope",0));
      } else {
        if (source.IsForwarded()) {
          w_numope = source.GetCaller().GetNumber("numope","N",6,0);
          m_bpassedw_numope = true;
        } else {
          w_numope = source.GetParameter("numope",source.GetParameter("w_numope",0));
        }
      }
      m_bpassedw_risultato = source.Has("w_risultato");
      if (m_bpassedw_risultato) {
        w_risultato = source.GetParameter("w_risultato",source.GetParameter("risultato",""));
      } else {
        if (source.IsForwarded()) {
          w_risultato = source.GetCaller().GetString("risultato","C",80,0);
          m_bpassedw_risultato = true;
        } else {
          w_risultato = source.GetParameter("risultato",source.GetParameter("w_risultato",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_saldi_oro";
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
    return  ! (status.m_bpassedw_risultato) ||  ! (status.m_bpassedw_numope) ||  ! (status.m_bpassedw_impricevuto) ||  ! (status.m_bpassedw_imppagato) ||  ! (status.m_bpassedw_CONNES) ||  ! (status.m_bpassedw_annoope);
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
    if ( ! (status.m_bpassedw_annoope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_annoope',"+SPLib.ToJSValue(status.w_annoope,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_annoope,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_annoope',l_cV);");
    if ( ! (status.m_bpassedw_CONNES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNES',"+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNES',l_cV);");
    if ( ! (status.m_bpassedw_imppagato)) {
      status.out.println("l_cV=WtA(l_oWnd('w_imppagato',"+SPLib.ToJSValue(status.w_imppagato,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_imppagato,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_imppagato',l_cV);");
    if ( ! (status.m_bpassedw_impricevuto)) {
      status.out.println("l_cV=WtA(l_oWnd('w_impricevuto',"+SPLib.ToJSValue(status.w_impricevuto,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_impricevuto,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_impricevuto',l_cV);");
    if ( ! (status.m_bpassedw_numope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_numope',"+SPLib.ToJSValue(status.w_numope,"N",6,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_numope,"N",6,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_numope',l_cV);");
    if ( ! (status.m_bpassedw_risultato)) {
      status.out.println("l_cV=WtA(l_oWnd('w_risultato',"+SPLib.ToJSValue(status.w_risultato,"C",80,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_risultato,"C",80,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_risultato',l_cV);");
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
    arrt_saldi_oroR Rcalled;
    Rcalled = new arrt_saldi_oroR(status.context,status);
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
    return new arrt_saldi_oroR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_saldi_oroR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_saldi_oro"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_annoope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_annoope),"?",0,0)+"");
        status.out.println("js:w_CONNES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNES),"?",0,0)+"");
        status.out.println("js:w_imppagato="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_imppagato),"?",0,0)+"");
        status.out.println("js:w_impricevuto="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impricevuto),"?",0,0)+"");
        status.out.println("js:w_numope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_numope),"?",0,0)+"");
        status.out.println("js:w_risultato="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_risultato),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_annoope,null)) {");
        status.out.println("window[f].w_annoope="+SPLib.ToJSValue(status.w_annoope,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CONNES,null)) {");
        status.out.println("window[f].w_CONNES="+SPLib.ToJSValue(status.w_CONNES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_imppagato,null)) {");
        status.out.println("window[f].w_imppagato="+SPLib.ToJSValue(status.w_imppagato,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_impricevuto,null)) {");
        status.out.println("window[f].w_impricevuto="+SPLib.ToJSValue(status.w_impricevuto,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_numope,null)) {");
        status.out.println("window[f].w_numope="+SPLib.ToJSValue(status.w_numope,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_risultato,null)) {");
        status.out.println("window[f].w_risultato="+SPLib.ToJSValue(status.w_risultato,"C",0,0)+";");
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
      arrt_saldi_oroR Rcalled;
      Rcalled = new arrt_saldi_oroR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_saldi_oro");
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
