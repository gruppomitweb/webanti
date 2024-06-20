import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_imp_dati_mc extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*47b0cfb3*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipodest;
    public String w_tipodest;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impzip;
    public double w_impzip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_annorif;
    public double w_annorif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_chkaui;
    public String w_chkaui;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_imperr;
    public String w_imperr;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_creamo;
    public String w_creamo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_fscarti;
    public double w_fscarti;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgaggfam;
    public String w_flgaggfam;
    public double _z;
    public String fhand;
    public String ohand;
    public String zhand;
    public String xhand;
    public String shand;
    public String riga;
    public String xConnes;
    public String _tdest;
    public String xCF;
    public String xSOCTCon;
    public String xSOCTCF;
    public String xCodCab;
    public String xCitta;
    public String cCliProg;
    public String cInfProg1;
    public String cInfProg2;
    public String cOpeProg1;
    public String cOpeProg2;
    public String xSesso;
    public String xRapporto;
    public String xCAB;
    public String xPrv;
    public String xDIP;
    public String xDIPx;
    public String cCli1;
    public String xIDB;
    public String xData;
    public String xDatF;
    public double cNumNew;
    public double cNumMod;
    public double cNumInv;
    public String cFlagLire;
    public String cFlagCont;
    public String cFlagFraz;
    public double cMaxRow;
    public String cIdCau;
    public double xCFE;
    public double conta;
    public double _esito;
    public String cSNAS;
    public String cCNAS;
    public String _unicode;
    public double _salta;
    public double nProgImp;
    public double nProgImp2;
    public double nProgSto;
    public String _idbase;
    public String _codinter;
    public String _citinter;
    public String _cabinter;
    public String _prvinter;
    public String _intercod;
    public String _intercit;
    public String _intercab;
    public String _interprv;
    public String _tipper;
    public String _benrag;
    public String _bensta;
    public String _bencta;
    public String _bencab;
    public String _benprv;
    public String _benind;
    public String _bencap;
    public String _flgmodi;
    public String _conadd;
    public java.sql.Date _datareg;
    public java.sql.Date _dataope;
    public java.sql.Date _datvarage;
    public double _flgdataim;
    public double _chkerr;
    public String _rifimp;
    public String _oldidb;
    public String stringaflagrap2;
    public String _statoreg;
    public java.sql.Date _datarett;
    public String _flagrap2;
    public String _idreg;
    public double _findsub;
    public double _opeerr;
    public double _frzerr;
    public double _opxerr;
    public double _soxerr;
    public String _numprog;
    public String _colleg;
    public String _frapcli;
    public String _tiporap;
    public String _czip;
    public String cNomeFileZip;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String _file1;
    public String _file2;
    public String _descerr;
    public double _oldest;
    public double _newest;
    public String _idb2;
    public double _totin;
    public double _totout;
    public String _iccab;
    public String _iccit;
    public String _icprv;
    public String _icsta;
    public String _icrag;
    public String _flgvali;
    public String _oldcf;
    public String ciidbase;
    public java.sql.Date cidataini;
    public java.sql.Date cidatafine;
    public String cicodinter;
    public String cinumprog;
    public String citiporap;
    public String _tipoimp;
    public double _sposta;
    public String czipfile;
    public String cpercorsozip;
    public String cdirectoryfile;
    public String buffernomefile;
    public String nomefileimport;
    public double _priorita;
    public String column01;
    public String column02;
    public String column03;
    public String column04;
    public String column05;
    public String column06;
    public String column07;
    public String column08;
    public String column09;
    public String column10;
    public String column11;
    public String column12;
    public String column13;
    public String column14;
    public String column15;
    public String column16;
    public String column17;
    public String column18;
    public String column19;
    public String column20;
    public String column21;
    public String column22;
    public String column23;
    public String column24;
    public String column25;
    public String column26;
    public String column27;
    public String column28;
    public String column29;
    public String column30;
    public String column31;
    public String column32;
    public String column33;
    public String column34;
    public String column35;
    public String column36;
    public String column37;
    public String column38;
    public String column39;
    public String column40;
    public String column41;
    public String column42;
    public String column43;
    public String column44;
    public String column45;
    public String column46;
    public String column47;
    public String column48;
    public String column49;
    public String column50;
    public String column51;
    public String column52;
    public String column53;
    public String column54;
    public String column55;
    public String column56;
    public String column57;
    public String column58;
    public String column59;
    public String column60;
    public String column61;
    public String column62;
    public String column63;
    public String column64;
    public String column65;
    public String column66;
    public String column67;
    public String column68;
    public String column69;
    public String gPathApp;
    public String gAzienda;
    public String gUrlApp;
    public String gMsgImp;
    public String gMsgProc;
    public String gFlgRet;
    public String gTipInter;
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
      m_bpassedw_annorif = source.Has("w_annorif");
      if (m_bpassedw_annorif) {
        w_annorif = source.GetParameter("w_annorif",source.GetParameter("annorif",0));
      } else {
        if (source.IsForwarded()) {
          w_annorif = source.GetCaller().GetNumber("annorif","N",4,0);
          m_bpassedw_annorif = true;
        } else {
          w_annorif = source.GetParameter("annorif",source.GetParameter("w_annorif",0));
        }
      }
      m_bpassedw_chkaui = source.Has("w_chkaui");
      if (m_bpassedw_chkaui) {
        w_chkaui = source.GetParameter("w_chkaui",source.GetParameter("chkaui",""));
      } else {
        if (source.IsForwarded()) {
          w_chkaui = source.GetCaller().GetString("chkaui","C",1,0);
          m_bpassedw_chkaui = true;
        } else {
          w_chkaui = source.GetParameter("chkaui",source.GetParameter("w_chkaui",""));
        }
      }
      m_bpassedw_imperr = source.Has("w_imperr");
      if (m_bpassedw_imperr) {
        w_imperr = source.GetParameter("w_imperr",source.GetParameter("imperr",""));
      } else {
        if (source.IsForwarded()) {
          w_imperr = source.GetCaller().GetString("imperr","C",1,0);
          m_bpassedw_imperr = true;
        } else {
          w_imperr = source.GetParameter("imperr",source.GetParameter("w_imperr",""));
        }
      }
      m_bpassedw_creamo = source.Has("w_creamo");
      if (m_bpassedw_creamo) {
        w_creamo = source.GetParameter("w_creamo",source.GetParameter("creamo",""));
      } else {
        if (source.IsForwarded()) {
          w_creamo = source.GetCaller().GetString("creamo","C",1,0);
          m_bpassedw_creamo = true;
        } else {
          w_creamo = source.GetParameter("creamo",source.GetParameter("w_creamo",""));
        }
      }
      m_bpassedw_fscarti = source.Has("w_fscarti");
      if (m_bpassedw_fscarti) {
        w_fscarti = source.GetParameter("w_fscarti",source.GetParameter("fscarti",0));
      } else {
        if (source.IsForwarded()) {
          w_fscarti = source.GetCaller().GetNumber("fscarti","N",1,0);
          m_bpassedw_fscarti = true;
        } else {
          w_fscarti = source.GetParameter("fscarti",source.GetParameter("w_fscarti",0));
        }
      }
      m_bpassedw_flgaggfam = source.Has("w_flgaggfam");
      if (m_bpassedw_flgaggfam) {
        w_flgaggfam = source.GetParameter("w_flgaggfam",source.GetParameter("flgaggfam",""));
      } else {
        if (source.IsForwarded()) {
          w_flgaggfam = source.GetCaller().GetString("flgaggfam","C",1,0);
          m_bpassedw_flgaggfam = true;
        } else {
          w_flgaggfam = source.GetParameter("flgaggfam",source.GetParameter("w_flgaggfam",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_imp_dati_mc";
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
    return  ! (status.m_bpassedw_flgaggfam) ||  ! (status.m_bpassedw_fscarti) ||  ! (status.m_bpassedw_creamo) ||  ! (status.m_bpassedw_imperr) ||  ! (status.m_bpassedw_chkaui) ||  ! (status.m_bpassedw_annorif) ||  ! (status.m_bpassedw_impzip) ||  ! (status.m_bpassedw_tipodest);
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
    if ( ! (status.m_bpassedw_annorif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_annorif',"+SPLib.ToJSValue(status.w_annorif,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_annorif,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_annorif',l_cV);");
    if ( ! (status.m_bpassedw_chkaui)) {
      status.out.println("l_cV=WtA(l_oWnd('w_chkaui',"+SPLib.ToJSValue(status.w_chkaui,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_chkaui,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_chkaui',l_cV);");
    if ( ! (status.m_bpassedw_imperr)) {
      status.out.println("l_cV=WtA(l_oWnd('w_imperr',"+SPLib.ToJSValue(status.w_imperr,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_imperr,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_imperr',l_cV);");
    if ( ! (status.m_bpassedw_creamo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_creamo',"+SPLib.ToJSValue(status.w_creamo,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_creamo,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_creamo',l_cV);");
    if ( ! (status.m_bpassedw_fscarti)) {
      status.out.println("l_cV=WtA(l_oWnd('w_fscarti',"+SPLib.ToJSValue(status.w_fscarti,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_fscarti,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_fscarti',l_cV);");
    if ( ! (status.m_bpassedw_flgaggfam)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgaggfam',"+SPLib.ToJSValue(status.w_flgaggfam,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgaggfam,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgaggfam',l_cV);");
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
    arrt_imp_dati_mcR Rcalled;
    Rcalled = new arrt_imp_dati_mcR(status.context,status);
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
    return new arrt_imp_dati_mcR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_imp_dati_mcR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_imp_dati_mc"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_tipodest="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipodest),"?",0,0)+"");
        status.out.println("js:w_impzip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impzip),"?",0,0)+"");
        status.out.println("js:w_annorif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_annorif),"?",0,0)+"");
        status.out.println("js:w_chkaui="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_chkaui),"?",0,0)+"");
        status.out.println("js:w_imperr="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_imperr),"?",0,0)+"");
        status.out.println("js:w_creamo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_creamo),"?",0,0)+"");
        status.out.println("js:w_fscarti="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_fscarti),"?",0,0)+"");
        status.out.println("js:w_flgaggfam="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgaggfam),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_annorif,null)) {");
        status.out.println("window[f].w_annorif="+SPLib.ToJSValue(status.w_annorif,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_chkaui,null)) {");
        status.out.println("window[f].w_chkaui="+SPLib.ToJSValue(status.w_chkaui,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_imperr,null)) {");
        status.out.println("window[f].w_imperr="+SPLib.ToJSValue(status.w_imperr,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_creamo,null)) {");
        status.out.println("window[f].w_creamo="+SPLib.ToJSValue(status.w_creamo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_fscarti,null)) {");
        status.out.println("window[f].w_fscarti="+SPLib.ToJSValue(status.w_fscarti,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgaggfam,null)) {");
        status.out.println("window[f].w_flgaggfam="+SPLib.ToJSValue(status.w_flgaggfam,"C",0,0)+";");
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
      arrt_imp_dati_mcR Rcalled;
      Rcalled = new arrt_imp_dati_mcR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_imp_dati_mc");
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
