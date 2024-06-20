// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_com_oggettiveR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tmp_appo_co1;
  public String m_cServer_tmp_appo_co1;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tmp_esitosaldi;
  public String m_cServer_tmp_esitosaldi;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
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
  public double pAnno;
  public String pMese;
  public double pLimite;
  public String pI3I4;
  public String gAzienda;
  public String gPathDoc;
  public String gMsgProc;
  public String gMsgImp;
  public String cRitorno;
  public double nTotale;
  public String fhand;
  public java.sql.Date _datini;
  public java.sql.Date _datfin;
  public double _limcon;
  public String _nomefile;
  public String _testo;
  public String _bpentseg;
  public String _bpcodpat;
  public String _abiinter;
  public String _cdatfin;
  public double _contaope;
  public double _id_operazione;
  public double _contasogg;
  public String _operazioni;
  public String _soggetti;
  public double _prgsogg;
  public MemoryCursor_mcoperazionico_mcrdef mcOperazioni;
  public MemoryCursor_mcsoggettico_mcrdef mcSoggetti;
  public MemoryCursor_mcrowserrori_mcrdef mcErrori;
  public MemoryCursor_mcconnes_mcrdef mcCFOperazione;
  public String _tiposogg;
  public String _connes;
  public String _codsta;
  public String _cabnas;
  public String _sesso;
  public String _abicab;
  public double _found;
  public String _tipo;
  public String _numprog;
  public String _totlire;
  public String _totcont;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String _outfile;
  public double _cfexist;
  public double _titexec;
  public String _abitrim;
  public String _cabtrim;
  public String cReturn;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_com_oggettiveR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_com_oggettive",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_appo_co1")) {
      m_cPhName_tmp_appo_co1 = p_ContextObject.GetPhName("tmp_appo_co1");
      if (m_cPhName_tmp_appo_co1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_appo_co1 = m_cPhName_tmp_appo_co1+" "+m_Ctx.GetWritePhName("tmp_appo_co1");
      }
      m_cServer_tmp_appo_co1 = p_ContextObject.GetServer("tmp_appo_co1");
    }
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
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
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosaldi")) {
      m_cPhName_tmp_esitosaldi = p_ContextObject.GetPhName("tmp_esitosaldi");
      if (m_cPhName_tmp_esitosaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_esitosaldi = m_cPhName_tmp_esitosaldi+" "+m_Ctx.GetWritePhName("tmp_esitosaldi");
      }
      m_cServer_tmp_esitosaldi = p_ContextObject.GetServer("tmp_esitosaldi");
    }
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pLimite",p_cVarName)) {
      return pLimite;
    }
    if (CPLib.eqr("nTotale",p_cVarName)) {
      return nTotale;
    }
    if (CPLib.eqr("_limcon",p_cVarName)) {
      return _limcon;
    }
    if (CPLib.eqr("_contaope",p_cVarName)) {
      return _contaope;
    }
    if (CPLib.eqr("_id_operazione",p_cVarName)) {
      return _id_operazione;
    }
    if (CPLib.eqr("_contasogg",p_cVarName)) {
      return _contasogg;
    }
    if (CPLib.eqr("_prgsogg",p_cVarName)) {
      return _prgsogg;
    }
    if (CPLib.eqr("_found",p_cVarName)) {
      return _found;
    }
    if (CPLib.eqr("_cfexist",p_cVarName)) {
      return _cfexist;
    }
    if (CPLib.eqr("_titexec",p_cVarName)) {
      return _titexec;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_com_oggettive";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pMese",p_cVarName)) {
      return pMese;
    }
    if (CPLib.eqr("pI3I4",p_cVarName)) {
      return pI3I4;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("_bpentseg",p_cVarName)) {
      return _bpentseg;
    }
    if (CPLib.eqr("_bpcodpat",p_cVarName)) {
      return _bpcodpat;
    }
    if (CPLib.eqr("_abiinter",p_cVarName)) {
      return _abiinter;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      return _cdatfin;
    }
    if (CPLib.eqr("_operazioni",p_cVarName)) {
      return _operazioni;
    }
    if (CPLib.eqr("_soggetti",p_cVarName)) {
      return _soggetti;
    }
    if (CPLib.eqr("_tiposogg",p_cVarName)) {
      return _tiposogg;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_codsta",p_cVarName)) {
      return _codsta;
    }
    if (CPLib.eqr("_cabnas",p_cVarName)) {
      return _cabnas;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_abicab",p_cVarName)) {
      return _abicab;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      return _tipo;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_totlire",p_cVarName)) {
      return _totlire;
    }
    if (CPLib.eqr("_totcont",p_cVarName)) {
      return _totcont;
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
    if (CPLib.eqr("_outfile",p_cVarName)) {
      return _outfile;
    }
    if (CPLib.eqr("_abitrim",p_cVarName)) {
      return _abitrim;
    }
    if (CPLib.eqr("_cabtrim",p_cVarName)) {
      return _cabtrim;
    }
    if (CPLib.eqr("cReturn",p_cVarName)) {
      return cReturn;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
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
    if (CPLib.eqr("mcOperazioni",p_cVarName)) {
      return mcOperazioni;
    }
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      return mcSoggetti;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcCFOperazione",p_cVarName)) {
      return mcCFOperazione;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pLimite",p_cVarName)) {
      pLimite = value;
      return;
    }
    if (CPLib.eqr("nTotale",p_cVarName)) {
      nTotale = value;
      return;
    }
    if (CPLib.eqr("_limcon",p_cVarName)) {
      _limcon = value;
      return;
    }
    if (CPLib.eqr("_contaope",p_cVarName)) {
      _contaope = value;
      return;
    }
    if (CPLib.eqr("_id_operazione",p_cVarName)) {
      _id_operazione = value;
      return;
    }
    if (CPLib.eqr("_contasogg",p_cVarName)) {
      _contasogg = value;
      return;
    }
    if (CPLib.eqr("_prgsogg",p_cVarName)) {
      _prgsogg = value;
      return;
    }
    if (CPLib.eqr("_found",p_cVarName)) {
      _found = value;
      return;
    }
    if (CPLib.eqr("_cfexist",p_cVarName)) {
      _cfexist = value;
      return;
    }
    if (CPLib.eqr("_titexec",p_cVarName)) {
      _titexec = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pMese",p_cVarName)) {
      pMese = value;
      return;
    }
    if (CPLib.eqr("pI3I4",p_cVarName)) {
      pI3I4 = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("_bpentseg",p_cVarName)) {
      _bpentseg = value;
      return;
    }
    if (CPLib.eqr("_bpcodpat",p_cVarName)) {
      _bpcodpat = value;
      return;
    }
    if (CPLib.eqr("_abiinter",p_cVarName)) {
      _abiinter = value;
      return;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      _cdatfin = value;
      return;
    }
    if (CPLib.eqr("_operazioni",p_cVarName)) {
      _operazioni = value;
      return;
    }
    if (CPLib.eqr("_soggetti",p_cVarName)) {
      _soggetti = value;
      return;
    }
    if (CPLib.eqr("_tiposogg",p_cVarName)) {
      _tiposogg = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_codsta",p_cVarName)) {
      _codsta = value;
      return;
    }
    if (CPLib.eqr("_cabnas",p_cVarName)) {
      _cabnas = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_abicab",p_cVarName)) {
      _abicab = value;
      return;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      _tipo = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_totlire",p_cVarName)) {
      _totlire = value;
      return;
    }
    if (CPLib.eqr("_totcont",p_cVarName)) {
      _totcont = value;
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
    if (CPLib.eqr("_outfile",p_cVarName)) {
      _outfile = value;
      return;
    }
    if (CPLib.eqr("_abitrim",p_cVarName)) {
      _abitrim = value;
      return;
    }
    if (CPLib.eqr("_cabtrim",p_cVarName)) {
      _cabtrim = value;
      return;
    }
    if (CPLib.eqr("cReturn",p_cVarName)) {
      cReturn = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
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
    if (CPLib.eqr("mcOperazioni",p_cVarName)) {
      mcOperazioni = (MemoryCursor_mcoperazionico_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      mcSoggetti = (MemoryCursor_mcsoggettico_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcrowserrori_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCFOperazione",p_cVarName)) {
      mcCFOperazione = (MemoryCursor_mcconnes_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_co_totalerec=null;
    CPResultSet Cursor_qbe_co_operazbo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_qbe_co_validi_totale=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAnno Numeric(4, 0) */
      /* pMese Char(2) */
      /* pLimite Numeric(12, 2) */
      /* pI3I4 Char(1) */
      /* gAzienda Char(10) // Azienda */
      /* gPathDoc Char(128) // Path Documenti */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* cRitorno Char(50) */
      /* nTotale Numeric(10, 0) */
      /* fhand Char(10) */
      /* _datini Date */
      /* _datfin Date */
      /* _limcon Numeric(12, 0) */
      /* _nomefile Char(30) */
      /* _testo Memo */
      /* _bpentseg Char(30) */
      /* _bpcodpat Char(12) */
      /* _abiinter Char(6) */
      /* _cdatfin Char(8) */
      /* _contaope Numeric(10, 0) */
      /* _id_operazione Numeric(10, 0) */
      /* _contasogg Numeric(10, 0) */
      /* _operazioni Memo */
      /* _soggetti Memo */
      /* _prgsogg Numeric(10, 0) */
      /* mcOperazioni MemoryCursor(mcOperazioniCO.MCRDef) */
      /* mcSoggetti MemoryCursor(mcSoggettiCO.MCRDef) */
      /* mcErrori MemoryCursor(mcRowsErrori.MCRDef) */
      /* mcCFOperazione MemoryCursor(mcConnes.MCRDef) */
      /* _tiposogg Char(2) */
      /* _connes Char(16) */
      /* _codsta Char(3) */
      /* _cabnas Char(6) */
      /* _sesso Char(1) */
      /* _abicab Char(13) */
      /* _found Numeric(1, 0) */
      /* _tipo Char(1) */
      /* _numprog Char(11) */
      /* _totlire Char(15) */
      /* _totcont Char(15) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* _outfile Char(100) */
      /* _cfexist Numeric(1, 0) */
      /* _titexec Numeric(1, 0) */
      /* gMsgProc := 'Ora Inizio Elaborazione Comunicazioni Oggettive: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione Comunicazioni Oggettive: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select BPCODPAT,BPENTSEG,ABI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _bpentseg := intermbo->BPENTSEG */
        _bpentseg = Cursor_intermbo.GetString("BPENTSEG");
        /* _bpcodpat := intermbo->BPCODPAT */
        _bpcodpat = Cursor_intermbo.GetString("BPCODPAT");
        /* _abiinter := intermbo->ABI */
        _abiinter = Cursor_intermbo.GetString("ABI");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _datini := CharToDate(Str(pAnno,4,0)+pMese+"01") */
      _datini = CPLib.CharToDate(CPLib.Str(pAnno,4,0)+pMese+"01");
      /* _datfin := arfn_finemese(_datini) */
      _datfin = arfn_finemeseR.Make(m_Ctx,this).Run(_datini);
      /* _cdatfin := DateToChar(_datfin) */
      _cdatfin = CPLib.DateToChar(_datfin);
      /* _limcon := pLimite * 100 */
      _limcon = CPLib.Round(pLimite*100,0);
      /* nTotale := 0 */
      nTotale = CPLib.Round(0,0);
      // * --- Select from qbe_co_totalerec
      SPBridge.HMCaller _h0000003F;
      _h0000003F = new SPBridge.HMCaller();
      _h0000003F.Set("m_cVQRList",m_cVQRList);
      _h0000003F.Set("dadata",_datini);
      _h0000003F.Set("a_data",_datfin);
      _h0000003F.Set("limcon",_limcon);
      _h0000003F.Set("i3i4",pI3I4);
      if (Cursor_qbe_co_totalerec!=null)
        Cursor_qbe_co_totalerec.Close();
      Cursor_qbe_co_totalerec = new VQRHolder("qbe_co_totalerec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_co_totalerec.Eof())) {
        /* nTotale := qbe_co_totalerec->TOTALE */
        nTotale = CPLib.Round(Cursor_qbe_co_totalerec.GetDouble("TOTALE"),0);
        Cursor_qbe_co_totalerec.Next();
      }
      m_cConnectivityError = Cursor_qbe_co_totalerec.ErrorMessage();
      Cursor_qbe_co_totalerec.Close();
      // * --- End Select
      // * --- Create temporary table tmp_esitosaldi
      if (m_Ctx.IsSharedTemp("tmp_esitosaldi")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_esitosaldi")) {
          m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
          m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_esitosaldi");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_esitosaldi");
      if ( ! (m_Ctx.IsSharedTemp("tmp_esitosaldi"))) {
        m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_esitosaldi",m_cServer,"proto")),m_cPhName,"tmp_esitosaldi",m_Ctx);
      }
      m_cPhName_tmp_esitosaldi = m_cPhName;
      /* If nTotale = 0 */
      if (CPLib.eqr(nTotale,0)) {
        /* Exec "Scrittura File" Page 9:OpenFile */
        OpenFile();
        /* Exec "Negativa" Page 4:Negativa */
        Negativa();
      } else { // Else
        // * --- Create temporary table tmp_appo_co1
        if (m_Ctx.IsSharedTemp("tmp_appo_co1")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_appo_co1")) {
            m_cServer = m_Ctx.GetServer("tmp_appo_co1");
            m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_appo_co1");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_appo_co1");
        if ( ! (m_Ctx.IsSharedTemp("tmp_appo_co1"))) {
          m_cServer = m_Ctx.GetServer("tmp_appo_co1");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_appo_co1",m_cServer,"proto")),m_cPhName,"tmp_appo_co1",m_Ctx);
        }
        m_cPhName_tmp_appo_co1 = m_cPhName;
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000048status;
        nTry00000048status = m_Sql.GetTransactionStatus();
        String cTry00000048msg;
        cTry00000048msg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from qbe_co_operazbo
          SPBridge.HMCaller _h00000049;
          _h00000049 = new SPBridge.HMCaller();
          _h00000049.Set("m_cVQRList",m_cVQRList);
          _h00000049.Set("dadata",_datini);
          _h00000049.Set("a_data",_datfin);
          _h00000049.Set("limcon",_limcon);
          _h00000049.Set("i3i4",pI3I4);
          if (Cursor_qbe_co_operazbo!=null)
            Cursor_qbe_co_operazbo.Close();
          Cursor_qbe_co_operazbo = new VQRHolder("qbe_co_operazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000049,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_co_operazbo.Eof())) {
            /* _totlire := Right('000000000000000'+LRTrim(Str(qbe_co_operazbo->TOTLIRE,15,0)),15) */
            _totlire = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_co_operazbo.GetDouble("TOTLIRE"),15,0)),15);
            /* _totcont := Right('000000000000000'+LRTrim(Str(qbe_co_operazbo->TOTCONT,15,0)),15) */
            _totcont = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),15,0)),15);
            /* _totlire := Left(_totlire,13)+'00' */
            _totlire = CPLib.Left(_totlire,13)+"00";
            /* _totcont := Left(_totcont,13)+'00' */
            _totcont = CPLib.Left(_totcont,13)+"00";
            /* gMsgImp := 'Controllo Operazione:' + qbe_co_operazbo->TIPO + "-"+qbe_co_operazbo->NUMPROG // Messaggio Import */
            gMsgImp = "Controllo Operazione:"+Cursor_qbe_co_operazbo.GetString("TIPO")+"-"+Cursor_qbe_co_operazbo.GetString("NUMPROG");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If not(Empty(qbe_co_operazbo->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_qbe_co_operazbo.GetString("CONNESCLI")))) {
              // * --- Insert into tmp_appo_co1 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_appo_co1");
              m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"00000050")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000050(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),0)?CPLib.Val(_totlire):CPLib.Val(_totcont)),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_appo_co1",true);
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
            /* If not(Empty(qbe_co_operazbo->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_qbe_co_operazbo.GetString("CONNESOPER")))) {
              // * --- Insert into tmp_appo_co1 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_appo_co1");
              m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"00000052")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000052(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),0)?CPLib.Val(_totlire):CPLib.Val(_totcont)),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_appo_co1",true);
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
            /* If qbe_co_operazbo->TIPO='O' */
            if (CPLib.eqr(Cursor_qbe_co_operazbo.GetString("TIPO"),"O")) {
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                /* If not(Empty(clientiope->CODSOG)) and clientiope->CODSOG <> qbe_co_operazbo->CONNESCLI */
                if ( ! (CPLib.Empty(Cursor_clientiope.GetString("CODSOG"))) && CPLib.ne(Cursor_clientiope.GetString("CODSOG"),Cursor_qbe_co_operazbo.GetString("CONNESCLI"))) {
                  // * --- Insert into tmp_appo_co1 from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_appo_co1");
                  m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"00000056")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000056(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),0)?CPLib.Val(_totlire):CPLib.Val(_totcont)),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_appo_co1",true);
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
                Cursor_clientiope.Next();
              }
              m_cConnectivityError = Cursor_clientiope.ErrorMessage();
              Cursor_clientiope.Close();
              // * --- End Select
              // * --- Select from sogopebo
              m_cServer = m_Ctx.GetServer("sogopebo");
              m_cPhName = m_Ctx.GetPhName("sogopebo");
              if (Cursor_sogopebo!=null)
                Cursor_sogopebo.Close();
              Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_sogopebo.Eof())) {
                /* If not(Empty(sogopebo->CODSOG)) and sogopebo->CODSOG <> qbe_co_operazbo->CONNESOPER */
                if ( ! (CPLib.Empty(Cursor_sogopebo.GetString("CODSOG"))) && CPLib.ne(Cursor_sogopebo.GetString("CODSOG"),Cursor_qbe_co_operazbo.GetString("CONNESOPER"))) {
                  // * --- Insert into tmp_appo_co1 from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_appo_co1");
                  m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"00000059")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000059(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),0)?CPLib.Val(_totlire):CPLib.Val(_totcont)),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_appo_co1",true);
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
                Cursor_sogopebo.Next();
              }
              m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
              Cursor_sogopebo.Close();
              // * --- End Select
              /* ElseIf qbe_co_operazbo->TIPO='F' */
            } else if (CPLib.eqr(Cursor_qbe_co_operazbo.GetString("TIPO"),"F")) {
              // * --- Select from clientifrz
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              if (Cursor_clientifrz!=null)
                Cursor_clientifrz.Close();
              Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientifrz.Eof())) {
                /* If not(Empty(clientifrz->CODSOG)) and clientifrz->CODSOG <> qbe_co_operazbo->CONNESCLI */
                if ( ! (CPLib.Empty(Cursor_clientifrz.GetString("CODSOG"))) && CPLib.ne(Cursor_clientifrz.GetString("CODSOG"),Cursor_qbe_co_operazbo.GetString("CONNESCLI"))) {
                  // * --- Insert into tmp_appo_co1 from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_appo_co1");
                  m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"0000005C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000005C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),0)?CPLib.Val(_totlire):CPLib.Val(_totcont)),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_appo_co1",true);
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
                Cursor_clientifrz.Next();
              }
              m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
              Cursor_clientifrz.Close();
              // * --- End Select
              // * --- Select from sogopefbo
              m_cServer = m_Ctx.GetServer("sogopefbo");
              m_cPhName = m_Ctx.GetPhName("sogopefbo");
              if (Cursor_sogopefbo!=null)
                Cursor_sogopefbo.Close();
              Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_sogopefbo.Eof())) {
                /* If not(Empty(sogopefbo->CODSOG)) and sogopefbo->CODSOG <> qbe_co_operazbo->CONNESOPER */
                if ( ! (CPLib.Empty(Cursor_sogopefbo.GetString("CODSOG"))) && CPLib.ne(Cursor_sogopefbo.GetString("CODSOG"),Cursor_qbe_co_operazbo.GetString("CONNESOPER"))) {
                  // * --- Insert into tmp_appo_co1 from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_appo_co1");
                  m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"0000005F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000005F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_co_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_co_operazbo.GetDouble("TOTCONT"),0)?CPLib.Val(_totlire):CPLib.Val(_totcont)),"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_appo_co1",true);
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
                Cursor_sogopefbo.Next();
              }
              m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
              Cursor_sogopefbo.Close();
              // * --- End Select
            } // End If
            Cursor_qbe_co_operazbo.Next();
          }
          m_cConnectivityError = Cursor_qbe_co_operazbo.ErrorMessage();
          Cursor_qbe_co_operazbo.Close();
          // * --- End Select
          /* Cancella */
          // * --- Delete from tmp_appo_co1
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_appo_co1");
          m_cPhName = m_Ctx.GetPhName("tmp_appo_co1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_appo_co1",m_Ctx.GetCompany());
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nMySQL)) {
            m_cQueryTable = m_Ctx.CreateTmpPhName("cptmp_1xab23");
            new VQRHolder("qbe_co_validi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).CreateServerQuery(m_Ctx, "cptmp_1xab23",false);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"00000061")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where exists( select 1 from "+m_cQueryTable+" where ";
            m_cSql = m_cSql+m_oWrInfo.GetTableWriteName()+".NDG = "+m_cQueryTable+".NDG";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter(true)+" ) ";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            m_Ctx.DropTmp("cptmp_1xab23");
          } else {
            try {
              l_VQRHolder = new VQRHolder("qbe_co_validi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true);
              m_cQuery = l_VQRHolder.GetQueryMakingTempTables(m_Ctx,m_Sql,m_cServer,true);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"00000061")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where exists( select 1 from ("+m_cQuery+") cptmp_1xab23 where ";
              m_cSql = m_cSql+m_oWrInfo.GetTableWriteName()+".NDG = cptmp_1xab23.NDG";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter(true)+" ) ";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
            } finally {
              if (l_VQRHolder!=null)
                l_VQRHolder.DropTempTables(m_Ctx);
            }
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
          // * --- Select from qbe_co_validi_totale
          if (Cursor_qbe_co_validi_totale!=null)
            Cursor_qbe_co_validi_totale.Close();
          Cursor_qbe_co_validi_totale = new VQRHolder("qbe_co_validi_totale",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_co_validi_totale.Eof())) {
            /* nTotale := qbe_co_validi_totale->TOTALE */
            nTotale = CPLib.Round(Cursor_qbe_co_validi_totale.GetDouble("TOTALE"),0);
            Cursor_qbe_co_validi_totale.Next();
          }
          m_cConnectivityError = Cursor_qbe_co_validi_totale.ErrorMessage();
          Cursor_qbe_co_validi_totale.Close();
          // * --- End Select
          /* Exec "Scrittura File" Page 9:OpenFile */
          OpenFile();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* If nTotale=0 */
          if (CPLib.eqr(nTotale,0)) {
            /* Exec "Negativa" Page 4:Negativa */
            Negativa();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } else { // Else
            /* Exec "Positiva" Page 5:Positiva */
            Positiva();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
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
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000048status,0)) {
            m_Sql.SetTransactionStatus(nTry00000048status,cTry00000048msg);
          }
        }
      } // End If
      /* Exec "Coda" Page 3:Coda */
      Coda();
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* If mcErrori.RecCount() > 0 */
      if (CPLib.gt(mcErrori.RecCount(),0)) {
        for (MemoryCursorRow_mcrowserrori_mcrdef rwErrori : mcErrori._iterable_()) {
          // * --- Insert into tmp_esitosaldi from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esitosaldi");
          m_cPhName = m_Ctx.GetPhName("tmp_esitosaldi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esitosaldi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_com_oggettive",88,"0000006E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000006E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rwErrori.colonna01),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rwErrori.colonna02),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rwErrori.Errore),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esitosaldi",true);
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
        }
        /* _outfile := 'ERRORI' */
        _outfile = "ERRORI";
        /* gMsgImp := 'Elaborazione Terminata. Rilevati Errori' */
        gMsgImp = "Elaborazione Terminata. Rilevati Errori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Else
        /* cOnlyNomeFile := _nomefile */
        cOnlyNomeFile = _nomefile;
        /* _outfile := Strtran(_nomefile,'.xml','.zip') */
        _outfile = CPLib.Strtran(_nomefile,".xml",".zip");
        /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+_nomefile */
        cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_nomefile;
        /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+_outfile */
        cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_outfile;
        /* Exec "Crea File Zip" Page 8:FileZip */
        FileZip();
        /* gMsgImp := 'Elaborazione Terminata!' */
        gMsgImp = "Elaborazione Terminata!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Comunicazioni Oggettive: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione Comunicazioni Oggettive: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _outfile */
      throw new Stop(_outfile);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_co_totalerec!=null)
          Cursor_qbe_co_totalerec.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_co_operazbo!=null)
          Cursor_qbe_co_operazbo.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_co_validi_totale!=null)
          Cursor_qbe_co_validi_totale.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Testa() throws Exception {
    /* _testo := '' */
    _testo = "";
    /* _testo := _testo +'<?xml version="1.0" encoding="UTF-8" standalone="yes"?>' + NL */
    _testo = _testo+"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+"\n";
    /* _testo := _testo +'<message xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.bancaditalia.it/bolina/common/vo/message" xmlns:ns2="http://www.bancaditalia.it/bolina/common/vo/cube" xsi:schemaLocation="http://www.bancaditalia.it/bolina/common/vo/message message_bancaditalia.xsd">' + NL */
    _testo = _testo+"<message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.bancaditalia.it/bolina/common/vo/message\" xmlns:ns2=\"http://www.bancaditalia.it/bolina/common/vo/cube\" xsi:schemaLocation=\"http://www.bancaditalia.it/bolina/common/vo/message message_bancaditalia.xsd\">"+"\n";
    /* _testo := _testo +'<header>' + NL */
    _testo = _testo+"<header>"+"\n";
    /* _testo := _testo +'<survey>OGG</survey>' + NL */
    _testo = _testo+"<survey>OGG</survey>"+"\n";
    /* _testo := _testo +'<partner>'+LRTrim(_bpcodpat)+'</partner>' + NL */
    _testo = _testo+"<partner>"+CPLib.LRTrim(_bpcodpat)+"</partner>"+"\n";
    /* _testo := _testo +'<initialDate>' + Left(_cdatfin,4) + '-' + Substr(_cdatfin,5,2) + '-' + Right(_cdatfin,2) + '</initialDate>' + NL */
    _testo = _testo+"<initialDate>"+CPLib.Left(_cdatfin,4)+"-"+CPLib.Substr(_cdatfin,5,2)+"-"+CPLib.Right(_cdatfin,2)+"</initialDate>"+"\n";
    /* _testo := _testo + '<timeProduction>'+Strtran(arfn_fdatetime_bp(DateTime()),'T',' ') +'</timeProduction>' + NL */
    _testo = _testo+"<timeProduction>"+CPLib.Strtran(arfn_fdatetime_bpR.Make(m_Ctx,this).Run(CPLib.DateTime()),"T"," ")+"</timeProduction>"+"\n";
    /* _testo := _testo + '<type>SUBSTITUTION</type>' + NL */
    _testo = _testo+"<type>SUBSTITUTION</type>"+"\n";
    /* _testo := _testo + '</header>' + NL */
    _testo = _testo+"</header>"+"\n";
    /* _testo := _testo + '<content>' + NL */
    _testo = _testo+"<content>"+"\n";
    /* _testo := _testo + '<dataSegment id="OBSERVATION">' + NL */
    _testo = _testo+"<dataSegment id=\"OBSERVATION\">"+"\n";
    /* FileLibMit.Write(fhand,_testo) */
    FileLibMit.Write(fhand,_testo);
    /* _testo := '' */
    _testo = "";
  }
  void Coda() throws Exception {
    /* _testo := '' */
    _testo = "";
    /* _testo := _testo +'</dataSegment>' + NL */
    _testo = _testo+"</dataSegment>"+"\n";
    /* _testo := _testo +'</content>' + NL */
    _testo = _testo+"</content>"+"\n";
    /* _testo := _testo +'</message>'+NL */
    _testo = _testo+"</message>"+"\n";
    /* FileLibMit.Write(fhand,_testo) */
    FileLibMit.Write(fhand,_testo);
  }
  void Negativa() throws Exception {
    /* _testo := "" */
    _testo = "";
    /* _testo := _testo +'<cube lastObsId="0" id="OGG_NEGATIVA" xmlns="http://www.bancaditalia.it/bolina/common/vo/cube">' + NL */
    _testo = _testo+"<cube lastObsId=\"0\" id=\"OGG_NEGATIVA\" xmlns=\"http://www.bancaditalia.it/bolina/common/vo/cube\">"+"\n";
    /* _testo := _testo +'<obs id="0">' + NL */
    _testo = _testo+"<obs id=\"0\">"+"\n";
    /* _testo := _testo +'<dim name="CODICE_SEGNALANTE" value="'+LRTrim(_bpentseg)+'"/>' + NL */
    _testo = _testo+"<dim name=\"CODICE_SEGNALANTE\" value=\""+CPLib.LRTrim(_bpentseg)+"\"/>"+"\n";
    /* _testo := _testo +'<dim name="DATA_CONTABILE" value="'+ LRTrim(_cdatfin)+'"/>' + NL */
    _testo = _testo+"<dim name=\"DATA_CONTABILE\" value=\""+CPLib.LRTrim(_cdatfin)+"\"/>"+"\n";
    /* _testo := _testo +'<dim name="SEGN_NEG" value="1"/>' + NL */
    _testo = _testo+"<dim name=\"SEGN_NEG\" value=\"1\"/>"+"\n";
    /* _testo := _testo +'</obs>' + NL */
    _testo = _testo+"</obs>"+"\n";
    /* _testo := _testo +'</cube>' + NL */
    _testo = _testo+"</cube>"+"\n";
    /* FileLibMit.Write(fhand,_testo) */
    FileLibMit.Write(fhand,_testo);
  }
  void Positiva() throws Exception {
    CPResultSet Cursor_qbe_co_operazioni_valide=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_qbe_co_titolari=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_jperazbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _contaope := 0 */
      _contaope = CPLib.Round(0,0);
      /* _id_operazione := 1 */
      _id_operazione = CPLib.Round(1,0);
      /* _contasogg := 0 */
      _contasogg = CPLib.Round(0,0);
      /* _operazioni := "" */
      _operazioni = "";
      /* _soggetti := "" */
      _soggetti = "";
      // * --- Select from qbe_co_operazioni_valide
      if (Cursor_qbe_co_operazioni_valide!=null)
        Cursor_qbe_co_operazioni_valide.Close();
      Cursor_qbe_co_operazioni_valide = new VQRHolder("qbe_co_operazioni_valide",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_co_operazioni_valide.Eof())) {
        /* gMsgImp := 'Elaboro Operazione:' + qbe_co_operazioni_valide->TIPO + "-"+qbe_co_operazioni_valide->NUMPROG // Messaggio Import */
        gMsgImp = "Elaboro Operazione:"+Cursor_qbe_co_operazioni_valide.GetString("TIPO")+"-"+Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _abicab := '' */
        _abicab = "";
        /* _tipo := qbe_co_operazioni_valide->TIPO */
        _tipo = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
        /* _numprog := qbe_co_operazioni_valide->NUMPROG */
        _numprog = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
        /* If qbe_co_operazioni_valide->TIPO='O' */
        if (CPLib.eqr(Cursor_qbe_co_operazioni_valide.GetString("TIPO"),"O")) {
          // * --- Select from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          if (Cursor_operazbo!=null)
            Cursor_operazbo.Close();
          Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo.Eof())) {
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.CONTAOPE := _contaope */
            mcOperazioni.row.CONTAOPE = _contaope;
            /* mcOperazioni.CODICE_SEGNALANTE := _bpentseg */
            mcOperazioni.row.CODICE_SEGNALANTE = _bpentseg;
            /* mcOperazioni.DATA_CONTABILE := _cdatfin */
            mcOperazioni.row.DATA_CONTABILE = _cdatfin;
            /* mcOperazioni.ID_OPERAZIONE := _id_operazione */
            mcOperazioni.row.ID_OPERAZIONE = _id_operazione;
            /* mcOperazioni.DATA_CONT_OPERAZ := DateToChar(operazbo->DATAOPE) */
            mcOperazioni.row.DATA_CONT_OPERAZ = CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE"));
            /* mcOperazioni.TIPO_OPERAZIONE := operazbo->CODANA */
            mcOperazioni.row.TIPO_OPERAZIONE = Cursor_operazbo.GetString("CODANA");
            /* mcOperazioni.SEGNO_OPERAZ := operazbo->SEGNO */
            mcOperazioni.row.SEGNO_OPERAZ = Cursor_operazbo.GetString("SEGNO");
            /* mcOperazioni.COD_VALUTA := operazbo->VALUTA */
            mcOperazioni.row.COD_VALUTA = Cursor_operazbo.GetString("VALUTA");
            /* mcOperazioni.IMPORTO_OPERAZ := operazbo->TOTLIRE */
            mcOperazioni.row.IMPORTO_OPERAZ = Cursor_operazbo.GetDouble("TOTLIRE");
            /* mcOperazioni.IMPORTO_CONT := iif(operazbo->TOTCONT > 0,operazbo->TOTCONT,iif((operazbo->CODANA='I3' or operazbo->CODANA='I4') and operazbo->TOTCONT=0,operazbo->TOTLIRE,operazbo->TOTCONT)) */
            mcOperazioni.row.IMPORTO_CONT = (CPLib.gt(Cursor_operazbo.GetDouble("TOTCONT"),0)?Cursor_operazbo.GetDouble("TOTCONT"):((CPLib.eqr(Cursor_operazbo.GetString("CODANA"),"I3") || CPLib.eqr(Cursor_operazbo.GetString("CODANA"),"I4")) && CPLib.eqr(Cursor_operazbo.GetDouble("TOTCONT"),0)?Cursor_operazbo.GetDouble("TOTLIRE"):Cursor_operazbo.GetDouble("TOTCONT")));
            /* If not(Empty(operazbo->CODDIPE)) */
            if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CODDIPE")))) {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              if (Cursor_anadip!=null)
                Cursor_anadip.Close();
              Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_operazbo.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anadip.Eof())) {
                /* _found := 1 */
                _found = CPLib.Round(1,0);
                /* mcOperazioni.CODICE_FILIALE := operazbo->CODDIPE */
                mcOperazioni.row.CODICE_FILIALE = Cursor_operazbo.GetString("CODDIPE");
                /* If not(Empty(anadip->CAB2)) */
                if ( ! (CPLib.Empty(Cursor_anadip.GetString("CAB2")))) {
                  /* _abicab := AbiCab(_abiinter,anadip->CAB2) */
                  _abicab = AbiCab(_abiinter,Cursor_anadip.GetString("CAB2"));
                  /* mcOperazioni.UL_BANCARIA_CAB := _abicab */
                  mcOperazioni.row.UL_BANCARIA_CAB = _abicab;
                  /* mcOperazioni.COMUNE_ESEC := anadip->CAB */
                  mcOperazioni.row.COMUNE_ESEC = Cursor_anadip.GetString("CAB");
                } // End If
                Cursor_anadip.Next();
              }
              m_cConnectivityError = Cursor_anadip.ErrorMessage();
              Cursor_anadip.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                /* mcErrori.Errore := 'Dipendenza:' +LRTrim(operazbo->CODDIPE) + ' - Codice Dipendenza Anomalo (Non presente in archivio dipendenze)' */
                mcErrori.row.Errore = "Dipendenza:"+CPLib.LRTrim(Cursor_operazbo.GetString("CODDIPE"))+" - Codice Dipendenza Anomalo (Non presente in archivio dipendenze)";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* If not(Empty(operazbo->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_operazbo.GetString("RAPPORTO")))) {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              if (Cursor_anarapbo!=null)
                Cursor_anarapbo.Close();
              Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IBAN,CODOGG,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anarapbo.Eof())) {
                /* _found := 1 */
                _found = CPLib.Round(1,0);
                /* If Empty(anarapbo->CODOGG) */
                if (CPLib.Empty(Cursor_anarapbo.GetString("CODOGG"))) {
                  /* mcErrori.AppendBlank() */
                  mcErrori.AppendBlank();
                  /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                  mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                  /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                  mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                  /* mcErrori.Errore := 'Rapporto: '+LRTrim(anarapbo->RAPPORTO)+" - Assenza Codice Comunicazione Oggettiva" */
                  mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_anarapbo.GetString("RAPPORTO"))+" - Assenza Codice Comunicazione Oggettiva";
                  /* mcErrori.SaveRow() */
                  mcErrori.SaveRow();
                } else { // Else
                  /* mcOperazioni.CAT_RAPPORTO := anarapbo->CODOGG */
                  mcOperazioni.row.CAT_RAPPORTO = Cursor_anarapbo.GetString("CODOGG");
                  /* If anarapbo->CODOGG='028' */
                  if (CPLib.eqr(Cursor_anarapbo.GetString("CODOGG"),"028")) {
                    /* If Empty(anarapbo->IBAN) */
                    if (CPLib.Empty(Cursor_anarapbo.GetString("IBAN"))) {
                      /* mcErrori.AppendBlank() */
                      mcErrori.AppendBlank();
                      /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                      mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                      /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                      mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                      /* mcErrori.Errore := 'Rapporto: '+LRTrim(anarapbo->RAPPORTO)+" - Manca di IBAN per tipologia Conto Corrente" */
                      mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_anarapbo.GetString("RAPPORTO"))+" - Manca di IBAN per tipologia Conto Corrente";
                      /* mcErrori.SaveRow() */
                      mcErrori.SaveRow();
                    } else { // Else
                      /* mcOperazioni.NUMERO_RAPPORTO := anarapbo->IBAN */
                      mcOperazioni.row.NUMERO_RAPPORTO = Cursor_anarapbo.GetString("IBAN");
                    } // End If
                  } else { // Else
                    /* mcOperazioni.NUMERO_RAPPORTO := anarapbo->RAPPORTO */
                    mcOperazioni.row.NUMERO_RAPPORTO = Cursor_anarapbo.GetString("RAPPORTO");
                  } // End If
                  /* If not(Empty(_abicab)) */
                  if ( ! (CPLib.Empty(_abicab))) {
                    /* mcOperazioni.FILIALE := _abicab */
                    mcOperazioni.row.FILIALE = _abicab;
                  } // End If
                } // End If
                Cursor_anarapbo.Next();
              }
              m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
              Cursor_anarapbo.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                /* mcErrori.Errore := 'Rapporto: '+LRTrim(operazbo->RAPPORTO)+' - Codice Rapporto Anomalo (Non presente in archivio rapporti)' */
                mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_operazbo.GetString("RAPPORTO"))+" - Codice Rapporto Anomalo (Non presente in archivio rapporti)";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* mcCFOperazione.Zap() */
            mcCFOperazione.Zap();
            /* _prgsogg := 0 */
            _prgsogg = CPLib.Round(0,0);
            /* _titexec := 0 */
            _titexec = CPLib.Round(0,0);
            /* If not(Empty(operazbo->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESCLI")))) {
              /* _tiposogg := iif(Empty(operazbo->CONNESOPER),'01','02') */
              _tiposogg = (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER"))?"01":"02");
              /* _connes := operazbo->CONNESCLI */
              _connes = Cursor_operazbo.GetString("CONNESCLI");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              /* If Empty(_sesso) */
              if (CPLib.Empty(_sesso)) {
                // * --- Select from qbe_co_titolari
                SPBridge.HMCaller _h000000E4;
                _h000000E4 = new SPBridge.HMCaller();
                _h000000E4.Set("m_cVQRList",m_cVQRList);
                _h000000E4.Set("pCODCLI",_connes);
                _h000000E4.Set("pDATOPE",Cursor_operazbo.GetDate("DATAOPE"));
                if (Cursor_qbe_co_titolari!=null)
                  Cursor_qbe_co_titolari.Close();
                Cursor_qbe_co_titolari = new VQRHolder("qbe_co_titolari",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000E4,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_co_titolari.Eof())) {
                  /* _tiposogg := '04' */
                  _tiposogg = "04";
                  /* If Empty(operazbo->CONNESOPER) or (not(Empty(operazbo->CONNESOPER)) and qbe_co_titolari->CODINTER <> operazbo->CONNESOPER) */
                  if (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER")) || ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_co_titolari.GetString("CODINTER"),Cursor_operazbo.GetString("CONNESOPER")))) {
                    /* _connes := qbe_co_titolari->CODINTER */
                    _connes = Cursor_qbe_co_titolari.GetString("CODINTER");
                    /* Exec "Soggetti" Page 6:Soggetti */
                    Soggetti();
                    /* ElseIf not(Empty(operazbo->CONNESOPER)) and qbe_co_titolari->CODINTER = operazbo->CONNESOPER */
                  } else if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER"))) && CPLib.eqr(Cursor_qbe_co_titolari.GetString("CODINTER"),Cursor_operazbo.GetString("CONNESOPER"))) {
                    /* _titexec := 1 */
                    _titexec = CPLib.Round(1,0);
                  } // End If
                  Cursor_qbe_co_titolari.Next();
                }
                m_cConnectivityError = Cursor_qbe_co_titolari.ErrorMessage();
                Cursor_qbe_co_titolari.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(operazbo->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER")))) {
              /* _tiposogg := iif(_titexec=1,'08',iif(operazbo->TIPOLEG='6','07','03')) */
              _tiposogg = (CPLib.eqr(_titexec,1)?"08":(CPLib.eqr(Cursor_operazbo.GetString("TIPOLEG"),"6")?"07":"03"));
              /* _connes := operazbo->CONNESOPER */
              _connes = Cursor_operazbo.GetString("CONNESOPER");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
            } // End If
            /* If not(Empty(operazbo->CONNESBEN)) and operazbo->CONNESBEN <> operazbo->CONNESCLI */
            if ( ! (CPLib.Empty(Cursor_operazbo.GetString("CONNESBEN"))) && CPLib.ne(Cursor_operazbo.GetString("CONNESBEN"),Cursor_operazbo.GetString("CONNESCLI"))) {
              /* _tiposogg := '06' */
              _tiposogg = "06";
              /* _connes := operazbo->CONNESBEN */
              _connes = Cursor_operazbo.GetString("CONNESBEN");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
            } // End If
            /* If Empty(operazbo->CONNESBEN) and not(Empty(operazbo->C_RAG)) */
            if (CPLib.Empty(Cursor_operazbo.GetString("CONNESBEN")) &&  ! (CPLib.Empty(Cursor_operazbo.GetString("C_RAG")))) {
              /* _prgsogg := _prgsogg + 1 */
              _prgsogg = CPLib.Round(_prgsogg+1,0);
              /* _contasogg := _contasogg + 1 */
              _contasogg = CPLib.Round(_contasogg+1,0);
              /* mcSoggetti.AppendBlank() */
              mcSoggetti.AppendBlank();
              /* mcSoggetti.CONTASOGG := _contaope */
              mcSoggetti.row.CONTASOGG = _contaope;
              /* mcSoggetti.CODICE_SEGNALANTE := _bpentseg */
              mcSoggetti.row.CODICE_SEGNALANTE = _bpentseg;
              /* mcSoggetti.DATA_CONTABILE := _cdatfin */
              mcSoggetti.row.DATA_CONTABILE = _cdatfin;
              /* mcSoggetti.ID_OPERAZIONE := _id_operazione */
              mcSoggetti.row.ID_OPERAZIONE = _id_operazione;
              /* mcSoggetti.PROG_SOGGETTO := _prgsogg */
              mcSoggetti.row.PROG_SOGGETTO = _prgsogg;
              /* mcSoggetti.CODICE_TIPO_SOGGETTO := '06' */
              mcSoggetti.row.CODICE_TIPO_SOGGETTO = "06";
              /* mcSoggetti.NATURA_GIURIDICA := 'NPF' */
              mcSoggetti.row.NATURA_GIURIDICA = "NPF";
              /* mcSoggetti.CODICE_FISCALE := Replicate('X',16) */
              mcSoggetti.row.CODICE_FISCALE = CPLib.Replicate("X",16);
              /* mcSoggetti.NPF_DENOMINAZIONE := arfn_agechar(LRTrim(operazbo->C_RAG)," ") */
              mcSoggetti.row.NPF_DENOMINAZIONE = arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_operazbo.GetString("C_RAG"))," ");
              /* If operazbo->C_STA='086' */
              if (CPLib.eqr(Cursor_operazbo.GetString("C_STA"),"086")) {
                /* mcSoggetti.NPF_SEDELEG_IND_COMUNE := operazbo->C_CAB */
                mcSoggetti.row.NPF_SEDELEG_IND_COMUNE = Cursor_operazbo.GetString("C_CAB");
              } // End If
              /* mcSoggetti.NPF_SEDELEG_IND_STATO := operazbo->C_STA */
              mcSoggetti.row.NPF_SEDELEG_IND_STATO = Cursor_operazbo.GetString("C_STA");
              /* mcSoggetti.SaveRow() */
              mcSoggetti.SaveRow();
            } // End If
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              /* _tiposogg := iif(Empty(operazbo->CONNESOPER),'01','02') */
              _tiposogg = (CPLib.Empty(Cursor_operazbo.GetString("CONNESOPER"))?"01":"02");
              /* _connes := clientiope->CODSOG */
              _connes = Cursor_clientiope.GetString("CODSOG");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              /* If Empty(_sesso) */
              if (CPLib.Empty(_sesso)) {
                // * --- Select from qbe_co_titolari
                SPBridge.HMCaller _h00000108;
                _h00000108 = new SPBridge.HMCaller();
                _h00000108.Set("m_cVQRList",m_cVQRList);
                _h00000108.Set("pCODCLI",_connes);
                _h00000108.Set("pDATOPE",Cursor_operazbo.GetDate("DATAOPE"));
                if (Cursor_qbe_co_titolari!=null)
                  Cursor_qbe_co_titolari.Close();
                Cursor_qbe_co_titolari = new VQRHolder("qbe_co_titolari",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000108,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_co_titolari.Eof())) {
                  /* _tiposogg := '04' */
                  _tiposogg = "04";
                  /* _connes := qbe_co_titolari->CODINTER */
                  _connes = Cursor_qbe_co_titolari.GetString("CODINTER");
                  /* Exec "Soggetti" Page 6:Soggetti */
                  Soggetti();
                  Cursor_qbe_co_titolari.Next();
                }
                m_cConnectivityError = Cursor_qbe_co_titolari.ErrorMessage();
                Cursor_qbe_co_titolari.Close();
                // * --- End Select
              } // End If
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              /* _tiposogg := iif(sogopebo->LEGAME='6','07','03') */
              _tiposogg = (CPLib.eqr(Cursor_sogopebo.GetString("LEGAME"),"6")?"07":"03");
              /* _connes := sogopebo->CODSOG */
              _connes = Cursor_sogopebo.GetString("CODSOG");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            Cursor_operazbo.Next();
          }
          m_cConnectivityError = Cursor_operazbo.ErrorMessage();
          Cursor_operazbo.Close();
          // * --- End Select
          /* ElseIf qbe_co_operazioni_valide->TIPO='F' */
        } else if (CPLib.eqr(Cursor_qbe_co_operazioni_valide.GetString("TIPO"),"F")) {
          // * --- Select from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          if (Cursor_fraziobo!=null)
            Cursor_fraziobo.Close();
          Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fraziobo.Eof())) {
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.CONTAOPE := _contaope */
            mcOperazioni.row.CONTAOPE = _contaope;
            /* mcOperazioni.CODICE_SEGNALANTE := _bpentseg */
            mcOperazioni.row.CODICE_SEGNALANTE = _bpentseg;
            /* mcOperazioni.DATA_CONTABILE := _cdatfin */
            mcOperazioni.row.DATA_CONTABILE = _cdatfin;
            /* mcOperazioni.ID_OPERAZIONE := _id_operazione */
            mcOperazioni.row.ID_OPERAZIONE = _id_operazione;
            /* mcOperazioni.DATA_CONT_OPERAZ := DateToChar(fraziobo->DATAOPE) */
            mcOperazioni.row.DATA_CONT_OPERAZ = CPLib.DateToChar(Cursor_fraziobo.GetDate("DATAOPE"));
            /* mcOperazioni.TIPO_OPERAZIONE := fraziobo->CODANA */
            mcOperazioni.row.TIPO_OPERAZIONE = Cursor_fraziobo.GetString("CODANA");
            /* mcOperazioni.SEGNO_OPERAZ := fraziobo->SEGNO */
            mcOperazioni.row.SEGNO_OPERAZ = Cursor_fraziobo.GetString("SEGNO");
            /* mcOperazioni.COD_VALUTA := fraziobo->VALUTA */
            mcOperazioni.row.COD_VALUTA = Cursor_fraziobo.GetString("VALUTA");
            /* mcOperazioni.IMPORTO_OPERAZ := fraziobo->TOTLIRE */
            mcOperazioni.row.IMPORTO_OPERAZ = Cursor_fraziobo.GetDouble("TOTLIRE");
            /* mcOperazioni.IMPORTO_CONT := iif(fraziobo->TOTCONT > 0,fraziobo->TOTCONT,iif((fraziobo->CODANA='I3' or fraziobo->CODANA='I4') and fraziobo->TOTCONT=0,fraziobo->TOTLIRE,fraziobo->TOTCONT)) */
            mcOperazioni.row.IMPORTO_CONT = (CPLib.gt(Cursor_fraziobo.GetDouble("TOTCONT"),0)?Cursor_fraziobo.GetDouble("TOTCONT"):((CPLib.eqr(Cursor_fraziobo.GetString("CODANA"),"I3") || CPLib.eqr(Cursor_fraziobo.GetString("CODANA"),"I4")) && CPLib.eqr(Cursor_fraziobo.GetDouble("TOTCONT"),0)?Cursor_fraziobo.GetDouble("TOTLIRE"):Cursor_fraziobo.GetDouble("TOTCONT")));
            /* If not(Empty(fraziobo->CODDIPE)) */
            if ( ! (CPLib.Empty(Cursor_fraziobo.GetString("CODDIPE")))) {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              if (Cursor_anadip!=null)
                Cursor_anadip.Close();
              Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anadip.Eof())) {
                /* _found := 1 */
                _found = CPLib.Round(1,0);
                /* mcOperazioni.CODICE_FILIALE := fraziobo->CODDIPE */
                mcOperazioni.row.CODICE_FILIALE = Cursor_fraziobo.GetString("CODDIPE");
                /* If not(Empty(anadip->CAB2)) */
                if ( ! (CPLib.Empty(Cursor_anadip.GetString("CAB2")))) {
                  /* mcOperazioni.UL_BANCARIA_CAB := anadip->CAB2 */
                  mcOperazioni.row.UL_BANCARIA_CAB = Cursor_anadip.GetString("CAB2");
                  /* mcOperazioni.COMUNE_ESEC := anadip->CAB */
                  mcOperazioni.row.COMUNE_ESEC = Cursor_anadip.GetString("CAB");
                } // End If
                Cursor_anadip.Next();
              }
              m_cConnectivityError = Cursor_anadip.ErrorMessage();
              Cursor_anadip.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                /* mcErrori.Errore := 'Dipendenza:' +LRTrim(fraziobo->CODDIPE) + ' - Codice Dipendenza Anomalo (Non presente in archivio dipendenze)' */
                mcErrori.row.Errore = "Dipendenza:"+CPLib.LRTrim(Cursor_fraziobo.GetString("CODDIPE"))+" - Codice Dipendenza Anomalo (Non presente in archivio dipendenze)";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* If not(Empty(fraziobo->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_fraziobo.GetString("RAPPORTO")))) {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              if (Cursor_anarapbo!=null)
                Cursor_anarapbo.Close();
              Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IBAN,CODOGG,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anarapbo.Eof())) {
                /* _found := 1 */
                _found = CPLib.Round(1,0);
                /* If Empty(anarapbo->CODOGG) */
                if (CPLib.Empty(Cursor_anarapbo.GetString("CODOGG"))) {
                  /* mcErrori.AppendBlank() */
                  mcErrori.AppendBlank();
                  /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                  mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                  /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                  mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                  /* mcErrori.Errore := 'Rapporto: '+LRTrim(anarapbo->RAPPORTO)+" - Assenza Codice Comunicazione Oggettiva" */
                  mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_anarapbo.GetString("RAPPORTO"))+" - Assenza Codice Comunicazione Oggettiva";
                  /* mcErrori.SaveRow() */
                  mcErrori.SaveRow();
                } else { // Else
                  /* mcOperazioni.CAT_RAPPORTO := anarapbo->CODOGG */
                  mcOperazioni.row.CAT_RAPPORTO = Cursor_anarapbo.GetString("CODOGG");
                  /* If anarapbo->CODOGG='028' */
                  if (CPLib.eqr(Cursor_anarapbo.GetString("CODOGG"),"028")) {
                    /* mcOperazioni.NUMERO_RAPPORTO := anarapbo->IBAN */
                    mcOperazioni.row.NUMERO_RAPPORTO = Cursor_anarapbo.GetString("IBAN");
                  } else { // Else
                    /* mcOperazioni.NUMERO_RAPPORTO := anarapbo->RAPPORTO */
                    mcOperazioni.row.NUMERO_RAPPORTO = Cursor_anarapbo.GetString("RAPPORTO");
                  } // End If
                  /* If not(Empty(_abicab)) */
                  if ( ! (CPLib.Empty(_abicab))) {
                    /* mcOperazioni.FILIALE := _abicab */
                    mcOperazioni.row.FILIALE = _abicab;
                  } // End If
                } // End If
                Cursor_anarapbo.Next();
              }
              m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
              Cursor_anarapbo.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                /* mcErrori.Errore := 'Rapporto: '+LRTrim(fraziobo->RAPPORTO)+' - Codice Rapporto Anomalo (Non presente in archivio rapporti)' */
                mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_fraziobo.GetString("RAPPORTO"))+" - Codice Rapporto Anomalo (Non presente in archivio rapporti)";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* mcCFOperazione.Zap() */
            mcCFOperazione.Zap();
            /* _prgsogg := 0 */
            _prgsogg = CPLib.Round(0,0);
            /* _titexec := 0 */
            _titexec = CPLib.Round(0,0);
            /* If not(Empty(fraziobo->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_fraziobo.GetString("CONNESCLI")))) {
              /* _tiposogg := iif(Empty(fraziobo->CONNESOPER),'01','02') */
              _tiposogg = (CPLib.Empty(Cursor_fraziobo.GetString("CONNESOPER"))?"01":"02");
              /* _connes := fraziobo->CONNESCLI */
              _connes = Cursor_fraziobo.GetString("CONNESCLI");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              /* If Empty(_sesso) */
              if (CPLib.Empty(_sesso)) {
                // * --- Select from qbe_co_titolari
                SPBridge.HMCaller _h00000148;
                _h00000148 = new SPBridge.HMCaller();
                _h00000148.Set("m_cVQRList",m_cVQRList);
                _h00000148.Set("pCODCLI",_connes);
                _h00000148.Set("pDATOPE",Cursor_fraziobo.GetDate("DATAOPE"));
                if (Cursor_qbe_co_titolari!=null)
                  Cursor_qbe_co_titolari.Close();
                Cursor_qbe_co_titolari = new VQRHolder("qbe_co_titolari",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000148,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_co_titolari.Eof())) {
                  /* _tiposogg := '04' */
                  _tiposogg = "04";
                  /* If Empty(fraziobo->CONNESOPER) or (not(Empty(fraziobo->CONNESOPER)) and qbe_co_titolari->CODINTER <> fraziobo->CONNESOPER) */
                  if (CPLib.Empty(Cursor_fraziobo.GetString("CONNESOPER")) || ( ! (CPLib.Empty(Cursor_fraziobo.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_co_titolari.GetString("CODINTER"),Cursor_fraziobo.GetString("CONNESOPER")))) {
                    /* _connes := qbe_co_titolari->CODINTER */
                    _connes = Cursor_qbe_co_titolari.GetString("CODINTER");
                    /* Exec "Soggetti" Page 6:Soggetti */
                    Soggetti();
                    /* ElseIf not(Empty(fraziobo->CONNESOPER)) and qbe_co_titolari->CODINTER = fraziobo->CONNESOPER */
                  } else if ( ! (CPLib.Empty(Cursor_fraziobo.GetString("CONNESOPER"))) && CPLib.eqr(Cursor_qbe_co_titolari.GetString("CODINTER"),Cursor_fraziobo.GetString("CONNESOPER"))) {
                    /* _titexec := 1 */
                    _titexec = CPLib.Round(1,0);
                  } // End If
                  Cursor_qbe_co_titolari.Next();
                }
                m_cConnectivityError = Cursor_qbe_co_titolari.ErrorMessage();
                Cursor_qbe_co_titolari.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(fraziobo->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_fraziobo.GetString("CONNESOPER")))) {
              /* _tiposogg := iif(_titexec=1,'08',iif(fraziobo->TIPOLEG='6','07','03')) */
              _tiposogg = (CPLib.eqr(_titexec,1)?"08":(CPLib.eqr(Cursor_fraziobo.GetString("TIPOLEG"),"6")?"07":"03"));
              /* _connes := fraziobo->CONNESOPER */
              _connes = Cursor_fraziobo.GetString("CONNESOPER");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
            } // End If
            /* If not(Empty(fraziobo->CONNESBEN)) and fraziobo->CONNESBEN <> fraziobo->CONNESCLI */
            if ( ! (CPLib.Empty(Cursor_fraziobo.GetString("CONNESBEN"))) && CPLib.ne(Cursor_fraziobo.GetString("CONNESBEN"),Cursor_fraziobo.GetString("CONNESCLI"))) {
              /* _tiposogg := '06' */
              _tiposogg = "06";
              /* _connes := fraziobo->CONNESBEN */
              _connes = Cursor_fraziobo.GetString("CONNESBEN");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
            } // End If
            /* If Empty(fraziobo->CONNESBEN) and not(Empty(fraziobo->C_RAG)) */
            if (CPLib.Empty(Cursor_fraziobo.GetString("CONNESBEN")) &&  ! (CPLib.Empty(Cursor_fraziobo.GetString("C_RAG")))) {
              /* _prgsogg := _prgsogg + 1 */
              _prgsogg = CPLib.Round(_prgsogg+1,0);
              /* _contasogg := _contasogg + 1 */
              _contasogg = CPLib.Round(_contasogg+1,0);
              /* mcSoggetti.AppendBlank() */
              mcSoggetti.AppendBlank();
              /* mcSoggetti.CONTASOGG := _contaope */
              mcSoggetti.row.CONTASOGG = _contaope;
              /* mcSoggetti.CODICE_SEGNALANTE := _bpentseg */
              mcSoggetti.row.CODICE_SEGNALANTE = _bpentseg;
              /* mcSoggetti.DATA_CONTABILE := _cdatfin */
              mcSoggetti.row.DATA_CONTABILE = _cdatfin;
              /* mcSoggetti.ID_OPERAZIONE := _id_operazione */
              mcSoggetti.row.ID_OPERAZIONE = _id_operazione;
              /* mcSoggetti.PROG_SOGGETTO := _prgsogg */
              mcSoggetti.row.PROG_SOGGETTO = _prgsogg;
              /* mcSoggetti.CODICE_TIPO_SOGGETTO := '06' */
              mcSoggetti.row.CODICE_TIPO_SOGGETTO = "06";
              /* mcSoggetti.NATURA_GIURIDICA := 'NPF' */
              mcSoggetti.row.NATURA_GIURIDICA = "NPF";
              /* mcSoggetti.CODICE_FISCALE := Replicate('X',16) */
              mcSoggetti.row.CODICE_FISCALE = CPLib.Replicate("X",16);
              /* mcSoggetti.NPF_DENOMINAZIONE := arfn_agechar(LRTrim(fraziobo->C_RAG)," ") */
              mcSoggetti.row.NPF_DENOMINAZIONE = arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_fraziobo.GetString("C_RAG"))," ");
              /* If fraziobo->C_STA='086' */
              if (CPLib.eqr(Cursor_fraziobo.GetString("C_STA"),"086")) {
                /* mcSoggetti.NPF_SEDELEG_IND_COMUNE := fraziobo->C_CAB */
                mcSoggetti.row.NPF_SEDELEG_IND_COMUNE = Cursor_fraziobo.GetString("C_CAB");
              } // End If
              /* mcSoggetti.NPF_SEDELEG_IND_STATO := fraziobo->C_STA */
              mcSoggetti.row.NPF_SEDELEG_IND_STATO = Cursor_fraziobo.GetString("C_STA");
              /* mcSoggetti.SaveRow() */
              mcSoggetti.SaveRow();
            } // End If
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              /* _tiposogg := iif(Empty(fraziobo->CONNESOPER),'01','02') */
              _tiposogg = (CPLib.Empty(Cursor_fraziobo.GetString("CONNESOPER"))?"01":"02");
              /* _connes := clientifrz->CODSOG */
              _connes = Cursor_clientifrz.GetString("CODSOG");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              /* If Empty(_sesso) */
              if (CPLib.Empty(_sesso)) {
                // * --- Select from qbe_co_titolari
                SPBridge.HMCaller _h0000016C;
                _h0000016C = new SPBridge.HMCaller();
                _h0000016C.Set("m_cVQRList",m_cVQRList);
                _h0000016C.Set("pCODCLI",_connes);
                _h0000016C.Set("pDATOPE",Cursor_fraziobo.GetDate("DATAOPE"));
                if (Cursor_qbe_co_titolari!=null)
                  Cursor_qbe_co_titolari.Close();
                Cursor_qbe_co_titolari = new VQRHolder("qbe_co_titolari",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000016C,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_co_titolari.Eof())) {
                  /* _tiposogg := '04' */
                  _tiposogg = "04";
                  /* _connes := qbe_co_titolari->CODINTER */
                  _connes = Cursor_qbe_co_titolari.GetString("CODINTER");
                  /* Exec "Soggetti" Page 6:Soggetti */
                  Soggetti();
                  Cursor_qbe_co_titolari.Next();
                }
                m_cConnectivityError = Cursor_qbe_co_titolari.ErrorMessage();
                Cursor_qbe_co_titolari.Close();
                // * --- End Select
              } // End If
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              /* _tiposogg := iif(sogopefbo->LEGAME='6','07','03') */
              _tiposogg = (CPLib.eqr(Cursor_sogopefbo.GetString("LEGAME"),"6")?"07":"03");
              /* _connes := sogopefbo->CODSOG */
              _connes = Cursor_sogopefbo.GetString("CODSOG");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
            Cursor_fraziobo.Next();
          }
          m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
          Cursor_fraziobo.Close();
          // * --- End Select
          /* ElseIf qbe_co_operazioni_valide->TIPO='J' */
        } else if (CPLib.eqr(Cursor_qbe_co_operazioni_valide.GetString("TIPO"),"J")) {
          // * --- Select from jperazbo
          m_cServer = m_Ctx.GetServer("jperazbo");
          m_cPhName = m_Ctx.GetPhName("jperazbo");
          if (Cursor_jperazbo!=null)
            Cursor_jperazbo.Close();
          Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_co_operazioni_valide.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jperazbo.Eof())) {
            /* mcOperazioni.AppendBlank() */
            mcOperazioni.AppendBlank();
            /* mcOperazioni.CONTAOPE := _contaope */
            mcOperazioni.row.CONTAOPE = _contaope;
            /* mcOperazioni.CODICE_SEGNALANTE := _bpentseg */
            mcOperazioni.row.CODICE_SEGNALANTE = _bpentseg;
            /* mcOperazioni.DATA_CONTABILE := _cdatfin */
            mcOperazioni.row.DATA_CONTABILE = _cdatfin;
            /* mcOperazioni.ID_OPERAZIONE := _id_operazione */
            mcOperazioni.row.ID_OPERAZIONE = _id_operazione;
            /* mcOperazioni.DATA_CONT_OPERAZ := DateToChar(jperazbo->DATAOPE) */
            mcOperazioni.row.DATA_CONT_OPERAZ = CPLib.DateToChar(Cursor_jperazbo.GetDate("DATAOPE"));
            /* mcOperazioni.TIPO_OPERAZIONE := jperazbo->CODANA */
            mcOperazioni.row.TIPO_OPERAZIONE = Cursor_jperazbo.GetString("CODANA");
            /* mcOperazioni.SEGNO_OPERAZ := jperazbo->SEGNO */
            mcOperazioni.row.SEGNO_OPERAZ = Cursor_jperazbo.GetString("SEGNO");
            /* mcOperazioni.COD_VALUTA := jperazbo->VALUTA */
            mcOperazioni.row.COD_VALUTA = Cursor_jperazbo.GetString("VALUTA");
            /* mcOperazioni.IMPORTO_OPERAZ := jperazbo->TOTLIRE */
            mcOperazioni.row.IMPORTO_OPERAZ = Cursor_jperazbo.GetDouble("TOTLIRE");
            /* mcOperazioni.IMPORTO_CONT := iif(jperazbo->TOTCONT > 0,jperazbo->TOTCONT,iif((jperazbo->CODANA='I3' or jperazbo->CODANA='I4') and jperazbo->TOTCONT=0,jperazbo->TOTLIRE,jperazbo->TOTCONT)) */
            mcOperazioni.row.IMPORTO_CONT = (CPLib.gt(Cursor_jperazbo.GetDouble("TOTCONT"),0)?Cursor_jperazbo.GetDouble("TOTCONT"):((CPLib.eqr(Cursor_jperazbo.GetString("CODANA"),"I3") || CPLib.eqr(Cursor_jperazbo.GetString("CODANA"),"I4")) && CPLib.eqr(Cursor_jperazbo.GetDouble("TOTCONT"),0)?Cursor_jperazbo.GetDouble("TOTLIRE"):Cursor_jperazbo.GetDouble("TOTCONT")));
            /* If not(Empty(jperazbo->CODDIPE)) */
            if ( ! (CPLib.Empty(Cursor_jperazbo.GetString("CODDIPE")))) {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              if (Cursor_anadip!=null)
                Cursor_anadip.Close();
              Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anadip.Eof())) {
                /* _found := 1 */
                _found = CPLib.Round(1,0);
                /* mcOperazioni.CODICE_FILIALE := jperazbo->CODDIPE */
                mcOperazioni.row.CODICE_FILIALE = Cursor_jperazbo.GetString("CODDIPE");
                /* If not(Empty(anadip->CAB2)) */
                if ( ! (CPLib.Empty(Cursor_anadip.GetString("CAB2")))) {
                  /* mcOperazioni.UL_BANCARIA_CAB := anadip->CAB2 */
                  mcOperazioni.row.UL_BANCARIA_CAB = Cursor_anadip.GetString("CAB2");
                  /* mcOperazioni.COMUNE_ESEC := anadip->CAB */
                  mcOperazioni.row.COMUNE_ESEC = Cursor_anadip.GetString("CAB");
                } // End If
                Cursor_anadip.Next();
              }
              m_cConnectivityError = Cursor_anadip.ErrorMessage();
              Cursor_anadip.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                /* mcErrori.Errore := 'Dipendenza:' +LRTrim(jperazbo->CODDIPE) + ' - Codice Dipendenza Anomalo (Non presente in archivio dipendenze)' */
                mcErrori.row.Errore = "Dipendenza:"+CPLib.LRTrim(Cursor_jperazbo.GetString("CODDIPE"))+" - Codice Dipendenza Anomalo (Non presente in archivio dipendenze)";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* If not(Empty(jperazbo->RAPPORTO)) */
            if ( ! (CPLib.Empty(Cursor_jperazbo.GetString("RAPPORTO")))) {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from anarapbo
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              if (Cursor_anarapbo!=null)
                Cursor_anarapbo.Close();
              Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IBAN,CODOGG,RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_jperazbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_anarapbo.Eof())) {
                /* _found := 1 */
                _found = CPLib.Round(1,0);
                /* If Empty(anarapbo->CODOGG) */
                if (CPLib.Empty(Cursor_anarapbo.GetString("CODOGG"))) {
                  /* mcErrori.AppendBlank() */
                  mcErrori.AppendBlank();
                  /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                  mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                  /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                  mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                  /* mcErrori.Errore := 'Rapporto: '+LRTrim(anarapbo->RAPPORTO)+" - Assenza Codice Comunicazione Oggettiva" */
                  mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_anarapbo.GetString("RAPPORTO"))+" - Assenza Codice Comunicazione Oggettiva";
                  /* mcErrori.SaveRow() */
                  mcErrori.SaveRow();
                } else { // Else
                  /* mcOperazioni.CAT_RAPPORTO := anarapbo->CODOGG */
                  mcOperazioni.row.CAT_RAPPORTO = Cursor_anarapbo.GetString("CODOGG");
                  /* If anarapbo->CODOGG='028' */
                  if (CPLib.eqr(Cursor_anarapbo.GetString("CODOGG"),"028")) {
                    /* mcOperazioni.NUMERO_RAPPORTO := anarapbo->IBAN */
                    mcOperazioni.row.NUMERO_RAPPORTO = Cursor_anarapbo.GetString("IBAN");
                  } else { // Else
                    /* mcOperazioni.NUMERO_RAPPORTO := anarapbo->RAPPORTO */
                    mcOperazioni.row.NUMERO_RAPPORTO = Cursor_anarapbo.GetString("RAPPORTO");
                  } // End If
                  /* If not(Empty(_abicab)) */
                  if ( ! (CPLib.Empty(_abicab))) {
                    /* mcOperazioni.FILIALE := _abicab */
                    mcOperazioni.row.FILIALE = _abicab;
                  } // End If
                } // End If
                Cursor_anarapbo.Next();
              }
              m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
              Cursor_anarapbo.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := qbe_co_operazioni_valide->TIPO */
                mcErrori.row.colonna01 = Cursor_qbe_co_operazioni_valide.GetString("TIPO");
                /* mcErrori.colonna02 := qbe_co_operazioni_valide->NUMPROG */
                mcErrori.row.colonna02 = Cursor_qbe_co_operazioni_valide.GetString("NUMPROG");
                /* mcErrori.Errore := 'Rapporto: '+LRTrim(jperazbo->RAPPORTO)+' - Codice Rapporto Anomalo (Non presente in archivio rapporti)' */
                mcErrori.row.Errore = "Rapporto: "+CPLib.LRTrim(Cursor_jperazbo.GetString("RAPPORTO"))+" - Codice Rapporto Anomalo (Non presente in archivio rapporti)";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* mcCFOperazione.Zap() */
            mcCFOperazione.Zap();
            /* _prgsogg := 0 */
            _prgsogg = CPLib.Round(0,0);
            /* _titexec := 0 */
            _titexec = CPLib.Round(0,0);
            /* If not(Empty(jperazbo->CONNESCLI)) */
            if ( ! (CPLib.Empty(Cursor_jperazbo.GetString("CONNESCLI")))) {
              /* _tiposogg := iif(Empty(jperazbo->CONNESOPER),'01','02') */
              _tiposogg = (CPLib.Empty(Cursor_jperazbo.GetString("CONNESOPER"))?"01":"02");
              /* _connes := jperazbo->CONNESCLI */
              _connes = Cursor_jperazbo.GetString("CONNESCLI");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
              /* If Empty(_sesso) */
              if (CPLib.Empty(_sesso)) {
                // * --- Select from qbe_co_titolari
                SPBridge.HMCaller _h000001AC;
                _h000001AC = new SPBridge.HMCaller();
                _h000001AC.Set("m_cVQRList",m_cVQRList);
                _h000001AC.Set("pCODCLI",_connes);
                _h000001AC.Set("pDATOPE",Cursor_jperazbo.GetDate("DATAOPE"));
                if (Cursor_qbe_co_titolari!=null)
                  Cursor_qbe_co_titolari.Close();
                Cursor_qbe_co_titolari = new VQRHolder("qbe_co_titolari",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001AC,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_co_titolari.Eof())) {
                  /* _tiposogg := '04' */
                  _tiposogg = "04";
                  /* If Empty(jperazbo->CONNESOPER) or (not(Empty(jperazbo->CONNESOPER)) and qbe_co_titolari->CODINTER <> jperazbo->CONNESOPER) */
                  if (CPLib.Empty(Cursor_jperazbo.GetString("CONNESOPER")) || ( ! (CPLib.Empty(Cursor_jperazbo.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_co_titolari.GetString("CODINTER"),Cursor_jperazbo.GetString("CONNESOPER")))) {
                    /* _connes := qbe_co_titolari->CODINTER */
                    _connes = Cursor_qbe_co_titolari.GetString("CODINTER");
                    /* Exec "Soggetti" Page 6:Soggetti */
                    Soggetti();
                    /* ElseIf not(Empty(jperazbo->CONNESOPER)) and qbe_co_titolari->CODINTER = jperazbo->CONNESOPER */
                  } else if ( ! (CPLib.Empty(Cursor_jperazbo.GetString("CONNESOPER"))) && CPLib.eqr(Cursor_qbe_co_titolari.GetString("CODINTER"),Cursor_jperazbo.GetString("CONNESOPER"))) {
                    /* _titexec := 1 */
                    _titexec = CPLib.Round(1,0);
                  } // End If
                  Cursor_qbe_co_titolari.Next();
                }
                m_cConnectivityError = Cursor_qbe_co_titolari.ErrorMessage();
                Cursor_qbe_co_titolari.Close();
                // * --- End Select
              } // End If
            } // End If
            /* If not(Empty(jperazbo->CONNESOPER)) */
            if ( ! (CPLib.Empty(Cursor_jperazbo.GetString("CONNESOPER")))) {
              /* _tiposogg := iif(_titexec=1,'08',iif(jperazbo->TIPOLEG='6','07','03')) */
              _tiposogg = (CPLib.eqr(_titexec,1)?"08":(CPLib.eqr(Cursor_jperazbo.GetString("TIPOLEG"),"6")?"07":"03"));
              /* _connes := jperazbo->CONNESOPER */
              _connes = Cursor_jperazbo.GetString("CONNESOPER");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
            } // End If
            /* If not(Empty(jperazbo->CONNESBEN)) and jperazbo->CONNESBEN <> jperazbo->CONNESCLI */
            if ( ! (CPLib.Empty(Cursor_jperazbo.GetString("CONNESBEN"))) && CPLib.ne(Cursor_jperazbo.GetString("CONNESBEN"),Cursor_jperazbo.GetString("CONNESCLI"))) {
              /* _tiposogg := '06' */
              _tiposogg = "06";
              /* _connes := jperazbo->CONNESBEN */
              _connes = Cursor_jperazbo.GetString("CONNESBEN");
              /* Exec "Soggetti" Page 6:Soggetti */
              Soggetti();
            } // End If
            /* If Empty(jperazbo->CONNESBEN) and not(Empty(jperazbo->C_RAG)) */
            if (CPLib.Empty(Cursor_jperazbo.GetString("CONNESBEN")) &&  ! (CPLib.Empty(Cursor_jperazbo.GetString("C_RAG")))) {
              /* _prgsogg := _prgsogg + 1 */
              _prgsogg = CPLib.Round(_prgsogg+1,0);
              /* _contasogg := _contasogg + 1 */
              _contasogg = CPLib.Round(_contasogg+1,0);
              /* mcSoggetti.AppendBlank() */
              mcSoggetti.AppendBlank();
              /* mcSoggetti.CONTASOGG := _contaope */
              mcSoggetti.row.CONTASOGG = _contaope;
              /* mcSoggetti.CODICE_SEGNALANTE := _bpentseg */
              mcSoggetti.row.CODICE_SEGNALANTE = _bpentseg;
              /* mcSoggetti.DATA_CONTABILE := _cdatfin */
              mcSoggetti.row.DATA_CONTABILE = _cdatfin;
              /* mcSoggetti.ID_OPERAZIONE := _id_operazione */
              mcSoggetti.row.ID_OPERAZIONE = _id_operazione;
              /* mcSoggetti.PROG_SOGGETTO := _prgsogg */
              mcSoggetti.row.PROG_SOGGETTO = _prgsogg;
              /* mcSoggetti.CODICE_TIPO_SOGGETTO := '06' */
              mcSoggetti.row.CODICE_TIPO_SOGGETTO = "06";
              /* mcSoggetti.NATURA_GIURIDICA := 'NPF' */
              mcSoggetti.row.NATURA_GIURIDICA = "NPF";
              /* mcSoggetti.CODICE_FISCALE := Replicate('X',16) */
              mcSoggetti.row.CODICE_FISCALE = CPLib.Replicate("X",16);
              /* mcSoggetti.NPF_DENOMINAZIONE := arfn_agechar(LRTrim(jperazbo->C_RAG)," ") */
              mcSoggetti.row.NPF_DENOMINAZIONE = arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(Cursor_jperazbo.GetString("C_RAG"))," ");
              /* If jperazbo->C_STA='086' */
              if (CPLib.eqr(Cursor_jperazbo.GetString("C_STA"),"086")) {
                /* mcSoggetti.NPF_SEDELEG_IND_COMUNE := jperazbo->C_CAB */
                mcSoggetti.row.NPF_SEDELEG_IND_COMUNE = Cursor_jperazbo.GetString("C_CAB");
              } // End If
              /* mcSoggetti.NPF_SEDELEG_IND_STATO := jperazbo->C_STA */
              mcSoggetti.row.NPF_SEDELEG_IND_STATO = Cursor_jperazbo.GetString("C_STA");
              /* mcSoggetti.SaveRow() */
              mcSoggetti.SaveRow();
            } // End If
            Cursor_jperazbo.Next();
          }
          m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
          Cursor_jperazbo.Close();
          // * --- End Select
        } // End If
        /* _contaope := _contaope + 1 */
        _contaope = CPLib.Round(_contaope+1,0);
        /* _id_operazione := _id_operazione + 1 */
        _id_operazione = CPLib.Round(_id_operazione+1,0);
        Cursor_qbe_co_operazioni_valide.Next();
      }
      m_cConnectivityError = Cursor_qbe_co_operazioni_valide.ErrorMessage();
      Cursor_qbe_co_operazioni_valide.Close();
      // * --- End Select
      /* _testo := '<cube lastObsId="'+LRTrim(Str(_contaope-1,10,0))+'" id="OGG_OPERAZIONE" xmlns="http://www.bancaditalia.it/bolina/common/vo/cube">' */
      _testo = "<cube lastObsId=\""+CPLib.LRTrim(CPLib.Str(_contaope-1,10,0))+"\" id=\"OGG_OPERAZIONE\" xmlns=\"http://www.bancaditalia.it/bolina/common/vo/cube\">";
      /* FileLibMit.WriteLine(fhand,_testo) */
      FileLibMit.WriteLine(fhand,_testo);
      for (MemoryCursorRow_mcoperazionico_mcrdef rwOperazioni : mcOperazioni._iterable_()) {
        /* _testo := '<obs id="'+LRTrim(Str(rwOperazioni.CONTAOPE,10,0))+'">' + NL */
        _testo = "<obs id=\""+CPLib.LRTrim(CPLib.Str(rwOperazioni.CONTAOPE,10,0))+"\">"+"\n";
        /* _testo := _testo + '<dim name="CODICE_SEGNALANTE" value="'+LRTrim(rwOperazioni.CODICE_SEGNALANTE)+'"/>' + NL */
        _testo = _testo+"<dim name=\"CODICE_SEGNALANTE\" value=\""+CPLib.LRTrim(rwOperazioni.CODICE_SEGNALANTE)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="DATA_CONTABILE" value="'+DateToChar(rwOperazioni.DATA_CONTABILE)+'"/>' + NL */
        _testo = _testo+"<dim name=\"DATA_CONTABILE\" value=\""+CPLib.DateToChar(rwOperazioni.DATA_CONTABILE)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="ID_OPERAZIONE" value="'+LRTrim(Str(rwOperazioni.ID_OPERAZIONE,10,0))+'"/>' + NL */
        _testo = _testo+"<dim name=\"ID_OPERAZIONE\" value=\""+CPLib.LRTrim(CPLib.Str(rwOperazioni.ID_OPERAZIONE,10,0))+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="DATA_CONT_OPERAZ" value="'+DateToChar(rwOperazioni.DATA_CONT_OPERAZ)+'"/>' + NL */
        _testo = _testo+"<dim name=\"DATA_CONT_OPERAZ\" value=\""+CPLib.DateToChar(rwOperazioni.DATA_CONT_OPERAZ)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="TIPO_OPERAZIONE" value="'+LRTrim(rwOperazioni.TIPO_OPERAZIONE)+'"/>' + NL */
        _testo = _testo+"<dim name=\"TIPO_OPERAZIONE\" value=\""+CPLib.LRTrim(rwOperazioni.TIPO_OPERAZIONE)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="SEGNO_OPERAZ" value="'+LRTrim(rwOperazioni.SEGNO_OPERAZ)+'"/>' + NL */
        _testo = _testo+"<dim name=\"SEGNO_OPERAZ\" value=\""+CPLib.LRTrim(rwOperazioni.SEGNO_OPERAZ)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="COD_VALUTA" value="'+LRTrim(rwOperazioni.COD_VALUTA)+'"/>' + NL */
        _testo = _testo+"<dim name=\"COD_VALUTA\" value=\""+CPLib.LRTrim(rwOperazioni.COD_VALUTA)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="IMPORTO_OPERAZ" value="'+LRTrim(Str(Int(rwOperazioni.IMPORTO_OPERAZ/100),10,0))+'"/>' + NL */
        _testo = _testo+"<dim name=\"IMPORTO_OPERAZ\" value=\""+CPLib.LRTrim(CPLib.Str(CPLib.Int(rwOperazioni.IMPORTO_OPERAZ/100),10,0))+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="IMPORTO_CONT" value="'+LRTrim(Str(Int(rwOperazioni.IMPORTO_CONT/100),10,0))+'"/>' + NL */
        _testo = _testo+"<dim name=\"IMPORTO_CONT\" value=\""+CPLib.LRTrim(CPLib.Str(CPLib.Int(rwOperazioni.IMPORTO_CONT/100),10,0))+"\"/>"+"\n";
        /* If not(Empty(LRTrim(rwOperazioni.CODICE_FILIALE))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(rwOperazioni.CODICE_FILIALE)))) {
          /* _testo := _testo + '<dim name="CODICE_FILIALE" value="'+LRTrim(rwOperazioni.CODICE_FILIALE)+'"/>' + NL */
          _testo = _testo+"<dim name=\"CODICE_FILIALE\" value=\""+CPLib.LRTrim(rwOperazioni.CODICE_FILIALE)+"\"/>"+"\n";
        } // End If
        /* If not(Empty(rwOperazioni.UL_BANCARIA_CAB)) */
        if ( ! (CPLib.Empty(rwOperazioni.UL_BANCARIA_CAB))) {
          /* _testo := _testo +'<dim name="UL_BANCARIA_CAB" value="'+LRTrim(rwOperazioni.UL_BANCARIA_CAB)+'"/>' + NL */
          _testo = _testo+"<dim name=\"UL_BANCARIA_CAB\" value=\""+CPLib.LRTrim(rwOperazioni.UL_BANCARIA_CAB)+"\"/>"+"\n";
          /* _testo := _testo + '<dim name="COMUNE_ESEC" value="'+LRTrim(rwOperazioni.COMUNE_ESEC)+'"/>' + NL */
          _testo = _testo+"<dim name=\"COMUNE_ESEC\" value=\""+CPLib.LRTrim(rwOperazioni.COMUNE_ESEC)+"\"/>"+"\n";
        } // End If
        /* If not(Empty(rwOperazioni.CAT_RAPPORTO)) */
        if ( ! (CPLib.Empty(rwOperazioni.CAT_RAPPORTO))) {
          /* _testo := _testo + '<dim name="CAT_RAPPORTO" value="'+LRTrim(rwOperazioni.CAT_RAPPORTO)+'"/>' + NL */
          _testo = _testo+"<dim name=\"CAT_RAPPORTO\" value=\""+CPLib.LRTrim(rwOperazioni.CAT_RAPPORTO)+"\"/>"+"\n";
          /* _testo := _testo + '<dim name="NUMERO_RAPPORTO" value="'+LRTrim(rwOperazioni.NUMERO_RAPPORTO)+'"/>'+NL */
          _testo = _testo+"<dim name=\"NUMERO_RAPPORTO\" value=\""+CPLib.LRTrim(rwOperazioni.NUMERO_RAPPORTO)+"\"/>"+"\n";
          /* If not(Empty(rwOperazioni.FILIALE)) */
          if ( ! (CPLib.Empty(rwOperazioni.FILIALE))) {
            /* _testo := _testo + '<dim name="FILIALE" value="'+LRTrim(rwOperazioni.FILIALE)+'"/>'+NL */
            _testo = _testo+"<dim name=\"FILIALE\" value=\""+CPLib.LRTrim(rwOperazioni.FILIALE)+"\"/>"+"\n";
          } // End If
        } // End If
        /* _testo := _testo + '</obs>' + NL */
        _testo = _testo+"</obs>"+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
      }
      /* _testo := '</cube>' */
      _testo = "</cube>";
      /* FileLibMit.WriteLine(fhand,_testo) */
      FileLibMit.WriteLine(fhand,_testo);
      /* _testo := '<cube lastObsId="'+LRTrim(Str(_contasogg-1,10,0))+'" id="OGG_SOGGETTO" xmlns="http://www.bancaditalia.it/bolina/common/vo/cube">' */
      _testo = "<cube lastObsId=\""+CPLib.LRTrim(CPLib.Str(_contasogg-1,10,0))+"\" id=\"OGG_SOGGETTO\" xmlns=\"http://www.bancaditalia.it/bolina/common/vo/cube\">";
      /* FileLibMit.WriteLine(fhand,_testo) */
      FileLibMit.WriteLine(fhand,_testo);
      for (MemoryCursorRow_mcsoggettico_mcrdef rwSoggetti : mcSoggetti._iterable_()) {
        /* _testo := '<obs id="'+LRTrim(Str(rwSoggetti.CONTASOGG,10,0))+'">' + NL */
        _testo = "<obs id=\""+CPLib.LRTrim(CPLib.Str(rwSoggetti.CONTASOGG,10,0))+"\">"+"\n";
        /* _testo := _testo + '<dim name="CODICE_SEGNALANTE" value="'+LRTrim(rwSoggetti.CODICE_SEGNALANTE)+'"/>' + NL */
        _testo = _testo+"<dim name=\"CODICE_SEGNALANTE\" value=\""+CPLib.LRTrim(rwSoggetti.CODICE_SEGNALANTE)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="DATA_CONTABILE" value="'+DateToChar(rwSoggetti.DATA_CONTABILE)+'"/>' + NL */
        _testo = _testo+"<dim name=\"DATA_CONTABILE\" value=\""+CPLib.DateToChar(rwSoggetti.DATA_CONTABILE)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="ID_OPERAZIONE" value="'+LRTrim(Str(rwSoggetti.ID_OPERAZIONE,10,0))+'"/>' + NL */
        _testo = _testo+"<dim name=\"ID_OPERAZIONE\" value=\""+CPLib.LRTrim(CPLib.Str(rwSoggetti.ID_OPERAZIONE,10,0))+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="PROG_SOGGETTO" value="'+LRTrim(Str(rwSoggetti.PROG_SOGGETTO,10,0))+'"/>' + NL */
        _testo = _testo+"<dim name=\"PROG_SOGGETTO\" value=\""+CPLib.LRTrim(CPLib.Str(rwSoggetti.PROG_SOGGETTO,10,0))+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="CODICE_TIPO_SOGGETTO" value="'+LRTrim(rwSoggetti.CODICE_TIPO_SOGGETTO)+'"/>' + NL */
        _testo = _testo+"<dim name=\"CODICE_TIPO_SOGGETTO\" value=\""+CPLib.LRTrim(rwSoggetti.CODICE_TIPO_SOGGETTO)+"\"/>"+"\n";
        /* _testo := _testo +'<dim name="NATURA_GIURIDICA" value="'+LRTrim(rwSoggetti.NATURA_GIURIDICA)+'"/>'+NL */
        _testo = _testo+"<dim name=\"NATURA_GIURIDICA\" value=\""+CPLib.LRTrim(rwSoggetti.NATURA_GIURIDICA)+"\"/>"+"\n";
        /* _testo := _testo + '<dim name="CODICE_FISCALE" value="'+LRTrim(rwSoggetti.CODICE_FISCALE)+'"/>' + NL */
        _testo = _testo+"<dim name=\"CODICE_FISCALE\" value=\""+CPLib.LRTrim(rwSoggetti.CODICE_FISCALE)+"\"/>"+"\n";
        /* If not(Empty(rwSoggetti.SGRP_ATTIVITA_EC)) */
        if ( ! (CPLib.Empty(rwSoggetti.SGRP_ATTIVITA_EC))) {
          /* _testo := _testo + '<dim name="SGRP_ATTIVITA_EC" value="'+LRTrim(rwSoggetti.SGRP_ATTIVITA_EC)+'"/>' + NL */
          _testo = _testo+"<dim name=\"SGRP_ATTIVITA_EC\" value=\""+CPLib.LRTrim(rwSoggetti.SGRP_ATTIVITA_EC)+"\"/>"+"\n";
        } // End If
        /* If not(Empty(rwSoggetti.CODICE_ATECO)) */
        if ( ! (CPLib.Empty(rwSoggetti.CODICE_ATECO))) {
          /* _testo := _testo + '<dim name="CODICE_ATECO" value="'+LRTrim(rwSoggetti.CODICE_ATECO)+'"/>' + NL */
          _testo = _testo+"<dim name=\"CODICE_ATECO\" value=\""+CPLib.LRTrim(rwSoggetti.CODICE_ATECO)+"\"/>"+"\n";
        } // End If
        /* If LRTrim(rwSoggetti.NATURA_GIURIDICA)='NPF' */
        if (CPLib.eqr(CPLib.LRTrim(rwSoggetti.NATURA_GIURIDICA),"NPF")) {
          /* _testo := _testo + '<dim name="NPF_DENOMINAZIONE" value="'+arfn_agechar(LRTrim(rwSoggetti.NPF_DENOMINAZIONE)," ")+'"/>' + NL */
          _testo = _testo+"<dim name=\"NPF_DENOMINAZIONE\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.NPF_DENOMINAZIONE)," ")+"\"/>"+"\n";
          /* If not(Empty(rwSoggetti.NPF_SEDELEG_IND_COMUNE)) */
          if ( ! (CPLib.Empty(rwSoggetti.NPF_SEDELEG_IND_COMUNE))) {
            /* _testo := _testo + '<dim name="NPF_SEDELEG_IND_COMUNE" value="'+arfn_agechar(LRTrim(rwSoggetti.NPF_SEDELEG_IND_COMUNE)," ")+'"/>' + NL */
            _testo = _testo+"<dim name=\"NPF_SEDELEG_IND_COMUNE\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.NPF_SEDELEG_IND_COMUNE)," ")+"\"/>"+"\n";
          } // End If
          /* _testo := _testo + '<dim name="NPF_SEDELEG_IND_STATO" value="'+arfn_agechar(LRTrim(rwSoggetti.NPF_SEDELEG_IND_STATO)," ")+'"/>' + NL */
          _testo = _testo+"<dim name=\"NPF_SEDELEG_IND_STATO\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.NPF_SEDELEG_IND_STATO)," ")+"\"/>"+"\n";
        } else { // Else
          /* _testo := _testo + '<dim name="PF_NOME" value="'+arfn_agechar(LRTrim(rwSoggetti.PF_NOME)," ")+'"/>' + NL */
          _testo = _testo+"<dim name=\"PF_NOME\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.PF_NOME)," ")+"\"/>"+"\n";
          /* _testo := _testo + '<dim name="PF_COGNOME" value="'+arfn_agechar(LRTrim(rwSoggetti.PF_COGNOME)," ")+'"/>' + NL */
          _testo = _testo+"<dim name=\"PF_COGNOME\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.PF_COGNOME)," ")+"\"/>"+"\n";
          /* _testo := _testo + '<dim name="PF_SESSO" value="'+LRTrim(rwSoggetti.PF_SESSO)+'"/>' + NL */
          _testo = _testo+"<dim name=\"PF_SESSO\" value=\""+CPLib.LRTrim(rwSoggetti.PF_SESSO)+"\"/>"+"\n";
          /* _testo := _testo + '<dim name="PF_DATANASCITA" value="'+DateToChar(rwSoggetti.PF_DATANASCITA)+'"/>' + NL */
          _testo = _testo+"<dim name=\"PF_DATANASCITA\" value=\""+CPLib.DateToChar(rwSoggetti.PF_DATANASCITA)+"\"/>"+"\n";
          /* If not(Empty(rwSoggetti.PF_STATONASCITA)) */
          if ( ! (CPLib.Empty(rwSoggetti.PF_STATONASCITA))) {
            /* _testo := _testo + '<dim name="PF_STATONASCITA" value="'+arfn_agechar(LRTrim(rwSoggetti.PF_STATONASCITA)," ")+'"/>' + NL */
            _testo = _testo+"<dim name=\"PF_STATONASCITA\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.PF_STATONASCITA)," ")+"\"/>"+"\n";
          } // End If
          /* If not(Empty(rwSoggetti.PF_COMUNENASCITA)) */
          if ( ! (CPLib.Empty(rwSoggetti.PF_COMUNENASCITA))) {
            /* _testo := _testo + '<dim name="PF_COMUNENASCITA" value="'+LRTrim(rwSoggetti.PF_COMUNENASCITA)+'"/>' + NL */
            _testo = _testo+"<dim name=\"PF_COMUNENASCITA\" value=\""+CPLib.LRTrim(rwSoggetti.PF_COMUNENASCITA)+"\"/>"+"\n";
          } // End If
          /* If not(Empty(rwSoggetti.PF_IND_COMUNE)) */
          if ( ! (CPLib.Empty(rwSoggetti.PF_IND_COMUNE))) {
            /* _testo := _testo + '<dim name="PF_IND_COMUNE" value="'+arfn_agechar(LRTrim(rwSoggetti.PF_IND_COMUNE)," ")+'"/>' + NL */
            _testo = _testo+"<dim name=\"PF_IND_COMUNE\" value=\""+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwSoggetti.PF_IND_COMUNE)," ")+"\"/>"+"\n";
          } // End If
          /* _testo := _testo + '<dim name="PF_IND_STATO" value="'+LRTrim(rwSoggetti.PF_IND_STATO)+'"/>' + NL */
          _testo = _testo+"<dim name=\"PF_IND_STATO\" value=\""+CPLib.LRTrim(rwSoggetti.PF_IND_STATO)+"\"/>"+"\n";
          /* _testo := _testo + '<dim name="PF_POLITIC_ESPOSTA" value="'+LRTrim(rwSoggetti.PF_POLITIC_ESPOSTA)+'"/>' + NL */
          _testo = _testo+"<dim name=\"PF_POLITIC_ESPOSTA\" value=\""+CPLib.LRTrim(rwSoggetti.PF_POLITIC_ESPOSTA)+"\"/>"+"\n";
        } // End If
        /* _testo := _testo + '</obs>' + NL */
        _testo = _testo+"</obs>"+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
      }
      /* _testo := '</cube>' */
      _testo = "</cube>";
      /* FileLibMit.WriteLine(fhand,_testo) */
      FileLibMit.WriteLine(fhand,_testo);
    } finally {
      try {
        if (Cursor_qbe_co_operazioni_valide!=null)
          Cursor_qbe_co_operazioni_valide.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_co_titolari!=null)
          Cursor_qbe_co_titolari.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jperazbo!=null)
          Cursor_jperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Soggetti() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* _sesso := '' */
      _sesso = "";
      /* _found := 0 */
      _found = CPLib.Round(0,0);
      /* _cfexist := 0 */
      _cfexist = CPLib.Round(0,0);
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* _found := 1 */
        _found = CPLib.Round(1,0);
        for (MemoryCursorRow_mcconnes_mcrdef rwCFOperazione : mcCFOperazione._iterable_()) {
          /* If LRTrim(rwCFOperazione.connes) = LRTrim(personbo->CODFISC) */
          if (CPLib.eqr(CPLib.LRTrim(rwCFOperazione.connes),CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")))) {
            /* _cfexist := 1 */
            _cfexist = CPLib.Round(1,0);
          } // End If
        }
        /* If _cfexist = 0 */
        if (CPLib.eqr(_cfexist,0)) {
          /* _prgsogg := _prgsogg + 1 */
          _prgsogg = CPLib.Round(_prgsogg+1,0);
          /* _contasogg := _contasogg + 1 */
          _contasogg = CPLib.Round(_contasogg+1,0);
          /* _sesso := personbo->SESSO */
          _sesso = Cursor_personbo.GetString("SESSO");
          /* mcSoggetti.AppendBlank() */
          mcSoggetti.AppendBlank();
          /* mcSoggetti.CONTASOGG := _contasogg */
          mcSoggetti.row.CONTASOGG = _contasogg;
          /* mcSoggetti.CODICE_SEGNALANTE := _bpentseg */
          mcSoggetti.row.CODICE_SEGNALANTE = _bpentseg;
          /* mcSoggetti.DATA_CONTABILE := _cdatfin */
          mcSoggetti.row.DATA_CONTABILE = _cdatfin;
          /* mcSoggetti.ID_OPERAZIONE := _id_operazione */
          mcSoggetti.row.ID_OPERAZIONE = _id_operazione;
          /* mcSoggetti.PROG_SOGGETTO := _prgsogg */
          mcSoggetti.row.PROG_SOGGETTO = _prgsogg;
          /* mcSoggetti.CODICE_TIPO_SOGGETTO := _tiposogg */
          mcSoggetti.row.CODICE_TIPO_SOGGETTO = _tiposogg;
          /* mcSoggetti.NATURA_GIURIDICA := iif(not(Empty(personbo->SESSO)),'PF','NPF') */
          mcSoggetti.row.NATURA_GIURIDICA = ( ! (CPLib.Empty(Cursor_personbo.GetString("SESSO")))?"PF":"NPF");
          /* mcSoggetti.CODICE_FISCALE := iif(personbo->CFESTERO=1,Replicate('X',16),personbo->CODFISC) */
          mcSoggetti.row.CODICE_FISCALE = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Replicate("X",16):Cursor_personbo.GetString("CODFISC"));
          /* If _tiposogg='01' or _tiposogg='02' */
          if (CPLib.eqr(_tiposogg,"01") || CPLib.eqr(_tiposogg,"02")) {
            /* mcSoggetti.SGRP_ATTIVITA_EC := personbo->SOTGRUP */
            mcSoggetti.row.SGRP_ATTIVITA_EC = Cursor_personbo.GetString("SOTGRUP");
            /* If not(Empty(personbo->ATTIV)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("ATTIV")))) {
              /* mcSoggetti.CODICE_ATECO := Left(LRTrim(personbo->ATTIV),4) */
              mcSoggetti.row.CODICE_ATECO = CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("ATTIV")),4);
            } // End If
          } // End If
          /* If Empty(personbo->SESSO) */
          if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
            /* mcSoggetti.NPF_DENOMINAZIONE := LRTrim(Left(arfn_agechar(personbo->RAGSOC," "),40)) */
            mcSoggetti.row.NPF_DENOMINAZIONE = CPLib.LRTrim(CPLib.Left(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "),40));
            /* mcSoggetti.NPF_SEDELEG_IND_COMUNE := personbo->CODCAB */
            mcSoggetti.row.NPF_SEDELEG_IND_COMUNE = Cursor_personbo.GetString("CODCAB");
            /* mcSoggetti.NPF_SEDELEG_IND_STATO := personbo->PAESE */
            mcSoggetti.row.NPF_SEDELEG_IND_STATO = Cursor_personbo.GetString("PAESE");
          } else { // Else
            /* mcSoggetti.PF_NOME := LRTrim(Left(arfn_agechar(personbo->NOME," "),30)) */
            mcSoggetti.row.PF_NOME = CPLib.LRTrim(CPLib.Left(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NOME")," "),30));
            /* mcSoggetti.PF_COGNOME := LRTrim(Left(arfn_agechar(personbo->COGNOME," "),30)) */
            mcSoggetti.row.PF_COGNOME = CPLib.LRTrim(CPLib.Left(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("COGNOME")," "),30));
            /* mcSoggetti.PF_SESSO := iif(personbo->SESSO='M' or personbo->SESSO='1','M','F') */
            mcSoggetti.row.PF_SESSO = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"M") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"M":"F");
            /* mcSoggetti.PF_DATANASCITA := DateToChar(personbo->DATANASC) */
            mcSoggetti.row.PF_DATANASCITA = CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC"));
            /* If personbo->TIPINTER='EE' */
            if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
              /* _codsta := '' */
              _codsta = "";
              // * --- Read from tbstatna
              m_cServer = m_Ctx.GetServer("tbstatna");
              m_cPhName = m_Ctx.GetPhName("tbstatna");
              m_cSql = "";
              m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO")));
              if (m_Ctx.IsSharedTemp("tbstatna")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codsta = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstatna into routine arfn_com_oggettive returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codsta = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* mcSoggetti.PF_STATONASCITA := _codsta */
              mcSoggetti.row.PF_STATONASCITA = _codsta;
              /* If Empty(_codsta) */
              if (CPLib.Empty(_codsta)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := _tipo */
                mcErrori.row.colonna01 = _tipo;
                /* mcErrori.colonna02 := _numprog */
                mcErrori.row.colonna02 = _numprog;
                /* mcErrori.Errore := 'Soggetto: '+LRTrim(personbo->RAGSOC)+ "("+LRTrim(personbo->CONNES)+") : stato di nascita anomalo" */
                mcErrori.row.Errore = "Soggetto: "+CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+"("+CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+") : stato di nascita anomalo";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } else { // Else
              /* _cabnas := '' */
              _cabnas = "";
              // * --- Read from tbcittna
              m_cServer = m_Ctx.GetServer("tbcittna");
              m_cPhName = m_Ctx.GetPhName("tbcittna");
              m_cSql = "";
              m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")),"C",60,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_personbo.GetString("NASCOMUN")));
              m_cSql = m_cSql+" and PROV="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_personbo.GetString("TIPINTER")),"C",2,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_personbo.GetString("TIPINTER")));
              if (m_Ctx.IsSharedTemp("tbcittna")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cabnas = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcittna into routine arfn_com_oggettive returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cabnas = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* mcSoggetti.PF_COMUNENASCITA := _cabnas */
              mcSoggetti.row.PF_COMUNENASCITA = _cabnas;
              /* mcSoggetti.PF_STATONASCITA := '086' */
              mcSoggetti.row.PF_STATONASCITA = "086";
              /* If Empty(_cabnas) */
              if (CPLib.Empty(_cabnas)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := _tipo */
                mcErrori.row.colonna01 = _tipo;
                /* mcErrori.colonna02 := _numprog */
                mcErrori.row.colonna02 = _numprog;
                /* mcErrori.Errore := 'Soggetto: '+LRTrim(personbo->RAGSOC)+ "("+LRTrim(personbo->CONNES)+") : comune di nascita anomalo" */
                mcErrori.row.Errore = "Soggetto: "+CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+"("+CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+") : comune di nascita anomalo";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
            /* mcSoggetti.PF_IND_COMUNE := personbo->CODCAB */
            mcSoggetti.row.PF_IND_COMUNE = Cursor_personbo.GetString("CODCAB");
            /* If Empty(personbo->CODCAB) and (personbo->PAESE = '086' or Empty(personbo->PAESE)) */
            if (CPLib.Empty(Cursor_personbo.GetString("CODCAB")) && (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.Empty(Cursor_personbo.GetString("PAESE")))) {
              /* mcErrori.AppendBlank() */
              mcErrori.AppendBlank();
              /* mcErrori.colonna01 := _tipo */
              mcErrori.row.colonna01 = _tipo;
              /* mcErrori.colonna02 := _numprog */
              mcErrori.row.colonna02 = _numprog;
              /* mcErrori.Errore := 'Soggetto: '+LRTrim(personbo->RAGSOC)+ "("+LRTrim(personbo->CONNES)+") : cab di residenza anomalo" */
              mcErrori.row.Errore = "Soggetto: "+CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"))+"("+CPLib.LRTrim(Cursor_personbo.GetString("CONNES"))+") : cab di residenza anomalo";
              /* mcErrori.SaveRow() */
              mcErrori.SaveRow();
            } // End If
            /* mcSoggetti.PF_IND_STATO := personbo->PAESE */
            mcSoggetti.row.PF_IND_STATO = Cursor_personbo.GetString("PAESE");
            /* mcSoggetti.PF_POLITIC_ESPOSTA := iif(personbo->PEP='S','SI','NO') */
            mcSoggetti.row.PF_POLITIC_ESPOSTA = (CPLib.eqr(Cursor_personbo.GetString("PEP"),"S")?"SI":"NO");
          } // End If
          /* mcCFOperazione.AppendBlank() */
          mcCFOperazione.AppendBlank();
          /* mcCFOperazione.connes := personbo->CODFISC */
          mcCFOperazione.row.connes = Cursor_personbo.GetString("CODFISC");
          /* mcCFOperazione.SaveRow() */
          mcCFOperazione.SaveRow();
        } // End If
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      /* If _found=0 */
      if (CPLib.eqr(_found,0)) {
        /* mcErrori.AppendBlank() */
        mcErrori.AppendBlank();
        /* mcErrori.colonna01 := _tipo */
        mcErrori.row.colonna01 = _tipo;
        /* mcErrori.colonna02 := _numprog */
        mcErrori.row.colonna02 = _numprog;
        /* If _tiposogg='01' or _tiposogg='02' */
        if (CPLib.eqr(_tiposogg,"01") || CPLib.eqr(_tiposogg,"02")) {
          /* mcErrori.Errore := 'Codice Cliente Anomalo (Non presente in archivio soggetti)' */
          mcErrori.row.Errore = "Codice Cliente Anomalo (Non presente in archivio soggetti)";
        } // End If
        /* If _tiposogg='03' or _tiposogg='07' */
        if (CPLib.eqr(_tiposogg,"03") || CPLib.eqr(_tiposogg,"07")) {
          /* mcErrori.Errore := 'Codice Soggetto Operante/Fiduciario Anomalo (Non presente in archivio soggetti)' */
          mcErrori.row.Errore = "Codice Soggetto Operante/Fiduciario Anomalo (Non presente in archivio soggetti)";
        } // End If
        /* If _tiposogg='04' */
        if (CPLib.eqr(_tiposogg,"04")) {
          /* mcErrori.Errore := 'Codice Titolare Effettivo/Cointestatario Anomalo (Non presente in archivio soggetti)' */
          mcErrori.row.Errore = "Codice Titolare Effettivo/Cointestatario Anomalo (Non presente in archivio soggetti)";
        } // End If
        /* If _tiposogg='06' */
        if (CPLib.eqr(_tiposogg,"06")) {
          /* mcErrori.Errore := 'Codice Controparte Anomalo (Non presente in archivio soggetti)' */
          mcErrori.row.Errore = "Codice Controparte Anomalo (Non presente in archivio soggetti)";
        } // End If
        /* mcErrori.SaveRow() */
        mcErrori.SaveRow();
      } // End If
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
  String AbiCab(String _abi,String _cab) throws Exception {
    /* _abi Char(6) */
    /* _cab Char(6) */
    /* _abitrim Char(5) */
    /* _cabtrim Char(5) */
    /* cReturn Char(13) */
    /* _abitrim := iif(Len(LRTrim(_abi)) > 5,Substr(LRTrim(_abi),2,5),LRTrim(_abi)) */
    _abitrim = (CPLib.gt(CPLib.Len(CPLib.LRTrim(_abi)),5)?CPLib.Substr(CPLib.LRTrim(_abi),2,5):CPLib.LRTrim(_abi));
    /* _cabtrim := iif(Len(LRTrim(_cab)) > 5,Substr(LRTrim(_cab),2,5),LRTrim(_cab)) */
    _cabtrim = (CPLib.gt(CPLib.Len(CPLib.LRTrim(_cab)),5)?CPLib.Substr(CPLib.LRTrim(_cab),2,5):CPLib.LRTrim(_cab));
    /* _abitrim := Right('00000'+LRTrim(_abitrim),5) */
    _abitrim = CPLib.Right("00000"+CPLib.LRTrim(_abitrim),5);
    /* _cabtrim := Right('00000'+LRTrim(_cabtrim),5) */
    _cabtrim = CPLib.Right("00000"+CPLib.LRTrim(_cabtrim),5);
    /* cReturn := _abitrim+"00"+_cabtrim */
    cReturn = _abitrim+"00"+_cabtrim;
    /* Page Return cReturn */
    return cReturn;
  }
  void FileZip() throws Exception {
    // Qui vengono scritti i file da inserire nello zip
        String[] filenames = new String[]{cNomeFile};
        
        // Crea un buffer per la lettura dei file
        byte[] buf = new byte[1024];
        
        try {
            // Creail file ZIP
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Comprime i file
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Apre il file da aggiungere allo ZIP
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Trasferisce i dati da i file allo ZIP
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Chiude il file
                out.closeEntry();
                in.close();
            }
        
            // Chiude il file ZIP
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void OpenFile() throws Exception {
    /* _nomefile := "COMOGG_"+Str(pAnno,4,0)+pMese+iif(nTotale=0,"_NEG","_POS")+".xml" */
    _nomefile = "COMOGG_"+CPLib.Str(pAnno,4,0)+pMese+(CPLib.eqr(nTotale,0)?"_NEG":"_POS")+".xml";
    /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
    /* Exec "Testa" Page 2:Testa */
    Testa();
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,String p_pMese,double p_pLimite,String p_pI3I4) {
    pAnno = p_pAnno;
    pMese = p_pMese;
    pLimite = p_pLimite;
    pI3I4 = p_pI3I4;
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
  public String Run(double p_pAnno,String p_pMese,double p_pLimite,String p_pI3I4) {
    pAnno = p_pAnno;
    pMese = p_pMese;
    pLimite = p_pLimite;
    pI3I4 = p_pI3I4;
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
  public static arfn_com_oggettiveR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_com_oggettiveR(p_Ctx, p_Caller);
  }
  public static arfn_com_oggettiveR Make(CPContext p_Ctx) {
    return new arfn_com_oggettiveR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pMese = CPLib.Space(2);
    pLimite = 0;
    pI3I4 = CPLib.Space(1);
    cRitorno = CPLib.Space(50);
    nTotale = 0;
    fhand = CPLib.Space(10);
    _datini = CPLib.NullDate();
    _datfin = CPLib.NullDate();
    _limcon = 0;
    _nomefile = CPLib.Space(30);
    _testo = "";
    _bpentseg = CPLib.Space(30);
    _bpcodpat = CPLib.Space(12);
    _abiinter = CPLib.Space(6);
    _cdatfin = CPLib.Space(8);
    _contaope = 0;
    _id_operazione = 0;
    _contasogg = 0;
    _operazioni = "";
    _soggetti = "";
    _prgsogg = 0;
    mcOperazioni = new MemoryCursor_mcoperazionico_mcrdef();
    mcSoggetti = new MemoryCursor_mcsoggettico_mcrdef();
    mcErrori = new MemoryCursor_mcrowserrori_mcrdef();
    mcCFOperazione = new MemoryCursor_mcconnes_mcrdef();
    _tiposogg = CPLib.Space(2);
    _connes = CPLib.Space(16);
    _codsta = CPLib.Space(3);
    _cabnas = CPLib.Space(6);
    _sesso = CPLib.Space(1);
    _abicab = CPLib.Space(13);
    _found = 0;
    _tipo = CPLib.Space(1);
    _numprog = CPLib.Space(11);
    _totlire = CPLib.Space(15);
    _totcont = CPLib.Space(15);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    _outfile = CPLib.Space(100);
    _cfexist = 0;
    _titexec = 0;
    _abitrim = CPLib.Space(5);
    _cabtrim = CPLib.Space(5);
    cReturn = CPLib.Space(13);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_co_totalerec,qbe_co_operazbo,qbe_co_validi,qbe_co_validi_totale,qbe_co_operazioni_valide,qbe_co_titolari,qbe_co_titolari,qbe_co_titolari,qbe_co_titolari,qbe_co_titolari,
  public static final String m_cVQRList = ",qbe_co_totalerec,qbe_co_operazbo,qbe_co_validi,qbe_co_validi_totale,qbe_co_operazioni_valide,qbe_co_titolari,qbe_co_titolari,qbe_co_titolari,qbe_co_titolari,qbe_co_titolari,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_com_oggettive,arfn_fdatetime,arfn_fdatetime_bp,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_com_oggettive,arfn_fdatetime,arfn_fdatetime_bp,arfn_finemese,";
  public static String[] m_cRunParameterNames={"pAnno","pMese","pLimite","pI3I4"};
  protected static String GetFieldsName_00000050(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_appo_co1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000052(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_appo_co1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000056(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_appo_co1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000059(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_appo_co1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_appo_co1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_appo_co1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTEST,";
    p_cSql = p_cSql+"TXTERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esitosaldi",true);
    return p_cSql;
  }
}
