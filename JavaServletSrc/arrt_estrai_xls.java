import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_estrai_xls extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*506bc57b*!";
  public class ServletStatus extends SPRoutineServletStatus {
    public String gMsgImp;
    public String gFileName;
    public String gFlgWU;
    public String gUrlApp;
    public String _gPathApp;
    public String _gAzienda;
    public String fhand;
    public String filenome;
    public double righe;
    public String cell01;
    public String column01;
    public double cell_count;
    public double riga_letta;
    public String _file;
    public java.sql.Date _dadata;
    public java.sql.Date _a_data;
    public String prova;
    public String foglio;
    public String _nfile;
    public String stringa;
    public String numero;
    public String dData;
    public String dataoggi;
    public String numprog;
    public String datareg;
    public java.sql.Date _datareg;
    public String dataope;
    public java.sql.Date _dataope;
    public String f_datope;
    public String f_datnas;
    public String f_datreg;
    public String tipope;
    public String cauana;
    public String causin;
    public String segno;
    public String valuta;
    public String divisa;
    public double cambio;
    public double totimp;
    public double totcon;
    public String codfisc;
    public String nominativo;
    public String indirizzo;
    public String citres;
    public String capres;
    public String prvres;
    public String stares;
    public String citnas;
    public String prvnas;
    public String stanas;
    public String sesso;
    public String datnas;
    public java.sql.Date _datnas;
    public String tipdoc;
    public String autril;
    public String numdoc;
    public String datril;
    public java.sql.Date _datril;
    public String _testa;
    public String _agetesta;
    public String _sqr;
    public String _coddip;
    public String _namdip;
    public String _citdip;
    public String _nomman;
    public String _cogman;
    public String _nazben;
    public String _luonas;
    public String _tipdoc;
    public String _numdoc;
    public String f_datdoc;
    public String _autril;
    public String _numprog;
    public String _mtcn;
    public String _macage;
    public String _stator;
    public String _rapporto;
    public double riga;
    public String _ndg;
    public String _cfestero;
    public String _numsto;
    public double _ctot;
    public String cNomeFile;
    public String cNomeFileZip;
    public java.sql.Date _datadoc;
    public double _max;
    public double _min;
    public double _tot;
    public double _mono;
    public double _cicli;
    public double _contacicli;
    public double _bottom;
    public double _top;
    public String _mstato;
    public String _rifimp;
    public String _rifimp2;
    public String _connesdoc;
    public java.sql.Date _datarett;
    public String _dcauana;
    public String _dcausin;
    public String _dpaeseres;
    public String _dpaesedes;
    public String _dtipoope;
    public String _dstator;
    public String prcProg;
    public String cOutput;
    public String _codstar;
    public double _totgen;
    public String fmhand;
    public String _file1;
    public String _file2;
    public double _totalone;
    public String _orgdati;
    public String _codinter;
    public String _prvdip;
    public String _cabdip;
    public String _inddip;
    public String _cfromdate;
    public String _c_todate;
    public String _nomefile;
    public String _ragsoc;
    public double _importo;
    public String _ajwcode;
    public String pTipo;
    public java.sql.Date w_dadata;
    public java.sql.Date w_adata;
    public String w_cdadata;
    public String w_c_adata;
    public String w_cDIP;
    public String w_xdesdip;
    public String w_ragosc;
    public String w_citnas;
    public String w_stanas;
    public java.sql.Date w_datnas;
    public String w_cMTCN;
    public String w_cCODFISC;
    public String w_ragben;
    public String w_staben;
    public String w_codmag;
    public String w_connes;
    public String w_nomefile;
    public String w_tipofile;
    public String w_flgsto;
    public String w_tipoout;
    public String w_opesel;
    public String w_frzsel;
    public String w_attive;
    public String w_destfold;
    public String pAzienda;
    public String pPath;
    public String pMese;
    public String pNCF;
    public String pSegno;
    public String pLstSta;
    public String pLstPrv;
    public double pImporto;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_dadata","w_dadata");
      }        
      w_dadata = source.GetParameter("w_dadata",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_adata","w_adata");
      }        
      w_adata = source.GetParameter("w_adata",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_cdadata","w_cdadata");
      }        
      w_cdadata = source.GetParameter("w_cdadata","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_c_adata","w_c_adata");
      }        
      w_c_adata = source.GetParameter("w_c_adata","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_cDIP","w_cDIP");
      }        
      w_cDIP = source.GetParameter("w_cDIP","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_xdesdip","w_xdesdip");
      }        
      w_xdesdip = source.GetParameter("w_xdesdip","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ragosc","w_ragosc");
      }        
      w_ragosc = source.GetParameter("w_ragosc","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_citnas","w_citnas");
      }        
      w_citnas = source.GetParameter("w_citnas","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_stanas","w_stanas");
      }        
      w_stanas = source.GetParameter("w_stanas","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_datnas","w_datnas");
      }        
      w_datnas = source.GetParameter("w_datnas",CPLib.NullDate());
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_cMTCN","w_cMTCN");
      }        
      w_cMTCN = source.GetParameter("w_cMTCN","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_cCODFISC","w_cCODFISC");
      }        
      w_cCODFISC = source.GetParameter("w_cCODFISC","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_ragben","w_ragben");
      }        
      w_ragben = source.GetParameter("w_ragben","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_staben","w_staben");
      }        
      w_staben = source.GetParameter("w_staben","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_codmag","w_codmag");
      }        
      w_codmag = source.GetParameter("w_codmag","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_connes","w_connes");
      }        
      w_connes = source.GetParameter("w_connes","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_nomefile","w_nomefile");
      }        
      w_nomefile = source.GetParameter("w_nomefile","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipofile","w_tipofile");
      }        
      w_tipofile = source.GetParameter("w_tipofile","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_flgsto","w_flgsto");
      }        
      w_flgsto = source.GetParameter("w_flgsto","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_tipoout","w_tipoout");
      }        
      w_tipoout = source.GetParameter("w_tipoout","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_opesel","w_opesel");
      }        
      w_opesel = source.GetParameter("w_opesel","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_frzsel","w_frzsel");
      }        
      w_frzsel = source.GetParameter("w_frzsel","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_attive","w_attive");
      }        
      w_attive = source.GetParameter("w_attive","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.w_destfold","w_destfold");
      }        
      w_destfold = source.GetParameter("w_destfold","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pAzienda","pAzienda");
      }        
      pAzienda = source.GetParameter("pAzienda","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pPath","pPath");
      }        
      pPath = source.GetParameter("pPath","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pMese","pMese");
      }        
      pMese = source.GetParameter("pMese","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pNCF","pNCF");
      }        
      pNCF = source.GetParameter("pNCF","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pSegno","pSegno");
      }        
      pSegno = source.GetParameter("pSegno","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pLstSta","pLstSta");
      }        
      pLstSta = source.GetParameter("pLstSta","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pLstPrv","pLstPrv");
      }        
      pLstPrv = source.GetParameter("pLstPrv","");
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pImporto","pImporto");
      }        
      pImporto = source.GetParameter("pImporto",0);
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_estrai_xls";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = true;
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
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pTipo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pTipo',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dadata,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_dadata',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_adata,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_adata',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+",'C');");
    status.out.println("l_oWv.setValue('w_cdadata',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+",'C');");
    status.out.println("l_oWv.setValue('w_c_adata',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cDIP,"C",6,0)+",'C');");
    status.out.println("l_oWv.setValue('w_cDIP',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdesdip,"C",30,0)+",'C');");
    status.out.println("l_oWv.setValue('w_xdesdip',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragosc,"C",60,0)+",'C');");
    status.out.println("l_oWv.setValue('w_ragosc',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_citnas,"C",40,0)+",'C');");
    status.out.println("l_oWv.setValue('w_citnas',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_stanas,"C",40,0)+",'C');");
    status.out.println("l_oWv.setValue('w_stanas',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datnas,"D",8,0)+",'D');");
    status.out.println("l_oWv.setValue('w_datnas',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cMTCN,"C",10,0)+",'C');");
    status.out.println("l_oWv.setValue('w_cMTCN',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cCODFISC,"C",16,0)+",'C');");
    status.out.println("l_oWv.setValue('w_cCODFISC',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragben,"C",60,0)+",'C');");
    status.out.println("l_oWv.setValue('w_ragben',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_staben,"C",40,0)+",'C');");
    status.out.println("l_oWv.setValue('w_staben',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codmag,"C",5,0)+",'C');");
    status.out.println("l_oWv.setValue('w_codmag',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_connes,"C",16,0)+",'C');");
    status.out.println("l_oWv.setValue('w_connes',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_nomefile,"C",60,0)+",'C');");
    status.out.println("l_oWv.setValue('w_nomefile',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipofile,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tipofile',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_flgsto',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoout,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_tipoout',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_opesel,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_opesel',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_frzsel,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_frzsel',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_attive,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('w_attive',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_destfold,"C",128,0)+",'C');");
    status.out.println("l_oWv.setValue('w_destfold',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pAzienda,"C",10,0)+",'C');");
    status.out.println("l_oWv.setValue('pAzienda',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pPath,"C",80,0)+",'C');");
    status.out.println("l_oWv.setValue('pPath',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pMese,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pMese',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pNCF,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pNCF',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pSegno,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pSegno',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pLstSta,"C",128,0)+",'C');");
    status.out.println("l_oWv.setValue('pLstSta',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pLstPrv,"C",128,0)+",'C');");
    status.out.println("l_oWv.setValue('pLstPrv',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pImporto,"N",15,2)+",'N');");
    status.out.println("l_oWv.setValue('pImporto',l_cV);");
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
    arrt_estrai_xlsR Rcalled;
    Rcalled = new arrt_estrai_xlsR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.pTipo,status.w_dadata,status.w_adata,status.w_cdadata,status.w_c_adata,status.w_cDIP,status.w_xdesdip,status.w_ragosc,status.w_citnas,status.w_stanas,status.w_datnas,status.w_cMTCN,status.w_cCODFISC,status.w_ragben,status.w_staben,status.w_codmag,status.w_connes,status.w_nomefile,status.w_tipofile,status.w_flgsto,status.w_tipoout,status.w_opesel,status.w_frzsel,status.w_attive,status.w_destfold,status.pAzienda,status.pPath,status.pMese,status.pNCF,status.pSegno,status.pLstSta,status.pLstPrv,status.pImporto);
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
    return new arrt_estrai_xlsR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_estrai_xlsR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.pTipo,status.w_dadata,status.w_adata,status.w_cdadata,status.w_c_adata,status.w_cDIP,status.w_xdesdip,status.w_ragosc,status.w_citnas,status.w_stanas,status.w_datnas,status.w_cMTCN,status.w_cCODFISC,status.w_ragben,status.w_staben,status.w_codmag,status.w_connes,status.w_nomefile,status.w_tipofile,status.w_flgsto,status.w_tipoout,status.w_opesel,status.w_frzsel,status.w_attive,status.w_destfold,status.pAzienda,status.pPath,status.pMese,status.pNCF,status.pSegno,status.pLstSta,status.pLstPrv,status.pImporto)))+"");
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_estrai_xls"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
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
      arrt_estrai_xlsR Rcalled;
      Rcalled = new arrt_estrai_xlsR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_estrai_xls");
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
