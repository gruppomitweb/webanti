import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stprappo_prv extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*deaa2dc6*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_daRappo;
    public String w_daRappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_aRappo;
    public String w_aRappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaData;
    public java.sql.Date w_DaData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AData;
    public java.sql.Date w_AData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_dadata;
    public String w_c_dadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_adata;
    public String w_c_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_detope;
    public String w_detope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgtit;
    public String w_flgtit;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgdel;
    public String w_flgdel;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_coddip;
    public String w_coddip;
    public String gPathApp;
    public String gUrlApp;
    public String gDescAzi;
    public String gAzienda;
    public String gMsgImp;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_daRappo = source.Has("w_daRappo");
      if (m_bpassedw_daRappo) {
        w_daRappo = source.GetParameter("w_daRappo",source.GetParameter("daRappo",""));
      } else {
        if (source.IsForwarded()) {
          w_daRappo = source.GetCaller().GetString("daRappo","C",25,0);
          m_bpassedw_daRappo = true;
        } else {
          w_daRappo = source.GetParameter("daRappo",source.GetParameter("w_daRappo",""));
        }
      }
      m_bpassedw_aRappo = source.Has("w_aRappo");
      if (m_bpassedw_aRappo) {
        w_aRappo = source.GetParameter("w_aRappo",source.GetParameter("aRappo",""));
      } else {
        if (source.IsForwarded()) {
          w_aRappo = source.GetCaller().GetString("aRappo","C",25,0);
          m_bpassedw_aRappo = true;
        } else {
          w_aRappo = source.GetParameter("aRappo",source.GetParameter("w_aRappo",""));
        }
      }
      m_bpassedw_DaData = source.Has("w_DaData");
      if (m_bpassedw_DaData) {
        w_DaData = source.GetParameter("w_DaData",source.GetParameter("DaData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaData = source.GetCaller().GetDate("DaData","D",8,0);
          m_bpassedw_DaData = true;
        } else {
          w_DaData = source.GetParameter("DaData",source.GetParameter("w_DaData",CPLib.NullDate()));
        }
      }
      m_bpassedw_AData = source.Has("w_AData");
      if (m_bpassedw_AData) {
        w_AData = source.GetParameter("w_AData",source.GetParameter("AData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_AData = source.GetCaller().GetDate("AData","D",8,0);
          m_bpassedw_AData = true;
        } else {
          w_AData = source.GetParameter("AData",source.GetParameter("w_AData",CPLib.NullDate()));
        }
      }
      m_bpassedw_c_dadata = source.Has("w_c_dadata");
      if (m_bpassedw_c_dadata) {
        w_c_dadata = source.GetParameter("w_c_dadata",source.GetParameter("c_dadata",""));
      } else {
        if (source.IsForwarded()) {
          w_c_dadata = source.GetCaller().GetString("c_dadata","C",8,0);
          m_bpassedw_c_dadata = true;
        } else {
          w_c_dadata = source.GetParameter("c_dadata",source.GetParameter("w_c_dadata",""));
        }
      }
      m_bpassedw_c_adata = source.Has("w_c_adata");
      if (m_bpassedw_c_adata) {
        w_c_adata = source.GetParameter("w_c_adata",source.GetParameter("c_adata",""));
      } else {
        if (source.IsForwarded()) {
          w_c_adata = source.GetCaller().GetString("c_adata","C",8,0);
          m_bpassedw_c_adata = true;
        } else {
          w_c_adata = source.GetParameter("c_adata",source.GetParameter("w_c_adata",""));
        }
      }
      m_bpassedw_detope = source.Has("w_detope");
      if (m_bpassedw_detope) {
        w_detope = source.GetParameter("w_detope",source.GetParameter("detope",""));
      } else {
        if (source.IsForwarded()) {
          w_detope = source.GetCaller().GetString("detope","C",1,0);
          m_bpassedw_detope = true;
        } else {
          w_detope = source.GetParameter("detope",source.GetParameter("w_detope",""));
        }
      }
      m_bpassedw_flgtit = source.Has("w_flgtit");
      if (m_bpassedw_flgtit) {
        w_flgtit = source.GetParameter("w_flgtit",source.GetParameter("flgtit",""));
      } else {
        if (source.IsForwarded()) {
          w_flgtit = source.GetCaller().GetString("flgtit","C",1,0);
          m_bpassedw_flgtit = true;
        } else {
          w_flgtit = source.GetParameter("flgtit",source.GetParameter("w_flgtit",""));
        }
      }
      m_bpassedw_flgdel = source.Has("w_flgdel");
      if (m_bpassedw_flgdel) {
        w_flgdel = source.GetParameter("w_flgdel",source.GetParameter("flgdel",""));
      } else {
        if (source.IsForwarded()) {
          w_flgdel = source.GetCaller().GetString("flgdel","C",1,0);
          m_bpassedw_flgdel = true;
        } else {
          w_flgdel = source.GetParameter("flgdel",source.GetParameter("w_flgdel",""));
        }
      }
      m_bpassedw_coddip = source.Has("w_coddip");
      if (m_bpassedw_coddip) {
        w_coddip = source.GetParameter("w_coddip",source.GetParameter("coddip",""));
      } else {
        if (source.IsForwarded()) {
          w_coddip = source.GetCaller().GetString("coddip","C",6,0);
          m_bpassedw_coddip = true;
        } else {
          w_coddip = source.GetParameter("coddip",source.GetParameter("w_coddip",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_stprappo_prv";
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
    return  ! (status.m_bpassedw_coddip) ||  ! (status.m_bpassedw_flgdel) ||  ! (status.m_bpassedw_flgtit) ||  ! (status.m_bpassedw_detope) ||  ! (status.m_bpassedw_c_adata) ||  ! (status.m_bpassedw_c_dadata) ||  ! (status.m_bpassedw_AData) ||  ! (status.m_bpassedw_DaData) ||  ! (status.m_bpassedw_aRappo) ||  ! (status.m_bpassedw_daRappo);
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
    if ( ! (status.m_bpassedw_daRappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_daRappo',"+SPLib.ToJSValue(status.w_daRappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_daRappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_daRappo',l_cV);");
    if ( ! (status.m_bpassedw_aRappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_aRappo',"+SPLib.ToJSValue(status.w_aRappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_aRappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_aRappo',l_cV);");
    if ( ! (status.m_bpassedw_DaData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaData',"+SPLib.ToJSValue(status.w_DaData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaData',l_cV);");
    if ( ! (status.m_bpassedw_AData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_AData',"+SPLib.ToJSValue(status.w_AData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_AData',l_cV);");
    if ( ! (status.m_bpassedw_c_dadata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_dadata',"+SPLib.ToJSValue(status.w_c_dadata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_dadata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_dadata',l_cV);");
    if ( ! (status.m_bpassedw_c_adata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_adata',"+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_adata',l_cV);");
    if ( ! (status.m_bpassedw_detope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_detope',"+SPLib.ToJSValue(status.w_detope,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_detope,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_detope',l_cV);");
    if ( ! (status.m_bpassedw_flgtit)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgtit',"+SPLib.ToJSValue(status.w_flgtit,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgtit,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgtit',l_cV);");
    if ( ! (status.m_bpassedw_flgdel)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgdel',"+SPLib.ToJSValue(status.w_flgdel,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgdel,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgdel',l_cV);");
    if ( ! (status.m_bpassedw_coddip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_coddip',"+SPLib.ToJSValue(status.w_coddip,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_coddip,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_coddip',l_cV);");
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
    arrt_stprappo_prvR Rcalled;
    Rcalled = new arrt_stprappo_prvR(status.context,status);
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
    return new arrt_stprappo_prvR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stprappo_prvR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stprappo_prv"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_daRappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_daRappo),"?",0,0)+"");
        status.out.println("js:w_aRappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_aRappo),"?",0,0)+"");
        status.out.println("js:w_DaData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaData),"?",0,0)+"");
        status.out.println("js:w_AData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AData),"?",0,0)+"");
        status.out.println("js:w_c_dadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_dadata),"?",0,0)+"");
        status.out.println("js:w_c_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_adata),"?",0,0)+"");
        status.out.println("js:w_detope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_detope),"?",0,0)+"");
        status.out.println("js:w_flgtit="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgtit),"?",0,0)+"");
        status.out.println("js:w_flgdel="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgdel),"?",0,0)+"");
        status.out.println("js:w_coddip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_coddip),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_daRappo,null)) {");
        status.out.println("window[f].w_daRappo="+SPLib.ToJSValue(status.w_daRappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_aRappo,null)) {");
        status.out.println("window[f].w_aRappo="+SPLib.ToJSValue(status.w_aRappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DaData,null)) {");
        status.out.println(" window[f].w_DaData.setTime(("+SPLib.ToJSValue(status.w_DaData,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AData,null)) {");
        status.out.println(" window[f].w_AData.setTime(("+SPLib.ToJSValue(status.w_AData,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_dadata,null)) {");
        status.out.println("window[f].w_c_dadata="+SPLib.ToJSValue(status.w_c_dadata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_adata,null)) {");
        status.out.println("window[f].w_c_adata="+SPLib.ToJSValue(status.w_c_adata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_detope,null)) {");
        status.out.println("window[f].w_detope="+SPLib.ToJSValue(status.w_detope,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgtit,null)) {");
        status.out.println("window[f].w_flgtit="+SPLib.ToJSValue(status.w_flgtit,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgdel,null)) {");
        status.out.println("window[f].w_flgdel="+SPLib.ToJSValue(status.w_flgdel,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_coddip,null)) {");
        status.out.println("window[f].w_coddip="+SPLib.ToJSValue(status.w_coddip,"C",0,0)+";");
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
      arrt_stprappo_prvR Rcalled;
      Rcalled = new arrt_stprappo_prvR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stprappo_prv");
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
