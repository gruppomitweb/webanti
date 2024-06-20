import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stp_scheda_di_verifica extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*38eacf43*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNES;
    public String w_CONNES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNESLEG;
    public String w_CONNESLEG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ana;
    public double w_ana;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_mpa;
    public double w_mpa;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_neo;
    public double w_neo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_vcam;
    public double w_vcam;
    public String gUrlApp;
    public String gInter;
    public String gTAEG;
    public String gTEG;
    public String gPromo;
    public String gPrevPers;
    public String gCalcCG;
    public String _contito;
    public String pModRep;
    public String nomefile;
    public String intesfile;
    public String fhand;
    public String verifica;
    public String c_neo;
    public String c_old;
    public String c_cod;
    public String pf_rag;
    public String pf_cnome;
    public String pf_nome;
    public String pf_fcf;
    public String pf_f;
    public String pf_fdoc;
    public String pf_doc;
    public String pf_dnas;
    public String pf_lnas;
    public String pf_ctz;
    public String pf_cf;
    public String pf_piva;
    public String pf_sexM;
    public String pf_sexF;
    public String pf_ind;
    public String pf_cap;
    public String pf_cta;
    public String pf_prv;
    public String pf_stato;
    public String pf_tel;
    public String pf_fax;
    public String pf_mail;
    public String pf_ind2;
    public String pf_cap2;
    public String pf_cta2;
    public String pf_prv2;
    public String s_rag;
    public String s_f;
    public String s_fvisu;
    public String s_fdoc;
    public String s_fcf;
    public String s_cf;
    public String s_piva;
    public String s_ind;
    public String s_cap;
    public String s_cta;
    public String s_prv;
    public String s_stato;
    public String l_rag;
    public String l_cnome;
    public String l_nome;
    public String l_fdoc;
    public String l_doc;
    public String l_fcf;
    public String l_cf;
    public String l_sexM;
    public String l_sexF;
    public String l_ind;
    public String l_cap;
    public String l_cta;
    public String l_prv;
    public String l_stato;
    public String l_dnasc;
    public String l_lnasc;
    public String l_ctz;
    public String l_tel;
    public String l_fax;
    public String l_mail;
    public String l_ind2;
    public String l_cap2;
    public String l_cta2;
    public String l_prv2;
    public String t_fsi;
    public String t_fno;
    public String t_f231;
    public String t_fcf;
    public String t_fdoc;
    public String t_doc;
    public void GetNonLocals(SPParameterSource source) {
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
      m_bpassedw_CONNESLEG = source.Has("w_CONNESLEG");
      if (m_bpassedw_CONNESLEG) {
        w_CONNESLEG = source.GetParameter("w_CONNESLEG",source.GetParameter("CONNESLEG",""));
      } else {
        if (source.IsForwarded()) {
          w_CONNESLEG = source.GetCaller().GetString("CONNESLEG","C",16,0);
          m_bpassedw_CONNESLEG = true;
        } else {
          w_CONNESLEG = source.GetParameter("CONNESLEG",source.GetParameter("w_CONNESLEG",""));
        }
      }
      m_bpassedw_ana = source.Has("w_ana");
      if (m_bpassedw_ana) {
        w_ana = source.GetParameter("w_ana",source.GetParameter("ana",0));
      } else {
        if (source.IsForwarded()) {
          w_ana = source.GetCaller().GetNumber("ana","N",1,0);
          m_bpassedw_ana = true;
        } else {
          w_ana = source.GetParameter("ana",source.GetParameter("w_ana",0));
        }
      }
      m_bpassedw_mpa = source.Has("w_mpa");
      if (m_bpassedw_mpa) {
        w_mpa = source.GetParameter("w_mpa",source.GetParameter("mpa",0));
      } else {
        if (source.IsForwarded()) {
          w_mpa = source.GetCaller().GetNumber("mpa","N",1,0);
          m_bpassedw_mpa = true;
        } else {
          w_mpa = source.GetParameter("mpa",source.GetParameter("w_mpa",0));
        }
      }
      m_bpassedw_neo = source.Has("w_neo");
      if (m_bpassedw_neo) {
        w_neo = source.GetParameter("w_neo",source.GetParameter("neo",0));
      } else {
        if (source.IsForwarded()) {
          w_neo = source.GetCaller().GetNumber("neo","N",1,0);
          m_bpassedw_neo = true;
        } else {
          w_neo = source.GetParameter("neo",source.GetParameter("w_neo",0));
        }
      }
      m_bpassedw_vcam = source.Has("w_vcam");
      if (m_bpassedw_vcam) {
        w_vcam = source.GetParameter("w_vcam",source.GetParameter("vcam",0));
      } else {
        if (source.IsForwarded()) {
          w_vcam = source.GetCaller().GetNumber("vcam","N",1,0);
          m_bpassedw_vcam = true;
        } else {
          w_vcam = source.GetParameter("vcam",source.GetParameter("w_vcam",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_stp_scheda_di_verifica";
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
    return  ! (status.m_bpassedw_vcam) ||  ! (status.m_bpassedw_neo) ||  ! (status.m_bpassedw_mpa) ||  ! (status.m_bpassedw_ana) ||  ! (status.m_bpassedw_CONNESLEG) ||  ! (status.m_bpassedw_CONNES);
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
    if ( ! (status.m_bpassedw_CONNES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNES',"+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNES',l_cV);");
    if ( ! (status.m_bpassedw_CONNESLEG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNESLEG',"+SPLib.ToJSValue(status.w_CONNESLEG,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNESLEG,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNESLEG',l_cV);");
    if ( ! (status.m_bpassedw_ana)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ana',"+SPLib.ToJSValue(status.w_ana,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ana,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_ana',l_cV);");
    if ( ! (status.m_bpassedw_mpa)) {
      status.out.println("l_cV=WtA(l_oWnd('w_mpa',"+SPLib.ToJSValue(status.w_mpa,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_mpa,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_mpa',l_cV);");
    if ( ! (status.m_bpassedw_neo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_neo',"+SPLib.ToJSValue(status.w_neo,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_neo,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_neo',l_cV);");
    if ( ! (status.m_bpassedw_vcam)) {
      status.out.println("l_cV=WtA(l_oWnd('w_vcam',"+SPLib.ToJSValue(status.w_vcam,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_vcam,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_vcam',l_cV);");
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
    arrt_stp_scheda_di_verificaR Rcalled;
    Rcalled = new arrt_stp_scheda_di_verificaR(status.context,status);
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
    return new arrt_stp_scheda_di_verificaR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stp_scheda_di_verificaR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stp_scheda_di_verifica"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_CONNES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNES),"?",0,0)+"");
        status.out.println("js:w_CONNESLEG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNESLEG),"?",0,0)+"");
        status.out.println("js:w_ana="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ana),"?",0,0)+"");
        status.out.println("js:w_mpa="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_mpa),"?",0,0)+"");
        status.out.println("js:w_neo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_neo),"?",0,0)+"");
        status.out.println("js:w_vcam="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_vcam),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_CONNES,null)) {");
        status.out.println("window[f].w_CONNES="+SPLib.ToJSValue(status.w_CONNES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CONNESLEG,null)) {");
        status.out.println("window[f].w_CONNESLEG="+SPLib.ToJSValue(status.w_CONNESLEG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ana,null)) {");
        status.out.println("window[f].w_ana="+SPLib.ToJSValue(status.w_ana,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_mpa,null)) {");
        status.out.println("window[f].w_mpa="+SPLib.ToJSValue(status.w_mpa,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_neo,null)) {");
        status.out.println("window[f].w_neo="+SPLib.ToJSValue(status.w_neo,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_vcam,null)) {");
        status.out.println("window[f].w_vcam="+SPLib.ToJSValue(status.w_vcam,"N",0,0)+";");
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
      arrt_stp_scheda_di_verificaR Rcalled;
      Rcalled = new arrt_stp_scheda_di_verificaR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stp_scheda_di_verifica");
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
