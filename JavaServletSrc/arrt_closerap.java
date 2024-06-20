import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_closerap extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*7cface53*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dataope;
    public java.sql.Date w_dataope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datareg;
    public java.sql.Date w_datareg;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipope;
    public String w_tipope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdes1;
    public String w_xdes1;
    public String gAzienda;
    public String cProg1;
    public String cProg2;
    public double nProgImp;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_dataope = source.Has("w_dataope");
      if (m_bpassedw_dataope) {
        w_dataope = source.GetParameter("w_dataope",source.GetParameter("dataope",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_dataope = source.GetCaller().GetDate("dataope","D",8,0);
          m_bpassedw_dataope = true;
        } else {
          w_dataope = source.GetParameter("dataope",source.GetParameter("w_dataope",CPLib.NullDate()));
        }
      }
      m_bpassedw_datareg = source.Has("w_datareg");
      if (m_bpassedw_datareg) {
        w_datareg = source.GetParameter("w_datareg",source.GetParameter("datareg",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datareg = source.GetCaller().GetDate("datareg","D",8,0);
          m_bpassedw_datareg = true;
        } else {
          w_datareg = source.GetParameter("datareg",source.GetParameter("w_datareg",CPLib.NullDate()));
        }
      }
      m_bpassedw_tipope = source.Has("w_tipope");
      if (m_bpassedw_tipope) {
        w_tipope = source.GetParameter("w_tipope",source.GetParameter("tipope",""));
      } else {
        if (source.IsForwarded()) {
          w_tipope = source.GetCaller().GetString("tipope","C",2,0);
          m_bpassedw_tipope = true;
        } else {
          w_tipope = source.GetParameter("tipope",source.GetParameter("w_tipope",""));
        }
      }
      m_bpassedw_xdes1 = source.Has("w_xdes1");
      if (m_bpassedw_xdes1) {
        w_xdes1 = source.GetParameter("w_xdes1",source.GetParameter("xdes1",""));
      } else {
        if (source.IsForwarded()) {
          w_xdes1 = source.GetCaller().GetString("xdes1","C",90,0);
          m_bpassedw_xdes1 = true;
        } else {
          w_xdes1 = source.GetParameter("xdes1",source.GetParameter("w_xdes1",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_closerap";
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
    return  ! (status.m_bpassedw_xdes1) ||  ! (status.m_bpassedw_tipope) ||  ! (status.m_bpassedw_datareg) ||  ! (status.m_bpassedw_dataope);
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
    if ( ! (status.m_bpassedw_dataope)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_dataope',"+SPLib.ToJSValue(status.w_dataope,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dataope,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_dataope',l_cV);");
    if ( ! (status.m_bpassedw_datareg)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datareg',"+SPLib.ToJSValue(status.w_datareg,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datareg,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datareg',l_cV);");
    if ( ! (status.m_bpassedw_tipope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipope',"+SPLib.ToJSValue(status.w_tipope,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipope,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipope',l_cV);");
    if ( ! (status.m_bpassedw_xdes1)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xdes1',"+SPLib.ToJSValue(status.w_xdes1,"C",90,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdes1,"C",90,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xdes1',l_cV);");
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
    arrt_closerapR Rcalled;
    Rcalled = new arrt_closerapR(status.context,status);
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
    return new arrt_closerapR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_closerapR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_closerap"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_dataope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dataope),"?",0,0)+"");
        status.out.println("js:w_datareg="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datareg),"?",0,0)+"");
        status.out.println("js:w_tipope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipope),"?",0,0)+"");
        status.out.println("js:w_xdes1="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdes1),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_dataope,null)) {");
        status.out.println(" window[f].w_dataope.setTime(("+SPLib.ToJSValue(status.w_dataope,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datareg,null)) {");
        status.out.println(" window[f].w_datareg.setTime(("+SPLib.ToJSValue(status.w_datareg,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipope,null)) {");
        status.out.println("window[f].w_tipope="+SPLib.ToJSValue(status.w_tipope,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdes1,null)) {");
        status.out.println("window[f].w_xdes1="+SPLib.ToJSValue(status.w_xdes1,"C",0,0)+";");
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
      arrt_closerapR Rcalled;
      Rcalled = new arrt_closerapR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_closerap");
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
