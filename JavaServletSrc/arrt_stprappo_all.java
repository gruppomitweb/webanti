import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stprappo_all extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*fa1f4aee*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gPathApp;
    public String gUrlApp;
    public String gDescAzi;
    public String gAzienda;
    public String gMsgImp;
    public String nomefilexls;
    public String rapporto;
    public String descrap;
    public String cf;
    public String piva;
    public String dataini;
    public java.sql.Date _dataini;
    public String datafin;
    public java.sql.Date _datafin;
    public String tiprap;
    public String valuta;
    public String _ragsoc;
    public String _tipsog;
    public String connes;
    public String indirizzo;
    public String citres;
    public String capres;
    public String cabres;
    public String prvres;
    public String stares;
    public String citnas;
    public String prvnas;
    public String stanas;
    public String sesso;
    public String datnas;
    public String tipdoc;
    public String autril;
    public String numdoc;
    public String datril;
    public String luonas;
    public String _sae;
    public String _dsae;
    public String _ateco;
    public String _dateco;
    public String _ssin;
    public String _dssin;
    public String _rae;
    public String _drae;
    public String _customerid;
    public String _scopo;
    public String _natura;
    public String _risglob;
    public String _datprof;
    public String _datrevprof;
    public String _desrisglob;
    public String _cognome;
    public String _nome;
    public String _risglobs;
    public String _datprofs;
    public String _datrevprofs;
    public String _destipsog;
    public String foglio;
    public String stringa;
    public String report_name;
    public String c_dadata;
    public String c_adata;
    public String fonte;
    public String tipostp;
    public String daRappo;
    public String aRappo;
    public String DaSogg;
    public String ASogg;
    public String coddip;
    public java.sql.Date DaData;
    public java.sql.Date AData;
    public boolean detope;
    public boolean detana;
    public boolean flgtit;
    public boolean flgdel;
    public String tipo;
    public boolean attiva;
    public boolean mod_attiva;
    public boolean cancellata;
    public boolean mod_copia;
    public boolean aui;
    public String pTIPOAG;
    public String pRISGLOB;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.fonte","fonte");
      }        
      fonte = source.GetParameter("fonte","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.tipostp","tipostp");
      }        
      tipostp = source.GetParameter("tipostp","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.daRappo","daRappo");
      }        
      daRappo = source.GetParameter("daRappo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.aRappo","aRappo");
      }        
      aRappo = source.GetParameter("aRappo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.DaSogg","DaSogg");
      }        
      DaSogg = source.GetParameter("DaSogg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.ASogg","ASogg");
      }        
      ASogg = source.GetParameter("ASogg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.coddip","coddip");
      }        
      coddip = source.GetParameter("coddip","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.DaData","DaData");
      }        
      DaData = source.GetParameter("DaData",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.AData","AData");
      }        
      AData = source.GetParameter("AData",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.detope","detope");
      }        
      detope = source.GetParameter("detope",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.detana","detana");
      }        
      detana = source.GetParameter("detana",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.flgtit","flgtit");
      }        
      flgtit = source.GetParameter("flgtit",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.flgdel","flgdel");
      }        
      flgdel = source.GetParameter("flgdel",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.tipo","tipo");
      }        
      tipo = source.GetParameter("tipo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.attiva","attiva");
      }        
      attiva = source.GetParameter("attiva",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.mod_attiva","mod_attiva");
      }        
      mod_attiva = source.GetParameter("mod_attiva",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.cancellata","cancellata");
      }        
      cancellata = source.GetParameter("cancellata",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.mod_copia","mod_copia");
      }        
      mod_copia = source.GetParameter("mod_copia",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.aui","aui");
      }        
      aui = source.GetParameter("aui",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTIPOAG","pTIPOAG");
      }        
      pTIPOAG = source.GetParameter("pTIPOAG","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pRISGLOB","pRISGLOB");
      }        
      pRISGLOB = source.GetParameter("pRISGLOB","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_stprappo_all";
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.fonte,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('fonte',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.tipostp,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('tipostp',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.daRappo,"C",25,0)+",'C');");
    status.out.println("l_oWv.setValue('daRappo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.aRappo,"C",25,0)+",'C');");
    status.out.println("l_oWv.setValue('aRappo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.DaSogg,"C",16,0)+",'C');");
    status.out.println("l_oWv.setValue('DaSogg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.ASogg,"C",16,0)+",'C');");
    status.out.println("l_oWv.setValue('ASogg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.coddip,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('coddip',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.DaData,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('DaData',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.AData,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('AData',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.detope,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('detope',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.detana,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('detana',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.flgtit,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('flgtit',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.flgdel,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('flgdel',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.tipo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('tipo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.attiva,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('attiva',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.mod_attiva,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('mod_attiva',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.cancellata,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('cancellata',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.mod_copia,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('mod_copia',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.aui,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('aui',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pTIPOAG,"C",2,0)+",'C');");
    status.out.println("l_oWv.setValue('pTIPOAG',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pRISGLOB,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pRISGLOB',l_cV);");
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
    arrt_stprappo_allR Rcalled;
    Rcalled = new arrt_stprappo_allR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.fonte,status.tipostp,status.daRappo,status.aRappo,status.DaSogg,status.ASogg,status.coddip,status.DaData,status.AData,status.detope,status.detana,status.flgtit,status.flgdel,status.tipo,status.attiva,status.mod_attiva,status.cancellata,status.mod_copia,status.aui,status.pTIPOAG,status.pRISGLOB);
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
    return new arrt_stprappo_allR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stprappo_allR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.fonte,status.tipostp,status.daRappo,status.aRappo,status.DaSogg,status.ASogg,status.coddip,status.DaData,status.AData,status.detope,status.detana,status.flgtit,status.flgdel,status.tipo,status.attiva,status.mod_attiva,status.cancellata,status.mod_copia,status.aui,status.pTIPOAG,status.pRISGLOB)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stprappo_all"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
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
      arrt_stprappo_allR Rcalled;
      Rcalled = new arrt_stprappo_allR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stprappo_all");
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
