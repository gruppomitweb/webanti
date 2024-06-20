// * --- Area Manuale = BO - Header
// * --- opert_imp_dati_soggetto
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
// * --- Fine Area Manuale
public class opert_imp_dati_soggettoR implements CallerWithObjs {
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
  public String m_cPhName_tmp_imp_oper;
  public String m_cServer_tmp_imp_oper;
  public String m_cPhName_xpe_contante;
  public String m_cServer_xpe_contante;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xrz_contante;
  public String m_cServer_xrz_contante;
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
  public String pIVA;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public String gActLog;
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
  public double _totgen;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public opert_imp_dati_soggettoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_imp_dati_soggetto",m_Caller);
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
    m_cPhName_tmp_imp_oper = p_ContextObject.GetPhName("tmp_imp_oper");
    if (m_cPhName_tmp_imp_oper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_imp_oper = m_cPhName_tmp_imp_oper+" "+m_Ctx.GetWritePhName("tmp_imp_oper");
    }
    m_cServer_tmp_imp_oper = p_ContextObject.GetServer("tmp_imp_oper");
    m_cPhName_xpe_contante = p_ContextObject.GetPhName("xpe_contante");
    if (m_cPhName_xpe_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xpe_contante = m_cPhName_xpe_contante+" "+m_Ctx.GetWritePhName("xpe_contante");
    }
    m_cServer_xpe_contante = p_ContextObject.GetServer("xpe_contante");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xrz_contante = p_ContextObject.GetPhName("xrz_contante");
    if (m_cPhName_xrz_contante.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xrz_contante = m_cPhName_xrz_contante+" "+m_Ctx.GetWritePhName("xrz_contante");
    }
    m_cServer_xrz_contante = p_ContextObject.GetServer("xrz_contante");
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "opert_imp_dati_soggetto";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pIVA",p_cVarName)) {
      return pIVA;
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
    if (CPLib.eqr("gActLog",p_cVarName)) {
      return gActLog;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pIVA",p_cVarName)) {
      pIVA = value;
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
    if (CPLib.eqr("gActLog",p_cVarName)) {
      gActLog = value;
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
      /* pIVA Char(16) */
      /* gMsgImp Char(120) // Messaggio Trasferimento */
      /* gMsgProc Memo // Log */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gActLog Char(1) // Log Attivo */
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
      /* cRitorno Char(2) */
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
      /* _totgen Numeric(12, 2) */
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
                info.log("Routine opert_imp_dati_soggetto: query on tbcauint returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
                info.log("Routine opert_imp_dati_soggetto: query on tbvalute returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
                info.log("Routine opert_imp_dati_soggetto: query on qbe_personbo_ope returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
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
      /* Exec "Operazioni" Page 2:Page_2 */
      Page_2();
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
    CPResultSet Cursor_scarti_import=null;
    CPResultSet Cursor_scarto_contante=null;
    try {
      /* Import Operazioni */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgImp := 'Inizio Importazione Operazioni ...' // Messaggio Trasferimento */
      gMsgImp = "Inizio Importazione Operazioni ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Legge il file di testo e porta i dati nella tabella */
      /* Cicla sul file transitorio e scrive i record */
      /* _rownum := 0 */
      _rownum = CPLib.Round(0,0);
      /* _errrow := 0 */
      _errrow = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Inizio Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Inizio Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000055status;
      nTry00000055status = m_Sql.GetTransactionStatus();
      String cTry00000055msg;
      cTry00000055msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from scarti_import
        m_cServer = m_Ctx.GetServer("scarti_import");
        m_cPhName = m_Ctx.GetPhName("scarti_import");
        if (Cursor_scarti_import!=null)
          Cursor_scarti_import.Close();
        Cursor_scarti_import = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIVA,"?",0,0,m_cServer, m_oParameters),m_cServer,pIVA)+" "+")"+(m_Ctx.IsSharedTemp("scarti_import")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_scarti_import.Eof())) {
          /* mcOperazioni.AppendBlank() */
          mcOperazioni.AppendBlank();
          /* mcOperazioni.TIPOOPER := scarti_import->TIPOOPER */
          mcOperazioni.row.TIPOOPER = Cursor_scarti_import.GetString("TIPOOPER");
          /* mcOperazioni.CODSTUDIO := scarti_import->CODSTUDIO */
          mcOperazioni.row.CODSTUDIO = Cursor_scarti_import.GetString("CODSTUDIO");
          /* mcOperazioni.CODDIPE := scarti_import->CODDIPE */
          mcOperazioni.row.CODDIPE = Cursor_scarti_import.GetString("CODDIPE");
          /* mcOperazioni.NUMPROG := scarti_import->NUMPROG */
          mcOperazioni.row.NUMPROG = Cursor_scarti_import.GetString("NUMPROG");
          /* mcOperazioni.DATAOPE := scarti_import->DATAOPE */
          mcOperazioni.row.DATAOPE = Cursor_scarti_import.GetString("DATAOPE");
          /* mcOperazioni.FLAGFRAZ := scarti_import->FLAGFRAZ */
          mcOperazioni.row.FLAGFRAZ = Cursor_scarti_import.GetString("FLAGFRAZ");
          /* mcOperazioni.CAUOPER := scarti_import->CAUOPER */
          mcOperazioni.row.CAUOPER = Cursor_scarti_import.GetString("CAUOPER");
          /* mcOperazioni.CONNESCLI := scarti_import->CONNESCLI */
          mcOperazioni.row.CONNESCLI = Cursor_scarti_import.GetString("CONNESCLI");
          /* mcOperazioni.CONNESREAL := scarti_import->CONNESREAL */
          mcOperazioni.row.CONNESREAL = Cursor_scarti_import.GetString("CONNESREAL");
          /* mcOperazioni.CONNESBEN := scarti_import->CONNESBEN */
          mcOperazioni.row.CONNESBEN = Cursor_scarti_import.GetString("CONNESBEN");
          /* mcOperazioni.DATAREG := scarti_import->DATAREG */
          mcOperazioni.row.DATAREG = Cursor_scarti_import.GetString("DATAREG");
          /* mcOperazioni.STATOREG := scarti_import->STATOREG */
          mcOperazioni.row.STATOREG = Cursor_scarti_import.GetString("STATOREG");
          /* mcOperazioni.DATARETT := scarti_import->DATARETT */
          mcOperazioni.row.DATARETT = Cursor_scarti_import.GetString("DATARETT");
          /* mcOperazioni.VALUTA := scarti_import->VALUTA */
          mcOperazioni.row.VALUTA = Cursor_scarti_import.GetString("VALUTA");
          /* mcOperazioni.IMPORTO := scarti_import->IMPORTO */
          mcOperazioni.row.IMPORTO = Cursor_scarti_import.GetDouble("IMPORTO");
          /* mcOperazioni.CONTANTI := scarti_import->CONTANTI */
          mcOperazioni.row.CONTANTI = Cursor_scarti_import.GetDouble("CONTANTI");
          /* mcOperazioni.MEZPAG := scarti_import->MEZPAG */
          mcOperazioni.row.MEZPAG = Cursor_scarti_import.GetString("MEZPAG");
          /* mcOperazioni.PRESTAZ := scarti_import->PRESTAZ */
          mcOperazioni.row.PRESTAZ = Cursor_scarti_import.GetString("PRESTAZ");
          /* mcOperazioni.POSIZ := scarti_import->POSIZ */
          mcOperazioni.row.POSIZ = Cursor_scarti_import.GetString("POSIZ");
          /* mcOperazioni.RAGIO := scarti_import->RAGIO */
          mcOperazioni.row.RAGIO = Cursor_scarti_import.GetString("RAGIO");
          /* mcOperazioni.MODSVOL := scarti_import->MODSVOL */
          mcOperazioni.row.MODSVOL = Cursor_scarti_import.GetString("MODSVOL");
          /* mcOperazioni.AREAGEO := scarti_import->AREAGEO */
          mcOperazioni.row.AREAGEO = Cursor_scarti_import.GetString("AREAGEO");
          /* mcOperazioni.AMMONT := scarti_import->AMMONT */
          mcOperazioni.row.AMMONT = Cursor_scarti_import.GetString("AMMONT");
          /* mcOperazioni.DURAT := scarti_import->DURAT */
          mcOperazioni.row.DURAT = Cursor_scarti_import.GetString("DURAT");
          /* mcOperazioni.TIPO := scarti_import->TIPO */
          mcOperazioni.row.TIPO = Cursor_scarti_import.GetString("TIPO");
          /* mcOperazioni.RRAGIO := scarti_import->RRAGIO */
          mcOperazioni.row.RRAGIO = Cursor_scarti_import.GetDouble("RRAGIO");
          /* mcOperazioni.RCOMP := scarti_import->RCOMP */
          mcOperazioni.row.RCOMP = Cursor_scarti_import.GetDouble("RCOMP");
          /* mcOperazioni.RAREA := scarti_import->RAREA */
          mcOperazioni.row.RAREA = Cursor_scarti_import.GetDouble("RAREA");
          /* mcOperazioni.RIMP := scarti_import->RIMP */
          mcOperazioni.row.RIMP = Cursor_scarti_import.GetDouble("RIMP");
          /* mcOperazioni.RFREQ := scarti_import->RFREQ */
          mcOperazioni.row.RFREQ = Cursor_scarti_import.GetDouble("RFREQ");
          /* mcOperazioni.RTIPO := scarti_import->RTIPO */
          mcOperazioni.row.RTIPO = Cursor_scarti_import.GetDouble("RTIPO");
          /* mcOperazioni.IMPPROG := scarti_import->IMPPROG13 */
          mcOperazioni.row.IMPPROG = Cursor_scarti_import.GetString("IMPPROG13");
          /* mcOperazioni.DESPUNTO := scarti_import->DESPUNTO */
          mcOperazioni.row.DESPUNTO = Cursor_scarti_import.GetString("DESPUNTO");
          /* mcContante.SaveRow() */
          mcContante.SaveRow();
          Cursor_scarti_import.Next();
        }
        m_cConnectivityError = Cursor_scarti_import.ErrorMessage();
        Cursor_scarti_import.Close();
        // * --- End Select
        // * --- Delete from scarti_import
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("scarti_import");
        m_cPhName = m_Ctx.GetPhName("scarti_import");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarti_import",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati_soggetto",266,"0000007A")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIVA,"?",0,0,m_cServer),m_cServer,pIVA)+"";
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
        /* xRif := '' */
        xRif = "";
        for (MemoryCursorRow_tmp_imp_oper rowOperazioni : mcOperazioni._iterable_()) {
          /* cOpePrg := Utilities.GetAutonumber("PRGPROPRG\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpePrg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPROPRG\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
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
            /* Exec "Trova codice cliente" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* cCli1 := _clinew */
            cCli1 = _clinew;
          } // End If
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
            /* Exec "Trova codice cliente" Page 3:Page_3 */
            Page_3();
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
            /* Exec "Trova codice cliente" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* cCli3 := _clinew */
            cCli3 = _clinew;
          } // End If
          /* Verifica il tipo di operazione */
          /* If Empty(cCli2) */
          if (CPLib.Empty(cCli2)) {
            /* _imperr := Utilities.GetAutonumber("PRGIMPOPER\'"+LRTrim(gAzienda)+"'",0,10) */
            _imperr = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPER\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Insert into scarti_import from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("scarti_import");
            m_cPhName = m_Ctx.GetPhName("scarti_import");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarti_import",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati_soggetto",266,"000000A7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A7(m_Ctx,m_oWrInfo);
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
            /* xIDBASE := Utilities.GetAutonumber("PRGPROBASE\'"+LRTrim(gAzienda)+"'",'',10) */
            xIDBASE = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPROBASE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati_soggetto",266,"000000AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000AB(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpePrg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cauaui,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCli2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCli3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cData3,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cValuta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.IMPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONTANTI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DESPUNTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRESTAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N° Pratica "+CPLib.LRTrim(rowOperazioni.NUMPROG),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowOperazioni.TIPOOPER)?_tipointer:rowOperazioni.TIPOOPER),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(rowOperazioni.CODSTUDIO)?CPLib.LRTrim(_cfinter):rowOperazioni.CODSTUDIO),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazioni.IMPPROG),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.AMMONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.DURAT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_finalita,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cauint,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_caurischio,"?",0,0,m_cServer)+", ";
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
            /* _totgen := 0 */
            _totgen = CPLib.Round(0,2);
            // * --- Select from scarto_contante
            m_cServer = m_Ctx.GetServer("scarto_contante");
            m_cPhName = m_Ctx.GetPhName("scarto_contante");
            if (Cursor_scarto_contante!=null)
              Cursor_scarto_contante.Close();
            Cursor_scarto_contante = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IMPPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOperazioni.IMPPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rowOperazioni.IMPPROG)+" "+")"+(m_Ctx.IsSharedTemp("scarto_contante")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_scarto_contante.Eof())) {
              // * --- Insert into xpe_contante from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xpe_contante");
              m_cPhName = m_Ctx.GetPhName("xpe_contante");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xpe_contante",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati_soggetto",266,"000000AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000AE(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(xIDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_scarto_contante.GetString("TIPATT"),"RIT")?Cursor_scarto_contante.GetDouble("TOTBANKNOTE"):0),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_scarto_contante.GetString("TIPATT"),"SOV")?Cursor_scarto_contante.GetDouble("TOTBANKNOTE"):0),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("TIPATT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("TIPOATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("CODICEGLN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetDouble("TAGLIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetDouble("NBANCONOTE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("ABIINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("ABIPROPR"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("GLNALTROSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("GLNALTRASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("CODCLICON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("CODCOMCON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("ATECO_CON"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_scarto_contante.GetDouble("TOTRIGA"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xpe_contante",true);
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
              /* _totgen := _totgen + scarto_contante->TOTRIGA */
              _totgen = CPLib.Round(_totgen+Cursor_scarto_contante.GetDouble("TOTRIGA"),2);
              Cursor_scarto_contante.Next();
            }
            m_cConnectivityError = Cursor_scarto_contante.ErrorMessage();
            Cursor_scarto_contante.Close();
            // * --- End Select
            // * --- Write into xpe_contante from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xpe_contante");
            m_cPhName = m_Ctx.GetPhName("xpe_contante");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xpe_contante",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati_soggetto",266,"000000B0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
            // * --- Delete from scarto_contante
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("scarto_contante");
            m_cPhName = m_Ctx.GetPhName("scarto_contante");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"scarto_contante",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("opert_imp_dati_soggetto",266,"000000B1")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IMPPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOperazioni.IMPPROG,"?",0,0,m_cServer),m_cServer,rowOperazioni.IMPPROG)+"";
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
            /* _rownum := _rownum + 1 */
            _rownum = CPLib.Round(_rownum+1,0);
          } // End If
          /* gMsgImp := 'Sono state importate '+LRTrim(Str(_rownum,10,0))+' Operazioni ...' // Messaggio Trasferimento */
          gMsgImp = "Sono state importate "+CPLib.LRTrim(CPLib.Str(_rownum,10,0))+" Operazioni ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000055status,0)) {
          m_Sql.SetTransactionStatus(nTry00000055status,cTry00000055msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Termine Import File alle ore '+arfn_fdatetime(DateTime()) + NL // Log */
      gMsgProc = gMsgProc+"Termine Import File alle ore "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Terminato Import Operazioni' // Messaggio Trasferimento */
      gMsgImp = "Terminato Import Operazioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If gActLog='S' */
      if (CPLib.eqr(gActLog,"S")) {
        /* Exec Routine arrt_writelog('IMPORT','Prestazioni/O',"Caricamento Nuovo Soggetto",gMsgProc) */
        arrt_writelogR.Make(m_Ctx,this).Run("IMPORT","Prestazioni/O","Caricamento Nuovo Soggetto",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_scarti_import!=null)
          Cursor_scarti_import.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_scarto_contante!=null)
          Cursor_scarto_contante.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
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
        /* _cauint := rowPersonbo.CAUSALE */
        _cauint = CPLib.Round(rowPersonbo.CAUSALE,0);
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
  public String RunAsync(String p_pIVA) {
    pIVA = p_pIVA;
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
  public Forward Run(String p_pIVA) {
    pIVA = p_pIVA;
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
  public static opert_imp_dati_soggettoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_imp_dati_soggettoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pIVA = CPLib.Space(16);
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
    cRitorno = CPLib.Space(2);
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
    _totgen = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gActLog=m_Ctx.GetGlobalString("gActLog");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_personbo_ope,
  public static final String m_cVQRList = ",qbe_personbo_ope,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pIVA"};
  protected static String GetFieldsName_000000A7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
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
    p_cSql = p_cSql+"DESPUNTO,";
    p_cSql = p_cSql+"PRESTAZ,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"TIPOOPER,";
    p_cSql = p_cSql+"CODSTUDIO,";
    p_cSql = p_cSql+"IMPPROG,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"CAUSALE,";
    p_cSql = p_cSql+"RSCOPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTALERIG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xpe_contante",true);
    return p_cSql;
  }
}
