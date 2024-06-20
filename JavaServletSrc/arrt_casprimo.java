import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_casprimo extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*a04147b7*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgnuovi;
    public String w_flgnuovi;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_anno;
    public double w_anno;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_mese;
    public String w_mese;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgstp;
    public String w_flgstp;
    public String gAzienda;
    public String gMsgImp;
    public String gMsgProc;
    public String gIntemediario;
    public String gPathApp;
    public double _conta;
    public String _errore;
    public double _crea;
    public java.sql.Date _dataini;
    public java.sql.Date _datafin;
    public String _invio;
    public double _max;
    public double _min;
    public double _tot;
    public double _mono;
    public double _contacicli;
    public double _bottom;
    public double _top;
    public double _cicli;
    public double _totrecord;
    public double _reccount;
    public String _unique;
    public String _newuc;
    public String cProg;
    public String _cdataini;
    public String _cdatafin;
    public String fhand;
    public String _nomefile;
    public String cNomeFile;
    public String _mese;
    public String _riga;
    public double _tipo1;
    public double _tipo2;
    public double _tipo3;
    public double _tipo4;
    public String _oldmsg;
    public String _cfinter;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_flgnuovi = source.Has("w_flgnuovi");
      if (m_bpassedw_flgnuovi) {
        w_flgnuovi = source.GetParameter("w_flgnuovi",source.GetParameter("flgnuovi",""));
      } else {
        if (source.IsForwarded()) {
          w_flgnuovi = source.GetCaller().GetString("flgnuovi","C",1,0);
          m_bpassedw_flgnuovi = true;
        } else {
          w_flgnuovi = source.GetParameter("flgnuovi",source.GetParameter("w_flgnuovi",""));
        }
      }
      m_bpassedw_anno = source.Has("w_anno");
      if (m_bpassedw_anno) {
        w_anno = source.GetParameter("w_anno",source.GetParameter("anno",0));
      } else {
        if (source.IsForwarded()) {
          w_anno = source.GetCaller().GetNumber("anno","N",4,0);
          m_bpassedw_anno = true;
        } else {
          w_anno = source.GetParameter("anno",source.GetParameter("w_anno",0));
        }
      }
      m_bpassedw_mese = source.Has("w_mese");
      if (m_bpassedw_mese) {
        w_mese = source.GetParameter("w_mese",source.GetParameter("mese",""));
      } else {
        if (source.IsForwarded()) {
          w_mese = source.GetCaller().GetString("mese","C",2,0);
          m_bpassedw_mese = true;
        } else {
          w_mese = source.GetParameter("mese",source.GetParameter("w_mese",""));
        }
      }
      m_bpassedw_flgstp = source.Has("w_flgstp");
      if (m_bpassedw_flgstp) {
        w_flgstp = source.GetParameter("w_flgstp",source.GetParameter("flgstp",""));
      } else {
        if (source.IsForwarded()) {
          w_flgstp = source.GetCaller().GetString("flgstp","C",2,0);
          m_bpassedw_flgstp = true;
        } else {
          w_flgstp = source.GetParameter("flgstp",source.GetParameter("w_flgstp",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_casprimo";
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
    return  ! (status.m_bpassedw_flgstp) ||  ! (status.m_bpassedw_mese) ||  ! (status.m_bpassedw_anno) ||  ! (status.m_bpassedw_flgnuovi);
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
    if ( ! (status.m_bpassedw_flgnuovi)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgnuovi',"+SPLib.ToJSValue(status.w_flgnuovi,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgnuovi,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgnuovi',l_cV);");
    if ( ! (status.m_bpassedw_anno)) {
      status.out.println("l_cV=WtA(l_oWnd('w_anno',"+SPLib.ToJSValue(status.w_anno,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_anno,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_anno',l_cV);");
    if ( ! (status.m_bpassedw_mese)) {
      status.out.println("l_cV=WtA(l_oWnd('w_mese',"+SPLib.ToJSValue(status.w_mese,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_mese,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_mese',l_cV);");
    if ( ! (status.m_bpassedw_flgstp)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgstp',"+SPLib.ToJSValue(status.w_flgstp,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgstp,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgstp',l_cV);");
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
    arrt_casprimoR Rcalled;
    Rcalled = new arrt_casprimoR(status.context,status);
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
    return new arrt_casprimoR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_casprimoR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_casprimo"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_flgnuovi="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgnuovi),"?",0,0)+"");
        status.out.println("js:w_anno="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_anno),"?",0,0)+"");
        status.out.println("js:w_mese="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_mese),"?",0,0)+"");
        status.out.println("js:w_flgstp="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgstp),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_flgnuovi,null)) {");
        status.out.println("window[f].w_flgnuovi="+SPLib.ToJSValue(status.w_flgnuovi,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_anno,null)) {");
        status.out.println("window[f].w_anno="+SPLib.ToJSValue(status.w_anno,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_mese,null)) {");
        status.out.println("window[f].w_mese="+SPLib.ToJSValue(status.w_mese,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgstp,null)) {");
        status.out.println("window[f].w_flgstp="+SPLib.ToJSValue(status.w_flgstp,"C",0,0)+";");
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
      arrt_casprimoR Rcalled;
      Rcalled = new arrt_casprimoR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_casprimo");
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
