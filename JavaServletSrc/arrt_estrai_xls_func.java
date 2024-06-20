import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_estrai_xls_func extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*58137579*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gMsgImp;
    public String gFileName;
    public String gFlgWU;
    public String gUrlApp;
    public String _gPathApp;
    public String _gAzienda;
    public String fhand;
    public String filenome;
    public double righe;
    public String cell01;
    public String column01;
    public double cell_count;
    public double riga_letta;
    public String _file;
    public java.sql.Date _dadata;
    public java.sql.Date _a_data;
    public String prova;
    public String foglio;
    public String _nfile;
    public String stringa;
    public String numero;
    public String dData;
    public String dataoggi;
    public String numprog;
    public String datareg;
    public java.sql.Date _datareg;
    public String dataope;
    public java.sql.Date _dataope;
    public String f_datope;
    public String f_datnas;
    public String f_datreg;
    public String tipope;
    public String cauana;
    public String causin;
    public String segno;
    public String valuta;
    public String divisa;
    public double cambio;
    public double totimp;
    public double totcon;
    public String codfisc;
    public String nominativo;
    public String indirizzo;
    public String citres;
    public String capres;
    public String prvres;
    public String stares;
    public String citnas;
    public String prvnas;
    public String stanas;
    public String sesso;
    public String datnas;
    public java.sql.Date _datnas;
    public String tipdoc;
    public String autril;
    public String numdoc;
    public String datril;
    public java.sql.Date _datril;
    public String _testa;
    public String _agetesta;
    public String _sqr;
    public String _coddip;
    public String _namdip;
    public String _citdip;
    public String _nomman;
    public String _cogman;
    public String _nazben;
    public String _luonas;
    public String _tipdoc;
    public String _numdoc;
    public String f_datdoc;
    public String _autril;
    public String _numprog;
    public String _mtcn;
    public String _macage;
    public String _stator;
    public String _rapporto;
    public double riga;
    public String _ndg;
    public String _cfestero;
    public String _numsto;
    public double _ctot;
    public String cNomeFile;
    public String cNomeFileZip;
    public java.sql.Date _datadoc;
    public double _max;
    public double _min;
    public double _tot;
    public double _mono;
    public double _cicli;
    public double _contacicli;
    public double _bottom;
    public double _top;
    public String _mstato;
    public String _rifimp;
    public String _rifimp2;
    public String _connesdoc;
    public java.sql.Date _datarett;
    public String _dcauana;
    public String _dcausin;
    public String _dpaeseres;
    public String _dpaesedes;
    public String _dtipoope;
    public String _dstator;
    public String prcProg;
    public String cOutput;
    public String _codstar;
    public double _totgen;
    public String fmhand;
    public String _file1;
    public String _file2;
    public double _totalone;
    public String _orgdati;
    public String _codinter;
    public String _prvdip;
    public String _cabdip;
    public String _inddip;
    public String _cfromdate;
    public String _c_todate;
    public String _nomefile;
    public String _ragsoc;
    public double _importo;
    public String _ajwcode;
    public java.sql.Date _datasto;
    public java.sql.Date _datascad;
    public String _fdtscad;
    public String _iban;
    MemoryCursor_mcparametri_mcrdef pmcParametri;
    public String pAzienda;
    public String pPath;
    void PrintMutableParameters() throws java.io.IOException {
      CPMemoryCursor l_PreviousResult = this.m_CursorResult;
      boolean l_PreviousMutated = this.m_bMutated;
      try {
        this.m_bMutated = true;
        this.out.println("djs:pmcParametri=");
        this.m_CursorResult = this.pmcParametri;
        JSResultSet(this);
        this.out.println();
      } finally {
        this.m_CursorResult = l_PreviousResult;
        this.m_bMutated = l_PreviousMutated;
      }
    }
    public void GetNonLocals(SPParameterSource source) {
      Map<String,Object> l_UniqueIDs;
      l_UniqueIDs = new HashMap<String,Object>();
      Properties l_PropertiesRead;
      l_PropertiesRead = CPMemoryCursor.GetProperties(source.GetParameter("pmcParametri",""));
      if (l_UniqueIDs.containsKey(l_PropertiesRead.getProperty("uniqueID"))) {
        pmcParametri = (MemoryCursor_mcparametri_mcrdef)l_UniqueIDs.get(l_PropertiesRead.getProperty("uniqueID"));
      } else {
        pmcParametri = new MemoryCursor_mcparametri_mcrdef(l_PropertiesRead,this.context);
        if ( ! (CPLib.IsNull(l_PropertiesRead.getProperty("uniqueID")))) {
          l_UniqueIDs.put(l_PropertiesRead.getProperty("uniqueID"),pmcParametri);
        }
      }
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pAzienda","pAzienda");
      }        
      pAzienda = source.GetParameter("pAzienda","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pPath","pPath");
      }        
      pPath = source.GetParameter("pPath","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_estrai_xls_func";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = true;
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
    return false;
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pmcParametri,"MC",0,0)+",'MC');");
    status.out.println("l_oWv.setValue('pmcParametri',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pAzienda,"C",10,0)+",'C');");
    status.out.println("l_oWv.setValue('pAzienda',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pPath,"C",80,0)+",'C');");
    status.out.println("l_oWv.setValue('pPath',l_cV);");
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
    arrt_estrai_xls_funcR Rcalled;
    Rcalled = new arrt_estrai_xls_funcR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.pmcParametri,status.pAzienda,status.pPath);
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
    return new arrt_estrai_xls_funcR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_estrai_xls_funcR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.pmcParametri,status.pAzienda,status.pPath)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_estrai_xls_func"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
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
        if (status.m_bError) {
          l_cErrMsg = status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(status.m_cErrMsg));
          status.out.println("window[f].l_cErrorMsg="+SPLib.ToJSValue(l_cErrMsg,"C",0,0)+";");
          status.out.println("window[f].DisplayErrorMessage();");
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
      arrt_estrai_xls_funcR Rcalled;
      Rcalled = new arrt_estrai_xls_funcR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_estrai_xls_func");
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
