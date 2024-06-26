import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_modopen2 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*b7fc67e4*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datarett;
    public java.sql.Date w_datarett;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_newcoint;
    public String w_newcoint;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_newtipoag;
    public String w_newtipoag;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldcoint;
    public String w_oldcoint;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldfile;
    public String w_oldfile;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldidbase;
    public String w_oldidbase;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldprog;
    public String w_oldprog;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldrappo;
    public String w_oldrappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldrnumrig;
    public double w_oldrnumrig;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldtipoag;
    public String w_oldtipoag;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ragione;
    public String w_ragione;
    public String gAzienda;
    public String _coint;
    public String _tipage;
    public String _rifana;
    public String cProg;
    public String cIDBase;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_datarett = source.Has("w_datarett");
      if (m_bpassedw_datarett) {
        w_datarett = source.GetParameter("w_datarett",source.GetParameter("datarett",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datarett = source.GetCaller().GetDate("datarett","D",8,0);
          m_bpassedw_datarett = true;
        } else {
          w_datarett = source.GetParameter("datarett",source.GetParameter("w_datarett",CPLib.NullDate()));
        }
      }
      m_bpassedw_newcoint = source.Has("w_newcoint");
      if (m_bpassedw_newcoint) {
        w_newcoint = source.GetParameter("w_newcoint",source.GetParameter("newcoint",""));
      } else {
        if (source.IsForwarded()) {
          w_newcoint = source.GetCaller().GetString("newcoint","C",1,0);
          m_bpassedw_newcoint = true;
        } else {
          w_newcoint = source.GetParameter("newcoint",source.GetParameter("w_newcoint",""));
        }
      }
      m_bpassedw_newtipoag = source.Has("w_newtipoag");
      if (m_bpassedw_newtipoag) {
        w_newtipoag = source.GetParameter("w_newtipoag",source.GetParameter("newtipoag",""));
      } else {
        if (source.IsForwarded()) {
          w_newtipoag = source.GetCaller().GetString("newtipoag","C",2,0);
          m_bpassedw_newtipoag = true;
        } else {
          w_newtipoag = source.GetParameter("newtipoag",source.GetParameter("w_newtipoag",""));
        }
      }
      m_bpassedw_oldcoint = source.Has("w_oldcoint");
      if (m_bpassedw_oldcoint) {
        w_oldcoint = source.GetParameter("w_oldcoint",source.GetParameter("oldcoint",""));
      } else {
        if (source.IsForwarded()) {
          w_oldcoint = source.GetCaller().GetString("oldcoint","C",1,0);
          m_bpassedw_oldcoint = true;
        } else {
          w_oldcoint = source.GetParameter("oldcoint",source.GetParameter("w_oldcoint",""));
        }
      }
      m_bpassedw_oldfile = source.Has("w_oldfile");
      if (m_bpassedw_oldfile) {
        w_oldfile = source.GetParameter("w_oldfile",source.GetParameter("oldfile",""));
      } else {
        if (source.IsForwarded()) {
          w_oldfile = source.GetCaller().GetString("oldfile","C",15,0);
          m_bpassedw_oldfile = true;
        } else {
          w_oldfile = source.GetParameter("oldfile",source.GetParameter("w_oldfile",""));
        }
      }
      m_bpassedw_oldidbase = source.Has("w_oldidbase");
      if (m_bpassedw_oldidbase) {
        w_oldidbase = source.GetParameter("w_oldidbase",source.GetParameter("oldidbase",""));
      } else {
        if (source.IsForwarded()) {
          w_oldidbase = source.GetCaller().GetString("oldidbase","C",10,0);
          m_bpassedw_oldidbase = true;
        } else {
          w_oldidbase = source.GetParameter("oldidbase",source.GetParameter("w_oldidbase",""));
        }
      }
      m_bpassedw_oldprog = source.Has("w_oldprog");
      if (m_bpassedw_oldprog) {
        w_oldprog = source.GetParameter("w_oldprog",source.GetParameter("oldprog",""));
      } else {
        if (source.IsForwarded()) {
          w_oldprog = source.GetCaller().GetString("oldprog","C",15,0);
          m_bpassedw_oldprog = true;
        } else {
          w_oldprog = source.GetParameter("oldprog",source.GetParameter("w_oldprog",""));
        }
      }
      m_bpassedw_oldrappo = source.Has("w_oldrappo");
      if (m_bpassedw_oldrappo) {
        w_oldrappo = source.GetParameter("w_oldrappo",source.GetParameter("oldrappo",""));
      } else {
        if (source.IsForwarded()) {
          w_oldrappo = source.GetCaller().GetString("oldrappo","C",25,0);
          m_bpassedw_oldrappo = true;
        } else {
          w_oldrappo = source.GetParameter("oldrappo",source.GetParameter("w_oldrappo",""));
        }
      }
      m_bpassedw_oldrnumrig = source.Has("w_oldrnumrig");
      if (m_bpassedw_oldrnumrig) {
        w_oldrnumrig = source.GetParameter("w_oldrnumrig",source.GetParameter("oldrnumrig",0));
      } else {
        if (source.IsForwarded()) {
          w_oldrnumrig = source.GetCaller().GetNumber("oldrnumrig","N",10,0);
          m_bpassedw_oldrnumrig = true;
        } else {
          w_oldrnumrig = source.GetParameter("oldrnumrig",source.GetParameter("w_oldrnumrig",0));
        }
      }
      m_bpassedw_oldtipoag = source.Has("w_oldtipoag");
      if (m_bpassedw_oldtipoag) {
        w_oldtipoag = source.GetParameter("w_oldtipoag",source.GetParameter("oldtipoag",""));
      } else {
        if (source.IsForwarded()) {
          w_oldtipoag = source.GetCaller().GetString("oldtipoag","C",2,0);
          m_bpassedw_oldtipoag = true;
        } else {
          w_oldtipoag = source.GetParameter("oldtipoag",source.GetParameter("w_oldtipoag",""));
        }
      }
      m_bpassedw_ragione = source.Has("w_ragione");
      if (m_bpassedw_ragione) {
        w_ragione = source.GetParameter("w_ragione",source.GetParameter("ragione",""));
      } else {
        if (source.IsForwarded()) {
          w_ragione = source.GetCaller().GetString("ragione","C",1,0);
          m_bpassedw_ragione = true;
        } else {
          w_ragione = source.GetParameter("ragione",source.GetParameter("w_ragione",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_modopen2";
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
    return  ! (status.m_bpassedw_ragione) ||  ! (status.m_bpassedw_oldtipoag) ||  ! (status.m_bpassedw_oldrnumrig) ||  ! (status.m_bpassedw_oldrappo) ||  ! (status.m_bpassedw_oldprog) ||  ! (status.m_bpassedw_oldidbase) ||  ! (status.m_bpassedw_oldfile) ||  ! (status.m_bpassedw_oldcoint) ||  ! (status.m_bpassedw_newtipoag) ||  ! (status.m_bpassedw_newcoint) ||  ! (status.m_bpassedw_datarett);
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
    if ( ! (status.m_bpassedw_datarett)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datarett',"+SPLib.ToJSValue(status.w_datarett,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datarett,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datarett',l_cV);");
    if ( ! (status.m_bpassedw_newcoint)) {
      status.out.println("l_cV=WtA(l_oWnd('w_newcoint',"+SPLib.ToJSValue(status.w_newcoint,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_newcoint,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_newcoint',l_cV);");
    if ( ! (status.m_bpassedw_newtipoag)) {
      status.out.println("l_cV=WtA(l_oWnd('w_newtipoag',"+SPLib.ToJSValue(status.w_newtipoag,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_newtipoag,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_newtipoag',l_cV);");
    if ( ! (status.m_bpassedw_oldcoint)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldcoint',"+SPLib.ToJSValue(status.w_oldcoint,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldcoint,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldcoint',l_cV);");
    if ( ! (status.m_bpassedw_oldfile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldfile',"+SPLib.ToJSValue(status.w_oldfile,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldfile,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldfile',l_cV);");
    if ( ! (status.m_bpassedw_oldidbase)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldidbase',"+SPLib.ToJSValue(status.w_oldidbase,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldidbase,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldidbase',l_cV);");
    if ( ! (status.m_bpassedw_oldprog)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldprog',"+SPLib.ToJSValue(status.w_oldprog,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldprog,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldprog',l_cV);");
    if ( ! (status.m_bpassedw_oldrappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldrappo',"+SPLib.ToJSValue(status.w_oldrappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldrappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldrappo',l_cV);");
    if ( ! (status.m_bpassedw_oldrnumrig)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldrnumrig',"+SPLib.ToJSValue(status.w_oldrnumrig,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldrnumrig,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_oldrnumrig',l_cV);");
    if ( ! (status.m_bpassedw_oldtipoag)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldtipoag',"+SPLib.ToJSValue(status.w_oldtipoag,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldtipoag,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldtipoag',l_cV);");
    if ( ! (status.m_bpassedw_ragione)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ragione',"+SPLib.ToJSValue(status.w_ragione,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragione,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ragione',l_cV);");
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
    arrt_modopen2R Rcalled;
    Rcalled = new arrt_modopen2R(status.context,status);
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
    return new arrt_modopen2R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_modopen2R Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_modopen2"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_datarett="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datarett),"?",0,0)+"");
        status.out.println("js:w_newcoint="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_newcoint),"?",0,0)+"");
        status.out.println("js:w_newtipoag="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_newtipoag),"?",0,0)+"");
        status.out.println("js:w_oldcoint="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldcoint),"?",0,0)+"");
        status.out.println("js:w_oldfile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldfile),"?",0,0)+"");
        status.out.println("js:w_oldidbase="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldidbase),"?",0,0)+"");
        status.out.println("js:w_oldprog="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldprog),"?",0,0)+"");
        status.out.println("js:w_oldrappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldrappo),"?",0,0)+"");
        status.out.println("js:w_oldrnumrig="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldrnumrig),"?",0,0)+"");
        status.out.println("js:w_oldtipoag="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldtipoag),"?",0,0)+"");
        status.out.println("js:w_ragione="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ragione),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_datarett,null)) {");
        status.out.println(" window[f].w_datarett.setTime(("+SPLib.ToJSValue(status.w_datarett,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_newcoint,null)) {");
        status.out.println("window[f].w_newcoint="+SPLib.ToJSValue(status.w_newcoint,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_newtipoag,null)) {");
        status.out.println("window[f].w_newtipoag="+SPLib.ToJSValue(status.w_newtipoag,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldcoint,null)) {");
        status.out.println("window[f].w_oldcoint="+SPLib.ToJSValue(status.w_oldcoint,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldfile,null)) {");
        status.out.println("window[f].w_oldfile="+SPLib.ToJSValue(status.w_oldfile,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldidbase,null)) {");
        status.out.println("window[f].w_oldidbase="+SPLib.ToJSValue(status.w_oldidbase,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldprog,null)) {");
        status.out.println("window[f].w_oldprog="+SPLib.ToJSValue(status.w_oldprog,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldrappo,null)) {");
        status.out.println("window[f].w_oldrappo="+SPLib.ToJSValue(status.w_oldrappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldrnumrig,null)) {");
        status.out.println("window[f].w_oldrnumrig="+SPLib.ToJSValue(status.w_oldrnumrig,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldtipoag,null)) {");
        status.out.println("window[f].w_oldtipoag="+SPLib.ToJSValue(status.w_oldtipoag,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ragione,null)) {");
        status.out.println("window[f].w_ragione="+SPLib.ToJSValue(status.w_ragione,"C",0,0)+";");
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
      arrt_modopen2R Rcalled;
      Rcalled = new arrt_modopen2R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_modopen2");
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
