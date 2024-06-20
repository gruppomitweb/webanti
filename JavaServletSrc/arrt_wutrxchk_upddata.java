import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_wutrxchk_upddata extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*8d6f0109*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCOGNOM;
    public String w_TRXCOGNOM;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNOME;
    public String w_TRXNOME;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODFIS;
    public String w_TRXCODFIS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXLUONAS;
    public String w_TRXLUONAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATNAS;
    public java.sql.Date w_TRXDATNAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXSESSO;
    public String w_TRXSESSO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXFLGCF;
    public String w_TRXFLGCF;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xtipdoc;
    public String w_xtipdoc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xtnumdoc;
    public String w_xtnumdoc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xluonas;
    public String w_xluonas;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_TRXCOGNOM = source.Has("w_TRXCOGNOM");
      if (m_bpassedw_TRXCOGNOM) {
        w_TRXCOGNOM = source.GetParameter("w_TRXCOGNOM",source.GetParameter("TRXCOGNOM",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCOGNOM = source.GetCaller().GetString("TRXCOGNOM","C",50,0);
          m_bpassedw_TRXCOGNOM = true;
        } else {
          w_TRXCOGNOM = source.GetParameter("TRXCOGNOM",source.GetParameter("w_TRXCOGNOM",""));
        }
      }
      m_bpassedw_TRXNOME = source.Has("w_TRXNOME");
      if (m_bpassedw_TRXNOME) {
        w_TRXNOME = source.GetParameter("w_TRXNOME",source.GetParameter("TRXNOME",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNOME = source.GetCaller().GetString("TRXNOME","C",50,0);
          m_bpassedw_TRXNOME = true;
        } else {
          w_TRXNOME = source.GetParameter("TRXNOME",source.GetParameter("w_TRXNOME",""));
        }
      }
      m_bpassedw_TRXCODFIS = source.Has("w_TRXCODFIS");
      if (m_bpassedw_TRXCODFIS) {
        w_TRXCODFIS = source.GetParameter("w_TRXCODFIS",source.GetParameter("TRXCODFIS",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODFIS = source.GetCaller().GetString("TRXCODFIS","C",16,0);
          m_bpassedw_TRXCODFIS = true;
        } else {
          w_TRXCODFIS = source.GetParameter("TRXCODFIS",source.GetParameter("w_TRXCODFIS",""));
        }
      }
      m_bpassedw_TRXLUONAS = source.Has("w_TRXLUONAS");
      if (m_bpassedw_TRXLUONAS) {
        w_TRXLUONAS = source.GetParameter("w_TRXLUONAS",source.GetParameter("TRXLUONAS",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXLUONAS = source.GetCaller().GetString("TRXLUONAS","C",50,0);
          m_bpassedw_TRXLUONAS = true;
        } else {
          w_TRXLUONAS = source.GetParameter("TRXLUONAS",source.GetParameter("w_TRXLUONAS",""));
        }
      }
      m_bpassedw_TRXDATNAS = source.Has("w_TRXDATNAS");
      if (m_bpassedw_TRXDATNAS) {
        w_TRXDATNAS = source.GetParameter("w_TRXDATNAS",source.GetParameter("TRXDATNAS",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_TRXDATNAS = source.GetCaller().GetDate("TRXDATNAS","D",8,0);
          m_bpassedw_TRXDATNAS = true;
        } else {
          w_TRXDATNAS = source.GetParameter("TRXDATNAS",source.GetParameter("w_TRXDATNAS",CPLib.NullDate()));
        }
      }
      m_bpassedw_TRXSESSO = source.Has("w_TRXSESSO");
      if (m_bpassedw_TRXSESSO) {
        w_TRXSESSO = source.GetParameter("w_TRXSESSO",source.GetParameter("TRXSESSO",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXSESSO = source.GetCaller().GetString("TRXSESSO","C",1,0);
          m_bpassedw_TRXSESSO = true;
        } else {
          w_TRXSESSO = source.GetParameter("TRXSESSO",source.GetParameter("w_TRXSESSO",""));
        }
      }
      m_bpassedw_TRXFLGCF = source.Has("w_TRXFLGCF");
      if (m_bpassedw_TRXFLGCF) {
        w_TRXFLGCF = source.GetParameter("w_TRXFLGCF",source.GetParameter("TRXFLGCF",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXFLGCF = source.GetCaller().GetString("TRXFLGCF","C",1,0);
          m_bpassedw_TRXFLGCF = true;
        } else {
          w_TRXFLGCF = source.GetParameter("TRXFLGCF",source.GetParameter("w_TRXFLGCF",""));
        }
      }
      m_bpassedw_xtipdoc = source.Has("w_xtipdoc");
      if (m_bpassedw_xtipdoc) {
        w_xtipdoc = source.GetParameter("w_xtipdoc",source.GetParameter("xtipdoc",""));
      } else {
        if (source.IsForwarded()) {
          w_xtipdoc = source.GetCaller().GetString("xtipdoc","C",2,0);
          m_bpassedw_xtipdoc = true;
        } else {
          w_xtipdoc = source.GetParameter("xtipdoc",source.GetParameter("w_xtipdoc",""));
        }
      }
      m_bpassedw_xtnumdoc = source.Has("w_xtnumdoc");
      if (m_bpassedw_xtnumdoc) {
        w_xtnumdoc = source.GetParameter("w_xtnumdoc",source.GetParameter("xtnumdoc",""));
      } else {
        if (source.IsForwarded()) {
          w_xtnumdoc = source.GetCaller().GetString("xtnumdoc","C",15,0);
          m_bpassedw_xtnumdoc = true;
        } else {
          w_xtnumdoc = source.GetParameter("xtnumdoc",source.GetParameter("w_xtnumdoc",""));
        }
      }
      m_bpassedw_xluonas = source.Has("w_xluonas");
      if (m_bpassedw_xluonas) {
        w_xluonas = source.GetParameter("w_xluonas",source.GetParameter("xluonas",""));
      } else {
        if (source.IsForwarded()) {
          w_xluonas = source.GetCaller().GetString("xluonas","C",50,0);
          m_bpassedw_xluonas = true;
        } else {
          w_xluonas = source.GetParameter("xluonas",source.GetParameter("w_xluonas",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_wutrxchk_upddata";
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
    return  ! (status.m_bpassedw_xluonas) ||  ! (status.m_bpassedw_xtnumdoc) ||  ! (status.m_bpassedw_xtipdoc) ||  ! (status.m_bpassedw_TRXFLGCF) ||  ! (status.m_bpassedw_TRXSESSO) ||  ! (status.m_bpassedw_TRXDATNAS) ||  ! (status.m_bpassedw_TRXLUONAS) ||  ! (status.m_bpassedw_TRXCODFIS) ||  ! (status.m_bpassedw_TRXNOME) ||  ! (status.m_bpassedw_TRXCOGNOM);
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
    if ( ! (status.m_bpassedw_TRXCOGNOM)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCOGNOM',"+SPLib.ToJSValue(status.w_TRXCOGNOM,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCOGNOM,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCOGNOM',l_cV);");
    if ( ! (status.m_bpassedw_TRXNOME)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNOME',"+SPLib.ToJSValue(status.w_TRXNOME,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNOME,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNOME',l_cV);");
    if ( ! (status.m_bpassedw_TRXCODFIS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODFIS',"+SPLib.ToJSValue(status.w_TRXCODFIS,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODFIS,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODFIS',l_cV);");
    if ( ! (status.m_bpassedw_TRXLUONAS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXLUONAS',"+SPLib.ToJSValue(status.w_TRXLUONAS,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXLUONAS,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXLUONAS',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATNAS)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATNAS',"+SPLib.ToJSValue(status.w_TRXDATNAS,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATNAS,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATNAS',l_cV);");
    if ( ! (status.m_bpassedw_TRXSESSO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXSESSO',"+SPLib.ToJSValue(status.w_TRXSESSO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXSESSO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXSESSO',l_cV);");
    if ( ! (status.m_bpassedw_TRXFLGCF)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXFLGCF',"+SPLib.ToJSValue(status.w_TRXFLGCF,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXFLGCF,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXFLGCF',l_cV);");
    if ( ! (status.m_bpassedw_xtipdoc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xtipdoc',"+SPLib.ToJSValue(status.w_xtipdoc,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xtipdoc,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xtipdoc',l_cV);");
    if ( ! (status.m_bpassedw_xtnumdoc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xtnumdoc',"+SPLib.ToJSValue(status.w_xtnumdoc,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xtnumdoc,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xtnumdoc',l_cV);");
    if ( ! (status.m_bpassedw_xluonas)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xluonas',"+SPLib.ToJSValue(status.w_xluonas,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xluonas,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xluonas',l_cV);");
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
    arrt_wutrxchk_upddataR Rcalled;
    Rcalled = new arrt_wutrxchk_upddataR(status.context,status);
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
    return new arrt_wutrxchk_upddataR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_wutrxchk_upddataR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_wutrxchk_upddata"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_TRXCOGNOM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCOGNOM),"?",0,0)+"");
        status.out.println("js:w_TRXNOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNOME),"?",0,0)+"");
        status.out.println("js:w_TRXCODFIS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODFIS),"?",0,0)+"");
        status.out.println("js:w_TRXLUONAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXLUONAS),"?",0,0)+"");
        status.out.println("js:w_TRXDATNAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATNAS),"?",0,0)+"");
        status.out.println("js:w_TRXSESSO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXSESSO),"?",0,0)+"");
        status.out.println("js:w_TRXFLGCF="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXFLGCF),"?",0,0)+"");
        status.out.println("js:w_xtipdoc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xtipdoc),"?",0,0)+"");
        status.out.println("js:w_xtnumdoc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xtnumdoc),"?",0,0)+"");
        status.out.println("js:w_xluonas="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xluonas),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_TRXCOGNOM,null)) {");
        status.out.println("window[f].w_TRXCOGNOM="+SPLib.ToJSValue(status.w_TRXCOGNOM,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNOME,null)) {");
        status.out.println("window[f].w_TRXNOME="+SPLib.ToJSValue(status.w_TRXNOME,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODFIS,null)) {");
        status.out.println("window[f].w_TRXCODFIS="+SPLib.ToJSValue(status.w_TRXCODFIS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXLUONAS,null)) {");
        status.out.println("window[f].w_TRXLUONAS="+SPLib.ToJSValue(status.w_TRXLUONAS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATNAS,null)) {");
        status.out.println(" window[f].w_TRXDATNAS.setTime(("+SPLib.ToJSValue(status.w_TRXDATNAS,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXSESSO,null)) {");
        status.out.println("window[f].w_TRXSESSO="+SPLib.ToJSValue(status.w_TRXSESSO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXFLGCF,null)) {");
        status.out.println("window[f].w_TRXFLGCF="+SPLib.ToJSValue(status.w_TRXFLGCF,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xtipdoc,null)) {");
        status.out.println("window[f].w_xtipdoc="+SPLib.ToJSValue(status.w_xtipdoc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xtnumdoc,null)) {");
        status.out.println("window[f].w_xtnumdoc="+SPLib.ToJSValue(status.w_xtnumdoc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xluonas,null)) {");
        status.out.println("window[f].w_xluonas="+SPLib.ToJSValue(status.w_xluonas,"C",0,0)+";");
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
      arrt_wutrxchk_upddataR Rcalled;
      Rcalled = new arrt_wutrxchk_upddataR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_wutrxchk_upddata");
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
