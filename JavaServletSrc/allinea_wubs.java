import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class allinea_wubs extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*f9fcbe69*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipodest;
    public String w_tipodest;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impzip;
    public double w_impzip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_opextc;
    public String w_opextc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codmage;
    public String w_codmage;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_destfin;
    public String w_destfin;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xMAFLGRAP;
    public String w_xMAFLGRAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xMAFLGBON;
    public String w_xMAFLGBON;
    public String _idb;
    public String fhand;
    public double nProg;
    public String nomefileimport;
    public String xConnes;
    public double conta;
    public double _nerrori;
    public String _tdest;
    public double _i;
    public String cOpeProg1;
    public String cOpeProg2;
    public double nProgImp;
    public String xData;
    public String _tiporap;
    public double nVal;
    public double ndVal;
    public double nChVal;
    public String cVal;
    public String cTVal;
    public String cCVal;
    public double nIntest;
    public String xCAB;
    public String xDIP;
    public String xDIPx;
    public String cCli1;
    public double cNumNew;
    public double cNumMod;
    public double cNumInv;
    public double _esito;
    public String _idbase;
    public String _intercod;
    public String _intercit;
    public String _intercab;
    public String _interprv;
    public String _intertip;
    public String _ccab;
    public String _cprov;
    public String _ccap;
    public String _csta;
    public String _crag;
    public String _cbanca;
    public String _btipo;
    public String _bragsoc;
    public String _bcodcab;
    public String _bcitta;
    public String _bstato;
    public String _bprov;
    public String _cauana;
    public String _causin;
    public String _segno;
    public String _tipope;
    public String _rappd;
    public double _nocf;
    public String w_CODFISC;
    public java.sql.Date w_DATANASC;
    public String w_NASCOMUN;
    public String w_NASSTATO;
    public String w_COGNOME;
    public String w_RAGSOC;
    public String w_NOME;
    public String w_SESSO;
    public String gPathApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_tipodest = source.Has("w_tipodest");
      if (m_bpassedw_tipodest) {
        w_tipodest = source.GetParameter("w_tipodest",source.GetParameter("tipodest",""));
      } else {
        if (source.IsForwarded()) {
          w_tipodest = source.GetCaller().GetString("tipodest","C",1,0);
          m_bpassedw_tipodest = true;
        } else {
          w_tipodest = source.GetParameter("tipodest",source.GetParameter("w_tipodest",""));
        }
      }
      m_bpassedw_impzip = source.Has("w_impzip");
      if (m_bpassedw_impzip) {
        w_impzip = source.GetParameter("w_impzip",source.GetParameter("impzip",0));
      } else {
        if (source.IsForwarded()) {
          w_impzip = source.GetCaller().GetNumber("impzip","N",1,0);
          m_bpassedw_impzip = true;
        } else {
          w_impzip = source.GetParameter("impzip",source.GetParameter("w_impzip",0));
        }
      }
      m_bpassedw_opextc = source.Has("w_opextc");
      if (m_bpassedw_opextc) {
        w_opextc = source.GetParameter("w_opextc",source.GetParameter("opextc",""));
      } else {
        if (source.IsForwarded()) {
          w_opextc = source.GetCaller().GetString("opextc","C",1,0);
          m_bpassedw_opextc = true;
        } else {
          w_opextc = source.GetParameter("opextc",source.GetParameter("w_opextc",""));
        }
      }
      m_bpassedw_codmage = source.Has("w_codmage");
      if (m_bpassedw_codmage) {
        w_codmage = source.GetParameter("w_codmage",source.GetParameter("codmage",""));
      } else {
        if (source.IsForwarded()) {
          w_codmage = source.GetCaller().GetString("codmage","C",5,0);
          m_bpassedw_codmage = true;
        } else {
          w_codmage = source.GetParameter("codmage",source.GetParameter("w_codmage",""));
        }
      }
      m_bpassedw_destfin = source.Has("w_destfin");
      if (m_bpassedw_destfin) {
        w_destfin = source.GetParameter("w_destfin",source.GetParameter("destfin",""));
      } else {
        if (source.IsForwarded()) {
          w_destfin = source.GetCaller().GetString("destfin","C",1,0);
          m_bpassedw_destfin = true;
        } else {
          w_destfin = source.GetParameter("destfin",source.GetParameter("w_destfin",""));
        }
      }
      m_bpassedw_xMAFLGRAP = source.Has("w_xMAFLGRAP");
      if (m_bpassedw_xMAFLGRAP) {
        w_xMAFLGRAP = source.GetParameter("w_xMAFLGRAP",source.GetParameter("xMAFLGRAP",""));
      } else {
        if (source.IsForwarded()) {
          w_xMAFLGRAP = source.GetCaller().GetString("xMAFLGRAP","C",1,0);
          m_bpassedw_xMAFLGRAP = true;
        } else {
          w_xMAFLGRAP = source.GetParameter("xMAFLGRAP",source.GetParameter("w_xMAFLGRAP",""));
        }
      }
      m_bpassedw_xMAFLGBON = source.Has("w_xMAFLGBON");
      if (m_bpassedw_xMAFLGBON) {
        w_xMAFLGBON = source.GetParameter("w_xMAFLGBON",source.GetParameter("xMAFLGBON",""));
      } else {
        if (source.IsForwarded()) {
          w_xMAFLGBON = source.GetCaller().GetString("xMAFLGBON","C",1,0);
          m_bpassedw_xMAFLGBON = true;
        } else {
          w_xMAFLGBON = source.GetParameter("xMAFLGBON",source.GetParameter("w_xMAFLGBON",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "allinea_wubs";
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
    return  ! (status.m_bpassedw_xMAFLGBON) ||  ! (status.m_bpassedw_xMAFLGRAP) ||  ! (status.m_bpassedw_destfin) ||  ! (status.m_bpassedw_codmage) ||  ! (status.m_bpassedw_opextc) ||  ! (status.m_bpassedw_impzip) ||  ! (status.m_bpassedw_tipodest);
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
    if ( ! (status.m_bpassedw_tipodest)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipodest',"+SPLib.ToJSValue(status.w_tipodest,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipodest,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipodest',l_cV);");
    if ( ! (status.m_bpassedw_impzip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_impzip',"+SPLib.ToJSValue(status.w_impzip,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_impzip,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_impzip',l_cV);");
    if ( ! (status.m_bpassedw_opextc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_opextc',"+SPLib.ToJSValue(status.w_opextc,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_opextc,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_opextc',l_cV);");
    if ( ! (status.m_bpassedw_codmage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codmage',"+SPLib.ToJSValue(status.w_codmage,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codmage,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codmage',l_cV);");
    if ( ! (status.m_bpassedw_destfin)) {
      status.out.println("l_cV=WtA(l_oWnd('w_destfin',"+SPLib.ToJSValue(status.w_destfin,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_destfin,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_destfin',l_cV);");
    if ( ! (status.m_bpassedw_xMAFLGRAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xMAFLGRAP',"+SPLib.ToJSValue(status.w_xMAFLGRAP,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xMAFLGRAP,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xMAFLGRAP',l_cV);");
    if ( ! (status.m_bpassedw_xMAFLGBON)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xMAFLGBON',"+SPLib.ToJSValue(status.w_xMAFLGBON,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xMAFLGBON,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xMAFLGBON',l_cV);");
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
    allinea_wubsR Rcalled;
    Rcalled = new allinea_wubsR(status.context,status);
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
    return new allinea_wubsR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,allinea_wubsR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","allinea_wubs"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_tipodest="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipodest),"?",0,0)+"");
        status.out.println("js:w_impzip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impzip),"?",0,0)+"");
        status.out.println("js:w_opextc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_opextc),"?",0,0)+"");
        status.out.println("js:w_codmage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codmage),"?",0,0)+"");
        status.out.println("js:w_destfin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_destfin),"?",0,0)+"");
        status.out.println("js:w_xMAFLGRAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xMAFLGRAP),"?",0,0)+"");
        status.out.println("js:w_xMAFLGBON="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xMAFLGBON),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_tipodest,null)) {");
        status.out.println("window[f].w_tipodest="+SPLib.ToJSValue(status.w_tipodest,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_impzip,null)) {");
        status.out.println("window[f].w_impzip="+SPLib.ToJSValue(status.w_impzip,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_opextc,null)) {");
        status.out.println("window[f].w_opextc="+SPLib.ToJSValue(status.w_opextc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codmage,null)) {");
        status.out.println("window[f].w_codmage="+SPLib.ToJSValue(status.w_codmage,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_destfin,null)) {");
        status.out.println("window[f].w_destfin="+SPLib.ToJSValue(status.w_destfin,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xMAFLGRAP,null)) {");
        status.out.println("window[f].w_xMAFLGRAP="+SPLib.ToJSValue(status.w_xMAFLGRAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xMAFLGBON,null)) {");
        status.out.println("window[f].w_xMAFLGBON="+SPLib.ToJSValue(status.w_xMAFLGBON,"C",0,0)+";");
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
      allinea_wubsR Rcalled;
      Rcalled = new allinea_wubsR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"allinea_wubs");
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
