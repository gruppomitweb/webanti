import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_riallinea_fileae extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*SSWENGGZVR*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_offset;
    public double w_offset;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_f_denom;
    public String w_f_denom;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_prefrap;
    public String w_prefrap;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_f_ricaui;
    public String w_f_ricaui;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codval;
    public String w_codval;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_impzip;
    public double w_impzip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipofile;
    public double w_tipofile;
    public String fhand;
    public String riga;
    public String _filename;
    public String _codint;
    public String _periodo;
    public String _tipofile;
    public String _nomefile;
    public String _descfile;
    public double _esito;
    public String _rapporto;
    public double _numrig;
    public String _ragsoc;
    public String _prog;
    public String _tiprap;
    public String _startmsg;
    public double _numriga;
    public double cNumNew;
    public double cNumMod;
    public double cNumSog;
    public double cNumDel;
    public double cNumOXC;
    public double cNumRap;
    public double conta;
    public double cicla;
    public String cNPROG;
    public String cCODFISC;
    public String cCOGNOME;
    public String cNOME;
    public String cSESSO;
    public java.sql.Date dDATNAS;
    public String cNACITTA;
    public String cNAPROV;
    public String cRAGSOC;
    public String cSLCITTA;
    public String cSLPROV;
    public String cTIPOINF;
    public String cCOINT;
    public java.sql.Date dDATAPE;
    public java.sql.Date dDATCHI;
    public String cIDFILE;
    public String cIDPROG;
    public String cTIPOOP;
    public String cRiga;
    public String _connes;
    public double nProgImp;
    public double nProgImp2;
    public String cInfProg1;
    public String cInfProg2;
    public String cProgA;
    public String cProgC;
    public String cID;
    public java.sql.Date _dtret;
    public double _friga;
    public String _frappo;
    public String _tipoag;
    public String _coint;
    public String _idbase;
    public String czipfile;
    public String cpercorsozip;
    public String cdirectoryfile;
    public String buffernomefile;
    public String nomefileimport;
    public double _priorita;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public String gPathApp;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_offset = source.Has("w_offset");
      if (m_bpassedw_offset) {
        w_offset = source.GetParameter("w_offset",source.GetParameter("offset",0));
      } else {
        if (source.IsForwarded()) {
          w_offset = source.GetCaller().GetNumber("offset","N",5,0);
          m_bpassedw_offset = true;
        } else {
          w_offset = source.GetParameter("offset",source.GetParameter("w_offset",0));
        }
      }
      m_bpassedw_f_denom = source.Has("w_f_denom");
      if (m_bpassedw_f_denom) {
        w_f_denom = source.GetParameter("w_f_denom",source.GetParameter("f_denom",""));
      } else {
        if (source.IsForwarded()) {
          w_f_denom = source.GetCaller().GetString("f_denom","C",1,0);
          m_bpassedw_f_denom = true;
        } else {
          w_f_denom = source.GetParameter("f_denom",source.GetParameter("w_f_denom",""));
        }
      }
      m_bpassedw_prefrap = source.Has("w_prefrap");
      if (m_bpassedw_prefrap) {
        w_prefrap = source.GetParameter("w_prefrap",source.GetParameter("prefrap",""));
      } else {
        if (source.IsForwarded()) {
          w_prefrap = source.GetCaller().GetString("prefrap","C",5,0);
          m_bpassedw_prefrap = true;
        } else {
          w_prefrap = source.GetParameter("prefrap",source.GetParameter("w_prefrap",""));
        }
      }
      m_bpassedw_f_ricaui = source.Has("w_f_ricaui");
      if (m_bpassedw_f_ricaui) {
        w_f_ricaui = source.GetParameter("w_f_ricaui",source.GetParameter("f_ricaui",""));
      } else {
        if (source.IsForwarded()) {
          w_f_ricaui = source.GetCaller().GetString("f_ricaui","C",1,0);
          m_bpassedw_f_ricaui = true;
        } else {
          w_f_ricaui = source.GetParameter("f_ricaui",source.GetParameter("w_f_ricaui",""));
        }
      }
      m_bpassedw_codval = source.Has("w_codval");
      if (m_bpassedw_codval) {
        w_codval = source.GetParameter("w_codval",source.GetParameter("codval",""));
      } else {
        if (source.IsForwarded()) {
          w_codval = source.GetCaller().GetString("codval","C",3,0);
          m_bpassedw_codval = true;
        } else {
          w_codval = source.GetParameter("codval",source.GetParameter("w_codval",""));
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
      m_bpassedw_tipofile = source.Has("w_tipofile");
      if (m_bpassedw_tipofile) {
        w_tipofile = source.GetParameter("w_tipofile",source.GetParameter("tipofile",0));
      } else {
        if (source.IsForwarded()) {
          w_tipofile = source.GetCaller().GetNumber("tipofile","N",1,0);
          m_bpassedw_tipofile = true;
        } else {
          w_tipofile = source.GetParameter("tipofile",source.GetParameter("w_tipofile",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_riallinea_fileae";
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
    return  ! (status.m_bpassedw_tipofile) ||  ! (status.m_bpassedw_impzip) ||  ! (status.m_bpassedw_codval) ||  ! (status.m_bpassedw_f_ricaui) ||  ! (status.m_bpassedw_prefrap) ||  ! (status.m_bpassedw_f_denom) ||  ! (status.m_bpassedw_offset);
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
    if ( ! (status.m_bpassedw_offset)) {
      status.out.println("l_cV=WtA(l_oWnd('w_offset',"+SPLib.ToJSValue(status.w_offset,"N",5,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_offset,"N",5,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_offset',l_cV);");
    if ( ! (status.m_bpassedw_f_denom)) {
      status.out.println("l_cV=WtA(l_oWnd('w_f_denom',"+SPLib.ToJSValue(status.w_f_denom,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_f_denom,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_f_denom',l_cV);");
    if ( ! (status.m_bpassedw_prefrap)) {
      status.out.println("l_cV=WtA(l_oWnd('w_prefrap',"+SPLib.ToJSValue(status.w_prefrap,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_prefrap,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_prefrap',l_cV);");
    if ( ! (status.m_bpassedw_f_ricaui)) {
      status.out.println("l_cV=WtA(l_oWnd('w_f_ricaui',"+SPLib.ToJSValue(status.w_f_ricaui,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_f_ricaui,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_f_ricaui',l_cV);");
    if ( ! (status.m_bpassedw_codval)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codval',"+SPLib.ToJSValue(status.w_codval,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codval,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codval',l_cV);");
    if ( ! (status.m_bpassedw_impzip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_impzip',"+SPLib.ToJSValue(status.w_impzip,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_impzip,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_impzip',l_cV);");
    if ( ! (status.m_bpassedw_tipofile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipofile',"+SPLib.ToJSValue(status.w_tipofile,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipofile,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_tipofile',l_cV);");
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
    arrt_riallinea_fileaeR Rcalled;
    Rcalled = new arrt_riallinea_fileaeR(status.context,status);
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
    return new arrt_riallinea_fileaeR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_riallinea_fileaeR Rcalled) throws IOException {
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
          ts = new CPTokenSource(status.context.Translate(Rcalled.m_cLastMsgError),"\n");
          while (ts.HasMoreTokens()) {
            status.out.println("Error message:"+ts.NextToken()+"");
          }
        }
        if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_riallinea_fileae"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+status.m_cFaultTrace+"");
          }
        }
        status.out.println("js:w_offset="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_offset),"?",0,0)+"");
        status.out.println("js:w_f_denom="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_f_denom),"?",0,0)+"");
        status.out.println("js:w_prefrap="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_prefrap),"?",0,0)+"");
        status.out.println("js:w_f_ricaui="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_f_ricaui),"?",0,0)+"");
        status.out.println("js:w_codval="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codval),"?",0,0)+"");
        status.out.println("js:w_impzip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_impzip),"?",0,0)+"");
        status.out.println("js:w_tipofile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipofile),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_offset,null)) {");
        status.out.println("window[f].w_offset="+SPLib.ToJSValue(status.w_offset,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_f_denom,null)) {");
        status.out.println("window[f].w_f_denom="+SPLib.ToJSValue(status.w_f_denom,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_prefrap,null)) {");
        status.out.println("window[f].w_prefrap="+SPLib.ToJSValue(status.w_prefrap,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_f_ricaui,null)) {");
        status.out.println("window[f].w_f_ricaui="+SPLib.ToJSValue(status.w_f_ricaui,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codval,null)) {");
        status.out.println("window[f].w_codval="+SPLib.ToJSValue(status.w_codval,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_impzip,null)) {");
        status.out.println("window[f].w_impzip="+SPLib.ToJSValue(status.w_impzip,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipofile,null)) {");
        status.out.println("window[f].w_tipofile="+SPLib.ToJSValue(status.w_tipofile,"N",0,0)+";");
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
      arrt_riallinea_fileaeR Rcalled;
      Rcalled = new arrt_riallinea_fileaeR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_riallinea_fileae");
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
