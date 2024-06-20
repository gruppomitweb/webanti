import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_imp_dati_wubs_errori extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ab079df*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String _numprog;
    public String nomeesito;
    public String nomefilexls;
    public String filexls;
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
    public String _legrap;
    public String _idb2;
    public String _errore;
    public double nResult;
    public double _sogliamax;
    public java.sql.Date _limite20;
    public double _limitesoglia;
    public String _validstato;
    public double _nocf;
    public String w_CODFISC;
    public java.sql.Date w_DATANASC;
    public String w_NASCOMUN;
    public String w_NASSTATO;
    public String w_COGNOME;
    public String w_RAGSOC;
    public String w_NOME;
    public String w_SESSO;
    public double righe;
    public String filenome;
    public String cell01;
    public String cell02;
    public String cell03;
    public String cell04;
    public String cell05;
    public String cell06;
    public String cell07;
    public String cell08;
    public double cell09;
    public double cell09c;
    public String cell10;
    public double cell11;
    public double cell11c;
    public String cell12;
    public String cell13;
    public String cell14;
    public String cell15;
    public String cell16;
    public String cell17;
    public String cell18;
    public String cell19;
    public String cell20;
    public String cell21;
    public String cell22;
    public String cell23;
    public String cell24;
    public String cell25;
    public String cell26;
    public String cell27;
    public String cell28;
    public String cell29;
    public String cell30;
    public String cell31;
    public String cell32;
    public String cell33;
    public String cell34;
    public String cell35;
    public String cell36;
    public String cell37;
    public String cell38;
    public String cell39;
    public String cell40;
    public String cell41;
    public String _rapporto;
    public double _contadel;
    public String _ragsoc;
    public String gPathApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public String gUrlApp;
    public String w_tipodest;
    public double a_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipodest","w_tipodest");
      }        
      w_tipodest = source.GetParameter("w_tipodest","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_imp_dati_wubs_errori";
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
    arrt_imp_dati_wubs_erroriR Rcalled;
    Rcalled = new arrt_imp_dati_wubs_erroriR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.a_retval = Rcalled.Run(status.w_tipodest);
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
    return new arrt_imp_dati_wubs_erroriR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_imp_dati_wubs_erroriR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_imp_dati_wubs_errori"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.a_retval))+"");
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
