import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_discouic_rilievi_pg extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*cb15c94a*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gPathApp;
    public String gTipInter;
    public String gIntemediario;
    public String gAzienda;
    public String gDescAzi;
    public String gMsgImp;
    public String gMsgProc;
    public String _tipcentro;
    public String _sottotipo;
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
    public String _dipbase;
    public String _dipcab;
    public String _dipabicab;
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
    public double _find;
    public boolean _clientikpe;
    public boolean _clientifrz;
    public boolean _clientiope;
    public java.sql.Date w_DaDatOpe;
    public java.sql.Date w_ADatOpe;
    public String w_rcoddip;
    public String w_rabicab;
    public String w_rcabdip;
    public String w_rpaecli;
    public String w_rcabcli;
    public String w_rcodvoc;
    public String w_rflglire;
    public String w_rsegno;
    public String w_rsetsin;
    public String w_rpaecon;
    public String w_rcabcon;
    public String w_rpaeint;
    public String w_rcabint;
    public String w_TipoOper;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_DaDatOpe","w_DaDatOpe");
      }        
      w_DaDatOpe = source.GetParameter("w_DaDatOpe",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ADatOpe","w_ADatOpe");
      }        
      w_ADatOpe = source.GetParameter("w_ADatOpe",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rcoddip","w_rcoddip");
      }        
      w_rcoddip = source.GetParameter("w_rcoddip","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rabicab","w_rabicab");
      }        
      w_rabicab = source.GetParameter("w_rabicab","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rcabdip","w_rcabdip");
      }        
      w_rcabdip = source.GetParameter("w_rcabdip","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rpaecli","w_rpaecli");
      }        
      w_rpaecli = source.GetParameter("w_rpaecli","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rcabcli","w_rcabcli");
      }        
      w_rcabcli = source.GetParameter("w_rcabcli","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rcodvoc","w_rcodvoc");
      }        
      w_rcodvoc = source.GetParameter("w_rcodvoc","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rflglire","w_rflglire");
      }        
      w_rflglire = source.GetParameter("w_rflglire","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rsegno","w_rsegno");
      }        
      w_rsegno = source.GetParameter("w_rsegno","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rsetsin","w_rsetsin");
      }        
      w_rsetsin = source.GetParameter("w_rsetsin","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rpaecon","w_rpaecon");
      }        
      w_rpaecon = source.GetParameter("w_rpaecon","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rcabcon","w_rcabcon");
      }        
      w_rcabcon = source.GetParameter("w_rcabcon","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rpaeint","w_rpaeint");
      }        
      w_rpaeint = source.GetParameter("w_rpaeint","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rcabint","w_rcabint");
      }        
      w_rcabint = source.GetParameter("w_rcabint","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_TipoOper","w_TipoOper");
      }        
      w_TipoOper = source.GetParameter("w_TipoOper","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_discouic_rilievi_pg";
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_DaDatOpe',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_ADatOpe',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcoddip,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rcoddip',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rabicab,"C",10,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rabicab',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabdip,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rcabdip',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rpaecli,"C",3,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rpaecli',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabcli,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rcabcli',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcodvoc,"C",2,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rcodvoc',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rflglire,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rflglire',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rsegno,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rsegno',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rsetsin,"C",3,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rsetsin',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rpaecon,"C",3,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rpaecon',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabcon,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rcabcon',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rpaeint,"C",3,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rpaeint',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabint,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rcabint',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TipoOper,"C",2,0)+",'C');");
    status.out.println("l_oWv.setValue('w_TipoOper',l_cV);");
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
    arrt_discouic_rilievi_pgR Rcalled;
    Rcalled = new arrt_discouic_rilievi_pgR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.w_DaDatOpe,status.w_ADatOpe,status.w_rcoddip,status.w_rabicab,status.w_rcabdip,status.w_rpaecli,status.w_rcabcli,status.w_rcodvoc,status.w_rflglire,status.w_rsegno,status.w_rsetsin,status.w_rpaecon,status.w_rcabcon,status.w_rpaeint,status.w_rcabint,status.w_TipoOper);
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
    return new arrt_discouic_rilievi_pgR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_discouic_rilievi_pgR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.w_DaDatOpe,status.w_ADatOpe,status.w_rcoddip,status.w_rabicab,status.w_rcabdip,status.w_rpaecli,status.w_rcabcli,status.w_rcodvoc,status.w_rflglire,status.w_rsegno,status.w_rsetsin,status.w_rpaecon,status.w_rcabcon,status.w_rpaeint,status.w_rcabint,status.w_TipoOper)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_discouic_rilievi_pg"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
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
      arrt_discouic_rilievi_pgR Rcalled;
      Rcalled = new arrt_discouic_rilievi_pgR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_discouic_rilievi_pg");
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
