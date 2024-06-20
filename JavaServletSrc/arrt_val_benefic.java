import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_val_benefic extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*58c1df1*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNESBEN;
    public String w_CONNESBEN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_CAB;
    public String w_C_CAB;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_CAP;
    public String w_C_CAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_CTA;
    public String w_C_CTA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_IND;
    public String w_C_IND;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_PRV;
    public String w_C_PRV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_RAG;
    public String w_C_RAG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_STA;
    public String w_C_STA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dessta;
    public String w_dessta;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_CONNESBEN = source.Has("w_CONNESBEN");
      if (m_bpassedw_CONNESBEN) {
        w_CONNESBEN = source.GetParameter("w_CONNESBEN",source.GetParameter("CONNESBEN",""));
      } else {
        if (source.IsForwarded()) {
          w_CONNESBEN = source.GetCaller().GetString("CONNESBEN","C",16,0);
          m_bpassedw_CONNESBEN = true;
        } else {
          w_CONNESBEN = source.GetParameter("CONNESBEN",source.GetParameter("w_CONNESBEN",""));
        }
      }
      m_bpassedw_C_CAB = source.Has("w_C_CAB");
      if (m_bpassedw_C_CAB) {
        w_C_CAB = source.GetParameter("w_C_CAB",source.GetParameter("C_CAB",""));
      } else {
        if (source.IsForwarded()) {
          w_C_CAB = source.GetCaller().GetString("C_CAB","C",6,0);
          m_bpassedw_C_CAB = true;
        } else {
          w_C_CAB = source.GetParameter("C_CAB",source.GetParameter("w_C_CAB",""));
        }
      }
      m_bpassedw_C_CAP = source.Has("w_C_CAP");
      if (m_bpassedw_C_CAP) {
        w_C_CAP = source.GetParameter("w_C_CAP",source.GetParameter("C_CAP",""));
      } else {
        if (source.IsForwarded()) {
          w_C_CAP = source.GetCaller().GetString("C_CAP","C",5,0);
          m_bpassedw_C_CAP = true;
        } else {
          w_C_CAP = source.GetParameter("C_CAP",source.GetParameter("w_C_CAP",""));
        }
      }
      m_bpassedw_C_CTA = source.Has("w_C_CTA");
      if (m_bpassedw_C_CTA) {
        w_C_CTA = source.GetParameter("w_C_CTA",source.GetParameter("C_CTA",""));
      } else {
        if (source.IsForwarded()) {
          w_C_CTA = source.GetCaller().GetString("C_CTA","C",30,0);
          m_bpassedw_C_CTA = true;
        } else {
          w_C_CTA = source.GetParameter("C_CTA",source.GetParameter("w_C_CTA",""));
        }
      }
      m_bpassedw_C_IND = source.Has("w_C_IND");
      if (m_bpassedw_C_IND) {
        w_C_IND = source.GetParameter("w_C_IND",source.GetParameter("C_IND",""));
      } else {
        if (source.IsForwarded()) {
          w_C_IND = source.GetCaller().GetString("C_IND","C",35,0);
          m_bpassedw_C_IND = true;
        } else {
          w_C_IND = source.GetParameter("C_IND",source.GetParameter("w_C_IND",""));
        }
      }
      m_bpassedw_C_PRV = source.Has("w_C_PRV");
      if (m_bpassedw_C_PRV) {
        w_C_PRV = source.GetParameter("w_C_PRV",source.GetParameter("C_PRV",""));
      } else {
        if (source.IsForwarded()) {
          w_C_PRV = source.GetCaller().GetString("C_PRV","C",2,0);
          m_bpassedw_C_PRV = true;
        } else {
          w_C_PRV = source.GetParameter("C_PRV",source.GetParameter("w_C_PRV",""));
        }
      }
      m_bpassedw_C_RAG = source.Has("w_C_RAG");
      if (m_bpassedw_C_RAG) {
        w_C_RAG = source.GetParameter("w_C_RAG",source.GetParameter("C_RAG",""));
      } else {
        if (source.IsForwarded()) {
          w_C_RAG = source.GetCaller().GetString("C_RAG","C",70,0);
          m_bpassedw_C_RAG = true;
        } else {
          w_C_RAG = source.GetParameter("C_RAG",source.GetParameter("w_C_RAG",""));
        }
      }
      m_bpassedw_C_STA = source.Has("w_C_STA");
      if (m_bpassedw_C_STA) {
        w_C_STA = source.GetParameter("w_C_STA",source.GetParameter("C_STA",""));
      } else {
        if (source.IsForwarded()) {
          w_C_STA = source.GetCaller().GetString("C_STA","C",3,0);
          m_bpassedw_C_STA = true;
        } else {
          w_C_STA = source.GetParameter("C_STA",source.GetParameter("w_C_STA",""));
        }
      }
      m_bpassedw_dessta = source.Has("w_dessta");
      if (m_bpassedw_dessta) {
        w_dessta = source.GetParameter("w_dessta",source.GetParameter("dessta",""));
      } else {
        if (source.IsForwarded()) {
          w_dessta = source.GetCaller().GetString("dessta","C",40,0);
          m_bpassedw_dessta = true;
        } else {
          w_dessta = source.GetParameter("dessta",source.GetParameter("w_dessta",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_val_benefic";
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
    return  ! (status.m_bpassedw_dessta) ||  ! (status.m_bpassedw_C_STA) ||  ! (status.m_bpassedw_C_RAG) ||  ! (status.m_bpassedw_C_PRV) ||  ! (status.m_bpassedw_C_IND) ||  ! (status.m_bpassedw_C_CTA) ||  ! (status.m_bpassedw_C_CAP) ||  ! (status.m_bpassedw_C_CAB) ||  ! (status.m_bpassedw_CONNESBEN);
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
    if ( ! (status.m_bpassedw_CONNESBEN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNESBEN',"+SPLib.ToJSValue(status.w_CONNESBEN,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNESBEN,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNESBEN',l_cV);");
    if ( ! (status.m_bpassedw_C_CAB)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_CAB',"+SPLib.ToJSValue(status.w_C_CAB,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_CAB,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_CAB',l_cV);");
    if ( ! (status.m_bpassedw_C_CAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_CAP',"+SPLib.ToJSValue(status.w_C_CAP,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_CAP,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_CAP',l_cV);");
    if ( ! (status.m_bpassedw_C_CTA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_CTA',"+SPLib.ToJSValue(status.w_C_CTA,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_CTA,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_CTA',l_cV);");
    if ( ! (status.m_bpassedw_C_IND)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_IND',"+SPLib.ToJSValue(status.w_C_IND,"C",35,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_IND,"C",35,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_IND',l_cV);");
    if ( ! (status.m_bpassedw_C_PRV)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_PRV',"+SPLib.ToJSValue(status.w_C_PRV,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_PRV,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_PRV',l_cV);");
    if ( ! (status.m_bpassedw_C_RAG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_RAG',"+SPLib.ToJSValue(status.w_C_RAG,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_RAG,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_RAG',l_cV);");
    if ( ! (status.m_bpassedw_C_STA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_STA',"+SPLib.ToJSValue(status.w_C_STA,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_STA,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_STA',l_cV);");
    if ( ! (status.m_bpassedw_dessta)) {
      status.out.println("l_cV=WtA(l_oWnd('w_dessta',"+SPLib.ToJSValue(status.w_dessta,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dessta,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_dessta',l_cV);");
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
    arrt_val_beneficR Rcalled;
    Rcalled = new arrt_val_beneficR(status.context,status);
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
    return new arrt_val_beneficR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_val_beneficR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_val_benefic"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_CONNESBEN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNESBEN),"?",0,0)+"");
        status.out.println("js:w_C_CAB="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_CAB),"?",0,0)+"");
        status.out.println("js:w_C_CAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_CAP),"?",0,0)+"");
        status.out.println("js:w_C_CTA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_CTA),"?",0,0)+"");
        status.out.println("js:w_C_IND="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_IND),"?",0,0)+"");
        status.out.println("js:w_C_PRV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_PRV),"?",0,0)+"");
        status.out.println("js:w_C_RAG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_RAG),"?",0,0)+"");
        status.out.println("js:w_C_STA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_STA),"?",0,0)+"");
        status.out.println("js:w_dessta="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dessta),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_CONNESBEN,null)) {");
        status.out.println("window[f].w_CONNESBEN="+SPLib.ToJSValue(status.w_CONNESBEN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_CAB,null)) {");
        status.out.println("window[f].w_C_CAB="+SPLib.ToJSValue(status.w_C_CAB,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_CAP,null)) {");
        status.out.println("window[f].w_C_CAP="+SPLib.ToJSValue(status.w_C_CAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_CTA,null)) {");
        status.out.println("window[f].w_C_CTA="+SPLib.ToJSValue(status.w_C_CTA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_IND,null)) {");
        status.out.println("window[f].w_C_IND="+SPLib.ToJSValue(status.w_C_IND,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_PRV,null)) {");
        status.out.println("window[f].w_C_PRV="+SPLib.ToJSValue(status.w_C_PRV,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_RAG,null)) {");
        status.out.println("window[f].w_C_RAG="+SPLib.ToJSValue(status.w_C_RAG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_STA,null)) {");
        status.out.println("window[f].w_C_STA="+SPLib.ToJSValue(status.w_C_STA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_dessta,null)) {");
        status.out.println("window[f].w_dessta="+SPLib.ToJSValue(status.w_dessta,"C",0,0)+";");
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
      arrt_val_beneficR Rcalled;
      Rcalled = new arrt_val_beneficR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_val_benefic");
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
