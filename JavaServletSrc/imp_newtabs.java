import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class imp_newtabs extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*8999c658*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String fhand;
    public String riga;
    public String _code1;
    public String _code;
    public String _code2;
    public String _code3;
    public String _code4;
    public String _code10;
    public String _code11;
    public String _code40;
    public double _codenum;
    public String _dbaicab;
    public double conta;
    public String _lista;
    public String _oldazi;
    public String _id4;
    public String _stringa;
    public double _id;
    public String gMsgImp;
    public String gMsgProc;
    public String w_tbcitta;
    public String w_tbstati;
    public String w_tbsetsin;
    public String w_tbcauana;
    public String w_inter2bo;
    public String w_tbvalute;
    public String w_tbtipreg;
    public String w_tbtipint;
    public String w_tbesitoage;
    public String w_tbrapp;
    public String w_tbstgru;
    public String w_tbramgru;
    public String w_tbtipdoc;
    public String w_tbtipleg;
    public String w_tbtipnat;
    public String w_tberrorisid;
    public String w_tberrsiddgn;
    public String w_tbricevutesid;
    public String w_tbcittna;
    public String w_tbstatna;
    public String w_tberrdge;
    public String w_tbprvreg;
    public String w_tbesielb;
    public String w_convgio;
    public String w_staticrs;
    public String w_tbcandistr;
    public String w_tbluonas;
    public String w_tbprovsv;
    public String w_rapogg;
    public String w_tbnatura;
    public String w_tbscopo;
    public String w_tbrisglob;
    public String pTipo;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcitta","w_tbcitta");
      }        
      w_tbcitta = source.GetParameter("w_tbcitta","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbstati","w_tbstati");
      }        
      w_tbstati = source.GetParameter("w_tbstati","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbsetsin","w_tbsetsin");
      }        
      w_tbsetsin = source.GetParameter("w_tbsetsin","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcauana","w_tbcauana");
      }        
      w_tbcauana = source.GetParameter("w_tbcauana","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_inter2bo","w_inter2bo");
      }        
      w_inter2bo = source.GetParameter("w_inter2bo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbvalute","w_tbvalute");
      }        
      w_tbvalute = source.GetParameter("w_tbvalute","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipreg","w_tbtipreg");
      }        
      w_tbtipreg = source.GetParameter("w_tbtipreg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipint","w_tbtipint");
      }        
      w_tbtipint = source.GetParameter("w_tbtipint","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbesitoage","w_tbesitoage");
      }        
      w_tbesitoage = source.GetParameter("w_tbesitoage","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbrapp","w_tbrapp");
      }        
      w_tbrapp = source.GetParameter("w_tbrapp","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbstgru","w_tbstgru");
      }        
      w_tbstgru = source.GetParameter("w_tbstgru","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbramgru","w_tbramgru");
      }        
      w_tbramgru = source.GetParameter("w_tbramgru","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipdoc","w_tbtipdoc");
      }        
      w_tbtipdoc = source.GetParameter("w_tbtipdoc","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipleg","w_tbtipleg");
      }        
      w_tbtipleg = source.GetParameter("w_tbtipleg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbtipnat","w_tbtipnat");
      }        
      w_tbtipnat = source.GetParameter("w_tbtipnat","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tberrorisid","w_tberrorisid");
      }        
      w_tberrorisid = source.GetParameter("w_tberrorisid","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tberrsiddgn","w_tberrsiddgn");
      }        
      w_tberrsiddgn = source.GetParameter("w_tberrsiddgn","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbricevutesid","w_tbricevutesid");
      }        
      w_tbricevutesid = source.GetParameter("w_tbricevutesid","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcittna","w_tbcittna");
      }        
      w_tbcittna = source.GetParameter("w_tbcittna","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbstatna","w_tbstatna");
      }        
      w_tbstatna = source.GetParameter("w_tbstatna","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tberrdge","w_tberrdge");
      }        
      w_tberrdge = source.GetParameter("w_tberrdge","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbprvreg","w_tbprvreg");
      }        
      w_tbprvreg = source.GetParameter("w_tbprvreg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbesielb","w_tbesielb");
      }        
      w_tbesielb = source.GetParameter("w_tbesielb","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_convgio","w_convgio");
      }        
      w_convgio = source.GetParameter("w_convgio","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_staticrs","w_staticrs");
      }        
      w_staticrs = source.GetParameter("w_staticrs","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbcandistr","w_tbcandistr");
      }        
      w_tbcandistr = source.GetParameter("w_tbcandistr","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbluonas","w_tbluonas");
      }        
      w_tbluonas = source.GetParameter("w_tbluonas","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbprovsv","w_tbprovsv");
      }        
      w_tbprovsv = source.GetParameter("w_tbprovsv","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_rapogg","w_rapogg");
      }        
      w_rapogg = source.GetParameter("w_rapogg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbnatura","w_tbnatura");
      }        
      w_tbnatura = source.GetParameter("w_tbnatura","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbscopo","w_tbscopo");
      }        
      w_tbscopo = source.GetParameter("w_tbscopo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tbrisglob","w_tbrisglob");
      }        
      w_tbrisglob = source.GetParameter("w_tbrisglob","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "imp_newtabs";
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
    return false;
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbcitta,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbcitta',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbstati,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbstati',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbsetsin,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbsetsin',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbcauana,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbcauana',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_inter2bo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_inter2bo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbvalute,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbvalute',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtipreg,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbtipreg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtipint,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbtipint',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbesitoage,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbesitoage',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbrapp,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbrapp',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbstgru,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbstgru',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbramgru,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbramgru',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtipdoc,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbtipdoc',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtipleg,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbtipleg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbtipnat,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbtipnat',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tberrorisid,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tberrorisid',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tberrsiddgn,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tberrsiddgn',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbricevutesid,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbricevutesid',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbcittna,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbcittna',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbstatna,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbstatna',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tberrdge,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tberrdge',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbprvreg,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbprvreg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbesielb,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbesielb',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_convgio,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_convgio',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_staticrs,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_staticrs',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbcandistr,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbcandistr',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbluonas,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbluonas',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbprovsv,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbprovsv',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rapogg,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_rapogg',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbnatura,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbnatura',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbscopo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbscopo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tbrisglob,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tbrisglob',l_cV);");
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
    imp_newtabsR Rcalled;
    Rcalled = new imp_newtabsR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.w_tbcitta,status.w_tbstati,status.w_tbsetsin,status.w_tbcauana,status.w_inter2bo,status.w_tbvalute,status.w_tbtipreg,status.w_tbtipint,status.w_tbesitoage,status.w_tbrapp,status.w_tbstgru,status.w_tbramgru,status.w_tbtipdoc,status.w_tbtipleg,status.w_tbtipnat,status.w_tberrorisid,status.w_tberrsiddgn,status.w_tbricevutesid,status.w_tbcittna,status.w_tbstatna,status.w_tberrdge,status.w_tbprvreg,status.w_tbesielb,status.w_convgio,status.w_staticrs,status.w_tbcandistr,status.w_tbluonas,status.w_tbprovsv,status.w_rapogg,status.w_tbnatura,status.w_tbscopo,status.w_tbrisglob,status.pTipo);
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
    return new imp_newtabsR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,imp_newtabsR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.w_tbcitta,status.w_tbstati,status.w_tbsetsin,status.w_tbcauana,status.w_inter2bo,status.w_tbvalute,status.w_tbtipreg,status.w_tbtipint,status.w_tbesitoage,status.w_tbrapp,status.w_tbstgru,status.w_tbramgru,status.w_tbtipdoc,status.w_tbtipleg,status.w_tbtipnat,status.w_tberrorisid,status.w_tberrsiddgn,status.w_tbricevutesid,status.w_tbcittna,status.w_tbstatna,status.w_tberrdge,status.w_tbprvreg,status.w_tbesielb,status.w_convgio,status.w_staticrs,status.w_tbcandistr,status.w_tbluonas,status.w_tbprovsv,status.w_rapogg,status.w_tbnatura,status.w_tbscopo,status.w_tbrisglob,status.pTipo)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","imp_newtabs"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
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
        if (status.m_bError) {
          l_cErrMsg = status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(status.m_cErrMsg));
          status.out.println("window[f].l_cErrorMsg="+SPLib.ToJSValue(l_cErrMsg,"C",0,0)+";");
          status.out.println("window[f].DisplayErrorMessage();");
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
      imp_newtabsR Rcalled;
      Rcalled = new imp_newtabsR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"imp_newtabs");
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
