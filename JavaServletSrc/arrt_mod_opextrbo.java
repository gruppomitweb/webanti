import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_mod_opextrbo extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*9a8df2ea*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_annorif;
    public String w_annorif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codval;
    public String w_codval;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNES;
    public String w_CONNES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dataope;
    public java.sql.Date w_dataope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impsaldo;
    public double w_impsaldo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_nummov;
    public double w_nummov;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_txtnote;
    public String w_txtnote;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdesval;
    public String w_xdesval;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_annorif = source.Has("w_annorif");
      if (m_bpassedw_annorif) {
        w_annorif = source.GetParameter("w_annorif",source.GetParameter("annorif",""));
      } else {
        if (source.IsForwarded()) {
          w_annorif = source.GetCaller().GetString("annorif","C",4,0);
          m_bpassedw_annorif = true;
        } else {
          w_annorif = source.GetParameter("annorif",source.GetParameter("w_annorif",""));
        }
      }
      m_bpassedw_codval = source.Has("w_codval");
      if (m_bpassedw_codval) {
        w_codval = source.GetParameter("w_codval",source.GetParameter("codval",""));
      } else {
        if (source.IsForwarded()) {
          w_codval = source.GetCaller().GetString("codval","C",3,0);
          m_bpassedw_codval = true;
        } else {
          w_codval = source.GetParameter("codval",source.GetParameter("w_codval",""));
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
      m_bpassedw_impsaldo = source.Has("w_impsaldo");
      if (m_bpassedw_impsaldo) {
        w_impsaldo = source.GetParameter("w_impsaldo",source.GetParameter("impsaldo",0));
      } else {
        if (source.IsForwarded()) {
          w_impsaldo = source.GetCaller().GetNumber("impsaldo","N",17,0);
          m_bpassedw_impsaldo = true;
        } else {
          w_impsaldo = source.GetParameter("impsaldo",source.GetParameter("w_impsaldo",0));
        }
      }
      m_bpassedw_nummov = source.Has("w_nummov");
      if (m_bpassedw_nummov) {
        w_nummov = source.GetParameter("w_nummov",source.GetParameter("nummov",0));
      } else {
        if (source.IsForwarded()) {
          w_nummov = source.GetCaller().GetNumber("nummov","N",10,0);
          m_bpassedw_nummov = true;
        } else {
          w_nummov = source.GetParameter("nummov",source.GetParameter("w_nummov",0));
        }
      }
      m_bpassedw_txtnote = source.Has("w_txtnote");
      if (m_bpassedw_txtnote) {
        w_txtnote = source.GetParameter("w_txtnote",source.GetParameter("txtnote",""));
      } else {
        if (source.IsForwarded()) {
          w_txtnote = source.GetCaller().GetString("txtnote","C",50,0);
          m_bpassedw_txtnote = true;
        } else {
          w_txtnote = source.GetParameter("txtnote",source.GetParameter("w_txtnote",""));
        }
      }
      m_bpassedw_xdesval = source.Has("w_xdesval");
      if (m_bpassedw_xdesval) {
        w_xdesval = source.GetParameter("w_xdesval",source.GetParameter("xdesval",""));
      } else {
        if (source.IsForwarded()) {
          w_xdesval = source.GetCaller().GetString("xdesval","C",45,0);
          m_bpassedw_xdesval = true;
        } else {
          w_xdesval = source.GetParameter("xdesval",source.GetParameter("w_xdesval",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_mod_opextrbo";
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
    return  ! (status.m_bpassedw_xdesval) ||  ! (status.m_bpassedw_txtnote) ||  ! (status.m_bpassedw_nummov) ||  ! (status.m_bpassedw_impsaldo) ||  ! (status.m_bpassedw_dataope) ||  ! (status.m_bpassedw_CONNES) ||  ! (status.m_bpassedw_codval) ||  ! (status.m_bpassedw_annorif);
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
    if ( ! (status.m_bpassedw_annorif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_annorif',"+SPLib.ToJSValue(status.w_annorif,"C",4,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_annorif,"C",4,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_annorif',l_cV);");
    if ( ! (status.m_bpassedw_codval)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codval',"+SPLib.ToJSValue(status.w_codval,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codval,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codval',l_cV);");
    if ( ! (status.m_bpassedw_CONNES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNES',"+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNES',l_cV);");
    if ( ! (status.m_bpassedw_dataope)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_dataope',"+SPLib.ToJSValue(status.w_dataope,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dataope,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_dataope',l_cV);");
    if ( ! (status.m_bpassedw_impsaldo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_impsaldo',"+SPLib.ToJSValue(status.w_impsaldo,"N",17,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_impsaldo,"N",17,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_impsaldo',l_cV);");
    if ( ! (status.m_bpassedw_nummov)) {
      status.out.println("l_cV=WtA(l_oWnd('w_nummov',"+SPLib.ToJSValue(status.w_nummov,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_nummov,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_nummov',l_cV);");
    if ( ! (status.m_bpassedw_txtnote)) {
      status.out.println("l_cV=WtA(l_oWnd('w_txtnote',"+SPLib.ToJSValue(status.w_txtnote,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_txtnote,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_txtnote',l_cV);");
    if ( ! (status.m_bpassedw_xdesval)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xdesval',"+SPLib.ToJSValue(status.w_xdesval,"C",45,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdesval,"C",45,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xdesval',l_cV);");
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
    arrt_mod_opextrboR Rcalled;
    Rcalled = new arrt_mod_opextrboR(status.context,status);
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
    return new arrt_mod_opextrboR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_mod_opextrboR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_mod_opextrbo"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_annorif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_annorif),"?",0,0)+"");
        status.out.println("js:w_codval="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codval),"?",0,0)+"");
        status.out.println("js:w_CONNES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNES),"?",0,0)+"");
        status.out.println("js:w_dataope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dataope),"?",0,0)+"");
        status.out.println("js:w_impsaldo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impsaldo),"?",0,0)+"");
        status.out.println("js:w_nummov="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_nummov),"?",0,0)+"");
        status.out.println("js:w_txtnote="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_txtnote),"?",0,0)+"");
        status.out.println("js:w_xdesval="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdesval),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_annorif,null)) {");
        status.out.println("window[f].w_annorif="+SPLib.ToJSValue(status.w_annorif,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codval,null)) {");
        status.out.println("window[f].w_codval="+SPLib.ToJSValue(status.w_codval,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CONNES,null)) {");
        status.out.println("window[f].w_CONNES="+SPLib.ToJSValue(status.w_CONNES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_dataope,null)) {");
        status.out.println(" window[f].w_dataope.setTime(("+SPLib.ToJSValue(status.w_dataope,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_impsaldo,null)) {");
        status.out.println("window[f].w_impsaldo="+SPLib.ToJSValue(status.w_impsaldo,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_nummov,null)) {");
        status.out.println("window[f].w_nummov="+SPLib.ToJSValue(status.w_nummov,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_txtnote,null)) {");
        status.out.println("window[f].w_txtnote="+SPLib.ToJSValue(status.w_txtnote,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdesval,null)) {");
        status.out.println("window[f].w_xdesval="+SPLib.ToJSValue(status.w_xdesval,"C",0,0)+";");
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
      arrt_mod_opextrboR Rcalled;
      Rcalled = new arrt_mod_opextrboR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_mod_opextrbo");
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
