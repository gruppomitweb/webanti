import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_crea_3132 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*81dd5a0e*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAPPORTO;
    public String w_RAPPORTO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLAGLIRE;
    public String w_FLAGLIRE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_VALUTA;
    public String w_VALUTA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPORAP;
    public String w_TIPORAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODDIPE;
    public String w_CODDIPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCCIT;
    public String w_DESCCIT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROVINCIA;
    public String w_PROVINCIA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODCAB;
    public String w_CODCAB;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xDescDipe;
    public String w_xDescDipe;
    public String _noinf;
    public String cInfProg1;
    public String cInfProg2;
    public String cColleg;
    public double nProgImp;
    public String _codinter;
    public String _citinter;
    public String _cabinter;
    public String _prvinter;
    public String _tipinter;
    public String _desinter;
    public String _idb2;
    public String gAzienda;
    public void GetNonLocals(SPParameterSource source) {
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
      m_bpassedw_FLAGLIRE = source.Has("w_FLAGLIRE");
      if (m_bpassedw_FLAGLIRE) {
        w_FLAGLIRE = source.GetParameter("w_FLAGLIRE",source.GetParameter("FLAGLIRE",""));
      } else {
        if (source.IsForwarded()) {
          w_FLAGLIRE = source.GetCaller().GetString("FLAGLIRE","C",1,0);
          m_bpassedw_FLAGLIRE = true;
        } else {
          w_FLAGLIRE = source.GetParameter("FLAGLIRE",source.GetParameter("w_FLAGLIRE",""));
        }
      }
      m_bpassedw_VALUTA = source.Has("w_VALUTA");
      if (m_bpassedw_VALUTA) {
        w_VALUTA = source.GetParameter("w_VALUTA",source.GetParameter("VALUTA",""));
      } else {
        if (source.IsForwarded()) {
          w_VALUTA = source.GetCaller().GetString("VALUTA","C",3,0);
          m_bpassedw_VALUTA = true;
        } else {
          w_VALUTA = source.GetParameter("VALUTA",source.GetParameter("w_VALUTA",""));
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
      m_bpassedw_DESCCIT = source.Has("w_DESCCIT");
      if (m_bpassedw_DESCCIT) {
        w_DESCCIT = source.GetParameter("w_DESCCIT",source.GetParameter("DESCCIT",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCCIT = source.GetCaller().GetString("DESCCIT","C",30,0);
          m_bpassedw_DESCCIT = true;
        } else {
          w_DESCCIT = source.GetParameter("DESCCIT",source.GetParameter("w_DESCCIT",""));
        }
      }
      m_bpassedw_PROVINCIA = source.Has("w_PROVINCIA");
      if (m_bpassedw_PROVINCIA) {
        w_PROVINCIA = source.GetParameter("w_PROVINCIA",source.GetParameter("PROVINCIA",""));
      } else {
        if (source.IsForwarded()) {
          w_PROVINCIA = source.GetCaller().GetString("PROVINCIA","C",2,0);
          m_bpassedw_PROVINCIA = true;
        } else {
          w_PROVINCIA = source.GetParameter("PROVINCIA",source.GetParameter("w_PROVINCIA",""));
        }
      }
      m_bpassedw_CODCAB = source.Has("w_CODCAB");
      if (m_bpassedw_CODCAB) {
        w_CODCAB = source.GetParameter("w_CODCAB",source.GetParameter("CODCAB",""));
      } else {
        if (source.IsForwarded()) {
          w_CODCAB = source.GetCaller().GetString("CODCAB","C",6,0);
          m_bpassedw_CODCAB = true;
        } else {
          w_CODCAB = source.GetParameter("CODCAB",source.GetParameter("w_CODCAB",""));
        }
      }
      m_bpassedw_xDescDipe = source.Has("w_xDescDipe");
      if (m_bpassedw_xDescDipe) {
        w_xDescDipe = source.GetParameter("w_xDescDipe",source.GetParameter("xDescDipe",""));
      } else {
        if (source.IsForwarded()) {
          w_xDescDipe = source.GetCaller().GetString("xDescDipe","C",30,0);
          m_bpassedw_xDescDipe = true;
        } else {
          w_xDescDipe = source.GetParameter("xDescDipe",source.GetParameter("w_xDescDipe",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_crea_3132";
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
    return  ! (status.m_bpassedw_xDescDipe) ||  ! (status.m_bpassedw_CODCAB) ||  ! (status.m_bpassedw_PROVINCIA) ||  ! (status.m_bpassedw_DESCCIT) ||  ! (status.m_bpassedw_CODDIPE) ||  ! (status.m_bpassedw_TIPORAP) ||  ! (status.m_bpassedw_VALUTA) ||  ! (status.m_bpassedw_FLAGLIRE) ||  ! (status.m_bpassedw_RAPPORTO);
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
    if ( ! (status.m_bpassedw_FLAGLIRE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLAGLIRE',"+SPLib.ToJSValue(status.w_FLAGLIRE,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLAGLIRE,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLAGLIRE',l_cV);");
    if ( ! (status.m_bpassedw_VALUTA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_VALUTA',"+SPLib.ToJSValue(status.w_VALUTA,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_VALUTA,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_VALUTA',l_cV);");
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
    if ( ! (status.m_bpassedw_DESCCIT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCCIT',"+SPLib.ToJSValue(status.w_DESCCIT,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCCIT,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCCIT',l_cV);");
    if ( ! (status.m_bpassedw_PROVINCIA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROVINCIA',"+SPLib.ToJSValue(status.w_PROVINCIA,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROVINCIA,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROVINCIA',l_cV);");
    if ( ! (status.m_bpassedw_CODCAB)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODCAB',"+SPLib.ToJSValue(status.w_CODCAB,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODCAB,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODCAB',l_cV);");
    if ( ! (status.m_bpassedw_xDescDipe)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xDescDipe',"+SPLib.ToJSValue(status.w_xDescDipe,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xDescDipe,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xDescDipe',l_cV);");
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
    arrt_crea_3132R Rcalled;
    Rcalled = new arrt_crea_3132R(status.context,status);
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
    return new arrt_crea_3132R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_crea_3132R Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_crea_3132"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_RAPPORTO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAPPORTO),"?",0,0)+"");
        status.out.println("js:w_FLAGLIRE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLAGLIRE),"?",0,0)+"");
        status.out.println("js:w_VALUTA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_VALUTA),"?",0,0)+"");
        status.out.println("js:w_TIPORAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPORAP),"?",0,0)+"");
        status.out.println("js:w_CODDIPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODDIPE),"?",0,0)+"");
        status.out.println("js:w_DESCCIT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCCIT),"?",0,0)+"");
        status.out.println("js:w_PROVINCIA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROVINCIA),"?",0,0)+"");
        status.out.println("js:w_CODCAB="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODCAB),"?",0,0)+"");
        status.out.println("js:w_xDescDipe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xDescDipe),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_FLAGLIRE,null)) {");
        status.out.println("window[f].w_FLAGLIRE="+SPLib.ToJSValue(status.w_FLAGLIRE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_VALUTA,null)) {");
        status.out.println("window[f].w_VALUTA="+SPLib.ToJSValue(status.w_VALUTA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPORAP,null)) {");
        status.out.println("window[f].w_TIPORAP="+SPLib.ToJSValue(status.w_TIPORAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODDIPE,null)) {");
        status.out.println("window[f].w_CODDIPE="+SPLib.ToJSValue(status.w_CODDIPE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCCIT,null)) {");
        status.out.println("window[f].w_DESCCIT="+SPLib.ToJSValue(status.w_DESCCIT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROVINCIA,null)) {");
        status.out.println("window[f].w_PROVINCIA="+SPLib.ToJSValue(status.w_PROVINCIA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODCAB,null)) {");
        status.out.println("window[f].w_CODCAB="+SPLib.ToJSValue(status.w_CODCAB,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xDescDipe,null)) {");
        status.out.println("window[f].w_xDescDipe="+SPLib.ToJSValue(status.w_xDescDipe,"C",0,0)+";");
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
      arrt_crea_3132R Rcalled;
      Rcalled = new arrt_crea_3132R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_crea_3132");
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
