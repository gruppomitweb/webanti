import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_estrai_oper extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*212403a9*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dadata;
    public java.sql.Date w_dadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_adata;
    public java.sql.Date w_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cdadata;
    public String w_cdadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_adata;
    public String w_c_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cCODFISC;
    public String w_cCODFISC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cDIP;
    public String w_cDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cMTCN;
    public String w_cMTCN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdesdip;
    public String w_xdesdip;
    public String gPathApp;
    public String gUrlApp;
    public String _dadata;
    public String _a_data;
    public String prova;
    public String foglio;
    public String nomefile;
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
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_dadata = source.Has("w_dadata");
      if (m_bpassedw_dadata) {
        w_dadata = source.GetParameter("w_dadata",source.GetParameter("dadata",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_dadata = source.GetCaller().GetDate("dadata","D",8,0);
          m_bpassedw_dadata = true;
        } else {
          w_dadata = source.GetParameter("dadata",source.GetParameter("w_dadata",CPLib.NullDate()));
        }
      }
      m_bpassedw_adata = source.Has("w_adata");
      if (m_bpassedw_adata) {
        w_adata = source.GetParameter("w_adata",source.GetParameter("adata",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_adata = source.GetCaller().GetDate("adata","D",8,0);
          m_bpassedw_adata = true;
        } else {
          w_adata = source.GetParameter("adata",source.GetParameter("w_adata",CPLib.NullDate()));
        }
      }
      m_bpassedw_cdadata = source.Has("w_cdadata");
      if (m_bpassedw_cdadata) {
        w_cdadata = source.GetParameter("w_cdadata",source.GetParameter("cdadata",""));
      } else {
        if (source.IsForwarded()) {
          w_cdadata = source.GetCaller().GetString("cdadata","C",8,0);
          m_bpassedw_cdadata = true;
        } else {
          w_cdadata = source.GetParameter("cdadata",source.GetParameter("w_cdadata",""));
        }
      }
      m_bpassedw_c_adata = source.Has("w_c_adata");
      if (m_bpassedw_c_adata) {
        w_c_adata = source.GetParameter("w_c_adata",source.GetParameter("c_adata",""));
      } else {
        if (source.IsForwarded()) {
          w_c_adata = source.GetCaller().GetString("c_adata","C",8,0);
          m_bpassedw_c_adata = true;
        } else {
          w_c_adata = source.GetParameter("c_adata",source.GetParameter("w_c_adata",""));
        }
      }
      m_bpassedw_cCODFISC = source.Has("w_cCODFISC");
      if (m_bpassedw_cCODFISC) {
        w_cCODFISC = source.GetParameter("w_cCODFISC",source.GetParameter("cCODFISC",""));
      } else {
        if (source.IsForwarded()) {
          w_cCODFISC = source.GetCaller().GetString("cCODFISC","C",16,0);
          m_bpassedw_cCODFISC = true;
        } else {
          w_cCODFISC = source.GetParameter("cCODFISC",source.GetParameter("w_cCODFISC",""));
        }
      }
      m_bpassedw_cDIP = source.Has("w_cDIP");
      if (m_bpassedw_cDIP) {
        w_cDIP = source.GetParameter("w_cDIP",source.GetParameter("cDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_cDIP = source.GetCaller().GetString("cDIP","C",5,0);
          m_bpassedw_cDIP = true;
        } else {
          w_cDIP = source.GetParameter("cDIP",source.GetParameter("w_cDIP",""));
        }
      }
      m_bpassedw_cMTCN = source.Has("w_cMTCN");
      if (m_bpassedw_cMTCN) {
        w_cMTCN = source.GetParameter("w_cMTCN",source.GetParameter("cMTCN",""));
      } else {
        if (source.IsForwarded()) {
          w_cMTCN = source.GetCaller().GetString("cMTCN","C",10,0);
          m_bpassedw_cMTCN = true;
        } else {
          w_cMTCN = source.GetParameter("cMTCN",source.GetParameter("w_cMTCN",""));
        }
      }
      m_bpassedw_xdesdip = source.Has("w_xdesdip");
      if (m_bpassedw_xdesdip) {
        w_xdesdip = source.GetParameter("w_xdesdip",source.GetParameter("xdesdip",""));
      } else {
        if (source.IsForwarded()) {
          w_xdesdip = source.GetCaller().GetString("xdesdip","C",30,0);
          m_bpassedw_xdesdip = true;
        } else {
          w_xdesdip = source.GetParameter("xdesdip",source.GetParameter("w_xdesdip",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_estrai_oper";
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
    return  ! (status.m_bpassedw_xdesdip) ||  ! (status.m_bpassedw_cMTCN) ||  ! (status.m_bpassedw_cDIP) ||  ! (status.m_bpassedw_cCODFISC) ||  ! (status.m_bpassedw_c_adata) ||  ! (status.m_bpassedw_cdadata) ||  ! (status.m_bpassedw_adata) ||  ! (status.m_bpassedw_dadata);
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
    if ( ! (status.m_bpassedw_dadata)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_dadata',"+SPLib.ToJSValue(status.w_dadata,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dadata,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_dadata',l_cV);");
    if ( ! (status.m_bpassedw_adata)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_adata',"+SPLib.ToJSValue(status.w_adata,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_adata,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_adata',l_cV);");
    if ( ! (status.m_bpassedw_cdadata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cdadata',"+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cdadata',l_cV);");
    if ( ! (status.m_bpassedw_c_adata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_adata',"+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_adata',l_cV);");
    if ( ! (status.m_bpassedw_cCODFISC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cCODFISC',"+SPLib.ToJSValue(status.w_cCODFISC,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cCODFISC,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cCODFISC',l_cV);");
    if ( ! (status.m_bpassedw_cDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cDIP',"+SPLib.ToJSValue(status.w_cDIP,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cDIP,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cDIP',l_cV);");
    if ( ! (status.m_bpassedw_cMTCN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cMTCN',"+SPLib.ToJSValue(status.w_cMTCN,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cMTCN,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cMTCN',l_cV);");
    if ( ! (status.m_bpassedw_xdesdip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xdesdip',"+SPLib.ToJSValue(status.w_xdesdip,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdesdip,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xdesdip',l_cV);");
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
    arrt_estrai_operR Rcalled;
    Rcalled = new arrt_estrai_operR(status.context,status);
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
    return new arrt_estrai_operR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_estrai_operR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_estrai_oper"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_dadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dadata),"?",0,0)+"");
        status.out.println("js:w_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_adata),"?",0,0)+"");
        status.out.println("js:w_cdadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cdadata),"?",0,0)+"");
        status.out.println("js:w_c_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_adata),"?",0,0)+"");
        status.out.println("js:w_cCODFISC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cCODFISC),"?",0,0)+"");
        status.out.println("js:w_cDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cDIP),"?",0,0)+"");
        status.out.println("js:w_cMTCN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cMTCN),"?",0,0)+"");
        status.out.println("js:w_xdesdip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdesdip),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_dadata,null)) {");
        status.out.println(" window[f].w_dadata.setTime(("+SPLib.ToJSValue(status.w_dadata,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_adata,null)) {");
        status.out.println(" window[f].w_adata.setTime(("+SPLib.ToJSValue(status.w_adata,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cdadata,null)) {");
        status.out.println("window[f].w_cdadata="+SPLib.ToJSValue(status.w_cdadata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_adata,null)) {");
        status.out.println("window[f].w_c_adata="+SPLib.ToJSValue(status.w_c_adata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cCODFISC,null)) {");
        status.out.println("window[f].w_cCODFISC="+SPLib.ToJSValue(status.w_cCODFISC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cDIP,null)) {");
        status.out.println("window[f].w_cDIP="+SPLib.ToJSValue(status.w_cDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cMTCN,null)) {");
        status.out.println("window[f].w_cMTCN="+SPLib.ToJSValue(status.w_cMTCN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdesdip,null)) {");
        status.out.println("window[f].w_xdesdip="+SPLib.ToJSValue(status.w_xdesdip,"C",0,0)+";");
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
      arrt_estrai_operR Rcalled;
      Rcalled = new arrt_estrai_operR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_estrai_oper");
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
