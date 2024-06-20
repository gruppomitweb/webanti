import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_imp_dati_rtra extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*97dfe0c8*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String _azienda;
    public String cProg;
    public String w_destfin;
    public String _trxdate;
    public String fhand;
    public String ihand;
    public String dhand;
    public String xhand;
    public String iNomeFile;
    public String riga;
    public String _codrap;
    public String _luonas;
    public double nProg;
    public String nomefileimport;
    public String xConnes;
    public String _tdest;
    public double _pos;
    public double _npos;
    public String _tipoop;
    public String _coddip;
    public String _uniquecode;
    public java.sql.Date _datope;
    public java.sql.Date _datmod;
    public java.sql.Date _datreal;
    public java.sql.Date _datreg;
    public String _impstr;
    public double _importo;
    public double _contanti;
    public String _flgcash;
    public String _statodest;
    public String _isodest;
    public String _cognome;
    public String _nome;
    public String _citta;
    public String _cap;
    public String _via;
    public String _paese;
    public String _prov;
    public String _cab;
    public String _cognomecp;
    public String _nomecp;
    public String _pep;
    public String _sesso;
    public String _nascitta;
    public String _nasstato;
    public String _resstato;
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
    public String _flgbanca;
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
    public double _nocfap;
    public String _condoc;
    public String _idfile;
    public String _mage;
    public String _oldcodfis;
    public String _ocodfis;
    public java.sql.Timestamp _dtimport;
    public String _txtope;
    public double _errore;
    public double _nerrori;
    public double _nerraua;
    public double eProg;
    public String _codstanas;
    public String _codstares;
    public String _siglacit;
    public String _siglasta;
    public String _codcit;
    public String _merr;
    public String _oldmac;
    public double _aggcli;
    public String _tiperr;
    public String _intertip;
    public String _listerr;
    public String _tipope;
    public String _rapporto;
    public String _priga;
    public String w_codmage;
    public String stringaflagrap2;
    public String _oldidb;
    public String _flagrap2;
    public String _idreg;
    public String _idb2;
    public String _citdip;
    public String _cabdip;
    public String _provdip;
    public double _id;
    public String _filename;
    public String _dipid;
    public String _nfile;
    public String _filen;
    public double _nerrage;
    public double _errage;
    public double _contage;
    public String _anno;
    public double _errorig;
    public String _ageerr01;
    public String _ageerr02;
    public String _ageerr03;
    public String _ageerr04;
    public String _ageerr05;
    public String _ageerr06;
    public String _ageerr07;
    public String _ageerr08;
    public String _ageerr09;
    public String _colonna1;
    public String _colonna2;
    public String _colonna3;
    public String _colonna4;
    public String _colonna5;
    public String _colonna6;
    public String _flgact;
    public String w_xMARESSDEF;
    public String _flgaua;
    public String _datamin;
    public java.sql.Date _datadmin;
    public String _connesdoc;
    public java.sql.Date _lastdate;
    public String _campo1;
    public String _campo2;
    public String _wupos;
    public double _omaxid;
    public double _omaxpg;
    public double _omaxim;
    public double _pmaxim;
    public double _wmaxpg;
    public double _opxmax;
    public double _contarig;
    public String _wuposonly;
    public double _tottrans;
    public double _totmovi;
    public double _erraua;
    public double _ggscad;
    public double _scarti;
    public double _cpers;
    public double _coper;
    public double _idau;
    public String _gMsgProc;
    public String _pathfile;
    public String _pathdoc;
    public String _filescarti;
    public String xFLGSAE;
    public String gID;
    public String _nazrildoc;
    public String _dipcod;
    public java.sql.Date _limite20;
    public String w_idmage;
    public String w_xMAFLGRAP;
    public String w_xMAFLGBON;
    public String w_xMAFLGCKR;
    public String w_xMAFLGASR;
    public String w_xMADIPSTD;
    public String w_xMAFLGCHKDAT;
    public String w_xMANAIDWU;
    public String czipfile;
    public String cpercorsozip;
    public String cdirectoryfile;
    public String buffernomefile;
    public String nomefileorg;
    public double _priorita;
    public String w_CODFISC;
    public java.sql.Date w_DATANASC;
    public String w_NASCOMUN;
    public String w_NASSTATO;
    public String w_COGNOME;
    public String w_RAGSOC;
    public String w_NOME;
    public String w_SESSO;
    public double riga_letta;
    public double foglio;
    public String _err01;
    public String _err02;
    public String _err03;
    public String _err04;
    public String _err05;
    public String _err06;
    public String _err07;
    public String _err08;
    public String _err09;
    public String _err10;
    public String _err11;
    public String _err12;
    public String _err13;
    public String _err14;
    public String _err15;
    public String _err16;
    public String _err17;
    public String _err18;
    public String _err19;
    public String _err20;
    public String _err21;
    public String _err22;
    public String _err23;
    public String _err24;
    public String _err25;
    public String _err26;
    public String _err27;
    public String _err28;
    public String _err29;
    public String _err30;
    public String _err31;
    public String _err32;
    public String _err33;
    public String _err34;
    public String _err35;
    public String _err36;
    public String _err37;
    public String _err38;
    public String _err39;
    public String _err40;
    public String _err41;
    public String _aua01;
    public String _aua02;
    public String _aua03;
    public String _aua04;
    public String _aua05;
    public String _aua06;
    public String _aua07;
    public String _aua08;
    public String _aua09;
    public String _aua10;
    public String _faua1;
    public String _faua2;
    public String _faua3;
    public String _faua4;
    public String gPathApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public String gUrlApp;
    public String w_tipodest;
    public String w_delprec;
    public String pAUA;
    public String pModo;
    public String pTipo;
    public String pErrAUI;
    public String pImpAna;
    public String pNoDG;
    public String aaaaaaaa_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipodest","w_tipodest");
      }        
      w_tipodest = source.GetParameter("w_tipodest","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_delprec","w_delprec");
      }        
      w_delprec = source.GetParameter("w_delprec","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pAUA","pAUA");
      }        
      pAUA = source.GetParameter("pAUA","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pModo","pModo");
      }        
      pModo = source.GetParameter("pModo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pErrAUI","pErrAUI");
      }        
      pErrAUI = source.GetParameter("pErrAUI","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pImpAna","pImpAna");
      }        
      pImpAna = source.GetParameter("pImpAna","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pNoDG","pNoDG");
      }        
      pNoDG = source.GetParameter("pNoDG","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_imp_dati_rtra";
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
  private void ExecuteRoutine(ServletStatus status) throws IOException {
    arrt_imp_dati_rtraR Rcalled;
    Rcalled = new arrt_imp_dati_rtraR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaaaaaa_retval = Rcalled.Run(status.w_tipodest,status.w_delprec,status.pAUA,status.pModo,status.pTipo,status.pErrAUI,status.pImpAna,status.pNoDG);
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
    return new arrt_imp_dati_rtraR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_imp_dati_rtraR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_imp_dati_rtra"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.aaaaaaaa_retval))+"");
    status.out.println(
     " -->" +
    "");
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void Begin(ServletStatus status) throws IOException {
    if ( ! (CPLib.Empty(status.m_cGlobalsToRead))) {
      JSGlobals(status);
    } else if (CPLib.Empty(status.m_cBrowseName)) {
      ExecuteRoutine(status);
    } else {
      JSResultSet(status);
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
