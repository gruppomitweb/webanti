import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_chkdiana_all extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*fc5e727a*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gPathApp;
    public String gPathDoc;
    public String gIntemediario;
    public String gUrlApp;
    public String gAzienda;
    public double gNumRec;
    public double gNumReg;
    public String gMsgImp;
    public String gMsgProc;
    public String gFlgWU;
    public String gCodDip;
    public String w_codcab;
    public String w_cabcod;
    public String w_desccit;
    public String w_citdesc;
    public String w_provin;
    public String w_provind;
    public String w_coddipe;
    public double w_agente;
    public String _note;
    public double _rownum;
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
    public String w_cdareg_rap;
    public String w_c_areg_rap;
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
    public String _tiprec;
    public String _raeatc;
    public String oldfolder;
    public String _tipoag;
    public String _datage;
    public String _numticket;
    public String w_cdareg;
    public String w_c_areg;
    public String z_codcab;
    public String z_desccit;
    public String z_provin;
    public String z_coddipe;
    public String _tiporap;
    public String cRitorno;
    public double _righe;
    public double _righetot;
    public double _numfile;
    public String _riga;
    public double tblnum;
    public String tblname_main;
    public double _maxrighe;
    public String _file1;
    public String _file2;
    public double _oldmc;
    public String cProg;
    public boolean _mlientiope;
    public boolean _clientiope;
    public boolean _mogopebo;
    public boolean _sogopebo;
    public boolean _meneficope;
    public boolean _beneficope;
    public boolean _merzistiope;
    public boolean _terzistiope;
    public boolean _mlientifrz;
    public boolean _clientifrz;
    public boolean _mogopefbo;
    public boolean _sogopefbo;
    public boolean _meneficfrz;
    public boolean _beneficfrz;
    public boolean _merzistifrz;
    public boolean _terzistifrz;
    public boolean _rapcoll;
    public boolean _rapcolleg;
    public boolean _xlientiope;
    public boolean _xogopebo;
    public boolean _xeneficope;
    public boolean _xerzistiope;
    public boolean _xlientifrz;
    public boolean _xogopefbo;
    public boolean _xeneficfrz;
    public boolean _xerzistifrz;
    public boolean _xapcoll;
    public boolean _xapcolleg;
    public String _nfile;
    public String pCodDip;
    public String pCodCab;
    public String pDesCit;
    public String pProv;
    public java.sql.Date w_DaData;
    public java.sql.Date w_AData;
    public java.sql.Date w_DaDataReg;
    public java.sql.Date w_ADataReg;
    public String pCli;
    public java.sql.Date pDatOpe;
    public String pRap;
    public String pTRap;
    public String pTipoR;
    public String pRAE;
    public String pSTATO;
    public java.sql.Date pDatRet;
    public double _usemc;
    public String cStringa;
    public String _tipsot;
    public String w_codinter;
    public String w_tipinter;
    public String w_codage;
    public String w_codcli;
    public String w_ragben;
    public String daope;
    public String a_ope;
    public String dareg;
    public String a_reg;
    public String w_tipoarchd;
    public String w_tipoarchp;
    public String w_stoper;
    public String w_flgope;
    public String w_flgfrz;
    public String w_flgrae;
    public String w_flgrap;
    public String w_tiprap;
    public String w_flgtit;
    public String w_tiptit;
    public String w_flgint;
    public String w_flgdel;
    public String w_flgchk;
    public String w_flgxls;
    public String w_flgsto;
    public String w_allsto;
    public String w_multifile;
    public String w_flg2020;
    public String aaaabaaaaaaaaaaaaaaaaaaaaaa_retval;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codinter","w_codinter");
      }        
      w_codinter = source.GetParameter("w_codinter","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipinter","w_tipinter");
      }        
      w_tipinter = source.GetParameter("w_tipinter","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codage","w_codage");
      }        
      w_codage = source.GetParameter("w_codage","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codcli","w_codcli");
      }        
      w_codcli = source.GetParameter("w_codcli","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ragben","w_ragben");
      }        
      w_ragben = source.GetParameter("w_ragben","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.daope","daope");
      }        
      daope = source.GetParameter("daope","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.a_ope","a_ope");
      }        
      a_ope = source.GetParameter("a_ope","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.dareg","dareg");
      }        
      dareg = source.GetParameter("dareg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.a_reg","a_reg");
      }        
      a_reg = source.GetParameter("a_reg","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipoarchd","w_tipoarchd");
      }        
      w_tipoarchd = source.GetParameter("w_tipoarchd","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipoarchp","w_tipoarchp");
      }        
      w_tipoarchp = source.GetParameter("w_tipoarchp","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_stoper","w_stoper");
      }        
      w_stoper = source.GetParameter("w_stoper","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgope","w_flgope");
      }        
      w_flgope = source.GetParameter("w_flgope","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgfrz","w_flgfrz");
      }        
      w_flgfrz = source.GetParameter("w_flgfrz","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgrae","w_flgrae");
      }        
      w_flgrae = source.GetParameter("w_flgrae","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgrap","w_flgrap");
      }        
      w_flgrap = source.GetParameter("w_flgrap","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tiprap","w_tiprap");
      }        
      w_tiprap = source.GetParameter("w_tiprap","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgtit","w_flgtit");
      }        
      w_flgtit = source.GetParameter("w_flgtit","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tiptit","w_tiptit");
      }        
      w_tiptit = source.GetParameter("w_tiptit","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgint","w_flgint");
      }        
      w_flgint = source.GetParameter("w_flgint","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgdel","w_flgdel");
      }        
      w_flgdel = source.GetParameter("w_flgdel","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgchk","w_flgchk");
      }        
      w_flgchk = source.GetParameter("w_flgchk","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgxls","w_flgxls");
      }        
      w_flgxls = source.GetParameter("w_flgxls","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgsto","w_flgsto");
      }        
      w_flgsto = source.GetParameter("w_flgsto","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_allsto","w_allsto");
      }        
      w_allsto = source.GetParameter("w_allsto","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_multifile","w_multifile");
      }        
      w_multifile = source.GetParameter("w_multifile","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flg2020","w_flg2020");
      }        
      w_flg2020 = source.GetParameter("w_flg2020","");
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_chkdiana_all";
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
    arrt_chkdiana_allR Rcalled;
    Rcalled = new arrt_chkdiana_allR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.aaaabaaaaaaaaaaaaaaaaaaaaaa_retval = Rcalled.Run(status.w_codinter,status.w_tipinter,status.w_codage,status.w_codcli,status.w_ragben,status.daope,status.a_ope,status.dareg,status.a_reg,status.w_tipoarchd,status.w_tipoarchp,status.w_stoper,status.w_flgope,status.w_flgfrz,status.w_flgrae,status.w_flgrap,status.w_tiprap,status.w_flgtit,status.w_tiptit,status.w_flgint,status.w_flgdel,status.w_flgchk,status.w_flgxls,status.w_flgsto,status.w_allsto,status.w_multifile,status.w_flg2020);
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
    return new arrt_chkdiana_allR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_chkdiana_allR Rcalled) throws IOException {
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
      status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_chkdiana_all"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
      if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
        status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
      }
    }
    status.PrintMutableParameters();
    status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(status.aaaabaaaaaaaaaaaaaaaaaaaaaa_retval))+"");
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
