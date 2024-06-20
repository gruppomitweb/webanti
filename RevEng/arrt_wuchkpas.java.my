import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_wuchkpas extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*309e065f*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipodest;
    public String w_tipodest;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_opextc;
    public String w_opextc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_destfin;
    public String w_destfin;
    public String fhand;
    public String riga;
    public double nProg;
    public String nomefileimport;
    public String xConnes;
    public double conta;
    public String _tdest;
    public double _i;
    public String _tipope;
    public double _pos;
    public double _npos;
    public String _tipoop;
    public String _coddip;
    public String _uniquecode;
    public java.sql.Date _datope;
    public String _impstr;
    public double _importo;
    public String _statodest;
    public String _statores;
    public String _isodest;
    public String _cognome;
    public String _nome;
    public String _citta;
    public String _cap;
    public String _via;
    public String _prov;
    public String _cab;
    public String _cognomecp;
    public String _nomecp;
    public String _sesso;
    public String _nascitta;
    public String _nasstato;
    public String _nasprov;
    public java.sql.Date _nasdata;
    public String _tipodoc;
    public String _numdoc;
    public java.sql.Date _docril;
    public String _autril;
    public java.sql.Date _docsca;
    public String _codfis;
    public String _connes;
    public String cOpeProg1;
    public String cOpeProg2;
    public double nProgImp;
    public String xSesso;
    public String xCAB;
    public String xDIP;
    public String xDIPx;
    public String cCli1;
    public String xIDB;
    public String xData;
    public String xDatF;
    public double cNumNew;
    public double cNumMod;
    public double cNumInv;
    public double _esito;
    public String _idbase;
    public String _intercod;
    public String _intercit;
    public String _intercab;
    public String _interprv;
    public String _doctype;
    public String _codana;
    public String _codsin;
    public String _segno;
    public String _uifdest;
    public String cProgSto;
    public String _prog;
    public double _nocf;
    public String _condoc;
    public String _idfile;
    public String _mage;
    public String _oldcodfis;
    public java.sql.Timestamp _dtimport;
    public String _txtope;
    public double _errore;
    public double _nerrori;
    public double eProg;
    public String _codstanas;
    public String _merr;
    public String _oldmac;
    public double _aggcli;
    public String _tiperr;
    public String w_codmage;
    public String _codrap;
    public String _listerr;
    public String _intertip;
    public String w_xMAFLGRAP;
    public String w_xMAFLGBON;
    public String w_xMAFLGCKR;
    public String w_xMAFLGASR;
    public String _siglacit;
    public String _siglasta;
    public String _citinter;
    public String _cabinter;
    public String _prvinter;
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
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_wuchkpas";
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
    return  ! (status.m_bpassedw_destfin) ||  ! (status.m_bpassedw_opextc) ||  ! (status.m_bpassedw_tipodest);
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
    if ( ! (status.m_bpassedw_opextc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_opextc',"+SPLib.ToJSValue(status.w_opextc,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_opextc,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_opextc',l_cV);");
    if ( ! (status.m_bpassedw_destfin)) {
      status.out.println("l_cV=WtA(l_oWnd('w_destfin',"+SPLib.ToJSValue(status.w_destfin,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_destfin,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_destfin',l_cV);");
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
    arrt_wuchkpasR Rcalled;
    Rcalled = new arrt_wuchkpasR(status.context,status);
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
    return new arrt_wuchkpasR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_wuchkpasR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_wuchkpas"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_tipodest="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipodest),"?",0,0)+"");
        status.out.println("js:w_opextc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_opextc),"?",0,0)+"");
        status.out.println("js:w_destfin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_destfin),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_opextc,null)) {");
        status.out.println("window[f].w_opextc="+SPLib.ToJSValue(status.w_opextc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_destfin,null)) {");
        status.out.println("window[f].w_destfin="+SPLib.ToJSValue(status.w_destfin,"C",0,0)+";");
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
      arrt_wuchkpasR Rcalled;
      Rcalled = new arrt_wuchkpasR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_wuchkpas");
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
