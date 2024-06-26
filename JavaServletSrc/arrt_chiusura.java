import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_chiusura extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*4158fa74*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datchi;
    public java.sql.Date w_datchi;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datreg;
    public java.sql.Date w_datreg;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipoarch;
    public String w_tipoarch;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_causale;
    public String w_causale;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_macage;
    public String w_macage;
    public String _errlog;
    public double imprec;
    public double _noprot;
    public String _rapold;
    public String _tipoco;
    public double _nriga;
    public double _newrow;
    public double _conta;
    public String _idriga;
    public double _bottom;
    public double _top;
    public double _max;
    public double _cicli;
    public double _min;
    public double nProgImp;
    public String cInfProg1;
    public String cInfProg2;
    public double _closed;
    public double _delega;
    public String _coddel;
    public double _nrow;
    public String _idb2;
    public String _idreg;
    public String _macodice;
    public String gMsgImp;
    public String gAzienda;
    public String gMsgProc;
    public String pTipo;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      m_bpassedw_datchi = source.Has("w_datchi");
      if (m_bpassedw_datchi) {
        w_datchi = source.GetParameter("w_datchi",source.GetParameter("datchi",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datchi = source.GetCaller().GetDate("datchi","D",8,0);
          m_bpassedw_datchi = true;
        } else {
          w_datchi = source.GetParameter("datchi",source.GetParameter("w_datchi",CPLib.NullDate()));
        }
      }
      m_bpassedw_datreg = source.Has("w_datreg");
      if (m_bpassedw_datreg) {
        w_datreg = source.GetParameter("w_datreg",source.GetParameter("datreg",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datreg = source.GetCaller().GetDate("datreg","D",8,0);
          m_bpassedw_datreg = true;
        } else {
          w_datreg = source.GetParameter("datreg",source.GetParameter("w_datreg",CPLib.NullDate()));
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
      m_bpassedw_causale = source.Has("w_causale");
      if (m_bpassedw_causale) {
        w_causale = source.GetParameter("w_causale",source.GetParameter("causale",""));
      } else {
        if (source.IsForwarded()) {
          w_causale = source.GetCaller().GetString("causale","C",2,0);
          m_bpassedw_causale = true;
        } else {
          w_causale = source.GetParameter("causale",source.GetParameter("w_causale",""));
        }
      }
      m_bpassedw_macage = source.Has("w_macage");
      if (m_bpassedw_macage) {
        w_macage = source.GetParameter("w_macage",source.GetParameter("macage",""));
      } else {
        if (source.IsForwarded()) {
          w_macage = source.GetCaller().GetString("macage","C",5,0);
          m_bpassedw_macage = true;
        } else {
          w_macage = source.GetParameter("macage",source.GetParameter("w_macage",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_chiusura";
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
    return  ! (status.m_bpassedw_macage) ||  ! (status.m_bpassedw_causale) ||  ! (status.m_bpassedw_tipoarch) ||  ! (status.m_bpassedw_datreg) ||  ! (status.m_bpassedw_datchi);
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
    if ( ! (status.m_bpassedw_datchi)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datchi',"+SPLib.ToJSValue(status.w_datchi,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datchi,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datchi',l_cV);");
    if ( ! (status.m_bpassedw_datreg)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datreg',"+SPLib.ToJSValue(status.w_datreg,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datreg,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datreg',l_cV);");
    if ( ! (status.m_bpassedw_tipoarch)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipoarch',"+SPLib.ToJSValue(status.w_tipoarch,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoarch,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipoarch',l_cV);");
    if ( ! (status.m_bpassedw_causale)) {
      status.out.println("l_cV=WtA(l_oWnd('w_causale',"+SPLib.ToJSValue(status.w_causale,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_causale,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_causale',l_cV);");
    if ( ! (status.m_bpassedw_macage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_macage',"+SPLib.ToJSValue(status.w_macage,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_macage,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_macage',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pTipo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pTipo',l_cV);");
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
    arrt_chiusuraR Rcalled;
    Rcalled = new arrt_chiusuraR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.pTipo);
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
    return new arrt_chiusuraR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_chiusuraR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.pTipo)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_chiusura"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_datchi="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datchi),"?",0,0)+"");
        status.out.println("js:w_datreg="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datreg),"?",0,0)+"");
        status.out.println("js:w_tipoarch="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipoarch),"?",0,0)+"");
        status.out.println("js:w_causale="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_causale),"?",0,0)+"");
        status.out.println("js:w_macage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_macage),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_datchi,null)) {");
        status.out.println(" window[f].w_datchi.setTime(("+SPLib.ToJSValue(status.w_datchi,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datreg,null)) {");
        status.out.println(" window[f].w_datreg.setTime(("+SPLib.ToJSValue(status.w_datreg,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipoarch,null)) {");
        status.out.println("window[f].w_tipoarch="+SPLib.ToJSValue(status.w_tipoarch,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_causale,null)) {");
        status.out.println("window[f].w_causale="+SPLib.ToJSValue(status.w_causale,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_macage,null)) {");
        status.out.println("window[f].w_macage="+SPLib.ToJSValue(status.w_macage,"C",0,0)+";");
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
      arrt_chiusuraR Rcalled;
      Rcalled = new arrt_chiusuraR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_chiusura");
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
