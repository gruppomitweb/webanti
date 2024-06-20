import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_estrai_all1 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*5fce2b6f*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gPathApp;
    public String gPathDoc;
    public String gIntemediario;
    public String gTipInter;
    public String gUrlApp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public String w_codcab;
    public String w_cabcod;
    public String w_desccit;
    public String w_citdesc;
    public String w_provin;
    public String w_provind;
    public String w_coddipe;
    public double w_agente;
    public String _note;
    public double _rownum;
    public String fhand;
    public String _nomefile;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public double nTotRec;
    public double nTotReg;
    public double nNumRec;
    public double _avanza;
    public String _codrif;
    public String w_cdadata;
    public String w_c_adata;
    public String w_cdadata_rap;
    public String w_c_adata_rap;
    public String w_cdareg_rap;
    public String w_c_areg_rap;
    public double _ctotale;
    public double _conta;
    public double _max;
    public double _min;
    public double _top;
    public double _bottom;
    public double _cicli;
    public double _contacilci;
    public String _flagrap;
    public double _ciclo;
    public String _ramate;
    public String _numsto;
    public double _oldrighe;
    public double _continua;
    public String _oldrap;
    public String _idereg;
    public String xStato;
    public String _tiprec;
    public String _raeatc;
    public String oldfolder;
    public String _tipoag;
    public String _datage;
    public String _numticket;
    public String w_cdareg;
    public String w_c_areg;
    public String z_desccit;
    public String z_codcab;
    public String z_provin;
    public String z_coddipe;
    public String _idb;
    public String _connescli;
    public String _connaltro;
    public java.sql.Date _datastorico;
    public String _statooperazione;
    public java.sql.Date _datarettifica;
    public String _tipoperazione;
    public String _rapporto_check;
    public String _codcli_check;
    public String _testo;
    public String w_ragben;
    public boolean _mlientiope;
    public boolean _clientiope;
    public boolean _mogopebo;
    public boolean _sogopebo;
    public boolean _meneficope;
    public boolean _beneficope;
    public boolean _merzistiope;
    public boolean _terzistiope;
    public boolean _mlientifrz;
    public boolean _clientifrz;
    public boolean _mogopefbo;
    public boolean _sogopefbo;
    public boolean _meneficfrz;
    public boolean _beneficfrz;
    public boolean _merzistifrz;
    public boolean _terzistifrz;
    public String pCodDip;
    public String pCodCabFil;
    public String pCodCab;
    public String pDesCit;
    public String pProv;
    public java.sql.Date w_DaData;
    public java.sql.Date w_AData;
    public String w_codage;
    public String w_codcli;
    public String w_rapporto;
    public String w_flgope;
    public String w_flgrap;
    public String w_flgfrz;
    public String w_flgordine;
    public String w_stoper;
    public String w_tipout;
    public String w_rappAttivSel;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_DaData","w_DaData");
      }        
      w_DaData = source.GetParameter("w_DaData",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_AData","w_AData");
      }        
      w_AData = source.GetParameter("w_AData",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codage","w_codage");
      }        
      w_codage = source.GetParameter("w_codage","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codcli","w_codcli");
      }        
      w_codcli = source.GetParameter("w_codcli","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rapporto","w_rapporto");
      }        
      w_rapporto = source.GetParameter("w_rapporto","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgope","w_flgope");
      }        
      w_flgope = source.GetParameter("w_flgope","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgrap","w_flgrap");
      }        
      w_flgrap = source.GetParameter("w_flgrap","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgfrz","w_flgfrz");
      }        
      w_flgfrz = source.GetParameter("w_flgfrz","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgordine","w_flgordine");
      }        
      w_flgordine = source.GetParameter("w_flgordine","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_stoper","w_stoper");
      }        
      w_stoper = source.GetParameter("w_stoper","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipout","w_tipout");
      }        
      w_tipout = source.GetParameter("w_tipout","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rappAttivSel","w_rappAttivSel");
      }        
      w_rappAttivSel = source.GetParameter("w_rappAttivSel","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_estrai_all1";
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaData,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_DaData',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AData,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_AData',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codage,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_codage',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codcli,"C",16,0)+",'C');");
    status.out.println("l_oWv.setValue('w_codcli',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rapporto,"C",25,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rapporto',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgope,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_flgope',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgrap,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_flgrap',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgfrz,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_flgfrz',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgordine,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_flgordine',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_stoper,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_stoper',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipout,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tipout',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rappAttivSel,"C",0,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rappAttivSel',l_cV);");
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
    arrt_estrai_all1R Rcalled;
    Rcalled = new arrt_estrai_all1R(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.w_DaData,status.w_AData,status.w_codage,status.w_codcli,status.w_rapporto,status.w_flgope,status.w_flgrap,status.w_flgfrz,status.w_flgordine,status.w_stoper,status.w_tipout,status.w_rappAttivSel);
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
    return new arrt_estrai_all1R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_estrai_all1R Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.w_DaData,status.w_AData,status.w_codage,status.w_codcli,status.w_rapporto,status.w_flgope,status.w_flgrap,status.w_flgfrz,status.w_flgordine,status.w_stoper,status.w_tipout,status.w_rappAttivSel)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_estrai_all1"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
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
      arrt_estrai_all1R Rcalled;
      Rcalled = new arrt_estrai_all1R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_estrai_all1");
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
