import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_inviomese_globale extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*1a6b1924*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dadatag;
    public java.sql.Date w_dadatag;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_a_datag;
    public java.sql.Date w_a_datag;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_bloccaedit;
    public String w_bloccaedit;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_errore;
    public String w_errore;
    public String _errlog;
    public double imprec;
    public double _noprot;
    public String _rapold;
    public String _tipoco;
    public double _nriga;
    public double _newrow;
    public double _conta;
    public String _idriga;
    public double _bottom;
    public double _top;
    public double _max;
    public double _cicli;
    public double _min;
    public double nProgImp;
    public double nProgImp2;
    public String _cfestero;
    public String _cfimport;
    public double _chkimp;
    public java.sql.Date w_dadata;
    public java.sql.Date w_a_data;
    public String gMsgImp;
    public String gAzienda;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_dadatag = source.Has("w_dadatag");
      if (m_bpassedw_dadatag) {
        w_dadatag = source.GetParameter("w_dadatag",source.GetParameter("dadatag",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_dadatag = source.GetCaller().GetDate("dadatag","D",8,0);
          m_bpassedw_dadatag = true;
        } else {
          w_dadatag = source.GetParameter("dadatag",source.GetParameter("w_dadatag",CPLib.NullDate()));
        }
      }
      m_bpassedw_a_datag = source.Has("w_a_datag");
      if (m_bpassedw_a_datag) {
        w_a_datag = source.GetParameter("w_a_datag",source.GetParameter("a_datag",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_a_datag = source.GetCaller().GetDate("a_datag","D",8,0);
          m_bpassedw_a_datag = true;
        } else {
          w_a_datag = source.GetParameter("a_datag",source.GetParameter("w_a_datag",CPLib.NullDate()));
        }
      }
      m_bpassedw_bloccaedit = source.Has("w_bloccaedit");
      if (m_bpassedw_bloccaedit) {
        w_bloccaedit = source.GetParameter("w_bloccaedit",source.GetParameter("bloccaedit",""));
      } else {
        if (source.IsForwarded()) {
          w_bloccaedit = source.GetCaller().GetString("bloccaedit","C",1,0);
          m_bpassedw_bloccaedit = true;
        } else {
          w_bloccaedit = source.GetParameter("bloccaedit",source.GetParameter("w_bloccaedit",""));
        }
      }
      m_bpassedw_errore = source.Has("w_errore");
      if (m_bpassedw_errore) {
        w_errore = source.GetParameter("w_errore",source.GetParameter("errore",""));
      } else {
        if (source.IsForwarded()) {
          w_errore = source.GetCaller().GetString("errore","C",120,0);
          m_bpassedw_errore = true;
        } else {
          w_errore = source.GetParameter("errore",source.GetParameter("w_errore",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_inviomese_globale";
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
    return  ! (status.m_bpassedw_errore) ||  ! (status.m_bpassedw_bloccaedit) ||  ! (status.m_bpassedw_a_datag) ||  ! (status.m_bpassedw_dadatag);
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
    if ( ! (status.m_bpassedw_dadatag)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_dadatag',"+SPLib.ToJSValue(status.w_dadatag,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dadatag,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_dadatag',l_cV);");
    if ( ! (status.m_bpassedw_a_datag)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_a_datag',"+SPLib.ToJSValue(status.w_a_datag,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_a_datag,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_a_datag',l_cV);");
    if ( ! (status.m_bpassedw_bloccaedit)) {
      status.out.println("l_cV=WtA(l_oWnd('w_bloccaedit',"+SPLib.ToJSValue(status.w_bloccaedit,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_bloccaedit,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_bloccaedit',l_cV);");
    if ( ! (status.m_bpassedw_errore)) {
      status.out.println("l_cV=WtA(l_oWnd('w_errore',"+SPLib.ToJSValue(status.w_errore,"C",120,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_errore,"C",120,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_errore',l_cV);");
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
    arrt_inviomese_globaleR Rcalled;
    Rcalled = new arrt_inviomese_globaleR(status.context,status);
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
    return new arrt_inviomese_globaleR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_inviomese_globaleR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_inviomese_globale"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_dadatag="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dadatag),"?",0,0)+"");
        status.out.println("js:w_a_datag="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_a_datag),"?",0,0)+"");
        status.out.println("js:w_bloccaedit="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_bloccaedit),"?",0,0)+"");
        status.out.println("js:w_errore="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_errore),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_dadatag,null)) {");
        status.out.println(" window[f].w_dadatag.setTime(("+SPLib.ToJSValue(status.w_dadatag,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_a_datag,null)) {");
        status.out.println(" window[f].w_a_datag.setTime(("+SPLib.ToJSValue(status.w_a_datag,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_bloccaedit,null)) {");
        status.out.println("window[f].w_bloccaedit="+SPLib.ToJSValue(status.w_bloccaedit,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_errore,null)) {");
        status.out.println("window[f].w_errore="+SPLib.ToJSValue(status.w_errore,"C",0,0)+";");
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
      arrt_inviomese_globaleR Rcalled;
      Rcalled = new arrt_inviomese_globaleR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_inviomese_globale");
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
