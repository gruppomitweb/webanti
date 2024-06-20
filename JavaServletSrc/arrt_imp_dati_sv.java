import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_imp_dati_sv extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*622337e*!";
  public class ServletStatus extends SPRoutineServletStatus {
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
    public String _flganag;
    public String _oldcf;
    public String _oldcog;
    public String _oldnom;
    public String _oldrgs;
    public String _oldncm;
    public String _oldnst;
    public java.sql.Date _oldndt;
    public String _oldnpv;
    public String _oldnsx;
    public double _oldncf;
    public String cProgSto;
    public String xRiga1;
    public String xRiga2;
    public String xRiga3;
    public String xRiga4;
    public String xRiga5;
    public String xRiga6;
    public String cNewProg;
    public String _tipooprap;
    public java.sql.Date _oldreg;
    public String ciidbase;
    public java.sql.Date cidataini;
    public java.sql.Date cidatafine;
    public String cicodinter;
    public String cinumprog;
    public String citiporap;
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
    public String gPathApp;
    public String gAzienda;
    public String gUrlApp;
    public String gMsgImp;
    public String gMsgProc;
    public String gFlgRet;
    public String gTipInter;
    public String gPathDoc;
    public double _inviato;
    public String w_tipodest;
    public String w_chkaui;
    public String w_imperr;
    public String w_flgaggfam;
    public String w_flgimposv;
    public String w_creamo;
    public String w_norifimp;
    public String w_flgforzaagg;
    public double aaaaaaaa_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipodest","w_tipodest");
      }        
      w_tipodest = source.GetParameter("w_tipodest","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_chkaui","w_chkaui");
      }        
      w_chkaui = source.GetParameter("w_chkaui","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_imperr","w_imperr");
      }        
      w_imperr = source.GetParameter("w_imperr","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgaggfam","w_flgaggfam");
      }        
      w_flgaggfam = source.GetParameter("w_flgaggfam","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgimposv","w_flgimposv");
      }        
      w_flgimposv = source.GetParameter("w_flgimposv","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_creamo","w_creamo");
      }        
      w_creamo = source.GetParameter("w_creamo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_norifimp","w_norifimp");
      }        
      w_norifimp = source.GetParameter("w_norifimp","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgforzaagg","w_flgforzaagg");
      }        
      w_flgforzaagg = source.GetParameter("w_flgforzaagg","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_imp_dati_sv";
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
    return false;
  }
  private void ExecuteRoutine(ServletStatus status) throws IOException {
    arrt_imp_dati_svR Rcalled;
    Rcalled = new arrt_imp_dati_svR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaaaaaa_retval = Rcalled.Run(status.w_tipodest,status.w_chkaui,status.w_imperr,status.w_flgaggfam,status.w_flgimposv,status.w_creamo,status.w_norifimp,status.w_flgforzaagg);
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
    return new arrt_imp_dati_svR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_imp_dati_svR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_imp_dati_sv"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
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
