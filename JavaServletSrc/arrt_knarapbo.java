import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_knarapbo extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3025094a*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAPPORTO;
    public String w_RAPPORTO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCRAP;
    public String w_DESCRAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPORAP;
    public String w_TIPORAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODDIPE;
    public String w_CODDIPE;
    public String cConnes;
    public String pTipo;
    public String pOper;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pOper","pOper");
      }        
      pOper = source.GetParameter("pOper","");
      m_bpassedw_RAPPORTO = source.Has("w_RAPPORTO");
      if (m_bpassedw_RAPPORTO) {
        w_RAPPORTO = source.GetParameter("w_RAPPORTO",source.GetParameter("RAPPORTO",""));
      } else {
        if (source.IsForwarded()) {
          w_RAPPORTO = source.GetCaller().GetString("RAPPORTO","C",25,0);
          m_bpassedw_RAPPORTO = true;
        } else {
          w_RAPPORTO = source.GetParameter("RAPPORTO",source.GetParameter("w_RAPPORTO",""));
        }
      }
      m_bpassedw_DESCRAP = source.Has("w_DESCRAP");
      if (m_bpassedw_DESCRAP) {
        w_DESCRAP = source.GetParameter("w_DESCRAP",source.GetParameter("DESCRAP",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCRAP = source.GetCaller().GetString("DESCRAP","C",50,0);
          m_bpassedw_DESCRAP = true;
        } else {
          w_DESCRAP = source.GetParameter("DESCRAP",source.GetParameter("w_DESCRAP",""));
        }
      }
      m_bpassedw_TIPORAP = source.Has("w_TIPORAP");
      if (m_bpassedw_TIPORAP) {
        w_TIPORAP = source.GetParameter("w_TIPORAP",source.GetParameter("TIPORAP",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPORAP = source.GetCaller().GetString("TIPORAP","C",1,0);
          m_bpassedw_TIPORAP = true;
        } else {
          w_TIPORAP = source.GetParameter("TIPORAP",source.GetParameter("w_TIPORAP",""));
        }
      }
      m_bpassedw_CODDIPE = source.Has("w_CODDIPE");
      if (m_bpassedw_CODDIPE) {
        w_CODDIPE = source.GetParameter("w_CODDIPE",source.GetParameter("CODDIPE",""));
      } else {
        if (source.IsForwarded()) {
          w_CODDIPE = source.GetCaller().GetString("CODDIPE","C",6,0);
          m_bpassedw_CODDIPE = true;
        } else {
          w_CODDIPE = source.GetParameter("CODDIPE",source.GetParameter("w_CODDIPE",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_knarapbo";
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
    return  ! (status.m_bpassedw_CODDIPE) ||  ! (status.m_bpassedw_TIPORAP) ||  ! (status.m_bpassedw_DESCRAP) ||  ! (status.m_bpassedw_RAPPORTO);
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
    if ( ! (status.m_bpassedw_RAPPORTO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAPPORTO',"+SPLib.ToJSValue(status.w_RAPPORTO,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAPPORTO,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAPPORTO',l_cV);");
    if ( ! (status.m_bpassedw_DESCRAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCRAP',"+SPLib.ToJSValue(status.w_DESCRAP,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCRAP,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCRAP',l_cV);");
    if ( ! (status.m_bpassedw_TIPORAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPORAP',"+SPLib.ToJSValue(status.w_TIPORAP,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPORAP,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPORAP',l_cV);");
    if ( ! (status.m_bpassedw_CODDIPE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODDIPE',"+SPLib.ToJSValue(status.w_CODDIPE,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODDIPE,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODDIPE',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pTipo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pTipo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pOper,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pOper',l_cV);");
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
    arrt_knarapboR Rcalled;
    Rcalled = new arrt_knarapboR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.pTipo,status.pOper);
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
    return new arrt_knarapboR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_knarapboR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.pTipo,status.pOper)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_knarapbo"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_RAPPORTO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAPPORTO),"?",0,0)+"");
        status.out.println("js:w_DESCRAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCRAP),"?",0,0)+"");
        status.out.println("js:w_TIPORAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPORAP),"?",0,0)+"");
        status.out.println("js:w_CODDIPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODDIPE),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_RAPPORTO,null)) {");
        status.out.println("window[f].w_RAPPORTO="+SPLib.ToJSValue(status.w_RAPPORTO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCRAP,null)) {");
        status.out.println("window[f].w_DESCRAP="+SPLib.ToJSValue(status.w_DESCRAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPORAP,null)) {");
        status.out.println("window[f].w_TIPORAP="+SPLib.ToJSValue(status.w_TIPORAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODDIPE,null)) {");
        status.out.println("window[f].w_CODDIPE="+SPLib.ToJSValue(status.w_CODDIPE,"C",0,0)+";");
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
      arrt_knarapboR Rcalled;
      Rcalled = new arrt_knarapboR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_knarapbo");
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
