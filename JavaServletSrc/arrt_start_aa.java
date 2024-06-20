import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_start_aa extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*1d8c9fa7*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipoallin;
    public String w_tipoallin;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_showdata;
    public double w_showdata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassed_top;
    public double _top;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassed_bottom;
    public double _bottom;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_Countot;
    public double w_Countot;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_Countok;
    public double w_Countok;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_Countpr;
    public double w_Countpr;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_Countpr2;
    public double w_Countpr2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_Countko;
    public double w_Countko;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_bloccaedit;
    public String w_bloccaedit;
    public String gMsgImp;
    public String gMsgProc;
    public String RAGSOC;
    public String NOME;
    public String COGNOME;
    public String SubRag;
    public double NSpazzi;
    public double NSpazzi2;
    public String Controllo;
    public String Allineamento;
    public double _i;
    public double _max;
    public double _cicli;
    public double _conta;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_tipoallin = source.Has("w_tipoallin");
      if (m_bpassedw_tipoallin) {
        w_tipoallin = source.GetParameter("w_tipoallin",source.GetParameter("tipoallin",""));
      } else {
        if (source.IsForwarded()) {
          w_tipoallin = source.GetCaller().GetString("tipoallin","C",1,0);
          m_bpassedw_tipoallin = true;
        } else {
          w_tipoallin = source.GetParameter("tipoallin",source.GetParameter("w_tipoallin",""));
        }
      }
      m_bpassedw_showdata = source.Has("w_showdata");
      if (m_bpassedw_showdata) {
        w_showdata = source.GetParameter("w_showdata",source.GetParameter("showdata",0));
      } else {
        if (source.IsForwarded()) {
          w_showdata = source.GetCaller().GetNumber("showdata","N",1,0);
          m_bpassedw_showdata = true;
        } else {
          w_showdata = source.GetParameter("showdata",source.GetParameter("w_showdata",0));
        }
      }
      m_bpassed_top = source.Has("_top");
      if (m_bpassed_top) {
        _top = source.GetParameter("_top",source.GetParameter("_top",0));
      } else {
        if (source.IsForwarded()) {
          _top = source.GetCaller().GetNumber("_top","N",15,0);
          m_bpassed_top = true;
        } else {
          _top = source.GetParameter("_top",source.GetParameter("_top",0));
        }
      }
      m_bpassed_bottom = source.Has("_bottom");
      if (m_bpassed_bottom) {
        _bottom = source.GetParameter("_bottom",source.GetParameter("_bottom",0));
      } else {
        if (source.IsForwarded()) {
          _bottom = source.GetCaller().GetNumber("_bottom","N",15,0);
          m_bpassed_bottom = true;
        } else {
          _bottom = source.GetParameter("_bottom",source.GetParameter("_bottom",0));
        }
      }
      m_bpassedw_Countot = source.Has("w_Countot");
      if (m_bpassedw_Countot) {
        w_Countot = source.GetParameter("w_Countot",source.GetParameter("Countot",0));
      } else {
        if (source.IsForwarded()) {
          w_Countot = source.GetCaller().GetNumber("Countot","N",20,0);
          m_bpassedw_Countot = true;
        } else {
          w_Countot = source.GetParameter("Countot",source.GetParameter("w_Countot",0));
        }
      }
      m_bpassedw_Countok = source.Has("w_Countok");
      if (m_bpassedw_Countok) {
        w_Countok = source.GetParameter("w_Countok",source.GetParameter("Countok",0));
      } else {
        if (source.IsForwarded()) {
          w_Countok = source.GetCaller().GetNumber("Countok","N",20,0);
          m_bpassedw_Countok = true;
        } else {
          w_Countok = source.GetParameter("Countok",source.GetParameter("w_Countok",0));
        }
      }
      m_bpassedw_Countpr = source.Has("w_Countpr");
      if (m_bpassedw_Countpr) {
        w_Countpr = source.GetParameter("w_Countpr",source.GetParameter("Countpr",0));
      } else {
        if (source.IsForwarded()) {
          w_Countpr = source.GetCaller().GetNumber("Countpr","N",20,0);
          m_bpassedw_Countpr = true;
        } else {
          w_Countpr = source.GetParameter("Countpr",source.GetParameter("w_Countpr",0));
        }
      }
      m_bpassedw_Countpr2 = source.Has("w_Countpr2");
      if (m_bpassedw_Countpr2) {
        w_Countpr2 = source.GetParameter("w_Countpr2",source.GetParameter("Countpr2",0));
      } else {
        if (source.IsForwarded()) {
          w_Countpr2 = source.GetCaller().GetNumber("Countpr2","N",20,0);
          m_bpassedw_Countpr2 = true;
        } else {
          w_Countpr2 = source.GetParameter("Countpr2",source.GetParameter("w_Countpr2",0));
        }
      }
      m_bpassedw_Countko = source.Has("w_Countko");
      if (m_bpassedw_Countko) {
        w_Countko = source.GetParameter("w_Countko",source.GetParameter("Countko",0));
      } else {
        if (source.IsForwarded()) {
          w_Countko = source.GetCaller().GetNumber("Countko","N",20,0);
          m_bpassedw_Countko = true;
        } else {
          w_Countko = source.GetParameter("Countko",source.GetParameter("w_Countko",0));
        }
      }
      m_bpassedw_bloccaedit = source.Has("w_bloccaedit");
      if (m_bpassedw_bloccaedit) {
        w_bloccaedit = source.GetParameter("w_bloccaedit",source.GetParameter("bloccaedit",""));
      } else {
        if (source.IsForwarded()) {
          w_bloccaedit = source.GetCaller().GetString("bloccaedit","C",1,0);
          m_bpassedw_bloccaedit = true;
        } else {
          w_bloccaedit = source.GetParameter("bloccaedit",source.GetParameter("w_bloccaedit",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_start_aa";
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
    return  ! (status.m_bpassedw_bloccaedit) ||  ! (status.m_bpassedw_Countko) ||  ! (status.m_bpassedw_Countpr2) ||  ! (status.m_bpassedw_Countpr) ||  ! (status.m_bpassedw_Countok) ||  ! (status.m_bpassedw_Countot) ||  ! (status.m_bpassed_bottom) ||  ! (status.m_bpassed_top) ||  ! (status.m_bpassedw_showdata) ||  ! (status.m_bpassedw_tipoallin);
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
    if ( ! (status.m_bpassedw_tipoallin)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipoallin',"+SPLib.ToJSValue(status.w_tipoallin,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoallin,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipoallin',l_cV);");
    if ( ! (status.m_bpassedw_showdata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_showdata',"+SPLib.ToJSValue(status.w_showdata,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_showdata,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_showdata',l_cV);");
    if ( ! (status.m_bpassed_top)) {
      status.out.println("l_cV=WtA(l_oWnd('w__top',"+SPLib.ToJSValue(status._top,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status._top,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('_top',l_cV);");
    if ( ! (status.m_bpassed_bottom)) {
      status.out.println("l_cV=WtA(l_oWnd('w__bottom',"+SPLib.ToJSValue(status._bottom,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status._bottom,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('_bottom',l_cV);");
    if ( ! (status.m_bpassedw_Countot)) {
      status.out.println("l_cV=WtA(l_oWnd('w_Countot',"+SPLib.ToJSValue(status.w_Countot,"N",20,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Countot,"N",20,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_Countot',l_cV);");
    if ( ! (status.m_bpassedw_Countok)) {
      status.out.println("l_cV=WtA(l_oWnd('w_Countok',"+SPLib.ToJSValue(status.w_Countok,"N",20,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Countok,"N",20,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_Countok',l_cV);");
    if ( ! (status.m_bpassedw_Countpr)) {
      status.out.println("l_cV=WtA(l_oWnd('w_Countpr',"+SPLib.ToJSValue(status.w_Countpr,"N",20,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Countpr,"N",20,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_Countpr',l_cV);");
    if ( ! (status.m_bpassedw_Countpr2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_Countpr2',"+SPLib.ToJSValue(status.w_Countpr2,"N",20,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Countpr2,"N",20,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_Countpr2',l_cV);");
    if ( ! (status.m_bpassedw_Countko)) {
      status.out.println("l_cV=WtA(l_oWnd('w_Countko',"+SPLib.ToJSValue(status.w_Countko,"N",20,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_Countko,"N",20,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_Countko',l_cV);");
    if ( ! (status.m_bpassedw_bloccaedit)) {
      status.out.println("l_cV=WtA(l_oWnd('w_bloccaedit',"+SPLib.ToJSValue(status.w_bloccaedit,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_bloccaedit,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_bloccaedit',l_cV);");
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
    arrt_start_aaR Rcalled;
    Rcalled = new arrt_start_aaR(status.context,status);
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
    return new arrt_start_aaR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_start_aaR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_start_aa"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_tipoallin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipoallin),"?",0,0)+"");
        status.out.println("js:w_showdata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_showdata),"?",0,0)+"");
        status.out.println("js:_top="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled._top),"?",0,0)+"");
        status.out.println("js:_bottom="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled._bottom),"?",0,0)+"");
        status.out.println("js:w_Countot="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_Countot),"?",0,0)+"");
        status.out.println("js:w_Countok="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_Countok),"?",0,0)+"");
        status.out.println("js:w_Countpr="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_Countpr),"?",0,0)+"");
        status.out.println("js:w_Countpr2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_Countpr2),"?",0,0)+"");
        status.out.println("js:w_Countko="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_Countko),"?",0,0)+"");
        status.out.println("js:w_bloccaedit="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_bloccaedit),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_tipoallin,null)) {");
        status.out.println("window[f].w_tipoallin="+SPLib.ToJSValue(status.w_tipoallin,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_showdata,null)) {");
        status.out.println("window[f].w_showdata="+SPLib.ToJSValue(status.w_showdata,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w__top,null)) {");
        status.out.println("window[f].w__top="+SPLib.ToJSValue(status._top,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w__bottom,null)) {");
        status.out.println("window[f].w__bottom="+SPLib.ToJSValue(status._bottom,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_Countot,null)) {");
        status.out.println("window[f].w_Countot="+SPLib.ToJSValue(status.w_Countot,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_Countok,null)) {");
        status.out.println("window[f].w_Countok="+SPLib.ToJSValue(status.w_Countok,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_Countpr,null)) {");
        status.out.println("window[f].w_Countpr="+SPLib.ToJSValue(status.w_Countpr,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_Countpr2,null)) {");
        status.out.println("window[f].w_Countpr2="+SPLib.ToJSValue(status.w_Countpr2,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_Countko,null)) {");
        status.out.println("window[f].w_Countko="+SPLib.ToJSValue(status.w_Countko,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_bloccaedit,null)) {");
        status.out.println("window[f].w_bloccaedit="+SPLib.ToJSValue(status.w_bloccaedit,"C",0,0)+";");
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
      arrt_start_aaR Rcalled;
      Rcalled = new arrt_start_aaR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_start_aa");
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
