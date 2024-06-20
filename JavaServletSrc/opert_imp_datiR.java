// * --- Area Manuale = BO - Header
// * --- opert_imp_dati
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
// * --- Fine Area Manuale
public class opert_imp_datiR implements CallerWithObjs {
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_frz_contante;
  public String m_cServer_frz_contante;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_ope_contante;
  public String m_cServer_ope_contante;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_scarti_import;
  public String m_cServer_scarti_import;
  public String m_cPhName_scarto_contante;
  public String m_cServer_scarto_contante;
  public String m_cPhName_tbcauint;
  public String m_cServer_tbcauint;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_tmp_erroriimp;
  public String m_cServer_tmp_erroriimp;
  public String m_cPhName_xpe_contante;
  public String m_cServer_xpe_contante;
  public String m_cPhName_xrz_contante;
  public String m_cServer_xrz_contante;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_zperazbo;
  public String m_cServer_zperazbo;
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
  public String w_nomefile;
  public String w_tipodest;
  public String w_tipofile;
  public String w_tipoform;
  public String w_PAGMEZ;
  public String pScheduler;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String cActLog;
  public String gTipInter;
  public String fhand;
  public String filename;
  public String riga;
  public String xIDBASE;
  public String cCliProg;
  public String xSesso;
  public double bModifica;
  public java.sql.Date cData1;
  public java.sql.Date cData2;
  public java.sql.Date cData3;
  public java.sql.Date cData4;
  public java.sql.Date cData5;
  public String cOpePrg;
  public String cCli1;
  public String cCli2;
  public String cCli3;
  public String cValuta;
  public String xRif;
  public String xPrg;
  public String xPaese;
  public String _path;
  public double _rownum;
  public double _errrow;
  public double _conta;
  public String cRitorno;
  public String _tipointer;
  public String _cfinter;
  public String _specie;
  public String _area;
  public String _ateco;
  public String _istat;
  public double _cauint;
  public String _cautmp;
  public String _cauaui;
  public String _finalita;
  public double _caurischio;
  public String _cliente;
  public String _clinew;
  public String _flgcau;
  public MemoryCursor_tbcauint mcTBCAUINT;
  public MemoryCursor_tbvalute mcTBVALUTE;
  public MemoryCursor_qbe_personbo_ope_vqr mcPERSONBO;
  public MemoryCursor_tmp_imp_sog mcSoggetti;
  public MemoryCursor_tmp_imp_oper mcOperazioni;
  public MemoryCursor_tmp_contante mcContante;
  public double _imperr;
  public String xStatoReg;
  public String _numprog;
  public double _totgen;
  public double xIMPPROG;
  public String _logmsg;
  public String cProgSto;
  public double nProgSto;
  public double nProgImp;
  public java.sql.Date _datarett;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opert_imp_datiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_imp_dati",m_Caller);
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_frz_contante = p_ContextObject.GetPhName("frz_contante");
    if (m_cPhName_frz_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_frz_contante = m_cPhName_frz_contante+" "+m_Ctx.GetWritePhName("frz_contante");
    }
    m_cServer_frz_contante = p_ContextObject.GetServer("frz_contante");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_ope_contante = p_ContextObject.GetPhName("ope_contante");
    if (m_cPhName_ope_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ope_contante = m_cPhName_ope_contante+" "+m_Ctx.GetWritePhName("ope_contante");
    }
    m_cServer_ope_contante = p_ContextObject.GetServer("ope_contante");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_scarti_import = p_ContextObject.GetPhName("scarti_import");
    if (m_cPhName_scarti_import.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_scarti_import = m_cPhName_scarti_import+" "+m_Ctx.GetWritePhName("scarti_import");
    }
    m_cServer_scarti_import = p_ContextObject.GetServer("scarti_import");
    m_cPhName_scarto_contante = p_ContextObject.GetPhName("scarto_contante");
    if (m_cPhName_scarto_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_scarto_contante = m_cPhName_scarto_contante+" "+m_Ctx.GetWritePhName("scarto_contante");
    }
    m_cServer_scarto_contante = p_ContextObject.GetServer("scarto_contante");
    m_cPhName_tbcauint = p_ContextObject.GetPhName("tbcauint");
    if (m_cPhName_tbcauint.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauint = m_cPhName_tbcauint+" "+m_Ctx.GetWritePhName("tbcauint");
    }
    m_cServer_tbcauint = p_ContextObject.GetServer("tbcauint");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_erroriimp")) {
      m_cPhName_tmp_erroriimp = p_ContextObject.GetPhName("tmp_erroriimp");
      if (m_cPhName_tmp_erroriimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_erroriimp = m_cPhName_tmp_erroriimp+" "+m_Ctx.GetWritePhName("tmp_erroriimp");
      }
      m_cServer_tmp_erroriimp = p_ContextObject.GetServer("tmp_erroriimp");
    }
    m_cPhName_xpe_contante = p_ContextObject.GetPhName("xpe_contante");
    if (m_cPhName_xpe_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xpe_contante = m_cPhName_xpe_contante+" "+m_Ctx.GetWritePhName("xpe_contante");
    }
    m_cServer_xpe_contante = p_ContextObject.GetServer("xpe_contante");
    m_cPhName_xrz_contante = p_ContextObject.GetPhName("xrz_contante");
    if (m_cPhName_xrz_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xrz_contante = m_cPhName_xrz_contante+" "+m_Ctx.GetWritePhName("xrz_contante");
    }
    m_cServer_xrz_contante = p_ContextObject.GetServer("xrz_contante");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_zperazbo = p_ContextObject.GetPhName("zperazbo");
    if (m_cPhName_zperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_zperazbo = m_cPhName_zperazbo+" "+m_Ctx.GetWritePhName("zperazbo");
    }
    m_cServer_zperazbo = p_ContextObject.GetServer("zperazbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bModifica",p_cVarName)) {
      return bModifica;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      return _rownum;
    }
    if (CPLib.eqr("_errrow",p_cVarName)) {
      return _errrow;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_cauint",p_cVarName)) {
      return _cauint;
    }
    if (CPLib.eqr("_caurischio",p_cVarName)) {
      return _caurischio;
    }
    if (CPLib.eqr("_imperr",p_cVarName)) {
      return _imperr;
    }
    if (CPLib.eqr("_totgen",p_cVarName)) {
      return _totgen;
    }
    if (CPLib.eqr("xIMPPROG",p_cVarName)) {
      return xIMPPROG;
    }
    if (CPLib.eqr("nProgSto",p_cVarName)) {
      return nProgSto;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "opert_imp_dati";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      return w_tipofile;
    }
    if (CPLib.eqr("tipoform",p_cVarName)) {
      return w_tipoform;
    }
    if (CPLib.eqr("PAGMEZ",p_cVarName)) {
      return w_PAGMEZ;
    }
    if (CPLib.eqr("pScheduler",p_cVarName)) {
      return pScheduler;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("xIDBASE",p_cVarName)) {
      return xIDBASE;
    }
    if (CPLib.eqr("cCliProg",p_cVarName)) {
      return cCliProg;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      return xSesso;
    }
    if (CPLib.eqr("cOpePrg",p_cVarName)) {
      return cOpePrg;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      return cCli1;
    }
    if (CPLib.eqr("cCli2",p_cVarName)) {
      return cCli2;
    }
    if (CPLib.eqr("cCli3",p_cVarName)) {
      return cCli3;
    }
    if (CPLib.eqr("cValuta",p_cVarName)) {
      return cValuta;
    }
    if (CPLib.eqr("xRif",p_cVarName)) {
      return xRif;
    }
    if (CPLib.eqr("xPrg",p_cVarName)) {
      return xPrg;
    }
    if (CPLib.eqr("xPaese",p_cVarName)) {
      return xPaese;
    }
    if (CPLib.eqr("_path",p_cVarName)) {
      return _path;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_tipointer",p_cVarName)) {
      return _tipointer;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      return _cfinter;
    }
    if (CPLib.eqr("_specie",p_cVarName)) {
      return _specie;
    }
    if (CPLib.eqr("_area",p_cVarName)) {
      return _area;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      return _ateco;
    }
    if (CPLib.eqr("_istat",p_cVarName)) {
      return _istat;
    }
    if (CPLib.eqr("_cautmp",p_cVarName)) {
      return _cautmp;
    }
    if (CPLib.eqr("_cauaui",p_cVarName)) {
      return _cauaui;
    }
    if (CPLib.eqr("_finalita",p_cVarName)) {
      return _finalita;
    }
    if (CPLib.eqr("_cliente",p_cVarName)) {
      return _cliente;
    }
    if (CPLib.eqr("_clinew",p_cVarName)) {
      return _clinew;
    }
    if (CPLib.eqr("_flgcau",p_cVarName)) {
      return _flgcau;
    }
    if (CPLib.eqr("xStatoReg",p_cVarName)) {
      return xStatoReg;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_logmsg",p_cVarName)) {
      return _logmsg;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cData1",p_cVarName)) {
      return cData1;
    }
    if (CPLib.eqr("cData2",p_cVarName)) {
      return cData2;
    }
    if (CPLib.eqr("cData3",p_cVarName)) {
      return cData3;
    }
    if (CPLib.eqr("cData4",p_cVarName)) {
      return cData4;
    }
    if (CPLib.eqr("cData5",p_cVarName)) {
      return cData5;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      return _datarett;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcTBCAUINT",p_cVarName)) {
      return mcTBCAUINT;
    }
    if (CPLib.eqr("mcTBVALUTE",p_cVarName)) {
      return mcTBVALUTE;
    }
    if (CPLib.eqr("mcPERSONBO",p_cVarName)) {
      return mcPERSONBO;
    }
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      return mcSoggetti;
    }
    if (CPLib.eqr("mcOperazioni",p_cVarName)) {
      return mcOperazioni;
    }
    if (CPLib.eqr("mcContante",p_cVarName)) {
      return mcContante;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("bModifica",p_cVarName)) {
      bModifica = value;
      return;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      _rownum = value;
      return;
    }
    if (CPLib.eqr("_errrow",p_cVarName)) {
      _errrow = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_cauint",p_cVarName)) {
      _cauint = value;
      return;
    }
    if (CPLib.eqr("_caurischio",p_cVarName)) {
      _caurischio = value;
      return;
    }
    if (CPLib.eqr("_imperr",p_cVarName)) {
      _imperr = value;
      return;
    }
    if (CPLib.eqr("_totgen",p_cVarName)) {
      _totgen = value;
      return;
    }
    if (CPLib.eqr("xIMPPROG",p_cVarName)) {
      xIMPPROG = value;
      return;
    }
    if (CPLib.eqr("nProgSto",p_cVarName)) {
      nProgSto = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      w_tipofile = value;
      return;
    }
    if (CPLib.eqr("tipoform",p_cVarName)) {
      w_tipoform = value;
      return;
    }
    if (CPLib.eqr("PAGMEZ",p_cVarName)) {
      w_PAGMEZ = value;
      return;
    }
    if (CPLib.eqr("pScheduler",p_cVarName)) {
      pScheduler = value;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("xIDBASE",p_cVarName)) {
      xIDBASE = value;
      return;
    }
    if (CPLib.eqr("cCliProg",p_cVarName)) {
      cCliProg = value;
      return;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      xSesso = value;
      return;
    }
    if (CPLib.eqr("cOpePrg",p_cVarName)) {
      cOpePrg = value;
      return;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      cCli1 = value;
      return;
    }
    if (CPLib.eqr("cCli2",p_cVarName)) {
      cCli2 = value;
      return;
    }
    if (CPLib.eqr("cCli3",p_cVarName)) {
      cCli3 = value;
      return;
    }
    if (CPLib.eqr("cValuta",p_cVarName)) {
      cValuta = value;
      return;
    }
    if (CPLib.eqr("xRif",p_cVarName)) {
      xRif = value;
      return;
    }
    if (CPLib.eqr("xPrg",p_cVarName)) {
      xPrg = value;
      return;
    }
    if (CPLib.eqr("xPaese",p_cVarName)) {
      xPaese = value;
      return;
    }
    if (CPLib.eqr("_path",p_cVarName)) {
      _path = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_tipointer",p_cVarName)) {
      _tipointer = value;
      return;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      _cfinter = value;
      return;
    }
    if (CPLib.eqr("_specie",p_cVarName)) {
      _specie = value;
      return;
    }
    if (CPLib.eqr("_area",p_cVarName)) {
      _area = value;
      return;
    }
    if (CPLib.eqr("_ateco",p_cVarName)) {
      _ateco = value;
      return;
    }
    if (CPLib.eqr("_istat",p_cVarName)) {
      _istat = value;
      return;
    }
    if (CPLib.eqr("_cautmp",p_cVarName)) {
      _cautmp = value;
      return;
    }
    if (CPLib.eqr("_cauaui",p_cVarName)) {
      _cauaui = value;
      return;
    }
    if (CPLib.eqr("_finalita",p_cVarName)) {
      _finalita = value;
      return;
    }
    if (CPLib.eqr("_cliente",p_cVarName)) {
      _cliente = value;
      return;
    }
    if (CPLib.eqr("_clinew",p_cVarName)) {
      _clinew = value;
      return;
    }
    if (CPLib.eqr("_flgcau",p_cVarName)) {
      _flgcau = value;
      return;
    }
    if (CPLib.eqr("xStatoReg",p_cVarName)) {
      xStatoReg = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_logmsg",p_cVarName)) {
      _logmsg = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("cData1",p_cVarName)) {
      cData1 = value;
      return;
    }
    if (CPLib.eqr("cData2",p_cVarName)) {
      cData2 = value;
      return;
    }
    if (CPLib.eqr("cData3",p_cVarName)) {
      cData3 = value;
      return;
    }
    if (CPLib.eqr("cData4",p_cVarName)) {
      cData4 = value;
      return;
    }
    if (CPLib.eqr("cData5",p_cVarName)) {
      cData5 = value;
      return;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      _datarett = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTBCAUINT",p_cVarName)) {
      mcTBCAUINT = (MemoryCursor_tbcauint)value;
      return;
    }
    if (CPLib.eqr("mcTBVALUTE",p_cVarName)) {
      mcTBVALUTE = (MemoryCursor_tbvalute)value;
      return;
    }
    if (CPLib.eqr("mcPERSONBO",p_cVarName)) {
      mcPERSONBO = (MemoryCursor_qbe_personbo_ope_vqr)value;
      return;
    }
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      mcSoggetti = (MemoryCursor_tmp_imp_sog)value;
      return;
    }
    if (CPLib.eqr("mcOperazioni",p_cVarName)) {
      mcOperazioni = (MemoryCursor_tmp_imp_oper)value;
      return;
    }
    if (CPLib.eqr("mcContante",p_cVarName)) {
      mcContante = (MemoryCursor_tmp_contante)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tbcauint=null;
    CPResultSet Cursor_tbvalute=null;
    CPResultSet Cursor_qbe_personbo_ope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_nomefile Char(100) */
      /* w_tipodest Char(1) */
      /* w_tipofile Char(1) */
      /* w_tipoform Char(1) */
      /* w_PAGMEZ Char(30) */
      /* pScheduler Char(1) */
      /* gMsgImp Char(120) // Messaggio Trasferimento */
      /* gMsgProc Memo // Log */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Documenti */
      /* cActLog Char(1) // Log Applicazione */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* fhand Char(1) */
      /* filename Char(80) */
      /* riga Memo */
      /* xIDBASE Char(10) */
      /* cCliProg Char(6) */
      /* xSesso Char(1) */
      /* bModifica Numeric(1, 0) */
      /* cData1 Date */
      /* cData2 Date */
      /* cData3 Date */
      /* cData4 Date */
      /* cData5 Date */
      /* cOpePrg Char(7) */
      /* cCli1 Char(7) */
      /* cCli2 Char(7) */
      /* cCli3 Char(7) */
      /* cValuta Char(3) */
      /* xRif Char(7) */
      /* xPrg Char(7) */
      /* xPaese Char(3) */
      /* _path Char(128) */
      /* _rownum Numeric(10, 0) */
      /* _errrow Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* cRitorno Char(0) */
      /* _tipointer Char(2) */
      /* _cfinter Char(16) */
      /* _specie Char(4) */
      /* _area Char(5) */
      /* _ateco Char(10) */
      /* _istat Char(6) */
      /* _cauint Numeric(5, 0) */
      /* _cautmp Char(4) */
      /* _cauaui Char(4) */
      /* _finalita Char(50) */
      /* _caurischio Numeric(3, 0) */
      /* _cliente Char(16) */
      /* _clinew Char(16) */
      /* _flgcau Char(1) */
      /* mcTBCAUINT MemoryCursor(tbcauint) */
      /* mcTBVALUTE MemoryCursor(tbvalute) */
      /* mcPERSONBO MemoryCursor(qbe_personbo_ope.vqr) */
      /* mcSoggetti MemoryCursor(tmp_imp_sog) */
      /* mcOperazioni MemoryCursor(tmp_imp_oper) */
      /* mcContante MemoryCursor(tmp_contante) */
      /* _imperr Numeric(10, 0) */
      /* xStatoReg Char(1) */
      /* _numprog Char(13) */
      /* _totgen Numeric(12, 2) */
      /* xIMPPROG Numeric(10, 0) */
      /* _logmsg Memo */
      /* cProgSto Char(15) */
      /* nProgSto Numeric(15, 0) */
      /* _datarett := Date() */
      _datarett = CPLib.Date();
      /* nProgImp Numeric(15, 0) */
      /* _tipointer := '' */
      _tipointer = "";
      /* _cfinter := '' */
      _cfinter = "";
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODICE,CODFISC,TIPOOPER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _tipointer := intermbo->TIPINTER */
        _tipointer = Cursor_intermbo.GetString("TIPINTER");
        /* _cfinter := intermbo->CODFISC */
        _cfinter = Cursor_intermbo.GetString("CODFISC");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Legge path applicazione */
      /* gMsgImp := 'Attendere. Elaborazione in corso ...' // Messaggio Trasferimento */
      gMsgImp = "Attendere. Elaborazione in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := '' */
      gMsgProc = "";
      /* Verifica il tipo di file che si sta importando */
      /* cRitorno := 'OK' */
      cRitorno = "OK";
      // * --- Drop temporary table tmp_erroriimp
      if (m_Ctx.IsSharedTemp("tmp_erroriimp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_erroriimp")) {
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_erroriimp");
      }
      // * --- Create temporary table tmp_erroriimp
      if (m_Ctx.IsSharedTemp("tmp_erroriimp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_erroriimp")) {
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_erroriimp");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_erroriimp");
      if ( ! (m_Ctx.IsSharedTemp("tmp_erroriimp"))) {
        m_cServer = m_Ctx.GetServer("tmp_erroriimp");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_erroriimp",m_cServer,"proto")),m_cPhName,"tmp_erroriimp",m_Ctx);
      }
      m_cPhName_tmp_erroriimp = m_cPhName;
      /* If (w_tipofile='O' or w_tipofile='F') */
      if ((CPLib.eqr(w_tipofile,"O") || CPLib.eqr(w_tipofile,"F"))) {
        // * --- Fill memory cursor mcTBCAUINT on tbcauint
        mcTBCAUINT.Zap();
        m_cServer = m_Ctx.GetServer("tbcauint");
        m_cPhName = m_Ctx.GetPhName("tbcauint");
        if (Cursor_tbcauint!=null)
          Cursor_tbcauint.Close();
        Cursor_tbcauint = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcauint")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tbcauint;
          Cursor_tbcauint.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine opert_imp_dati: query on tbcauint returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbcauint.Eof())) {
          mcTBCAUINT.AppendBlank();
          mcTBCAUINT.row.CICODICE = Cursor_tbcauint.GetDouble("CICODICE");
          mcTBCAUINT.row.CICAUCOD = Cursor_tbcauint.GetString("CICAUCOD");
          mcTBCAUINT.row.CIFINALIT = Cursor_tbcauint.GetString("CIFINALIT");
          mcTBCAUINT.row.CIRISCHIO = Cursor_tbcauint.GetDouble("CIRISCHIO");
          Cursor_tbcauint.Next();
        }
        m_cConnectivityError = Cursor_tbcauint.ErrorMessage();
        Cursor_tbcauint.Close();
        mcTBCAUINT.GoTop();
        // * --- Fill memory cursor mcTBVALUTE on tbvalute
        mcTBVALUTE.Zap();
        m_cServer = m_Ctx.GetServer("tbvalute");
        m_cPhName = m_Ctx.GetPhName("tbvalute");
        if (Cursor_tbvalute!=null)
          Cursor_tbvalute.Close();
        Cursor_tbvalute = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbvalute")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tbvalute;
          Cursor_tbvalute.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine opert_imp_dati: query on tbvalute returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbvalute.Eof())) {
          mcTBVALUTE.AppendBlank();
          mcTBVALUTE.row.CODVAL = Cursor_tbvalute.GetString("CODVAL");
          mcTBVALUTE.row.DESCRI = Cursor_tbvalute.GetString("DESCRI");
          mcTBVALUTE.row.ISO = Cursor_tbvalute.GetString("ISO");
          mcTBVALUTE.row.CAMBIO = Cursor_tbvalute.GetDouble("CAMBIO");
          mcTBVALUTE.row.CAMBDAT = Cursor_tbvalute.GetDouble("CAMBDAT");
          mcTBVALUTE.row.CAMBLIRA = Cursor_tbvalute.GetDouble("CAMBLIRA");
          mcTBVALUTE.row.IDTBLS = Cursor_tbvalute.GetString("IDTBLS");
          Cursor_tbvalute.Next();
        }
        m_cConnectivityError = Cursor_tbvalute.ErrorMessage();
        Cursor_tbvalute.Close();
        mcTBVALUTE.GoTop();
        // * --- Fill memory cursor mcPERSONBO on qbe_personbo_ope
        mcPERSONBO.Zap();
        if (Cursor_qbe_personbo_ope!=null)
          Cursor_qbe_personbo_ope.Close();
        Cursor_qbe_personbo_ope = new VQRHolder("qbe_personbo_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_personbo_ope;
          Cursor_qbe_personbo_ope.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine opert_imp_dati: query on qbe_personbo_ope returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_personbo_ope.Eof())) {
          mcPERSONBO.AppendBlank();
          mcPERSONBO.row.CONNES = Cursor_qbe_personbo_ope.GetString("CONNES");
          mcPERSONBO.row.CODFISC = Cursor_qbe_personbo_ope.GetString("CODFISC");
          mcPERSONBO.row.PARTIVA = Cursor_qbe_personbo_ope.GetString("PARTIVA");
          mcPERSONBO.row.CAUSALE = Cursor_qbe_personbo_ope.GetDouble("CAUSALE");
          Cursor_qbe_personbo_ope.Next();
        }
        m_cConnectivityError = Cursor_qbe_personbo_ope.ErrorMessage();
        Cursor_qbe_personbo_ope.Close();
        mcPERSONBO.GoTop();
      } // End If
      /* gMsgProc := 'Inizio Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Inizio Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := '<b>Inizio Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + "</b><br>" */
        _logmsg = "<b>Inizio Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"</b><br>";
      } // End If
      /* Case w_tipofile = 'P' */
      if (CPLib.eqr(w_tipofile,"P")) {
        /* Exec "Soggetti" Page 2:Page_2 */
        Page_2();
        /* Case w_tipofile = 'O' */
      } else if (CPLib.eqr(w_tipofile,"O")) {
        /* Exec "Operazioni" Page 3:Page_3 */
        Page_3();
        /* Case w_tipofile = 'F' */
      } else if (CPLib.eqr(w_tipofile,"F")) {
        /* Exec "Frazionate" Page 4:Page_4 */
        Page_4();
        /* Case w_tipofile='C' */
      } else if (CPLib.eqr(w_tipofile,"C")) {
        /* Exec "Contante" Page 5:Page_5 */
        Page_5();
      } // End Case
      /* FileLibMit.MoveFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile),LRTrim(gPathDoc)+"/import/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)+"_"+DateToChar(Date())) */
      FileLibMit.MoveFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile),CPLib.LRTrim(gPathDoc)+"/import/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile)+"_"+CPLib.DateToChar(CPLib.Date()));
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* cRitorno := _logmsg */
        cRitorno = _logmsg;
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbcauint!=null)
          Cursor_tbcauint.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbvalute!=null)
          Cursor_tbvalute.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_personbo_ope!=null)
          Cursor_qbe_personbo_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Inizio Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If w_tipoform = 'C' */
      if (CPLib.eqr(w_tipoform,"C")) {
        /* _rownum := -1 */
        _rownum = CPLib.Round(-1,0);
        /* filename := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile) */
        filename = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile);
        FileReader freader=new FileReader(filename);
        CSVReader reader = new CSVReader(freader);
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        double nTry0000006Fstatus;
        nTry0000006Fstatus = m_Sql.GetTransactionStatus();
        String cTry0000006Fmsg;
        cTry0000006Fmsg = m_Sql.TransactionErrorMessage();
        try {
          /* If _rownum >= 0 */
          if (CPLib.ge(_rownum,0)) {
            /* mcSoggetti.AppendBlank() */
            mcSoggetti.AppendBlank();
            /* mcSoggetti.TIPOOPER := nextLine[0] */
            mcSoggetti.row.TIPOOPER = nextLine[0];
            /* mcSoggetti.CODSTUDIO := nextLine[1] */
            mcSoggetti.row.CODSTUDIO = nextLine[1];
            /* mcSoggetti.TIPOIDEN := nextLine[2] */
            mcSoggetti.row.TIPOIDEN = nextLine[2];
            /* mcSoggetti.CONNES := nextLine[3] */
            mcSoggetti.row.CONNES = nextLine[3];
            /* mcSoggetti.DATAIDENT := nextLine[4] */
            mcSoggetti.row.DATAIDENT = nextLine[4];
            /* mcSoggetti.RAGSOC := nextLine[5] */
            mcSoggetti.row.RAGSOC = nextLine[5];
            /* mcSoggetti.PAESE := nextLine[6] */
            mcSoggetti.row.PAESE = nextLine[6];
            /* mcSoggetti.DESCCIT := nextLine[7] */
            mcSoggetti.row.DESCCIT = nextLine[7];
            /* mcSoggetti.PROVINCIA := nextLine[8] */
            mcSoggetti.row.PROVINCIA = nextLine[8];
            /* mcSoggetti.DOMICILIO := nextLine[9] */
            mcSoggetti.row.DOMICILIO = nextLine[9];
            /* mcSoggetti.CAP := nextLine[10] */
            mcSoggetti.row.CAP = nextLine[10];
            /* mcSoggetti.CODFISC := nextLine[11] */
            mcSoggetti.row.CODFISC = nextLine[11];
            /* mcSoggetti.DATANASC := nextLine[12] */
            mcSoggetti.row.DATANASC = nextLine[12];
            /* mcSoggetti.NASCOMUN := nextLine[13] */
            mcSoggetti.row.NASCOMUN = nextLine[13];
            /* mcSoggetti.TIPODOC := nextLine[14] */
            mcSoggetti.row.TIPODOC = nextLine[14];
            /* mcSoggetti.NUMDOCUM := nextLine[15] */
            mcSoggetti.row.NUMDOCUM = nextLine[15];
            /* mcSoggetti.DATARILASC := nextLine[16] */
            mcSoggetti.row.DATARILASC = nextLine[16];
            /* mcSoggetti.AUTRILASC := nextLine[17] */
            mcSoggetti.row.AUTRILASC = nextLine[17];
            /* mcSoggetti.SESSO := nextLine[18] */
            mcSoggetti.row.SESSO = nextLine[18];
            /* mcSoggetti.STATOREG := nextLine[19] */
            mcSoggetti.row.STATOREG = nextLine[19];
            /* mcSoggetti.DATARETT := nextLine[20] */
            mcSoggetti.row.DATARETT = nextLine[20];
            /* mcSoggetti.DATAVALI := nextLine[21] */
            mcSoggetti.row.DATAVALI = nextLine[21];
            /* mcSoggetti.PROVNASC := nextLine[22] */
            mcSoggetti.row.PROVNASC = nextLine[22];
            /* mcSoggetti.RESPINS := nextLine[23] */
            mcSoggetti.row.RESPINS = nextLine[23];
            /* mcSoggetti.CODCLI := nextLine[24] */
            mcSoggetti.row.CODCLI = nextLine[24];
            /* mcSoggetti.SPECIE := nextLine[25] */
            mcSoggetti.row.SPECIE = nextLine[25];
            /* mcSoggetti.COMPORT := nextLine[26] */
            mcSoggetti.row.COMPORT = nextLine[26];
            /* mcSoggetti.ATTIV := nextLine[27] */
            mcSoggetti.row.ATTIV = nextLine[27];
            /* mcSoggetti.AREAGEO := nextLine[28] */
            mcSoggetti.row.AREAGEO = nextLine[28];
            /* mcSoggetti.RNATGIU := Val(nextLine[29]) */
            mcSoggetti.row.RNATGIU = CPLib.Val(nextLine[29]);
            /* mcSoggetti.RCOMP := Val(nextLine[30]) */
            mcSoggetti.row.RCOMP = CPLib.Val(nextLine[30]);
            /* mcSoggetti.RATTIV := Val(nextLine[31]) */
            mcSoggetti.row.RATTIV = CPLib.Val(nextLine[31]);
            /* mcSoggetti.RAREA := Val(nextLine[32]) */
            mcSoggetti.row.RAREA = CPLib.Val(nextLine[32]);
            /* mcSoggetti.RAPSEGNA := nextLine[33] */
            mcSoggetti.row.RAPSEGNA = nextLine[33];
            /* mcSoggetti.PIVA := nextLine[34] */
            mcSoggetti.row.PIVA = nextLine[34];
            /* mcSoggetti.PEP := nextLine[35] */
            mcSoggetti.row.PEP = nextLine[35];
            /* mcSoggetti.TIPSOG := nextLine[36] */
            mcSoggetti.row.TIPSOG = nextLine[36];
            /* mcSoggetti.SaveRow() */
            mcSoggetti.SaveRow();
          } // End If
          /* _rownum := _rownum + 1 */
          _rownum = CPLib.Round(_rownum+1,0);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* gMsgProc := gMsgProc + 'Errore alla Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
          gMsgProc = gMsgProc+"Errore alla Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
          // * --- Insert into tmp_erroriimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000009A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000009A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
          // Accept Error
          m_Sql.AcceptTransactionError();
          m_cLastMsgError = "";
          m_bError = false;
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000006Fstatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000006Fstatus,cTry0000006Fmsg);
          }
        }
        /* gMsgImp := 'Sono stati controllati '+LRTrim(Str(_rownum,10,0))+' Soggetti ...' // Messaggio Trasferimento */
        gMsgImp = "Sono stati controllati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Soggetti ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } else { // Else
        /* fhand := FileLibrary.OpenRead('./appo/'+LRTrim(w_nomefile)) */
        fhand = FileLibrary.OpenRead("./appo/"+CPLib.LRTrim(w_nomefile));
        /* While not(FileLibrary.Eof(fhand)) */
        while ( ! (FileLibrary.Eof(fhand))) {
          /* riga := FileLibrary.ReadLine(fhand) */
          riga = FileLibrary.ReadLine(fhand);
          double nTry000000A1status;
          nTry000000A1status = m_Sql.GetTransactionStatus();
          String cTry000000A1msg;
          cTry000000A1msg = m_Sql.TransactionErrorMessage();
          try {
            /* If _rownum > 0 */
            if (CPLib.gt(_rownum,0)) {
              /* mcSoggetti.AppendBlank() */
              mcSoggetti.AppendBlank();
              /* mcSoggetti.TIPOOPER := Left(riga,2) */
              mcSoggetti.row.TIPOOPER = CPLib.Left(riga,2);
              /* mcSoggetti.CODSTUDIO := Substr(riga,3,11) */
              mcSoggetti.row.CODSTUDIO = CPLib.Substr(riga,3,11);
              /* mcSoggetti.TIPOIDEN := Substr(riga,14,2) */
              mcSoggetti.row.TIPOIDEN = CPLib.Substr(riga,14,2);
              /* mcSoggetti.CONNES := Substr(riga,16,6) */
              mcSoggetti.row.CONNES = CPLib.Substr(riga,16,6);
              /* mcSoggetti.DATAIDENT := Substr(riga,22,8) */
              mcSoggetti.row.DATAIDENT = CPLib.Substr(riga,22,8);
              /* mcSoggetti.RAGSOC := Substr(riga,30,70) */
              mcSoggetti.row.RAGSOC = CPLib.Substr(riga,30,70);
              /* mcSoggetti.PAESE := Substr(riga,100,30) */
              mcSoggetti.row.PAESE = CPLib.Substr(riga,100,30);
              /* mcSoggetti.DESCCIT := Substr(riga,130,30) */
              mcSoggetti.row.DESCCIT = CPLib.Substr(riga,130,30);
              /* mcSoggetti.PROVINCIA := Substr(riga,160,15) */
              mcSoggetti.row.PROVINCIA = CPLib.Substr(riga,160,15);
              /* mcSoggetti.DOMICILIO := Substr(riga,175,35) */
              mcSoggetti.row.DOMICILIO = CPLib.Substr(riga,175,35);
              /* mcSoggetti.CAP := Substr(riga,210,5) */
              mcSoggetti.row.CAP = CPLib.Substr(riga,210,5);
              /* mcSoggetti.CODFISC := Substr(riga,215,16) */
              mcSoggetti.row.CODFISC = CPLib.Substr(riga,215,16);
              /* mcSoggetti.DATANASC := Substr(riga,231,8) */
              mcSoggetti.row.DATANASC = CPLib.Substr(riga,231,8);
              /* mcSoggetti.NASCOMUN := Substr(riga,239,30) */
              mcSoggetti.row.NASCOMUN = CPLib.Substr(riga,239,30);
              /* mcSoggetti.TIPODOC := Substr(riga,269,2) */
              mcSoggetti.row.TIPODOC = CPLib.Substr(riga,269,2);
              /* mcSoggetti.NUMDOCUM := Substr(riga,271,15) */
              mcSoggetti.row.NUMDOCUM = CPLib.Substr(riga,271,15);
              /* mcSoggetti.DATARILASC := Substr(riga,286,8) */
              mcSoggetti.row.DATARILASC = CPLib.Substr(riga,286,8);
              /* mcSoggetti.AUTRILASC := Substr(riga,295,30) */
              mcSoggetti.row.AUTRILASC = CPLib.Substr(riga,295,30);
              /* mcSoggetti.SESSO := Substr(riga,325,1) */
              mcSoggetti.row.SESSO = CPLib.Substr(riga,325,1);
              /* mcSoggetti.STATOREG := Substr(riga,326,1) */
              mcSoggetti.row.STATOREG = CPLib.Substr(riga,326,1);
              /* mcSoggetti.DATARETT := Substr(riga,327,8) */
              mcSoggetti.row.DATARETT = CPLib.Substr(riga,327,8);
              /* mcSoggetti.DATAVALI := Substr(riga,335,8) */
              mcSoggetti.row.DATAVALI = CPLib.Substr(riga,335,8);
              /* mcSoggetti.PROVNASC := Substr(riga,342,2) */
              mcSoggetti.row.PROVNASC = CPLib.Substr(riga,342,2);
              /* mcSoggetti.RESPINS := Substr(riga,343,30) */
              mcSoggetti.row.RESPINS = CPLib.Substr(riga,343,30);
              /* mcSoggetti.CODCLI := Substr(riga,374,6) */
              mcSoggetti.row.CODCLI = CPLib.Substr(riga,374,6);
              /* mcSoggetti.SPECIE := Substr(riga,380,4) */
              mcSoggetti.row.SPECIE = CPLib.Substr(riga,380,4);
              /* mcSoggetti.COMPORT := Substr(riga,384,5) */
              mcSoggetti.row.COMPORT = CPLib.Substr(riga,384,5);
              /* mcSoggetti.ATTIV := Substr(riga,389,10) */
              mcSoggetti.row.ATTIV = CPLib.Substr(riga,389,10);
              /* mcSoggetti.AREAGEO := Substr(riga,399,5) */
              mcSoggetti.row.AREAGEO = CPLib.Substr(riga,399,5);
              /* mcSoggetti.RNATGIU := Val(Substr(riga,404,3)) */
              mcSoggetti.row.RNATGIU = CPLib.Val(CPLib.Substr(riga,404,3));
              /* mcSoggetti.RCOMP := Val(Substr(riga,407,3)) */
              mcSoggetti.row.RCOMP = CPLib.Val(CPLib.Substr(riga,407,3));
              /* mcSoggetti.RATTIV := Val(Substr(riga,410,3)) */
              mcSoggetti.row.RATTIV = CPLib.Val(CPLib.Substr(riga,410,3));
              /* mcSoggetti.RAREA := Val(Substr(riga,413,3)) */
              mcSoggetti.row.RAREA = CPLib.Val(CPLib.Substr(riga,413,3));
              /* mcSoggetti.RAPSEGNA := Substr(riga,416,1) */
              mcSoggetti.row.RAPSEGNA = CPLib.Substr(riga,416,1);
              /* mcSoggetti.PIVA := Substr(riga,417,11) */
              mcSoggetti.row.PIVA = CPLib.Substr(riga,417,11);
              /* mcSoggetti.PEP := Substr(riga,428,1) */
              mcSoggetti.row.PEP = CPLib.Substr(riga,428,1);
              /* mcSoggetti.TIPSOG := Substr(riga,429,1) */
              mcSoggetti.row.TIPSOG = CPLib.Substr(riga,429,1);
              /* mcSoggetti.SaveRow() */
              mcSoggetti.SaveRow();
            } // End If
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
            gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
            // * --- Insert into tmp_erroriimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_erroriimp");
            m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000000CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000CC(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000A1status,0)) {
              m_Sql.SetTransactionStatus(nTry000000A1status,cTry000000A1msg);
            }
          }
          /* gMsgImp := 'Sono stati controllati '+LRTrim(Str(_rownum,10,0))+' Soggetti ...' // Messaggio Trasferimento */
          gMsgImp = "Sono stati controllati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Soggetti ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End While
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
      } // End If
      /* gMsgProc := gMsgProc + 'Sono stati controllati '+LRTrim(Str(_rownum,10,0))+' Soggetti ...' + NL // Log */
      gMsgProc = gMsgProc+"Sono stati controllati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Soggetti ..."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Termine Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Terminato Controllo Soggetti' // Messaggio Trasferimento */
      gMsgImp = "Terminato Controllo Soggetti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Cicla sul file temporaneo e se tutti i dati sono uguali salta il record */
      /* gMsgProc := gMsgProc + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000D7status;
      nTry000000D7status = m_Sql.GetTransactionStatus();
      String cTry000000D7msg;
      cTry000000D7msg = m_Sql.TransactionErrorMessage();
      try {
        for (MemoryCursorRow_tmp_imp_sog rowSoggetti : mcSoggetti._iterable_()) {
          /* xIDBASE := '' */
          xIDBASE = "";
          /* cCliProg := '' */
          cCliProg = "";
          /* If not(Empty(rowSoggetti.CODFISC)) */
          if ( ! (CPLib.Empty(rowSoggetti.CODFISC))) {
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.CODFISC),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(rowSoggetti.CODFISC));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cCliProg = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cCliProg = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* xSesso := iif(rowSoggetti.SESSO='M','1',iif(rowSoggetti.SESSO='F','2','0')) */
          xSesso = (CPLib.eqr(rowSoggetti.SESSO,"M")?"1":(CPLib.eqr(rowSoggetti.SESSO,"F")?"2":"0"));
          /* cData1 := iif(Empty(rowSoggetti.DATAIDENT),NullDate(),CharToDate(Right(rowSoggetti.DATAIDENT,4)+Substr(rowSoggetti.DATAIDENT,3,2)+Left(rowSoggetti.DATAIDENT,2))) */
          cData1 = (CPLib.Empty(rowSoggetti.DATAIDENT)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowSoggetti.DATAIDENT,4)+CPLib.Substr(rowSoggetti.DATAIDENT,3,2)+CPLib.Left(rowSoggetti.DATAIDENT,2)));
          /* cData2 := iif(Empty(rowSoggetti.DATANASC),NullDate(),CharToDate(Right(rowSoggetti.DATANASC,4)+Substr(rowSoggetti.DATANASC,3,2)+Left(rowSoggetti.DATANASC,2))) */
          cData2 = (CPLib.Empty(rowSoggetti.DATANASC)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowSoggetti.DATANASC,4)+CPLib.Substr(rowSoggetti.DATANASC,3,2)+CPLib.Left(rowSoggetti.DATANASC,2)));
          /* cData3 := iif(Empty(rowSoggetti.DATARETT),NullDate(),CharToDate(Right(rowSoggetti.DATARETT,4)+Substr(rowSoggetti.DATARETT,3,2)+Left(rowSoggetti.DATARETT,2))) */
          cData3 = (CPLib.Empty(rowSoggetti.DATARETT)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowSoggetti.DATARETT,4)+CPLib.Substr(rowSoggetti.DATARETT,3,2)+CPLib.Left(rowSoggetti.DATARETT,2)));
          /* cData4 := iif(Empty(rowSoggetti.DATARILASC),NullDate(),CharToDate(Right(rowSoggetti.DATARILASC,4)+Substr(rowSoggetti.DATARILASC,3,2)+Left(rowSoggetti.DATARILASC,2))) */
          cData4 = (CPLib.Empty(rowSoggetti.DATARILASC)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowSoggetti.DATARILASC,4)+CPLib.Substr(rowSoggetti.DATARILASC,3,2)+CPLib.Left(rowSoggetti.DATARILASC,2)));
          /* cData5 := iif(Empty(rowSoggetti.DATAVALI),NullDate(),CharToDate(Right(rowSoggetti.DATAVALI,4)+Substr(rowSoggetti.DATAVALI,3,2)+Left(rowSoggetti.DATAVALI,2))) */
          cData5 = (CPLib.Empty(rowSoggetti.DATAVALI)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowSoggetti.DATAVALI,4)+CPLib.Substr(rowSoggetti.DATAVALI,3,2)+CPLib.Left(rowSoggetti.DATAVALI,2)));
          /* xPaese := '' */
          xPaese = "";
          /* _specie := iif(Empty(rowSoggetti.SPECIE) and xSesso <> '0','PF',rowSoggetti.SPECIE) */
          _specie = (CPLib.Empty(rowSoggetti.SPECIE) && CPLib.ne(xSesso,"0")?"PF":rowSoggetti.SPECIE);
          /* If Len(LRTrim(rowSoggetti.PAESE)) = 0 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowSoggetti.PAESE)),0)) {
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSoggetti.DESCCIT,"C",60,0,m_cServer),m_cServer,rowSoggetti.DESCCIT);
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PKTBSTATI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xPaese = Read_Cursor.GetString("PKTBSTATI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xPaese = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSoggetti.PAESE,"C",40,0,m_cServer),m_cServer,rowSoggetti.PAESE);
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xPaese = Read_Cursor.GetString("CODSTA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xPaese = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* _area := iif(not(Empty(rowSoggetti.AREAGEO)),rowSoggetti.AREAGEO,iif(xPaese='086',rowSoggetti.PROVINCIA,xPaese)) */
          _area = ( ! (CPLib.Empty(rowSoggetti.AREAGEO))?rowSoggetti.AREAGEO:(CPLib.eqr(xPaese,"086")?rowSoggetti.PROVINCIA:xPaese));
          /* If Empty(LRTrim(cCliProg)) */
          if (CPLib.Empty(CPLib.LRTrim(cCliProg))) {
            /* cCliProg := Utilities.GetAutonumber("PRGCLIENTE\'"+LRTrim(gAzienda)+"'",'',6) */
            cCliProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGCLIENTE\\'"+CPLib.LRTrim(gAzienda)+"'","",6);
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000000EB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000EB(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCliProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.TIPOIDEN),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.RAGSOC),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xPaese,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.DESCCIT),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.PROVINCIA),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.DOMICILIO),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.CODFISC),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.NASCOMUN),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(xSesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVNASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData4,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData5,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(xSesso,"1") || CPLib.eqr(xSesso,"2")?"F":"G"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_specie,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COMPORT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_area),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RNATGIU,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RATTIV,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAPSEGNA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PEP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPSOG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
          } else { // Else
            /* bModifica := 0 */
            bModifica = CPLib.Round(0,0);
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer, m_oParameters),m_cServer,rowSoggetti.CODFISC)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* cCliProg := personbo->CONNES */
              cCliProg = Cursor_personbo.GetString("CONNES");
              /* If LRTrim(personbo->AUTRILASC) <> LRTrim(rowSoggetti.AUTRILASC) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("AUTRILASC")),CPLib.LRTrim(rowSoggetti.AUTRILASC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->CAP) <> LRTrim(rowSoggetti.CAP) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),CPLib.LRTrim(rowSoggetti.CAP))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->CODFISC) <> LRTrim(rowSoggetti.CODFISC) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")),CPLib.LRTrim(rowSoggetti.CODFISC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->DATAIDENT <> CharToDate(rowSoggetti.DATAIDENT) */
              if (CPLib.ne(Cursor_personbo.GetDate("DATAIDENT"),CPLib.CharToDate(rowSoggetti.DATAIDENT))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->DATANASC <> CharToDate(rowSoggetti.DATANASC) */
              if (CPLib.ne(Cursor_personbo.GetDate("DATANASC"),CPLib.CharToDate(rowSoggetti.DATANASC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->DATARILASC <> CharToDate(rowSoggetti.DATARILASC) */
              if (CPLib.ne(Cursor_personbo.GetDate("DATARILASC"),CPLib.CharToDate(rowSoggetti.DATARILASC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->DATAVALI <> CharToDate(rowSoggetti.DATAVALI) */
              if (CPLib.ne(Cursor_personbo.GetDate("DATAVALI"),CPLib.CharToDate(rowSoggetti.DATAVALI))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->DESCCIT) <> LRTrim(rowSoggetti.DESCCIT) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("DESCCIT")),CPLib.LRTrim(rowSoggetti.DESCCIT))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->DOMICILIO) <> LRTrim(rowSoggetti.DOMICILIO) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("DOMICILIO")),CPLib.LRTrim(rowSoggetti.DOMICILIO))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->NASCOMUN) <> LRTrim(rowSoggetti.NASCOMUN) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")),CPLib.LRTrim(rowSoggetti.NASCOMUN))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->NUMDOCUM) <> LRTrim(rowSoggetti.NUMDOCUM) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("NUMDOCUM")),CPLib.LRTrim(rowSoggetti.NUMDOCUM))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->PAESE) <> LRTrim(rowSoggetti.PAESE) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")),CPLib.LRTrim(rowSoggetti.PAESE))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->PROVINCIA) <> LRTrim(rowSoggetti.PROVINCIA) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA")),CPLib.LRTrim(rowSoggetti.PROVINCIA))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->TIPINTER) <> LRTrim(rowSoggetti.PROVNASC) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("TIPINTER")),CPLib.LRTrim(rowSoggetti.PROVNASC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->RAGSOC) <> LRTrim(rowSoggetti.RAGSOC) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC")),CPLib.LRTrim(rowSoggetti.RAGSOC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->SESSO <> xSesso */
              if (CPLib.ne(Cursor_personbo.GetString("SESSO"),xSesso)) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->TIPODOC) <> LRTrim(rowSoggetti.TIPODOC) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("TIPODOC")),CPLib.LRTrim(rowSoggetti.TIPODOC))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If LRTrim(personbo->IDENT) <> LRTrim(rowSoggetti.TIPOIDEN) */
              if (CPLib.ne(CPLib.LRTrim(Cursor_personbo.GetString("IDENT")),CPLib.LRTrim(rowSoggetti.TIPOIDEN))) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->PKTBSPECIE <> _specie */
              if (CPLib.ne(Cursor_personbo.GetString("PKTBSPECIE"),_specie)) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->PARTIVA <> rowSoggetti.PIVA */
              if (CPLib.ne(Cursor_personbo.GetString("PARTIVA"),rowSoggetti.PIVA)) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->PEP <> rowSoggetti.PEP */
              if (CPLib.ne(Cursor_personbo.GetString("PEP"),rowSoggetti.PEP)) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->TIPOSOGGETTO <> rowSoggetti.TIPSOG */
              if (CPLib.ne(Cursor_personbo.GetString("TIPOSOGGETTO"),rowSoggetti.TIPSOG)) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              /* If personbo->RAPSEGNA <> rowSoggetti.RAPSEGNA */
              if (CPLib.ne(Cursor_personbo.GetString("RAPSEGNA"),rowSoggetti.RAPSEGNA)) {
                /* bModifica := 1 */
                bModifica = CPLib.Round(1,0);
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* If bModifica = 1 */
            if (CPLib.eqr(bModifica,1)) {
              /* cProgSto := '' */
              cProgSto = "";
              /* _datarett Date */
              // * --- Select from wersonbo
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              if (Cursor_wersonbo!=null)
                Cursor_wersonbo.Close();
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCliProg,"?",0,0,m_cServer, m_oParameters),m_cServer,cCliProg)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datarett,"?",0,0,m_cServer, m_oParameters),m_cServer,_datarett)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* cProgSto := wersonbo->sanumpro */
                cProgSto = Cursor_wersonbo.GetString("sanumpro");
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
              /* If Empty(LRTrim(cProgSto)) */
              if (CPLib.Empty(CPLib.LRTrim(cProgSto))) {
                /* Calcola il progressivo di registrazione */
                /* nProgSto := nProgSto + 1 */
                nProgSto = CPLib.Round(nProgSto+1,0);
                /* cProgSto := Right('000000000000000'+LRTrim(Str(nProgSto,15,0)),15) */
                cProgSto = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(nProgSto,15,0)),15);
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCliProg,"?",0,0,m_cServer, m_oParameters),m_cServer,cCliProg)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Insert into wersonbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000127")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000127(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datarett,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CAUSALE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODLEGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAIDENT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARAUT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DISATTIVO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("FATTURATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGNOTRIM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FREQUENZA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("IMPORTOMAX"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NUMOPERAZ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAPSEGNA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOGAFFIDATARIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOSOGGETTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ALTROCAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ALTRODOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("BANCABEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CITTADIN2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODORO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CRIME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("CRIMEDATE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAPROF"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAREVPROF"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FATCA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("FLGVALIDO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDENT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASCOMUN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDNASSTATO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("MITIG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("NOTIT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ODB"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("PEPDATE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RESFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TELEF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cCliProg,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
                  m_cSql = m_cSql+")";
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              // * --- Write into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000128")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"IDENT = "+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.TIPOIDEN),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAIDENT = "+CPLib.ToSQL(cData1,"D",8,0)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(rowSoggetti.RAGSOC,"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(xPaese,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.DESCCIT),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(rowSoggetti.PROVINCIA,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.DOMICILIO),"C",35,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(rowSoggetti.CAP,"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.CODFISC),"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(cData2,"D",8,0)+", ";
              m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(rowSoggetti.NASCOMUN),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(rowSoggetti.TIPODOC,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(cData4,"D",8,0)+", ";
              m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(rowSoggetti.AUTRILASC,"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(xSesso,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(cData5,"D",8,0)+", ";
              m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(rowSoggetti.PROVNASC,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL((CPLib.eqr(xSesso,"1") || CPLib.eqr(xSesso,"2")?"F":"G"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(_specie,"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(rowSoggetti.ATTIV,"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(rowSoggetti.COMPORT,"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(CPLib.LRTrim(_area),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(rowSoggetti.RNATGIU,"N",3,0)+", ";
              m_cSql = m_cSql+"RATTIV = "+CPLib.ToSQL(rowSoggetti.RATTIV,"N",3,0)+", ";
              m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(rowSoggetti.RCOMP,"N",3,0)+", ";
              m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(rowSoggetti.RAREA,"N",3,0)+", ";
              m_cSql = m_cSql+"RAPSEGNA = "+CPLib.ToSQL(rowSoggetti.RAPSEGNA,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(rowSoggetti.PIVA,"C",14,0,m_cServer)+", ";
              m_cSql = m_cSql+"PEP = "+CPLib.ToSQL(rowSoggetti.PEP,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"TIPOSOGGETTO = "+CPLib.ToSQL(rowSoggetti.TIPSOG,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cCliProg,"?",0,0,m_cServer),m_cServer,cCliProg)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
          } // End If
          /* _rownum := _rownum + 1 */
          _rownum = CPLib.Round(_rownum+1,0);
          // * --- Insert into tmp_erroriimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000012A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000012A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Inserito record "+rowSoggetti.CODFISC,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Sono stati importati '+LRTrim(Str(_rownum,10,0))+' Soggetti ...' // Messaggio Trasferimento */
          gMsgImp = "Sono stati importati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Soggetti ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        /* gMsgProc := gMsgProc + 'Sono stati importati '+LRTrim(Str(_rownum,10,0))+' Soggetti ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono stati importati "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Soggetti ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Import dei dati concluso con successo" + NL */
        gMsgProc = gMsgProc+"Import dei dati concluso con successo"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        /* gMsgProc := gMsgProc + "Errore nell'import definitivo dei dati: "+ NL + m_cLastMsgError + NL */
        gMsgProc = gMsgProc+"Errore nell'import definitivo dei dati: "+"\n"+m_cLastMsgError+"\n";
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000D7status,0)) {
          m_Sql.SetTransactionStatus(nTry000000D7status,cTry000000D7msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Fine Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Fine Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Terminato Import Soggetti' // Messaggio Trasferimento */
      gMsgImp = "Terminato Import Soggetti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If cActLog='S' */
      if (CPLib.eqr(cActLog,"S")) {
        /* Exec Routine arrt_writelog('IMPORT','Soggetti',LRTrim(w_nomefile),gMsgProc) */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT","Soggetti",CPLib.LRTrim(w_nomefile),gMsgProc);
      } // End If
    } finally {
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Import Operazioni */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgImp := 'Inizio Importazione Operazioni ...' // Messaggio Trasferimento */
      gMsgImp = "Inizio Importazione Operazioni ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* mcContante.Zap() */
      mcContante.Zap();
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Inizio Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg + 'Inizio Controllo File alle ore '+arfn_fdatetime(DateTime()) + "<br>" */
        _logmsg = _logmsg+"Inizio Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* _rownum := -1 */
      _rownum = CPLib.Round(-1,0);
      /* _errrow := 0 */
      _errrow = CPLib.Round(0,0);
      /* If w_tipoform = 'C' */
      if (CPLib.eqr(w_tipoform,"C")) {
        /* filename := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile) */
        filename = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile);
        FileReader freader=new FileReader(filename);
        CSVReader reader = new CSVReader(freader);
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        double nTry00000145status;
        nTry00000145status = m_Sql.GetTransactionStatus();
        String cTry00000145msg;
        cTry00000145msg = m_Sql.TransactionErrorMessage();
        try {
          /* If _rownum >= 0 */
          if (CPLib.ge(_rownum,0)) {
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.TIPOOPER := nextLine[0] */
            mcOperazioni.row.TIPOOPER = nextLine[0];
            /* mcOperazioni.CODSTUDIO := nextLine[1] */
            mcOperazioni.row.CODSTUDIO = nextLine[1];
            /* mcOperazioni.CODDIPE := nextLine[2] */
            mcOperazioni.row.CODDIPE = nextLine[2];
            /* mcOperazioni.NUMPROG := nextLine[3] */
            mcOperazioni.row.NUMPROG = nextLine[3];
            /* mcOperazioni.DATAOPE := nextLine[4] */
            mcOperazioni.row.DATAOPE = nextLine[4];
            /* mcOperazioni.FLAGFRAZ := nextLine[5] */
            mcOperazioni.row.FLAGFRAZ = nextLine[5];
            /* mcOperazioni.CAUOPER := nextLine[6] */
            mcOperazioni.row.CAUOPER = nextLine[6];
            /* mcOperazioni.CONNESCLI := nextLine[7] */
            mcOperazioni.row.CONNESCLI = nextLine[7];
            /* mcOperazioni.CONNESREAL := nextLine[8] */
            mcOperazioni.row.CONNESREAL = nextLine[8];
            /* mcOperazioni.CONNESBEN := nextLine[9] */
            mcOperazioni.row.CONNESBEN = nextLine[9];
            /* mcOperazioni.DATAREG := nextLine[10] */
            mcOperazioni.row.DATAREG = nextLine[10];
            /* mcOperazioni.STATOREG := nextLine[11] */
            mcOperazioni.row.STATOREG = nextLine[11];
            /* mcOperazioni.DATARETT := nextLine[12] */
            mcOperazioni.row.DATARETT = nextLine[12];
            /* mcOperazioni.VALUTA := nextLine[13] */
            mcOperazioni.row.VALUTA = nextLine[13];
            /* mcOperazioni.IMPORTO := Val(nextLine[14]) */
            mcOperazioni.row.IMPORTO = CPLib.Val(nextLine[14]);
            /* mcOperazioni.CONTANTI := Val(nextLine[15]) */
            mcOperazioni.row.CONTANTI = CPLib.Val(nextLine[15]);
            /* mcOperazioni.MEZPAG := nextLine[16] */
            mcOperazioni.row.MEZPAG = nextLine[16];
            /* mcOperazioni.PRESTAZ := nextLine[17] */
            mcOperazioni.row.PRESTAZ = nextLine[17];
            /* mcOperazioni.POSIZ := nextLine[21] */
            mcOperazioni.row.POSIZ = nextLine[21];
            /* mcOperazioni.RAGIO := nextLine[22] */
            mcOperazioni.row.RAGIO = nextLine[22];
            /* mcOperazioni.MODSVOL := nextLine[23] */
            mcOperazioni.row.MODSVOL = nextLine[23];
            /* mcOperazioni.AREAGEO := nextLine[24] */
            mcOperazioni.row.AREAGEO = nextLine[24];
            /* mcOperazioni.AMMONT := nextLine[25] */
            mcOperazioni.row.AMMONT = nextLine[25];
            /* mcOperazioni.DURAT := nextLine[26] */
            mcOperazioni.row.DURAT = nextLine[26];
            /* mcOperazioni.TIPO := nextLine[27] */
            mcOperazioni.row.TIPO = nextLine[27];
            /* mcOperazioni.RRAGIO := Val(nextLine[28]) */
            mcOperazioni.row.RRAGIO = CPLib.Val(nextLine[28]);
            /* mcOperazioni.RCOMP := Val(nextLine[29]) */
            mcOperazioni.row.RCOMP = CPLib.Val(nextLine[29]);
            /* mcOperazioni.RAREA := Val(nextLine[30]) */
            mcOperazioni.row.RAREA = CPLib.Val(nextLine[30]);
            /* mcOperazioni.RIMP := Val(nextLine[31]) */
            mcOperazioni.row.RIMP = CPLib.Val(nextLine[31]);
            /* mcOperazioni.RFREQ := Val(nextLine[32]) */
            mcOperazioni.row.RFREQ = CPLib.Val(nextLine[32]);
            /* mcOperazioni.RTIPO := Val(nextLine[33]) */
            mcOperazioni.row.RTIPO = CPLib.Val(nextLine[33]);
            /* mcOperazioni.IMPPROG := nextLine[34] */
            mcOperazioni.row.IMPPROG = nextLine[34];
            /* mcOperazioni.DESPUNTO := nextLine[35] */
            mcOperazioni.row.DESPUNTO = nextLine[35];
            /* mcContante.SaveRow() */
            mcContante.SaveRow();
          } // End If
          /* _rownum := _rownum + 1 */
          _rownum = CPLib.Round(_rownum+1,0);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
          gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
          /* If pScheduler='S' */
          if (CPLib.eqr(pScheduler,"S")) {
            /* _logmsg := _logmsg + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + "<br>" */
            _logmsg = _logmsg+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"<br>";
          } // End If
          // * --- Insert into tmp_erroriimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000016E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000016E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
          // Accept Error
          m_Sql.AcceptTransactionError();
          m_cLastMsgError = "";
          m_bError = false;
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000145status,0)) {
            m_Sql.SetTransactionStatus(nTry00000145status,cTry00000145msg);
          }
        }
        /* gMsgImp := 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } else { // Else
        /* fhand := FileLibrary.OpenRead('appo/'+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) */
        fhand = FileLibrary.OpenRead("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
        /* While not(FileLibrary.Eof(fhand)) */
        while ( ! (FileLibrary.Eof(fhand))) {
          /* riga := FileLibrary.ReadLine(fhand) */
          riga = FileLibrary.ReadLine(fhand);
          double nTry00000175status;
          nTry00000175status = m_Sql.GetTransactionStatus();
          String cTry00000175msg;
          cTry00000175msg = m_Sql.TransactionErrorMessage();
          try {
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.TIPOOPER := Left(riga,2) */
            mcOperazioni.row.TIPOOPER = CPLib.Left(riga,2);
            /* mcOperazioni.CODSTUDIO := Substr(riga,3,11) */
            mcOperazioni.row.CODSTUDIO = CPLib.Substr(riga,3,11);
            /* mcOperazioni.CODDIPE := Substr(riga,14,6) */
            mcOperazioni.row.CODDIPE = CPLib.Substr(riga,14,6);
            /* mcOperazioni.NUMPROG := Substr(riga,20,11) */
            mcOperazioni.row.NUMPROG = CPLib.Substr(riga,20,11);
            /* mcOperazioni.DATAOPE := Substr(riga,31,8) */
            mcOperazioni.row.DATAOPE = CPLib.Substr(riga,31,8);
            /* mcOperazioni.FLAGFRAZ := Substr(riga,39,1) */
            mcOperazioni.row.FLAGFRAZ = CPLib.Substr(riga,39,1);
            /* mcOperazioni.CAUOPER := Substr(riga,40,4) */
            mcOperazioni.row.CAUOPER = CPLib.Substr(riga,40,4);
            /* mcOperazioni.CONNESCLI := Substr(riga,44,16) */
            mcOperazioni.row.CONNESCLI = CPLib.Substr(riga,44,16);
            /* mcOperazioni.CONNESREAL := Substr(riga,60,16) */
            mcOperazioni.row.CONNESREAL = CPLib.Substr(riga,60,16);
            /* mcOperazioni.CONNESBEN := Substr(riga,76,16) */
            mcOperazioni.row.CONNESBEN = CPLib.Substr(riga,76,16);
            /* mcOperazioni.DATAREG := Substr(riga,92,8) */
            mcOperazioni.row.DATAREG = CPLib.Substr(riga,92,8);
            /* mcOperazioni.STATOREG := Substr(riga,100,1) */
            mcOperazioni.row.STATOREG = CPLib.Substr(riga,100,1);
            /* mcOperazioni.DATARETT := Substr(riga,101,8) */
            mcOperazioni.row.DATARETT = CPLib.Substr(riga,101,8);
            /* mcOperazioni.VALUTA := Substr(riga,109,3) */
            mcOperazioni.row.VALUTA = CPLib.Substr(riga,109,3);
            /* mcOperazioni.IMPORTO := Val(Substr(riga,112,15)) / 100 */
            mcOperazioni.row.IMPORTO = CPLib.Val(CPLib.Substr(riga,112,15))/100;
            /* mcOperazioni.CONTANTI := Val(Substr(riga,127,15)) / 100 */
            mcOperazioni.row.CONTANTI = CPLib.Val(CPLib.Substr(riga,127,15))/100;
            /* mcOperazioni.MEZPAG := Substr(riga,142,30) */
            mcOperazioni.row.MEZPAG = CPLib.Substr(riga,142,30);
            /* mcOperazioni.PRESTAZ := Substr(riga,172,30) */
            mcOperazioni.row.PRESTAZ = CPLib.Substr(riga,172,30);
            /* mcOperazioni.POSIZ := Substr(riga,220,1) */
            mcOperazioni.row.POSIZ = CPLib.Substr(riga,220,1);
            /* mcOperazioni.RAGIO := Substr(riga,221,5) */
            mcOperazioni.row.RAGIO = CPLib.Substr(riga,221,5);
            /* mcOperazioni.MODSVOL := Substr(riga,226,5) */
            mcOperazioni.row.MODSVOL = CPLib.Substr(riga,226,5);
            /* mcOperazioni.AREAGEO := Substr(riga,231,5) */
            mcOperazioni.row.AREAGEO = CPLib.Substr(riga,231,5);
            /* mcOperazioni.AMMONT := Substr(riga,236,5) */
            mcOperazioni.row.AMMONT = CPLib.Substr(riga,236,5);
            /* mcOperazioni.DURAT := Substr(riga,241,5) */
            mcOperazioni.row.DURAT = CPLib.Substr(riga,241,5);
            /* mcOperazioni.TIPO := Substr(riga,246,5) */
            mcOperazioni.row.TIPO = CPLib.Substr(riga,246,5);
            /* mcOperazioni.RRAGIO := Val(Substr(riga,251,3)) */
            mcOperazioni.row.RRAGIO = CPLib.Val(CPLib.Substr(riga,251,3));
            /* mcOperazioni.RCOMP := Val(Substr(riga,254,3)) */
            mcOperazioni.row.RCOMP = CPLib.Val(CPLib.Substr(riga,254,3));
            /* mcOperazioni.RAREA := Val(Substr(riga,257,3)) */
            mcOperazioni.row.RAREA = CPLib.Val(CPLib.Substr(riga,257,3));
            /* mcOperazioni.RIMP := Val(Substr(riga,260,3)) */
            mcOperazioni.row.RIMP = CPLib.Val(CPLib.Substr(riga,260,3));
            /* mcOperazioni.RFREQ := Val(Substr(riga,263,3)) */
            mcOperazioni.row.RFREQ = CPLib.Val(CPLib.Substr(riga,263,3));
            /* mcOperazioni.RTIPO := Val(Substr(riga,266,3)) */
            mcOperazioni.row.RTIPO = CPLib.Val(CPLib.Substr(riga,266,3));
            /* mcOperazioni.IMPPROG := Substr(riga,269,13) */
            mcOperazioni.row.IMPPROG = CPLib.Substr(riga,269,13);
            /* mcOperazioni.DESPUNTO := Substr(riga,282,80) */
            mcOperazioni.row.DESPUNTO = CPLib.Substr(riga,282,80);
            /* mcContante.SaveRow() */
            mcContante.SaveRow();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
            gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
            /* If pScheduler='S' */
            if (CPLib.eqr(pScheduler,"S")) {
              /* _logmsg := _logmsg +  'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + "<br>" */
              _logmsg = _logmsg+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"<br>";
            } // End If
            // * --- Insert into tmp_erroriimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_erroriimp");
            m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000019D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000019D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000175status,0)) {
              m_Sql.SetTransactionStatus(nTry00000175status,cTry00000175msg);
            }
          }
          /* gMsgImp := 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
          gMsgImp = "Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End While
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
      } // End If
      /* gMsgProc := gMsgProc + 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' + NL // Log */
      gMsgProc = gMsgProc+"Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ..."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Termine Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg +  'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' + "<br>" */
        _logmsg = _logmsg+"Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ..."+"<br>";
        /* _logmsg := _logmsg + 'Termine Controllo File alle ore '+arfn_fdatetime(DateTime()) + "<br>" */
        _logmsg = _logmsg+"Termine Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* gMsgImp := 'Terminato Controllo Operazioni' // Messaggio Trasferimento */
      gMsgImp = "Terminato Controllo Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Cicla sul file transitorio e scrive i record */
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      /* _errrow := 0 */
      _errrow = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + "<br>" // Log */
        _logmsg = _logmsg+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000001AFstatus;
      nTry000001AFstatus = m_Sql.GetTransactionStatus();
      String cTry000001AFmsg;
      cTry000001AFmsg = m_Sql.TransactionErrorMessage();
      try {
        /* xRif := '' */
        xRif = "";
        for (MemoryCursorRow_tmp_imp_oper rowOperazioni : mcOperazioni._iterable_()) {
          /* xIDBASE := '' */
          xIDBASE = "";
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xIDBASE = Read_Cursor.GetString("IDBASE");
            xStatoReg = Read_Cursor.GetString("STATOREG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xIDBASE = "";
            xStatoReg = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(xIDBASE) or (At(xStatoReg,'|0|1')=0 and not(Empty(xIDBASE))) */
          if (CPLib.Empty(xIDBASE) || (CPLib.eqr(CPLib.At(xStatoReg,"|0|1"),0) &&  ! (CPLib.Empty(xIDBASE)))) {
            /* xIDBASE := '' */
            xIDBASE = "";
            // * --- Read from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_cSql = "";
            m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
            if (m_Ctx.IsSharedTemp("xperazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xIDBASE = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xIDBASE = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(xIDBASE) */
            if (CPLib.Empty(xIDBASE)) {
              /* xStatoReg := '' */
              xStatoReg = "";
              // * --- Read from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_cSql = "";
              m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
              if (m_Ctx.IsSharedTemp("fraziobo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xIDBASE = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on fraziobo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xIDBASE = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(xIDBASE) or (At(xStatoReg,'|0|1')=0 and not(Empty(xIDBASE))) */
              if (CPLib.Empty(xIDBASE) || (CPLib.eqr(CPLib.At(xStatoReg,"|0|1"),0) &&  ! (CPLib.Empty(xIDBASE)))) {
                /* xIDBASE := '' */
                xIDBASE = "";
                // * --- Read from xraziobo
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_cSql = "";
                m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
                if (m_Ctx.IsSharedTemp("xraziobo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  xIDBASE = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on xraziobo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  xIDBASE = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
          } // End If
          /* If Empty(xIDBASE) */
          if (CPLib.Empty(xIDBASE)) {
            /* If w_tipodest='P' */
            if (CPLib.eqr(w_tipodest,"P")) {
              /* cOpePrg := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(gAzienda)+"'",'',11) */
              cOpePrg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            } else { // Else
              /* cOpePrg := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
              cOpePrg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            } // End If
            /* _cauint := 0 */
            _cauint = CPLib.Round(0,0);
            /* _cauaui := '' */
            _cauaui = "";
            /* _finalita := '' */
            _finalita = "";
            /* _caurischio := 0 */
            _caurischio = CPLib.Round(0,0);
            /* Trasforma le date */
            /* cData1 := iif(Empty(rowOperazioni.DATAOPE),NullDate(),CharToDate(Right(rowOperazioni.DATAOPE,4)+Substr(rowOperazioni.DATAOPE,3,2)+Left(rowOperazioni.DATAOPE,2))) */
            cData1 = (CPLib.Empty(rowOperazioni.DATAOPE)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowOperazioni.DATAOPE,4)+CPLib.Substr(rowOperazioni.DATAOPE,3,2)+CPLib.Left(rowOperazioni.DATAOPE,2)));
            /* cData2 := iif(Empty(rowOperazioni.DATAREG),NullDate(),CharToDate(Right(rowOperazioni.DATAREG,4)+Substr(rowOperazioni.DATAREG,3,2)+Left(rowOperazioni.DATAREG,2))) */
            cData2 = (CPLib.Empty(rowOperazioni.DATAREG)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowOperazioni.DATAREG,4)+CPLib.Substr(rowOperazioni.DATAREG,3,2)+CPLib.Left(rowOperazioni.DATAREG,2)));
            /* cData3 := iif(Empty(rowOperazioni.DATARETT),NullDate(),CharToDate(Right(rowOperazioni.DATARETT,4)+Substr(rowOperazioni.DATARETT,3,2)+Left(rowOperazioni.DATARETT,2))) */
            cData3 = (CPLib.Empty(rowOperazioni.DATARETT)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowOperazioni.DATARETT,4)+CPLib.Substr(rowOperazioni.DATARETT,3,2)+CPLib.Left(rowOperazioni.DATARETT,2)));
            /* Legge la valuta */
            /* cValuta := '' */
            cValuta = "";
            for (MemoryCursorRow_tbvalute rowValuta : mcTBVALUTE._iterable_()) {
              /* If rowValuta.CODVAL=rowOperazioni.VALUTA or rowValuta.ISO=rowOperazioni.VALUTA */
              if (CPLib.eqr(rowValuta.CODVAL,rowOperazioni.VALUTA) || CPLib.eqr(rowValuta.ISO,rowOperazioni.VALUTA)) {
                /* cValuta := rowValuta.CODVAL */
                cValuta = rowValuta.CODVAL;
                // Exit Loop
                if (true) {
                  break;
                }
              } // End If
            }
            /* cCli1 := '' */
            cCli1 = "";
            /* cCli2 := '' */
            cCli2 = "";
            /* cCli3 := '' */
            cCli3 = "";
            /* If not(Empty(LRTrim(rowOperazioni.CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(rowOperazioni.CONNESCLI)))) {
              /* _clinew := '' */
              _clinew = "";
              /* _cliente := LRTrim(rowOperazioni.CONNESCLI) */
              _cliente = CPLib.LRTrim(rowOperazioni.CONNESCLI);
              /* _flgcau := 'S' */
              _flgcau = "S";
              /* _cautmp := rowOperazioni.CAUOPER */
              _cautmp = rowOperazioni.CAUOPER;
              /* Exec "Trova codice cliente" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* cCli1 := _clinew */
              cCli1 = _clinew;
            } // End If
            /* If not(Empty(LRTrim(rowOperazioni.CONNESREAL))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(rowOperazioni.CONNESREAL)))) {
              /* _clinew := '' */
              _clinew = "";
              /* _cliente := LRTrim(rowOperazioni.CONNESREAL) */
              _cliente = CPLib.LRTrim(rowOperazioni.CONNESREAL);
              /* _cautmp := rowOperazioni.CAUOPER */
              _cautmp = rowOperazioni.CAUOPER;
              /* _flgcau := 'N' */
              _flgcau = "N";
              /* Exec "Trova codice cliente" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* cCli2 := _clinew */
              cCli2 = _clinew;
            } // End If
            /* If not(Empty(LRTrim(rowOperazioni.CONNESBEN))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(rowOperazioni.CONNESBEN)))) {
              /* _clinew := '' */
              _clinew = "";
              /* _cliente := LRTrim(rowOperazioni.CONNESBEN) */
              _cliente = CPLib.LRTrim(rowOperazioni.CONNESBEN);
              /* _cautmp := rowOperazioni.CAUOPER */
              _cautmp = rowOperazioni.CAUOPER;
              /* _flgcau := 'N' */
              _flgcau = "N";
              /* Exec "Trova codice cliente" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* cCli3 := _clinew */
              cCli3 = _clinew;
            } // End If
            /* Verifica il tipo di operazione */
            /* If Empty(cCli1) */
            if (CPLib.Empty(cCli1)) {
              /* _imperr := Utilities.GetAutonumber("PRGIMPOPER\'"+LRTrim(gAzienda)+"'",0,10) */
              _imperr = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPER\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
              // * --- Insert into scarti_import from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("scarti_import");
              m_cPhName = m_Ctx.GetPhName("scarti_import");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarti_import",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000001EB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001EB(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_imperr,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPOOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODSTUDIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DATAOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CAUOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESREAL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DATAREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DATARETT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.VALUTA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MEZPAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.POSIZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODABI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNALTRO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Cliente non rilevato","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"scarti_import",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* _errrow := _errrow + 1 */
              _errrow = CPLib.Round(_errrow+1,0);
              /* gMsgImp := 'Sono state scartate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
              gMsgImp = "Sono state scartate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } else { // Else
              /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* If w_tipodest='P' */
              if (CPLib.eqr(w_tipodest,"P")) {
                /* xIDBASE := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(gAzienda)+"'",'',10) */
                xIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into xperazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xperazbo");
                m_cPhName = m_Ctx.GetPhName("xperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000001F1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001F1(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cauaui,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowOperazioni.CODSTUDIO)?CPLib.LRTrim(_cfinter):rowOperazioni.CODSTUDIO),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(rowOperazioni.CONTANTI,0)?"S,":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_PAGMEZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N° Pratica "+CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpePrg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_finalita,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(gTipInter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cValuta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                /* xIDBASE := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
                xIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into operazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000001F3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001F3(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cauaui,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowOperazioni.CODSTUDIO)?CPLib.LRTrim(_cfinter):rowOperazioni.CODSTUDIO),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(rowOperazioni.CONTANTI,0)?"S,":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_PAGMEZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N° Pratica "+CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpePrg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_finalita,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(gTipInter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cValuta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* _rownum := _rownum + 1 */
              _rownum = CPLib.Round(_rownum+1,0);
            } // End If
            /* gMsgImp := 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
            gMsgImp = "Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } else { // Else
            // Transaction Error
            cTry000001AFmsg = CPLib.FormatMsg(m_Ctx,"Import bloccato. Sono state trovate operazioni già presenti con lo stesso codice"+rowOperazioni.NUMPROG+"");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Import bloccato. Sono state trovate operazioni già presenti con lo stesso codice"+rowOperazioni.NUMPROG+""));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Import bloccato. Sono state trovate operazioni già presenti con lo stesso codice"+rowOperazioni.NUMPROG+""));
          } // End If
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Sono state scartate '+LRTrim(Str(_errrow,10,0))+' Operazioni ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono state scartate "+CPLib.LRTrim(CPLib.Str(_errrow,10,0))+" Operazioni ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Import definitivo dei dati concluso con successo" + NL */
        gMsgProc = gMsgProc+"Import definitivo dei dati concluso con successo"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If pScheduler='S' */
        if (CPLib.eqr(pScheduler,"S")) {
          /* _logmsg := _logmsg + 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' + "<br>" // Log */
          _logmsg = _logmsg+"Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ..."+"<br>";
          /* _logmsg := _logmsg + 'Sono state scartate '+LRTrim(Str(_errrow,10,0))+' Operazioni ...' + "<br>" // Log */
          _logmsg = _logmsg+"Sono state scartate "+CPLib.LRTrim(CPLib.Str(_errrow,10,0))+" Operazioni ..."+"<br>";
          /* _logmsg := _logmsg + "Import definitivo dei dati concluso con successo" + "<br>" */
          _logmsg = _logmsg+"Import definitivo dei dati concluso con successo"+"<br>";
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Errore nell'import definitivo dei dati: " + m_cLastMsgError + NL */
        gMsgProc = gMsgProc+"Errore nell'import definitivo dei dati: "+m_cLastMsgError+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If pScheduler='S' */
        if (CPLib.eqr(pScheduler,"S")) {
          /* _logmsg := _logmsg +  "Errore nell'import definitivo dei dati: " + m_cLastMsgError + "<br>" */
          _logmsg = _logmsg+"Errore nell'import definitivo dei dati: "+m_cLastMsgError+"<br>";
        } // End If
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000001AFstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000001AFstatus,cTry000001AFmsg);
        }
      }
      /* gMsgProc := gMsgProc + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Fine Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Fine Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + "<br>" // Log */
        _logmsg = _logmsg+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
        /* _logmsg := _logmsg + 'Fine Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + "<br>" */
        _logmsg = _logmsg+"Fine Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* gMsgImp := 'Terminato Import Operazioni' // Messaggio Trasferimento */
      gMsgImp = "Terminato Import Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If cActLog='S' */
      if (CPLib.eqr(cActLog,"S")) {
        /* Exec Routine arrt_writelog('IMPORT','Prestazioni/O',LRTrim(w_nomefile),gMsgProc) */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT","Prestazioni/O",CPLib.LRTrim(w_nomefile),gMsgProc);
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Import Frazionate */
      /* gMsgImp := 'Inizio Importazione Frazionate ...' // Messaggio Trasferimento */
      gMsgImp = "Inizio Importazione Frazionate ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Inizio Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      /* _errrow := 0 */
      _errrow = CPLib.Round(0,0);
      /* If w_tipoform = 'C' */
      if (CPLib.eqr(w_tipoform,"C")) {
        /* filename := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile) */
        filename = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile);
        FileReader freader=new FileReader(filename);
        CSVReader reader = new CSVReader(freader);
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        double nTry00000215status;
        nTry00000215status = m_Sql.GetTransactionStatus();
        String cTry00000215msg;
        cTry00000215msg = m_Sql.TransactionErrorMessage();
        try {
          /* If _rownum > 0 */
          if (CPLib.gt(_rownum,0)) {
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.TIPOOPER := nextLine[0] */
            mcOperazioni.row.TIPOOPER = nextLine[0];
            /* mcOperazioni.CODSTUDIO := nextLine[1] */
            mcOperazioni.row.CODSTUDIO = nextLine[1];
            /* mcOperazioni.CODDIPE := nextLine[2] */
            mcOperazioni.row.CODDIPE = nextLine[2];
            /* mcOperazioni.NUMPROG := nextLine[3] */
            mcOperazioni.row.NUMPROG = nextLine[3];
            /* mcOperazioni.DATAOPE := nextLine[4] */
            mcOperazioni.row.DATAOPE = nextLine[4];
            /* mcOperazioni.FLAGFRAZ := nextLine[5] */
            mcOperazioni.row.FLAGFRAZ = nextLine[5];
            /* mcOperazioni.CAUOPER := nextLine[6] */
            mcOperazioni.row.CAUOPER = nextLine[6];
            /* mcOperazioni.CONNESCLI := nextLine[7] */
            mcOperazioni.row.CONNESCLI = nextLine[7];
            /* mcOperazioni.CONNESREAL := nextLine[8] */
            mcOperazioni.row.CONNESREAL = nextLine[8];
            /* mcOperazioni.CONNESBEN := nextLine[9] */
            mcOperazioni.row.CONNESBEN = nextLine[9];
            /* mcOperazioni.DATAREG := nextLine[10] */
            mcOperazioni.row.DATAREG = nextLine[10];
            /* mcOperazioni.STATOREG := nextLine[11] */
            mcOperazioni.row.STATOREG = nextLine[11];
            /* mcOperazioni.DATARETT := nextLine[12] */
            mcOperazioni.row.DATARETT = nextLine[12];
            /* mcOperazioni.VALUTA := nextLine[13] */
            mcOperazioni.row.VALUTA = nextLine[13];
            /* mcOperazioni.IMPORTO := Val(nextLine[14]) */
            mcOperazioni.row.IMPORTO = CPLib.Val(nextLine[14]);
            /* mcOperazioni.CONTANTI := Val(nextLine[15]) */
            mcOperazioni.row.CONTANTI = CPLib.Val(nextLine[15]);
            /* mcOperazioni.MEZPAG := nextLine[16] */
            mcOperazioni.row.MEZPAG = nextLine[16];
            /* mcOperazioni.PRESTAZ := nextLine[17] */
            mcOperazioni.row.PRESTAZ = nextLine[17];
            /* mcOperazioni.POSIZ := nextLine[21] */
            mcOperazioni.row.POSIZ = nextLine[21];
            /* mcOperazioni.RAGIO := nextLine[22] */
            mcOperazioni.row.RAGIO = nextLine[22];
            /* mcOperazioni.MODSVOL := nextLine[23] */
            mcOperazioni.row.MODSVOL = nextLine[23];
            /* mcOperazioni.AREAGEO := nextLine[24] */
            mcOperazioni.row.AREAGEO = nextLine[24];
            /* mcOperazioni.AMMONT := nextLine[25] */
            mcOperazioni.row.AMMONT = nextLine[25];
            /* mcOperazioni.DURAT := nextLine[26] */
            mcOperazioni.row.DURAT = nextLine[26];
            /* mcOperazioni.TIPO := nextLine[27] */
            mcOperazioni.row.TIPO = nextLine[27];
            /* mcOperazioni.RRAGIO := Val(nextLine[28]) */
            mcOperazioni.row.RRAGIO = CPLib.Val(nextLine[28]);
            /* mcOperazioni.RCOMP := Val(nextLine[29]) */
            mcOperazioni.row.RCOMP = CPLib.Val(nextLine[29]);
            /* mcOperazioni.RAREA := Val(nextLine[30]) */
            mcOperazioni.row.RAREA = CPLib.Val(nextLine[30]);
            /* mcOperazioni.RIMP := Val(nextLine[31]) */
            mcOperazioni.row.RIMP = CPLib.Val(nextLine[31]);
            /* mcOperazioni.RFREQ := Val(nextLine[32]) */
            mcOperazioni.row.RFREQ = CPLib.Val(nextLine[32]);
            /* mcOperazioni.RTIPO := Val(nextLine[33]) */
            mcOperazioni.row.RTIPO = CPLib.Val(nextLine[33]);
            /* mcOperazioni.IMPPROG := nextLine[34] */
            mcOperazioni.row.IMPPROG = nextLine[34];
            /* mcOperazioni.DESPUNTO := nextLine[35] */
            mcOperazioni.row.DESPUNTO = nextLine[35];
            /* mcContante.SaveRow() */
            mcContante.SaveRow();
          } // End If
          /* _rownum := _rownum + 1 */
          _rownum = CPLib.Round(_rownum+1,0);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
          gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
          /* If pScheduler='S' */
          if (CPLib.eqr(pScheduler,"S")) {
            /* _logmsg := _logmsg + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + "<br>" */
            _logmsg = _logmsg+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"<br>";
          } // End If
          // * --- Insert into tmp_erroriimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000023E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000023E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
          // Accept Error
          m_Sql.AcceptTransactionError();
          m_cLastMsgError = "";
          m_bError = false;
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000215status,0)) {
            m_Sql.SetTransactionStatus(nTry00000215status,cTry00000215msg);
          }
        }
        /* gMsgImp := 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } else { // Else
        /* fhand := FileLibrary.OpenRead('appo/'+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) */
        fhand = FileLibrary.OpenRead("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
        /* While not(FileLibrary.Eof(fhand)) */
        while ( ! (FileLibrary.Eof(fhand))) {
          /* riga := FileLibrary.ReadLine(fhand) */
          riga = FileLibrary.ReadLine(fhand);
          double nTry00000245status;
          nTry00000245status = m_Sql.GetTransactionStatus();
          String cTry00000245msg;
          cTry00000245msg = m_Sql.TransactionErrorMessage();
          try {
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.TIPOOPER := Left(riga,2) */
            mcOperazioni.row.TIPOOPER = CPLib.Left(riga,2);
            /* mcOperazioni.CODSTUDIO := Substr(riga,3,11) */
            mcOperazioni.row.CODSTUDIO = CPLib.Substr(riga,3,11);
            /* mcOperazioni.CODDIPE := Substr(riga,14,6) */
            mcOperazioni.row.CODDIPE = CPLib.Substr(riga,14,6);
            /* mcOperazioni.NUMPROG := Substr(riga,20,11) */
            mcOperazioni.row.NUMPROG = CPLib.Substr(riga,20,11);
            /* mcOperazioni.DATAOPE := Substr(riga,31,8) */
            mcOperazioni.row.DATAOPE = CPLib.Substr(riga,31,8);
            /* mcOperazioni.FLAGFRAZ := Substr(riga,39,1) */
            mcOperazioni.row.FLAGFRAZ = CPLib.Substr(riga,39,1);
            /* mcOperazioni.CAUOPER := Substr(riga,40,4) */
            mcOperazioni.row.CAUOPER = CPLib.Substr(riga,40,4);
            /* mcOperazioni.CONNESCLI := Substr(riga,44,16) */
            mcOperazioni.row.CONNESCLI = CPLib.Substr(riga,44,16);
            /* mcOperazioni.CONNESREAL := Substr(riga,60,16) */
            mcOperazioni.row.CONNESREAL = CPLib.Substr(riga,60,16);
            /* mcOperazioni.CONNESBEN := Substr(riga,76,16) */
            mcOperazioni.row.CONNESBEN = CPLib.Substr(riga,76,16);
            /* mcOperazioni.DATAREG := Substr(riga,92,8) */
            mcOperazioni.row.DATAREG = CPLib.Substr(riga,92,8);
            /* mcOperazioni.STATOREG := Substr(riga,100,1) */
            mcOperazioni.row.STATOREG = CPLib.Substr(riga,100,1);
            /* mcOperazioni.DATARETT := Substr(riga,101,8) */
            mcOperazioni.row.DATARETT = CPLib.Substr(riga,101,8);
            /* mcOperazioni.VALUTA := Substr(riga,109,3) */
            mcOperazioni.row.VALUTA = CPLib.Substr(riga,109,3);
            /* mcOperazioni.IMPORTO := Val(Substr(riga,112,15)) / 100 */
            mcOperazioni.row.IMPORTO = CPLib.Val(CPLib.Substr(riga,112,15))/100;
            /* mcOperazioni.CONTANTI := Val(Substr(riga,127,15)) / 100 */
            mcOperazioni.row.CONTANTI = CPLib.Val(CPLib.Substr(riga,127,15))/100;
            /* mcOperazioni.MEZPAG := Substr(riga,142,30) */
            mcOperazioni.row.MEZPAG = CPLib.Substr(riga,142,30);
            /* mcOperazioni.PRESTAZ := Substr(riga,172,30) */
            mcOperazioni.row.PRESTAZ = CPLib.Substr(riga,172,30);
            /* mcOperazioni.POSIZ := Substr(riga,220,1) */
            mcOperazioni.row.POSIZ = CPLib.Substr(riga,220,1);
            /* mcOperazioni.RAGIO := Substr(riga,221,5) */
            mcOperazioni.row.RAGIO = CPLib.Substr(riga,221,5);
            /* mcOperazioni.MODSVOL := Substr(riga,226,5) */
            mcOperazioni.row.MODSVOL = CPLib.Substr(riga,226,5);
            /* mcOperazioni.AREAGEO := Substr(riga,231,5) */
            mcOperazioni.row.AREAGEO = CPLib.Substr(riga,231,5);
            /* mcOperazioni.AMMONT := Substr(riga,236,5) */
            mcOperazioni.row.AMMONT = CPLib.Substr(riga,236,5);
            /* mcOperazioni.DURAT := Substr(riga,241,5) */
            mcOperazioni.row.DURAT = CPLib.Substr(riga,241,5);
            /* mcOperazioni.TIPO := Substr(riga,246,5) */
            mcOperazioni.row.TIPO = CPLib.Substr(riga,246,5);
            /* mcOperazioni.RRAGIO := Val(Substr(riga,251,3)) */
            mcOperazioni.row.RRAGIO = CPLib.Val(CPLib.Substr(riga,251,3));
            /* mcOperazioni.RCOMP := Val(Substr(riga,254,3)) */
            mcOperazioni.row.RCOMP = CPLib.Val(CPLib.Substr(riga,254,3));
            /* mcOperazioni.RAREA := Val(Substr(riga,257,3)) */
            mcOperazioni.row.RAREA = CPLib.Val(CPLib.Substr(riga,257,3));
            /* mcOperazioni.RIMP := Val(Substr(riga,260,3)) */
            mcOperazioni.row.RIMP = CPLib.Val(CPLib.Substr(riga,260,3));
            /* mcOperazioni.RFREQ := Val(Substr(riga,263,3)) */
            mcOperazioni.row.RFREQ = CPLib.Val(CPLib.Substr(riga,263,3));
            /* mcOperazioni.RTIPO := Val(Substr(riga,266,3)) */
            mcOperazioni.row.RTIPO = CPLib.Val(CPLib.Substr(riga,266,3));
            /* mcOperazioni.IMPPROG := Substr(riga,269,13) */
            mcOperazioni.row.IMPPROG = CPLib.Substr(riga,269,13);
            /* mcOperazioni.DESPUNTO := Substr(riga,282,80) */
            mcOperazioni.row.DESPUNTO = CPLib.Substr(riga,282,80);
            /* mcContante.SaveRow() */
            mcContante.SaveRow();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
            gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
            /* If pScheduler='S' */
            if (CPLib.eqr(pScheduler,"S")) {
              /* _logmsg := _logmsg + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + "<br>" */
              _logmsg = _logmsg+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"<br>";
            } // End If
            // * --- Insert into tmp_erroriimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_erroriimp");
            m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000026D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000026D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000245status,0)) {
              m_Sql.SetTransactionStatus(nTry00000245status,cTry00000245msg);
            }
          }
          /* gMsgImp := 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
          gMsgImp = "Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End While
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
      } // End If
      /* gMsgProc := gMsgProc + 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' + NL // Log */
      gMsgProc = gMsgProc+"Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ..."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Termine Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Terminato Controllo Operazioni' // Messaggio Trasferimento */
      gMsgImp = "Terminato Controllo Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000277status;
      nTry00000277status = m_Sql.GetTransactionStatus();
      String cTry00000277msg;
      cTry00000277msg = m_Sql.TransactionErrorMessage();
      try {
        /* xRif := '' */
        xRif = "";
        for (MemoryCursorRow_tmp_imp_oper rowOperazioni : mcOperazioni._iterable_()) {
          /* xIDBASE := '' */
          xIDBASE = "";
          /* xStatoReg := '' */
          xStatoReg = "";
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xIDBASE = Read_Cursor.GetString("IDBASE");
            xStatoReg = Read_Cursor.GetString("STATOREG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xIDBASE = "";
            xStatoReg = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(xIDBASE) or (At(xStatoReg,'|0|1')=0 and not(Empty(xIDBASE))) */
          if (CPLib.Empty(xIDBASE) || (CPLib.eqr(CPLib.At(xStatoReg,"|0|1"),0) &&  ! (CPLib.Empty(xIDBASE)))) {
            /* xIDBASE := '' */
            xIDBASE = "";
            // * --- Read from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_cSql = "";
            m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
            if (m_Ctx.IsSharedTemp("xperazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xIDBASE = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xIDBASE = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(xIDBASE) */
            if (CPLib.Empty(xIDBASE)) {
              /* xStatoReg := '' */
              xStatoReg = "";
              // * --- Read from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_cSql = "";
              m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
              if (m_Ctx.IsSharedTemp("fraziobo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xIDBASE = Read_Cursor.GetString("IDBASE");
                xStatoReg = Read_Cursor.GetString("STATOREG");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on fraziobo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xIDBASE = "";
                xStatoReg = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(xIDBASE) or (At(xStatoReg,'|0|1')=0 and not(Empty(xIDBASE))) */
              if (CPLib.Empty(xIDBASE) || (CPLib.eqr(CPLib.At(xStatoReg,"|0|1"),0) &&  ! (CPLib.Empty(xIDBASE)))) {
                /* xIDBASE := '' */
                xIDBASE = "";
                // * --- Read from xraziobo
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_cSql = "";
                m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowOperazioni.IMPPROG));
                if (m_Ctx.IsSharedTemp("xraziobo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  xIDBASE = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on xraziobo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  xIDBASE = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
          } // End If
          /* If Empty(xIDBASE) */
          if (CPLib.Empty(xIDBASE)) {
            /* If w_tipodest='P' */
            if (CPLib.eqr(w_tipodest,"P")) {
              /* cOpePrg := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
              cOpePrg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            } else { // Else
              /* cOpePrg := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
              cOpePrg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
            } // End If
            /* _cauint := 0 */
            _cauint = CPLib.Round(0,0);
            /* _cauaui := '' */
            _cauaui = "";
            /* _finalita := '' */
            _finalita = "";
            /* _caurischio := 0 */
            _caurischio = CPLib.Round(0,0);
            /* Trasforma le date */
            /* cData1 := iif(Empty(rowOperazioni.DATAOPE),NullDate(),CharToDate(Right(rowOperazioni.DATAOPE,4)+Substr(rowOperazioni.DATAOPE,3,2)+Left(rowOperazioni.DATAOPE,2))) */
            cData1 = (CPLib.Empty(rowOperazioni.DATAOPE)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowOperazioni.DATAOPE,4)+CPLib.Substr(rowOperazioni.DATAOPE,3,2)+CPLib.Left(rowOperazioni.DATAOPE,2)));
            /* cData2 := iif(Empty(rowOperazioni.DATAREG),NullDate(),CharToDate(Right(rowOperazioni.DATAREG,4)+Substr(rowOperazioni.DATAREG,3,2)+Left(rowOperazioni.DATAREG,2))) */
            cData2 = (CPLib.Empty(rowOperazioni.DATAREG)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowOperazioni.DATAREG,4)+CPLib.Substr(rowOperazioni.DATAREG,3,2)+CPLib.Left(rowOperazioni.DATAREG,2)));
            /* cData3 := iif(Empty(rowOperazioni.DATARETT),NullDate(),CharToDate(Right(rowOperazioni.DATARETT,4)+Substr(rowOperazioni.DATARETT,3,2)+Left(rowOperazioni.DATARETT,2))) */
            cData3 = (CPLib.Empty(rowOperazioni.DATARETT)?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(rowOperazioni.DATARETT,4)+CPLib.Substr(rowOperazioni.DATARETT,3,2)+CPLib.Left(rowOperazioni.DATARETT,2)));
            /* Legge la valuta */
            /* cValuta := '' */
            cValuta = "";
            for (MemoryCursorRow_tbvalute rowValuta : mcTBVALUTE._iterable_()) {
              /* If rowValuta.CODVAL=rowOperazioni.VALUTA or rowValuta.ISO=rowOperazioni.VALUTA */
              if (CPLib.eqr(rowValuta.CODVAL,rowOperazioni.VALUTA) || CPLib.eqr(rowValuta.ISO,rowOperazioni.VALUTA)) {
                /* cValuta := rowValuta.CODVAL */
                cValuta = rowValuta.CODVAL;
                // Exit Loop
                if (true) {
                  break;
                }
              } // End If
            }
            /* cCli1 := '' */
            cCli1 = "";
            /* cCli2 := '' */
            cCli2 = "";
            /* cCli3 := '' */
            cCli3 = "";
            /* If not(Empty(LRTrim(rowOperazioni.CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(rowOperazioni.CONNESCLI)))) {
              /* _clinew := '' */
              _clinew = "";
              /* _cliente := LRTrim(rowOperazioni.CONNESCLI) */
              _cliente = CPLib.LRTrim(rowOperazioni.CONNESCLI);
              /* _flgcau := 'N' */
              _flgcau = "N";
              /* _cautmp := rowOperazioni.CAUOPER */
              _cautmp = rowOperazioni.CAUOPER;
              /* Exec "Trova codice cliente" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* cCli1 := _clinew */
              cCli1 = _clinew;
            } // End If
            /* If not(Empty(LRTrim(rowOperazioni.CONNESREAL))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(rowOperazioni.CONNESREAL)))) {
              /* _clinew := '' */
              _clinew = "";
              /* _cliente := LRTrim(rowOperazioni.CONNESREAL) */
              _cliente = CPLib.LRTrim(rowOperazioni.CONNESREAL);
              /* _cautmp := rowOperazioni.CAUOPER */
              _cautmp = rowOperazioni.CAUOPER;
              /* _flgcau := 'S' */
              _flgcau = "S";
              /* Exec "Trova codice cliente" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* cCli2 := _clinew */
              cCli2 = _clinew;
            } // End If
            /* If not(Empty(LRTrim(rowOperazioni.CONNESBEN))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(rowOperazioni.CONNESBEN)))) {
              /* _clinew := '' */
              _clinew = "";
              /* _cliente := LRTrim(rowOperazioni.CONNESBEN) */
              _cliente = CPLib.LRTrim(rowOperazioni.CONNESBEN);
              /* _cautmp := rowOperazioni.CAUOPER */
              _cautmp = rowOperazioni.CAUOPER;
              /* _flgcau := 'N' */
              _flgcau = "N";
              /* Exec "Trova codice cliente" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* cCli3 := _clinew */
              cCli3 = _clinew;
            } // End If
            /* Verifica il tipo di operazione */
            /* If Empty(cCli1) */
            if (CPLib.Empty(cCli1)) {
              /* _imperr := Utilities.GetAutonumber("PRGIMPOPER\'"+LRTrim(gAzienda)+"'",0,10) */
              _imperr = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPER\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
              // * --- Insert into scarti_import from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("scarti_import");
              m_cPhName = m_Ctx.GetPhName("scarti_import");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarti_import",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000002B4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002B4(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_imperr,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPOOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODSTUDIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DATAOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CAUOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESREAL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DATAREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DATARETT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.VALUTA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MEZPAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.POSIZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODABI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNALTRO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Cliente non rilevato","?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"scarti_import",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* _errrow := _errrow + 1 */
              _errrow = CPLib.Round(_errrow+1,0);
              /* gMsgImp := 'Sono state scartate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
              gMsgImp = "Sono state scartate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } else { // Else
              /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* If w_tipodest='P' */
              if (CPLib.eqr(w_tipodest,"P")) {
                /* xIDBASE := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
                xIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into xraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000002BA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002BA(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cauaui,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowOperazioni.CODSTUDIO)?CPLib.LRTrim(_cfinter):rowOperazioni.CODSTUDIO),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(rowOperazioni.CONTANTI,0)?"S,":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_PAGMEZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N° Pratica "+CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpePrg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_finalita,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(gTipInter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cValuta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } else { // Else
                /* xIDBASE := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
                xIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into fraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000002BC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000002BC(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cauaui,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowOperazioni.CODSTUDIO)?CPLib.LRTrim(_cfinter):rowOperazioni.CODSTUDIO),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCli2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cData3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(rowOperazioni.CONTANTI,0)?"S,":"N"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(rowOperazioni.MEZPAG))?w_PAGMEZ:rowOperazioni.MEZPAG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N° Pratica "+CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpePrg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_finalita,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(gTipInter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO*100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cValuta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("10","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
              /* _rownum := _rownum + 1 */
              _rownum = CPLib.Round(_rownum+1,0);
            } // End If
            /* gMsgImp := 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Frazionate ...' // Messaggio Trasferimento */
            gMsgImp = "Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Frazionate ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } else { // Else
            // Transaction Error
            cTry00000277msg = CPLib.FormatMsg(m_Ctx,"Import bloccato. Sono state trovate operazioni/frazionate già presenti con lo stesso codice");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Import bloccato. Sono state trovate operazioni/frazionate già presenti con lo stesso codice"));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Import bloccato. Sono state trovate operazioni/frazionate già presenti con lo stesso codice"));
          } // End If
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Frazionate ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Frazionate ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Sono state scartate '+LRTrim(Str(_errrow,10,0))+' Frazionate ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono state scartate "+CPLib.LRTrim(CPLib.Str(_errrow,10,0))+" Frazionate ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Import definitivo dei dati concluso con successo" + NL */
        gMsgProc = gMsgProc+"Import definitivo dei dati concluso con successo"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Errore nell'import definitivo dei dati: "+ NL + m_cLastMsgError + NL */
        gMsgProc = gMsgProc+"Errore nell'import definitivo dei dati: "+"\n"+m_cLastMsgError+"\n";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000277status,0)) {
          m_Sql.SetTransactionStatus(nTry00000277status,cTry00000277msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Fine Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Fine Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Terminato Import Frazionate' // Messaggio Trasferimento */
      gMsgImp = "Terminato Import Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If cActLog='S' */
      if (CPLib.eqr(cActLog,"S")) {
        /* Exec Routine arrt_writelog('IMPORT','Prestazioni/F',LRTrim(w_nomefile),gMsgProc) */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT","Prestazioni/F",CPLib.LRTrim(w_nomefile),gMsgProc);
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Import Contante */
      /* gMsgImp := 'Inizio Importazione Frazionate ...' // Messaggio Trasferimento */
      gMsgImp = "Inizio Importazione Frazionate ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Inizio Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg + 'Inizio Controllo File alle ore '+arfn_fdatetime(DateTime()) + "<br>" */
        _logmsg = _logmsg+"Inizio Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* _rownum := -1 */
      _rownum = CPLib.Round(-1,0);
      /* _errrow := 0 */
      _errrow = CPLib.Round(0,0);
      /* If w_tipoform = 'C' */
      if (CPLib.eqr(w_tipoform,"C")) {
        /* filename := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile) */
        filename = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile);
        FileReader freader=new FileReader(filename);
        CSVReader reader = new CSVReader(freader);
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
        double nTry000002D8status;
        nTry000002D8status = m_Sql.GetTransactionStatus();
        String cTry000002D8msg;
        cTry000002D8msg = m_Sql.TransactionErrorMessage();
        try {
          /* If _rownum >= 0 */
          if (CPLib.ge(_rownum,0)) {
            /* mcContante.AppendBlank() */
            mcContante.AppendBlank();
            /* mcContante.NUMPROG := nextLine[0] */
            mcContante.row.NUMPROG = nextLine[0];
            /* mcContante.TIPATT := nextLine[1] */
            mcContante.row.TIPATT = nextLine[1];
            /* mcContante.TIPOATTIV := nextLine[2] */
            mcContante.row.TIPOATTIV = nextLine[2];
            /* mcContante.CODICEGLN := nextLine[3] */
            mcContante.row.CODICEGLN = nextLine[3];
            /* mcContante.TOTBANKNOTE := Val(nextLine[4]) */
            mcContante.row.TOTBANKNOTE = CPLib.Val(nextLine[4]);
            /* mcContante.TAGLIO := Val(nextLine[5]) */
            mcContante.row.TAGLIO = CPLib.Val(nextLine[5]);
            /* mcContante.NBANCONOTE := Val(nextLine[6]) */
            mcContante.row.NBANCONOTE = CPLib.Val(nextLine[6]);
            /* mcContante.ABIINTER := nextLine[7] */
            mcContante.row.ABIINTER = nextLine[7];
            /* mcContante.ABIPROPR := nextLine[8] */
            mcContante.row.ABIPROPR = nextLine[8];
            /* mcContante.GLNALTROSOG := nextLine[9] */
            mcContante.row.GLNALTROSOG = nextLine[9];
            /* mcContante.GLNALTRASC := nextLine[10] */
            mcContante.row.GLNALTRASC = nextLine[10];
            /* mcContante.CODCLICON := nextLine[11] */
            mcContante.row.CODCLICON = nextLine[11];
            /* mcContante.CODCOMCON := nextLine[12] */
            mcContante.row.CODCOMCON = nextLine[12];
            /* mcContante.ATECO_CON := nextLine[13] */
            mcContante.row.ATECO_CON = nextLine[13];
            /* mcContante.IMPPROG := nextLine[14] */
            mcContante.row.IMPPROG = nextLine[14];
            /* mcContante.TOTRIGA := Val(nextLine[15]) */
            mcContante.row.TOTRIGA = CPLib.Val(nextLine[15]);
            /* mcContante.SaveRow() */
            mcContante.SaveRow();
          } // End If
          /* _rownum := _rownum + 1 */
          _rownum = CPLib.Round(_rownum+1,0);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
          gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
          // * --- Insert into tmp_erroriimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_erroriimp");
          m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"000002EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002EE(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
          // Accept Error
          m_Sql.AcceptTransactionError();
          m_cLastMsgError = "";
          m_bError = false;
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000002D8status,0)) {
            m_Sql.SetTransactionStatus(nTry000002D8status,cTry000002D8msg);
          }
        }
        /* gMsgImp := 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Righe Contanti ...' // Messaggio Trasferimento */
        gMsgImp = "Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Righe Contanti ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        }
        // Chiuse il file
        reader.close();
      } else { // Else
        /* fhand := FileLibrary.OpenRead('appo/'+LRTrim(gAzienda)+LRTrim(w_nomefile)) */
        fhand = FileLibrary.OpenRead("appo/"+CPLib.LRTrim(gAzienda)+CPLib.LRTrim(w_nomefile));
        /* While not(FileLibrary.Eof(fhand)) */
        while ( ! (FileLibrary.Eof(fhand))) {
          /* riga := FileLibrary.ReadLine(fhand) */
          riga = FileLibrary.ReadLine(fhand);
          double nTry000002F5status;
          nTry000002F5status = m_Sql.GetTransactionStatus();
          String cTry000002F5msg;
          cTry000002F5msg = m_Sql.TransactionErrorMessage();
          try {
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
            /* mcContante.AppendBlank() */
            mcContante.AppendBlank();
            /* mcContante.NUMPROG := Left(riga,11) */
            mcContante.row.NUMPROG = CPLib.Left(riga,11);
            /* mcContante.TIPATT := Substr(riga,12,3) */
            mcContante.row.TIPATT = CPLib.Substr(riga,12,3);
            /* mcContante.TIPOATTIV := Substr(riga,15,2) */
            mcContante.row.TIPOATTIV = CPLib.Substr(riga,15,2);
            /* mcContante.CODICEGLN := Substr(riga,17,13) */
            mcContante.row.CODICEGLN = CPLib.Substr(riga,17,13);
            /* mcContante.TOTBANKNOTE := Val(Substr(riga,30,10)) */
            mcContante.row.TOTBANKNOTE = CPLib.Val(CPLib.Substr(riga,30,10));
            /* mcContante.TAGLIO := Val(Substr(riga,40,4)) */
            mcContante.row.TAGLIO = CPLib.Val(CPLib.Substr(riga,40,4));
            /* mcContante.NBANCONOTE := Val(Substr(riga,44,10)) */
            mcContante.row.NBANCONOTE = CPLib.Val(CPLib.Substr(riga,44,10));
            /* mcContante.ABIINTER := Substr(riga,54,5) */
            mcContante.row.ABIINTER = CPLib.Substr(riga,54,5);
            /* mcContante.ABIPROPR := Substr(riga,59,5) */
            mcContante.row.ABIPROPR = CPLib.Substr(riga,59,5);
            /* mcContante.GLNALTROSOG := Substr(riga,64,13) */
            mcContante.row.GLNALTROSOG = CPLib.Substr(riga,64,13);
            /* mcContante.GLNALTRASC := Substr(riga,77,13) */
            mcContante.row.GLNALTRASC = CPLib.Substr(riga,77,13);
            /* mcContante.CODCLICON := Substr(riga,90,20) */
            mcContante.row.CODCLICON = CPLib.Substr(riga,90,20);
            /* mcContante.CODCOMCON := Substr(riga,110,6) */
            mcContante.row.CODCOMCON = CPLib.Substr(riga,110,6);
            /* mcContante.ATECO_CON := Substr(riga,116,10) */
            mcContante.row.ATECO_CON = CPLib.Substr(riga,116,10);
            /* mcContante.IMPPROG := Substr(riga,126,13) */
            mcContante.row.IMPPROG = CPLib.Substr(riga,126,13);
            /* mcContante.TOTRIGA := Val(Substr(riga,139,12)) */
            mcContante.row.TOTRIGA = CPLib.Val(CPLib.Substr(riga,139,12));
            /* mcContante.SaveRow() */
            mcContante.SaveRow();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* gMsgProc := gMsgProc + 'Riga Numero: '+LRTrim(Str(_rownum,10,0)) + " " + m_cLastMsgError + NL */
            gMsgProc = gMsgProc+"Riga Numero: "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" "+m_cLastMsgError+"\n";
            // * --- Insert into tmp_erroriimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_erroriimp");
            m_cPhName = m_Ctx.GetPhName("tmp_erroriimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_erroriimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000030A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000030A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_rownum,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(m_cLastMsgError,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_erroriimp",true);
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
            // Accept Error
            m_Sql.AcceptTransactionError();
            m_cLastMsgError = "";
            m_bError = false;
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000002F5status,0)) {
              m_Sql.SetTransactionStatus(nTry000002F5status,cTry000002F5msg);
            }
          }
          /* gMsgImp := 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' righe Contante ...' // Messaggio Trasferimento */
          gMsgImp = "Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" righe Contante ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End While
        /* FileLibrary.Close(fhand) */
        FileLibrary.Close(fhand);
      } // End If
      /* gMsgProc := gMsgProc + 'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Righe Contanti ...' + NL // Log */
      gMsgProc = gMsgProc+"Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Righe Contanti ..."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Termine Controllo File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg +  'Sono state controllate '+LRTrim(Str(_rownum,10,0))+' Righe Contanti ...' + "<br>" */
        _logmsg = _logmsg+"Sono state controllate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Righe Contanti ..."+"<br>";
        /* _logmsg := _logmsg + 'Termine Controllo File alle ore '+arfn_fdatetime(DateTime()) + "<br>" */
        _logmsg = _logmsg+"Termine Controllo File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* gMsgImp := 'Terminato Controllo Frazionate' // Messaggio Trasferimento */
      gMsgImp = "Terminato Controllo Frazionate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + "<br>" // Log */
        _logmsg = _logmsg+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000031Astatus;
      nTry0000031Astatus = m_Sql.GetTransactionStatus();
      String cTry0000031Amsg;
      cTry0000031Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* _numprog := '' */
        _numprog = "";
        /* _totgen := 0 */
        _totgen = CPLib.Round(0,2);
        for (MemoryCursorRow_tmp_contante rowContante : mcContante._iterable_()) {
          /* If _numprog <> rowContante.IMPPROG */
          if (CPLib.ne(_numprog,rowContante.IMPPROG)) {
            /* If _numprog <> '' */
            if (CPLib.ne(_numprog,"")) {
              /* Case xRif='OD' */
              if (CPLib.eqr(xRif,"OD")) {
                // * --- Write into ope_contante from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("ope_contante");
                m_cPhName = m_Ctx.GetPhName("ope_contante");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000322")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"ope_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* Case xRif='OP' */
              } else if (CPLib.eqr(xRif,"OP")) {
                // * --- Write into xpe_contante from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xpe_contante");
                m_cPhName = m_Ctx.GetPhName("xpe_contante");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xpe_contante",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000323")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xpe_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* Case xRif='FD' */
              } else if (CPLib.eqr(xRif,"FD")) {
                // * --- Write into frz_contante from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("frz_contante");
                m_cPhName = m_Ctx.GetPhName("frz_contante");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"frz_contante",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000324")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"frz_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* Case xRif='FP' */
              } else if (CPLib.eqr(xRif,"FP")) {
                // * --- Write into xrz_contante from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xrz_contante");
                m_cPhName = m_Ctx.GetPhName("xrz_contante");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xrz_contante",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000325")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xrz_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End Case
            } // End If
            /* _numprog := rowContante.IMPPROG */
            _numprog = rowContante.IMPPROG;
            /* _totgen := rowContante.TOTRIGA */
            _totgen = CPLib.Round(rowContante.TOTRIGA,2);
          } else { // Else
            /* _totgen := _totgen + rowContante.TOTRIGA */
            _totgen = CPLib.Round(_totgen+rowContante.TOTRIGA,2);
          } // End If
          /* xIDBASE := '' */
          xIDBASE = "";
          /* xRif := '' */
          xRif = "";
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG));
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xIDBASE = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xIDBASE = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(xIDBASE) */
          if (CPLib.Empty(xIDBASE)) {
            // * --- Read from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_cSql = "";
            m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG));
            if (m_Ctx.IsSharedTemp("xperazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xIDBASE = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xIDBASE = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(xIDBASE) */
            if (CPLib.Empty(xIDBASE)) {
              // * --- Read from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_cSql = "";
              m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG));
              if (m_Ctx.IsSharedTemp("fraziobo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xIDBASE = Read_Cursor.GetString("IDBASE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on fraziobo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xIDBASE = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(xIDBASE) */
              if (CPLib.Empty(xIDBASE)) {
                // * --- Read from xraziobo
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_cSql = "";
                m_cSql = m_cSql+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG));
                if (m_Ctx.IsSharedTemp("xraziobo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  xIDBASE = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on xraziobo into routine opert_imp_dati returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  xIDBASE = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If not(Empty(xIDBASE)) */
                if ( ! (CPLib.Empty(xIDBASE))) {
                  /* xRif := 'FP' */
                  xRif = "FP";
                  // * --- Write into xraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000334")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?"8199":"8101"),"C",4,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IMPPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } // End If
              } else { // Else
                /* xRif := 'FD' */
                xRif = "FD";
                // * --- Write into fraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000336")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?"8199":"8101"),"C",4,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IMPPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
              } // End If
            } else { // Else
              /* xRif := 'OP' */
              xRif = "OP";
              // * --- Write into xperazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xperazbo");
              m_cPhName = m_Ctx.GetPhName("xperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000338")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
              m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?"8199":"8101"),"C",4,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IMPPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End If
          } else { // Else
            /* xRif := 'OD' */
            xRif = "OD";
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000033A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?"8199":"8101"),"C",4,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IMPPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG))+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
          } // End If
          /* If not(Empty(xIDBASE)) */
          if ( ! (CPLib.Empty(xIDBASE))) {
            /* _ateco := iif(not(Empty(LRTrim(rowContante.ATECO_CON))),Left(LRTrim(rowContante.ATECO_CON)+"0000000000",6),'') */
            _ateco = ( ! (CPLib.Empty(CPLib.LRTrim(rowContante.ATECO_CON)))?CPLib.Left(CPLib.LRTrim(rowContante.ATECO_CON)+"0000000000",6):"");
            /* _istat := iif(not(Empty(LRTrim(rowContante.CODCOMCON))),Right('000000'+LRTrim(rowContante.CODCOMCON),6),'') */
            _istat = ( ! (CPLib.Empty(CPLib.LRTrim(rowContante.CODCOMCON)))?CPLib.Right("000000"+CPLib.LRTrim(rowContante.CODCOMCON),6):"");
            /* Case xRif='OD' */
            if (CPLib.eqr(xRif,"OD")) {
              // * --- Merge into ope_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("ope_contante");
              m_cPhName = m_Ctx.GetPhName("ope_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(xIDBASE,"?",0,0)+" as IDOPE";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+" as TAGLIO";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "ope_contante.IDOPE = cptmp_1xab23.IDOPE";
              m_cWhere = m_cWhere+" and "+"ope_contante.TAGLIO = cptmp_1xab23.TAGLIO";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000033F")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" ope_contante USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"ope_contante",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_0000033F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"ope_contante",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000033F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"ope_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+" and TAGLIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowContante.TAGLIO,"?",0,0,m_cServer),m_cServer,rowContante.TAGLIO)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000033F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000033F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"ope_contante",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* Case xRif='OP' */
            } else if (CPLib.eqr(xRif,"OP")) {
              // * --- Merge into xpe_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xpe_contante");
              m_cPhName = m_Ctx.GetPhName("xpe_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xpe_contante",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(xIDBASE,"?",0,0)+" as IDOPE";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+" as TAGLIO";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "xpe_contante.IDOPE = cptmp_1xab23.IDOPE";
              m_cWhere = m_cWhere+" and "+"xpe_contante.TAGLIO = cptmp_1xab23.TAGLIO";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000340")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" xpe_contante USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xpe_contante",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000340(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xpe_contante",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000340")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xpe_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+" and TAGLIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowContante.TAGLIO,"?",0,0,m_cServer),m_cServer,rowContante.TAGLIO)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000340")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000340(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xpe_contante",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* Case xRif='FD' */
            } else if (CPLib.eqr(xRif,"FD")) {
              // * --- Merge into frz_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("frz_contante");
              m_cPhName = m_Ctx.GetPhName("frz_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"frz_contante",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(xIDBASE,"?",0,0)+" as IDOPE";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+" as TAGLIO";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "frz_contante.IDOPE = cptmp_1xab23.IDOPE";
              m_cWhere = m_cWhere+" and "+"frz_contante.TAGLIO = cptmp_1xab23.TAGLIO";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000341")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" frz_contante USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"frz_contante",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000341(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"frz_contante",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000341")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"frz_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+" and TAGLIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowContante.TAGLIO,"?",0,0,m_cServer),m_cServer,rowContante.TAGLIO)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000341")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000341(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"frz_contante",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* Case xRif='FP' */
            } else if (CPLib.eqr(xRif,"FP")) {
              // * --- Merge into xrz_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xrz_contante");
              m_cPhName = m_Ctx.GetPhName("xrz_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xrz_contante",m_Ctx.GetCompany());
              m_cQuery = "select ";
              m_cQuery =  m_cQuery+""+CPLib.ToSQL(xIDBASE,"?",0,0)+" as IDOPE";
              m_cQuery =  m_cQuery+", "+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+" as TAGLIO";
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                m_cQuery = m_cQuery+" from dual";
              }
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cWhere = "xrz_contante.IDOPE = cptmp_1xab23.IDOPE";
              m_cWhere = m_cWhere+" and "+"xrz_contante.TAGLIO = cptmp_1xab23.TAGLIO";
              m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
              if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000342")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" xrz_contante USING ";
                m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xrz_contante",true,true);
                m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                m_cSql = m_cSql+GetFieldsName_00000342(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xrz_contante",true);
                m_cSql = m_cSql+")";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = m_cSql+";";
                }
              } else {
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000342")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"BILLSRIT = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"BILLSSOV = "+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"N",10,0)+", ";
                m_cSql = m_cSql+"TIPATT = "+CPLib.ToSQL(rowContante.TIPATT,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOATTIV = "+CPLib.ToSQL(rowContante.TIPOATTIV,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODICEGLN = "+CPLib.ToSQL(rowContante.CODICEGLN,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"NBANCONOTE = "+CPLib.ToSQL(rowContante.NBANCONOTE,"N",5,0)+", ";
                m_cSql = m_cSql+"ABIINTER = "+CPLib.ToSQL(rowContante.ABIINTER,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"ABIPROPR = "+CPLib.ToSQL(rowContante.ABIPROPR,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTROSOG = "+CPLib.ToSQL(rowContante.GLNALTROSOG,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"GLNALTRASC = "+CPLib.ToSQL(rowContante.GLNALTRASC,"C",13,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCLICON = "+CPLib.ToSQL(rowContante.CODCLICON,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCOMCON = "+CPLib.ToSQL(_istat,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATECO_CON = "+CPLib.ToSQL(_ateco,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TOTALERIG = "+CPLib.ToSQL(rowContante.TOTRIGA,"N",12,2)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xrz_contante",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
                m_cSql = m_cSql+" and TAGLIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowContante.TAGLIO,"?",0,0,m_cServer),m_cServer,rowContante.TAGLIO)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.eqr(m_nUpdatedRows,0)) {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000342")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000342(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"RIT")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(rowContante.TIPATT,"SOV")?rowContante.TOTBANKNOTE:0),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_istat,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_ateco,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xrz_contante",true);
                  m_cSql = m_cSql+")";
                } else {
                  m_cSql = "";
                }
              }
              if ( ! (CPLib.Empty(m_cSql))) {
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              }
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
            } // End Case
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
            /* gMsgImp := 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Righe Contante ...' // Messaggio Trasferimento */
            gMsgImp = "Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Righe Contante ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } else { // Else
            /* xIMPPROG := 0 */
            xIMPPROG = CPLib.Round(0,0);
            // * --- Read from scarti_import
            m_cServer = m_Ctx.GetServer("scarti_import");
            m_cPhName = m_Ctx.GetPhName("scarti_import");
            m_cSql = "";
            m_cSql = m_cSql+"IMPPROG13="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowContante.IMPPROG),"C",13,0,m_cServer),m_cServer,CPLib.LRTrim(rowContante.IMPPROG));
            if (m_Ctx.IsSharedTemp("scarti_import")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IMPPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xIMPPROG = CPLib.Round(Read_Cursor.GetDouble("IMPPROG"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on scarti_import into routine opert_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xIMPPROG = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If xIMPPROG <> 0 */
            if (CPLib.ne(xIMPPROG,0)) {
              // * --- Insert into scarto_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("scarto_contante");
              m_cPhName = m_Ctx.GetPhName("scarto_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarto_contante",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"00000348")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000348(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPATT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TIPOATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODICEGLN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTBANKNOTE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TAGLIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.NBANCONOTE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ABIPROPR,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTROSOG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.GLNALTRASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCLICON,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODCOMCON,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.ATECO_CON,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.IMPPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowContante.TOTRIGA,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"scarto_contante",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* _errrow := _errrow + 1 */
              _errrow = CPLib.Round(_errrow+1,0);
              /* gMsgImp := 'Sono state scartate '+LRTrim(Str(_errrow,10,0))+' Righe Contante ...' // Messaggio Trasferimento */
              gMsgImp = "Sono state scartate "+CPLib.LRTrim(CPLib.Str(_errrow,10,0))+" Righe Contante ...";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
          } // End If
        }
        /* Case xRif='OD' */
        if (CPLib.eqr(xRif,"OD")) {
          // * --- Write into ope_contante from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("ope_contante");
          m_cPhName = m_Ctx.GetPhName("ope_contante");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ope_contante",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000034C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"ope_contante",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* Case xRif='OP' */
        } else if (CPLib.eqr(xRif,"OP")) {
          // * --- Write into xpe_contante from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xpe_contante");
          m_cPhName = m_Ctx.GetPhName("xpe_contante");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xpe_contante",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000034D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xpe_contante",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* Case xRif='FD' */
        } else if (CPLib.eqr(xRif,"FD")) {
          // * --- Write into frz_contante from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("frz_contante");
          m_cPhName = m_Ctx.GetPhName("frz_contante");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"frz_contante",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000034E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"frz_contante",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* Case xRif='FP' */
        } else if (CPLib.eqr(xRif,"FP")) {
          // * --- Write into xrz_contante from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xrz_contante");
          m_cPhName = m_Ctx.GetPhName("xrz_contante");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xrz_contante",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati",327,"0000034F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TOTALEGEN = "+CPLib.ToSQL(_totgen,"N",12,2)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xrz_contante",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer),m_cServer,xIDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
        } // End Case
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Righe Contante ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Righe Contante ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Sono state scartate '+LRTrim(Str(_errrow,10,0))+' Righe Contante ...' + NL // Log */
        gMsgProc = gMsgProc+"Sono state scartate "+CPLib.LRTrim(CPLib.Str(_errrow,10,0))+" Righe Contante ..."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Import definitivo dei dati concluso con successo" + NL */
        gMsgProc = gMsgProc+"Import definitivo dei dati concluso con successo"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If pScheduler='S' */
        if (CPLib.eqr(pScheduler,"S")) {
          /* _logmsg := _logmsg + 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Righe Contante ...' + "<br>" // Log */
          _logmsg = _logmsg+"Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Righe Contante ..."+"<br>";
          /* _logmsg := _logmsg + 'Sono state scartate '+LRTrim(Str(_errrow,10,0))+' Righe Contante ...' + "<br>" // Log */
          _logmsg = _logmsg+"Sono state scartate "+CPLib.LRTrim(CPLib.Str(_errrow,10,0))+" Righe Contante ..."+"<br>";
          /* _logmsg := _logmsg + "Import definitivo dei dati concluso con successo" + "<br>" */
          _logmsg = _logmsg+"Import definitivo dei dati concluso con successo"+"<br>";
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Errore nell'import definitivo dei dati: "+ NL + m_cLastMsgError + NL */
        gMsgProc = gMsgProc+"Errore nell'import definitivo dei dati: "+"\n"+m_cLastMsgError+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If pScheduler='S' */
        if (CPLib.eqr(pScheduler,"S")) {
          /* _logmsg := _logmsg +  "Errore nell'import definitivo dei dati: " + m_cLastMsgError + "<br>" */
          _logmsg = _logmsg+"Errore nell'import definitivo dei dati: "+m_cLastMsgError+"<br>";
        } // End If
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000031Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000031Astatus,cTry0000031Amsg);
        }
      }
      /* gMsgProc := gMsgProc + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Fine Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Fine Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pScheduler='S' */
      if (CPLib.eqr(pScheduler,"S")) {
        /* _logmsg := _logmsg + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + "<br>" // Log */
        _logmsg = _logmsg+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
        /* _logmsg := _logmsg + 'Fine Elaborazione del file '+LRTrim(w_nomefile)+" alle ore "+arfn_fdatetime(DateTime()) + "<br>" */
        _logmsg = _logmsg+"Fine Elaborazione del file "+CPLib.LRTrim(w_nomefile)+" alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"<br>";
      } // End If
      /* gMsgImp := 'Terminato Import Contante' // Messaggio Trasferimento */
      gMsgImp = "Terminato Import Contante";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If cActLog='S' */
      if (CPLib.eqr(cActLog,"S")) {
        /* Exec Routine arrt_writelog('IMPORT','Contanti',LRTrim(w_nomefile),gMsgProc) */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT","Contanti",CPLib.LRTrim(w_nomefile),gMsgProc);
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
    /* _flgfind Char(1) */
    String _flgfind;
    _flgfind = CPLib.Space(1);
    /* _clinew := '' */
    _clinew = "";
    /* _flgfind := 'S' */
    _flgfind = "S";
    for (MemoryCursorRow_qbe_personbo_ope_vqr rowPersonbo : mcPERSONBO._iterable_()) {
      /* If (rowPersonbo.CONNES=_cliente or rowPersonbo.CODFISC=_cliente or rowPersonbo.PARTIVA=_cliente) */
      if ((CPLib.eqr(rowPersonbo.CONNES,_cliente) || CPLib.eqr(rowPersonbo.CODFISC,_cliente) || CPLib.eqr(rowPersonbo.PARTIVA,_cliente))) {
        /* _clinew := rowPersonbo.CONNES */
        _clinew = rowPersonbo.CONNES;
        // Exit Loop
        if (true) {
          break;
        }
      } // End If
    }
    /* If _flgcau='S' and _flgfind='S' and not(Empty(_clinew)) */
    if (CPLib.eqr(_flgcau,"S") && CPLib.eqr(_flgfind,"S") &&  ! (CPLib.Empty(_clinew))) {
      /* _cauint := iif(Empty(_cautmp),_cauint,Val(_cautmp)) */
      _cauint = CPLib.Round((CPLib.Empty(_cautmp)?_cauint:CPLib.Val(_cautmp)),0);
      /* If _cauint <> 0 */
      if (CPLib.ne(_cauint,0)) {
        for (MemoryCursorRow_tbcauint rowCausale : mcTBCAUINT._iterable_()) {
          /* If rowCausale.CICODICE=_cauint */
          if (CPLib.eqr(rowCausale.CICODICE,_cauint)) {
            /* _cauaui := rowCausale.CICAUCOD */
            _cauaui = rowCausale.CICAUCOD;
            /* _finalita := rowCausale.CIFINALIT */
            _finalita = rowCausale.CIFINALIT;
            /* _caurischio := rowCausale.CIRISCHIO */
            _caurischio = CPLib.Round(rowCausale.CIRISCHIO,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        }
      } // End If
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_w_nomefile,String p_w_tipodest,String p_w_tipofile,String p_w_tipoform,String p_w_PAGMEZ,String p_pScheduler) {
    w_nomefile = p_w_nomefile;
    w_tipodest = p_w_tipodest;
    w_tipofile = p_w_tipofile;
    w_tipoform = p_w_tipoform;
    w_PAGMEZ = p_w_PAGMEZ;
    pScheduler = p_pScheduler;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public String Run(String p_w_nomefile,String p_w_tipodest,String p_w_tipofile,String p_w_tipoform,String p_w_PAGMEZ,String p_pScheduler) {
    w_nomefile = p_w_nomefile;
    w_tipodest = p_w_tipodest;
    w_tipofile = p_w_tipofile;
    w_tipoform = p_w_tipoform;
    w_PAGMEZ = p_w_PAGMEZ;
    pScheduler = p_pScheduler;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
    return l_result;
  }
  public static opert_imp_datiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_imp_datiR(p_Ctx, p_Caller);
  }
  public static opert_imp_datiR Make(CPContext p_Ctx) {
    return new opert_imp_datiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_nomefile = CPLib.Space(100);
    w_tipodest = CPLib.Space(1);
    w_tipofile = CPLib.Space(1);
    w_tipoform = CPLib.Space(1);
    w_PAGMEZ = CPLib.Space(30);
    pScheduler = CPLib.Space(1);
    fhand = CPLib.Space(1);
    filename = CPLib.Space(80);
    riga = "";
    xIDBASE = CPLib.Space(10);
    cCliProg = CPLib.Space(6);
    xSesso = CPLib.Space(1);
    bModifica = 0;
    cData1 = CPLib.NullDate();
    cData2 = CPLib.NullDate();
    cData3 = CPLib.NullDate();
    cData4 = CPLib.NullDate();
    cData5 = CPLib.NullDate();
    cOpePrg = CPLib.Space(7);
    cCli1 = CPLib.Space(7);
    cCli2 = CPLib.Space(7);
    cCli3 = CPLib.Space(7);
    cValuta = CPLib.Space(3);
    xRif = CPLib.Space(7);
    xPrg = CPLib.Space(7);
    xPaese = CPLib.Space(3);
    _path = CPLib.Space(128);
    _rownum = 0;
    _errrow = 0;
    _conta = 0;
    cRitorno = CPLib.Space(0);
    _tipointer = CPLib.Space(2);
    _cfinter = CPLib.Space(16);
    _specie = CPLib.Space(4);
    _area = CPLib.Space(5);
    _ateco = CPLib.Space(10);
    _istat = CPLib.Space(6);
    _cauint = 0;
    _cautmp = CPLib.Space(4);
    _cauaui = CPLib.Space(4);
    _finalita = CPLib.Space(50);
    _caurischio = 0;
    _cliente = CPLib.Space(16);
    _clinew = CPLib.Space(16);
    _flgcau = CPLib.Space(1);
    mcTBCAUINT = new MemoryCursor_tbcauint();
    mcTBVALUTE = new MemoryCursor_tbvalute();
    mcPERSONBO = new MemoryCursor_qbe_personbo_ope_vqr();
    mcSoggetti = new MemoryCursor_tmp_imp_sog();
    mcOperazioni = new MemoryCursor_tmp_imp_oper();
    mcContante = new MemoryCursor_tmp_contante();
    _imperr = 0;
    xStatoReg = CPLib.Space(1);
    _numprog = CPLib.Space(13);
    _totgen = 0;
    xIMPPROG = 0;
    _logmsg = "";
    cProgSto = CPLib.Space(15);
    nProgSto = 0;
    nProgImp = 0;
    _datarett = CPLib.NullDate();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    cActLog=m_Ctx.GetGlobalString("cActLog");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_personbo_ope,
  public static final String m_cVQRList = ",qbe_personbo_ope,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_writelog,opert_imp_dati,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_writelog,opert_imp_dati,";
  public static String[] m_cRunParameterNames={"w_nomefile","w_tipodest","w_tipofile","w_tipoform","w_PAGMEZ","pScheduler"};
  protected static String GetFieldsName_0000009A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000EB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000127(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"CODLEGRAP,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"DATAIDENT,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATARAUT,";
    p_cSql = p_cSql+"DISATTIVO,";
    p_cSql = p_cSql+"FATTURATO,";
    p_cSql = p_cSql+"FLGNOTRIM,";
    p_cSql = p_cSql+"FREQUENZA,";
    p_cSql = p_cSql+"IMPORTOMAX,";
    p_cSql = p_cSql+"NUMOPERAZ,";
    p_cSql = p_cSql+"RAPSEGNA,";
    p_cSql = p_cSql+"SOGAFFIDATARIO,";
    p_cSql = p_cSql+"TIPOSOGGETTO,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"ALTROCAP,";
    p_cSql = p_cSql+"ALTRODOM,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"BANCABEN,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CITTADIN1,";
    p_cSql = p_cSql+"CITTADIN2,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODORO,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CRIME,";
    p_cSql = p_cSql+"CRIMEDATE,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAPROF,";
    p_cSql = p_cSql+"DATAREVPROF,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"IDENT,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDNASCOMUN,";
    p_cSql = p_cSql+"IDNASSTATO,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PEPDATE,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESFISC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SETTSINT2,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"TELEF,";
    p_cSql = p_cSql+"TIN,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"TIPOOPER,";
    p_cSql = p_cSql+"CODSTUDIO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CAUOPER,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESREAL,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"POSIZ,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"CODABI,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"IMPPROG13,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"scarti_import",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000026D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"TIPOOPER,";
    p_cSql = p_cSql+"CODSTUDIO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"CAUOPER,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESREAL,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"CONTANTI,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"POSIZ,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"CODABI,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+"IMPPROG13,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"scarti_import",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002BA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002BC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"MEZPAG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000030A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errormsg,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_erroriimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000033F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDOPE,";
    p_cSql = p_cSql+"BILLSRIT,";
    p_cSql = p_cSql+"BILLSSOV,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPOATTIV,";
    p_cSql = p_cSql+"CODICEGLN,";
    p_cSql = p_cSql+"TAGLIO,";
    p_cSql = p_cSql+"NBANCONOTE,";
    p_cSql = p_cSql+"ABIINTER,";
    p_cSql = p_cSql+"ABIPROPR,";
    p_cSql = p_cSql+"GLNALTROSOG,";
    p_cSql = p_cSql+"GLNALTRASC,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODCOMCON,";
    p_cSql = p_cSql+"ATECO_CON,";
    p_cSql = p_cSql+"TOTALERIG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"ope_contante",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000340(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDOPE,";
    p_cSql = p_cSql+"BILLSRIT,";
    p_cSql = p_cSql+"BILLSSOV,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPOATTIV,";
    p_cSql = p_cSql+"CODICEGLN,";
    p_cSql = p_cSql+"TAGLIO,";
    p_cSql = p_cSql+"NBANCONOTE,";
    p_cSql = p_cSql+"ABIINTER,";
    p_cSql = p_cSql+"ABIPROPR,";
    p_cSql = p_cSql+"GLNALTROSOG,";
    p_cSql = p_cSql+"GLNALTRASC,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODCOMCON,";
    p_cSql = p_cSql+"ATECO_CON,";
    p_cSql = p_cSql+"TOTALERIG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xpe_contante",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000341(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDOPE,";
    p_cSql = p_cSql+"BILLSRIT,";
    p_cSql = p_cSql+"BILLSSOV,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPOATTIV,";
    p_cSql = p_cSql+"CODICEGLN,";
    p_cSql = p_cSql+"TAGLIO,";
    p_cSql = p_cSql+"NBANCONOTE,";
    p_cSql = p_cSql+"ABIINTER,";
    p_cSql = p_cSql+"ABIPROPR,";
    p_cSql = p_cSql+"GLNALTROSOG,";
    p_cSql = p_cSql+"GLNALTRASC,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODCOMCON,";
    p_cSql = p_cSql+"ATECO_CON,";
    p_cSql = p_cSql+"TOTALERIG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"frz_contante",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000342(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDOPE,";
    p_cSql = p_cSql+"BILLSRIT,";
    p_cSql = p_cSql+"BILLSSOV,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPOATTIV,";
    p_cSql = p_cSql+"CODICEGLN,";
    p_cSql = p_cSql+"TAGLIO,";
    p_cSql = p_cSql+"NBANCONOTE,";
    p_cSql = p_cSql+"ABIINTER,";
    p_cSql = p_cSql+"ABIPROPR,";
    p_cSql = p_cSql+"GLNALTROSOG,";
    p_cSql = p_cSql+"GLNALTRASC,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODCOMCON,";
    p_cSql = p_cSql+"ATECO_CON,";
    p_cSql = p_cSql+"TOTALERIG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xrz_contante",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000348(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPATT,";
    p_cSql = p_cSql+"TIPOATTIV,";
    p_cSql = p_cSql+"CODICEGLN,";
    p_cSql = p_cSql+"TOTBANKNOTE,";
    p_cSql = p_cSql+"TAGLIO,";
    p_cSql = p_cSql+"NBANCONOTE,";
    p_cSql = p_cSql+"ABIINTER,";
    p_cSql = p_cSql+"ABIPROPR,";
    p_cSql = p_cSql+"GLNALTROSOG,";
    p_cSql = p_cSql+"GLNALTRASC,";
    p_cSql = p_cSql+"CODCLICON,";
    p_cSql = p_cSql+"CODCOMCON,";
    p_cSql = p_cSql+"ATECO_CON,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"TOTRIGA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"scarto_contante",true);
    return p_cSql;
  }
}
