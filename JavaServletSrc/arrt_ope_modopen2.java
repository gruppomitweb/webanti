import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_ope_modopen2 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3f338a1d*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datarett;
    public java.sql.Date w_datarett;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldidbase;
    public String w_oldidbase;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldprog;
    public String w_oldprog;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldrappo;
    public String w_oldrappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldfile;
    public String w_oldfile;
    public String gAzienda;
    public String _coint;
    public String _tipage;
    public String _rifana;
    public String cProg;
    public String cCanc;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_datarett = source.Has("w_datarett");
      if (m_bpassedw_datarett) {
        w_datarett = source.GetParameter("w_datarett",source.GetParameter("datarett",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datarett = source.GetCaller().GetDate("datarett","D",8,0);
          m_bpassedw_datarett = true;
        } else {
          w_datarett = source.GetParameter("datarett",source.GetParameter("w_datarett",CPLib.NullDate()));
        }
      }
      m_bpassedw_oldidbase = source.Has("w_oldidbase");
      if (m_bpassedw_oldidbase) {
        w_oldidbase = source.GetParameter("w_oldidbase",source.GetParameter("oldidbase",""));
      } else {
        if (source.IsForwarded()) {
          w_oldidbase = source.GetCaller().GetString("oldidbase","C",10,0);
          m_bpassedw_oldidbase = true;
        } else {
          w_oldidbase = source.GetParameter("oldidbase",source.GetParameter("w_oldidbase",""));
        }
      }
      m_bpassedw_oldprog = source.Has("w_oldprog");
      if (m_bpassedw_oldprog) {
        w_oldprog = source.GetParameter("w_oldprog",source.GetParameter("oldprog",""));
      } else {
        if (source.IsForwarded()) {
          w_oldprog = source.GetCaller().GetString("oldprog","C",15,0);
          m_bpassedw_oldprog = true;
        } else {
          w_oldprog = source.GetParameter("oldprog",source.GetParameter("w_oldprog",""));
        }
      }
      m_bpassedw_oldrappo = source.Has("w_oldrappo");
      if (m_bpassedw_oldrappo) {
        w_oldrappo = source.GetParameter("w_oldrappo",source.GetParameter("oldrappo",""));
      } else {
        if (source.IsForwarded()) {
          w_oldrappo = source.GetCaller().GetString("oldrappo","C",25,0);
          m_bpassedw_oldrappo = true;
        } else {
          w_oldrappo = source.GetParameter("oldrappo",source.GetParameter("w_oldrappo",""));
        }
      }
      m_bpassedw_oldfile = source.Has("w_oldfile");
      if (m_bpassedw_oldfile) {
        w_oldfile = source.GetParameter("w_oldfile",source.GetParameter("oldfile",""));
      } else {
        if (source.IsForwarded()) {
          w_oldfile = source.GetCaller().GetString("oldfile","C",15,0);
          m_bpassedw_oldfile = true;
        } else {
          w_oldfile = source.GetParameter("oldfile",source.GetParameter("w_oldfile",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_ope_modopen2";
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
    return  ! (status.m_bpassedw_oldfile) ||  ! (status.m_bpassedw_oldrappo) ||  ! (status.m_bpassedw_oldprog) ||  ! (status.m_bpassedw_oldidbase) ||  ! (status.m_bpassedw_datarett);
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
    if ( ! (status.m_bpassedw_datarett)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datarett',"+SPLib.ToJSValue(status.w_datarett,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datarett,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datarett',l_cV);");
    if ( ! (status.m_bpassedw_oldidbase)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldidbase',"+SPLib.ToJSValue(status.w_oldidbase,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldidbase,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldidbase',l_cV);");
    if ( ! (status.m_bpassedw_oldprog)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldprog',"+SPLib.ToJSValue(status.w_oldprog,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldprog,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldprog',l_cV);");
    if ( ! (status.m_bpassedw_oldrappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldrappo',"+SPLib.ToJSValue(status.w_oldrappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldrappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldrappo',l_cV);");
    if ( ! (status.m_bpassedw_oldfile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldfile',"+SPLib.ToJSValue(status.w_oldfile,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldfile,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldfile',l_cV);");
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
    arrt_ope_modopen2R Rcalled;
    Rcalled = new arrt_ope_modopen2R(status.context,status);
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
    return new arrt_ope_modopen2R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_ope_modopen2R Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_ope_modopen2"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_datarett="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datarett),"?",0,0)+"");
        status.out.println("js:w_oldidbase="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldidbase),"?",0,0)+"");
        status.out.println("js:w_oldprog="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldprog),"?",0,0)+"");
        status.out.println("js:w_oldrappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldrappo),"?",0,0)+"");
        status.out.println("js:w_oldfile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldfile),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_datarett,null)) {");
        status.out.println(" window[f].w_datarett.setTime(("+SPLib.ToJSValue(status.w_datarett,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldidbase,null)) {");
        status.out.println("window[f].w_oldidbase="+SPLib.ToJSValue(status.w_oldidbase,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldprog,null)) {");
        status.out.println("window[f].w_oldprog="+SPLib.ToJSValue(status.w_oldprog,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldrappo,null)) {");
        status.out.println("window[f].w_oldrappo="+SPLib.ToJSValue(status.w_oldrappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldfile,null)) {");
        status.out.println("window[f].w_oldfile="+SPLib.ToJSValue(status.w_oldfile,"C",0,0)+";");
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
      arrt_ope_modopen2R Rcalled;
      Rcalled = new arrt_ope_modopen2R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_ope_modopen2");
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
