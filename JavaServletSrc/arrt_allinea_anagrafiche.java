import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_allinea_anagrafiche extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*f8f60478*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ccab;
    public double w_ccab;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ccodfisc;
    public double w_ccodfisc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rvalcampi;
    public String w_rvalcampi;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cutf8;
    public double w_cutf8;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cstandard;
    public double w_cstandard;
    public String gMsgAll;
    public String gMsgProc;
    public double gReport;
    public String connes;
    public String ragsoc;
    public double errori;
    public double _max;
    public double _cnt;
    public double _cicli;
    public double _conta;
    public double _top;
    public double _bottom;
    public double _contar;
    public double _errcabnofind;
    public double _errnocab;
    public double _errcfnocorretto;
    public double _errcfnocomune;
    public double _errutf8;
    public double _report;
    public double w_a_comuni;
    public double w_b_cf;
    public double w_c_utf8;
    public double w_d_totali;
    public String _mini;
    public String cab_citta;
    public String cab_cap;
    public String cab_prov;
    public String cab_stato;
    public String cab2_citta;
    public String cab2_cap;
    public String cab2_prov;
    public String cab2_stato;
    public String cf_oggi;
    public String cf_decennio;
    public java.sql.Date cf_datanasc;
    public String cf_anno;
    public String cf_mese;
    public double cf_asc;
    public String cf_giorno;
    public String cf_sesso;
    public String cf_sigla;
    public String cf_citta;
    public String cf_prov;
    public String cf_stato;
    public java.sql.Date cf2_datanasc;
    public String cf2_sesso;
    public String cf2_citta;
    public String cf2_prov;
    public String cf2_stato;
    public String u_nascomun;
    public String u_desccit;
    public String u_ragsoc;
    public String u_nome;
    public String u_cognome;
    public String u_c;
    public String u_c2;
    public String u_c3;
    public double u_i;
    public double u_lenfor;
    public double u_mod;
    public double cabok;
    public double cfok;
    public double utf8ok;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_ccab = source.Has("w_ccab");
      if (m_bpassedw_ccab) {
        w_ccab = source.GetParameter("w_ccab",source.GetParameter("ccab",0));
      } else {
        if (source.IsForwarded()) {
          w_ccab = source.GetCaller().GetNumber("ccab","N",1,0);
          m_bpassedw_ccab = true;
        } else {
          w_ccab = source.GetParameter("ccab",source.GetParameter("w_ccab",0));
        }
      }
      m_bpassedw_ccodfisc = source.Has("w_ccodfisc");
      if (m_bpassedw_ccodfisc) {
        w_ccodfisc = source.GetParameter("w_ccodfisc",source.GetParameter("ccodfisc",0));
      } else {
        if (source.IsForwarded()) {
          w_ccodfisc = source.GetCaller().GetNumber("ccodfisc","N",1,0);
          m_bpassedw_ccodfisc = true;
        } else {
          w_ccodfisc = source.GetParameter("ccodfisc",source.GetParameter("w_ccodfisc",0));
        }
      }
      m_bpassedw_rvalcampi = source.Has("w_rvalcampi");
      if (m_bpassedw_rvalcampi) {
        w_rvalcampi = source.GetParameter("w_rvalcampi",source.GetParameter("rvalcampi",""));
      } else {
        if (source.IsForwarded()) {
          w_rvalcampi = source.GetCaller().GetString("rvalcampi","C",1,0);
          m_bpassedw_rvalcampi = true;
        } else {
          w_rvalcampi = source.GetParameter("rvalcampi",source.GetParameter("w_rvalcampi",""));
        }
      }
      m_bpassedw_cutf8 = source.Has("w_cutf8");
      if (m_bpassedw_cutf8) {
        w_cutf8 = source.GetParameter("w_cutf8",source.GetParameter("cutf8",0));
      } else {
        if (source.IsForwarded()) {
          w_cutf8 = source.GetCaller().GetNumber("cutf8","N",1,0);
          m_bpassedw_cutf8 = true;
        } else {
          w_cutf8 = source.GetParameter("cutf8",source.GetParameter("w_cutf8",0));
        }
      }
      m_bpassedw_cstandard = source.Has("w_cstandard");
      if (m_bpassedw_cstandard) {
        w_cstandard = source.GetParameter("w_cstandard",source.GetParameter("cstandard",0));
      } else {
        if (source.IsForwarded()) {
          w_cstandard = source.GetCaller().GetNumber("cstandard","N",10,0);
          m_bpassedw_cstandard = true;
        } else {
          w_cstandard = source.GetParameter("cstandard",source.GetParameter("w_cstandard",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_allinea_anagrafiche";
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
    return  ! (status.m_bpassedw_cstandard) ||  ! (status.m_bpassedw_cutf8) ||  ! (status.m_bpassedw_rvalcampi) ||  ! (status.m_bpassedw_ccodfisc) ||  ! (status.m_bpassedw_ccab);
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
    if ( ! (status.m_bpassedw_ccab)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ccab',"+SPLib.ToJSValue(status.w_ccab,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ccab,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_ccab',l_cV);");
    if ( ! (status.m_bpassedw_ccodfisc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ccodfisc',"+SPLib.ToJSValue(status.w_ccodfisc,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ccodfisc,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_ccodfisc',l_cV);");
    if ( ! (status.m_bpassedw_rvalcampi)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rvalcampi',"+SPLib.ToJSValue(status.w_rvalcampi,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rvalcampi,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rvalcampi',l_cV);");
    if ( ! (status.m_bpassedw_cutf8)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cutf8',"+SPLib.ToJSValue(status.w_cutf8,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cutf8,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_cutf8',l_cV);");
    if ( ! (status.m_bpassedw_cstandard)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cstandard',"+SPLib.ToJSValue(status.w_cstandard,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cstandard,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_cstandard',l_cV);");
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
    arrt_allinea_anagraficheR Rcalled;
    Rcalled = new arrt_allinea_anagraficheR(status.context,status);
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
    return new arrt_allinea_anagraficheR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_allinea_anagraficheR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_allinea_anagrafiche"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_ccab="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ccab),"?",0,0)+"");
        status.out.println("js:w_ccodfisc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ccodfisc),"?",0,0)+"");
        status.out.println("js:w_rvalcampi="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rvalcampi),"?",0,0)+"");
        status.out.println("js:w_cutf8="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cutf8),"?",0,0)+"");
        status.out.println("js:w_cstandard="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cstandard),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_ccab,null)) {");
        status.out.println("window[f].w_ccab="+SPLib.ToJSValue(status.w_ccab,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ccodfisc,null)) {");
        status.out.println("window[f].w_ccodfisc="+SPLib.ToJSValue(status.w_ccodfisc,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rvalcampi,null)) {");
        status.out.println("window[f].w_rvalcampi="+SPLib.ToJSValue(status.w_rvalcampi,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cutf8,null)) {");
        status.out.println("window[f].w_cutf8="+SPLib.ToJSValue(status.w_cutf8,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cstandard,null)) {");
        status.out.println("window[f].w_cstandard="+SPLib.ToJSValue(status.w_cstandard,"N",0,0)+";");
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
      arrt_allinea_anagraficheR Rcalled;
      Rcalled = new arrt_allinea_anagraficheR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_allinea_anagrafiche");
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
