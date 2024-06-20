import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_sd_comunega extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*TLEJGYJRRH*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_a_data;
    public java.sql.Date w_a_data;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dadata;
    public java.sql.Date w_dadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datpri;
    public java.sql.Date w_datpri;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datsecf;
    public java.sql.Date w_datsecf;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datseci;
    public java.sql.Date w_datseci;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_iniz;
    public String w_iniz;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_seco;
    public String w_seco;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_anno;
    public double w_anno;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_mese;
    public String w_mese;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FILEINVIO;
    public String w_FILEINVIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATAINVIO;
    public java.sql.Date w_DATAINVIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CFINVIO;
    public String w_CFINVIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CAFINVIO;
    public String w_CAFINVIO;
    public String _errlog;
    public String _file;
    public String _nomefile;
    public String _descfile;
    public double _r;
    public double _i;
    public String fhand;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public String cProg;
    public String _cfinvio;
    public String _cafinvio;
    public String _tipinvio;
    public String _impinvio;
    public String _cfint;
    public String _ragint;
    public String _citint;
    public String _prvint;
    public java.sql.Date _datinvio;
    public String gPathApp;
    public String gAzienda;
    public String gIntemediario;
    public void GetNonLocals(SPParameterSource source) {
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
      m_bpassedw_datpri = source.Has("w_datpri");
      if (m_bpassedw_datpri) {
        w_datpri = source.GetParameter("w_datpri",source.GetParameter("datpri",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datpri = source.GetCaller().GetDate("datpri","D",8,0);
          m_bpassedw_datpri = true;
        } else {
          w_datpri = source.GetParameter("datpri",source.GetParameter("w_datpri",CPLib.NullDate()));
        }
      }
      m_bpassedw_datsecf = source.Has("w_datsecf");
      if (m_bpassedw_datsecf) {
        w_datsecf = source.GetParameter("w_datsecf",source.GetParameter("datsecf",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datsecf = source.GetCaller().GetDate("datsecf","D",8,0);
          m_bpassedw_datsecf = true;
        } else {
          w_datsecf = source.GetParameter("datsecf",source.GetParameter("w_datsecf",CPLib.NullDate()));
        }
      }
      m_bpassedw_datseci = source.Has("w_datseci");
      if (m_bpassedw_datseci) {
        w_datseci = source.GetParameter("w_datseci",source.GetParameter("datseci",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datseci = source.GetCaller().GetDate("datseci","D",8,0);
          m_bpassedw_datseci = true;
        } else {
          w_datseci = source.GetParameter("datseci",source.GetParameter("w_datseci",CPLib.NullDate()));
        }
      }
      m_bpassedw_iniz = source.Has("w_iniz");
      if (m_bpassedw_iniz) {
        w_iniz = source.GetParameter("w_iniz",source.GetParameter("iniz",""));
      } else {
        if (source.IsForwarded()) {
          w_iniz = source.GetCaller().GetString("iniz","C",1,0);
          m_bpassedw_iniz = true;
        } else {
          w_iniz = source.GetParameter("iniz",source.GetParameter("w_iniz",""));
        }
      }
      m_bpassedw_seco = source.Has("w_seco");
      if (m_bpassedw_seco) {
        w_seco = source.GetParameter("w_seco",source.GetParameter("seco",""));
      } else {
        if (source.IsForwarded()) {
          w_seco = source.GetCaller().GetString("seco","C",1,0);
          m_bpassedw_seco = true;
        } else {
          w_seco = source.GetParameter("seco",source.GetParameter("w_seco",""));
        }
      }
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
      m_bpassedw_mese = source.Has("w_mese");
      if (m_bpassedw_mese) {
        w_mese = source.GetParameter("w_mese",source.GetParameter("mese",""));
      } else {
        if (source.IsForwarded()) {
          w_mese = source.GetCaller().GetString("mese","C",2,0);
          m_bpassedw_mese = true;
        } else {
          w_mese = source.GetParameter("mese",source.GetParameter("w_mese",""));
        }
      }
      m_bpassedw_FILEINVIO = source.Has("w_FILEINVIO");
      if (m_bpassedw_FILEINVIO) {
        w_FILEINVIO = source.GetParameter("w_FILEINVIO",source.GetParameter("FILEINVIO",""));
      } else {
        if (source.IsForwarded()) {
          w_FILEINVIO = source.GetCaller().GetString("FILEINVIO","C",1,0);
          m_bpassedw_FILEINVIO = true;
        } else {
          w_FILEINVIO = source.GetParameter("FILEINVIO",source.GetParameter("w_FILEINVIO",""));
        }
      }
      m_bpassedw_DATAINVIO = source.Has("w_DATAINVIO");
      if (m_bpassedw_DATAINVIO) {
        w_DATAINVIO = source.GetParameter("w_DATAINVIO",source.GetParameter("DATAINVIO",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATAINVIO = source.GetCaller().GetDate("DATAINVIO","D",8,0);
          m_bpassedw_DATAINVIO = true;
        } else {
          w_DATAINVIO = source.GetParameter("DATAINVIO",source.GetParameter("w_DATAINVIO",CPLib.NullDate()));
        }
      }
      m_bpassedw_CFINVIO = source.Has("w_CFINVIO");
      if (m_bpassedw_CFINVIO) {
        w_CFINVIO = source.GetParameter("w_CFINVIO",source.GetParameter("CFINVIO",""));
      } else {
        if (source.IsForwarded()) {
          w_CFINVIO = source.GetCaller().GetString("CFINVIO","C",16,0);
          m_bpassedw_CFINVIO = true;
        } else {
          w_CFINVIO = source.GetParameter("CFINVIO",source.GetParameter("w_CFINVIO",""));
        }
      }
      m_bpassedw_CAFINVIO = source.Has("w_CAFINVIO");
      if (m_bpassedw_CAFINVIO) {
        w_CAFINVIO = source.GetParameter("w_CAFINVIO",source.GetParameter("CAFINVIO",""));
      } else {
        if (source.IsForwarded()) {
          w_CAFINVIO = source.GetCaller().GetString("CAFINVIO","C",5,0);
          m_bpassedw_CAFINVIO = true;
        } else {
          w_CAFINVIO = source.GetParameter("CAFINVIO",source.GetParameter("w_CAFINVIO",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_sd_comunega";
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
    return  ! (status.m_bpassedw_CAFINVIO) ||  ! (status.m_bpassedw_CFINVIO) ||  ! (status.m_bpassedw_DATAINVIO) ||  ! (status.m_bpassedw_FILEINVIO) ||  ! (status.m_bpassedw_mese) ||  ! (status.m_bpassedw_anno) ||  ! (status.m_bpassedw_seco) ||  ! (status.m_bpassedw_iniz) ||  ! (status.m_bpassedw_datseci) ||  ! (status.m_bpassedw_datsecf) ||  ! (status.m_bpassedw_datpri) ||  ! (status.m_bpassedw_dadata) ||  ! (status.m_bpassedw_a_data);
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
    if ( ! (status.m_bpassedw_datpri)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datpri',"+SPLib.ToJSValue(status.w_datpri,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datpri,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datpri',l_cV);");
    if ( ! (status.m_bpassedw_datsecf)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datsecf',"+SPLib.ToJSValue(status.w_datsecf,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datsecf,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datsecf',l_cV);");
    if ( ! (status.m_bpassedw_datseci)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datseci',"+SPLib.ToJSValue(status.w_datseci,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datseci,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datseci',l_cV);");
    if ( ! (status.m_bpassedw_iniz)) {
      status.out.println("l_cV=WtA(l_oWnd('w_iniz',"+SPLib.ToJSValue(status.w_iniz,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_iniz,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_iniz',l_cV);");
    if ( ! (status.m_bpassedw_seco)) {
      status.out.println("l_cV=WtA(l_oWnd('w_seco',"+SPLib.ToJSValue(status.w_seco,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_seco,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_seco',l_cV);");
    if ( ! (status.m_bpassedw_anno)) {
      status.out.println("l_cV=WtA(l_oWnd('w_anno',"+SPLib.ToJSValue(status.w_anno,"N",4,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_anno,"N",4,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_anno',l_cV);");
    if ( ! (status.m_bpassedw_mese)) {
      status.out.println("l_cV=WtA(l_oWnd('w_mese',"+SPLib.ToJSValue(status.w_mese,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_mese,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_mese',l_cV);");
    if ( ! (status.m_bpassedw_FILEINVIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FILEINVIO',"+SPLib.ToJSValue(status.w_FILEINVIO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FILEINVIO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FILEINVIO',l_cV);");
    if ( ! (status.m_bpassedw_DATAINVIO)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATAINVIO',"+SPLib.ToJSValue(status.w_DATAINVIO,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATAINVIO,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATAINVIO',l_cV);");
    if ( ! (status.m_bpassedw_CFINVIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CFINVIO',"+SPLib.ToJSValue(status.w_CFINVIO,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CFINVIO,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CFINVIO',l_cV);");
    if ( ! (status.m_bpassedw_CAFINVIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CAFINVIO',"+SPLib.ToJSValue(status.w_CAFINVIO,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CAFINVIO,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CAFINVIO',l_cV);");
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
    arrt_sd_comunegaR Rcalled;
    Rcalled = new arrt_sd_comunegaR(status.context,status);
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
    return new arrt_sd_comunegaR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_sd_comunegaR Rcalled) throws IOException {
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
          ts = new CPTokenSource(status.context.Translate(Rcalled.m_cLastMsgError),"\n");
          while (ts.HasMoreTokens()) {
            status.out.println("Error message:"+ts.NextToken()+"");
          }
        }
        if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_sd_comunega"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+status.m_cFaultTrace+"");
          }
        }
        status.out.println("js:w_a_data="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_a_data),"?",0,0)+"");
        status.out.println("js:w_dadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dadata),"?",0,0)+"");
        status.out.println("js:w_datpri="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datpri),"?",0,0)+"");
        status.out.println("js:w_datsecf="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datsecf),"?",0,0)+"");
        status.out.println("js:w_datseci="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datseci),"?",0,0)+"");
        status.out.println("js:w_iniz="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_iniz),"?",0,0)+"");
        status.out.println("js:w_seco="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_seco),"?",0,0)+"");
        status.out.println("js:w_anno="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_anno),"?",0,0)+"");
        status.out.println("js:w_mese="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_mese),"?",0,0)+"");
        status.out.println("js:w_FILEINVIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FILEINVIO),"?",0,0)+"");
        status.out.println("js:w_DATAINVIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATAINVIO),"?",0,0)+"");
        status.out.println("js:w_CFINVIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CFINVIO),"?",0,0)+"");
        status.out.println("js:w_CAFINVIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CAFINVIO),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_a_data,null)) {");
        status.out.println(" window[f].w_a_data.setTime(Date.parse("+SPLib.ToJSValue(status.w_a_data,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_dadata,null)) {");
        status.out.println(" window[f].w_dadata.setTime(Date.parse("+SPLib.ToJSValue(status.w_dadata,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datpri,null)) {");
        status.out.println(" window[f].w_datpri.setTime(Date.parse("+SPLib.ToJSValue(status.w_datpri,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datsecf,null)) {");
        status.out.println(" window[f].w_datsecf.setTime(Date.parse("+SPLib.ToJSValue(status.w_datsecf,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datseci,null)) {");
        status.out.println(" window[f].w_datseci.setTime(Date.parse("+SPLib.ToJSValue(status.w_datseci,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_iniz,null)) {");
        status.out.println("window[f].w_iniz="+SPLib.ToJSValue(status.w_iniz,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_seco,null)) {");
        status.out.println("window[f].w_seco="+SPLib.ToJSValue(status.w_seco,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_anno,null)) {");
        status.out.println("window[f].w_anno="+SPLib.ToJSValue(status.w_anno,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_mese,null)) {");
        status.out.println("window[f].w_mese="+SPLib.ToJSValue(status.w_mese,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FILEINVIO,null)) {");
        status.out.println("window[f].w_FILEINVIO="+SPLib.ToJSValue(status.w_FILEINVIO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATAINVIO,null)) {");
        status.out.println(" window[f].w_DATAINVIO.setTime(Date.parse("+SPLib.ToJSValue(status.w_DATAINVIO,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CFINVIO,null)) {");
        status.out.println("window[f].w_CFINVIO="+SPLib.ToJSValue(status.w_CFINVIO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CAFINVIO,null)) {");
        status.out.println("window[f].w_CAFINVIO="+SPLib.ToJSValue(status.w_CAFINVIO,"C",0,0)+";");
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
      arrt_sd_comunegaR Rcalled;
      Rcalled = new arrt_sd_comunegaR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_sd_comunega");
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
