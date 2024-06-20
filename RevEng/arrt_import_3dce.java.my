import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_import_3dce extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*2b471993*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_msgproc;
    public String w_msgproc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbareegeog;
    public String w_tbareegeog;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbspecie;
    public String w_tbspecie;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbtiporisc;
    public String w_tbtiporisc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbsvolgim;
    public String w_tbsvolgim;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbcondotta;
    public String w_tbcondotta;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbimporto;
    public String w_tbimporto;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbdurata;
    public String w_tbdurata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbplauso;
    public String w_tbplauso;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tbtipatt;
    public String w_tbtipatt;
    public String fhand;
    public String riga;
    public String _flgpers;
    public String _code5;
    public String _code4;
    public String _code3;
    public String _code10;
    public String gMsgImp;
    public String gMsgProc;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_msgproc = source.Has("w_msgproc");
      if (m_bpassedw_msgproc) {
        w_msgproc = source.GetParameter("w_msgproc",source.GetParameter("msgproc",""));
      } else {
        if (source.IsForwarded()) {
          w_msgproc = source.GetCaller().GetString("msgproc","M",10,0);
          m_bpassedw_msgproc = true;
        } else {
          w_msgproc = source.GetParameter("msgproc",source.GetParameter("w_msgproc",""));
        }
      }
      m_bpassedw_tbareegeog = source.Has("w_tbareegeog");
      if (m_bpassedw_tbareegeog) {
        w_tbareegeog = source.GetParameter("w_tbareegeog",source.GetParameter("tbareegeog",""));
      } else {
        if (source.IsForwarded()) {
          w_tbareegeog = source.GetCaller().GetString("tbareegeog","C",1,0);
          m_bpassedw_tbareegeog = true;
        } else {
          w_tbareegeog = source.GetParameter("tbareegeog",source.GetParameter("w_tbareegeog",""));
        }
      }
      m_bpassedw_tbspecie = source.Has("w_tbspecie");
      if (m_bpassedw_tbspecie) {
        w_tbspecie = source.GetParameter("w_tbspecie",source.GetParameter("tbspecie",""));
      } else {
        if (source.IsForwarded()) {
          w_tbspecie = source.GetCaller().GetString("tbspecie","C",1,0);
          m_bpassedw_tbspecie = true;
        } else {
          w_tbspecie = source.GetParameter("tbspecie",source.GetParameter("w_tbspecie",""));
        }
      }
      m_bpassedw_tbtiporisc = source.Has("w_tbtiporisc");
      if (m_bpassedw_tbtiporisc) {
        w_tbtiporisc = source.GetParameter("w_tbtiporisc",source.GetParameter("tbtiporisc",""));
      } else {
        if (source.IsForwarded()) {
          w_tbtiporisc = source.GetCaller().GetString("tbtiporisc","C",1,0);
          m_bpassedw_tbtiporisc = true;
        } else {
          w_tbtiporisc = source.GetParameter("tbtiporisc",source.GetParameter("w_tbtiporisc",""));
        }
      }
      m_bpassedw_tbsvolgim = source.Has("w_tbsvolgim");
      if (m_bpassedw_tbsvolgim) {
        w_tbsvolgim = source.GetParameter("w_tbsvolgim",source.GetParameter("tbsvolgim",""));
      } else {
        if (source.IsForwarded()) {
          w_tbsvolgim = source.GetCaller().GetString("tbsvolgim","C",1,0);
          m_bpassedw_tbsvolgim = true;
        } else {
          w_tbsvolgim = source.GetParameter("tbsvolgim",source.GetParameter("w_tbsvolgim",""));
        }
      }
      m_bpassedw_tbcondotta = source.Has("w_tbcondotta");
      if (m_bpassedw_tbcondotta) {
        w_tbcondotta = source.GetParameter("w_tbcondotta",source.GetParameter("tbcondotta",""));
      } else {
        if (source.IsForwarded()) {
          w_tbcondotta = source.GetCaller().GetString("tbcondotta","C",1,0);
          m_bpassedw_tbcondotta = true;
        } else {
          w_tbcondotta = source.GetParameter("tbcondotta",source.GetParameter("w_tbcondotta",""));
        }
      }
      m_bpassedw_tbimporto = source.Has("w_tbimporto");
      if (m_bpassedw_tbimporto) {
        w_tbimporto = source.GetParameter("w_tbimporto",source.GetParameter("tbimporto",""));
      } else {
        if (source.IsForwarded()) {
          w_tbimporto = source.GetCaller().GetString("tbimporto","C",1,0);
          m_bpassedw_tbimporto = true;
        } else {
          w_tbimporto = source.GetParameter("tbimporto",source.GetParameter("w_tbimporto",""));
        }
      }
      m_bpassedw_tbdurata = source.Has("w_tbdurata");
      if (m_bpassedw_tbdurata) {
        w_tbdurata = source.GetParameter("w_tbdurata",source.GetParameter("tbdurata",""));
      } else {
        if (source.IsForwarded()) {
          w_tbdurata = source.GetCaller().GetString("tbdurata","C",1,0);
          m_bpassedw_tbdurata = true;
        } else {
          w_tbdurata = source.GetParameter("tbdurata",source.GetParameter("w_tbdurata",""));
        }
      }
      m_bpassedw_tbplauso = source.Has("w_tbplauso");
      if (m_bpassedw_tbplauso) {
        w_tbplauso = source.GetParameter("w_tbplauso",source.GetParameter("tbplauso",""));
      } else {
        if (source.IsForwarded()) {
          w_tbplauso = source.GetCaller().GetString("tbplauso","C",1,0);
          m_bpassedw_tbplauso = true;
        } else {
          w_tbplauso = source.GetParameter("tbplauso",source.GetParameter("w_tbplauso",""));
        }
      }
      m_bpassedw_tbtipatt = source.Has("w_tbtipatt");
      if (m_bpassedw_tbtipatt) {
        w_tbtipatt = source.GetParameter("w_tbtipatt",source.GetParameter("tbtipatt",""));
      } else {
        if (source.IsForwarded()) {
          w_tbtipatt = source.GetCaller().GetString("tbtipatt","C",1,0);
          m_bpassedw_tbtipatt = true;
        } else {
          w_tbtipatt = source.GetParameter("tbtipatt",source.GetParameter("w_tbtipatt",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_import_3dce";
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
    return  ! (status.m_bpassedw_tbtipatt) ||  ! (status.m_bpassedw_tbplauso) ||  ! (status.m_bpassedw_tbdurata) ||  ! (status.m_bpassedw_tbimporto) ||  ! (status.m_bpassedw_tbcondotta) ||  ! (status.m_bpassedw_tbsvolgim) ||  ! (status.m_bpassedw_tbtiporisc) ||  ! (status.m_bpassedw_tbspecie) ||  ! (status.m_bpassedw_tbareegeog) ||  ! (status.m_bpassedw_msgproc);
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
    if ( ! (status.m_bpassedw_msgproc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_msgproc',"+SPLib.ToJSValue(status.w_msgproc,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_msgproc,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_msgproc',l_cV);");
    if ( ! (status.m_bpassedw_tbareegeog)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbareegeog',"+SPLib.ToJSValue(status.w_tbareegeog,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbareegeog,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbareegeog',l_cV);");
    if ( ! (status.m_bpassedw_tbspecie)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbspecie',"+SPLib.ToJSValue(status.w_tbspecie,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbspecie,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbspecie',l_cV);");
    if ( ! (status.m_bpassedw_tbtiporisc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbtiporisc',"+SPLib.ToJSValue(status.w_tbtiporisc,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtiporisc,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbtiporisc',l_cV);");
    if ( ! (status.m_bpassedw_tbsvolgim)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbsvolgim',"+SPLib.ToJSValue(status.w_tbsvolgim,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbsvolgim,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbsvolgim',l_cV);");
    if ( ! (status.m_bpassedw_tbcondotta)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbcondotta',"+SPLib.ToJSValue(status.w_tbcondotta,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbcondotta,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbcondotta',l_cV);");
    if ( ! (status.m_bpassedw_tbimporto)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbimporto',"+SPLib.ToJSValue(status.w_tbimporto,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbimporto,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbimporto',l_cV);");
    if ( ! (status.m_bpassedw_tbdurata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbdurata',"+SPLib.ToJSValue(status.w_tbdurata,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbdurata,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbdurata',l_cV);");
    if ( ! (status.m_bpassedw_tbplauso)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbplauso',"+SPLib.ToJSValue(status.w_tbplauso,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbplauso,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbplauso',l_cV);");
    if ( ! (status.m_bpassedw_tbtipatt)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tbtipatt',"+SPLib.ToJSValue(status.w_tbtipatt,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtipatt,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tbtipatt',l_cV);");
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
    arrt_import_3dceR Rcalled;
    Rcalled = new arrt_import_3dceR(status.context,status);
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
    return new arrt_import_3dceR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_import_3dceR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_import_3dce"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_msgproc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_msgproc),"?",0,0)+"");
        status.out.println("js:w_tbareegeog="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbareegeog),"?",0,0)+"");
        status.out.println("js:w_tbspecie="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbspecie),"?",0,0)+"");
        status.out.println("js:w_tbtiporisc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbtiporisc),"?",0,0)+"");
        status.out.println("js:w_tbsvolgim="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbsvolgim),"?",0,0)+"");
        status.out.println("js:w_tbcondotta="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbcondotta),"?",0,0)+"");
        status.out.println("js:w_tbimporto="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbimporto),"?",0,0)+"");
        status.out.println("js:w_tbdurata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbdurata),"?",0,0)+"");
        status.out.println("js:w_tbplauso="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbplauso),"?",0,0)+"");
        status.out.println("js:w_tbtipatt="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tbtipatt),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_msgproc,null)) {");
        status.out.println("window[f].w_msgproc="+SPLib.ToJSValue(status.w_msgproc,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbareegeog,null)) {");
        status.out.println("window[f].w_tbareegeog="+SPLib.ToJSValue(status.w_tbareegeog,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbspecie,null)) {");
        status.out.println("window[f].w_tbspecie="+SPLib.ToJSValue(status.w_tbspecie,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbtiporisc,null)) {");
        status.out.println("window[f].w_tbtiporisc="+SPLib.ToJSValue(status.w_tbtiporisc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbsvolgim,null)) {");
        status.out.println("window[f].w_tbsvolgim="+SPLib.ToJSValue(status.w_tbsvolgim,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbcondotta,null)) {");
        status.out.println("window[f].w_tbcondotta="+SPLib.ToJSValue(status.w_tbcondotta,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbimporto,null)) {");
        status.out.println("window[f].w_tbimporto="+SPLib.ToJSValue(status.w_tbimporto,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbdurata,null)) {");
        status.out.println("window[f].w_tbdurata="+SPLib.ToJSValue(status.w_tbdurata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbplauso,null)) {");
        status.out.println("window[f].w_tbplauso="+SPLib.ToJSValue(status.w_tbplauso,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tbtipatt,null)) {");
        status.out.println("window[f].w_tbtipatt="+SPLib.ToJSValue(status.w_tbtipatt,"C",0,0)+";");
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
      arrt_import_3dceR Rcalled;
      Rcalled = new arrt_import_3dceR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_import_3dce");
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
