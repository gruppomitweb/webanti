import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_discouic_chk extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*41b554ba*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gPathApp;
    public String gTipInter;
    public String gIntemediario;
    public String gAzienda;
    public String gDescAzi;
    public String gMsgImp;
    public String gMsgProc;
    public String _tipcentro;
    public String _codcentro;
    public String _settsint;
    public String _ramogrp;
    public String _sotgru;
    public double _appconta;
    public double _totconta;
    public double _conta;
    public String _codcab;
    public String _provin;
    public String _paese;
    public String _testo;
    public String _file;
    public String cdadata;
    public String c_adata;
    public java.sql.Date w_dadata;
    public java.sql.Date w_adata;
    public String _mesi;
    public String _mese;
    public String _codcab2;
    public String _provin2;
    public String _perpaese;
    public String _percab;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public String cProg;
    public String fhand;
    public double _max;
    public double _min;
    public double _tot;
    public double _mono;
    public double _cicli;
    public double _contacilci;
    public double _bottom;
    public double _top;
    public String _stato;
    public String _errore;
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
    public double _contaop;
    public String _datini;
    public String _datfin;
    public java.sql.Date _ddatini;
    public java.sql.Date _ddatfin;
    public java.sql.Date _dataoggi;
    public String _cdataoggi;
    public double _contarow;
    public String _oldmsg;
    public String _sesso;
    public double _cope;
    public String pTipo;
    public java.sql.Date w_DaDatOpe;
    public java.sql.Date w_ADatOpe;
    public String w_tipocr;
    public String w_codcr;
    public String w_flgfrazionate;
    public double aaaaaa_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_DaDatOpe","w_DaDatOpe");
      }        
      w_DaDatOpe = source.GetParameter("w_DaDatOpe",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ADatOpe","w_ADatOpe");
      }        
      w_ADatOpe = source.GetParameter("w_ADatOpe",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipocr","w_tipocr");
      }        
      w_tipocr = source.GetParameter("w_tipocr","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codcr","w_codcr");
      }        
      w_codcr = source.GetParameter("w_codcr","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgfrazionate","w_flgfrazionate");
      }        
      w_flgfrazionate = source.GetParameter("w_flgfrazionate","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_discouic_chk";
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
    arrt_discouic_chkR Rcalled;
    Rcalled = new arrt_discouic_chkR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaaaa_retval = Rcalled.Run(status.pTipo,status.w_DaDatOpe,status.w_ADatOpe,status.w_tipocr,status.w_codcr,status.w_flgfrazionate);
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
    return new arrt_discouic_chkR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_discouic_chkR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_discouic_chk"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.aaaaaa_retval))+"");
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
