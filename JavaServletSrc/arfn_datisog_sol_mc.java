import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arfn_datisog_sol_mc extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ccdce8ae*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String cRitorno;
    public String _numsto;
    public String _ramate;
    public String _tipsot;
    public String pCli;
    public java.sql.Date pDatOpe;
    public String pRap;
    public String pTRap;
    public String pTipoR;
    public String pRAE;
    public String pSTATO;
    public java.sql.Date pDatRet;
    MemoryCursor_personbo mcPersonbo;
    MemoryCursor_wersonbo mcWersonbo;
    public String aaaaaaaaaa_retval;
    void PrintMutableParameters() throws java.io.IOException {
      CPMemoryCursor l_PreviousResult = this.m_CursorResult;
      boolean l_PreviousMutated = this.m_bMutated;
      try {
        this.m_bMutated = true;
        this.out.println("djs:mcPersonbo=");
        this.m_CursorResult = this.mcPersonbo;
        JSResultSet(this);
        this.out.println();
        this.out.println("djs:mcWersonbo=");
        this.m_CursorResult = this.mcWersonbo;
        JSResultSet(this);
        this.out.println();
      } finally {
        this.m_CursorResult = l_PreviousResult;
        this.m_bMutated = l_PreviousMutated;
      }
    }
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pCli","pCli");
      }        
      pCli = source.GetParameter("pCli","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pDatOpe","pDatOpe");
      }        
      pDatOpe = source.GetParameter("pDatOpe",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pRap","pRap");
      }        
      pRap = source.GetParameter("pRap","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTRap","pTRap");
      }        
      pTRap = source.GetParameter("pTRap","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipoR","pTipoR");
      }        
      pTipoR = source.GetParameter("pTipoR","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pRAE","pRAE");
      }        
      pRAE = source.GetParameter("pRAE","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pSTATO","pSTATO");
      }        
      pSTATO = source.GetParameter("pSTATO","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pDatRet","pDatRet");
      }        
      pDatRet = source.GetParameter("pDatRet",CPLib.NullDate());
      Map<String,Object> l_UniqueIDs;
      l_UniqueIDs = new HashMap<String,Object>();
      Properties l_PropertiesRead;
      l_PropertiesRead = CPMemoryCursor.GetProperties(source.GetParameter("mcPersonbo",""));
      if (l_UniqueIDs.containsKey(l_PropertiesRead.getProperty("uniqueID"))) {
        mcPersonbo = (MemoryCursor_personbo)l_UniqueIDs.get(l_PropertiesRead.getProperty("uniqueID"));
      } else {
        mcPersonbo = new MemoryCursor_personbo(l_PropertiesRead,this.context);
        if ( ! (CPLib.IsNull(l_PropertiesRead.getProperty("uniqueID")))) {
          l_UniqueIDs.put(l_PropertiesRead.getProperty("uniqueID"),mcPersonbo);
        }
      }
      l_PropertiesRead = CPMemoryCursor.GetProperties(source.GetParameter("mcWersonbo",""));
      if (l_UniqueIDs.containsKey(l_PropertiesRead.getProperty("uniqueID"))) {
        mcWersonbo = (MemoryCursor_wersonbo)l_UniqueIDs.get(l_PropertiesRead.getProperty("uniqueID"));
      } else {
        mcWersonbo = new MemoryCursor_wersonbo(l_PropertiesRead,this.context);
        if ( ! (CPLib.IsNull(l_PropertiesRead.getProperty("uniqueID")))) {
          l_UniqueIDs.put(l_PropertiesRead.getProperty("uniqueID"),mcWersonbo);
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arfn_datisog_sol_mc";
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
  private void ExecuteRoutine(ServletStatus status) throws IOException {
    arfn_datisog_sol_mcR Rcalled;
    Rcalled = new arfn_datisog_sol_mcR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaaaaaaaa_retval = Rcalled.Run(status.pCli,status.pDatOpe,status.pRap,status.pTRap,status.pTipoR,status.pRAE,status.pSTATO,status.pDatRet,status.mcPersonbo,status.mcWersonbo);
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
    return new arfn_datisog_sol_mcR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arfn_datisog_sol_mcR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arfn_datisog_sol_mc"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.aaaaaaaaaa_retval))+"");
    status.out.println(
     " -->" +
    "");
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void Begin(ServletStatus status) throws IOException {
    if ( ! (CPLib.Empty(status.m_cGlobalsToRead))) {
      JSGlobals(status);
    } else if (CPLib.Empty(status.m_cBrowseName)) {
      ExecuteRoutine(status);
    } else {
      JSResultSet(status);
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
