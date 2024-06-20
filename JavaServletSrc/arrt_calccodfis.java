import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_calccodfis extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*c09a6818*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODFISC;
    public String w_CODFISC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATANASC;
    public java.sql.Date w_DATANASC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NASCOMUN;
    public String w_NASCOMUN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NASSTATO;
    public String w_NASSTATO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_COGNOME;
    public String w_COGNOME;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAGSOC;
    public String w_RAGSOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NOME;
    public String w_NOME;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SESSO;
    public String w_SESSO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPINTER;
    public String w_TIPINTER;
    public String apporagsoc;
    public String Mese;
    public String Giorno;
    public String Anno;
    public String cData;
    public String cSigla;
    public String cSiglaN;
    public String cognome;
    public String nome;
    public double c1;
    public double c2;
    public String cCog;
    public String cNom;
    public double nCheck;
    public String cCheck;
    public String cChar;
    public double nChar;
    public double nocf;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_CODFISC = source.Has("w_CODFISC");
      if (m_bpassedw_CODFISC) {
        w_CODFISC = source.GetParameter("w_CODFISC",source.GetParameter("CODFISC",""));
      } else {
        if (source.IsForwarded()) {
          w_CODFISC = source.GetCaller().GetString("CODFISC","C",16,0);
          m_bpassedw_CODFISC = true;
        } else {
          w_CODFISC = source.GetParameter("CODFISC",source.GetParameter("w_CODFISC",""));
        }
      }
      m_bpassedw_DATANASC = source.Has("w_DATANASC");
      if (m_bpassedw_DATANASC) {
        w_DATANASC = source.GetParameter("w_DATANASC",source.GetParameter("DATANASC",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATANASC = source.GetCaller().GetDate("DATANASC","D",8,0);
          m_bpassedw_DATANASC = true;
        } else {
          w_DATANASC = source.GetParameter("DATANASC",source.GetParameter("w_DATANASC",CPLib.NullDate()));
        }
      }
      m_bpassedw_NASCOMUN = source.Has("w_NASCOMUN");
      if (m_bpassedw_NASCOMUN) {
        w_NASCOMUN = source.GetParameter("w_NASCOMUN",source.GetParameter("NASCOMUN",""));
      } else {
        if (source.IsForwarded()) {
          w_NASCOMUN = source.GetCaller().GetString("NASCOMUN","C",30,0);
          m_bpassedw_NASCOMUN = true;
        } else {
          w_NASCOMUN = source.GetParameter("NASCOMUN",source.GetParameter("w_NASCOMUN",""));
        }
      }
      m_bpassedw_NASSTATO = source.Has("w_NASSTATO");
      if (m_bpassedw_NASSTATO) {
        w_NASSTATO = source.GetParameter("w_NASSTATO",source.GetParameter("NASSTATO",""));
      } else {
        if (source.IsForwarded()) {
          w_NASSTATO = source.GetCaller().GetString("NASSTATO","C",30,0);
          m_bpassedw_NASSTATO = true;
        } else {
          w_NASSTATO = source.GetParameter("NASSTATO",source.GetParameter("w_NASSTATO",""));
        }
      }
      m_bpassedw_COGNOME = source.Has("w_COGNOME");
      if (m_bpassedw_COGNOME) {
        w_COGNOME = source.GetParameter("w_COGNOME",source.GetParameter("COGNOME",""));
      } else {
        if (source.IsForwarded()) {
          w_COGNOME = source.GetCaller().GetString("COGNOME","C",26,0);
          m_bpassedw_COGNOME = true;
        } else {
          w_COGNOME = source.GetParameter("COGNOME",source.GetParameter("w_COGNOME",""));
        }
      }
      m_bpassedw_RAGSOC = source.Has("w_RAGSOC");
      if (m_bpassedw_RAGSOC) {
        w_RAGSOC = source.GetParameter("w_RAGSOC",source.GetParameter("RAGSOC",""));
      } else {
        if (source.IsForwarded()) {
          w_RAGSOC = source.GetCaller().GetString("RAGSOC","C",70,0);
          m_bpassedw_RAGSOC = true;
        } else {
          w_RAGSOC = source.GetParameter("RAGSOC",source.GetParameter("w_RAGSOC",""));
        }
      }
      m_bpassedw_NOME = source.Has("w_NOME");
      if (m_bpassedw_NOME) {
        w_NOME = source.GetParameter("w_NOME",source.GetParameter("NOME",""));
      } else {
        if (source.IsForwarded()) {
          w_NOME = source.GetCaller().GetString("NOME","C",25,0);
          m_bpassedw_NOME = true;
        } else {
          w_NOME = source.GetParameter("NOME",source.GetParameter("w_NOME",""));
        }
      }
      m_bpassedw_SESSO = source.Has("w_SESSO");
      if (m_bpassedw_SESSO) {
        w_SESSO = source.GetParameter("w_SESSO",source.GetParameter("SESSO",""));
      } else {
        if (source.IsForwarded()) {
          w_SESSO = source.GetCaller().GetString("SESSO","C",1,0);
          m_bpassedw_SESSO = true;
        } else {
          w_SESSO = source.GetParameter("SESSO",source.GetParameter("w_SESSO",""));
        }
      }
      m_bpassedw_TIPINTER = source.Has("w_TIPINTER");
      if (m_bpassedw_TIPINTER) {
        w_TIPINTER = source.GetParameter("w_TIPINTER",source.GetParameter("TIPINTER",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPINTER = source.GetCaller().GetString("TIPINTER","C",2,0);
          m_bpassedw_TIPINTER = true;
        } else {
          w_TIPINTER = source.GetParameter("TIPINTER",source.GetParameter("w_TIPINTER",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_calccodfis";
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
    return  ! (status.m_bpassedw_TIPINTER) ||  ! (status.m_bpassedw_SESSO) ||  ! (status.m_bpassedw_NOME) ||  ! (status.m_bpassedw_RAGSOC) ||  ! (status.m_bpassedw_COGNOME) ||  ! (status.m_bpassedw_NASSTATO) ||  ! (status.m_bpassedw_NASCOMUN) ||  ! (status.m_bpassedw_DATANASC) ||  ! (status.m_bpassedw_CODFISC);
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
    if ( ! (status.m_bpassedw_CODFISC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODFISC',"+SPLib.ToJSValue(status.w_CODFISC,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODFISC,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODFISC',l_cV);");
    if ( ! (status.m_bpassedw_DATANASC)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATANASC',"+SPLib.ToJSValue(status.w_DATANASC,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATANASC,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATANASC',l_cV);");
    if ( ! (status.m_bpassedw_NASCOMUN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NASCOMUN',"+SPLib.ToJSValue(status.w_NASCOMUN,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NASCOMUN,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NASCOMUN',l_cV);");
    if ( ! (status.m_bpassedw_NASSTATO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NASSTATO',"+SPLib.ToJSValue(status.w_NASSTATO,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NASSTATO,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NASSTATO',l_cV);");
    if ( ! (status.m_bpassedw_COGNOME)) {
      status.out.println("l_cV=WtA(l_oWnd('w_COGNOME',"+SPLib.ToJSValue(status.w_COGNOME,"C",26,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_COGNOME,"C",26,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_COGNOME',l_cV);");
    if ( ! (status.m_bpassedw_RAGSOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAGSOC',"+SPLib.ToJSValue(status.w_RAGSOC,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAGSOC,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAGSOC',l_cV);");
    if ( ! (status.m_bpassedw_NOME)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NOME',"+SPLib.ToJSValue(status.w_NOME,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NOME,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NOME',l_cV);");
    if ( ! (status.m_bpassedw_SESSO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SESSO',"+SPLib.ToJSValue(status.w_SESSO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SESSO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SESSO',l_cV);");
    if ( ! (status.m_bpassedw_TIPINTER)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPINTER',"+SPLib.ToJSValue(status.w_TIPINTER,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPINTER,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPINTER',l_cV);");
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
    arrt_calccodfisR Rcalled;
    Rcalled = new arrt_calccodfisR(status.context,status);
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
    return new arrt_calccodfisR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_calccodfisR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_calccodfis"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_CODFISC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODFISC),"?",0,0)+"");
        status.out.println("js:w_DATANASC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATANASC),"?",0,0)+"");
        status.out.println("js:w_NASCOMUN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NASCOMUN),"?",0,0)+"");
        status.out.println("js:w_NASSTATO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NASSTATO),"?",0,0)+"");
        status.out.println("js:w_COGNOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_COGNOME),"?",0,0)+"");
        status.out.println("js:w_RAGSOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAGSOC),"?",0,0)+"");
        status.out.println("js:w_NOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NOME),"?",0,0)+"");
        status.out.println("js:w_SESSO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SESSO),"?",0,0)+"");
        status.out.println("js:w_TIPINTER="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPINTER),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_CODFISC,null)) {");
        status.out.println("window[f].w_CODFISC="+SPLib.ToJSValue(status.w_CODFISC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATANASC,null)) {");
        status.out.println(" window[f].w_DATANASC.setTime(("+SPLib.ToJSValue(status.w_DATANASC,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NASCOMUN,null)) {");
        status.out.println("window[f].w_NASCOMUN="+SPLib.ToJSValue(status.w_NASCOMUN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NASSTATO,null)) {");
        status.out.println("window[f].w_NASSTATO="+SPLib.ToJSValue(status.w_NASSTATO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_COGNOME,null)) {");
        status.out.println("window[f].w_COGNOME="+SPLib.ToJSValue(status.w_COGNOME,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAGSOC,null)) {");
        status.out.println("window[f].w_RAGSOC="+SPLib.ToJSValue(status.w_RAGSOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NOME,null)) {");
        status.out.println("window[f].w_NOME="+SPLib.ToJSValue(status.w_NOME,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SESSO,null)) {");
        status.out.println("window[f].w_SESSO="+SPLib.ToJSValue(status.w_SESSO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPINTER,null)) {");
        status.out.println("window[f].w_TIPINTER="+SPLib.ToJSValue(status.w_TIPINTER,"C",0,0)+";");
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
      arrt_calccodfisR Rcalled;
      Rcalled = new arrt_calccodfisR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_calccodfis");
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
