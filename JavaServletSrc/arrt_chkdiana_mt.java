import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_chkdiana_mt extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*156b66ee*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codinter;
    public String w_codinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipinter;
    public String w_tipinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaData;
    public java.sql.Date w_DaData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AData;
    public java.sql.Date w_AData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipoarch;
    public String w_tipoarch;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codage;
    public String w_codage;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgope;
    public String w_flgope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgfrz;
    public String w_flgfrz;
    public String gPathApp;
    public String gIntemediario;
    public String gUrlApp;
    public String gAzienda;
    public double gNumRec;
    public double gNumReg;
    public String gMsgImp;
    public String gFlgWU;
    public String w_codcab;
    public String w_cabcod;
    public String w_desccit;
    public String w_citdesc;
    public String w_provin;
    public String w_provind;
    public String w_coddipe;
    public String _note;
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
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_codinter = source.Has("w_codinter");
      if (m_bpassedw_codinter) {
        w_codinter = source.GetParameter("w_codinter",source.GetParameter("codinter",""));
      } else {
        if (source.IsForwarded()) {
          w_codinter = source.GetCaller().GetString("codinter","C",11,0);
          m_bpassedw_codinter = true;
        } else {
          w_codinter = source.GetParameter("codinter",source.GetParameter("w_codinter",""));
        }
      }
      m_bpassedw_tipinter = source.Has("w_tipinter");
      if (m_bpassedw_tipinter) {
        w_tipinter = source.GetParameter("w_tipinter",source.GetParameter("tipinter",""));
      } else {
        if (source.IsForwarded()) {
          w_tipinter = source.GetCaller().GetString("tipinter","C",2,0);
          m_bpassedw_tipinter = true;
        } else {
          w_tipinter = source.GetParameter("tipinter",source.GetParameter("w_tipinter",""));
        }
      }
      m_bpassedw_DaData = source.Has("w_DaData");
      if (m_bpassedw_DaData) {
        w_DaData = source.GetParameter("w_DaData",source.GetParameter("DaData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaData = source.GetCaller().GetDate("DaData","D",8,0);
          m_bpassedw_DaData = true;
        } else {
          w_DaData = source.GetParameter("DaData",source.GetParameter("w_DaData",CPLib.NullDate()));
        }
      }
      m_bpassedw_AData = source.Has("w_AData");
      if (m_bpassedw_AData) {
        w_AData = source.GetParameter("w_AData",source.GetParameter("AData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_AData = source.GetCaller().GetDate("AData","D",8,0);
          m_bpassedw_AData = true;
        } else {
          w_AData = source.GetParameter("AData",source.GetParameter("w_AData",CPLib.NullDate()));
        }
      }
      m_bpassedw_tipoarch = source.Has("w_tipoarch");
      if (m_bpassedw_tipoarch) {
        w_tipoarch = source.GetParameter("w_tipoarch",source.GetParameter("tipoarch",""));
      } else {
        if (source.IsForwarded()) {
          w_tipoarch = source.GetCaller().GetString("tipoarch","C",1,0);
          m_bpassedw_tipoarch = true;
        } else {
          w_tipoarch = source.GetParameter("tipoarch",source.GetParameter("w_tipoarch",""));
        }
      }
      m_bpassedw_codage = source.Has("w_codage");
      if (m_bpassedw_codage) {
        w_codage = source.GetParameter("w_codage",source.GetParameter("codage",""));
      } else {
        if (source.IsForwarded()) {
          w_codage = source.GetCaller().GetString("codage","C",6,0);
          m_bpassedw_codage = true;
        } else {
          w_codage = source.GetParameter("codage",source.GetParameter("w_codage",""));
        }
      }
      m_bpassedw_flgope = source.Has("w_flgope");
      if (m_bpassedw_flgope) {
        w_flgope = source.GetParameter("w_flgope",source.GetParameter("flgope",""));
      } else {
        if (source.IsForwarded()) {
          w_flgope = source.GetCaller().GetString("flgope","C",1,0);
          m_bpassedw_flgope = true;
        } else {
          w_flgope = source.GetParameter("flgope",source.GetParameter("w_flgope",""));
        }
      }
      m_bpassedw_flgfrz = source.Has("w_flgfrz");
      if (m_bpassedw_flgfrz) {
        w_flgfrz = source.GetParameter("w_flgfrz",source.GetParameter("flgfrz",""));
      } else {
        if (source.IsForwarded()) {
          w_flgfrz = source.GetCaller().GetString("flgfrz","C",1,0);
          m_bpassedw_flgfrz = true;
        } else {
          w_flgfrz = source.GetParameter("flgfrz",source.GetParameter("w_flgfrz",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_chkdiana_mt";
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
    return  ! (status.m_bpassedw_flgfrz) ||  ! (status.m_bpassedw_flgope) ||  ! (status.m_bpassedw_codage) ||  ! (status.m_bpassedw_tipoarch) ||  ! (status.m_bpassedw_AData) ||  ! (status.m_bpassedw_DaData) ||  ! (status.m_bpassedw_tipinter) ||  ! (status.m_bpassedw_codinter);
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
    if ( ! (status.m_bpassedw_codinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codinter',"+SPLib.ToJSValue(status.w_codinter,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codinter,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codinter',l_cV);");
    if ( ! (status.m_bpassedw_tipinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipinter',"+SPLib.ToJSValue(status.w_tipinter,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipinter,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipinter',l_cV);");
    if ( ! (status.m_bpassedw_DaData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaData',"+SPLib.ToJSValue(status.w_DaData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaData',l_cV);");
    if ( ! (status.m_bpassedw_AData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_AData',"+SPLib.ToJSValue(status.w_AData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_AData',l_cV);");
    if ( ! (status.m_bpassedw_tipoarch)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipoarch',"+SPLib.ToJSValue(status.w_tipoarch,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoarch,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipoarch',l_cV);");
    if ( ! (status.m_bpassedw_codage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codage',"+SPLib.ToJSValue(status.w_codage,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codage,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codage',l_cV);");
    if ( ! (status.m_bpassedw_flgope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgope',"+SPLib.ToJSValue(status.w_flgope,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgope,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgope',l_cV);");
    if ( ! (status.m_bpassedw_flgfrz)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgfrz',"+SPLib.ToJSValue(status.w_flgfrz,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgfrz,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgfrz',l_cV);");
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
    arrt_chkdiana_mtR Rcalled;
    Rcalled = new arrt_chkdiana_mtR(status.context,status);
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
    return new arrt_chkdiana_mtR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_chkdiana_mtR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_chkdiana_mt"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_codinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codinter),"?",0,0)+"");
        status.out.println("js:w_tipinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipinter),"?",0,0)+"");
        status.out.println("js:w_DaData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaData),"?",0,0)+"");
        status.out.println("js:w_AData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AData),"?",0,0)+"");
        status.out.println("js:w_tipoarch="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipoarch),"?",0,0)+"");
        status.out.println("js:w_codage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codage),"?",0,0)+"");
        status.out.println("js:w_flgope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgope),"?",0,0)+"");
        status.out.println("js:w_flgfrz="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgfrz),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_codinter,null)) {");
        status.out.println("window[f].w_codinter="+SPLib.ToJSValue(status.w_codinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipinter,null)) {");
        status.out.println("window[f].w_tipinter="+SPLib.ToJSValue(status.w_tipinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DaData,null)) {");
        status.out.println(" window[f].w_DaData.setTime(("+SPLib.ToJSValue(status.w_DaData,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AData,null)) {");
        status.out.println(" window[f].w_AData.setTime(("+SPLib.ToJSValue(status.w_AData,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipoarch,null)) {");
        status.out.println("window[f].w_tipoarch="+SPLib.ToJSValue(status.w_tipoarch,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codage,null)) {");
        status.out.println("window[f].w_codage="+SPLib.ToJSValue(status.w_codage,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgope,null)) {");
        status.out.println("window[f].w_flgope="+SPLib.ToJSValue(status.w_flgope,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgfrz,null)) {");
        status.out.println("window[f].w_flgfrz="+SPLib.ToJSValue(status.w_flgfrz,"C",0,0)+";");
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
      arrt_chkdiana_mtR Rcalled;
      Rcalled = new arrt_chkdiana_mtR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_chkdiana_mt");
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
