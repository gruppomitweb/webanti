import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_dlgspecifici extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*b4ce02b5*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codinter;
    public String w_codinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipinter;
    public String w_tipinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgint;
    public String w_flgint;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgrae;
    public String w_flgrae;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgsto;
    public String w_flgsto;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgdel;
    public String w_flgdel;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_passwd;
    public String w_passwd;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipofile;
    public String w_tipofile;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_numreg;
    public double w_numreg;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_numrec;
    public double w_numrec;
    public String gPathApp;
    public String gIntemediario;
    public String gUrlApp;
    public String gAzienda;
    public double gNumRec;
    public double gNumReg;
    public String gMsgImp;
    public String gMsgProc;
    public String gFlgWU;
    public String w_codcab;
    public String w_cabcod;
    public String w_desccit;
    public String w_citdesc;
    public String w_provin;
    public String w_provind;
    public String w_coddipe;
    public String _note;
    public String fhand;
    public String _nomefile;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public double nTotRec;
    public double nTotReg;
    public double nNumRec;
    public double _avanza;
    public String _codrif;
    public String w_cdadata;
    public String w_c_adata;
    public String w_cdadata_rap;
    public String w_c_adata_rap;
    public double _ctotale;
    public double _conta;
    public double _max;
    public double _min;
    public double _top;
    public double _bottom;
    public double _cicli;
    public double _contacilci;
    public String _flagrap;
    public double _ciclo;
    public String _ramate;
    public String _numsto;
    public double _oldrighe;
    public double _continua;
    public String _oldrap;
    public String _idereg;
    public String xStato;
    public double _conta1;
    public double _conta2;
    public double _conta4;
    public double _conta5;
    public double _conta6;
    public double _conta7;
    public double _conta8;
    public double _conta9;
    public String w_codage;
    public String w_codcli;
    public String w_ragben;
    public String _raeatc;
    public double _rownum;
    public String _tiprec;
    public String _tipoag;
    public String _datage;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_codinter = source.Has("w_codinter");
      if (m_bpassedw_codinter) {
        w_codinter = source.GetParameter("w_codinter",source.GetParameter("codinter",""));
      } else {
        if (source.IsForwarded()) {
          w_codinter = source.GetCaller().GetString("codinter","C",11,0);
          m_bpassedw_codinter = true;
        } else {
          w_codinter = source.GetParameter("codinter",source.GetParameter("w_codinter",""));
        }
      }
      m_bpassedw_tipinter = source.Has("w_tipinter");
      if (m_bpassedw_tipinter) {
        w_tipinter = source.GetParameter("w_tipinter",source.GetParameter("tipinter",""));
      } else {
        if (source.IsForwarded()) {
          w_tipinter = source.GetCaller().GetString("tipinter","C",2,0);
          m_bpassedw_tipinter = true;
        } else {
          w_tipinter = source.GetParameter("tipinter",source.GetParameter("w_tipinter",""));
        }
      }
      m_bpassedw_flgint = source.Has("w_flgint");
      if (m_bpassedw_flgint) {
        w_flgint = source.GetParameter("w_flgint",source.GetParameter("flgint",""));
      } else {
        if (source.IsForwarded()) {
          w_flgint = source.GetCaller().GetString("flgint","C",1,0);
          m_bpassedw_flgint = true;
        } else {
          w_flgint = source.GetParameter("flgint",source.GetParameter("w_flgint",""));
        }
      }
      m_bpassedw_flgrae = source.Has("w_flgrae");
      if (m_bpassedw_flgrae) {
        w_flgrae = source.GetParameter("w_flgrae",source.GetParameter("flgrae",""));
      } else {
        if (source.IsForwarded()) {
          w_flgrae = source.GetCaller().GetString("flgrae","C",1,0);
          m_bpassedw_flgrae = true;
        } else {
          w_flgrae = source.GetParameter("flgrae",source.GetParameter("w_flgrae",""));
        }
      }
      m_bpassedw_flgsto = source.Has("w_flgsto");
      if (m_bpassedw_flgsto) {
        w_flgsto = source.GetParameter("w_flgsto",source.GetParameter("flgsto",""));
      } else {
        if (source.IsForwarded()) {
          w_flgsto = source.GetCaller().GetString("flgsto","C",1,0);
          m_bpassedw_flgsto = true;
        } else {
          w_flgsto = source.GetParameter("flgsto",source.GetParameter("w_flgsto",""));
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
      m_bpassedw_passwd = source.Has("w_passwd");
      if (m_bpassedw_passwd) {
        w_passwd = source.GetParameter("w_passwd",source.GetParameter("passwd",""));
      } else {
        if (source.IsForwarded()) {
          w_passwd = source.GetCaller().GetString("passwd","C",20,0);
          m_bpassedw_passwd = true;
        } else {
          w_passwd = source.GetParameter("passwd",source.GetParameter("w_passwd",""));
        }
      }
      m_bpassedw_tipofile = source.Has("w_tipofile");
      if (m_bpassedw_tipofile) {
        w_tipofile = source.GetParameter("w_tipofile",source.GetParameter("tipofile",""));
      } else {
        if (source.IsForwarded()) {
          w_tipofile = source.GetCaller().GetString("tipofile","C",1,0);
          m_bpassedw_tipofile = true;
        } else {
          w_tipofile = source.GetParameter("tipofile",source.GetParameter("w_tipofile",""));
        }
      }
      m_bpassedw_numreg = source.Has("w_numreg");
      if (m_bpassedw_numreg) {
        w_numreg = source.GetParameter("w_numreg",source.GetParameter("numreg",0));
      } else {
        if (source.IsForwarded()) {
          w_numreg = source.GetCaller().GetNumber("numreg","N",15,0);
          m_bpassedw_numreg = true;
        } else {
          w_numreg = source.GetParameter("numreg",source.GetParameter("w_numreg",0));
        }
      }
      m_bpassedw_numrec = source.Has("w_numrec");
      if (m_bpassedw_numrec) {
        w_numrec = source.GetParameter("w_numrec",source.GetParameter("numrec",0));
      } else {
        if (source.IsForwarded()) {
          w_numrec = source.GetCaller().GetNumber("numrec","N",15,0);
          m_bpassedw_numrec = true;
        } else {
          w_numrec = source.GetParameter("numrec",source.GetParameter("w_numrec",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_dlgspecifici";
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
    return  ! (status.m_bpassedw_numrec) ||  ! (status.m_bpassedw_numreg) ||  ! (status.m_bpassedw_tipofile) ||  ! (status.m_bpassedw_passwd) ||  ! (status.m_bpassedw_flgdel) ||  ! (status.m_bpassedw_flgsto) ||  ! (status.m_bpassedw_flgrae) ||  ! (status.m_bpassedw_flgint) ||  ! (status.m_bpassedw_tipinter) ||  ! (status.m_bpassedw_codinter);
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
    if ( ! (status.m_bpassedw_codinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codinter',"+SPLib.ToJSValue(status.w_codinter,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codinter,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codinter',l_cV);");
    if ( ! (status.m_bpassedw_tipinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipinter',"+SPLib.ToJSValue(status.w_tipinter,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipinter,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipinter',l_cV);");
    if ( ! (status.m_bpassedw_flgint)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgint',"+SPLib.ToJSValue(status.w_flgint,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgint,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgint',l_cV);");
    if ( ! (status.m_bpassedw_flgrae)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgrae',"+SPLib.ToJSValue(status.w_flgrae,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgrae,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgrae',l_cV);");
    if ( ! (status.m_bpassedw_flgsto)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgsto',"+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgsto',l_cV);");
    if ( ! (status.m_bpassedw_flgdel)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgdel',"+SPLib.ToJSValue(status.w_flgdel,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgdel,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgdel',l_cV);");
    if ( ! (status.m_bpassedw_passwd)) {
      status.out.println("l_cV=WtA(l_oWnd('w_passwd',"+SPLib.ToJSValue(status.w_passwd,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_passwd,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_passwd',l_cV);");
    if ( ! (status.m_bpassedw_tipofile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipofile',"+SPLib.ToJSValue(status.w_tipofile,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipofile,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipofile',l_cV);");
    if ( ! (status.m_bpassedw_numreg)) {
      status.out.println("l_cV=WtA(l_oWnd('w_numreg',"+SPLib.ToJSValue(status.w_numreg,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_numreg,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_numreg',l_cV);");
    if ( ! (status.m_bpassedw_numrec)) {
      status.out.println("l_cV=WtA(l_oWnd('w_numrec',"+SPLib.ToJSValue(status.w_numrec,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_numrec,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_numrec',l_cV);");
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
    arrt_dlgspecificiR Rcalled;
    Rcalled = new arrt_dlgspecificiR(status.context,status);
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
    return new arrt_dlgspecificiR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_dlgspecificiR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_dlgspecifici"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_codinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codinter),"?",0,0)+"");
        status.out.println("js:w_tipinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipinter),"?",0,0)+"");
        status.out.println("js:w_flgint="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgint),"?",0,0)+"");
        status.out.println("js:w_flgrae="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgrae),"?",0,0)+"");
        status.out.println("js:w_flgsto="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgsto),"?",0,0)+"");
        status.out.println("js:w_flgdel="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgdel),"?",0,0)+"");
        status.out.println("js:w_passwd="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_passwd),"?",0,0)+"");
        status.out.println("js:w_tipofile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipofile),"?",0,0)+"");
        status.out.println("js:w_numreg="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_numreg),"?",0,0)+"");
        status.out.println("js:w_numrec="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_numrec),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_codinter,null)) {");
        status.out.println("window[f].w_codinter="+SPLib.ToJSValue(status.w_codinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipinter,null)) {");
        status.out.println("window[f].w_tipinter="+SPLib.ToJSValue(status.w_tipinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgint,null)) {");
        status.out.println("window[f].w_flgint="+SPLib.ToJSValue(status.w_flgint,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgrae,null)) {");
        status.out.println("window[f].w_flgrae="+SPLib.ToJSValue(status.w_flgrae,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgsto,null)) {");
        status.out.println("window[f].w_flgsto="+SPLib.ToJSValue(status.w_flgsto,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgdel,null)) {");
        status.out.println("window[f].w_flgdel="+SPLib.ToJSValue(status.w_flgdel,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_passwd,null)) {");
        status.out.println("window[f].w_passwd="+SPLib.ToJSValue(status.w_passwd,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipofile,null)) {");
        status.out.println("window[f].w_tipofile="+SPLib.ToJSValue(status.w_tipofile,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_numreg,null)) {");
        status.out.println("window[f].w_numreg="+SPLib.ToJSValue(status.w_numreg,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_numrec,null)) {");
        status.out.println("window[f].w_numrec="+SPLib.ToJSValue(status.w_numrec,"N",0,0)+";");
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
      arrt_dlgspecificiR Rcalled;
      Rcalled = new arrt_dlgspecificiR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_dlgspecifici");
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
