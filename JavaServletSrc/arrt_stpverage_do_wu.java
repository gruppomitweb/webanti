import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_stpverage_do_wu extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*63c3f04b*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaDatOpe;
    public java.sql.Date w_DaDatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ADatOpe;
    public java.sql.Date w_ADatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_adata;
    public String w_c_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cdadata;
    public String w_cdadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_chkcfis;
    public String w_chkcfis;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_noninvio;
    public String w_noninvio;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codmage;
    public String w_codmage;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_fisccod;
    public String w_fisccod;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_statonas;
    public String w_statonas;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipoerr;
    public String w_tipoerr;
    public String _motivo;
    public String _codrap;
    public String _codper;
    public java.sql.Date _datnas;
    public String _provnas;
    public String _comnas;
    public String _naznas;
    public String _mesnas;
    public String _gionas;
    public String _annnas;
    public String _sesso;
    public String _codfisc;
    public String _cmesi;
    public double _pos;
    public String _motivo2;
    public String _chkcf;
    public String _chkstato;
    public String _chknet;
    public ReportLibrary _report;
    public boolean bReport;
    public String filename;
    public String filepath;
    public double _conta;
    public double _max;
    public double _min;
    public double _tot;
    public double _cicli;
    public double _bottom;
    public double _top;
    public double _reccount;
    public String gMsgImp;
    public String gPathApp;
    public String gUrlApp;
    public String gAzienda;
    public String w_CODFISC;
    public java.sql.Date w_DATANASC;
    public String w_NASCOMUN;
    public String w_NASSTATO;
    public String w_COGNOME;
    public String w_RAGSOC;
    public String w_NOME;
    public String w_SESSO;
    public String pTipo;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      m_bpassedw_DaDatOpe = source.Has("w_DaDatOpe");
      if (m_bpassedw_DaDatOpe) {
        w_DaDatOpe = source.GetParameter("w_DaDatOpe",source.GetParameter("DaDatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaDatOpe = source.GetCaller().GetDate("DaDatOpe","D",8,0);
          m_bpassedw_DaDatOpe = true;
        } else {
          w_DaDatOpe = source.GetParameter("DaDatOpe",source.GetParameter("w_DaDatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_ADatOpe = source.Has("w_ADatOpe");
      if (m_bpassedw_ADatOpe) {
        w_ADatOpe = source.GetParameter("w_ADatOpe",source.GetParameter("ADatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_ADatOpe = source.GetCaller().GetDate("ADatOpe","D",8,0);
          m_bpassedw_ADatOpe = true;
        } else {
          w_ADatOpe = source.GetParameter("ADatOpe",source.GetParameter("w_ADatOpe",CPLib.NullDate()));
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
      m_bpassedw_cdadata = source.Has("w_cdadata");
      if (m_bpassedw_cdadata) {
        w_cdadata = source.GetParameter("w_cdadata",source.GetParameter("cdadata",""));
      } else {
        if (source.IsForwarded()) {
          w_cdadata = source.GetCaller().GetString("cdadata","C",8,0);
          m_bpassedw_cdadata = true;
        } else {
          w_cdadata = source.GetParameter("cdadata",source.GetParameter("w_cdadata",""));
        }
      }
      m_bpassedw_chkcfis = source.Has("w_chkcfis");
      if (m_bpassedw_chkcfis) {
        w_chkcfis = source.GetParameter("w_chkcfis",source.GetParameter("chkcfis",""));
      } else {
        if (source.IsForwarded()) {
          w_chkcfis = source.GetCaller().GetString("chkcfis","C",1,0);
          m_bpassedw_chkcfis = true;
        } else {
          w_chkcfis = source.GetParameter("chkcfis",source.GetParameter("w_chkcfis",""));
        }
      }
      m_bpassedw_noninvio = source.Has("w_noninvio");
      if (m_bpassedw_noninvio) {
        w_noninvio = source.GetParameter("w_noninvio",source.GetParameter("noninvio",""));
      } else {
        if (source.IsForwarded()) {
          w_noninvio = source.GetCaller().GetString("noninvio","C",1,0);
          m_bpassedw_noninvio = true;
        } else {
          w_noninvio = source.GetParameter("noninvio",source.GetParameter("w_noninvio",""));
        }
      }
      m_bpassedw_codmage = source.Has("w_codmage");
      if (m_bpassedw_codmage) {
        w_codmage = source.GetParameter("w_codmage",source.GetParameter("codmage",""));
      } else {
        if (source.IsForwarded()) {
          w_codmage = source.GetCaller().GetString("codmage","C",5,0);
          m_bpassedw_codmage = true;
        } else {
          w_codmage = source.GetParameter("codmage",source.GetParameter("w_codmage",""));
        }
      }
      m_bpassedw_fisccod = source.Has("w_fisccod");
      if (m_bpassedw_fisccod) {
        w_fisccod = source.GetParameter("w_fisccod",source.GetParameter("fisccod",""));
      } else {
        if (source.IsForwarded()) {
          w_fisccod = source.GetCaller().GetString("fisccod","C",16,0);
          m_bpassedw_fisccod = true;
        } else {
          w_fisccod = source.GetParameter("fisccod",source.GetParameter("w_fisccod",""));
        }
      }
      m_bpassedw_statonas = source.Has("w_statonas");
      if (m_bpassedw_statonas) {
        w_statonas = source.GetParameter("w_statonas",source.GetParameter("statonas",""));
      } else {
        if (source.IsForwarded()) {
          w_statonas = source.GetCaller().GetString("statonas","C",40,0);
          m_bpassedw_statonas = true;
        } else {
          w_statonas = source.GetParameter("statonas",source.GetParameter("w_statonas",""));
        }
      }
      m_bpassedw_tipoerr = source.Has("w_tipoerr");
      if (m_bpassedw_tipoerr) {
        w_tipoerr = source.GetParameter("w_tipoerr",source.GetParameter("tipoerr",""));
      } else {
        if (source.IsForwarded()) {
          w_tipoerr = source.GetCaller().GetString("tipoerr","C",1,0);
          m_bpassedw_tipoerr = true;
        } else {
          w_tipoerr = source.GetParameter("tipoerr",source.GetParameter("w_tipoerr",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_stpverage_do_wu";
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
    return  ! (status.m_bpassedw_tipoerr) ||  ! (status.m_bpassedw_statonas) ||  ! (status.m_bpassedw_fisccod) ||  ! (status.m_bpassedw_codmage) ||  ! (status.m_bpassedw_noninvio) ||  ! (status.m_bpassedw_chkcfis) ||  ! (status.m_bpassedw_cdadata) ||  ! (status.m_bpassedw_c_adata) ||  ! (status.m_bpassedw_ADatOpe) ||  ! (status.m_bpassedw_DaDatOpe);
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
    if ( ! (status.m_bpassedw_DaDatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaDatOpe',"+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaDatOpe',l_cV);");
    if ( ! (status.m_bpassedw_ADatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_ADatOpe',"+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_ADatOpe',l_cV);");
    if ( ! (status.m_bpassedw_c_adata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_adata',"+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_adata',l_cV);");
    if ( ! (status.m_bpassedw_cdadata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cdadata',"+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cdadata',l_cV);");
    if ( ! (status.m_bpassedw_chkcfis)) {
      status.out.println("l_cV=WtA(l_oWnd('w_chkcfis',"+SPLib.ToJSValue(status.w_chkcfis,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_chkcfis,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_chkcfis',l_cV);");
    if ( ! (status.m_bpassedw_noninvio)) {
      status.out.println("l_cV=WtA(l_oWnd('w_noninvio',"+SPLib.ToJSValue(status.w_noninvio,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_noninvio,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_noninvio',l_cV);");
    if ( ! (status.m_bpassedw_codmage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codmage',"+SPLib.ToJSValue(status.w_codmage,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codmage,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codmage',l_cV);");
    if ( ! (status.m_bpassedw_fisccod)) {
      status.out.println("l_cV=WtA(l_oWnd('w_fisccod',"+SPLib.ToJSValue(status.w_fisccod,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_fisccod,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_fisccod',l_cV);");
    if ( ! (status.m_bpassedw_statonas)) {
      status.out.println("l_cV=WtA(l_oWnd('w_statonas',"+SPLib.ToJSValue(status.w_statonas,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_statonas,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_statonas',l_cV);");
    if ( ! (status.m_bpassedw_tipoerr)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipoerr',"+SPLib.ToJSValue(status.w_tipoerr,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoerr,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipoerr',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pTipo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pTipo',l_cV);");
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
    arrt_stpverage_do_wuR Rcalled;
    Rcalled = new arrt_stpverage_do_wuR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.pTipo);
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
    return new arrt_stpverage_do_wuR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_stpverage_do_wuR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.pTipo)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_stpverage_do_wu"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_DaDatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaDatOpe),"?",0,0)+"");
        status.out.println("js:w_ADatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ADatOpe),"?",0,0)+"");
        status.out.println("js:w_c_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_adata),"?",0,0)+"");
        status.out.println("js:w_cdadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cdadata),"?",0,0)+"");
        status.out.println("js:w_chkcfis="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_chkcfis),"?",0,0)+"");
        status.out.println("js:w_noninvio="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_noninvio),"?",0,0)+"");
        status.out.println("js:w_codmage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codmage),"?",0,0)+"");
        status.out.println("js:w_fisccod="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_fisccod),"?",0,0)+"");
        status.out.println("js:w_statonas="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_statonas),"?",0,0)+"");
        status.out.println("js:w_tipoerr="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipoerr),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_DaDatOpe,null)) {");
        status.out.println(" window[f].w_DaDatOpe.setTime(("+SPLib.ToJSValue(status.w_DaDatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ADatOpe,null)) {");
        status.out.println(" window[f].w_ADatOpe.setTime(("+SPLib.ToJSValue(status.w_ADatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_adata,null)) {");
        status.out.println("window[f].w_c_adata="+SPLib.ToJSValue(status.w_c_adata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cdadata,null)) {");
        status.out.println("window[f].w_cdadata="+SPLib.ToJSValue(status.w_cdadata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_chkcfis,null)) {");
        status.out.println("window[f].w_chkcfis="+SPLib.ToJSValue(status.w_chkcfis,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_noninvio,null)) {");
        status.out.println("window[f].w_noninvio="+SPLib.ToJSValue(status.w_noninvio,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codmage,null)) {");
        status.out.println("window[f].w_codmage="+SPLib.ToJSValue(status.w_codmage,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_fisccod,null)) {");
        status.out.println("window[f].w_fisccod="+SPLib.ToJSValue(status.w_fisccod,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_statonas,null)) {");
        status.out.println("window[f].w_statonas="+SPLib.ToJSValue(status.w_statonas,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipoerr,null)) {");
        status.out.println("window[f].w_tipoerr="+SPLib.ToJSValue(status.w_tipoerr,"C",0,0)+";");
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
      arrt_stpverage_do_wuR Rcalled;
      Rcalled = new arrt_stpverage_do_wuR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_stpverage_do_wu");
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
