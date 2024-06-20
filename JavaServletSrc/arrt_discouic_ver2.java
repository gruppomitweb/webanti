import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_discouic_ver2 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*20ba6d46*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaDatOpe;
    public java.sql.Date w_DaDatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ADatOpe;
    public java.sql.Date w_ADatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipocr;
    public String w_tipocr;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codcr;
    public String w_codcr;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datinv;
    public java.sql.Date w_datinv;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_numinv;
    public double w_numinv;
    public String gPathApp;
    public String gPathDoc;
    public String gAzienda;
    public String gTipInter;
    public String gIntemediario;
    public String gMsgImp;
    public String gMsgProc;
    public String _tipcentro;
    public String _codcentro;
    public String _settsint;
    public double _appconta;
    public double _totconta;
    public double _conta;
    public double _contaw;
    public double _contaop;
    public String _coddip;
    public String _abicab;
    public String _cabdip;
    public String _paesecli;
    public String _cabcli;
    public String _paesecp;
    public String _cabcp;
    public String _paeseicp;
    public String _cabicp;
    public double _operaz;
    public double _ocont;
    public String _testo;
    public String _txtappo;
    public String _file;
    public String cdadata;
    public String c_adata;
    public java.sql.Date w_dadata;
    public java.sql.Date w_adata;
    public String _mesi;
    public String _mese;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public String cProg;
    public String fhand;
    public double _nita;
    public double _next;
    public double _nalt;
    public String _datafine;
    public String _txttot;
    public double _tope;
    public double _tcon;
    public String _dataprod;
    public String _oraprod;
    public String _cDataOra;
    public double _totimp;
    public double _totcon;
    public double _max;
    public double _min;
    public double _tot;
    public double _mono;
    public double _cicli;
    public double _contacilci;
    public double _bottom;
    public double _top;
    public String _cabint;
    public String _ita1;
    public String _ita2;
    public String _ext1;
    public String _ext2;
    public String _alt1;
    public String _alt2;
    public String _sara;
    public double _nosara;
    public double _pqtotale;
    public String _datini;
    public String _datfin;
    public java.sql.Date _ddatini;
    public java.sql.Date _ddatfin;
    public java.sql.Date _dataoggi;
    public String _cdataoggi;
    public double _contarow;
    public String _oldmsg;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_DaDatOpe = source.Has("w_DaDatOpe");
      if (m_bpassedw_DaDatOpe) {
        w_DaDatOpe = source.GetParameter("w_DaDatOpe",source.GetParameter("DaDatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaDatOpe = source.GetCaller().GetDate("DaDatOpe","D",8,0);
          m_bpassedw_DaDatOpe = true;
        } else {
          w_DaDatOpe = source.GetParameter("DaDatOpe",source.GetParameter("w_DaDatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_ADatOpe = source.Has("w_ADatOpe");
      if (m_bpassedw_ADatOpe) {
        w_ADatOpe = source.GetParameter("w_ADatOpe",source.GetParameter("ADatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_ADatOpe = source.GetCaller().GetDate("ADatOpe","D",8,0);
          m_bpassedw_ADatOpe = true;
        } else {
          w_ADatOpe = source.GetParameter("ADatOpe",source.GetParameter("w_ADatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_tipocr = source.Has("w_tipocr");
      if (m_bpassedw_tipocr) {
        w_tipocr = source.GetParameter("w_tipocr",source.GetParameter("tipocr",""));
      } else {
        if (source.IsForwarded()) {
          w_tipocr = source.GetCaller().GetString("tipocr","C",2,0);
          m_bpassedw_tipocr = true;
        } else {
          w_tipocr = source.GetParameter("tipocr",source.GetParameter("w_tipocr",""));
        }
      }
      m_bpassedw_codcr = source.Has("w_codcr");
      if (m_bpassedw_codcr) {
        w_codcr = source.GetParameter("w_codcr",source.GetParameter("codcr",""));
      } else {
        if (source.IsForwarded()) {
          w_codcr = source.GetCaller().GetString("codcr","C",11,0);
          m_bpassedw_codcr = true;
        } else {
          w_codcr = source.GetParameter("codcr",source.GetParameter("w_codcr",""));
        }
      }
      m_bpassedw_datinv = source.Has("w_datinv");
      if (m_bpassedw_datinv) {
        w_datinv = source.GetParameter("w_datinv",source.GetParameter("datinv",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datinv = source.GetCaller().GetDate("datinv","D",8,0);
          m_bpassedw_datinv = true;
        } else {
          w_datinv = source.GetParameter("datinv",source.GetParameter("w_datinv",CPLib.NullDate()));
        }
      }
      m_bpassedw_numinv = source.Has("w_numinv");
      if (m_bpassedw_numinv) {
        w_numinv = source.GetParameter("w_numinv",source.GetParameter("numinv",0));
      } else {
        if (source.IsForwarded()) {
          w_numinv = source.GetCaller().GetNumber("numinv","N",10,0);
          m_bpassedw_numinv = true;
        } else {
          w_numinv = source.GetParameter("numinv",source.GetParameter("w_numinv",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_discouic_ver2";
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
    return  ! (status.m_bpassedw_numinv) ||  ! (status.m_bpassedw_datinv) ||  ! (status.m_bpassedw_codcr) ||  ! (status.m_bpassedw_tipocr) ||  ! (status.m_bpassedw_ADatOpe) ||  ! (status.m_bpassedw_DaDatOpe);
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
    if ( ! (status.m_bpassedw_DaDatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaDatOpe',"+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaDatOpe',l_cV);");
    if ( ! (status.m_bpassedw_ADatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_ADatOpe',"+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_ADatOpe',l_cV);");
    if ( ! (status.m_bpassedw_tipocr)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipocr',"+SPLib.ToJSValue(status.w_tipocr,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipocr,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipocr',l_cV);");
    if ( ! (status.m_bpassedw_codcr)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codcr',"+SPLib.ToJSValue(status.w_codcr,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codcr,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codcr',l_cV);");
    if ( ! (status.m_bpassedw_datinv)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datinv',"+SPLib.ToJSValue(status.w_datinv,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datinv,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datinv',l_cV);");
    if ( ! (status.m_bpassedw_numinv)) {
      status.out.println("l_cV=WtA(l_oWnd('w_numinv',"+SPLib.ToJSValue(status.w_numinv,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_numinv,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_numinv',l_cV);");
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
    arrt_discouic_ver2R Rcalled;
    Rcalled = new arrt_discouic_ver2R(status.context,status);
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
    return new arrt_discouic_ver2R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_discouic_ver2R Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_discouic_ver2"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_DaDatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaDatOpe),"?",0,0)+"");
        status.out.println("js:w_ADatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ADatOpe),"?",0,0)+"");
        status.out.println("js:w_tipocr="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipocr),"?",0,0)+"");
        status.out.println("js:w_codcr="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codcr),"?",0,0)+"");
        status.out.println("js:w_datinv="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datinv),"?",0,0)+"");
        status.out.println("js:w_numinv="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_numinv),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_DaDatOpe,null)) {");
        status.out.println(" window[f].w_DaDatOpe.setTime(("+SPLib.ToJSValue(status.w_DaDatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ADatOpe,null)) {");
        status.out.println(" window[f].w_ADatOpe.setTime(("+SPLib.ToJSValue(status.w_ADatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipocr,null)) {");
        status.out.println("window[f].w_tipocr="+SPLib.ToJSValue(status.w_tipocr,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codcr,null)) {");
        status.out.println("window[f].w_codcr="+SPLib.ToJSValue(status.w_codcr,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datinv,null)) {");
        status.out.println(" window[f].w_datinv.setTime(("+SPLib.ToJSValue(status.w_datinv,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_numinv,null)) {");
        status.out.println("window[f].w_numinv="+SPLib.ToJSValue(status.w_numinv,"N",0,0)+";");
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
      arrt_discouic_ver2R Rcalled;
      Rcalled = new arrt_discouic_ver2R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_discouic_ver2");
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
