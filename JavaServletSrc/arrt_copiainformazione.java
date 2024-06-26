import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_copiainformazione extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*87794160*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IDBASE;
    public String w_IDBASE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAPPORTO;
    public String w_RAPPORTO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_OPERAZMOD;
    public String w_OPERAZMOD;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATARETT;
    public java.sql.Date w_DATARETT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATAOPE;
    public java.sql.Date w_DATAOPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NUMPROG;
    public String w_NUMPROG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPOOPRAP;
    public String w_TIPOOPRAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IDBASE2;
    public String w_IDBASE2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IDEREG;
    public String w_IDEREG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_STATOREG;
    public String w_STATOREG;
    public String gSblocco;
    public String gAzienda;
    public java.sql.Date gDataVaria;
    public String cNewProg;
    public String _idreg;
    public String _flagrap2;
    public String pTipo;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      m_bpassedw_IDBASE = source.Has("w_IDBASE");
      if (m_bpassedw_IDBASE) {
        w_IDBASE = source.GetParameter("w_IDBASE",source.GetParameter("IDBASE",""));
      } else {
        if (source.IsForwarded()) {
          w_IDBASE = source.GetCaller().GetString("IDBASE","C",10,0);
          m_bpassedw_IDBASE = true;
        } else {
          w_IDBASE = source.GetParameter("IDBASE",source.GetParameter("w_IDBASE",""));
        }
      }
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
      m_bpassedw_OPERAZMOD = source.Has("w_OPERAZMOD");
      if (m_bpassedw_OPERAZMOD) {
        w_OPERAZMOD = source.GetParameter("w_OPERAZMOD",source.GetParameter("OPERAZMOD",""));
      } else {
        if (source.IsForwarded()) {
          w_OPERAZMOD = source.GetCaller().GetString("OPERAZMOD","C",20,0);
          m_bpassedw_OPERAZMOD = true;
        } else {
          w_OPERAZMOD = source.GetParameter("OPERAZMOD",source.GetParameter("w_OPERAZMOD",""));
        }
      }
      m_bpassedw_DATARETT = source.Has("w_DATARETT");
      if (m_bpassedw_DATARETT) {
        w_DATARETT = source.GetParameter("w_DATARETT",source.GetParameter("DATARETT",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATARETT = source.GetCaller().GetDate("DATARETT","D",8,0);
          m_bpassedw_DATARETT = true;
        } else {
          w_DATARETT = source.GetParameter("DATARETT",source.GetParameter("w_DATARETT",CPLib.NullDate()));
        }
      }
      m_bpassedw_DATAOPE = source.Has("w_DATAOPE");
      if (m_bpassedw_DATAOPE) {
        w_DATAOPE = source.GetParameter("w_DATAOPE",source.GetParameter("DATAOPE",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATAOPE = source.GetCaller().GetDate("DATAOPE","D",8,0);
          m_bpassedw_DATAOPE = true;
        } else {
          w_DATAOPE = source.GetParameter("DATAOPE",source.GetParameter("w_DATAOPE",CPLib.NullDate()));
        }
      }
      m_bpassedw_NUMPROG = source.Has("w_NUMPROG");
      if (m_bpassedw_NUMPROG) {
        w_NUMPROG = source.GetParameter("w_NUMPROG",source.GetParameter("NUMPROG",""));
      } else {
        if (source.IsForwarded()) {
          w_NUMPROG = source.GetCaller().GetString("NUMPROG","C",11,0);
          m_bpassedw_NUMPROG = true;
        } else {
          w_NUMPROG = source.GetParameter("NUMPROG",source.GetParameter("w_NUMPROG",""));
        }
      }
      m_bpassedw_TIPOOPRAP = source.Has("w_TIPOOPRAP");
      if (m_bpassedw_TIPOOPRAP) {
        w_TIPOOPRAP = source.GetParameter("w_TIPOOPRAP",source.GetParameter("TIPOOPRAP",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPOOPRAP = source.GetCaller().GetString("TIPOOPRAP","C",2,0);
          m_bpassedw_TIPOOPRAP = true;
        } else {
          w_TIPOOPRAP = source.GetParameter("TIPOOPRAP",source.GetParameter("w_TIPOOPRAP",""));
        }
      }
      m_bpassedw_IDBASE2 = source.Has("w_IDBASE2");
      if (m_bpassedw_IDBASE2) {
        w_IDBASE2 = source.GetParameter("w_IDBASE2",source.GetParameter("IDBASE2",""));
      } else {
        if (source.IsForwarded()) {
          w_IDBASE2 = source.GetCaller().GetString("IDBASE2","C",10,0);
          m_bpassedw_IDBASE2 = true;
        } else {
          w_IDBASE2 = source.GetParameter("IDBASE2",source.GetParameter("w_IDBASE2",""));
        }
      }
      m_bpassedw_IDEREG = source.Has("w_IDEREG");
      if (m_bpassedw_IDEREG) {
        w_IDEREG = source.GetParameter("w_IDEREG",source.GetParameter("IDEREG",""));
      } else {
        if (source.IsForwarded()) {
          w_IDEREG = source.GetCaller().GetString("IDEREG","C",20,0);
          m_bpassedw_IDEREG = true;
        } else {
          w_IDEREG = source.GetParameter("IDEREG",source.GetParameter("w_IDEREG",""));
        }
      }
      m_bpassedw_STATOREG = source.Has("w_STATOREG");
      if (m_bpassedw_STATOREG) {
        w_STATOREG = source.GetParameter("w_STATOREG",source.GetParameter("STATOREG",""));
      } else {
        if (source.IsForwarded()) {
          w_STATOREG = source.GetCaller().GetString("STATOREG","C",1,0);
          m_bpassedw_STATOREG = true;
        } else {
          w_STATOREG = source.GetParameter("STATOREG",source.GetParameter("w_STATOREG",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_copiainformazione";
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
    return  ! (status.m_bpassedw_STATOREG) ||  ! (status.m_bpassedw_IDEREG) ||  ! (status.m_bpassedw_IDBASE2) ||  ! (status.m_bpassedw_TIPOOPRAP) ||  ! (status.m_bpassedw_NUMPROG) ||  ! (status.m_bpassedw_DATAOPE) ||  ! (status.m_bpassedw_DATARETT) ||  ! (status.m_bpassedw_OPERAZMOD) ||  ! (status.m_bpassedw_RAPPORTO) ||  ! (status.m_bpassedw_IDBASE);
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
    if ( ! (status.m_bpassedw_IDBASE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IDBASE',"+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IDBASE',l_cV);");
    if ( ! (status.m_bpassedw_RAPPORTO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAPPORTO',"+SPLib.ToJSValue(status.w_RAPPORTO,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAPPORTO,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAPPORTO',l_cV);");
    if ( ! (status.m_bpassedw_OPERAZMOD)) {
      status.out.println("l_cV=WtA(l_oWnd('w_OPERAZMOD',"+SPLib.ToJSValue(status.w_OPERAZMOD,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_OPERAZMOD,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_OPERAZMOD',l_cV);");
    if ( ! (status.m_bpassedw_DATARETT)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATARETT',"+SPLib.ToJSValue(status.w_DATARETT,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATARETT,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATARETT',l_cV);");
    if ( ! (status.m_bpassedw_DATAOPE)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATAOPE',"+SPLib.ToJSValue(status.w_DATAOPE,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATAOPE,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATAOPE',l_cV);");
    if ( ! (status.m_bpassedw_NUMPROG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NUMPROG',"+SPLib.ToJSValue(status.w_NUMPROG,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NUMPROG,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NUMPROG',l_cV);");
    if ( ! (status.m_bpassedw_TIPOOPRAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPOOPRAP',"+SPLib.ToJSValue(status.w_TIPOOPRAP,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPOOPRAP,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPOOPRAP',l_cV);");
    if ( ! (status.m_bpassedw_IDBASE2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IDBASE2',"+SPLib.ToJSValue(status.w_IDBASE2,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IDBASE2,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IDBASE2',l_cV);");
    if ( ! (status.m_bpassedw_IDEREG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IDEREG',"+SPLib.ToJSValue(status.w_IDEREG,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IDEREG,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IDEREG',l_cV);");
    if ( ! (status.m_bpassedw_STATOREG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_STATOREG',"+SPLib.ToJSValue(status.w_STATOREG,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_STATOREG,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_STATOREG',l_cV);");
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
    arrt_copiainformazioneR Rcalled;
    Rcalled = new arrt_copiainformazioneR(status.context,status);
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
    return new arrt_copiainformazioneR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_copiainformazioneR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_copiainformazione"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_IDBASE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IDBASE),"?",0,0)+"");
        status.out.println("js:w_RAPPORTO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAPPORTO),"?",0,0)+"");
        status.out.println("js:w_OPERAZMOD="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_OPERAZMOD),"?",0,0)+"");
        status.out.println("js:w_DATARETT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATARETT),"?",0,0)+"");
        status.out.println("js:w_DATAOPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATAOPE),"?",0,0)+"");
        status.out.println("js:w_NUMPROG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NUMPROG),"?",0,0)+"");
        status.out.println("js:w_TIPOOPRAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPOOPRAP),"?",0,0)+"");
        status.out.println("js:w_IDBASE2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IDBASE2),"?",0,0)+"");
        status.out.println("js:w_IDEREG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IDEREG),"?",0,0)+"");
        status.out.println("js:w_STATOREG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_STATOREG),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_IDBASE,null)) {");
        status.out.println("window[f].w_IDBASE="+SPLib.ToJSValue(status.w_IDBASE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAPPORTO,null)) {");
        status.out.println("window[f].w_RAPPORTO="+SPLib.ToJSValue(status.w_RAPPORTO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_OPERAZMOD,null)) {");
        status.out.println("window[f].w_OPERAZMOD="+SPLib.ToJSValue(status.w_OPERAZMOD,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATARETT,null)) {");
        status.out.println(" window[f].w_DATARETT.setTime(("+SPLib.ToJSValue(status.w_DATARETT,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATAOPE,null)) {");
        status.out.println(" window[f].w_DATAOPE.setTime(("+SPLib.ToJSValue(status.w_DATAOPE,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NUMPROG,null)) {");
        status.out.println("window[f].w_NUMPROG="+SPLib.ToJSValue(status.w_NUMPROG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPOOPRAP,null)) {");
        status.out.println("window[f].w_TIPOOPRAP="+SPLib.ToJSValue(status.w_TIPOOPRAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_IDBASE2,null)) {");
        status.out.println("window[f].w_IDBASE2="+SPLib.ToJSValue(status.w_IDBASE2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_IDEREG,null)) {");
        status.out.println("window[f].w_IDEREG="+SPLib.ToJSValue(status.w_IDEREG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_STATOREG,null)) {");
        status.out.println("window[f].w_STATOREG="+SPLib.ToJSValue(status.w_STATOREG,"C",0,0)+";");
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
      arrt_copiainformazioneR Rcalled;
      Rcalled = new arrt_copiainformazioneR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_copiainformazione");
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
