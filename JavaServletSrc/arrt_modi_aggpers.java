import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_modi_aggpers extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*4264d225*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNES;
    public String w_CONNES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AREAGEO;
    public String w_AREAGEO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_BANCABEN;
    public String w_BANCABEN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_COMPORT;
    public String w_COMPORT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PKTBSPECIE;
    public String w_PKTBSPECIE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAREA;
    public double w_RAREA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RCOMP;
    public double w_RCOMP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RNATGIU;
    public double w_RNATGIU;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CITTADIN1;
    public String w_CITTADIN1;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CITTADIN2;
    public String w_CITTADIN2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RESFISC;
    public String w_RESFISC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MITIG;
    public double w_MITIG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MITGDOC;
    public String w_MITGDOC;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_CONNES = source.Has("w_CONNES");
      if (m_bpassedw_CONNES) {
        w_CONNES = source.GetParameter("w_CONNES",source.GetParameter("CONNES",""));
      } else {
        if (source.IsForwarded()) {
          w_CONNES = source.GetCaller().GetString("CONNES","C",16,0);
          m_bpassedw_CONNES = true;
        } else {
          w_CONNES = source.GetParameter("CONNES",source.GetParameter("w_CONNES",""));
        }
      }
      m_bpassedw_AREAGEO = source.Has("w_AREAGEO");
      if (m_bpassedw_AREAGEO) {
        w_AREAGEO = source.GetParameter("w_AREAGEO",source.GetParameter("AREAGEO",""));
      } else {
        if (source.IsForwarded()) {
          w_AREAGEO = source.GetCaller().GetString("AREAGEO","C",5,0);
          m_bpassedw_AREAGEO = true;
        } else {
          w_AREAGEO = source.GetParameter("AREAGEO",source.GetParameter("w_AREAGEO",""));
        }
      }
      m_bpassedw_BANCABEN = source.Has("w_BANCABEN");
      if (m_bpassedw_BANCABEN) {
        w_BANCABEN = source.GetParameter("w_BANCABEN",source.GetParameter("BANCABEN",""));
      } else {
        if (source.IsForwarded()) {
          w_BANCABEN = source.GetCaller().GetString("BANCABEN","C",11,0);
          m_bpassedw_BANCABEN = true;
        } else {
          w_BANCABEN = source.GetParameter("BANCABEN",source.GetParameter("w_BANCABEN",""));
        }
      }
      m_bpassedw_COMPORT = source.Has("w_COMPORT");
      if (m_bpassedw_COMPORT) {
        w_COMPORT = source.GetParameter("w_COMPORT",source.GetParameter("COMPORT",""));
      } else {
        if (source.IsForwarded()) {
          w_COMPORT = source.GetCaller().GetString("COMPORT","C",5,0);
          m_bpassedw_COMPORT = true;
        } else {
          w_COMPORT = source.GetParameter("COMPORT",source.GetParameter("w_COMPORT",""));
        }
      }
      m_bpassedw_PKTBSPECIE = source.Has("w_PKTBSPECIE");
      if (m_bpassedw_PKTBSPECIE) {
        w_PKTBSPECIE = source.GetParameter("w_PKTBSPECIE",source.GetParameter("PKTBSPECIE",""));
      } else {
        if (source.IsForwarded()) {
          w_PKTBSPECIE = source.GetCaller().GetString("PKTBSPECIE","C",4,0);
          m_bpassedw_PKTBSPECIE = true;
        } else {
          w_PKTBSPECIE = source.GetParameter("PKTBSPECIE",source.GetParameter("w_PKTBSPECIE",""));
        }
      }
      m_bpassedw_RAREA = source.Has("w_RAREA");
      if (m_bpassedw_RAREA) {
        w_RAREA = source.GetParameter("w_RAREA",source.GetParameter("RAREA",0));
      } else {
        if (source.IsForwarded()) {
          w_RAREA = source.GetCaller().GetNumber("RAREA","N",3,0);
          m_bpassedw_RAREA = true;
        } else {
          w_RAREA = source.GetParameter("RAREA",source.GetParameter("w_RAREA",0));
        }
      }
      m_bpassedw_RCOMP = source.Has("w_RCOMP");
      if (m_bpassedw_RCOMP) {
        w_RCOMP = source.GetParameter("w_RCOMP",source.GetParameter("RCOMP",0));
      } else {
        if (source.IsForwarded()) {
          w_RCOMP = source.GetCaller().GetNumber("RCOMP","N",3,0);
          m_bpassedw_RCOMP = true;
        } else {
          w_RCOMP = source.GetParameter("RCOMP",source.GetParameter("w_RCOMP",0));
        }
      }
      m_bpassedw_RNATGIU = source.Has("w_RNATGIU");
      if (m_bpassedw_RNATGIU) {
        w_RNATGIU = source.GetParameter("w_RNATGIU",source.GetParameter("RNATGIU",0));
      } else {
        if (source.IsForwarded()) {
          w_RNATGIU = source.GetCaller().GetNumber("RNATGIU","N",3,0);
          m_bpassedw_RNATGIU = true;
        } else {
          w_RNATGIU = source.GetParameter("RNATGIU",source.GetParameter("w_RNATGIU",0));
        }
      }
      m_bpassedw_CITTADIN1 = source.Has("w_CITTADIN1");
      if (m_bpassedw_CITTADIN1) {
        w_CITTADIN1 = source.GetParameter("w_CITTADIN1",source.GetParameter("CITTADIN1",""));
      } else {
        if (source.IsForwarded()) {
          w_CITTADIN1 = source.GetCaller().GetString("CITTADIN1","C",3,0);
          m_bpassedw_CITTADIN1 = true;
        } else {
          w_CITTADIN1 = source.GetParameter("CITTADIN1",source.GetParameter("w_CITTADIN1",""));
        }
      }
      m_bpassedw_CITTADIN2 = source.Has("w_CITTADIN2");
      if (m_bpassedw_CITTADIN2) {
        w_CITTADIN2 = source.GetParameter("w_CITTADIN2",source.GetParameter("CITTADIN2",""));
      } else {
        if (source.IsForwarded()) {
          w_CITTADIN2 = source.GetCaller().GetString("CITTADIN2","C",3,0);
          m_bpassedw_CITTADIN2 = true;
        } else {
          w_CITTADIN2 = source.GetParameter("CITTADIN2",source.GetParameter("w_CITTADIN2",""));
        }
      }
      m_bpassedw_RESFISC = source.Has("w_RESFISC");
      if (m_bpassedw_RESFISC) {
        w_RESFISC = source.GetParameter("w_RESFISC",source.GetParameter("RESFISC",""));
      } else {
        if (source.IsForwarded()) {
          w_RESFISC = source.GetCaller().GetString("RESFISC","C",3,0);
          m_bpassedw_RESFISC = true;
        } else {
          w_RESFISC = source.GetParameter("RESFISC",source.GetParameter("w_RESFISC",""));
        }
      }
      m_bpassedw_MITIG = source.Has("w_MITIG");
      if (m_bpassedw_MITIG) {
        w_MITIG = source.GetParameter("w_MITIG",source.GetParameter("MITIG",0));
      } else {
        if (source.IsForwarded()) {
          w_MITIG = source.GetCaller().GetNumber("MITIG","N",4,0);
          m_bpassedw_MITIG = true;
        } else {
          w_MITIG = source.GetParameter("MITIG",source.GetParameter("w_MITIG",0));
        }
      }
      m_bpassedw_MITGDOC = source.Has("w_MITGDOC");
      if (m_bpassedw_MITGDOC) {
        w_MITGDOC = source.GetParameter("w_MITGDOC",source.GetParameter("MITGDOC",""));
      } else {
        if (source.IsForwarded()) {
          w_MITGDOC = source.GetCaller().GetString("MITGDOC","C",100,0);
          m_bpassedw_MITGDOC = true;
        } else {
          w_MITGDOC = source.GetParameter("MITGDOC",source.GetParameter("w_MITGDOC",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_modi_aggpers";
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
    return  ! (status.m_bpassedw_MITGDOC) ||  ! (status.m_bpassedw_MITIG) ||  ! (status.m_bpassedw_RESFISC) ||  ! (status.m_bpassedw_CITTADIN2) ||  ! (status.m_bpassedw_CITTADIN1) ||  ! (status.m_bpassedw_RNATGIU) ||  ! (status.m_bpassedw_RCOMP) ||  ! (status.m_bpassedw_RAREA) ||  ! (status.m_bpassedw_PKTBSPECIE) ||  ! (status.m_bpassedw_COMPORT) ||  ! (status.m_bpassedw_BANCABEN) ||  ! (status.m_bpassedw_AREAGEO) ||  ! (status.m_bpassedw_CONNES);
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
    if ( ! (status.m_bpassedw_CONNES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNES',"+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNES,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNES',l_cV);");
    if ( ! (status.m_bpassedw_AREAGEO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_AREAGEO',"+SPLib.ToJSValue(status.w_AREAGEO,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AREAGEO,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_AREAGEO',l_cV);");
    if ( ! (status.m_bpassedw_BANCABEN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_BANCABEN',"+SPLib.ToJSValue(status.w_BANCABEN,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_BANCABEN,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_BANCABEN',l_cV);");
    if ( ! (status.m_bpassedw_COMPORT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_COMPORT',"+SPLib.ToJSValue(status.w_COMPORT,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_COMPORT,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_COMPORT',l_cV);");
    if ( ! (status.m_bpassedw_PKTBSPECIE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PKTBSPECIE',"+SPLib.ToJSValue(status.w_PKTBSPECIE,"C",4,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PKTBSPECIE,"C",4,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PKTBSPECIE',l_cV);");
    if ( ! (status.m_bpassedw_RAREA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAREA',"+SPLib.ToJSValue(status.w_RAREA,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAREA,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RAREA',l_cV);");
    if ( ! (status.m_bpassedw_RCOMP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RCOMP',"+SPLib.ToJSValue(status.w_RCOMP,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RCOMP,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RCOMP',l_cV);");
    if ( ! (status.m_bpassedw_RNATGIU)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RNATGIU',"+SPLib.ToJSValue(status.w_RNATGIU,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RNATGIU,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RNATGIU',l_cV);");
    if ( ! (status.m_bpassedw_CITTADIN1)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CITTADIN1',"+SPLib.ToJSValue(status.w_CITTADIN1,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CITTADIN1,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CITTADIN1',l_cV);");
    if ( ! (status.m_bpassedw_CITTADIN2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CITTADIN2',"+SPLib.ToJSValue(status.w_CITTADIN2,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CITTADIN2,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CITTADIN2',l_cV);");
    if ( ! (status.m_bpassedw_RESFISC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RESFISC',"+SPLib.ToJSValue(status.w_RESFISC,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RESFISC,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RESFISC',l_cV);");
    if ( ! (status.m_bpassedw_MITIG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MITIG',"+SPLib.ToJSValue(status.w_MITIG,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MITIG,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_MITIG',l_cV);");
    if ( ! (status.m_bpassedw_MITGDOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MITGDOC',"+SPLib.ToJSValue(status.w_MITGDOC,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MITGDOC,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_MITGDOC',l_cV);");
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
    arrt_modi_aggpersR Rcalled;
    Rcalled = new arrt_modi_aggpersR(status.context,status);
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
    return new arrt_modi_aggpersR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_modi_aggpersR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_modi_aggpers"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_CONNES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNES),"?",0,0)+"");
        status.out.println("js:w_AREAGEO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AREAGEO),"?",0,0)+"");
        status.out.println("js:w_BANCABEN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_BANCABEN),"?",0,0)+"");
        status.out.println("js:w_COMPORT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_COMPORT),"?",0,0)+"");
        status.out.println("js:w_PKTBSPECIE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PKTBSPECIE),"?",0,0)+"");
        status.out.println("js:w_RAREA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAREA),"?",0,0)+"");
        status.out.println("js:w_RCOMP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RCOMP),"?",0,0)+"");
        status.out.println("js:w_RNATGIU="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RNATGIU),"?",0,0)+"");
        status.out.println("js:w_CITTADIN1="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CITTADIN1),"?",0,0)+"");
        status.out.println("js:w_CITTADIN2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CITTADIN2),"?",0,0)+"");
        status.out.println("js:w_RESFISC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RESFISC),"?",0,0)+"");
        status.out.println("js:w_MITIG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MITIG),"?",0,0)+"");
        status.out.println("js:w_MITGDOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MITGDOC),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_CONNES,null)) {");
        status.out.println("window[f].w_CONNES="+SPLib.ToJSValue(status.w_CONNES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AREAGEO,null)) {");
        status.out.println("window[f].w_AREAGEO="+SPLib.ToJSValue(status.w_AREAGEO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_BANCABEN,null)) {");
        status.out.println("window[f].w_BANCABEN="+SPLib.ToJSValue(status.w_BANCABEN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_COMPORT,null)) {");
        status.out.println("window[f].w_COMPORT="+SPLib.ToJSValue(status.w_COMPORT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PKTBSPECIE,null)) {");
        status.out.println("window[f].w_PKTBSPECIE="+SPLib.ToJSValue(status.w_PKTBSPECIE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAREA,null)) {");
        status.out.println("window[f].w_RAREA="+SPLib.ToJSValue(status.w_RAREA,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RCOMP,null)) {");
        status.out.println("window[f].w_RCOMP="+SPLib.ToJSValue(status.w_RCOMP,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RNATGIU,null)) {");
        status.out.println("window[f].w_RNATGIU="+SPLib.ToJSValue(status.w_RNATGIU,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CITTADIN1,null)) {");
        status.out.println("window[f].w_CITTADIN1="+SPLib.ToJSValue(status.w_CITTADIN1,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CITTADIN2,null)) {");
        status.out.println("window[f].w_CITTADIN2="+SPLib.ToJSValue(status.w_CITTADIN2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RESFISC,null)) {");
        status.out.println("window[f].w_RESFISC="+SPLib.ToJSValue(status.w_RESFISC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MITIG,null)) {");
        status.out.println("window[f].w_MITIG="+SPLib.ToJSValue(status.w_MITIG,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MITGDOC,null)) {");
        status.out.println("window[f].w_MITGDOC="+SPLib.ToJSValue(status.w_MITGDOC,"C",0,0)+";");
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
      arrt_modi_aggpersR Rcalled;
      Rcalled = new arrt_modi_aggpersR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_modi_aggpers");
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
