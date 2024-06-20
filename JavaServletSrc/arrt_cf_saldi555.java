import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_cf_saldi555 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*1f8e95a7*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_anno;
    public double w_anno;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_a_data;
    public java.sql.Date w_a_data;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dadata;
    public java.sql.Date w_dadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_fileprodotto;
    public String w_fileprodotto;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgann;
    public String w_flgann;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgsos;
    public String w_flgsos;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flg555;
    public String w_flg555;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_numcicli;
    public double w_numcicli;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgope;
    public String w_flgope;
    public String gMsgImp;
    public String gIntemediario;
    public String gAzienda;
    public String gPathApp;
    public String gMsgProc;
    public double _min;
    public double _max;
    public double _tot;
    public double _mono;
    public double _cicli;
    public double _contacicli;
    public double _bottom;
    public double _top;
    public double _area1;
    public double _area2;
    public String fhand;
    public String _nomefile;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public double _contaglob;
    public double _rifprog;
    public String _rif1;
    public String _rif2;
    public String _cab;
    public String _desrap;
    public String _val;
    public String _file;
    public double _ContaB;
    public double _ContaC;
    public double _i;
    public double _ContaArea1;
    public double _ContaArea2;
    public String _entra;
    public String _cfinter;
    public String _uniquecode;
    public String _prap;
    public String _codinter;
    public double _conta;
    public double _annsel;
    public String _prgdel;
    public double _contagen;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_anno = source.Has("w_anno");
      if (m_bpassedw_anno) {
        w_anno = source.GetParameter("w_anno",source.GetParameter("anno",0));
      } else {
        if (source.IsForwarded()) {
          w_anno = source.GetCaller().GetNumber("anno","N",4,0);
          m_bpassedw_anno = true;
        } else {
          w_anno = source.GetParameter("anno",source.GetParameter("w_anno",0));
        }
      }
      m_bpassedw_a_data = source.Has("w_a_data");
      if (m_bpassedw_a_data) {
        w_a_data = source.GetParameter("w_a_data",source.GetParameter("a_data",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_a_data = source.GetCaller().GetDate("a_data","D",8,0);
          m_bpassedw_a_data = true;
        } else {
          w_a_data = source.GetParameter("a_data",source.GetParameter("w_a_data",CPLib.NullDate()));
        }
      }
      m_bpassedw_dadata = source.Has("w_dadata");
      if (m_bpassedw_dadata) {
        w_dadata = source.GetParameter("w_dadata",source.GetParameter("dadata",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_dadata = source.GetCaller().GetDate("dadata","D",8,0);
          m_bpassedw_dadata = true;
        } else {
          w_dadata = source.GetParameter("dadata",source.GetParameter("w_dadata",CPLib.NullDate()));
        }
      }
      m_bpassedw_fileprodotto = source.Has("w_fileprodotto");
      if (m_bpassedw_fileprodotto) {
        w_fileprodotto = source.GetParameter("w_fileprodotto",source.GetParameter("fileprodotto",""));
      } else {
        if (source.IsForwarded()) {
          w_fileprodotto = source.GetCaller().GetString("fileprodotto","C",128,0);
          m_bpassedw_fileprodotto = true;
        } else {
          w_fileprodotto = source.GetParameter("fileprodotto",source.GetParameter("w_fileprodotto",""));
        }
      }
      m_bpassedw_flgann = source.Has("w_flgann");
      if (m_bpassedw_flgann) {
        w_flgann = source.GetParameter("w_flgann",source.GetParameter("flgann",""));
      } else {
        if (source.IsForwarded()) {
          w_flgann = source.GetCaller().GetString("flgann","C",1,0);
          m_bpassedw_flgann = true;
        } else {
          w_flgann = source.GetParameter("flgann",source.GetParameter("w_flgann",""));
        }
      }
      m_bpassedw_flgsos = source.Has("w_flgsos");
      if (m_bpassedw_flgsos) {
        w_flgsos = source.GetParameter("w_flgsos",source.GetParameter("flgsos",""));
      } else {
        if (source.IsForwarded()) {
          w_flgsos = source.GetCaller().GetString("flgsos","C",1,0);
          m_bpassedw_flgsos = true;
        } else {
          w_flgsos = source.GetParameter("flgsos",source.GetParameter("w_flgsos",""));
        }
      }
      m_bpassedw_flg555 = source.Has("w_flg555");
      if (m_bpassedw_flg555) {
        w_flg555 = source.GetParameter("w_flg555",source.GetParameter("flg555",""));
      } else {
        if (source.IsForwarded()) {
          w_flg555 = source.GetCaller().GetString("flg555","C",1,0);
          m_bpassedw_flg555 = true;
        } else {
          w_flg555 = source.GetParameter("flg555",source.GetParameter("w_flg555",""));
        }
      }
      m_bpassedw_numcicli = source.Has("w_numcicli");
      if (m_bpassedw_numcicli) {
        w_numcicli = source.GetParameter("w_numcicli",source.GetParameter("numcicli",0));
      } else {
        if (source.IsForwarded()) {
          w_numcicli = source.GetCaller().GetNumber("numcicli","N",2,0);
          m_bpassedw_numcicli = true;
        } else {
          w_numcicli = source.GetParameter("numcicli",source.GetParameter("w_numcicli",0));
        }
      }
      m_bpassedw_flgope = source.Has("w_flgope");
      if (m_bpassedw_flgope) {
        w_flgope = source.GetParameter("w_flgope",source.GetParameter("flgope",""));
      } else {
        if (source.IsForwarded()) {
          w_flgope = source.GetCaller().GetString("flgope","C",0,0);
          m_bpassedw_flgope = true;
        } else {
          w_flgope = source.GetParameter("flgope",source.GetParameter("w_flgope",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_cf_saldi555";
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
    return  ! (status.m_bpassedw_flgope) ||  ! (status.m_bpassedw_numcicli) ||  ! (status.m_bpassedw_flg555) ||  ! (status.m_bpassedw_flgsos) ||  ! (status.m_bpassedw_flgann) ||  ! (status.m_bpassedw_fileprodotto) ||  ! (status.m_bpassedw_dadata) ||  ! (status.m_bpassedw_a_data) ||  ! (status.m_bpassedw_anno);
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
    if ( ! (status.m_bpassedw_anno)) {
      status.out.println("l_cV=WtA(l_oWnd('w_anno',"+SPLib.ToJSValue(status.w_anno,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_anno,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_anno',l_cV);");
    if ( ! (status.m_bpassedw_a_data)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_a_data',"+SPLib.ToJSValue(status.w_a_data,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_a_data,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_a_data',l_cV);");
    if ( ! (status.m_bpassedw_dadata)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_dadata',"+SPLib.ToJSValue(status.w_dadata,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dadata,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_dadata',l_cV);");
    if ( ! (status.m_bpassedw_fileprodotto)) {
      status.out.println("l_cV=WtA(l_oWnd('w_fileprodotto',"+SPLib.ToJSValue(status.w_fileprodotto,"C",128,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_fileprodotto,"C",128,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_fileprodotto',l_cV);");
    if ( ! (status.m_bpassedw_flgann)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgann',"+SPLib.ToJSValue(status.w_flgann,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgann,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgann',l_cV);");
    if ( ! (status.m_bpassedw_flgsos)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgsos',"+SPLib.ToJSValue(status.w_flgsos,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgsos,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgsos',l_cV);");
    if ( ! (status.m_bpassedw_flg555)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flg555',"+SPLib.ToJSValue(status.w_flg555,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flg555,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flg555',l_cV);");
    if ( ! (status.m_bpassedw_numcicli)) {
      status.out.println("l_cV=WtA(l_oWnd('w_numcicli',"+SPLib.ToJSValue(status.w_numcicli,"N",2,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_numcicli,"N",2,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_numcicli',l_cV);");
    if ( ! (status.m_bpassedw_flgope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgope',"+SPLib.ToJSValue(status.w_flgope,"C",0,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgope,"C",0,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgope',l_cV);");
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
    arrt_cf_saldi555R Rcalled;
    Rcalled = new arrt_cf_saldi555R(status.context,status);
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
    return new arrt_cf_saldi555R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_cf_saldi555R Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_cf_saldi555"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_anno="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_anno),"?",0,0)+"");
        status.out.println("js:w_a_data="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_a_data),"?",0,0)+"");
        status.out.println("js:w_dadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dadata),"?",0,0)+"");
        status.out.println("js:w_fileprodotto="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_fileprodotto),"?",0,0)+"");
        status.out.println("js:w_flgann="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgann),"?",0,0)+"");
        status.out.println("js:w_flgsos="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgsos),"?",0,0)+"");
        status.out.println("js:w_flg555="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flg555),"?",0,0)+"");
        status.out.println("js:w_numcicli="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_numcicli),"?",0,0)+"");
        status.out.println("js:w_flgope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgope),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_anno,null)) {");
        status.out.println("window[f].w_anno="+SPLib.ToJSValue(status.w_anno,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_a_data,null)) {");
        status.out.println(" window[f].w_a_data.setTime(("+SPLib.ToJSValue(status.w_a_data,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_dadata,null)) {");
        status.out.println(" window[f].w_dadata.setTime(("+SPLib.ToJSValue(status.w_dadata,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_fileprodotto,null)) {");
        status.out.println("window[f].w_fileprodotto="+SPLib.ToJSValue(status.w_fileprodotto,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgann,null)) {");
        status.out.println("window[f].w_flgann="+SPLib.ToJSValue(status.w_flgann,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgsos,null)) {");
        status.out.println("window[f].w_flgsos="+SPLib.ToJSValue(status.w_flgsos,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flg555,null)) {");
        status.out.println("window[f].w_flg555="+SPLib.ToJSValue(status.w_flg555,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_numcicli,null)) {");
        status.out.println("window[f].w_numcicli="+SPLib.ToJSValue(status.w_numcicli,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgope,null)) {");
        status.out.println("window[f].w_flgope="+SPLib.ToJSValue(status.w_flgope,"C",0,0)+";");
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
      arrt_cf_saldi555R Rcalled;
      Rcalled = new arrt_cf_saldi555R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_cf_saldi555");
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
