import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stp_ope_fraz_all extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*6ed14f1f*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gFlgDoc;
    public String gDescAzi;
    public double onlyope;
    public double onlyrap;
    public String statoreg;
    public String _connes;
    public java.sql.Date _dataope;
    public java.sql.Date _datareg;
    public java.sql.Date _dataret;
    public String _numsto;
    public String _nomereport;
    public String _ftypes;
    public String _fmodels;
    public String _rotate;
    public String _reportname;
    public String _fonte_arch;
    public String _tipo_arch;
    public double _conta;
    public java.sql.Date _datachk;
    public String w_c_dadataope;
    public String w_c_adataope;
    public String w_c_dadatareg;
    public String w_c_adatareg;
    public String w_c_dadataret;
    public String w_c_adataret;
    public double w_StatoLower;
    public double w_StatoUpper;
    public double progrIns;
    public boolean _mlientiope;
    public boolean _clientiope;
    public boolean _mogopebo;
    public boolean _sogopebo;
    public boolean _meneficope;
    public boolean _beneficope;
    public boolean _merzistiope;
    public boolean _terzistiope;
    public boolean _mlientifrz;
    public boolean _clientifrz;
    public boolean _mogopefbo;
    public boolean _sogopefbo;
    public boolean _meneficfrz;
    public boolean _beneficfrz;
    public boolean _merzistifrz;
    public boolean _terzistifrz;
    public boolean _rapcolleg;
    public boolean _xerzistifrz;
    public boolean _xeneficfrz;
    public boolean _xlientifrz;
    public boolean _xogopefbo;
    public boolean _xogopebo;
    public boolean _xlientiope;
    public boolean _xeneficope;
    public boolean _xerzistiope;
    public boolean bRitorno;
    public java.sql.Date w_DaDatOpe;
    public java.sql.Date w_ADatOpe;
    public java.sql.Date w_DaDatReg;
    public java.sql.Date w_ADatReg;
    public java.sql.Date w_DaDatRet;
    public java.sql.Date w_ADatRet;
    public String w_EstrazTitEffNelPeriodo;
    public String w_CONNES;
    public String w_TipoOpeStampa;
    public String w_TipoStampa;
    public String w_OrderBy;
    public boolean w_Stp_dist_lire_euro;
    public boolean w_Con_Contanti;
    public String w_Stato;
    public boolean w_Senza_dip;
    public String w_Dipendenza;
    public String w_Ambito;
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
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_DaDatReg","w_DaDatReg");
      }        
      w_DaDatReg = source.GetParameter("w_DaDatReg",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ADatReg","w_ADatReg");
      }        
      w_ADatReg = source.GetParameter("w_ADatReg",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_DaDatRet","w_DaDatRet");
      }        
      w_DaDatRet = source.GetParameter("w_DaDatRet",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ADatRet","w_ADatRet");
      }        
      w_ADatRet = source.GetParameter("w_ADatRet",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_EstrazTitEffNelPeriodo","w_EstrazTitEffNelPeriodo");
      }        
      w_EstrazTitEffNelPeriodo = source.GetParameter("w_EstrazTitEffNelPeriodo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_CONNES","w_CONNES");
      }        
      w_CONNES = source.GetParameter("w_CONNES","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_TipoOpeStampa","w_TipoOpeStampa");
      }        
      w_TipoOpeStampa = source.GetParameter("w_TipoOpeStampa","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_TipoStampa","w_TipoStampa");
      }        
      w_TipoStampa = source.GetParameter("w_TipoStampa","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_OrderBy","w_OrderBy");
      }        
      w_OrderBy = source.GetParameter("w_OrderBy","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_Stp_dist_lire_euro","w_Stp_dist_lire_euro");
      }        
      w_Stp_dist_lire_euro = source.GetParameter("w_Stp_dist_lire_euro",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_Con_Contanti","w_Con_Contanti");
      }        
      w_Con_Contanti = source.GetParameter("w_Con_Contanti",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_Stato","w_Stato");
      }        
      w_Stato = source.GetParameter("w_Stato","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_Senza_dip","w_Senza_dip");
      }        
      w_Senza_dip = source.GetParameter("w_Senza_dip",false);
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_Dipendenza","w_Dipendenza");
      }        
      w_Dipendenza = source.GetParameter("w_Dipendenza","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_Ambito","w_Ambito");
      }        
      w_Ambito = source.GetParameter("w_Ambito","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_stp_ope_fraz_all";
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatReg,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_DaDatReg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatReg,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_ADatReg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatRet,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_DaDatRet',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatRet,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_ADatRet',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_EstrazTitEffNelPeriodo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_EstrazTitEffNelPeriodo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNES,"C",30,0)+",'C');");
    status.out.println("l_oWv.setValue('w_CONNES',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TipoOpeStampa,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_TipoOpeStampa',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TipoStampa,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_TipoStampa',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_OrderBy,"C",30,0)+",'C');");
    status.out.println("l_oWv.setValue('w_OrderBy',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Stp_dist_lire_euro,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('w_Stp_dist_lire_euro',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Con_Contanti,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('w_Con_Contanti',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Stato,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_Stato',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Senza_dip,"L",1,0)+",'L');");
    status.out.println("l_oWv.setValue('w_Senza_dip',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Dipendenza,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_Dipendenza',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Ambito,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_Ambito',l_cV);");
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
    arrt_stp_ope_fraz_allR Rcalled;
    Rcalled = new arrt_stp_ope_fraz_allR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.w_DaDatOpe,status.w_ADatOpe,status.w_DaDatReg,status.w_ADatReg,status.w_DaDatRet,status.w_ADatRet,status.w_EstrazTitEffNelPeriodo,status.w_CONNES,status.w_TipoOpeStampa,status.w_TipoStampa,status.w_OrderBy,status.w_Stp_dist_lire_euro,status.w_Con_Contanti,status.w_Stato,status.w_Senza_dip,status.w_Dipendenza,status.w_Ambito);
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
    return new arrt_stp_ope_fraz_allR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stp_ope_fraz_allR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.w_DaDatOpe,status.w_ADatOpe,status.w_DaDatReg,status.w_ADatReg,status.w_DaDatRet,status.w_ADatRet,status.w_EstrazTitEffNelPeriodo,status.w_CONNES,status.w_TipoOpeStampa,status.w_TipoStampa,status.w_OrderBy,status.w_Stp_dist_lire_euro,status.w_Con_Contanti,status.w_Stato,status.w_Senza_dip,status.w_Dipendenza,status.w_Ambito)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stp_ope_fraz_all"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
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
      arrt_stp_ope_fraz_allR Rcalled;
      Rcalled = new arrt_stp_ope_fraz_allR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stp_ope_fraz_all");
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
