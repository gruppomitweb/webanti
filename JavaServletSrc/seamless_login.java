import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class seamless_login extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*15e3fadb*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpUser;
    public String pUser;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpPwd;
    public String pPwd;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpAzienda;
    public String pAzienda;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpURL;
    public String pURL;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpURLOE;
    public String pURLOE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpOTP;
    public String pOTP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpIPC;
    public String pIPC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpIPS;
    public String pIPS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpIPSP;
    public String pIPSP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpIPRP;
    public String pIPRP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedpBrowser;
    public String pBrowser;
    public String gUtility;
    public String gIPC;
    public String gIPS;
    public String gIPSP;
    public String gIPP;
    public String gBrowser;
    public String gOTP;
    public String _path;
    public String _skt_server;
    public String _skt_paths;
    public double _skt_port;
    public String _skt_mode;
    public String _skt_connes;
    public String _header;
    public String _ritorno;
    public String _dati;
    public String _dati64;
    public double _ldati;
    public java.io.InputStreamReader _isr;
    public double _usrcode;
    public double _isadm;
    public String _muser;
    public double _mutil;
    public String _accesso;
    public String _tip;
    public double _ltip;
    public double _ntip;
    public double _nfind;
    public String fhand;
    public String riga;
    public double _maxazi;
    public double _aziext;
    public double _blocco;
    public String pippo;
    public String _pathdoc;
    public String _otp;
    public String _superdip;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedpUser = source.Has("pUser");
      if (m_bpassedpUser) {
        pUser = source.GetParameter("pUser",source.GetParameter("pUser",""));
      } else {
        if (source.IsForwarded()) {
          pUser = source.GetCaller().GetString("pUser","C",20,0);
          m_bpassedpUser = true;
        } else {
          pUser = source.GetParameter("pUser",source.GetParameter("pUser",""));
        }
      }
      m_bpassedpPwd = source.Has("pPwd");
      if (m_bpassedpPwd) {
        pPwd = source.GetParameter("pPwd",source.GetParameter("pPwd",""));
      } else {
        if (source.IsForwarded()) {
          pPwd = source.GetCaller().GetString("pPwd","C",20,0);
          m_bpassedpPwd = true;
        } else {
          pPwd = source.GetParameter("pPwd",source.GetParameter("pPwd",""));
        }
      }
      m_bpassedpAzienda = source.Has("pAzienda");
      if (m_bpassedpAzienda) {
        pAzienda = source.GetParameter("pAzienda",source.GetParameter("pAzienda",""));
      } else {
        if (source.IsForwarded()) {
          pAzienda = source.GetCaller().GetString("pAzienda","C",10,0);
          m_bpassedpAzienda = true;
        } else {
          pAzienda = source.GetParameter("pAzienda",source.GetParameter("pAzienda",""));
        }
      }
      m_bpassedpURL = source.Has("pURL");
      if (m_bpassedpURL) {
        pURL = source.GetParameter("pURL",source.GetParameter("pURL",""));
      } else {
        if (source.IsForwarded()) {
          pURL = source.GetCaller().GetString("pURL","C",50,0);
          m_bpassedpURL = true;
        } else {
          pURL = source.GetParameter("pURL",source.GetParameter("pURL",""));
        }
      }
      m_bpassedpURLOE = source.Has("pURLOE");
      if (m_bpassedpURLOE) {
        pURLOE = source.GetParameter("pURLOE",source.GetParameter("pURLOE",""));
      } else {
        if (source.IsForwarded()) {
          pURLOE = source.GetCaller().GetString("pURLOE","C",50,0);
          m_bpassedpURLOE = true;
        } else {
          pURLOE = source.GetParameter("pURLOE",source.GetParameter("pURLOE",""));
        }
      }
      m_bpassedpOTP = source.Has("pOTP");
      if (m_bpassedpOTP) {
        pOTP = source.GetParameter("pOTP",source.GetParameter("pOTP",""));
      } else {
        if (source.IsForwarded()) {
          pOTP = source.GetCaller().GetString("pOTP","C",6,0);
          m_bpassedpOTP = true;
        } else {
          pOTP = source.GetParameter("pOTP",source.GetParameter("pOTP",""));
        }
      }
      m_bpassedpIPC = source.Has("pIPC");
      if (m_bpassedpIPC) {
        pIPC = source.GetParameter("pIPC",source.GetParameter("pIPC",""));
      } else {
        if (source.IsForwarded()) {
          pIPC = source.GetCaller().GetString("pIPC","C",20,0);
          m_bpassedpIPC = true;
        } else {
          pIPC = source.GetParameter("pIPC",source.GetParameter("pIPC",""));
        }
      }
      m_bpassedpIPS = source.Has("pIPS");
      if (m_bpassedpIPS) {
        pIPS = source.GetParameter("pIPS",source.GetParameter("pIPS",""));
      } else {
        if (source.IsForwarded()) {
          pIPS = source.GetCaller().GetString("pIPS","C",120,0);
          m_bpassedpIPS = true;
        } else {
          pIPS = source.GetParameter("pIPS",source.GetParameter("pIPS",""));
        }
      }
      m_bpassedpIPSP = source.Has("pIPSP");
      if (m_bpassedpIPSP) {
        pIPSP = source.GetParameter("pIPSP",source.GetParameter("pIPSP",""));
      } else {
        if (source.IsForwarded()) {
          pIPSP = source.GetCaller().GetString("pIPSP","C",20,0);
          m_bpassedpIPSP = true;
        } else {
          pIPSP = source.GetParameter("pIPSP",source.GetParameter("pIPSP",""));
        }
      }
      m_bpassedpIPRP = source.Has("pIPRP");
      if (m_bpassedpIPRP) {
        pIPRP = source.GetParameter("pIPRP",source.GetParameter("pIPRP",""));
      } else {
        if (source.IsForwarded()) {
          pIPRP = source.GetCaller().GetString("pIPRP","C",20,0);
          m_bpassedpIPRP = true;
        } else {
          pIPRP = source.GetParameter("pIPRP",source.GetParameter("pIPRP",""));
        }
      }
      m_bpassedpBrowser = source.Has("pBrowser");
      if (m_bpassedpBrowser) {
        pBrowser = source.GetParameter("pBrowser",source.GetParameter("pBrowser",""));
      } else {
        if (source.IsForwarded()) {
          pBrowser = source.GetCaller().GetString("pBrowser","C",128,0);
          m_bpassedpBrowser = true;
        } else {
          pBrowser = source.GetParameter("pBrowser",source.GetParameter("pBrowser",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "seamless_login";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = true;
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
    return  ! (status.m_bpassedpBrowser) ||  ! (status.m_bpassedpIPRP) ||  ! (status.m_bpassedpIPSP) ||  ! (status.m_bpassedpIPS) ||  ! (status.m_bpassedpIPC) ||  ! (status.m_bpassedpOTP) ||  ! (status.m_bpassedpURLOE) ||  ! (status.m_bpassedpURL) ||  ! (status.m_bpassedpAzienda) ||  ! (status.m_bpassedpPwd) ||  ! (status.m_bpassedpUser);
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
    if ( ! (status.m_bpassedpUser)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pUser',"+SPLib.ToJSValue(status.pUser,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pUser,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pUser',l_cV);");
    if ( ! (status.m_bpassedpPwd)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pPwd',"+SPLib.ToJSValue(status.pPwd,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pPwd,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pPwd',l_cV);");
    if ( ! (status.m_bpassedpAzienda)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pAzienda',"+SPLib.ToJSValue(status.pAzienda,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pAzienda,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pAzienda',l_cV);");
    if ( ! (status.m_bpassedpURL)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pURL',"+SPLib.ToJSValue(status.pURL,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pURL,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pURL',l_cV);");
    if ( ! (status.m_bpassedpURLOE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pURLOE',"+SPLib.ToJSValue(status.pURLOE,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pURLOE,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pURLOE',l_cV);");
    if ( ! (status.m_bpassedpOTP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pOTP',"+SPLib.ToJSValue(status.pOTP,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pOTP,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pOTP',l_cV);");
    if ( ! (status.m_bpassedpIPC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pIPC',"+SPLib.ToJSValue(status.pIPC,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pIPC,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pIPC',l_cV);");
    if ( ! (status.m_bpassedpIPS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pIPS',"+SPLib.ToJSValue(status.pIPS,"C",120,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pIPS,"C",120,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pIPS',l_cV);");
    if ( ! (status.m_bpassedpIPSP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pIPSP',"+SPLib.ToJSValue(status.pIPSP,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pIPSP,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pIPSP',l_cV);");
    if ( ! (status.m_bpassedpIPRP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pIPRP',"+SPLib.ToJSValue(status.pIPRP,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pIPRP,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pIPRP',l_cV);");
    if ( ! (status.m_bpassedpBrowser)) {
      status.out.println("l_cV=WtA(l_oWnd('w_pBrowser',"+SPLib.ToJSValue(status.pBrowser,"C",128,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pBrowser,"C",128,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('pBrowser',l_cV);");
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
    seamless_loginR Rcalled;
    Rcalled = new seamless_loginR(status.context,status);
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
    return new seamless_loginR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,seamless_loginR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","seamless_login"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:pUser="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pUser),"?",0,0)+"");
        status.out.println("js:pPwd="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pPwd),"?",0,0)+"");
        status.out.println("js:pAzienda="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pAzienda),"?",0,0)+"");
        status.out.println("js:pURL="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pURL),"?",0,0)+"");
        status.out.println("js:pURLOE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pURLOE),"?",0,0)+"");
        status.out.println("js:pOTP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pOTP),"?",0,0)+"");
        status.out.println("js:pIPC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pIPC),"?",0,0)+"");
        status.out.println("js:pIPS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pIPS),"?",0,0)+"");
        status.out.println("js:pIPSP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pIPSP),"?",0,0)+"");
        status.out.println("js:pIPRP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pIPRP),"?",0,0)+"");
        status.out.println("js:pBrowser="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.pBrowser),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_pUser,null)) {");
        status.out.println("window[f].w_pUser="+SPLib.ToJSValue(status.pUser,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pPwd,null)) {");
        status.out.println("window[f].w_pPwd="+SPLib.ToJSValue(status.pPwd,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pAzienda,null)) {");
        status.out.println("window[f].w_pAzienda="+SPLib.ToJSValue(status.pAzienda,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pURL,null)) {");
        status.out.println("window[f].w_pURL="+SPLib.ToJSValue(status.pURL,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pURLOE,null)) {");
        status.out.println("window[f].w_pURLOE="+SPLib.ToJSValue(status.pURLOE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pOTP,null)) {");
        status.out.println("window[f].w_pOTP="+SPLib.ToJSValue(status.pOTP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pIPC,null)) {");
        status.out.println("window[f].w_pIPC="+SPLib.ToJSValue(status.pIPC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pIPS,null)) {");
        status.out.println("window[f].w_pIPS="+SPLib.ToJSValue(status.pIPS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pIPSP,null)) {");
        status.out.println("window[f].w_pIPSP="+SPLib.ToJSValue(status.pIPSP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pIPRP,null)) {");
        status.out.println("window[f].w_pIPRP="+SPLib.ToJSValue(status.pIPRP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_pBrowser,null)) {");
        status.out.println("window[f].w_pBrowser="+SPLib.ToJSValue(status.pBrowser,"C",0,0)+";");
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
      seamless_loginR Rcalled;
      Rcalled = new seamless_loginR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"seamless_login");
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
