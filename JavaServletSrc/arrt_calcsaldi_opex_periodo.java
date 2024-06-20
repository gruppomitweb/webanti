import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_calcsaldi_opex_periodo extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3d7020ee*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_annorif;
    public double w_annorif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_valuta;
    public String w_valuta;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaData;
    public java.sql.Date w_DaData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_A_Data;
    public java.sql.Date w_A_Data;
    public String _codcli;
    public double _totale;
    public double _operaz;
    public String _anno;
    public double _tot;
    public String gMsgImp;
    public void GetNonLocals(SPParameterSource source) {
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
      m_bpassedw_valuta = source.Has("w_valuta");
      if (m_bpassedw_valuta) {
        w_valuta = source.GetParameter("w_valuta",source.GetParameter("valuta",""));
      } else {
        if (source.IsForwarded()) {
          w_valuta = source.GetCaller().GetString("valuta","C",3,0);
          m_bpassedw_valuta = true;
        } else {
          w_valuta = source.GetParameter("valuta",source.GetParameter("w_valuta",""));
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
      m_bpassedw_A_Data = source.Has("w_A_Data");
      if (m_bpassedw_A_Data) {
        w_A_Data = source.GetParameter("w_A_Data",source.GetParameter("A_Data",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_A_Data = source.GetCaller().GetDate("A_Data","D",8,0);
          m_bpassedw_A_Data = true;
        } else {
          w_A_Data = source.GetParameter("A_Data",source.GetParameter("w_A_Data",CPLib.NullDate()));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_calcsaldi_opex_periodo";
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
    return  ! (status.m_bpassedw_A_Data) ||  ! (status.m_bpassedw_DaData) ||  ! (status.m_bpassedw_valuta) ||  ! (status.m_bpassedw_annorif);
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
    if ( ! (status.m_bpassedw_annorif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_annorif',"+SPLib.ToJSValue(status.w_annorif,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_annorif,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_annorif',l_cV);");
    if ( ! (status.m_bpassedw_valuta)) {
      status.out.println("l_cV=WtA(l_oWnd('w_valuta',"+SPLib.ToJSValue(status.w_valuta,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_valuta,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_valuta',l_cV);");
    if ( ! (status.m_bpassedw_DaData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaData',"+SPLib.ToJSValue(status.w_DaData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaData',l_cV);");
    if ( ! (status.m_bpassedw_A_Data)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_A_Data',"+SPLib.ToJSValue(status.w_A_Data,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_A_Data,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_A_Data',l_cV);");
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
    arrt_calcsaldi_opex_periodoR Rcalled;
    Rcalled = new arrt_calcsaldi_opex_periodoR(status.context,status);
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
    return new arrt_calcsaldi_opex_periodoR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_calcsaldi_opex_periodoR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_calcsaldi_opex_periodo"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_annorif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_annorif),"?",0,0)+"");
        status.out.println("js:w_valuta="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_valuta),"?",0,0)+"");
        status.out.println("js:w_DaData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaData),"?",0,0)+"");
        status.out.println("js:w_A_Data="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_A_Data),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_annorif,null)) {");
        status.out.println("window[f].w_annorif="+SPLib.ToJSValue(status.w_annorif,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_valuta,null)) {");
        status.out.println("window[f].w_valuta="+SPLib.ToJSValue(status.w_valuta,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DaData,null)) {");
        status.out.println(" window[f].w_DaData.setTime(("+SPLib.ToJSValue(status.w_DaData,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_A_Data,null)) {");
        status.out.println(" window[f].w_A_Data.setTime(("+SPLib.ToJSValue(status.w_A_Data,"D",0,0)+").getTime())");
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
      arrt_calcsaldi_opex_periodoR Rcalled;
      Rcalled = new arrt_calcsaldi_opex_periodoR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_calcsaldi_opex_periodo");
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
