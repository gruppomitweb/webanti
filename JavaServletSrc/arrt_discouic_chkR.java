// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_discouic_chkR implements CallerWithObjs {
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
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_filedatiuic;
  public String m_cServer_filedatiuic;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_tipocr;
  public String w_codcr;
  public String w_flgfrazionate;
  public String gPathApp;
  public String gTipInter;
  public String gIntemediario;
  public String gAzienda;
  public String gDescAzi;
  public String gMsgImp;
  public String gMsgProc;
  public String _tipcentro;
  public String _codcentro;
  public String _settsint;
  public String _ramogrp;
  public String _sotgru;
  public double _appconta;
  public double _totconta;
  public double _conta;
  public String _codcab;
  public String _provin;
  public String _paese;
  public String _testo;
  public String _file;
  public String cdadata;
  public String c_adata;
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String _mesi;
  public String _mese;
  public String _codcab2;
  public String _provin2;
  public String _perpaese;
  public String _percab;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String cProg;
  public String fhand;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public String _stato;
  public String _errore;
  public String _err01;
  public String _err02;
  public String _err03;
  public String _err04;
  public String _err05;
  public String _err06;
  public String _err07;
  public String _err08;
  public String _err09;
  public String _err10;
  public String _err11;
  public double _contaop;
  public String _datini;
  public String _datfin;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _cdataoggi;
  public double _contarow;
  public String _oldmsg;
  public String _sesso;
  public double _cope;
  public MemoryCursor_tbcitta mcCitta;
  public MemoryCursor_tbstati mcStati;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_discouic_chkR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_discouic_chk",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
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
    m_cPhName_filedatiuic = p_ContextObject.GetPhName("filedatiuic");
    if (m_cPhName_filedatiuic.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_filedatiuic = m_cPhName_filedatiuic+" "+m_Ctx.GetWritePhName("filedatiuic");
    }
    m_cServer_filedatiuic = p_ContextObject.GetServer("filedatiuic");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_appconta",p_cVarName)) {
      return _appconta;
    }
    if (CPLib.eqr("_totconta",p_cVarName)) {
      return _totconta;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_contaop",p_cVarName)) {
      return _contaop;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    if (CPLib.eqr("_cope",p_cVarName)) {
      return _cope;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_discouic_chk";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("tipocr",p_cVarName)) {
      return w_tipocr;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      return w_codcr;
    }
    if (CPLib.eqr("flgfrazionate",p_cVarName)) {
      return w_flgfrazionate;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_tipcentro",p_cVarName)) {
      return _tipcentro;
    }
    if (CPLib.eqr("_codcentro",p_cVarName)) {
      return _codcentro;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      return _settsint;
    }
    if (CPLib.eqr("_ramogrp",p_cVarName)) {
      return _ramogrp;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      return _sotgru;
    }
    if (CPLib.eqr("_codcab",p_cVarName)) {
      return _codcab;
    }
    if (CPLib.eqr("_provin",p_cVarName)) {
      return _provin;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return c_adata;
    }
    if (CPLib.eqr("_mesi",p_cVarName)) {
      return _mesi;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("_codcab2",p_cVarName)) {
      return _codcab2;
    }
    if (CPLib.eqr("_provin2",p_cVarName)) {
      return _provin2;
    }
    if (CPLib.eqr("_perpaese",p_cVarName)) {
      return _perpaese;
    }
    if (CPLib.eqr("_percab",p_cVarName)) {
      return _percab;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_stato",p_cVarName)) {
      return _stato;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_err01",p_cVarName)) {
      return _err01;
    }
    if (CPLib.eqr("_err02",p_cVarName)) {
      return _err02;
    }
    if (CPLib.eqr("_err03",p_cVarName)) {
      return _err03;
    }
    if (CPLib.eqr("_err04",p_cVarName)) {
      return _err04;
    }
    if (CPLib.eqr("_err05",p_cVarName)) {
      return _err05;
    }
    if (CPLib.eqr("_err06",p_cVarName)) {
      return _err06;
    }
    if (CPLib.eqr("_err07",p_cVarName)) {
      return _err07;
    }
    if (CPLib.eqr("_err08",p_cVarName)) {
      return _err08;
    }
    if (CPLib.eqr("_err09",p_cVarName)) {
      return _err09;
    }
    if (CPLib.eqr("_err10",p_cVarName)) {
      return _err10;
    }
    if (CPLib.eqr("_err11",p_cVarName)) {
      return _err11;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
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
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
    }
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
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
    if (CPLib.eqr("mcCitta",p_cVarName)) {
      return mcCitta;
    }
    if (CPLib.eqr("mcStati",p_cVarName)) {
      return mcStati;
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
    if (CPLib.eqr("_appconta",p_cVarName)) {
      _appconta = value;
      return;
    }
    if (CPLib.eqr("_totconta",p_cVarName)) {
      _totconta = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
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
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_contaop",p_cVarName)) {
      _contaop = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
    if (CPLib.eqr("_cope",p_cVarName)) {
      _cope = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("tipocr",p_cVarName)) {
      w_tipocr = value;
      return;
    }
    if (CPLib.eqr("codcr",p_cVarName)) {
      w_codcr = value;
      return;
    }
    if (CPLib.eqr("flgfrazionate",p_cVarName)) {
      w_flgfrazionate = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("_tipcentro",p_cVarName)) {
      _tipcentro = value;
      return;
    }
    if (CPLib.eqr("_codcentro",p_cVarName)) {
      _codcentro = value;
      return;
    }
    if (CPLib.eqr("_settsint",p_cVarName)) {
      _settsint = value;
      return;
    }
    if (CPLib.eqr("_ramogrp",p_cVarName)) {
      _ramogrp = value;
      return;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      _sotgru = value;
      return;
    }
    if (CPLib.eqr("_codcab",p_cVarName)) {
      _codcab = value;
      return;
    }
    if (CPLib.eqr("_provin",p_cVarName)) {
      _provin = value;
      return;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      c_adata = value;
      return;
    }
    if (CPLib.eqr("_mesi",p_cVarName)) {
      _mesi = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("_codcab2",p_cVarName)) {
      _codcab2 = value;
      return;
    }
    if (CPLib.eqr("_provin2",p_cVarName)) {
      _provin2 = value;
      return;
    }
    if (CPLib.eqr("_perpaese",p_cVarName)) {
      _perpaese = value;
      return;
    }
    if (CPLib.eqr("_percab",p_cVarName)) {
      _percab = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_stato",p_cVarName)) {
      _stato = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_err01",p_cVarName)) {
      _err01 = value;
      return;
    }
    if (CPLib.eqr("_err02",p_cVarName)) {
      _err02 = value;
      return;
    }
    if (CPLib.eqr("_err03",p_cVarName)) {
      _err03 = value;
      return;
    }
    if (CPLib.eqr("_err04",p_cVarName)) {
      _err04 = value;
      return;
    }
    if (CPLib.eqr("_err05",p_cVarName)) {
      _err05 = value;
      return;
    }
    if (CPLib.eqr("_err06",p_cVarName)) {
      _err06 = value;
      return;
    }
    if (CPLib.eqr("_err07",p_cVarName)) {
      _err07 = value;
      return;
    }
    if (CPLib.eqr("_err08",p_cVarName)) {
      _err08 = value;
      return;
    }
    if (CPLib.eqr("_err09",p_cVarName)) {
      _err09 = value;
      return;
    }
    if (CPLib.eqr("_err10",p_cVarName)) {
      _err10 = value;
      return;
    }
    if (CPLib.eqr("_err11",p_cVarName)) {
      _err11 = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
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
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
      return;
    }
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      _ddatini = value;
      return;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      _ddatfin = value;
      return;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
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
    if (CPLib.eqr("mcCitta",p_cVarName)) {
      mcCitta = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcStati",p_cVarName)) {
      mcStati = (MemoryCursor_tbstati)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_tbstati=null;
    try {
      /* pTipo Char(1) // R = Report (pdf)     X = Excel (Vecchio)    Z = Excel (Nuovo per reimport) */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_tipocr Char(2) // Tipo di intermediario */
      /* w_codcr Char(11) // Codice intermediario */
      /* w_flgfrazionate Char(1) // Considera frazionate */
      /* Variabili Globali */
      /* gPathApp Char(80) // Path Applicazione */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio Import */
      /* _tipcentro Char(2) */
      /* _codcentro Char(11) */
      /* _settsint Char(3) */
      /* _ramogrp Char(3) */
      /* _sotgru Char(3) */
      /* _appconta Numeric(10, 0) */
      /* _totconta Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* _codcab Char(6) */
      /* _provin Char(2) */
      /* _paese Char(3) */
      /* _testo Memo */
      /* _file Char(20) */
      /* cdadata Char(8) */
      /* c_adata Char(8) */
      /* w_dadata Date */
      /* w_adata Date */
      /* _mesi Char(12) */
      /* _mese Char(1) */
      /* _codcab2 Char(6) */
      /* _provin2 Char(2) */
      /* _perpaese Char(3) */
      /* _percab Char(6) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* cProg Char(10) */
      /* fhand Char(10) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _stato Char(3) */
      /* _errore Memo */
      /* _err01 Char(1) */
      /* _err02 Char(1) */
      /* _err03 Char(1) */
      /* _err04 Char(1) */
      /* _err05 Char(1) */
      /* _err06 Char(1) */
      /* _err07 Char(1) */
      /* _err08 Char(1) */
      /* _err09 Char(1) */
      /* _err10 Char(1) */
      /* _err11 Char(1) */
      /* _contaop Numeric(10, 0) */
      /* _datini Char(8) */
      /* _datfin Char(8) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _cdataoggi Char(8) */
      /* _contarow Numeric(15, 0) */
      /* _oldmsg Memo */
      /* _sesso Char(1) */
      /* _cope Numeric(10, 0) */
      /* mcCitta MemoryCursor(tbcitta) */
      /* mcStati MemoryCursor(tbstati) */
      /* Assegna valore a variabili */
      /* _ddatini := w_DaDatOpe */
      _ddatini = w_DaDatOpe;
      /* _ddatfin := w_ADatOpe */
      _ddatfin = w_ADatOpe;
      /* _datini := DateToChar(_ddatini) */
      _datini = CPLib.DateToChar(_ddatini);
      /* _datfin := DateToChar(_ddatfin) */
      _datfin = CPLib.DateToChar(_ddatfin);
      /* w_dadata := w_DaDatOpe */
      w_dadata = w_DaDatOpe;
      /* w_adata := w_ADatOpe */
      w_adata = w_ADatOpe;
      /* cdadata := DateToChar(w_DaDatOpe) */
      cdadata = CPLib.DateToChar(w_DaDatOpe);
      /* c_adata := DateToChar(w_ADatOpe) */
      c_adata = CPLib.DateToChar(w_ADatOpe);
      /* _tipcentro := iif(Empty(w_tipocr),gTipInter,w_tipocr) */
      _tipcentro = (CPLib.Empty(w_tipocr)?gTipInter:w_tipocr);
      /* _codcentro := iif(Empty(w_codcr),gIntemediario,w_codcr) */
      _codcentro = (CPLib.Empty(w_codcr)?gIntemediario:w_codcr);
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
      // * --- Fill memory cursor mcCitta on tbcitta
      mcCitta.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_discouic_chk: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcCitta.AppendWithTrimmedKey(Cursor_tbcitta.GetString("CAB"));
        mcCitta.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcCitta.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcCitta.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcCitta.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcCitta.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcCitta.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcCitta.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcCitta.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcCitta.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcCitta.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcCitta.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcCitta.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcCitta.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcCitta.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcCitta.GoTop();
      // * --- Fill memory cursor mcStati on tbstati
      mcStati.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_discouic_chk: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcStati.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
        mcStati.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcStati.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcStati.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcStati.row.ISO = Cursor_tbstati.GetString("ISO");
        mcStati.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcStati.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcStati.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcStati.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcStati.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcStati.GoTop();
      /* Verifica le operazioni da trasportare */
      /* gMsgProc := 'Ora Inizio Estrazione Dati:'+arfn_fdatetime(DateTime()) + NL // Messaggio Import */
      gMsgProc = "Ora Inizio Estrazione Dati:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000064status;
      nTry00000064status = m_Sql.GetTransactionStatus();
      String cTry00000064msg;
      cTry00000064msg = m_Sql.TransactionErrorMessage();
      try {
        /* Exec "Operazioni" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* If w_flgfrazionate='S' */
        if (CPLib.eqr(w_flgfrazionate,"S")) {
          /* Exec "Frazionate" Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End If
        /* Exec "Operazioni Società Quotate" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
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
      /* If pTipo='R' */
      if (CPLib.eqr(pTipo,"R")) {
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"0000006D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000006D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("0123456789","?",0,0,m_cServer)+", ";
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
        } // End If
        /* gMsgImp := 'Estrazione dati terminata! Procedere con la stampa' // Messaggio Import */
        gMsgImp = "Estrazione dati terminata! Procedere con la stampa";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* ElseIf pTipo='X' or pTipo='Z' */
      } else if (CPLib.eqr(pTipo,"X") || CPLib.eqr(pTipo,"Z")) {
        /* If _conta=0 */
        if (CPLib.eqr(_conta,0)) {
          // * --- Insert into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("0123456789","?",0,0,m_cServer)+", ";
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
        } // End If
        /* gMsgImp := "Estrazione dati terminata! Procedere con l'estrazione del file Excel" // Messaggio Import */
        gMsgImp = "Estrazione dati terminata! Procedere con l'estrazione del file Excel";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* gMsgProc := gMsgProc + 'Record con presenza di anomalie:'+LRTrim(Str(_conta,10,0)) + NL // Messaggio Import */
      gMsgProc = gMsgProc+"Record con presenza di anomalie:"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Estrazione Dati:'+arfn_fdatetime(DateTime()) // Messaggio Import */
      gMsgProc = gMsgProc+"Ora Fine Estrazione Dati:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _conta */
      throw new Stop(_conta);
    } finally {
      try {
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_opeuif=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _datini */
      _cdataoggi = _datini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* _cope := 0 */
      _cope = CPLib.Round(0,0);
      /* While _dataoggi <= _ddatfin */
      while (CPLib.le(_dataoggi,_ddatfin)) {
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" // Messaggio */
          gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni") // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni");
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" */
        _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
        // * --- Select from qbe_opeuif
        SPBridge.HMCaller _h00000083;
        _h00000083 = new SPBridge.HMCaller();
        _h00000083.Set("m_cVQRList",m_cVQRList);
        _h00000083.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
        Cursor_qbe_opeuif = new VQRHolder("qbe_opeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000083,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_opeuif.Eof())) {
          /* _contaop := _contaop + 1 */
          _contaop = CPLib.Round(_contaop+1,0);
          /* _cope := _cope + 1 */
          _cope = CPLib.Round(_cope+1,0);
          /* gMsgImp := 'Elaboro Operazione N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
          gMsgImp = "Elaboro Operazione N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _err01 := '' */
          _err01 = "";
          /* _err02 := '' */
          _err02 = "";
          /* _err03 := '' */
          _err03 = "";
          /* _err04 := '' */
          _err04 = "";
          /* _err05 := '' */
          _err05 = "";
          /* _err06 := '' */
          _err06 = "";
          /* _err07 := '' */
          _err07 = "";
          /* _err08 := '' */
          _err08 = "";
          /* _err09 := '' */
          _err09 = "";
          /* _err10 := '' */
          _err10 = "";
          /* _err11 := '' */
          _err11 = "";
          /* _errore := '' */
          _errore = "";
          /* _perpaese := qbe_opeuif->PAESECLI */
          _perpaese = Cursor_qbe_opeuif.GetString("PAESECLI");
          /* _percab := qbe_opeuif->CABCLI */
          _percab = Cursor_qbe_opeuif.GetString("CABCLI");
          /* _codcab := iif(Empty(qbe_opeuif->CODCAB),qbe_opeuif->CABDIP,qbe_opeuif->CODCAB) */
          _codcab = (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB"))?Cursor_qbe_opeuif.GetString("CABDIP"):Cursor_qbe_opeuif.GetString("CODCAB"));
          /* _settsint := qbe_opeuif->SETTSINT */
          _settsint = Cursor_qbe_opeuif.GetString("SETTSINT");
          /* _sesso := qbe_opeuif->SESSO */
          _sesso = Cursor_qbe_opeuif.GetString("SESSO");
          /* If not(Empty(qbe_opeuif->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("RAPPORTO")))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_qbe_opeuif.GetString("RAPPORTO")))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_opeuif->DATAOPE and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= qbe_opeuif->DATAOPE) */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_opeuif.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_opeuif.GetDate("DATAOPE")))) {
                /* _sesso := '' */
                _sesso = "";
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _percab = Read_Cursor.GetString("CODCAB");
                  _perpaese = Read_Cursor.GetString("PAESE");
                  _settsint = Read_Cursor.GetString("SETTSINT");
                  _sesso = Read_Cursor.GetString("SESSO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_chk returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _percab = "";
                  _perpaese = "";
                  _settsint = "";
                  _sesso = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(_perpaese) */
                if (CPLib.Empty(_perpaese)) {
                  /* _err01 := 'X' */
                  _err01 = "X";
                  /* _errore := _errore + 'Manca Paese Residenza Cliente' + NL */
                  _errore = _errore+"Manca Paese Residenza Cliente"+"\n";
                } else { // Else
                  /* _stato := '' */
                  _stato = "";
                  /* If mcStati.GoToKey(_perpaese) */
                  if (mcStati.GoToKey(_perpaese)) {
                    /* _stato := mcStati.CODSTA */
                    _stato = mcStati.row.CODSTA;
                  } // End If
                  /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                  if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                    /* _errore := _errore + 'Paese Residenza Cliente Errato' + NL */
                    _errore = _errore+"Paese Residenza Cliente Errato"+"\n";
                    /* _err01 := 'X' */
                    _err01 = "X";
                  } // End If
                } // End If
                /* If (Empty(_perpaese) and Empty(_percab)) or (_perpaese='086' and Empty(_percab)) */
                if ((CPLib.Empty(_perpaese) && CPLib.Empty(_percab)) || (CPLib.eqr(_perpaese,"086") && CPLib.Empty(_percab))) {
                  /* _errore := _errore + 'Manca CAB Residenza Cliente' + NL */
                  _errore = _errore+"Manca CAB Residenza Cliente"+"\n";
                  /* _err02 := 'X' */
                  _err02 = "X";
                } // End If
                /* If not(Empty(_percab)) and not(mcCitta.GoToKey(LRTrim(_percab))) */
                if ( ! (CPLib.Empty(_percab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_percab)))) {
                  /* _errore := _errore + 'CAB Residenza Cliente Errato' + NL */
                  _errore = _errore+"CAB Residenza Cliente Errato"+"\n";
                  /* _err02 := 'X' */
                  _err02 = "X";
                } // End If
                /* If Empty(_settsint) */
                if (CPLib.Empty(_settsint)) {
                  /* _errore := _errore + 'Manca Settore Sintetico Cliente' */
                  _errore = _errore+"Manca Settore Sintetico Cliente";
                  /* _err03 := 'X' */
                  _err03 = "X";
                } // End If
                /* If not(Empty(_sesso)) */
                if ( ! (CPLib.Empty(_sesso))) {
                  /* If (_settsint<>'600' and _settsint<>'601') and _perpaese='086' */
                  if ((CPLib.ne(_settsint,"600") && CPLib.ne(_settsint,"601")) && CPLib.eqr(_perpaese,"086")) {
                    /* _errore := _errore + 'Settore Sintetico Cliente Residente in Italia Errato' */
                    _errore = _errore+"Settore Sintetico Cliente Residente in Italia Errato";
                    /* _err03 := 'X' */
                    _err03 = "X";
                  } // End If
                  /* If _settsint<>'711' and _perpaese<>'086' */
                  if (CPLib.ne(_settsint,"711") && CPLib.ne(_perpaese,"086")) {
                    /* _errore := _errore + "Settore Sintetico Cliente Residente all'Estero Errato" */
                    _errore = _errore+"Settore Sintetico Cliente Residente all'Estero Errato";
                    /* _err03 := 'X' */
                    _err03 = "X";
                  } // End If
                } // End If
                /* If not(Empty(_settsint)) and _settsint='999' */
                if ( ! (CPLib.Empty(_settsint)) && CPLib.eqr(_settsint,"999")) {
                  /* _errore := _errore + 'Settore sintetico 999 non valido per SARA' */
                  _errore = _errore+"Settore sintetico 999 non valido per SARA";
                  /* _err04 := 'X' */
                  _err04 = "X";
                } // End If
                /* If Empty(qbe_opeuif->CODDIPE) */
                if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODDIPE"))) {
                  /* _errore := _errore + 'Manca Codice Agenzia' + NL */
                  _errore = _errore+"Manca Codice Agenzia"+"\n";
                  /* _err05 := 'X' */
                  _err05 = "X";
                } // End If
                /* If Empty(_codcab) and not(Empty(qbe_opeuif->CODDIPE)) */
                if (CPLib.Empty(_codcab) &&  ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODDIPE")))) {
                  /* _errore := _errore + 'Manca CAB Dipendenza / Agenzia' + NL */
                  _errore = _errore+"Manca CAB Dipendenza / Agenzia"+"\n";
                  /* _err05 := 'X' */
                  _err05 = "X";
                } // End If
                /* If not(Empty(_codcab)) and not(mcCitta.GoToKey(LRTrim(_codcab))) */
                if ( ! (CPLib.Empty(_codcab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_codcab)))) {
                  /* _errore := _errore + 'CAB Dipendenza / Agenzia Errato' + NL */
                  _errore = _errore+"CAB Dipendenza / Agenzia Errato"+"\n";
                  /* _err05 := 'X' */
                  _err05 = "X";
                } // End If
                /* If At(LRTrim(qbe_opeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                  /* If Empty(qbe_opeuif->C_STA) */
                  if (CPLib.Empty(Cursor_qbe_opeuif.GetString("C_STA"))) {
                    /* _errore := _errore + 'Manca Paese Residenza Controparte' + NL */
                    _errore = _errore+"Manca Paese Residenza Controparte"+"\n";
                    /* _err06 := 'X' */
                    _err06 = "X";
                  } else { // Else
                    /* _stato := '' */
                    _stato = "";
                    /* If mcStati.GoToKey(qbe_opeuif->C_STA) */
                    if (mcStati.GoToKey(Cursor_qbe_opeuif.GetString("C_STA"))) {
                      /* _stato := mcStati.CODSTA */
                      _stato = mcStati.row.CODSTA;
                    } // End If
                    /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                    if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                      /* _errore := _errore + 'Paese Residenza Controparte Errato' + NL */
                      _errore = _errore+"Paese Residenza Controparte Errato"+"\n";
                      /* _err06 := 'X' */
                      _err06 = "X";
                    } // End If
                  } // End If
                  /* If Empty(qbe_opeuif->PAESE) */
                  if (CPLib.Empty(Cursor_qbe_opeuif.GetString("PAESE"))) {
                    /* _errore := _errore + 'Manca Paese Intermediario Controparte' + NL */
                    _errore = _errore+"Manca Paese Intermediario Controparte"+"\n";
                    /* _err08 := 'X' */
                    _err08 = "X";
                  } else { // Else
                    /* If mcStati.GoToKey(qbe_opeuif->PAESE) */
                    if (mcStati.GoToKey(Cursor_qbe_opeuif.GetString("PAESE"))) {
                      /* _stato := mcStati.CODSTA */
                      _stato = mcStati.row.CODSTA;
                    } // End If
                    /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                    if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                      /* _errore := _errore + 'Paese Intermediario Controparte Errato' + NL */
                      _errore = _errore+"Paese Intermediario Controparte Errato"+"\n";
                      /* _err08 := 'X' */
                      _err08 = "X";
                    } // End If
                  } // End If
                } // End If
                /* If not(Empty(qbe_opeuif->C_CAB)) and not(mcCitta.GoToKey(LRTrim(qbe_opeuif->C_CAB))) */
                if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("C_CAB"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("C_CAB"))))) {
                  /* _errore := _errore + 'CAB Controparte Errato' + NL */
                  _errore = _errore+"CAB Controparte Errato"+"\n";
                  /* _err07 := 'X' */
                  _err07 = "X";
                } // End If
                /* If not(Empty(qbe_opeuif->CODCAB2)) and not(mcCitta.GoToKey(LRTrim(qbe_opeuif->CODCAB2))) */
                if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODCAB2"))))) {
                  /* _errore := _errore + 'CAB Intermediario Controparte Errato' + NL */
                  _errore = _errore+"CAB Intermediario Controparte Errato"+"\n";
                  /* _err09 := 'X' */
                  _err09 = "X";
                } // End If
                /* If not(Empty(LRTrim(_errore))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_errore)))) {
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
                  /* If pTipo='Z' */
                  if (CPLib.eqr(pTipo,"Z")) {
                    /* -- inseriemnto per reimport dei errori corretti */
                    // * --- Insert into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"000000DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000DF(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CABCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCITCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCITD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PAESECLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CABDIP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
                  } else { // Else
                    /* -- classico inserimento */
                    // * --- Insert into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"000000E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000000E1(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
                  } // End If
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Else
            /* If Empty(_perpaese) */
            if (CPLib.Empty(_perpaese)) {
              /* _errore := _errore + 'Manca Paese Residenza Cliente' + NL */
              _errore = _errore+"Manca Paese Residenza Cliente"+"\n";
              /* _err01 := 'X' */
              _err01 = "X";
            } else { // Else
              /* _stato := '' */
              _stato = "";
              /* If mcStati.GoToKey(_perpaese) */
              if (mcStati.GoToKey(_perpaese)) {
                /* _stato := mcStati.CODSTA */
                _stato = mcStati.row.CODSTA;
              } // End If
              /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
              if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                /* _errore := _errore + 'Paese Residenza Cliente Errato' + NL */
                _errore = _errore+"Paese Residenza Cliente Errato"+"\n";
                /* _err01 := 'X' */
                _err01 = "X";
              } // End If
            } // End If
            /* If (Empty(_perpaese) and Empty(_percab)) or (_perpaese='086' and Empty(_percab)) */
            if ((CPLib.Empty(_perpaese) && CPLib.Empty(_percab)) || (CPLib.eqr(_perpaese,"086") && CPLib.Empty(_percab))) {
              /* _errore := _errore + 'Manca CAB Residenza Cliente' + NL */
              _errore = _errore+"Manca CAB Residenza Cliente"+"\n";
              /* _err02 := 'X' */
              _err02 = "X";
            } // End If
            /* If not(Empty(_percab)) and not(mcCitta.GoToKey(LRTrim(_percab))) */
            if ( ! (CPLib.Empty(_percab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_percab)))) {
              /* _errore := _errore + 'CAB Residenza Cliente Errato' + NL */
              _errore = _errore+"CAB Residenza Cliente Errato"+"\n";
              /* _err02 := 'X' */
              _err02 = "X";
            } // End If
            /* If Empty(_settsint) */
            if (CPLib.Empty(_settsint)) {
              /* _errore := _errore + 'Manca Settore Sintetico Cliente' */
              _errore = _errore+"Manca Settore Sintetico Cliente";
              /* _err03 := 'X' */
              _err03 = "X";
            } // End If
            /* If not(Empty(_sesso)) */
            if ( ! (CPLib.Empty(_sesso))) {
              /* If _settsint<>'600' and _perpaese='086' */
              if (CPLib.ne(_settsint,"600") && CPLib.eqr(_perpaese,"086")) {
                /* _errore := _errore + 'Settore Sintetico Cliente Residente in Italia Errato' */
                _errore = _errore+"Settore Sintetico Cliente Residente in Italia Errato";
                /* _err03 := 'X' */
                _err03 = "X";
              } // End If
              /* If _settsint<>'711' and _perpaese<>'086' */
              if (CPLib.ne(_settsint,"711") && CPLib.ne(_perpaese,"086")) {
                /* _errore := _errore + "Settore Sintetico Cliente Residente all'Estero Errato" */
                _errore = _errore+"Settore Sintetico Cliente Residente all'Estero Errato";
                /* _err03 := 'X' */
                _err03 = "X";
              } // End If
            } // End If
            /* If not(Empty(_settsint)) and _settsint='999' */
            if ( ! (CPLib.Empty(_settsint)) && CPLib.eqr(_settsint,"999")) {
              /* _errore := _errore + 'Settore sintetico 999 non valido per SARA' */
              _errore = _errore+"Settore sintetico 999 non valido per SARA";
              /* _err04 := 'X' */
              _err04 = "X";
            } // End If
            /* If Empty(qbe_opeuif->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODDIPE"))) {
              /* _errore := _errore + 'Manca Codce Agenzia' + NL */
              _errore = _errore+"Manca Codce Agenzia"+"\n";
              /* _err05 := 'X' */
              _err05 = "X";
            } // End If
            /* If Empty(_codcab) and not(Empty(qbe_opeuif->CODDIPE)) */
            if (CPLib.Empty(_codcab) &&  ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODDIPE")))) {
              /* _errore := _errore + 'Manca CAB Dipendeza / Agenzia' + NL */
              _errore = _errore+"Manca CAB Dipendeza / Agenzia"+"\n";
              /* _err05 := 'X' */
              _err05 = "X";
            } // End If
            /* If not(Empty(_codcab)) and not(mcCitta.GoToKey(LRTrim(_codcab))) */
            if ( ! (CPLib.Empty(_codcab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_codcab)))) {
              /* _errore := _errore + 'CAB Dipendenza / Agenzia Errato' + NL */
              _errore = _errore+"CAB Dipendenza / Agenzia Errato"+"\n";
              /* _err05 := 'X' */
              _err05 = "X";
            } // End If
            /* If Empty(qbe_opeuif->CODVOC) */
            if (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODVOC"))) {
              /* _errore := _errore + 'Manca CAUSALE SINTETICA' + NL */
              _errore = _errore+"Manca CAUSALE SINTETICA"+"\n";
              /* _err10 := 'X' */
              _err10 = "X";
            } // End If
            /* If Empty(qbe_opeuif->SEGNO) */
            if (CPLib.Empty(Cursor_qbe_opeuif.GetString("SEGNO"))) {
              /* _errore := _errore + 'Manca Segno Operazione' + NL */
              _errore = _errore+"Manca Segno Operazione"+"\n";
              /* _err11 := 'X' */
              _err11 = "X";
            } // End If
            /* If At(LRTrim(qbe_opeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* If Empty(qbe_opeuif->C_STA) */
              if (CPLib.Empty(Cursor_qbe_opeuif.GetString("C_STA"))) {
                /* _errore := _errore + 'Manca Paese Residenza Controparte' + NL */
                _errore = _errore+"Manca Paese Residenza Controparte"+"\n";
                /* _err06 := 'X' */
                _err06 = "X";
              } else { // Else
                /* _stato := '' */
                _stato = "";
                /* If mcStati.GoToKey(qbe_opeuif->C_STA) */
                if (mcStati.GoToKey(Cursor_qbe_opeuif.GetString("C_STA"))) {
                  /* _stato := mcStati.CODSTA */
                  _stato = mcStati.row.CODSTA;
                } // End If
                /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                  /* _errore := _errore + 'Paese Residenza Controparte Errato' + NL */
                  _errore = _errore+"Paese Residenza Controparte Errato"+"\n";
                  /* _err06 := 'X' */
                  _err06 = "X";
                } // End If
              } // End If
              /* If Empty(qbe_opeuif->PAESE) */
              if (CPLib.Empty(Cursor_qbe_opeuif.GetString("PAESE"))) {
                /* _errore := _errore + 'Manca Paese Intermediario Controparte' + NL */
                _errore = _errore+"Manca Paese Intermediario Controparte"+"\n";
                /* _err08 := 'X' */
                _err08 = "X";
              } else { // Else
                /* _stato := '' */
                _stato = "";
                /* If mcStati.GoToKey(qbe_opeuif->PAESE) */
                if (mcStati.GoToKey(Cursor_qbe_opeuif.GetString("PAESE"))) {
                  /* _stato := mcStati.CODSTA */
                  _stato = mcStati.row.CODSTA;
                } // End If
                /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                  /* _errore := _errore + 'Paese Intermediario Controparte Errato' + NL */
                  _errore = _errore+"Paese Intermediario Controparte Errato"+"\n";
                  /* _err08 := 'X' */
                  _err08 = "X";
                } // End If
              } // End If
            } // End If
            /* If not(Empty(qbe_opeuif->C_CAB)) and not(mcCitta.GoToKey(LRTrim(qbe_opeuif->C_CAB))) */
            if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("C_CAB"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("C_CAB"))))) {
              /* _errore := _errore + 'CAB Controparte Errato' + NL */
              _errore = _errore+"CAB Controparte Errato"+"\n";
              /* _err07 := 'X' */
              _err07 = "X";
            } // End If
            /* If not(Empty(qbe_opeuif->CODCAB2)) and not(mcCitta.GoToKey(LRTrim(qbe_opeuif->CODCAB2))) */
            if ( ! (CPLib.Empty(Cursor_qbe_opeuif.GetString("CODCAB2"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_opeuif.GetString("CODCAB2"))))) {
              /* _errore := _errore + 'CAB Intermediario Controparte Errato' + NL */
              _errore = _errore+"CAB Intermediario Controparte Errato"+"\n";
              /* _err09 := 'X' */
              _err09 = "X";
            } // End If
            /* If not(Empty(LRTrim(_errore))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_errore)))) {
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* If pTipo='Z' */
              if (CPLib.eqr(pTipo,"Z")) {
                /* -- Inserimento per reimport dei errori corretti */
                // * --- Insert into tmp_stpoperazioni from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"0000012A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000012A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CABCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCITCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCITD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PAESECLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CABDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
              } else { // Else
                /* -- classico inserimento */
                // * --- Insert into tmp_stpoperazioni from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"0000012C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000012C(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("OPE","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_opeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
              } // End If
            } // End If
          } // End If
          Cursor_qbe_opeuif.Next();
        }
        m_cConnectivityError = Cursor_qbe_opeuif.ErrorMessage();
        Cursor_qbe_opeuif.Close();
        // * --- End Select
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
        /* _cdataoggi := DateToChar(_dataoggi) */
        _cdataoggi = CPLib.DateToChar(_dataoggi);
      } // End While
      /* If _cope=0 */
      if (CPLib.eqr(_cope,0)) {
        /* gMsgProc := gMsgProc + NL + 'Non sono presenti dati da elaborare nel file Operazioni' + NL */
        gMsgProc = gMsgProc+"\n"+"Non sono presenti dati da elaborare nel file Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_cope,10,0))+' record del file Operazioni' + NL */
        gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cope,10,0))+" record del file Operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_opeuif!=null)
          Cursor_qbe_opeuif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_frauif=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su fraziobo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _datini */
      _cdataoggi = _datini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* _cope := 0 */
      _cope = CPLib.Round(0,0);
      /* While _dataoggi <= _ddatfin */
      while (CPLib.le(_dataoggi,_ddatfin)) {
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" // Messaggio */
          gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate") // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate");
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" */
        _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
        // * --- Select from qbe_frauif
        SPBridge.HMCaller _h00000141;
        _h00000141 = new SPBridge.HMCaller();
        _h00000141.Set("m_cVQRList",m_cVQRList);
        _h00000141.Set("cdadata",_cdataoggi);
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
        Cursor_qbe_frauif = new VQRHolder("qbe_frauif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000141,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_frauif.Eof())) {
          /* _cope := _cope + 1 */
          _cope = CPLib.Round(_cope+1,0);
          /* _contaop := _contaop + 1 */
          _contaop = CPLib.Round(_contaop+1,0);
          /* gMsgImp := 'Elaboro Operazione N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
          gMsgImp = "Elaboro Operazione N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _err01 := '' */
          _err01 = "";
          /* _err02 := '' */
          _err02 = "";
          /* _err03 := '' */
          _err03 = "";
          /* _err04 := '' */
          _err04 = "";
          /* _err05 := '' */
          _err05 = "";
          /* _err06 := '' */
          _err06 = "";
          /* _err07 := '' */
          _err07 = "";
          /* _err08 := '' */
          _err08 = "";
          /* _err09 := '' */
          _err09 = "";
          /* _err10 := '' */
          _err10 = "";
          /* _err11 := '' */
          _err11 = "";
          /* _errore := '' */
          _errore = "";
          /* _perpaese := qbe_frauif->PAESECLI */
          _perpaese = Cursor_qbe_frauif.GetString("PAESECLI");
          /* _percab := qbe_frauif->CABCLI */
          _percab = Cursor_qbe_frauif.GetString("CABCLI");
          /* _codcab := iif(Empty(qbe_frauif->CODCAB),qbe_frauif->CABDIP,qbe_frauif->CODCAB) */
          _codcab = (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB"))?Cursor_qbe_frauif.GetString("CABDIP"):Cursor_qbe_frauif.GetString("CODCAB"));
          /* _settsint := qbe_frauif->SETTSINT */
          _settsint = Cursor_qbe_frauif.GetString("SETTSINT");
          /* _sesso := qbe_frauif->SESSO */
          _sesso = Cursor_qbe_frauif.GetString("SESSO");
          /* If not(Empty(qbe_frauif->RAPPORTO)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("RAPPORTO")))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_frauif.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_qbe_frauif.GetString("RAPPORTO")))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_frauif->DATAOPE and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= qbe_frauif->DATAOPE)  */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frauif.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frauif.GetDate("DATAOPE")))) {
                /* _sesso := '' */
                _sesso = "";
                // * --- Read from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                m_cSql = "";
                m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")));
                if (m_Ctx.IsSharedTemp("personbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _percab = Read_Cursor.GetString("CODCAB");
                  _perpaese = Read_Cursor.GetString("PAESE");
                  _settsint = Read_Cursor.GetString("SETTSINT");
                  _sesso = Read_Cursor.GetString("SESSO");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_chk returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _percab = "";
                  _perpaese = "";
                  _settsint = "";
                  _sesso = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(_perpaese) */
                if (CPLib.Empty(_perpaese)) {
                  /* _errore := _errore + 'Manca Paese Residenza Cliente' + NL */
                  _errore = _errore+"Manca Paese Residenza Cliente"+"\n";
                  /* _err01 := 'X' */
                  _err01 = "X";
                } else { // Else
                  /* _stato := '' */
                  _stato = "";
                  /* If mcStati.GoToKey(_perpaese) */
                  if (mcStati.GoToKey(_perpaese)) {
                    /* _stato := mcStati.CODSTA */
                    _stato = mcStati.row.CODSTA;
                  } // End If
                  /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                  if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                    /* _errore := _errore + 'Paese Residenza Cliente Errato' + NL */
                    _errore = _errore+"Paese Residenza Cliente Errato"+"\n";
                    /* _err01 := 'X' */
                    _err01 = "X";
                  } // End If
                } // End If
                /* If (Empty(_perpaese) and Empty(_percab)) or (_perpaese='086' and Empty(_percab)) */
                if ((CPLib.Empty(_perpaese) && CPLib.Empty(_percab)) || (CPLib.eqr(_perpaese,"086") && CPLib.Empty(_percab))) {
                  /* _errore := _errore + 'Manca CAB Residenza Cliente' + NL */
                  _errore = _errore+"Manca CAB Residenza Cliente"+"\n";
                  /* _err02 := 'X' */
                  _err02 = "X";
                } // End If
                /* If not(Empty(_percab)) and not(mcCitta.GoToKey(LRTrim(_percab))) */
                if ( ! (CPLib.Empty(_percab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_percab)))) {
                  /* _errore := _errore + 'CAB Residenza Cliente Errato' + NL */
                  _errore = _errore+"CAB Residenza Cliente Errato"+"\n";
                  /* _err02 := 'X' */
                  _err02 = "X";
                } // End If
                /* If Empty(_settsint) */
                if (CPLib.Empty(_settsint)) {
                  /* _errore := _errore +  'Manca Settore Sintetico Cliente' */
                  _errore = _errore+"Manca Settore Sintetico Cliente";
                  /* _err03 := 'X' */
                  _err03 = "X";
                } // End If
                /* If not(Empty(_sesso)) */
                if ( ! (CPLib.Empty(_sesso))) {
                  /* If (_settsint<>'600' and _settsint<>'601') and _perpaese='086' */
                  if ((CPLib.ne(_settsint,"600") && CPLib.ne(_settsint,"601")) && CPLib.eqr(_perpaese,"086")) {
                    /* _errore := _errore + 'Settore Sintetico Cliente Residente in Italia Errato' */
                    _errore = _errore+"Settore Sintetico Cliente Residente in Italia Errato";
                    /* _err03 := 'X' */
                    _err03 = "X";
                  } // End If
                  /* If _settsint<>'711' and _perpaese<>'086' */
                  if (CPLib.ne(_settsint,"711") && CPLib.ne(_perpaese,"086")) {
                    /* _errore := _errore + "Settore Sintetico Cliente Residente all'Estero Errato" */
                    _errore = _errore+"Settore Sintetico Cliente Residente all'Estero Errato";
                    /* _err03 := 'X' */
                    _err03 = "X";
                  } // End If
                } // End If
                /* If not(Empty(_settsint)) and _settsint='999' */
                if ( ! (CPLib.Empty(_settsint)) && CPLib.eqr(_settsint,"999")) {
                  /* _errore := _errore + 'Settore sintetico 999 non valido per SARA' */
                  _errore = _errore+"Settore sintetico 999 non valido per SARA";
                  /* _err04 := 'X' */
                  _err04 = "X";
                } // End If
                /* If Empty(qbe_frauif->CODDIPE) */
                if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODDIPE"))) {
                  /* _errore := _errore + 'Manca Codce Agenzia' + NL */
                  _errore = _errore+"Manca Codce Agenzia"+"\n";
                  /* _err05 := 'X' */
                  _err05 = "X";
                } // End If
                /* If Empty(_codcab) and not(Empty(qbe_frauif->CODDIPE)) */
                if (CPLib.Empty(_codcab) &&  ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CODDIPE")))) {
                  /* _errore := _errore + 'Manca CAB Dipendeza / Agenzia' + NL */
                  _errore = _errore+"Manca CAB Dipendeza / Agenzia"+"\n";
                  /* _err05 := 'X' */
                  _err05 = "X";
                } // End If
                /* If not(Empty(_codcab)) and not(mcCitta.GoToKey(LRTrim(_codcab))) */
                if ( ! (CPLib.Empty(_codcab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_codcab)))) {
                  /* _errore := _errore + 'CAB Dipendenza / Agenzia Errato' + NL */
                  _errore = _errore+"CAB Dipendenza / Agenzia Errato"+"\n";
                  /* _err05 := 'X' */
                  _err05 = "X";
                } // End If
                /* If Empty(qbe_frauif->CODVOC) */
                if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODVOC"))) {
                  /* _errore := _errore + 'Manca CAUSALE SINTETICA' + NL */
                  _errore = _errore+"Manca CAUSALE SINTETICA"+"\n";
                  /* _err10 := 'X' */
                  _err10 = "X";
                } // End If
                /* If Empty(qbe_frauif->SEGNO) */
                if (CPLib.Empty(Cursor_qbe_frauif.GetString("SEGNO"))) {
                  /* _errore := _errore + 'Manca Segno Operazione' + NL */
                  _errore = _errore+"Manca Segno Operazione"+"\n";
                  /* _err11 := 'X' */
                  _err11 = "X";
                } // End If
                /* If At(LRTrim(qbe_frauif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                  /* If Empty(qbe_frauif->C_STA) */
                  if (CPLib.Empty(Cursor_qbe_frauif.GetString("C_STA"))) {
                    /* _errore := _errore + 'Manca Paese Residenza Controparte' + NL */
                    _errore = _errore+"Manca Paese Residenza Controparte"+"\n";
                    /* _err06 := 'X' */
                    _err06 = "X";
                  } else { // Else
                    /* _stato := '' */
                    _stato = "";
                    /* If mcStati.GoToKey(qbe_frauif->C_STA) */
                    if (mcStati.GoToKey(Cursor_qbe_frauif.GetString("C_STA"))) {
                      /* _stato := mcStati.CODSTA */
                      _stato = mcStati.row.CODSTA;
                    } // End If
                    /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                    if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                      /* _errore := _errore + 'Paese Residenza Controparte Errato' + NL */
                      _errore = _errore+"Paese Residenza Controparte Errato"+"\n";
                      /* _err06 := 'X' */
                      _err06 = "X";
                    } // End If
                  } // End If
                  /* If Empty(qbe_frauif->PAESE) */
                  if (CPLib.Empty(Cursor_qbe_frauif.GetString("PAESE"))) {
                    /* _errore := _errore + 'Manca Paese Intermediario Controparte' + NL */
                    _errore = _errore+"Manca Paese Intermediario Controparte"+"\n";
                    /* _err08 := 'X' */
                    _err08 = "X";
                  } else { // Else
                    /* _stato := '' */
                    _stato = "";
                    /* If mcStati.GoToKey(qbe_frauif->PAESE) */
                    if (mcStati.GoToKey(Cursor_qbe_frauif.GetString("PAESE"))) {
                      /* _stato := mcStati.CODSTA */
                      _stato = mcStati.row.CODSTA;
                    } // End If
                    /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                    if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                      /* _errore := _errore + 'Paese Intermediario Controparte Errato' + NL */
                      _errore = _errore+"Paese Intermediario Controparte Errato"+"\n";
                      /* _err08 := 'X' */
                      _err08 = "X";
                    } // End If
                  } // End If
                } // End If
                /* If not(Empty(qbe_frauif->C_CAB)) and not(mcCitta.GoToKey(LRTrim(qbe_frauif->C_CAB))) */
                if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("C_CAB"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_frauif.GetString("C_CAB"))))) {
                  /* _errore := _errore + 'CAB Controparte Errato' + NL */
                  _errore = _errore+"CAB Controparte Errato"+"\n";
                  /* _err07 := 'X' */
                  _err07 = "X";
                } // End If
                /* If not(Empty(qbe_frauif->CODCAB2)) and not(mcCitta.GoToKey(LRTrim(qbe_frauif->CODCAB2))) */
                if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODCAB2"))))) {
                  /* _errore := _errore + 'CAB Intermediario Controparte Errato' + NL */
                  _errore = _errore+"CAB Intermediario Controparte Errato"+"\n";
                  /* _err09 := 'X' */
                  _err09 = "X";
                } // End If
                /* If not(Empty(LRTrim(_errore))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_errore)))) {
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
                  /* If pTipo='Z' */
                  if (CPLib.eqr(pTipo,"Z")) {
                    /* -- Inserimento per reimport dei errori corretti */
                    // * --- Insert into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"000001A4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001A4(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CABCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCITCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCITD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PAESECLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CABDIP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
                  } else { // Else
                    /* -- classico inserimento */
                    // * --- Insert into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"000001A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001A6(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
                  } // End If
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } else { // Else
            /* If Empty(_perpaese) */
            if (CPLib.Empty(_perpaese)) {
              /* _errore := _errore + 'Manca Paese Residenza Cliente' + NL */
              _errore = _errore+"Manca Paese Residenza Cliente"+"\n";
              /* _err01 := 'X' */
              _err01 = "X";
            } else { // Else
              /* _stato := '' */
              _stato = "";
              /* If mcStati.GoToKey(_perpaese) */
              if (mcStati.GoToKey(_perpaese)) {
                /* _stato := mcStati.CODSTA */
                _stato = mcStati.row.CODSTA;
              } // End If
              /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
              if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                /* _errore := _errore + 'Paese Residenza Cliente Errato' + NL */
                _errore = _errore+"Paese Residenza Cliente Errato"+"\n";
                /* _err01 := 'X' */
                _err01 = "X";
              } // End If
            } // End If
            /* If not(Empty(_perpaese)) and _perpaese='030' */
            if ( ! (CPLib.Empty(_perpaese)) && CPLib.eqr(_perpaese,"030")) {
              /* _err01 := 'X' */
              _err01 = "X";
              /* _errore := _errore + 'Paese di residenza non valido' + NL */
              _errore = _errore+"Paese di residenza non valido"+"\n";
            } // End If
            /* If (Empty(_perpaese) and Empty(_percab)) or (_perpaese='086' and Empty(_percab)) */
            if ((CPLib.Empty(_perpaese) && CPLib.Empty(_percab)) || (CPLib.eqr(_perpaese,"086") && CPLib.Empty(_percab))) {
              /* _errore := _errore + 'Manca CAB Residenza Cliente' + NL */
              _errore = _errore+"Manca CAB Residenza Cliente"+"\n";
              /* _err02 := 'X' */
              _err02 = "X";
            } // End If
            /* If not(Empty(_percab)) and not(mcCitta.GoToKey(LRTrim(_percab))) */
            if ( ! (CPLib.Empty(_percab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_percab)))) {
              /* _errore := _errore + 'CAB Residenza Cliente Errato' + NL */
              _errore = _errore+"CAB Residenza Cliente Errato"+"\n";
              /* _err02 := 'X' */
              _err02 = "X";
            } // End If
            /* If Empty(_settsint) */
            if (CPLib.Empty(_settsint)) {
              /* _errore := _errore + 'Manca Settore Sintetico Cliente' */
              _errore = _errore+"Manca Settore Sintetico Cliente";
              /* _err03 := 'X' */
              _err03 = "X";
            } // End If
            /* If not(Empty(_sesso)) */
            if ( ! (CPLib.Empty(_sesso))) {
              /* If _settsint<>'600' and _perpaese='086' */
              if (CPLib.ne(_settsint,"600") && CPLib.eqr(_perpaese,"086")) {
                /* _errore := _errore + 'Settore Sintetico Cliente Residente in Italia Errato' */
                _errore = _errore+"Settore Sintetico Cliente Residente in Italia Errato";
                /* _err03 := 'X' */
                _err03 = "X";
              } // End If
              /* If _settsint<>'711' and _perpaese<>'086' */
              if (CPLib.ne(_settsint,"711") && CPLib.ne(_perpaese,"086")) {
                /* _errore := _errore + "Settore Sintetico Cliente Residente all'Estero Errato" */
                _errore = _errore+"Settore Sintetico Cliente Residente all'Estero Errato";
                /* _err03 := 'X' */
                _err03 = "X";
              } // End If
            } // End If
            /* If not(Empty(_settsint)) and _settsint='999' */
            if ( ! (CPLib.Empty(_settsint)) && CPLib.eqr(_settsint,"999")) {
              /* _errore := _errore + 'Settore sintetico 999 non valido per SARA' */
              _errore = _errore+"Settore sintetico 999 non valido per SARA";
              /* _err04 := 'X' */
              _err04 = "X";
            } // End If
            /* If Empty(qbe_frauif->CODDIPE) */
            if (CPLib.Empty(Cursor_qbe_frauif.GetString("CODDIPE"))) {
              /* _errore := _errore + 'Manca Codce Agenzia' + NL */
              _errore = _errore+"Manca Codce Agenzia"+"\n";
              /* _err05 := 'X' */
              _err05 = "X";
            } // End If
            /* If Empty(_codcab) and not(Empty(qbe_frauif->CODDIPE)) */
            if (CPLib.Empty(_codcab) &&  ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CODDIPE")))) {
              /* _errore := _errore + 'Manca CAB Dipendenza / Agenzia' + NL */
              _errore = _errore+"Manca CAB Dipendenza / Agenzia"+"\n";
              /* _err05 := 'X' */
              _err05 = "X";
            } // End If
            /* If not(Empty(_codcab)) and not(mcCitta.GoToKey(LRTrim(_codcab))) */
            if ( ! (CPLib.Empty(_codcab)) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(_codcab)))) {
              /* _errore := _errore + 'CAB Dipendenza / Agenzia Errato' + NL */
              _errore = _errore+"CAB Dipendenza / Agenzia Errato"+"\n";
              /* _err05 := 'X' */
              _err05 = "X";
            } // End If
            /* If At(LRTrim(qbe_frauif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
            if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
              /* If Empty(qbe_frauif->C_STA) */
              if (CPLib.Empty(Cursor_qbe_frauif.GetString("C_STA"))) {
                /* _errore := _errore + 'Manca Paese Residenza Controparte' + NL */
                _errore = _errore+"Manca Paese Residenza Controparte"+"\n";
                /* _err06 := 'X' */
                _err06 = "X";
              } else { // Else
                /* _stato := '' */
                _stato = "";
                /* If mcStati.GoToKey(qbe_frauif->C_STA) */
                if (mcStati.GoToKey(Cursor_qbe_frauif.GetString("C_STA"))) {
                  /* _stato := mcStati.CODSTA */
                  _stato = mcStati.row.CODSTA;
                } // End If
                /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                  /* _errore := _errore + 'Paese Residenza Controparte Errato' + NL */
                  _errore = _errore+"Paese Residenza Controparte Errato"+"\n";
                  /* _err06 := 'X' */
                  _err06 = "X";
                } // End If
              } // End If
              /* If Empty(qbe_frauif->PAESE) */
              if (CPLib.Empty(Cursor_qbe_frauif.GetString("PAESE"))) {
                /* _errore := _errore + 'Manca Paese Intermediario Controparte' + NL */
                _errore = _errore+"Manca Paese Intermediario Controparte"+"\n";
                /* _err08 := 'X' */
                _err08 = "X";
              } else { // Else
                /* _stato := '' */
                _stato = "";
                /* If mcStati.GoToKey(qbe_frauif->PAESE) */
                if (mcStati.GoToKey(Cursor_qbe_frauif.GetString("PAESE"))) {
                  /* _stato := mcStati.CODSTA */
                  _stato = mcStati.row.CODSTA;
                } // End If
                /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
                if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
                  /* _errore := _errore + 'Paese Intermediario Controparte Errato' + NL */
                  _errore = _errore+"Paese Intermediario Controparte Errato"+"\n";
                  /* _err08 := 'X' */
                  _err08 = "X";
                } // End If
              } // End If
            } // End If
            /* If not(Empty(qbe_frauif->C_CAB)) and not(mcCitta.GoToKey(LRTrim(qbe_frauif->C_CAB))) */
            if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("C_CAB"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_frauif.GetString("C_CAB"))))) {
              /* _errore := _errore + 'CAB Controparte Errato' + NL */
              _errore = _errore+"CAB Controparte Errato"+"\n";
              /* _err07 := 'X' */
              _err07 = "X";
            } // End If
            /* If not(Empty(qbe_frauif->CODCAB2)) and not(mcCitta.GoToKey(LRTrim(qbe_frauif->CODCAB2))) */
            if ( ! (CPLib.Empty(Cursor_qbe_frauif.GetString("CODCAB2"))) &&  ! (mcCitta.GoToKey(CPLib.LRTrim(Cursor_qbe_frauif.GetString("CODCAB2"))))) {
              /* _errore := _errore + 'CAB Intermediario Controparte Errato' + NL */
              _errore = _errore+"CAB Intermediario Controparte Errato"+"\n";
              /* _err09 := 'X' */
              _err09 = "X";
            } // End If
            /* If not(Empty(LRTrim(_errore))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_errore)))) {
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* If pTipo='Z' */
              if (CPLib.eqr(pTipo,"Z")) {
                /* -- Inserimento per reimport dei errori corretti */
                // * --- Insert into tmp_stpoperazioni from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"000001EC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001EC(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CABCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCITCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCITD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PAESECLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CABDIP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
              } else { // Else
                /* -- classico inserimento */
                // * --- Insert into tmp_stpoperazioni from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"000001EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001EE(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDate("DATARETT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("FRZ","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_frauif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
              } // End If
            } // End If
          } // End If
          Cursor_qbe_frauif.Next();
        }
        m_cConnectivityError = Cursor_qbe_frauif.ErrorMessage();
        Cursor_qbe_frauif.Close();
        // * --- End Select
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
        /* _cdataoggi := DateToChar(_dataoggi) */
        _cdataoggi = CPLib.DateToChar(_dataoggi);
      } // End While
      /* If _cope=0 */
      if (CPLib.eqr(_cope,0)) {
        /* gMsgProc := gMsgProc + NL + 'Non sono presenti dati da elaborare nel file Frazionate' + NL */
        gMsgProc = gMsgProc+"\n"+"Non sono presenti dati da elaborare nel file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_cope,10,0))+' record del file Frazionate' + NL */
        gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cope,10,0))+" record del file Frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Frazionate' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_frauif!=null)
          Cursor_qbe_frauif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_kpeuif=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla su operazbo e seleziona i record nel range definito */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Società Quotate' +NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Società Quotate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _cope := 0 */
      _cope = CPLib.Round(0,0);
      // * --- Select from qbe_kpeuif
      SPBridge.HMCaller _h000001F8;
      _h000001F8 = new SPBridge.HMCaller();
      _h000001F8.Set("m_cVQRList",m_cVQRList);
      _h000001F8.Set("cdadata",_datini);
      _h000001F8.Set("c_adata",_datfin);
      if (Cursor_qbe_kpeuif!=null)
        Cursor_qbe_kpeuif.Close();
      Cursor_qbe_kpeuif = new VQRHolder("qbe_kpeuif",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001F8,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_kpeuif.Eof())) {
        /* _contaop := _contaop + 1 */
        _contaop = CPLib.Round(_contaop+1,0);
        /* _cope := _cope + 1 */
        _cope = CPLib.Round(_cope+1,0);
        /* gMsgImp := 'Elaboro Operazione N. '+ LRTrim(Str(_contaop,10,0)) // Messaggio Import */
        gMsgImp = "Elaboro Operazione N. "+CPLib.LRTrim(CPLib.Str(_contaop,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _err01 := '' */
        _err01 = "";
        /* _err02 := '' */
        _err02 = "";
        /* _err03 := '' */
        _err03 = "";
        /* _err04 := '' */
        _err04 = "";
        /* _err05 := '' */
        _err05 = "";
        /* _err06 := '' */
        _err06 = "";
        /* _err07 := '' */
        _err07 = "";
        /* _err08 := '' */
        _err08 = "";
        /* _err09 := '' */
        _err09 = "";
        /* _err10 := '' */
        _err10 = "";
        /* _err11 := '' */
        _err11 = "";
        /* _errore := '' */
        _errore = "";
        /* _perpaese := qbe_kpeuif->PAESECLI */
        _perpaese = Cursor_qbe_kpeuif.GetString("PAESECLI");
        /* _percab := qbe_kpeuif->CABCLI */
        _percab = Cursor_qbe_kpeuif.GetString("CABCLI");
        /* _codcab := iif(Empty(qbe_kpeuif->CODCAB),qbe_kpeuif->CABDIP,qbe_kpeuif->CODCAB) */
        _codcab = (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODCAB"))?Cursor_qbe_kpeuif.GetString("CABDIP"):Cursor_qbe_kpeuif.GetString("CODCAB"));
        /* _settsint := qbe_kpeuif->SETTSINT */
        _settsint = Cursor_qbe_kpeuif.GetString("SETTSINT");
        /* _sesso := qbe_kpeuif->SESSO */
        _sesso = Cursor_qbe_kpeuif.GetString("SESSO");
        /* If not(Empty(qbe_kpeuif->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_kpeuif.GetString("RAPPORTO")))) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("RAPPORTO")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("RAPPORTO")))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If intestbo->DATAINI <= qbe_kpeuif->DATAOPE and (Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= qbe_kpeuif->DATAOPE) */
            if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_kpeuif.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_kpeuif.GetDate("DATAOPE")))) {
              /* _sesso := '' */
              _sesso = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_intestbo.GetString("CODINTER")));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SETTSINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _percab = Read_Cursor.GetString("CODCAB");
                _perpaese = Read_Cursor.GetString("PAESE");
                _settsint = Read_Cursor.GetString("SETTSINT");
                _sesso = Read_Cursor.GetString("SESSO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_discouic_chk returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _percab = "";
                _perpaese = "";
                _settsint = "";
                _sesso = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_perpaese) */
              if (CPLib.Empty(_perpaese)) {
                /* _errore := _errore + 'Manca Paese Residenza Cliente' + NL */
                _errore = _errore+"Manca Paese Residenza Cliente"+"\n";
                /* _err01 := 'X' */
                _err01 = "X";
              } else { // Else
                /* _stato := '' */
                _stato = "";
                /* If mcStati.GoToKey(_perpaese) */
                if (mcStati.GoToKey(_perpaese)) {
                  /* _stato := mcStati.CODSTA */
                  _stato = mcStati.row.CODSTA;
                } // End If
                /* If Empty(_stato) */
                if (CPLib.Empty(_stato)) {
                  /* _errore := _errore + 'Paese Residenza Cliente Errato' + NL */
                  _errore = _errore+"Paese Residenza Cliente Errato"+"\n";
                  /* _err01 := 'X' */
                  _err01 = "X";
                } // End If
              } // End If
              /* If (Empty(_perpaese) and Empty(_percab)) or (_perpaese='086' and Empty(_percab)) */
              if ((CPLib.Empty(_perpaese) && CPLib.Empty(_percab)) || (CPLib.eqr(_perpaese,"086") && CPLib.Empty(_percab))) {
                /* _errore := _errore + 'Manca CAB Residenza Cliente' + NL */
                _errore = _errore+"Manca CAB Residenza Cliente"+"\n";
                /* _err02 := 'X' */
                _err02 = "X";
              } // End If
              /* If Empty(_settsint) */
              if (CPLib.Empty(_settsint)) {
                /* _errore := _errore + 'Manca Settore Sintetico Cliente' */
                _errore = _errore+"Manca Settore Sintetico Cliente";
                /* _err03 := 'X' */
                _err03 = "X";
              } // End If
              /* If not(Empty(_sesso)) */
              if ( ! (CPLib.Empty(_sesso))) {
                /* If (_settsint<>'600' or _settsint<>'601') and _perpaese='086' */
                if ((CPLib.ne(_settsint,"600") || CPLib.ne(_settsint,"601")) && CPLib.eqr(_perpaese,"086")) {
                  /* _errore := _errore + 'Settore Sintetico Cliente Residente in Italia Errato' */
                  _errore = _errore+"Settore Sintetico Cliente Residente in Italia Errato";
                  /* _err03 := 'X' */
                  _err03 = "X";
                } // End If
                /* If _settsint<>'711' and _perpaese<>'086' */
                if (CPLib.ne(_settsint,"711") && CPLib.ne(_perpaese,"086")) {
                  /* _errore := _errore + "Settore Sintetico Cliente Residente all'Estero Errato" */
                  _errore = _errore+"Settore Sintetico Cliente Residente all'Estero Errato";
                  /* _err03 := 'X' */
                  _err03 = "X";
                } // End If
              } // End If
              /* If not(Empty(_settsint)) and _settsint='999' */
              if ( ! (CPLib.Empty(_settsint)) && CPLib.eqr(_settsint,"999")) {
                /* _errore := _errore +  'Settore sintetico 999 non valido per SARA' */
                _errore = _errore+"Settore sintetico 999 non valido per SARA";
                /* _err04 := 'X' */
                _err04 = "X";
              } // End If
              /* If Empty(qbe_kpeuif->CODDIPE) */
              if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODDIPE"))) {
                /* _errore := _errore + 'Manca Codce Agenzia' + NL */
                _errore = _errore+"Manca Codce Agenzia"+"\n";
                /* _err05 := 'X' */
                _err05 = "X";
              } // End If
              /* If Empty(_codcab) and not(Empty(qbe_kpeuif->CODDIPE)) */
              if (CPLib.Empty(_codcab) &&  ! (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODDIPE")))) {
                /* _errore := _errore + 'Manca CAB Dipendeza / Agenzia' + NL */
                _errore = _errore+"Manca CAB Dipendeza / Agenzia"+"\n";
                /* _err05 := 'X' */
                _err05 = "X";
              } // End If
              /* If Empty(qbe_kpeuif->CODVOC) */
              if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODVOC"))) {
                /* _errore := _errore + 'Manca CAUSALE SINTETICA' + NL */
                _errore = _errore+"Manca CAUSALE SINTETICA"+"\n";
                /* _err10 := 'X' */
                _err10 = "X";
              } // End If
              /* If Empty(qbe_kpeuif->SEGNO) */
              if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("SEGNO"))) {
                /* _errore := _errore + 'Manca Segno Operazione' + NL */
                _errore = _errore+"Manca Segno Operazione"+"\n";
                /* _err11 := 'X' */
                _err11 = "X";
              } // End If
              /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
              if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
                /* If Empty(qbe_kpeuif->C_STA) */
                if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("C_STA"))) {
                  /* _errore := _errore + 'Manca Paese Residenza Controparte' + NL */
                  _errore = _errore+"Manca Paese Residenza Controparte"+"\n";
                  /* _err06 := 'X' */
                  _err06 = "X";
                } else { // Else
                  /* _stato := '' */
                  _stato = "";
                  /* If mcStati.GoToKey(qbe_kpeuif->C_STA) */
                  if (mcStati.GoToKey(Cursor_qbe_kpeuif.GetString("C_STA"))) {
                    /* _stato := mcStati.CODSTA */
                    _stato = mcStati.row.CODSTA;
                  } // End If
                  /* If Empty(_stato) */
                  if (CPLib.Empty(_stato)) {
                    /* _errore := _errore + 'Paese Residenza Controparte Errato' + NL */
                    _errore = _errore+"Paese Residenza Controparte Errato"+"\n";
                    /* _err06 := 'X' */
                    _err06 = "X";
                  } // End If
                } // End If
                /* If Empty(qbe_kpeuif->PAESE) */
                if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("PAESE"))) {
                  /* _errore := _errore + 'Manca Paese Intermediario Controparte' + NL */
                  _errore = _errore+"Manca Paese Intermediario Controparte"+"\n";
                  /* _err08 := 'X' */
                  _err08 = "X";
                } else { // Else
                  /* _stato := '' */
                  _stato = "";
                  /* If mcStati.GoToKey(qbe_kpeuif->PAESE) */
                  if (mcStati.GoToKey(Cursor_qbe_kpeuif.GetString("PAESE"))) {
                    /* _stato := mcStati.CODSTA */
                    _stato = mcStati.row.CODSTA;
                  } // End If
                  /* If Empty(_stato) */
                  if (CPLib.Empty(_stato)) {
                    /* _errore := _errore + 'Paese Intermediario Controparte Errato' + NL */
                    _errore = _errore+"Paese Intermediario Controparte Errato"+"\n";
                    /* _err08 := 'X' */
                    _err08 = "X";
                  } // End If
                } // End If
              } // End If
              /* If not(Empty(LRTrim(_errore))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_errore)))) {
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
                /* If pTipo='Z' */
                if (CPLib.eqr(pTipo,"Z")) {
                  /* -- Inserimento per reimport dei errori corretti */
                  // * --- Insert into tmp_stpoperazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"0000024F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000024F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CABCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCITCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCITD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESECLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CABDIP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
                } else { // Else
                  /* -- classico inserimento */
                  // * --- Insert into tmp_stpoperazioni from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                  m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"00000251")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000251(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
                } // End If
              } // End If
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } else { // Else
          /* If Empty(_perpaese) */
          if (CPLib.Empty(_perpaese)) {
            /* _errore := _errore + 'Manca Paese Residenza Cliente' + NL */
            _errore = _errore+"Manca Paese Residenza Cliente"+"\n";
            /* _err01 := 'X' */
            _err01 = "X";
          } else { // Else
            /* _stato := '' */
            _stato = "";
            /* If mcStati.GoToKey(_perpaese) */
            if (mcStati.GoToKey(_perpaese)) {
              /* _stato := mcStati.CODSTA */
              _stato = mcStati.row.CODSTA;
            } // End If
            /* If Empty(_stato) or (not(Empty(_stato)) and _stato='030') */
            if (CPLib.Empty(_stato) || ( ! (CPLib.Empty(_stato)) && CPLib.eqr(_stato,"030"))) {
              /* _errore := _errore + 'Paese Residenza Cliente Errato' + NL */
              _errore = _errore+"Paese Residenza Cliente Errato"+"\n";
              /* _err01 := 'X' */
              _err01 = "X";
            } // End If
          } // End If
          /* If not(Empty(_perpaese)) and _perpaese='030' */
          if ( ! (CPLib.Empty(_perpaese)) && CPLib.eqr(_perpaese,"030")) {
            /* _err01 := 'X' */
            _err01 = "X";
            /* _errore := _errore + 'Paese di residenza non valido (030)' + NL */
            _errore = _errore+"Paese di residenza non valido (030)"+"\n";
          } // End If
          /* If (Empty(_perpaese) and Empty(_percab)) or (_perpaese='086' and Empty(_percab)) */
          if ((CPLib.Empty(_perpaese) && CPLib.Empty(_percab)) || (CPLib.eqr(_perpaese,"086") && CPLib.Empty(_percab))) {
            /* _errore := _errore + 'Manca CAB Residenza Cliente' + NL */
            _errore = _errore+"Manca CAB Residenza Cliente"+"\n";
            /* _err02 := 'X' */
            _err02 = "X";
          } // End If
          /* If Empty(_settsint) */
          if (CPLib.Empty(_settsint)) {
            /* _errore := _errore + 'Manca Settore Sintetico Cliente' */
            _errore = _errore+"Manca Settore Sintetico Cliente";
            /* _err03 := 'X' */
            _err03 = "X";
          } // End If
          /* If not(Empty(_sesso)) */
          if ( ! (CPLib.Empty(_sesso))) {
            /* If _settsint<>'600' and _perpaese='086' */
            if (CPLib.ne(_settsint,"600") && CPLib.eqr(_perpaese,"086")) {
              /* _errore := _errore + 'Settore Sintetico Cliente Residente in Italia Errato' */
              _errore = _errore+"Settore Sintetico Cliente Residente in Italia Errato";
              /* _err03 := 'X' */
              _err03 = "X";
            } // End If
            /* If _settsint<>'711' and _perpaese<>'086' */
            if (CPLib.ne(_settsint,"711") && CPLib.ne(_perpaese,"086")) {
              /* _errore := _errore + "Settore Sintetico Cliente Residente all'Estero Errato" */
              _errore = _errore+"Settore Sintetico Cliente Residente all'Estero Errato";
              /* _err03 := 'X' */
              _err03 = "X";
            } // End If
          } // End If
          /* If not(Empty(_settsint)) and _settsint='999' */
          if ( ! (CPLib.Empty(_settsint)) && CPLib.eqr(_settsint,"999")) {
            /* _errore := _errore + 'Settore sintetico 999 non valido per SARA' */
            _errore = _errore+"Settore sintetico 999 non valido per SARA";
            /* _err04 := 'X' */
            _err04 = "X";
          } // End If
          /* If Empty(qbe_kpeuif->CODDIPE) */
          if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODDIPE"))) {
            /* _errore := _errore + 'Manca Codce Agenzia' + NL */
            _errore = _errore+"Manca Codce Agenzia"+"\n";
            /* _err05 := 'X' */
            _err05 = "X";
          } // End If
          /* If Empty(_codcab) and not(Empty(qbe_kpeuif->CODDIPE)) */
          if (CPLib.Empty(_codcab) &&  ! (CPLib.Empty(Cursor_qbe_kpeuif.GetString("CODDIPE")))) {
            /* _errore := _errore + 'Manca CAB Dipendenza / Agenzia' + NL */
            _errore = _errore+"Manca CAB Dipendenza / Agenzia"+"\n";
            /* _err05 := 'X' */
            _err05 = "X";
          } // End If
          /* If At(LRTrim(qbe_kpeuif->CODVOC),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') > 0 */
          if (CPLib.gt(CPLib.At(CPLib.LRTrim(Cursor_qbe_kpeuif.GetString("CODVOC")),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
            /* If Empty(qbe_kpeuif->C_STA) */
            if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("C_STA"))) {
              /* _errore := _errore + 'Manca Paese Residenza Controparte' + NL */
              _errore = _errore+"Manca Paese Residenza Controparte"+"\n";
              /* _err06 := 'X' */
              _err06 = "X";
            } else { // Else
              /* _stato := '' */
              _stato = "";
              /* If mcStati.GoToKey(qbe_kpeuif->C_STA) */
              if (mcStati.GoToKey(Cursor_qbe_kpeuif.GetString("C_STA"))) {
                /* _stato := mcStati.CODSTA */
                _stato = mcStati.row.CODSTA;
              } // End If
              /* If Empty(_stato) */
              if (CPLib.Empty(_stato)) {
                /* _errore := _errore + 'Paese Residenza Controparte Errato' + NL */
                _errore = _errore+"Paese Residenza Controparte Errato"+"\n";
                /* _err06 := 'X' */
                _err06 = "X";
              } // End If
            } // End If
            /* If Empty(qbe_kpeuif->PAESE) */
            if (CPLib.Empty(Cursor_qbe_kpeuif.GetString("PAESE"))) {
              /* _errore := _errore + 'Manca Paese Intermediario Controparte' + NL */
              _errore = _errore+"Manca Paese Intermediario Controparte"+"\n";
              /* _err08 := 'X' */
              _err08 = "X";
            } else { // Else
              /* _stato := '' */
              _stato = "";
              /* If mcStati.GoToKey(qbe_kpeuif->PAESE) */
              if (mcStati.GoToKey(Cursor_qbe_kpeuif.GetString("PAESE"))) {
                /* _stato := mcStati.CODSTA */
                _stato = mcStati.row.CODSTA;
              } // End If
              /* If Empty(_stato) */
              if (CPLib.Empty(_stato)) {
                /* _errore := _errore + 'Paese Intermediario Controparte Errato' + NL */
                _errore = _errore+"Paese Intermediario Controparte Errato"+"\n";
                /* _err08 := 'X' */
                _err08 = "X";
              } // End If
            } // End If
          } // End If
          /* If not(Empty(LRTrim(_errore))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_errore)))) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* If pTipo='Z' */
            if (CPLib.eqr(pTipo,"Z")) {
              /* -- Inserimento per reimport dei errori corretti */
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"0000028B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000028B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CABCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCITCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCITD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESECLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CABDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
            } else { // Else
              /* -- classico inserimento */
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_discouic_chk",168,"0000028D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000028D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("KPE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTCONT")/100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetDouble("TOTLIRE")/100,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_kpeuif.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
            } // End If
          } // End If
        } // End If
        Cursor_qbe_kpeuif.Next();
      }
      m_cConnectivityError = Cursor_qbe_kpeuif.ErrorMessage();
      Cursor_qbe_kpeuif.Close();
      // * --- End Select
      /* If _cope=0 */
      if (CPLib.eqr(_cope,0)) {
        /* gMsgProc := gMsgProc + NL + 'Non sono presenti dati da elaborare nel file Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"\n"+"Non sono presenti dati da elaborare nel file Operazioni Società Quotate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + NL + 'Sono stati elaborati '+LRTrim(Str(_cope,10,0))+' record del file Operazioni Società Quotate' + NL */
        gMsgProc = gMsgProc+"\n"+"Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(_cope,10,0))+" record del file Operazioni Società Quotate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file Operazioni Società Quotate' +NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file Operazioni Società Quotate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_kpeuif!=null)
          Cursor_qbe_kpeuif.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_tipocr,String p_w_codcr,String p_w_flgfrazionate) {
    pTipo = p_pTipo;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_tipocr = p_w_tipocr;
    w_codcr = p_w_codcr;
    w_flgfrazionate = p_w_flgfrazionate;
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
  public double Run(String p_pTipo,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_tipocr,String p_w_codcr,String p_w_flgfrazionate) {
    pTipo = p_pTipo;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_tipocr = p_w_tipocr;
    w_codcr = p_w_codcr;
    w_flgfrazionate = p_w_flgfrazionate;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_discouic_chkR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_discouic_chkR(p_Ctx, p_Caller);
  }
  public static arrt_discouic_chkR Make(CPContext p_Ctx) {
    return new arrt_discouic_chkR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_tipocr = CPLib.Space(2);
    w_codcr = CPLib.Space(11);
    w_flgfrazionate = CPLib.Space(1);
    _tipcentro = CPLib.Space(2);
    _codcentro = CPLib.Space(11);
    _settsint = CPLib.Space(3);
    _ramogrp = CPLib.Space(3);
    _sotgru = CPLib.Space(3);
    _appconta = 0;
    _totconta = 0;
    _conta = 0;
    _codcab = CPLib.Space(6);
    _provin = CPLib.Space(2);
    _paese = CPLib.Space(3);
    _testo = "";
    _file = CPLib.Space(20);
    cdadata = CPLib.Space(8);
    c_adata = CPLib.Space(8);
    w_dadata = CPLib.NullDate();
    w_adata = CPLib.NullDate();
    _mesi = CPLib.Space(12);
    _mese = CPLib.Space(1);
    _codcab2 = CPLib.Space(6);
    _provin2 = CPLib.Space(2);
    _perpaese = CPLib.Space(3);
    _percab = CPLib.Space(6);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    cProg = CPLib.Space(10);
    fhand = CPLib.Space(10);
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    _stato = CPLib.Space(3);
    _errore = "";
    _err01 = CPLib.Space(1);
    _err02 = CPLib.Space(1);
    _err03 = CPLib.Space(1);
    _err04 = CPLib.Space(1);
    _err05 = CPLib.Space(1);
    _err06 = CPLib.Space(1);
    _err07 = CPLib.Space(1);
    _err08 = CPLib.Space(1);
    _err09 = CPLib.Space(1);
    _err10 = CPLib.Space(1);
    _err11 = CPLib.Space(1);
    _contaop = 0;
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _cdataoggi = CPLib.Space(8);
    _contarow = 0;
    _oldmsg = "";
    _sesso = CPLib.Space(1);
    _cope = 0;
    mcCitta = new MemoryCursor_tbcitta();
    mcStati = new MemoryCursor_tbstati();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_opeuif,qbe_frauif,qbe_kpeuif,
  public static final String m_cVQRList = ",qbe_opeuif,qbe_frauif,qbe_kpeuif,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_discouic_chk,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_discouic_chk,";
  public static String[] m_cRunParameterNames={"pTipo","w_DaDatOpe","w_ADatOpe","w_tipocr","w_codcr","w_flgfrazionate"};
  protected static String GetFieldsName_0000006D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGCLI,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"ERR05,";
    p_cSql = p_cSql+"ERR06,";
    p_cSql = p_cSql+"ERR07,";
    p_cSql = p_cSql+"ERR08,";
    p_cSql = p_cSql+"ERR09,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGCLI,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"ERR05,";
    p_cSql = p_cSql+"ERR06,";
    p_cSql = p_cSql+"ERR07,";
    p_cSql = p_cSql+"ERR08,";
    p_cSql = p_cSql+"ERR09,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGCLI,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"ERR05,";
    p_cSql = p_cSql+"ERR06,";
    p_cSql = p_cSql+"ERR07,";
    p_cSql = p_cSql+"ERR08,";
    p_cSql = p_cSql+"ERR09,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGCLI,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"ERR05,";
    p_cSql = p_cSql+"ERR06,";
    p_cSql = p_cSql+"ERR07,";
    p_cSql = p_cSql+"ERR08,";
    p_cSql = p_cSql+"ERR09,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGCLI,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000251(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"ERR05,";
    p_cSql = p_cSql+"ERR06,";
    p_cSql = p_cSql+"ERR07,";
    p_cSql = p_cSql+"ERR08,";
    p_cSql = p_cSql+"ERR09,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CABICP,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAESECP,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGCLI,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SETTSINTAGG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESCOL,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+"ERR02,";
    p_cSql = p_cSql+"ERR03,";
    p_cSql = p_cSql+"ERR04,";
    p_cSql = p_cSql+"ERR05,";
    p_cSql = p_cSql+"ERR06,";
    p_cSql = p_cSql+"ERR07,";
    p_cSql = p_cSql+"ERR08,";
    p_cSql = p_cSql+"ERR09,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TXTNOTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
}
