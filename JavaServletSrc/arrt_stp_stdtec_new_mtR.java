// * --- Area Manuale = BO - Header
// * --- arrt_stp_stdtec_new_mt
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;

//import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.cos.*;
// * --- Fine Area Manuale
public class arrt_stp_stdtec_new_mtR implements CallerWithObjs {
  // gestori associati a particolari eventi ('Routine start')
  public static volatile java.util.Map<String,java.util.List<com.zucchetti.sitepainter.EventHandler>> specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile java.util.List<com.zucchetti.sitepainter.EventHandler> allEventsHandlers;
  // indica se si sta gestendo un evento scatenato da questa routine per restituire il valore corretto di i_EntityName ed i_EntityType
  static boolean m_bEventRunning;
  public String m_cLastMsgError;
  public boolean m_bError;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabile di caller (variabili di caller): passata nel costruttore
  public CallerWithObjs m_Caller;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_tmp_soggettioper;
  public String m_cServer_tmp_soggettioper;
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  String m_cServer;
  String m_cPhName;
  CPPhTableWrInfo m_oWrInfo;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public String pTipo;
  public String pAUI;
  public String pPDF;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public java.sql.Date w_DaDatReg;
  public java.sql.Date w_ADatReg;
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_daCodDip;
  public String w_aCodDip;
  public String w_flgrae;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  public String _id;
  public String _id2;
  public double _conta4;
  public double _conta3;
  public double _conta2;
  public double _conta;
  public String _numsto;
  public String w_c_dadata;
  public String w_c_adata;
  public String w_dacdatreg;
  public String w_acdatreg;
  public String xProg;
  public String lReport;
  public double _fint;
  public double _fope;
  public double _fter;
  public double _fben;
  public String _tipinter;
  public String _codinter;
  public String _dipcabinter;
  public String _dipcittainter;
  public String _dipprvinter;
  public String _dipcab;
  public String _dipcitta;
  public String _dipprv;
  public String _codint2;
  public MemoryCursor_anadip mcAnaDip;
  public MemoryCursor_mcsoggetti_mcrdef mcSoggetti;
  public MemoryCursor_mclistafile_mcrdef mcListFile;
  public MemoryCursor_mclistafile_mcrdef mcFileList;
  public MemoryCursor_mclistafile_mcrdef mcFileGroup;
  public MemoryCursorRow_mclistafile_mcrdef rowListFile;
  public double _contacli;
  public double _contater;
  public double _contaben;
  public double _contaopr;
  public double _contamli;
  public double _contamer;
  public double _contamen;
  public double _contampr;
  public String _cabinter;
  public String _citinter;
  public String _prvinter;
  public String nReport;
  public String _reportold;
  public String _reportname;
  public double _nrep;
  public String filepdf;
  public java.sql.Date _dataope;
  public String _tipocli;
  public String _tipoese;
  public String _tipoter;
  public String _tipoopr;
  public double _min;
  public double _max;
  public double _tot;
  public double _contacicli;
  public double _top;
  public double _bottom;
  public double _mono;
  public double _cicli;
  public double _lista;
  public double nPag;
  public String _varrep;
  public String _oldmsg;
  public String lReport1;
  public String gDescAzi;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_stdtec_new_mtR (CPContext p_ContextObject, Caller caller) {
    if (caller == null)
      m_Caller = CallerWithObjsImpl.EMPTY;
    else if (caller instanceof CallerWithObjs)
      m_Caller = (CallerWithObjs)caller;
    else
      m_Caller = new CallerWithObjsImpl(caller);
    m_Ctx=p_ContextObject;
    // Assegnazione della variabile di collegamento con il database
    m_Sql=m_Ctx.GetSql();
    /*  Impostazione dell'ambiente globale: il businness object si collega
                                all'oggetto globale (unico per più istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda è contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_stp_stdtec_new_mt",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    if (m_cPhName_meneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficfrz = m_cPhName_meneficfrz+" "+m_Ctx.GetWritePhName("meneficfrz");
    }
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    if (m_cPhName_meneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficope = m_cPhName_meneficope+" "+m_Ctx.GetWritePhName("meneficope");
    }
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    if (m_cPhName_merzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistifrz = m_cPhName_merzistifrz+" "+m_Ctx.GetWritePhName("merzistifrz");
    }
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    if (m_cPhName_merzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistiope = m_cPhName_merzistiope+" "+m_Ctx.GetWritePhName("merzistiope");
    }
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    if (m_cPhName_mlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientifrz = m_cPhName_mlientifrz+" "+m_Ctx.GetWritePhName("mlientifrz");
    }
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    if (m_cPhName_mlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientiope = m_cPhName_mlientiope+" "+m_Ctx.GetWritePhName("mlientiope");
    }
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    if (m_cPhName_mogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopebo = m_cPhName_mogopebo+" "+m_Ctx.GetWritePhName("mogopebo");
    }
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    if (m_cPhName_mogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopefbo = m_cPhName_mogopefbo+" "+m_Ctx.GetWritePhName("mogopefbo");
    }
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
      m_cPhName_tmp_soggettioper = p_ContextObject.GetPhName("tmp_soggettioper");
      if (m_cPhName_tmp_soggettioper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_soggettioper = m_cPhName_tmp_soggettioper+" "+m_Ctx.GetWritePhName("tmp_soggettioper");
      }
      m_cServer_tmp_soggettioper = p_ContextObject.GetServer("tmp_soggettioper");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta4",p_cVarName)) {
      return _conta4;
    }
    if (CPLib.eqr("_conta3",p_cVarName)) {
      return _conta3;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      return _conta2;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_fint",p_cVarName)) {
      return _fint;
    }
    if (CPLib.eqr("_fope",p_cVarName)) {
      return _fope;
    }
    if (CPLib.eqr("_fter",p_cVarName)) {
      return _fter;
    }
    if (CPLib.eqr("_fben",p_cVarName)) {
      return _fben;
    }
    if (CPLib.eqr("_contacli",p_cVarName)) {
      return _contacli;
    }
    if (CPLib.eqr("_contater",p_cVarName)) {
      return _contater;
    }
    if (CPLib.eqr("_contaben",p_cVarName)) {
      return _contaben;
    }
    if (CPLib.eqr("_contaopr",p_cVarName)) {
      return _contaopr;
    }
    if (CPLib.eqr("_contamli",p_cVarName)) {
      return _contamli;
    }
    if (CPLib.eqr("_contamer",p_cVarName)) {
      return _contamer;
    }
    if (CPLib.eqr("_contamen",p_cVarName)) {
      return _contamen;
    }
    if (CPLib.eqr("_contampr",p_cVarName)) {
      return _contampr;
    }
    if (CPLib.eqr("_nrep",p_cVarName)) {
      return _nrep;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      return _lista;
    }
    if (CPLib.eqr("nPag",p_cVarName)) {
      return nPag;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stp_stdtec_new_mt";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      return pAUI;
    }
    if (CPLib.eqr("pPDF",p_cVarName)) {
      return pPDF;
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      return w_daCodDip;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      return w_aCodDip;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      return w_flgrae;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    if (CPLib.eqr("_id2",p_cVarName)) {
      return _id2;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("dacdatreg",p_cVarName)) {
      return w_dacdatreg;
    }
    if (CPLib.eqr("acdatreg",p_cVarName)) {
      return w_acdatreg;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      return xProg;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      return lReport;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      return _tipinter;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_dipcabinter",p_cVarName)) {
      return _dipcabinter;
    }
    if (CPLib.eqr("_dipcittainter",p_cVarName)) {
      return _dipcittainter;
    }
    if (CPLib.eqr("_dipprvinter",p_cVarName)) {
      return _dipprvinter;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      return _dipcab;
    }
    if (CPLib.eqr("_dipcitta",p_cVarName)) {
      return _dipcitta;
    }
    if (CPLib.eqr("_dipprv",p_cVarName)) {
      return _dipprv;
    }
    if (CPLib.eqr("_codint2",p_cVarName)) {
      return _codint2;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      return _citinter;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      return _prvinter;
    }
    if (CPLib.eqr("nReport",p_cVarName)) {
      return nReport;
    }
    if (CPLib.eqr("_reportold",p_cVarName)) {
      return _reportold;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      return _reportname;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      return filepdf;
    }
    if (CPLib.eqr("_tipocli",p_cVarName)) {
      return _tipocli;
    }
    if (CPLib.eqr("_tipoese",p_cVarName)) {
      return _tipoese;
    }
    if (CPLib.eqr("_tipoter",p_cVarName)) {
      return _tipoter;
    }
    if (CPLib.eqr("_tipoopr",p_cVarName)) {
      return _tipoopr;
    }
    if (CPLib.eqr("_varrep",p_cVarName)) {
      return _varrep;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("lReport1",p_cVarName)) {
      return lReport1;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("DaDatReg",p_cVarName)) {
      return w_DaDatReg;
    }
    if (CPLib.eqr("ADatReg",p_cVarName)) {
      return w_ADatReg;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcAnaDip",p_cVarName)) {
      return mcAnaDip;
    }
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      return mcSoggetti;
    }
    if (CPLib.eqr("mcListFile",p_cVarName)) {
      return mcListFile;
    }
    if (CPLib.eqr("mcFileList",p_cVarName)) {
      return mcFileList;
    }
    if (CPLib.eqr("mcFileGroup",p_cVarName)) {
      return mcFileGroup;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowListFile",p_cVarName)) {
      return rowListFile;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta4",p_cVarName)) {
      _conta4 = value;
      return;
    }
    if (CPLib.eqr("_conta3",p_cVarName)) {
      _conta3 = value;
      return;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      _conta2 = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_fint",p_cVarName)) {
      _fint = value;
      return;
    }
    if (CPLib.eqr("_fope",p_cVarName)) {
      _fope = value;
      return;
    }
    if (CPLib.eqr("_fter",p_cVarName)) {
      _fter = value;
      return;
    }
    if (CPLib.eqr("_fben",p_cVarName)) {
      _fben = value;
      return;
    }
    if (CPLib.eqr("_contacli",p_cVarName)) {
      _contacli = value;
      return;
    }
    if (CPLib.eqr("_contater",p_cVarName)) {
      _contater = value;
      return;
    }
    if (CPLib.eqr("_contaben",p_cVarName)) {
      _contaben = value;
      return;
    }
    if (CPLib.eqr("_contaopr",p_cVarName)) {
      _contaopr = value;
      return;
    }
    if (CPLib.eqr("_contamli",p_cVarName)) {
      _contamli = value;
      return;
    }
    if (CPLib.eqr("_contamer",p_cVarName)) {
      _contamer = value;
      return;
    }
    if (CPLib.eqr("_contamen",p_cVarName)) {
      _contamen = value;
      return;
    }
    if (CPLib.eqr("_contampr",p_cVarName)) {
      _contampr = value;
      return;
    }
    if (CPLib.eqr("_nrep",p_cVarName)) {
      _nrep = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_lista",p_cVarName)) {
      _lista = value;
      return;
    }
    if (CPLib.eqr("nPag",p_cVarName)) {
      nPag = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      pAUI = value;
      return;
    }
    if (CPLib.eqr("pPDF",p_cVarName)) {
      pPDF = value;
      return;
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      w_daCodDip = value;
      return;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      w_aCodDip = value;
      return;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      w_flgrae = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
    if (CPLib.eqr("_id2",p_cVarName)) {
      _id2 = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("dacdatreg",p_cVarName)) {
      w_dacdatreg = value;
      return;
    }
    if (CPLib.eqr("acdatreg",p_cVarName)) {
      w_acdatreg = value;
      return;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      xProg = value;
      return;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      lReport = value;
      return;
    }
    if (CPLib.eqr("_tipinter",p_cVarName)) {
      _tipinter = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_dipcabinter",p_cVarName)) {
      _dipcabinter = value;
      return;
    }
    if (CPLib.eqr("_dipcittainter",p_cVarName)) {
      _dipcittainter = value;
      return;
    }
    if (CPLib.eqr("_dipprvinter",p_cVarName)) {
      _dipprvinter = value;
      return;
    }
    if (CPLib.eqr("_dipcab",p_cVarName)) {
      _dipcab = value;
      return;
    }
    if (CPLib.eqr("_dipcitta",p_cVarName)) {
      _dipcitta = value;
      return;
    }
    if (CPLib.eqr("_dipprv",p_cVarName)) {
      _dipprv = value;
      return;
    }
    if (CPLib.eqr("_codint2",p_cVarName)) {
      _codint2 = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      _citinter = value;
      return;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      _prvinter = value;
      return;
    }
    if (CPLib.eqr("nReport",p_cVarName)) {
      nReport = value;
      return;
    }
    if (CPLib.eqr("_reportold",p_cVarName)) {
      _reportold = value;
      return;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      _reportname = value;
      return;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      filepdf = value;
      return;
    }
    if (CPLib.eqr("_tipocli",p_cVarName)) {
      _tipocli = value;
      return;
    }
    if (CPLib.eqr("_tipoese",p_cVarName)) {
      _tipoese = value;
      return;
    }
    if (CPLib.eqr("_tipoter",p_cVarName)) {
      _tipoter = value;
      return;
    }
    if (CPLib.eqr("_tipoopr",p_cVarName)) {
      _tipoopr = value;
      return;
    }
    if (CPLib.eqr("_varrep",p_cVarName)) {
      _varrep = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("lReport1",p_cVarName)) {
      lReport1 = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("DaDatReg",p_cVarName)) {
      w_DaDatReg = value;
      return;
    }
    if (CPLib.eqr("ADatReg",p_cVarName)) {
      w_ADatReg = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowListFile",p_cVarName)) {
      rowListFile = (MemoryCursorRow_mclistafile_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcAnaDip",p_cVarName)) {
      mcAnaDip = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      mcSoggetti = (MemoryCursor_mcsoggetti_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcListFile",p_cVarName)) {
      mcListFile = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFileList",p_cVarName)) {
      mcFileList = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFileGroup",p_cVarName)) {
      mcFileGroup = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* pTipo Char(1) // Operazioni - Frazionate */
      /* pAUI Char(1) // Definitivo - Provvisorio */
      /* pPDF Char(6) // Tipologia PDF */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_DaDatReg Date */
      /* w_ADatReg Date */
      /* w_daCodCli Char(16) */
      /* w_aCodCli Char(16) */
      /* w_daCodDip Char(6) */
      /* w_aCodDip Char(6) */
      /* w_flgrae Char(1) := 'A' // Rae/ateco */
      /* _nomerep Memo // Nome Stampa */
      /* _report Object(ReportLibrary) */
      /* bReport Bool */
      /* _id Char(6) */
      /* _id2 Char(6) */
      /* _conta4 Numeric(6, 0) */
      /* _conta3 Numeric(2, 0) */
      /* _conta2 Numeric(6, 0) */
      /* _conta Numeric(10, 0) */
      /* _numsto Char(15) */
      /* w_c_dadata Char(8) */
      /* w_c_adata Char(8) */
      /* w_dacdatreg Char(8) */
      /* w_acdatreg Char(8) */
      /* xProg Char(15) */
      /* lReport Memo */
      /* _fint Numeric(1, 0) */
      /* _fope Numeric(1, 0) */
      /* _fter Numeric(1, 0) */
      /* _fben Numeric(1, 0) */
      /* _tipinter Char(2) */
      /* _codinter Char(11) */
      /* _dipcabinter Char(6) // cab dipendenza intermediario */
      /* _dipcittainter Char(30) // Citta dipendenza intermediario */
      /* _dipprvinter Char(2) // provincia dipendenza intermediario */
      /* _dipcab Char(6) // cab dipendenza */
      /* _dipcitta Char(30) // Citta dipendenza */
      /* _dipprv Char(2) // provincia dipendenza */
      /* _codint2 Char(11) // provincia dipendenza */
      /* mcAnaDip MemoryCursor(anadip) */
      /* mcSoggetti MemoryCursor(mcSoggetti.MCRDef) */
      /* mcListFile MemoryCursor(mcListaFile.MCRDef) */
      /* mcFileList MemoryCursor(mcListaFile.MCRDef) */
      /* mcFileGroup MemoryCursor(mcListaFile.MCRDef) */
      /* rowListFile Row(mcListaFile.MCRDef) */
      /* _contacli Numeric(10, 0) */
      /* _contater Numeric(10, 0) */
      /* _contaben Numeric(10, 0) */
      /* _contaopr Numeric(10, 0) */
      /* _contamli Numeric(10, 0) */
      /* _contamer Numeric(10, 0) */
      /* _contamen Numeric(10, 0) */
      /* _contampr Numeric(10, 0) */
      /* _cabinter Char(6) */
      /* _citinter Char(30) */
      /* _prvinter Char(2) */
      /* nReport Char(100) */
      /* _reportold Char(100) */
      /* _reportname Char(100) */
      /* _nrep Numeric(10, 0) */
      /* filepdf Char(128) */
      /* _dataope Date */
      /* _tipocli Char(1) */
      /* _tipoese Char(1) */
      /* _tipoter Char(1) */
      /* _tipoopr Char(1) */
      /* _min Numeric(10, 0) */
      /* _max Numeric(10, 0) */
      /* _tot Numeric(10, 0) */
      /* _contacicli Numeric(10, 0) */
      /* _top Numeric(10, 0) */
      /* _bottom Numeric(10, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _lista Numeric(10, 0) */
      /* nPag Numeric(10, 0) */
      /* _varrep Char(30) */
      /* _oldmsg Memo */
      /* lReport1 Memo */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Drop temporary table tmp_stpoperazioni
      if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpoperazioni");
      }
      // * --- Drop temporary table tmp_soggettioper
      if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_soggettioper");
      }
      // * --- Create temporary table tmp_stpoperazioni
      if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpoperazioni");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpoperazioni");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpoperazioni"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpoperazioni",m_cServer,"proto")),m_cPhName,"tmp_stpoperazioni",m_Ctx);
      }
      m_cPhName_tmp_stpoperazioni = m_cPhName;
      // * --- Create temporary table tmp_soggettioper
      if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_soggettioper");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_soggettioper");
      if ( ! (m_Ctx.IsSharedTemp("tmp_soggettioper"))) {
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_soggettioper",m_cServer,"proto")),m_cPhName,"tmp_soggettioper",m_Ctx,new String[]{"IDBASE,TIPOPERS,CONNES"});
      }
      m_cPhName_tmp_soggettioper = m_cPhName;
      // * --- Fill memory cursor mcAnaDip on anadip
      mcAnaDip.Zap();
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      if (Cursor_anadip!=null)
        Cursor_anadip.Close();
      Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_anadip;
        Cursor_anadip.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_stp_stdtec_new_mt: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_anadip.Eof())) {
        mcAnaDip.AppendWithTrimmedKey(Cursor_anadip.GetString("CODDIP"));
        mcAnaDip.row.CODDIP = Cursor_anadip.GetString("CODDIP");
        mcAnaDip.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
        mcAnaDip.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
        mcAnaDip.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
        mcAnaDip.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
        mcAnaDip.row.CAB = Cursor_anadip.GetString("CAB");
        mcAnaDip.row.IDBASE = Cursor_anadip.GetString("IDBASE");
        mcAnaDip.row.AGENTE = Cursor_anadip.GetString("AGENTE");
        mcAnaDip.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
        mcAnaDip.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
        mcAnaDip.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
        mcAnaDip.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
        mcAnaDip.row.CODLOC = Cursor_anadip.GetString("CODLOC");
        mcAnaDip.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
        mcAnaDip.row.NUOVO = Cursor_anadip.GetString("NUOVO");
        mcAnaDip.row.CAP = Cursor_anadip.GetString("CAP");
        mcAnaDip.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
        mcAnaDip.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
        mcAnaDip.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
        mcAnaDip.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
        mcAnaDip.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
        mcAnaDip.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
        mcAnaDip.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
        mcAnaDip.row.FLGATT = Cursor_anadip.GetString("FLGATT");
        mcAnaDip.row.CODAGE = Cursor_anadip.GetString("CODAGE");
        mcAnaDip.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
        mcAnaDip.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
        mcAnaDip.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
        mcAnaDip.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
        mcAnaDip.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
        mcAnaDip.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
        mcAnaDip.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
        mcAnaDip.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
        mcAnaDip.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
        mcAnaDip.row.CAB2 = Cursor_anadip.GetString("CAB2");
        mcAnaDip.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
        mcAnaDip.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
        mcAnaDip.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
        mcAnaDip.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
        mcAnaDip.row.CODFISC = Cursor_anadip.GetString("CODFISC");
        mcAnaDip.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
        mcAnaDip.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
        mcAnaDip.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
        mcAnaDip.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
        mcAnaDip.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
        mcAnaDip.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
        mcAnaDip.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
        Cursor_anadip.Next();
      }
      m_cConnectivityError = Cursor_anadip.ErrorMessage();
      Cursor_anadip.Close();
      mcAnaDip.GoTop();
      /* nReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+LibreriaMit.UniqueId()+'.pdf' */
      nReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+LibreriaMit.UniqueId()+".pdf";
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000064status;
      nTry00000064status = m_Sql.GetTransactionStatus();
      String cTry00000064msg;
      cTry00000064msg = m_Sql.TransactionErrorMessage();
      try {
        /* w_c_dadata := iif(Empty(w_DaDatOpe),'',DateToChar(w_DaDatOpe)) */
        w_c_dadata = (CPLib.Empty(w_DaDatOpe)?"":CPLib.DateToChar(w_DaDatOpe));
        /* w_c_adata := iif(Empty(w_ADatOpe),'',DateToChar(w_ADatOpe)) */
        w_c_adata = (CPLib.Empty(w_ADatOpe)?"":CPLib.DateToChar(w_ADatOpe));
        /* w_dacdatreg := iif(Empty(w_DaDatReg),'',DateToChar(w_DaDatReg)) */
        w_dacdatreg = (CPLib.Empty(w_DaDatReg)?"":CPLib.DateToChar(w_DaDatReg));
        /* w_acdatreg := iif(Empty(w_ADatReg),'',DateToChar(w_ADatReg)) */
        w_acdatreg = (CPLib.Empty(w_ADatReg)?"":CPLib.DateToChar(w_ADatReg));
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _fint := 0 */
        _fint = CPLib.Round(0,0);
        /* _fter := 0 */
        _fter = CPLib.Round(0,0);
        /* _fben := 0 */
        _fben = CPLib.Round(0,0);
        /* _fope := 0 */
        _fope = CPLib.Round(0,0);
        /* _contacli := 0 */
        _contacli = CPLib.Round(0,0);
        /* _contater := 0 */
        _contater = CPLib.Round(0,0);
        /* _contaben := 0 */
        _contaben = CPLib.Round(0,0);
        /* _contaopr := 0 */
        _contaopr = CPLib.Round(0,0);
        /* _nrep := 1 */
        _nrep = CPLib.Round(1,0);
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _dipcabinter := intermbo->CODCAB // cab dipendenza intermediario */
          _dipcabinter = Cursor_intermbo.GetString("CODCAB");
          /* _dipcittainter := intermbo->DESCCIT // Citta dipendenza intermediario */
          _dipcittainter = Cursor_intermbo.GetString("DESCCIT");
          /* _dipprvinter := intermbo->PROVINCIA // provincia dipendenza intermediario */
          _dipprvinter = Cursor_intermbo.GetString("PROVINCIA");
          /* _tipinter := intermbo->TIPINTER */
          _tipinter = Cursor_intermbo.GetString("TIPINTER");
          /* _codinter := Left(LRTrim(intermbo->CODFISC),11) */
          _codinter = CPLib.Left(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),11);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Lancio la stampa */
        /* Case pTipo='O' and pAUI='D' */
        if (CPLib.eqr(pTipo,"O") && CPLib.eqr(pAUI,"D")) {
          /* Exec "Operazioni AUI" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pTipo='O' and pAUI='P' */
        } else if (CPLib.eqr(pTipo,"O") && CPLib.eqr(pAUI,"P")) {
          /* Exec "Operazioni Prov." Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pTipo='F' and pAUI='D' */
        } else if (CPLib.eqr(pTipo,"F") && CPLib.eqr(pAUI,"D")) {
          /* Exec "Frazionate AUI" Page 4:Page_4 */
          Page_4();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Case pTipo='F' and pAUI='P' */
        } else if (CPLib.eqr(pTipo,"F") && CPLib.eqr(pAUI,"P")) {
          /* Exec "Frazionate Prov." Page 5:Page_5 */
          Page_5();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End Case
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000064status,0)) {
          m_Sql.SetTransactionStatus(nTry00000064status,cTry00000064msg);
        }
      }
      /* If mcFileList.RecCount() > 0 */
      if (CPLib.gt(mcFileList.RecCount(),0)) {
        /* gMsgImp := 'Creazione Documento Finale' // Messaggio Import */
        gMsgImp = "Creazione Documento Finale";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + NL + 'Ora Inizio Creazione Documento: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"\n"+"Ora Inizio Creazione Documento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _reportname := 'stampa_stdtec_'+DateToChar(Date())+'.pdf' */
        _reportname = "stampa_stdtec_"+CPLib.DateToChar(CPLib.Date())+".pdf";
        /* lReport := LRTrim(gPathApp)+'/output/'+LRTrim(gAzienda)+'/'+LRTrim(_reportname) */
        lReport = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_reportname);
        // Crea le variabili per per il merge
        PDFMergerUtility merger2 = new PDFMergerUtility();
        merger2.setDestinationFileName(lReport);
        for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcFileList._iterable_()) {
          /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile) */
          lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile);
          /* merger2.addSource(lReport) */
          merger2.addSource(lReport);
        }
        // Scrive il pdf mergiato
        merger2.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
        for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcFileList._iterable_()) {
          /* FileLibMit.DeleteFile('stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile)) */
          FileLibMit.DeleteFile("stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile));
        }
        /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Ora Fine Creazione Documento: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Creazione Documento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc+ 'Sono state elaborate '+LRTrim(Str(_conta,10,0))+iif(pTipo='O'," operazioni"," frazionate") + NL */
        gMsgProc = gMsgProc+"Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+(CPLib.eqr(pTipo,"O")?" operazioni":" frazionate")+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* filepdf := LRTrim(Strtran(gPathApp,'/','//'))+"//output//"+LRTrim(gAzienda)+"//"+LRTrim(_reportname) */
        filepdf = CPLib.LRTrim(CPLib.Strtran(gPathApp,"/","//"))+"//output//"+CPLib.LRTrim(gAzienda)+"//"+CPLib.LRTrim(_reportname);
        /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(filepdf) */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(filepdf),false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non sono stati trovati dati per i parametri inseriti' + NL */
        gMsgProc = gMsgProc+"Non sono stati trovati dati per i parametri inseriti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + NL + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"\n"+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Stop LRTrim(gUrlApp)+"blank.htm" */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"blank.htm",false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_alloperazbo_min_max=null;
    CPResultSet Cursor_qbe_alloperazbo_lim=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_mogopebo=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_merzistiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_meneficope=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000099;
      _h00000099 = new SPBridge.HMCaller();
      _h00000099.Set("m_cVQRList",m_cVQRList);
      _h00000099.Set("tbname","clientiope");
      _h00000099.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000099,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contacli := qbe_tab_mmc->tot */
        _contacli = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000009B;
      _h0000009B = new SPBridge.HMCaller();
      _h0000009B.Set("m_cVQRList",m_cVQRList);
      _h0000009B.Set("tbname","sogopebo");
      _h0000009B.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000009B,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaopr := qbe_tab_mmc->tot */
        _contaopr = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000009D;
      _h0000009D = new SPBridge.HMCaller();
      _h0000009D.Set("m_cVQRList",m_cVQRList);
      _h0000009D.Set("tbname","terzistiope");
      _h0000009D.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000009D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contater := qbe_tab_mmc->tot */
        _contater = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000009F;
      _h0000009F = new SPBridge.HMCaller();
      _h0000009F.Set("m_cVQRList",m_cVQRList);
      _h0000009F.Set("tbname","beneficope");
      _h0000009F.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000009F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaben := qbe_tab_mmc->tot */
        _contaben = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000000A1;
      _h000000A1 = new SPBridge.HMCaller();
      _h000000A1.Set("m_cVQRList",m_cVQRList);
      _h000000A1.Set("tbname","mlientiope");
      _h000000A1.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A1,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contamli := qbe_tab_mmc->tot */
        _contamli = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000000A3;
      _h000000A3 = new SPBridge.HMCaller();
      _h000000A3.Set("m_cVQRList",m_cVQRList);
      _h000000A3.Set("tbname","mogopebo");
      _h000000A3.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A3,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contampr := qbe_tab_mmc->tot */
        _contampr = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000000A5;
      _h000000A5 = new SPBridge.HMCaller();
      _h000000A5.Set("m_cVQRList",m_cVQRList);
      _h000000A5.Set("tbname","merzistiope");
      _h000000A5.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A5,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contamer := qbe_tab_mmc->tot */
        _contamer = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000000A7;
      _h000000A7 = new SPBridge.HMCaller();
      _h000000A7.Set("m_cVQRList",m_cVQRList);
      _h000000A7.Set("tbname","meneficope");
      _h000000A7.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A7,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contamen := qbe_tab_mmc->tot */
        _contamen = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* nPag := 1 */
      nPag = CPLib.Round(1,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_alloperazbo_min_max
      SPBridge.HMCaller _h000000AE;
      _h000000AE = new SPBridge.HMCaller();
      _h000000AE.Set("m_cVQRList",m_cVQRList);
      _h000000AE.Set("c_dadata",w_c_dadata);
      _h000000AE.Set("c_adata",w_c_adata);
      _h000000AE.Set("daCodCli",w_daCodCli);
      _h000000AE.Set("aCodCli",w_aCodCli);
      _h000000AE.Set("daCodDip",w_daCodDip);
      _h000000AE.Set("aCodDip",w_aCodDip);
      _h000000AE.Set("dacdatreg",w_dacdatreg);
      _h000000AE.Set("acdatreg",w_acdatreg);
      _h000000AE.Set("DaDatReg",w_DaDatReg);
      _h000000AE.Set("ADatReg",w_ADatReg);
      if (Cursor_qbe_alloperazbo_min_max!=null)
        Cursor_qbe_alloperazbo_min_max.Close();
      Cursor_qbe_alloperazbo_min_max = new VQRHolder("qbe_alloperazbo_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000AE,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_alloperazbo_min_max.Eof())) {
        /* _min := qbe_alloperazbo_min_max->min */
        _min = CPLib.Round(Cursor_qbe_alloperazbo_min_max.GetDouble("min"),0);
        /* _max := qbe_alloperazbo_min_max->max */
        _max = CPLib.Round(Cursor_qbe_alloperazbo_min_max.GetDouble("max"),0);
        /* _tot := _max - _min */
        _tot = CPLib.Round(_max-_min,0);
        Cursor_qbe_alloperazbo_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_alloperazbo_min_max.ErrorMessage();
      Cursor_qbe_alloperazbo_min_max.Close();
      // * --- End Select
      /* _mono := iif(_tot > 1000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,1000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_tot,1000) <> 0,Int(_tot/1000) + 1,Int(_tot/1000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_tot,1000),0)?CPLib.Int(_tot/1000)+1:CPLib.Int(_tot/1000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* While _contacicli<=_cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _contacicli=1 */
          if (CPLib.eqr(_contacicli,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 999 */
            _top = CPLib.Round(_min+999,0);
            /* ElseIf _contacicli = _cicli */
          } else if (CPLib.eqr(_contacicli,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 999 */
            _top = CPLib.Round(_bottom+999,0);
          } // End If
        } // End If
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto eseguendo il ciclo '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli)) + " del file operazioni" // Messaggio */
          gMsgProc = gMsgProc+"Sto eseguendo il ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli))+" del file operazioni";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto eseguendo il ciclo '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli)) + " del file operazioni") // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto eseguendo il ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli))+" del file operazioni");
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sto eseguendo il ciclo '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli)) + " del file operazioni" */
        _oldmsg = "Sto eseguendo il ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli))+" del file operazioni";
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Delete from tmp_stpoperazioni
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000000CA")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Delete from tmp_soggettioper
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000000CB")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* _fope := 0 */
          _fope = CPLib.Round(0,0);
          // * --- Select from qbe_alloperazbo_lim
          SPBridge.HMCaller _h000000CD;
          _h000000CD = new SPBridge.HMCaller();
          _h000000CD.Set("m_cVQRList",m_cVQRList);
          _h000000CD.Set("c_dadata",w_c_dadata);
          _h000000CD.Set("c_adata",w_c_adata);
          _h000000CD.Set("daCodCli",w_daCodCli);
          _h000000CD.Set("aCodCli",w_aCodCli);
          _h000000CD.Set("daCodDip",w_daCodDip);
          _h000000CD.Set("aCodDip",w_aCodDip);
          _h000000CD.Set("_bottom",_bottom);
          _h000000CD.Set("_top",_top);
          _h000000CD.Set("dacdatreg",w_dacdatreg);
          _h000000CD.Set("acdatreg",w_acdatreg);
          _h000000CD.Set("DaDatReg",w_DaDatReg);
          _h000000CD.Set("ADatReg",w_ADatReg);
          if (Cursor_qbe_alloperazbo_lim!=null)
            Cursor_qbe_alloperazbo_lim.Close();
          Cursor_qbe_alloperazbo_lim = new VQRHolder("qbe_alloperazbo_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000CD,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_alloperazbo_lim.Eof())) {
            /* _fope := 1 */
            _fope = CPLib.Round(1,0);
            /* _dataope := qbe_alloperazbo_lim->DATAOPE */
            _dataope = Cursor_qbe_alloperazbo_lim.GetDate("DATAOPE");
            /* gMsgImp := "Sto elaborando l'operazione con codice "+LRTrim(qbe_alloperazbo_lim->NUMPROG) // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con codice "+CPLib.LRTrim(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
            _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
            /* If _dataope < CharToDate('20140101') */
            if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
              /* _tipocli := iif(Empty(LRTrim(qbe_alloperazbo_lim->CONNESOPER)),'2','3') */
              _tipocli = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER")))?"2":"3");
              /* _tipoopr := '4' */
              _tipoopr = "4";
              /* _tipoter := '6' */
              _tipoter = "6";
            } else { // Else
              /* _tipocli := '7' */
              _tipocli = "7";
              /* _tipoopr := '8' */
              _tipoopr = "8";
              /* _tipoter := '9' */
              _tipoter = "9";
            } // End If
            /* If not(Empty(LRTrim(qbe_alloperazbo_lim->CODINT2))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_alloperazbo_lim.GetString("CODINT2"))))) {
              // * --- Read from inter2bo
              m_cServer = m_Ctx.GetServer("inter2bo");
              m_cPhName = m_Ctx.GetPhName("inter2bo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_alloperazbo_lim.GetString("CODINT2"));
              if (m_Ctx.IsSharedTemp("inter2bo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codint2 = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec_new_mt returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codint2 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(qbe_alloperazbo_lim->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_alloperazbo_lim.GetString("CODDIPE"))) {
              /* _cabinter := _dipcabinter */
              _cabinter = _dipcabinter;
              /* _citinter := _dipcittainter */
              _citinter = _dipcittainter;
              /* _prvinter := _dipprvinter */
              _prvinter = _dipprvinter;
            } else { // Else
              /* If mcAnaDip.GoToKey(qbe_alloperazbo_lim->CODDIPE) */
              if (mcAnaDip.GoToKey(Cursor_qbe_alloperazbo_lim.GetString("CODDIPE"))) {
                /* _cabinter := mcAnaDip.CAB */
                _cabinter = mcAnaDip.row.CAB;
                /* _citinter := mcAnaDip.DESCCIT */
                _citinter = mcAnaDip.row.DESCCIT;
                /* _prvinter := mcAnaDip.PROVINCIA */
                _prvinter = mcAnaDip.row.PROVINCIA;
              } // End If
            } // End If
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000000E4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E4(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If not(Empty(qbe_alloperazbo_lim->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fint := 1 */
              _fint = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_alloperazbo_lim->CONNESCLI,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000000EF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000EF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contacli > 0 */
              if (CPLib.gt(_contacli,0)) {
                // * --- Select from clientiope
                m_cServer = m_Ctx.GetServer("clientiope");
                m_cPhName = m_Ctx.GetPhName("clientiope");
                if (Cursor_clientiope!=null)
                  Cursor_clientiope.Close();
                Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_clientiope.Eof())) {
                  /* If clientiope->CODSOG <> qbe_alloperazbo_lim->CONNESCLI */
                  if (CPLib.ne(Cursor_clientiope.GetString("CODSOG"),Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fint := 1 */
                    _fint = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(clientiope->CODSOG,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000000FC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000FC(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_clientiope.Next();
                }
                m_cConnectivityError = Cursor_clientiope.ErrorMessage();
                Cursor_clientiope.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contamli > 0 */
              if (CPLib.gt(_contamli,0)) {
                // * --- Select from mlientiope
                m_cServer = m_Ctx.GetServer("mlientiope");
                m_cPhName = m_Ctx.GetPhName("mlientiope");
                if (Cursor_mlientiope!=null)
                  Cursor_mlientiope.Close();
                Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_mlientiope.Eof())) {
                  /* If mlientiope->CODSOG <> qbe_alloperazbo_lim->CONNESCLI */
                  if (CPLib.ne(Cursor_mlientiope.GetString("CODSOG"),Cursor_qbe_alloperazbo_lim.GetString("CONNESCLI"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fint := 1 */
                    _fint = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(mlientiope->CODSOG,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_mlientiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_mlientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000109")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000109(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_mlientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_mlientiope.Next();
                }
                m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
                Cursor_mlientiope.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(qbe_alloperazbo_lim->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fope := 1 */
              _fope = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_alloperazbo_lim->CONNESOPER,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000114")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000114(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contaopr > 0 */
              if (CPLib.gt(_contaopr,0)) {
                // * --- Select from sogopebo
                m_cServer = m_Ctx.GetServer("sogopebo");
                m_cPhName = m_Ctx.GetPhName("sogopebo");
                if (Cursor_sogopebo!=null)
                  Cursor_sogopebo.Close();
                Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_sogopebo.Eof())) {
                  /* If sogopebo->CODSOG <> qbe_alloperazbo_lim->CONNESOPER */
                  if (CPLib.ne(Cursor_sogopebo.GetString("CODSOG"),Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fope := 1 */
                    _fope = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(sogopebo->CODSOG,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_sogopebo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000121")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000121(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_sogopebo.Next();
                }
                m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
                Cursor_sogopebo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contampr > 0 */
              if (CPLib.gt(_contampr,0)) {
                // * --- Select from mogopebo
                m_cServer = m_Ctx.GetServer("mogopebo");
                m_cPhName = m_Ctx.GetPhName("mogopebo");
                if (Cursor_mogopebo!=null)
                  Cursor_mogopebo.Close();
                Cursor_mogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_mogopebo.Eof())) {
                  /* If mogopebo->CODSOG <> qbe_alloperazbo_lim->CONNESOPER */
                  if (CPLib.ne(Cursor_mogopebo.GetString("CODSOG"),Cursor_qbe_alloperazbo_lim.GetString("CONNESOPER"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fope := 1 */
                    _fope = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(mogopebo->CODSOG,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_mogopebo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_mogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000012E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000012E(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_mogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_mogopebo.Next();
                }
                m_cConnectivityError = Cursor_mogopebo.ErrorMessage();
                Cursor_mogopebo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(qbe_alloperazbo_lim->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo_lim.GetString("CONNALTRO")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fter := 1 */
              _fter = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_alloperazbo_lim->CONNALTRO,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_alloperazbo_lim.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000139")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000139(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contater > 0 */
              if (CPLib.gt(_contater,0)) {
                // * --- Select from terzistiope
                m_cServer = m_Ctx.GetServer("terzistiope");
                m_cPhName = m_Ctx.GetPhName("terzistiope");
                if (Cursor_terzistiope!=null)
                  Cursor_terzistiope.Close();
                Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_terzistiope.Eof())) {
                  /* If terzistiope->CODSOG <> qbe_alloperazbo_lim->CONNALTRO */
                  if (CPLib.ne(Cursor_terzistiope.GetString("CODSOG"),Cursor_qbe_alloperazbo_lim.GetString("CONNALTRO"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fter := 1 */
                    _fter = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(terzistiope->CODSOG,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000146")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000146(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_terzistiope.Next();
                }
                m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
                Cursor_terzistiope.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contamer > 0 */
              if (CPLib.gt(_contamer,0)) {
                // * --- Select from merzistiope
                m_cServer = m_Ctx.GetServer("merzistiope");
                m_cPhName = m_Ctx.GetPhName("merzistiope");
                if (Cursor_merzistiope!=null)
                  Cursor_merzistiope.Close();
                Cursor_merzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_merzistiope.Eof())) {
                  /* If merzistiope->CODSOG <> qbe_alloperazbo_lim->CONNALTRO */
                  if (CPLib.ne(Cursor_merzistiope.GetString("CODSOG"),Cursor_qbe_alloperazbo_lim.GetString("CONNALTRO"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fter := 1 */
                    _fter = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(merzistiope->CODSOG,iif(qbe_alloperazbo_lim->STATOREG<>'1',qbe_alloperazbo_lim->DATAREG,qbe_alloperazbo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_merzistiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_alloperazbo_lim.GetDate("DATAREG"):Cursor_qbe_alloperazbo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_merzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000153")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000153(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_merzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_merzistiope.Next();
                }
                m_cConnectivityError = Cursor_merzistiope.ErrorMessage();
                Cursor_merzistiope.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(qbe_alloperazbo_lim->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_alloperazbo_lim.GetString("C_RAG")))) {
              /* _fben := 1 */
              _fben = CPLib.Round(1,0);
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000158")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000158(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_alloperazbo_lim.GetString("CONNESBEN"))?"":Cursor_qbe_alloperazbo_lim.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contaben > 0 */
              if (CPLib.gt(_contaben,0)) {
                // * --- Select from beneficope
                m_cServer = m_Ctx.GetServer("beneficope");
                m_cPhName = m_Ctx.GetPhName("beneficope");
                if (Cursor_beneficope!=null)
                  Cursor_beneficope.Close();
                Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_beneficope.Eof())) {
                  /* _fben := 1 */
                  _fben = CPLib.Round(1,0);
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000015E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000015E(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_beneficope.GetString("CODSOG"))?"":Cursor_beneficope.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  Cursor_beneficope.Next();
                }
                m_cConnectivityError = Cursor_beneficope.ErrorMessage();
                Cursor_beneficope.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_alloperazbo_lim->STATOREG='3' */
            if (CPLib.eqr(Cursor_qbe_alloperazbo_lim.GetString("STATOREG"),"3")) {
              /* If _contamen > 0 */
              if (CPLib.gt(_contamen,0)) {
                // * --- Select from meneficope
                m_cServer = m_Ctx.GetServer("meneficope");
                m_cPhName = m_Ctx.GetPhName("meneficope");
                if (Cursor_meneficope!=null)
                  Cursor_meneficope.Close();
                Cursor_meneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_meneficope.Eof())) {
                  /* _fben := 1 */
                  _fben = CPLib.Round(1,0);
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000164")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000164(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_meneficope.GetString("CODSOG"))?"":Cursor_meneficope.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  Cursor_meneficope.Next();
                }
                m_cConnectivityError = Cursor_meneficope.ErrorMessage();
                Cursor_meneficope.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_qbe_alloperazbo_lim.Next();
          }
          m_cConnectivityError = Cursor_qbe_alloperazbo_lim.ErrorMessage();
          Cursor_qbe_alloperazbo_lim.Close();
          // * --- End Select
          /* If _fope=1 */
          if (CPLib.eqr(_fope,1)) {
            /* Exec "Stampa" Page 6:Page_6 */
            Page_6();
          } // End If
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If _conta3=5 or _contacicli=_cicli */
        if (CPLib.eqr(_conta3,5) || CPLib.eqr(_contacicli,_cicli)) {
          /* _conta4 := _conta4 + 1 */
          _conta4 = CPLib.Round(_conta4+1,0);
          /* _id2 := Right('000000'+LRTrim(Str(_conta4,6,0)),6) */
          _id2 = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta4,6,0)),6);
          /* _reportname := LRTrim(gAzienda)+'_stdtec_'+_id2+'.pdf' */
          _reportname = CPLib.LRTrim(gAzienda)+"_stdtec_"+_id2+".pdf";
          /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(_reportname) */
          lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_reportname);
          /* mcFileList.AppendBlank() */
          mcFileList.AppendBlank();
          /* mcFileList.nomefile := LRTrim(_reportname) */
          mcFileList.row.nomefile = CPLib.LRTrim(_reportname);
          /* mcFileList.priorita := _contacicli */
          mcFileList.row.priorita = _contacicli;
          /* mcFileList.SaveRow() */
          mcFileList.SaveRow();
          /* _nomerep := '' */
          _nomerep = "";
          for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcListFile._iterable_()) {
            /* _nomerep := _nomerep + LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile)+";" */
            _nomerep = _nomerep+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile)+";";
          }
          /* _nomerep := Left(_nomerep,Len(LRTrim(_nomerep)) - 1) // Nome Stampa */
          _nomerep = CPLib.Left(_nomerep,CPLib.Len(CPLib.LRTrim(_nomerep))-1);
          /* If pPDF='PDF' */
          if (CPLib.eqr(pPDF,"PDF")) {
            /* bReport := _report.MergingPdf(_nomerep,lReport,true) */
            bReport = _report.MergingPdf(_nomerep,lReport,true);
          } else { // Else
            /* bReport := _report.MergingPdfA(_nomerep,lReport,true) */
            bReport = _report.MergingPdfA(_nomerep,lReport,true);
          } // End If
          /* _report.cleanObj() */
          _report.cleanObj();
          /* mcListFile.Zap() */
          mcListFile.Zap();
          /* _conta3 := 0 */
          _conta3 = CPLib.Round(0,0);
        } // End If
        /* _contacicli := _contacicli + 1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_alloperazbo_min_max!=null)
          Cursor_qbe_alloperazbo_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_alloperazbo_lim!=null)
          Cursor_qbe_alloperazbo_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mlientiope!=null)
          Cursor_mlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mogopebo!=null)
          Cursor_mogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_merzistiope!=null)
          Cursor_merzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_allxperazbo_lim=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xerzistiope=null;
    CPResultSet Cursor_xeneficope=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000017D;
      _h0000017D = new SPBridge.HMCaller();
      _h0000017D.Set("m_cVQRList",m_cVQRList);
      _h0000017D.Set("tbname","xlientiope");
      _h0000017D.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000017D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contacli := qbe_tab_mmc->tot */
        _contacli = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000017F;
      _h0000017F = new SPBridge.HMCaller();
      _h0000017F.Set("m_cVQRList",m_cVQRList);
      _h0000017F.Set("tbname","xogopebo");
      _h0000017F.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000017F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaopr := qbe_tab_mmc->tot */
        _contaopr = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000181;
      _h00000181 = new SPBridge.HMCaller();
      _h00000181.Set("m_cVQRList",m_cVQRList);
      _h00000181.Set("tbname","xerzistiope");
      _h00000181.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000181,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contater := qbe_tab_mmc->tot */
        _contater = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000183;
      _h00000183 = new SPBridge.HMCaller();
      _h00000183.Set("m_cVQRList",m_cVQRList);
      _h00000183.Set("tbname","xeneficope");
      _h00000183.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000183,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaben := qbe_tab_mmc->tot */
        _contaben = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* pPDF := 'PDF' */
      pPDF = "PDF";
      /* nPag := 1 */
      nPag = CPLib.Round(1,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000018B;
      _h0000018B = new SPBridge.HMCaller();
      _h0000018B.Set("m_cVQRList",m_cVQRList);
      _h0000018B.Set("tbname","xperazbo");
      _h0000018B.Set("fldname","PRGIMPOPE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000018B,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _min := qbe_tab_mmc->min */
        _min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* _max := qbe_tab_mmc->max */
        _max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* _tot := qbe_tab_mmc->tot */
        _tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* _mono := iif(_tot > 15000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* While _contacicli<=_cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacicli -1 ) * 1000) + 1 */
          _bottom = CPLib.Round(((_contacicli-1)*1000)+1,0);
          /* _top := _contacicli * 1000 */
          _top = CPLib.Round(_contacicli*1000,0);
        } // End If
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_allxperazbo_lim
          SPBridge.HMCaller _h0000019E;
          _h0000019E = new SPBridge.HMCaller();
          _h0000019E.Set("m_cVQRList",m_cVQRList);
          _h0000019E.Set("c_dadata",w_c_dadata);
          _h0000019E.Set("c_adata",w_c_adata);
          _h0000019E.Set("daCodCli",w_daCodCli);
          _h0000019E.Set("aCodCli",w_aCodCli);
          _h0000019E.Set("daCodDip",w_daCodDip);
          _h0000019E.Set("aCodDip",w_aCodDip);
          _h0000019E.Set("_bottom",_bottom);
          _h0000019E.Set("_top",_top);
          if (Cursor_qbe_allxperazbo_lim!=null)
            Cursor_qbe_allxperazbo_lim.Close();
          Cursor_qbe_allxperazbo_lim = new VQRHolder("qbe_allxperazbo_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000019E,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allxperazbo_lim.Eof())) {
            /* _fint := 0 */
            _fint = CPLib.Round(0,0);
            /* _fter := 0 */
            _fter = CPLib.Round(0,0);
            /* _fben := 0 */
            _fben = CPLib.Round(0,0);
            /* _fope := 0 */
            _fope = CPLib.Round(0,0);
            /* _dataope := qbe_allxperazbo_lim->DATAOPE */
            _dataope = Cursor_qbe_allxperazbo_lim.GetDate("DATAOPE");
            /* gMsgImp := "Sto elaborando l'operazione con codice "+LRTrim(qbe_allxperazbo_lim->NUMPROG) // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con codice "+CPLib.LRTrim(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
            _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
            /* If _dataope < CharToDate('20140101') */
            if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
              /* _tipocli := iif(Empty(LRTrim(qbe_allxperazbo_lim->CONNESOPER)),'2','3') */
              _tipocli = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER")))?"2":"3");
              /* _tipoopr := '4' */
              _tipoopr = "4";
              /* _tipoter := '6' */
              _tipoter = "6";
            } else { // Else
              /* _tipocli := '7' */
              _tipocli = "7";
              /* _tipoopr := '8' */
              _tipoopr = "8";
              /* _tipoter := '9' */
              _tipoter = "9";
            } // End If
            // * --- Delete from tmp_stpoperazioni
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001AE")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            // * --- Delete from tmp_soggettioper
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001AF")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If not(Empty(LRTrim(qbe_allxperazbo_lim->CODINT2))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxperazbo_lim.GetString("CODINT2"))))) {
              // * --- Read from inter2bo
              m_cServer = m_Ctx.GetServer("inter2bo");
              m_cPhName = m_Ctx.GetPhName("inter2bo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_allxperazbo_lim.GetString("CODINT2"));
              if (m_Ctx.IsSharedTemp("inter2bo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codint2 = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec_new_mt returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codint2 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(qbe_allxperazbo_lim->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_allxperazbo_lim.GetString("CODDIPE"))) {
              /* _cabinter := _dipcabinter */
              _cabinter = _dipcabinter;
              /* _citinter := _dipcittainter */
              _citinter = _dipcittainter;
              /* _prvinter := _dipprvinter */
              _prvinter = _dipprvinter;
            } else { // Else
              /* If mcAnaDip.GoToKey(qbe_allxperazbo_lim->CODDIPE) */
              if (mcAnaDip.GoToKey(Cursor_qbe_allxperazbo_lim.GetString("CODDIPE"))) {
                /* _cabinter := mcAnaDip.CAB */
                _cabinter = mcAnaDip.row.CAB;
                /* _citinter := mcAnaDip.DESCCIT */
                _citinter = mcAnaDip.row.DESCCIT;
                /* _prvinter := mcAnaDip.PROVINCIA */
                _prvinter = mcAnaDip.row.PROVINCIA;
              } // End If
            } // End If
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001BA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001BA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If not(Empty(qbe_allxperazbo_lim->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo_lim.GetString("CONNESCLI")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fint := 1 */
              _fint = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allxperazbo_lim->CONNESCLI,iif(qbe_allxperazbo_lim->STATOREG<>'1',qbe_allxperazbo_lim->DATAREG,qbe_allxperazbo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxperazbo_lim.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"):Cursor_qbe_allxperazbo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001C5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001C5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contacli > 0 */
            if (CPLib.gt(_contacli,0)) {
              // * --- Select from xlientiope
              m_cServer = m_Ctx.GetServer("xlientiope");
              m_cPhName = m_Ctx.GetPhName("xlientiope");
              if (Cursor_xlientiope!=null)
                Cursor_xlientiope.Close();
              Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xlientiope.Eof())) {
                /* If xlientiope->CODSOG <> qbe_allxperazbo_lim->CONNESCLI */
                if (CPLib.ne(Cursor_xlientiope.GetString("CODSOG"),Cursor_qbe_allxperazbo_lim.GetString("CONNESCLI"))) {
                  /* mcSoggetti.Zap() */
                  mcSoggetti.Zap();
                  /* _fint := 1 */
                  _fint = CPLib.Round(1,0);
                  /* xProg := arfn_chkspers(xlientiope->CODSOG,iif(qbe_allxperazbo_lim->STATOREG<>'1',qbe_allxperazbo_lim->DATAREG,qbe_allxperazbo_lim->DATARETT)) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xlientiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"):Cursor_qbe_allxperazbo_lim.GetDate("DATARETT")));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Fill memory cursor mcSoggetti on personbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_personbo;
                      Cursor_personbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_personbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    mcSoggetti.GoTop();
                  } else { // Else
                    // * --- Fill memory cursor mcSoggetti on wersonbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_wersonbo;
                      Cursor_wersonbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_wersonbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    mcSoggetti.GoTop();
                  } // End If
                  /* mcSoggetti.GoTop() */
                  mcSoggetti.GoTop();
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001D1(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_xlientiope.Next();
              }
              m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
              Cursor_xlientiope.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(qbe_allxperazbo_lim->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fope := 1 */
              _fope = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allxperazbo_lim->CONNESOPER,iif(qbe_allxperazbo_lim->STATOREG<>'1',qbe_allxperazbo_lim->DATAREG,qbe_allxperazbo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"):Cursor_qbe_allxperazbo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001DC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001DC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contaopr > 0 */
            if (CPLib.gt(_contaopr,0)) {
              // * --- Select from xogopebo
              m_cServer = m_Ctx.GetServer("xogopebo");
              m_cPhName = m_Ctx.GetPhName("xogopebo");
              if (Cursor_xogopebo!=null)
                Cursor_xogopebo.Close();
              Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xogopebo.Eof())) {
                /* If LRTrim(xogopebo->CODSOG) <> LRTrim(qbe_allxperazbo_lim->CONNESOPER) */
                if (CPLib.ne(CPLib.LRTrim(Cursor_xogopebo.GetString("CODSOG")),CPLib.LRTrim(Cursor_qbe_allxperazbo_lim.GetString("CONNESOPER")))) {
                  /* mcSoggetti.Zap() */
                  mcSoggetti.Zap();
                  /* _fope := 1 */
                  _fope = CPLib.Round(1,0);
                  /* xProg := arfn_chkspers(xogopebo->CODSOG,iif(qbe_allxperazbo_lim->STATOREG<>'1',qbe_allxperazbo_lim->DATAREG,qbe_allxperazbo_lim->DATARETT)) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xogopebo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"):Cursor_qbe_allxperazbo_lim.GetDate("DATARETT")));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Fill memory cursor mcSoggetti on personbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_personbo;
                      Cursor_personbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_personbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    mcSoggetti.GoTop();
                  } else { // Else
                    // * --- Fill memory cursor mcSoggetti on wersonbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_wersonbo;
                      Cursor_wersonbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_wersonbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    mcSoggetti.GoTop();
                  } // End If
                  /* mcSoggetti.GoTop() */
                  mcSoggetti.GoTop();
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001E8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001E8(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_xogopebo.Next();
              }
              m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
              Cursor_xogopebo.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(qbe_allxperazbo_lim->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo_lim.GetString("CONNALTRO")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fter := 1 */
              _fter = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allxperazbo_lim->CONNALTRO,iif(qbe_allxperazbo_lim->STATOREG<>'1',qbe_allxperazbo_lim->DATAREG,qbe_allxperazbo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxperazbo_lim.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"):Cursor_qbe_allxperazbo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001F3(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contater > 0 */
            if (CPLib.gt(_contater,0)) {
              // * --- Select from xerzistiope
              m_cServer = m_Ctx.GetServer("xerzistiope");
              m_cPhName = m_Ctx.GetPhName("xerzistiope");
              if (Cursor_xerzistiope!=null)
                Cursor_xerzistiope.Close();
              Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xerzistiope.Eof())) {
                /* If xerzistiope->CODSOG <> qbe_allxperazbo_lim->CONNALTRO */
                if (CPLib.ne(Cursor_xerzistiope.GetString("CODSOG"),Cursor_qbe_allxperazbo_lim.GetString("CONNALTRO"))) {
                  /* mcSoggetti.Zap() */
                  mcSoggetti.Zap();
                  /* _fter := 1 */
                  _fter = CPLib.Round(1,0);
                  /* xProg := arfn_chkspers(xerzistiope->CODSOG,iif(qbe_allxperazbo_lim->STATOREG<>'1',qbe_allxperazbo_lim->DATAREG,qbe_allxperazbo_lim->DATARETT)) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xerzistiope.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxperazbo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxperazbo_lim.GetDate("DATAREG"):Cursor_qbe_allxperazbo_lim.GetDate("DATARETT")));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Fill memory cursor mcSoggetti on personbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_personbo;
                      Cursor_personbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_personbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    mcSoggetti.GoTop();
                  } else { // Else
                    // * --- Fill memory cursor mcSoggetti on wersonbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_wersonbo;
                      Cursor_wersonbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_wersonbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    mcSoggetti.GoTop();
                  } // End If
                  /* mcSoggetti.GoTop() */
                  mcSoggetti.GoTop();
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000001FF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001FF(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_xerzistiope.Next();
              }
              m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
              Cursor_xerzistiope.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(qbe_allxperazbo_lim->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxperazbo_lim.GetString("C_RAG")))) {
              /* _fben := 1 */
              _fben = CPLib.Round(1,0);
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000204")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000204(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_allxperazbo_lim.GetString("CONNESBEN"))?"":Cursor_qbe_allxperazbo_lim.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contaben > 0 */
            if (CPLib.gt(_contaben,0)) {
              // * --- Select from xeneficope
              m_cServer = m_Ctx.GetServer("xeneficope");
              m_cPhName = m_Ctx.GetPhName("xeneficope");
              if (Cursor_xeneficope!=null)
                Cursor_xeneficope.Close();
              Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xeneficope.Eof())) {
                /* _fben := 1 */
                _fben = CPLib.Round(1,0);
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000209")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000209(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxperazbo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_xeneficope.GetString("CODSOG"))?"":Cursor_xeneficope.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                Cursor_xeneficope.Next();
              }
              m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
              Cursor_xeneficope.Close();
              // * --- End Select
            } // End If
            /* Exec "Stampa" Page 6:Page_6 */
            Page_6();
            Cursor_qbe_allxperazbo_lim.Next();
          }
          m_cConnectivityError = Cursor_qbe_allxperazbo_lim.ErrorMessage();
          Cursor_qbe_allxperazbo_lim.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If mcListFile.RecCount() > 0 */
        if (CPLib.gt(mcListFile.RecCount(),0)) {
          /* _conta2 := _conta2 + 1 */
          _conta2 = CPLib.Round(_conta2+1,0);
          /* _id2 := Right('000000'+LRTrim(Str(_conta2,6,0)),6) */
          _id2 = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta2,6,0)),6);
          /* _reportname := LRTrim(gAzienda)+'_stdtec_'+_id2+'.pdf' */
          _reportname = CPLib.LRTrim(gAzienda)+"_stdtec_"+_id2+".pdf";
          /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(_reportname) */
          lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_reportname);
          /* mcFileList.AppendBlank() */
          mcFileList.AppendBlank();
          /* mcFileList.nomefile := LRTrim(_reportname) */
          mcFileList.row.nomefile = CPLib.LRTrim(_reportname);
          /* mcFileList.priorita := _contacicli */
          mcFileList.row.priorita = _contacicli;
          /* mcFileList.SaveRow() */
          mcFileList.SaveRow();
          // Crea le variabili per per il merge
          PDFMergerUtility merger = new PDFMergerUtility();
          OutputStream bout2 = new BufferedOutputStream(new FileOutputStream(lReport));
          for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcListFile._iterable_()) {
            /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile) */
            lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile);
            /* merger.addSource(lReport) */
            merger.addSource(lReport);
          }
          // Scrive il pdf mergiato
          merger.setDestinationStream(bout2);
          merger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
          for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcListFile._iterable_()) {
            /* FileLibMit.DeleteFile('stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile)) */
            FileLibMit.DeleteFile("stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile));
          }
          /* mcListFile.Zap() */
          mcListFile.Zap();
        } // End If
        /* _contacicli := _contacicli + 1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_allxperazbo_lim!=null)
          Cursor_qbe_allxperazbo_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_allfraziobo_lim=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_mlientifrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_mogopefbo=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_merzistifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_meneficfrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000021F;
      _h0000021F = new SPBridge.HMCaller();
      _h0000021F.Set("m_cVQRList",m_cVQRList);
      _h0000021F.Set("tbname","clientifrz");
      _h0000021F.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000021F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contacli := qbe_tab_mmc->tot */
        _contacli = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000221;
      _h00000221 = new SPBridge.HMCaller();
      _h00000221.Set("m_cVQRList",m_cVQRList);
      _h00000221.Set("tbname","sogopefbo");
      _h00000221.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000221,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaopr := qbe_tab_mmc->tot */
        _contaopr = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000223;
      _h00000223 = new SPBridge.HMCaller();
      _h00000223.Set("m_cVQRList",m_cVQRList);
      _h00000223.Set("tbname","terzistifrz");
      _h00000223.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000223,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contater := qbe_tab_mmc->tot */
        _contater = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000225;
      _h00000225 = new SPBridge.HMCaller();
      _h00000225.Set("m_cVQRList",m_cVQRList);
      _h00000225.Set("tbname","beneficfrz");
      _h00000225.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000225,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaben := qbe_tab_mmc->tot */
        _contaben = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000227;
      _h00000227 = new SPBridge.HMCaller();
      _h00000227.Set("m_cVQRList",m_cVQRList);
      _h00000227.Set("tbname","mlientifrz");
      _h00000227.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000227,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contamli := qbe_tab_mmc->tot */
        _contamli = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000229;
      _h00000229 = new SPBridge.HMCaller();
      _h00000229.Set("m_cVQRList",m_cVQRList);
      _h00000229.Set("tbname","mogopefbo");
      _h00000229.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000229,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contampr := qbe_tab_mmc->tot */
        _contampr = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000022B;
      _h0000022B = new SPBridge.HMCaller();
      _h0000022B.Set("m_cVQRList",m_cVQRList);
      _h0000022B.Set("tbname","merzistifrz");
      _h0000022B.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000022B,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contamer := qbe_tab_mmc->tot */
        _contamer = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000022D;
      _h0000022D = new SPBridge.HMCaller();
      _h0000022D.Set("m_cVQRList",m_cVQRList);
      _h0000022D.Set("tbname","meneficfrz");
      _h0000022D.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000022D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contamen := qbe_tab_mmc->tot */
        _contamen = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* nPag := 1 */
      nPag = CPLib.Round(1,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000234;
      _h00000234 = new SPBridge.HMCaller();
      _h00000234.Set("m_cVQRList",m_cVQRList);
      _h00000234.Set("tbname","fraziobo");
      _h00000234.Set("fldname","PRGIMPFRZ");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000234,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _min := qbe_tab_mmc->min */
        _min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* _max := qbe_tab_mmc->max */
        _max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* _tot := qbe_tab_mmc->tot */
        _tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* _mono := iif(_tot > 1000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,1000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* While _contacicli<=_cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _contacicli=1 */
          if (CPLib.eqr(_contacicli,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 999 */
            _top = CPLib.Round(_min+999,0);
            /* ElseIf _contacicli = _cicli */
          } else if (CPLib.eqr(_contacicli,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 999 */
            _top = CPLib.Round(_bottom+999,0);
          } // End If
        } // End If
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto eseguendo il ciclo '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli)) + " del file operazioni" // Messaggio */
          gMsgProc = gMsgProc+"Sto eseguendo il ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli))+" del file operazioni";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto eseguendo il ciclo '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli)) + " del file operazioni") // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto eseguendo il ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli))+" del file operazioni");
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sto eseguendo il ciclo '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli)) + " del file operazioni" */
        _oldmsg = "Sto eseguendo il ciclo "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli))+" del file operazioni";
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000024F")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000250")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          /* _fope := 0 */
          _fope = CPLib.Round(0,0);
          // * --- Select from qbe_allfraziobo_lim
          SPBridge.HMCaller _h00000253;
          _h00000253 = new SPBridge.HMCaller();
          _h00000253.Set("m_cVQRList",m_cVQRList);
          _h00000253.Set("c_dadata",w_c_dadata);
          _h00000253.Set("c_adata",w_c_adata);
          _h00000253.Set("daCodCli",w_daCodCli);
          _h00000253.Set("aCodCli",w_aCodCli);
          _h00000253.Set("daCodDip",w_daCodDip);
          _h00000253.Set("aCodDip",w_aCodDip);
          _h00000253.Set("_bottom",_bottom);
          _h00000253.Set("_top",_top);
          if (Cursor_qbe_allfraziobo_lim!=null)
            Cursor_qbe_allfraziobo_lim.Close();
          Cursor_qbe_allfraziobo_lim = new VQRHolder("qbe_allfraziobo_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000253,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allfraziobo_lim.Eof())) {
            /* _fint := 0 */
            _fint = CPLib.Round(0,0);
            /* _fter := 0 */
            _fter = CPLib.Round(0,0);
            /* _fben := 0 */
            _fben = CPLib.Round(0,0);
            /* _fope := 1 */
            _fope = CPLib.Round(1,0);
            /* _dataope := qbe_allfraziobo_lim->DATAOPE */
            _dataope = Cursor_qbe_allfraziobo_lim.GetDate("DATAOPE");
            /* gMsgImp := "Sto elaborando l'operazione con codice "+LRTrim(qbe_allfraziobo_lim->NUMPROG) // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con codice "+CPLib.LRTrim(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
            _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
            /* If _dataope < CharToDate('20140101') */
            if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
              /* _tipocli := iif(Empty(LRTrim(qbe_allfraziobo_lim->CONNESOPER)),'2','3') */
              _tipocli = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER")))?"2":"3");
              /* _tipoopr := '4' */
              _tipoopr = "4";
              /* _tipoter := '6' */
              _tipoter = "6";
            } else { // Else
              /* _tipocli := '7' */
              _tipocli = "7";
              /* _tipoopr := '8' */
              _tipoopr = "8";
              /* _tipoter := '9' */
              _tipoter = "9";
            } // End If
            /* If not(Empty(LRTrim(qbe_allfraziobo_lim->CODINT2))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allfraziobo_lim.GetString("CODINT2"))))) {
              // * --- Read from inter2bo
              m_cServer = m_Ctx.GetServer("inter2bo");
              m_cPhName = m_Ctx.GetPhName("inter2bo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_allfraziobo_lim.GetString("CODINT2"));
              if (m_Ctx.IsSharedTemp("inter2bo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codint2 = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec_new_mt returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codint2 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(qbe_allfraziobo_lim->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_allfraziobo_lim.GetString("CODDIPE"))) {
              /* _cabinter := _dipcabinter */
              _cabinter = _dipcabinter;
              /* _citinter := _dipcittainter */
              _citinter = _dipcittainter;
              /* _prvinter := _dipprvinter */
              _prvinter = _dipprvinter;
            } else { // Else
              /* If mcAnaDip.GoToKey(qbe_allfraziobo_lim->CODDIPE) */
              if (mcAnaDip.GoToKey(Cursor_qbe_allfraziobo_lim.GetString("CODDIPE"))) {
                /* _cabinter := mcAnaDip.CAB */
                _cabinter = mcAnaDip.row.CAB;
                /* _citinter := mcAnaDip.DESCCIT */
                _citinter = mcAnaDip.row.DESCCIT;
                /* _prvinter := mcAnaDip.PROVINCIA */
                _prvinter = mcAnaDip.row.PROVINCIA;
              } // End If
            } // End If
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000026D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000026D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If not(Empty(qbe_allfraziobo_lim->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fint := 1 */
              _fint = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allfraziobo_lim->CONNESCLI,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000278")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000278(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contacli > 0 */
              if (CPLib.gt(_contacli,0)) {
                // * --- Select from clientifrz
                m_cServer = m_Ctx.GetServer("clientifrz");
                m_cPhName = m_Ctx.GetPhName("clientifrz");
                if (Cursor_clientifrz!=null)
                  Cursor_clientifrz.Close();
                Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_clientifrz.Eof())) {
                  /* If clientifrz->CODSOG <> qbe_allfraziobo_lim->CONNESCLI */
                  if (CPLib.ne(Cursor_clientifrz.GetString("CODSOG"),Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fint := 1 */
                    _fint = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(clientifrz->CODSOG,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_clientifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000285")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000285(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_clientifrz.Next();
                }
                m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
                Cursor_clientifrz.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG = '3' */
            if (CPLib.eqr(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contamli > 0 */
              if (CPLib.gt(_contamli,0)) {
                // * --- Select from mlientifrz
                m_cServer = m_Ctx.GetServer("mlientifrz");
                m_cPhName = m_Ctx.GetPhName("mlientifrz");
                if (Cursor_mlientifrz!=null)
                  Cursor_mlientifrz.Close();
                Cursor_mlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_mlientifrz.Eof())) {
                  /* If mlientifrz->CODSOG <> qbe_allfraziobo_lim->CONNESCLI */
                  if (CPLib.ne(Cursor_mlientifrz.GetString("CODSOG"),Cursor_qbe_allfraziobo_lim.GetString("CONNESCLI"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fint := 1 */
                    _fint = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(mlientifrz->CODSOG,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_mlientifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_mlientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000292")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000292(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_mlientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_mlientifrz.Next();
                }
                m_cConnectivityError = Cursor_mlientifrz.ErrorMessage();
                Cursor_mlientifrz.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(qbe_allfraziobo_lim->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fope := 1 */
              _fope = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allfraziobo_lim->CONNESOPER,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000029D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000029D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contaopr > 0 */
              if (CPLib.gt(_contaopr,0)) {
                // * --- Select from sogopefbo
                m_cServer = m_Ctx.GetServer("sogopefbo");
                m_cPhName = m_Ctx.GetPhName("sogopefbo");
                if (Cursor_sogopefbo!=null)
                  Cursor_sogopefbo.Close();
                Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_sogopefbo.Eof())) {
                  /* If sogopefbo->CODSOG <> qbe_allfraziobo_lim->CONNESOPER */
                  if (CPLib.ne(Cursor_sogopefbo.GetString("CODSOG"),Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fope := 1 */
                    _fope = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(sogopefbo->CODSOG,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_sogopefbo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002AA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002AA(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_sogopefbo.Next();
                }
                m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
                Cursor_sogopefbo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG = '3' */
            if (CPLib.eqr(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contampr > 0 */
              if (CPLib.gt(_contampr,0)) {
                // * --- Select from mogopefbo
                m_cServer = m_Ctx.GetServer("mogopefbo");
                m_cPhName = m_Ctx.GetPhName("mogopefbo");
                if (Cursor_mogopefbo!=null)
                  Cursor_mogopefbo.Close();
                Cursor_mogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_mogopefbo.Eof())) {
                  /* If mogopefbo->CODSOG <> qbe_allfraziobo_lim->CONNESOPER */
                  if (CPLib.ne(Cursor_mogopefbo.GetString("CODSOG"),Cursor_qbe_allfraziobo_lim.GetString("CONNESOPER"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fope := 1 */
                    _fope = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(mogopefbo->CODSOG,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_mogopefbo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_mogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002B7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002B7(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_mogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_mogopefbo.Next();
                }
                m_cConnectivityError = Cursor_mogopefbo.ErrorMessage();
                Cursor_mogopefbo.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(qbe_allfraziobo_lim->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo_lim.GetString("CONNALTRO")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fter := 1 */
              _fter = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allfraziobo_lim->CONNALTRO,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allfraziobo_lim.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002C2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contater > 0 */
              if (CPLib.gt(_contater,0)) {
                // * --- Select from terzistifrz
                m_cServer = m_Ctx.GetServer("terzistifrz");
                m_cPhName = m_Ctx.GetPhName("terzistifrz");
                if (Cursor_terzistifrz!=null)
                  Cursor_terzistifrz.Close();
                Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_terzistifrz.Eof())) {
                  /* If terzistifrz->CODSOG <> qbe_allfraziobo_lim->CONNALTRO */
                  if (CPLib.ne(Cursor_terzistifrz.GetString("CODSOG"),Cursor_qbe_allfraziobo_lim.GetString("CONNALTRO"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fter := 1 */
                    _fter = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(terzistifrz->CODSOG,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002CF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002CF(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_terzistifrz.Next();
                }
                m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
                Cursor_terzistifrz.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG = '3' */
            if (CPLib.eqr(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contamer > 0 */
              if (CPLib.gt(_contamer,0)) {
                // * --- Select from merzistifrz
                m_cServer = m_Ctx.GetServer("merzistifrz");
                m_cPhName = m_Ctx.GetPhName("merzistifrz");
                if (Cursor_merzistifrz!=null)
                  Cursor_merzistifrz.Close();
                Cursor_merzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_merzistifrz.Eof())) {
                  /* If merzistifrz->CODSOG <> qbe_allfraziobo_lim->CONNALTRO */
                  if (CPLib.ne(Cursor_merzistifrz.GetString("CODSOG"),Cursor_qbe_allfraziobo_lim.GetString("CONNALTRO"))) {
                    /* mcSoggetti.Zap() */
                    mcSoggetti.Zap();
                    /* _fter := 1 */
                    _fter = CPLib.Round(1,0);
                    /* xProg := arfn_chkspers(merzistifrz->CODSOG,iif(qbe_allfraziobo_lim->STATOREG<>'1',qbe_allfraziobo_lim->DATAREG,qbe_allfraziobo_lim->DATARETT)) */
                    xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_merzistifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allfraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allfraziobo_lim.GetDate("DATARETT")));
                    /* If Empty(LRTrim(xProg)) */
                    if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                      // * --- Fill memory cursor mcSoggetti on personbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_merzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_personbo;
                        Cursor_personbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_personbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      mcSoggetti.GoTop();
                    } else { // Else
                      // * --- Fill memory cursor mcSoggetti on wersonbo
                      mcSoggetti.Zap();
                      m_cServer = m_Ctx.GetServer("wersonbo");
                      m_cPhName = m_Ctx.GetPhName("wersonbo");
                      if (Cursor_wersonbo!=null)
                        Cursor_wersonbo.Close();
                      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      {
                        final CPResultSet m_TheCursor = Cursor_wersonbo;
                        Cursor_wersonbo.ActionOnClose(new Runnable() {
                          public void run() {
                            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                              if ( ! (CPLib.IsNull(info))) {
                                info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                              }
                            }
                          }
                          });
                      }
                      while ( ! (Cursor_wersonbo.Eof())) {
                        mcSoggetti.AppendBlank();
                        mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                        mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                        mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                        mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                        mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                        mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                        mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                        mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                        mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                        mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                        mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                        mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                        mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                        mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                        mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                        mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                        mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                        mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                        mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                        mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                        mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                        mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                        mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                        Cursor_wersonbo.Next();
                      }
                      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                      Cursor_wersonbo.Close();
                      mcSoggetti.GoTop();
                    } // End If
                    /* mcSoggetti.GoTop() */
                    mcSoggetti.GoTop();
                    // * --- Insert into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002DC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000002DC(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_merzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_Sql.AbortTransaction();
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                    }
                  } // End If
                  Cursor_merzistifrz.Next();
                }
                m_cConnectivityError = Cursor_merzistifrz.ErrorMessage();
                Cursor_merzistifrz.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(qbe_allfraziobo_lim->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allfraziobo_lim.GetString("C_RAG")))) {
              /* _fben := 1 */
              _fben = CPLib.Round(1,0);
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002E1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_allfraziobo_lim.GetString("CONNESBEN"))?"":Cursor_qbe_allfraziobo_lim.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contaben > 0 */
              if (CPLib.gt(_contaben,0)) {
                // * --- Select from beneficfrz
                m_cServer = m_Ctx.GetServer("beneficfrz");
                m_cPhName = m_Ctx.GetPhName("beneficfrz");
                if (Cursor_beneficfrz!=null)
                  Cursor_beneficfrz.Close();
                Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_beneficfrz.Eof())) {
                  /* _fben := 1 */
                  _fben = CPLib.Round(1,0);
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002E7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002E7(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_beneficfrz.GetString("CODSOG"))?"":Cursor_beneficfrz.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  Cursor_beneficfrz.Next();
                }
                m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
                Cursor_beneficfrz.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If qbe_allfraziobo_lim->STATOREG <> '3' */
            if (CPLib.ne(Cursor_qbe_allfraziobo_lim.GetString("STATOREG"),"3")) {
              /* If _contamen > 0 */
              if (CPLib.gt(_contamen,0)) {
                // * --- Select from meneficfrz
                m_cServer = m_Ctx.GetServer("meneficfrz");
                m_cPhName = m_Ctx.GetPhName("meneficfrz");
                if (Cursor_meneficfrz!=null)
                  Cursor_meneficfrz.Close();
                Cursor_meneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_meneficfrz.Eof())) {
                  /* _fben := 1 */
                  _fben = CPLib.Round(1,0);
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"000002ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000002ED(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allfraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_meneficfrz.GetString("CODSOG"))?"":Cursor_meneficfrz.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                  Cursor_meneficfrz.Next();
                }
                m_cConnectivityError = Cursor_meneficfrz.ErrorMessage();
                Cursor_meneficfrz.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_qbe_allfraziobo_lim.Next();
          }
          m_cConnectivityError = Cursor_qbe_allfraziobo_lim.ErrorMessage();
          Cursor_qbe_allfraziobo_lim.Close();
          // * --- End Select
          /* If _fope=1 */
          if (CPLib.eqr(_fope,1)) {
            /* Exec "Stampa" Page 6:Page_6 */
            Page_6();
          } // End If
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli + 1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* If _conta3=10 or _contacicli=_cicli */
      if (CPLib.eqr(_conta3,10) || CPLib.eqr(_contacicli,_cicli)) {
        /* _conta4 := _conta4 + 1 */
        _conta4 = CPLib.Round(_conta4+1,0);
        /* _id2 := Right('000000'+LRTrim(Str(_conta4,6,0)),6) */
        _id2 = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta4,6,0)),6);
        /* _reportname := LRTrim(gAzienda)+'_stdtec_'+_id2+'.pdf' */
        _reportname = CPLib.LRTrim(gAzienda)+"_stdtec_"+_id2+".pdf";
        /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(_reportname) */
        lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_reportname);
        /* mcFileList.AppendBlank() */
        mcFileList.AppendBlank();
        /* mcFileList.nomefile := LRTrim(_reportname) */
        mcFileList.row.nomefile = CPLib.LRTrim(_reportname);
        /* mcFileList.priorita := _contacicli */
        mcFileList.row.priorita = _contacicli;
        /* mcFileList.SaveRow() */
        mcFileList.SaveRow();
        /* _nomerep := '' */
        _nomerep = "";
        for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcListFile._iterable_()) {
          /* _nomerep := _nomerep + LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile)+";" */
          _nomerep = _nomerep+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile)+";";
        }
        /* _nomerep := Left(_nomerep,Len(LRTrim(_nomerep)) - 1) // Nome Stampa */
        _nomerep = CPLib.Left(_nomerep,CPLib.Len(CPLib.LRTrim(_nomerep))-1);
        /* If pPDF='PDF' */
        if (CPLib.eqr(pPDF,"PDF")) {
          /* bReport := _report.MergingPdf(_nomerep,lReport,true) */
          bReport = _report.MergingPdf(_nomerep,lReport,true);
        } else { // Else
          /* bReport := _report.MergingPdfA(_nomerep,lReport,true) */
          bReport = _report.MergingPdfA(_nomerep,lReport,true);
        } // End If
        /* _report.cleanObj() */
        _report.cleanObj();
        /* mcListFile.Zap() */
        mcListFile.Zap();
        /* _conta3 := 0 */
        _conta3 = CPLib.Round(0,0);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_allfraziobo_lim!=null)
          Cursor_qbe_allfraziobo_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mlientifrz!=null)
          Cursor_mlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mogopefbo!=null)
          Cursor_mogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_merzistifrz!=null)
          Cursor_merzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_meneficfrz!=null)
          Cursor_meneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_allxraziobo_lim=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000306;
      _h00000306 = new SPBridge.HMCaller();
      _h00000306.Set("m_cVQRList",m_cVQRList);
      _h00000306.Set("tbname","xlientifrz");
      _h00000306.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000306,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contacli := qbe_tab_mmc->tot */
        _contacli = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000308;
      _h00000308 = new SPBridge.HMCaller();
      _h00000308.Set("m_cVQRList",m_cVQRList);
      _h00000308.Set("tbname","xogopefbo");
      _h00000308.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000308,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaopr := qbe_tab_mmc->tot */
        _contaopr = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000030A;
      _h0000030A = new SPBridge.HMCaller();
      _h0000030A.Set("m_cVQRList",m_cVQRList);
      _h0000030A.Set("tbname","xerzistifrz");
      _h0000030A.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000030A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contater := qbe_tab_mmc->tot */
        _contater = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000030C;
      _h0000030C = new SPBridge.HMCaller();
      _h0000030C.Set("m_cVQRList",m_cVQRList);
      _h0000030C.Set("tbname","xeneficfrz");
      _h0000030C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000030C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _contaben := qbe_tab_mmc->tot */
        _contaben = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* pPDF := 'PDF' */
      pPDF = "PDF";
      /* nPag := 1 */
      nPag = CPLib.Round(1,0);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000314;
      _h00000314 = new SPBridge.HMCaller();
      _h00000314.Set("m_cVQRList",m_cVQRList);
      _h00000314.Set("tbname","xraziobo");
      _h00000314.Set("fldname","PRGIMPFRZ");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000314,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _min := qbe_tab_mmc->min */
        _min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
        /* _max := qbe_tab_mmc->max */
        _max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
        /* _tot := qbe_tab_mmc->tot */
        _tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* _mono := iif(_tot > 15000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* While _contacicli<=_cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacicli -1 ) * 1000) + 1 */
          _bottom = CPLib.Round(((_contacicli-1)*1000)+1,0);
          /* _top := _contacicli * 1000 */
          _top = CPLib.Round(_contacicli*1000,0);
        } // End If
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_allxraziobo_lim
          SPBridge.HMCaller _h00000327;
          _h00000327 = new SPBridge.HMCaller();
          _h00000327.Set("m_cVQRList",m_cVQRList);
          _h00000327.Set("c_dadata",w_c_dadata);
          _h00000327.Set("c_adata",w_c_adata);
          _h00000327.Set("daCodCli",w_daCodCli);
          _h00000327.Set("aCodCli",w_aCodCli);
          _h00000327.Set("daCodDip",w_daCodDip);
          _h00000327.Set("aCodDip",w_aCodDip);
          _h00000327.Set("_bottom",_bottom);
          _h00000327.Set("_top",_top);
          if (Cursor_qbe_allxraziobo_lim!=null)
            Cursor_qbe_allxraziobo_lim.Close();
          Cursor_qbe_allxraziobo_lim = new VQRHolder("qbe_allxraziobo_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000327,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_allxraziobo_lim.Eof())) {
            /* _fint := 0 */
            _fint = CPLib.Round(0,0);
            /* _fter := 0 */
            _fter = CPLib.Round(0,0);
            /* _fben := 0 */
            _fben = CPLib.Round(0,0);
            /* _fope := 0 */
            _fope = CPLib.Round(0,0);
            /* _dataope := qbe_allxraziobo_lim->DATAOPE */
            _dataope = Cursor_qbe_allxraziobo_lim.GetDate("DATAOPE");
            /* gMsgImp := "Sto elaborando l'operazione con codice "+LRTrim(qbe_allxraziobo_lim->NUMPROG) // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con codice "+CPLib.LRTrim(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
            _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
            /* If _dataope < CharToDate('20140101') */
            if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
              /* _tipocli := iif(Empty(LRTrim(qbe_allxraziobo_lim->CONNESOPER)),'2','3') */
              _tipocli = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER")))?"2":"3");
              /* _tipoopr := '4' */
              _tipoopr = "4";
              /* _tipoter := '6' */
              _tipoter = "6";
            } else { // Else
              /* _tipocli := '7' */
              _tipocli = "7";
              /* _tipoopr := '8' */
              _tipoopr = "8";
              /* _tipoter := '9' */
              _tipoter = "9";
            } // End If
            // * --- Delete from tmp_stpoperazioni
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000337")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            // * --- Delete from tmp_soggettioper
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000338")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If not(Empty(LRTrim(qbe_allxraziobo_lim->CODINT2))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_allxraziobo_lim.GetString("CODINT2"))))) {
              // * --- Read from inter2bo
              m_cServer = m_Ctx.GetServer("inter2bo");
              m_cPhName = m_Ctx.GetPhName("inter2bo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CODINT2"),"C",11,0,m_cServer),m_cServer,Cursor_qbe_allxraziobo_lim.GetString("CODINT2"));
              if (m_Ctx.IsSharedTemp("inter2bo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codint2 = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_stp_stdtec_new_mt returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codint2 = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(qbe_allxraziobo_lim->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_allxraziobo_lim.GetString("CODDIPE"))) {
              /* _cabinter := _dipcabinter */
              _cabinter = _dipcabinter;
              /* _citinter := _dipcittainter */
              _citinter = _dipcittainter;
              /* _prvinter := _dipprvinter */
              _prvinter = _dipprvinter;
            } else { // Else
              /* If mcAnaDip.GoToKey(qbe_allxraziobo_lim->CODDIPE) */
              if (mcAnaDip.GoToKey(Cursor_qbe_allxraziobo_lim.GetString("CODDIPE"))) {
                /* _cabinter := mcAnaDip.CAB */
                _cabinter = mcAnaDip.row.CAB;
                /* _citinter := mcAnaDip.DESCCIT */
                _citinter = mcAnaDip.row.DESCCIT;
                /* _prvinter := mcAnaDip.PROVINCIA */
                _prvinter = mcAnaDip.row.PROVINCIA;
              } // End If
            } // End If
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000343")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000343(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CODANA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_codint2),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("DESC2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("PROV2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("TOTCONT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDate("DATARETT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("CAMBIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("idcauana"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("INFORM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("NOPROT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NATURA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("RTIPO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("RIMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("RFREQ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("RRAGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("TIPO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcabinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipcittainter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dipprvinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If not(Empty(qbe_allxraziobo_lim->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo_lim.GetString("CONNESCLI")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fint := 1 */
              _fint = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allxraziobo_lim->CONNESCLI,iif(qbe_allxraziobo_lim->STATOREG<>'1',qbe_allxraziobo_lim->DATAREG,qbe_allxraziobo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxraziobo_lim.GetString("CONNESCLI"),(CPLib.ne(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allxraziobo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000034E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000034E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contacli > 0 */
            if (CPLib.gt(_contacli,0)) {
              // * --- Select from xlientifrz
              m_cServer = m_Ctx.GetServer("xlientifrz");
              m_cPhName = m_Ctx.GetPhName("xlientifrz");
              if (Cursor_xlientifrz!=null)
                Cursor_xlientifrz.Close();
              Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xlientifrz.Eof())) {
                /* If xlientifrz->CODSOG <> qbe_allxraziobo_lim->CONNESCLI */
                if (CPLib.ne(Cursor_xlientifrz.GetString("CODSOG"),Cursor_qbe_allxraziobo_lim.GetString("CONNESCLI"))) {
                  /* mcSoggetti.Zap() */
                  mcSoggetti.Zap();
                  /* _fint := 1 */
                  _fint = CPLib.Round(1,0);
                  /* xProg := arfn_chkspers(xlientifrz->CODSOG,iif(qbe_allxraziobo_lim->STATOREG<>'1',qbe_allxraziobo_lim->DATAREG,qbe_allxraziobo_lim->DATARETT)) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xlientifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allxraziobo_lim.GetDate("DATARETT")));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Fill memory cursor mcSoggetti on personbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_personbo;
                      Cursor_personbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_personbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    mcSoggetti.GoTop();
                  } else { // Else
                    // * --- Fill memory cursor mcSoggetti on wersonbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_wersonbo;
                      Cursor_wersonbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_wersonbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    mcSoggetti.GoTop();
                  } // End If
                  /* mcSoggetti.GoTop() */
                  mcSoggetti.GoTop();
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000035A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000035A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipocli,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xlientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_xlientifrz.Next();
              }
              m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
              Cursor_xlientifrz.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(qbe_allxraziobo_lim->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fope := 1 */
              _fope = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allxraziobo_lim->CONNESOPER,iif(qbe_allxraziobo_lim->STATOREG<>'1',qbe_allxraziobo_lim->DATAREG,qbe_allxraziobo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER"),(CPLib.ne(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allxraziobo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000365")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000365(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contaopr > 0 */
            if (CPLib.gt(_contaopr,0)) {
              // * --- Select from xogopefbo
              m_cServer = m_Ctx.GetServer("xogopefbo");
              m_cPhName = m_Ctx.GetPhName("xogopefbo");
              if (Cursor_xogopefbo!=null)
                Cursor_xogopefbo.Close();
              Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xogopefbo.Eof())) {
                /* If xogopefbo->CODSOG <> qbe_allxraziobo_lim->CONNESOPER */
                if (CPLib.ne(Cursor_xogopefbo.GetString("CODSOG"),Cursor_qbe_allxraziobo_lim.GetString("CONNESOPER"))) {
                  /* mcSoggetti.Zap() */
                  mcSoggetti.Zap();
                  /* _fope := 1 */
                  _fope = CPLib.Round(1,0);
                  /* xProg := arfn_chkspers(xogopefbo->CODSOG,iif(qbe_allxraziobo_lim->STATOREG<>'1',qbe_allxraziobo_lim->DATAREG,qbe_allxraziobo_lim->DATARETT)) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xogopefbo.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allxraziobo_lim.GetDate("DATARETT")));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Fill memory cursor mcSoggetti on personbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_personbo;
                      Cursor_personbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_personbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    mcSoggetti.GoTop();
                  } else { // Else
                    // * --- Fill memory cursor mcSoggetti on wersonbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_wersonbo;
                      Cursor_wersonbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_wersonbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    mcSoggetti.GoTop();
                  } // End If
                  /* mcSoggetti.GoTop() */
                  mcSoggetti.GoTop();
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000371")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000371(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoopr,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_xogopefbo.Next();
              }
              m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
              Cursor_xogopefbo.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(qbe_allxraziobo_lim->CONNALTRO)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo_lim.GetString("CONNALTRO")))) {
              /* mcSoggetti.Zap() */
              mcSoggetti.Zap();
              /* _fter := 1 */
              _fter = CPLib.Round(1,0);
              /* xProg := arfn_chkspers(qbe_allxraziobo_lim->CONNALTRO,iif(qbe_allxraziobo_lim->STATOREG<>'1',qbe_allxraziobo_lim->DATAREG,qbe_allxraziobo_lim->DATARETT)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxraziobo_lim.GetString("CONNALTRO"),(CPLib.ne(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allxraziobo_lim.GetDate("DATARETT")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Fill memory cursor mcSoggetti on personbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_personbo;
                  Cursor_personbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_personbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                mcSoggetti.GoTop();
              } else { // Else
                // * --- Fill memory cursor mcSoggetti on wersonbo
                mcSoggetti.Zap();
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_wersonbo;
                  Cursor_wersonbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_wersonbo.Eof())) {
                  mcSoggetti.AppendBlank();
                  mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                  mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                  mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                  mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                  mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                  mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                  mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                  mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                  mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                  mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                  mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                  mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                  mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                  mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                  mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                  mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                  mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                  mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                  mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                mcSoggetti.GoTop();
              } // End If
              /* mcSoggetti.GoTop() */
              mcSoggetti.GoTop();
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000037C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000037C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contater > 0 */
            if (CPLib.gt(_contater,0)) {
              // * --- Select from xerzistifrz
              m_cServer = m_Ctx.GetServer("xerzistifrz");
              m_cPhName = m_Ctx.GetPhName("xerzistifrz");
              if (Cursor_xerzistifrz!=null)
                Cursor_xerzistifrz.Close();
              Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xerzistifrz.Eof())) {
                /* If xerzistifrz->CODSOG <> qbe_allxraziobo_lim->CONNALTRO */
                if (CPLib.ne(Cursor_xerzistifrz.GetString("CODSOG"),Cursor_qbe_allxraziobo_lim.GetString("CONNALTRO"))) {
                  /* mcSoggetti.Zap() */
                  mcSoggetti.Zap();
                  /* _fter := 1 */
                  _fter = CPLib.Round(1,0);
                  /* xProg := arfn_chkspers(xerzistifrz->CODSOG,iif(qbe_allxraziobo_lim->STATOREG<>'1',qbe_allxraziobo_lim->DATAREG,qbe_allxraziobo_lim->DATARETT)) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xerzistifrz.GetString("CODSOG"),(CPLib.ne(Cursor_qbe_allxraziobo_lim.GetString("STATOREG"),"1")?Cursor_qbe_allxraziobo_lim.GetDate("DATAREG"):Cursor_qbe_allxraziobo_lim.GetDate("DATARETT")));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Fill memory cursor mcSoggetti on personbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_personbo;
                      Cursor_personbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_personbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
                      Cursor_personbo.Next();
                    }
                    m_cConnectivityError = Cursor_personbo.ErrorMessage();
                    Cursor_personbo.Close();
                    mcSoggetti.GoTop();
                  } else { // Else
                    // * --- Fill memory cursor mcSoggetti on wersonbo
                    mcSoggetti.Zap();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    if (Cursor_wersonbo!=null)
                      Cursor_wersonbo.Close();
                    Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,RAGSOC,PAESE,CODCAB,DESCCIT,PROVINCIA,DOMICILIO,CAP,CODFISC,CODFISC,NASCOMUN,NASSTATO,DATANASC,TIPINTER,SOTGRUP,RAMOGRUP,SETTSINT,TIPODOC,NUMDOCUM,DATARILASC,AUTRILASC,SESSO,ATTIV,TIPINTER,DATAVALI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    {
                      final CPResultSet m_TheCursor = Cursor_wersonbo;
                      Cursor_wersonbo.ActionOnClose(new Runnable() {
                        public void run() {
                          if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                            com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                            if ( ! (CPLib.IsNull(info))) {
                              info.log("Routine arrt_stp_stdtec_new_mt: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                            }
                          }
                        }
                        });
                    }
                    while ( ! (Cursor_wersonbo.Eof())) {
                      mcSoggetti.AppendBlank();
                      mcSoggetti.row.CONNES = Cursor_wersonbo.GetString("CONNES");
                      mcSoggetti.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                      mcSoggetti.row.PAESE = Cursor_wersonbo.GetString("PAESE");
                      mcSoggetti.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
                      mcSoggetti.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                      mcSoggetti.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                      mcSoggetti.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
                      mcSoggetti.row.CAP = Cursor_wersonbo.GetString("CAP");
                      mcSoggetti.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
                      mcSoggetti.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                      mcSoggetti.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
                      mcSoggetti.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
                      mcSoggetti.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
                      mcSoggetti.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
                      mcSoggetti.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
                      mcSoggetti.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
                      mcSoggetti.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
                      mcSoggetti.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
                      mcSoggetti.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
                      mcSoggetti.row.SESSO = Cursor_wersonbo.GetString("SESSO");
                      mcSoggetti.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
                      mcSoggetti.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
                      mcSoggetti.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
                      Cursor_wersonbo.Next();
                    }
                    m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                    Cursor_wersonbo.Close();
                    mcSoggetti.GoTop();
                  } // End If
                  /* mcSoggetti.GoTop() */
                  mcSoggetti.GoTop();
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000388")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000388(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipoter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xerzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAGSOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PAESE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODCAB,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DESCCIT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.PROVINCIA,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DOMICILIO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CAP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.CODFISC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATANASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASCOMUN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NASSTATO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SOTGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.RAMOGRUP,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SETTSINT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPODOC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.NUMDOCUM,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.DATARILASC,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.AUTRILASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.SESSO,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.ATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(mcSoggetti.row.TIPINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                  }
                } // End If
                Cursor_xerzistifrz.Next();
              }
              m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
              Cursor_xerzistifrz.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(qbe_allxraziobo_lim->C_RAG)) */
            if ( ! (CPLib.Empty(Cursor_qbe_allxraziobo_lim.GetString("C_RAG")))) {
              /* _fben := 1 */
              _fben = CPLib.Round(1,0);
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"0000038D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000038D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_qbe_allxraziobo_lim.GetString("CONNESBEN"))?"":Cursor_qbe_allxraziobo_lim.GetString("CONNESBEN")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If _contaben > 0 */
            if (CPLib.gt(_contaben,0)) {
              // * --- Select from xeneficfrz
              m_cServer = m_Ctx.GetServer("xeneficfrz");
              m_cPhName = m_Ctx.GetPhName("xeneficfrz");
              if (Cursor_xeneficfrz!=null)
                Cursor_xeneficfrz.Close();
              Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xeneficfrz.Eof())) {
                /* _fben := 1 */
                _fben = CPLib.Round(1,0);
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_new_mt",299,"00000392")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000392(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_tipinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxraziobo_lim.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_xeneficfrz.GetString("CODSOG"))?"":Cursor_xeneficfrz.GetString("CODSOG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                Cursor_xeneficfrz.Next();
              }
              m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
              Cursor_xeneficfrz.Close();
              // * --- End Select
            } // End If
            /* _conta2 := _conta2 + 1 */
            _conta2 = CPLib.Round(_conta2+1,0);
            /* _id2 := Right('000000'+LRTrim(Str(_conta2,6,0)),6) */
            _id2 = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta2,6,0)),6);
            /* Exec "Stampa" Page 6:Page_6 */
            Page_6();
            Cursor_qbe_allxraziobo_lim.Next();
          }
          m_cConnectivityError = Cursor_qbe_allxraziobo_lim.ErrorMessage();
          Cursor_qbe_allxraziobo_lim.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If mcListFile.RecCount() > 0 */
        if (CPLib.gt(mcListFile.RecCount(),0)) {
          /* _conta2 := _conta2 + 1 */
          _conta2 = CPLib.Round(_conta2+1,0);
          /* _id2 := Right('000000'+LRTrim(Str(_conta2,6,0)),6) */
          _id2 = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta2,6,0)),6);
          /* _reportname := LRTrim(gAzienda)+'_stdtec_'+_id2+'.pdf' */
          _reportname = CPLib.LRTrim(gAzienda)+"_stdtec_"+_id2+".pdf";
          /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(_reportname) */
          lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_reportname);
          /* mcFileList.AppendBlank() */
          mcFileList.AppendBlank();
          /* mcFileList.nomefile := LRTrim(_reportname) */
          mcFileList.row.nomefile = CPLib.LRTrim(_reportname);
          /* mcFileList.priorita := _contacicli */
          mcFileList.row.priorita = _contacicli;
          /* mcFileList.SaveRow() */
          mcFileList.SaveRow();
          // Crea le variabili per per il merge
          PDFMergerUtility merger = new PDFMergerUtility();
          OutputStream bout2 = new BufferedOutputStream(new FileOutputStream(lReport));
          for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcListFile._iterable_()) {
            /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile) */
            lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile);
            /* merger.addSource(lReport) */
            merger.addSource(lReport);
          }
          // Scrive il pdf mergiato
          merger.setDestinationStream(bout2);
          merger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
          for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcListFile._iterable_()) {
            /* FileLibMit.DeleteFile('stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile)) */
            FileLibMit.DeleteFile("stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile));
          }
          /* mcListFile.Zap() */
          mcListFile.Zap();
        } // End If
        /* _contacicli := _contacicli + 1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_allxraziobo_lim!=null)
          Cursor_qbe_allxraziobo_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    /* _report := ReportLibrary.GetReportLibrary() */
    _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
    /* _report.SetParameterChar('outputFormat',pPDF) */
    _report.SetParameterChar("outputFormat",pPDF);
    /* _report.setParameterChar('w_daCodDip',w_daCodDip) */
    _report.setParameterChar("w_daCodDip",w_daCodDip);
    /* _report.setParameterChar('w_aCodDip',w_aCodDip) */
    _report.setParameterChar("w_aCodDip",w_aCodDip);
    /* _report.setParameterChar('w_daCodCli',w_daCodCli) */
    _report.setParameterChar("w_daCodCli",w_daCodCli);
    /* _report.setParameterChar('w_aCodCli',w_aCodCli) */
    _report.setParameterChar("w_aCodCli",w_aCodCli);
    /* _report.setParameterChar('w_c_dadata',w_c_dadata) */
    _report.setParameterChar("w_c_dadata",w_c_dadata);
    /* _report.setParameterChar('w_c_adata',w_c_adata) */
    _report.setParameterChar("w_c_adata",w_c_adata);
    /* _report.setParameterChar('w_dacdatreg',w_dacdatreg) */
    _report.setParameterChar("w_dacdatreg",w_dacdatreg);
    /* _report.setParameterChar('w_acdatreg',w_acdatreg) */
    _report.setParameterChar("w_acdatreg",w_acdatreg);
    /* _report.SetParameterDate('w_DaDatReg',w_DaDatReg) */
    _report.SetParameterDate("w_DaDatReg",w_DaDatReg);
    /* _report.SetParameterDate('w_ADatReg',w_ADatReg) */
    _report.SetParameterDate("w_ADatReg",w_ADatReg);
    /* _report.setParameterChar('DescAzi',gDescAzi) */
    _report.setParameterChar("DescAzi",gDescAzi);
    /* _report.setParameterChar('pTipo',pTipo) */
    _report.setParameterChar("pTipo",pTipo);
    /* _report.setParameterChar('pAUI',pAUI) */
    _report.setParameterChar("pAUI",pAUI);
    /* _report.setParameterChar('w_flgrae',w_flgrae) */
    _report.setParameterChar("w_flgrae",w_flgrae);
    /* _nomerep := '' */
    _nomerep = "";
    /* If _dataope < CharToDate('20140101') */
    if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
      /* _varrep := "arrp_stp_stdtec_mt" */
      _varrep = "arrp_stp_stdtec_mt";
    } else { // Else
      /* _varrep := "arrp_stp_stdtec_new_mt" */
      _varrep = "arrp_stp_stdtec_new_mt";
    } // End If
    /* _conta2 := _conta2 + 1 */
    _conta2 = CPLib.Round(_conta2+1,0);
    /* _conta3 := _conta3 + 1 */
    _conta3 = CPLib.Round(_conta3+1,0);
    /* _id2 := Right('000000'+LRTrim(Str(_conta2,6,0)),6) */
    _id2 = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta2,6,0)),6);
    /* Exec "Esegue la stampa della pagina" Page 7:StampaPag */
    StampaPag();
  }
  void StampaPag() throws Exception {
    /* _report.SetParameterNumeric('nNumPage',nPag) */
    _report.SetParameterNumeric("nNumPage",nPag);
    /* bReport := _report.makeReport(_varrep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_id2+'.pdf','A4','PORTRAIT',pPDF) */
    bReport = _report.makeReport(_varrep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_id2+".pdf","A4","PORTRAIT",pPDF);
    /* nPag := _report.GetnNumPage()+1 */
    nPag = CPLib.Round(_report.GetnNumPage()+1,0);
    /* _report.cleanObj() */
    _report.cleanObj();
    /* mcListFile.AppendBlank() */
    mcListFile.AppendBlank();
    /* mcListFile.nomefile := 'stampa_stdtec_'+_id2+'.pdf' */
    mcListFile.row.nomefile = "stampa_stdtec_"+_id2+".pdf";
    /* mcListFile.priorita := _conta */
    mcListFile.row.priorita = _conta;
    /* mcListFile.SaveRow() */
    mcListFile.SaveRow();
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daCodCli,String p_w_aCodCli,String p_w_daCodDip,String p_w_aCodDip) {
    return RunAsync(p_pTipo,p_pAUI,p_pPDF,p_w_DaDatOpe,p_w_ADatOpe,p_w_DaDatReg,p_w_ADatReg,p_w_daCodCli,p_w_aCodCli,p_w_daCodDip,p_w_aCodDip,"A");
  }
  public String RunAsync(String p_pTipo,String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daCodCli,String p_w_aCodCli,String p_w_daCodDip,String p_w_aCodDip,String p_w_flgrae) {
    pTipo = p_pTipo;
    pAUI = p_pAUI;
    pPDF = p_pPDF;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_daCodCli = p_w_daCodCli;
    w_aCodCli = p_w_aCodCli;
    w_daCodDip = p_w_daCodDip;
    w_aCodDip = p_w_aCodDip;
    w_flgrae = p_w_flgrae;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=Run();
        } finally {
          //evito di tenere nell'heap della virtual machine riferimenti non piu' usati
          m_Caller = null;
          m_Sql = null;
          m_Ctx = null;
        }
      }
    }
    );
  }
  public Forward Run(String p_pTipo,String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daCodCli,String p_w_aCodCli,String p_w_daCodDip,String p_w_aCodDip) {
    return Run(p_pTipo,p_pAUI,p_pPDF,p_w_DaDatOpe,p_w_ADatOpe,p_w_DaDatReg,p_w_ADatReg,p_w_daCodCli,p_w_aCodCli,p_w_daCodDip,p_w_aCodDip,"A");
  }
  public Forward Run(String p_pTipo,String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daCodCli,String p_w_aCodCli,String p_w_daCodDip,String p_w_aCodDip,String p_w_flgrae) {
    pTipo = p_pTipo;
    pAUI = p_pAUI;
    pPDF = p_pPDF;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_daCodCli = p_w_daCodCli;
    w_aCodCli = p_w_aCodCli;
    w_daCodDip = p_w_daCodDip;
    w_aCodDip = p_w_aCodDip;
    w_flgrae = p_w_flgrae;
    return Run();
  }
  public Forward Run() {
    Forward f;
    f = Forward.Unforwarded;
    m_Ctx = m_Ctx.DisabledDataFilteringVersion();
    try {
      try {
        try {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent("Run start",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
          Page_1();
        } finally {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent(com.zucchetti.sitepainter.EventHandler.RUN_END,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        }
      } catch(Forward forward) {
        f=forward;
      } catch(Stop stop_value) {
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        CPStdCounter.Error(fault);
        CallerExImpl l_oTraceSink;
        l_oTraceSink = new CallerExImpl(m_Caller,"");
        if (l_oTraceSink.HasWorkingVar("m_cFaultTrace")) {
          if ( ! (CPLib.IsAdministrator(m_Ctx)) && m_Ctx.HasAdministeredUsers()) {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,"MSG_ADMIN_REQUIRED");
          } else {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,CPLib.DumpException(fault));
          }
        }
      }
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stp_stdtec_new_mtR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_stdtec_new_mtR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    pAUI = CPLib.Space(1);
    pPDF = CPLib.Space(6);
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_DaDatReg = CPLib.NullDate();
    w_ADatReg = CPLib.NullDate();
    w_daCodCli = CPLib.Space(16);
    w_aCodCli = CPLib.Space(16);
    w_daCodDip = CPLib.Space(6);
    w_aCodDip = CPLib.Space(6);
    w_flgrae = CPLib.Space(1);
    _nomerep = "";
    _report = null;
    bReport = false;
    _id = CPLib.Space(6);
    _id2 = CPLib.Space(6);
    _conta4 = 0;
    _conta3 = 0;
    _conta2 = 0;
    _conta = 0;
    _numsto = CPLib.Space(15);
    w_c_dadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    w_dacdatreg = CPLib.Space(8);
    w_acdatreg = CPLib.Space(8);
    xProg = CPLib.Space(15);
    lReport = "";
    _fint = 0;
    _fope = 0;
    _fter = 0;
    _fben = 0;
    _tipinter = CPLib.Space(2);
    _codinter = CPLib.Space(11);
    _dipcabinter = CPLib.Space(6);
    _dipcittainter = CPLib.Space(30);
    _dipprvinter = CPLib.Space(2);
    _dipcab = CPLib.Space(6);
    _dipcitta = CPLib.Space(30);
    _dipprv = CPLib.Space(2);
    _codint2 = CPLib.Space(11);
    mcAnaDip = new MemoryCursor_anadip();
    mcSoggetti = new MemoryCursor_mcsoggetti_mcrdef();
    mcListFile = new MemoryCursor_mclistafile_mcrdef();
    mcFileList = new MemoryCursor_mclistafile_mcrdef();
    mcFileGroup = new MemoryCursor_mclistafile_mcrdef();
    rowListFile = new MemoryCursorRow_mclistafile_mcrdef();
    _contacli = 0;
    _contater = 0;
    _contaben = 0;
    _contaopr = 0;
    _contamli = 0;
    _contamer = 0;
    _contamen = 0;
    _contampr = 0;
    _cabinter = CPLib.Space(6);
    _citinter = CPLib.Space(30);
    _prvinter = CPLib.Space(2);
    nReport = CPLib.Space(100);
    _reportold = CPLib.Space(100);
    _reportname = CPLib.Space(100);
    _nrep = 0;
    filepdf = CPLib.Space(128);
    _dataope = CPLib.NullDate();
    _tipocli = CPLib.Space(1);
    _tipoese = CPLib.Space(1);
    _tipoter = CPLib.Space(1);
    _tipoopr = CPLib.Space(1);
    _min = 0;
    _max = 0;
    _tot = 0;
    _contacicli = 0;
    _top = 0;
    _bottom = 0;
    _mono = 0;
    _cicli = 0;
    _lista = 0;
    nPag = 0;
    _varrep = CPLib.Space(30);
    _oldmsg = "";
    lReport1 = "";
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_alloperazbo_min_max,qbe_alloperazbo_lim,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_allxperazbo_lim,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_allfraziobo_lim,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_allxraziobo_lim,
  public static final String m_cVQRList = ",qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_alloperazbo_min_max,qbe_alloperazbo_lim,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_allxperazbo_lim,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_allfraziobo_lim,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_allxraziobo_lim,";
  // ENTITY_BATCHES: ,arfn_chkspers,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_chkspers,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pTipo","pAUI","pPDF","w_DaDatOpe","w_ADatOpe","w_DaDatReg","w_ADatReg","w_daCodCli","w_aCodCli","w_daCodDip","w_aCodDip","w_flgrae"};
  protected static String GetFieldsName_000000E4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000109(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000114(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000121(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000139(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000146(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000153(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000158(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000164(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001BA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000204(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000209(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000278(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000285(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000292(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000029D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002CF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002DC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002E7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000343(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DIPCAB,";
    p_cSql = p_cSql+"DIPCIT,";
    p_cSql = p_cSql+"DIPPRV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000034E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000035A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000365(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000371(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000037C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000388(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"PROVANAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000038D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000392(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
}
