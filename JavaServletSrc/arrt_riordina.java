import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_riordina extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*84de77de*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_frzuif;
    public String w_frzuif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_opeage;
    public String w_opeage;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_opeuif;
    public String w_opeuif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rapage;
    public String w_rapage;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rapuif;
    public String w_rapuif;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_titaui;
    public String w_titaui;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgpart;
    public String w_flgpart;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_prgidb;
    public double w_prgidb;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_prgnprg;
    public double w_prgnprg;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_prgiope;
    public double w_prgiope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_daData;
    public java.sql.Date w_daData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dataover;
    public String w_dataover;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ngiorni;
    public double w_ngiorni;
    public String cProg;
    public String cProg1;
    public String cIDBASE;
    public String cIDB2;
    public String cIdReg;
    public String cIdMod;
    public String cTipRap;
    public String cFlgRap;
    public double cPrgImp;
    public String cOldProg;
    public String w_cDATREG;
    public double _conta;
    public String mycProg;
    public double mycPrgImp;
    public String gAzienda;
    public String gMsgImp;
    public String gFlgWU;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_frzuif = source.Has("w_frzuif");
      if (m_bpassedw_frzuif) {
        w_frzuif = source.GetParameter("w_frzuif",source.GetParameter("frzuif",""));
      } else {
        if (source.IsForwarded()) {
          w_frzuif = source.GetCaller().GetString("frzuif","C",1,0);
          m_bpassedw_frzuif = true;
        } else {
          w_frzuif = source.GetParameter("frzuif",source.GetParameter("w_frzuif",""));
        }
      }
      m_bpassedw_opeage = source.Has("w_opeage");
      if (m_bpassedw_opeage) {
        w_opeage = source.GetParameter("w_opeage",source.GetParameter("opeage",""));
      } else {
        if (source.IsForwarded()) {
          w_opeage = source.GetCaller().GetString("opeage","C",1,0);
          m_bpassedw_opeage = true;
        } else {
          w_opeage = source.GetParameter("opeage",source.GetParameter("w_opeage",""));
        }
      }
      m_bpassedw_opeuif = source.Has("w_opeuif");
      if (m_bpassedw_opeuif) {
        w_opeuif = source.GetParameter("w_opeuif",source.GetParameter("opeuif",""));
      } else {
        if (source.IsForwarded()) {
          w_opeuif = source.GetCaller().GetString("opeuif","C",1,0);
          m_bpassedw_opeuif = true;
        } else {
          w_opeuif = source.GetParameter("opeuif",source.GetParameter("w_opeuif",""));
        }
      }
      m_bpassedw_rapage = source.Has("w_rapage");
      if (m_bpassedw_rapage) {
        w_rapage = source.GetParameter("w_rapage",source.GetParameter("rapage",""));
      } else {
        if (source.IsForwarded()) {
          w_rapage = source.GetCaller().GetString("rapage","C",1,0);
          m_bpassedw_rapage = true;
        } else {
          w_rapage = source.GetParameter("rapage",source.GetParameter("w_rapage",""));
        }
      }
      m_bpassedw_rapuif = source.Has("w_rapuif");
      if (m_bpassedw_rapuif) {
        w_rapuif = source.GetParameter("w_rapuif",source.GetParameter("rapuif",""));
      } else {
        if (source.IsForwarded()) {
          w_rapuif = source.GetCaller().GetString("rapuif","C",1,0);
          m_bpassedw_rapuif = true;
        } else {
          w_rapuif = source.GetParameter("rapuif",source.GetParameter("w_rapuif",""));
        }
      }
      m_bpassedw_titaui = source.Has("w_titaui");
      if (m_bpassedw_titaui) {
        w_titaui = source.GetParameter("w_titaui",source.GetParameter("titaui",""));
      } else {
        if (source.IsForwarded()) {
          w_titaui = source.GetCaller().GetString("titaui","C",1,0);
          m_bpassedw_titaui = true;
        } else {
          w_titaui = source.GetParameter("titaui",source.GetParameter("w_titaui",""));
        }
      }
      m_bpassedw_flgpart = source.Has("w_flgpart");
      if (m_bpassedw_flgpart) {
        w_flgpart = source.GetParameter("w_flgpart",source.GetParameter("flgpart",""));
      } else {
        if (source.IsForwarded()) {
          w_flgpart = source.GetCaller().GetString("flgpart","C",1,0);
          m_bpassedw_flgpart = true;
        } else {
          w_flgpart = source.GetParameter("flgpart",source.GetParameter("w_flgpart",""));
        }
      }
      m_bpassedw_prgidb = source.Has("w_prgidb");
      if (m_bpassedw_prgidb) {
        w_prgidb = source.GetParameter("w_prgidb",source.GetParameter("prgidb",0));
      } else {
        if (source.IsForwarded()) {
          w_prgidb = source.GetCaller().GetNumber("prgidb","N",10,0);
          m_bpassedw_prgidb = true;
        } else {
          w_prgidb = source.GetParameter("prgidb",source.GetParameter("w_prgidb",0));
        }
      }
      m_bpassedw_prgnprg = source.Has("w_prgnprg");
      if (m_bpassedw_prgnprg) {
        w_prgnprg = source.GetParameter("w_prgnprg",source.GetParameter("prgnprg",0));
      } else {
        if (source.IsForwarded()) {
          w_prgnprg = source.GetCaller().GetNumber("prgnprg","N",10,0);
          m_bpassedw_prgnprg = true;
        } else {
          w_prgnprg = source.GetParameter("prgnprg",source.GetParameter("w_prgnprg",0));
        }
      }
      m_bpassedw_prgiope = source.Has("w_prgiope");
      if (m_bpassedw_prgiope) {
        w_prgiope = source.GetParameter("w_prgiope",source.GetParameter("prgiope",0));
      } else {
        if (source.IsForwarded()) {
          w_prgiope = source.GetCaller().GetNumber("prgiope","N",10,0);
          m_bpassedw_prgiope = true;
        } else {
          w_prgiope = source.GetParameter("prgiope",source.GetParameter("w_prgiope",0));
        }
      }
      m_bpassedw_daData = source.Has("w_daData");
      if (m_bpassedw_daData) {
        w_daData = source.GetParameter("w_daData",source.GetParameter("daData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_daData = source.GetCaller().GetDate("daData","D",8,0);
          m_bpassedw_daData = true;
        } else {
          w_daData = source.GetParameter("daData",source.GetParameter("w_daData",CPLib.NullDate()));
        }
      }
      m_bpassedw_dataover = source.Has("w_dataover");
      if (m_bpassedw_dataover) {
        w_dataover = source.GetParameter("w_dataover",source.GetParameter("dataover",""));
      } else {
        if (source.IsForwarded()) {
          w_dataover = source.GetCaller().GetString("dataover","C",1,0);
          m_bpassedw_dataover = true;
        } else {
          w_dataover = source.GetParameter("dataover",source.GetParameter("w_dataover",""));
        }
      }
      m_bpassedw_ngiorni = source.Has("w_ngiorni");
      if (m_bpassedw_ngiorni) {
        w_ngiorni = source.GetParameter("w_ngiorni",source.GetParameter("ngiorni",0));
      } else {
        if (source.IsForwarded()) {
          w_ngiorni = source.GetCaller().GetNumber("ngiorni","N",2,0);
          m_bpassedw_ngiorni = true;
        } else {
          w_ngiorni = source.GetParameter("ngiorni",source.GetParameter("w_ngiorni",0));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_riordina";
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
    return  ! (status.m_bpassedw_ngiorni) ||  ! (status.m_bpassedw_dataover) ||  ! (status.m_bpassedw_daData) ||  ! (status.m_bpassedw_prgiope) ||  ! (status.m_bpassedw_prgnprg) ||  ! (status.m_bpassedw_prgidb) ||  ! (status.m_bpassedw_flgpart) ||  ! (status.m_bpassedw_titaui) ||  ! (status.m_bpassedw_rapuif) ||  ! (status.m_bpassedw_rapage) ||  ! (status.m_bpassedw_opeuif) ||  ! (status.m_bpassedw_opeage) ||  ! (status.m_bpassedw_frzuif);
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
    if ( ! (status.m_bpassedw_frzuif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_frzuif',"+SPLib.ToJSValue(status.w_frzuif,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_frzuif,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_frzuif',l_cV);");
    if ( ! (status.m_bpassedw_opeage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_opeage',"+SPLib.ToJSValue(status.w_opeage,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_opeage,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_opeage',l_cV);");
    if ( ! (status.m_bpassedw_opeuif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_opeuif',"+SPLib.ToJSValue(status.w_opeuif,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_opeuif,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_opeuif',l_cV);");
    if ( ! (status.m_bpassedw_rapage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rapage',"+SPLib.ToJSValue(status.w_rapage,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rapage,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rapage',l_cV);");
    if ( ! (status.m_bpassedw_rapuif)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rapuif',"+SPLib.ToJSValue(status.w_rapuif,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rapuif,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rapuif',l_cV);");
    if ( ! (status.m_bpassedw_titaui)) {
      status.out.println("l_cV=WtA(l_oWnd('w_titaui',"+SPLib.ToJSValue(status.w_titaui,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_titaui,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_titaui',l_cV);");
    if ( ! (status.m_bpassedw_flgpart)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgpart',"+SPLib.ToJSValue(status.w_flgpart,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgpart,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgpart',l_cV);");
    if ( ! (status.m_bpassedw_prgidb)) {
      status.out.println("l_cV=WtA(l_oWnd('w_prgidb',"+SPLib.ToJSValue(status.w_prgidb,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_prgidb,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_prgidb',l_cV);");
    if ( ! (status.m_bpassedw_prgnprg)) {
      status.out.println("l_cV=WtA(l_oWnd('w_prgnprg',"+SPLib.ToJSValue(status.w_prgnprg,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_prgnprg,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_prgnprg',l_cV);");
    if ( ! (status.m_bpassedw_prgiope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_prgiope',"+SPLib.ToJSValue(status.w_prgiope,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_prgiope,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_prgiope',l_cV);");
    if ( ! (status.m_bpassedw_daData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_daData',"+SPLib.ToJSValue(status.w_daData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_daData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_daData',l_cV);");
    if ( ! (status.m_bpassedw_dataover)) {
      status.out.println("l_cV=WtA(l_oWnd('w_dataover',"+SPLib.ToJSValue(status.w_dataover,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dataover,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_dataover',l_cV);");
    if ( ! (status.m_bpassedw_ngiorni)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ngiorni',"+SPLib.ToJSValue(status.w_ngiorni,"N",2,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ngiorni,"N",2,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_ngiorni',l_cV);");
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
    arrt_riordinaR Rcalled;
    Rcalled = new arrt_riordinaR(status.context,status);
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
    return new arrt_riordinaR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_riordinaR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_riordina"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_frzuif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_frzuif),"?",0,0)+"");
        status.out.println("js:w_opeage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_opeage),"?",0,0)+"");
        status.out.println("js:w_opeuif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_opeuif),"?",0,0)+"");
        status.out.println("js:w_rapage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rapage),"?",0,0)+"");
        status.out.println("js:w_rapuif="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rapuif),"?",0,0)+"");
        status.out.println("js:w_titaui="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_titaui),"?",0,0)+"");
        status.out.println("js:w_flgpart="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgpart),"?",0,0)+"");
        status.out.println("js:w_prgidb="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_prgidb),"?",0,0)+"");
        status.out.println("js:w_prgnprg="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_prgnprg),"?",0,0)+"");
        status.out.println("js:w_prgiope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_prgiope),"?",0,0)+"");
        status.out.println("js:w_daData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_daData),"?",0,0)+"");
        status.out.println("js:w_dataover="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dataover),"?",0,0)+"");
        status.out.println("js:w_ngiorni="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ngiorni),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_frzuif,null)) {");
        status.out.println("window[f].w_frzuif="+SPLib.ToJSValue(status.w_frzuif,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_opeage,null)) {");
        status.out.println("window[f].w_opeage="+SPLib.ToJSValue(status.w_opeage,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_opeuif,null)) {");
        status.out.println("window[f].w_opeuif="+SPLib.ToJSValue(status.w_opeuif,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rapage,null)) {");
        status.out.println("window[f].w_rapage="+SPLib.ToJSValue(status.w_rapage,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rapuif,null)) {");
        status.out.println("window[f].w_rapuif="+SPLib.ToJSValue(status.w_rapuif,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_titaui,null)) {");
        status.out.println("window[f].w_titaui="+SPLib.ToJSValue(status.w_titaui,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgpart,null)) {");
        status.out.println("window[f].w_flgpart="+SPLib.ToJSValue(status.w_flgpart,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_prgidb,null)) {");
        status.out.println("window[f].w_prgidb="+SPLib.ToJSValue(status.w_prgidb,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_prgnprg,null)) {");
        status.out.println("window[f].w_prgnprg="+SPLib.ToJSValue(status.w_prgnprg,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_prgiope,null)) {");
        status.out.println("window[f].w_prgiope="+SPLib.ToJSValue(status.w_prgiope,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_daData,null)) {");
        status.out.println(" window[f].w_daData.setTime(("+SPLib.ToJSValue(status.w_daData,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_dataover,null)) {");
        status.out.println("window[f].w_dataover="+SPLib.ToJSValue(status.w_dataover,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ngiorni,null)) {");
        status.out.println("window[f].w_ngiorni="+SPLib.ToJSValue(status.w_ngiorni,"N",0,0)+";");
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
      arrt_riordinaR Rcalled;
      Rcalled = new arrt_riordinaR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_riordina");
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
